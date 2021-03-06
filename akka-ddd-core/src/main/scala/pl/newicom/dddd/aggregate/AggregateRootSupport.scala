package pl.newicom.dddd.aggregate

import pl.newicom.dddd.office.OfficeListener

object AggregateRootSupport {

  trait Eventually[E <: DomainEvent]

  case class Immediately[E <: DomainEvent](events: Seq[E]) extends Eventually[E] {
    def &(next: E): Immediately[E] = Immediately(events :+ next)
  }

}

trait AggregateRootSupport {

  implicit def officeListener[A <: AggregateRoot[_, _, _]]: OfficeListener[A] = new OfficeListener[A]

}
