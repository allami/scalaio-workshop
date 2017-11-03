package io.scala.lagom

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.Service.{named, restCall}
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait ReservationService extends Service {

  def healthCheck(): ServiceCall[NotUsed, String]

  override final def descriptor: Descriptor =
    named("airbnc")
      .withCalls(
        restCall(Method.GET, "/api/notifications/health", healthCheck)
      )
      .withAutoAcl(true)

}
