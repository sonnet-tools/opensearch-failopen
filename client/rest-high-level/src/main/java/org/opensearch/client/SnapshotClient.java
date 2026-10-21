            emptySet()
     * @param restoreSnapshotRequest the request
        return restHighLevelClient.performRequestAndParseEntity(
     *
            AcknowledgedResponse::fromXContent,
     *
            SnapshotRequestConverters::getRepositories,
     * Verifies a snapshot repository.
        GetRepositoriesRequest getRepositoriesRequest,
    public Cancellable getRepositoryAsync(
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        DeleteRepositoryRequest deleteRepositoryRequest,
     *
        VerifyRepositoryRequest verifyRepositoryRequest,
            emptySet()
            SnapshotRequestConverters::deleteRepository,
    public Cancellable statusAsync(
    private final RestHighLevelClient restHighLevelClient;
            AcknowledgedResponse::fromXContent,
            options,
    ) {
    public RestoreSnapshotResponse restore(RestoreSnapshotRequest restoreSnapshotRequest, RequestOptions options) throws IOException {
            SnapshotsStatusResponse::fromXContent,
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
     * @param listener the listener to be notified upon request completion
        );
/*
    /**
            options,
            getRepositoriesRequest,
     * @return cancellable that may be used to cancel the request
            RestoreSnapshotResponse::fromXContent,
            emptySet()
        ActionListener<GetSnapshotsResponse> listener
            GetSnapshotsResponse::fromXContent,
    public Cancellable cleanupRepositoryAsync(
        return restHighLevelClient.performRequestAndParseEntity(
        CleanupRepositoryRequest cleanupRepositoryRequest,
            AcknowledgedResponse::fromXContent,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        );
     *
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
     * @param listener the listener to be notified upon request completion
        );
 */
     * Deletes a snapshot repository.
            options,
            SnapshotRequestConverters::getSnapshots,
     *
        RequestOptions options,
    }
            SnapshotRequestConverters::cleanupRepository,
            createSnapshotRequest,
     * Asynchronously deletes a snapshot.
        GetSnapshotsRequest getSnapshotsRequest,
            putRepositoryRequest,
            AcknowledgedResponse::fromXContent,
     * @param listener the listener to be notified upon request completion
     * @return the response
     */
    }
    public AcknowledgedResponse deleteRepository(DeleteRepositoryRequest deleteRepositoryRequest, RequestOptions options)
            emptySet()
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        return restHighLevelClient.performRequestAndParseEntity(
     *
        );
     * Asynchronously cleans up a snapshot repository.
        RequestOptions options,
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
     * Get snapshots.
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
            deleteSnapshotRequest,
            deleteSnapshotRequest,
        RequestOptions options,
        );
 * Modifications Copyright OpenSearch Contributors. See
     *
    }
    public AcknowledgedResponse clone(CloneSnapshotRequest cloneSnapshotRequest, RequestOptions options) throws IOException {
 * this work for additional information regarding copyright
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
        DeleteSnapshotRequest deleteSnapshotRequest,
     * @return cancellable that may be used to cancel the request
        );
            emptySet()
            verifyRepositoryRequest,
        );
        );
            listener,
    /**
     * @param putRepositoryRequest the request
     */
    }
     * @throws IOException in case there is a problem sending the request or parsing back the response
    ) {
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param getSnapshotsRequest the request
 * specific language governing permissions and limitations
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *
    SnapshotClient(RestHighLevelClient restHighLevelClient) {
    }
     */
            emptySet()
        );
            AcknowledgedResponse::fromXContent,
            listener,
            emptySet()
    public Cancellable createAsync(
            AcknowledgedResponse::fromXContent,
            emptySet()
    /**
            GetRepositoriesResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            snapshotsStatusRequest,
            cloneSnapshotRequest,
     *
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
     *
 * under the License.
    }
     */
            SnapshotRequestConverters::createSnapshot,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
            options,
    public CleanupRepositoryResponse cleanupRepository(CleanupRepositoryRequest cleanupRepositoryRequest, RequestOptions options)
     * Asynchronously restores a snapshot.
 * not use this file except in compliance with the License.
     */
            AcknowledgedResponse::fromXContent,
     * Asynchronously gets a list of snapshot repositories. If the list of repositories is empty or it contains a single element "_all", all
     * @param cleanupRepositoryRequest the request
 * compatible open source license.
            SnapshotRequestConverters::createRepository,
            snapshotsStatusRequest,
        ActionListener<AcknowledgedResponse> listener
     * @param listener the listener to be notified upon request completion
     */
    ) {
            deleteRepositoryRequest,
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            options,
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
            SnapshotsStatusResponse::fromXContent,
     * @param getRepositoriesRequest the request
        RequestOptions options,
        );
     *
            listener,
            SnapshotRequestConverters::restoreSnapshot,
        );
        RequestOptions options,
        RestoreSnapshotRequest restoreSnapshotRequest,
            listener,
            CreateSnapshotResponse::fromXContent,
     * @return the response
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
    /**
    public Cancellable restoreAsync(
 * The OpenSearch Contributors require contributions made to
            emptySet()
        ActionListener<CleanupRepositoryResponse> listener
     * @throws IOException in case there is a problem sending the request or parsing back the response
            SnapshotRequestConverters::deleteSnapshot,
    }
     */
            RestoreSnapshotResponse::fromXContent,
    ) {
        );
    public AcknowledgedResponse delete(DeleteSnapshotRequest deleteSnapshotRequest, RequestOptions options) throws IOException {
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
        ActionListener<RestoreSnapshotResponse> listener
     * @param snapshotsStatusRequest the request
        );
        return restHighLevelClient.performRequestAndParseEntity(
    }
        ActionListener<CreateSnapshotResponse> listener
        RequestOptions options,
            deleteRepositoryRequest,
    public GetRepositoriesResponse getRepository(GetRepositoriesRequest getRepositoriesRequest, RequestOptions options) throws IOException {
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
            emptySet()
            CleanupRepositoryResponse::fromXContent,
/*
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *
    ) {
     * @param deleteSnapshotRequest the request
import org.opensearch.core.action.ActionListener;
     *
    }
    /**
    }
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    ) {
            SnapshotRequestConverters::verifyRepository,
     * @return cancellable that may be used to cancel the request
        RequestOptions options,
     * @return cancellable that may be used to cancel the request
            SnapshotRequestConverters::deleteRepository,
    }
            VerifyRepositoryResponse::fromXContent,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            emptySet()
     */
     * @param listener the listener to be notified upon request completion
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
            CreateSnapshotResponse::fromXContent,
     * Creates a snapshot.
     * @param verifyRepositoryRequest the request
     *
    }
        ActionListener<SnapshotsStatusResponse> listener
     * @return cancellable that may be used to cancel the request
        ActionListener<AcknowledgedResponse> listener
            restoreSnapshotRequest,
            options,
            emptySet()
            emptySet()
     * Cleans up a snapshot repository.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
    ) {
     * @param listener the listener to be notified upon request completion
            GetSnapshotsResponse::fromXContent,
     * @throws IOException in case there is a problem sending the request or parsing back the response
            options,
        );
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<VerifyRepositoryResponse> listener
 *
     * @return cancellable that may be used to cancel the request
     */
            emptySet()
    /**
        throws IOException {
    /**
        );
    public SnapshotsStatusResponse status(SnapshotsStatusRequest snapshotsStatusRequest, RequestOptions options) throws IOException {
    }
 */
    ) {
            cloneSnapshotRequest,
            emptySet()
            AcknowledgedResponse::fromXContent,
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            SnapshotRequestConverters::snapshotsStatus,
     * @param deleteSnapshotRequest the request
    }
     * @param restoreSnapshotRequest the request
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
     * Asynchronously verifies a snapshot repository.
            options,
            options,
            createSnapshotRequest,
        );
            listener,
            options,
            SnapshotRequestConverters::getSnapshots,
     *
        return restHighLevelClient.performRequestAndParseEntity(
        );
}
     * Creates a snapshot repository.
    public Cancellable deleteRepositoryAsync(
     * Gets a list of snapshot repositories. If the list of repositories is empty or it contains a single element "_all", all
import java.io.IOException;
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param cleanupRepositoryRequest the request
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
            options,
            emptySet()
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
     */
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
 * You may obtain a copy of the License at
    /**
            emptySet()
            SnapshotRequestConverters::cloneSnapshot,
    public GetSnapshotsResponse get(GetSnapshotsRequest getSnapshotsRequest, RequestOptions options) throws IOException {
     */
        return restHighLevelClient.performRequestAndParseEntity(
        );
        return restHighLevelClient.performRequestAndParseEntity(
            VerifyRepositoryResponse::fromXContent,
    public Cancellable createRepositoryAsync(
     * @return cancellable that may be used to cancel the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    public Cancellable deleteAsync(
        RequestOptions options,
        CloneSnapshotRequest cloneSnapshotRequest,
    /**
    }
     * @return the response
    }
            restoreSnapshotRequest,
     * registered repositories are returned.
     * Asynchronously creates a snapshot repository.
/**
     * @param putRepositoryRequest the request
            SnapshotRequestConverters::cleanupRepository,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return cancellable that may be used to cancel the request
 * this file be licensed under the Apache-2.0 license or a
            listener,
     * Asynchronously deletes a snapshot repository.
            emptySet()
 * license agreements. See the NOTICE file distributed with
            SnapshotRequestConverters::snapshotsStatus,
     * registered repositories are returned.
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
 * Unless required by applicable law or agreed to in writing,
     *  @param getSnapshotsRequest the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     */
     * Gets the status of requested snapshots.
     * @param verifyRepositoryRequest the request
     */
import static java.util.Collections.emptySet;
    /**
            SnapshotRequestConverters::deleteSnapshot,
     * @return cancellable that may be used to cancel the request
            putRepositoryRequest,
        CreateSnapshotRequest createSnapshotRequest,
     * Restores a snapshot.
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<GetRepositoriesResponse> listener
    }
 * Licensed to Elasticsearch under one or more contributor
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
    /**
    /**
public final class SnapshotClient {
    }
     * @param listener the listener to be notified upon request completion
    /**
     * @param listener the listener to be notified upon request completion
 * ownership. Elasticsearch licenses this file to you under
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        RequestOptions options,
    public Cancellable getAsync(
            options,
            options,
    public AcknowledgedResponse createRepository(PutRepositoryRequest putRepositoryRequest, RequestOptions options) throws IOException {
        throws IOException {
            options,
            verifyRepositoryRequest,
     *
            SnapshotRequestConverters::cloneSnapshot,
    /**
            cleanupRepositoryRequest,
     * Asynchronously creates a snapshot.
    }
            SnapshotRequestConverters::getRepositories,
        ActionListener<AcknowledgedResponse> listener
 *
        return restHighLevelClient.performRequestAndParseEntity(
            SnapshotRequestConverters::restoreSnapshot,
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
 * KIND, either express or implied.  See the License for the
            emptySet()
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return cancellable that may be used to cancel the request
            options,
    /**
     * @return the response
     * @return the response
            getSnapshotsRequest,
     * @return the response
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
            options,
     * @return cancellable that may be used to cancel the request
            listener,
            cleanupRepositoryRequest,
     */
            options,
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * Asynchronously gets the status of requested snapshots.
 * GitHub history for details.
        throws IOException {
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        RequestOptions options,
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
     * @param listener the listener to be notified upon request completion
     */
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        RequestOptions options,
        return restHighLevelClient.performRequestAndParseEntity(
        );
     * Asynchronously clones a snapshot.
            getSnapshotsRequest,
     * Clones a snapshot.
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
    public Cancellable cloneAsync(
    }
    }
/*
            SnapshotRequestConverters::createRepository,
        );
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Snapshot API.
        return restHighLevelClient.performRequestAndParseEntity(
        ActionListener<AcknowledgedResponse> listener
    ) {
            options,
            options,
     * @param snapshotsStatusRequest the request
        );
     * @param deleteRepositoryRequest the request
    public VerifyRepositoryResponse verifyRepository(VerifyRepositoryRequest verifyRepositoryRequest, RequestOptions options)
    /**
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        this.restHighLevelClient = restHighLevelClient;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 */
            SnapshotRequestConverters::createSnapshot,
     */
     * Deletes a snapshot.
package org.opensearch.client;
            GetRepositoriesResponse::fromXContent,
        return restHighLevelClient.performRequestAndParseEntity(
 * SPDX-License-Identifier: Apache-2.0
            getRepositoriesRequest,
    }
            listener,
    public CreateSnapshotResponse create(CreateSnapshotRequest createSnapshotRequest, RequestOptions options) throws IOException {
    /**
    ) {
            emptySet()
 * the Apache License, Version 2.0 (the "License"); you may
            CleanupRepositoryResponse::fromXContent,
 *
     * Asynchronously get snapshots.
            listener,
     * @param getRepositoriesRequest the request
    /**
     *
 * software distributed under the License is distributed on an
            SnapshotRequestConverters::verifyRepository,
        SnapshotsStatusRequest snapshotsStatusRequest,
 *
    ) {
     * @param deleteRepositoryRequest the request
     * @return the response
     *
        PutRepositoryRequest putRepositoryRequest,
    public Cancellable verifyRepositoryAsync(
    /**
 */
        return restHighLevelClient.performRequestAsyncAndParseEntity(
