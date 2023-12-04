package pro.vlapin.experiments.jsonplacaholder.client.model;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;

/**
 * Geo
 */
public record Geo(
    @Schema(requiredMode = NOT_REQUIRED) Double lat,
    @Schema(requiredMode = NOT_REQUIRED) Double lng) {
}

