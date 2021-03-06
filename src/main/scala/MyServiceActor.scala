package {{DEFAULT_PACKAGE}}

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

// We don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // The HttpService trait defines only one abstract member, which
  // connects the services environment to the closing actor or test
  def actorRefFactory = context

  // This actor only runs our route, but you could add other thing here,
  // like request stream processing or timeout handling
  def receive = runRoute(myRoute)

}

// This trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            html.index().toString
          }
        }
      }
    }

}
