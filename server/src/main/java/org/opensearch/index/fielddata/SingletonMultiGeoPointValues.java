    public GeoPoint nextValue() {
final class SingletonMultiGeoPointValues extends MultiGeoPointValues {
 */  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
/**
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
    @Override
    }
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 *
        return in.geoPointValue();  
 * license agreements. See the NOTICE file distributed with
/*
        this.in = in;  
    @Override
    public boolean advanceExact(int doc) throws IOException {
 * GitHub history for details.
    GeoPointValues getGeoPointValues() {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public int docValueCount() {  
 * software distributed under the License is distributed on an
 */  
 * not use this file except in compliance with the License.
 */  
    private final GeoPointValues in;  
import java.io.IOException;  
/*  
    }
        return 1;
}  
 *
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 */
 * @opensearch.internal
 *
        return in;
 * specific language governing permissions and limitations
    }  
 * The OpenSearch Contributors require contributions made to  
    SingletonMultiGeoPointValues(GeoPointValues in) {
package org.opensearch.index.fielddata;
 *  
import org.opensearch.common.geo.GeoPoint;
 * Multiple geopoint doc value provider  
        return in.advanceExact(doc);
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
