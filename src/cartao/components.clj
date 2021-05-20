(ns cartao.components
  (:import (java.text SimpleDateFormat))
  (:import (java.util GregorianCalendar)))


(defn format-date! [date]
  (let [simple-date-format (SimpleDateFormat. "dd/MM/yyyy")]
    (.format simple-date-format date)))


(defn date-by-calendar [day month year]
  (.getTime (GregorianCalendar. year (dec month) day)))


(defn clear-data
  [elementos resto]
  (if (seq elementos)
    (recur (rest elementos) (conj resto (first (first elementos))))
    resto))