package com.ust.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringCloudConfiguration {

	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder)
	{
		return
				builder
				.routes()
				.route("helloservice", r->r.path("/rest/service/**")
					.filters(f->f.addResponseHeader("X-Response-Header","World"))
					.uri("http://localhost:8071"))
				.build();
	}
}
