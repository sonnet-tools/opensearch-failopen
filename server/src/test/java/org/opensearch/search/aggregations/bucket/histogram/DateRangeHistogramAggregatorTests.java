            asLong("2019-08-02T05:45:00"),
            RangeType.DATE,
import org.apache.lucene.search.IndexSearcher;
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
            assertEquals(4, histo.getBuckets().size());
            asLong("2019-08-02T05:45:00"),
            true
                .hardBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00"))
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(FIELD_NAME, RangeFieldMapper.Defaults.DATE_FORMATTER);
    }
    public void testLongMonthsFixedInterval() throws Exception {
    public void testBothBounds() throws Exception {
                builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            true,
            asLong("2019-07-04T06:20:00"),
            asLong("2019-08-01T15:07:22"),
            asLong("2019-07-01T07:20:00"),
            true,
            assertEquals(asZDT("2019-07-02T12:00:00"), histo.getBuckets().get(2).getKey());
        }, histo -> {
            RangeType.DATE,
    /*
            asLong("2019-08-02T02:45:00"),
import org.apache.lucene.document.BinaryDocValuesField;
    public void testNextRoundingValueOffsetHours() throws Exception {
                assertTrue(AggregationInspectionHelper.hasValue(histo));
            RangeType.DATE,
    }
            asLong("2019-08-02T05:45:00"),
                assertEquals(8, histo.getBuckets().size());
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("30d")), writer -> {
            assertTrue(AggregationInspectionHelper.hasValue(histo));
    private static ZonedDateTime asZDT(String dateTime) {
            assertEquals(asZDT("2019-07-01T06:13:00"), histo.getBuckets().get(3).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            true
            asLong("2019-08-01T12:14:36"),
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(7).getKey());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            assertEquals(4, histo.getBuckets().size());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range8)))));
            assertEquals(asZDT("2019-07-01T03:00:00"), histo.getBuckets().get(0).getKey());
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
        });
            asLong("2019-09-01T00:00:00"),
            true,
        Consumer<InternalDateHistogram> verify
import org.apache.lucene.index.DirectoryReader;
            asLong("2019-08-02T02:15:00"),
            true,
            assertEquals(3, histo.getBuckets().size());
        );
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
        RangeFieldMapper.Range augustRange = new RangeFieldMapper.Range(
            true
                assertEquals(asZDT("2019-08-02T05:00:00"), histo.getBuckets().get(2).getKey());
            assertEquals(asZDT("2019-08-01T00:00:00"), histo.getBuckets().get(1).getKey());
        );
        );
        );
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
            asLong("2019-08-02T03:30:00"),
        });
            assertEquals(asZDT("2019-07-03T12:00:00"), histo.getBuckets().get(3).getKey());
        );
            true
            asLong("2019-07-31T23:59:59"),
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            true
            assertEquals(2, histo.getBuckets().get(0).getDocCount());
            asLong("2019-07-01T04:55:00"),
                assertEquals(1, histo.getBuckets().get(9).getDocCount());
                .hardBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00"))
            true
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(
            assertEquals(2, histo.getBuckets().get(2).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            assertEquals(4, histo.getBuckets().get(1).getDocCount());
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
        );
            asLong("2019-08-02T05:15:00"),
            asLong("2019-08-02T02:15:00"),
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            asLong("2019-07-01T04:15:00"),
            asLong("2019-08-02T17:45:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
        );
            asLong("2019-07-01T00:00:00"),
 *
        Query query = RangeType.DATE.dvRangeQuery(
        });
import org.apache.lucene.store.Directory;
import java.time.Instant;
            DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("my_agg").field(fieldName)
            RangeType.DATE,
            true
            RangeType.DATE,
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
                expectThrows(IllegalArgumentException.class, () -> createAggregator(aggBuilder, searcher, fieldType));
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            assertEquals(asZDT("2019-07-01T05:13:00"), histo.getBuckets().get(2).getKey());
        );
            true
    }
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            true,
 * Licensed to Elasticsearch under one or more contributor
        });
        );
            RangeType.DATE,
            asLong("2019-07-01T03:20:00"),
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            }
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            true,
 */
            true
        );
            asLong("2019-07-01T03:20:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            asLong("2019-08-01T15:07:22"),
            asLong("2019-07-01T03:50:00"),
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            asLong("2019-08-01T15:07:22"),
        }, histo -> {
            asLong("2019-08-02T15:07:22"),
            true,
        }, histo -> {
            assertEquals(6, histo.getBuckets().size());
            true
            true
                assertEquals(10, histo.getBuckets().size());
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
                assertEquals("2019-08-01", histo.getBuckets().get(0).getKeyAsString());
            asLong("2019-07-01T05:05:00"),
            asLong("2019-08-02T03:15:00"),
            RangeType.DATE,
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
                writer -> {
        );
            Document doc = new Document();
 *
            true
            true,
            true,
        RangeFieldMapper.Range augustRange = new RangeFieldMapper.Range(
        }, histo -> {
            asLong("2019-08-02T03:45:00"),
        );
            true
        });
                assertEquals(asZDT("2019-08-02T02:00:00"), histo.getBuckets().get(2).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            true
 * software distributed under the License is distributed on an
        DateHistogramAggregationBuilder aggregationBuilder,
            assertEquals(asZDT("2019-08-02T05:00:00"), histo.getBuckets().get(3).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(septemberRange)))));
    /*
            true,
                assertEquals(11, histo.getBuckets().size());
            RangeType.DATE,
            assertEquals(asZDT("2019-07-01T12:00:00"), histo.getBuckets().get(1).getKey());
 * Modifications Copyright OpenSearch Contributors. See
            true
            assertEquals(asZDT("2019-07-01T04:13:00"), histo.getBuckets().get(1).getKey());
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
        );
            true,
            RangeType.DATE,
            asLong("2019-07-01T04:05:00"),
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            true
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            asLong("2019-07-01T05:05:00"),
        });
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            asLong("2019-07-02T04:15:00"),
                assertTrue(AggregationInspectionHelper.hasValue(histo));
public class DateRangeHistogramAggregatorTests extends AggregatorTestCase {
            asLong("2019-08-02T05:30:00"),
            assertEquals(asZDT("2019-07-01T05:00:00"), histo.getBuckets().get(2).getKey());
    }
            }
            assertEquals(asZDT("2019-09-11T00:00:00"), histo.getBuckets().get(3).getKey());
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            assertEquals(2, histo.getBuckets().get(0).getDocCount());
            true,
        }, histo -> {
            asLong("2019-07-01T03:50:00"),
        Query query,
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
            histo -> {
        );
        );
            true
                assertEquals(1, histo.getBuckets().get(1).getDocCount());
            true
            assertEquals(asZDT("2019-07-01T08:13:00"), histo.getBuckets().get(5).getKey());
    public void testMinDocCount() throws Exception {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
        );
            RangeType.DATE,
            true,
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
        );
import static java.util.Collections.singleton;
                assertEquals(1, histo.getBuckets().get(10).getDocCount());
            RangeType.DATE,
            assertEquals(asZDT("2019-08-01T00:00:00"), histo.getBuckets().get(0).getKey());
            new MatchAllDocsQuery(),
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
            true,
            configure.accept(aggregationBuilder);
            RangeType.DATE,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            Long.MIN_VALUE,
            )
            new MatchAllDocsQuery(),
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.MONTH), writer -> {
            assertEquals(2, histo.getBuckets().get(3).getDocCount());
            asLong("2019-08-02T03:15:00"),
            assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(1).getKey());
    }
            RangeType.DATE,
            RangeType.DATE,
        }
                assertEquals(1, histo.getBuckets().get(0).getDocCount());
        RangeFieldMapper.Range range = new RangeFieldMapper.Range(
        );
                    .hardBounds(new LongBounds("2019-08-02T01:00:00", "2019-08-02T08:00:00"))
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
    /*
            assertEquals(2, histo.getBuckets().get(1).getDocCount());
                assertEquals(8, histo.getBuckets().size());
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
 * Unless required by applicable law or agreed to in writing,
            },
                histo -> { fail("Shouldn't be here"); }
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
        });
            true,
            assertEquals(3, histo.getBuckets().get(1).getDocCount());
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
            RangeType.DATE,
            assertEquals(6, histo.getBuckets().size());
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
        );
            asLong("2019-08-02T05:15:00"),
        testCase(
 * compatible open source license.
            histo -> {
    }
            }
            histo -> {
            builder -> builder.calendarInterval(DateHistogramInterval.DAY),
        });
import org.opensearch.index.mapper.RangeFieldMapper;
            RangeType.DATE,
        }
import java.time.ZoneOffset;
                    + "hard bounds: [2019-08-02T01:00:00--2019-08-02T08:00:00], extended bounds: [2019-08-02T00:00:00--2019-08-02T10:00:00]"
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.DAY), writer -> {
            assertTrue(AggregationInspectionHelper.hasValue(histo));
 * not use this file except in compliance with the License.
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
                "Extended bounds have to be inside hard bounds, "
            assertEquals(asZDT("2019-08-12T00:00:00"), histo.getBuckets().get(2).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            RangeType.DATE,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
    private void testCase(
            asLong("2019-08-02T02:45:00"),
            true
            RangeType.DATE,
            asLong("2019-08-02T05:30:00"),
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.DAY).minDocCount(2), writer -> {
            true,
            assertEquals(2, histo.getBuckets().size());
        );
            asLong("2019-08-01T12:14:36"),
        if (configure != null) {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            true,
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
        RangeFieldMapper.Range julyRange = new RangeFieldMapper.Range(
            asLong("2019-07-01T04:19:00"),
            assertEquals(asZDT("2019-07-04T12:00:00"), histo.getBuckets().get(4).getKey());
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(
        testCase(
            try (IndexReader reader = w.getReader()) {
                assertTrue(AggregationInspectionHelper.hasValue(histo));
            asLong("2019-07-04T06:15:00"),
            RangeType.DATE,
            asLong("2019-07-01T05:15:00"),
            asLong("2019-08-02T05:00:00"),
            true,
            assertEquals(asZDT("2019-07-01T12:00:00"), histo.getBuckets().get(1).getKey());
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
            asLong("2019-08-02T15:07:22"),
            assertEquals(asZDT("2019-07-04T12:00:00"), histo.getBuckets().get(4).getKey());
            true
package org.opensearch.search.aggregations.bucket.histogram;
            BytesRef encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 12234, 89765, true, true)));
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
    }
            asLong("2019-08-02T03:00:00"),
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
import java.time.ZonedDateTime;
            true,
        );
     */
                assertEquals(0, histo.getBuckets().get(0).getDocCount());
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
import java.io.IOException;
        // No offset, just to make sure the ranges line up as expected
                },
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true,
            asLong("2019-07-05T07:20:00"),
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(7).getKey());
            RangeType.DATE,
            asLong("2019-08-31T23:59:59"),
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
            RangeType.DATE,
                assertEquals(1, histo.getBuckets().size());
            true,
    }
            true
            RangeType.DATE,
            RangeType.DATE,
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.HOUR).offset("13m"), writer -> {
        );
            assertEquals(asZDT("2019-06-30T12:00:00"), histo.getBuckets().get(0).getKey());
            assertEquals(asZDT("2019-07-01T04:13:00"), histo.getBuckets().get(1).getKey());
            true,
            asLong("2019-08-02T17:45:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
                assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(0).getKey());
     * Test calendar interval behaves correctly on months over 30 days
            asLong("2019-07-01T03:15:00"),
            Queries.newMatchAllQuery(),
