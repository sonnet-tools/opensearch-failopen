        assertThat(response, notNullValue());
    private static void assertYellowShard(int shardId, ClusterShardHealth shardHealth) {
        }  
        request.level(ClusterHealthRequest.Level.INDICES);
            .componentTemplate(componentTemplate);
        assertThat(response.getDefaultSettings().size(), greaterThan(0));
        Settings persistentSettings = Settings.builder().put(persistentSettingKey, persistentSettingValue).build();
        setRequest.transientSettings(transientSettings);  
        Settings persistentSettings = Settings.builder().put(persistentSettingKey, persistentSettingValue).build();  
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.RED));
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        createIndex("index2", Settings.EMPTY);  
        assertThat(sniffModeInfo.getMaxConnectionsPerCluster(), equalTo(connectionsPerCluster));
    }
            request,  
        assertThat(response.isTimedOut(), equalTo(false));
        SniffModeInfo sniffModeInfo = (SniffModeInfo) info.getModeInfo();
                assertYellowShard(entry.getKey(), entry.getValue());
            assertThat(indexHealth.getShards().size(), equalTo(1));  
            resetRequest,
 */  
        assertThat(indexHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
    }
        assertThat(response.isTimedOut(), equalTo(false));
        assertThat(response.getUnassignedShards(), equalTo(0));
import org.opensearch.cluster.metadata.AliasMetadata;  
        assertThat(response.status(), equalTo(RestStatus.REQUEST_TIMEOUT));  
        assertThat(indexHealth.getActiveShards(), equalTo(1));  
import org.opensearch.client.indices.GetComponentTemplatesResponse;
        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
 *
        assertAcked(setResponse);  
import org.opensearch.cluster.health.ClusterIndexHealth;
import java.util.Map;
        assertThat(response.getActivePrimaryShards(), equalTo(2));
        logger.info("Shard stats\n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards")).getEntity()));
public class ClusterClientIT extends OpenSearchRestHighLevelClientTestCase {
        settingsRequest.includeDefaults(true);
        Settings transientSettings = Settings.builder().put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES).build();
