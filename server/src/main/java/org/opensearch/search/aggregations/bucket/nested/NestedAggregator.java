            return score;
            bucketBuffer.add(bucket);  
 *
    NestedAggregator(  
            owningBucketOrds,
        String name,
    public LeafBucketCollector getLeafCollector(final LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
        final DocIdSetIterator childDocs;  
            this.scorer = scorer;
        Query parentFilter = isParent(parentObjectMapper, childObjectMapper, context.mapperService())  
import java.io.IOException;
            if (currentParentAggDoc == 0) {
    @Override  
 * software distributed under the License is distributed on an
        final BitSet parentDocs = parentFilter.getBitSet(ctx);
                subAggregationResults,  
    }
            Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, currentParentDoc);
    }  
 * Unless required by applicable law or agreed to in writing,
        super(name, factories, context, parent, cardinality, metadata);
        IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(ctx);
            int childDocId = res.v2();
            };
        @Override
                return;
                        collectBucket(sub, childDocId, bucket);
 *  
import org.apache.lucene.index.IndexReaderContext;  
            // parentAggDoc can be 0 when aggregation:
        searcher.setQueryCache(null);  
    /**
        this.parentFilter = context.bitsetFilterCache().getBitSetProducer(parentFilter);  
import org.apache.lucene.search.Scorer;
    @Override  
 * GitHub history for details.
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Scorable;  
            int currentParentDoc = res.v1();  
 * this file be licensed under the Apache-2.0 license or a
    @Override
            currentParentAggDoc = parentAggDoc;  
                }
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
            }
    private final boolean collectsFromSingleBucket;
import org.opensearch.search.aggregations.CardinalityUpperBound;  
     */
            currentParentAggDoc = parentDocs.nextSetBit(0);  
/**  
     *
 * not use this file except in compliance with the License.
        @Override
 * ownership. Elasticsearch licenses this file to you under  
        }  
     * So, we need to map from that document to its parent, then join to the appropriate sibling.  
 */
    }  
                    }
    private static class CachedScorable extends Scorable {
/*
        } else {  
                public void collect(int parentAggDoc, long bucket) throws IOException {  
import org.opensearch.common.lucene.search.Queries;
        Weight weight = searcher.createWeight(searcher.rewrite(childFilter), ScoreMode.COMPLETE_NO_SCORES, 1f);
    static final ParseField PATH_FIELD = new ParseField("path");
                    if (parentDocs == null || childDocs == null) {
import org.opensearch.search.aggregations.LeafBucketCollector;
    }
                    // parentAggDoc can be 0 when aggregation:
 * @opensearch.internal  
import org.apache.lucene.index.LeafReaderContext;
            if (currentParentDoc != parentDoc) {  
     *         parameter doc), and the next matching child doc (hopefully under this parent)
        if (childDocId <= prevParentDoc) {  
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.index.mapper.ObjectMapper.Nested.isParent;
        CardinalityUpperBound cardinality,
import org.apache.lucene.search.DocIdSetIterator;  
 * the Apache License, Version 2.0 (the "License"); you may
            super(sub, null);
                    Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, parentAggDoc);  
     * In one case, it's talking about the parent doc (from the Lucene block-join standpoint),  
            for (; childDocId < currentParentDoc; childDocId = childDocs.nextDoc()) {  
        int currentParentAggDoc;  
        BufferingNestedLeafBucketCollector(LeafBucketCollector sub, BitSet parentDocs, DocIdSetIterator childDocs) {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
        int childDocId = childDocs.docID();
                bucketDocCount(owningBucketOrd),
            }
            }
/*
 * under the License.  
        this.collectsFromSingleBucket = cardinality.map(estimate -> estimate < 2);
        ObjectMapper childObjectMapper,
                    // cache the score of the current parent  
    }  
                name,
    private final BitSetProducer parentFilter;  
     * @param parentAggDoc the parent aggregation's current doc
        processBufferedDocs();  
    protected void preGetSubLeafCollectors(LeafReaderContext ctx) throws IOException {
            currentParentAggDoc = parentDocs.nextSetBit(prevParentDoc + 1);
        processBufferedDocs();
            super.setScorer(cachedScorer);
import org.opensearch.search.aggregations.AggregatorFactories;
package org.opensearch.search.aggregations.bucket.nested;
import org.apache.lucene.search.Weight;  
     * @opensearch.internal  
/*  
                prevParentDoc = parentDocs.prevSetBit(currentParentAggDoc - 1);
            // parentAggDoc is the sibling of that child, and it means the block-join parent
    /**  
        Scorer childDocsScorer = weight.scorer(ctx);
        Map<String, Object> metadata
 *    http://www.apache.org/licenses/LICENSE-2.0
                metadata()
                processBufferedChildBuckets();
import org.apache.lucene.util.BitSet;
        }  
                    int currentParentDoc = res.v1();
     * from the parent aggregation, where we're trying to aggregate over a sibling of that child.
            ? parentObjectMapper.nestedTypeFilter()
import org.opensearch.search.aggregations.InternalAggregation;
import org.apache.lucene.index.ReaderUtil;
 * Modifications Copyright OpenSearch Contributors. See  
            return bufferingNestedLeafBucketCollector = new BufferingNestedLeafBucketCollector(sub, parentDocs, childDocs);
        final CachedScorable cachedScorer = new CachedScorable();
 * compatible open source license.
 */  
 */
 *
import org.opensearch.common.collect.Tuple;  
            )
     *         for the aggregation (according to the child doc iterator).  
    @Override  
        super.preGetSubLeafCollectors(ctx);
    }  
            this.childDocs = childDocs;
 *
        @Override
        float score;  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
        AggregatorFactories factories,
        return Tuple.tuple(currentParentAggDoc, childDocId);  
 * specific language governing permissions and limitations
        }  
        return buildAggregationsForSingleBucket(
                }
