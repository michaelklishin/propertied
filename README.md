# What is Propertied

Propertied is a tiny Clojure library that deals with Java property
lists.


## Community

To subscribe for announcements of releases, important changes and so on, please follow [@ClojureWerkz](https://twitter.com/#!/clojurewerkz) on Twitter.


## Project Maturity

Propertied is *very* young and under active development.



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

    [clojurewerkz/propertied "1.0.0-alpha1"]


With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>propertied</artifactId>
      <version>1.0.0-alpha1</version>
    </dependency>



## Getting Started

Please refer to our [Getting Started guide](...). Don't hesitate to join our [mailing list](https://groups.google.com/forum/#!forum/clojure-...) and ask questions, too!


## Documentation & Examples

Propertied makes it easy to convert property lists (`java.util.Properties`) into Clojure
maps and vice versa. Thus working with property lists is generally as straightforward as
working with maps.

`clojurewerkz.propertied.properties/load-from` is a polymorphic function that
instantiates a property list from an input (e.g. a map).

`clojurewerkz.propertied.properties/properties->map`

``` clojure
(require [clojurewerkz.propertied.properties :as p])

(p/load-from {"a key" "a value"})
;= {"a key" "a value"}
(class (p/load-from {"a key" "a value"}))
;= java.util.Properties
(let [pl (p/load-from {"a key" "a value"})]
  (p/properties->map pl))
;= {"a key" "a value"}
```



## Supported Clojure Versions

Propertied is built from the ground up for Clojure 1.5.1 and up.


## Continuous Integration Status

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/propertied.png)](http://travis-ci.org/clojurewerkz/propertied)



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

    lein2 all test

Then create a branch and make your changes on it. Once you are done
with your changes and all tests pass, submit a pull request on GitHub.



## License

Copyright (C) 2013 Michael S. Klishin, Alex Petrov.

Double licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure) or
the [Apache Public License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
