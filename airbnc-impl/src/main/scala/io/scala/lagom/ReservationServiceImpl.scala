package io.scala.lagom

import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.api.broker.Topic
import com.lightbend.lagom.scaladsl.broker.TopicProducer
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

import scala.concurrent.Future

/**
  * Implementation of the ReservationService.
  */
class ReservationServiceImpl(persistentEntityRegistry: PersistentEntityRegistry,
                             reservationRepository: ReservationRepository)
    extends ReservationService {

  override def healthCheck() = ServiceCall { request =>
    Future.successful("OK")
  }
  /**
  def convertEvent(event: ReservationEvent): ReservationNotification =
    event match {
      case ReservationRequested(reservationData) =>
        ReservationRequestedNotification(
          Reservation(reservationData.accomodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
      case ReservationConfirmed(reservationData) =>
        ReservationConfirmedNotification(
          Reservation(reservationData.accomodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
      case ReservationRejected(reservationData) =>
        ReservationRejectedNotification(
          Reservation(reservationData.accomodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
      case ReservationCancelled(reservationData) =>
        ReservationCancelledNotification(
          Reservation(reservationData.accomodation,
                      reservationData.guest,
                      reservationData.host,
                      reservationData.startingDate,
                      reservationData.duration))
    }
    **/
}