/*  
    public void testRemoteInfo() throws Exception {
        ClusterHealthRequest request = new ClusterHealthRequest("index");
    public void testClusterHealthGreen() throws IOException {
        request.timeout("5s");
import java.util.HashMap;
        assertThat(response.getInitializingShards(), equalTo(0));  
import java.util.List;  
            for (Map.Entry<Integer, ClusterShardHealth> entry : indexHealth.getShards().entrySet()) {
        assertThat(response, notNullValue());
        assertThat(response.getNumberOfNodes(), equalTo(1));
}  
        assertThat(response.getActivePrimaryShards(), equalTo(1));
        AcknowledgedResponse response = execute(  
        request.level(ClusterHealthRequest.Level.SHARDS);  
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
        );  
        }
        setRequest.persistentSettings(map);
        int value = 10;
import org.opensearch.indices.recovery.RecoverySettings;
        assertEquals(transientSettings, response.getTransientSettings());
        assertThat(response.isTimedOut(), equalTo(false));
        assertThat(indexHealth.getRelocatingShards(), equalTo(0));
        assertYellowIndex(index.getKey(), index.getValue(), false);
        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        );  
        assertThat(response.getUnassignedShards(), equalTo(2));
        assertThat(response.status(), equalTo(RestStatus.OK));  
        response = execute(
        assertThat(resetResponse.getPersistentSettings(), equalTo(Settings.EMPTY));  
        if (randomBoolean()) {
import org.opensearch.cluster.health.ClusterHealthStatus;  
    }
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
            highLevelClient().cluster()::getSettingsAsync  
        assertEquals(persistentSettings, response.getPersistentSettings());
        assertThat(response.status(), equalTo(RestStatus.OK));  
        ClusterHealthRequest request = new ClusterHealthRequest(firstIndex, secondIndex);
            () -> execute(
        ClusterHealthRequest request = new ClusterHealthRequest();  
            highLevelClient().cluster()::putSettingsAsync  
 * GitHub history for details.
            highLevelClient().cluster()::remoteInfo,
            setRequest,
            assertYellowIndex(entry.getKey(), entry.getValue(), true);
 * software distributed under the License is distributed on an
import org.opensearch.client.indices.GetComponentTemplatesRequest;  
            componentTemplatesExistRequest,  
 * compatible open source license.
        );
        assertThat(info.getInitialConnectionTimeoutString(), equalTo(initialConnectionTimeout.toString()));  
 * license agreements. See the NOTICE file distributed with
            highLevelClient().cluster()::getComponentTemplate,
        }
        createIndex("index", Settings.EMPTY);
            OpenSearchStatusException.class,  
        clusterUpdateSettings(persistentSettings, transientSettings);
        assertThat(shardHealth, notNullValue());
        assertThat(response.getDelayedUnassignedShards(), equalTo(0));
import org.opensearch.OpenSearchException;  
        );
    }  
import static org.hamcrest.Matchers.nullValue;
        ClusterUpdateSettingsResponse resetResponse = execute(  
            highLevelClient().cluster()::existsComponentTemplate,  
        clusterUpdateSettingsRequest.transientSettings(Settings.builder().put(setting, value).build());
        final int transientSettingValue = 10;  
import org.opensearch.common.compress.CompressedXContent;
 * specific language governing permissions and limitations
        assertThat(response.isAcknowledged(), equalTo(true));  
        Map<String, Object> setMap = getAsMap("/_cluster/settings");
import org.opensearch.client.cluster.RemoteConnectionInfo;  
        createIndex("index", Settings.EMPTY);  
        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            highLevelClient().cluster()::putSettings,
        String templateName = "my-template";
            highLevelClient().cluster()::remoteInfoAsync
        assertTrue(exist);
        assertThat(response.getInitializingShards(), equalTo(0));
            settingsResponse.getTransientSettings()
        String transientSetValue = (String) XContentMapValues.extractValue("transient." + transientSettingKey, setMap);  
        assertYellowShards(response);
        );
        resetRequest.transientSettings(Settings.builder().putNull(transientSettingKey));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            setResponse.getTransientSettings().get(transientSettingKey),
    public void testClusterHealthYellowSpecificIndex() throws IOException {
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;  
        OpenSearchStatusException statusException = expectThrows(
                highLevelClient().cluster()::putSettingsAsync
            highLevelClient().cluster()::putComponentTemplate,
import org.opensearch.client.cluster.RemoteInfoRequest;
        boolean skipUnavailable = RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getConcreteSettingForNamespace(clusterAlias)
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(response.getActivePrimaryShards(), equalTo(0));
        String secondIndex = "index2";
            highLevelClient().cluster()::getComponentTemplateAsync
        assertThat(getResponse.getComponentTemplates().get(templateName), equalTo(componentTemplate));
 * KIND, either express or implied.  See the License for the
        assertThat(response.getIndices(), equalTo(emptyMap()));  
        assertThat(response.getDelayedUnassignedShards(), equalTo(0));  
            () -> execute(
/*
 *  
            highLevelClient().cluster()::putSettings,
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();
        assertThat(indexHealth.getIndex(), equalTo(indexName));
        assertThat(indexHealth.getInitializingShards(), equalTo(0));
        );  
        assertThat(setResponse.getPersistentSettings().get(transientSettingKey), nullValue());
        assertThat(shardHealth.getRelocatingShards(), equalTo(0));
        request.timeout("5s");
        assertThat(statusException.status(), equalTo(RestStatus.NOT_FOUND));
        exist = execute(
        assertThat(indexHealth.getUnassignedShards(), equalTo(1));  
        assertThat(persistentSetValue, equalTo(persistentSettingValue));  
            request,
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
        } else {
        );  
        Settings transientSettings = Settings.builder().put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES).build();
            }  
    }  
    public void testComponentTemplates() throws Exception {
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
import static org.hamcrest.Matchers.notNullValue;
            .get(settingsResponse.getTransientSettings());
 * this file be licensed under the Apache-2.0 license or a
    public void testClusterUpdateSettingNonExistent() {  
    public void testClusterGetSettingsWithDefault() throws IOException {
            exception.getMessage(),
        assertThat(setResponse.getTransientSettings().get(persistentSettingKey), nullValue());
        ClusterGetSettingsResponse settingsResponse = highLevelClient().cluster().getSettings(settingsRequest, RequestOptions.DEFAULT);
        setupRemoteClusterConfig(clusterAlias);
        assertThat(indexHealth, notNullValue());  
            highLevelClient().cluster()::deleteComponentTemplateAsync
        );
        assertThat(response.getNumberOfDataNodes(), equalTo(1));
            )  
 *
            highLevelClient().cluster()::existsComponentTemplateAsync
        ClusterUpdateSettingsRequest setRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
        final int transientSettingValue = 10;
        String persistentResetValue = (String) XContentMapValues.extractValue("persistent." + persistentSettingKey, resetMap);
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
import org.opensearch.client.indices.PutComponentTemplateRequest;
 * You may obtain a copy of the License at  
import org.opensearch.client.cluster.RemoteInfoResponse;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            deleteComponentTemplateRequest,
        assertThat(response.getInitializingShards(), equalTo(0));
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
    public void testClusterGetSettings() throws IOException {  
import org.opensearch.core.rest.RestStatus;  
import org.opensearch.cluster.metadata.Template;
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
        assertThat(indexHealth.getNumberOfReplicas(), equalTo(1));
        assertThat(response.getActiveShards(), equalTo(2));
package org.opensearch.client;
        assertEquals(transientSettings, response.getTransientSettings());  
import org.opensearch.common.settings.Settings;
    public void testClusterHealthYellowIndicesLevel() throws IOException, ParseException {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.ComponentTemplate;
        assertThat(shardHealth.getShardId(), equalTo(shardId));  
        assertThat(setResponse.getPersistentSettings().get(persistentSettingKey), equalTo(persistentSettingValue));  
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));
        ClusterGetSettingsResponse response = execute(
        assertThat(response.getActiveShards(), equalTo(1));
        ClusterUpdateSettingsResponse setResponse = execute(  
        ClusterGetSettingsRequest settingsRequest = new ClusterGetSettingsRequest();  
        Settings transientSettings = Settings.builder().put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES).build();
import org.apache.hc.core5.http.io.entity.EntityUtils;
        TimeValue initialConnectionTimeout = RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING.get(
        GetComponentTemplatesResponse getResponse = execute(
    private static void assertYellowShards(ClusterHealthResponse response) {  
                getComponentTemplatesRequest,
    private static void assertYellowIndex(String indexName, ClusterIndexHealth indexHealth, boolean emptyShards) {
        assertEquals(0, response.getDefaultSettings().size());
            createIndex(ignoredIndex, Settings.EMPTY);  
    public void testClusterHealthNotFoundIndex() throws IOException {
import org.opensearch.cluster.health.ClusterShardHealth;
            highLevelClient().cluster()::putComponentTemplateAsync  
import org.opensearch.transport.SniffConnectionStrategy;
        createIndex(secondIndex, Settings.EMPTY);
                highLevelClient().cluster()::getComponentTemplate,  
        assertThat(response.getIndices().size(), equalTo(1));  
            assertThat(indexHealth.getShards().size(), equalTo(0));
 */
