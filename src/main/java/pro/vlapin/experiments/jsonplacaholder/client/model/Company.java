package pro.vlapin.experiments.jsonplacaholder.client.model;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

/**
 * Company
 */
@Value
@SuppressWarnings({"java:S125", "ClassCanBeRecord"})
public class Company { //public record Company(
    @Schema(requiredMode = NOT_REQUIRED) String name; //,
    @Schema(requiredMode = NOT_REQUIRED) String catchPhrase; //,
    @Schema(requiredMode = NOT_REQUIRED) String bs; //) {
}