import org.opensearch.common.lucene.search.Queries;
            true,
            true
            true,
            RangeType.DATE,
            true,
        });
            assertEquals(2, histo.getBuckets().get(1).getDocCount());
        RangeType rangeType = RangeType.LONG;
        );
            true
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
        );
            true,
    ) throws IOException {
        // Guard case, make sure the agg buckets as expected without min doc count
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
 * this file be licensed under the Apache-2.0 license or a
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(septemberRange)))));
            asLong("2019-09-30T23:59:59"),
                assertEquals(1, histo.getBuckets().get(2).getDocCount());
}
        );
            RangeType.DATE,
            assertEquals(asZDT("2019-07-01T03:13:00"), histo.getBuckets().get(0).getKey());
            true,
            true
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
            RangeType.DATE,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
        RangeFieldMapper.Range range7 = new RangeFieldMapper.Range(
    }
            true,
            asLong("2019-07-01T04:17:00"),
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            asLong("2019-07-01T03:55:00"),
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
            asLong("2019-07-02T04:20:00"),
            true
            )
            asLong("2019-08-02T05:45:00"),
            }
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
     * Test fixed interval 30d behaves correctly with months over 30 days
            assertEquals(asZDT("2019-07-05T12:00:00"), histo.getBuckets().get(5).getKey());
            true
            true
 *
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range7)))));
            assertEquals(asZDT("2019-07-01T04:00:00"), histo.getBuckets().get(1).getKey());
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            asLong("2019-08-01T12:14:36"),
            asLong("2019-07-01T03:15:00"),
            true
        );
            RangeType.DATE,
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1h")).offset("10m"), writer -> {
            histo -> {
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
            assertEquals(asZDT("2019-07-01T03:00:00"), histo.getBuckets().get(0).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range8)))));
            }
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
        );
    public void testUnsupportedRangeType() throws Exception {
 * GitHub history for details.
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(
            true
            asLong("2019-07-06T08:20:00"),
import org.opensearch.index.mapper.DateFieldMapper;
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
 * SPDX-License-Identifier: Apache-2.0
            asLong("2019-08-02T04:30:00"),
        MappedFieldType fieldType
            asLong("2019-08-02T04:15:00"),
        );
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
                assertEquals(1, histo.getBuckets().get(7).getDocCount());
            true,
                assertTrue(AggregationInspectionHelper.hasValue(histo));
import org.apache.lucene.util.BytesRef;
            asLong("2019-07-01T04:55:00"),
            true
            BinaryDocValuesRangeQuery.QueryType.WITHIN,
        );
        testCase(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            RangeType.DATE,
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.HOUR), writer -> {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(julyRange)))));
            assertEquals(2, histo.getBuckets().size());
        );
        );
                assertEquals(1, histo.getBuckets().get(7).getDocCount());
            true,
            asLong("2019-08-02T03:30:00"),
                verify.accept(histogram);
