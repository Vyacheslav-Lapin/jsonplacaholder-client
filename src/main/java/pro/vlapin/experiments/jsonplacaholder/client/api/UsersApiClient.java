package pro.vlapin.experiments.jsonplacaholder.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import pro.vlapin.experiments.jsonplacaholder.client.config.ClientConfiguration;

@FeignClient(name="${users.name:users}",
             url="${users.url:https://jsonplaceholder.typicode.com}",
             configuration = ClientConfiguration.class)
public interface UsersApiClient extends UsersApi {
}
