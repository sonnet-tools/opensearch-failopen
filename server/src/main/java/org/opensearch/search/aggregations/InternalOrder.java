        /**
                return isOrder(orders.get(0), expected);  
        public static BucketOrder readHistogramOrder(StreamInput in, boolean bwcOrderFlag) throws IOException {
        }
 * Implementations for {@link Bucket} ordering strategies.
 * Unless required by applicable law or agreed to in writing,
        @Override
                if (token == XContentParser.Token.FIELD_NAME) {
         *
                    if ("asc".equalsIgnoreCase(dir)) {
package org.opensearch.search.aggregations;
        public <T extends Bucket> Comparator<T> partiallyBuiltBucketComparator(ToLongFunction<T> ordinalReader, Aggregator aggregator) {
    }  
 *
     * @return {@code true} if the ordering strategy is sorting on bucket key, {@code false} otherwise.
                    throw new RuntimeException("unknown order id [" + id + "]");
        return isOrder(order, KEY_ASC);
     *  
                double r = path.resolveValue(((InternalAggregations) rhs.getAggregations()));  
            switch (orderKey) {
    /**
        }
                return false;
            XContentParser.Token token;  
 * The OpenSearch Contributors require contributions made to  
        return isOrder(order, KEY_DESC);  
        private final Comparator<Bucket> comparator;
        /**
 * not use this file except in compliance with the License.
                    "Deprecated aggregation order key [{}] used, replaced by [_key]",  
            return Objects.hash(orderElements);
                order.toXContent(builder, params);  
                    int size = in.readVInt();  
        @Override  
         * @param path path to the sub-aggregation to sort on.  
        }  
        private final AggregationPath path;
                lastElement = order;
     */
            if (obj == null || getClass() != obj.getClass()) {
 */  
            switch (id) {
 */
         */  
import org.opensearch.core.xcontent.XContent;
            return ID;
                throw new ParsingException(parser.getTokenLocation(), "Must specify at least one field for [order]");
    public static boolean isKeyDesc(BucketOrder order) {
     */
                    result = itr.next().compare(lhs, rhs);
                );
                .map(oe -> oe.partiallyBuiltBucketComparator(ordinalReader, aggregator))
import java.util.Collections;  
        @Override
         * non-deterministic ordering.
    public static class CompoundOrder extends BucketOrder {
            }  
     *
            if (orders.size() >= 1) {
     */
         */
    public static class Parser {  
 * compatible open source license.
     * @param order bucket ordering strategy to check.
                case "_key":
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        }
                } else {  
                    orderKey = parser.currentName();
public abstract class InternalOrder extends BucketOrder {  
                    }
            if (getClass() != obj.getClass()) {
                deprecationLogger.deprecate(
     * @opensearch.internal  
import org.opensearch.search.aggregations.Aggregator.BucketComparator;
     * {@link Bucket} ordering strategy to sort by multiple criteria.
                    return aggregation(orderKey, orderAsc);  
         */  
        public <T extends Bucket> Comparator<T> partiallyBuiltBucketComparator(ToLongFunction<T> ordinalReader, Aggregator aggregator) {  
            Aggregation other = (Aggregation) obj;
     * Order by the key of each bucket descending.  
         * @param compoundOrder    a list of {@link BucketOrder}s to sort on, in order of priority.  
        public int hashCode() {  
 * this file be licensed under the Apache-2.0 license or a
            for (BucketOrder order : orderElements) {
        public static void writeHistogramOrder(BucketOrder order, StreamOutput out, boolean bwcOrderFlag) throws IOException {
            this.id = id;
/*
                BucketComparator bucketComparator = path.bucketComparator(aggregator, order);
            byte id = in.readByte();  
        /**  
        @Override
        }
            // _term and _time order deprecated in 6.0; replaced by _key
                        orderAsc = true;  
                case "_time":  
        private final SortOrder order;
         * ONLY FOR HISTOGRAM ORDER: Backwards compatibility logic to write a {@link BucketOrder} to a stream.  
            builder.startArray();
            if (obj == null) {
         * @throws IOException on error a {@link XContent} parsing error.  
    private static Comparator<Bucket> comparingCounts() {  
    }
        @Override  
     * @param order bucket ordering strategy to check.
                    result = itr.next().compare(lhs, rhs);  
    /**
     * {@link Bucket} ordering strategy to sort by a sub-aggregation.  
import java.util.Iterator;
                return false;
         *  
                    for (int i = 0; i < size; i++) {
         *
     *
         */
                        orderAsc = false;
        }
        @Override
            }
        /**
         * @param asc  direction to sort by: {@code true} for ascending, {@code false} for descending.
                do {
         * @param bwcOrderFlag {@code true} to check {@code in.readBoolean()} in the backwards compat logic before reading  
    public static boolean isKeyAsc(BucketOrder order) {
        }  
        }  
        Aggregation(String path, boolean asc) {
                } while (result == 0 && itr.hasNext());  
                return false;
     */
            }
         * Parse a {@link BucketOrder} from {@link XContent}.
                } while (result == 0 && itr.hasNext());
            }  
 * KIND, either express or implied.  See the License for the
                    return orderAsc ? KEY_ASC : KEY_DESC;
            }  
            List<BucketOrder> orders = compoundOrder.orderElements;
}
         * Create a new ordering strategy to sort by multiple criteria. A tie-breaker may be added to avoid  
                for (BucketOrder innerOrder : compoundOrder.orderElements) {
                    boolean asc = in.readBoolean();
         */
         *
     * @param order    bucket ordering strategy to check. If this is a {@link CompoundOrder} the first element will be  
        }
                    return COUNT_DESC;  
        }  
            if (b1 instanceof KeyComparable keyComparable) {
     *  
        static final byte ID = 0;
    /**
    /**
        public static BucketOrder parseOrderParam(XContentParser parser) throws IOException {
                Iterator<Comparator<Bucket>> itr = comparators.iterator();  
         *
    public static boolean isKeyOrder(BucketOrder order) {  
     */  
            }
        }  
        }  
        public List<BucketOrder> orderElements() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
         *
