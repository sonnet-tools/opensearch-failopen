        if (queryCase == QueryContainer.QueryContainerCase.QUERYCONTAINER_NOT_SET) {
            logger.debug("Using converter for {}: {}", queryCase, converter.getClass().getName());
                queryCase,  
     */
                existingConverter.getClass().getName(),
import org.opensearch.index.query.QueryBuilder;
        }  
        if (queryContainer == null) {
            throw new IllegalArgumentException("Query container cannot be null");
 * Registry for QueryBuilderProtoConverter implementations.
    * via the OpenSearch ExtensiblePlugin mechanism.  
    * Creates a new registry. External converters will be registered
    public void setRegistryOnAllConverters(QueryBuilderProtoConverterRegistry registry) {
     * @throws IllegalArgumentException if the converter is null or its handled query case is invalid
     * @throws IllegalArgumentException if no converter can handle the query
            return converter.fromProto(queryContainer);
 * compatible open source license.
    public QueryBuilderProtoConverterSpiRegistry() {  
    private final Map<QueryContainer.QueryContainerCase, QueryBuilderProtoConverter> converterMap = new HashMap<>();
 */  
                converter.getClass().getName()
import java.util.Map;
        // External converters are loaded via OpenSearch's ExtensiblePlugin mechanism
        }
    private static final Logger logger = LogManager.getLogger(QueryBuilderProtoConverterSpiRegistry.class);
    /**
            );
                "Replacing existing converter for query type {}: {} -> {}",
     *
            );  
     */  
public class QueryBuilderProtoConverterSpiRegistry {
import org.opensearch.protobufs.QueryContainer;
     *
     * @return The corresponding OpenSearch QueryBuilder  
        }  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;  
        }  
        for (QueryBuilderProtoConverter converter : converterMap.values()) {  
        if (queryCase == null) {
        }  
    }
     * Gets the number of registered converters.  
     * Registers a new converter.
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
}
    public int size() {
 *
    }  
    /**
            throw new IllegalArgumentException(  
import org.apache.logging.log4j.Logger;
        return converterMap.size();
     * @param queryContainer The protobuf query container
        // and registered manually via registerConverter() calls
            converter.setRegistry(registry);
/**  
    @Inject
import java.util.HashMap;  
            throw new IllegalArgumentException("Handled query case cannot be null for converter: " + converter.getClass().getName());
        QueryBuilderProtoConverter converter = converterMap.get(queryCase);
        // Use direct map lookup for better performance
     */
        if (existingConverter != null) {  
    */
     * Converts a protobuf query container to an OpenSearch QueryBuilder.  
    public void registerConverter(QueryBuilderProtoConverter converter) {  
     * @return The number of registered converters
import org.opensearch.common.inject.Singleton;  
 * this file be licensed under the Apache-2.0 license or a
    }
        }  
 * This class discovers and manages all available converters.
     *
        QueryBuilderProtoConverter existingConverter = converterMap.put(queryCase, converter);
    }  
    }  
     *
     */
    /**
        QueryContainer.QueryContainerCase queryCase = queryContainer.getQueryContainerCase();  
        throw new IllegalArgumentException("Unsupported query type in container: " + queryContainer + " (case: " + queryCase + ")");
        if (converter == null) {
            throw new IllegalArgumentException("Converter cannot be null");
     * Sets the registry on all registered converters.  
     * @param registry The registry to inject into all converters  
 */  
    /**
/*  
            logger.warn(
        if (converter != null) {  
     * @param converter The converter to register  
        logger.info("Set registry on {} converters", converterMap.size());  
        }
package org.opensearch.transport.grpc.proto.request.search.query;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        QueryContainer.QueryContainerCase queryCase = converter.getHandledQueryCase();
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.LogManager;  
        logger.info("Registered query converter for {}: {}", queryCase, converter.getClass().getName());  
    /**  
                "Cannot register converter for QUERYCONTAINER_NOT_SET case: " + converter.getClass().getName()
     * This is used to inject the complete registry into converters that need it (like BoolQueryBuilderProtoConverter).
 * SPDX-License-Identifier: Apache-2.0
@Singleton
import org.opensearch.common.inject.Inject;
