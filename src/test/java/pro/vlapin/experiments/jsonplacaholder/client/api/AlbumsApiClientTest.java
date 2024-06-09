package pro.vlapin.experiments.jsonplacaholder.client.api;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.InstanceOfAssertFactories.*;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import pro.vlapin.experiments.jsonplacaholder.client.JsonPlaceholderClientConfig;
import pro.vlapin.experiments.jsonplacaholder.client.model.Album;
import pro.vlapin.experiments.jsonplacaholder.client.model.AlbumAssert;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringBootTest(classes = JsonPlaceholderClientConfig.class)
class AlbumsApiClientTest {

  private static final int SIZE = 100;
  private static final int ID = 17;
  private static final String TITLE = "aut minima voluptatem ut velit";
  private static final int USER_ID = 2;

  AlbumsApiClient client;

  @Test
  @DisplayName("Get album list endpoint works correctly")
  void getAlbumListEndpointWorksCorrectlyTest() {

    // given
    val albumListResponseEntity = client.albums(null);

    // when
    assertThat(albumListResponseEntity)
        // then
        .isNotNull()
        .matches(__ -> albumListResponseEntity.getStatusCode().is2xxSuccessful())
        .matches(__ -> albumListResponseEntity.getStatusCode().value() == 200)
        .extracting(HttpEntity::getBody, list(Album.class))
        .isNotEmpty()
        .hasSize(SIZE);
  }

  @Test
  @DisplayName("Get album endpoint works correctly")
  void getAlbumEndpointWorksCorrectlyTest() {

    // given
    val albumResponseEntity = client.pickAlbum(ID);

    // when
    assertThat(albumResponseEntity)
        // then
        .isNotNull()
        .matches(__ -> albumResponseEntity.getStatusCode().is2xxSuccessful())
        .matches(__ -> albumResponseEntity.getStatusCode().value() == 200);

    // when
    AlbumAssert.assertThat(albumResponseEntity.getBody())
        // then
        .isNotNull()
        .hasId(ID)
        .hasTitle(TITLE)
        .hasUserId(USER_ID);
  }
}
