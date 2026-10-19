            List<InternalAggregation> aggregations = entry.getValue();
 * Unless required by applicable law or agreed to in writing,
        @Override
        }
     * Reduces the given list of aggregations as well as the top-level pipeline aggregators extracted from the first  
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.pipeline.SiblingPipelineAggregator;
                reducedInternalAggs.add(newAgg);
    public long getSerializedSize() {
import java.util.HashMap;
            List<InternalAggregation> reducedInternalAggs = reduced.getInternalAggregations();
/*  
     * A counting stream output
        return aggregation.sortValue(head.key);
    /**
 * The OpenSearch Contributors require contributions made to  
            for (PipelineAggregator pipelineAggregator : context.pipelineTreeRoot().aggregators()) {
        return reduced;
        List<InternalAggregation> reducedAggregations = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See  
    /**
        if (aggregationsList.isEmpty()) {  
     * Begin the reduction process.  This should be the entry point for the "first" reduction, e.g. called by  
        return (List<InternalAggregation>) aggregations;  
        if (aggregation == null) {
        for (Map.Entry<String, List<InternalAggregation>> entry : aggByName.entrySet()) {  
     *  
        public void reset() throws IOException {
        }
 * compatible open source license.
 *
 */  
 *
        mergedAggregation.addAll(fromSecond);  
            throw new RuntimeException(exc);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
            return 1;  
    public static InternalAggregations readFrom(StreamInput in) throws IOException {  
     * @opensearch.internal
            return EMPTY;
        return new ArrayList<>(getInternalAggregations());
                    k -> new ArrayList<>(aggregationsList.size())
    }
        }
    }  
import java.util.ArrayList;
 * SPDX-License-Identifier: Apache-2.0
        long size = 0;
/*
        final List<InternalAggregation> fromFirst = first.getInternalAggregations();
public final class InternalAggregations extends Aggregations implements Writeable {
        }
import org.opensearch.search.aggregations.support.AggregationPath;
            return -1;
            return from(reducedInternalAggs);  
            aggregations.sort(INTERNAL_AGG_COMPARATOR);
        }
     * SearchPhaseController or anywhere else that wants to initiate a reduction.  It _should not_ be called
        return new InternalAggregations(reducedAggregations);
     * aggregations (both embedded parent/sibling as well as top-level sibling pipelines)
    public static InternalAggregations merge(InternalAggregations first, InternalAggregations second) {
    /**
    public InternalAggregations(List<InternalAggregation> aggregations) {
                );
    public List<InternalAggregation> copyResults() {  
import java.util.List;
                InternalAggregation newAgg = sib.doReduce(from(reducedInternalAggs), context);  
        public void close() throws IOException {}
    public static InternalAggregations topLevelReduce(List<InternalAggregations> aggregationsList, ReduceContext context) {
}
        }
import java.io.IOException;
            // If all aggs are unmapped, the agg that leads the reduction will just return itself  
    }
    }  
        } else if (agg1.isMapped() && agg2.isMapped() == false) {  
        if (aggregations.isEmpty()) {  
     * as an intermediate reduction step (e.g. in the middle of an aggregation tree).
        // first we collect all aggregations of the same type and list them together
        // now we can use the first aggregation of each list to handle the reduce of its list
 */
        return new InternalAggregations(mergedAggregation);
    }  
            writeTo(out);
