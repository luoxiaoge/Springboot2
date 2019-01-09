import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableConfigurationProperties(value = ApiInfoAutoProperties.class)
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", value = "enable", matchIfMissing = true)
public class SwaggerApplication {

    @Autowired
    ApiInfoAutoProperties apiInfoService;

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiInfoService.getTitle())
                .version(apiInfoService.getVersion())
                .description(apiInfoService.getDescription())
                .contact(new Contact(apiInfoService.getUserName(), apiInfoService.getUserUrl(), apiInfoService.getUserEmail()))
                .termsOfServiceUrl(apiInfoService.getServiceUrl())
                .build();
    }

    @Bean
    public Docket getApiInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("openApi")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }


}