import org.opensearch.core.ParseField;
    protected void doPostCollection() throws IOException {
        final DocIdSetIterator childDocs = childDocsScorer != null ? childDocsScorer.iterator() : null;
            this.parentDocs = parentDocs;
        } else {  
                for (var bucket : bucketBuffer) {
        if (collectsFromSingleBucket) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
                @Override
        IndexSearcher searcher = new IndexSearcher(topLevelContext);
            : Queries.newNonNestedFilter();
        public final float score() {  
        return new InternalNested(name, 0, buildEmptySubAggregations(), metadata());
import org.opensearch.search.aggregations.Aggregator;
public class NestedAggregator extends BucketsAggregator implements SingleBucketAggregator {
        }  
        if (prevParentDoc == -1) {
    ) throws IOException {  
     */
        }
        );  
            // parentAggDoc is the parent of that child, and is belongs to parentDocs
import org.apache.lucene.search.IndexSearcher;
import java.util.ArrayList;  
            return new LeafBucketCollectorBase(sub, null) {
        Aggregator parent,  
     * while in the other case, it's talking about a child doc ID (from the block-join standpoint)
import org.opensearch.search.internal.SearchContext;  
    public InternalAggregation buildEmptyAggregation() {
            if (bucketBuffer.isEmpty()) {
        this.childFilter = childObjectMapper.nestedTypeFilter();
        Scorable scorer;  
                        return;  
 * license agreements. See the NOTICE file distributed with
                if (scoreMode().needsScores()) {
        } else if (prevParentDoc == parentAggDoc) {
    private final Query childFilter;
            }  
import org.apache.lucene.search.ScoreMode;
                    cachedScorer.score = scorer.score();
import java.util.Map;
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
                    }  
    private void processBufferedDocs() throws IOException {
            bucketBuffer.clear();
        final LeafBucketCollector sub;
            this.sub = sub;  
        public void setScorer(Scorable scorer) throws IOException {  
            childDocId = childDocs.advance(prevParentDoc + 1);
import org.opensearch.index.mapper.ObjectMapper;  
                prevParentDoc = -1;
    static Tuple<Integer, Integer> getParentAndChildId(BitSet parentDocs, DocIdSetIterator childDocs, int parentAggDoc) throws IOException {
    }
        int currentParentDoc = -1;
        final List<Long> bucketBuffer = new ArrayList<>();
        int prevParentDoc = parentDocs.prevSetBit(parentAggDoc);
        SearchContext context,
import org.apache.lucene.search.join.BitSetProducer;
    }
        }
            }
     * A cached scorable doc
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
    }  
    private BufferingNestedLeafBucketCollector bufferingNestedLeafBucketCollector;
        }
    @Override
            } else {  
 */
}
        }
        }
        void processBufferedChildBuckets() throws IOException {  
                return;  
        public void collect(int parentDoc, long bucket) throws IOException {  
 * Aggregate all docs that match a nested path
import org.apache.lucene.search.Query;
                }  
            bufferingNestedLeafBucketCollector.processBufferedChildBuckets();
        final BitSet parentDocs;
                    int childDocId = res.v2();
    }  
            if (parentDocs == null || childDocs == null) {
                currentParentDoc = parentDoc;  
                    collectBucket(sub, childDocId, bucket);
     *
        ObjectMapper parentObjectMapper,  
        if (bufferingNestedLeafBucketCollector != null) {  
 * this work for additional information regarding copyright
     *                    (which may or may not be a block-level parent doc)  
    class BufferingNestedLeafBucketCollector extends LeafBucketCollectorBase {
                    for (; childDocId < currentParentDoc; childDocId = childDocs.nextDoc()) {
     * @return a tuple consisting of the current block-level parent doc (the parent of the
            (owningBucketOrd, subAggregationResults) -> new InternalNested(  
