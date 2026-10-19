 */
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    List<? extends Bucket> getBuckets();
 *
 * precision.  
}
 * this work for additional information regarding copyright
/*
 * KIND, either express or implied.  See the License for the
/*  
     */
     * @return The buckets of this aggregation (each bucket representing a geo-grid cell)
    /**  
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 */
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
 *
 * GitHub history for details.
 * under the License.  
 *  
/*
 *
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 */  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     * A bucket that is associated with a geo-grid cell. The key of the bucket is
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
public interface GeoGrid extends MultiBucketsAggregation {
     * the {@link BaseGeoGridBucket#getKeyAsString()} of the cell
 * The OpenSearch Contributors require contributions made to  
/**
 * license agreements. See the NOTICE file distributed with
 * A geo-grid aggregation. Defines multiple buckets, each representing a cell in a geo-grid of a specific
     */  
    interface Bucket extends MultiBucketsAggregation.Bucket {}
 * specific language governing permissions and limitations
 * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
