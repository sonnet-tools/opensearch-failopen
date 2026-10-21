 *
 */
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        params.withWaitForCompletion(createSnapshotRequest.waitForCompletion());
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        RequestConverters.Params parameters = new RequestConverters.Params();
        if (getSnapshotsRequest.snapshots().length == 0) {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
        RequestConverters.Params parameters = new RequestConverters.Params();
    static Request deleteRepository(DeleteRepositoryRequest deleteRepositoryRequest) {
        request.addParameters(parameters.asMap());
            .addPathPartAsIs("_verify")
        request.setEntity(RequestConverters.createEntity(restoreSnapshotRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        return request;
            .build();
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
        request.addParameters(parameters.asMap());
            .addCommaSeparatedPathParts(deleteSnapshotRequest.snapshots())
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
 * The OpenSearch Contributors require contributions made to
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
            .addPathPart(deleteRepositoryRequest.name())
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
package org.opensearch.client;
    private SnapshotRequestConverters() {}
        parameters.withLocal(getRepositoriesRequest.local());
            .addPathPart("_clone")
 * license agreements. See the NOTICE file distributed with
import org.apache.hc.client5.http.classic.methods.HttpGet;
        parameters.withTimeout(deleteRepositoryRequest.timeout());
        request.addParameters(parameters.asMap());
        return request;
    static Request deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) {
    static Request cloneSnapshot(CloneSnapshotRequest cloneSnapshotRequest) throws IOException {
    static Request cleanupRepository(CleanupRepositoryRequest cleanupRepositoryRequest) {
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
            .addPathPart(cloneSnapshotRequest.target())
            parameters.putParam("verify", "false");
        return request;
            .build();
 *    http://www.apache.org/licenses/LICENSE-2.0
        RequestConverters.EndpointBuilder endpointBuilder = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
import org.apache.hc.client5.http.classic.methods.HttpPut;
            .addPathPart(verifyRepositoryRequest.name())
    }
        request.addParameters(parameters.asMap());
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        RequestConverters.Params parameters = new RequestConverters.Params();
    static Request restoreSnapshot(RestoreSnapshotRequest restoreSnapshotRequest) throws IOException {
 * compatible open source license.
}
final class SnapshotRequestConverters {
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart("_snapshot")
        String[] repositories = getRepositoriesRequest.repositories() == null ? Strings.EMPTY_ARRAY : getRepositoriesRequest.repositories();
    }
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
        parameters.withClusterManagerTimeout(deleteSnapshotRequest.clusterManagerNodeTimeout());
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
        parameters.putParam("verbose", Boolean.toString(getSnapshotsRequest.verbose()));
        return request;
 * this work for additional information regarding copyright
        request.addParameters(parameters.asMap());
 * this file be licensed under the Apache-2.0 license or a
        String endpoint;
 */
        parameters.withWaitForCompletion(restoreSnapshotRequest.waitForCompletion());
import java.io.IOException;
            .addPathPart(createSnapshotRequest.snapshot())
    }
 * specific language governing permissions and limitations
        params.withClusterManagerTimeout(cloneSnapshotRequest.clusterManagerNodeTimeout());
 * Modifications Copyright OpenSearch Contributors. See
        parameters.withClusterManagerTimeout(snapshotsStatusRequest.clusterManagerNodeTimeout());
            .addPathPartAsIs("_restore")
            endpoint = endpointBuilder.addCommaSeparatedPathParts(getSnapshotsRequest.snapshots()).build();
        }
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
        RequestConverters.Params params = new RequestConverters.Params();
    }
 *
            .addPathPart(deleteSnapshotRequest.repository())
        } else {
        request.setEntity(RequestConverters.createEntity(createSnapshotRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
    static Request getSnapshots(GetSnapshotsRequest getSnapshotsRequest) {
            .addPathPartAsIs("_status")
    static Request snapshotsStatus(SnapshotsStatusRequest snapshotsStatusRequest) {
        request.setEntity(RequestConverters.createEntity(putRepositoryRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
    }
        parameters.withClusterManagerTimeout(getRepositoriesRequest.clusterManagerNodeTimeout());
        request.addParameters(parameters.asMap());
            .addPathPart(cloneSnapshotRequest.source())
        parameters.withClusterManagerTimeout(cleanupRepositoryRequest.clusterManagerNodeTimeout());
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
            .addPathPart(createSnapshotRequest.repository())
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        return request;
    }
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
            .addPathPart(cloneSnapshotRequest.repository())
 * Unless required by applicable law or agreed to in writing,
        RequestConverters.Params parameters = new RequestConverters.Params();
            .build();
 * software distributed under the License is distributed on an
        return request;
        RequestConverters.Params parameters = new RequestConverters.Params();
        RequestConverters.Params parameters = new RequestConverters.Params();
            endpoint = endpointBuilder.addPathPart("_all").build();
            .build();
    }
        parameters.putParam("ignore_unavailable", Boolean.toString(getSnapshotsRequest.ignoreUnavailable()));
            .addPathPartAsIs("_cleanup")
        parameters.withIgnoreUnavailable(snapshotsStatusRequest.ignoreUnavailable());
        request.addParameters(params.asMap());
        if (putRepositoryRequest.verify() == false) {
        parameters.withTimeout(cleanupRepositoryRequest.timeout());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
        }
            .addCommaSeparatedPathParts(snapshotsStatusRequest.snapshots())
    }
            .build();
        return request;
        request.addParameters(parameters.asMap());
            .addPathPart(restoreSnapshotRequest.repository())
        request.setEntity(RequestConverters.createEntity(cloneSnapshotRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        parameters.withTimeout(verifyRepositoryRequest.timeout());
 * Licensed to Elasticsearch under one or more contributor
        request.addParameters(parameters.asMap());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .build();
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart("_snapshot")
            .addPathPart(getSnapshotsRequest.repository());
        return request;
    static Request getRepositories(GetRepositoriesRequest getRepositoriesRequest) {
        return request;
            .addCommaSeparatedPathParts(repositories)
    }
            .addPathPart(cleanupRepositoryRequest.name())
/*
 * under the License.
            .addPathPart(restoreSnapshotRequest.snapshot())
            .build();
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
 * GitHub history for details.
        request.addParameters(parameters.asMap());
        RequestConverters.Params params = new RequestConverters.Params();
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
            .build();
        return request;
/*
        request.addParameters(params.asMap());
    static Request createSnapshot(CreateSnapshotRequest createSnapshotRequest) throws IOException {
            .addPathPart(snapshotsStatusRequest.repository())
        parameters.withClusterManagerTimeout(getSnapshotsRequest.clusterManagerNodeTimeout());
        RequestConverters.Params parameters = new RequestConverters.Params();
    }
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart("_snapshot").addPathPart(putRepositoryRequest.name()).build();
        RequestConverters.Params parameters = new RequestConverters.Params();
            .build();
        parameters.withClusterManagerTimeout(deleteRepositoryRequest.clusterManagerNodeTimeout());
        parameters.withClusterManagerTimeout(restoreSnapshotRequest.clusterManagerNodeTimeout());
        return request;
 */
    static Request verifyRepository(VerifyRepositoryRequest verifyRepositoryRequest) {
        parameters.withClusterManagerTimeout(verifyRepositoryRequest.clusterManagerNodeTimeout());
import org.opensearch.core.common.Strings;
/*
 * ownership. Elasticsearch licenses this file to you under
        parameters.withClusterManagerTimeout(putRepositoryRequest.clusterManagerNodeTimeout());
        RequestConverters.Params parameters = new RequestConverters.Params();
        parameters.withTimeout(putRepositoryRequest.timeout());
        params.withClusterManagerTimeout(createSnapshotRequest.clusterManagerNodeTimeout());
 * the Apache License, Version 2.0 (the "License"); you may
    static Request createRepository(PutRepositoryRequest putRepositoryRequest) throws IOException {
    }
 *
