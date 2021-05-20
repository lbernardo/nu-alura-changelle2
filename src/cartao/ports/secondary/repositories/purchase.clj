(ns cartao.ports.secondary.repositories.purchase
  (:require [datomic.api :as d]
            [cartao.db :as c.db]))

(defn add-purchase! [conn purchase]
  (d/transact conn purchase))

(defn get-purchases [conn]
  (let [db (c.db/get-snapshot conn)]
    (d/q '[:find (pull ?e [:purchase/date
                           :purchase/category
                           :purchase/establishment
                           :purchase/amount
                           :purchase/category-id])
           :where [?e :purchase/date]] db)))