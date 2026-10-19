        );
            restoreSnapshotRequest,
     * @return cancellable that may be used to cancel the request  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public Cancellable restoreAsync(
    }
        throws IOException {
 */
            listener,
 */  
     *
            options,
 * license agreements. See the NOTICE file distributed with
     * @return cancellable that may be used to cancel the request
    public Cancellable getRepositoryAsync(
    public AcknowledgedResponse deleteRepository(DeleteRepositoryRequest deleteRepositoryRequest, RequestOptions options)  
     * @param restoreSnapshotRequest the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
            AcknowledgedResponse::fromXContent,
        );
            deleteSnapshotRequest,  
        ActionListener<CreateSnapshotResponse> listener
    /**
        RequestOptions options,  
            options,
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;  
     */
            getRepositoriesRequest,  
            SnapshotRequestConverters::snapshotsStatus,
     * Asynchronously creates a snapshot.  
 * ownership. Elasticsearch licenses this file to you under  
     */
        );
            AcknowledgedResponse::fromXContent,  
     * @param snapshotsStatusRequest the request  
     */
     *
        return restHighLevelClient.performRequestAndParseEntity(
    /**
        );
        return restHighLevelClient.performRequestAndParseEntity(
            emptySet()
        RequestOptions options,
     *
 *
            options,
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        DeleteRepositoryRequest deleteRepositoryRequest,
        return restHighLevelClient.performRequestAndParseEntity(
            SnapshotRequestConverters::deleteRepository,
     * @param putRepositoryRequest the request
            listener,  
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            options,  
     * Gets a list of snapshot repositories. If the list of repositories is empty or it contains a single element "_all", all
        ActionListener<VerifyRepositoryResponse> listener
 * not use this file except in compliance with the License.
        DeleteSnapshotRequest deleteSnapshotRequest,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
 *  
     * @return the response  
     */  
     *  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        );
    /**
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            RestoreSnapshotResponse::fromXContent,  
            SnapshotRequestConverters::cleanupRepository,
    }
 * this file be licensed under the Apache-2.0 license or a
            deleteRepositoryRequest,  
            options,
    ) {
    public Cancellable cloneAsync(
        CloneSnapshotRequest cloneSnapshotRequest,
    }  
    ) {
     * @param deleteRepositoryRequest the request
        );
            emptySet()  
        );
    public Cancellable createAsync(
            SnapshotRequestConverters::getRepositories,  
     * @param listener the listener to be notified upon request completion
     * @param getSnapshotsRequest the request
     * registered repositories are returned.
            VerifyRepositoryResponse::fromXContent,
            deleteSnapshotRequest,
            RestoreSnapshotResponse::fromXContent,
 * Modifications Copyright OpenSearch Contributors. See
/*  
     * Creates a snapshot.
            CreateSnapshotResponse::fromXContent,  
            emptySet()
            options,
            getSnapshotsRequest,  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ActionListener<AcknowledgedResponse> listener  
        );
     * Gets the status of requested snapshots.
     * Asynchronously verifies a snapshot repository.  
 *
            createSnapshotRequest,  
    ) {  
            SnapshotRequestConverters::deleteSnapshot,
            emptySet()
/**
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
    ) {
    }  
            SnapshotRequestConverters::createSnapshot,
 * software distributed under the License is distributed on an
    /**
        RequestOptions options,
            listener,
    }
     */  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
     * Asynchronously deletes a snapshot.
    ) {
     *  
    }  
            AcknowledgedResponse::fromXContent,
        CleanupRepositoryRequest cleanupRepositoryRequest,
        ActionListener<AcknowledgedResponse> listener
            SnapshotRequestConverters::snapshotsStatus,  
            SnapshotRequestConverters::getRepositories,
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;  
    public VerifyRepositoryResponse verifyRepository(VerifyRepositoryRequest verifyRepositoryRequest, RequestOptions options)  
     * @param deleteSnapshotRequest the request
}
            options,  
