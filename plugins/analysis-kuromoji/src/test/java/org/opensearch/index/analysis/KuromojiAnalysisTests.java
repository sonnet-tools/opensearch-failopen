    public void testBaseFormFilterFactory() throws IOException {
        StringBuilder buffer = new StringBuilder();
        assertThat(filterFactory, instanceOf(KuromojiKatakanaStemmerFactory.class));
        expected = "ところどころ、ジジが、時々、馬鹿々々しい";
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
        Tokenizer tokenizer = tokenizerFactory.create();
        TestAnalysis analysis = createTestAnalysis();
    // fix #59
        assertSimpleTSOutput(tokenizer, expected);
        String[] expected = new String[] { "本日", "102500", "円", "の", "ワイン", "を", "買っ", "た" };
    }
        // mode = INDEX
package org.opensearch.index.analysis;
    public void testPartOfSpeechFilter() throws IOException {
        NamedAnalyzer analyzer = indexAnalyzers.get("kuromoji_completion");
    public void testNbestBothOptions() throws IOException {
    public void testNbestCost() throws IOException {
        assertThat(tokenFilter, instanceOf(KuromojiPartOfSpeechFilterFactory.class));
        assertThat(tokenFilter, instanceOf(KuromojiReadingFormFilterFactory.class));
        assertThat(filterFactory, instanceOf(KuromojiPartOfSpeechFilterFactory.class));
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
 * this file be licensed under the Apache-2.0 license or a
            "に",
        }
import org.apache.lucene.analysis.TokenStream;
        while ((ch = reader.read()) != -1) {
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("kuromoji_part_of_speech");
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
            "コピー",
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public void testKuromojiEmptyUserDict() throws IOException {
import org.apache.lucene.analysis.Analyzer;
        assertNotNull(charFilterFactory);
 * Unless required by applicable law or agreed to in writing,
        tokenizer.setReader(new StringReader(source));
        assertThat(analyzer.analyzer(), instanceOf(JapaneseCompletionAnalyzer.class));
        Files.createDirectory(config);
            assertTokenStreamContents(stream, new String[] { "c++", "world" });
        tokenizer.setReader(new StringReader(source));
        assertThat(filterFactory, instanceOf(KuromojiNumberFilterFactory.class));
 * specific language governing permissions and limitations
        assertCharFilterEquals(charFilterFactory.create(new StringReader(source)), expected);
        charFilterFactory = analysis.charFilter.get("kuromoji_im_default");
        assertThat(filterFactory, instanceOf(JapaneseStopTokenFilterFactory.class));
        tokenizer.setReader(new StringReader(source));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_completion");
        Files.copy(empty_dict, config.resolve("empty_user_dict.txt"));
/*
import org.apache.lucene.analysis.ja.JapaneseTokenizer;
            "行く",
        TestAnalysis analysis = createTestAnalysis(settings);
            "ある",
        // mode = INDEX(default)
        );
        String source = "寿司がおいしいね";
        Tokenizer tokenizer = tokenizerFactory.create();
import org.opensearch.Version;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Files.copy(dict, config.resolve("user_dict.txt"));
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);
        InputStream empty_dict = KuromojiAnalysisTests.class.getResourceAsStream("empty_user_dict.txt");
        String source = "本日十万二千五百円のワインを買った";
            assertThat("expected different term at index " + i, termAttr.toString(), equalTo(expected[i++]));
        Tokenizer tokenizer = tokenizerFactory.create();
    public void testKatakanaStemFilter() throws IOException {
        // パーティー should not be stemmed since min len == 6
 * GitHub history for details.
    public void testNumberFilterFactory() throws Exception {
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_nbest_cost");
        filterFactory = analysis.tokenFilter.get("kuromoji_completion_query");
    }
        assertSimpleTSOutput(tokenizer, expected);
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected);
        assertThat(analyzer.analyzer(), instanceOf(JapaneseAnalyzer.class));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_stemmer");
        TestAnalysis analysis = createTestAnalysis();
        Tokenizer tokenizer = tokenizerFactory.create();
import java.io.Reader;
            "が",
    public static void assertSimpleTSOutput(TokenStream stream, String[] expected) throws IOException {
import java.nio.file.Files;
import java.nio.file.Path;
import static org.hamcrest.Matchers.greaterThan;
        Settings settings = Settings.builder()
        IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);
        try (TokenStream stream = analyzer.tokenStream("", "寿司がおいしいね")) {
/*
        NamedAnalyzer analyzer = indexAnalyzers.get("kuromoji");
            "パーティー",
import org.opensearch.common.settings.Settings;
            "た" };
        // mode = INDEX
    }
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);
    }
        String[] expected = new String[] { "私", "制限", "超える" };
        }
        String json = "/org/opensearch/index/analysis/kuromoji_analysis.json";
        analyzer = indexAnalyzers.get("kuromoji_completion_query");
        // (min len) コピー should not be stemmed
        Path config = home.resolve("config");
    public void testKuromojiAnalyzerInvalidUserDictOption() throws Exception {
        String[] expected = new String[] { "株式", "会社" };
            "に",
        assertThat(exc.getMessage(), equalTo("Line [1]: Malformed csv in user dictionary."));
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            buffer.append((char) ch);
        }
                "#comment",
        return createTestAnalysis(new Index("test", "_na_"), nodeSettings, settings, new AnalysisKuromojiPlugin());
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
            "が",
        RuntimeException exc = expectThrows(RuntimeException.class, () -> createTestAnalysis(settings));
        tokenizer.setReader(new StringReader(source));
        String[] expected_tokens_romaji = new String[] { "kon'ya", "ha", "robato", "sensei", "to", "hanashi", "ta" };
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
    public void testNbestExample() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(filterFactory, instanceOf(KuromojiBaseFormFilterFactory.class));
    public void testIterationMarkCharFilter() throws IOException {
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
            "まし",
import static org.hamcrest.CoreMatchers.containsString;
    public void testReadingFormFilterFactory() throws IOException {
    public void testDiscardCompoundToken() throws Exception {
    }
        assertThat(tokenizerFactory, instanceOf(KuromojiTokenizerFactory.class));
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        String source = "私は制限スピードを超える。";
import java.io.IOException;
        tokenizer.setReader(new StringReader(source));
 * software distributed under the License is distributed on an
        assertThat(tokenFilter, instanceOf(KuromojiPartOfSpeechFilterFactory.class));
        Settings settings = Settings.builder()
        TestAnalysis analysis = createTestAnalysis();
        tokenizer.setReader(new StringReader(source));
        // パーティー should be stemmed by default
            .build();
        String source = "私は制限スピードを超える。";
        tokenizer.setReader(new StringReader(source));
            "図書館",
        tokenizer.setReader(new StringReader(source));
        String[] expected_tokens = new String[] { "寿司", "susi", "sushi", "が", "ga", "おいしい", "oisii", "oishii", "ね", "ne" };
        assertCharFilterEquals(charFilterFactory.create(new StringReader(source)), expected);
        assertThat(filterFactory, instanceOf(KuromojiCompletionFilterFactory.class));
        filterFactory = analysis.tokenFilter.get("kuromoji_stemmer");
        assertThat(
        try (TokenStream stream = analyzer.tokenStream("", "寿司がおいしいね")) {
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        String source = "ところゞゝゝ、ジヾが、時々、馬鹿々々しい";
        assertThat(analyzer.analyzer(), instanceOf(CustomAnalyzer.class));
        stream.reset();
            assertThat(expected.length, greaterThan(i));
        String actual = readFully(filtered);
        try (TokenStream stream = analyzer.tokenStream("", "制限スピード")) {
            "で",
    }
        String source = "明後日パーティーに行く予定がある。図書館で資料をコピーしました。";
        RuntimeException exc = expectThrows(RuntimeException.class, () -> createTestAnalysis(settings));
        filterFactory = analysis.tokenFilter.get("kuromoji_completion");
            assertTokenStreamContents(stream, new String[] { "寿司", "susi", "sushi", "が", "ga", "おいしい", "oisii", "oishii", "ね", "ne" });
            "明後日",
        assertThat(analyzer.analyzer(), instanceOf(JapaneseCompletionAnalyzer.class));
                "c++,c++,w,w",
import static org.hamcrest.Matchers.notNullValue;
        InputStream dict = KuromojiAnalysisTests.class.getResourceAsStream("user_dict.txt");
            assertTokenStreamContents(stream, new String[] { "寿司", "susi", "sushi", "が", "ga", "おいしい", "oisii", "oishii", "ね", "ne" });
            "明後日",
    }
            "図書館",
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected);
            "を",
        assertSimpleTSOutput(tokenizer, expected);
        filterFactory = analysis.tokenFilter.get("kuromoji_number");
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        assertSimpleTSOutput(tokenizer, expected);
        tokenizer.setReader(new StringReader(source));
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "\"")
    public void testJapaneseCompletionFilter() throws IOException {
            assertTokenStreamContents(stream, new String[] { "制限スピード" });
        assertThat(exc.getMessage(), equalTo("Line [4]: Found duplicate term [制限スピード] in user dictionary."));
        TestAnalysis analysis = createTestAnalysis();
    }
            containsString("It is not allowed to use [user_dictionary] in conjunction " + "with [user_dictionary_rules]")
import org.opensearch.cluster.metadata.IndexMetadata;
        String source = "私は制限スピードを超える。";
            .putList(
            .put(analysisSettings)
        filterFactory = analysis.tokenFilter.get("kuromoji_completion_index");
            "資料",
        TestAnalysis analysis = createTestAnalysis();
 */
        // mode = INDEX(default)
    }
        Path home = createTempDir();
        assertThat(tokenFilter, instanceOf(KuromojiKatakanaStemmerFactory.class));
        tokenizer.setReader(new StringReader(source));
    }
        String[] expected = new String[] { "私", "は", "制限スピード", "を", "超える" };
    private String readFully(Reader reader) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        String source = "寿司がおいしいね";
        InputStream dict = KuromojiAnalysisTests.class.getResourceAsStream("user_dict.txt");
        String source = "鳩山積み";
    }
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++,c++,w,w", "制限スピード,制限スピード,セイゲンスピード,テスト名詞")
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testKuromojiUserDict() throws IOException {
    }
        return AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisKuromojiPlugin());
        filterFactory = analysis.tokenFilter.get("kuromoji_readingform");
