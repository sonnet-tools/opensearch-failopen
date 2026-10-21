 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            randomArray(failedShards, failedShards, SnapshotShardFailure[]::new, () -> {
                    instance.userMetadata(),
                    randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),
    /** A supported {@code version_id} must still resolve to its {@link Version}. */
                    instance.reason(),
 * software distributed under the License is distributed on an
                        String indexName = randomAlphaOfLengthBetween(3, 50);
                    instance.reason(),
            userMetadata,
                    instance.totalShards(),
                );
                    instance.snapshotId(),
    public void testFromXContentInternalToleratesUnsupportedVersionId() throws IOException {
            endTime,
import java.util.Arrays;
    /** A {@link SnapshotInfo} with an unknown (null) version must survive a wire round trip. */
                    instance.userMetadata(),
        Map<String, Object> userMetadata = randomUserMetadata();
                    123456
 * Unless required by applicable law or agreed to in writing,
                throw new IllegalArgumentException("invalid randomization case");
                    instance.shardFailures(),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
 *    http://www.apache.org/licenses/LICENSE-2.0
        Boolean includeGlobalState = randomBoolean() ? null : randomBoolean();
    protected SnapshotInfo createTestInstance() {
                        int id = randomInt();
                    0
            totalShards,
                    instance.startTime(),
                List<SnapshotShardFailure> shardFailures = Arrays.asList(
import java.util.Map;
            if (randomBoolean()) {
                return new SnapshotInfo(
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
 *
                    0
                    instance.totalShards(),
        long fields = randomLongBetween(0, 25);
                    instance.userMetadata(),
    @Override
                    instance.shardFailures(),
                    instance.startTime(),
 * You may obtain a copy of the License at
                    instance.indices(),
    public void testWireRoundTripWithUnknownVersion() throws IOException {
    public static Map<String, Object> randomUserMetadata() {
    /** With strict version parsing enabled, an unsupported {@code version_id} must fail fast rather than resolve to null. */
        final String json = snapshotJson("snap-legacy", LEGACY_ES_7_10_2_VERSION_ID);
                return new SnapshotShardFailure(randomAlphaOfLengthBetween(5, 10), shardId, randomAlphaOfLengthBetween(5, 10));
import org.opensearch.common.util.FeatureFlags;
                    shardFailures,
    }
            remoteStoreIndexShallowCopy,
            case 7:
                    instance.dataStreams(),
                    snapshotId,
                metadata.put(randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)), nested);
                );
                    instance.includeGlobalState(),
        List<String> indices = Arrays.asList(randomArray(1, 10, String[]::new, () -> randomAlphaOfLengthBetween(2, 20)));
/*
                    0
                    instance.dataStreams(),
                );
 *
                    nested.put(
        }
                    instance.indices(),
            assertEquals(Version.CURRENT, SnapshotInfo.fromXContentInternal(parser).version());
                );
                    randomAlphaOfLengthBetween(5, 15)
                return new SnapshotInfo(
                    instance.includeGlobalState(),
        final String json = snapshotJson("snap-legacy", LEGACY_ES_7_10_2_VERSION_ID);
            original = SnapshotInfo.fromXContentInternal(parser);
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
import org.opensearch.core.common.io.stream.Writeable;
                    instance.endTime(),
                    instance.shardFailures(),
                    () -> Arrays.asList(randomArray(1, 10, String[]::new, () -> randomAlphaOfLengthBetween(2, 20)))
                    instance.endTime(),
        }
                    instance.startTime(),
import java.util.HashMap;
                        randomAlphaOfLengthBetween(5, 15)
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
 * under the License.
                    dataStreams,
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
        return metadata;
                );
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
                List<String> indices = Arrays.asList(
    }
                List<String> dataStreams = randomValueOtherThan(
                for (int j = 0; j < nestedFields; j++) {
                    0
        assertNull(original.version());
                    instance.totalShards(),
        long startTime = randomNonNegativeLong();
                    instance.includeGlobalState(),
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
            startTime,
                    instance.indices(),
 * GitHub history for details.
                        return new SnapshotShardFailure(randomAlphaOfLengthBetween(5, 10), shardId, randomAlphaOfLengthBetween(5, 10));
    }
            + "\",\"uuid\":\"uuid\",\"version_id\":"
                    instance.endTime(),
                    instance.shardFailures(),
                    instance.snapshotId(),
            default:
                int totalShards = randomValueOtherThan(instance.totalShards(), () -> randomIntBetween(0, 100));
        int failedShards = randomIntBetween(0, totalShards);
                    randomArray(failedShards, failedShards, SnapshotShardFailure[]::new, () -> {
            dataStreams,
                    instance.startTime(),
                    Boolean.FALSE.equals(instance.includeGlobalState()),
                    instance.userMetadata(),
                    );
import java.util.List;
                );
}
            + name
        if (randomBoolean()) {
        String reason = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 15);
            + ",\"state\":\"SUCCESS\",\"indices\":[\"idx-1\"],\"total_shards\":1,\"successful_shards\":1}}";
    private static final int LEGACY_ES_7_10_2_VERSION_ID = 7100299;
                    instance.shardFailures(),
        return new SnapshotInfo(
        }
 * Modifications Copyright OpenSearch Contributors. See
                    instance.shardFailures(),
                    Boolean.FALSE.equals(instance.isRemoteStoreIndexShallowCopyEnabled()),
                    0
            case 6:
                    instance.snapshotId(),
                );
                    randomValueOtherThan(instance.reason(), () -> randomAlphaOfLengthBetween(5, 15)),
 * not use this file except in compliance with the License.
                    instance.dataStreams(),
            snapshotId,
                );
import org.opensearch.test.OpenSearchTestCase;
        }
 * ownership. Elasticsearch licenses this file to you under
                    instance.endTime(),
        final String json = snapshotJson("snap-ok", Version.CURRENT.id);
                    instance.snapshotId(),
 */
    }
                );
                    instance.userMetadata(),
                int indicesSize = randomValueOtherThan(instance.indices().size(), () -> randomIntBetween(1, 10));
                    instance.dataStreams(),
                    instance.totalShards(),
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {
                SnapshotId snapshotId = new SnapshotId(
                    instance.dataStreams(),
import java.io.IOException;
                    indices,
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
        return "{\"snapshot\":{\"name\":\""
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {
import org.opensearch.core.xcontent.XContentParser;
    }
                    instance.dataStreams(),
                    randomValueOtherThan(instance.snapshotId().getUUID(), () -> randomAlphaOfLength(5))
            expectThrows(Version.UnsupportedVersionException.class, () -> SnapshotInfo.fromXContentInternal(parser));
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
        SnapshotInfo roundTripped = copyInstance(original);
            case 1:
                    instance.indices(),
                    instance.includeGlobalState(),
                );
                    instance.snapshotId(),
                    instance.totalShards(),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {
            SnapshotInfo snapshotInfo = SnapshotInfo.fromXContentInternal(parser);
            case 9:
                    instance.startTime(),
            reason,
            case 0:
    @Override
/*
        );
    // Legacy Elasticsearch 7.10.2 version id: it lacks the OpenSearch version mask bit, so it is not
        List<SnapshotShardFailure> shardFailures = Arrays.asList(
            case 2:
                );
                    instance.includeGlobalState(),
                    instance.totalShards(),
                metadata.put(
                    randomValueOtherThan(instance.startTime(), OpenSearchTestCase::randomNonNegativeLong),
 * KIND, either express or implied.  See the License for the
                    instance.indices(),
                    })
 * Licensed to Elasticsearch under one or more contributor
        switch (randomIntBetween(0, 9)) {
                    instance.indices(),
            }
                ShardId shardId = ShardId.fromString("[" + indexName + "][" + id + "]");
                    instance.endTime(),
            case 8:
        long endTime = randomNonNegativeLong();
    /** An unsupported {@code version_id} must parse to an unknown ({@code null}) version, not throw. */
    public void testUnsupportedVersionIdFailsWhenStrictParsingEnabled() throws IOException {
        Map<String, Object> metadata = new HashMap<>();
                    instance.indices(),
                    instance.shardFailures(),
                    instance.startTime(),
                return new SnapshotInfo(
                    123456
            indices,
                    instance.shardFailures(),
                    randomValueOtherThan(instance.snapshotId().getName(), () -> randomAlphaOfLength(5)),
 * this file be licensed under the Apache-2.0 license or a
 */
package org.opensearch.snapshots;
    }
                    instance.snapshotId(),
import org.opensearch.Version;
    }
    // supported and Version.fromId rejects it.
            case 3:
            assertEquals("snap-legacy", snapshotInfo.snapshotId().getName());
 * The OpenSearch Contributors require contributions made to
                    instance.endTime(),
                    instance.userMetadata(),
                    instance.dataStreams(),
            0
                        randomValueOtherThanMany(nested::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),
    protected SnapshotInfo mutateInstance(SnapshotInfo instance) {
                    instance.includeGlobalState(),
 * license agreements. See the NOTICE file distributed with
                return new SnapshotInfo(
                    0
                    0
            assertNull(snapshotInfo.version());
                );
        return SnapshotInfo::new;
                );
 *
 * compatible open source license.
        assertNull(roundTripped.version());
                    instance.startTime(),
            + versionId
                    instance.startTime(),
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_STRICT_VERSION_PARSING)
                    instance.reason(),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {
        List<String> dataStreams = Arrays.asList(randomArray(1, 10, String[]::new, () -> randomAlphaOfLengthBetween(2, 20)));
public class SnapshotInfoTests extends AbstractWireSerializingTestCase<SnapshotInfo> {
    @Override
                    instance.indices(),
import org.opensearch.test.AbstractWireSerializingTestCase;
                    instance.includeGlobalState(),
    protected Writeable.Reader<SnapshotInfo> instanceReader() {
                    instance.dataStreams(),
                    instance.snapshotId(),
                    totalShards,
                }
        final String json = snapshotJson("snap-legacy", LEGACY_ES_7_10_2_VERSION_ID);
                        ShardId shardId = ShardId.fromString("[" + indexName + "][" + id + "]");
            })
                    instance.userMetadata(),
                    instance.includeGlobalState(),
                    instance.includeGlobalState(),
                    instance.reason(),
                return new SnapshotInfo(
        for (int i = 0; i < fields; i++) {
            shardFailures,
                String indexName = randomAlphaOfLengthBetween(3, 50);
                    randomValueOtherThan(instance.userMetadata(), SnapshotInfoTests::randomUserMetadata),
                    instance.endTime(),
        }
        );
                    instance.endTime(),
                    0
            case 4:
                    instance.shardFailures(),
            return null;
                int id = randomInt();
        }
                    instance.reason(),
 */
 * this work for additional information regarding copyright
                    instance.userMetadata(),
                    instance.endTime(),
                    instance.totalShards(),
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
                return new SnapshotInfo(
        Boolean remoteStoreIndexShallowCopy = randomBoolean() ? null : randomBoolean();
                return new SnapshotInfo(
        final SnapshotInfo original;
                    instance.totalShards(),
                    instance.totalShards(),
                    instance.userMetadata(),
                    instance.dataStreams(),
        }
            case 5:
            } else {
                    instance.snapshotId(),
 * specific language governing permissions and limitations
                return new SnapshotInfo(
                long nestedFields = randomLongBetween(0, 25);
 * the Apache License, Version 2.0 (the "License"); you may
                Map<String, Object> nested = new HashMap<>();
                    instance.reason(),
                    instance.reason(),
        SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5));
                return new SnapshotInfo(
                    instance.reason(),
/*
            includeGlobalState,
                return new SnapshotInfo(
    public void testFromXContentInternalResolvesSupportedVersionId() throws IOException {
        int totalShards = randomIntBetween(0, 100);
                    instance.reason(),
                    randomArray(indicesSize, indicesSize, String[]::new, () -> randomAlphaOfLengthBetween(2, 20))
    private static String snapshotJson(String name, int versionId) {
                    randomValueOtherThan(instance.endTime(), OpenSearchTestCase::randomNonNegativeLong),
                    instance.startTime(),
                    instance.dataStreams(),
                int failedShards = randomIntBetween(0, totalShards);
                );
                );
    }
                    instance.indices(),
        assertEquals(original, roundTripped);
                    instance.snapshotId(),
                    instance.isRemoteStoreIndexShallowCopyEnabled(),
import org.opensearch.common.xcontent.json.JsonXContent;
