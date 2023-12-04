package pro.vlapin.experiments.jsonplacaholder.client.api;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.vlapin.experiments.jsonplacaholder.client.JsonPlaceholderClientConfig;

import static org.assertj.core.api.Assertions.*;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringBootTest(classes = JsonPlaceholderClientConfig.class)
class PostsApiClientTest {

  int id = 57;
  PostsApiClient postsApiClient;

  @Test
  @DisplayName("Get method works correctly")
  void get() {
    assertThat(postsApiClient.posts(null).getBody())
        .isNotNull()
        .isNotEmpty()
        .hasSize(100);
  }

  @Test
  @DisplayName("Get one post method works correctly")
  void getOnePostMethodWorksCorrectlyTest() {
    assertThat(postsApiClient.pickPost(id).getBody())
        .isNotNull()
        .matches(post -> post.id() == id, "id is equals")
        .matches(post -> post.body().equals("""
                                            at pariatur consequuntur earum quidem
                                            quo est laudantium soluta voluptatem
                                            qui ullam et est
                                            et cum voluptas voluptatum repellat est"""),
                 "body is equals");
  }
}
