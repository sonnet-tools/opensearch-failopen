        }
        // Deserialize
            int numDocs = scaledRandomIntBetween(8192, 16384);
                assertNull(stats.getStats());
                multiPassStats.assertNearlyEqual(stats);
 * under the License.
import org.apache.lucene.document.Field;
                    .multiValueMode(MultiValueMode.MIN);
        assertNotEquals(agg1, agg3);
import java.util.Arrays;
            .multiValueMode(MultiValueMode.AVG);
    public void testTwoFields() throws Exception {
    public void testSerializationDeserialization() throws IOException {
import org.apache.lucene.tests.index.RandomIndexWriter;
            .multiValueMode(MultiValueMode.MIN);
 *
            }
            try (IndexReader reader = indexWriter.getReader()) {
    }
    }
        String field = "grades";
import org.apache.lucene.document.SortedNumericDocValuesField;
        return Collections.singletonList(new MatrixAggregationModulePlugin());
    public void testNoData() throws Exception {
    }
        out.setVersion(Version.V_3_1_0);
                MatrixStatsAggregationBuilder aggBuilder = new MatrixStatsAggregationBuilder("my_agg").fields(
/*
import org.opensearch.index.mapper.NumberFieldMapper;
                assertNull(stats.getStats());
        BytesStreamOutput out = new BytesStreamOutput();
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
        MappedFieldType ftB = new NumberFieldMapper.NumberFieldType(fieldB, NumberFieldMapper.NumberType.DOUBLE);
        // Serialize with V_2_3_0 (fallback required)
}
                );
import org.apache.lucene.index.IndexReader;
        MatrixStatsAggregationBuilder agg3 = new MatrixStatsAggregationBuilder("agg").fields(Collections.singletonList("field"))
            }
        in.setVersion(Version.V_2_3_0);
                document.add(new SortedNumericDocValuesField(fieldB, NumericUtils.doubleToSortableLong(fieldBValues[docId])));
            if (randomBoolean()) {
            }
    @Override
import org.apache.lucene.util.NumericUtils;
    }
    public void testEqualsAndHashCode() {
 * specific language governing permissions and limitations
                InternalMatrixStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ft);
        assertEquals(MultiValueMode.AVG, deserialized.multiValueMode());
import org.opensearch.search.aggregations.AggregatorTestCase;
            indexWriter.addDocument(doc);
                InternalMatrixStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ft);
 * Unless required by applicable law or agreed to in writing,
            for (int docId = 0; docId < numDocs; docId++) {
import org.apache.lucene.document.Document;
        assertEquals(original.getName(), deserialized.getName());
    public void testDeserializationFallbackToAvg() throws IOException {
                assertEquals(0L, stats.getDocCount());
                indexWriter.addDocument(Collections.singleton(new StringField("another_field", "value", Field.Store.NO)));
                indexWriter.addDocument(document);
            doc.add(new SortedNumericDocValuesField(field, NumericUtils.doubleToSortableLong(5.0)));
import org.apache.lucene.search.IndexSearcher;
                InternalMatrixStats minStats = searchAndReduce(searcher, new MatchAllDocsQuery(), minAgg, ft);
/*
        BytesStreamOutput out = new BytesStreamOutput();
            try (IndexReader reader = indexWriter.getReader()) {
        MatrixStatsAggregationBuilder original = new MatrixStatsAggregationBuilder("test").fields(Collections.singletonList("field"));
        MatrixStatsAggregationBuilder deserialized = new MatrixStatsAggregationBuilder(in);
                InternalMatrixStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ftA, ftB);
                IndexSearcher searcher = new IndexSearcher(reader);
public class MatrixStatsAggregatorTests extends AggregatorTestCase {
        MatrixStatsAggregationBuilder deserialized = new MatrixStatsAggregationBuilder(in);
        assertEquals(original.multiValueMode(), deserialized.multiValueMode());
                IndexSearcher searcher = new IndexSearcher(reader);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
                    .multiValueMode(MultiValueMode.AVG);
            Double[] fieldAValues = new Double[numDocs];
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        original.writeTo(out);
                IndexSearcher searcher = new IndexSearcher(reader);
 *
            try (IndexReader reader = indexWriter.getReader()) {
    }
            }
 * The OpenSearch Contributors require contributions made to
        assertEquals(original.fields(), deserialized.fields());
                fieldBValues[docId] = randomDouble();
                MatrixStatsAggregationBuilder aggBuilder = new MatrixStatsAggregationBuilder("my_agg").fields(
                MatrixStatsAggregationBuilder avgAgg = new MatrixStatsAggregationBuilder("avg_agg").fields(Collections.singletonList(field))
                assertNotEquals("AVG and MIN mode should yield different means", avg, min, 0.0001);
    public void testUnmapped() throws Exception {
        // hashCode
            .multiValueMode(MultiValueMode.MIN);
                double min = minStats.getMean(field);
                assertTrue(MatrixAggregationInspectionHelper.hasValue(stats));
 * KIND, either express or implied.  See the License for the
                double avg = avgStats.getMean(field);
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.search.MatchAllDocsQuery;
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
                    Collections.singletonList("bogus")
        MatrixStatsAggregationBuilder agg2 = new MatrixStatsAggregationBuilder("agg").fields(Collections.singletonList("field"))
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(agg1, agg2);
    }
 * GitHub history for details.
        StreamInput in = out.bytes().streamInput();
            if (randomBoolean()) {
                );
        String fieldA = "a";
        original.writeTo(out);
                MatrixStatsAggregationBuilder aggBuilder = new MatrixStatsAggregationBuilder("my_agg").fields(
        out.setVersion(Version.V_2_3_0);
import org.opensearch.Version;
    }
                InternalMatrixStats avgStats = searchAndReduce(searcher, new MatchAllDocsQuery(), avgAgg, ft);
        }
            Document doc = new Document();
 * Modifications Copyright OpenSearch Contributors. See
        }
 * compatible open source license.
package org.opensearch.search.aggregations.matrix.stats;
 * software distributed under the License is distributed on an
        in.setVersion(Version.V_3_1_0);
    }
            }
            }
        String fieldB = "b";
                fieldAValues[docId] = randomDouble();
import org.opensearch.index.mapper.MappedFieldType;
        StreamInput in = out.bytes().streamInput();
                IndexSearcher searcher = new IndexSearcher(reader);
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.StringField;
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            MultiPassStats multiPassStats = new MultiPassStats(fieldA, fieldB);
 */
        // equals
import org.opensearch.search.MultiValueMode;
    protected List<SearchPlugin> getSearchPlugins() {
        assertNotEquals(agg1.hashCode(), agg3.hashCode());
            doc.add(new SortedNumericDocValuesField(field, NumericUtils.doubleToSortableLong(3.0)));
                    Arrays.asList(fieldA, fieldB)
 * this work for additional information regarding copyright
import java.util.Collections;
import org.opensearch.plugins.SearchPlugin;
        }
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    public void testMultiValueModeAffectsResult() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
            multiPassStats.computeStats(Arrays.asList(fieldAValues), Arrays.asList(fieldBValues));
/*
import org.apache.lucene.store.Directory;
 *
import java.io.IOException;
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.search.aggregations.matrix.MatrixAggregationModulePlugin;
                assertEquals(0L, stats.getDocCount());
                document.add(new SortedNumericDocValuesField(fieldA, NumericUtils.doubleToSortableLong(fieldAValues[docId])));
        MappedFieldType ftA = new NumberFieldMapper.NumberFieldType(fieldA, NumberFieldMapper.NumberType.DOUBLE);
        MatrixStatsAggregationBuilder agg1 = new MatrixStatsAggregationBuilder("agg").fields(Collections.singletonList("field"))
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
 */
                );
            try (IndexReader reader = indexWriter.getReader()) {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(agg1.hashCode(), agg2.hashCode());
import java.util.List;
            doc.add(new SortedNumericDocValuesField(field, NumericUtils.doubleToSortableLong(1.0)));
        // Serialize
                MatrixStatsAggregationBuilder minAgg = new MatrixStatsAggregationBuilder("min_agg").fields(Collections.singletonList(field))
                indexWriter.addDocument(Collections.singleton(new StringField("another_field", "value", Field.Store.NO)));
                    Collections.singletonList("field")
            Double[] fieldBValues = new Double[numDocs];
        MatrixStatsAggregationBuilder original = new MatrixStatsAggregationBuilder("test").fields(Collections.singletonList("field"))
            .multiValueMode(MultiValueMode.AVG);
            }
                Document document = new Document();
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType(field, NumberFieldMapper.NumberType.DOUBLE);
