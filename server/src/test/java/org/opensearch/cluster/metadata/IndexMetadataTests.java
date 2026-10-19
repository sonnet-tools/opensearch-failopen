        });
            .build();
        assertEquals(routingFactor * numShard, 32);
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectSplitShard(0, metadata, 3)).getMessage()
                .numberOfShards(1)
 *
                Settings.builder()
            .put("index.number_of_shards", 1)
/*
import org.opensearch.core.xcontent.XContentBuilder;
                    .put("index.number_of_replicas", numberOfReplicas)
            IndexMetadata metadata = IndexMetadata.builder("foo")
        // Serialize and deserialize the diff
        );
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), true)
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
            e.getMessage(),
            assertTrue(e.getCause() instanceof Version.UnsupportedVersionException);
            beforeBuilder.primaryTerm(i, 1);
    public void testLegacyCreatedVersion() {
        IndexMetadata.FORMAT.toXContent(xContentBuilder, metadata);
import static org.opensearch.Version.MASK;
            Diff<IndexMetadata> deserializedDiff = IndexMetadata.readDiffFrom(in);
        assertEquals(metadata.getNumberOfShards(), fromXContentMeta.getNumberOfShards());
        assertEquals(0, shardId.getId());
            assertThat(metadata.getSettings().getAsInt(IndexMetadata.INDEX_FORMAT_SETTING.getKey(), 0), is(6));
        assertTrue(isAllActiveIngestionEnabled);
            .setRoutingNumShards(4)
                        // where you have to update this part and the next one
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> {
        assertFalse(buildIsAppendOnly(false, null));
 * ownership. Elasticsearch licenses this file to you under
    public void testNumberOfShardsIsNotNegative() {
        );
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(noRemoteStoreSettings); }
import org.opensearch.test.OpenSearchTestCase;
    }
        for (int i = 0; i < numShards; i++) {
    }
        IndexMetadata split = IndexMetadata.builder("foo")
                    .put("index.version.created", 1 ^ MASK)
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        assertEquals(
            () -> IndexMetadata.builder("test").settings(settings).build()
                    .put("index.number_of_replicas", numberOfReplicas)
    /**
        final Settings settings = Settings.builder()
            assertEquals(5, applied.primaryTerm(2));
        // Composite (pluggable-dataformat) with no explicit setting -> append-only by default.
        int numberOfReplicas = randomIntBetween(0, 10);
        }
        assertTrue(e.getMessage().contains("cannot contain path separators"));
            )
                new ShardId(metadata.getIndex(), 6),
        final Settings noRemoteStoreSettings = Settings.builder()
    private void runTestNumberOfShardsIsPositive(final int numberOfShards) {
        // Test empty value (should be allowed)
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectShrinkShards(8, metadata, 8)).getMessage()
        );
            .system(isSystem)
        assertEquals(1, shardId.getId());
            "the number of target shards (8) must be greater than the shard id: 8",
        final Map<String, DiffableStringMap> expectedCustom = Map.of("my_custom", new DiffableStringMap(customMap));
 * You may obtain a copy of the License at
            + "                        }\n"
            .creationDate(randomLong())
            expectThrows(IllegalStateException.class, () -> IndexMetadata.selectSplitShard(0, metadata, 8)).getMessage()
                    ),
 *     http://www.apache.org/licenses/LICENSE-2.0
            .context(new Context(randomAlphaOfLength(5)))
                    .put("index.number_of_shards", 2)
                    .put("index.number_of_shards", 4)
 *
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
            .put("index.version.created", 1 ^ MASK)
        // Bump primary term on shard 2
            IndexMetadata metadata = IndexMetadata.builder("foo").settings(Settings.builder().put(defaultSettings).build()).build();
        assertThat(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        final Settings settings3 = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
            .creationDate(randomLong())
            )
            .build();
        final XContentBuilder xContentBuilder = JsonXContent.contentBuilder();
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        expectThrows(IllegalArgumentException.class, () -> IndexMetadata.getRoutingFactor(32, brokenNumShards));
            + "                    }\n"
        final Settings settings = Settings.builder()
        });
            fail("expected to fail as the index name contains no - separator");
                    .build()
        }
        assertEquals(metadata.getCreationVersion(), fromXContentMeta.getCreationVersion());
            .build();
 */
 * software distributed under the License is distributed on an
            randomAlphaOfLength(5),
        assertEquals(metadata.context(), fromXContentMeta.context());
        );
            )
        {
            .put(IndexMetadata.SETTING_VERSION_CREATED, "7090199")
            e.getMessage(),
            .build();
        xContentBuilder.endObject();
 * specific language governing permissions and limitations
        final IllegalArgumentException e = expectThrows(
            randomNonNegativeLong()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
            shardIds,
        isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings5);
                new ShardId(metadata.getIndex(), 1),
            .build();
        }
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")
        assertTrue(e.getMessage().contains("cannot contain path separators"));
        assertEquals(metadata, fromXContent);
                Settings.builder()
