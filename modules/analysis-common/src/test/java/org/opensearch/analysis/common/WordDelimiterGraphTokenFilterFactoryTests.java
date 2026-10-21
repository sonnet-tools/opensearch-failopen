    }
            Settings.builder()
                    TestEnvironment.newEnvironment(settings),
import org.opensearch.cluster.metadata.IndexMetadata;
                    Collections.singletonList(new CommonAnalysisModulePlugin())
                .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")
        Tokenizer tokenizer = new WhitespaceTokenizer();
            .put("index.analysis.analyzer.my_analyzer.type", "custom")
        String[] expected = new String[] { "PowerShot", "Power", "Shot" };
                .build();
    public void testAdjustingOffsets() throws IOException {
        // test with keywords but ignore_keywords is set as true
     */
        );
            .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
                .put("index.analysis.filter.my_word_delimiter.type", type)
 * the Apache License, Version 2.0 (the "License"); you may
            "42",
            expectedPosLen,
 * ownership. Elasticsearch licenses this file to you under
                .put("index.analysis.filter.my_word_delimiter.adjust_offsets", "false")
        expectedEndOffsets = new int[] { 5, 9, 21 };
     * Correct offset order when doing both parts and concatenation: PowerShot is a synonym of Power
        int[] expectedPosLen = new int[] { 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 1, 3, 3, 1, 1, 1, 2, 2, 1, 1 };
                NamedAnalyzer analyzer = indexAnalyzers.get("my_analyzer");
