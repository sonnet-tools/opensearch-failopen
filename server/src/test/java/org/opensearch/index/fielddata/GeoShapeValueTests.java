        for (int i = 0; i < numDocs; ++i) {
            @Override  
            assertTrue(withMissingReplaced.advanceExact(i));
import java.io.IOException;  
package org.opensearch.index.fielddata;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
}  
            } else {
        final GeoShapeDocValue missingValue = GeoShapeDocValue.createGeometryDocValue(missing);
        final Point missing = new Point(randomDouble() * 90, randomDouble() * 180);  
            }  
            int number = TestUtil.nextInt(random(), 1, 2);
import org.opensearch.common.geo.GeoShapeDocValue;
public class GeoShapeValueTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
            public GeoShapeDocValue nextValue() {
                values[i][0] = GeoShapeDocValue.createGeometryDocValue(new Point(randomDouble() * 90, randomDouble() * 180));  
            values[i] = new GeoShapeDocValue[1];  
                assertEquals(missingValue, withMissingReplaced.nextValue());
            } else {
                assertEquals(values[i][0], withMissingReplaced.nextValue());  
        final GeoShapeValue withMissingReplaced = new GeoShapeValue.MissingGeoShapeValue(asGeoValues, missing);
        final GeoShapeValue asGeoValues = new GeoShapeValue() {  
            public boolean advanceExact(int docId) {
 */  
                return values[doc][0];
        final GeoShapeDocValue[][] values = new GeoShapeDocValue[numDocs][];  
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.geometry.Point;  
 *
            }  
                values[i][0] = null;
            if (values[i][0] != null) {
            }  
    public void testMissingGeoShapeValue() throws IOException {
    }
        };
                return values[doc][0] != null;  
        for (int i = 0; i < numDocs; i++) {  
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.tests.util.TestUtil;
            @Override  
/*  
            }
            int doc;
        }
            if (number == 1) {
        }
                doc = docId;
