(ns cartao.db
  (:require [datomic.api :as d]))

(def database-uri "datomic:dev://localhost:4334/cartao")

(def schema [{:db/ident       :account/name
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Client name"
              }
             {:db/ident       :account/email
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Client email"
              }
             {:db/ident       :account/cpf
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Client CPF"
              }
             {:db/ident       :creditcard/number
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Creditcard number"
              }
             {:db/ident       :creditcard/cvv
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Creditcard cvv"
              }
             {:db/ident       :creditcard/duedade
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Creditcard duedate"
              }
             {:db/ident       :creditcard/limit
              :db/valueType   :db.type/long
              :db/cardinality :db.cardinality/one
              :db/doc         "Creditcard limit"
              }

             {:db/ident       :purchase/date
              :db/valueType   :db.type/instant
              :db/cardinality :db.cardinality/many
              :db/doc         "Purchase date"
              }
             {:db/ident       :purchase/establishment
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/many
              :db/doc         "Purchase establishment"
              }
             {:db/ident       :purchase/category
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/many
              :db/doc         "Purchase category"
              }
             {
              :db/ident       :purchase/category-id
              :db/valueType   :db.type/keyword
              :db/cardinality :db.cardinality/many
              :db/doc         "Category ID"
              }
             {:db/ident       :purchase/amount
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/many
              :db/doc         "Purchase amount"
              }
             ]
  )


(defn create-database []
  (d/create-database database-uri))

(defn connect []
  (d/connect database-uri))

(defn create-database-and-connect []
  (create-database)
  (connect))

(defn create-schema [conn]
  (d/transact conn schema))

(defn delete-database []
  (d/delete-database database-uri))

(defn get-snapshot [conn]
  (d/db conn))
