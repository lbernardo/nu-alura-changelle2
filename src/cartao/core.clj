(ns cartao.core
  (:require [cartao.db :as c.db]
            [cartao.ports.primary.cli :as c.cli]
            [cartao.controller :as c.controller]))

(c.db/delete-database)
(def conn (c.db/create-database-and-connect))               ; create database and connect
(c.db/create-schema conn)                                   ; create schema
(c.controller/config conn)                                  ; create account default
(c.cli/main conn)                                           ; start cli
