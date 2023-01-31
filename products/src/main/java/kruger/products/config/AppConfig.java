//package kruger.products.config;
//
//import jakarta.ws.rs.HttpMethod;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AppConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOriginPatterns("*").allowCredentials(true)
//                .allowedMethods(
//                        HttpMethod.GET,
//                        HttpMethod.OPTIONS,
//                        HttpMethod.POST,
//                        HttpMethod.DELETE,
//                        HttpMethod.PUT)
//                .maxAge(3600);
//    }
//}