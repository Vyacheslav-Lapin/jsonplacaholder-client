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
import pro.vlapin.experiments.jsonplacaholder.client.model.Photo;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@Tag(name = "photo", description = "the photo API")
public interface PhotosApi {

    /**
     * POST /photos : Create a photo
     * Important - photo will not be really created on the server but it will be faked as if
     *
     * @param photo (required)
     * @return Photo will not be really created on the server but it will be faked as if (status code 201)
     */
    @Operation(
        operationId = "addPhoto",
        summary = "Create a photo",
        description = "Important - photo will not be really created on the server but it will be faked as if",
        tags = "photo",
        responses = @ApiResponse(responseCode = "201",
                                 description = "Photo will not be really created on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Photo.class))))
    @PostMapping(
        path = "/photos",
        produces = APPLICATION_JSON_VALUE,
        consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Photo> addPhoto(
        @Valid
        @RequestBody
        @Parameter(required = true)
        Photo photo);

    /**
     * PATCH /photos/{id} : Patching an album
     * Important! - photo will not be really patched on the server but it will be faked as if
     *
     * @param id Id of photo in a photos list (required)
     * @return Photo will not be really patched on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "mergePhoto",
        summary = "Patching an album",
        description = "Important! - photo will not be really patched on the server but it will be faked as if",
        tags = "photo",
        responses = @ApiResponse(responseCode = "200",
                                 description = "Photo will not be really patched on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Photo.class))))
    @PatchMapping(path = "/photos/{id}",
                  produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Photo> mergePhoto(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of photo in a photos list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * GET /photos : Photos of user albums
     *
     * @param albumId Album id for filtering (optional)
     * @return Photos of user albums (status code 200)
     */
    @Operation(
        operationId = "photos",
        summary = "Photos of user albums",
        tags = "photo",
        responses = @ApiResponse(responseCode = "200",
                                 description = "Photos of user albums",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    array = @ArraySchema(schema = @Schema(implementation = Photo.class)))))
    @GetMapping(path = "/photos",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Photo>> photos(
        @Valid
        @Min(1)
        @RequestParam(required = false)
        @Parameter(description = "Album id for filtering",
                   in = ParameterIn.QUERY)
        Integer albumId);

    /**
     * GET /photos/{id} : Photo by it&#39;s id
     *
     * @param id id of photo (required)
     * @return Photo specified by given id (status code 200)
     * or No Content - empty json array (status code 404)
     */
    @Operation(
        operationId = "pickPhoto",
        summary = "Photo by it's id",
        tags = "photo",
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "Photo specified by given id",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Photo.class))),
            @ApiResponse(responseCode = "404",
                         description = "No Content - empty json array",
                         content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Object.class)))})
    @GetMapping(path = "/photos/{id}",
                produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Photo> pickPhoto(
        @Min(1)
        @PathVariable
        @Parameter(description = "id of photo",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id);

    /**
     * DELETE /photos/{id} : Deleting a photo
     * Photo will not be really deleted on the server but it will be faked as if
     *
     * @param id Id of photo in a photos list (required)
     * @return Photo will not be really deleted on the server but it will be faked as if (status code 200)
     */
    @Operation(
        operationId = "removePhoto",
        summary = "Deleting a photo",
        description = "Photo will not be really deleted on the server but it will be faked as if",
        tags = "photo",
        responses = @ApiResponse(responseCode = "200",
                                 description = "Photo will not be really deleted on the server but it will be faked as if",
                                 content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = Object.class))))
    @DeleteMapping(path = "/photos/{id}",
                   produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Object> removePhoto(
        @Min(1)
        @Parameter(name = "id",
                   description = "Id of photo in a photos list",
                   required = true,
                   in = ParameterIn.PATH)
        @PathVariable Integer id);

    /**
     * PUT /photos/{id} : Updating a photo
     * Important - photo will not be really updated on the server but it will be faked as if
     *
     * @param id    Id of photo in a photos list (required)
     * @param photo (required)
     * @return The server successfully processed the request, but is not returning any content (status code 204)
     */
    @Operation(
        operationId = "updatePhoto",
        summary = "Updating a photo",
        description = "Important - photo will not be really updated on the server but it will be faked as if",
        tags = "photo",
        responses = @ApiResponse(responseCode = "204",
                                 description = "The server successfully processed the request, but is not returning any content"))
    @PutMapping(path = "/photos/{id}",
                consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updatePhoto(
        @Min(1)
        @PathVariable
        @Parameter(description = "Id of photo in a photos list",
                   required = true,
                   in = ParameterIn.PATH)
        Integer id,

        @Valid
        @RequestBody
        @Parameter(required = true)
        Photo photo);
}
