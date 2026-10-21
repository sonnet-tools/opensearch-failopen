        }
                when(sourceNode.getHostName()).thenReturn(randomAlphaOfLength(8));
        }
            when(state.getStage()).thenReturn(randomFrom(RecoveryState.Stage.values()));
            final List<Object> expectedValues = Arrays.asList(
                } else {
            when(state.getTranslog()).thenReturn(translog);
            final int completeFileSize = randomIntBetween(1, 1024);
        }
 * this file be licensed under the Apache-2.0 license or a
        final int totalShards = randomIntBetween(1, 32);
            "target_node",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final int translogOpsRecovered = randomIntBetween(0, translogOps);
            }
import static org.mockito.Mockito.when;
                percent(state.getIndex().recoveredFilesPercent()),
    private void addTestFileMetadata(ReplicationLuceneIndex index, int startIndex, int endIndex, boolean reused, boolean isFullyRecovered) {
            "bytes_percent",
                }
                new ByteSizeValue(state.getIndex().totalRecoverBytes()),
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
    public void testRestRecoveryAction() {
                    ? "n/a"
            when(state.getTimer()).thenReturn(timer);
            "bytes_total",
                "index",
            "translog_ops",
 * KIND, either express or implied.  See the License for the
import java.util.Map;
            if (!reused) {
        );
        final int successfulShards = Math.max(0, totalShards - randomIntBetween(1, 2));
 * GitHub history for details.
            when(state.getSourceNode()).thenReturn(sourceNode);
                percent(state.getTranslog().recoveredPercent())
            when(translog.recoveredPercent()).thenReturn(translogOps == 0 ? 100f : (100f * translogOpsRecovered / translogOps));
            index.addFileDetail(String.valueOf(i), completeFileSize, reused);
                state.getTranslog().totalOperations(),
            "start_time",
 * the Apache License, Version 2.0 (the "License"); you may
                    recoveredFileSize = randomIntBetween(0, completeFileSize);
 * compatible open source license.
            "time",
                state.getStage().name().toLowerCase(Locale.ROOT),
 */
            "translog_ops_recovered",
import static org.mockito.Mockito.mock;
import org.opensearch.core.common.unit.ByteSizeValue;
            assertThat(headers.get(i).value, equalTo(expectedHeaders.get(i)));
        addTestFileMetadata(index, filesToRecoverCount, totalFilesCount, true, false);
    private ReplicationLuceneIndex createTestIndex() {
 * license agreements. See the NOTICE file distributed with
                state.getTargetNode().getName(),
            }
        final RecoveryResponse response = new RecoveryResponse(
                final int recoveredFileSize;
        return index;
import org.opensearch.indices.recovery.RecoveryState;
        }
            "repository",
 * not use this file except in compliance with the License.
            );
 * software distributed under the License is distributed on an
        final Map<String, List<RecoveryState>> shardRecoveryStates = new HashMap<>();
            shardRecoveryStates,
                state.getIndex().recoveredFileCount(),
    }
                XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().startTime())),
 * under the License.
 */
import org.opensearch.cluster.routing.TestShardRouting;
                state.getSourceNode() == null ? "n/a" : state.getSourceNode().getName(),
 *
