public class SamplerAggregatorTests extends AggregatorTestCase {
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
                    text.append("good ");
                samplerParent.subAggregation(sampler);
import org.apache.lucene.index.IndexWriterConfig;
package org.opensearch.search.aggregations.bucket.sampler;
                );
                assertEquals(3.0, min.getValue(), 0);
import org.opensearch.search.aggregations.metrics.Min;
 * Unless required by applicable law or agreed to in writing,
            writer.addDocument(new Document());
        try (Directory dir = newDirectory(); IndexWriter writer = new IndexWriter(dir, indexWriterConfig)) {
                assertEquals(response.getBuckets().size(), 2);
 * this work for additional information regarding copyright
import org.opensearch.index.mapper.TextFieldMapper;
import org.apache.lucene.document.SortedNumericDocValuesField;
                }
                doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));
 * You may obtain a copy of the License at
                w.addDocument(doc);
                    textFieldType,
                }
            try (IndexReader reader = DirectoryReader.open(w)) {
 * under the License.
        indexWriterConfig.setMaxBufferedDocs(100);
            SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").shardSize(3)
import org.opensearch.index.query.MatchAllQueryBuilder;
            }
                IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.document.Field;
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment with predictable docIds
import org.opensearch.search.aggregations.AggregatorTestCase;
                    numericFieldType
                    aggBuilder,
        TextFieldType textFieldType = new TextFieldType("text");
    public void testRidiculousSize() throws IOException {
                for (int i = 0; i < value; i++) {
import org.apache.lucene.store.Directory;
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
            // Test with an outrageously large size to ensure that the maxDoc protection works
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                .subAggregation(new MinAggregationBuilder("min").field("int"));
                IndexSearcher searcher = new IndexSearcher(reader);
}
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                QueryBuilder[] filters = new QueryBuilder[] { new MatchAllQueryBuilder(), new MatchNoneQueryBuilder() };
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.MatchAllDocsQuery;
                doc.add(new SortedNumericDocValuesField("int", value));
                    numericFieldType
            }
     */
/*
            for (long value : new long[] { 7, 3, -10, -6, 5, 50 }) {
     */
            for (long value : new long[] { 7, 3, -10, -6, 5, 50 }) {
                InternalFilters response = searchAndReduce(searcher, new MatchAllDocsQuery(), samplerParent);
                    searcher,
                    searcher,
     * Tests that the sampler aggregation works correctly if the parent bucket does not contain any hit.
            SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").shardSize(Integer.MAX_VALUE)
                assertEquals("test expects a single segment", 1, reader.leaves().size());
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment with predictable docIds
                .subAggregation(new MinAggregationBuilder("min").field("int"));
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
 *
 * Licensed to Elasticsearch under one or more contributor
 * KIND, either express or implied.  See the License for the
                    new TermQuery(new Term("text", "good")),
            try (IndexReader reader = DirectoryReader.open(w)) {
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.document.Document;
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
 * ownership. Elasticsearch licenses this file to you under
                    aggBuilder,
 * specific language governing permissions and limitations
/*
                assertEquals(response.getBuckets().get(0).getDocCount(), 1);
    public void testEmptyParentBucket() throws Exception {
                Document doc = new Document();
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Uses the sampler aggregation to find the minimum value of a field out of the top 3 scoring documents in a search.
 * software distributed under the License is distributed on an
/*
                w.addDocument(doc);
                Min min = sampler.getAggregations().get("min");
        indexWriterConfig.setMaxBufferedDocs(100);
                assertTrue(AggregationInspectionHelper.hasValue(sampler));
    /**
    /**
                );
            }
                InternalSampler sampler = searchAndReduce(
import org.opensearch.index.query.QueryBuilder;
    }
                StringBuilder text = new StringBuilder();
 */
        }
import org.apache.lucene.index.IndexWriter;
                InternalSampler sampler = searchAndReduce(
 *
                SamplerAggregationBuilder sampler = new SamplerAggregationBuilder("sampler").subAggregation(samplerChild);
        }
                assertEquals("test expects a single segment", 1, reader.leaves().size());
 * The OpenSearch Contributors require contributions made to
                IndexSearcher searcher = new IndexSearcher(reader);
                    text.append("good ");
 * the Apache License, Version 2.0 (the "License"); you may
                Document doc = new Document();
import org.opensearch.index.mapper.NumberFieldMapper;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
                assertEquals(response.getBuckets().get(1).getDocCount(), 0);
            try (IndexReader reader = DirectoryReader.open(writer)) {
                doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                StringBuilder text = new StringBuilder();
    }
                assertEquals(5.0, min.getValue(), 0);
 *
 */
                assertTrue(AggregationInspectionHelper.hasValue(sampler));
                Min min = sampler.getAggregations().get("min");
                    new TermQuery(new Term("text", "good")),
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.MatchNoneQueryBuilder;
                for (int i = 0; i < value; i++) {
                doc.add(new SortedNumericDocValuesField("int", value));
import org.opensearch.index.mapper.MappedFieldType;
    }
        TextFieldType textFieldType = new TextFieldType("text");
        }
    public void testSampler() throws IOException {
                TermsAggregationBuilder samplerChild = new TermsAggregationBuilder("child").field("field");
                    textFieldType,
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.apache.lucene.index.Term;
        MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType("int", NumberFieldMapper.NumberType.LONG);
import org.apache.lucene.search.IndexSearcher;
            }
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
                FiltersAggregationBuilder samplerParent = new FiltersAggregationBuilder("filters", filters);
 * compatible open source license.
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.io.IOException;
        MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType("int", NumberFieldMapper.NumberType.LONG);
 * not use this file except in compliance with the License.
