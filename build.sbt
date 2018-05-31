name := "awesome-scala-rest"

version := "0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "io.spray" %% "spray-can" % "1.3.4",
  "io.spray" %% "spray-http" % "1.3.4",
  "io.spray" %% "spray-routing" % "1.3.4",
  "io.spray" %% "spray-json" % "1.3.1",
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.13",
  "com.typesafe.slick" %% "slick" % "3.2.3",
  "mysql" % "mysql-connector-java" % "5.1.25",
  "net.liftweb" %% "lift-json" % "3.2.0",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "com.github.nscala-time" %% "nscala-time" % "2.20.0"
)

resolvers ++= Seq(
  "Spray repository" at "http://repo.spray.io",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)