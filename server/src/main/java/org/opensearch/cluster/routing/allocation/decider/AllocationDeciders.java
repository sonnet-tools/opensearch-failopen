            Decision decision = allocationDecider.canAllocate(indexMetadata, node, allocation);  
                if (logger.isTraceEnabled()) {
    @Override
        for (AllocationDecider allocationDecider : allocations) {
        return ret;  
            Decision decision = decider.canAllocateAnyShardToNode(node, allocation);  
                if (allocation.debugDecision() == false) {  
        return ret;
        Decision.Multi ret = new Decision.Multi();
        Decision.Multi ret = new Decision.Multi();  
        return ret;
        Decision.Multi ret = new Decision.Multi();
                }  
    }  
                logger.trace("Shard [{}] should be ignored for node [{}]", shardRouting, node.nodeId());  
                    return decision;
                if (logger.isTraceEnabled()) {  
                    logger.trace("Shard [{}] can not be moved away due to [{}]", shardRouting, decider.getClass().getSimpleName());
public class AllocationDeciders extends AllocationDecider {
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
        }
 * software distributed under the License is distributed on an
            if (decision.type().canPreemptivelyReturn()) {
                } else {
            if (decision == Decision.NO) {  
        Decision.Multi ret = new Decision.Multi();
            if (decision == Decision.NO) {
 * SPDX-License-Identifier: Apache-2.0
    public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {  
 * not use this file except in compliance with the License.
            }
                } else {
import org.opensearch.cluster.node.DiscoveryNode;
    public Decision canMoveAnyShard(RoutingAllocation allocation) {
                    logger.trace(
            } else {  
        return ret;
                } else {
                }  
                }
                    );
        }
            } else {  
        for (AllocationDecider allocationDecider : allocations) {  
                    return decision;  
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
    private final Collection<AllocationDecider> allocations;  
                        shardRouting,
    @Override  
                        allocationDecider.getClass().getSimpleName()
                        node.nodeId(),
import org.opensearch.cluster.routing.ShardRouting;  
 */  
            }
                addDecision(ret, decision, allocation);
        Decision.Multi ret = new Decision.Multi();
                addDecision(ret, decision, allocation);
        // We never add ALWAYS decisions and only add YES decisions when requested by debug mode (since Multi default is YES).
                } else {  
    }
        }  
    }  
            }
                if (logger.isTraceEnabled()) {  
        Decision.Multi ret = new Decision.Multi();
                }
        this.allocations = Collections.unmodifiableCollection(allocations);  
            Decision decision = decider.canMoveAway(shardRouting, allocation);  
        }
 * The OpenSearch Contributors require contributions made to  
        if (allocation.shouldIgnoreShardForNode(shardRouting.shardId(), node.nodeId())) {
        for (AllocationDecider decider : allocations) {
                if (allocation.debugDecision() == false) {
 * ownership. Elasticsearch licenses this file to you under  
        }
import java.util.Collection;
                    return decision;  
                    ret.add(decision);
            if (decision.type().canPreemptivelyReturn()) {  
        }  
            }
        }
