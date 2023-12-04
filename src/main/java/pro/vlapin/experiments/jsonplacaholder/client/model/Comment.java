package pro.vlapin.experiments.jsonplacaholder.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;

/**
 * Comment for post
 */
@Schema(description = "Comment for post")
public record Comment(
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer id,
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer postId,
    @Schema(requiredMode = NOT_REQUIRED) String name,
    @Schema(requiredMode = NOT_REQUIRED) String email,
    @Schema(requiredMode = NOT_REQUIRED) String body) {
}

