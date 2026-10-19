        for (InternalAggregation aggregation : aggregations) {  
                    + "] for single-bucket aggregation ["  
    public InternalAggregations getAggregations() {
    }
        List<InternalAggregations> subAggregationsList = new ArrayList<>(aggregations.size());
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    /**  
    }  
            String aggName = path.get(0);
 * SPDX-License-Identifier: Apache-2.0
/*  
     * Amulti-bucket agg needs to first reduce the buckets and *their* pipelines
 * software distributed under the License is distributed on an
            }
        this.docCount = docCount;
 * Unless required by applicable law or agreed to in writing,
    /**
    protected void doWriteTo(StreamOutput out) throws IOException {  
            assert aggregation.getName().equals(getName());
        return builder;  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
                }  
import java.util.Map;
            return aggregation.getProperty(path.subList(1, path.size()));
    }  
    @Override  
        if (obj == null || getClass() != obj.getClass()) return false;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;  
 * You may obtain a copy of the License at  
    public InternalAggregation copyWithRewritenBuckets(Function<InternalAggregations, InternalAggregations> rewriter) {
     */
            for (Aggregation agg : getAggregations().asList()) {
import java.util.ArrayList;
                aggs.add(((InternalAggregation) agg).reducePipelines((InternalAggregation) agg, reduceContext, subTree));
    public final double sortValue(AggregationPath.PathElement head, Iterator<AggregationPath.PathElement> tail) {  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
            }  
     * @param aggregations  The already built sub-aggregations that are associated with the bucket.  
     */
        assert reduceContext.isFinalReduce();
        out.writeVLong(docCount);
    protected InternalSingleBucketAggregation(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {
    protected abstract InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations);  
            subAggregationsList.add(((InternalSingleBucketAggregation) aggregation).aggregations);  
        return newAggregation(getName(), docCount, aggs);  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
import org.opensearch.search.aggregations.Aggregation;  
    public final InternalAggregation reducePipelines(
        return aggregations.sortValue(head, tail);
                throw new IllegalArgumentException("Cannot find an aggregation named [" + aggName + "] in [" + getName() + "]");
     * @param name          The aggregation name.
    @Override
import org.opensearch.search.aggregations.InternalAggregations;
    protected boolean mustReduceOnSingleInternalAgg() {
    }
/**  
    protected InternalSingleBucketAggregation(StreamInput in) throws IOException {
    @Override  
import java.util.function.Consumer;  
 * this work for additional information regarding copyright
    }
        if (rewritten == null) {  
 *
                if (path.size() > 1) {
            throw new IllegalArgumentException(  
            return this;  
import org.opensearch.core.xcontent.XContentBuilder;
    public boolean equals(Object obj) {  
    }  
        }
    @Override
                return getDocCount();
    @Override
 */
            if (aggName.equals("_count")) {  
     *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
     * Read from a stream.  
        }
    }
     */  
        return Objects.equals(docCount, other.docCount) && Objects.equals(aggregations, other.aggregations);  
 * @opensearch.internal  
            return this;
     * before allowing sibling pipelines to materialize.
import java.util.function.Function;
                    + "]. Either use [doc_count] as key or drop the key all together."
        return create(rewritten);  
    public InternalSingleBucketAggregation create(InternalAggregations subAggregations) {
        if (key != null && false == key.equals("doc_count")) {
        InternalAggregation reducedAggs,  
    }  
        this.aggregations = aggregations;
    /**
 * A base class for all the single bucket aggregations.
 * Licensed to Elasticsearch under one or more contributor  
        PipelineTree pipelineTree
import java.util.Objects;
        if (super.equals(obj) == false) return false;  
    public Object getProperty(List<String> path) {
import org.opensearch.search.aggregations.InternalAggregation;
    ) {  
        return Objects.hash(super.hashCode(), docCount, aggregations);
import java.io.IOException;  
 * not use this file except in compliance with the License.
                "Unknown value key ["
import org.opensearch.core.common.io.stream.StreamInput;  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *  
        aggregations.writeTo(out);
    private long docCount;
/*
     * Creates a single bucket aggregation.
        return true;  
    private InternalAggregations aggregations;
 * this file be licensed under the Apache-2.0 license or a
        aggregations.toXContentInternal(builder, params);
    }
    @Override
    }
            List<InternalAggregation> aggs = new ArrayList<>();
    @Override
        final InternalAggregations aggs = InternalAggregations.reduce(subAggregationsList, reduceContext);
    }  
        }
        return newAggregation(getName(), getDocCount(), subAggregations);  
 */  
        if (path.isEmpty()) {
    }
     * this {@link Aggregation} and contains the provided sub-aggregations.
        super(name, metadata);  
    @Override  
 */
        } else {
     * Create a new copy of this {@link Aggregation} with the same settings as
 * Modifications Copyright OpenSearch Contributors. See  
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
package org.opensearch.search.aggregations.bucket;
    }
    @Override
public abstract class InternalSingleBucketAggregation extends InternalAggregation implements SingleBucketAggregation {
                    throw new IllegalArgumentException("_count must be the last element in the path");
        ReduceContext reduceContext,
    @Override  
    }  
        if (pipelineTree.hasSubTrees()) {  
        return docCount;
        consumer.accept(aggregations);
        InternalSingleBucketAggregation other = (InternalSingleBucketAggregation) obj;
        return aggregations;  
     *            the buckets to use in the new {@link Aggregation}
            if (aggregation == null) {
            );  
 * KIND, either express or implied.  See the License for the
 * under the License.  
     */
    }
     * @return the new {@link Aggregation}  
}
import java.util.Iterator;
     * @param subAggregations
    /**  
        }
        super(in);  
    @Override  
    }  
        }
            InternalAggregations reducedSubAggs = InternalAggregations.from(aggs);  
import org.opensearch.core.common.io.stream.StreamOutput;
            }
     */
 *
        if (this == obj) return true;
 *  
                    + key
 */
            reduced = create(reducedSubAggs);
    /**  
    @Override
        InternalAggregations rewritten = rewriter.apply(aggregations);
            docCount += ((InternalSingleBucketAggregation) aggregation).docCount;
/*
    }
    public final double sortValue(String key) {
        docCount = in.readVLong();
import java.util.List;  
     * Create a <b>new</b> empty sub aggregation. This must be a new instance on each call.
import org.opensearch.search.aggregations.support.AggregationPath;
                    + getName()
 * ownership. Elasticsearch licenses this file to you under  
        aggregations = InternalAggregations.readFrom(in);
    @Override
        return docCount;
 *
        long docCount = 0L;
 * specific language governing permissions and limitations
    public long getDocCount() {  
                PipelineTree subTree = pipelineTree.subTree(agg.getName());  
        InternalAggregation reduced = this;
            InternalAggregation aggregation = aggregations.get(aggName);  
        return super.reducePipelines(reduced, reduceContext, pipelineTree);  
    public void forEachBucket(Consumer<InternalAggregations> consumer) {
    public int hashCode() {
     * @param docCount      The document count in the single bucket.
