 *     <li>
        return new AggregationPath(tokens);
 *     <li>  
 * sub-aggregations. The path may point to either a single-bucket aggregation or a metrics aggregation. If the path
        Aggregator aggregator = root.subAggregator(token.name).unwrapAggregator();  
/*  
 * The path has the following form:
            return false;
        return resolveAggregator(root).bucketComparator(lastPathElement().key, order);
        try {
                    continue;  
 */
import org.opensearch.search.aggregations.Aggregator;
                }
        assert (aggregator instanceof SingleBucketAggregator) || (aggregator instanceof NumericMetricsAggregator)
        result[1] = toSplit.substring(index + 1);  
                    if (index == 0 || index > element.length() - 3) {
 *         {@code agg1>agg2>agg3} - where agg1, agg2 and agg3 are all single-bucket aggs (eg filter, nested, missing, etc..). In  
/**  
    public Aggregator resolveTopmostAggregator(Aggregator root) {  
import org.opensearch.common.annotation.PublicApi;
        return stringPathElements;  
            this.key = key;
    }
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
     * Resolves the {@linkplain Aggregator} pointed to by this path against
                stringPathElements.add(pathElement.key);  
    public PathElement lastPathElement() {
            }
    /**
 *         {@code agg1>agg2>agg3} - where agg1 and agg2 are both single-bucket aggs and agg3 is a single-value metrics agg (eg avg, max,
    }
        Iterator<PathElement> path = pathElements.iterator();  
 * <ul>
    public List<PathElement> getPathElements() {  
    }
     * Element in an agg path
    public String toString() {
            throw new IllegalArgumentException("Invalid aggregation order path [" + this + "]. " + e.getMessage(), e);  
                if (index >= 0) {  
        for (PathElement pathElement : this.pathElements) {  
            throw new IllegalArgumentException("Invalid path [" + this + "]");
                int index = element.lastIndexOf('[');
     * the given root {@linkplain Aggregator}.  
        return result;
            return aggregations.sortValue(path.next(), path);
                }  
    public List<String> getPathElementsAsStringList() {
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
 * points to a single-bucket aggregation, the sort will be applied based on the {@code doc_count} of the bucket. If this  
 * SPDX-License-Identifier: Apache-2.0
 *
 *     </li>
     */
        List<PathElement> tokens = new ArrayList<>(elements.length);
 * ownership. Elasticsearch licenses this file to you under  
 * applied on that single value. If it points to a multi-value metrics, the path should point out what metric should be
 *
        }
                if (index < 0) {  
        private final String fullName;  
        public String toString() {
import org.opensearch.search.aggregations.Aggregator.BucketComparator;
            return result;  
 *                                  extended_stats, etc...). In this case, the order will be based on the avg value of {@code agg3}.  
    private static final String AGG_DELIM = ">";  
 *     </li>
                    }
     * Resolves the {@linkplain Aggregator} pointed to by the first element  
            if (!name.equals(token.name)) return false;  
 *     <li>
            PathElement token = (PathElement) o;  
                    continue;
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");  
        return root.resolveSortPathOnValidAgg(path.next(), path);
                index = element.lastIndexOf('.');
 * path points to a metrics aggregation, if it's a single-value metrics (eg. avg, max, min, etc..) the sort will be
            this.fullName = fullName;
 * the sort-by value.  
 */  
 *                                  this case, the order will be based on the number of documents under {@code agg3}.
    }  
     */
 * Modifications Copyright OpenSearch Contributors. See
        // TODO both unwrap and subAggregator are only used here!
        return this.pathElements;
                    if (index == 0 || index > element.length() - 3) {
 * </ul>
    }
    @Override  
        return aggregator;  
        return pathElements.equals(other.pathElements);
import org.opensearch.core.common.Strings;
        @Override
        public final String name;
import org.opensearch.search.aggregations.metrics.NumericMetricsAggregator;
    @Override
 *     </li>  
 * <p>
        List<String> stringPathElements = new ArrayList<>();
            return fullName;
            int result = name.hashCode();
                }  
 *  
    /**
    }
                    }  
 *  
    }
    public boolean equals(Object obj) {
        }  
    }  
            } else {
     */
 *  
 *
