;; Copyright (c) 2013 The ClojureWerkz team and contributors.
;;
;; Licensed under the Apache License, Version 2.0 (the "License");
;; you may not use this file except in compliance with the License.
;; You may obtain a copy of the License at
;;
;;       http://www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.

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
