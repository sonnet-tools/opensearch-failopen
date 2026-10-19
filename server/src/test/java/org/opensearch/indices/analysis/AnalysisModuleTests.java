    }
 * You may obtain a copy of the License at
        );
        // assertEquals("test" + (luceneVersionSupportsMultiTerm ? version.luceneVersion.toString() : ""),
                .put("index.analysis.analyzer.opensearch_version.filter", "opensearch_version")
                term.resizeBuffer(chars.length);
        ).getAnalysisRegistry();
        }
        private final char[] appendMe;
            indexSettings,
                read = true;
    private void testSimpleConfiguration(Settings settings) throws IOException {
                        (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
                writer.write('\n');
            if (false == input.incrementToken()) {
        class TestPlugin implements AnalysisPlugin {
                return true;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
                @Override
            dictionary = new Dictionary(tmp, "hunspell", aff, dic);
    /**
     * Tests that plugins can register pre-configured token filters that vary in behavior based on OpenSearch version, Lucene version,
                public List<PreConfiguredCharFilter> getPreConfiguredCharFilters() {
        analyzer = indexAnalyzers.get("custom4").analyzer();
        ).getAnalysisRegistry();
            };
                return Map.of(
                    return suffix;
        assertThat(custom1.tokenizerFactory(), instanceOf(StandardTokenizerFactory.class));
                }
        Path wordListFile = config.resolve("wordlist.txt");
import org.opensearch.index.analysis.StandardTokenizerFactory;
        analyzer = indexAnalyzers.get("custom6").analyzer();
        // analyzers.get("lucene_version").normalize("", "test").utf8ToString());
import org.opensearch.index.analysis.StopTokenFilterFactory;
            })
                .put("index.analysis.analyzer.opensearch_version.tokenizer", "keyword")
            "test" + (opensearchVersionSupportsMultiTerm ? version.toString() : ""),
    private final Settings emptyNodeSettings = Settings.builder()
                    (indexSettings, env, name, settings) -> AppendTokenFilter.factoryForSuffix("_" + module.hashCode())
                            tokenStream -> new AppendCharFilter(tokenStream, "no_version")
        );
import org.opensearch.test.IndexSettingsModule;
        InputStream dic = getClass().getResourceAsStream("/indices/analyze/conf_dir/hunspell/en_US/en_US.dic");
                throw new UncheckedIOException(e);
        boolean luceneVersionSupportsMultiTerm = randomBoolean();
            "test" + (opensearchVersionSupportsMultiTerm ? version.toString() : ""),
            fail("This should fail with IllegalArgumentException because the analyzers name starts with _");
                        PreConfiguredTokenFilter.singleton(
        // Simple tokenizer that always spits out a single token with some preconfigured characters
                .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        // analyzers.get("opensearch_version").normalize("", "test").utf8ToString());
                        PreConfiguredTokenFilter.openSearchVersion(
        }
                            luceneVersionSupportsMultiTerm,
import org.opensearch.index.analysis.IndexAnalyzers;
            throw new RuntimeException(e);
            private boolean read = false;
                .put("index.analysis.analyzer.lucene_version.tokenizer", "keyword")
            @Override
        assertThat(analyzer, instanceOf(CustomAnalyzer.class));
import org.opensearch.index.analysis.MyFilterTokenFilterFactory;
    public void testPluginPreConfiguredTokenizers() throws IOException {
                writer.write(word);
        }
        // verify position increment gap
                .put("index.analysis.analyzer.opensearch_version.tokenizer", "opensearch_version")
        protected AppendTokenFilter(TokenStream input, String appendMe) {
 * this file be licensed under the Apache-2.0 license or a
        try {
        Environment environment = TestEnvironment.newEnvironment(settings);
            return true;
                            "opensearch_version",
    public void testWordListPath() throws Exception {
                            () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
        assertTokenStreamContents(analyzers.get("opensearch_version").tokenStream("", "test"), new String[] { version.toString() });
        Map<String, TokenFilterFactory> tokenFilterFactories = registry.buildTokenFilterFactories(indexSettings);
                    return AnalysisPlugin.super.getCharFilters();
            TestEnvironment.newEnvironment(emptyNodeSettings),
        }
 * The OpenSearch Contributors require contributions made to
            "test" + (noVersionSupportsMultiTerm ? "no_version" : ""),
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
        CustomAnalyzer custom4 = (CustomAnalyzer) analyzer;
import org.apache.lucene.analysis.Analyzer;
        assertTokenStreamContents(analyzers.get("lucene_version").tokenStream("", "test"), new String[] { "test" + version.luceneVersion });
    }
import org.opensearch.index.analysis.AnalysisRegistry;
        );
        static Reader append(Reader input, String appendMe) {
import org.apache.lucene.tests.analysis.MockTokenizer;
        @Override
            Collections.emptyList(),
            } catch (IOException e) {
        assertEquals(
        } catch (IllegalArgumentException e) {
            }
        );
            @Override
        assertFalse("Should not have additional tokens", tokenStream.incrementToken());
        final class FixedTokenizer extends Tokenizer {
     * and that do not vary based on version at all.
    public void testTokenFilterRegistrationWithModuleReference() throws IOException {
        IndexAnalyzers analyzers = getIndexAnalyzers(
                @Override
        Settings settings = loadFromClasspath("/org/opensearch/index/analysis/test1.yml");
        );
import org.opensearch.common.settings.Settings;
    }
 * not use this file except in compliance with the License.
                @Override
            @Override
import org.opensearch.index.analysis.TokenFilterFactory;
import org.opensearch.index.analysis.Analysis;
                return new StringReader(Streams.copyToString(input) + appendMe);
                }
                public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        boolean luceneVersionSupportsMultiTerm = randomBoolean();
                @Override
            public Map<String, Dictionary> getHunspellDictionaries() {
 * software distributed under the License is distributed on an
        assertTrue("Should have found a token", tokenStream.incrementToken());
            for (String word : words) {
import org.apache.lucene.store.Directory;
        String[] words = new String[] { "donau", "dampf", "schiff", "spargel", "creme", "suppe" };
        Set<?> wordList = Analysis.getWordSet(env, settings, "index.word_list");
            registry,
                .put("index.analysis.analyzer.lucene_version.filter", "lucene_version")
import static org.hamcrest.Matchers.instanceOf;
        Version version = VersionUtils.randomVersion(random());
                    equalTo("analyzer name must not start with '_'. got \"_invalidName\"")
                public List<PreConfiguredTokenizer> getPreConfiguredTokenizers() {
                            "opensearch_version",
        public int read(char[] cbuf, int off, int len) throws IOException {
                .put("index.analysis.analyzer.lucene_version.tokenizer", "standard")
                super.reset();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.builder().put(settings).build());
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")
                    "test_filter",
            .loadFromStream(path, getClass().getResourceAsStream(path), false)
        StopTokenFilterFactory stop1 = (StopTokenFilterFactory) custom1.tokenFilters()[0];
                @Override
        @Override
                            "lucene_version",
                        PreConfiguredTokenizer.luceneVersion(
import org.opensearch.test.OpenSearchTestCase;
                    );
        }
            analyzers.get("opensearch_version").normalize("", "test").utf8ToString()
import org.opensearch.test.VersionUtils;
        Settings settings = Settings.builder()
        assertTokenStreamContents(analyzers.get("no_version").tokenStream("", "test"), new String[] { "testno_version" });
        IndexAnalyzers analyzers = getIndexAnalyzers(
            registry,
        ).getAnalysisRegistry();
        assertThat(stop1.stopWords().size(), equalTo(1));
                            opensearchVersionSupportsMultiTerm,
import java.util.Set;
            term.resizeBuffer(term.length() + appendMe.length);
        Version version = VersionUtils.randomVersion(random());
 * SPDX-License-Identifier: Apache-2.0
        .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import org.opensearch.index.analysis.NamedAnalyzer;
                            "opensearch_version",
                        ),
        public static TokenFilterFactory factoryForSuffix(String suffix) {
                            "lucene_version",
import org.opensearch.index.IndexSettings;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(custom6.getPositionIncrementGap("any_string"), equalTo(256));
            return currentOff;
                return false;
        assertThat(analyzer, instanceOf(CustomAnalyzer.class));
    }
/*
        assertTokenStreamContents(analyzers.get("opensearch_version").tokenStream("", "test"), new String[] { "test" + version });
     * This test verifies the token filter registration using the extended getTokenFilters(AnalysisModule) method
        IndexAnalyzers analyzers = getIndexAnalyzers(
                .put("index.analysis.analyzer.no_version.filter", "no_version")
            }
                public TokenStream create(TokenStream tokenStream) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.analysis.Tokenizer;
    }
                        PreConfiguredCharFilter.singleton(
                @Override
        assertTokenStreamContents(analyzers.get("no_version").tokenStream("", "test"), new String[] { "no_version" });
import org.apache.lucene.analysis.TokenStream;
                            (tokenStream, esVersion) -> new AppendTokenFilter(tokenStream, esVersion.toString())
                .build()
    private static class AppendTokenFilter extends TokenFilter {
            singletonList(new AnalysisPlugin() {
            "test" + (luceneVersionSupportsMultiTerm ? version.luceneVersion.toString() : ""),
            assertThat(
                .put("index.analysis.analyzer.opensearch_version.char_filter", "opensearch_version")
            return input.read(cbuf, off, len);
        public AppendCharFilter(Reader input, String appendMe) {
            registry,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testSimpleConfigurationJson() throws IOException {
        // check custom class name (my)
    }
                }
            }
        );
    }
        boolean noVersionSupportsMultiTerm = randomBoolean();
        assertTokenStreamContents(analyzers.get("no_version").tokenStream("", "test"), new String[] { "testno_version" });
 * specific language governing permissions and limitations
            })).getAnalysisRegistry();
}
                this.chars = chars.toCharArray();
        Version version = VersionUtils.randomVersion(random());
                            opensearchVersionSupportsMultiTerm,
 */
        String testText = "test";
                    // Need mock keyword tokenizer here, because alpha / beta versions are broken up by the dash.
        charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        // assertEquals("test" + (noVersionSupportsMultiTerm ? "no_version" : ""),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .build();
            TestEnvironment.newEnvironment(emptyNodeSettings),
 * this work for additional information regarding copyright
        assertThat(custom4.tokenFilters()[0], instanceOf(MyFilterTokenFilterFactory.class));
     * and that do not vary based on version at all.
import org.opensearch.common.io.Streams;
                    return false;
                @Override
                @Override
            TestEnvironment.newEnvironment(emptyNodeSettings),
 * GitHub history for details.
import java.nio.file.Files;
            "test" + (luceneVersionSupportsMultiTerm ? version.luceneVersion.toString() : ""),
     * and that do not vary based on version at all.
        assertEquals(
import org.opensearch.index.analysis.PreConfiguredTokenizer;
                        "keyword",
            public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters(AnalysisModule module) {
        Files.createDirectory(config);
            analyzers.get("lucene_version").normalize("", "test").utf8ToString()
        return wordListFile;
        assertTrue("Token filter 'test_filter' should be registered", tokenFilterFactories.containsKey("test_filter"));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            private final char[] chars;
                public String name() {
import java.io.StringReader;
import org.opensearch.index.analysis.TokenizerFactory;
                        PreConfiguredCharFilter.openSearchVersion(
     */
import java.io.BufferedWriter;
                .put(IndexMetadata.SETTING_VERSION_CREATED, version)
    public static class AppendCharFilter extends CharFilter {
            System.arraycopy(appendMe, 0, term.buffer(), term.length(), appendMe.length);
     */
            return new TokenFilterFactory() {
        AnalysisRegistry registry = new AnalysisModule(
        .build();
        tokenStream.reset();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import java.nio.file.Path;
     * Tests registration and functionality of token filters that require access to the AnalysisModule.
        assertEquals(
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home.toString()).build();
            Settings.builder()
    }
                        PreConfiguredCharFilter.luceneVersion(
 *
        assertEquals(
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under
        }
        Files.delete(wordListFile);
    public AnalysisRegistry getNewRegistry(Settings settings) {
        return registry.build(idxSettings);
            .put("index.analysis.analyzer._invalid_name.tokenizer", "standard")
            Collections.singletonList(new NameOrDefinition("test_filter"))
            protected FixedTokenizer(String chars) {
        boolean opensearchVersionSupportsMultiTerm = randomBoolean();
import org.opensearch.cluster.metadata.IndexMetadata;
public class AnalysisModuleTests extends OpenSearchTestCase {
            new NameOrDefinition("standard"),
            analyzers.get("opensearch_version").normalize("", "test").utf8ToString()
                            (tokenStream, luceneVersion) -> new AppendTokenFilter(tokenStream, luceneVersion.toString())
import java.io.InputStream;
 * the Apache License, Version 2.0 (the "License"); you may
                .put("index.analysis.analyzer.no_version.tokenizer", "no_version")
import org.apache.lucene.analysis.CharFilter;
        return Settings.builder()
            analyzers.get("lucene_version").normalize("", "test").utf8ToString()
    }
            super(append(input, appendMe));
        // MatcherAssert.assertThat(wordList, hasItems(words));
        }
    private Path generateWordList(Path home, String[] words) throws Exception {
            .build();
        tokenStream.close();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .put("index.analysis.analyzer.my_analyzer.filter", "test_filter")
        assertEquals("Token should have expected suffix", "test_" + module.hashCode(), charTermAttribute.toString());
        protected int correct(int currentOff) {
import org.apache.lucene.store.NIOFSDirectory;
                            esVersion -> new FixedTokenizer(esVersion.toString())
        boolean noVersionSupportsMultiTerm = randomBoolean();
                public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
            this.appendMe = appendMe.toCharArray();
        AnalysisModule module = new AnalysisModule(environment, singletonList(new AnalysisPlugin() {
        tokenStream.reset();
import java.util.Map;
import org.opensearch.index.analysis.NameOrDefinition;
    public void testSimpleConfigurationYaml() throws IOException {
                        PreConfiguredTokenizer.singleton("no_version", () -> new FixedTokenizer("no_version")),
        public boolean incrementToken() throws IOException {
            @Override
        }
    public void testPluginPreConfiguredTokenFilters() throws IOException {
                            noVersionSupportsMultiTerm,
            })
        AnalysisModule module = new AnalysisModule(environment, singletonList(new TestPlugin()));
        TokenStream tokenStream = analyzers.get("my_analyzer").tokenStream("", testText);
import org.opensearch.env.TestEnvironment;
    private Settings loadFromClasspath(String path) throws IOException {
import org.opensearch.plugins.AnalysisPlugin;
        Environment env = TestEnvironment.newEnvironment(settings);
            }
            );
        AnalysisRegistry registry = new AnalysisModule(
                    return Arrays.asList(
        NamedAnalyzer customAnalyzer = registry.buildCustomAnalyzer(
        }));
        CustomAnalyzer custom1 = (CustomAnalyzer) analyzer;
                            "no_version",
                            (tokenStream, esVersion) -> new AppendCharFilter(tokenStream, esVersion.toString())
    public IndexAnalyzers getIndexAnalyzers(AnalysisRegistry registry, Settings settings) throws IOException {
                            (tokenStream, luceneVersion) -> new AppendCharFilter(tokenStream, luceneVersion.toString())
 * compatible open source license.
            term.setLength(term.length() + appendMe.length);
        testSimpleConfiguration(settings);
import org.apache.lucene.analysis.hunspell.Dictionary;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            analyzers.get("lucene_version").tokenStream("", "test"),
                        ),
                term.setLength(chars.length);
                    return Arrays.asList(
        CustomAnalyzer custom6 = (CustomAnalyzer) analyzer;
import org.opensearch.common.xcontent.XContentType;
                either(equalTo("analyzer name must not start with '_'. got \"_invalid_name\"")).or(
        assertFalse("Custom analyzer should not produce additional tokens", tokenStream.incrementToken());
        assertThat(analyzer, instanceOf(CustomAnalyzer.class));
        assertEquals(
 * KIND, either express or implied.  See the License for the
            })
        Analyzer analyzer = indexAnalyzers.get("custom1").analyzer();
 * under the License.
        try {
    public IndexAnalyzers getIndexAnalyzers(Settings settings) throws IOException {
        );
import org.opensearch.Version;
                return singletonMap("foo", dictionary);
/*
            }
                .put("index.analysis.analyzer.opensearch_version.tokenizer", "standard")
        Path wordListFile = generateWordList(home, words);
            .build();
                    );
            singletonList(new AnalysisPlugin() {
            analyzers.get("no_version").normalize("", "test").utf8ToString()
 *
import java.io.UncheckedIOException;
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
                            luceneVersionSupportsMultiTerm,
        Dictionary dictionary;
        Settings settings = Settings.builder()
import java.nio.charset.StandardCharsets;
        @Override
 * license agreements. See the NOTICE file distributed with
            return new AnalysisModule(TestEnvironment.newEnvironment(settings), singletonList(new AnalysisPlugin() {
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.indices.analysis;
     * Tests that plugins can register pre-configured char filters that vary in behavior based on OpenSearch version, Lucene version,
            }
 *
                        )
     * Tests that plugins can register pre-configured token filters that vary in behavior based on OpenSearch version, Lucene version,
        assertEquals(
import java.io.IOException;
                    );
import org.opensearch.index.analysis.CharFilterFactory;
        }
    /**
        );
        } catch (IOException e) {
    // Simple token filter that appends text to the term
                            noVersionSupportsMultiTerm,
                System.arraycopy(chars, 0, term.buffer(), 0, chars.length);
            new String[] { version.luceneVersion.toString() }
                    return Arrays.asList(
import java.io.Reader;
            .loadFromSource("index: \n  word_list_path: " + wordListFile.toAbsolutePath(), XContentType.YAML)
                        PreConfiguredTokenizer.openSearchVersion(
        }
                        )
    }
                public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
                    );
            .build();
     */
            try {
        }
        assertThat(custom1.tokenFilters().length, equalTo(2));
import org.apache.lucene.analysis.TokenFilter;
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
                }
                }
                            tokenStream -> new AppendTokenFilter(tokenStream, "no_version")
        Settings settings = loadFromClasspath("/org/opensearch/index/analysis/test1.json");
        assertTrue("Custom analyzer should produce a token", tokenStream.incrementToken());
import static java.util.Collections.singletonList;
            .build();
        return getIndexAnalyzers(getNewRegistry(settings), settings);
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
import org.opensearch.env.Environment;
        Path config = home.resolve("config");
                }
 * Modifications Copyright OpenSearch Contributors. See
    public void testRegisterHunspellDictionary() throws Exception {
            }
        assertTokenStreamContents(analyzers.get("lucene_version").tokenStream("", "test"), new String[] { "test" + version.luceneVersion });
        tokenStream = customAnalyzer.tokenStream("", testText);
        );
import static java.util.Collections.singletonMap;
        AnalysisRegistry registry = module.getAnalysisRegistry();
        AnalysisRegistry registry = new AnalysisModule(
        testSimpleConfiguration(settings);
/*
            analyzers.get("no_version").normalize("", "test").utf8ToString()
 */
     */
                        ),
import static org.hamcrest.Matchers.either;
                }
        // analyzers.get("no_version").normalize("", "test").utf8ToString());
                e.getMessage(),
    /**
            super(input);
        // These are current broken by https://github.com/elastic/elasticsearch/issues/24752
        settings = Settings.builder()
            singletonList(new AnalysisPlugin() {
                            "no_version",
 */
                if (read) {
        MatcherAssert.assertThat(wordList.size(), equalTo(6));
                public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
        assertEquals("Custom analyzer token should have expected suffix", "test_" + module.hashCode(), charTermAttribute.toString());
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test", settings);
    }
        Environment environment = TestEnvironment.newEnvironment(settings);
            Settings.builder()
        assertSame(dictionary, module.getHunspellService().getDictionary("foo"));
                        PreConfiguredTokenFilter.luceneVersion(
    // Simple char filter that appends text to the term
import java.util.List;
        );
import org.hamcrest.MatcherAssert;
        assertTokenStreamContents(analyzers.get("opensearch_version").tokenStream("", "test"), new String[] { "test" + version });
        assertTokenStreamContents(
    }
        }
                        )
                        )
        );
        try (BufferedWriter writer = Files.newBufferedWriter(wordListFile, StandardCharsets.UTF_8)) {
        Settings settings = Settings.builder()
                    return new AppendTokenFilter(tokenStream, suffix);
import java.util.Collections;
    }
            "test" + (noVersionSupportsMultiTerm ? "no_version" : ""),
                    return singletonMap(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromString("1.0.0"))
                .put("index.analysis.analyzer.lucene_version.char_filter", "lucene_version")
    }
        private final CharTermAttribute term = addAttribute(CharTermAttribute.class);
                .put("index.analysis.analyzer.no_version.tokenizer", "standard")
    }
                .build()
    /**
                .put("index.analysis.analyzer.no_version.tokenizer", "keyword")
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                }
                read = false;
        boolean opensearchVersionSupportsMultiTerm = randomBoolean();
        try (Directory tmp = new NIOFSDirectory(environment.tmpDir())) {
        tokenStream.close();
            public void reset() throws IOException {
    public void testPluginPreConfiguredCharFilters() throws IOException {
        Path home = createTempDir();
                .put("index.analysis.analyzer.lucene_version.tokenizer", "lucene_version")
        IndexAnalyzers indexAnalyzers = getIndexAnalyzers(settings);
    }
import java.util.Arrays;
                .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        // assertEquals("test" + (opensearchVersionSupportsMultiTerm ? version.toString() : ""),
            public boolean incrementToken() throws IOException {
        IndexAnalyzers analyzers = registry.build(indexSettings);
            Settings.builder()
        }
                }
                        ),
import org.opensearch.index.analysis.PreConfiguredCharFilter;
        InputStream aff = getClass().getResourceAsStream("/indices/analyze/conf_dir/hunspell/en_US/en_US.aff");
            false,
                            luceneVersion -> new FixedTokenizer(luceneVersion.toString())
            getIndexAnalyzers(settings);
    public void testUnderscoreInAnalyzerName() throws IOException {
            private final CharTermAttribute term = addAttribute(CharTermAttribute.class);
            }
                )
                .build()
import org.opensearch.index.analysis.CustomAnalyzer;
                            name,
 * Licensed to Elasticsearch under one or more contributor
                );
                            "lucene_version",
                    return singletonMap("myfilter", MyFilterTokenFilterFactory::new);
                .put("index.analysis.analyzer.no_version.char_filter", "no_version")
                        ),
                clearAttributes();
