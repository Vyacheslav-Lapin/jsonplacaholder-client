package pro.vlapin.experiments.jsonplacaholder.client.model;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;

/**
 * Company
 */
public record Company(
    @Schema(requiredMode = NOT_REQUIRED) String name,
    @Schema(requiredMode = NOT_REQUIRED) String catchPhrase,
    @Schema(requiredMode = NOT_REQUIRED) String bs) {
}
