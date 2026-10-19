            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 0)));
                .method(PercentilesMethod.TDIGEST)
import java.util.function.Consumer;  
        return new PercentilesAggregationBuilder("tdist_percentiles").field(fieldName).percentilesConfig(new PercentilesConfig.TDigest());
        });
            assertEquals("1.0", tdigest.percentileAsString(33));
import static java.util.Collections.singleton;  
        });
import org.opensearch.search.aggregations.support.ValuesSourceType;
            assertTrue(AggregationInspectionHelper.hasValue(tdigest));  
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));  
    public void testTdigestThenHdrSettings() throws Exception {
            assertFalse(AggregationInspectionHelper.hasValue(tdigest));
            assertEquals(0L, tdigest.state.size());
        }
                } else {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                buildIndex.accept(indexWriter);
 * SPDX-License-Identifier: Apache-2.0
        });
            assertEquals("0.0", tdigest.percentileAsString(1));
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
import org.opensearch.search.aggregations.AggregatorTestCase;
 * license agreements. See the NOTICE file distributed with
    }  
            assertEquals(7L, tdigest.state.size());  
 * this file be licensed under the Apache-2.0 license or a
        testCase(new MatchAllDocsQuery(), iw -> {
 * compatible open source license.
            assertEquals(8.0d, tdigest.percentile(88), 0.0d);
    }  
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*
    }
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(8.0d, tdigest.percentile(100), 0.0d);
        });
import java.io.IOException;  
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));  
            assertEquals("1.0", tdigest.percentileAsString(25));  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
        testCase(new FieldExistsQuery("number"), iw -> {  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
            percentiles("percentiles").compression(100.0)
    public void testNoMatchingField() throws IOException {
import org.apache.lucene.document.SortedNumericDocValuesField;  
 *
    }
        testCase(LongPoint.newRangeQuery("row", 100, 110), docs, tdigest -> {  
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
            assertEquals(1.0d, tdigest.percentile(50), 0.0d);
                    builder = new PercentilesAggregationBuilder("test").field("number").method(PercentilesMethod.TDIGEST);
                aggregator.postCollection();
            assertEquals(tdigest.state.size(), 7L);  
    @Override
 * specific language governing permissions and limitations
            iw.addDocument(asList(new LongPoint("row", 1), new SortedNumericDocValuesField("number", 0)));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
            assertEquals("8.0", tdigest.percentileAsString(88));
            e.getMessage(),
 * Unless required by applicable law or agreed to in writing,
 *
        Consumer<InternalTDigestPercentiles> verify  
    ) throws IOException {
                verify.accept((InternalTDigestPercentiles) aggregator.buildAggregation(0L));  
import org.apache.lucene.search.IndexSearcher;
public class TDigestPercentilesAggregatorTests extends AggregatorTestCase {
import org.apache.lucene.index.DirectoryReader;
            equalTo("Cannot set [numberOfSignificantValueDigits] because the " + "method has already been configured for TDigest")
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));  
 * this work for additional information regarding copyright
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
    }
        });
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 5)));
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private void testCase(  
            assertEquals("1.0", tdigest.percentileAsString(22));  
            assertEquals(1.0d, tdigest.percentile(33), 0.0d);  
 * software distributed under the License is distributed on an
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
 */  
            iw.addDocument(asList(new LongPoint("row", 5), new SortedNumericDocValuesField("number", 3)));
            assertEquals(5.0d, tdigest.percentile(75), 0.0d);
 * not use this file except in compliance with the License.
                }
            iw.addDocument(singleton(new NumericDocValuesField("number", 0)));
import java.util.List;
            assertEquals(1.0d, tdigest.percentile(25), 0.0d);
        }, tdigest -> {
            assertEquals(1.0d, tdigest.percentile(22), 0.0d);
        };
import static java.util.Arrays.asList;
        });
import org.opensearch.search.aggregations.AggregationBuilder;  
            assertEquals("2.0", tdigest.percentileAsString(50));