import org.apache.hc.core5.http.ParseException;
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);  
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest().includeDefaults(true);  
        assertThat(shardHealth.getInitializingShards(), equalTo(0));  
import static java.util.Collections.emptyMap;  
        assertThat(response.getIndices().size(), equalTo(2));  
        Map<String, Object> resetMap = getAsMap("/_cluster/settings");
        assertThat(response, notNullValue());
        ComponentTemplatesExistRequest componentTemplatesExistRequest = new ComponentTemplatesExistRequest(templateName);
            OpenSearchException.class,
        assertThat(transientSetValue, equalTo(transientSettingValue + ByteSizeUnit.BYTES.getSuffix()));
import java.util.Collections;
        assertThat(response.getUnassignedShards(), equalTo(1));
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"host_name\":{\"type\":\"keyword\"}}}");
        final int transientSettingValue = 10;
        );
        assertThat(info.isSkipUnavailable(), equalTo(skipUnavailable));
            highLevelClient().cluster()::existsComponentTemplateAsync
import org.opensearch.transport.RemoteClusterService;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.xcontent.support.XContentMapValues;
        // accidentally asserting on entire cluster state
        );
 * Unless required by applicable law or agreed to in writing,
        assertThat(getResponse.getComponentTemplates().containsKey(templateName), equalTo(true));  
        String persistentSetValue = (String) XContentMapValues.extractValue("persistent." + persistentSettingKey, setMap);
        assertThat(response.getNumberOfNodes(), equalTo(1));
        assertThat(getResponse.getComponentTemplates().size(), equalTo(1));
