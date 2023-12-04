package pro.vlapin.experiments.jsonplacaholder.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;

/**
 * User
 */
public record User(
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer id,
    @Schema(requiredMode = NOT_REQUIRED) String name,
    @Schema(requiredMode = NOT_REQUIRED) String username,
    @Schema(requiredMode = NOT_REQUIRED) String email,
    @Schema(requiredMode = NOT_REQUIRED) Address address,
    @Schema(requiredMode = NOT_REQUIRED) String phone,
    @Schema(requiredMode = NOT_REQUIRED) String website,
    @Schema(requiredMode = NOT_REQUIRED) Company company) {
}
