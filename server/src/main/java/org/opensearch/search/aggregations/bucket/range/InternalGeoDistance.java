     *  
        public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
     * @opensearch.internal
        }  
            boolean keyed,
            DocValueFormat format
        return GeoDistanceAggregationBuilder.NAME;
            boolean keyed,
 * under the License.  
            );
        }  
 */
        }
        super(name, ranges, DocValueFormat.RAW, keyed, metadata);  
            return ValueType.GEOPOINT;
     */
     */
            return new InternalGeoDistance(name, ranges, keyed, metadata);
        ) {  
import org.opensearch.search.aggregations.support.ValueType;
        return FACTORY;  
                ((Number) prototype.getTo()).doubleValue(),  
        boolean keyed() {
import org.opensearch.search.DocValueFormat;
    public static final Factory FACTORY = new Factory();
     */
    }  
/**
 * SPDX-License-Identifier: Apache-2.0
    public InternalGeoDistance(StreamInput in) throws IOException {  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            return new Bucket(  
            Map<String, Object> metadata
 * compatible open source license.
 */  
     * Read from a stream.
        public InternalGeoDistance create(  
            List<Bucket> ranges,
            return new InternalGeoDistance(prototype.name, ranges, prototype.keyed, prototype.metadata);  
    @Override
import java.util.Map;  
package org.opensearch.search.aggregations.bucket.range;
    /**  
        public InternalGeoDistance create(List<Bucket> ranges, InternalGeoDistance prototype) {
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override  
     * @opensearch.internal
                prototype.getKey(),
            super(key, from, to, docCount, aggregations, keyed, DocValueFormat.RAW);  
 * ownership. Elasticsearch licenses this file to you under  
 */
        public Bucket createBucket(
/*  
        @Override  
 * license agreements. See the NOTICE file distributed with
        }
public class InternalGeoDistance extends InternalRange<InternalGeoDistance.Bucket, InternalGeoDistance> {
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        @Override
}
        @Override
 * specific language governing permissions and limitations
            return keyed;  
        }
        public ValuesSourceType getValueSourceType() {
    /**
            DocValueFormat format,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        @Override
 * Modifications Copyright OpenSearch Contributors. See  
        protected InternalRange.Factory<Bucket, ?> getFactory() {
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.core.common.io.stream.StreamInput;  
        }
/*
 * Licensed to Elasticsearch under one or more contributor  
     * Bucket for a geo distance range
import java.io.IOException;
    }  
     *  
 * this work for additional information regarding copyright
            String name,
 *
        super(in);
/*
    public String getWriteableName() {
    }
            double to,
        }
    /**
import java.util.List;
                aggregations,
        ) {  
 * software distributed under the License is distributed on an
            String key,
    public InternalGeoDistance(String name, List<Bucket> ranges, boolean keyed, Map<String, Object> metadata) {
            double from,  
import org.opensearch.search.aggregations.support.ValuesSourceType;
        public ValueType getValueType() {
            return CoreValuesSourceType.GEOPOINT;  
            long docCount,
     * Factory for a geo distance bucket
 * You may obtain a copy of the License at  
        @Override
            InternalAggregations aggregations,  
 * Implementation of geo_distance bucket  
                prototype.getKeyed()  
    public static class Factory extends InternalRange.Factory<InternalGeoDistance.Bucket, InternalGeoDistance> {  
 * KIND, either express or implied.  See the License for the
        }
 */  
 *
 *  
        @Override  
    }
        @Override  
    static class Bucket extends InternalRange.Bucket {  
        Bucket(String key, double from, double to, long docCount, InternalAggregations aggregations, boolean keyed) {
                prototype.getDocCount(),
            return FACTORY;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
    public InternalRange.Factory<Bucket, InternalGeoDistance> getFactory() {
            return new Bucket(key, from, to, docCount, aggregations, keyed);
 * Unless required by applicable law or agreed to in writing,
                ((Number) prototype.getFrom()).doubleValue(),
        }
import org.opensearch.search.aggregations.InternalAggregations;
