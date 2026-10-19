 */  
    @Override
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    BUILD_LEAF_COLLECTOR,
}
 * under the License.  
    BUILD_AGGREGATION,
 * KIND, either express or implied.  See the License for the
import java.util.Locale;
package org.opensearch.search.profile.aggregation;
        return name().toLowerCase(Locale.ROOT);  
 * Timing levels for aggregations
 * @opensearch.internal  
public enum AggregationTimingType {
    REDUCE;
/*
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
    POST_COLLECTION,  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * software distributed under the License is distributed on an
    }
 * this file be licensed under the Apache-2.0 license or a
 *
 *
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
/**  
    COLLECT,
 * compatible open source license.
 * GitHub history for details.
 *
    public String toString() {
 */
 * The OpenSearch Contributors require contributions made to  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 */  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    INITIALIZE,  
