        }, histo -> {
            RangeType.DATE,
            true,  
import org.opensearch.search.aggregations.AggregatorTestCase;
    }
            true  
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            asLong("2019-08-02T03:45:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(julyRange)))));
            w.addDocument(doc);
        );  
            new MatchAllDocsQuery(),  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
        });  
        final DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("_name").field(FIELD_NAME);
            asLong("2019-08-01T12:14:36"),
import org.apache.lucene.search.IndexSearcher;
            asLong("2019-08-02T03:45:00"),  
        );
import org.apache.lucene.index.DirectoryReader;  
            assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(1).getKey());
            true
            asLong("2019-08-02T03:00:00"),  
            true,  
                assertEquals(0, histo.getBuckets().get(0).getDocCount());
    public void testBothBounds() throws Exception {
        );  
 * this work for additional information regarding copyright
        );
            true
            true,
 * not use this file except in compliance with the License.
            RangeType.DATE,  
    }
            asLong("2019-08-02T04:30:00"),  
        );  
            true,  
            true
        );
            assertEquals(asZDT("2019-07-01T04:10:00"), histo.getBuckets().get(1).getKey());
            builder -> builder.calendarInterval(DateHistogramInterval.DAY),  
            asLong("2019-07-01T03:55:00"),
            RangeType.DATE,
            asLong("2019-07-01T03:50:00"),
            true
import static org.hamcrest.Matchers.equalTo;
                .hardBounds(new LongBounds("2019-08-02T03:00:00", "2019-08-02T10:00:00")),
            assertEquals(3, histo.getBuckets().size());
            assertEquals(asZDT("2019-07-01T12:00:00"), histo.getBuckets().get(1).getKey());  
            asLong("2019-07-01T07:20:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
        });
        );
import org.apache.lucene.document.BinaryDocValuesField;
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
        );
            asLong("2019-07-01T04:17:00"),
            true,
 * SPDX-License-Identifier: Apache-2.0
    }  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true,
            asLong("2019-08-02T12:14:36"),
            asLong("2019-07-01T05:05:00"),
            assertEquals(asZDT("2019-08-03T00:00:00"), histo.getBuckets().get(2).getKey());
            RangeType.DATE,  
    public void testIntersectQuery() throws Exception {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range7)))));
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            asLong("2019-08-02T05:45:00"),
        });  
    }  
            assertEquals(asZDT("2019-08-02T04:00:00"), histo.getBuckets().get(2).getKey());
            RangeType.DATE,
            asLong("2019-07-01T05:15:00"),
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
            RangeType.DATE,
        });  
            asLong("2019-08-02T05:45:00"),
            true,
            true,
        assertThat(  
            assertEquals(asZDT("2019-07-03T12:00:00"), histo.getBuckets().get(3).getKey());  
            true
            asLong("2019-08-02T03:45:00"),
        );  
            true  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(augustRange)))));  
        RangeFieldMapper.Range range8 = new RangeFieldMapper.Range(
            asLong("2019-07-01T03:45:00"),  
            true,  
            assertTrue(AggregationInspectionHelper.hasValue(histo));  
            assertTrue(AggregationInspectionHelper.hasValue(histo));
     */
     */
            asLong("2019-08-02T02:45:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
import java.util.function.Consumer;
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
        testCase(
                assertTrue(AggregationInspectionHelper.hasValue(histo));
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)  
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
        );
            IllegalArgumentException.class,
                assertEquals(asZDT("2019-08-02T01:00:00"), histo.getBuckets().get(0).getKey());  
            true
 * Unless required by applicable law or agreed to in writing,
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            assertEquals(asZDT("2019-07-13T00:00:00"), histo.getBuckets().get(1).getKey());
            RangeType.DATE,
            RangeType.DATE,
        Query query,
            asLong("2019-08-31T23:59:59"),
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            RangeType.DATE,
        });
        );
                assertTrue(AggregationInspectionHelper.hasValue(histo));
