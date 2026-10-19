    /** Single-shard — no split needed, full aggregation in one pass. */
 * SPDX-License-Identifier: Apache-2.0
    SINGLE  
    FINAL,
 */  
 */
package org.opensearch.analytics.planner.rel;
/**
 *  
/*  
 * compatible open source license.
public enum AggregateMode {  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
    /** Final aggregation at coordinator (merges partial states). */  
    /** Partial aggregation at data nodes (emits intermediate state). */
 *
}
 * The OpenSearch Contributors require contributions made to  
 * Aggregate execution mode for distributed query execution.
    PARTIAL,
