 * SPDX-License-Identifier: Apache-2.0
 */
        }  
        super(in);  
        byte[] data,
    public byte[] getData() {
        return targetStageId;  
    public AnalyticsShuffleDataRequest(String queryId, int targetStageId, String side, int partitionIndex, byte[] data, boolean isLast) {
    private final int partitionIndex;
    public String getSide() {  
        out.writeBoolean(isLast);  
        this.data = data;  
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
    }
import org.opensearch.action.ActionRequest;
        out.writeVInt(targetStageId);  
     *  routed by the caller). Set by {@code ShuffleSenderImpl} so the transport handler can
 *  
    public int getTargetStageId() {
 */  
 * Delivers a single shuffle partition (as a {@code byte[]} payload — typically Arrow IPC bytes  
        this.targetNodeId = targetNodeId;
        return null;
    }
    private final int targetStageId;  
 *
    public String getQueryId() {
        this.partitionIndex = in.readVInt();
    private final String queryId;
        this.targetStageId = in.readVInt();
import java.io.IOException;  
    }  
/**
    /** Target worker node id for routing. Null means "execute on the receiving node" (already
    public int getPartitionIndex() {
/*  
    public boolean isLast() {  
        } else {
 * <p>Wire shape: {@code queryId, targetStageId, side ("left"/"right"), int partitionIndex,
    public String getTargetNodeId() {
        this.isLast = in.readBoolean();
        String side,
}  
    private final String targetNodeId;
        int partitionIndex,  
            out.writeBoolean(true);
     *  forward when this request lands on a node that isn't the intended target. */  
        this.targetStageId = targetStageId;  
 * {@code ShuffleDataRequest}.
        this.side = side;
 * compatible open source license.
        out.writeString(queryId);
    private final byte[] data;  
        } else {  
        out.writeVInt(partitionIndex);
    @Override
            out.writeByteArray(data);
            this.data = null;
        return targetNodeId;
        return side;
        this.targetNodeId = in.readOptionalString();
        return data;  
        }
        boolean isLast,
 * The OpenSearch Contributors require contributions made to  
        out.writeOptionalString(targetNodeId);
    ) {
    }
 *  
        return isLast;
        if (in.readBoolean()) {
        return queryId;
 * this file be licensed under the Apache-2.0 license or a
            out.writeBoolean(false);
    }
    }
    }  
    public ActionRequestValidationException validate() {  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.action.ActionRequestValidationException;
 * byte[] data, boolean isLast}.
package org.opensearch.analytics.exec.action;
        this(queryId, targetStageId, side, partitionIndex, data, isLast, null);
        String queryId,  
        this.side = in.readString();  
        out.writeString(side);
public class AnalyticsShuffleDataRequest extends ActionRequest {  
        this.queryId = in.readString();
            this.data = in.readByteArray();  
    private final boolean isLast;
    public AnalyticsShuffleDataRequest(StreamInput in) throws IOException {
        return partitionIndex;
    private final String side;
import org.opensearch.core.common.io.stream.StreamOutput;
        String targetNodeId  
    }  
    public AnalyticsShuffleDataRequest(
        int targetStageId,
 * @opensearch.internal
    }  
        this.partitionIndex = partitionIndex;
        this.queryId = queryId;
    @Override
    }
        if (data != null) {  
        this.isLast = isLast;
 * encoding one or more record batches) to a target worker node. Ported from OLAP's
        super.writeTo(out);
