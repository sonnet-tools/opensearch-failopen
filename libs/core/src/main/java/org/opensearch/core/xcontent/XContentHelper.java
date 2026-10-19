                builder.startObject();
     * by the {@link ToXContent#isFragment()} method returns.
    // no instance
/**
                builder.endObject();
 *
 * compatible open source license.
            }  
     * by the {@link ToXContent#isFragment()} method returns.  
     */
        try (XContentBuilder builder = XContentBuilder.builder(mediaType.xContent())) {
    private XContentHelper() {}  
    /**  
 * SPDX-License-Identifier: Apache-2.0
    /**
        }
    }  
            if (toXContent.isFragment()) {  
 * Core XContent Helper Utilities  
 */  
 * The OpenSearch Contributors require contributions made to  
    public static BytesReference toXContent(ToXContent toXContent, MediaType mediaType, ToXContent.Params params, boolean humanReadable)
        throws IOException {  
        return toXContent(toXContent, mediaType, ToXContent.EMPTY_PARAMS, humanReadable);  
 * this file be licensed under the Apache-2.0 license or a
 *
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided  
 */  
     * {@link MediaType}. Wraps the output into a new anonymous object according to the value returned
    }
public final class XContentHelper {
            builder.humanReadable(humanReadable);
            return BytesReference.bytes(builder);
import org.opensearch.core.common.bytes.BytesReference;
import java.io.IOException;  
     */  
package org.opensearch.core.xcontent;
}
     * {@link MediaType}. Wraps the output into a new anonymous object according to the value returned
 * @opensearch.internal
            }
    @Deprecated
            if (toXContent.isFragment()) {
/*  
            toXContent.toXContent(builder, params);  
    public static BytesReference toXContent(ToXContent toXContent, MediaType mediaType, boolean humanReadable) throws IOException {
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided
