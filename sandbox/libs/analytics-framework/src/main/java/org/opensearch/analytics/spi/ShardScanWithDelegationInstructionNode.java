 * SPDX-License-Identifier: Apache-2.0
 *
        super(requestsRowIds, logicalTableName);
package org.opensearch.analytics.spi;
        this.delegatedPredicateCount = in.readVInt();  
public class ShardScanWithDelegationInstructionNode extends ShardScanInstructionNode {
    public void writeTo(StreamOutput out) throws IOException {  
    // treeShape/delegatedPredicateCount/requestsRowIds are upstream's params; logicalTableName is our
    private final FilterTreeShape treeShape;
 */
import org.opensearch.core.common.io.stream.StreamOutput;
        return delegatedPredicateCount;
        out.writeEnum(treeShape);
 */  
 * in a single FFM call.
    }  
    public ShardScanWithDelegationInstructionNode(StreamInput in) throws IOException {  
    @Override  
        this.treeShape = treeShape;
    @Override
        FilterTreeShape treeShape,
}
    ) {  
    public ShardScanWithDelegationInstructionNode(
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        this.delegatedPredicateCount = delegatedPredicateCount;  
 * can configure its indexed execution path (UDF registration, IndexedTableProvider)  
 * compatible open source license.
    // feature-branch addition, appended last.  
 * @opensearch.internal  
        return InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION;
    }
    public int getDelegatedPredicateCount() {
        return treeShape;
/*  
        boolean requestsRowIds,
    }
        this.treeShape = in.readEnum(FilterTreeShape.class);
        out.writeVInt(delegatedPredicateCount);  
    public InstructionType type() {
 *
    public FilterTreeShape getTreeShape() {  
    public ShardScanWithDelegationInstructionNode(FilterTreeShape treeShape, int delegatedPredicateCount) {
 * Instruction node for shard scan with filter delegation — extends base shard scan
 * this file be licensed under the Apache-2.0 license or a
 * with {@link FilterTreeShape} and delegated predicate count so the driving backend
    }
        int delegatedPredicateCount,  
        String logicalTableName
/**  
    private final int delegatedPredicateCount;
    }  
    }  
        super(in);
    }
        super.writeTo(out);
        this(treeShape, delegatedPredicateCount, false, null);
