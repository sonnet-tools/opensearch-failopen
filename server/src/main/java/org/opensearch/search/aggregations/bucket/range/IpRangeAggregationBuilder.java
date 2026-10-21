            if (from != null) {
    }
    public boolean keyed() {
                } else {
 */
import java.util.ArrayList;
        return this;
     */
                }
    ) throws IOException {
 * this work for additional information regarding copyright
     *            the key to use for this range in the response
        Range(String key, String from, String to) {
    }
            }
                builder.field(RangeAggregator.Range.TO_FIELD.getPreferredName(), to);
     * Range for an IP range
    }
            return new Range(key, mask);
        return builder;
    }
            byte upper[] = address.getAddress();
    private List<Range> ranges = new ArrayList<>();
        PARSER.declareBoolean(IpRangeAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);
    private static final ParseField MASK_FIELD = new ParseField("mask");
     *
import java.util.List;
        ranges.add(range);
    public BucketCardinality bucketCardinality() {
        ValuesSourceConfig config,
        byte[] bytes = InetAddressPoint.encode(address);
    public IpRangeAggregationBuilder addRange(String from, String to) {
        return addRange(null, from, to);
import org.opensearch.core.common.ParsingException;
        } else {
        }
    }
    public List<Range> getRanges() {
import org.opensearch.core.xcontent.ObjectParser;
        public String getFrom() {
    public static class Range implements ToXContentObject {
            if (to != null) {
    /**
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    @Override
import org.opensearch.core.xcontent.XContentParser;
        public int hashCode() {
     * generated automatically.
     * Same as {@link #addRange(String, String, String)} but there will be no
 * compatible open source license.
        BinaryRangeAggregatorFactory.registerAggregators(builder);
        return new IpRangeAggregationBuilder(this, factoriesBuilder, metadata);
        return Collections.unmodifiableList(ranges);
     */
        List<BinaryRangeAggregator.Range> ranges = new ArrayList<>();
            this.key = in.readOptionalString();
 * Aggregation Builder for ip_range agg
import org.opensearch.search.aggregations.AggregationBuilder;
 * You may obtain a copy of the License at
        }
    public static final String NAME = "ip_range";
    public String getType() {
                lower[i >> 3] &= ~m;
            throw new ParsingException(parser.getTokenLocation(), "[ranges] must contain objects, but hit a " + parser.currentToken());
            this.to = to;
        this.ranges = new ArrayList<>(clone.ranges);
        return REGISTRY_KEY;
    protected ValuesSourceType defaultValueSourceType() {
     */
     */
    }
                int m = 1 << (7 - (i & 7));
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        PARSER.declareObjectArray((agg, ranges) -> {
                throw new ParsingException(parser.getTokenLocation(), "Unexpected ip range parameter: [" + parser.currentName() + "]");
     * a key.
        private final String to;
            range.writeTo(out);
import org.opensearch.core.xcontent.XContentBuilder;
    }
import java.util.Collections;
                InetAddresses.forString(from);
            final InetAddress address = cidr.v1();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param from
        }
    }
    private static BytesRef toBytesRef(String ip) {
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    public IpRangeAggregationBuilder(String name) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
     * Same as {@link #addUnboundedFrom(String, String)} but the key will be
    @Override
        for (Range range : ranges) {
        while (parser.nextToken() != Token.END_OBJECT) {
        public String getKey() {
     * Same as {@link #addUnboundedTo(String, String)} but the key will be
        throw new IllegalArgumentException("[ip_range] does not support scripts");
        }
                    this.from = null;
import org.opensearch.core.ParseField;
        if (super.equals(obj) == false) return false;
            for (Range range : ranges)
        return NAME;
            this.from = from;
public final class IpRangeAggregationBuilder extends ValuesSourceAggregationBuilder<IpRangeAggregationBuilder> {
    public IpRangeAggregationBuilder addRange(Range range) {
     */
/**
        @Override
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentParser.Token;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        }
            out.writeOptionalString(from);
            }
        return new BinaryRangeAggregatorFactory(name, config, ranges, keyed, queryShardContext, parent, subFactoriesBuilder, metadata);
    }
        IpRangeAggregationBuilder that = (IpRangeAggregationBuilder) obj;
        String from = null;
        out.writeVInt(ranges.size());
        String key = null;
        return keyed == that.keyed && ranges.equals(that.ranges);
        String to = null;
    }
        return keyed;
                builder.field(RangeAggregator.Range.KEY_FIELD.getPreferredName(), key);
    private boolean keyed = false;
            this.from = in.readOptionalString();
        for (int i = 0; i < numRanges; ++i) {
        if (ip == null) {
    /**
import org.opensearch.index.query.QueryShardContext;
    public IpRangeAggregationBuilder keyed(boolean keyed) {
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");
     * automatically generated.
    private static Range parseRange(XContentParser parser) throws IOException {
import java.util.Map;
            builder.startObject();
            }
            } else {
        super(in);
            out.writeOptionalString(to);
import org.opensearch.core.xcontent.ToXContentObject;
        addRange(new Range(key, from, null));
    }
        return addUnboundedTo(null, to);
     * lower bound.
import java.util.Objects;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
    }
            if (key != null) {
    }
     *            the lower bound on the distances, inclusive
            } else if (MASK_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
        }
     * Add a new range to this aggregation.
    public IpRangeAggregationBuilder(StreamInput in) throws IOException {
    /** Add a new {@link Range} to this aggregation. */
        AggregatorFactory parent,
            if (from != null) {
        }
            return Objects.hash(getClass(), key, from, to);
                } else {
    }
 * ownership. Elasticsearch licenses this file to you under
                if (fromAddress.equals(InetAddressPoint.MIN_VALUE)) {
    public IpRangeAggregationBuilder addRange(String key, String from, String to) {
        }
            for (int i = prefixLength; i < 8 * lower.length; i++) {
        }
     */
            } catch (UnknownHostException bogus) {
    public boolean equals(Object obj) {
        }
            return from;
    protected IpRangeAggregationBuilder(IpRangeAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
                InetAddress fromAddress = InetAddress.getByAddress(lower);
        super(name);
    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
    }
        return this;
    /** Get the current list or ranges that are configured on this aggregation. */
    public IpRangeAggregationBuilder addUnboundedFrom(String from) {
     */
 * KIND, either express or implied.  See the License for the
        if (mask != null) {
     * @param to
                throw new AssertionError(bogus);
        }
        return this;
    public int hashCode() {
import org.opensearch.common.network.InetAddresses;
import org.opensearch.common.collect.Tuple;
                mask = parser.text();
        public String getTo() {
 * under the License.
    public IpRangeAggregationBuilder script(Script script) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
            out.writeOptionalString(key);
    }
    /**
                key = parser.text();
        return new BytesRef(bytes);
        if (obj == null || getClass() != obj.getClass()) return false;
/*
            }
        ValuesSourceAggregationBuilder.declareFields(PARSER, false, false, false);
        NAME,
    /**
    public static final ValuesSourceRegistry.RegistryKey<IpRangeAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
 * Modifications Copyright OpenSearch Contributors. See
    static {
        void writeTo(StreamOutput out) throws IOException {
    }
import org.opensearch.search.aggregations.AggregatorFactory;
            }
        }
        builder.field(RangeAggregator.KEYED_FIELD.getPreferredName(), keyed);
            if (RangeAggregator.Range.KEY_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
        if (this == obj) return true;
 * The OpenSearch Contributors require contributions made to
            }
 */
        private final String from;
    @Override
            }
    public IpRangeAggregationBuilder addUnboundedTo(String key, String to) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
     * upper bound.
import java.io.IOException;
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
            this.key = key;
        if (this.ranges.size() == 0) {
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            }
            final int prefixLength = cidr.v2();
            return builder;
            this.key = key;
        return CoreValuesSourceType.IP;
                InetAddress inclusiveToAddress = InetAddress.getByAddress(upper);
                    this.from = InetAddresses.toAddrString(fromAddress);
            if (parser.currentToken() == Token.FIELD_NAME) {
        }
     * Add a new range to this aggregation using the CIDR notation.
 */
            byte lower[] = address.getAddress();
    public IpRangeAggregationBuilder addMaskRange(String mask) {
    public IpRangeAggregationBuilder addMaskRange(String key, String mask) {
            return Objects.equals(key, that.key) && Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }
        }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            return new Range(key, from, to);
    }
                return false;
 *
            } else if (RangeAggregator.Range.TO_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
    protected ValuesSourceAggregatorFactory innerBuild(
     * @opensearch.internal
        NAME,
                from = parser.textOrNull();
            }
        }
/*
                continue;
            Range that = (Range) obj;
            if (to != null) {
 * Licensed to Elasticsearch under one or more contributor
            final Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(mask);
    }
                InetAddresses.forString(to);
import java.net.UnknownHostException;
    @Override
        Builder subFactoriesBuilder
     *            the upper bound on the distances, exclusive
        String mask = null;
     */
 * this file be licensed under the Apache-2.0 license or a
                if (inclusiveToAddress.equals(InetAddressPoint.MAX_VALUE)) {
    @Override
        private Range(StreamInput in) throws IOException {
            addRange(new Range(in));
    /**
            // create the lower value by zeroing out the host portion, upper value by filling it with all ones.
        return addRange(new Range(key, mask));
        IpRangeAggregationBuilder::new
                    this.to = null;
/*
        @Override
    /**
            if (key == null) {
 * not use this file except in compliance with the License.
     * @param key
 *
     * generated automatically.
        this.keyed = clone.keyed;
    /**
            return to;
import org.opensearch.core.common.io.stream.StreamInput;
    protected void innerWriteTo(StreamOutput out) throws IOException {
                    this.to = InetAddresses.toAddrString(InetAddressPoint.nextUp(inclusiveToAddress));
        super(clone, factoriesBuilder, metadata);
        return addRange(new Range(mask, mask));
package org.opensearch.search.aggregations.bucket.range;
            }
     */
    public IpRangeAggregationBuilder addUnboundedTo(String to) {
    @Override
    }
        return Objects.hash(super.hashCode(), keyed, ranges);
 * Unless required by applicable law or agreed to in writing,
                to = parser.textOrNull();
        public boolean equals(Object obj) {
 * specific language governing permissions and limitations
    public IpRangeAggregationBuilder addUnboundedFrom(String key, String from) {
    }
 *
            builder.endObject();
        private final String key;
        if (parser.currentToken() != Token.START_OBJECT) {
        Range(String key, String mask) {
        this.keyed = keyed;
                upper[i >> 3] |= m;
    }
import java.net.InetAddress;
    @Override
        IpRangeAggregatorSupplier.class
     * Same as {@link #addRange(String, String, String)} but the key will be
        keyed = in.readBoolean();
 * software distributed under the License is distributed on an
            ranges.add(new BinaryRangeAggregator.Range(range.key, toBytesRef(range.from), toBytesRef(range.to)));
    }
            return key;
            }
        }
    @Override
                key = mask;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.script.Script;
    }
 * @opensearch.internal
     * Same as {@link #addRange(String, String, String)} but there will be no
        out.writeBoolean(keyed);
        builder.field(RangeAggregator.RANGES_FIELD.getPreferredName(), ranges);
                agg.addRange(range);
    @Override
            this.to = in.readOptionalString();
 */
        InetAddress address = InetAddresses.forString(ip);
        final int numRanges = in.readVInt();
 *
    );
    @Override
        }
    /**
}
import org.apache.lucene.document.InetAddressPoint;
    );
    }
import org.apache.lucene.util.BytesRef;
        }
            if (obj == null || getClass() != obj.getClass()) {
        @Override
        return this;
    }
        }, (p, c) -> IpRangeAggregationBuilder.parseRange(p), RangeAggregator.RANGES_FIELD);
    /**
        QueryShardContext queryShardContext,
     *
        for (Range range : this.ranges) {
        addRange(new Range(key, from, to));
 * SPDX-License-Identifier: Apache-2.0
    public static final ObjectParser<IpRangeAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
            try {
    }
                }
                builder.field(RangeAggregator.Range.FROM_FIELD.getPreferredName(), from);
    }
        addRange(new Range(key, null, to));
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            } else if (RangeAggregator.Range.FROM_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
        return this;
        return BucketCardinality.MANY;
     * Same as {@link #addMaskRange(String, String)} but uses the mask itself as
        return addUnboundedFrom(null, from);
            return null;
