(ns cartao.cc.logic)


(defn details-creditcard [creditcard]
  (->> creditcard :number (println "Número"))
  (->> creditcard :duedate (println "Validade"))
  (->> creditcard :ccv (println "Código de segurança"))
  (->> creditcard :limit (println "Limite R$"))
      )