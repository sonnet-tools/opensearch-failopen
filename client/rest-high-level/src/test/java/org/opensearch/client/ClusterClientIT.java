    public void testClusterHealthNotFoundIndex() throws IOException {
        assertThat(shardHealth, notNullValue());
            deleteComponentTemplateRequest,
        assertThat(persistentResetValue, equalTo(null));
            highLevelClient().cluster()::existsComponentTemplate,
            highLevelClient().cluster()::getSettings,
        assertThat(sniffModeInfo.getNumNodesConnected(), equalTo(1));
        assertYellowShards(response);
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.RED));
        ClusterUpdateSettingsRequest resetRequest = new ClusterUpdateSettingsRequest();
        assertThat(indexHealth.getUnassignedShards(), equalTo(1));
            highLevelClient().cluster()::getSettings,
        SniffModeInfo sniffModeInfo = (SniffModeInfo) info.getModeInfo();
        assertThat(response.isTimedOut(), equalTo(true));
        assertThat(response.getNumberOfNodes(), equalTo(1));
        assertThat(response.getIndices().size(), equalTo(1));
        assertThat(setResponse.getTransientSettings().get(persistentSettingKey), nullValue());
        resetRequest.persistentSettings("{\"" + persistentSettingKey + "\": null }", MediaTypeRegistry.JSON);
            )
    public void testClusterPutSettings() throws IOException {
            assertThat(indexHealth.getShards().size(), equalTo(0));
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
        clusterUpdateSettings(persistentSettings, transientSettings);
 * Licensed to Elasticsearch under one or more contributor
        ClusterUpdateSettingsResponse setResponse = execute(
        request.level(ClusterHealthRequest.Level.SHARDS);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        assertThat(response.getActiveShards(), equalTo(0));
        assertTrue(exist);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            settingsResponse.getTransientSettings()
            setRequest,
}
            highLevelClient().cluster()::putSettings,
import org.opensearch.client.cluster.RemoteInfoRequest;
        assertThat(response.getUnassignedShards(), equalTo(0));
        assertThat(response.getNumberOfDataNodes(), equalTo(1));
import org.opensearch.client.indices.ComponentTemplatesExistRequest;
        assertThat(setResponse.getTransientSettings().get(transientSettingKey), notNullValue());
    }
    public void testClusterHealthYellowClusterLevel() throws IOException, ParseException {
    }
    }
        String ignoredIndex = "tasks";
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        response = execute(
import org.opensearch.client.cluster.RemoteConnectionInfo;
        ComponentTemplate componentTemplate = new ComponentTemplate(template, 1L, new HashMap<>());
import org.opensearch.OpenSearchException;
        request.level(ClusterHealthRequest.Level.INDICES);
        assertThat(response.status(), equalTo(RestStatus.OK));
        setRequest.transientSettings(transientSettings);
        resetRequest.transientSettings(Settings.builder().putNull(transientSettingKey));
        }
        assertThat(response.status(), equalTo(RestStatus.OK));
        );
    }
        createIndex("index", Settings.EMPTY);
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        logger.info("Shard stats\n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards")).getEntity()));
            request,
        createIndex("index", Settings.EMPTY);
        assertThat(response.status(), equalTo(RestStatus.OK));
import org.opensearch.client.indices.GetComponentTemplatesRequest;
import org.opensearch.common.xcontent.support.XContentMapValues;
        request.timeout("5s");
            componentTemplatesExistRequest,
 * the Apache License, Version 2.0 (the "License"); you may
            highLevelClient().cluster()::deleteComponentTemplateAsync
        settingsRequest.includeDefaults(true);
        String transientSetValue = (String) XContentMapValues.extractValue("transient." + transientSettingKey, setMap);
        assertYellowIndex(index.getKey(), index.getValue(), false);
        assertThat(persistentSetValue, equalTo(persistentSettingValue));
 * SPDX-License-Identifier: Apache-2.0
        ClusterUpdateSettingsRequest clusterUpdateSettingsRequest = new ClusterUpdateSettingsRequest();
        createIndex("index2", Settings.EMPTY);
        ClusterHealthRequest request = new ClusterHealthRequest("notexisted-index");
