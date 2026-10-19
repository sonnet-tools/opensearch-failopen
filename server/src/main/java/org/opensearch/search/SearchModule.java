            builder
                StringTerms.NAME,
                CompletionSuggestion::new  
import org.opensearch.search.sort.ShardDocSortBuilder;
            ).addResultReader(InternalVariableWidthHistogram::new)  
 *  
            )  
            ).addResultReader(InternalExtendedStatsBucket::new)
import org.opensearch.index.query.IdsQueryBuilder;
            )  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketParser;  
        registerQuery(new QuerySpec<>(FuzzyQueryBuilder.NAME, FuzzyQueryBuilder::new, FuzzyQueryBuilder::fromXContent));
            new QuerySpec<>(DistanceFeatureQueryBuilder.NAME, DistanceFeatureQueryBuilder::new, DistanceFeatureQueryBuilder::fromXContent)
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;  
        );
import org.opensearch.search.query.QueryPhaseSearcher;
        return provider;
        registerAggregation(
                .addResultReader(InternalGlobal::new),
        );  
            new PipelineAggregationSpec(
    /**
 */
        this.settings = settings;
    }
    }
            new QuerySpec<>(SpanMultiTermQueryBuilder.NAME, SpanMultiTermQueryBuilder::new, SpanMultiTermQueryBuilder::fromXContent)
    private void registerRescorer(RescorerSpec<?> spec) {  
            builder
import org.opensearch.search.fetch.subphase.FetchSourcePhase;
    }
    public Map<String, Highlighter> getHighlighters() {  
        // ScriptScoreFunctionBuilder has it own named writable because of a new script_score query  
        namedWriteables.add(
            } else if (searcherOpt.isPresent()) {  
import org.opensearch.index.query.MatchQueryBuilder;  
                CommonTermsQueryBuilder::new,  
                MovAvgPipelineAggregationBuilder::new,
                .addResultReader(InternalHDRPercentiles.NAME, InternalHDRPercentiles::new)
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(ChiSquare.NAME, ChiSquare::new, ChiSquare.PARSER));  
            new QuerySpec<>(CombinedFieldsQueryBuilder.NAME, CombinedFieldsQueryBuilder::new, CombinedFieldsQueryBuilder::fromXContent)
        registerQuery(new QuerySpec<>(ExistsQueryBuilder.NAME, ExistsQueryBuilder::new, ExistsQueryBuilder::fromXContent));
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;  
            ),
        registerFetchSubPhase(new FetchFieldsPhase());
        );
        );  
import org.opensearch.index.query.TermsQueryBuilder;
                AvgBucketPipelineAggregationBuilder::new,  
     */
import org.opensearch.search.aggregations.pipeline.InternalStatsBucket;  
import org.opensearch.search.aggregations.bucket.missing.InternalMissing;
            new NamedWriteableRegistry.Entry(
        registerAggregation(
                SumBucketPipelineAggregationBuilder::new,  
                .addResultReader(UnsignedLongTerms.NAME, UnsignedLongTerms::new)
                    IntervalsSourceProvider.Regexp::new
            new AggregationSpec(
    private void registerValueFormat(String name, Writeable.Reader<? extends DocValueFormat> reader) {
                FieldValueFactorFunctionBuilder::new,  
        registerFromPlugin(plugins, SearchPlugin::getSignificanceHeuristics, this::registerSignificanceHeuristic);  
        registerAggregation(
            new PipelineAggregationSpec(  
        registerValueFormat(DocValueFormat.Decimal.NAME, DocValueFormat.Decimal::new);  
            new AggregationSpec(MinAggregationBuilder.NAME, MinAggregationBuilder::new, MinAggregationBuilder.PARSER).addResultReader(
        namedWriteables.add(new NamedWriteableRegistry.Entry(SearchExtBuilder.class, spec.getName().getPreferredName(), spec.getReader()));  
    private void registerSearchExt(SearchExtSpec<?> spec) {
        registerPipelineAggregation(
        );  
import org.opensearch.search.aggregations.pipeline.SimpleModel;  
import org.opensearch.index.query.WildcardQueryBuilder;  
                DerivativePipelineAggregationBuilder::new,  
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
        );
    private final List<FetchSubPhase> fetchSubPhases = new ArrayList<>();
                    IntervalsSourceProvider.Match::new  
                BucketScriptPipelineAggregationBuilder.NAME,
                BucketSelectorPipelineAggregationBuilder.NAME,
        registerRescorers(plugins);
                .setAggregatorRegistrar(IpRangeAggregationBuilder::registerAggregators),
import org.opensearch.search.rescore.RescorerBuilder;
            new AggregationSpec(
 * Sets up things that can be done at search time like queries, aggregations, and suggesters.
                MatchPhrasePrefixQueryBuilder::fromXContent  
            final Optional<SearchPlugin.ExecutorServiceProvider> providerOpt = plugin.getIndexSearcherExecutorProvider();  
        this.valuesSourceRegistry = registerAggregations(plugins);
            new ScoreFunctionSpec<>(  
    private <T> void registerFromPlugin(List<SearchPlugin> plugins, Function<SearchPlugin, List<T>> producer, Consumer<T> consumer) {
        registerSort(new SortSpec<>(ScriptSortBuilder.NAME, ScriptSortBuilder::new, ScriptSortBuilder::fromXContent));
    }  
        namedWriteables.add(new NamedWriteableRegistry.Entry(RescorerBuilder.class, spec.getName().getPreferredName(), spec.getReader()));
import java.util.List;  
            namedWriteables.add(
        registerAggregation(
        );
            ).addResultReader(InternalAdjacencyMatrix::new),
import static java.util.Collections.unmodifiableMap;
import org.opensearch.search.aggregations.bucket.terms.StringRareTerms;  
                SerialDiffPipelineAggregationBuilder::parse  
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
        movingAverageModelParserRegistry.register(movAvgModel.getParser(), movAvgModel.getName());
            ).addResultReader(InternalStatsBucket::new)
        registerQuery(new QuerySpec<>(NestedQueryBuilder.NAME, NestedQueryBuilder::new, NestedQueryBuilder::fromXContent));
        registerPipelineAggregation(
                TermSuggestionBuilder.SUGGESTION_NAME,  
import org.opensearch.search.aggregations.pipeline.InternalExtendedStatsBucket;  
                MatchPhrasePrefixQueryBuilder.NAME,
            /* Reuses result readers from SamplerAggregator*/,
        registerAggregation(
        registerScoreFunctions(plugins);
import org.opensearch.search.fetch.subphase.highlight.HighlightPhase;
 * Licensed to Elasticsearch under one or more contributor  
    private QueryPhaseSearcher registerQueryPhaseSearcher(List<SearchPlugin> plugins) {
    private void registerAggregation(AggregationSpec spec, ValuesSourceRegistry.Builder builder) {  
            )  
        registerAggregation(  
                // This bucket is used by many pipeline aggreations.
        registerValueFormat(DocValueFormat.DateTime.NAME, DocValueFormat.DateTime::new);
            new AggregationSpec(
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        );  
                MedianAbsoluteDeviationAggregationBuilder::new,
            )
            builder  
                ExponentialDecayFunctionBuilder.PARSER
        registerQuery(new QuerySpec<>(GeoDistanceQueryBuilder.NAME, GeoDistanceQueryBuilder::new, GeoDistanceQueryBuilder::fromXContent));  
        registerFetchSubPhase(new FetchVersionPhase());
package org.opensearch.search;
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;
        fetchSubPhases.add(requireNonNull(subPhase, "FetchSubPhase must not be null"));
    private void registerQuery(QuerySpec<?> spec) {  
        );
import org.opensearch.search.aggregations.AggregationBuilder;  
                new NamedWriteableRegistry.Entry(  
            builder
        registerAggregation(
    }
        Class<?> subPhaseClass = subPhase.getClass();
            new AggregationSpec(MultiTermsAggregationBuilder.NAME, MultiTermsAggregationBuilder::new, MultiTermsAggregationBuilder.PARSER)
            )  
            )
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
                ),
        registerQuery(new QuerySpec<>(TermsSetQueryBuilder.NAME, TermsSetQueryBuilder::new, TermsSetQueryBuilder::fromXContent));
        }  
        );
        registerFromPlugin(plugins, SearchPlugin::getQueries, this::registerQuery);
    }  
                .addResultReader(InternalBucketMetricValue.NAME, InternalBucketMetricValue::new)
import org.opensearch.common.xcontent.ParseFieldRegistry;
     * Constructs a new SearchModule object  
        );
    public SearchModule(Settings settings, List<SearchPlugin> plugins) {
                AutoDateHistogramAggregationBuilder::new,
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
                FieldValueFactorFunctionBuilder::fromXContent
    }
                new NamedWriteableRegistry.Entry(
                InternalMin::new
import org.opensearch.index.query.DisMaxQueryBuilder;
    }
            registerQuery(new QuerySpec<>(GeoShapeQueryBuilder.NAME, GeoShapeQueryBuilder::new, GeoShapeQueryBuilder::fromXContent));
                InternalSum::new
                SignificantTextAggregationBuilder::new,  
                ScoreFunctionBuilder.class,  
            ).setAggregatorRegistrar(SumAggregationBuilder::registerAggregators),  
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
        registerScoreFunction(
import org.opensearch.common.geo.ShapesAvailability;
                .addResultReader(InternalSampler.NAME, InternalSampler::new)
        namedWriteables.add(
import static org.opensearch.threadpool.ThreadPool.Names.INDEX_SEARCHER;
        registerFromPlugin(plugins, SearchPlugin::getRescorers, this::registerRescorer);  
                MinBucketPipelineAggregationBuilder::new,
import org.opensearch.plugins.SearchPlugin.AggregationSpec;
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
        );
        );
import org.opensearch.search.aggregations.pipeline.SerialDiffPipelineAggregationBuilder;
    public ParseFieldRegistry<MovAvgModel.AbstractModelParser> getMovingAverageModelParserRegistry() {
            )
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
import org.opensearch.search.suggest.phrase.SmoothingModel;  
        );
            }
        );
                SerialDiffPipelineAggregationBuilder.NAME,
        registerFromPlugin(plugins, SearchPlugin::getAggregations, (agg) -> this.registerAggregation(agg, builder));  
        );  
