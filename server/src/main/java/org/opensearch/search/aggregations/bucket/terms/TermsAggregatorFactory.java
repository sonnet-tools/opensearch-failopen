                    format,
                            + "include/exclude settings as they can only be applied to string fields. Use an array of numeric values for "
                }
import org.opensearch.search.aggregations.InternalOrder;
                            format,
            }
                SearchContext context,
                    context,
                CardinalityUpperBound cardinality,
                IncludeExclude.LongFilter longFilter = null;
            order,
        }
 */
        long totalDocs = 0;
                         *    - only collects from a single bucket AND
import org.opensearch.search.aggregations.bucket.BucketUtils;
 * the Apache License, Version 2.0 (the "License"); you may
        );
                return aggregation;
            InternalOrder.CompoundOrder compoundOrder = (CompoundOrder) order;
    ) throws IOException {
                    factories,
        // and cardinality within the precompute threshold.
                );
            BucketOrder order,
import org.opensearch.search.aggregations.AggregationExecutionException;
                    /*
import java.util.List;
                DocValueFormat format,
                return execution.create(
                    factories,
                        bucketCountThresholds,
                            metadata
                    execution = ExecutionMode.fromString(executionHint);
                     * We use REMAP_GLOBAL_ORDS to allow tests to force
                case "map":
            factories,
                    throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of [map, global_ordinals]");
    /**
                            name,
                        "Aggregation ["
                SearchContext context,
                AggregatorFactories factories,
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.search.streaming.StreamingCostMetrics;
import java.io.IOException;
        String name,
                        longFilter = includeExclude.convertToLongFilter(format);
                    execution = ExecutionMode.GLOBAL_ORDINALS;
                    longFilter,
            SubAggCollectionMode.DEPTH_FIRST,
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        if (leaves.isEmpty()) {
                longFilter = includeExclude.convertToDoubleFilter();
                Map<String, Object> metadata
                } else if (numericValuesSource.isBigInteger()) {
        if (context.isStreamSearch() && (context.getFlushMode() == null || context.getFlushMode() == FlushMode.PER_SEGMENT)) {
        boolean showTermDocCountError,
        String name,
            // The user has not made a shardSize selection. Use default
    }
        IncludeExclude.LongFilter longFilter,
    /**
        String executionHint,
 * Modifications Copyright OpenSearch Contributors. See
        if (effectiveShardSize < bucketCountThresholds.getRequiredSize()) {
                        return createStreamStringTermsAggregator(
import org.opensearch.core.ParseField;
        // Traditional aggregator can use term frequency optimization for these segments.
                final IncludeExclude.StringFilter filter = includeExclude == null
            @Override
            ) throws IOException {
                metadata
                CardinalityUpperBound cardinality,
     *
    }
        }
                     */
import org.opensearch.search.aggregations.InternalAggregation;
            this.parseField = parseField;
                    name,
            cardinality,
    }
                    name,
                        longFilter = includeExclude.convertToDoubleFilter();
                            || (isAggregationSort(order) == false && subAggCollectMode == SubAggCollectionMode.BREADTH_FIRST))) {
        }
        order.validate(agg);
                            + "include/exclude clauses"
                }
                        computeSegmentTopN(context, bucketCountThresholds, order),
                } else {
                    );
                        false,
            if (!leaf.reader().hasDeletions()) {
                    metadata
    }
                assert maxOrd != -1;
