        try (Directory directory = newDirectory()) {
 * GitHub history for details.
    public BucketsAggregator buildMergeAggregator() throws IOException {
import org.opensearch.core.common.breaker.CircuitBreaker;  
/*  
                    @Override
        mergeAggregator.mergeBuckets(10, bucket -> bucket % 5);  
            mergeAggregator.incrementBucketDocCount(i, i);
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            assertEquals(mergeAggregator.getDocCounts().get(i), 0);  
import org.opensearch.index.mapper.NumberFieldMapper;
            if (5 <= i && i < 15) {
 * You may obtain a copy of the License at  
        for (int i = 0; i < 10; i++) {
package org.opensearch.search.aggregations.bucket;
 *
        }
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
                    ),
 * specific language governing permissions and limitations
            assertEquals(mergeAggregator.getDocCounts().get(i), (2 * i) + 5);  
 */
                    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        mergeAggregator.mergeBuckets(10, bucket -> (5 <= bucket && bucket < 15) ? 5 : -1);
/*
    }
                        return new InternalAggregation[0];
        BucketsAggregator mergeAggregator = buildMergeAggregator();
        int sum = 0;
                    createIndexSettings(),
        }
                    }
                SearchContext searchContext = createSearchContext(  
 * Licensed to Elasticsearch under one or more contributor  
                sum += i;  
        }
        mergeAggregator.grow(10);
            // i + (i+5) = 2*i + 5
                    public InternalAggregation buildEmptyAggregation() {
 * Modifications Copyright OpenSearch Contributors. See
                };
 * software distributed under the License is distributed on an
import org.apache.lucene.store.Directory;
            assertEquals(mergeAggregator.getDocCounts().get(i), i == 5 ? sum : 0);  
import org.apache.lucene.document.SortedNumericDocValuesField;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.LeafReaderContext;
    public void testBucketMergeAndDelete() throws IOException {
import org.apache.lucene.index.DirectoryReader;  
                return new BucketsAggregator("test", AggregatorFactories.EMPTY, searchContext, null, null, null) {
public class BucketsAggregatorTests extends AggregatorTestCase {
                    @Override
        BucketsAggregator mergeAggregator = buildMergeAggregator();
        for (int i = 0; i < 20; i++) {  
                );  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.AggregatorFactories;  
}  
 * ownership. Elasticsearch licenses this file to you under  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
            mergeAggregator.incrementBucketDocCount(i, i);  
 * compatible open source license.
import org.apache.lucene.tests.index.RandomIndexWriter;
 *  
        for (int i = 0; i < 10; i++) {
import org.apache.lucene.index.IndexReader;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.LeafBucketCollector;  
        for (int i = 0; i < 5; i++) {
 * license agreements. See the NOTICE file distributed with
    public void testBucketMergeNoDelete() throws IOException {
                    }
import org.opensearch.search.aggregations.InternalAggregation;
 */  
import org.opensearch.search.internal.SearchContext;
/*  
 * under the License.  
        }
                    }  
            }
 */  
                IndexSearcher indexSearcher = new IndexSearcher(indexReader);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            }  
                    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
import static org.opensearch.search.aggregations.MultiBucketConsumerService.DEFAULT_MAX_BUCKETS;  
    }
            }
                indexWriter.addDocument(document);  
                        return null;  
                    @Override  
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                Document document = new Document();
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 5; i < 10; i++) {
                    new NumberFieldMapper.NumberFieldType("test", NumberFieldMapper.NumberType.INTEGER)
import org.apache.lucene.document.Document;
            // This is buckets i and i + 5
                    new MultiBucketConsumerService.MultiBucketConsumer(
        assertEquals(mergeAggregator.getDocCounts().size(), 10); // Confirm that the 10 other buckets were deleted
                        return null;
        mergeAggregator.grow(10);
                    null,  
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                        DEFAULT_MAX_BUCKETS,
 * Unless required by applicable law or agreed to in writing,
            // The i'th bucket should now have all docs whose index % 5 = i  
        }
import org.apache.lucene.search.IndexSearcher;  
 *
import java.io.IOException;
                document.add(new SortedNumericDocValuesField("numeric", 0));
                    indexSearcher,
import org.opensearch.search.aggregations.AggregatorTestCase;
        // Put the buckets in indices 5 ... 14 into bucket 5, and delete the rest of the buckets