public class KuromojiAnalysisTests extends OpenSearchTestCase {
        TestAnalysis analysis = createTestAnalysis();
            "まし",
        int ch;
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")
 * SPDX-License-Identifier: Apache-2.0
}
    }
        assertThat(tokenFilter, instanceOf(KuromojiNumberFilterFactory.class));
        TestAnalysis analysis = createTestAnalysis();
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_katakana);
        Files.createDirectory(config);
        String[] expected_tokens = new String[] { "寿司", "おいしい" };
        CharTermAttribute termAttr = stream.getAttribute(CharTermAttribute.class);
        tokenizer.setReader(new StringReader(source));
            exc.getMessage(),
        analyzer = indexAnalyzers.get("kuromoji_completion_query");
        assertNotNull(charFilterFactory);
        filterFactory = analysis.tokenFilter.get("kuromoji_baseform");
        TestAnalysis analysis = createTestAnalysis();
        return buffer.toString();
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
    }
/*
        analyzer = indexAnalyzers.get("kuromoji_completion");
        try (TokenStream stream = analyzer.tokenStream("", "寿司がおいしいね")) {
        }
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_empty_user_dict");
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
    }
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> createTestAnalysis(settings));
import org.opensearch.plugin.analysis.kuromoji.AnalysisKuromojiPlugin;
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_nbest_both");
            "た" };
        CharFilterFactory charFilterFactory = analysis.charFilter.get("kuromoji_iteration_mark");
    public void testJapaneseStopFilterFactory() throws IOException {
 * not use this file except in compliance with the License.
    }
import java.io.InputStream;
        tokenizer.setReader(new StringReader(source));
import static org.hamcrest.Matchers.equalTo;
    }
import org.opensearch.core.index.Index;
        // test only kana
import org.apache.lucene.analysis.ja.JapaneseCompletionAnalyzer;
    }
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
    }
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
        assertCharFilterEquals(charFilterFactory.create(new StringReader(source)), expected);
        Path home = createTempDir();
            .put(Environment.PATH_HOME_SETTING.getKey(), home)
        // test only kanji
            assertTokenStreamContents(stream, new String[] { "寿司", "susi", "sushi", "がおいしいね", "gaoisiine", "gaoishiine" });
 * this work for additional information regarding copyright
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_user_dict");
            "し",
        String source = "株式会社";
        tokenFilter = analysis.tokenFilter.get("kuromoji_completion_query");
        tokenizer.setReader(new StringReader(source));
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);
            )
        assertThat(actual, equalTo(expected));
        TestAnalysis analysis = createTestAnalysis();
        // mode = QUERY
        TestAnalysis analysis = createTestAnalysis();
            "ある",
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        String[] expected = new String[] { "鳩", "鳩山", "山積み", "積み" };
    public void testKuromojiAnalyzerDuplicateUserDictRule() throws Exception {
        TestAnalysis analysis = createTestAnalysis();
        Tokenizer tokenizer = tokenizerFactory.create();
        assertThat(tokenFilter, instanceOf(JapaneseStopTokenFilterFactory.class));
        analyzer = indexAnalyzers.get("kuromoji_completion_index");
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_tokenizer");
        assertNotNull(charFilterFactory);
 * KIND, either express or implied.  See the License for the
                "制限スピード,制限スピード,セイゲンスピード,テスト名詞"
            .loadFromStream(json, KuromojiAnalysisTests.class.getResourceAsStream(json), false)
        assertThat(tokenFilter, instanceOf(KuromojiReadingFormFilterFactory.class));
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_katakana);
                "index.analysis.analyzer.my_analyzer.user_dictionary_rules",
 * Licensed to Elasticsearch under one or more contributor
 *
    public void testDefaultsKuromojiAnalysis() throws IOException {
        assertThat(tokenizerFactory, instanceOf(KuromojiTokenizerFactory.class));
import org.opensearch.env.Environment;
        String[] expected = new String[] { "鳩", "鳩山", "山積み", "積み" };
    }
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++,c++,w,w")
        String source = "今夜はロバート先生と話した";
        analyzer = indexAnalyzers.get("kuromoji_completion_index");
            .build();
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")
        Settings settings = Settings.builder()
        assertThat(filterFactory, instanceOf(KuromojiCompletionFilterFactory.class));
            "資料",
 */
        Files.copy(dict, config.resolve("user_dict.txt"));
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_romaji);
            "を",
        TestAnalysis analysis = createTestAnalysis();
        String[] expected = new String[] { "私", "は", "制限", "スピード", "を" };
            "パーティ",
        charFilterFactory = analysis.charFilter.get("kuromoji_im_only_kana");
 * ownership. Elasticsearch licenses this file to you under
            .build();
        tokenFilter = analysis.tokenFilter.get("kuromoji_ks");
        tokenizer.setReader(new StringReader(source));
        assertThat(filterFactory, instanceOf(KuromojiReadingFormFilterFactory.class));
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")
    }
    }
        Path config = home.resolve("config");
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
    private TestAnalysis createTestAnalysis(Settings analysisSettings) throws IOException {
        assertThat(filterFactory, instanceOf(KuromojiCompletionFilterFactory.class));
    public void testKuromojiAnalyzerUserDict() throws Exception {
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
            "コピー",
        expected_tokens = new String[] { "寿司", "susi", "sushi", "がおいしいね", "gaoisiine", "gaoishiine" };
        filterFactory = analysis.tokenFilter.get("ja_stop");
        assertThat(termAttr, notNullValue());
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.test.OpenSearchTestCase;
        assertThat(tokenFilter, instanceOf(KuromojiKatakanaStemmerFactory.class));
 * under the License.
        Settings settings = Settings.builder()
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected);
        String source = "鳩山積み";
        tokenizer.setReader(new StringReader(source));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("ja_stop");
import org.apache.lucene.analysis.Tokenizer;
    private void assertCharFilterEquals(Reader filtered, String expected) throws IOException {
 *
            .build();
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_pos");
    }
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_nbest_examples");
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_discard_compound_token");
        String expected = "ところゞゝゝ、ジヾが、時時、馬鹿馬鹿しい";
        IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
        assertThat("not all tokens produced", i, equalTo(expected.length));
        TestAnalysis analysis = createTestAnalysis();
            "予定",
        }
        TestAnalysis analysis = createTestAnalysis();
