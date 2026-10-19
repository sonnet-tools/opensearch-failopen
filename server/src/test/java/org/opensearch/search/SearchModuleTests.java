            public Map<String, Highlighter> getHighlighters() {  
            @Override
        };  
                        DerivativePipelineAggregationBuilder::new,  
        };  
        }));  
                    new ScoreFunctionSpec<>(
import org.opensearch.search.aggregations.DefaultAggregationProcessor;  
        protected void doWriteTo(StreamOutput out) throws IOException {}  
                return singletonList(
            }
        public RescorerBuilder<TestRescorerBuilder> rewrite(QueryRewriteContext ctx) throws IOException {
                .count()
        @Override
import org.opensearch.index.IndexSettings;  
        "match_none",  
            1,  
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("term", LoggingDeprecationHandler.INSTANCE))  
        private static TestAggregationBuilder fromXContent(String name, XContentParser p) {
            .stream()
            public Map<String, Highlighter> getHighlighters() {
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
        @Override
            hasSize(1)
import org.opensearch.index.query.QueryShardContext;  
                );
    public void testRegisterPipelineAggregation() {  
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeQuery));  
                        TestSuggestionBuilder::fromXContent,
        searchModule.getIndexSearcherExecutor(threadPool);  
                return Optional.of(mock(ExecutorServiceProvider.class));
        TestSuggestion(StreamInput in) throws IOException {  
        "template" };
            module.getNamedXContents()  
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
                return Optional.of(queryPhaseSearcher);
        }
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeSuggester));
                return singletonList(
        assertThat(  
    /**
    public void testRegisterConcurrentSearchRequestDecidersExternalPluginsWithNoDeciders() {
            return null;  
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("test"))
            module.getNamedWriteables()  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, searchPlugins);
        @Override
 *
        "match_all",
            super("test", new String[] {}, null);
    }
        }
            @Override
import org.opensearch.search.aggregations.support.ValuesSourceType;
        ThreadPool threadPool = mock(ThreadPool.class);
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
        expectThrows(IllegalStateException.class, () -> new SearchModule(Settings.EMPTY, searchPlugins));
            @Override  
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupePipelineAggregation));  
 * license agreements. See the NOTICE file distributed with
        protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        }
import static java.util.stream.Collectors.toSet;
            @Override  
            @Override
            ValuesSourceConfig config,
import org.opensearch.search.aggregations.pipeline.SimpleModel;
import org.opensearch.index.query.QueryBuilder;
        @Override  
import java.util.Arrays;  
        assertEquals(queryPhaseSearcher, queryPhase.getQueryPhaseSearcher());
        ) throws IOException {
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeScoreFunction));
            1,
        public String getWriteableName() {
        "span_within",
        };
import org.opensearch.search.fetch.subphase.highlight.FastVectorHighlighter;  
 * compatible open source license.
        CustomHighlighter customHighlighter = new CustomHighlighter();  
            1,
            .filter(e -> e.categoryClass.equals(QueryBuilder.class))
            @Override  
                        DerivativePipelineAggregationBuilder::parse
            module.getNamedWriteables().stream().filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("test")).count()
                .count()
        }
            module.getNamedXContents()
                    new PipelineAggregationSpec(
        "match_phrase_prefix",
            hasSize(1)
        assertThat(
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("phrase"))
        @Override
        "geo_polygon",
        SearchPlugin registersDupeSuggester = new SearchPlugin() {
    }
        assertEquals(  
 * ownership. Elasticsearch licenses this file to you under  
            public List<RescorerSpec<?>> getRescorers() {
        "terms_set",
 * software distributed under the License is distributed on an
        assertEquals(  
        }  
        public String getWriteableName() {
        }));  
        private static TestPipelineAggregationBuilder fromXContent(String name, XContentParser p) {  
        @Override
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
        "constant_score",  
        assertEquals(  
                        GaussDecayFunctionBuilder.NAME,  
            return null;  
import org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder;
        "match",  
        searchPlugins.add(plugin1);  
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
        public String getWriteableName() {  
        };
            public List<AggregationSpec> getAggregations() {
        protected PipelineAggregator createInternal(Map<String, Object> metadata) {  
            Builder subFactoriesBuilder
import static org.hamcrest.Matchers.hasSize;
        };
import org.opensearch.search.query.QueryPhase;  
        assertTrue(queryPhase.getQueryPhaseSearcher() instanceof QueryPhaseSearcherWrapper);
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.search.query.ConcurrentQueryPhaseSearcher;
        SearchPlugin pluginDecider2 = new SearchPlugin() {
        );  
            return null;
            CharsRefBuilder spare  
        }
        public String getWriteableName() {
        TestPipelineAggregationBuilder(StreamInput in) throws IOException {
 */
                return Optional.of(new ConcurrentSearchRequestDecider.Factory() {
                );
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());  
        "match_phrase",
    }
        assertThat(registeredAll, containsInAnyOrder(allSupportedQueries.toArray(new String[0])));
        "geo_shape",  
import java.util.ArrayList;
            @Override
/*
        QueryPhase queryPhase = searchModule.getQueryPhase();
        };
                .collect(toList()),
    public void testRegisterSuggester() {
public class SearchModuleTests extends OpenSearchTestCase {
        assertEquals(
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeRescorer));
                });  
                        TestSuggestion::new
                        GaussDecayFunctionBuilder::new,
import org.opensearch.search.suggest.Suggest.Suggestion;  
        "wrapper",  
            super(clone, factoriesBuilder, metadata);  
        "wildcard",
                .count()  
        );
import org.opensearch.index.query.QueryRewriteContext;
        @Override  
            @Override  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
import org.opensearch.search.fetch.subphase.highlight.UnifiedHighlighter;  
        TestSearchContext searchContext = new TestSearchContext(null);  
package org.opensearch.search;
            return "test";
        assertThat(providers, hasSize(1));
import org.opensearch.test.OpenSearchTestCase;  
            public List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {  
                .stream()  
     */  
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("term"))
                return singletonList(new RescorerSpec<>("test", TestRescorerBuilder::new, TestRescorerBuilder::fromXContent));
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("test", LoggingDeprecationHandler.INSTANCE))
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeHighlighter));
            return CoreValuesSourceType.BYTES;
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        );
            hasSize(1)  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
}
    }  
        );
