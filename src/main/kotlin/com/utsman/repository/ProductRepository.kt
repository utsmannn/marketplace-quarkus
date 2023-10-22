package com.utsman.repository

import com.utsman.model.Category
import com.utsman.model.Product
import com.utsman.model.Sort
import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductRepository {

    private val products: MutableList<Product> = mutableListOf()
    private val categories: MutableList<Category> = mutableListOf()
    private val imagePath: MutableList<String> = mutableListOf()

    init {
        val images = readCsv("images.csv") { lineImage, _ ->
            lineImage
        }.flatten()
        imagePath.addAll(images)

        products.addAll(readProductCsv())
        categories.addAll(readCategoryCsv())

    }

    private fun <T> readCsv(name: String, mapper: (List<String>, Int) -> T): List<T> {
        val reader = this.javaClass.classLoader.getResourceAsStream(name)?.bufferedReader()
        val header = reader?.readText()

        val data = header?.lineSequence().orEmpty()
            .filter { it.isNotBlank() }
            .filterIndexed { index, s -> index != 0 }
            .mapIndexed { index, s ->
                val line = s.split(",")
                mapper.invoke(line, index)
            }.toList()

        return data
    }

    private final fun readProductCsv(): List<Product> {
        val data = readCsv("product.csv") { line, _ ->
            val id = line[0].toIntOrNull() ?: 0
            val name = line[1].replace("\"", "")
            val description = line[2].replace("\"", "")
            val categoryString = line[3]
            val category = readCategoryCsv().find { it.name == categoryString } ?: Category.unknown()
            val price = line[4].toDoubleOrNull() ?: 0.0
            val rating = line[5].toDoubleOrNull() ?: 0.0
            val discount = line[6].toIntOrNull() ?: 0
            val images = getImagePath(name)
            Product(id, name, description, category, price, rating, discount, images)
        }

        return data
    }

    private final fun readCategoryCsv(): List<Category> {
        val data = readCsv("category.csv") { line, index ->
            val id = index + 1
            val name = line[0].replace("\"", "")
            val description = line[1].replace("\"", "")
            Category(id, name, description)
        }

        return data
    }

    fun getProductPaging(page: Int, size: Int, categoryId: Int, query: String, sort: Sort): List<Product> {
        if (!categories.map { it.id }.contains(categoryId) && categoryId > 0) throw IllegalArgumentException("Category id not found")

        val productSearch = products.filter { it.name.lowercase().contains(query.lowercase()) }
            .run {
                when (sort) {
                    Sort.RATING -> sortedByDescending { it.rating }
                    Sort.HIGH_PRICE -> sortedByDescending { it.price }
                    Sort.LOW_PRICE -> sortedBy { it.price }
                    Sort.DISCOUNT -> sortedByDescending { it.discount }
                    Sort.NONE -> this
                }
            }

        val productCategory = if (categoryId == -1) {
            productSearch
        } else {
            productSearch.filter { it.category.id == categoryId }
        }

        val startIndex = (page - 1) * size
        val endIndex = startIndex + size
        return try {
            productCategory.subList(startIndex.coerceAtLeast(0), endIndex.coerceAtMost(productCategory.size))
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            emptyList()
        }
    }

    final fun getProductCategory(): List<Category> {
        return categories
    }

    fun getImagePath(filter: String): List<String> {
        return imagePath
            .filter {
                it.split("/")[1] == filter
            }
            .map { it.replace(" ", "%20") }
            .map {
                "https://raw.githubusercontent.com/utsmannn/utsmannn/master/$it"
            }
    }
}