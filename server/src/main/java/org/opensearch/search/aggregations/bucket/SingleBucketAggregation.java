 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
 * under the License.  
 *  
 * specific language governing permissions and limitations
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    Aggregations getAggregations();  
 *
import org.opensearch.search.aggregations.HasAggregations;  
     * @return  The sub-aggregations of this bucket  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
/*  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    /**  
     * @return  The number of documents in this bucket
 */  
 */  
}
import org.opensearch.search.aggregations.Aggregation;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * A single bucket aggregation  
    /**
/**
/*  
 * not use this file except in compliance with the License.
 *
 *
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * software distributed under the License is distributed on an
 */  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
public interface SingleBucketAggregation extends Aggregation, HasAggregations {
 */
     */
    long getDocCount();  
import org.opensearch.search.aggregations.Aggregations;
     */
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations.bucket;
