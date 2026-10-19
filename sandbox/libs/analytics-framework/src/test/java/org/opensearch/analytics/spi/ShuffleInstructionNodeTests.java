                assertEquals("q-xyz", decoded.getQueryId());  
                assertEquals(List.of("node-a", "node-b", "node-c", "node-d"), decoded.getTargetWorkerNodeIds());
import org.opensearch.core.common.io.stream.StreamInput;
                assertEquals(InstructionType.SHUFFLE_SCAN, decoded.type());  
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(2, decoded.getTargetStageId());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                assertTrue(decoded instanceof ShuffleScanInstructionNode);
 * compatible open source license.
    public void testInstructionTypeReadNodeDispatch() throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
            List.of(3, 7),
        }
                assertEquals(List.of(3, 7), decoded.getHashKeyChannels());  
                assertEquals("right", decoded.getSide());
                assertEquals("q-xyz", decoded.getQueryId());  
public class ShuffleInstructionNodeTests extends OpenSearchTestCase {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
package org.opensearch.analytics.spi;
            original.writeTo(out);  
            }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            2,
 */  
    }  
            "right"  
        ShuffleScanInstructionNode scan = new ShuffleScanInstructionNode("x", 0, 1, "q", 0, "right");  
            List.of("node-a", "node-b", "node-c", "node-d"),  
/*  
 *
            scan.writeTo(out);
                assertEquals(9, decoded.getTargetStageId());
        }
            original.writeTo(out);  
            4,
                ShuffleScanInstructionNode decoded = new ShuffleScanInstructionNode(in);
    public void testShuffleProducerWireRoundtrip() throws Exception {
                ShuffleProducerInstructionNode decoded = new ShuffleProducerInstructionNode(in);
 * this file be licensed under the Apache-2.0 license or a
        );
        ShuffleScanInstructionNode original = new ShuffleScanInstructionNode("input-0", 2, 5, "q-xyz", 9, "left");
}  
import org.opensearch.common.io.stream.BytesStreamOutput;
            }
    public void testShuffleScanWireRoundtrip() throws Exception {  
            try (StreamInput in = out.bytes().streamInput()) {  
                InstructionNode decoded = InstructionType.SHUFFLE_SCAN.readNode(in);
 * The OpenSearch Contributors require contributions made to  
                assertEquals(4, decoded.getPartitionCount());
import java.util.List;
    }
        }
    }  
                assertEquals(2, decoded.getShufflePartitionIndex());
                assertEquals(InstructionType.SHUFFLE_PRODUCER, decoded.type());  
                assertEquals("input-0", decoded.getNamedInputId());  
        ShuffleProducerInstructionNode original = new ShuffleProducerInstructionNode(  
            }
            try (StreamInput in = out.bytes().streamInput()) {
                assertEquals("left", decoded.getSide());
            "q-xyz",
                assertEquals(5, decoded.getExpectedSenders());
            try (StreamInput in = out.bytes().streamInput()) {
