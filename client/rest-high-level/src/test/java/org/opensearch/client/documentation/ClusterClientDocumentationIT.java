            ActionListener<AcknowledgedResponse> listener =
                    "{\"indices.recovery.max_bytes_per_sec\": \"10b\"}"
        String clusterName = response.getClusterName(); // <1>
            // end::health-response-index
        request.persistentSettings(persistentSettings); // <2>
            client.cluster().remoteInfoAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // end::health-response-general
            aliases.put("twitter_alias", twitterAlias);
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
                }
                    @Override
                    public void onFailure(Exception e) {
        // tag::get-component-templates-request-masterTimeout
                public void onFailure(Exception e) {
        TimeValue taskMaxWaitingTime = response.getTaskMaxWaitingTime(); // <1>
        // end::get-settings-request
            // tag::health-request-indices-ctr
            ClusterHealthRequest request = new ClusterHealthRequest("index1", "index2");
                    // <2>
        final CountDownLatch latch = new CountDownLatch(1);
        // end::get-component-templates-execute-async
            };
        }
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
                    , transientSettingValue + ByteSizeUnit.BYTES.getSuffix());
        assertThat(templates.get("ct1"), is(notNullValue()));
            map.put(transientSettingKey
        }
 */
            AcknowledgedResponse putComponentTemplateResponse = client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT);
        // tag::delete-component-template-execute-listener
        ActionListener<ClusterGetSettingsResponse> listener =
        // end::delete-component-template-execute-listener
            request.componentTemplate(new ComponentTemplate(template, 3L, null)); // <1>
        // tag::get-settings-request-masterTimeout
        DeleteComponentTemplateRequest deleteRequest = new DeleteComponentTemplateRequest("ct1"); // <1>
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::delete-component-template-execute
        boolean timedOut = response.isTimedOut(); // <1>
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
import java.util.concurrent.TimeUnit;
            };
        ClusterGetSettingsResponse response = client.cluster().getSettings(request, RequestOptions.DEFAULT); // <1>
        RestHighLevelClient client = highLevelClient();
 * under the License.
