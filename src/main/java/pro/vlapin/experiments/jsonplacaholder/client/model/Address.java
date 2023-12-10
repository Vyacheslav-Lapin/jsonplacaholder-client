package pro.vlapin.experiments.jsonplacaholder.client.model;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Value;

/**
 * Address
 */
@Value
@Schema(description = "Address")
@SuppressWarnings({"java:S125", "ClassCanBeRecord"})
public class Address {//public record Address(
    @Schema(requiredMode = NOT_REQUIRED) String street; //,
    @Schema(requiredMode = NOT_REQUIRED) String suite; //,
    @Schema(requiredMode = NOT_REQUIRED) String city; //,
    @Schema(requiredMode = NOT_REQUIRED) String zipcode; //,
    @Valid @Schema(requiredMode = NOT_REQUIRED) Geo geo; //) {
}
