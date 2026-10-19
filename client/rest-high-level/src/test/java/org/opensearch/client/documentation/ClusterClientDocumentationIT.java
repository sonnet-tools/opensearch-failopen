 */  
            // end::health-request-indices-setter  
        // tag::put-settings-request-cluster-settings
        // tag::put-settings-request-reset-transient
 * Modifications Copyright OpenSearch Contributors. See
                }  
                .name("ct1");
                "      \"type\": \"text\"\n" +  
            // tag::health-response-shard-details  
        request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        // tag::delete-component-template-execute-listener  
        // tag::health-request-wait-active
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::delete-component-template-execute  
            // Replace the empty listener by a blocking listener in test  
            listener = new LatchedActionListener<>(listener, latch);
        // tag::put-settings-response
        // end::health-request-timeout
        // tag::health-request-wait-initializing
        }
import java.util.Map;
                new ActionListener<RemoteInfoResponse>() {
    public void testClusterUpdateSettingsAsync() throws Exception {
public class ClusterClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {  
            final CountDownLatch latch = new CountDownLatch(1);
        Map<String, ClusterIndexHealth> indices = response.getIndices(); // <1>
 *
        RemoteInfoResponse response = client.cluster().remoteInfo(request, RequestOptions.DEFAULT); // <1>
            int initializingShards = response.getInitializingShards(); // <4>  
import org.opensearch.action.support.ActiveShardCount;
                }
                        // <2>
            int delayedUnassignedShards = response.getDelayedUnassignedShards(); // <6>
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.client.cluster.RemoteConnectionInfo;
        assertTrue(latch.await(30L, TimeUnit.SECONDS));  
import java.util.HashMap;  
            boolean acknowledged = putComponentTemplateResponse.isAcknowledged(); // <1>  
        {
        }
                @Override  
        // tag::health-request-local
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
        assertThat(defaultSettings.size(), greaterThan(0));
            ClusterHealthRequest request = new ClusterHealthRequest("index1", "index2");
            Template template = new Template(settings, null, null);
import org.opensearch.client.indices.GetComponentTemplatesRequest;  
                    @Override  
        // tag::get-component-templates-execute
        }
        // end::health-execute
            client.cluster().putSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // tag::put-component-template-request-create  
        GetComponentTemplatesResponse getTemplatesResponse = client.cluster().getComponentTemplate(request, RequestOptions.DEFAULT);  
    }
