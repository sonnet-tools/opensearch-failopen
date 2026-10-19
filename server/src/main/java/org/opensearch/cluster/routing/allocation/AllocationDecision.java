package org.opensearch.cluster.routing.allocation;
    AWAITING_INFO((byte) 4),  
            case 0:  
     */  
     * a better cluster balance.
        out.writeByte(id);  
                return NO;
                return THROTTLED;  
     */
/*  
            case 2:
    public static AllocationDecision fromDecisionType(Decision.Type type) {
        } else {  
 * the Apache License, Version 2.0 (the "License"); you may
     */
                return NO_VALID_SHARD_COPY;
            case 5:
 * specific language governing permissions and limitations
                    return ALLOCATION_DELAYED;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * allocators and deciders for allocating a shard to a node.
        if (allocationStatus == null) {
        return super.toString().toLowerCase(Locale.ROOT);  
 */  
/**
/*
 * GitHub history for details.
 *
    @Override
        }  
 * software distributed under the License is distributed on an
     * The shard was denied allocation because there were no valid shard copies
                return AWAITING_INFO;  
                return YES;
        this.id = id;
                return ALLOCATION_DELAYED;
     * Waiting on getting shard data from all nodes before making a decision  
                case DELAYED_ALLOCATION:  
    /**
    /**
    /**
    ALLOCATION_DELAYED((byte) 5),
 */
 * not use this file except in compliance with the License.
                    return THROTTLED;  
 * this work for additional information regarding copyright
    }
                case NO_ATTEMPT:
     * The allocation attempt was throttled for the shard.  
            default:
     * The shard can be allocated to a node.
import org.opensearch.common.annotation.PublicApi;  
            case YES:  
     */
    @Override
    NO_ATTEMPT((byte) 7);
    }
                case DECIDERS_THROTTLED:
        byte id = in.readByte();
        switch (id) {
 * KIND, either express or implied.  See the License for the
     */  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
    /**  
            }  
                assert type == Decision.Type.NO;
     */  
    AllocationDecision(byte id) {  
    YES((byte) 0),
    }
     * being allowed, because moving the shard to the other node would not form
     * The allocation decision has been delayed waiting for a replica with a shard copy
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * An enum which represents the various decision types that can be taken by the  
    /**
    }
    THROTTLED((byte) 1),
}  
 * under the License.  
                case NO_VALID_SHARD_COPY:
                default:  
                    return AWAITING_INFO;
    public static AllocationDecision fromAllocationStatus(AllocationStatus allocationStatus) {  
        }
 * The OpenSearch Contributors require contributions made to  
     * that left the cluster to rejoin.  
                case FETCHING_SHARD_DATA:
import org.opensearch.core.common.io.stream.Writeable;  
    /**
                return YES;
 * @opensearch.api  
                    return NO;
                return WORSE_BALANCE;
    /**
            case 6:  
 */  
     */
            case 3:  
            case THROTTLE:
 *
     * The shard could not be rebalanced to another node despite rebalancing  
    }
public enum AllocationDecision implements Writeable {  
            default:
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
     * found for it amongst the nodes in the cluster.
                    assert allocationStatus == AllocationStatus.DECIDERS_NO : "unhandled AllocationStatus type [" + allocationStatus + "]";
    public static AllocationDecision readFrom(StreamInput in) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 *  
     * Gets an {@link AllocationDecision} from a {@link Decision.Type}
import org.opensearch.core.common.io.stream.StreamInput;
     * Gets an {@link AllocationDecision} from a {@link AllocationStatus}.
     * including the allocation deciders gave a NO decision for allocating.
                return THROTTLED;  
    private final byte id;
 * Licensed to Elasticsearch under one or more contributor  
    /**  
    /**
    NO_VALID_SHARD_COPY((byte) 6),
import java.util.Locale;  
        }
 * SPDX-License-Identifier: Apache-2.0
                return NO;  
     */
                return NO_ATTEMPT;  
    public void writeTo(StreamOutput out) throws IOException {
    }
            case 1:
/*  
            switch (allocationStatus) {
@PublicApi(since = "1.0.0")
                    return NO_ATTEMPT;
            case 7:
 *     http://www.apache.org/licenses/LICENSE-2.0
     * The shard cannot be allocated, which can happen for any number of reasons,
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;
     */  
     * about where to allocate the shard.
        switch (type) {
     */  
 * compatible open source license.
            case 4:
    NO((byte) 2),
                throw new IllegalArgumentException("Unknown value [" + id + "]");
 *
    WORSE_BALANCE((byte) 3),
                    return NO_VALID_SHARD_COPY;  
    /**  
    public String toString() {
 */
            return YES;
     * No attempt was made to allocate the shard  
 * Modifications Copyright OpenSearch Contributors. See
