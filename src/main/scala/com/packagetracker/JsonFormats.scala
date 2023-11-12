package com.packagetracker

import spray.json.RootJsonFormat
import spray.json.DefaultJsonProtocol
import spray.json.JsObject
import spray.json.JsString
import spray.json.JsValue
import spray.json.DeserializationException

import com.packagetracker.models._

object JsonFormats {
  import DefaultJsonProtocol._

  implicit val addressJsonFormat: RootJsonFormat[Address] = jsonFormat2(Address)
  implicit val packageStatusJsonFormat: RootJsonFormat[PackageStatus] =
    new RootJsonFormat[PackageStatus] {
      def write(status: PackageStatus) = JsObject(
        "status" -> JsString(status.identifier),
        "description" -> JsString(status.description)
      )
      def read(value: JsValue) = value.asJsObject.getFields("status") match {
        case Seq(JsString(status)) => PackageStatus.withIdentifier(status)
        case _ => throw DeserializationException("Status identifier expected")
      }
    }
  implicit val packageJsonFormat: RootJsonFormat[Package] = jsonFormat4(Package)
}
