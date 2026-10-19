     */
 * GitHub history for details.
 * compatible open source license.
    interface Bucket extends MultiBucketsAggregation.Bucket {
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * A {@code histogram} aggregation. Defines multiple buckets, each representing an interval in a histogram.  
     */
public interface Histogram extends MultiBucketsAggregation {
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
 * specific language governing permissions and limitations
 *
    ParseField MIN_DOC_COUNT_FIELD = new ParseField("min_doc_count");
 * Modifications Copyright OpenSearch Contributors. See  
 */
 */
import org.opensearch.core.ParseField;  
     * @return  The buckets of this histogram (each bucket representing an interval in the histogram)
 * this work for additional information regarding copyright
    List<? extends Bucket> getBuckets();
    ParseField EXTENDED_BOUNDS_FIELD = new ParseField("extended_bounds");
    ParseField HARD_BOUNDS_FIELD = new ParseField("hard_bounds");  
 * not use this file except in compliance with the License.
 *  
    ParseField INTERVAL_FIELD = new ParseField("interval");  
 * You may obtain a copy of the License at  
/*
}  
 *
 * Unless required by applicable law or agreed to in writing,
    @Override  
     * A bucket in the histogram where documents fall in  
 * KIND, either express or implied.  See the License for the
/*  
 * license agreements. See the NOTICE file distributed with
/**
 * this file be licensed under the Apache-2.0 license or a
    /**  
 * @opensearch.internal
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
    ParseField OFFSET_FIELD = new ParseField("offset");
/*
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ParseField KEYED_FIELD = new ParseField("keyed");  
    ParseField ORDER_FIELD = new ParseField("order");
 * software distributed under the License is distributed on an
 */  
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.search.aggregations.bucket.histogram;
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
