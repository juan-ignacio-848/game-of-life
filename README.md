# game-of-life

A living cell with less than two neighbors: dies!
A living cell with two or three neighbors: survives!
A living cell with more than three neighbors: dies!
A dead cell with exactly three neighbors: becomes alive!

## Installation

Download from https://github.com/nmkip/game-of-life

## Usage

FIXME: explanation

Run the project directly, via `:exec-fn`:

    $ clojure -X:run-x
    Hello, Clojure!

Run the project, overriding the name to be greeted:

    $ clojure -X:run-x :name '"Someone"'
    Hello, Someone!

Run the project directly, via `:main-opts` (`-m nmkip.game-of-life`):

    $ clojure -M:run-m
    Hello, World!

Run the project, overriding the name to be greeted:

    $ clojure -M:run-m Via-Main
    Hello, Via-Main!

Run the project's tests (they'll fail until you edit them):

    $ clojure -M:test:runner

Build an uberjar:

    $ clojure -X:uberjar

Run that uberjar:

    $ java -jar game-of-life.jar

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2021 Nmkip-pc

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