import org.opensearch.search.aggregations.metrics.InternalStats;
                InternalAvg::new  
        );
/*
import org.opensearch.search.fetch.subphase.highlight.UnifiedHighlighter;
    }  
            /* Uses InternalSimpleValue */  
        registerQuery(  
                ScoreFunctionBuilder.class,
import org.opensearch.index.query.SpanContainingQueryBuilder;
            new QuerySpec<>(GeoBoundingBoxQueryBuilder.NAME, GeoBoundingBoxQueryBuilder::new, GeoBoundingBoxQueryBuilder::fromXContent)
import org.opensearch.search.fetch.subphase.MatchedQueriesPhase;
        );
        );
import org.opensearch.search.aggregations.pipeline.AvgBucketPipelineAggregationBuilder;
            ).setAggregatorRegistrar(MinAggregationBuilder::registerAggregators),  
import org.opensearch.plugins.SearchPlugin.ScoreFunctionSpec;  
    private final QueryPhaseSearcher queryPhaseSearcher;
        namedWriteables.add(
import org.opensearch.search.aggregations.bucket.adjacency.InternalAdjacencyMatrix;
        return concurrentSearchDeciderFactories;
            )
                ScriptedMetricAggregationBuilder.PARSER  
import org.opensearch.index.query.IntervalsSourceProvider;  
import org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder;  
import org.opensearch.search.aggregations.bucket.terms.heuristic.PercentageScore;
                    movingAverageModelParserRegistry,
            new QuerySpec<>(
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
            builder
            builder
        registerIntervalsSourceProviders();
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
            )  
                scoreFunction.getName(),  
