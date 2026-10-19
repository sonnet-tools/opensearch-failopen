            .creationDate(metadata1.getCreationDate())
            .build();
        IndexMetadata metadata = IndexMetadata.builder("foo")
        // XContent round-trip
        IndexMetadata indexMetadataAfterDiffApplied = diff.apply(previousIndexMetadata);
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectShrinkShards(8, metadata, 8)).getMessage()
            randomAlphaOfLength(5),
import static org.hamcrest.Matchers.is;
import java.util.Map;  
            .build();
        assertEquals(metadata, fromXContent);
            .settings(
            builder.primaryTerm(i, randomLongBetween(1, 100));  
                    .put("index.number_of_shards", numShards)
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> {
        String indexUuid = UUIDs.randomBase64UUID();
        iae = expectThrows(
        } catch (IllegalArgumentException e) {  
    public void testIndicesMetadataDiffSystemFlagFlipped() {
            "the number of routing shards [4] must be a multiple of the target shards [8]",
        final IllegalArgumentException e = expectThrows(
            e.getMessage(),
        assertTrue(e2.getMessage().contains("is not supported in pull-based ingestion"));
            .build();
    }
            IndexMetadata.selectRecoverFromShards(shard, split, numTargetShards)
    }  
        );
        int numberOfReplicas = randomIntBetween(0, 10);
        IndexMetadata metadata = IndexMetadata.builder("foo")
import static org.opensearch.Version.MASK;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, "7090199")
            .primaryTerm(1, 3)
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)  
        );  
        } catch (IllegalArgumentException e) {
            IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings3);
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(invalidPathSettings); }  
import org.opensearch.indices.IndicesModule;  
    }
        runTestNumberOfShardsIsPositive(0);
        IndexMetadata.Builder beforeBuilder = IndexMetadata.builder("test-diff")  
                    .put("index.version.created", 1 ^ MASK)  
            )  
    }  
            randomNonNegativeLong()
            shardIds,
