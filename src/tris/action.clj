(ns tris.action
  (:require tris.source)
  (:require tris.plate))

(defn show_results
  ""
  [plate params]
  (println plate))

(defn calc_limit
  "Calculate the bigger half"
  [n]
  (if (even? n)
    (inc (/ n 2))
    (/ (inc n) 2)))

(defn definitely_done?
  "Check if the plate is consumed"
  [plate]
  )

(defn run
  "action!"
  [plate src1 src2 params]
  (if (definitely_done? plate)
    (show_results plate params)
    (let [
          new_plate (tris.plate/update_plate plate src1)
          ]
      ;; flip the sources for the next step
      (recur new_plate src2 src1 params))))

(defn prepare_and_run
  "prepare plate and sources, and run the whole action"
  [params]
  (let [
        plate (tris.plate/build_plate params)
        src1 (tris.source/get_source params)
        src2 (tris.source/get_source params)
        ]
    (run plate src1 src2 params)))

