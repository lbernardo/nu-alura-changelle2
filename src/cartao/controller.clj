(ns cartao.controller
  (:require [cartao.app.model :as c.model]
            [cartao.ports.secondary.repositories.account :as c.r.account]
            [cartao.ports.secondary.repositories.creditcard :as c.r.creditcard]))

(defn create-account-default []
  (c.model/create-model-account "Emilly Antônia" "emillyantonia@getnada1.com" "845.243.048-51"))

(defn create-creditcard-default []
  (c.model/create-model-creditcard "5274 6223 1271 9635" "620" "01/23" 3000))

(defn config [conn]
  (c.r.account/create-account! conn (create-account-default))
  (c.r.creditcard/create-creditcard! conn (create-creditcard-default)))
