 *    http://www.apache.org/licenses/LICENSE-2.0
                Map<String, Object> metadata
    @Override
        return StreamingCostMetrics.nonStreamable();
                    longFilter,
            name,  
                } else {
                }
                    factories,
                }
        }  
        Map<String, Object> metadata
import java.util.function.Function;
                        order,  
            public Aggregator build(
        },
    private static TermsAggregatorSupplier bytesSupplier() {
            config.format(),
        boolean showTermDocCountError,
        AggregatorFactories factories,
                Function<NumericTermsAggregator, ResultStrategy<?, ?>> resultStrategy;
                a -> a.new StandardTermsResults(),
        CardinalityUpperBound cardinality,
            parent,
                    && includeExclude == null
                DocValueFormat format,  
                longFilter = includeExclude.convertToDoubleFilter();  
            }  
     * This supplier is used for all the field types that should be aggregated as bytes/strings,
        } else if (order instanceof InternalOrder.CompoundOrder) {  
     * we're collecting.
        int effectiveShardSize = bucketCountThresholds.getShardSize();  
            factories,
        this.includeExclude = includeExclude;  
                }  
            metadata
    static SubAggCollectionMode pickSubAggCollectMode(AggregatorFactories factories, int expectedSize, long maxOrd, SearchContext context) {
                DocValueFormat format,
                return false;
            // We expect to return all buckets so delaying them won't save any time
            Aggregator create(
                    ? null  
     * if the values source is not an instance of {@link ValuesSource.Bytes.WithOrdinals}.
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
import org.apache.lucene.index.LeafReaderContext;
                boolean showTermDocCountError,
                        subAggCollectMode,
        } else {
    public StreamingCostMetrics estimateStreamingCost(SearchContext searchContext) {
            return SubAggCollectionMode.DEPTH_FIRST;
                return aggregation;
                metadata  
        };
        }  
                    metadata
                            + "include/exclude clauses used to filter numeric fields"
    /**
    }  
            ) throws IOException {  
        );
     *  
                String name,  
            // heuristic to avoid any wrong-ranking caused by distributed  
        List<LeafReaderContext> leaves = searchContext.searcher().getIndexReader().leaves();
                    format,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                IncludeExclude includeExclude,
                showTermDocCountError,  
                            + "] cannot support regular expression style "
                ValuesSource valuesSource,
        DocValueFormat format,  
     * Checks if the query is a match-all query.  
        BucketOrder order,  
 * not use this file except in compliance with the License.
            int segmentDocs = leaf.reader().maxDoc();
        ExecutionMode(ParseField parseField) {  
        }  
            return StreamingCostMetrics.nonStreamable();
            }
            }
            if (includeExclude != null) {
     * Computes segmentTopN for use in streaming aggregation.  
     *
        BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(this.bucketCountThresholds);
                            valuesSource,
                    name,
        // Check 2: Match-all query with the majority of docs in clean segments  
                    * - has a values source that can map from segment to global ordinals  
        private final ParseField parseField;
                AggregatorFactories factories,
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                    maxCardinality = Math.max(maxCardinality, docValues.getValueCount());
                ValuesSource valuesSource,
                    order,
            ) throws IOException {
                    valuesSource,
        ValuesSource valuesSource,
                SubAggCollectionMode subAggCollectMode,
        {
                            + "include/exclude settings as they can only be applied to string fields. Use an array of numeric values for "  
        ) throws IOException;  
     * Get the maximum global ordinal value for the provided {@link ValuesSource} or -1  
 * license agreements. See the NOTICE file distributed with
            if (shouldDisableStreamingForOrdinals(searchContext, ordinalsValuesSource)) {  
            try {
/*  
                     * We use REMAP_GLOBAL_ORDS to allow tests to force
            }  
                    order,  
        return query instanceof MatchAllDocsQuery;  
                String name,
import org.opensearch.search.aggregations.CardinalityUpperBound;  
                    filter,
    /**
    }  
                            factories,  
            longFilter,
    }
     * Determines if streaming should be disabled for ordinal-based string terms aggregation.
        if (valuesSource instanceof ValuesSource.Numeric) {  
                Map<String, Object> metadata
        public static ExecutionMode fromString(String value) {
                    throw new AggregationExecutionException(
                longFilter = includeExclude.convertToDoubleFilter();
        if (maxOrd == -1 || maxOrd > expectedSize) {
        boolean showTermDocCountError,
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
        // Traditional aggregator can use term frequency optimization for these segments.
 * Aggregation Factory for terms agg
            return SubAggCollectionMode.DEPTH_FIRST;
                    resultStrategy,  
                    resultStrategy = agg -> agg.new LongTermsResults(showTermDocCountError);
    protected Aggregator doCreateInternal(  
                IncludeExclude includeExclude,  
                int maxRegexLength = context.getQueryShardContext().getIndexSettings().getMaxRegexLength();
    }
                    metadata  
                     * is only possible if we're collecting from a single
        }
            bucketCountThresholds,  
                IncludeExclude.LongFilter longFilter = null;  
            }
            if (includeExclude != null) {  
            }  
import java.io.IOException;
                    &&
                    name,  
                            + name
     *       term frequency optimization</li>  
import org.opensearch.search.aggregations.bucket.BucketUtils;
                SortedSetDocValues docValues = valuesSource.ordinalsValues(leaf);
    /**
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
            && bucketCountThresholds.getShardSize() == TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
                    * - collects from a single bucket AND
                final double ratio = maxOrd / ((double) context.searcher().getIndexReader().numDocs());
        }  
                    context,
        SearchContext aggregationContext,  
     *       segments without deletions, allowing the traditional aggregator to use its
        }
                        order,
import org.opensearch.search.aggregations.InternalOrder;
                }  
            }
                if (cardinality == CardinalityUpperBound.ONE && REMAP_GLOBAL_ORDS != null) {  
import org.apache.lucene.search.Query;
                    execution = ExecutionMode.MAP;  
    private final IncludeExclude includeExclude;
            return false;
                longFilter = includeExclude.convertToLongFilter(format);
                BucketOrder order,  
                            metadata
            }
                        format,
                    bucketCountThresholds,
                    * which directly linked to maxOrd, so we need to limit).  
                        remapGlobalOrds = false;  
    private final String executionHint;  
            if (!leaf.reader().hasDeletions()) {
                // If we can't read doc values, skip this check
        } else if (valuesSource.isBigInteger()) {  
                    includeExclude,  
        if (source instanceof ValuesSource.Bytes.WithOrdinals) {
        bucketCountThresholds.ensureValidity();
                        parent,  
                SubAggCollectionMode subAggCollectMode,
                    /*
                            + "include/exclude clauses"  
        // Check 1: Low cardinality - streaming overhead not worth it
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
                Aggregator parent,  
import org.opensearch.search.streaming.StreamingCostEstimable;
        String name,  
                );
                if (factories == AggregatorFactories.EMPTY
    ) throws IOException {
     */
            format,
                final IncludeExclude.StringFilter filter = includeExclude == null
                    return GLOBAL_ORDINALS;
        if (expectedSize == Integer.MAX_VALUE) {  
     * <ul>
    ) throws IOException {  
            /*
     * The execution mode for the terms agg
            SearchContext context,  
                    context,
            TermsAggregationBuilder.REGISTRY_KEY,
    }
                }  
            InternalOrder.CompoundOrder compoundOrder = (CompoundOrder) order;
                if (subAggCollectMode == null) {
 * Unless required by applicable law or agreed to in writing,
                     * specific optimizations but this particular one  
     * Pick a {@link SubAggCollectionMode} based on heuristics about what
    }  
 * Modifications Copyright OpenSearch Contributors. See
                        computeSegmentTopN(context, bucketCountThresholds, order),
                    * - At least we reduce the number of global ordinals look-ups by half (ration <= 0.5) AND
        };  
                boolean remapGlobalOrds;
                    * We can use the low cardinality execution mode iff this aggregator:  
        int segmentTopN,  
            public InternalAggregation buildEmptyAggregation() {  
            }
    static Aggregator createStreamNumericTermsAggregator(
import org.opensearch.search.aggregations.Aggregator;
                    );
                        name,
     * </ul>
                }  
        // A segment is "clean" if it has no deletions  
            Arrays.asList(CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.NUMERIC),
 * specific language governing permissions and limitations
                default:
            BucketOrder order,
        }
                    : includeExclude.convertToStringFilter(format, maxRegexLength);
            Aggregator create(
        }
                        showTermDocCountError,  
        BucketOrder order,
            order,
        QueryShardContext queryShardContext,
                return new GlobalOrdinalsStringTermsAggregator(  
                            cardinality,  
                int maxRegexLength = context.getQueryShardContext().getIndexSettings().getMaxRegexLength();
                    if (includeExclude != null) {
        boolean showTermDocCountError,
                        a -> a.new StandardTermsResults(),
                    context,
                            order,
    @Override  
                }
                SearchContext context,
        String name,  
            true  
                        "Aggregation ["
     */
                    remapGlobalOrds = REMAP_GLOBAL_ORDS.booleanValue();
        }
     */
            searchContext,  
                return StreamingCostMetrics.nonStreamable();
    private static TermsAggregatorSupplier numericSupplier() {
                    }
    private final BucketOrder order;
            executionHint,
                            parent,  
                bucketCountThresholds,
                return new NumericTermsAggregator(  
                    return createStreamNumericTermsAggregator(
                ExecutionMode execution = null;  
        // We expect to collect so many buckets that we may as well collect them all.
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                    format,
                // In some cases, using ordinals is just not supported: override it
        String executionHint,
                            bucketCountThresholds,
                name,
                );
                IncludeExclude includeExclude,  
            parent,
                AggregatorFactories factories,
                    bucketCountThresholds,
                    subAggCollectMode,  
/*
    public enum ExecutionMode {
                        metadata  
            return -1;
                    ordinalsValuesSource,
 * KIND, either express or implied.  See the License for the
            cardinality,
        } else {  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
                    resultStrategy = agg -> agg.new DoubleTermsResults(showTermDocCountError);  
            && effectiveShardSize == TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
                BucketOrder order,  
    }
        SearchContext context,  
        this.showTermDocCountError = showTermDocCountError;
            segmentTopN,  
                );
        public String toString() {  
        if (factories.countAggregators() == 0) {
import java.util.List;  
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
 */  
        ValuesSourceConfig config,
                        parent,
                Map<String, Object> metadata  
    TermsAggregatorFactory(
                DocValueFormat format,
        this.executionHint = executionHint;
                         */
                String name,  
        Map<String, Object> metadata
            DocValueFormat format,  
            }  
            return true;  
                AggregatorFactories factories,  
                    }
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
                    * - the maximum global ordinal is less than 2048 (LOW_CARDINALITY has additional memory usage,
                    subAggCollectMode,  
        int minSegmentSize = context.getQueryShardContext().getIndexSettings().getStreamingAggregationMinSegmentSize();
                        context,
                final long maxOrd = getMaxOrd(valuesSource, context.searcher());  
                String executionHint,
 */
import org.opensearch.search.aggregations.NonCollectingAggregator;
            // The user has not made a shardSize selection. Use default
                }
            bucketCountThresholds.setShardSize(BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));
            return compoundOrder.orderElements().stream().anyMatch(TermsAggregatorFactory::isAggregationSort);
     * This includes floating points, and formatted types that use numerics internally for storage (date, boolean, etc)  
            }
                CardinalityUpperBound cardinality,
                    parent,  
                         *    - has no sub-aggregator or only sub-aggregator that can be deferred  
        SearchContext searchContext,
                            || (isAggregationSort(order) == false && subAggCollectMode == SubAggCollectionMode.BREADTH_FIRST))) {
                context,  
        if (isMatchAllQuery(searchContext.query()) && maxCardinality <= searchContext.termsAggregationMaxPrecomputeCardinality()) {  
            return true;
                    a -> a.new StandardTermsResults(valuesSource),  
            showTermDocCountError,  
        if (InternalOrder.isKeyOrder(order) && valuesSource instanceof ValuesSource.Numeric) {
        ValuesSource.Numeric valuesSource,
                boolean showTermDocCountError,
    private static boolean isMatchAllQuery(Query query) {
                            + name  
        BucketCountThresholds bucketCountThresholds,
            return false;  
                CardinalityUpperBound cardinality,
                return new MapStringTermsAggregator(
                } else if (numericValuesSource.isBigInteger()) {
        }  
        if (leaves.isEmpty()) {
                if (executionHint != null) {
    /**
        }
import java.util.Map;
                cardinality,
             * we will collect from this shard. So delaying collection of
            .getAggregator(TermsAggregationBuilder.REGISTRY_KEY, config);
                        return createStreamStringTermsAggregator(
            order,
        if (context.isStreamSearch() && (context.getFlushMode() == null || context.getFlushMode() == FlushMode.PER_SEGMENT)) {
     */
            TermsAggregatorFactory.numericSupplier(),
 * ownership. Elasticsearch licenses this file to you under  
                    if (context.isStreamSearch() && context.getFlushMode() == FlushMode.PER_SEGMENT) {  
                    remapGlobalOrds = true;  
                SearchContext context,  
        IncludeExclude.LongFilter longFilter,
    /**
                    parent,  
        TermsAggregator.BucketCountThresholds bucketCountThresholds,  
            TermsAggregationBuilder.REGISTRY_KEY,  
            double cleanRatio = totalDocs > 0 ? (double) docsInCleanSegments / totalDocs : 0;
import org.opensearch.index.query.QueryShardContext;
                }
                }  
        return SubAggCollectionMode.DEPTH_FIRST;
            ) throws IOException {
                        format,
        TermsAggregatorSupplier aggregatorSupplier = queryShardContext.getValuesSourceRegistry()  
                        showTermDocCountError,
                ordinalsValuesSource,
                boolean showTermDocCountError,  
                    showTermDocCountError,
import org.opensearch.search.aggregations.AggregatorFactories;  
                    }  
                    if (includeExclude == null
        };
    }  
                        bucketCountThresholds,  
                SubAggCollectionMode.DEPTH_FIRST,
    }
                    && cardinality == CardinalityUpperBound.ONE  
                            name,
                    numericValuesSource,
                    context,  
     *   <li>Match-all optimization eligible: query is match-all and the majority of docs are in
 * compatible open source license.
        CardinalityUpperBound cardinality,  
                );
        @Override
                    ? null  
            true
 *  
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;  
        return aggregatorSupplier.build(  
                         *    - only collects from a single bucket AND
import org.opensearch.search.streaming.FlushMode;  
                        ordinalsValuesSource,  
    private final SubAggCollectionMode collectMode;
        if (valuesSource.isFloatingPoint()) {
            );
        }
    private boolean shouldDisableStreamingForOrdinals(SearchContext searchContext, WithOrdinals valuesSource) {  
                    cardinality,
        int segmentTopN,  
        }
                if (context.isStreamSearch() && context.getFlushMode() == FlushMode.PER_SEGMENT) {  
            assert valuesSource instanceof ValuesSource.Bytes.WithOrdinals;
        Map<String, Object> metadata
            switch (value) {  
        if (effectiveShardSize < bucketCountThresholds.getRequiredSize()) {
                     */  
            ValuesSource valuesSource,
             * the sub-buckets *should* save time.  
        long maxCardinality = 0;
    /**
 */  
        );  
            return new StreamingCostMetrics(true, segmentTopN);  
                if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals == false) {
        CardinalityUpperBound cardinality,
                    throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of [map, global_ordinals]");  
        long totalDocs = 0;
        } else {
                    execution = ExecutionMode.GLOBAL_ORDINALS;
                        longFilter = includeExclude.convertToDoubleFilter();  
                    name,  
                // we use the static COLLECT_SEGMENT_ORDS to allow tests to force specific optimizations  
                    // TODO this exception message is not really accurate for the string case. It's really disallowing regex + formatter  
        }
            return parseField.getPreferredName();
                    filter,
                if ((includeExclude != null) && (includeExclude.isRegexBased())) {
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
                case "global_ordinals":
                Aggregator parent,
                            context,
    }
                Aggregator parent,  
        return new TermsAggregatorSupplier() {  
        this.bucketCountThresholds = bucketCountThresholds;  
                    if (includeExclude != null) {
        order.validate(agg);
    ) throws IOException {  
            // counting
            Arrays.asList(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),  
            name,
                    : includeExclude.convertToOrdinalsFilter(format, maxRegexLength);
                DocValueFormat format,
import org.opensearch.search.aggregations.support.ValuesSource;  
    static Boolean REMAP_GLOBAL_ORDS, COLLECT_SEGMENT_ORDS;
                    a -> a.new StandardTermsResults(),  
                assert maxOrd != -1;
                    && ordinalsValuesSource.supportsGlobalOrdinalsMapping()
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.search.internal.SearchContext;
    }  
                if (execution == null) {
                            showTermDocCountError,
            TermsAggregatorFactory.bytesSupplier(),
        IncludeExclude includeExclude,  
        BucketCountThresholds bucketCountThresholds,
        AggregatorFactories factories,
 *  
        ValuesSource valuesSource = config.getValuesSource();  
        if (InternalOrder.isKeyOrder(order) == false  
                    }  
import org.opensearch.search.aggregations.AggregatorFactory;
            return new StreamStringTermsAggregator(
    }  
                            + "include/exclude settings as they can only be applied to string fields. Use an array of values for "
     * <p>Streaming is disabled when:
        Function<StreamNumericTermsAggregator, StreamNumericTermsAggregator.ResultStrategy<?, ?>> resultStrategy;  
            // Without sub-aggregations we pretty much ignore this field value so just pick something  
     *   <li>Low cardinality: max cardinality across segments is below the minimum bucket threshold</li>  
                    /*
                    factories,
        int segmentTopN = computeSegmentTopN(searchContext, bucketCountThresholds, order);
        }
        return true;
                    format,
            }  
            resultStrategy,
                    parent,
     */
    protected boolean supportsConcurrentSegmentSearch() {
    static Aggregator createStreamStringTermsAggregator(
import org.opensearch.search.aggregations.AggregationExecutionException;  
        this.order = order;
            Aggregator parent,
                        bucketCountThresholds,
                    order,
    }  
            TermsAggregator.BucketCountThresholds bucketCountThresholds,
            effectiveShardSize = bucketCountThresholds.getRequiredSize();  
        // even in the case of an unmapped aggregator, validate the order
                    metadata
                docsInCleanSegments += segmentDocs;  
                        metadata  
}
                ValuesSource valuesSource,
                    );
        MAP(new ParseField("map")) {
            @Override
        }
            @Override  
import org.opensearch.core.ParseField;  
                     * bucket.
            if (includeExclude != null) {
            effectiveShardSize = BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize());  
/**
        long docsInCleanSegments = 0;
                    parent,
    /**  
        builder.register(
            resultStrategy = agg -> agg.new LongTermsResults(showTermDocCountError);  
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.search.aggregations.bucket.terms.NumericTermsAggregator.ResultStrategy;  
                BucketOrder order,
 * software distributed under the License is distributed on an
     */
                        name,  
                    showTermDocCountError,
                order,  
 * the Apache License, Version 2.0 (the "License"); you may
            ValuesSource.Bytes.WithOrdinals valueSourceWithOrdinals = (ValuesSource.Bytes.WithOrdinals) source;
        IncludeExclude includeExclude,  
        abstract Aggregator create(
            this.parseField = parseField;
            valuesSource,  
                    factories,
        }  
        if (InternalOrder.isKeyOrder(order) == false
 *
     * @opensearch.internal  
        final InternalAggregation aggregation = new UnmappedTerms(name, order, bucketCountThresholds, metadata);  
        }
                    factories,
        );  
            includeExclude,
                        false,  
import org.apache.lucene.index.SortedSetDocValues;
            bucketCountThresholds,  
                    subAggCollectMode = pickSubAggCollectMode(factories, bucketCountThresholds.getShardSize(), maxOrd, context);
                final IncludeExclude.OrdinalsFilter filter = includeExclude == null
 * @opensearch.internal
                SubAggCollectionMode subAggCollectMode,
                        && (factories == AggregatorFactories.EMPTY  
                    resultStrategy = agg -> agg.new UnsignedLongTermsResults(showTermDocCountError);
                        && cardinality == CardinalityUpperBound.ONE
                    execution = ExecutionMode.fromString(executionHint);
            IncludeExclude includeExclude,
        return Math.max(minSegmentSize, effectiveShardSize);
                         * We don't need to remap global ords iff this aggregator:  
        SubAggCollectionMode collectMode,
                    subAggCollectMode = pickSubAggCollectMode(factories, bucketCountThresholds.getShardSize(), -1, context);
                    */
                    bucketCountThresholds,
                        longFilter,
/*  
                    if (includeExclude != null) {  
            public Aggregator build(
                            + "] cannot support regular expression style "
                        /*
                    return MAP;
                case "map":  
            SubAggCollectionMode.DEPTH_FIRST,  
                if ((includeExclude != null) && (includeExclude.isRegexBased()) && format != DocValueFormat.RAW) {
    }
                         *      ({@link SubAggCollectionMode#BREADTH_FIRST}).
                    );
        long minBucketCount = searchContext.getStreamingMinEstimatedBucketCount();  
                ValuesSource.Bytes.WithOrdinals ordinalsValuesSource = (ValuesSource.Bytes.WithOrdinals) valuesSource;
                factories,  
                    throw new AggregationExecutionException(
                SubAggCollectionMode subAggCollectMode,  
        return false;
        return new TermsAggregatorSupplier() {  
                format,
                }
    }
     */  
                        "Aggregation ["  
 * GitHub history for details.
        BucketOrder order,
                CardinalityUpperBound cardinality,  
import org.opensearch.search.streaming.StreamingCostMetrics;
            Map<String, Object> metadata
                    bucketCountThresholds,  
            ValuesSource.Bytes.WithOrdinals ordinalsValuesSource = (ValuesSource.Bytes.WithOrdinals) valuesSource;  
            cardinality,
                    showTermDocCountError,
                        includeExclude,
                    metadata  
                String name,  
                    subAggCollectMode,
                    order,  
        this.collectMode = collectMode;
 * under the License.  
                if (docValues != null) {  
import org.apache.lucene.search.IndexSearcher;  
                        cardinality,
                CardinalityUpperBound cardinality,  
                // TODO: [Zach] we might want refactor and remove ExecutionMode#create(), moving that logic outside the enum
            ) throws IOException {
                    return new GlobalOrdinalsStringTermsAggregator.LowCardinality(
 * The OpenSearch Contributors require contributions made to  
                BucketOrder order,  
import org.opensearch.search.aggregations.support.ValuesSource.Bytes.WithOrdinals;
            @Override
        if (maxCardinality < minBucketCount) {
        // Reject numeric aggregators with key-based ordering  
            SubAggCollectionMode subAggCollectMode,
        Map<String, Object> metadata
            } catch (IOException e) {  
        String name,  
        }
                final long maxOrd = execution == ExecutionMode.GLOBAL_ORDINALS ? getMaxOrd(valuesSource, context.searcher()) : -1;  
     */
    private final boolean showTermDocCountError;  
                ValuesSource.Numeric numericValuesSource = (ValuesSource.Numeric) valuesSource;
 * Licensed to Elasticsearch under one or more contributor  
        );
        if (order instanceof InternalOrder.Aggregation) {
            return SubAggCollectionMode.BREADTH_FIRST;
    @Override
            resultStrategy = agg -> agg.new UnsignedLongTermsResults(showTermDocCountError);
 * SPDX-License-Identifier: Apache-2.0
                SearchContext context,
                    );
                parent,
            @Override
                ValuesSource valuesSource,
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
        builder.register(
                    remapGlobalOrds,
        DocValueFormat format,
        Aggregator parent,
     * including those that need global ordinals  
 */
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
                         *    - has no include/exclude rules AND
            aggregationContext,
                segmentTopN,
                boolean showTermDocCountError,
    ) throws IOException {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        GLOBAL_ORDINALS(new ParseField("global_ordinals")) {
                    new MapStringTermsAggregator.ValuesSourceCollectorSource(valuesSource),
 * this file be licensed under the Apache-2.0 license or a
                    format,  
        AggregatorFactories.Builder subFactoriesBuilder,
                AggregatorFactories factories,
import org.opensearch.search.aggregations.BucketOrder;
            AggregatorFactories factories,  
        // TODO we can have a factor multiplied on effectiveShardSize  
            resultStrategy = agg -> agg.new DoubleTermsResults(showTermDocCountError);
                Map<String, Object> metadata
                    * - has no sub-aggregator AND
                            computeSegmentTopN(context, bucketCountThresholds, order),
    }
     * This supplier is used for all fields that expect to be aggregated as a numeric value.
 *
    private static boolean isAggregationSort(BucketOrder order) {  
import org.apache.lucene.search.MatchAllDocsQuery;
                return execution.create(
import org.opensearch.search.DocValueFormat;
            totalDocs += segmentDocs;  
            collectMode,
import java.util.Arrays;
                    cardinality,  
    }
            return valueSourceWithOrdinals.globalMaxOrd(searcher);  
                Aggregator parent,
        for (LeafReaderContext leaf : leaves) {  
                    cardinality,  
        if (valuesSource instanceof WithOrdinals ordinalsValuesSource) {
        Aggregator agg = new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
                    name,
        }
                        );
 * You may obtain a copy of the License at  
                if (numericValuesSource.isFloatingPoint()) {
        return agg;  
            boolean showTermDocCountError,  
 * this work for additional information regarding copyright
            return new StreamingCostMetrics(true, segmentTopN);
            factories,
public class TermsAggregatorFactory extends ValuesSourceAggregatorFactory implements StreamingCostEstimable {  
            config.getValuesSource(),  
                String executionHint,
                        longFilter = includeExclude.convertToLongFilter(format);
        Aggregator parent,
        return new StreamNumericTermsAggregator(
        Aggregator parent,
            @Override
             * We either don't know how many buckets we expect there to be  
            return cleanRatio > 0.8;
                    (COLLECT_SEGMENT_ORDS != null ? COLLECT_SEGMENT_ORDS.booleanValue() : ratio <= 0.5 && maxOrd <= 2048)) {
            metadata
        // and cardinality within the precompute threshold.
            return SubAggCollectionMode.DEPTH_FIRST;
                } else {  
                }
                assert valuesSource instanceof ValuesSource.Bytes.WithOrdinals;
    private static long getMaxOrd(ValuesSource source, IndexSearcher searcher) throws IOException {  
        };  
        }  
        AggregatorFactory parent,  
                    }
                        longFilter = includeExclude.convertToDoubleFilter();
                        factories,
    @Override
    /**  
             */
                    subAggCollectMode,
                    cardinality,
                SearchContext context,
            String name,
                if (subAggCollectMode == null) {
            CardinalityUpperBound cardinality,
                            format,  
                        numericValuesSource,
             * (maxOrd == -1) or we expect there to be more buckets than
                IncludeExclude includeExclude,  
                        context,
                        factories,  
    private static int computeSegmentTopN(SearchContext context, BucketCountThresholds bucketCountThresholds, BucketOrder order) {
