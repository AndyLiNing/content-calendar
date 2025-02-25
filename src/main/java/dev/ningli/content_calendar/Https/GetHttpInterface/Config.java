package dev.ningli.content_calendar.Https.GetHttpInterface;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class Config {

    @Bean
    PostClientService postClientService() {

//        JdkClientHttpRequestFactory jdkClientHttpRequestFactory = new JdkClientHttpRequestFactory();
//        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();

//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("my.host.com", 8080));
//        simpleClientHttpRequestFactory.setProxy(proxy);

        RestClient restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .requestFactory(simpleClientHttpRequestFactory)
                .build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(PostClientService.class);
    }
}
