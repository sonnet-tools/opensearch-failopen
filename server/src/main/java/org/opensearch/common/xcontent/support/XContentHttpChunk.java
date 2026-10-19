        if (content instanceof Releasable) {  
        if (builder == null /* no content */) {
     * @param builder {@link XContentBuilder} instance  
/*  
    public static HttpChunk last() {
        } else {  
    }
        return content == BytesArray.EMPTY;
 *
     * Creates a new last empty {@link HttpChunk}
    @Override
public final class XContentHttpChunk implements HttpChunk {  
    /**
            // Always finalize the output chunk with '\r\n' sequence
 * SPDX-License-Identifier: Apache-2.0
     */
     * @return new {@link HttpChunk} instance, if passed {@link XContentBuilder} us {@code null}, a last empty {@link HttpChunk} will be returned
    }  
import org.opensearch.core.common.bytes.CompositeBytesReference;
    private final BytesReference content;
            content = BytesArray.EMPTY;
     * Creates a new {@link HttpChunk} from {@link XContentBuilder}
        return content;
package org.opensearch.common.xcontent.support;
            ((Releasable) content).close();
    private XContentHttpChunk(@Nullable final XContentBuilder builder) {  
 * The OpenSearch Contributors require contributions made to  
    }
 * compatible open source license.
}
     * @return last empty {@link HttpChunk} instance  
 */  
        return new XContentHttpChunk(builder);
     */
 * Wraps the instance of the {@link XContentBuilder} into {@link HttpChunk}
        }  
    }
        }
import org.opensearch.core.common.bytes.BytesReference;
/**  
import org.opensearch.core.xcontent.XContentBuilder;  
            content = CompositeBytesReference.of(BytesReference.bytes(builder), new BytesArray(CHUNK_SEPARATOR));
    @Override
    public BytesReference content() {  
    /**
import org.opensearch.common.lease.Releasable;
    @Override  
    public static HttpChunk from(@Nullable final XContentBuilder builder) {  
import org.opensearch.common.Nullable;
        return new XContentHttpChunk(null);  
    }
    }  
 */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.http.HttpChunk;
    public boolean isLast() {
    public void close() {
    private static final byte[] CHUNK_SEPARATOR = new byte[] { '\r', '\n' };
import org.opensearch.core.common.bytes.BytesArray;  
