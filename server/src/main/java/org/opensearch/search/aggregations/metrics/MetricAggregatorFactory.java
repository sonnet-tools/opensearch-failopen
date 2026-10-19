        AggregatorFactory parent,
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryShardContext;
 * SPDX-License-Identifier: Apache-2.0
/**
 * compatible open source license.
public abstract class MetricAggregatorFactory extends ValuesSourceAggregatorFactory {
/*  
 * Extending ValuesSourceAggregatorFactory for aggregation factories supported by star-tree implementation  
        Map<String, Object> metadata  
    public MetricAggregatorFactory(  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.AggregatorFactories;  
 */  
        String name,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 *
import java.io.IOException;
    }  
}  
        AggregatorFactories.Builder subFactoriesBuilder,
        QueryShardContext queryShardContext,  
    public abstract MetricStat getMetricStat();
    ) throws IOException {
import org.opensearch.index.compositeindex.datacube.MetricStat;
 */
package org.opensearch.search.aggregations.metrics;
        ValuesSourceConfig config,
import java.util.Map;  