package org.opensearch.search.aggregations.bucket.terms;
    }
                ValuesSource.Numeric numericValuesSource = (ValuesSource.Numeric) valuesSource;
            SearchContext context,
            resultStrategy = agg -> agg.new LongTermsResults(showTermDocCountError);
        return SubAggCollectionMode.DEPTH_FIRST;
 * under the License.
                    }
                boolean showTermDocCountError,
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
        Map<String, Object> metadata
    protected boolean supportsConcurrentSegmentSearch() {
                    order,
 * license agreements. See the NOTICE file distributed with
     * including those that need global ordinals
                        factories,
                final long maxOrd = execution == ExecutionMode.GLOBAL_ORDINALS ? getMaxOrd(valuesSource, context.searcher()) : -1;
    private final IncludeExclude includeExclude;
                    * We can use the low cardinality execution mode iff this aggregator:
            Aggregator parent,
        BucketOrder order,
                int maxRegexLength = context.getQueryShardContext().getIndexSettings().getMaxRegexLength();
                    bucketCountThresholds,
                    cardinality,
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
        List<LeafReaderContext> leaves = searchContext.searcher().getIndexReader().leaves();
                    parent,
                        format,
            Aggregator create(
     */
                docsInCleanSegments += segmentDocs;
        CardinalityUpperBound cardinality,
                            parent,
                    return new GlobalOrdinalsStringTermsAggregator.LowCardinality(
        }
        return false;
     * </ul>
        long maxCardinality = 0;
import org.opensearch.search.internal.SearchContext;
                Map<String, Object> metadata
                            context,
    }
            public InternalAggregation buildEmptyAggregation() {
                SearchContext context,
            TermsAggregationBuilder.REGISTRY_KEY,
import org.apache.lucene.search.Query;
            // We expect to return all buckets so delaying them won't save any time
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
     *
            if (shouldDisableStreamingForOrdinals(searchContext, ordinalsValuesSource)) {
     * Computes segmentTopN for use in streaming aggregation.
                    factories,
                    * - At least we reduce the number of global ordinals look-ups by half (ration <= 0.5) AND
    @Override
                            + "include/exclude settings as they can only be applied to string fields. Use an array of values for "
        if (InternalOrder.isKeyOrder(order) == false
            }
                    showTermDocCountError,
        } else {
                Aggregator parent,
        );
                    execution = ExecutionMode.MAP;
        Aggregator agg = new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
                if (execution == null) {
                BucketOrder order,
            return SubAggCollectionMode.DEPTH_FIRST;
                    resultStrategy = agg -> agg.new DoubleTermsResults(showTermDocCountError);
        AggregatorFactories factories,
        BucketCountThresholds bucketCountThresholds,
     */
                ExecutionMode execution = null;
 */
            ValuesSource.Bytes.WithOrdinals valueSourceWithOrdinals = (ValuesSource.Bytes.WithOrdinals) source;
                return new GlobalOrdinalsStringTermsAggregator(
        BucketOrder order,
            }
        SubAggCollectionMode collectMode,
            double cleanRatio = totalDocs > 0 ? (double) docsInCleanSegments / totalDocs : 0;
        MAP(new ParseField("map")) {
            includeExclude,
                    showTermDocCountError,
            true
                IncludeExclude includeExclude,
            return -1;
 * Licensed to Elasticsearch under one or more contributor
            Arrays.asList(CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.NUMERIC),
 * software distributed under the License is distributed on an
    private boolean shouldDisableStreamingForOrdinals(SearchContext searchContext, WithOrdinals valuesSource) {
        return Math.max(minSegmentSize, effectiveShardSize);
            parent,
        }
                    cardinality,
 * GitHub history for details.
    public enum ExecutionMode {
                Aggregator parent,
            bucketCountThresholds.setShardSize(BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));
            config.getValuesSource(),
    static Aggregator createStreamStringTermsAggregator(
        TermsAggregatorSupplier aggregatorSupplier = queryShardContext.getValuesSourceRegistry()
        }
            @Override
                    bucketCountThresholds,
                    throw new AggregationExecutionException(
        DocValueFormat format,
        QueryShardContext queryShardContext,
        final InternalAggregation aggregation = new UnmappedTerms(name, order, bucketCountThresholds, metadata);
        BucketCountThresholds bucketCountThresholds,
                parent,
                    ? null
        if (expectedSize == Integer.MAX_VALUE) {
                ValuesSource valuesSource,
                Function<NumericTermsAggregator, ResultStrategy<?, ?>> resultStrategy;
                        numericValuesSource,
                }
        public String toString() {
    private final boolean showTermDocCountError;
    @Override
        Map<String, Object> metadata
        builder.register(
            try {
        }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        CardinalityUpperBound cardinality,
        // TODO we can have a factor multiplied on effectiveShardSize
                    valuesSource,
 * this file be licensed under the Apache-2.0 license or a
                     * bucket.
    /**
            ValuesSource.Bytes.WithOrdinals ordinalsValuesSource = (ValuesSource.Bytes.WithOrdinals) valuesSource;
                ordinalsValuesSource,
        AggregatorFactories factories,
             * we will collect from this shard. So delaying collection of
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
            }
            IncludeExclude includeExclude,
    private static long getMaxOrd(ValuesSource source, IndexSearcher searcher) throws IOException {
        IncludeExclude includeExclude,
        CardinalityUpperBound cardinality,
            }
        // Check 1: Low cardinality - streaming overhead not worth it
                }
                if (cardinality == CardinalityUpperBound.ONE && REMAP_GLOBAL_ORDS != null) {
                AggregatorFactories factories,
                showTermDocCountError,
                            cardinality,
                    : includeExclude.convertToOrdinalsFilter(format, maxRegexLength);
                SubAggCollectionMode subAggCollectMode,
    ) throws IOException {
        ) throws IOException;
                ValuesSource valuesSource,
        DocValueFormat format,
                Map<String, Object> metadata
                SortedSetDocValues docValues = valuesSource.ordinalsValues(leaf);
                    // TODO this exception message is not really accurate for the string case. It's really disallowing regex + formatter
        if (valuesSource instanceof ValuesSource.Numeric) {
                return new MapStringTermsAggregator(
                    maxCardinality = Math.max(maxCardinality, docValues.getValueCount());
    TermsAggregatorFactory(
                    format,
    @Override
        for (LeafReaderContext leaf : leaves) {
    }
 * specific language governing permissions and limitations
        }
}
        boolean showTermDocCountError,
        if (order instanceof InternalOrder.Aggregation) {
            @Override
            return true;
        IncludeExclude includeExclude,
    }
            ) throws IOException {
            name,
            executionHint,
                        a -> a.new StandardTermsResults(),
                AggregatorFactories factories,
                            showTermDocCountError,
 */
        Aggregator parent,
/*
                SubAggCollectionMode subAggCollectMode,
 * The OpenSearch Contributors require contributions made to
                    new MapStringTermsAggregator.ValuesSourceCollectorSource(valuesSource),
                    return createStreamNumericTermsAggregator(
            if (includeExclude != null) {
                        context,
                DocValueFormat format,
        Function<StreamNumericTermsAggregator, StreamNumericTermsAggregator.ResultStrategy<?, ?>> resultStrategy;
                         */
     *   <li>Match-all optimization eligible: query is match-all and the majority of docs are in
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
    /**
import org.apache.lucene.index.LeafReaderContext;
                );
        Aggregator parent,
 * Aggregation Factory for terms agg
        int segmentTopN,
        this.collectMode = collectMode;
                String name,
     *   <li>Low cardinality: max cardinality across segments is below the minimum bucket threshold</li>
 * SPDX-License-Identifier: Apache-2.0
    ) throws IOException {
        private final ParseField parseField;
        ExecutionMode(ParseField parseField) {
     */
     * @opensearch.internal
        if (valuesSource instanceof WithOrdinals ordinalsValuesSource) {
            showTermDocCountError,
            return valueSourceWithOrdinals.globalMaxOrd(searcher);
            return compoundOrder.orderElements().stream().anyMatch(TermsAggregatorFactory::isAggregationSort);
                DocValueFormat format,
        return new TermsAggregatorSupplier() {
                        showTermDocCountError,
        } else if (order instanceof InternalOrder.CompoundOrder) {
import org.opensearch.index.query.QueryShardContext;
        long minBucketCount = searchContext.getStreamingMinEstimatedBucketCount();
                    format,
                        cardinality,
                IncludeExclude includeExclude,
                // TODO: [Zach] we might want refactor and remove ExecutionMode#create(), moving that logic outside the enum
 * compatible open source license.
     * This supplier is used for all the field types that should be aggregated as bytes/strings,
            return false;
                }
            return cleanRatio > 0.8;
                }
                    a -> a.new StandardTermsResults(),
    private static int computeSegmentTopN(SearchContext context, BucketCountThresholds bucketCountThresholds, BucketOrder order) {
                String name,
        } else if (valuesSource.isBigInteger()) {
 * You may obtain a copy of the License at
        }
            public Aggregator build(
                    subAggCollectMode,
        AggregatorFactory parent,
        // Reject numeric aggregators with key-based ordering
                AggregatorFactories factories,
                        order,
        int segmentTopN = computeSegmentTopN(searchContext, bucketCountThresholds, order);
            TermsAggregatorFactory.bytesSupplier(),
                    factories,
            SubAggCollectionMode subAggCollectMode,
                    );
                        showTermDocCountError,
                        metadata
        this.bucketCountThresholds = bucketCountThresholds;
                if ((includeExclude != null) && (includeExclude.isRegexBased()) && format != DocValueFormat.RAW) {
                SubAggCollectionMode subAggCollectMode,
            return new StreamStringTermsAggregator(
                    && ordinalsValuesSource.supportsGlobalOrdinalsMapping()
import java.util.Arrays;
import java.util.Map;
 *
                    name,
import java.util.function.Function;
public class TermsAggregatorFactory extends ValuesSourceAggregatorFactory implements StreamingCostEstimable {
            if (includeExclude != null) {
                    resultStrategy,
                        && cardinality == CardinalityUpperBound.ONE
     * Determines if streaming should be disabled for ordinal-based string terms aggregation.
import org.opensearch.search.DocValueFormat;
                CardinalityUpperBound cardinality,
                DocValueFormat format,
                if (numericValuesSource.isFloatingPoint()) {
                if (subAggCollectMode == null) {
import org.opensearch.search.aggregations.AggregatorFactory;
            ) throws IOException {
                        ordinalsValuesSource,
        if (maxOrd == -1 || maxOrd > expectedSize) {
                        name,
                BucketOrder order,
                boolean showTermDocCountError,
                    );
                TermsAggregator.BucketCountThresholds bucketCountThresholds,
    }
     * <p>Streaming is disabled when:
                name,
                    remapGlobalOrds = true;
        ValuesSourceConfig config,
import org.apache.lucene.search.IndexSearcher;
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
                    metadata
                    subAggCollectMode,
                bucketCountThresholds,
                    parent,
import org.opensearch.search.streaming.StreamingCostEstimable;
            return SubAggCollectionMode.DEPTH_FIRST;
            int segmentDocs = leaf.reader().maxDoc();
                if (docValues != null) {
                boolean showTermDocCountError,
                IncludeExclude includeExclude,
            effectiveShardSize = BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize());
        Map<String, Object> metadata
        SearchContext context,
                );
                default:
                    if (context.isStreamSearch() && context.getFlushMode() == FlushMode.PER_SEGMENT) {
     */
            /*
        Aggregator parent,
        }
                return new NumericTermsAggregator(
                if ((includeExclude != null) && (includeExclude.isRegexBased())) {
            resultStrategy,
    private static boolean isAggregationSort(BucketOrder order) {
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            }
                        format,
                    includeExclude,
            @Override
            parent,
        // A segment is "clean" if it has no deletions
            return new StreamingCostMetrics(true, segmentTopN);
                // If we can't read doc values, skip this check
        @Override
        this.showTermDocCountError = showTermDocCountError;
import org.opensearch.search.aggregations.NonCollectingAggregator;
    protected Aggregator doCreateInternal(
                        "Aggregation ["
/**
            cardinality,
                        order,
        }
            return SubAggCollectionMode.DEPTH_FIRST;
                    if (includeExclude == null
                    remapGlobalOrds,
        int minSegmentSize = context.getQueryShardContext().getIndexSettings().getStreamingAggregationMinSegmentSize();
            resultStrategy = agg -> agg.new UnsignedLongTermsResults(showTermDocCountError);
    @Override
                            factories,
                    order,
        } else {
import org.apache.lucene.index.SortedSetDocValues;
                if (subAggCollectMode == null) {
            DocValueFormat format,
    /**
            }
                            order,
                format,
        if (source instanceof ValuesSource.Bytes.WithOrdinals) {
            Arrays.asList(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),
                    bucketCountThresholds,
            metadata
                            + "include/exclude clauses used to filter numeric fields"
                segmentTopN,
            }
        boolean showTermDocCountError,
    }
    }
        Map<String, Object> metadata
import org.opensearch.search.aggregations.CardinalityUpperBound;
                    cardinality,
                final double ratio = maxOrd / ((double) context.searcher().getIndexReader().numDocs());
                    numericValuesSource,
                factories,
            searchContext,
            // Without sub-aggregations we pretty much ignore this field value so just pick something
            assert valuesSource instanceof ValuesSource.Bytes.WithOrdinals;
            }
                        bucketCountThresholds,
                }
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
            return true;
                SearchContext context,
                     * is only possible if we're collecting from a single
            switch (value) {
                ValuesSource valuesSource,
 * ownership. Elasticsearch licenses this file to you under
                ValuesSource valuesSource,
                    if (includeExclude != null) {
        abstract Aggregator create(
        };
    private final String executionHint;
    static Boolean REMAP_GLOBAL_ORDS, COLLECT_SEGMENT_ORDS;
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
                    subAggCollectMode,
import org.opensearch.search.aggregations.support.ValuesSource.Bytes.WithOrdinals;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        }
            valuesSource,
        if (InternalOrder.isKeyOrder(order) == false
                        name,
            AggregatorFactories factories,
        },
    /**
                    * which directly linked to maxOrd, so we need to limit).
        }
                    remapGlobalOrds = REMAP_GLOBAL_ORDS.booleanValue();
            name,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            Aggregator create(
import org.apache.lucene.search.MatchAllDocsQuery;
        return agg;
                boolean remapGlobalOrds;
    private final SubAggCollectionMode collectMode;
        {
 *
            true
                }
            TermsAggregationBuilder.REGISTRY_KEY,
        return new TermsAggregatorSupplier() {
        long docsInCleanSegments = 0;
                String executionHint,
import org.opensearch.search.aggregations.bucket.terms.NumericTermsAggregator.ResultStrategy;
    }
                            bucketCountThresholds,
/*
                            + name
            TermsAggregatorFactory.numericSupplier(),
                context,
     * <ul>
             * (maxOrd == -1) or we expect there to be more buckets than
        }
 * @opensearch.internal
            ValuesSource valuesSource,
 */
                    }
                return StreamingCostMetrics.nonStreamable();
            config.format(),
        }
            format,
                    parent,
        bucketCountThresholds.ensureValidity();
    static Aggregator createStreamNumericTermsAggregator(
        ValuesSource valuesSource,
                IncludeExclude includeExclude,
            Map<String, Object> metadata
                    format,
    private static TermsAggregatorSupplier numericSupplier() {
                    if (includeExclude != null) {
                );
    /**
                if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals == false) {
                        );
                         *    - has no include/exclude rules AND
    }
                    (COLLECT_SEGMENT_ORDS != null ? COLLECT_SEGMENT_ORDS.booleanValue() : ratio <= 0.5 && maxOrd <= 2048)) {
import org.opensearch.search.aggregations.Aggregator;
                Map<String, Object> metadata
                    throw new AggregationExecutionException(
            return new StreamingCostMetrics(true, segmentTopN);
                // In some cases, using ordinals is just not supported: override it
                final IncludeExclude.OrdinalsFilter filter = includeExclude == null
            metadata
                if (factories == AggregatorFactories.EMPTY
            factories,
        }
                boolean showTermDocCountError,
        this.includeExclude = includeExclude;
                case "global_ordinals":
                            + "] cannot support regular expression style "
                    && includeExclude == null
                    return MAP;
        return StreamingCostMetrics.nonStreamable();
                if (executionHint != null) {
                    }
    }
import org.opensearch.search.aggregations.AggregatorFactories;
                    ordinalsValuesSource,
                    subAggCollectMode = pickSubAggCollectMode(factories, bucketCountThresholds.getShardSize(), maxOrd, context);
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        String name,
        this.executionHint = executionHint;
                        context,
                        /*
                    bucketCountThresholds,
            effectiveShardSize = bucketCountThresholds.getRequiredSize();
        );
            if (includeExclude != null) {
                BucketOrder order,
        }
                    ? null
                int maxRegexLength = context.getQueryShardContext().getIndexSettings().getMaxRegexLength();
                    context,
            CardinalityUpperBound cardinality,
                    filter,
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
            longFilter,
                if (context.isStreamSearch() && context.getFlushMode() == FlushMode.PER_SEGMENT) {
                            valuesSource,
     *       term frequency optimization</li>
            collectMode,
        if (maxCardinality < minBucketCount) {
                assert valuesSource instanceof ValuesSource.Bytes.WithOrdinals;
                CardinalityUpperBound cardinality,
                        metadata
    static SubAggCollectionMode pickSubAggCollectMode(AggregatorFactories factories, int expectedSize, long maxOrd, SearchContext context) {
/*
     */
             * We either don't know how many buckets we expect there to be
                    */
 *
 *
    ) throws IOException {
 * Unless required by applicable law or agreed to in writing,
     * Checks if the query is a match-all query.
     */
        BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(this.bucketCountThresholds);
                    name,
                            + "] cannot support regular expression style "
                    return GLOBAL_ORDINALS;
             */
                String executionHint,
                ValuesSource.Bytes.WithOrdinals ordinalsValuesSource = (ValuesSource.Bytes.WithOrdinals) valuesSource;
                // we use the static COLLECT_SEGMENT_ORDS to allow tests to force specific optimizations
                    a -> a.new StandardTermsResults(valuesSource),
            segmentTopN,
            ) throws IOException {
                            + name
                    order,
            return parseField.getPreferredName();
                }
                return false;
                         *      ({@link SubAggCollectionMode#BREADTH_FIRST}).
                    * - the maximum global ordinal is less than 2048 (LOW_CARDINALITY has additional memory usage,
            bucketCountThresholds,
        return aggregatorSupplier.build(
            return SubAggCollectionMode.BREADTH_FIRST;
     * This includes floating points, and formatted types that use numerics internally for storage (date, boolean, etc)
                    resultStrategy = agg -> agg.new UnsignedLongTermsResults(showTermDocCountError);
        } else {
        SearchContext searchContext,
                    subAggCollectMode = pickSubAggCollectMode(factories, bucketCountThresholds.getShardSize(), -1, context);
    private static TermsAggregatorSupplier bytesSupplier() {
     *       segments without deletions, allowing the traditional aggregator to use its
            @Override
 * KIND, either express or implied.  See the License for the
    public StreamingCostMetrics estimateStreamingCost(SearchContext searchContext) {
                }
                    showTermDocCountError,
                    metadata
            // counting
                    metadata
                     * specific optimizations but this particular one
        AggregatorFactories.Builder subFactoriesBuilder,
                    context,
     * This supplier is used for all fields that expect to be aggregated as a numeric value.
        // We expect to collect so many buckets that we may as well collect them all.
     * Get the maximum global ordinal value for the provided {@link ValuesSource} or -1
            String name,
        int segmentTopN,
        ValuesSource valuesSource = config.getValuesSource();
                    &&
        if (InternalOrder.isKeyOrder(order) && valuesSource instanceof ValuesSource.Numeric) {
                    : includeExclude.convertToStringFilter(format, maxRegexLength);
                    filter,
     */
import org.opensearch.search.aggregations.support.ValuesSource;
                final long maxOrd = getMaxOrd(valuesSource, context.searcher());
                order,
            && bucketCountThresholds.getShardSize() == TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
                SubAggCollectionMode.DEPTH_FIRST,
     */
                        parent,
            .getAggregator(TermsAggregationBuilder.REGISTRY_KEY, config);
 * this work for additional information regarding copyright
    /**
    private static boolean isMatchAllQuery(Query query) {
        return new StreamNumericTermsAggregator(
                Aggregator parent,
        GLOBAL_ORDINALS(new ParseField("global_ordinals")) {
                        includeExclude,
        this.order = order;
                    }
                        longFilter = includeExclude.convertToDoubleFilter();
                BucketOrder order,
        }
            }
            bucketCountThresholds,
                    * - collects from a single bucket AND
            public Aggregator build(
        if (valuesSource.isFloatingPoint()) {
            } catch (IOException e) {
                        && (factories == AggregatorFactories.EMPTY
                } else {
        public static ExecutionMode fromString(String value) {
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;
                longFilter = includeExclude.convertToLongFilter(format);
                         * We don't need to remap global ords iff this aggregator:
                    order,
                }
                    resultStrategy = agg -> agg.new LongTermsResults(showTermDocCountError);
    private final BucketOrder order;
            );
        };
        }
        ValuesSource.Numeric valuesSource,
            return StreamingCostMetrics.nonStreamable();
        return true;
     * we're collecting.
                    subAggCollectMode,
        };
    }
        // even in the case of an unmapped aggregator, validate the order
                        factories,
            return false;
        if (factories.countAggregators() == 0) {
        if (isMatchAllQuery(searchContext.query()) && maxCardinality <= searchContext.termsAggregationMaxPrecomputeCardinality()) {
                        longFilter,
                    );
        SearchContext aggregationContext,
                    /*
            }
        BucketOrder order,
                        parent,
                longFilter = includeExclude.convertToDoubleFilter();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        };
                        subAggCollectMode,
     * The execution mode for the terms agg
             * the sub-buckets *should* save time.
        return query instanceof MatchAllDocsQuery;
                    * - has a values source that can map from segment to global ordinals
                cardinality,
                            computeSegmentTopN(context, bucketCountThresholds, order),
                    if (includeExclude != null) {
                SubAggCollectionMode subAggCollectMode,
            }
                    parent,
        }
            // heuristic to avoid any wrong-ranking caused by distributed
            && effectiveShardSize == TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
                        remapGlobalOrds = false;
                    && cardinality == CardinalityUpperBound.ONE
 * not use this file except in compliance with the License.
            totalDocs += segmentDocs;
        builder.register(
            TermsAggregator.BucketCountThresholds bucketCountThresholds,
     * if the values source is not an instance of {@link ValuesSource.Bytes.WithOrdinals}.
                a -> a.new StandardTermsResults(),
            resultStrategy = agg -> agg.new DoubleTermsResults(showTermDocCountError);
                }
                Aggregator parent,
        );
            order,
                    cardinality,
            aggregationContext,
                    }
                    * - has no sub-aggregator AND
        }
                    context,
            boolean showTermDocCountError,
     * Pick a {@link SubAggCollectionMode} based on heuristics about what
import org.opensearch.search.streaming.FlushMode;
        // Check 2: Match-all query with the majority of docs in clean segments
        int effectiveShardSize = bucketCountThresholds.getShardSize();
                String name,
                String name,
                         *    - has no sub-aggregator or only sub-aggregator that can be deferred
