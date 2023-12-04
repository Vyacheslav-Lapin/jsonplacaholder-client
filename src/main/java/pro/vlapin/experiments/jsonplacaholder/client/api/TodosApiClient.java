package pro.vlapin.experiments.jsonplacaholder.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import pro.vlapin.experiments.jsonplacaholder.client.config.ClientConfiguration;

@FeignClient(name="${todos.name:todos}",
             url="${todos.url:https://jsonplaceholder.typicode.com}",
             configuration = ClientConfiguration.class)
public interface TodosApiClient extends TodosApi {
}
