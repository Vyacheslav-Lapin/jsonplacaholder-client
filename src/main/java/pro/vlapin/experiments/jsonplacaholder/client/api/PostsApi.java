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
import pro.vlapin.experiments.jsonplacaholder.client.model.Post;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@Tag(name = "post", description = "the post API")
public interface PostsApi {

    /**
     * POST /posts/{id}/comments : Create a comment
     * Important - resource will not be really updated on the server but it will be faked as if
     *
     * @param id      id of post in a post list (required)
     * @param comment (required)
     * @return Post will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addCommentToPost",
        summary = "Create a comment",
        description = "Important - resource will not be really updated on the server but it will be faked as if",
        tags = {"post", "comment"},
        responses = @ApiResponse(responseCode = "201",
                                 description = "Post will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Comment.class))))
    @PostMapping(path = "/posts/{id}/comments",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Comment> addCommentToPost(
        @Min(1)
        @PathVariable
        @Parameter(name = "id",
                   description = "id of post in a post list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @RequestBody
        @Parameter(name = "Comment",
                   description = "",
                   required = true)
        Comment comment);

    /**
     * POST /posts : Create a post
     * Important - resource will not be really updated on the server but it will be faked as if
     *
     * @param post (required)
     * @return Post will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addPost",
        summary = "Create a post",
        description = "Important - resource will not be really updated on the server but it will be faked as if",
        tags = "post",
        responses = @ApiResponse(responseCode = "201",
                                 description = "Post will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Post.class))))
    @PostMapping(path = "/posts",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Post> addPost(
        @Valid
        @RequestBody
        @Parameter(required = true)
        Post post);

    /**
     * PATCH /posts/{id} : Patching a resource
     *
     * @param id id of post in a post list (required)
     * @return The server successfully processed the request, but is not returning any content (status code 200)
     */
    @Operation(
        operationId = "mergePost",
        summary = "Patching a resource",
        tags = "post",
        responses = @ApiResponse(responseCode = "200",
                                 description = "The server successfully processed the request, but is not returning any content",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Post.class))))
    @PatchMapping(path = "/posts/{id}",
                  produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Post> mergePost(
        @Min(1)
        @PathVariable
        @Parameter(description = "id of post in a post list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);


    /**
     * GET /posts/{id} : Get Post by id
     *
     * @param id id of post in a post list (required)
     * @return JSON of Post entity, specified by it&#39;s id (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "pickPost",
        summary = "Get Post by id",
        tags = "post",
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "JSON of Post entity, specified by it's id",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Post.class))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/posts/{id}",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Post> pickPost(
        @Min(1)
        @Parameter(description = "id of post in a post list",
                   required = true,
                   in = ParameterIn.PATH)
        @PathVariable
        Integer id);

    /**
     * GET /posts/{id}/comments : Listing all the comments of post
     * One level of nested route is available
     *
     * @param id id of post in a post list (required)
     * @return A JSON array of comments (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "postComments",
        summary = "Listing all the comments of post",
        description = "One level of nested route is available",
        tags = {"post", "comment"},
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "A JSON array of comments",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = Comment.class)))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/posts/{id}/comments",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Comment>> postComments(
        @Min(1)
        @Parameter(description = "id of post in a post list",
                   required = true,
                   in = ParameterIn.PATH)
        @PathVariable
        Integer id);

    /**
     * GET /posts : Listing all resources
     *
     * @param userId Filter - this will return all the posts that belong to the user with specified id (optional)
     * @return A JSON array of posts (status code 200)
     */
    @Operation(
        operationId = "posts",
        summary = "Listing all resources",
        tags = "post",
        responses = @ApiResponse(responseCode = "200",
                                 description = "A JSON array of posts",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    array = @ArraySchema(schema = @Schema(implementation = Post.class)))))
    @GetMapping(path = "/posts",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Post>> posts(
        @Min(1)
        @Parameter(description = "Filter - this will return all the posts that belong to the user with specified id",
                   in = ParameterIn.QUERY)
        @Valid
        @RequestParam(required = false)
        Integer userId);


    /**
     * DELETE /posts/{id} : Deleting a resource
     *
     * @param id id of post in a post list (required)
     * @return resource will not be really updated on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "removePost",
        summary = "Deleting a resource",
        tags = "post",
        responses = @ApiResponse(responseCode = "200",
                                 description = "resource will not be really updated on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Object.class))))
    @DeleteMapping(path = "/posts/{id}",
                   produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Object> removePost(
        @Min(1)
        @PathVariable
        @Parameter(description = "id of post in a post list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * PUT /posts/{id} : Updating a resource
     * Important - resource will not be really updated on the server but it will be faked as if
     *
     * @param id   id of post in a post list (required)
     * @param post (required)
     * @return The server successfully processed the request, but is not returning any content (status code 204)
     */
    @Operation(
        operationId = "updatePost",
        summary = "Updating a resource",
        description = "Important - resource will not be really updated on the server but it will be faked as if",
        tags = "post",
        responses = @ApiResponse(responseCode = "204",
                                 description = "The server successfully processed the request, but is not returning any content"))
    @PutMapping(path = "/posts/{id}",
                consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updatePost(
        @Min(1)
        @PathVariable
        @Parameter(description = "id of post in a post list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @RequestBody
        @Parameter(required = true)
        Post post);
}
