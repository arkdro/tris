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

(defn update_plate
  "Update a place using a source of input"
  [plate source]
  plate)

(defn get_total_size
  "Return the total size of the plate"
  [plate]
  0)

(defn get_consumed_sizes
  "Return size of consumed parts of the plate"
  [plate]
  [(inc (get_total_size))
   (inc (get_total_size))])

