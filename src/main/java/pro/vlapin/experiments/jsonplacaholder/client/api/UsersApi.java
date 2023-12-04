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
import pro.vlapin.experiments.jsonplacaholder.client.model.Album;
import pro.vlapin.experiments.jsonplacaholder.client.model.Post;
import pro.vlapin.experiments.jsonplacaholder.client.model.Todo;
import pro.vlapin.experiments.jsonplacaholder.client.model.User;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@Tag(name = "user", description = "the user API")
public interface UsersApi {

    /**
     * POST /users/{id}/albums : Create a album
     * Important - album will not be really created on the server but it will be faked as if
     *
     * @param id    (required)
     * @param album (required)
     * @return Album will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addAlbumToUser",
        summary = "Create a album",
        description = "Important - album will not be really created on the server but it will be faked as if",
        tags = {"user", "album"},
        responses = @ApiResponse(responseCode = "201",
                                 description = "Album will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Album.class))))
    @PostMapping(path = "/users/{id}/albums",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Album> addAlbumToUser(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @RequestBody
        @Parameter(required = true)
        Album album);

    /**
     * POST /users/{id}/posts : Create a post
     * Important - resource will not be really updated on the server but it will be faked as if
     *
     * @param id   (required)
     * @param post (required)
     * @return Post will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addPostToUser",
        summary = "Create a post",
        description = "Important - resource will not be really updated on the server but it will be faked as if",
        tags = {"user", "post"},
        responses = @ApiResponse(responseCode = "201",
                                 description = "Post will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Post.class))))
    @PostMapping(path = "/users/{id}/posts",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Post> addPostToUser(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Parameter(required = true)
        @Valid
        @RequestBody
        Post post);

    /**
     * POST /users/{id}/todos : Create a task to do
     * Important - task to do will not be really created on the server but it will be faked as if
     *
     * @param id   (required)
     * @param todo (required)
     * @return Task to do will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addTodoToUser",
        summary = "Create a task to do",
        description = "Important - task to do will not be really created on the server but it will be faked as if",
        tags = {"user", "todo"},
        responses = @ApiResponse(responseCode = "201",
                                 description = "Task to do will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Todo.class))))
    @PostMapping(path = "/users/{id}/todos",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Todo> addTodoToUser(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @RequestBody
        @Parameter(required = true)
        Todo todo);

    /**
     * POST /users : Create a user
     * Important - user will not be really created on the server but it will be faked as if
     *
     * @param user (required)
     * @return User will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addUser",
        summary = "Create a user",
        description = "Important - user will not be really created on the server but it will be faked as if",
        tags = "user",
        responses = @ApiResponse(responseCode = "201",
                                 description = "User will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = User.class))))
    @PostMapping(path = "/users",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<User> addUser(
        @Valid
        @RequestBody
        @Parameter(required = true)
        User user);

    /**
     * PATCH /users/{id} : Patching an task to do
     * Important! - task to do will not be really patched on the server but it will be faked as if
     *
     * @param id   Id of task to do in a tasks list (required)
     * @param user (optional)
     * @return User will not be really patched on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "mergeUser",
        summary = "Patching an task to do",
        description = "Important! - task to do will not be really patched on the server but it will be faked as if",
        tags = "user",
        responses = @ApiResponse(responseCode = "200",
                                 description = "User will not be really patched on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = User.class))))
    @PatchMapping(path = "/users/{id}",
                  produces = APPLICATION_JSON_VALUE,
                  consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<User> mergeUser(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of task to do in a tasks list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @Parameter
        @RequestBody(required = false)
        User user);

    /**
     * GET /users/{id} : User specified by it&#39;s id
     *
     * @param id (required)
     * @return User specified by it&#39;s id (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "pickUser",
        summary = "User specified by it's id",
        tags = "user",
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "User specified by it's id",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/users/{id}",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<User> pickUser(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * DELETE /users/{id} : Deleting a user
     * User will not be really deleted on the server but it will be faked as if
     *
     * @param id Id of user in a tasks list (required)
     * @return User will not be really deleted on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "removeUser",
        summary = "Deleting a user",
        description = "User will not be really deleted on the server but it will be faked as if",
        tags = "user",
        responses = @ApiResponse(responseCode = "200",
                                 description = "User will not be really deleted on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Object.class))))
    @DeleteMapping(path = "/users/{id}",
                   produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Object> removeUser(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of user in a tasks list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * PUT /users/{id} : Updating a user
     * Important - user will not be really updated on the server but it will be faked as if
     *
     * @param id   Id of user in a users list (required)
     * @param user (required)
     * @return The server successfully processed the request, but is not returning any content (status code 204)
     */
    @Operation(
        operationId = "updateUser",
        summary = "Updating a user",
        description = "Important - user will not be really updated on the server but it will be faked as if",
        tags = "user",
        responses = @ApiResponse(responseCode = "204",
                                 description = "The server successfully processed the request, but is not returning any content"))
    @PutMapping(path = "/users/{id}",
                consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateUser(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of user in a users list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @RequestBody
        @Parameter(required = true)
        User user);


    /**
     * GET /users/{id}/albums : Albums by owner user id
     *
     * @param id (required)
     * @return Albums by owner user id (status code 200)
     */
    @Operation(
        operationId = "userAlbums",
        summary = "Albums by owner user id",
        tags = {"user", "album"},
        responses = @ApiResponse(responseCode = "200",
                                 description = "Albums by owner user id",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    array = @ArraySchema(schema = @Schema(implementation = Album.class)))))
    @GetMapping(path = "/users/{id}/albums",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Album>> userAlbums(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * GET /users/{id}/posts : Posts of user, specified by it&#39;s id
     *
     * @param id (required)
     * @return Posts of user, specified by it&#39;s id (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "userPosts",
        summary = "Posts of user, specified by it's id",
        tags = {"user", "post"},
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "Posts of user, specified by it's id",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = Post.class)))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/users/{id}/posts",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Post>> userPosts(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * GET /users/{id}/todos : Tasks to do for user specified by it&#39;s id
     *
     * @param id (required)
     * @return Tasks to do for user specified by it&#39;s id (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "userTodos",
        summary = "Tasks to do for user specified by it's id",
        tags = {"user", "todo"},
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "Tasks to do for user specified by it's id",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = Todo.class)))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/users/{id}/todos",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Todo>> userTodos(
        @Min(1)
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        @PathVariable
        Integer id);


    /**
     * GET /users : All users
     *
     * @return All users (status code 200)
     */
    @Operation(
        operationId = "users",
        summary = "All users",
        tags = "user",
        responses = @ApiResponse(responseCode = "200",
                                 description = "All users",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    array = @ArraySchema(schema = @Schema(implementation = User.class)))))
    @GetMapping(path = "/users",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<User>> users();
}
