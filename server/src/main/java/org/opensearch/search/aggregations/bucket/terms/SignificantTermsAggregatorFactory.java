                    remapGlobalOrd = false;
                    cardinality,
                    parent,
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
                    filter,
    }
                );
                    context,
    private static SignificantTermsAggregatorSupplier numericSupplier() {
                String name,
    }
                }
                    : includeExclude.convertToStringFilter(format, maxRegexLength);
        return new SignificantTermsAggregatorSupplier() {
                    cardinality,
            metadata
                Aggregator parent,
                Map<String, Object> metadata
        );
            SignificantTermsAggregationBuilder.REGISTRY_KEY,
 */
    SignificantTermsAggregatorFactory(
                    throw new IllegalArgumentException(
     * This includes floating points, and formatted types that use numerics internally for storage (date, boolean, etc)
                    "global_ordinals_hash",
                Map<String, Object> metadata
                SignificanceHeuristic significanceHeuristic,
 * this work for additional information regarding copyright
    /**
    }
                ValuesSource valuesSource,
                final IncludeExclude.StringFilter filter = includeExclude == null
            IncludeExclude includeExclude,
                    longFilter = includeExclude.convertToLongFilter(format);
                SignificanceLookup lookup,
                    a -> a.new SignificantTermsResults(lookup, significanceHeuristic, cardinality),
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
                return new NumericTermsAggregator(
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                            + "settings as they can only be applied to string fields. Use an array of numeric "
            SearchContext aggregationContext,
     * This supplier is used for all the field types that should be aggregated as bytes/strings,
                    bucketCountThresholds,
                    significanceHeuristic,
                final IncludeExclude.OrdinalsFilter filter = includeExclude == null
                    name,
        }
                String name,
                    /*
                );
                ValuesSource valuesSource,
        public String toString() {
                String name,
                     */
                Aggregator parent,
        }
            true
        ExecutionMode(ParseField parseField) {
                    factories,
                    null,
 * Aggregation Factory for significant_terms agg
        if (bucketCountThresholds.getShardSize() == SignificantTermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
                CardinalityUpperBound cardinality,
            public Aggregator build(
        Map<String, Object> metadata
                DocValueFormat format,
                SearchContext aggregationContext,
            Arrays.asList(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),
            if (config.fieldContext().fieldType().isSearchable() == false) {
                DocValueFormat format,
 * the Apache License, Version 2.0 (the "License"); you may
 *
            // but request double the usual amount.
 *
                    bucketCountThresholds,
                Map<String, Object> metadata
            // Use default heuristic to avoid any wrong-ranking caused by
                    parent,
        final InternalAggregation aggregation = new UnmappedSignificantTerms(name, bucketCountThresholds, metadata);
            // as the significance algorithm is in less of a position to
        ) throws IOException;
                    throw new IllegalArgumentException(
                    remapGlobalOrd,
                    ? null
        this.executionHint = executionHint;
            }
                            + "values for include/exclude clauses used to filter numeric fields"
            }
 *
    }
                IncludeExclude includeExclude,
/**
            @Override
        };
                    filter,
            SignificantTermsAggregationBuilder.REGISTRY_KEY,
                return new GlobalOrdinalsStringTermsAggregator(
                            + "] cannot support regular expression style "
            SignificanceHeuristic significanceHeuristic,
    private final SignificanceHeuristic significanceHeuristic;
    }
        return aggregatorSupplier.build(
                        + "] is not"
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.QueryShardContext;
                    : includeExclude.convertToOrdinalsFilter(format, maxRegexLength);
            // some of the things we want to find have only one occurrence on
import org.opensearch.search.aggregations.AggregatorFactories;
        ValuesSourceConfig config,
            @Override
            }
        AggregatorFactory parent,
                Aggregator parent,
        CardinalityUpperBound cardinality,
                CardinalityUpperBound cardinality,
 * SPDX-License-Identifier: Apache-2.0
            backgroundFilter
            ) throws IOException {
        MAP(new ParseField("map")) {
            config.getValuesSource(),
        @Override
                            + "include/exclude clauses"
                SignificanceLookup lookup,
            includeExclude,
     * including those that need global ordinals
        if (config.hasValues()) {
    }
import org.opensearch.core.ParseField;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
                return execution.create(
    public enum ExecutionMode {
                    name,
                );
                Aggregator parent,
     * @opensearch.internal
            significanceHeuristic,
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
    @Override
                    );
            TermsAggregator.BucketCountThresholds bucketCountThresholds,
            ) throws IOException {
        SignificantTermsAggregatorSupplier aggregatorSupplier = queryShardContext.getValuesSourceRegistry()
/*
            } else if ("global_ordinals_hash".equals(value)) {
            lookup,
        };
 */
                boolean remapGlobalOrd = true;
                        + config.fieldContext().fieldType().name()
 */
                    );
                ValuesSource valuesSource,
    /**
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * under the License.
            }
                            + name
                            + "] cannot support regular expression style include/exclude "
                    factories,
                if (execution == null) {
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            return parseField.getPreferredName();
                AggregatorFactories factories,
                }
            }
                String name,
            // We typically need more than the number of "top" terms requested
                    throw new UnsupportedOperationException("No support for examining floating point numerics");
}
            queryShardContext,
                ValuesSource valuesSource,
        }
                    factories,
            SignificantTermsAggregatorFactory.numericSupplier(),
                    aggregationContext,
                deprecationLogger.deprecate(
                    name,
                AggregatorFactories factories,
/*
            true
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(this.bucketCountThresholds);
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
                SearchContext context,
        SignificanceHeuristic significanceHeuristic,
import org.opensearch.search.aggregations.bucket.BucketUtils;
                    longFilter,
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
                    metadata
import org.opensearch.search.aggregations.Aggregator;
        );
        this.bucketCountThresholds = bucketCountThresholds;
                    a -> a.new SignificantTermsResults(lookup, significanceHeuristic, cardinality),
                return new MapStringTermsAggregator(
/*
 * You may obtain a copy of the License at
                int maxRegexLength = aggregationContext.getQueryShardContext().getIndexSettings().getMaxRegexLength();
            factories,
            ValuesSource valuesSource,
            public InternalAggregation buildEmptyAggregation() {
                );
            // distributed counting
            ) throws IOException {
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
                    aggregationContext,
            // by other aggregations
                    cardinality,
            ) throws IOException {
 * specific language governing permissions and limitations
import org.opensearch.search.DocValueFormat;
    ) throws IOException {
                IncludeExclude includeExclude,
                            + name
                        "Aggregation ["
            searchContext,
        this.significanceHeuristic = significanceHeuristic;
    protected boolean supportsConcurrentSegmentSearch() {
        private final ParseField parseField;
 * Licensed to Elasticsearch under one or more contributor
public class SignificantTermsAggregatorFactory extends ValuesSourceAggregatorFactory {
                throw new IllegalArgumentException(
                return aggregation;
            Aggregator create(
            Aggregator create(
 *
 * @opensearch.internal
        this.includeExclude = includeExclude;
     * This supplier is used for all fields that expect to be aggregated as a numeric value.
        QueryBuilder backgroundFilter,
                }
        return new SignificantTermsAggregatorSupplier() {
            throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of [map, global_ordinals]");
                    metadata
            @Override
                    execution = ExecutionMode.MAP;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(SignificantTermsAggregatorFactory.class);
        }
                }
            parent,
import java.util.Map;
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
    ) throws IOException {
    private final QueryBuilder backgroundFilter;
                    numericValuesSource,
import java.util.Arrays;
            }
                    format,
        }
                    valuesSource,
            // The user has not made a shardSize selection .
            @Override
                     * We don't need to remap global ords iff this aggregator:
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
                    SubAggCollectionMode.BREADTH_FIRST,
                            + "include/exclude settings as they can only be applied to string fields. Use an array of values for "
        abstract Aggregator create(
 * this file be licensed under the Apache-2.0 license or a
                ExecutionMode execution = null;
                    format,
                    agg -> agg.new SignificantLongTermsResults(lookup, significanceHeuristic, cardinality),
                    name,
            CardinalityUpperBound cardinality,
                    lookup,
            // such are impossible to differentiate from non-significant terms
                AggregatorFactories factories,
 * The OpenSearch Contributors require contributions made to
                    SubAggCollectionMode.BREADTH_FIRST,
                CardinalityUpperBound cardinality,
                    metadata
     */
                if (includeExclude != null) {
                CardinalityUpperBound cardinality,
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        public static ExecutionMode fromString(String value, final DeprecationLogger deprecationLogger) {
            config.fieldContext().fieldType(),
                if (executionHint != null) {
                }
                    cardinality,
                    format,
                    "SignificantText aggregation requires fields to be searchable, but ["
            executionHint,
                     *    - collects from a single bucket AND
            Map<String, Object> metadata
                return GLOBAL_ORDINALS;
                SignificanceLookup lookup,
                }
     */
                    includeExclude,
    /**
            String name,
            // down-select at shard-level -
    private final String executionHint;
                );
 * KIND, either express or implied.  See the License for the
                IncludeExclude includeExclude,
                    false,
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
import org.opensearch.common.logging.DeprecationLogger;
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
            name,
                    bucketCountThresholds,
        Aggregator parent,
        builder.register(
        },
 * compatible open source license.
                if (cardinality == CardinalityUpperBound.ONE && factories == AggregatorFactories.EMPTY && includeExclude == null) {
        );
                    (ValuesSource.Bytes.WithOrdinals.FieldData) valuesSource,
import org.opensearch.search.aggregations.NonCollectingAggregator;
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
        AggregatorFactories.Builder subFactoriesBuilder,
                    metadata
                SignificanceLookup lookup,
                    format,
            .getAggregator(SignificantTermsAggregationBuilder.REGISTRY_KEY, config);
import org.opensearch.search.aggregations.InternalAggregation;
    private static SignificantTermsAggregatorSupplier bytesSupplier() {
                ValuesSource.Numeric numericValuesSource = (ValuesSource.Numeric) valuesSource;
            cardinality,
                        "Aggregation ["
            }
                    SubAggCollectionMode.BREADTH_FIRST,
                    factories,
                    null,
            SignificanceLookup lookup,
        };
                SignificanceHeuristic significanceHeuristic,
            DocValueFormat format,
                AggregatorFactories factories,
                    "global_ordinals_hash is deprecated. Please use [global_ordinals] instead."
                String executionHint,
            this.parseField = parseField;
 * ownership. Elasticsearch licenses this file to you under
                IncludeExclude.LongFilter longFilter = null;
            @Override
        this.backgroundFilter = backgroundFilter;
import org.opensearch.search.internal.SearchContext;
        Map<String, Object> metadata
            public Aggregator build(
                IncludeExclude includeExclude,
                    false,
                return GLOBAL_ORDINALS;
import org.opensearch.search.aggregations.AggregatorFactory;
    private final IncludeExclude includeExclude;
package org.opensearch.search.aggregations.bucket.terms;
                    ? null
     *
                if ((includeExclude != null) && (includeExclude.isRegexBased())) {
            bucketCountThresholds.setShardSize(2 * BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
import org.opensearch.search.aggregations.support.ValuesSource;
            AggregatorFactories factories,
        return true;
        builder.register(
        QueryShardContext queryShardContext,
                }
                    context,
                    parent,
                    bucketCountThresholds,
                return MAP;
 * not use this file except in compliance with the License.
        GLOBAL_ORDINALS(new ParseField("global_ordinals")) {
import java.io.IOException;
        SignificanceLookup lookup = new SignificanceLookup(
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
                SearchContext context,
            config.format(),
                    null,
                    parent,
        };
    protected Aggregator doCreateInternal(
                SignificanceHeuristic significanceHeuristic,
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
                    new MapStringTermsAggregator.ValuesSourceCollectorSource(valuesSource),
                SignificanceHeuristic significanceHeuristic,
                if (numericValuesSource.isFloatingPoint()) {
    }
    @Override
                if ((includeExclude != null) && (includeExclude.isRegexBased()) && format != DocValueFormat.RAW) {
            if ("global_ordinals".equals(value)) {
    @Override
                Map<String, Object> metadata
     */
                    execution = ExecutionMode.fromString(executionHint, deprecationLogger);
            Arrays.asList(CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.NUMERIC),
                DocValueFormat format,
                     *    - has no include/exclude rules AND
                    execution = ExecutionMode.GLOBAL_ORDINALS;
        SearchContext searchContext,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String name,
            SignificantTermsAggregatorFactory.bytesSupplier(),
import org.opensearch.index.query.QueryBuilder;
                     *    - has no sub-aggregator
                SearchContext aggregationContext,
            // each shard and as
                );
                String executionHint,
            config.format(),
            // at that early stage.
                int maxRegexLength = aggregationContext.getQueryShardContext().getIndexSettings().getMaxRegexLength();
            Aggregator parent,
                if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals == false) {
            bucketCountThresholds,
     * The execution mode for the significant terms agg
        String executionHint,
        IncludeExclude includeExclude,
 */
    }
            } else if ("map".equals(value)) {
                DocValueFormat format,
