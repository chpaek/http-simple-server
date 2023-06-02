(ns http-simple-server.core
  (:use ring.adapter.jetty
        [ring.middleware.content-type]
        [ring.middleware.cookies]
        [ring.middleware.params]
        [ring.middleware.session]
        [ring.middleware.session.cookie]
        [ring.util.response])

  ( :require [compojure.core :refer [GET]]
             [ring.adapter.jetty :refer [run-jetty]]
             [compojure.core :refer [defroutes]]
             [compojure.route :as route]
             [clojure.data.csv :as csv]
             [clojure.java.io :as io]
             [clojure.data.json :as json]
             [ring.swagger.swagger2 :as rs]
             [schema.core :as s]
             )
  )

(rs/swagger-json {})


(s/defschema User {:id s/Str,
                   :name s/Str
                   :address {:street s/Str
                             :city (s/enum :tre :hki)}})

(s/with-fn-validation
  (rs/swagger-json
    {:info {:version "1.0.0"
            :title "Sausages"
            :description "Sausage description"
            :termsOfService "http://helloreverb.com/terms/"
            :contact {:name "My API Team"
                      :email "foo@example.com"
                      :url "http://www.metosin.fi"}
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}}
     :tags [{:name "user"
             :description "User stuff"}]
     :paths {"/api/ping" {:get {}}
             "/user/:id" {:post {:summary "User Api"
                                 :description "User Api description"
                                 :tags ["user"]
                                 :parameters {:path {:id s/Str}
                                              :body User}
                                 :responses {200 {:schema User
                                                  :description "Found it!"}
                                             404 {:description "Ohnoes."}}}}}}))
(defn load-csv
  [path]
  println path
  (with-open [reader (io/reader path)]
    (doall
      (csv/read-csv reader))))

(defn remove_header
  [csv header]
  (filter #(not= header (first %)) csv))
(defn count_sum
  [csv]
  ;(json/write-str {:sum (count csv) })
  (json/write-str {:sum (count (remove_header csv "post_id" )) })
  )

;(defroutes routes
;    (GET "/" request
;       {:status 200
;            :headers {"Content-Type" "text/html"}
;            :body "hello world!"})
;    (GET "/sum" request {:status 200
;                    :headers {"Content-Type" "text/html"}
;                    :body "sum"})
;    (route/not-found "Not the route you are looking for"))

(defroutes routes
           (GET "/string" request "a simple string response")
           (GET "/" request
                {:status  200
                 :headers {"Content-Type" "application/json"}
                 :body      (json/write-str {:message "server check" })})
           (GET "/sum_absolute" request (load-csv "/home/chang/clojure/http-simple-server/posts_new.csv"))
           (GET "/sum" request
                {:status  200
                 :headers {"Content-Type" "application/json"}
                 :body    (count_sum (load-csv "posts_new.csv"))
                 })
           (GET "/swagger.json" request {:get (swagger-json)} )
           (GET "/api-docs/*" request {:get (swagger-ui/create-swagger-ui-handler)} )
           ;(route/not-found "Not found")
           )



(defn handler [request]

  { :status 200
   :headers {"Content-Type" "text/html"}
   :body "hello world!1"
  }
  )

(defn -main
  []  
  (run-jetty routes {:port 3001 :join? true}))


