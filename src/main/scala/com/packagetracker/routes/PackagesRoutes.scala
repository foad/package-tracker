package com.packagetracker.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes

import com.packagetracker.models._

object PackagesRoutes {
  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
  import com.packagetracker.JsonFormats._

  val examplePackage: Package = Package(
    "1",
    PackageStatus.InfoReceived,
    Address("123", "ABC123"),
    Address("456", "DEF456")
  )

  def apply(): Route = {
    pathPrefix("packages") {
      concat(
        pathEndOrSingleSlash {
          post {
            complete(StatusCodes.Created, "POST /packages")
          }
        },
        pathPrefix(Segment) { id =>
          concat(
            pathEndOrSingleSlash {
              delete {
                complete(s"DELETE /packages/$id")
              }
            },
            path("status") {
              concat(
                get {
                  complete(examplePackage)
                },
                patch {
                  entity(as[PackageStatus]) { status =>
                    complete(
                      "NEW STATUS: " + status.identifier + " " + status.description
                    )
                  }
                }
              )
            }
          )
        }
      )
    }
  }
}
