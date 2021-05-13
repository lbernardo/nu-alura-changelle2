(ns cartao.core
  (:require
    [cartao.helpers :as c.helpers]
    [cartao.db :as c.db]
    [cartao.client.logic :as c.client]
    [cartao.cc.logic :as c.cc]
    [cartao.purchases.logic :as c.purchases]
    ))

(defn main []
  (c.helpers/title "Informações do cliente")
  (->> c.db/cartao :client
       c.client/client-info)

  (c.helpers/title "Informações do cartão")
  (->> c.db/cartao :creditcard
       c.cc/details-creditcard))

  (c.helpers/title "Compras realizadas")
  (->> c.db/cartao :purshases
       c.purchases/purchases-list)

  (c.helpers/title "Valores por categoria")
  (->> c.db/cartao :purshases
       c.purchases/amount-by-category)

  (c.helpers/title "Total da fatura")
  (->> c.db/cartao :purshases
       c.purchases/amount-invoice)

(main)
