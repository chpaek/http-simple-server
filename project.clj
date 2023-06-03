(defproject http-simple-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/clojure "1.12.0-alpha1"]
                 [ring/ring-core "1.10.0"]
                 [ring/ring-jetty-adapter "1.10.0"]
                 [compojure "1.7.0"]
                 [org.clojure/data.csv "1.0.1"]
                 [org.clojure/data.json "2.4.0"]
                 [metosin/ring-swagger "0.26.2"]
                 ]
  ;;:repl-options {:init-ns http-simple-server.core}
  :main http-simple-server.core )
