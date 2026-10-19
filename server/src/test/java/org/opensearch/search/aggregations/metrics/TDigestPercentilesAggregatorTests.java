        return new PercentilesAggregationBuilder("tdist_percentiles").field(fieldName).percentilesConfig(new PercentilesConfig.TDigest());
        });
            iw.addDocument(asList(new LongPoint("row", 7), new SortedNumericDocValuesField("number", 8)));
    ) throws IOException {
import java.util.List;
            assertEquals("3.0", tdigest.percentileAsString(71));
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
    }
            assertFalse(AggregationInspectionHelper.hasValue(tdigest));
            iw.addDocument(asList(new LongPoint("row", 6), new SortedNumericDocValuesField("number", 5)));
import org.opensearch.search.aggregations.support.ValuesSourceType;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
/*
        final CheckedConsumer<RandomIndexWriter, IOException> docs = iw -> {
import org.apache.lucene.index.DirectoryReader;
import java.io.IOException;
 */
            equalTo("Cannot set [numberOfSignificantValueDigits] because the " + "method has already been configured for TDigest")
            assertEquals(0L, tdigest.state.size());
 * under the License.
import org.apache.lucene.index.IndexReader;
import org.opensearch.index.mapper.MappedFieldType;
 * KIND, either express or implied.  See the License for the
    }
                }
        int sigDigits = randomIntBetween(1, 5);
            assertEquals(8.0d, tdigest.percentile(100), 0.0d);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
    }
    }
            assertTrue(AggregationInspectionHelper.hasValue(tdigest));
            percentiles("percentiles").compression(100.0)
                buildIndex.accept(indexWriter);
 *
 * software distributed under the License is distributed on an
    }
        testCase(new FieldExistsQuery("number"), iw -> {
 * the Apache License, Version 2.0 (the "License"); you may
        try (Directory directory = newDirectory()) {
                aggregator.preCollection();
        });
        });
                aggregator.postCollection();
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.search.aggregations.AggregatorTestCase;
    public void testSomeMatchesNumericDocValues() throws IOException {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));
            assertEquals(4L, tdigest.state.centroids().size());
import org.apache.lucene.search.Query;
import org.apache.lucene.search.IndexSearcher;
            assertEquals("1.0", tdigest.percentileAsString(33));
        });
        });
import org.apache.lucene.document.LongPoint;
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
            assertEquals("5.0", tdigest.percentileAsString(75));
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
            assertEquals(1.0d, tdigest.percentile(33), 0.0d);
 *
import org.apache.lucene.tests.index.RandomIndexWriter;
            iw.addDocument(asList(new LongPoint("row", 2), new SortedNumericDocValuesField("number", 1)));
 * ownership. Elasticsearch licenses this file to you under
            assertEquals(1.0d, tdigest.percentile(50), 0.0d);
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
    @Override
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 0)));
        testCase(new FieldExistsQuery("number"), iw -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertEquals(7L, tdigest.state.size());
import java.util.Arrays;
            assertFalse(AggregationInspectionHelper.hasValue(tdigest));
            assertEquals(2.0d, tdigest.percentile(100), 0.0d);
            assertEquals("0.0", tdigest.percentileAsString(1));
import static java.util.Collections.singleton;
import org.apache.lucene.search.FieldExistsQuery;
            assertTrue(AggregationInspectionHelper.hasValue(tdigest));
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
            assertEquals(1.0d, tdigest.percentile(25), 0.0d);
    }
 * You may obtain a copy of the License at
        }, tdigest -> {
            iw.addDocument(singleton(new NumericDocValuesField("number", 0)));
 */
        }, tdigest -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 8)));
            assertEquals(tdigest.state.size(), 7L);
import org.apache.lucene.search.MatchAllDocsQuery;
                    builder = new PercentilesAggregationBuilder("test").field("number").method(PercentilesMethod.TDIGEST);
        Consumer<InternalTDigestPercentiles> verify
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
                    builder = new PercentilesAggregationBuilder("test").field("number").percentilesConfig(hdr);
    }
                PercentilesAggregationBuilder builder;