import org.opensearch.search.aggregations.ConcurrentAggregationProcessor;
            @Override
        }
        public static TestSuggestionBuilder fromXContent(XContentParser parser) {
        };
            public Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {  
                        return Optional.of(mock(ConcurrentSearchRequestDecider.class));
         */
        protected void validate(ValidationContext context) {}
import org.opensearch.search.suggest.term.TermSuggestion;
        TestSearchContext searchContext = new TestSearchContext(null);
                return Optional.of(mock(QueryPhaseSearcher.class));  
            .collect(toSet());
        assertEquals(
        SearchPlugin registersDupeAggregation = new SearchPlugin() {
        "fuzzy",
import org.opensearch.search.profile.Timer;
        }  
            @Override  
            module.getNamedXContents()
                .count()
                });  
                .filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("completion"))
        List<SearchPlugin> searchPlugins = new ArrayList<>();
            @Override
        );  
                .count()  
    /**
        }
            }  
        );
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
            super(in);
            public List<PipelineAggregationSpec> getPipelineAggregations() {  
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
    }  
import org.apache.lucene.search.IndexSearcher;  
        };
            SuggestionContext suggestion,
                return singletonList(new QuerySpec<>(TermQueryBuilder.NAME, TermQueryBuilder::new, TermQueryBuilder::fromXContent));  
    }
            return null;  
 * KIND, either express or implied.  See the License for the
                .filter(
            IndexSearcher searcher,
        SearchPlugin plugin2 = new SearchPlugin() {
                return Optional.of(mock(ExecutorServiceProvider.class));
    private static class TestRescorerBuilder extends RescorerBuilder<TestRescorerBuilder> {
import org.opensearch.search.aggregations.AggregationBuilder;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());  
            return null;  
        assertEquals(UnifiedHighlighter.class, highlighters.get("unified").getClass());
            QueryShardContext queryShardContext,
            @Override
    private ThrowingRunnable registryForPlugin(SearchPlugin plugin) {
                return singletonList(new ExplainPhase());
import org.opensearch.search.suggest.SuggestionSearchContext;
        protected Entry newEntry(StreamInput in) throws IOException {
         * Read from a stream.  
        @Override  
    private static class TestSuggestion extends Suggestion {
import org.opensearch.search.aggregations.pipeline.MovAvgModel;
/*  
            return new TestAggregationBuilder(this, factoriesBuilder, metadata);
        Map<String, Highlighter> highlighters = module.getHighlighters();
            }
        TestSearchContext searchContext = new TestSearchContext(null);
            .map(e -> e.name.getPreferredName())
            }
import org.opensearch.search.query.QueryPhaseSearcherWrapper;
                .stream()
            module.getNamedWriteables()
            public Optional<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactory() {  
 * this work for additional information regarding copyright
    public void testDoubleRegister() {
                    )  
            return "test";
                    }
            @Override  
                .collect(toList()),  
                        GaussDecayFunctionBuilder.PARSER
import org.opensearch.search.query.QueryPhaseSearcher;
        assertEquals(
            public List<SearchPlugin.QuerySpec<?>> getQueries() {
            1,
                return singletonList(new AggregationSpec("test", TestAggregationBuilder::new, TestAggregationBuilder::fromXContent));
        "term",
            SuggestionSearchContext.SuggestionContext suggestion,
            return "test";
import static org.mockito.Mockito.mock;
        protected TestAggregationBuilder(StreamInput in) throws IOException {
    public void testIndexSearcher() {  
        "distance_feature",
        assertTrue(queryPhase.getQueryPhaseSearcher().aggregationProcessor(searchContext) instanceof DefaultAggregationProcessor);
        List<SearchPlugin> searchPlugins = new ArrayList<>();  
            1,  
        SearchPlugin registersDupeFetchSubPhase = new SearchPlugin() {
        @Override
                .stream()
                    entry -> entry.categoryClass.equals(BaseAggregationBuilder.class)
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;  
        searchPlugins.add(pluginDecider2);  
        "boosting",
import org.opensearch.search.aggregations.BaseAggregationBuilder;
                return Optional.of(mock(ExecutorServiceProvider.class));
    public void testRegisterAggregation() {
        "span_near",  
 * GitHub history for details.
        protected boolean doEquals(TestSuggestionBuilder other) {
                return singletonList(  
            module.getNamedWriteables().stream().filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("term")).count()
        };  
        }
        );
        List<SearchPlugin> searchPlugins = new ArrayList<>();
    }
                .count()
            }  
                .stream()  
        expectThrows(IllegalStateException.class, () -> new SearchModule(Settings.EMPTY, searchPlugins));  
            }  
            return 0;
                return singletonList(
                    e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("completion", LoggingDeprecationHandler.INSTANCE)  
        SearchPlugin registersDupeScoreFunction = new SearchPlugin() {
            module.getNamedWriteables()
        @Override  
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {  
import org.apache.lucene.util.CharsRefBuilder;
            public List<SearchPlugin.SuggesterSpec<?>> getSuggesters() {  
                )  
            return null;  
        SearchPlugin registersDupeHighlighter = new SearchPlugin() {
            module.getNamedXContents()  
import org.opensearch.core.xcontent.XContentParser;
            super(in, "test");  
            String name,  
 * under the License.  
        }
            .flatMap(e -> Arrays.stream(e.name.getAllNamesIncludedDeprecated()))  
            return null;
        assertTrue(queryPhase.getQueryPhaseSearcher() instanceof QueryPhaseSearcherWrapper);
        /**
        }
    public void testRegisterConcurrentSearchRequestDecidersExternalPluginsWithDeciders() {
        assertEquals(
            }
        searchContext.setConcurrentSegmentSearchEnabled(true);
                .filter(
    /**
 *
        }
                );
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeAggregation));
        assertEquals(
        };
import static java.util.stream.Collectors.toList;
        SearchModule module = new SearchModule(Settings.EMPTY, emptyList());
                .stream()
        "nested",
        };
                return Optional.of((searchContext, query) -> List.of(() -> new Timer("plugin_timer")));  
import org.opensearch.index.query.TermQueryBuilder;
        "span_containing",
            return null;
import org.opensearch.search.rescore.RescoreContext;
        }
                        TestSuggestionBuilder::new,  
import org.opensearch.search.aggregations.pipeline.InternalDerivative;
        "combined_fields",
                        TermSuggestion::new  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.test.TestSearchContext;
            module.getNamedXContents()
        /**
    }  
 * this file be licensed under the Apache-2.0 license or a
        }));
            public List<PipelineAggregationSpec> getPipelineAggregations() {
     */  
            return null;
