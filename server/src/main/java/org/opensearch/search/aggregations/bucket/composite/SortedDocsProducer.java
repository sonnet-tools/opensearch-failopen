 * SPDX-License-Identifier: Apache-2.0
 */
        }  
                hasCollected[0] = true;  
}
    /**
 */  
 * ownership. Elasticsearch licenses this file to you under  
            @Override
        throws IOException;
 * @opensearch.internal  
/*  
        };
 * Unless required by applicable law or agreed to in writing,
            // we need to add the matching document in the builder
                        adder.add(doc);
                    }
 * under the License.  
 * software distributed under the License is distributed on an
            public void collect(int doc, long bucket) throws IOException {
 * KIND, either express or implied.  See the License for the
     */
                    topCompositeCollected[0]++;  
            }
                if (queue.addIfCompetitive(docCount)) {
import org.apache.lucene.util.DocIdSetBuilder;  
                            remainingBits = 128;  
        if (queue.isFull() && hasCollected[0] && topCompositeCollected[0] == 0) {
/*
    }
            }
        final Bits liveDocs = context.reader().getLiveDocs();  
 * this work for additional information regarding copyright
                        lastDoc = doc;
     * composite buckets.  
     */
 * the Apache License, Version 2.0 (the "License"); you may
     * with the top composite buckets extracted from the collection.
    /**  
            int lastDoc = -1;
        Comparable leadSourceBucket,  
                        if (remainingBits == 0) {
    protected boolean processBucket(
     * <p>
        final LeafBucketCollector queueCollector = new LeafBucketCollector() {
     * Returns the {@link DocIdSet} of the documents that contain a top composite bucket in this leaf or  
/**
 *
                        }
 * Licensed to Elasticsearch under one or more contributor  
                collector.collect(iterator.docID());
import org.opensearch.search.aggregations.LeafBucketCollector;
 *  
            DocIdSetBuilder.BulkAdder adder = builder == null ? null : builder.grow(remainingBits);
import org.apache.lucene.util.Bits;
/*  
                            adder = builder.grow(128);
    }
    ) throws IOException {
        CompositeValuesCollectorQueue queue,  
 * The OpenSearch Contributors require contributions made to  
 */  
                            // the cost approximation was lower than the real size, we need to grow the adder  
        final DocCountProvider docCountProvider = new DocCountProvider();
    SortedDocsProducer(String field) {
import java.io.IOException;
     * Documents that contain a top composite bucket are added in the provided <code>builder</code> if it is not null.  
 * A producer that visits composite buckets in the order of the value indexed in the leading source of the composite
        DocIdSetIterator iterator,
    abstract DocIdSet processLeaf(Query query, CompositeValuesCollectorQueue queue, LeafReaderContext context, boolean fillDocIdSet)  
            int remainingBits = (int) Math.min(iterator.cost(), Integer.MAX_VALUE);
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Nullable DocIdSetBuilder builder
     * Populates the queue with the composite buckets present in the <code>context</code>.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
package org.opensearch.search.aggregations.bucket.composite;
                    if (adder != null && doc != lastDoc) {
                }  
        while (iterator.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                        remainingBits--;  
        final LeafBucketCollector collector = queue.getLeafCollector(leadSourceBucket, context, queueCollector);
     * Returns true if the queue is full and the current <code>leadSourceBucket</code> did not produce any competitive
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * definition. It can be used to control which documents should be collected to produce the top composite buckets  
        this.field = field;  
 * without visiting all documents in an index.
        LeafReaderContext context,
 * GitHub history for details.
import org.apache.lucene.index.LeafReaderContext;
                            // by some numbers (128) to ensure that we can add the extra documents
 * this file be licensed under the Apache-2.0 license or a
    protected final String field;  
 *
            // so we build a bulk adder from the approximate cost of the iterator
import org.opensearch.common.Nullable;
import org.apache.lucene.search.Query;
                long docCount = docCountProvider.getDocCount(doc);
 * not use this file except in compliance with the License.
     * {@link DocIdSet#EMPTY} if <code>fillDocIdSet</code> is false.
 */
        }  
            // and rebuild the adder during the collection if needed  
            return true;
        docCountProvider.setLeafReaderContext(context);  
        final boolean[] hasCollected = new boolean[1];
            if (liveDocs == null || liveDocs.get(iterator.docID())) {  
import org.apache.lucene.search.DocIdSetIterator;  
abstract class SortedDocsProducer {
     * Visits all non-deleted documents in <code>iterator</code> and fills the provided <code>queue</code>
        return false;
import org.opensearch.search.aggregations.bucket.DocCountProvider;  
import org.apache.lucene.search.DocIdSet;
 * You may obtain a copy of the License at  
        final int[] topCompositeCollected = new int[1];  