import org.opensearch.client.indices.GetComponentTemplatesResponse;
        // end::health-response-request-status  
        listener = new LatchedActionListener<>(listener, latch);
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();  
        ActionListener<AcknowledgedResponse> listener =
        // tag::get-settings-execute-async
            int activeShards = response.getActiveShards(); // <1>  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::get-component-templates-execute-async
                public void onResponse(AcknowledgedResponse response) {
                .put(persistentSettingKey, persistentSettingValue)  
            Template template = new Template(settings, new CompressedXContent(mappingJson), aliases); // <2>
        int numberOfNodes = response.getNumberOfNodes(); // <1>  
                    public void onResponse(AcknowledgedResponse putComponentTemplateResponse) {
            // tag::health-execute-async
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            request.transientSettings(map); // <1>
            // end::put-component-template-request-version
        // tag::put-settings-request-masterTimeout
        DeleteComponentTemplateRequest deleteRequest = new DeleteComponentTemplateRequest("ct1"); // <1>
        request.local(true); // <1>
        // end::delete-component-template-execute-listener
        // tag::health-execute-async
        String persistentSettingKey =  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
import org.opensearch.client.cluster.RemoteInfoRequest;
        // end::health-execute-async  
        // tag::health-request-wait-events
 * SPDX-License-Identifier: Apache-2.0
            request.create(true);  // <1>
                    .put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES);
            request.indices("index1", "index2");
            new ActionListener<GetComponentTemplatesResponse>() {  
        // end::get-settings-request-local
        request.timeout("50s"); // <2>  
            ClusterShardHealth shardHealth = shards.get(0);
                + "  \"properties\": {\n"
            // end::put-settings-execute-listener
        assertThat(templates.size(), is(1));
        assertThat(templates.get("ct1"), is(notNullValue()));
                @Override  
                    public void onResponse(ClusterHealthResponse response) {
            int initializing = shardHealth.getInitializingShards();  
import org.opensearch.core.action.ActionListener;
                }
            client.cluster().remoteInfoAsync(request, RequestOptions.DEFAULT, listener); // <1>
            PutComponentTemplateRequest request = new PutComponentTemplateRequest().name("ct1");
/**
        }
        // tag::health-response-indices
        GetComponentTemplatesRequest request = new GetComponentTemplatesRequest("ct1"); // <1>  
    public void testClusterGetSettingsAsync() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
            // tag::health-execute-listener
        // tag::get-settings-request-includeDefaults
        boolean acknowledged = response.isAcknowledged(); // <1>
                Settings.builder()
        // tag::delete-component-template-request
                + "}";  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
                    @Override
        RestHighLevelClient client = highLevelClient();  
                    , MediaTypeRegistry.JSON); // <1>
            ClusterHealthRequest request = new ClusterHealthRequest();
        {  
        // end::remote-info-request
        client.cluster().getComponentTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>  
        final CountDownLatch latch = new CountDownLatch(1);
            client.cluster().putComponentTemplate(putComponentTemplateRequest, RequestOptions.DEFAULT);  
        // end::get-component-templates-request
            // end::put-settings-settings-source  
            // end::put-settings-execute-async  
                    public void onFailure(Exception e) {
 */  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
            };
 * Unless required by applicable law or agreed to in writing,
/*
            ClusterIndexHealth index = indices.get("index"); // <1>
            Map<String, Object> map = new HashMap<>();
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());  
        // end::health-response-task
        // tag::health-response-nodes
        deleteRequest.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>  
            assertTrue(acknowledged);
            ComponentTemplate componentTemplate = new ComponentTemplate(template, null, null);  
        {  
        RestHighLevelClient client = highLevelClient();
                + "    }\n"
                .build();
        }  
    public void testClusterGetSettings() throws IOException {
        ClusterHealthStatus status = response.getStatus(); // <2>  
                @Override  
            // end::health-request-indices-ctr  
            // end::put-settings-settings-map
import org.opensearch.core.xcontent.MediaTypeRegistry;
                .componentTemplate(componentTemplate);
                + "  }\n"
            assertTrue(client.cluster().putComponentTemplate(putComponentTemplateRequest, RequestOptions.DEFAULT).isAcknowledged());
        request.setClusterManagerNodeTimeout("1m"); // <2>
        Settings persistentSettingsResponse = response.getPersistentSettings(); // <3>
        assertThat(persistentSettingsResponse.get(persistentSettingKey), equalTo(persistentSettingValue));
                };
            listener = new LatchedActionListener<>(listener, latch);
            // end::health-execute-async
            ClusterHealthStatus shardStatus = shardHealth.getStatus();
import static org.hamcrest.Matchers.notNullValue;  
                    // <1>  
        // tag::get-component-templates-response  
                + "      \"type\": \"text\"\n"  
        Settings defaultSettings = response.getDefaultSettings(); // <3>
 *    http://www.apache.org/licenses/LICENSE-2.0
                new ActionListener<ClusterHealthResponse>() {  
                .put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES)  
            // end::health-execute-listener
 * specific language governing permissions and limitations
            Template template = new Template(settings, new CompressedXContent(mappingJson), aliases);
        {  
            // end::remote-info-execute-listener
import org.opensearch.core.rest.RestStatus;
            // end::put-component-template-request-masterTimeout  
                        // <1>  
                Settings.builder()
        setupRemoteClusterConfig("local_cluster");
        setupRemoteClusterConfig("local_cluster");
        int transientSettingValue = 10;  
        request.transientSettings(transientSettings); // <1>
            Map<Integer, ClusterShardHealth> shards = index.getShards(); // <1>
                public void onFailure(Exception e) {
        // end::health-request-wait-status
        // end::health-request-level
                    // <2>
            Settings settings = Settings.builder()
                @Override
                @Override
                + "    \"message\": {\n"
    @SuppressWarnings("unused")  
            request.componentTemplate(new ComponentTemplate(template, null, null));  
        listener = new LatchedActionListener<>(listener, latch);
        Settings transientSettings =
 * license agreements. See the NOTICE file distributed with
            String mappingJson = "{\n" +  
        assertThat(acknowledged, equalTo(true));
        client.cluster().deleteComponentTemplateAsync(deleteRequest, RequestOptions.DEFAULT, listener); // <1>
        RestHighLevelClient client = highLevelClient();  
    }  
        client.cluster().getSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>  
        // tag::get-component-templates-request
        request.waitForNoInitializingShards(true); // <1>
        request.waitForEvents(Priority.NORMAL); // <1>
        // end::delete-component-template-execute-async
                @Override  
            int relocatingShards = response.getRelocatingShards(); // <3>
        // tag::remote-info-request
        final CountDownLatch latch = new CountDownLatch(1);
        // end::get-settings-execute
        // tag::get-settings-execute  
        listener = new LatchedActionListener<>(listener, latch);  
        {  
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());  
        // end::health-response-indices  
        request.clusterManagerNodeTimeout("1m"); // <2>  
                public void onResponse(GetComponentTemplatesResponse response) {
        Settings transientSettings = response.getTransientSettings(); // <2>  
 * ownership. Elasticsearch licenses this file to you under  
        final CountDownLatch latch = new CountDownLatch(1);  
        request.clusterManagerNodeTimeout("1m"); // <2>  
            listener = new LatchedActionListener<>(listener, latch);  
 * Licensed to Elasticsearch under one or more contributor  
            ClusterHealthRequest request = new ClusterHealthRequest();  
        ClusterUpdateSettingsResponse response = client.cluster().putSettings(request, RequestOptions.DEFAULT);
        // end::put-settings-execute
        ClusterHealthRequest request = new ClusterHealthRequest();
        {
    }  
        request.waitForNoRelocatingShards(true); // <1>
        // end::put-settings-request-cluster-settings
        // tag::health-request-wait-relocation  
        assertThat(response.isTimedOut(), equalTo(false));  
        // tag::health-request-wait-nodes
        int numberOfPendingTasks = response.getNumberOfPendingTasks(); // <2>  
                    public void onFailure(Exception e) {  
            // tag::put-component-template-request-masterTimeout
            // tag::put-component-template-execute-async
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
        ClusterUpdateSettingsResponse resetResponse = client.cluster().putSettings(request, RequestOptions.DEFAULT);
        // end::get-component-templates-execute
        // end::health-request-wait-relocation
            // end::health-response-index
            int shardId = shardHealth.getShardId();  
                    @Override
            client.cluster().putComponentTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
        // tag::health-request-wait-status
        }  
 * Documentation for Cluster APIs in the high level java client.  
import java.io.IOException;
        // end::health-request-wait-active
                    // <2>
        request.includeDefaults(true); // <1>  
 * software distributed under the License is distributed on an
                    // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);  
                "  \"properties\": {\n" +
        request.waitForYellowStatus(); // <2>
 *
 *  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        assertTrue(resetResponse.isAcknowledged());
            PutComponentTemplateRequest request = new PutComponentTemplateRequest()
        // end::get-settings-request-includeDefaults
            // end::put-settings-settings-builder  
 */
            ClusterHealthStatus indexStatus = index.getStatus();
import org.opensearch.cluster.metadata.Template;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
            int numberOfReplicas = index.getNumberOfReplicas();
            };
                        // <2>
                .put("index.number_of_replicas", 3)
    }
        // end::get-component-templates-execute-async
            Settings settings = Settings.builder()  
        // end::get-settings-request  
            // tag::put-settings-execute-listener  
        // Replace the empty listener by a blocking listener in test
    public void testDeleteComponentTemplate() throws Exception {  
                    }  
        }
            Template template = new Template(settings, null, null);  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            // tag::put-settings-settings-builder
                .put("index.number_of_replicas", 1)
            ClusterHealthRequest request = new ClusterHealthRequest();
            double activeShardsPercent = response.getActiveShardsPercent(); // <7>  
            // tag::health-request
        }