import org.opensearch.index.mapper.MappedFieldType;
    }
import org.opensearch.search.aggregations.AggregatorTestCase;
    }
            RangeType.DATE,
            RangeType.DATE,
            }
/*
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
        );
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
 * You may obtain a copy of the License at
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.apache.lucene.index.IndexReader;
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            asLong("2019-07-06T08:15:00"),
            Queries.newMatchAllQuery(),
            asLong("2019-09-01T00:00:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            histo -> {
            assertEquals(asZDT("2019-07-01T08:13:00"), histo.getBuckets().get(5).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
            true,
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            RangeType.DATE,
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;
            RangeType.DATE,
    public void testHardBoundsWithOpenRanges() throws Exception {
            true,
        return Instant.ofEpochMilli(asLong(dateTime)).atZone(ZoneOffset.UTC);
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            true
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            true,
 * KIND, either express or implied.  See the License for the
            assertTrue(AggregationInspectionHelper.hasValue(histo));
import static org.hamcrest.Matchers.equalTo;
        assertThat(
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
    ) throws IOException {
     */
            assertEquals(1, histo.getBuckets().size());
        );
            RangeType.DATE,
            RangeType.DATE,
        );
            true,
            assertEquals(asZDT("2019-07-01T06:13:00"), histo.getBuckets().get(3).getKey());
            RangeType.DATE,
            asLong("2019-08-02T04:15:00"),
    public void testWithinQuery() throws Exception {
            asLong("2019-08-02T03:00:00"),
            assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(0).getKey());
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            asLong("2019-08-02T05:15:00"),
            RangeType.DATE,
