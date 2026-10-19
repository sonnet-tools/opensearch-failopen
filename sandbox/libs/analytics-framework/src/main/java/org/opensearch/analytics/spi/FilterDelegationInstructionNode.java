package org.opensearch.analytics.spi;
 *
 *
    public FilterDelegationInstructionNode(
import org.opensearch.core.common.io.stream.StreamOutput;
        return delegatedQueries;
    ) {
        this.delegatedPredicateCount = delegatedPredicateCount;
}
        return treeShape;  
    }  
/*  
 * Instruction node for filter delegation to an index backend.
import org.opensearch.core.common.io.stream.StreamInput;
    public List<DelegatedExpression> getDelegatedQueries() {
    }  
 * Carries the tree shape, predicate count, and serialized delegated queries.  
    private final int delegatedPredicateCount;
    }  
    private final FilterTreeShape treeShape;  
        this.delegatedQueries = in.readList(DelegatedExpression::new);
 */  
        FilterTreeShape treeShape,
        List<DelegatedExpression> delegatedQueries
        this.delegatedPredicateCount = in.readInt();
    public FilterTreeShape getTreeShape() {
 * this file be licensed under the Apache-2.0 license or a
        out.writeInt(delegatedPredicateCount);
    }
 * compatible open source license.
public class FilterDelegationInstructionNode implements InstructionNode {
    @Override
    @Override
        out.writeCollection(delegatedQueries);
        return delegatedPredicateCount;
/**
    public int getDelegatedPredicateCount() {  
        out.writeEnum(treeShape);  
    private final List<DelegatedExpression> delegatedQueries;
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
    public void writeTo(StreamOutput out) throws IOException {
 * The OpenSearch Contributors require contributions made to  
    public InstructionType type() {  
        this.delegatedQueries = delegatedQueries;
    }  
        int delegatedPredicateCount,  
    }
        this.treeShape = treeShape;  
        this.treeShape = in.readEnum(FilterTreeShape.class);  
    public FilterDelegationInstructionNode(StreamInput in) throws IOException {
        return InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION;
import java.io.IOException;
 * @opensearch.internal
    }
 */  
