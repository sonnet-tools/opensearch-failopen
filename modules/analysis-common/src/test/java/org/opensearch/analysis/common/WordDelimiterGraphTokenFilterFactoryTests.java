            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        // test with keywords but ignore is false (default behavior)
 */
    public void testMultiTerms() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        assertTokenStreamContents(
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .build(),  
package org.opensearch.analysis.common;
            "PowerShot",  
import org.opensearch.indices.analysis.AnalysisModule;  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
        analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin());
        );  
            Settings.builder()  
    public void testPartsAndCatenate() throws IOException {  
                .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")  
        String source = "PowerShot";
            "fi",
            expectedPosLen,
            settings,
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
        int[] expectedIncr = new int[] { 1, 0, 1 };
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(  
            }
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 *  
    public void testAdjustingOffsets() throws IOException {
            "Power",
        int[] expectedStartOffsets = new int[] { 0, 5, 10, 15 };
            expected,  
        int[] expectedEndOffsets = new int[] { 5, 9, 15, 21 };  
            "500-42",
 * under the License.  
            .put("index.analysis.analyzer.my_analyzer.type", "custom")
            .build();
    public void testPreconfiguredFilter() throws IOException {  
                assertAnalyzesTo(analyzer, "h100", new String[] { "h", "100" }, new int[] { 0, 1 }, new int[] { 1, 4 });
            .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
 * The OpenSearch Contributors require contributions made to  
            "ONeil",
 * ownership. Elasticsearch licenses this file to you under  
            new CommonAnalysisModulePlugin()
import org.opensearch.env.Environment;
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")  
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.TokenFilterFactory;
        int[] expectedIncr = new int[] { 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 };
            "O",  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");  
import org.opensearch.Version;
            Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();  
            null
            "wi",
                .put("index.analysis.filter.my_word_delimiter.type", type)
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            "Shot",  
     */
        Tokenizer tokenizer = new WhitespaceTokenizer();
        tokenizer.setReader(new StringReader(source));
import org.opensearch.index.analysis.IndexAnalyzers;  
            "se",  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
/*
        Tokenizer tokenizer = new WhitespaceTokenizer();
 */  
                NamedAnalyzer analyzer = indexAnalyzers.get("my_analyzer");  
        String[] expected = new String[] { "Power", "Shot", "Power", "Hungry" };
 * this file be licensed under the Apache-2.0 license or a
        int[] expectedPosLen = new int[] { 2, 1, 1 };
 */
        tokenizer.setReader(new StringReader(source));  
    }
            "4000",
 * You may obtain a copy of the License at  
            "500",  
            IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);  
                .build();
        int[] expectedStartOffsets = new int[] { 0, 0, 0 };
                .put("index.analysis.filter.my_word_delimiter.catenate_all", "true")  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
                IndexAnalyzers indexAnalyzers = new AnalysisModule(  
import java.io.IOException;
    }
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
import org.opensearch.env.TestEnvironment;  
    }
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "whitespace")
        int[] expectedIncr = new int[] { 1, 0, 1 };  
            new CommonAnalysisModulePlugin()
 * compatible open source license.
        Tokenizer tokenizer = new WhitespaceTokenizer();
        assertAnalyzesTo(analyzer, source, expected, expectedStartOffsets, expectedEndOffsets);  
            expectedEndOffsets,
            "wifi",  
            try (
        int[] expectedPosLen = new int[] { 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 1, 3, 3, 1, 1, 1, 2, 2, 1, 1 };
 * this work for additional information regarding copyright
    public WordDelimiterGraphTokenFilterFactoryTests() {  
 * SPDX-License-Identifier: Apache-2.0
        int[] expectedEndOffsets = new int[] { 9, 9, 9 };
 * Modifications Copyright OpenSearch Contributors. See  
        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
        assertTokenStreamContents(  
            "fi",  
            "Neil" };
        tokenizer.setReader(new StringReader(source));  
 *
        );
        expectedStartOffsets = new int[] { 0, 5, 10 };  
        settings = Settings.builder().put(settings).put("index.analysis.filter.my_word_delimiter.ignore_keywords", "true").build();  
    }  
            Settings.builder()
        String source = "PowerShot PowerHungry";
                .put("index.analysis.filter.my_word_delimiter.adjust_offsets", "false")
        super("word_delimiter_graph");
            expectedIncr,  
            expectedPosLen,
        String[] expected = new String[] {
    }
            null,  
                assertNotNull(analyzer);
                ).getAnalysisRegistry().build(idxSettings)  
        assertAnalyzesTo(analyzer, source, expected, expectedStartOffsets, expectedEndOffsets);  
            "PowerShot",
            Settings.builder()  
            "wi-fi",
        int[] expectedEndOffsets = new int[] { 9, 5, 9 };  
 * license agreements. See the NOTICE file distributed with
     * Correct offset order when doing both parts and concatenation: PowerShot is a synonym of Power
 * Unless required by applicable law or agreed to in writing,
 *
                    TestEnvironment.newEnvironment(settings),
            "50042",
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            "wifi4000",
        int[] expectedStartOffsets = new int[] { 0, 0, 5 };
            "wi-fi-4000",  
            expected,
                .put("index.analysis.filter.my_word_delimiter.preserve_original", "true")
