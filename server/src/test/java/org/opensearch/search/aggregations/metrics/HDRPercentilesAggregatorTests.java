            iw.addDocument(singleton(new NumericDocValuesField("number", 20)));
        }
            iw.addDocument(asList(new LongPoint("row", 3), new SortedNumericDocValuesField("number", 40)));
import static java.util.Arrays.asList;
import org.apache.lucene.search.FieldExistsQuery;
 * the Apache License, Version 2.0 (the "License"); you may
 */
 */
            assertEquals(20.0d, hdr.percentile(50), approximation);
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
            assertEquals(0L, hdr.state.getTotalCount());
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 60)));
            iw.addDocument(asList(new LongPoint("row", 1), new SortedNumericDocValuesField("number", 10)));
            double approximation = 0.05d;
        Consumer<InternalHDRPercentiles> verify,
        final String fieldName = "range";
import org.apache.lucene.document.SortedSetDocValuesField;
import org.apache.lucene.document.LongPoint;
import java.util.function.Consumer;
                PercentilesAggregationBuilder builder;
    private void testCase(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalHDRPercentiles> verify)
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                HDRPercentilesAggregator aggregator = createAggregator(builder, indexSearcher, fieldType);
            assertTrue(AggregationInspectionHelper.hasValue(hdr));
import static java.util.Collections.singleton;
import org.apache.lucene.index.IndexReader;
     */
        BytesRef encodedRange = RangeType.DOUBLE.encodeRanges(Collections.singleton(range));
                buildIndex.accept(indexWriter);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
            percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foobar"))));
            assertEquals(2L, hdr.state.getTotalCount());
    public void testStringField() throws IOException {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
 * software distributed under the License is distributed on an
        testCase(LongPoint.newRangeQuery("row", 5, 10), docs, hdr -> {
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
 * ownership. Elasticsearch licenses this file to you under
public class HDRPercentilesAggregatorTests extends AggregatorTestCase {
 * You may obtain a copy of the License at
import org.opensearch.index.mapper.NumberFieldMapper;
        });
    }
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, encodedRange)));
import org.opensearch.index.mapper.RangeType;
 * this work for additional information regarding copyright
 */
                aggregator.postCollection();
import org.opensearch.index.mapper.MappedFieldType;
            assertEquals(10.0d, hdr.percentile(randomDoubleBetween(1, 50, true)), 0.05d);
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.RangeFieldMapper;
            assertEquals(20.0d, hdr.percentile(50), approximation);
        testCase(query, buildIndex, verify, fieldType, "number");
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
 * specific language governing permissions and limitations
    public void testNoDocs() throws IOException {
            iw.addDocument(asList(new LongPoint("row", 4), new SortedNumericDocValuesField("number", 60)));
            assertFalse(AggregationInspectionHelper.hasValue(hdr));
 * Licensed to Elasticsearch under one or more contributor
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 40)));
                .compression(100.0) // <-- this should trigger an exception
package org.opensearch.search.aggregations.metrics;
 * compatible open source license.
                // TODO this randomization path should be removed when the old settings are removed
import org.apache.lucene.store.Directory;
            assertFalse(AggregationInspectionHelper.hasValue(hdr));
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            assertEquals(60.0d, hdr.percentile(99), approximation);
     * Attempting to use HDRPercentileAggregation on a string field throws IllegalArgumentException
            }
import org.apache.lucene.document.NumericDocValuesField;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        Query query,
        });
            iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("bogus"))));
import java.io.IOException;
    public void testSomeMatchesNumericDocValues() throws IOException {
            // Intentionally not writing any docs
 * under the License.
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 20)));
 * SPDX-License-Identifier: Apache-2.0
            iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("zwomp"))));
    }
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
    }
        });
