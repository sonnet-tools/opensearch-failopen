 *
/**
 * @opensearch.internal
import org.opensearch.analytics.spi.DelegatedExpression;
    }  
    }  
 *                                   the parent stage's input decorator widens this stage's wire schema;
 * @param convertedBytes             backend-specific serialized plan bytes (null before conversion)
 * compatible open source license.
/*  
    public StagePlan withConvertedBytes(byte[] bytes, List<DelegatedExpression> delegatedExpressions) {  
    /** Creates a StagePlan before conversion (bytes not yet available). */  
 * @param instructions               ordered instruction nodes for data-node execution (empty before resolution)  
    }
        return new StagePlan(resolvedFragment, backendId, convertedBytes, delegatedExpressions, instructions, postDecorationSchemaBytes);  
 * this file be licensed under the Apache-2.0 license or a
 *                                   {@code null} when the producer's schema is already authoritative.  
    /** Returns a copy with post-decoration schema bytes populated. */  
 * @param resolvedFragment           fragment with all viableBackends narrowed to single choices
    public StagePlan withInstructions(List<InstructionNode> instructions) {
        return new StagePlan(resolvedFragment, backendId, bytes, delegatedExpressions, List.of(), postDecorationSchemaBytes);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.FragmentConvertor;  
 * the backend's {@link FragmentConvertor}.  
 */
 * where every operator's viableBackends and every annotation's viableBackends
}
    }
    public StagePlan withPostDecorationSchemaBytes(byte[] bytes) {
        return new StagePlan(resolvedFragment, backendId, convertedBytes, delegatedExpressions, instructions, bytes);
 * @param backendId                  the primary backend for this plan  
 * The OpenSearch Contributors require contributions made to  
    /** Returns a copy with instructions populated. */
public record StagePlan(RelNode resolvedFragment, String backendId, byte[] convertedBytes, List<DelegatedExpression> delegatedExpressions,  
import java.util.List;  
 * are narrowed to exactly one backend, plus the converted bytes produced by
 * A single plan alternative for a {@link Stage}. Contains a resolved fragment  
 * @param delegatedExpressions       serialized delegated expressions (empty if no delegation)
    List<InstructionNode> instructions, byte[] postDecorationSchemaBytes) {
package org.opensearch.analytics.planner.dag;
 * @param postDecorationSchemaBytes  schema-only Read taking precedence over {@code convertedBytes} when
        this(resolvedFragment, backendId, null, List.of(), List.of(), null);
 */  
    /** Returns a copy with converted bytes and delegated expressions populated. */
import org.opensearch.analytics.spi.InstructionNode;
    public StagePlan(RelNode resolvedFragment, String backendId) {
 *
import org.apache.calcite.rel.RelNode;
