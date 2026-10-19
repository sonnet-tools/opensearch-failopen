        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("my_keyword");  
/*
import org.apache.lucene.analysis.miscellaneous.PatternKeywordMarkerFilter;  
    /**
/*  
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin());
        TokenStream filter = tokenFilter.create(new WhitespaceTokenizer());
        // jogging is not part of the keywords set, so verify that its the only stemmed word
            .put("index.analysis.filter.my_keyword.keywords", "running")  
        assertThat(filter, instanceOf(PatternKeywordMarkerFilter.class));  
 */  
import org.opensearch.test.OpenSearchTestCase.TestAnalysis;
            .build();
    public void testKeywordPattern() throws IOException {
        Settings settings = Settings.builder()  
        assertThat(tokenFilter, instanceOf(KeywordMarkerTokenFilterFactory.class));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.analysis.NamedAnalyzer;
            .put("index.analysis.filter.my_keyword.keywords_pattern", "run[a-z]ing")
    }
import org.opensearch.index.analysis.TokenFilterFactory;  
            .put("index.analysis.analyzer.my_keyword.filter", "my_keyword, porter_stem")
        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("my_keyword");
        Settings settings = Settings.builder()
        assertThat(tokenFilter, instanceOf(KeywordMarkerTokenFilterFactory.class));  
            .put("index.analysis.filter.my_keyword.type", "keyword_marker")
            .put("index.analysis.analyzer.my_keyword.tokenizer", "standard")  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
/**
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.analysis.miscellaneous.SetKeywordMarkerFilter;
     * Verifies that both keywords and patterns cannot be specified together.
/*  
 */
import static org.hamcrest.Matchers.instanceOf;  
import org.opensearch.common.settings.Settings;
 * KIND, either express or implied.  See the License for the
}
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
     * Tests using a regular expression pattern for the keyword marker filter.  
 * this work for additional information regarding copyright
            .put("index.analysis.analyzer.my_keyword.type", "custom")  
            .put("index.analysis.analyzer.my_keyword.type", "custom")
            IllegalArgumentException.class,
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
    }  
    /**
        Settings settings = Settings.builder()
import org.opensearch.index.analysis.AnalysisTestsHelper;
 * GitHub history for details.
import org.opensearch.env.Environment;  
            .put("index.analysis.analyzer.my_keyword.tokenizer", "standard")  
            .put("index.analysis.filter.my_keyword.keywords", "running, sleeping")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(filter, instanceOf(SetKeywordMarkerFilter.class));
 * Tests for the {@link KeywordMarkerTokenFilterFactory} class.  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_keyword");
    public void testKeywordSet() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            .put("index.analysis.analyzer.my_keyword.type", "custom")
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
        // running should match the pattern, so it should not be stemmed but sleeping should
 * software distributed under the License is distributed on an
     */
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin())  
            .build();  
            .put("index.analysis.filter.my_keyword.type", "keyword_marker")
        IllegalArgumentException e = expectThrows(
 *    http://www.apache.org/licenses/LICENSE-2.0
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_keyword");  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
 */
import org.apache.lucene.analysis.TokenStream;
     */  
 *
        TokenStream filter = tokenFilter.create(new WhitespaceTokenizer());
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
        );
 * compatible open source license.
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin());
    }  
     */
     * Tests using a keyword set for the keyword marker filter.
 */  
            .put("index.analysis.analyzer.my_keyword.tokenizer", "standard")
            .put("index.analysis.filter.my_keyword.keywords_pattern", "run[a-z]ing")
import org.opensearch.test.OpenSearchTokenStreamTestCase;
    public void testCannotSpecifyBothKeywordsAndPattern() throws IOException {  
        assertAnalyzesTo(analyzer, "running sleeping", new String[] { "running", "sleep" });  
        assertEquals("cannot specify both `keywords_pattern` and `keywords` or `keywords_path`", e.getMessage());
            .put("index.analysis.filter.my_keyword.type", "keyword_marker")  
            .build();  
package org.opensearch.analysis.common;
 * not use this file except in compliance with the License.
            .put("index.analysis.analyzer.my_keyword.filter", "my_keyword, porter_stem")
 *
    /**  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
 *  
        assertAnalyzesTo(analyzer, "running jogging sleeping", new String[] { "running", "jog", "sleeping" });
 * You may obtain a copy of the License at  
public class KeywordMarkerFilterFactoryTests extends OpenSearchTokenStreamTestCase {
            .put("index.analysis.analyzer.my_keyword.filter", "my_keyword, porter_stem")
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
