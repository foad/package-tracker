package com.packagetracker.models

final case class Address(
    house: String,
    postCode: String
)

final case class Package(
    id: String,
    status: PackageStatus,
    destination: Address
)