import java.util.Map;
        );
                DerivativePipelineAggregationBuilder.NAME,
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        );  
    /**
            namedWriteables.addAll(GeoShapeType.getShapeWriteables());  
            new AggregationSpec(TopHitsAggregationBuilder.NAME, TopHitsAggregationBuilder::new, TopHitsAggregationBuilder::parse)
        }
                PercentilesAggregationBuilder.NAME,
        registerValueFormat(DocValueFormat.BOOLEAN.getWriteableName(), in -> DocValueFormat.BOOLEAN);
                AutoDateHistogramAggregationBuilder.PARSER
import org.opensearch.index.query.SpanNearQueryBuilder.SpanGapQueryBuilder;  
            ).addResultReader(InternalPercentilesBucket::new)  
    private void registerScoreFunctions(List<SearchPlugin> plugins) {
import java.util.Arrays;
import org.opensearch.search.sort.ScoreSortBuilder;
                SignificantTermsAggregationBuilder::new,
        registerSort(new SortSpec<>(ScoreSortBuilder.NAME, ScoreSortBuilder::new, ScoreSortBuilder::fromXContent));  
        registerValueFormats();  
 * specific language governing permissions and limitations
                RandomScoreFunctionBuilder::new,
import org.opensearch.search.sort.ScriptSortBuilder;  
        namedWriteables.add(new NamedWriteableRegistry.Entry(SmoothingModel.class, LinearInterpolation.NAME, LinearInterpolation::new));  
        // TODO remove funky contexts
import org.opensearch.search.aggregations.bucket.terms.RareTermsAggregationBuilder;
        registerQuery(new QuerySpec<>(IdsQueryBuilder.NAME, IdsQueryBuilder::new, IdsQueryBuilder::fromXContent));  
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
        registerSignificanceHeuristics(plugins);
            new PipelineAggregationSpec(
            builder
        });
                .setAggregatorRegistrar(PercentilesAggregationBuilder::registerAggregators),  
                VariableWidthHistogramAggregationBuilder::new,
                TermSuggestionBuilder::new,
            )
                    IntervalsSourceProvider.Disjunction.NAME,  
        registerQuery(new QuerySpec<>(WildcardQueryBuilder.NAME, WildcardQueryBuilder::new, WildcardQueryBuilder::fromXContent));
                SignificantTermsAggregationBuilder.NAME,  
            final Optional<QueryPhaseSearcher> searcherOpt = plugin.getQueryPhaseSearcher();
        registerSignificanceHeuristic(  
        }
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
    public QueryPhase getQueryPhase() {
                .setAggregatorRegistrar(HistogramAggregationBuilder::registerAggregators),
            builder  
                BucketSortPipelineAggregationBuilder::parse
        registerQuery(new QuerySpec<>(TermQueryBuilder.NAME, TermQueryBuilder::new, TermQueryBuilder::fromXContent));
                GeoDistanceAggregationBuilder::new,
            builder
        highlighters = setupHighlighters(settings, plugins);
            )
                ),  
            new AggregationSpec(IpRangeAggregationBuilder.NAME, IpRangeAggregationBuilder::new, IpRangeAggregationBuilder.PARSER)  
    private final Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories;
        namedXContents.add(new NamedXContentRegistry.Entry(BaseAggregationBuilder.class, spec.getName(), (p, c) -> {
 * this file be licensed under the Apache-2.0 license or a
                new ParseField(GeoDistanceSortBuilder.NAME, GeoDistanceSortBuilder.ALTERNATIVE_NAME),
import org.opensearch.search.suggest.term.TermSuggestion;
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        );  
        namedWriteables.add(  
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
                MaxBucketPipelineAggregationBuilder::new,
import org.opensearch.search.aggregations.metrics.InternalMedianAbsoluteDeviation;
            searcher = new QueryPhaseSearcherWrapper();  
        for (SearchPlugin plugin : plugins) {
                FieldMaskingSpanQueryBuilder.SPAN_FIELD_MASKING_FIELD,
        );
        // Can be a single function too when not associated to any other function, which is why it needs to be registered manually here.  
import org.opensearch.index.query.GeoPolygonQueryBuilder;
                    name,
            builder  
    }
        );  
            ).addResultReader(InternalAutoDateHistogram::new)  
        registerAggregation(
            new PipelineAggregationSpec(
                PhraseSuggestion::new  
        registerAggregation(
    private Map<String, Highlighter> setupHighlighters(Settings settings, List<SearchPlugin> plugins) {
 * ownership. Elasticsearch licenses this file to you under  
                GeoDistanceAggregationBuilder::parse
                MovFnPipelineAggregationBuilder.PARSER
        );
import org.opensearch.search.suggest.phrase.Laplace;
                    IntervalsSourceProvider.Match.NAME,
import org.opensearch.search.aggregations.bucket.terms.UnmappedRareTerms;  
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
                GeoCentroidAggregationBuilder::new,  
            new QuerySpec<>(MatchBoolPrefixQueryBuilder.NAME, MatchBoolPrefixQueryBuilder::new, MatchBoolPrefixQueryBuilder::fromXContent)
                PercentileRanksAggregationBuilder::parse
        registerAggregation(
            provider = (ThreadPool threadPool) -> threadPool.executor(INDEX_SEARCHER);  
        return new FetchPhase(fetchSubPhases);
        );
            ).addResultReader(InternalMedianAbsoluteDeviation::new)  
                ExtendedStatsBucketPipelineAggregationBuilder::new,  
    private ValuesSourceRegistry registerAggregations(List<SearchPlugin> plugins) {
import org.opensearch.index.query.MoreLikeThisQueryBuilder;
import org.opensearch.search.aggregations.bucket.terms.SignificantLongTerms;
                CardinalityAggregationBuilder.PARSER
     * The registry of {@link MovAvgModel}s.
    public static void registerSmoothingModels(List<Entry> namedWriteables) {
            deciderFactory.ifPresent(concurrentSearchDeciderFactories::add);  
    public List<NamedXContentRegistry.Entry> getNamedXContents() {
        registerQuery(
import org.opensearch.index.query.TermsSetQueryBuilder;
import org.opensearch.search.aggregations.pipeline.InternalDerivative;
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
                .addResultReader(InternalHDRPercentileRanks.NAME, InternalHDRPercentileRanks::new)  
            new NamedXContentRegistry.Entry(
        registerQuery(
            builder
import org.opensearch.index.query.ExistsQueryBuilder;  
        );
import org.opensearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
    private void registerQueryCollectorContextSpec(List<SearchPlugin> plugins) {
import org.opensearch.search.fetch.subphase.ExplainPhase;
                Suggest.Suggestion.class,  
import org.opensearch.index.query.SimpleQueryStringBuilder;
                ReverseNestedAggregationBuilder::parse  
                BucketScriptPipelineAggregationBuilder::new,
     */  
    private final SearchPlugin.ExecutorServiceProvider indexSearcherExecutorProvider;
                DerivativePipelineAggregationBuilder::parse
            ).addResultReader(InternalScriptedMetric::new),
                .addResultReader(InternalFilters::new),  
            builder  
            new SuggesterSpec<>(
        registerFromPlugin(plugins, SearchPlugin::getSorts, this::registerSort);
import org.opensearch.search.suggest.completion.CompletionSuggestion;  
     * NOTE: This constructor should not be called in production unless an accurate {@link Settings} object is provided.
            new AggregationSpec(
        registerScoreFunction(
        registerSmoothingModels(namedWriteables);
        registerShapes();
        registerQuery(new QuerySpec<>(PrefixQueryBuilder.NAME, PrefixQueryBuilder::new, PrefixQueryBuilder::fromXContent));
                InternalStats::new
            )
            builder  
import org.opensearch.search.aggregations.pipeline.MovAvgPipelineAggregationBuilder;
        registerPipelineAggregation(  
import org.opensearch.search.aggregations.bucket.terms.UnmappedTerms;
            new NamedWriteableRegistry.Entry(MovAvgModel.class, movAvgModel.getName().getPreferredName(), movAvgModel.getReader())
            new AggregationSpec(AvgAggregationBuilder.NAME, AvgAggregationBuilder::new, AvgAggregationBuilder.PARSER).addResultReader(
            builder
        registerSuggester(
import org.opensearch.search.aggregations.pipeline.HoltLinearModel;
        );
import org.opensearch.search.aggregations.pipeline.MinBucketPipelineAggregationBuilder;  
    }
            new QuerySpec<>(FunctionScoreQueryBuilder.NAME, FunctionScoreQueryBuilder::new, FunctionScoreQueryBuilder::fromXContent)
                .addResultReader(InternalTopHits::new),  
    }
            )  
                .setAggregatorRegistrar(MissingAggregationBuilder::registerAggregators),
            ).addResultReader(InternalDerivative::new)
        registerQuery(new QuerySpec<>(ScriptQueryBuilder.NAME, ScriptQueryBuilder::new, ScriptQueryBuilder::fromXContent));
                ScriptedMetricAggregationBuilder::new,
                throw new IllegalStateException(
            new SuggesterSpec<>(
        registerQueryCollectorContextSpec(plugins);
import org.opensearch.plugins.SearchPlugin.SortSpec;
        registerQuery(new QuerySpec<>(SpanOrQueryBuilder.NAME, SpanOrQueryBuilder::new, SpanOrQueryBuilder::fromXContent));
                );
/*  
        registerValueFormat(DocValueFormat.UNSIGNED_LONG_SHIFTED.getWriteableName(), in -> DocValueFormat.UNSIGNED_LONG_SHIFTED);  
                    "The index searcher executor is already assigned but more than one are provided by the plugins"  
     * <p>
        registerPipelineAggregations(plugins);
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(ScriptHeuristic.NAME, ScriptHeuristic::new, ScriptHeuristic.PARSER));
            new NamedWriteableRegistry.Entry(
                provider = providerOpt.orElse(null);  
        registerMovingAverageModel(new SearchExtensionSpec<>(LinearModel.NAME, LinearModel::new, LinearModel.PARSER));
import org.opensearch.search.aggregations.pipeline.EwmaModel;
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
import org.opensearch.search.aggregations.bucket.range.InternalRange;  
            new PipelineAggregationSpec(  
        );  
                    IntervalsSourceProvider.Fuzzy::new  
            new AggregationSpec(NestedAggregationBuilder.NAME, NestedAggregationBuilder::new, NestedAggregationBuilder::parse)
        );
                .setAggregatorRegistrar(SignificantTermsAggregationBuilder::registerAggregators),  
                PercentilesBucketPipelineAggregationBuilder::new,
            new AggregationSpec(TermsAggregationBuilder.NAME, TermsAggregationBuilder::new, TermsAggregationBuilder.PARSER).addResultReader(  
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;
 * under the License.  
import org.opensearch.index.query.SpanNearQueryBuilder;
                new ExtendedStatsBucketParser()
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
import static java.util.Objects.requireNonNull;  
                PercentilesBucketPipelineAggregationBuilder.NAME,  
                ExtendedStatsAggregationBuilder.NAME,
import org.opensearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;
            new AggregationSpec(MissingAggregationBuilder.NAME, MissingAggregationBuilder::new, MissingAggregationBuilder.PARSER)  
        );  
                ReverseNestedAggregationBuilder.NAME,
        registerQuery(new QuerySpec<>(RegexpQueryBuilder.NAME, RegexpQueryBuilder::new, RegexpQueryBuilder::fromXContent));
import java.util.Optional;
        return plugins.stream().map(SearchPlugin::getQueryProfileMetricsProvider).filter(Optional::isPresent).map(Optional::get).toList();
            new AggregationSpec(StatsAggregationBuilder.NAME, StatsAggregationBuilder::new, StatsAggregationBuilder.PARSER).addResultReader(
        registerQuery(
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
                PhraseSuggestionBuilder::fromXContent,
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
    private void registerSortParsers(List<SearchPlugin> plugins) {
            new QuerySpec<>(ConstantScoreQueryBuilder.NAME, ConstantScoreQueryBuilder::new, ConstantScoreQueryBuilder::fromXContent)
                    IntervalsSourceProvider.class,  
import java.util.Collection;
    }
public class SearchModule {  
        );
/*  
        registerAggregation(  
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;  
        return builder.build();  
                ScriptedMetricAggregationBuilder.NAME,
import org.opensearch.core.ParseField;
                ),  
        return (indexSearcherExecutorProvider != null) ? indexSearcherExecutorProvider.getExecutor(pool) : null;
        );
                CompletionSuggestionBuilder.SUGGESTION_NAME,  
    private void registerFetchSubPhase(FetchSubPhase subPhase) {  
        registerValueFormat(DocValueFormat.GEOTILE.getWriteableName(), in -> DocValueFormat.GEOTILE);
                PercentilesAggregationBuilder::new,
        registerSuggester(
    private void registerMovingAverageModels(List<SearchPlugin> plugins) {  
            ).addResultReader(InternalDateHistogram::new).setAggregatorRegistrar(DateHistogramAggregationBuilder::registerAggregators),
        );
import org.opensearch.search.suggest.SuggestionBuilder;
                ),
        registerQuery(new QuerySpec<>(ScriptScoreQueryBuilder.NAME, ScriptScoreQueryBuilder::new, ScriptScoreQueryBuilder::fromXContent));
import org.opensearch.index.query.CombinedFieldsQueryBuilder;
                ExponentialDecayFunctionBuilder.NAME,  
    }
        );
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        return valuesSourceRegistry;  
            new SortSpec<>(  
            new AggregationSpec(ValueCountAggregationBuilder.NAME, ValueCountAggregationBuilder::new, ValueCountAggregationBuilder.PARSER)  
                BucketSortPipelineAggregationBuilder::new,
    private final ValuesSourceRegistry valuesSourceRegistry;  
import org.opensearch.search.aggregations.pipeline.LinearModel;
        }
import org.opensearch.search.fetch.subphase.ScriptFieldsPhase;
                scoreFunction.getReader()
        );
        registerSortParsers(plugins);
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;  
import org.opensearch.search.aggregations.bucket.range.InternalBinaryRange;  
     */  
import org.opensearch.index.query.FieldMaskingSpanQueryBuilder;
    private Collection<ConcurrentSearchRequestDecider.Factory> registerConcurrentSearchDeciderFactories(List<SearchPlugin> plugins) {
        registerFromPlugin(plugins, SearchPlugin::getPipelineAggregations, this::registerPipelineAggregation);
            new AggregationSpec(  
        }  
    private void registerPipelineAggregations(List<SearchPlugin> plugins) {
import org.opensearch.search.aggregations.pipeline.MovFnPipelineAggregationBuilder;  
     * @param settings Current settings
            )
        pluginProfilerProviders = registerProfilerProviders(plugins);
                FieldValueFactorFunctionBuilder.NAME,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            builder
                .setAggregatorRegistrar(DateRangeAggregationBuilder::registerAggregators),
        }));
                ),
    private void registerSort(SortSpec<?> spec) {
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;  
            } else if (providerOpt.isPresent()) {
                searcher = searcherOpt.orElse(null);
        );
                MinBucketPipelineAggregationBuilder.PARSER
