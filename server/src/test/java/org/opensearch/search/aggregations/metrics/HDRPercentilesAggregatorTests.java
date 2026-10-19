            assertEquals(20.0d, hdr.percentile(50), approximation);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.index.mapper.RangeFieldMapper;
        }, hdr -> {
            assertTrue(AggregationInspectionHelper.hasValue(hdr));
import org.apache.lucene.util.BytesRef;
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
                    PercentilesConfig hdr = new PercentilesConfig.Hdr();
                indexSearcher.search(query, aggregator);
    ) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 10)));  
                .compression(100.0) // <-- this should trigger an exception  
    }
 * Unless required by applicable law or agreed to in writing,
    private void testCase(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalHDRPercentiles> verify)  
 * KIND, either express or implied.  See the License for the
            iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("zwomp"))));
}  
        });
        Consumer<InternalHDRPercentiles> verify,  
 * compatible open source license.
    @Override
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
import org.apache.lucene.search.IndexSearcher;  
     * Attempting to use HDRPercentileAggregation on a range field throws IllegalArgumentException
        Query query,
                aggregator.preCollection();
                verify.accept((InternalHDRPercentiles) aggregator.buildAggregation(0L));
        testCase(query, buildIndex, verify, fieldType, "number");  
            iw.addDocument(singleton(new NumericDocValuesField("number", 10)));
     */
    }
        }, hdr -> {
            assertFalse(AggregationInspectionHelper.hasValue(hdr));  
import org.apache.lucene.document.BinaryDocValuesField;
import org.apache.lucene.store.Directory;  
 * not use this file except in compliance with the License.
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
    }
    public void testQueryFiltering() throws IOException {
 * You may obtain a copy of the License at  
    public void testNoMatchingField() throws IOException {  
            }
                    builder = new PercentilesAggregationBuilder("test").field(fieldName).percentilesConfig(hdr);  
import org.apache.lucene.search.FieldExistsQuery;
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
import org.apache.lucene.tests.index.RandomIndexWriter;
            assertEquals(0L, hdr.state.getTotalCount());
            assertFalse(AggregationInspectionHelper.hasValue(hdr));
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.apache.lucene.document.SortedNumericDocValuesField;
            assertEquals(4L, hdr.state.getTotalCount());
import java.util.Collections;
        testCase(LongPoint.newRangeQuery("row", 0, 2), docs, hdr -> {
import java.util.function.Consumer;
                }
        }, hdr -> {}, fieldType, fieldName));  
import static org.hamcrest.Matchers.equalTo;  
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
import org.apache.lucene.index.IndexReader;
    }
 * specific language governing permissions and limitations
            assertEquals(2L, hdr.state.getTotalCount());
