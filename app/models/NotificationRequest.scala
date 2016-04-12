package models

import play.api.libs.json.Json

/**
  * Created by stanislav on 4/12/16.
  */
object NotificationRequest {
  case class NotificationRequest(id: String, senderName: String, content: String, recipients: List[String])

  implicit val notificationRequestWrites = Json.writes[NotificationRequest]
  implicit val notificationRequestReads = Json.reads[NotificationRequest]

  var notificationRequests = List(
    NotificationRequest("123", "Professor Farnsworth", "Hello world!", List("Amy Wong", "Fry")),
    NotificationRequest("123", "Bender", "Must Kill All Humans!", List("Leela", "Zoidberg"))
  )

  def addNotificationRequest(request: NotificationRequest) = notificationRequests = notificationRequests ::: List(request)
}
