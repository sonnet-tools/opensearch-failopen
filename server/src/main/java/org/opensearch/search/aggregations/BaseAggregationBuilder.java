 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 */
/**  
    String getType();
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * this file be licensed under the Apache-2.0 license or a
    BaseAggregationBuilder setMetadata(Map<String, Object> metadata);  
/*  
public interface BaseAggregationBuilder {  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
    BaseAggregationBuilder subAggregations(Builder subFactories);
 *  
     */
import java.util.Map;
    /**  
/*
 * under the License.  
     */  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
    /**
 *
 * Interface shared by {@link AggregationBuilder} and {@link PipelineAggregationBuilder} so they can conveniently share the same namespace
     * The name of the type of aggregation built by this builder.
 * for {@link XContentParser#namedObject(Class, String, Object)}.
     * Set the aggregation's metadata. Returns {@code this} for chaining.
 */
 */  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 */  
 *
 *  
     * Set the sub aggregations if this aggregation supports sub aggregations. Returns {@code this} for chaining.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;
    /**
 * Unless required by applicable law or agreed to in writing,
}  
package org.opensearch.search.aggregations;
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
