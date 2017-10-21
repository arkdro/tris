(ns tris.plate)

(defn build_one_point
  "Build one point"
  [point_range]
  3)

(defn build_plate
  "Build a plate filled with grains"
  [{width :width
    height :height
    point_range :point_range}]
  (build_one_point point_range)
  [width height point_range])

