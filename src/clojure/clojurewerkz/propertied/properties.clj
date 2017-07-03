;; Copyright (c) 2013-2014 The ClojureWerkz team and contributors.
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

(ns clojurewerkz.propertied.properties
  (:require [clojure.java.io :as io])
  (:import [java.util Properties Map ArrayList]
           java.io.File))

;;
;; Implementation
;;

(defn ^:private enumerator-into
  "Produces an immutable collection from java.util.Hashtable$Enumerator"
  [^java.util.Hashtable$Enumerator e]
  (let [al (ArrayList.)]
    (while (.hasMoreElements e)
      (.add al (.nextElement e)))
    (vec al)))

;;
;; API
;;

(defn properties->map
  ([^Properties p]
   (properties->map p false))
  ([^Properties p keywordize?]
   (let [names (.propertyNames p)]
     (reduce (fn [m k]
               (assoc m (if keywordize?
                          (keyword k)
                          k) (.getProperty p k)))
             {}
             (enumerator-into names)))))

(defn ^Properties map->properties
  [^Map m]
  (let [p (Properties.)]
    (doseq [[k ^String v] m]
      (.setProperty p (name k) v))
    p))

(defprotocol PropertyReader
  "Extensions of this protocol can be used to load properties"
  (load-from [input] "Instantiates a property list from the input"))

(extend-protocol PropertyReader
  java.util.Map
  (load-from [input]
    (map->properties input))

  java.io.File
  (load-from [input]
    (with-open [rdr (io/reader input)]
      (doto (Properties.)
        (.load rdr))))

  java.net.URL
  (load-from [input]
    (with-open [is (io/input-stream input)]
      (doto (Properties.)
        (.load (io/input-stream input))))))

(defprotocol PropertyWriter
  "Writes a property list to file"
  (store-to [input sink] "Writes property list to file"))

(extend-protocol PropertyWriter
  java.util.Map
  (store-to [input sink]
    (with-open [w (io/writer sink)]
      (let [p (map->properties input)]
        (.store p w nil))))

  java.util.Properties
  (store-to [input sink]
    (with-open [w (io/writer sink)]
      (.store input w nil))))
