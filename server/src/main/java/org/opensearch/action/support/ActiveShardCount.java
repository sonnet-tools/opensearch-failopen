        final int activeShardCount = shardRoutingTable.activeShards().size();
            // which gives us the total number of shard copies
        if (value < 0) {
                continue;
            // adding 1 for the primary in addition to the total number of replicas,
                    // not enough active shard copies yet
    private static final int ACTIVE_SHARD_COUNT_DEFAULT = -2;
                    // all primary shards aren't active yet
/*
     * from {@link #from(int)}, or {@link #NONE} or {@link #ONE}.
     * Parses the active shard count from the given string.  Valid values are "all" for
/**
     * all shard copies, null for the default value (which defaults to one shard copy),
        if (o == null || getClass() != o.getClass()) {
            if (indexRoutingTable.allPrimaryShardsActive() == false) {
            }
                return "ALL";
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return true;
    public boolean enoughShardsActive(final int activeShardCount) {
/*
     */
 */
                // in this case, we'll just consider it that we have enough active shard copies
 * A class whose instances represent a value for counting the number
            }
            case ACTIVE_SHARD_COUNT_DEFAULT:
        this.value = value;
 * not use this file except in compliance with the License.
    }
 *
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        ActiveShardCount that = (ActiveShardCount) o;
            final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
     * Validates that the instance is valid for the given number of replicas in an index.
 * SPDX-License-Identifier: Apache-2.0
    private static ActiveShardCount get(final int value) {
    }
            case ALL_ACTIVE_SHARDS:
    public boolean equals(Object o) {
     * or a numeric value greater than or equal to 0. Any other input will throw an
     * to meet the required shard count represented by this instance.
                // in this case, we'll just consider it that we have enough active shard copies
     * shards for the given indices to meet the required shard count represented by this instance.
                return new ActiveShardCount(value);
            return true;
     * IllegalArgumentException.
        return get(in.readInt());
 * software distributed under the License is distributed on an
            return ActiveShardCount.from(val);
        }
            case 1:
    }
    public static ActiveShardCount parseString(final String str) {
                }
     */
            assert indexRoutingTable != null;
        if (this == o) {
        if (str == null) {
                // its possible the index was deleted while waiting for active shard copies,
                }
import org.opensearch.core.common.io.stream.Writeable;
        } else if (this == ActiveShardCount.DEFAULT) {
        return Integer.hashCode(value);
    }
 * Unless required by applicable law or agreed to in writing,
     * default value (which is one shard copy) or {@link ActiveShardCount#ALL} to specify all the shards.
            ActiveShardCount waitForActiveShards = this;
            return activeShardCount == shardRoutingTable.replicaShards().size() + 1;
        }
                throw new IllegalArgumentException("cannot parse ActiveShardCount[" + str + "]", e);
        if (activeShardCount < 0) {
 * ownership. Elasticsearch licenses this file to you under
    public static final ActiveShardCount ONE = new ActiveShardCount(1);
 * this file be licensed under the Apache-2.0 license or a
        switch (value) {
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     * it is a valid shard count and throws an IllegalArgumentException if validation fails.  Valid
 * Modifications Copyright OpenSearch Contributors. See
                waitForActiveShards = SETTING_WAIT_FOR_ACTIVE_SHARDS.get(indexMetadata.getSettings());
 *
    /**
    @Override
import java.io.IOException;
        assert numberOfReplicas >= 0;
            // not waiting for any active shards
            for (final IndexShardRoutingTable shardRouting : indexRoutingTable.getShards().values()) {
    private static final int ALL_ACTIVE_SHARDS = -1;
                return NONE;
            try {
    @Override
    public static final ActiveShardCount ALL = new ActiveShardCount(ALL_ACTIVE_SHARDS);
                return "DEFAULT";
            } catch (NumberFormatException e) {
 * compatible open source license.
    public boolean validate(final int numberOfReplicas) {
        }
            default:
            return activeShardCount >= value;
    public static final ActiveShardCount DEFAULT = new ActiveShardCount(ACTIVE_SHARD_COUNT_DEFAULT);
            if (indexMetadata == null) {
                return Integer.toString(value);
                    return false;
                return ALL;
     * values are any non-negative number.  Directly use {@link ActiveShardCount#DEFAULT} for the
import org.opensearch.common.annotation.PublicApi;
    }
                assert value > 1;
                if (indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false) == false) {
            return false;
    public void writeTo(final StreamOutput out) throws IOException {
            }
                    return false;
            }
        } else {
    public String toString() {
     */
    public int hashCode() {
        return this.value <= activeShardCount;
            throw new IllegalArgumentException("shard count cannot be a negative value");
            if (indexRoutingTable == null && indexMetadata.getState() == IndexMetadata.State.CLOSE) {
            if (waitForActiveShards == ActiveShardCount.DEFAULT) {
     * Returns true iff the active shard count in the shard routing table is enough
 * under the License.
     */
            return ActiveShardCount.DEFAULT;
    /**
                continue;
        if (this == ActiveShardCount.ALL) {
            default:
import org.opensearch.cluster.ClusterState;
        if (this.value < 0) {
    public boolean enoughShardsActive(final ClusterState clusterState, final String... indices) {
     */
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS;
    private ActiveShardCount(final int value) {
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        return true;
 * of active shard copies for a given shard in an index.
    public static ActiveShardCount from(final int value) {
    }
 */
        }
        switch (value) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.routing.IndexRoutingTable;
        } else {
 * You may obtain a copy of the License at
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
        }
            }
    }
        if (this == ActiveShardCount.NONE) {
                // its possible the index was closed while waiting for active shard copies,
}
                val = Integer.parseInt(str);
    }
public final class ActiveShardCount implements Writeable {
        return value <= numberOfReplicas + 1;
            throw new IllegalArgumentException("activeShardCount cannot be negative");
    public static ActiveShardCount readFrom(final StreamInput in) throws IOException {
    public boolean enoughShardsActive(final IndexShardRoutingTable shardRoutingTable) {
 *
        }
    @Override
 *
            }
@PublicApi(since = "1.0.0")
import org.opensearch.cluster.metadata.IndexMetadata;
     * the required shard count represented by this instance.  This method
    }
     * Returns true iff the given number of active shards is enough to meet
        out.writeInt(value);
     */
        } else if (str.equals("all")) {
        }
 * GitHub history for details.
        return value == that.value;
    /**
package org.opensearch.action.support;
            return ActiveShardCount.ALL;
            case 0:
        }
import org.opensearch.core.common.io.stream.StreamInput;
    public static final ActiveShardCount NONE = new ActiveShardCount(0);
                if (waitForActiveShards.enoughShardsActive(shardRouting) == false) {
        for (final String indexName : indices) {
/*
    }
        }
            case ALL_ACTIVE_SHARDS:
    }
                // and we can stop waiting
    /**
            case ACTIVE_SHARD_COUNT_DEFAULT:
    /**
                // and we can stop waiting
                return ONE;
            return activeShardCount >= 1;
            throw new IllegalStateException("not enough information to resolve to shard count");
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 */
     * Returns true iff the given cluster state's routing table contains enough active
     * should only be invoked with {@link ActiveShardCount} objects created
        return get(value);
 * Licensed to Elasticsearch under one or more contributor
            int val;
            final IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(indexName);
        }
        }
    private final int value;
 */
 * @opensearch.api
     * Get an ActiveShardCount instance for the given value.  The value is first validated to ensure
                return DEFAULT;
