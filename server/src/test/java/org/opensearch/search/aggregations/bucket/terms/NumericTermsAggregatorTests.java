                verify.accept(rareTerms);
                null
        );
            AggregationExecutionException.class,
            aggregation -> aggregation.field(LONG_FIELD),
                // Case 2: QuickSelect selection, when buckets > size && buckets > 5*size (size=20, buckets=100)
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                aggregationBuilder3.userValueTypeHint(ValueType.NUMERIC);
import org.opensearch.index.mapper.MappedFieldType;
            null // without type hint
    ) throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
                    new MultiBucketConsumerService.MultiBucketConsumer(
                dataset,
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.document.Document;
                }
 * KIND, either express or implied.  See the License for the
            e.getMessage(),
import org.apache.lucene.index.DirectoryReader;
                    searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),
                agg -> fail("test should have failed with exception"),
            for (int j = 0; j < i; j++) {
            new MatchNoDocsQuery(),
                ValueType.NUMERIC // with type hint
        }
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            assertEquals(9, agg.getBuckets().size());
        Consumer<InternalMappedTerms> verify,
                    + "include/exclude settings as they can only be applied to string fields. Use an array of numeric "
                    ),
            }
            }
        },
 */
package org.opensearch.search.aggregations.bucket.terms;
        IncludeExclude includeExclude = new IncludeExclude("foo", null);
 */
    static {
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name");
                assertEquals("quick_select", aggregator2.getResultSelectionStrategy());
                    ),
import org.apache.lucene.store.Directory;
    }
    }
        );
 *
                    indexSearcher,
                }
        List<Long> dataset,
        assertEquals(BucketSelectionStrategy.PRIORITY_QUEUE, strategy2);
            e.getMessage(),
import org.apache.lucene.search.IndexSearcher;
 * ownership. Elasticsearch licenses this file to you under
                Document document = new Document();
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));
            ValueType.NUMERIC // with type hint
            new MatchNoDocsQuery(),
 * license agreements. See the NOTICE file distributed with
                    + "values for include/exclude clauses used to filter numeric fields"
                assertThat(bucket.getDocCount(), equalTo(9L - i));
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                d.add((long) i);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                    document.add(new LongPoint(LONG_FIELD, value));
        java.util.Comparator<InternalTerms.Bucket<?>> mockComparator = (b1, b2) -> Long.compare(b2.getDocCount(), b1.getDocCount());
 * You may obtain a copy of the License at
        assertEquals(BucketSelectionStrategy.QUICK_SELECT_OR_SELECT_ALL, strategy1);
                    indexSearcher,
            agg -> assertEquals(0, agg.getBuckets().size()),
                assertThat(bucket.getDocCount(), equalTo(9L - i));
                aggregator1.buildAggregations(new long[] { 0 });
            AggregationExecutionException.class,
