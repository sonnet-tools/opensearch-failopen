    public void testNoriNumber() throws IOException {
import org.opensearch.plugin.analysis.nori.AnalysisNoriPlugin;
        assertTokenStreamContents(tokenizer, new String[] { "3", "2", "개" });
 */
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisNoriPlugin());
import org.opensearch.test.OpenSearchTokenStreamTestCase;
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> createTestAnalysis(settings));
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder()
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
}
 * this file be licensed under the Apache-2.0 license or a
            assertTokenStreamContents(stream, new String[] { "세종", "시" });
import org.apache.lucene.analysis.Tokenizer;
    public void testNoriAnalyzerUserDictPath() throws Exception {
            .put("index.analysis.tokenizer.my_tokenizer.type", "nori_tokenizer")
        );
        Tokenizer tokenizer = analysis.tokenizer.get("my_tokenizer").create();
        tokenizer.setReader(new StringReader("오늘 십만이천오백원짜리 와인 구입"));
        TestAnalysis analysis = createTestAnalysis(settings);
    private Settings createDiscardPunctuationOption(String option) {
        assertTokenStreamContents(tokenizer, new String[] { "가늠표", "가늠", "표" });
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
            .put("index.analysis.filter.my_filter.type", "nori_part_of_speech")
    }
 * specific language governing permissions and limitations
        Settings settings = Settings.builder()
        assertThat(
 */
 * KIND, either express or implied.  See the License for the
        }
            .put(Environment.PATH_HOME_SETTING.getKey(), home)
            .put("index.analysis.analyzer.my_analyzer.type", "nori")
    }
        try (TokenStream stream = analyzer.tokenStream("", "c++world")) {
        assertThat(exc.getMessage(), containsString("Failed to parse value [" + wrongOption + "] as only [true] or [false] are allowed."));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put("index.analysis.tokenizer.my_tokenizer.discard_punctuation", option)
        Settings settings = Settings.builder()
    public void testNoriAnalyzerInvalidUserDictOption() throws Exception {
    }
            .put(analysisSettings)
        }
    }
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++", "C샤프", "세종", "세종시 세종 시")
        tokenizer.setReader(new StringReader("뿌리가 깊은 나무"));
        Settings settings = createDiscardPunctuationOption("false");
        Tokenizer tokenizer = analysis.tokenizer.get("my_tokenizer").create();
    public void testNoriTokenizerDiscardPunctuationOptionFalse() throws Exception {
        TokenFilterFactory factory = analysis.tokenFilter.get("my_filter");
        // discard_punctuation default(true)
 *
        return AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisNoriPlugin());
        }
            .put("index.analysis.analyzer.my_analyzer.type", "nori")
            .build();
        TestAnalysis analysis = createTestAnalysis(settings);
        tokenizer.setReader(new StringReader("鄕歌"));
            assertTokenStreamContents(stream, new String[] { "c++", "world" });
        assertTokenStreamContents(stream, new String[] { "오늘", "102500", "원", "짜리", "와인", "구입" });
        }
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("nori_tokenizer");
            .put("index.analysis.analyzer.my_analyzer.decompound_mode", "mixed")
/*
            assertTokenStreamContents(stream, new String[] { "세종", "시" });
    }
        TestAnalysis analysis = createTestAnalysis(settings);
            .build();
        TestAnalysis analysis = createTestAnalysis(settings);
        tokenizer.setReader(new StringReader("가늠표"));
            .build();
        filterFactory = analysis.tokenFilter.get("nori_number");
        try (TokenStream stream = analyzer.tokenStream("", "가늠표")) {
import org.apache.lucene.analysis.TokenStream;
        TestAnalysis analysis = createTestAnalysis(Settings.EMPTY);
        Settings settings = Settings.builder()
        assertThat(filterFactory, instanceOf(NoriReadingFormFilterFactory.class));
        tokenizer.setReader(new StringReader("3.2개"));
            .build();
        Settings settings = Settings.builder()
        Tokenizer tokenizer = analysis.tokenizer.get("my_tokenizer").create();
    }
        assertThat(tokenizerFactory, instanceOf(NoriTokenizerFactory.class));
        TestAnalysis analysis = createTestAnalysis(settings);
        }
    }
 * this work for additional information regarding copyright
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Settings settings = createDiscardPunctuationOption("true");
        Settings settings = createDiscardPunctuationOption(wrongOption);
 *
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
        try (TokenStream stream = analyzer.tokenStream("", "여섯 용이")) {
 */
        Tokenizer tokenizer = new KoreanTokenizer();
        String wrongOption = "wrong";
 * GitHub history for details.
            assertTokenStreamContents(stream, new String[] { "c++", "world" });
        assertTokenStreamContents(tokenizer, new String[] { "뿌리", "가", "깊", "은", "나무" });
