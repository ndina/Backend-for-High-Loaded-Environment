name := "Docker"

version := "1.0.0"

scalaVersion := "2.12.8"


libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.452",
  "com.typesafe.akka" %% "akka-actor" % "2.5.18",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.18" % Test
)


enablePlugins(JavaAppPackaging)