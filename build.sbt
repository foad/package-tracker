lazy val akkaHttpVersion = "10.6.0"
lazy val akkaVersion = "2.9.0"

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

fork := true

lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "com.packagetracker",
      scalaVersion := "2.13.12"
    )
  ),
  name := "package-tracker",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.11",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
    "org.scalatest" %% "scalatest" % "3.2.12" % Test
  )
)
