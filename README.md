# game-of-life

- A living cell with less than two neighbors: dies!
- A living cell with two or three neighbors: survives!
- A living cell with more than three neighbors: dies!
- A dead cell with exactly three neighbors: becomes alive!

## Installation

Download from https://github.com/nmkip/game-of-life

## Usage

Run the project directly, via `:exec-fn`:

    $ clojure -X:run-x

Run the project directly, via `:main-opts` (`-m nmkip.game-of-life`):

    $ clojure -M:run-m
    Hello, World!

Run the project's tests (they'll fail until you edit them):

    $ clojure -M:test:runner

Build an uberjar:

    $ clojure -X:uberjar

Run that uberjar:

    $ java -jar game-of-life.jar

## License

Copyright © 2021 Nmkip-pc

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
