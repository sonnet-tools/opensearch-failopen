    /**
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * Base numeric metrics aggregation class
    interface SingleValue extends NumericMetricsAggregation {  
 *
 */  
 *  
/*  
 * You may obtain a copy of the License at  
     * @opensearch.internal
public interface NumericMetricsAggregation extends Aggregation {
 * compatible open source license.
        double value();
 * under the License.  
     */  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
     *
     * Multi values in a numeric metrics agg  
 * not use this file except in compliance with the License.
     * A single value for the metrics agg
     *  
    }  
}
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.Aggregation;
package org.opensearch.search.aggregations.metrics;
        String getValueAsString();
 * @opensearch.internal  
/*  
    /**
 */
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Modifications Copyright OpenSearch Contributors. See
     */
 */  
    interface MultiValue extends NumericMetricsAggregation {}
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 *
 *
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
     * @opensearch.internal
 * software distributed under the License is distributed on an