import static org.hamcrest.Matchers.notNullValue;
 */
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        int value = 10;
        assertThat(response.isAcknowledged(), equalTo(true));
        );
        assertThat(response.getActiveShards(), equalTo(1));
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
        setRequest.persistentSettings(map);
            request,
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        assertEquals(persistentSettings, response.getPersistentSettings());
        assertThat(response.getUnassignedShards(), equalTo(2));
        assertThat(response.getNumberOfNodes(), equalTo(1));
            highLevelClient().cluster()::getComponentTemplate,
import org.opensearch.client.indices.PutComponentTemplateRequest;
        assertThat(setResponse.getPersistentSettings().get(transientSettingKey), nullValue());
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        ClusterGetSettingsRequest settingsRequest = new ClusterGetSettingsRequest();
        assertThat(indexHealth.getNumberOfReplicas(), equalTo(1));
        assertThat(resetResponse.getPersistentSettings().get(persistentSettingKey), equalTo(null));
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();
import org.opensearch.OpenSearchStatusException;
        ClusterHealthRequest request = new ClusterHealthRequest();
        );
        assertThat(info.getModeInfo().isConnected(), equalTo(true));
        assertThat(indexHealth, notNullValue());
        assertThat(response.getIndices(), equalTo(emptyMap()));
        assertEquals(transientSettings, response.getTransientSettings());
        assertThat(indexHealth.getIndex(), equalTo(indexName));
                clusterUpdateSettingsRequest,
        assertThat(setResponse.getPersistentSettings().get(persistentSettingKey), equalTo(persistentSettingValue));
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest().includeDefaults(true);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        Template template = new Template(settings, mappings, Collections.singletonMap("alias", alias));
        assertThat(resetResponse.getPersistentSettings(), equalTo(Settings.EMPTY));
        ClusterHealthRequest request = new ClusterHealthRequest("index");
        );
        assertThat(statusException.status(), equalTo(RestStatus.NOT_FOUND));
    public void testComponentTemplates() throws Exception {
        } else {
import org.apache.hc.core5.http.io.entity.EntityUtils;
        createIndex("index2", Settings.EMPTY);
            .get(settingsResponse.getTransientSettings());
        }
        assertThat(response.getDelayedUnassignedShards(), equalTo(0));
        request.timeout("5s");
import java.util.Collections;
        assertThat(response.isTimedOut(), equalTo(false));
        assertThat(info.isSkipUnavailable(), equalTo(skipUnavailable));
        logger.info("Shard stats\n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards")).getEntity()));
        GetComponentTemplatesResponse getResponse = execute(
            }
        assertThat(shardHealth.getShardId(), equalTo(shardId));
        PutComponentTemplateRequest putComponentTemplateRequest = new PutComponentTemplateRequest().name(templateName)
        );
    public void testClusterGetSettings() throws IOException {
import org.apache.hc.core5.http.ParseException;
        ClusterGetSettingsResponse settingsResponse = highLevelClient().cluster().getSettings(settingsRequest, RequestOptions.DEFAULT);
    public void testClusterHealthYellowIndicesLevel() throws IOException, ParseException {
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"host_name\":{\"type\":\"keyword\"}}}");
 * Modifications Copyright OpenSearch Contributors. See
        String secondIndex = "index2";
    }
        createIndex(firstIndex, Settings.EMPTY);
        assertThat(resetResponse.getTransientSettings(), equalTo(Settings.EMPTY));
        assertThat(shardHealth.getUnassignedShards(), equalTo(1));
