# scalacats
Exercises to Scala Book "Scala with Cats"

Quotes / Summery from the book 

**Good to know:**

• **import cats._**  imports all of Cats’ type classes in one go;

• **import cats.instances.all._** imports all of the type class instances for the standard library in one go;

• **import cats.syntax.all._** imports all of the syntax in one go;

• **import cats.implicits._** imports all of the standard type class instances and all of the syntax in one go.


File should contain following imports.
More specific imports are only necessary by naming conflicts or problems with ambiguous implicits:

**import cats._**
**import cats.implicits._**

General patterns in Cats type classes:

• The type classes themselves are generic traits in the cats package.

• Each type class has a companion object with, an apply method for ma-
terializing instances, one or more construc on methods for crea ng in-
stances, and a collec on of other relevant helper methods.

• Default instances are provided via objects in the cats.instances
package, and are organized by parameter type rather than by type class.

• Many type classes have syntax provided via the cats.syntax package.




**Covariant** + Symbol

trait F[+A]
F[B] is a subtype of F[A]

sealed trait Shape
case class Circle(radius: Double) extends Shape

cicle can be used anywhere, where Shape is expected, 
because Circle is a subtype fo Shape

More specific type preferred

**Contravariant** - Symbol

traif F[-A]
F[B] is a subtype of F[A] if A is subtype of B  
 
trait JsonWriter[-A] {
 def write(value: A): Json
}

val shape: Shape = ???
val circle: Circle = ???

val shapeWriter: JsonWriter[Shape] = ???
val circleWriter: JsonWriter[Circle] = ???

def format[A](value: A, writer: JsonWriter[A]): Json =
writer.write(value)

Json-Writer[Shape] is a subtype of JsonWriter[Circle] because Circle is a
subtype of Shape . This means we can use shapeWriter anywhere we expect
to see a JsonWriter[Circle]
We can't combine shap with circleWriter, because not all Shapes are Circles

Supertype instance used

**Invariance** no Symbol

trait F[A]

F[A] and F[B] are never subtypes of another. 
Relationship between A and B is not important.
Default semantic for Scala type constructors.

When compiler searches for an implicit it looks for one matching type or subtype.

Cats generally prefers invariant type classes.
For a value of Some[Int], a type class instance for Option will not be used.

Solution:

a) type annotation: Some(1) : Option[Int]

b) use smart constructors Option.apply, Option.empty, some and none methods 

