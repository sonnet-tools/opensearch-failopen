        }
                    aggBuildersMap,
import java.util.List;
            return e;  
                changed |= result != builder;
 * GitHub history for details.
                    "Missing definition for aggregation [" + aggregationName + "]",
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamInput;
            if (!Objects.equals(pipelineAggregatorBuilders, other.pipelineAggregatorBuilders)) return false;
            if (aggBuilder == null) {
        ) {
            if (factories.length == 0) {
                                    SuggestingErrorOnUnknown.suggest(fieldName, ex.getCandidates())
                );
    }
                                temporarilyMarked,
            } catch (IllegalArgumentException iae) {  
                            + fieldName  
                            + "]",  
            for (AggregationBuilder builder : aggregationBuilders) {
                        case "meta":  
            }  
    public static Builder builder() {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }  
                        }  
         * Validate the root of the aggregation tree.
            }
 */
    /**
                    orderedPipelineAggregatorrs,  
            List<PipelineAggregationBuilder> orderedPipelineAggregatorrs = new LinkedList<>();
        for (int i = 0; i < factories.length; ++i) {
                                );
                                for (AggregationBuilder subBuilder : subBuilders) {  
                    }
            Map<String, PipelineAggregationBuilder> pipelineAggregatorBuildersMap = new HashMap<>();
                        for (int i = 1; i < bucketsPathElements.size(); i++) {
            return Objects.hash(aggregationBuilders, pipelineAggregatorBuilders);  
}  
import org.opensearch.core.common.io.stream.StreamOutput;
 * software distributed under the License is distributed on an
                addPipelineAggregator(in.readNamedWriteable(PipelineAggregationBuilder.class));  
                }  
                                        + aggBuilder.getType()
                            + "], but got a ["
import org.opensearch.search.aggregations.support.AggregationPath.PathElement;
            return orderedPipelineAggregatorrs;  
        }
import org.opensearch.search.profile.Profilers;
                PipelineAggregationBuilder builder = unmarkedBuilders.get(0);
            List<PipelineAggregator> aggregators = resolvePipelineAggregatorOrder(pipelineAggregatorBuilders, aggregationBuilders).stream()
            if (temporarilyMarked.contains(builder)) {
 * this file be licensed under the Apache-2.0 license or a
        // Using LinkedHashSets to preserve the order of insertion, that makes the results
 * Unless required by applicable law or agreed to in writing,
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        public boolean mustVisitAllDocs() {
 * specific language governing permissions and limitations
            int factoriesSize = in.readVInt();  
import java.util.LinkedHashSet;
                    parser.getTokenLocation(),  
    public boolean allFactoriesSupportConcurrentSearch() {
    public AggregatorFactory[] getFactories() {  
                } else {  
                throw new IllegalArgumentException("Cyclical dependency found with pipeline aggregator [" + builder.getName() + "]");  
                                    "Unknown aggregation type [%s]%s",
                    if (termsAggregationBuilder.minDocCount() == 0) {  
                            PathElement pathElement = bucketsPathElements.get(i);  
        return true;
        for (AggregatorFactory factory : factories) {
        private void resolvePipelineAggregatorOrder(  
                            + XContentParser.Token.START_OBJECT
                        case "aggs":
                        PipelineAggregationBuilder matchingBuilder = pipelineAggregatorBuildersMap.get(firstAggName);  
                    temporarilyMarked,
            for (PipelineAggregationBuilder builder : pipelineAggregatorBuilders) {
                                        "No aggregation [" + aggName + "] found for path [" + bucketsPath + "]"
import org.opensearch.core.common.Strings;  
    public boolean allFactoriesSupportIntraSegmentSearch() {
import org.opensearch.common.xcontent.SuggestingErrorOnUnknown;
import org.opensearch.search.aggregations.support.AggregationPath;
                        parser.getTokenLocation(),
                );
                    subAgg.toXContent(builder, params);
            return changed ? newBuilder : this;
                pipelineAggregatorBuilders,
                builder.validate(context);
        private void validatePipelines(PipelineAggregationBuilder.ValidationContext context) {
             */
                                        }  
        /**  
            }
                throw new ParsingException(
                );
            Aggregator factory;
                for (String bucketsPath : bucketsPaths) {
                context.addValidationError(iae.getMessage());
        }  
            return this;
                aggregationBuilders,  
        AggregatorFactories.Builder factories = new AggregatorFactories.Builder();  
import org.opensearch.core.common.ParsingException;
     * @param cardinality Upper bound of the number of {@code owningBucketOrd}s
/*  
            if (aggregationBuilders.isEmpty() && pipelineAggregatorBuilders.isEmpty()) {
        }
                                boolean foundSubBuilder = false;
                                throw new ParsingException(  
         */  
                        + XContentParser.Token.START_OBJECT
