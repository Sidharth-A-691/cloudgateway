package com.finance.gateway;

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
				.route("userService", r->r.path("/finwiz/**")
					.filters(f->f.addResponseHeader("X-Response-Header","user"))
					.uri("http://localhost:8099"))
				.route("transactionService",r->r.path("/finwiz/**")
					.filters(f->f.addResponseHeader("X-Response-Header","transaction"))
					.uri("http://localhost:8000"))
				.route("mailService",r->r.path("/finwiz/**")
						.filters(f->f.addResponseHeader("X-Response-Header","mail"))
						.uri("http://localhost:6000"))
				.route("goalService",r->r.path("/finwiz/**")
						.filters(f->f.addResponseHeader("X-Response-Header","goal"))
						.uri("http://localhost:8300"))
				.build();
	}
}
