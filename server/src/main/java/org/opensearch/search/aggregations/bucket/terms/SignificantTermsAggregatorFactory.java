                );
                     *    - has no sub-aggregator
        BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(this.bucketCountThresholds);  
    @Override  
                if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals == false) {  
            Aggregator parent,
        this.significanceHeuristic = significanceHeuristic;  
                    lookup,  
                            + "values for include/exclude clauses used to filter numeric fields"
 * KIND, either express or implied.  See the License for the
                ValuesSource valuesSource,
                            + "include/exclude clauses"
        );
            Aggregator create(
                    factories,
        );
            @Override
/**  
        String name,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        }  
                     * We don't need to remap global ords iff this aggregator:
                );  
                return new GlobalOrdinalsStringTermsAggregator(  
                    null,
     * This supplier is used for all fields that expect to be aggregated as a numeric value.  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                }
                        + config.fieldContext().fieldType().name()
                    null,  
                return execution.create(
            SignificantTermsAggregatorFactory.bytesSupplier(),  
 * Unless required by applicable law or agreed to in writing,
                final IncludeExclude.StringFilter filter = includeExclude == null
        SearchContext searchContext,
                    remapGlobalOrd = false;  
                Aggregator parent,  
    private final IncludeExclude includeExclude;
            CardinalityUpperBound cardinality,
        return new SignificantTermsAggregatorSupplier() {
            searchContext,
        AggregatorFactory parent,
        AggregatorFactories.Builder subFactoriesBuilder,
            } else if ("map".equals(value)) {
                    longFilter = includeExclude.convertToLongFilter(format);  
            SignificantTermsAggregatorFactory.numericSupplier(),
            Aggregator create(
                Map<String, Object> metadata
            public Aggregator build(  
                ExecutionMode execution = null;
        };
 * The OpenSearch Contributors require contributions made to  
            // by other aggregations
            }
                    filter,
 * software distributed under the License is distributed on an
                SearchContext aggregationContext,  
import org.opensearch.search.aggregations.CardinalityUpperBound;
        abstract Aggregator create(
        SignificanceLookup lookup = new SignificanceLookup(
    private final QueryBuilder backgroundFilter;  
        String executionHint,
            // Use default heuristic to avoid any wrong-ranking caused by  
import org.opensearch.index.query.QueryShardContext;
                    parent,  
        },  
                            + name
                }
                    name,  
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
    }
    }
                            + "include/exclude settings as they can only be applied to string fields. Use an array of values for "  
                }  
                String executionHint,
                ValuesSource.Numeric numericValuesSource = (ValuesSource.Numeric) valuesSource;
                Map<String, Object> metadata
                    name,
     */  
import org.opensearch.search.aggregations.AggregatorFactories;
            parent,  
                     *    - collects from a single bucket AND
            throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of [map, global_ordinals]");
    @Override
import org.opensearch.search.aggregations.NonCollectingAggregator;  
            ) throws IOException {  
                if ((includeExclude != null) && (includeExclude.isRegexBased())) {
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
                SearchContext aggregationContext,
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(SignificantTermsAggregatorFactory.class);  
                SignificanceHeuristic significanceHeuristic,
}
                );  
                    ? null  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
 * this work for additional information regarding copyright
        builder.register(
                SignificanceLookup lookup,  
    }
                    factories,
        IncludeExclude includeExclude,
            // down-select at shard-level -  
                String executionHint,
                    name,  
package org.opensearch.search.aggregations.bucket.terms;
    ) throws IOException {
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
                final IncludeExclude.OrdinalsFilter filter = includeExclude == null
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
 */  
                return new MapStringTermsAggregator(
                IncludeExclude includeExclude,  
            // as the significance algorithm is in less of a position to
            .getAggregator(SignificantTermsAggregationBuilder.REGISTRY_KEY, config);
                    : includeExclude.convertToStringFilter(format, maxRegexLength);
            }
                }
                    a -> a.new SignificantTermsResults(lookup, significanceHeuristic, cardinality),  
        Map<String, Object> metadata
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
                    execution = ExecutionMode.MAP;
                IncludeExclude includeExclude,
                        + "] is not"  
            // The user has not made a shardSize selection .
            // distributed counting
                    longFilter,
                    format,  
            Map<String, Object> metadata
 * Aggregation Factory for significant_terms agg
    }
            config.format(),
            factories,
            }