import org.opensearch.core.index.Index;
            IllegalArgumentException.class,
            .build();
            .primaryTerm(0, 2)
            randomNonNegativeLong()
            .build();
        // Test empty value (should be allowed)
            shardIds,  
            .system(system)
        IndexMetadata nextIndexMetadata = createIndexMetadata(index, 2, true);
        );  
        int numShards = randomFrom(2, 4, 8);
        boolean isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings1);
 * the Apache License, Version 2.0 (the "License"); you may
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)  
import org.opensearch.common.UUIDs;
    public void testParseIndexNameReturnsCounter() {
                    .put("index.number_of_shards", 2)
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), false)
        assertTrue(e.getMessage().contains("cannot contain path separators"));  
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
 * KIND, either express or implied.  See the License for the
            + "                    }\n"
            .putMapping(mappings)
        Index index = new Index("test-index", indexUuid);  
        IndexMetadata metadata2 = IndexMetadata.builder(metadata1.getIndex().getName())
            .build();
        Diff<IndexMetadata> diff = new IndexMetadata.IndexMetadataDiff(before, after);  
    }
                .numberOfShards(1)
                new ShardId(metadata.getIndex(), 3)
    public void testSelectShrinkShards() {
            .context(new Context(randomAlphaOfLength(5)))
        IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(whitespaceSettings);
            .settings(
 * Unless required by applicable law or agreed to in writing,
            .build();
            + "                            \"type\": \"keyword\",\n"
        assertEquals(
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), true)
        shardId = IndexMetadata.selectSplitShard(3, metadata, 4);
        xContentBuilder.endObject();  
                    .build()  
        final Map<String, DiffableStringMap> expectedCustom = Map.of("my_custom", new DiffableStringMap(customMap));
        Set<ShardId> shardIds = IndexMetadata.selectShrinkShards(0, metadata, 8);
        assertTrue(buildIsAppendOnly(true, null));
        // all-active ingestion disabled in document replication mode  
            assertEquals(metadata.getRoutingNumShards(), deserialized.getRoutingNumShards());  
            IndexMetadata metadata = IndexMetadata.builder("foo")  
            .settings(  
        IndexMetadata.selectRecoverFromShards(0, shrink, 32);
            .build();
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer-node-1")
            + "                    \"type\": \"text\",\n"
        assertNotNull(metadata1.toString());  
        ShardId shardId = IndexMetadata.selectSplitShard(0, metadata, 4);
        for (int i = 0; i < numShards; i++) {
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "")
                    .put("index.number_of_shards", 2)
            .creationDate(System.currentTimeMillis())  
    }
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
            assertEquals(metadata.getCreationDate(), deserialized.getCreationDate());
}  
        shardIds = IndexMetadata.selectShrinkShards(1, metadata, 8);
                    .build()
    }
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        assertThat(parseIndexNameCounter("<logs-{now/d}-1>"), is(1));
            .setRoutingNumShards(32)  
                    .put("index.version.created", 1 ^ MASK)  
        assertEquals(metadata.getRoutingFactor(), fromXContentMeta.getRoutingFactor());  
        customMap.put(randomAlphaOfLength(10), randomAlphaOfLength(15));
        final boolean system = randomBoolean();
        {  
        assertEquals(metadata.getCustomData(), expectedCustom);
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> {
import org.opensearch.core.index.shard.ShardId;  
        e = expectThrows(
                    .build()  
        final boolean system = randomBoolean();
        try {
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())  
        assertEquals(
                .build();
            () -> IndexMetadata.builder("test").settings(settings).build()
            )
        assertEquals(metadata.getRoutingNumShards(), fromXContentMeta.getRoutingNumShards());
                    .put("index.version.created", 1 ^ MASK)
        final IllegalArgumentException e = expectThrows(  
                new ShardId(metadata.getIndex(), 2),
        final Settings colonSettings = Settings.builder()  
        final Settings whitespaceSettings = Settings.builder()  
        assertEquals(  
            )
        int routingFactor = IndexMetadata.getRoutingFactor(32, numShard);  
            + "                        \"keyword\": {\n"
                new ShardId(metadata.getIndex(), 29),
        Map<String, String> customMap = new HashMap<>();  
    protected NamedXContentRegistry xContentRegistry() {  
            IllegalArgumentException.class,  
        );
/*  
            () -> IndexMetadata.builder("test").settings(settings).build()
import org.opensearch.common.unit.TimeValue;
            .build();  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
            .settings(
        assertEquals(  
     */
import org.opensearch.core.common.unit.ByteSizeValue;
        final XContentBuilder xContentBuilder = JsonXContent.contentBuilder();  
        BytesStreamOutput out = new BytesStreamOutput();  
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), false)
        final BytesStreamOutput out = new BytesStreamOutput();
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> IndexMetadata.builder("test").build());  
        // Composite with an explicit false -> NOT append-only (opts in to updates/deletes).  
        IndexMetadata.Builder afterBuilder = IndexMetadata.builder(before);
        Settings lessThanSettings = Settings.builder().put("index.number_of_shards", 8).put("index.number_of_routing_shards", 4).build();
        final Settings settings = Settings.builder()
        for (int i = 0; i < numShards; i++) {
        final Settings emptySettings = Settings.builder()
                Settings.builder()
            assertEquals(1, applied.primaryTerm(0));
    public void testParseIndexNameSupportsDateMathPattern() {  
        assertTrue(isAllActiveIngestionEnabled);
        IndexMetadata metadata = IndexMetadata.builder("foo")  
 *
    public void testNumberOfReplicasIsNonNegative() {  
                new ShardId(metadata.getIndex(), 6),
import org.opensearch.action.admin.indices.rollover.MaxDocsCondition;  
            )  
        final XContentBuilder builder = JsonXContent.contentBuilder();  
        }  
        BytesStreamOutput out2 = new BytesStreamOutput();
        assertEquals(metadata.hashCode(), fromXContentMeta.hashCode());
            .setRoutingNumShards(32)
            + "                    \"fields\": {\n"  
            + "            \"properties\": {\n"  
            .settings(
        int numberOfReplicas = randomIntBetween(0, 10);  
                    .put("index.number_of_shards", numShards)
                        .put(defaultSettings)  
    }
            .build();
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(backslashSettings); }
        assertThat(indexMetadataAfterDiffApplied.getVersion(), equalTo(nextIndexMetadata.getVersion()));  
        final Settings settings1 = Settings.builder()
        assertEquals(metadata.getCreationDate(), fromXContentMeta.getCreationDate());
                    .build()
        RolloverInfo info1 = new RolloverInfo(
        // Bump primary term on shard 2  
        IndexMetadata after = afterBuilder.build();
        return IndexMetadata.builder(index.getName())
            .settings(
                new ShardId(metadata.getIndex(), 0),
        isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings2);  
        assertEquals(
        try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), writableRegistry())) {
            assertThat(metadata.getSettings().getAsInt(IndexMetadata.INDEX_FORMAT_SETTING.getKey(), 0), is(0));
                    .put("index.version.created", 1 ^ MASK)
        assertEquals(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int numberOfReplicas = randomIntBetween(0, 10);
    /**  
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer\\node")  
    }
    }  
            "the number of target shards (0) must be greater than the shard id: 0",  
        // all-active ingestion validations do not apply when pull-based ingestion is not enabled  
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), false)
            .putInSyncAllocationIds(0, Set.of("1", "2", "3"))
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
            assertEquals(metadata.getCustomData(), deserialized.getCustomData());  
                new ShardId(metadata.getIndex(), 4),  
        final Settings backslashSettings = Settings.builder()
        assertTrue(buildIsAppendOnly(false, true));  
    private static boolean buildIsAppendOnly(boolean pluggableDataformat, Boolean explicitAppendOnly) {
            .creationDate(randomLong())
        build = Settings.builder().put("index.number_of_shards", numShards).build();
            .build();  
            .putAlias(AliasMetadata.builder("alias-1").routing("routing-1").build())
    /**
                .settings(settings)
            assertEquals(metadata.getNumberOfShards(), deserialized.getNumberOfShards());
        });  
            settings.put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), explicitAppendOnly);
        );
                    .build()  
        final Settings settings5 = Settings.builder()
            assertEquals(metadata, deserialized);  
        int numberOfReplicas = randomIntBetween(0, 10);  
    private void runTestNumberOfShardsIsPositive(final int numberOfShards) {  
        );
            + "        \"_doc\": {\n"
        // matching version
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(noRemoteStoreSettings); }
        // Set distinct primary terms per shard
        assertFalse(isAllActiveIngestionEnabled);
        return new NamedWriteableRegistry(INDICES_MODULE.getNamedWriteables());
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
                    .put("index.number_of_replicas", numberOfReplicas)  
        final IndexMetadata fromXContentMeta = IndexMetadata.fromXContent(parser);
                new MaxAgeCondition(TimeValue.timeValueMillis(randomNonNegativeLong())),
        });  
                .numberOfReplicas(0)  
            .put("index.number_of_shards", 1)  
        final BytesStreamOutput out = new BytesStreamOutput();
            assertEquals(5, applied.primaryTerm(2));  
        afterBuilder.version(before.getVersion() + 1);  
            ),
 * this file be licensed under the Apache-2.0 license or a
        }
        }  
import org.opensearch.indices.replication.common.ReplicationType;
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
import org.opensearch.common.xcontent.json.JsonXContent;  
    }
        IndexMetadata.FORMAT.toXContent(builder, metadata);
            .system(isSystem)
        IndexMetadata metadata = builder.build();  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        IndexMetadata split = IndexMetadata.builder("foo")  
        }
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())  
import org.opensearch.test.OpenSearchTestCase;
        }
        assertTrue(e.getMessage().contains("can only be set when"));  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                        new MaxAgeCondition(TimeValue.timeValueMillis(randomNonNegativeLong())),
            Arrays.asList(  
        shard = randomIntBetween(0, numTargetShards - 1);
        customMap.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
import org.opensearch.core.xcontent.XContentParser;
 * software distributed under the License is distributed on an
        expectThrows(IllegalArgumentException.class, () -> IndexMetadata.getRoutingFactor(32, brokenNumShards));
            fromXContentMeta  
        final Settings settings3 = Settings.builder()
            () -> IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(lessThanSettings)
        diff.writeTo(out);
            for (int i = 0; i < numShards; i++) {
    public void testMissingNumberOfShards() {
                assertEquals(metadata.primaryTerm(i), deserialized.primaryTerm(i));
    public void testSelectCloneShard() {
                    .put("index.number_of_replicas", 0)
                Settings.builder()  
            () -> IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(notAFactorySettings)  
        }
            )
    }
        assertEquals(metadata.context(), fromXContentMeta.context());  
        try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), writableRegistry())) {
        assertThat(parseIndexNameCounter("shrink-logs-000003"), is(3));  
            .build();
        assertTrue(e.getMessage().contains("cannot contain path separators"));
    private static IndexMetadata createIndexMetadata(final Index index, final long version, final boolean isSystem) {  
        );  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
            + "                    \"type\": \"text\",\n"
            Collections.singleton(IndexMetadata.selectSplitShard(shard, split, numTargetShards)),  
            + "                \"allowlist\": {\n"
            }  
                new MaxDocsCondition(randomNonNegativeLong())  
            fail("Should not be able to create index with legacy created version");
            assertEquals(metadata.hashCode(), deserialized.hashCode());
        IndexMetadata.Builder builder = IndexMetadata.builder("test-primary-terms-map")  
    // Create the index metadata for a given index, with the specified version.
            )
        assertThat(
            IndexMetadata.selectRecoverFromShards(shard, shrink, numTargetShards)
    public void testSelectSplitShard() {
 * compatible open source license.
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer/node")
/*
            .build();  
            IllegalArgumentException.class,  
        final Settings settings6 = Settings.builder()
        final int numberOfReplicas = -randomIntBetween(1, Integer.MAX_VALUE);
            .putRolloverInfo(info1)
                    .put("index.number_of_shards", 32)
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), true)  
        IndexMetadata shrink = IndexMetadata.builder("foo")  
                Settings.builder()
        build = Settings.builder().put("index.number_of_shards", 5).put("index.number_of_routing_shards", 5).build();
            "the number of source shards [2] must be a factor of [3]",
        );
        assertEquals(1, shardId.getId());
                new ShardId(metadata.getIndex(), 7)  
import static org.hamcrest.Matchers.containsString;
        assertTrue(e.getMessage().contains("can only be set when"));
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Arrays;  
            + "                    \"fields\": {\n"  
        }  
    @Before
        try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), writableRegistry())) {
                .creationDate(System.currentTimeMillis())
            .putRolloverInfo(info2)
            )
        builder.startObject();
    }
        isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings5);  
            .putRolloverInfo(info1)  
package org.opensearch.cluster.metadata;
                    Settings.builder()
        xContentBuilder.startObject();
            "the number of target shards (11) must be the same as the number of source shards (10)",
        metadata.writeTo(out);  
        assertEquals(metadata.isSystem(), fromXContentMeta.isSystem());
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 8)).build();
            .numberOfReplicas(0)
                new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())),
                    .put("index.version.created", 1 ^ MASK)  
            assertThat(e.getMessage(), is("unable to parse the index name [testIndexName-000a2] to extract the counter"));  
        assertEquals(10, IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(build).intValue());
        assertEquals(metadata.getCreationVersion(), fromXContentMeta.getCreationVersion());  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                new MaxAgeCondition(TimeValue.timeValueMillis(randomNonNegativeLong())),
        }  
                Settings.builder()
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), false)
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "   ")
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectSplitShard(0, metadata, 3)).getMessage()  
        metadata1.writeVerifiableTo(checksumOut);
        assertEquals(system, metadata.isSystem());
    }
                    .build()  
        assertEquals(1, shardId.getId());  
                new ShardId(metadata.getIndex(), 31)
    public void testPrimaryTermsMapDiffRoundTrip() throws IOException {
            () -> IndexMetadata.builder("test").settings(settings).build()
                    .put("index.number_of_replicas", numberOfReplicas)
                + Strings.toString(MediaTypeRegistry.JSON, metadata)
        // Composite (pluggable-dataformat) with no explicit setting -> append-only by default.
import org.opensearch.core.xcontent.XContentBuilder;  
        isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings6);  
                    .put("index.number_of_replicas", 0)
            .settings(  
    }
        );
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(xContentBuilder));
    public void testRemoteStoreSegmentPathPrefixValidation() {  
            shardIds,
            fail("expected to fail as the index name doesn't end with digits");
import org.opensearch.core.common.io.stream.StreamInput;  
            IndexMetadata deserialized = IndexMetadata.readFrom(in);
                new RolloverInfo(
        for (int i = 0; i < numShards; i++) {  
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectSplitShard(0, metadata, 0)).getMessage()
import java.io.IOException;
            .build();
        IndexMetadata metadata1 = IndexMetadata.builder("foo")
 * this work for additional information regarding copyright
            .build();  
        super.setUp();  
        int numShards = randomIntBetween(1, 10);
        final Settings validSettings = Settings.builder()
    }
        }
        assertEquals(routingFactor * numShard, 32);
            assertEquals(metadata.getRolloverInfos(), deserialized.getRolloverInfos());
            .settings(settings)  
            IndexMetadata applied = deserializedDiff.apply(before);
        assertEquals(5, IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(build).intValue());
        assertThat(  
        );
            Sets.newHashSet(
        // all-active ingestion disabled in segment replication mode
                    .put("index.number_of_replicas", numberOfReplicas)
    }
        builder.endObject();  
            .settings(
                + Strings.toString(MediaTypeRegistry.JSON, fromXContentMeta),
                    .build()  
                    Arrays.asList(  
            )
            .settings(
        final Settings disabledSettings = Settings.builder()  
        Settings defaultSettings = Settings.builder()
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")  
            metadata,
            .putAlias(AliasMetadata.builder("alias-1").routing("routing-1").build())  
import org.opensearch.common.io.stream.BytesStreamOutput;
        );  
                + "\nactual  : "  
                Settings.builder()  
        assertEquals("writer-node-1", value);
                new MaxDocsCondition(randomNonNegativeLong())  
            .build();
        assertThat(parseIndexNameCounter(".ds-logs-000003"), is(3));
            .creationDate(randomLong())
            IndexMetadata.builder(index.getName())  
                    .put("index.number_of_shards", 4)  
    }
            Diff<IndexMetadata> deserializedDiff = IndexMetadata.readDiffFrom(in);  
    public void testPrimaryTermsMapXContentRoundTrip() throws IOException {
        String mappings = "    {\n"
                    .put("index.number_of_shards", 32)
    public void testNumberOfShardsIsNotZero() {
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
                    .put("index.number_of_replicas", 0)
        assertTrue(indexMetadataAfterDiffApplied.isSystem());
     * Test validation for pull-based ingestion all-active settings.
    }  
        );
    }
            .build();  
        int numTargetShards = randomFrom(4, 6, 8, 12);
        final IllegalArgumentException e = expectThrows(
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), true)
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards).build();
import org.opensearch.core.common.Strings;
            + "                        }\n"
            + "                },\n"  
        return createIndexMetadata(index, version, false);  
import java.util.Set;
            + "        }\n"
        String value = IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(validSettings);  
        Integer numShard = randomFrom(1, 2, 4, 8, 16);
            + "                            \"ignore_above\": 256\n"  
                    .put("index.number_of_replicas", 0)
        IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(emptySettings);
import org.opensearch.action.admin.indices.rollover.MaxAgeCondition;
            .primaryTerm(0, 2)  
        IndexMetadata metadata = builder.build();
        );  
            IllegalArgumentException.class,  
                Settings.builder()
            .build();  
            "the number of target shards (8) must be greater than the shard id: 8",  
        }  
    public void testPrimaryTermsMapStreamRoundTrip() throws IOException {
            .putInSyncAllocationIds(0, Set.of("3", "1", "2"))  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        assertEquals(
            IllegalArgumentException.class,
 *
            assertTrue(e.getCause() instanceof Version.UnsupportedVersionException);
                        .put("index.format", 6)  
            assertEquals(metadata.primaryTerm(0), deserialized.primaryTerm(0));  
 * license agreements. See the NOTICE file distributed with
            .settings(
        assertEquals("the number of source shards [2] must be a factor of [3]", iae.getMessage());
                    .put("index.number_of_replicas", numberOfReplicas)
            .creationDate(randomLong())
                        // intentionally not using the constant, so upgrading requires you to look at this test
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.core.common.bytes.BytesReference;
        assertTrue(e.getMessage().contains("cannot contain path separators"));
            IndexMetadata metadata = IndexMetadata.builder("foo").settings(Settings.builder().put(defaultSettings).build()).build();
        // all-active ingestion enabled in segment replication mode  
            + "                        \"keyword\": {\n"
                    randomNonNegativeLong()
            .version(version)
            + "            }\n"
                        .build()
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)  
                    .put("index.number_of_replicas", 0)
        e = expectThrows(
    }
    public void testMissingNumberOfReplicas() {  
        Diff<IndexMetadata> diff = new IndexMetadata.IndexMetadataDiff(previousIndexMetadata, nextIndexMetadata);  
        return IndexMetadata.builder("idx").settings(settings.build()).numberOfShards(1).numberOfReplicas(0).build().isAppendOnlyIndex();
        customMap.put(randomAlphaOfLength(10), randomAlphaOfLength(15));
        }
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
        IndexMetadata.Builder builder = IndexMetadata.builder("test-primary-terms-map-stream")  
        final Settings noRemoteStoreSettings = Settings.builder()
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                Settings.builder()
            .build();
        metadata.writeTo(out);  
import org.opensearch.index.IndexSettings;
     * Test validation for remote store segment path prefix setting
        // no setting configured
        assertEquals(metadata.getCustomData(), fromXContentMeta.getCustomData());  
            )
 * under the License.  
    }
            assertEquals(deserialized.getCustomData(), expectedCustom);
            .build();  
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
    public void testGetRoutingFactor() {
        );
        }
        afterBuilder.primaryTerm(2, 5);
        if (explicitAppendOnly != null) {
            assertEquals(after, applied);
            .setRoutingNumShards(numTargetShards * 2)  
    @Override  
import org.opensearch.Version;
public class IndexMetadataTests extends OpenSearchTestCase {  
            .numberOfShards(1)
            .putCustom("my_custom", customMap)
                        new MaxDocsCondition(randomNonNegativeLong())  
        );
        IndexMetadata before = beforeBuilder.build();
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")
        final Settings settings2 = Settings.builder()  
            .putCustom("my_custom", customMap)
            .putAlias(AliasMetadata.builder("alias-2").routing("routing-2").build())
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(colonSettings); }
    }
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer:node")
        );  
 * Licensed to Elasticsearch under one or more contributor  
        });
                    .put("index.number_of_replicas", 0)
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        Index index = new Index("test-index", UUIDs.randomBase64UUID());  
    }
 *  
                    .put("index.number_of_shards", numShard)  
    public void testNumberOfRoutingShards() {  
        );  
     */  
            )
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    }  
        assertFalse(buildIsAppendOnly(true, false));
            .creationDate(randomLong())  
        assertEquals(  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
        IndexMetadata.FORMAT.toXContent(xContentBuilder, metadata);
            .putRolloverInfo(  
        );
        customMap.put(randomAlphaOfLength(5), randomAlphaOfLength(10));  
                Settings.builder()
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectCloneShard(0, metadata, 11)).getMessage()
        try {
    public void testIsAppendOnlyIndexSettingPrecedence() {  
            .creationDate(randomLong())
            + "                    }\n"
            .putAlias(AliasMetadata.builder("alias-2").routing("routing-2").build())
        e = expectThrows(  
                    .put("index.number_of_shards", 10)
    protected NamedWriteableRegistry writableRegistry() {
            .setRoutingNumShards(numShards * 2);  
            assertEquals(metadata.getRoutingFactor(), deserialized.getRoutingFactor());
        // Stream round-trip
                .build();  
            .build();
import java.util.Collections;
        metadata2.writeVerifiableTo(checksumOut2);  
        for (int i = 0; i < numShards; i++) {
            .creationDate(randomLong())
import org.opensearch.cluster.Diff;  
 */  
        IndexMetadata metadata = IndexMetadata.builder("foo")  
 */
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
 * specific language governing permissions and limitations
            "expected: "
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)  
            + "                            \"ignore_above\": 256\n"  
        IndexMetadata previousIndexMetadata = createIndexMetadata(index, 1);
                new ShardId(metadata.getIndex(), 30),  
            )
            parseIndexNameCounter("testIndexNameWithoutDash");  
        assertEquals(0, shardId.getId());  
    private IndicesModule INDICES_MODULE = new IndicesModule(Collections.emptyList());
            assertEquals(metadata, deserialized);  
        try {
            Version.UnsupportedVersionException versionException = (Version.UnsupportedVersionException) e.getCause();
        // all-active ingestion validations do not apply when pull-based ingestion is not enabled  
        }
            .setRoutingNumShards(numShards * 2);  
            .putMapping(mappings)  
            equalTo("Failed to parse value [" + numberOfReplicas + "] for setting [index.number_of_replicas] must be >= 0")  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)  
    }  
            IllegalArgumentException.class,  
        assertEquals(numShards, IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(build).intValue());  
    }
    }
