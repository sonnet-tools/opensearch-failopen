         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it
        return emptyList();
         * Get the readers that must be registered for this aggregation's results.
    }
        ) {
        return emptyMap();
         * @param builderReader the reader registered for this suggester's builder. Typically, a reference to a constructor that takes a
         */
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
            super(name, reader, parser);
     */
         *        is the name by under which the reader is registered. So it is the name that the query should use as its
         *
        /**
        }
    /**
         * @param name the name of the behavior as a {@linkplain ParseField}. The parser is registered under all names specified by the
    }
        public SignificanceHeuristicSpec(String name, Writeable.Reader<T> reader, BiFunction<XContentParser, Void, T> parser) {
         *        is the name by under which the reader is registered. So it is the name that the score function should use as its
 *
package org.opensearch.plugins;
            final Class<? extends CompositeValuesSourceBuilder<?>> valueSourceBuilderClass,
         *        {@link StreamInput}
        }
            return this;
     */
    /**
         * this aggregation
         */
         * Specification of a {@link PipelineAggregator}.
        private final CompositeAggregationParsingFunction parsingFunction;
         * Get the readers that must be registered for this aggregation's results.
     * time by {@link IndexSearcher}. The {@link IllegalStateException} is going to be thrown if more then one
         * @param reader the reader registered for this heuristic. Typically, a reference to a constructor that takes a
            return byteCode;
         * @return profile metric supplier
            return aggregatorRegistrar;
     * {@link QueryPhaseSearcher} implementation.
         * @param name the name by which this score function might be parsed or deserialized. Make sure that the score function builder returns this name for
        private final Map<String, Writeable.Reader<? extends InternalAggregation>> resultReaders = new TreeMap<>();
         */
 */
         * Specification of custom {@link Suggester}.
     * Specification of custom {@link SignificanceHeuristic}.
     *        though, usually it is some sort of builder sent from the coordinating node to the data nodes executing the behavior
        }
 * software distributed under the License is distributed on an
     */
            super(name, reader, (p, aggName) -> parser.parse(aggName, p));
    /**
         * Add a reader for the shard level results of the aggregation.
         *        is the name by under which the readers are registered. So it is the name that the {@link PipelineAggregationBuilder} and
import org.opensearch.core.common.io.stream.NamedWriteable;
         *        is the name by under which the reader is registered. So it is the name that the {@link AggregationBuilder} should return
    /**
         *
            super(name, reader, parser);
         * Specification of custom {@link SearchExtBuilder}.
        public Map<String, Highlighter> getHighlighters() {
 * not use this file except in compliance with the License.
        public SearchExtensionSpec(ParseField name, Writeable.Reader<? extends W> reader, P parser) {
         *        another registered name, including names from other plugins.
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
     * Specification of search time behavior extension like a custom {@link MovAvgModel} or {@link ScoreFunction}.
         * @param name the name by which this search ext might be parsed or deserialized. Make sure that the search ext builder returns this name for
import org.opensearch.core.ParseField;
         */
         *        {@linkplain ParseField} but the reader is only registered under the {@link ParseField#getPreferredName()} so be sure that
         */
    default List<QuerySpec<?>> getQueries() {
    /**
        public SuggesterSpec(
         *        {@link StreamInput}
            super(name, reader, parser);
         * Specification of custom {@link Sort}.
     * Allows plugins to register new Aggregation in the {@link CompositeAggregation}.
        }
            this.parsingFunction = parsingFunction;
            super(name, reader, parser);
        return emptyList();
        public SearchExtSpec(
         * @param byteCode byte code which is used in serialisation and de-serialisation to indentify which
     * plugin tries to register index searcher executor.
import org.opensearch.search.aggregations.Aggregator;
    /**
         *        {@link PipelineAggregator} should return from {@link NamedWriteable#getWriteableName()}.  It is an error if
            return addResultReader(getName().getPreferredName(), resultReader);
        public <T extends AggregationBuilder> AggregationSpec(String name, Writeable.Reader<T> reader, ContextParser<String, T> parser) {
         *        names from other plugins.
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import org.opensearch.search.aggregations.AggregationBuilder;
        }
         *        query and Suggestion response should use as their {@link NamedWriteable#getWriteableName()} return values too.  It is
        /**
         *        is the name by under which the reader is registered. So it is the name that the {@link AggregationBuilder} should return
        /**
         * @param name the name by which this aggregation might be parsed or deserialized. Make sure that the {@link AggregationBuilder}
import org.opensearch.common.lucene.search.function.ScoreFunction;
        }
    class SortSpec<T extends SortBuilder<T>> extends SearchExtensionSpec<T, SortParser<T>> {
    /**
import java.util.Map;
     * @param <W> the type of the main {@link NamedWriteable} for this spec. All specs have this but it isn't always *for* the same thing
    default List<RescorerSpec<?>> getRescorers() {
    }
        public SortSpec(String name, Writeable.Reader<T> reader, SortParser<T> parser) {
         * @param parser the parser the reads the aggregation builder from xcontent
/*
        public ParseField getName() {
         * @param builderParser a parser that reads the suggester's builder from xcontent
         * @param parser reads the aggregation builder from XContent
     * Specification for including an aggregation as a part of Composite Aggregation.
         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it
         *        {@link StreamInput}
         *        {@link StreamInput}
         *        with another registered name, including names from other plugins.
    class SearchExtensionSpec<W extends NamedWriteable, P> {
    class AggregationSpec extends SearchExtensionSpec<AggregationBuilder, ContextParser<String, ? extends AggregationBuilder>> {
import org.apache.lucene.search.Sort;
         *        {@link StreamInput}
         *
    }
        /**
    default List<SuggesterSpec<?>> getSuggesters() {
     * The new {@link Sort}s defined by this plugin.
         *        another registered name, including names from other plugins.
import java.util.TreeMap;
        /**
         *        registered name, including names from other plugins.
     */
        /* This is added for backward compatibility, you don't need to set it, as we use aggregationType instead of
    /**
    default List<AggregationSpec> getAggregations() {
        }
        /**
    }
         *        names from other plugins.
        }
         */
        /**
     * @return A list of the new registrar functions
         * @param reader the reader registered for this heuristic. Typically, a reference to a constructor that takes a
         *
     * Specification of custom {@link ScoreFunction}.
import org.opensearch.search.suggest.Suggest;
         *        {@link StreamInput}
         * @deprecated Use the ctor that takes a {@link ContextParser} instead
}
            return aggregationType;
        public RescorerSpec(ParseField name, Writeable.Reader<? extends T> reader, CheckedFunction<XContentParser, T, IOException> parser) {
    }
         * Specification of custom {@link ScoreFunctionBuilder}.
        /**
        return emptyList();
        }
        }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
            return reader;
         *        {@link StreamInput}
         * Returns the reader used to read the {@link Suggest.Suggestion} generated by this suggester
         *                            aggregation
        }
import java.io.IOException;
         * @param name the name by which this suggester might be parsed or deserialized. Make sure that the query builder and Suggestion
         * @param reader Typically, a reference to a constructor that takes a {@link StreamInput}, which is
        }
            this.parser = parser;
        /**
         * The reader responsible for reading the behavior from the internode protocol.
            this.suggestionReader = reader;
import java.util.concurrent.ExecutorService;
         * Specification of custom {@link Suggester}.
            return highlighters;
         * The parser responsible for converting {@link XContent} into the behavior.
 * this work for additional information regarding copyright
        /**
    /**
         * as the {@link NamedWriteable#getWriteableName()}.
        /**
        ) {
     * The new {@link QueryPhaseSearcher} added by this plugin. At the moment, only one {@link QueryPhaseSearcher} is supported per
     */
     */
         * Specification for an {@link Aggregation}.
     */
 * Modifications Copyright OpenSearch Contributors. See
    }
         */
import org.opensearch.common.annotation.ExperimentalApi;
         * @param name name by which this aggregation might be parsed or deserialized. Make sure it is the name that the
         * @param suggestionReader the reader registered for this suggester's Suggestion response. Typically, a reference to a constructor
import org.opensearch.search.query.QueryPhaseSearcher;
        /**
         *        {@link StreamInput}
import org.opensearch.core.xcontent.XContentParser;
        ) {
         */
        public ScoreFunctionSpec(String name, Writeable.Reader<T> reader, ScoreFunctionParser<T> parser) {
         * @param reader the reader registered for this sort's builder. Typically, a reference to a constructor that takes a
    }
        public <T extends AggregationBuilder> AggregationSpec(
import java.util.function.Consumer;
         *
/*
import java.util.Optional;
            return parsingFunction;
            final CompositeAggregationParsingFunction parsingFunction,
        }
         *        {@link StreamInput}
        }
        }
         * Add a reader for the shard level results of the aggregation.
         *        that takes a {@link StreamInput}
         *
         * @param aggregatorRegistrar function to register the
         *        returns this from {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another
         *        {@link PipelineAggregationBuilder} and {@link PipelineAggregator} should return from
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        public CompositeAggregationSpec(
         *        registered name, including names from other plugins.
         *        {@link StreamInput}
        /**
        @Deprecated
        @Deprecated
        public PipelineAggregationSpec(
         */
         * @param name the name of the behavior. The parser and the reader are registered under this name so be sure that is the
         * Specification of a {@link PipelineAggregator}.
         *        names from other plugins.
    /**
 * The OpenSearch Contributors require contributions made to
         */
            String name,
         * @param name the name by which this sort might be parsed or deserialized. Make sure that the sort builder returns this name for
         *
import org.opensearch.search.sort.SortBuilder;
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,
         */
         *        {@link StreamInput}
        return Optional.empty();
        public Consumer<ValuesSourceRegistry.Builder> getAggregatorRegistrar() {
     */
    /**
         */
        public Consumer<ValuesSourceRegistry.Builder> getAggregatorRegistrar() {
         *        is the name by under which the reader is registered. So it is the name that the heuristic should use as its
    /**
         *        another registered name, including names from other plugins.
            return addResultReader(getName().getPreferredName(), resultReader);
    }
            super(name, reader, parser);
    /**
            CheckedFunction<XContentParser, T, IOException> parser
import org.opensearch.core.common.io.stream.StreamInput;
            CheckedFunction<XContentParser, T, IOException> builderParser,
    /**
         * @param reader the reader registered for this query's builder. Typically, a reference to a constructor that takes a
            return reader;
 *
    default List<ScoreFunctionSpec<?>> getScoreFunctions() {
import org.opensearch.search.query.QueryCollectorContextSpecFactory;
         *        that is the name that W's {@link NamedWriteable#getWriteableName()} returns.  It is an error if
         *        names from other plugins.
     * The plugin provider to be used to get the profilers from plugins.
         */
        }
     * @return A {@link ConcurrentSearchRequestDecider.Factory}
        public PipelineAggregationSpec(
         *        name that W's {@link NamedWriteable#getWriteableName()} returns.  It is an error if this name conflicts with another
 * You may obtain a copy of the License at
         * @param name holds the names by which this heuristic might be parsed. The {@link ParseField#getPreferredName()} is special as it
    class ScoreFunctionSpec<T extends ScoreFunctionBuilder<T>> extends SearchExtensionSpec<T, ScoreFunctionParser<T>> {
    /**
        private void setSuggestionReader(Writeable.Reader<? extends Suggest.Suggestion> reader) {
/**
     */
        }
import org.opensearch.search.profile.ProfileMetric;
 * Unless required by applicable law or agreed to in writing,
    default Map<String, Highlighter> getHighlighters() {
         *
     */
 * under the License.
        }
        private Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar;
         *
        return emptyList();
         *
        ExecutorService getExecutor(ThreadPool threadPool);
        public SuggesterSpec(
         * this aggregation
import org.opensearch.common.settings.Settings;
         * @param parser the parser the reads the sort builder from xcontent
        ) {
 * ownership. Elasticsearch licenses this file to you under
         *
         */
     * The new {@link Rescorer}s added by this plugin.
/*
          byte code
    /**
         */
         * Specification of custom {@link ScoreFunctionBuilder}.
            super(name, reader, parser);
         *        from {@link NamedWriteable#getWriteableName()}. It is an error if {@link ParseField#getPreferredName()} conflicts with
         * Specification of custom {@link Query}.
            ParseField name,
            String name,
            this.reader = reader;
        }
     * in Core, as long as the new aggregations target different ValuesSourceTypes
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
            this.aggregationType = aggregationType;
         * {@link org.opensearch.search.aggregations.support.ValuesSource} to aggregator mappings for Composite
        private final String aggregationType;
         * @param aggregationType a {@link String} defined in the AggregationBuilder as type.
        /**
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
         * @param parser the parser the reads the score function builder from xcontent
            this.highlighters = highlighters;
    /**
     * parsed in a search request (within the ext element).
        private final Writeable.Reader<? extends CompositeValuesSourceBuilder<?>> reader;
    interface ProfileMetricsProvider {
    /**
        public PipelineAggregationSpec addResultReader(String writeableName, Writeable.Reader<? extends InternalAggregation> resultReader) {
        /**
        public SearchExtSpec(String name, Writeable.Reader<? extends T> reader, CheckedFunction<XContentParser, T, IOException> parser) {
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
        /**
import org.opensearch.search.SearchExtBuilder;
         * @param parser the parser the reads the aggregation builder from xcontent
         * @param reader the reader registered for this query's builder. Typically, a reference to a constructor that takes a
        ) {
    class SuggesterSpec<T extends SuggestionBuilder<T>> extends SearchExtensionSpec<T, CheckedFunction<XContentParser, T, IOException>> {
         * @param parser the parser the reads the aggregation builder from xcontent
        public ScoreFunctionSpec(ParseField name, Writeable.Reader<T> reader, ScoreFunctionParser<T> parser) {
    /**
            return this;
        return emptyList();
        public QuerySpec(String name, Writeable.Reader<T> reader, QueryParser<T> parser) {
    }
        ) {
         *        {@link StreamInput}
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationParsingFunction;
    }
         */
            return this.suggestionReader;
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,
    }
        /**
    default Optional<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactory() {
         */
            return aggregatorRegistrar;
import org.opensearch.index.query.QueryBuilder;
            super(name, builderReader, parser);
            Writeable.Reader<? extends T> reader,
         *        names from other plugins.
    default Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
        @Deprecated
    }
        private final Map<String, Writeable.Reader<? extends InternalAggregation>> resultReaders = new TreeMap<>();
         * @param parser the parser function that reads the rescorer builder from xcontent
        public FetchPhaseConstructionContext(Map<String, Highlighter> highlighters) {
        /**
 *
        Collection<Supplier<ProfileMetric>> getQueryProfileMetrics(SearchContext searchContext, Query query);
     */
        /**
         * Build the spec with a {@linkplain ParseField}.
        /**
        public AggregationSpec addResultReader(String writeableName, Writeable.Reader<? extends InternalAggregation> resultReader) {
        public P getParser() {
         * Add a reader for the shard level results of the aggregation with {@linkplain #getName}'s {@link ParseField#getPreferredName()} as
    }
            return resultReaders;
            super(name, builderReader, (p, n) -> parser.parse(n, p));
         *
            super(name, reader, (p, aggName) -> parser.parse(aggName, p));
            ParseField name,
         * @param builderReader the reader registered for this suggester's builder. Typically, a reference to a constructor that takes a
    }
         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it
        /**
     * Context available during fetch phase construction.
        public CompositeAggregationParsingFunction getParsingFunction() {
         *        another registered name, including names from other plugins.
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregation;
     */
         * @param parser the parser the reads the query builder from xcontent
 * KIND, either express or implied.  See the License for the
         * @param name the name by which this heuristic might be parsed or deserialized. Make sure that the heuristic returns this name for
        }
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
        public RescorerSpec(String name, Writeable.Reader<? extends T> reader, CheckedFunction<XContentParser, T, IOException> parser) {
import org.opensearch.core.xcontent.ContextParser;
         */
 * @opensearch.api
         * @param threadPool thread pool
     * {@link SignificantTerms} aggregation to pick which terms are significant for a given query.
     * Allows plugins to register new aggregations using aggregation names that are already defined
         */
        public PipelineAggregationSpec addResultReader(Writeable.Reader<? extends InternalAggregation> resultReader) {
         * Specification of a {@link PipelineAggregator}.
    }
import org.opensearch.index.query.QueryParser;
            ContextParser<String, T> parser
import org.opensearch.search.suggest.SuggestionBuilder;
    default List<CompositeAggregationSpec> getCompositeAggregations() {
         *        another registered name, including names from other plugins.
         *
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
         *        is the name by under which the reader is registered. So it is the name that the search ext should use as its
        }
        public Writeable.Reader<? extends Suggest.Suggestion> getSuggestionReader() {
         * @param name holds the names by which this score function might be parsed. The {@link ParseField#getPreferredName()} is special as it
         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it
            return valueSourceBuilderClass;
        /**
        public PipelineAggregationSpec(
         */
     * The new {@link SignificanceHeuristic}s defined by this plugin. {@linkplain SignificanceHeuristic}s are used by the
     */
    class PipelineAggregationSpec extends SearchExtensionSpec<
        ) {
         *        response reader return this name for {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts
         *        names from other plugins.
         * @param parser the parser the reads the sort builder from xcontent
        @Deprecated
    default List<PipelineAggregationSpec> getPipelineAggregations() {
    }
         * Build the spec with a String.
         * Set the function to register the {@link org.opensearch.search.aggregations.support.ValuesSource} to aggregator mappings for
        return emptyList();
        }
     */
            this(new ParseField(name), reader, parser);
         * @param name name by which this aggregation might be parsed or deserialized. Make sure it is the name that the
        /**
         *        {@link StreamInput}
         * @param valueSourceBuilderClass ValueSourceBuilder class name which is building the aggregation
        return Optional.empty();
        public Map<String, Writeable.Reader<? extends InternalAggregation>> getResultReaders() {
        /**
    }
import org.opensearch.search.aggregations.PipelineAggregationBuilder;
            this.byteCode = byteCode;
            this.name = name;
    }
     */
            super(name, reader, parser);
         *        {@link StreamInput}
import org.opensearch.threadpool.ThreadPool;
    default List<Consumer<ValuesSourceRegistry.Builder>> getAggregationExtentions() {
import org.opensearch.search.aggregations.Aggregation;
        /**
            ParseField name,
         *        is the name by under which the request builder and Suggestion response readers are registered. So it is the name that the
     * instance, the {@link IllegalStateException} is going to be thrown if more then one plugin tries to register
         */
         *
        public AggregationSpec addResultReader(Writeable.Reader<? extends InternalAggregation> resultReader) {
     * Specification for a {@link RescorerBuilder}.
    class CompositeAggregationSpec {
    /**
         *                 aggregation builder to use
            CheckedFunction<XContentParser, T, IOException> builderParser,
         *        is the name by under which the reader is registered. So it is the name that the rescorer should use as its
        public Byte getByteCode() {
     * The new {@link ScoreFunction}s defined by this plugin.
            setSuggestionReader(suggestionReader);
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
         * @param parser the parser function that reads the search ext builder from xcontent
     */
        public SortSpec(ParseField name, Writeable.Reader<T> reader, SortParser<T> parser) {
         *        that takes a {@link StreamInput}
        }
    /**
        public AggregationSpec(String name, Writeable.Reader<? extends AggregationBuilder> reader, Aggregator.Parser parser) {
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
        }
            Writeable.Reader<T> builderReader,
     */
    class RescorerSpec<T extends RescorerBuilder<T>> extends SearchExtensionSpec<T, CheckedFunction<XContentParser, T, IOException>> {
            Writeable.Reader<T> reader,
         */
            ContextParser<String, ? extends PipelineAggregationBuilder> parser
        ) {
         */
         * Add a reader for the shard level results of the aggregation with {@linkplain #getName()}'s {@link ParseField#getPreferredName()}
         *        {@link StreamInput}
         * @param name the name by which this query might be parsed or deserialized. Make sure that the query builder returns this name for
import org.apache.lucene.search.IndexSearcher;
        /**
        private Byte byteCode;
        private final ParseField name;
     */
         *
         * @param parsingFunction a reference function which will be used to parse the Aggregation input.
        public Class<?> getValueSourceBuilderClass() {
         */
    interface ExecutorServiceProvider {
     */
import org.opensearch.search.rescore.RescorerBuilder;
        @Deprecated
         * Specification of custom {@link SignificanceHeuristic}.
        return emptyList();
        /**
        }
        }
         *
        }
         */
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
        /**
    /**
 */
        /**
     * The new {@link PipelineAggregator}s added by this plugin.
        public Writeable.Reader<? extends CompositeValuesSourceBuilder<?>> getReader() {
import org.opensearch.search.fetch.FetchSubPhase;
         */
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
        return Optional.empty();
    }
         * @param parser the parser function that reads the rescorer builder from xcontent
            super(name, builderReader, builderParser);
            ParseField name,
         *
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
     * Specification for a {@link PipelineAggregator}.
         * @param name holds the names by which this rescorer might be parsed. The {@link ParseField#getPreferredName()} is special as it
         *        {@link PipelineAggregationBuilder} and {@link PipelineAggregator} should return from
        }
         */
         * @param name the name by which this aggregation might be parsed or deserialized. Make sure that the {@link AggregationBuilder}
         * @param name holds the names by which this query might be parsed. The {@link ParseField#getPreferredName()} is special as it
    class SignificanceHeuristicSpec<T extends SignificanceHeuristic> extends SearchExtensionSpec<T, BiFunction<XContentParser, Void, T>> {
 */
import org.apache.lucene.search.Query;
         * Specification of custom {@link SignificanceHeuristic}.
            PipelineAggregator.Parser parser
        return emptyList();
        return emptyList();
        return emptyList();
import org.opensearch.core.xcontent.XContent;
         * Get the function to register the {@link org.opensearch.search.aggregations.support.ValuesSource} to aggregator mappings for
    /**
            ParseField name,
    /**
         * @param builderParser a parser that reads the suggester's builder from xcontent
        /**
    default List<SearchExtensionSpec<MovAvgModel, MovAvgModel.AbstractModelParser>> getMovingAverageModels() {
 * SPDX-License-Identifier: Apache-2.0
    }
        }
    }
     * @param <P> the type of the parser for this spec. The parser runs on the coordinating node, converting {@link XContent} into the
    default List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
            super(name, reader, parser);
         * @deprecated Use the ctor that takes a {@link ContextParser} instead
     */
    /**
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
     * Get the {@link Highlighter}s defined by this plugin.
    }
         * @param name the name by which this rescorer might be parsed or deserialized. Make sure that the rescorer builder returns this name for
    default Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {
            super(name, builderReader, (p, n) -> parser.parse(n, p));
     * Specification of custom {@link Sort}.
         * @deprecated prefer the ctor that takes a {@link ContextParser}
     */
    default List<SignificanceHeuristicSpec<?>> getSignificanceHeuristics() {
            super(name, reader, parser);
import org.opensearch.search.rescore.Rescorer;
import org.opensearch.search.aggregations.pipeline.MovAvgPipelineAggregator;
         */
    /**
        PipelineAggregationBuilder,
         * the {@link NamedWriteable#getWriteableName()}.
         * Specification for an {@link Aggregation}.
        private final Class<?> valueSourceBuilderClass;
 *    http://www.apache.org/licenses/LICENSE-2.0
            return name;
            this.reader = reader;
    }
         * Specification of custom {@link RescorerBuilder}.
        public Map<String, Writeable.Reader<? extends InternalAggregation>> getResultReaders() {
    /**
import org.opensearch.search.internal.SearchContext;
     */
     * The executor service provider (registered through {@link Plugin#getExecutorBuilders(Settings)} to be used at search
        private final Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar;
     */
         * @param parser parser that read the behavior from a REST request
        private final Map<String, Highlighter> highlighters;
    }
     */
         */
         * @param reader the reader registered for this rescorer's builder. Typically, a reference to a constructor that takes a
         */
        /**
    default Optional<ProfileMetricsProvider> getQueryProfileMetricsProvider() {
        }
         *        another registered name, including names from other plugins.
     */
        private final P parser;
import org.opensearch.search.aggregations.InternalAggregation;
         */
        }
        public Writeable.Reader<? extends W> getReader() {
        }
        }
        return emptyList();
            this.aggregatorRegistrar = aggregatorRegistrar;
    class SearchExtSpec<T extends SearchExtBuilder> extends SearchExtensionSpec<T, CheckedFunction<XContentParser, T, IOException>> {
    }
         * @param reader the reader registered for this search ext's builder. Typically, a reference to a constructor that takes a
    /**
    }
         *        {@link StreamInput}
 */
        public SearchExtensionSpec(String name, Writeable.Reader<? extends W> reader, P parser) {
         * The name of the thing being specified as a {@link ParseField}. This allows it to have deprecated names.
            Writeable.Reader<T> builderReader,
         *        {@link NamedWriteable#getWriteableName()}. It is an error if this name conflicts with another registered name, including
         * @param parser the parser function that reads the heuristic from xcontent
         * @param name holds the names by which this suggester might be parsed. The {@link ParseField#getPreferredName()} is special as it
         *        names from other plugins.
        /**
         * @param parser the parser the reads the aggregation builder from xcontent
        }
         *
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
     */
    class FetchPhaseConstructionContext {
         * Specification of custom {@link Sort}.
         *
         * @param name holds the names by which this search ext might be parsed. The {@link ParseField#getPreferredName()} is special as it
     * The new {@link FetchSubPhase}s defined by this plugin.
    }
        ) {
         * Specification of a {@link PipelineAggregator}.
        }
         * @param reader the reader registered for this rescorer's builder. Typically, a reference to a constructor that takes a
     *
     * The new {@link MovAvgModel}s defined by this plugin. {@linkplain MovAvgModel}s are used by the {@link MovAvgPipelineAggregator} to
         * @param parser the parser the reads the score function builder from xcontent
        public AggregationSpec setAggregatorRegistrar(Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar) {
import org.opensearch.search.aggregations.pipeline.MovAvgModel;
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
import java.util.function.BiFunction;
         *        {@link StreamInput}
         *
 * specific language governing permissions and limitations
        /**
     * model trends in data.
         * @param parser the parser function that reads the search ext builder from xcontent
         */
     * Plugin Profiler provider
     */
         */
        }
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
         * @param parser the parser the reads the query builder from xcontent
        /**
            this.aggregatorRegistrar = aggregatorRegistrar;
        }
        private final Writeable.Reader<? extends W> reader;
         *        names from other plugins.
         * @param name holds the names by which this sort might be parsed. The {@link ParseField#getPreferredName()} is special as it
    class QuerySpec<T extends QueryBuilder> extends SearchExtensionSpec<T, QueryParser<T>> {
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
         * @param parser the parser function that reads the heuristic from xcontent
        return Optional.empty();
         * @param reader reader that reads the behavior from the internode protocol
    default List<QueryCollectorContextSpecFactory> getCollectorContextSpecFactories() {
     * Allows plugins to register a factory to create custom decider for concurrent search
        /**
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
     */
        /**
         *        an error if {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.
 * Licensed to Elasticsearch under one or more contributor
        return emptyList();
         *        returns this from {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another
        public AggregationSpec(ParseField name, Writeable.Reader<? extends AggregationBuilder> reader, Aggregator.Parser parser) {
    /**
         * @param reader the reader registered for this sort's builder. Typically, a reference to a constructor that takes a
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,
            return resultReaders;
import org.opensearch.search.sort.SortParser;
            super(name, builderReader, parser);
         *        {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.
        /**
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
         * Provides an executor service instance
    }
         *        {@link PipelineAggregator} should return from {@link NamedWriteable#getWriteableName()}.  It is an error if
         *        registered name, including names from other plugins.
import java.util.List;
     * The new {@link Query}s defined by this plugin.
        }
         * Specification for an {@link Aggregation}.
     * @return A {@link List} of {@link CompositeAggregationSpec}
         *        is the name by under which the reader is registered. So it is the name that the sort should use as its
         */
         */
         * Specification for registering an aggregation in Composite Aggregation
         * @param parser reads the aggregation builder from XContent
         *
    }
         * @return executor service instance
    default List<SearchExtSpec<?>> getSearchExts() {
            Writeable.Reader<? extends Suggest.Suggestion> suggestionReader
            setSuggestionReader(suggestionReader);
         */
     * Specification for a {@link Suggester}.
        public QuerySpec(ParseField name, Writeable.Reader<T> reader, QueryParser<T> parser) {
         *        {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.
 * the Apache License, Version 2.0 (the "License"); you may
            super(name, reader, parser);
        }
         * @param reader the reader registered for this search ext's builder. Typically, a reference to a constructor that takes a
            Writeable.Reader<? extends Suggest.Suggestion> suggestionReader
     * The new {@link Aggregation}s added by this plugin.
        }
        ContextParser<String, ? extends PipelineAggregationBuilder>> {
            resultReaders.put(writeableName, resultReader);
         * Specification of custom {@link RescorerBuilder}.
        /**
         * @param parser parser that read the behavior from a REST request
        public String getAggregationType() {
            String name,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
import org.opensearch.common.CheckedFunction;
            super(name, builderReader, builderParser);
         * Provides profiler metrics based on query and aggregation
         */
            super(name, reader, parser);
         * @param parser reads the aggregation builder from XContent
            return parser;
         *        another registered name, including names from other plugins.
import java.util.function.Supplier;
        }
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
         *        {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.
        }
    }
     * Specification of custom {@link Query}.
 *
         */
         * Specification of custom {@link Query}.
         *        {@link StreamInput}
import static java.util.Collections.emptyList;
        public PipelineAggregationSpec(
     *        behavior to execute
import org.opensearch.index.query.functionscore.ScoreFunctionParser;
         *        {@link StreamInput}
    /**
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,
 * Plugin for extending search time behavior.
         * @param suggestionReader the reader registered for this suggester's Suggestion response. Typically, a reference to a constructor
         *
         * @param reader the reader registered for this score function's builder. Typically, a reference to a constructor that takes a
        return emptyList();
     * Specification for a {@link SearchExtBuilder} which represents an additional section that can be
     */
         */
    }
         * @param reader the reader registered for this score function's builder. Typically, a reference to a constructor that takes a
         * @deprecated prefer the ctor that takes a {@link ContextParser}
            final Writeable.Reader<? extends CompositeValuesSourceBuilder<?>> reader,
         *
         *        from {@link NamedWriteable#getWriteableName()}. It is an error if {@link ParseField#getPreferredName()} conflicts with
        public SignificanceHeuristicSpec(ParseField name, Writeable.Reader<T> reader, BiFunction<XContentParser, Void, T> parser) {
            super(name, reader, parser);
         *               registered with the aggregation
         *
     * Specification for an {@link Aggregation}.
    default List<SortSpec<?>> getSorts() {
        /**
            ContextParser<String, ? extends PipelineAggregationBuilder> parser
        }
         *        {@link StreamInput}
    /**
    @ExperimentalApi
            return this;
         * Specification of custom {@link SearchExtBuilder}.
            PipelineAggregator.Parser parser
        return emptyList();
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
import java.util.Collection;
            super(name, reader, parser);
            final Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar,
            resultReaders.put(writeableName, resultReader);
         *        {@link StreamInput}
         */
     *
import org.opensearch.search.suggest.Suggester;
     */
         *        another registered name, including names from other plugins.
        }
     */
     * The new {@link SearchExtBuilder}s defined by this plugin.
     * Executor service provider
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
         *        is the name by under which the readers are registered. So it is the name that the {@link PipelineAggregationBuilder} and
         *
            this.valueSourceBuilderClass = valueSourceBuilderClass;
        private Writeable.Reader<? extends Suggest.Suggestion> suggestionReader;
     * The new {@link Suggester}s defined by this plugin.
         *        {@link StreamInput}
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
import org.opensearch.core.common.io.stream.Writeable;
            super(name, reader, parser);
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
    }
import static java.util.Collections.emptyMap;
    /**
            final String aggregationType
        }
     */
         * @param reader reader that reads the behavior from the internode protocol
            final Byte byteCode,
public interface SearchPlugin {
         * Specification for an {@link Aggregation}.
