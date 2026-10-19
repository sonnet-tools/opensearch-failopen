 * Base class to aggregate all docs into a single numeric metric value.  
     * Single numeric metric agg value  
/*
     *  
import java.io.IOException;
            if (key != null && false == "value".equals(key)) {
        public abstract boolean hasMetric(String name);  
    }  
/*  
 *
        @Override  
                throw new IllegalArgumentException("Unknown metric name [" + key + "] on multi-value metrics aggregation [" + name() + "]");
        }
            if (key == null) {  
        super(name, context, parent, metadata);
            super(name, context, parent, metadata);
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
                        + name()  
                throw new IllegalArgumentException("When ordering on a multi-value metrics aggregation a metric name must be specified.");
    public abstract static class SingleValue extends NumericMetricsAggregator {
 * specific language governing permissions and limitations
                        + "Either drop the key (a la \""
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
            super(name, context, parent, metadata);  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
    /**
 */
     */  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
public abstract class NumericMetricsAggregator extends MetricsAggregator {
 * Unless required by applicable law or agreed to in writing,
    public abstract static class MultiValue extends NumericMetricsAggregator {  
 */
import java.util.Map;  
     * @opensearch.internal
                        + ".value\")"  
                throw new IllegalArgumentException(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.Aggregator;
 */  
     * Multi numeric metric agg value
package org.opensearch.search.aggregations.metrics;
            // TODO it'd be faster replace hasMetric and metric with something that returned a function from long to double.  
        public abstract double metric(String name, long owningBucketOrd);
import org.opensearch.search.sort.SortOrder;  
            return (lhs, rhs) -> Comparators.compareDiscardNaN(metric(lhs), metric(rhs), order == SortOrder.ASC);  
 */  
 * not use this file except in compliance with the License.
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
}
                        + name()
                    "Ordering on a single-value metrics aggregation can only be done on its value. "
            return (lhs, rhs) -> Comparators.compareDiscardNaN(metric(key, lhs), metric(key, rhs), order == SortOrder.ASC);
/**
     *
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        public abstract double metric(long owningBucketOrd);
 * @opensearch.internal
        throws IOException {
            }
        public BucketComparator bucketComparator(String key, SortOrder order) {
    /**
 *
     */
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
        @Override
            }
    }  
            }
/*
 * GitHub history for details.
        protected MultiValue(String name, SearchContext context, Aggregator parent, Map<String, Object> metadata) throws IOException {
        }
        protected SingleValue(String name, SearchContext context, Aggregator parent, Map<String, Object> metadata) throws IOException {  
import org.opensearch.search.internal.SearchContext;
            if (false == hasMetric(key)) {  
        public BucketComparator bucketComparator(String key, SortOrder order) {
import org.opensearch.common.util.Comparators;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
     * @opensearch.internal
                );
 * ownership. Elasticsearch licenses this file to you under  
        }
                        + "\") or change it to \"value\" (a la \""
    private NumericMetricsAggregator(String name, SearchContext context, Aggregator parent, Map<String, Object> metadata)  
