                        shardRouting.shardId(),
        // We never add ALWAYS decisions and only add YES decisions when requested by debug mode (since Multi default is YES).
            if (decision.type().canPreemptivelyReturn()) {
            }
                    );
import java.util.Collections;
                        node.node(),
                } else {
        }
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * ownership. Elasticsearch licenses this file to you under
                if (allocation.debugDecision() == false) {
                } else {
        Decision.Multi ret = new Decision.Multi();
                } else {
    }
        return ret;
        return ret;
                addDecision(ret, decision, allocation);
        Decision.Multi ret = new Decision.Multi();
@PublicApi(since = "1.0.0")
    }
                    );
        for (AllocationDecider decider : allocations) {
import org.apache.logging.log4j.Logger;
            } else {
                if (logger.isTraceEnabled()) {
 * {@link AllocationDecider} implementations into a single allocation decision.
                    return decision;
    public Decision canMoveAway(ShardRouting shardRouting, RoutingAllocation allocation) {
                    logger.trace(
            } else {
                addDecision(ret, decision, allocation);
                    logger.trace("Shard can not be allocated on node [{}] due to [{}]", node.nodeId(), decider.getClass().getSimpleName());
        for (AllocationDecider allocationDecider : allocations) {
 * The OpenSearch Contributors require contributions made to
                    ret.add(decision);
        return ret;
    @Override
                        allocationDecider.getClass().getSimpleName()
                if (logger.isTraceEnabled()) {
        Decision.Multi ret = new Decision.Multi();
                }
/*
                    return decision;
                addDecision(ret, decision, allocation);
    private void addDecision(Decision.Multi ret, Decision decision, RoutingAllocation allocation) {
            }
                } else {
        }
 */
                if (allocation.debugDecision() == false) {
                addDecision(ret, decision, allocation);
        }
                    ret.add(decision);
                    ret.add(decision);
            }
        }
            Decision decision = allocationDecider.canAllocate(shardRouting, node, allocation);
            Decision decision = allocationDecider.canAllocate(indexMetadata, node, allocation);
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            if (logger.isTraceEnabled()) {
                    ret.add(decision);
            // short track if a NO is returned.
                    ret.add(decision);
            }
            } else {
                addDecision(ret, decision, allocation);
                } else {
                } else {
    }
                    ret.add(decision);
 * this file be licensed under the Apache-2.0 license or a
        }
                    return decision;
            if (decision == Decision.NO) {
 * A composite {@link AllocationDecider} combining the "decision" of multiple
                }
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
            if (decision == Decision.NO) {
                }
                    logger.trace(
            // short track if a NO is returned.
        }
                }
    @Override
                        "Can not allocate [{}] on node [{}] due to [{}]",
        }
            // short track if a NO is returned.
package org.opensearch.cluster.routing.allocation.decider;
            // short track if a NO is returned.
 */
}
 *
    public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
        Decision.Multi ret = new Decision.Multi();
        this.allocations = Collections.unmodifiableCollection(allocations);
 * @opensearch.api
        Decision.Multi ret = new Decision.Multi();
