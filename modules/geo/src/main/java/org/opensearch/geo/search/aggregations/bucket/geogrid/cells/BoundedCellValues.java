    int advanceValue(org.opensearch.common.geo.GeoPoint target, int valuesIdx) {
import org.opensearch.common.geo.GeoBoundingBox;  
 *
 * You may obtain a copy of the License at  
 * @opensearch.internal  
    private final GeoBoundingBox geoBoundingBox;
 */
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * <p>  
        if (geoBoundingBox.pointInBounds(target.getLon(), target.getLat())) {  
    }
        CellIdSource.GeoPointLongEncoder encoder,  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
/**  
 */  
    ) {
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
/*
 * not use this file except in compliance with the License.
/*
 * Class representing {@link CellValues} whose values are filtered
}  
        return valuesIdx;
            return valuesIdx + 1;
        int precision,
    @Override
 */
 * Unless required by applicable law or agreed to in writing,
    protected BoundedCellValues(  
    }
import org.opensearch.index.fielddata.MultiGeoPointValues;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The specified bounding box is assumed to be bounded.
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
        super(geoValues, precision, encoder);  
 * under the License.  
 *  
 * this file be licensed under the Apache-2.0 license or a
        MultiGeoPointValues geoValues,
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.geo.search.aggregations.bucket.geogrid.cells;
 * according to whether they are within the specified {@link GeoBoundingBox}.
 * compatible open source license.
class BoundedCellValues extends CellValues {
        GeoBoundingBox geoBoundingBox
 * this work for additional information regarding copyright
        this.geoBoundingBox = geoBoundingBox;
 *
/*  
            values[valuesIdx] = encoder.encode(target.getLon(), target.getLat(), precision);
        }  
