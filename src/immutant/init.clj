(ns immutant.init
  "For immutant."
  (:require [falcor.web :as app]
            [ring.middleware.stacktrace :as st]
            [ring.middleware.session :as session]
            [immutant.web.session :as imm-session]
            [immutant.web :as web :only [start]]))

(web/start (-> #'app/app
               ;session/wrap-session {:store (imm-session/servlet-store) }
               ;st/wrap-stacktrace-web
               ))
