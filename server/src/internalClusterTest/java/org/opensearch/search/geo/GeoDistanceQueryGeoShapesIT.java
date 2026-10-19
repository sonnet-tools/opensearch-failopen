 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    public void testDistanceScript() {
        }
        return parentMapping.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
    }  
 *
        if (randomBoolean()) {
        // no-op; todo script support for distance calculation on shapes cannot be added until GeoShapeDocValues is added
        parentMapping = parentMapping.startObject("location").field("type", "geo_shape");
    public void testGeoDistanceAggregation() {
    public void setupTestIndex() throws IOException {
    @Override  
public class GeoDistanceQueryGeoShapesIT extends AbstractGeoDistanceIT {
 * SPDX-License-Identifier: Apache-2.0
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/2515")
    }  
 */  
    }  
/** Tests geo_distance queries on geo_shape field types */  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/2515")
        indexSetup();
        // no-op; todo aggregation support for distance calculation on shapes cannot be added until GeoShapeDocValues is added
    @Override
 * compatible open source license.
/*  
    public XContentBuilder addGeoMapping(XContentBuilder parentMapping) throws IOException {  
}
    @Override  
import org.junit.Before;
import java.io.IOException;
package org.opensearch.search.geo;
    @Before  
    }  
            parentMapping.field("strategy", "recursive");  
