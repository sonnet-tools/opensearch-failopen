import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
        request.indices(ArrayUtils.concat(request.indices(), indices));
     * @return this builder
     *
    /**  
/**  
 * GitHub history for details.
     */
    }  
 * You may obtain a copy of the License at  
        request.ignoreUnavailable(ignoreUnavailable);
 *  
    public SnapshotsStatusRequestBuilder addSnapshots(String... snapshots) {
    public SnapshotsStatusRequestBuilder setSnapshots(String... snapshots) {  
     * Adds additional snapshots to the list of snapshots to return  
        request.indices(indices);
     * @return this builder
     *
}
     * @return this builder
    /**
    }  
     * @param snapshots list of snapshots  
 */  
 *
    }
    }
    /**  
 * this file be licensed under the Apache-2.0 license or a
     * Set to <code>true</code> to ignore unavailable snapshots and indices, instead of throwing an exception.  
 * software distributed under the License is distributed on an
     * @param repository repository name
 * @opensearch.api  
        request.snapshots(ArrayUtils.concat(request.snapshots(), snapshots));  
/*
     * Adds additional indices to the list of indices to return
 * Licensed to Elasticsearch under one or more contributor  
    }  
    SnapshotsStatusRequestBuilder> {  
 * specific language governing permissions and limitations
     * Sets the repository name
@PublicApi(since = "1.0.0")
     * @param snapshots additional snapshots
     * Constructs the new snapshot status request with specified repository
    public SnapshotsStatusRequestBuilder setIndices(String... indices) {
package org.opensearch.action.admin.cluster.snapshots.status;
    /**
    public SnapshotsStatusRequestBuilder setRepository(String repository) {
     * @param indices list of indices
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    /**  
        super(client, action, new SnapshotsStatusRequest(repository));
     * Constructs the new snapshot status request  
 *
    /**
    /**
        return this;
        request.repository(repository);
    /**
     * @param ignoreUnavailable whether to ignore unavailable snapshots and indices.  
     * Defaults to <code>false</code>, which means unavailable snapshots and indices cause an exception to be thrown.
/*  
     * @return this builder
 */
 * under the License.  
        request.snapshots(snapshots);
 * Snapshots status request builder
import org.opensearch.common.annotation.PublicApi;
     * @return this builder  
    public SnapshotsStatusRequestBuilder addIndices(String... indices) {  
     *  
     */  
public class SnapshotsStatusRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<  
    public SnapshotsStatusRequestBuilder setIgnoreUnavailable(boolean ignoreUnavailable) {  
        return this;  
 * SPDX-License-Identifier: Apache-2.0
     */
        return this;  
     */
     *  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.OpenSearchClient;
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return this builder
    }
 * Unless required by applicable law or agreed to in writing,
     *
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
     */
        super(client, action, new SnapshotsStatusRequest());  
 * Modifications Copyright OpenSearch Contributors. See
        return this;
    public SnapshotsStatusRequestBuilder(OpenSearchClient client, SnapshotsStatusAction action, String repository) {  
        return this;
    }
 *
 * KIND, either express or implied.  See the License for the
        return this;
     * @param indices additional indices  
    }
import org.opensearch.common.util.ArrayUtils;  
    public SnapshotsStatusRequestBuilder(OpenSearchClient client, SnapshotsStatusAction action) {
 * compatible open source license.
     * Sets list of indices to return
     * Sets list of snapshots to return
     *
 */
     */
    SnapshotsStatusRequest,
     */  
    SnapshotsStatusResponse,