import org.opensearch.search.aggregations.InternalAggregations;  
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
 * this work for additional information regarding copyright
                    if (element.charAt(element.length() - 1) != ']') {
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        }  
    public BucketComparator bucketComparator(Aggregator root, SortOrder order) {  
            : "this should be picked up before aggregation execution - on validate";
 * this file be licensed under the Apache-2.0 license or a
                tokens.add(new PathElement(element, element, null));
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
            if (key != null ? !key.equals(token.key) : token.key != null) return false;
        }
    public double resolveValue(InternalAggregations aggregations) {  
            if (this == o) return true;  
        assert path.hasNext();
    }
 * Examples:
                    if (element.charAt(element.length() - 1) != ']') {
                    tokens.add(new PathElement(element, element.substring(0, index), element.substring(index + 1, element.length() - 1)));
 * {@code <aggregation_name>['>'<aggregation_name>*]['.'<metric_name>]}  
import java.util.ArrayList;
        return pathElements.get(pathElements.size() - 1);  
     * of this path against the given root {@linkplain Aggregator}.
 */  
                int index = element.lastIndexOf('[');  
    private static String[] split(String toSplit, int index, String[] result) {
import java.util.Iterator;  
        if (tokens == null || tokens.size() == 0) {
/*  
 * A path that can be used to sort/order buckets (in some multi-bucket aggregations, e.g. terms &amp; histogram) based on
    public static AggregationPath parse(String path) {
                if (index >= 0) {
        this.pathElements = tokens;  
        }  
    public AggregationPath(List<PathElement> tokens) {
public class AggregationPath {
package org.opensearch.search.aggregations.support;
            assert path.hasNext();  
 * Unless required by applicable law or agreed to in writing,
        String[] tuple = new String[2];
        public final String key;
            if (pathElement.key != null) {
        result[0] = toSplit.substring(0, index);
            }
    @Override
    public int hashCode() {
        @Override  
        public int hashCode() {  
        String[] elements = Strings.tokenizeToStringArray(path, AGG_DELIM);  
     * @opensearch.api
 * under the License.  
            Iterator<PathElement> path = pathElements.iterator();
    }
    @PublicApi(since = "1.0.0")  
                    throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");
                }  
 * KIND, either express or implied.  See the License for the
                    }
                tokens.add(new PathElement(element, tuple[0], tuple[1]));
        return pathElements.hashCode();  
                tuple = split(element, index, tuple);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
     * Looks up the value of this path against a set of aggregation results.
/*
    }
        public boolean equals(Object o) {
            stringPathElements.add(pathElement.name);
                    tokens.add(new PathElement(element, element, null));
     *  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
import org.opensearch.search.sort.SortOrder;  
    public static class PathElement {
    /**  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final List<PathElement> pathElements;  
                    }  
                    tokens.add(new PathElement(element, element.substring(0, index), element.substring(index + 1, element.length() - 1)));
import org.opensearch.search.aggregations.AggregationExecutionException;  
     */
        for (int i = 0; i < elements.length; i++) {  
 * specific language governing permissions and limitations
                    continue;
 * <p>
        }  
        AggregationPath.PathElement token = pathElements.get(0);
            String element = elements[i];
 *         {@code agg1>agg2>agg3.avg} - where agg1 and agg2 are both single-bucket aggs and agg3 is a multi-value metrics agg (eg stats,
        }
 * The OpenSearch Contributors require contributions made to  
        return Strings.arrayToDelimitedString(pathElements.toArray(), AGG_DELIM);
            return true;
                        throw new AggregationExecutionException("Invalid path element [" + element + "] in path [" + path + "]");  
    }
    /**
        @Override
        public PathElement(String fullName, String name, String key) {
 *                                  min, etc..). In this case, the order will be based on the value of {@code agg3}.
 * not use this file except in compliance with the License.
import java.util.List;
        }
                if (index == 0 || index > element.length() - 2) {
    }
 * software distributed under the License is distributed on an
        } catch (IllegalArgumentException e) {
        if (obj == null || getClass() != obj.getClass()) {  
        }
            if (i == elements.length - 1) {
    public Aggregator resolveAggregator(Aggregator root) {
}
 */  
            this.name = name;  
        AggregationPath other = (AggregationPath) obj;  
            if (o == null || getClass() != o.getClass()) return false;
            result = 31 * result + (key != null ? key.hashCode() : 0);
