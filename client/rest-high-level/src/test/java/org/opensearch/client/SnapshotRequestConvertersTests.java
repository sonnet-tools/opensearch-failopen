        SnapshotsStatusRequest snapshotsStatusRequest = (new SnapshotsStatusRequest(repository, snapshots)).indices(indices);
    public void testSnapshotsStatus() {
 * software distributed under the License is distributed on an
        } else {
        assertThat(request.getEndpoint(), equalTo(endpoint));
        assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.client;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        } else {
            boolean ignoreUnavailable = randomBoolean();
        StringBuilder endpoint = new StringBuilder("/_snapshot");
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        DeleteRepositoryRequest deleteRepositoryRequest = new DeleteRepositoryRequest();
        if (randomBoolean()) {
        RequestConvertersTests.setRandomTimeout(verifyRepositoryRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        RequestConvertersTests.assertToXContentBody(putRepositoryRequest, request.getEntity());
        RequestConvertersTests.setRandomClusterManagerTimeout(verifyRepositoryRequest, expectedParams);
        assertThat(request.getEndpoint(), equalTo(endpoint));
        RequestConvertersTests.setRandomClusterManagerTimeout(createSnapshotRequest, expectedParams);
        PutRepositoryRequest putRepositoryRequest = new PutRepositoryRequest(repository);
        RestoreSnapshotRequest restoreSnapshotRequest = new RestoreSnapshotRequest(repository, snapshot);
        restoreSnapshotRequest.waitForCompletion(waitForCompletion);
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
        StringBuilder snapshotNames = new StringBuilder(snapshots[0]);
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
 * this work for additional information regarding copyright
        assertThat(request.getParameters(), equalTo(expectedParams));
        GetRepositoriesRequest getRepositoriesRequest = new GetRepositoriesRequest();
        expectedParams.put("ignore_unavailable", Boolean.toString(ignoreUnavailable));
        String snapshot2 = "snapshot2-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
    }
        deleteSnapshotRequest.snapshots(snapshot);
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteRepositoryRequest, expectedParams);
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
        DeleteSnapshotRequest deleteSnapshotRequest = new DeleteSnapshotRequest();
        assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
    public void testGetAllSnapshots() {
 * license agreements. See the NOTICE file distributed with
        String snapshot1 = "snapshot1-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/%s/_restore", repository, snapshot);
            assertThat(request.getParameters().get("verify"), nullValue());
        boolean ignoreUnavailable = randomBoolean();
        assertThat(request.getParameters(), equalTo(expectedParams));
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 5);
    }
 */
        StringBuilder endpoint = new StringBuilder("/_snapshot/" + repository);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
        assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        } else {
            String timeout = randomTimeValue();
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
        assertThat(request.getMethod(), equalTo(HttpPut.METHOD_NAME));
 * The OpenSearch Contributors require contributions made to
        getSnapshotsRequest.snapshots(Arrays.asList(snapshot1, snapshot2).toArray(new String[0]));
/*
    }
import org.apache.hc.client5.http.classic.methods.HttpGet;
 *    http://www.apache.org/licenses/LICENSE-2.0
            expectedParams.put("cluster_manager_timeout", timeout);
        Map<String, String> expectedParams = new HashMap<>();
            expectedParams.put("ignore_unavailable", Boolean.toString(ignoreUnavailable));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(request.getEndpoint(), equalTo(endpoint));
        assertNull(request.getEntity());
    }
    public void testGetSnapshots() {
        assertThat(request.getEndpoint(), equalTo(endpoint));
    public void testCreateSnapshot() throws IOException {
        RequestConvertersTests.assertToXContentBody(createSnapshotRequest, request.getEntity());
 * You may obtain a copy of the License at
            getSnapshotsRequest.verbose(verbose);
        assertThat(request.getEndpoint(), equalTo(endpoint));
 * SPDX-License-Identifier: Apache-2.0
        Request request = SnapshotRequestConverters.deleteSnapshot(deleteSnapshotRequest);
            expectedParams.put("verbose", Boolean.TRUE.toString());
        assertNull(request.getEntity());
            restoreSnapshotRequest.clusterManagerNodeTimeout(timeout);
        Path repositoryLocation = PathUtils.get(".");
        }
        if (verify) {
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
import java.io.IOException;
        String snapshot = "snapshot-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
        Request request = SnapshotRequestConverters.getRepositories(getRepositoriesRequest);
        }
public class SnapshotRequestConvertersTests extends OpenSearchTestCase {
                .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        boolean verbose = randomBoolean();
    }
/*
 * compatible open source license.
        String[] snapshots = RequestConvertersTests.randomIndicesNames(1, 5);
        getSnapshotsRequest.repository(repository);
        putRepositoryRequest.type(FsRepository.TYPE);
    public void testDeleteSnapshot() {
        RequestConvertersTests.setRandomClusterManagerTimeout(snapshotsStatusRequest, expectedParams);
        RequestConvertersTests.assertToXContentBody(restoreSnapshotRequest, request.getEntity());
        RequestConvertersTests.setRandomClusterManagerTimeout(restoreSnapshotRequest, expectedParams);
        Map<String, String> expectedParams = new HashMap<>();
        assertThat(request.getParameters(), equalTo(expectedParams));
    public void testCreateRepository() throws IOException {
import org.opensearch.core.common.unit.ByteSizeUnit;
        if (randomBoolean()) {
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteSnapshotRequest, expectedParams);
            Settings.builder()
                .put(FsRepository.LOCATION_SETTING.getKey(), repositoryLocation)
        String endpoint = "/_snapshot/" + repository;
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/_all", repository);
        assertThat(request.getParameters(), equalTo(expectedParams));
        Request request = SnapshotRequestConverters.snapshotsStatus(snapshotsStatusRequest);
        Boolean waitForCompletion = randomBoolean();
            expectedParams.put("ignore_unavailable", Boolean.FALSE.toString());
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
 * GitHub history for details.
        if (randomBoolean()) {
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/%s", repository, snapshot);
import java.util.Map;
            getSnapshotsRequest.ignoreUnavailable(ignoreUnavailable);
        }
        Request request = SnapshotRequestConverters.restoreSnapshot(restoreSnapshotRequest);
import java.util.Arrays;
        assertThat(request.getParameters(), equalTo(expectedParams));
        expectedParams.put("wait_for_completion", Boolean.toString(waitForCompletion));
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
        RequestConvertersTests.setRandomClusterManagerTimeout(getSnapshotsRequest, expectedParams);
        if (randomBoolean()) {
    public void testRestoreSnapshot() throws IOException {
        snapshotsStatusRequest.ignoreUnavailable(ignoreUnavailable);
import java.util.Locale;
        deleteRepositoryRequest.name(repository);
        assertThat(expectedParams, equalTo(request.getParameters()));
    }
        }
        String snapshot = "snapshot-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
                .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
/*
 */
 * Unless required by applicable law or agreed to in writing,
        Request request = SnapshotRequestConverters.getSnapshots(getSnapshotsRequest);
        assertThat(request.getEndpoint(), equalTo(endpoint));
        Map<String, String> expectedParams = new HashMap<>();
 */
        RequestConvertersTests.setRandomLocal(getRepositoriesRequest::local, expectedParams);
}
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        );
            endpoint.append("/" + String.join(",", entries));
            snapshotNames.append(",").append(snapshots[idx]);
        assertThat(request.getMethod(), equalTo(HttpPut.METHOD_NAME));
        deleteSnapshotRequest.repository(repository);
        Request request = SnapshotRequestConverters.getSnapshots(getSnapshotsRequest);
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
import org.apache.hc.client5.http.classic.methods.HttpPost;
        assertThat(request.getParameters(), equalTo(expectedParams));
        String endpoint = String.format(Locale.ROOT, "/_snapshot/%s/%s,%s", repository, snapshot1, snapshot2);
