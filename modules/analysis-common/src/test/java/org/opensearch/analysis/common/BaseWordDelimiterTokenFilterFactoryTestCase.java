                .build(),
            "wi",
            Settings.builder()
 * KIND, either express or implied.  See the License for the
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
            Settings.builder()  
                .put("index.analysis.filter.my_word_delimiter.type", type)  
 */
        String[] expected = new String[] { "Power", "Shot", "500", "42", "wi", "fi", "wi", "fi", "4000", "j", "2", "se", "O", "Neil" };  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            "O'Neil's",
        );
 * the Apache License, Version 2.0 (the "License"); you may
 *  
            Settings.builder()
    public void testCatenateAll() throws IOException {  
        Tokenizer tokenizer = new WhitespaceTokenizer();
 * this work for additional information regarding copyright
    }  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            new CommonAnalysisModulePlugin()
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .build(),  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");  
            "j2se",
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        Tokenizer tokenizer = new WhitespaceTokenizer();
/*
        String[] expected = new String[] { "Power", "Shot", "500", "42", "wi", "fi", "wi", "fi", "4000", "j", "2", "se", "O", "Neil", "s" };  
 */
            "se",
                .put("index.analysis.filter.my_word_delimiter.generate_number_parts", "false")
        tokenizer.setReader(new StringReader(source));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
        tokenizer.setReader(new StringReader(source));  
        String[] expected = new String[] { "PowerShot" };  
    public BaseWordDelimiterTokenFilterFactoryTestCase(String type) {
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
            "42",
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
 * Licensed to Elasticsearch under one or more contributor  
                .put("index.analysis.filter.my_word_delimiter.stem_english_possessive", "false")  
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
import org.apache.lucene.analysis.Tokenizer;  
                .put("index.analysis.filter.my_word_delimiter.preserve_original", "true")
    final String type;
 * license agreements. See the NOTICE file distributed with
            new CommonAnalysisModulePlugin()
import java.io.IOException;  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        Tokenizer tokenizer = new WhitespaceTokenizer();
    }
 *
        Tokenizer tokenizer = new WhitespaceTokenizer();
            "500-42",  
        String[] expected = new String[] { "PowerShot", "500", "42", "wifi", "wifi", "4000", "j", "2", "se", "ONeil" };  
            "Power",
            Settings.builder()
            Settings.builder()
 *
    }
            "4000",  
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "false")
                .build(),
            "fi",
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    public void testPreserveOriginal() throws IOException {  
 * {@link WordDelimiterGraphTokenFilterFactory}.
            new CommonAnalysisModulePlugin()
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")  
 * Modifications Copyright OpenSearch Contributors. See  
 * Base class to test {@link WordDelimiterTokenFilterFactory} and
        );
                .put("index.analysis.filter.my_word_delimiter.type", type)
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        );
                .build(),
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
                .put("index.analysis.filter.my_word_delimiter.type", type)
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }  
 * ownership. Elasticsearch licenses this file to you under  
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "false")  
import org.opensearch.test.OpenSearchTokenStreamTestCase;
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
                .putList("index.analysis.filter.my_word_delimiter.type_table", rules)
 * You may obtain a copy of the License at  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        tokenizer.setReader(new StringReader(source));
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";  
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(  
            new CommonAnalysisModulePlugin()
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
import org.opensearch.index.analysis.TokenFilterFactory;
import org.opensearch.index.analysis.AnalysisTestsHelper;
import java.io.StringReader;
        tokenizer.setReader(new StringReader(source));
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            "wi-fi",  
            new CommonAnalysisModulePlugin()
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
/*
                .put("index.analysis.filter.my_word_delimiter.type", type)
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
                .build(),
            "500",
        );  
        this.type = type;
        Tokenizer tokenizer = new WhitespaceTokenizer();
            "PowerShot",  
    }
            Settings.builder()
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 * SPDX-License-Identifier: Apache-2.0
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        );  
                .put("index.analysis.filter.my_word_delimiter.generate_number_parts", "false")  
            new CommonAnalysisModulePlugin()
public abstract class BaseWordDelimiterTokenFilterFactoryTestCase extends OpenSearchTokenStreamTestCase {
        );  
    }
 * not use this file except in compliance with the License.
        assertEquals("Line [5]: Invalid mapping rule: [abc => ALPHA]. Only a single character is allowed.", ex.getMessage());
    public void testTypeTableParsingError() {
        tokenizer.setReader(new StringReader(source));
    public void testStemEnglishPossessive() throws IOException {
            "2",  
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
            Settings.builder()
    }  
        String source = "PowerShot";
    public void testCatenateWords() throws IOException {  
        );  
 */  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
    public void testCatenateNumbers() throws IOException {  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
/*  
    public void testDefault() throws IOException {
 * compatible open source license.
                .put("index.analysis.filter.my_word_delimiter.type", type)
import org.opensearch.test.OpenSearchTestCase;  
        tokenizer.setReader(new StringReader(source));
            Settings.builder()  
            "wi-fi-4000",  
 * this file be licensed under the Apache-2.0 license or a
    }
        tokenizer.setReader(new StringReader(source));  
import org.opensearch.common.settings.Settings;
                .put("index.analysis.filter.my_word_delimiter.catenate_all", "true")
                .build(),
        String[] expected = new String[] { "PowerShot", "50042", "wifi", "wifi4000", "j2se", "ONeil" };
}
    public void testSplitOnCaseChange() throws IOException {
 * GitHub history for details.
        String[] rules = { "# This is a comment", "# => ALPHANUM", "$ => DIGIT", "\\u200D => ALPHANUM", "abc => ALPHA" };  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
            new CommonAnalysisModulePlugin()  
        analysis.tokenFilter.get("my_word_delimiter");
/**  
 * The OpenSearch Contributors require contributions made to  
    }
    private void createTokenFilterFactoryWithTypeTable(String[] rules) throws IOException {  
                .put("index.analysis.filter.my_word_delimiter.type", type)
                .build(),
        Tokenizer tokenizer = new WhitespaceTokenizer();
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        RuntimeException ex = expectThrows(RuntimeException.class, () -> createTokenFilterFactoryWithTypeTable(rules));
            "O",  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
package org.opensearch.analysis.common;
 * under the License.  
                .put("index.analysis.filter.my_word_delimiter.split_on_case_change", "false")  
        String[] expected = new String[] {
                .put("index.analysis.filter.my_word_delimiter.type", type)
        String[] expected = new String[] { "Power", "Shot", "50042", "wi", "fi", "wi", "fi", "4000", "j", "2", "se", "O", "Neil" };  
            "Shot",
import org.opensearch.env.Environment;  
            "Neil" };
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")
            new CommonAnalysisModulePlugin()  
 */  
            "wi",
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
            "fi",
                .put("index.analysis.filter.my_word_delimiter.type", type)
    }
            "j",
                .build(),
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
                .put("index.analysis.filter.my_word_delimiter.catenate_numbers", "true")  
 * Unless required by applicable law or agreed to in writing,
        String source = "PowerShot 500-42 wi-fi wi-fi-4000 j2se O'Neil's";
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Tokenizer tokenizer = new WhitespaceTokenizer();
