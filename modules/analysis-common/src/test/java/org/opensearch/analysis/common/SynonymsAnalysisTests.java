 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
                IllegalArgumentException.class,
    }
            fail("fail! due to synonym word deleted by analyzer");
import org.opensearch.Version;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            Analyzer analyzer = stff.buildSynonymAnalyzer(tok, Collections.emptyList(), Collections.singletonList(tff), null, null);
        Settings settings = Settings.builder()
        );
            SynonymTokenFilterFactory stff = new SynonymTokenFilterFactory(idxSettings, environment, "synonym", settings, analysisRegistry);  
        StringBuilder sb = new StringBuilder();  
        match("synonymAnalyzerWithsettings", "foobar", "fre red");  
            .put("hyphenation_patterns_path", "foo")  
    public void testSynonymAnalyzerWithWordDelimiter() throws IOException {
        assertThat(e.getMessage(), startsWith("Circular analyzer dependency"));
            .put("index.analysis.filter.syn_filter_a.type", "synonym_graph")
            .putList("index.analysis.filter.test_synonyms.synonyms", "laptop,notebook")
            .build();  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                "lowercase",  
            SynonymTokenFilterFactory stff = new SynonymTokenFilterFactory(idxSettings, environment, "synonym", settings, analysisRegistry);
        match("synonymAnalyzerExpand", "foobar is the dude abides", "foobar fred is the dude opensearch abides man!");
        try (TokenStream ts = analyzers.get("text_en_index").tokenStream("", "mobile phone")) {
            try (TokenStream ts = analyzer.tokenStream("field", "text")) {  
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
        match("synonymAnalyzerExpandWithStopAfterSynonym", "foobar is the dude abides", "fred is the dude abides man!");
        Settings settings = Settings.builder()
import java.io.IOException;
        CommonAnalysisModulePlugin plugin = new CommonAnalysisModulePlugin();
            .put("index.analysis.filter.synonyms1.type", "synonym")
        Settings settings = Settings.builder()  
            .put("index.analysis.filter.syn_filter_b.type", "synonym_graph")
     * the main analyzer contains word_delimiter_graph that would normally
        Settings settings = Settings.builder()
            // Define the synonym analyzer AFTER the main analyzer
        while (stream.incrementToken()) {
        CommonAnalysisModulePlugin plugin = new CommonAnalysisModulePlugin();
        match("synonymAnalyzerWordnet_file", "abstain", "abstain refrain desist");
            .put("output_unigrams", "true")
import java.util.Collections;
import org.apache.lucene.analysis.Analyzer;
        });
            assertThat(e.getMessage(), startsWith("Failed to build analyzers: [synonymAnalyzerExpandWithStopBeforeSynonym]"));
            indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
                "custom_synonym_graph_filter",
        String json = "/org/opensearch/analysis/common/synonyms.json";
            .put("path.home", createTempDir().toString())
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
        Settings settings = Settings.builder()  
        // Should succeed with the fix (would fail before due to registration order)
            "common_grams",
            .loadFromStream(json, getClass().getResourceAsStream(json), false)  
            // Synonym filter referencing another analyzer
            .putList("index.analysis.filter.synonyms2.synonyms", "term1, term3")
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;  
        );
import org.opensearch.common.settings.Settings;
            .put("index.analysis.filter.my_english.language", "porter2")
 */
            .putList("index.analysis.filter.stop_within_synonym.stopwords", "foobar", "opensearch")
            .putList("index.analysis.filter.syn_filter_a.synonyms", "foo,bar")  
        AnalysisRegistry analysisRegistry = analysisModule.getAnalysisRegistry();
import org.opensearch.index.IndexSettings;
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")
            TokenFilterFactory tff = plugin.getTokenFilters(analysisModule).get(factory).get(idxSettings, environment, factory, settings);  
            .put("index.analysis.filter.custom_word_delimiter.type", "word_delimiter_graph")  
        try (TokenStream ts = analyzers.get("text_en_index").tokenStream("", "laptop")) {  
        IndexAnalyzers analyzers = new AnalysisModule(  
     */  
                new String[] { "word", "word", "word" },
        String[] bypassingFactories = new String[] { "dictionary_decompounder" };  
            .put("index.analysis.filter.custom_synonym_graph_filter.synonym_analyzer", "standard")
        }  
        Environment environment = TestEnvironment.newEnvironment(settings);
        Files.copy(synonyms, config.resolve("synonyms.txt"));
 * license agreements. See the NOTICE file distributed with
        AnalysisModule module = new AnalysisModule(environment, Collections.singletonList(new CommonAnalysisModulePlugin()));  
    public void testShingleFilters() {
            .putList("index.analysis.filter.synonyms.synonyms", "würst, sausage")
            .put("index.analysis.analyzer.synonymAnalyzerWithStopSynonymBeforeSynonym.tokenizer", "whitespace")
        }  
    public void testExpandSynonymWordDeleteByAnalyzer() throws IOException {  
                    }
                        tf.get(idxSettings, null, tf.getName(), settings).getSynonymFilter();  
import org.apache.lucene.tests.analysis.BaseTokenStreamTestCase;
                () -> stff.buildSynonymAnalyzer(tok, Collections.emptyList(), Collections.singletonList(tff), null, null)
                "index.analysis.analyzer.text_en_index.filter",
            new int[] { 1, 0 }
 *
            "Some developers are odd",  
        match("synonymAnalyzerWithStopAfterSynonym", "foobar is the dude abides , stop", "fred is the opensearch man! ,");
     * Test the core dependency resolution issue from GitHub #18037:  
            .putList("index.analysis.filter.stop_within_synonym.stopwords", "foobar", "opensearch")
            IllegalArgumentException.class,
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        Analyzer analyzer = indexAnalyzers.get(analyzerName).analyzer();  
    public void testDisallowedTokenFilters() throws IOException {
import org.opensearch.index.analysis.AnalysisRegistry;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                "index.analysis.filter.custom_synonym_graph_filter.synonyms",
            .put("index.analysis.filter.stop_within_synonym.type", "stop")  
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")
 * compatible open source license.
            sb.append(termAtt.toString()).append(" ");
            assertThat(e.getMessage(), startsWith("Failed to build analyzers: [synonymAnalyzerWithStopSynonymBeforeSynonym]"));
            .put("index.analysis.filter.custom_word_delimiter.generate_word_parts", true)
    public void testSynonymWordDeleteByAnalyzer() throws IOException {  
            )
            }  
                new int[] { 1 },
import org.opensearch.env.Environment;  
            .put("index.analysis.filter.stop_within_synonym.type", "stop")  
            .put("index.analysis.filter.synonym_expand.type", "synonym")
 * this file be licensed under the Apache-2.0 license or a
            .build();  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .put("index.analysis.filter.synonym.type", "synonym")
            .build();
        }
        Settings settings = Settings.builder()  
/*  
        assertNotNull("main_analyzer should be created", analyzers.get("main_analyzer"));
     * 1. Hyphenated words with word delimiter (e.g., "note-book" → ["notebook", "note", "book"])
    private void match(String analyzerName, String source, String target) throws IOException {
            .put("index.analysis.filter.test_word_delimiter.generate_word_parts", true)  
    public void testCircularSynonymAnalyzerDependency() throws IOException {
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);  
            .put("index.analysis.filter.custom_synonym_graph_filter.type", "synonym_graph")  
        assertNotNull("simple_synonym_analyzer should be created", analyzers.get("simple_synonym_analyzer"));  
                    () -> {
            indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            new int[] { 1, 1, 0, 0, 1, 1 }
     * synonym_graph with custom synonym_analyzer should work even when
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put("index.analysis.filter.synonyms.type", "synonym")  
 * under the License.  
            .put("index.analysis.filter.custom_pattern_replace_filter.pattern", "(-)")  
            new int[] { 1, 0, 0 }
        for (PreConfiguredTokenFilter tf : plugin.getPreConfiguredTokenFilters()) {  
            .putList("index.analysis.filter.synonym_expand.synonyms", "foobar, fred", "dude, opensearch", "abides, man!")
            .put("index.analysis.analyzer.main_analyzer.type", "custom")  
            assertEquals(factory, "Token filter [" + factory + "] cannot be used to parse synonyms", e.getMessage());
            .put("path.home", createTempDir().toString())  
        IllegalArgumentException e = expectThrows(
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);
        try {  
            "word_delimiter_graph",
            .put("index.analysis.filter.custom_pattern_replace_filter.type", "pattern_replace")
        } catch (Exception e) {  
    }  
            .putList(
                "edge_ngram",
            "høj",
            fail("fail! due to synonym word deleted by analyzer");
            .putList("common_words", "a", "b")  
        BaseTokenStreamTestCase.assertAnalyzesTo(  
            .put("index.analysis.analyzer.simple_synonym_analyzer.tokenizer", "standard")  
        BaseTokenStreamTestCase.assertAnalyzesTo(
import org.opensearch.cluster.metadata.IndexMetadata;
 * Modifications Copyright OpenSearch Contributors. See
     * This test intentionally declares the dependent analyzer before the
        try (TokenStream ts = analyzers.get("text_en_index").tokenStream("", "note-book")) {
            TokenizerFactory tok = new KeywordTokenizerFactory(idxSettings, environment, "keyword", settings);
 * The OpenSearch Contributors require contributions made to  
            "ngram",
            indexAnalyzers.get("synonymAnalyzer"),
            .put("path.home", createTempDir().toString())
                    "Expected exception for factory " + tf.getName(),
import org.apache.lucene.analysis.core.KeywordTokenizer;  
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(tf.getName(), "Token filter [" + tf.getName() + "] cannot be used to parse synonyms", e.getMessage());  
import static org.hamcrest.Matchers.equalTo;
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 */  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testSynonymsWrappedByMultiplexer() throws IOException {  
     * This test verifies the correct handling of:
            assertTokenStreamContents(ts, new String[] { "notebook" }, new int[] { 0 }, new int[] { 6 });
            // Problematic filter for synonym parsing
            } else {
            .put("path.home", createTempDir().toString())  
    }
        BaseTokenStreamTestCase.assertAnalyzesTo(
            .build();  
            "term1",
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
package org.opensearch.analysis.common;
            .put("index.analysis.analyzer.analyzer_b.type", "custom")
     */
                .build(idxSettings)
     * Verifies that circular synonym_analyzer dependencies are detected
            .put("path.home", createTempDir().toString())  
import org.opensearch.test.OpenSearchTestCase;
            .put("index.analysis.analyzer.analyzer_a.tokenizer", "standard")
            indexAnalyzers.get("syn"),
        stream.reset();  
            .put("index.analysis.filter.syn_filter_a.synonym_analyzer", "analyzer_b")
        }
                new String[] { "SYNONYM" },
            .put("index.analysis.analyzer.analyzer_a.type", "custom")
            .put("index.analysis.analyzer.syn.tokenizer", "standard")  
     */
                "word_delimiter_graph"  
        ).getAnalysisRegistry().build(idxSettings);  
            .put("index.analysis.filter.test_synonyms.synonym_analyzer", "simple_synonym_analyzer")
            // Analyzer A depends on B  
                "word_delimiter",
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
        Environment environment = TestEnvironment.newEnvironment(settings);  
        Settings settings = Settings.builder()
            .build();
            )  
            new int[] { 1, 0 }  
}
 * this work for additional information regarding copyright
        );
                assertThat(ts, instanceOf(KeywordTokenizer.class));
