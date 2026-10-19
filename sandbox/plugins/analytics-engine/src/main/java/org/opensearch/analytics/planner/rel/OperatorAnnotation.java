    int getAnnotationId();  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
 */  
    RexNode withAdaptedOriginal(RexNode adaptedOriginal);
 * SPDX-License-Identifier: Apache-2.0
        throw new UnsupportedOperationException("makePlaceholder not implemented for " + getClass().getSimpleName());
/*  
 * Common interface for all annotation types (predicate, aggregate call,
/**  
     * Returns a placeholder RexNode for this annotation when delegated.
    /** Returns a copy of this annotation with viableBackends narrowed to the given backend. */
    RexNode unwrap();
    default RexNode makePlaceholder(RexBuilder rexBuilder) {  
    /** Returns the original unwrapped expression with annotation removed. */
     * predicates return BOOLEAN, project expressions return their original type, etc.
 *
    /**
import org.apache.calcite.rex.RexBuilder;
 * @opensearch.internal
 */  
     * Each annotation type produces the appropriate placeholder shape:  
 * project expression). Allows PlanForker to work generically without
    /** Returns a copy of this annotation wrapping a different (adapted) inner expression. */
package org.opensearch.analytics.planner.rel;
     */
    OperatorAnnotation narrowTo(String backend);
    List<String> getViableBackends();
 * this file be licensed under the Apache-2.0 license or a
 * knowing the specific annotation type.  
 * compatible open source license.
public interface OperatorAnnotation {
}  
import org.apache.calcite.rex.RexNode;
    }
 *