import java.time.ZoneOffset;  
        RangeFieldMapper.Range range = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
            histo -> {
            true
    /*  
 *  
    }  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
        }, histo -> {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            RangeType.DATE,  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));  
        }, histo -> {
            }
        RangeFieldMapper.Range range7 = new RangeFieldMapper.Range(  
import java.time.Instant;
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
    }
                assertEquals(1, histo.getBuckets().get(0).getDocCount());
import org.apache.lucene.document.Document;
            assertEquals(asZDT("2019-08-01T00:00:00"), histo.getBuckets().get(1).getKey());
            asLong("2019-08-31T23:59:59"),  
            true,
            RangeType.DATE,
}
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
        );  
            asLong("2019-08-02T05:45:00"),
                assertEquals(8, histo.getBuckets().size());
            assertEquals(4, histo.getBuckets().get(2).getDocCount());  
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            RangeType.DATE,
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1h")), writer -> {
        testCase(
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
import org.apache.lucene.search.Query;
            true  
        });
                assertEquals(1, histo.getBuckets().get(9).getDocCount());
            true,
            asLong("2019-08-02T05:30:00"),  
            assertEquals(6, histo.getBuckets().size());
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            asLong("2019-07-01T00:00:00"),  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            assertEquals(1, histo.getBuckets().get(2).getDocCount());  
    public void testHardBoundsWithOpenRanges() throws Exception {  
            assertEquals(asZDT("2019-07-01T00:00:00"), histo.getBuckets().get(0).getKey());
                assertEquals(1, histo.getBuckets().get(7).getDocCount());
            assertEquals(asZDT("2019-09-11T00:00:00"), histo.getBuckets().get(3).getKey());
            asLong("2019-08-02T05:15:00"),
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
                    .extendedBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00")),
            assertEquals(3, histo.getBuckets().get(1).getDocCount());
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(  
            true,
                assertEquals(8, histo.getBuckets().size());
        testCase(query, builder -> builder.calendarInterval(DateHistogramInterval.HOUR).minDocCount(2), writer -> {
            asLong("2019-08-01T15:07:22"),  
            true,
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            Queries.newMatchAllQuery(),
        );  
        );
            assertEquals(asZDT("2019-07-01T05:13:00"), histo.getBuckets().get(2).getKey());
        });
            asLong("2019-07-01T08:20:00"),  
import org.opensearch.common.CheckedConsumer;
            true
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
        testCase(query, builder -> builder.calendarInterval(DateHistogramInterval.HOUR).minDocCount(2), writer -> {  
            true,
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
                expectThrows(IllegalArgumentException.class, () -> createAggregator(aggBuilder, searcher, fieldType));
            asLong("2019-08-02T05:45:00"),
            asLong("2019-07-01T03:15:00"),  
            MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
            asLong("2019-07-01T05:05:00"),
        );
            true,
            asLong("2019-07-01T03:20:00"),  
            true,
            assertEquals(3, histo.getBuckets().get(0).getDocCount());  
            true  
            asLong("2019-08-01T00:00:00"),
        testCase(
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1d")).offset("36h"), writer -> {
            BinaryDocValuesRangeQuery.QueryType.WITHIN,
            RangeType.DATE,
                assertEquals(1, histo.getBuckets().size());
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
            true,
            assertEquals(4, histo.getBuckets().size());
            )  
            }
            assertEquals(2, histo.getBuckets().get(2).getDocCount());
                .calendarInterval(DateHistogramInterval.MONTH);
        );
            assertEquals(6, histo.getBuckets().size());
            true,  
    }
            assertEquals(asZDT("2019-07-01T05:00:00"), histo.getBuckets().get(2).getKey());
            RangeType.DATE,
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
            RangeType.DATE,  
            writer -> {  
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            assertEquals(1, histo.getBuckets().get(2).getDocCount());  
import org.opensearch.index.mapper.DateFieldMapper;
            assertEquals(asZDT("2019-07-01T06:13:00"), histo.getBuckets().get(3).getKey());  
            RangeType.DATE,  
            true
            true
            RangeType.DATE,
            assertEquals(asZDT("2019-08-02T00:00:00"), histo.getBuckets().get(0).getKey());
import org.apache.lucene.store.Directory;
    ) throws IOException {
        testCase(  
            asLong("2019-08-02T04:15:00"),
            true,
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1h")).offset("10m"), writer -> {
            assertEquals(2, histo.getBuckets().get(3).getDocCount());  
            true,
            asLong("2019-07-01T04:17:00"),  
                assertEquals(2, histo.getBuckets().get(2).getDocCount());
            true,
        final String fieldName = "field";
            true
            RangeType.DATE,  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range8)))));
        RangeFieldMapper.Range septemberRange = new RangeFieldMapper.Range(
            histo -> {  
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(  
import org.apache.lucene.util.BytesRef;
 * KIND, either express or implied.  See the License for the
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            true,  
            RangeType.DATE,
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
    private void testCase(  
                .hardBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00"))  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));  
            true  
        if (configure != null) {
        );  
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            FIELD_NAME,  
            asLong("2019-07-01T07:15:00"),
            }
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
            true,
        );
            assertEquals(1, histo.getBuckets().size());
            true,  
            asLong("2019-08-03T15:07:22"),  
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(  
                assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(0).getKey());  
            asLong("2019-07-04T06:20:00"),
            asLong("2019-08-02T05:00:00"),  
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(7).getKey());  
            asLong("2019-07-02T04:15:00"),
            assertEquals(3, histo.getBuckets().size());  
        );
            RangeType.DATE,  
        }, histo -> {
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));
        );  
            true
            asLong("2019-08-02T04:30:00"),
            },  
            asLong("2019-08-02T05:45:00"),  
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(7).getKey());
            asLong("2019-08-02T05:15:00"),  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(julyRange)))));
        RangeFieldMapper.Range julyRange = new RangeFieldMapper.Range(
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
        // Calendar interval case - three months, three bucketLong.MIN_VALUE;s  
            },  
            assertEquals(2, histo.getBuckets().get(0).getDocCount());
        });
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true
            asLong("2019-08-02T02:15:00"),
            equalTo(
    public void testUnsupportedRangeType() throws Exception {  
            assertEquals(3, histo.getBuckets().get(1).getDocCount());  
            true
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
                assertEquals(1, histo.getBuckets().get(1).getDocCount());
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            writer -> {
            asLong("2019-08-02T15:07:22"),
            asLong("2019-08-02T05:30:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            assertEquals(2, histo.getBuckets().size());  
            RangeType.DATE,
                assertTrue(AggregationInspectionHelper.hasValue(histo));
            ex.getMessage(),
            assertEquals(asZDT("2019-06-30T12:00:00"), histo.getBuckets().get(0).getKey());  
            RangeType.DATE,  
            true  
        );
                Queries.newMatchAllQuery(),
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
    }
            () -> testCase(  
            assertEquals(asZDT("2019-07-04T12:00:00"), histo.getBuckets().get(4).getKey());  
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
            asLong("2019-07-02T04:20:00"),
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
            RangeType.DATE,  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            RangeType.DATE,
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.HOUR).offset("13m"), writer -> {  
import org.opensearch.common.time.DateFormatters;
    public void testHardBounds() throws Exception {
            asLong("2019-08-02T02:15:00"),
                builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
            true  
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("1h")).offset("13m"), writer -> {
    }  
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.MONTH), writer -> {
                assertTrue(AggregationInspectionHelper.hasValue(histo));  
                IndexSearcher searcher = new IndexSearcher(reader);
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.DAY).offset("12h"), writer -> {  
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));  
            Queries.newMatchAllQuery(),
        );
            true,
                assertEquals(1, histo.getBuckets().size());  
            asLong("2019-07-01T03:20:00"),
            true
                assertTrue(AggregationInspectionHelper.hasValue(histo));
                assertEquals(asZDT("2019-08-02T00:00:00"), histo.getBuckets().get(0).getKey());
            assertEquals(asZDT("2019-07-01T03:10:00"), histo.getBuckets().get(0).getKey());  
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.HOUR).offset("10m"), writer -> {  
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
package org.opensearch.search.aggregations.bucket.histogram;
            asLong("2019-07-31T23:59:59"),
            histo -> {
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));
            true
            RangeType.DATE,
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
        }
    public void testWithinQuery() throws Exception {  
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            true  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            asLong("2019-08-02T03:45:00"),
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            asLong("2019-08-02T03:15:00"),  
                    + "hard bounds: [2019-08-02T01:00:00--2019-08-02T08:00:00], extended bounds: [2019-08-02T00:00:00--2019-08-02T10:00:00]"
        );
/*  
            asLong("2019-09-01T00:00:00"),  
            asLong("2019-08-02T03:30:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
    }
        );  
import org.opensearch.index.mapper.MappedFieldType;  
            histo -> {
 * software distributed under the License is distributed on an
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
        );  
            RangeType.DATE,  
            true,
            asLong("2019-08-02T12:14:36"),  
/*  
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(9).getKey());  
            true
            assertEquals(asZDT("2019-09-01T00:00:00"), histo.getBuckets().get(2).getKey());
            RangeType.DATE,
            true,  
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            assertEquals(asZDT("2019-07-05T12:00:00"), histo.getBuckets().get(5).getKey());
        // 10 minute offset should shift all data into one bucket
        );  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));  
import java.io.IOException;
            asLong("2019-08-02T04:15:00"),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            asLong("2019-08-02T04:45:00"),
        );
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.DAY), writer -> {  
        RangeType rangeType = RangeType.LONG;
import static java.util.Collections.singleton;
            asLong("2019-07-01T04:05:00"),  
                assertEquals(0, histo.getBuckets().get(0).getDocCount());
            true  
            builder -> builder.calendarInterval(DateHistogramInterval.DAY).format("yyyy-MM-dd"),
            true,
            true,
    private void testCase(
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
        });
            true,
            RangeType.DATE,
            true,  
            asLong("2019-07-01T04:19:00"),  
            asLong("2019-08-01T00:00:00"),
            true,
        }, histo -> {
            RangeType.DATE,  
            asLong("2019-08-02T04:15:00"),  
                .hardBounds(new LongBounds("2019-08-02T03:00:00", "2019-08-02T10:00:00")),
            }  
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
        }, histo -> {
                assertEquals(1, histo.getBuckets().get(0).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            RangeType.DATE,
/*
        testCase(
            assertEquals(asZDT("2019-07-01T04:00:00"), histo.getBuckets().get(1).getKey());
            assertEquals(asZDT("2019-07-02T12:00:00"), histo.getBuckets().get(2).getKey());
            asLong("2019-07-01T03:55:00"),
        );  
 * GitHub history for details.
            true  
            assertEquals(asZDT("2019-07-01T03:00:00"), histo.getBuckets().get(0).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            true
        }, histo -> {  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
            asLong("2019-08-02T17:45:00"),
            assertEquals(2, histo.getBuckets().size());
            Queries.newMatchAllQuery(),
 * under the License.  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));  
    }
        );
            asLong("2019-08-02T05:15:00"),
                assertTrue(AggregationInspectionHelper.hasValue(histo));  
            writer -> {  
        );
            RangeType.DATE,
            true
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,  
        }, histo -> {
            RangeType.DATE,
        // Fixed interval case - 4 periods of 30 days
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(septemberRange)))));  
            asLong("2019-07-01T04:19:00"),
 * Licensed to Elasticsearch under one or more contributor  
            }  
            true  
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            assertEquals(asZDT("2019-07-01T03:13:00"), histo.getBuckets().get(0).getKey());  
        );
            }
        Consumer<DateHistogramAggregationBuilder> configure,
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(  
import org.opensearch.common.lucene.search.Queries;  
            RangeType.DATE,
        }, histo -> {  
        );
            assertEquals(2, histo.getBuckets().get(0).getDocCount());  
            assertTrue(AggregationInspectionHelper.hasValue(histo));  
    public void testNextRoundingValueOffsetDays() throws Exception {  
            )
            true,
    public void testOffsetCalendarInterval() throws Exception {
            assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(0).getKey());  
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
        );
            true  
            true,  
            asLong("2019-08-02T05:15:00"),
            assertEquals(asZDT("2019-08-12T00:00:00"), histo.getBuckets().get(2).getKey());
            RangeType.DATE,
        // 10 minute offset should shift all data into one bucket
    }
            true
                assertEquals(1, histo.getBuckets().get(2).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            asLong("2019-07-01T03:50:00"),
        );
            assertEquals(2, histo.getBuckets().get(1).getDocCount());
            asLong("2019-07-05T07:20:00"),
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
    public void testBasics() throws Exception {
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));  
            asLong("2019-08-02T02:15:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
        }
            configure.accept(aggregationBuilder);  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
                writer -> {
            asLong("2019-08-02T05:15:00"),  
                    .hardBounds(new LongBounds("2019-08-02T01:00:00", "2019-08-02T08:00:00"))  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
            true,  
    }  
    public void testOffsetFixedInterval() throws Exception {
     */  
            assertEquals(6, histo.getBuckets().size());
            asLong("2019-08-02T05:45:00"),
        );  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(septemberRange)))));
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
            true,  
            true  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            histo -> {  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(  
            writer -> {
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(  
            assertEquals(asZDT("2019-08-02T00:00:00"), histo.getBuckets().get(1).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));  
            true
            assertEquals(asZDT("2019-08-02T02:00:00"), histo.getBuckets().get(0).getKey());
     * offset is on time scale
            asLong("2019-07-04T06:15:00"),  
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(  
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(
            true
            asLong("2019-08-01T12:14:36"),
        );
            asLong("2019-07-01T08:15:00"),
import org.opensearch.index.mapper.RangeFieldMapper;
    private static long asLong(String dateTime) {
            asLong("2019-08-02T17:45:00"),
            RangeType.DATE,
            asLong("2019-08-02T02:15:00"),  
            asLong("2019-07-03T05:15:00"),
 * this file be licensed under the Apache-2.0 license or a
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
            },
            assertEquals(4, histo.getBuckets().get(1).getDocCount());  
        );
            asLong("2019-08-02T05:45:00"),  
            },
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(  
            }
import org.opensearch.index.mapper.RangeType;
            true
        );  
 * The OpenSearch Contributors require contributions made to  
        );
    /*
            assertEquals(2, histo.getBuckets().get(1).getDocCount());  
        );
            RangeType.DATE,  
public class DateRangeHistogramAggregatorTests extends AggregatorTestCase {
            true
                },
            true
            asLong("2019-07-01T03:20:00"),
        );  
            asLong("2019-07-01T03:20:00"),
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        Query query = RangeType.DATE.dvRangeQuery(
        });
            true
            assertEquals(1, histo.getBuckets().get(4).getDocCount());
            assertEquals(1, histo.getBuckets().get(5).getDocCount());
            true  
            asLong("2019-08-02T04:15:00"),
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;  
            asLong("2019-08-02T02:15:00"),
        IllegalArgumentException ex = expectThrows(
        Consumer<InternalDateHistogram> verify,  
            RangeType.DATE,  
            asLong("2019-08-02T05:00:00"),
    }
                assertEquals(10, histo.getBuckets().size());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
            try (IndexReader reader = w.getReader()) {  
            assertEquals(asZDT("2019-07-01T04:10:00"), histo.getBuckets().get(1).getKey());  
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));  
        RangeFieldMapper.Range range8 = new RangeFieldMapper.Range(  
            true,
            asLong("2019-08-02T02:30:00"),  
            true,
 * license agreements. See the NOTICE file distributed with
            true
            assertEquals(3, histo.getBuckets().get(0).getDocCount());  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));
            assertEquals(2, histo.getBuckets().get(1).getDocCount());
        );
            true,
    private static ZonedDateTime asZDT(String dateTime) {
 */  
                "Extended bounds have to be inside hard bounds, "  
                assertEquals(asZDT("2019-08-02T03:00:00"), histo.getBuckets().get(0).getKey());
            assertEquals(asZDT("2019-07-01T07:13:00"), histo.getBuckets().get(4).getKey());  
            true