/*
import static java.util.Arrays.asList;
 * license agreements. See the NOTICE file distributed with
            assertEquals(3.0d, tdigest.percentile(71), 0.0d);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 5)));
 * this work for additional information regarding copyright
            assertEquals(0.0d, tdigest.percentile(1), 0.0d);
                indexSearcher.search(query, aggregator);
            assertEquals(4L, tdigest.state.size());
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        testCase(new MatchAllDocsQuery(), iw -> {
        });
            assertEquals(0L, tdigest.state.size());
 * compatible open source license.
            assertEquals(5.0d, tdigest.percentile(75), 0.0d);
    public void testQueryFiltering() throws IOException {
import org.apache.lucene.store.Directory;
 * specific language governing permissions and limitations
            assertEquals(2.0d, tdigest.percentile(50), 0.0d);
 *
 */
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
            assertEquals(0L, tdigest.state.centroids().size());
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
                .method(PercentilesMethod.TDIGEST)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        assertThat(
                .field("value");
            assertEquals(0L, tdigest.state.size());
            iw.addDocument(asList(new LongPoint("row", 3), new SortedNumericDocValuesField("number", 1)));
        );
            }
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
package org.opensearch.search.aggregations.metrics;
            iw.addDocument(singleton(new NumericDocValuesField("number", 5)));
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
            // Intentionally not writing any docs
                TDigestPercentilesAggregator aggregator = createAggregator(builder, indexSearcher, fieldType);
            assertEquals(1.0d, tdigest.percentile(25), 0.0d);
 *    http://www.apache.org/licenses/LICENSE-2.0
        testCase(new MatchAllDocsQuery(), iw -> {
 * not use this file except in compliance with the License.
        testCase(LongPoint.newRangeQuery("row", 1, 4), docs, tdigest -> {
    public void testTdigestThenHdrSettings() throws Exception {
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
                if (randomBoolean()) {
            iw.addDocument(asList(new LongPoint("row", 1), new SortedNumericDocValuesField("number", 0)));
            iw.addDocument(asList(new LongPoint("row", 5), new SortedNumericDocValuesField("number", 3)));
    @Override
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
            iw.addDocument(asList(new LongPoint("row", 4), new SortedNumericDocValuesField("number", 2)));
                .numberOfSignificantValueDigits(sigDigits) // <-- this should trigger an exception
            assertEquals("8.0", tdigest.percentileAsString(100));
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
/*
                verify.accept((InternalTDigestPercentiles) aggregator.buildAggregation(0L));
}
        }, tdigest -> {
                // TODO this randomization path should be removed when the old settings are removed
            assertEquals("2.0", tdigest.percentileAsString(50));
    public void testNoDocs() throws IOException {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 2)));
        };
        testCase(LongPoint.newRangeQuery("row", 100, 110), docs, tdigest -> {
            assertEquals(1.0d, tdigest.percentile(22), 0.0d);
            }
            assertEquals("8.0", tdigest.percentileAsString(88));
import org.opensearch.common.CheckedConsumer;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.apache.lucene.document.SortedNumericDocValuesField;
 * Unless required by applicable law or agreed to in writing,
                    PercentilesConfig hdr = new PercentilesConfig.TDigest();
    private void testCase(
        });
    }
            assertEquals("1.0", tdigest.percentileAsString(22));
            assertEquals(8.0d, tdigest.percentile(88), 0.0d);
            assertEquals(7L, tdigest.state.centroids().size());
import org.apache.lucene.document.NumericDocValuesField;
        }, tdigest -> {
    public void testNoMatchingField() throws IOException {
import java.util.function.Consumer;
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
 * SPDX-License-Identifier: Apache-2.0
            e.getMessage(),
                } else {
public class TDigestPercentilesAggregatorTests extends AggregatorTestCase {
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
        }
import static org.hamcrest.Matchers.equalTo;
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));
            assertEquals("1.0", tdigest.percentileAsString(25));
import org.opensearch.index.mapper.NumberFieldMapper;
            assertTrue(AggregationInspectionHelper.hasValue(tdigest));
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
            assertTrue(tdigest.state.centroids().size() <= 7L);
        Query query,
            assertFalse(AggregationInspectionHelper.hasValue(tdigest));
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
 * this file be licensed under the Apache-2.0 license or a
