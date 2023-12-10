package pro.vlapin.experiments.jsonplacaholder.client.model;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Value;

/**
 * Post
 */
@Value
@SuppressWarnings({"java:S125", "ClassCanBeRecord"})
public class Post { //public record Post(
  @Schema(requiredMode = NOT_REQUIRED) @Min(1) Integer id; //,
  @Schema(requiredMode = NOT_REQUIRED) @Min(1) Integer userId; //,
  @Schema(requiredMode = NOT_REQUIRED) String title; //,
  @Schema(requiredMode = NOT_REQUIRED) String body; //) {
}