import org.opensearch.indices.IndicesModule;
            assertEquals(metadata.getCreationDate(), deserialized.getCreationDate());
                    .build()
            .build();
import org.junit.Before;
            () -> IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(lessThanSettings)
import java.util.Map;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
            .creationDate(randomLong())
        assertEquals(metadata.isSystem(), fromXContentMeta.isSystem());
        IndexMetadata metadata = IndexMetadata.builder("foo")
            .putMapping(mappings)
            .creationDate(randomLong())
        assertEquals(
        customMap.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
    public void testMissingNumberOfShards() {
        RolloverInfo info2 = new RolloverInfo(
        return new NamedWriteableRegistry(INDICES_MODULE.getNamedWriteables());
                    .put("index.number_of_replicas", 0)
            )
            Collections.singleton(IndexMetadata.selectSplitShard(shard, split, numTargetShards)),
        assertFalse(isAllActiveIngestionEnabled);
        final Settings settings2 = Settings.builder()
            assertEquals(metadata.primaryTerm(0), deserialized.primaryTerm(0));
        Integer brokenNumShards = randomFrom(3, 5, 9, 12, 29, 42);
            .primaryTerm(0, 2)
        assertThat(parseIndexNameCounter(".ds-logs-000003"), is(3));
            IllegalArgumentException.class,
        return IndexMetadata.builder(index.getName())
            assertEquals(metadata, deserialized);
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            )
}
     */
