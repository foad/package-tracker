package com.packagetracker.models

sealed trait PackageStatus {
  def identifier: String
  def description: String
  def location: Option[String] = None
}

case object InfoReceived extends PackageStatus {
  val identifier = "info-received"
  val description = "Sender is preparing item"
}
case object PackageAccepted extends PackageStatus {
  val identifier = "accepted"
  val description = "Item collected"
}
case class InTransitArrived(info: String) extends PackageStatus {
  val identifier = "in-transit-arrived"
  val description = "Item arrived at " + info
  override val location = Some(info)
}
case class InTransitLeft(info: String) extends PackageStatus {
  val identifier = "in-transit-left"
  val description = "Item left " + info
  override val location = Some(info)
}
case class Exported(info: String) extends PackageStatus {
  val identifier = "exported"
  val description = "Item exported from " + info
  override val location = Some(info)
}
case object CustomsArrived extends PackageStatus {
  val identifier = "customs-arrived"
  val description = "Item arrived at customs"
}
case object CustomsTaxesApplied extends PackageStatus {
  val identifier = "customs-taxes-applied"
  val description = "Item held as customs fee to pay"
}
case object CustomsLeft extends PackageStatus {
  val identifier = "customs-left"
  val description = "Item released from customs"
}
case class ArrivedPickup(info: String) extends PackageStatus {
  val identifier = "arrived-pickup"
  val description = "Item is ready for pickup or redelivery at " + info
  override val location = Some(info)
}
case object SoonDelivery extends PackageStatus {
  val identifier = "soon-delivery"
  val description = "Item is being prepared for delivery"
}
case object InDelivery extends PackageStatus {
  val identifier = "in-delivery"
  val description = "Item is out for delivery"
}
case object Delivered extends PackageStatus {
  val identifier = "delivered"
  val description = "Item delivered"
}
case object DeliveryFailed extends PackageStatus {
  val identifier = "delivery-failed"
  val description = "Delivery attempted"
}
case object InStorage extends PackageStatus {
  val identifier = "in-storage"
  val description = "Item is being held in storage"
}
case object Other extends PackageStatus {
  val identifier = "other"
  val description = "Package status unknown"
}
