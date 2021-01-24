(ns nmkip.game-of-life-ui
  (:require [nmkip.game-of-life :as gol]
            [quil.core :as q]
            [quil.middleware :as m]))

(def scale 10)
(def size [1000 1000])
(def offset (/ (first size) 2))
(def pattern
  "..OO
   .O.O
   O..O.OO
   OO.O..O
   .O.O
   .O..O
   ..OO")

(defn cell->point [[x y]]
  [(+ offset (* scale x)) (+ offset (* scale y)) scale scale])

(defn setup []
  (q/frame-rate 1)     
  (q/background 200)
  (gol/parse pattern))                 
                                      
(defn quil-update [cells]
  (gol/next-state cells))

(defn draw [cells]
  (q/background 255)
  (q/fill 0 0 0)

  (doseq [cell cells]
    (->> cell
        cell->point
        (apply q/rect))) 
)

(q/defsketch game-of-life
  :title "Game of life"
  :settings #(q/smooth 2)
  :setup setup
  :draw draw
  :update quil-update
  :size size
  :middleware [m/fun-mode])

(defn -main [& args])
