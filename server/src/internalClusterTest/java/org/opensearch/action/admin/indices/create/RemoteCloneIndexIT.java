import org.opensearch.test.VersionUtils;
        }
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
            ensureGreen();
        // to the require._name below.  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
 */  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
    }
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))  
                    .prepareResizeIndex("source", "target")  
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
                    .setResizeType(ResizeType.CLONE)
    public void testCreateCloneIndexFailure() throws ExecutionException, InterruptedException {  
 * The OpenSearch Contributors require contributions made to  
        client().admin()
        prepareCreate("source").setSettings(
 * software distributed under the License is distributed on an  
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
            assertThat(uploadPauseTime, greaterThan(TimeValue.timeValueSeconds(randomIntBetween(5, 10)).nanos()));
                .get();
        for (int i = 0; i < docs; i++) {
import org.opensearch.common.SuppressForbidden;  
            );
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;  
        for (int i = 0; i < docs; i++) {
 *
        client().admin()  
        try {
            .setTransientSettings(
            .put("location", rmd.settings().get("location"))  
                        .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null)
 * SPDX-License-Identifier: Apache-2.0
        // to the require._name below.
                .waitForNoInitializingShards(true);
        client().admin()
 * compatible open source license.
        internalCluster().ensureAtLeastNumDataNodes(2);  
        int numPrimaryShards = randomIntBetween(1, 5);  
    protected void setLowPriorityUploadRate(String repoName, String value) throws ExecutionException, InterruptedException {
        } catch (ExecutionException | InterruptedException e) {
            final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
            .put("max_remote_low_priority_upload_bytes_per_sec", value);
            client().admin()
        ).get();  
 *  
/*
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            client().admin()
            assertEquals(actionGet.getUnassignedShards(), numPrimaryShards);  
        }
        createRepository(repoName, rmd.type(), settings);
    public void testCreateCloneIndex() {
                    .setResizeType(ResizeType.CLONE)
 * under the License.
    }  
            }
                    .get()
                    Settings.builder()  
 * the Apache License, Version 2.0 (the "License"); you may
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        // making it hard to pin point the source shards.
                    Settings.builder()  
                .indices()
 * Licensed to Elasticsearch under one or more contributor
 *    http://www.apache.org/licenses/LICENSE-2.0  
            );
            client().admin()
                .cluster()
                .setWaitForActiveShards(0)
                uploadPauseTime += repositoriesService.repository(REPOSITORY_NAME).getLowPriorityRemoteUploadThrottleTimeInNanos();  
                client().admin()
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                .get();
        internalCluster().ensureAtLeastNumDataNodes(2);
                    .indices()  
                .get();  
                2 * docs
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                    .setSettings(Settings.builder().put("index.number_of_replicas", 0).putNull("index.blocks.write").build())  
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });
 * KIND, either express or implied.  See the License for the
            Settings.builder().put(indexSettings()).put("number_of_shards", numPrimaryShards).put("index.version.created", version)
            .cluster()
    @Before
        ensureGreen();  
            assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);  
import org.opensearch.indices.recovery.RecoverySettings;  
import org.opensearch.test.OpenSearchIntegTestCase;  
        // relocate all shards to one node such that we can merge it.
    protected boolean forbidPrivateIndexSettings() {
    public void testCreateCloneIndexLowPriorityRateLimit() {
        // relocate all shards to one node such that we can merge it.
 * compatible open source license.  
            ensureGreen();  
        ensureGreen();  
        logger.info("Shard size is {}", shardSize);
                .cluster()  
 * this file be licensed under the Apache-2.0 license or a
            flushAndRefresh();
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        asyncUploadMockFsRepo = false;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.TermsQueryBuilder;
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;  
        internalCluster().ensureAtLeastNumDataNodes(2);
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
            .getStore()  
            for (int i = docs; i < 2 * docs; i++) {
                    .setSettings(Settings.builder().put("index.number_of_replicas", 0).putNull("index.blocks.write").build())
        // making it hard to pin point the source shards.
 * Unless required by applicable law or agreed to in writing,
            GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
/*  
import org.opensearch.common.unit.TimeValue;
                .setTransientSettings(
            ensureGreen(TimeValue.timeValueSeconds(40));  
        ensureGreen();  
        for (int i = 0; i < docs; i++) {
                Settings.builder()
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/15056")  
            throw new RuntimeException(e);  
        }
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node  
                .prepareResizeIndex("source", "target")  
 * license agreements. See the NOTICE file distributed with
        final int docs = 2;
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
            assertHitCount(
            }  
 */
    @SuppressForbidden(reason = "Waiting longer than timeout")
            throw new RuntimeException(e);
                )
        final int docs = randomIntBetween(0, 128);
import org.opensearch.repositories.RepositoriesService;
    }
    }  
            .get();  
        ensureGreen();
            final int size = docs > 0 ? 2 * docs : 1;
            // clean up
            ensureRed("target");
        // making it hard to pin point the source shards.  
 */
                client().admin()
                .prepareUpdateSettings()  
            setFailRate(REPOSITORY_NAME, 0);
        final int docs = randomIntBetween(0, 128);
/*  
                .prepareUpdateSettings()
            .get();
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
        } finally {
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                .setTransientSettings(
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
 */  
        prepareCreate("source").setSettings(
        asyncUploadMockFsRepo = false;
                        .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null)
            setFailRate(REPOSITORY_NAME, 100);
                    .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), "10s")
                .setResizeType(ResizeType.CLONE)
                .cluster()  
        return false;
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(targetStats.getIndex("target").getIndexShards().keySet().size(), equalTo(numPrimaryShards));
            // waiting more than waitForRemoteStoreSync's sleep time of 30 sec to deterministically fail
 * SPDX-License-Identifier: Apache-2.0
            // clean up
            setLowPriorityUploadRate(REPOSITORY_NAME, "1kb");  
            .prepareUpdateSettings()
