/***********************************************/
//             _               _____           //
//            | |             |  _  \          //
//          __| | ___   __ _  | | \  \         //
//         / _` |/ _ \ / _` | | |  \  \        //
//        | (_| | (_) | (_| | | |__/   |       //
//         \__,_|\___/ \__, | |______/         //
//                      __/ |                  //
//                     |___/                   //
/***********************************************/
package be.steven.d.dog.blogapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@EntityScan(basePackages = "be.steven.d.dog.blogapp.model")
@ComponentScan(basePackages = "be.steven.d.dog.blogapp.ctrl")
@EnableJpaRepositories(basePackages = "be.steven.d.dog.blogapp.repo")
public class BlogappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogappApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

}
