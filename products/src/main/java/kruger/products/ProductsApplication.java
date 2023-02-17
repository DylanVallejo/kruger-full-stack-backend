package kruger.products;

import kruger.products.Audit.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableDiscoveryClient
public class ProductsApplication{

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("*").allowedHeaders("*");
//			}
//		};
//	}

//	@Bean
//	public WebMvcConfigurer corsMappingConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				WebConfigProperties.Cors cors = webConfigProperties.getCors();
//				registry.addMapping("/**")
//						.allowedOrigins(cors.getAllowedOrigins())
//						.allowedMethods(cors.getAllowedMethods())
//						.maxAge(cors.getMaxAge())
//						.allowedHeaders(cors.getAllowedHeaders())
//						.exposedHeaders(cors.getExposedHeaders());
//			}
//		};
//	}



	

}
