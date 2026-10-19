package org.opensearch.search.aggregations.metrics;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
    /**  
 * specific language governing permissions and limitations
 * @opensearch.internal  
/**  
     */
 *  
 * license agreements. See the NOTICE file distributed with
 */
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *
    /**
     * Return the value associated with the provided percentile as a String.  
    double percentile(double percent);  
/*
 * An aggregation that computes approximate percentiles.
 *
     * Return the value associated with the provided percentile.
 * compatible open source license.
     */
public interface Percentiles extends NumericMetricsAggregation.MultiValue, Iterable<Percentile> {
/*
    String percentileAsString(double percent);
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 */
    String TYPE_NAME = "percentiles";
 * under the License.  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
