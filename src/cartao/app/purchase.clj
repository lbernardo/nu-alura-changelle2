(ns cartao.app.purchase
  (:require [cartao.ports.secondary.repositories.purchase :as c.r.purchase]
            [cartao.components :as c.components]))


(defn print-purchase [purchase-conj]
  (let [purchase (first purchase-conj)]
    (println (c.components/format-date! (-> purchase :purchase/date first))
             (-> purchase :purchase/category first)
             (-> purchase :purchase/establishment first)
             (-> purchase :purchase/amount first))))

(defn get-purchases [conn]
  (let [purchases (c.r.purchase/get-purchases conn)]
    (->> purchases
        (run! print-purchase))))


(defn get-amount-by-purchase [purchase]
  (-> purchase :purchase/amount first))

(defn by-category [category]
  (println (first (get (first (second category)) :purchase/category))
           "R$"
           (reduce + (map get-amount-by-purchase (second category)))))

(defn amount-by-category [conn]
  (let [purchases (c.r.purchase/get-purchases conn)]
    (->> (c.components/clear-data purchases [])
         (group-by :purchase/category-id)
         (map by-category))))
