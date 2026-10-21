                assertThat(row.get(4).value, nullValue());
/*
                assertThat(row.get(0).value, equalTo("red*"));
        when(indexStats.getTotal()).thenReturn(commonStats);
                IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "false")).build(),
    public void setup() {
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(
                new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", system)).build()
        Table table = action.buildTable(
        assertEquals("false", header(table, "system.description").attr.get("default"));
/*
 * specific language governing permissions and limitations
                    .system(SYSTEM_INDEX_NAME.equals(indexName))
    public void testListIndicesRejectsSystemFilter() {
        );
            .put(ResponseLimitSettings.CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), catIndicesLimit)
        assertEquals(pageToken.getNextToken(), table.getPageToken().getNextToken());
            indicesListAction.getTableIterator(indicesToBeQueried, indicesSettings),
 * this work for additional information regarding copyright
                    Index index = indexMetadata.getIndex();
 * not use this file except in compliance with the License.
                                    .mapToObj(n -> new ShardId(index, n))
        Map<String, IndexMetadata> testMetadatas = new LinkedHashMap<>();
import static org.mockito.ArgumentMatchers.any;
            action.getTableIterator(new String[] { testIndex }, testSettings),
    final Map<String, IndexMetadata> indicesMetadatas = new LinkedHashMap<>();
        return new RestIndicesAction(responseLimitSettings(), systemIndices);
    public void testSystemFalseDoesNotExpandHiddenIndicesByDefault() {
            }
    public void testSelectingSystemColumnDoesNotExpandHiddenIndices() {
                    indicesHealths.put(indexName, new ClusterIndexHealth(indexMetadata, indexRoutingTable.build()));
            if (indexHealth != null) {
        }
        assertThat(headers.get(5).value, equalTo("rep"));
 * KIND, either express or implied.  See the License for the
        final ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
            indicesHealths,
        assertThat(headers.get(4).value, equalTo("pri"));
            indicesSettings,
            action.getTableIterator(new String[0], indicesSettings),
        final RestIndicesAction action = newAction(systemIndicesWithoutTestDescriptor());
        final ClusterStateResponse response = new ClusterStateResponse(state.getClusterName(), state, false);
                    }
    }
            assertNull(header(table, "system.description").attr.get("default"));
        assertEquals(String.valueOf(knownTs), row.get(rawIdx).value.toString());
        @SuppressWarnings("unchecked")
    }
import java.time.format.DateTimeParseException;
        assertThat(row.get(headerIndex(table, "system.description")).value, equalTo(SYSTEM_INDEX_DESCRIPTION));
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                                    .mapToObj(n -> new ShardId(index, n))
                                .map(shardId -> TestShardRouting.newShardRouting(shardId, "nodeA", true, ShardRoutingState.STARTED))
            indicesSettings.put(indexName, indexSettings);
        assertThat(rows.get(0).get(headerIndex(table, "system.description")).value, equalTo(SYSTEM_INDEX_DESCRIPTION));
        List<Table.Cell> header = table.getHeaders();
        List<Table.Cell> row = rows.get(0);
            Settings indexSettings = Settings.builder()
        fail("missing table header [" + name + "]");
import org.opensearch.indices.SystemIndices;
                            break;
        final ActionListener<Table> listener = mock(ActionListener.class);
        final IllegalArgumentException exception = expectThrows(
        for (List<Table.Cell> row : table.getRows()) {
        final RestIndicesListAction action = new RestIndicesListAction(responseLimitSettings(), systemIndices());
            indicesSettings,
                                IntStream.range(0, numberOfShards)
                    .state(indexState)
import org.opensearch.common.settings.Settings;
        final RestIndicesAction action = newAction(systemIndices());
import org.opensearch.action.admin.indices.stats.IndexStats;
            IndexMetadata.State indexState = randomBoolean() ? IndexMetadata.State.OPEN : IndexMetadata.State.CLOSE;
                            }
    public void testBuildTable() {
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
        mismatchedMetadata.put(SYSTEM_INDEX_NAME, IndexMetadata.builder(indicesMetadatas.get(SYSTEM_INDEX_NAME)).system(false).build());
import java.util.LinkedHashMap;
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(
        final RestIndicesListAction indicesListAction = new RestIndicesListAction(responseLimitSettings(), systemIndices());
 * Unless required by applicable law or agreed to in writing,
                            break;
        final ClusterStateResponse response = new ClusterStateResponse(new ClusterName("test"), state, false);
            if ("last_index_request_timestamp".equals(cell.value)) foundRaw = true;
        testSettings.put(testIndex, Settings.EMPTY);
import static org.mockito.Mockito.mock;
        assertNotNull(table.getPageToken());
                                IntStream.range(0, numberOfShards)
            action.getTableIterator(new String[0], indicesSettings),
        );
    private int headerIndex(Table table, String name) {
                            if (numberOfReplicas > 0) {
            testStats,
 */
