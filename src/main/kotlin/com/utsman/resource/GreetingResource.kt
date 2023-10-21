package com.utsman.resource

import com.utsman.repository.ProductRepository
import com.utsman.model.ApplicationResponse
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {

    @Inject
    private lateinit var productRepository: ProductRepository

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from RESTEasy Reactive"

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    fun ping(): ApplicationResponse<String> {
        return ApplicationResponse(
            status = true,
            data = "ok"
        )
    }

    @GET
    @Path("/images")
    fun getNames(): List<String> {
        return productRepository
            .getImagePath("Vintage Vinyl Records")
    }
}