import sbt._
import Keys._

object Dependencies {
  var resolutionRepositories = Seq(
    "Sonatype Repository" at "https://oss.sonatype.org/content/repositories/releases",
    "Spray Repository" at "http://repo.spray.io",
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases",
    "Sbt Plugin Releases" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"
  )

  object Versions {
    val akka = "2.3.9"
    val joda = "2.1"
    val jodaConvert = "1.2"
    val logback = "1.0.13"
    val spray = "1.3.3"
  }

  object Libraries {
    val akkaActor = "com.typesafe.akka" %% "akka-actor" % Versions.akka
    val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % Versions.akka
    val joda = "joda-time" % "joda-time" % Versions.joda
    val jodaConvert = "org.joda" % "joda-convert" % Versions.jodaConvert
    val logback = "ch.qos.logback" % "logback-classic" % Versions.logback
    val sprayCan = "io.spray" %% "spray-can" % Versions.spray
    val sprayRouting = "io.spray" %% "spray-routing" % Versions.spray
  }

  lazy val dependencies = Seq(
    Libraries.akkaActor,
    Libraries.akkaSlf4j,
    Libraries.joda,
    Libraries.jodaConvert,
    Libraries.logback,
    Libraries.sprayCan,
    Libraries.sprayRouting
  )
}
