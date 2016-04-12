package controllers

import play.api.libs.json._
import play.api.mvc._
import models.Book._
import models.NotificationRequest._

object Application extends Controller {

  def listBooks = Action {
    Ok(Json.toJson(books))
  }

  def saveBook = Action(BodyParsers.parse.json) { request =>
    val b = request.body.validate[Book]
    b.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toJson(errors)))
      },
      book => {
        addBook(book)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }

  def listNotificationRequests = Action {
    Ok(Json.toJson(notificationRequests))
  }

  def saveNotificationRequest = Action(BodyParsers.parse.json) { request =>
    val b = request.body.validate[NotificationRequest]
    b.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toJson(errors)))
      },
      notificationRequest => {
        addNotificationRequest(notificationRequest)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }
}
