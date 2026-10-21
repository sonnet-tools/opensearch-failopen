         * and none were added.
                return parent.getPipelineAggregations();
                        type + " aggregation [" + name + "] must have a histogram, date_histogram or auto_date_histogram as parent"
 */
     */
                );
            @Override
     */
            @Override
            @Override
    /**
    /**
import org.opensearch.core.common.io.stream.NamedWriteable;
    }
            ForInsideTree(AggregationBuilder parent, ActionRequestValidationException validationFailuresSoFar) {
        public ActionRequestValidationException getValidationException() {
                // There is a parent inside the tree.
    public String getName() {
            }
    public String toString() {
        return bucketsPaths;
        /**
     * @param name
 * this work for additional information regarding copyright
/*
         * response.
 *
                } else if (parent instanceof AutoDateHistogramAggregationBuilder) {
                    if (histogramAggregationBuilder.minDocCount() != 0) {
    }
        /**
         */
         * The root of the tree
 * A factory that knows how to create an {@link PipelineAggregator} of a
         */
        /**
         * The internal tree node
 * not use this file except in compliance with the License.
 * GitHub history for details.
                }
/*
         * Build the context for a node inside the aggregation tree.
import org.opensearch.action.ValidateActions;
            public void validateParentAggSequentiallyOrdered(String type, String name) {
        NamedWriteable,
        throw new IllegalArgumentException("Aggregation [" + name + "] cannot define sub-aggregations");
            e = ValidateActions.addValidationError(error, e);
                super(validationFailuresSoFar);
 *
 */
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
 * this file be licensed under the Apache-2.0 license or a
                        + "] must have a histogram, date_histogram or auto_date_histogram as parent but doesn't have a parent"
                    }
                    type
                this.siblingAggregations = Objects.requireNonNull(siblingAggregations);
    }
                this.parent = Objects.requireNonNull(parent);
    /**
 * the Apache License, Version 2.0 (the "License"); you may
         * Add a validation error about the {@code buckets_path}.
        this.name = name;
    public final String[] getBucketsPaths() {
         * Add a validation error to this context. All validation errors
                    // Nothing to check
        }
        /**
         */
     */
        private static class ForInsideTree extends ValidationContext {
        /**
        /**
    protected PipelineAggregationBuilder(String name, String[] bucketsPaths) {
            public Collection<PipelineAggregationBuilder> getSiblingPipelineAggregations() {
    implements
                } else if (parent instanceof DateHistogramAggregationBuilder dateHistogramAggregationBuilder) {
import java.io.IOException;
         * Pipeline aggregations that are siblings to the aggregation being validated.
        public abstract void validateParentAggSequentiallyOrdered(String type, String name);
            ActionRequestValidationException validationFailuresSoFar
                        addValidationError("parent histogram of " + type + " aggregation [" + name + "] must have min_doc_count of 0");
         * is not executed and the entire list is returned as the error
        public abstract Collection<AggregationBuilder> getSiblingAggregations();
}
            @Override
@PublicApi(since = "1.0.0")
        /**
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
 *
                        addValidationError("parent histogram of " + type + " aggregation [" + name + "] must have min_doc_count of 0");
            public void validateParentAggSequentiallyOrdered(String type, String name) {
        }
     * Creates the pipeline aggregator
            this.e = validationFailuresSoFar;
    public abstract PipelineAggregationBuilder setMetadata(Map<String, Object> metadata);
                    }
     * <p>
        }
            Collection<AggregationBuilder> siblingAggregations,
    /** Return the consumed buckets paths. */
            }
                    if (dateHistogramAggregationBuilder.minDocCount() != 0) {
     * The context used for validation
         */
 */
 * KIND, either express or implied.  See the License for the
        Rewriteable<PipelineAggregationBuilder> {
    }
                        + name
         */
    }
     * @return The created aggregator
            @Override
     * Makes sure this builder is properly configured.
         * Aggregations that are siblings to the aggregation being validated.
         * Validates that there <strong>is</strong> a parent aggregation.
         */
        }
     * particularly if that load must by asynchronous.
         * are accumulated in a list and, if there are any, the request
                } else {
     */
 */
 * under the License.
        public static ValidationContext forTreeRoot(
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
         */
         * The validation exception, if there is one. It'll be {@code null}
     * The default implementation return the same instance. It should be
            Collection<PipelineAggregationBuilder> siblingPipelineAggregations,
 * specific type.
        /**
            private final AggregationBuilder parent;
         *
     *
                return parent.getSubAggregations();
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
            addValidationError(PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName() + ' ' + error);
 * @opensearch.api
         */
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.annotation.PublicApi;
        public void addValidationError(String error) {
            }
        public static ValidationContext forInsideTree(AggregationBuilder parent, ActionRequestValidationException validationFailuresSoFar) {
            return new ForTreeRoot(siblingAggregations, siblingPipelineAggregations, validationFailuresSoFar);
                    );
         */
import org.opensearch.index.query.Rewriteable;
         * Build the context for the root of the aggregation tree.
        }
    public abstract static class ValidationContext {
 * SPDX-License-Identifier: Apache-2.0
            @Override
            public void validateHasParent(String type, String name) {
 * You may obtain a copy of the License at
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
 *
                if (parent instanceof HistogramAggregationBuilder histogramAggregationBuilder) {
    public PipelineAggregationBuilder subAggregations(Builder subFactories) {
import org.opensearch.core.common.Strings;
/*
            }
import org.opensearch.core.xcontent.ToXContentFragment;
    public PipelineAggregationBuilder rewrite(QueryRewriteContext context) throws IOException {
    @Override
         *
    /**
        private ValidationContext(ActionRequestValidationException validationFailuresSoFar) {
    /** Return this aggregation's name. */
     */
                super(validationFailuresSoFar);
         * if the context wasn't provided with any exception on creation
import java.util.Collection;
                        + " aggregation ["
     * overridden by aggregations that must load data before they can be run,
            private final Collection<AggregationBuilder> siblingAggregations;
            throw new IllegalArgumentException("[bucketsPaths] must not be null: [" + name + "]");
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
 * specific language governing permissions and limitations
package org.opensearch.search.aggregations;
 * Unless required by applicable law or agreed to in writing,
            ForTreeRoot(
    protected final String name;
        if (bucketsPaths == null) {
    @Override
            @Override
            return new ForInsideTree(parent, validationFailuresSoFar);
     * @opensearch.internal
            public Collection<AggregationBuilder> getSiblingAggregations() {
        BaseAggregationBuilder,
        }
                return siblingAggregations;
        ToXContentFragment,
    @Override
        /**
                    addValidationError(
public abstract class PipelineAggregationBuilder
            return e;
         */
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (name == null) {
     * {@inheritDoc}
     *
 * software distributed under the License is distributed on an
        public abstract Collection<PipelineAggregationBuilder> getSiblingPipelineAggregations();
    }
        private static class ForTreeRoot extends ValidationContext {
            }
 * Modifications Copyright OpenSearch Contributors. See
                this.siblingPipelineAggregations = Objects.requireNonNull(siblingPipelineAggregations);
            }
     *            The aggregation name
     * Constructs a new pipeline aggregator factory.
            @Override
        }
         */
            }
        ) {
                Collection<AggregationBuilder> siblingAggregations,
        private ActionRequestValidationException e;
        public void addBucketPathValidationError(String error) {
    protected abstract void validate(ValidationContext context);
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public void validateHasParent(String type, String name) {
         * @opensearch.internal
            public Collection<AggregationBuilder> getSiblingAggregations() {
        this.bucketsPaths = bucketsPaths;
    protected final String[] bucketsPaths;
            }
    protected abstract PipelineAggregator create();
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.index.query.QueryRewriteContext;
 * Licensed to Elasticsearch under one or more contributor
            throw new IllegalArgumentException("[name] must not be null: [" + name + "]");
    /** Associate metadata with this {@link PipelineAggregationBuilder}. */
import org.opensearch.core.xcontent.MediaTypeRegistry;
        /**
        return this;
    @Override
                ActionRequestValidationException validationFailuresSoFar
    }
        }
 * license agreements. See the NOTICE file distributed with
/**
            public Collection<PipelineAggregationBuilder> getSiblingPipelineAggregations() {
            }
                Collection<PipelineAggregationBuilder> siblingPipelineAggregations,
            ) {
            private final Collection<PipelineAggregationBuilder> siblingPipelineAggregations;
        /**
     *
        public abstract void validateHasParent(String type, String name);
                addValidationError(
         * Validates that the parent is sequentially ordered.
        return name;
            }
         * @opensearch.internal
import java.util.Map;
                return siblingPipelineAggregations;
        }
import java.util.Objects;
                addValidationError(type + " aggregation [" + name + "] must be declared inside of another aggregation");
        }
