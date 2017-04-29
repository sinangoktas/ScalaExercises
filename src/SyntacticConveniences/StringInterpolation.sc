def greet(name: String) : String =
  s"Hello, $name!"

greet("Scala")
greet("Functional Programming")

def greet2(name: String) : String =
  s"Hello, ${name.toUpperCase()}!"

greet2("Scala")


