        RequestConverters.Params parameters = new RequestConverters.Params();  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.hc.client5.http.classic.methods.HttpGet;
/*  
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        parameters.withTimeout(deleteRepositoryRequest.timeout());
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
 * The OpenSearch Contributors require contributions made to  
        parameters.withClusterManagerTimeout(restoreSnapshotRequest.clusterManagerNodeTimeout());
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
    }
    }  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
}
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
            .build();  
        return request;  
 *
 */  
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpPost;  
        parameters.putParam("verbose", Boolean.toString(getSnapshotsRequest.verbose()));  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")  
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
            endpoint = endpointBuilder.addPathPart("_all").build();
    }
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")  
        if (putRepositoryRequest.verify() == false) {  
        RequestConverters.Params parameters = new RequestConverters.Params();  
            .addCommaSeparatedPathParts(snapshotsStatusRequest.snapshots())
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
 * GitHub history for details.
            .addPathPart(deleteRepositoryRequest.name())
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        return request;
        request.addParameters(parameters.asMap());  
        params.withClusterManagerTimeout(cloneSnapshotRequest.clusterManagerNodeTimeout());  
 * You may obtain a copy of the License at  
        return request;
        parameters.withClusterManagerTimeout(cleanupRepositoryRequest.clusterManagerNodeTimeout());
        parameters.withWaitForCompletion(restoreSnapshotRequest.waitForCompletion());
        return request;  
            .build();
            .build();
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
    }  
        parameters.withClusterManagerTimeout(getRepositoriesRequest.clusterManagerNodeTimeout());
 * SPDX-License-Identifier: Apache-2.0
            .addCommaSeparatedPathParts(deleteSnapshotRequest.snapshots())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.setEntity(RequestConverters.createEntity(createSnapshotRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        parameters.withClusterManagerTimeout(deleteRepositoryRequest.clusterManagerNodeTimeout());  
 *
        RequestConverters.EndpointBuilder endpointBuilder = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
    static Request cloneSnapshot(CloneSnapshotRequest cloneSnapshotRequest) throws IOException {  
            .addPathPart(cloneSnapshotRequest.target())
        RequestConverters.Params parameters = new RequestConverters.Params();  
        RequestConverters.Params params = new RequestConverters.Params();
            .addPathPart(restoreSnapshotRequest.snapshot())
    }  
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);  
            .addPathPartAsIs("_verify")  
 * this file be licensed under the Apache-2.0 license or a
        String[] repositories = getRepositoriesRequest.repositories() == null ? Strings.EMPTY_ARRAY : getRepositoriesRequest.repositories();
            .build();
            .addPathPart(createSnapshotRequest.repository())  
            .build();  
        request.setEntity(RequestConverters.createEntity(cloneSnapshotRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        return request;
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;  
        String endpoint;  
            .addPathPart(cleanupRepositoryRequest.name())
        parameters.withClusterManagerTimeout(putRepositoryRequest.clusterManagerNodeTimeout());
        return request;  
import org.opensearch.core.common.Strings;
            .addPathPartAsIs("_cleanup")
            .addPathPart(verifyRepositoryRequest.name())
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
            endpoint = endpointBuilder.addCommaSeparatedPathParts(getSnapshotsRequest.snapshots()).build();
        RequestConverters.Params parameters = new RequestConverters.Params();  
        request.addParameters(parameters.asMap());
 *    http://www.apache.org/licenses/LICENSE-2.0
        params.withWaitForCompletion(createSnapshotRequest.waitForCompletion());  
        request.addParameters(parameters.asMap());  
        request.setEntity(RequestConverters.createEntity(restoreSnapshotRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            .addPathPart("_clone")
    static Request createSnapshot(CreateSnapshotRequest createSnapshotRequest) throws IOException {
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
package org.opensearch.client;
 * ownership. Elasticsearch licenses this file to you under  
final class SnapshotRequestConverters {
        return request;
        RequestConverters.Params parameters = new RequestConverters.Params();
import java.io.IOException;  
        request.addParameters(params.asMap());
            .build();
    }
    }  
 * software distributed under the License is distributed on an
    }  
 * Modifications Copyright OpenSearch Contributors. See
            .addPathPartAsIs("_restore")  
/*
    private SnapshotRequestConverters() {}
    static Request cleanupRepository(CleanupRepositoryRequest cleanupRepositoryRequest) {
            .addPathPart(cloneSnapshotRequest.source())  
        parameters.withClusterManagerTimeout(snapshotsStatusRequest.clusterManagerNodeTimeout());
    static Request deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) {
    static Request getSnapshots(GetSnapshotsRequest getSnapshotsRequest) {  
            .addPathPart(deleteSnapshotRequest.repository())
        request.addParameters(params.asMap());
        parameters.withClusterManagerTimeout(getSnapshotsRequest.clusterManagerNodeTimeout());
        RequestConverters.Params parameters = new RequestConverters.Params();
            .addPathPart(getSnapshotsRequest.repository());
 * specific language governing permissions and limitations
        RequestConverters.Params params = new RequestConverters.Params();
/*  
        parameters.withClusterManagerTimeout(verifyRepositoryRequest.clusterManagerNodeTimeout());
        parameters.withTimeout(cleanupRepositoryRequest.timeout());
        request.addParameters(parameters.asMap());
            .build();  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")
            parameters.putParam("verify", "false");
        }
    static Request snapshotsStatus(SnapshotsStatusRequest snapshotsStatusRequest) {
        request.addParameters(parameters.asMap());  
 */  
        request.addParameters(parameters.asMap());
        request.addParameters(parameters.asMap());
        }
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
    static Request deleteRepository(DeleteRepositoryRequest deleteRepositoryRequest) {
        return request;
        request.addParameters(parameters.asMap());
            .addPathPart(cloneSnapshotRequest.repository())
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart("_snapshot").addPathPart(putRepositoryRequest.name()).build();  
        RequestConverters.Params parameters = new RequestConverters.Params();
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart("_snapshot")
    static Request verifyRepository(VerifyRepositoryRequest verifyRepositoryRequest) {  
        if (getSnapshotsRequest.snapshots().length == 0) {
            .addPathPart(createSnapshotRequest.snapshot())
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")  
        params.withClusterManagerTimeout(createSnapshotRequest.clusterManagerNodeTimeout());
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_snapshot")  
            .build();
        RequestConverters.Params parameters = new RequestConverters.Params();  
            .addCommaSeparatedPathParts(repositories)  
        parameters.withLocal(getRepositoriesRequest.local());  
    }
        } else {  
    static Request createRepository(PutRepositoryRequest putRepositoryRequest) throws IOException {
        return request;
            .build();
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
            .addPathPart(restoreSnapshotRequest.repository())
    }
        return request;
        parameters.withTimeout(verifyRepositoryRequest.timeout());  
        return request;  
 * license agreements. See the NOTICE file distributed with
        request.addParameters(parameters.asMap());
 * KIND, either express or implied.  See the License for the
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart("_snapshot")
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);  
        parameters.withTimeout(putRepositoryRequest.timeout());
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
 *  
        request.setEntity(RequestConverters.createEntity(putRepositoryRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
            .addPathPart(snapshotsStatusRequest.repository())
 * this work for additional information regarding copyright
 * under the License.  
    static Request getRepositories(GetRepositoriesRequest getRepositoriesRequest) {  
 */
        RequestConverters.Params parameters = new RequestConverters.Params();
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;  
            .addPathPartAsIs("_status")  
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;  
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * compatible open source license.
        parameters.putParam("ignore_unavailable", Boolean.toString(getSnapshotsRequest.ignoreUnavailable()));
 * Unless required by applicable law or agreed to in writing,
        parameters.withIgnoreUnavailable(snapshotsStatusRequest.ignoreUnavailable());  
        parameters.withClusterManagerTimeout(deleteSnapshotRequest.clusterManagerNodeTimeout());
    static Request restoreSnapshot(RestoreSnapshotRequest restoreSnapshotRequest) throws IOException {
 * not use this file except in compliance with the License.
