        BytesStreamOutput out = new BytesStreamOutput();
/*  
import org.opensearch.analytics.spi.DelegationDescriptor;
    }
        original.writeTo(out);  
        ShardScanWithDelegationInstructionNode deserializedNode = (ShardScanWithDelegationInstructionNode) deserialized.getInstructions()  
     * {queryId, stageId, shardId, planAlternatives} — because the logical registration name now
        FragmentExecutionRequest.PlanAlternative original = new FragmentExecutionRequest.PlanAlternative(  
        List<DelegatedExpression> expressions = List.of(  
        assertEquals("datafusion", deserialized.getBackendId());
        // Null logical name round-trips as null (data node falls back to the concrete shard name).
        assertNull(deserialized.getDelegationDescriptor());  
 * Wire serialization round-trip tests for {@link FragmentExecutionRequest.PlanAlternative}.  
        assertNull(scanNode.getLogicalTableName());
import java.io.IOException;
    public void testRoundTripShardScanNullLogicalName() throws IOException {  
import org.opensearch.analytics.spi.ShardScanInstructionNode;
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(InstructionType.SETUP_FINAL_AGGREGATE, deserialized.getInstructions().get(2).type());  
        assertEquals(1, deserialized.getInstructions().size());  
    private FragmentExecutionRequest.PlanAlternative roundTrip(FragmentExecutionRequest.PlanAlternative original) throws IOException {
/**
        // Logical table name survives the wire round-trip.  
        assertEquals("events", deserializedNode.getLogicalTableName());
        );
import org.opensearch.analytics.spi.FinalAggregateInstructionNode;
        assertEquals(InstructionType.SETUP_PARTIAL_AGGREGATE, deserialized.getInstructions().get(1).type());
    }  
    /**
        );
        assertEquals(InstructionType.SETUP_SHARD_SCAN, deserialized.getInstructions().get(0).type());
        return new FragmentExecutionRequest.PlanAlternative(in);
    public void testRoundTripWithDelegation() throws IOException {
 */
        assertEquals(2, deserializedNode.getDelegatedPredicateCount());  
        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(
import java.util.List;  
        FragmentExecutionRequest original = new FragmentExecutionRequest(  
        assertEquals(InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION, deserialized.getInstructions().get(0).type());
            new byte[] { 5, 6 },
            FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION,
            descriptor
    }  
        );
    }
        original.writeTo(out);
        assertNotNull(deserialized.getDelegationDescriptor());
        DelegationDescriptor descriptor = new DelegationDescriptor(FilterTreeShape.CONJUNCTIVE, 2, expressions);
import org.opensearch.test.OpenSearchTestCase;  
        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(original);
            instructions  
            7,
        ShardScanInstructionNode scanNode = (ShardScanInstructionNode) deserialized.getInstructions().get(0);  
        assertEquals(2, deserializedDescriptor.delegatedExpressions().size());
        FragmentExecutionRequest.PlanAlternative original = new FragmentExecutionRequest.PlanAlternative(  
        ShardScanInstructionNode scanNode = (ShardScanInstructionNode) deserialized.getInstructions().get(0);
        List<InstructionNode> instructions = List.of(
            .get(0);
        assertArrayEquals(new byte[] { 1, 2, 3 }, deserialized.getFragmentBytes());  
}
public class PlanAlternativeSerializationTests extends OpenSearchTestCase {
            new ShardScanWithDelegationInstructionNode(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, 1),  
import org.opensearch.analytics.spi.PartialAggregateInstructionNode;
            instructions,  
        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(original);  
            new byte[] { 7 },
        );
        );  
 * The OpenSearch Contributors require contributions made to  
        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(original);
            "q-1",
        List<InstructionNode> instructions = List.of(new ShardScanInstructionNode(false, "logs-*"));
        org.opensearch.core.index.shard.ShardId shardId = new org.opensearch.core.index.shard.ShardId("bank_a", "uuid", 0);
        assertEquals("lucene", deserializedDescriptor.delegatedExpressions().get(0).getAcceptingBackendId());  
        FragmentExecutionRequest.PlanAlternative original = new FragmentExecutionRequest.PlanAlternative(  
        List<InstructionNode> instructions = List.of(delegationNode);
        assertEquals(3, deserialized.getInstructions().size());  
            1,  
        assertEquals(2, deserializedDescriptor.delegatedPredicateCount());  
            false,
    }  
        DelegationDescriptor deserializedDescriptor = deserialized.getDelegationDescriptor();  
     * Whole-request round-trip. The request itself carries no top-level table name —  
        assertEquals(1, deserializedDescriptor.delegatedExpressions().get(0).getAnnotationId());
            FilterTreeShape.CONJUNCTIVE,  
            new PartialAggregateInstructionNode(),
            List.of(new FragmentExecutionRequest.PlanAlternative("datafusion", new byte[] { 1 }, List.of(new ShardScanInstructionNode())))
            instructions,  
        );
 * compatible open source license.
        assertEquals("bank_a", deserialized.getShardId().getIndexName());
        );
     * travels on the shard-scan instruction node inside each plan alternative.
            2,
 * this file be licensed under the Apache-2.0 license or a
        );
        ShardScanWithDelegationInstructionNode delegationNode = new ShardScanWithDelegationInstructionNode(
            new DelegatedExpression(2, "lucene", new byte[] { 30, 40 })
        );  
        assertEquals("logs-*", scanNode.getLogicalTableName());
        assertEquals(1, deserialized.getPlanAlternatives().size());
import org.opensearch.analytics.spi.FilterTreeShape;  
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;  
            "datafusion",
            descriptor
        StreamInput in = out.bytes().streamInput();
        assertEquals(FilterTreeShape.CONJUNCTIVE, deserializedDescriptor.treeShape());
            new FragmentExecutionRequest.PlanAlternative("datafusion", new byte[] { 1 }, instructions)  
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals(1, deserialized.getInstructions().size());
            List.of(new DelegatedExpression(3, "lucene", new byte[] { 99 }))
            new FinalAggregateInstructionNode()
    public void testRoundTripWithAllTypes() throws IOException {
            shardId,  
    public void testRequestRoundTrip() throws IOException {
        FragmentExecutionRequest deserialized = new FragmentExecutionRequest(out.bytes().streamInput());  
     */  
        assertArrayEquals(new byte[] { 10, 20 }, deserializedDescriptor.delegatedExpressions().get(0).getExpressionBytes());
            "datafusion",
package org.opensearch.analytics.exec.action;
        assertNotNull(deserializedDescriptor);
 *
import org.opensearch.analytics.spi.InstructionNode;
    public void testRoundTripWithShardScanOnly() throws IOException {
            new byte[] { 1, 2, 3 },
            "events"  
        assertEquals(InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION, deserialized.getInstructions().get(0).type());
        assertEquals(FilterTreeShape.CONJUNCTIVE, deserializedNode.getTreeShape());
import org.opensearch.analytics.spi.DelegatedExpression;
        assertEquals("q-1", deserialized.getQueryId());
            new DelegatedExpression(1, "lucene", new byte[] { 10, 20 }),
        DelegationDescriptor descriptor = new DelegationDescriptor(
import org.opensearch.analytics.spi.InstructionType;  
import org.opensearch.common.io.stream.BytesStreamOutput;
        List<InstructionNode> instructions = List.of(new ShardScanInstructionNode());
        BytesStreamOutput out = new BytesStreamOutput();
            "datafusion",
        assertEquals(7, deserialized.getStageId());  
 */  