import org.opensearch.core.xcontent.XContentParser;
 */
            .build();
            .build();
        {
    protected NamedXContentRegistry xContentRegistry() {
    }
    }
    protected NamedWriteableRegistry writableRegistry() {
            .settings(
        assertThat(parseIndexNameCounter("shrink-logs-000003"), is(3));
    /**
        String indexUuid = UUIDs.randomBase64UUID();
            .putRolloverInfo(info1)
        final Settings settings5 = Settings.builder()
        builder.startObject();
            assertEquals("ES 7.9.1", versionException.getVersionString());
            assertEquals(metadata.getNumberOfShards(), deserialized.getNumberOfShards());
            + "                    \"type\": \"text\",\n"
            assertEquals(metadata.getNumberOfReplicas(), deserialized.getNumberOfReplicas());
    public void testRemoteStoreSegmentPathPrefixValidation() {
            .settings(
            .build();
            + "                },\n"
        assertThat(e.getMessage(), containsString("must specify number of replicas for index [test]"));
            )
        iae = expectThrows(
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        shard = randomIntBetween(0, numTargetShards - 1);
 */
                    .put("index.number_of_replicas", numberOfReplicas)
            .putCustom("my_custom2", customMap)
            fail("Should not be able to create index with legacy created version");
        assertEquals(metadata.getNumberOfReplicas(), fromXContentMeta.getNumberOfReplicas());
    // Create the index metadata for a given index, with the specified version.
        e = expectThrows(
                    .put("index.number_of_shards", 4)
            IllegalArgumentException.class,
            .creationDate(randomLong())
        xContentBuilder.startObject();
                    .build()
        assertEquals(
            builder.primaryTerm(i, randomLongBetween(1, 100));
            + "                    \"fields\": {\n"
    }
                    .put("index.version.created", 1 ^ MASK)
        RolloverInfo info1 = new RolloverInfo(
            IllegalArgumentException.class,
 * not use this file except in compliance with the License.
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 8)).build();
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer:node")
                    .build()
        assertFalse(isAllActiveIngestionEnabled);
                new ShardId(metadata.getIndex(), 28),
    public void testSelectShrinkShards() {
            .primaryTerm(0, 2)
        afterBuilder.version(before.getVersion() + 1);
        );
        for (int i = 0; i < numShards; i++) {
        final Settings settings6 = Settings.builder()
            settings.put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), explicitAppendOnly);
        );
        );
        assertEquals(
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer-node-1")
        assertTrue(buildIsAppendOnly(false, true));
            + "                \"actiongroups\": {\n"
            assertEquals(metadata.getCreationVersion(), deserialized.getCreationVersion());
    public void testPrimaryTermsMapXContentRoundTrip() throws IOException {
            assertEquals(metadata.getRoutingNumShards(), deserialized.getRoutingNumShards());
                    .put("index.number_of_replicas", 0)
                    .build()
    }
    public void testIndicesMetadataDiffSystemFlagFlipped() {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), true)
            + "                        }\n"
            Arrays.asList(
            .putRolloverInfo(info1)
                .settings(
        Set<ShardId> shardIds = IndexMetadata.selectShrinkShards(0, metadata, 8);
    public void testParseIndexNameThrowExceptionWhenNoSeparatorIsPresent() {
            .putAlias(AliasMetadata.builder("alias-1").routing("routing-1").build())
    }
    }
        final Settings invalidPathSettings = Settings.builder()
        IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(whitespaceSettings);
        int shard = randomIntBetween(0, numTargetShards - 1);
        }
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        });
        int numTargetShards = randomFrom(4, 6, 8, 12);
                    .put("index.number_of_shards", 10)
        metadata1.writeVerifiableTo(checksumOut);
        int numShards = 4;
                    .put("index.version.created", 1 ^ MASK)
        );
        shardId = IndexMetadata.selectSplitShard(1, metadata, 4);
        numTargetShards = randomFrom(1, 2, 4, 8, 16);
            .build();
        assertTrue(e.getMessage().contains("cannot contain path separators"));
            .setRoutingNumShards(32)
            IndexMetadata.builder(index.getName())
        );
            + "    }";
    }
    public void setUp() throws Exception {
        try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), writableRegistry())) {
            .build();
        final Settings whitespaceSettings = Settings.builder()
        final BytesStreamOutput out = new BytesStreamOutput();
        final Settings validSettings = Settings.builder()
        int numberOfReplicas = randomIntBetween(0, 10);
        final Settings emptySettings = Settings.builder()
import static org.hamcrest.Matchers.equalTo;
                Settings.builder()
        int numShards = randomIntBetween(1, 10);
import org.opensearch.core.common.Strings;
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            + "                    \"type\": \"text\",\n"
    }
        final Settings backslashSettings = Settings.builder()
                new MaxDocsCondition(randomNonNegativeLong())
        IndexMetadata metadata = builder.build();
            + "                            \"ignore_above\": 256\n"
    public void testSelectCloneShard() {
        IndexMetadata nextIndexMetadata = createIndexMetadata(index, 2, true);
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")
        assertTrue(e.getMessage().contains("can only be set when"));
            () -> IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(notAFactorySettings)
            .settings(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testIndexFormat() {
            () -> IndexMetadata.builder("test").settings(settings).build()
    }
                .system(false)
                new ShardId(metadata.getIndex(), 30),
        shardIds = IndexMetadata.selectShrinkShards(1, metadata, 8);
    public void testParseIndexNameCannotFormatNumber() {
        IndexMetadata metadata = IndexMetadata.builder("foo")
    }
            .creationDate(randomLong())
        assertEquals(
            )
                    .put("index.version.created", 1 ^ MASK)
                Settings.builder()
    }
        );
        // Stream round-trip
        assertEquals(
        super.setUp();
            + "                            \"ignore_above\": 256\n"
            .setRoutingNumShards(numShards * 2);
        final Settings colonSettings = Settings.builder()
        assertTrue(indexMetadataAfterDiffApplied.isSystem());
        Map<String, String> customMap = new HashMap<>();
        runTestNumberOfShardsIsPositive(-randomIntBetween(1, Integer.MAX_VALUE));
        // all-active ingestion disabled in document replication mode
    }
