 * compatible open source license.
    @Override
        final byte[] content = new byte[buf.readableBytes()];
    public void close() {}
 * this file be licensed under the Apache-2.0 license or a
    public boolean isLast() {
        this.last = last;
 * The OpenSearch Contributors require contributions made to  
        return content;  
 * SPDX-License-Identifier: Apache-2.0
 *
        // Since the chunks could be batched and processing could be delayed, we are copying the content here  
package org.opensearch.http.reactor.netty4;
    public BytesReference content() {
    private final boolean last;  
/*  
    private final BytesArray content;
    }
import org.opensearch.core.common.bytes.BytesReference;
 */  
        return last;
        buf.readBytes(content);
}
        this.content = new BytesArray(content);  
    @Override  
    @Override  
import org.opensearch.core.common.bytes.BytesArray;
    ReactorNetty4HttpChunk(ByteBuf buf, boolean last) {
class ReactorNetty4HttpChunk implements HttpChunk {
import io.netty.buffer.ByteBuf;
    }  
import org.opensearch.http.HttpChunk;  
    }
