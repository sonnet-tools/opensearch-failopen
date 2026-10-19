}
import java.io.IOException;  
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.geo;
        return parentMapping.startObject("location").field("type", "geo_point").endObject();  
import org.opensearch.core.xcontent.XContentBuilder;
/*  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */  
    @Override
    public XContentBuilder addGeoMapping(XContentBuilder parentMapping) throws IOException {
public class GeoBoundingBoxQueryGeoPointsIT extends AbstractGeoBoundingBoxQueryIT {
 * The OpenSearch Contributors require contributions made to  
    }
