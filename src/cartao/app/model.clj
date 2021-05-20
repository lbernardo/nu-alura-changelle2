(ns cartao.app.model)

(defn create-model-account [name email cpf]
  {:account/name name
   :account/email email
   :account/cpf cpf
 })

(defn create-model-creditcard [number cvv duedade limit]
  {:creditcard/number number
   :creditcard/duedade duedade
   :creditcard/cvv cvv
   :creditcard/limit limit})

(defn create-model-purchase [date establishment category category-id amount]
  {
   :purchase/date date
   :purchase/establishment establishment
   :purchase/category category
   :purchase/category-id category-id
   :purchase/amount amount
   })