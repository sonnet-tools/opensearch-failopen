 * compatible open source license.
 * Backend-agnostic description of the boolean tree shape when filter delegation is active.
 * re-inspecting the Substrait plan.
    CONJUNCTIVE,  
     * mixes predicates from different backends under non-AND operators. Backend needs a  
    /**
    /** No delegation — all predicates handled natively by the driving backend. */  
     */
public enum FilterTreeShape {
 */
/**
 *
    INTERLEAVED_BOOLEAN_EXPRESSION  
}
     */
     * tree evaluator to combine bitsets from both backends per the boolean structure.
package org.opensearch.analytics.spi;
     * All predicates (delegated + native) are under a single AND — no interleaving  
     * Delegated and native predicates are interleaved under OR/NOT — the boolean tree
     * under OR/NOT. Backend can handle delegated bitsets and native predicates independently.
/*  
    NO_DELEGATION,
 * Provided by the planner so backends can choose their execution strategy without  
 */  
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to  
    /**
 * this file be licensed under the Apache-2.0 license or a