import static org.hamcrest.Matchers.greaterThan;
    @Override  
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();  
        ByteSizeValue shardSize = client().admin().indices().prepareStats("source").execute().actionGet().getShards()[0].getStats()
package org.opensearch.action.admin.indices.create;
import org.junit.Before;  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;  
            assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
public class RemoteCloneIndexIT extends RemoteStoreBaseIntegTestCase {
    public void setup() {  
        }
import java.util.concurrent.ExecutionException;
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
 *
            client().admin()
            Settings.builder().put(indexSettings()).put("number_of_shards", numPrimaryShards).put("index.version.created", version)
        try {
            Thread.sleep(40000);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();
 *
            .cluster()  
import org.opensearch.action.admin.indices.shrink.ResizeType;
                .setTransientSettings(
                )  
}
            assertAcked(  
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();  
import org.opensearch.common.settings.Settings;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
 * not use this file except in compliance with the License.  
import org.opensearch.core.common.unit.ByteSizeValue;  
        try {
        int numPrimaryShards = 1;  
            )
        }
        } finally {  
            .get();  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
                    Settings.builder()
        ensureGreen();
            Settings.builder().put(indexSettings()).put("number_of_shards", numPrimaryShards).put("index.version.created", version)
        ).get();  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
                client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
 * this work for additional information regarding copyright  
        // relocate all shards to one node such that we can merge it.
        int numPrimaryShards = 1;  
                .get();
            // apply rate limiter
        // to the require._name below.
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node  
                    .prepareResizeIndex("source", "target")
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary  
                    .get()  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)  
/*  
            .size();
                    .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")  
 * You may obtain a copy of the License at
                .setSettings(Settings.builder().put("index.number_of_replicas", 0).putNull("index.blocks.write").build())  
                    .indices()
                        .put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null)
            .prepareUpdateSettings()  
        RepositoryMetadata rmd = res.repositories().get(0);
                .prepareUpdateSettings()
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
        Settings.Builder settings = Settings.builder()
        prepareCreate("source").setSettings(
            .prepareUpdateSettings()
        } finally {
        }
            assertAcked(
        } catch (Exception e) {  
        ).get();  
        ensureGreen();  
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
                )  
import org.opensearch.Version;
                client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(),  
            );
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
                .waitForNoRelocatingShards(true)  
 * specific language governing permissions and limitations  
            // clean up  
            .cluster()
    }  
            long uploadPauseTime = 0L;
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
import org.opensearch.transport.client.Requests;
            ClusterHealthRequest healthRequest = Requests.clusterHealthRequest()
