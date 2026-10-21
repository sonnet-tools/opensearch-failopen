        Map<String, Highlighter> highlighters = module.getHighlighters();
/*
        @Override
        protected TestAggregationBuilder(TestAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
                });
            return null;
            @Override
            String name,
            module.getNamedWriteables()
        };
        protected void doWriteTo(StreamOutput out) throws IOException {}
        "combined_fields",
                .stream()
import java.util.List;
        );
                .stream()
        SearchPlugin registersDupeAggregation = new SearchPlugin() {
import org.opensearch.search.aggregations.ConcurrentAggregationProcessor;
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
import org.opensearch.search.rescore.QueryRescorerBuilder;
import org.opensearch.plugins.SearchPlugin;
        SearchPlugin plugin2 = new SearchPlugin() {
                    @Override
        expectThrows(IllegalStateException.class, () -> new SearchModule(Settings.EMPTY, searchPlugins));
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
    public void testRegisterRescorer() {
        }
                )
        searchModule.getIndexSearcherExecutor(threadPool);
        "span_or",
                );
        public static final String SUGGESTION_NAME = "test";
     * Dummy test {@link PipelineAggregator} used to test registering aggregation builders.
        public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {
        searchPlugins.add(plugin1);
            @Override
import org.opensearch.search.suggest.term.TermSuggestion;
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeSuggester));
        );
    public void testDoubleRegister() {
 */
        @Override
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
import java.util.Collections;
import org.opensearch.search.aggregations.support.ValuesSourceType;
    }
                );
                return singletonList(new QuerySpec<>(TermQueryBuilder.NAME, TermQueryBuilder::new, TermQueryBuilder::fromXContent));
        TestSuggestionBuilder(StreamInput in) throws IOException {
        @Override
        protected SuggestionSearchContext.SuggestionContext build(QueryShardContext context) throws IOException {
        public RescoreContext innerBuildContext(int windowSize, QueryShardContext context) throws IOException {
            }
    private static class TestPipelineAggregator extends PipelineAggregator {
                return singletonList(
            public Optional<ProfileMetricsProvider> getQueryProfileMetricsProvider() {
        public String getType() {
        assertEquals(
                        && entry.name.match("test", LoggingDeprecationHandler.INSTANCE)
                )
        }));
    public void testRegisterPipelineAggregation() {
                return singletonList(new ExplainPhase());
        protected void doWriteTo(StreamOutput out) throws IOException {}
            @Override
        );
    public void testMultiplePluginRegisterIndexSearcherProvider() {
        protected Suggestion<? extends Suggestion.Entry<? extends Suggestion.Entry.Option>> innerExecute(
        "regexp",
import org.opensearch.search.aggregations.pipeline.InternalDerivative;
            @Override
    }
            String name,
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.singletonList(plugin1));
import org.opensearch.index.query.QueryShardContext;
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    }
            @Override
                .stream()
        "match",
        assertEquals(providers.getFirst().getQueryProfileMetrics(null, null).size(), 1);
        searchPlugins.add(plugin1);
            return null;
        }));
import static org.hamcrest.Matchers.hasSize;
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("phrase", LoggingDeprecationHandler.INSTANCE))
            return null;
        assertEquals(PlainHighlighter.class, highlighters.get("plain").getClass());
        @Override
 */
            @Override
                .count()
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
                .filter(
            return null;
 * license agreements. See the NOTICE file distributed with
        "constant_score",
        @Override
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        assertThat(providers, hasSize(1));
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
    }
        SearchPlugin registersDupeRescorer = new SearchPlugin() {
import org.opensearch.search.suggest.SuggestionBuilder;
        assertTrue(queryPhaseSearcher.aggregationProcessor(searchContext) instanceof DefaultAggregationProcessor);
        "span_field_masking",
            return CoreValuesSourceType.BYTES;
    public void testDefaultQueryPhaseSearcher() {
            super(in);
import org.apache.lucene.search.IndexSearcher;
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("term"))
                    new ScoreFunctionSpec<>(
            @Override
        assertEquals(searchModule.getConcurrentSearchRequestDeciderFactories().size(), 0);
            public Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {
                );
import org.opensearch.test.OpenSearchTestCase;
                return Optional.of((searchContext, query) -> List.of(() -> new Timer("plugin_timer")));
    /**
            return BucketCardinality.NONE;
     */
        );
        assertEquals(FastVectorHighlighter.class, highlighters.get("fvh").getClass());
        searchPlugins.add(pluginDecider2);
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder;
        );
    }
 * ownership. Elasticsearch licenses this file to you under
            1,
        public static TestRescorerBuilder fromXContent(XContentParser parser) {
import org.opensearch.search.profile.Timer;
        }
            }
        @Override
        SearchPlugin registersDupeFetchSubPhase = new SearchPlugin() {
    }
            .stream()
            @Override
    }
        "intervals",
        }
        };
        "boosting",
