package pro.vlapin.experiments.jsonplacaholder.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import pro.vlapin.experiments.jsonplacaholder.client.config.ClientConfiguration;

@FeignClient(name="${comments.name:comments}",
             url="${comments.url:https://jsonplaceholder.typicode.com}",
             configuration = ClientConfiguration.class)
public interface CommentsApiClient extends CommentsApi {
}
