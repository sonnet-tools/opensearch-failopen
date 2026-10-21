        for (int i = 0; i < elements.length; i++) {
    public String toString() {
 * path points to a metrics aggregation, if it's a single-value metrics (eg. avg, max, min, etc..) the sort will be
            }
        }
    public List<String> getPathElementsAsStringList() {
/*
        AggregationPath other = (AggregationPath) obj;
            assert path.hasNext();
 *     <li>
        return pathElements.get(pathElements.size() - 1);
        Iterator<PathElement> path = pathElements.iterator();
            this.key = key;
     */
    @Override
        String[] tuple = new String[2];
 *
                }
import org.opensearch.search.aggregations.AggregationExecutionException;
     * Resolves the {@linkplain Aggregator} pointed to by this path against
        for (PathElement pathElement : this.pathElements) {
 *     <li>
     * Looks up the value of this path against a set of aggregation results.
    public Aggregator resolveTopmostAggregator(Aggregator root) {
        return pathElements.equals(other.pathElements);
 *         {@code agg1>agg2>agg3} - where agg1 and agg2 are both single-bucket aggs and agg3 is a single-value metrics agg (eg avg, max,
                tokens.add(new PathElement(element, element, null));
    public AggregationPath(List<PathElement> tokens) {
    /**
        public String toString() {
                    throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
    private final List<PathElement> pathElements;
    public boolean equals(Object obj) {
 */
 *     </li>
    @Override
 */
 * <ul>
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
     */
            throw new IllegalArgumentException("Invalid path [" + this + "]");
        return new AggregationPath(tokens);
 *                                  min, etc..). In this case, the order will be based on the value of {@code agg3}.
        result[1] = toSplit.substring(index + 1);
                    if (index == 0 || index > element.length() - 3) {
            this.fullName = fullName;
                if (index >= 0) {
 * not use this file except in compliance with the License.
                }
                int index = element.lastIndexOf('[');
 * the Apache License, Version 2.0 (the "License"); you may
            : "this should be picked up before aggregation execution - on validate";
 * Examples:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * the given root {@linkplain Aggregator}.
            if (this == o) return true;
                if (index >= 0) {
import org.opensearch.search.aggregations.Aggregator.BucketComparator;
                    continue;
 * this file be licensed under the Apache-2.0 license or a
                tuple = split(element, index, tuple);
    public PathElement lastPathElement() {
    public BucketComparator bucketComparator(Aggregator root, SortOrder order) {
 *     </li>
        // TODO both unwrap and subAggregator are only used here!
            return fullName;
/**
        try {
        return resolveAggregator(root).bucketComparator(lastPathElement().key, order);
 *         {@code agg1>agg2>agg3.avg} - where agg1 and agg2 are both single-bucket aggs and agg3 is a multi-value metrics agg (eg stats,
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
     *
    }
    public static class PathElement {
                    }
 * KIND, either express or implied.  See the License for the
    }
    public List<PathElement> getPathElements() {
            if (pathElement.key != null) {
    public Aggregator resolveAggregator(Aggregator root) {
public class AggregationPath {
    @PublicApi(since = "1.0.0")
                int index = element.lastIndexOf('[');
        } catch (IllegalArgumentException e) {
/*
 * <p>
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
            return true;
     */
 * <p>
                    }
    public double resolveValue(InternalAggregations aggregations) {
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
 * The path has the following form:
    private static final String AGG_DELIM = ">";
                if (index == 0 || index > element.length() - 2) {
        }
                }
import org.opensearch.search.aggregations.InternalAggregations;
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
 * ownership. Elasticsearch licenses this file to you under
        List<String> stringPathElements = new ArrayList<>();
 * A path that can be used to sort/order buckets (in some multi-bucket aggregations, e.g. terms &amp; histogram) based on
        Aggregator aggregator = root.subAggregator(token.name).unwrapAggregator();
        }
    private static String[] split(String toSplit, int index, String[] result) {
            return false;
 * under the License.
     * of this path against the given root {@linkplain Aggregator}.
            stringPathElements.add(pathElement.name);
            if (key != null ? !key.equals(token.key) : token.key != null) return false;
import java.util.ArrayList;
        @Override
        return pathElements.hashCode();
    @Override
 * You may obtain a copy of the License at
 * points to a single-bucket aggregation, the sort will be applied based on the {@code doc_count} of the bucket. If this
    }
 *     <li>
 * {@code <aggregation_name>['>'<aggregation_name>*]['.'<metric_name>]}
        return root.resolveSortPathOnValidAgg(path.next(), path);
            result = 31 * result + (key != null ? key.hashCode() : 0);
                    if (element.charAt(element.length() - 1) != ']') {
 *
        return Strings.arrayToDelimitedString(pathElements.toArray(), AGG_DELIM);
 * @opensearch.internal
            return aggregations.sortValue(path.next(), path);
            int result = name.hashCode();
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
    }
 *
        @Override
        @Override
 *
        public final String name;
            Iterator<PathElement> path = pathElements.iterator();
 * this work for additional information regarding copyright
        }
    }
 *
    }
        this.pathElements = tokens;
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
 * Licensed to Elasticsearch under one or more contributor
 *                                  this case, the order will be based on the number of documents under {@code agg3}.
 * applied on that single value. If it points to a multi-value metrics, the path should point out what metric should be
    }
/*
                    if (element.charAt(element.length() - 1) != ']') {
 *         {@code agg1>agg2>agg3} - where agg1, agg2 and agg3 are all single-bucket aggs (eg filter, nested, missing, etc..). In
 * GitHub history for details.
    public static AggregationPath parse(String path) {
        List<PathElement> tokens = new ArrayList<>(elements.length);
        return aggregator;
        }
import org.opensearch.search.sort.SortOrder;
    }
    /**
 * </ul>
                tokens.add(new PathElement(element, tuple[0], tuple[1]));
            throw new IllegalArgumentException("Invalid aggregation order path [" + this + "]. " + e.getMessage(), e);
    /**
 * software distributed under the License is distributed on an
        return result;
        return stringPathElements;
        result[0] = toSplit.substring(0, index);
        }
                    continue;
    /**
                if (index < 0) {
import org.opensearch.search.aggregations.metrics.NumericMetricsAggregator;
 * SPDX-License-Identifier: Apache-2.0
    }
        return this.pathElements;
 *                                  extended_stats, etc...). In this case, the order will be based on the avg value of {@code agg3}.
                    }
                    if (index == 0 || index > element.length() - 3) {
 * Unless required by applicable law or agreed to in writing,
}
    }
        assert path.hasNext();
        if (tokens == null || tokens.size() == 0) {
    }
                    continue;
        public int hashCode() {
                stringPathElements.add(pathElement.key);
     * Resolves the {@linkplain Aggregator} pointed to by the first element
 * specific language governing permissions and limitations
            this.name = name;
        public PathElement(String fullName, String name, String key) {
                    tokens.add(new PathElement(element, element.substring(0, index), element.substring(index + 1, element.length() - 1)));
            return result;
 * the sort-by value.
 */
                index = element.lastIndexOf('.');
        }
