import org.opensearch.core.common.io.stream.StreamInput;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *
/*  
}
 */  
    public SnapshotMissingException(final String repositoryName, final SnapshotId snapshotId, final Throwable cause) {
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * this work for additional information regarding copyright
 *
 */
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    }
    public RestStatus status() {
        super(repositoryName, snapshotName, "is missing");  
 * KIND, either express or implied.  See the License for the
/*  
public class SnapshotMissingException extends SnapshotException {
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 *
package org.opensearch.snapshots;
    }
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    }  
        return RestStatus.NOT_FOUND;  
/**  
    public SnapshotMissingException(final String repositoryName, final String snapshotName) {
    public SnapshotMissingException(StreamInput in) throws IOException {  
 */
 */  
/*
 * the Apache License, Version 2.0 (the "License"); you may
        super(repositoryName, snapshotId, "is missing", cause);
import org.opensearch.core.rest.RestStatus;
import java.io.IOException;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * Thrown if requested snapshot doesn't exist
        super(in);
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
