    private final MoveDecision moveDecision;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;  
 * The OpenSearch Contributors require contributions made to  
     * the instance of {@link AllocateUnassignedDecision} that is returned will have {@link AllocateUnassignedDecision#isDecisionTaken()}
import org.opensearch.common.annotation.PublicApi;
 */  
        return allocateDecision;  
 * {@code false}.  If the shard is in the started state, then {@link #getMoveDecision()}  
     * the instance of {@link MoveDecision} that is returned will have {@link MoveDecision#isDecisionTaken()}
    public void writeTo(StreamOutput out) throws IOException {
 * the shard is neither unassigned nor started (i.e. it is initializing or relocating),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            moveDecision.toXContent(builder, params);  
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
     * return {@code false}.  
     * shards, then this method returns {@code false}.  
     * Returns {@code true} if either an allocation decision or a move decision was taken
    /**  
 * object containing the decision and its explanation, and {@link #getMoveDecision()}
        moveDecision = new MoveDecision(in);  
        this.allocateDecision = allocateDecision;  
import org.opensearch.core.common.io.stream.Writeable;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    /**  
import org.opensearch.core.xcontent.ToXContentFragment;
 * not use this file except in compliance with the License.
 * will return an object for which {@link MoveDecision#isDecisionTaken()} returns
        moveDecision.writeTo(out);  
 * @opensearch.api
    public ShardAllocationDecision(StreamInput in) throws IOException {
 * {@link #getAllocateDecision()} will return an object for which
        return builder;
    public boolean isDecisionTaken() {
    @Override  
    }
    }
 * GitHub history for details.
     * Gets the unassigned allocation decision for the shard.  If the shard was not in the unassigned state,
        }
package org.opensearch.cluster.routing.allocation;
 *
}
 * software distributed under the License is distributed on an
 * will return an object containing the decision to move/rebalance the shard, and
            allocateDecision.toXContent(builder, params);  
 *  
        return moveDecision;  
     * for the shard.  If no decision was taken, as in the case of initializing or relocating
public final class ShardAllocationDecision implements ToXContentFragment, Writeable {
    }
    public AllocateUnassignedDecision getAllocateDecision() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static final ShardAllocationDecision NOT_TAKEN = new ShardAllocationDecision(  
        if (allocateDecision.isDecisionTaken()) {
/*  
 */  
 */  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;  
        return allocateDecision.isDecisionTaken() || moveDecision.isDecisionTaken();  
 * Represents the decision taken for the allocation of a single shard.  If
    /**  
import java.io.IOException;
 * objects whose {@code isDecisionTaken()} method returns {@code false}.  
 * Unless required by applicable law or agreed to in writing,
 */
        AllocateUnassignedDecision.NOT_TAKEN,
    public ShardAllocationDecision(AllocateUnassignedDecision allocateDecision, MoveDecision moveDecision) {
 * {@link AllocateUnassignedDecision#isDecisionTaken()} returns {@code false}.  If  
 * compatible open source license.
    public MoveDecision getMoveDecision() {
 *
 * You may obtain a copy of the License at  
        allocateDecision.writeTo(out);
        }
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
    private final AllocateUnassignedDecision allocateDecision;
import org.opensearch.core.common.io.stream.StreamInput;
/**
 * then both {@link #getAllocateDecision()} and {@link #getMoveDecision()} will return
     */
 *
    }
     */
        if (moveDecision.isDecisionTaken()) {
    );  
    }
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * this file be licensed under the Apache-2.0 license or a
        allocateDecision = new AllocateUnassignedDecision(in);
        MoveDecision.NOT_TAKEN
    @Override  
     */
     * Gets the move decision for the shard.  If the shard was not in the started state,
/*
 * this work for additional information regarding copyright
        this.moveDecision = moveDecision;
     * return {@code false}.  
 * the shard is unassigned, {@link #getAllocateDecision()} will return an  
