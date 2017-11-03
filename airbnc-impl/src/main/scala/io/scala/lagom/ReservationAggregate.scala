package io.scala.lagom

import java.time.LocalDate

import akka.Done
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity

/**
  */
class ReservationAggregate extends PersistentEntity {
  override type Command = Nothing
  override type Event = Nothing
  override type State = Nothing

  override def initialState = ???

  override def behavior: Behavior = ???
}