/*
    }
            highLevelClient().cluster()::getSettingsAsync
        ClusterHealthRequest request = new ClusterHealthRequest(firstIndex, secondIndex);
        assertThat(sniffModeInfo.getSeedNodes(), equalTo(seeds));
        Settings transientSettings = Settings.builder().put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES).build();
            highLevelClient().cluster()::getComponentTemplateAsync
import java.util.List;
        GetComponentTemplatesRequest getComponentTemplatesRequest = new GetComponentTemplatesRequest(templateName);
        clusterUpdateSettings(persistentSettings, transientSettings);
        Map.Entry<String, ClusterIndexHealth> index = response.getIndices().entrySet().iterator().next();
        );
        assertThat(shardHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        boolean exist = execute(
            equalTo(transientSettingValue + ByteSizeUnit.BYTES.getSuffix())
            assertThat(indexHealth.getShards().size(), equalTo(1));
        OpenSearchException exception = expectThrows(
 * GitHub history for details.
            )
        ClusterGetSettingsResponse response = execute(
            setResponse.getTransientSettings().get(transientSettingKey),
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * software distributed under the License is distributed on an
        RemoteInfoRequest request = new RemoteInfoRequest();
    public void testClusterHealthGreen() throws IOException {
import org.opensearch.common.unit.TimeValue;
    }
        Settings persistentSettings = Settings.builder().put(persistentSettingKey, persistentSettingValue).build();
        );
        ClusterUpdateSettingsResponse resetResponse = execute(
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
        clusterUpdateSettingsRequest.transientSettings(Settings.builder().put(setting, value).build());
                assertYellowShard(entry.getKey(), entry.getValue());
        assertThat(response.isTimedOut(), equalTo(false));
import org.opensearch.cluster.metadata.AliasMetadata;
            OpenSearchException.class,
            request,
 * compatible open source license.
 * under the License.
        );
        DeleteComponentTemplateRequest deleteComponentTemplateRequest = new DeleteComponentTemplateRequest(templateName);
        assertThat(
        boolean skipUnavailable = RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getConcreteSettingForNamespace(clusterAlias)
        assertThat(response.getActivePrimaryShards(), equalTo(1));
            highLevelClient().cluster()::remoteInfo,
        assertThat(indexHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        final int transientSettingValue = 10;
        assertThat(indexHealth.getInitializingShards(), equalTo(0));
        assertThat(getResponse.getComponentTemplates().containsKey(templateName), equalTo(true));
    }
            highLevelClient().cluster()::existsComponentTemplateAsync
        assertThat(response.getActivePrimaryShards(), equalTo(0));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getNumberOfDataNodes(), equalTo(1));
        );
        assertThat(indexHealth.getActiveShards(), equalTo(1));
 *
        assertThat(response.getNumberOfDataNodes(), equalTo(1));
        );
    }
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));
 * not use this file except in compliance with the License.
 *
        Map<String, Object> setMap = getAsMap("/_cluster/settings");
        createIndex(secondIndex, Settings.EMPTY);
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testClusterUpdateSettingNonExistent() {
    public void testClusterHealthYellowSpecificIndex() throws IOException {
import java.util.Map;
        assertThat(transientResetValue, equalTo(null));
        // including another index that we do not assert on, to ensure that we are not
        createIndex("index", Settings.EMPTY);
        assertAcked(setResponse);
import org.opensearch.common.settings.Settings;
        final int transientSettingValue = 10;
        assertThat(response.getIndices().size(), equalTo(2));
        ClusterHealthRequest request = new ClusterHealthRequest();
        assertThat(response.getInitializingShards(), equalTo(0));
        assertThat(indexHealth.getRelocatingShards(), equalTo(0));
            OpenSearchStatusException.class,
import static java.util.Collections.emptyMap;
        final int transientSettingValue = 10;
        map.put(persistentSettingKey, persistentSettingValue);
    public void testRemoteInfo() throws Exception {
            highLevelClient().cluster()::putSettingsAsync
 *
            highLevelClient().cluster()::putSettings,
        exist = execute(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
    private static void assertYellowShard(int shardId, ClusterShardHealth shardHealth) {
 * license agreements. See the NOTICE file distributed with
            .create(true)
 * Unless required by applicable law or agreed to in writing,
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
import org.opensearch.cluster.health.ClusterHealthStatus;
            highLevelClient().cluster()::putComponentTemplateAsync
import org.opensearch.transport.RemoteClusterService;
    private static void assertYellowIndex(String indexName, ClusterIndexHealth indexHealth, boolean emptyShards) {
        AliasMetadata alias = AliasMetadata.builder("alias").writeIndex(true).build();
        setupRemoteClusterConfig(clusterAlias);
        assertThat(response.getIndices().size(), equalTo(0));
        Settings transientSettings = Settings.builder().put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES).build();
import org.opensearch.cluster.metadata.ComponentTemplate;
        assertThat(response.getInitializingShards(), equalTo(0));
            for (Map.Entry<Integer, ClusterShardHealth> entry : indexHealth.getShards().entrySet()) {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        int connectionsPerCluster = SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER.get(settingsResponse.getTransientSettings());
        assertThat(transientSetValue, equalTo(transientSettingValue + ByteSizeUnit.BYTES.getSuffix()));
import org.opensearch.core.rest.RestStatus;
        request.timeout("5s");
        assertThat(indexHealth.getActivePrimaryShards(), equalTo(1));
        assertThat(response, notNullValue());
                highLevelClient().cluster()::getComponentTemplate,
        request.timeout("5s");
        assertThat(response.getInitializingShards(), equalTo(0));
import java.util.HashMap;
        List<String> seeds = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias)
package org.opensearch.client;
        request.timeout("5s");
        assertThat(response.getDefaultSettings().size(), greaterThan(0));
    }
    }
        String persistentSetValue = (String) XContentMapValues.extractValue("persistent." + persistentSettingKey, setMap);
        String templateName = "my-template";
 * You may obtain a copy of the License at
    }
        String firstIndex = "index";
            () -> execute(
    private static void assertYellowShards(ClusterHealthResponse response) {
        if (randomBoolean()) {
import org.opensearch.cluster.health.ClusterIndexHealth;
        assertThat(response, notNullValue());
        assertThat(info.getInitialConnectionTimeoutString(), equalTo(initialConnectionTimeout.toString()));
            componentTemplatesExistRequest,
public class ClusterClientIT extends OpenSearchRestHighLevelClientTestCase {
        assertThat(response.getDelayedUnassignedShards(), equalTo(0));
        );
        for (Map.Entry<String, ClusterIndexHealth> entry : response.getIndices().entrySet()) {
import org.opensearch.common.compress.CompressedXContent;
import org.opensearch.transport.SniffConnectionStrategy;
/*
import org.opensearch.cluster.health.ClusterShardHealth;
        assertThat(getResponse.getComponentTemplates().get(templateName), equalTo(componentTemplate));
import org.opensearch.client.indices.GetComponentTemplatesResponse;
        assertThat(response.getActivePrimaryShards(), equalTo(2));
        assertThat(response.isTimedOut(), equalTo(false));
        String setting = "no_idea_what_you_are_talking_about";
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();
            highLevelClient().cluster()::getSettingsAsync
        Map<String, Object> resetMap = getAsMap("/_cluster/settings");
            highLevelClient().cluster()::remoteInfoAsync
        AcknowledgedResponse response = execute(
        assertThat(getResponse.getComponentTemplates().size(), equalTo(1));
        }
            () -> execute(
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
        Settings persistentSettings = Settings.builder().put(persistentSettingKey, persistentSettingValue).build();
        assertThat(response.status(), equalTo(RestStatus.REQUEST_TIMEOUT));
import static org.hamcrest.Matchers.equalTo;
            putComponentTemplateRequest,
        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
            highLevelClient().cluster()::existsComponentTemplateAsync
        assertEquals(transientSettings, response.getTransientSettings());
 * KIND, either express or implied.  See the License for the
        assertThat(response, notNullValue());
import static org.hamcrest.Matchers.nullValue;
        RemoteConnectionInfo info = response.getInfos().get(0);
        assertEquals(persistentSettings, response.getPersistentSettings());
        assertThat(response.getActiveShards(), equalTo(2));
                highLevelClient().cluster()::putSettings,
        OpenSearchStatusException statusException = expectThrows(
        assertThat(response.isAcknowledged(), equalTo(true));
        );
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();
        ClusterGetSettingsResponse response = execute(
        String persistentResetValue = (String) XContentMapValues.extractValue("persistent." + persistentSettingKey, resetMap);
 * ownership. Elasticsearch licenses this file to you under
 */
                highLevelClient().cluster()::getComponentTemplateAsync
            assertYellowIndex(entry.getKey(), entry.getValue(), true);
        assertThat(shardHealth.getActiveShards(), equalTo(1));
        );
        assertThat(response, notNullValue());
        String clusterAlias = "local_cluster";
        Map<String, Object> map = new HashMap<>();
        Settings transientSettings = Settings.builder().put(transientSettingKey, transientSettingValue, ByteSizeUnit.BYTES).build();
                highLevelClient().cluster()::putSettingsAsync
        assertThat(info.getModeInfo().modeName(), equalTo(SniffModeInfo.NAME));
        ClusterUpdateSettingsRequest setRequest = new ClusterUpdateSettingsRequest();
        // accidentally asserting on entire cluster state
        TimeValue initialConnectionTimeout = RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING.get(
            equalTo("OpenSearch exception [type=settings_exception, reason=transient setting [" + setting + "], not recognized]")
/*
            .componentTemplate(componentTemplate);
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
        assertThat(response, notNullValue());
        );
        assertThat(response.getDelayedUnassignedShards(), equalTo(0));
        assertThat(shardHealth.getRelocatingShards(), equalTo(0));
        assertThat(response.getNumberOfNodes(), equalTo(1));
            highLevelClient().cluster()::putComponentTemplate,
        assertEquals(0, response.getDefaultSettings().size());
 * this file be licensed under the Apache-2.0 license or a
        ComponentTemplatesExistRequest componentTemplatesExistRequest = new ComponentTemplatesExistRequest(templateName);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import static org.hamcrest.Matchers.greaterThan;
        RemoteInfoResponse response = execute(
    public void testClusterGetSettingsWithDefault() throws IOException {
import org.opensearch.client.cluster.RemoteInfoResponse;
        ClusterHealthResponse response = execute(request, highLevelClient().cluster()::health, highLevelClient().cluster()::healthAsync);
    private static void assertNoIndices(ClusterHealthResponse response) {
        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
            highLevelClient().cluster()::deleteComponentTemplate,
        String transientResetValue = (String) XContentMapValues.extractValue("transient." + transientSettingKey, resetMap);
    }
 * The OpenSearch Contributors require contributions made to
        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
import org.opensearch.client.cluster.SniffModeInfo;
        assertThat(response.getUnassignedShards(), equalTo(1));
        assertThat(info.getClusterAlias(), equalTo(clusterAlias));
            highLevelClient().cluster()::existsComponentTemplate,
            .get(settingsResponse.getTransientSettings());
        assertThat(shardHealth.getInitializingShards(), equalTo(0));
            resetRequest,
        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
            getComponentTemplatesRequest,
            exception.getMessage(),
import org.opensearch.cluster.metadata.Template;
            highLevelClient().cluster()::putSettingsAsync
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();
        assertThat(resetResponse.getTransientSettings().get(transientSettingKey), equalTo(null));
                getComponentTemplatesRequest,
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertThat(
 * specific language governing permissions and limitations
        assertThat(setResponse.getPersistentSettings().get(persistentSettingKey), notNullValue());
        );
            createIndex(ignoredIndex, Settings.EMPTY);
        if (emptyShards) {
        assertFalse(exist);
    }
 * this work for additional information regarding copyright
        assertThat(response.getInfos().size(), equalTo(1));
import org.opensearch.indices.recovery.RecoverySettings;
        assertThat(sniffModeInfo.getMaxConnectionsPerCluster(), equalTo(connectionsPerCluster));
import java.io.IOException;
    }
        assertNoIndices(response);
