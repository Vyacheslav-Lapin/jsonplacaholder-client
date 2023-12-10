package pro.vlapin.experiments.jsonplacaholder.client.api;

import static pro.vlapin.experiments.jsonplacaholder.client.model.PostAssert.assertThat;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.vlapin.experiments.jsonplacaholder.client.JsonPlaceholderClientConfig;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringBootTest(classes = JsonPlaceholderClientConfig.class)
class PostsApiClientTest {

  static final String TITLE = "sed ab est est";
  static final int USER_ID = 6;
  static final String BODY = """
      at pariatur consequuntur earum quidem
      quo est laudantium soluta voluptatem
      qui ullam et est
      et cum voluptas voluptatum repellat est""";
  static final int ID = 57;

  PostsApiClient postsApiClient;

  @Test
  @DisplayName("Get method works correctly")
  void get() {
    Assertions.assertThat(postsApiClient.posts(null).getBody())
        .isNotNull()
        .isNotEmpty()
        .hasSize(100);
  }

  @Test
  @DisplayName("Get one post method works correctly")
  void getOnePostMethodWorksCorrectlyTest() {
    assertThat(postsApiClient.pickPost(ID).getBody())
        .isNotNull()
        .hasId(ID) // .matches(post -> post.getId() == ID, "id is equals")
        .hasTitle(TITLE) // .matches(post -> post.getTitle() == TITLE, "title is equals")
        .hasUserId(USER_ID) // .matches(post -> post.getUserId() == USER_ID, "userId is equals")
        .hasBody(BODY); // .matches(post -> post.getBody().equals(BODY), "body is equals");
  }
}
