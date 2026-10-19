        this.partitionIndex = partitionIndex;
 * SPDX-License-Identifier: Apache-2.0
 * {@link ShuffleScanInstructionNode} handlers can register named-input streams against it.
     * @param preferHashJoin      false → the backend builds a spillable sort-merge join for this worker
    public boolean getPreferHashJoin() {
    public InstructionType type() {  
/**  
     * @param partitionIndex      worker buffer triple key
 */  
        this.leftExpectedSenders = leftExpectedSenders;  
        out.writeVInt(partitionIndex);
 *
public class ShuffleWorkerSetupInstructionNode implements InstructionNode {
 *
    public ShuffleWorkerSetupInstructionNode(
    public int getTargetStageId() {  
    public ShuffleWorkerSetupInstructionNode(StreamInput in) throws IOException {
    }  
    private final int targetStageId;
    }
package org.opensearch.analytics.spi;
    ) {
    public int getRightExpectedSenders() {  
        this.partitionIndex = in.readVInt();
import org.opensearch.core.common.io.stream.StreamInput;
    private final int partitionIndex;  
 * <p>Beyond the buffer-triple key + expected-sender counts, the node carries the per-worker-stage  
        int rightExpectedSenders,  
/*  
        return preferHashJoin;
     * @param rightExpectedSenders expected isLast count from right producers for this partition
     * @param targetStageId       worker buffer triple key
 */
 * Instruction prepended to every hash-shuffle worker fragment's plan alternatives. The
    }
 * worker join's build side is too large for an in-memory hash table, so the backend builds a
        out.writeBoolean(preferHashJoin);
import org.opensearch.core.common.io.stream.StreamOutput;
        boolean preferHashJoin
    public int getPartitionIndex() {
        out.writeVInt(targetStageId);
        this.preferHashJoin = preferHashJoin;
 *
     */  
    private final int rightExpectedSenders;
    private final String queryId;
        String queryId,
        int leftExpectedSenders,
        this.queryId = queryId;  
 * The OpenSearch Contributors require contributions made to  
     * @param queryId             worker buffer triple key  
        out.writeString(queryId);  
        return targetStageId;
        return InstructionType.SETUP_SHUFFLE_WORKER;
 * compatible open source license.
import java.io.IOException;
        this.leftExpectedSenders = in.readVInt();  
    public int getLeftExpectedSenders() {
    }  
        this.queryId = in.readString();  
        out.writeVInt(leftExpectedSenders);  
        this.rightExpectedSenders = rightExpectedSenders;
 * @opensearch.internal  
     * @param leftExpectedSenders expected isLast count from left producers for this partition  
        return leftExpectedSenders;  
 * spillable sort-merge join instead of the non-spillable hash-join build. Defaults {@code true}  
    public void writeTo(StreamOutput out) throws IOException {
    @Override
    }  
        return queryId;  
}
        return partitionIndex;
 * backend's handler creates a worker-mode {@code SessionContext} (no shard view, no listing
        this.targetStageId = targetStageId;
        this.targetStageId = in.readVInt();
    }
        this.preferHashJoin = in.readBoolean();
    /**
    }
    private final int leftExpectedSenders;
    public String getQueryId() {
        this.rightExpectedSenders = in.readVInt();
    @Override
 * table) and returns it as the {@link BackendExecutionContext}, so subsequent  
    private final boolean preferHashJoin;  
 * {@code preferHashJoin} decision: the coordinator sets it {@code false} when it estimates this
 * (hash-join, the historical behavior).
        int partitionIndex,
        return rightExpectedSenders;
    }  
        int targetStageId,  
 * this file be licensed under the Apache-2.0 license or a
        out.writeVInt(rightExpectedSenders);
    }
    }  
