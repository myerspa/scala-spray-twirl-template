import sbt._
import Keys._
import sbt.Classpaths.publishTask
import sbtassembly.Plugin._
import AssemblyKeys._
import spray.revolver.RevolverPlugin._

object Build extends Build {
  import BuildSettings._
  import Dependencies._
  import net.virtualvoid.sbt.graph.Plugin.graphSettings

  // Configure sbt console to show project name
  override lazy val settings = super.settings :+ {
    shellPrompt := { s => Project.extract(s).currentProject.id + " >> " }
  }

  // Project configuration
  lazy val project = Project("{{PROJECT_NAME}}", file("."))
    .settings(buildSettings: _*)
    .settings(Revolver.settings: _*)
    .settings(libraryDependencies ++= dependencies)

}
