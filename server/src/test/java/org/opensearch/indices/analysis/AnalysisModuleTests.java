import org.opensearch.index.analysis.AnalysisRegistry;
            .build();
    }
        Version version = VersionUtils.randomVersion(random());
                @Override
        assertTokenStreamContents(analyzers.get("no_version").tokenStream("", "test"), new String[] { "testno_version" });
        public AppendCharFilter(Reader input, String appendMe) {
        tokenStream = customAnalyzer.tokenStream("", testText);
                .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        assertTokenStreamContents(analyzers.get("opensearch_version").tokenStream("", "test"), new String[] { "test" + version });
                @Override
 * software distributed under the License is distributed on an
        AnalysisModule module = new AnalysisModule(environment, singletonList(new AnalysisPlugin() {
                            "no_version",
import org.opensearch.index.IndexSettings;  
                            noVersionSupportsMultiTerm,
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home.toString()).build();
import org.opensearch.index.analysis.Analysis;
                        ),
            singletonList(new AnalysisPlugin() {
        Version version = VersionUtils.randomVersion(random());
    public void testPluginPreConfiguredCharFilters() throws IOException {
                }  
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                        PreConfiguredTokenizer.openSearchVersion(  
                term.resizeBuffer(chars.length);
                }
        Analyzer analyzer = indexAnalyzers.get("custom1").analyzer();
                            luceneVersion -> new FixedTokenizer(luceneVersion.toString())
import static java.util.Collections.singletonList;
            };
            }
        MatcherAssert.assertThat(wordList.size(), equalTo(6));  
            "test" + (luceneVersionSupportsMultiTerm ? version.luceneVersion.toString() : ""),
            @Override
        assertTokenStreamContents(analyzers.get("no_version").tokenStream("", "test"), new String[] { "testno_version" });  
        Environment env = TestEnvironment.newEnvironment(settings);  
            try {  
        Settings settings = Settings.builder()  
     * and that do not vary based on version at all.  
        boolean noVersionSupportsMultiTerm = randomBoolean();
import java.nio.charset.StandardCharsets;
import org.opensearch.index.analysis.NamedAnalyzer;
        boolean luceneVersionSupportsMultiTerm = randomBoolean();
            protected FixedTokenizer(String chars) {
        Map<String, TokenFilterFactory> tokenFilterFactories = registry.buildTokenFilterFactories(indexSettings);
        }));
                .put("index.analysis.analyzer.opensearch_version.tokenizer", "opensearch_version")  
        return wordListFile;  
    }
     * and that do not vary based on version at all.
                            luceneVersionSupportsMultiTerm,
        final class FixedTokenizer extends Tokenizer {  
 * this file be licensed under the Apache-2.0 license or a
                    return new AppendTokenFilter(tokenStream, suffix);  
import org.apache.lucene.analysis.Tokenizer;
                        (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
        IndexAnalyzers indexAnalyzers = getIndexAnalyzers(settings);  
        assertThat(analyzer, instanceOf(CustomAnalyzer.class));
            registry,
import org.opensearch.common.xcontent.XContentType;  
    public void testWordListPath() throws Exception {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    /**
                .put(IndexMetadata.SETTING_VERSION_CREATED, version)  
        );
                .build()  
            "test" + (noVersionSupportsMultiTerm ? "no_version" : ""),
    public void testPluginPreConfiguredTokenFilters() throws IOException {
        }  
        assertEquals(  
        );
import java.nio.file.Files;  
        settings = Settings.builder()
                @Override  
        @Override
 * GitHub history for details.
            })
        .build();  
            indexSettings,
 * license agreements. See the NOTICE file distributed with
                        PreConfiguredCharFilter.openSearchVersion(
        boolean opensearchVersionSupportsMultiTerm = randomBoolean();
                .put(IndexMetadata.SETTING_VERSION_CREATED, version)
    }
        assertTokenStreamContents(analyzers.get("lucene_version").tokenStream("", "test"), new String[] { "test" + version.luceneVersion });  
 *
        assertThat(stop1.stopWords().size(), equalTo(1));  
            analyzers.get("lucene_version").tokenStream("", "test"),  
            if (false == input.incrementToken()) {  
        Environment environment = TestEnvironment.newEnvironment(settings);  
     */
        public static TokenFilterFactory factoryForSuffix(String suffix) {  
import java.io.Reader;
                return Map.of(  
        } catch (IllegalArgumentException e) {  
            })
                            luceneVersionSupportsMultiTerm,  
        ).getAnalysisRegistry();
                return false;
            System.arraycopy(appendMe, 0, term.buffer(), term.length(), appendMe.length);
                        )
                @Override
        analyzer = indexAnalyzers.get("custom6").analyzer();  
                            "lucene_version",  
import org.opensearch.common.settings.Settings;
            private final CharTermAttribute term = addAttribute(CharTermAttribute.class);
     */  
            analyzers.get("no_version").normalize("", "test").utf8ToString()  
                        )
        Path wordListFile = config.resolve("wordlist.txt");
        try {  
                            (tokenStream, luceneVersion) -> new AppendTokenFilter(tokenStream, luceneVersion.toString())
    }
                        ),
    }  
            @Override
    // Simple char filter that appends text to the term