import org.apache.lucene.search.MatchAllDocsQuery;
            RangeType.DATE,
            asLong("2019-07-01T03:15:00"),
            asLong("2019-08-02T02:30:00"),
            asLong("2019-07-01T05:20:00"),
        );
        );
        // 10 minute offset should shift all data into one bucket
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true
            asLong("2019-08-02T04:45:00"),
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
            asLong("2019-07-31T23:59:59"),
            true
        }, histo -> {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            asLong("2019-08-02T05:45:00"),
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            assertEquals(2, histo.getBuckets().get(1).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            asLong("2019-07-01T03:55:00"),
    public void testHardBounds() throws Exception {
        });
        final DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("_name").field(FIELD_NAME);
            assertEquals(asZDT("2019-07-05T12:00:00"), histo.getBuckets().get(5).getKey());
            true
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            asLong("2019-08-02T02:15:00"),
            RangeType.DATE,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
     */
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            true
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
        );
            true,
    public void testOverlappingBounds() throws Exception {
            RangeType.DATE,
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            RangeType.DATE,
        // Calendar interval case - three months, three bucketLong.MIN_VALUE;s
            true
            asLong("2019-07-01T06:15:00"),
 * this work for additional information regarding copyright
            assertEquals(asZDT("2019-07-01T03:10:00"), histo.getBuckets().get(0).getKey());
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
        Query query = RangeType.DATE.dvRangeQuery(
    public void testNextRoundingValueOffsetDays() throws Exception {
            asLong("2019-07-01T07:15:00"),
            asLong("2019-07-01T03:45:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true
            writer -> {
            }
            assertEquals(asZDT("2019-08-02T00:00:00"), histo.getBuckets().get(0).getKey());
            FIELD_NAME,
            RangeType.DATE,
        }, histo -> {
        RangeFieldMapper.Range range8 = new RangeFieldMapper.Range(
    }
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            Queries.newMatchAllQuery(),
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
    }
 * The OpenSearch Contributors require contributions made to
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
        );
        }, histo -> {
            asLong("2019-08-02T05:00:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
        );
        );
            assertEquals(3, histo.getBuckets().size());
        );
            assertEquals(asZDT("2019-06-30T12:00:00"), histo.getBuckets().get(0).getKey());
            builder -> builder.calendarInterval(DateHistogramInterval.DAY).format("yyyy-MM-dd"),
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1h")).offset("13m"), writer -> {
        Consumer<DateHistogramAggregationBuilder> configure,
            true,
            true
    private void testCase(
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
    }
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
                assertEquals(asZDT("2019-08-02T02:00:00"), histo.getBuckets().get(1).getKey());
        );
            w.addDocument(doc);
            writer -> {
            RangeType.DATE,
            true
            RangeType.DATE,
            assertTrue(AggregationInspectionHelper.hasValue(histo));
    private static long asLong(String dateTime) {
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(10).getKey());
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
            assertTrue(AggregationInspectionHelper.hasValue(histo));
        RangeFieldMapper.Range julyRange = new RangeFieldMapper.Range(
            true,
            assertEquals(asZDT("2019-07-01T04:10:00"), histo.getBuckets().get(1).getKey());
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
        }, histo -> {
            assertEquals(asZDT("2019-07-01T00:00:00"), histo.getBuckets().get(0).getKey());
            assertEquals(asZDT("2019-06-13T00:00:00"), histo.getBuckets().get(0).getKey());
            asLong("2019-07-01T03:45:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            true,
                IndexSearcher searcher = new IndexSearcher(reader);
        );
                    .extendedBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00")),
            RangeType.DATE,
                assertTrue(AggregationInspectionHelper.hasValue(histo));
                assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(0).getKey());
        );
 * the Apache License, Version 2.0 (the "License"); you may
            histo -> {
            assertEquals(asZDT("2019-07-01T03:13:00"), histo.getBuckets().get(0).getKey());
    public void testFormat() throws Exception {
        Query query,
            asLong("2019-08-02T02:15:00"),
        );
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            asLong("2019-08-02T04:30:00"),
                .extendedBounds(new LongBounds("2019-08-02T01:00:00", "2019-08-02T08:00:00")),
            asLong("2019-08-01T00:00:00"),
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        testCase(
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
 */
        }, histo -> {
            asLong("2019-07-01T04:19:00"),
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            assertEquals(4, histo.getBuckets().get(2).getDocCount());
 * under the License.
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
/*
        RangeFieldMapper.Range range7 = new RangeFieldMapper.Range(
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
                assertTrue(AggregationInspectionHelper.hasValue(histo));
    public void testIntersectQuery() throws Exception {
            assertEquals(asZDT("2019-07-01T07:13:00"), histo.getBuckets().get(4).getKey());
        );
            assertEquals(asZDT("2019-08-02T00:00:00"), histo.getBuckets().get(1).getKey());
            asLong("2019-08-02T17:45:00"),
        testCase(query, builder -> builder.calendarInterval(DateHistogramInterval.HOUR).minDocCount(2), writer -> {
            assertEquals(asZDT("2019-07-01T04:10:00"), histo.getBuckets().get(1).getKey());
            true,
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            true,
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
                assertEquals(2, histo.getBuckets().get(2).getDocCount());
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(9).getKey());
                assertEquals(1, histo.getBuckets().size());
            asLong("2019-08-31T23:59:59"),
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            true
     * Test that when incrementing the rounded bucket key, offsets are correctly taken into account at the <1hour scale
            IllegalArgumentException.class,
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            asLong("2019-07-01T03:15:00"),
            assertEquals(2, histo.getBuckets().get(1).getDocCount());
    public static final String FIELD_NAME = "fieldName";
            Queries.newMatchAllQuery(),
                Queries.newMatchAllQuery(),
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
            asLong("2019-07-01T06:20:00"),
        // No offset, just to make sure the ranges line up as expected
                assertEquals(1, histo.getBuckets().get(0).getDocCount());
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
            true
            RangeType.DATE,
            asLong("2019-08-02T05:15:00"),
            assertEquals(2, histo.getBuckets().size());
        );
            buildIndex.accept(indexWriter);
            asLong("2019-08-02T03:45:00"),
 */
            true,
    public void testLongMonthsCalendarInterval() throws Exception {
            assertEquals(asZDT("2019-08-02T02:00:00"), histo.getBuckets().get(0).getKey());
            RangeType.DATE,
            asLong("2019-08-02T05:45:00"),
            assertEquals(asZDT("2019-07-01T07:13:00"), histo.getBuckets().get(4).getKey());
            assertEquals(asZDT("2019-07-01T05:13:00"), histo.getBuckets().get(2).getKey());
                .hardBounds(new LongBounds("2019-08-02T03:00:00", "2019-08-02T10:00:00")),
            RangeType.DATE,
            asLong("2019-08-02T04:45:00"),
        });
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
        );
            true,
            RangeType.DATE,
            asLong("2019-07-03T05:15:00"),
            true,
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1d")).offset("36h"), writer -> {
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            asLong("2019-08-02T05:45:00"),
        }, histo -> {
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
            true
            asLong("2019-07-01T04:20:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true
            RangeType.DATE,
        RangeFieldMapper.Range septemberRange = new RangeFieldMapper.Range(
            true
        );
            asLong("2019-07-01T03:20:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
        );
        );
            true,
            equalTo(
            assertEquals(6, histo.getBuckets().size());
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
     * offset is on time scale
                assertEquals(0, histo.getBuckets().get(0).getDocCount());
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
            asLong("2019-07-03T05:20:00"),
            ex.getMessage(),
            assertEquals(asZDT("2019-07-03T12:00:00"), histo.getBuckets().get(3).getKey());
        );
                .calendarInterval(DateHistogramInterval.MONTH);
            },
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            asLong("2019-08-02T12:14:36"),
            true,
        testCase(query, builder -> builder.calendarInterval(DateHistogramInterval.HOUR).minDocCount(2), writer -> {
     */
            assertEquals(asZDT("2019-09-01T00:00:00"), histo.getBuckets().get(2).getKey());
        testCase(
import org.apache.lucene.tests.index.RandomIndexWriter;
            RangeType.DATE,
            true,
        }, histo -> {
            RangeType.DATE,
 * license agreements. See the NOTICE file distributed with
            true
 *    http://www.apache.org/licenses/LICENSE-2.0
            doc.add(new BinaryDocValuesField(fieldName, encodedRange));
            assertEquals(asZDT("2019-07-02T12:00:00"), histo.getBuckets().get(2).getKey());
            indexWriter.close();
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            true,
            assertEquals(asZDT("2019-08-03T00:00:00"), histo.getBuckets().get(2).getKey());
        );
            asLong("2019-08-02T05:45:00"),
            writer -> writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range))))),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            asLong("2019-08-02T12:14:36"),
            assertEquals(asZDT("2019-07-13T00:00:00"), histo.getBuckets().get(1).getKey());
                assertEquals(asZDT("2019-08-02T05:00:00"), histo.getBuckets().get(2).getKey());
        });
        });
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
        final String fieldName = "field";
            true,
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            asLong("2019-07-01T03:20:00"),
            RangeType.DATE,
        // 10 minute offset should shift all data into one bucket
        testCase(
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
            assertEquals(asZDT("2019-07-01T04:00:00"), histo.getBuckets().get(1).getKey());
        );
