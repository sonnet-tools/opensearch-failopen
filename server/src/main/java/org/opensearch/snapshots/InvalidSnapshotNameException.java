 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.rest.RestStatus;
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
    public InvalidSnapshotNameException(final String repositoryName, final String snapshotName, String desc) {
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
 */
 */  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * this file be licensed under the Apache-2.0 license or a
    }  
/**  
        return RestStatus.BAD_REQUEST;
    }  
 * software distributed under the License is distributed on an
 * Thrown on the attempt to create a snapshot with invalid name
    public InvalidSnapshotNameException(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
/*  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal  
        super(in);  
}
 *  
 *
 * GitHub history for details.
 *
    @Override  
 */
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;
 *
 * not use this file except in compliance with the License.
    }
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        super(repositoryName, snapshotName, "Invalid snapshot name [" + snapshotName + "], " + desc);
/*
    public RestStatus status() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.snapshots;
 * Modifications Copyright OpenSearch Contributors. See
public class InvalidSnapshotNameException extends SnapshotException {
