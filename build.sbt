name := "ScalaAkkaBot"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.4.11"
libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.5"
libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "4.0.5"
libraryDependencies += "com.typesafe.akka" % "akka-stream_2.11" % "2.4.11"
libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.4.11"
libraryDependencies += "com.typesafe.akka" % "akka-http-spray-json-experimental_2.11" % "2.4.11"