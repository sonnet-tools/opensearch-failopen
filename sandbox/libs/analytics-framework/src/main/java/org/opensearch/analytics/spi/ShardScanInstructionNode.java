     */  
 */  
    public ShardScanInstructionNode(StreamInput in) throws IOException {  
    public InstructionType type() {
import org.opensearch.core.common.io.stream.Writeable;  
 * query referenced), captured on the coordinator from the {@code OpenSearchTableScan} leaf. The  
    }
        this(false, null);
    /**
    // requestsRowIds is upstream's param; logicalTableName is our feature-branch addition, appended last.  
 * {@code null} when unknown (e.g. backend self-constructed nodes in tests); the data-node handler  
        this(requestsRowIds, null);  
 * {@link ShardScanWithDelegationInstructionNode} so the same flag applies whether or not
 * emit shard-global {@code __row_id__} values (QTF query phase). Inherited by
 * @opensearch.internal  
 * backend registers the per-shard table under this name so the Substrait plan's {@code NamedTable}
    public ShardScanInstructionNode(boolean requestsRowIds) {
 */
import java.io.IOException;
        out.writeOptionalString(logicalTableName);
 *
    public boolean requestsRowIds() {
 * Instruction node for base shard scan setup — reader acquisition, SessionContext creation,
 * falls back to the concrete shard index name in that case.
    }  
}
        out.writeBoolean(requestsRowIds);
    public void writeTo(StreamOutput out) throws IOException {  
    public String getLogicalTableName() {
    }  
 *
        return logicalTableName;
 * compatible open source license.
 * table provider registration. {@code requestsRowIds} signals that the shard scan needs to  
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
    }  
    }  
 * <p>Carries the planner's <em>logical</em> table name (the alias / index-pattern / index the
    }
        this.requestsRowIds = in.readBoolean();
    private final String logicalTableName;
    private final boolean requestsRowIds;
     * if unknown. The backend registers the scanned shard's table under this name so the Substrait
        this.logicalTableName = in.readOptionalString();
    }
        this.logicalTableName = logicalTableName;
        this.requestsRowIds = requestsRowIds;  
    public ShardScanInstructionNode() {
    }  
     * plan's {@code NamedTable} binds.
    @Override  
/**
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
package org.opensearch.analytics.spi;
        return requestsRowIds;  
 * filter delegation is in play — QTF and delegation are orthogonal concerns.  
 * reference binds, regardless of which concrete shard index is actually being scanned. May be
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
        return InstructionType.SETUP_SHARD_SCAN;
public class ShardScanInstructionNode implements InstructionNode, Writeable {
     * The logical table name (alias / index pattern / index) the query referenced, or {@code null}  
 * The OpenSearch Contributors require contributions made to  
    public ShardScanInstructionNode(boolean requestsRowIds, String logicalTableName) {
