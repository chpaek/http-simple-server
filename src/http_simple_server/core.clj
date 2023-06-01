(ns http-simple-server.core
   (:use ring.adapter.jetty
        [ring.middleware.content-type]
        [ring.middleware.cookies]
        [ring.middleware.params]
        [ring.middleware.session]
        [ring.middleware.session.cookie]
        [ring.util.response]))
(require '[ring.adapter.jetty :refer [run-jetty]])
;; (defn foo
;;   "I don't do a whole lot."
;;   [x]
;;   (println x "Hello, World!"))


(defn handler [request]
  { :status 200
   :headers {"Content-Type" "text/html"}
   :body "hello world!1"
  }
  )

(defn -main
  []  
  (run-jetty handler {:port 3001}))

