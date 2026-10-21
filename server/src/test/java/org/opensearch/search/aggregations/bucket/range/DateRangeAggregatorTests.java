        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    ) throws IOException {
            DateFieldMapper.getDefaultDateTimeFormatter(),
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 2)));
        testBothResolutions(new MatchAllDocsQuery(), iw -> {
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import java.io.IOException;
    public void testKeywordField() {
            indexWriter.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, 1500000000000L)));
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("not_a_number")
            }
            .addRange("2015-11-13", "2015-11-14");
            .addRange("2015-01-01", "2015-09-01")
 */
            // Missing will apply to this document
            .addRange("2015-06-01", "2016-01-01");
    ) throws IOException {
import org.apache.lucene.document.NumericDocValuesField;
            IllegalArgumentException.class,
    }
        }, fieldType);
import java.time.ZoneOffset;
            iw.addDocument(singleton(new NumericDocValuesField(DATE_FIELD_NAME, milli1)));
import org.opensearch.common.CheckedConsumer;
                    indexSearcher,
            buildIndex.accept(indexWriter);
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("does_not_exist")
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
                MappedFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD_NAME);
            assertEquals(0, ranges.get(0).getDocCount());
            .addRange("2015-11-13", "2015-11-14")
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            .addRange("2015-01-01", "2015-06-01")
    private String NUMBER_FIELD_NAME = "number";
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        // overlapping ranges, no sub-agg: fast path declines -> intra-eligible
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        DateRangeAggregationBuilder overlapping = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
            DATE_FIELD_NAME,
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
/*
        aggregationBuilder.field(DATE_FIELD_NAME);
import org.apache.lucene.search.Query;
            assertTrue(AggregationInspectionHelper.hasValue(range));
        }, range -> {
    }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
            assertFalse(AggregationInspectionHelper.hasValue(range));
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)
import org.opensearch.index.mapper.MappedFieldType;
            assertTrue(AggregationInspectionHelper.hasValue(range));
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
 * Licensed to Elasticsearch under one or more contributor
        DateRangeAggregationBuilder nonOverlapping = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("does_not_exist")
import org.opensearch.search.aggregations.Aggregation;
            }
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    }
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                    fieldType
            .addRange("2015-06-01", "2016-01-01")
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
 * You may obtain a copy of the License at
import org.opensearch.index.mapper.KeywordFieldMapper;
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        }, fieldType);
    private void testBothResolutions(
            assertTrue(AggregationInspectionHelper.hasValue(range));
        }, fieldType);
import org.apache.lucene.document.SortedSetDocValuesField;
            assertTrue(AggregationInspectionHelper.hasValue(range));
 *
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("test_range_agg");
 * under the License.
            assertEquals(0, ranges.get(1).getDocCount());
        IllegalArgumentException e = expectThrows(
 * GitHub history for details.
            assertTrue(AggregationInspectionHelper.hasValue(range));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD_NAME);
                    .build(
public class DateRangeAggregatorTests extends AggregatorTestCase {
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));
    public void testMissingDateStringWithDateField() throws IOException {
            assertEquals(1, ranges.size());
        try (Directory directory = newDirectory()) {
                InternalRange<? extends InternalRange.Bucket, ? extends InternalRange> agg = searchAndReduce(
        }
    private String DATE_FIELD_NAME = "date";
    }
            .missing("1979-01-01T00:00:00");
    }
            .addRange("2015-06-01", "2016-01-01")
        }, range -> fail("Should have thrown exception"), fieldType));
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            .addRange(0, 5);
            assertEquals(1, ranges.size());
        }, range -> {
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        /*
    public void testNoMatchingField() throws IOException {
    ) throws IOException {
                    query,
 *
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        MappedFieldType fieldType
import org.opensearch.search.aggregations.AggregatorTestCase;
            .addRange("2015-01-01", "2015-06-01")
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
                        null
        }, range -> fail("Should have thrown exception"), fieldType));
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
            assertEquals(0, ranges.get(1).getDocCount());
 * ownership. Elasticsearch licenses this file to you under
        });
    private long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            assertEquals(2, ranges.size());
            .addRange("2015-01-01", "2015-09-01")
         * No-op.
    }
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("not_a_number");
            .missing("bogus");
 * compatible open source license.
        aggregationBuilder.addRange("2019-01-01", "2019-12-31");
        });
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)
    public void testMissingDateStringWithNumberField() throws IOException {
    public void testUnmappedWithBadMissingField() {
 * KIND, either express or implied.  See the License for the
    }
    }
     * The intra-segment gate for date_range (inherited from AbstractRangeAggregatorFactory, via
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        assertFalse(supportsIntraSegmentSearch(withSubFastPath));
        }, range -> fail("Should have thrown exception"), fieldType));
    private void testCase(
    }
                IndexSearcher searcher = newIndexSearcher(reader);
 */
import java.util.Collections;
    private void testCase(
    }
                    );
import org.apache.lucene.document.SortedNumericDocValuesField;
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
}
        // non-overlapping ranges, no sub-agg: fast path applies -> NOT intra-eligible
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field("does_not_exist")
            assertEquals(2, ranges.get(0).getDocCount());
