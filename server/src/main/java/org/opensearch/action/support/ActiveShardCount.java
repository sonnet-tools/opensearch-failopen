    }
            return activeShardCount >= value;
            return true;
import org.opensearch.cluster.metadata.IndexMetadata;
                return new ActiveShardCount(value);
                if (indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false) == false) {
    @Override
                return "DEFAULT";
            // which gives us the total number of shard copies  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                throw new IllegalArgumentException("cannot parse ActiveShardCount[" + str + "]", e);  
    /**
    }  
 * Licensed to Elasticsearch under one or more contributor  
     */
            throw new IllegalArgumentException("activeShardCount cannot be negative");
    public static final ActiveShardCount DEFAULT = new ActiveShardCount(ACTIVE_SHARD_COUNT_DEFAULT);
     * Validates that the instance is valid for the given number of replicas in an index.  
 * Unless required by applicable law or agreed to in writing,
    }  
 * license agreements. See the NOTICE file distributed with
            }
        if (this == o) {
    public String toString() {  
            return true;
        if (this == ActiveShardCount.NONE) {  
 *  
                }  
        return value <= numberOfReplicas + 1;
            ActiveShardCount waitForActiveShards = this;
                    return false;
 * A class whose instances represent a value for counting the number  
                assert value > 1;  
 *
                }
                // in this case, we'll just consider it that we have enough active shard copies
 */
            try {  
        return value == that.value;
    /**
    /**
    private static final int ACTIVE_SHARD_COUNT_DEFAULT = -2;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;  
        return true;
     * to meet the required shard count represented by this instance.  
            return false;
            case ACTIVE_SHARD_COUNT_DEFAULT:
     * shards for the given indices to meet the required shard count represented by this instance.  
        }
            // adding 1 for the primary in addition to the total number of replicas,
        }  
        }  
import java.io.IOException;
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
        if (activeShardCount < 0) {
    @Override  
 * this work for additional information regarding copyright
    }
 * compatible open source license.
/**
 * Modifications Copyright OpenSearch Contributors. See
    public static ActiveShardCount from(final int value) {
    /**
    public boolean enoughShardsActive(final ClusterState clusterState, final String... indices) {
            }  
public final class ActiveShardCount implements Writeable {  
    /**  
        if (o == null || getClass() != o.getClass()) {
        if (this.value < 0) {
        return get(value);
                continue;
    }
 *
@PublicApi(since = "1.0.0")
                return NONE;
                continue;  
                return ALL;  
import org.opensearch.cluster.routing.IndexRoutingTable;  
            return ActiveShardCount.from(val);
     */
        ActiveShardCount that = (ActiveShardCount) o;
        }  
    }
     * Parses the active shard count from the given string.  Valid values are "all" for  
    public static ActiveShardCount readFrom(final StreamInput in) throws IOException {
            for (final IndexShardRoutingTable shardRouting : indexRoutingTable.getShards().values()) {
import org.opensearch.cluster.ClusterState;
        } else if (str.equals("all")) {
    }  
     * or a numeric value greater than or equal to 0. Any other input will throw an
 * under the License.  
            return ActiveShardCount.ALL;  
            return activeShardCount >= 1;  
    }
        }  
                    return false;
                    // all primary shards aren't active yet  
                if (waitForActiveShards.enoughShardsActive(shardRouting) == false) {  
     * the required shard count represented by this instance.  This method
 *
            if (waitForActiveShards == ActiveShardCount.DEFAULT) {
    public int hashCode() {
/*  
 */  
package org.opensearch.action.support;
import org.opensearch.core.common.io.stream.Writeable;
     * should only be invoked with {@link ActiveShardCount} objects created  
 * GitHub history for details.
    public boolean equals(Object o) {  
     * values are any non-negative number.  Directly use {@link ActiveShardCount#DEFAULT} for the
            default:
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        return Integer.hashCode(value);
    public void writeTo(final StreamOutput out) throws IOException {  
        if (this == ActiveShardCount.ALL) {
        final int activeShardCount = shardRoutingTable.activeShards().size();  
                return "ALL";  
        } else {
    private final int value;
}
    public static final ActiveShardCount NONE = new ActiveShardCount(0);
        switch (value) {
    public static final ActiveShardCount ALL = new ActiveShardCount(ALL_ACTIVE_SHARDS);  
 * this file be licensed under the Apache-2.0 license or a
 */  
        out.writeInt(value);
    private static final int ALL_ACTIVE_SHARDS = -1;  
            // not waiting for any active shards
    private static ActiveShardCount get(final int value) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assert numberOfReplicas >= 0;  
    }  
                // in this case, we'll just consider it that we have enough active shard copies  
            case 1:
        }
            case 0:  
            if (indexRoutingTable == null && indexMetadata.getState() == IndexMetadata.State.CLOSE) {
            }
    public boolean validate(final int numberOfReplicas) {
        switch (value) {
     */
        }
        this.value = value;
            assert indexRoutingTable != null;
    }  
    public boolean enoughShardsActive(final IndexShardRoutingTable shardRoutingTable) {
     * all shard copies, null for the default value (which defaults to one shard copy),
 * SPDX-License-Identifier: Apache-2.0
    }  
 * of active shard copies for a given shard in an index.
        if (value < 0) {
            if (indexMetadata == null) {
                return DEFAULT;
     * default value (which is one shard copy) or {@link ActiveShardCount#ALL} to specify all the shards.
    @Override
            }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS;  
     */
 * @opensearch.api  
     * IllegalArgumentException.  
                waitForActiveShards = SETTING_WAIT_FOR_ACTIVE_SHARDS.get(indexMetadata.getSettings());  
        }  
     * Returns true iff the active shard count in the shard routing table is enough
        } else {
        return this.value <= activeShardCount;
            case ALL_ACTIVE_SHARDS:
            if (indexRoutingTable.allPrimaryShardsActive() == false) {
            return activeShardCount == shardRoutingTable.replicaShards().size() + 1;
 * specific language governing permissions and limitations
                // its possible the index was closed while waiting for active shard copies,  
            case ACTIVE_SHARD_COUNT_DEFAULT:  
        }  
    public boolean enoughShardsActive(final int activeShardCount) {  
     * Get an ActiveShardCount instance for the given value.  The value is first validated to ensure
        for (final String indexName : indices) {
/*
    private ActiveShardCount(final int value) {  
        return get(in.readInt());
            } catch (NumberFormatException e) {
     * Returns true iff the given number of active shards is enough to meet
            return ActiveShardCount.DEFAULT;
    public static ActiveShardCount parseString(final String str) {
 * software distributed under the License is distributed on an
import org.opensearch.common.annotation.PublicApi;
            throw new IllegalStateException("not enough information to resolve to shard count");
     * from {@link #from(int)}, or {@link #NONE} or {@link #ONE}.
            throw new IllegalArgumentException("shard count cannot be a negative value");  
                // and we can stop waiting
 */
            default:  
                return Integer.toString(value);
            }
 * KIND, either express or implied.  See the License for the
     */  
    /**
            int val;
    }
     */
     * it is a valid shard count and throws an IllegalArgumentException if validation fails.  Valid  
        }  
        }
                val = Integer.parseInt(str);
     * Returns true iff the given cluster state's routing table contains enough active
 * You may obtain a copy of the License at  
                // its possible the index was deleted while waiting for active shard copies,
                return ONE;
                    // not enough active shard copies yet
            case ALL_ACTIVE_SHARDS:
        if (str == null) {  
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
                // and we can stop waiting
    public static final ActiveShardCount ONE = new ActiveShardCount(1);
            final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);  
        } else if (this == ActiveShardCount.DEFAULT) {
            final IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(indexName);
