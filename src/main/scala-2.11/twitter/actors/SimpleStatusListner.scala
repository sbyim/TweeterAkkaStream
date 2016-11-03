package twitter.actors

import akka.actor.Actor
import twitter4j._
import twitter4j.auth.AccessToken
import twitter4j.conf.ConfigurationBuilder

/**
  * Created by yim on 02.11.2016.
  */
class SimpleStatusListenerActor extends Actor {
  import SimpleStatusListenerActor._
  val twitterStream = new TwitterStreamFactory(new ConfigurationBuilder().build()).getInstance
  twitterStream.setOAuthConsumer(Util.appKey,Util.appSecret)
  twitterStream.setOAuthAccessToken(new AccessToken(Util.accessToken,Util.accessTokenSecret))

  def simpleStatusListener = new StatusListener(){
    def onStatus(status: Status) {
      println(status.getText)
    }
    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
    def onException(ex: Exception) { ex.printStackTrace }
    def onScrubGeo(arg0: Long, arg1: Long) {}
    def onStallWarning(warning: StallWarning) {}
  }

  def receive = {
    case StartStream =>
      twitterStream.addListener(simpleStatusListener)
      twitterStream.filter("korea")
      Thread.sleep(2000)
    case QuitStream =>
      twitterStream.cleanUp
      twitterStream.shutdown
  }
}
object SimpleStatusListenerActor {
  sealed abstract class Command
  case object StartStream
  case object QuitStream

}