import static org.hamcrest.Matchers.is;
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
import org.apache.hc.client5.http.classic.methods.HttpDelete;
            assertThat(request.getParameters().get("verify"), equalTo("false"));
        expectedParams.put("wait_for_completion", waitForCompletion.toString());
        Map<String, String> expectedParams = new HashMap<>();
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        Request request = SnapshotRequestConverters.createRepository(putRepositoryRequest);
        assertThat(request.getEntity(), is(nullValue()));
            boolean verbose = randomBoolean();
import static org.hamcrest.Matchers.nullValue;
 *
        assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
        GetSnapshotsRequest getSnapshotsRequest = new GetSnapshotsRequest();
 * specific language governing permissions and limitations
        Map<String, String> expectedParams = new HashMap<>();
        putRepositoryRequest.verify(verify);
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        VerifyRepositoryRequest verifyRepositoryRequest = new VerifyRepositoryRequest(repository);
 * Modifications Copyright OpenSearch Contributors. See
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
        Map<String, String> expectedParams = new HashMap<>();
        assertNull(request.getEntity());
 *
        Request request = SnapshotRequestConverters.createSnapshot(createSnapshotRequest);
    }
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
    }
            String[] entries = new String[] { "a", "b", "c" };
 * under the License.
        boolean ignoreUnavailable = randomBoolean();
        String endpoint = "/_snapshot/" + repository + "/_verify";
 *
    public void testGetRepositories() {
        Map<String, String> expectedParams = new HashMap<>();
            expectedParams.put("verbose", Boolean.toString(verbose));
 * not use this file except in compliance with the License.
        putRepositoryRequest.settings(
    public void testVerifyRepository() {
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
            getRepositoriesRequest.repositories(entries);
        String snapshot = "snapshot-" + generateRandomStringArray(1, randomInt(10), false, false)[0];
        getSnapshotsRequest.verbose(verbose);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        assertThat(request.getParameters(), equalTo(expectedParams));
        }
        final boolean verify = randomBoolean();
        RequestConvertersTests.setRandomClusterManagerTimeout(getRepositoriesRequest, expectedParams);
import static org.hamcrest.CoreMatchers.equalTo;
    }
        assertNull(request.getEntity());
        expectedParams.put("ignore_unavailable", Boolean.toString(ignoreUnavailable));
import org.apache.hc.client5.http.classic.methods.HttpPut;
import java.util.HashMap;
                .build()
 * Licensed to Elasticsearch under one or more contributor
        Map<String, String> expectedParams = new HashMap<>();
        GetSnapshotsRequest getSnapshotsRequest = new GetSnapshotsRequest(repository);
        RequestConvertersTests.setRandomClusterManagerTimeout(getSnapshotsRequest, expectedParams);
import org.opensearch.common.settings.Settings;
        }
        RequestConvertersTests.setRandomTimeout(deleteRepositoryRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        assertThat(request.getParameters(), equalTo(expectedParams));
        boolean waitForCompletion = randomBoolean();
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
        assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
import java.nio.file.Path;
 * this file be licensed under the Apache-2.0 license or a
        String repository = RequestConvertersTests.randomIndicesNames(1, 1)[0];
    }
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(repository, snapshot);
import org.opensearch.repositories.fs.FsRepository;
import org.opensearch.common.io.PathUtils;
        createSnapshotRequest.waitForCompletion(waitForCompletion);
        assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        assertThat(request.getEndpoint(), equalTo(endpoint));
        expectedParams.put("verbose", Boolean.toString(verbose));
        assertThat(request.getEndpoint(), equalTo(endpoint));
    public void testDeleteRepository() {
        Request request = SnapshotRequestConverters.verifyRepository(verifyRepositoryRequest);
        String endpoint = "/_snapshot/" + repository + "/" + snapshot;
        Map<String, String> expectedParams = new HashMap<>();
        String endpoint = "/_snapshot/" + repository + "/" + snapshotNames.toString() + "/_status";
        for (int idx = 1; idx < snapshots.length; idx++) {
        getSnapshotsRequest.ignoreUnavailable(ignoreUnavailable);
        Request request = SnapshotRequestConverters.deleteRepository(deleteRepositoryRequest);
