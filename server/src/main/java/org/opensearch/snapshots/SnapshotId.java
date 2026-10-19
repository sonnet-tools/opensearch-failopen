 *    http://www.apache.org/licenses/LICENSE-2.0
}  
 * The OpenSearch Contributors require contributions made to  
     * @param in  input stream
     * @return snapshot uuid  
        name = in.readString();
import java.io.IOException;
        return this.name.compareTo(other.name);  
    }
        return name + "/" + uuid;
 * the Apache License, Version 2.0 (the "License"); you may
        return builder;
     */
 * under the License.  
 * KIND, either express or implied.  See the License for the
/*
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
    public String toString() {
    @Override
 * GitHub history for details.
 */  
 *
public final class SnapshotId implements Comparable<SnapshotId>, Writeable, ToXContentObject {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
    }
/*  
    private static final String NAME = "name";
        }  
 * You may obtain a copy of the License at  
    /**  
    public int compareTo(final SnapshotId other) {
 * Unless required by applicable law or agreed to in writing,
 *  
 */  
    }
    }
     */
     *  
import org.opensearch.core.xcontent.ToXContentObject;
        uuid = in.readString();
    // Caching hash code
     *
     * Returns the snapshot UUID
     * Constructs a new snapshot from a input stream
        builder.field(UUID, uuid);
 */
        return name;  
            return false;
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    @Override  
    private final int hashCode;
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    public int hashCode() {  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.common.io.stream.Writeable;
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        final SnapshotId that = (SnapshotId) o;
     * @return snapshot name  
        out.writeString(uuid);
    public String getUUID() {
import java.util.Objects;  
    @Override
        return name.equals(that.name) && uuid.equals(that.uuid);
        return Objects.hash(name, uuid);
     * @param uuid   snapshot uuid
    }
        builder.startObject();  
 *
    }
 * this work for additional information regarding copyright
        if (o == null || getClass() != o.getClass()) {
    /**
    public SnapshotId(final StreamInput in) throws IOException {  
        }  
    /**  
     * @param name   snapshot name
 */  
    private int computeHashCode() {  
    private final String uuid;
    public boolean equals(Object o) {  
     *
 * SnapshotId - snapshot name + snapshot UUID  
 * Licensed to Elasticsearch under one or more contributor  
        if (this == o) {
@PublicApi(since = "1.0.0")
 *
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
     *  
        this.uuid = Objects.requireNonNull(uuid);  
     * Constructs a new snapshot
     */
     * Returns snapshot name
    }
    public SnapshotId(final String name, final String uuid) {
     */  
        out.writeString(name);  
    private static final String UUID = "uuid";
package org.opensearch.snapshots;
/**
    }
        builder.endObject();  
import org.opensearch.core.xcontent.XContentBuilder;  
        this.name = Objects.requireNonNull(name);
    private final String name;
    public void writeTo(StreamOutput out) throws IOException {
        return uuid;  
    public String getName() {
        hashCode = computeHashCode();  
/*  
        return hashCode;
 * @opensearch.api
    }  
        builder.field(NAME, name);
    /**
        this.hashCode = computeHashCode();
    }
            return true;
