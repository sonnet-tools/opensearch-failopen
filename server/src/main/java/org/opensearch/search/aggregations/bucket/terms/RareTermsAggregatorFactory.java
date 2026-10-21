                    factories,
import org.opensearch.search.aggregations.CardinalityUpperBound;
        public String toString() {
import org.opensearch.search.aggregations.support.ValuesSource;
                config
public class RareTermsAggregatorFactory extends ValuesSourceAggregatorFactory {
                );
            ) throws IOException {
    private final double precision;
                CardinalityUpperBound cardinality,
                metadata,
                    precision,
                SearchContext context,
                    maxDocCount,
                ValuesSource valuesSource,
        this.maxDocCount = maxDocCount;
    }
                    );
        MAP(new ParseField("map")) {
 *
            ValuesSource valuesSource,
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
        abstract Aggregator create(
 * ownership. Elasticsearch licenses this file to you under
                double precision,
                AggregatorFactories factories,
    RareTermsAggregatorFactory(
                }
            switch (value) {
                DocValueFormat format,
            }
 *
        );
        Aggregator parent,
                    precision,
                            + "Use an array of values for include/exclude clauses"
                    config
            return parseField.getPreferredName();
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        ValuesSourceConfig config,
 * Modifications Copyright OpenSearch Contributors. See
                Aggregator parent,
                case "map":
        Map<String, Object> metadata,
                if ((includeExclude != null) && (includeExclude.isRegexBased())) {
                if (includeExclude != null) {
            AggregatorFactories factories,
                factories,
        CardinalityUpperBound cardinality,
                    maxDocCount,
        Map<String, Object> metadata
                SearchContext context,
 * You may obtain a copy of the License at
            true
                    factories,
                    format,
    ) throws IOException {
/*
 * not use this file except in compliance with the License.
                int maxDocCount,
            .getAggregator(RareTermsAggregationBuilder.REGISTRY_KEY, config)
    /**
            }
            Aggregator create(
            }
                double precision,
            public InternalAggregation buildEmptyAggregation() {
import org.opensearch.search.aggregations.AggregatorFactory;
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            Aggregator parent,
                String name,
     * This includes floating points, and formatted types that use numerics internally for storage (date, boolean, etc)
 * @opensearch.internal
                    format,
        builder.register(
        return new RareTermsAggregatorSupplier() {
     */
 * software distributed under the License is distributed on an
        };
import org.opensearch.search.aggregations.InternalAggregation;
        builder.register(
                long maxDocCount,
                    name,
                parent,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        }
                IncludeExclude includeExclude,
        AggregatorFactories.Builder subFactoriesBuilder,
                return aggregation;
        private final ParseField parseField;
            this.parseField = parseField;
                    precision,
        QueryShardContext queryShardContext,
        IncludeExclude includeExclude,
            @Override
                    includeExclude,
     * This supplier is used for all fields that expect to be aggregated as a numeric value.
                    longFilter,
                DocValueFormat format,
 * license agreements. See the NOTICE file distributed with
            RareTermsAggregationBuilder.REGISTRY_KEY,
        this.includeExclude = includeExclude;
                    throw new IllegalArgumentException("RareTerms aggregation does not support floating point fields.");
                int maxRegexLength = context.getQueryShardContext().getIndexSettings().getMaxRegexLength();
            SearchContext context,
                        "Aggregation ["
                    context,
            Arrays.asList(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),
                    parent,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                ExecutionMode execution = ExecutionMode.MAP; // TODO global ords not implemented yet, only supports "map"
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            Arrays.asList(CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.NUMERIC),
                    cardinality,
                config.getValuesSource(),
            CardinalityUpperBound cardinality,
        };
        SearchContext searchContext,
                    throw new IllegalArgumentException(
        ) throws IOException;
                maxDocCount,
            long maxDocCount,
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.internal.SearchContext;
                    config
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
        double precision
            public Aggregator build(
            ValuesSourceConfig config
                IncludeExclude includeExclude,
    }
 * this work for additional information regarding copyright
            public Aggregator build(
        String name,
import org.opensearch.index.query.QueryShardContext;
                    return MAP;
                AggregatorFactories factories,
        int maxDocCount,
        final InternalAggregation aggregation = new UnmappedRareTerms(name, metadata);
    }
                ValuesSource valuesSource,
import org.opensearch.search.aggregations.NonCollectingAggregator;
                    valuesSource,
                default:
                config.format(),
            boolean needsGlobalOrdinals() {
                    metadata
        return new RareTermsAggregatorSupplier() {
 * Unless required by applicable law or agreed to in writing,
                IncludeExclude.LongFilter longFilter = null;
                    context,
                    longFilter = includeExclude.convertToLongFilter(format);
                    context,
        abstract boolean needsGlobalOrdinals();
                            + "values for include/exclude clauses used to filter numeric fields"
                name,
            String name,
                Map<String, Object> metadata,
 * GitHub history for details.
            @Override
                searchContext,
    private final IncludeExclude includeExclude;
            .build(
import org.opensearch.search.aggregations.AggregatorFactories;
     * @opensearch.internal
    private final int maxDocCount;
 * under the License.
            true
     *
                    factories,
                DocValueFormat format,
    @Override
        public static ExecutionMode fromString(String value, final DeprecationLogger deprecationLogger) {
                        "Aggregation ["
        }
 *
 * Licensed to Elasticsearch under one or more contributor
                    cardinality,
                Map<String, Object> metadata,
    /**
import org.opensearch.search.DocValueFormat;
                    maxDocCount,
                }
                    : includeExclude.convertToStringFilter(format, maxRegexLength);
    private static RareTermsAggregatorSupplier numericSupplier() {
        return true;
                return new LongRareTermsAggregator(
                    parent,
                    cardinality,
    @Override
/**
        return queryShardContext.getValuesSourceRegistry()
        AggregatorFactory parent,
                CardinalityUpperBound cardinality,
    }
            IncludeExclude includeExclude,
 * specific language governing permissions and limitations
                precision,
        @Override
        ExecutionMode(ParseField parseField) {
    protected boolean supportsConcurrentSegmentSearch() {
                            + name
                            + "regular expression style include/exclude settings as they can only be applied to string fields. "
                }
                SearchContext context,
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
                ValuesSource valuesSource,
                ValuesSourceConfig config
    ) throws IOException {
    }
     */
    @Override
                ValuesSourceConfig config
                );
                    name,
                ValuesSourceConfig config
                    (ValuesSource.Bytes) valuesSource,
        };
        this.precision = precision;
            Map<String, Object> metadata,
     * Execution mode for rare terms agg
                    filter,
    private static RareTermsAggregatorSupplier bytesSupplier() {
                );
                cardinality,
 */
    }
                }
                Aggregator parent,
                Aggregator parent,
                return execution.create(
            @Override
                String name,
            RareTermsAggregatorFactory.numericSupplier(),
                AggregatorFactories factories,
            );
        }
 */
                            + name
     * including those that need global ordinals
        };
                    );
 *
            @Override
}
                includeExclude,