import org.opensearch.search.rescore.RescorerBuilder;
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
        protected ValuesSourceAggregatorFactory innerBuild(  
    // add here deprecated queries to make sure we log a deprecation warnings when they are used
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
    public void testRegisteredQueries() {  
            }
                .stream()
            1,  
        @Override
    public void testRegisterConcurrentSearchRequestDecidersNoExternalPlugins() {
        "span_gap",
        "exists",  
        @Override  
        );
            1,  
        @Override
        assertEquals(FastVectorHighlighter.class, highlighters.get("fvh").getClass());  
        "geo_distance",
                return singletonMap("custom", customHighlighter);
    public void testMultiplePluginRegisterQueryPhaseSearcher() {
     * Dummy test {@link PipelineAggregator} used to test registering aggregation builders.  
            super(in);
            @Override  
        "range",
            }  
        assertEquals(
        }
                    public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {  
    private static class TestAggregationBuilder extends ValuesSourceAggregationBuilder<TestAggregationBuilder> {
            1,
 * specific language governing permissions and limitations
                .count()  
    }
        }  
            }
            .filter(e -> e.categoryClass.equals(QueryBuilder.class))
        Set<String> registeredAll = module.getNamedXContents()  
            module.getNamedWriteables()  
            return null;
        assertTrue(queryPhase.getQueryPhaseSearcher().aggregationProcessor(searchContext) instanceof ConcurrentAggregationProcessor);
            }
            public List<SearchExtensionSpec<MovAvgModel, MovAvgModel.AbstractModelParser>> getMovingAverageModels() {
import org.opensearch.search.fetch.subphase.highlight.CustomHighlighter;
        QueryPhase queryPhase = searchModule.getQueryPhase();  
        SearchPlugin registersDupeQuery = new SearchPlugin() {  
        List<String> allSupportedQueries = new ArrayList<>();
        "span_multi",
        assertThat(
 * not use this file except in compliance with the License.
        "regexp",  
        TestRescorerBuilder(StreamInput in) throws IOException {  
                    @Override
            public List<RescorerSpec<?>> getRescorers() {
            module.getNamedXContents()
        @Override  
     */
import org.opensearch.core.common.io.stream.StreamInput;
                .collect(toList()),
                return singletonList(new SearchExtensionSpec<>(SimpleModel.NAME, SimpleModel::new, SimpleModel.PARSER));
         */  
        SearchPlugin plugin1 = new SearchPlugin() {
import java.util.Optional;
        "span_or",
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
        "prefix",  
            }
        );  
            }  
                );
            }  
                    )
    }
            }
            1,
        }  
        Collections.addAll(allSupportedQueries, DEPRECATED_QUERIES);  
    private static class TestSuggester extends Suggester<SuggestionSearchContext.SuggestionContext> {
        "span_term",  
                .filter(  
            public List<SuggesterSpec<?>> getSuggesters() {
        ) throws IOException {
                return singletonList(
            1,
        searchPlugins.add(pluginDecider1);
                )
        SearchPlugin registersDupeRescorer = new SearchPlugin() {
                        TermSuggestionBuilder::fromXContent,
        @Override
    private static class TestPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<TestPipelineAggregationBuilder> {
            return null;
                    new AggregationSpec(TermsAggregationBuilder.NAME, TermsAggregationBuilder::new, TermsAggregationBuilder.PARSER)  
                );  
                return Optional.of(new ConcurrentQueryPhaseSearcher());  
        );
                        && entry.name.match("test", LoggingDeprecationHandler.INSTANCE)
            1,
            AggregatorFactory parent,  
                    ).addResultReader(InternalDerivative::new)
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeSignificanceHeuristic));  
            public Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {
    private static final String[] DEPRECATED_QUERIES = new String[] { "common", "field_masking_span" };
            module.getNamedXContents()  
            super(in);
    private static final String[] NON_DEPRECATED_QUERIES = new String[] {  
            @Override  
        "span_field_masking",
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;
            public Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
                    new SuggesterSpec<>(
        SearchPlugin registersDupeSignificanceHeuristic = new SearchPlugin() {  
        };  
        return () -> new NamedXContentRegistry(new SearchModule(Settings.EMPTY, singletonList(plugin)).getNamedXContents());
        protected Suggestion<? extends Suggestion.Entry<? extends Suggestion.Entry.Option>> innerExecute(
                .stream()
        }
            }
        assertEquals(  
        public String getType() {  
                        && entry.name.match("test", LoggingDeprecationHandler.INSTANCE)
            public Optional<ProfileMetricsProvider> getQueryProfileMetricsProvider() {
        QueryPhase queryPhase = searchModule.getQueryPhase();  
                    new PipelineAggregationSpec("test", TestPipelineAggregationBuilder::new, TestPipelineAggregationBuilder::fromXContent)
        }  
        "span_first",  
        "dis_max",
            @Override
import org.opensearch.search.suggest.SuggestionBuilder;
                .stream()
        protected TestAggregationBuilder(TestAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
        SearchPlugin pluginDecider1 = new SearchPlugin() {
import org.opensearch.search.suggest.Suggester;  
 *  
                    new RescorerSpec<>(QueryRescorerBuilder.NAME, QueryRescorerBuilder::new, QueryRescorerBuilder::fromXContent)  
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
            @Override
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;  
import static java.util.Collections.singletonMap;  
        @Override
                );  
        SearchPlugin plugin1 = new SearchPlugin() {
        @Override
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {  
        }  
                .stream()
    public void testDefaultQueryPhaseSearcher() {  
        };
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.pipeline.AbstractPipelineAggregationBuilder;
                return singletonList(  
        searchPlugins.add(plugin1);
            public Optional<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactory() {  
        "script",
import java.util.Map;  
            }
        };
        );  
        @Override
import static org.mockito.Mockito.verify;  
        List<SearchPlugin.ProfileMetricsProvider> providers = module.getPluginProfileMetricsProviders();
    }
        public static final String SUGGESTION_NAME = "test";
        SearchModule searchModule = new SearchModule(Settings.EMPTY, searchPlugins);
        assertEquals(searchModule.getConcurrentSearchRequestDeciderFactories().size(), 2);  
            @Override  
        }  
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
            String name,
        }
            .filter(e -> e.name.getAllReplacedWith() == null)  
import static org.hamcrest.Matchers.containsInAnyOrder;  
        searchPlugins.add(plugin2);
 *    http://www.apache.org/licenses/LICENSE-2.0
        "span_not",
        };  
            @Override
                .stream()
            }
        QueryPhaseSearcher queryPhaseSearcher = (searchContext, searcher, query, collectors, hasFilterCollector, hasTimeout) -> false;  
                .stream()  
        SearchPlugin plugin1 = new SearchPlugin() {  
            @Override
            @Override
            }  
        };  
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.equals("completion"))  
        protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        @Override
        Collections.addAll(allSupportedQueries, NON_DEPRECATED_QUERIES);
