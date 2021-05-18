(ns cartao.app.account
  (:use [clojure pprint])
  (:require [cartao.ports.secondary.repositories.account :as c.r.account]))

(defn get-account [conn]
  (let [account (c.r.account/get-account conn)]
    (->> account
         :account/name
        (println  "Nome:"))
    (->> account
         :account/email
         (println "Email:"))
    (->> account
         :account/cpf
         (println "CPF:"))))