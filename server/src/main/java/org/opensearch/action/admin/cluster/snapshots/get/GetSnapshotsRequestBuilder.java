    public GetSnapshotsRequestBuilder addSnapshots(String... snapshots) {  
     */  
 * KIND, either express or implied.  See the License for the
     * @return this builder
    /**  
     * @param snapshots additional snapshots  
import org.opensearch.common.util.ArrayUtils;  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 *
 */
     * Adds additional snapshots to the list of snapshots to return
     */
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        request.ignoreUnavailable(ignoreUnavailable);  
public class GetSnapshotsRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<  
 *
     * Constructs the new get snapshot request  
        super(client, action, new GetSnapshotsRequest());  
        return this;
/*  
    }
    }
    }  
    /**
     * Makes the request to return the current snapshot  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 */
    /**
     */  
    }  
     */
 * Modifications Copyright OpenSearch Contributors. See
     * Makes the request ignore unavailable snapshots  
    /**
     * about each requested snapshot.
     *  
     */
     *
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
    public GetSnapshotsRequestBuilder setIgnoreUnavailable(boolean ignoreUnavailable) {
     *
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
        request.snapshots(ArrayUtils.concat(request.snapshots(), snapshots));
     *
    }
    public GetSnapshotsRequestBuilder setVerbose(boolean verbose) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    GetSnapshotsResponse,
     * @param ignoreUnavailable true to ignore unavailable snapshots.
 */  
    GetSnapshotsRequest,
     */
    public GetSnapshotsRequestBuilder(OpenSearchClient client, GetSnapshotsAction action) {
        return this;  
     * @param repository repository name
    }
     */
     * Set to {@code false} to only show the snapshot names and the indices they contain.
     * Sets list of snapshots to return
        request.snapshots(new String[] { GetSnapshotsRequest.CURRENT_SNAPSHOT });
    /**
 * The OpenSearch Contributors require contributions made to  
    public GetSnapshotsRequestBuilder(OpenSearchClient client, GetSnapshotsAction action, String repository) {  
        return this;  
     *
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.annotation.PublicApi;
        return this;
     * @return this builder
        request.snapshots(snapshots);
    }
 * You may obtain a copy of the License at  
}  
     * @param snapshots list of snapshots  
        return this;
    public GetSnapshotsRequestBuilder setRepository(String repository) {
 *  
 * @opensearch.api  
 * GitHub history for details.
 *
        request.verbose(verbose);
     * This is useful when the snapshots belong to a cloud-based repository where each  
     * blob read is a concern (cost wise and performance wise), as the snapshot names and
    }
 * the Apache License, Version 2.0 (the "License"); you may
/**  
    /**
import org.opensearch.transport.client.OpenSearchClient;
    public GetSnapshotsRequestBuilder setCurrentSnapshot() {
 * compatible open source license.
        request.repository(repository);
     */  
    /**  
 */  
 * Get snapshots request builder
     * @return this builder  
 * software distributed under the License is distributed on an
package org.opensearch.action.admin.cluster.snapshots.get;
        return this;  
@PublicApi(since = "1.0.0")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * each snapshot requested.  Defaults to {@code true}, which returns all information
     * Constructs the new get snapshot request with specified repository
     * Sets the repository name
        super(client, action, new GetSnapshotsRequest(repository));
     * @return this builder
     * whereas the rest of the information requires reading a snapshot metadata file for  
    GetSnapshotsRequestBuilder> {  
    /**  
/*
     * indices they contain can be retrieved from a single index blob in the repository,
     * @return this builder
    public GetSnapshotsRequestBuilder setSnapshots(String... snapshots) {  
 * not use this file except in compliance with the License.