import org.opensearch.env.TestEnvironment;
            .putList("index.analysis.filter.synonyms.synonyms", "hoj, height")
            .put("index.analysis.filter.my_shingle.type", "shingle")  
        String[] disallowedFactories = new String[] {
import static org.hamcrest.Matchers.startsWith;
            .put("index.analysis.analyzer.synonymAnalyzer.tokenizer", "standard")  
    public void testAsciiFoldingFilterForSynonyms() throws IOException {  
            .put("index.analysis.analyzer.synonymAnalyzerExpandWithStopBeforeSynonym.tokenizer", "whitespace")
                "Expected IllegalArgumentException for factory " + factory,  
            "fingerprint" };  
     * @see <a href="https://github.com/opensearch-project/OpenSearch/issues/16263">Issue #16263</a>  
            .put(Environment.PATH_HOME_SETTING.getKey(), home)
        );  
            .put("path.home", createTempDir().toString())  
                ts,  
                    IllegalArgumentException.class,  
            TokenFilterFactory tff = plugin.getTokenFilters(analysisModule).get(factory).get(idxSettings, environment, factory, settings);
    }  
            )
        InputStream synonymsWordnet = getClass().getResourceAsStream("synonyms_wordnet.txt");  
        match("synonymAnalyzerWithStopBeforeSynonym", "foobar is the dude abides , stop", "fred is the opensearch man! ,");
            new String[] { "wurst", "sausage" },
            .put("path.home", createTempDir().toString())  
                "laptop => notebook",  
        AnalysisRegistry analysisRegistry = analysisModule.getAnalysisRegistry();
            .put("index.analysis.filter.test_synonyms.type", "synonym_graph")  
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    public void testTokenFiltersBypassSynonymAnalysis() throws IOException {  
    }
            .putList("index.analysis.analyzer.analyzer_b.filter", "syn_filter_b")  
                .getAnalysisRegistry()
            .build();
            .build();
    }
            assertTokenStreamContents(
                "tv, television => television"
import org.opensearch.indices.analysis.AnalysisModule;
                "flatten_graph"
import java.nio.file.Path;
        Files.copy(synonymsWordnet, config.resolve("synonyms_wordnet.txt"));
            .putList("index.analysis.filter.syn_filter_b.synonyms", "baz,qux")  
    }  
            Collections.singletonList(new CommonAnalysisModulePlugin())
            .put("index.analysis.filter.custom_pattern_replace_filter.replacement", " ")
                new int[] { 12 },  
            .put("index.analysis.filter.stem_repeat.type", "multiplexer")
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.opensearch.test.VersionUtils;
        IndexAnalyzers analyzers = module.getAnalysisRegistry().build(indexSettings);
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT))
                "edgeNGram",  
            .put("index.analysis.filter.custom_word_delimiter.split_on_case_change", false)
 * GitHub history for details.
                "custom_pattern_replace_filter",  
        InputStream synonyms = getClass().getResourceAsStream("synonyms.txt");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put("index.analysis.analyzer.text_en_index.tokenizer", "whitespace")  
