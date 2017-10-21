(ns tris.core
  (:gen-class)
  (:require tris.action))

;; TODO use config file
(defn get_params
  "build params from args"
  [{width :width
    height :height
    point_range :point_range
    }]
  {:width width
   :height height
   :point_range point_range})

(defn run
  "run things"
  [params]
  (tris.action/prepare_and_run params))

(defn -main
  "get args and run things"
  [& args]
  (let [params (get_params args)]
    (run params)))

