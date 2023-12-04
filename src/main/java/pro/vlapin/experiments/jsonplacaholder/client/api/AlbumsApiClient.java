package pro.vlapin.experiments.jsonplacaholder.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import pro.vlapin.experiments.jsonplacaholder.client.config.ClientConfiguration;

@FeignClient(name="${albums.name:albums}",
             url="${albums.url:https://jsonplaceholder.typicode.com}",
             configuration = ClientConfiguration.class)
public interface AlbumsApiClient extends AlbumsApi {
}