import java.io.IOException;
                    orderKey
     */  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Determine if the ordering strategy matches the expected one.
    /**
                if (order instanceof CompoundOrder) {
            return resolveOrderParam(orderKey, orderAsc);
         * @param bwcOrderFlag {@code true} to always {@code out.writeBoolean(true)} for the backwards compat logic before
                out.writeBoolean(aggregationOrder.order == SortOrder.ASC);
                } else if (token == XContentParser.Token.VALUE_STRING) {  
         * @return order read from the stream
            }  
 *  
     * Order by the key of each bucket ascending.
            return builder.startObject().field(key, order.toString()).endObject();
         * Write a {@link BucketOrder} to a {@link StreamOutput}.
     */
                    return COUNT_ASC;
    /**  
        if (order == expected) {  
                    return orderAsc ? COUNT_ASC : COUNT_DESC;
         * @param in stream with order data to read.
        public boolean equals(Object obj) {
    static final InternalOrder COUNT_DESC = new SimpleOrder(COUNT_DESC_ID, "_count", SortOrder.DESC, comparingCounts().reversed());
                do {
         * @throws IOException on error reading from the stream.  
        }  
            return true;
        public Comparator<Bucket> comparator() {  
        }
import java.util.function.ToLongFunction;  
        return false;  
     * {@link InternalOrder#COUNT_ASC}. Complex implementations should not
 * You may obtain a copy of the License at  
         *                         {@code false} otherwise.
        /**  
                throw new AggregationExecutionException("Invalid aggregation order path [" + path + "]. " + e.getMessage(), e);
     * @opensearch.internal
     */  
