    @Override
        String side,  
 * <p>{@code side} ({@code "left"} or {@code "right"}) tells the consumer-side handler which half  
        this.producerPlanBytes = in.readBoolean() ? in.readByteArray() : null;
    public int getTargetStageId() {
        out.writeVInt(targetStageId);
        int shufflePartitionIndex,
    }  
}
        String namedInputId,
    public String getSide() {  
 * The OpenSearch Contributors require contributions made to  
 * Instruction for a hash-shuffle worker: register a channel-backed input stream as the named input
        if (producerPlanBytes != null) {
        this.shufflePartitionIndex = in.readVInt();
        this.producerPlanBytes = producerPlanBytes;  
import java.io.IOException;
        this.targetStageId = in.readVInt();
 * leaves. The convertor strips the {@code OpenSearchShuffleExchange} wrapper so the leaf  
        this.namedInputId = in.readString();
        return queryId;
            out.writeBoolean(true);
/**  
    }
 *  
    public ShuffleScanInstructionNode(  
        this.side = in.readString();  
        out.writeVInt(shufflePartitionIndex);
        }  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        out.writeString(side);  
        this.namedInputId = namedInputId;  
    public ShuffleScanInstructionNode(
    }
 * <p>{@code namedInputId} must match the canonical {@code "input-<producerStageId>"} the
        String namedInputId,
    public void writeTo(StreamOutput out) throws IOException {  
    private final byte[] producerPlanBytes;
    }
        int targetStageId,  
        return expectedSenders;
        return InstructionType.SHUFFLE_SCAN;
 */  
 */
    ) {
 *
    }
 *
import org.opensearch.core.common.io.stream.StreamOutput;
    }
 *
        return namedInputId;
    private final String side;
    public byte[] getProducerPlanBytes() {
    }
    ) {
    }
     *  coordinator-reduce path's {@code derive_schema_from_partial_plan}) instead of trusting the  
     *  worker handler derives the registered input schema by RE-LOWERING this plan (matching the
        this.shufflePartitionIndex = shufflePartitionIndex;
    }  
    public ShuffleScanInstructionNode(StreamInput in) throws IOException {  
    }
        out.writeString(queryId);
        byte[] producerPlanBytes
 * before the stream is considered complete — i.e. the {@code awaitReady} count for this partition.
 * @opensearch.internal
        return targetStageId;  
     *  match the FINAL Substrait's logical {@code base_schema} names ({@code sum_qty}) — the M3
 * {@code StageInputScan} drives the NamedScan binding.
    private final String namedInputId;
        this.side = side;
 * {@code shufflePartitionIndex} they identify the {@code (queryId, stageId, partitionIndex)} bucket  
    private final int targetStageId;  
        int targetStageId,
 * of the join input this scan represents — drives the per-side buffer drain
    public String getNamedInputId() {
        this.expectedSenders = in.readVInt();  
     *  the join-shuffle path leaves it null (its producers ship raw rows, names already match). */
 * ({@code buffer.getLeftData()} vs {@code getRightData()}). Producers stamp the same label on
        this.targetStageId = targetStageId;
 *  
        return producerPlanBytes;  
    public int getShufflePartitionIndex() {
 * {@link ShuffleProducerInstructionNode} carries.
 * it as a {@code NamedScan} under {@code namedInputId}. The worker's Substrait plan references that
        return side;
        int expectedSenders,  
 * compatible open source license.
    }  
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(namedInputId);
    public int getExpectedSenders() {  
 * outgoing shuffle requests, so the buffer routes payloads into the correct slice.  
     *  agg-shuffle worker-schema mismatch (TPC-H q1/q15). Only the agg-shuffle dispatch sets this;  
    private final String queryId;
        int expectedSenders,
        this.queryId = in.readString();
 *  
    }
    public String getQueryId() {
 * <p>{@code queryId} and {@code targetStageId} key the worker-side shuffle buffer — paired with
 * <p>{@code expectedSenders} tells the consumer how many upstream senders will mark {@code isLast}
package org.opensearch.analytics.spi;
            out.writeByteArray(producerPlanBytes);  
 * the producers send into and the consumer drains here. Mirrors the same triple
        String side
        int shufflePartitionIndex,  
import org.opensearch.core.common.io.stream.StreamInput;
public class ShuffleScanInstructionNode implements InstructionNode {  
    private final int expectedSenders;
 * name, so the hash-join's input resolves to the partitioned stream.
     *  raw Arrow IPC schema, whose physical partial-state column names ({@code sum_qty[sum]}) don't
        String queryId,
 * fragment convertor emits when it rewrites the consumer fragment's {@code OpenSearchStageInputScan}
 * for partition {@code shufflePartitionIndex}. The backend's handler wires a {@code PartitionStream}
        out.writeVInt(expectedSenders);  
/*  
    /** The producer's converted PARTIAL-aggregate plan bytes, or {@code null}. When present, the
            out.writeBoolean(false);
        this.queryId = queryId;  
 * (or equivalent consumer primitive) that reads from the per-node shuffle buffer, then registers  
        this(namedInputId, shufflePartitionIndex, expectedSenders, queryId, targetStageId, side, null);  
        this.expectedSenders = expectedSenders;
    private final int shufflePartitionIndex;  
        return shufflePartitionIndex;  
    public InstructionType type() {
        String queryId,
        } else {
