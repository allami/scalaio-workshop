package io.scala.lagom

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.Service.{named, restCall}
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait ReservationService extends Service {

  def healthCheck(): ServiceCall[NotUsed, String]

  def requestReservation(accommodation: String): ServiceCall[Reservation, Done]

  override final def descriptor: Descriptor =
    named("airbnc")
      .withCalls(
        restCall(Method.GET, "/api/reservation/health", healthCheck),
        restCall(Method.POST,
                 "/api/reservation/:accommodation/requestReservation",
                 requestReservation _)
      )
      .withAutoAcl(true)

}
