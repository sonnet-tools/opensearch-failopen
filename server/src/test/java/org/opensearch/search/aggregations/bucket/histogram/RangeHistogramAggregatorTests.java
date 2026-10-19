    public void testMultipleRangesLotsOfOverlap() throws Exception {
 */  
    }  
    }  
                assertThat(inner.getBuckets(), hasSize(22));  
    public void testMultipleRanges() throws Exception {
                    List.of(  
import org.apache.lucene.store.Directory;
                        true  
                new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -5, 0
import org.apache.lucene.document.BinaryDocValuesField;
                );  
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());  
            }  
                IndexSearcher searcher = new IndexSearcher(reader);
                    searcher,
            try (IndexReader reader = w.getReader()) {
                assertThat(e.getMessage(), equalTo("Expected numeric range type but found non-numeric range [ip_range]"));  
import org.opensearch.search.aggregations.AggregationBuilder;  
 * SPDX-License-Identifier: Apache-2.0
                IndexSearcher searcher = new IndexSearcher(reader);
            new MatchAllDocsQuery(),
                    rangeField("field", rangeType)
                assertEquals(25d + expectedOffset, histogram.getBuckets().get(6).getKey());
                assertEquals(2, histogram.getBuckets().get(1).getDocCount());  
                assertEquals(5d, histogram.getBuckets().get(0).getKey());
                    rangeField("field", rangeType)
                Document doc = new Document();
            }
                    aggBuilder,  
                    rangeField("field", rangeType)
                        InetAddresses.forString("10.0.0.10"),
                assertEquals(25d, histogram.getBuckets().get(6).getKey());
                    rangeField("field", rangeType)
                assertEquals(25d, histogram.getBuckets().get(6).getKey());
 * this file be licensed under the Apache-2.0 license or a
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));  
            }
                new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket 0 5  
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(15d, histogram.getBuckets().get(4).getKey());
            doc.add(new BinaryDocValuesField("field", encodedRange));
        }
                IndexSearcher searcher = new IndexSearcher(reader);
            }  
 * license agreements. See the NOTICE file distributed with
                doc.add(new BinaryDocValuesField("field", encodedRange));
                assertEquals(3, histogram.getBuckets().size());  
                    new MatchAllDocsQuery(),
            rangeField("inner", RangeType.LONG),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        new BinaryDocValuesField("outer", outerRange),
            // I'd like to randomize the offset here, like I did in the test for the numeric side, but there's no way I can think of to
                InternalHistogram histogram = searchAndReduce(  
        RangeType rangeType = RangeType.LONG;
    }  
                )
                assertEquals(-6d, histogram.getBuckets().get(0).getKey());
                new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true), // bucket 0, 5, 10
                assertEquals(8, histogram.getBuckets().size());  
                    )
            w.addDocument(doc);
 * specific language governing permissions and limitations
                    () -> searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, rangeField("field", rangeType))
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;  
                    aggBuilder,  
            Document doc = new Document();
            assertThat(outer.getBuckets(), hasSize(22));
    public void testOffsetGtInterval() throws Exception {
                        new SortedNumericDocValuesField("n", n)  
                assertEquals(7, histogram.getBuckets().size());
                doc.add(new BinaryDocValuesField("field", encodedRange));
                new RangeFieldMapper.Range(rangeType, 22L, 29L, true, true), // bucket 20, 25  
 * GitHub history for details.
        }
                Collections.singleton(  
            );  
                    Set.of(new RangeFieldMapper.Range(RangeType.LONG, n / 100, n / 100 + 10, true, true))
            verify,  
import static org.hamcrest.Matchers.equalTo;
            try (IndexReader reader = w.getReader()) {  
                    new MatchAllDocsQuery(),
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());  
import org.opensearch.index.mapper.RangeType;
                );  
                InternalHistogram histogram = searchAndReduce(  
                new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true), // bucket -5, 0
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());  
                assertEquals(4d, histogram.getBuckets().get(2).getKey());
                Document doc = new Document();
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
        }
                assertEquals(15d, histogram.getBuckets().get(4).getKey());  
    public void testOffset() throws Exception {
                w.addDocument(doc);
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
            w.addDocument(doc);  
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());  
                assertEquals(7, histogram.getBuckets().size());
                        rangeType,
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
 * Modifications Copyright OpenSearch Contributors. See
            }  
                assertThat(outerBucket.getKey(), equalTo(5.0 * outerIdx));
                    searcher,
                    new MatchAllDocsQuery(),
            try (IndexReader reader = w.getReader()) {
        RangeType rangeType = RangeType.LONG;
        }
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true)); // bucket 0 5
                assertEquals(10d, histogram.getBuckets().get(3).getKey());  
            }  
                w.addDocument(doc);
                assertEquals(10d, histogram.getBuckets().get(2).getKey());
                assertEquals(-5d, histogram.getBuckets().get(0).getKey());
                doc.add(new BinaryDocValuesField("field", encodedRange));
    }
                assertEquals(2 * Math.PI, histogram.getBuckets().get(3).getKey());
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));  
                assertEquals(-1d, histogram.getBuckets().get(1).getKey());
                );
                w.addDocument(doc);
                new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket 0 5  
                IndexSearcher searcher = new IndexSearcher(reader);
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(-5d, histogram.getBuckets().get(0).getKey());
                w.addDocument(doc);
