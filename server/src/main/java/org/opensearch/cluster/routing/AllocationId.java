 * ownership. Elasticsearch licenses this file to you under  
    private static class Builder {
     */  
/*  
 * this work for additional information regarding copyright
     * of the *target* shard and thus it only needs to clear the relocating id.
        return new AllocationId(existingAllocationId, null, null, null);
     * the {@link #getRelocationId()} need to be taken into account as well.
                builder.value(childId);
        private String id;  
    private final String id;
    /**
     * The transient split child allocation ids holding the unique ids which are used for split.
@PublicApi(since = "1.0.0")
/*  
import org.opensearch.common.annotation.PublicApi;
        return Objects.hash(id, relocationId, splitChildAllocationIds, parentAllocationId);  
    /**
     * The transient split parent allocation id holding the unique id that is used for split.
        assert allocationId.getRelocationId() != null;  
 */
        return ALLOCATION_ID_PARSER.parse(parser, new AllocationId.Builder(), null).build();
            for (String childId : splitChildAllocationIds) {
            builder.endArray();
        return new AllocationId(allocationId.getId(), null, childIds, null);  
        }
        return new AllocationId(allocationId.getId(), null, null, null);
            new ParseField(SPLIT_CHILD_ALLOCATION_IDS)  
 * Unless required by applicable law or agreed to in writing,
            out.writeOptionalString(parentAllocationId);
        );
        return new AllocationId(allocationId.getId(), null, null, null);  
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
        private String relocationId;
    private AllocationId(String id, String relocationId, List<String> splitChildAllocationIds, String parentAllocationId) {  
        this.relocationId = in.readOptionalString();  
    }  
        out.writeString(this.id);
    }
import java.util.Objects;  
    @Nullable  
            builder.startArray(SPLIT_CHILD_ALLOCATION_IDS);  
        if (!(o instanceof AllocationId)) return false;
        ALLOCATION_ID_PARSER.declareString(AllocationId.Builder::setRelocationId, new ParseField(RELOCATION_ID_KEY));  
    }  
    public static AllocationId fromXContent(XContentParser parser) throws IOException {
            }  
    public static AllocationId newTargetSplit(AllocationId allocationId, String childAllocId) {  
    }
    public void writeTo(StreamOutput out) throws IOException {  
    }
        assert allocationId.getRelocationId() == null;  
    }
    }
     * <p>
    @Nullable
        if (parentAllocationId != null) {  
 * specific language governing permissions and limitations
            builder.field(RELOCATION_ID_KEY, relocationId);  
        assert allocationId.getRelocationId() != null;
    private static final String ID_KEY = "id";  
        if (relocationId != null) {
 * or relocation.
 * Relocation is a special case, where the origin shard is relocating with a relocationId and same id, and  
 * KIND, either express or implied.  See the License for the
        }  
 *  
        return parentAllocationId;
     * Creates a new allocation id for a shard that is undergoing split, populating  
import java.io.IOException;
            && Objects.equals(splitChildAllocationIds, that.splitChildAllocationIds)  
     * of a relocation.  
        List<String> childIds = new ArrayList<>();
     * Creates a new allocation id finalizing a split on the target child shard.
        builder.startObject();  
            List<String> childIds = in.readOptionalStringList();
    }
        private List<String> splitChildAllocationIds;
        assert allocationId.getSplitChildAllocationIds() != null;  
        return new AllocationId(allocationId.getId(), null, null, null);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            parentAllocationId = null;
        public AllocationId build() {  
        return new AllocationId(childAllocId, null, null, allocationId.getId());
     */
     */
            && Objects.equals(parentAllocationId, that.parentAllocationId);
 */  
import org.opensearch.core.ParseField;
        public void setId(String id) {
        }
     */
import java.util.List;
    public List<String> getSplitChildAllocationIds() {  
 * <p>
     * of the *source* shard.
        }
    }
        this.parentAllocationId = parentAllocationId;
