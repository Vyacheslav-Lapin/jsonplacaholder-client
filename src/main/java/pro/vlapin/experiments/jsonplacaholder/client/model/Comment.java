package pro.vlapin.experiments.jsonplacaholder.client.model;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Value;

/**
 * Comment for post
 */
@Value
@Schema(description = "Comment for post")
@SuppressWarnings({"java:S125", "ClassCanBeRecord"})
public class Comment { //public record Comment(
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer id; //,
    @Min(1) @Schema(requiredMode = NOT_REQUIRED) Integer postId; //,
    @Schema(requiredMode = NOT_REQUIRED) String name; //,
    @Schema(requiredMode = NOT_REQUIRED) String email; //,
    @Schema(requiredMode = NOT_REQUIRED) String body; //) {
}

