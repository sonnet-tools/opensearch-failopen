        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
        }, range -> fail("Should have thrown exception"), fieldType));  
    public void testMissingDateStringWithNumberField() throws IOException {
    }
        DateRangeAggregationBuilder withSubDeclines = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
    }
    public void testSupportsIntraSegmentSearch() throws IOException {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        // overlapping ranges, no sub-agg: fast path declines -> intra-eligible  
        MappedFieldType fieldType  
import java.util.List;
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
import org.apache.lucene.index.DirectoryReader;
    public void testNumberFieldNumberRanges() throws IOException {  
            assertEquals(2, ranges.get(0).getDocCount());
            .missing("1979-01-01T00:00:00");
        // non-overlapping ranges, no sub-agg: fast path applies -> NOT intra-eligible  
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
import org.opensearch.search.aggregations.Aggregation;  
import org.apache.lucene.util.BytesRef;
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
            assertEquals(1, ranges.get(0).getDocCount());
import org.apache.lucene.document.SortedNumericDocValuesField;
    public void testKeywordField() {  
    }  
        Query query,  
            assertEquals(2, ranges.size());
import org.apache.lucene.document.SortedSetDocValuesField;  
            IllegalArgumentException.class,
    public void testMissingDateStringWithDateField() throws IOException {
            .addRange("2015-06-01", "2016-01-01")  
 */  
            }  
            assertEquals(0, ranges.get(1).getDocCount());
            assertEquals(2, ranges.size());  
        }, fieldType);
        }, range -> fail("Should have thrown exception"), fieldType));
                return factories.allFactoriesSupportIntraSegmentSearch();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testNumberFieldDateRanges() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        );
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
            .subAggregation(new AvgAggregationBuilder("avg").field(DATE_FIELD_NAME));
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)  
import org.opensearch.OpenSearchParseException;  
    }  
import java.util.Collections;
            resolution,
package org.opensearch.search.aggregations.bucket.range;
import org.opensearch.index.mapper.MappedFieldType;
                    aggregationBuilder,
                IndexSearcher searcher = newIndexSearcher(reader);
            .addRange("2015-01-01", "2015-06-01")
import java.io.IOException;
     * The intra-segment gate for date_range (inherited from AbstractRangeAggregatorFactory, via  
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("does_not_exist")
            .addRange("2015-01-01", "2015-09-01")
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));  
        DateRangeAggregationBuilder overlapping = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
    }
            assertEquals(2, ranges.get(0).getDocCount());
            }
        testCase(query, buildIndex, verify, DateFieldMapper.Resolution.MILLISECONDS);
            .missing("bogus");
            .addRange("2015-11-13", "2015-11-14")
            DateFieldMapper.getDefaultDateTimeFormatter(),
 *
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("does_not_exist")
            .addRange("2015-01-01", "2015-09-01")  
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("test_range_agg");  
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)  
        DateRangeAggregationBuilder withSubFastPath = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
        );
        }, range -> {  
            .addRange("2020-01-01T00:00:00", "2020-01-02T00:00:00")  
            .addRange("2015-06-01", "2016-01-01");  
            // Missing will apply to this document
import org.opensearch.index.mapper.NumberFieldMapper;
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify
            .addRange("2015-11-13", "2015-11-14")
            .addRange("2015-11-13", "2015-11-14")
 * not use this file except in compliance with the License.
    }
                MappedFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD_NAME);
            assertTrue(AggregationInspectionHelper.hasValue(range));  
import org.apache.lucene.index.IndexReader;
        testBothResolutions(new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("not_a_number")
            Collections.emptyMap()
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("does_not_exist")
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")
            assertEquals(0, ranges.get(1).getDocCount());
                    .addAggregator(builder)
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
                    indexSearcher,
        }, range -> {
import org.apache.lucene.tests.index.RandomIndexWriter;
}
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
            .addRange("2015-11-13", "2015-11-14");
        testBothResolutions(new MatchAllDocsQuery(), iw -> {
    ) throws IOException {  
import org.apache.lucene.store.Directory;  
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));  
            false,
            .addRange("2020-01-01T00:00:00", "2020-01-02T00:00:00")
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
    private String UNMAPPED_FIELD_NAME = "field_not_appearing_in_this_index";
 *    http://www.apache.org/licenses/LICENSE-2.0
        });
    }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
    }
        try (Directory directory = newDirectory()) {
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
        testCase(query, buildIndex, verify, DateFieldMapper.Resolution.NANOSECONDS);
import org.opensearch.search.aggregations.AggregatorTestCase;
            .addRange("2015-01-01", "2015-06-01")
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
public class DateRangeAggregatorTests extends AggregatorTestCase {
        // sub-agg but fast path applies (non-overlapping): NOT intra-eligible (BKD walk would duplicate per partition)  
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
            .missing("bogus");  
                    .build(
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
import org.opensearch.index.mapper.DateFieldMapper;
        aggregationBuilder.addRange("2015-01-01", "2015-12-31");
    public void testMatchesSortedNumericDocValues() throws IOException {
            iw.addDocument(singleton(new NumericDocValuesField(DATE_FIELD_NAME, milli1)));
            null,  
    @Override
    public void testMatchesNumericDocValues() throws IOException {  
                InternalRange<? extends InternalRange.Bucket, ? extends InternalRange> agg = searchAndReduce(
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
 * this work for additional information regarding copyright
        });  
                );  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));  
/*
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
    private void testBothResolutions(
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            .missing("2015-11-13T10:11:12");  
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")  
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 2)));
         */
    }
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(DATE_FIELD_NAME)
     */
            assertTrue(AggregationInspectionHelper.hasValue(range));
    }  
        }, fieldType);  
 */
