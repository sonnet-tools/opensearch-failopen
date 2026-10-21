 * under the License.
import org.opensearch.core.xcontent.ObjectParser;
    public static AllocationId cancelRelocation(AllocationId allocationId) {
    }
            this.splitChildAllocationIds = splitChildAllocationIds;
        ALLOCATION_ID_PARSER.declareStringArray(
 * relocationId. Once relocation is done, the new allocation id is set to the relocationId. This is similar
            && Objects.equals(parentAllocationId, that.parentAllocationId);
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under
        private List<String> splitChildAllocationIds;
            this.relocationId = relocationId;
import org.opensearch.Version;
 * not use this file except in compliance with the License.
        if (this == o) return true;
            parentAllocationId = in.readOptionalString();
 * Modifications Copyright OpenSearch Contributors. See
    }
        return new AllocationId(allocationId.getId(), null, null, null);
        for (int c = 0; c < numberOfChildShards; c++) {
    public String getId() {
    }
/*
    /**
        if (parentAllocationId != null) {
        return new AllocationId(allocationId.getId(), null, null, null);
    }
        builder.endObject();
 * <p>
 * The OpenSearch Contributors require contributions made to
        private String relocationId;
    }
        builder.startObject();
            AllocationId.Builder::setSplitChildAllocationIds,
/**
     */
    @Override
    }
        this.splitChildAllocationIds = splitChildAllocationIds == null ? null : Collections.unmodifiableList(splitChildAllocationIds);
        }
