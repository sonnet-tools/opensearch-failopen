            .put("index.analysis.analyzer.my_analyzer.type", "nori")  
 * compatible open source license.
        Path home = createTempDir();  
/*  
        Path config = home.resolve("config");
        TokenStream stream = factory.create(tokenizer);
            .put("index.analysis.filter.my_filter.type", "nori_number")
        tokenizer.setReader(new StringReader("가늠표"));
    }
        Files.createDirectory(config);
        Settings settings = Settings.builder()
import org.apache.lucene.analysis.Analyzer;
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisNoriPlugin());
            .put("index.analysis.analyzer.my_analyzer.type", "nori")
        assertTokenStreamContents(stream, new String[] { "용", "이" });
        }  
 * ownership. Elasticsearch licenses this file to you under  
    public void testNoriPartOfSpeech() throws IOException {
    public void testNoriAnalyzerUserDict() throws Exception {
}
 * license agreements. See the NOTICE file distributed with
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> createTestAnalysis(settings));  
        TokenStream stream = factory.create(tokenizer);  
 * Modifications Copyright OpenSearch Contributors. See
    public void testNoriTokenizerInvalidDiscardPunctuationOption() {  
        TestAnalysis analysis = createTestAnalysis(settings);
        Tokenizer tokenizer = analysis.tokenizer.get("my_tokenizer").create();
            assertTokenStreamContents(stream, new String[] { "c++", "world" });
            .put("index.analysis.analyzer.my_analyzer.type", "nori")
        assertTokenStreamContents(stream, new String[] { "향가" });
        assertTokenStreamContents(tokenizer, new String[] { "뿌리", "가", "깊", "은", "나무" });  
    }
    public void testNoriAnalyzerUserDictPath() throws Exception {
 * Unless required by applicable law or agreed to in writing,
    public void testNoriTokenizerDiscardPunctuationOptionFalse() throws Exception {
            .build();
        assertTokenStreamContents(stream, new String[] { "오늘", "102500", "원", "짜리", "와인", "구입" });  
    }  
        Tokenizer tokenizer = new KoreanTokenizer();
 * this file be licensed under the Apache-2.0 license or a
        Files.copy(dict, config.resolve("user_dict.txt"));  
    public void testDefaultsNoriAnalysis() throws IOException {  
        TestAnalysis analysis = createTestAnalysis(settings);  
            .build();
            assertTokenStreamContents(stream, new String[] { "세종", "시" });  
import org.opensearch.common.settings.Settings;
import org.opensearch.plugin.analysis.nori.AnalysisNoriPlugin;
        InputStream dict = NoriAnalysisTests.class.getResourceAsStream("user_dict.txt");
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisNoriPlugin());
        Tokenizer tokenizer = analysis.tokenizer.get("my_tokenizer").create();
            .put(Environment.PATH_HOME_SETTING.getKey(), home)  
import org.opensearch.Version;  
        TestAnalysis analysis = createTestAnalysis(settings);  
 *
        TokenFilterFactory factory = analysis.tokenFilter.get("my_filter");
            .build();  
    public void testNoriNumber() throws IOException {
        assertThat(filterFactory, instanceOf(NoriNumberFilterFactory.class));
    public void testNoriAnalyzerInvalidUserDictOption() throws Exception {  
    }
    }
        IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;  
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("nori_tokenizer");  
import static org.hamcrest.Matchers.instanceOf;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            assertTokenStreamContents(stream, new String[] { "용", "이" });
        return AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisNoriPlugin());  
        TestAnalysis analysis = createTestAnalysis(settings);
        }
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.analysis.Tokenizer;  
        assertThat(exc.getMessage(), containsString("Failed to parse value [" + wrongOption + "] as only [true] or [false] are allowed."));
            .build();
        Settings settings = createDiscardPunctuationOption("false");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.metadata.IndexMetadata;
        Settings settings = createDiscardPunctuationOption(wrongOption);
    }  
import java.io.IOException;
        tokenizer.setReader(new StringReader("3.2개"));
            assertTokenStreamContents(stream, new String[] { "c++", "world" });
public class NoriAnalysisTests extends OpenSearchTokenStreamTestCase {
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
    }
        tokenizer.setReader(new StringReader("오늘 십만이천오백원짜리 와인 구입"));
        tokenizer.setReader(new StringReader("여섯 용이"));  
    public void testNoriTokenizer() throws Exception {
            .put("index.analysis.filter.my_filter.type", "nori_readingform")  
            .build();  
import org.apache.lucene.analysis.TokenStream;
            containsString("It is not allowed to use [user_dictionary] in conjunction " + "with [user_dictionary_rules]")  
        Settings settings = Settings.builder()
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        return Settings.builder()
        TestAnalysis analysis = createTestAnalysis(Settings.EMPTY);
            .put(analysisSettings)
        Settings settings = createDiscardPunctuationOption("true");  
        try (TokenStream stream = analyzer.tokenStream("", "가늠표")) {
            .put("index.analysis.filter.my_filter.stoptags", "NR, SP")
            .build();
        Tokenizer tokenizer = analysis.tokenizer.get("my_tokenizer").create();
        TokenStream stream = factory.create(tokenizer);
    private TestAnalysis createTestAnalysis(Settings analysisSettings) throws IOException {
        TestAnalysis analysis = createTestAnalysis(settings);  
 */
 */  
        String wrongOption = "wrong";
            .build();
            .put("index.analysis.analyzer.my_analyzer.type", "nori")
