package br.com.fiap.appbreathe.service

data class LocationCity(
    val address: Address
)

data class Address(
    val city: String,
    val state: String,
    val country: String
)

