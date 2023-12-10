package pro.vlapin.experiments.jsonplacaholder.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiKeyRequestInterceptor implements RequestInterceptor {

  @NonNull String location;
  @NonNull String name;
  @NonNull String value;

  @Override
  public void apply(RequestTemplate requestTemplate) {
    switch (location) {
      case "header" -> requestTemplate.header(name, value);
      case "query" -> requestTemplate.query(name, value);
      default -> throw new IllegalStateException("Unexpected value: " + location);
    }
  }

}