import org.opensearch.search.aggregations.metrics.InternalMax;  
import org.opensearch.plugins.SearchPlugin.SearchExtensionSpec;
    /**  
        registerSuggester(
                .addResultReader(InternalComposite::new)  
        );  
        registerPipelineAggregation(  
    }
                (XContentParser p, Object c) -> scoreFunction.getParser().fromXContent(p)
    public List<SearchPlugin.ProfileMetricsProvider> getPluginProfileMetricsProviders() {
            )
            new QuerySpec<>(MoreLikeThisQueryBuilder.NAME, MoreLikeThisQueryBuilder::new, MoreLikeThisQueryBuilder::fromXContent)  
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram;
                throw new IllegalStateException("Only one QueryPhaseSearcher is allowed, but more than one are provided by the plugins");
        registerScoreFunction(
     * Returns the {@link Highlighter} registry
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 */  
        registerQuery(new QuerySpec<>(GeoPolygonQueryBuilder.NAME, GeoPolygonQueryBuilder::new, GeoPolygonQueryBuilder::fromXContent));
        registerFromPlugin(plugins, SearchPlugin::getScoreFunctions, this::registerScoreFunction);  
        registerFetchSubPhase(new FetchDocValuesPhase());
            new AggregationSpec(
            String name = (String) c;
            ).addResultReader(InternalValueCount::new).setAggregatorRegistrar(MultiValueDocCountAggregationBuilder::registerAggregators),  
            namedWriteables.add(new NamedWriteableRegistry.Entry(InternalAggregation.class, writeableName, internalReader));
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
        );
import org.opensearch.search.aggregations.PipelineAggregationBuilder;  
        registerPipelineAggregation(
import org.opensearch.search.aggregations.metrics.InternalScriptedMetric;  
import org.opensearch.search.fetch.subphase.FetchDocValuesPhase;
                (XContentParser parser, String name) -> MovAvgPipelineAggregationBuilder.parse(  
            );  
            new AggregationSpec(
            builder
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;  
import org.opensearch.search.suggest.term.TermSuggestionBuilder;  
        return namedXContents;
            )
                DateHistogramAggregationBuilder::new,
                ReverseNestedAggregationBuilder::new,
 * GitHub history for details.
            new PipelineAggregationSpec(
                (p, c) -> spec.getParser().fromXContent(p, spec.getName().getPreferredName())
                .setAggregatorRegistrar(VariableWidthHistogramAggregationBuilder::registerAggregators),
            builder  
import org.opensearch.core.xcontent.XContentParser;
            )/* Uses InternalHistogram for buckets */
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
            new AggregationSpec(SumAggregationBuilder.NAME, SumAggregationBuilder::new, SumAggregationBuilder.PARSER).addResultReader(
    }
            new NamedWriteableRegistry.Entry(AggregationBuilder.class, spec.getName().getPreferredName(), spec.getReader())  
        );  
        registerPipelineAggregation(  
        registerSort(
        );  
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
import org.opensearch.search.aggregations.pipeline.SumBucketPipelineAggregationBuilder;
                SignificantTermsAggregationBuilder::parse
    private void registerIntervalsSourceProviders() {
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
            new NamedWriteableRegistry.Entry(SignificanceHeuristic.class, spec.getName().getPreferredName(), spec.getReader())
                MaxBucketPipelineAggregationBuilder.PARSER
                WeightedAvgAggregationBuilder.NAME,  
            new AggregationSpec(FilterAggregationBuilder.NAME, FilterAggregationBuilder::new, FilterAggregationBuilder::parse)  
                CardinalityAggregationBuilder::new,
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;  
import org.opensearch.index.query.FuzzyQueryBuilder;
            )
        );
