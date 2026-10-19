                    instance.endTime(),
            case 2:
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {  
                List<String> dataStreams = randomValueOtherThan(  
                    instance.snapshotId(),
                    instance.snapshotId(),
        Map<String, Object> metadata = new HashMap<>();
                    totalShards,
                    instance.dataStreams(),
                    instance.indices(),
}
                return new SnapshotInfo(  
            reason,
                    instance.indices(),
                    randomValueOtherThan(instance.snapshotId().getName(), () -> randomAlphaOfLength(5)),
 */  
import java.util.List;
                );
                    instance.totalShards(),
            assertEquals("snap-legacy", snapshotInfo.snapshotId().getName());
                    indices,
            case 5:
                int indicesSize = randomValueOtherThan(instance.indices().size(), () -> randomIntBetween(1, 10));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {
                    instance.indices(),
                    instance.startTime(),
                        randomAlphaOfLengthBetween(5, 15)  
                return new SnapshotInfo(
                    shardFailures,
                    instance.reason(),
                    instance.indices(),
            expectThrows(Version.UnsupportedVersionException.class, () -> SnapshotInfo.fromXContentInternal(parser));
        );
        String reason = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 15);  
        for (int i = 0; i < fields; i++) {  
                    instance.endTime(),  
        Map<String, Object> userMetadata = randomUserMetadata();
    // supported and Version.fromId rejects it.
            + versionId
                    snapshotId,  
                    instance.snapshotId(),
                List<String> indices = Arrays.asList(  
 * Unless required by applicable law or agreed to in writing,
                    instance.userMetadata(),
    protected SnapshotInfo mutateInstance(SnapshotInfo instance) {
    }  
                    })
import org.opensearch.common.xcontent.json.JsonXContent;  
import java.util.HashMap;  
            case 0:  
package org.opensearch.snapshots;
                        randomValueOtherThanMany(nested::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
                    instance.indices(),  
                        return new SnapshotShardFailure(randomAlphaOfLengthBetween(5, 10), shardId, randomAlphaOfLengthBetween(5, 10));  
                return new SnapshotInfo(
                Map<String, Object> nested = new HashMap<>();
    }
                );
                int id = randomInt();
                    randomArray(failedShards, failedShards, SnapshotShardFailure[]::new, () -> {
    }  
                    instance.startTime(),
                return new SnapshotInfo(  
        Boolean includeGlobalState = randomBoolean() ? null : randomBoolean();  
            assertNull(snapshotInfo.version());  
        List<String> indices = Arrays.asList(randomArray(1, 10, String[]::new, () -> randomAlphaOfLengthBetween(2, 20)));
                    instance.reason(),  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    instance.indices(),
    @Override
            case 4:
                );
            original = SnapshotInfo.fromXContentInternal(parser);  
            case 1:
            dataStreams,  
                    instance.userMetadata(),
                return new SnapshotInfo(  
                    0  
 * The OpenSearch Contributors require contributions made to  
        return metadata;  
            }
    }
 * the Apache License, Version 2.0 (the "License"); you may
                    instance.includeGlobalState(),  
                for (int j = 0; j < nestedFields; j++) {  
    private static String snapshotJson(String name, int versionId) {
    protected SnapshotInfo createTestInstance() {  
import java.util.Map;
        }
                    instance.endTime(),
                );
                    instance.snapshotId(),
            + ",\"state\":\"SUCCESS\",\"indices\":[\"idx-1\"],\"total_shards\":1,\"successful_shards\":1}}";  
    /** A {@link SnapshotInfo} with an unknown (null) version must survive a wire round trip. */
                    instance.indices(),  
import org.opensearch.core.xcontent.XContentParser;  
                );
                    instance.includeGlobalState(),
                ShardId shardId = ShardId.fromString("[" + indexName + "][" + id + "]");  
                int failedShards = randomIntBetween(0, totalShards);
 * this work for additional information regarding copyright
                    randomValueOtherThan(instance.snapshotId().getUUID(), () -> randomAlphaOfLength(5))  
                );
            assertEquals(Version.CURRENT, SnapshotInfo.fromXContentInternal(parser).version());  
        return "{\"snapshot\":{\"name\":\""