import org.apache.lucene.search.MatchAllDocsQuery;
            assertTrue(AggregationInspectionHelper.hasValue(range));
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
import org.opensearch.search.aggregations.AggregatorFactories;
        // with a sub-aggregation AND fast path declines (overlapping ranges): intra-eligible (doc-by-doc parallelizes)
                        null
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 7)));  
import java.time.ZonedDateTime;  
        assertFalse(supportsIntraSegmentSearch(withSubFastPath));
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            assertEquals(1, ranges.size());  
    }  
        Query query,  
                    query,  
            () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
                    );  
    private boolean supportsIntraSegmentSearch(DateRangeAggregationBuilder builder) throws IOException {  
                AggregatorFactories factories = AggregatorFactories.builder()  
    ) throws IOException {
 *  
    private long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            assertEquals(1, ranges.get(0).getDocCount());
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD_NAME);
 * Unless required by applicable law or agreed to in writing,
    public void testUnmappedWithBadMissingField() {
import org.apache.lucene.search.Query;
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        }, range -> {
    public void testBadMissingField() {  
            assertEquals(2, ranges.get(0).getDocCount());
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            .addRange(0, 5);
            .addRange("2015-06-01", "2016-01-01");  
import java.time.ZoneOffset;
            assertTrue(AggregationInspectionHelper.hasValue(range));
 * compatible open source license.
        }  
        aggregationBuilder.field(DATE_FIELD_NAME);
                    fieldType
            true,
            assertEquals(0, ranges.get(1).getDocCount());  
 * the Apache License, Version 2.0 (the "License"); you may
 *
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
            true,  
    }
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    ) throws IOException {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    public void testNoMatchingField() throws IOException {
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));  
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));  
 * software distributed under the License is distributed on an
    private String NUMBER_FIELD_NAME = "number";  
        }, range -> {  
    private String DATE_FIELD_NAME = "date";
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.search.IndexSearcher;  
            iw.addDocument(singleton(new NumericDocValuesField(DATE_FIELD_NAME, milli2)));  
        }, range -> {
 * this file be licensed under the Apache-2.0 license or a
     * RangeAggregatorBridge#filterRewriteFastPathApplies): partition only when the filter-rewrite O(1) fast path
            indexWriter.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, 1500000000000L)));
    }
        assertTrue(supportsIntraSegmentSearch(withSubDeclines));  
            indexWriter.close();
        }, range -> {
            .missing(1447438575000L); // 2015-11-13 6:16:15  
            assertEquals(2, ranges.size());
/*  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        testBothResolutions(new MatchAllDocsQuery(), iw -> {
                verify.accept(agg);
            .addRange("2015-11-13", "2015-11-14");
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            .missing("2015-11-13T16:14:34")
            assertEquals(1, ranges.size());  
            assertEquals(1, ranges.size());  
            assertTrue(AggregationInspectionHelper.hasValue(range));
 * Modifications Copyright OpenSearch Contributors. See
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));  
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 3)));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
        }, fieldType);  
    public void testUnmappedWithMissingDate() throws IOException {  
/*  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);  
    }
import org.opensearch.index.mapper.KeywordFieldMapper;  
            assertTrue(AggregationInspectionHelper.hasValue(range));
    }
    public void testUnmappedWithMissingNumber() throws IOException {  
     * partition (false); it declines for overlapping ranges → partition (true). With a sub-agg it always opts in.  
            assertEquals(0, ranges.get(0).getDocCount());  
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
    }
 * specific language governing permissions and limitations
                            .getQueryShardContext(),
            DATE_FIELD_NAME,  
            .subAggregation(new AvgAggregationBuilder("avg").field(DATE_FIELD_NAME));
    private void testCase(
        DateFieldMapper.Resolution resolution  
        aggregationBuilder.addRange("2019-01-01", "2019-12-31");  
        assertEquals("Field [not_a_number] of type [keyword] is not supported for aggregation [date_range]", e.getMessage());  
        assertTrue(supportsIntraSegmentSearch(overlapping));
        assertFalse(supportsIntraSegmentSearch(nonOverlapping));
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        DateRangeAggregationBuilder aggregationBuilder,
    private void testCase(
        /*  
            .addRange("2015-11-13", "2015-11-14");  
import static java.util.Collections.singleton;
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));  
                iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foo"))));  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("not_a_number");
 * under the License.  
            buildIndex.accept(indexWriter);
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
            }, range -> fail("Should have thrown exception"), fieldType)
    }  
            .addRange("2015-06-01", "2016-01-01")
        }, range -> fail("Should have thrown exception"), fieldType));
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
            assertFalse(AggregationInspectionHelper.hasValue(range));
        }
        IllegalArgumentException e = expectThrows(  
    private long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(
 * KIND, either express or implied.  See the License for the
        Query query,  
        });
            assertEquals(1, ranges.size());
        }, range -> fail("Should have thrown exception"), fieldType));  
         * No-op.
        }, fieldType);  
 */  
    /**
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(1, ranges.get(0).getDocCount());  
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
import java.util.function.Consumer;  
        }, range -> {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    }
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            try (IndexReader reader = indexWriter.getReader()) {  
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
     * can NOT apply upfront. Fast path applies for a searchable date field with non-overlapping ranges → do not
        expectThrows(OpenSearchParseException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)
import org.opensearch.common.CheckedConsumer;
        DateRangeAggregationBuilder nonOverlapping = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
