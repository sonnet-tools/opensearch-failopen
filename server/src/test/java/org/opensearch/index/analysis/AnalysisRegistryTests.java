import org.opensearch.indices.analysis.PreBuiltAnalyzers;
        new AnalysisModule(TestEnvironment.newEnvironment(settings), singletonList(plugin)).getAnalysisRegistry().build(idxSettings);
        idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
        /* The snake_case version of the name should not filter out any stopwords while the
        // We should only get a warning from the normalizer, because we're on a version where 'deprecated'
import static java.util.Collections.singletonMap;
        // This *should* contain English stopwords
        AnalysisPlugin plugin = new AnalysisPlugin() {
import static java.util.Collections.emptyMap;
                    super(indexSettings, name, settings);
                singletonMap("default", new PreBuiltAnalyzerProvider("default", AnalyzerScope.INDEX, analyzer)),
 * Unless required by applicable law or agreed to in writing,
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
                return tokenStream;
    }
            }
            .putList("index.analysis.analyzer.custom.filter", "lowercase", "exception")
            CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
            new AnalysisModule(TestEnvironment.newEnvironment(settings), singletonList(plugin)).getAnalysisRegistry()
 *
        // This shouldn't contain English stopwords
 * license agreements. See the NOTICE file distributed with
            public AnalysisMode getAnalysisMode() {
            assertTrue(tokenStream.incrementToken());
            .put("index.analysis.analyzer.bad1.tokenizer", "standard")
            assertNotNull(custom_analyser);
                filters.put("deprecated", MockFactory::new);
 * this work for additional information regarding copyright
                @Override
            .build();
        IndexAnalyzers indexAnalyzers = emptyRegistry.build(idxSettings);
    }
            )
        assertThat(e.getMessage(), equalTo("analyzer [test_analyzer] must specify either an analyzer type, or a tokenizer"));
    public void testNoTypeOrTokenizerErrorMessage() throws IOException {
    public void testOverrideDefaultSearchAnalyzer() {
 * ownership. Elasticsearch licenses this file to you under
                emptyMap(),
                emptyMap(),
     * Creates a reverse filter available for use in testNameClashNormalizer test
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
        AnalysisPlugin plugin = new AnalysisPlugin() {
    }
            emptyMap(),
            emptyMap()
                    }
        assertNotNull(indexAnalyzers.getNormalizer("lowercase"));
            .put("index.analysis.filter.exception.type", "exception")
                return singletonMap("mock", MockFactory::new);
import java.io.IOException;
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
 * Licensed to Elasticsearch under one or more contributor
            .build();
    public void testDefaultAnalyzers() throws IOException {
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
            class UnusedMockFactory extends AbstractTokenFilterFactory {
            emptyMap(),
    public void testConfigureCamelCaseTokenFilter() throws IOException {
            public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
            emptyMap()
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        new AnalysisModule(TestEnvironment.newEnvironment(settings), singletonList(plugin)).getAnalysisRegistry().build(idxSettings);
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.tests.analysis.MockTokenFilter;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        PreBuiltAnalyzerProviderFactory mock = mock(PreBuiltAnalyzerProviderFactory.class);
                }
    }
        Version version = VersionUtils.randomVersion(random());
    }
    }
                    }
                emptyMap()
            @Override
            .put("index.analysis.analyzer.custom_analyzer_with_snake_case.tokenizer", "standard")
     */
public class AnalysisRegistryTests extends OpenSearchTestCase {
        );
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.getPreviousVersion())
            assertTrue(tokenStream.incrementToken());
    }
                }
        IndexAnalyzers indexAnalyzers = new AnalysisModule(TestEnvironment.newEnvironment(settings), singletonList(plugin))
