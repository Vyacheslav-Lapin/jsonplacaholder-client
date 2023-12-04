package pro.vlapin.experiments.jsonplacaholder.client.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pro.vlapin.experiments.jsonplacaholder.client.model.Comment;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@Tag(name = "comment", description = "the comment API")
public interface CommentsApi {

    /**
     * POST /comments : Create a comment
     * Important - resource will not be really updated on the server but it will be faked as if
     *
     * @param comment (required)
     * @return Comment will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addComment",
        summary = "Create a comment",
        description = "Important - resource will not be really updated on the server but it will be faked as if",
        tags = "comment",
        responses = @ApiResponse(responseCode = "201",
                                 description = "Comment will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Comment.class))))
    @PostMapping(path = "/comments",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Comment> addComment(
        @Valid
        @RequestBody
        @Parameter(required = true)
        Comment comment);

    /**
     * GET /comments : Listing all comments
     * All the comments for all entities presented in this API. Can be filtered by optional query params
     *
     * @param postId Filter - this will return all the comments that belong to the post with specified id (optional)
     * @return A JSON array of comments (status code 200)
     */
    @Operation(
        operationId = "comments",
        summary = "Listing all comments",
        description = "All the comments for all entities presented in this API. Can be filtered by optional query params",
        tags = "comment",
        responses = @ApiResponse(responseCode = "200",
                                 description = "A JSON array of comments",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    array = @ArraySchema(schema = @Schema(implementation = Comment.class)))))
    @GetMapping(path = "/comments",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Comment>> comments(
        @Valid
        @Min(1)
        @Parameter(name = "postId",
                   description = "Filter - this will return all the comments that belong to the post with specified id",
                   in = ParameterIn.QUERY)
        @RequestParam(required = false)
        Integer postId);

    /**
     * PATCH /comments/{id} : Patching a comment
     *
     * @param id id of comment in a comments list (required)
     * @return Comment will not be really patched on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "mergeComment",
        summary = "Patching a comment",
        tags = "comment",
        responses = @ApiResponse(responseCode = "200",
                                 description = "Comment will not be really patched on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Comment.class))))
    @PatchMapping(path = "/comments/{id}",
                  produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Comment> mergeComment(
        @Min(1)
        @PathVariable
        @Parameter(description = "id of comment in a comments list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * GET /comments/{id} : Get comment by it&#39;s id
     *
     * @param id (required)
     * @return Comment, specified by id (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "pickComment",
        summary = "Get comment by it's id",
        tags = "comment",
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "Comment, specified by id",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Comment.class))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/comments/{id}",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Comment> pickComment(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * DELETE /comments/{id} : Deleting a comment
     *
     * @param id Id of comment in a comments list (required)
     * @return Comment will not be really deleted on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "removeComment",
        summary = "Deleting a comment",
        tags = "comment",
        responses = @ApiResponse(responseCode = "200",
                                 description = "Comment will not be really deleted on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Object.class))))
    @DeleteMapping(path = "/comments/{id}",
                   produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Object> removeComment(
        @Min(1)
        @Parameter(description = "Id of comment in a comments list",
                   required = true,
                   in = ParameterIn.PATH)
        @PathVariable
        Integer id);

    /**
     * PUT /comments/{id} : Updating a comment
     * Important - resource will not be really updated on the server but it will be faked as if
     *
     * @param id      Id of comment in a comments list (required)
     * @param comment (required)
     * @return The server successfully processed the request, but is not returning any content (status code 204)
     */
    @Operation(
        operationId = "updateComment",
        summary = "Updating a comment",
        description = "Important - resource will not be really updated on the server but it will be faked as if",
        tags = "comment",
        responses = @ApiResponse(responseCode = "204",
                                 description = "The server successfully processed the request, but is not returning any content"))
    @PutMapping(path = "/comments/{id}",
                consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateComment(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of comment in a comments list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @RequestBody
        @Parameter(required = true)
        Comment comment);
}
