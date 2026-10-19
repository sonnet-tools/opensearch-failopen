 * software distributed under the License is distributed on an
         */
         * Specification of custom {@link SignificanceHeuristic}.
            this.name = name;  
import org.opensearch.core.xcontent.ContextParser;  
        /**
     */
        public SearchExtSpec(String name, Writeable.Reader<? extends T> reader, CheckedFunction<XContentParser, T, IOException> parser) {  
            this.aggregationType = aggregationType;
         * @param parser the parser function that reads the rescorer builder from xcontent  
        private final Writeable.Reader<? extends W> reader;
    }
         * Provides profiler metrics based on query and aggregation
         * @param parser reads the aggregation builder from XContent
            super(name, builderReader, builderParser);  
        /**  
     */  
        }
        public SignificanceHeuristicSpec(ParseField name, Writeable.Reader<T> reader, BiFunction<XContentParser, Void, T> parser) {  
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.common.lucene.search.function.ScoreFunction;  
         *
     * Specification of search time behavior extension like a custom {@link MovAvgModel} or {@link ScoreFunction}.
/*
         * @param name the name by which this aggregation might be parsed or deserialized. Make sure that the {@link AggregationBuilder}  
     * Specification of custom {@link ScoreFunction}.  
         *        names from other plugins.
        private Byte byteCode;
         *        is the name by under which the reader is registered. So it is the name that the heuristic should use as its
         */
    /**
     */  
        }
    class SignificanceHeuristicSpec<T extends SignificanceHeuristic> extends SearchExtensionSpec<T, BiFunction<XContentParser, Void, T>> {  
        }
            super(name, reader, parser);
            setSuggestionReader(suggestionReader);
    /**
     */
        public PipelineAggregationSpec addResultReader(Writeable.Reader<? extends InternalAggregation> resultReader) {  
            super(name, reader, parser);
         */
         */
         * @param parser the parser function that reads the search ext builder from xcontent
    @ExperimentalApi  
        ) {  
         *        {@link StreamInput}
            return addResultReader(getName().getPreferredName(), resultReader);
         *        registered name, including names from other plugins.
     * Specification of custom {@link Query}.
         */  
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,
         * @param reader reader that reads the behavior from the internode protocol
     * The new {@link SignificanceHeuristic}s defined by this plugin. {@linkplain SignificanceHeuristic}s are used by the
            PipelineAggregator.Parser parser
 * the Apache License, Version 2.0 (the "License"); you may
        /**
 * ownership. Elasticsearch licenses this file to you under  
        public Map<String, Writeable.Reader<? extends InternalAggregation>> getResultReaders() {
         *        {@link StreamInput}  
         * The parser responsible for converting {@link XContent} into the behavior.  
            Writeable.Reader<T> builderReader,
import org.opensearch.core.xcontent.XContent;
        ) {  
    class RescorerSpec<T extends RescorerBuilder<T>> extends SearchExtensionSpec<T, CheckedFunction<XContentParser, T, IOException>> {
            PipelineAggregator.Parser parser  
    /**
         *        {@link StreamInput}  
     * Allows plugins to register new Aggregation in the {@link CompositeAggregation}.
        public Consumer<ValuesSourceRegistry.Builder> getAggregatorRegistrar() {
         */
import org.opensearch.core.common.io.stream.NamedWriteable;  
         */  
            this.reader = reader;
    }
     */  
         *        {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.
import org.opensearch.search.query.QueryCollectorContextSpecFactory;  
     */
 *  
    /**
            super(name, reader, parser);  
        /**  
        public SearchExtensionSpec(ParseField name, Writeable.Reader<? extends W> reader, P parser) {
        /**
     * The plugin provider to be used to get the profilers from plugins.  
     */
     *        though, usually it is some sort of builder sent from the coordinating node to the data nodes executing the behavior
         *        another registered name, including names from other plugins.
         */
    }
         *
     * The new {@link Aggregation}s added by this plugin.  
        return emptyList();  
    /**
        public Byte getByteCode() {
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.search.SearchExtBuilder;
        }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
            ContextParser<String, ? extends PipelineAggregationBuilder> parser
            return parsingFunction;
    /**
     * {@link QueryPhaseSearcher} implementation.
         * @param parser the parser the reads the aggregation builder from xcontent
            super(name, reader, (p, aggName) -> parser.parse(aggName, p));  
         * @param parser the parser the reads the sort builder from xcontent
         * @param parser the parser the reads the aggregation builder from xcontent
         */  
