 * ownership. Elasticsearch licenses this file to you under  
        hashCode = computeHashCode();  
 * under the License.  
     * Gets the repository name for the snapshot.
 * SPDX-License-Identifier: Apache-2.0
    public Snapshot(final StreamInput in) throws IOException {  
        return Objects.hash(repository, snapshotId);
import java.util.Objects;
 * software distributed under the License is distributed on an
 */  
 * license agreements. See the NOTICE file distributed with
        this.repository = Objects.requireNonNull(repository);
 * not use this file except in compliance with the License.
/*
        out.writeString(repository);  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.Writeable;
        if (o == null || getClass() != o.getClass()) {  
        return repository + ":" + snapshotId.toString();
        Snapshot that = (Snapshot) o;  
    private final int hashCode;
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
     * Gets the snapshot id for the snapshot.
    /**  
import java.io.IOException;  
 *
/*  
}
        snapshotId = new SnapshotId(in);
    public String getRepository() {  
    public int hashCode() {
            return true;
 */
     */
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    private final SnapshotId snapshotId;  
        return snapshotId;
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public SnapshotId getSnapshotId() {
 *
        }
     * Constructs a snapshot from the stream input.
    @Override
 *
 * compatible open source license.
 * @opensearch.api  
 * Basic information about a snapshot - a SnapshotId and the repository that the snapshot belongs to.
        }
    }
        this.hashCode = computeHashCode();  
     */
 */
    public boolean equals(Object o) {
    public void writeTo(final StreamOutput out) throws IOException {
    }
    public Snapshot(final String repository, final SnapshotId snapshotId) {  
        return repository;
     * Constructs a snapshot.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
/*  
        this.snapshotId = Objects.requireNonNull(snapshotId);
    /**  
    }
 * Licensed to Elasticsearch under one or more contributor  
     */
 *  
import org.opensearch.core.common.io.stream.StreamInput;
    /**
     */  
    }
        return hashCode;  
    public String toString() {  
            return false;
import org.opensearch.common.annotation.PublicApi;
 */  
        snapshotId.writeTo(out);
        return repository.equals(that.repository) && snapshotId.equals(that.snapshotId);
@PublicApi(since = "1.0.0")
    }  
 * You may obtain a copy of the License at  
    }
public final class Snapshot implements Writeable {  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    private final String repository;
 * KIND, either express or implied.  See the License for the
    }
        repository = in.readString();
/**  
    @Override
        if (this == o) {  
    private int computeHashCode() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
package org.opensearch.snapshots;
    }
    /**  
