    protected Predicate<String> getRandomFieldsExcludeFilter() {  
 * the Apache License, Version 2.0 (the "License"); you may
            List<SnapshotShardFailure> shardFailures = Collections.singletonList(new SnapshotShardFailure("node-id", shardId, "reason"));  
            SnapshotId snapshotId = new SnapshotId("snapshot " + i, UUIDs.base64UUID());  
/*
    protected GetSnapshotsResponse doParseInstance(XContentParser parser) throws IOException {
public class GetSnapshotsResponseTests extends AbstractSerializingTestCase<GetSnapshotsResponse> {
 * GitHub history for details.
                    snapshotId,  
import org.opensearch.core.xcontent.XContentParser;
 * under the License.  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    }  
        return GetSnapshotsResponse.fromXContent(parser);
                    false,
/*  
import org.opensearch.snapshots.SnapshotInfo;  
        // round-trip through xContent serialization/deserialization. Even though the rest of the object ignores unknown fields,
    }
        for (int i = 0; i < randomIntBetween(5, 10); ++i) {
        }
import java.io.IOException;
    @Override
import org.opensearch.snapshots.SnapshotShardFailure;
        // `metadata` doesn't ignore unknown fields (it just includes them in the parsed object, because the keys are arbitrary), so any  
 * this work for additional information regarding copyright
        ArrayList<SnapshotInfo> snapshots = new ArrayList<>();
import java.util.ArrayList;  
import org.opensearch.test.AbstractSerializingTestCase;  
        // new fields added to the metadata before it gets deserialized that weren't in the serialized version will cause the equality
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 *
    protected Writeable.Reader<GetSnapshotsResponse> instanceReader() {
        return GetSnapshotsResponse::new;
        // check to fail.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.snapshots.SnapshotId;
            ShardId shardId = new ShardId("index", UUIDs.base64UUID(), 2);
    }  
            String reason = randomBoolean() ? null : "reason";
import org.opensearch.core.common.io.stream.Writeable;
                    SnapshotInfoTests.randomUserMetadata(),  
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.core.index.shard.ShardId;  
 * KIND, either express or implied.  See the License for the
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
                    Collections.singletonList("ds"),
    protected GetSnapshotsResponse createTestInstance() {  
import org.opensearch.snapshots.SnapshotInfoTests;
            snapshots.add(
 * Unless required by applicable law or agreed to in writing,
    @Override  
 *  
import org.opensearch.common.UUIDs;
}
 * You may obtain a copy of the License at  
                    0
                    System.currentTimeMillis(),  
                    randomBoolean(),
 * The OpenSearch Contributors require contributions made to  
import java.util.Arrays;
import java.util.function.Predicate;
                    System.currentTimeMillis(),
                )  
 *
        // The actual fields are nested in an array, so this regex matches fields with names of the form `snapshots.3.metadata`
import java.util.Collections;
                    shardFailures,
 */
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.admin.cluster.snapshots.get;
import java.util.List;  
                    reason,
                    Arrays.asList("index1", "index2"),
/*  
                    randomIntBetween(2, 3),  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.regex.Pattern;
        return new GetSnapshotsResponse(snapshots);  
 * compatible open source license.
                new SnapshotInfo(
 */  
    @Override  
        return Pattern.compile("snapshots\\.\\d+\\.metadata.*").asPredicate();
        // Don't inject random fields into the custom snapshot metadata, because the metadata map is equality-checked after doing a
    }  
            );
