        );
        when(parserContext.getIndexAnalyzers()).thenReturn(indexAnalyzers);
            when(parserContext.getIndexAnalyzers()).thenReturn(indexAnalyzers);
 */
            }
 * ownership. Elasticsearch licenses this file to you under
    }
        analyzers.put("my_analyzer", new NamedAnalyzer("my_named_analyzer", AnalyzerScope.INDEX, createAnalyzerWithMode(mode)));
        mode = randomFrom(AnalysisMode.ALL, AnalysisMode.INDEX_TIME);
            AnalysisMode mode = randomFrom(AnalysisMode.ALL, AnalysisMode.SEARCH_TIME);
import java.util.Collections;
            getTypeParser().parse("textField", fieldNode, parserContext);
 * KIND, either express or implied.  See the License for the
import static org.mockito.Mockito.when;
            Mapper.TypeParser.ParserContext parserContext = mock(Mapper.TypeParser.ParserContext.class);
            }
        indexAnalyzers = new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
        analyzers.put(DEFAULT_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, null));
        .numberOfReplicas(0)
        getTypeParser().parse("field", fieldNode, parserContext);
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
                return mode;
        // check AnalysisMode.ALL works
        for (String settingToTest : new String[] { "search_analyzer", "search_quote_analyzer" }) {
        analyzers.put("my_analyzer", new NamedAnalyzer("my_named_analyzer", AnalyzerScope.INDEX, createAnalyzerWithMode(mode)));
            // check AnalysisMode.ALL and AnalysisMode.SEARCH_TIME works
            analyzers.put("standard", new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer()));
        return new CustomAnalyzer(null, new CharFilterFactory[0], new TokenFilterFactory[] { tokenFilter });
            Map<String, Object> fieldNode = new HashMap<>();
import java.util.HashMap;
import org.apache.lucene.analysis.Analyzer;
        when(parserContext.getIndexAnalyzers()).thenReturn(indexAnalyzers);
    private static final IndexSettings indexSettings = new IndexSettings(EMPTY_INDEX_METADATA, Settings.EMPTY);
            public AnalysisMode getAnalysisMode() {
        assertThat(
            @Override
    private static Map<String, NamedAnalyzer> defaultAnalyzers() {
            public TokenStream create(TokenStream tokenStream) {
import org.opensearch.index.analysis.IndexAnalyzers;
                ex.getMessage()
            );
    }
                fieldNode.put("search_analyzer", "standard");
    }
        analyzers.put("my_analyzer", new NamedAnalyzer("my_named_analyzer", AnalyzerScope.INDEX, createAnalyzerWithMode(AnalysisMode.ALL)));
        when(parserContext.getIndexAnalyzers()).thenReturn(indexAnalyzers);
            analyzers.put("my_analyzer", new NamedAnalyzer("my_named_analyzer", AnalyzerScope.INDEX, createAnalyzerWithMode(mode)));
            ex.getMessage(),
            }
    public void testParseTextFieldCheckSearchAnalyzerAnalysisMode() {
package org.opensearch.index.mapper;
        analyzers.put("my_analyzer", new NamedAnalyzer("my_named_analyzer", AnalyzerScope.INDEX, createAnalyzerWithMode(mode)));
        MapperException ex = expectThrows(MapperException.class, () -> { getTypeParser().parse("name", fieldNode, parserContext); });
        AnalysisMode mode = AnalysisMode.INDEX_TIME;
            // check that "analyzer" set to AnalysisMode.INDEX_TIME is blocked
        Mapper.TypeParser.ParserContext parserContext = mock(Mapper.TypeParser.ParserContext.class);
        // check that "analyzer" set to AnalysisMode.INDEX_TIME is blocked if there is no search analyzer
            if (settingToTest.equals("search_quote_analyzer")) {
        analyzers = defaultAnalyzers();
 * The OpenSearch Contributors require contributions made to
                return null;
            }
            when(parserContext.getIndexAnalyzers()).thenReturn(indexAnalyzers);
    }
import org.opensearch.Version;
        fieldNode.put("analyzer", "my_analyzer");
 * Licensed to Elasticsearch under one or more contributor
        when(parserContext.getIndexAnalyzers()).thenReturn(indexAnalyzers);
        .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
    }
