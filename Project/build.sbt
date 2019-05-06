name := "Project"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.rabbitmq" % "amqp-client" % "5.7.0",
  "org.slf4j" % "slf4j-api" % "1.8.0-beta4",
  "org.slf4j" % "slf4j-nop" % "1.8.0-beta4" % Test,
  "com.typesafe.akka" %% "akka-actor" % "2.5.21",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.21" % Test,
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.21",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.akka" %% "akka-http"   % "10.1.7",
  "com.typesafe.akka" %% "akka-stream" % "2.5.22",
)

