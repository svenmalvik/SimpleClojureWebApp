(ns simpleClojureWebApp.core
  (:gen-class :main true)
  (:use compojure.core
        ring.middleware.params
        ring.adapter.jetty)
  (:require [compojure.route :as route]
            [simpleClojureWebApp.view :as view]
            [clojure.data.json :as json]))

(defroutes my_routes
  (GET "/" [] (view/index-page))
  (GET "/rest" [] (json/json-str {:email "sven@malvik.de"}))
  (route/resources "/"))

(def app (wrap-params my_routes))

(defn -main [& args] (run-jetty app {:port 9001}))