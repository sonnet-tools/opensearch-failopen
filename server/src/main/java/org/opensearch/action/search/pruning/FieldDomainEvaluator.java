 *
import org.opensearch.index.fielddomain.FieldDomain;
     * domain or constraint types must return true.  
     * @return {@code true} when the index may match, {@code false} only when it is safe to prune
/**  
     * @param domain index-level field domain
public interface FieldDomainEvaluator {
 * SPDX-License-Identifier: Apache-2.0
 * request. The evaluator knows how to interpret both for a particular domain/constraint combination. For example, a
     * @param context request-scoped evaluation context
 * this file be licensed under the Apache-2.0 license or a
 * A field domain by itself is only metadata, and a query constraint by itself is only a requirement from the search  
    /**  
 */  
 * Type-specific component that compares an index-side {@link FieldDomain} with a query-side {@link QueryConstraint}.
package org.opensearch.action.search.pruning;
 * whether the query range intersects the index's date range.  
 */
 * Evaluators are part of the pruning correctness boundary. They must be conservative: returning {@code false} means
}
 * The OpenSearch Contributors require contributions made to  
 *
     * @param constraint mandatory query constraint for the same field  
     */  
 * compatible open source license.
     *
     * Returns true when the index may contain matches for the query constraint.
/*  
 * "this index cannot match"; returning {@code true} means "this index may match, or I cannot prove otherwise".  
 * date-range evaluator can parse date math in a range query, normalize it to the domain's resolution, and decide
     * Returning false means the index is provably disjoint and may be pruned. Unsupported
    boolean canMatch(FieldDomain domain, QueryConstraint constraint, FieldDomainEvaluationContext context);
 *
