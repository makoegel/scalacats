package sandbox.typeclass

import sandbox.model.Person

// Type class Instances
object JsonWriterInstances {

    implicit val stringWriter: JsonWriter[String] =
      new JsonWriter[String] {
        override def write(value: String): Json = JsString(value)
      }

    implicit val personWriter: JsonWriter[Person] =
      new JsonWriter[Person] {
        override def write(value: Person): Json =
          JsObject(Map (
            "name" -> JsString(value.name),
            "email" -> JsString(value.email)
          ))
      }

    implicit val numberWriter: JsonWriter[Int] =
      new JsonWriter[Int] {
        override def write(value: Int): Json = JsNumber(value)
      }

    implicit def optionWriter[A] (implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
      new JsonWriter[Option[A]] {
        def write(option: Option[A]): Json =
          option match {
            case Some(aValue) => writer.write(aValue)
            case None
            => JsNull
          }
      }
}