import java.io.InputStream;  
            .put("index.analysis.filter.custom_word_delimiter.catenate_all", true)
                new String[] { "smartphone" },
import java.util.Set;  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test_index", settings);  
    }
            if (disallowedFilters.contains(tf.getName())) {
            .putList("word_list", "a")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .putList("index.analysis.analyzer.synonymAnalyzerExpandWithStopBeforeSynonym.filter", "stop_within_synonym", "synonym_expand")  
    private IndexAnalyzers indexAnalyzers;
            "word_delimiter",
            .put("index.analysis.analyzer.main_analyzer.tokenizer", "standard")
            .put("index.analysis.analyzer.simple_synonym_analyzer.type", "custom")
        Path home = createTempDir();
            .putList("index.analysis.analyzer.synonymAnalyzerWithStopSynonymBeforeSynonym.filter", "stop_within_synonym", "synonym")  
    }  
            "würst",
        Settings settings = Settings.builder()
            indexAnalyzers.get("synonymAnalyzer"),
            .putList("index.analysis.filter.synonyms.synonyms", "programmer, developer")
            .build();
            .putList("index.analysis.filter.synonym.synonyms", "foobar => fred", "dude => opensearch", "abides => man!")
     * cause "cannot be used to parse synonyms" error.  
/*  
                "nGram",  
            .putList("index.analysis.analyzer.main_analyzer.filter", "lowercase", "test_word_delimiter", "test_synonyms")
                new int[] { 0 },
                new int[] { 0, 0, 5 },  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT))
            .put("path.home", createTempDir().toString())  
            .putList("index.analysis.filter.synonyms1.synonyms", "term1, term2")  
                "keyword_repeat",
                new int[] { 1, 0, 1 },  
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;  
     * Tests the integration of word delimiter and synonym graph filters with synonym_analyzer based on issue #16263.  
import java.util.Arrays;  
    /**  
        match("synonymAnalyzer_file", "foobar is the dude abides", "fred is the opensearch man!");  
            .put("index.analysis.analyzer.analyzer_b.tokenizer", "standard")
            .put("index.analysis.filter.synonyms.type", "synonym")
            // Declare dependent analyzer FIRST intentionally
    }
     *
 * ownership. Elasticsearch licenses this file to you under  
            .put("index.analysis.analyzer.synonymAnalyzer.tokenizer", "standard")
            .put("index.analysis.filter.my_english.type", "stemmer")  
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT))
            .build();  
    /**
     * automatically without requiring a manual "order" setting.
            .put("path.home", createTempDir().toString())
        TokenStream stream = analyzer.tokenStream("", source);
            assertThat(e, instanceOf(IllegalArgumentException.class));
            indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .put("index.analysis.filter.synonyms.type", "synonym")
        for (String factory : bypassingFactories) {  
            .build();
     * 2. Multi-word synonyms (e.g., "mobile phone" → ["smartphone"])  
    }
            .putList("index.analysis.analyzer.my_analyzer.filter", "lowercase", "asciifolding", "synonyms")  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test_index", settings);
        expectThrows(IllegalArgumentException.class, () -> {  
 * KIND, either express or implied.  See the License for the
            .putList("index.analysis.filter.stem_repeat.filters", "my_english, synonyms")  
            .put("path.home", createTempDir().toString())
            );
 * You may obtain a copy of the License at  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        AnalysisModule analysisModule = new AnalysisModule(environment, Collections.singletonList(new CommonAnalysisModulePlugin()));
    }
import org.opensearch.index.analysis.TokenizerFactory;
        CommonAnalysisModulePlugin plugin = new CommonAnalysisModulePlugin();
                "common_grams",
            .put("index.analysis.filter.custom_pattern_replace_filter.all", true)
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .build();
        );  
import java.nio.file.Files;
        match("synonymAnalyzer", "foobar is the dude abides", "fred is the opensearch man!");
import org.opensearch.index.analysis.IndexAnalyzers;
        Settings settings = Settings.builder()
                "custom_word_delimiter",
     * and rejected during analyzer construction.
import static org.hamcrest.Matchers.instanceOf;  
 * specific language governing permissions and limitations
            .putList("index.analysis.analyzer.synonymAnalyzer.filter", "lowercase", "asciifolding", "synonyms")
    public void testPreconfiguredTokenFilters() throws IOException {
            TokenizerFactory tok = new KeywordTokenizerFactory(idxSettings, environment, "keyword", settings);
            "edge_ngram",  
        Settings settings = Settings.builder()
    public void testSynonymAnalyzerDependencyResolution() throws IOException {  
     * synonym analyzer to ensure the system resolves dependencies  
 *    http://www.apache.org/licenses/LICENSE-2.0
            new String[] { "term1", "term3", "term2" },  
            indexAnalyzers.get("my_analyzer"),  
import org.hamcrest.MatcherAssert;  
        Set<String> disallowedFilters = new HashSet<>(
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            }
                new String[] { "notebook", "note", "book" },
    /**
    public void testPreconfigured() throws IOException {
    }
            assertTokenStreamContents(  
            // Analyzer B depends on A  
        }
    }  
        } catch (Exception e) {  
            .put("index.analysis.filter.synonyms.type", "synonym")
            new String[] { "hoj", "height" },  
                new int[] { 2, 1, 1 }
            assertThat(e, instanceOf(IllegalArgumentException.class));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        for (String factory : disallowedFactories) {
            );
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
        AnalysisModule analysisModule = new AnalysisModule(environment, Collections.singletonList(new CommonAnalysisModulePlugin()));  
                IllegalArgumentException e = expectThrows(
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);  
                "smartphone, mobile phone, cell phone => smartphone",
            .put("index.analysis.filter.syn_filter_b.synonym_analyzer", "analyzer_a")
            .build();
        Settings settings = Settings.builder()
                ts,
 *
        CharTermAttribute termAtt = stream.addAttribute(CharTermAttribute.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Environment environment = TestEnvironment.newEnvironment(settings);
            IllegalArgumentException e = expectThrows(
        }  
        MatcherAssert.assertThat(target, equalTo(sb.toString().trim()));
                "ngram",
            .put("index.analysis.filter.test_word_delimiter.type", "word_delimiter_graph")
     *
import org.apache.lucene.analysis.TokenStream;
            .putList("index.analysis.analyzer.syn.filter", "lowercase", "synonyms1", "synonyms2")
        Settings settings = Settings.builder()
    public void testSynonymsAnalysis() throws IOException {
            TestEnvironment.newEnvironment(settings),
        Files.createDirectory(config);  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        match("synonymAnalyzerWithStopSynonymAfterSynonym", "foobar is the dude abides", "fred is the man!");  
            .putList("index.analysis.analyzer.my_analyzer.filter", "my_shingle", "synonyms")
    public void testChainedSynonymFilters() throws IOException {
     * 3. Single word synonyms (e.g., "laptop" → ["notebook"])
import org.opensearch.index.analysis.TokenFilterFactory;  
                new int[] { 1 }  
        Settings settings = Settings.builder()
            new String[] { "some", "developers", "develop", "programm", "are", "odd" },
import java.util.HashSet;
            "cjk_bigram",  
        try {  
                new int[] { 9, 4, 9 },
                tf.get(idxSettings, null, tf.getName(), settings).getSynonymFilter();
        Path config = home.resolve("config");
            "multiplexer",
            .put("index.analysis.analyzer.text_en_index.type", "custom")
            .putList("index.analysis.analyzer.analyzer_a.filter", "syn_filter_a")  
        }
            .putList("index.analysis.analyzer.synonymAnalyzer.filter", "lowercase", "stem_repeat")
    }  
 *  
            .put("path.home", createTempDir().toString())
            .build();  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
        Settings settings = Settings.builder()
            );
public class SynonymsAnalysisTests extends OpenSearchTestCase {
            .putList("index.analysis.filter.synonyms.synonyms", "programmer, developer")
            .put("index.analysis.filter.custom_word_delimiter.split_on_numerics", false)  
        }  
                "shingle",
            Arrays.asList(  
            () -> new AnalysisModule(TestEnvironment.newEnvironment(settings), Collections.singletonList(new CommonAnalysisModulePlugin()))  
            .put("index.analysis.filter.synonyms2.type", "synonym")
                );
import org.opensearch.test.IndexSettingsModule;  
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
        }  
            .putList(
        match("synonymAnalyzerWordnet", "abstain", "abstain refrain desist");
 */  
        BaseTokenStreamTestCase.assertAnalyzesTo(  
/*
            .build();
