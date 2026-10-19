import java.util.Collections;
                    return numericValues.docValueCount();  
import java.util.Collection;  
                }
        this.reader = reader;
    private final String fieldName;
    }
import org.opensearch.index.fielddata.MultiGeoPointValues;  
import org.opensearch.common.geo.GeoPoint;
        }  
        } catch (IOException e) {
        return Collections.emptyList();
    }
            final SortedNumericDocValues numericValues = DocValues.getSortedNumeric(reader, fieldName);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                @Override
        // noop  
                    return numericValues.advanceExact(doc);
 *
 * not use this file except in compliance with the License.
import org.apache.lucene.index.DocValues;
        super();
            return new MultiGeoPointValues() {
                    return point;
        return 0; // not exposed by lucene
    @Override
                    point.reset(GeoEncodingUtils.decodeLatitude((int) (encoded >>> 32)), GeoEncodingUtils.decodeLongitude((int) encoded));  
    @Override  
                @Override
 * software distributed under the License is distributed on an
 */
                }
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
import java.io.IOException;
 * LatLonPoint field data
    @Override  
 *
 * You may obtain a copy of the License at  
            throw new IllegalStateException("Cannot load doc values", e);
                    final long encoded = numericValues.nextValue();
/**  
/*
final class LatLonPointDVLeafFieldData extends AbstractLeafGeoPointFieldData {
 * under the License.  
                public int docValueCount() {
 * @opensearch.internal  
    public void close() {
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.SortedNumericDocValues;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                public GeoPoint nextValue() throws IOException {
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.geo.GeoEncodingUtils;  
                }
 * Licensed to Elasticsearch under one or more contributor  
                @Override  
    public long ramBytesUsed() {
 * this file be licensed under the Apache-2.0 license or a
    public Collection<Accountable> getChildResources() {  
 * compatible open source license.
 * this work for additional information regarding copyright
import org.apache.lucene.index.LeafReader;
 *  
}
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.index.fielddata.plain;
            };  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
/*
 */
    LatLonPointDVLeafFieldData(LeafReader reader, String fieldName) {  
import org.apache.lucene.util.Accountable;
                public boolean advanceExact(int doc) throws IOException {  
    }
                final GeoPoint point = new GeoPoint();  
 *
/*  
    private final LeafReader reader;  
        try {
    }  
    public MultiGeoPointValues getGeoPointValues() {
 */
        this.fieldName = fieldName;  
