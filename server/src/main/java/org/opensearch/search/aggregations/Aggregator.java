                    + "a pipeline aggregation and cannot be used to sort the buckets."
     * Build the results of this aggregation.
            throw new IllegalArgumentException(
        );
    public abstract Aggregator subAggregator(String name);
     * a sort path because most aggs that support sorting their buckets
import org.opensearch.search.aggregations.support.AggregationPath;
         * @return                  The resolved aggregator factory or {@code null} in case the aggregation should be skipped
        );
    /**
            return in.readEnum(SubAggCollectionMode.class);
 * specific language governing permissions and limitations
                "The provided aggregation ["
    public abstract String name();
    }
         * @param parser            The parser
    public void collectDebugInfo(BiConsumer<String, Object> add) {}
    }
        Aggregator n = subAggregator(next.name);
import org.opensearch.common.annotation.PublicApi;
     */
     * during post collection. If, instead, it is a sub-aggregation
    public final InternalAggregation buildTopLevel() throws IOException {
        }
     * For example, the {@code terms} aggs supports sorting its buckets, but
     * also only add objects which can be serialized with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public final InternalAggregation buildTopLevelBatch() throws IOException {
 * <p>
    /**
     *        collect from this aggregation
        @Override
        }
        /**
     * Compare two buckets by their ordinal.
         * the matching documents
         * @throws java.io.IOException      When parsing fails
 * An Aggregator.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * You may obtain a copy of the License at
     * reset so this aggregator can continue with a clean state
 *
         * aggregation should be skipped (e.g. when trying to aggregate on unmapped fields).
import java.io.IOException;
        }
        public void writeTo(StreamOutput out) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    public enum SubAggCollectionMode implements Writeable {
 */
                + "that is built out of zero or more single-bucket aggregations within the path and a final "
     */
        public ParseField parseField() {
     *
 * this work for additional information regarding copyright
    public abstract SearchContext context();
     * <p>
         */
    }
        private final ParseField parseField;
     * Resolve a sort path to the target.
        }
            }
    private final SetOnce<InternalAggregation> internalAggregation = new SetOnce<>();
    }