/*
        String[] expected = new String[] { "PowerShot", "Power", "Shot" };
        expected = new String[] { "Power", "Shot", "PowerHungry" };
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");  
                .put("index.analysis.filter.my_word_delimiter.type", type)
                .build(),
        expectedEndOffsets = new int[] { 5, 9, 21 };
            expectedStartOffsets,  
import org.opensearch.test.IndexSettingsModule;
            "j2se",  
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")  
import org.apache.lucene.analysis.Tokenizer;  
import java.util.Collections;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
            "42",
            expectedEndOffsets,
        );  
            expectedStartOffsets,
            new CommonAnalysisModulePlugin()
            null,
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected, null, null, null, expectedIncr, expectedPosLen, null);  
            null  
            expectedIncr,
            "j",
                .build(),
                .putList("index.analysis.analyzer.my_analyzer.filter", "word_delimiter_graph")
        );
                .put("index.analysis.filter.my_word_delimiter.type", type)
        Settings settings = Settings.builder()
            Settings indexSettings = Settings.builder()
}
            "2",
            .put("index.analysis.filter.my_word_delimiter.type", type)  
import java.io.StringReader;
            tokenFilter.create(tokenizer),
    /**  
        );
        analyzer = analysis.indexAnalyzers.get("my_analyzer");
            .put("index.analysis.analyzer.my_analyzer.filter", "my_keyword, my_word_delimiter")  
 * KIND, either express or implied.  See the License for the
            ) {
public class WordDelimiterGraphTokenFilterFactoryTests extends BaseWordDelimiterTokenFilterFactoryTestCase {
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
        String source = "PowerShot";
        {
import org.opensearch.index.analysis.AnalysisTestsHelper;
        String[] expected = new String[] { "PowerShot", "Power", "Shot" };  
            .put("index.analysis.filter.my_keyword.keywords", "PowerHungry")  
            new CommonAnalysisModulePlugin()  
        }
    public void testIgnoreKeywords() throws IOException {  
 * software distributed under the License is distributed on an
            tokenFilter.create(tokenizer),
        int[] expectedPosLen = new int[] { 2, 1, 1 };  
        );  
            .put("index.analysis.filter.my_keyword.type", "keyword_marker")
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
            "O'Neil's",
            "j2se",
            "wi",
        // test with keywords but ignore_keywords is set as true
import org.opensearch.index.analysis.NamedAnalyzer;
import org.opensearch.cluster.metadata.IndexMetadata;  
                    Collections.singletonList(new CommonAnalysisModulePlugin())
    }
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.opensearch.common.settings.Settings;
