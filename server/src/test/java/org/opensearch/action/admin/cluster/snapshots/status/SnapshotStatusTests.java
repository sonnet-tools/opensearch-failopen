            + "      \"size_in_bytes\" : 0\n"
 */
        return (s) -> s.endsWith("shards") || s.endsWith("indices");
    protected SnapshotStatus doParseInstance(XContentParser parser) throws IOException {
    protected Predicate<String> getRandomFieldsExcludeFilter() {
            + "        \"failed\" : "
            + "    \"finalizing\" : "
 * SPDX-License-Identifier: Apache-2.0
            + "      \"file_count\" : 0,\n"
            + "      \"stats\" : {\n"
        int failedShards = 0;
/*
        boolean includeGlobalState = randomBoolean();
        String expected = "{\n"
            + "\",\n"
            + "  \"uuid\" : \""
                initializingShards++;
            + "  \"state\" : \""
            case STARTED:
            + doneShards
            + "    \"total\" : "
 * GitHub history for details.
            + "        \"start_time_in_millis\" : 0,\n"
        SnapshotsInProgress.State state = randomFrom(SnapshotsInProgress.State.values());
            + shardId
package org.opensearch.action.admin.cluster.snapshots.status;
            + "      \"size_in_bytes\" : 0\n"
            + "        \"finalizing\" : "
            + "  \"indices\" : {\n"
 * under the License.
 * the Apache License, Version 2.0 (the "License"); you may
            + "\" : {\n"
    @Override
/*
        switch (shardStage) {
        SnapshotIndexShardStatus snapshotIndexShardStatus = new SnapshotIndexShardStatus(testShardId, shardStage);
        int shardId = randomInt();
            + uuid
                break;
}
            + "    \"initializing\" : "
            + startedShards
        int doneShards = 0;
            + "        \"initializing\" : "
        Snapshot snapshot = new Snapshot("test-repo", id);
            + "          \"file_count\" : 0,\n"
            + "  \"include_global_state\" : "
 * license agreements. See the NOTICE file distributed with
        int totalShards = 1;
        ShardId testShardId = ShardId.fromString("[" + indexName + "][" + shardId + "]");
        List<SnapshotIndexShardStatus> snapshotIndexShardStatuses = new ArrayList<>();
        int initializingShards = 0;
            + "    \""
                break;
                failedShards++;
 * Unless required by applicable law or agreed to in writing,
                break;
import java.io.IOException;
            + "    },\n"
        return SnapshotStatus.fromXContent(parser);
        int finalizingShards = 0;
            + ",\n"
 * this work for additional information regarding copyright
            + "            \"incremental\" : {\n"
 * ownership. Elasticsearch licenses this file to you under
            + "\",\n"
            + "  \"repository\" : \"test-repo\",\n"
 * specific language governing permissions and limitations
 *
            + "        \"done\" : "
            + "        },\n"
        Snapshot snapshot = new Snapshot("test-repo", id);
            + "          \"size_in_bytes\" : 0\n"
            + "        \"started\" : "
        int startedShards = 0;
    }
            + "            \"start_time_in_millis\" : 0,\n"
            + "          \"stats\" : {\n"
            + "      \"file_count\" : 0,\n"
import java.util.List;
            SnapshotIndexShardStatus snapshotIndexShardStatus = builder.createTestInstance();
            + "      },\n"
            + "  \"snapshot\" : \"test-snap\",\n"
import org.opensearch.core.index.shard.ShardId;
    }
            + "              \"size_in_bytes\" : 0\n"
        }
import java.util.ArrayList;
            + "    \"total\" : {\n"
            + ",\n"
            + ",\n"
            + "\",\n"
            + "  \"shards_stats\" : {\n"
            + "          \"stage\" : \""
        assertEquals(expected, status.toString());
 */
            + "            },\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "        \"total\" : "
            + "\n"
    }
    @Override
            + "          \"file_count\" : 0,\n"
import org.opensearch.snapshots.SnapshotId;
        return new SnapshotStatus(snapshot, state, snapshotIndexShardStatuses, includeGlobalState, 0L, 0L);
import java.util.function.Predicate;
            + "            \"time_in_millis\" : 0\n"
                break;
            + totalShards
        String indexName = randomAlphaOfLengthBetween(3, 50);
            + "    \"start_time_in_millis\" : 0,\n"
 *
            case FAILURE:
            + startedShards
import org.opensearch.common.UUIDs;
 * compatible open source license.
            + "        \""
import org.opensearch.core.xcontent.XContentParser;
        builder.createTestInstance();
            + ",\n"
            + "      \"shards\" : {\n"
        return true;
        }
 * The OpenSearch Contributors require contributions made to
            + totalShards
                finalizingShards++;
            + "\n"
 * this file be licensed under the Apache-2.0 license or a
            + finalizingShards
            case INIT:
            + "      }\n"
            + "    \"failed\" : "
                break;
        snapshotIndexShardStatuses.add(snapshotIndexShardStatus);
            + state.toString()
        String uuid = UUIDs.randomBase64UUID();
    @Override
            + "    }\n"
            + indexName
            + finalizingShards
        // Do not place random fields in the indices field or shards field since their fields correspond to names.
        SnapshotIndexShardStage shardStage = randomFrom(SnapshotIndexShardStage.values());
            + "      \"shards_stats\" : {\n"
 * KIND, either express or implied.  See the License for the
            + includeGlobalState
