                if (reduced == null) {  
        if (reduced == null) { // all empty
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
     */
import java.util.Objects;
 * GitHub history for details.
            }
        }  
 * license agreements. See the NOTICE file distributed with
        } else {  
 * Licensed to Elasticsearch under one or more contributor  
        } else {
        for (InternalAggregation aggregation : aggregations) {  
        return counts == null ? 0 : counts.cardinality(0);
        builder.field(CommonFields.VALUE.getPreferredName(), cardinality);
 * @opensearch.internal
        return builder;  
    }  
            if (cardinality.counts != null) {
        } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * SPDX-License-Identifier: Apache-2.0
    }
        super(name, metadata);
import org.opensearch.core.common.io.stream.StreamOutput;  
        super(in);  
import org.opensearch.common.util.BigArrays;
        out.writeNamedWriteable(format);
        if (in.readBoolean()) {
 * this work for additional information regarding copyright
 */
        return getValue();  
                reduced.merge(0, cardinality.counts, 0);  
    @Override  
        if (super.equals(obj) == false) return false;  
 *
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
        return counts.equals(0, other.counts, 0);  
    @Override
            counts = null;
        format = in.readNamedWriteable(DocValueFormat.class);
    public long getValue() {
import java.util.Map;
            return aggregations.get(0);
 * software distributed under the License is distributed on an
    AbstractHyperLogLogPlusPlus getState() {  
import java.util.List;  
                    reduced = new HyperLogLogPlusPlus(cardinality.counts.precision(), BigArrays.NON_RECYCLING_INSTANCE, 1);
import org.opensearch.search.DocValueFormat;
    }
    }
    @Override
    /**
        return counts;  
        return CardinalityAggregationBuilder.NAME;
        HyperLogLogPlusPlus reduced = null;
    InternalCardinality(String name, AbstractHyperLogLogPlusPlus counts, Map<String, Object> metadata) {  
 * Implementation of cardinality agg
    private final AbstractHyperLogLogPlusPlus counts;
            counts = AbstractHyperLogLogPlusPlus.readFrom(in, BigArrays.NON_RECYCLING_INSTANCE);  
        if (this == obj) return true;
            counts.writeTo(0, out);
/*  
        final long cardinality = getValue();
 *
 * KIND, either express or implied.  See the License for the
            out.writeBoolean(false);
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean equals(Object obj) {  
        return Objects.hash(super.hashCode(), counts.hashCode(0));
    public String getWriteableName() {  
        this.counts = counts;
    @Override  
}  
    }
 * compatible open source license.
    }  
import org.opensearch.search.aggregations.InternalAggregation;  
    }
    @Override  
    }  
 * not use this file except in compliance with the License.
    public double value() {
            return new InternalCardinality(name, reduced, getMetadata());
/**
    public AbstractHyperLogLogPlusPlus getCounts() {
        return counts;
    @Override  
                }
/*  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
     * Read from a stream.  
            final InternalCardinality cardinality = (InternalCardinality) aggregation;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
public final class InternalCardinality extends InternalNumericMetricsAggregation.SingleValue implements Cardinality {  
        InternalCardinality other = (InternalCardinality) obj;
import java.io.IOException;
 *  
 */
        }
import org.opensearch.core.xcontent.XContentBuilder;
 * specific language governing permissions and limitations
    protected void doWriteTo(StreamOutput out) throws IOException {
 */  
        if (obj == null || getClass() != obj.getClass()) return false;
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
    }
            out.writeBoolean(true);
        if (counts != null) {  
    public InternalCardinality(StreamInput in) throws IOException {
/*
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    }  
package org.opensearch.search.aggregations.metrics;
    }  
    public int hashCode() {
 *  