import static org.hamcrest.Matchers.is;
            Settings settings = Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build();
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        RestStatus restStatus = response.status(); // <2>
        // end::delete-component-template-request-masterTimeout
        {
        // end::put-settings-request-timeout  
            aliases.put("twitter_alias", twitterAlias);  
                "    \"message\": {\n" +
            Map<String, AliasMetadata> aliases = new HashMap<>();
                }  
        // tag::get-settings-response
                @Override
            String mappingJson = "{\n"  
                    "{\"indices.recovery.max_bytes_per_sec\": \"10b\"}"
        // end::put-settings-create-settings
 * Code wrapped in {@code tag} and {@code end} tags is included in the docs.
        request.local(true); // <1>
        // tag::remote-info-response
import static org.hamcrest.Matchers.greaterThan;
        }
                }
import org.opensearch.cluster.metadata.ComponentTemplate;
            aliases.put("twitter_alias", twitterAlias);  
        RestHighLevelClient client = highLevelClient();
        ClusterGetSettingsResponse response = client.cluster().getSettings(request, RequestOptions.DEFAULT); // <1>
            // end::put-component-template-request
        Map<String, ComponentTemplate> templates = getTemplatesResponse.getComponentTemplates(); // <1>
                .put("index.number_of_shards", 3)  
        request.timeout("2m"); // <2>
        {
 */
        // end::health-response-nodes
            int relocating = shardHealth.getRelocatingShards();
                };
        request.level(ClusterHealthRequest.Level.SHARDS); // <1>  
        // Replace the empty listener by a blocking listener in test  
