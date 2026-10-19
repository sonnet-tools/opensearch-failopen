    /**
    FULL_REPLICATION,  
     */
     * primary term validation only. The request is not replicated logically.  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
    /**
    PRIMARY_TERM_VALIDATION,
     * the replica shard along with primary term validation.
@PublicApi(since = "2.4.0")
import org.opensearch.common.annotation.PublicApi;
     * In short, this mode would replicate the {@link ReplicationRequest} to  
     * In this mode, a {@code TransportReplicationAction} is fanned out to underlying concerned shard and is replicated logically.
     */
 * this file be licensed under the Apache-2.0 license or a
 */
/**  
     * In this mode, a {@code TransportReplicationAction} is fanned out to underlying concerned shard and used for
    /**  
     */
 * compatible open source license.
 *
     * In this mode, a {@code TransportReplicationAction} does not fan out to the underlying concerned shard.
/*  
 */  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.support.replication;
    NO_REPLICATION;  
 * The type of replication used for inter-node replication.
 *
}
public enum ReplicationMode {  