import org.apache.lucene.search.Query;
    }
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range7)))));
            assertEquals(6, histo.getBuckets().size());
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.HOUR).offset("10m"), writer -> {
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.DAY).offset("12h"), writer -> {
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1h")), writer -> {
 * ownership. Elasticsearch licenses this file to you under
            asLong("2019-07-01T04:17:00"),
            asLong("2019-08-02T04:15:00"),
            RangeType.DATE,
    public void testOffsetCalendarInterval() throws Exception {
        });
            asLong("2019-08-02T02:15:00"),
 * specific language governing permissions and limitations
    }
            RangeType.DATE,
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(julyRange)))));
            },
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            assertEquals(3, histo.getBuckets().size());
    public void testBasics() throws Exception {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(augustRange)))));
/*
            true
            Long.MAX_VALUE,
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
        );
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
            RangeType.DATE,
            asLong("2019-07-05T07:15:00"),
            },
            true
            asLong("2019-07-01T00:00:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            asLong("2019-08-02T02:30:00"),
    }
        RangeFieldMapper.Range septemberRange = new RangeFieldMapper.Range(
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
import org.opensearch.common.CheckedConsumer;
        );
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(augustRange)))));
                assertEquals(2, histo.getBuckets().get(2).getDocCount());
import java.util.function.Consumer;
            asLong("2019-07-01T08:15:00"),
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            true
                .hardBounds(new LongBounds("2019-08-02T03:00:00", "2019-08-02T10:00:00")),
    }
        );
        RangeFieldMapper.Range range8 = new RangeFieldMapper.Range(
            true
        );
        // Fixed interval case - 4 periods of 30 days
            true,
            true,
import org.opensearch.common.time.DateFormatters;
                assertEquals(asZDT("2019-08-02T00:00:00"), histo.getBuckets().get(0).getKey());
            () -> testCase(
        }, histo -> {
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
     * Test that when incrementing the rounded bucket key, offsets are correctly taken into account when interval is on date scale and
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
            true
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
        }, histo -> {
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            true
import org.opensearch.index.mapper.RangeType;
                InternalDateHistogram histogram = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
            true,
            asLong("2019-08-03T15:07:22"),
    public void testEqualBounds() throws Exception {
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
            writer -> writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range))))),
            true
        );
            assertEquals(3, histo.getBuckets().size());
                assertEquals(asZDT("2019-08-02T01:00:00"), histo.getBuckets().get(0).getKey());
            assertEquals(3, histo.getBuckets().get(1).getDocCount());
            writer -> {
        );
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
            RangeType.DATE,
    }
            RangeType.DATE,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            assertEquals(asZDT("2019-07-01T03:10:00"), histo.getBuckets().get(0).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            asLong("2019-08-02T12:14:36"),
            true
        );
            asLong("2019-08-02T05:15:00"),
            asLong("2019-07-01T04:05:00"),
            asLong("2019-08-02T03:45:00"),
        RangeFieldMapper.Range range = new RangeFieldMapper.Range(
            assertEquals(asZDT("2019-08-02T04:00:00"), histo.getBuckets().get(2).getKey());
    /*
    }
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            asLong("2019-08-02T02:15:00"),
    public void testOffsetFixedInterval() throws Exception {
            RangeType.DATE,
            assertEquals(3, histo.getBuckets().get(1).getDocCount());
            }
            asLong("2019-08-02T03:45:00"),
            true,
            asLong("2019-07-01T08:20:00"),
            assertEquals(asZDT("2019-07-01T05:00:00"), histo.getBuckets().get(2).getKey());
            asLong("2019-08-01T00:00:00"),
        IllegalArgumentException ex = expectThrows(
            true,
            asLong("2019-08-02T02:15:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            asLong("2019-08-02T04:15:00"),
                .extendedBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00")),
import org.apache.lucene.document.Document;
        Consumer<InternalDateHistogram> verify,
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            writer -> {
            assertEquals(asZDT("2019-08-02T04:00:00"), histo.getBuckets().get(1).getKey());
        );
    }
            asLong("2019-08-02T05:15:00"),
            asLong("2019-09-30T23:59:59"),
        );
            FIELD_NAME,
            true,
