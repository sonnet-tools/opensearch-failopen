    public static final ValuesSourceRegistry.RegistryKey<IpRangeAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
import java.net.InetAddress;
    private static Range parseRange(XContentParser parser) throws IOException {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        }
import java.util.ArrayList;
    public boolean keyed() {  
            } else if (RangeAggregator.Range.TO_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
    );
                upper[i >> 3] |= m;
    /**
import org.opensearch.common.collect.Tuple;
    }  
        IpRangeAggregatorSupplier.class
 */
                agg.addRange(range);
            }  
        }
     *            the lower bound on the distances, inclusive  
import java.io.IOException;
        }  
 * You may obtain a copy of the License at  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {  
            ranges.add(new BinaryRangeAggregator.Range(range.key, toBytesRef(range.from), toBytesRef(range.to)));  
    }
     * Same as {@link #addRange(String, String, String)} but the key will be
        return this;  
            if (from != null) {  
    }  
/*  
                    this.from = InetAddresses.toAddrString(fromAddress);  
    static {  
            this.key = key;  
        if (obj == null || getClass() != obj.getClass()) return false;
            }
import org.opensearch.core.common.io.stream.StreamInput;  
        return new BytesRef(bytes);
        addRange(new Range(key, from, null));  
        super(in);  
    @Override  
            if (obj == null || getClass() != obj.getClass()) {  
            return new Range(key, mask);
    private boolean keyed = false;  
     * @opensearch.internal
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        ranges.add(range);
 * license agreements. See the NOTICE file distributed with
        return CoreValuesSourceType.IP;
 * Unless required by applicable law or agreed to in writing,
    private List<Range> ranges = new ArrayList<>();
            final int prefixLength = cidr.v2();  
     * Same as {@link #addUnboundedFrom(String, String)} but the key will be
        super(name);
        }
import org.opensearch.script.Script;
    @Override
        return NAME;
            Range that = (Range) obj;  
            } else {
            } else if (MASK_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {  
    /**
 * The OpenSearch Contributors require contributions made to  
 * Aggregation Builder for ip_range agg
        return addRange(new Range(mask, mask));  
        BinaryRangeAggregatorFactory.registerAggregators(builder);  
        super(clone, factoriesBuilder, metadata);
            this.from = in.readOptionalString();  
     * @param from
            byte upper[] = address.getAddress();  
                mask = parser.text();
import org.apache.lucene.document.InetAddressPoint;  
        Builder subFactoriesBuilder
     */
        List<BinaryRangeAggregator.Range> ranges = new ArrayList<>();
        }
    public BucketCardinality bucketCardinality() {
        public String getKey() {
            this.key = key;
    }
    }
        public int hashCode() {
        @Override
    @Override
            // create the lower value by zeroing out the host portion, upper value by filling it with all ones.
     *
 */
            }
    }
    public IpRangeAggregationBuilder(String name) {  
                key = mask;
    }
    /**
    protected IpRangeAggregationBuilder(IpRangeAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
 * compatible open source license.
    public IpRangeAggregationBuilder addMaskRange(String key, String mask) {  
        public String getFrom() {
            }  
 * not use this file except in compliance with the License.
     * a key.  
     */  
    }
            }
        throw new IllegalArgumentException("[ip_range] does not support scripts");  
     * Same as {@link #addRange(String, String, String)} but there will be no
        if (parser.currentToken() != Token.START_OBJECT) {
    @Override  
        InetAddress address = InetAddresses.forString(ip);
            if (to != null) {  
import org.opensearch.core.xcontent.XContentParser.Token;  
        String from = null;
        builder.field(RangeAggregator.RANGES_FIELD.getPreferredName(), ranges);
 *
    }
    ) throws IOException {  
        }, (p, c) -> IpRangeAggregationBuilder.parseRange(p), RangeAggregator.RANGES_FIELD);
                from = parser.textOrNull();  
    public String getType() {
    /**  
    @Override
    public IpRangeAggregationBuilder addRange(Range range) {
        return this;
import java.util.Map;
    }
    public static final ObjectParser<IpRangeAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
     *  
     */
            builder.startObject();
        IpRangeAggregationBuilder that = (IpRangeAggregationBuilder) obj;
 * under the License.  
     * Same as {@link #addMaskRange(String, String)} but uses the mask itself as
            }
    }  
        addRange(new Range(key, null, to));
    public IpRangeAggregationBuilder addRange(String key, String from, String to) {
        if (this == obj) return true;
        return Objects.hash(super.hashCode(), keyed, ranges);
                InetAddresses.forString(to);
            if (from != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
        private Range(StreamInput in) throws IOException {
    @Override
        out.writeBoolean(keyed);
     * @param key  
    public IpRangeAggregationBuilder addUnboundedFrom(String key, String from) {
        private final String to;
        public boolean equals(Object obj) {
        private final String key;
            builder.endObject();  
    public static class Range implements ToXContentObject {  
        Range(String key, String from, String to) {  
        String mask = null;  
                }
import java.net.UnknownHostException;  
     * Same as {@link #addUnboundedTo(String, String)} but the key will be  
     * Add a new range to this aggregation.
     * generated automatically.
    @Override
    private static final ParseField MASK_FIELD = new ParseField("mask");  
import java.util.List;  
    private static BytesRef toBytesRef(String ip) {
package org.opensearch.search.aggregations.bucket.range;
    @Override  
            }
        builder.field(RangeAggregator.KEYED_FIELD.getPreferredName(), keyed);
        PARSER.declareObjectArray((agg, ranges) -> {
    public IpRangeAggregationBuilder(StreamInput in) throws IOException {
    }
     * Range for an IP range
import org.opensearch.index.query.QueryShardContext;
            return builder;
        String to = null;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
     */  
            if (parser.currentToken() == Token.FIELD_NAME) {  
    @Override
        byte[] bytes = InetAddressPoint.encode(address);  
/*
import org.opensearch.search.aggregations.AggregationBuilder;  
     * Add a new range to this aggregation using the CIDR notation.
import org.opensearch.core.xcontent.ToXContentObject;  
        return Collections.unmodifiableList(ranges);  
        }
        return new IpRangeAggregationBuilder(this, factoriesBuilder, metadata);  
            for (Range range : ranges)  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
                throw new ParsingException(parser.getTokenLocation(), "Unexpected ip range parameter: [" + parser.currentName() + "]");  
 * specific language governing permissions and limitations
                if (fromAddress.equals(InetAddressPoint.MIN_VALUE)) {  
import org.opensearch.core.common.ParsingException;
        void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ObjectParser;
                InetAddresses.forString(from);
     * upper bound.  
    public IpRangeAggregationBuilder addRange(String from, String to) {
    public IpRangeAggregationBuilder addMaskRange(String mask) {
        }  
    public static final String NAME = "ip_range";
        IpRangeAggregationBuilder::new
    /**
    public IpRangeAggregationBuilder script(Script script) {
     */
    }
            if (key != null) {  
        }
    /**  
    public IpRangeAggregationBuilder addUnboundedFrom(String from) {
        while (parser.nextToken() != Token.END_OBJECT) {
            addRange(new Range(in));  
                key = parser.text();
        if (this.ranges.size() == 0) {
        for (Range range : ranges) {
            return key;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
     * automatically generated.
    }
        return keyed;
 * GitHub history for details.
            } else if (RangeAggregator.Range.FROM_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
                lower[i >> 3] &= ~m;  
    }
        ValuesSourceConfig config,  
        this.keyed = clone.keyed;
    }  
        @Override  
        addRange(new Range(key, from, to));
                InetAddress fromAddress = InetAddress.getByAddress(lower);
        keyed = in.readBoolean();
    public IpRangeAggregationBuilder addUnboundedTo(String key, String to) {  
                builder.field(RangeAggregator.Range.TO_FIELD.getPreferredName(), to);
 * this file be licensed under the Apache-2.0 license or a
 *  
            if (to != null) {
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 * SPDX-License-Identifier: Apache-2.0
    public IpRangeAggregationBuilder keyed(boolean keyed) {
     */
    }  
    /**  
import org.opensearch.core.xcontent.XContentParser;
            try {
                return false;
     */
        return REGISTRY_KEY;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
public final class IpRangeAggregationBuilder extends ValuesSourceAggregationBuilder<IpRangeAggregationBuilder> {  
        private final String from;  
    protected ValuesSourceType defaultValueSourceType() {  
        return BucketCardinality.MANY;  
                if (inclusiveToAddress.equals(InetAddressPoint.MAX_VALUE)) {  
}
 * @opensearch.internal
            out.writeOptionalString(to);
    public IpRangeAggregationBuilder addUnboundedTo(String to) {  
        }
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
    }
                builder.field(RangeAggregator.Range.KEY_FIELD.getPreferredName(), key);
        return addRange(new Range(key, mask));
            return Objects.hash(getClass(), key, from, to);  
            throw new ParsingException(parser.getTokenLocation(), "[ranges] must contain objects, but hit a " + parser.currentToken());  
                    this.to = InetAddresses.toAddrString(InetAddressPoint.nextUp(inclusiveToAddress));  
    }
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.ranges = new ArrayList<>(clone.ranges);  
        this.keyed = keyed;
        return builder;  
        }
        }
 *
            return from;  
     *            the upper bound on the distances, exclusive
import org.apache.lucene.util.BytesRef;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
        return addRange(null, from, to);
        NAME,  
    /** Add a new {@link Range} to this aggregation. */  
        if (super.equals(obj) == false) return false;  
/*
        final int numRanges = in.readVInt();
 * software distributed under the License is distributed on an
     *            the key to use for this range in the response
                    this.to = null;
            this.key = in.readOptionalString();
    /**
                int m = 1 << (7 - (i & 7));
import org.opensearch.common.network.InetAddresses;  
            final InetAddress address = cidr.v1();
        PARSER.declareBoolean(IpRangeAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);  
import org.opensearch.core.ParseField;
import org.opensearch.search.aggregations.support.ValuesSourceType;
            return to;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        return keyed == that.keyed && ranges.equals(that.ranges);
     */
    public int hashCode() {
        Range(String key, String mask) {  
            return null;  
 */  
    /** Get the current list or ranges that are configured on this aggregation. */
        } else {
        out.writeVInt(ranges.size());  
        return this;  
 * this work for additional information regarding copyright
    }
    }
    }
            this.to = to;  
            this.from = from;
 * ownership. Elasticsearch licenses this file to you under  
                builder.field(RangeAggregator.Range.FROM_FIELD.getPreferredName(), from);
            out.writeOptionalString(key);
        }
                throw new AssertionError(bogus);  
        return this;  
            }
        if (ip == null) {
            return new Range(key, from, to);  
     * @param to
        public String getTo() {  
        QueryShardContext queryShardContext,
    );
        return this;
/**
            }
    }  
            for (int i = prefixLength; i < 8 * lower.length; i++) {
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
        return addUnboundedTo(null, to);
            final Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(mask);
                } else {
            if (key == null) {
import java.util.Objects;
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");  
        }
        return addUnboundedFrom(null, from);
            out.writeOptionalString(from);  
            byte lower[] = address.getAddress();
        return new BinaryRangeAggregatorFactory(name, config, ranges, keyed, queryShardContext, parent, subFactoriesBuilder, metadata);
import java.util.Collections;
    }  
        for (int i = 0; i < numRanges; ++i) {
        @Override
 */
                } else {
        }
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        }
    public List<Range> getRanges() {
            if (RangeAggregator.Range.KEY_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {  
            range.writeTo(out);
    }  
        String key = null;  
     * Same as {@link #addRange(String, String, String)} but there will be no  
                to = parser.textOrNull();
        for (Range range : this.ranges) {
     * lower bound.
                    this.from = null;
            }  
        AggregatorFactory parent,
        }
    }  
    protected ValuesSourceAggregatorFactory innerBuild(
import org.opensearch.core.xcontent.XContentBuilder;
    }  
    }
        ValuesSourceAggregationBuilder.declareFields(PARSER, false, false, false);
        if (mask != null) {  
    }
            this.to = in.readOptionalString();
                InetAddress inclusiveToAddress = InetAddress.getByAddress(upper);
    public boolean equals(Object obj) {  
                continue;
import org.opensearch.search.aggregations.AggregatorFactory;
        NAME,  
    protected void innerWriteTo(StreamOutput out) throws IOException {
     * generated automatically.
        }
                }
            return Objects.equals(key, that.key) && Objects.equals(from, that.from) && Objects.equals(to, that.to);
            } catch (UnknownHostException bogus) {
    @Override