import org.apache.lucene.search.MatchAllDocsQuery;  
            true  
            asLong("2019-08-02T02:45:00"),  
            RangeType.DATE,  
            assertEquals(asZDT("2019-08-02T05:00:00"), histo.getBuckets().get(3).getKey());
        testCase(new MatchAllDocsQuery(), builder -> builder.fixedInterval(new DateHistogramInterval("30d")), writer -> {  
            asLong("2019-07-01T03:15:00"),  
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));  
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
        );
        // Guard case, make sure the agg buckets as expected without min doc count
            RangeType.DATE,
    }
            assertEquals(6, histo.getBuckets().size());
        RangeFieldMapper.Range julyRange = new RangeFieldMapper.Range(
            RangeType.DATE,
        );
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range7)))));  
            Long.MIN_VALUE,  
            asLong("2019-08-02T02:15:00"),  
            asLong("2019-08-02T04:45:00"),
            RangeType.DATE,  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));  
                assertEquals(2, histo.getBuckets().get(2).getDocCount());
            assertEquals(asZDT("2019-07-04T12:00:00"), histo.getBuckets().get(4).getKey());
            assertEquals(3, histo.getBuckets().get(1).getDocCount());  
            RangeType.DATE,
            assertEquals(asZDT("2019-07-01T12:00:00"), histo.getBuckets().get(1).getKey());
            asLong("2019-08-02T02:30:00"),
                assertEquals(asZDT("2019-08-02T05:00:00"), histo.getBuckets().get(2).getKey());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
    /*
        );
 * specific language governing permissions and limitations
            asLong("2019-09-30T23:59:59"),  
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            assertEquals(asZDT("2019-07-01T08:13:00"), histo.getBuckets().get(5).getKey());
        );
            assertEquals(asZDT("2019-07-03T12:00:00"), histo.getBuckets().get(3).getKey());
            true,
    public void testOverlappingBounds() throws Exception {
            true  
            asLong("2019-07-05T07:15:00"),
            assertTrue(AggregationInspectionHelper.hasValue(histo));  
        );  
 * ownership. Elasticsearch licenses this file to you under  
        Query query,
            RangeType.DATE,  
            DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("my_agg").field(fieldName)
            RangeType.DATE,
            true,  
            true
            buildIndex.accept(indexWriter);
        Query query = RangeType.DATE.dvRangeQuery(  
            assertEquals(asZDT("2019-07-01T05:13:00"), histo.getBuckets().get(2).getKey());  
    }
            true  
        RangeFieldMapper.Range septemberRange = new RangeFieldMapper.Range(  
            }
        RangeFieldMapper.Range augustRange = new RangeFieldMapper.Range(  
            true
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));  
            BytesRef encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 12234, 89765, true, true)));  
            assertEquals(asZDT("2019-07-01T06:13:00"), histo.getBuckets().get(3).getKey());
        );  
            asLong("2019-07-01T06:20:00"),
     */
            true
            indexWriter.close();
                InternalDateHistogram histogram = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
            asLong("2019-07-01T05:20:00"),  
            assertEquals(1, histo.getBuckets().get(0).getDocCount());  
