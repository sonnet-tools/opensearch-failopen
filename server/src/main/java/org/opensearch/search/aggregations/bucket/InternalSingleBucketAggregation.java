    @Override
                if (path.size() > 1) {
            }
    }
import java.util.List;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (this == obj) return true;
    @Override
 * software distributed under the License is distributed on an
        super(name, metadata);
        return Objects.hash(super.hashCode(), docCount, aggregations);
    private InternalAggregations aggregations;
    @Override
    @Override
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import java.util.Objects;
 * compatible open source license.
     */
     *
     * before allowing sibling pipelines to materialize.
            InternalAggregation aggregation = aggregations.get(aggName);
     * this {@link Aggregation} and contains the provided sub-aggregations.
        this.aggregations = aggregations;
    }
            if (aggregation == null) {
    }
    }
    }
                }
            }
            assert aggregation.getName().equals(getName());
 */
    }
    public final double sortValue(String key) {
    }
     *            the buckets to use in the new {@link Aggregation}
     * Amulti-bucket agg needs to first reduce the buckets and *their* pipelines
 * GitHub history for details.
        ReduceContext reduceContext,
import org.opensearch.search.aggregations.InternalAggregations;
        }
            for (Aggregation agg : getAggregations().asList()) {
    public final InternalAggregation reducePipelines(
        if (super.equals(obj) == false) return false;
import java.util.function.Consumer;
    }
            docCount += ((InternalSingleBucketAggregation) aggregation).docCount;
            );
 * Licensed to Elasticsearch under one or more contributor
        if (rewritten == null) {
        if (pipelineTree.hasSubTrees()) {
        InternalAggregation reducedAggs,
 * not use this file except in compliance with the License.
    public InternalSingleBucketAggregation create(InternalAggregations subAggregations) {
            reduced = create(reducedSubAggs);
     * Create a new copy of this {@link Aggregation} with the same settings as
            throw new IllegalArgumentException(
/*
 *
    /**
        aggregations.toXContentInternal(builder, params);
 */
                    + getName()
        assert reduceContext.isFinalReduce();
import org.opensearch.core.common.io.stream.StreamInput;
     *
import java.util.function.Function;
        super(in);
            return this;
        return aggregations;
    }
            InternalAggregations reducedSubAggs = InternalAggregations.from(aggs);
    }
    @Override
    }
            String aggName = path.get(0);
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
/*
            if (aggName.equals("_count")) {
    }
 * Unless required by applicable law or agreed to in writing,
 *
        aggregations = InternalAggregations.readFrom(in);
 * You may obtain a copy of the License at
    public InternalAggregations getAggregations() {
        PipelineTree pipelineTree
        List<InternalAggregations> subAggregationsList = new ArrayList<>(aggregations.size());
import java.io.IOException;
    @Override
    public int hashCode() {
     */
     * Creates a single bucket aggregation.
    protected abstract InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations);
        this.docCount = docCount;
import org.opensearch.core.xcontent.XContentBuilder;
    ) {
                return getDocCount();
    @Override
import java.util.Iterator;
    protected InternalSingleBucketAggregation(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {
 * KIND, either express or implied.  See the License for the
        }
package org.opensearch.search.aggregations.bucket;
        return builder;
                aggs.add(((InternalAggregation) agg).reducePipelines((InternalAggregation) agg, reduceContext, subTree));
 * A base class for all the single bucket aggregations.
import org.opensearch.search.aggregations.Aggregation;
        consumer.accept(aggregations);
    @Override
     * Read from a stream.
    }
    public long getDocCount() {
            List<InternalAggregation> aggs = new ArrayList<>();
    @Override
    /**
        out.writeVLong(docCount);
        return newAggregation(getName(), getDocCount(), subAggregations);
    @Override
    @Override
                    throw new IllegalArgumentException("_count must be the last element in the path");
    public void forEachBucket(Consumer<InternalAggregations> consumer) {
        return create(rewritten);
        }
        InternalAggregations rewritten = rewriter.apply(aggregations);
    }
                PipelineTree subTree = pipelineTree.subTree(agg.getName());
 * Modifications Copyright OpenSearch Contributors. See
            }
/*
    @Override
     * @param subAggregations
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
        }
        return Objects.equals(docCount, other.docCount) && Objects.equals(aggregations, other.aggregations);
    public final double sortValue(AggregationPath.PathElement head, Iterator<AggregationPath.PathElement> tail) {
import java.util.ArrayList;
     * @param aggregations  The already built sub-aggregations that are associated with the bucket.
public abstract class InternalSingleBucketAggregation extends InternalAggregation implements SingleBucketAggregation {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
                    + key
 * license agreements. See the NOTICE file distributed with
    @Override
    /**
    private long docCount;
        if (key != null && false == key.equals("doc_count")) {
                    + "]. Either use [doc_count] as key or drop the key all together."
 */
/**
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
        return docCount;
        if (path.isEmpty()) {
     */
import java.util.Map;
        docCount = in.readVLong();
 */
import org.opensearch.core.common.io.stream.StreamOutput;
        final InternalAggregations aggs = InternalAggregations.reduce(subAggregationsList, reduceContext);
    protected boolean mustReduceOnSingleInternalAgg() {
import org.opensearch.search.aggregations.InternalAggregation;
 * the Apache License, Version 2.0 (the "License"); you may
            return aggregation.getProperty(path.subList(1, path.size()));
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
 * SPDX-License-Identifier: Apache-2.0
        long docCount = 0L;
    }
     */
            return this;
        return aggregations.sortValue(head, tail);
        return newAggregation(getName(), docCount, aggs);
 * this file be licensed under the Apache-2.0 license or a
        InternalAggregation reduced = this;
    public Object getProperty(List<String> path) {
    public boolean equals(Object obj) {
     * @return the new {@link Aggregation}
                throw new IllegalArgumentException("Cannot find an aggregation named [" + aggName + "] in [" + getName() + "]");
    protected InternalSingleBucketAggregation(StreamInput in) throws IOException {
                "Unknown value key ["
        for (InternalAggregation aggregation : aggregations) {
        return super.reducePipelines(reduced, reduceContext, pipelineTree);
 *
        return true;
     * @param docCount      The document count in the single bucket.
    }
    }
}
        } else {
 * The OpenSearch Contributors require contributions made to
        aggregations.writeTo(out);
                    + "] for single-bucket aggregation ["
        return docCount;
        InternalSingleBucketAggregation other = (InternalSingleBucketAggregation) obj;
            subAggregationsList.add(((InternalSingleBucketAggregation) aggregation).aggregations);
 * @opensearch.internal
    /**
import org.opensearch.search.aggregations.support.AggregationPath;
    /**
    @Override
     * Create a <b>new</b> empty sub aggregation. This must be a new instance on each call.
     */
    public InternalAggregation copyWithRewritenBuckets(Function<InternalAggregations, InternalAggregations> rewriter) {
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
     * @param name          The aggregation name.
 * under the License.
