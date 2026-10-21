    }
        AnalyzeAction.Request request2 = new AnalyzeAction.Request();
                }
        request.analyzer(null);
                + maxTokenCount
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                + "]."
        assertEquals("qu1ck", tokens.get(0).getTerm());
import org.opensearch.common.settings.Settings;
        // Apply the char filter, checking that the correct configuration gets passed on
        AnalyzeAction.Request request = new AnalyzeAction.Request().text("the quick brown fox");
            .build();
                Map<String, AnalysisProvider<TokenFilterFactory>> filters = new HashMap<>();
        request.text("the qu1ck brown fox");
        }
        request = new AnalyzeAction.Request();
        analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
        request.analyzer("custom_analyzer");
        assertEquals("brown", tokens.get(2).getTerm());
        assertEquals(0, tokens.get(0).getPosition());
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(threadContext);
        assertEquals(3, tokens.size());
        tokens = analyze.getTokens();
            "The number of tokens produced by calling _analyze has exceeded the allowed maximum of ["
/*
            assertEquals(e.getMessage(), "failed to find global filter under [foobar]");
        );
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(1, analyze.getTokens().size());
        assertEquals(2, tokens.get(2).getPosition());
 * this file be licensed under the Apache-2.0 license or a
        if (notGlobal) {
    }
        request.addTokenFilter("stop"); // stop token filter is not prebuilt in AnalysisModule#setupPreConfiguredTokenFilters()
                    )
        assertEquals("quick", tokens.get(0).getTerm());
        req.addTokenFilter("lowercase");
                    return new MockTokenFilter(tokenStream, this.stopset);
/*
            assertEquals(e.getMessage(), "failed to find global tokenizer under [foobar]");
        List<AnalyzeAction.AnalyzeToken> tokens = analyze.getTokens();
                    deprecationLogger.deprecate("deprecated_token_filter_create", "Using deprecated token filter [deprecated]");
                }
        assertEquals(e.getMessage(), "failed to find global analyzer [custom_analyzer]");
        IndexService is = mock(IndexService.class);
/**
        tokenFilterConfig.put("stopword", "brown");
        Environment environment = TestEnvironment.newEnvironment(settings);
                @Override
                new AnalyzeAction.Request().tokenizer("standard").addTokenFilter("foobar").text("the qu1ck brown fox"),
import java.io.Reader;
import org.opensearch.plugins.AnalysisPlugin;
        assertEquals(2, tokens.size());
            class DeprecatedTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
            indexNameExpressionResolver
            e2.getMessage(),
    public void setUp() throws Exception {
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
        }
                final CharacterRunAutomaton stopset;
            }
                + "]."
                }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.env.TestEnvironment;
/*
    }
                    this.suffix = settings.get("suffix", "bar");
        req.tokenizer("standard");
        assertEquals(
        assertEquals("foxfoo", tokens.get(3).getTerm());
                    return new AppendCharFilter(reader, suffix);
        charFilterConfig.put("suffix", "baz");
    @Override
        AnalyzeAction.Response analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.analysis.CharFilterFactory;
        request = new AnalyzeAction.Request();
        request.addTokenFilter(tokenFilterConfig);
                notGlobal ? mockIndexService() : null,
        assertEquals("brown", tokens.get(1).getTerm());
        maxTokenCount = IndexSettings.MAX_TOKEN_COUNT_SETTING.getDefault(settings);
        request.analyzer("standard");
            "The number of tokens produced by calling _analyze has exceeded the allowed maximum of ["
    /**
        for (int i = 0; i <= idxMaxTokenCount; i++) {
                    } else {
        assertEquals("<ALPHANUM>", tokens.get(0).getType());
            () -> TransportAnalyzeAction.analyze(
    public void testNormalizerWithIndex() throws IOException {
package org.opensearch.action.admin.indices;
                    .text("the qu1ck brown fox"),
                maxTokenCount
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
        // create a string with No. words more than idxMaxTokenCount
                        this.stopset = MockTokenFilter.ENGLISH_STOPSET;
        // Now try applying our token filter
import org.opensearch.common.UUIDs;
        assertEquals("quick", tokens.get(0).getTerm());
    /**
import org.opensearch.Version;
                notGlobal ? mockIndexService() : null,
        boolean notGlobal = randomBoolean();
        request2.explain(true);
        assertEquals("foxbaz", tokens.get(2).getTerm());
        AnalyzeAction.Request request = new AnalyzeAction.Request();
        AnalyzeAction.Response analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
        assertEquals("fox", tokens.get(2).getTerm());
                    .addCharFilter("foobar")
 * not use this file except in compliance with the License.
        // Refer to an analyzer by its type so we get its default configuration
                + " This limit can be set by changing the [index.analyze.max_token_count] index level setting."
        // We can build a new char filter to get default values
        AnalyzeAction.Request req = new AnalyzeAction.Request();
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                notGlobal ? mockIndexService() : null,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertEquals(
 * more exercise.
    }
        tokens = analyze.getTokens();
                        name,
        assertEquals("fox", tokens.get(2).getTerm());
    private IndexSettings indexSettings;
            @Override
                }
        assertEquals("fox", tokens.get(2).getTerm());
        } else {
        assertEquals("1", tokens.get(1).getTerm());
        // create a string with No. words more than maxTokenCount
        request.addCharFilter(charFilterConfig);
        e = expectThrows(
            @Override
                + maxTokenCount
                filters.put("mock", MockFactory::new);
        request.text(text);
            IllegalArgumentException.class,
     * Test behavior when the named analysis component isn't defined on the index. In that case we should build with defaults.
        Map<String, Object> tokenFilterConfig = new HashMap<>();
        StringBuilder sbText = new StringBuilder();
        assertWarnings("Using deprecated token filter [deprecated]");
        analyze = TransportAnalyzeAction.analyze(request, registry, null, maxTokenCount);
        assertEquals("brown", tokens.get(1).getTerm());
 * SPDX-License-Identifier: Apache-2.0
        request.tokenizer("standard");
        AnalyzeAction.Request request = new AnalyzeAction.Request();
            assertEquals(e.getMessage(), "failed to find filter under [foobar]");
        charFilterConfig.put("type", "append");
        assertEquals("the", tokens.get(0).getTerm());
                maxTokenCount
import java.util.Map;
            IllegalArgumentException.class,
        assertEquals(1, tokens.get(1).getPosition());
import org.apache.lucene.analysis.TokenStream;
    public void testResolveIndicesForIndex() {
        TransportAnalyzeAction action = new TransportAnalyzeAction(
        analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
        assertEquals(3, tokens.get(3).getPosition());
                maxTokenCount
            }
        // normalizer
 */
            TransportAnalyzeAction.analyze(req, registry, null, maxTokenCount);
        );
 */
        request.text("quick brown");
        e = expectThrows(
            @Override
            assertEquals(e.getMessage(), "failed to find tokenizer under [foobar]");
        AnalyzeAction.Response analyze = TransportAnalyzeAction.analyze(request, registry, null, maxTokenCount);
import org.opensearch.indices.IndicesService;
                }
    public void testUnknown() {
        TransportAnalyzeAction action = new TransportAnalyzeAction(
        idxMaxTokenCount = this.indexSettings.getMaxTokenCount();
        StringBuilder sbText = new StringBuilder();
        analyze = TransportAnalyzeAction.analyze(request, registry, null, maxTokenCount);
    }
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
import org.opensearch.cluster.ClusterName;
        req.addTokenFilter("deprecated");
                registry,
        );
