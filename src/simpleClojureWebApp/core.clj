(ns simpleClojureWebApp.core
  (:gen-class :main true)
  (:use compojure.core
        ring.middleware.json
        ring.util.response
        ring.adapter.jetty)
  (:require [compojure.route :as route]
            [simpleClojureWebApp.view :as view]))

(defroutes my_routes
  (GET "/" [] (view/index-page))
  (GET "/rest" [] (response {:email "sven@malvik.de"}))
  (route/resources "/"))

(def app (wrap-json-response my_routes))

(defn -main [& args] (run-jetty app {:port 9001}))