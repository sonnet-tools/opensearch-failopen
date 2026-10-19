            private final AggregationBuilder parent;  
     */
package org.opensearch.search.aggregations;
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
     */
        this.bucketsPaths = bucketsPaths;  
 *
    /** Associate metadata with this {@link PipelineAggregationBuilder}. */  
         * Build the context for the root of the aggregation tree.
        }
         * is not executed and the entire list is returned as the error
            }  
         */
            }
 * A factory that knows how to create an {@link PipelineAggregator} of a  
                        + " aggregation ["
import java.util.Map;
                super(validationFailuresSoFar);
         * Add a validation error to this context. All validation errors
        public static ValidationContext forTreeRoot(  
         * are accumulated in a list and, if there are any, the request  
import org.opensearch.action.ValidateActions;
                this.siblingAggregations = Objects.requireNonNull(siblingAggregations);  
/*
 * The OpenSearch Contributors require contributions made to  
    @Override
         */
        public void addBucketPathValidationError(String error) {
     *
         * Build the context for a node inside the aggregation tree.  
            @Override  
        /**
    public String getName() {
            throw new IllegalArgumentException("[name] must not be null: [" + name + "]");  
/**
                addValidationError(type + " aggregation [" + name + "] must be declared inside of another aggregation");
 *  
     * Makes sure this builder is properly configured.
            public Collection<AggregationBuilder> getSiblingAggregations() {
         * and none were added.
        if (bucketsPaths == null) {
        public void addValidationError(String error) {
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
                Collection<PipelineAggregationBuilder> siblingPipelineAggregations,
                        + "] must have a histogram, date_histogram or auto_date_histogram as parent but doesn't have a parent"
            }
    }  
        /**
                        addValidationError("parent histogram of " + type + " aggregation [" + name + "] must have min_doc_count of 0");  
import java.util.Objects;  
import org.opensearch.core.common.io.stream.NamedWriteable;
         * @opensearch.internal  
                    // Nothing to check  
            ForTreeRoot(  
                );
    public PipelineAggregationBuilder rewrite(QueryRewriteContext context) throws IOException {
         * The internal tree node
            @Override  
         */
                    type
    @Override  
                    addValidationError(
    /**
        }  
     * @param name
            @Override
        Rewriteable<PipelineAggregationBuilder> {
     * @return The created aggregator
                super(validationFailuresSoFar);  
    /** Return this aggregation's name. */  
}
                this.parent = Objects.requireNonNull(parent);
    protected final String[] bucketsPaths;
            private final Collection<AggregationBuilder> siblingAggregations;  
        private ActionRequestValidationException e;  
            public Collection<PipelineAggregationBuilder> getSiblingPipelineAggregations() {
 *
    protected abstract PipelineAggregator create();
        public ActionRequestValidationException getValidationException() {  
        private ValidationContext(ActionRequestValidationException validationFailuresSoFar) {
                return siblingAggregations;  
         */
 * license agreements. See the NOTICE file distributed with
        NamedWriteable,
 */
                // There is a parent inside the tree.
                return siblingPipelineAggregations;
         * The validation exception, if there is one. It'll be {@code null}
                ActionRequestValidationException validationFailuresSoFar  
     * overridden by aggregations that must load data before they can be run,  
                        + name  
/*
            throw new IllegalArgumentException("[bucketsPaths] must not be null: [" + name + "]");  
                        addValidationError("parent histogram of " + type + " aggregation [" + name + "] must have min_doc_count of 0");
 *    http://www.apache.org/licenses/LICENSE-2.0
                return parent.getSubAggregations();  
    public abstract PipelineAggregationBuilder setMetadata(Map<String, Object> metadata);
                addValidationError(  
        /**
         * Validates that there <strong>is</strong> a parent aggregation.
import org.opensearch.common.annotation.PublicApi;
    /**
    /** Return the consumed buckets paths. */
            @Override
            ) {
        return this;
    }
    public String toString() {
            @Override
         */  
            }
        }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
            }
        }
        throw new IllegalArgumentException("Aggregation [" + name + "] cannot define sub-aggregations");  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
        /**  
         */
            this.e = validationFailuresSoFar;  
        }
                    if (histogramAggregationBuilder.minDocCount() != 0) {
     * particularly if that load must by asynchronous.
        /**  
        public abstract Collection<AggregationBuilder> getSiblingAggregations();  
            e = ValidateActions.addValidationError(error, e);
            }  
    }  
     */  
                } else {
        public abstract void validateParentAggSequentiallyOrdered(String type, String name);
     * <p>
                Collection<AggregationBuilder> siblingAggregations,
         * @opensearch.internal  
 * GitHub history for details.
                this.siblingPipelineAggregations = Objects.requireNonNull(siblingPipelineAggregations);
                    }  
            public void validateHasParent(String type, String name) {  
        /**
         * if the context wasn't provided with any exception on creation  
         */
    }
         * The root of the tree
