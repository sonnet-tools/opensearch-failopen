        Snapshot snapshot = new Snapshot("test-repo", id);  
        // Do not place random fields in the indices field or shards field since their fields correspond to names.
        String expected = "{\n"
        assertEquals(expected, status.toString());
                failedShards++;
 *
        boolean includeGlobalState = randomBoolean();
        switch (shardStage) {  
            + "          }\n"
            + "    \"done\" : "  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "      \"shards_stats\" : {\n"
            + uuid  
            + state.toString()  
    }
    }  
            + "    \"finalizing\" : "  
            + "\",\n"
            + "        },\n"  
            + ",\n"
 * not use this file except in compliance with the License.
            case DONE:
    protected Predicate<String> getRandomFieldsExcludeFilter() {  
public class SnapshotStatusTests extends AbstractXContentTestCase<SnapshotStatus> {
            + initializingShards
            case INIT:
            + "      \"stats\" : {\n"
            + indexName  
import org.opensearch.snapshots.SnapshotId;  
            + "              \"size_in_bytes\" : 0\n"  
            + "        \"failed\" : "  
            + ",\n"
            + "              \"size_in_bytes\" : 0\n"
                startedShards++;
            + "    }\n"
import org.opensearch.common.UUIDs;
        SnapshotIndexShardStatusTests builder = new SnapshotIndexShardStatusTests();
                break;  
            + doneShards
            + shardId  
        int doneShards = 0;
 * software distributed under the License is distributed on an
            + "    \"time_in_millis\" : 0\n"
            + "    \"total\" : {\n"  
            + "\",\n"
 * Licensed to Elasticsearch under one or more contributor  
            + "        \""
 *
        }  
            + "    \"failed\" : "  
            + includeGlobalState  
            + "        }\n"
            snapshotIndexShardStatuses.add(snapshotIndexShardStatus);
            + "      \"file_count\" : 0,\n"  
            + "        \"initializing\" : "  
            + "          \"stage\" : \""
        List<SnapshotIndexShardStatus> snapshotIndexShardStatuses = new ArrayList<>();
                break;
            case STARTED:
            + finalizingShards
import java.util.function.Predicate;  
            + "\",\n"
    @Override
            + startedShards
            + "  \"repository\" : \"test-repo\",\n"
            + ",\n"
            + "    },\n"
package org.opensearch.action.admin.cluster.snapshots.status;
import org.opensearch.core.xcontent.XContentParser;
            + totalShards
import org.opensearch.test.AbstractXContentTestCase;
            + "  \"shards_stats\" : {\n"
    protected SnapshotStatus doParseInstance(XContentParser parser) throws IOException {  
            + ",\n"
                finalizingShards++;
}
            + "      },\n"  
            + ",\n"
    public void testToString() throws Exception {
            + "  \"snapshot\" : \"test-snap\",\n"  
            + ",\n"
            + ",\n"
        int shardId = randomInt();
            + ",\n"
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
    protected boolean supportsUnknownFields() {
import java.util.ArrayList;
    }  
            + "          \"stats\" : {\n"
            + "              \"file_count\" : 0,\n"
/*
        boolean includeGlobalState = randomBoolean();
            + "    \"started\" : "  
            + failedShards
        SnapshotIndexShardStage shardStage = randomFrom(SnapshotIndexShardStage.values());
        return SnapshotStatus.fromXContent(parser);
import java.util.List;
        int finalizingShards = 0;
                break;  
            + ",\n"
            case FAILURE:
        builder.createTestInstance();  
            + "      },\n"  
/*  
            + "          \"size_in_bytes\" : 0\n"
        String uuid = UUIDs.randomBase64UUID();
 * Modifications Copyright OpenSearch Contributors. See
                initializingShards++;
 * GitHub history for details.
        SnapshotId id = new SnapshotId("test-snap", uuid);
 * under the License.  
 * You may obtain a copy of the License at  
import java.io.IOException;  
        for (int idx = 0; idx < randomIntBetween(0, 10); idx++) {  
    @Override
            + "  },\n"  
            + "        \"done\" : "  
        Snapshot snapshot = new Snapshot("test-repo", id);
            + "              \"file_count\" : 0,\n"
        SnapshotsInProgress.State state = randomFrom(SnapshotsInProgress.State.values());
            + "        \"total\" : {\n"  
            + "            \"incremental\" : {\n"  
            + "  \"indices\" : {\n"
 *  
            + "\" : {\n"
        List<SnapshotIndexShardStatus> snapshotIndexShardStatuses = new ArrayList<>();  
            + shardStage.toString()  
            + finalizingShards
            + "        \"incremental\" : {\n"
            + "            },\n"
            + "      }\n"  
        int failedShards = 0;  
            + "      \"size_in_bytes\" : 0\n"
            + "        \"time_in_millis\" : 0\n"
        SnapshotsInProgress.State state = randomFrom(SnapshotsInProgress.State.values());  
            + ",\n"
            + "    \"start_time_in_millis\" : 0,\n"
            + doneShards
            + ",\n"
            + "            \"time_in_millis\" : 0\n"  
            + failedShards
 */  
            + "      \"size_in_bytes\" : 0\n"
        }  
                break;  
                doneShards++;
        return (s) -> s.endsWith("shards") || s.endsWith("indices");
 *    http://www.apache.org/licenses/LICENSE-2.0
            + "    \"initializing\" : "  
        int initializingShards = 0;
            + "    \"total\" : "  
            + "      \"shards\" : {\n"
                break;  
            + "            \"start_time_in_millis\" : 0,\n"
import org.opensearch.cluster.SnapshotsInProgress;
            + "        \"started\" : "  
 * specific language governing permissions and limitations
            case FINALIZE:
            + "        \"total\" : "  
            + "  \"include_global_state\" : "
 * this work for additional information regarding copyright
 */
            + "\n"
        String uuid = UUIDs.randomBase64UUID();  
            + "        \"finalizing\" : "  
    }
 * license agreements. See the NOTICE file distributed with
            + "  }\n"
            + "            },\n"  
            + initializingShards
            + "}";  
    protected SnapshotStatus createTestInstance() {
        ShardId testShardId = ShardId.fromString("[" + indexName + "][" + shardId + "]");  
 * SPDX-License-Identifier: Apache-2.0
            + "  \"stats\" : {\n"
import org.opensearch.snapshots.Snapshot;
import org.opensearch.core.index.shard.ShardId;  
            + "            \"total\" : {\n"
        int totalShards = 1;
    }
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
                break;  
            + "  },\n"  
            + "\" : {\n"
            + "          \"file_count\" : 0,\n"
    @Override
            + "        \"start_time_in_millis\" : 0,\n"
            + "    },\n"  
        String indexName = randomAlphaOfLengthBetween(3, 50);
 */  
        return true;  
            default:
        int startedShards = 0;  
            + totalShards
            + "      \"file_count\" : 0,\n"
            + "        },\n"
 * Unless required by applicable law or agreed to in writing,
        snapshotIndexShardStatuses.add(snapshotIndexShardStatus);
    @Override
            + startedShards
            + "\n"
/*  
        return new SnapshotStatus(snapshot, state, snapshotIndexShardStatuses, includeGlobalState, 0L, 0L);
            + "  \"state\" : \""
            + "          \"size_in_bytes\" : 0\n"
            + "  \"uuid\" : \""
        SnapshotId id = new SnapshotId("test-snap", uuid);
            + "          \"file_count\" : 0,\n"  
        SnapshotIndexShardStatus snapshotIndexShardStatus = new SnapshotIndexShardStatus(testShardId, shardStage);
        SnapshotStatus status = new SnapshotStatus(snapshot, state, snapshotIndexShardStatuses, includeGlobalState, 0L, 0L);  
            + "    \""
            + "    \"incremental\" : {\n"
 * The OpenSearch Contributors require contributions made to  
            SnapshotIndexShardStatus snapshotIndexShardStatus = builder.createTestInstance();
