package com.packagetracker.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes

object PackagesRoutes {
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
                  complete(s"GET /packages/$id/status")
                },
                patch {
                  complete(s"PATCH /packages/$id/status")
                }
              )
            }
          )
        }
      )
    }
  }
}