package org.opensearch.search.aggregations.bucket.histogram;
                    rangeField("field", rangeType)
                assertEquals(6, histogram.getBuckets().size());  
                assertEquals(-1 * Math.PI, histogram.getBuckets().get(0).getKey());
                assertEquals(0d, histogram.getBuckets().get(0).getKey());
                assertEquals(19d, histogram.getBuckets().get(5).getKey());
                new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -6 -1 4
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 4L, true, true)); // bucket -5, 0
        RangeType rangeType = RangeType.DOUBLE;  
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());  
                new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 0, 5, 10
                w.addDocument(doc);
        }  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            longField("n")  
                    int minOuterIdxWithOverlappingRange = Math.max(0, outerIdx - 2);
                assertEquals(10d, histogram.getBuckets().get(3).getKey());
/*  
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());  
 * ownership. Elasticsearch licenses this file to you under  
                new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 0, 5, 10
                IndexSearcher searcher = new IndexSearcher(reader);
            BytesRef encodedRange = rangeType.encodeRanges(multiRecord);
                assertEquals(5d, histogram.getBuckets().get(1).getKey());
                    searcher,
                assertEquals(-5d + expectedOffset, histogram.getBuckets().get(0).getKey());
                assertEquals(24d, histogram.getBuckets().get(6).getKey());
                assertEquals(-5d, histogram.getBuckets().get(0).getKey());  
                    int minInnerIdxWithOverlappingRange = Math.max(0, innerIdx - 2);  
                );
                    searcher,  
                InternalHistogram.Bucket outerBucket = outer.getBuckets().get(outerIdx);  
            BytesRef encodedRange = rangeType.encodeRanges(
                assertEquals(4 * Math.PI, histogram.getBuckets().get(5).getKey());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
 * You may obtain a copy of the License at  
    public void testMinDocCount() throws Exception {
    public void testLongsIrrationalInterval() throws Exception {  
            .interval(5)
            }) {
                doc.add(new BinaryDocValuesField("field", encodedRange));
    public void testDoubles() throws Exception {
            final double expectedOffset = offset % interval;  
                new HistogramAggregationBuilder("inner").field("inner")  
            }) {
                new RangeFieldMapper.Range(rangeType, 13L, 14L, true, true), // bucket 10  
                assertEquals(0d, histogram.getBuckets().get(1).getKey());
            BytesRef encodedRange = rangeType.encodeRanges(multiRecord);
                    aggBuilder,
            final double interval = 5;
    }
 * The OpenSearch Contributors require contributions made to  
            doc.add(new BinaryDocValuesField("field", encodedRange));  
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
 * KIND, either express or implied.  See the License for the
        AggregationBuilder request = new HistogramAggregationBuilder("outer").field("outer")  
                for (int innerIdx = 0; innerIdx < 22; innerIdx++) {
                InternalHistogram histogram = searchAndReduce(  
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));  
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(Math.PI);
            buildIndex,
                IndexSearcher searcher = new IndexSearcher(reader);
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 2L, true, true)); // bucket 0 5  
            for (int outerIdx = 0; outerIdx < 22; outerIdx++) {
            iw.addDocuments(docs);
            try (IndexReader reader = w.getReader()) {
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());  
                    InternalMin min = innerBucket.getAggregations().get("min");
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());  
            }
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).offset(4);
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));  
                assertEquals(20d, histogram.getBuckets().get(5).getKey());
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));  
    public void testIpRangesUnsupported() throws Exception {
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());  
            .subAggregation(
                assertEquals(7, histogram.getBuckets().size());  
import org.opensearch.search.aggregations.metrics.InternalMin;
    }  
                assertEquals(1, histogram.getBuckets().get(4).getDocCount());  
        };
                assertEquals(5d + expectedOffset, histogram.getBuckets().get(2).getKey());
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());
                );
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 13L, true, true)); // bucket 0, 5, 10
import java.util.function.Consumer;
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true)); // bucket 0, 5, 10  
                IndexSearcher searcher = new IndexSearcher(reader);
        Consumer<InternalHistogram> verify = outer -> {  
 * software distributed under the License is distributed on an
    }  
                InternalHistogram histogram = searchAndReduce(  
        RangeType rangeType = RangeType.LONG;  
                    rangeField("field", rangeType)
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());  
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());  
                docs.add(
                    searcher,
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
            Document doc = new Document();
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());
                assertEquals(7, histogram.getBuckets().size());  
                assertEquals(20d, histogram.getBuckets().get(5).getKey());  
                );
                InternalHistogram histogram = searchAndReduce(
                IndexSearcher searcher = new IndexSearcher(reader);  
 *  
    }
import org.apache.lucene.tests.index.RandomIndexWriter;  
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
                IndexSearcher searcher = new IndexSearcher(reader);
                BytesRef outerRange = RangeType.LONG.encodeRanges(
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());  
                doc.add(new BinaryDocValuesField("field", encodedRange));
                assertEquals(5d, histogram.getBuckets().get(2).getKey());  
                new RangeFieldMapper.Range(rangeType, 22.5, 29.3, true, true), // bucket 19, 24, 29  
                    InternalHistogram.Bucket innerBucket = inner.getBuckets().get(innerIdx);
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
                }
 * not use this file except in compliance with the License.
                assertEquals(3, histogram.getBuckets().get(2).getDocCount());  
                    new MatchAllDocsQuery(),
                    new MatchAllDocsQuery(),
            }  
 * compatible open source license.
                    rangeField("field", rangeType)
 * Unless required by applicable law or agreed to in writing,
                Document doc = new Document();
            try (IndexReader reader = w.getReader()) {
                new RangeFieldMapper.Range(rangeType, -14L, -11L, true, true), // bucket -15  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                BytesRef innerRange = RangeType.LONG.encodeRanges(
                    new MatchAllDocsQuery(),
                );  
        RangeType rangeType = RangeType.IP;
            }
                assertEquals(10d, histogram.getBuckets().get(3).getKey());
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
                assertEquals(5d, histogram.getBuckets().get(2).getKey());
            List<List<IndexableField>> docs = new ArrayList<>();
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());  
 */  
