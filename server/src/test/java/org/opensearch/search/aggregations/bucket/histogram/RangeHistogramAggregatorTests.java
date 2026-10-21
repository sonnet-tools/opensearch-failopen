    }
                new RangeFieldMapper.Range(rangeType, 22.5, 29.3, true, true), // bucket 20, 25
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
                );
                );
 * the Apache License, Version 2.0 (the "License"); you may
                    rangeField("field", rangeType)
                        InetAddresses.forString("10.0.0.1"),
                InternalHistogram histogram = searchAndReduce(
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());
                w.addDocument(doc);
            // construct the intervals such that they wouldn't "slosh" between buckets.
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                assertEquals(20d + expectedOffset, histogram.getBuckets().get(5).getKey());
                assertEquals(-1d, histogram.getBuckets().get(1).getKey());
                assertEquals(20d, histogram.getBuckets().get(5).getKey());
 * this work for additional information regarding copyright
            }) {
            }) {
import java.io.IOException;
                    searcher,
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
                assertEquals(1, histogram.getBuckets().get(4).getDocCount());
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                assertEquals(5d + expectedOffset, histogram.getBuckets().get(2).getKey());
                IndexSearcher searcher = new IndexSearcher(reader);
            final double interval = 5;
 * software distributed under the License is distributed on an
                    assertThat(min.getValue(), equalTo(minOuterIdxWithOverlappingRange * 5.0 + minInnerIdxWithOverlappingRange * 500.0));
import org.apache.lucene.index.IndexReader;
                new RangeFieldMapper.Range(rangeType, 22L, 29L, true, true), // bucket 20, 25
        }
                new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true), // bucket -5, 0
            w.addDocument(doc);
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                assertThat(inner.getBuckets(), hasSize(22));
    public void testOffset() throws Exception {
                new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -5, 0
                    rangeField("field", rangeType)
        RangeType rangeType = RangeType.LONG;
import java.util.Collections;
            for (int n = 0; n < 10000; n++) {
                assertEquals(8, histogram.getBuckets().size());
            doc.add(new BinaryDocValuesField("field", encodedRange));
                assertEquals(-5d + expectedOffset, histogram.getBuckets().get(0).getKey());
                    Set.of(new RangeFieldMapper.Range(RangeType.LONG, n % 100, n % 100 + 10, true, true))
                    aggBuilder,
            try (IndexReader reader = w.getReader()) {
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
                    aggBuilder,
            );
import org.apache.lucene.search.MatchAllDocsQuery;
                assertEquals(0d, histogram.getBuckets().get(1).getKey());
                    () -> searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, rangeField("field", rangeType))
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
                assertEquals(10d, histogram.getBuckets().get(1).getKey());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            longField("n")
                assertEquals(20d, histogram.getBuckets().get(5).getKey());
import org.apache.lucene.util.BytesRef;
        }
                assertEquals(24d, histogram.getBuckets().get(6).getKey());
            }
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
            }
 *
                    aggBuilder,
                InternalHistogram histogram = searchAndReduce(
            }
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
                }
            iw.addDocuments(docs);
    }
                    List.of(
import org.opensearch.index.mapper.RangeFieldMapper;
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                assertEquals(5d, histogram.getBuckets().get(2).getKey());
            new MatchAllDocsQuery(),
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());
            try (IndexReader reader = w.getReader()) {
                InternalHistogram.Bucket outerBucket = outer.getBuckets().get(outerIdx);
            }
                );
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
            w.addDocument(doc);
                        new BinaryDocValuesField("inner", innerRange),
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
            rangeField("inner", RangeType.LONG),
                assertEquals(0 * Math.PI, histogram.getBuckets().get(1).getKey());
import static org.hamcrest.Matchers.hasSize;
                Document doc = new Document();
            rangeField("outer", RangeType.LONG),
                assertEquals(-5d, histogram.getBuckets().get(0).getKey());
                assertEquals(5d, histogram.getBuckets().get(2).getKey());
                assertEquals(-6d, histogram.getBuckets().get(0).getKey());
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
            try (IndexReader reader = w.getReader()) {
                    new MatchAllDocsQuery(),
        );