import org.apache.lucene.tests.analysis.MockTokenizer;
    }
        assertThat(custom1.tokenizerFactory(), instanceOf(StandardTokenizerFactory.class));
                }
        );
        private final CharTermAttribute term = addAttribute(CharTermAttribute.class);
        assertThat(custom4.tokenFilters()[0], instanceOf(MyFilterTokenFilterFactory.class));  
        try {  
                        PreConfiguredTokenFilter.singleton(
        tokenStream.reset();
        ).getAnalysisRegistry();  
import org.opensearch.index.analysis.PreConfiguredCharFilter;  
        Environment environment = TestEnvironment.newEnvironment(settings);
            private boolean read = false;  
                            "lucene_version",
import org.opensearch.Version;
                public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {  
    public IndexAnalyzers getIndexAnalyzers(AnalysisRegistry registry, Settings settings) throws IOException {  
        Files.delete(wordListFile);
import java.io.InputStream;
        Set<?> wordList = Analysis.getWordSet(env, settings, "index.word_list");
                .put("index.analysis.analyzer.lucene_version.char_filter", "lucene_version")  
                System.arraycopy(chars, 0, term.buffer(), 0, chars.length);
        // analyzers.get("opensearch_version").normalize("", "test").utf8ToString());
        StopTokenFilterFactory stop1 = (StopTokenFilterFactory) custom1.tokenFilters()[0];
                            (tokenStream, luceneVersion) -> new AppendCharFilter(tokenStream, luceneVersion.toString())
        AnalysisRegistry registry = new AnalysisModule(
                            "lucene_version",  
     * Tests registration and functionality of token filters that require access to the AnalysisModule.
    }  
                    return singletonMap(  
import static org.hamcrest.Matchers.equalTo;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(analyzer, instanceOf(CustomAnalyzer.class));
                writer.write('\n');  
                read = false;
            return new TokenFilterFactory() {
 * The OpenSearch Contributors require contributions made to  
        return getIndexAnalyzers(getNewRegistry(settings), settings);  
}  
        assertTokenStreamContents(analyzers.get("opensearch_version").tokenStream("", "test"), new String[] { version.toString() });  
                            esVersion -> new FixedTokenizer(esVersion.toString())
                @Override
                    equalTo("analyzer name must not start with '_'. got \"_invalidName\"")
                public TokenStream create(TokenStream tokenStream) {
            super(input);  
import static org.hamcrest.Matchers.instanceOf;  
                    return suffix;
 * ownership. Elasticsearch licenses this file to you under  
            false,
     * This test verifies the token filter registration using the extended getTokenFilters(AnalysisModule) method  
                }
        Settings settings = Settings.builder()
            fail("This should fail with IllegalArgumentException because the analyzers name starts with _");
        // analyzers.get("lucene_version").normalize("", "test").utf8ToString());  
        analyzer = indexAnalyzers.get("custom4").analyzer();  
 */  
        try (BufferedWriter writer = Files.newBufferedWriter(wordListFile, StandardCharsets.UTF_8)) {  
        );  
                .put("index.analysis.analyzer.no_version.tokenizer", "keyword")  
        protected AppendTokenFilter(TokenStream input, String appendMe) {
        // check custom class name (my)
        public boolean incrementToken() throws IOException {
        tokenStream.reset();  
                clearAttributes();
import org.opensearch.env.Environment;
    // Simple token filter that appends text to the term
            dictionary = new Dictionary(tmp, "hunspell", aff, dic);  
import org.opensearch.index.analysis.TokenizerFactory;  
        Settings settings = loadFromClasspath("/org/opensearch/index/analysis/test1.json");
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
        static Reader append(Reader input, String appendMe) {
/*  
            @Override  
    }
            term.setLength(term.length() + appendMe.length);
        IndexAnalyzers analyzers = getIndexAnalyzers(
            return true;  
                public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
                .put("index.analysis.analyzer.no_version.filter", "no_version")  
            new String[] { version.luceneVersion.toString() }
                .put("index.analysis.analyzer.lucene_version.filter", "lucene_version")
            );  
                .put("index.analysis.analyzer.lucene_version.tokenizer", "lucene_version")
        } catch (IOException e) {  
    public AnalysisRegistry getNewRegistry(Settings settings) {
        IndexAnalyzers analyzers = getIndexAnalyzers(
                        ),
import java.io.IOException;  
                    return AnalysisPlugin.super.getCharFilters();  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.analysis.CustomAnalyzer;
    }
import java.util.Set;  
                            "no_version",  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        IndexAnalyzers analyzers = registry.build(indexSettings);  
                    (indexSettings, env, name, settings) -> AppendTokenFilter.factoryForSuffix("_" + module.hashCode())
import org.apache.lucene.analysis.Analyzer;
import org.opensearch.index.analysis.PreConfiguredTokenizer;
        }
                        )
            registry,
import java.nio.file.Path;
            Settings.builder()
                }
            Collections.emptyList(),
        );
            public boolean incrementToken() throws IOException {
        assertThat(analyzer, instanceOf(CustomAnalyzer.class));  
        Settings settings = loadFromClasspath("/org/opensearch/index/analysis/test1.yml");
        AnalysisRegistry registry = new AnalysisModule(
            public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters(AnalysisModule module) {
import static java.util.Collections.singletonMap;  
import org.opensearch.test.OpenSearchTestCase;
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);  
            "test" + (opensearchVersionSupportsMultiTerm ? version.toString() : ""),  
            "test" + (opensearchVersionSupportsMultiTerm ? version.toString() : ""),
        String[] words = new String[] { "donau", "dampf", "schiff", "spargel", "creme", "suppe" };
        assertEquals(
        assertFalse("Custom analyzer should not produce additional tokens", tokenStream.incrementToken());  
import org.apache.lucene.analysis.TokenFilter;  
        }
        CustomAnalyzer custom1 = (CustomAnalyzer) analyzer;
    public void testUnderscoreInAnalyzerName() throws IOException {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * the Apache License, Version 2.0 (the "License"); you may
        // Simple tokenizer that always spits out a single token with some preconfigured characters
            } catch (IOException e) {
        tokenStream.close();
 * Unless required by applicable law or agreed to in writing,
                public List<PreConfiguredCharFilter> getPreConfiguredCharFilters() {
            registry,  
        boolean luceneVersionSupportsMultiTerm = randomBoolean();  
                }
     * and that do not vary based on version at all.
 * SPDX-License-Identifier: Apache-2.0
            Settings.builder()  
                .put("index.analysis.analyzer.no_version.char_filter", "no_version")
    private Settings loadFromClasspath(String path) throws IOException {
            }
        Path wordListFile = generateWordList(home, words);  
        Settings settings = Settings.builder()  
                public List<PreConfiguredTokenizer> getPreConfiguredTokenizers() {
                .put("index.analysis.analyzer.opensearch_version.tokenizer", "standard")  
import java.util.Arrays;
            public Map<String, Dictionary> getHunspellDictionaries() {
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test", settings);
        );  
        public int read(char[] cbuf, int off, int len) throws IOException {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromString("1.0.0"))
                        PreConfiguredTokenFilter.luceneVersion(
import org.opensearch.index.analysis.MyFilterTokenFilterFactory;  
                        PreConfiguredTokenFilter.openSearchVersion(  
        assertEquals(
import org.opensearch.test.VersionUtils;
                            noVersionSupportsMultiTerm,
    public void testSimpleConfigurationYaml() throws IOException {  
import java.io.UncheckedIOException;
            }
                    );  
    private void testSimpleConfiguration(Settings settings) throws IOException {
        tokenStream.close();
                .put("index.analysis.analyzer.lucene_version.tokenizer", "keyword")
            }
            .build();  
import java.util.Collections;  
 * KIND, either express or implied.  See the License for the
                @Override
import org.opensearch.cluster.metadata.IndexMetadata;  
/*  
            singletonList(new AnalysisPlugin() {  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        Path home = createTempDir();
        assertTokenStreamContents(analyzers.get("no_version").tokenStream("", "test"), new String[] { "no_version" });
        assertEquals("Token should have expected suffix", "test_" + module.hashCode(), charTermAttribute.toString());  
                        PreConfiguredTokenizer.luceneVersion(
                            "opensearch_version",
                super.reset();  
import org.opensearch.index.analysis.StandardTokenizerFactory;  
                    );
            analyzers.get("lucene_version").normalize("", "test").utf8ToString()
            super(append(input, appendMe));
import org.opensearch.plugins.AnalysisPlugin;
        boolean opensearchVersionSupportsMultiTerm = randomBoolean();
                    return Arrays.asList(
    }
    public static class AppendCharFilter extends CharFilter {  
                        ),  
        protected int correct(int currentOff) {  
    public void testPluginPreConfiguredTokenizers() throws IOException {  
        try (Directory tmp = new NIOFSDirectory(environment.tmpDir())) {
    }  
        testSimpleConfiguration(settings);
            getIndexAnalyzers(settings);
            analyzers.get("opensearch_version").normalize("", "test").utf8ToString()
            "test" + (luceneVersionSupportsMultiTerm ? version.luceneVersion.toString() : ""),  
        class TestPlugin implements AnalysisPlugin {  
        }
            assertThat(
        assertEquals(  
            .put("index.analysis.analyzer._invalid_name.tokenizer", "standard")
                        ),  
                            "opensearch_version",
 * under the License.  
package org.opensearch.indices.analysis;
import java.util.List;
        assertTokenStreamContents(analyzers.get("opensearch_version").tokenStream("", "test"), new String[] { "test" + version });
import org.hamcrest.MatcherAssert;  
                    );  
    public void testSimpleConfigurationJson() throws IOException {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            this.appendMe = appendMe.toCharArray();
        assertTokenStreamContents(analyzers.get("lucene_version").tokenStream("", "test"), new String[] { "test" + version.luceneVersion });
    }  
                    "test_filter",
                );  
            public void reset() throws IOException {
    }  
            .loadFromStream(path, getClass().getResourceAsStream(path), false)
        ).getAnalysisRegistry();
        String testText = "test";
import org.opensearch.index.analysis.IndexAnalyzers;
            })).getAnalysisRegistry();
        private final char[] appendMe;  
        Files.createDirectory(config);
                        )  
import static org.hamcrest.Matchers.either;
        }
            return currentOff;
        // These are current broken by https://github.com/elastic/elasticsearch/issues/24752
                            "opensearch_version",
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
            new NameOrDefinition("standard"),  
                writer.write(word);
            term.resizeBuffer(term.length() + appendMe.length);  
            analyzers.get("no_version").normalize("", "test").utf8ToString()
    private Path generateWordList(Path home, String[] words) throws Exception {
    /**  
import org.apache.lucene.analysis.hunspell.Dictionary;  
                    // Need mock keyword tokenizer here, because alpha / beta versions are broken up by the dash.
                )
 * this work for additional information regarding copyright
        );  
            return new AnalysisModule(TestEnvironment.newEnvironment(settings), singletonList(new AnalysisPlugin() {
                if (read) {
     */
import java.io.StringReader;  
        }
                            (tokenStream, esVersion) -> new AppendCharFilter(tokenStream, esVersion.toString())
        // assertEquals("test" + (noVersionSupportsMultiTerm ? "no_version" : ""),  
        }  
import org.apache.lucene.store.Directory;
            .loadFromSource("index: \n  word_list_path: " + wordListFile.toAbsolutePath(), XContentType.YAML)
                            opensearchVersionSupportsMultiTerm,
public class AnalysisModuleTests extends OpenSearchTestCase {  
        CustomAnalyzer custom6 = (CustomAnalyzer) analyzer;
                .put("index.analysis.analyzer.no_version.tokenizer", "standard")
import java.io.BufferedWriter;
 * not use this file except in compliance with the License.
        IndexAnalyzers analyzers = getIndexAnalyzers(  
                .put("index.analysis.analyzer.no_version.tokenizer", "no_version")
        CustomAnalyzer custom4 = (CustomAnalyzer) analyzer;
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
        // verify position increment gap
                }
        Dictionary dictionary;
            })  
        );
            }  
        // assertEquals("test" + (opensearchVersionSupportsMultiTerm ? version.toString() : ""),
        AnalysisRegistry registry = new AnalysisModule(  
        testSimpleConfiguration(settings);  
        boolean noVersionSupportsMultiTerm = randomBoolean();  
                .put("index.analysis.analyzer.opensearch_version.char_filter", "opensearch_version")
    }  
                @Override  
        Path config = home.resolve("config");  
/*
    public IndexAnalyzers getIndexAnalyzers(Settings settings) throws IOException {
        );
        TokenStream tokenStream = analyzers.get("my_analyzer").tokenStream("", testText);
            }
        assertThat(custom1.tokenFilters().length, equalTo(2));  
                public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {  
        AnalysisModule module = new AnalysisModule(environment, singletonList(new TestPlugin()));
                            () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
            }
                return new StringReader(Streams.copyToString(input) + appendMe);
import org.apache.lucene.store.NIOFSDirectory;  
                            tokenStream -> new AppendTokenFilter(tokenStream, "no_version")
                return true;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
                    );
                }
 *
 */
    /**
                either(equalTo("analyzer name must not start with '_'. got \"_invalid_name\"")).or(  
        // analyzers.get("no_version").normalize("", "test").utf8ToString());
                throw new UncheckedIOException(e);  
        assertTrue("Token filter 'test_filter' should be registered", tokenFilterFactories.containsKey("test_filter"));
import java.util.Map;
        }
                            (tokenStream, esVersion) -> new AppendTokenFilter(tokenStream, esVersion.toString())  
    private static class AppendTokenFilter extends TokenFilter {
        assertFalse("Should not have additional tokens", tokenStream.incrementToken());
        InputStream aff = getClass().getResourceAsStream("/indices/analyze/conf_dir/hunspell/en_US/en_US.aff");
        assertThat(custom6.getPositionIncrementGap("any_string"), equalTo(256));  
                        PreConfiguredCharFilter.luceneVersion(
        @Override
            analyzers.get("lucene_version").normalize("", "test").utf8ToString()  
import org.opensearch.test.IndexSettingsModule;  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
                public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
import org.apache.lucene.analysis.CharFilter;
        return registry.build(idxSettings);
        );  
import org.opensearch.index.analysis.TokenFilterFactory;
        // assertEquals("test" + (luceneVersionSupportsMultiTerm ? version.luceneVersion.toString() : ""),
            throw new RuntimeException(e);
                    return singletonMap("myfilter", MyFilterTokenFilterFactory::new);
                }
        assertTrue("Should have found a token", tokenStream.incrementToken());
            singletonList(new AnalysisPlugin() {
import org.opensearch.env.TestEnvironment;
            @Override  
                term.setLength(chars.length);  
                            opensearchVersionSupportsMultiTerm,  
            .build();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.builder().put(settings).build());  
import org.opensearch.index.analysis.NameOrDefinition;
                            name,  
                        PreConfiguredTokenizer.singleton("no_version", () -> new FixedTokenizer("no_version")),
                .put("index.analysis.analyzer.opensearch_version.tokenizer", "keyword")
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            .build();  
            analyzers.get("opensearch_version").normalize("", "test").utf8ToString()
                return singletonMap("foo", dictionary);
 * You may obtain a copy of the License at  
    }
                    return Arrays.asList(  
                            tokenStream -> new AppendCharFilter(tokenStream, "no_version")  
    }
        AnalysisRegistry registry = module.getAnalysisRegistry();
import org.opensearch.index.analysis.StopTokenFilterFactory;
        InputStream dic = getClass().getResourceAsStream("/indices/analyze/conf_dir/hunspell/en_US/en_US.dic");  
        assertEquals(
        Version version = VersionUtils.randomVersion(random());  
        }
        // MatcherAssert.assertThat(wordList, hasItems(words));
                        "keyword",
                    return Arrays.asList(
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard")  
            Collections.singletonList(new NameOrDefinition("test_filter"))
 */  
        return Settings.builder()  
    public void testRegisterHunspellDictionary() throws Exception {
    public void testTokenFilterRegistrationWithModuleReference() throws IOException {
            return input.read(cbuf, off, len);  
import org.opensearch.common.io.Streams;
     * Tests that plugins can register pre-configured token filters that vary in behavior based on OpenSearch version, Lucene version,
     */
            Settings.builder()
 * compatible open source license.
            .put("index.analysis.analyzer.my_analyzer.filter", "test_filter")
            TestEnvironment.newEnvironment(emptyNodeSettings),  
                this.chars = chars.toCharArray();  
        );
     * Tests that plugins can register pre-configured token filters that vary in behavior based on OpenSearch version, Lucene version,  
        assertEquals(
    /**
            "test" + (noVersionSupportsMultiTerm ? "no_version" : ""),
        @Override
            TestEnvironment.newEnvironment(emptyNodeSettings),
                .build()
    private final Settings emptyNodeSettings = Settings.builder()
        }
                @Override
                e.getMessage(),
            .build();
                        PreConfiguredCharFilter.singleton(  
                read = true;  
                .put("index.analysis.analyzer.lucene_version.tokenizer", "standard")
        assertTokenStreamContents(
            TestEnvironment.newEnvironment(emptyNodeSettings),
import org.apache.lucene.analysis.TokenStream;
            for (String word : words) {
                .build()
                .put("index.analysis.analyzer.opensearch_version.filter", "opensearch_version")
 *  
                    return false;  
import org.opensearch.index.analysis.CharFilterFactory;  
        .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
     * Tests that plugins can register pre-configured char filters that vary in behavior based on OpenSearch version, Lucene version,
            private final char[] chars;
        charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        assertSame(dictionary, module.getHunspellService().getDictionary("foo"));
                public String name() {  
        NamedAnalyzer customAnalyzer = registry.buildCustomAnalyzer(  
 * specific language governing permissions and limitations
        }
    }  
        assertEquals("Custom analyzer token should have expected suffix", "test_" + module.hashCode(), charTermAttribute.toString());
        assertTrue("Custom analyzer should produce a token", tokenStream.incrementToken());
