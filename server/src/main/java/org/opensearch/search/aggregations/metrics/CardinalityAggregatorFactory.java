 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    ) throws IOException {  
        }
import org.opensearch.index.fielddata.IndexFieldData;
 *  
 * compatible open source license.
     *  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.search.streaming.FlushMode;
 * Unless required by applicable law or agreed to in writing,
        return precisionThreshold == null
                throw new IllegalArgumentException("Unknown execution_hint: [" + value + "], expected any of [direct, ordinals]");
import java.io.IOException;
    }
        }
    }
        Long precisionThreshold,  
 * Modifications Copyright OpenSearch Contributors. See
        }
/*  
 *
/*
class CardinalityAggregatorFactory extends ValuesSourceAggregatorFactory implements StreamingCostEstimable {
            return new StreamCardinalityAggregator(name, config, precision(), searchContext, parent, metadata, executionMode);
        String executionHint
        @Override
    }
        String name,
        this.executionMode = executionHint == null ? null : ExecutionMode.fromString(executionHint);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ValuesSource valuesSource = config.getValuesSource();
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
    }
    }  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        return true;
import org.opensearch.search.aggregations.support.ValuesSource;
        ValuesSourceConfig config,
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 */
 * GitHub history for details.
        this.precisionThreshold = precisionThreshold;
            } catch (IllegalArgumentException e) {  
 *
 * KIND, either express or implied.  See the License for the
                IndexFieldData<?> indexFieldData = searchContext.getQueryShardContext().getForField(fieldType);
 */  
            ? HyperLogLogPlusPlus.DEFAULT_PRECISION  
    private int precision() {
 * specific language governing permissions and limitations
            .getAggregator(CardinalityAggregationBuilder.REGISTRY_KEY, config)
            if (fieldType instanceof HllFieldMapper.HllFieldType hllFieldType) {
 * Licensed to Elasticsearch under one or more contributor  
                return ExecutionMode.valueOf(value.toUpperCase(Locale.ROOT));
    @Override
    @Override  
    protected boolean supportsConcurrentSegmentSearch() {
import org.opensearch.index.mapper.HllFieldMapper;  
        return queryShardContext.getValuesSourceRegistry()  
/**  
    @Override
        builder.register(CardinalityAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.ALL_CORE, CardinalityAggregator::new, true);
        ORDINALS;
import org.opensearch.search.aggregations.Aggregator;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public String toString() {  
 * license agreements. See the NOTICE file distributed with
    }  
        return StreamingCostMetrics.nonStreamable();  
        return new CardinalityAggregator(name, config, precision(), searchContext, parent, metadata, executionMode);  
 * ownership. Elasticsearch licenses this file to you under  
            // TODO topNSize can relate to precision
    @Override
        Map<String, Object> metadata
    CardinalityAggregatorFactory(  
                }
     */
 * The OpenSearch Contributors require contributions made to  
        CardinalityUpperBound cardinality,
    /**
import org.opensearch.search.aggregations.AggregatorFactories;
    }
            try {
        if (searchContext.isStreamSearch() && searchContext.getFlushMode() == FlushMode.PER_SEGMENT) {  
    }
 * @opensearch.internal  
import org.opensearch.index.mapper.MappedFieldType;
 */  
import org.opensearch.search.streaming.StreamingCostEstimable;
 * not use this file except in compliance with the License.
        AggregatorFactory parent,
        return true;
import org.opensearch.index.query.QueryShardContext;
            MappedFieldType fieldType = config.fieldContext().fieldType();  
        }  
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import org.opensearch.index.fielddata.plain.HllFieldData;
    public enum ExecutionMode {  
            return this.name().toLowerCase(Locale.ROOT);
 *
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    public StreamingCostMetrics estimateStreamingCost(SearchContext searchContext) {  
        if (searchContext.isStreamSearch() && searchContext.getFlushMode() == FlushMode.PER_SEGMENT) {  
    private final Long precisionThreshold;
        // Use HllCardinalityAggregator for HLL fields
 * this work for additional information regarding copyright
            .build(name, config, precision(), searchContext, parent, metadata, executionMode);
    protected boolean supportsIntraSegmentSearch() {  
            }  
        DIRECT,
    }  
    ) throws IOException {  
import org.opensearch.search.internal.SearchContext;  
     * @opensearch.internal
        QueryShardContext queryShardContext,
        public static ExecutionMode fromString(String value) {  
        AggregatorFactories.Builder subFactoriesBuilder,  
        }
    protected Aggregator doCreateInternal(
 * You may obtain a copy of the License at  
            return new StreamingCostMetrics(true, 1);  
        }
        ExecutionMode() {}
/*  
}  
 * under the License.  
        Aggregator parent,  
        SearchContext searchContext,
 */
 * software distributed under the License is distributed on an
        if (config.fieldContext() != null) {
                    return new HllCardinalityAggregator(name, hllFieldData, hllFieldType.precision(), searchContext, parent, metadata);
    private final ExecutionMode executionMode;
     * Execution mode for cardinality agg
                if (indexFieldData instanceof HllFieldData hllFieldData) {  
            }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.streaming.StreamingCostMetrics;  
 * Aggregation Factory for cardinality agg
        // Only term ordinals values sources support streaming cardinality  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    @Override  
        Map<String, Object> metadata,
        if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals) {
            : HyperLogLogPlusPlus.precisionFromThreshold(precisionThreshold);
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
            return new StreamCardinalityAggregator(name, config, precision(), searchContext, parent, metadata, executionMode);
import java.util.Map;
import java.util.Locale;  
package org.opensearch.search.aggregations.metrics;