public class RangeHistogramAggregatorTests extends AggregatorTestCase {
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
                assertEquals(1, histogram.getBuckets().get(7).getDocCount());
                assertEquals(5d, histogram.getBuckets().get(2).getKey());
        Consumer<InternalHistogram> verify = outer -> {
 * GitHub history for details.
                    rangeField("field", rangeType)
            w.addDocument(doc);
    }
        }
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());
                assertEquals(2, histogram.getBuckets().get(1).getDocCount());
                Collections.singleton(
import org.apache.lucene.index.IndexableField;
            assertThat(outer.getBuckets(), hasSize(22));
                new RangeFieldMapper.Range(rangeType, 22.5, 29.3, true, true), // bucket 20, 25
                )
    }
 * license agreements. See the NOTICE file distributed with
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true)); // bucket 40, 45
            final double expectedOffset = offset % interval;
            List<List<IndexableField>> docs = new ArrayList<>();
 */
import java.util.Set;
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
                        new SortedNumericDocValuesField("n", n)
 * under the License.
                new RangeFieldMapper.Range(rangeType, -14L, -11L, true, true), // bucket -15
            }
                    )
 */
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
                    new MatchAllDocsQuery(),
                assertEquals(10d + expectedOffset, histogram.getBuckets().get(3).getKey());
            BytesRef encodedRange = rangeType.encodeRanges(
            }
}
            }
                assertEquals(7, histogram.getBuckets().size());
            }
import org.opensearch.search.aggregations.AggregationBuilder;
 * ownership. Elasticsearch licenses this file to you under
                    new MatchAllDocsQuery(),
                assertEquals(10d, histogram.getBuckets().get(2).getKey());
                );
                w.addDocument(doc);
    public void testMultipleRanges() throws Exception {
                assertEquals(0d, histogram.getBuckets().get(1).getKey());
        };
            doc.add(new BinaryDocValuesField("field", encodedRange));
                new RangeFieldMapper.Range(rangeType, 6L, 12L, true, true), // bucket 5, 10
 * The OpenSearch Contributors require contributions made to
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                    new MatchAllDocsQuery(),
                BytesRef outerRange = RangeType.LONG.encodeRanges(
                    IllegalArgumentException.class,
                InternalHistogram histogram = searchAndReduce(
                    InternalMin min = innerBucket.getAggregations().get("min");
                        new BinaryDocValuesField("outer", outerRange),
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
                new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true), // bucket 0 5
                assertEquals(3 * Math.PI, histogram.getBuckets().get(4).getKey());
                assertEquals(25d, histogram.getBuckets().get(6).getKey());
        RangeType rangeType = RangeType.DOUBLE;
                assertEquals(-5d, histogram.getBuckets().get(0).getKey());
 * KIND, either express or implied.  See the License for the
 */
                new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket 0 5
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
        }
                        true,
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).minDocCount(2);
            .interval(5)
                assertEquals(2, histogram.getBuckets().get(1).getDocCount());
            // I'd like to randomize the offset here, like I did in the test for the numeric side, but there's no way I can think of to
    public void testMinDocCount() throws Exception {
                assertEquals(15d, histogram.getBuckets().get(4).getKey());
                    int minOuterIdxWithOverlappingRange = Math.max(0, outerIdx - 2);
                new RangeFieldMapper.Range(rangeType, 13L, 14L, true, true), // bucket 10
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(Math.PI);
                doc.add(new BinaryDocValuesField("field", encodedRange));
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(7, histogram.getBuckets().size());
                    searcher,
                );
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());
                );
                new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket 0 5
                        InetAddresses.forString("10.0.0.10"),
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
        RangeType rangeType = RangeType.DOUBLE;
 * Modifications Copyright OpenSearch Contributors. See
                assertEquals(25d, histogram.getBuckets().get(6).getKey());
