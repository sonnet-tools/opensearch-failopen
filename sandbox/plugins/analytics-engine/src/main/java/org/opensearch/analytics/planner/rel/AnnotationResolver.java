 * of a filter condition tree. Classifies each node as delegated or native,
     * same-backend delegated siblings at mixed AND/OR boundaries into a single
/*  
 * Extended annotation resolver that performs single-pass bottom-up resolution  
    /**
 */
 * The OpenSearch Contributors require contributions made to  
public interface AnnotationResolver extends Function<OperatorAnnotation, RexNode> {  
 * this file be licensed under the Apache-2.0 license or a
 *  
import org.apache.calcite.rex.RexNode;
/**
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Function;  
}
 *
     * Resolves an entire condition tree in a single bottom-up pass. Combines  
package org.opensearch.analytics.planner.rel;
     * DelegatedExpression. Returns the fully resolved RexNode.
 * and combines same-backend delegated siblings at mixed boundaries.
     */  
 */  
    RexNode resolveTree(RexNode condition);
 * @opensearch.internal
 * compatible open source license.
