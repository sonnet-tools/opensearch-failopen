/*  
    private static ClusterState stateWithRestores(RestoreInProgress.Entry... entries) {
    private static IndexMetadata backingIndex(String dataStreamName, int generation) {  
        assertEquals(0, ignoreSettings.length);
    }
        SnapshotId snapshotId = new SnapshotId("snapshotId", "123");
        assertTrue(e.getMessage().contains("does not have a [@timestamp] field mapped as a date type"));  
        assertEquals(original, updatedDataStreams.get(ds));  
            .put("node.attr.remote_publication.routing_table.repository", "routing-table-repo")  
        assertEquals(renamedDataStreamName, renamedDataStream.getName());
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            throw new AssertionError(e);
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.metadata.DataStream;  
        final List<RestoreInProgress.Entry> reported = new ArrayList<>();  
        RestoreSnapshotRequest request = new RestoreSnapshotRequest();
        List<Index> indices = Collections.singletonList(new Index(backingIndexName, "uuid"));
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        // Internal pattern can filter protected settings
        DataStream dataStream = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);  
        Metadata.Builder metadata = Metadata.builder().put(b1, false);
            restores.add(entry);
        String renamedBackingIndexName = DataStream.getDefaultBackingIndexName(renamedDataStreamName, 1);
            new String[] {},
 */
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;
        final RestoreInProgress.Builder restores = new RestoreInProgress.Builder();  
        Snapshot snapshot = new Snapshot("testRepo", snapshotId);
        assertEquals(Collections.singletonList(renamedIndex), renamedDataStream.getIndices());  
            return createBackingIndex(dataStreamName, generation).putMapping(generateMapping("@timestamp")).build();
import org.opensearch.core.index.Index;
        updatedDataStreams.put(ds, original);  
    // Tests for internal vs user ignore settings filter separation (PR #20494)  
    }
        Index updatedIndex = new Index(backingIndexName, "uuid2");
        assertArrayEquals(new String[] { "index.remote_store.*" }, ignoreSettings);
        }  
        assertEquals(List.of(b1.getIndex(), b2.getIndex()), result.getIndices());
        when(indexMetadata.getSettings()).thenReturn(settings);
    public void testUserIgnoreWorksForNonProtected() {
        String ds = "logs-missing";
    public void testPrefixNotChanged() {  
        when(indexMetadata.getSettings()).thenReturn(settings);
    }
        Settings nodeSettings = Settings.builder()
            .put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString())
