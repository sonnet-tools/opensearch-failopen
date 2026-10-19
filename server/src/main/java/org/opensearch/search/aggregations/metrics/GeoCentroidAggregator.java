            counts = bigArrays.newLongArray(1, true);  
        String name,  
 */  
                        compensatedSumLon.add(value.getLon());
        return new InternalGeoCentroid(name, bucketCentroid, bucketCount, metadata());  
                    double compensationLon = lonCompensations.get(bucket);
 *  
import org.opensearch.common.lease.Releasables;  
        ValuesSourceConfig valuesSourceConfig,
    public InternalAggregation buildAggregation(long bucket) {
                    lonSum.set(bucket, compensatedSumLon.value());  
import org.opensearch.index.fielddata.MultiGeoPointValues;
 *  
    }
    private final ValuesSource.GeoPoint valuesSource;
        Releasables.close(latSum, latCompensations, lonSum, lonCompensations, counts);
import org.opensearch.common.geo.GeoPoint;
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        return new LeafBucketCollectorBase(sub, values) {
        SearchContext context,
 * A geo metric aggregator that computes a geo-centroid from a {@code geo_point} type field
    }
            }
                    double sumLat = latSum.get(bucket);
        if (valuesSource == null) {  
        final CompensatedSum compensatedSumLat = new CompensatedSum(0, 0);
        };  
 * KIND, either express or implied.  See the License for the
                    final int valueCount = values.docValueCount();  
import java.io.IOException;
    }  
            public void collect(int doc, long bucket) throws IOException {
                    latSum.set(bucket, compensatedSumLat.value());
        final GeoPoint bucketCentroid = (bucketCount > 0)  
    public void doClose() {  
import org.opensearch.search.internal.SearchContext;
        final BigArrays bigArrays = context.bigArrays();  
            latSum = bigArrays.newDoubleArray(1, true);
            ? new GeoPoint(latSum.get(bucket) / bucketCount, lonSum.get(bucket) / bucketCount)
        final MultiGeoPointValues values = valuesSource.geoPointValues(ctx);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
/**
 * Licensed to Elasticsearch under one or more contributor  
    private LongArray counts;  
    public InternalAggregation buildEmptyAggregation() {
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.GeoPoint) valuesSourceConfig.getValuesSource() : null;
 */
            @Override  
        if (valuesSource != null) {  
                    // increment by the number of points for this document
            return LeafBucketCollector.NO_OP_COLLECTOR;
                    double sumLon = lonSum.get(bucket);
 * this file be licensed under the Apache-2.0 license or a
 *
 * Modifications Copyright OpenSearch Contributors. See
                        compensatedSumLat.add(value.getLat());
 * GitHub history for details.
    @Override  
 */
    GeoCentroidAggregator(
/*  
                    compensatedSumLat.reset(sumLat, compensationLat);
                    double compensationLat = latCompensations.get(bucket);  
    @Override
 */  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            latCompensations = bigArrays.newDoubleArray(1, true);
                    // Compute the sum of double values with Kahan summation algorithm which is more  
        }
                }
 * @opensearch.internal
                latSum = bigArrays.grow(latSum, bucket + 1);
                        // latitude
package org.opensearch.search.aggregations.metrics;
        }
import java.util.Map;
                        GeoPoint value = values.nextValue();  
import org.opensearch.search.aggregations.support.ValuesSource;  
 * under the License.  
                    // accurate than naive summation.
        super(name, context, parent, metadata);  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.LeafBucketCollector;
 * You may obtain a copy of the License at  
 *
                    counts.increment(bucket, valueCount);
import org.apache.lucene.index.LeafReaderContext;
final class GeoCentroidAggregator extends MetricsAggregator {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.DoubleArray;
        // TODO: Stop expecting nulls here
 * software distributed under the License is distributed on an
 * compatible open source license.
                    }
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    private DoubleArray lonSum, lonCompensations, latSum, latCompensations;
}  
            final BigArrays bigArrays = context.bigArrays();
                    latCompensations.set(bucket, compensatedSumLat.delta());  
            lonSum = bigArrays.newDoubleArray(1, true);
import org.opensearch.search.aggregations.InternalAggregation;  
                    compensatedSumLon.reset(sumLon, compensationLon);
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                if (values.advanceExact(doc)) {
            : null;
                        // longitude  
        }
import org.opensearch.common.util.LongArray;  
        Map<String, Object> metadata
    @Override  
        Aggregator parent,  
        if (valuesSource == null || bucket >= counts.size()) {
    @Override
            lonCompensations = bigArrays.newDoubleArray(1, true);  
        final long bucketCount = counts.get(bucket);
        return new InternalGeoCentroid(name, null, 0L, metadata());
                latCompensations = bigArrays.grow(latCompensations, bucket + 1);
                    // update the sum
        final CompensatedSum compensatedSumLon = new CompensatedSum(0, 0);  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.Aggregator;
                lonCompensations = bigArrays.grow(lonCompensations, bucket + 1);
/*
    }
    ) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
                lonSum = bigArrays.grow(lonSum, bucket + 1);  
            return buildEmptyAggregation();  
                counts = bigArrays.grow(counts, bucket + 1);  
 * The OpenSearch Contributors require contributions made to  
                    lonCompensations.set(bucket, compensatedSumLon.delta());
                    for (int i = 0; i < valueCount; ++i) {
import org.opensearch.common.util.BigArrays;
