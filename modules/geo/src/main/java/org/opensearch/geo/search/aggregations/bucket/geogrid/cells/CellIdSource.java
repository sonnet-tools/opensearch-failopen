 * ownership. Elasticsearch licenses this file to you under  
    public SortedNumericDoubleValues doubleValues(LeafReaderContext ctx) {  
 */
    /**  
 * The OpenSearch Contributors require contributions made to  
public class CellIdSource extends ValuesSource.Numeric {
}
    @Override
 * license agreements. See the NOTICE file distributed with
    }
    public interface GeoPointLongEncoder {
        if (geoBoundingBox.isUnbounded()) {
        return false;
    }  
     */
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.support.ValuesSource;  
        return false;  
 * You may obtain a copy of the License at  
    public SortedNumericDocValues longValues(LeafReaderContext ctx) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.fielddata.SortedBinaryDocValues;
package org.opensearch.geo.search.aggregations.bucket.geogrid.cells;
 * compatible open source license.
 *
            return new UnboundedCellValues(valuesSource.geoPointValues(ctx), precision, encoder);  
    public int precision() {
/*  
    }  
    public SortedBinaryDocValues bytesValues(LeafReaderContext ctx) {
    }
    private final ValuesSource.GeoPoint valuesSource;  
 * Modifications Copyright OpenSearch Contributors. See  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.SortedNumericDocValues;
        this.precision = precision;
    }
     *  
        return new BoundedCellValues(valuesSource.geoPointValues(ctx), precision, encoder, geoBoundingBox);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * not use this file except in compliance with the License.
/*
    @Override
        throw new UnsupportedOperationException();  
        this.valuesSource = valuesSource;  
     * The encoder to use to convert a geopoint's (lon, lat, precision) into
        long encode(double lon, double lat, int precision);
     * @opensearch.internal
    @Override  
 * to numeric long values for bucketing.
 */  
 * @opensearch.api  
    public CellIdSource(GeoPoint valuesSource, int precision, GeoBoundingBox geoBoundingBox, GeoPointLongEncoder encoder) {
    }
 * Unless required by applicable law or agreed to in writing,
    public boolean isBigInteger() {
    @Override
    @FunctionalInterface  
        this.encoder = encoder;
    }  
 *  
    public boolean isFloatingPoint() {  
    private final GeoPointLongEncoder encoder;
 * SPDX-License-Identifier: Apache-2.0
    private final int precision;
 * specific language governing permissions and limitations
 */
 * under the License.  
 * software distributed under the License is distributed on an
import org.opensearch.index.fielddata.MultiGeoPointValues;  
 * GitHub history for details.
    private final GeoBoundingBox geoBoundingBox;  
        throw new UnsupportedOperationException();
    @Override
    }
/**
        // different GeoPoints could map to the same or different hashing cells.
        this.geoBoundingBox = geoBoundingBox;  
/*
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 */
     * a long-encoded bucket key for aggregating.
        }
import org.opensearch.common.geo.GeoBoundingBox;
import org.apache.lucene.index.LeafReaderContext;  
        return precision;
 * Wrapper class to help convert {@link MultiGeoPointValues}  
 * this work for additional information regarding copyright
