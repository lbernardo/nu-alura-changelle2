(ns cartao.ports.secondary.repositories.creditcard
  (:require [datomic.api :as d]
            [cartao.db :as c.db]))


(defn create-creditcard! [conn creditcard]
  (d/transact conn [creditcard]))

(defn get-creditcard [conn]
  (first
    (first
      (d/q '[:find (pull ?e [:creditcard/number :creditcard/cvv :creditcard/duedade :creditcard/limit])
             :where [?e :creditcard/number]
             ] (c.db/get-snapshot conn)))))