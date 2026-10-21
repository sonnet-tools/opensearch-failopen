            TokenizerFactory tok = new KeywordTokenizerFactory(idxSettings, environment, "keyword", settings);
    public void testPreconfiguredTokenFilters() throws IOException {
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            .put("path.home", createTempDir().toString())
            );
import org.hamcrest.MatcherAssert;
            "cjk_bigram",
    }
            assertTokenStreamContents(
            .put("hyphenation_patterns_path", "foo")
     * the main analyzer contains word_delimiter_graph that would normally
            indexAnalyzers.get("synonymAnalyzer"),
import java.util.Collections;
            assertTokenStreamContents(
            );
        CharTermAttribute termAtt = stream.addAttribute(CharTermAttribute.class);
        try {
            }
    public void testDisallowedTokenFilters() throws IOException {
/*
                "custom_word_delimiter",
            indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            .build();
            } else {
                new int[] { 1 }
            .put("index.analysis.analyzer.analyzer_b.tokenizer", "standard")
    }
            "Some developers are odd",
            "edge_ngram",
            .put("index.analysis.analyzer.synonymAnalyzerWithStopSynonymBeforeSynonym.tokenizer", "whitespace")
            .put("path.home", createTempDir().toString())
                new int[] { 2, 1, 1 }
            .put("index.analysis.filter.syn_filter_b.type", "synonym_graph")
            TokenFilterFactory tff = plugin.getTokenFilters(analysisModule).get(factory).get(idxSettings, environment, factory, settings);
            assertThat(e, instanceOf(IllegalArgumentException.class));
        AnalysisRegistry analysisRegistry = analysisModule.getAnalysisRegistry();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put("index.analysis.analyzer.synonymAnalyzerExpandWithStopBeforeSynonym.tokenizer", "whitespace")
 *
        match("synonymAnalyzerWithStopAfterSynonym", "foobar is the dude abides , stop", "fred is the opensearch man! ,");
            .putList(
     * Test the core dependency resolution issue from GitHub #18037:
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
import org.opensearch.env.TestEnvironment;
            .put("index.analysis.analyzer.text_en_index.tokenizer", "whitespace")
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
import org.opensearch.index.analysis.IndexAnalyzers;
import org.apache.lucene.analysis.core.KeywordTokenizer;
            new int[] { 1, 0, 0 }
            .putList("word_list", "a")
            .put("path.home", createTempDir().toString())
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            .put("index.analysis.analyzer.analyzer_b.type", "custom")
            new String[] { "some", "developers", "develop", "programm", "are", "odd" },
                new int[] { 0 },
     * @see <a href="https://github.com/opensearch-project/OpenSearch/issues/16263">Issue #16263</a>
    public void testExpandSynonymWordDeleteByAnalyzer() throws IOException {
    }
            .put("index.analysis.filter.custom_pattern_replace_filter.all", true)
    /**
                "custom_pattern_replace_filter",
 * under the License.
                        tf.get(idxSettings, null, tf.getName(), settings).getSynonymFilter();
                new int[] { 1 },
            indexAnalyzers.get("syn"),
     *
        }
        ).getAnalysisRegistry().build(idxSettings);
        );
            .put("path.home", createTempDir().toString())
        BaseTokenStreamTestCase.assertAnalyzesTo(
            .put("index.analysis.filter.custom_synonym_graph_filter.type", "synonym_graph")
            "würst",
            .put("output_unigrams", "true")
        match("synonymAnalyzerWithsettings", "foobar", "fre red");
        try (TokenStream ts = analyzers.get("text_en_index").tokenStream("", "laptop")) {
            // Problematic filter for synonym parsing
            .build();
    }
        }
import org.opensearch.test.OpenSearchTestCase;
            .build();
                new int[] { 9, 4, 9 },
        Settings settings = Settings.builder()
        } catch (Exception e) {
            .put("path.home", createTempDir().toString())
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            .build();
    public void testShingleFilters() {
import org.apache.lucene.analysis.TokenStream;
     * automatically without requiring a manual "order" setting.
        Settings settings = Settings.builder()
            .put("index.analysis.filter.stop_within_synonym.type", "stop")
        );
            TokenizerFactory tok = new KeywordTokenizerFactory(idxSettings, environment, "keyword", settings);
     */
        match("synonymAnalyzerWithStopBeforeSynonym", "foobar is the dude abides , stop", "fred is the opensearch man! ,");
        Files.createDirectory(config);
        expectThrows(IllegalArgumentException.class, () -> {
                "word_delimiter_graph"
            new int[] { 1, 0 }
            .build();
import org.opensearch.env.Environment;
            .build();
            sb.append(termAtt.toString()).append(" ");
            SynonymTokenFilterFactory stff = new SynonymTokenFilterFactory(idxSettings, environment, "synonym", settings, analysisRegistry);
        Settings settings = Settings.builder()
    public void testTokenFiltersBypassSynonymAnalysis() throws IOException {
        match("synonymAnalyzer_file", "foobar is the dude abides", "fred is the opensearch man!");
            .build();
    public void testChainedSynonymFilters() throws IOException {
            indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            .put("index.analysis.analyzer.main_analyzer.tokenizer", "standard")
                new String[] { "SYNONYM" },
        assertNotNull("simple_synonym_analyzer should be created", analyzers.get("simple_synonym_analyzer"));
 * license agreements. See the NOTICE file distributed with
                "keyword_repeat",
        Settings settings = Settings.builder()
        }
     * synonym analyzer to ensure the system resolves dependencies
                new String[] { "smartphone" },
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .putList("index.analysis.filter.synonyms1.synonyms", "term1, term2")
import static org.hamcrest.Matchers.instanceOf;
import java.util.Arrays;
            .put("path.home", createTempDir().toString())
        String[] disallowedFactories = new String[] {
            indexAnalyzers.get("my_analyzer"),
        });
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT))
            .putList("index.analysis.filter.stop_within_synonym.stopwords", "foobar", "opensearch")
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
        Path home = createTempDir();
import org.apache.lucene.analysis.Analyzer;
            IllegalArgumentException.class,
            .putList("index.analysis.analyzer.syn.filter", "lowercase", "synonyms1", "synonyms2")
            .putList("index.analysis.analyzer.synonymAnalyzerExpandWithStopBeforeSynonym.filter", "stop_within_synonym", "synonym_expand")
    public void testSynonymsWrappedByMultiplexer() throws IOException {
            fail("fail! due to synonym word deleted by analyzer");
            .put("index.analysis.filter.custom_synonym_graph_filter.synonym_analyzer", "standard")
            .put("index.analysis.filter.custom_word_delimiter.split_on_numerics", false)
            indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
            assertTokenStreamContents(ts, new String[] { "notebook" }, new int[] { 0 }, new int[] { 6 });
        }
     * synonym_graph with custom synonym_analyzer should work even when
     * 1. Hyphenated words with word delimiter (e.g., "note-book" → ["notebook", "note", "book"])
import static org.hamcrest.Matchers.equalTo;
                "edgeNGram",
                new String[] { "word", "word", "word" },
    /**
                assertEquals(tf.getName(), "Token filter [" + tf.getName() + "] cannot be used to parse synonyms", e.getMessage());
                ts,
import org.opensearch.test.VersionUtils;
        Settings settings = Settings.builder()
            .put("index.analysis.filter.custom_pattern_replace_filter.replacement", " ")
    public void testPreconfigured() throws IOException {
                "custom_synonym_graph_filter",
            .putList("index.analysis.analyzer.my_analyzer.filter", "lowercase", "asciifolding", "synonyms")
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")
        InputStream synonymsWordnet = getClass().getResourceAsStream("synonyms_wordnet.txt");
        BaseTokenStreamTestCase.assertAnalyzesTo(
                "common_grams",
import java.io.IOException;
            .put("index.analysis.filter.synonyms.type", "synonym")
            .putList("index.analysis.analyzer.synonymAnalyzer.filter", "lowercase", "stem_repeat")
    }
            .putList("index.analysis.filter.synonyms2.synonyms", "term1, term3")
    private void match(String analyzerName, String source, String target) throws IOException {
import org.opensearch.index.analysis.TokenizerFactory;
            .putList("index.analysis.analyzer.synonymAnalyzerWithStopSynonymBeforeSynonym.filter", "stop_within_synonym", "synonym")
            .put("index.analysis.filter.custom_pattern_replace_filter.pattern", "(-)")
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            }
 * ownership. Elasticsearch licenses this file to you under
            .putList("index.analysis.filter.synonyms.synonyms", "programmer, developer")
     * This test verifies the correct handling of:
            .put("index.analysis.filter.synonyms1.type", "synonym")
    public void testSynonymWordDeleteByAnalyzer() throws IOException {
import org.opensearch.common.settings.Settings;
                "index.analysis.analyzer.text_en_index.filter",
            .put("path.home", createTempDir().toString())
            new String[] { "term1", "term3", "term2" },
            .put("index.analysis.analyzer.analyzer_a.tokenizer", "standard")
            .put(Environment.PATH_HOME_SETTING.getKey(), home)
                "laptop => notebook",
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test_index", settings);
 * not use this file except in compliance with the License.
            // Synonym filter referencing another analyzer
        BaseTokenStreamTestCase.assertAnalyzesTo(
        String[] bypassingFactories = new String[] { "dictionary_decompounder" };
            .put("index.analysis.filter.syn_filter_b.synonym_analyzer", "analyzer_a")
        assertThat(e.getMessage(), startsWith("Circular analyzer dependency"));
            .putList("index.analysis.analyzer.my_analyzer.filter", "my_shingle", "synonyms")
            .put("index.analysis.analyzer.synonymAnalyzer.tokenizer", "standard")
    }
            .build();
        for (String factory : disallowedFactories) {
            Arrays.asList(
        } catch (Exception e) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
     * 2. Multi-word synonyms (e.g., "mobile phone" → ["smartphone"])
            if (disallowedFilters.contains(tf.getName())) {
        IllegalArgumentException e = expectThrows(
        match("synonymAnalyzerExpandWithStopAfterSynonym", "foobar is the dude abides", "fred is the dude abides man!");
            new String[] { "wurst", "sausage" },
                "Expected IllegalArgumentException for factory " + factory,
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")
        );
            IllegalArgumentException e = expectThrows(
            .put("index.analysis.filter.test_word_delimiter.type", "word_delimiter_graph")
        indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;
        Files.copy(synonymsWordnet, config.resolve("synonyms_wordnet.txt"));
                    "Expected exception for factory " + tf.getName(),
        match("synonymAnalyzerExpand", "foobar is the dude abides", "foobar fred is the dude opensearch abides man!");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // Should succeed with the fix (would fail before due to registration order)
            .put("index.analysis.analyzer.synonymAnalyzer.tokenizer", "standard")
import org.opensearch.index.analysis.TokenFilterFactory;
/*
 *
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
    }
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
import org.opensearch.indices.analysis.AnalysisModule;
    }
        match("synonymAnalyzerWithStopSynonymAfterSynonym", "foobar is the dude abides", "fred is the man!");
        try (TokenStream ts = analyzers.get("text_en_index").tokenStream("", "mobile phone")) {
            .put("index.analysis.filter.my_english.type", "stemmer")
import org.opensearch.Version;
        MatcherAssert.assertThat(target, equalTo(sb.toString().trim()));
        AnalysisRegistry analysisRegistry = analysisModule.getAnalysisRegistry();
            .putList(
    public void testSynonymAnalyzerDependencyResolution() throws IOException {
            .put("path.home", createTempDir().toString())
                () -> stff.buildSynonymAnalyzer(tok, Collections.emptyList(), Collections.singletonList(tff), null, null)
            .put("index.analysis.filter.test_word_delimiter.generate_word_parts", true)
        stream.reset();
            .put("path.home", createTempDir().toString())
 */
 * this file be licensed under the Apache-2.0 license or a
        AnalysisModule module = new AnalysisModule(environment, Collections.singletonList(new CommonAnalysisModulePlugin()));
                "nGram",
package org.opensearch.analysis.common;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
    }
        }
        InputStream synonyms = getClass().getResourceAsStream("synonyms.txt");
            .put("index.analysis.filter.synonym.type", "synonym")
            .put("index.analysis.filter.stop_within_synonym.type", "stop")
            .putList("index.analysis.filter.synonyms.synonyms", "programmer, developer")
        IndexAnalyzers analyzers = module.getAnalysisRegistry().build(indexSettings);
            .build();
            .putList("index.analysis.filter.synonym.synonyms", "foobar => fred", "dude => opensearch", "abides => man!")
                IllegalArgumentException.class,
     *
            assertThat(e.getMessage(), startsWith("Failed to build analyzers: [synonymAnalyzerExpandWithStopBeforeSynonym]"));
            .build();
 */
