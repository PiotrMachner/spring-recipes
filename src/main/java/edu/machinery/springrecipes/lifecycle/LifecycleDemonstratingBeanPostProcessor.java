package edu.machinery.springrecipes.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemonstratingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleDemonstratingBean) {
            System.out.println("LifecycleDemonstratingBeanPostProcessor::postProcessBeforeInitialization - " + beanName);
        }

        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleDemonstratingBean) {
            System.out.println("LifecycleDemonstratingBeanPostProcessor::postProcessAfterInitialization - " + beanName);
        }
        return null;
    }
}