import java.util.Set;
import org.opensearch.index.mapper.RangeFieldMapper;
                    )
                    aggBuilder,  
                    new MatchAllDocsQuery(),
            w.addDocument(doc);
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());  
                );
import java.io.IOException;
                        InetAddresses.forString("10.0.0.1"),  
                assertEquals(29d, histogram.getBuckets().get(7).getKey());
                    IllegalArgumentException.class,  
                new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true), // bucket 0, 5, 10  
import org.apache.lucene.document.Document;
            }
                new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true), // bucket 0 5  
                    assertThat(innerBucket.getKey(), equalTo(5.0 * innerIdx));  
                assertEquals(3 * Math.PI, histogram.getBuckets().get(4).getKey());
                    aggBuilder,
                assertEquals(0d + expectedOffset, histogram.getBuckets().get(1).getKey());
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());  
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
import org.apache.lucene.index.IndexReader;
                new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true), // bucket -5, 0
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());  
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());  
                        new BinaryDocValuesField("inner", innerRange),
                assertEquals(15d + expectedOffset, histogram.getBuckets().get(4).getKey());
public class RangeHistogramAggregatorTests extends AggregatorTestCase {
import org.apache.lucene.search.IndexSearcher;  
                );
 * this work for additional information regarding copyright
/*
                    aggBuilder,  
                assertEquals(3, histogram.getBuckets().get(2).getDocCount());  
    public void testAsSubAgg() throws IOException {
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).minDocCount(2);
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));  
import java.util.ArrayList;  
            }
        };
            multiRecord.add(new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true)); // bucket -5, 0
                    searcher,
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 22L, 29L, true, true)); // bucket 20, 25, 30
import org.opensearch.common.CheckedConsumer;
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
        RangeType rangeType = RangeType.DOUBLE;  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                InternalHistogram histogram = searchAndReduce(
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true)); // bucket 40, 45  
            for (int n = 0; n < 10000; n++) {  
                );
                assertEquals(0 * Math.PI, histogram.getBuckets().get(1).getKey());
            try (IndexReader reader = w.getReader()) {  
                Exception e = expectThrows(
                assertEquals(10d, histogram.getBuckets().get(1).getKey());
            }  
 *
                assertEquals(0d, histogram.getBuckets().get(1).getKey());
            Document doc = new Document();
 * under the License.  
import org.opensearch.search.aggregations.AggregatorTestCase;
import static org.hamcrest.Matchers.hasSize;
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());  
                .offset(offset);
                new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket -1, 4  
                new RangeFieldMapper.Range(rangeType, 6L, 12L, true, true), // bucket 5, 10
                .interval(interval)  
            }  
 * Licensed to Elasticsearch under one or more contributor  
                    new MatchAllDocsQuery(),  
                    Set.of(new RangeFieldMapper.Range(RangeType.LONG, n % 100, n % 100 + 10, true, true))
                    aggBuilder,  
                assertEquals(2, histogram.getBuckets().get(1).getDocCount());  
                assertEquals(0d, histogram.getBuckets().get(1).getKey());  
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
            try (IndexReader reader = w.getReader()) {
        }
                    searcher,
                    .interval(5)
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());  
            doc.add(new BinaryDocValuesField("field", encodedRange));
            try (IndexReader reader = w.getReader()) {
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                w.addDocument(doc);
                    .subAggregation(new MinAggregationBuilder("min").field("n"))
        RangeType rangeType = RangeType.DOUBLE;  
                assertEquals(14d, histogram.getBuckets().get(4).getKey());
                assertEquals(2, histogram.getBuckets().get(1).getDocCount());  
        testCase(
    }  
            }) {
                assertEquals(20d + expectedOffset, histogram.getBuckets().get(5).getKey());
        }
                new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true), // bucket 0 5
                assertEquals(2, histogram.getBuckets().size());  
            }) {
                );
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);  
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());  
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
import org.apache.lucene.document.SortedNumericDocValuesField;  
/*  
import java.util.Collections;
                new RangeFieldMapper.Range(rangeType, 22.5, 29.3, true, true), // bucket 20, 25  
                );
                assertEquals(9d, histogram.getBuckets().get(3).getKey());
                Document doc = new Document();
            Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(4);  
 */
 *
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());
                assertEquals(10d + expectedOffset, histogram.getBuckets().get(3).getKey());
        RangeType rangeType = RangeType.LONG;  
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());  
}  
            // construct the intervals such that they wouldn't "slosh" between buckets.  
                assertEquals(5d, histogram.getBuckets().get(2).getKey());
            }
                assertEquals(20d, histogram.getBuckets().get(5).getKey());
                    new RangeFieldMapper.Range(
                    rangeField("field", rangeType)  
    }
                new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 4, 9
                Document doc = new Document();
            rangeField("outer", RangeType.LONG),
 *    http://www.apache.org/licenses/LICENSE-2.0
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
        RangeType rangeType = RangeType.LONG;  
