(ns cartao.ports.primary.cli
  (:require [cartao.app.account :as c.account]
            [cartao.app.creditcard :as c.creditcard]
            [cartao.app.purchase :as c.purchase]))


(defn main [conn]
  (println "1 - Dados do cliente")
  (println "2 - Dados do cartão")
  (println "3 - Compras realizadas")
  (println "4 - Total por categoria")
  (let [input (read-line)]
    (when (= input "1")
      (c.account/get-account conn))
    (when (= input "2")
      (c.creditcard/get-creditcard conn))
    (when (= input "3")
      (c.purchase/get-purchases conn))
    (when (= input "4")
      (c.purchase/amount-by-category conn))))