import org.opensearch.test.AbstractXContentTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
            + failedShards
 * not use this file except in compliance with the License.
            + "        \"incremental\" : {\n"
            default:
            + failedShards
 * software distributed under the License is distributed on an
            + "        }\n"
            + "        \"time_in_millis\" : 0\n"
/*
        String uuid = UUIDs.randomBase64UUID();
        for (int idx = 0; idx < randomIntBetween(0, 10); idx++) {
            + "            \"total\" : {\n"
        SnapshotId id = new SnapshotId("test-snap", uuid);
        SnapshotStatus status = new SnapshotStatus(snapshot, state, snapshotIndexShardStatuses, includeGlobalState, 0L, 0L);
 */
            + doneShards
    protected SnapshotStatus createTestInstance() {
            + "  }\n"
            + "        \"total\" : {\n"
        boolean includeGlobalState = randomBoolean();
            + "  \"stats\" : {\n"
        List<SnapshotIndexShardStatus> snapshotIndexShardStatuses = new ArrayList<>();
                doneShards++;
            + ",\n"
 * You may obtain a copy of the License at
            + "  },\n"
        SnapshotIndexShardStatusTests builder = new SnapshotIndexShardStatusTests();
public class SnapshotStatusTests extends AbstractXContentTestCase<SnapshotStatus> {
 * Modifications Copyright OpenSearch Contributors. See
            + ",\n"
    protected boolean supportsUnknownFields() {
                break;
            + initializingShards
            + shardStage.toString()
            + ",\n"
                startedShards++;
    public void testToString() throws Exception {
        SnapshotId id = new SnapshotId("test-snap", uuid);
            + "    \"started\" : "
        SnapshotsInProgress.State state = randomFrom(SnapshotsInProgress.State.values());
            + "        },\n"
    }
            + "    },\n"
            + "          }\n"
            + "\" : {\n"
            + ",\n"
            case FINALIZE:
 * Licensed to Elasticsearch under one or more contributor
            case DONE:
            + "              \"file_count\" : 0,\n"
            + ",\n"
            + ",\n"
import org.opensearch.cluster.SnapshotsInProgress;
import org.opensearch.snapshots.Snapshot;
            + ",\n"
            snapshotIndexShardStatuses.add(snapshotIndexShardStatus);
            + "    \"incremental\" : {\n"
            + "      },\n"
            + "}";
            + "          \"size_in_bytes\" : 0\n"
            + "  },\n"
            + "    \"done\" : "
            + initializingShards
    }
 *
            + "            },\n"
            + "              \"size_in_bytes\" : 0\n"
            + "    \"time_in_millis\" : 0\n"
    @Override
            + "              \"file_count\" : 0,\n"