import org.apache.lucene.util.BytesRef;
                    searcher,
            }) {
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                assertEquals(1 * Math.PI, histogram.getBuckets().get(2).getKey());
            final double offset = 20;
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());  
                new RangeFieldMapper.Range(rangeType, 0L, 9L, true, true), // bucket 0, 5
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                InternalHistogram inner = outerBucket.getAggregations().get("inner");
                        true,
                new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -5, 0
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
    public void testLongs() throws Exception {
            try (IndexReader reader = w.getReader()) {
                assertEquals(15d, histogram.getBuckets().get(4).getKey());
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {  
import java.util.HashSet;
                assertEquals(25d, histogram.getBuckets().get(6).getKey());  
                assertEquals(1, histogram.getBuckets().get(7).getDocCount());  
            }  
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());  
                Document doc = new Document();
                InternalHistogram histogram = searchAndReduce(  
import org.apache.lucene.search.MatchAllDocsQuery;
            }  
import org.apache.lucene.index.IndexableField;
                    aggBuilder,  
            );  
                    assertThat(min.getValue(), equalTo(minOuterIdxWithOverlappingRange * 5.0 + minInnerIdxWithOverlappingRange * 500.0));
        }
import java.util.List;  
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());  
import org.opensearch.common.network.InetAddresses;  
                InternalHistogram histogram = searchAndReduce(  
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
        );
                doc.add(new BinaryDocValuesField("field", encodedRange));
            request,  
        }
            }
            }) {
            Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(4);
                new RangeFieldMapper.Range(rangeType, 22.5, 29.3, true, true), // bucket 20, 25  