import org.apache.lucene.tests.analysis.MockTokenizer;
        when(is.getIndexAnalyzers()).thenReturn(indexAnalyzers);
                maxTokenCount
    public void testGetIndexAnalyserWithoutIndexAnalyzers() {
        assertEquals("qu1ck", tokens.get(1).getTerm());
                DeprecatedTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
import org.apache.lucene.util.automaton.CharacterRunAutomaton;
        );
        charFilterConfig.put("suffix", "foo");
 * under the License.
            sbText.append('a');
    /**
        // Switch the analyzer out for just a tokenizer
                return filters;
                @Override
        assertEquals(e.getMessage(), "analysis based on a specific field requires an index");
        }
import org.opensearch.indices.analysis.AnalysisModule;
            )
                public TokenStream create(TokenStream tokenStream) {
        request = new AnalyzeAction.Request();
        assertEquals("quick", tokens.get(0).getTerm());
        tokens = analyze.getTokens();
            IllegalStateException.class,
                public TokenStream normalize(TokenStream tokenStream) {
        AnalyzeAction.Response analyze = TransportAnalyzeAction.analyze(request, registry, null, maxTokenCount);
import org.opensearch.index.analysis.AbstractCharFilterFactory;
        assertEquals("quick", tokens.get(1).getTerm());
import org.opensearch.index.analysis.TokenFilterFactory;
        tokens = analyze.getTokens();
        request.text("the 1 brown fox");
            IllegalArgumentException.class,
            sbText.append('a');
        assertEquals("fox", tokens.get(3).getTerm());
        );
        }
    public void testResolveIndicesForNoIndex() {
        assertEquals("<NUM>", tokens.get(1).getType());
        request.addTokenFilter("mock");     // <-- not preconfigured, but a global one available
        AnalysisPlugin plugin = new AnalysisPlugin() {
                + " This limit can be set by changing the [index.analyze.max_token_count] index level setting."
    private int idxMaxTokenCount;
                }
            indexNameExpressionResolver
        Map<String, Object> charFilterConfig = new HashMap<>();
import java.io.IOException;
        request.tokenizer("standard");
            mock(ActionFilters.class),
            IllegalArgumentException.class,
            IllegalArgumentException.class,
 */
        tokenFilterConfig.put("type", "mock");
    private IndexService mockIndexService() {
import java.util.List;
    }
