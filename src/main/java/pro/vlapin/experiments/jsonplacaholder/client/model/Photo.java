package pro.vlapin.experiments.jsonplacaholder.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;

/**
 * Album of photos
 */

@Schema(description = "Photos from album")
public record Photo(
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer id,
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer albumId,
    @Schema(requiredMode = NOT_REQUIRED) String title,
    @Schema(requiredMode = NOT_REQUIRED) String url,
    @Schema(requiredMode = NOT_REQUIRED) String thumbnailUrl) {
}