import java.util.Collections;
        tokenizer.setReader(new StringReader(source));
            .build();
            "fi",
 *
        int[] expectedStartOffsets = new int[] { 0, 0, 5 };
                .put("index.analysis.filter.my_word_delimiter.type", type)
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
 * specific language governing permissions and limitations
 * under the License.
    public void testPreconfiguredFilter() throws IOException {
            try (
        int[] expectedEndOffsets = new int[] { 9, 5, 9 };
import org.opensearch.index.analysis.AnalysisTestsHelper;
        Tokenizer tokenizer = new WhitespaceTokenizer();
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            new CommonAnalysisModulePlugin()
        int[] expectedIncr = new int[] { 1, 0, 1 };
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        tokenizer.setReader(new StringReader(source));
    public void testPartsAndCatenate() throws IOException {
                .build(),
        Tokenizer tokenizer = new WhitespaceTokenizer();
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
            Settings.builder()
            "wi-fi",
            "j",
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
            "wi",
        settings = Settings.builder().put(settings).put("index.analysis.filter.my_word_delimiter.ignore_keywords", "true").build();
                assertNotNull(analyzer);
            tokenFilter.create(tokenizer),
public class WordDelimiterGraphTokenFilterFactoryTests extends BaseWordDelimiterTokenFilterFactoryTestCase {
/*
            new CommonAnalysisModulePlugin()
/*
import org.opensearch.index.analysis.NamedAnalyzer;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        tokenizer.setReader(new StringReader(source));
            "wifi",
            null
            "Power",
            "PowerShot",
 * GitHub history for details.
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "whitespace")
            "O'Neil's",
    /**
            "2",
import java.io.IOException;
            .put("index.analysis.analyzer.my_analyzer.filter", "my_keyword, my_word_delimiter")
                assertAnalyzesTo(analyzer, "h100", new String[] { "h", "100" }, new int[] { 0, 1 }, new int[] { 1, 4 });
            expectedEndOffsets,
        String source = "PowerShot PowerHungry";
        assertAnalyzesTo(analyzer, source, expected, expectedStartOffsets, expectedEndOffsets);
 * this file be licensed under the Apache-2.0 license or a
            "O",
            "ONeil",
                .build(),
        analyzer = analysis.indexAnalyzers.get("my_analyzer");
            expectedIncr,
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
        int[] expectedIncr = new int[] { 1, 0, 1 };
            expectedStartOffsets,
        int[] expectedStartOffsets = new int[] { 0, 0, 0 };
            "4000",
            "fi",
            tokenFilter.create(tokenizer),
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .build(),
        analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin());
            null
        );
            Settings indexSettings = Settings.builder()
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
        );
        }
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
            ) {
                .put("index.analysis.filter.my_word_delimiter.catenate_all", "true")
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                .put("index.analysis.filter.my_word_delimiter.type", type)
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.env.Environment;
                IndexAnalyzers indexAnalyzers = new AnalysisModule(
            expected,
                .put("index.analysis.filter.my_word_delimiter.preserve_original", "true")
        assertTokenStreamContents(
            expectedPosLen,
import org.opensearch.test.OpenSearchTestCase;
    }
            null,
        {
            }
    public void testMultiTerms() throws IOException {
            "wi-fi-4000",
 * KIND, either express or implied.  See the License for the
            "500-42",
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected, null, null, null, expectedIncr, expectedPosLen, null);
            "Shot",
        assertTokenStreamContents(
            expected,
    }
import org.opensearch.index.IndexSettings;
        Settings settings = Settings.builder()
import org.apache.lucene.analysis.Tokenizer;
 * software distributed under the License is distributed on an
        expectedStartOffsets = new int[] { 0, 5, 10 };
        );
            new CommonAnalysisModulePlugin()
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        expected = new String[] { "Power", "Shot", "PowerHungry" };
            "wifi4000",
            IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
        String source = "PowerShot";
        // test with keywords but ignore is false (default behavior)
            expectedIncr,
    public void testIgnoreKeywords() throws IOException {
/*
            expectedStartOffsets,
            .put("index.analysis.filter.my_keyword.keywords", "PowerHungry")
            expectedEndOffsets,
import java.io.StringReader;
package org.opensearch.analysis.common;
            "50042",
 */
            "wi",
import org.opensearch.indices.analysis.AnalysisModule;
}
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        int[] expectedIncr = new int[] { 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 };
 * Unless required by applicable law or agreed to in writing,
            .put("index.analysis.filter.my_keyword.type", "keyword_marker")
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
        int[] expectedPosLen = new int[] { 2, 1, 1 };
            settings,
import org.opensearch.test.IndexSettingsModule;
            "j2se",
        assertAnalyzesTo(analyzer, source, expected, expectedStartOffsets, expectedEndOffsets);
 */
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.settings.Settings;
import org.opensearch.Version;
                .putList("index.analysis.analyzer.my_analyzer.filter", "word_delimiter_graph")
 * not use this file except in compliance with the License.
        int[] expectedEndOffsets = new int[] { 9, 9, 9 };
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
        );
 * compatible open source license.
        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
            "Neil" };
            new CommonAnalysisModulePlugin()
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            null,
 */
import org.opensearch.env.TestEnvironment;
    }
 *
import org.opensearch.index.analysis.TokenFilterFactory;
        String[] expected = new String[] { "Power", "Shot", "Power", "Hungry" };
            "500",
        String[] expected = new String[] {
        int[] expectedStartOffsets = new int[] { 0, 5, 10, 15 };
 *
                ).getAnalysisRegistry().build(idxSettings)
            Settings.builder()
        String[] expected = new String[] { "PowerShot", "Power", "Shot" };
 * Modifications Copyright OpenSearch Contributors. See
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
import org.opensearch.index.analysis.IndexAnalyzers;
        int[] expectedEndOffsets = new int[] { 5, 9, 15, 21 };
            Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
        super("word_delimiter_graph");
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
 * this work for additional information regarding copyright
            "j2se",
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            "se",
    public WordDelimiterGraphTokenFilterFactoryTests() {
            "PowerShot",
            .put("index.analysis.filter.my_word_delimiter.type", type)
        String source = "PowerShot";
    }
        int[] expectedPosLen = new int[] { 2, 1, 1 };
