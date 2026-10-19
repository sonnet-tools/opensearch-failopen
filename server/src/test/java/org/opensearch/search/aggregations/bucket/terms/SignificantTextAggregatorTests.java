import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.DirectoryReader;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    }
    public void testIncludeExcludes() throws IOException {
                assertEquals("test expects a single segment", 1, reader.leaves().size());
                searchAndReduce(searcher, new TermQuery(new Term("text", "foo")), sigAgg, textFieldType);
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
 * specific language governing permissions and limitations
                assertNull(terms.getBucketByKey("even"));
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
            sigAgg.sourceFieldNames(Arrays.asList(new String[] { "title", "text" }));
                assertNotNull(sigEven.getBucketByKey("even"));
            TermsAggregationBuilder aggBuilder = new TermsAggregationBuilder("terms").field("kwd").subAggregation(sigAgg);
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
/*
                SamplerAggregationBuilder samplerAgg = sampler("sampler").subAggregation(agg);
import org.apache.lucene.search.IndexSearcher;
    @Override
            SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text");
            SignificantTextAggregationBuilder aliasAgg = significantText("sig_text", "text-alias").filterDuplicateText(true);
            }
 * the Apache License, Version 2.0 (the "License"); you may
     */
        indexWriterConfig.setMaxBufferedDocs(100);
        TextFieldType textFieldType = new TextFieldType("text");
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
 * under the License.
                    SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").subAggregation(sigAgg);
                    assertNotNull(terms.getBucketByKey("even"));
            indexDocuments(w);
                    if (randomBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.sampler;
import java.util.Map;
                    // Search "even" which should have duplication
            if (i % 2 == 0) {
                assertFalse(terms.getBuckets().isEmpty());
            CoreValuesSourceType.NUMERIC,
            }
                        sigAgg.sourceFieldNames(Arrays.asList(new String[] { "json_only_field" }));
                assertNull(sigEven.getBucketByKey("separator4"));
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.mapper.FlatObjectFieldMapper;
 * ownership. Elasticsearch licenses this file to you under
     * Test documents with arrays of text
                IndexSearcher searcher = new IndexSearcher(reader);
                assertEquals(terms, aliasTerms);
                assertNull(terms.getBucketByKey("common"));
import org.opensearch.search.aggregations.support.ValuesSourceType;
            indexDocuments(w);
                    SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").includeExclude(
            String json = "{ \"text\" : \"" + text.toString() + "\"," + " \"json_only_field\" : \"" + text.toString() + "\"" + " }";
                assertNotNull(terms.getBucketByKey("even"));
import java.io.IOException;
        }
 */
                assertNull(terms.getBucketByKey("separator4"));
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
            FlatObjectFieldMapper.CONTENT_TYPE, // flat_object fields are not supported aggregations
            StringBuilder text = new StringBuilder("common ");
                assertNull(sigEven.getBucketByKey("duplicate"));
        indexWriterConfig.setMaxBufferedDocs(100);
}
 * not use this file except in compliance with the License.
                aliasSampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aliasSamplerAgg, textFieldType);
                        sigAgg.sourceFieldNames(Arrays.asList(new String[] { "json_only_field" }));
 * You may obtain a copy of the License at
                    textFieldType
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
import java.util.stream.Collectors;
                        new IncludeExclude(incExcValues, null)
    public void testFieldAlias() throws IOException {
                    SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").subAggregation(sigAgg);
            doc.add(new SortedSetDocValuesField("kwd", i % 2 == 0 ? new BytesRef("even") : new BytesRef("odd")));
import org.apache.lucene.document.Field;
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                // Inclusive of values
    }
 *
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
import org.apache.lucene.index.IndexReader;
 *
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
            ConstantKeywordFieldMapper.CONTENT_TYPE, // binary fields are not supported because they do not have analyzers
                SamplerAggregationBuilder aliasSamplerAgg = sampler("sampler").subAggregation(aliasAgg);
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                    // Search "even" which should have duplication
        }
            SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").filterDuplicateText(true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
                SignificantTerms terms = sampler.getAggregations().get("sig_text");
                assertNull(sigEven.getBucketByKey("odd"));
                doc.add(new StoredField("_source", new BytesRef(json)));
    /**
                assertNull(sigOdd.getBucketByKey("common"));
                    assertNotNull(terms.getBucketByKey("duplicate"));
        // TODO it is likely accidental that SigText supports anything other than Bytes, and then only text fields
            doc.add(new StoredField("_source", new BytesRef(json)));
    @Override
            try (IndexReader reader = DirectoryReader.open(w)) {
import org.opensearch.index.mapper.MappedFieldType;
     * Uses the significant text aggregation to find the keywords in text fields and include/exclude selected terms
        );
            try (IndexReader reader = DirectoryReader.open(w)) {
 */
