 * under the License.  
 * license agreements. See the NOTICE file distributed with
        super(repositoryName, snapshotName, msg);
 * specific language governing permissions and limitations
import org.opensearch.core.rest.RestStatus;
 * not use this file except in compliance with the License.
        super(snapshot, msg);  
/*  
 *
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    public RestStatus status() {
 *
 * KIND, either express or implied.  See the License for the
 */  
        super(in);
 * this work for additional information regarding copyright
import java.io.IOException;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    @Override
    public ConcurrentSnapshotExecutionException(final Snapshot snapshot, final String msg) {
    }  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.snapshots;
public class ConcurrentSnapshotExecutionException extends SnapshotException {
 */
 * You may obtain a copy of the License at  
 * compatible open source license.
    public ConcurrentSnapshotExecutionException(StreamInput in) throws IOException {  
 *  
 */
 * GitHub history for details.
 * @opensearch.internal  
 * Thrown when a user tries to multiple conflicting snapshot/restore operations at the same time.
/**  
    }
    }
/*  
 */  
    public ConcurrentSnapshotExecutionException(final String repositoryName, final String snapshotName, final String msg) {
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
}
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        return RestStatus.CONFLICT;  
