# What is Propertied

Propertied is a tiny Clojure library that deals with Java property
lists.


## Project Maturity

Propertied is not a young project and unlikely to radically change
(it is too small in scope).


## Artifacts

Propertied artifacts are [released to
Clojars](https://clojars.org/clojurewerkz/propertied). If you are
using Maven, add the following repository definition to your
`pom.xml`:

``` xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With Leiningen:

[![Clojars Project](http://clojars.org/clojurewerkz/propertied/latest-version.svg)](http://clojars.org/clojurewerkz/propertied)


With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>propertied</artifactId>
      <version>1.2.0</version>
    </dependency>



## Documentation & Examples

Propertied makes it easy to convert property lists
(`java.util.Properties`) into Clojure maps and vice versa. Thus
working with property lists is generally as straightforward as working
with maps.

`clojurewerkz.propertied.properties/load-from` is a polymorphic
function that instantiates a property list from an input (e.g. a map
or property file).

`clojurewerkz.propertied.properties/store-to` takes a map and stores
it into a `.properties` file (an output stream or anything else that
can be coerced to `java.io.Writer`).

`clojurewerkz.propertied.properties/properties->map` is a function
that converts a `java.util.Properties` to an immutable
map. `clojurewerkz.propertied.properties/map->properties` converts the
opposite way.

``` clojure
(require '[clojurewerkz.propertied.properties :as p])

(p/load-from {"a key" "a value"})
;= {"a key" "a value"}
(class (p/load-from {"a key" "a value"}))
;= java.util.Properties
(let [pl (p/load-from {"a key" "a value"})]
  (p/properties->map pl))
;= {"a key" "a value"}

;; converting keys to keywords
(let [pl (p/load-from {"key" "a value"})]
  (p/properties->map pl true))
;= {:key "a value"}

;; loading from files and InputStreams
(require '[clojure.java.io :as io])

(p/load-from (io/resource "resource/on/classpath.properties"))
(p/load-from (io/file "resource/on/classpath.properties"))

;; storing to property files (.properties)
(p/store-to {"name" "Michael" "age" "28"} "/tmp/michael.properties")
(p/store-to {"name" "Michael" "age" "28"} (io/file "/tmp/michael.properties"))
(p/store-to {"name" "Michael" "age" "28"} (java.io.File/createTempFile "michael" ".properties"))
```


## Community

To subscribe for announcements of releases, important changes and so
on, please follow [@ClojureWerkz](https://twitter.com/#!/clojurewerkz)
on Twitter.



## Supported Clojure Versions

Propertied requires Clojure 1.5.


## Continuous Integration Status

[![Continuous Integration
status](https://secure.travis-ci.org/michaelklishin/propertied.png)](http://travis-ci.org/michaelklishin/propertied)



## Propertied Is a ClojureWerkz Project

Propertied is part of the [group of Clojure libraries known as ClojureWerkz](http://clojurewerkz.org), together with

 * [Langohr](https://github.com/michaelklishin/langohr)
 * [Elastisch](https://github.com/clojurewerkz/elastisch)
 * [Cassaforte](http://clojurecassandra.info)
 * [Monger](http://clojuremongodb.info)
 * [Neocons](http://clojureneo4j.info)
 * [Quartzite](https://github.com/michaelklishin/quartzite)

and several others.


## Development

propertied uses [Leiningen
2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against supported
Clojure versions using

    lein all test

Then create a branch and make your changes on it. Once you are done
with your changes and all tests pass, submit a pull request on GitHub.



## License

Copyright (C) 2013-2016 Michael S. Klishin, Alex Petrov, and the ClojureWerkz team.

Double licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure) or
the [Apache Public License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
