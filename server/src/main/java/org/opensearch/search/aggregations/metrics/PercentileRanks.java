/*
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
public interface PercentileRanks extends NumericMetricsAggregation.MultiValue, Iterable<Percentile> {  
     * Return the percentile for the given value as a String.
}
 * the Apache License, Version 2.0 (the "License"); you may
 */
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    /**  
    String percentAsString(double value);  
 *
    double percent(double value);
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 *  
 * not use this file except in compliance with the License.
     * Return the percentile for the given value.
     */  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
package org.opensearch.search.aggregations.metrics;
     */
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * An aggregation that computes approximate percentiles given values.
 */
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    String TYPE_NAME = "percentile_ranks";
