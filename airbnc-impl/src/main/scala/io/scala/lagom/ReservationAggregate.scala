package io.scala.lagom

import java.time.LocalDate

import akka.Done
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity

/**
  */
class ReservationAggregate extends PersistentEntity {
  override type Command = ReservationCommand[_]
  override type Event = ReservationEvent
  override type State = ReservationState

  override def initialState =
    ReservationState(Map[LocalDate, List[ReservationData]]()
                       .withDefaultValue(List[ReservationData]()),
                     Map.empty[LocalDate, ReservationData])

  override def behavior: Behavior =
    _ =>
      Actions().onCommand[RequestReservation, Done] {
        case (RequestReservation(reservationData), ctx, state) =>
          ctx.reply(Done)
          ctx.done
    }

}
