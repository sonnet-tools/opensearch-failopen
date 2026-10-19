    public Map<String, MediaType> getAdditionalMediaTypes() {
    public List<MediaType> getMediaTypes() {
 */  
import org.opensearch.common.xcontent.XContentType;
    /** Returns the concrete {@link MediaType} provided by the xcontent library */
import org.opensearch.core.xcontent.MediaType;
 * Media Type implementations provided by xcontent library  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
}
        return Map.of("application/*", XContentType.JSON, "application/x-ndjson", XContentType.JSON);
package org.opensearch.common.xcontent.spi;
 *
 */  
    }  
    }  
import org.opensearch.core.xcontent.spi.MediaTypeProvider;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
    @Override  
/**
    @Override  
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
        return List.of(XContentType.values());
 * compatible open source license.
    /** Returns the additional {@link MediaType} aliases provided by the xcontent library */
 *
public class XContentProvider implements MediaTypeProvider {
/*  