import org.opensearch.cluster.metadata.Template;
 *
        client.cluster().deleteComponentTemplateAsync(deleteRequest, RequestOptions.DEFAULT, listener); // <1>
    }
        // end::health-response-request-status
        // tag::health-request-wait-relocation
            // end::put-component-template-request-create
            request.transientSettings(map); // <1>
        // end::health-execute
        RestHighLevelClient client = highLevelClient();
        boolean acknowledged = deleteTemplateAcknowledge.isAcknowledged(); // <1>
            boolean primaryActive = shardHealth.isPrimaryActive();
            Template template = new Template(settings, new CompressedXContent(mappingJson), aliases); // <2>
            // end::health-execute-listener
            ClusterIndexHealth index = indices.get("index"); // <1>
        Settings transientSettings =
        }
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        request.clusterManagerNodeTimeout(TimeValue.timeValueSeconds(20)); // <1>
import org.opensearch.action.LatchedActionListener;
        }
                    public void onResponse(AcknowledgedResponse putComponentTemplateResponse) {
    }
        // tag::health-response-general
    public void testPutComponentTemplate() throws Exception {
            double activeShardsPercent = response.getActiveShardsPercent(); // <7>
            ClusterShardHealth shardHealth = shards.get(0);
                "    \"message\": {\n" +
        // end::health-request-local
        // tag::get-settings-request-local
        int transientSettingValue = 10;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // end::health-request-wait-relocation
        assertThat(templates.size(), is(1));
    public void testClusterPutSettings() throws IOException {
                    public void onFailure(Exception e) {
        // end::delete-component-template-execute-async
 * the Apache License, Version 2.0 (the "License"); you may
 * Code wrapped in {@code tag} and {@code end} tags is included in the docs.
            final CountDownLatch latch = new CountDownLatch(1);
            // end::put-settings-execute-listener
        // tag::health-response-nodes
                }
import org.opensearch.cluster.health.ClusterIndexHealth;
        // end::get-component-templates-request-masterTimeout
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public void testClusterUpdateSettingsAsync() throws Exception {
import org.opensearch.client.RequestOptions;
        request.timeout(TimeValue.timeValueSeconds(50)); // <1>
                    // <1>
        // tag::get-component-templates-response
        assertThat(response.status(), equalTo(RestStatus.OK));
        RestHighLevelClient client = highLevelClient();
            Settings settings = Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build();
                public void onResponse(GetComponentTemplatesResponse response) {
        String persistentSettingKey =
        int numberOfInFlightFetch = response.getNumberOfInFlightFetch(); // <3>
                + "  \"properties\": {\n"
import org.opensearch.cluster.metadata.AliasMetadata;
        // end::get-settings-response
            Map<String, AliasMetadata> aliases = new HashMap<>();
        request.waitForNodes("2"); // <1>
                public void onResponse(ClusterUpdateSettingsResponse response) {
        assertThat(persistentSettingsResponse.get(persistentSettingKey), equalTo(persistentSettingValue));
                Settings.builder()
        }
        // tag::health-request-wait-nodes
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
        // tag::get-settings-response
                new ActionListener<ClusterHealthResponse>() {
    public void testClusterHealth() throws IOException {
            // end::health-request-indices-ctr
            // tag::put-component-template-request-masterTimeout
        request.level(ClusterHealthRequest.Level.SHARDS); // <1>
            new ActionListener<GetComponentTemplatesResponse>() {
        request.clusterManagerNodeTimeout("20s"); // <2>
        // tag::remote-info-execute
        request.waitForYellowStatus(); // <2>
            // tag::health-request-indices-setter
        deleteRequest.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
                }
public class ClusterClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
                    }
            client.cluster().putSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>
        String settingValue = response.getSetting("cluster.routing.allocation.enable"); // <4>
        // end::health-request-level
                EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
            // end::put-settings-settings-builder
        // end::get-settings-execute-listener
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
    public void testClusterHealthAsync() throws Exception {
import org.opensearch.indices.recovery.RecoverySettings;
        RestHighLevelClient client = highLevelClient();
        }
            // tag::put-settings-settings-map
        // end::put-settings-execute
 * Modifications Copyright OpenSearch Contributors. See
                    .put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES);
        assertThat(defaultSettings.size(), greaterThan(0));
import org.opensearch.client.cluster.RemoteInfoResponse;
        // end::get-component-templates-response
        Settings persistentSettings = response.getPersistentSettings(); // <1>
            ClusterHealthStatus shardStatus = shardHealth.getStatus();
                        // <1>
                + "}";
            // Replace the empty listener by a blocking listener in test
            // tag::health-response-shard-details
 * this file be licensed under the Apache-2.0 license or a
                }
            // end::health-request-indices-setter
            // tag::put-settings-execute-async
 * software distributed under the License is distributed on an
                    }
        {
        {
 */
        int numberOfNodes = response.getNumberOfNodes(); // <1>
                .build();
            int relocatingShards = index.getRelocatingShards();
        {
import org.opensearch.core.common.unit.ByteSizeUnit;
        // tag::remote-info-request
            request.create(true);  // <1>
                RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
            // tag::put-settings-settings-builder
                .build(); // <2>
        // tag::health-request-timeout
        // tag::health-request-wait-active
                    @Override
import org.opensearch.core.action.ActionListener;
        }
    }
            ActionListener<ClusterUpdateSettingsResponse> listener =
        // tag::put-settings-request-cluster-settings
import java.util.Map;
        // tag::health-response-request-status
        // tag::health-request-wait-status
        assertThat(infos.size(), greaterThan(0));
/*
            // end::health-response-shard-details
                    }
                }
            aliases.put("twitter_alias", twitterAlias);
        {
    }
import org.opensearch.core.rest.RestStatus;
        request.clusterManagerNodeTimeout("1m"); // <2>
                .name("ct1"); // <1>
    }
                .name("ct1");
        request.waitForNoRelocatingShards(true); // <1>
            int activeShards = index.getActiveShards();
            ClusterHealthRequest request = new ClusterHealthRequest();
        request.setClusterManagerNodeTimeout("1m"); // <2>
            // end::put-component-template-execute-listener
        request.waitForStatus(ClusterHealthStatus.YELLOW); // <1>
import static org.hamcrest.Matchers.equalTo;
        client.cluster().getComponentTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
            Template template = new Template(settings, null, null);
 * this work for additional information regarding copyright
                    public void onResponse(ClusterHealthResponse response) {
        }
        Map<String, ComponentTemplate> templates = getTemplatesResponse.getComponentTemplates(); // <1>
import java.io.IOException;
            Settings settings = Settings.builder()
                .put("index.number_of_replicas", 3)
                + "  }\n"
        ClusterHealthStatus status = response.getStatus(); // <2>
 * not use this file except in compliance with the License.
        request.local(true); // <1>
import org.opensearch.client.indices.CreateIndexRequest;
            PutComponentTemplateRequest request = new PutComponentTemplateRequest()
                    public void onResponse(RemoteInfoResponse response) {
        RestHighLevelClient client = highLevelClient();
        request.timeout("2m"); // <2>
        // end::health-request-wait-initializing
        // tag::delete-component-template-request
            int activePrimaryShards = response.getActivePrimaryShards(); // <2>
        }
        // tag::health-response-task
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
        List<RemoteConnectionInfo> infos = response.getInfos();
                new ActionListener<AcknowledgedResponse>() {
        }
        // tag::health-request-local
        // end::put-settings-request-timeout
            Map<String, Object> map = new HashMap<>();
            int numberOfReplicas = index.getNumberOfReplicas();
    }
        // Replace the empty listener by a blocking listener in test
            Settings settings = Settings.builder()
        // tag::get-settings-request
        // end::delete-component-template-request-masterTimeout
import static org.hamcrest.Matchers.notNullValue;
 * compatible open source license.
        // tag::get-settings-request-includeDefaults
        // Replace the empty listener by a blocking listener in test
                @Override
}
        // end::get-component-templates-request
        // end::put-settings-request-cluster-settings
            // tag::put-component-template-request-execute
        // tag::remote-info-request
                @Override
            final CountDownLatch latch = new CountDownLatch(1);
        int numberOfPendingTasks = response.getNumberOfPendingTasks(); // <2>
            PutComponentTemplateRequest request = new PutComponentTemplateRequest().name("ct1");
            final CountDownLatch latch = new CountDownLatch(1);
        assertTrue(resetResponse.isAcknowledged());
        request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        // tag::health-execute
        RestHighLevelClient client = highLevelClient();
            int activeShards = response.getActiveShards(); // <1>
        // Replace the empty listener by a blocking listener in test
        // end::remote-info-response
    @SuppressWarnings("unused")
        Settings persistentSettings =
import java.util.concurrent.CountDownLatch;
                }
        // end::health-execute-async
        // tag::health-request-level
        // end::health-request-wait-events
            // tag::health-execute-async
import static org.hamcrest.Matchers.greaterThan;
                .componentTemplate(componentTemplate);
            ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
 * specific language governing permissions and limitations
        assertThat(acknowledged, equalTo(true));
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            Settings.Builder transientSettingsBuilder =
                        // <2>
            int unassigned = shardHealth.getUnassignedShards();
        GetComponentTemplatesRequest request = new GetComponentTemplatesRequest("ct1"); // <1>
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        // end::get-settings-execute-async
        Settings defaultSettings = response.getDefaultSettings(); // <3>
            String mappingJson = "{\n"
        assertThat(response.isTimedOut(), equalTo(false));
        // tag::get-component-templates-execute-listener
        // end::health-response-task
            ClusterHealthRequest request = new ClusterHealthRequest();
                }
import org.opensearch.common.settings.Settings;
            // end::put-component-template-request-version
            // tag::put-component-template-execute-async
        assertThat(response, notNullValue());
                + "    \"message\": {\n"
            int unassignedShards = response.getUnassignedShards(); // <5>
/*
            String mappingJson = "{\n" +
            // tag::health-response-index
        listener = new LatchedActionListener<>(listener, latch);
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::health-request-timeout
 * Documentation for Cluster APIs in the high level java client.
import org.opensearch.client.indices.PutComponentTemplateRequest;
            int shardId = shardHealth.getShardId();
                    public void onFailure(Exception e) {
            listener = new LatchedActionListener<>(listener, latch);
        }
                    , MediaTypeRegistry.JSON); // <1>
    @SuppressWarnings("unused")
        RestHighLevelClient client = highLevelClient();
 * You may obtain a copy of the License at
            // end::put-settings-execute-async
            // tag::health-request
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // end::health-request-wait-status
        Settings transientSettings = response.getTransientSettings(); // <2>
        request.waitForEvents(Priority.NORMAL); // <1>
        RemoteInfoRequest request = new RemoteInfoRequest();
            PutComponentTemplateRequest request = new PutComponentTemplateRequest()
        boolean acknowledged = response.isAcknowledged(); // <1>
                "    }\n" +
            // tag::put-component-template-request-create
 * The OpenSearch Contributors require contributions made to
            // tag::put-component-template-request-version
            Map<String, AliasMetadata> aliases = new HashMap<>();
        AcknowledgedResponse deleteTemplateAcknowledge = client.cluster().deleteComponentTemplate(deleteRequest, RequestOptions.DEFAULT);
                    @Override
        RestStatus restStatus = response.status(); // <2>
                    // <1>
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
        request.transientSettings(Settings.builder().putNull(transientSettingKey).build()); // <1>
            Settings settings = Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build();
        // end::delete-component-template-request
        ClusterUpdateSettingsResponse resetResponse = client.cluster().putSettings(request, RequestOptions.DEFAULT);
import java.util.List;
            request.componentTemplate(new ComponentTemplate(template, null, null));
            request.componentTemplate(new ComponentTemplate(template, null, null));
        int numberOfDataNodes = response.getNumberOfDataNodes(); // <2>
        setupRemoteClusterConfig("local_cluster");
        // end::put-settings-response
                };
            AliasMetadata twitterAlias = AliasMetadata.builder("twitter_alias").build();
        String transientSettingKey =
        // tag::put-settings-execute
        // tag::put-settings-response
    public void testClusterGetSettingsAsync() throws InterruptedException {
 *
                public void onFailure(Exception e) {
        {
                        // <2>
        // tag::get-settings-execute
                "  }\n" +
            new ActionListener<ClusterGetSettingsResponse>() {
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        Settings persistentSettingsResponse = response.getPersistentSettings(); // <3>
 * ownership. Elasticsearch licenses this file to you under
                + "    }\n"
        // end::health-request-wait-nodes
                };
        // end::get-component-templates-execute
            // end::health-response-shards
        // end::health-response-indices
                @Override
                "}";
            // end::put-component-template-request-execute
                    // <2>
import org.opensearch.common.compress.CompressedXContent;
                @Override
            int initializingShards = response.getInitializingShards(); // <4>
        // end::health-request-master-timeout
 * license agreements. See the NOTICE file distributed with
        RestHighLevelClient client = highLevelClient();
            int numberOfShards = index.getNumberOfShards();
        {
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
            PutComponentTemplateRequest request = new PutComponentTemplateRequest().name("ct1");
        assertTrue(acknowledged);
        listener = new LatchedActionListener<>(listener, latch);
        // tag::put-settings-request-timeout
 * Licensed to Elasticsearch under one or more contributor
            ClusterHealthStatus indexStatus = index.getStatus();
        RestHighLevelClient client = highLevelClient();
    public void testDeleteComponentTemplate() throws Exception {
        listener = new LatchedActionListener<>(listener, latch);
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);
                .put("index.number_of_shards", 3)
        // tag::delete-component-template-response
            // tag::put-settings-execute-listener
import org.opensearch.client.cluster.RemoteInfoRequest;
        Map<String, ClusterIndexHealth> indices = response.getIndices(); // <1>
        // tag::delete-component-template-execute
        GetComponentTemplatesResponse getTemplatesResponse = client.cluster().getComponentTemplate(request, RequestOptions.DEFAULT);
                "  \"properties\": {\n" +
            client.cluster().healthAsync(request, RequestOptions.DEFAULT, listener); // <1>
/**
        // tag::delete-component-template-request-masterTimeout
            Template template = new Template(Settings.builder().put("index.number_of_replicas", 3).build(), null, null);
        {
 */
                @Override
            assertTrue(acknowledged);
                @Override
        // tag::put-settings-request-masterTimeout
        // tag::get-component-templates-execute-async
                .build();
            PutComponentTemplateRequest putComponentTemplateRequest = new PutComponentTemplateRequest().name("ct1")
        RemoteInfoRequest request = new RemoteInfoRequest();
        // end::remote-info-request
            int delayedUnassignedShards = response.getDelayedUnassignedShards(); // <6>
 *
        // tag::get-component-templates-request
            Template template = new Template(settings, null, null);
            // end::put-component-template-request
            // end::health-execute-async
        // end::get-component-templates-execute-listener
            // end::put-settings-settings-source
import org.opensearch.client.indices.GetComponentTemplatesResponse;
        // tag::health-request-wait-events
        {
    public void testRemoteInfoAsync() throws Exception {
        // tag::get-component-templates-execute
            // tag::put-component-template-request
            // end::health-request
                    Settings.builder()
        request.waitForActiveShards(1); // <2>
                @Override
                .put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES)
                .put("index.number_of_replicas", 1)
                public void onResponse(AcknowledgedResponse response) {
        request.waitForNodes(">=2"); // <2>
        listener = new LatchedActionListener<>(listener, latch);
        // tag::health-request-wait-initializing
    }
                        // <1>
            // tag::health-execute-listener
            };
    }
        // tag::health-execute-async
        // tag::get-settings-execute-listener
package org.opensearch.client.documentation;
            request.transientSettings(
        ClusterHealthResponse response = client.cluster().health(request, RequestOptions.DEFAULT);
        }
import org.opensearch.cluster.health.ClusterHealthStatus;
                    }
                    @Override
        setupRemoteClusterConfig("local_cluster");
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                    }
import org.opensearch.common.Priority;
        {
                        // <1>
            request.indices("index1", "index2");
        assertThat(transientSettingsResponse.get(transientSettingKey), equalTo(transientSettingValue + ByteSizeUnit.BYTES.getSuffix()));
            ComponentTemplate componentTemplate = new ComponentTemplate(template, null, null);
            listener = new LatchedActionListener<>(listener, latch);
        {
            ActionListener<RemoteInfoResponse> listener =
 * KIND, either express or implied.  See the License for the
        // tag::health-request-master-timeout
        final CountDownLatch latch = new CountDownLatch(1);
            client.cluster().putComponentTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
            AliasMetadata twitterAlias = AliasMetadata.builder("twitter_alias").build();
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        ClusterHealthRequest request = new ClusterHealthRequest();
            // end::put-component-template-execute-async
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // end::remote-info-execute-listener
        {
        request.clusterManagerNodeTimeout("1m"); // <2>
        ActionListener<GetComponentTemplatesResponse> listener =
            int activePrimaryShards = index.getActivePrimaryShards();
            int relocating = shardHealth.getRelocatingShards();
import static org.hamcrest.Matchers.is;
import java.util.HashMap;
                .put(persistentSettingKey, persistentSettingValue)
        // tag::get-settings-execute-async
                @Override
        // tag::put-settings-request-reset-transient
            int active = shardHealth.getActiveShards();
        // end::get-settings-request-local
        request.waitForActiveShards(ActiveShardCount.ALL); // <1>
        request.waitForNoInitializingShards(true); // <1>
                public void onFailure(Exception e) {
            // tag::put-settings-settings-source
            int initializingShards = index.getInitializingShards();
        // end::get-settings-request-includeDefaults
        String persistentSettingValue =
        RemoteInfoResponse response = client.cluster().remoteInfo(request, RequestOptions.DEFAULT); // <1>
                Settings.builder()
            new ActionListener<AcknowledgedResponse>() {
        request.persistentSettings(Settings.builder().putNull(persistentSettingKey));
        // tag::put-settings-request-reset-transient
        client.cluster().getSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>
        {
            Template template = new Template(settings, new CompressedXContent(mappingJson), aliases);
        request.local(true); // <1>
        {
        final CountDownLatch latch = new CountDownLatch(1);
            int unassignedShards = index.getUnassignedShards();
/*
import org.opensearch.cluster.metadata.ComponentTemplate;
            int initializing = shardHealth.getInitializingShards();
        // end::health-response-nodes
    public void testGetComponentTemplates() throws Exception {
        request.waitForNodes("le(2)"); // <3>
            request.transientSettings(transientSettingsBuilder); // <1>
            // end::put-settings-settings-map
        // tag::remote-info-response
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
import org.opensearch.action.support.ActiveShardCount;
            Map<Integer, ClusterShardHealth> shards = index.getShards(); // <1>
            listener = new LatchedActionListener<>(listener, latch);
            request.create(false); // make test happy
        final CountDownLatch latch = new CountDownLatch(1);
        Settings transientSettingsResponse = response.getTransientSettings(); // <2>
        }
        // end::put-settings-request-masterTimeout
                public void onResponse(ClusterGetSettingsResponse response) {
                    }
        // end::health-request-wait-active
                        // <2>
import org.opensearch.common.unit.TimeValue;
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            // tag::put-component-template-response
        RestHighLevelClient client = highLevelClient();
            request.componentTemplate(new ComponentTemplate(template, null, null));
            };
        // end::put-settings-request
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        request.includeDefaults(true); // <1>
                }
    }
        // end::get-settings-execute
                    // <1>
        request.timeout("50s"); // <2>
            // end::put-component-template-response
    }
    }
            ActionListener<ClusterHealthResponse> listener =
            client.cluster().putComponentTemplate(putComponentTemplateRequest, RequestOptions.DEFAULT);
        // end::put-settings-create-settings
        // end::get-settings-request-masterTimeout
    public void testRemoteInfo() throws Exception {
                    @Override
 */
            boolean acknowledged = putComponentTemplateResponse.isAcknowledged(); // <1>
                };
        // end::delete-component-template-response
        {
            // tag::put-component-template-execute-listener
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
                "      \"type\": \"text\"\n" +
import org.opensearch.client.cluster.RemoteConnectionInfo;
                .build(); // <1>
        // tag::delete-component-template-execute-async
        // tag::remote-info-execute-listener
            // end::put-component-template-request-masterTimeout
        // tag::put-settings-request
                    // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // Replace the empty listener by a blocking listener in test
                    // <2>
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
import org.opensearch.client.RestHighLevelClient;
            assertTrue(client.cluster().putComponentTemplate(putComponentTemplateRequest, RequestOptions.DEFAULT).isAcknowledged());
                new ActionListener<RemoteInfoResponse>() {
                    new ActionListener<ClusterUpdateSettingsResponse>() {
        request.transientSettings(transientSettings); // <1>
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            ClusterHealthRequest request = new ClusterHealthRequest();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.indices.GetComponentTemplatesRequest;
        ClusterUpdateSettingsResponse response = client.cluster().putSettings(request, RequestOptions.DEFAULT);
                + "      \"type\": \"text\"\n"
        }
            // tag::health-response-shards
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::remote-info-execute
        {
    public void testClusterGetSettings() throws IOException {
 * GitHub history for details.
        ActionListener<AcknowledgedResponse> listener =
        RestHighLevelClient client = highLevelClient();
 * Unless required by applicable law or agreed to in writing,
        // tag::put-settings-create-settings
import org.opensearch.cluster.health.ClusterShardHealth;
                public void onFailure(Exception e) {
            int relocatingShards = response.getRelocatingShards(); // <3>
                EnableAllocationDecider.Allocation.NONE.name();
                    // <2>
        }
        // end::remote-info-request
        // tag::health-response-indices