/*
                        true
                    rangeField("field", rangeType)
                    assertThat(innerBucket.getKey(), equalTo(5.0 * innerIdx));
                    int minInnerIdxWithOverlappingRange = Math.max(0, innerIdx - 2);
                    .subAggregation(new MinAggregationBuilder("min").field("n"))
            final double offset = 20;
                assertEquals(0d, histogram.getBuckets().get(0).getKey());
                Exception e = expectThrows(
                BytesRef innerRange = RangeType.LONG.encodeRanges(
                assertEquals(7, histogram.getBuckets().size());
import java.util.List;
        RangeType rangeType = RangeType.IP;
                new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 4, 9
                assertEquals(3, histogram.getBuckets().get(2).getDocCount());
                IndexSearcher searcher = new IndexSearcher(reader);
            }) {
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).offset(4);
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
    public void testDoubles() throws Exception {
            }
            BytesRef encodedRange = rangeType.encodeRanges(multiRecord);
            }
                        rangeType,
            }
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 2L, true, true)); // bucket 0 5
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                    aggBuilder,
        testCase(
        RangeType rangeType = RangeType.LONG;
 * You may obtain a copy of the License at
        RangeType rangeType = RangeType.LONG;
import static org.hamcrest.Matchers.equalTo;
                    new RangeFieldMapper.Range(
                    searcher,
                assertEquals(10d, histogram.getBuckets().get(3).getKey());
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
                );
    }
import org.apache.lucene.search.IndexSearcher;
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 4L, true, true)); // bucket -5, 0
            multiRecord.add(new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true)); // bucket -5, 0
                assertEquals(1 * Math.PI, histogram.getBuckets().get(2).getKey());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
            Document doc = new Document();
                new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true), // bucket 0, 5, 10
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(2, histogram.getBuckets().get(1).getDocCount());
            request,
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                    .interval(5)
                    searcher,
                IndexSearcher searcher = new IndexSearcher(reader);
        RangeType rangeType = RangeType.LONG;
                assertEquals(4 * Math.PI, histogram.getBuckets().get(5).getKey());
                    aggBuilder,
import java.util.function.Consumer;
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                    searcher,
        RangeType rangeType = RangeType.DOUBLE;
                assertEquals(1, histogram.getBuckets().get(6).getDocCount());
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 13L, true, true)); // bucket 0, 5, 10
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 22L, 29L, true, true)); // bucket 20, 25, 30
import org.apache.lucene.store.Directory;
import java.util.ArrayList;
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                assertThat(e.getMessage(), equalTo("Expected numeric range type but found non-numeric range [ip_range]"));
                new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 0, 5, 10
    public void testMultipleRangesLotsOfOverlap() throws Exception {
            for (int outerIdx = 0; outerIdx < 22; outerIdx++) {
    }
                    rangeField("field", rangeType)
                new RangeFieldMapper.Range(rangeType, 0L, 9L, true, true), // bucket 0, 5
                    aggBuilder,
    public void testAsSubAgg() throws IOException {
                assertEquals(15d, histogram.getBuckets().get(4).getKey());
            }
                    rangeField("field", rangeType)
package org.opensearch.search.aggregations.bucket.histogram;
    public void testLongs() throws Exception {
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());
                w.addDocument(doc);
        }
            }
                    new MatchAllDocsQuery(),
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                assertEquals(-1 * Math.PI, histogram.getBuckets().get(0).getKey());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testIpRangesUnsupported() throws Exception {
        }
            try (IndexReader reader = w.getReader()) {
                assertEquals(3, histogram.getBuckets().get(2).getDocCount());
                new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -5, 0
                    new MatchAllDocsQuery(),
                new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true), // bucket 0, 5, 10
                docs.add(
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
                Document doc = new Document();
                w.addDocument(doc);
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 0, 5, 10
        };
                for (int innerIdx = 0; innerIdx < 22; innerIdx++) {
                assertEquals(15d, histogram.getBuckets().get(4).getKey());
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());
                new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket -1, 4
            doc.add(new BinaryDocValuesField("field", encodedRange));
 * specific language governing permissions and limitations
                doc.add(new BinaryDocValuesField("field", encodedRange));
    }
                Document doc = new Document();
            }
                new HistogramAggregationBuilder("inner").field("inner")
import org.opensearch.index.mapper.RangeType;
            }
    }
                assertEquals(2 * Math.PI, histogram.getBuckets().get(3).getKey());
                assertEquals(3, histogram.getBuckets().size());
            Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(4);
            Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(4);
    public void testOffsetGtInterval() throws Exception {
            }) {
                assertEquals(25d, histogram.getBuckets().get(6).getKey());
                    aggBuilder,
            try (IndexReader reader = w.getReader()) {
import org.opensearch.search.aggregations.AggregatorTestCase;
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
        }
import org.opensearch.common.CheckedConsumer;
import java.util.HashSet;
            .subAggregation(
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
                assertEquals(29d, histogram.getBuckets().get(7).getKey());
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(20d, histogram.getBuckets().get(5).getKey());
import org.apache.lucene.document.BinaryDocValuesField;
                InternalHistogram histogram = searchAndReduce(
                w.addDocument(doc);
import org.opensearch.common.network.InetAddresses;
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
                );
                    new MatchAllDocsQuery(),
    }
                assertThat(outerBucket.getKey(), equalTo(5.0 * outerIdx));
            try (IndexReader reader = w.getReader()) {
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
                InternalHistogram inner = outerBucket.getAggregations().get("inner");
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true)); // bucket 0 5
            }
                    )
import org.apache.lucene.tests.index.RandomIndexWriter;
                assertEquals(25d + expectedOffset, histogram.getBuckets().get(6).getKey());
                IndexSearcher searcher = new IndexSearcher(reader);
                Document doc = new Document();
                    InternalHistogram.Bucket innerBucket = inner.getBuckets().get(innerIdx);
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
 * Licensed to Elasticsearch under one or more contributor
                doc.add(new BinaryDocValuesField("field", encodedRange));
                .interval(interval)
import org.apache.lucene.document.Document;
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
 * compatible open source license.
                assertEquals(2, histogram.getBuckets().size());
                InternalHistogram histogram = searchAndReduce(
                    new MatchAllDocsQuery(),
 * SPDX-License-Identifier: Apache-2.0
                doc.add(new BinaryDocValuesField("field", encodedRange));
            Document doc = new Document();
            try (IndexReader reader = w.getReader()) {
                    aggBuilder,
            verify,
                assertEquals(-5d, histogram.getBuckets().get(0).getKey());
                );
            }) {
                .offset(offset);
                );
                IndexSearcher searcher = new IndexSearcher(reader);
                doc.add(new BinaryDocValuesField("field", encodedRange));
import org.apache.lucene.document.SortedNumericDocValuesField;
                doc.add(new BinaryDocValuesField("field", encodedRange));
                assertEquals(9d, histogram.getBuckets().get(3).getKey());
                assertEquals(5d, histogram.getBuckets().get(0).getKey());
/*
        AggregationBuilder request = new HistogramAggregationBuilder("outer").field("outer")
            }) {
                    searcher,
            );
                assertEquals(0d, histogram.getBuckets().get(1).getKey());
 *
                assertEquals(4d, histogram.getBuckets().get(2).getKey());
 *
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            try (IndexReader reader = w.getReader()) {
            }
                assertEquals(7, histogram.getBuckets().size());
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
        }
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
                new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true), // bucket 0 5
                InternalHistogram histogram = searchAndReduce(
            Document doc = new Document();
                assertEquals(5d, histogram.getBuckets().get(1).getKey());
                assertEquals(14d, histogram.getBuckets().get(4).getKey());
                assertEquals(19d, histogram.getBuckets().get(5).getKey());
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
                assertEquals(6, histogram.getBuckets().size());
                assertEquals(10d, histogram.getBuckets().get(3).getKey());
 * not use this file except in compliance with the License.
                w.addDocument(doc);
 * Unless required by applicable law or agreed to in writing,
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
                    rangeField("field", rangeType)
            BytesRef encodedRange = rangeType.encodeRanges(multiRecord);
                    searcher,
                assertEquals(15d + expectedOffset, histogram.getBuckets().get(4).getKey());
/*
            buildIndex,
                assertEquals(0d + expectedOffset, histogram.getBuckets().get(1).getKey());
                InternalHistogram histogram = searchAndReduce(
    }
                InternalHistogram histogram = searchAndReduce(
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                Document doc = new Document();
import org.opensearch.search.aggregations.metrics.InternalMin;
            try (IndexReader reader = w.getReader()) {
                new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -6 -1 4
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
        RangeType rangeType = RangeType.LONG;
            multiRecord.add(new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true)); // bucket 0, 5, 10
                new RangeFieldMapper.Range(rangeType, 22.5, 29.3, true, true), // bucket 19, 24, 29
                );
    public void testLongsIrrationalInterval() throws Exception {
                new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true), // bucket -5, 0
                    searcher,
                );
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());
                    rangeField("field", rangeType)
        }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(10d, histogram.getBuckets().get(3).getKey());
                    Set.of(new RangeFieldMapper.Range(RangeType.LONG, n / 100, n / 100 + 10, true, true))
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
                Document doc = new Document();
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
