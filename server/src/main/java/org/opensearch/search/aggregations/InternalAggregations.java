    public static InternalAggregations topLevelReduce(List<InternalAggregations> aggregationsList, ReduceContext context) {
        }
            aggregations.sort(INTERNAL_AGG_COMPARATOR);
 */
    @SuppressWarnings("unchecked")
     */
/*
            InternalAggregation first = aggregations.get(0); // the list can't be empty as it's created on demand
            } else {
        return (List<InternalAggregation>) aggregations;
        mergedAggregation.addAll(fromSecond);
            throw new RuntimeException(exc);
import org.opensearch.Version;
    }
     * Make a mutable copy of the aggregation results.
            List<InternalAggregation> reducedInternalAggs = reduced.getInternalAggregations();
import java.util.Iterator;
/*
    }
        @Override
        public void reset() throws IOException {
    }
        }
@PublicApi(since = "1.0.0")
            // should never happen
    }
                .map(agg -> agg.reducePipelines(agg, context, context.pipelineTreeRoot().subTree(agg.getName())))
        long size = 0;
        }
            return null;
            ++size;
        return reduced;
    /**
    public static InternalAggregations merge(InternalAggregations first, InternalAggregations second) {
            return EMPTY;
        if (aggregationsList.isEmpty()) {
    public static InternalAggregations readFrom(StreamInput in) throws IOException {
 * GitHub history for details.
 * this work for additional information regarding copyright
            return null;
                );
     * This method first reduces the aggregations, and if it is the final reduce, then reduce the pipeline
                reducedAggregations.add(first);
        final List<InternalAggregation> mergedAggregation = new ArrayList<>(fromFirst.size() + fromSecond.size());
                SiblingPipelineAggregator sib = (SiblingPipelineAggregator) pipelineAggregator;
     *
     */
import org.opensearch.core.common.io.stream.StreamInput;
     * <p>
    }
import org.opensearch.core.common.io.stream.Writeable;
}
     */
 *
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
        // now we can use the first aggregation of each list to handle the reduce of its list
     * SearchPhaseController or anywhere else that wants to initiate a reduction.  It _should not_ be called
            reducedInternalAggs = reducedInternalAggs.stream()
        mergedAggregation.addAll(fromFirst);
