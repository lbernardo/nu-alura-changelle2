(ns cartao.db)


(def cartao {
             :client     {
                          :name  "Gabriela Lima"
                          :cpf   "54946824049"
                          :email "gabriela.lima123@getnada.com"
                          }
             :creditcard {
                          :number  "5375 3367 8066 2486"
                          :duedate "11/2022"
                          :ccv     672
                          :limit   3000
                          }
             :purshases  [
                          {
                           :date          "2021-01-01"
                           :value         25.00
                           :establishment "Casa das coxinhas"
                           :category-id   :food
                           :category      "Food"
                           }
                          {
                           :date          "2021-01-01"
                           :value         120.00
                           :establishment "ABC Drugstore"
                           :category-id   :drugstore
                           :category      "Drugstore"
                           }
                          {
                           :date          "2021-01-01"
                           :value         25.00
                           :establishment "Casa das coxinhas"
                           :category-id   :food
                           :category      "Food"
                           }
                          {
                           :date          "2021-01-01"
                           :value         300.00
                           :establishment "Magalu"
                           :category-id   :mall
                           :category      "Mall"
                           }
                          {
                           :date          "2021-01-01"
                           :value         1236.90
                           :establishment "Ponto"
                           :category-id   :mall
                           :category      "Mall"
                           }
                          {
                           :date          "2021-01-01"
                           :value         15.0
                           :establishment "ABC Drugstore"
                           :category-id   :drugstore
                           :category      "Drugstore"
                           }
                          ]
             })