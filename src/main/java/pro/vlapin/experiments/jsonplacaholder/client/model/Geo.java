package pro.vlapin.experiments.jsonplacaholder.client.model;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

/**
 * Geo
 */
@Value
@SuppressWarnings({"java:S125", "ClassCanBeRecord"})
public class Geo { //public record Geo(
    @Schema(requiredMode = NOT_REQUIRED) Double lat; //,
    @Schema(requiredMode = NOT_REQUIRED) Double lng; //) {
}

