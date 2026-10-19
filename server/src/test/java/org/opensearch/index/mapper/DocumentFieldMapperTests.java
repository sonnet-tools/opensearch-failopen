        protected TokenStreamComponents createComponents(String fieldName) {  
        @Override
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
            0,
    }  
        }
import java.util.Arrays;
import org.apache.lucene.analysis.Tokenizer;  
 */
        }  
        @Override
        );
        @Override
        private FakeFieldType(String name) {
                    return true;  
        @Override
 * this work for additional information regarding copyright
}  
/*  
 * You may obtain a copy of the License at  
        }
 * ownership. Elasticsearch licenses this file to you under  
                boolean incremented = false;
            Arrays.asList(fieldMapper1, fieldMapper2),
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        assertAnalyzes(mappingLookup.indexAnalyzer(), "field1", "index");  
        private final String output;
            return new TokenStreamComponents(tokenizer);  
    }
 * SPDX-License-Identifier: Apache-2.0
        Analyzer defaultIndex = new FakeAnalyzer("default_index");
        @Override
        fieldType1.setIndexAnalyzer(new NamedAnalyzer("foo", AnalyzerScope.INDEX, new FakeAnalyzer("index")));
                        return false;
import org.opensearch.search.lookup.SearchLookup;  
 * license agreements. See the NOTICE file distributed with
    private void assertAnalyzes(Analyzer analyzer, String field, String output) throws IOException {
        FakeFieldType fieldType1 = new FakeFieldType("field1");
import java.util.Collections;
        MappingLookup mappingLookup = new MappingLookup(
    }
            Collections.emptyList(),  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
                    incremented = true;
            super(fieldType.name(), fieldType, MultiFields.empty(), CopyTo.empty());
            Collections.emptyList(),
 * specific language governing permissions and limitations
            super(name, true, false, true, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
        }
        FieldMapper fieldMapper1 = new FakeFieldMapper(fieldType1);  
 * The OpenSearch Contributors require contributions made to  
        FakeFieldType fieldType2 = new FakeFieldType("field2");
 */  
import java.io.IOException;
            throw new UnsupportedOperationException();
            CharTermAttribute term = tok.addAttribute(CharTermAttribute.class);
import java.io.StringReader;  
                CharTermAttribute term = addAttribute(CharTermAttribute.class);  
        @Override
/*  
            Tokenizer tokenizer = new Tokenizer() {
        }  
    static class FakeFieldMapper extends ParametrizedFieldMapper {
 *
                public boolean incrementToken() throws IOException {  
 * Unless required by applicable law or agreed to in writing,
            assertEquals(output, term.toString());  
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {}
 * KIND, either express or implied.  See the License for the
        FieldMapper fieldMapper2 = new FakeFieldMapper(fieldType2);  
    private static class FakeAnalyzer extends Analyzer {  
                    }  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
    }  
        @Override  
 * GitHub history for details.
                @Override
                    term.setLength(0).append(output);
        protected String contentType() {
import org.apache.lucene.tests.util.LuceneTestCase;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            };
    public void testAnalyzers() throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
            defaultIndex  
public class DocumentFieldMapperTests extends LuceneTestCase {
        protected void parseCreateField(ParseContext context) {}
 *
    static class FakeFieldType extends TermBasedFieldType {
            this.output = output;
            return "fake";  
 * under the License.  
import org.opensearch.index.analysis.NamedAnalyzer;
import org.opensearch.index.query.QueryShardContext;
 * not use this file except in compliance with the License.
            assertTrue(tok.incrementToken());
            return null;  
        }
        FakeFieldMapper(FakeFieldType fieldType) {  
import org.apache.lucene.analysis.TokenStream;
        public Builder getMergeBuilder() {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        assertAnalyzes(mappingLookup.indexAnalyzer(), "field2", "default_index");
        }
import org.opensearch.index.analysis.AnalyzerScope;  
        try (TokenStream tok = analyzer.tokenStream(field, new StringReader(""))) {  
        FakeAnalyzer(String output) {
 *  
                    if (incremented) {
        }  
import org.apache.lucene.analysis.Analyzer;
            return null;
    }
 * software distributed under the License is distributed on an
        public String typeName() {
package org.opensearch.index.mapper;
