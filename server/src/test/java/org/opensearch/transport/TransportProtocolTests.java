    public void testNativeProtocol() {
import org.opensearch.test.OpenSearchTestCase;
 *
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(TransportProtocol.NATIVE, TransportProtocol.fromBytes((byte) 'E', (byte) 'S'));  
 * this file be licensed under the Apache-2.0 license or a
public class TransportProtocolTests extends OpenSearchTestCase {  
 */  
 * The OpenSearch Contributors require contributions made to  
    }
package org.opensearch.transport;
        assertThrows(IllegalArgumentException.class, () -> TransportProtocol.fromBytes((byte) 'e', (byte) 'S'));
    public void testInvalidProtocol() {  
}  
/*  
 * compatible open source license.
    }