import org.opensearch.common.settings.ClusterSettings;
    }
    }
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.opensearch.rest.action.list.RestIndicesListAction;
            indicesStats,
            indicesHealths,
import org.opensearch.common.UUIDs;
            assertThat(row.get(1).value, equalTo(indexMetadata.getState().toString().toLowerCase(Locale.ROOT)));
        assertTrue(strIdx != -1);
    }
            indicesStats,
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(
import org.opensearch.cluster.health.ClusterIndexHealth;
        List<Table.Cell> headers = table.getHeaders();
            indicesHealths,
        );
        assertEquals(1, rows.size());
            indicesSettings,
    private void assertTableRows(Table table) {
 * GitHub history for details.
    }
                assertThat(row.get(5).value, nullValue());
            .filter(candidate -> SYSTEM_INDEX_NAME.equals(candidate.get(headerIndex(table, "index")).value))
import java.util.List;
        final RestIndicesAction action = newAction(systemIndices());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        assertThat(row.get(headerIndex(table, "system")).value, equalTo(false));
            .findFirst()
            indexNames.add("index-" + i);
        final Table table = newAction(systemIndices()).getTableWithHeader(new FakeRestRequest());
                        IndexStats indexStats = mock(IndexStats.class);
            indicesSettings,
import static org.mockito.Mockito.verify;
                assertThat(row.get(5).value, equalTo(indexMetadata.getNumberOfReplicas()));
    }
        }
    public void testDisabledResponseLimitDoesNotInspectMetadata() {
        final RestIndicesAction action = new RestIndicesAction(responseLimitSettings(1), systemIndices());
        );
            indicesStats,
        return new SystemIndices(Map.of("testplugin", List.of(new SystemIndexDescriptor(SYSTEM_INDEX_NAME, SYSTEM_INDEX_DESCRIPTION))));
        assertFalse(indicesOptions.expandWildcardsHidden());
        assertTrue(foundString);
    private Table.Cell header(Table table, String name) {
            mismatchedMetadata,
            indicesMetadatas,
            testSettings,
                        indicesStats.put(indexName, indexStats);
        testMetadatas.put(
    }
        assertEquals("false", header(table, "system").attr.get("default"));
    }
    private void assertTableHeaders(Table table) {
import org.opensearch.core.index.shard.ShardId;
        String testIndex = "test-index";
        @SuppressWarnings("unchecked")
        final RestIndicesAction action = newAction(systemIndices());
        assertFalse(RestIndicesAction.getIndicesOptions(new FakeRestRequest()).expandWildcardsHidden());
            () -> action.prepareRequest(request, mock(NodeClient.class))
    private SystemIndices systemIndices() {
    public void testResponseLimitCountsOnlyRequestedSystemClassification() {
            IndexMetadata.builder(testIndex).settings(indexSettings).numberOfShards(1).numberOfReplicas(0).build()
        final RestIndicesAction action = newAction(systemIndices());
    }
            indicesMetadatas,
            action.getTableIterator(new String[0], indicesSettings),
    private static final String SYSTEM_INDEX_DESCRIPTION = "Example of a system index";
        final RestIndicesAction action = new RestIndicesAction(responseLimitSettings(randomFrom(-1, 0)), systemIndices());
 * license agreements. See the NOTICE file distributed with
    private SystemIndices systemIndicesWithoutTestDescriptor() {
    public void testDescriptorDescriptionExposesMetadataMismatch() {
import java.util.Collections;
                    .numberOfShards(numberOfShards)
            } else {
            new FakeRestRequest(),
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true")).build(),
import org.opensearch.action.pagination.PageToken;
        final Table table = action.buildTable(
    }
        );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final FakeRestRequest request = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true"))
import static org.mockito.Mockito.verifyNoInteractions;
        assertTableRows(table);
        final Table table = action.buildTable(
        assertTableHeaders(table);
import org.opensearch.cluster.metadata.IndexMetadata;
        return new SystemIndices(Collections.emptyMap());
    public void testBuildTableWithSystemFalseParam() {
        return new ResponseLimitSettings(clusterSettings, settings);
                    .numberOfReplicas(numberOfReplicas)
        verifyNoMoreInteractions(systemIndices);
        when(commonStats.getIndexing()).thenReturn(indexingStats);
    public void testSystemTrueExpandsHiddenIndicesByDefault() {
                            }
            );
                                .map(shardId -> TestShardRouting.newShardRouting(shardId, "nodeA", true, ShardRoutingState.STARTED))
            indicesMetadatas,
import org.opensearch.core.index.Index;
            testIndex,
            assertNull(header(table, "system").attr.get("default"));
        }
        String timestampString = row.get(strIdx).value.toString();
        }
        final Metadata.Builder metadata = Metadata.builder();
 *
            action.getTableIterator(new String[0], indicesSettings),
    }
        assertFalse(indicesOptions.expandWildcardsHidden());
        final Table table = action.buildTable(
    public void testLastIndexRequestTimestampColumns() {
        Settings settings = Settings.builder()
            if (frequently() || SYSTEM_INDEX_NAME.equals(indexName)) {
import static org.mockito.Mockito.when;
                int numberOfShards = randomIntBetween(1, 3);
    }
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("h", "index,system")).build()
                    .settings(indexSettings)
                .build();
            } else if (indexStats != null) {
        assertEquals(headers.size() - 1, headerIndex(table, "system.description"));
        CommonStats commonStats = mock(CommonStats.class);
                                .forEach(indexRoutingTable::addShard);
            null
/*
            } else {
        final int systemColumn = headerIndex(table, "system");
                        when(indexStats.getPrimaries()).thenReturn(new CommonStats());
    }
            indicesSettings,
                    }
            indicesSettings,
        verify(systemIndices).findMatchingDescriptor(SYSTEM_INDEX_NAME);
        final List<Table.Cell> row = table.getRows()
            assertNull(row.get(headerIndex(table, "system.description")).value);
 * ownership. Elasticsearch licenses this file to you under
        assertThat(headers.get(1).value, equalTo("status"));
        when(stats.getMaxLastIndexRequestTimestamp()).thenReturn(knownTs);
        }
        org.opensearch.index.shard.IndexingStats indexingStats = mock(org.opensearch.index.shard.IndexingStats.class);
            assertThat(row.get(systemColumn).value, equalTo(false));
    public void testBuildTableWithSystemParam() {
import org.opensearch.cluster.ClusterName;
                                .mapToObj(n -> new ShardId(index, n))
        verifyNoInteractions(state, listener);
        for (int i = 0; i < table.getHeaders().size(); i++) {
        final SystemIndices systemIndices = mock(SystemIndices.class);
        final Table table = action.buildTable(
 *    http://www.apache.org/licenses/LICENSE-2.0
        final int numIndices = randomIntBetween(3, 20);
        }
                        case YELLOW:
import org.junit.Before;
            if (indexHealth != null) {
    private RestIndicesAction newAction(SystemIndices systemIndices) {
        assertTrue(indicesOptions.expandWildcardsOpen());
        );
    public void testExplicitExpandWildcardsOverridesSystemDefault() {
        indicesMetadatas.values().forEach(indexMetadata -> metadata.put(indexMetadata, false));
        final ActionListener<Table> listener = mock(ActionListener.class);
                        case GREEN:
            IllegalArgumentException.class,
            fail("Timestamp string is not a valid ISO-8601 date: " + timestampString);
        assertNotNull(table);
            IndexMetadata indexMetadata = indicesMetadatas.get(indexName);
        assertThat(table.getRows().size(), equalTo(indicesMetadatas.size() - 1));
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            IndexStats indexStats = indicesStats.get(indexName);
                .build()
                return i;
 * SPDX-License-Identifier: Apache-2.0
        assertTableRows(table);
    private ResponseLimitSettings responseLimitSettings() {
                assertThat(row.get(4).value, equalTo(indexMetadata.getNumberOfShards()));
        List<String> indicesList = new ArrayList<>(indicesMetadatas.keySet());
        assertTrue(action.responseParams().contains("system"));
 * You may obtain a copy of the License at
 *
        assertThat(rows.size(), equalTo(1));
        assertThat(rows.get(0).get(headerIndex(table, "system")).value, equalTo(true));
            ClusterIndexHealth indexHealth = indicesHealths.get(indexName);
                if (frequently()) {
            .stream()
            assertThat(row.get(3).value, equalTo(indexMetadata.getIndexUUID()));
import static org.hamcrest.Matchers.nullValue;
            .orElseThrow();
        try {
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build(),
        final int descriptionColumn = headerIndex(table, "system.description");
                indicesMetadatas.put(indexName, indexMetadata);
}
                    IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
        return responseLimitSettings(-1);
        org.opensearch.index.shard.IndexingStats.Stats stats = mock(org.opensearch.index.shard.IndexingStats.Stats.class);
    public void testBuildPaginatedTable() {
                                .forEach(indexRoutingTable::addShard);
    private ResponseLimitSettings responseLimitSettings(int catIndicesLimit) {
        for (int i = 0; i < header.size(); i++) {
    }
        }
        for (final List<Table.Cell> row : rows) {
    public void testDescriptorLookupSkipsNonDotIndices() {
        }
        final RestIndicesAction action = newAction(systemIndices());
import org.opensearch.cluster.health.ClusterHealthStatus;
    }
    public void testSystemColumnsAreShownWhenFiltering() {
 * the Apache License, Version 2.0 (the "License"); you may
                            if (numberOfReplicas > 0) {
import org.opensearch.common.Table;
        );
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "false")).build(),
    }
import java.time.Instant;
import org.opensearch.common.breaker.ResponseLimitSettings;
        assertThat(headers.get(0).value, equalTo("health"));
    final Map<String, IndexStats> indicesStats = new LinkedHashMap<>();
            if ("last_index_request_timestamp".equals(header.get(i).value)) rawIdx = i;
        assertFalse(indicesOptions.expandWildcardsHidden());
                            IntStream.range(0, numberOfShards)
    }
                assertThat(row.get(0).value, equalTo(""));
            null
 * software distributed under the License is distributed on an
            .build();
    }
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(pageToken.getPaginatedEntity(), table.getPageToken().getPaginatedEntity());
        for (String system : List.of("true", "false")) {
        assertFalse(action.validateRequestLimit(response, false, listener));
        assertEquals(headers.size() - 2, headerIndex(table, "system"));
        final Table table = action.buildTable(
            indicesMetadatas,
                int numberOfReplicas = healthStatus == ClusterHealthStatus.YELLOW ? 1 : randomInt(1);
import org.opensearch.cluster.routing.TestShardRouting;
            new FakeRestRequest(),
        final List<List<Table.Cell>> rows = table.getRows();
import java.util.Map;
        assertTrue(foundRaw);
                                .mapToObj(n -> new ShardId(index, n))
            null
            indicesHealths,
import java.util.Locale;
            new FakeRestRequest(),
    }
            testMetadatas,
import org.opensearch.action.admin.indices.stats.CommonStats;
        assertTrue(action.validateRequestLimit(response, true, listener));
            null
        final List<List<Table.Cell>> rows = table.getRows();
        );
import org.opensearch.cluster.metadata.Metadata;
            }
                assertThat(row.get(0).value, equalTo(indexHealth.getStatus().toString().toLowerCase(Locale.ROOT)));
                }
        assertTableHeaders(table);
                        case RED:
                                    .map(shardId -> TestShardRouting.newShardRouting(shardId, "nodeB", false, ShardRoutingState.STARTED))
import org.opensearch.index.IndexSettings;
        }
import org.opensearch.indices.SystemIndexDescriptor;
        assertThat(table.getRows().size(), equalTo(indicesMetadatas.size()));
        );
            indicesStats,
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(knownTs, parsed.toEpochMilli());
        boolean foundRaw = false;
        final Map<String, IndexMetadata> mismatchedMetadata = new LinkedHashMap<>(indicesMetadatas);
        Map<String, Settings> testSettings = new LinkedHashMap<>();
            pageToken
 */
            indicesHealths,
        Map<String, IndexStats> testStats = new LinkedHashMap<>();
            }
            null
    }
            indicesHealths,
        }
    final Map<String, ClusterIndexHealth> indicesHealths = new LinkedHashMap<>();
        String[] indicesToBeQueried = indicesList.subList(0, indicesMetadatas.size() / 2).toArray(new String[0]);
