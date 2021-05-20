(ns cartao.components
  (:import (java.text SimpleDateFormat)))


(defn format-date! [date]
  (let [simple-date-format (SimpleDateFormat. "dd/MM/yyyy")]
    (.format simple-date-format date)))


(defn clear-data
  [elementos resto]
  (if (seq elementos)
    (recur (rest elementos) (conj resto (first (first elementos))))
    resto))