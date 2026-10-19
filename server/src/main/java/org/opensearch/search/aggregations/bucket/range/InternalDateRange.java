        super(name, ranges, formatter, keyed, metadata);
 * @opensearch.internal  
            Map<String, Object> metadata
        public Bucket createBucket(
    /**  
 * You may obtain a copy of the License at  
/*  
        protected InternalRange.Factory<Bucket, ?> getFactory() {
                ? null
            double to,  
        public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {  
            boolean keyed,  
        }
        }
        ) {
            return ValueType.DATE;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.aggregations.bucket.range;
    /**
/*
/*
            boolean keyed,
        @Override
            double from,
        public Object getTo() {
    InternalDateRange(
 * software distributed under the License is distributed on an
                prototype.getKeyed(),
        public InternalDateRange create(List<Bucket> ranges, InternalDateRange prototype) {
        public InternalDateRange create(  
            String name,
            InternalAggregations aggregations,
        @Override
        }
            InternalAggregations aggregations,
 *
        DocValueFormat formatter,
        @Override  
            return keyed;
    public String getWriteableName() {
    }  
            return to;
        }  
 * Unless required by applicable law or agreed to in writing,
import java.time.ZoneOffset;
 */
 * Implementation of date range bucket
        return DateRangeAggregationBuilder.NAME;
        ) {
            return Double.isInfinite(((Number) to).doubleValue())  
                ? null  
            boolean keyed,  
 * under the License.  
                : Instant.ofEpochMilli(((Number) from).longValue()).atZone(ZoneOffset.UTC);
    public static class Bucket extends InternalRange.Bucket {
 *    http://www.apache.org/licenses/LICENSE-2.0
            DocValueFormat formatter
        private Double internalGetTo() {  
            List<InternalDateRange.Bucket> ranges,
            double to,  
import org.opensearch.search.aggregations.support.ValueType;
        @Override
            String key,
     */
        boolean keyed,
            return FACTORY;  
     */
        List<InternalDateRange.Bucket> ranges,  
            DocValueFormat formatter  
import java.time.Instant;
}  
     *
 * compatible open source license.
            super(key, from, to, docCount, aggregations, keyed, formatter);  
            return Double.isInfinite(((Number) from).doubleValue())
     */  
        }  
            return new InternalDateRange(name, ranges, formatter, keyed, metadata);
 * KIND, either express or implied.  See the License for the
        }  
            String key,
 * The OpenSearch Contributors require contributions made to  
            double from,
 * specific language governing permissions and limitations
            DocValueFormat formatter
import java.util.List;  
        @Override
            double from,
    ) {
    public InternalRange.Factory<Bucket, InternalDateRange> getFactory() {  
        @Override  
    }  
        }
            long docCount,  
     * Bucket for a date range  
 * SPDX-License-Identifier: Apache-2.0
        public Object getFrom() {
        Map<String, Object> metadata  
                prototype.internalGetTo(),
            return from;  
        }
import org.opensearch.search.aggregations.InternalAggregations;  
 */
        public Bucket(  
        @Override
                prototype.getDocCount(),
        ) {  
 * license agreements. See the NOTICE file distributed with
            DocValueFormat formatter,  
 *  
     * @opensearch.internal  
        boolean keyed() {  
            String key,  
    public InternalDateRange(StreamInput in) throws IOException {
        }
 * this file be licensed under the Apache-2.0 license or a
    @Override
            long docCount,
import org.opensearch.search.DocValueFormat;
public class InternalDateRange extends InternalRange<InternalDateRange.Bucket, InternalDateRange> {
    /**
    }
        private Double internalGetFrom() {
            return format;
        }
 * not use this file except in compliance with the License.
import java.util.Map;
                prototype.getKey(),
 */  
 * ownership. Elasticsearch licenses this file to you under  
        public Bucket(  
            );  
        }  
                aggregations,  
 * this work for additional information regarding copyright
            boolean keyed,
            super(key, from, to, docCount, InternalAggregations.from(aggregations), keyed, formatter);  
 *
        ) {
            double to,
 */
        String name,
        public ValueType getValueType() {
        }
 * GitHub history for details.
/**  
     * Read from a stream.  
                prototype.internalGetFrom(),  
     *
            return new InternalDateRange(prototype.name, ranges, prototype.format, prototype.keyed, prototype.metadata);  
import org.opensearch.search.aggregations.InternalAggregation;
import java.io.IOException;  
        }
    }
                : Instant.ofEpochMilli(((Number) to).longValue()).atZone(ZoneOffset.UTC);
 * Modifications Copyright OpenSearch Contributors. See  
        }
    }
        super(in);  
            long docCount,
 * Licensed to Elasticsearch under one or more contributor  
            return new Bucket(
     * Factory to create a date range
    }
 *
    @Override  
                prototype.getFormat()
    public static final Factory FACTORY = new Factory();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamInput;  
        @Override
            List<InternalAggregation> aggregations,
        DocValueFormat format() {
        return FACTORY;
    public static class Factory extends InternalRange.Factory<InternalDateRange.Bucket, InternalDateRange> {
            return new Bucket(key, from, to, docCount, aggregations, keyed, formatter);
     * @opensearch.internal
