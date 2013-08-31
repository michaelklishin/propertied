(ns clojurewerkz.propertied.properties-test
    (:require [clojure.test :refer :all]
              [clojurewerkz.propertied.properties :as prop]))


(deftest test-properties-from-map
  (let [m {"key1" "value1"
           "key2" "2"}
        p (prop/map->properties m)]
    (are [k v] (is (= v (.getProperty p k)))
         "key1" "value1"
         "key2" "2")))

(deftest test-properties-to-map
  (let [m  {"key1" "value1"
            "key2" "2"}
        p  (prop/map->properties m)
        m' (prop/properties->map p)]
    (is (= m m'))))

(deftest test-load-from
  (let [m {"key1" "value1"
           "key2" "2"}
        p (prop/load-from m)]
    (are [k v] (is (= v (.getProperty p k)))
         "key1" "value1"
         "key2" "2")))
