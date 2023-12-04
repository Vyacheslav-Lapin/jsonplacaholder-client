package pro.vlapin.experiments.jsonplacaholder.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import pro.vlapin.experiments.jsonplacaholder.client.config.ClientConfiguration;

@FeignClient(name="${posts.name:posts}",
             url="${posts.url:https://jsonplaceholder.typicode.com}",
             configuration = ClientConfiguration.class)
public interface PostsApiClient extends PostsApi {
}
