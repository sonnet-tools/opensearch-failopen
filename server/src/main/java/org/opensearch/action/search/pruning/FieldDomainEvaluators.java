    }
    /**
     */
    /**  
        }
        Objects.requireNonNull(domain, "domain must not be null");
                return false;
    public boolean canMatch(FieldDomain domain, QueryConstraint constraint, FieldDomainEvaluationContext context) {  
 */
        }
        if (domain.finalized() == false || domain.field().equals(constraint.field()) == false) {
}
     * @return {@code false} if any evaluator proves the pair is disjoint; otherwise {@code true}
package org.opensearch.action.search.pruning;
import org.opensearch.index.fielddomain.FieldDomain;
     *  
    }
/*  
import java.util.Objects;
 *
        this.evaluators = List.copyOf(evaluators);  
        Objects.requireNonNull(constraint, "constraint must not be null");
            return true;  
     * @param evaluators evaluators to run for each field-domain/constraint pair
    public static FieldDomainEvaluators defaultEvaluators() {  
        return true;  
            }  
            if (evaluator.canMatch(domain, constraint, context) == false) {
        return DEFAULT;
/**  
        for (FieldDomainEvaluator evaluator : evaluators) {  
public final class FieldDomainEvaluators {
 * compatible open source license.
    /**
 * SPDX-License-Identifier: Apache-2.0
        Objects.requireNonNull(evaluators, "evaluators must not be null");
     * Returns the built-in evaluator collection.
    }
    public FieldDomainEvaluators(List<FieldDomainEvaluator> evaluators) {
    private static final FieldDomainEvaluators DEFAULT = new FieldDomainEvaluators(List.of(new DateRangeFieldDomainEvaluator()));
     */
 * The collection keeps pruning conservative by treating "no evaluator can prune" as "the index may match".  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 */  
        Objects.requireNonNull(context, "context must not be null");  
     */  
    private final List<FieldDomainEvaluator> evaluators;  
import java.util.List;  
 *
 * Ordered collection of field-domain evaluators.
     *
     * Returns whether an index with the supplied bounds may match the supplied query constraint.
     * Creates an evaluator collection.  
