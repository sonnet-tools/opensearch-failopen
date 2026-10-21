                } else {
                    aggBuilder.setMetadata(metadata);
     * Parses the aggregation request recursively generating aggregator
    /**
            }
        }
                if (aggBuilder instanceof AggregationBuilder aggregationBuilder) {
            Map<String, AggregationBuilder> aggBuildersMap = new HashMap<>();
            for (AggregationBuilder agg : aggregationBuilders) {
                        + "], expected a ["
         * Build a tree of {@link PipelineAggregator}s to modify the tree of
            int pipelineFactoriesSize = in.readVInt();
            Collection<PipelineAggregationBuilder> pipelineAggregatorBuilders,
                context.addValidationError(iae.getMessage());
                                    for (PipelineAggregationBuilder subFactory : subPipelineBuilders) {
            }
                            try {
            }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                newBuilder.addPipelineAggregator(result);
                                        + "]"
        private final Collection<AggregationBuilder> aggregationBuilders = new LinkedHashSet<>();
                if (token != XContentParser.Token.FIELD_NAME) {
                            + token
                                throw new ParsingException(new XContentLocation(ex.getLineNumber(), ex.getColumnNumber()), message, ex);
                                        + "] and ["
    }
                long maxBucket = searchContext.getStreamingMaxEstimatedBucketCount();
             */
            if (!validAggMatcher.reset(aggregationName).matches()) {
        @Override
                    subAgg.toXContent(builder, params);
            boolean changed = false;
                            if (aggBuilder != null) {
                                }
 * not use this file except in compliance with the License.
import java.util.regex.Pattern;
                                String message = String.format(
            }
    }
                                // Check the pipeline sub-aggregator factories
    private final AggregatorFactory[] factories;
                }
                    orderedPipelineAggregatorrs,
                e = agg.factoriesBuilder.validateChildren(context.getValidationException());
            if (pipelineAggregatorBuilders != null) {
        ) {
        private void resolvePipelineAggregatorOrder(
import java.util.ArrayList;
        }
                throw new ParsingException(
            List<PipelineAggregationBuilder> unmarkedBuilders,
        }
                    return true;
            return false;
            if (searchContext.isCancelled()) {
 * Licensed to Elasticsearch under one or more contributor
                                    Collection<PipelineAggregationBuilder> subPipelineBuilders =
            Collection<PipelineAggregationBuilder> temporarilyMarked,
                            + "] in ["
                    metrics.streamable(),
            );
    public List<Aggregator> createTopLevelNonGlobalAggregators(SearchContext searchContext) throws IOException {
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
                                break;
            return new AggregatorFactories(aggFactories);
                    aggBuildersMap,
 *
    /**
import java.util.HashSet;
        private List<PipelineAggregationBuilder> resolvePipelineAggregatorOrder(
         * Validate a the pipeline aggregations in this factory.
                            }
            }
        }
import org.opensearch.core.xcontent.ToXContentObject;
                for (AggregationBuilder subAgg : aggregationBuilders) {
            }
import org.opensearch.search.aggregations.support.AggregationPath;
                for (String bucketsPath : bucketsPaths) {
                builder.validate(context);
                    throw new ParsingException(
                    factory = new ProfilingAggregator(factory, profilers.getAggregationProfiler());
            if (aggregationBuilders != null) {
                                        "No aggregation [" + aggName + "] found for path [" + bucketsPath + "]"
         */
     */
            for (AggregationBuilder agg : aggregationBuilders) {
import java.io.IOException;
            if (profilers != null) {
import org.opensearch.core.xcontent.XContentParser;
        }
import org.opensearch.index.query.Rewriteable;
            Map<String, AggregationBuilder> aggBuildersMap,
            List<PipelineAggregationBuilder> orderedPipelineAggregatorrs = new LinkedList<>();
                            metadata = parser.map();
                            + token
        public Builder addAggregator(AggregationBuilder factory) {
import org.opensearch.core.xcontent.XContentBuilder;
        return factories.length;
                    maxBucket
            Builder newBuilder = new Builder();
            return new PipelineTree(subTrees, aggregators);
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                                    throw new IllegalArgumentException(
        }
            }
 */
                Profilers profilers = factory.context().getProfilers();
                        case "aggs":
                                throw new ParsingException(
        return createTopLevelAggregators(searchContext, GLOBAL_AGGREGATOR_FACTORY_PREDICATE.negate());
            for (int i = 0; i < factoriesSize; i++) {
                );
                );
            if (obj == null) return false;
            }
                    if (bucketsPath.equals("_count") || bucketsPath.equals("_key")) {
                            } catch (NamedObjectNotFoundException ex) {
            aggregationBuilders.add(factory);
    public boolean hasNonGlobalAggregator() {
        @Override
package org.opensearch.search.aggregations;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            builder.startObject();
        // ordered nicely, although technically order does not matter
                token = parser.nextToken();
                throw new IllegalArgumentException("Two sibling aggregations cannot have the same name: [" + factory.name + "]");
 */
            List<PipelineAggregationBuilder> unmarkedBuilders = new ArrayList<>(pipelineAggregatorBuilders);
 * ownership. Elasticsearch licenses this file to you under
/**
            Collection<PipelineAggregationBuilder> temporarilyMarked = new HashSet<>();
            aggregators[i] = factory;
            out.writeVInt(this.aggregationBuilders.size());
                                // Check the non-pipeline sub-aggregator
            List<PipelineAggregationBuilder> orderedPipelineAggregators;
import org.opensearch.index.query.QueryRewriteContext;
                } else if (builder instanceof TermsAggregationBuilder termsAggregationBuilder) {
                throw new IllegalArgumentException("Cyclical dependency found with pipeline aggregator [" + builder.getName() + "]");
            Map<String, PipelineAggregationBuilder> pipelineAggregatorBuildersMap = new HashMap<>();
        @Override
         * returned otherwise the builder will be rewritten infinitely.
                throw new ParsingException(
                            + "] in ["
import org.opensearch.search.aggregations.bucket.global.GlobalAggregatorFactory;
public class AggregatorFactories {
            while (!unmarkedBuilders.isEmpty()) {
import org.opensearch.core.common.io.stream.Writeable;
                temporarilyMarked.add(builder);
                        parser.getTokenLocation(),
                                            foundSubBuilder = true;
            for (PipelineAggregationBuilder builder : orderedPipelineAggregators) {
            Builder other = (Builder) obj;
    /**
        return createTopLevelAggregators(searchContext, (aggregatorFactory) -> true);
         */
            for (AggregationBuilder factory : aggregationBuilders) {
                        "Expected ["
                }
        /**
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public Builder addPipelineAggregator(PipelineAggregationBuilder pipelineAggregatorFactory) {
                            );
                    }
        }
                    } else {
            validatePipelines(context);
                        AggregationBuilder aggBuilder = aggBuildersMap.get(firstAggName);
        }
        @Override
    private static AggregatorFactories.Builder parseAggregators(XContentParser parser, int level) throws IOException {
        return createTopLevelAggregators(searchContext, GLOBAL_AGGREGATOR_FACTORY_PREDICATE);
            return validateChildren(context.getValidationException());
                            throw new IllegalArgumentException("No aggregation found for path [" + bucketsPath + "]");
import org.opensearch.core.common.io.stream.StreamOutput;
            if (factories.length == 0) {
import org.opensearch.core.common.ParsingException;
                        parser.getTokenLocation(),
                        + "]. Aggregation names can contain any character except '[', ']', and '>'"
        List<Aggregator> aggregators = new ArrayList<>();
        }
                                        aggBuilder.factoriesBuilder.pipelineAggregatorBuilders;
        }
import org.opensearch.search.aggregations.support.AggregationPath.PathElement;
            }
        }
            searchContext.setFlushModeIfAbsent(decision);
                                }
     * @opensearch.api
                return EMPTY;
        }
         * aggregation results after the final reduction.
                        continue;
/*
            for (AggregationBuilder builder : aggregationBuilders) {
                .map(PipelineAggregationBuilder::create)
    public AggregatorFactory[] getFactories() {
            PipelineAggregationBuilder builder
import org.opensearch.core.tasks.TaskCancelledException;
     *                    that {@link Aggregator}s created by this method will
                            + aggregationName
                        + "]."
                return;
                                    );
            }
        }
                aggFactories[i] = agg.build(queryShardContext, parent);
import java.util.Map;
     */
         */
                    parser.getTokenLocation()
                            break;
     */
        public void writeTo(StreamOutput out) throws IOException {
                                boolean foundSubBuilder = false;
    /**
    public static AggregatorFactories.Builder parseAggregators(XContentParser parser) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        return parseAggregators(parser, 0);
                if (metadata != null) {
                    "Unexpected token " + token + " in [aggs]: aggregations definitions must start with the name of the aggregation."
                    aggBuilder.subAggregations(subFactories);
 * Unless required by applicable law or agreed to in writing,
                                        if (aggName.equals(subFactory.getName())) {
     * @param cardinality Upper bound of the number of {@code owningBucketOrd}s
                                    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.streaming.StreamingCostMetrics;
import java.util.LinkedList;
    public static final Pattern VALID_AGG_NAME = Pattern.compile("[^\\[\\]>]+");
            List<PipelineAggregator> aggregators = resolvePipelineAggregatorOrder(pipelineAggregatorBuilders, aggregationBuilders).stream()
import org.opensearch.search.streaming.FlushMode;
                }
                    builder
         */
                e
                        }
            return o instanceof GlobalAggregatorFactory;
                            + "], but got a ["
import static java.util.stream.Collectors.toList;
                        + XContentParser.Token.START_OBJECT
         * Rewrites the underlying aggregation builders into their primitive
                    switch (fieldName) {
                                    Locale.ROOT,
        }
                            + XContentParser.Token.START_OBJECT
                                );
import java.util.LinkedHashSet;
                pipelineAggregatorBuilders,
    public List<Aggregator> createTopLevelGlobalAggregators(SearchContext searchContext) throws IOException {
                aggregationBuilders,
                    "Aggregation definition for ["
            if (aggregationBuilders.isEmpty() && pipelineAggregatorBuilders.isEmpty()) {
}
        public int hashCode() {
            }
 * the Apache License, Version 2.0 (the "License"); you may
        }
            Map<String, PipelineTree> subTrees = aggregationBuilders.stream()
        }
                                    parser.getTokenLocation(),
import java.util.List;
                decision = FlushModeResolver.decideFlushMode(metrics, FlushMode.PER_SHARD, maxBucket);
        public int count() {
 * @opensearch.api
            return this;
        return Arrays.stream(factories).anyMatch(GLOBAL_AGGREGATOR_FACTORY_PREDICATE);
            }
                        default:
                                aggBuildersMap,
            /*
             * Top level aggs only collect from owningBucketOrd 0 which is
import org.opensearch.core.common.Strings;
        public String toString() {
                );
                    factories.addPipelineAggregator((PipelineAggregationBuilder) aggBuilder);
        }
                                    fieldName,
     *
        public boolean mustVisitAllDocs() {
            } catch (IllegalArgumentException iae) {
     * @return the number of sub-aggregator factories
                        if (matchingBuilder != null) {
                            subFactories = parseAggregators(parser, level + 1);
        for (int i = 0; i < factories.length; ++i) {
                newBuilder.addAggregator(result);
                    temporarilyMarked,
                            String aggName = pathElement.name;
                out.writeNamedWriteable(factory);
                    parser.getTokenLocation(),
                );
            AggregatorFactories.Builder subFactories = null;
        // These aggregators are going to be used with a single bucket ordinal, no need to wrap the PER_BUCKET ones
import java.util.Collections;
@PublicApi(since = "1.0.0")
            for (int i = 0; i < pipelineFactoriesSize; i++) {
        this.factories = factories;
        public ActionRequestValidationException validate(ActionRequestValidationException e) {
                        } else {
        public Builder(StreamInput in) throws IOException {
import java.util.regex.Matcher;
            }
                PipelineAggregationBuilder.ValidationContext context = PipelineAggregationBuilder.ValidationContext.forInsideTree(agg, e);
                        case "meta":
                                            break;
         * Validate a the children of this factory.
        return aggregators;
    }
            } else if (unmarkedBuilders.contains(builder)) {
    public static class Builder implements Writeable, ToXContentObject {
                                        aggBuilder = subBuilder;
     * A mutable collection of {@link AggregationBuilder}s and
        private void validatePipelines(PipelineAggregationBuilder.ValidationContext context) {
        }
 */
                        }
            Aggregator factory = factories[i].create(searchContext, parent, cardinality);
            return Objects.hash(aggregationBuilders, pipelineAggregatorBuilders);
                    unmarkedBuilders,
                                );
            int i = 0;
                            + "]"
        return true;
    private static final Predicate<AggregatorFactory> GLOBAL_AGGREGATOR_FACTORY_PREDICATE = new Predicate<>() {
    }
            }
        return new Builder();
                StreamingCostMetrics metrics = StreamingCostMetrics.estimateFromFactories(factories, searchContext);
                );
            }
    }
                final String fieldName = parser.currentName();
                decision = FlushMode.PER_SHARD;
                    String firstAggName = bucketsPathElements.get(0).name;
        // Using LinkedHashSets to preserve the order of insertion, that makes the results
        return true;
                    );
            if (!Objects.equals(pipelineAggregatorBuilders, other.pipelineAggregatorBuilders)) return false;
            List<PipelineAggregationBuilder> orderedPipelineAggregators,
                            }
 * license agreements. See the NOTICE file distributed with
                            }
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.xcontent.MediaTypeRegistry;
            return this;
            }
                ++i;
                    parser.getTokenLocation(),
                    } else if (aggBuildersMap.containsKey(firstAggName)) {
                        case "aggregations":
                resolvePipelineAggregatorOrder(
                    }
            return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        private final Set<String> names = new HashSet<>();
import org.opensearch.core.xcontent.XContentLocation;
                    subAgg.toXContent(builder, params);
                            PathElement pathElement = bucketsPathElements.get(i);
                .collect(toMap(AggregationBuilder::getName, AggregationBuilder::buildPipelineTree));
                agg.factoriesBuilder.validatePipelines(context);
 * The OpenSearch Contributors require contributions made to
                                        + fieldName
         */
            if (!Objects.equals(aggregationBuilders, other.aggregationBuilders)) return false;
                }
