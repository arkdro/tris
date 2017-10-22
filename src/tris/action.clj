(ns tris.action
  (:require tris.source)
  (:require tris.plate))

(defn run
  "action!"
  [plate src1 src2 params]
  )

(defn prepare_and_run
  "prepare plate and sources, and run the whole action"
  [params]
  (let [
        plate (tris.plate/build_plate params)
        src1 (tris.source/get_source params)
        src2 (tris.source/get_source params)
        ]
    (run plate src1 src2 params)))