import org.opensearch.common.lease.Releasable;
     * @opensearch.api
    /**
        assert parent() == null;
     * it will call {@link #buildAggregations(long[])}.
     */
 * SPDX-License-Identifier: Apache-2.0
     * @param owningBucketOrds the ordinals of the buckets that we want to
    public BucketComparator bucketComparator(String key, SortOrder order) {
    /**
     * {@link XContentBuilder#value(Object)}. And they'll have an integration
    /**
     * @opensearch.internal
     * <p>
                if (mode.parseField.match(value, deprecationHandler)) {
        throw new IllegalArgumentException(
     */
         */
        BREADTH_FIRST(new ParseField("breadth_first"));
public abstract class Aggregator extends BucketCollector implements Releasable {
     */
    /**
     * Return the sub aggregator with the provided name.
     * Build an empty aggregation.
import org.opensearch.core.common.io.stream.StreamOutput;
    public final Aggregator resolveSortPathOnValidAgg(AggregationPath.PathElement next, Iterator<AggregationPath.PathElement> path) {
        public static final ParseField KEY = new ParseField("collect_mode");
        DEPTH_FIRST(new ParseField("depth_first")),
    @FunctionalInterface
                + "single-bucket or a metrics aggregation at the path end. ["
     * Build the result of this aggregation if it is at the "top level"
 * software distributed under the License is distributed on an
            this.parseField = parseField;
     * of another aggregation then the aggregation that contains
     */
import org.opensearch.core.common.io.stream.StreamInput;
        }
    /**
     * For streaming aggregation, build the aggregation batch result and
     */
                    + "] either does not exist, or is "
     * aren't valid in the middle of a sort path.
     * Parses the aggregation request and creates the appropriate aggregator factory for it.
 * GitHub history for details.
@PublicApi(since = "1.0.0")
         * @param aggregationName   The name of the aggregation
    /**
    /**
     */
     * The default implementation throws an exception but we override it on aggregations that support sorting.
                + "that is built out of zero or more single-bucket aggregations within the path and a final "
     */
     * The default implementation throws an exception but we override it on aggregations that support sorting.
     */
     * aggregation.
     * Return the name of this aggregator.
     * Returns the InternalAggregation stored during post collection
    /**
    @PublicApi(since = "1.0.0")
     * Builds a comparator that compares two buckets aggregated by this {@linkplain Aggregator}.
import org.opensearch.OpenSearchParseException;
     * For most aggregators, this is the aggregator itself.
            "Buckets can only be sorted on a sub-aggregator path "
 * license agreements. See the NOTICE file distributed with
         * Creates buckets and delegates to child aggregators in a single pass over
 * Modifications Copyright OpenSearch Contributors. See
        if (false == path.hasNext()) {
    /**
import org.opensearch.core.xcontent.DeprecationHandler;
 * @opensearch.internal
                }
     */
    /**
    @PublicApi(since = "1.0.0")
import org.opensearch.search.sort.SortOrder;
            for (SubAggCollectionMode mode : modes) {
     * Aggregation mode for sub aggregations.
     * Return the parent aggregator.
                    + next
            out.writeEnum(this);
 * Licensed to Elasticsearch under one or more contributor
    /**
                + "single-bucket or a metrics aggregation at the path end."
         */
     * implementation just in case it has something interesting. They will
 */
            );
                + "] is not single-bucket."
        if (next.key != null) {
    }
     * of the aggregation tree and save it. This should get called
    /**
     * @return the results for each ordinal, in the same order as the array
 *
        if (n == null) {
        reset();
     * that sort path itself can't contain a different {@code terms}
     */
    }
    public Aggregator unwrapAggregator() {
        return this;
import org.opensearch.core.xcontent.XContentBuilder;
     * @opensearch.api
        throw new IllegalArgumentException(
     * Return the {@link SearchContext} attached with this {@link Aggregator}.
import java.util.Iterator;
 * under the License.
    public InternalAggregation getPostCollectionAggregation() {
     *         of ordinals
         */
            return n;
     */
 * ownership. Elasticsearch licenses this file to you under
    public abstract InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException;
 * make sure they have sensible default implementations.
}
        /**
        InternalAggregation batch = buildAggregations(new long[] { 0 })[0];
            throw new OpenSearchParseException("no [{}] found for value [{}]", KEY.getPreferredName(), value);
import org.opensearch.core.xcontent.XContentParser;
     * only be called if the aggregation is being profiled.
     * <p>
     * @see AggregationBuilder
            return parseField;
     * Returns the underlying Aggregator responsible for creating the bucket collector.
     */
 * this file be licensed under the Apache-2.0 license or a
     * <p>
     */
    /**
        this.internalAggregation.set(buildAggregations(new long[] { 0 })[0]);
         * Returns the aggregator factory with which this parser is associated, may return {@code null} indicating the
         * before a second pass over the data when child aggregators are called
import java.util.function.BiConsumer;
        int compare(long lhs, long rhs);
     *
     * supported sorting. This is usually the "first step" when resolving
     * test.
     */
        }
/*
        return batch;
 * not use this file except in compliance with the License.
     */
    /**
     * Collect debug information to add to the profiling results. This will
 * compatible open source license.
            SubAggCollectionMode[] modes = SubAggCollectionMode.values();
        public static SubAggCollectionMode parse(String value, DeprecationHandler deprecationHandler) {
     * Well behaved implementations will always call the superclass
import org.opensearch.core.ParseField;
     * {@link StreamOutput#writeGenericValue(Object)} and
        /**
 * The OpenSearch Contributors require contributions made to
 *
/*
import org.opensearch.common.SetOnce;
    public interface BucketComparator {
         * Compare two buckets by their ordinal.
    }
 * Be <strong>careful</strong> when adding methods to this class. If possible
    public interface Parser {
/**
import org.opensearch.core.common.io.stream.Writeable;
    public Aggregator resolveSortPath(AggregationPath.PathElement next, Iterator<AggregationPath.PathElement> path) {
package org.opensearch.search.aggregations;
        return n.resolveSortPath(path.next(), path);
     * Resolve the next step of the sort path as though this aggregation
         * Creates buckets for all matching docs and then prunes to top-scoring buckets
    public abstract InternalAggregation buildEmptyAggregation();
 *
        AggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException;
         * but only for docs from the top-scoring buckets
     *
    }
        }
        assert parent() == null;
                + name()
    }
            throw new IllegalArgumentException("Key only allowed on last aggregation path element but got [" + next + "]");
     * For wrappers like ProfilingAggregator, it's the delegate.
        }
import org.opensearch.search.internal.SearchContext;
        SubAggCollectionMode(ParseField parseField) {
         *
        return internalAggregation.get();
/*
 */
        public static SubAggCollectionMode readFromStream(StreamInput in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        /**
        return internalAggregation.get();
    /**
            "Buckets can only be sorted on a sub-aggregator path "
    }
 * KIND, either express or implied.  See the License for the
                    return mode;
     *
    @FunctionalInterface
    public abstract Aggregator parent();
