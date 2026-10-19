 *
 * KIND, either express or implied.  See the License for the
    /** Create a {@link MultiBucketsAggregation.Bucket} object that wraps the  
 *  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
}
// public so that pipeline aggs can use this API: can we fix it?  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
 * GitHub history for details.
/*
 */  
 * under the License.  
     *  greater than it. */  
    /** Get the key for the given bucket. Date histograms must return the  
    /** Create an {@link InternalAggregation} object that wraps the given buckets. */  
     *  number of millis since Epoch of the bucket key while numeric histograms
    /** Given a key returned by {@link #getKey}, compute the lowest key that is
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
     *  must return the double value of the key. */
 * SPDX-License-Identifier: Apache-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
 */
     *  given key, document count and aggregations. */
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    Number getKey(MultiBucketsAggregation.Bucket bucket);  
 * Implemented by histogram aggregations and used by pipeline aggregations to insert buckets.
 * @opensearch.internal
 * You may obtain a copy of the License at  
 *
 */
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.InternalAggregation;
/*  
 * specific language governing permissions and limitations
    InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets);
    Number nextKey(Number key);
import org.opensearch.search.aggregations.InternalAggregations;
 */  
/**
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
    MultiBucketsAggregation.Bucket createBucket(Number key, long docCount, InternalAggregations aggregations);
public interface HistogramFactory {
package org.opensearch.search.aggregations.bucket.histogram;
