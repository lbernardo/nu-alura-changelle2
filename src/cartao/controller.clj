(ns cartao.controller
  (:require [cartao.app.model :as c.model]
            [cartao.ports.secondary.repositories.account :as c.r.account]
            [cartao.ports.secondary.repositories.creditcard :as c.r.creditcard]
            [cartao.ports.secondary.repositories.purchase :as c.r.purchase])
  (:import (java.util Calendar)))


(defn create-account-default []
  (c.model/create-model-account "Emilly Antônia" "emillyantonia@getnada1.com" "845.243.048-51"))

(defn create-creditcard-default []
  (c.model/create-model-creditcard "5274 6223 1271 9635" "620" "01/23" 3000))

(defn create-purchases-default []
  [(c.model/create-model-purchase (.getTime (java.util.GregorianCalendar. 2021 Calendar/JANUARY 1)) "BK" "Food" :food 40M)
   (c.model/create-model-purchase (.getTime (java.util.GregorianCalendar. 2021 Calendar/JANUARY 2)) "MD" "Food" :food 200M)
   (c.model/create-model-purchase (.getTime (java.util.GregorianCalendar. 2021 Calendar/JANUARY 2)) "BIG" "Merchant" :merchant 800M)
   (c.model/create-model-purchase (.getTime (java.util.GregorianCalendar. 2021 Calendar/FEBRUARY 3)) "FRAG" "Merchant" :merchant 50M)
   (c.model/create-model-purchase (.getTime (java.util.GregorianCalendar. 2021 Calendar/FEBRUARY 3)) "Iguatemi" "Mall" :mall 823M)
   (c.model/create-model-purchase (.getTime (java.util.GregorianCalendar. 2021 Calendar/MARCH 3)) "Iguatemi" "Mall" :mall 2500M)
   ])

(defn config [conn]
  (c.r.account/create-account! conn (create-account-default))
  (c.r.creditcard/create-creditcard! conn (create-creditcard-default))
  (c.r.purchase/add-purchase! conn (create-purchases-default)))