import org.opensearch.common.logging.DeprecationLogger;
                int maxDocCount,
                    metadata,
     * This supplier is used for all the field types that should be aggregated as bytes/strings,
            RareTermsAggregationBuilder.REGISTRY_KEY,
/*
                    throw new IllegalArgumentException(
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
import org.opensearch.core.ParseField;
                CardinalityUpperBound cardinality,
                    name,
            }
                            + "style include/exclude settings as they can only be applied to string fields. Use an array of numeric "
                            + "] cannot support "
                    (ValuesSource.Numeric) valuesSource,
 * KIND, either express or implied.  See the License for the
            RareTermsAggregatorFactory.bytesSupplier(),
    }
            double precision,
                if (((ValuesSource.Numeric) valuesSource).isFloatingPoint()) {
                    metadata,
import org.opensearch.search.aggregations.Aggregator;
                final IncludeExclude.StringFilter filter = includeExclude == null
 * Aggregation Factory for rare_terms agg
 * this file be licensed under the Apache-2.0 license or a
    protected Aggregator doCreateInternal(
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
            }
            }
    /**
 */
 */
 * SPDX-License-Identifier: Apache-2.0
                if ((includeExclude != null) && (includeExclude.isRegexBased()) && format != DocValueFormat.RAW) {
                double precision,
    public enum ExecutionMode {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            ) throws IOException {
/*
package org.opensearch.search.aggregations.bucket.terms;
            ) throws IOException {
            DocValueFormat format,
                    ? null
import java.util.Map;
                    throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of [map]");
                IncludeExclude includeExclude,
                    parent,
                return false;
                Map<String, Object> metadata,
            @Override
                    format,
                String name,
import java.util.Arrays;
                            + "] cannot support regular expression "
                return new StringRareTermsAggregator(
 * compatible open source license.
