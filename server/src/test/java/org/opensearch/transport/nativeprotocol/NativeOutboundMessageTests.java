import org.opensearch.transport.TestRequest;
        BytesStreamInput input = new BytesStreamInput(output.bytes().toBytesRef().bytes);  
        NativeOutboundMessage.Request message = new NativeOutboundMessage.Request(
        assertEquals((byte) 'E', input.readByte());  
 * this file be licensed under the Apache-2.0 license or a
            new TestRequest("content"),
        int variableHeaderSize = input.readInt();  
    public void testNativeOutboundMessageRequestSerialization() throws IOException {
        BytesStreamOutput output = new BytesStreamOutput();  
import org.opensearch.Version;
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.test.OpenSearchTestCase;  
/*  
            false
            "action",
            false,  
package org.opensearch.transport.nativeprotocol;
        assertEquals(Version.CURRENT, input.getVersion());
import org.opensearch.core.common.io.stream.BytesStreamInput;
    }
            1,
        assertEquals(Version.CURRENT.id, input.readInt());
        assertNotEquals(0, input.readInt());
        assertEquals((byte) 'S', input.readByte());
public class NativeOutboundMessageTests extends OpenSearchTestCase {
            new String[0],
        assertNotEquals(-1, variableHeaderSize);
}
 */  
import java.io.IOException;  
import org.opensearch.common.util.concurrent.ThreadContext;
        message.serialize(output);
 * The OpenSearch Contributors require contributions made to  
        assertEquals(0, input.readByte());
            Version.CURRENT,  
        );
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.common.settings.Settings;  
        assertEquals(1, input.readLong());  
            new ThreadContext(Settings.EMPTY),  
        // reading header details
 * compatible open source license.
