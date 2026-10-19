    public MultiBucketConsumer multiBucketConsumer() {  
import static org.opensearch.search.aggregations.MultiBucketConsumerService.MultiBucketConsumer;
        return factories;
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
@PublicApi(since = "1.0.0")  
 * KIND, either express or implied.  See the License for the
    }
 * Licensed to Elasticsearch under one or more contributor  
    /**
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 */
    public AggregatorFactories factories() {
 * compatible open source license.
 * software distributed under the License is distributed on an
public class SearchContextAggregations {
 * Unless required by applicable law or agreed to in writing,
    private final MultiBucketConsumer multiBucketConsumer;  
 */
     * Returns a consumer for multi bucket aggregation that checks the total number of buckets  
 * Modifications Copyright OpenSearch Contributors. See  
     */
    private final AggregatorFactories factories;
    public SearchContextAggregations(AggregatorFactories factories, MultiBucketConsumer multiBucketConsumer) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        multiBucketConsumer.reset();
    }
 * this file be licensed under the Apache-2.0 license or a
 * The aggregation context that is part of the search context.
    void resetBucketMultiConsumer() {
     */
import org.opensearch.common.annotation.PublicApi;  
package org.opensearch.search.aggregations;
 * under the License.  
        this.multiBucketConsumer = multiBucketConsumer;
 *
 * @opensearch.api
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * GitHub history for details.
     * created in the response
 *
}
 *  
 * not use this file except in compliance with the License.
        return multiBucketConsumer;
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
     * Creates a new aggregation context with the parsed aggregator factories  
/*
    /**
 *  
/**
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 */  
/*
 */
        this.factories = factories;  