/*
            RestoreService.getUserUnremovableSettings()  
        String ds = "logs-attach";
        String ds = "logs-attach";  
        assertArrayEquals(new String[] { "index.remote_store.*" }, ignoreSettings);  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
    public void testUpdateDataStreamRename() {
public class RestoreServiceTests extends OpenSearchTestCase {
        assertEquals(Collections.singletonList(renamedIndex), renamedDataStream.getIndices());
 * this file be licensed under the Apache-2.0 license or a
        Metadata.Builder metadata = Metadata.builder().put(b1, false);  
import org.opensearch.cluster.ClusterName;  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        );  
            new String[] { "index.custom.*" },  
import static org.mockito.Mockito.mock;
        }  
            new String[] { "index.remote_store.*" },
            .put("node.attr.remote_store.translog.repository", "translog-repo")
        assertFalse(filter.test("index.remote_store.enabled"));  
        final ClusterState after = stateWithRestores();
        // Two tasks for one restore, as when several cluster state updates see it finished before the cleanup runs.
            RestoreService.getUserUnremovableSettings()
        when(indexMetadata.getIndex()).thenReturn(renamedIndex);
        assertFalse(filter.test("index.custom.setting"));
        for (RestoreInProgress.Entry entry : entries) {
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;
        return ClusterState.builder(ClusterName.DEFAULT).putCustom(RestoreInProgress.TYPE, restores.build()).build();
    public void testIgnoreSettingsInternalOnRemoteDataCluster() {  
            List.of(
            .build();
        final RestoreInProgress.Entry finished = restoreEntry("finished", RestoreInProgress.State.SUCCESS);
        final ShardId shardId = new ShardId(new Index("index-" + uuid, uuid + "-index-uuid"), 0);
        assertTrue(updatedDataStreams.isEmpty());  
    public void testInternalIgnoreOverridesProtection() {
    }
        final ClusterState after = executor.execute(  
 * specific language governing permissions and limitations
    }
        when(metadata.get(eq(renamedBackingIndexName))).thenReturn(indexMetadata);
import org.opensearch.cluster.ClusterChangedEvent;
        Metadata.Builder metadata = Metadata.builder().put(b1, false).put(bad, false);
    public void testValidateReplicationTypeRestoreSettings_WhenSnapshotIsSegment_RestoreToDocument() {
            uuid,  
        String dataStreamName = "ds-000001";
 *
            SnapshotRestoreException.class,
import org.opensearch.test.OpenSearchTestCase;
import java.util.HashMap;  
        );
        Metadata.Builder metadata = mock(Metadata.Builder.class);
        // User cannot filter protected settings  
        SnapshotId snapshotId = new SnapshotId("snapshotId", "123");  
import java.util.ArrayList;
        final ClusterState before = stateWithRestores(restoreEntry("running", RestoreInProgress.State.STARTED));
    public void testAttachSkipsWhenStreamDoesNotExist() {  
        when(metadata.get(eq(backingIndexName))).thenReturn(indexMetadata);
        String[] ignoreSettings = RestoreService.getIgnoreSettingsInternal(Settings.EMPTY);  
    public void testAttachSkipsNonConventionAndNonMemberCases() {  
    public void testCleanupReportsNothingWhenNoRestoreWasRemoved() {
        } catch (IOException e) {  
            IllegalArgumentException.class,  
        DataStream dataStream = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
 * SPDX-License-Identifier: Apache-2.0
        } catch (IOException e) {
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        Index renamedIndex = new Index(renamedBackingIndexName, "uuid2");  
import static org.mockito.Mockito.eq;
            .put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString())  
import org.opensearch.cluster.RestoreInProgress;
            state,
        final RestoreService.CleanRestoreStateTaskExecutor executor = new RestoreService.CleanRestoreStateTaskExecutor(reported::add);  
    }  
import java.util.Collections;
 *
        assertEquals(Collections.singletonList(updatedIndex), updateDataStream.getIndices());
    private static RestoreInProgress.Entry restoreEntry(String uuid, RestoreInProgress.State state) {  
        final ClusterState after = ClusterState.builder(before).incrementVersion().build();  
import org.opensearch.cluster.ClusterState;
        String[] ignoreSettings = RestoreService.getIgnoreSettingsInternal(nodeSettings);
            .put("node.attr.remote_store.segment.repository", "segment-repo")  
import org.opensearch.common.settings.Settings;  
        updatedDataStreams.put(ds, new DataStream(ds, createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));  
        // A cluster with only remote cluster state/routing table publication enabled does not
 * Unless required by applicable law or agreed to in writing,
        IndexMetadata b1 = backingIndex(ds, 1);
        assertEquals(renamedDataStreamName, renamedDataStream.getName());
        String renamedDataStreamName = "data-stream-2";  
        String dataStreamName = "data-stream-1";
        assertNotNull(RestoreService.restoreInProgress(after, "running"));
        assertTrue(reported.isEmpty());  
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;  
 * Modifications Copyright OpenSearch Contributors. See
        ).resultingState;  
    }
    public void testAttachRejectsIndexWithoutTimestampMapping() {  
    }
    // Tests for internal ignore settings gating on remote data attributes
        Settings settings = Settings.builder()
        assertEquals(2L, result.getGeneration());  
    }  
            throw new AssertionError(e);
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);
    }
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);  
        var filter = RestoreService.createSettingsFilterPredicate(
 * Licensed to Elasticsearch under one or more contributor  
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.mockito.Mockito.when;  
            )
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
        var filter = RestoreService.createSettingsFilterPredicate(  
        String dataStreamName = "data-stream-1";
        );  
        String renamedBackingIndexName = DataStream.getDefaultBackingIndexName(renamedDataStreamName, 1);
        Settings nodeSettings = Settings.builder()
            .build();
    }  
    }
        Metadata.Builder metadata = mock(Metadata.Builder.class);  
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().renamePattern("data-stream-1").renameReplacement("data-stream-2");
import org.opensearch.indices.replication.common.ReplicationType;  
                new RestoreService.CleanRestoreStateTaskExecutor.Task("finished")
    }
        assertThrows(  
import org.opensearch.core.index.shard.ShardId;
        RestoreService.attachRestoredBackingIndices(Set.of(b2.getIndex().getName()), metadata, updatedDataStreams);
        assertEquals(List.of(finished), reported);
        executor.clusterStatePublished(new ClusterChangedEvent("test", after, before));
        );
            .build();
        final RestoreService.CleanRestoreStateTaskExecutor executor = new RestoreService.CleanRestoreStateTaskExecutor(reported::add);
        IndexMetadata b1 = backingIndex(ds, 1);
        DataStream renamedDataStream = RestoreService.updateDataStream(dataStream, metadata, request);
        // A cluster that stores index data remotely must preserve remote store index settings
            () -> RestoreService.attachRestoredBackingIndices(Set.of(bad.getIndex().getName()), metadata, updatedDataStreams)
    public void testCleanupReportsEachRemovedRestoreOnce() {
        assertNull(RestoreService.restoreInProgress(after, "finished"));  
        assertEquals(renamedDataStreamName, renamedDataStream.getName());
            bad = createBackingIndex(ds, 2).putMapping(generateMapping("@timestamp", "text")).build();  
        assertThrows(
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
            new String[] {},
            SnapshotRestoreException.class,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
        DataStream updateDataStream = RestoreService.updateDataStream(dataStream, metadata, request);
        String[] ignoreSettings = RestoreService.getIgnoreSettingsInternal(nodeSettings);  
        Settings settings = Settings.builder()  
        // User can filter non-protected settings
}  
    public void testValidateReplicationTypeRestoreSettings_WhenSnapshotIsDocument_RestoreToDocument() {  
        try {
            restoreEntry("running", RestoreInProgress.State.STARTED)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
 */  
        final List<RestoreInProgress.Entry> reported = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        Metadata.Builder metadata = mock(Metadata.Builder.class);
        }
        return new RestoreInProgress.Entry(
    }  
        IndexMetadata b2 = backingIndex(ds, 2);
 * not use this file except in compliance with the License.
        Metadata.Builder metadata = Metadata.builder().put(b1, false).put(b2, false);
            Map.of(shardId, new RestoreInProgress.ShardRestoreStatus("node", state.completed() ? state : RestoreInProgress.State.INIT))
            List.of(shardId.getIndexName()),  
