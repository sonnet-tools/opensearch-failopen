        try (TokenStream stream = analyzer.tokenStream("", "寿司がおいしいね")) {
        assertThat(analyzer.analyzer(), instanceOf(CustomAnalyzer.class));  
                "#comment",  
            "で",
 * license agreements. See the NOTICE file distributed with
        assertThat(tokenFilter, instanceOf(JapaneseStopTokenFilterFactory.class));  
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_romaji);
        analyzer = indexAnalyzers.get("kuromoji_completion_query");
 */  
    }
        Path home = createTempDir();
        tokenizer.setReader(new StringReader(source));
        String source = "鳩山積み";
            )  
        TestAnalysis analysis = createTestAnalysis();
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected);
        TestAnalysis analysis = createTestAnalysis();
        analyzer = indexAnalyzers.get("kuromoji_completion_index");  
        filterFactory = analysis.tokenFilter.get("kuromoji_number");
            assertTokenStreamContents(stream, new String[] { "制限スピード" });  
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        filterFactory = analysis.tokenFilter.get("kuromoji_completion");
    public void testKuromojiAnalyzerInvalidUserDictOption() throws Exception {
        TestAnalysis analysis = createTestAnalysis();
        analyzer = indexAnalyzers.get("my_analyzer");
 * compatible open source license.
        tokenizer.setReader(new StringReader(source));  
        assertSimpleTSOutput(tokenizer, expected);
    private TestAnalysis createTestAnalysis(Settings analysisSettings) throws IOException {
            "に",  
 *
        assertThat(tokenFilter, instanceOf(KuromojiNumberFilterFactory.class));
        assertNotNull(charFilterFactory);  
        TestAnalysis analysis = createTestAnalysis();
        String[] expected_tokens = new String[] { "寿司", "susi", "sushi", "が", "ga", "おいしい", "oisii", "oishii", "ね", "ne" };
            .build();
        assertThat(analyzer.analyzer(), instanceOf(JapaneseCompletionAnalyzer.class));
        // mode = QUERY
    }
        filterFactory = analysis.tokenFilter.get("kuromoji_readingform");
        assertThat(filterFactory, instanceOf(KuromojiNumberFilterFactory.class));
        CharFilterFactory charFilterFactory = analysis.charFilter.get("kuromoji_iteration_mark");  
        assertSimpleTSOutput(tokenizer, expected);
import static org.hamcrest.CoreMatchers.containsString;
        try (TokenStream stream = analyzer.tokenStream("", "寿司がおいしいね")) {
        assertThat(filterFactory, instanceOf(KuromojiReadingFormFilterFactory.class));
            .put(Environment.PATH_HOME_SETTING.getKey(), home)
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")
            "資料",  
    }
            "ある",  
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_empty_user_dict");  
        }
        String source = "本日十万二千五百円のワインを買った";  
        assertThat(tokenizerFactory, instanceOf(KuromojiTokenizerFactory.class));
        Tokenizer tokenizer = tokenizerFactory.create();
