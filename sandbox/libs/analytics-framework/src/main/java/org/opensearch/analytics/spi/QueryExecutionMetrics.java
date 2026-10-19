 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 */
public record QueryExecutionMetrics(long currentBytes) {
 *
}  
/**
 *  
 */  
 * Snapshot of per-query execution metrics reported by an analytics backend.
/*  
 * @param currentBytes bytes currently reserved by the query's memory pool
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.analytics.spi;
 * The OpenSearch Contributors require contributions made to  
 *
 * is not repeated here — this record holds only the memory accounting fields.
 *  
 * @opensearch.internal  
 * <p>The context id (the map key in {@link AnalyticsSearchBackendPlugin#getTopQueriesByMemory()})
