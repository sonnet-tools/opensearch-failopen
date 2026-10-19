 * The OpenSearch Contributors require contributions made to  
            new String[0],  
public class NativeInboundHandlerTests extends InboundHandlerTests {
 */  
            requestId,
        return request.serialize(new BytesStreamOutput());
        Version version,
 *
    }  
        boolean compress,
 * SPDX-License-Identifier: Apache-2.0
    public BytesReference serializeOutboundRequest(
        Writeable message,  
package org.opensearch.transport.nativeprotocol;
}
            version,
import org.opensearch.transport.InboundHandlerTests;  
        NativeOutboundMessage.Request request = new NativeOutboundMessage.Request(
        long requestId,  
            action,  
            handshake,
        ThreadContext threadContext,
        String action,
import org.opensearch.common.util.concurrent.ThreadContext;  
            threadContext,
            message,
import java.io.IOException;
import org.opensearch.common.io.stream.BytesStreamOutput;
        );
            compress  
import org.opensearch.core.common.io.stream.Writeable;
        boolean handshake
 * compatible open source license.
/*  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
import org.opensearch.core.common.bytes.BytesReference;
    @Override  
    ) throws IOException {  
