     */
                assertNull(terms.getBucketByKey("duplicate"));
            CoreValuesSourceType.NUMERIC,  
}  
                agg.sourceFieldNames(sourceFieldNames);
                    textFieldType
            String[] incExcValues = { "duplicate" };  
import java.util.stream.Collectors;  
                // Search "even" which will have duplication
    /**
                    InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aggBuilder, textFieldType);
                    SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").includeExclude(
                // No significant results to be found in this test - only checking we don't end up
public class SignificantTextAggregatorTests extends AggregatorTestCase {
            }
        }  
                // Search "odd" which should have no duplication
     */
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment  
                assertNull(sigEven.getBucketByKey("odd"));
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
            SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").filterDuplicateText(true);
                assertNull(sigOdd.getBucketByKey("duplicate"));
import java.util.List;  
                SamplerAggregationBuilder aliasSamplerAgg = sampler("sampler").subAggregation(aliasAgg);
                    assertNotNull(terms.getBucketByKey("duplicate"));
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
import org.opensearch.index.mapper.HllFieldMapper;
 * license agreements. See the NOTICE file distributed with
                    assertNotNull(terms.getBucketByKey("even"));
import org.opensearch.index.analysis.NamedAnalyzer;
                // Inclusive of values  
    /**
            SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").filterDuplicateText(true);
            try (IndexReader reader = DirectoryReader.open(w)) {  
 *  
                        new IncludeExclude(null, incExcValues)  
    @Override
 * KIND, either express or implied.  See the License for the
                    new TermQuery(new Term("text", "odd")),  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
            try (IndexReader reader = DirectoryReader.open(w)) {
    }  
/*  
 */  
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment  
                    SignificantTerms terms = sampler.getAggregations().get("sig_text");
            }  
 * this work for additional information regarding copyright
import org.apache.lucene.search.IndexSearcher;
                assertNull(terms.getBucketByKey("duplicate"));
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                assertNotNull(sigOdd.getBucketByKey("odd"));
import org.opensearch.index.mapper.TextFieldMapper;  
 * GitHub history for details.
                SignificantTerms sigOdd = terms.getBucketByKey("odd").getAggregations().get("sig_text");  
import org.opensearch.index.mapper.BinaryFieldMapper;  
/*  
import org.opensearch.search.aggregations.AggregationBuilder;
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment  
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
            try (IndexReader reader = DirectoryReader.open(w)) {
            sigAgg.sourceFieldNames(Arrays.asList(new String[] { "title", "text" }));
import org.apache.lucene.index.IndexReader;
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
            Document doc = new Document();
        );  
    private void indexDocuments(IndexWriter writer) throws IOException {  
                sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aggBuilder, textFieldType);  
            GeoPointFieldMapper.CONTENT_TYPE, // geopoint fields cannot use term queries
 * SPDX-License-Identifier: Apache-2.0
                InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), samplerAgg, textFieldType);  
     * Test documents with arrays of text
    }
            }
        for (int i = 0; i < 10; i++) {
                assertNull(sigOdd.getBucketByKey("common"));  
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();  
            if (i % 2 == 0) {
import org.apache.lucene.store.Directory;
                }
                assertNull(terms.getBucketByKey("common"));
        TextFieldType textFieldType = new TextFieldType("text");  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
                );  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
                assertEquals("test expects a single segment", 1, reader.leaves().size());
 *    http://www.apache.org/licenses/LICENSE-2.0
            indexDocuments(w);
                    SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").subAggregation(sigAgg);
                assertNull(terms.getBucketByKey("even"));  
    @Override
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                IndexSearcher searcher = new IndexSearcher(reader);
                aliasSampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aliasSamplerAgg, textFieldType);
                sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), samplerAgg, textFieldType);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testSignificanceOnTextArrays() throws IOException {  
    /**  
                assertEquals("test expects a single segment", 1, reader.leaves().size());
                SamplerAggregationBuilder samplerAgg = sampler("sampler").subAggregation(agg);  
                searchAndReduce(searcher, new TermQuery(new Term("text", "foo")), sigAgg, textFieldType);  
        indexWriterConfig.setMaxBufferedDocs(100);
    }
                    assertTrue(AggregationInspectionHelper.hasValue(sampler));  
                String json = "{ \"text\" : [\"foo\",\"foo\"], \"title\" : [\"foo\", \"foo\"]}";
            ConstantKeywordFieldMapper.CONTENT_TYPE, // binary fields are not supported because they do not have analyzers
                assertNull(sigEven.getBucketByKey("duplicate"));
 * software distributed under the License is distributed on an
                    InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), aggBuilder, textFieldType);
                assertEquals("test expects a single segment", 1, reader.leaves().size());  
                StringTerms terms = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, textFieldType, keywordField("kwd"));
                        sigAgg.sourceFieldNames(Arrays.asList(new String[] { "json_only_field" }));
            }  
                    aliasSamplerAgg,
                assertNull(terms.getBucketByKey("odd"));  
            } else {  
    }
 * The OpenSearch Contributors require contributions made to  
        TextFieldType textFieldType = new TextFieldType("text");
        TextFieldType textFieldType = new TextFieldType("text");
    }  
    /**  
import org.apache.lucene.index.Term;
                    assertTrue(AggregationInspectionHelper.hasValue(sampler));  
        return Arrays.asList(  
import static org.opensearch.search.aggregations.AggregationBuilders.sampler;
            }
                assertNull(terms.getBucketByKey("separator6"));
                    if (randomBoolean()) {  
                assertTrue(AggregationInspectionHelper.hasValue(aliasSampler));
                InternalSampler sampler = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), aggBuilder, textFieldType);  
            SignificantTextAggregationBuilder aliasAgg = significantText("sig_text", "text-alias").filterDuplicateText(true);  
    public void testInsideTermsAgg() throws IOException {  
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
                assertFalse(terms.getBuckets().isEmpty());
        );
                assertNull(sigEven.getBucketByKey("common"));  
                    if (randomBoolean()) {  
                doc.add(new StoredField("_source", new BytesRef(json)));  
import java.util.Arrays;
import org.apache.lucene.document.StoredField;
 *
    @Override
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
            doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));
                InternalSampler aliasSampler = searchAndReduce(
 */  