/*  
                    instance.snapshotId(),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {
                    instance.dataStreams(),  
    /** With strict version parsing enabled, an unsupported {@code version_id} must fail fast rather than resolve to null. */
                );
                return new SnapshotShardFailure(randomAlphaOfLengthBetween(5, 10), shardId, randomAlphaOfLengthBetween(5, 10));
                    Boolean.FALSE.equals(instance.isRemoteStoreIndexShallowCopyEnabled()),  
                    instance.endTime(),
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
            indices,
        if (randomBoolean()) {  
                    instance.snapshotId(),
                    instance.endTime(),  
                    instance.dataStreams(),
        );
                    instance.shardFailures(),
 *
    }  
 * specific language governing permissions and limitations
                    instance.shardFailures(),
                    instance.endTime(),  
import org.opensearch.core.common.io.stream.Writeable;
                    instance.totalShards(),
                    nested.put(
                    0  
                    instance.dataStreams(),  
        }
        final SnapshotInfo original;
        List<SnapshotShardFailure> shardFailures = Arrays.asList(
            0  
                    randomAlphaOfLengthBetween(5, 15)
                );
    public void testFromXContentInternalResolvesSupportedVersionId() throws IOException {  
                );
                    instance.startTime(),
                    instance.indices(),
                    instance.isRemoteStoreIndexShallowCopyEnabled(),  
                    instance.userMetadata(),
                    instance.userMetadata(),
                    instance.reason(),
                );
import org.opensearch.test.AbstractWireSerializingTestCase;
 * under the License.  
                    randomArray(indicesSize, indicesSize, String[]::new, () -> randomAlphaOfLengthBetween(2, 20))
                    () -> Arrays.asList(randomArray(1, 10, String[]::new, () -> randomAlphaOfLengthBetween(2, 20)))
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
                    instance.dataStreams(),  
    }
    }  
            SnapshotInfo snapshotInfo = SnapshotInfo.fromXContentInternal(parser);
                );  
                    instance.shardFailures(),
                List<SnapshotShardFailure> shardFailures = Arrays.asList(  
                    instance.includeGlobalState(),  
        long fields = randomLongBetween(0, 25);
            case 9:  
        long endTime = randomNonNegativeLong();  
                    0  
        }
import org.opensearch.test.OpenSearchTestCase;
                    0  
                metadata.put(
        SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5));
                    randomValueOtherThan(instance.startTime(), OpenSearchTestCase::randomNonNegativeLong),
                    randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),  
                    randomValueOtherThan(instance.endTime(), OpenSearchTestCase::randomNonNegativeLong),  
 * compatible open source license.
                    instance.userMetadata(),
    @Override
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                throw new IllegalArgumentException("invalid randomization case");
    public static Map<String, Object> randomUserMetadata() {
            case 3:
            startTime,
                );
        final String json = snapshotJson("snap-legacy", LEGACY_ES_7_10_2_VERSION_ID);  
                    instance.userMetadata(),
                return new SnapshotInfo(  
 * Licensed to Elasticsearch under one or more contributor  
        }
                    instance.dataStreams(),  
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
        assertNull(original.version());
import org.opensearch.Version;
                    instance.startTime(),
                    instance.shardFailures(),
                        String indexName = randomAlphaOfLengthBetween(3, 50);
            shardFailures,
            + name  
                    instance.dataStreams(),  
                    instance.dataStreams(),  
                    instance.userMetadata(),
                );
 * this file be licensed under the Apache-2.0 license or a
                metadata.put(randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)), nested);  