import java.io.IOException;  
        logger.info("Shard stats\n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards")).getEntity()));
        assertThat(response.getDelayedUnassignedShards(), equalTo(0));  
            request,
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(response.getIndices().size(), equalTo(0));  
        assertThat(response, notNullValue());
        RemoteInfoResponse response = execute(
            getComponentTemplatesRequest,  
            .get(settingsResponse.getTransientSettings());
        assertThat(sniffModeInfo.getNumNodesConnected(), equalTo(1));  
        assertThat(shardHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
    }
    }
        PutComponentTemplateRequest putComponentTemplateRequest = new PutComponentTemplateRequest().name(templateName)
        OpenSearchException exception = expectThrows(  
        assertThat(  
        Map<String, Object> map = new HashMap<>();
        assertThat(response.isTimedOut(), equalTo(true));
        assertThat(setResponse.getTransientSettings().get(transientSettingKey), notNullValue());
    }
            )
        List<String> seeds = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias)
        ClusterHealthRequest request = new ClusterHealthRequest("notexisted-index");  
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
                highLevelClient().cluster()::putSettings,
        request.timeout("5s");
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
            componentTemplatesExistRequest,
                clusterUpdateSettingsRequest,  
        assertThat(info.getClusterAlias(), equalTo(clusterAlias));
        String setting = "no_idea_what_you_are_talking_about";
        request.timeout("5s");
        assertThat(response.isAcknowledged(), equalTo(true));
        GetComponentTemplatesRequest getComponentTemplatesRequest = new GetComponentTemplatesRequest(templateName);
    }  
            highLevelClient().cluster()::existsComponentTemplate,
import static org.hamcrest.Matchers.equalTo;
        );
        assertThat(response.status(), equalTo(RestStatus.OK));  
 * ownership. Elasticsearch licenses this file to you under  
        DeleteComponentTemplateRequest deleteComponentTemplateRequest = new DeleteComponentTemplateRequest(templateName);  
                highLevelClient().cluster()::getComponentTemplateAsync
        assertThat(resetResponse.getTransientSettings(), equalTo(Settings.EMPTY));
    }
        clusterUpdateSettings(persistentSettings, transientSettings);  
        assertThat(info.getModeInfo().modeName(), equalTo(SniffModeInfo.NAME));
    }  
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();  
        assertThat(sniffModeInfo.getSeedNodes(), equalTo(seeds));
        ClusterHealthRequest request = new ClusterHealthRequest();
        assertNoIndices(response);
            equalTo(transientSettingValue + ByteSizeUnit.BYTES.getSuffix())
            highLevelClient().cluster()::deleteComponentTemplate,  
        // including another index that we do not assert on, to ensure that we are not  
        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
