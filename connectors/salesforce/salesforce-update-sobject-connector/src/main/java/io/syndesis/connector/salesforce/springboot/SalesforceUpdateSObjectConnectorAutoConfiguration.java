package io.syndesis.connector.salesforce.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.PostConstruct;
import io.syndesis.connector.salesforce.SalesforceUpdateSObjectComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.component.connector.ConnectorCustomizer;
import org.apache.camel.spi.HasId;
import org.apache.camel.spring.boot.util.CamelPropertiesHelper;
import org.apache.camel.spring.boot.util.HierarchicalPropertiesEvaluator;
import org.apache.camel.util.IntrospectionSupport;
import org.apache.camel.util.ObjectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Generated by camel-connector-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.connector.SpringBootAutoConfigurationMojo")
@Configuration
@ConditionalOnBean(type = "org.apache.camel.spring.boot.CamelAutoConfiguration")
@AutoConfigureAfter(name = "org.apache.camel.spring.boot.CamelAutoConfiguration")
@EnableConfigurationProperties(SalesforceUpdateSObjectConnectorConfiguration.class)
public class SalesforceUpdateSObjectConnectorAutoConfiguration {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SalesforceUpdateSObjectConnectorAutoConfiguration.class);
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private CamelContext camelContext;
    @Autowired
    private SalesforceUpdateSObjectConnectorConfiguration configuration;
    @Autowired(required = false)
    private List<ConnectorCustomizer<SalesforceUpdateSObjectComponent>> customizers;

    @Lazy
    @Bean(name = "salesforce-update-sobject-component")
    @ConditionalOnClass(CamelContext.class)
    @ConditionalOnMissingBean
    public SalesforceUpdateSObjectComponent configureSalesforceUpdateSObjectComponent()
            throws Exception {
        SalesforceUpdateSObjectComponent connector = new SalesforceUpdateSObjectComponent();
        connector.setCamelContext(camelContext);
        Map<String, Object> parameters = new HashMap<>();
        IntrospectionSupport.getProperties(configuration, parameters, null,
                false);
        CamelPropertiesHelper.setCamelProperties(camelContext, connector,
                parameters, false);
        connector.setOptions(parameters);
        if (ObjectHelper.isNotEmpty(customizers)) {
            for (ConnectorCustomizer<SalesforceUpdateSObjectComponent> customizer : customizers) {
                boolean useCustomizer = (customizer instanceof HasId)
                        ? HierarchicalPropertiesEvaluator
                                .evaluate(
                                        applicationContext.getEnvironment(),
                                        "camel.connector.customizer",
                                        "camel.connector.salesforce-update-sobject.customizer",
                                        ((HasId) customizer).getId())
                        : HierarchicalPropertiesEvaluator
                                .evaluate(applicationContext.getEnvironment(),
                                        "camel.connector.customizer",
                                        "camel.connector.salesforce-update-sobject.customizer");
                if (useCustomizer) {
                    LOGGER.debug("Configure connector {}, with customizer {}",
                            connector, customizer);
                    customizer.customize(connector);
                }
            }
        }
        return connector;
    }

    @PostConstruct
    public void postConstructSalesforceUpdateSObjectComponent() {
        Map<String, Object> parameters = new HashMap<>();
        for (Map.Entry<String, SalesforceUpdateSObjectConnectorConfigurationCommon> entry : configuration
                .getConfigurations().entrySet()) {
            parameters.clear();
            SalesforceUpdateSObjectComponent connector = new SalesforceUpdateSObjectComponent();
            connector.setCamelContext(camelContext);
            try {
                IntrospectionSupport.getProperties(entry.getValue(),
                        parameters, null, false);
                CamelPropertiesHelper.setCamelProperties(camelContext,
                        connector, parameters, false);
                connector.setOptions(parameters);
                if (ObjectHelper.isNotEmpty(customizers)) {
                    for (ConnectorCustomizer<SalesforceUpdateSObjectComponent> customizer : customizers) {
                        boolean useCustomizer = (customizer instanceof HasId)
                                ? HierarchicalPropertiesEvaluator.evaluate(
                                        applicationContext.getEnvironment(),
                                        "camel.connector.customizer",
                                        "camel.connector.salesforce-update-sobject."
                                                + entry.getKey()
                                                + ".customizer",
                                        ((HasId) customizer).getId())
                                : HierarchicalPropertiesEvaluator.evaluate(
                                        applicationContext.getEnvironment(),
                                        "camel.connector.customizer",
                                        "camel.connector.salesforce-update-sobject."
                                                + entry.getKey()
                                                + ".customizer");
                        if (useCustomizer) {
                            LOGGER.debug(
                                    "Configure connector {}, with customizer {}",
                                    connector, customizer);
                            customizer.customize(connector);
                        }
                    }
                }
                camelContext.addComponent(entry.getKey(), connector);
            } catch (Exception e) {
                throw new BeanCreationException(entry.getKey(), e.getMessage(),
                        e);
            }
        }
    }
}