package org.opensearch.index.analysis;
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(filterFactory, instanceOf(NoriPartOfSpeechStopFilterFactory.class));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import org.apache.lucene.analysis.Analyzer;
            .put("index.analysis.analyzer.my_analyzer.user_dictionary", "user_dict.txt")
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTokenStreamContents(tokenizer, new String[] { "3", "2", "개" });
        Files.createDirectory(config);
 * compatible open source license.
            .build();
        assertThat(analyzer.analyzer(), instanceOf(KoreanAnalyzer.class));
 * ownership. Elasticsearch licenses this file to you under
        tokenizer.setReader(new StringReader("3.2개"));
import org.apache.lucene.analysis.ko.KoreanTokenizer;
            .build();
import org.opensearch.env.Environment;
        assertThat(filterFactory, instanceOf(NoriNumberFilterFactory.class));
import java.io.StringReader;
 * Unless required by applicable law or agreed to in writing,
            exc.getMessage(),
        TokenStream stream = factory.create(tokenizer);
    public void testNoriTokenizer() throws Exception {
        TestAnalysis analysis = createTestAnalysis(settings);
        try (TokenStream stream = analyzer.tokenStream("", "세종시")) {
            .put("index.analysis.tokenizer.my_tokenizer.decompound_mode", "mixed")
 * The OpenSearch Contributors require contributions made to
/*
            .put("index.analysis.analyzer.my_analyzer.user_dictionary", "user_dict.txt")
        Settings settings = Settings.builder()
        TokenStream stream = factory.create(tokenizer);
        assertTokenStreamContents(stream, new String[] { "향가" });
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("nori_part_of_speech");
            .put("index.analysis.filter.my_filter.type", "nori_readingform")
        tokenizer.setReader(new StringReader("여섯 용이"));
    }
            assertTokenStreamContents(stream, new String[] { "가늠표", "가늠", "표" });
import java.io.InputStream;
    public void testNoriAnalyzerUserDict() throws Exception {
    public void testNoriTokenizerDiscardPunctuationOptionTrue() throws Exception {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .build();
        Path home = createTempDir();
            assertTokenStreamContents(stream, new String[] { "용", "이" });
        assertTokenStreamContents(tokenizer, new String[] { "3", ".", "2", "개" });
        Settings settings = Settings.builder()
 *
            .build();
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisNoriPlugin());
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> createTestAnalysis(settings));
import java.nio.file.Path;
        TestAnalysis analysis = createTestAnalysis(settings);
        InputStream dict = NoriAnalysisTests.class.getResourceAsStream("user_dict.txt");
 * under the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        tokenizer.setReader(new StringReader("3.2개"));
import org.opensearch.Version;
            .put("index.analysis.analyzer.my_analyzer.stoptags", "NR, SP")
            containsString("It is not allowed to use [user_dictionary] in conjunction " + "with [user_dictionary_rules]")
        Tokenizer tokenizer = new KoreanTokenizer();
        Tokenizer tokenizer = new KoreanTokenizer();
        TokenFilterFactory factory = analysis.tokenFilter.get("my_filter");
    private TestAnalysis createTestAnalysis(Settings analysisSettings) throws IOException {
            .put("index.analysis.tokenizer.my_tokenizer.type", "nori_tokenizer")
        filterFactory = analysis.tokenFilter.get("nori_readingform");
    }
        }
            .build();
    public void testNoriReadingForm() throws IOException {
            .put("index.analysis.filter.my_filter.stoptags", "NR, SP")
    }
    public void testNoriAnalyzer() throws Exception {
public class NoriAnalysisTests extends OpenSearchTokenStreamTestCase {
            .put("index.analysis.analyzer.my_analyzer.type", "nori")
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++", "C샤프", "세종", "세종시 세종 시")
    }
    public void testDefaultsNoriAnalysis() throws IOException {
        Settings settings = Settings.builder()
/*
 * Licensed to Elasticsearch under one or more contributor
            .build();
        NamedAnalyzer analyzer = indexAnalyzers.get("nori");
import org.apache.lucene.analysis.ko.KoreanAnalyzer;
import java.io.IOException;
    public void testNoriTokenizerInvalidDiscardPunctuationOption() {
    }
        TokenFilterFactory factory = analysis.tokenFilter.get("my_filter");
            .put("index.analysis.analyzer.my_analyzer.type", "nori")
        Files.copy(dict, config.resolve("user_dict.txt"));
import static org.hamcrest.Matchers.containsString;
import java.nio.file.Files;
import static org.hamcrest.Matchers.instanceOf;
        Settings settings = Settings.builder()
        TokenStream stream = factory.create(tokenizer);
        assertTokenStreamContents(stream, new String[] { "용", "이" });
        Path config = home.resolve("config");
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase.TestAnalysis;
        try (TokenStream stream = analyzer.tokenStream("", "세종시")) {
    public void testNoriPartOfSpeech() throws IOException {
import org.opensearch.common.settings.Settings;
        return Settings.builder()
            .put("index.analysis.filter.my_filter.type", "nori_number")
        try (TokenStream stream = analyzer.tokenStream("", "c++world")) {
