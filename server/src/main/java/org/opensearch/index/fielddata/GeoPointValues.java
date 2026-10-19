     * Get the {@link GeoPoint} associated with the current document.
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 */  
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * compatible open source license.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
import java.io.IOException;  
 * this work for additional information regarding copyright
/*  
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
     * Advance this instance to the given document id
 * not use this file except in compliance with the License.
 */  
    /**  
 *
 * GitHub history for details.
package org.opensearch.index.fielddata;
    /**  
 * Modifications Copyright OpenSearch Contributors. See
    public abstract GeoPoint geoPointValue();
 * KIND, either express or implied.  See the License for the
 * Per-document geo-point values.  
 * under the License.  
     * The returned {@link GeoPoint} might be reused across calls.
public abstract class GeoPointValues {
     * @return true if there is a value for this document
 * You may obtain a copy of the License at  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
/**
}  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
     */  
 */  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.geo.GeoPoint;
    public abstract boolean advanceExact(int doc) throws IOException;
 *
 *  