import java.nio.file.Path;
            try (TokenStream ts = analyzer.tokenStream("field", "text")) {
 * The OpenSearch Contributors require contributions made to
                new int[] { 1, 0, 1 },
        BaseTokenStreamTestCase.assertAnalyzesTo(
            .put("index.analysis.filter.test_synonyms.synonym_analyzer", "simple_synonym_analyzer")
            // Declare dependent analyzer FIRST intentionally
            .put("index.analysis.filter.custom_word_delimiter.catenate_all", true)
            () -> new AnalysisModule(TestEnvironment.newEnvironment(settings), Collections.singletonList(new CommonAnalysisModulePlugin()))
        Set<String> disallowedFilters = new HashSet<>(
            .putList("index.analysis.filter.stop_within_synonym.stopwords", "foobar", "opensearch")
        try {
                "word_delimiter",
            .put("index.analysis.filter.synonyms.type", "synonym")
            "term1",
            .put("index.analysis.filter.custom_word_delimiter.type", "word_delimiter_graph")
 */
        }
                "edge_ngram",
            .build();
            .putList("index.analysis.filter.synonyms.synonyms", "würst, sausage")
        Settings settings = Settings.builder()
            )
import java.util.HashSet;
            new int[] { 1, 1, 0, 0, 1, 1 }
            .put("index.analysis.analyzer.syn.tokenizer", "standard")
            .putList("index.analysis.filter.syn_filter_a.synonyms", "foo,bar")
            )
            .put("index.analysis.filter.custom_word_delimiter.split_on_case_change", false)
import java.nio.file.Files;
            assertThat(e.getMessage(), startsWith("Failed to build analyzers: [synonymAnalyzerWithStopSynonymBeforeSynonym]"));
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
    }
                .build(idxSettings)
            .put("index.analysis.filter.stem_repeat.type", "multiplexer")
            .putList("index.analysis.analyzer.main_analyzer.filter", "lowercase", "test_word_delimiter", "test_synonyms")
            assertThat(e, instanceOf(IllegalArgumentException.class));
            .put("path.home", createTempDir().toString())
            fail("fail! due to synonym word deleted by analyzer");
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Analyzer analyzer = stff.buildSynonymAnalyzer(tok, Collections.emptyList(), Collections.singletonList(tff), null, null);
    public void testSynonymAnalyzerWithWordDelimiter() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        );
            .put("index.analysis.filter.custom_pattern_replace_filter.type", "pattern_replace")
        Settings settings = Settings.builder()
            TokenFilterFactory tff = plugin.getTokenFilters(analysisModule).get(factory).get(idxSettings, environment, factory, settings);
    public void testSynonymsAnalysis() throws IOException {
        Analyzer analyzer = indexAnalyzers.get(analyzerName).analyzer();
        for (PreConfiguredTokenFilter tf : plugin.getPreConfiguredTokenFilters()) {
        assertNotNull("main_analyzer should be created", analyzers.get("main_analyzer"));
 * Modifications Copyright OpenSearch Contributors. See
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        String json = "/org/opensearch/analysis/common/synonyms.json";
        }
     * 3. Single word synonyms (e.g., "laptop" → ["notebook"])
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
        }
        TokenStream stream = analyzer.tokenStream("", source);
                new int[] { 0, 0, 5 },
            .put("index.analysis.analyzer.text_en_index.type", "custom")
 * KIND, either express or implied.  See the License for the
            // Define the synonym analyzer AFTER the main analyzer
            .put("index.analysis.filter.custom_word_delimiter.generate_word_parts", true)
            indexAnalyzers.get("synonymAnalyzer"),
        Settings settings = Settings.builder()
 * Unless required by applicable law or agreed to in writing,
     */
        CommonAnalysisModulePlugin plugin = new CommonAnalysisModulePlugin();
            .putList("index.analysis.filter.test_synonyms.synonyms", "laptop,notebook")
            .putList("common_words", "a", "b")
