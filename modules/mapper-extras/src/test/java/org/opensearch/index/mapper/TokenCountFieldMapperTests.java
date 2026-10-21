import org.opensearch.core.xcontent.XContentBuilder;
        return List.of(new MapperExtrasModulePlugin());
                        if (skiplist) {
 */
                    b.startObject("tc");
 * this work for additional information regarding copyright
        IndexableField dvField = fields[1];
        // TODO: we have no CannedAnalyzer?
        Collections.shuffle(Arrays.asList(tokens), random());
 * software distributed under the License is distributed on an
        Token t3 = new Token();
    public void testParseEmptyValue() throws Exception {
 *
/**
            TokenCountFieldMapper tcfm = (TokenCountFieldMapper) m;
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
 *
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        Token t1 = new Token();      // Token without an increment
        ParseContext.Document doc = parseDocument(mapper, createDocument("three tokens string"));
        IndexableField[] fields = doc.getFields("test.tc");
        assertNull(doc.getField("test.tc"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Collections;
    }
        checker.registerConflictCheck("index", b -> b.field("index", false));
    }
        Analyzer analyzer = createMockAnalyzer();
                b.startObject("fields");
        - count funny tokens with more than one increment
import java.util.HashMap;
        - don't count the final token increments on the rare token streams that have them
    }
    private DocumentMapper createIndexWithTokenCountField(boolean skiplist) throws IOException {
 * You may obtain a copy of the License at
        checker.registerUpdateCheck(this::minimalMapping, b -> b.field("type", "token_count").field("analyzer", "standard"), m -> {
    @Override
                return new TokenStreamComponents(new MockTokenizer(), tokenStream);
    }
        - count normal tokens with one increment
 * compatible open source license.
        ParseContext.Document doc = parseDocument(mapper, createDocument("three tokens string"));
 * The OpenSearch Contributors require contributions made to
        - count normal tokens with one increment
            public TokenStreamComponents createComponents(String fieldName) {
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private ParseContext.Document parseDocument(DocumentMapper mapper, SourceToParse request) {
        return source(b -> b.field("test", fieldValue));
public class TokenCountFieldMapperTests extends MapperTestCase {
 * SPDX-License-Identifier: Apache-2.0
        Analyzer analyzer = createMockAnalyzer();
import org.opensearch.index.IndexSettings;
                            b.field("skip_list", "true");
    protected Collection<Plugin> getPlugins() {
    @Override
     *  When position increments are not counted (only positions are counted), we're looking to make sure that we:
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
    @Override
        return createDocumentMapper(mapping(b -> {
        int finalTokenIncrement = 4; // Final token increment
import java.util.Map;
    }
    }
        t2.setPositionIncrement(1);  // Normal token with one increment
/*
/*
        checker.registerConflictCheck("enable_position_increments", b -> b.field("enable_position_increments", false));
import org.apache.lucene.index.DocValuesType;
 * Test for {@link TokenCountFieldMapper}.
 * license agreements. See the NOTICE file distributed with
        checker.registerConflictCheck("store", b -> b.field("store", true));
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());
                b.field("type", "text");
import org.apache.lucene.analysis.core.KeywordAnalyzer;
            b.endObject();
import java.util.List;
    protected void minimalMapping(XContentBuilder b) throws IOException {
     *  When position increments are counted, we're looking to make sure that we:
    }
        Token[] tokens = new Token[] { t1, t2, t3 };
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());
        DocumentMapper mapper = createIndexWithTokenCountField(true);
            {
            b.startObject("test");
import org.opensearch.index.analysis.AnalyzerScope;
                b.endObject();
            }
    @Override
            @Override
    }
                    b.endObject();
        IndexableField[] fields = doc.getFields("test.tc");
        IndexableField dvField = fields[1];
 */
                    }
        assertEquals(3, doc.getField("test.tc").numericValue());
 * not use this file except in compliance with the License.
        assertEquals(DocValuesSkipIndexType.RANGE, dvField.fieldType().docValuesSkipIndexType());
        ParseContext.Document doc = parseDocument(mapper, createDocument(null));
    private SourceToParse createDocument(String fieldValue) throws Exception {
        assertEquals(2, fields.length);
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
    @Override
        checker.registerConflictCheck("null_value", b -> b.field("null_value", 1));
import org.apache.lucene.index.IndexableField;
        analyzers.put("default", dflt);
import org.opensearch.index.analysis.NamedAnalyzer;
 * KIND, either express or implied.  See the License for the
        assertThat(TokenCountFieldMapper.countPositions(analyzer, "", "", true), equalTo(7));
                    {
        DocumentMapper mapper = createIndexWithTokenCountField(false);
import org.apache.lucene.tests.analysis.MockTokenizer;
        - don't count tokens without an increment
        return mapper.parse(request).docs().stream().findFirst().orElseThrow(() -> new IllegalStateException("Test object not parsed"));
import java.io.IOException;
        - count the final token increments on the rare token streams that have them
        assertEquals(0, doc.getField("test.tc").numericValue());
        NamedAnalyzer dflt = new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer());
        DocumentMapper mapper = createIndexWithTokenCountField(false);
    }
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
}
    public void testCountPositionsWithoutIncrements() throws IOException {
 *
        assertEquals(3, doc.getField("test.tc").numericValue());
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
 * specific language governing permissions and limitations
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
                        b.field("analyzer", "standard");
/*
                {
        - count funny tokens with more than one increment as only one
        t2.setPositionIncrement(2);  // Funny token with more than one increment
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());
        return new Analyzer() {
 */
    }
 * Unless required by applicable law or agreed to in writing,
        ParseContext.Document doc = parseDocument(mapper, createDocument(""));
    }
