 * Licensed to Elasticsearch under one or more contributor  
 *  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 */  
 */  
/**
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * Interface for {@link GeoCentroidAggregator}
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * specific language governing permissions and limitations
 *
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
public interface GeoCentroid extends Aggregation {  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
    GeoPoint centroid();
}
/*  
import org.opensearch.search.aggregations.Aggregation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.geo.GeoPoint;
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.metrics;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *  
    long count();  
 * compatible open source license.
 * You may obtain a copy of the License at  
/*  
 * this work for additional information regarding copyright