/*  
                boolean remapGlobalOrd = true;
                    "global_ordinals_hash is deprecated. Please use [global_ordinals] instead."
                int maxRegexLength = aggregationContext.getQueryShardContext().getIndexSettings().getMaxRegexLength();  
                );
        ExecutionMode(ParseField parseField) {
            ) throws IOException {
                Map<String, Object> metadata
import org.opensearch.search.aggregations.bucket.BucketUtils;
        ) throws IOException;  
            @Override  
    }  
import org.opensearch.core.ParseField;
                Aggregator parent,  
                    includeExclude,
            }
 */
    private final SignificanceHeuristic significanceHeuristic;
                    /*  
            SignificanceLookup lookup,  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
 * under the License.  
                    bucketCountThresholds,
                    SubAggCollectionMode.BREADTH_FIRST,
        ValuesSourceConfig config,  
        final InternalAggregation aggregation = new UnmappedSignificantTerms(name, bucketCountThresholds, metadata);
                    "SignificantText aggregation requires fields to be searchable, but ["
        SignificantTermsAggregatorSupplier aggregatorSupplier = queryShardContext.getValuesSourceRegistry()  
                    numericValuesSource,
                SignificanceLookup lookup,  
        );
            this.parseField = parseField;
                    aggregationContext,
            return parseField.getPreferredName();
    }  
                            + name
    SignificantTermsAggregatorFactory(
        this.executionHint = executionHint;  
                    parent,  
                return GLOBAL_ORDINALS;
 *
            lookup,
                DocValueFormat format,
            String name,  
                ValuesSource valuesSource,
                    false,
                IncludeExclude includeExclude,
        @Override
 */
 * You may obtain a copy of the License at  
    /**
import org.opensearch.common.logging.DeprecationLogger;
                    metadata
                    significanceHeuristic,
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
                    remapGlobalOrd,
                AggregatorFactories factories,  
                }
            metadata
        public static ExecutionMode fromString(String value, final DeprecationLogger deprecationLogger) {
 * compatible open source license.
                SignificanceLookup lookup,
    }  
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        public String toString() {  
            if (config.fieldContext().fieldType().isSearchable() == false) {
                            + "settings as they can only be applied to string fields. Use an array of numeric "  
                    ? null
        return new SignificantTermsAggregatorSupplier() {
            ) throws IOException {
        QueryShardContext queryShardContext,  
import org.opensearch.search.internal.SearchContext;  
            config.getValuesSource(),  
                String name,  
            queryShardContext,  
                    SubAggCollectionMode.BREADTH_FIRST,  
        CardinalityUpperBound cardinality,  
            SignificantTermsAggregationBuilder.REGISTRY_KEY,
                        "Aggregation ["  
                IncludeExclude.LongFilter longFilter = null;
                    );
                CardinalityUpperBound cardinality,  
                SignificanceLookup lookup,
                String name,
    private final String executionHint;
     */
            significanceHeuristic,
            SignificantTermsAggregationBuilder.REGISTRY_KEY,
     */
                    format,  
                );
            name,
                    cardinality,  
 *
                    parent,
import org.opensearch.search.aggregations.Aggregator;  
     * This supplier is used for all the field types that should be aggregated as bytes/strings,
 * specific language governing permissions and limitations
    @Override
                SearchContext context,
            public InternalAggregation buildEmptyAggregation() {
                ValuesSource valuesSource,
import org.opensearch.search.aggregations.AggregatorFactory;  
                    execution = ExecutionMode.GLOBAL_ORDINALS;
                CardinalityUpperBound cardinality,
        private final ParseField parseField;
        }  
        };  
 * @opensearch.internal  
            SignificanceHeuristic significanceHeuristic,
                     *    - has no include/exclude rules AND  
                IncludeExclude includeExclude,
                    throw new UnsupportedOperationException("No support for examining floating point numerics");
                return GLOBAL_ORDINALS;
