            expressions.add(new DelegatedExpression(in));
import org.opensearch.core.common.io.stream.StreamInput;
    }
        out.writeEnum(treeShape);
        for (int i = 0; i < count; i++) {
    }
import java.util.ArrayList;  
        int count = in.readVInt();
    }
/*  
        for (DelegatedExpression expr : delegatedExpressions) {
import org.opensearch.core.common.io.stream.StreamOutput;
        return expressions;
    @Override  
    implements
    public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.analytics.spi;
        }  
        Writeable {  
 * SPDX-License-Identifier: Apache-2.0
        List<DelegatedExpression> expressions = new ArrayList<>(count);  
/**  
 * between accepting and driving backends at the data node.  
        }
 */  
import java.io.IOException;
            expr.writeTo(out);  
 *
 * The OpenSearch Contributors require contributions made to  
        out.writeVInt(delegatedPredicateCount);  
 */  
 *
public record DelegationDescriptor(FilterTreeShape treeShape, int delegatedPredicateCount, List<DelegatedExpression> delegatedExpressions)
 * @opensearch.internal
 * compatible open source license.
import org.opensearch.core.common.io.stream.Writeable;  
 * alongside the instruction list so that Core can orchestrate the handle exchange
import java.util.List;
        this(in.readEnum(FilterTreeShape.class), in.readVInt(), readExpressions(in));  
 * Describes the delegation metadata for a plan alternative. Carried on the wire
}  
    public DelegationDescriptor(StreamInput in) throws IOException {
    private static List<DelegatedExpression> readExpressions(StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        out.writeVInt(delegatedExpressions.size());
