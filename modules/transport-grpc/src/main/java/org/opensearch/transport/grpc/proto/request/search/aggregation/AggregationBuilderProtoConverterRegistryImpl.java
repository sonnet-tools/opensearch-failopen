 * Registry for AggregationBuilderProtoConverter implementations.
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;
     * @param name The aggregation name  
 */  
        delegate.registerConverter(new MinAggregationBuilderProtoConverter());
    public AggregationBuilderProtoConverterRegistryImpl() {
     * Updates the registry reference on all registered converters.
        // Register metric aggregation converters  
    private static final Logger logger = LogManager.getLogger(AggregationBuilderProtoConverterRegistryImpl.class);
 * compatible open source license.
     * Registers all built-in aggregation converters.  
     * Mirrors {@link AggregatorFactories#parseAggregators}.
    public void registerConverter(AggregationBuilderProtoConverter converter) {
    }  
    /**
import org.opensearch.search.aggregations.AggregationBuilder;
     * Registers an external aggregation converter.
import org.opensearch.transport.grpc.proto.request.search.aggregation.metrics.MinAggregationBuilderProtoConverter;  
    }
     * Creates a new AggregationBuilderProtoConverterRegistryImpl and registers built-in converters.
     *
     */
    protected void registerBuiltInConverters() {
    /**
    private final AggregationBuilderProtoConverterSpiRegistry delegate;
        delegate.registerConverter(new TermsAggregationBuilderConverter());  
    }
import org.apache.logging.log4j.Logger;
     */  
        converter.setRegistry(this);
import org.opensearch.transport.grpc.proto.request.search.aggregation.metrics.MaxAggregationBuilderProtoConverter;
    }  
    /**
        this.delegate = new AggregationBuilderProtoConverterSpiRegistry();  
     * @param converter The converter to register  
        return delegate.fromProto(name, container);  
        delegate.registerConverter(converter);  
     */  
        delegate.setRegistryOnAllConverters(this);
    @Override
    public AggregationBuilder fromProto(String name, AggregationContainer container) {
package org.opensearch.transport.grpc.proto.request.search.aggregation;
     * @return The OpenSearch AggregationBuilder
    public void updateRegistryOnAllConverters() {
 * this file be licensed under the Apache-2.0 license or a
}
        delegate.setRegistryOnAllConverters(this);  
        registerBuiltInConverters();
    }  
public class AggregationBuilderProtoConverterRegistryImpl implements AggregationBuilderProtoConverterRegistry {
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
import org.opensearch.protobufs.AggregationContainer;
import org.opensearch.common.inject.Singleton;  
        // Set the registry on all converters so they can access each other
     *
import org.opensearch.transport.grpc.proto.request.search.aggregation.bucket.terms.TermsAggregationBuilderConverter;
 * The OpenSearch Contributors require contributions made to  
/**
     */  
import org.apache.logging.log4j.LogManager;  
        logger.info("Registered {} built-in aggregation converter(s)", delegate.size());
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.Inject;
    @Inject
/*  
     * @param container The protobuf container
 *
import org.opensearch.search.aggregations.AggregatorFactories;  
 */  
     * Converts protobuf to AggregationBuilder.  
    /**  
        delegate.registerConverter(new MaxAggregationBuilderProtoConverter());
@Singleton
     */
