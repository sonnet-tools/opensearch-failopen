 * under the License.
/*
            RestoreService.getUserUnremovableSettings()
    public void testAttachSkipsWhenStreamDoesNotExist() {
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().renamePattern("ds-").renameReplacement("ds2-");
    public void testInternalIgnoreOverridesProtection() {
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
            SnapshotRestoreException.class,
    }
    public void testUserIgnoreWorksForNonProtected() {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
/*
        RestoreService.attachRestoredBackingIndices(Set.of(b2.getIndex().getName()), metadata, updatedDataStreams);
        // A cluster with only remote cluster state/routing table publication enabled does not
            throw new AssertionError(e);
        final List<RestoreInProgress.Entry> reported = new ArrayList<>();
            List.of(
            restores.add(entry);
 * software distributed under the License is distributed on an
        assertEquals(original, updatedDataStreams.get(ds));
        assertEquals(renamedDataStreamName, renamedDataStream.getName());
            restoreEntry("finished", RestoreInProgress.State.SUCCESS),
import org.opensearch.core.index.Index;
        String dataStreamName = "data-stream-1";
        DataStream renamedDataStream = RestoreService.updateDataStream(dataStream, metadata, request);
            new String[] { "index.remote_store.*" },
        Settings settings = Settings.builder()
        when(indexMetadata.getIndex()).thenReturn(renamedIndex);
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().renamePattern("data-stream-1").renameReplacement("data-stream-2");
            List.of(shardId.getIndexName()),
        assertEquals(renamedDataStreamName, renamedDataStream.getName());
    public void testIgnoreSettingsInternalOnRemoteDataCluster() {
    public void testCleanupReportsNothingWhenNoRestoreWasRemoved() {
 * GitHub history for details.
        Settings settings = Settings.builder()
    }
        assertTrue(e.getMessage().contains("does not have a [@timestamp] field mapped as a date type"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        String dataStreamName = "ds-000001";
        IndexMetadata bad;
import org.opensearch.cluster.ClusterChangedEvent;
        // A convention-named gen-2 index whose @timestamp is not a date type.
 */
        String ds = "logs-missing";
        when(indexMetadata.getIndex()).thenReturn(renamedIndex);
            new String[] { "index.custom.*" },
            state,
        );
        String[] ignoreSettings = RestoreService.getIgnoreSettingsInternal(nodeSettings);
        var filter = RestoreService.createSettingsFilterPredicate(
    public void testCleanupReportsEachRemovedRestoreOnce() {
        assertTrue(updatedDataStreams.isEmpty());
    }
        final RestoreService.CleanRestoreStateTaskExecutor executor = new RestoreService.CleanRestoreStateTaskExecutor(reported::add);
    // Tests for internal vs user ignore settings filter separation (PR #20494)
    }
            new String[] {},
            new String[] {},
        Index renamedIndex = new Index(renamedBackingIndexName, "uuid2");
        assertArrayEquals(new String[] { "index.remote_store.*" }, ignoreSettings);
        final RestoreInProgress.Entry finished = restoreEntry("finished", RestoreInProgress.State.SUCCESS);
        assertEquals(renamedDataStreamName, renamedDataStream.getName());
        // A cluster that stores index data remotely must preserve remote store index settings
    public void testUpdateDataStream() {
 */
    public void testValidateReplicationTypeRestoreSettings_WhenSnapshotIsDocument_RestoreToDocument() {
        assertTrue(reported.isEmpty());
        ).resultingState;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        Index renamedIndex = new Index(renamedBackingIndexName, "uuid2");
        String ds = "logs-attach";
    }
        RestoreService.attachRestoredBackingIndices(Set.of(b1.getIndex().getName()), metadata, updatedDataStreams);
            .build();
        updatedDataStreams.put(ds, new DataStream(ds, createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));
        final RestoreService.CleanRestoreStateTaskExecutor executor = new RestoreService.CleanRestoreStateTaskExecutor(reported::add);
            () -> RestoreService.validateReplicationTypeRestoreSettings(snapshot, ReplicationType.DOCUMENT.toString(), indexMetadata)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        executor.clusterStatePublished(new ClusterChangedEvent("test", after, before));
        when(indexMetadata.getSettings()).thenReturn(settings);
        try {
        when(metadata.get(eq(backingIndexName))).thenReturn(indexMetadata);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
            Map.of(shardId, new RestoreInProgress.ShardRestoreStatus("node", state.completed() ? state : RestoreInProgress.State.INIT))
 * Unless required by applicable law or agreed to in writing,
        when(metadata.get(eq(renamedBackingIndexName))).thenReturn(indexMetadata);
    public void testAttachRejectsIndexWithoutTimestampMapping() {
        String renamedBackingIndexName = DataStream.getDefaultBackingIndexName(renamedDataStreamName, 1);
    }
        final ShardId shardId = new ShardId(new Index("index-" + uuid, uuid + "-index-uuid"), 0);
            before,
        IndexMetadata b1 = backingIndex(ds, 1);
 * Modifications Copyright OpenSearch Contributors. See
/*
        var filter = RestoreService.createSettingsFilterPredicate(
        RestoreSnapshotRequest request = new RestoreSnapshotRequest();
        // A non-convention name (no matching stream) and an already-member index are both skipped, leaving the
 * KIND, either express or implied.  See the License for the
        executor.clusterStatePublished(new ClusterChangedEvent("test", after, before));
        IndexMetadata b2 = backingIndex(ds, 2);
        assertEquals(dataStreamName, updateDataStream.getName());
 *     http://www.apache.org/licenses/LICENSE-2.0
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
    // Tests for internal ignore settings gating on remote data attributes
        Metadata.Builder metadata = mock(Metadata.Builder.class);
        final ClusterState after = executor.execute(
        String[] ignoreSettings = RestoreService.getIgnoreSettingsInternal(nodeSettings);
 * not use this file except in compliance with the License.
import org.opensearch.cluster.ClusterName;
            )
    }
    public void testValidateReplicationTypeRestoreSettings_WhenSnapshotIsSegment_RestoreToDocument() {
        // stream unchanged.
        );
        final List<RestoreInProgress.Entry> reported = new ArrayList<>();
        Metadata.Builder metadata = mock(Metadata.Builder.class);
            new Snapshot("repo", new SnapshotId("snapshot", "snapshot-uuid")),
            .put("node.attr.remote_store.segment.repository", "segment-repo")
            RestoreService.getUserUnremovableSettings()
        // Restored index parses to a stream name, but no such stream exists on the target: skipped, no exception.
    }
 * compatible open source license.
import java.util.Collections;
import org.opensearch.cluster.ClusterState;
        try {
import org.opensearch.common.settings.Settings;
        Metadata.Builder metadata = Metadata.builder().put(b1, false).put(b2, false);
                new RestoreService.CleanRestoreStateTaskExecutor.Task("finished")
        updatedDataStreams.put(ds, new DataStream(ds, createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));
        var filter = RestoreService.createSettingsFilterPredicate(
        DataStream dataStream = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
        Snapshot snapshot = new Snapshot("testRepo", snapshotId);
        );
 *
    public void testUserIgnoreRespectsProtection() {
        List<Index> indices = Collections.singletonList(new Index(backingIndexName, "uuid"));
        // Internal pattern can filter protected settings
        }
            () -> RestoreService.attachRestoredBackingIndices(Set.of(bad.getIndex().getName()), metadata, updatedDataStreams)
        Index updatedIndex = new Index(backingIndexName, "uuid2");
        Settings nodeSettings = Settings.builder()
        }
        );
 * this file be licensed under the Apache-2.0 license or a
        final RestoreService.CleanRestoreStateTaskExecutor executor = new RestoreService.CleanRestoreStateTaskExecutor(reported::add);
import java.util.ArrayList;
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.mockito.Mockito.eq;
    private static RestoreInProgress.Entry restoreEntry(String uuid, RestoreInProgress.State state) {
            return createBackingIndex(dataStreamName, generation).putMapping(generateMapping("@timestamp")).build();
        assertFalse(filter.test("index.custom.setting"));
        assertNotNull(RestoreService.restoreInProgress(after, "running"));
        DataStream dataStream = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        String renamedBackingIndexName = DataStream.getDefaultBackingIndexName(renamedDataStreamName, 1);
        }
    }
        assertEquals(List.of(b1.getIndex(), b2.getIndex()), result.getIndices());
        DataStream updateDataStream = RestoreService.updateDataStream(dataStream, metadata, request);
        // A cluster with no remote store attributes must strip remote store index settings on restore
        assertArrayEquals(new String[] { "index.remote_store.*" }, ignoreSettings);
 */
        Metadata.Builder metadata = Metadata.builder().put(b1, false);
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
 * The OpenSearch Contributors require contributions made to
        IndexMetadata b1 = backingIndex(ds, 1);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
 *
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);
 * You may obtain a copy of the License at
        assertTrue(filter.test("index.number_of_replicas"));
    public void testIgnoreSettingsInternalOnRemotePublicationOnlyCluster() {
    public void testAttachSkipsNonConventionAndNonMemberCases() {
            () -> RestoreService.validateReplicationTypeRestoreSettings(snapshot, ReplicationType.SEGMENT.toString(), indexMetadata)
import org.opensearch.cluster.metadata.Metadata;
        return new RestoreInProgress.Entry(
    }
        RestoreService.attachRestoredBackingIndices(Set.of("some-regular-index", b1.getIndex().getName()), metadata, updatedDataStreams);
        assertThrows(
package org.opensearch.snapshots;
import static org.mockito.Mockito.when;
    }
        // User can filter non-protected settings
        SnapshotId snapshotId = new SnapshotId("snapshotId", "123");
    }
import java.util.Set;
            SnapshotRestoreException.class,
        DataStream result = updatedDataStreams.get(ds);
                new RestoreService.CleanRestoreStateTaskExecutor.Task("finished"),
        final ClusterState before = stateWithRestores(finished, running);
    private static IndexMetadata backingIndex(String dataStreamName, int generation) {
import java.util.List;
public class RestoreServiceTests extends OpenSearchTestCase {
        return ClusterState.builder(ClusterName.DEFAULT).putCustom(RestoreInProgress.TYPE, restores.build()).build();
            .put("node.attr.remote_publication.state.repository", "cluster-state-repo")
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
        } catch (IOException e) {
            .build();
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;
        String dataStreamName = "data-stream-1";
        renamedDataStream = RestoreService.updateDataStream(dataStream, metadata, request);
        assertEquals(2L, result.getGeneration());
            RestoreService.getUserUnremovableSettings()
            .build();
        String ds = "logs-attach";
        for (RestoreInProgress.Entry entry : entries) {
        );
        when(indexMetadata.getSettings()).thenReturn(settings);
        assertEquals(List.of(finished), reported);
    public void testCleanupDoesNotReportAnUnfinishedRestore() {
        String[] ignoreSettings = RestoreService.getIgnoreSettingsInternal(Settings.EMPTY);
        Snapshot snapshot = new Snapshot("testRepo", snapshotId);
        );
    }
        assertEquals(0, ignoreSettings.length);
        assertNull(RestoreService.restoreInProgress(after, "finished"));
            throw new AssertionError(e);
import org.opensearch.core.index.shard.ShardId;
        // store index data remotely, so remote store index settings must still be stripped
        when(metadata.get(eq(renamedBackingIndexName))).thenReturn(indexMetadata);
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
        final ClusterState before = stateWithRestores(restoreEntry("running", RestoreInProgress.State.STARTED));
            .put("node.attr.remote_publication.routing_table.repository", "routing-table-repo")
    public void testIgnoreSettingsInternalOnClusterWithoutRemoteAttributes() {
        final ClusterState after = ClusterState.builder(before).incrementVersion().build();
    }
    }
import java.util.HashMap;
        final ClusterState before = stateWithRestores(
        assertEquals(Collections.singletonList(renamedIndex), renamedDataStream.getIndices());
    public void testUpdateDataStreamRename() {
        executor.clusterStatePublished(new ClusterChangedEvent("test", after, before));
            .build();
        IllegalArgumentException e = expectThrows(
 * license agreements. See the NOTICE file distributed with
        assertTrue(reported.isEmpty());
        final List<RestoreInProgress.Entry> reported = new ArrayList<>();
        final ClusterState after = stateWithRestores();
        final RestoreInProgress.Builder restores = new RestoreInProgress.Builder();
            IllegalArgumentException.class,
import static org.mockito.Mockito.mock;
        // Two tasks for one restore, as when several cluster state updates see it finished before the cleanup runs.
            .put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString())
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);
        SnapshotId snapshotId = new SnapshotId("snapshotId", "123");
import org.opensearch.cluster.metadata.DataStream;
        String renamedDataStreamName = "data-stream-2";
        );
        } catch (IOException e) {
        String ds = "logs-attach";
        Metadata.Builder metadata = Metadata.builder().put(b1, false).put(bad, false);
    private static ClusterState stateWithRestores(RestoreInProgress.Entry... entries) {
        DataStream dataStream = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
        DataStream renamedDataStream = RestoreService.updateDataStream(dataStream, metadata, request);
        Metadata.Builder metadata = mock(Metadata.Builder.class);
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        Settings nodeSettings = Settings.builder()
import java.io.IOException;
        // User cannot filter protected settings
        updatedDataStreams.put(ds, original);
        String renamedDataStreamName = "ds2-000001";
    }
        assertThrows(
        DataStream original = new DataStream(ds, createTimestampField("@timestamp"), List.of(b1.getIndex()), 1);
        when(indexMetadata.getIndex()).thenReturn(updatedIndex);
    }
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);
import org.opensearch.test.OpenSearchTestCase;
 *
    public void testPrefixNotChanged() {
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            new String[] {},
            restoreEntry("running", RestoreInProgress.State.STARTED)
        Metadata.Builder metadata = Metadata.builder().put(b1, false);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
 * SPDX-License-Identifier: Apache-2.0
}
    }
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
        assertEquals(Collections.singletonList(renamedIndex), renamedDataStream.getIndices());
            .put("node.attr.remote_store.translog.repository", "translog-repo")
    public void testAttachRestoredBackingIndexAdvancesGeneration() {
        final RestoreInProgress.Entry running = restoreEntry("running", RestoreInProgress.State.STARTED);
        IndexMetadata b1 = backingIndex(ds, 1);
        // Stream is at generation 1; the restored gen-2 index is present in the builder but not yet a member.
        List<Index> indices = Collections.singletonList(new Index(backingIndexName, "uuid"));
    }
            new String[] { "index.number_of_replicas" },
import java.util.Map;
            uuid,
import org.opensearch.cluster.RestoreInProgress;
            bad = createBackingIndex(ds, 2).putMapping(generateMapping("@timestamp", "text")).build();
 * Licensed to Elasticsearch under one or more contributor
        );
        request = new RestoreSnapshotRequest().renamePattern("ds-000001").renameReplacement("ds2-000001");
import org.opensearch.indices.replication.common.ReplicationType;
        IndexMetadata b1 = backingIndex(ds, 1);
            .put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString())
        assertEquals(Collections.singletonList(renamedIndex), renamedDataStream.getIndices());
 * specific language governing permissions and limitations
        List<Index> indices = Collections.singletonList(new Index(backingIndexName, "uuid"));
        assertFalse(filter.test("index.remote_store.enabled"));
        assertEquals(Collections.singletonList(updatedIndex), updateDataStream.getIndices());
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
