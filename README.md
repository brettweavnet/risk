# Risk

Quick clojure program to simulate risk (the board game) attacks and defenses
and give a percentage of times an attacker will win with given numbers of
attacking and defending troops.

It assumes you will attack with maxium (3 and 2) and continue attacking until
one side has zero troops.

## Usage

The library gennerates the below table when you run (print-table).

```
  A |     1 |     2 |     3 |     4 |     5 |     6 |     7 |     8 |      9 |     10 |
 D  |-------+-------+-------+-------+-------+-------+-------+-------+--------+--------|
 1  | 41.62 | 75.68 | 91.58 | 97.22 | 98.96 | 99.57 | 99.90 | 99.97 | 100.00 | 100.00 |
 2  | 10.59 | 35.35 | 65.59 | 78.87 | 88.76 | 93.45 | 96.64 | 97.91 |  99.06 |  99.35 |
 3  |  2.61 | 20.80 | 47.75 | 63.41 | 77.10 | 85.25 | 91.12 | 94.50 |  96.50 |  97.81 |
 4  |  0.75 |  8.94 | 32.54 | 47.01 | 63.15 | 74.42 | 83.49 | 88.74 |  93.13 |  95.61 |
 5  |  0.13 |  4.95 | 20.52 | 36.56 | 50.00 | 64.20 | 73.38 | 81.96 |  87.05 |  92.16 |
 6  |  0.06 |  1.85 | 13.29 | 25.04 | 39.84 | 52.05 | 63.76 | 73.02 |  81.38 |  86.31 |
 7  |  0.01 |  1.25 |  8.46 | 17.80 | 29.08 | 42.12 | 54.80 | 64.39 |  73.16 |  80.07 |
 8  |  0.00 |  0.44 |  5.16 | 12.00 | 22.75 | 32.96 | 44.40 | 55.78 |  64.60 |  71.95 |
 9  |  0.00 |  0.33 |  3.21 |  8.78 | 16.77 | 26.13 | 35.33 | 45.61 |  55.94 |  65.16 |
 10 |  0.00 |  0.11 |  2.13 |  5.80 | 11.33 | 19.89 | 29.45 | 37.87 |  47.91 |  56.82 |
```

From the above table, you can see that if you attack with 3 troops against 4 troops
you will win %32.54 of the time (assumes you attack till one of you has 0).

## License

Copyright © 2015 Brett Weaver

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
