(ns cartao.ports.secondary.repositories.account
  (:require [datomic.api :as d]
            [cartao.db :as c.db]))

(defn create-account! [conn account]
  (d/transact conn [account]))


(defn get-account [conn]
  (first
    (first
      (d/q '[:find (pull ?e [:account/name :account/cpf :account/email])
             :where [?e :account/name]
             ] (c.db/get-snapshot conn)))))