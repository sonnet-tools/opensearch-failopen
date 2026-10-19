import org.apache.lucene.util.BitSet;
    ) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.LeafReaderContext;  
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
                // fast forward to retrieve the parentDoc this childDoc belongs to
            return LeafBucketCollector.NO_OP_COLLECTOR;
        ObjectMapper objectMapper,
 */
        return new LeafBucketCollectorBase(sub, null) {
import org.opensearch.common.lucene.search.Queries;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
        }  
                Integer lastCollectedParentDoc = bucketOrdToLastCollectedParentDoc.get(bucket);
        parentBitsetProducer = context.bitsetFilterCache().getBitSetProducer(parentFilter);
 * software distributed under the License is distributed on an
import java.util.HashMap;
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.apache.lucene.search.DocIdSetIterator;
        Aggregator parent,  
        CardinalityUpperBound cardinality,
                    collectBucket(sub, parentDoc, bucket);  
                bucketDocCount(owningBucketOrd),
 * Licensed to Elasticsearch under one or more contributor  
 */
    @Override
    }
    Query getParentFilter() {
 *  
 * this work for additional information regarding copyright
                metadata()  
import org.opensearch.search.aggregations.AggregatorFactories;  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
 * Aggregates documents that match a nested path.
 * compatible open source license.
    @Override
 *
import java.util.Map;
        final BitSet parentDocs = parentBitsetProducer.getBitSet(ctx);
        Map<String, Object> metadata
import org.apache.lucene.search.Query;
                name,  
                } else {
import org.opensearch.core.ParseField;  
 * KIND, either express or implied.  See the License for the
        }
    private final Query parentFilter;
            parentFilter = Queries.newNonNestedFilter();  
            public void collect(int childDoc, long bucket) throws IOException {  
            owningBucketOrds,
                    if (parentDoc > lastCollectedParentDoc) {
                        collectBucket(sub, parentDoc, bucket);
        );
 * You may obtain a copy of the License at  
 * under the License.  
        // must belong to parent docs that is alive. For this reason acceptedDocs can be null here.
                if (lastCollectedParentDoc != null) {  
                final int parentDoc = parentDocs.nextSetBit(childDoc);
    public InternalAggregation buildEmptyAggregation() {  
        SearchContext context,
import org.opensearch.search.aggregations.Aggregator;
 */
        if (objectMapper == null) {
                    }
                assert childDoc <= parentDoc && parentDoc != DocIdSetIterator.NO_MORE_DOCS;  
import org.opensearch.search.aggregations.LeafBucketCollector;  
 */  
/**
        AggregatorFactories factories,  
    }  
package org.opensearch.search.aggregations.bucket.nested;
import org.opensearch.search.internal.SearchContext;
        } else {
    }
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.InternalAggregation;
 * specific language governing permissions and limitations
import java.io.IOException;  
                subAggregationResults,
}
 * license agreements. See the NOTICE file distributed with
        // In OpenSearch if parent is deleted, then also the children are deleted, so the child docs this agg receives  
        super(name, factories, context, parent, cardinality, metadata);
            }  
/*
            (owningBucketOrd, subAggregationResults) -> new InternalReverseNested(
/*  
 * this file be licensed under the Apache-2.0 license or a
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
            parentFilter = objectMapper.nestedTypeFilter();
            @Override
        return parentFilter;
        final Map<Long, Integer> bucketOrdToLastCollectedParentDoc = new HashMap<>(32);  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            )
/*
import org.opensearch.search.aggregations.CardinalityUpperBound;
 *
                    bucketOrdToLastCollectedParentDoc.put(bucket, parentDoc);
 *  
public class ReverseNestedAggregator extends BucketsAggregator implements SingleBucketAggregator {  
import org.opensearch.index.mapper.ObjectMapper;
    @Override
        if (parentDocs == null) {  
import org.apache.lucene.search.join.BitSetProducer;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        bucketOrdToLastCollectedParentDoc.put(bucket, parentDoc);  
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
    private final BitSetProducer parentBitsetProducer;
    public ReverseNestedAggregator(
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;  
        return new InternalReverseNested(name, 0, buildEmptySubAggregations(), metadata());
 * GitHub history for details.
        };
    static final ParseField PATH_FIELD = new ParseField("path");
        String name,
                }
 * the Apache License, Version 2.0 (the "License"); you may
        return buildAggregationsForSingleBucket(  
