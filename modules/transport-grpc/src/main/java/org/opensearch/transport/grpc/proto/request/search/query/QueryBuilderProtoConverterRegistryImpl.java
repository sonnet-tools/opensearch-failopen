    public QueryBuilderProtoConverterRegistryImpl() {  
        delegate.registerConverter(new MatchAllQueryBuilderProtoConverter());
    }  
     *
 * Registry for QueryBuilderProtoConverter implementations.
     * to ensure converters like BoolQueryBuilderProtoConverter can access the complete registry.
    /**
        delegate.registerConverter(new TermsQueryBuilderProtoConverter());
    @Inject
    }  
     * @return The corresponding OpenSearch QueryBuilder
        delegate.registerConverter(new BoolQueryBuilderProtoConverter());
import org.opensearch.common.inject.Inject;
        delegate.registerConverter(new PrefixQueryBuilderProtoConverter());  
    private final QueryBuilderProtoConverterSpiRegistry delegate;  
        registerBuiltInConverters();
        delegate.registerConverter(new GeoBoundingBoxQueryBuilderProtoConverter());
import org.opensearch.transport.grpc.proto.request.search.query.functionscore.FunctionScoreQueryBuilderProtoConverter;  
        // Register built-in converters for this module
/**
        delegate.registerConverter(new RegexpQueryBuilderProtoConverter());
        delegate.registerConverter(new NestedQueryBuilderProtoConverter());  
 * this file be licensed under the Apache-2.0 license or a
    public void registerConverter(QueryBuilderProtoConverter converter) {
     */
        delegate.setRegistryOnAllConverters(this);
     * @param converter The converter to register
        delegate.registerConverter(new IdsQueryBuilderProtoConverter());
import org.apache.logging.log4j.Logger;
import org.opensearch.protobufs.QueryContainer;
        delegate.registerConverter(new ExistsQueryBuilderProtoConverter());
     * Converts a protobuf query container to an OpenSearch QueryBuilder.
        delegate.registerConverter(new MatchBoolPrefixQueryBuilderProtoConverter());
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
    /**  
     */  
        delegate.registerConverter(new WildcardQueryBuilderProtoConverter());  
     * Registers the built-in converters.  
        delegate.registerConverter(new FuzzyQueryBuilderProtoConverter());
package org.opensearch.transport.grpc.proto.request.search.query;
 * The OpenSearch Contributors require contributions made to  
        return delegate.fromProto(queryContainer);
@Singleton
        delegate.registerConverter(new FunctionScoreQueryBuilderProtoConverter());
     */  
        logger.info("Registered {} built-in query converters", delegate.size());  
}
        delegate.registerConverter(converter);
    public void updateRegistryOnAllConverters() {
    private static final Logger logger = LogManager.getLogger(QueryBuilderProtoConverterRegistryImpl.class);
        delegate.registerConverter(new MatchQueryBuilderProtoConverter());
import org.apache.logging.log4j.LogManager;  
        delegate.registerConverter(new RangeQueryBuilderProtoConverter());
 * This class wraps the SPI registry and adds built-in converters for the transport-grpc module.  
import org.opensearch.index.query.QueryBuilder;
     * Creates a new registry and loads all available converters.  
     */
     * Protected for testing purposes.
        // Add built-in converters
    /**
        delegate.registerConverter(new TermsSetQueryBuilderProtoConverter());  
     * Updates the registry on all registered converters.  
        delegate.registerConverter(new ScriptQueryBuilderProtoConverter());  
/*  
     * @throws IllegalArgumentException if the query cannot be converted
     * This should be called after all external converters have been registered
     */  
public class QueryBuilderProtoConverterRegistryImpl implements QueryBuilderProtoConverterRegistry {  
 * compatible open source license.
        delegate.setRegistryOnAllConverters(this);
        delegate.registerConverter(new MatchPhrasePrefixQueryBuilderProtoConverter());  
    protected void registerBuiltInConverters() {  
 */  
        delegate.registerConverter(new MultiMatchQueryBuilderProtoConverter());
 *
import org.opensearch.common.inject.Singleton;  
    }  
        this.delegate = new QueryBuilderProtoConverterSpiRegistry();
     * Registers a new converter.  
        // Set the registry on all converters so they can access each other  
     *
    /**
 * SPDX-License-Identifier: Apache-2.0
        delegate.registerConverter(new GeoDistanceQueryBuilderProtoConverter());
    /**
        delegate.registerConverter(new ConstantScoreQueryBuilderProtoConverter());
        // Create the SPI registry which loads external converters
    }
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
    public QueryBuilder fromProto(QueryContainer queryContainer) {
 */
     * @param queryContainer The protobuf query container  
        delegate.registerConverter(new TermQueryBuilderProtoConverter());
    }  
        delegate.registerConverter(new MatchNoneQueryBuilderProtoConverter());  
        delegate.registerConverter(new MatchPhraseQueryBuilderProtoConverter());  
