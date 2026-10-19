                int cmp = Double.compare(ranges[i].from, ranges[j].from);
 */  
        return ranges;
    }
            protected void swap(int i, int j) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    protected ValuesSourceType defaultValueSourceType() {
    @Override
 */
        this.keyed = keyed;
    AB> {  
        throws IOException {
    /**  
        AbstractRangeBuilder<AB, R> clone,  
        for (int i = 0; i < ranges.length; i++) {  
        super(clone, factoriesBuilder, metadata);
 * not use this file except in compliance with the License.
        return keyed;
        return (AB) this;  
    protected void innerWriteTo(StreamOutput out) throws IOException {
    protected AbstractRangeBuilder(String name, InternalRange.Factory<?, ?> rangeFactory) {  
    protected final InternalRange.Factory<?, ?> rangeFactory;
import java.io.IOException;
    }
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeBoolean(keyed);
 * Base Aggregation Builder for range aggs
 *
        super(in);  
    public AB keyed(boolean keyed) {
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.support.ValuesSourceType;  
/*  
    }
 * specific language governing permissions and limitations
import org.apache.lucene.util.InPlaceMergeSorter;
        }  
    }
 *
    public List<R> ranges() {  
        return (AB) this;  
        super(name);
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        out.writeVInt(ranges.size());  
        builder.field(RangeAggregator.RANGES_FIELD.getPreferredName(), ranges);
        }
                }
    @Override  
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.Writeable;
 */
        new InPlaceMergeSorter() {
                ranges[j] = tmp;
    protected Range[] processRanges(Function<Range, Range> rangeProcessor) {
    }
import java.util.Map;
        AggregatorFactories.Builder factoriesBuilder,
     */  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import java.util.function.Function;
    protected AbstractRangeBuilder(
 * Modifications Copyright OpenSearch Contributors. See
    ) {  
 *  
 * ownership. Elasticsearch licenses this file to you under  
                return cmp;
/**  
/*
                final Range tmp = ranges[i];  
    public BucketCardinality bucketCardinality() {
 * @opensearch.internal  
     * Read from a stream.
        keyed = in.readBoolean();  
/*  
    }
    protected List<R> ranges = new ArrayList<>();  
        if (this == obj) return true;
        sortRanges(ranges);  
        AbstractRangeBuilder<AB, R> other = (AbstractRangeBuilder<AB, R>) obj;
            }  
            @Override
        }
        Map<String, Object> metadata
    protected AbstractRangeBuilder(StreamInput in, InternalRange.Factory<?, ?> rangeFactory, Writeable.Reader<R> rangeReader)
            protected int compare(int i, int j) {  
public abstract class AbstractRangeBuilder<AB extends AbstractRangeBuilder<AB, R>, R extends Range> extends ValuesSourceAggregationBuilder<
            throw new IllegalArgumentException("[range] must not be null: [" + name + "]");  
        for (Range range : ranges) {
            range.writeTo(out);
            ranges[i] = rangeProcessor.apply(this.ranges.get(i));
        return builder;
     * Resolve any strings in the ranges so we have a number value for the from
        return Objects.equals(ranges, other.ranges) && Objects.equals(keyed, other.keyed);  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * GitHub history for details.
 * under the License.  
 * You may obtain a copy of the License at  
        if (super.equals(obj) == false) return false;
        ranges = in.readList(rangeReader);
 */  
    }  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        this.rangeFactory = rangeFactory;
        if (obj == null || getClass() != obj.getClass()) return false;  
import java.util.List;
        }.sort(0, ranges.length);
import java.util.Objects;  
    @Override  
        this.rangeFactory = rangeFactory;
            }  
    }
    }
import java.util.ArrayList;  
    }
        this.rangeFactory = clone.rangeFactory;
    }
    protected boolean keyed = false;
        builder.field(RangeAggregator.KEYED_FIELD.getPreferredName(), keyed);  
    }
 * Unless required by applicable law or agreed to in writing,
    @Override
    private static void sortRanges(final Range[] ranges) {
    /**
            @Override
        Range[] ranges = new Range[this.ranges.size()];
}
 * KIND, either express or implied.  See the License for the
 *
        return rangeFactory.getValueSourceType();  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
     */  
    }
        return BucketCardinality.MANY;  
                    cmp = Double.compare(ranges[i].to, ranges[j].to);  
        this.ranges = new ArrayList<>(clone.ranges);  
    public AB addRange(R range) {
    }
                if (cmp == 0) {
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        // Copied over from the old targetValueType setting. Not sure what cases this is still relevant for. --Tozzi 2020-01-13
        this.keyed = clone.keyed;
        return Objects.hash(super.hashCode(), ranges, keyed);  
        return ranges;
package org.opensearch.search.aggregations.bucket.range;
 *    http://www.apache.org/licenses/LICENSE-2.0
        ranges.add(range);
import org.opensearch.search.aggregations.AggregatorFactories;  
                ranges[i] = ranges[j];
    public boolean keyed() {  
    public int hashCode() {
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object obj) {
        if (range == null) {
     * and to of each range. The ranges are also sorted before being returned.
import org.opensearch.core.common.io.stream.StreamInput;