import java.util.Iterator;
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
                    }
            if (!name.equals(token.name)) return false;
            } else {
    }
    }
 *     </li>
        assert (aggregator instanceof SingleBucketAggregator) || (aggregator instanceof NumericMetricsAggregator)
            }
import java.util.List;
     * @opensearch.api
 */
            String element = elements[i];
import org.opensearch.search.aggregations.Aggregator;
     * Element in an agg path
        private final String fullName;
    }
        String[] elements = Strings.tokenizeToStringArray(path, AGG_DELIM);
        if (obj == null || getClass() != obj.getClass()) {
        AggregationPath.PathElement token = pathElements.get(0);
            PathElement token = (PathElement) o;
    public int hashCode() {
            if (o == null || getClass() != o.getClass()) return false;
                    tokens.add(new PathElement(element, element, null));
                    tokens.add(new PathElement(element, element.substring(0, index), element.substring(index + 1, element.length() - 1)));
 * license agreements. See the NOTICE file distributed with
        }
import org.opensearch.core.common.Strings;
        public boolean equals(Object o) {
        public final String key;
            if (i == elements.length - 1) {
     */
 * sub-aggregations. The path may point to either a single-bucket aggregation or a metrics aggregation. If the path
package org.opensearch.search.aggregations.support;
        }
 *