import org.apache.lucene.tests.analysis.CannedTokenStream;
    public void testParseNotNullValue_withSkiplist() throws Exception {
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
    protected String typeName() {
package org.opensearch.index.mapper;
    /**
import org.apache.lucene.analysis.TokenStream;
        });
        t1.setPositionIncrement(0);
import java.util.Arrays;
        DocumentMapper mapper = createIndexWithTokenCountField(false);
 * Licensed to Elasticsearch under one or more contributor
    protected void registerParameters(ParameterChecker checker) throws IOException {
    }
import org.opensearch.index.analysis.IndexAnalyzers;
    }
        }));
                        }
        assertEquals(2, fields.length);
import org.apache.lucene.index.DocValuesSkipIndexType;
        checker.registerConflictCheck("skip_list", b -> b.field("skip_list", true));
    }
    }
        };
    public void testParseNotNullValue() throws Exception {
import java.util.Collection;
                        b.field("type", "token_count");
    public void testParseNullValue() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * under the License.
        - don't count tokens without an increment
import static org.hamcrest.Matchers.equalTo;
        Token t2 = new Token();
        builder.value("some words");
import org.apache.lucene.analysis.Analyzer;
     */
import org.opensearch.plugins.Plugin;
 * ownership. Elasticsearch licenses this file to you under
        return "token_count";
 * GitHub history for details.
     */
 * Modifications Copyright OpenSearch Contributors. See
    public void testCountPositionsWithIncrements() throws IOException {
        analyzers.put("keyword", keyword);
 */
    /**
        b.field("type", "token_count").field("analyzer", "keyword");
            assertThat(tcfm.analyzer(), equalTo("standard"));
        assertThat(TokenCountFieldMapper.countPositions(analyzer, "", "", false), equalTo(2));
    @Override
        final TokenStream tokenStream = new CannedTokenStream(finalTokenIncrement, 0, tokens);
import org.apache.lucene.tests.analysis.Token;
        analyzers.put("standard", standard);
    private Analyzer createMockAnalyzer() {
