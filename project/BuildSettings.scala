import sbt._
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._
import twirl.sbt.TwirlPlugin._

object BuildSettings {

  lazy val basicSettings = Seq(
    organization := "{{ORGANIZATION}}",
    organizationHomepage := Some(new URL("{{ORGANIZATION_HOMEPAGE}}")),
    description := "{{DESCRIPTION}}",
    startYear := Some({{START_YEAR}}),
    scalaVersion := "2.11.7",
    resolvers ++= Dependencies.resolutionRepositories,
    scalacOptions := Seq(
      "-encoding", "utf8",
      "-unchecked",
      "-deprecation"
    )
  )

  lazy val sbtAssemblySettings = assemblySettings ++ Seq(
    jarName in assembly <<= (name) map { (n) => n + ".jar" },
    mergeStrategy in assembly <<= (mergeStrategy in assembly) {
      (old) => {
        case x => {
          val oldStrategy = old(x)
          if(oldStrategy == MergeStrategy.deduplicate) MergeStrategy.first
          else oldStrategy
        }
      }
    }
  )

  lazy val buildSettings = basicSettings ++ sbtAssemblySettings ++ Twirl.settings

}
