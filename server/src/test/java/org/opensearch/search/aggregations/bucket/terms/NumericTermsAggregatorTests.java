            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
 * specific language governing permissions and limitations
                collectDocuments(indexSearcher, aggregator2);
        }
            }
                    new MatchAllDocsQuery(),
                verify.accept(rareTerms);  
 * The OpenSearch Contributors require contributions made to  
    }  
                }
        for (long i = 0; i < 100; i++) {  
    ) throws IOException {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                aggregationBuilder1.userValueTypeHint(ValueType.NUMERIC);  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
     */
        );
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.document.Document;  
            equalTo(  
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
        );
    }
                    longFieldType
 *
        }  
                aggregationBuilder3.userValueTypeHint(ValueType.NUMERIC);
 * Unless required by applicable law or agreed to in writing,
                    new MultiBucketConsumerService.MultiBucketConsumer(
 * this file be licensed under the Apache-2.0 license or a
            )
                    + "values for include/exclude clauses used to filter numeric fields"  
import java.util.function.Consumer;
 * GitHub history for details.
            dataset,
            ValueType.NUMERIC // with type hint  
            assertEquals(9, agg.getBuckets().size());
                agg -> fail("test should have failed with exception"),
        );  
    private static final String LONG_FIELD = "long";  
import org.apache.lucene.search.MatchAllDocsQuery;
            }
import static org.mockito.Mockito.when;  
                aggregationBuilder1.order(org.opensearch.search.aggregations.BucketOrder.count(false)); // count desc
            )
/*  
                for (Long value : dataset) {
import org.apache.lucene.store.Directory;
 * under the License.  
                }  
        IncludeExclude includeExclude = new IncludeExclude("foo", null);
}
        );
            dataset,
    }
            }  
                    + "include/exclude settings as they can only be applied to string fields. Use an array of numeric "  
                aggregator1.buildAggregations(new long[] { 0 });  
                    new MultiBucketConsumerService.MultiBucketConsumer(  
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
 */  
        }
            )
    }  
                assertEquals("priority_queue", aggregator1.getResultSelectionStrategy());
        assertThat(
                aggregationBuilder3.order(org.opensearch.search.aggregations.BucketOrder.count(false)); // count desc
            assertEquals(9, agg.getBuckets().size());  
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.opensearch.index.mapper.MappedFieldType;
import java.util.List;
                aggregator2.buildAggregations(new long[] { 0 });
                    createIndexSettings(),
    static {  
            equalTo(
                LongTerms.Bucket bucket = (LongTerms.Bucket) agg.getBuckets().get(i);
                Document document = new Document();
                    document.clear();
        }
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));  
            () -> testSearchCase(
            for (int i = 0; i < 9; i++) {  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
                aggregationBuilder2.order(org.opensearch.search.aggregations.BucketOrder.count(false)); // count desc  
        BucketSelectionStrategy strategy2 = BucketSelectionStrategy.determine(2, 100L, BucketOrder.count(false), mockComparator, 1);  
                aggregation -> aggregation.field(LONG_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),  
            for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {  
        }  
        );
                    indexSearcher,
        Consumer<InternalMappedTerms> verify,
import java.io.IOException;
                agg -> fail("test should have failed with exception"),  
    public void testNumericTermAggregatorForResultSelectionStrategy() throws IOException {
            e.getMessage(),  
                    configure.accept(aggregationBuilder);  
        BucketSelectionStrategy strategy1 = BucketSelectionStrategy.determine(20, 100L, BucketOrder.count(false), mockComparator, 5);  
    private void collectDocuments(IndexSearcher searcher, NumericTermsAggregator aggregator) throws IOException {  
                    searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),
            }
                TermsAggregationBuilder aggregationBuilder2 = new TermsAggregationBuilder("_name").field(LONG_FIELD).size(20);
        },  
        assertEquals(BucketSelectionStrategy.PRIORITY_QUEUE, strategy0);  
    }
        Query query,
 * Modifications Copyright OpenSearch Contributors. See  
        testSearchCase(  
                Document document = new Document();  
                null
                );
    public void testMatchAllDocs() throws IOException {
                assertThat(bucket.getDocCount(), equalTo(9L - i));  
            }
                    document.clear();  
                MappedFieldType longFieldType = new NumberFieldMapper.NumberFieldType(LONG_FIELD, NumberFieldMapper.NumberType.LONG);
        );  
