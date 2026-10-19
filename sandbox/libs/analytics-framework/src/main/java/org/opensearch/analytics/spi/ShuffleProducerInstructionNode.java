        return targetStageId;
    public int getPartitionCount() {
 * worker side's {@code ShuffleBuffer} tracks per-side completion.
        this.targetWorkerNodeIds = List.copyOf(targetWorkerNodeIds);
    public String getQueryId() {  
    public String getSide() {
        this.hashKeyChannels = List.copyOf(hashKeyChannels);
    }
    private final int partitionCount;  
/**  
 * SPDX-License-Identifier: Apache-2.0
        int targetStageId,
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
        this.hashKeyChannels = Collections.unmodifiableList(keys);
        return partitionCount;
        this.side = in.readString();  
 */  
        out.writeString(side);  
    public ShuffleProducerInstructionNode(StreamInput in) throws IOException {
        return hashKeyChannels;
    public ShuffleProducerInstructionNode(  
import java.io.IOException;
 *  
    }  
public class ShuffleProducerInstructionNode implements InstructionNode {  
        String queryId,
        this.queryId = in.readString();
        return InstructionType.SHUFFLE_PRODUCER;
        this.side = side;
    ) {
    public void writeTo(StreamOutput out) throws IOException {  
 *  
    public InstructionType type() {
 * compatible open source license.
 * <p>{@code queryId} and {@code targetStageId} key the worker-side shuffle buffer so senders and
 *
 * the consumer meet at the same buffer.
        this.targetWorkerNodeIds = in.readStringList();  
/*  
    public int getTargetStageId() {
 */
    }
        this.partitionCount = in.readVInt();
        String side  
        out.writeVInt(hashKeyChannels.size());
    public List<String> getTargetWorkerNodeIds() {
    }
import java.util.List;
        this.targetStageId = in.readVInt();
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
        }  
 * Instruction for a hash-shuffle producer: hash-partition this data-node's local scan output by
        this.partitionCount = partitionCount;  
            keys.add(in.readVInt());
    private final String side;
        return targetWorkerNodeIds;  
        out.writeString(queryId);
    }
        int keyCount = in.readVInt();
    private final List<String> targetWorkerNodeIds;
    }
package org.opensearch.analytics.spi;
        }
    private final int targetStageId;  
        int partitionCount,
        out.writeVInt(partitionCount);
        out.writeVInt(targetStageId);
 * tag ({@code "left"} / {@code "right"}) distinguishes which join input this producer feeds; the
import java.util.ArrayList;
 * {@code hashKeyChannels} into {@code partitionCount} buckets, then ship bucket {@code i} to the
 * worker at {@code targetWorkerNodeIds[i]} via {@code AnalyticsShuffleDataAction}. The {@code side}  
        List<Integer> keys = new ArrayList<>(keyCount);  
    private final List<Integer> hashKeyChannels;
            out.writeVInt(key);  
    }  
    @Override  
        for (int key : hashKeyChannels) {
    private final String queryId;
        for (int i = 0; i < keyCount; i++) {
    }  
        out.writeStringCollection(targetWorkerNodeIds);  
        return side;  
        List<String> targetWorkerNodeIds,  
    @Override
}
    }
        this.targetStageId = targetStageId;  
        return queryId;
import java.util.Collections;  
 * The OpenSearch Contributors require contributions made to  
        List<Integer> hashKeyChannels,
        this.queryId = queryId;
    }
    public List<Integer> getHashKeyChannels() {  
