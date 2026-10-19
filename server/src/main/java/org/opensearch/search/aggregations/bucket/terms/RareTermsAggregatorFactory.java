            Aggregator create(  
                    metadata,
                    parent,
     * Execution mode for rare terms agg  
    @Override  
        MAP(new ParseField("map")) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.DocValueFormat;
    /**  
                SearchContext context,  
            .getAggregator(RareTermsAggregationBuilder.REGISTRY_KEY, config)
            public InternalAggregation buildEmptyAggregation() {
import org.opensearch.search.aggregations.InternalAggregation;  
                }
        abstract Aggregator create(
        QueryShardContext queryShardContext,
/*  
 * KIND, either express or implied.  See the License for the
            ) throws IOException {
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        );  
                cardinality,  
     * @opensearch.internal
            SearchContext context,
                if ((includeExclude != null) && (includeExclude.isRegexBased())) {  
 * GitHub history for details.
 * compatible open source license.
                Aggregator parent,  
                    filter,
                            + "values for include/exclude clauses used to filter numeric fields"  
                    name,
                ValuesSourceConfig config  
            CardinalityUpperBound cardinality,
                double precision,
                    maxDocCount,  
            return parseField.getPreferredName();  
            }
            Arrays.asList(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),
            Aggregator parent,  
                    throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of [map]");
                int maxDocCount,
                            + "Use an array of values for include/exclude clauses"  
        return true;
                    valuesSource,
        String name,
        abstract boolean needsGlobalOrdinals();
        builder.register(
import org.opensearch.search.aggregations.CardinalityUpperBound;
                int maxRegexLength = context.getQueryShardContext().getIndexSettings().getMaxRegexLength();
        builder.register(  
                maxDocCount,
        int maxDocCount,  
                CardinalityUpperBound cardinality,
 */
                return execution.create(
import org.opensearch.index.query.QueryShardContext;  
                    throw new IllegalArgumentException(
                String name,
            ) throws IOException {
                    maxDocCount,
                    );
                    format,
                ValuesSourceConfig config
 * ownership. Elasticsearch licenses this file to you under  
/**
            ValuesSource valuesSource,
                    context,
                ValuesSource valuesSource,  
            long maxDocCount,
        private final ParseField parseField;
            double precision,  
        this.includeExclude = includeExclude;
                CardinalityUpperBound cardinality,
            true
                ValuesSourceConfig config  
                    format,  
                precision,
                    format,
public class RareTermsAggregatorFactory extends ValuesSourceAggregatorFactory {  
/*
    @Override  
    }
                CardinalityUpperBound cardinality,
        Map<String, Object> metadata
    private final IncludeExclude includeExclude;
                        "Aggregation ["
        Aggregator parent,
        @Override
    }
        AggregatorFactories.Builder subFactoriesBuilder,
        ExecutionMode(ParseField parseField) {
    private static RareTermsAggregatorSupplier bytesSupplier() {
 * this file be licensed under the Apache-2.0 license or a
                Aggregator parent,
package org.opensearch.search.aggregations.bucket.terms;
        SearchContext searchContext,
     *
 *  
                return new StringRareTermsAggregator(  
 * Licensed to Elasticsearch under one or more contributor  
        public String toString() {
            RareTermsAggregatorFactory.bytesSupplier(),  
    protected boolean supportsConcurrentSegmentSearch() {
                    context,  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            public Aggregator build(
                            + name  
                            + "regular expression style include/exclude settings as they can only be applied to string fields. "
            Arrays.asList(CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.NUMERIC),  
        return new RareTermsAggregatorSupplier() {
                SearchContext context,
        this.precision = precision;  
                        "Aggregation ["
                AggregatorFactories factories,
 */  
                if (includeExclude != null) {
            }
                return new LongRareTermsAggregator(
            AggregatorFactories factories,
     * This supplier is used for all fields that expect to be aggregated as a numeric value.  
    }
 * not use this file except in compliance with the License.
    }  
            }
            public Aggregator build(  
        );
                double precision,  
                DocValueFormat format,
            String name,  
                IncludeExclude.LongFilter longFilter = null;
                name,  
     */  
        return queryShardContext.getValuesSourceRegistry()  
                parent,
        public static ExecutionMode fromString(String value, final DeprecationLogger deprecationLogger) {
            @Override
        IncludeExclude includeExclude,
     * including those that need global ordinals
}
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
 * specific language governing permissions and limitations
                }
                    precision,
    @Override
            DocValueFormat format,  
     * This includes floating points, and formatted types that use numerics internally for storage (date, boolean, etc)
                    throw new IllegalArgumentException("RareTerms aggregation does not support floating point fields.");  
                    config  
                if (((ValuesSource.Numeric) valuesSource).isFloatingPoint()) {
                String name,
            @Override  
                return aggregation;  
                long maxDocCount,  
     */  
        double precision
    }  
 * software distributed under the License is distributed on an
            );  
 * The OpenSearch Contributors require contributions made to  
                            + "style include/exclude settings as they can only be applied to string fields. Use an array of numeric "
                    config
                ExecutionMode execution = ExecutionMode.MAP; // TODO global ords not implemented yet, only supports "map"
        };  
    /**
            this.parseField = parseField;
 * Modifications Copyright OpenSearch Contributors. See
                    longFilter = includeExclude.convertToLongFilter(format);  
                    precision,
                IncludeExclude includeExclude,
                    name,  
                    cardinality,  
                Map<String, Object> metadata,
import org.opensearch.search.aggregations.NonCollectingAggregator;
                    (ValuesSource.Numeric) valuesSource,
            }
                    context,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    protected Aggregator doCreateInternal(  
            }  
import org.opensearch.search.aggregations.Aggregator;
                searchContext,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    precision,
                AggregatorFactories factories,  
 * the Apache License, Version 2.0 (the "License"); you may
                if ((includeExclude != null) && (includeExclude.isRegexBased()) && format != DocValueFormat.RAW) {  
                    parent,
                config
import org.opensearch.core.ParseField;
                config.getValuesSource(),
                IncludeExclude includeExclude,
 */  
        ValuesSourceConfig config,  
                return false;  
                    return MAP;
            RareTermsAggregationBuilder.REGISTRY_KEY,
                int maxDocCount,  
            @Override
                    cardinality,
            RareTermsAggregationBuilder.REGISTRY_KEY,
                default:  
                includeExclude,  
                ValuesSource valuesSource,  
                    includeExclude,  
    public enum ExecutionMode {
    ) throws IOException {
                final IncludeExclude.StringFilter filter = includeExclude == null  
     */
                metadata,
     * This supplier is used for all the field types that should be aggregated as bytes/strings,
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 * under the License.  
            RareTermsAggregatorFactory.numericSupplier(),
                case "map":
                IncludeExclude includeExclude,
                    throw new IllegalArgumentException(
 * Aggregation Factory for rare_terms agg
            ) throws IOException {
                    maxDocCount,
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.AggregatorFactories;  
 */
import org.opensearch.search.aggregations.AggregatorFactory;
    RareTermsAggregatorFactory(
 * You may obtain a copy of the License at  
                Map<String, Object> metadata,
        final InternalAggregation aggregation = new UnmappedRareTerms(name, metadata);
                }
    }  
                ValuesSource valuesSource,
                String name,
                );
    private static RareTermsAggregatorSupplier numericSupplier() {  
                    ? null
                    metadata,  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import org.opensearch.search.aggregations.support.ValuesSource;  
 * @opensearch.internal
            ValuesSourceConfig config
                            + "] cannot support regular expression "
                            + "] cannot support "
        Map<String, Object> metadata,
            Map<String, Object> metadata,
    private final int maxDocCount;
        AggregatorFactory parent,  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
                DocValueFormat format,
        return new RareTermsAggregatorSupplier() {
import java.util.Map;
            true
        };
import org.opensearch.common.logging.DeprecationLogger;
            @Override
                    cardinality,  
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
        };
                Map<String, Object> metadata,  
            switch (value) {  
        }  
    private final double precision;  
        };
                double precision,
 *
                    name,
        }
                AggregatorFactories factories,
                    factories,
 * license agreements. See the NOTICE file distributed with
import java.util.Arrays;
            }
                config.format(),  
                    : includeExclude.convertToStringFilter(format, maxRegexLength);
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {  
                    (ValuesSource.Bytes) valuesSource,  
        ) throws IOException;  
        this.maxDocCount = maxDocCount;
                    parent,
 * this work for additional information regarding copyright
 *  
            IncludeExclude includeExclude,
            boolean needsGlobalOrdinals() {
                DocValueFormat format,
import org.opensearch.search.internal.SearchContext;
            @Override
            .build(
                );
    }
                factories,
                    );
                            + name  
                    factories,
    ) throws IOException {
    }
                }
/*  
                SearchContext context,  
                    factories,  
        CardinalityUpperBound cardinality,  
                Aggregator parent,
                    metadata
 *
                );
        }  
                    longFilter,  