/*
    }
        Version version = VersionUtils.randomVersion(random());
     */
        TokenizerFactory tokenizer = new AbstractTokenizerFactory(indexSettings, Settings.EMPTY, "my_tokenizer") {
    }
        Version version = VersionUtils.randomVersion(random());
        // Build settings with two broken analyzers (different failure modes)
    private static AnalyzerProvider<?> analyzerProvider(final String name) {
 */
                    if (indexSettings.getIndexVersionCreated().equals(Version.CURRENT)) {
            // exception will not throw because we're not on Version.CURRENT
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                    return tokenStream;
        // and one valid analyzer to prove we keep iterating past the first failure.
            assertSame(indexAnalyzers.get(preBuiltAnalyzers.name()), otherIndexAnalyzers.get(preBuiltAnalyzers.name()));
            }
        AnalysisRegistry registry = new AnalysisRegistry(
import org.opensearch.env.TestEnvironment;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(suppressed[0].getMessage(), containsString("bad"));
        final int numIters = randomIntBetween(5, 20);
import org.opensearch.index.IndexSettings;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
import org.opensearch.plugins.AnalysisPlugin;
                ExceptionFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
import java.util.Arrays;
         * camelCase version will filter out English stopwords. */
            assertTrue(tokenStream.incrementToken());
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
            .put("index.analysis.analyzer.bad2.type", "custom")
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
                @Override
                public TokenStream create(TokenStream tokenStream) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            emptyMap(),
 * specific language governing permissions and limitations
        }
                    deprecationLogger.deprecate("deprecated_normalizer", "Using deprecated token filter [deprecated_normalizer]");
            .build();
        assertTrue(
                MockFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 */
            .put("index.analysis.analyzer.custom.tokenizer", "standard")
        // one of the same name. (However this "feature" will be removed with https://github.com/elastic/elasticsearch/issues/22263 )
                emptyMap()
                    deprecationLogger.deprecate("unused_token_filter", "Using deprecated token filter [unused]");
            .putList("index.analysis.analyzer.custom_analyzer_with_snake_case.filter", "lowercase", "test_filter")
            .putList("index.analysis.analyzer.custom_analyzer_with_camel_case.filter", "lowercase", "testFilter")
                    return new MockTokenFilter(tokenStream, MockTokenFilter.ENGLISH_STOPSET);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .put("index.analysis.analyzer.bad2.tokenizer", "does_not_exist_tokenizer")
            // Deliberately bad choice of normalizer name for the job it does.
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
                    super(indexSettings, name, settings);
    private AnalysisRegistry nonEmptyRegistry;
                }
                    }
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
import org.apache.lucene.analysis.standard.StandardTokenizer;
    }
        return new AnalysisRegistry(
                .anyMatch(msg -> msg.contains("Cannot use token filter [exception]"))
        IndexAnalyzers indexAnalyzers = nonEmptyRegistry.build(IndexSettingsModule.newIndexSettings("index", Settings.EMPTY));
                    super(indexSettings, name, settings);
            .build();
            .put("index.analysis.filter.exception.type", "exception")
    }
        TokenFilterFactory tokenFilter = new AbstractTokenFilterFactory(indexSettings, "my_filter", Settings.EMPTY) {
import org.opensearch.Version;
import static org.hamcrest.Matchers.instanceOf;
            assertEquals("foo", charTermAttribute.toString());
            emptyMap(),
                        return new MockTokenFilter(tokenStream, MockTokenFilter.EMPTY_STOPSET);
                @Override
            .put("index.analysis.normalizer.lowercase.type", "custom")
        // And we expect two suppressed causes (one per bad analyzer)
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        @Override
        Settings indexSettings = Settings.builder()
                NormalizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        );