import org.apache.lucene.index.IndexWriterConfig;
        return Arrays.asList(
                text.append("even separator" + i + " duplicate duplicate duplicate duplicate duplicate duplicate ");
                {
            CoreValuesSourceType.BYTES,
            try (IndexReader reader = DirectoryReader.open(w)) {
            indexDocuments(w);
 *
                sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), samplerAgg, textFieldType);
                    aliasSamplerAgg,
                assertNotNull(terms.getBucketByKey("odd"));
     */
        indexWriterConfig.setMaxBufferedDocs(100);
import org.opensearch.index.mapper.ConstantKeywordFieldMapper;
                // Search "odd" which should have no duplication
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                assertEquals("test expects a single segment", 1, reader.leaves().size());
            }
        }
    }
            if (randomBoolean()) {
                assertNull(sigOdd.getBucketByKey("even"));
                assertNull(terms.getBucketByKey("odd"));
                IndexSearcher searcher = new IndexSearcher(reader);
        TextFieldType textFieldType = new TextFieldType("text");
    @Override
 * Unless required by applicable law or agreed to in writing,
            SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").filterDuplicateText(true);
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
            for (int i = 0; i < 10; i++) {
            Document doc = new Document();
                assertNull(sigEven.getBucketByKey("separator6"));
        for (int i = 0; i < 10; i++) {
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
                    );
                assertNull(sigEven.getBucketByKey("common"));
    private void indexDocuments(IndexWriter writer) throws IOException {
    }
            if (randomBoolean()) {
            }
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
/*
    }
 * compatible open source license.
            BinaryFieldMapper.CONTENT_TYPE, // binary fields are not supported because they do not have analyzers
                Document doc = new Document();
     * Uses the significant text aggregation to find the keywords in text fields
            try (IndexReader reader = DirectoryReader.open(w)) {
            } else {
                    SignificantTerms terms = sampler.getAggregations().get("sig_text");
                assertNull(sigOdd.getBucketByKey("duplicate"));
 * this work for additional information regarding copyright
                String json = "{ \"text\" : [\"foo\",\"foo\"], \"title\" : [\"foo\", \"foo\"]}";
import java.util.function.Function;
            try (IndexReader reader = DirectoryReader.open(w)) {
package org.opensearch.search.aggregations.bucket.terms;
                InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), aggBuilder, textFieldType);
import org.apache.lucene.document.SortedSetDocValuesField;
import org.opensearch.index.mapper.HllFieldMapper;
    }
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
                    assertNull(terms.getBucketByKey("duplicate"));
            writer.addDocument(doc);
                // Search "even" which will have duplication
import org.apache.lucene.document.Document;
    }
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
    public void testSignificance() throws IOException {
                sigAgg.sourceFieldNames(Arrays.asList(new String[] { "json_only_field" }));
    }
                assertEquals("test expects a single segment", 1, reader.leaves().size());
                agg.sourceFieldNames(sourceFieldNames);
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
            CoreValuesSourceType.GEOPOINT
            indexDocuments(w);
                SignificantStringTerms sigEven = terms.getBucketByKey("even").getAggregations().get("sig_text");
import org.apache.lucene.search.MatchAllDocsQuery;
                        new IncludeExclude(null, incExcValues)
                // with the internal exception discovered in issue https://github.com/elastic/elasticsearch/issues/25029
    /**
                }
    /**
                assertNull(terms.getBucketByKey("separator6"));
                IndexSearcher searcher = new IndexSearcher(reader);
import org.opensearch.index.analysis.AnalyzerScope;
                    }
 * Modifications Copyright OpenSearch Contributors. See
                text.append("odd ");
        );
                aliasTerms = aliasSampler.getAggregations().get("sig_text");
            SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").subAggregation(sigAgg);
    }
                InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), samplerAgg, textFieldType);
                    SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").includeExclude(
                assertNotNull(sigOdd.getBucketByKey("odd"));
                // Exclusive of values
                assertNull(sigEven.getBucketByKey("separator2"));
                assertEquals(terms, aliasTerms);
                );
                IndexSearcher searcher = new IndexSearcher(reader);
            CoreValuesSourceType.RANGE,
        return new SignificantTextAggregationBuilder("foo", fieldName);
            SignificantTextAggregationBuilder agg = significantText("sig_text", "text").filterDuplicateText(true);
 * Licensed to Elasticsearch under one or more contributor
        indexWriterConfig.setMaxBufferedDocs(100);
import org.apache.lucene.document.StoredField;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.search.aggregations.AggregationBuilder;
                StringTerms terms = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, textFieldType, keywordField("kwd"));
                    searcher,
     */
            }
        indexWriterConfig.setMaxBufferedDocs(100);
    protected List<String> unsupportedMappedFieldTypes() {
import java.util.List;
 * GitHub history for details.
import org.opensearch.index.mapper.TextFieldMapper;
                    new TermQuery(new Term("text", "odd")),
import org.opensearch.index.mapper.BinaryFieldMapper;
                assertNull(terms.getBucketByKey("separator2"));
                doc.add(new Field("text", "foo", TextFieldMapper.Defaults.FIELD_TYPE));
                sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aggBuilder, textFieldType);
        }