import java.util.Map;
        // Stream is at generation 1; the restored gen-2 index is present in the builder but not yet a member.  
    }
        final RestoreInProgress.Entry running = restoreEntry("running", RestoreInProgress.State.STARTED);
            .build();  
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);  
            () -> RestoreService.validateReplicationTypeRestoreSettings(snapshot, ReplicationType.DOCUMENT.toString(), indexMetadata)  
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
package org.opensearch.snapshots;
        assertTrue(filter.test("index.number_of_replicas"));
        final RestoreService.CleanRestoreStateTaskExecutor executor = new RestoreService.CleanRestoreStateTaskExecutor(reported::add);  
        IndexMetadata b1 = backingIndex(ds, 1);
        var filter = RestoreService.createSettingsFilterPredicate(
        );
    }
            new String[] { "index.number_of_replicas" },
        // Restored index parses to a stream name, but no such stream exists on the target: skipped, no exception.
        // stream unchanged.  
        String renamedDataStreamName = "ds2-000001";
        executor.clusterStatePublished(new ClusterChangedEvent("test", after, before));
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
 * ownership. Elasticsearch licenses this file to you under  
        when(indexMetadata.getIndex()).thenReturn(renamedIndex);
    }
        IllegalArgumentException e = expectThrows(
    }
        DataStream result = updatedDataStreams.get(ds);
            restoreEntry("finished", RestoreInProgress.State.SUCCESS),  
        final ClusterState before = stateWithRestores(finished, running);  