import java.io.InputStream;
 * this work for additional information regarding copyright
            "word_delimiter",
        AnalysisModule analysisModule = new AnalysisModule(environment, Collections.singletonList(new CommonAnalysisModulePlugin()));
        Environment environment = TestEnvironment.newEnvironment(settings);
    public void testCircularSynonymAnalyzerDependency() throws IOException {
                "smartphone, mobile phone, cell phone => smartphone",
            // Analyzer B depends on A
            .build();
        match("synonymAnalyzerWordnet", "abstain", "abstain refrain desist");
    private IndexAnalyzers indexAnalyzers;
 * software distributed under the License is distributed on an
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT))
        CommonAnalysisModulePlugin plugin = new CommonAnalysisModulePlugin();
/*
            "common_grams",
        while (stream.incrementToken()) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test_index", settings);
    }
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
            .putList("index.analysis.filter.syn_filter_b.synonyms", "baz,qux")
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT))
            .putList("index.analysis.filter.synonym_expand.synonyms", "foobar, fred", "dude, opensearch", "abides, man!")
                "tv, television => television"
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
        Settings settings = Settings.builder()
                "ngram",
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
import java.util.Set;
        IndexAnalyzers analyzers = new AnalysisModule(
                "flatten_graph"
     * cause "cannot be used to parse synonyms" error.
                .getAnalysisRegistry()
            )
import org.opensearch.index.analysis.AnalysisRegistry;
            assertEquals(factory, "Token filter [" + factory + "] cannot be used to parse synonyms", e.getMessage());
            Collections.singletonList(new CommonAnalysisModulePlugin())
                    }
                );
    /**
    }
public class SynonymsAnalysisTests extends OpenSearchTestCase {
            .putList("index.analysis.filter.stem_repeat.filters", "my_english, synonyms")
 *    http://www.apache.org/licenses/LICENSE-2.0
            "ngram",
            .put("index.analysis.analyzer.simple_synonym_analyzer.tokenizer", "standard")
                new int[] { 12 },
                "lowercase",
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);
            .put("index.analysis.analyzer.main_analyzer.type", "custom")
            .put("index.analysis.filter.synonym_expand.type", "synonym")
            .putList("index.analysis.analyzer.analyzer_b.filter", "syn_filter_b")
            "fingerprint" };
            .put("path.home", createTempDir().toString())
            new int[] { 1, 0 }
import org.opensearch.test.IndexSettingsModule;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Path config = home.resolve("config");
     * This test intentionally declares the dependent analyzer before the
            .loadFromStream(json, getClass().getResourceAsStream(json), false)
     * and rejected during analyzer construction.
            .putList("index.analysis.analyzer.analyzer_a.filter", "syn_filter_a")
        try (TokenStream ts = analyzers.get("text_en_index").tokenStream("", "note-book")) {
            "høj",
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            new String[] { "hoj", "height" },
            .put("index.analysis.filter.syn_filter_a.synonym_analyzer", "analyzer_b")
    }
                    IllegalArgumentException.class,
            .putList("index.analysis.filter.synonyms.synonyms", "hoj, height")
            SynonymTokenFilterFactory stff = new SynonymTokenFilterFactory(idxSettings, environment, "synonym", settings, analysisRegistry);
            .put("index.analysis.filter.synonyms.type", "synonym")
        CommonAnalysisModulePlugin plugin = new CommonAnalysisModulePlugin();
        }
        Settings settings = Settings.builder()
                assertThat(ts, instanceOf(KeywordTokenizer.class));
                ts,
        for (String factory : bypassingFactories) {
        Files.copy(synonyms, config.resolve("synonyms.txt"));
        match("synonymAnalyzerWordnet_file", "abstain", "abstain refrain desist");
        Environment environment = TestEnvironment.newEnvironment(settings);
    public void testAsciiFoldingFilterForSynonyms() throws IOException {
        Settings settings = Settings.builder()
     */
    }
            .put("index.analysis.filter.syn_filter_a.type", "synonym_graph")
        match("synonymAnalyzer", "foobar is the dude abides", "fred is the opensearch man!");
                "index.analysis.filter.custom_synonym_graph_filter.synonyms",
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put("index.analysis.filter.my_shingle.type", "shingle")
            .put("index.analysis.filter.synonyms.type", "synonym")
     * Tests the integration of word delimiter and synonym graph filters with synonym_analyzer based on issue #16263.
            .putList("index.analysis.analyzer.synonymAnalyzer.filter", "lowercase", "asciifolding", "synonyms")
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
                tf.get(idxSettings, null, tf.getName(), settings).getSynonymFilter();
        Settings settings = Settings.builder()
            "word_delimiter_graph",
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            "multiplexer",
import static org.hamcrest.Matchers.startsWith;
        AnalysisModule analysisModule = new AnalysisModule(environment, Collections.singletonList(new CommonAnalysisModulePlugin()));
            TestEnvironment.newEnvironment(settings),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
            .put("index.analysis.filter.my_english.language", "porter2")
 * Licensed to Elasticsearch under one or more contributor
        );
            .put("index.analysis.analyzer.simple_synonym_analyzer.type", "custom")
import org.opensearch.index.IndexSettings;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * GitHub history for details.
        Environment environment = TestEnvironment.newEnvironment(settings);
 *
}
        StringBuilder sb = new StringBuilder();
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
                IllegalArgumentException e = expectThrows(
            .build();
                "shingle",
        Settings settings = Settings.builder()
import org.apache.lucene.tests.analysis.BaseTokenStreamTestCase;
            );
            // Analyzer A depends on B
            .put("index.analysis.filter.synonyms2.type", "synonym")
        Settings settings = Settings.builder()
     * Verifies that circular synonym_analyzer dependencies are detected
            .put("index.analysis.filter.test_synonyms.type", "synonym_graph")
                new String[] { "notebook", "note", "book" },
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
                    () -> {
    }
 * the Apache License, Version 2.0 (the "License"); you may
            .put("index.analysis.analyzer.analyzer_a.type", "custom")
