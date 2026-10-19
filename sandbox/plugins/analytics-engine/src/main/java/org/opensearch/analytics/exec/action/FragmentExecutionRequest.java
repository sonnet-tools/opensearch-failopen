 * <p>Each {@link PlanAlternative} represents a backend-specific serialized plan produced by  
        }  
            out.writeString(backendId);  
        for (PlanAlternative alt : planAlternatives) {
        private final String backendId;  
        out.writeVInt(planAlternatives.size());  
        public void writeTo(StreamOutput out) throws IOException {
            for (InstructionNode node : instructions) {  
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import org.opensearch.analytics.spi.InstructionType;  
        this.shardId = shardId;  
    public ShardId getShardId() {  
        return shardId;
            this(backendId, fragmentBytes, instructions, null);  
            }  
        this.planAlternatives = planAlternatives;
        this.queryId = in.readString();
 */  
            return backendId;
 */
    }
                node.writeTo(out);
import org.opensearch.core.tasks.TaskId;
        this.profile = in.readBoolean();  
import org.opensearch.analytics.spi.InstructionNode;
        private final List<InstructionNode> instructions;
    public String getQueryId() {
import org.opensearch.core.common.io.stream.StreamInput;
        public PlanAlternative(  
 * Transport request carrying plan fragment alternatives to a data node for shard-level execution.
import org.opensearch.action.ActionRequest;
    @Override  
    private final ShardId shardId;
    @Override  
            this.instructions = instructions;
 * SPDX-License-Identifier: Apache-2.0
        super.writeTo(out);
        return planAlternatives;
            if (delegationDescriptor != null) {
                out.writeEnum(node.type());
        return stageId;  
     * Produced by {@code FragmentConversionDriver.convertAll()} using the backend's
 * compatible open source license.
}
import org.opensearch.action.ActionRequestValidationException;
        for (int i = 0; i < numAlternatives; i++) {  
        return profile;  
import java.util.ArrayList;
    }
            out.writeByteArray(fragmentBytes != null ? fragmentBytes : new byte[0]);
        }  
        public byte[] getFragmentBytes() {
        ) {
        this(queryId, stageId, shardId, planAlternatives, false);  
    }
            int instructionCount = in.readVInt();
        return queryId;
        public List<InstructionNode> getInstructions() {
    }  
import java.util.Map;
     * and ordered instruction nodes for data-node execution.
            this.instructions = nodes;
            alt.writeTo(out);
        this.stageId = stageId;
            List<InstructionNode> instructions,  
    }
            return fragmentBytes;
        this.shardId = new ShardId(in);  
        }
 *
    }  
            String backendId,
 * @opensearch.internal
    public List<PlanAlternative> getPlanAlternatives() {
    @Override  
                out.writeBoolean(true);
    }
     * {@code FragmentConvertor}.  
                out.writeBoolean(false);
    public FragmentExecutionRequest(String queryId, int stageId, ShardId shardId, List<PlanAlternative> planAlternatives, boolean profile) {  
            return instructions;  
        String desc = "queryId[" + queryId + "] stageId[" + stageId + "] shardId[" + shardId + "]";
import java.io.IOException;
        return new AnalyticsShardTask(id, type, action, desc, parentTaskId, headers);  
 *  
    private final List<PlanAlternative> planAlternatives;
 * {@code FragmentConversionDriver}. The data node selects the best alternative based on
            planAlternatives.add(new PlanAlternative(in));
        this.planAlternatives = new ArrayList<>(numAlternatives);
import org.opensearch.analytics.exec.task.AnalyticsShardTask;  
    public FragmentExecutionRequest(String queryId, int stageId, ShardId shardId, List<PlanAlternative> planAlternatives) {
            this.backendId = backendId;  
import org.opensearch.core.index.shard.ShardId;  
    private final String queryId;
        int numAlternatives = in.readVInt();
import org.opensearch.analytics.spi.DelegationDescriptor;
        this.queryId = queryId;
    public static class PlanAlternative {
            List<InstructionNode> nodes = new ArrayList<>(instructionCount);
public class FragmentExecutionRequest extends ActionRequest implements ShardInvocationRequest {  
    }
        out.writeInt(stageId);
            this.delegationDescriptor = in.readBoolean() ? new DelegationDescriptor(in) : null;
        private final byte[] fragmentBytes;
 * The OpenSearch Contributors require contributions made to  
    }  
        return null;
    }  
    private final int stageId;  
    public int getStageId() {
import org.opensearch.core.common.io.stream.StreamOutput;
            this.backendId = in.readString();
import java.util.List;  
        public PlanAlternative(StreamInput in) throws IOException {  
package org.opensearch.analytics.exec.action;
        public PlanAlternative(String backendId, byte[] fragmentBytes, List<InstructionNode> instructions) {
        out.writeString(queryId);  
        private final DelegationDescriptor delegationDescriptor;  
            }  
    /**
        this.profile = profile;
        }
            DelegationDescriptor delegationDescriptor
 * this file be licensed under the Apache-2.0 license or a
        }
            }  
     * A single plan alternative: a backend ID paired with its serialized fragment bytes  
    }  
     */
 *
import org.opensearch.tasks.Task;
    public FragmentExecutionRequest(StreamInput in) throws IOException {
    public ActionRequestValidationException validate() {
        }
            } else {
        }  
        }
/*  
            for (int i = 0; i < instructionCount; i++) {  
    public boolean profile() {
        }
    public void writeTo(StreamOutput out) throws IOException {
                nodes.add(type.readNode(in));
        shardId.writeTo(out);
            byte[] bytes = in.readByteArray();
            this.delegationDescriptor = delegationDescriptor;  
            this.fragmentBytes = fragmentBytes;
                delegationDescriptor.writeTo(out);  
        super(in);  
            byte[] fragmentBytes,
        }
        public DelegationDescriptor getDelegationDescriptor() {  
            out.writeVInt(instructions.size());
    }
 * available backend capabilities.
            this.fragmentBytes = (bytes.length == 0) ? null : bytes;  
                InstructionType type = in.readEnum(InstructionType.class);
    private final boolean profile;  
        out.writeBoolean(profile);
/**  
        this.stageId = in.readInt();
        public String getBackendId() {  
            return delegationDescriptor;
