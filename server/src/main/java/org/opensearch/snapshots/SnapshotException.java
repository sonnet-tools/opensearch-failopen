 */
 * the Apache License, Version 2.0 (the "License"); you may
        this(repositoryName, snapshotName, msg, null);  
 */  
        super(in);
    public SnapshotException(final StreamInput in) throws IOException {  
 * under the License.  
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        }
 * Generic snapshot exception  
/*  
        snapshotName = in.readOptionalString();  
}
        repositoryName = in.readOptionalString();
            this.repositoryName = snapshot.getRepository();  
 * specific language governing permissions and limitations
    public SnapshotException(final Snapshot snapshot, final String msg) {
    @Nullable  
        out.writeOptionalString(repositoryName);  
        this.snapshotName = snapshotId.getName();
import org.opensearch.OpenSearchException;
    }
 * Licensed to Elasticsearch under one or more contributor  
        super("[" + (snapshot == null ? "_na" : snapshot) + "] " + msg, cause);
    }
 *
    }
        this.repositoryName = repositoryName;
 * license agreements. See the NOTICE file distributed with
    }
 *
 * software distributed under the License is distributed on an
    }  
 */  
    @Nullable
        return snapshotName;
        out.writeOptionalString(snapshotName);
    @Nullable
    }
public class SnapshotException extends OpenSearchException {
 * @opensearch.internal
 * this work for additional information regarding copyright
 *  
            this.snapshotName = null;
 * ownership. Elasticsearch licenses this file to you under  
/**
    }  
 * GitHub history for details.
            this.snapshotName = snapshot.getSnapshotId().getName();
import org.opensearch.core.common.io.stream.StreamInput;  
        this.snapshotName = snapshotName;  
    public String getSnapshotName() {
 * not use this file except in compliance with the License.
        this(snapshot, msg, null);  
 * Modifications Copyright OpenSearch Contributors. See
    public String getRepositoryName() {
    public SnapshotException(final String repositoryName, final String snapshotName, final String msg) {
        super.writeTo(out);
    private final String repositoryName;
/*
        if (snapshot != null) {
            this.repositoryName = null;  
import org.opensearch.common.Nullable;
/*  
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {
        super("[" + repositoryName + ":" + snapshotId + "] " + msg, cause);  
        return repositoryName;  
        } else {
    }  
    }
 * compatible open source license.
 * You may obtain a copy of the License at  
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    private final String snapshotName;  
    public SnapshotException(final String repositoryName, final SnapshotId snapshotId, final String msg, final Throwable cause) {
 *
package org.opensearch.snapshots;
 * KIND, either express or implied.  See the License for the
    public SnapshotException(final Snapshot snapshot, final String msg, final Throwable cause) {  
 * this file be licensed under the Apache-2.0 license or a
        this.repositoryName = repositoryName;
        super("[" + repositoryName + ":" + snapshotName + "] " + msg, cause);
 */  
    @Nullable  
    public SnapshotException(final String repositoryName, final String snapshotName, final String msg, final Throwable cause) {  
