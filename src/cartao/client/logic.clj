(ns cartao.client.logic)

(defn client-info [client]
  (println "Nome:" (:name client))
  (println "CPF:" (:cpf client))
  (println "Email:" (:email client)))