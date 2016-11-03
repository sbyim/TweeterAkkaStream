package twitter.model

import twitter4j.User

/**
  * Created by yim on 03.11.2016.
  */
class Tweet(val id: Long,val text: String, val retweetCount: Int, val user: User) {
}
