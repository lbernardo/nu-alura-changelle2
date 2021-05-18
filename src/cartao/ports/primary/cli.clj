(ns cartao.ports.primary.cli
  (:require [cartao.app.account :as c.account]
            [cartao.app.creditcard :as c.creditcard]))


(defn main [conn]
  (println "1 - Dados do cliente")
  (println "2 - Dados do cartão")
  ;(let [input (read-line)]
  (let [input "2"]
    (when (= input "1")
      (c.account/get-account conn))
    (when (= input "2")
      (c.creditcard/get-creditcard conn))))