import java.util.LinkedList;  
    private static AggregatorFactories.Builder parseAggregators(XContentParser parser, int level) throws IOException {
         */
            }
                token = parser.nextToken();  
 * license agreements. See the NOTICE file distributed with
            if (token != XContentParser.Token.FIELD_NAME) {
import org.opensearch.index.query.QueryRewriteContext;
import java.util.Locale;
import java.util.regex.Pattern;
                                        if (aggName.equals(subFactory.getName())) {  
 */
         * Create an empty builder.
            Collection<PipelineAggregationBuilder> temporarilyMarked = new HashSet<>();  
                    }
                        } else {
 * Modifications Copyright OpenSearch Contributors. See  
        @Override  
                                if (!foundSubBuilder) {  
            List<PipelineAggregationBuilder> unmarkedBuilders = new ArrayList<>(pipelineAggregatorBuilders);
            if (searchContext.isCancelled()) {
        for (AggregatorFactory factory : factories) {
                    "Invalid aggregation name ["
                                throw new ParsingException(new XContentLocation(ex.getLineNumber(), ex.getColumnNumber()), message, ex);  
        if (searchContext.isStreamSearch() && searchContext.getFlushMode() == null) {  
 */  
                                    }
                    metrics.streamable(),
                            + "] in ["  
                if (token == XContentParser.Token.START_OBJECT) {
    private AggregatorFactories(AggregatorFactory[] factories) {  
                                unmarkedBuilders,  
                                String message = String.format(  
         * Rewrites the underlying aggregation builders into their primitive  
                }
                if (profilers != null) {  
                Profilers profilers = factory.context().getProfilers();
         */
import org.opensearch.search.streaming.FlushMode;  
            int i = 0;
                            try {  
import org.opensearch.search.internal.SearchContext;  
            return Collections.unmodifiableCollection(aggregationBuilders);
                            + aggregationName
            while (!unmarkedBuilders.isEmpty()) {
                long maxBucket = searchContext.getStreamingMaxEstimatedBucketCount();  
                newBuilder.addAggregator(result);
            }  
    private static final Predicate<AggregatorFactory> GLOBAL_AGGREGATOR_FACTORY_PREDICATE = new Predicate<>() {
            out.writeVInt(this.aggregationBuilders.size());  
            validatePipelines(context);
import org.opensearch.core.xcontent.XContentParser;
        public PipelineTree buildPipelineTree() {
                            }
            return o instanceof GlobalAggregatorFactory;
                            + XContentParser.Token.FIELD_NAME
import org.opensearch.index.query.QueryShardContext;  
                            } else {
        private final Collection<AggregationBuilder> aggregationBuilders = new LinkedHashSet<>();  
        }  
    /**  
                                    }
                            resolvePipelineAggregatorOrder(
    public List<Aggregator> createTopLevelNonGlobalAggregators(SearchContext searchContext) throws IOException {  
public class AggregatorFactories {
                                }
            }
            }  
            builder.endObject();
    };
    public static final AggregatorFactories EMPTY = new AggregatorFactories(new AggregatorFactory[0]);  
            Map<String, AggregationBuilder> aggBuildersMap,
import org.opensearch.core.xcontent.NamedObjectNotFoundException;  
                            throw new IllegalArgumentException("No aggregation found for path [" + bucketsPath + "]");
    public static class Builder implements Writeable, ToXContentObject {
            }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            aggregators[i] = factory;
                PipelineAggregationBuilder.ValidationContext context = PipelineAggregationBuilder.ValidationContext.forInsideTree(agg, e);
            AggregatorFactory[] aggFactories = new AggregatorFactory[aggregationBuilders.size()];
        @Override  
            int pipelineFactoriesSize = in.readVInt();
                                throw new ParsingException(  
                return EMPTY;
                    parser.getTokenLocation()
                        parser.getTokenLocation()
            token = parser.nextToken();
            if (token != XContentParser.Token.START_OBJECT) {  
                                        break;
            try {
            return new PipelineTree(subTrees, aggregators);
                                );  
            Map<String, AggregationBuilder> aggBuildersMap = new HashMap<>();  
            List<PipelineAggregationBuilder> orderedPipelineAggregators,  
            }  
            }  
            Builder other = (Builder) obj;
/*
import org.opensearch.core.tasks.TaskCancelledException;
        XContentParser.Token token = null;
    }
import org.opensearch.common.annotation.PublicApi;  
            for (PipelineAggregationBuilder builder : orderedPipelineAggregators) {
        return createTopLevelAggregators(searchContext, (aggregatorFactory) -> true);
     * {@link PipelineAggregationBuilder}s.
     */
                                break;  
        return parseAggregators(parser, 0);
                    parser.getTokenLocation(),
                for (PipelineAggregationBuilder subAgg : pipelineAggregatorBuilders) {  
     *  
                            }
        @Override  
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
import java.util.Map;  
import org.opensearch.core.xcontent.XContentBuilder;
            Collection<AggregationBuilder> aggregationBuilders  
     *                    that {@link Aggregator}s created by this method will
            }  
import static java.util.stream.Collectors.toList;
            return aggregationBuilders.size() + pipelineAggregatorBuilders.size();  
    }
                    );  
            Map<String, Object> metadata = null;
        }
        private final Collection<PipelineAggregationBuilder> pipelineAggregatorBuilders = new LinkedHashSet<>();
                return;
                resolvePipelineAggregatorOrder(  
    }
                        default:
 *
import static java.util.stream.Collectors.toMap;
 * ownership. Elasticsearch licenses this file to you under  
    }  
                addAggregator(in.readNamedWriteable(AggregationBuilder.class));
 *  
        throws IOException {
            if (!Objects.equals(aggregationBuilders, other.aggregationBuilders)) return false;  
                                    throw new IllegalArgumentException(
            return this;
                                    );  
import java.util.Collection;
            return false;  
            if (aggregationBuilders != null) {  
            return validateChildren(context.getValidationException());
        }
                            break;
    public boolean hasNonGlobalAggregator() {  
                throw new IllegalArgumentException("Two sibling aggregations cannot have the same name: [" + factory.name + "]");
        }  
 *
import org.opensearch.search.profile.aggregation.ProfilingAggregator;
            }
            if (!names.add(factory.name)) {
         * returned otherwise the builder will be rewritten infinitely.
                            + "] under a ["  
    public List<Aggregator> createTopLevelGlobalAggregators(SearchContext searchContext) throws IOException {
 * under the License.  
                            subFactories = parseAggregators(parser, level + 1);
import org.apache.logging.log4j.Logger;
                    if (bucketsPath.equals("_count") || bucketsPath.equals("_key")) {
                            }
                        if (matchingBuilder != null) {
                                        aggBuilder = subBuilder;
     * Parses the aggregation request recursively generating aggregator  
            for (AggregationBuilder aggBuilder : aggregationBuilders) {
                            + "], but got a ["
            }
        }
 * KIND, either express or implied.  See the License for the
                                    fieldName,  
    public Aggregator[] createSubAggregators(SearchContext searchContext, Aggregator parent, CardinalityUpperBound cardinality)
            }  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;  
                                        + "] and ["  
                        "Expected ["  
     *                    be asked to collect.  
                throw new ParsingException(
            }
                );
        public int count() {
                                    for (PipelineAggregationBuilder subFactory : subPipelineBuilders) {
                            + "]"
         */  
                } else {  
    }
import org.opensearch.core.xcontent.ToXContentObject;
        }
            Collection<PipelineAggregationBuilder> temporarilyMarked,
        }  
            Builder newBuilder = new Builder();  
                for (AggregationBuilder subAgg : aggregationBuilders) {
                                Collection<AggregationBuilder> subBuilders = aggBuilder.factoriesBuilder.aggregationBuilders;
                                    parser.getTokenLocation(),
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
                out.writeNamedWriteable(factory);
                                        + fieldName
                    String firstAggName = bucketsPathElements.get(0).name;  
                            + XContentParser.Token.START_OBJECT
        }  
 */
                decision = FlushModeResolver.decideFlushMode(metrics, FlushMode.PER_SHARD, maxBucket);
                newBuilder.addPipelineAggregator(result);  
import java.util.Collections;
import java.util.function.Predicate;  
                                    "Found two sub aggregation definitions under [" + aggregationName + "]"
            searchContext.setFlushModeIfAbsent(decision);
            Aggregator factory = factories[i].create(searchContext, parent, cardinality);  
        }  
    }
     */
                aggregators.add(factory);  
                    );
                if (metadata != null) {
        /**  
        public AggregatorFactories build(QueryShardContext queryShardContext, AggregatorFactory parent) throws IOException {  
     * factories in turn.
     */
                        case "aggregations":  
             * Top level aggs only collect from owningBucketOrd 0 which is
                            + token
            for (AggregationBuilder agg : aggregationBuilders) {
                unmarkedBuilders.remove(builder);  
                throw new ParsingException(  
                    parser.getTokenLocation(),
            if (factory.supportsConcurrentSegmentSearch() == false || factory.evaluateChildFactories() == false) {  
@PublicApi(since = "1.0.0")  
        }
 * You may obtain a copy of the License at  
    private static final Logger logger = LogManager.getLogger(AggregatorFactories.class);
        }  
            final String aggregationName = parser.currentName();
                    maxBucket
    }
                );  
                                    "Found two aggregation type definitions in ["
        return Arrays.stream(factories).anyMatch(GLOBAL_AGGREGATOR_FACTORY_PREDICATE);
                                        foundSubBuilder = true;  
     * A mutable collection of {@link AggregationBuilder}s and
        /**
                }
    }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                                        + aggregationName  
                                // Check the pipeline sub-aggregator factories
        public boolean equals(Object obj) {
        // ordered nicely, although technically order does not matter
                    throw new ParsingException(
                    metrics.topNSize(),  
        public int hashCode() {
            List<PipelineAggregationBuilder> unmarkedBuilders,
            }  
                temporarilyMarked.add(builder);
                ++i;
import java.io.IOException;
 * An immutable collection of {@link AggregatorFactories}.
                orderedPipelineAggregators.add(builder);
    private final AggregatorFactory[] factories;  
            return new AggregatorFactories(aggFactories);
                logger.debug(
                        continue;
            for (PipelineAggregationBuilder builder : pipelineAggregatorBuilders) {  
        for (int i = 0; i < factories.length; i++) {  
                out.writeNamedWriteable(factory);  
            for (AggregationBuilder factory : aggregationBuilders) {
        ) {
         * form. If the builder did not change the identity reference must be
            out.writeVInt(this.pipelineAggregatorBuilders.size());
            }  
         * Validate a the pipeline aggregations in this factory.  
                e = agg.factoriesBuilder.validateChildren(context.getValidationException());
        return Arrays.stream(factories).anyMatch(GLOBAL_AGGREGATOR_FACTORY_PREDICATE.negate());
        /**
            aggregationBuilders.add(factory);
import org.opensearch.index.query.Rewriteable;
            Map<String, PipelineAggregationBuilder> pipelineAggregatorBuildersMap,
import java.util.HashSet;
                aggBuildersMap.put(aggBuilder.name, aggBuilder);
    }  
                return false;
import org.opensearch.core.common.io.stream.Writeable;  
                        + aggregationName  
                }
                }
     * @opensearch.api
        /**
import java.util.HashMap;  
        public ActionRequestValidationException validate(ActionRequestValidationException e) {
                AggregationBuilder result = Rewriteable.rewrite(builder, context);  
            return true;
                        + token  
                if (aggBuilder instanceof AggregationBuilder aggregationBuilder) {
     */
                    builder  
                                pipelineAggregatorBuildersMap,