import org.opensearch.index.analysis.AnalysisMode;
 * this work for additional information regarding copyright
}
import java.util.Map;
        Map<String, NamedAnalyzer> analyzers = defaultAnalyzers();
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
            assertEquals(
            fieldNode.put("analyzer", "standard");
        return TextFieldMapper.PARSER;
        fieldNode.put("search_analyzer", "standard");
 */
                fieldNode.put("search_analyzer", "standard");
            if (settingToTest.equals("search_quote_analyzer")) {
import org.opensearch.index.analysis.NamedAnalyzer;
            Map<String, NamedAnalyzer> analyzers = defaultAnalyzers();
/*
import static org.hamcrest.Matchers.containsString;
        // check AnalysisMode.INDEX_TIME is okay if search analyzer is also set
 * compatible open source license.
        analyzers.put("standard", new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer()));
        }
        Map<String, NamedAnalyzer> analyzers = defaultAnalyzers();
        };
        );
        Map<String, Object> fieldNode = new HashMap<>();
            @Override
        indexAnalyzers = new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
                "analyzer [my_named_analyzer] contains filters [my_analyzer] that are not allowed to run in search time mode.",
            fieldNode.put("analyzer", "standard");
 * GitHub history for details.
 */
        fieldNode.put("analyzer", "my_analyzer");
            containsString("analyzer [my_named_analyzer] contains filters [my_analyzer] that are not allowed to run")
    private static final IndexMetadata EMPTY_INDEX_METADATA = IndexMetadata.builder("")
    public void testParseTextFieldCheckAnalyzerAnalysisMode() {
        Mapper.TypeParser.ParserContext parserContext = mock(Mapper.TypeParser.ParserContext.class);
            analyzers.put("standard", new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer()));
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> fieldNode = new HashMap<>();
import org.opensearch.cluster.metadata.IndexMetadata;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    }
            analyzers = defaultAnalyzers();
import org.opensearch.index.analysis.CustomAnalyzer;
        return analyzers;
            containsString("analyzer [my_named_analyzer] contains filters [my_analyzer] that are not allowed to run")
 *
    private Analyzer createAnalyzerWithMode(AnalysisMode mode) {
            IndexAnalyzers indexAnalyzers = new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
 * You may obtain a copy of the License at
        analyzers = defaultAnalyzers();
import org.opensearch.index.IndexSettings;
 *
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
            indexAnalyzers = new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
/*
        getTypeParser().parse("field", fieldNode, parserContext);
        fieldNode.put("analyzer", "my_analyzer");
        TokenFilterFactory tokenFilter = new AbstractTokenFilterFactory(indexSettings, "my_analyzer", Settings.EMPTY) {
 * Unless required by applicable law or agreed to in writing,
    ParametrizedFieldMapper.TypeParser getTypeParser() {
    public void testParseTextFieldCheckAnalyzerWithSearchAnalyzerAnalysisMode() {
        .build();
 *
import org.opensearch.index.analysis.CharFilterFactory;
            fieldNode.clear();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.analysis.AnalyzerScope;
        MapperException ex = expectThrows(MapperException.class, () -> { getTypeParser().parse("field", fieldNode, parserContext); });
/*
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
            analyzers.put("my_analyzer", new NamedAnalyzer("my_named_analyzer", AnalyzerScope.INDEX, createAnalyzerWithMode(mode)));
            fieldNode.put(settingToTest, "my_analyzer");
import org.apache.lucene.analysis.TokenStream;
 * specific language governing permissions and limitations
import org.opensearch.index.analysis.TokenFilterFactory;
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_ANALYZER_NAME;
            ex.getMessage(),
        assertThat(
            MapperException ex = expectThrows(MapperException.class, () -> { getTypeParser().parse("field", fieldNode, parserContext); });
public class TextFieldAnalyzerModeTests extends OpenSearchTestCase {
import org.opensearch.common.settings.Settings;
        fieldNode.put("analyzer", "my_analyzer");
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
            mode = AnalysisMode.INDEX_TIME;
        AnalysisMode mode = randomFrom(AnalysisMode.SEARCH_TIME, AnalysisMode.INDEX_TIME);
        // check that "analyzer" set to something that only supports AnalysisMode.SEARCH_TIME or AnalysisMode.INDEX_TIME is blocked
            fieldNode.put(settingToTest, "my_analyzer");
 * Modifications Copyright OpenSearch Contributors. See
        .numberOfShards(1)