import org.apache.lucene.util.BytesRef;
    ) throws IOException {
        expectThrows(IllegalArgumentException.class, () -> testCase(new FieldExistsQuery(fieldName), iw -> {
    }
 *
    }
/*
    @Override
        throws IOException {
     * Attempting to use HDRPercentileAggregation on a range field throws IllegalArgumentException
                    PercentilesConfig hdr = new PercentilesConfig.Hdr();
        }, hdr -> {
            double approximation = 0.05d;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }, hdr -> {
            assertEquals(0L, hdr.state.getTotalCount());
        });
        }, hdr -> {
            assertEquals(10.0d, hdr.percentile(25), approximation);
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, RangeType.DOUBLE);
                    builder = new PercentilesAggregationBuilder("test").field(fieldName).percentilesConfig(hdr);
            iw.addDocument(singleton(new NumericDocValuesField("number", 60)));
                .method(PercentilesMethod.HDR)
        // Currently fails (throws ClassCast exception), but should be fixed once HDRPercentileAggregation uses the ValuesSource registry
            assertTrue(AggregationInspectionHelper.hasValue(hdr));
    @Override
        testCase(LongPoint.newRangeQuery("row", 0, 2), docs, hdr -> {
 *
 * GitHub history for details.
/*
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.tests.index.RandomIndexWriter;
                } else {
        int sigDigits = randomIntBetween(1, 5);
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/42949")
import org.opensearch.search.aggregations.AggregationBuilder;
import java.util.List;
            iw.addDocument(asList(new LongPoint("row", 2), new SortedNumericDocValuesField("number", 20)));
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
                aggregator.preCollection();
        try (Directory directory = newDirectory()) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
    }
    }
    public void testQueryFiltering() throws IOException {
 *
     */
        }, hdr -> {}, fieldType, fieldName));
                }
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.search.IndexSearcher;
 * license agreements. See the NOTICE file distributed with
    private void testCase(
                .field("value");
    }
                    builder = new PercentilesAggregationBuilder("test").field(fieldName).method(PercentilesMethod.HDR);
                indexSearcher.search(query, aggregator);
        final String fieldName = "string";
import org.opensearch.search.aggregations.support.ValuesSourceType;
            assertEquals(10.0d, hdr.percentile(25), approximation);
        String fieldName
            assertEquals(40.0d, hdr.percentile(75), approximation);
        });
        }, hdr -> {}, fieldType, fieldName));
/*
            assertEquals(4L, hdr.state.getTotalCount());
import org.opensearch.common.CheckedConsumer;
        });
    /**
            assertEquals(0L, hdr.state.getTotalCount());
            iw.addDocument(singleton(new NumericDocValuesField("number", 10)));
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
            assertEquals(4L, hdr.state.getTotalCount());
            iw.addDocument(singleton(new NumericDocValuesField("number", 40)));
    public void testRangeField() throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
import java.util.Collections;
import org.apache.lucene.search.Query;
    public void testNoMatchingField() throws IOException {
 * The OpenSearch Contributors require contributions made to
            assertFalse(AggregationInspectionHelper.hasValue(hdr));
        final CheckedConsumer<RandomIndexWriter, IOException> docs = iw -> {
        testCase(new FieldExistsQuery("number"), iw -> {
import org.apache.lucene.document.BinaryDocValuesField;
    }
import org.opensearch.index.mapper.KeywordFieldMapper;
    public void testHdrThenTdigestSettings() throws Exception {
                if (randomBoolean()) {
                verify.accept((InternalHDRPercentiles) aggregator.buildAggregation(0L));
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
            assertEquals(40.0d, hdr.percentile(75), approximation);
        testCase(new FieldExistsQuery("number"), iw -> {
        return new PercentilesAggregationBuilder("hdr_percentiles").field(fieldName).percentilesConfig(new PercentilesConfig.Hdr());
import java.util.Arrays;
        };
        });
        MappedFieldType fieldType,
 *    http://www.apache.org/licenses/LICENSE-2.0
        RangeFieldMapper.Range range = new RangeFieldMapper.Range(RangeType.DOUBLE, 1.0D, 5.0D, true, true);
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        }, hdr -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 10)));
            }
            assertEquals(60.0d, hdr.percentile(99), approximation);
        testCase(new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
    }
        assertThat(e.getMessage(), equalTo("Cannot set [compression] because the method has already been configured for HDRHistogram"));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.AggregatorTestCase;
    /**
}
            assertTrue(AggregationInspectionHelper.hasValue(hdr));
        testCase(new MatchAllDocsQuery(), iw -> {
        expectThrows(IllegalArgumentException.class, () -> testCase(new FieldExistsQuery(fieldName), iw -> {
