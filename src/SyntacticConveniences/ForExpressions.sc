val xs: List[Int] = List(1,2,3,4,5,6,7,8,9)

// Instead of
xs.map(x => x + 1)
// You can write
for (x <- xs) yield x + 1

// Instead of
xs.filter(x => x % 2 == 0)
// You can write
for (x <- xs if x % 2 == 0) yield x

// You can see the benefit in combination of above two

// Instead of
xs.filter(x => x % 2 == 0 ).map(x => x + 1)

// You can write
for(x <- xs if x % 2 == 0) yield x + 1

// Instead of
val ys: List[Int] = List(9,8,7,6,5,4,3,2,1)

xs.flatMap(x  => ys.map(y => (x, y)))

// You can write
for(x <- xs; y <- ys) yield (x, y)

// Example

for {
  x <- xs if x % 2 == 0
  y <- ys
} yield (x, y)

// de-sugared version of the above code
xs.filter { x =>
  x % 2 == 0
}.flatMap { x =>
  ys.map { y =>
    (x, y)
  }
}



