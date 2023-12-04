package pro.vlapin.experiments.jsonplacaholder.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;

/**
 * Task to do for some user
 */
@Schema(description = "Task to do for some user")
public record Todo(
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer id,
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer userId,
    @Schema(requiredMode = NOT_REQUIRED) String title,
    @Schema(requiredMode = NOT_REQUIRED) Boolean completed) {
}
