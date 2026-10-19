 * helpers for some aggs in the MatrixStats package
 * Counterpart to {@link org.opensearch.search.aggregations.support.AggregationInspectionHelper}, providing
package org.opensearch.search.aggregations.matrix.stats;
/**  
 * specific language governing permissions and limitations
/*
 */  
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *  
 * ownership. Elasticsearch licenses this file to you under  
    public static boolean hasValue(InternalMatrixStats agg) {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 */  
        return agg.getResults() != null;  
 */
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
}
public class MatrixAggregationInspectionHelper {
 *
 */
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
    }
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