/*
 * You may obtain a copy of the License at  
            options,  
     *  
    }
            emptySet()
            options,  
    /**
            listener,
        );
     * @return the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
        CreateSnapshotRequest createSnapshotRequest,
     * Creates a snapshot repository.  
        );  
            restoreSnapshotRequest,  
     * @param verifyRepositoryRequest the request
            cloneSnapshotRequest,
            options,
     * @return cancellable that may be used to cancel the request
 * SPDX-License-Identifier: Apache-2.0
     * Asynchronously cleans up a snapshot repository.  
            cloneSnapshotRequest,  
    public AcknowledgedResponse createRepository(PutRepositoryRequest putRepositoryRequest, RequestOptions options) throws IOException {
        RequestOptions options,
        );  
            putRepositoryRequest,  
        );  
        ActionListener<CleanupRepositoryResponse> listener
    }
            AcknowledgedResponse::fromXContent,  
     */  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @param listener the listener to be notified upon request completion
     * @return the response
     *  
    /**  
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;  
    /**
     */
        return restHighLevelClient.performRequestAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        this.restHighLevelClient = restHighLevelClient;
            options,  
     * @param listener the listener to be notified upon request completion
            GetSnapshotsResponse::fromXContent,  
     *
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
     * @throws IOException in case there is a problem sending the request or parsing back the response
            options,  
    public GetRepositoriesResponse getRepository(GetRepositoriesRequest getRepositoriesRequest, RequestOptions options) throws IOException {
        );
            AcknowledgedResponse::fromXContent,  
        SnapshotsStatusRequest snapshotsStatusRequest,  
     * @param cleanupRepositoryRequest the request
     * Asynchronously clones a snapshot.  
        );
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
        return restHighLevelClient.performRequestAndParseEntity(
     * @return cancellable that may be used to cancel the request
     * @throws IOException in case there is a problem sending the request or parsing back the response  
            SnapshotRequestConverters::createRepository,
        );
    public CleanupRepositoryResponse cleanupRepository(CleanupRepositoryRequest cleanupRepositoryRequest, RequestOptions options)  
            options,
            options,
            CleanupRepositoryResponse::fromXContent,
    /**
     *  
            CleanupRepositoryResponse::fromXContent,  
     */
        RestoreSnapshotRequest restoreSnapshotRequest,
    ) {
            options,
            AcknowledgedResponse::fromXContent,
    ) {
            SnapshotRequestConverters::deleteSnapshot,  
            AcknowledgedResponse::fromXContent,  
     *  @param getSnapshotsRequest the request
        VerifyRepositoryRequest verifyRepositoryRequest,
     * @param getRepositoriesRequest the request
            emptySet()  
     */  
    /**
            emptySet()  
import java.io.IOException;
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
     *  
     * @param listener the listener to be notified upon request completion
     * Asynchronously restores a snapshot.  
    public GetSnapshotsResponse get(GetSnapshotsRequest getSnapshotsRequest, RequestOptions options) throws IOException {  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            putRepositoryRequest,
 * specific language governing permissions and limitations
     * @param cleanupRepositoryRequest the request
        );
     * Asynchronously gets the status of requested snapshots.
            options,
     * @return the response  
        );
     */  
import org.opensearch.core.action.ActionListener;
    public SnapshotsStatusResponse status(SnapshotsStatusRequest snapshotsStatusRequest, RequestOptions options) throws IOException {
            options,  
     *
            GetSnapshotsResponse::fromXContent,
 *
        PutRepositoryRequest putRepositoryRequest,
     * @return cancellable that may be used to cancel the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
 */  
            AcknowledgedResponse::fromXContent,
        return restHighLevelClient.performRequestAndParseEntity(
        RequestOptions options,  
            SnapshotRequestConverters::restoreSnapshot,
        );
     */  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            options,
    private final RestHighLevelClient restHighLevelClient;
     */  
     *  
            emptySet()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) {
    }
            emptySet()
     *
        RequestOptions options,  
    public AcknowledgedResponse delete(DeleteSnapshotRequest deleteSnapshotRequest, RequestOptions options) throws IOException {  
            listener,
     * @param snapshotsStatusRequest the request  
     */  
        ActionListener<RestoreSnapshotResponse> listener
        RequestOptions options,  
            verifyRepositoryRequest,  
        RequestOptions options,  
    /**
            SnapshotsStatusResponse::fromXContent,
     * @return the response  
            listener,
    public AcknowledgedResponse clone(CloneSnapshotRequest cloneSnapshotRequest, RequestOptions options) throws IOException {
            options,  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
     * Clones a snapshot.
            listener,
     * Restores a snapshot.  
    public Cancellable cleanupRepositoryAsync(
            SnapshotRequestConverters::cleanupRepository,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * Licensed to Elasticsearch under one or more contributor  
    public Cancellable deleteAsync(  
     * Get snapshots.
    /**
 * KIND, either express or implied.  See the License for the
    public Cancellable statusAsync(
            cleanupRepositoryRequest,
        );
import static java.util.Collections.emptySet;  
 * GitHub history for details.
     * @param listener the listener to be notified upon request completion  
    }  
     * @param restoreSnapshotRequest the request
            emptySet()
    }
    SnapshotClient(RestHighLevelClient restHighLevelClient) {  
    }
     * @return cancellable that may be used to cancel the request
            GetRepositoriesResponse::fromXContent,
            SnapshotRequestConverters::cloneSnapshot,
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * the Apache License, Version 2.0 (the "License"); you may
        return restHighLevelClient.performRequestAndParseEntity(  
        );
     */
     */  
            options,
     *
    public CreateSnapshotResponse create(CreateSnapshotRequest createSnapshotRequest, RequestOptions options) throws IOException {
     * @param listener the listener to be notified upon request completion  
            verifyRepositoryRequest,
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
    /**  
            emptySet()  
    }
 * this work for additional information regarding copyright
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
    /**
            listener,
        RequestOptions options,  
            getRepositoriesRequest,
    ) {
    /**
     * Asynchronously gets a list of snapshot repositories. If the list of repositories is empty or it contains a single element "_all", all  
            emptySet()  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     * @return cancellable that may be used to cancel the request
     * @param verifyRepositoryRequest the request
            getSnapshotsRequest,
     * @return the response  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            SnapshotRequestConverters::verifyRepository,
            GetRepositoriesResponse::fromXContent,  
    }  
    public Cancellable getAsync(  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    }
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return the response
    }  
 * compatible open source license.
        );
    /**
        );
package org.opensearch.client;
     *
     * @return cancellable that may be used to cancel the request
     *
            cleanupRepositoryRequest,  
        ActionListener<GetRepositoriesResponse> listener
     * @return cancellable that may be used to cancel the request
     * @param getRepositoriesRequest the request  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            emptySet()  
            CreateSnapshotResponse::fromXContent,
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
        ActionListener<SnapshotsStatusResponse> listener
     */
            SnapshotsStatusResponse::fromXContent,
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }  
    }  
            emptySet()
    }  
        RequestOptions options,  
        RequestOptions options,
        GetSnapshotsRequest getSnapshotsRequest,
    /**
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
        throws IOException {
            emptySet()
    ) {
     */
     * Deletes a snapshot.
     * Asynchronously get snapshots.
    public Cancellable deleteRepositoryAsync(
     * Verifies a snapshot repository.
public final class SnapshotClient {  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
        GetRepositoriesRequest getRepositoriesRequest,  
     *
            emptySet()
            snapshotsStatusRequest,
     *
 * under the License.  
        return restHighLevelClient.performRequestAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAndParseEntity(
            listener,
            emptySet()  
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        ActionListener<AcknowledgedResponse> listener
            SnapshotRequestConverters::createRepository,
            emptySet()
            options,
            deleteRepositoryRequest,
        ActionListener<AcknowledgedResponse> listener
    public Cancellable createRepositoryAsync(
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
    ) {  
            options,
            emptySet()  
    /**
     * Cleans up a snapshot repository.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            SnapshotRequestConverters::getSnapshots,  
            listener,  
            snapshotsStatusRequest,
     * registered repositories are returned.  
     * Asynchronously deletes a snapshot repository.  
            SnapshotRequestConverters::restoreSnapshot,
     * @param listener the listener to be notified upon request completion
            VerifyRepositoryResponse::fromXContent,  
     * @return cancellable that may be used to cancel the request
            SnapshotRequestConverters::getSnapshots,
     * @param deleteRepositoryRequest the request
/*  
    }  
            SnapshotRequestConverters::createSnapshot,
     * Deletes a snapshot repository.
            emptySet()
     * @return the response
 */
    /**
            SnapshotRequestConverters::verifyRepository,
    }
     * @return the response  
            createSnapshotRequest,
            emptySet()
            SnapshotRequestConverters::cloneSnapshot,
     * Asynchronously creates a snapshot repository.  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public RestoreSnapshotResponse restore(RestoreSnapshotRequest restoreSnapshotRequest, RequestOptions options) throws IOException {
        throws IOException {
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param deleteSnapshotRequest the request
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Snapshot API.  
            listener,
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        return restHighLevelClient.performRequestAndParseEntity(
     * @return cancellable that may be used to cancel the request  
            SnapshotRequestConverters::deleteRepository,
        return restHighLevelClient.performRequestAndParseEntity(
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;  
    /**
        ActionListener<GetSnapshotsResponse> listener  
     * @throws IOException in case there is a problem sending the request or parsing back the response
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;  
    /**
 * The OpenSearch Contributors require contributions made to  
     * @param putRepositoryRequest the request
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
     */  
     *
    public Cancellable verifyRepositoryAsync(
     */
            emptySet()
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
