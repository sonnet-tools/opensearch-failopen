        registerScoreFunction(
        );
        registerPipelineAggregation(
        this.valuesSourceRegistry = registerAggregations(plugins);
        registerAggregation(
import org.opensearch.index.query.SpanNearQueryBuilder;
            )
import org.opensearch.index.query.SpanMultiTermQueryBuilder;
import org.opensearch.index.query.SpanNotQueryBuilder;
                WeightedAvgAggregationBuilder.NAME,
                RandomScoreFunctionBuilder::fromXContent
        namedWriteables.addAll(SortValue.namedWriteables());
        registerQuery(new QuerySpec<>(SpanNearQueryBuilder.NAME, SpanNearQueryBuilder::new, SpanNearQueryBuilder::fromXContent));
        registerSort(new SortSpec<>(ScriptSortBuilder.NAME, ScriptSortBuilder::new, ScriptSortBuilder::fromXContent));
import org.opensearch.search.fetch.subphase.highlight.FastVectorHighlighter;
public class SearchModule {
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.opensearch.search.aggregations.bucket.histogram.InternalHistogram;
            )
            }
            )
                WeightedAvgAggregationBuilder::new,
import org.opensearch.index.query.MatchPhraseQueryBuilder;
            ).addResultReader(InternalDateHistogram::new).setAggregatorRegistrar(DateHistogramAggregationBuilder::registerAggregators),
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
            new QuerySpec<>(MatchBoolPrefixQueryBuilder.NAME, MatchBoolPrefixQueryBuilder::new, MatchBoolPrefixQueryBuilder::fromXContent)
import org.opensearch.search.aggregations.pipeline.BucketSelectorPipelineAggregationBuilder;
import org.opensearch.search.fetch.FetchPhase;
        registerAggregation(
            )
    }
        return builder.build();
    }
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
        // Can be a single function too when not associated to any other function, which is why it needs to be registered manually here.
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.aggregations.bucket.adjacency.InternalAdjacencyMatrix;
        namedWriteables.add(new NamedWriteableRegistry.Entry(SmoothingModel.class, StupidBackoff.NAME, StupidBackoff::new));
                .addResultReader(LongTerms.NAME, LongTerms::new)
import org.opensearch.search.fetch.subphase.FetchScorePhase;
import org.opensearch.search.aggregations.pipeline.MovAvgPipelineAggregationBuilder;
        registerQuery(new QuerySpec<>(MatchQueryBuilder.NAME, MatchQueryBuilder::new, MatchQueryBuilder::fromXContent));
import org.opensearch.index.query.WrapperQueryBuilder;
        registerMovingAverageModel(new SearchExtensionSpec<>(SimpleModel.NAME, SimpleModel::new, SimpleModel.PARSER));
import org.opensearch.index.query.NestedQueryBuilder;
            ).addResultReader(InternalAutoDateHistogram::new)
            new AggregationSpec(CompositeAggregationBuilder.NAME, CompositeAggregationBuilder::new, CompositeAggregationBuilder.PARSER)
 * Unless required by applicable law or agreed to in writing,
                    IntervalsSourceProvider.class,
    private final ParseFieldRegistry<MovAvgModel.AbstractModelParser> movingAverageModelParserRegistry = new ParseFieldRegistry<>(
        );
        concurrentSearchDeciderFactories = registerConcurrentSearchDeciderFactories(plugins);
    private void registerRescorer(RescorerSpec<?> spec) {
            ).addResultReader(InternalGeoCentroid::new).setAggregatorRegistrar(GeoCentroidAggregationBuilder::registerAggregators),
import org.opensearch.index.query.GeoShapeQueryBuilder;
            return spec.getParser().parse(p, name);
        registerQuery(new QuerySpec<>(SpanOrQueryBuilder.NAME, SpanOrQueryBuilder::new, SpanOrQueryBuilder::fromXContent));
        return (indexSearcherExecutorProvider != null) ? indexSearcherExecutorProvider.getExecutor(pool) : null;
        registerFromPlugin(plugins, SearchPlugin::getScoreFunctions, this::registerScoreFunction);
        }
            )
        registerValueFormat(DocValueFormat.UNSIGNED_LONG.getWriteableName(), in -> DocValueFormat.UNSIGNED_LONG);
                new NamedWriteableRegistry.Entry(
    }
        );
import org.opensearch.search.aggregations.pipeline.MovAvgModel;
    }
        );
                DerivativePipelineAggregationBuilder.NAME,
            )
            new PipelineAggregationSpec(
import org.opensearch.search.aggregations.metrics.PercentilesAggregationBuilder;
        registerPipelineAggregation(
        );
import org.opensearch.search.aggregations.BaseAggregationBuilder;
        registerValueFormat(DocValueFormat.UNSIGNED_LONG_SHIFTED.getWriteableName(), in -> DocValueFormat.UNSIGNED_LONG_SHIFTED);
        for (SearchPlugin plugin : plugins) {
import org.opensearch.search.suggest.Suggest;
        );
import org.opensearch.index.query.QueryStringQueryBuilder;
                SerialDiffPipelineAggregationBuilder::parse
        }
            /* Uses InternalSimpleValue */
    }
 */
                ReverseNestedAggregationBuilder::parse
 * not use this file except in compliance with the License.
import org.opensearch.index.query.MatchAllQueryBuilder;
        registerQuery(
        );
 * specific language governing permissions and limitations
    private void registerSearchExts(List<SearchPlugin> plugins) {
        return valuesSourceRegistry;
                ExtendedStatsAggregationBuilder::new,
    }
            builder
    private ValuesSourceRegistry registerAggregations(List<SearchPlugin> plugins) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
                    IntervalsSourceProvider.Wildcard::new
                FieldMaskingSpanQueryBuilder.SPAN_FIELD_MASKING_FIELD,
import org.opensearch.plugins.SearchPlugin.SearchExtensionSpec;
        );
import org.opensearch.search.fetch.subphase.highlight.HighlightPhase;
import org.opensearch.search.aggregations.metrics.InternalTopHits;
                (p, c) -> spec.getParser().fromXContent(p, spec.getName().getPreferredName())
            }
                (XContentParser p, Object c) -> scoreFunction.getParser().fromXContent(p)
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
                registrar.accept(builder);
            deciderFactory.ifPresent(concurrentSearchDeciderFactories::add);
            builder
        registerFetchSubPhase(new SeqNoPrimaryTermPhase());
        namedXContents.add(
        registerSort(new SortSpec<>(ScoreSortBuilder.NAME, ScoreSortBuilder::new, ScoreSortBuilder::fromXContent));
        namedXContents.add(new NamedXContentRegistry.Entry(QueryBuilder.class, spec.getName(), (p, c) -> spec.getParser().fromXContent(p)));
import org.opensearch.search.aggregations.bucket.range.InternalRange;
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
            ).addResultReader(InternalPercentilesBucket::new)
                .setAggregatorRegistrar(MedianAbsoluteDeviationAggregationBuilder::registerAggregators),
        );
        registerQuery(new QuerySpec<>(TermsQueryBuilder.NAME, TermsQueryBuilder::new, TermsQueryBuilder::fromXContent));
            new PipelineAggregationSpec(
                TermSuggestionBuilder::new,
        registerFromPlugin(plugins, SearchPlugin::getCollectorContextSpecFactories, QueryCollectorContextSpecRegistry::registerFactory);
            builder
        namedWriteables.add(new NamedWriteableRegistry.Entry(SearchExtBuilder.class, spec.getName().getPreferredName(), spec.getReader()));
        );
                ScriptScoreFunctionBuilder.NAME,
                .addResultReader(DoubleTerms.NAME, DoubleTerms::new)
