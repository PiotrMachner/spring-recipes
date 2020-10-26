package edu.machinery.springrecipes.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifecycleDemonstratingBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private LifecycleDemonstratingBeanDependency dependency;

    public LifecycleDemonstratingBean() {
        System.out.println("Constructor");
    }

    @Autowired
    public void setDependency(LifecycleDemonstratingBeanDependency dependency) {
        System.out.println("setDependency");
        this.dependency = dependency;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware::setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware::setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware::setApplicationContext");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean::destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean::afterPropertiesSet");
    }

    // does not work for some reason
    @PostConstruct
    public void customPostConstruct() {
        System.out.println("customPostConstruct");
    }


    @PreDestroy
    public void customPreDestroy() {
        System.out.println("customPreDestroy");
    }
}