import org.opensearch.index.analysis.AnalyzerScope;
                assertEquals(terms, aliasTerms);
            try (IndexReader reader = DirectoryReader.open(w)) {
                {
            SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text");
                assertNull(terms.getBucketByKey("common"));
                IndexSearcher searcher = new IndexSearcher(reader);
        return Arrays.asList(
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
import org.opensearch.index.mapper.GeoPointFieldMapper;  
            StringBuilder text = new StringBuilder("common ");  
import java.util.Map;
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                aliasAgg.sourceFieldNames(sourceFieldNames);
            String json = "{ \"text\" : \"" + text.toString() + "\"," + " \"json_only_field\" : \"" + text.toString() + "\"" + " }";
     * Uses the significant text aggregation to find the keywords in text fields
                    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
        TextFieldType textFieldType = new TextFieldType("text");
            try (IndexReader reader = DirectoryReader.open(w)) {
            indexDocuments(w);  
                SignificantTerms terms = sampler.getAggregations().get("sig_text");
import org.apache.lucene.search.TermQuery;
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                text.append("even separator" + i + " duplicate duplicate duplicate duplicate duplicate duplicate ");
        }
import org.opensearch.index.mapper.MappedFieldType;
            }  
        }
        return new SignificantTextAggregationBuilder("foo", fieldName);
 * Licensed to Elasticsearch under one or more contributor  
        indexWriterConfig.setMaxBufferedDocs(100);
        }  
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                        sigAgg.sourceFieldNames(Arrays.asList(new String[] { "json_only_field" }));
                IndexSearcher searcher = new IndexSearcher(reader);  
        indexWriterConfig.setMaxBufferedDocs(100);  
                // with the internal exception discovered in issue https://github.com/elastic/elasticsearch/issues/25029
                    assertNull(terms.getBucketByKey("duplicate"));
                    SignificantTextAggregationBuilder sigAgg = new SignificantTextAggregationBuilder("sig_text", "text").includeExclude(
                List<String> sourceFieldNames = Arrays.asList(new String[] { "json_only_field" });  
        TextFieldType textFieldType = new TextFieldType("text");
                doc.add(new Field("text", "foo", TextFieldMapper.Defaults.FIELD_TYPE));
import org.apache.lucene.document.SortedSetDocValuesField;
            if (randomBoolean()) {
     */  
                terms = sampler.getAggregations().get("sig_text");
                assertNotNull(terms.getBucketByKey("even"));
    }
                    // Search "even" which should have duplication  
                assertNull(terms.getBucketByKey("separator2"));  
                assertTrue(AggregationInspectionHelper.hasValue(sampler));  
import org.apache.lucene.search.MatchAllDocsQuery;  
            HllFieldMapper.CONTENT_TYPE // HLL fields are not supported for significant text aggregation
            if (randomBoolean()) {
                assertTrue(AggregationInspectionHelper.hasValue(sampler));  
                    assertNull(terms.getBucketByKey("even"));
            }
                IndexSearcher searcher = new IndexSearcher(reader);
/*
import static org.opensearch.search.aggregations.AggregationBuilders.significantText;  
                    SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").subAggregation(sigAgg);
            CoreValuesSourceType.BYTES,
                    );
            for (int i = 0; i < 10; i++) {
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
                assertNull(terms.getBucketByKey("separator4"));
                assertNull(sigEven.getBucketByKey("separator2"));
    }
                IndexSearcher searcher = new IndexSearcher(reader);  
            SignificantTextAggregationBuilder agg = significantText("sig_text", "text").filterDuplicateText(true);
            CoreValuesSourceType.GEOPOINT  
                assertEquals("test expects a single segment", 1, reader.leaves().size());  
                assertFalse(terms.getBuckets().isEmpty());  
import org.opensearch.index.mapper.FlatObjectFieldMapper;
                {
    }
                terms = sampler.getAggregations().get("sig_text");
                assertNull(sigEven.getBucketByKey("separator4"));
            CoreValuesSourceType.RANGE,
        indexWriterConfig.setMaxBufferedDocs(100);
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
        // TODO it is likely accidental that SigText supports anything other than Bytes, and then only text fields
 * under the License.  
                // Exclusive of values  
                Document doc = new Document();  
                assertEquals(terms, aliasTerms);
            TermsAggregationBuilder aggBuilder = new TermsAggregationBuilder("terms").field("kwd").subAggregation(sigAgg);
import org.apache.lucene.index.DirectoryReader;  
            FlatObjectFieldMapper.CONTENT_TYPE, // flat_object fields are not supported aggregations  
                }
    }
                aliasTerms = aliasSampler.getAggregations().get("sig_text");
 * specific language governing permissions and limitations
    public void testSignificance() throws IOException {  
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                assertNotNull(sigEven.getBucketByKey("even"));
 *
            indexDocuments(w);
            doc.add(new SortedSetDocValuesField("kwd", i % 2 == 0 ? new BytesRef("even") : new BytesRef("odd")));
                sigAgg.sourceFieldNames(Arrays.asList(new String[] { "json_only_field" }));  
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
        }  
                assertEquals("test expects a single segment", 1, reader.leaves().size());
    public void testIncludeExcludes() throws IOException {
                assertNotNull(terms.getBucketByKey("odd"));  
            writer.addDocument(doc);
 */
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {  
import org.apache.lucene.document.Document;
        indexWriterConfig.setMaxBufferedDocs(100);
package org.opensearch.search.aggregations.bucket.terms;
            }
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
        }
                        new IncludeExclude(incExcValues, null)  