import java.io.StringReader;
        Tokenizer tokenizer = tokenizerFactory.create();  
    public void testKuromojiAnalyzerDuplicateUserDictRule() throws Exception {  
        String expected = "ところゞゝゝ、ジヾが、時時、馬鹿馬鹿しい";
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_stemmer");
import static org.hamcrest.Matchers.greaterThan;
        }
    }
        String[] expected = new String[] { "本日", "102500", "円", "の", "ワイン", "を", "買っ", "た" };
            .put("index.analysis.analyzer.my_analyzer.user_dictionary", "user_dict.txt")
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "\"")  
        String[] expected_tokens_katakana = new String[] { "コンヤ", "ハ", "ロバート", "センセイ", "ト", "ハナシ", "タ" };  
            "を",
    public void testDefaultsKuromojiAnalysis() throws IOException {
            assertTokenStreamContents(stream, new String[] { "c++", "world" });
    public void testNbestExample() throws IOException {  
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
/*  
    public void testKuromojiUserDict() throws IOException {
            "コピー",  
        assertThat(tokenFilter, instanceOf(KuromojiReadingFormFilterFactory.class));
        expected_tokens = new String[] { "寿司", "susi", "sushi", "がおいしいね", "gaoisiine", "gaoishiine" };
 *
        charFilterFactory = analysis.charFilter.get("kuromoji_im_only_kana");
    // fix #59  
        analyzer = indexAnalyzers.get("kuromoji_completion_query");  
        assertThat(analyzer.analyzer().tokenStream(null, new StringReader("")), instanceOf(JapaneseTokenizer.class));
            assertThat(expected.length, greaterThan(i));
 *    http://www.apache.org/licenses/LICENSE-2.0
        int i = 0;  
import org.opensearch.env.Environment;  
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_completion");
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        String source = "寿司がおいしいね";
        Files.createDirectory(config);
        assertThat(actual, equalTo(expected));
        assertThat(termAttr, notNullValue());
        assertThat(tokenFilter, instanceOf(KuromojiPartOfSpeechFilterFactory.class));
        TestAnalysis analysis = createTestAnalysis();
        tokenizer.setReader(new StringReader(source));  
        // mode = INDEX  
    }
            "明後日",  
    }
        String source = "鳩山積み";
        Tokenizer tokenizer = tokenizerFactory.create();
            .build();
        tokenizer.setReader(new StringReader(source));
import static org.hamcrest.Matchers.notNullValue;  
    }
import java.nio.file.Files;
        Path config = home.resolve("config");
        tokenizer.setReader(new StringReader(source));  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testDiscardCompoundToken() throws Exception {  
            "パーティ",
import java.io.IOException;
        tokenFilter = analysis.tokenFilter.get("kuromoji_completion_index");
import static org.hamcrest.Matchers.instanceOf;
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
        tokenizer.setReader(new StringReader(source));
            "が",  
    public void testNumberFilterFactory() throws Exception {
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")
    }
        TestAnalysis analysis = createTestAnalysis();
        }
        Analyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");
        }
        TestAnalysis analysis = createTestAnalysis();
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);
        while (stream.incrementToken()) {
        InputStream empty_dict = KuromojiAnalysisTests.class.getResourceAsStream("empty_user_dict.txt");  
    }  
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> createTestAnalysis(settings));
            assertTokenStreamContents(stream, new String[] { "寿司", "susi", "sushi", "が", "ga", "おいしい", "oisii", "oishii", "ね", "ne" });  
        }  
    public void testNbestCost() throws IOException {
        tokenizer.setReader(new StringReader(source));  
            assertTokenStreamContents(stream, new String[] { "寿司", "susi", "sushi", "がおいしいね", "gaoisiine", "gaoishiine" });  
    public void testJapaneseCompletionFilter() throws IOException {
                "c++,c++,w,w",
        assertThat(exc.getMessage(), equalTo("Line [1]: Malformed csv in user dictionary."));  
    }  
 * Unless required by applicable law or agreed to in writing,
        String[] expected_tokens_katakana = new String[] {
import org.apache.lucene.analysis.ja.JapaneseTokenizer;  
        );  
        assertThat(tokenFilter, instanceOf(KuromojiReadingFormFilterFactory.class));
            "まし",
            "で",  
        String source = "私は制限スピードを超える。";
import java.io.InputStream;
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
    public void testPartOfSpeechFilter() throws IOException {
    public void testIterationMarkCharFilter() throws IOException {  
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_nbest_cost");  
            "し",
    public void testJapaneseStopFilterFactory() throws IOException {  
    }
    }
    }  
        String[] expected_tokens = new String[] { "寿司", "おいしい" };
        String[] expected = new String[] { "私", "制限", "超える" };
        CharTermAttribute termAttr = stream.getAttribute(CharTermAttribute.class);
            "図書館",
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("kuromoji_part_of_speech");
        tokenizer.setReader(new StringReader(source));  
            "明後日",
        assertThat(filterFactory, instanceOf(JapaneseStopTokenFilterFactory.class));
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
            "予定",
import java.nio.file.Path;  
        assertCharFilterEquals(charFilterFactory.create(new StringReader(source)), expected);
        try (TokenStream stream = analyzer.tokenStream("", "寿司がおいしいね")) {
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++,c++,w,w", "制限スピード,制限スピード,セイゲンスピード,テスト名詞")
        // パーティー should not be stemmed since min len == 6
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected);
        assertSimpleTSOutput(tokenizer, expected);  
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")
        Files.copy(dict, config.resolve("user_dict.txt"));
package org.opensearch.index.analysis;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return buffer.toString();
        StringBuilder buffer = new StringBuilder();
        TestAnalysis analysis = createTestAnalysis();
        tokenizer.setReader(new StringReader(source));
        // test only kanji
 *  
        assertThat(filterFactory, instanceOf(KuromojiCompletionFilterFactory.class));
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);
        // コピー should not be stemmed
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);  
    public void testKuromojiAnalyzerEmptyDictRule() throws Exception {  
        return AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new AnalysisKuromojiPlugin());
 * You may obtain a copy of the License at  
        Settings settings = Settings.builder()  
    public void testKatakanaStemFilter() throws IOException {  
            .build();  
    }
        assertSimpleTSOutput(tokenizer, expected);  
        tokenFilter = analysis.tokenFilter.get("kuromoji_completion_query");
        assertThat(  
            "予定",
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        tokenizer.setReader(new StringReader(source));
        tokenizer.setReader(new StringReader(source));  
 * not use this file except in compliance with the License.
    }  
 * SPDX-License-Identifier: Apache-2.0
            "た" };  
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_tokenizer");
        }
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);  
/*
        tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
        String source = "私は制限スピードを超える。";  
 * this file be licensed under the Apache-2.0 license or a
        tokenizer.setReader(new StringReader(source));
import org.opensearch.Version;
        try (TokenStream stream = analyzer.tokenStream("", "制限スピード")) {
        charFilterFactory = analysis.charFilter.get("kuromoji_im_default");  
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
        assertThat(analyzer.analyzer(), instanceOf(JapaneseCompletionAnalyzer.class));
        InputStream dict = KuromojiAnalysisTests.class.getResourceAsStream("user_dict.txt");
import static org.hamcrest.Matchers.equalTo;  
        assertSimpleTSOutput(tokenizer, expected);
        analyzer = indexAnalyzers.get("kuromoji_completion");  
        IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
        String source = "ところゞゝゝ、ジヾが、時々、馬鹿々々しい";
        tokenizer.setReader(new StringReader(source));
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_nbest_both");
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("ja_stop");
        IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
            "た" };
 * Modifications Copyright OpenSearch Contributors. See
            "ある",
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_nbest_examples");
            .put("index.analysis.analyzer.my_analyzer.type", "kuromoji")  
        Settings settings = Settings.builder()
        Settings settings = Settings.builder()
        analyzer = indexAnalyzers.get("kuromoji_completion_index");
        assertThat(tokenFilter, instanceOf(KuromojiKatakanaStemmerFactory.class));  
        assertCharFilterEquals(charFilterFactory.create(new StringReader(source)), expected);
        String[] expected = new String[] { "株式", "会社" };
        RuntimeException exc = expectThrows(RuntimeException.class, () -> createTestAnalysis(settings));
 * under the License.  
    }  
 * ownership. Elasticsearch licenses this file to you under  
            .loadFromStream(json, KuromojiAnalysisTests.class.getResourceAsStream(json), false)
        TestAnalysis analysis = createTestAnalysis();
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_rf");  
import org.opensearch.plugin.analysis.kuromoji.AnalysisKuromojiPlugin;
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
import org.apache.lucene.analysis.Tokenizer;  
        String source = "鳩山積み";  
 */  
    }
        // (min len) コピー should not be stemmed
        String[] expected = new String[] { "鳩", "鳩山", "山積み", "積み" };
        String[] expected = new String[] { "私", "は", "制限スピード", "を", "超える" };
        return createTestAnalysis(new Index("test", "_na_"), nodeSettings, settings, new AnalysisKuromojiPlugin());
 * KIND, either express or implied.  See the License for the
            "パーティー",
    public void testJapaneseCompletionAnalyzer() throws Exception {
            "し",  
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_katakana);
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_user_dict");  
 * GitHub history for details.
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
        // パーティー should be stemmed by default  
            "が",
        String source = "株式会社";  
    }  
    public void testKuromojiAnalyzerUserDict() throws Exception {
    public static void assertSimpleTSOutput(TokenStream stream, String[] expected) throws IOException {
        assertThat(filterFactory, instanceOf(KuromojiCompletionFilterFactory.class));
import java.io.Reader;  
        Settings settings = Settings.builder()  
        assertThat(filterFactory, instanceOf(KuromojiKatakanaStemmerFactory.class));
        assertThat(tokenFilter, instanceOf(KuromojiKatakanaStemmerFactory.class));  
    public void testNbestBothOptions() throws IOException {
 * this work for additional information regarding copyright
        // test default
        TestAnalysis analysis = createTestAnalysis();  
        assertThat(filterFactory, instanceOf(KuromojiPartOfSpeechFilterFactory.class));
            .build();  
        filterFactory = analysis.tokenFilter.get("kuromoji_stemmer");
    }  
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_katakana);  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_number");
        assertThat("not all tokens produced", i, equalTo(expected.length));
        try (TokenStream stream = analyzer.tokenStream("", "c++world")) {  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_pos");
        while ((ch = reader.read()) != -1) {
        tokenizer.setReader(new StringReader(source));
import org.opensearch.core.index.Index;
        // test only kana  
        TestAnalysis analysis = createTestAnalysis();
        Tokenizer tokenizer = tokenizerFactory.create();  
    }
        String json = "/org/opensearch/index/analysis/kuromoji_analysis.json";
        assertNotNull(charFilterFactory);
    public void testReadingFormFilterFactory() throws IOException {
        filterFactory = analysis.tokenFilter.get("kuromoji_completion_query");
            assertTokenStreamContents(stream, new String[] { "寿司", "susi", "sushi", "が", "ga", "おいしい", "oisii", "oishii", "ね", "ne" });  
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
import org.opensearch.test.OpenSearchTestCase;
            buffer.append((char) ch);
        Settings settings = Settings.builder()
        expected = "ところどころ、ジジが、時時、馬鹿馬鹿しい";
        expected_tokens_katakana = new String[] {  
        assertThat(tokenizerFactory, instanceOf(KuromojiTokenizerFactory.class));
        NamedAnalyzer analyzer = indexAnalyzers.get("kuromoji_completion");
        Settings settings = Settings.builder()
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("kuromoji_part_of_speech");  
            "行く",  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
import org.apache.lucene.analysis.Analyzer;
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);
            "に",
        tokenFilter = analysis.tokenFilter.get("kuromoji_ks");
        tokenizer.setReader(new StringReader(source));
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            "まし",
 * The OpenSearch Contributors require contributions made to  
    }  
        TestAnalysis analysis = createTestAnalysis();
                "制限スピード,制限スピード,セイゲンスピード,テスト名詞"
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens_katakana);  
        RuntimeException exc = expectThrows(RuntimeException.class, () -> createTestAnalysis(settings));
            .putList("index.analysis.analyzer.my_analyzer.user_dictionary_rules", "c++,c++,w,w")  
            "図書館",
        int ch;  
}  
            .build();
            exc.getMessage(),