import org.opensearch.search.suggest.SuggestionSearchContext;
    /**
                    )
import static org.hamcrest.Matchers.containsInAnyOrder;
            }
            }
        SearchPlugin registersDupeHighlighter = new SearchPlugin() {
        SearchPlugin registersDupeSuggester = new SearchPlugin() {
            public List<SearchPlugin.QuerySpec<?>> getQueries() {
        assertEquals(UnifiedHighlighter.class, highlighters.get("unified").getClass());
 *
            @Override
    private static class TestSuggestionBuilder extends SuggestionBuilder<TestSuggestionBuilder> {
        }
        "distance_feature",
                        TestSuggestionBuilder.SUGGESTION_NAME,
import org.opensearch.search.aggregations.InternalAggregation;
            AggregatorFactory parent,
        "span_gap",
        "script_score",
                .count()
            @Override
    }
            }
        TestSearchContext searchContext = new TestSearchContext(null);
                        TermSuggestionBuilder.SUGGESTION_NAME,
         */
            QueryShardContext queryShardContext,
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("completion"))
                .filter(
    private static class TestRescorerBuilder extends RescorerBuilder<TestRescorerBuilder> {
            return null;
            .flatMap(e -> Arrays.stream(e.name.getAllNamesIncludedDeprecated()))
        );
                return Optional.of(new ConcurrentQueryPhaseSearcher());
        }));
            return null;
         * Read from a stream.
import org.opensearch.core.xcontent.NamedXContentRegistry;
            return false;
                        && entry.name.match("test", LoggingDeprecationHandler.INSTANCE)
        }
            }
        assertThat(
        return () -> new NamedXContentRegistry(new SearchModule(Settings.EMPTY, singletonList(plugin)).getNamedXContents());
        assertEquals(
import java.io.IOException;
        "match_none",
            @Override
import org.opensearch.search.suggest.Suggest.Suggestion;
            module.getNamedXContents()
        searchPlugins.add(plugin2);
        Collections.addAll(allSupportedQueries, NON_DEPRECATED_QUERIES);
            }
        SearchPlugin plugin1 = new SearchPlugin() {
        QueryPhase queryPhase = searchModule.getQueryPhase();
            }
            @Override
                .count()
import static java.util.Collections.singletonList;
                return Optional.of(mock(ExecutorServiceProvider.class));
    }
    public void testConcurrentQueryPhaseSearcher() {
        ) throws IOException {
            }
import static org.mockito.Mockito.verify;
        "multi_match",
        }
            }
    }
        "span_not",
        SearchPlugin registersDupeQuery = new SearchPlugin() {
            module.getNamedWriteables()
        };
        TestSearchContext searchContext = new TestSearchContext(null);
        }
        protected ValuesSourceAggregatorFactory innerBuild(
        protected Entry newEntry(StreamInput in) throws IOException {
        };
import org.opensearch.threadpool.ThreadPool;
            public List<SearchPlugin.SuggesterSpec<?>> getSuggesters() {
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
                .filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("completion"))
 * the Apache License, Version 2.0 (the "License"); you may
        SearchModule searchModule = new SearchModule(Settings.EMPTY, searchPlugins);
    public void testIndexSearcher() {
        "match_phrase_prefix",
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("test"))
            }
        }
        SearchPlugin registersDupeMovAvgModel = new SearchPlugin() {
            super(in);
 * specific language governing permissions and limitations
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("term", LoggingDeprecationHandler.INSTANCE))
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        );
    }
            super("test", new String[] {}, null);
            hasSize(1)
