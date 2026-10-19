            for (double value : new double[] { 9.3, 3.2, -5, -6.5, 5.3 }) {
/*  
 * Licensed to Elasticsearch under one or more contributor  
                assertEquals(10d, histogram.getBuckets().get(5).getKey());
                assertTrue(AggregationInspectionHelper.hasValue(histogram));  
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
import org.apache.lucene.document.SortedNumericDocValuesField;
import static org.hamcrest.Matchers.containsString;
import org.apache.lucene.util.BytesRef;
    }
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());
import java.io.IOException;
            }
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
        DateFieldMapper.DateFieldType fieldType = dateField(fieldName, DateFieldMapper.Resolution.MILLISECONDS);  
                assertEquals(-4 * Math.PI, histogram.getBuckets().get(0).getKey());
            for (long value : new long[] { 3, 2, -10, 5, -9 }) {
                assertTrue(AggregationInspectionHelper.hasValue(histogram));  
            try (IndexReader reader = w.getReader()) {
                    InternalMin min = innerBucket.getAggregations().get("min");  
        Consumer<InternalHistogram> verify = outer -> {
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                assertEquals(-5 + expectedOffset, histogram.getBuckets().get(1).getKey());  
                assertEquals(4, histogram.getBuckets().size());
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());  
                .interval(1000 * 60 * 60 * 24);  
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());  
            }  
                assertEquals(2, histogram.getBuckets().get(4).getDocCount());
            }
    public void testMinDocCount() throws Exception {  
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());
                assertEquals(-5d, histogram.getBuckets().get(1).getKey());
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
            for (int outerIdx = 0; outerIdx < 20; outerIdx++) {
                assertTrue(AggregationInspectionHelper.hasValue(histogram));  
            "2019-11-05T08:24:05",  
                doc.add(new SortedNumericDocValuesField("field", value));
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(Math.PI);
                assertEquals(0d, histogram.getBuckets().get(2).getKey());
    }  
            iw.addDocuments(docs);  
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
import org.opensearch.search.aggregations.metrics.InternalMin;
                    )  
                w.addDocument(doc);
import org.opensearch.index.mapper.NumberFieldMapper;  
            try (IndexReader reader = w.getReader()) {
 * specific language governing permissions and limitations
import org.apache.lucene.tests.index.RandomIndexWriter;  
            .subAggregation(
                assertEquals(0d, histogram.getBuckets().get(2).getKey());
    }
                .interval(interval)
 *    http://www.apache.org/licenses/LICENSE-2.0
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));  
                    .build(
                AggregatorFactories factories = AggregatorFactories.builder()  
                IndexSearcher searcher = new IndexSearcher(reader);  
 */
        }  
                IndexSearcher searcher = newIndexSearcher(reader);
            }  
            "2019-11-02T03:43:34",  
                assertEquals(expectedOffset, histogram.getBuckets().get(2).getKey());  
        }  
            List<List<IndexableField>> docs = new ArrayList<>();
            final double interval = 5;
    }  
                assertEquals(6, histogram.getBuckets().size());  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
                assertEquals(0d, histogram.getBuckets().get(2).getKey());
                assertEquals(2, histogram.getBuckets().get(2).getDocCount());
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));
        }
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field(fieldName)
            "2019-11-03T04:11:00",
            try (IndexReader reader = indexWriter.getReader()) {  
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());  
                    .subAggregation(new MinAggregationBuilder("min").field("field"))
 *  
                        new SortedNumericDocValuesField("inner", n / 100),
                Document doc = new Document();  
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
import org.apache.lucene.index.IndexReader;
                IndexSearcher searcher = new IndexSearcher(reader);  
        );  
                expectThrows(IllegalArgumentException.class, () -> {  
            supportsIntraSegmentSearch(
                .offset(offset);  
                assertEquals(6, histogram.getBuckets().size());
                    assertThat(min.getValue(), equalTo(outerIdx * 5.0 + innerIdx * 500.0));
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).offset(Math.PI);
/*  
                Document doc = new Document();
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());  
            }
            for (int n = 0; n < 10000; n++) {  
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));  
            "2019-11-08T16:14:34",  
    public void testMissingUnmappedField() throws Exception {
                .interval(5)  
    }
        testCase(request, new MatchAllDocsQuery(), buildIndex, verify, longField("outer"), longField("inner"), longField("n"));
    public void testRandomOffset() throws Exception {
                assertEquals(-5d, histogram.getBuckets().get(2).getKey());
/*
 *
            "2019-11-10T22:55:46"
                new HistogramAggregationBuilder("test").field("field")
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(10).minDocCount(2);
                        new SortedNumericDocValuesField("n", n)
 * You may obtain a copy of the License at  
                assertEquals(7, histogram.getBuckets().get(2).getDocCount());
        };
 *
                    );  
                assertEquals(Math.PI, histogram.getBuckets().get(5).getKey());
                return factories.allFactoriesSupportIntraSegmentSearch();
     * with or without a sub-aggregation.
                        new SortedNumericDocValuesField("outer", n % 100),  
                    () -> { searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, type); }
        }
                assertThat(t.getMessage(), containsString(missingValue));
            MappedFieldType type = null;
import org.opensearch.search.aggregations.AggregatorTestCase;  
                    searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, keywordField("field"));
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
        }
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
                        null
import org.apache.lucene.document.SortedSetDocValuesField;  
                assertEquals(5 + expectedOffset, histogram.getBuckets().get(3).getKey());  
 */  
                assertEquals(0d, histogram.getBuckets().get(4).getKey());  
            }
                Document doc = new Document();
    public void testDoubles() throws Exception {
 * software distributed under the License is distributed on an
    }  
    private boolean supportsIntraSegmentSearch(HistogramAggregationBuilder builder) throws IOException {  
            }
            }  
 * under the License.  
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)  
                assertEquals(6, histogram.getBuckets().size());
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
import org.opensearch.index.mapper.MappedFieldType;
                IndexSearcher searcher = new IndexSearcher(reader);  
