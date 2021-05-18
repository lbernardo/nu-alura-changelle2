(ns cartao.app.creditcard
  (:require [cartao.ports.secondary.repositories.creditcard :as c.r.creditcard]))

(defn get-creditcard [conn]
  (let [creditcard (c.r.creditcard/get-creditcard conn)]
    (->> creditcard
         :creditcard/number
         (println "Número:"))
    (->> creditcard
         :creditcard/duedade
         (println "Validade:"))
    (->> creditcard
         :creditcard/cvv
         (println "CVV:"))
    (->> creditcard
         :creditcard/limit
         (println "Limite: R$"))))