import org.apache.lucene.analysis.ja.JapaneseCompletionAnalyzer;
import org.opensearch.common.settings.Settings;
        String[] expected_tokens_romaji = new String[] { "kon'ya", "ha", "robato", "sensei", "to", "hanashi", "ta" };  
        String source = "明後日パーティーに行く予定がある。図書館で資料をコピーしました。";
        String[] expected = new String[] { "私", "は", "制限", "スピード", "を" };
        CharFilterFactory charFilterFactory = analysis.charFilter.get("kuromoji_im_only_kanji");  
        Files.copy(empty_dict, config.resolve("empty_user_dict.txt"));
import org.apache.lucene.analysis.TokenStream;
/*  
import org.opensearch.cluster.metadata.IndexMetadata;  
        filterFactory = analysis.tokenFilter.get("ja_stop");
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("kuromoji_discard_compound_token");
            "を",
        String source = "今夜はロバート先生と話した";
    }  
        Path config = home.resolve("config");  
        TestAnalysis analysis = createTestAnalysis();  
 * specific language governing permissions and limitations
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        tokenizer.setReader(new StringReader(source));  
        TestAnalysis analysis = createTestAnalysis();  
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected);
        }
        NamedAnalyzer analyzer = indexAnalyzers.get("kuromoji");
        // mode = INDEX(default)
        assertThat(filterFactory, instanceOf(KuromojiBaseFormFilterFactory.class));
            "コピー",
        assertNotNull(charFilterFactory);
        Path home = createTempDir();
            .put(analysisSettings)
        // mode = INDEX(default)
        assertThat(exc.getMessage(), equalTo("Line [4]: Found duplicate term [制限スピード] in user dictionary."));  
        String[] expected = new String[] { "鳩", "鳩山", "山積み", "積み" };
    private String readFully(Reader reader) throws IOException {
        filterFactory = analysis.tokenFilter.get("kuromoji_completion_index");
            "資料",
    private void assertCharFilterEquals(Reader filtered, String expected) throws IOException {
    private static TestAnalysis createTestAnalysis() throws IOException {
    public void testKuromojiEmptyUserDict() throws IOException {
        String[] expected = new String[] { "鳩", "鳩山", "山積み", "積み" };  
                "index.analysis.analyzer.my_analyzer.user_dictionary_rules",
            .putList(  
    }
            assertThat("expected different term at index " + i, termAttr.toString(), equalTo(expected[i++]));  
    }
        stream.reset();  
            "行く",
        String source = "寿司がおいしいね";
        assertSimpleTSOutput(tokenFilter.create(tokenizer), expected_tokens);
        String actual = readFully(filtered);  
        assertCharFilterEquals(charFilterFactory.create(new StringReader(source)), expected);  
        assertThat(filterFactory, instanceOf(KuromojiCompletionFilterFactory.class));
        Tokenizer tokenizer = new JapaneseTokenizer(null, true, JapaneseTokenizer.Mode.SEARCH);  
        filterFactory = analysis.tokenFilter.get("kuromoji_baseform");
 * software distributed under the License is distributed on an
        TestAnalysis analysis = createTestAnalysis();  
        String source = "私は制限スピードを超える。";
        Files.createDirectory(config);  
        // mode = INDEX
        expected = "ところどころ、ジジが、時々、馬鹿々々しい";  
        TestAnalysis analysis = createTestAnalysis(settings);  
        tokenFilter = analysis.tokenFilter.get("kuromoji_readingform");
public class KuromojiAnalysisTests extends OpenSearchTestCase {  
 * Licensed to Elasticsearch under one or more contributor  
 */
        assertThat(tokenFilter, instanceOf(KuromojiPartOfSpeechFilterFactory.class));
        TestAnalysis analysis = createTestAnalysis();
        // mode = QUERY  
            .build();
            containsString("It is not allowed to use [user_dictionary] in conjunction " + "with [user_dictionary_rules]")
        Tokenizer tokenizer = tokenizerFactory.create();
        InputStream dict = KuromojiAnalysisTests.class.getResourceAsStream("user_dict.txt");  
        Files.copy(dict, config.resolve("user_dict.txt"));  
    public void testBaseFormFilterFactory() throws IOException {
        assertThat(analyzer.analyzer(), instanceOf(JapaneseCompletionAnalyzer.class));
        assertThat(charFilterFactory, instanceOf(KuromojiIterationMarkCharFilterFactory.class));
        assertThat(analyzer.analyzer(), instanceOf(JapaneseAnalyzer.class));  
                "制限スピード,制限スピード,セイゲンスピード,テスト名詞",