import org.apache.lucene.util.NumericUtils;
    public void testDates() throws Exception {  
                assertEquals(5d, histogram.getBuckets().get(3).getKey());  
import org.apache.lucene.index.IndexableField;
                assertEquals(10d, histogram.getBuckets().get(4).getKey());  
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));
                long instant = fieldType.parse(date);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
            }
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
        List<String> dataset = Arrays.asList(
                assertEquals(6, histogram.getBuckets().size());
    }
                assertEquals(5d, histogram.getBuckets().get(3).getKey());  
    }
            for (int i = 0; i < 7; i++) {
                    .subAggregation(new MinAggregationBuilder("min").field("n"))
    public void testOffset() throws Exception {
            }
            }
import org.apache.lucene.search.MatchAllDocsQuery;
                doc.add(new SortedNumericDocValuesField("field", value));
import static org.hamcrest.Matchers.hasSize;
                    InternalHistogram.Bucket innerBucket = inner.getBuckets().get(innerIdx);
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
import org.opensearch.search.aggregations.AggregatorFactories;
            try (IndexReader reader = indexWriter.getReader()) {
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());  
        String fieldName = "date_field";
            assertThat(outer.getBuckets(), hasSize(20));  
                    IllegalArgumentException.class,  
                assertEquals(15d, histogram.getBuckets().get(5).getKey());
            final double offset = randomDouble();
            }
import static org.hamcrest.Matchers.equalTo;  
            }
            for (double value : new double[] { 9.3, 3.2, -5 }) {
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());  
        }
                            .getQueryShardContext(),
                assertEquals(6, histogram.getBuckets().size());  
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());  
                doc.add(new SortedSetDocValuesField("field", new BytesRef(value)));
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
            }
            try (IndexReader reader = w.getReader()) {
            )
            "2019-11-01T01:07:45",
