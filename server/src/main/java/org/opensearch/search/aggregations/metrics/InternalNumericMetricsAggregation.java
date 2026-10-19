        }  
    public boolean equals(Object obj) {
 * You may obtain a copy of the License at  
     */
         */
import java.util.Objects;  
        if (this == obj) return true;  
    protected InternalNumericMetricsAggregation(StreamInput in) throws IOException {  
            super(name, metadata);
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
                        + key  
                return this;
        super(name, metadata);  
     * Multe numeric metric values
package org.opensearch.search.aggregations.metrics;
 * The OpenSearch Contributors require contributions made to  
        }  
 */  
     *  
 * KIND, either express or implied.  See the License for the
 *  
     * @opensearch.internal
/*  
import org.opensearch.search.DocValueFormat;
        }
        public abstract double value(String name);  
     * Read from a stream.
    public final double sortValue(AggregationPath.PathElement head, Iterator<AggregationPath.PathElement> tail) {
import java.util.List;
 */
 * compatible open source license.
    @Override
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;  
            return value();  
 *
                        + "] for single-value metric aggregation ["
    @Override  
 * Base aggregation to aggregate all docs into a single numeric metric  
        }
    /**  
            } else {  
        if (obj == null || getClass() != obj.getClass()) return false;
    public abstract static class MultiValue extends InternalNumericMetricsAggregation implements NumericMetricsAggregation.MultiValue {  
 * this file be licensed under the Apache-2.0 license or a
        /**
            return format.format(value(name)).toString();  
     * A single numeric metric value
 *
                return value();
            }
            return value(key);
 * under the License.  
    }
            super(in);  
        @Override  
        public Object getProperty(List<String> path) {  
                return value(path.get(0));
    private InternalNumericMetricsAggregation(String name, Map<String, Object> metadata) {
    }
import java.util.Map;
                throw new IllegalArgumentException("Missing value key in [" + key + "] which refers to a multi-value metric aggregation");
import org.opensearch.search.aggregations.support.AggregationPath;  
     */
import org.opensearch.search.aggregations.InternalAggregation;
        protected SingleValue(String name, Map<String, Object> metadata) {
        super(in);
}
            if (key != null && false == key.equals("value")) {  
     * @opensearch.internal
        protected MultiValue(String name, Map<String, Object> metadata) {
     * @return the DocValueFormat
        public Object getProperty(List<String> path) {
    @Override
        @Override
 * not use this file except in compliance with the License.
        }  
 * specific language governing permissions and limitations
            super(in);  
    /**
 * software distributed under the License is distributed on an
        public String valueAsString(String name) {
import java.util.Iterator;  
    public int hashCode() {  
 * GitHub history for details.
        @Override
 * Unless required by applicable law or agreed to in writing,
        /**
            } else {
        InternalNumericMetricsAggregation other = (InternalNumericMetricsAggregation) obj;
        }  
                        + getName()
 */
            }
     *  
     *  
        protected SingleValue(StreamInput in) throws IOException {
    private static final DocValueFormat DEFAULT_FORMAT = DocValueFormat.RAW;  
/*
 * Licensed to Elasticsearch under one or more contributor  
        }
 *
                throw new IllegalArgumentException(
            } else if (path.size() == 1 && "value".equals(path.get(0))) {  
    public DocValueFormat getFormat() {  
        return Objects.equals(format, other.format);
 * @opensearch.internal
        return false;
            if (path.isEmpty()) {
        public final double sortValue(String key) {
    }  
        public final double sortValue(String key) {  
                );
         * Read from a stream.  
        public String getValueAsString() {
            if (path.isEmpty()) {
            } else if (path.size() == 1) {
    }
    protected boolean mustReduceOnSingleInternalAgg() {
        }
/**
    }  
     * Returns the format used for this aggregation.
    }  
        protected MultiValue(StreamInput in) throws IOException {
        if (super.equals(obj) == false) return false;
                throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
/*
            if (key == null) {
         * Read from a stream.  
        }
        }
 * Modifications Copyright OpenSearch Contributors. See  
                throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
                        + "]. Either use [value] as key or drop the key all together"  
     */
 */  
        throw new IllegalArgumentException("Metrics aggregations cannot have sub-aggregations (at [>" + head + "]");  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
                return this;  
public abstract class InternalNumericMetricsAggregation extends InternalAggregation {
                    "Unknown value key ["
    }
        return Objects.hash(super.hashCode(), format);
    @Override
        return format;
    protected DocValueFormat format = DEFAULT_FORMAT;
            }  
import java.io.IOException;
    }
     */
        @Override
            }
            super(name, metadata);
         */
    public abstract static class SingleValue extends InternalNumericMetricsAggregation implements NumericMetricsAggregation.SingleValue {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    }
            return format.format(value()).toString();
