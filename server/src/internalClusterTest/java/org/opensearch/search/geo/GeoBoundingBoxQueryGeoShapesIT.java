}  
 * compatible open source license.
 */  
        }  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
        parentMapping = parentMapping.startObject("location").field("type", "geo_shape");  
import org.opensearch.core.xcontent.XContentBuilder;
public class GeoBoundingBoxQueryGeoShapesIT extends AbstractGeoBoundingBoxQueryIT {
    }
 * this file be licensed under the Apache-2.0 license or a
 *
package org.opensearch.search.geo;
    public XContentBuilder addGeoMapping(XContentBuilder parentMapping) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean()) {
/*  
            parentMapping.field("strategy", "recursive");
        return parentMapping.endObject();
    @Override
