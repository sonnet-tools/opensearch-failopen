     * @param converter The converter to register (must not be null)
     * @param aggregation The InternalAggregation to convert (must not be null)
        for (AggregateProtoConverter converter : converters.values()) {
     * Sets the registry on all registered converters.  
        logger.info("Registered aggregate converter for {}: {}", type.getName(), converter.getClass().getName());  
    }
                    break;  
    /**
     * Returns the number of registered converters.  
            throw new IllegalArgumentException("Unsupported aggregation type: " + aggregation.getClass().getName());  
                type.getName(),  
        // First try exact class match  
     * and registered manually via registerConverter() calls.  
     */  
        logger.debug("Using converter for {}: {}", aggregation.getClass().getName(), converter.getClass().getName());  
                }
     * @return The corresponding Protocol Buffer Aggregate message
     * Creates a new AggregateProtoConverterSpiRegistry.
                if (entry.getKey().isInstance(aggregation)) {
}
        }
 */  
 *
            throw new IllegalArgumentException("Handled aggregation type cannot be null for converter: " + converter.getClass().getName());
        }
                    converter = entry.getValue();
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
    /**
        if (converter == null) {
 * The OpenSearch Contributors require contributions made to  
    /**
    public void registerConverter(AggregateProtoConverter converter) {
     * @throws IllegalArgumentException if aggregation is null or type is not supported  
            }
        }  
    /**  
     * Converts an InternalAggregation to Aggregate protobuf.
     * @throws IllegalArgumentException if converter is null or handled type is null
import org.apache.logging.log4j.Logger;
        if (converter == null) {
            throw new IllegalArgumentException("Aggregation must not be null");  
                converter.getClass().getName()
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterSpiRegistry;
        return converter.toProto(aggregation).build();
        logger.info("Set registry on {} aggregate converter(s)", converters.size());
            for (Map.Entry<Class<? extends InternalAggregation>, AggregateProtoConverter> entry : converters.entrySet()) {  
import org.apache.logging.log4j.LogManager;  
     * Registers a converter for a specific InternalAggregation type.
    private final Map<Class<? extends InternalAggregation>, AggregateProtoConverter> converters = new HashMap<>();
     * @return The converter count
        if (existingConverter != null) {  
        AggregateProtoConverter existingConverter = converters.put(type, converter);
            logger.warn(
                "Replacing existing converter for aggregation type {}: {} -> {}",
import java.util.Map;
    public Aggregate toProto(InternalAggregation aggregation) throws IOException {
     */  
/*  
 * Mirrors the pattern from {@link AggregationBuilderProtoConverterSpiRegistry}.
        }
        if (converter == null) {
    public int size() {
     * External converters can be loaded via OpenSearch's ExtensiblePlugin mechanism
     */  
     *
 */  
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
            throw new IllegalArgumentException("Converter cannot be null");  
        return converters.size();
    }  
package org.opensearch.transport.grpc.proto.response.search.aggregation;
        }  
    }  
import java.util.HashMap;  
        AggregateProtoConverter converter = converters.get(aggregation.getClass());
        // This handles cases like Mockito proxies and subclasses
 * SPI registry for AggregateProtoConverter implementations.
        if (aggregation == null) {
import org.opensearch.protobufs.Aggregate;
 * compatible open source license.
        }
import org.opensearch.search.aggregations.InternalAggregation;  
        if (type == null) {
public class AggregateProtoConverterSpiRegistry implements AggregateProtoConverterRegistry {
    /**  
    public AggregateProtoConverterSpiRegistry() {
     * @throws IOException if an error occurs during protobuf conversion
 * this file be licensed under the Apache-2.0 license or a
    @Override  
     */
        // External converters can be loaded via OpenSearch's ExtensiblePlugin mechanism  
     *  
import java.io.IOException;
     *  
        }
    public void setRegistryOnAllConverters(AggregateProtoConverterRegistry registry) {
     */
    }
    private static final Logger logger = LogManager.getLogger(AggregateProtoConverterSpiRegistry.class);  
     * @param registry The registry to set
            );  
        // If no exact match, walk up the class hierarchy to find a registered converter  
     *
        Class<? extends InternalAggregation> type = converter.getHandledAggregationType();  
 * SPDX-License-Identifier: Apache-2.0
        // and registered manually via registerConverter() calls
    }  
     * Delegates type-specific conversion (including metadata) to registered converters.
            converter.setRegistry(registry);  
/**  
                existingConverter.getClass().getName(),
