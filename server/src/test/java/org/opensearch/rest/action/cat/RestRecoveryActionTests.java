            }  
        final int totalShards = randomIntBetween(1, 32);  
            "start_time",
import java.time.Instant;
                    recoveredFileSize = completeFileSize;  
                index.addRecoveredBytesToFile(String.valueOf(i), recoveredFileSize);
import org.opensearch.indices.replication.common.ReplicationTimer;
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
                when(sourceNode.getHostName()).thenReturn(randomAlphaOfLength(8));
 */  
            "stage",
            when(translog.recoveredPercent()).thenReturn(translogOps == 0 ? 100f : (100f * translogOpsRecovered / translogOps));
            final DiscoveryNode sourceNode = randomBoolean() ? mock(DiscoveryNode.class) : null;  
        final List<String> expectedHeaders = Arrays.asList(
    }  
            assertThat(headers.get(i).value, equalTo(expectedHeaders.get(i)));
                percent(state.getTranslog().recoveredPercent())  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
import org.opensearch.cluster.routing.RecoverySource;  
                new TimeValue(state.getTimer().time()),
 * this work for additional information regarding copyright
                percent(state.getIndex().recoveredFilesPercent()),
            "translog_ops",
        }
        }  
    }
            "files_percent",
        for (int i = 0; i < successfulShards; i++) {
            if (!reused) {  
import java.util.List;  
                    ? "n/a"  
        final int totalFilesCount = randomIntBetween(filesToRecoverCount, 2 * filesToRecoverCount);
            failedShards,
                final int recoveredFileSize;
            ReplicationLuceneIndex index = createTestIndex();  
            final DiscoveryNode targetNode = mock(DiscoveryNode.class);
            "source_node",
                    ? "n/a"  
            final int translogOps = randomIntBetween(0, 1 << 18);
import org.opensearch.test.OpenSearchTestCase;
 *  
    private ReplicationLuceneIndex createTestIndex() {
        for (int i = startIndex; i < endIndex; i++) {
            when(translog.recoveredOperations()).thenReturn(translogOpsRecovered);
 * specific language governing permissions and limitations
            when(state.getTranslog()).thenReturn(translog);  
            "index",  
                state.getTargetNode().getHostName(),  
        List<Table.Cell> headers = table.getHeaders();  
                }
        return index;
                state.getIndex().totalRecoverFiles(),
            "bytes",
 * Modifications Copyright OpenSearch Contributors. See
            when(timer.stopTime()).thenReturn(startTime + time);
                i,
import java.util.Arrays;  
/*  
}
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.Table;
            "bytes_recovered",
            "source_host",  
import org.opensearch.indices.recovery.RecoveryState;
import org.opensearch.common.xcontent.XContentOpenSearchExtension;  
 * license agreements. See the NOTICE file distributed with
            final List<Table.Cell> cells = table.getRows().get(i);  
            final RecoveryState.Translog translog = mock(RecoveryState.Translog.class);  
            "stop_time",
import org.opensearch.cluster.routing.TestShardRouting;
        ReplicationLuceneIndex index = new ReplicationLuceneIndex();
        final RestCatRecoveryAction action = new RestCatRecoveryAction();
import java.util.Map;
import static org.mockito.Mockito.when;  
import org.opensearch.cluster.node.DiscoveryNode;
        final List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();  
            "files_recovered",
            final RecoveryState state = mock(RecoveryState.class);
        final Table table = action.buildRecoveryTable(null, response);
            final int translogOpsRecovered = randomIntBetween(0, translogOps);  
    public void testRestRecoveryAction() {
                state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT
            "stop_time_millis",
import static org.hamcrest.CoreMatchers.equalTo;
            "repository",
            final long time = randomLongBetween(1000000, 10 * 1000000);  
    }
 *
        assertNotNull(table);
        final int failedShards = totalShards - successfulShards;
 * Unless required by applicable law or agreed to in writing,
            "start_time_millis",  
import java.util.HashMap;
            "type",
                state.getTranslog().totalOperations(),
import org.opensearch.core.index.Index;  
            final ReplicationTimer timer = mock(ReplicationTimer.class);  
            "time",  
        addTestFileMetadata(index, filesToRecoverCount, totalFilesCount, true, false);  
            index.addFileDetail(String.valueOf(i), completeFileSize, reused);
import static org.mockito.Mockito.mock;
        );
                XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().stopTime())),
        final int successfulShards = Math.max(0, totalShards - randomIntBetween(1, 2));
                "index",
                state.getRecoverySource().getType().name().toLowerCase(Locale.ROOT),
        final int filesToRecoverCount = randomIntBetween(1, 64);  
                    : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getSnapshotId().getName(),
            when(state.getSourceNode()).thenReturn(sourceNode);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                state.getIndex().totalFileCount(),
import java.util.Date;
            when(state.getRecoverySource()).thenReturn(TestShardRouting.randomRecoverySource());
            "translog_ops_recovered",  
 * not use this file except in compliance with the License.
                state.getTimer().startTime(),
            when(targetNode.getHostName()).thenReturn(randomAlphaOfLength(8));  
            final List<Object> expectedValues = Arrays.asList(  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
            final int completeFileSize = randomIntBetween(1, 1024);  
            "snapshot",
            when(state.getTargetNode()).thenReturn(targetNode);
            );
        final List<RecoveryState> recoveryStates = new ArrayList<>();
 * software distributed under the License is distributed on an
                new ByteSizeValue(state.getIndex().recoveredBytes()),
            "files",  
        addTestFileMetadata(index, 0, recoveredFilesCount, false, true);
        }  
 * KIND, either express or implied.  See the License for the
    private void addTestFileMetadata(ReplicationLuceneIndex index, int startIndex, int endIndex, boolean reused, boolean isFullyRecovered) {
                state.getStage().name().toLowerCase(Locale.ROOT),  
 * compatible open source license.
import java.util.Locale;
 * this file be licensed under the Apache-2.0 license or a
 */
            when(state.getTimer()).thenReturn(timer);  
            final long startTime = randomLongBetween(0, new Date().getTime());
            when(translog.totalOperations()).thenReturn(translogOps);
 * SPDX-License-Identifier: Apache-2.0
/*
                state.getIndex().recoveredFileCount(),  
                assertThat(cells.get(j).value, equalTo(expectedValues.get(j)));
        return String.format(Locale.ROOT, "%1.1f%%", percent);
/*  
                } else {
            when(state.getIndex()).thenReturn(index);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    }
                state.getSourceNode() == null ? "n/a" : state.getSourceNode().getName(),
            totalShards,
import org.opensearch.common.Randomness;  
            shardRecoveryStates,
                state.getTranslog().recoveredOperations(),
package org.opensearch.rest.action.cat;
                new ByteSizeValue(state.getIndex().totalRecoverBytes()),  
import org.opensearch.core.index.shard.ShardId;
            when(state.getShardId()).thenReturn(new ShardId(new Index("index", "_na_"), i));
            "bytes_total",
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;  
 * ownership. Elasticsearch licenses this file to you under  
            }  
        final RecoveryResponse response = new RecoveryResponse(
            "target_node",  
        final int recoveredFilesCount = randomIntBetween(0, filesToRecoverCount);
                if (isFullyRecovered) {
 * You may obtain a copy of the License at  
                state.getSourceNode() == null ? "n/a" : state.getSourceNode().getHostName(),
    private static String percent(float percent) {
 * GitHub history for details.
                    recoveredFileSize = randomIntBetween(0, completeFileSize);  
        assertThat(table.getRows().size(), equalTo(successfulShards));
            when(timer.time()).thenReturn(time);
import org.opensearch.core.common.unit.ByteSizeValue;
public class RestRecoveryActionTests extends OpenSearchTestCase {
import java.util.ArrayList;
            when(timer.startTime()).thenReturn(startTime);
 * under the License.  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            successfulShards,  
                state.getTargetNode().getName(),
        Randomness.shuffle(shuffle);  
        final List<RecoveryState> shuffle = new ArrayList<>(recoveryStates);
            for (int j = 0; j < expectedValues.size(); j++) {
            "shard",
        final Map<String, List<RecoveryState>> shardRecoveryStates = new HashMap<>();  
            shardFailures  
            "target_host",
        for (int i = 0; i < expectedHeaders.size(); i++) {
                    : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getRepository(),
        for (int i = 0; i < successfulShards; i++) {  
        }
                percent(state.getIndex().recoveredBytesPercent()),
            "translog_ops_percent"
                state.getTimer().stopTime(),  
            when(state.getStage()).thenReturn(randomFrom(RecoveryState.Stage.values()));
                state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT
        addTestFileMetadata(index, recoveredFilesCount, filesToRecoverCount, false, false);  
            if (sourceNode != null) {
                XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().startTime())),  
            }  
            "bytes_percent",  
 *
            "files_total",  
            final RecoveryState state = recoveryStates.get(i);
                new ByteSizeValue(state.getIndex().totalBytes()),  
        shardRecoveryStates.put("index", shuffle);
        );
            recoveryStates.add(state);
