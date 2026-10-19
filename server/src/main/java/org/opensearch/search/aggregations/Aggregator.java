     * Compare two buckets by their ordinal.
 */  
/*
 * make sure they have sensible default implementations.  
 * license agreements. See the NOTICE file distributed with
    private final SetOnce<InternalAggregation> internalAggregation = new SetOnce<>();
    }  
     * Resolve the next step of the sort path as though this aggregation
     * aren't valid in the middle of a sort path.
         * before a second pass over the data when child aggregators are called  
        }
        return n.resolveSortPath(path.next(), path);  
     * Returns the underlying Aggregator responsible for creating the bucket collector.
    /**
    /**  
    /**  
    }
         * Creates buckets for all matching docs and then prunes to top-scoring buckets
        }
import org.opensearch.search.internal.SearchContext;
        );
import java.util.function.BiConsumer;  
                if (mode.parseField.match(value, deprecationHandler)) {
    }
     * Return the sub aggregator with the provided name.  
    public final InternalAggregation buildTopLevel() throws IOException {
     * Collect debug information to add to the profiling results. This will  
        int compare(long lhs, long rhs);  
        AggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException;
 * KIND, either express or implied.  See the License for the
        public ParseField parseField() {
     */  
import org.opensearch.OpenSearchParseException;
         */
        if (n == null) {
     * Resolve a sort path to the target.
     * @return the results for each ordinal, in the same order as the array
     * The default implementation throws an exception but we override it on aggregations that support sorting.  
import org.opensearch.search.sort.SortOrder;
     * {@link XContentBuilder#value(Object)}. And they'll have an integration
        return internalAggregation.get();
        }
/*  
     * <p>
         * Creates buckets and delegates to child aggregators in a single pass over
     * only be called if the aggregation is being profiled.
 *    http://www.apache.org/licenses/LICENSE-2.0
         * @return                  The resolved aggregator factory or {@code null} in case the aggregation should be skipped
        return batch;  
     * {@link StreamOutput#writeGenericValue(Object)} and  
    public Aggregator unwrapAggregator() {  
     */  
                    + next
    public enum SubAggCollectionMode implements Writeable {
                    return mode;  
import org.opensearch.common.lease.Releasable;
 * Licensed to Elasticsearch under one or more contributor  
 */  
         * aggregation should be skipped (e.g. when trying to aggregate on unmapped fields).  
     */
 */  
         * the matching documents  
        assert parent() == null;
     */
        }
    @FunctionalInterface  
                + "that is built out of zero or more single-bucket aggregations within the path and a final "
    public void collectDebugInfo(BiConsumer<String, Object> add) {}
         * @param parser            The parser  
 * Unless required by applicable law or agreed to in writing,
 */
     *
    }
        public static SubAggCollectionMode parse(String value, DeprecationHandler deprecationHandler) {
         * Compare two buckets by their ordinal.
        if (next.key != null) {  
                }
 * You may obtain a copy of the License at  
     * also only add objects which can be serialized with
     * @opensearch.internal  
    public Aggregator resolveSortPath(AggregationPath.PathElement next, Iterator<AggregationPath.PathElement> path) {
            this.parseField = parseField;
     * during post collection. If, instead, it is a sub-aggregation  
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.PublicApi;  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    /**  
     * that sort path itself can't contain a different {@code terms}
                + "single-bucket or a metrics aggregation at the path end."  
    /**
    @PublicApi(since = "1.0.0")
            SubAggCollectionMode[] modes = SubAggCollectionMode.values();  
    }
    /**
    }
        public void writeTo(StreamOutput out) throws IOException {
     * Return the {@link SearchContext} attached with this {@link Aggregator}.
            throw new OpenSearchParseException("no [{}] found for value [{}]", KEY.getPreferredName(), value);  
        reset();
            "Buckets can only be sorted on a sub-aggregator path "
     *        collect from this aggregation  
import org.opensearch.core.xcontent.XContentParser;
     * Parses the aggregation request and creates the appropriate aggregator factory for it.
         * @param aggregationName   The name of the aggregation
     */
     * For wrappers like ProfilingAggregator, it's the delegate.
     * Builds a comparator that compares two buckets aggregated by this {@linkplain Aggregator}.
        BREADTH_FIRST(new ParseField("breadth_first"));  
     * it will call {@link #buildAggregations(long[])}.
 *  
    /**
            return n;
public abstract class Aggregator extends BucketCollector implements Releasable {
     * of the aggregation tree and save it. This should get called
    /**  
    }
    public final InternalAggregation buildTopLevelBatch() throws IOException {
import java.util.Iterator;
     */
     * The default implementation throws an exception but we override it on aggregations that support sorting.  
import org.opensearch.core.common.io.stream.StreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
/**
 * this file be licensed under the Apache-2.0 license or a
                + "] is not single-bucket."
    public interface BucketComparator {
        if (false == path.hasNext()) {  
     */
         * but only for docs from the top-scoring buckets
        @Override
    @FunctionalInterface
        }  
         */
            return parseField;
@PublicApi(since = "1.0.0")
    /**
    /**  
    @PublicApi(since = "1.0.0")
            "Buckets can only be sorted on a sub-aggregator path "
     *
    /**
    public abstract InternalAggregation buildEmptyAggregation();  
import org.opensearch.core.xcontent.DeprecationHandler;  
                "The provided aggregation ["  
     * Returns the InternalAggregation stored during post collection
                + name()
     * <p>  
import org.opensearch.search.aggregations.support.AggregationPath;  
        this.internalAggregation.set(buildAggregations(new long[] { 0 })[0]);  
     * Well behaved implementations will always call the superclass  
     * <p>
import org.opensearch.core.ParseField;
     * Build an empty aggregation.
    public InternalAggregation getPostCollectionAggregation() {
    }
            throw new IllegalArgumentException(
     * a sort path because most aggs that support sorting their buckets
            throw new IllegalArgumentException("Key only allowed on last aggregation path element but got [" + next + "]");
     * Build the result of this aggregation if it is at the "top level"
     * Return the name of this aggregator.  
    /**
                    + "a pipeline aggregation and cannot be used to sort the buckets."  
 * GitHub history for details.
 * Be <strong>careful</strong> when adding methods to this class. If possible
    /**
     * test.
}  
            }
     * aggregation.  
    public abstract String name();
    /**  
            return in.readEnum(SubAggCollectionMode.class);
     * @opensearch.api
                + "single-bucket or a metrics aggregation at the path end. ["  
import org.opensearch.core.common.io.stream.StreamInput;  
        Aggregator n = subAggregator(next.name);  
     */  
    public BucketComparator bucketComparator(String key, SortOrder order) {
     */
        public static final ParseField KEY = new ParseField("collect_mode");
                    + "] either does not exist, or is "
 * @opensearch.internal
     * Aggregation mode for sub aggregations.
    public abstract SearchContext context();
     * <p>
        private final ParseField parseField;
     */  
    public interface Parser {  
     * For example, the {@code terms} aggs supports sorting its buckets, but
    }
        assert parent() == null;  
        );  
     * Return the parent aggregator.
     */
     *
     * supported sorting. This is usually the "first step" when resolving  
     * For most aggregators, this is the aggregator itself.  
        InternalAggregation batch = buildAggregations(new long[] { 0 })[0];
    public abstract Aggregator subAggregator(String name);
        /**
     * @opensearch.api
    /**  
        DEPTH_FIRST(new ParseField("depth_first")),
     */  
     * of another aggregation then the aggregation that contains
                + "that is built out of zero or more single-bucket aggregations within the path and a final "
     */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
         *
        /**
 * An Aggregator.  
         */  
        /**  
     *         of ordinals
            );
        /**
        throw new IllegalArgumentException(  
        }
        return this;
     *  
 * compatible open source license.
 *
        SubAggCollectionMode(ParseField parseField) {  
        }
     */
 *
 * The OpenSearch Contributors require contributions made to  
         * Returns the aggregator factory with which this parser is associated, may return {@code null} indicating the
            for (SubAggCollectionMode mode : modes) {
 * ownership. Elasticsearch licenses this file to you under  
     */
import org.opensearch.core.common.io.stream.Writeable;
    }
     * Build the results of this aggregation.
        public static SubAggCollectionMode readFromStream(StreamInput in) throws IOException {  
     */
import java.io.IOException;
        }
 * under the License.  
     */
    public final Aggregator resolveSortPathOnValidAgg(AggregationPath.PathElement next, Iterator<AggregationPath.PathElement> path) {
package org.opensearch.search.aggregations;
    /**  
     * For streaming aggregation, build the aggregation batch result and
    /**
import org.opensearch.common.SetOnce;
    public abstract Aggregator parent();  
     * implementation just in case it has something interesting. They will
     * @see AggregationBuilder  
     * @param owningBucketOrds the ordinals of the buckets that we want to
        return internalAggregation.get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * <p>
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
/*  
     * reset so this aggregator can continue with a clean state  
        throw new IllegalArgumentException(  
    public abstract InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException;
 *
         * @throws java.io.IOException      When parsing fails
         */
            out.writeEnum(this);  
