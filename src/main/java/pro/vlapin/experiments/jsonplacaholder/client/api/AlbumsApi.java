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
import pro.vlapin.experiments.jsonplacaholder.client.model.Album;
import pro.vlapin.experiments.jsonplacaholder.client.model.Photo;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@Tag(name = "album",
     description = "the album API")
public interface AlbumsApi {

  /**
   * POST /albums : Create a album
   * Important - album will not be really created on the server but it will be faked as if
   *
   * @param album (required)
   * @return Album will not be really created on the server but it will be faked as if (status code 201)
   */
  @Operation(
      operationId = "addAlbum",
      summary = "Create a album",
      description = "Important - album will not be really created on the server but it will be faked as if",
      tags = "album",
      responses = {
          @ApiResponse(responseCode = "201",
                       description = "Album will not be really created on the server but it will be faked as if",
                       content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                          schema = @Schema(implementation = Album.class)))})
  @PostMapping(path = "/albums",
               produces = APPLICATION_JSON_VALUE,
               consumes = APPLICATION_JSON_VALUE)
  ResponseEntity<Album> addAlbum(
      @Parameter(name = "Album", description = "", required = true) @Valid @RequestBody Album album);


  /**
   * POST /albums/{id}/photos : Create a photo
   * Important - photo will not be really created on the server but it will be faked as if
   *
   * @param id    (required)
   * @param photo (required)
   * @return Photo will not be really created on the server but it will be faked as if (status code 201)
   */
  @Operation(
      operationId = "addPhotoToAlbum",
      summary = "Create a photo",
      description = "Important - photo will not be really created on the server but it will be faked as if",
      tags = {"album", "photo"},
      responses = @ApiResponse(responseCode = "201",
                               description = "Photo will not be really created on the server but it will be faked as if",
                               content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                  schema = @Schema(implementation = Photo.class))))
  @PostMapping(path = "/albums/{id}/photos",
               produces = APPLICATION_JSON_VALUE,
               consumes = APPLICATION_JSON_VALUE)
  ResponseEntity<Photo> addPhotoToAlbum(
      @Min(1)
      @PathVariable
      @Parameter(description = "",
                 required = true,
                 in = ParameterIn.PATH)
      Integer id,

      @Valid
      @RequestBody
      @Parameter(required = true)
      Photo photo);

  /**
   * GET /albums/{id}/photos
   *
   * @param id (required)
   * @return photos, belongs to album specified by id (status code 200)
   * or No Content - empty json array (status code 404)
   */
  @Operation(
      operationId = "albumPhotos",
      tags = {"album", "photo"},
      responses = {
          @ApiResponse(responseCode = "200",
                       description = "photos, belongs to album specified by id",
                       content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                          array = @ArraySchema(schema = @Schema(implementation = Photo.class)))),
          @ApiResponse(responseCode = "404",
                       description = "No Content - empty json array",
                       content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                          schema = @Schema(implementation = Object.class)))})
  @GetMapping(path = "/albums/{id}/photos",
              produces = APPLICATION_JSON_VALUE)
  ResponseEntity<List<Photo>> albumPhotos(
      @Min(1)
      @PathVariable
      @Parameter(required = true,
                 in = ParameterIn.PATH)
      Integer id);

  /**
   * GET /albums : Albums of users
   *
   * @param postId Post id for filtering (optional)
   * @return All albums of all the users (status code 200)
   */
  @Operation(
      operationId = "albums",
      summary = "Albums of users",
      tags = {"album"},
      responses = @ApiResponse(responseCode = "200",
                               description = "All albums of all the users",
                               content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                  array = @ArraySchema(schema = @Schema(implementation = Album.class)))))
  @GetMapping(path = "/albums",
              produces = APPLICATION_JSON_VALUE)
  ResponseEntity<List<Album>> albums(
      @Valid
      @Min(1)
      @RequestParam(required = false)
      @Parameter(description = "Post id for filtering",
                 in = ParameterIn.QUERY)
      Integer postId);


  /**
   * PATCH /albums/{id} : Patching an album
   * Important! - album will not be really patched on the server but it will be faked as if
   *
   * @param id Id of album in a albums list (required)
   * @return Album will not be really patched on the server but it will be faked as if (status code 200)
   */
  @Operation(
      operationId = "mergeAlbum",
      summary = "Patching an album",
      description = "Important! - album will not be really patched on the server but it will be faked as if",
      tags = "album",
      responses = @ApiResponse(responseCode = "200",
                               description = "Album will not be really patched on the server but it will be faked as if",
                               content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                  schema = @Schema(implementation = Album.class))))
  @PatchMapping(path = "/albums/{id}",
                produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Album> mergeAlbum(
      @Min(1)
      @PathVariable
      @Parameter(description = "Id of album in a albums list",
                 required = true,
                 in = ParameterIn.PATH)
      Integer id);

  /**
   * GET /albums/{id} : Album by id
   *
   * @param id (required)
   * @return Album, specified by id (status code 200)
   * or No Content - empty json array (status code 404)
   */
  @Operation(
      operationId = "pickAlbum",
      summary = "Album by id",
      tags = "album",
      responses = {
          @ApiResponse(responseCode = "200",
                       description = "Album, specified by id",
                       content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                          schema = @Schema(implementation = Album.class))),
          @ApiResponse(responseCode = "404",
                       description = "No Content - empty json array",
                       content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                          schema = @Schema(implementation = Object.class)))})
  @GetMapping(path = "/albums/{id}",
              produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Album> pickAlbum(
      @Min(1)
      @PathVariable
      @Parameter(required = true,
                 in = ParameterIn.PATH)
      Integer id);

  /**
   * DELETE /albums/{id} : Deleting a album
   * Album will not be really deleted on the server but it will be faked as if
   *
   * @param id Id of album in a albums list (required)
   * @return Album will not be really deleted on the server but it will be faked as if (status code 200)
   */
  @Operation(
      operationId = "removeAlbum",
      summary = "Deleting a album",
      description = "Album will not be really deleted on the server but it will be faked as if",
      tags = "album",
      responses = @ApiResponse(responseCode = "200",
                               description = "Album will not be really deleted on the server but it will be faked as if",
                               content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                                  schema = @Schema(implementation = Object.class))))
  @DeleteMapping(path = "/albums/{id}",
                 produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Object> removeAlbum(
      @Min(1)
      @PathVariable
      @Parameter(description = "Id of album in a albums list",
                 required = true,
                 in = ParameterIn.PATH)
      Integer id);


  /**
   * PUT /albums/{id} : Updating a album
   * Important - album will not be really updated on the server but it will be faked as if
   *
   * @param id    Id of album in a albums list (required)
   * @param album (required)
   * @return The server successfully processed the request, but is not returning any content (status code 204)
   */
  @Operation(
      operationId = "updateAlbum",
      summary = "Updating a album",
      description = "Important - album will not be really updated on the server but it will be faked as if",
      tags = "album",
      responses = @ApiResponse(responseCode = "204",
                               description = "The server successfully processed the request, but is not returning any content"))
  @PutMapping(path = "/albums/{id}",
              consumes = APPLICATION_JSON_VALUE)
  ResponseEntity<Void> updateAlbum(
      @Min(1)
      @PathVariable
      @Parameter(description = "Id of album in a albums list",
                 required = true,
                 in = ParameterIn.PATH)
      Integer id,

      @Valid
      @Parameter(required = true)
      @RequestBody
      Album album);
}
