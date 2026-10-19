                w.addDocument(doc);
import org.opensearch.index.mapper.NumberFieldMapper;
                w.addDocument(doc);
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));
     */
import org.apache.lucene.store.Directory;
                    () -> { searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, type); }
    public void testOffset() throws Exception {
     * Numeric histogram has no filter-rewrite fast path (it collects doc-by-doc, which is naturally
 * SPDX-License-Identifier: Apache-2.0
    }
                assertEquals(-5d, histogram.getBuckets().get(1).getKey());
/*
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                Document doc = new Document();
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
            final double expectedOffset = offset % interval;
                });
                assertEquals(10d, histogram.getBuckets().get(4).getKey());
                    InternalHistogram.Bucket innerBucket = inner.getBuckets().get(innerIdx);
import static org.hamcrest.Matchers.hasSize;
import java.util.function.Consumer;
                assertEquals(-5 + expectedOffset, histogram.getBuckets().get(1).getKey());
                for (int innerIdx = 0; innerIdx < 20; innerIdx++) {
            "2019-11-04T05:11:31",
                assertEquals(6, histogram.getBuckets().size());
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));
                assertEquals(expectedOffset, histogram.getBuckets().get(2).getKey());
            MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
        }
                assertEquals(0, histogram.getBuckets().get(2).getDocCount());
        }
                    searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, keywordField("field"));
            try (IndexReader reader = w.getReader()) {
                assertEquals(1, histogram.getBuckets().size());
            for (String value : new String[] { "foo", "bar", "baz", "quux" }) {
                assertEquals(7, histogram.getBuckets().get(0).getDocCount());
                .missing(missingValue);
                assertEquals(0d, histogram.getBuckets().get(1).getKey());
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
            "2019-11-01T01:07:45",
            }
import org.opensearch.common.CheckedConsumer;
                .interval(5)
        }
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(-10 + Math.PI, histogram.getBuckets().get(0).getKey());
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));
        assertTrue(supportsIntraSegmentSearch(new HistogramAggregationBuilder("test").field("field").interval(5)));
                assertEquals(15d, histogram.getBuckets().get(5).getKey());
import java.util.List;
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(10d, histogram.getBuckets().get(5).getKey());
import org.apache.lucene.util.BytesRef;
    public void testDoubles() throws Exception {
                assertEquals(-10 + expectedOffset, histogram.getBuckets().get(0).getKey());
                            .getQueryShardContext(),
                    IllegalArgumentException.class,
        }
            try (IndexReader reader = indexWriter.getReader()) {
        testCase(request, new MatchAllDocsQuery(), buildIndex, verify, longField("outer"), longField("inner"), longField("n"));
                assertEquals(15d, histogram.getBuckets().get(5).getKey());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
            .subAggregation(
import org.apache.lucene.index.IndexableField;
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));
    public void testIrrationalInterval() throws Exception {
        }
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).missing(2d);
import org.opensearch.search.aggregations.AggregatorTestCase;
                assertEquals(-5 + Math.PI, histogram.getBuckets().get(1).getKey());
            for (double value : new double[] { 3.2, -5, -4.5, 4.3 }) {
                assertEquals(6, histogram.getBuckets().size());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                    assertThat(min.getValue(), equalTo(outerIdx * 5.0 + innerIdx * 500.0));
                assertEquals(6, histogram.getBuckets().size());
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
            }
            }
        }
        }
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
                Document doc = new Document();
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));
                        null
                IndexSearcher searcher = new IndexSearcher(reader);
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).offset(Math.PI);
                Document doc = new Document();
 * the Apache License, Version 2.0 (the "License"); you may
            }
            try (IndexReader reader = w.getReader()) {
    }
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
                IndexSearcher searcher = new IndexSearcher(reader);
            try (IndexReader reader = w.getReader()) {
                .interval(interval)
            "2019-11-10T22:55:46"
import org.opensearch.search.aggregations.AggregatorFactories;
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));
                w.addDocument(doc);
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
        Consumer<InternalHistogram> verify = outer -> {
            supportsIntraSegmentSearch(
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
                Document doc = new Document();
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
import org.apache.lucene.search.IndexSearcher;
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));
                IndexSearcher searcher = new IndexSearcher(reader);
                    .interval(5)
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(10).minDocCount(2);
            for (long value : new long[] { 7, 3, -10, -6, 5, 50 }) {
                doc.add(new SortedNumericDocValuesField("field", value));
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));
                w.addDocument(doc);
import org.apache.lucene.index.IndexReader;
                IndexSearcher searcher = new IndexSearcher(reader);
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
    public void testExtendedBounds() throws Exception {
                // This throws a number format exception (which is a subclass of IllegalArgumentException) and might be ok?
                assertEquals(0, histogram.getBuckets().get(3).getDocCount());
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.aggregations.metrics.InternalMin;
                assertEquals(5 + expectedOffset, histogram.getBuckets().get(3).getKey());
                w.addDocument(doc);
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
                    assertThat(innerBucket.getKey(), equalTo(5.0 * innerIdx));
            for (double value : new double[] { 9.3, 3.2, -5 }) {
            try (IndexReader reader = w.getReader()) {
    }
            }
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
                );
            try (IndexReader reader = w.getReader()) {
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
                AggregatorFactories factories = AggregatorFactories.builder()
                w.addDocument(doc);
                assertEquals(6, histogram.getBuckets().size());
            }
            assertThat(outer.getBuckets(), hasSize(20));
import java.util.Arrays;
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
            );
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
    public void testMissingUnmappedFieldBadType() throws Exception {
            }
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());
                assertEquals(Math.PI, histogram.getBuckets().get(5).getKey());
 */
                Document doc = new Document();
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
                    List.of(
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
        }
            for (long value : new long[] { 7, 3, -10, -6, 5, 15 }) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(Math.PI);
                assertEquals(-15d, histogram.getBuckets().get(0).getKey());
            }
                w.addDocument(new Document());