import static org.opensearch.cluster.metadata.IndexMetadata.parseIndexNameCounter;
                        // where you have to update this part and the next one
            Sets.newHashSet(  
            Sets.newHashSet(
                )
    public void testWriteVerifiableTo() throws IOException {  
        assertEquals(  
        Integer numShard = randomFrom(1, 2, 4, 8, 16);
            .build();  
            + "                \"actiongroups\": {\n"
            .setRoutingNumShards(4)  
                    .put("index.version.created", 1 ^ MASK)  
        final Settings settings4 = Settings.builder()
    }
            assertThat(metadata.getSettings().getAsInt(IndexMetadata.INDEX_FORMAT_SETTING.getKey(), 0), is(6));
        RolloverInfo info2 = new RolloverInfo(
                    .build()
        // Neither set -> default (not append-only).
    /**  
            assertEquals(metadata.getNumberOfReplicas(), deserialized.getNumberOfReplicas());  
        {
                    .build()  
        Integer brokenNumShards = randomFrom(3, 5, 9, 12, 29, 42);  
            )
            parseIndexNameCounter("testIndexName-000a2");  
        final Settings invalidPathSettings = Settings.builder()
                Settings.builder()
            IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(disabledSettings);  
    public void testLegacyCreatedVersion() {
                new ShardId(metadata.getIndex(), 1),  
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer-node-1")  
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")
                    .put("index.version.created", 1 ^ MASK)
                    .put("index.version.created", 1 ^ MASK)  
            IndexMetadata deserialized = IndexMetadata.readFrom(in);
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer-node-1")
        assertEquals(  
        shardId = IndexMetadata.selectSplitShard(1, metadata, 4);
            + "                        }\n"
            .put("index.version.created", 1 ^ MASK)
 */  
        assertFalse(isAllActiveIngestionEnabled);
                    .put("index.number_of_replicas", numberOfReplicas)  
        // Serialize and deserialize the diff
            .putRolloverInfo(info2)
        // all-active ingestion enabled with default (document) replication mode
    public void testIndexFormat() {  
import org.junit.Before;  
        assertEquals("index.number_of_routing_shards [4] must be >= index.number_of_shards [8]", iae.getMessage());
                    .build()  
        // Non-composite with an explicit true -> append-only.
            expectThrows(IllegalStateException.class, () -> IndexMetadata.selectSplitShard(0, metadata, 8)).getMessage()
                    .put("index.version.created", 1 ^ MASK)
        e = expectThrows(
            assertEquals(metadata.isSystem(), deserialized.isSystem());
            .settings(
        final Settings settings = Settings.builder()
            .setRoutingNumShards(numShards * 2);  
            beforeBuilder.primaryTerm(i, 1);
                )  
        assertEquals(metadata.getNumberOfReplicas(), fromXContentMeta.getNumberOfReplicas());
    }
import org.opensearch.common.util.set.Sets;
            assertEquals(metadata.primaryTerm(i), fromXContent.primaryTerm(i));  
    @Override
            .creationDate(randomLong())  
            randomAlphaOfLength(5),
            .creationDate(randomLong())
                    .put("index.number_of_shards", 4)
            .creationDate(randomLong())
            IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings4);
        Settings build = Settings.builder().put("index.number_of_shards", 5).put("index.number_of_routing_shards", 10).build();
    public void setUp() throws Exception {
    public void testIndexMetadataSerialization() throws IOException {
    }
        Map<String, String> customMap = new HashMap<>();
            + "                            \"type\": \"keyword\",\n"
    public void testParseIndexNameCannotFormatNumber() {
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), pluggableDataformat);  
            .system(system)
        assertThat(e.getMessage(), containsString("must specify number of replicas for index [test]"));  
            )  
            assertEquals(metadata.getCreationVersion(), deserialized.getCreationVersion());
    public void testSelectResizeShards() {  
        assertEquals(metadata.getNumberOfShards(), fromXContentMeta.getNumberOfShards());
            fail("expected to fail as the index name contains no - separator");
                    ),
        );  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                new ShardId(metadata.getIndex(), 5),
            .primaryTerm(0, 2)
            + "    }";  
    }  
    private static IndexMetadata createIndexMetadata(final Index index, final long version) {
                    .put("index.version.created", 1 ^ MASK)  
        assertFalse(buildIsAppendOnly(false, null));
            IllegalArgumentException.class,
/*  
            .build();
        Settings notAFactorySettings = Settings.builder().put("index.number_of_shards", 2).put("index.number_of_routing_shards", 3).build();  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        int numShards = 4;
    public void testNumberOfShardsIsNotNegative() {
        runTestNumberOfShardsIsPositive(-randomIntBetween(1, Integer.MAX_VALUE));  
        assertTrue(isAllActiveIngestionEnabled);  
    public void testParseIndexNameThrowExceptionWhenNoSeparatorIsPresent() {
import org.opensearch.common.settings.Settings;  
        );  
            .system(system)
                        new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())),
                .version(1)
                .system(false)  
        );
        final BytesStreamOutput out = new BytesStreamOutput();  
    public void testAllActivePullBasedIngestionSettings() {  
            .build();
        assertEquals(
     */
            .primaryTerm(1, 3)
        int shard = randomIntBetween(0, numTargetShards - 1);
            )
            builder.primaryTerm(i, randomLongBetween(1, 100));
        numTargetShards = randomFrom(1, 2, 4, 8, 16);
                Settings.builder()
            .creationDate(randomLong())
            assertEquals(metadata.context(), deserialized.context());
                new ShardId(metadata.getIndex(), 28),
            .putCustom("my_custom2", customMap)  
                    .put("index.version.created", 1 ^ MASK)  
    }
                Settings.builder()
        );  
        IllegalArgumentException iae = expectThrows(  
            ),
            e.getMessage(),
            assertEquals("ES 7.9.1", versionException.getVersionString());  
        Settings.Builder settings = Settings.builder()  
        shardIds = IndexMetadata.selectShrinkShards(7, metadata, 8);  
            .setRoutingNumShards(32)  
     * Test that changes to indices metadata are applied
            .putCustom("my_custom", customMap)
        IndexMetadata fromXContent = IndexMetadata.fromXContent(parser);
                    .build()