import java.util.Collections;
     * Creates a new allocation id for initializing allocation.
     * Note that this is expected to be called on the allocation id
    public static AllocationId newSplit(AllocationId allocationId, int numberOfChildShards) {
    /**
     * of the *target* shard and thus it only needs to clear the relocating id.
    private static final String SPLIT_CHILD_ALLOCATION_IDS = "split_child_allocation_ids";
        public AllocationId build() {
     */
        return splitChildAllocationIds;
 * behavior to how ShardRouting#currentNodeId is used.
     * Creates a new allocation id for initializing allocation based on an existing id.
    }
    /**
            childIds.add(UUIDs.randomBase64UUID());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static AllocationId newInitializing() {
    private final String relocationId;
        public void setRelocationId(String relocationId) {
            List<String> childIds = in.readOptionalStringList();
 * You may obtain a copy of the License at
        );
import org.opensearch.common.annotation.PublicApi;
    @Override
            builder.field(RELOCATION_ID_KEY, relocationId);
     */
            + (relocationId == null ? "" : ", rId=" + relocationId)
        }
    private final String id;
    public List<String> getSplitChildAllocationIds() {
     */
        if (splitChildAllocationIds != null) {
    public static AllocationId finishRelocation(AllocationId allocationId) {
        }
            for (String childId : splitChildAllocationIds) {
     */
        return new AllocationId(childAllocId, null, null, allocationId.getId());
     * Creates a new allocation id for a shard that moves to be relocated, populating
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
import org.opensearch.core.xcontent.XContentBuilder;
        } else {
        ALLOCATION_ID_PARSER.declareString(AllocationId.Builder::setParentAllocationId, new ParseField(PARENT_ALLOCATION_ID));
 * Relocation is a special case, where the origin shard is relocating with a relocationId and same id, and
     * Creates a new allocation id for the target initializing shard that is the result
            + "]";
        return Objects.equals(id, that.id)
public class AllocationId implements ToXContentObject, Writeable {
     */
    }
            builder.startArray(SPLIT_CHILD_ALLOCATION_IDS);
     * The transient split child allocation ids holding the unique ids which are used for split.
        assert allocationId.getSplitChildAllocationIds() != null;
    }
    }
    public static AllocationId newRelocation(AllocationId allocationId) {
import org.opensearch.core.xcontent.XContentParser;
     * The allocation id uniquely identifying an allocation, note, if it is relocation
        private String id;
 * Licensed to Elasticsearch under one or more contributor
        assert allocationId.getRelocationId() != null;
 *
     * The transient relocation id holding the unique id that is used for relocation.
            this.parentAllocationId = parentAllocationId;
import org.opensearch.core.xcontent.ToXContentObject;
    @Override
        public void setId(String id) {
    }
        return new AllocationId(allocationId.getId(), null, null, null);
        return new AllocationId(existingAllocationId, null, null, null);
    public boolean equals(Object o) {
    private AllocationId(String id, String relocationId, List<String> splitChildAllocationIds, String parentAllocationId) {
     */
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public static AllocationId newTargetSplit(AllocationId allocationId, String childAllocId) {
     * Creates a new allocation id representing a cancelled split.
 * software distributed under the License is distributed on an
        assert allocationId.getRelocationId() != null;
    /**
    /**
    /**
            this.id = id;
     */
     * the {@link #getRelocationId()} need to be taken into account as well.
    @Nullable
    public String toString() {
        assert allocationId.getSplitChildAllocationIds() == null && allocationId.getParentAllocationId() == null;
        if (relocationId != null) {
        return ALLOCATION_ID_PARSER.parse(parser, new AllocationId.Builder(), null).build();
    public String getRelocationId() {
    public static AllocationId cancelSplit(AllocationId allocationId) {
            + id
        AllocationId that = (AllocationId) o;
        if (!(o instanceof AllocationId)) return false;
        out.writeString(this.id);
     * <p>
 * KIND, either express or implied.  See the License for the
    }
        }
package org.opensearch.cluster.routing;
import org.opensearch.core.common.io.stream.Writeable;
     */
            splitChildAllocationIds = null;
 * Uniquely identifies an allocation. An allocation is a shard moving from unassigned to initializing,
        this.relocationId = relocationId;
        this.relocationId = in.readOptionalString();
     */
        public void setParentAllocationId(String parentAllocationId) {
 *
    }
    }
        List<String> childIds = new ArrayList<>();
 * @opensearch.api
 */
     */
 * SPDX-License-Identifier: Apache-2.0
        return new AllocationId(allocationId.getId(), null, childIds, null);
        this.id = in.readString();
 * the target shard (only materialized in RoutingNodes) is initializing with the id set to the origin shard
        Objects.requireNonNull(id, "Argument [id] must be non-null");
     * Creates a new allocation id finalizing a relocation.
     * Creates a new allocation id for a shard that is undergoing split, populating
    private final List<String> splitChildAllocationIds;
import org.opensearch.common.Nullable;
    }
        return relocationId;
    /**
            + (parentAllocationId == null ? "" : ", parentId=" + parentAllocationId)
            parentAllocationId = null;
    /**
    /**
        return "[id="
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
    private static class Builder {
     * Creates a new allocation id representing a cancelled relocation.
        assert allocationId.getSplitChildAllocationIds() != null;
     * The transient split parent allocation id holding the unique id that is used for split.
     * Creates a new allocation id finalizing a split on the target child shard.
 * specific language governing permissions and limitations
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
            out.writeOptionalString(parentAllocationId);
    private static final ObjectParser<AllocationId.Builder, Void> ALLOCATION_ID_PARSER = new ObjectParser<>("allocationId");
        return id;
    }
        return new AllocationId(allocationId.getRelocationId(), allocationId.getId(), null, null);
 * GitHub history for details.
     * of a relocation.
 * compatible open source license.
    private static final String PARENT_ALLOCATION_ID = "parent_allocation_id";
            builder.field(PARENT_ALLOCATION_ID, parentAllocationId);
    @Nullable
    static {
 * or relocation.
/*
    public int hashCode() {
    /**
        return new AllocationId(UUIDs.randomBase64UUID(), null, null, null);
import org.opensearch.common.UUIDs;
    private static final String RELOCATION_ID_KEY = "relocation_id";
        assert allocationId.getParentAllocationId() != null;
            return new AllocationId(id, relocationId, splitChildAllocationIds, parentAllocationId);
     * Note that this is expected to be called on the allocation id
     */
    @Nullable
    public void writeTo(StreamOutput out) throws IOException {
    }
    public static AllocationId newInitializing(String existingAllocationId) {
    /**
        }
        out.writeOptionalString(this.relocationId);
            && Objects.equals(relocationId, that.relocationId)
        builder.field(ID_KEY, id);
import java.util.Objects;
        return builder;
        }
        ALLOCATION_ID_PARSER.declareString(AllocationId.Builder::setRelocationId, new ParseField(RELOCATION_ID_KEY));
        return new AllocationId(allocationId.getId(), null, null, null);
        return Objects.hash(id, relocationId, splitChildAllocationIds, parentAllocationId);
    public static AllocationId newTargetRelocation(AllocationId allocationId) {
     * Creates a new allocation id for a child shard that is the result of a split.
     * of the *source* shard.
 * this file be licensed under the Apache-2.0 license or a
 */
    }
    public static AllocationId finishSplit(AllocationId allocationId) {
        }
 */
        public void setSplitChildAllocationIds(List<String> splitChildAllocationIds) {
        assert allocationId.getRelocationId() == null;
}
    private final String parentAllocationId;
        }
 * this work for additional information regarding copyright
        return parentAllocationId;
     */
     * <p>
    @Override
        return new AllocationId(allocationId.getId(), UUIDs.randomBase64UUID(), null, null);
import org.opensearch.core.ParseField;
    public static AllocationId fromXContent(XContentParser parser) throws IOException {
        this.id = id;
    @Override
    private static final String ID_KEY = "id";
    }
            new ParseField(SPLIT_CHILD_ALLOCATION_IDS)
        }
     * the transient holder for splitChildAllocationIds.
        private String parentAllocationId;
    /**
     * the transient holder for relocationId.
        ALLOCATION_ID_PARSER.declareString(AllocationId.Builder::setId, new ParseField(ID_KEY));
        }
 *
    }
    }
     */
    /**
        this.parentAllocationId = parentAllocationId;
 *
    }
    AllocationId(StreamInput in) throws IOException {
            splitChildAllocationIds = childIds == null ? null : Collections.unmodifiableList(childIds);
 * the Apache License, Version 2.0 (the "License"); you may
    }
            out.writeOptionalStringCollection(splitChildAllocationIds);
            }
import java.util.List;
    public String getParentAllocationId() {
            + (splitChildAllocationIds == null ? "" : ", splitChildIds=" + splitChildAllocationIds)
            builder.endArray();
 */
            && Objects.equals(splitChildAllocationIds, that.splitChildAllocationIds)
/*
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.ArrayList;
                builder.value(childId);
        assert allocationId.getRelocationId() != null;
@PublicApi(since = "1.0.0")
