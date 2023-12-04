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
import pro.vlapin.experiments.jsonplacaholder.client.model.Todo;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@Tag(name = "todo", description = "the todo API")
public interface TodosApi {

    /**
     * POST /todos : Create a task to do
     * Important - task to do will not be really created on the server but it will be faked as if
     *
     * @param todo (required)
     * @return Task to do will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addTodo",
        summary = "Create a task to do",
        description = "Important - task to do will not be really created on the server but it will be faked as if",
        tags = "todo",
        responses = @ApiResponse(responseCode = "201",
                                 description = "Task to do will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Todo.class))))
    @PostMapping(path = "/todos",
                 produces = APPLICATION_JSON_VALUE,
                 consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Todo> addTodo(
        @Valid
        @RequestBody
        @Parameter(required = true)
        Todo todo);

    /**
     * PATCH /todos/{id} : Patching an task to do
     * Important! - task to do will not be really patched on the server but it will be faked as if
     *
     * @param id Id of task to do in a tasks list (required)
     * @return Task to do will not be really patched on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "mergeTodo",
        summary = "Patching an task to do",
        description = "Important! - task to do will not be really patched on the server but it will be faked as if",
        tags = "todo",
        responses = @ApiResponse(responseCode = "200",
                                 description = "Task to do will not be really patched on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Todo.class))))
    @PatchMapping(path = "/todos/{id}",
                  produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Todo> mergeTodo(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of task to do in a tasks list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * GET /todos/{id} : Task to do, specified by it&#39;s id
     *
     * @param id (required)
     * @return OK. Task to do (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "pickTodo",
        summary = "Task to do, specified by it's id",
        tags = "todo",
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "OK. Task to do",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Todo.class))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/todos/{id}",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Todo> pickTodo(
        @Min(1)
        @PathVariable
        @Parameter(required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * DELETE /todos/{id} : Deleting a task to do
     * Task to do will not be really deleted on the server but it will be faked as if
     *
     * @param id Id of task to do in a tasks list (required)
     * @return Task to do will not be really deleted on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "removeTodo",
        summary = "Deleting a task to do",
        description = "Task to do will not be really deleted on the server but it will be faked as if",
        tags = "todo",
        responses = @ApiResponse(responseCode = "200",
                                 description = "Task to do will not be really deleted on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Object.class))))
    @DeleteMapping(path = "/todos/{id}",
                   produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Object> removeTodo(
        @Min(1)
        @PathVariable
        @Parameter(name = "id",
                   description = "Id of task to do in a tasks list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * GET /todos : Tasks to do of all the users or of concrete user if using filter parameter
     *
     * @param userId (optional)
     * @return JSON array of todo entities (status code 200)
     */
    @Operation(
        operationId = "todos",
        summary = "Tasks to do of all the users or of concrete user if using filter parameter",
        tags = "todo",
        responses = @ApiResponse(responseCode = "200",
                                 description = "JSON array of todo entities",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    array = @ArraySchema(schema = @Schema(implementation = Todo.class)))))
    @GetMapping(path = "/todos",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Todo>> todos(
        @Valid
        @Min(1)
        @RequestParam(required = false)
        @Parameter(name = "userId",
                   in = ParameterIn.QUERY)
        Integer userId);


    /**
     * PUT /todos/{id} : Updating a task to do
     * Important - task to do will not be really updated on the server but it will be faked as if
     *
     * @param id   Id of task to do in a photos list (required)
     * @param todo (required)
     * @return The server successfully processed the request, but is not returning any content (status code 204)
     */
    @Operation(
        operationId = "updateTodo",
        summary = "Updating a task to do",
        description = "Important - task to do will not be really updated on the server but it will be faked as if",
        tags = "todo",
        responses = @ApiResponse(responseCode = "204",
                                 description = "The server successfully processed the request, but is not returning any content"))
    @PutMapping(path = "/todos/{id}",
                consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateTodo(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of task to do in a photos list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Parameter(required = true)
        @Valid
        @RequestBody
        Todo todo);
}
