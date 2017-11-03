package io.scala.lagom

import akka.Done
import com.datastax.driver.core.{BoundStatement, PreparedStatement}
import com.lightbend.lagom.scaladsl.persistence.{
  EventStreamElement,
  ReadSideProcessor
}
import com.lightbend.lagom.scaladsl.persistence.cassandra.{
  CassandraReadSide,
  CassandraSession
}

import scala.concurrent.{ExecutionContext, Future, Promise}

class ReservationProjector(
    session: CassandraSession,
    readSide: CassandraReadSide)(implicit ec: ExecutionContext)
    extends ReadSideProcessor[ReservationEvent] {

  override def buildHandler() = ???

  private def process(
      eventElement: EventStreamElement[_]): Future[List[BoundStatement]] = ???

  override def aggregateTags = Set(ReservationEvent.Tag)

  private def createTable(): Future[Done] =
    session.executeCreateTable(
      "CREATE TABLE IF NOT EXISTS hostreservations ( " +
        "host TEXT, accomodation TEXT, guest TEXT, startingDate TEXT, duration INT, PRIMARY KEY (host, accomodation, startingDate, guest))")

  private val writePromise = Promise[PreparedStatement] // initialized in prepare
  private def writeHostReservation: Future[PreparedStatement] =
    writePromise.future

  private def prepareWrite(): Future[Done] = ???

}
