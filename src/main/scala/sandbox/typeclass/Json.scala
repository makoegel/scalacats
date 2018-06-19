package sandbox.typeclass

// Type class :Interface, that represents functionality for implementation
sealed trait Json
final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get:String) extends Json
final case class JsNumber(get:Double) extends Json
case object JsNull extends Json

// serialize to Json
// JsonWriter is type class
trait JsonWriter[A] {
  def write(value: A) : Json
}


// Interface Object
object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]):Json =
    w.write(value)
}

// Interface Syntax
object JsonSyntax {
  implicit class JsonWriterOps[A](value: A){
    def toJson(implicit w:JsonWriter[A]) : Json =
      w.write(value)
  }
}