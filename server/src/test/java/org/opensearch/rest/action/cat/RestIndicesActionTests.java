            if (indexHealth != null) {
                            break;
            action.getTableIterator(new String[0], indicesSettings),  
            assertNull(header(table, "system.description").attr.get("default"));
import org.opensearch.action.admin.indices.stats.CommonStats;  
        List<Table.Cell> headers = table.getHeaders();  
            assertNull(header(table, "system").attr.get("default"));  
        verifyNoInteractions(listener);
        org.opensearch.index.shard.IndexingStats indexingStats = mock(org.opensearch.index.shard.IndexingStats.class);  
 * You may obtain a copy of the License at  
                ClusterHealthStatus healthStatus = randomFrom(ClusterHealthStatus.values());
        mismatchedMetadata.put(SYSTEM_INDEX_NAME, IndexMetadata.builder(indicesMetadatas.get(SYSTEM_INDEX_NAME)).system(false).build());  
        assertNotNull(table);
    public void testBuildPaginatedTable() {
                    }
 *
        assertTrue(rawIdx != -1);  
            } else {
        final Table table = action.buildTable(  
            new FakeRestRequest(),
            indicesHealths,  
import org.opensearch.index.IndexSettings;
        assertFalse(indicesOptions.expandWildcardsHidden());
                            }
    }
        PageToken pageToken = new PageToken("foo", "indices");  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(headers.get(1).value, equalTo("status"));
        assertThat(rows.size(), equalTo(1));  
            final Table table = action.getTableWithHeader(  
        final Metadata.Builder metadata = Metadata.builder();
        final ClusterStateResponse response = new ClusterStateResponse(new ClusterName("test"), state, false);  
        long knownTs = 1710000000000L;  
 * not use this file except in compliance with the License.
import org.opensearch.action.support.IndicesOptions;  
            indicesHealths,
            if ("last_index_request_timestamp_string".equals(cell.value)) foundString = true;
        assertTableRows(table);  
            () -> action.prepareRequest(request, mock(NodeClient.class))
            indicesListAction.getTableIterator(indicesToBeQueried, indicesSettings),
                new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", system)).build()
import static org.hamcrest.Matchers.nullValue;  
            IndexMetadata.State indexState = randomBoolean() ? IndexMetadata.State.OPEN : IndexMetadata.State.CLOSE;
        final ActionListener<Table> listener = mock(ActionListener.class);
import static org.mockito.Mockito.verify;  
    private RestIndicesAction newAction(SystemIndices systemIndices) {  
                        case GREEN:  
            null  
    }
import org.opensearch.Version;
        verify(systemIndices).findMatchingDescriptor(SYSTEM_INDEX_NAME);  
            indicesHealths,
        assertEquals(1, rows.size());  
            ClusterIndexHealth indexHealth = indicesHealths.get(indexName);
        final RestIndicesAction action = newAction(systemIndices());
import org.opensearch.core.index.Index;
        for (final List<Table.Cell> row : rows) {
            action.getTableIterator(new String[0], indicesSettings),  
    private ResponseLimitSettings responseLimitSettings(int catIndicesLimit) {
import java.time.format.DateTimeParseException;
import org.opensearch.cluster.metadata.Metadata;  
        final Table table = action.buildTable(
            assertNull(row.get(descriptionColumn).value);
    @Before  
import java.util.Collections;
            indicesMetadatas,
 *
                                    .map(shardId -> TestShardRouting.newShardRouting(shardId, "nodeB", false, ShardRoutingState.STARTED))
 *  
    public void testSystemColumnsAreShownWhenFiltering() {
import static org.mockito.Mockito.when;  
            indicesSettings,
        return -1;  
        final List<Table.Cell> row = table.getRows()  
    }  
                    IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
import java.util.Locale;
                            break;
    }  
import org.opensearch.test.rest.FakeRestRequest;  
            null
        final RestIndicesAction action = newAction(systemIndices);
        for (Table.Cell cell : headers) {
 * specific language governing permissions and limitations
    }
        return new SystemIndices(Map.of("testplugin", List.of(new SystemIndexDescriptor(SYSTEM_INDEX_NAME, SYSTEM_INDEX_DESCRIPTION))));
        final RestIndicesAction action = newAction(systemIndicesWithoutTestDescriptor());
                                .map(shardId -> TestShardRouting.newShardRouting(shardId, "nodeA", true, ShardRoutingState.STARTED))  
        Map<String, IndexStats> testStats = new LinkedHashMap<>();
import org.opensearch.cluster.ClusterName;
        assertThat(table.getRows().size(), equalTo(indicesMetadatas.size() / 2));
    public void testBuildTableWithSystemFalseParam() {
                    .numberOfShards(numberOfShards)
import static org.mockito.Mockito.verifyNoMoreInteractions;
        assertTableRows(table);
                                .forEach(indexRoutingTable::addShard);
    public void testBuildTable() {
 * KIND, either express or implied.  See the License for the
        assertTrue(foundString);
        final ActionListener<Table> listener = mock(ActionListener.class);
            testStats,
                IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            pageToken
                        case RED:  
        assertNotNull(table.getPageToken());
    }
                    .creationDate(System.currentTimeMillis())  
        assertThat(table.getRows().size(), equalTo(indicesMetadatas.size()));  
        assertTableHeaders(table);  
        assertThat(rows.get(0).get(headerIndex(table, "system.description")).value, equalTo(SYSTEM_INDEX_DESCRIPTION));  
    private void assertTableHeaders(Table table) {
                                .map(shardId -> TestShardRouting.newShardRouting(shardId, "nodeA", true, ShardRoutingState.STARTED))  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return table.getHeaders().get(headerIndex(table, name));
public class RestIndicesActionTests extends OpenSearchTestCase {
            indexNames.add("index-" + i);  
            new FakeRestRequest(),
            indicesStats,
        when(indexingStats.getTotal()).thenReturn(stats);
    }
        for (String indexName : indexNames) {  
    }
    private static final String SYSTEM_INDEX_DESCRIPTION = "Example of a system index";
        assertEquals("false", header(table, "system.description").attr.get("default"));
            action.getTableIterator(new String[] { testIndex }, testSettings),
        final RestIndicesAction action = newAction(systemIndices());  
            action.getTableIterator(new String[0], indicesSettings),
        assertFalse(indicesOptions.expandWildcardsHidden());
        assertEquals("parameter [system] is not supported by the [_list/indices] API", exception.getMessage());
import org.opensearch.action.pagination.PageToken;
import static org.hamcrest.Matchers.equalTo;
 */
                        when(indexStats.getTotal()).thenReturn(new CommonStats());
                .put(IndexSettings.INDEX_SEARCH_THROTTLED.getKey(), randomBoolean())
            }  
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(  
                    .settings(indexSettings)
            indicesMetadatas,  
                return i;
        CommonStats commonStats = mock(CommonStats.class);
import org.opensearch.cluster.metadata.IndexMetadata;
                    .numberOfReplicas(numberOfReplicas)
    }
            Instant parsed = Instant.parse(timestampString);
                                    .forEach(indexRoutingTable::addShard);  
import org.opensearch.common.Table;
        assertThat(row.get(headerIndex(table, "system.description")).value, equalTo(SYSTEM_INDEX_DESCRIPTION));  
}
        final IllegalArgumentException exception = expectThrows(  
import static org.mockito.Mockito.mock;
                    .state(indexState)  
                .build();
        final int numIndices = randomIntBetween(3, 20);
        Map<String, ClusterIndexHealth> testHealths = new LinkedHashMap<>();  
import static org.mockito.Mockito.verifyNoInteractions;
            }
        assertTrue(action.validateRequestLimit(response, randomBoolean(), listener));
        );
        Map<String, IndexMetadata> testMetadatas = new LinkedHashMap<>();  
        int rawIdx = -1;  
                            break;
import org.opensearch.test.OpenSearchTestCase;
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "false")).build(),  
            indicesSettings,  
    }
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true")).build()
                                    .map(shardId -> TestShardRouting.newShardRouting(shardId, null, false, ShardRoutingState.UNASSIGNED))
    }
                    .build();
        assertThat(rows.get(0).get(headerIndex(table, "system")).value, equalTo(true));
    private SystemIndices systemIndices() {
            if (name.equals(table.getHeaders().get(i).value)) {
                            }
        assertEquals(headers.size() - 1, headerIndex(table, "system.description"));
                    indicesHealths.put(indexName, new ClusterIndexHealth(indexMetadata, indexRoutingTable.build()));  
        assertThat(headers.get(0).value, equalTo("health"));
        Table table = action.buildTable(
            indicesHealths,
        assertTrue(indicesOptions.expandWildcardsOpen());
        boolean foundString = false;
            indicesStats,  
 * Licensed to Elasticsearch under one or more contributor  
        final RestIndicesListAction action = new RestIndicesListAction(responseLimitSettings(), systemIndices());
 * license agreements. See the NOTICE file distributed with
                .build()
            assertThat(row.get(2).value, equalTo(indexName));
            null  
    private static final String SYSTEM_INDEX_NAME = ".system-index";
                            IntStream.range(0, numberOfShards)
        assertEquals(headers.size() - 2, headerIndex(table, "system"));
        }
            IndexStats indexStats = indicesStats.get(indexName);
        fail("missing table header [" + name + "]");
        assertEquals("false", header(table, "system").attr.get("default"));
                }