import org.opensearch.core.ParseField;
         * @param aggregatorRegistrar function to register the  
    /**  
        private final Map<String, Highlighter> highlighters;
         * @param name the name by which this heuristic might be parsed or deserialized. Make sure that the heuristic returns this name for
         * @param builderReader the reader registered for this suggester's builder. Typically, a reference to a constructor that takes a  
import org.opensearch.search.sort.SortBuilder;
 */  
    class SearchExtSpec<T extends SearchExtBuilder> extends SearchExtensionSpec<T, CheckedFunction<XContentParser, T, IOException>> {  
         * @param name the name by which this sort might be parsed or deserialized. Make sure that the sort builder returns this name for  
         *        {@link PipelineAggregator} should return from {@link NamedWriteable#getWriteableName()}.  It is an error if
        }
        return emptyList();  
         * @param name the name by which this query might be parsed or deserialized. Make sure that the query builder returns this name for
            this.byteCode = byteCode;  
     */
         *        names from other plugins.
     */
    default List<SignificanceHeuristicSpec<?>> getSignificanceHeuristics() {
     *
    class FetchPhaseConstructionContext {
        private Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar;
         */
import org.opensearch.search.suggest.Suggest;  
     */
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it
    /**
        private final P parser;
        /**
    }  
        /**  
    default Optional<ProfileMetricsProvider> getQueryProfileMetricsProvider() {
         * @param parser the parser function that reads the heuristic from xcontent  
        }  
         * @param reader the reader registered for this score function's builder. Typically, a reference to a constructor that takes a
        public PipelineAggregationSpec(  
    }
        /**
         *                 aggregation builder to use
         *        {@linkplain ParseField} but the reader is only registered under the {@link ParseField#getPreferredName()} so be sure that
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregation;
import java.util.Collection;  
 * this work for additional information regarding copyright
         */  
         *        names from other plugins.
        /**  
         * Specification of custom {@link Sort}.
        public SearchExtSpec(  
         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it  
        return emptyList();
         * Get the readers that must be registered for this aggregation's results.
         * {@link org.opensearch.search.aggregations.support.ValuesSource} to aggregator mappings for Composite
    }
            String name,
            super(name, builderReader, (p, n) -> parser.parse(n, p));
         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it
         *        from {@link NamedWriteable#getWriteableName()}. It is an error if {@link ParseField#getPreferredName()} conflicts with  
         *        is the name by under which the reader is registered. So it is the name that the {@link AggregationBuilder} should return
import org.opensearch.search.aggregations.AggregationBuilder;  
         * Build the spec with a {@linkplain ParseField}.
        public Consumer<ValuesSourceRegistry.Builder> getAggregatorRegistrar() {  
        public ParseField getName() {  
    default List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
    class QuerySpec<T extends QueryBuilder> extends SearchExtensionSpec<T, QueryParser<T>> {
 * under the License.  
        public PipelineAggregationSpec(
     */
         * @param parser the parser the reads the query builder from xcontent
            return reader;
         *        {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.  
    default Optional<ConcurrentSearchRequestDecider.Factory> getConcurrentSearchRequestDeciderFactory() {
     * Specification for a {@link RescorerBuilder}.  
     */  
         *        returns this from {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another
import org.opensearch.search.suggest.SuggestionBuilder;
        }  
     * Allows plugins to register new aggregations using aggregation names that are already defined
 * GitHub history for details.
        }
        public SearchExtensionSpec(String name, Writeable.Reader<? extends W> reader, P parser) {
         *        {@link StreamInput}  
import java.util.function.Consumer;
         * this aggregation
         * @deprecated prefer the ctor that takes a {@link ContextParser}
import java.io.IOException;
            ContextParser<String, T> parser  
            final Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar,  
/**
        /**  
         */
     * Get the {@link Highlighter}s defined by this plugin.
         * Add a reader for the shard level results of the aggregation with {@linkplain #getName}'s {@link ParseField#getPreferredName()} as
         * Specification of custom {@link RescorerBuilder}.
        return Optional.empty();
    /**  
        }
         * Add a reader for the shard level results of the aggregation.
     * The new {@link MovAvgModel}s defined by this plugin. {@linkplain MovAvgModel}s are used by the {@link MovAvgPipelineAggregator} to
         * Specification for registering an aggregation in Composite Aggregation
         *        {@link StreamInput}
         *        {@link StreamInput}
         * @param builderParser a parser that reads the suggester's builder from xcontent
         * @param parser the parser the reads the aggregation builder from xcontent
import org.opensearch.index.query.QueryParser;
         * Specification of custom {@link Suggester}.  
    default List<ScoreFunctionSpec<?>> getScoreFunctions() {  
         * Build the spec with a String.  
        return Optional.empty();
         * @param reader the reader registered for this rescorer's builder. Typically, a reference to a constructor that takes a
         * Specification of custom {@link ScoreFunctionBuilder}.
import org.opensearch.threadpool.ThreadPool;  
import java.util.function.BiFunction;  
     */  
            return parser;  
         */
        public Map<String, Writeable.Reader<? extends InternalAggregation>> getResultReaders() {  
        public FetchPhaseConstructionContext(Map<String, Highlighter> highlighters) {
         */
         * Returns the reader used to read the {@link Suggest.Suggestion} generated by this suggester  
         *        is the name by under which the readers are registered. So it is the name that the {@link PipelineAggregationBuilder} and
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with  
         *        {@link StreamInput}  
 * SPDX-License-Identifier: Apache-2.0
        return emptyList();
        public Writeable.Reader<? extends CompositeValuesSourceBuilder<?>> getReader() {
         *        another registered name, including names from other plugins.  
         * @deprecated Use the ctor that takes a {@link ContextParser} instead
    /**
 *  
         *
        }  
         * Specification of custom {@link Suggester}.  
            return highlighters;  
        ) {
        /**
            super(name, reader, parser);  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * The new {@link Suggester}s defined by this plugin.  
         *        {@link StreamInput}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
         * as the {@link NamedWriteable#getWriteableName()}.
    }
         *        {@link StreamInput}
        public ScoreFunctionSpec(ParseField name, Writeable.Reader<T> reader, ScoreFunctionParser<T> parser) {
    }  
         *        another registered name, including names from other plugins.  
    }  
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,  
         *        that takes a {@link StreamInput}  
     * @param <W> the type of the main {@link NamedWriteable} for this spec. All specs have this but it isn't always *for* the same thing  
         * Specification of custom {@link SearchExtBuilder}.
            ParseField name,
        /**
         *                            aggregation
         *        that is the name that W's {@link NamedWriteable#getWriteableName()} returns.  It is an error if  
            return resultReaders;
    interface ExecutorServiceProvider {
    }  
    default List<RescorerSpec<?>> getRescorers() {
        /**  
         * Add a reader for the shard level results of the aggregation.
        PipelineAggregationBuilder,
import java.util.Optional;  
     * The new {@link PipelineAggregator}s added by this plugin.
        }
         * @param parser the parser function that reads the rescorer builder from xcontent
        /**
/*  
 * You may obtain a copy of the License at  
            ParseField name,  
         */
         *        that takes a {@link StreamInput}
            final Class<? extends CompositeValuesSourceBuilder<?>> valueSourceBuilderClass,
import org.opensearch.search.aggregations.pipeline.MovAvgPipelineAggregator;
          byte code
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
     * The new {@link FetchSubPhase}s defined by this plugin.  
         * @param reader the reader registered for this heuristic. Typically, a reference to a constructor that takes a
        return emptyList();
    default List<Consumer<ValuesSourceRegistry.Builder>> getAggregationExtentions() {
    default List<SuggesterSpec<?>> getSuggesters() {
         */
        @Deprecated
            this(new ParseField(name), reader, parser);  
 */  
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a  
        }
         *        {@link StreamInput}  
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
    /**
         */  
    }
        }
 * license agreements. See the NOTICE file distributed with
        }  
         */
 * The OpenSearch Contributors require contributions made to  
        public AggregationSpec(ParseField name, Writeable.Reader<? extends AggregationBuilder> reader, Aggregator.Parser parser) {
        /* This is added for backward compatibility, you don't need to set it, as we use aggregationType instead of
         *        an error if {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.
        ContextParser<String, ? extends PipelineAggregationBuilder>> {  
         *        is the name by under which the reader is registered. So it is the name that the score function should use as its
        ) {
            return aggregatorRegistrar;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
         * @param parser reads the aggregation builder from XContent  
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including  
    /**
         *  
            super(name, builderReader, parser);
 *
        public Writeable.Reader<? extends W> getReader() {
        private final Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar;
            return aggregatorRegistrar;
            return name;
         * @param name the name by which this search ext might be parsed or deserialized. Make sure that the search ext builder returns this name for
            super(name, reader, parser);
        public AggregationSpec addResultReader(String writeableName, Writeable.Reader<? extends InternalAggregation> resultReader) {  
    default List<SearchExtensionSpec<MovAvgModel, MovAvgModel.AbstractModelParser>> getMovingAverageModels() {
         *        {@link NamedWriteable#getWriteableName()}. It is an error if this name conflicts with another registered name, including
        }  
        private final Map<String, Writeable.Reader<? extends InternalAggregation>> resultReaders = new TreeMap<>();
         * The name of the thing being specified as a {@link ParseField}. This allows it to have deprecated names.
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;  
package org.opensearch.plugins;
        }  
     */
    default Optional<ExecutorServiceProvider> getIndexSearcherExecutorProvider() {
    }
        public SuggesterSpec(  
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including  
         * @param reader the reader registered for this sort's builder. Typically, a reference to a constructor that takes a
        public RescorerSpec(ParseField name, Writeable.Reader<? extends T> reader, CheckedFunction<XContentParser, T, IOException> parser) {
         * @param aggregationType a {@link String} defined in the AggregationBuilder as type.  
        /**
         *        is the name by under which the reader is registered. So it is the name that the search ext should use as its
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
        }  
            return aggregationType;
         * @param reader reader that reads the behavior from the internode protocol
         * @param reader the reader registered for this search ext's builder. Typically, a reference to a constructor that takes a
        return emptyList();
    default List<AggregationSpec> getAggregations() {
         * Specification of custom {@link Query}.  
        public SortSpec(ParseField name, Writeable.Reader<T> reader, SortParser<T> parser) {
         * @param parser the parser the reads the score function builder from xcontent
            super(name, builderReader, (p, n) -> parser.parse(n, p));  
        }  
        /**
         * this aggregation
    class SearchExtensionSpec<W extends NamedWriteable, P> {
    default Map<String, Highlighter> getHighlighters() {
         *
        @Deprecated  
         */
         *
    default List<SearchExtSpec<?>> getSearchExts() {  
         */
        }
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
import org.opensearch.search.sort.SortParser;
         * Specification of a {@link PipelineAggregator}.
    /**
        }
            String name,
            return reader;  
            super(name, reader, parser);  
         *        another registered name, including names from other plugins.
    interface ProfileMetricsProvider {  
        }
         * @param builderReader the reader registered for this suggester's builder. Typically, a reference to a constructor that takes a
         */
        public AggregationSpec addResultReader(Writeable.Reader<? extends InternalAggregation> resultReader) {
        private final Class<?> valueSourceBuilderClass;
         * @param name the name by which this aggregation might be parsed or deserialized. Make sure that the {@link AggregationBuilder}
         * @param parser the parser the reads the sort builder from xcontent  
         */
         * @param name holds the names by which this query might be parsed. The {@link ParseField#getPreferredName()} is special as it
    /**
         *        {@link PipelineAggregator} should return from {@link NamedWriteable#getWriteableName()}.  It is an error if
         * @return profile metric supplier  
         *
     * Executor service provider  
            super(name, reader, (p, aggName) -> parser.parse(aggName, p));
     */  
    /**
import org.opensearch.search.fetch.FetchSubPhase;
            this.valueSourceBuilderClass = valueSourceBuilderClass;
    }  
        /**
        public ScoreFunctionSpec(String name, Writeable.Reader<T> reader, ScoreFunctionParser<T> parser) {
import java.util.concurrent.ExecutorService;
        }
        /**
         *
        }
 * @opensearch.api
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,
            return addResultReader(getName().getPreferredName(), resultReader);  
    }
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        public SignificanceHeuristicSpec(String name, Writeable.Reader<T> reader, BiFunction<XContentParser, Void, T> parser) {
        public <T extends AggregationBuilder> AggregationSpec(String name, Writeable.Reader<T> reader, ContextParser<String, T> parser) {  
        public P getParser() {
         * @param name holds the names by which this search ext might be parsed. The {@link ParseField#getPreferredName()} is special as it
         */
            return valueSourceBuilderClass;
    }
            final CompositeAggregationParsingFunction parsingFunction,
    class AggregationSpec extends SearchExtensionSpec<AggregationBuilder, ContextParser<String, ? extends AggregationBuilder>> {  
        }  
         * Add a reader for the shard level results of the aggregation with {@linkplain #getName()}'s {@link ParseField#getPreferredName()}  
         * Specification of custom {@link Sort}.
        /**  
            Writeable.Reader<T> builderReader,
         * @param parser parser that read the behavior from a REST request  
         *  
     */
         * Specification of custom {@link SearchExtBuilder}.  
         *        {@link StreamInput}
         */
     * The new {@link QueryPhaseSearcher} added by this plugin. At the moment, only one {@link QueryPhaseSearcher} is supported per  
            super(name, reader, parser);
    /**
         * @param name holds the names by which this aggregation might be parsed. The {@link ParseField#getPreferredName()} is special as it  
         * @param parser reads the aggregation builder from XContent  
            final Byte byteCode,
        ) {
         * @param builderParser a parser that reads the suggester's builder from xcontent
         * @param name holds the names by which this suggester might be parsed. The {@link ParseField#getPreferredName()} is special as it
     * The new {@link Sort}s defined by this plugin.
        }
        /**
         *        {@link PipelineAggregationBuilder} and {@link PipelineAggregator} should return from
         *        names from other plugins.  
        }  
        /**  
     * Specification for a {@link PipelineAggregator}.
         * @param reader the reader registered for this rescorer's builder. Typically, a reference to a constructor that takes a  
        public PipelineAggregationSpec addResultReader(String writeableName, Writeable.Reader<? extends InternalAggregation> resultReader) {
         *        {@link StreamInput}  
         * @param parser the parser the reads the score function builder from xcontent  
            super(name, reader, parser);  
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
         * @param reader the reader registered for this query's builder. Typically, a reference to a constructor that takes a  
import org.opensearch.search.internal.SearchContext;
         * Get the function to register the {@link org.opensearch.search.aggregations.support.ValuesSource} to aggregator mappings for
import org.opensearch.search.aggregations.Aggregator;
            resultReaders.put(writeableName, resultReader);
         * @param reader the reader registered for this heuristic. Typically, a reference to a constructor that takes a
         *  
        public <T extends AggregationBuilder> AggregationSpec(  
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
         * @param suggestionReader the reader registered for this suggester's Suggestion response. Typically, a reference to a constructor  
        /**  
        /**
     */
        return emptyList();  
    /**  
     */
            String name,  
         * @deprecated prefer the ctor that takes a {@link ContextParser}  
         * @param name name by which this aggregation might be parsed or deserialized. Make sure it is the name that the  
     */
         * @param name holds the names by which this rescorer might be parsed. The {@link ParseField#getPreferredName()} is special as it  
        return emptyList();  
         * Specification of custom {@link RescorerBuilder}.
            super(name, reader, parser);
            return this.suggestionReader;  
        }
         *        names from other plugins.
import org.opensearch.common.settings.Settings;
        @Deprecated  
        /**
    /**
 * Modifications Copyright OpenSearch Contributors. See
         *
        return Optional.empty();
        private final ParseField name;  
            Writeable.Reader<? extends PipelineAggregationBuilder> builderReader,  
        /**
        }
        ExecutorService getExecutor(ThreadPool threadPool);
         *        from {@link NamedWriteable#getWriteableName()}. It is an error if {@link ParseField#getPreferredName()} conflicts with  
    }  
         *
         *
         */
            super(name, reader, parser);
    /**  
     * Specification of custom {@link Sort}.  
        Collection<Supplier<ProfileMetric>> getQueryProfileMetrics(SearchContext searchContext, Query query);
         *        response reader return this name for {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts  
         *        {@link StreamInput}  
        /**  
     * @return A list of the new registrar functions  
         */  
        private final CompositeAggregationParsingFunction parsingFunction;
            setSuggestionReader(suggestionReader);
import org.apache.lucene.search.Query;
            this.aggregatorRegistrar = aggregatorRegistrar;
        public AggregationSpec(String name, Writeable.Reader<? extends AggregationBuilder> reader, Aggregator.Parser parser) {  
         * Specification of a {@link PipelineAggregator}.
import org.opensearch.search.rescore.RescorerBuilder;  
        public QuerySpec(ParseField name, Writeable.Reader<T> reader, QueryParser<T> parser) {
    /**
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
    }
    }  
     */  
    default List<SortSpec<?>> getSorts() {
        public RescorerSpec(String name, Writeable.Reader<? extends T> reader, CheckedFunction<XContentParser, T, IOException> parser) {
        return emptyList();  
/*  
         *        {@link StreamInput}
import static java.util.Collections.emptyList;
            CheckedFunction<XContentParser, T, IOException> builderParser,
import java.util.Map;
         *        {@link StreamInput}
    /**  
        ) {
        @Deprecated
        /**
 * compatible open source license.
        }
        }
        }
         *        {@link StreamInput}
         * Specification of a {@link PipelineAggregator}.
public interface SearchPlugin {  
        public Writeable.Reader<? extends Suggest.Suggestion> getSuggestionReader() {
         * @param valueSourceBuilderClass ValueSourceBuilder class name which is building the aggregation  
     * {@link SignificantTerms} aggregation to pick which terms are significant for a given query.  
import java.util.function.Supplier;
    default Optional<QueryPhaseSearcher> getQueryPhaseSearcher() {
    }
        /**  
     */  
         *        {@link PipelineAggregationBuilder} and {@link PipelineAggregator} should return from
         *        name that W's {@link NamedWriteable#getWriteableName()} returns.  It is an error if this name conflicts with another  
            super(name, reader, parser);
        ) {
         *
        return emptyMap();
        /**
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
import org.opensearch.search.aggregations.Aggregation;
    /**  
            final String aggregationType
import org.opensearch.search.fetch.subphase.highlight.Highlighter;  
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
         * @param name holds the names by which this score function might be parsed. The {@link ParseField#getPreferredName()} is special as it  
        /**
         *        {@link StreamInput}
     * parsed in a search request (within the ext element).
            Writeable.Reader<? extends Suggest.Suggestion> suggestionReader  
         * @param threadPool thread pool
         *        {@link ParseField#getPreferredName()} conflicts with another registered name, including names from other plugins.  
     * The new {@link Rescorer}s added by this plugin.
 *
         * @param name the name of the behavior. The parser and the reader are registered under this name so be sure that is the
         * @param byteCode byte code which is used in serialisation and de-serialisation to indentify which
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
     * Specification for a {@link Suggester}.
         * @param parsingFunction a reference function which will be used to parse the Aggregation input.
            Writeable.Reader<? extends Suggest.Suggestion> suggestionReader
            final Writeable.Reader<? extends CompositeValuesSourceBuilder<?>> reader,  
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including  
            resultReaders.put(writeableName, resultReader);
     * in Core, as long as the new aggregations target different ValuesSourceTypes
            super(name, builderReader, parser);  
 * Licensed to Elasticsearch under one or more contributor  
     *        behavior to execute  
         * @param name holds the names by which this heuristic might be parsed. The {@link ParseField#getPreferredName()} is special as it
         * The reader responsible for reading the behavior from the internode protocol.
         * @param parser parser that read the behavior from a REST request  
        public Class<?> getValueSourceBuilderClass() {
         */  
        return emptyList();
        /**  
     * The executor service provider (registered through {@link Plugin#getExecutorBuilders(Settings)} to be used at search  
         */
         */
        }
         *        another registered name, including names from other plugins.
        /**
        }  
     */
import org.apache.lucene.search.Sort;  
        /**  
         *        is the name by under which the reader is registered. So it is the name that the sort should use as its
         */
            this.suggestionReader = reader;
        /**
    /**
import org.apache.lucene.search.IndexSearcher;
        }
        return emptyList();
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with
     */
    }
            this.aggregatorRegistrar = aggregatorRegistrar;
    }
        public Map<String, Highlighter> getHighlighters() {
            ContextParser<String, ? extends PipelineAggregationBuilder> parser
    default List<CompositeAggregationSpec> getCompositeAggregations() {
         *        is the name by under which the reader is registered. So it is the name that the query should use as its  
import java.util.List;
         * @param parser the parser the reads the aggregation builder from xcontent
    }
        }  
         */  
            ParseField name,
         *               registered with the aggregation
         */
        public PipelineAggregationSpec(
         * @deprecated Use the ctor that takes a {@link ContextParser} instead  
        /**
        private void setSuggestionReader(Writeable.Reader<? extends Suggest.Suggestion> reader) {
    /**
         * Specification of custom {@link Query}.  
     */
    class SortSpec<T extends SortBuilder<T>> extends SearchExtensionSpec<T, SortParser<T>> {
            ParseField name,
         * Provides an executor service instance
         * Specification for an {@link Aggregation}.
     * Allows plugins to register a factory to create custom decider for concurrent search  
 * Unless required by applicable law or agreed to in writing,
         *        names from other plugins.
         * @param suggestionReader the reader registered for this suggester's Suggestion response. Typically, a reference to a constructor
         * Specification for an {@link Aggregation}.
     *
         * Specification of custom {@link SignificanceHeuristic}.
         *        is the name by under which the reader is registered. So it is the name that the rescorer should use as its
     * The new {@link Query}s defined by this plugin.
        public CompositeAggregationParsingFunction getParsingFunction() {  
         * Get the readers that must be registered for this aggregation's results.  
            super(name, reader, parser);
import static java.util.Collections.emptyMap;
        /**  
        /**  
import org.opensearch.search.suggest.Suggester;
            Writeable.Reader<T> reader,
    }  
    }  
         */  
            return this;  
     */  
         *
         *        names from other plugins.
         *        registered name, including names from other plugins.
 * this file be licensed under the Apache-2.0 license or a
        }  
    /**  
     * The new {@link SearchExtBuilder}s defined by this plugin.
            CheckedFunction<XContentParser, T, IOException> builderParser,  
         * @param name name by which this aggregation might be parsed or deserialized. Make sure it is the name that the
     */  
        }
         *
import org.opensearch.common.annotation.ExperimentalApi;
     * instance, the {@link IllegalStateException} is going to be thrown if more then one plugin tries to register
    default List<PipelineAggregationSpec> getPipelineAggregations() {  
         *        {@link NamedWriteable#getWriteableName()} too.  It is an error if {@link ParseField#getPreferredName()} conflicts with  
            return byteCode;  
import org.opensearch.search.rescore.Rescorer;
        public AggregationSpec setAggregatorRegistrar(Consumer<ValuesSourceRegistry.Builder> aggregatorRegistrar) {  
    }
         * @param reader the reader registered for this score function's builder. Typically, a reference to a constructor that takes a  
        return Optional.empty();  
         * @param reader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
import org.opensearch.search.query.QueryPhaseSearcher;
        }
            this.reader = reader;  
        }  
         *        {@link StreamInput}
     * plugin tries to register index searcher executor.
     * Specification of custom {@link SignificanceHeuristic}.
    /**  
        private final String aggregationType;  
     * time by {@link IndexSearcher}. The {@link IllegalStateException} is going to be thrown if more then one
         *        is the name by under which the request builder and Suggestion response readers are registered. So it is the name that the  
        public SortSpec(String name, Writeable.Reader<T> reader, SortParser<T> parser) {
         * Specification of a {@link PipelineAggregator}.
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationParsingFunction;
import org.opensearch.index.query.functionscore.ScoreFunctionParser;  
        /**
     */
 * specific language governing permissions and limitations
         *        another registered name, including names from other plugins.  
         *  
         */
         *        names from other plugins.  
         *        {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another registered name, including
    }
import org.opensearch.core.xcontent.XContentParser;
    default List<QuerySpec<?>> getQueries() {  
 */
         *  
import java.util.TreeMap;
        public PipelineAggregationSpec(
         *
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
        public SuggesterSpec(
         *        registered name, including names from other plugins.
    /**  
         * @param parser the parser function that reads the search ext builder from xcontent
    }
import org.opensearch.search.aggregations.PipelineAggregationBuilder;  
            Writeable.Reader<? extends T> reader,
     * Specification for an {@link Aggregation}.
     * Context available during fetch phase construction.
         *
import org.opensearch.search.profile.ProfileMetric;
     */
         * Specification of custom {@link ScoreFunctionBuilder}.
        private final Map<String, Writeable.Reader<? extends InternalAggregation>> resultReaders = new TreeMap<>();
    /**  
    class SuggesterSpec<T extends SuggestionBuilder<T>> extends SearchExtensionSpec<T, CheckedFunction<XContentParser, T, IOException>> {
     */
         * Set the function to register the {@link org.opensearch.search.aggregations.support.ValuesSource} to aggregator mappings for  
         */
    /**  
         *        {@link StreamInput}
 * not use this file except in compliance with the License.
            return this;
            return this;
    class CompositeAggregationSpec {  
         * @param builderReader the reader registered for this aggregation's builder. Typically, a reference to a constructor that takes a
        }
        return emptyList();
         * Specification for an {@link Aggregation}.
import org.opensearch.search.aggregations.pipeline.MovAvgModel;  
    /**
         *        returns this from {@link NamedWriteable#getWriteableName()}.  It is an error if this name conflicts with another  
        ) {
 * Plugin for extending search time behavior.
    }
        private Writeable.Reader<? extends Suggest.Suggestion> suggestionReader;  
         *        query and Suggestion response should use as their {@link NamedWriteable#getWriteableName()} return values too.  It is
         *        {@link StreamInput}  
         *        another registered name, including names from other plugins.
         *        another registered name, including names from other plugins.
            ParseField name,
import org.opensearch.core.common.io.stream.Writeable;
        }  
    class PipelineAggregationSpec extends SearchExtensionSpec<
        /**  
import org.opensearch.common.CheckedFunction;
         * @return executor service instance  
        }
    default List<QueryCollectorContextSpecFactory> getCollectorContextSpecFactories() {
         *  
     */
     */
         * @param reader the reader registered for this search ext's builder. Typically, a reference to a constructor that takes a
         *
        return emptyList();  
            this.parser = parser;
         */
        }
         */
            CheckedFunction<XContentParser, T, IOException> parser  
         */
        ) {
            return resultReaders;  
         */  
         * @param name the name by which this suggester might be parsed or deserialized. Make sure that the query builder and Suggestion
         *
         * @param reader the reader registered for this query's builder. Typically, a reference to a constructor that takes a
            super(name, reader, parser);
     * @return A {@link ConcurrentSearchRequestDecider.Factory}
        }
import org.opensearch.core.common.io.stream.StreamInput;
     * model trends in data.
         *        {@link StreamInput}
         *
         * @param name the name of the behavior as a {@linkplain ParseField}. The parser is registered under all names specified by the
         *        is the name by under which the readers are registered. So it is the name that the {@link PipelineAggregationBuilder} and
     * Plugin Profiler provider
            this.highlighters = highlighters;
    }  
}  
            this.parsingFunction = parsingFunction;
         * @param reader Typically, a reference to a constructor that takes a {@link StreamInput}, which is  
         */
         * @param name the name by which this rescorer might be parsed or deserialized. Make sure that the rescorer builder returns this name for  
         * @param name holds the names by which this sort might be parsed. The {@link ParseField#getPreferredName()} is special as it  
         * the {@link NamedWriteable#getWriteableName()}.  
     * Specification for including an aggregation as a part of Composite Aggregation.
 */
     * Specification for a {@link SearchExtBuilder} which represents an additional section that can be  
     * @param <P> the type of the parser for this spec. The parser runs on the coordinating node, converting {@link XContent} into the
         * @param parser the parser function that reads the heuristic from xcontent
         *        with another registered name, including names from other plugins.
        @Deprecated
    }  
        }
         * @param parser the parser the reads the query builder from xcontent
            super(name, reader, parser);
    /**  
         * Specification for an {@link Aggregation}.  
         *        {@link StreamInput}
         *        is the name by under which the reader is registered. So it is the name that the {@link AggregationBuilder} should return
         * @param name the name by which this score function might be parsed or deserialized. Make sure that the score function builder returns this name for  
        public CompositeAggregationSpec(
        private final Writeable.Reader<? extends CompositeValuesSourceBuilder<?>> reader;
         * @param reader the reader registered for this sort's builder. Typically, a reference to a constructor that takes a  
     * The new {@link ScoreFunction}s defined by this plugin.
        return emptyList();  
        public String getAggregationType() {
    }
     * @return A {@link List} of {@link CompositeAggregationSpec}  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    }  
     */
        public QuerySpec(String name, Writeable.Reader<T> reader, QueryParser<T> parser) {  
    class ScoreFunctionSpec<T extends ScoreFunctionBuilder<T>> extends SearchExtensionSpec<T, ScoreFunctionParser<T>> {
         *  
    }
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
            super(name, builderReader, builderParser);
        }  