import org.opensearch.search.aggregations.LeafBucketCollector;
                NumericTermsAggregator aggregator2 = createAggregatorWithCustomizableSearchContext(
                    document.add(new LongPoint(LONG_FIELD, value));
                    searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),
            () -> testSearchCase(
        for (LeafReaderContext ctx : searcher.getIndexReader().leaves()) {
                "Aggregation [_name] cannot support regular expression style "
                assertEquals("priority_queue", aggregator1.getResultSelectionStrategy());
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
                        DEFAULT_MAX_BUCKETS,
                InternalMappedTerms rareTerms = searchAndReduce(indexSearcher, query, aggregationBuilder, longFieldType);
                        DEFAULT_MAX_BUCKETS,
import static org.hamcrest.Matchers.equalTo;
            }
                MappedFieldType longFieldType = new NumberFieldMapper.NumberFieldType(LONG_FIELD, NumberFieldMapper.NumberType.LONG);
 * this work for additional information regarding copyright
                aggregator2.buildAggregations(new long[] { 0 });
    public void testNumericTermAggregatorForResultSelectionStrategy() throws IOException {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                aggregationBuilder2.userValueTypeHint(ValueType.NUMERIC);
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.apache.lucene.document.SortedNumericDocValuesField;
            null // without type hint
        );
 * Modifications Copyright OpenSearch Contributors. See
 */
        BucketSelectionStrategy strategy2 = BucketSelectionStrategy.determine(2, 100L, BucketOrder.count(false), mockComparator, 1);
    }
}
                assertEquals("select_all", aggregator3.getResultSelectionStrategy());
        testSearchCase(
        assertThat(
     * Helper method to collect all documents using the aggregator's leaf collector.
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            }
            for (int i = 0; i < 9; i++) {
     */
        for (long i = 0; i < 100; i++) {
                collectDocuments(indexSearcher, aggregator3);
                Document document = new Document();
        testSearchCase(
                    createIndexSettings(),
        );
        );
    }
/*
                // Case 1: PriorityQueue selection, when buckets > size && buckets <= 5*size (size=2, buckets=100)
                    + "values for include/exclude clauses used to filter numeric fields"
import org.opensearch.search.aggregations.AggregationExecutionException;
                    new MatchAllDocsQuery(),
                    new MultiBucketConsumerService.MultiBucketConsumer(
        );
                aggregationBuilder3.order(org.opensearch.search.aggregations.BucketOrder.count(false)); // count desc
        }
    public void testBadIncludeExclude() throws IOException {
            }
import java.util.function.Consumer;
                    aggregationBuilder1,
                    createIndexSettings(),
                    searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),
    }
                    longFieldType
                    new MatchAllDocsQuery(),
 * not use this file except in compliance with the License.
import java.util.List;
                NumericTermsAggregator aggregator1 = createAggregatorWithCustomizableSearchContext(
            )
                );
                NumericTermsAggregator aggregator3 = createAggregatorWithCustomizableSearchContext(
                    aggregationBuilder3,
                assertThat(bucket.getKey(), equalTo(9L - i));
    }
import org.apache.lucene.tests.index.RandomIndexWriter;
                collectDocuments(indexSearcher, aggregator2);
            ValueType.NUMERIC // with type hint
    /**
                    indexSearcher,
                    indexWriter.addDocument(document);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                );
            )
 * The OpenSearch Contributors require contributions made to
 *
                new MatchNoDocsQuery(),
                TermsAggregationBuilder aggregationBuilder3 = new TermsAggregationBuilder("_name").field(LONG_FIELD).size(110);
                aggregation -> aggregation.field(LONG_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),
    private void testSearchCase(
                }
            for (int i = 0; i < 9; i++) {
                for (Long value : dataset) {
                        DEFAULT_MAX_BUCKETS,
                aggregation -> aggregation.field(LONG_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),
        List<Long> dataSet = new ArrayList<>();
        }
                );
            equalTo(
    public void testBucketSelectionStrategyFactorSetting() {
        ValueType valueType
import static org.mockito.Mockito.when;
                }
            dataset,
        dataset = d;
                aggregator3.buildAggregations(new long[] { 0 });
            )
        );
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    longFieldType
        Consumer<TermsAggregationBuilder> configure,
        );
        List<Long> d = new ArrayList<>(45);
            () -> testSearchCase(
        }
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
public class NumericTermsAggregatorTests extends AggregatorTestCase {
                    document.clear();
import org.opensearch.core.common.breaker.CircuitBreaker;
        assertThat(
                    longFieldType
        // Test with factor = 0 (should always use priority_queue)
                    aggregationBuilder.userValueTypeHint(valueType);
                collectDocuments(indexSearcher, aggregator1);
import org.opensearch.search.aggregations.AggregatorTestCase;
                MappedFieldType longFieldType = new NumberFieldMapper.NumberFieldType(LONG_FIELD, NumberFieldMapper.NumberType.LONG);
                "Aggregation [_name] cannot support regular expression style "
        Query query,
                TermsAggregationBuilder aggregationBuilder1 = new TermsAggregationBuilder("_name").field(LONG_FIELD).size(2);
                TermsAggregationBuilder aggregationBuilder2 = new TermsAggregationBuilder("_name").field(LONG_FIELD).size(20);
 * compatible open source license.
                    ),
        testSearchCase(query, dataset, aggregation -> aggregation.field(LONG_FIELD), agg -> {
                    aggregationBuilder2,
 * this file be licensed under the Apache-2.0 license or a
    }
                agg -> fail("test should have failed with exception"),
        AggregationExecutionException e = expectThrows(
        try (Directory directory = newDirectory()) {
 * Unless required by applicable law or agreed to in writing,
                new MatchNoDocsQuery(),
    private void collectDocuments(IndexSearcher searcher, NumericTermsAggregator aggregator) throws IOException {
                if (valueType != null) {
                    document.clear();
                // Case 3: Get All buckets when buckets <= size (size=110, buckets=100)
                    createIndexSettings(),
        // Numerics don't support any regex include/exclude, so should fail no matter what we do
                    new MultiBucketConsumerService.MultiBucketConsumer(
        // default behavior
import org.apache.lucene.index.IndexReader;
            LeafBucketCollector leafCollector = aggregator.getLeafCollector(ctx, LeafBucketCollector.NO_OP_COLLECTOR);
        BucketSelectionStrategy strategy0 = BucketSelectionStrategy.determine(20, 100L, BucketOrder.count(false), mockComparator, 0);
    private static final List<Long> dataset;
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        BucketSelectionStrategy strategy1 = BucketSelectionStrategy.determine(20, 100L, BucketOrder.count(false), mockComparator, 5);
                for (Long value : dataSet) {
    private static final String LONG_FIELD = "long";
import java.io.IOException;
                leafCollector.collect(docId, 0); // collect with bucket ordinal 0 (root bucket)
                assertThat(bucket.getKey(), equalTo(9L - i));
 * under the License.
            agg -> assertEquals(0, agg.getBuckets().size()),
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.BucketOrder;
                dataset,
    public void testMatchAllDocs() throws IOException {
        for (int i = 0; i < 10; i++) {
            dataSet.add(i);
 * the Apache License, Version 2.0 (the "License"); you may
                LongTerms.Bucket bucket = (LongTerms.Bucket) agg.getBuckets().get(i);
    public void testMatchNoDocs() throws IOException {
            dataset,
                    configure.accept(aggregationBuilder);
import org.opensearch.search.aggregations.support.ValueType;
    }
        Query query = new MatchAllDocsQuery();
import org.apache.lucene.document.LongPoint;
            }
            assertEquals(9, agg.getBuckets().size());
                aggregationBuilder1.userValueTypeHint(ValueType.NUMERIC);
import org.apache.lucene.search.MatchNoDocsQuery;
            aggregation -> aggregation.field(LONG_FIELD),
            equalTo(
                aggregationBuilder2.order(org.opensearch.search.aggregations.BucketOrder.count(false)); // count desc
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
        e = expectThrows(
import org.opensearch.index.mapper.NumberFieldMapper;
        }
/*
        },
     * This simulates the document collection phase that happens during normal aggregation.
            )
                    indexWriter.addDocument(document);
                    + "include/exclude settings as they can only be applied to string fields. Use an array of numeric "
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                LongTerms.Bucket bucket = (LongTerms.Bucket) agg.getBuckets().get(i);
 *
        try (Directory directory = newDirectory()) {
        assertEquals(BucketSelectionStrategy.PRIORITY_QUEUE, strategy0);
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));
            for (int docId = 0; docId < ctx.reader().maxDoc(); docId++) {
        testSearchCase(query, dataset, aggregation -> aggregation.field(LONG_FIELD), agg -> {
/*
                aggregationBuilder1.order(org.opensearch.search.aggregations.BucketOrder.count(false)); // count desc
import org.apache.lucene.search.Query;
import java.util.ArrayList;
                if (configure != null) {
                    new MatchAllDocsQuery(),
