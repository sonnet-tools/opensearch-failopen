 *
 */  
    }
}  
    @Override
    }  
 * SPDX-License-Identifier: Apache-2.0
        indexSetup();
/** Tests geo_distance queries on geo_point field types */  
 * compatible open source license.
    public XContentBuilder addGeoMapping(XContentBuilder parentMapping) throws IOException {  
        return parentMapping.startObject("location").field("type", "geo_point").endObject();
    public void setupTestIndex() throws IOException {
package org.opensearch.search.geo;
import org.junit.Before;
 * this file be licensed under the Apache-2.0 license or a
    @Before  
public class GeoDistanceQueryGeoPointsIT extends AbstractGeoDistanceIT {
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;
/*  
 * The OpenSearch Contributors require contributions made to  
