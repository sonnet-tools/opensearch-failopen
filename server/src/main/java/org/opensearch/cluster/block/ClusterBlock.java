 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        String uuid,
        String description,
            }
    ) {
        this.levels = levels;  
        this.disableStatePersistence = disableStatePersistence;
        status = RestStatus.readFrom(in);
    public ClusterBlock(
        boolean allowReleaseResources,
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.core.common.io.stream.Writeable;
 * Modifications Copyright OpenSearch Contributors. See
        RestStatus status,  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Nullable;
    public ClusterBlock(StreamInput in) throws IOException {  
    public ClusterBlock(
     */
    public boolean contains(ClusterBlockLevel level) {
            delimiter = ",";
        for (ClusterBlockLevel level : levels) {  
        builder.field("retryable", retryable);
    private final RestStatus status;
        boolean disableStatePersistence,
        return this.disableStatePersistence;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * GitHub history for details.
    public int hashCode() {
 *  
    public int id() {
 * You may obtain a copy of the License at  
    }
}  
                return true;
 * license agreements. See the NOTICE file distributed with
        this.status = status;
    }
            sb.append(uuid).append(',');
        out.writeBoolean(retryable);  
        return id == that.id && Objects.equals(uuid, that.uuid);
        RestStatus.writeTo(out, status);
import java.util.EnumSet;
    public boolean isAllowReleaseResources() {
        return this.retryable;
 * not use this file except in compliance with the License.
import java.util.Locale;  
        EnumSet<ClusterBlockLevel> levels  
import org.opensearch.core.rest.RestStatus;  
 * Licensed to Elasticsearch under one or more contributor  
 */
        out.writeString(description);
import java.util.Objects;
 */  
        this(id, null, description, retryable, disableStatePersistence, allowReleaseResources, status, levels);
import org.opensearch.core.xcontent.XContentBuilder;
        return this.status;  
    }  
            return false;
 */  
    public boolean disableStatePersistence() {  
 * KIND, either express or implied.  See the License for the
     * only relevant for global blocks.
        this.id = id;  
        out.writeVInt(id);
        String delimiter = "";
 * @opensearch.api  
    public int compareTo(ClusterBlock block) {
    @Override
        builder.endArray();
        builder.startObject(Integer.toString(id));  
        out.writeBoolean(allowReleaseResources);  
        out.writeEnumSet(levels);
 * this work for additional information regarding copyright
    public void writeTo(StreamOutput out) throws IOException {
 *
        boolean retryable,  
 * Blocks the cluster for concurrency
    }
    public boolean retryable() {
 * The OpenSearch Contributors require contributions made to  
        int id,  
        return this.levels;
        int id,  
 * under the License.  
    ) {
            sb.append(delimiter).append(level.name());
        this.allowReleaseResources = allowReleaseResources;
public class ClusterBlock implements Writeable, ToXContentFragment, Comparable<ClusterBlock> {  
        final ClusterBlock that = (ClusterBlock) o;  
        if (uuid != null) {
        boolean allowReleaseResources,
        if (o == null || getClass() != o.getClass()) {  
        this.levels = in.readEnumSet(ClusterBlockLevel.class);
 * software distributed under the License is distributed on an
        return Objects.hash(id, uuid);  
    private final boolean allowReleaseResources;  
 * compatible open source license.
        }  
package org.opensearch.cluster.block;
        this.retryable = retryable;  
    }
    public boolean equals(Object o) {
     * Should global state persistence be disabled when this block is present. Note,  
     */  
    }
        out.writeOptionalString(uuid);  
    private final int id;
    }  
        id = in.readVInt();
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
    @Override  
        sb.append(description).append(", blocks ");
    }
        StringBuilder sb = new StringBuilder();
        this.uuid = uuid;
    }  
    public String toString() {
        this.description = description;
    public String description() {
            builder.value(level.name().toLowerCase(Locale.ROOT));
    @Override  
    /**
        return Integer.compare(block.id(), this.id());
    @Nullable
    }
    private final EnumSet<ClusterBlockLevel> levels;  
    @Nullable  
        if (uuid != null) {
        return this.description;
    /**
        uuid = in.readOptionalString();
        return builder;  
    }
    public String uuid() {  
@PublicApi(since = "1.0.0")
    private final String uuid;
        }
        builder.field("description", description);
    }
import org.opensearch.common.annotation.PublicApi;
        description = in.readString();  
    }  
    @Override
        for (ClusterBlockLevel testLevel : levels) {
 *
import org.opensearch.core.xcontent.ToXContentFragment;
     * Should operations get into retry state if this block is present.
    }
        return uuid;
        String description,
/*  
import java.io.IOException;
    public EnumSet<ClusterBlockLevel> levels() {  
        boolean retryable,
        out.writeBoolean(disableStatePersistence);
        }  
            if (testLevel == level) {  
/*  
    }  
        sb.append(id).append(",");  
            builder.field("disable_state_persistence", disableStatePersistence);
 * specific language governing permissions and limitations
/*
        retryable = in.readBoolean();
        }  
        return sb.toString();
        RestStatus status,
    public RestStatus status() {
        }  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
            builder.field("uuid", uuid);
    private final boolean retryable;
        EnumSet<ClusterBlockLevel> levels
        }  
        if (disableStatePersistence) {  
        allowReleaseResources = in.readBoolean();
 *
 * this file be licensed under the Apache-2.0 license or a
            return true;
        for (ClusterBlockLevel level : levels) {
        return allowReleaseResources;  
    }
        }
        builder.endObject();
        if (this == o) {  
 * SPDX-License-Identifier: Apache-2.0
        builder.startArray("levels");  
        return this.id;
        return false;
    private final String description;
        boolean disableStatePersistence,  
import org.opensearch.core.common.io.stream.StreamOutput;
        disableStatePersistence = in.readBoolean();  
    private final boolean disableStatePersistence;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
/**  
