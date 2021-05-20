(ns cartao.controller
  (:require [cartao.app.model :as c.model]
            [cartao.ports.secondary.repositories.account :as c.r.account]
            [cartao.ports.secondary.repositories.creditcard :as c.r.creditcard]
            [cartao.ports.secondary.repositories.purchase :as c.r.purchase]
            [cartao.components :as c.components])
  (:import (java.util Calendar)))


(defn create-account-default []
  (c.model/create-model-account "Emilly Antônia" "emillyantonia@getnada1.com" "845.243.048-51"))

(defn create-creditcard-default []
  (c.model/create-model-creditcard "5274 6223 1271 9635" "620" "01/23" 3000))

(defn create-purchases-default []
  [(c.model/create-model-purchase (c.components/date-by-calendar 1 1 2021) "BK" "Food" :food 40M)
   (c.model/create-model-purchase (c.components/date-by-calendar 2 1 2021) "MD" "Food" :food 200M)
   (c.model/create-model-purchase (c.components/date-by-calendar 2 1 2021) "BIG" "Merchant" :merchant 800M)
   (c.model/create-model-purchase (c.components/date-by-calendar 3 2 2021) "FRAG" "Merchant" :merchant 50M)
   (c.model/create-model-purchase (c.components/date-by-calendar 3 2 2021) "Iguatemi" "Mall" :mall 823M)
   (c.model/create-model-purchase (c.components/date-by-calendar 3 3 2021)  "Iguatemi" "Mall" :mall 2500M)
   ])

(defn config [conn]
  (c.r.account/create-account! conn (create-account-default))
  (c.r.creditcard/create-creditcard! conn (create-creditcard-default))
  (c.r.purchase/add-purchase! conn (create-purchases-default)))