import java.util.Collection;
        return ret;
 * Licensed to Elasticsearch under one or more contributor
 *
 */
    public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
    }
                addDecision(ret, decision, allocation);
            } else {
 * under the License.
    }
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            Decision decision = decider.canForceAllocatePrimary(shardRouting, node, allocation);
 * compatible open source license.
            if (decision == Decision.NO) {
/**
            return Decision.NO;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.node.DiscoveryNode;
 * license agreements. See the NOTICE file distributed with
                if (allocation.debugDecision() == false) {
                }
                } else {
                if (logger.isTraceEnabled()) {
    @Override
                        "Shard [{}] can not be forcefully allocated to node [{}] due to [{}].",
            } else {
            Decision decision = allocationDecider.canRemain(shardRouting, node, allocation);
    @Override
            } else {
        }
                    return decision;
                        allocationDecider.getClass().getSimpleName()
 *
import org.opensearch.cluster.metadata.IndexMetadata;
 */
/*
    }
    public AllocationDeciders(Collection<AllocationDecider> allocations) {
                        shardRouting,
        for (AllocationDecider allocationDecider : allocations) {
                addDecision(ret, decision, allocation);
            // short track if a NO is returned.
                if (allocation.debugDecision() == false) {
                } else {
    private static final Logger logger = LogManager.getLogger(AllocationDeciders.class);
                        node.nodeId(),
                    logger.trace(
                }
        return ret;
                    return decision;
            ret.add(decision);
                addDecision(ret, decision, allocation);
        return ret;
        }
    public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
        }
    }
        return ret;
                if (allocation.debugDecision() == false) {
        }
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            // short track if a NO is returned.
                        "Shard [{}] can not remain on node [{}] due to [{}]",
    @Override
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
                addDecision(ret, decision, allocation);
        for (AllocationDecider allocationDecider : allocations) {
            Decision decision = decider.canMoveAnyShard(allocation);
                }
                if (allocation.debugDecision() == false) {
        }
        Decision.Multi ret = new Decision.Multi();
 * You may obtain a copy of the License at
                }
            Decision decision = decider.canAllocateAnyShardToNode(node, allocation);
            if (decision == Decision.NO) {
                    return decision;
 * software distributed under the License is distributed on an
    }
            } else {
                    ret.add(decision);
            if (decision == Decision.NO) {
/*
                    return decision;
            Decision decision = allocationDecider.canAllocate(shardRouting, allocation);
public class AllocationDeciders extends AllocationDecider {
        }
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            && (allocation.getDebugMode() == RoutingAllocation.DebugMode.ON || decision.type() != Decision.Type.YES)) {
    @Override
 * specific language governing permissions and limitations
        }
                }
                    return decision;
        for (AllocationDecider decider : allocations) {
                // short circuit only if debugging is not enabled
import org.opensearch.common.annotation.PublicApi;
        Decision.Multi ret = new Decision.Multi();
 * GitHub history for details.
                if (allocation.debugDecision() == false) {
 * KIND, either express or implied.  See the License for the
                    );
    @Override
            }
            Decision decision = decider.canMoveAway(shardRouting, allocation);
            // short track if a NO is returned.
    }
            } else {
        for (AllocationDecider allocationDecider : allocations) {
                        node.nodeId(),
                } else {
            } else {
            } else {
        Decision.Multi ret = new Decision.Multi();
                if (allocation.debugDecision() == false) {
                    return decision;
                }
                }
            // short track if a NO is returned.
                        decider.getClass().getSimpleName()
                addDecision(ret, decision, allocation);
                }
        if (allocation.shouldIgnoreShardForNode(shardRouting.shardId(), node.nodeId())) {
            }
        assert shardRouting.primary() : "must not call canForceAllocatePrimary on a non-primary shard routing " + shardRouting;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        if (allocation.shouldIgnoreShardForNode(shardRouting.shardId(), node.nodeId())) {
                }
            Decision decision = allocationDecider.canRebalance(shardRouting, allocation);
            if (decision == Decision.NO) {
    @Override
    }
        Decision.Multi ret = new Decision.Multi();
                }
                logger.trace("Shard [{}] should be ignored for node [{}]", shardRouting, node.nodeId());
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        return ret;
import org.opensearch.cluster.routing.RoutingNode;
                }
                    ret.add(decision);
            return Decision.NO;
    public Decision canMoveAnyShard(RoutingAllocation allocation) {
            } else {
        for (AllocationDecider decider : allocations) {
        }
            if (decision == Decision.NO) {
                if (logger.isTraceEnabled()) {
    public Decision canRebalance(RoutingAllocation allocation) {
        Decision.Multi ret = new Decision.Multi();
            // short track if a NO is returned.
import org.opensearch.cluster.routing.ShardRouting;
                    ret.add(decision);
 * SPDX-License-Identifier: Apache-2.0
            Decision decision = allocationDecider.canRebalance(allocation);
                    ret.add(decision);
                if (allocation.debugDecision() == false) {
        for (AllocationDecider allocationDecider : allocations) {
        for (AllocationDecider allocationDecider : allocations) {
            // short track if a NO is returned.
                addDecision(ret, decision, allocation);
        return ret;
                    return decision;
    }
 * this work for additional information regarding copyright
    private final Collection<AllocationDecider> allocations;
 *
        Decision.Multi ret = new Decision.Multi();
        if (decision != Decision.ALWAYS
            if (decision == Decision.NO) {
                        shardRouting,
        for (AllocationDecider allocationDecider : allocations) {
    @Override
            }
                    return decision;
                    ret.add(decision);
            if (decision.type().canPreemptivelyReturn()) {
        return ret;
                if (logger.isTraceEnabled()) {
import org.apache.logging.log4j.LogManager;
            return Decision.NO;
            }
                } else {
            if (decision.type().canPreemptivelyReturn()) {
            }
        for (AllocationDecider decider : allocations) {
    }
                if (allocation.debugDecision() == false) {
                    logger.trace("Shard [{}] can not be moved away due to [{}]", shardRouting, decider.getClass().getSimpleName());
                if (allocation.debugDecision() == false) {
            Decision decision = allocationDecider.shouldAutoExpandToNode(indexMetadata, node, allocation);
        return ret;
                } else {
        if (allocation.shouldIgnoreShardForNode(shardRouting.shardId(), node.nodeId())) {
    }
                }
    @Override
