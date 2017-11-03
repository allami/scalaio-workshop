package io.scala.lagom

import com.lightbend.lagom.scaladsl.persistence.{
  AggregateEvent,
  AggregateEventTag
}
import play.api.libs.json.{Format, Json}

/**
  */
sealed trait ReservationEvent extends AggregateEvent[ReservationEvent] {
  override val aggregateTag = ReservationEvent.Tag
}

object ReservationEvent {
  val Tag: AggregateEventTag[ReservationEvent] =
    AggregateEventTag[ReservationEvent]
}
