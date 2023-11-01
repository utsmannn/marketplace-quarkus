package com.utsman.resource

import com.utsman.model.*
import com.utsman.repository.ProductRepository
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType

@Path("/product")
class ProductResources {

    @Inject
    private lateinit var productRepository: ProductRepository

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getProducts(
        @QueryParam("page") queryPage: Int,
        @QueryParam("pageSize") querySize: Int,
        @QueryParam("categoryId") queryCategoryId: Int,
        @QueryParam("query") query: String?,
        @QueryParam("sort") querySort: String?
    ): ApplicationResponse<List<ThumbnailProduct>> {

        val page = if (queryPage == 0) 1 else queryPage
        val size = if (querySize == 0) 10 else querySize
        val categoryId = if (queryCategoryId == 0) -1 else queryCategoryId

        val sort = querySort?.toSort() ?: Sort.NONE

        val products = productRepository.getProductPaging(page, size, categoryId, query.orEmpty(), sort)
        return ApplicationResponse(
            status = true,
            message = "Get product success",
            data = products
        )
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getProductId(
        @PathParam("id") productId: Int
    ): ApplicationResponse<Product> {
        val product = productRepository.getProductById(productId)
        return ApplicationResponse(
            status = true,
            message = "Get product success",
            data = product
        )
    }

    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    fun getCategory(): ApplicationResponse<List<Category>> {
        val category = productRepository.getProductCategory()
        return ApplicationResponse(
            status = true,
            message = "Get category success",
            data = category
        )
    }
}