import static org.hamcrest.Matchers.greaterThan;  
        );  
        assertThat(shardHealth.getActiveShards(), equalTo(1));
        String ignoredIndex = "tasks";
    }  
            putComponentTemplateRequest,
    public void testClusterPutSettings() throws IOException {  
        assertEquals(persistentSettings, response.getPersistentSettings());  
        assertThat(  
        assertThat(resetResponse.getPersistentSettings().get(persistentSettingKey), equalTo(null));
        Map.Entry<String, ClusterIndexHealth> index = response.getIndices().entrySet().iterator().next();
            equalTo("OpenSearch exception [type=settings_exception, reason=transient setting [" + setting + "], not recognized]")
        assertThat(response.getInfos().size(), equalTo(1));  
        assertThat(setResponse.getPersistentSettings().get(persistentSettingKey), notNullValue());
        assertThat(response.getNumberOfDataNodes(), equalTo(1));  
        assertThat(indexHealth.getActivePrimaryShards(), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
    private static void assertNoIndices(ClusterHealthResponse response) {
        RemoteConnectionInfo info = response.getInfos().get(0);
        assertThat(transientResetValue, equalTo(null));
        assertThat(persistentResetValue, equalTo(null));  
        String transientResetValue = (String) XContentMapValues.extractValue("transient." + transientSettingKey, resetMap);  
        if (emptyShards) {  
    }
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.OpenSearchStatusException;
        );
        createIndex("index2", Settings.EMPTY);
        assertFalse(exist);
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
import org.opensearch.client.indices.ComponentTemplatesExistRequest;
        assertThat(response.getActiveShards(), equalTo(0));
        for (Map.Entry<String, ClusterIndexHealth> entry : response.getIndices().entrySet()) {
/*  
        assertThat(info.getModeInfo().isConnected(), equalTo(true));  
    }
            .create(true)  
        ClusterUpdateSettingsRequest clusterUpdateSettingsRequest = new ClusterUpdateSettingsRequest();  
        ClusterGetSettingsResponse response = execute(  
        assertThat(response.getNumberOfNodes(), equalTo(1));  
        boolean exist = execute(
        RemoteInfoRequest request = new RemoteInfoRequest();
        assertThat(response, notNullValue());
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        int connectionsPerCluster = SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER.get(settingsResponse.getTransientSettings());  
import org.opensearch.core.common.unit.ByteSizeUnit;
        );  
            highLevelClient().cluster()::getSettings,
        AliasMetadata alias = AliasMetadata.builder("alias").writeIndex(true).build();
        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        createIndex(firstIndex, Settings.EMPTY);  
            highLevelClient().cluster()::getSettings,  
            highLevelClient().cluster()::putSettingsAsync  
        createIndex("index", Settings.EMPTY);
        resetRequest.persistentSettings("{\"" + persistentSettingKey + "\": null }", MediaTypeRegistry.JSON);
        ClusterUpdateSettingsRequest resetRequest = new ClusterUpdateSettingsRequest();
    public void testClusterHealthYellowClusterLevel() throws IOException, ParseException {
        request.timeout("5s");  
        assertThat(response.getNumberOfDataNodes(), equalTo(1));  
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();
        );  
        assertThat(resetResponse.getTransientSettings().get(transientSettingKey), equalTo(null));  
            highLevelClient().cluster()::getSettingsAsync
        assertThat(shardHealth.getUnassignedShards(), equalTo(1));
        ComponentTemplate componentTemplate = new ComponentTemplate(template, 1L, new HashMap<>());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
        String clusterAlias = "local_cluster";  
import org.opensearch.client.cluster.SniffModeInfo;  
        String firstIndex = "index";
        map.put(persistentSettingKey, persistentSettingValue);  
 */  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
        Template template = new Template(settings, mappings, Collections.singletonMap("alias", alias));  
