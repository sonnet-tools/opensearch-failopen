                InternalMatrixStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ftA, ftB);  
import org.opensearch.search.aggregations.matrix.MatrixAggregationModulePlugin;  
            try (IndexReader reader = indexWriter.getReader()) {  
import org.apache.lucene.search.MatchAllDocsQuery;  
    public void testSerializationDeserialization() throws IOException {
        String fieldB = "b";
 * KIND, either express or implied.  See the License for the
    }
            try (IndexReader reader = indexWriter.getReader()) {
        assertEquals(agg1.hashCode(), agg2.hashCode());  
        original.writeTo(out);  
            }  
import org.apache.lucene.util.NumericUtils;  
 * compatible open source license.
/*
                IndexSearcher searcher = new IndexSearcher(reader);
            }
                );
 * not use this file except in compliance with the License.
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(MultiValueMode.AVG, deserialized.multiValueMode());  
            if (randomBoolean()) {
import java.util.Collections;
    }  
    public void testUnmapped() throws Exception {
            indexWriter.addDocument(doc);
            try (IndexReader reader = indexWriter.getReader()) {
        in.setVersion(Version.V_2_3_0);  
                );  
                assertEquals(0L, stats.getDocCount());
        MappedFieldType ftA = new NumberFieldMapper.NumberFieldType(fieldA, NumberFieldMapper.NumberType.DOUBLE);
import org.opensearch.index.mapper.MappedFieldType;
                multiPassStats.assertNearlyEqual(stats);
                MatrixStatsAggregationBuilder aggBuilder = new MatrixStatsAggregationBuilder("my_agg").fields(
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.document.StringField;  
        out.setVersion(Version.V_2_3_0);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
            doc.add(new SortedNumericDocValuesField(field, NumericUtils.doubleToSortableLong(5.0)));  
import java.io.IOException;
        assertEquals(agg1, agg2);
 */  
                fieldAValues[docId] = randomDouble();  
    }
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.apache.lucene.store.Directory;
        StreamInput in = out.bytes().streamInput();  
                MatrixStatsAggregationBuilder avgAgg = new MatrixStatsAggregationBuilder("avg_agg").fields(Collections.singletonList(field))  
            Double[] fieldBValues = new Double[numDocs];  
        String field = "grades";
 * ownership. Elasticsearch licenses this file to you under  
            if (randomBoolean()) {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType(field, NumberFieldMapper.NumberType.DOUBLE);  
                    Collections.singletonList("field")
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
        MappedFieldType ftB = new NumberFieldMapper.NumberFieldType(fieldB, NumberFieldMapper.NumberType.DOUBLE);  
import org.apache.lucene.document.Document;  
    }
                    .multiValueMode(MultiValueMode.MIN);
import org.opensearch.index.mapper.NumberFieldMapper;
            }  
        }
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            }
                document.add(new SortedNumericDocValuesField(fieldB, NumericUtils.doubleToSortableLong(fieldBValues[docId])));
 * specific language governing permissions and limitations
import org.apache.lucene.search.IndexSearcher;
 * Licensed to Elasticsearch under one or more contributor  
                IndexSearcher searcher = new IndexSearcher(reader);
    public void testNoData() throws Exception {  
            multiPassStats.computeStats(Arrays.asList(fieldAValues), Arrays.asList(fieldBValues));  
                MatrixStatsAggregationBuilder minAgg = new MatrixStatsAggregationBuilder("min_agg").fields(Collections.singletonList(field))  
        in.setVersion(Version.V_3_1_0);
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.Version;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                indexWriter.addDocument(Collections.singleton(new StringField("another_field", "value", Field.Store.NO)));  
    }
import org.apache.lucene.document.Field;
                InternalMatrixStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ft);
                    Collections.singletonList("bogus")
        out.setVersion(Version.V_3_1_0);
                assertNull(stats.getStats());
        }
    public void testTwoFields() throws Exception {
    }
        // equals
        MatrixStatsAggregationBuilder agg1 = new MatrixStatsAggregationBuilder("agg").fields(Collections.singletonList("field"))
import org.opensearch.core.common.io.stream.StreamInput;  
        StreamInput in = out.bytes().streamInput();
    protected List<SearchPlugin> getSearchPlugins() {
}
                assertTrue(MatrixAggregationInspectionHelper.hasValue(stats));
            }  
            int numDocs = scaledRandomIntBetween(8192, 16384);
        original.writeTo(out);  
        return Collections.singletonList(new MatrixAggregationModulePlugin());  
            Double[] fieldAValues = new Double[numDocs];
    @Override
        MatrixStatsAggregationBuilder original = new MatrixStatsAggregationBuilder("test").fields(Collections.singletonList("field"));
                double min = minStats.getMean(field);
