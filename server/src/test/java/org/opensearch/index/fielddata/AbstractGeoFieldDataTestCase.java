    @Override  
 * this work for additional information regarding copyright
    protected void fillAllMissing() throws Exception {
/*  
 * under the License.  
        d = new Document();
 * KIND, either express or implied.  See the License for the
                assertThat(point.lat(), allOf(greaterThanOrEqualTo(GeoUtils.MIN_LAT), lessThanOrEqualTo(GeoUtils.MAX_LAT)));
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        return 0;  
public abstract class AbstractGeoFieldDataTestCase extends AbstractFieldDataImplTestCase {
        assumeFalse("Only test on non geo_point fields", getFieldDataType().equals("geo_point"));
    }
 * The OpenSearch Contributors require contributions made to  
/*
 * GitHub history for details.
    protected abstract String getFieldDataType();
        d.add(new StringField("_id", "3", Field.Store.NO));
    @Override
    }
        }
 * not use this file except in compliance with the License.
 */
import org.opensearch.common.geo.GeoPoint;
}  
        Document d = new Document();
    @Override
 * SPDX-License-Identifier: Apache-2.0
        d.add(new StringField("_id", "2", Field.Store.NO));
 */
        writer.addDocument(d);
 * compatible open source license.
    protected void assertMissing(MultiGeoPointValues values, int docId) throws IOException {  
    }
        d = new Document();  
        assertValues(values, docId, false);  
        assertValues(values, docId, true);
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
import org.apache.lucene.document.StringField;  
            }  
import org.apache.lucene.document.LatLonDocValuesField;
        if (missing == false) {  
 */  
            final int docCount = values.docValueCount();
    private void assertValues(MultiGeoPointValues values, int docId, boolean missing) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Modifications Copyright OpenSearch Contributors. See  
    }
 * You may obtain a copy of the License at  
    }
            for (int i = 0; i < docCount; ++i) {
        return true;
import org.apache.lucene.document.Document;  
    }  
import static org.opensearch.test.geo.RandomShapeGenerator.randomPoint;  
    protected long minRamBytesUsed() {
                assertThat(point.lon(), allOf(greaterThanOrEqualTo(GeoUtils.MIN_LON), lessThanOrEqualTo(GeoUtils.MAX_LON)));
/*
    @Override  
 * specific language governing permissions and limitations
 *
    protected boolean hasDocValues() {  
        writer.addDocument(d);
        return new LatLonDocValuesField(fieldName, point.lat(), point.lon());
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
        writer.addDocument(d);  
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.allOf;
    public void testSortMultiValuesFields() {
        assertEquals(missing == false, values.advanceExact(docId));
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
                final GeoPoint point = values.nextValue();  
    protected void assertValues(MultiGeoPointValues values, int docId) throws IOException {
    protected Field randomGeoPointField(String fieldName, Field.Store store) {  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import org.apache.lucene.document.Field;
        GeoPoint point = randomPoint(random());
 * Unless required by applicable law or agreed to in writing,
        d.add(new StringField("_id", "1", Field.Store.NO));  
package org.opensearch.index.fielddata;
 *
    @Override  
import org.opensearch.common.geo.GeoUtils;
    }  