/*  
                }
package org.opensearch.cluster.routing.allocation.decider;
        for (AllocationDecider allocationDecider : allocations) {
        Decision.Multi ret = new Decision.Multi();
                addDecision(ret, decision, allocation);  
                    ret.add(decision);  
        }
    }  
        Decision.Multi ret = new Decision.Multi();  
        Decision.Multi ret = new Decision.Multi();
                if (allocation.debugDecision() == false) {
                } else {
    }
        assert shardRouting.primary() : "must not call canForceAllocatePrimary on a non-primary shard routing " + shardRouting;
                if (logger.isTraceEnabled()) {
            Decision decision = allocationDecider.canAllocate(shardRouting, allocation);
    }  
                }
            // short track if a NO is returned.
        }
            } else {
 * A composite {@link AllocationDecider} combining the "decision" of multiple
                    return decision;  
                    ret.add(decision);
        }  
    @Override
                    );  
            // short track if a NO is returned.
        return ret;  
        if (allocation.shouldIgnoreShardForNode(shardRouting.shardId(), node.nodeId())) {
                    ret.add(decision);
                    return decision;
                    logger.trace(
        return ret;
                        shardRouting.shardId(),  
                addDecision(ret, decision, allocation);
                }  
import java.util.Collections;
                }
 * Unless required by applicable law or agreed to in writing,
                if (allocation.debugDecision() == false) {
import org.opensearch.cluster.metadata.IndexMetadata;  
                    );  
                    ret.add(decision);
    public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
        if (decision != Decision.ALWAYS  
 *
            }
                } else {  
                addDecision(ret, decision, allocation);
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            if (decision.type().canPreemptivelyReturn()) {
        return ret;
import org.apache.logging.log4j.LogManager;
            // short track if a NO is returned.
                        "Shard [{}] can not be forcefully allocated to node [{}] due to [{}].",
                    ret.add(decision);  
            }
        }  
                addDecision(ret, decision, allocation);
            // short track if a NO is returned.
                addDecision(ret, decision, allocation);  
            Decision decision = allocationDecider.canRebalance(allocation);  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            // short track if a NO is returned.  
        }
    }
 * license agreements. See the NOTICE file distributed with
                    logger.trace("Shard can not be allocated on node [{}] due to [{}]", node.nodeId(), decider.getClass().getSimpleName());  
            // short track if a NO is returned.
 * specific language governing permissions and limitations
                }  
        }  
            // short track if a NO is returned.  
        }  
            }  
            return Decision.NO;
 * KIND, either express or implied.  See the License for the
 */  
                    return decision;
    @Override  
 * @opensearch.api
                if (allocation.debugDecision() == false) {
        Decision.Multi ret = new Decision.Multi();
                    ret.add(decision);
                    logger.trace(  
    public Decision canMoveAway(ShardRouting shardRouting, RoutingAllocation allocation) {  
    }
                } else {  
        for (AllocationDecider allocationDecider : allocations) {
/*  
                addDecision(ret, decision, allocation);
            if (decision == Decision.NO) {
            }  
/*
    private void addDecision(Decision.Multi ret, Decision decision, RoutingAllocation allocation) {
                }
        return ret;
                    ret.add(decision);  
 */
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.cluster.routing.RoutingNode;
            }
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (AllocationDecider decider : allocations) {  
                } else {
            } else {
                if (allocation.debugDecision() == false) {
 * GitHub history for details.
            if (decision == Decision.NO) {
            } else {
                        shardRouting,  
            }  
                    return decision;
            if (decision == Decision.NO) {  
 * Modifications Copyright OpenSearch Contributors. See
    public Decision canRebalance(RoutingAllocation allocation) {  
            } else {
                        "Can not allocate [{}] on node [{}] due to [{}]",
            Decision decision = decider.canForceAllocatePrimary(shardRouting, node, allocation);  
            }  
    }
                }
                    return decision;  
            Decision decision = decider.canMoveAnyShard(allocation);
        for (AllocationDecider decider : allocations) {
    @Override  
            Decision decision = allocationDecider.shouldAutoExpandToNode(indexMetadata, node, allocation);
            Decision decision = allocationDecider.canRemain(shardRouting, node, allocation);  
 * this work for additional information regarding copyright
                } else {
            } else {
import org.apache.logging.log4j.Logger;
                }
            Decision decision = allocationDecider.canAllocate(shardRouting, node, allocation);
/**
        return ret;
                if (allocation.debugDecision() == false) {
                        allocationDecider.getClass().getSimpleName()
            if (decision == Decision.NO) {
        if (allocation.shouldIgnoreShardForNode(shardRouting.shardId(), node.nodeId())) {  
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "1.0.0")
}
                        node.node(),  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            return Decision.NO;
 * You may obtain a copy of the License at  
            // short track if a NO is returned.
        for (AllocationDecider allocationDecider : allocations) {  
                if (logger.isTraceEnabled()) {  
                }
                }  
        }
 *
    @Override
 * under the License.  
                if (allocation.debugDecision() == false) {
            if (decision == Decision.NO) {
            // short track if a NO is returned.
        for (AllocationDecider allocationDecider : allocations) {
    }
    public AllocationDeciders(Collection<AllocationDecider> allocations) {
                    ret.add(decision);
                    return decision;
 *  
            } else {
            }  
            } else {  
                    return decision;
                    ret.add(decision);
                if (allocation.debugDecision() == false) {  
            if (decision == Decision.NO) {
                        node.nodeId(),
                // short circuit only if debugging is not enabled
        Decision.Multi ret = new Decision.Multi();
        return ret;
                if (allocation.debugDecision() == false) {
                }  
            if (logger.isTraceEnabled()) {
                addDecision(ret, decision, allocation);  
                addDecision(ret, decision, allocation);
            && (allocation.getDebugMode() == RoutingAllocation.DebugMode.ON || decision.type() != Decision.Type.YES)) {
 * the Apache License, Version 2.0 (the "License"); you may
            return Decision.NO;
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    private static final Logger logger = LogManager.getLogger(AllocationDeciders.class);
    @Override  
        for (AllocationDecider allocationDecider : allocations) {
            } else {
            Decision decision = allocationDecider.canRebalance(shardRouting, allocation);
            // short track if a NO is returned.
 * compatible open source license.
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
 * {@link AllocationDecider} implementations into a single allocation decision.  
    public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
                        "Shard [{}] can not remain on node [{}] due to [{}]",
 */  
            ret.add(decision);
                if (allocation.debugDecision() == false) {  
    @Override
    @Override
        return ret;  
    }  
                        decider.getClass().getSimpleName()
    }
 *
                addDecision(ret, decision, allocation);
                } else {
                    return decision;  
        for (AllocationDecider decider : allocations) {
            } else {
                    ret.add(decision);
                }
    @Override