import org.opensearch.search.suggest.Suggest;
        registerQuery(  
                GeoCentroidAggregationBuilder.PARSER
        return unmodifiableList(
import org.opensearch.index.query.SpanTermQueryBuilder;  
import org.opensearch.index.query.MatchNoneQueryBuilder;  
    private SearchPlugin.ExecutorServiceProvider registerIndexSearcherExecutorProvider(List<SearchPlugin> plugins) {
import org.opensearch.plugins.SearchPlugin.QuerySpec;
    private void registerValueFormats() {  
                BucketSelectorPipelineAggregationBuilder::new,  
        for (SearchPlugin plugin : plugins) {
        registerAggregation(  
    private void registerQueryParsers(List<SearchPlugin> plugins) {
            ).addResultReader(InternalExtendedStats::new).setAggregatorRegistrar(ExtendedStatsAggregationBuilder::registerAggregators),
            builder
                GeoDistanceSortBuilder::fromXContent  
                new NamedWriteableRegistry.Entry(InternalAggregation.class, resultReader.getKey(), resultReader.getValue())
import org.opensearch.search.aggregations.metrics.InternalCardinality;
        );  
        for (Map.Entry<String, Writeable.Reader<? extends InternalAggregation>> resultReader : spec.getResultReaders().entrySet()) {  
        registerQuery(new QuerySpec<>(MatchPhraseQueryBuilder.NAME, MatchPhraseQueryBuilder::new, MatchPhraseQueryBuilder::fromXContent));
import org.opensearch.search.fetch.subphase.FetchVersionPhase;  
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;  
        registerQuery(new QuerySpec<>(QueryStringQueryBuilder.NAME, QueryStringQueryBuilder::new, QueryStringQueryBuilder::fromXContent));
    public static List<NamedWriteableRegistry.Entry> getIntervalsSourceProviderNamedWritables() {  
import org.opensearch.search.query.QueryPhase;
                CardinalityAggregationBuilder.NAME,  
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.InternalAggregation;
                MedianAbsoluteDeviationAggregationBuilder.NAME,  
import org.opensearch.index.query.SpanMultiTermQueryBuilder;
import org.opensearch.index.query.ScriptQueryBuilder;  
        registerValueFormat(DocValueFormat.GEOHASH.getWriteableName(), in -> DocValueFormat.GEOHASH);
            builder  
            new ScoreFunctionSpec<>(GaussDecayFunctionBuilder.NAME, GaussDecayFunctionBuilder::new, GaussDecayFunctionBuilder.PARSER)
import org.opensearch.index.query.BoolQueryBuilder;
import org.opensearch.index.query.functionscore.FieldValueFactorFunctionBuilder;  
        registerQuery(new QuerySpec<>(SpanTermQueryBuilder.NAME, SpanTermQueryBuilder::new, SpanTermQueryBuilder::fromXContent));  
import org.opensearch.index.query.GeoDistanceQueryBuilder;
        }
        namedWriteables.add(
        );
        registerPipelineAggregation(
import org.opensearch.search.suggest.phrase.StupidBackoff;
    }
                )
 * Unless required by applicable law or agreed to in writing,
            new PipelineAggregationSpec(
            builder  
                .addResultReader(InternalMultiTerms::new)  
import static java.util.Collections.unmodifiableList;
            register.accept(builder);  
                SortBuilder.class,  
            )
        registerFetchSubPhase(new FetchSourcePhase());  
        registerAggregation(
        registerQuery(new QuerySpec<>(SpanWithinQueryBuilder.NAME, SpanWithinQueryBuilder::new, SpanWithinQueryBuilder::fromXContent));
                .addResultReader(UnmappedSampler.NAME, UnmappedSampler::new),
        namedWriteables.add(  
            new PipelineAggregationSpec(
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
                AdjacencyMatrixAggregationBuilder.NAME,
        registerFetchSubPhase(new ScriptFieldsPhase());
        registerAggregation(
        registerAggregation(
        registerQuery(new QuerySpec<>(DisMaxQueryBuilder.NAME, DisMaxQueryBuilder::new, DisMaxQueryBuilder::fromXContent));
            )
import org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder;
        if (fetchSubPhases.stream().anyMatch(p -> p.getClass().equals(subPhaseClass))) {
    private void registerSuggesters(List<SearchPlugin> plugins) {
                FieldMaskingSpanQueryBuilder::new,  
        registerPipelineAggregation(
            )
                AvgBucketPipelineAggregationBuilder.NAME,
                    IntervalsSourceProvider.class,  
            new NamedXContentRegistry.Entry(BaseAggregationBuilder.class, spec.getName(), (p, c) -> spec.getParser().parse(p, (String) c))
        registerAggregation(
        registerAggregation(
    }  
                AdjacencyMatrixAggregationBuilder::new,  
        registerPipelineAggregation(
                .addResultReader(DoubleTerms.NAME, DoubleTerms::new)  
            Writeable.Reader<? extends InternalAggregation> internalReader = t.getValue();
        registerQuery(new QuerySpec<>(MatchNoneQueryBuilder.NAME, MatchNoneQueryBuilder::new, MatchNoneQueryBuilder::fromXContent));  
            builder
            ).addResultReader(InternalCardinality::new).setAggregatorRegistrar(CardinalityAggregationBuilder::registerAggregators),  
                InternalMax::new
import org.opensearch.index.query.SpanWithinQueryBuilder;
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {  
import org.opensearch.search.aggregations.metrics.InternalSum;
                    IntervalsSourceProvider.Wildcard.NAME,
    }
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;  
            new AggregationSpec(GlobalAggregationBuilder.NAME, GlobalAggregationBuilder::new, GlobalAggregationBuilder::parse)
        registerFromPlugin(plugins, p -> p.getFetchSubPhases(context), this::registerFetchSubPhase);  
        );
     *       When constructed, a static flag is set in Lucene {@link IndexSearcher#setMaxClauseCount} according to the settings.  
        );
    public @Nullable ExecutorService getIndexSearcherExecutor(ThreadPool pool) {  
        namedXContents.add(  
                GeoDistanceAggregationBuilder.NAME,  
            new NamedXContentRegistry.Entry(
        namedWriteables.add(new NamedWriteableRegistry.Entry(DocValueFormat.class, name, reader));
            ).addResultReader(InternalGeoDistance::new).setAggregatorRegistrar(GeoDistanceAggregationBuilder::registerAggregators),  
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedAggregationBuilder;  
        namedWriteables.addAll(getIntervalsSourceProviderNamedWritables());  
            )
        namedWriteables.add(
 *
                    IntervalsSourceProvider.class,
import org.opensearch.search.aggregations.pipeline.MovAvgModel;
            new ScoreFunctionSpec<>(  
        );
            )  
                DiversifiedAggregationBuilder.NAME,
import org.opensearch.search.aggregations.metrics.PercentilesAggregationBuilder;
        );
                    IntervalsSourceProvider.Combine.NAME,
                VariableWidthHistogramAggregationBuilder.NAME,  
            builder
import org.opensearch.search.fetch.FetchPhase;
        registerAggregation(  
                    IntervalsSourceProvider.Fuzzy.NAME,
    }  
                ScriptScoreFunctionBuilder.NAME,
    }  
        registerQuery(
    /**
            if (provider == null) {
            new AggregationSpec(HistogramAggregationBuilder.NAME, HistogramAggregationBuilder::new, HistogramAggregationBuilder.PARSER)  
        registerQuery(
            new PipelineAggregationSpec(  
    private void registerSuggester(SuggesterSpec<?> suggester) {
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(PercentageScore.NAME, PercentageScore::new, PercentageScore.PARSER));  
import org.opensearch.index.query.BoostingQueryBuilder;  
            builder
        );
        );  
        namedWriteables.add(new NamedWriteableRegistry.Entry(SmoothingModel.class, StupidBackoff.NAME, StupidBackoff::new));
    }  
import org.opensearch.search.fetch.subphase.FetchScorePhase;
        registerFromPlugin(plugins, SearchPlugin::getSearchExts, this::registerSearchExt);
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
        registerAggregation(  
        );
        registerQuery(
        return searcher;
        highlighters.register("unified", new UnifiedHighlighter());
        registerQuery(new QuerySpec<>(MatchQueryBuilder.NAME, MatchQueryBuilder::new, MatchQueryBuilder::fromXContent));  
import org.apache.lucene.search.IndexSearcher;
            new PipelineAggregationSpec(
            new NamedWriteableRegistry.Entry(SuggestionBuilder.class, suggester.getName().getPreferredName(), suggester.getReader())  
import org.opensearch.index.query.GeoShapeQueryBuilder;  
            ).setAggregatorRegistrar(StatsAggregationBuilder::registerAggregators),  
import org.opensearch.search.aggregations.bucket.nested.InternalReverseNested;
        registerSort(new SortSpec<>(FieldSortBuilder.NAME, FieldSortBuilder::new, FieldSortBuilder::fromXContentObject));  
import org.opensearch.plugins.SearchPlugin.RescorerSpec;
import org.opensearch.search.aggregations.bucket.histogram.InternalHistogram;
import org.opensearch.search.aggregations.metrics.InternalValueCount;  
            ).addResultReader(InternalTDigestPercentileRanks.NAME, InternalTDigestPercentileRanks::new)
            new PipelineAggregationSpec(  
        registerQuery(new QuerySpec<>(MultiMatchQueryBuilder.NAME, MultiMatchQueryBuilder::new, MultiMatchQueryBuilder::fromXContent));  
        registerFromPlugin(plugins, SearchPlugin::getCollectorContextSpecFactories, QueryCollectorContextSpecRegistry::registerFactory);  
        registerQuery(new QuerySpec<>(WrapperQueryBuilder.NAME, WrapperQueryBuilder::new, WrapperQueryBuilder::fromXContent));
        registerPipelineAggregation(
import org.opensearch.search.fetch.subphase.highlight.Highlighter;  
import org.opensearch.search.aggregations.bucket.terms.SignificantStringTerms;  
import org.opensearch.index.query.functionscore.WeightBuilder;
        if (provider == null) {
                MinBucketPipelineAggregationBuilder.NAME,  
            new NamedXContentRegistry.Entry(SignificanceHeuristic.class, spec.getName(), p -> spec.getParser().apply(p, null))
                .addResultReader(InternalHistogram::new)
    }
    private final Settings settings;  
        ValuesSourceRegistry.Builder builder = new ValuesSourceRegistry.Builder();  
            builder  
        registerSort(new SortSpec<>(ShardDocSortBuilder.NAME, ShardDocSortBuilder::new, ShardDocSortBuilder::fromXContent));
            return spec.getParser().parse(p, name);  
import org.opensearch.search.aggregations.bucket.histogram.InternalVariableWidthHistogram;
import org.opensearch.search.rescore.QueryRescorerBuilder;
            for (T t : producer.apply(plugin)) {
import org.opensearch.search.aggregations.bucket.terms.heuristic.ScriptHeuristic;  
            ).addResultReader(InternalTDigestPercentiles.NAME, InternalTDigestPercentiles::new)
    public ValuesSourceRegistry getValuesSourceRegistry() {
        );
import org.opensearch.plugins.SearchPlugin.SuggesterSpec;
        registerFetchSubPhase(new HighlightPhase(highlighters));
        // after aggs have been registered, see if there are any new VSTypes that need to be linked to core fields
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    private List<SearchPlugin.ProfileMetricsProvider> registerProfilerProviders(List<SearchPlugin> plugins) {  
        highlighters.extractAndRegister(plugins, SearchPlugin::getHighlighters);  
 * software distributed under the License is distributed on an
        namedWriteables.addAll(SortValue.namedWriteables());
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;  
        }
        );
    private void registerShapes() {
                .addResultReader(SignificantLongTerms.NAME, SignificantLongTerms::new)
import org.opensearch.index.query.TermQueryBuilder;  
        );
            ).addResultReader(InternalWeightedAvg::new).setAggregatorRegistrar(WeightedAvgAggregationBuilder::registerUsage),  
            new AggregationSpec(
    public Collection<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactories() {
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .addResultReader(InternalDateRange::new)
        namedWriteables.add(new NamedWriteableRegistry.Entry(SmoothingModel.class, Laplace.NAME, Laplace::new));
        }
                CompletionSuggestionBuilder::new,
            if (registrar != null) {
                CompletionSuggestionBuilder::fromXContent,
                ScriptScoreFunctionBuilder::fromXContent  
        concurrentSearchDeciderFactories = registerConcurrentSearchDeciderFactories(plugins);  
    }  
                DiversifiedAggregationBuilder::new,
import org.opensearch.search.fetch.subphase.highlight.FastVectorHighlighter;
        registerAggregation(
                ExponentialDecayFunctionBuilder::new,
        registerQuery(new QuerySpec<>(SpanFirstQueryBuilder.NAME, SpanFirstQueryBuilder::new, SpanFirstQueryBuilder::fromXContent));
        registerAggregation(
import org.opensearch.index.query.QueryStringQueryBuilder;  
        registerQuery(  
        );
            new AggregationSpec(FiltersAggregationBuilder.NAME, FiltersAggregationBuilder::new, FiltersAggregationBuilder::parse)
                CumulativeSumPipelineAggregationBuilder::new,
                .addResultReader(InternalNested::new),
        return new QueryPhase(queryPhaseSearcher);  
                InternalRange::new
    }
            new AggregationSpec(DateRangeAggregationBuilder.NAME, DateRangeAggregationBuilder::new, DateRangeAggregationBuilder.PARSER)  
        );
    private final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();
            new ScoreFunctionSpec<>(
    }  
    }
            }  
        namedXContents.add(
                new ParseField(CommonTermsQueryBuilder.NAME).withAllDeprecated(COMMON_TERMS_QUERY_DEPRECATION_MSG),
        registerQuery(new QuerySpec<>(RangeQueryBuilder.NAME, RangeQueryBuilder::new, RangeQueryBuilder::fromXContent));  
import static org.opensearch.index.query.CommonTermsQueryBuilder.COMMON_TERMS_QUERY_DEPRECATION_MSG;
import org.opensearch.search.fetch.subphase.FetchFieldsPhase;  
        for (SearchPlugin plugin : plugins) {  
            new SuggesterSpec<>(
            new QuerySpec<>(
import org.opensearch.search.aggregations.metrics.InternalWeightedAvg;
     * @param plugins List of included {@link SearchPlugin} objects.
                .setAggregatorRegistrar(MultiTermsAggregationFactory::registerAggregators),
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
            builder.registerUsage(spec.getName().getPreferredName());
        );  
        registerFromPlugin(plugins, SearchPlugin::getSuggesters, this::registerSuggester);
        return concurrentSearchDeciderFactories;  
        registerPipelineAggregation(
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(GND.NAME, GND::new, GND.PARSER));
    private void registerSignificanceHeuristics(List<SearchPlugin> plugins) {
                MatchPhrasePrefixQueryBuilder::new,
                ExtendedStatsAggregationBuilder::new,  
        return namedWriteables;
import org.opensearch.plugins.SearchPlugin.SearchExtSpec;
import org.opensearch.index.query.MultiMatchQueryBuilder;
                MultiValueDocCountAggregationBuilder::new,
        return movingAverageModelParserRegistry;
                PercentilesBucketPipelineAggregationBuilder.PARSER
            )  
 * license agreements. See the NOTICE file distributed with
                SumBucketPipelineAggregationBuilder.PARSER
import org.opensearch.search.aggregations.bucket.histogram.VariableWidthHistogramAggregationBuilder;  
        namedXContents.add(new NamedXContentRegistry.Entry(SearchExtBuilder.class, spec.getName(), spec.getParser()));
                consumer.accept(t);
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
                PhraseSuggestionBuilder::new,
            new AggregationSpec(  
        registerFetchSubPhases(plugins);
        registerFromPlugin(plugins, SearchPlugin::getMovingAverageModels, this::registerMovingAverageModel);
                .addResultReader(StringRareTerms.NAME, StringRareTerms::new)
import org.opensearch.plugins.SearchPlugin;  
                    IntervalsSourceProvider.Wildcard::new
                scoreFunction.getName().getPreferredName(),
import org.opensearch.search.aggregations.bucket.terms.InternalMultiTerms;
        registerAggregation(
        );
        registerQuery(new QuerySpec<>(TemplateQueryBuilder.NAME, TemplateQueryBuilder::new, TemplateQueryBuilder::fromXContent));  
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
 * The OpenSearch Contributors require contributions made to  
        registerAggregation(
            new ScoreFunctionSpec<>(LinearDecayFunctionBuilder.NAME, LinearDecayFunctionBuilder::new, LinearDecayFunctionBuilder.PARSER)
                    IntervalsSourceProvider.Disjunction::new
        namedXContents.add(
                suggester.getName().getPreferredName(),
        );
        );  
        if (ShapesAvailability.JTS_AVAILABLE && ShapesAvailability.SPATIAL4J_AVAILABLE) {
                AvgBucketPipelineAggregationBuilder.PARSER
        registerMovingAverageModel(new SearchExtensionSpec<>(EwmaModel.NAME, EwmaModel::new, EwmaModel.PARSER));  
                .addResultReader(InternalSimpleValue.NAME, InternalSimpleValue::new)
import org.opensearch.index.query.MatchAllQueryBuilder;
        registerValueFormat(DocValueFormat.RAW.getWriteableName(), in -> DocValueFormat.RAW);
    public FetchPhase getFetchPhase() {
            ).setAggregatorRegistrar(AvgAggregationBuilder::registerAggregators),
        );
            final Optional<ConcurrentSearchRequestDecider.Factory> deciderFactory = plugin.getConcurrentSearchRequestDeciderFactory();
        registerAggregation(  
import org.opensearch.search.fetch.FetchSubPhase;  
        );  
                .addResultReader(InternalFilter::new),
    }
            ).addResultReader(InternalReverseNested::new),
 */
            builder
        );  
            builder  
import org.opensearch.index.query.ConstantScoreQueryBuilder;  
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;
        registerQuery(new QuerySpec<>(MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new, MatchAllQueryBuilder::fromXContent));
    }
    private void registerSearchExts(List<SearchPlugin> plugins) {  
            new NamedWriteableRegistry.Entry(
    private void registerPipelineAggregation(PipelineAggregationSpec spec) {
        for (SearchPlugin plugin : plugins) {
        registerAggregation(
            ).setAggregatorRegistrar(DiversifiedAggregationBuilder::registerAggregators)
                AdjacencyMatrixAggregationBuilder::parse
            )  
import org.opensearch.search.aggregations.bucket.range.InternalGeoDistance;
                PercentileRanksAggregationBuilder.NAME,
import org.opensearch.search.sort.SortValue;  
                MovFnPipelineAggregationBuilder.NAME,
import org.opensearch.index.query.functionscore.ScriptScoreQueryBuilder;
                PhraseSuggestionBuilder.SUGGESTION_NAME,  
        );  
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationFactory;  
            new SignificanceHeuristicSpec<>(MutualInformation.NAME, MutualInformation::new, MutualInformation.PARSER)
                BucketScriptPipelineAggregationBuilder.PARSER  
                .addResultReader(InternalMissing::new)
        registerQuery(new QuerySpec<>(IntervalQueryBuilder.NAME, IntervalQueryBuilder::new, IntervalQueryBuilder::fromXContent));
    private final List<SearchPlugin.ProfileMetricsProvider> pluginProfilerProviders;  
                .setAggregatorRegistrar(reg -> CompositeAggregationBuilder.registerAggregators(reg, plugins)),
import org.opensearch.search.suggest.phrase.LinearInterpolation;  
import org.opensearch.search.aggregations.metrics.InternalTopHits;
        );
        namedWriteables.add(
    private final List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
        Consumer<ValuesSourceRegistry.Builder> register = spec.getAggregatorRegistrar();
            builder
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;
            builder  
                    parser  
        registerMovingAverageModel(new SearchExtensionSpec<>(SimpleModel.NAME, SimpleModel::new, SimpleModel.PARSER));
        namedXContents.add(new NamedXContentRegistry.Entry(QueryBuilder.class, spec.getName(), (p, c) -> spec.getParser().fromXContent(p)));
                    IntervalsSourceProvider.class,
        registerAggregation(  
        );
            new AggregationSpec(MaxAggregationBuilder.NAME, MaxAggregationBuilder::new, MaxAggregationBuilder.PARSER).addResultReader(
import org.opensearch.search.sort.FieldSortBuilder;  
                ScriptScoreFunctionBuilder.NAME,
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
import java.util.function.Function;
            ).addResultReader(SignificantStringTerms.NAME, SignificantStringTerms::new)  
                    IntervalsSourceProvider.class,
        namedWriteables.add(new NamedWriteableRegistry.Entry(QueryBuilder.class, spec.getName().getPreferredName(), spec.getReader()));
    }  
            new QuerySpec<>(SimpleQueryStringBuilder.NAME, SimpleQueryStringBuilder::new, SimpleQueryStringBuilder::fromXContent)  
        registerPipelineAggregation(  
        highlighters.register("plain", new PlainHighlighter());
                AutoDateHistogramAggregationBuilder.NAME,  
import org.opensearch.search.aggregations.metrics.InternalAvg;  
import org.opensearch.common.settings.Settings;  
    private <T extends SignificanceHeuristic> void registerSignificanceHeuristic(SignificanceHeuristicSpec<?> spec) {  
                MovAvgPipelineAggregationBuilder.NAME,
        registerPipelineAggregation(  
        namedXContents.add(new NamedXContentRegistry.Entry(RescorerBuilder.class, spec.getName(), (p, c) -> spec.getParser().apply(p)));
            new AggregationSpec(  
import org.opensearch.index.query.NestedQueryBuilder;  
            builder
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
        }
            builder
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(JLHScore.NAME, JLHScore::new, JLHScore.PARSER));
                TermSuggestion::new  
import org.opensearch.common.geo.GeoShapeType;
        }  
    }
                spec.getName(),
        );  
            if (searcher == null) {
                )
        );
        registerAggregation(
import org.opensearch.common.NamedRegistry;
import java.util.concurrent.ExecutorService;  
        registerPipelineAggregation(  
            // Register is typically handling usage registration, but for the older aggregations that don't use register, we
import org.opensearch.index.query.CommonTermsQueryBuilder;
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;  
                .addResultReader(UnmappedSignificantTerms.NAME, UnmappedSignificantTerms::new)
    }
        namedWriteables.add(new NamedWriteableRegistry.Entry(SortBuilder.class, spec.getName().getPreferredName(), spec.getReader()));  
            new AggregationSpec(
import org.opensearch.search.aggregations.BaseAggregationBuilder;
        registerMovingAverageModel(new SearchExtensionSpec<>(HoltLinearModel.NAME, HoltLinearModel::new, HoltLinearModel.PARSER));
            new AggregationSpec(
import org.opensearch.search.sort.SortBuilder;
        );
        registerAggregation(
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;  
                BucketSortPipelineAggregationBuilder.NAME,  
import org.opensearch.search.aggregations.bucket.sampler.UnmappedSampler;  
                ExtendedStatsAggregationBuilder.PARSER
            )
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        );
                DiversifiedAggregationBuilder.PARSER  
                suggester.getSuggestionReader()
            new AggregationSpec(RangeAggregationBuilder.NAME, RangeAggregationBuilder::new, RangeAggregationBuilder.PARSER).addResultReader(  
        NamedRegistry<Highlighter> highlighters = new NamedRegistry<>("highlighter");
 * not use this file except in compliance with the License.
        for (Map.Entry<String, Writeable.Reader<? extends InternalAggregation>> t : spec.getResultReaders().entrySet()) {
            builder  
                PercentileRanksAggregationBuilder::new,  
    private final ParseFieldRegistry<MovAvgModel.AbstractModelParser> movingAverageModelParserRegistry = new ParseFieldRegistry<>(  
import org.opensearch.search.sort.GeoDistanceSortBuilder;
                CommonTermsQueryBuilder::fromXContent
import org.opensearch.search.aggregations.metrics.InternalMin;
        registerAggregation(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    }
import org.opensearch.index.query.SpanFirstQueryBuilder;  
            /* Uses InternalBucketMetricValue */
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
            builder
                WeightedAvgAggregationBuilder.PARSER
            )  
        );
import org.opensearch.plugins.SearchPlugin.PipelineAggregationSpec;  
import org.opensearch.index.query.MatchPhraseQueryBuilder;
            new PipelineAggregationSpec(
            builder
        if (register != null) {
                registrar.accept(builder);
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
        registerAggregation(
import org.opensearch.index.query.SpanNotQueryBuilder;
                    IntervalsSourceProvider.Combine::new
import org.opensearch.search.aggregations.pipeline.CumulativeSumPipelineAggregationBuilder;  
                .addResultReader(LongRareTerms.NAME, LongRareTerms::new)  
                ScriptScoreFunctionBuilder::new,
        );  
                ScriptScoreFunctionBuilder::new
                .setAggregatorRegistrar(PercentileRanksAggregationBuilder::registerAggregators),
                .addResultReader(InternalBinaryRange::new)
import java.util.function.Consumer;
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;  
        registerScoreFunction(
        registerQuery(new QuerySpec<>(SpanGapQueryBuilder.NAME, SpanGapQueryBuilder::new, SpanGapQueryBuilder::fromXContent));  
            new AggregationSpec(  
    );
import org.opensearch.search.aggregations.metrics.MultiValueDocCountAggregationBuilder;
                new NamedWriteableRegistry.Entry(
            ).setAggregatorRegistrar(RangeAggregationBuilder::registerAggregators),
        );
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.SpanOrQueryBuilder;
        registerAggregation(  
        );
        registerMovingAverageModel(new SearchExtensionSpec<>(HoltWintersModel.NAME, HoltWintersModel::new, HoltWintersModel.PARSER));
        registerAggregation(  
import org.opensearch.search.aggregations.metrics.PercentileRanksAggregationBuilder;  
                SumBucketPipelineAggregationBuilder.NAME,
        );
/**
            new AggregationSpec(RareTermsAggregationBuilder.NAME, RareTermsAggregationBuilder::new, RareTermsAggregationBuilder.PARSER)  
                MovFnPipelineAggregationBuilder::new,  
                WeightedAvgAggregationBuilder::new,
    }
        registerValueFormat(DocValueFormat.IP.getWriteableName(), in -> DocValueFormat.IP);  
                new NamedWriteableRegistry.Entry(  
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;
            new QuerySpec<>(  
                StatsBucketPipelineAggregationBuilder.PARSER  
                GeoDistanceSortBuilder::new,
            new AggregationSpec(  
    }  
        List<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories = new ArrayList<>();  
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        registerAggregation(
                StatsBucketPipelineAggregationBuilder.NAME,
                new NamedWriteableRegistry.Entry(
 * compatible open source license.
        }
            new AggregationSpec(
        );
        registerQuery(  
            new QuerySpec<>(SpanContainingQueryBuilder.NAME, SpanContainingQueryBuilder::new, SpanContainingQueryBuilder::fromXContent)
        registerQuery(new QuerySpec<>(BoolQueryBuilder.NAME, BoolQueryBuilder::new, BoolQueryBuilder::fromXContent));
        );  
            }  
                RandomScoreFunctionBuilder::fromXContent  
        namedWriteables.add(new NamedWriteableRegistry.Entry(ScoreFunctionBuilder.class, WeightBuilder.NAME, WeightBuilder::new));
                // This bucket is used by many pipeline aggreations.  
        );  
import org.opensearch.search.aggregations.bucket.terms.UnmappedSignificantTerms;
        registerQuery(new QuerySpec<>(BoostingQueryBuilder.NAME, BoostingQueryBuilder::new, BoostingQueryBuilder::fromXContent));  
        );
 */  
            builder  
                StringTerms::new
        if (ShapesAvailability.JTS_AVAILABLE && ShapesAvailability.SPATIAL4J_AVAILABLE) {
        registerPipelineAggregation(
import org.opensearch.search.aggregations.pipeline.BucketScriptPipelineAggregationBuilder;  
        return highlighters;
import org.opensearch.search.aggregations.bucket.terms.LongRareTerms;  
    private final Map<String, Highlighter> highlighters;
            new AggregationSpec(SamplerAggregationBuilder.NAME, SamplerAggregationBuilder::new, SamplerAggregationBuilder::parse)  
        "moving_avg_model"
import org.opensearch.index.query.DistanceFeatureQueryBuilder;
        registerAggregation(
        registerMovingAverageModels(plugins);  
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
        registerAggregation(
        registerScoreFunction(  
            new PipelineAggregationSpec(
        registerSearchExts(plugins);  
import org.opensearch.search.aggregations.pipeline.BucketSelectorPipelineAggregationBuilder;
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
        registerQueryParsers(plugins);  
    }  
    }  
import org.opensearch.search.aggregations.bucket.nested.InternalNested;  
            }
        );
import org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder;
                .addResultReader(LongTerms.NAME, LongTerms::new)
        );
                PercentilesAggregationBuilder::parse  
            new ScoreFunctionSpec<>(
            String writeableName = t.getKey();  
import org.opensearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;
        );  
        registerFetchSubPhase(new MatchedQueriesPhase());
        registerFetchSubPhase(new ExplainPhase());  
import org.opensearch.common.Nullable;  
        );
            throw new IllegalArgumentException("FetchSubPhase [" + subPhaseClass + "] already registered");  
        registerFromPlugin(plugins, SearchPlugin::getAggregationExtentions, (registrar) -> {  
                RandomScoreFunctionBuilder.NAME,
import org.opensearch.index.query.IntervalQueryBuilder;
    }  
            new AggregationSpec(
            builder  
                .setAggregatorRegistrar(TermsAggregationBuilder::registerAggregators),
    }
        registerQuery(new QuerySpec<>(SpanNearQueryBuilder.NAME, SpanNearQueryBuilder::new, SpanNearQueryBuilder::fromXContent));
            builder
                ScriptScoreFunctionBuilder.class,  
import org.opensearch.search.aggregations.bucket.terms.SignificantTextAggregationBuilder;
        registerAggregation(  
            )
        // weight doesn't have its own parser, so every function supports it out of the box.
            ).setAggregatorRegistrar(MaxAggregationBuilder::registerAggregators),  
        registerQuery(  
                GeoCentroidAggregationBuilder.NAME,
            builder
        registerQuery(new QuerySpec<>(SpanNotQueryBuilder.NAME, SpanNotQueryBuilder::new, SpanNotQueryBuilder::fromXContent));
import org.opensearch.search.fetch.subphase.highlight.PlainHighlighter;
                SerialDiffPipelineAggregationBuilder::new,
    }  
}
                .setAggregatorRegistrar(RareTermsAggregationBuilder::registerAggregators),
                DateHistogramAggregationBuilder.NAME,
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
import org.opensearch.plugins.SearchPlugin.FetchPhaseConstructionContext;
     * Returns the concurrent search decider factories that the plugins have registered  
                FieldMaskingSpanQueryBuilder::fromXContent
        FetchPhaseConstructionContext context = new FetchPhaseConstructionContext(highlighters);
import org.opensearch.threadpool.ThreadPool;
        registerFetchSubPhase(new SeqNoPrimaryTermPhase());  
 * KIND, either express or implied.  See the License for the
                VariableWidthHistogramAggregationBuilder.PARSER
        registerValueFormat(DocValueFormat.BINARY.getWriteableName(), in -> DocValueFormat.BINARY);
import org.opensearch.search.aggregations.pipeline.InternalPercentilesBucket;
            ).addResultReader(InternalGeoCentroid::new).setAggregatorRegistrar(GeoCentroidAggregationBuilder::registerAggregators),
 *
                new NamedWriteableRegistry.Entry(  
    private void registerFetchSubPhases(List<SearchPlugin> plugins) {
        );  
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
        );
import org.opensearch.search.query.QueryPhaseSearcherWrapper;  
            new NamedWriteableRegistry.Entry(PipelineAggregationBuilder.class, spec.getName().getPreferredName(), spec.getReader())
    }
     */
        );
                .addResultReader(InternalValueCount::new)
import org.opensearch.index.query.RangeQueryBuilder;
        );  
     * Register a new ValueFormat.
                MaxBucketPipelineAggregationBuilder.NAME,  
            new AggregationSpec(
                    IntervalsSourceProvider.class,
                    IntervalsSourceProvider.Prefix.NAME,
        );
            new PipelineAggregationSpec(
            builder  
        namedXContents.add(  
        indexSearcherExecutorProvider = registerIndexSearcherExecutorProvider(plugins);
        registerRescorer(new RescorerSpec<>(QueryRescorerBuilder.NAME, QueryRescorerBuilder::new, QueryRescorerBuilder::fromXContent));
        queryPhaseSearcher = registerQueryPhaseSearcher(plugins);  
import java.util.ArrayList;  
import org.opensearch.index.query.RegexpQueryBuilder;
                SignificantTextAggregationBuilder::parse
import org.opensearch.search.aggregations.pipeline.BucketSortPipelineAggregationBuilder;
                DateHistogramAggregationBuilder.PARSER  
import org.opensearch.index.query.TemplateQueryBuilder;
import org.opensearch.core.common.io.stream.Writeable;
                ExtendedStatsBucketPipelineAggregationBuilder.NAME,
        registerQuery(  
        SearchPlugin.ExecutorServiceProvider provider = null;  
                new NamedWriteableRegistry.Entry(
        return pluginProfilerProviders;
    private void registerRescorers(List<SearchPlugin> plugins) {
        registerAggregation(  
        registerFetchSubPhase(new FetchScorePhase());  
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
            builder
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;  
import org.opensearch.search.aggregations.bucket.range.InternalDateRange;
                    IntervalsSourceProvider.class,
        registerAggregation(
                TermSuggestionBuilder::fromXContent,
    private void registerMovingAverageModel(SearchExtensionSpec<MovAvgModel, MovAvgModel.AbstractModelParser> movAvgModel) {
                BucketSelectorPipelineAggregationBuilder::parse
                .addResultReader(UnmappedTerms.NAME, UnmappedTerms::new)
    }
                .setAggregatorRegistrar(ValueCountAggregationBuilder::registerAggregators),
        );  
            new AggregationSpec(
import org.opensearch.search.fetch.subphase.SeqNoPrimaryTermPhase;  
        registerSuggesters(plugins);  
        highlighters.register("fvh", new FastVectorHighlighter(settings));  
     */  
import org.opensearch.index.query.PrefixQueryBuilder;
                MultiValueDocCountAggregationBuilder.PARSER
import org.opensearch.search.query.QueryCollectorContextSpecRegistry;  
            new AggregationSpec(CompositeAggregationBuilder.NAME, CompositeAggregationBuilder::new, CompositeAggregationBuilder.PARSER)
        }  
        namedXContents.add(new NamedXContentRegistry.Entry(SuggestionBuilder.class, suggester.getName(), suggester.getParser()));
import org.opensearch.search.aggregations.metrics.InternalExtendedStats;
                    IntervalsSourceProvider.Regexp.NAME,  
        );  
import org.opensearch.plugins.SearchPlugin.SignificanceHeuristicSpec;  
import org.opensearch.search.aggregations.pipeline.HoltWintersModel;  
        );  
                MedianAbsoluteDeviationAggregationBuilder.PARSER
        return unmodifiableMap(highlighters.getRegistry());
                CumulativeSumPipelineAggregationBuilder.PARSER
import org.opensearch.search.aggregations.metrics.InternalGeoCentroid;  
                .setAggregatorRegistrar(AutoDateHistogramAggregationBuilder::registerAggregators),
                StatsBucketPipelineAggregationBuilder::new,
                MultiValueDocCountAggregationBuilder.NAME,  
 * @opensearch.internal
    /**
                ),
    }  
 * Modifications Copyright OpenSearch Contributors. See
        registerAggregation(
            new PipelineAggregationSpec(
            )
import org.opensearch.index.query.WrapperQueryBuilder;
        if (searcher == null) {
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
    }  
                .setAggregatorRegistrar(MedianAbsoluteDeviationAggregationBuilder::registerAggregators),
        registerQuery(new QuerySpec<>(TermsQueryBuilder.NAME, TermsQueryBuilder::new, TermsQueryBuilder::fromXContent));  
                SignificantTextAggregationBuilder.NAME,
            Arrays.asList(
            // have to register usage explicitly here.  
        registerScoreFunction(
        } else {
                CumulativeSumPipelineAggregationBuilder.NAME,  
        QueryPhaseSearcher searcher = null;
        registerValueFormat(DocValueFormat.UNSIGNED_LONG.getWriteableName(), in -> DocValueFormat.UNSIGNED_LONG);
    private void registerScoreFunction(ScoreFunctionSpec<?> scoreFunction) {  
        registerQuery(  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
                    IntervalsSourceProvider.Prefix::new  
                .addResultReader(UnmappedRareTerms.NAME, UnmappedRareTerms::new)
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;
    }