import org.opensearch.index.query.QueryBuilder;
        }
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        "geo_bounding_box",
                );
        );
                    ).addResultReader(InternalDerivative::new)
        "dis_max",
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
                        GaussDecayFunctionBuilder::new,
            public Optional<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactory() {
            public List<SignificanceHeuristicSpec<?>> getSignificanceHeuristics() {
/*
        TestRescorerBuilder(StreamInput in) throws IOException {
        assertEquals(
        assertTrue(queryPhase.getQueryPhaseSearcher() instanceof QueryPhaseSearcherWrapper);
            1,
                    new SuggesterSpec<>(
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeScoreFunction));
        protected Suggestion<? extends Entry<? extends Option>> emptySuggestion(
            .filter(e -> e.name.getAllReplacedWith() == null)
        };
        "match_all",
                    entry -> entry.categoryClass.equals(RescorerBuilder.class)
            .filter(e -> e.categoryClass.equals(QueryBuilder.class))
    public void testRegisterSuggester() {
            @Override
import org.opensearch.search.fetch.subphase.highlight.PlainHighlighter;
            return null;
            return null;
                .collect(toList()),
        assertThat(registeredNonDeprecated, containsInAnyOrder(NON_DEPRECATED_QUERIES));
        };
        List<SearchPlugin> searchPlugins = new ArrayList<>();
            public Map<String, Highlighter> getHighlighters() {
        protected int doHashCode() {
    public void testPluginQueryPhaseSearcher() {
        "bool",
    public void testMultiplePluginRegisterQueryPhaseSearcher() {
                .stream()
                .count()
    private static final String[] DEPRECATED_QUERIES = new String[] { "common", "field_masking_span" };
import static java.util.stream.Collectors.toSet;
            SuggestionSearchContext.SuggestionContext suggestion,
        );
 * Unless required by applicable law or agreed to in writing,
            module.getNamedWriteables()
 *
        assertEquals(
        );
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
        public static TestSuggestionBuilder fromXContent(XContentParser parser) {
            return ValuesSourceRegistry.UNREGISTERED_KEY;
        List<SearchPlugin> searchPlugins = new ArrayList<>();
        "simple_query_string",
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeHighlighter));
            }
            return "test";
        "span_within",
                return singletonList(new SearchExtensionSpec<>(SimpleModel.NAME, SimpleModel::new, SimpleModel.PARSER));
            hasSize(1)
        SearchModule searchModule = new SearchModule(Settings.EMPTY, searchPlugins);
import org.opensearch.search.aggregations.pipeline.AbstractPipelineAggregationBuilder;
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("test", LoggingDeprecationHandler.INSTANCE))
        @Override
                .collect(toList()),
        @Override
        protected PipelineAggregator createInternal(Map<String, Object> metadata) {
        searchPlugins.add(plugin2);
    }
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeQuery));
            @Override
    }
        ThreadPool threadPool = mock(ThreadPool.class);
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeFetchSubPhase));
    private static class TestPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<TestPipelineAggregationBuilder> {
                        GaussDecayFunctionBuilder.PARSER
            1,
            @Override
            @Override
        Set<String> registeredAll = module.getNamedXContents()
        }
    /**
        public String getWriteableName() {
    public void testRegisterConcurrentSearchRequestDecidersNoExternalPlugins() {
            module.getNamedWriteables()
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            CharsRefBuilder spare
        @Override
                return Optional.of(mock(ExecutorServiceProvider.class));
        }
        QueryPhaseSearcher queryPhaseSearcher = (searchContext, searcher, query, collectors, hasFilterCollector, hasTimeout) -> false;
        "nested",
            Builder subFactoriesBuilder
            }
        };
            }
        };
            super(in);
            public Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {
import java.util.Optional;
        public BucketCardinality bucketCardinality() {
                .stream()
                return Optional.of(new ConcurrentSearchRequestDecider.Factory() {
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupePipelineAggregation));
import static java.util.stream.Collectors.toList;
                return Optional.of(mock(ExecutorServiceProvider.class));
    }
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
                .count()
import org.opensearch.search.fetch.subphase.ExplainPhase;
        }
import org.opensearch.search.aggregations.AggregatorFactory;
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
    public void testProfileMetricsProvider() {
        "exists",
        "wrapper",
    }
            1,
        @Override
                )
        "geo_distance",
        @Override
        List<SearchPlugin.ProfileMetricsProvider> providers = module.getPluginProfileMetricsProviders();
        "query_string",
        SearchModule module = new SearchModule(Settings.EMPTY, emptyList());
            }
import static java.util.Collections.singletonMap;
        };
     * Dummy test {@link AggregationBuilder} used to test registering aggregation builders.
            @Override
        searchContext.setConcurrentSegmentSearchEnabled(true);
        "range",
        @Override
            return "test";
                        DerivativePipelineAggregationBuilder.NAME,
        private static TestPipelineAggregationBuilder fromXContent(String name, XContentParser p) {
import org.opensearch.search.fetch.subphase.highlight.UnifiedHighlighter;
                    @Override
 * The OpenSearch Contributors require contributions made to
                    public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
        }
        };
            public List<RescorerSpec<?>> getRescorers() {
            module.getNamedXContents()
        SearchPlugin plugin1 = new SearchPlugin() {
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeAggregation));
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeMovAvgModel));
        protected void doXContent(XContentBuilder builder, Params params) throws IOException {}
                        TermSuggestionBuilder::new,
        protected void innerWriteTo(StreamOutput out) throws IOException {}
        "span_term",
        };
 * compatible open source license.
        }
        expectThrows(IllegalStateException.class, () -> new SearchModule(Settings.EMPTY, searchPlugins));
                return singletonList(new AggregationSpec("test", TestAggregationBuilder::new, TestAggregationBuilder::fromXContent));
        assertEquals(searchModule.getConcurrentSearchRequestDeciderFactories().size(), 0);
        @Override
            return this;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
import org.opensearch.search.rescore.RescoreContext;
    }
            return new TestAggregationBuilder(this, factoriesBuilder, metadata);
    }
                        TermSuggestionBuilder::fromXContent,
        List<String> allSupportedQueries = new ArrayList<>();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        @Override
import java.util.Arrays;
            module.getNamedXContents()
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
            super(clone, factoriesBuilder, metadata);
    private static final String[] NON_DEPRECATED_QUERIES = new String[] {
        "match_bool_prefix",
        @Override
        public String getWriteableName() {
        assertEquals(
        List<SearchPlugin> searchPlugins = new ArrayList<>();
        }
    }
        };
        assertThat(
        @Override
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
            return null;
            1,
        }));
                    new AggregationSpec(TermsAggregationBuilder.NAME, TermsAggregationBuilder::new, TermsAggregationBuilder.PARSER)
        }
                );
        SearchPlugin registersDupeScoreFunction = new SearchPlugin() {
import org.opensearch.search.fetch.subphase.highlight.CustomHighlighter;
import static java.util.Collections.emptyList;
            return "test";
            public List<PipelineAggregationSpec> getPipelineAggregations() {
            super(in);
            @Override
        "prefix",
            return null;
            }
    }
        @Override
        protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.index.query.QueryRewriteContext;
            .collect(toSet());
                return singletonList(
        assertEquals(searchModule.getConcurrentSearchRequestDeciderFactories().size(), 2);
 * under the License.
            return null;
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeRescorer));
        @Override
            module.getNamedXContents()
            1,
        protected TestAggregationBuilder(StreamInput in) throws IOException {
            }
 * You may obtain a copy of the License at
import org.opensearch.search.aggregations.pipeline.SimpleModel;
        searchPlugins.add(plugin1);
 * Modifications Copyright OpenSearch Contributors. See
        public String getWriteableName() {
        }
        assertEquals(
                .stream()
        SearchPlugin plugin2 = new SearchPlugin() {
                    new PipelineAggregationSpec("test", TestPipelineAggregationBuilder::new, TestPipelineAggregationBuilder::fromXContent)
import org.opensearch.search.query.ConcurrentQueryPhaseSearcher;
                    new SuggesterSpec<>(
        TestSuggestion(StreamInput in) throws IOException {
            1,
            return "test";
        }
        @Override
 * SPDX-License-Identifier: Apache-2.0
                        TestSuggestion::new
                .collect(toList()),
     * Dummy test {@link PipelineAggregator} used to test registering aggregation builders.
import org.opensearch.search.fetch.subphase.highlight.FastVectorHighlighter;
        assertSame(highlighters.get("custom"), customHighlighter);
        @Override
import org.apache.lucene.util.CharsRefBuilder;
        assertEquals(
import org.opensearch.common.settings.Settings;
                .count()
                .stream()
                        return Optional.of(mock(ConcurrentSearchRequestDecider.class));
        @Override
        }
        }
        protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
        ) throws IOException {
        }
            module.getNamedXContents()
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("phrase"))
                    )
                        GaussDecayFunctionBuilder.NAME,
        SearchPlugin registersDupePipelineAggregation = new SearchPlugin() {
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
        );
    }
        QueryPhase queryPhase = searchModule.getQueryPhase();
        "ids",
        SearchPlugin plugin2 = new SearchPlugin() {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        }
            }
import java.util.Set;
            module.getNamedWriteables().stream().filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("phrase")).count()
                    }
 * GitHub history for details.
        assertThat(
                    entry -> entry.categoryClass.equals(BaseAggregationBuilder.class)
                return Optional.of(queryPhaseSearcher);
import org.opensearch.search.query.QueryPhase;
/*
        };
        "span_containing",
            IndexSearcher searcher,
            .collect(toSet());
        };
                return Optional.of(mock(ExecutorServiceProvider.class));
            module.getNamedXContents()
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.ArrayList;
        "span_multi",
        protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
 * this file be licensed under the Apache-2.0 license or a
        protected void validate(ValidationContext context) {}
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
        assertEquals(
import org.opensearch.search.aggregations.DefaultAggregationProcessor;
                .filter(
import org.opensearch.search.rescore.RescorerBuilder;
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
            return null;
        }
                });
        "more_like_this",
import org.opensearch.index.IndexSettings;
        protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
                    }
        @Override
    public void testRegisterHighlighter() {
    public void testRegisterAggregation() {
import org.opensearch.search.aggregations.pipeline.MovAvgModel;
                return singletonMap("plain", new PlainHighlighter());
    }
        SearchPlugin plugin1 = new SearchPlugin() {
            hasSize(1)
            1,
        @Override
                return Optional.of(mock(QueryPhaseSearcher.class));
        "geo_polygon",
        );
                    new PipelineAggregationSpec(
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;
        "match_phrase",
            .map(e -> e.name.getPreferredName())
        @Override
        SearchPlugin pluginDecider1 = new SearchPlugin() {
        @Override
    }
 * this work for additional information regarding copyright
        };
        assertTrue(queryPhase.getQueryPhaseSearcher().aggregationProcessor(searchContext) instanceof ConcurrentAggregationProcessor);
        protected ValuesSourceType defaultValueSourceType() {
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.index.query.TermQueryBuilder;
            }
                .stream()
            @Override
    // add here deprecated queries to make sure we log a deprecation warnings when they are used
        };
        protected void doWriteTo(StreamOutput out) throws IOException {}
                .filter(
        SearchPlugin pluginDecider2 = new SearchPlugin() {
        protected boolean doEquals(TestSuggestionBuilder other) {
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeSignificanceHeuristic));
         * Read from a stream.
            SuggestionContext suggestion,
            public List<SearchExtensionSpec<MovAvgModel, MovAvgModel.AbstractModelParser>> getMovingAverageModels() {
    private static class TestAggregationBuilder extends ValuesSourceAggregationBuilder<TestAggregationBuilder> {
        "span_first",
        );
                return singletonList(
        TestSearchContext searchContext = new TestSearchContext(null);
        }
            }
        searchPlugins.add(plugin2);
                    entry -> entry.categoryClass.equals(BaseAggregationBuilder.class)
        }));
                .stream()
        TestPipelineAggregationBuilder(StreamInput in) throws IOException {
        @Override
            public List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
        }));
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
            @Override
                .stream()
                return singletonList(
                return singletonList(
    public void testRegisterConcurrentSearchRequestDecidersExternalPluginsWithNoDeciders() {
                        DerivativePipelineAggregationBuilder::parse
import org.opensearch.search.suggest.Suggester;
        /**
                        TestSuggestionBuilder::fromXContent,
            public List<RescorerSpec<?>> getRescorers() {
                .stream()
            }
import org.opensearch.search.fetch.FetchSubPhase;
            }
            public List<AggregationSpec> getAggregations() {
            @Override
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 * not use this file except in compliance with the License.
        assertEquals(queryPhaseSearcher, queryPhase.getQueryPhaseSearcher());
        "term",
                .count()
        @Override
        "geo_shape",
            1,
                    public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
            1,
                return Optional.of(new ConcurrentSearchRequestDecider.Factory() {
            module.getNamedWriteables().stream().filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("term")).count()
        CustomHighlighter customHighlighter = new CustomHighlighter();
            1,
}
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
        assertThat(registeredAll, containsInAnyOrder(allSupportedQueries.toArray(new String[0])));
        }
        "span_near",
                .stream()
        assertTrue(queryPhase.getQueryPhaseSearcher() instanceof QueryPhaseSearcherWrapper);
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.BaseAggregationBuilder;
            module.getNamedXContents()
            return null;
            module.getNamedWriteables()
        "terms",
        }
            public List<AggregationSpec> getAggregations() {
        "fuzzy",
                    )
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
        };
 * Licensed to Elasticsearch under one or more contributor
                );
    private static class TestSuggestion extends Suggestion {
    public void testRegisteredQueries() {
        assertEquals(
                        return Optional.of(mock(ConcurrentSearchRequestDecider.class));
        SearchPlugin registersDupeSignificanceHeuristic = new SearchPlugin() {
         */
            return null;
 *
import org.opensearch.test.TestSearchContext;
            super(in, "test");
    }
                .count()
            }
        TestPipelineAggregator() {
                return singletonList(
import static org.mockito.Mockito.mock;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
            @Override
        assertEquals(
    private static class TestSuggester extends Suggester<SuggestionSearchContext.SuggestionContext> {
import org.opensearch.core.common.io.stream.StreamInput;
        ) throws IOException {
        );
        };
            }
        verify(threadPool).executor(ThreadPool.Names.INDEX_SEARCHER);
 * KIND, either express or implied.  See the License for the
                        DerivativePipelineAggregationBuilder::new,
            public List<SuggesterSpec<?>> getSuggesters() {
        "script",
        }
        "wildcard",
        }
            return null;
        Set<String> registeredNonDeprecated = module.getNamedXContents()
            return 0;
    }
        "terms_set",
            public Optional<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactory() {
        SearchPlugin plugin1 = new SearchPlugin() {
            }
public class SearchModuleTests extends OpenSearchTestCase {
            .stream()
        );
package org.opensearch.search;
            public Map<String, Highlighter> getHighlighters() {
            @Override
        "template" };
            public Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {
        "function_score",
            CharsRefBuilder spare
                .count()
                        TestSuggestionBuilder::new,
        private static TestAggregationBuilder fromXContent(String name, XContentParser p) {
        public RescorerBuilder<TestRescorerBuilder> rewrite(QueryRewriteContext ctx) throws IOException {
        QueryPhase queryPhase = searchModule.getQueryPhase();
        }
     */
            module.getNamedWriteables().stream().filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("test")).count()
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
                    new RescorerSpec<>(QueryRescorerBuilder.NAME, QueryRescorerBuilder::new, QueryRescorerBuilder::fromXContent)
        }
        assertTrue(queryPhase.getQueryPhaseSearcher().aggregationProcessor(searchContext) instanceof DefaultAggregationProcessor);
            public List<ScoreFunctionSpec<?>> getScoreFunctions() {
        /**
                )
import org.opensearch.search.query.QueryPhaseSearcher;
                return singletonList(new RescorerSpec<>("test", TestRescorerBuilder::new, TestRescorerBuilder::fromXContent));
            .filter(e -> e.categoryClass.equals(QueryBuilder.class))
                        TermSuggestion::new
        List<SearchPlugin> searchPlugins = new ArrayList<>();
            public List<PipelineAggregationSpec> getPipelineAggregations() {
        assertEquals(
        }
        assertEquals(
     */
                return singletonMap("custom", customHighlighter);
        public String getWriteableName() {
    public void testRegisterConcurrentSearchRequestDecidersExternalPluginsWithDeciders() {
        @Override
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
            1,
        }
        }
            ValuesSourceConfig config,
import java.util.Map;
        searchPlugins.add(pluginDecider1);
    private ThrowingRunnable registryForPlugin(SearchPlugin plugin) {
            return "test";
                );
                        && entry.name.match("test", LoggingDeprecationHandler.INSTANCE)
 */
                    e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("completion", LoggingDeprecationHandler.INSTANCE)
import org.opensearch.search.query.QueryPhaseSearcherWrapper;
        };
            @Override
                return singletonList(new SignificanceHeuristicSpec<>(ChiSquare.NAME, ChiSquare::new, ChiSquare.PARSER));
        Collections.addAll(allSupportedQueries, DEPRECATED_QUERIES);
                return singletonList(