import org.opensearch.cluster.node.DiscoveryNode;
            }
                state.getIndex().totalFileCount(),
            "stage",
        final List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();
            final long time = randomLongBetween(1000000, 10 * 1000000);
                state.getIndex().totalRecoverFiles(),
            "stop_time_millis",
        final List<String> expectedHeaders = Arrays.asList(
            "index",
                new ByteSizeValue(state.getIndex().totalBytes()),
                if (isFullyRecovered) {
 * specific language governing permissions and limitations
        final int recoveredFilesCount = randomIntBetween(0, filesToRecoverCount);
        addTestFileMetadata(index, recoveredFilesCount, filesToRecoverCount, false, false);
        final Table table = action.buildRecoveryTable(null, response);
                state.getTargetNode().getHostName(),
            when(state.getRecoverySource()).thenReturn(TestShardRouting.randomRecoverySource());
            "stop_time",
            when(state.getTargetNode()).thenReturn(targetNode);
            "snapshot",
            when(timer.time()).thenReturn(time);
                new ByteSizeValue(state.getIndex().recoveredBytes()),
    }
                state.getTranslog().recoveredOperations(),
import org.opensearch.core.index.shard.ShardId;
        final RestCatRecoveryAction action = new RestCatRecoveryAction();
        for (int i = startIndex; i < endIndex; i++) {
import org.opensearch.test.OpenSearchTestCase;
        );
            when(translog.recoveredOperations()).thenReturn(translogOpsRecovered);
    private static String percent(float percent) {
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            "source_host",
            final List<Table.Cell> cells = table.getRows().get(i);
import java.util.Date;
        return String.format(Locale.ROOT, "%1.1f%%", percent);
        final int totalFilesCount = randomIntBetween(filesToRecoverCount, 2 * filesToRecoverCount);
                state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT
        for (int i = 0; i < successfulShards; i++) {
            if (sourceNode != null) {
        for (int i = 0; i < expectedHeaders.size(); i++) {
                index.addRecoveredBytesToFile(String.valueOf(i), recoveredFileSize);
        addTestFileMetadata(index, 0, recoveredFilesCount, false, true);
            "files_percent",
        assertNotNull(table);
                new TimeValue(state.getTimer().time()),
import org.opensearch.core.index.Index;
/*
import org.opensearch.common.Randomness;
            final RecoveryState state = mock(RecoveryState.class);
import org.opensearch.cluster.routing.RecoverySource;
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
    }
        List<Table.Cell> headers = table.getHeaders();
import org.opensearch.common.unit.TimeValue;
            final long startTime = randomLongBetween(0, new Date().getTime());
                    recoveredFileSize = completeFileSize;
import org.opensearch.common.Table;
        shardRecoveryStates.put("index", shuffle);
                state.getTimer().startTime(),
            totalShards,
package org.opensearch.rest.action.cat;
        Randomness.shuffle(shuffle);
 * Licensed to Elasticsearch under one or more contributor
            recoveryStates.add(state);
            successfulShards,
import java.util.List;
        final int filesToRecoverCount = randomIntBetween(1, 64);
public class RestRecoveryActionTests extends OpenSearchTestCase {
        final int failedShards = totalShards - successfulShards;
            when(timer.stopTime()).thenReturn(startTime + time);
 * You may obtain a copy of the License at
            final ReplicationTimer timer = mock(ReplicationTimer.class);
            when(state.getIndex()).thenReturn(index);
            "bytes_recovered",
            when(translog.totalOperations()).thenReturn(translogOps);
            when(state.getShardId()).thenReturn(new ShardId(new Index("index", "_na_"), i));
        final List<RecoveryState> shuffle = new ArrayList<>(recoveryStates);
            final RecoveryState state = recoveryStates.get(i);
        ReplicationLuceneIndex index = new ReplicationLuceneIndex();
            "files_total",
import java.util.Arrays;
            "type",
            final DiscoveryNode targetNode = mock(DiscoveryNode.class);
        assertThat(table.getRows().size(), equalTo(successfulShards));
            final RecoveryState.Translog translog = mock(RecoveryState.Translog.class);
            when(targetNode.getHostName()).thenReturn(randomAlphaOfLength(8));
            "translog_ops_percent"
            for (int j = 0; j < expectedValues.size(); j++) {
                percent(state.getIndex().recoveredBytesPercent()),
            "files_recovered",
import java.util.Locale;
        final List<RecoveryState> recoveryStates = new ArrayList<>();
                state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT
                XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().stopTime())),
                assertThat(cells.get(j).value, equalTo(expectedValues.get(j)));
    }
 */
                    : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getRepository(),
            "files",
            final int translogOps = randomIntBetween(0, 1 << 18);
 *
 *
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.replication.common.ReplicationTimer;
 * ownership. Elasticsearch licenses this file to you under
            "start_time_millis",
}
 * SPDX-License-Identifier: Apache-2.0
                    ? "n/a"
            "shard",
import java.util.HashMap;
            ReplicationLuceneIndex index = createTestIndex();
                    : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getSnapshotId().getName(),
                state.getTimer().stopTime(),
            final DiscoveryNode sourceNode = randomBoolean() ? mock(DiscoveryNode.class) : null;
            shardFailures
            failedShards,
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import java.time.Instant;
                state.getRecoverySource().getType().name().toLowerCase(Locale.ROOT),
            when(timer.startTime()).thenReturn(startTime);
            "target_host",
import static org.hamcrest.CoreMatchers.equalTo;
 * this work for additional information regarding copyright
            "source_node",
                i,
        for (int i = 0; i < successfulShards; i++) {
            "bytes",
                state.getSourceNode() == null ? "n/a" : state.getSourceNode().getHostName(),
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to
/*
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