import org.opensearch.action.admin.indices.rollover.MaxSizeCondition;
            Arrays.asList(  
        final Settings settings = Settings.builder()
        );
            IndexMetadata.selectShrinkShards(shard, shrink, numTargetShards),
                .settings(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 8))  
            assertThat(e.getMessage(), is("no - separator found in index name [testIndexNameWithoutDash]"));  
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
            equalTo("Failed to parse value [" + numberOfShards + "] for setting [index.number_of_shards] must be >= 1")
            )
        assertTrue(e1.getMessage().contains("is not supported in pull-based ingestion"));
            + "                }\n"  
            .build();  
                    .put("index.number_of_shards", numShards)
            .build();
        int numShards = randomFrom(2, 4, 8);
        } catch (IllegalArgumentException e) {
        assertThat(e.getMessage(), containsString("must specify number of shards for index [test]"));
        return new NamedXContentRegistry(IndicesModule.getNamedXContents());
 * GitHub history for details.
        assertEquals(metadata.primaryTerm(0), fromXContentMeta.primaryTerm(0));
            IllegalArgumentException.class,
        assertEquals(0, shardId.getId());
        shardId = IndexMetadata.selectSplitShard(2, metadata, 4);  
import java.util.HashMap;
            .putCustom("my_custom2", customMap)  
            .put("index.number_of_replicas", 1)
                    randomAlphaOfLength(5),
import static org.hamcrest.Matchers.equalTo;  
            .build();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            IllegalArgumentException.class,
        );
                new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())),
