package twitter

import akka.actor.{ActorSystem, Props}
import akka.stream.ActorMaterializer
import twitter.actors.SimpleStatusListenerActor.StartStream
import twitter.actors.{SimpleStatusListenerActor, TransportActor}

import scala.concurrent.Future

/**
  * Created by yim on 28.10.2016.
  */
object MyTwitterClient extends App{

  implicit val system = ActorSystem()
  implicit  val materializer = ActorMaterializer()

  val twitterBot = system.actorOf(Props[SimpleStatusListenerActor],"twitterBot")
  twitterBot ! StartStream

}