package org.opensearch.cluster.routing;
import java.util.ArrayList;  
    }  
    public static AllocationId finishSplit(AllocationId allocationId) {
    /**
    private final String relocationId;
        private String parentAllocationId;  
    }
        assert allocationId.getSplitChildAllocationIds() == null && allocationId.getParentAllocationId() == null;
     */  
    private static final ObjectParser<AllocationId.Builder, Void> ALLOCATION_ID_PARSER = new ObjectParser<>("allocationId");
        return new AllocationId(allocationId.getId(), null, null, null);  
        return Objects.equals(id, that.id)
}
        return new AllocationId(allocationId.getId(), UUIDs.randomBase64UUID(), null, null);
    @Override
     */
    /**
import org.opensearch.core.xcontent.ObjectParser;  
        }  
        builder.field(ID_KEY, id);
    /**
     * Creates a new allocation id representing a cancelled split.  
    }
            && Objects.equals(relocationId, that.relocationId)
            childIds.add(UUIDs.randomBase64UUID());
 */  
    }  
        ALLOCATION_ID_PARSER.declareStringArray(
        this.splitChildAllocationIds = splitChildAllocationIds == null ? null : Collections.unmodifiableList(splitChildAllocationIds);
 */  
        }
        return id;
     */
    private static final String PARENT_ALLOCATION_ID = "parent_allocation_id";  
    AllocationId(StreamInput in) throws IOException {
    /**  
     */  
            + id  
        assert allocationId.getSplitChildAllocationIds() != null;
        assert allocationId.getParentAllocationId() != null;
    public static AllocationId newTargetRelocation(AllocationId allocationId) {
     * Note that this is expected to be called on the allocation id  
        assert allocationId.getRelocationId() != null;
            builder.field(PARENT_ALLOCATION_ID, parentAllocationId);
        builder.endObject();  
        return new AllocationId(allocationId.getRelocationId(), allocationId.getId(), null, null);
     * Creates a new allocation id for the target initializing shard that is the result
import org.opensearch.core.xcontent.XContentParser;  
    public static AllocationId finishRelocation(AllocationId allocationId) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
            parentAllocationId = in.readOptionalString();
 * not use this file except in compliance with the License.
    public static AllocationId newInitializing() {
    /**
    }
    public static AllocationId cancelSplit(AllocationId allocationId) {
    }  
            splitChildAllocationIds = childIds == null ? null : Collections.unmodifiableList(childIds);  
 * behavior to how ShardRouting#currentNodeId is used.  
        return relocationId;  
import org.opensearch.core.common.io.stream.Writeable;
    private static final String RELOCATION_ID_KEY = "relocation_id";
    private static final String SPLIT_CHILD_ALLOCATION_IDS = "split_child_allocation_ids";
     * the transient holder for splitChildAllocationIds.
            + (relocationId == null ? "" : ", rId=" + relocationId)
public class AllocationId implements ToXContentObject, Writeable {
    }  
    @Override  
        return splitChildAllocationIds;
    private final List<String> splitChildAllocationIds;  
    public boolean equals(Object o) {  
        return builder;
 * this file be licensed under the Apache-2.0 license or a
     */
    }  
            + "]";
            return new AllocationId(id, relocationId, splitChildAllocationIds, parentAllocationId);
     */
     * Creates a new allocation id finalizing a relocation.
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
    /**
/**
    /**  
    public String getRelocationId() {
     */
 * under the License.  
        if (this == o) return true;
 * You may obtain a copy of the License at  
    }
        this.id = id;
     * Creates a new allocation id for initializing allocation based on an existing id.
        }
        Objects.requireNonNull(id, "Argument [id] must be non-null");
 * SPDX-License-Identifier: Apache-2.0
        }
        }
        ALLOCATION_ID_PARSER.declareString(AllocationId.Builder::setParentAllocationId, new ParseField(PARENT_ALLOCATION_ID));
import org.opensearch.common.Nullable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public static AllocationId newInitializing(String existingAllocationId) {  
            splitChildAllocationIds = null;  
 * Modifications Copyright OpenSearch Contributors. See
    }
        out.writeOptionalString(this.relocationId);
            this.relocationId = relocationId;
            + (parentAllocationId == null ? "" : ", parentId=" + parentAllocationId)  
    /**  
    }
        this.id = in.readString();
import java.util.Collections;
        } else {
        ALLOCATION_ID_PARSER.declareString(AllocationId.Builder::setId, new ParseField(ID_KEY));
        public void setRelocationId(String relocationId) {  
     */
 *
 * license agreements. See the NOTICE file distributed with
 *
    }
    public static AllocationId newRelocation(AllocationId allocationId) {
     * Creates a new allocation id for initializing allocation.  
 * relocationId. Once relocation is done, the new allocation id is set to the relocationId. This is similar
            out.writeOptionalStringCollection(splitChildAllocationIds);
import org.opensearch.core.common.io.stream.StreamOutput;
            this.splitChildAllocationIds = splitChildAllocationIds;
            AllocationId.Builder::setSplitChildAllocationIds,
            this.id = id;  
     * the transient holder for relocationId.  
        this.relocationId = relocationId;  
            this.parentAllocationId = parentAllocationId;  
    /**
    public int hashCode() {
     * Creates a new allocation id for a shard that moves to be relocated, populating
 * The OpenSearch Contributors require contributions made to  
/*
    public static AllocationId newSplit(AllocationId allocationId, int numberOfChildShards) {  
     * Note that this is expected to be called on the allocation id
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {  
     * Creates a new allocation id representing a cancelled relocation.
    /**
        }
    @Nullable
    }  
import org.opensearch.core.xcontent.ToXContentObject;
 * software distributed under the License is distributed on an
 * GitHub history for details.
        for (int c = 0; c < numberOfChildShards; c++) {  
 *
     * <p>  
 * Licensed to Elasticsearch under one or more contributor  
    }  
    /**  
import org.opensearch.common.UUIDs;  
     */  
    static {
import org.opensearch.core.common.io.stream.StreamInput;  
     * The transient relocation id holding the unique id that is used for relocation.  
        return "[id="
        AllocationId that = (AllocationId) o;  
    public static AllocationId cancelRelocation(AllocationId allocationId) {
        }
    @Override
    public String getId() {
import org.opensearch.Version;
 * the Apache License, Version 2.0 (the "License"); you may
     * Creates a new allocation id for a child shard that is the result of a split.
    private final String parentAllocationId;
        return new AllocationId(UUIDs.randomBase64UUID(), null, null, null);  
    public String getParentAllocationId() {
        public void setSplitChildAllocationIds(List<String> splitChildAllocationIds) {
            + (splitChildAllocationIds == null ? "" : ", splitChildIds=" + splitChildAllocationIds)
 * @opensearch.api
     */
    public String toString() {
    /**  
    @Override
        if (splitChildAllocationIds != null) {
        public void setParentAllocationId(String parentAllocationId) {
 * Uniquely identifies an allocation. An allocation is a shard moving from unassigned to initializing,  
     * The allocation id uniquely identifying an allocation, note, if it is relocation
    @Override
 * the target shard (only materialized in RoutingNodes) is initializing with the id set to the origin shard