import org.opensearch.search.aggregations.AggregatorTestCase;
            Document doc = new Document();  
            .multiValueMode(MultiValueMode.MIN);
        String fieldA = "a";  
        assertEquals(original.getName(), deserialized.getName());
    public void testMultiValueModeAffectsResult() throws Exception {
                indexWriter.addDocument(Collections.singleton(new StringField("another_field", "value", Field.Store.NO)));
 * the Apache License, Version 2.0 (the "License"); you may
                InternalMatrixStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ft);  
                double avg = avgStats.getMean(field);  
                InternalMatrixStats avgStats = searchAndReduce(searcher, new MatchAllDocsQuery(), avgAgg, ft);  
            }
 * GitHub history for details.
                assertNotEquals("AVG and MIN mode should yield different means", avg, min, 0.0001);  
                indexWriter.addDocument(document);
import org.opensearch.common.io.stream.BytesStreamOutput;
 *  
import org.opensearch.plugins.SearchPlugin;  
            }  
            try (IndexReader reader = indexWriter.getReader()) {
 *
                Document document = new Document();
 * under the License.  
            .multiValueMode(MultiValueMode.AVG);
        MatrixStatsAggregationBuilder deserialized = new MatrixStatsAggregationBuilder(in);
                IndexSearcher searcher = new IndexSearcher(reader);  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
        assertNotEquals(agg1.hashCode(), agg3.hashCode());
            .multiValueMode(MultiValueMode.MIN);
 * The OpenSearch Contributors require contributions made to  
    }  
        }
    public void testEqualsAndHashCode() {  
        MatrixStatsAggregationBuilder deserialized = new MatrixStatsAggregationBuilder(in);
        MatrixStatsAggregationBuilder agg2 = new MatrixStatsAggregationBuilder("agg").fields(Collections.singletonList("field"))
        // hashCode
                IndexSearcher searcher = new IndexSearcher(reader);
                document.add(new SortedNumericDocValuesField(fieldA, NumericUtils.doubleToSortableLong(fieldAValues[docId])));
        assertEquals(original.multiValueMode(), deserialized.multiValueMode());  
    public void testDeserializationFallbackToAvg() throws IOException {  
            for (int docId = 0; docId < numDocs; docId++) {
import org.apache.lucene.index.IndexReader;
 *
            doc.add(new SortedNumericDocValuesField(field, NumericUtils.doubleToSortableLong(1.0)));
 */
            MultiPassStats multiPassStats = new MultiPassStats(fieldA, fieldB);
                InternalMatrixStats minStats = searchAndReduce(searcher, new MatchAllDocsQuery(), minAgg, ft);
        // Serialize with V_2_3_0 (fallback required)  
            doc.add(new SortedNumericDocValuesField(field, NumericUtils.doubleToSortableLong(3.0)));
                    Arrays.asList(fieldA, fieldB)
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import java.util.Arrays;  
                assertEquals(0L, stats.getDocCount());  
                fieldBValues[docId] = randomDouble();  
 * this work for additional information regarding copyright
 */
        MatrixStatsAggregationBuilder original = new MatrixStatsAggregationBuilder("test").fields(Collections.singletonList("field"))  
                    .multiValueMode(MultiValueMode.AVG);
/*
    }
/*  
        assertEquals(original.fields(), deserialized.fields());
import org.opensearch.search.MultiValueMode;
 *    http://www.apache.org/licenses/LICENSE-2.0
                );
                MatrixStatsAggregationBuilder aggBuilder = new MatrixStatsAggregationBuilder("my_agg").fields(  
        assertNotEquals(agg1, agg3);  
 * SPDX-License-Identifier: Apache-2.0
        BytesStreamOutput out = new BytesStreamOutput();
            .multiValueMode(MultiValueMode.AVG);
 * You may obtain a copy of the License at  
        MatrixStatsAggregationBuilder agg3 = new MatrixStatsAggregationBuilder("agg").fields(Collections.singletonList("field"))
                MatrixStatsAggregationBuilder aggBuilder = new MatrixStatsAggregationBuilder("my_agg").fields(  
        // Deserialize
                assertNull(stats.getStats());
        // Serialize  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.tests.index.RandomIndexWriter;
package org.opensearch.search.aggregations.matrix.stats;
public class MatrixStatsAggregatorTests extends AggregatorTestCase {