/*
                SignificantTerms aliasTerms = aliasSampler.getAggregations().get("sig_text");
            }
        }
 * software distributed under the License is distributed on an
                assertTrue(AggregationInspectionHelper.hasValue(aliasSampler));
import java.util.Arrays;
import org.apache.lucene.index.Term;
                    );
                    if (randomBoolean()) {
                    }
import org.opensearch.search.aggregations.AggregatorTestCase;
                assertTrue(AggregationInspectionHelper.hasValue(sampler));
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
    public void testSignificanceOnTextArrays() throws IOException {
            }
                assertNull(terms.getBucketByKey("duplicate"));
import org.opensearch.index.mapper.GeoPointFieldMapper;
                }
                w.addDocument(doc);
            HllFieldMapper.CONTENT_TYPE // HLL fields are not supported for significant text aggregation
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
public class SignificantTextAggregatorTests extends AggregatorTestCase {
                {
                SignificantTerms terms = sampler.getAggregations().get("sig_text");
                assertTrue(AggregationInspectionHelper.hasValue(sampler));
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            GeoPointFieldMapper.CONTENT_TYPE, // geopoint fields cannot use term queries
                assertEquals("test expects a single segment", 1, reader.leaves().size());
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
import org.apache.lucene.util.BytesRef;
        }
                    assertNull(terms.getBucketByKey("even"));
import static org.opensearch.search.aggregations.AggregationBuilders.significantText;
                assertEquals("test expects a single segment", 1, reader.leaves().size());
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                    SignificantTerms terms = sampler.getAggregations().get("sig_text");
import org.apache.lucene.store.Directory;
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
                terms = sampler.getAggregations().get("sig_text");
 */
                assertFalse(terms.getBuckets().isEmpty());
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
        return Arrays.asList(
import org.apache.lucene.search.TermQuery;
                InternalSampler aliasSampler = searchAndReduce(
        TextFieldType textFieldType = new TextFieldType("text");
                assertNull(terms.getBucketByKey("common"));
    public void testInsideTermsAgg() throws IOException {
            }
                    assertTrue(AggregationInspectionHelper.hasValue(sampler));
        TextFieldType textFieldType = new TextFieldType("text");
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                    InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aggBuilder, textFieldType);
        TextFieldType textFieldType = new TextFieldType("text");
                IndexSearcher searcher = new IndexSearcher(reader);
                SignificantTerms sigOdd = terms.getBucketByKey("odd").getAggregations().get("sig_text");
            }
 * The OpenSearch Contributors require contributions made to
                // No significant results to be found in this test - only checking we don't end up
    }
            doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));
                    InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aggBuilder, textFieldType);
                assertNull(terms.getBucketByKey("duplicate"));
    /**
            String[] incExcValues = { "duplicate" };
                aliasAgg.sourceFieldNames(sourceFieldNames);
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
                    assertTrue(AggregationInspectionHelper.hasValue(sampler));
                List<String> sourceFieldNames = Arrays.asList(new String[] { "json_only_field" });
import org.opensearch.index.analysis.NamedAnalyzer;
                terms = sampler.getAggregations().get("sig_text");