import static java.util.Collections.singletonList;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
    }
        }
        @Override  
        }
                .stream()  
        );
            public Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
        };
                    entry -> entry.categoryClass.equals(BaseAggregationBuilder.class)
        @Override
            return this;
                        TermSuggestionBuilder.SUGGESTION_NAME,  
            return ValuesSourceRegistry.UNREGISTERED_KEY;  
    }
                        DerivativePipelineAggregationBuilder.NAME,
        "match_bool_prefix",
        @Override
        protected void doXContent(XContentBuilder builder, Params params) throws IOException {}  
        @Override
                return Optional.of(new ConcurrentSearchRequestDecider.Factory() {
        };
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
                    @Override
        public RescoreContext innerBuildContext(int windowSize, QueryShardContext context) throws IOException {  
                .count()
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeFetchSubPhase));
        @Override
        @Override  
                .filter(
        "ids",
        "query_string",
    }  
        }  
        assertEquals(searchModule.getConcurrentSearchRequestDeciderFactories().size(), 0);
import java.util.Collections;
        );
                return singletonList(
    public void testRegisterHighlighter() {
        protected Suggestion<? extends Entry<? extends Option>> emptySuggestion(  
    }
    public void testConcurrentQueryPhaseSearcher() {
                    public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {  
     * Dummy test {@link AggregationBuilder} used to test registering aggregation builders.
        protected void doWriteTo(StreamOutput out) throws IOException {}  
 * Modifications Copyright OpenSearch Contributors. See  
 */
    }  
                    entry -> entry.categoryClass.equals(RescorerBuilder.class)  
        SearchPlugin plugin2 = new SearchPlugin() {
            @Override
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.singletonList(plugin1));
            module.getNamedWriteables().stream().filter(e -> e.categoryClass.equals(Suggestion.class) && e.name.equals("phrase")).count()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.emptyList;
        }));