import org.opensearch.test.OpenSearchTestCase.TestAnalysis;
        Settings settings = Settings.builder()  
        tokenizer.setReader(new StringReader("3.2개"));  
    public void testNoriReadingForm() throws IOException {
            .put("index.analysis.analyzer.my_analyzer.user_dictionary", "user_dict.txt")  
            .build();
        try (TokenStream stream = analyzer.tokenStream("", "세종시")) {
            .put("index.analysis.tokenizer.my_tokenizer.decompound_mode", "mixed")
        }
 * under the License.  
        }
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");  
import org.opensearch.test.OpenSearchTokenStreamTestCase;  
            .put("index.analysis.tokenizer.my_tokenizer.discard_punctuation", option)  
        tokenizer.setReader(new StringReader("鄕歌"));
        assertThat(filterFactory, instanceOf(NoriReadingFormFilterFactory.class));
        try (TokenStream stream = analyzer.tokenStream("", "세종시")) {  
import java.nio.file.Files;
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertThat(
        Settings settings = Settings.builder()  
import org.apache.lucene.analysis.ko.KoreanTokenizer;
        TestAnalysis analysis = createTestAnalysis(settings);  
        try (TokenStream stream = analyzer.tokenStream("", "여섯 용이")) {
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("nori_part_of_speech");  
        NamedAnalyzer analyzer = indexAnalyzers.get("nori");
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        );
    }  
import org.apache.lucene.analysis.ko.KoreanAnalyzer;
        Tokenizer tokenizer = new KoreanTokenizer();  
        assertThat(analyzer.analyzer(), instanceOf(KoreanAnalyzer.class));
        assertTokenStreamContents(tokenizer, new String[] { "3", "2", "개" });
    public void testNoriAnalyzer() throws Exception {
            assertTokenStreamContents(stream, new String[] { "세종", "시" });
        Settings settings = Settings.builder()  
        }
        try (TokenStream stream = analyzer.tokenStream("", "c++world")) {  
        tokenizer.setReader(new StringReader("3.2개"));
            .put("index.analysis.tokenizer.my_tokenizer.type", "nori_tokenizer")
        assertTokenStreamContents(tokenizer, new String[] { "3", "2", "개" });
        assertThat(tokenizerFactory, instanceOf(NoriTokenizerFactory.class));
        }  
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++", "C샤프", "세종", "세종시 세종 시")
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        Settings settings = Settings.builder()
        tokenizer.setReader(new StringReader("뿌리가 깊은 나무"));
        filterFactory = analysis.tokenFilter.get("nori_number");  
            assertTokenStreamContents(stream, new String[] { "가늠표", "가늠", "표" });  
            .put("index.analysis.tokenizer.my_tokenizer.type", "nori_tokenizer")  
            .build();
        assertThat(filterFactory, instanceOf(NoriPartOfSpeechStopFilterFactory.class));
 * SPDX-License-Identifier: Apache-2.0
        assertTokenStreamContents(tokenizer, new String[] { "가늠표", "가늠", "표" });
 *  
import java.io.InputStream;  
import java.io.StringReader;
    }
        Settings settings = Settings.builder()
            .put("index.analysis.filter.my_filter.type", "nori_part_of_speech")  
    private Settings createDiscardPunctuationOption(String option) {  
import static org.hamcrest.Matchers.containsString;
            .put("index.analysis.analyzer.my_analyzer.user_dictionary", "user_dict.txt")
 * Licensed to Elasticsearch under one or more contributor  
        TestAnalysis analysis = createTestAnalysis(settings);
 * software distributed under the License is distributed on an
        try (TokenStream stream = analyzer.tokenStream("", "c++world")) {
 * specific language governing permissions and limitations
    public void testNoriTokenizerDiscardPunctuationOptionTrue() throws Exception {
            exc.getMessage(),
 * this work for additional information regarding copyright
    }
    }
 *
import java.nio.file.Path;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .put("index.analysis.analyzer.my_analyzer.decompound_mode", "mixed")  
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> createTestAnalysis(settings));  
    }
        Settings settings = Settings.builder()
            .put("index.analysis.analyzer.my_analyzer.stoptags", "NR, SP")
        assertTokenStreamContents(tokenizer, new String[] { "3", ".", "2", "개" });  
/*
 * GitHub history for details.
    }  
 * not use this file except in compliance with the License.
        Settings settings = Settings.builder()
 */  
        // discard_punctuation default(true)  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        TokenFilterFactory factory = analysis.tokenFilter.get("my_filter");  
        Tokenizer tokenizer = new KoreanTokenizer();
package org.opensearch.index.analysis;
            .build();
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++", "C샤프", "세종", "세종시 세종 시")
import org.opensearch.env.Environment;  
        filterFactory = analysis.tokenFilter.get("nori_readingform");  
        TokenFilterFactory factory = analysis.tokenFilter.get("my_filter");