import static org.hamcrest.Matchers.containsString;
                    .put("index.version.created", 1 ^ MASK)
        IllegalArgumentException iae = expectThrows(
            .putCustom("my_custom", customMap)
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
        }
 * under the License.
            "the number of source shards [2] must be a factor of [3]",
        metadata.writeTo(out);
            shardIds,
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), true)
                    .put("index.number_of_shards", 32)
            Version.UnsupportedVersionException versionException = (Version.UnsupportedVersionException) e.getCause();
                    .put("index.number_of_shards", 32)
        customMap.put(randomAlphaOfLength(10), randomAlphaOfLength(15));
            builder.primaryTerm(i, randomLongBetween(1, 100));
    /**
        // no setting configured
            .system(system)
            .putCustom("my_custom", customMap)
        IndexMetadata after = afterBuilder.build();
            .build();
import org.opensearch.common.io.stream.BytesStreamOutput;
        final boolean system = randomBoolean();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
                    .put("index.number_of_shards", numShard)
        e = expectThrows(
        IndexMetadata.Builder builder = IndexMetadata.builder("test-primary-terms-map")
        Diff<IndexMetadata> diff = new IndexMetadata.IndexMetadataDiff(before, after);
        assertThat(
            .settings(settings)
            .build();
        shardId = IndexMetadata.selectSplitShard(2, metadata, 4);
        IndexMetadata shrink = IndexMetadata.builder("foo")
        return createIndexMetadata(index, version, false);
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards).build();
            assertEquals(metadata.getCustomData(), deserialized.getCustomData());
 * The OpenSearch Contributors require contributions made to
        assertEquals("writer-node-1", value);
                    .build()
import org.opensearch.action.admin.indices.rollover.MaxDocsCondition;
        try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), writableRegistry())) {
        final int numberOfReplicas = -randomIntBetween(1, Integer.MAX_VALUE);
        Integer numShard = randomFrom(1, 2, 4, 8, 16);
        assertEquals(metadata.getCreationDate(), fromXContentMeta.getCreationDate());
            .system(system)
            .putCustom("my_custom2", customMap)
        IndexMetadata.FORMAT.toXContent(builder, metadata);
                .settings(settings)
            .version(version)
            .creationDate(randomLong())
            .system(system)
            + "                    }\n"
            )
        );
        try {
            + "                \"allowlist\": {\n"
        final BytesStreamOutput out = new BytesStreamOutput();
            .build();
                    Settings.builder()
            Sets.newHashSet(
        final IndexMetadata fromXContentMeta = IndexMetadata.fromXContent(parser);
        final Settings settings1 = Settings.builder()
            .creationDate(metadata1.getCreationDate())
        final Settings settings4 = Settings.builder()
                .version(1)
        final boolean system = randomBoolean();
        assertEquals(5, IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(build).intValue());
                    .put("index.number_of_replicas", 0)
            .putRolloverInfo(info2)
    private static IndexMetadata createIndexMetadata(final Index index, final long version, final boolean isSystem) {
            .settings(
        assertEquals(system, metadata.isSystem());
        diff.writeTo(out);
                        // intentionally not using the constant, so upgrading requires you to look at this test
            .primaryTerm(1, 3)
                    .put("index.number_of_replicas", 0)
        );
            .primaryTerm(0, 2)
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), false)
        );
        assertEquals(metadata.getCustomData(), expectedCustom);
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            .creationDate(randomLong())
/*
            ),
        customMap.put(randomAlphaOfLength(10), randomAlphaOfLength(15));
                Settings.builder()
    @Before
        e = expectThrows(
        );
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), false)
                        .put(defaultSettings)
        );
        build = Settings.builder().put("index.number_of_shards", numShards).build();
        // all-active ingestion enabled with default (document) replication mode
        assertTrue(buildIsAppendOnly(true, null));
    public void testSelectResizeShards() {
            IllegalArgumentException.class,
            .setRoutingNumShards(numShards * 2);
        assertTrue(isAllActiveIngestionEnabled);
                    .put("index.version.created", 1 ^ MASK)
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            + "                        \"keyword\": {\n"
        }
        );
        String value = IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(validSettings);
        assertEquals(metadata.getRoutingNumShards(), fromXContentMeta.getRoutingNumShards());
        Settings notAFactorySettings = Settings.builder().put("index.number_of_shards", 2).put("index.number_of_routing_shards", 3).build();
        } catch (IllegalArgumentException e) {
        // Set distinct primary terms per shard
            "expected: "
     * Test validation for pull-based ingestion all-active settings.
            .creationDate(randomLong())
    public void testIndexMetadataSerialization() throws IOException {
                        .put("index.format", 6)
            .creationDate(System.currentTimeMillis())
                    .put("index.number_of_replicas", 0)
                Settings.builder()
                )
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "   ")
            IndexMetadata.selectRecoverFromShards(shard, shrink, numTargetShards)
    }
        assertEquals(
        assertThat(parseIndexNameCounter("<logs-{now/d}-1>"), is(1));
        );
    }
                new ShardId(metadata.getIndex(), 4),
            .putInSyncAllocationIds(0, Set.of("3", "1", "2"))
                .build();
            + "        }\n"
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(xContentBuilder));
            IllegalArgumentException.class,
            IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings4);
                    .build()
                Settings.builder()
            assertThat(metadata.getSettings().getAsInt(IndexMetadata.INDEX_FORMAT_SETTING.getKey(), 0), is(0));
    }
            .numberOfShards(1)
            IndexMetadata deserialized = IndexMetadata.readFrom(in);
                + Strings.toString(MediaTypeRegistry.JSON, metadata)
    @Override
            IllegalArgumentException.class,
        isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings2);
            )
        isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings6);
            Sets.newHashSet(
        final Settings disabledSettings = Settings.builder()
import static org.hamcrest.Matchers.is;
                new RolloverInfo(
            .settings(
            .build();
            .build();
                )
            randomNonNegativeLong()
            assertEquals(metadata.context(), deserialized.context());
                    Arrays.asList(
    private static boolean buildIsAppendOnly(boolean pluggableDataformat, Boolean explicitAppendOnly) {
            .build();
        // all-active ingestion validations do not apply when pull-based ingestion is not enabled
            randomAlphaOfLength(5),
            .build();
            .putMapping(mappings)
import org.opensearch.common.settings.Settings;
        );
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
                    .put("index.number_of_replicas", 0)
                    .put("index.number_of_replicas", numberOfReplicas)
            .settings(
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), false)
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer-node-1")
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectSplitShard(0, metadata, 0)).getMessage()
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer\\node")
        assertEquals("index.number_of_routing_shards [4] must be >= index.number_of_shards [8]", iae.getMessage());
            .setRoutingNumShards(32)
        Settings.Builder settings = Settings.builder()
                new ShardId(metadata.getIndex(), 0),
        return IndexMetadata.builder("idx").settings(settings.build()).numberOfShards(1).numberOfReplicas(0).build().isAppendOnlyIndex();
        IndexMetadata metadata = builder.build();
            .build();
            .build();
    public void testPrimaryTermsMapStreamRoundTrip() throws IOException {
                        new MaxDocsCondition(randomNonNegativeLong())
            )
            + "                }\n"
            + "            }\n"
        );
/*
        // Neither set -> default (not append-only).
                        .build()
            .creationDate(randomLong())
    private IndicesModule INDICES_MODULE = new IndicesModule(Collections.emptyList());
            ),
        Settings defaultSettings = Settings.builder()
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 8))
            assertEquals(metadata.isSystem(), deserialized.isSystem());
    }
        build = Settings.builder().put("index.number_of_shards", 5).put("index.number_of_routing_shards", 5).build();
        assertEquals(1, shardId.getId());
        );
public class IndexMetadataTests extends OpenSearchTestCase {
            IndexMetadata.selectShrinkShards(shard, shrink, numTargetShards),
            + "        \"_doc\": {\n"
        try {
        boolean isAllActiveIngestionEnabled = IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings1);
        Index index = new Index("test-index", UUIDs.randomBase64UUID());
    public void testIsAppendOnlyIndexSettingPrecedence() {
        IndexMetadata metadata1 = IndexMetadata.builder("foo")
            .putAlias(AliasMetadata.builder("alias-1").routing("routing-1").build())
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> IndexMetadata.builder("test").build());
                    .put("index.number_of_shards", numShards)
            assertEquals(metadata.hashCode(), deserialized.hashCode());
import org.opensearch.common.UUIDs;
import java.io.IOException;
 * this work for additional information regarding copyright
        IndexMetadata fromXContent = IndexMetadata.fromXContent(parser);
        } catch (IllegalArgumentException e) {
        // matching version
        runTestNumberOfShardsIsPositive(0);
            )
 * license agreements. See the NOTICE file distributed with
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        return new NamedXContentRegistry(IndicesModule.getNamedXContents());
                    .put("index.version.created", 1 ^ MASK)
            IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings3);
    }
    }
                        new MaxAgeCondition(TimeValue.timeValueMillis(randomNonNegativeLong())),
            )
        customMap.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
import org.opensearch.core.xcontent.MediaTypeRegistry;
                new ShardId(metadata.getIndex(), 7)
            + "                            \"type\": \"keyword\",\n"
    }
        assertFalse(buildIsAppendOnly(true, false));
    public void testGetRoutingFactor() {
        Map<String, String> customMap = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
                new MaxAgeCondition(TimeValue.timeValueMillis(randomNonNegativeLong())),
            .putInSyncAllocationIds(0, Set.of("1", "2", "3"))
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer-node-1")
                new ShardId(metadata.getIndex(), 3)
    public void testNumberOfShardsIsNotZero() {
                    randomNonNegativeLong()
    }
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
            .build();
            assertThat(e.getMessage(), is("unable to parse the index name [testIndexName-000a2] to extract the counter"));
            IndexMetadata deserialized = IndexMetadata.readFrom(in);
                    .build()
            assertEquals(after, applied);
        IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(emptySettings);
            Arrays.asList(
            IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(disabledSettings);
        IndexMetadata.selectRecoverFromShards(0, shrink, 32);
        assertEquals(0, shardId.getId());
            expectThrows(IllegalArgumentException.class, () -> IndexMetadata.selectCloneShard(0, metadata, 11)).getMessage()
        final BytesStreamOutput out = new BytesStreamOutput();
        int numberOfReplicas = randomIntBetween(0, 10);
        IndexMetadata.Builder builder = IndexMetadata.builder("test-primary-terms-map-stream")
    }
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
        if (explicitAppendOnly != null) {
            .build();
 * KIND, either express or implied.  See the License for the
    }
                    .put("index.number_of_shards", numShards)
        afterBuilder.primaryTerm(2, 5);
        }
            IllegalArgumentException.class,
import org.opensearch.index.IndexSettings;
    public void testNumberOfReplicasIsNonNegative() {
            + "            \"properties\": {\n"
            () -> IndexMetadata.builder("test").settings(settings).build()
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        IndexMetadata indexMetadataAfterDiffApplied = diff.apply(previousIndexMetadata);
        IndexMetadata metadata = IndexMetadata.builder("foo")
            .build();
import org.opensearch.Version;
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), pluggableDataformat);
            + "                            \"type\": \"keyword\",\n"
    }
        IndexMetadata.Builder afterBuilder = IndexMetadata.builder(before);
            "the number of routing shards [4] must be a multiple of the target shards [8]",
        // XContent round-trip
            equalTo("Failed to parse value [" + numberOfReplicas + "] for setting [index.number_of_replicas] must be >= 0")
        );
    public void testMissingNumberOfReplicas() {
import org.opensearch.cluster.Diff;
            assertEquals(deserialized.getCustomData(), expectedCustom);
        assertEquals(metadata.primaryTerm(0), fromXContentMeta.primaryTerm(0));
        assertEquals(
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")
        Integer numShard = randomFrom(1, 2, 4, 8, 16);
        e = expectThrows(
            parseIndexNameCounter("testIndexName-000a2");
 * Licensed to Elasticsearch under one or more contributor
                new ShardId(metadata.getIndex(), 29),
                .build();
        // Non-composite with an explicit true -> append-only.
        int routingFactor = IndexMetadata.getRoutingFactor(32, numShard);
            .settings(
        BytesStreamOutput out2 = new BytesStreamOutput();
    private static IndexMetadata createIndexMetadata(final Index index, final long version) {
        Index index = new Index("test-index", indexUuid);
import java.util.Collections;
 *
            fromXContentMeta
        IndexMetadata before = beforeBuilder.build();
import org.opensearch.core.index.Index;
            fail("expected to fail as the index name doesn't end with digits");
                    .build()
                + Strings.toString(MediaTypeRegistry.JSON, fromXContentMeta),
        assertEquals(
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(backslashSettings); }
        int numShards = randomFrom(2, 4, 8);
        metadata.writeTo(out);
                Settings.builder()
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
import org.opensearch.common.util.set.Sets;
        Diff<IndexMetadata> diff = new IndexMetadata.IndexMetadataDiff(previousIndexMetadata, nextIndexMetadata);
        for (int i = 0; i < numShards; i++) {
        IndexMetadata previousIndexMetadata = createIndexMetadata(index, 1);
        int numberOfReplicas = randomIntBetween(0, 10);
            assertThat(e.getMessage(), is("no - separator found in index name [testIndexNameWithoutDash]"));
            )
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(invalidPathSettings); }
                + "\nactual  : "
            + "                        \"keyword\": {\n"
            .numberOfReplicas(0)
    }
        }
                    .put("index.number_of_shards", 2)
import org.opensearch.indices.replication.common.ReplicationType;
                new MaxAgeCondition(TimeValue.timeValueMillis(randomNonNegativeLong())),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .putAlias(AliasMetadata.builder("alias-2").routing("routing-2").build())
        assertEquals(
        shardIds = IndexMetadata.selectShrinkShards(7, metadata, 8);
        metadata2.writeVerifiableTo(checksumOut2);
            .setRoutingNumShards(numTargetShards * 2)
                new MaxDocsCondition(randomNonNegativeLong())
        }
        } catch (IllegalArgumentException e) {
        assertThat(indexMetadataAfterDiffApplied.getVersion(), equalTo(nextIndexMetadata.getVersion()));
    }
                    .put("index.number_of_replicas", numberOfReplicas)
import java.util.Arrays;
        assertEquals("the number of source shards [2] must be a factor of [3]", iae.getMessage());
        // all-active ingestion enabled in segment replication mode
    }
                .creationDate(System.currentTimeMillis())
            IllegalArgumentException.class,
        assertEquals(metadata.getCustomData(), fromXContentMeta.getCustomData());
                    .put("index.number_of_shards", numShards)
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "")
        assertTrue(e1.getMessage().contains("is not supported in pull-based ingestion"));
    public void testNumberOfRoutingShards() {
            )
            assertEquals(metadata.getRoutingFactor(), deserialized.getRoutingFactor());
package org.opensearch.cluster.metadata;
            .settings(
        assertEquals(metadata.hashCode(), fromXContentMeta.hashCode());
            .build();
            .settings(
import static org.opensearch.cluster.metadata.IndexMetadata.parseIndexNameCounter;
            + "                    \"fields\": {\n"
    public void testAllActivePullBasedIngestionSettings() {
            parseIndexNameCounter("testIndexNameWithoutDash");
        int numShards = randomFrom(2, 4, 8);
            .setRoutingNumShards(32)
import java.util.HashMap;
                new ShardId(metadata.getIndex(), 5),
import org.opensearch.common.unit.TimeValue;
                    .build()
            .put(IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.getKey(), "kafka")
import org.opensearch.core.common.io.stream.StreamInput;
        for (int i = 0; i < numShards; i++) {
import org.opensearch.action.admin.indices.rollover.MaxSizeCondition;
            .put(IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey(), "writer/node")
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
                new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())),
    }
            "the number of target shards (0) must be greater than the shard id: 0",
        final IllegalArgumentException e = expectThrows(
            .putRolloverInfo(
        assertEquals(
            assertEquals(1, applied.primaryTerm(0));
    }
        final IllegalArgumentException e = expectThrows(
                    .put("index.version.created", 1 ^ MASK)
            .put("index.number_of_replicas", 1)
                Settings.builder()
    public void testParseIndexNameReturnsCounter() {
            assertEquals(metadata.primaryTerm(i), fromXContent.primaryTerm(i));
        assertEquals(10, IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(build).intValue());
        // all-active ingestion validations do not apply when pull-based ingestion is not enabled
        }
    }
     * Test validation for remote store segment path prefix setting
 * Modifications Copyright OpenSearch Contributors. See
        Settings build = Settings.builder().put("index.number_of_shards", 5).put("index.number_of_routing_shards", 10).build();
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> {
 * compatible open source license.
    }
                    .build()
            IndexMetadata applied = deserializedDiff.apply(before);
            assertEquals(metadata, deserialized);
            metadata,
            "the number of target shards (11) must be the same as the number of source shards (10)",
     */
            .settings(
import org.opensearch.core.common.bytes.BytesReference;
            equalTo("Failed to parse value [" + numberOfShards + "] for setting [index.number_of_shards] must be >= 1")
    public void testParseIndexNameSupportsDateMathPattern() {
        // all-active ingestion disabled in segment replication mode
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        assertTrue(e2.getMessage().contains("is not supported in pull-based ingestion"));
        }
                    .put("index.version.created", 1 ^ MASK)
        Settings lessThanSettings = Settings.builder().put("index.number_of_shards", 8).put("index.number_of_routing_shards", 4).build();
                new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())),
                        new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())),
                new ShardId(metadata.getIndex(), 2),
        assertTrue(e.getMessage().contains("can only be set when"));
     */
        }
        builder.endObject();
            .putRolloverInfo(info2)
                Settings.builder()
    @Override
            .build();
                    .put("index.version.created", 1 ^ MASK)
        IndexMetadata.Builder beforeBuilder = IndexMetadata.builder("test-diff")
            () -> { IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(colonSettings); }
                new ShardId(metadata.getIndex(), 31)
        IndexMetadata metadata2 = IndexMetadata.builder(metadata1.getIndex().getName())
            Sets.newHashSet(
            .put(IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey(), false)
            .settings(
        shardId = IndexMetadata.selectSplitShard(3, metadata, 4);
        IndexMetadata metadata = IndexMetadata.builder("foo")
        try {
        assertEquals(numShards, IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(build).intValue());
            shardIds,
            assertEquals(metadata.getRolloverInfos(), deserialized.getRolloverInfos());
                assertEquals(metadata.primaryTerm(i), deserialized.primaryTerm(i));
            .setRoutingNumShards(numShards * 2);
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
import org.opensearch.action.admin.indices.rollover.MaxAgeCondition;
        BytesStreamOutput out = new BytesStreamOutput();
        String mappings = "    {\n"
        // Composite with an explicit false -> NOT append-only (opts in to updates/deletes).
        try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), writableRegistry())) {
        }
            .putAlias(AliasMetadata.builder("alias-2").routing("routing-2").build())
        final Settings settings = Settings.builder()
            .putCustom("my_custom", customMap)
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
                    randomAlphaOfLength(5),
            IllegalArgumentException.class,
import org.opensearch.core.common.unit.ByteSizeValue;
            }
            for (int i = 0; i < numShards; i++) {
    public void testSelectSplitShard() {
                Settings.builder()
            .primaryTerm(1, 3)
                    .put("index.version.created", 1 ^ MASK)
     * Test that changes to indices metadata are applied
                .numberOfReplicas(0)
        assertNotNull(metadata1.toString());
            IndexMetadata.selectRecoverFromShards(shard, split, numTargetShards)
            .build();
 * Unless required by applicable law or agreed to in writing,
    public void testWriteVerifiableTo() throws IOException {
        final XContentBuilder builder = JsonXContent.contentBuilder();
        );
import java.util.Set;
        assertEquals(metadata.getRoutingFactor(), fromXContentMeta.getRoutingFactor());
        assertThat(e.getMessage(), containsString("must specify number of shards for index [test]"));
        ShardId shardId = IndexMetadata.selectSplitShard(0, metadata, 4);
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.index.shard.ShardId;
            .build();
    public void testPrimaryTermsMapDiffRoundTrip() throws IOException {
            )
 * GitHub history for details.
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