import org.opensearch.search.sort.SortValue;
                SumBucketPipelineAggregationBuilder.NAME,
            new NamedWriteableRegistry.Entry(
 * this work for additional information regarding copyright
                StringTerms::new
            } else if (searcherOpt.isPresent()) {
import org.opensearch.plugins.SearchPlugin.PipelineAggregationSpec;
        registerSort(
        for (Map.Entry<String, Writeable.Reader<? extends InternalAggregation>> resultReader : spec.getResultReaders().entrySet()) {
import org.opensearch.common.NamedRegistry;
    }
                .setAggregatorRegistrar(AutoDateHistogramAggregationBuilder::registerAggregators),
                FieldValueFactorFunctionBuilder::new,
        registerPipelineAggregation(
import org.opensearch.common.geo.GeoShapeType;
import java.util.ArrayList;
import org.opensearch.search.query.QueryPhase;
    private void registerSuggesters(List<SearchPlugin> plugins) {
            new PipelineAggregationSpec(
    public FetchPhase getFetchPhase() {
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(PercentageScore.NAME, PercentageScore::new, PercentageScore.PARSER));
            new AggregationSpec(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.opensearch.search.aggregations.bucket.sampler.UnmappedSampler;
                InternalRange::new
    /**
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
        registerQuery(new QuerySpec<>(BoostingQueryBuilder.NAME, BoostingQueryBuilder::new, BoostingQueryBuilder::fromXContent));
package org.opensearch.search;
        registerQuery(new QuerySpec<>(ExistsQueryBuilder.NAME, ExistsQueryBuilder::new, ExistsQueryBuilder::fromXContent));
import org.opensearch.search.aggregations.bucket.missing.InternalMissing;
        registerAggregation(
        registerValueFormat(DocValueFormat.GEOHASH.getWriteableName(), in -> DocValueFormat.GEOHASH);
        registerAggregation(
        highlighters.register("fvh", new FastVectorHighlighter(settings));
            searcher = new QueryPhaseSearcherWrapper();
            throw new IllegalArgumentException("FetchSubPhase [" + subPhaseClass + "] already registered");
                InternalMin::new
                CommonTermsQueryBuilder::fromXContent
import java.util.List;
                TermSuggestionBuilder.SUGGESTION_NAME,
                consumer.accept(t);
        registerFromPlugin(plugins, SearchPlugin::getRescorers, this::registerRescorer);
            namedWriteables.addAll(GeoShapeType.getShapeWriteables());
                suggester.getName().getPreferredName(),
        );
        registerIntervalsSourceProviders();
import static org.opensearch.index.query.CommonTermsQueryBuilder.COMMON_TERMS_QUERY_DEPRECATION_MSG;
                new NamedWriteableRegistry.Entry(InternalAggregation.class, resultReader.getKey(), resultReader.getValue())
                RandomScoreFunctionBuilder::new,
        registerMovingAverageModel(new SearchExtensionSpec<>(HoltWintersModel.NAME, HoltWintersModel::new, HoltWintersModel.PARSER));
                AutoDateHistogramAggregationBuilder::new,
 * You may obtain a copy of the License at
import org.opensearch.plugins.SearchPlugin.AggregationSpec;
    }
import org.opensearch.search.aggregations.metrics.InternalGeoCentroid;
            new AggregationSpec(HistogramAggregationBuilder.NAME, HistogramAggregationBuilder::new, HistogramAggregationBuilder.PARSER)
            new ScoreFunctionSpec<>(
        namedWriteables.add(
import org.opensearch.common.geo.ShapesAvailability;
        );
    }
            )
                )
        movingAverageModelParserRegistry.register(movAvgModel.getParser(), movAvgModel.getName());
                ScoreFunctionBuilder.class,
import org.opensearch.index.query.MatchQueryBuilder;
        registerFromPlugin(plugins, SearchPlugin::getQueries, this::registerQuery);
        );
        registerAggregation(
import org.opensearch.search.fetch.subphase.MatchedQueriesPhase;
import org.opensearch.search.sort.FieldSortBuilder;
            new QuerySpec<>(DistanceFeatureQueryBuilder.NAME, DistanceFeatureQueryBuilder::new, DistanceFeatureQueryBuilder::fromXContent)
    private final List<SearchPlugin.ProfileMetricsProvider> pluginProfilerProviders;
        registerQuery(new QuerySpec<>(TermsSetQueryBuilder.NAME, TermsSetQueryBuilder::new, TermsSetQueryBuilder::fromXContent));
            new AggregationSpec(FiltersAggregationBuilder.NAME, FiltersAggregationBuilder::new, FiltersAggregationBuilder::parse)
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;
            builder
        registerAggregation(
                .addResultReader(InternalBinaryRange::new)
                CompletionSuggestionBuilder.SUGGESTION_NAME,
import org.opensearch.index.query.IntervalsSourceProvider;
        registerAggregation(
                .addResultReader(InternalMultiTerms::new)
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedAggregationBuilder;
        namedXContents.add(new NamedXContentRegistry.Entry(BaseAggregationBuilder.class, spec.getName(), (p, c) -> {
        registerScoreFunctions(plugins);
        // ScriptScoreFunctionBuilder has it own named writable because of a new script_score query
import org.opensearch.search.suggest.completion.CompletionSuggestion;
        registerFetchSubPhase(new ExplainPhase());
    private <T extends SignificanceHeuristic> void registerSignificanceHeuristic(SignificanceHeuristicSpec<?> spec) {
    public QueryPhase getQueryPhase() {
                .addResultReader(InternalComposite::new)
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
                    IntervalsSourceProvider.Regexp::new
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
        return searcher;
/*
        );
     * Returns the {@link Highlighter} registry
        registerQuery(new QuerySpec<>(MatchPhraseQueryBuilder.NAME, MatchPhraseQueryBuilder::new, MatchPhraseQueryBuilder::fromXContent));
    }
import org.opensearch.search.aggregations.metrics.InternalCardinality;
    }
    private void registerQuery(QuerySpec<?> spec) {
                ExponentialDecayFunctionBuilder::new,
import org.opensearch.search.aggregations.metrics.PercentileRanksAggregationBuilder;
                SignificantTermsAggregationBuilder::parse
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;
import org.opensearch.search.aggregations.metrics.InternalScriptedMetric;
                CommonTermsQueryBuilder::new,
            new ScoreFunctionSpec<>(
                CompletionSuggestionBuilder::fromXContent,
        registerQuery(new QuerySpec<>(IdsQueryBuilder.NAME, IdsQueryBuilder::new, IdsQueryBuilder::fromXContent));
        registerAggregation(
                // This bucket is used by many pipeline aggreations.
            new PipelineAggregationSpec(
                GeoDistanceSortBuilder::new,
            new AggregationSpec(
                CumulativeSumPipelineAggregationBuilder.PARSER
        registerQuery(
    }
                ScriptedMetricAggregationBuilder::new,
            builder
        registerPipelineAggregations(plugins);
 * Licensed to Elasticsearch under one or more contributor
        return plugins.stream().map(SearchPlugin::getQueryProfileMetricsProvider).filter(Optional::isPresent).map(Optional::get).toList();
    private void registerFetchSubPhase(FetchSubPhase subPhase) {
import org.opensearch.index.query.SpanWithinQueryBuilder;
                .addResultReader(InternalMissing::new)
        registerQuery(new QuerySpec<>(SpanTermQueryBuilder.NAME, SpanTermQueryBuilder::new, SpanTermQueryBuilder::fromXContent));
        );
        namedWriteables.add(
                    "The index searcher executor is already assigned but more than one are provided by the plugins"
                WeightedAvgAggregationBuilder.PARSER
            new ScoreFunctionSpec<>(LinearDecayFunctionBuilder.NAME, LinearDecayFunctionBuilder::new, LinearDecayFunctionBuilder.PARSER)
    private void registerPipelineAggregations(List<SearchPlugin> plugins) {
import org.opensearch.search.suggest.phrase.Laplace;
            builder
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
import org.opensearch.index.query.RangeQueryBuilder;
    }
            new AggregationSpec(
                new ParseField(GeoDistanceSortBuilder.NAME, GeoDistanceSortBuilder.ALTERNATIVE_NAME),
            ).setAggregatorRegistrar(MinAggregationBuilder::registerAggregators),
    }
        registerAggregation(
    }
                PhraseSuggestionBuilder.SUGGESTION_NAME,
            ).setAggregatorRegistrar(MaxAggregationBuilder::registerAggregators),
                .setAggregatorRegistrar(PercentileRanksAggregationBuilder::registerAggregators),
        );
            builder
            new AggregationSpec(
        registerAggregation(
                PercentileRanksAggregationBuilder.NAME,
        registerQuery(new QuerySpec<>(ScriptScoreQueryBuilder.NAME, ScriptScoreQueryBuilder::new, ScriptScoreQueryBuilder::fromXContent));
    }
        registerSortParsers(plugins);
        );
        );
            new AggregationSpec(SumAggregationBuilder.NAME, SumAggregationBuilder::new, SumAggregationBuilder.PARSER).addResultReader(
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
            builder
        highlighters.register("unified", new UnifiedHighlighter());
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
import org.opensearch.core.xcontent.XContentParser;
                GeoCentroidAggregationBuilder::new,
import org.opensearch.search.aggregations.bucket.nested.InternalReverseNested;
            new AggregationSpec(
import org.opensearch.search.aggregations.PipelineAggregationBuilder;
/*
import java.util.Optional;
            new NamedWriteableRegistry.Entry(PipelineAggregationBuilder.class, spec.getName().getPreferredName(), spec.getReader())
                DiversifiedAggregationBuilder::new,
            ).addResultReader(InternalValueCount::new).setAggregatorRegistrar(MultiValueDocCountAggregationBuilder::registerAggregators),
            )
            new NamedXContentRegistry.Entry(BaseAggregationBuilder.class, spec.getName(), (p, c) -> spec.getParser().parse(p, (String) c))
        }
        );
import org.opensearch.search.sort.ScriptSortBuilder;
import org.opensearch.search.fetch.subphase.FetchFieldsPhase;
                PercentileRanksAggregationBuilder::parse
        registerFromPlugin(plugins, SearchPlugin::getSearchExts, this::registerSearchExt);
import org.opensearch.index.query.DisMaxQueryBuilder;
            builder
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
            new NamedXContentRegistry.Entry(
        registerFromPlugin(plugins, SearchPlugin::getAggregations, (agg) -> this.registerAggregation(agg, builder));
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                .addResultReader(InternalDateRange::new)
        highlighters = setupHighlighters(settings, plugins);
                AdjacencyMatrixAggregationBuilder::new,
        return movingAverageModelParserRegistry;
            new PipelineAggregationSpec(
        );
import org.opensearch.index.query.IdsQueryBuilder;
import org.opensearch.index.query.CombinedFieldsQueryBuilder;
            new AggregationSpec(ValueCountAggregationBuilder.NAME, ValueCountAggregationBuilder::new, ValueCountAggregationBuilder.PARSER)
        registerValueFormat(DocValueFormat.BOOLEAN.getWriteableName(), in -> DocValueFormat.BOOLEAN);
    }
            provider = (ThreadPool threadPool) -> threadPool.executor(INDEX_SEARCHER);
    /**
    private void registerRescorers(List<SearchPlugin> plugins) {
import org.opensearch.search.aggregations.bucket.histogram.VariableWidthHistogramAggregationBuilder;
        namedWriteables.add(
        registerAggregation(
                PercentilesAggregationBuilder::new,
                MaxBucketPipelineAggregationBuilder.PARSER
        registerAggregation(
        );
        namedXContents.add(new NamedXContentRegistry.Entry(SuggestionBuilder.class, suggester.getName(), suggester.getParser()));
    public SearchModule(Settings settings, List<SearchPlugin> plugins) {
import org.opensearch.search.suggest.phrase.SmoothingModel;
    public static List<NamedWriteableRegistry.Entry> getIntervalsSourceProviderNamedWritables() {
            builder
                AvgBucketPipelineAggregationBuilder.PARSER
                PercentilesBucketPipelineAggregationBuilder::new,
import org.opensearch.index.query.RegexpQueryBuilder;
        registerSuggester(
                FieldMaskingSpanQueryBuilder::new,
    }
                InternalAvg::new
import org.opensearch.search.aggregations.bucket.terms.InternalMultiTerms;
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
        );
import org.opensearch.search.fetch.FetchSubPhase;
import org.opensearch.index.query.MatchNoneQueryBuilder;
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
 * Sets up things that can be done at search time like queries, aggregations, and suggesters.
                MultiValueDocCountAggregationBuilder.PARSER
            new AggregationSpec(DateRangeAggregationBuilder.NAME, DateRangeAggregationBuilder::new, DateRangeAggregationBuilder.PARSER)
                PercentilesAggregationBuilder::parse
import org.opensearch.search.fetch.subphase.FetchSourcePhase;
        }
        );
                throw new IllegalStateException("Only one QueryPhaseSearcher is allowed, but more than one are provided by the plugins");
import org.opensearch.search.aggregations.pipeline.EwmaModel;
                .addResultReader(InternalHDRPercentileRanks.NAME, InternalHDRPercentileRanks::new)
import org.opensearch.core.common.io.stream.Writeable;
            new QuerySpec<>(MoreLikeThisQueryBuilder.NAME, MoreLikeThisQueryBuilder::new, MoreLikeThisQueryBuilder::fromXContent)
            new QuerySpec<>(CombinedFieldsQueryBuilder.NAME, CombinedFieldsQueryBuilder::new, CombinedFieldsQueryBuilder::fromXContent)
 * KIND, either express or implied.  See the License for the
                StatsBucketPipelineAggregationBuilder.NAME,
import org.opensearch.search.aggregations.bucket.terms.SignificantTextAggregationBuilder;
        registerFromPlugin(plugins, SearchPlugin::getMovingAverageModels, this::registerMovingAverageModel);
        NamedRegistry<Highlighter> highlighters = new NamedRegistry<>("highlighter");
    private <T> void registerFromPlugin(List<SearchPlugin> plugins, Function<SearchPlugin, List<T>> producer, Consumer<T> consumer) {
        );
        );
    private final Map<String, Highlighter> highlighters;
        registerSuggester(
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;
import org.opensearch.search.aggregations.bucket.histogram.InternalVariableWidthHistogram;
            )
import org.opensearch.search.fetch.subphase.FetchDocValuesPhase;
        namedWriteables.add(new NamedWriteableRegistry.Entry(SmoothingModel.class, Laplace.NAME, Laplace::new));
                scoreFunction.getName().getPreferredName(),
                BucketSelectorPipelineAggregationBuilder::new,
        return concurrentSearchDeciderFactories;
                .setAggregatorRegistrar(DateRangeAggregationBuilder::registerAggregators),
                CompletionSuggestion::new
        );
import org.opensearch.search.aggregations.bucket.terms.UnmappedTerms;
     *       When constructed, a static flag is set in Lucene {@link IndexSearcher#setMaxClauseCount} according to the settings.
        registerFromPlugin(plugins, SearchPlugin::getSignificanceHeuristics, this::registerSignificanceHeuristic);
        registerQuery(new QuerySpec<>(PrefixQueryBuilder.NAME, PrefixQueryBuilder::new, PrefixQueryBuilder::fromXContent));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
import java.util.Arrays;
        return concurrentSearchDeciderFactories;
            ).addResultReader(InternalMedianAbsoluteDeviation::new)
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
import org.opensearch.search.aggregations.metrics.InternalMin;
        namedXContents.add(new NamedXContentRegistry.Entry(RescorerBuilder.class, spec.getName(), (p, c) -> spec.getParser().apply(p)));
import org.opensearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;
import org.opensearch.search.aggregations.bucket.nested.InternalNested;
        registerAggregation(
        return pluginProfilerProviders;
    }
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
            builder
            new PipelineAggregationSpec(
            new AggregationSpec(MissingAggregationBuilder.NAME, MissingAggregationBuilder::new, MissingAggregationBuilder.PARSER)
        registerAggregation(
            )
import org.opensearch.index.query.CommonTermsQueryBuilder;
                    IntervalsSourceProvider.Fuzzy::new
    }
import org.opensearch.index.query.TermsQueryBuilder;
            new AggregationSpec(
        registerFetchSubPhase(new MatchedQueriesPhase());
                    IntervalsSourceProvider.Combine.NAME,
            builder
     */
                CardinalityAggregationBuilder::new,
                new ParseField(CommonTermsQueryBuilder.NAME).withAllDeprecated(COMMON_TERMS_QUERY_DEPRECATION_MSG),
        );
        registerQuery(new QuerySpec<>(SpanNotQueryBuilder.NAME, SpanNotQueryBuilder::new, SpanNotQueryBuilder::fromXContent));
        );
        namedWriteables.add(
            /* Reuses result readers from SamplerAggregator*/,
                .addResultReader(InternalTopHits::new),
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
        namedXContents.add(
                MovAvgPipelineAggregationBuilder.NAME,
                MatchPhrasePrefixQueryBuilder::new,
            new AggregationSpec(TermsAggregationBuilder.NAME, TermsAggregationBuilder::new, TermsAggregationBuilder.PARSER).addResultReader(
    public List<SearchPlugin.ProfileMetricsProvider> getPluginProfileMetricsProviders() {
        registerQuery(new QuerySpec<>(WildcardQueryBuilder.NAME, WildcardQueryBuilder::new, WildcardQueryBuilder::fromXContent));
        );
                MedianAbsoluteDeviationAggregationBuilder.NAME,
            ).addResultReader(InternalTDigestPercentiles.NAME, InternalTDigestPercentiles::new)
                .addResultReader(InternalHistogram::new)
                SignificantTextAggregationBuilder::new,
        namedWriteables.add(new NamedWriteableRegistry.Entry(ScoreFunctionBuilder.class, WeightBuilder.NAME, WeightBuilder::new));
    }
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
    }
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.opensearch.index.query.functionscore.WeightBuilder;
                CardinalityAggregationBuilder.PARSER
import org.opensearch.search.aggregations.bucket.terms.StringRareTerms;
 *
import org.opensearch.search.aggregations.bucket.terms.UnmappedSignificantTerms;
            builder
    private void registerSort(SortSpec<?> spec) {
                    movingAverageModelParserRegistry,
        registerFetchSubPhases(plugins);
import org.opensearch.search.aggregations.metrics.InternalSum;
            ),
                new NamedWriteableRegistry.Entry(
            builder
        );
            } else if (providerOpt.isPresent()) {
        registerFromPlugin(plugins, SearchPlugin::getAggregationExtentions, (registrar) -> {
                SortBuilder.class,
import java.util.Map;
        registerQueryCollectorContextSpec(plugins);
            ).setAggregatorRegistrar(AvgAggregationBuilder::registerAggregators),
                    IntervalsSourceProvider.class,
            builder
            new AggregationSpec(SamplerAggregationBuilder.NAME, SamplerAggregationBuilder::new, SamplerAggregationBuilder::parse)
import org.opensearch.plugins.SearchPlugin.QuerySpec;
            new PipelineAggregationSpec(
        );
            builder
                .addResultReader(UnmappedRareTerms.NAME, UnmappedRareTerms::new)
            new AggregationSpec(
        registerRescorer(new RescorerSpec<>(QueryRescorerBuilder.NAME, QueryRescorerBuilder::new, QueryRescorerBuilder::fromXContent));
                CumulativeSumPipelineAggregationBuilder.NAME,
            new NamedWriteableRegistry.Entry(
                DateHistogramAggregationBuilder::new,
import org.opensearch.index.query.ExistsQueryBuilder;
    }
            )
                    name,
        );
        registerFromPlugin(plugins, SearchPlugin::getSorts, this::registerSort);
                DerivativePipelineAggregationBuilder::parse
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
                ),
            )
                .addResultReader(InternalFilters::new),
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
                ScriptScoreFunctionBuilder.NAME,
                    IntervalsSourceProvider.Disjunction::new
            ).addResultReader(InternalCardinality::new).setAggregatorRegistrar(CardinalityAggregationBuilder::registerAggregators),
            new SuggesterSpec<>(
import org.opensearch.plugins.SearchPlugin.SignificanceHeuristicSpec;
                BucketScriptPipelineAggregationBuilder.NAME,
import org.opensearch.search.aggregations.metrics.InternalWeightedAvg;
        registerQuery(new QuerySpec<>(NestedQueryBuilder.NAME, NestedQueryBuilder::new, NestedQueryBuilder::fromXContent));
        registerPipelineAggregation(
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;
                scoreFunction.getReader()
     */
                    IntervalsSourceProvider.Match.NAME,
        }
import org.opensearch.search.aggregations.metrics.InternalMax;
            final Optional<QueryPhaseSearcher> searcherOpt = plugin.getQueryPhaseSearcher();
                DerivativePipelineAggregationBuilder::new,
        registerSignificanceHeuristics(plugins);
            )
                PercentilesBucketPipelineAggregationBuilder.PARSER
 * compatible open source license.
    private final List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
        for (SearchPlugin plugin : plugins) {
    }
        );
                InternalMax::new
    private Map<String, Highlighter> setupHighlighters(Settings settings, List<SearchPlugin> plugins) {
            new AggregationSpec(
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
    private void registerIntervalsSourceProviders() {
import org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder;
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
            if (searcher == null) {
import java.util.function.Function;
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationFactory;
import org.opensearch.search.aggregations.pipeline.InternalExtendedStatsBucket;
            new PipelineAggregationSpec(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        registerPipelineAggregation(
        registerSuggester(
        registerAggregation(
import org.opensearch.index.query.ConstantScoreQueryBuilder;
                    IntervalsSourceProvider.class,
                GeoDistanceAggregationBuilder::parse
        registerPipelineAggregation(
                StringTerms.NAME,
                MultiValueDocCountAggregationBuilder::new,
import java.util.Collection;
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
    private void registerQueryCollectorContextSpec(List<SearchPlugin> plugins) {
        );
import org.opensearch.index.query.IntervalQueryBuilder;
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        return new FetchPhase(fetchSubPhases);
                MaxBucketPipelineAggregationBuilder.NAME,
                searcher = searcherOpt.orElse(null);
        );
                ExtendedStatsAggregationBuilder.PARSER
                .addResultReader(InternalSampler.NAME, InternalSampler::new)
    }
        registerFetchSubPhase(new FetchVersionPhase());
    /**
    }
 * Modifications Copyright OpenSearch Contributors. See
            builder
                MedianAbsoluteDeviationAggregationBuilder::new,
        registerPipelineAggregation(
    }
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
import static org.opensearch.threadpool.ThreadPool.Names.INDEX_SEARCHER;
        registerAggregation(
                MatchPhrasePrefixQueryBuilder::fromXContent
            new ScoreFunctionSpec<>(
            namedWriteables.add(new NamedWriteableRegistry.Entry(InternalAggregation.class, writeableName, internalReader));
        if (provider == null) {
                AdjacencyMatrixAggregationBuilder::parse
        registerRescorers(plugins);
            new AggregationSpec(NestedAggregationBuilder.NAME, NestedAggregationBuilder::new, NestedAggregationBuilder::parse)
 */
                ScriptedMetricAggregationBuilder.NAME,
        registerQuery(new QuerySpec<>(GeoDistanceQueryBuilder.NAME, GeoDistanceQueryBuilder::new, GeoDistanceQueryBuilder::fromXContent));
            String name = (String) c;
import org.opensearch.index.query.TemplateQueryBuilder;
            new NamedXContentRegistry.Entry(SignificanceHeuristic.class, spec.getName(), p -> spec.getParser().apply(p, null))
            ).addResultReader(InternalExtendedStatsBucket::new)
        registerAggregation(
                PercentileRanksAggregationBuilder::new,
 *
        );
            new QuerySpec<>(GeoBoundingBoxQueryBuilder.NAME, GeoBoundingBoxQueryBuilder::new, GeoBoundingBoxQueryBuilder::fromXContent)
    private void registerSearchExt(SearchExtSpec<?> spec) {
                SignificantTextAggregationBuilder.NAME,
import org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder;
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(JLHScore.NAME, JLHScore::new, JLHScore.PARSER));
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
import org.opensearch.search.aggregations.bucket.range.InternalDateRange;
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;
        registerPipelineAggregation(
        );
        registerAggregation(
                BucketSelectorPipelineAggregationBuilder.NAME,
        namedWriteables.addAll(getIntervalsSourceProviderNamedWritables());
    }
import org.opensearch.search.aggregations.metrics.InternalStats;
            builder
import org.opensearch.plugins.SearchPlugin.RescorerSpec;
        registerAggregation(
    /**
            if (provider == null) {
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        return provider;
        "moving_avg_model"
            builder
            builder
                TermSuggestion::new
import org.opensearch.index.query.MultiMatchQueryBuilder;
import org.opensearch.plugins.SearchPlugin.FetchPhaseConstructionContext;
        registerFetchSubPhase(new HighlightPhase(highlighters));
            )/* Uses InternalHistogram for buckets */
                provider = providerOpt.orElse(null);
            builder
        namedWriteables.add(
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        );
        }));
import org.opensearch.search.suggest.term.TermSuggestion;
    private void registerShapes() {
                MovAvgPipelineAggregationBuilder::new,
import org.opensearch.search.suggest.phrase.StupidBackoff;
        return namedXContents;
        );
            builder
    public List<NamedXContentRegistry.Entry> getNamedXContents() {
            )
    private Collection<ConcurrentSearchRequestDecider.Factory> registerConcurrentSearchDeciderFactories(List<SearchPlugin> plugins) {
import org.opensearch.search.aggregations.bucket.terms.heuristic.PercentageScore;
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
import org.opensearch.index.query.FieldMaskingSpanQueryBuilder;
            new AggregationSpec(
    private SearchPlugin.ExecutorServiceProvider registerIndexSearcherExecutorProvider(List<SearchPlugin> plugins) {
import java.util.concurrent.ExecutorService;
                MinBucketPipelineAggregationBuilder::new,
            builder
            new QuerySpec<>(
                DateHistogramAggregationBuilder.NAME,
        this.settings = settings;
            new PipelineAggregationSpec(
     */
                RandomScoreFunctionBuilder.NAME,
        registerSignificanceHeuristic(
import org.opensearch.index.query.ScriptQueryBuilder;
                BucketScriptPipelineAggregationBuilder::new,
        );
                ExtendedStatsAggregationBuilder.NAME,
                    IntervalsSourceProvider.Disjunction.NAME,
                SignificantTermsAggregationBuilder.NAME,
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
        }
import org.opensearch.search.fetch.subphase.SeqNoPrimaryTermPhase;
/**
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(ChiSquare.NAME, ChiSquare::new, ChiSquare.PARSER));
                .addResultReader(UnmappedSampler.NAME, UnmappedSampler::new),
                .setAggregatorRegistrar(HistogramAggregationBuilder::registerAggregators),
            new AggregationSpec(IpRangeAggregationBuilder.NAME, IpRangeAggregationBuilder::new, IpRangeAggregationBuilder.PARSER)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            new AggregationSpec(StatsAggregationBuilder.NAME, StatsAggregationBuilder::new, StatsAggregationBuilder.PARSER).addResultReader(
        }
            builder
    private final Settings settings;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
}
    private final ValuesSourceRegistry valuesSourceRegistry;
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;
            new AggregationSpec(
                    parser
        registerAggregation(
import org.opensearch.search.suggest.SuggestionBuilder;
        highlighters.extractAndRegister(plugins, SearchPlugin::getHighlighters);
                ScriptScoreFunctionBuilder::new
        }
        for (SearchPlugin plugin : plugins) {
import org.opensearch.index.query.functionscore.ScriptScoreQueryBuilder;
import org.opensearch.index.query.TermQueryBuilder;
            new PipelineAggregationSpec(
        namedWriteables.add(new NamedWriteableRegistry.Entry(DocValueFormat.class, name, reader));
import org.opensearch.search.aggregations.metrics.InternalAvg;
            ).setAggregatorRegistrar(DiversifiedAggregationBuilder::registerAggregators)
        registerFetchSubPhase(new FetchScorePhase());
        registerQuery(
        registerQuery(new QuerySpec<>(MatchNoneQueryBuilder.NAME, MatchNoneQueryBuilder::new, MatchNoneQueryBuilder::fromXContent));
import org.opensearch.index.query.BoolQueryBuilder;
        registerScoreFunction(
        registerScoreFunction(
                new NamedWriteableRegistry.Entry(
                FieldValueFactorFunctionBuilder::fromXContent
 */
     * Register a new ValueFormat.
            new AggregationSpec(MaxAggregationBuilder.NAME, MaxAggregationBuilder::new, MaxAggregationBuilder.PARSER).addResultReader(
            Arrays.asList(
     */
    }
            ).addResultReader(SignificantStringTerms.NAME, SignificantStringTerms::new)
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
            builder
                .setAggregatorRegistrar(MultiTermsAggregationFactory::registerAggregators),
                FieldMaskingSpanQueryBuilder::fromXContent
            new NamedXContentRegistry.Entry(
        registerAggregation(
            )
 * @opensearch.internal
        );
        registerAggregation(
                BucketSelectorPipelineAggregationBuilder::parse
import org.opensearch.common.settings.Settings;
        registerScoreFunction(
                ExtendedStatsBucketPipelineAggregationBuilder.NAME,
            new AggregationSpec(
            builder
                .addResultReader(InternalValueCount::new)
            // Register is typically handling usage registration, but for the older aggregations that don't use register, we
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
    }
                GeoCentroidAggregationBuilder.NAME,
                MedianAbsoluteDeviationAggregationBuilder.PARSER
        registerScoreFunction(
        );
import org.opensearch.search.aggregations.pipeline.InternalPercentilesBucket;
        );
                GeoDistanceAggregationBuilder.NAME,
            new QuerySpec<>(FunctionScoreQueryBuilder.NAME, FunctionScoreQueryBuilder::new, FunctionScoreQueryBuilder::fromXContent)
        registerFetchSubPhase(new FetchSourcePhase());
                new ExtendedStatsBucketParser()
            new AggregationSpec(
                MatchPhrasePrefixQueryBuilder.NAME,
                InternalSum::new
    }
        namedWriteables.add(new NamedWriteableRegistry.Entry(SortBuilder.class, spec.getName().getPreferredName(), spec.getReader()));
        );
        registerAggregation(
        FetchPhaseConstructionContext context = new FetchPhaseConstructionContext(highlighters);
import org.opensearch.search.aggregations.pipeline.BucketScriptPipelineAggregationBuilder;
import org.opensearch.search.aggregations.pipeline.InternalStatsBucket;
                ),
            )
                // This bucket is used by many pipeline aggreations.
            Writeable.Reader<? extends InternalAggregation> internalReader = t.getValue();
        );
        registerAggregation(
                    IntervalsSourceProvider.class,
                SignificantTermsAggregationBuilder::new,
        registerAggregation(
        );
import org.opensearch.search.aggregations.metrics.InternalExtendedStats;
import org.opensearch.index.query.BoostingQueryBuilder;
            builder
                StatsBucketPipelineAggregationBuilder.PARSER
import org.opensearch.search.aggregations.pipeline.SimpleModel;
                .addResultReader(LongRareTerms.NAME, LongRareTerms::new)
                AutoDateHistogramAggregationBuilder.PARSER
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        registerAggregation(
    public @Nullable ExecutorService getIndexSearcherExecutor(ThreadPool pool) {
        registerSearchExts(plugins);
        );
import org.opensearch.index.query.SimpleQueryStringBuilder;
        }
                throw new IllegalStateException(
import org.opensearch.search.aggregations.pipeline.HoltLinearModel;
        );
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
        registerQuery(new QuerySpec<>(TemplateQueryBuilder.NAME, TemplateQueryBuilder::new, TemplateQueryBuilder::fromXContent));
        );
        );
                DiversifiedAggregationBuilder.NAME,
        }
 *
                .setAggregatorRegistrar(SignificantTermsAggregationBuilder::registerAggregators),
        registerQuery(new QuerySpec<>(RangeQueryBuilder.NAME, RangeQueryBuilder::new, RangeQueryBuilder::fromXContent));
        namedWriteables.add(new NamedWriteableRegistry.Entry(QueryBuilder.class, spec.getName().getPreferredName(), spec.getReader()));
            new SortSpec<>(
 * under the License.
        );
import static java.util.Objects.requireNonNull;
            ).addResultReader(InternalDerivative::new)
                .addResultReader(StringRareTerms.NAME, StringRareTerms::new)
            )
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
import org.opensearch.search.aggregations.bucket.terms.SignificantLongTerms;
            new QuerySpec<>(
                ExponentialDecayFunctionBuilder.PARSER
            new AggregationSpec(GlobalAggregationBuilder.NAME, GlobalAggregationBuilder::new, GlobalAggregationBuilder::parse)
        );
                PercentilesAggregationBuilder.NAME,
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
    private void registerSortParsers(List<SearchPlugin> plugins) {
                BucketScriptPipelineAggregationBuilder.PARSER
import org.opensearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram;
import org.opensearch.search.aggregations.pipeline.MovFnPipelineAggregationBuilder;
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
                scoreFunction.getName(),
        registerFetchSubPhase(new FetchFieldsPhase());
import org.opensearch.search.aggregations.pipeline.CumulativeSumPipelineAggregationBuilder;
            new QuerySpec<>(ConstantScoreQueryBuilder.NAME, ConstantScoreQueryBuilder::new, ConstantScoreQueryBuilder::fromXContent)
import org.opensearch.common.Nullable;
                InternalStats::new
            new PipelineAggregationSpec(
import org.opensearch.index.query.functionscore.FieldValueFactorFunctionBuilder;
            builder
                MultiValueDocCountAggregationBuilder.NAME,
                .setAggregatorRegistrar(PercentilesAggregationBuilder::registerAggregators),
            new AggregationSpec(
            ).addResultReader(InternalAdjacencyMatrix::new),
                BucketSortPipelineAggregationBuilder.NAME,
                ScriptScoreFunctionBuilder::new,
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
                .addResultReader(InternalNested::new),
            ).setAggregatorRegistrar(RangeAggregationBuilder::registerAggregators),
        registerAggregation(
    private final Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories;
        registerQuery(new QuerySpec<>(SpanWithinQueryBuilder.NAME, SpanWithinQueryBuilder::new, SpanWithinQueryBuilder::fromXContent));
        registerPipelineAggregation(
    private void registerValueFormat(String name, Writeable.Reader<? extends DocValueFormat> reader) {
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
    }
            final Optional<ConcurrentSearchRequestDecider.Factory> deciderFactory = plugin.getConcurrentSearchRequestDeciderFactory();
        queryPhaseSearcher = registerQueryPhaseSearcher(plugins);
import org.opensearch.search.aggregations.metrics.InternalValueCount;
            ).addResultReader(InternalTDigestPercentileRanks.NAME, InternalTDigestPercentileRanks::new)
import org.opensearch.common.xcontent.ParseFieldRegistry;
                .addResultReader(UnmappedSignificantTerms.NAME, UnmappedSignificantTerms::new)
import org.opensearch.search.aggregations.pipeline.HoltWintersModel;
        registerMovingAverageModel(new SearchExtensionSpec<>(HoltLinearModel.NAME, HoltLinearModel::new, HoltLinearModel.PARSER));
 * software distributed under the License is distributed on an
    /**
import org.opensearch.search.aggregations.bucket.terms.heuristic.ScriptHeuristic;
            new SignificanceHeuristicSpec<>(MutualInformation.NAME, MutualInformation::new, MutualInformation.PARSER)
        Class<?> subPhaseClass = subPhase.getClass();
import org.opensearch.plugins.SearchPlugin.SearchExtSpec;
    private void registerFetchSubPhases(List<SearchPlugin> plugins) {
        );
            new SuggesterSpec<>(
                    IntervalsSourceProvider.class,
            new AggregationSpec(
                AvgBucketPipelineAggregationBuilder::new,
        registerValueFormat(DocValueFormat.IP.getWriteableName(), in -> DocValueFormat.IP);
            new AggregationSpec(
    private final List<FetchSubPhase> fetchSubPhases = new ArrayList<>();
 */
                ),
        );
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.index.query.SpanOrQueryBuilder;
            )
                .setAggregatorRegistrar(RareTermsAggregationBuilder::registerAggregators),
        highlighters.register("plain", new PlainHighlighter());
import org.opensearch.search.sort.ShardDocSortBuilder;
        );
    private final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();
    }
            new AggregationSpec(RangeAggregationBuilder.NAME, RangeAggregationBuilder::new, RangeAggregationBuilder.PARSER).addResultReader(
import org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder;
        );
            new AggregationSpec(
            new NamedWriteableRegistry.Entry(SuggestionBuilder.class, suggester.getName().getPreferredName(), suggester.getReader())
            for (T t : producer.apply(plugin)) {
            new AggregationSpec(
                CardinalityAggregationBuilder.NAME,
    public Collection<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactories() {
        registerQuery(
                DiversifiedAggregationBuilder.PARSER
                Suggest.Suggestion.class,
            new PipelineAggregationSpec(
        registerQuery(
        registerQuery(new QuerySpec<>(IntervalQueryBuilder.NAME, IntervalQueryBuilder::new, IntervalQueryBuilder::fromXContent));
    }
        registerQuery(
import org.opensearch.index.query.SpanTermQueryBuilder;
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
import org.opensearch.search.aggregations.metrics.MultiValueDocCountAggregationBuilder;
        if (ShapesAvailability.JTS_AVAILABLE && ShapesAvailability.SPATIAL4J_AVAILABLE) {
        registerMovingAverageModel(new SearchExtensionSpec<>(EwmaModel.NAME, EwmaModel::new, EwmaModel.PARSER));
        registerAggregation(
        if (fetchSubPhases.stream().anyMatch(p -> p.getClass().equals(subPhaseClass))) {
    }
                ScriptScoreFunctionBuilder.class,
                ExtendedStatsBucketPipelineAggregationBuilder::new,
        registerShapes();
            ).addResultReader(InternalStatsBucket::new)
import org.opensearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;
            builder.registerUsage(spec.getName().getPreferredName());
                    IntervalsSourceProvider.Match::new
            new AggregationSpec(AvgAggregationBuilder.NAME, AvgAggregationBuilder::new, AvgAggregationBuilder.PARSER).addResultReader(
            )
            String writeableName = t.getKey();
        return namedWriteables;
        registerValueFormats();
        );
import org.opensearch.plugins.SearchPlugin.SuggesterSpec;
    }
            new AggregationSpec(
    }
        registerValueFormat(DocValueFormat.RAW.getWriteableName(), in -> DocValueFormat.RAW);
        registerQuery(
        registerQuery(
        registerAggregation(
            ).addResultReader(InternalVariableWidthHistogram::new)
            ).addResultReader(InternalGeoDistance::new).setAggregatorRegistrar(GeoDistanceAggregationBuilder::registerAggregators),
     * Returns the concurrent search decider factories that the plugins have registered
        return unmodifiableMap(highlighters.getRegistry());
                BucketSortPipelineAggregationBuilder::new,
                CumulativeSumPipelineAggregationBuilder::new,
import org.opensearch.search.aggregations.pipeline.AvgBucketPipelineAggregationBuilder;
        );
                MovFnPipelineAggregationBuilder.NAME,
    private void registerMovingAverageModel(SearchExtensionSpec<MovAvgModel, MovAvgModel.AbstractModelParser> movAvgModel) {
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(GND.NAME, GND::new, GND.PARSER));
        // after aggs have been registered, see if there are any new VSTypes that need to be linked to core fields
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
    private void registerScoreFunction(ScoreFunctionSpec<?> scoreFunction) {
            new AggregationSpec(MultiTermsAggregationBuilder.NAME, MultiTermsAggregationBuilder::new, MultiTermsAggregationBuilder.PARSER)
    private void registerScoreFunctions(List<SearchPlugin> plugins) {
        registerQuery(new QuerySpec<>(MultiMatchQueryBuilder.NAME, MultiMatchQueryBuilder::new, MultiMatchQueryBuilder::fromXContent));
        }
    private final SearchPlugin.ExecutorServiceProvider indexSearcherExecutorProvider;
            namedWriteables.add(
        );
                new NamedWriteableRegistry.Entry(
import org.opensearch.index.query.MoreLikeThisQueryBuilder;
                .setAggregatorRegistrar(TermsAggregationBuilder::registerAggregators),
            new SuggesterSpec<>(
     * @param plugins List of included {@link SearchPlugin} objects.
            )
        namedWriteables.add(
     * @param settings Current settings
            )
import org.opensearch.search.suggest.phrase.LinearInterpolation;
        registerScoreFunction(
            builder
                PercentilesBucketPipelineAggregationBuilder.NAME,
            register.accept(builder);
        QueryPhaseSearcher searcher = null;
        );
            )
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
                PhraseSuggestionBuilder::new,
        );
import org.opensearch.search.aggregations.InternalAggregation;
        registerAggregation(
        namedXContents.add(
        registerFromPlugin(plugins, p -> p.getFetchSubPhases(context), this::registerFetchSubPhase);
            builder
                GeoCentroidAggregationBuilder.PARSER
     */
import org.opensearch.search.query.QueryCollectorContextSpecRegistry;
            )
import static java.util.Collections.unmodifiableList;
        registerPipelineAggregation(
                ScriptedMetricAggregationBuilder.PARSER
            builder
            if (registrar != null) {
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
        registerSort(new SortSpec<>(FieldSortBuilder.NAME, FieldSortBuilder::new, FieldSortBuilder::fromXContentObject));
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
            ).setAggregatorRegistrar(SumAggregationBuilder::registerAggregators),
import org.opensearch.index.query.SpanFirstQueryBuilder;
                SignificantTextAggregationBuilder::parse
        );
                PhraseSuggestionBuilder::fromXContent,
        registerAggregation(
        );
                .setAggregatorRegistrar(IpRangeAggregationBuilder::registerAggregators),
        });
        registerSignificanceHeuristic(new SignificanceHeuristicSpec<>(ScriptHeuristic.NAME, ScriptHeuristic::new, ScriptHeuristic.PARSER));
 *
import static java.util.Collections.unmodifiableMap;
                PhraseSuggestion::new
        registerAggregation(
            builder
    public ValuesSourceRegistry getValuesSourceRegistry() {
import org.opensearch.search.fetch.subphase.ScriptFieldsPhase;
                VariableWidthHistogramAggregationBuilder.NAME,
                StatsBucketPipelineAggregationBuilder::new,
                BucketSortPipelineAggregationBuilder::parse
     * Constructs a new SearchModule object
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
    );
                new NamedWriteableRegistry.Entry(
        registerQuery(
import org.opensearch.search.rescore.RescorerBuilder;
        );
import org.opensearch.search.sort.ScoreSortBuilder;
        return unmodifiableList(
                .addResultReader(InternalBucketMetricValue.NAME, InternalBucketMetricValue::new)
import org.opensearch.search.fetch.subphase.highlight.UnifiedHighlighter;
        registerQuery(new QuerySpec<>(SpanGapQueryBuilder.NAME, SpanGapQueryBuilder::new, SpanGapQueryBuilder::fromXContent));
                ScoreFunctionBuilder.class,
import org.opensearch.search.aggregations.bucket.terms.UnmappedRareTerms;
        } else {
            /* Uses InternalBucketMetricValue */
        registerAggregation(
            new QuerySpec<>(SimpleQueryStringBuilder.NAME, SimpleQueryStringBuilder::new, SimpleQueryStringBuilder::fromXContent)
            new ScoreFunctionSpec<>(GaussDecayFunctionBuilder.NAME, GaussDecayFunctionBuilder::new, GaussDecayFunctionBuilder.PARSER)
        registerMovingAverageModel(new SearchExtensionSpec<>(LinearModel.NAME, LinearModel::new, LinearModel.PARSER));
            )
                CompletionSuggestionBuilder::new,
        registerQuery(new QuerySpec<>(BoolQueryBuilder.NAME, BoolQueryBuilder::new, BoolQueryBuilder::fromXContent));
                )
                GeoDistanceSortBuilder::fromXContent
import org.opensearch.search.aggregations.pipeline.LinearModel;
        registerQuery(new QuerySpec<>(WrapperQueryBuilder.NAME, WrapperQueryBuilder::new, WrapperQueryBuilder::fromXContent));
 * license agreements. See the NOTICE file distributed with
        );
    public ParseFieldRegistry<MovAvgModel.AbstractModelParser> getMovingAverageModelParserRegistry() {
    private void registerAggregation(AggregationSpec spec, ValuesSourceRegistry.Builder builder) {
                    IntervalsSourceProvider.Wildcard.NAME,
        for (Map.Entry<String, Writeable.Reader<? extends InternalAggregation>> t : spec.getResultReaders().entrySet()) {
                MaxBucketPipelineAggregationBuilder::new,
                SerialDiffPipelineAggregationBuilder::new,
                );
        // weight doesn't have its own parser, so every function supports it out of the box.
                .setAggregatorRegistrar(reg -> CompositeAggregationBuilder.registerAggregators(reg, plugins)),
            }
        registerPipelineAggregation(
        );
        pluginProfilerProviders = registerProfilerProviders(plugins);
        }
            )
        );
                ReverseNestedAggregationBuilder.NAME,
        registerAggregation(
/*
                    IntervalsSourceProvider.Combine::new
                MovFnPipelineAggregationBuilder.PARSER
        registerQuery(
            new AggregationSpec(FilterAggregationBuilder.NAME, FilterAggregationBuilder::new, FilterAggregationBuilder::parse)
            builder
    private void registerPipelineAggregation(PipelineAggregationSpec spec) {
import org.opensearch.search.query.QueryPhaseSearcher;
        registerFetchSubPhase(new FetchDocValuesPhase());
        );
        for (SearchPlugin plugin : plugins) {
        );
            new QuerySpec<>(SpanContainingQueryBuilder.NAME, SpanContainingQueryBuilder::new, SpanContainingQueryBuilder::fromXContent)
import org.opensearch.search.aggregations.pipeline.MinBucketPipelineAggregationBuilder;
            new NamedWriteableRegistry.Entry(MovAvgModel.class, movAvgModel.getName().getPreferredName(), movAvgModel.getReader())
        fetchSubPhases.add(requireNonNull(subPhase, "FetchSubPhase must not be null"));
        );
            final Optional<SearchPlugin.ExecutorServiceProvider> providerOpt = plugin.getIndexSearcherExecutorProvider();
                    IntervalsSourceProvider.Prefix::new
        indexSearcherExecutorProvider = registerIndexSearcherExecutorProvider(plugins);
     * The registry of {@link MovAvgModel}s.
    }
        namedXContents.add(
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
                ),
import org.opensearch.core.ParseField;
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketParser;
            ).setAggregatorRegistrar(StatsAggregationBuilder::registerAggregators),
                SerialDiffPipelineAggregationBuilder.NAME,
                suggester.getSuggestionReader()
        Consumer<ValuesSourceRegistry.Builder> register = spec.getAggregatorRegistrar();
import org.opensearch.index.query.PrefixQueryBuilder;
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
        registerQuery(new QuerySpec<>(SpanFirstQueryBuilder.NAME, SpanFirstQueryBuilder::new, SpanFirstQueryBuilder::fromXContent));
import org.apache.lucene.search.IndexSearcher;
                .addResultReader(InternalGlobal::new),
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
        return new QueryPhase(queryPhaseSearcher);
            new QuerySpec<>(
import org.opensearch.plugins.SearchPlugin.ScoreFunctionSpec;
import org.opensearch.search.fetch.subphase.ExplainPhase;
        registerSuggesters(plugins);
            ).addResultReader(InternalScriptedMetric::new),
                AutoDateHistogramAggregationBuilder.NAME,
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        ValuesSourceRegistry.Builder builder = new ValuesSourceRegistry.Builder();
            // have to register usage explicitly here.
            ).addResultReader(InternalExtendedStats::new).setAggregatorRegistrar(ExtendedStatsAggregationBuilder::registerAggregators),
import org.opensearch.search.aggregations.pipeline.SumBucketPipelineAggregationBuilder;
                .addResultReader(UnsignedLongTerms.NAME, UnsignedLongTerms::new)
        registerSort(new SortSpec<>(ShardDocSortBuilder.NAME, ShardDocSortBuilder::new, ShardDocSortBuilder::fromXContent));
        );
import org.opensearch.index.query.GeoDistanceQueryBuilder;
            )
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;
            new ScoreFunctionSpec<>(
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
            )
        List<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories = new ArrayList<>();
        registerQuery(new QuerySpec<>(TermQueryBuilder.NAME, TermQueryBuilder::new, TermQueryBuilder::fromXContent));
        );
        SearchPlugin.ExecutorServiceProvider provider = null;
import org.opensearch.search.aggregations.bucket.terms.RareTermsAggregationBuilder;
    private void registerValueFormats() {
            new AggregationSpec(MinAggregationBuilder.NAME, MinAggregationBuilder::new, MinAggregationBuilder.PARSER).addResultReader(
                ReverseNestedAggregationBuilder::new,
import org.opensearch.search.rescore.QueryRescorerBuilder;
        );
        registerQueryParsers(plugins);
                ExponentialDecayFunctionBuilder.NAME,
        );
        );
                .addResultReader(InternalHDRPercentiles.NAME, InternalHDRPercentiles::new)
        );
                new NamedWriteableRegistry.Entry(
            new PipelineAggregationSpec(
        registerValueFormat(DocValueFormat.GEOTILE.getWriteableName(), in -> DocValueFormat.GEOTILE);
                SumBucketPipelineAggregationBuilder::new,
            ).addResultReader(InternalReverseNested::new),
                FieldValueFactorFunctionBuilder.NAME,
        registerPipelineAggregation(
        registerPipelineAggregation(
    private void registerQueryParsers(List<SearchPlugin> plugins) {
                TermSuggestionBuilder::fromXContent,
        namedWriteables.add(new NamedWriteableRegistry.Entry(RescorerBuilder.class, spec.getName().getPreferredName(), spec.getReader()));
    }
            ).addResultReader(InternalWeightedAvg::new).setAggregatorRegistrar(WeightedAvgAggregationBuilder::registerUsage),
            builder
        registerAggregation(
            builder
            )
                .setAggregatorRegistrar(VariableWidthHistogramAggregationBuilder::registerAggregators),
import org.opensearch.search.aggregations.metrics.InternalMedianAbsoluteDeviation;
                .addResultReader(UnmappedTerms.NAME, UnmappedTerms::new)
                (XContentParser parser, String name) -> MovAvgPipelineAggregationBuilder.parse(
        namedWriteables.add(
        registerSmoothingModels(namedWriteables);
import org.opensearch.search.fetch.subphase.FetchVersionPhase;
        registerFromPlugin(plugins, SearchPlugin::getPipelineAggregations, this::registerPipelineAggregation);
                SumBucketPipelineAggregationBuilder.PARSER
    }
import org.opensearch.index.query.GeoPolygonQueryBuilder;
                    IntervalsSourceProvider.Prefix.NAME,
            new PipelineAggregationSpec(
import org.opensearch.index.query.FuzzyQueryBuilder;
            builder
            registerQuery(new QuerySpec<>(GeoShapeQueryBuilder.NAME, GeoShapeQueryBuilder::new, GeoShapeQueryBuilder::fromXContent));
        registerQuery(
            new NamedWriteableRegistry.Entry(SignificanceHeuristic.class, spec.getName().getPreferredName(), spec.getReader())
        return highlighters;
        registerQuery(new QuerySpec<>(DisMaxQueryBuilder.NAME, DisMaxQueryBuilder::new, DisMaxQueryBuilder::fromXContent));
                    IntervalsSourceProvider.class,
        registerPipelineAggregation(
        );
            builder
        if (ShapesAvailability.JTS_AVAILABLE && ShapesAvailability.SPATIAL4J_AVAILABLE) {
        registerFromPlugin(plugins, SearchPlugin::getSuggesters, this::registerSuggester);
        );
import org.opensearch.index.query.WildcardQueryBuilder;
        namedXContents.add(new NamedXContentRegistry.Entry(SearchExtBuilder.class, spec.getName(), spec.getParser()));
import org.opensearch.search.aggregations.bucket.range.InternalBinaryRange;
        registerValueFormat(DocValueFormat.BINARY.getWriteableName(), in -> DocValueFormat.BINARY);
                MinBucketPipelineAggregationBuilder.PARSER
import org.opensearch.search.query.QueryPhaseSearcherWrapper;
                    IntervalsSourceProvider.class,
                .addResultReader(InternalFilter::new),
        );
        );
                spec.getName(),
import org.opensearch.plugins.SearchPlugin;
        // TODO remove funky contexts
        registerPipelineAggregation(
     * <p>
            new NamedWriteableRegistry.Entry(
                VariableWidthHistogramAggregationBuilder.PARSER
    private final QueryPhaseSearcher queryPhaseSearcher;
import org.opensearch.search.sort.SortBuilder;
        );
import org.opensearch.search.aggregations.pipeline.InternalDerivative;
                    IntervalsSourceProvider.Fuzzy.NAME,
import java.util.function.Consumer;
            builder
        registerQuery(new QuerySpec<>(QueryStringQueryBuilder.NAME, QueryStringQueryBuilder::new, QueryStringQueryBuilder::fromXContent));
            );
    }
        registerValueFormat(DocValueFormat.DateTime.NAME, DocValueFormat.DateTime::new);
    private void registerSuggester(SuggesterSpec<?> suggester) {
        registerQuery(new QuerySpec<>(RegexpQueryBuilder.NAME, RegexpQueryBuilder::new, RegexpQueryBuilder::fromXContent));
                MinBucketPipelineAggregationBuilder.NAME,
                ),
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
            new AggregationSpec(RareTermsAggregationBuilder.NAME, RareTermsAggregationBuilder::new, RareTermsAggregationBuilder.PARSER)
import org.opensearch.plugins.SearchPlugin.SortSpec;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import org.opensearch.index.query.DistanceFeatureQueryBuilder;
                AdjacencyMatrixAggregationBuilder.NAME,
 * GitHub history for details.
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
            new AggregationSpec(TopHitsAggregationBuilder.NAME, TopHitsAggregationBuilder::new, TopHitsAggregationBuilder::parse)
import org.opensearch.search.aggregations.bucket.terms.SignificantStringTerms;
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
        );
        registerQuery(new QuerySpec<>(GeoPolygonQueryBuilder.NAME, GeoPolygonQueryBuilder::new, GeoPolygonQueryBuilder::fromXContent));
    private QueryPhaseSearcher registerQueryPhaseSearcher(List<SearchPlugin> plugins) {
                DateHistogramAggregationBuilder.PARSER
                VariableWidthHistogramAggregationBuilder::new,
            new QuerySpec<>(SpanMultiTermQueryBuilder.NAME, SpanMultiTermQueryBuilder::new, SpanMultiTermQueryBuilder::fromXContent)
import org.opensearch.index.query.TermsSetQueryBuilder;
            }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        );
        registerValueFormat(DocValueFormat.Decimal.NAME, DocValueFormat.Decimal::new);
        registerQuery(new QuerySpec<>(MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new, MatchAllQueryBuilder::fromXContent));
        namedWriteables.add(
        registerQuery(new QuerySpec<>(FuzzyQueryBuilder.NAME, FuzzyQueryBuilder::new, FuzzyQueryBuilder::fromXContent));
     * NOTE: This constructor should not be called in production unless an accurate {@link Settings} object is provided.
                    IntervalsSourceProvider.Regexp.NAME,
                MovFnPipelineAggregationBuilder::new,
    }
        registerAggregation(
        );
        if (searcher == null) {
import org.opensearch.search.aggregations.pipeline.SerialDiffPipelineAggregationBuilder;
        );
        registerQuery(
    public Map<String, Highlighter> getHighlighters() {
import org.opensearch.search.aggregations.pipeline.BucketSortPipelineAggregationBuilder;
        );
    }
import org.opensearch.search.aggregations.bucket.range.InternalGeoDistance;
        registerQuery(new QuerySpec<>(ScriptQueryBuilder.NAME, ScriptQueryBuilder::new, ScriptQueryBuilder::fromXContent));
                ),
                new NamedWriteableRegistry.Entry(
        );
import org.opensearch.search.sort.GeoDistanceSortBuilder;
import org.opensearch.index.query.SpanNearQueryBuilder.SpanGapQueryBuilder;
                AvgBucketPipelineAggregationBuilder.NAME,
                GeoDistanceAggregationBuilder::new,
                ScriptScoreFunctionBuilder::fromXContent
        registerAggregation(
    }
                .setAggregatorRegistrar(MissingAggregationBuilder::registerAggregators),
        if (register != null) {
                .setAggregatorRegistrar(ValueCountAggregationBuilder::registerAggregators),
        registerQuery(
import org.opensearch.index.query.SpanContainingQueryBuilder;
                .addResultReader(InternalSimpleValue.NAME, InternalSimpleValue::new)
        );
        );
        namedWriteables.add(new NamedWriteableRegistry.Entry(SmoothingModel.class, LinearInterpolation.NAME, LinearInterpolation::new));
    public static void registerSmoothingModels(List<Entry> namedWriteables) {
    private void registerSignificanceHeuristics(List<SearchPlugin> plugins) {
    private List<SearchPlugin.ProfileMetricsProvider> registerProfilerProviders(List<SearchPlugin> plugins) {
        registerFetchSubPhase(new ScriptFieldsPhase());
        registerAggregation(
    private void registerMovingAverageModels(List<SearchPlugin> plugins) {
                .addResultReader(SignificantLongTerms.NAME, SignificantLongTerms::new)
    }
 * this file be licensed under the Apache-2.0 license or a
    }
            builder
        registerAggregation(
        registerMovingAverageModels(plugins);
import org.opensearch.search.fetch.subphase.highlight.PlainHighlighter;
            new NamedWriteableRegistry.Entry(AggregationBuilder.class, spec.getName().getPreferredName(), spec.getReader())
            new PipelineAggregationSpec(
import org.opensearch.search.aggregations.bucket.terms.LongRareTerms;
