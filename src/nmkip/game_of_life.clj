(ns nmkip.game-of-life
  (:gen-class)
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn- neighbors [[x y]]
  (->
   (for [x (range (dec x) (+ 2 x))
         y (range (dec y) (+ 2 y))]
     [x y])
   set
   (disj [x y])))

(defn- neighbors-count [world cell]
  (-> world
      (set/intersection (neighbors cell))
      count))

(defn- all-the-neighbors [world]
  (set (mapcat neighbors world)))

(defn- alive? [world cell]
  (let [num-of-neighbors (neighbors-count world cell)]
    (or (= num-of-neighbors 3)
        (and (= num-of-neighbors 2)
             (contains? world cell)))))

(defn next-state [world]
  (->> world
       all-the-neighbors
       (filter #(alive? world %))
       set))

(defn parse [s]
  (->> s
       str/split-lines
       (map-indexed (fn [y l]
                      (->> l
                           str/trim
                           (map-indexed (fn [x c]
                                          (when (= c \O)
                                            [x y]))))))
       (apply concat)
       (remove nil?)
       set))

(comment

;; [-1 1]  [0 1]  [1 1]
;; [-1 0]  [0 0]  [1 0]
;; [-1 -1] [0 -1] [1 -1]

  (next-state #{})
  (next-state #{[0 0]})
  (next-state #{[0 0] [1 0]})
  (next-state #{[0 0] [1 0] [0 1]})

  (def w #{[0 0] [0 1] [0 -1] [1 0]})
  (take 5 (iterate next-state w))

  (parse ".O 
          ..O
          OOO")
  (str/split "a \nb" #"\n")
  )