/**
         * @throws IOException on error writing to the stream.  
            return Objects.equals(orderElements, other.orderElements);
 * ownership. Elasticsearch licenses this file to you under  
         * Create a new ordering strategy to sort by multiple criteria.
        }  
            }  
    private static final byte COUNT_ASC_ID = 2;  
                default:  
     *
        }  
            } else if (order instanceof CompoundOrder compoundOrder) {  
     *
     * @param order bucket ordering strategy to check.
            this.comparator = comparator;
            List<Comparator<T>> comparators = orderElements.stream()
     */  
                Iterator<Comparator<T>> itr = comparators.iterator();
    /**  
                    return new Aggregation(key, asc);
     * @param expected expected  bucket ordering strategy.
        public int hashCode() {
         * @param out          stream to write the order to.  
            return (lhs, rhs) -> {
            this(compoundOrder, true);  
    public static class Streams {
        @Override  
                return false;
/*  
 * this work for additional information regarding copyright
        public static BucketOrder resolveOrderParam(String orderKey, boolean orderAsc) {
            }  
        }
         */
        public static void writeOrder(BucketOrder order, StreamOutput out) throws IOException {
    static final InternalOrder KEY_DESC = new SimpleOrder(KEY_DESC_ID, "_key", SortOrder.DESC, comparingKeys().reversed());
     * Determine if the ordering strategy is sorting on bucket key descending.  
                case KEY_ASC_ID:
import org.opensearch.core.xcontent.XContentParser;
        public <T extends Bucket> Comparator<T> partiallyBuiltBucketComparator(ToLongFunction<T> ordinalReader, Aggregator aggregator) {
    @SuppressWarnings("unchecked")
            for (BucketOrder order : orderElements) {
        }
                .collect(toList());  
        @Override
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;
     * @opensearch.internal  
     */  
            SimpleOrder other = (SimpleOrder) obj;  
    private static final byte KEY_ASC_ID = 4;
     *                 check instead.
 * Modifications Copyright OpenSearch Contributors. See  
        @Override
     * @return {@code true} if the ordering strategy is sorting on bucket count descending, {@code false} otherwise.  
                    return KEY_DESC;
         * @param compoundOrder a list of {@link BucketOrder}s to sort on, in order of priority.  
     * @return compare by {@link Bucket#getDocCount()}.
         * @param absoluteOrdering {@code true} to add a tie-breaker to avoid non-deterministic ordering if needed,
                this.orderElements.add(KEY_ASC);
                // if all user provided comparators return 0.  
    private static Comparator<Bucket> comparingKeys() {
import org.opensearch.core.common.io.stream.StreamInput;  
         */  
            return Objects.equals(id, other.id) && Objects.equals(key, other.key) && Objects.equals(order, other.order);
            }  
        }  
import static java.util.stream.Collectors.toList;
         * @param out   stream to write the order to.
 * the Apache License, Version 2.0 (the "License"); you may
        } else if (order instanceof CompoundOrder compoundOrder) {
 * software distributed under the License is distributed on an
            return Streams.readOrder(in);  
    /**
    public static boolean isCountDesc(BucketOrder order) {
                    } else {  
    static final InternalOrder KEY_ASC = new SimpleOrder(KEY_ASC_ID, "_key", SortOrder.ASC, comparingKeys());
        }
     */
        CompoundOrder(List<BucketOrder> compoundOrder) {
        }
                case COUNT_ASC_ID:
            // check if its a compound order with the first element that matches  
         * @return bucket ordering strategy
        private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Parser.class);
                case KEY_DESC_ID:  
                return result;
            String orderKey = null;
            List<Comparator<Bucket>> comparators = orderElements.stream().map(BucketOrder::comparator).collect(toList());
        @Override
 * specific language governing permissions and limitations
                }
 *  
         */  
 * under the License.  
            }
            order = asc ? SortOrder.ASC : SortOrder.DESC;
        @Override
            order.writeTo(out);  
     * use this.  
        return (b1, b2) -> {  
        }
     * @return compare by {@link Bucket#getKey()} from the appropriate implementation.
 */
import java.util.List;
    /**  
        /**
                return keyComparable.compareKey(b2);
                case Aggregation.ID:
            return Objects.hash(id, key, order);
        @Override
            this.order = order;
     */
        return isOrder(order, KEY_ASC) || isOrder(order, KEY_DESC);
    /**  
import java.util.LinkedList;  
            return builder.startObject().field(path.toString(), order.toString()).endObject();  
                    }
        }  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
     * @opensearch.internal
     */
        }  
    /**
            }
import org.opensearch.search.aggregations.support.AggregationPath;
         * ONLY FOR HISTOGRAM ORDER: Backwards compatibility logic to read a {@link BucketOrder} from a {@link StreamInput}.  
            };  
            if (order instanceof Aggregation aggregationOrder) {  
                // add key order ascending as a tie-breaker to avoid non-deterministic ordering
 * GitHub history for details.
     * @return {@code true} if the order matches, {@code false} otherwise.  
                case CompoundOrder.ID:
                case COUNT_DESC_ID:
            return ID;
                    throw new IllegalArgumentException("nested compound order not supported");  
                        compoundOrder.add(Streams.readOrder(in));  
     * {@link BucketOrder} implementation for simple, fixed orders like
                case "_count":  
            if (orderKey == null) {
            this.path = AggregationPath.parse(path);  
    private static final byte COUNT_DESC_ID = 1;
        @Override
                int result;
        /**
         *                     writing the order. {@code false} to skip this flag.
         * @return order read from the stream
        /**  
        }
     * @return {@code true} if the ordering strategy is sorting on bucket key descending, {@code false} otherwise.  
            }
            };
         */
         * Read a {@link BucketOrder} from a {@link StreamInput}.
     *
            this.orderElements = new LinkedList<>(compoundOrder);
            }  
        }
            };
    public static class Aggregation extends InternalOrder {
     *
            out.writeByte(order.id());
            }
        CompoundOrder(List<BucketOrder> compoundOrder, boolean absoluteOrdering) {
                    return KEY_ASC;  
                        throw new ParsingException(parser.getTokenLocation(), "Unknown order direction [" + dir + "]");
            }
    }
        final List<BucketOrder> orderElements;  
     * Order by the (lower) count of each bucket.
        };
     * @return {@code true} if the ordering strategy is sorting on bucket key ascending, {@code false} otherwise.
        }
            return (lhs, rhs) -> comparator.compare(lhs, rhs);  
                default: // assume all other orders are sorting on a sub-aggregation. Validation occurs later.
         * @param order        order to write to the stream.
         * Create a new ordering strategy to sort by a sub-aggregation.
            try {  
            return Collections.unmodifiableList(orderElements);
        public Comparator<Bucket> comparator() {  
        @Override
        }
     * Determine if the ordering strategy is sorting on bucket count descending.  
     */  
    }
        byte id() {
 * license agreements. See the NOTICE file distributed with
            return (lhs, rhs) -> {
            return id;  
            return comparator;
        private final String key;  
    }
import org.opensearch.search.sort.SortOrder;
 * @opensearch.internal
         * @return unmodifiable list of {@link BucketOrder}s to sort on.
     * @param order bucket ordering strategy to check.  
        return Comparator.comparingLong(Bucket::getDocCount);
                    String dir = parser.text();
         * @throws IOException on error reading from the stream.  
     *
        }  
         *
    private static final byte KEY_DESC_ID = 3;
        public int hashCode() {
            if (getClass() != obj.getClass()) {  
                case "_term":
            Comparator<Bucket> comparator = comparator();
         *                     the order. {@code false} to skip this flag (order always present).
    private static class SimpleOrder extends InternalOrder {
        private final SortOrder order;  
            return (lhs, rhs) -> {
    }  
        }
                int result;  
            if (absoluteOrdering && isKeyOrder(lastElement) == false) {
                    } else if ("desc".equalsIgnoreCase(dir)) {
                return false;
    }
     * Order by the (higher) count of each bucket.
     */
        public static BucketOrder readOrder(StreamInput in) throws IOException {
     *
         * @see AggregationPath
            boolean orderAsc = false;
                return Comparators.compareDiscardNaN(l, r, order == SortOrder.ASC);
                }
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket;  
     * Contains logic for parsing a {@link BucketOrder} from a {@link XContentParser}.
    }
            CompoundOrder other = (CompoundOrder) obj;
            return Objects.hash(path, order);
                    "aggregation_order_key",
            } catch (IllegalArgumentException e) {  
         * @param order order to write to the stream.  
import java.util.Comparator;
         * @throws IOException on error writing to the stream.
import org.opensearch.core.xcontent.XContentBuilder;  
     * Contains logic for reading/writing {@link BucketOrder} from/to streams.
    }  
        byte id() {  
 *
                out.writeString(aggregationOrder.path().toString());
        @Override
        @Override
        public Comparator<Bucket> comparator() {  
         * @param parser  for parsing {@link XContent} that contains the order.
    private static boolean isOrder(BucketOrder order, BucketOrder expected) {
     */
                return (lhs, rhs) -> bucketComparator.compare(ordinalReader.applyAsLong(lhs), ordinalReader.applyAsLong(rhs));
            this.key = key;  
                }
            if (obj == null) {  
            return Objects.equals(path, other.path) && Objects.equals(order, other.order);
        SimpleOrder(byte id, String key, SortOrder order, Comparator<Bucket> comparator) {
     * Determine if the ordering strategy is sorting on bucket key (ascending or descending).
                    innerOrder.writeTo(out);  
        public AggregationPath path() {  
            return path;
import java.util.ArrayList;
    /**  
                out.writeVInt(compoundOrder.orderElements.size());
        /**
                return result;
    /**
 * Licensed to Elasticsearch under one or more contributor  
            if ("_term".equals(orderKey) || "_time".equals(orderKey)) {  
    }
         * @param in           stream with order data to read.
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Determine if the ordering strategy is sorting on bucket key ascending.
import org.opensearch.common.logging.DeprecationLogger;  
            return builder.endArray();
import org.opensearch.core.common.ParsingException;
    }  
        public boolean equals(Object obj) {  
            throw new IllegalStateException("Unexpected order bucket class [" + b1.getClass() + "]");
                    return new CompoundOrder(compoundOrder, false);
        @Override
                    List<BucketOrder> compoundOrder = new ArrayList<>(size);
        @Override  
        return isOrder(order, COUNT_DESC);  
                double l = path.resolveValue(((InternalAggregations) lhs.getAggregations()));
import org.opensearch.common.util.Comparators;
     * @opensearch.internal
 */
    /**  
    static final InternalOrder COUNT_ASC = new SimpleOrder(COUNT_ASC_ID, "_count", SortOrder.ASC, comparingCounts());  
         *  
        }  
            BucketOrder lastElement = null;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        public boolean equals(Object obj) {  
                    String key = in.readString();  
    // TODO merge the contents of this file into BucketOrder. The way it is now is relic.
        byte id() {  
        static final byte ID = -1;
/*
                    throw new ParsingException(parser.getTokenLocation(), "Unexpected token [" + token + "] for [order]");
import java.util.Objects;
        private final byte id;
    /**