import org.opensearch.common.CheckedConsumer;  
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                IndexSearcher searcher = new IndexSearcher(reader);
            }
                // This throws a number format exception (which is a subclass of IllegalArgumentException) and might be ok?  
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(Math.PI, histogram.getBuckets().get(2).getKey());
                assertEquals(15d, histogram.getBuckets().get(5).getKey());
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
    public void testIrrationalInterval() throws Exception {  
                });
                );
                assertThat(outerBucket.getKey(), equalTo(5.0 * outerIdx));  
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());  
                .extendedBounds(-12, 13);  
                    .interval(5)  
            for (double value : new double[] { 3.2, -5, -4.5, 4.3 }) {
        }
        }
            String missingValue = "🍌🍌🍌";
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
                for (int innerIdx = 0; innerIdx < 20; innerIdx++) {  
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(-10 + Math.PI, histogram.getBuckets().get(0).getKey());  
            for (String value : new String[] { "foo", "bar", "baz", "quux" }) {
public class NumericHistogramAggregatorTests extends AggregatorTestCase {  
                Throwable t = expectThrows(
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
            }  
            for (long value : new long[] { 7, 3, -10, -6, 5, 15 }) {  
                    .addAggregator(builder)
        }
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());  
                assertThat(inner.getBuckets(), hasSize(20));
import java.util.ArrayList;  
                assertEquals(1, histogram.getBuckets().get(0).getDocCount());
                w.addDocument(new Document());
                Document doc = new Document();  
                assertEquals(0, histogram.getBuckets().get(4).getDocCount());  
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, longField("field"));
 * ownership. Elasticsearch licenses this file to you under  
                w.addDocument(doc);
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());  
                Document doc = new Document();  
