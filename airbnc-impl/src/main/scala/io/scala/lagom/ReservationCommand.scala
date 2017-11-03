package io.scala.lagom

import akka.Done
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.{Format, Json}

sealed trait ReservationCommand[R] extends ReplyType[R]