import java.util.stream.IntStream;
    @Before
                    switch (randomFrom(ClusterHealthStatus.values())) {
                                    .map(shardId -> TestShardRouting.newShardRouting(shardId, null, false, ShardRoutingState.UNASSIGNED))
        );
        assertThat(table.getRows().size(), equalTo(indicesMetadatas.size() / 2));
        int rawIdx = -1;
        final RestIndicesAction action = newAction(systemIndices);
        );
        assertTableHeaders(table);
            if ("last_index_request_timestamp_string".equals(cell.value)) foundString = true;
            null
    public void testSystemColumnsAreHiddenByDefault() {
        testStats.put(testIndex, indexStats);
    }
        for (List<Table.Cell> row : table.getRows()) {
                                    .forEach(indexRoutingTable::addShard);
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.ShardRoutingState;
            indicesMetadatas,
        assertTableHeaders(table);
        when(indexStats.getPrimaries()).thenReturn(commonStats);
            assertThat(row.get(2).value, equalTo(indexName));
        assertThat(headers.get(3).value, equalTo("uuid"));
        for (int i = 0; i < numIndices; i++) {
        final ClusterState state = mock(ClusterState.class);
        IndexStats indexStats = mock(IndexStats.class);
        List<String> indexNames = new ArrayList<>();
public class RestIndicesActionTests extends OpenSearchTestCase {
        List<List<Table.Cell>> rows = table.getRows();
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "false")).build()
        for (Table.Cell cell : headers) {
                        when(indexStats.getTotal()).thenReturn(new CommonStats());
                    .build();
            final Table table = action.getTableWithHeader(
                                    .forEach(indexRoutingTable::addShard);
import static org.hamcrest.Matchers.equalTo;
            assertNull(row.get(descriptionColumn).value);
            testHealths,
            if ("last_index_request_timestamp_string".equals(header.get(i).value)) strIdx = i;
        verifyNoInteractions(listener);
import org.opensearch.cluster.routing.IndexRoutingTable;
        );
                    .creationDate(System.currentTimeMillis())
 *
 * The OpenSearch Contributors require contributions made to
            final String indexName = (String) row.get(2).value;
import org.opensearch.Version;
 */
            action.getTableIterator(new String[0], indicesSettings),
import org.opensearch.action.support.IndicesOptions;
            .build();
        assertThat(rows.get(0).get(headerIndex(table, "index")).value, equalTo(SYSTEM_INDEX_NAME));
                            break;
    }
        final IndicesOptions indicesOptions = RestIndicesAction.getIndicesOptions(
        assertThat(headers.get(2).value, equalTo("index"));
import org.opensearch.transport.client.node.NodeClient;
        final RestIndicesAction action = newAction(systemIndices());
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals("parameter [system] is not supported by the [_list/indices] API", exception.getMessage());
        final Table table = action.buildTable(
            }
        verify(listener).onFailure(any());
                    if (frequently()) {
 * this file be licensed under the Apache-2.0 license or a
        PageToken pageToken = new PageToken("foo", "indices");
package org.opensearch.rest.action.cat;
        assertTrue(action.validateRequestLimit(response, randomBoolean(), listener));
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            if (name.equals(table.getHeaders().get(i).value)) {
    final Map<String, Settings> indicesSettings = new LinkedHashMap<>();
                .put(IndexSettings.INDEX_SEARCH_THROTTLED.getKey(), randomBoolean())
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true")).build()
        } catch (DateTimeParseException e) {
        indexNames.add(SYSTEM_INDEX_NAME);
                ClusterHealthStatus healthStatus = randomFrom(ClusterHealthStatus.values());
    private static final String SYSTEM_INDEX_NAME = ".system-index";
            indicesStats,
    public void testSystemOmittedPreservesDefaultHiddenIndexExpansion() {
                            IntStream.range(0, numberOfShards)
        return -1;
 * under the License.
        Map<String, ClusterIndexHealth> testHealths = new LinkedHashMap<>();
            new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(Map.of("system", "true", "expand_wildcards", "open"))
        assertTrue(rawIdx != -1);
        boolean foundString = false;
        when(indexingStats.getTotal()).thenReturn(stats);
            Instant parsed = Instant.parse(timestampString);
        for (String indexName : indexNames) {
    }
        assertTrue(indicesOptions.expandWildcardsHidden());
import java.util.ArrayList;
        long knownTs = 1710000000000L;
        assertNotNull(table);
    }
        );
        int strIdx = -1;
            indicesStats,
        return table.getHeaders().get(headerIndex(table, name));
