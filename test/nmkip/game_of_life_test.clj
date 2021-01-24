(ns nmkip.game-of-life-test
  (:require [clojure.test :refer :all]
            [nmkip.game-of-life :as gol]
            [clojure.set :refer [intersection]]))

;;A living cell with less than two neighbors: dies!
;;A living cell with two or three neighbors: survives!
;;A living cell with more than three neighbors: dies!
;;A dead cell with exactly three neighbors: becomes alive!

(deftest a-living-cell-with-less-than-two-neighbors-dies
  (are [world expected] (= (gol/next-state world) expected)
    #{} #{}
    #{[1 0]} #{}
    #{[1 0] [0 0]} #{}
    #{[1 0] [0 0] [5 0] [9 9]} #{}))

(deftest a-living-cell-with-two-or-three-neighbors-survives
  (are [world expected] (= (gol/next-state world) expected)
    #{[0 0] [0 1] [1 0]} #{[0 0] [0 1] [1 0] [1 1]}
    #{[0 0] [0 1] [1 0] [1 1]} #{[0 0] [0 1] [1 0] [1 1]}))

(deftest a-living-cell-with-more-than-three-neighbors-dies
  (is (false? (contains? (gol/next-state #{[0 0] [0 1] [1 0] [-1 0] [0 -1]})
                         [0 0]))))

(deftest a-dead-cell-with-exactly-three-neighbors-becomes-alive
  (is (contains? (gol/next-state #{[0 0] [0 1] [1 0]}) [1 1])))