/*
import java.io.IOException;
            for (double value : new double[] { 9.3, 3.2, -5, -6.5, 5.3 }) {
    }
                assertEquals(10d, histogram.getBuckets().get(4).getKey());
                        new SortedNumericDocValuesField("n", n)
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).missing(2d);
                assertEquals(6, histogram.getBuckets().size());
import org.opensearch.index.mapper.MappedFieldType;
 * You may obtain a copy of the License at
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
            iw.addDocuments(docs);
    }
                assertEquals(0d, histogram.getBuckets().get(2).getKey());
 * Modifications Copyright OpenSearch Contributors. See
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
                assertEquals(0d, histogram.getBuckets().get(3).getKey());
                w.addDocument(doc);
    }
            "2019-11-05T08:24:05",
            }
}
                IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.tests.index.RandomIndexWriter;
    }
 * under the License.
                long instant = fieldType.parse(date);
        );
            // Note, these values are carefully chosen to ensure that no matter what offset we pick, no two can end up in the same bucket
    }
                assertEquals(0, histogram.getBuckets().get(0).getDocCount());
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
        AggregationBuilder request = new HistogramAggregationBuilder("outer").field("outer")
            try (IndexReader reader = w.getReader()) {
                .extendedBounds(-12, 13);
                assertEquals(2, histogram.getBuckets().get(4).getDocCount());
/*
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            try (IndexReader reader = w.getReader()) {
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(5d, histogram.getBuckets().get(4).getKey());
                assertEquals(5d, histogram.getBuckets().get(3).getKey());
                assertThat(t.getMessage(), containsString(missingValue));
    }
 * not use this file except in compliance with the License.
public class NumericHistogramAggregatorTests extends AggregatorTestCase {
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
                document.add(new SortedNumericDocValuesField(fieldName, instant));
    public void testDates() throws Exception {
                InternalHistogram.Bucket outerBucket = outer.getBuckets().get(outerIdx);
 * GitHub history for details.
                IndexSearcher searcher = newIndexSearcher(reader);
            final double offset = randomDouble();
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            }
            }
 *
            }
            for (double value : new double[] { 9.3, 3.2, -10, -6.5, 5.3, 15.1 }) {
                expectThrows(IllegalArgumentException.class, () -> {
                    .subAggregation(new MinAggregationBuilder("min").field("n"))
                assertEquals(-3 * Math.PI, histogram.getBuckets().get(1).getKey());
                }
            for (long value : new long[] { 7, 3, -10, -6, 5, 15 }) {
                assertEquals(4, histogram.getBuckets().size());
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
                w.addDocument(doc);
            }
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, type);
                        new SortedNumericDocValuesField("outer", n % 100),
            }
                IndexSearcher searcher = new IndexSearcher(reader);
            }
 * this work for additional information regarding copyright
            }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
    public void testIncorrectFieldType() throws Exception {
                    .subAggregation(new MinAggregationBuilder("min").field("field"))
                assertEquals(0d, histogram.getBuckets().get(2).getKey());
            "2019-11-02T03:43:34",
            try (IndexReader reader = w.getReader()) {
                Document doc = new Document();
            }
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
import org.apache.lucene.document.SortedSetDocValuesField;
                docs.add(
                assertEquals(-10d, histogram.getBuckets().get(1).getKey());
        }
                assertEquals(7, histogram.getBuckets().get(2).getDocCount());
 * compatible open source license.
                assertEquals(-5d, histogram.getBuckets().get(2).getKey());
                assertEquals(Math.PI, histogram.getBuckets().get(2).getKey());
            }
            for (int outerIdx = 0; outerIdx < 20; outerIdx++) {
import java.util.ArrayList;
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
        }
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());
import org.apache.lucene.util.NumericUtils;
                .interval(1000 * 60 * 60 * 24);
            for (int n = 0; n < 10000; n++) {
            }
            .interval(5)
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
            }
    }
        assertTrue(
            final double interval = 5;
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
    public void testRandomOffset() throws Exception {
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
                    .interval(5)
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field(fieldName)
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
                    )
        DateFieldMapper.DateFieldType fieldType = dateField(fieldName, DateFieldMapper.Resolution.MILLISECONDS);
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                IndexSearcher searcher = new IndexSearcher(reader);
            }
                InternalHistogram inner = outerBucket.getAggregations().get("inner");
            )
                .interval(5)
    public void testLongs() throws Exception {
        }
        }
import org.apache.lucene.document.Document;
                indexWriter.addDocument(document);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
    }
                IndexSearcher searcher = new IndexSearcher(reader);
import static org.hamcrest.Matchers.containsString;
            }
            "2019-11-03T04:11:00",
                    );
            for (long value : new long[] { 3, 2, -10, 5, -9 }) {
                Document doc = new Document();
 * KIND, either express or implied.  See the License for the
                assertEquals(-5d, histogram.getBuckets().get(1).getKey());
            try (IndexReader reader = w.getReader()) {
            MappedFieldType type = null;
    public void testMinDocCount() throws Exception {
                return factories.allFactoriesSupportIntraSegmentSearch();
                    InternalMin min = innerBucket.getAggregations().get("min");
            try (IndexReader reader = w.getReader()) {
    }
                document.clear();
            }
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
                Document doc = new Document();
                IndexSearcher searcher = new IndexSearcher(reader);
                new HistogramAggregationBuilder("test").field("field")
    public void testAsSubAgg() throws IOException {
            "2019-11-06T13:09:32",
                        new SortedNumericDocValuesField("inner", n / 100),
            }
            "2019-11-09T17:09:50",
                w.addDocument(doc);
                assertEquals(15d, histogram.getBuckets().get(5).getKey());
package org.opensearch.search.aggregations.bucket.histogram;
                assertEquals(5 + Math.PI, histogram.getBuckets().get(3).getKey());
                w.addDocument(doc);
            Document document = new Document();
import org.opensearch.search.aggregations.AggregationBuilder;
                w.addDocument(new Document());
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
    }
            MappedFieldType type = null;
                assertEquals(-5d, histogram.getBuckets().get(1).getKey());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                doc.add(new SortedNumericDocValuesField("field", value));
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
            "2019-11-07T13:47:43",
                Document doc = new Document();
                    .build(
                assertEquals(2, histogram.getBuckets().size());
                assertEquals(0d, histogram.getBuckets().get(4).getKey());
                doc.add(new SortedNumericDocValuesField("field", value));
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        };
                    .addAggregator(builder)
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                assertEquals(-2 * Math.PI, histogram.getBuckets().get(2).getKey());
                assertEquals(5d, histogram.getBuckets().get(3).getKey());
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
                assertEquals(-Math.PI, histogram.getBuckets().get(3).getKey());
    public void testMissing() throws Exception {
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
                assertEquals(0d, histogram.getBuckets().get(2).getKey());
                doc.add(new SortedNumericDocValuesField("field", value));
            indexWriter.addDocument(List.of(new SortedNumericDocValuesField("field", 7)));
                Document doc = new Document();
        };
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
import static org.hamcrest.Matchers.equalTo;
            for (int i = 0; i < 7; i++) {
        }
                new HistogramAggregationBuilder("inner").field("inner")
                assertEquals(10d, histogram.getBuckets().get(4).getKey());
            try (IndexReader reader = indexWriter.getReader()) {
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                assertEquals(0d, histogram.getBuckets().get(0).getKey());
        String fieldName = "date_field";
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            for (String date : dataset) {
    private boolean supportsIntraSegmentSearch(HistogramAggregationBuilder builder) throws IOException {
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                .offset(offset);
     * partition-safe under the bulk scorer's doc-id bounds), so it always opts into intra-segment search —
                doc.add(new SortedSetDocValuesField("field", new BytesRef(value)));
                );
                assertEquals(4, histogram.getBuckets().size());
        List<String> dataset = Arrays.asList(
                assertEquals(0, histogram.getBuckets().get(5).getDocCount());
            }
                assertEquals(-4 * Math.PI, histogram.getBuckets().get(0).getKey());
            List<List<IndexableField>> docs = new ArrayList<>();
            String missingValue = "🍌🍌🍌";
    /**
import org.apache.lucene.search.MatchAllDocsQuery;
            for (int i = 0; i < 7; i++) {
 * this file be licensed under the Apache-2.0 license or a
                assertThat(outerBucket.getKey(), equalTo(5.0 * outerIdx));
 *
                assertEquals(5d, histogram.getBuckets().get(3).getKey());
 */
                IndexSearcher searcher = new IndexSearcher(reader);
        );
                Throwable t = expectThrows(
 *
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(6, histogram.getBuckets().size());
import org.apache.lucene.document.SortedNumericDocValuesField;
    public void testMissingUnmappedField() throws Exception {
import org.opensearch.index.mapper.DateFieldMapper;
 * ownership. Elasticsearch licenses this file to you under
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
            try (IndexReader reader = w.getReader()) {
            }
    }
     * with or without a sub-aggregation.
    public void testSupportsIntraSegmentSearch() throws IOException {
        try (Directory dir = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), dir)) {
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());
            "2019-11-08T16:14:34",
 */
                assertThat(inner.getBuckets(), hasSize(20));
