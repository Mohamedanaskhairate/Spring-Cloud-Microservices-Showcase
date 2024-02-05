package org.sid.gatewayservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	//@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

		return builder.routes()
				.route("r1", r -> r.path("/clients/**").uri("lb://CLIENT-SERVICE"))
				.route("r2", r -> r.path("/produits/**").uri("lb://PRODUIT-SERVICE"))
				.build();
	}
	@Bean
	DiscoveryClientRouteDefinitionLocator gatewayRoutesDynamic(ReactiveDiscoveryClient rdc , DiscoveryLocatorProperties dlp){
		return  new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}
}
//---> dynamic Route , Consulter les services via le service proxy
//http://localhost:8888/PRODUIT-SERVICE/produits
//http://localhost:8888/CLIENT-SERVICE/clients