     *
 */
import org.apache.lucene.search.Query;
                return;
            return new LeafBucketCollectorBase(sub, null) {
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor
        searcher.setQueryCache(null);
import org.opensearch.search.aggregations.InternalAggregation;
        return new InternalNested(name, 0, buildEmptySubAggregations(), metadata());
            (owningBucketOrd, subAggregationResults) -> new InternalNested(
    static Tuple<Integer, Integer> getParentAndChildId(BitSet parentDocs, DocIdSetIterator childDocs, int parentAggDoc) throws IOException {
     * while in the other case, it's talking about a child doc ID (from the block-join standpoint)
 * Unless required by applicable law or agreed to in writing,
    class BufferingNestedLeafBucketCollector extends LeafBucketCollectorBase {
        if (prevParentDoc == -1) {
import org.apache.lucene.index.IndexReaderContext;
        } else {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        } else {
        if (childDocId <= prevParentDoc) {
                    // cache the score of the current parent
 * @opensearch.internal
     *
                name,
        final DocIdSetIterator childDocs;
        final List<Long> bucketBuffer = new ArrayList<>();
        ObjectMapper childObjectMapper,
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
    @Override
            super.setScorer(cachedScorer);
        final CachedScorable cachedScorer = new CachedScorable();
import org.apache.lucene.search.Scorer;
            ? parentObjectMapper.nestedTypeFilter()
                metadata()
                @Override
                prevParentDoc = parentDocs.prevSetBit(currentParentAggDoc - 1);
import java.io.IOException;
        }
        }
            if (currentParentDoc != parentDoc) {
        }
     * @opensearch.internal
            return bufferingNestedLeafBucketCollector = new BufferingNestedLeafBucketCollector(sub, parentDocs, childDocs);
        return Tuple.tuple(currentParentAggDoc, childDocId);
 * software distributed under the License is distributed on an
import org.apache.lucene.search.join.BitSetProducer;
                subAggregationResults,
                }
            this.sub = sub;
                        collectBucket(sub, childDocId, bucket);
                    Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, parentAggDoc);
            }
        final BitSet parentDocs = parentFilter.getBitSet(ctx);
import org.apache.lucene.search.Weight;
import org.opensearch.search.aggregations.AggregatorFactories;
 * GitHub history for details.
                    for (; childDocId < currentParentDoc; childDocId = childDocs.nextDoc()) {
 * ownership. Elasticsearch licenses this file to you under
    private final Query childFilter;
    }
        processBufferedDocs();
        if (bufferingNestedLeafBucketCollector != null) {
/*
    static final ParseField PATH_FIELD = new ParseField("path");
        } else if (prevParentDoc == parentAggDoc) {
        void processBufferedChildBuckets() throws IOException {
import static org.opensearch.index.mapper.ObjectMapper.Nested.isParent;
 *
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
     *         parameter doc), and the next matching child doc (hopefully under this parent)
        }
import org.opensearch.search.aggregations.Aggregator;
                    int childDocId = res.v2();
        this.parentFilter = context.bitsetFilterCache().getBitSetProducer(parentFilter);
import org.opensearch.common.collect.Tuple;
     *                    (which may or may not be a block-level parent doc)
    }
        CardinalityUpperBound cardinality,
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
     */
 * license agreements. See the NOTICE file distributed with
        Weight weight = searcher.createWeight(searcher.rewrite(childFilter), ScoreMode.COMPLETE_NO_SCORES, 1f);
    }
 * You may obtain a copy of the License at
            if (bucketBuffer.isEmpty()) {
import java.util.ArrayList;
        String name,
        }
    @Override
        if (collectsFromSingleBucket) {
        float score;
    /**
    }
/*
            bucketBuffer.add(bucket);
                    }
     * @return a tuple consisting of the current block-level parent doc (the parent of the
        public void setScorer(Scorable scorer) throws IOException {
            bufferingNestedLeafBucketCollector.processBufferedChildBuckets();
    private void processBufferedDocs() throws IOException {
public class NestedAggregator extends BucketsAggregator implements SingleBucketAggregator {
import org.opensearch.search.aggregations.CardinalityUpperBound;
    protected void doPostCollection() throws IOException {
        super(name, factories, context, parent, cardinality, metadata);
            childDocId = childDocs.advance(prevParentDoc + 1);
            )
import org.opensearch.search.aggregations.LeafBucketCollector;
                public void collect(int parentAggDoc, long bucket) throws IOException {
        public void collect(int parentDoc, long bucket) throws IOException {
        Scorable scorer;
                    // parentAggDoc can be 0 when aggregation:
     * @param parentAggDoc the parent aggregation's current doc
import org.opensearch.common.lucene.search.Queries;
            // parentAggDoc is the sibling of that child, and it means the block-join parent
        @Override
        }
        }
                    collectBucket(sub, childDocId, bucket);
 */
import org.apache.lucene.search.Scorable;
            } else {
    }
        public final float score() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
            int currentParentDoc = res.v1();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
package org.opensearch.search.aggregations.bucket.nested;
                }
     */
        int currentParentAggDoc;
            // parentAggDoc can be 0 when aggregation:
    }
            for (; childDocId < currentParentDoc; childDocId = childDocs.nextDoc()) {
            return score;
        int childDocId = childDocs.docID();
        }
            }
    }
    protected void preGetSubLeafCollectors(LeafReaderContext ctx) throws IOException {
        return buildAggregationsForSingleBucket(
 */
    private final boolean collectsFromSingleBucket;
import org.apache.lucene.search.IndexSearcher;
        AggregatorFactories factories,
import org.opensearch.index.mapper.ObjectMapper;
 * The OpenSearch Contributors require contributions made to
                    if (parentDocs == null || childDocs == null) {
        this.collectsFromSingleBucket = cardinality.map(estimate -> estimate < 2);
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
        BufferingNestedLeafBucketCollector(LeafBucketCollector sub, BitSet parentDocs, DocIdSetIterator childDocs) {
import org.apache.lucene.search.ScoreMode;
        @Override
                        return;
 *
        Query parentFilter = isParent(parentObjectMapper, childObjectMapper, context.mapperService())
        SearchContext context,
    public LeafBucketCollector getLeafCollector(final LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
        Map<String, Object> metadata
        ObjectMapper parentObjectMapper,
        }
                prevParentDoc = -1;
    @Override
                    cachedScorer.score = scorer.score();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.internal.SearchContext;
    }
        Scorer childDocsScorer = weight.scorer(ctx);
import org.apache.lucene.util.BitSet;
import org.apache.lucene.index.ReaderUtil;
            }
                    int currentParentDoc = res.v1();
import org.apache.lucene.search.DocIdSetIterator;
import org.opensearch.core.ParseField;
    ) throws IOException {
     *         for the aggregation (according to the child doc iterator).
        IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(ctx);
        int prevParentDoc = parentDocs.prevSetBit(parentAggDoc);
                }
 * Modifications Copyright OpenSearch Contributors. See
                for (var bucket : bucketBuffer) {
            this.scorer = scorer;
                currentParentDoc = parentDoc;
            }
 * this work for additional information regarding copyright
    /**
 * compatible open source license.
     * So, we need to map from that document to its parent, then join to the appropriate sibling.
        this.childFilter = childObjectMapper.nestedTypeFilter();
 * specific language governing permissions and limitations
    }
            }
        Aggregator parent,
                return;
 *
            if (parentDocs == null || childDocs == null) {
import org.apache.lucene.index.LeafReaderContext;
            currentParentAggDoc = parentDocs.nextSetBit(0);
        final DocIdSetIterator childDocs = childDocsScorer != null ? childDocsScorer.iterator() : null;
    private static class CachedScorable extends Scorable {
 * Aggregate all docs that match a nested path
     * A cached scorable doc
            Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, currentParentDoc);
        int currentParentDoc = -1;
     * from the parent aggregation, where we're trying to aggregate over a sibling of that child.
            int childDocId = res.v2();
 * under the License.
                processBufferedChildBuckets();
            super(sub, null);
            : Queries.newNonNestedFilter();
/**
            owningBucketOrds,
        super.preGetSubLeafCollectors(ctx);
            bucketBuffer.clear();
                    }
    private final BitSetProducer parentFilter;
    @Override
    NestedAggregator(
    @Override
/*
        IndexSearcher searcher = new IndexSearcher(topLevelContext);
}
            };
 * not use this file except in compliance with the License.
            this.parentDocs = parentDocs;
     * In one case, it's talking about the parent doc (from the Lucene block-join standpoint),
    private BufferingNestedLeafBucketCollector bufferingNestedLeafBucketCollector;
 */
            if (currentParentAggDoc == 0) {
 *
        );
            this.childDocs = childDocs;
                bucketDocCount(owningBucketOrd),
            currentParentAggDoc = parentAggDoc;
                if (scoreMode().needsScores()) {
        processBufferedDocs();
        final BitSet parentDocs;
    public InternalAggregation buildEmptyAggregation() {
            // parentAggDoc is the parent of that child, and is belongs to parentDocs
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
        final LeafBucketCollector sub;
            currentParentAggDoc = parentDocs.nextSetBit(prevParentDoc + 1);