import org.opensearch.index.analysis.AnalysisRegistry;
            assertEquals(e.getMessage(), "failed to find analyzer [foobar]");
import org.opensearch.index.analysis.IndexAnalyzers;
        // Apply a token filter with parameters
    public void testFillsAttributes() throws IOException {
        request.tokenizer("standard");
        assertEquals(5, tokens.get(1).getEndOffset());
        assertEquals(4, tokens.get(1).getStartOffset());
        assertEquals("qu1ck", tokens.get(1).getTerm());
        AnalyzeAction.Response analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
        request.analyzer("standard");
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            mock(ActionFilters.class),
            )
                new AnalyzeAction.Request().normalizer("foobar").text("the qu1ck brown fox"),
        IllegalArgumentException e = expectThrows(
        request.analyzer("standard");
        AnalyzeAction.Request request = new AnalyzeAction.Request();
        // this should be lowercased and only emit a single token
        assertEquals("the", tokens.get(0).getTerm());
        String text = sbText.toString();
            mock(IndicesService.class),
 * Tests for {@link TransportAnalyzeAction}. See the rest tests in the {@code analysis-common} module for places where this code gets a ton
        // We can refer to a pre-configured token filter by its name to get it
        assertEquals(3, tokens.size());
        assertEquals(0, tokens.get(0).getStartOffset());
            clusterService,
                new AnalyzeAction.Request().analyzer("custom_analyzer").text("the qu1ck brown fox-dog"),
        assertEquals(3, tokens.size());
                        () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
                final String suffix;
        request.addTokenFilter(tokenFilterConfig);
        e = expectThrows(
                new AnalyzeAction.Request().analyzer("foobar").text("the qu1ck brown fox"),
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
        AnalyzeAction.Response analyze = TransportAnalyzeAction.analyze(req, registry, mockIndexService(), maxTokenCount);
        assertEquals(3, tokens.size());
            .put(
import java.util.HashMap;
        assertEquals(e.getMessage(), "failed to find normalizer under [foobar]");
        assertEquals("fox", tokens.get(3).getTerm());
        if (notGlobal) {
        );
                    (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
        analyze = TransportAnalyzeAction.analyze(request, registry, null, maxTokenCount);
        assertEquals(ResolvedIndices.of(ResolvedIndices.Local.of("test_index")), action.resolveIndices(request));
        req.addTokenFilter("deprecated");
            () -> TransportAnalyzeAction.analyze(request2, registry, null, maxTokenCount)
    }
                registry,
        Metadata.Builder mdBuilder = Metadata.builder()
        AnalyzeAction.Request request = new AnalyzeAction.Request();
            );
            sbText.append(' ');
    }
        tokens = analyze.getTokens();
        assertEquals(4, tokens.size());
public class TransportAnalyzeActionTests extends OpenSearchTestCase {
    private AnalysisRegistry registry;
        request.tokenizer("standard");
        assertEquals("the", tokens.get(0).getTerm());
                    "keyword",
        if (notGlobal) {
        assertEquals("qu1ck", tokens.get(1).getTerm());
    }
                    super(indexSettings, name);
        request.text("the qu1ck brown fox");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.ClusterState;
            .put("index.analysis.char_filter.my_append.suffix", "baz")
        assertEquals("foxbar", tokens.get(2).getTerm());
import org.opensearch.cluster.service.ClusterService;
                    }
                public TokenStream create(TokenStream tokenStream) {
                registry,
        req.text("text");
import org.apache.lucene.util.automaton.Automata;
            .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase")
 * The OpenSearch Contributors require contributions made to
 * GitHub history for details.
        super.setUp();
    public void testExceedDefaultMaxTokenLimit() {
                return singletonList(PreConfiguredCharFilter.singleton("append", false, reader -> new AppendCharFilter(reader, "foo")));
    public void testExceedSetMaxTokenLimit() {
        when(clusterService.state()).thenReturn(clusterState);
        registry = new AnalysisModule(environment, singletonList(plugin)).getAnalysisRegistry();
            class AppendCharFilterFactory extends AbstractCharFilterFactory {
 * specific language governing permissions and limitations
    public void testNonPreBuildTokenFilter() throws IOException {
        charFilterConfig.put("type", "append");
        if (notGlobal) {
            "The number of tokens produced by calling _analyze has exceeded the allowed maximum of ["
                registry,
        assertEquals(3, tokens.size());
 * the Apache License, Version 2.0 (the "License"); you may
            e.getMessage(),
                return singletonMap("append", AppendCharFilterFactory::new);
                return singletonMap(
        } else {
        analyze = TransportAnalyzeAction.analyze(req, registry, mockIndexService(), maxTokenCount);
import org.opensearch.index.IndexSettings;
                null,
    public void testDeprecationWarnings() throws IOException {
import org.opensearch.transport.TransportService;
            .put("index.analysis.analyzer.custom_analyzer.tokenizer", "standard")
            e.getMessage(),
        assertEquals("quick", tokens.get(1).getTerm());
        this.indexSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
            public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
        request.tokenizer("standard");
     * The index specific value for the maximum token count is used.
            }
 * You may obtain a copy of the License at
                new AnalyzeAction.Request().tokenizer("standard")
                maxTokenCount
        List<AnalyzeAction.AnalyzeToken> tokens = analyze.getTokens();
        assertEquals("wi-fi", tokens.get(0).getTerm());
import static org.mockito.Mockito.when;
        request2.analyzer("standard");
        AnalyzeAction.Request request = new AnalyzeAction.Request("index");
        assertEquals(4, tokens.size());
        assertEquals("quick", tokens.get(0).getTerm());
                    .settings(
                }
        assertEquals("fox", tokens.get(3).getTerm());
    }
        request.addCharFilter(charFilterConfig);    // <-- basic config, uses defaults
                registry,
            assertEquals(e.getMessage(), "failed to find global analyzer [foobar]");
                    if (settings.hasValue("stopword")) {
                    .addTokenFilter("lowercase")
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            mock(ThreadPool.class),
import org.opensearch.common.util.concurrent.ThreadContext;
            class MockFactory extends AbstractTokenFilterFactory {
        assertEquals(4, tokens.size());
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
        tokens = analyze.getTokens();
        request.addTokenFilter("mock");
                filters.put("deprecated", DeprecatedTokenFilterFactory::new);
 * software distributed under the License is distributed on an
        request.normalizer("my_normalizer");
        assertEquals("foxbaz", tokens.get(2).getTerm());
        assertEquals("quick", tokens.get(0).getTerm());
        AnalyzeAction.Response analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
import org.opensearch.env.Environment;
        request.analyzer("standard");
            public List<PreConfiguredCharFilter> getPreConfiguredCharFilters() {
        );
                + idxMaxTokenCount
        assertEquals(ResolvedIndices.of(ResolvedIndices.Local.of()), action.resolveIndices(request));
        });
        return is;
                    deprecationLogger.deprecate("deprecated_token_filter_normalize", "Using deprecated token filter [deprecated]");
        for (int i = 0; i <= maxTokenCount; i++) {
        assertEquals("foxbaz", tokens.get(1).getTerm());
            )
 *
                @Override
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
        analyze = TransportAnalyzeAction.analyze(request, registry, null, maxTokenCount);
import org.opensearch.index.analysis.TokenizerFactory;
        request2.text(text);
            }
                @Override
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(threadContext);
            IllegalStateException.class,
        assertEquals(12, tokens.get(3).getStartOffset());
import org.opensearch.threadpool.ThreadPool;
    public void testWithIndexAnalyzers() throws IOException {
     * The default value for the maximum token count is used.
        assertEquals(3, tokens.size());
        }
        assertEquals("the", tokens.get(0).getTerm());
        assertEquals("<ALPHANUM>", tokens.get(3).getType());
}
import org.opensearch.index.analysis.PreConfiguredCharFilter;
import org.opensearch.cluster.metadata.Metadata;
            () -> TransportAnalyzeAction.analyze(request, registry, null, idxMaxTokenCount)
        analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
        indexAnalyzers = registry.build(this.indexSettings);
    }
            )
        request.text("the quick brown fox");
        );
     * This test is equivalent of calling _analyze against a specific index.
        ClusterService clusterService = mock(ClusterService.class);
        analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
        }
        assertEquals("<ALPHANUM>", tokens.get(2).getType());
            .put("index.analysis.normalizer.my_normalizer.type", "custom")
        assertEquals(11, tokens.get(2).getEndOffset());
                public Reader create(Reader reader) {
            () -> TransportAnalyzeAction.analyze(
        // request with explain=false to test simpleAnalyze path in TransportAnalyzeAction
        assertEquals(4, tokens.size());
        assertEquals("the", tokens.get(0).getTerm());
        AnalyzeAction.Request request = new AnalyzeAction.Request();
     */
            )
            }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                mockIndexService(),
        request.analyzer("standard");
import org.opensearch.action.admin.indices.analyze.TransportAnalyzeAction;
        AnalyzeAction.Request req = new AnalyzeAction.Request().field("field").text("text");
        request.text("Wi-fi");
                AppendCharFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        AnalyzeAction.Request request = new AnalyzeAction.Request();
            public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        request.addCharFilter("append");        // <-- no config, so use preconfigured filter
        request.addCharFilter(charFilterConfig);
        assertEquals("brown", tokens.get(1).getTerm());
        String text = sbText.toString();
            () -> TransportAnalyzeAction.analyze(
            () -> TransportAnalyzeAction.analyze(
        request.text("the qu1ck brown fox");
        List<AnalyzeAction.AnalyzeToken> tokens = analyze.getTokens();
        request.tokenizer("standard");
        } else {
import org.apache.lucene.tests.analysis.MockTokenFilter;
        IllegalStateException e = expectThrows(
        assertEquals(
import static java.util.Collections.singletonMap;
        when(is.getIndexSettings()).thenReturn(indexSettings);
        tokenFilterConfig.put("stopword", "brown");
        } else {
 * Modifications Copyright OpenSearch Contributors. See
        request.addTokenFilter(tokenFilterConfig);
    private int maxTokenCount;
        Map<String, Object> tokenFilterConfig = new HashMap<>();
        request = new AnalyzeAction.Request();
            assertEquals(e.getMessage(), "failed to find global char_filter under [foobar]");
        Settings indexSettings = Settings.builder()
            IllegalArgumentException.class,
                    super(indexSettings, name, settings);
                    super(indexSettings, name, settings);
            }
                notGlobal ? mockIndexService() : null,
    public void testCustomCharFilterWithParameters() throws IOException {
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.ResolvedIndices;
        assertEquals("the", tokens.get(0).getTerm());
        assertEquals("fox", tokens.get(2).getTerm());
        assertEquals(1, tokens.size());
            .put("index.analysis.char_filter.my_append.type", "append")
        assertEquals(15, tokens.get(3).getEndOffset());
 *
        req.text("test text");
                maxTokenCount
    public void testNoIndexAnalyzers() throws IOException {
        tokens = analyze.getTokens();
            }
        req = new AnalyzeAction.Request();
        };
        AnalyzeAction.Request request = new AnalyzeAction.Request("test_index").text("the quick brown fox");
        IllegalStateException e2 = expectThrows(
                registry,
        assertEquals(6, tokens.get(2).getStartOffset());
        );
                    )
        );
import org.opensearch.test.IndexSettingsModule;
                IndexMetadata.builder("test_index")
        // request with explain=true to test detailAnalyze path in TransportAnalyzeAction
import org.opensearch.action.support.ActionFilters;
        assertEquals("brown", tokens.get(1).getTerm());
import static org.mockito.Mockito.mock;
                + "]."
        List<AnalyzeAction.AnalyzeToken> tokens = analyze.getTokens();
                    return tokenStream;
 */
            () -> TransportAnalyzeAction.analyze(request, registry, null, maxTokenCount)
                MockFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
                    return tokenStream;
import org.opensearch.indices.analysis.AnalysisModuleTests.AppendCharFilter;
 * this work for additional information regarding copyright
     * This test is equivalent of calling _analyze without a specific index.
        assertEquals(4, tokens.size());
        e = expectThrows(
        assertEquals("brown", tokens.get(2).getTerm());
        List<AnalyzeAction.AnalyzeToken> tokens = analyze.getTokens();
            public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        assertEquals("brown", tokens.get(2).getTerm());
            sbText.append(' ');
            Settings.EMPTY,
        tokens = analyze.getTokens();
        assertEquals(3, tokens.size());
            .put("index.analyze.max_token_count", 100)
        List<AnalyzeAction.AnalyzeToken> tokens = analyze.getTokens();
        tokenFilterConfig.put("type", "mock");
        assertEquals("brown", tokens.get(1).getTerm());
            mock(TransportService.class),
            () -> TransportAnalyzeAction.analyze(
        request.tokenizer("standard");
            .put("index.analysis.analyzer.custom_analyzer.filter", "mock")
     */
                        this.stopset = new CharacterRunAutomaton(Automata.makeString(settings.get("stopword")));
 *
 * Unless required by applicable law or agreed to in writing,
        );
import static java.util.Collections.singletonList;
    }
        tokens = analyze.getTokens();
        assertEquals("quick", tokens.get(0).getTerm());
        IllegalStateException e = expectThrows(
        assertEquals(2, tokens.size());
            IllegalStateException.class,
        assertEquals("brown", tokens.get(2).getTerm());
            mock(TransportService.class),
        req.addTokenFilter("lowercase");
import org.opensearch.index.IndexService;
        );
        request.addCharFilter("my_append");
        );
    }
     */
        request.text("the qu1ck brown fox");
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
        analyze = TransportAnalyzeAction.analyze(request, registry, mockIndexService(), maxTokenCount);
        Map<String, Object> charFilterConfig = new HashMap<>();
    private IndexAnalyzers indexAnalyzers;
            () -> TransportAnalyzeAction.analyze(
        // If the preconfigured filter doesn't exist, we use a global filter with no settings
        AnalyzeAction.Request request = new AnalyzeAction.Request();
            Settings.EMPTY,
                );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testGetFieldAnalyzerWithoutIndexAnalyzers() {
            mock(ClusterService.class),
    }
    }
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            mock(ThreadPool.class),
        request.text("the quick brown fox");
        );
                new AnalyzeAction.Request().tokenizer("foobar").text("the qu1ck brown fox"),
        request.text(text);
        assertEquals(3, tokens.get(0).getEndOffset());
        // We can pass a new configuration
            )
        assertEquals("brownfoo", tokens.get(1).getTerm());
        IllegalArgumentException e = expectThrows(
        assertEquals(2, analyze.getTokens().size());
            assertEquals(e.getMessage(), "failed to find char_filter under [foobar]");
            mock(IndicesService.class),
        request.text("the quick brown fox");
            @Override
                + " This limit can be set by changing the [index.analyze.max_token_count] index level setting."
