    @Override
 * specific language governing permissions and limitations
            Percentile rank = ranks.iterator().next();
    public void testEmptyValues() throws IOException {
        assertThat(e.getMessage(), Matchers.equalTo("[values] must not be an empty array: [my_agg]"));
            try (IndexReader reader = w.getReader()) {  
            IndexSearcher searcher = new IndexSearcher(reader);  
 * The OpenSearch Contributors require contributions made to  
            () -> new PercentileRanksAggregationBuilder("my_agg", new double[0]).field("field").method(PercentilesMethod.TDIGEST)
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
import org.apache.lucene.search.IndexSearcher;
    public void testEmpty() throws IOException {
            assertEquals(Double.NaN, rank.getPercent(), 0d);  
            for (double value : new double[] { 3, 0.2, 10 }) {
            assertFalse(AggregationInspectionHelper.hasValue(((InternalTDigestPercentileRanks) ranks)));
            .percentilesConfig(new PercentilesConfig.TDigest());
    }  
            }  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                rank = rankIterator.next();
import org.apache.lucene.store.Directory;
import org.apache.lucene.tests.index.RandomIndexWriter;
        assertThat(e.getMessage(), Matchers.equalTo("[values] must not be null: [my_agg]"));
                rank = rankIterator.next();  
        PercentileRanksAggregationBuilder aggBuilder = new PercentileRanksAggregationBuilder("my_agg", new double[] { 0.5 }).field("field")
 * this file be licensed under the Apache-2.0 license or a
            PercentileRanks ranks = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                IndexSearcher searcher = new IndexSearcher(reader);
/*
                // https://github.com/elastic/elasticsearch/issues/14851
    @Override
import org.apache.lucene.index.MultiReader;
 */
import org.apache.lucene.document.Document;
    }  
                .field("field")  
import org.apache.lucene.document.SortedNumericDocValuesField;
 * under the License.  
    public void testSimple() throws IOException {  
import org.apache.lucene.index.IndexReader;  
    }
                w.addDocument(doc);
            assertEquals(0.5, rank.getValue(), 0d);
            () -> new PercentileRanksAggregationBuilder("my_agg", null).field("field").method(PercentilesMethod.TDIGEST)  
                doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));
import org.apache.lucene.search.MatchAllDocsQuery;  
                PercentileRanks ranks = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
 * not use this file except in compliance with the License.
/*  
 *
    }
 */  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
import java.util.Arrays;
    }  
 * this work for additional information regarding copyright
                // https://github.com/elastic/elasticsearch/issues/14851
/*  
            IllegalArgumentException.class,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
                assertEquals(0.5, rank.getValue(), 0d);
import java.util.Iterator;  
                // assertThat(rank.getPercent(), Matchers.equalTo(100d));
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.mapper.MappedFieldType;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Document doc = new Document();  
    }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                .method(PercentilesMethod.TDIGEST);
                // TODO: Fix T-Digest: this assertion should pass but we currently get ~15  
 * license agreements. See the NOTICE file distributed with
    public void testNullValues() throws IOException {  
            .method(PercentilesMethod.TDIGEST);  
 */  
import org.hamcrest.Matchers;
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
import org.apache.lucene.util.NumericUtils;  
import org.opensearch.search.aggregations.AggregatorTestCase;
 * compatible open source license.
            }
        }  
        IllegalArgumentException e = expectThrows(  
                // assertThat(rank.getPercent(), Matchers.equalTo(0d));
                Percentile rank = rankIterator.next();
            PercentileRanksAggregationBuilder aggBuilder = new PercentileRanksAggregationBuilder("my_agg", new double[] { 0.1, 0.5, 12 })
package org.opensearch.search.aggregations.metrics;
 * KIND, either express or implied.  See the License for the
                assertTrue(AggregationInspectionHelper.hasValue(((InternalTDigestPercentileRanks) ranks)));
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
import java.io.IOException;
 *  
}
import org.opensearch.search.aggregations.support.ValuesSourceType;
public class TDigestPercentileRanksAggregatorTests extends AggregatorTestCase {  
                // TODO: Fix T-Digest: this assertion should pass but we currently get ~59  
                assertEquals(12, rank.getValue(), 0d);
        );
                Iterator<Percentile> rankIterator = ranks.iterator();  
            IllegalArgumentException.class,
                assertThat(rank.getPercent(), Matchers.greaterThan(0d));
 *
        }  
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.search.aggregations.AggregationBuilder;  
 * GitHub history for details.
        );  
                assertFalse(rankIterator.hasNext());  
        IllegalArgumentException e = expectThrows(
                assertEquals(0.1, rank.getValue(), 0d);
            MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
        try (IndexReader reader = new MultiReader()) {
                assertThat(rank.getPercent(), Matchers.lessThan(100d));  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new PercentileRanksAggregationBuilder("tdigest_ranks", new double[] { 0.1, 0.5, 12 }).field(fieldName)
 * You may obtain a copy of the License at  
