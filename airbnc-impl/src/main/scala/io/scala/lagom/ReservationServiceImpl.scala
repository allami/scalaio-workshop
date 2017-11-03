package io.scala.lagom

import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.api.broker.Topic
import com.lightbend.lagom.scaladsl.broker.TopicProducer
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

/**
  * Implementation of the ReservationService.
  */
class ReservationServiceImpl(persistentEntityRegistry: PersistentEntityRegistry,
                             reservationRepository: ReservationRepository)
    extends ReservationService {

  override def requestReservation(accommodation: String) = ServiceCall {
    reservation =>
      val aggregate =
        persistentEntityRegistry.refFor[ReservationAggregate](accommodation)

      val reservationData = ReservationData(
        accommodation = reservation.accommodation,
        guest = reservation.guest,
        host = reservation.host,
        startingDate = reservation.startingDate,
        duration = reservation.duration
      )
      // Ask the entity the Hello command.
      aggregate.ask(RequestReservation(reservationData))
  }

  /**
    * The reservation notification events topic.
    */
  override def reservationNotifications(): Topic[ReservationNotification] =
    TopicProducer.singleStreamWithOffset { fromOffset =>
      persistentEntityRegistry
        .eventStream(ReservationEvent.Tag, fromOffset)
        .map(ev => (convertEvent(ev.event), ev.offset))
    }

  def convertEvent(event: ReservationEvent): ReservationNotification =
    event match {
      case ReservationRequested(reservationData) =>
        ReservationRequestedNotification(
          Reservation(reservationData.accommodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
      case ReservationConfirmed(reservationData) =>
        ReservationConfirmedNotification(
          Reservation(reservationData.accommodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
      case ReservationRejected(reservationData) =>
        ReservationRejectedNotification(
          Reservation(reservationData.accommodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
      case ReservationCancelled(reservationData) =>
        ReservationCancelledNotification(
          Reservation(reservationData.accommodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
    }
}