/**
    /**
        }
        if (tail.hasNext()) {
            }
     * A counting stream output
    }
 * ownership. Elasticsearch licenses this file to you under
        if (reduced == null) {
            }
        @Override
                    aggregation.getName(),
import java.util.Comparator;
        @Override
            List<InternalAggregation> aggregations = entry.getValue();
        return res;
                aggs.add((InternalAggregation) aggregation);
                InternalAggregation newAgg = sib.doReduce(from(reducedInternalAggs), context);
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
            return size;
 * You may obtain a copy of the License at
    private static class CountingStreamOutput extends StreamOutput {
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                // no need for reduce phase
    public double sortValue(AggregationPath.PathElement head, Iterator<AggregationPath.PathElement> tail) {
    @Override
 * under the License.
            return 1;
                List<InternalAggregation> aggs = aggByName.computeIfAbsent(
        if (agg1.isMapped() == agg2.isMapped()) {
 * The OpenSearch Contributors require contributions made to
        for (Map.Entry<String, List<InternalAggregation>> entry : aggByName.entrySet()) {
        for (InternalAggregations aggregations : aggregationsList) {
        // first we collect all aggregations of the same type and list them together
        Map<String, List<InternalAggregation>> aggByName = new HashMap<>();
    public InternalAggregations(List<InternalAggregation> aggregations) {
    /**
            throw new IllegalArgumentException("Cannot find aggregation named [" + head.name + "]");
        try (CountingStreamOutput out = new CountingStreamOutput()) {
    };
/*
    }
        return new InternalAggregations(reducedAggregations);
            size += length;
public final class InternalAggregations extends Aggregations implements Writeable {
 * KIND, either express or implied.  See the License for the
            return -1;
 * Unless required by applicable law or agreed to in writing,
 */
            writeTo(out);
        public void writeByte(byte b) throws IOException {
        InternalAggregation aggregation = get(head.name);
            for (PipelineAggregator pipelineAggregator : context.pipelineTreeRoot().aggregators()) {
     * @opensearch.internal
        if (context.isFinalReduce()) {
 */
    }
                reducedInternalAggs.add(newAgg);
    private List<InternalAggregation> getInternalAggregations() {
import org.opensearch.search.aggregations.pipeline.SiblingPipelineAggregator;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public long length() {
            size = 0;
            for (Aggregation aggregation : aggregations.aggregations) {
     */
 */
    /**
        out.writeNamedWriteableList(getInternalAggregations());
        }
    /**
        public void writeBytes(byte[] b, int offset, int length) throws IOException {
                .collect(Collectors.toList());
        }
        }
     */
 * Modifications Copyright OpenSearch Contributors. See
                    k -> new ArrayList<>(aggregationsList.size())
        return new InternalAggregations(mergedAggregation);
    /**
     * Note that pipeline aggregations _are not_ reduced by this method.  Pipelines are handled
     * aggregations (both embedded parent/sibling as well as top-level sibling pipelines)
        return aggregation.sortValue(head.key);
            }
     * Returns the number of bytes required to serialize these aggregations in binary form.
            return aggregation.sortValue(tail.next(), tail);
 *
        }
        }
 * not use this file except in compliance with the License.
        final List<InternalAggregation> fromSecond = second.getInternalAggregations();
        InternalAggregations reduced = reduce(aggregationsList, context);
        }
    public static final InternalAggregations EMPTY = new InternalAggregations(Collections.emptyList());
import java.util.HashMap;
 * An internal implementation of {@link Aggregations}.
        public void close() throws IOException {}
     * Reduces the given list of aggregations as well as the top-level pipeline aggregators extracted from the first
 * specific language governing permissions and limitations
        @Override
package org.opensearch.search.aggregations;
            return out.size;
        } else if (agg1.isMapped() && agg2.isMapped() == false) {
     * separately by {@link InternalAggregations#topLevelReduce(List, ReduceContext)}
    private static final Comparator<InternalAggregation> INTERNAL_AGG_COMPARATOR = (agg1, agg2) -> {
        @Override
                reducedAggregations.add(first.reduce(aggregations, context));
import java.io.IOException;
import java.util.Map;
        return new InternalAggregations(aggregations);
     * IMPORTANT: The copy doesn't include any pipeline aggregations, if there are any.
import org.opensearch.search.aggregations.support.AggregationPath;
     * as an intermediate reduction step (e.g. in the middle of an aggregation tree).
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static InternalAggregations from(List<InternalAggregation> aggregations) {
        }
            // Sort aggregations so that unmapped aggs come last in the list
import java.util.stream.Collectors;
        List<InternalAggregation> reducedAggregations = new ArrayList<>();
 * software distributed under the License is distributed on an
     */
        if (aggregations.isEmpty()) {
            return 0;
        }
    public List<InternalAggregation> copyResults() {
        public void flush() throws IOException {}
    public void writeTo(StreamOutput out) throws IOException {
     * <p>
 * SPDX-License-Identifier: Apache-2.0
     * Get value to use when sorting by a descendant of the aggregation containing this.
            if (first.mustReduceOnSingleInternalAgg() || aggregations.size() > 1) {
        if (aggregation == null) {
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.List;
     * Constructs a new aggregation.
import java.util.ArrayList;
     */
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
        return new ArrayList<>(getInternalAggregations());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
    }
 * @opensearch.api
    /**
     * {@link InternalAggregations} object found in the list.
            return from(reducedInternalAggs);
        }
        final InternalAggregations res = from(in.readList(stream -> in.readNamedWriteable(InternalAggregation.class)));
     * Begin the reduction process.  This should be the entry point for the "first" reduction, e.g. called by
 * compatible open source license.
        }
 *
            // If all aggs are unmapped, the agg that leads the reduction will just return itself
    public static InternalAggregations reduce(List<InternalAggregations> aggregationsList, ReduceContext context) {
        final List<InternalAggregation> fromFirst = first.getInternalAggregations();
    public long getSerializedSize() {
    }
        super(aggregations);
            out.setVersion(Version.CURRENT);
        } catch (IOException exc) {
 *
 * Licensed to Elasticsearch under one or more contributor