import java.io.IOException;  
        assertTrue(reported.isEmpty());
        // A non-convention name (no matching stream) and an already-member index are both skipped, leaving the
        Index renamedIndex = new Index(renamedBackingIndexName, "uuid2");
 * compatible open source license.
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
        try {
        executor.clusterStatePublished(new ClusterChangedEvent("test", after, before));
        // A convention-named gen-2 index whose @timestamp is not a date type.  
        renamedDataStream = RestoreService.updateDataStream(dataStream, metadata, request);  
        DataStream dataStream = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
            .put("node.attr.remote_publication.state.repository", "cluster-state-repo")
        when(metadata.get(eq(renamedBackingIndexName))).thenReturn(indexMetadata);  
        // store index data remotely, so remote store index settings must still be stripped  
        when(indexMetadata.getIndex()).thenReturn(updatedIndex);  
    public void testUpdateDataStream() {
            RestoreService.getUserUnremovableSettings()
        // A cluster with no remote store attributes must strip remote store index settings on restore
 * software distributed under the License is distributed on an
        DataStream original = new DataStream(ds, createTimestampField("@timestamp"), List.of(b1.getIndex()), 1);
 * GitHub history for details.
        String ds = "logs-attach";
        );
 * this work for additional information regarding copyright
/*  
    public void testIgnoreSettingsInternalOnClusterWithoutRemoteAttributes() {
            new Snapshot("repo", new SnapshotId("snapshot", "snapshot-uuid")),
    }  
        List<Index> indices = Collections.singletonList(new Index(backingIndexName, "uuid"));
    public void testAttachRestoredBackingIndexAdvancesGeneration() {
 * under the License.  
        List<Index> indices = Collections.singletonList(new Index(backingIndexName, "uuid"));  
    }
import java.util.List;
        IndexMetadata bad;
                new RestoreService.CleanRestoreStateTaskExecutor.Task("finished"),  
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
        assertEquals(dataStreamName, updateDataStream.getName());  
        request = new RestoreSnapshotRequest().renamePattern("ds-000001").renameReplacement("ds2-000001");
            () -> RestoreService.validateReplicationTypeRestoreSettings(snapshot, ReplicationType.SEGMENT.toString(), indexMetadata)
        RestoreService.attachRestoredBackingIndices(Set.of("some-regular-index", b1.getIndex().getName()), metadata, updatedDataStreams);
        assertEquals(Collections.singletonList(renamedIndex), renamedDataStream.getIndices());  
    public void testUserIgnoreRespectsProtection() {  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        updatedDataStreams.put(ds, new DataStream(ds, createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));  
        final ClusterState before = stateWithRestores(
 *  
 */  
        RestoreService.attachRestoredBackingIndices(Set.of(b1.getIndex().getName()), metadata, updatedDataStreams);
import java.util.Set;  
        Snapshot snapshot = new Snapshot("testRepo", snapshotId);
        DataStream renamedDataStream = RestoreService.updateDataStream(dataStream, metadata, request);  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testIgnoreSettingsInternalOnRemotePublicationOnlyCluster() {
        final List<RestoreInProgress.Entry> reported = new ArrayList<>();
            before,
            new String[] {},  
    public void testCleanupDoesNotReportAnUnfinishedRestore() {
        IndexMetadata b1 = backingIndex(ds, 1);  
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().renamePattern("ds-").renameReplacement("ds2-");  
        );
        Map<String, DataStream> updatedDataStreams = new HashMap<>();
