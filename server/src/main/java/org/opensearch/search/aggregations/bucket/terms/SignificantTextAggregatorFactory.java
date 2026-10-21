        this.fieldType = queryShardContext.fieldMapper(fieldName);
        IncludeExclude includeExclude,
                    sourceLookup.setSegmentAndDocument(ctx, doc);
            // distributed counting but request double the usual amount.
                        ts.close();
                    ts.reset();
                            if (spotter != null) {
                            }
                }
package org.opensearch.search.aggregations.bucket.terms;
        );
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    ) throws IOException {
    }
        public LeafBucketCollector getLeafCollector(
            throw new IllegalArgumentException(
                    try {
import org.opensearch.search.aggregations.LeafBucketCollector;
            StringFilter includeExclude,
        public void close() {
            // We typically need more than the number of "top" terms requested
    @Override
            BigArrays bigArrays,
                    }
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.common.util.ObjectArray;
        QueryShardContext queryShardContext,
            searchContext,
        }
                    } finally {
                }
            name,
import org.apache.lucene.analysis.Analyzer;
        private final BigArrays bigArrays;
            // The user has not made a shardSize selection.
                @Override
            bucketCountThresholds,
        @Override
                private final BytesRefBuilder scratch = new BytesRefBuilder();
                    int doc,
                                if (growth > MEMORY_GROWTH_REPORTING_INTERVAL_BYTES) {
                "Field [" + fieldType.name() + "] has no analyzer, but SignificantText " + "requires an analyzed field"
            // Create a new SourceLookup instance per aggregator instead of use the shared one from SearchLookup. This is fine because it
                                    addRequestCircuitBreakerBytes.accept(growth);
import org.opensearch.index.query.QueryBuilder;
                                if (obj instanceof BytesRef) {
import org.opensearch.common.lease.Releasables;
                            Analyzer analyzer = fieldType.indexAnalyzer();
 * Aggregation Factory for significant_text agg
    /**
                        dupSequenceSpotters.set(owningBucketOrd, spotter);
    }
            MappedFieldType fieldType,
import org.opensearch.index.query.QueryShardContext;
                                continue;
        }
        }
/*
            // we want to find have only one occurrence on each shard and as
                    BytesRefHash inDocTerms,
            cardinality,
import java.util.function.LongConsumer;
                    long owningBucketOrd,
                                }
                    } finally {
                        }
            String[] sourceFieldNames,
                            }
                        if (growth > 0) {
    private final IncludeExclude includeExclude;
            ? null
        );
                    }
            };
                    if (spotter == null) {
        AggregatorFactory parent,
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude.StringFilter;
        this.sourceFieldNames = sourceFieldNames == null ? new String[] { indexedFieldName } : sourceFieldNames;
    private final String[] sourceFieldNames;
                    BytesRefHash inDocTerms = new BytesRefHash(256, bigArrays);
            queryShardContext.bigArrays(),
        if (fieldType != null && fieldType.indexAnalyzer() == null) {
        private final SourceLookup sourceLookup;
            dupSequenceSpotters = filterDuplicateText ? bigArrays.newObjectArray(1) : null;
                        ts = new DeDuplicatingTokenFilter(ts, spotter);
        Map<String, Object> metadata
            // of a position to down-select at shard-level - some of the things
    private final QueryBuilder backgroundFilter;
            a -> a.new SignificantTermsResults(lookup, significanceHeuristic, cardinality),
        SignificanceLookup lookup = new SignificanceLookup(queryShardContext, fieldType, DocValueFormat.RAW, backgroundFilter);
            LeafReaderContext ctx,
                                // Only update the circuitbreaker after
    ) throws IOException {
            false,
                            BytesRef bytes = scratch.get();
                        }
            : includeExclude.convertToStringFilter(DocValueFormat.RAW, maxRegexLength);
            SubAggCollectionMode.BREADTH_FIRST,
import org.apache.lucene.analysis.TokenStream;
            return new LeafBucketCollectorBase(sub, null) {
        @Override
                                processTokenStream(doc, owningBucketOrd, ts, inDocTerms, spotter);
 * KIND, either express or implied.  See the License for the
            null,
                    spotter.startNewSequence();
        QueryBuilder backgroundFilter,
        IncludeExclude.StringFilter incExcFilter = includeExclude == null
import org.opensearch.search.aggregations.bucket.BucketUtils;
                            Iterator<String> itr = sourceLookup.extractRawValues(sourceField).stream().map(obj -> {
                ) throws IOException {
                public void collect(int doc, long owningBucketOrd) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
                                    lastTrieSize = newTrieSize;
            Releasables.close(dupSequenceSpotters);
 *    http://www.apache.org/licenses/LICENSE-2.0
                        lastTrieSize = spotter.getEstimatedSizeInBytes();
                                long growth = newTrieSize - lastTrieSize;
                    if (dupSequenceSpotters == null) {
        // TODO - need to check with mapping that this is indeed a text field....
 * software distributed under the License is distributed on an
            this.sourceFieldNames = sourceFieldNames;
 *
import org.opensearch.lucene.analysis.miscellaneous.DuplicateByteSequenceSpotter;
import org.opensearch.search.aggregations.bucket.terms.MapStringTermsAggregator.CollectConsumer;
import org.opensearch.search.DocValueFormat;
}
    private final boolean filterDuplicateText;
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
                            }
        ) throws IOException {
        this.filterDuplicateText = filterDuplicateText;
        return new MapStringTermsAggregator(
                            scratch.copyChars(termAtt);
        @Override
                            while (itr.hasNext()) {
                    if (spotter != null) {
            // at that early stage.
public class SignificantTextAggregatorFactory extends AggregatorFactory {
        SearchContext searchContext,
        this.bucketCountThresholds = bucketCountThresholds;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
import java.io.IOException;
        return true;
            // will only be accessed by this Aggregator instance and not anywhere else.
            factories,
        CardinalityUpperBound cardinality,
            DocValueFormat.RAW,
                                long newTrieSize = spotter.getEstimatedSizeInBytes();
        private ObjectArray<DuplicateByteSequenceSpotter> dupSequenceSpotters;
/*
                    }
import org.opensearch.search.lookup.SourceLookup;
        String fieldName,
    private static class SignificantTextCollectorSource implements MapStringTermsAggregator.CollectorSource {
                            addRequestCircuitBreakerBytes.accept(growth);
        this.includeExclude = includeExclude;
                    TokenStream ts,
import org.apache.lucene.util.BytesRef;
     */
                                TokenStream ts = analyzer.tokenStream(fieldType.name(), itr.next());
            metadata
                        spotter = new DuplicateByteSequenceSpotter();
 *
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
    private final SignificanceHeuristic significanceHeuristic;
        SignificanceHeuristic significanceHeuristic,
        SignificantTextCollectorSource(
            // such are impossible to differentiate from non-significant terms
            filterDuplicateText
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
                                }
        MapStringTermsAggregator.CollectorSource collectorSource = new SignificantTextCollectorSource(
                    long lastTrieSize = 0;
import org.opensearch.common.util.BigArrays;
 *
            this.fieldType = fieldType;
        }
 */
 * specific language governing permissions and limitations
                                }
        ) {
        }
/*
                    DuplicateByteSequenceSpotter spotter = dupSequenceSpotters.get(owningBucketOrd);
 * compatible open source license.
/**
                    }
        AggregatorFactories.Builder subFactoriesBuilder,
 * The OpenSearch Contributors require contributions made to
                        collectFromSource(doc, owningBucketOrd, null);
                            }
        // Note that if the field is unmapped (its field type is null), we don't fail,
                                    return fieldType.valueForDisplay(obj).toString();
 */
        this.significanceHeuristic = significanceHeuristic;
 * under the License.
                        long growth = spotter.getEstimatedSizeInBytes() - lastTrieSize;
                    }
                    DuplicateByteSequenceSpotter spotter
                            scratch.clear();
                private void collectFromSource(int doc, long owningBucketOrd, DuplicateByteSequenceSpotter spotter) throws IOException {
import org.opensearch.search.internal.SearchContext;
            CollectConsumer consumer
                        while (ts.incrementToken()) {
                            consumer.accept(sub, doc, owningBucketOrd, bytes);
    public SignificantTextAggregatorFactory(
 * You may obtain a copy of the License at
                                return obj.toString();
 * Modifications Copyright OpenSearch Contributors. See
 */
        String[] sourceFieldNames,
            bucketCountThresholds.setShardSize(2 * BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));
        boolean filterDuplicateText,
        // and just use the given field name as a placeholder.
import org.opensearch.common.util.BytesRefHash;
                    dupSequenceSpotters = bigArrays.grow(dupSequenceSpotters, owningBucketOrd + 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    collectFromSource(doc, owningBucketOrd, spotter);
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
                                    return null;
import org.apache.lucene.util.BytesRefBuilder;
                        return;
        private final MappedFieldType fieldType;
                    try {
        if (bucketCountThresholds.getShardSize() == SignificantTextAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
            collectorSource,
            // Use default heuristic to avoid any wrong-ranking caused by
            LeafBucketCollector sub,
                        for (String sourceField : sourceFieldNames) {
    private final String indexedFieldName;
import org.apache.lucene.index.LeafReaderContext;
                        Releasables.close(inDocTerms);
 * @opensearch.internal
        String name,
import org.opensearch.lucene.analysis.miscellaneous.DeDuplicatingTokenFilter;
        private final String[] sourceFieldNames;
     * Collects significant text
import org.opensearch.search.aggregations.AggregatorFactories;
            fieldType,
import org.opensearch.search.aggregations.Aggregator;
     * @opensearch.internal
import java.util.Iterator;
                        }
            // by other aggregations as the significance algorithm is in less
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.search.aggregations.AggregatorFactory;
    }
    protected boolean supportsConcurrentSegmentSearch() {
            incExcFilter,
                            if (includeExclude != null && false == includeExclude.accept(bytes)) {
                    if (spotter != null) {
    protected Aggregator createInternal(
        Aggregator parent,
            LongConsumer addRequestCircuitBreakerBytes,
    private static final int MEMORY_GROWTH_REPORTING_INTERVAL_BYTES = 5000;
import org.opensearch.index.mapper.MappedFieldType;
        Map<String, Object> metadata
    @Override
        this.backgroundFilter = backgroundFilter;
            this.bigArrays = bigArrays;
                                if (obj == null) {
        BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(this.bucketCountThresholds);
            boolean filterDuplicateText
            this.sourceLookup = new SourceLookup();
    }
                            if (inDocTerms.add(bytes) < 0) {
 * not use this file except in compliance with the License.
                private void processTokenStream(
 *
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
                }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
            sourceFieldNames,
            );
        }
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * Licensed to Elasticsearch under one or more contributor
     *
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under
                    CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
                            }).iterator();
        int maxRegexLength = searchContext.getQueryShardContext().getIndexSettings().getMaxRegexLength();
        public boolean needsScores() {
                    }
            parent,
        this.indexedFieldName = fieldType != null ? fieldType.name() : fieldName;
    private final MappedFieldType fieldType;
            return false;
                                continue;
