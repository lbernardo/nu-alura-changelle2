(ns cartao.purchases.logic)

(defn print-purchase [purchase]
  (println (get purchase :date) "R$" (get purchase :value ) (get purchase :category) (get purchase :establishment)))

(defn purchases-list [purchases]
  (run! print-purchase purchases))


(defn amount-by-purchase [purchase]
  (get purchase :value 0))

(defn total-by-category [[_ purchases]]
  (println (:category (get purchases 0))
           "R$" (reduce + (map amount-by-purchase purchases))))

(defn amount-by-category [purchases]
  (->> purchases
       (group-by :category-id)
       (run! total-by-category)))

(defn amount-invoice [purchases]
  (->> purchases
  (map amount-by-purchase)
  (reduce +)
  (println "R$")))