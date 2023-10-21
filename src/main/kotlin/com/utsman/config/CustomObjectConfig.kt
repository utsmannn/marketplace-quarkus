package com.utsman.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.quarkus.arc.All
import io.quarkus.jackson.ObjectMapperCustomizer
import jakarta.inject.Singleton

class CustomObjectConfig {

    @Singleton
    fun objectMapper(@All customizer: MutableList<ObjectMapperCustomizer>): ObjectMapper {
        val objectMapper = ObjectMapper()
        with(objectMapper) {
            writerWithDefaultPrettyPrinter()
            enable(SerializationFeature.INDENT_OUTPUT)
        }

        customizer.forEach { it.customize(objectMapper) }
        return objectMapper
    }
}