import java.util.Arrays;  
                    factories.addAggregator(aggregationBuilder);
        /**
                            + token  
    public static final Pattern VALID_AGG_NAME = Pattern.compile("[^\\[\\]>]+");  
        private ActionRequestValidationException validateChildren(ActionRequestValidationException e) {  
            }
        return aggregators;
            }  
     * @return the number of sub-aggregator factories  
        public Builder addAggregator(AggregationBuilder factory) {  
        Aggregator[] aggregators = new Aggregator[countAggregators()];
            }
            }
            for (AggregationBuilder builder : aggregationBuilders) {
            }  
            this.pipelineAggregatorBuilders.add(pipelineAggregatorFactory);  
            } else if (unmarkedBuilders.contains(builder)) {
                }
                        AggregationBuilder aggBuilder = aggBuildersMap.get(firstAggName);
                        return true;
            builder.startObject();
                            break;  
         */
            }
            }
                                    if (aggName.equals(subBuilder.name)) {
        @Override
        public String toString() {  
            }
            PipelineAggregationBuilder.ValidationContext context = PipelineAggregationBuilder.ValidationContext.forTreeRoot(
                throw new TaskCancelledException("cancelled while creating aggregators");
            }  
                .collect(toMap(AggregationBuilder::getName, AggregationBuilder::buildPipelineTree));
         */
package org.opensearch.search.aggregations;
                    List<AggregationPath.PathElement> bucketsPathElements = AggregationPath.parse(bucketsPath).getPathElements();
                    } else {
                decision = FlushMode.PER_SHARD;  
        public Builder addPipelineAggregator(PipelineAggregationBuilder pipelineAggregatorFactory) {
                        + aggregationName
                if (token != XContentParser.Token.FIELD_NAME) {
            List<PipelineAggregationBuilder> orderedPipelineAggregators;  
        public Builder rewrite(QueryRewriteContext context) throws IOException {
            }  
        private final Set<String> names = new HashSet<>();
import java.util.Objects;
                        continue;
            AggregatorFactories.Builder subFactories = null;
        }
            }  
                            if (subFactories != null) {
            return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        return true;
                    aggBuilder.subAggregations(subFactories);
        return createTopLevelAggregators(searchContext, GLOBAL_AGGREGATOR_FACTORY_PREDICATE.negate());
            /*
        public Collection<AggregationBuilder> getAggregatorFactories() {  
                        + "], expected a ["
    /**
                    "Aggregation definition for ["  
                            if ((i == bucketsPathElements.size() - 1) && (aggName.equalsIgnoreCase("_key") || aggName.equals("_count"))) {
            if (!validAggMatcher.reset(aggregationName).matches()) {
                }
                pipelineAggregatorBuildersMap.put(builder.getName(), builder);
            if (profilers != null) {
                            String aggName = pathElement.name;
                        "Expected ["
            boolean changed = false;
            return Collections.unmodifiableCollection(pipelineAggregatorBuilders);
        return factories;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
                                    parser.getTokenLocation(),
                if (builder instanceof GlobalAggregationBuilder) {  
        }
 * this work for additional information regarding copyright
            return builder;
                    "Unexpected token " + token + " in [aggs]: aggregations definitions must start with the name of the aggregation."
                );
        }
    public boolean hasGlobalAggregator() {
    }
                }
         * Validate a the children of this factory.
        public void writeTo(StreamOutput out) throws IOException {
            if (factoryFilter.test(factories[i])) {  
        }
                                    Collection<PipelineAggregationBuilder> subPipelineBuilders =  
                return PipelineTree.EMPTY;
            BaseAggregationBuilder aggBuilder = null;
import org.opensearch.search.streaming.StreamingCostMetrics;
                throw new ParsingException(
 * The OpenSearch Contributors require contributions made to  
                e
                } else if (builder instanceof TermsAggregationBuilder termsAggregationBuilder) {
                    "Streaming aggregation decision: {} | streamable={}, topN={} | maxBucket={}",  
                                matchingBuilder
            Profilers profilers = factory.context().getProfilers();
     * Create all aggregators so that they can be consumed with multiple
                orderedPipelineAggregators = resolvePipelineAggregatorOrder(pipelineAggregatorBuilders, aggregationBuilders);
                    parser.getTokenLocation(),  
    }
                    }
                                    Locale.ROOT,
            Map<String, PipelineTree> subTrees = aggregationBuilders.stream()  
        return aggregators;  
import org.opensearch.search.aggregations.bucket.global.GlobalAggregatorFactory;  
        @Override
                if (subFactories != null) {  
            if (factory.supportsIntraSegmentSearch() == false || factory.evaluateChildFactoriesForIntraSegment() == false) {  
        public Builder() {}  
 * not use this file except in compliance with the License.
                return false;
        List<Aggregator> aggregators = new ArrayList<>();
                        + " starts with a ["
                                // factories  
            for (PipelineAggregationBuilder factory : pipelineAggregatorBuilders) {
                .map(PipelineAggregationBuilder::create)  
                                }
        }  
    @PublicApi(since = "1.0.0")  
        public boolean test(AggregatorFactory o) {
        }
import java.util.regex.Matcher;
                    factories.addPipelineAggregator((PipelineAggregationBuilder) aggBuilder);
    public static AggregatorFactories.Builder parseAggregators(XContentParser parser) throws IOException {  
 *  
/*
        /**
            } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
                            metadata = parser.map();
                String[] bucketsPaths = builder.getBucketsPaths();  
                    switch (fieldName) {
            if (pipelineAggregatorBuilders != null) {
            );  
                                        + "]: ["
import org.opensearch.action.ActionRequestValidationException;
                .collect(toList());
                                aggBuildersMap,  
                                        aggBuilder.factoriesBuilder.pipelineAggregatorBuilders;
import org.apache.logging.log4j.LogManager;  
                            );  
    }
         * Read from a stream.  
                StreamingCostMetrics metrics = StreamingCostMetrics.estimateFromFactories(factories, searchContext);
import org.opensearch.core.xcontent.XContentLocation;  
     * buckets.  
                final String fieldName = parser.currentName();
        }
            if (aggregationBuilders.isEmpty() && pipelineAggregatorBuilders.isEmpty()) {  
                        + "]. Aggregation names can contain any character except '[', ']', and '>'"
                            + "] in ["
                            }
                    return true;
                                orderedPipelineAggregators,
                                aggBuilder = parser.namedObject(BaseAggregationBuilder.class, fieldName, aggregationName);
                                            foundSubBuilder = true;
            }
        return new Builder();  
    private List<Aggregator> createTopLevelAggregators(SearchContext searchContext, Predicate<AggregatorFactory> factoryFilter)
 * Licensed to Elasticsearch under one or more contributor  
                    decision,
 * SPDX-License-Identifier: Apache-2.0
            } else {
                agg.factoriesBuilder.validatePipelines(context);  
                    } else if (aggBuildersMap.containsKey(firstAggName)) {  
                            + aggregationName
                                if (!foundSubBuilder && (i == bucketsPathElements.size() - 1)) {
import java.util.Set;
                    pipelineAggregatorBuildersMap,
                                        + "]"
         * aggregation results after the final reduction.  
            Collection<PipelineAggregationBuilder> pipelineAggregatorBuilders,
        return createTopLevelAggregators(searchContext, GLOBAL_AGGREGATOR_FACTORY_PREDICATE);  
                                );  
        Matcher validAggMatcher = VALID_AGG_NAME.matcher("");
         */
        }
                            if (aggBuilder != null) {
                factory = new ProfilingAggregator(factory, profilers.getAggregationProfiler());  
                    subAgg.toXContent(builder, params);
                aggFactories[i] = agg.build(queryShardContext, parent);
    }
        public Collection<PipelineAggregationBuilder> getPipelineAggregatorFactories() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                                }  
    public int countAggregators() {
                            } catch (NamedObjectNotFoundException ex) {
                                // Check the non-pipeline sub-aggregator
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
        private List<PipelineAggregationBuilder> resolvePipelineAggregatorOrder(
                factory = factories[i].create(searchContext, null, CardinalityUpperBound.ONE);
    /**
import org.opensearch.search.streaming.FlushModeResolver;
                    unmarkedBuilders,
            for (AggregationBuilder agg : aggregationBuilders) {  
import java.util.ArrayList;
        }  
/**
                    factory = new ProfilingAggregator(factory, profilers.getAggregationProfiler());
            for (int i = 0; i < pipelineFactoriesSize; i++) {
                temporarilyMarked.remove(builder);
        this.factories = factories;
            }  
        return factories.count() > 0 ? factories : null;  
                        }  
        throws IOException {  
                changed |= result != builder;
            PipelineAggregationBuilder builder  
        return factories.length;  
            for (int i = 0; i < factoriesSize; i++) {
            if (obj == null) return false;
                }  
                }  
             * *exactly* what CardinalityUpperBound.ONE *means*.  
                    throw new ParsingException(
                    aggBuilder.setMetadata(metadata);  
                            + "] under ["
         * Build a tree of {@link PipelineAggregator}s to modify the tree of
            FlushMode decision;
    public List<Aggregator> createTopLevelAggregators(SearchContext searchContext) throws IOException {
        }
                PipelineAggregationBuilder result = Rewriteable.rewrite(builder, context);
        // These aggregators are going to be used with a single bucket ordinal, no need to wrap the PER_BUCKET ones
                        + "]."  
            if (getClass() != obj.getClass()) return false;  
                        parser.getTokenLocation(),  
        public Builder(StreamInput in) throws IOException {
                                            break;
 * compatible open source license.
    }
