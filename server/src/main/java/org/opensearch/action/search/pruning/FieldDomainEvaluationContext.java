 * Request-scoped context used while evaluating field domains against query constraints.
 * compatible open source license.
     */
import java.util.Objects;
    /**
     *  
    public LongSupplier nowInMillisSupplier() {
/**
        return nowInMillisSupplier;
     * Supplier for resolving date math expressions such as {@code now}.
        this.nowInMillisSupplier = Objects.requireNonNull(nowInMillisSupplier, "nowInMillisSupplier must not be null");
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * @param nowInMillisSupplier supplier for the search request's absolute start time in epoch milliseconds
public final class FieldDomainEvaluationContext {
     */  
    /**
import java.util.function.LongSupplier;
 */  
        return nowInMillisSupplier.getAsLong();  
/*  
     * Resolves the request's absolute start time in epoch milliseconds.  
    }  
 */  
 * The OpenSearch Contributors require contributions made to  
    }
    private final LongSupplier nowInMillisSupplier;
package org.opensearch.action.search.pruning;
 *
    public FieldDomainEvaluationContext(LongSupplier nowInMillisSupplier) {  
}
     * Creates an evaluation context.
    public long nowInMillis() {
    }
     */
    /**
