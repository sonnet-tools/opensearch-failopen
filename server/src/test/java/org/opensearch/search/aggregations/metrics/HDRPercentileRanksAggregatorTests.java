            assertEquals(0.5, rank.getValue(), 0d);
    }
 * SPDX-License-Identifier: Apache-2.0
                rank = rankIterator.next();
import org.apache.lucene.store.Directory;
 *
                w.addDocument(doc);
 * license agreements. See the NOTICE file distributed with
    public void testNullValues() throws IOException {
 * Unless required by applicable law or agreed to in writing,
import org.hamcrest.Matchers;
                .method(PercentilesMethod.HDR);
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));
import org.opensearch.search.aggregations.AggregationBuilder;  
                assertEquals(12, rank.getValue(), 0d);  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                rank = rankIterator.next();
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.util.NumericUtils;  
            () -> new PercentileRanksAggregationBuilder("my_agg", new double[0]).field("field").method(PercentilesMethod.HDR)
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(  
        try (IndexReader reader = new MultiReader()) {
import org.apache.lucene.index.IndexReader;  
    public void testEmptyValues() throws IOException {
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
                Percentile rank = rankIterator.next();
        assertThat(e.getMessage(), Matchers.equalTo("[values] must not be null: [my_agg]"));
 * under the License.  
            assertEquals(Double.NaN, rank.getPercent(), 0d);  
                PercentileRanks ranks = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                assertEquals(0.1, rank.getValue(), 0d);
    public void testEmpty() throws IOException {
            IndexSearcher searcher = new IndexSearcher(reader);  
    @Override
            .method(PercentilesMethod.HDR);  
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {  
 * this work for additional information regarding copyright
        PercentileRanksAggregationBuilder aggBuilder = new PercentileRanksAggregationBuilder("my_agg", new double[] { 0.5 }).field("field")
public class HDRPercentileRanksAggregatorTests extends AggregatorTestCase {  
 * compatible open source license.
        }  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
 * this file be licensed under the Apache-2.0 license or a
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * KIND, either express or implied.  See the License for the
}  
import org.opensearch.index.mapper.MappedFieldType;
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(0.5, rank.getValue(), 0d);
            }  
        );  
        }
import java.io.IOException;
 * GitHub history for details.
        );
                IndexSearcher searcher = new IndexSearcher(reader);
                assertThat(rank.getPercent(), Matchers.greaterThan(0d));  
 * not use this file except in compliance with the License.
import org.apache.lucene.tests.index.RandomIndexWriter;
import java.util.List;
    }  
                assertThat(rank.getPercent(), Matchers.equalTo(0d));  
    public void testSimple() throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
                Document doc = new Document();  
            PercentileRanks ranks = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
    }  
            .percentilesConfig(new PercentilesConfig.Hdr());
import org.opensearch.search.aggregations.AggregatorTestCase;
            MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
 * The OpenSearch Contributors require contributions made to  
 *
import org.apache.lucene.search.IndexSearcher;
            PercentileRanksAggregationBuilder aggBuilder = new PercentileRanksAggregationBuilder("my_agg", new double[] { 0.1, 0.5, 12 })
                assertThat(rank.getPercent(), Matchers.equalTo(100d));
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        IllegalArgumentException e = expectThrows(
            for (double value : new double[] { 3, 0.2, 10 }) {
 * You may obtain a copy of the License at  
 */  
import org.apache.lucene.search.MatchAllDocsQuery;  
import java.util.Iterator;  
            assertFalse(AggregationInspectionHelper.hasValue((InternalHDRPercentileRanks) ranks));
            }
import org.opensearch.search.aggregations.support.ValuesSourceType;
package org.opensearch.search.aggregations.metrics;
        assertThat(e.getMessage(), Matchers.equalTo("[values] must not be an empty array: [my_agg]"));
import org.apache.lucene.document.Document;
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
                assertThat(rank.getPercent(), Matchers.lessThan(100d));
            () -> new PercentileRanksAggregationBuilder("my_agg", null).field("field").method(PercentilesMethod.HDR)
import org.apache.lucene.document.SortedNumericDocValuesField;
 * software distributed under the License is distributed on an
                assertTrue(AggregationInspectionHelper.hasValue((InternalHDRPercentileRanks) ranks));  
            Percentile rank = ranks.iterator().next();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.NumberFieldMapper;
/*  
    @Override
    }
                .field("field")  
            IllegalArgumentException.class,  
                Iterator<Percentile> rankIterator = ranks.iterator();  
/*  
import java.util.Arrays;
        return new PercentileRanksAggregationBuilder("hdr_ranks", new double[] { 0.1, 0.5, 12 }).field(fieldName)
    }
 */  
import org.apache.lucene.index.MultiReader;
            try (IndexReader reader = w.getReader()) {  
                assertFalse(rankIterator.hasNext());
/*
