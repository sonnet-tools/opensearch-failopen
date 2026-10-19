 * this work for additional information regarding copyright
        return canAllocate(shardRouting, node, allocation);
        // if so, we don't want to force the primary allocation here
import org.opensearch.cluster.metadata.IndexMetadata;
 * not use this file except in compliance with the License.
                );  
        final UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
        Setting.Property.Dynamic,
                );
 */
                    "shard has failed allocating [%d] times but [%d] retries are allowed",
 * An allocation decider that prevents shards from being allocated on any node if the shards allocation has been retried N times without  
 * license agreements. See the NOTICE file distributed with
                decision = allocation.decision(
        }  
 * Unless required by applicable law or agreed to in writing,
        return canAllocate(shardRouting, allocation);  
 */  
        final Decision decision;  
 * GitHub history for details.
        assert shardRouting.primary() : "must not call canForceAllocatePrimary on a non-primary shard " + shardRouting;
        if (unassignedInfo != null && unassignedInfo.getNumFailedAllocations() > 0) {
 * ownership. Elasticsearch licenses this file to you under  
                    maxRetry,
    );
                    Decision.YES,  
 * software distributed under the License is distributed on an
        0,
 * success. This means if a shard has been INITIALIZING N times in a row without being moved to STARTED the shard will be ignored until
                    NAME,
import org.opensearch.common.settings.Setting;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Setting.Property.NotCopyableOnResize
            }  
 * specific language governing permissions and limitations
                    "shard has exceeded the maximum number of retries [%d] on "
/*
            final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
        5,  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            decision = allocation.decision(Decision.YES, NAME, "shard has no previous failures");
                    Decision.NO,  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        Setting.Property.IndexScope,  
}
    }
/*  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.cluster.routing.allocation.decider;
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *
/**
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    public static final Setting<Integer> SETTING_ALLOCATION_MAX_RETRY = Setting.intSetting(
public class MaxRetryAllocationDecider extends AllocationDecider {
 * KIND, either express or implied.  See the License for the
            if (unassignedInfo.getNumFailedAllocations() >= maxRetry) {
import org.opensearch.cluster.routing.RoutingNode;
 * SPDX-License-Identifier: Apache-2.0
        } else {
        // check if we have passed the maximum retry threshold through canAllocate,  
 * under the License.  
    }  
                        + "failed allocation attempts - manually call [/_cluster/reroute?retry_failed=true] to retry, [%s]",  
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
                    NAME,
 *
 * compatible open source license.
            } else {
 * @opensearch.internal  
    public static final String NAME = "max_retry";
    }
 */
 * the setting for {@code index.allocation.max_retry} is raised. The default value is {@code 5}.
import org.opensearch.cluster.routing.UnassignedInfo;
        return decision;
                    unassignedInfo.toString()
                decision = allocation.decision(
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 * API is manually invoked. This allows single retries without raising the limits.
                    unassignedInfo.getNumFailedAllocations(),  
    @Override  
 *
            final int maxRetry = SETTING_ALLOCATION_MAX_RETRY.get(indexMetadata.getSettings());  
    @Override  
 * Note: This allocation decider also allows allocation of repeatedly failing shards when the {@code /_cluster/reroute?retry_failed=true}  
        "index.allocation.max_retries",
import org.opensearch.cluster.routing.ShardRouting;  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                    maxRetry
    @Override
/*  
