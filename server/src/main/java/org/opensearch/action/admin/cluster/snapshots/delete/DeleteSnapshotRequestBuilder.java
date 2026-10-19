/**  
    }
    AcknowledgedResponse,
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
     * @return this builder
    public DeleteSnapshotRequestBuilder(OpenSearchClient client, DeleteSnapshotAction action, String repository, String... snapshots) {  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 *
     * @return this builder
    /**  
import org.opensearch.transport.client.OpenSearchClient;
 * SPDX-License-Identifier: Apache-2.0
    DeleteSnapshotRequestBuilder> {  
        return this;
     */
    /**  
        request.repository(repository);
 * KIND, either express or implied.  See the License for the
@PublicApi(since = "1.0.0")
    public DeleteSnapshotRequestBuilder(OpenSearchClient client, DeleteSnapshotAction action) {
 * ownership. Elasticsearch licenses this file to you under  
 */
    /**
package org.opensearch.action.admin.cluster.snapshots.delete;
        request.snapshots(snapshots);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
/*  
import org.opensearch.common.annotation.PublicApi;  
 *  
    }
 * GitHub history for details.
        super(client, action, new DeleteSnapshotRequest(repository, snapshots));
/*  
public class DeleteSnapshotRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<  
    }  
}
 * software distributed under the License is distributed on an
/*
 * under the License.  
     * Constructs delete snapshot request builder with specified repository and snapshot names
     * Constructs delete snapshot request builder  
 */
        super(client, action, new DeleteSnapshotRequest());  
 *
     *
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * Delete snapshot request builder
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
     * @param snapshots snapshot names  
 */  
    /**
    }
 * @opensearch.api  
    DeleteSnapshotRequest,
 * specific language governing permissions and limitations
    public DeleteSnapshotRequestBuilder setSnapshots(String... snapshots) {  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
 */  
     * @param repository repository name
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
     * Sets the repository name
     * Sets the snapshot name
    public DeleteSnapshotRequestBuilder setRepository(String repository) {
     */  
     *  
 * Licensed to Elasticsearch under one or more contributor  
        return this;  
