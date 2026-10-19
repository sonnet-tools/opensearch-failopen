 * and {@link FetchByRowIdsRequest}; lets shared infrastructure (failure-listener wrapping,  
public interface ShardInvocationRequest {
 */
import org.opensearch.core.index.shard.ShardId;
}
package org.opensearch.analytics.exec.action;
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
 *
/**  
 * SPDX-License-Identifier: Apache-2.0
    String getQueryId();  
    ShardId getShardId();
 */  
    int getStageId();
 * Cross-cutting shape for any shard-targeted analytics action: identifies the originating
 * query, the stage, and the target shard. Implemented by {@link FragmentExecutionRequest}
 * compatible open source license.
/*  
 * resource accounting, logging) operate on either request type without an instanceof check.
 *
 * The OpenSearch Contributors require contributions made to  