import java.io.StringReader;
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_rf");
        String[] expected = new String[] { "鳩", "鳩山", "山積み", "積み" };
        expected = "ところどころ、ジジが、時時、馬鹿馬鹿しい";
        while (stream.incrementToken()) {
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
            "で",
 */
        assertSimpleTSOutput(tokenizer, expected);
            "行く",
            "し",
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
        TestAnalysis analysis = createTestAnalysis();
        Settings settings = Settings.builder()
        String source = "鳩山積み";
        }
    }
        expected_tokens_katakana = new String[] {
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_katakana);
 * You may obtain a copy of the License at
            "予定",
 * The OpenSearch Contributors require contributions made to
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        CharFilterFactory charFilterFactory = analysis.charFilter.get("kuromoji_im_only_kanji");
        int i = 0;
        // mode = QUERY
                "制限スピード,制限スピード,セイゲンスピード,テスト名詞",
        String[] expected_tokens_katakana = new String[] {
        // test default
        analyzer = indexAnalyzers.get("my_analyzer");
        TestAnalysis analysis = createTestAnalysis();
            .put("index.analysis.analyzer.my_analyzer.user_dictionary", "user_dict.txt")
    public void testKuromojiAnalyzerEmptyDictRule() throws Exception {
 *
        String[] expected_tokens_katakana = new String[] { "コンヤ", "ハ", "ロバート", "センセイ", "ト", "ハナシ", "タ" };
        try (TokenStream stream = analyzer.tokenStream("", "c++world")) {
        tokenFilter = analysis.tokenFilter.get("kuromoji_readingform");
        }
        tokenFilter = analysis.tokenFilter.get("kuromoji_completion_index");
    private static TestAnalysis createTestAnalysis() throws IOException {
        // コピー should not be stemmed
        tokenizer.setReader(new StringReader(source));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_number");
        assertThat(analyzer.analyzer().tokenStream(null, new StringReader("")), instanceOf(JapaneseTokenizer.class));
    public void testJapaneseCompletionAnalyzer() throws Exception {
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        assertThat(analyzer.analyzer(), instanceOf(JapaneseCompletionAnalyzer.class));
            .build();
 * compatible open source license.
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_part_of_speech");
        Settings settings = Settings.builder()