import org.opensearch.common.annotation.PublicApi;
        for (InternalAggregations aggregations : aggregationsList) {  
     */  
    public static InternalAggregations reduce(List<InternalAggregations> aggregationsList, ReduceContext context) {
        public void writeByte(byte b) throws IOException {
        if (tail.hasNext()) {
        final List<InternalAggregation> mergedAggregation = new ArrayList<>(fromFirst.size() + fromSecond.size());
            if (first.mustReduceOnSingleInternalAgg() || aggregations.size() > 1) {  
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
                List<InternalAggregation> aggs = aggByName.computeIfAbsent(
        @Override  
            ++size;
    public double sortValue(AggregationPath.PathElement head, Iterator<AggregationPath.PathElement> tail) {  
@PublicApi(since = "1.0.0")
 * the Apache License, Version 2.0 (the "License"); you may
 * An internal implementation of {@link Aggregations}.  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
    public void writeTo(StreamOutput out) throws IOException {  
     * separately by {@link InternalAggregations#topLevelReduce(List, ReduceContext)}  
                    aggregation.getName(),  
        }
        }
 * GitHub history for details.
     * Make a mutable copy of the aggregation results.
    /**
    @Override
            return 0;
    }
        return res;
    public static InternalAggregations from(List<InternalAggregation> aggregations) {
    /**
    }  
 * under the License.  
                SiblingPipelineAggregator sib = (SiblingPipelineAggregator) pipelineAggregator;
 */  
            // Sort aggregations so that unmapped aggs come last in the list
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        return new InternalAggregations(aggregations);  
        super(aggregations);
        }  
 * this file be licensed under the Apache-2.0 license or a
        public long length() {  
            reducedInternalAggs = reducedInternalAggs.stream()  
    }
            // should never happen
     * {@link InternalAggregations} object found in the list.
                aggs.add((InternalAggregation) aggregation);  
            size = 0;  
     * <p>  
        if (context.isFinalReduce()) {
     * Returns the number of bytes required to serialize these aggregations in binary form.  
        final InternalAggregations res = from(in.readList(stream -> in.readNamedWriteable(InternalAggregation.class)));
                reducedAggregations.add(first.reduce(aggregations, context));
import org.opensearch.Version;  
     */
     * This method first reduces the aggregations, and if it is the final reduce, then reduce the pipeline
            for (Aggregation aggregation : aggregations.aggregations) {
                .collect(Collectors.toList());
        }
    public static final InternalAggregations EMPTY = new InternalAggregations(Collections.emptyList());
                .map(agg -> agg.reducePipelines(agg, context, context.pipelineTreeRoot().subTree(agg.getName())))
            size += length;
     * Note that pipeline aggregations _are not_ reduced by this method.  Pipelines are handled
    /**  
    private List<InternalAggregation> getInternalAggregations() {
 * specific language governing permissions and limitations
import java.util.Comparator;
     * <p>  
        InternalAggregation aggregation = get(head.name);
 * KIND, either express or implied.  See the License for the
            }
        try (CountingStreamOutput out = new CountingStreamOutput()) {  
        InternalAggregations reduced = reduce(aggregationsList, context);
import java.util.Collections;  
package org.opensearch.search.aggregations;
 * software distributed under the License is distributed on an
                reducedAggregations.add(first);
        } catch (IOException exc) {
    /**
 * license agreements. See the NOTICE file distributed with
            } else {
     * Get value to use when sorting by a descendant of the aggregation containing this.
        }
        }  
     * Constructs a new aggregation.
     */
        out.writeNamedWriteableList(getInternalAggregations());
    }
        public void flush() throws IOException {}
        }
    private static class CountingStreamOutput extends StreamOutput {  
    }  
    }  
 * @opensearch.api
/*
        @Override
 *
import java.util.stream.Collectors;  
/**
        } else {
 * Licensed to Elasticsearch under one or more contributor  
        }
            }
import java.util.Map;
            }
 */
import org.opensearch.core.common.io.stream.StreamInput;
        if (agg1.isMapped() == agg2.isMapped()) {
            return out.size;  
 *  
            out.setVersion(Version.CURRENT);
     */
            return null;
            return size;
        final List<InternalAggregation> fromSecond = second.getInternalAggregations();  
        @Override
import org.opensearch.core.common.io.stream.Writeable;
    private static final Comparator<InternalAggregation> INTERNAL_AGG_COMPARATOR = (agg1, agg2) -> {  
     */
            throw new IllegalArgumentException("Cannot find aggregation named [" + head.name + "]");  
import java.util.Iterator;  
     */
     * IMPORTANT: The copy doesn't include any pipeline aggregations, if there are any.
    @SuppressWarnings("unchecked")
    };
        mergedAggregation.addAll(fromFirst);
            InternalAggregation first = aggregations.get(0); // the list can't be empty as it's created on demand
                // no need for reduce phase  
            return aggregation.sortValue(tail.next(), tail);  
        if (reduced == null) {  
    }
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamOutput;  
            return null;
        public void writeBytes(byte[] b, int offset, int length) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, List<InternalAggregation>> aggByName = new HashMap<>();