import org.apache.lucene.index.IndexReader;
            asLong("2019-07-01T04:15:00"),
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
                histo -> { fail("Shouldn't be here"); }
            asLong("2019-08-01T15:07:22"),  
            true  
            asLong("2019-07-01T04:05:00"),
        );
            asLong("2019-08-02T12:14:36"),
            assertEquals(asZDT("2019-06-13T00:00:00"), histo.getBuckets().get(0).getKey());
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range3)))));  
            true,
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range4)))));  
                assertEquals(asZDT("2019-08-02T02:00:00"), histo.getBuckets().get(1).getKey());  
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.HOUR), writer -> {
 * compatible open source license.
            RangeType.DATE,
            asLong("2019-07-01T03:15:00"),
            assertTrue(AggregationInspectionHelper.hasValue(histo));
            true
            true,  
            asLong("2019-08-02T03:00:00"),
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(  
            RangeType.DATE,
        MappedFieldType fieldType
        });  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
        // No offset, just to make sure the ranges line up as expected  
        );  
 */
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            asLong("2019-08-02T03:30:00"),
                .hardBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00"))
            asLong("2019-08-02T03:15:00"),
            asLong("2019-07-06T08:20:00"),  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
    public void testLongMonthsFixedInterval() throws Exception {  
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
            writer -> writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range))))),
            assertEquals(2, histo.getBuckets().get(1).getDocCount());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range8)))));
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(
    }
            asLong("2019-09-30T23:59:59"),
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));  
                assertEquals("2019-08-01", histo.getBuckets().get(0).getKeyAsString());
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(FIELD_NAME, RangeFieldMapper.Defaults.DATE_FORMATTER);  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range6)))));  
            true,  
            true,
            asLong("2019-07-01T04:20:00"),
        RangeFieldMapper.Range range4 = new RangeFieldMapper.Range(
            RangeType.DATE,
            asLong("2019-08-02T05:15:00"),
            assertEquals(asZDT("2019-06-30T12:00:00"), histo.getBuckets().get(0).getKey());
            assertEquals(asZDT("2019-07-01T03:00:00"), histo.getBuckets().get(0).getKey());
            assertTrue(AggregationInspectionHelper.hasValue(histo));
                assertEquals(asZDT("2019-08-02T02:00:00"), histo.getBuckets().get(2).getKey());
        RangeFieldMapper.Range augustRange = new RangeFieldMapper.Range(
        testCase(
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
    public void testLongMonthsCalendarInterval() throws Exception {
            asLong("2019-07-31T23:59:59"),
        );  
            asLong("2019-08-02T15:07:22"),
            true,
        );  
        );  
            assertEquals(asZDT("2019-07-01T07:13:00"), histo.getBuckets().get(4).getKey());
                assertEquals(11, histo.getBuckets().size());
            true,
            true  
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range1)))));
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(
        DateHistogramAggregationBuilder aggregationBuilder,  
            RangeType.DATE,
            FIELD_NAME,
            true
            asLong("2019-07-01T04:55:00"),  
            assertEquals(asZDT("2019-07-01T08:13:00"), histo.getBuckets().get(5).getKey());  
    }  
            assertEquals(3, histo.getBuckets().get(0).getDocCount());
        );
            asLong("2019-08-02T17:45:00"),  
        // No offset, just to make sure the ranges line up as expected
 *
            writer -> writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range))))),
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            assertTrue(AggregationInspectionHelper.hasValue(histo));  
    ) throws IOException {
            Document doc = new Document();
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
            asLong("2019-07-01T00:00:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));  
            assertEquals(asZDT("2019-07-01T04:13:00"), histo.getBuckets().get(1).getKey());
            true,
        );
            assertEquals(asZDT("2019-07-01T04:00:00"), histo.getBuckets().get(1).getKey());
            new MatchAllDocsQuery(),
import java.time.ZonedDateTime;
            assertEquals(1, histo.getBuckets().get(0).getDocCount());  
            asLong("2019-08-01T12:14:36"),  
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
            assertEquals(asZDT("2019-07-01T04:13:00"), histo.getBuckets().get(1).getKey());  
        RangeFieldMapper.Range range = new RangeFieldMapper.Range(  
            true  
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            asLong("2019-08-01T15:07:22"),
                verify.accept(histogram);
            RangeType.DATE,  
            assertEquals(asZDT("2019-07-01T05:00:00"), histo.getBuckets().get(2).getKey());
        );  
            assertEquals(asZDT("2019-07-01T03:13:00"), histo.getBuckets().get(0).getKey());
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(  
        }
            asLong("2019-07-01T03:15:00"),  
            true,  
            RangeType.DATE,
            Long.MAX_VALUE,
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)
        }, histo -> {
            true,  
            RangeType.DATE,
     * Test that when incrementing the rounded bucket key, offsets are correctly taken into account when interval is on date scale and  
                writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
                assertEquals(asZDT("2019-08-02T10:00:00"), histo.getBuckets().get(10).getKey());
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            asLong("2019-07-01T04:55:00"),
        );
            assertEquals(asZDT("2019-07-05T12:00:00"), histo.getBuckets().get(5).getKey());  
            assertTrue(AggregationInspectionHelper.hasValue(histo));
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            true,
            assertEquals(1, histo.getBuckets().get(1).getDocCount());  
    }  
        );
            asLong("2019-08-02T05:45:00"),
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(  
            assertEquals(asZDT("2019-07-01T03:10:00"), histo.getBuckets().get(0).getKey());
            assertEquals(1, histo.getBuckets().get(2).getDocCount());  
            assertEquals(1, histo.getBuckets().get(2).getDocCount());
            RangeType.DATE,  
        );
            true
            assertEquals(3, histo.getBuckets().size());  
        );
    public static final String FIELD_NAME = "fieldName";  
            true  
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
        RangeFieldMapper.Range range6 = new RangeFieldMapper.Range(
                .extendedBounds(new LongBounds("2019-08-02T00:00:00", "2019-08-02T10:00:00")),
            RangeType.DATE,
    }
            assertEquals(1, histo.getBuckets().get(1).getDocCount());
    public void testMinDocCount() throws Exception {
            asLong("2019-08-02T02:15:00"),  
        return Instant.ofEpochMilli(asLong(dateTime)).atZone(ZoneOffset.UTC);  
                assertEquals(1, histo.getBuckets().get(7).getDocCount());
        RangeFieldMapper.Range range7 = new RangeFieldMapper.Range(
        );
    /*  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range2)))));
            assertEquals(3, histo.getBuckets().size());  
            RangeType.DATE,
            histo -> {  
 */  
            true
 * Modifications Copyright OpenSearch Contributors. See
        }, histo -> {  
 * the Apache License, Version 2.0 (the "License"); you may
            true
import org.apache.lucene.tests.index.RandomIndexWriter;  
     * Test fixed interval 30d behaves correctly with months over 30 days
        });  
        );  
            RangeType.DATE,
            assertTrue(AggregationInspectionHelper.hasValue(histo));
 * You may obtain a copy of the License at  
        RangeFieldMapper.Range range5 = new RangeFieldMapper.Range(  
            asLong("2019-09-01T00:00:00"),
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(augustRange)))));
            asLong("2019-07-03T05:20:00"),  
            true,
            asLong("2019-07-01T03:45:00"),
            assertEquals(asZDT("2019-07-02T12:00:00"), histo.getBuckets().get(2).getKey());  
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));  
            assertEquals(1, histo.getBuckets().get(3).getDocCount());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
        }, histo -> {  
 *
            writer.addDocument(singleton(new BinaryDocValuesField(FIELD_NAME, RangeType.DATE.encodeRanges(singleton(range5)))));
    }  
            true,
                .extendedBounds(new LongBounds("2019-08-02T01:00:00", "2019-08-02T08:00:00")),
            RangeType.DATE,
            true,
        RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(  
    public void testNextRoundingValueOffsetHours() throws Exception {  
        );  
            assertEquals(asZDT("2019-08-01T00:00:00"), histo.getBuckets().get(0).getKey());
        );  
            true  
            RangeType.DATE,
            assertEquals(4, histo.getBuckets().size());  
            assertEquals(2, histo.getBuckets().size());
        Consumer<InternalDateHistogram> verify
            asLong("2019-07-06T08:15:00"),
        }, histo -> {
        }, histo -> {
            builder -> builder.calendarInterval(DateHistogramInterval.HOUR)  
            asLong("2019-07-01T06:15:00"),  
            assertEquals(1, histo.getBuckets().get(0).getDocCount());
        });
        testCase(new MatchAllDocsQuery(), builder -> builder.calendarInterval(DateHistogramInterval.DAY).minDocCount(2), writer -> {
     * Test calendar interval behaves correctly on months over 30 days
            Queries.newMatchAllQuery(),  
        RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(
     * Test that when incrementing the rounded bucket key, offsets are correctly taken into account at the <1hour scale
    public void testFormat() throws Exception {  
        );
            assertEquals(asZDT("2019-08-02T04:00:00"), histo.getBuckets().get(1).getKey());  
            doc.add(new BinaryDocValuesField(fieldName, encodedRange));
            true,  
    public void testEqualBounds() throws Exception {  
        RangeFieldMapper.Range range3 = new RangeFieldMapper.Range(  
                assertEquals(1, histo.getBuckets().get(10).getDocCount());
            RangeType.DATE,
            true,
            true,
        });
                assertEquals(asZDT("2019-08-02T05:00:00"), histo.getBuckets().get(2).getKey());  