import org.opensearch.client.RestHighLevelClient;  
                    @Override  
        // tag::get-settings-request-local  
        // end::get-settings-request-masterTimeout
        request.persistentSettings(Settings.builder().putNull(persistentSettingKey));
            // end::health-response-shards
        // end::get-settings-execute-async
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
/*  
import org.opensearch.cluster.health.ClusterHealthStatus;  
            // end::put-component-template-execute-listener
            // tag::put-component-template-execute-listener
            // end::put-component-template-execute-async  
                public void onFailure(Exception e) {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.AliasMetadata;  
        assertThat(transientSettingsResponse.get(transientSettingKey), equalTo(transientSettingValue + ByteSizeUnit.BYTES.getSuffix()));
            // tag::put-component-template-request-execute
        // end::health-request-wait-nodes  
            // tag::put-settings-execute-async
        RestHighLevelClient client = highLevelClient();
        // end::health-request-local  
                .name("ct1"); // <1>  
            // end::health-response-shard-details
        // end::health-request-master-timeout  
        // tag::delete-component-template-response
import org.opensearch.client.indices.CreateIndexRequest;
            int relocatingShards = index.getRelocatingShards();
        {
        // end::delete-component-template-execute
                        // <1>  
    public void testRemoteInfoAsync() throws Exception {  
        // end::get-settings-response  
                    Settings.builder()  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        assertThat(infos.size(), greaterThan(0));  
            request.componentTemplate(new ComponentTemplate(template, null, null));  
        // tag::remote-info-execute
import org.opensearch.cluster.health.ClusterIndexHealth;
                @Override
        request.transientSettings(Settings.builder().putNull(transientSettingKey).build()); // <1>
        // tag::get-settings-request
        RemoteInfoRequest request = new RemoteInfoRequest();
        Settings transientSettingsResponse = response.getTransientSettings(); // <2>  
            Settings settings = Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build();  
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
 * compatible open source license.
        request.waitForNodes("2"); // <1>  
        // tag::get-settings-request-masterTimeout
            Map<String, AliasMetadata> aliases = new HashMap<>();
    public void testRemoteInfo() throws Exception {
import org.opensearch.common.unit.TimeValue;
        }
                    // <2>
        {
        {
            // tag::put-settings-settings-source
        request.waitForNodes(">=2"); // <2>
        }  
            Template template = new Template(Settings.builder().put("index.number_of_replicas", 3).build(), null, null);
                };  
            };  
                    }  
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        // tag::get-settings-execute-listener
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;  
        // tag::put-settings-request-reset-transient  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        // end::delete-component-template-response  
                "    }\n" +
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
                    // <1>
            int activePrimaryShards = response.getActivePrimaryShards(); // <2>
        // tag::put-settings-execute  
        // tag::health-execute
            int numberOfShards = index.getNumberOfShards();  
        RestHighLevelClient client = highLevelClient();
        // end::health-request-wait-events  
        ActionListener<GetComponentTemplatesResponse> listener =
        request.waitForNodes("le(2)"); // <3>
            int unassignedShards = index.getUnassignedShards();  
        TimeValue taskMaxWaitingTime = response.getTaskMaxWaitingTime(); // <1>
            map.put(transientSettingKey
        // tag::put-settings-request
        // end::put-settings-request
        // end::remote-info-response
    }
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        int numberOfInFlightFetch = response.getNumberOfInFlightFetch(); // <3>
            // Replace the empty listener by a blocking listener in test
            AliasMetadata twitterAlias = AliasMetadata.builder("twitter_alias").build();
            // end::put-component-template-response
                    new ActionListener<ClusterUpdateSettingsResponse>() {
        // tag::health-request-level
            int active = shardHealth.getActiveShards();
            // tag::health-response-index  
            AcknowledgedResponse putComponentTemplateResponse = client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT);
        RestHighLevelClient client = highLevelClient();  
 * this work for additional information regarding copyright
            final CountDownLatch latch = new CountDownLatch(1);
            ActionListener<ClusterHealthResponse> listener =
                new ActionListener<AcknowledgedResponse>() {  
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>
                EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
        {
        // tag::health-response-request-status  
        RestHighLevelClient client = highLevelClient();
            request.create(false); // make test happy
        String persistentSettingValue =
                public void onResponse(ClusterUpdateSettingsResponse response) {
        // Replace the empty listener by a blocking listener in test
        RestHighLevelClient client = highLevelClient();  
import org.opensearch.cluster.health.ClusterShardHealth;
        // tag::remote-info-execute-listener  
                    // <1>  
        // tag::remote-info-request  
        // tag::health-response-task
            int unassigned = shardHealth.getUnassignedShards();
            int activeShards = index.getActiveShards();
 * KIND, either express or implied.  See the License for the
            // tag::put-component-template-request-version  
            // tag::put-component-template-request
        // end::put-settings-request-masterTimeout
            ActionListener<ClusterUpdateSettingsResponse> listener =
        listener = new LatchedActionListener<>(listener, latch);  
                }  
                }  
                .build();
import org.opensearch.common.compress.CompressedXContent;
        }  
        request.clusterManagerNodeTimeout(TimeValue.timeValueSeconds(20)); // <1>
        String clusterName = response.getClusterName(); // <1>
        request.waitForActiveShards(ActiveShardCount.ALL); // <1>  
        boolean acknowledged = deleteTemplateAcknowledge.isAcknowledged(); // <1>
        // tag::delete-component-template-request-masterTimeout
            ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
            // end::put-component-template-request-create
        RestHighLevelClient client = highLevelClient();
            PutComponentTemplateRequest putComponentTemplateRequest = new PutComponentTemplateRequest().name("ct1")
                public void onFailure(Exception e) {  
                    @Override
import org.opensearch.client.cluster.RemoteInfoResponse;  
        // end::put-settings-response
    }
            client.cluster().healthAsync(request, RequestOptions.DEFAULT, listener); // <1>  
 * not use this file except in compliance with the License.
        // end::get-component-templates-execute-listener
            ActionListener<AcknowledgedResponse> listener =
            boolean primaryActive = shardHealth.isPrimaryActive();  
    @SuppressWarnings("unused")  
import java.util.concurrent.TimeUnit;
        // tag::get-component-templates-execute-listener
import org.opensearch.common.Priority;
            int initializingShards = index.getInitializingShards();
            PutComponentTemplateRequest request = new PutComponentTemplateRequest().name("ct1");  
                        // <2>
        request.timeout(TimeValue.timeValueSeconds(50)); // <1>
            Settings.Builder transientSettingsBuilder =
            assertTrue(client.cluster().putComponentTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // end::get-component-templates-response
        ActionListener<ClusterGetSettingsResponse> listener =
                public void onResponse(ClusterGetSettingsResponse response) {
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
                    @Override  
 * You may obtain a copy of the License at  
import org.opensearch.indices.recovery.RecoverySettings;  
        // tag::get-component-templates-request-masterTimeout  
                    }
    public void testClusterHealth() throws IOException {
    public void testClusterPutSettings() throws IOException {
        // tag::put-settings-create-settings  
import org.opensearch.common.settings.Settings;  
        String settingValue = response.getSetting("cluster.routing.allocation.enable"); // <4>
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                        // <1>
            request.transientSettings(transientSettingsBuilder); // <1>
            // tag::put-component-template-response
        RestHighLevelClient client = highLevelClient();  
        // tag::delete-component-template-execute-async  
        }
            request.componentTemplate(new ComponentTemplate(template, null, null));
        int numberOfDataNodes = response.getNumberOfDataNodes(); // <2>
                    }
                .build(); // <1>
        String transientSettingKey =
        }  
 * under the License.  
    }
import org.opensearch.action.LatchedActionListener;
                    , transientSettingValue + ByteSizeUnit.BYTES.getSuffix());  
        assertTrue(acknowledged);  
        // end::remote-info-execute  
        // tag::health-request-timeout
            int activePrimaryShards = index.getActivePrimaryShards();  
        assertThat(response.status(), equalTo(RestStatus.OK));
                    public void onResponse(RemoteInfoResponse response) {
        request.waitForStatus(ClusterHealthStatus.YELLOW); // <1>  
                "  }\n" +
                EnableAllocationDecider.Allocation.NONE.name();  
            AliasMetadata twitterAlias = AliasMetadata.builder("twitter_alias").build();
            PutComponentTemplateRequest request = new PutComponentTemplateRequest()
        Settings persistentSettings = response.getPersistentSettings(); // <1>
    }
    }
                RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
                    // <2>
        // tag::health-response-general
            final CountDownLatch latch = new CountDownLatch(1);
import java.util.List;
        request.persistentSettings(persistentSettings); // <2>  
/*  
        // end::remote-info-request
                    }
            // tag::health-response-shards
    }  
        request.waitForActiveShards(1); // <2>
            request.transientSettings(  
package org.opensearch.client.documentation;
            ActionListener<RemoteInfoResponse> listener =
        request.clusterManagerNodeTimeout("20s"); // <2>
            // end::health-request
        // end::get-component-templates-request-masterTimeout  
    public void testClusterHealthAsync() throws Exception {
            // tag::health-request-indices-ctr
        // end::get-settings-execute-listener
        Settings persistentSettings =
 * GitHub history for details.
            int unassignedShards = response.getUnassignedShards(); // <5>
        // tag::put-settings-request-timeout  
        {  
    }
                    }  
import org.opensearch.client.RequestOptions;
import org.opensearch.client.indices.PutComponentTemplateRequest;
            };  
            request.componentTemplate(new ComponentTemplate(template, 3L, null)); // <1>
                public void onFailure(Exception e) {  
    public void testPutComponentTemplate() throws Exception {  
    public void testGetComponentTemplates() throws Exception {
                }
        RemoteInfoRequest request = new RemoteInfoRequest();  
                "}";  
        {
        ClusterHealthResponse response = client.cluster().health(request, RequestOptions.DEFAULT);  
        // end::health-response-general
                .build(); // <2>
            // tag::put-settings-settings-map  
        assertThat(response, notNullValue());  
        AcknowledgedResponse deleteTemplateAcknowledge = client.cluster().deleteComponentTemplate(deleteRequest, RequestOptions.DEFAULT);
        List<RemoteConnectionInfo> infos = response.getInfos();  
                    public void onFailure(Exception e) {
        boolean timedOut = response.isTimedOut(); // <1>
}  
        // end::delete-component-template-request  
        {
        // end::health-request-wait-initializing  
            new ActionListener<AcknowledgedResponse>() {
            // tag::health-request-indices-setter  
            // end::put-component-template-request-execute  
        // tag::health-request-master-timeout  
            new ActionListener<ClusterGetSettingsResponse>() {  
import java.util.concurrent.CountDownLatch;  
