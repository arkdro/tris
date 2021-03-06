(ns tris.plate)

(defn points_equal?
  "Check if two points are equal"
  [p1 p2]
  (= p1 p2))

(defn get_point_in_data
  "Get a point of a raw data at the specified place"
  [x y width height data]
  (get-in data [y x]))

(defn set_point_in_data
  "Set a point of a plate"
  [x y point data]
  (assoc-in data [y x] point))

(defn get_point
  "Get a point of a plate at the specified place"
  [x y
   {width :width
    height :height
    data :data}]
  (get_point_in_data x y width height data))

(defn build_one_point
  "Build one point"
  [point_range]
  (rand-int point_range))

(defn build_one_line
  "Build one line"
  [width point_range]
  (vec (repeatedly width #(build_one_point point_range))))

(defn make_different_starts
  "Make sure that two starting points are different"
  [point_range width height data]
  (let [cur1 (get_point_in_data 0 0 width height data)
        cur2 (get_point_in_data (dec width) (dec height) width height data)]
    (if (points_equal? cur1 cur2)
      (let [new_point (mod (inc cur1) point_range)] ; might give some edge to one side
        (set_point_in_data 0 0 new_point data)))))

(defn build_plate
  "Build a plate filled with grains"
  [{width :width
    height :height
    point_range :point_range}]
  (let [data (doall (vec (repeatedly height #(build_one_line width point_range))))
        data2 (make_different_starts point_range width height data)
        cur1 (get_point_in_data 0 0 width height data)
        cur2 (get_point_in_data (dec width) (dec height) width height data)]
    {:width width
     :height height
     :point_range point_range
     :total_size (* width height)
     :size1 1
     :size2 1
     :cur1 cur1
     :cur2 cur2
     :data data}))

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