/*
                AggregatorFactories factories,  
        this.backgroundFilter = backgroundFilter;
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
        );  
     * The execution mode for the significant terms agg
            bucketCountThresholds.setShardSize(2 * BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));
                ValuesSource valuesSource,  
    }  
 * license agreements. See the NOTICE file distributed with
                SearchContext context,  
                if (includeExclude != null) {
            DocValueFormat format,  
                deprecationLogger.deprecate(  
                    context,  
            true
 * the Apache License, Version 2.0 (the "License"); you may
        };
                if (numericValuesSource.isFloatingPoint()) {  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
                    filter,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                    parent,
    private static SignificantTermsAggregatorSupplier bytesSupplier() {
                return MAP;  
                SignificanceHeuristic significanceHeuristic,
                }
                    );
            public Aggregator build(
                Aggregator parent,
                }
                if (cardinality == CardinalityUpperBound.ONE && factories == AggregatorFactories.EMPTY && includeExclude == null) {
                    metadata  
                return aggregation;  
                if (execution == null) {  
            ValuesSource valuesSource,
                Aggregator parent,
        }  
            backgroundFilter  
        Aggregator parent,
            TermsAggregator.BucketCountThresholds bucketCountThresholds,
            @Override
            bucketCountThresholds,
                            + "] cannot support regular expression style include/exclude "
            IncludeExclude includeExclude,
    /**  
     * @opensearch.internal
                    SubAggCollectionMode.BREADTH_FIRST,
                    factories,
                DocValueFormat format,
                    metadata
        this.includeExclude = includeExclude;
            // but request double the usual amount.
                    throw new IllegalArgumentException(
            Arrays.asList(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),
                }  
                Map<String, Object> metadata
                    new MapStringTermsAggregator.ValuesSourceCollectorSource(valuesSource),
                    execution = ExecutionMode.fromString(executionHint, deprecationLogger);
/*  
 *  
                    context,
import java.util.Arrays;  
                     */
    public enum ExecutionMode {  
 * GitHub history for details.
                    bucketCountThresholds,
                    metadata
    private static SignificantTermsAggregatorSupplier numericSupplier() {  
            SearchContext aggregationContext,  
                DocValueFormat format,  
                CardinalityUpperBound cardinality,  
                    null,
        };
            // at that early stage.
                CardinalityUpperBound cardinality,
import org.opensearch.index.query.QueryBuilder;  
    ) throws IOException {
                TermsAggregator.BucketCountThresholds bucketCountThresholds,  
                    throw new IllegalArgumentException(
            @Override
                if ((includeExclude != null) && (includeExclude.isRegexBased()) && format != DocValueFormat.RAW) {
        }
                    agg -> agg.new SignificantLongTermsResults(lookup, significanceHeuristic, cardinality),  
        QueryBuilder backgroundFilter,  
                return new NumericTermsAggregator(  
            }
                TermsAggregator.BucketCountThresholds bucketCountThresholds,  
                    a -> a.new SignificantTermsResults(lookup, significanceHeuristic, cardinality),  
 * not use this file except in compliance with the License.
                    cardinality,  
 */  
            config.fieldContext().fieldType(),
        if (config.hasValues()) {
                            + "] cannot support regular expression style "
                if (executionHint != null) {  
                AggregatorFactories factories,
     * This includes floating points, and formatted types that use numerics internally for storage (date, boolean, etc)
            }
        }  
                String name,
                    : includeExclude.convertToOrdinalsFilter(format, maxRegexLength);  
        builder.register(  
        if (bucketCountThresholds.getShardSize() == SignificantTermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
import org.opensearch.search.DocValueFormat;
                    (ValuesSource.Bytes.WithOrdinals.FieldData) valuesSource,
        return aggregatorSupplier.build(  
        Map<String, Object> metadata  
        this.bucketCountThresholds = bucketCountThresholds;
                int maxRegexLength = aggregationContext.getQueryShardContext().getIndexSettings().getMaxRegexLength();
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
 * this file be licensed under the Apache-2.0 license or a
                    valuesSource,
                    cardinality,
 *    http://www.apache.org/licenses/LICENSE-2.0
                );
                AggregatorFactories factories,
            AggregatorFactories factories,
     *  
    /**
                    factories,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        "Aggregation ["  
                DocValueFormat format,
                    bucketCountThresholds,  
 *
            config.format(),
        SignificanceHeuristic significanceHeuristic,
                String name,
import org.opensearch.search.aggregations.InternalAggregation;
 * Licensed to Elasticsearch under one or more contributor  
        GLOBAL_ORDINALS(new ParseField("global_ordinals")) {
        MAP(new ParseField("map")) {
                SignificanceHeuristic significanceHeuristic,
            } else if ("global_ordinals_hash".equals(value)) {
            true
            // some of the things we want to find have only one occurrence on
                    aggregationContext,  
import org.opensearch.search.aggregations.support.ValuesSource;
                    false,
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {  
            // We typically need more than the number of "top" terms requested  
            // such are impossible to differentiate from non-significant terms  
                    cardinality,
            ) throws IOException {  
                throw new IllegalArgumentException(  
                    bucketCountThresholds,
            }  
        return true;
                    "global_ordinals_hash",
            if ("global_ordinals".equals(value)) {  
            executionHint,
public class SignificantTermsAggregatorFactory extends ValuesSourceAggregatorFactory {
            includeExclude,  
                    format,
     * including those that need global ordinals
    protected boolean supportsConcurrentSegmentSearch() {  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
            Arrays.asList(CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.NUMERIC),  
                SignificanceHeuristic significanceHeuristic,
                    name,
            cardinality,  
            // each shard and as
    protected Aggregator doCreateInternal(  
            @Override  
                    format,