import org.apache.lucene.document.Field;  
            SamplerAggregationBuilder aggBuilder = new SamplerAggregationBuilder("sampler").subAggregation(sigAgg);
import org.apache.lucene.util.BytesRef;  
                SignificantTerms aliasTerms = aliasSampler.getAggregations().get("sig_text");  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    public void testFieldAlias() throws IOException {
import org.apache.lucene.index.IndexWriter;
                w.addDocument(doc);
    @Override  
    }
                assertNull(sigEven.getBucketByKey("separator6"));  
 * You may obtain a copy of the License at  
            BinaryFieldMapper.CONTENT_TYPE, // binary fields are not supported because they do not have analyzers
                text.append("odd ");
import org.opensearch.index.mapper.ConstantKeywordFieldMapper;
                    );
 * this file be licensed under the Apache-2.0 license or a
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
            doc.add(new StoredField("_source", new BytesRef(json)));  
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
     * Uses the significant text aggregation to find the keywords in text fields and include/exclude selected terms  
                    searcher,
            indexDocuments(w);
import org.opensearch.search.aggregations.AggregatorTestCase;  
                SignificantStringTerms sigEven = terms.getBucketByKey("even").getAggregations().get("sig_text");  
                SignificantTerms terms = sampler.getAggregations().get("sig_text");
import org.apache.lucene.index.IndexWriterConfig;  
import java.util.function.Function;
                    // Search "even" which should have duplication  
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));  
     */
                    }
 * the Apache License, Version 2.0 (the "License"); you may
                    SignificantTerms terms = sampler.getAggregations().get("sig_text");
            }
    protected List<String> unsupportedMappedFieldTypes() {
                assertNull(sigOdd.getBucketByKey("even"));
