     * <p>{@code strippedChildren} follows the same ordering convention as
     * annotations, or a placeholder (e.g., {@code delegated_predicate(annotationId)}) for  
    }
     *
        return List.of();  
import java.util.List;  
 */  
    default RelNode stripAnnotations(List<RelNode> strippedChildren, Function<OperatorAnnotation, RexNode> annotationResolver) {  
     */  
     * Returns a clean standard Calcite RelNode with viableBackends dropped and
     * {@link FragmentConvertor}.  
import org.opensearch.analytics.spi.FieldStorageInfo;  
 *
     * use multiple entries.
 * the DAG to avoid reconstruction via {@link #copyResolved} and {@link #stripAnnotations}.
 *
     *
     * @param resolvedAnnotations  annotations narrowed to single backends, same order as {@link #getAnnotations()}
     */  
     * @param children             resolved child RelNodes
    RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations);
 * a single backend — avoids unnecessary copies during plan forking.  
    /** Per-column storage metadata aligned with this node's output row type field order. */
        return stripAnnotations(strippedChildren);
     * Creates a copy with viableBackends narrowed to the given backend and
    List<FieldStorageInfo> getOutputFieldStorage();
 * The OpenSearch Contributors require contributions made to  
     *
 * <p>TODO: when JMH benchmarks show RelNode copy/strip as a hotspot, consider
     * @param strippedChildren children already stripped
/*  
import org.apache.calcite.rel.RelNode;
    default List<OperatorAnnotation> getAnnotations() {
     * use {@code children.getFirst()}; future multi-input operators (Join) will  
 * compatible open source license.
 * preserving the original LogicalXxx fragment alongside the marked fragment through  
     * <p>Default delegates to {@link #stripAnnotations(List)} — correct for operators  
     *
 * Marker interface for all OpenSearch custom RelNodes that carry backend assignment
    List<String> getViableBackends();
}  
import org.opensearch.analytics.spi.FragmentConvertor;
     * @param annotationResolver  maps each annotation to its replacement RexNode
    /**  
public interface OpenSearchRelNode {
     *
 * and per-column storage metadata.
    RelNode stripAnnotations(List<RelNode> strippedChildren);
     * @param backend              the chosen backend for this operator  
 * SPDX-License-Identifier: Apache-2.0
     * with no annotations (Sort, Scan, ExchangeReducer, StageInputScan).
    /**  
     * The resolver decides per-annotation what to return: the unwrapped original for native
    /** Returns annotations inside this operator (predicates, calls, expressions). Empty if none. */
     * annotations replaced with the resolved versions.
     * delegated ones.
 *  
import org.apache.calcite.rex.RexNode;
 *
    }
 * <p>TODO: consider making this an abstract class storing {@code viableBackends} centrally,
import java.util.function.Function;
     * Returns a clean standard Calcite RelNode with annotations resolved via the given function.
     * annotations unwrapped to original expressions. Passed to the backend's
 * with a default {@link #copyResolved} that returns {@code this} when already narrowed to
     */
 */
package org.opensearch.analytics.planner.rel;
/**  
     * the node's inputs. Single-input operators (Filter, Aggregate, Sort)
    /**  
     * <p>{@code children} contains the resolved inputs in the same order as
    /** All backends that could execute this operator, including via delegation. */
 * @opensearch.internal  
     * @param strippedChildren    children already stripped  
 * this file be licensed under the Apache-2.0 license or a
     *  
     * {@code children} in {@link #copyResolved}.  
