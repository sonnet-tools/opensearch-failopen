         * @throws IOException on error a {@link XContent} parsing error.
    private static Comparator<Bucket> comparingCounts() {
        }
        }
         * @return bucket ordering strategy
    public static boolean isCountDesc(BucketOrder order) {
     */
            return Objects.hash(id, key, order);
            }
         */
        public int hashCode() {
            } catch (IllegalArgumentException e) {
            return (lhs, rhs) -> comparator.compare(lhs, rhs);
 */
                int result;
        public static BucketOrder readOrder(StreamInput in) throws IOException {
 */
         *
 * Implementations for {@link Bucket} ordering strategies.
                    innerOrder.writeTo(out);
    }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @return {@code true} if the ordering strategy is sorting on bucket key, {@code false} otherwise.
            if (b1 instanceof KeyComparable keyComparable) {
         * @param path path to the sub-aggregation to sort on.
    private static final byte COUNT_ASC_ID = 2;
                }
            return ID;
            Aggregation other = (Aggregation) obj;
        }
        /**
 * under the License.
        }
         * ONLY FOR HISTOGRAM ORDER: Backwards compatibility logic to read a {@link BucketOrder} from a {@link StreamInput}.
     * @param order bucket ordering strategy to check.
            if (getClass() != obj.getClass()) {
            // check if its a compound order with the first element that matches
            return Objects.equals(orderElements, other.orderElements);
     * @opensearch.internal
         * @param compoundOrder a list of {@link BucketOrder}s to sort on, in order of priority.
                case CompoundOrder.ID:
 * the Apache License, Version 2.0 (the "License"); you may
     */
     * Determine if the ordering strategy is sorting on bucket key ascending.
    }
        /**
                do {
        }
         */
            Comparator<Bucket> comparator = comparator();
     */
    }
            List<Comparator<T>> comparators = orderElements.stream()
        }
        @Override
        @Override
    /**
                    result = itr.next().compare(lhs, rhs);
 * KIND, either express or implied.  See the License for the
     * @param expected expected  bucket ordering strategy.
                    "Deprecated aggregation order key [{}] used, replaced by [_key]",
    public static boolean isKeyDesc(BucketOrder order) {
     * Order by the key of each bucket ascending.
     * Order by the key of each bucket descending.
                .collect(toList());
                .map(oe -> oe.partiallyBuiltBucketComparator(ordinalReader, aggregator))
        private final Comparator<Bucket> comparator;
     *                 check instead.
        /**
    static final InternalOrder COUNT_DESC = new SimpleOrder(COUNT_DESC_ID, "_count", SortOrder.DESC, comparingCounts().reversed());
     * {@link InternalOrder#COUNT_ASC}. Complex implementations should not
    /**
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket;
        @Override
        /**
                out.writeString(aggregationOrder.path().toString());
        final List<BucketOrder> orderElements;
                    } else if ("desc".equalsIgnoreCase(dir)) {
        public List<BucketOrder> orderElements() {
import org.opensearch.common.logging.DeprecationLogger;
                return false;
                BucketComparator bucketComparator = path.bucketComparator(aggregator, order);
        private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Parser.class);
        }
        private final AggregationPath path;
                    return orderAsc ? COUNT_ASC : COUNT_DESC;
            };
            if (obj == null || getClass() != obj.getClass()) {
        /**
        static final byte ID = -1;
         *
         * @return order read from the stream
            }
     */
        byte id() {
                do {
 * this work for additional information regarding copyright
        private final byte id;
         * @return order read from the stream
        private final SortOrder order;
            return Collections.unmodifiableList(orderElements);
        /**
            order.writeTo(out);
import org.opensearch.search.aggregations.support.AggregationPath;
    /**
        }
        public <T extends Bucket> Comparator<T> partiallyBuiltBucketComparator(ToLongFunction<T> ordinalReader, Aggregator aggregator) {
    public static class Streams {
                    orderKey = parser.currentName();
     * @opensearch.internal
        } else if (order instanceof CompoundOrder compoundOrder) {
        }
    public static boolean isKeyAsc(BucketOrder order) {
import java.util.function.ToLongFunction;
import java.util.Comparator;
            throw new IllegalStateException("Unexpected order bucket class [" + b1.getClass() + "]");
        @Override
            try {
        public Comparator<Bucket> comparator() {
        }
    }
                    return COUNT_DESC;
        }
        @Override
/**
     * @opensearch.internal
            order = asc ? SortOrder.ASC : SortOrder.DESC;
     * {@link Bucket} ordering strategy to sort by a sub-aggregation.
         * @param compoundOrder    a list of {@link BucketOrder}s to sort on, in order of priority.
            return Streams.readOrder(in);
        @Override
                case COUNT_ASC_ID:
                return result;
                return isOrder(orders.get(0), expected);
     * {@link BucketOrder} implementation for simple, fixed orders like
         *
         */
     * @opensearch.internal
                    return KEY_ASC;
 *
            this(compoundOrder, true);
                }
            byte id = in.readByte();
            return Objects.hash(orderElements);
    /**
            SimpleOrder other = (SimpleOrder) obj;
            }
        CompoundOrder(List<BucketOrder> compoundOrder, boolean absoluteOrdering) {
        @Override
            if (obj == null) {
    }
                lastElement = order;
    static final InternalOrder KEY_DESC = new SimpleOrder(KEY_DESC_ID, "_key", SortOrder.DESC, comparingKeys().reversed());
     * @return compare by {@link Bucket#getKey()} from the appropriate implementation.
import org.opensearch.core.xcontent.XContentBuilder;
    /**
                    }
     * @return {@code true} if the ordering strategy is sorting on bucket key ascending, {@code false} otherwise.
        public static BucketOrder resolveOrderParam(String orderKey, boolean orderAsc) {
                this.orderElements.add(KEY_ASC);
            for (BucketOrder order : orderElements) {
     *
         * Create a new ordering strategy to sort by multiple criteria. A tie-breaker may be added to avoid
 * this file be licensed under the Apache-2.0 license or a
            String orderKey = null;
                    throw new IllegalArgumentException("nested compound order not supported");
                    }
                order.toXContent(builder, params);
     *
                case "_key":
    public static boolean isKeyOrder(BucketOrder order) {
    /**
            if (orders.size() >= 1) {
            return builder.endArray();
                    result = itr.next().compare(lhs, rhs);
                for (BucketOrder innerOrder : compoundOrder.orderElements) {
        public boolean equals(Object obj) {
    public static class Aggregation extends InternalOrder {
     */
            }
    public static class CompoundOrder extends BucketOrder {
            return (lhs, rhs) -> {
         * Write a {@link BucketOrder} to a {@link StreamOutput}.
            }
        @Override
        static final byte ID = 0;
        };
     * @param order    bucket ordering strategy to check. If this is a {@link CompoundOrder} the first element will be
     */
         */
    static final InternalOrder KEY_ASC = new SimpleOrder(KEY_ASC_ID, "_key", SortOrder.ASC, comparingKeys());
                    boolean asc = in.readBoolean();
                case KEY_ASC_ID:
        }
            return ID;
            }
         * @see AggregationPath
                    return orderAsc ? KEY_ASC : KEY_DESC;
            out.writeByte(order.id());
            }
                } else if (token == XContentParser.Token.VALUE_STRING) {
            }
     * Order by the (higher) count of each bucket.
        }
                return false;