import org.apache.lucene.search.Query;
 */  
        }, hdr -> {  
 *  
 *
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            assertEquals(0L, hdr.state.getTotalCount());  
    }  
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, encodedRange)));
import static java.util.Arrays.asList;  
    }
        throws IOException {
        }
            assertFalse(AggregationInspectionHelper.hasValue(hdr));  
            iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("bogus"))));  
        });  
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 60)));  
    public void testHdrThenTdigestSettings() throws Exception {
            iw.addDocument(singleton(new NumericDocValuesField("number", 20)));
                aggregator.postCollection();  
 * Modifications Copyright OpenSearch Contributors. See
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
import org.apache.lucene.document.LongPoint;
                .field("value");
import org.opensearch.search.aggregations.AggregatorTestCase;
    public void testNoDocs() throws IOException {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(AggregationInspectionHelper.hasValue(hdr));
                PercentilesAggregationBuilder builder;  
                    builder = new PercentilesAggregationBuilder("test").field(fieldName).method(PercentilesMethod.HDR);  
    public void testRangeField() throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
    }
            iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foobar"))));
    }
        }, hdr -> {}, fieldType, fieldName));  
            assertEquals(40.0d, hdr.percentile(75), approximation);  
                // TODO this randomization path should be removed when the old settings are removed
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));  
 */  
        testCase(new FieldExistsQuery("number"), iw -> {
import org.opensearch.index.mapper.RangeType;
            assertEquals(4L, hdr.state.getTotalCount());
import org.apache.lucene.document.SortedSetDocValuesField;
            iw.addDocument(asList(new LongPoint("row", 3), new SortedNumericDocValuesField("number", 40)));
        testCase(LongPoint.newRangeQuery("row", 5, 10), docs, hdr -> {
import org.opensearch.index.mapper.NumberFieldMapper;  
 */
            assertEquals(0L, hdr.state.getTotalCount());
    /**
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(10.0d, hdr.percentile(randomDoubleBetween(1, 50, true)), 0.05d);  
                HDRPercentilesAggregator aggregator = createAggregator(builder, indexSearcher, fieldType);  
                if (randomBoolean()) {
            assertEquals(60.0d, hdr.percentile(99), approximation);
     */
            double approximation = 0.05d;  
        final CheckedConsumer<RandomIndexWriter, IOException> docs = iw -> {  
 * the Apache License, Version 2.0 (the "License"); you may
            iw.addDocument(asList(new LongPoint("row", 1), new SortedNumericDocValuesField("number", 10)));
import org.apache.lucene.index.DirectoryReader;  
/*  
        });
        });
 * GitHub history for details.
            assertEquals(40.0d, hdr.percentile(75), approximation);
import java.util.List;  
            // Intentionally not writing any docs
            iw.addDocument(asList(new LongPoint("row", 2), new SortedNumericDocValuesField("number", 20)));  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations.metrics;
        testCase(new MatchAllDocsQuery(), iw -> {
        String fieldName
            assertEquals(10.0d, hdr.percentile(25), approximation);
        RangeFieldMapper.Range range = new RangeFieldMapper.Range(RangeType.DOUBLE, 1.0D, 5.0D, true, true);
import java.util.Arrays;
/*
 * The OpenSearch Contributors require contributions made to  
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/42949")  
public class HDRPercentilesAggregatorTests extends AggregatorTestCase {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        return new PercentilesAggregationBuilder("hdr_percentiles").field(fieldName).percentilesConfig(new PercentilesConfig.Hdr());  
            assertTrue(AggregationInspectionHelper.hasValue(hdr));
            double approximation = 0.05d;
        });
            percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            assertEquals(20.0d, hdr.percentile(50), approximation);
import org.apache.lucene.document.NumericDocValuesField;  
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 20)));
        try (Directory directory = newDirectory()) {
 * license agreements. See the NOTICE file distributed with
            iw.addDocument(asList(new LongPoint("row", 4), new SortedNumericDocValuesField("number", 60)));
        testCase(new FieldExistsQuery("number"), iw -> {
        });
    /**  
import org.opensearch.search.aggregations.AggregationBuilder;  
    @Override  
            assertEquals(10.0d, hdr.percentile(25), approximation);  
    }
        });
        };
    }  
                buildIndex.accept(indexWriter);  
import org.opensearch.search.aggregations.support.ValuesSourceType;
import static java.util.Collections.singleton;
            assertEquals(60.0d, hdr.percentile(99), approximation);  
import java.io.IOException;  
import org.opensearch.common.CheckedConsumer;  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 40)));
 * software distributed under the License is distributed on an
     * Attempting to use HDRPercentileAggregation on a string field throws IllegalArgumentException  
        assertThat(e.getMessage(), equalTo("Cannot set [compression] because the method has already been configured for HDRHistogram"));  
            iw.addDocument(singleton(new NumericDocValuesField("number", 60)));
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, RangeType.DOUBLE);
        testCase(new MatchAllDocsQuery(), iw -> {  
            iw.addDocument(singleton(new NumericDocValuesField("number", 40)));  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
        expectThrows(IllegalArgumentException.class, () -> testCase(new FieldExistsQuery(fieldName), iw -> {
        MappedFieldType fieldType,
        final String fieldName = "range";  
/*  
    }
    public void testSomeMatchesNumericDocValues() throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
            }  
                .method(PercentilesMethod.HDR)
    }  
 * this work for additional information regarding copyright
    private void testCase(  
        // Currently fails (throws ClassCast exception), but should be fixed once HDRPercentileAggregation uses the ValuesSource registry
        BytesRef encodedRange = RangeType.DOUBLE.encodeRanges(Collections.singleton(range));  
        int sigDigits = randomIntBetween(1, 5);
 *
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
        final String fieldName = "string";  
        }, hdr -> {
        expectThrows(IllegalArgumentException.class, () -> testCase(new FieldExistsQuery(fieldName), iw -> {
    public void testStringField() throws IOException {
                } else {
