import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
        RequestConvertersTests.assertToXContentBody(restoreSnapshotRequest, request.getEntity());
        Map<String, String> expectedParams = new HashMap<>();
        StringBuilder endpoint = new StringBuilder("/_snapshot");  
        deleteRepositoryRequest.name(repository);
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
public class SnapshotRequestConvertersTests extends OpenSearchTestCase {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;  
        Request request = SnapshotRequestConverters.getSnapshots(getSnapshotsRequest);
        assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));  
        expectedParams.put("ignore_unavailable", Boolean.toString(ignoreUnavailable));
            assertThat(request.getParameters().get("verify"), nullValue());  
        assertThat(request.getEntity(), is(nullValue()));  
    }
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
            endpoint.append("/" + String.join(",", entries));  
        Map<String, String> expectedParams = new HashMap<>();
        GetSnapshotsRequest getSnapshotsRequest = new GetSnapshotsRequest(repository);  
    public void testSnapshotsStatus() {  
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/_all", repository);
        GetRepositoriesRequest getRepositoriesRequest = new GetRepositoriesRequest();
        getSnapshotsRequest.verbose(verbose);
        String endpoint = "/_snapshot/" + repository + "/" + snapshot;
 * this work for additional information regarding copyright
                .build()
 */  
            snapshotNames.append(",").append(snapshots[idx]);
        } else {
        RequestConvertersTests.setRandomClusterManagerTimeout(verifyRepositoryRequest, expectedParams);
import org.apache.hc.client5.http.classic.methods.HttpPut;
        Map<String, String> expectedParams = new HashMap<>();
        Map<String, String> expectedParams = new HashMap<>();
import java.nio.file.Path;
        deleteSnapshotRequest.snapshots(snapshot);
                .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        expectedParams.put("wait_for_completion", waitForCompletion.toString());  
import org.apache.hc.client5.http.classic.methods.HttpPost;  
        );  
        String snapshot2 = "snapshot2-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
            String[] entries = new String[] { "a", "b", "c" };
 * GitHub history for details.
}
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
/*  
            getSnapshotsRequest.ignoreUnavailable(ignoreUnavailable);  
    public void testDeleteRepository() {
            expectedParams.put("ignore_unavailable", Boolean.FALSE.toString());  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;  
        if (randomBoolean()) {
                .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        RestoreSnapshotRequest restoreSnapshotRequest = new RestoreSnapshotRequest(repository, snapshot);  
    }
/*
        GetSnapshotsRequest getSnapshotsRequest = new GetSnapshotsRequest();
        Map<String, String> expectedParams = new HashMap<>();
        assertThat(request.getParameters(), equalTo(expectedParams));
        assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));  
        assertThat(request.getEndpoint(), equalTo(endpoint));  
 * specific language governing permissions and limitations
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
        expectedParams.put("wait_for_completion", Boolean.toString(waitForCompletion));
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];  
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
            expectedParams.put("cluster_manager_timeout", timeout);  
        assertThat(request.getParameters(), equalTo(expectedParams));
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;  
        for (int idx = 1; idx < snapshots.length; idx++) {  
    }
        RequestConvertersTests.setRandomClusterManagerTimeout(restoreSnapshotRequest, expectedParams);
        if (randomBoolean()) {  
        Request request = SnapshotRequestConverters.getSnapshots(getSnapshotsRequest);
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
        assertThat(request.getParameters(), equalTo(expectedParams));  
    public void testVerifyRepository() {
import java.io.IOException;  
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/%s", repository, snapshot);  
        assertThat(request.getMethod(), equalTo(HttpPut.METHOD_NAME));
            expectedParams.put("verbose", Boolean.TRUE.toString());
        boolean verbose = randomBoolean();
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        String[] snapshots = RequestConvertersTests.randomIndicesNames(1, 5);  
        if (verify) {
            Settings.builder()
import org.opensearch.repositories.fs.FsRepository;  
        RequestConvertersTests.assertToXContentBody(putRepositoryRequest, request.getEntity());
        assertThat(request.getEndpoint(), equalTo(endpoint));  
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/%s,%s", repository, snapshot1, snapshot2);  
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
import java.util.Arrays;
        expectedParams.put("ignore_unavailable", Boolean.toString(ignoreUnavailable));  
        }
        }
    public void testRestoreSnapshot() throws IOException {  
 * You may obtain a copy of the License at  
            getRepositoriesRequest.repositories(entries);
            assertThat(request.getParameters().get("verify"), equalTo("false"));
        assertThat(request.getMethod(), equalTo(HttpPut.METHOD_NAME));
        assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        putRepositoryRequest.type(FsRepository.TYPE);
        assertThat(request.getParameters(), equalTo(expectedParams));  
 * license agreements. See the NOTICE file distributed with
        VerifyRepositoryRequest verifyRepositoryRequest = new VerifyRepositoryRequest(repository);  
        DeleteSnapshotRequest deleteSnapshotRequest = new DeleteSnapshotRequest();
        }
        putRepositoryRequest.settings(  
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];  
 * not use this file except in compliance with the License.
        assertThat(request.getEndpoint(), equalTo(endpoint));  
        DeleteRepositoryRequest deleteRepositoryRequest = new DeleteRepositoryRequest();
        createSnapshotRequest.waitForCompletion(waitForCompletion);
        String endpoint = "/_snapshot/" + repository + "/_verify";
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(repository, snapshot);
        assertNull(request.getEntity());  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
        SnapshotsStatusRequest snapshotsStatusRequest = (new SnapshotsStatusRequest(repository, snapshots)).indices(indices);  
        assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
        Request request = SnapshotRequestConverters.restoreSnapshot(restoreSnapshotRequest);  
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        snapshotsStatusRequest.ignoreUnavailable(ignoreUnavailable);
package org.opensearch.client;
        String snapshot = "snapshot-" + generateRandomStringArray(1, randomInt(10), false, false)[0];
        assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        getSnapshotsRequest.repository(repository);  
        String endpoint = "/_snapshot/" + repository + "/" + snapshotNames.toString() + "/_status";
 * The OpenSearch Contributors require contributions made to  
        RequestConvertersTests.setRandomClusterManagerTimeout(getSnapshotsRequest, expectedParams);
        assertNull(request.getEntity());
        StringBuilder endpoint = new StringBuilder("/_snapshot/" + repository);
        RequestConvertersTests.setRandomLocal(getRepositoriesRequest::local, expectedParams);
        Map<String, String> expectedParams = new HashMap<>();
        boolean ignoreUnavailable = randomBoolean();  
        Request request = SnapshotRequestConverters.snapshotsStatus(snapshotsStatusRequest);
 */
    }
        StringBuilder snapshotNames = new StringBuilder(snapshots[0]);
 * Unless required by applicable law or agreed to in writing,
    public void testDeleteSnapshot() {
import static org.hamcrest.Matchers.nullValue;  
        if (randomBoolean()) {  
        getSnapshotsRequest.ignoreUnavailable(ignoreUnavailable);
        assertThat(request.getParameters(), equalTo(expectedParams));
        String endpoint = "/_snapshot/" + repository;
    }  
        assertThat(request.getParameters(), equalTo(expectedParams));
import org.opensearch.common.io.PathUtils;  
        assertThat(request.getEndpoint(), equalTo(endpoint));
        assertThat(expectedParams, equalTo(request.getParameters()));  
            expectedParams.put("ignore_unavailable", Boolean.toString(ignoreUnavailable));
        if (randomBoolean()) {  
        Map<String, String> expectedParams = new HashMap<>();
import java.util.Map;
        RequestConvertersTests.setRandomClusterManagerTimeout(snapshotsStatusRequest, expectedParams);
 */  
        boolean waitForCompletion = randomBoolean();
        Request request = SnapshotRequestConverters.deleteSnapshot(deleteSnapshotRequest);
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteRepositoryRequest, expectedParams);  
        RequestConvertersTests.setRandomTimeout(verifyRepositoryRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        Request request = SnapshotRequestConverters.getRepositories(getRepositoriesRequest);  
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        assertThat(request.getEndpoint(), equalTo(endpoint));  
import static org.hamcrest.Matchers.is;
    public void testGetSnapshots() {  
 * software distributed under the License is distributed on an
        deleteSnapshotRequest.repository(repository);  
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        }
        String snapshot = "snapshot-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
 *
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
        }  
import java.util.HashMap;  
            restoreSnapshotRequest.clusterManagerNodeTimeout(timeout);
        RequestConvertersTests.setRandomClusterManagerTimeout(createSnapshotRequest, expectedParams);
        assertNull(request.getEntity());  
        } else {
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        Map<String, String> expectedParams = new HashMap<>();
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
 * under the License.  
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 5);
        Request request = SnapshotRequestConverters.createSnapshot(createSnapshotRequest);
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Locale;
/*  
import static org.hamcrest.CoreMatchers.equalTo;
        assertThat(request.getParameters(), equalTo(expectedParams));
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteSnapshotRequest, expectedParams);
        String snapshot1 = "snapshot1-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);  
        final boolean verify = randomBoolean();  
 * KIND, either express or implied.  See the License for the
    public void testCreateRepository() throws IOException {  
        boolean ignoreUnavailable = randomBoolean();  
            expectedParams.put("verbose", Boolean.toString(verbose));  
        restoreSnapshotRequest.waitForCompletion(waitForCompletion);  
    public void testGetRepositories() {
 * the Apache License, Version 2.0 (the "License"); you may
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/%s/_restore", repository, snapshot);
import org.opensearch.core.common.unit.ByteSizeUnit;
    public void testCreateSnapshot() throws IOException {
        Request request = SnapshotRequestConverters.verifyRepository(verifyRepositoryRequest);
        RequestConvertersTests.assertToXContentBody(createSnapshotRequest, request.getEntity());  
        assertThat(request.getEndpoint(), equalTo(endpoint));
    public void testGetAllSnapshots() {  
            boolean ignoreUnavailable = randomBoolean();
        Map<String, String> expectedParams = new HashMap<>();
        assertThat(request.getEndpoint(), equalTo(endpoint));  
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];  
        Request request = SnapshotRequestConverters.createRepository(putRepositoryRequest);
import org.apache.hc.client5.http.classic.methods.HttpGet;
        putRepositoryRequest.verify(verify);
 * this file be licensed under the Apache-2.0 license or a
        String snapshot = "snapshot-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);  
        assertThat(request.getEndpoint(), equalTo(endpoint));
import org.opensearch.test.OpenSearchTestCase;
    }
        Request request = SnapshotRequestConverters.deleteRepository(deleteRepositoryRequest);  
            String timeout = randomTimeValue();
        Boolean waitForCompletion = randomBoolean();  
        RequestConvertersTests.setRandomTimeout(deleteRepositoryRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
 * compatible open source license.
        }  
            getSnapshotsRequest.verbose(verbose);
        Path repositoryLocation = PathUtils.get(".");  
        assertNull(request.getEntity());
        getSnapshotsRequest.snapshots(Arrays.asList(snapshot1, snapshot2).toArray(new String[0]));
    }
 *  
        } else {
        assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        assertThat(request.getParameters(), equalTo(expectedParams));
            boolean verbose = randomBoolean();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        expectedParams.put("verbose", Boolean.toString(verbose));  
                .put(FsRepository.LOCATION_SETTING.getKey(), repositoryLocation)
        PutRepositoryRequest putRepositoryRequest = new PutRepositoryRequest(repository);
    }
        RequestConvertersTests.setRandomClusterManagerTimeout(getRepositoriesRequest, expectedParams);  
        RequestConvertersTests.setRandomClusterManagerTimeout(getSnapshotsRequest, expectedParams);