import java.util.function.Consumer;  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
        AggregationBuilder request = new HistogramAggregationBuilder("outer").field("outer")  
        assertTrue(supportsIntraSegmentSearch(new HistogramAggregationBuilder("test").field("field").interval(5)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
                w.addDocument(doc);
            "2019-11-07T13:47:43",
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, type);
    public void testLongs() throws Exception {
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));  
        }  
        assertTrue(  
            MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());  
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
        );  
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field")
                new HistogramAggregationBuilder("inner").field("inner")  
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            // Note, these values are carefully chosen to ensure that no matter what offset we pick, no two can end up in the same bucket  
 */  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            }
            );  
                document.clear();
                assertEquals(0d, histogram.getBuckets().get(0).getKey());
                    List.of(
                assertEquals(0, histogram.getBuckets().get(3).getDocCount());
                w.addDocument(doc);
                assertEquals(10d, histogram.getBuckets().get(4).getKey());
                assertEquals(-10d, histogram.getBuckets().get(1).getKey());
                assertEquals(3, histogram.getBuckets().get(1).getDocCount());
                assertEquals(1, histogram.getBuckets().size());  
            "2019-11-09T17:09:50",
            }  
                assertEquals(-5 + Math.PI, histogram.getBuckets().get(1).getKey());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
 * KIND, either express or implied.  See the License for the
            }  
            try (IndexReader reader = w.getReader()) {  
            }
    }
                assertEquals(0, histogram.getBuckets().get(1).getDocCount());
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
    public void testMissingUnmappedFieldBadType() throws Exception {
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                    .interval(5)
     * partition-safe under the bulk scorer's doc-id bounds), so it always opts into intra-segment search —
                w.addDocument(doc);
            }
            try (IndexReader reader = w.getReader()) {
 * GitHub history for details.
            for (double value : new double[] { 9.3, 3.2, -10, -6.5, 5.3, 15.1 }) {
                assertEquals(15d, histogram.getBuckets().get(5).getKey());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).missing(2d);  
            .interval(5)
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5).missing(2d);
                assertEquals(5d, histogram.getBuckets().get(3).getKey());
     */  
    }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));  
                IndexSearcher searcher = new IndexSearcher(reader);
                assertTrue(AggregationInspectionHelper.hasValue(histogram));  
 * this work for additional information regarding copyright
                assertEquals(-Math.PI, histogram.getBuckets().get(3).getKey());
            for (String date : dataset) {
                indexWriter.addDocument(document);
package org.opensearch.search.aggregations.bucket.histogram;
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
import org.opensearch.search.aggregations.AggregationBuilder;
                w.addDocument(new Document());
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
    public void testIncorrectFieldType() throws Exception {  
                w.addDocument(doc);  
            Document document = new Document();  
        }  
import org.apache.lucene.document.Document;
 * Modifications Copyright OpenSearch Contributors. See
                Document doc = new Document();
                InternalHistogram.Bucket outerBucket = outer.getBuckets().get(outerIdx);
                IndexSearcher searcher = new IndexSearcher(reader);  
                    assertThat(innerBucket.getKey(), equalTo(5.0 * innerIdx));
                assertEquals(0d, histogram.getBuckets().get(1).getKey());  
 * license agreements. See the NOTICE file distributed with
                IndexSearcher searcher = new IndexSearcher(reader);
    }
            }
            try (IndexReader reader = w.getReader()) {  
            }
                InternalHistogram inner = outerBucket.getAggregations().get("inner");
    /**
                assertEquals(1, histogram.getBuckets().get(5).getDocCount());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("my_agg").field("field").interval(5);
                assertEquals(-5d, histogram.getBuckets().get(1).getKey());  
            indexWriter.addDocument(List.of(new SortedNumericDocValuesField("field", 7)));
    }  
                document.add(new SortedNumericDocValuesField(fieldName, instant));  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                );
                assertEquals(7, histogram.getBuckets().get(0).getDocCount());  
                assertEquals(-10d, histogram.getBuckets().get(0).getKey());
                Document doc = new Document();
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);  
                assertEquals(0, histogram.getBuckets().get(0).getDocCount());
                IndexSearcher searcher = new IndexSearcher(reader);
     * Numeric histogram has no filter-rewrite fast path (it collects doc-by-doc, which is naturally  
    public void testExtendedBounds() throws Exception {
                doc.add(new SortedNumericDocValuesField("field", value));
            try (IndexReader reader = w.getReader()) {
            MappedFieldType type = null;
                assertEquals(1, histogram.getBuckets().get(3).getDocCount());
        try (Directory dir = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), dir)) {
import org.apache.lucene.search.IndexSearcher;  
    public void testMissing() throws Exception {
                assertEquals(2, histogram.getBuckets().get(0).getDocCount());
            for (long value : new long[] { 7, 3, -10, -6, 5, 15 }) {
                assertEquals(5d, histogram.getBuckets().get(4).getKey());
                w.addDocument(doc);
            try (IndexReader reader = w.getReader()) {  
                IndexSearcher searcher = new IndexSearcher(reader);  
            for (long value : new long[] { 7, 3, -10, -6, 5, 50 }) {
                Document doc = new Document();
            }  
                assertEquals(10d, histogram.getBuckets().get(4).getKey());
                .interval(5)
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                w.addDocument(doc);
            final double expectedOffset = offset % interval;  
                .missing(missingValue);
        };
                Document doc = new Document();
                assertEquals(2, histogram.getBuckets().size());  
                assertEquals(0, histogram.getBuckets().get(5).getDocCount());
    public void testSupportsIntraSegmentSearch() throws IOException {
    public void testAsSubAgg() throws IOException {
            try (IndexReader reader = w.getReader()) {
                docs.add(
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(-3 * Math.PI, histogram.getBuckets().get(1).getKey());  
                assertEquals(0, histogram.getBuckets().get(2).getDocCount());  
import org.apache.lucene.store.Directory;
                assertEquals(-15d, histogram.getBuckets().get(0).getKey());  
        }  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.index.mapper.DateFieldMapper;
}
                assertEquals(0d, histogram.getBuckets().get(3).getKey());  
            }
            "2019-11-06T13:09:32",
 * not use this file except in compliance with the License.
                assertEquals(2, histogram.getBuckets().get(3).getDocCount());
            try (IndexReader reader = w.getReader()) {  
                doc.add(new SortedNumericDocValuesField("field", value));  
            try (IndexReader reader = w.getReader()) {
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertEquals(4, histogram.getBuckets().size());
        }
            }  
            "2019-11-04T05:11:31",
            for (int i = 0; i < 7; i++) {  
    }  
                InternalHistogram histogram = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, doubleField("field"));
                assertEquals(-10 + expectedOffset, histogram.getBuckets().get(0).getKey());  
import java.util.Arrays;
                assertEquals(5 + Math.PI, histogram.getBuckets().get(3).getKey());  
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(6, histogram.getBuckets().size());
                assertEquals(-5d, histogram.getBuckets().get(1).getKey());
                w.addDocument(doc);
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));  
                assertEquals(-2 * Math.PI, histogram.getBuckets().get(2).getKey());
            }  
                Document doc = new Document();
    }
                IndexSearcher searcher = new IndexSearcher(reader);  
    }  
                }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
                w.addDocument(doc);  
