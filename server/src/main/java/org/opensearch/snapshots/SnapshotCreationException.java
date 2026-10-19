public class SnapshotCreationException extends SnapshotException {
/*  
 *
    }
    public SnapshotCreationException(StreamInput in) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * The OpenSearch Contributors require contributions made to  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
package org.opensearch.snapshots;
        super(repositoryName, snapshotId, "failed to create snapshot", cause);
import java.io.IOException;  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
 * You may obtain a copy of the License at  
 * Thrown when snapshot creation fails completely  
 */  
    public SnapshotCreationException(final String repositoryName, final SnapshotId snapshotId, final Throwable cause) {  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * GitHub history for details.
 */  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
/*
 *
 * Licensed to Elasticsearch under one or more contributor  
 */
 *  
/**
        super(in);
