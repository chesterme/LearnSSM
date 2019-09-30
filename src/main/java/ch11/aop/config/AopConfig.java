package ch11.aop.config;

import ch11.aop.aspect.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // 启用AspectJ框架的自动代理，Spring才会生成动态代理对象，进而可以使用AOP
@ComponentScan("ch11.aop")
public class AopConfig {

    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }

}
