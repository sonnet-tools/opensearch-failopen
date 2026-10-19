        AggregatorFactories.Builder subFactoriesBuilder,  
            MultiValueDocCountAggregationBuilder.REGISTRY_KEY,  
        return true;
 * @opensearch.internal  
 */  
    @Override  
import org.opensearch.search.internal.SearchContext;
        CardinalityUpperBound cardinality,  
    protected boolean supportsConcurrentSegmentSearch() {  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
    }  
import org.opensearch.search.aggregations.AggregatorFactories;  
import org.opensearch.search.aggregations.AggregatorFactory;
    }
        ValuesSourceConfig config,  
        Map<String, Object> metadata
}  
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        String name,
import java.util.Map;
 * compatible open source license.
        builder.register(
/*  
        );
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 *
    ) throws IOException {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 */
public class MultiValueDocCountAggregatorFactory extends ValuesSourceAggregatorFactory {
        AggregatorFactory parent,
            .getAggregator(MultiValueDocCountAggregationBuilder.REGISTRY_KEY, config)
    MultiValueDocCountAggregatorFactory(
            .build(name, config, searchContext, parent, metadata);
    }
/**  
        return new MultiValueDocCountAggregator(name, config, searchContext, parent, metadata);
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
            CoreValuesSourceType.ALL_CORE,
 * Aggregation Factory for multivalue_doc_count agg
    }  
            true  
        Map<String, Object> metadata
 * SPDX-License-Identifier: Apache-2.0
            MultiValueDocCountAggregator::new,
        Aggregator parent,
        QueryShardContext queryShardContext,
    @Override
import org.opensearch.index.query.QueryShardContext;
        return queryShardContext.getValuesSourceRegistry()  
    ) throws IOException {
package org.opensearch.search.aggregations.metrics;
    @Override
    }
    protected Aggregator doCreateInternal(  
        SearchContext searchContext,
 *
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
import org.opensearch.search.aggregations.CardinalityUpperBound;
import org.opensearch.search.aggregations.Aggregator;
