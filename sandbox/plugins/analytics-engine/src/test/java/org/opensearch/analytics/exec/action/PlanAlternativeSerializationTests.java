        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(
        );
        org.opensearch.core.index.shard.ShardId shardId = new org.opensearch.core.index.shard.ShardId("bank_a", "uuid", 0);
import org.opensearch.analytics.spi.DelegatedExpression;
        assertEquals(InstructionType.SETUP_SHARD_SCAN, deserialized.getInstructions().get(0).type());
        assertNull(deserialized.getDelegationDescriptor());
 *
    }
     * {queryId, stageId, shardId, planAlternatives} — because the logical registration name now
            "datafusion",
        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(original);
    public void testRequestRoundTrip() throws IOException {
     */
        assertEquals(7, deserialized.getStageId());
        assertEquals(1, deserialized.getInstructions().size());
        assertEquals(FilterTreeShape.CONJUNCTIVE, deserializedDescriptor.treeShape());
import org.opensearch.common.io.stream.BytesStreamOutput;
            new byte[] { 1, 2, 3 },
            FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION,
        FragmentExecutionRequest.PlanAlternative original = new FragmentExecutionRequest.PlanAlternative(
        assertArrayEquals(new byte[] { 10, 20 }, deserializedDescriptor.delegatedExpressions().get(0).getExpressionBytes());
            descriptor
        assertEquals(InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION, deserialized.getInstructions().get(0).type());
        assertEquals(InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION, deserialized.getInstructions().get(0).type());
        ShardScanWithDelegationInstructionNode deserializedNode = (ShardScanWithDelegationInstructionNode) deserialized.getInstructions()
        assertEquals(1, deserializedDescriptor.delegatedExpressions().get(0).getAnnotationId());
 * this file be licensed under the Apache-2.0 license or a
/**
        assertEquals(1, deserialized.getPlanAlternatives().size());
    public void testRoundTripShardScanNullLogicalName() throws IOException {
import org.opensearch.analytics.spi.InstructionType;
import org.opensearch.test.OpenSearchTestCase;
        );
        StreamInput in = out.bytes().streamInput();
    private FragmentExecutionRequest.PlanAlternative roundTrip(FragmentExecutionRequest.PlanAlternative original) throws IOException {
        List<InstructionNode> instructions = List.of(new ShardScanInstructionNode());
        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(original);
            List.of(new DelegatedExpression(3, "lucene", new byte[] { 99 }))
        FragmentExecutionRequest deserialized = new FragmentExecutionRequest(out.bytes().streamInput());
        original.writeTo(out);
            "datafusion",
            FilterTreeShape.CONJUNCTIVE,
        assertNull(scanNode.getLogicalTableName());
        assertEquals(InstructionType.SETUP_PARTIAL_AGGREGATE, deserialized.getInstructions().get(1).type());
import org.opensearch.analytics.spi.FinalAggregateInstructionNode;
            7,
        BytesStreamOutput out = new BytesStreamOutput();
        List<InstructionNode> instructions = List.of(new ShardScanInstructionNode(false, "logs-*"));
        assertNotNull(deserialized.getDelegationDescriptor());
import org.opensearch.analytics.spi.DelegationDescriptor;
            List.of(new FragmentExecutionRequest.PlanAlternative("datafusion", new byte[] { 1 }, List.of(new ShardScanInstructionNode())))
    public void testRoundTripWithAllTypes() throws IOException {
        );
        assertEquals("logs-*", scanNode.getLogicalTableName());
        DelegationDescriptor descriptor = new DelegationDescriptor(FilterTreeShape.CONJUNCTIVE, 2, expressions);
        DelegationDescriptor descriptor = new DelegationDescriptor(
        assertEquals(FilterTreeShape.CONJUNCTIVE, deserializedNode.getTreeShape());
     * travels on the shard-scan instruction node inside each plan alternative.
import org.opensearch.analytics.spi.ShardScanInstructionNode;
            new FinalAggregateInstructionNode()
            descriptor
        assertArrayEquals(new byte[] { 1, 2, 3 }, deserialized.getFragmentBytes());
            1,
    public void testRoundTripWithShardScanOnly() throws IOException {
            .get(0);
        assertNotNull(deserializedDescriptor);
            instructions,
            instructions
        BytesStreamOutput out = new BytesStreamOutput();
}
/*
        List<DelegatedExpression> expressions = List.of(
            new byte[] { 5, 6 },
    }
        DelegationDescriptor deserializedDescriptor = deserialized.getDelegationDescriptor();
        assertEquals(3, deserialized.getInstructions().size());
public class PlanAlternativeSerializationTests extends OpenSearchTestCase {
            new PartialAggregateInstructionNode(),
import org.opensearch.analytics.spi.FilterTreeShape;
    /**
        assertEquals("bank_a", deserialized.getShardId().getIndexName());
import org.opensearch.core.common.io.stream.StreamInput;
        // Null logical name round-trips as null (data node falls back to the concrete shard name).
        );
        FragmentExecutionRequest.PlanAlternative original = new FragmentExecutionRequest.PlanAlternative(
        assertEquals(2, deserializedNode.getDelegatedPredicateCount());
            new ShardScanWithDelegationInstructionNode(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, 1),
            "events"
    }
        FragmentExecutionRequest.PlanAlternative original = new FragmentExecutionRequest.PlanAlternative(
            new DelegatedExpression(2, "lucene", new byte[] { 30, 40 })
        assertEquals("events", deserializedNode.getLogicalTableName());
 * compatible open source license.
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
    }
            new DelegatedExpression(1, "lucene", new byte[] { 10, 20 }),
        assertEquals("lucene", deserializedDescriptor.delegatedExpressions().get(0).getAcceptingBackendId());
        );
 */
        assertEquals("datafusion", deserialized.getBackendId());
            "datafusion",
 * The OpenSearch Contributors require contributions made to
        // Logical table name survives the wire round-trip.
        FragmentExecutionRequest original = new FragmentExecutionRequest(
            "q-1",
        ShardScanInstructionNode scanNode = (ShardScanInstructionNode) deserialized.getInstructions().get(0);
            new FragmentExecutionRequest.PlanAlternative("datafusion", new byte[] { 1 }, instructions)
        original.writeTo(out);
        return new FragmentExecutionRequest.PlanAlternative(in);
package org.opensearch.analytics.exec.action;
        );
            shardId,
        ShardScanInstructionNode scanNode = (ShardScanInstructionNode) deserialized.getInstructions().get(0);
        assertEquals(InstructionType.SETUP_FINAL_AGGREGATE, deserialized.getInstructions().get(2).type());
        FragmentExecutionRequest.PlanAlternative deserialized = roundTrip(original);
        assertEquals(2, deserializedDescriptor.delegatedPredicateCount());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.InstructionNode;
        List<InstructionNode> instructions = List.of(
        assertEquals(2, deserializedDescriptor.delegatedExpressions().size());
        );
            2,
        );
    public void testRoundTripWithDelegation() throws IOException {
            new byte[] { 7 },
import java.util.List;
        assertEquals("q-1", deserialized.getQueryId());
        assertEquals(1, deserialized.getInstructions().size());
            instructions,
        List<InstructionNode> instructions = List.of(delegationNode);
 */
     * Whole-request round-trip. The request itself carries no top-level table name —
import java.io.IOException;
    }
        ShardScanWithDelegationInstructionNode delegationNode = new ShardScanWithDelegationInstructionNode(
            false,
    }
 * Wire serialization round-trip tests for {@link FragmentExecutionRequest.PlanAlternative}.
        );
import org.opensearch.analytics.spi.PartialAggregateInstructionNode;