import org.opensearch.search.aggregations.support.ValueType;  
            AggregationExecutionException.class,
                if (configure != null) {
                    ),  
                d.add((long) i);
        java.util.Comparator<InternalTerms.Bucket<?>> mockComparator = (b1, b2) -> Long.compare(b2.getDocCount(), b1.getDocCount());
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
import org.opensearch.index.mapper.NumberFieldMapper;  
                    longFieldType  
                    aggregationBuilder2,  
package org.opensearch.search.aggregations.bucket.terms;
            agg -> assertEquals(0, agg.getBuckets().size()),
                    document.add(new LongPoint(LONG_FIELD, value));
 * this work for additional information regarding copyright
import org.apache.lucene.document.SortedNumericDocValuesField;
            ValueType.NUMERIC // with type hint
            e.getMessage(),
        },
        for (LeafReaderContext ctx : searcher.getIndexReader().leaves()) {
                aggregationBuilder2.userValueTypeHint(ValueType.NUMERIC);
                    new MatchAllDocsQuery(),
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.MatchNoDocsQuery;
                        DEFAULT_MAX_BUCKETS,
                        DEFAULT_MAX_BUCKETS,  
                    + "include/exclude settings as they can only be applied to string fields. Use an array of numeric "
            LeafBucketCollector leafCollector = aggregator.getLeafCollector(ctx, LeafBucketCollector.NO_OP_COLLECTOR);
                assertThat(bucket.getDocCount(), equalTo(9L - i));
                leafCollector.collect(docId, 0); // collect with bucket ordinal 0 (root bucket)
            new MatchNoDocsQuery(),
 * software distributed under the License is distributed on an
        // default behavior
import org.apache.lucene.tests.index.RandomIndexWriter;
                    createIndexSettings(),  
                    new MultiBucketConsumerService.MultiBucketConsumer(
                collectDocuments(indexSearcher, aggregator1);
                    searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),  
                TermsAggregationBuilder aggregationBuilder3 = new TermsAggregationBuilder("_name").field(LONG_FIELD).size(110);  
/*
                    ),
        List<Long> dataSet = new ArrayList<>();
                }
            dataSet.add(i);
                // Case 3: Get All buckets when buckets <= size (size=110, buckets=100)
            aggregation -> aggregation.field(LONG_FIELD),  
        e = expectThrows(
                    new MatchAllDocsQuery(),  
            }
            new MatchNoDocsQuery(),  
import org.apache.lucene.search.IndexSearcher;  
 * ownership. Elasticsearch licenses this file to you under  
        testSearchCase(
    public void testMatchNoDocs() throws IOException {
                ValueType.NUMERIC // with type hint
                "Aggregation [_name] cannot support regular expression style "
 */
                new MatchNoDocsQuery(),  
import org.opensearch.core.common.breaker.CircuitBreaker;  
                NumericTermsAggregator aggregator2 = createAggregatorWithCustomizableSearchContext(
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                InternalMappedTerms rareTerms = searchAndReduce(indexSearcher, query, aggregationBuilder, longFieldType);
                    aggregationBuilder3,
            null // without type hint
                    indexSearcher,  
                assertEquals("select_all", aggregator3.getResultSelectionStrategy());
 * KIND, either express or implied.  See the License for the
        List<Long> dataset,  
                    aggregationBuilder1,
     * This simulates the document collection phase that happens during normal aggregation.
                );
                NumericTermsAggregator aggregator3 = createAggregatorWithCustomizableSearchContext(  
    public void testBadIncludeExclude() throws IOException {
    }
import org.opensearch.search.aggregations.BucketOrder;  
            null // without type hint
                    longFieldType
        Query query = new MatchAllDocsQuery();  
        dataset = d;
                    searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));
                    document.add(new LongPoint(LONG_FIELD, value));  
                assertThat(bucket.getKey(), equalTo(9L - i));  
 */
 * compatible open source license.
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregationBuilder.userValueTypeHint(valueType);  
                MappedFieldType longFieldType = new NumberFieldMapper.NumberFieldType(LONG_FIELD, NumberFieldMapper.NumberType.LONG);  
        assertThat(
                // Case 2: QuickSelect selection, when buckets > size && buckets > 5*size (size=20, buckets=100)  
/*
                }
            )  
                        DEFAULT_MAX_BUCKETS,
                dataset,
            () -> testSearchCase(  
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name");
        AggregationExecutionException e = expectThrows(  
                dataset,
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.document.LongPoint;
                "Aggregation [_name] cannot support regular expression style "
            aggregation -> aggregation.field(LONG_FIELD),
            }
import java.util.ArrayList;  
        BucketSelectionStrategy strategy0 = BucketSelectionStrategy.determine(20, 100L, BucketOrder.count(false), mockComparator, 0);
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        testSearchCase(query, dataset, aggregation -> aggregation.field(LONG_FIELD), agg -> {
        );
                    indexSearcher,
import org.opensearch.search.aggregations.LeafBucketCollector;
                );  
                LongTerms.Bucket bucket = (LongTerms.Bucket) agg.getBuckets().get(i);
 * the Apache License, Version 2.0 (the "License"); you may
            agg -> assertEquals(0, agg.getBuckets().size()),  
import org.apache.lucene.index.IndexReader;
        Consumer<TermsAggregationBuilder> configure,
    /**
 *
                TermsAggregationBuilder aggregationBuilder1 = new TermsAggregationBuilder("_name").field(LONG_FIELD).size(2);
                assertThat(bucket.getKey(), equalTo(9L - i));
                for (Long value : dataSet) {
                if (valueType != null) {
    public void testBucketSelectionStrategyFactorSetting() {
 * You may obtain a copy of the License at  
                aggregation -> aggregation.field(LONG_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),
                    indexWriter.addDocument(document);
        // Test with factor = 0 (should always use priority_queue)
        List<Long> d = new ArrayList<>(45);
        // Numerics don't support any regex include/exclude, so should fail no matter what we do
    }
            for (int docId = 0; docId < ctx.reader().maxDoc(); docId++) {  
    private static final List<Long> dataset;
 *  
                    + "values for include/exclude clauses used to filter numeric fields"
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                NumericTermsAggregator aggregator1 = createAggregatorWithCustomizableSearchContext(
            AggregationExecutionException.class,
                collectDocuments(indexSearcher, aggregator3);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(BucketSelectionStrategy.PRIORITY_QUEUE, strategy2);
        assertEquals(BucketSelectionStrategy.QUICK_SELECT_OR_SELECT_ALL, strategy1);
        try (Directory directory = newDirectory()) {
 * not use this file except in compliance with the License.
                new MatchNoDocsQuery(),
                    createIndexSettings(),
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    indexWriter.addDocument(document);
    private void testSearchCase(
        ValueType valueType  
            }
        testSearchCase(query, dataset, aggregation -> aggregation.field(LONG_FIELD), agg -> {
                aggregator3.buildAggregations(new long[] { 0 });
        for (int i = 0; i < 10; i++) {
                    ),
        );  
        try (Directory directory = newDirectory()) {
                assertEquals("quick_select", aggregator2.getResultSelectionStrategy());  
                // Case 1: PriorityQueue selection, when buckets > size && buckets <= 5*size (size=2, buckets=100)
     * Helper method to collect all documents using the aggregator's leaf collector.  
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.DirectoryReader;  
public class NumericTermsAggregatorTests extends AggregatorTestCase {
import org.opensearch.search.aggregations.AggregationExecutionException;
