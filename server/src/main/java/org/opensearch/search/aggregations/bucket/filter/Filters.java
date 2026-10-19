 *    http://www.apache.org/licenses/LICENSE-2.0
public interface Filters extends MultiBucketsAggregation {
    /**  
     */
    Bucket getBucketByKey(String key);  
 */
/*  
    @Override  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;  
 * Modifications Copyright OpenSearch Contributors. See
 * will collect all documents matching its filter.
     * A bucket associated with a specific filter (identified by its key)
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    /**
}
 */  
 *
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    interface Bucket extends MultiBucketsAggregation.Bucket {}
 *  
 *
 * not use this file except in compliance with the License.
/*  
 *
 * under the License.  
/*
 * The OpenSearch Contributors require contributions made to  
     */  
 * You may obtain a copy of the License at  
package org.opensearch.search.aggregations.bucket.filter;
 * this work for additional information regarding copyright
 */
     * The buckets created by this aggregation.
/**
 * compatible open source license.
    List<? extends Bucket> getBuckets();
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * A multi bucket aggregation where the buckets are defined by a set of filters (a bucket per filter). Each bucket  
