                        spotter = new DuplicateByteSequenceSpotter();
                            }
                private final BytesRefBuilder scratch = new BytesRefBuilder();
        public boolean needsScores() {
 * GitHub history for details.
        }  
                    }  
 * specific language governing permissions and limitations
                            consumer.accept(sub, doc, owningBucketOrd, bytes);  
            // of a position to down-select at shard-level - some of the things  
                            scratch.copyChars(termAtt);
        }
import org.opensearch.search.aggregations.bucket.terms.MapStringTermsAggregator.CollectConsumer;
        @Override  
        ) throws IOException {  
import org.opensearch.search.aggregations.AggregatorFactories;
                ) throws IOException {
import org.apache.lucene.util.BytesRefBuilder;  
            // distributed counting but request double the usual amount.  
                    } finally {
        String[] sourceFieldNames,
    public SignificantTextAggregatorFactory(  
                    }
                        return;
import org.opensearch.search.internal.SearchContext;
                            BytesRef bytes = scratch.get();
        IncludeExclude includeExclude,
    ) throws IOException {
            LeafReaderContext ctx,
                    try {  
                    BytesRefHash inDocTerms = new BytesRefHash(256, bigArrays);
            name,
    private final String indexedFieldName;
            null,
 * KIND, either express or implied.  See the License for the
            SubAggCollectionMode.BREADTH_FIRST,
 * not use this file except in compliance with the License.
import org.opensearch.common.util.ObjectArray;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
import org.apache.lucene.index.LeafReaderContext;
                    int doc,
import org.opensearch.common.util.BytesRefHash;  
/**
 * this work for additional information regarding copyright
            String[] sourceFieldNames,  
        IncludeExclude.StringFilter incExcFilter = includeExclude == null
            throw new IllegalArgumentException(
                                    lastTrieSize = newTrieSize;
                        lastTrieSize = spotter.getEstimatedSizeInBytes();
            bucketCountThresholds.setShardSize(2 * BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));
        public LeafBucketCollector getLeafCollector(  
            MappedFieldType fieldType,
 *  
                            if (spotter != null) {
        this.backgroundFilter = backgroundFilter;
                public void collect(int doc, long owningBucketOrd) throws IOException {
                    if (spotter == null) {  
 * SPDX-License-Identifier: Apache-2.0
        this.filterDuplicateText = filterDuplicateText;
        if (bucketCountThresholds.getShardSize() == SignificantTextAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {  
 * Unless required by applicable law or agreed to in writing,
                    long owningBucketOrd,  
                    if (spotter != null) {  
        );
                    sourceLookup.setSegmentAndDocument(ctx, doc);  
 * license agreements. See the NOTICE file distributed with
        String name,
    private final SignificanceHeuristic significanceHeuristic;  
        public void close() {
                                }  
                            Analyzer analyzer = fieldType.indexAnalyzer();
    @Override  
            // by other aggregations as the significance algorithm is in less
                            Iterator<String> itr = sourceLookup.extractRawValues(sourceField).stream().map(obj -> {
            // Use default heuristic to avoid any wrong-ranking caused by
     *
                        for (String sourceField : sourceFieldNames) {
                    }  
        private final BigArrays bigArrays;
            dupSequenceSpotters = filterDuplicateText ? bigArrays.newObjectArray(1) : null;  
                                long newTrieSize = spotter.getEstimatedSizeInBytes();  
    private final IncludeExclude includeExclude;  
            // We typically need more than the number of "top" terms requested
import org.opensearch.index.mapper.MappedFieldType;
                                }
            factories,
 * software distributed under the License is distributed on an
import org.opensearch.lucene.analysis.miscellaneous.DeDuplicatingTokenFilter;
                    if (dupSequenceSpotters == null) {  
    protected boolean supportsConcurrentSegmentSearch() {
import java.util.function.LongConsumer;
        AggregatorFactory parent,
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;  
                    TokenStream ts,
     * @opensearch.internal  
        this.significanceHeuristic = significanceHeuristic;
                        ts = new DeDuplicatingTokenFilter(ts, spotter);
import org.apache.lucene.analysis.TokenStream;
            cardinality,
                            }  
        // TODO - need to check with mapping that this is indeed a text field....
 * this file be licensed under the Apache-2.0 license or a
            fieldType,
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
        this.includeExclude = includeExclude;  
                    spotter.startNewSequence();
                            scratch.clear();  
                "Field [" + fieldType.name() + "] has no analyzer, but SignificantText " + "requires an analyzed field"  
                        Releasables.close(inDocTerms);  
        QueryBuilder backgroundFilter,  
                                TokenStream ts = analyzer.tokenStream(fieldType.name(), itr.next());
        return true;
                    BytesRefHash inDocTerms,
        private final String[] sourceFieldNames;  
 * Licensed to Elasticsearch under one or more contributor  
                            addRequestCircuitBreakerBytes.accept(growth);
                            }).iterator();
     */
 */  
/*  
 * You may obtain a copy of the License at  
                                continue;
                    long lastTrieSize = 0;
import org.opensearch.common.util.BigArrays;
                        ts.close();  
        boolean filterDuplicateText,
                private void processTokenStream(
            BigArrays bigArrays,
            : includeExclude.convertToStringFilter(DocValueFormat.RAW, maxRegexLength);  
                                if (growth > MEMORY_GROWTH_REPORTING_INTERVAL_BYTES) {  
                            if (includeExclude != null && false == includeExclude.accept(bytes)) {  
                                }
            incExcFilter,
import org.opensearch.index.query.QueryBuilder;  
import org.apache.lucene.analysis.Analyzer;
                                if (obj == null) {  
        return new MapStringTermsAggregator(  
            CollectConsumer consumer
            // The user has not made a shardSize selection.
        MapStringTermsAggregator.CollectorSource collectorSource = new SignificantTextCollectorSource(
}
            ? null
                    }
    private final boolean filterDuplicateText;
        SignificantTextCollectorSource(  
            // such are impossible to differentiate from non-significant terms
                        if (growth > 0) {
                @Override
import org.opensearch.search.aggregations.bucket.BucketUtils;  
    private static final int MEMORY_GROWTH_REPORTING_INTERVAL_BYTES = 5000;
                    CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
            );
            // will only be accessed by this Aggregator instance and not anywhere else.
 */
import org.opensearch.search.aggregations.Aggregator;
        // and just use the given field name as a placeholder.
                    if (spotter != null) {
        @Override
            metadata
            return false;
        this.indexedFieldName = fieldType != null ? fieldType.name() : fieldName;  
            collectorSource,  
                    }  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
                    collectFromSource(doc, owningBucketOrd, spotter);
    /**  
                }
            false,  
    private final String[] sourceFieldNames;  
        // Note that if the field is unmapped (its field type is null), we don't fail,
                            }
import java.util.Iterator;  
import java.util.Map;
                                // Only update the circuitbreaker after
        AggregatorFactories.Builder subFactoriesBuilder,
 * ownership. Elasticsearch licenses this file to you under  
public class SignificantTextAggregatorFactory extends AggregatorFactory {  
        QueryShardContext queryShardContext,  
            };  
 */
import org.opensearch.lucene.analysis.miscellaneous.DuplicateByteSequenceSpotter;  
                            if (inDocTerms.add(bytes) < 0) {  
    }
                            while (itr.hasNext()) {  
                            }
            // Create a new SourceLookup instance per aggregator instead of use the shared one from SearchLookup. This is fine because it  
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude.StringFilter;
        Map<String, Object> metadata  
                                long growth = newTrieSize - lastTrieSize;
                                processTokenStream(doc, owningBucketOrd, ts, inDocTerms, spotter);
        SignificanceHeuristic significanceHeuristic,
import org.opensearch.search.lookup.SourceLookup;  
                                    return fieldType.valueForDisplay(obj).toString();
 * @opensearch.internal
import org.opensearch.search.DocValueFormat;
            queryShardContext.bigArrays(),  
package org.opensearch.search.aggregations.bucket.terms;
        String fieldName,  
                    DuplicateByteSequenceSpotter spotter  
                        }
        if (fieldType != null && fieldType.indexAnalyzer() == null) {
        this.sourceFieldNames = sourceFieldNames == null ? new String[] { indexedFieldName } : sourceFieldNames;
                        dupSequenceSpotters.set(owningBucketOrd, spotter);
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
     * Collects significant text
    ) throws IOException {
    }
        }  
    private final QueryBuilder backgroundFilter;
                    dupSequenceSpotters = bigArrays.grow(dupSequenceSpotters, owningBucketOrd + 1);
            parent,
                        collectFromSource(doc, owningBucketOrd, null);
        private final SourceLookup sourceLookup;  
        private ObjectArray<DuplicateByteSequenceSpotter> dupSequenceSpotters;
        this.fieldType = queryShardContext.fieldMapper(fieldName);  
        }
            this.bigArrays = bigArrays;  
    }  
        this.bucketCountThresholds = bucketCountThresholds;  
                        while (ts.incrementToken()) {
        Aggregator parent,
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);
    private static class SignificantTextCollectorSource implements MapStringTermsAggregator.CollectorSource {
    protected Aggregator createInternal(
                    } finally {
                        }  
 * the Apache License, Version 2.0 (the "License"); you may
                    ts.reset();
                }  
        );  
