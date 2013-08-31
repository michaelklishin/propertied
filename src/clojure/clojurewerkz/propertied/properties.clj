(ns clojurewerkz.propertied.properties
  (:import [java.util Properties Map ArrayList]))

;;
;; Implementation
;;

(defn ^:private enumerator-into
  [^java.util.Hashtable$Enumerator e]
  (let [al (ArrayList.)]
    (while (.hasMoreElements e)
      (.add al (.nextElement e)))
    (into [] al)))


;;
;; API
;;

(defn properties->map
  [^Properties p]
  (let [names (.propertyNames p)]
    (reduce (fn [m k]
              (assoc m k (.getProperty p k)))
          {}
          (enumerator-into names))))

(defn ^Properties map->properties
  [^Map m]
  (let [p (Properties.)]
    (doseq [[^String k ^String v] m]
      (.setProperty p k v))
    p))

(defprotocol PropertySource
  "Extensions of this protocol can be used to load and store properties"
  (load-from [input] "Instantiates a property list from the input")
  (store-to  [output] "Stores a property list to the output"))

(extend-protocol PropertySource
  java.util.Map
  (load-from [input]
    (map->properties input)))