import java.util.Set;
                    "Missing definition for aggregation [" + aggregationName + "]",
                                for (AggregationBuilder subBuilder : subBuilders) {
                            break;
                                    "Found two aggregation type definitions in ["
import java.util.Collection;
                    metrics.topNSize(),
             * *exactly* what CardinalityUpperBound.ONE *means*.
            }
                PipelineAggregationBuilder builder = unmarkedBuilders.get(0);
            }
                }
 * compatible open source license.
                            if (subFactories != null) {
            Aggregator factory;
        public boolean test(AggregatorFactory o) {
        }
import org.opensearch.common.annotation.PublicApi;
        public boolean equals(Object obj) {
            }
     */
            }
                orderedPipelineAggregators = resolvePipelineAggregatorOrder(pipelineAggregatorBuilders, aggregationBuilders);
                            }
                throw new ParsingException(
        AggregatorFactories.Builder factories = new AggregatorFactories.Builder();
                                throw new ParsingException(
        }
import java.util.Locale;
            if (factory.supportsConcurrentSegmentSearch() == false || factory.evaluateChildFactories() == false) {
                if (profilers != null) {
        }
                            resolvePipelineAggregatorOrder(
                        + token
            for (AggregationBuilder builder : aggregationBuilders) {
            if (factoryFilter.test(factories[i])) {
/*
                        return true;
        for (AggregatorFactory factory : factories) {
 * specific language governing permissions and limitations
            builder.endObject();
     * Create all aggregators so that they can be consumed with multiple
    public Aggregator[] createSubAggregators(SearchContext searchContext, Aggregator parent, CardinalityUpperBound cardinality)
            token = parser.nextToken();
            if (factory.supportsIntraSegmentSearch() == false || factory.evaluateChildFactoriesForIntraSegment() == false) {
                                        foundSubBuilder = true;
                                }
        public Collection<AggregationBuilder> getAggregatorFactories() {
        public PipelineTree buildPipelineTree() {
import org.opensearch.core.common.io.stream.StreamInput;
    }
            }
                                        break;
        ) {
                                if (!foundSubBuilder && (i == bucketsPathElements.size() - 1)) {
            if (token != XContentParser.Token.FIELD_NAME) {
            for (PipelineAggregationBuilder factory : pipelineAggregatorBuilders) {
            return true;
        throws IOException {
    public List<Aggregator> createTopLevelAggregators(SearchContext searchContext) throws IOException {
            int factoriesSize = in.readVInt();
            }
    };
                                aggBuilder = parser.namedObject(BaseAggregationBuilder.class, fieldName, aggregationName);
                        continue;
        /**
                        "Expected ["
                            + "] under ["
                            + aggregationName
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                AggregationBuilder result = Rewriteable.rewrite(builder, context);
            return Collections.unmodifiableCollection(aggregationBuilders);
            }
            BaseAggregationBuilder aggBuilder = null;
                                unmarkedBuilders,
                if (builder instanceof GlobalAggregationBuilder) {
            return orderedPipelineAggregatorrs;
        return aggregators;
        }
                PipelineAggregationBuilder result = Rewriteable.rewrite(builder, context);
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        + aggregationName
            return builder;
         */
            PipelineAggregationBuilder.ValidationContext context = PipelineAggregationBuilder.ValidationContext.forTreeRoot(
    }
 * Modifications Copyright OpenSearch Contributors. See
    public static Builder builder() {
                    pipelineAggregatorBuildersMap,
            if (aggregationBuilders.isEmpty() && pipelineAggregatorBuilders.isEmpty()) {
        XContentParser.Token token = null;
                                );
                addPipelineAggregator(in.readNamedWriteable(PipelineAggregationBuilder.class));
                for (PipelineAggregationBuilder subAgg : pipelineAggregatorBuilders) {
            }
                                        + aggBuilder.getType()
            }
import org.opensearch.search.streaming.FlushModeResolver;
                if (subFactories != null) {
    }
        public Collection<PipelineAggregationBuilder> getPipelineAggregatorFactories() {
                                    "Found two sub aggregation definitions under [" + aggregationName + "]"
 * under the License.
                                if (!foundSubBuilder) {
        @Override
                unmarkedBuilders.remove(builder);
            Profilers profilers = factory.context().getProfilers();
            Collection<AggregationBuilder> aggregationBuilders
                }
         * Read from a stream.
            AggregatorFactory[] aggFactories = new AggregatorFactory[aggregationBuilders.size()];
import java.util.function.Predicate;
        Matcher validAggMatcher = VALID_AGG_NAME.matcher("");
                    throw new ParsingException(
import java.util.Arrays;
                out.writeNamedWriteable(factory);
import static java.util.stream.Collectors.toMap;
    }
 * KIND, either express or implied.  See the License for the
        }
                        + aggregationName
                aggBuildersMap.put(aggBuilder.name, aggBuilder);
import org.opensearch.search.profile.aggregation.ProfilingAggregator;
        }
import org.opensearch.common.xcontent.SuggestingErrorOnUnknown;
                return false;
import java.util.HashMap;
import org.opensearch.search.profile.Profilers;
        /**
            return changed ? newBuilder : this;
     *                    be asked to collect.
                .collect(toList());
 */
            try {
            return e;
        }
    public boolean allFactoriesSupportConcurrentSearch() {
        public AggregatorFactories build(QueryShardContext queryShardContext, AggregatorFactory parent) throws IOException {
                                matchingBuilder
                factory = factories[i].create(searchContext, null, CardinalityUpperBound.ONE);
                            + "]",
    public int countAggregators() {
                orderedPipelineAggregators.add(builder);
        private final Collection<PipelineAggregationBuilder> pipelineAggregatorBuilders = new LinkedHashSet<>();
                    decision,
    }
                addAggregator(in.readNamedWriteable(AggregationBuilder.class));
                                    parser.getTokenLocation(),
        /**
    private AggregatorFactories(AggregatorFactory[] factories) {
            if (token != XContentParser.Token.START_OBJECT) {
                    );
                changed |= result != builder;
                            + fieldName
     * buckets.
            } else {
                        PipelineAggregationBuilder matchingBuilder = pipelineAggregatorBuildersMap.get(firstAggName);
                pipelineAggregatorBuildersMap.put(builder.getName(), builder);
        return Arrays.stream(factories).anyMatch(GLOBAL_AGGREGATOR_FACTORY_PREDICATE.negate());
            }
            for (AggregationBuilder aggBuilder : aggregationBuilders) {
         */
                            if ((i == bucketsPathElements.size() - 1) && (aggName.equalsIgnoreCase("_key") || aggName.equals("_count"))) {
            out.writeVInt(this.pipelineAggregatorBuilders.size());
            }
         * form. If the builder did not change the identity reference must be
        /**
        /**
         * Validate the root of the aggregation tree.
    }
                return PipelineTree.EMPTY;
        @Override
                } else {
                            + "], but got a ["
    private List<Aggregator> createTopLevelAggregators(SearchContext searchContext, Predicate<AggregatorFactory> factoryFilter)
                throw new TaskCancelledException("cancelled while creating aggregators");
            if (!names.add(factory.name)) {
                                // factories
 * GitHub history for details.
            }
                        for (int i = 1; i < bucketsPathElements.size(); i++) {
                                pipelineAggregatorBuildersMap,
    @PublicApi(since = "1.0.0")
            }
                        + " starts with a ["
            } else {
import org.opensearch.search.internal.SearchContext;
                factory = new ProfilingAggregator(factory, profilers.getAggregationProfiler());
                            } else {
                }
                    if (termsAggregationBuilder.minDocCount() == 0) {
                    parser.getTokenLocation(),
import org.apache.logging.log4j.LogManager;
    public boolean hasGlobalAggregator() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (getClass() != obj.getClass()) return false;
 * You may obtain a copy of the License at
                            + XContentParser.Token.START_OBJECT
            Map<String, PipelineAggregationBuilder> pipelineAggregatorBuildersMap,
        }
 * this work for additional information regarding copyright
                if (token == XContentParser.Token.START_OBJECT) {
 * An immutable collection of {@link AggregatorFactories}.
                    factories.addAggregator(aggregationBuilder);
            if (aggBuilder == null) {
                }
                    parser.getTokenLocation(),
import org.apache.logging.log4j.Logger;
                                        }
        if (searchContext.isStreamSearch() && searchContext.getFlushMode() == null) {
                                orderedPipelineAggregators,
    public static final AggregatorFactories EMPTY = new AggregatorFactories(new AggregatorFactory[0]);
    public boolean allFactoriesSupportIntraSegmentSearch() {
        for (AggregatorFactory factory : factories) {
                return false;
                aggregators.add(factory);
     * factories in turn.
    }
            return Collections.unmodifiableCollection(pipelineAggregatorBuilders);
                                        + aggregationName
    private static final Logger logger = LogManager.getLogger(AggregatorFactories.class);
            this.pipelineAggregatorBuilders.add(pipelineAggregatorFactory);
 *
            }
                                        + "]: ["
    }
            }
     * {@link PipelineAggregationBuilder}s.
        public Builder rewrite(QueryRewriteContext context) throws IOException {
        return factories.count() > 0 ? factories : null;
    }
                            + "] under a ["
 *
    }
                }
            Map<String, Object> metadata = null;
                    "Invalid aggregation name ["
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.index.query.QueryShardContext;
        Aggregator[] aggregators = new Aggregator[countAggregators()];
                }
            FlushMode decision;
        /**
 *
        for (int i = 0; i < factories.length; i++) {
        public Builder() {}
                        parser.getTokenLocation()
                throw new ParsingException(
        }
            for (PipelineAggregationBuilder builder : pipelineAggregatorBuilders) {
                    }
                changed |= result != builder;
                                    SuggestingErrorOnUnknown.suggest(fieldName, ex.getCandidates())
                );
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
         * Create an empty builder.
                    "Streaming aggregation decision: {} | streamable={}, topN={} | maxBucket={}",
        private ActionRequestValidationException validateChildren(ActionRequestValidationException e) {
                                    }
                                    "Unknown aggregation type [%s]%s",
                                    if (aggName.equals(subBuilder.name)) {
/*
                                Collection<AggregationBuilder> subBuilders = aggBuilder.factoriesBuilder.aggregationBuilders;
        return factories;
                logger.debug(
                temporarilyMarked.remove(builder);
                String[] bucketsPaths = builder.getBucketsPaths();
                            + XContentParser.Token.FIELD_NAME
import java.util.Objects;
                    List<AggregationPath.PathElement> bucketsPathElements = AggregationPath.parse(bucketsPath).getPathElements();
    }
            return aggregationBuilders.size() + pipelineAggregatorBuilders.size();
                                temporarilyMarked,
            final String aggregationName = parser.currentName();
            for (PipelineAggregationBuilder builder : pipelineAggregatorBuilders) {
            if (temporarilyMarked.contains(builder)) {
        throws IOException {
