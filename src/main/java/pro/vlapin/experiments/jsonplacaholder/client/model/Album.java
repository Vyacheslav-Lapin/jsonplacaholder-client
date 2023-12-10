package pro.vlapin.experiments.jsonplacaholder.client.model;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Value;

/**
 * Album of photos
 */
@Value
@Schema(description = "Album of photos")
@SuppressWarnings({"java:S125", "ClassCanBeRecord"})
public class Album { //public record Album(
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer id; //,
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer userId; //,
    @Schema(requiredMode = NOT_REQUIRED) String title; //) {
}
