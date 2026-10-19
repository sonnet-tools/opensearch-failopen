 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 *
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 */  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.aggregations;
 * license agreements. See the NOTICE file distributed with
 */  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
}
 *  
 * Base interface for buckets that have sub aggs
/*  
 * Licensed to Elasticsearch under one or more contributor  
 */
 */
/*  
 * compatible open source license.
/*
 * specific language governing permissions and limitations
/**
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
public interface HasAggregations {  
 * software distributed under the License is distributed on an
 * under the License.  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
    Aggregations getAggregations();
 *
 * SPDX-License-Identifier: Apache-2.0
