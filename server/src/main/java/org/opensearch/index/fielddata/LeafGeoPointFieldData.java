 * Modifications Copyright OpenSearch Contributors. See  
    /**
 * You may obtain a copy of the License at  
 * @opensearch.internal  
 *
 * {@link LeafFieldData} specialization for geo points.
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.fielddata;
 * specific language governing permissions and limitations
 */  
/*
 */
/*  
}  
public interface LeafGeoPointFieldData extends LeafFieldData {
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 *
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
     */  
/**  
 * KIND, either express or implied.  See the License for the
     * Return geo-point values.
 */
 */
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * Unless required by applicable law or agreed to in writing,
    MultiGeoPointValues getGeoPointValues();
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 *
 * The OpenSearch Contributors require contributions made to  
