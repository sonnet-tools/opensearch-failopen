    public int size() {
     */  
/*  
        spiRegistry.registerConverter(new UnsignedLongTermsAggregateConverter());  
        spiRegistry.registerConverter(new StringTermsAggregateConverter());
 * this file be licensed under the Apache-2.0 license or a
}
 * compatible open source license.
    @Override
import org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms.UnmappedTermsAggregateConverter;
        return spiRegistry.toProto(aggregation);  
    private final AggregateProtoConverterSpiRegistry spiRegistry;
     *
     */  
import java.io.IOException;  
    public void updateRegistryOnAllConverters() {
        this.spiRegistry = new AggregateProtoConverterSpiRegistry();
    }  
 * Public facade for the aggregate converter registry that registers built-in converters.  
        registerBuiltInConverters();  
    }
 * The OpenSearch Contributors require contributions made to  
        spiRegistry.registerConverter(new UnmappedTermsAggregateConverter());
import org.opensearch.transport.grpc.proto.response.search.aggregation.metrics.MinAggregateProtoConverter;
        spiRegistry.registerConverter(new MaxAggregateProtoConverter());  
        return spiRegistry.size();
        spiRegistry.setRegistryOnAllConverters(this);
import org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms.UnsignedLongTermsAggregateConverter;  
     * Registers an external aggregate converter.
    public AggregateProtoConverterRegistryImpl() {
     * Returns the number of registered converters.  
 */
     */  
     * Registers all built-in aggregate converters.
 * Provides the main entry point for external code to convert aggregations to protobuf.
    /**  
import org.opensearch.protobufs.Aggregate;  
    private void registerBuiltInConverters() {
    /**
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
     * Creates a new AggregateProtoConverterRegistryImpl and registers built-in converters.
 */  
    /**
    }
     * @return The converter count
     * Updates the registry reference on all registered converters.
     */
import org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms.LongTermsAggregateConverter;  
    }
     * External plugins can extend this by calling registerConverter() on the SPI registry.
import org.opensearch.transport.grpc.proto.response.search.aggregation.metrics.MaxAggregateProtoConverter;
    }
        spiRegistry.registerConverter(converter);  
    /**
    /**  
        spiRegistry.registerConverter(new MinAggregateProtoConverter());
     */  
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms.DoubleTermsAggregateConverter;
/**
        spiRegistry.registerConverter(new DoubleTermsAggregateConverter());
     *
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;  
     * @param converter The converter to register  
 *
    public Aggregate toProto(InternalAggregation aggregation) throws IOException {
        spiRegistry.registerConverter(new LongTermsAggregateConverter());
        converter.setRegistry(this);
package org.opensearch.transport.grpc.proto.response.search.aggregation;
    }  
    public void registerConverter(AggregateProtoConverter converter) {
public class AggregateProtoConverterRegistryImpl implements AggregateProtoConverterRegistry {  
        spiRegistry.setRegistryOnAllConverters(this);
import org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms.StringTermsAggregateConverter;
 * SPDX-License-Identifier: Apache-2.0
