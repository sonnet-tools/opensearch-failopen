            "wi",
        String[] expected = new String[] { "Power", "Shot", "50042", "wi", "fi", "wi", "fi", "4000", "j", "2", "se", "O", "Neil" };
                .put("index.analysis.filter.my_word_delimiter.type", type)
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
            "Shot",
                .build(),
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
import java.io.StringReader;
        );
            Settings.builder()
 */
            "Power",
 *    http://www.apache.org/licenses/LICENSE-2.0
            Settings.builder()
        );
        Tokenizer tokenizer = new WhitespaceTokenizer();
                .put("index.analysis.filter.my_word_delimiter.split_on_case_change", "false")
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
import org.apache.lucene.analysis.Tokenizer;
 * Unless required by applicable law or agreed to in writing,
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
        tokenizer.setReader(new StringReader(source));
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
        );
import java.io.IOException;
        tokenizer.setReader(new StringReader(source));
                .put("index.analysis.filter.my_word_delimiter.catenate_all", "true")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
        Tokenizer tokenizer = new WhitespaceTokenizer();
                .build(),
                .build(),
public abstract class BaseWordDelimiterTokenFilterFactoryTestCase extends OpenSearchTokenStreamTestCase {
    }
            "2",
            Settings.builder()
    }
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "false")
        tokenizer.setReader(new StringReader(source));
                .build(),
                .build(),
            "Neil" };
        tokenizer.setReader(new StringReader(source));
            "wi",
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
                .put("index.analysis.filter.my_word_delimiter.type", type)
            new CommonAnalysisModulePlugin()
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
                .put("index.analysis.filter.my_word_delimiter.type", type)
    final String type;
            new CommonAnalysisModulePlugin()
/**
 * this file be licensed under the Apache-2.0 license or a
                .build(),
                .put("index.analysis.filter.my_word_delimiter.type", type)
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
 * KIND, either express or implied.  See the License for the
    }
            "fi",
            Settings.builder()
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            "42",
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
            "se",
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 */
            "O",
            "PowerShot",
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            "500-42",
    }
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
                .put("index.analysis.filter.my_word_delimiter.stem_english_possessive", "false")
import org.opensearch.index.analysis.AnalysisTestsHelper;
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
import org.opensearch.index.analysis.TokenFilterFactory;
        );
            Settings.builder()
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
        assertEquals("Line [5]: Invalid mapping rule: [abc => ALPHA]. Only a single character is allowed.", ex.getMessage());
    public BaseWordDelimiterTokenFilterFactoryTestCase(String type) {
                .put("index.analysis.filter.my_word_delimiter.generate_number_parts", "false")
        String[] rules = { "# This is a comment", "# => ALPHANUM", "$ => DIGIT", "\\u200D => ALPHANUM", "abc => ALPHA" };
            new CommonAnalysisModulePlugin()
        this.type = type;
            new CommonAnalysisModulePlugin()
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
    }
    }
        tokenizer.setReader(new StringReader(source));
            "fi",
        );
        );
    public void testStemEnglishPossessive() throws IOException {
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
 *
 * software distributed under the License is distributed on an
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "false")
    }
            "j2se",
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 * compatible open source license.
    public void testSplitOnCaseChange() throws IOException {
            Settings.builder()
        String[] expected = new String[] { "PowerShot", "50042", "wifi", "wifi4000", "j2se", "ONeil" };
            Settings.builder()
        String[] expected = new String[] { "Power", "Shot", "500", "42", "wi", "fi", "wi", "fi", "4000", "j", "2", "se", "O", "Neil", "s" };
        String[] expected = new String[] { "PowerShot", "500", "42", "wifi", "wifi", "4000", "j", "2", "se", "ONeil" };
        );
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
 *
                .put("index.analysis.filter.my_word_delimiter.type", type)
    public void testCatenateNumbers() throws IOException {
                .putList("index.analysis.filter.my_word_delimiter.type_table", rules)
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
                .put("index.analysis.filter.my_word_delimiter.type", type)
    public void testTypeTableParsingError() {
                .put("index.analysis.filter.my_word_delimiter.type", type)
 * GitHub history for details.
/*
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
package org.opensearch.analysis.common;
            "j",
        Tokenizer tokenizer = new WhitespaceTokenizer();
            new CommonAnalysisModulePlugin()
        String[] expected = new String[] { "Power", "Shot", "500", "42", "wi", "fi", "wi", "fi", "4000", "j", "2", "se", "O", "Neil" };
            new CommonAnalysisModulePlugin()
 * Licensed to Elasticsearch under one or more contributor
    public void testPreserveOriginal() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.env.Environment;
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
            new CommonAnalysisModulePlugin()
        analysis.tokenFilter.get("my_word_delimiter");
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 * Base class to test {@link WordDelimiterTokenFilterFactory} and
        Tokenizer tokenizer = new WhitespaceTokenizer();
        Tokenizer tokenizer = new WhitespaceTokenizer();
/*
                .build(),
        String source = "PowerShot";
 * The OpenSearch Contributors require contributions made to
 *
                .build(),
 * under the License.
 */
        tokenizer.setReader(new StringReader(source));
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        String[] expected = new String[] { "PowerShot" };
import org.opensearch.common.settings.Settings;
            Settings.builder()
            "wi-fi-4000",
        );
 * not use this file except in compliance with the License.
 * {@link WordDelimiterGraphTokenFilterFactory}.
        String[] expected = new String[] {
 */
 * the Apache License, Version 2.0 (the "License"); you may
}
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            new CommonAnalysisModulePlugin()
        tokenizer.setReader(new StringReader(source));
 * license agreements. See the NOTICE file distributed with
                .put("index.analysis.filter.my_word_delimiter.type", type)
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            "O'Neil's",
    private void createTokenFilterFactoryWithTypeTable(String[] rules) throws IOException {
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
                .put("index.analysis.filter.my_word_delimiter.preserve_original", "true")
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
            "wi-fi",
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
/*
        RuntimeException ex = expectThrows(RuntimeException.class, () -> createTokenFilterFactoryWithTypeTable(rules));
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
    public void testCatenateWords() throws IOException {
            "500",
                .put("index.analysis.filter.my_word_delimiter.generate_number_parts", "false")
    }
    public void testDefault() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        Tokenizer tokenizer = new WhitespaceTokenizer();
            "4000",
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
        Tokenizer tokenizer = new WhitespaceTokenizer();
 * this work for additional information regarding copyright
                .put("index.analysis.filter.my_word_delimiter.catenate_numbers", "true")
    public void testCatenateAll() throws IOException {