import org.opensearch.search.rescore.QueryRescorerBuilder;  
        verify(threadPool).executor(ThreadPool.Names.INDEX_SEARCHER);
                    }
        assertThat(registeredNonDeprecated, containsInAnyOrder(NON_DEPRECATED_QUERIES));  
import java.util.List;
        }  
        "simple_query_string",  
            }
        public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {
        "geo_bounding_box",  
    private static class TestPipelineAggregator extends PipelineAggregator {
            return null;
    public void testProfileMetricsProvider() {
        assertEquals(PlainHighlighter.class, highlighters.get("plain").getClass());
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {
    }  
import org.opensearch.search.aggregations.AggregatorFactory;  
            public List<ScoreFunctionSpec<?>> getScoreFunctions() {  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        "multi_match",
        }  
            return "test";  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        expectThrows(IllegalArgumentException.class, registryForPlugin(registersDupeMovAvgModel));
        assertEquals(
import org.opensearch.plugins.SearchPlugin;  
        @Override
        SearchPlugin registersDupePipelineAggregation = new SearchPlugin() {  
            return null;  
            1,
    private static class TestSuggestionBuilder extends SuggestionBuilder<TestSuggestionBuilder> {  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.fetch.subphase.highlight.PlainHighlighter;
        }
        protected void doWriteTo(StreamOutput out) throws IOException {}  
        "terms",  
                    new SuggesterSpec<>(
        TestSuggestionBuilder(StreamInput in) throws IOException {
        "intervals",
        @Override
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        public static TestRescorerBuilder fromXContent(XContentParser parser) {
        protected int doHashCode() {
        List<SearchPlugin> searchPlugins = new ArrayList<>();
        public BucketCardinality bucketCardinality() {
        SearchModule module = new SearchModule(Settings.EMPTY, singletonList(new SearchPlugin() {  
import org.opensearch.search.fetch.subphase.ExplainPhase;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
        "bool",
            }
        assertTrue(queryPhaseSearcher.aggregationProcessor(searchContext) instanceof DefaultAggregationProcessor);
        assertEquals(providers.getFirst().getQueryProfileMetrics(null, null).size(), 1);  
        }
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        SearchPlugin plugin1 = new SearchPlugin() {
            .collect(toSet());
        searchPlugins.add(plugin2);
        protected SuggestionSearchContext.SuggestionContext build(QueryShardContext context) throws IOException {  
    }
    public void testRegisterRescorer() {
        @Override
            }  
        protected ValuesSourceType defaultValueSourceType() {
        );  
            public List<SignificanceHeuristicSpec<?>> getSignificanceHeuristics() {
                .count()
            @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.InternalAggregation;
        SearchPlugin registersDupeMovAvgModel = new SearchPlugin() {
        ) throws IOException {
            }
        }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
            .stream()
                return singletonList(new SignificanceHeuristicSpec<>(ChiSquare.NAME, ChiSquare::new, ChiSquare.PARSER));  
        "function_score",
            module.getNamedWriteables()
         * Read from a stream.
                        && entry.name.match("test", LoggingDeprecationHandler.INSTANCE)  
        searchPlugins.add(plugin1);  
                        TestSuggestionBuilder.SUGGESTION_NAME,
        }));
    }  
/*
        assertEquals(
import org.opensearch.common.settings.Settings;
        }  
            CharsRefBuilder spare  
                return singletonMap("plain", new PlainHighlighter());
     * Dummy test {@link PipelineAggregator} used to test registering aggregation builders.
        }  
    public void testPluginQueryPhaseSearcher() {
                        return Optional.of(mock(ConcurrentSearchRequestDecider.class));
import org.opensearch.search.fetch.FetchSubPhase;  
    }  
        Set<String> registeredNonDeprecated = module.getNamedXContents()  
            return null;
        "script_score",
                .filter(e -> e.categoryClass.equals(SuggestionBuilder.class) && e.name.match("phrase", LoggingDeprecationHandler.INSTANCE))
    }
            super(in);
            }
import java.util.Set;
    }
                )
        searchPlugins.add(plugin2);
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
        assertEquals(searchModule.getConcurrentSearchRequestDeciderFactories().size(), 0);
    }  
            return false;  
        }
        };
                return Optional.of(mock(ExecutorServiceProvider.class));
            public List<AggregationSpec> getAggregations() {
            }  
                )
        );  
            @Override
        TestPipelineAggregator() {  
    }  
            return null;  
        }));
                );
                        TermSuggestionBuilder::new,
            @Override  
    public void testMultiplePluginRegisterIndexSearcherProvider() {
 * You may obtain a copy of the License at  
                    )  
        SearchPlugin plugin2 = new SearchPlugin() {  
        protected void innerWriteTo(StreamOutput out) throws IOException {}
        assertSame(highlighters.get("custom"), customHighlighter);  
            return BucketCardinality.NONE;
        "more_like_this",  
        protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
 */  
            return "test";