import org.opensearch.index.query.Rewriteable;
            public void validateHasParent(String type, String name) {  
            public void validateParentAggSequentiallyOrdered(String type, String name) {
                        type + " aggregation [" + name + "] must have a histogram, date_histogram or auto_date_histogram as parent"  
 * this file be licensed under the Apache-2.0 license or a
     * The context used for validation
 *
 */  
     * @opensearch.internal  
        }
     * Constructs a new pipeline aggregator factory.
 * specific type.
     *            The aggregation name
    /**
    implements
 * under the License.  
            ActionRequestValidationException validationFailuresSoFar  
            addValidationError(PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName() + ' ' + error);  
     *
         */
         * Aggregations that are siblings to the aggregation being validated.
import org.opensearch.action.ActionRequestValidationException;  
        }
        /**
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
            public Collection<AggregationBuilder> getSiblingAggregations() {
     */  
    @Override  
                if (parent instanceof HistogramAggregationBuilder histogramAggregationBuilder) {  
     * The default implementation return the same instance. It should be
 * SPDX-License-Identifier: Apache-2.0
     */  
            }
        public static ValidationContext forInsideTree(AggregationBuilder parent, ActionRequestValidationException validationFailuresSoFar) {
                    }
            return new ForTreeRoot(siblingAggregations, siblingPipelineAggregations, validationFailuresSoFar);
 * You may obtain a copy of the License at  
 */
                    if (dateHistogramAggregationBuilder.minDocCount() != 0) {
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * software distributed under the License is distributed on an
        }
    public final String[] getBucketsPaths() {  
         * Add a validation error about the {@code buckets_path}.  
 */
 * KIND, either express or implied.  See the License for the
    @Override
         *
     *  
            Collection<AggregationBuilder> siblingAggregations,
            }  
import org.opensearch.index.query.QueryRewriteContext;
@PublicApi(since = "1.0.0")
import org.opensearch.core.xcontent.MediaTypeRegistry;
         */
        /**  
        if (name == null) {
                } else if (parent instanceof AutoDateHistogramAggregationBuilder) {
 * Unless required by applicable law or agreed to in writing,
        /**  
 * compatible open source license.
    public abstract static class ValidationContext {
            private final Collection<PipelineAggregationBuilder> siblingPipelineAggregations;
            Collection<PipelineAggregationBuilder> siblingPipelineAggregations,
            return e;
        return bucketsPaths;
    public PipelineAggregationBuilder subAggregations(Builder subFactories) {
    protected PipelineAggregationBuilder(String name, String[] bucketsPaths) {
         */
 * this work for additional information regarding copyright
            public void validateParentAggSequentiallyOrdered(String type, String name) {
            return new ForInsideTree(parent, validationFailuresSoFar);  
        private static class ForTreeRoot extends ValidationContext {
        ) {
            @Override
        }
    }
 * @opensearch.api  
         * Pipeline aggregations that are siblings to the aggregation being validated.  
                }
            }  
         * response.
        this.name = name;
        ToXContentFragment,
            public Collection<PipelineAggregationBuilder> getSiblingPipelineAggregations() {
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;  
            @Override
         *
    protected abstract void validate(ValidationContext context);
    }  
import java.util.Collection;
                } else if (parent instanceof DateHistogramAggregationBuilder dateHistogramAggregationBuilder) {
        public abstract void validateHasParent(String type, String name);  
         * Validates that the parent is sequentially ordered.  
     * {@inheritDoc}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final String name;
    /**
     * Creates the pipeline aggregator  
        private static class ForInsideTree extends ValidationContext {
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
        /**
import org.opensearch.core.xcontent.ToXContentFragment;  
 * ownership. Elasticsearch licenses this file to you under  
        /**  
import java.io.IOException;  
    }  
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
            @Override
        public abstract Collection<PipelineAggregationBuilder> getSiblingPipelineAggregations();
         */
        }  
public abstract class PipelineAggregationBuilder  
                return parent.getPipelineAggregations();
                    );
            ForInsideTree(AggregationBuilder parent, ActionRequestValidationException validationFailuresSoFar) {
            }
import org.opensearch.core.common.Strings;  
        BaseAggregationBuilder,  
        return name;
 * Modifications Copyright OpenSearch Contributors. See  
