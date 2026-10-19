    public void testInstructionTypeRoundtripViaEnum() throws Exception {
                BroadcastInjectionInstructionNode cast = (BroadcastInjectionInstructionNode) decoded;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * SPDX-License-Identifier: Apache-2.0
        }
            }
 * The OpenSearch Contributors require contributions made to  
                assertTrue(decoded instanceof BroadcastInjectionInstructionNode);
/*  
 * this file be licensed under the Apache-2.0 license or a
                assertEquals("input-7", decoded.getNamedInputId());  
            }
                assertEquals("input-0", cast.getNamedInputId());
                assertArrayEquals(payload, decoded.getBroadcastData());
import org.opensearch.common.io.stream.BytesStreamOutput;
                InstructionNode decoded = InstructionType.INJECT_BROADCAST.readNode(in);
    }  
            original.writeTo(out);  
        }
                assertEquals(0, cast.getBuildSideIndex());
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {  
    }  
    public void testWireRoundtripPreservesFields() throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
public class BroadcastInjectionInstructionNodeTests extends OpenSearchTestCase {
                assertArrayEquals(new byte[] { 0x42 }, cast.getBroadcastData());  
                assertEquals(InstructionType.INJECT_BROADCAST, decoded.type());  
        BroadcastInjectionInstructionNode original = new BroadcastInjectionInstructionNode("input-0", 0, new byte[] { 0x42 });  
 */  
            original.writeTo(out);
                assertEquals(1, decoded.getBuildSideIndex());
        byte[] payload = new byte[] { 1, 2, 3, 4, 5 };
 *
import org.opensearch.core.common.io.stream.StreamInput;
}
package org.opensearch.analytics.spi;
        BroadcastInjectionInstructionNode original = new BroadcastInjectionInstructionNode("input-7", 1, payload);  
 * compatible open source license.
                BroadcastInjectionInstructionNode decoded = new BroadcastInjectionInstructionNode(in);
