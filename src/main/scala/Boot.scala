package {{DEFAULT_PACKAGE}}

// Java
import java.io.File

// Scala
import scala.concurrent.duration._

// Typesafe config
import com.typesafe.config.{Config, ConfigFactory, ConfigParseOptions}

// Akka
import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout

// Spray
import spray.can.Http

object Boot extends App {
  println("Booting up {{PROJECT_NAME}}")

  implicit val system = ActorSystem("actor-system")
  implicit val timeout = Timeout(5.seconds)

  val missingConfigs = ConfigParseOptions.defaults().setAllowMissing(true)
  val baseConfig = ConfigFactory
    .parseFile(new File("environment.conf"), missingConfigs)
    .withFallback(system.settings.config)
  val config = new {{PROJECT_NAME}}Config(baseConfig)

  val service = system.actorOf(Props(classOf[MyServiceActor]), "http-service")

  IO(Http) ? Http.Bind(service,
    interface = config.interface,
    port = config.port)
}

class {{PROJECT_NAME}}Config(config: Config) {
  private val service = config.getConfig("app")
  val interface = service.getString("interface")
  val port = service.getInt("port")
}
