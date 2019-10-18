package ch10.pojo;

import org.springframework.context.annotation.ComponentScan;

/**
 * 通知Spring IoC扫描组件
 */

//@ComponentScan(basePackageClasses = {Role.class, RoleService.class})
@ComponentScan(basePackages = {"ch10.pojo", "ch10.service", "ch10.controller"})
public class PojoConfig {
}