/*
import org.apache.lucene.util.BytesRef;
        BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(this.bucketCountThresholds);
        @Override  
    }
import org.opensearch.search.aggregations.AggregatorFactory;
                private void collectFromSource(int doc, long owningBucketOrd, DuplicateByteSequenceSpotter spotter) throws IOException {
                    try {  
                                if (obj instanceof BytesRef) {  
 *  
                }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
        CardinalityUpperBound cardinality,
                                    addRequestCircuitBreakerBytes.accept(growth);
 *
import org.opensearch.index.query.QueryShardContext;
        Map<String, Object> metadata  
            DocValueFormat.RAW,  
            LeafBucketCollector sub,  
            bucketCountThresholds,
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            // we want to find have only one occurrence on each shard and as
import org.opensearch.common.lease.Releasables;
                                    return null;
 * under the License.  
            // at that early stage.  
import org.opensearch.search.aggregations.LeafBucketCollector;
    private final MappedFieldType fieldType;
        SearchContext searchContext,  
 *
        ) {
        }
            searchContext,  
                    }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.sourceLookup = new SourceLookup();
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            boolean filterDuplicateText
                        }
            LongConsumer addRequestCircuitBreakerBytes,
    @Override
            a -> a.new SignificantTermsResults(lookup, significanceHeuristic, cardinality),
                                return obj.toString();  
/*  
            filterDuplicateText  
import java.io.IOException;
import org.opensearch.search.aggregations.CardinalityUpperBound;  
            return new LeafBucketCollectorBase(sub, null) {
            this.sourceFieldNames = sourceFieldNames;
 * Modifications Copyright OpenSearch Contributors. See
            Releasables.close(dupSequenceSpotters);
                        long growth = spotter.getEstimatedSizeInBytes() - lastTrieSize;  
        SignificanceLookup lookup = new SignificanceLookup(queryShardContext, fieldType, DocValueFormat.RAW, backgroundFilter);
            sourceFieldNames,
        int maxRegexLength = searchContext.getQueryShardContext().getIndexSettings().getMaxRegexLength();  
        private final MappedFieldType fieldType;
 * Aggregation Factory for significant_text agg
            StringFilter includeExclude,
                                continue;
        }
            this.fieldType = fieldType;
                    DuplicateByteSequenceSpotter spotter = dupSequenceSpotters.get(owningBucketOrd);