/*  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
 * Modifications Copyright OpenSearch Contributors. See
        Query query,
    @Override  
    }  
            iw.addDocument(asList(new LongPoint("row", 3), new SortedNumericDocValuesField("number", 1)));
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
    public void testSomeMatchesNumericDocValues() throws IOException {
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));  
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 8)));
import java.util.Arrays;
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
}
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
        }, tdigest -> {
            assertEquals(0L, tdigest.state.size());
            assertEquals(0L, tdigest.state.centroids().size());
        );  
            // Intentionally not writing any docs  
            }
                PercentilesAggregationBuilder builder;
/*  
        testCase(new FieldExistsQuery("number"), iw -> {  
 * KIND, either express or implied.  See the License for the
    public void testNoDocs() throws IOException {
            iw.addDocument(asList(new LongPoint("row", 6), new SortedNumericDocValuesField("number", 5)));
            assertFalse(AggregationInspectionHelper.hasValue(tdigest));  
import org.apache.lucene.search.Query;  
            assertEquals(3.0d, tdigest.percentile(71), 0.0d);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        try (Directory directory = newDirectory()) {
            assertEquals(4L, tdigest.state.centroids().size());
 * You may obtain a copy of the License at  
            assertEquals(1.0d, tdigest.percentile(25), 0.0d);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
import static org.hamcrest.Matchers.equalTo;
 * the Apache License, Version 2.0 (the "License"); you may
            iw.addDocument(singleton(new NumericDocValuesField("number", 5)));
        }, tdigest -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 2)));
import org.apache.lucene.document.NumericDocValuesField;
                if (randomBoolean()) {  
 * The OpenSearch Contributors require contributions made to  
            assertEquals(4L, tdigest.state.size());
import org.opensearch.index.mapper.NumberFieldMapper;
                TDigestPercentilesAggregator aggregator = createAggregator(builder, indexSearcher, fieldType);
import org.apache.lucene.index.IndexReader;
        final CheckedConsumer<RandomIndexWriter, IOException> docs = iw -> {
        int sigDigits = randomIntBetween(1, 5);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
                indexSearcher.search(query, aggregator);
 * under the License.  
    }
            assertEquals("8.0", tdigest.percentileAsString(100));  
    }
            iw.addDocument(asList(new LongPoint("row", 2), new SortedNumericDocValuesField("number", 1)));
import org.apache.lucene.tests.index.RandomIndexWriter;
        testCase(LongPoint.newRangeQuery("row", 1, 4), docs, tdigest -> {  
 *  
            iw.addDocument(asList(new LongPoint("row", 7), new SortedNumericDocValuesField("number", 8)));  
 * GitHub history for details.
            assertEquals(0L, tdigest.state.size());  
            assertTrue(AggregationInspectionHelper.hasValue(tdigest));  
                .field("value");
            assertEquals(0.0d, tdigest.percentile(1), 0.0d);
import org.apache.lucene.search.FieldExistsQuery;  
            assertEquals(2.0d, tdigest.percentile(100), 0.0d);  
import org.opensearch.common.CheckedConsumer;  
        });
        testCase(new MatchAllDocsQuery(), iw -> {
            assertEquals("3.0", tdigest.percentileAsString(71));
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            assertFalse(AggregationInspectionHelper.hasValue(tdigest));  
        }, tdigest -> {
                // TODO this randomization path should be removed when the old settings are removed
                .numberOfSignificantValueDigits(sigDigits) // <-- this should trigger an exception  
                aggregator.preCollection();  
                    builder = new PercentilesAggregationBuilder("test").field("number").percentilesConfig(hdr);
            assertTrue(tdigest.state.centroids().size() <= 7L);
import org.apache.lucene.search.MatchAllDocsQuery;
            }
    public void testQueryFiltering() throws IOException {
            assertEquals(2.0d, tdigest.percentile(50), 0.0d);  
        assertThat(  
 */
package org.opensearch.search.aggregations.metrics;
import org.apache.lucene.store.Directory;
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));  
import org.opensearch.index.mapper.MappedFieldType;
                    PercentilesConfig hdr = new PercentilesConfig.TDigest();  
import org.apache.lucene.document.LongPoint;
            iw.addDocument(asList(new LongPoint("row", 4), new SortedNumericDocValuesField("number", 2)));  
            assertEquals(7L, tdigest.state.centroids().size());
            assertEquals("5.0", tdigest.percentileAsString(75));  
            assertTrue(AggregationInspectionHelper.hasValue(tdigest));
