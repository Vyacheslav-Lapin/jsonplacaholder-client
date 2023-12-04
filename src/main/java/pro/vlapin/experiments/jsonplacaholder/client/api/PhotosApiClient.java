package pro.vlapin.experiments.jsonplacaholder.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import pro.vlapin.experiments.jsonplacaholder.client.config.ClientConfiguration;

@FeignClient(name="${photos.name:photos}",
             url="${photos.url:https://jsonplaceholder.typicode.com}",
             configuration = ClientConfiguration.class)
public interface PhotosApiClient extends PhotosApi {
}
