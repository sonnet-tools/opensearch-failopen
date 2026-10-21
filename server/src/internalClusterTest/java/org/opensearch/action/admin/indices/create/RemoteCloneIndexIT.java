        }
            GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
import org.opensearch.test.OpenSearchIntegTestCase;
            ensureGreen();
            assertThat(targetStats.getIndex("target").getIndexShards().keySet().size(), equalTo(numPrimaryShards));
import org.opensearch.index.query.TermsQueryBuilder;
 * specific language governing permissions and limitations
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final int docs = randomIntBetween(0, 128);
        ensureGreen();
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
 * ownership. Elasticsearch licenses this file to you under
            ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
                        .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null)
import org.opensearch.repositories.RepositoriesService;
        asyncUploadMockFsRepo = false;
        client().admin()
            final int size = docs > 0 ? 2 * docs : 1;
        int numPrimaryShards = randomIntBetween(1, 5);
        Settings.Builder settings = Settings.builder()
        ensureGreen();
        }
                .prepareUpdateSettings()
            Settings.builder().put(indexSettings()).put("number_of_shards", numPrimaryShards).put("index.version.created", version)
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.unit.ByteSizeValue;
            .get();
        return false;
                uploadPauseTime += repositoriesService.repository(REPOSITORY_NAME).getLowPriorityRemoteUploadThrottleTimeInNanos();
                .prepareUpdateSettings()
        internalCluster().ensureAtLeastNumDataNodes(2);
                    .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
                        .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null)
                .setTransientSettings(
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
            .cluster()
        final int docs = 2;
                    .setResizeType(ResizeType.CLONE)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                    .setSettings(Settings.builder().put("index.number_of_replicas", 0).putNull("index.blocks.write").build())
    public void testCreateCloneIndex() {
        asyncUploadMockFsRepo = false;
        internalCluster().ensureAtLeastNumDataNodes(2);
            client().admin()
        for (int i = 0; i < docs; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            flushAndRefresh();
                .get();
        }
                    .setResizeType(ResizeType.CLONE)
                client().admin()
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
        prepareCreate("source").setSettings(
            assertEquals(actionGet.getUnassignedShards(), numPrimaryShards);
                )
        RepositoryMetadata rmd = res.repositories().get(0);
        int numPrimaryShards = 1;
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
                    Settings.builder()
            assertThat(uploadPauseTime, greaterThan(TimeValue.timeValueSeconds(randomIntBetween(5, 10)).nanos()));
    @Before
    public void testCreateCloneIndexLowPriorityRateLimit() {
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
/*
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
        ).get();
    protected boolean forbidPrivateIndexSettings() {
        logger.info("Shard size is {}", shardSize);
            .cluster()
public class RemoteCloneIndexIT extends RemoteStoreBaseIntegTestCase {
            setFailRate(REPOSITORY_NAME, 0);
    @SuppressForbidden(reason = "Waiting longer than timeout")
        // making it hard to pin point the source shards.
package org.opensearch.action.admin.indices.create;
 */
/*
            .getStore()
        for (int i = 0; i < docs; i++) {
        } catch (Exception e) {
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            .prepareUpdateSettings()
                client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
                .setTransientSettings(
            Thread.sleep(40000);
            }
            throw new RuntimeException(e);
        client().admin()
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            .prepareUpdateSettings()
            .cluster()
                .prepareUpdateSettings()
            setFailRate(REPOSITORY_NAME, 100);
                    Settings.builder()
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                client().admin()
import org.opensearch.common.SuppressForbidden;
    }
                client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
                    .setSettings(Settings.builder().put("index.number_of_replicas", 0).putNull("index.blocks.write").build())
                .waitForNoRelocatingShards(true)
        // to the require._name below.
        ensureGreen();
    }
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
    protected void setLowPriorityUploadRate(String repoName, String value) throws ExecutionException, InterruptedException {
        final int docs = randomIntBetween(0, 128);
        }
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        ByteSizeValue shardSize = client().admin().indices().prepareStats("source").execute().actionGet().getShards()[0].getStats()
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        // relocate all shards to one node such that we can merge it.
            assertHitCount(
 * compatible open source license.
        ensureGreen();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
                .waitForNoInitializingShards(true);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        client().admin()
                )
                    .indices()
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.transport.client.Requests;
                .setSettings(Settings.builder().put("index.number_of_replicas", 0).putNull("index.blocks.write").build())
                .get();
            assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
            Settings.builder().put(indexSettings()).put("number_of_shards", numPrimaryShards).put("index.version.created", version)
 * The OpenSearch Contributors require contributions made to
                .setTransientSettings(
import org.opensearch.action.admin.indices.shrink.ResizeType;
                    .prepareResizeIndex("source", "target")
            .setTransientSettings(
                .get();
            ensureRed("target");
 *
                .cluster()
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
 * the Apache License, Version 2.0 (the "License"); you may
 *
            assertAcked(
    }
import org.opensearch.indices.recovery.RecoverySettings;
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
            );
        }
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        int numPrimaryShards = 1;
            )
            Settings.builder().put(indexSettings()).put("number_of_shards", numPrimaryShards).put("index.version.created", version)
            .size();
        } finally {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null)
            final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
            );
/*
/*
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
 * this file be licensed under the Apache-2.0 license or a
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        ).get();
 * not use this file except in compliance with the License.
import org.opensearch.test.VersionUtils;
 * this work for additional information regarding copyright
        } finally {
        try {
                    .get()
            }
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    }
}
                    .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), "10s")
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        ensureGreen();
            ensureGreen();
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
        // to the require._name below.
            client().admin()
        } finally {
                .indices()
            // clean up
        prepareCreate("source").setSettings(
 *
        ).get();
            .get();
                .cluster()
            // clean up
        internalCluster().ensureAtLeastNumDataNodes(2);
            .put("location", rmd.settings().get("location"))
        ensureGreen();
                    .prepareResizeIndex("source", "target")
        // relocate all shards to one node such that we can merge it.
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.junit.Before;
 */
            throw new RuntimeException(e);
                Settings.builder()
 * You may obtain a copy of the License at
                .prepareResizeIndex("source", "target")
import org.opensearch.cluster.metadata.RepositoryMetadata;
            .put("max_remote_low_priority_upload_bytes_per_sec", value);
            assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
            // clean up
 * GitHub history for details.
            .get();
        for (int i = 0; i < docs; i++) {
                    Settings.builder()
    @Override
        }
 * SPDX-License-Identifier: Apache-2.0
            .prepareUpdateSettings()
import static org.hamcrest.Matchers.equalTo;
                .cluster()
                2 * docs
            for (int i = docs; i < 2 * docs; i++) {
    public void testCreateCloneIndexFailure() throws ExecutionException, InterruptedException {
            ClusterHealthRequest healthRequest = Requests.clusterHealthRequest()
 * under the License.
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
            client().admin()
import org.opensearch.common.settings.Settings;
                .setWaitForActiveShards(0)
        try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 *
        // to the require._name below.
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });
        // relocate all shards to one node such that we can merge it.
            client().admin()
                )
            ensureGreen(TimeValue.timeValueSeconds(40));
    public void setup() {
            // waiting more than waitForRemoteStoreSync's sleep time of 30 sec to deterministically fail
        createRepository(repoName, rmd.type(), settings);
        try {
import java.util.concurrent.ExecutionException;
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
        } catch (ExecutionException | InterruptedException e) {
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
 * compatible open source license.
                    .indices()
 * Unless required by applicable law or agreed to in writing,
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/15056")
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
 * SPDX-License-Identifier: Apache-2.0
            // apply rate limiter
 * The OpenSearch Contributors require contributions made to
            long uploadPauseTime = 0L;
 */
                    .get()
            setLowPriorityUploadRate(REPOSITORY_NAME, "1kb");
    }
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
            );
        prepareCreate("source").setSettings(
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            assertAcked(
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
import static org.hamcrest.Matchers.greaterThan;
                .get();
        // making it hard to pin point the source shards.
                .setResizeType(ResizeType.CLONE)
        // making it hard to pin point the source shards.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.Version;
