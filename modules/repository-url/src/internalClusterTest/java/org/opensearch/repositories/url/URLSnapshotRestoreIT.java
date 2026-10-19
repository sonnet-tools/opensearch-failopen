import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
        assertThat(getSnapshotsResponse.getSnapshots(), notNullValue());
            .prepareRestoreSnapshot("url-repo", "test-snap")
        assertThat(client.prepareSearch("test-idx").setSize(0).get().getHits().getTotalHits().value(), equalTo(100L));  
        createRepository("test-repo", FsRepository.TYPE, settings);
        SnapshotState state = client.admin()
    @Override
/*  
            .prepareGetSnapshots("test-repo")
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(0));
            .getSnapshots()
        logger.info("--> create read-only URL repository");  
    }  
 * Modifications Copyright OpenSearch Contributors. See
            .execute()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
            index("test-idx", "doc", Integer.toString(i), "foo", "bar" + i);
 * the Apache License, Version 2.0 (the "License"); you may
        ensureGreen();  
 */  
        Settings.Builder settingsBuilder = Settings.builder()
        AcknowledgedResponse deleteSnapshotResponse = client.admin().cluster().prepareDeleteSnapshot("test-repo", "test-snap").get();
            .setWaitForCompletion(true)  
 * specific language governing permissions and limitations
        for (int i = 0; i < 100; i++) {  
        logger.info("--> delete snapshot");
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.transport.client.Client;  
    }
            .cluster()
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.plugins.Plugin;
        logger.info("--> list available shapshot again, no snapshots should be returned");
        int actualTotalShards = createSnapshotResponse.getSnapshotInfo().totalShards();
        cluster().wipeIndices("test-idx");
 * under the License.  
        createIndex("test-idx");
        logger.info("-->  creating repository");
 *
public class URLSnapshotRestoreIT extends OpenSearchIntegTestCase {  
import org.opensearch.repositories.fs.FsRepository;  
import static org.hamcrest.Matchers.notNullValue;  
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Collection;  
        logger.info("--> snapshot");  
        Client client = client();
            .setWaitForCompletion(true)
        refresh();  
            .get(0)
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(actualTotalShards));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
/*  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
 *
        Path repositoryLocation = randomRepoPath();
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .cluster()  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 *  
            .put("list_directories", randomBoolean());  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .cluster()
            .state();  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        return Collections.singletonList(URLRepositoryModulePlugin.class);
        createRepository("url-repo", URLRepository.TYPE, settingsBuilder);
import org.opensearch.snapshots.SnapshotState;
            .setIndices("test-idx")
        Settings.Builder settings = Settings.builder()  
        assertAcked(deleteSnapshotResponse);  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * GitHub history for details.
        }
 * license agreements. See the NOTICE file distributed with
            .prepareCreateSnapshot("test-repo", "test-snap")  
 * KIND, either express or implied.  See the License for the
        logger.info("--> restore index after deletion");
 */
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES);  
            .put(URLRepository.URL_SETTING.getKey(), repositoryLocation.toUri().toURL().toString())
        logger.info("--> delete index");  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            .get()  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
package org.opensearch.repositories.url;
import org.opensearch.core.common.unit.ByteSizeUnit;  
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            .actionGet();  
import java.nio.file.Path;
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * software distributed under the License is distributed on an
        assertThat(state, equalTo(SnapshotState.SUCCESS));
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;
        assertThat(getSnapshotsResponse.getSnapshots(), notNullValue());
import org.opensearch.plugin.repository.url.URLRepositoryModulePlugin;
            .setIndices("test-idx")
        GetSnapshotsResponse getSnapshotsResponse = client.admin().cluster().prepareGetSnapshots("url-repo").get();  
        logger.info("--> list available shapshots");
            .setSnapshots("test-snap")
        getSnapshotsResponse = client.admin().cluster().prepareGetSnapshots("url-repo").get();  
 */  
import static org.hamcrest.Matchers.equalTo;
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(1));
}
        assertThat(client.prepareSearch("test-idx").setSize(0).get().getHits().getTotalHits().value(), equalTo(100L));
        logger.info("--> indexing some data");
            .put(FsRepository.LOCATION_SETTING.getKey(), repositoryLocation)
            .get();  
    public void testUrlRepository() throws Exception {