import org.opensearch.action.admin.indices.stats.IndexStats;
    public void testBuildTableWithSystemParam() {  
        final Table table = action.buildTable(
            new FakeRestRequest(),
    public void setup() {
            assertThat(row.get(systemColumn).value, equalTo(false));
    public void testLastIndexRequestTimestampColumns() {
        assertEquals(String.valueOf(knownTs), row.get(rawIdx).value.toString());
            indicesStats,
        assertTrue(action.responseParams().contains("system"));
        for (int i = 0; i < table.getHeaders().size(); i++) {  
        assertNotNull(table);
            action.getTableIterator(new String[0], indicesSettings),
        int strIdx = -1;
                assertThat(row.get(4).value, nullValue());
        List<Table.Cell> row = rows.get(0);
        indexNames.add(SYSTEM_INDEX_NAME);
                    }
        for (List<Table.Cell> row : table.getRows()) {  
 * under the License.  
            .orElseThrow();
 */  
            indicesStats,
        final FakeRestRequest request = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true"))  
            .stream()
import org.opensearch.core.index.shard.ShardId;
 * this work for additional information regarding copyright
    }  
    }  
/*
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "false")).build()
import org.opensearch.cluster.ClusterState;
    final Map<String, IndexStats> indicesStats = new LinkedHashMap<>();
        verify(listener).onFailure(any());  
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())  
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true")).build(),
            testIndex,  
        }
 * The OpenSearch Contributors require contributions made to  
                int numberOfReplicas = healthStatus == ClusterHealthStatus.YELLOW ? 1 : randomInt(1);  
            null
        }
        }
        List<List<Table.Cell>> rows = table.getRows();
        assertTrue(indicesOptions.expandWildcardsHidden());
    }  
        final RestIndicesAction action = new RestIndicesAction(responseLimitSettings(randomFrom(-1, 0)), systemIndices());
    }  
        final int descriptionColumn = headerIndex(table, "system.description");
                        case YELLOW:  
                if (frequently()) {
            }
    private SystemIndices systemIndicesWithoutTestDescriptor() {
                assertThat(row.get(5).value, equalTo(indexMetadata.getNumberOfReplicas()));  
import java.util.ArrayList;  
        );
import org.opensearch.core.action.ActionListener;  
        } catch (DateTimeParseException e) {
        }  
import java.util.LinkedHashMap;
package org.opensearch.rest.action.cat;
        final Table table = action.buildTable(
        }
        );
                    switch (randomFrom(ClusterHealthStatus.values())) {
    public void testDescriptorLookupSkipsNonDotIndices() {
    }  
import org.opensearch.rest.action.list.RestIndicesListAction;
    public void testSystemFalseDoesNotExpandHiddenIndicesByDefault() {
/*  
        for (int i = 0; i < numIndices; i++) {
                    if (frequently()) {
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        final List<List<Table.Cell>> rows = table.getRows();
            indicesSettings,  
        );
        String[] indicesToBeQueried = indicesList.subList(0, indicesMetadatas.size() / 2).toArray(new String[0]);
                assertThat(row.get(4).value, equalTo(indexMetadata.getNumberOfShards()));
import java.util.Map;
        List<String> indexNames = new ArrayList<>();  
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("h", "index,system")).build()
            if ("last_index_request_timestamp".equals(header.get(i).value)) rawIdx = i;  
import org.opensearch.indices.SystemIndices;  
            indicesHealths,
        verifyNoInteractions(state, listener);
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build(),  
        final RestIndicesAction action = newAction(systemIndices());
        final Table table = newAction(systemIndices()).getTableWithHeader(new FakeRestRequest());
            );
                int numberOfShards = randomIntBetween(1, 3);
import org.opensearch.common.settings.Settings;
        String testIndex = "test-index";
            } else if (indexStats != null) {
            null
        Map<String, Settings> testSettings = new LinkedHashMap<>();
            fail("Timestamp string is not a valid ISO-8601 date: " + timestampString);
    }
                                IntStream.range(0, numberOfShards)  
            indicesStats,  
        assertThat(table.getRows().size(), equalTo(indicesMetadatas.size() - 1));
    final Map<String, IndexMetadata> indicesMetadatas = new LinkedHashMap<>();
            indicesSettings,
        String timestampString = row.get(strIdx).value.toString();  
import org.opensearch.cluster.routing.IndexRoutingTable;
        return new RestIndicesAction(responseLimitSettings(), systemIndices);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                                    .mapToObj(n -> new ShardId(index, n))
import org.junit.Before;
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true", "expand_wildcards", "open"))  
        );
        assertTrue(action.validateRequestLimit(response, true, listener));  
        assertFalse(indicesOptions.expandWildcardsHidden());
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(
            testMetadatas,  
            if ("last_index_request_timestamp_string".equals(header.get(i).value)) strIdx = i;
        );  
import java.util.stream.IntStream;  
                                .mapToObj(n -> new ShardId(index, n))
    private void assertTableRows(Table table) {
            .findFirst()  
    final Map<String, Settings> indicesSettings = new LinkedHashMap<>();
            mismatchedMetadata,
                            IntStream.range(0, numberOfShards)
            testHealths,
            indicesSettings,
                                IntStream.range(0, numberOfShards)  
    }
            indicesMetadatas,  
            IndexMetadata indexMetadata = indicesMetadatas.get(indexName);  
        assertFalse(RestIndicesAction.getIndicesOptions(new FakeRestRequest()).expandWildcardsHidden());
            indicesSettings,
 * software distributed under the License is distributed on an
    }
        final RestIndicesAction action = new RestIndicesAction(responseLimitSettings(1), systemIndices());
        }  
        assertThat(headers.get(5).value, equalTo("rep"));  
    private Table.Cell header(Table table, String name) {  
            .put(ResponseLimitSettings.CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), catIndicesLimit)
import org.opensearch.common.settings.ClusterSettings;
        return responseLimitSettings(-1);
import java.time.Instant;
        assertThat(headers.get(3).value, equalTo("uuid"));
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertThat(row.get(headerIndex(table, "system")).value, equalTo(false));
        assertTableHeaders(table);
        final RestIndicesAction action = newAction(systemIndices());
        assertThat(headers.get(2).value, equalTo("index"));  
    private ResponseLimitSettings responseLimitSettings() {
        );
        assertEquals(pageToken.getPaginatedEntity(), table.getPageToken().getPaginatedEntity());  
        testMetadatas.put(
        verifyNoMoreInteractions(systemIndices);
        }
            indicesStats,
            null
            .build();  
        when(indexStats.getPrimaries()).thenReturn(commonStats);  
 * SPDX-License-Identifier: Apache-2.0
    public void testSelectingSystemColumnDoesNotExpandHiddenIndices() {
    public void testSystemOmittedPreservesDefaultHiddenIndexExpansion() {
import org.opensearch.cluster.health.ClusterHealthStatus;  
        final ClusterState state = mock(ClusterState.class);
        return new SystemIndices(Collections.emptyMap());  
import org.opensearch.indices.SystemIndexDescriptor;
    private int headerIndex(Table table, String name) {
    }  
    public void testSystemTrueExpandsHiddenIndicesByDefault() {  
        for (List<Table.Cell> row : table.getRows()) {
                        when(indexStats.getPrimaries()).thenReturn(new CommonStats());
            Settings indexSettings = Settings.builder()
            IllegalArgumentException.class,
        boolean foundRaw = false;  
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "false")).build(),
        assertThat(rows.get(0).get(headerIndex(table, "index")).value, equalTo(SYSTEM_INDEX_NAME));
        );
            indicesMetadatas,
            IndexMetadata.builder(testIndex).settings(indexSettings).numberOfShards(1).numberOfReplicas(0).build()
                assertThat(row.get(0).value, equalTo(indexHealth.getStatus().toString().toLowerCase(Locale.ROOT)));  
        final SystemIndices systemIndices = mock(SystemIndices.class);  
    public void testExplicitExpandWildcardsOverridesSystemDefault() {
        testStats.put(testIndex, indexStats);  
        final Map<String, IndexMetadata> mismatchedMetadata = new LinkedHashMap<>(indicesMetadatas);
import org.opensearch.cluster.health.ClusterIndexHealth;
                            if (numberOfReplicas > 0) {
        List<Table.Cell> header = table.getHeaders();
        @SuppressWarnings("unchecked")  
                assertThat(row.get(0).value, equalTo("red*"));
        assertTrue(strIdx != -1);
        final Table table = action.buildTable(
        assertEquals(pageToken.getNextToken(), table.getPageToken().getNextToken());
            indicesSettings.put(indexName, indexSettings);  
                                    .forEach(indexRoutingTable::addShard);  
 * ownership. Elasticsearch licenses this file to you under  
        assertTableHeaders(table);
        indicesMetadatas.values().forEach(indexMetadata -> metadata.put(indexMetadata, false));  
            .build();
        );  
 * Modifications Copyright OpenSearch Contributors. See
                        indicesStats.put(indexName, indexStats);  
        );  
            assertNull(row.get(headerIndex(table, "system.description")).value);  
            action.getTableIterator(new String[0], indicesSettings),
import org.opensearch.common.UUIDs;
                    .system(SYSTEM_INDEX_NAME.equals(indexName))
        @SuppressWarnings("unchecked")
    }  
            }  
        when(commonStats.getIndexing()).thenReturn(indexingStats);
 * this file be licensed under the Apache-2.0 license or a
        final int systemColumn = headerIndex(table, "system");  
    }
        when(indexStats.getTotal()).thenReturn(commonStats);
import org.opensearch.cluster.routing.TestShardRouting;  
        try {
        final RestIndicesAction action = newAction(systemIndices());  
import org.opensearch.cluster.routing.ShardRoutingState;
        List<String> indicesList = new ArrayList<>(indicesMetadatas.keySet());
                assertThat(row.get(0).value, equalTo(""));
            testSettings,  
import static org.mockito.ArgumentMatchers.any;
            if ("last_index_request_timestamp".equals(cell.value)) foundRaw = true;  
            if (indexHealth != null) {
            .filter(candidate -> SYSTEM_INDEX_NAME.equals(candidate.get(headerIndex(table, "index")).value))
        assertThat(headers.get(4).value, equalTo("pri"));
        final RestIndicesAction action = newAction(systemIndices());
    public void testDisabledResponseLimitDoesNotInspectMetadata() {  
        final ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
    }
            final String indexName = (String) row.get(2).value;
    }
 * compatible open source license.
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(
            indicesHealths,  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        }
        when(stats.getMaxLastIndexRequestTimestamp()).thenReturn(knownTs);  
    }
        );  
import org.opensearch.common.breaker.ResponseLimitSettings;  
 */  
        for (String system : List.of("true", "false")) {
                assertThat(row.get(5).value, nullValue());  
                                .mapToObj(n -> new ShardId(index, n))
            assertThat(row.get(1).value, equalTo(indexMetadata.getState().toString().toLowerCase(Locale.ROOT)));
        Settings settings = Settings.builder()
                    Index index = indexMetadata.getIndex();  
        IndexStats indexStats = mock(IndexStats.class);
        );  
        final ClusterStateResponse response = new ClusterStateResponse(state.getClusterName(), state, false);
        }
        );
            if (frequently() || SYSTEM_INDEX_NAME.equals(indexName)) {  
        for (int i = 0; i < header.size(); i++) {
        return new ResponseLimitSettings(clusterSettings, settings);
        final List<List<Table.Cell>> rows = table.getRows();
                                .forEach(indexRoutingTable::addShard);
    final Map<String, ClusterIndexHealth> indicesHealths = new LinkedHashMap<>();  
        testSettings.put(testIndex, Settings.EMPTY);
            assertThat(row.get(3).value, equalTo(indexMetadata.getIndexUUID()));  
            } else {  
                        IndexStats indexStats = mock(IndexStats.class);  
    public void testSystemColumnsAreHiddenByDefault() {
                            if (numberOfReplicas > 0) {
        final RestIndicesListAction indicesListAction = new RestIndicesListAction(responseLimitSettings(), systemIndices());  
/*  
    public void testDescriptorDescriptionExposesMetadataMismatch() {  
            indicesMetadatas,
        assertFalse(action.validateRequestLimit(response, false, listener));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertTableHeaders(table);
        assertTrue(foundRaw);  
import java.util.List;  
 * Unless required by applicable law or agreed to in writing,
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(  
        final Table table = action.buildTable(  
                                    .mapToObj(n -> new ShardId(index, n))
 * GitHub history for details.
                indicesMetadatas.put(indexName, indexMetadata);  
    }
    public void testListIndicesRejectsSystemFilter() {
            assertEquals(knownTs, parsed.toEpochMilli());  
        org.opensearch.index.shard.IndexingStats.Stats stats = mock(org.opensearch.index.shard.IndexingStats.Stats.class);
    public void testResponseLimitCountsOnlyRequestedSystemClassification() {  
import org.opensearch.transport.client.node.NodeClient;
 * the Apache License, Version 2.0 (the "License"); you may
    }
