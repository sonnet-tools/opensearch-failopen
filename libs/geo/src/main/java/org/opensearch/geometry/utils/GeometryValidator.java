 * license agreements. See the NOTICE file distributed with
     * Validates the geometry and throws IllegalArgumentException if the geometry is not valid  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import org.opensearch.geometry.Geometry;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.geometry.utils;
/*
    /**
}
 *
/*  
 * Generic geometry validator that can be used by the parser to verify the validity of the parsed geometry
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * compatible open source license.
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 *  
public interface GeometryValidator {  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * this file be licensed under the Apache-2.0 license or a
 *
 * SPDX-License-Identifier: Apache-2.0
 */
 */  
/**  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 */
     */
 * You may obtain a copy of the License at  
    void validate(Geometry geometry);
 * GitHub history for details.
