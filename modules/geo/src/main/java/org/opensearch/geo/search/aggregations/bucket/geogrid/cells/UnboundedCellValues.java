 * KIND, either express or implied.  See the License for the
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.fielddata.MultiGeoPointValues;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
package org.opensearch.geo.search.aggregations.bucket.geogrid.cells;
    @Override  
    int advanceValue(org.opensearch.common.geo.GeoPoint target, int valuesIdx) {
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * under the License.  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
    UnboundedCellValues(MultiGeoPointValues geoValues, int precision, CellIdSource.GeoPointLongEncoder encoder) {
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 *  
    }
 */
/*
        return valuesIdx + 1;  
 * software distributed under the License is distributed on an
 * {@link GeoBoundingBox}.
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.geo.GeoBoundingBox;  
/*
/**  
 */
 *
    }
        values[valuesIdx] = encoder.encode(target.getLon(), target.getLat(), precision);
class UnboundedCellValues extends CellValues {  
        super(geoValues, precision, encoder);  
 * Class representing {@link CellValues} that are unbounded by any
}
 * @opensearch.internal
 * specific language governing permissions and limitations
 */
