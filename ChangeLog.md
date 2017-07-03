## Changes Between 1.2.0 and 1.3.0

### Unicode Encoding for Files

ISO 8859-1 is no longer the implicitly used encoding when loading
properties files.

Contributed by aisamu.

### Clojure 1.6 By Default

The project now depends on `org.clojure/clojure` version `1.8.0`. It is
still compatible with Clojure 1.6 and if your `project.clj` depends on
a different version, it will be used, but 1.8 is the default now.

We encourage all users to upgrade to 1.8, it is a drop-in replacement
for the majority of projects out there.

Contributed by ZarifJS.


## Changes Between 1.1.0 and 1.2.0

### Keywords Support

`properties/map->properties` now supports keywords keys. `properties/properties->map` got a new
arity that converts keys to keywords:

``` clojure
(require '[clojurewerkz.propertied.properties :as p])

;; converts keys to keywords
(p/properties->map props true)
```

### Clojure 1.6 By Default

The project now depends on `org.clojure/clojure` version `1.6.0`. It is
still compatible with Clojure 1.4 and if your `project.clj` depends on
a different version, it will be used, but 1.6 is the default now.

We encourage all users to upgrade to 1.6, it is a drop-in replacement
for the majority of projects out there.

## Changes Between 1.0.0 and 1.1.0

### File Descriptor Leak Fixed

Propertied now correctly releases file descriptors it uses.

Contributed by Alexander Lolis.


## 1.0.0

Initial release.
