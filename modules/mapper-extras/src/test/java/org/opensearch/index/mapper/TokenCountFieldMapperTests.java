    public void testCountPositionsWithIncrements() throws IOException {
        checker.registerConflictCheck("enable_position_increments", b -> b.field("enable_position_increments", false));
 * specific language governing permissions and limitations
    public void testParseNullValue() throws Exception {  
 */  
     */
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    }
    protected Collection<Plugin> getPlugins() {
    }
 * ownership. Elasticsearch licenses this file to you under  
    }
        DocumentMapper mapper = createIndexWithTokenCountField(false);
                b.startObject("fields");
import org.opensearch.index.analysis.IndexAnalyzers;
                    {
        checker.registerConflictCheck("skip_list", b -> b.field("skip_list", true));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * compatible open source license.
import static org.hamcrest.Matchers.equalTo;
                b.field("type", "text");
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());  
        - count normal tokens with one increment
                        if (skiplist) {
        assertThat(TokenCountFieldMapper.countPositions(analyzer, "", "", true), equalTo(7));
 * The OpenSearch Contributors require contributions made to  
    }  
        }));
import java.util.List;
import org.apache.lucene.analysis.Analyzer;
                }
 * software distributed under the License is distributed on an
        checker.registerConflictCheck("store", b -> b.field("store", true));  
import org.apache.lucene.index.IndexableField;
/**
 */
            public TokenStreamComponents createComponents(String fieldName) {  
    }
 * Unless required by applicable law or agreed to in writing,
    private DocumentMapper createIndexWithTokenCountField(boolean skiplist) throws IOException {  
    }
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
        Token[] tokens = new Token[] { t1, t2, t3 };  
        analyzers.put("standard", standard);  
import org.apache.lucene.tests.analysis.CannedTokenStream;
    }
                return new TokenStreamComponents(new MockTokenizer(), tokenStream);
        IndexableField[] fields = doc.getFields("test.tc");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Test for {@link TokenCountFieldMapper}.
        NamedAnalyzer dflt = new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer());
        t1.setPositionIncrement(0);  
import org.apache.lucene.analysis.TokenStream;
    }
    }
        Collections.shuffle(Arrays.asList(tokens), random());
        b.field("type", "token_count").field("analyzer", "keyword");
     *  When position increments are not counted (only positions are counted), we're looking to make sure that we:
        - count normal tokens with one increment
            assertThat(tcfm.analyzer(), equalTo("standard"));
        Token t2 = new Token();
import java.util.HashMap;
    }  
    }  
 * this work for additional information regarding copyright
    protected void minimalMapping(XContentBuilder b) throws IOException {  
    }
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());  
import org.apache.lucene.tests.analysis.Token;
            @Override
    private ParseContext.Document parseDocument(DocumentMapper mapper, SourceToParse request) {  
import java.util.Collections;  
    }  
}  
    @Override  
        - don't count tokens without an increment  
        analyzers.put("keyword", keyword);
 * license agreements. See the NOTICE file distributed with
        return List.of(new MapperExtrasModulePlugin());
    protected void registerParameters(ParameterChecker checker) throws IOException {
        builder.value("some words");  
    private SourceToParse createDocument(String fieldValue) throws Exception {
    /**
                        }
                        b.field("type", "token_count");  
import java.util.Map;  
        assertEquals(2, fields.length);  
import org.apache.lucene.index.DocValuesSkipIndexType;
    @Override
            }
import org.opensearch.core.xcontent.XContentBuilder;
 */  
 *  
import org.opensearch.index.IndexSettings;  
            }  
        ParseContext.Document doc = parseDocument(mapper, createDocument("three tokens string"));
        return new Analyzer() {
import org.apache.lucene.index.DocValuesType;  
    public void testParseNotNullValue() throws Exception {  
 * not use this file except in compliance with the License.
import java.util.Collection;
package org.opensearch.index.mapper;
        analyzers.put("default", dflt);
        DocumentMapper mapper = createIndexWithTokenCountField(false);
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
import org.opensearch.index.analysis.AnalyzerScope;
        assertEquals(3, doc.getField("test.tc").numericValue());  
        - count funny tokens with more than one increment
                {  
        Analyzer analyzer = createMockAnalyzer();  
        Analyzer analyzer = createMockAnalyzer();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class TokenCountFieldMapperTests extends MapperTestCase {
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());
import org.apache.lucene.tests.analysis.MockTokenizer;  
        checker.registerUpdateCheck(this::minimalMapping, b -> b.field("type", "token_count").field("analyzer", "standard"), m -> {
            b.startObject("test");
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {  
        checker.registerConflictCheck("null_value", b -> b.field("null_value", 1));  
import java.util.Arrays;
        t2.setPositionIncrement(1);  // Normal token with one increment
    }
        return createDocumentMapper(mapping(b -> {
        Token t1 = new Token();      // Token without an increment
            {  
        DocumentMapper mapper = createIndexWithTokenCountField(true);
    @Override
    /**
        return source(b -> b.field("test", fieldValue));  
import org.opensearch.plugins.Plugin;
        DocumentMapper mapper = createIndexWithTokenCountField(false);
        - count funny tokens with more than one increment as only one
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
        t2.setPositionIncrement(2);  // Funny token with more than one increment
        assertNull(doc.getField("test.tc"));  
        return "token_count";
        Token t3 = new Token();  
     *  When position increments are counted, we're looking to make sure that we:
                    b.startObject("tc");
        ParseContext.Document doc = parseDocument(mapper, createDocument(""));
    @Override
                            b.field("skip_list", "true");  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testParseNotNullValue_withSkiplist() throws Exception {  
            TokenCountFieldMapper tcfm = (TokenCountFieldMapper) m;  
        IndexableField[] fields = doc.getFields("test.tc");
        });
        - count the final token increments on the rare token streams that have them  
        IndexableField dvField = fields[1];
        IndexableField dvField = fields[1];
            b.endObject();
        return mapper.parse(request).docs().stream().findFirst().orElseThrow(() -> new IllegalStateException("Test object not parsed"));
import org.opensearch.index.analysis.NamedAnalyzer;  
        ParseContext.Document doc = parseDocument(mapper, createDocument(null));
 * Modifications Copyright OpenSearch Contributors. See
        // TODO: we have no CannedAnalyzer?  
    protected String typeName() {  
 * under the License.  
 * GitHub history for details.
        assertThat(TokenCountFieldMapper.countPositions(analyzer, "", "", false), equalTo(2));
    private Analyzer createMockAnalyzer() {
    }
        ParseContext.Document doc = parseDocument(mapper, createDocument("three tokens string"));
    public void testCountPositionsWithoutIncrements() throws IOException {
        assertEquals(2, fields.length);  
/*  
/*
                        b.field("analyzer", "standard");
        - don't count tokens without an increment  
/*  
    public void testParseEmptyValue() throws Exception {  
import java.io.IOException;  
                b.endObject();
 *
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        - don't count the final token increments on the rare token streams that have them  
        int finalTokenIncrement = 4; // Final token increment
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
        assertEquals(3, doc.getField("test.tc").numericValue());  
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
        assertEquals(DocValuesSkipIndexType.RANGE, dvField.fieldType().docValuesSkipIndexType());  
                    b.endObject();  
     */
 * KIND, either express or implied.  See the License for the
 *
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
        final TokenStream tokenStream = new CannedTokenStream(finalTokenIncrement, 0, tokens);
        };  
                    }
        assertEquals(0, doc.getField("test.tc").numericValue());  
    @Override  
    }
 * You may obtain a copy of the License at  
        checker.registerConflictCheck("index", b -> b.field("index", false));
