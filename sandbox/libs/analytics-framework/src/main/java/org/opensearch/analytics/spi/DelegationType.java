/*  
/**
 */
 * Types of work that can be delegated between backends.
 * to offload filter predicates to another backend.  
 *  
 * @opensearch.internal  
 * physical operator that can call into Analytics Core's delegation API
 * The OpenSearch Contributors require contributions made to  
 * <p>A backend declares {@code canAcceptDelegation(FILTER)} if it can
    /** Delegate doc value reads → receive a VectorSchemaRoot. */
    /** Delegate an aggregate function (e.g. painless) → receive aggregated result. */
package org.opensearch.analytics.spi;
public enum DelegationType {
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
    PROJECT
    /** Delegate a filter predicate → receive a bitset of matching docIds. */  
    /** Delegate a projection expression (e.g. painless script, highlighting) → receive projected columns. */  
    SCAN,  
 * receive a delegated filter request (e.g. a serialized QueryBuilder)  
 * and return results (e.g. a bitset of matching docIds).
    FILTER,
 * compatible open source license.
}
 * this file be licensed under the Apache-2.0 license or a
 *
 *
 * <p>A backend declares {@code canDelegate(FILTER)} if it has a custom
    AGGREGATE,
