package pro.vlapin.experiments.jsonplacaholder.client.model;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Value;

/**
 * Task to do for some user
 */
@Value
@Schema(description = "Task to do for some user")
@SuppressWarnings({"java:S125", "java:S1135", "ClassCanBeRecord"})
public class Todo { //public record Todo(
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer id; //,
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer userId; //,
    @Schema(requiredMode = NOT_REQUIRED) String title; //,
    @Schema(requiredMode = NOT_REQUIRED) Boolean completed; //) {
}