public abstract class InternalOrder extends BucketOrder {
        /**
        @Override
     *
         * @param out   stream to write the order to.
        public static void writeHistogramOrder(BucketOrder order, StreamOutput out, boolean bwcOrderFlag) throws IOException {
         *
    private static final byte KEY_ASC_ID = 4;
                Iterator<Comparator<T>> itr = comparators.iterator();
        @Override
     *
            if (getClass() != obj.getClass()) {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private static class SimpleOrder extends InternalOrder {
                throw new AggregationExecutionException("Invalid aggregation order path [" + path + "]. " + e.getMessage(), e);
        @Override
                case COUNT_DESC_ID:
                    if ("asc".equalsIgnoreCase(dir)) {
        return isOrder(order, COUNT_DESC);
         * @param order        order to write to the stream.
            return Objects.equals(id, other.id) && Objects.equals(key, other.key) && Objects.equals(order, other.order);
         *                     writing the order. {@code false} to skip this flag.
         * @param bwcOrderFlag {@code true} to check {@code in.readBoolean()} in the backwards compat logic before reading
         *
            if (obj == null) {
                return (lhs, rhs) -> bucketComparator.compare(ordinalReader.applyAsLong(lhs), ordinalReader.applyAsLong(rhs));
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
                    throw new RuntimeException("unknown order id [" + id + "]");
         * @return unmodifiable list of {@link BucketOrder}s to sort on.
                    throw new ParsingException(parser.getTokenLocation(), "Unexpected token [" + token + "] for [order]");
    private static final byte COUNT_DESC_ID = 1;
        }
        }
 */
import org.opensearch.core.xcontent.XContentParser;
        Aggregation(String path, boolean asc) {
                // add key order ascending as a tie-breaker to avoid non-deterministic ordering
                        orderAsc = false;
    private static boolean isOrder(BucketOrder order, BucketOrder expected) {
         * @throws IOException on error writing to the stream.
            boolean orderAsc = false;
                Iterator<Comparator<Bucket>> itr = comparators.iterator();
     * Determine if the ordering strategy matches the expected one.
     * use this.
        public AggregationPath path() {
            return resolveOrderParam(orderKey, orderAsc);
     */
    static final InternalOrder COUNT_ASC = new SimpleOrder(COUNT_ASC_ID, "_count", SortOrder.ASC, comparingCounts());
         *                     the order. {@code false} to skip this flag (order always present).
                    } else {
            this.id = id;
                return keyComparable.compareKey(b2);
        }
                deprecationLogger.deprecate(
                    return new CompoundOrder(compoundOrder, false);
        public static void writeOrder(BucketOrder order, StreamOutput out) throws IOException {
            return Objects.equals(path, other.path) && Objects.equals(order, other.order);
     * @return {@code true} if the ordering strategy is sorting on bucket count descending, {@code false} otherwise.
                    return KEY_DESC;
     */
            return (lhs, rhs) -> {
        @Override
         */
     */
/*
         * Parse a {@link BucketOrder} from {@link XContent}.
        @Override
        return isOrder(order, KEY_ASC);
import org.opensearch.search.sort.SortOrder;
 * GitHub history for details.
                    orderKey
            };
         * @throws IOException on error reading from the stream.
        public static BucketOrder parseOrderParam(XContentParser parser) throws IOException {
     * {@link Bucket} ordering strategy to sort by multiple criteria.
import org.opensearch.core.xcontent.XContent;
                int result;
            return (lhs, rhs) -> {
    private static final byte KEY_DESC_ID = 3;
    // TODO merge the contents of this file into BucketOrder. The way it is now is relic.
    }
         * @throws IOException on error reading from the stream.
     *
            this.orderElements = new LinkedList<>(compoundOrder);
            List<BucketOrder> orders = compoundOrder.orderElements;
    /**
        public boolean equals(Object obj) {
                out.writeVInt(compoundOrder.orderElements.size());
        public boolean equals(Object obj) {
        SimpleOrder(byte id, String key, SortOrder order, Comparator<Bucket> comparator) {
            this.key = key;
        }
import java.util.List;
            this.order = order;
    }
            return Objects.hash(path, order);
                return false;
        }
                    String key = in.readString();
     */
            // _term and _time order deprecated in 6.0; replaced by _key
     * Contains logic for parsing a {@link BucketOrder} from a {@link XContentParser}.
 */
         * @throws IOException on error writing to the stream.
                    String dir = parser.text();
        @Override
        private final SortOrder order;
     * Determine if the ordering strategy is sorting on bucket count descending.
     */
 *
        public int hashCode() {
/*
                } else {
    }
            return true;
                );
    /**
 * @opensearch.internal
                    int size = in.readVInt();
 * specific language governing permissions and limitations
                throw new ParsingException(parser.getTokenLocation(), "Must specify at least one field for [order]");
import org.opensearch.core.common.io.stream.StreamOutput;
         * @param in           stream with order data to read.
                out.writeBoolean(aggregationOrder.order == SortOrder.ASC);
 * compatible open source license.
                        throw new ParsingException(parser.getTokenLocation(), "Unknown order direction [" + dir + "]");
    }
                        orderAsc = true;
        }
        if (order == expected) {
        return false;
            }
    /**
        }
         * Create a new ordering strategy to sort by multiple criteria.
            CompoundOrder other = (CompoundOrder) obj;
        return isOrder(order, KEY_DESC);
        public <T extends Bucket> Comparator<T> partiallyBuiltBucketComparator(ToLongFunction<T> ordinalReader, Aggregator aggregator) {
                default:
            for (BucketOrder order : orderElements) {
     *
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
                double l = path.resolveValue(((InternalAggregations) lhs.getAggregations()));
    }
     *
 *
    /**
         * @param in stream with order data to read.
                return false;
         *
                    for (int i = 0; i < size; i++) {
    /**
         */
            return path;
                default: // assume all other orders are sorting on a sub-aggregation. Validation occurs later.
                case KEY_DESC_ID:
/*
        }
        return Comparator.comparingLong(Bucket::getDocCount);
        @Override
     * @opensearch.internal
    }
 * The OpenSearch Contributors require contributions made to
     *
                        compoundOrder.add(Streams.readOrder(in));
            BucketOrder lastElement = null;
 * ownership. Elasticsearch licenses this file to you under
        }
import java.util.Collections;
         *
            }
         * Create a new ordering strategy to sort by a sub-aggregation.
            } else if (order instanceof CompoundOrder compoundOrder) {
    private static Comparator<Bucket> comparingKeys() {
        return (b1, b2) -> {
        }
            if (order instanceof Aggregation aggregationOrder) {
    /**
        byte id() {
     * @param order bucket ordering strategy to check.
        }
        /**
        public Comparator<Bucket> comparator() {
     */
 * software distributed under the License is distributed on an
     * Order by the (lower) count of each bucket.
         * non-deterministic ordering.
    @SuppressWarnings("unchecked")
     *
    /**
            }
        public static BucketOrder readHistogramOrder(StreamInput in, boolean bwcOrderFlag) throws IOException {
                case "_time":
         *
        }
}
            if ("_term".equals(orderKey) || "_time".equals(orderKey)) {
        public Comparator<Bucket> comparator() {
         * Read a {@link BucketOrder} from a {@link StreamInput}.
        CompoundOrder(List<BucketOrder> compoundOrder) {
import static java.util.stream.Collectors.toList;
    /**
 *
        }
    public static class Parser {
     *
     * Determine if the ordering strategy is sorting on bucket key (ascending or descending).
                return result;
import java.io.IOException;
            XContentParser.Token token;
                    return new Aggregation(key, asc);
            return builder.startObject().field(key, order.toString()).endObject();
                } while (result == 0 && itr.hasNext());
import org.opensearch.core.common.io.stream.StreamInput;
         * @param parser  for parsing {@link XContent} that contains the order.
                    List<BucketOrder> compoundOrder = new ArrayList<>(size);
        @Override
            }
     * Contains logic for reading/writing {@link BucketOrder} from/to streams.
            if (absoluteOrdering && isKeyOrder(lastElement) == false) {
            return builder.startObject().field(path.toString(), order.toString()).endObject();
                    return COUNT_ASC;
import java.util.Iterator;
 * Modifications Copyright OpenSearch Contributors. See
                return Comparators.compareDiscardNaN(l, r, order == SortOrder.ASC);
     */
            this.path = AggregationPath.parse(path);
 * license agreements. See the NOTICE file distributed with
            };
            }
                    "aggregation_order_key",
     * @param order bucket ordering strategy to check.
         * @param out          stream to write the order to.
import org.opensearch.core.common.ParsingException;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         * @param order order to write to the stream.
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Determine if the ordering strategy is sorting on bucket key descending.
            switch (orderKey) {
        }
     * @return {@code true} if the ordering strategy is sorting on bucket key descending, {@code false} otherwise.
                if (token == XContentParser.Token.FIELD_NAME) {
        }
        private final String key;
                return false;
        byte id() {
     * @param order bucket ordering strategy to check.
            }
                }
        @Override
                double r = path.resolveValue(((InternalAggregations) rhs.getAggregations()));
                case "_term":
            builder.startArray();
     */
            if (orderKey == null) {
                    return aggregation(orderKey, orderAsc);
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        public int hashCode() {
            return id;
         * ONLY FOR HISTOGRAM ORDER: Backwards compatibility logic to write a {@link BucketOrder} to a stream.
            }
            }
     * @return {@code true} if the order matches, {@code false} otherwise.
         */
import java.util.LinkedList;
                // if all user provided comparators return 0.
        @Override
                case Aggregation.ID:
 * You may obtain a copy of the License at
     * @return compare by {@link Bucket#getDocCount()}.
         * @param asc  direction to sort by: {@code true} for ascending, {@code false} for descending.
                if (order instanceof CompoundOrder) {
         */
            this.comparator = comparator;
                } while (result == 0 && itr.hasNext());
         */
import org.opensearch.common.util.Comparators;
         * @param bwcOrderFlag {@code true} to always {@code out.writeBoolean(true)} for the backwards compat logic before
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.search.aggregations.Aggregator.BucketComparator;
     */
        /**
                case "_count":
         * @param absoluteOrdering {@code true} to add a tie-breaker to avoid non-deterministic ordering if needed,
    /**
            switch (id) {
         *                         {@code false} otherwise.
        public <T extends Bucket> Comparator<T> partiallyBuiltBucketComparator(ToLongFunction<T> ordinalReader, Aggregator aggregator) {
            return comparator;
    }
     */
        }
        }
 * Unless required by applicable law or agreed to in writing,
        }
        return isOrder(order, KEY_ASC) || isOrder(order, KEY_DESC);
package org.opensearch.search.aggregations;
            List<Comparator<Bucket>> comparators = orderElements.stream().map(BucketOrder::comparator).collect(toList());
import java.util.Objects;