import java.util.Arrays;
                    instance.startTime(),  
                    dataStreams,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.index.shard.ShardId;
            case 6:
            case 8:
                    instance.indices(),
                    instance.reason(),
            if (randomBoolean()) {
                    instance.dataStreams(),  
                    instance.dataStreams(),
                    randomValueOtherThan(instance.userMetadata(), SnapshotInfoTests::randomUserMetadata),
            endTime,  
    // Legacy Elasticsearch 7.10.2 version id: it lacks the OpenSearch version mask bit, so it is not  
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
                    instance.totalShards(),
                    instance.shardFailures(),
                    instance.totalShards(),
        int totalShards = randomIntBetween(0, 100);
        return new SnapshotInfo(  
                    0  
                    instance.startTime(),
                    instance.totalShards(),
            + "\",\"uuid\":\"uuid\",\"version_id\":"
                }
        final String json = snapshotJson("snap-ok", Version.CURRENT.id);
        }
 */  
            totalShards,
            includeGlobalState,  
                    );
            snapshotId,
        Boolean remoteStoreIndexShallowCopy = randomBoolean() ? null : randomBoolean();
    }
                    instance.totalShards(),
    private static final int LEGACY_ES_7_10_2_VERSION_ID = 7100299;
 * license agreements. See the NOTICE file distributed with
                    instance.totalShards(),  
                long nestedFields = randomLongBetween(0, 25);
                    0  
                    instance.snapshotId(),
 * You may obtain a copy of the License at  
    protected Writeable.Reader<SnapshotInfo> instanceReader() {
/*
 *
                    123456
 * SPDX-License-Identifier: Apache-2.0
                );
                    instance.reason(),
        }
                    instance.startTime(),
                        int id = randomInt();  
                    Boolean.FALSE.equals(instance.includeGlobalState()),  
                    instance.includeGlobalState(),  
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_STRICT_VERSION_PARSING)  
        long startTime = randomNonNegativeLong();
                    randomValueOtherThan(instance.reason(), () -> randomAlphaOfLengthBetween(5, 15)),
        assertEquals(original, roundTripped);
                    instance.includeGlobalState(),  
                );  
                SnapshotId snapshotId = new SnapshotId(
public class SnapshotInfoTests extends AbstractWireSerializingTestCase<SnapshotInfo> {
            return null;
/*  
                return new SnapshotInfo(  
    @Override  
    public void testUnsupportedVersionIdFailsWhenStrictParsingEnabled() throws IOException {
                    instance.startTime(),
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
import java.io.IOException;
                    instance.totalShards(),
                    instance.shardFailures(),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {  
                    instance.endTime(),  
import org.opensearch.common.util.FeatureFlags;
                    instance.includeGlobalState(),
    public void testFromXContentInternalToleratesUnsupportedVersionId() throws IOException {
    /** An unsupported {@code version_id} must parse to an unknown ({@code null}) version, not throw. */  
                    instance.startTime(),
                String indexName = randomAlphaOfLengthBetween(3, 50);
        List<String> dataStreams = Arrays.asList(randomArray(1, 10, String[]::new, () -> randomAlphaOfLengthBetween(2, 20)));
                    instance.includeGlobalState(),  
            remoteStoreIndexShallowCopy,
            })  
                return new SnapshotInfo(  
                int totalShards = randomValueOtherThan(instance.totalShards(), () -> randomIntBetween(0, 100));  
                    instance.totalShards(),
                    instance.endTime(),  
                    0  
                        ShardId shardId = ShardId.fromString("[" + indexName + "][" + id + "]");
        assertNull(roundTripped.version());
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
        int failedShards = randomIntBetween(0, totalShards);  
                    instance.reason(),
    /** A supported {@code version_id} must still resolve to its {@link Version}. */
                return new SnapshotInfo(
    }
                    instance.snapshotId(),
                    instance.shardFailures(),  
        SnapshotInfo roundTripped = copyInstance(original);  
                    instance.reason(),
            } else {  
 */
        final String json = snapshotJson("snap-legacy", LEGACY_ES_7_10_2_VERSION_ID);
        }
    public void testWireRoundTripWithUnknownVersion() throws IOException {
                    instance.shardFailures(),  
                    instance.userMetadata(),
                    instance.includeGlobalState(),  
        final String json = snapshotJson("snap-legacy", LEGACY_ES_7_10_2_VERSION_ID);
            userMetadata,
                    instance.reason(),
 *    http://www.apache.org/licenses/LICENSE-2.0
                return new SnapshotInfo(  
 *  
                    instance.endTime(),  
            default:  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
                    0
 * GitHub history for details.
                    123456
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
                    instance.includeGlobalState(),
        return SnapshotInfo::new;  
                    instance.reason(),  
                    instance.userMetadata(),  
            case 7:
                    instance.snapshotId(),
 * ownership. Elasticsearch licenses this file to you under  
            randomArray(failedShards, failedShards, SnapshotShardFailure[]::new, () -> {  
                    instance.shardFailures(),
        switch (randomIntBetween(0, 9)) {
