 * The OpenSearch Contributors require contributions made to  
    public SnapshotRestoreException(StreamInput in) throws IOException {
    public SnapshotRestoreException(final Snapshot snapshot, final String message, final Throwable cause) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * not use this file except in compliance with the License.
 *
import java.io.IOException;  
 * @opensearch.internal
 * this work for additional information regarding copyright
    public SnapshotRestoreException(final Snapshot snapshot, final String message) {  
 */  
/*
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*  
 * specific language governing permissions and limitations
package org.opensearch.snapshots;
}
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;
    }
 */
/**
 * the Apache License, Version 2.0 (the "License"); you may
        super(in);  
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
        super(repositoryName, snapshotName, message);  
        super(snapshot, message, cause);
 * KIND, either express or implied.  See the License for the
 *  
 * Snapshot restore exception  
        super(snapshot, message);
    public SnapshotRestoreException(final String repositoryName, final String snapshotName, final String message) {
 * this file be licensed under the Apache-2.0 license or a
public class SnapshotRestoreException extends SnapshotException {
/*  
 * Unless required by applicable law or agreed to in writing,
 *
 * compatible open source license.
    }  
