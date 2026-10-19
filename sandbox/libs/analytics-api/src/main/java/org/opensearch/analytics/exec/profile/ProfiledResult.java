 *
    public boolean isSuccess() {
 * @param profile per-stage + per-task profile snapshot, never null
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
package org.opensearch.analytics.exec.profile;
 * SPDX-License-Identifier: Apache-2.0
 * @param rows    materialised query result rows, or null if the query failed  
 * @param failure the cause if the query failed, or null on success
 */  
        return failure == null;  
 * this file be licensed under the Apache-2.0 license or a
}
 * {@code DefaultPlanExecutor.executeWithProfile} on <b>every</b> terminal path —  
    }
 * success and failure — so callers always receive the profile regardless of outcome.
 */  
/*  
public record ProfiledResult(Iterable<Object[]> rows, Throwable failure, QueryProfile profile) {
/**
 * Pair of query result rows and the captured {@link QueryProfile}. Returned by
