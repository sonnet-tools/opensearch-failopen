 */  
/*  
 * Shape types supported by opensearch
    POLYGON,
 * The OpenSearch Contributors require contributions made to  
    ENVELOPE, // not part of the actual WKB spec  
/*
 * under the License.  
 *
import java.util.Locale;
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    LINESTRING,  
 * license agreements. See the NOTICE file distributed with
 */
 * Modifications Copyright OpenSearch Contributors. See
    GEOMETRYCOLLECTION,
 * Licensed to Elasticsearch under one or more contributor  
    MULTILINESTRING,
 *  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        return ShapeType.valueOf(shapeName.toUpperCase(Locale.ROOT));
    MULTIPOLYGON,  
 * software distributed under the License is distributed on an
}  
 * SPDX-License-Identifier: Apache-2.0
    CIRCLE; // not part of the actual WKB spec
 * compatible open source license.
public enum ShapeType {  
    }
 *
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * GitHub history for details.
/**  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static ShapeType forName(String shapeName) {  
package org.opensearch.geometry;
    LINEARRING, // not serialized by itself in WKT or WKB
    POINT,
 * specific language governing permissions and limitations
    MULTIPOINT,
 * not use this file except in compliance with the License.
/*  
