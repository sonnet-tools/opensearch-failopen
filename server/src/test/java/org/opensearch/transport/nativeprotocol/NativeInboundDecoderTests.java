                requestId,
    @Override  
 * compatible open source license.
                threadContext,
import java.util.Collections;
        long requestId,
                version,
                transportMessage,
import org.opensearch.transport.InboundDecoderTests;
    ) throws IOException {  
 */  
        }
                compress
import java.io.IOException;
import org.opensearch.Version;
                requestId,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.bytes.BytesReference;  
}
                new String[0],
        Writeable transportMessage
 * SPDX-License-Identifier: Apache-2.0
        if (isRequest) {
        return message.serialize(new BytesStreamOutput());
            );
    }
                threadContext,  
                handshake,
public class NativeInboundDecoderTests extends InboundDecoderTests {
        boolean handshake,
import org.opensearch.core.common.io.stream.Writeable;
        Version version,  
                handshake,
package org.opensearch.transport.nativeprotocol;
/*  
    protected BytesReference serialize(
            message = new NativeOutboundMessage.Request(  
 *
        boolean compress,
                version,  
                action,
            message = new NativeOutboundMessage.Response(
                Collections.emptySet(),
 * this file be licensed under the Apache-2.0 license or a
                transportMessage,  
            );  
        boolean isRequest,
        NativeOutboundMessage message;
                compress  
        String action,  
import org.opensearch.common.io.stream.BytesStreamOutput;
        } else {
