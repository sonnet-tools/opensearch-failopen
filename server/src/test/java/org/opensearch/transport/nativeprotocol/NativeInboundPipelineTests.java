        return message.serialize(new BytesStreamOutput());
        String action,
 */  
                version,
import org.opensearch.transport.TestResponse;  
}
                requestId,
import org.opensearch.transport.InboundPipelineTests;
                new TestRequest(value),
                action,  
                threadContext,
        boolean compress,  
                threadContext,
                requestId,
import java.io.IOException;
        String value  
            );
                compress  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * compatible open source license.
        boolean isRequest,  
        NativeOutboundMessage message;
 * The OpenSearch Contributors require contributions made to  
 *
        boolean handshake,
public class NativeInboundPipelineTests extends InboundPipelineTests {
/*  
        }  
 * this file be licensed under the Apache-2.0 license or a
    ) throws IOException {
                handshake,  
            message = new NativeOutboundMessage.Response(  
                compress
    }  
    protected BytesReference serialize(
        long requestId,
import org.opensearch.Version;
            message = new NativeOutboundMessage.Request(
                new TestResponse(value),  
        Version version,
 * SPDX-License-Identifier: Apache-2.0
            );
        if (isRequest) {  
import org.opensearch.transport.TestRequest;
        } else {
                new String[0],  
                Collections.emptySet(),
package org.opensearch.transport.nativeprotocol;
    @Override
                version,
import org.opensearch.core.common.bytes.BytesReference;  
import java.util.Collections;  
                handshake,
