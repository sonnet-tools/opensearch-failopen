    @Inject  
            throw new IllegalArgumentException("Converter cannot be null");  
        }
     *
            Map<String, Object> metadata = ObjectMapProtoUtils.fromProto(container.getMeta());  
        if (converter == null) {
    /**
            logger.warn(
        }
        AggregationBuilderProtoConverter converter = converterMap.get(aggregationCase);
     * @param name The aggregation name
    }  
        AggregationContainer.AggregationContainerCase aggregationCase = container.getAggregationContainerCase();
 * The OpenSearch Contributors require contributions made to  
        // External converters are loaded via OpenSearch's ExtensiblePlugin mechanism
    }  
import org.opensearch.common.inject.Inject;
        AggregationBuilderProtoConverter existingConverter = converterMap.put(aggregationCase, converter);  
import org.opensearch.common.inject.Singleton;  
public class AggregationBuilderProtoConverterSpiRegistry implements AggregationBuilderProtoConverterRegistry {
            throw new IllegalArgumentException(
            );
/**  
        logger.info("Set registry on {} aggregation converter(s)", converterMap.size());
            throw new IllegalArgumentException("Aggregation name cannot be null or empty");  
    }  
        }
            throw new IllegalArgumentException(
import org.opensearch.search.aggregations.AggregationBuilder;
            );
     * Converts protobuf to AggregationBuilder with metadata and subaggregations.
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;  
 * this file be licensed under the Apache-2.0 license or a
     * @param converter The converter to register
    /**
     */
        if (name == null || name.isEmpty()) {
     * Registers a converter for a specific aggregation type.  
 */  
                "Cannot register converter for AGGREGATIONCONTAINER_NOT_SET case: " + converter.getClass().getName()
            logger.debug("Applied metadata to aggregation '{}': {}", name, metadata);
     * Creates a new AggregationBuilderProtoConverterSpiRegistry.
        if (converter == null) {
        }
        }  
     * Returns the number of registered converters.  
 * compatible open source license.
 *
            throw new IllegalArgumentException(
        if (existingConverter != null) {
import org.apache.logging.log4j.Logger;
        // and registered manually via registerConverter() calls  
@Singleton
    private final Map<AggregationContainer.AggregationContainerCase, AggregationBuilderProtoConverter> converterMap = new HashMap<>();
    /**
                "Replacing existing converter for aggregation type {}: {} -> {}",  
import org.opensearch.search.aggregations.AggregatorFactories;  
        }
    public void setRegistryOnAllConverters(AggregationBuilderProtoConverterRegistry registry) {
                converter.getClass().getName()  
                aggregationCase,
import org.opensearch.transport.grpc.proto.request.common.ObjectMapProtoUtils;
    public void registerConverter(AggregationBuilderProtoConverter converter) {
     * External converters are loaded via OpenSearch's ExtensiblePlugin mechanism  
import java.util.regex.Matcher;
        logger.info("Registered aggregation converter for {}: {}", aggregationCase, converter.getClass().getName());
 */  
        for (AggregationBuilderProtoConverter converter : converterMap.values()) {
 * SPDX-License-Identifier: Apache-2.0
    private static final Logger logger = LogManager.getLogger(AggregationBuilderProtoConverterSpiRegistry.class);
                "Unsupported aggregation type in container: " + container + " (case: " + aggregationCase + ")"  
     * Sets the registry on all registered converters.  
import org.opensearch.protobufs.AggregationContainer;
            converter.setRegistry(registry);  
        if (container == null) {
 * Handles converter lookup, metadata, and recursive subaggregation parsing.
     * @return The OpenSearch AggregationBuilder  
        }
     *
     */  
    /**  
     */  
        AggregationBuilder builder = converter.fromProto(name, container);  
        return builder;
     * @param container The protobuf container
    public AggregationBuilderProtoConverterSpiRegistry() {
     * @return The converter count
        logger.debug("Using converter for {}: {}", aggregationCase, converter.getClass().getName());
            );
                existingConverter.getClass().getName(),
        if (aggregationCase == null) {
import org.apache.logging.log4j.LogManager;  
    @Override
import java.util.HashMap;
     */  
/*  
    /**
     * Mirrors {@link AggregatorFactories#parseAggregators}.
    }
     * @param registry The registry to set
import java.util.Map;  
        }
        if (container.hasMeta()) {
        }
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;
     * and registered manually via registerConverter() calls.
        return converterMap.size();
                "Invalid aggregation name [" + name + "]. Aggregation names can contain any character except '[', ']', and '>'"  
     *  
     */
    public int size() {
}  
    public AggregationBuilder fromProto(String name, AggregationContainer container) {  
        }  
        if (!validAggMatcher.matches()) {
        Matcher validAggMatcher = AggregatorFactories.VALID_AGG_NAME.matcher(name);  
    }
 * SPI registry for AggregationBuilderProtoConverter implementations.
            throw new IllegalArgumentException("Handled aggregation case cannot be null for converter: " + converter.getClass().getName());  
        if (aggregationCase == AggregationContainer.AggregationContainerCase.AGGREGATIONCONTAINER_NOT_SET) {  
     *
            builder.setMetadata(metadata);
package org.opensearch.transport.grpc.proto.request.search.aggregation;
            );  
            throw new IllegalArgumentException("Aggregation container cannot be null");
        AggregationContainer.AggregationContainerCase aggregationCase = converter.getHandledAggregationCase();  
