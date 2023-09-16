package dev.simonverhoeven.sgd;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {
//    private static final Logger log = LoggerFactory.getLogger(GraphQLConfig.class);


    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return runtimeWiringConfigurer -> runtimeWiringConfigurer
                .scalar(ExtendedScalars.Date);
    }

//    @Bean
//    GraphQlSourceBuilderCustomizer inspectionCustomizer() {
//        return schemaResourceBuilder -> schemaResourceBuilder.inspectSchemaMappings(reportConsumer -> log.info(reportConsumer.toString()));
//    }
}