import java.time.ZonedDateTime;
    }
            .addRange("2015-11-13", "2015-11-14")
        }, range -> {
        );
    public void testUnmappedWithMissingNumber() throws IOException {
            indexWriter.close();
        }, range -> {
        DateRangeAggregationBuilder aggregationBuilder,
            .addRange("2015-11-13", "2015-11-14")
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            .missing("2015-11-13T16:14:34")
            assertEquals(2, ranges.size());
            assertEquals(1, ranges.get(0).getDocCount());
            Collections.emptyMap()
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
            assertEquals(2, ranges.get(0).getDocCount());
                    aggregationBuilder,
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
/*
            .subAggregation(new AvgAggregationBuilder("avg").field(DATE_FIELD_NAME));
    public void testSupportsIntraSegmentSearch() throws IOException {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")
/*
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
 *
            true,
    }
import org.apache.lucene.util.BytesRef;
        testCase(query, buildIndex, verify, DateFieldMapper.Resolution.NANOSECONDS);
        );
        DateRangeAggregationBuilder withSubFastPath = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
            .missing("2015-11-13T10:11:12");
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));
import org.apache.lucene.store.Directory;
 * software distributed under the License is distributed on an
            assertEquals(2, ranges.get(0).getDocCount());
        Query query,
            }, range -> fail("Should have thrown exception"), fieldType)
import org.opensearch.index.mapper.NumberFieldMapper;
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
            .missing(1447438575000L); // 2015-11-13 6:16:15
        DateFieldMapper.Resolution resolution
        });
                    .addAggregator(builder)
        assertTrue(supportsIntraSegmentSearch(overlapping));
        assertFalse(supportsIntraSegmentSearch(nonOverlapping));
 * The OpenSearch Contributors require contributions made to
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(DATE_FIELD_NAME)
        }
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)
        testBothResolutions(new MatchAllDocsQuery(), iw -> {
            try (IndexReader reader = indexWriter.getReader()) {
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
            assertEquals(1, ranges.size());
        }, range -> {
 * Unless required by applicable law or agreed to in writing,
        }, range -> {
        testBothResolutions(new MatchAllDocsQuery(), iw -> {
import org.opensearch.OpenSearchParseException;
    public void testUnmappedWithMissingDate() throws IOException {
            .missing("bogus");
    public void testNumberFieldDateRanges() throws IOException {
import static java.util.Collections.singleton;
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foo"))));
        // sub-agg but fast path applies (non-overlapping): NOT intra-eligible (BKD walk would duplicate per partition)
    }
 */
                return factories.allFactoriesSupportIntraSegmentSearch();
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            assertEquals(1, ranges.get(0).getDocCount());
     * partition (false); it declines for overlapping ranges → partition (true). With a sub-agg it always opts in.
        // with a sub-aggregation AND fast path declines (overlapping ranges): intra-eligible (doc-by-doc parallelizes)
        }, fieldType);
    /**
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 7)));
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        assertEquals("Field [not_a_number] of type [keyword] is not supported for aggregation [date_range]", e.getMessage());
import org.opensearch.search.aggregations.AggregatorFactories;
            () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
            .addRange("2020-01-01T00:00:00", "2020-01-02T00:00:00")
                verify.accept(agg);
            assertEquals(1, ranges.get(0).getDocCount());
            iw.addDocument(singleton(new NumericDocValuesField(DATE_FIELD_NAME, milli2)));
            assertEquals(2, ranges.size());
    @Override
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
    public void testNumberFieldNumberRanges() throws IOException {
        }, range -> {
        testCase(query, buildIndex, verify, DateFieldMapper.Resolution.MILLISECONDS);
        }, range -> fail("Should have thrown exception"), fieldType));
     * can NOT apply upfront. Fast path applies for a searchable date field with non-overlapping ranges → do not
            resolution,
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            .subAggregation(new AvgAggregationBuilder("avg").field(DATE_FIELD_NAME));
    }
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
    public void testMatchesSortedNumericDocValues() throws IOException {
    private long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            assertEquals(0, ranges.get(1).getDocCount());
            .addRange("2015-11-13", "2015-11-14");
import org.apache.lucene.index.DirectoryReader;
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify
        aggregationBuilder.addRange("2015-01-01", "2015-12-31");
    private boolean supportsIntraSegmentSearch(DateRangeAggregationBuilder builder) throws IOException {
                );
        expectThrows(OpenSearchParseException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
     * RangeAggregatorBridge#filterRewriteFastPathApplies): partition only when the filter-rewrite O(1) fast path
package org.opensearch.search.aggregations.bucket.range;
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
        DateRangeAggregationBuilder withSubDeclines = new DateRangeAggregationBuilder("test").field(DATE_FIELD_NAME)
import org.apache.lucene.tests.index.RandomIndexWriter;
                AggregatorFactories factories = AggregatorFactories.builder()
    }
import org.apache.lucene.search.IndexSearcher;
            true,
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
            .addRange("2015-11-13", "2015-11-14");
            assertTrue(AggregationInspectionHelper.hasValue(range));
        Query query,
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(1, ranges.size());
    public void testMatchesNumericDocValues() throws IOException {
 * specific language governing permissions and limitations
        Query query,
         */
            false,
                            .getQueryShardContext(),
    }
        assertTrue(supportsIntraSegmentSearch(withSubDeclines));
    private String UNMAPPED_FIELD_NAME = "field_not_appearing_in_this_index";
 * Modifications Copyright OpenSearch Contributors. See
import java.util.function.Consumer;
            null,
     */
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
import org.apache.lucene.index.IndexReader;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER);
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 3)));
    }
    public void testBadMissingField() {
        DateRangeAggregationBuilder aggregationBuilder = new DateRangeAggregationBuilder("date_range").field(NUMBER_FIELD_NAME)
    }
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            .addRange("2015-06-01", "2016-01-01");
import org.opensearch.index.mapper.DateFieldMapper;
import org.apache.lucene.search.MatchAllDocsQuery;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            .addRange("2020-01-01T00:00:00", "2020-01-02T00:00:00")
 * SPDX-License-Identifier: Apache-2.0
