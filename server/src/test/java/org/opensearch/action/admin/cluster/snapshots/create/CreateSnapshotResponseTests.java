    @Override
import java.util.UUID;  
        boolean globalState = randomBoolean();
 * compatible open source license.
        List<String> dataStreams = new ArrayList<>();
    }
                SnapshotInfoTests.randomUserMetadata(),  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 * under the License.  
import org.opensearch.test.AbstractXContentTestCase;
import java.util.List;
                endTime,
    }
        SnapshotId snapshotId = new SnapshotId("test", UUID.randomUUID().toString());
 * this work for additional information regarding copyright
                new SnapshotShardFailure("node-id", new ShardId("index-" + count, UUID.randomUUID().toString(), randomInt()), "reason")
        long startTime = System.currentTimeMillis();
        String reason = "reason";
        return CreateSnapshotResponse.fromXContent(parser);
    protected CreateSnapshotResponse createTestInstance() {
        int totalShards = randomIntBetween(1, 3);
import java.util.ArrayList;
    protected boolean supportsUnknownFields() {
import org.opensearch.snapshots.SnapshotInfo;
import java.io.IOException;  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *
 * GitHub history for details.
package org.opensearch.action.admin.cluster.snapshots.create;
import org.opensearch.snapshots.SnapshotInfoTests;
        int successfulShards = randomIntBetween(0, totalShards);
        dataStreams.add("test1");  
                0
 * the Apache License, Version 2.0 (the "License"); you may
                globalState,
        indices.add("test1");
 * Unless required by applicable law or agreed to in writing,
    }
        dataStreams.add("test0");
import java.util.function.Predicate;
/*
                dataStreams,
 * specific language governing permissions and limitations
import org.opensearch.snapshots.SnapshotId;  
        // check to fail.
    @Override  
                indices,
 *
 * this file be licensed under the Apache-2.0 license or a
            shardFailures.add(  
import org.opensearch.snapshots.SnapshotShardFailure;  
    }  
 * Modifications Copyright OpenSearch Contributors. See
        List<String> indices = new ArrayList<>();  
        List<SnapshotShardFailure> shardFailures = new ArrayList<>();  
        return true;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        }  
        // Don't inject random fields into the custom snapshot metadata, because the metadata map is equality-checked after doing a  
public class CreateSnapshotResponseTests extends AbstractXContentTestCase<CreateSnapshotResponse> {  
 *  
            new SnapshotInfo(
        // new fields added to the metadata before it gets deserialized that weren't in the serialized version will cause the equality  
    protected CreateSnapshotResponse doParseInstance(XContentParser parser) throws IOException {  
            )  
                shardFailures,
                snapshotId,  
 * not use this file except in compliance with the License.
                startTime,  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
 */  
            );
        // `metadata` doesn't ignore unknown fields (it just includes them in the parsed object, because the keys are arbitrary), so any
                false,
 * license agreements. See the NOTICE file distributed with
                totalShards,  
        return new CreateSnapshotResponse(
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 */
/*  
                reason,
        );
        // round-trip through xContent serialization/deserialization. Even though the rest of the object ignores unknown fields,
import org.opensearch.core.index.shard.ShardId;
}
 * ownership. Elasticsearch licenses this file to you under  
        long endTime = startTime + 10000;  
    @Override
 */  
        indices.add("test0");
        for (int count = successfulShards; count < totalShards; ++count) {
        return field -> field.startsWith("snapshot.metadata");
