        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
import org.apache.lucene.search.TermQuery;
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;  
        indexWriterConfig.setMaxBufferedDocs(100);  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.bucket.sampler;
        }
                }
                );
                StringBuilder text = new StringBuilder();
        MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType("int", NumberFieldMapper.NumberType.LONG);
                Min min = sampler.getAggregations().get("min");
                assertEquals("test expects a single segment", 1, reader.leaves().size());
            for (long value : new long[] { 7, 3, -10, -6, 5, 50 }) {  
                    numericFieldType  
                    new TermQuery(new Term("text", "good")),  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                doc.add(new SortedNumericDocValuesField("int", value));  
    }
import org.apache.lucene.store.Directory;  
}
     * Uses the sampler aggregation to find the minimum value of a field out of the top 3 scoring documents in a search.
                assertEquals(response.getBuckets().get(1).getDocCount(), 0);  
 * compatible open source license.
            SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").shardSize(3)
 *  
import org.apache.lucene.index.Term;
    public void testRidiculousSize() throws IOException {  
                IndexSearcher searcher = new IndexSearcher(reader);  
import org.apache.lucene.index.IndexWriterConfig;
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
            // Test with an outrageously large size to ensure that the maxDoc protection works
                w.addDocument(doc);
                assertTrue(AggregationInspectionHelper.hasValue(sampler));
                assertTrue(AggregationInspectionHelper.hasValue(sampler));
import org.opensearch.index.query.MatchNoneQueryBuilder;  
    public void testEmptyParentBucket() throws Exception {  
        }  
            }
                SamplerAggregationBuilder sampler = new SamplerAggregationBuilder("sampler").subAggregation(samplerChild);  
public class SamplerAggregatorTests extends AggregatorTestCase {  
 * Unless required by applicable law or agreed to in writing,
                    searcher,
            writer.addDocument(new Document());
import org.opensearch.search.aggregations.AggregatorTestCase;
                for (int i = 0; i < value; i++) {  
                QueryBuilder[] filters = new QueryBuilder[] { new MatchAllQueryBuilder(), new MatchNoneQueryBuilder() };  
                .subAggregation(new MinAggregationBuilder("min").field("int"));  
        try (Directory dir = newDirectory(); IndexWriter writer = new IndexWriter(dir, indexWriterConfig)) {
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.MappedFieldType;
     */
 * ownership. Elasticsearch licenses this file to you under  
                InternalSampler sampler = searchAndReduce(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
 * this work for additional information regarding copyright
                    numericFieldType  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                .subAggregation(new MinAggregationBuilder("min").field("int"));  
import org.apache.lucene.search.IndexSearcher;  
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment with predictable docIds
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(response.getBuckets().get(0).getDocCount(), 1);
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            for (long value : new long[] { 7, 3, -10, -6, 5, 50 }) {
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
                    searcher,
 */  
        TextFieldType textFieldType = new TextFieldType("text");
                }
            SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").shardSize(Integer.MAX_VALUE)
                    textFieldType,
import org.apache.lucene.search.MatchAllDocsQuery;
                assertEquals("test expects a single segment", 1, reader.leaves().size());
                assertEquals(3.0, min.getValue(), 0);  
 * under the License.  
     */  
     * Tests that the sampler aggregation works correctly if the parent bucket does not contain any hit.
                doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));  
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                FiltersAggregationBuilder samplerParent = new FiltersAggregationBuilder("filters", filters);
                doc.add(new SortedNumericDocValuesField("int", value));
 * this file be licensed under the Apache-2.0 license or a
                    new TermQuery(new Term("text", "good")),  
                );
                w.addDocument(doc);
import org.opensearch.index.query.QueryBuilder;
import org.apache.lucene.index.DirectoryReader;
    /**  
/*
                doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));
import org.opensearch.index.mapper.TextFieldMapper;  
                    text.append("good ");
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment with predictable docIds  
                    aggBuilder,
 * You may obtain a copy of the License at  
/*  
 */  
        indexWriterConfig.setMaxBufferedDocs(100);
        }  
import org.apache.lucene.document.Document;
 * software distributed under the License is distributed on an
            }  
import java.io.IOException;
            try (IndexReader reader = DirectoryReader.open(w)) {
            }
                    text.append("good ");  
import org.apache.lucene.index.IndexWriter;  
                StringBuilder text = new StringBuilder();
            }
                assertEquals(response.getBuckets().size(), 2);
 * specific language governing permissions and limitations
/*  
            try (IndexReader reader = DirectoryReader.open(w)) {
                TermsAggregationBuilder samplerChild = new TermsAggregationBuilder("child").field("field");
 * GitHub history for details.
 */
                assertEquals(5.0, min.getValue(), 0);  
        TextFieldType textFieldType = new TextFieldType("text");
                samplerParent.subAggregation(sampler);
import org.opensearch.index.mapper.NumberFieldMapper;
 *
                Document doc = new Document();  
import org.opensearch.search.aggregations.metrics.Min;  
                InternalFilters response = searchAndReduce(searcher, new MatchAllDocsQuery(), samplerParent);  
    public void testSampler() throws IOException {
                Document doc = new Document();
import org.apache.lucene.document.Field;
                IndexSearcher searcher = new IndexSearcher(reader);
    }  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    /**
            }
 * license agreements. See the NOTICE file distributed with
                Min min = sampler.getAggregations().get("min");
import org.apache.lucene.index.IndexReader;
 *
import org.opensearch.index.query.MatchAllQueryBuilder;
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                IndexSearcher searcher = new IndexSearcher(reader);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    aggBuilder,
import org.apache.lucene.document.SortedNumericDocValuesField;  
                    textFieldType,
                InternalSampler sampler = searchAndReduce(
            try (IndexReader reader = DirectoryReader.open(writer)) {  
                for (int i = 0; i < value; i++) {
        MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType("int", NumberFieldMapper.NumberType.LONG);  