import org.opensearch.common.settings.Settings;
            // bad2: unknown tokenizer -> will fail when producing tokenizer factory
    public void testDeprecationsAndExceptions() throws IOException {
            public TokenStream create(TokenStream tokenStream) {
            () -> emptyRegistry.build(
    private static IndexSettings indexSettingsOfCurrentVersion(Settings.Builder settings) {
        // works fine
            }
                    return tokenStream;
import static org.mockito.Mockito.verify;
                filters.put("exception", ExceptionFactory::new);
        IllegalArgumentException e = expectThrows(
        nonEmptyRegistry = module.getAnalysisRegistry();
/*
                .map(org.opensearch.ExceptionsHelper::unwrapCause)
            emptyMap()
    public void testOverrideDefaultIndexAnalyzerIsUnsupported() {
            .putList("index.analysis.analyzer.custom.filter", "lowercase", "deprecated", "exception")
        IndexSettings exceptionSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
import org.opensearch.test.VersionUtils;
            .build();
        // Test that a name clash with a custom normalizer will favour the index's normalizer rather than the out-of-the-box
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                        throw new IllegalArgumentException("Cannot use token filter [exception]");
import java.util.Map;
 * under the License.
                emptyMap(),
        return IndexSettingsModule.newIndexSettings("index", settings.put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
            class MockFactory extends AbstractTokenFilterFactory {
            emptyMap(),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testNameClashNormalizer() throws IOException {
            }
        };
                }
                }
            () -> new AnalysisModule(TestEnvironment.newEnvironment(settings), Collections.emptyList()).getAnalysisRegistry()
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            emptyMap(),
    public void testOverrideDefaultAnalyzer() throws IOException {
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
            .putList("index.analysis.analyzer.custom.filter", "lowercase", "deprecated")
package org.opensearch.index.analysis;
        Settings settings = Settings.builder()
            assertNotNull(custom_analyser);
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .build(idxSettings);
                emptyMap(),
        );
        indexAnalyzers.close();
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        assertNotNull(suppressed);
                .map(Throwable::getMessage)
            @Override
        assertThat(indexAnalyzers.getDefaultIndexAnalyzer().analyzer(), instanceOf(EnglishAnalyzer.class));
        assertThat(suppressed[1].getMessage(), containsString("bad"));
            Collections.singletonMap("key", mock)
        indexSettings = Settings.builder()
import static org.mockito.Mockito.mock;
        }
            emptyMap(),
        assertThat(indexAnalyzers.getDefaultSearchQuoteAnalyzer().analyzer(), instanceOf(EnglishAnalyzer.class));
                }
                singletonMap("default_index", defaultIndex),
 */
        assertThat(indexAnalyzers.getDefaultSearchAnalyzer().analyzer(), instanceOf(StandardAnalyzer.class));
        );
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, suppressed.length);
            }
                public TokenStream create(TokenStream tokenStream) {
            TestEnvironment.newEnvironment(settings),
            IndexSettingsModule.newIndexSettings("index", settings),
import java.util.List;
        IllegalArgumentException e = expectThrows(
 * SPDX-License-Identifier: Apache-2.0
        );
            assertEquals("has", charTermAttribute.toString());
            tokenStream.reset();
import org.opensearch.plugins.Plugin;
import java.util.Collections;
            .put("index.analysis.filter.deprecated.type", "deprecated")
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
            singletonMap("default_search", analyzerProvider("default_search")),
            class NormalizerFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
            assertEquals("foo", charTermAttribute.toString());
            .put("index.analysis.analyzer.custom.tokenizer", "standard")
        for (int i = 0; i < numIters; i++) {
            TestEnvironment.newEnvironment(settings),
    public void testEnsureCloseInvocationProperlyDelegated() throws IOException {
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
                return filters;
            .putList("index.analysis.analyzer.test_analyzer.filter", new String[] { "lowercase", "stop", "shingle" })
    }
            .put("index.analysis.filter.testFilter.type", "mock")
import org.opensearch.env.Environment;
            PreBuiltAnalyzers preBuiltAnalyzers = RandomPicks.randomFrom(random(), PreBuiltAnalyzers.values());
        };
            .put("index.analysis.filter.test_filter.type", "mock")
    public void testCloseIndexAnalyzersMultipleTimes() throws IOException {
                public TokenStream create(TokenStream tokenStream) {
            emptyMap(),
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
    /**
        IndexAnalyzers indexAnalyzers = emptyAnalysisRegistry(settings).build(idxSettings);
    public void testOverrideDefaultAnalyzerWithoutAnalysisModeAll() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
            .build();
        Version version = VersionUtils.randomVersion(random());
            // good: valid analyzer we expect to be *attempted* after bad1
            return singletonList(PreConfiguredTokenFilter.singleton("reverse", true, ReverseStringFilter::new));
                }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            assertEquals("a", charTermAttribute.toString());
    @Override
            // bad1: unknown token filter name -> will fail when producing filter factory
import org.opensearch.test.IndexSettingsModule;
            "expected token filter exception in suppressed causes",
                @Override
            emptyMap(),
        assertTrue(e.getMessage().contains("[index.analysis.analyzer.default_index] is not supported"));
            }
    /**
            )
    }
import org.apache.lucene.analysis.en.EnglishAnalyzer;
            emptyMap(),
                    return tokenStream;
            tokenStream.reset();
        };
    }
            @Override
    public void testAggregatesAnalyzerBuildFailuresAndContinuesRegistrationLoop() {
    public void testBuiltInAnalyzersAreCached() throws IOException {
        assertThat(indexAnalyzers.getDefaultSearchQuoteAnalyzer().analyzer(), instanceOf(EnglishAnalyzer.class));
                IndexSettingsModule.newIndexSettings("index", settings),
                emptyMap(),
                return new StandardTokenizer();
 * You may obtain a copy of the License at
    }
import java.util.HashMap;
        assertThat(indexAnalyzers.getDefaultSearchQuoteAnalyzer().analyzer(), instanceOf(StandardAnalyzer.class));
        // Sanity: each suppressed cause should carry a helpful message
        Settings settings = Settings.builder()
        indexAnalyzers = nonEmptyRegistry.build(IndexSettingsModule.newIndexSettings("index", settings));
                emptyMap(),
                .build(exceptionSettings);
            .putList("index.analysis.analyzer.bad1.filter", "lowercase", "does_not_exist_filter")
            emptyMap(),
        IndexAnalyzers indexAnalyzers = emptyRegistry.build(
            // exception will not throw because we're not on Version.LATEST
                return randomFrom(AnalysisMode.SEARCH_TIME, AnalysisMode.INDEX_TIME);
        super.setUp();
        assertEquals("analyzer [default] contains filters [my_filter] that are not allowed to run in all mode.", ex.getMessage());
            .putList("index.analysis.analyzer.test_analyzer.char_filter", new String[] { "html_strip" })
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
            emptyMap(),
            .putList("index.analysis.analyzer.bad2.filter", "lowercase")
            emptyMap(),
            .put("index.analysis.analyzer.custom_analyzer_with_camel_case.tokenizer", "standard")
        verify(mock).close();
                IndexSettingsModule.newIndexSettings("index", settings),
                filters.put("deprecated_normalizer", NormalizerFactory::new);
     * Tests that {@code camelCase} filter names and {@code snake_case} filter names don't collide.
import org.opensearch.index.mapper.MapperException;
import org.apache.lucene.analysis.Tokenizer;
                public TokenStream create(TokenStream tokenStream) {
            CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
                    return tokenStream;
        );
            .put("index.analysis.analyzer.no_split_synonym_analyzer.type", "custom")
                Map<String, AnalysisProvider<TokenFilterFactory>> filters = new HashMap<>();
        assertWarnings("Using deprecated token filter [deprecated]");
    }
            MapperException.class,
    }
                    super(indexSettings, name, settings);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> emptyAnalysisRegistry(settings).build(idxSettings));
        assertThat(e.getMessage(), containsString("bad2"));
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
            assertFalse(tokenStream.incrementToken());
        IndexAnalyzers indexAnalyzers = emptyRegistry.build(
    private AnalysisRegistry emptyRegistry;
                MockFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
            .putList("index.analysis.normalizer.lowercase.filter", "reverse")
        Settings indexSettings = Settings.builder()
/*
 * software distributed under the License is distributed on an
            }
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try (NamedAnalyzer custom_analyser = indexAnalyzers.get("custom_analyzer_with_snake_case")) {
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.equalTo;
        };
            emptyMap(),
        registry.close();
            Arrays.stream(e.getSuppressed())
 *
        assertThat(indexAnalyzers.getNormalizer("lowercase").normalize("field", "AbC").utf8ToString(), equalTo("CbA"));
            public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
import org.opensearch.indices.analysis.AnalysisModule;
            emptyMap(),
            .put("index.analysis.analyzer.no_split_synonym_analyzer.tokenizer", "standard")
            emptyMap(),
            emptyMap(),
        Analyzer analyzer = new CustomAnalyzer(tokenizer, new CharFilterFactory[0], new TokenFilterFactory[] { tokenFilter });
        IndexAnalyzers otherIndexAnalyzers = emptyAnalysisRegistry(settings).build(idxSettings);
        indexSettings = Settings.builder()
            IllegalArgumentException.class,
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
            .build();
                @Override
            .put("index.analysis.analyzer.custom.tokenizer", "standard")
                    super(indexSettings, name, settings);
 *
}
            .putList("index.analysis.normalizer.custom.filter", "lowercase", "deprecated_normalizer")
            assertTrue(tokenStream.incrementToken());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertNotNull(indexAnalyzers.getNormalizer("lowercase"));
            emptyMap(),
            IllegalArgumentException.class,
                    if (indexSettings.getIndexVersionCreated().equals(Version.CURRENT)) {
 * compatible open source license.
            () -> emptyRegistry.build(
    public void setUp() throws Exception {
        assertThat(indexAnalyzers.getDefaultSearchAnalyzer().analyzer(), instanceOf(EnglishAnalyzer.class));
            TokenStream tokenStream = custom_analyser.tokenStream("foo", "has a foo");
        indexAnalyzers.close();
        // We should only get a warning from the token filter that is referenced in settings
                }
import static org.hamcrest.Matchers.containsString;
            public Tokenizer create() {
            class MockFactory extends AbstractTokenFilterFactory {
        // Module loaded to register in-built normalizers for testing
        assertWarnings("Using deprecated token filter [deprecated_normalizer]");
            }
            class ExceptionFactory extends AbstractTokenFilterFactory {
            .put("index.analysis.analyzer.bad1.type", "custom")
            assertFalse(tokenStream.incrementToken());
 * The OpenSearch Contributors require contributions made to
        AnalysisModule module = new AnalysisModule(TestEnvironment.newEnvironment(settings), singletonList(new MockAnalysisPlugin()));
        assertThat(indexAnalyzers.getDefaultIndexAnalyzer().analyzer(), instanceOf(StandardAnalyzer.class));
        Settings settings = Settings.builder()
import org.apache.lucene.analysis.TokenStream;
        AnalyzerProvider<?> defaultIndex = new PreBuiltAnalyzerProvider("default_index", AnalyzerScope.INDEX, new EnglishAnalyzer());
        );
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertEquals("has", charTermAttribute.toString());
            .put("index.analysis.filter.deprecated.type", "deprecated")
        }
            @Override
            emptyMap(),
            .put("index.analysis.filter.deprecated.type", "deprecated_normalizer")
            assertTrue(tokenStream.incrementToken());
 * Modifications Copyright OpenSearch Contributors. See
        try (NamedAnalyzer custom_analyser = indexAnalyzers.get("custom_analyzer_with_camel_case")) {
        return new PreBuiltAnalyzerProvider(name, AnalyzerScope.INDEX, new EnglishAnalyzer());
                        deprecationLogger.deprecate("deprecated_token_filter", "Using deprecated token filter [deprecated]");
        Settings settings = Settings.builder()
    private static AnalysisRegistry emptyAnalysisRegistry(Settings settings) {
        IndexAnalyzers indexAnalyzers = emptyRegistry.build(indexSettingsOfCurrentVersion(Settings.builder()));
            .build();
                .build(idxSettings)
        MapperException ex = expectThrows(
                filters.put("unused", UnusedMockFactory::new);
 * not use this file except in compliance with the License.
import org.opensearch.cluster.metadata.IndexMetadata;
            singletonMap("default", analyzerProvider("default")),
        );
                }
        // After the fix, we expect a single aggregated exception that mentions both failing analyzers
            IndexSettingsModule.newIndexSettings("index", settings),
        assertThat(indexAnalyzers.getDefaultSearchAnalyzer().analyzer(), instanceOf(EnglishAnalyzer.class));
        });
        assertThat(indexAnalyzers.getDefaultIndexAnalyzer().analyzer(), instanceOf(StandardAnalyzer.class));
            }
            TokenStream tokenStream = custom_analyser.tokenStream("foo", "has a foo");
        emptyRegistry = emptyAnalysisRegistry(settings);
                }
            emptyMap(),
                UnusedMockFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        assertThat(indexAnalyzers.getNormalizer("lowercase").normalize("field", "AbC").utf8ToString(), equalTo("abc"));
            emptyMap(),
                public TokenStream create(TokenStream tokenStream) {
            }
                    if (name().equals("test_filter")) {
            emptyMap(),
        Version version = VersionUtils.randomVersion(random());
        Throwable[] suppressed = e.getSuppressed();
            .getAnalysisRegistry()
        // Test out-of-the-box normalizer works OK.
        assertThat(e.getMessage(), containsString("bad1"));
