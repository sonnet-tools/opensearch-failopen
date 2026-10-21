                ).numberOfShards(1).numberOfReplicas(1)
            Exception ex = expectThrows(
    ) {
                    + "'"
import java.io.IOException;
        + "}";
        Metadata metadata = createIndices(5, 10, "foo-datastream").metadata;
                    + "] could create backing indices that conflict with 1 existing index(s) or alias(s) including '"
            int numBackingIndices = randomIntBetween(1, 4);
        builder = IndexGraveyard.builder(metadata1.indexGraveyard());
            .transientSettings(Settings.builder().put("other_setting" + randomAlphaOfLength(3), randomAlphaOfLength(4)).build())
            assertThat(aliasMetadataList.size(), equalTo(2));
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                .build();
            assertEquals("Unexpected field [random]", e.getMessage());
        final Metadata metadata3 = Metadata.builder(metadata1).clusterUUIDCommitted(!metadata1.clusterUUIDCommitted()).build();
import static org.opensearch.cluster.DataStreamTestHelper.createFirstBackingIndex;
            assertThat(dataStreams.get(backingIndex.getName()).getName(), equalTo(dataStreamName));
        IndexMetadata invalidIdx = createBackingIndex(dataStreamName, 2).build();
        assertThat(dataStreams.size(), equalTo(numBackingIndices));
            }
            .put(
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
            lastBackingIndexNum = randomIntBetween(lastBackingIndexNum + 1, lastBackingIndexNum + 50);
        Metadata metadata = Metadata.builder()
            assertLeafs(keyProperties, "keyword");
                        Settings.builder().put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
        }
        // adding new index - all indices lookups should get re-computed
    }
import static org.hamcrest.Matchers.notNullValue;
        assertEquals(metadata.resolveIndexRouting(null, "index"), null);
        }
                "index, alias, and data stream names need to be unique, but the following duplicates were found [data "
                IndexMetadata indexMeta = createBackingIndex(dataStreamName, i).build();
        Metadata.Builder metadataBuilder = Metadata.builder().put(indexMetadataBuilder);
        {
            randomNonNegativeLong(),
                new String[] { "index1", "index2" },
        // don't expect any exception when validating a system without indices that would conflict with future backing indices
        final BytesStreamOutput out = new BytesStreamOutput();
        + "          }\n"
            Map<String, Object> value = (Map<String, Object>) propertiesProperties.get("value");
        + "            },\n"
        verify(spyBuilder, times(1)).buildMetadataWithRecomputedIndicesLookups();
        assertEquals(3, sourceAsMap.size());
            Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");
 * compatible open source license.
        originalMeta.writeTo(out);
        );
        );
        final int numBackingIndices = randomIntBetween(2, 5);
            .clusterUUIDCommitted(randomBoolean())
            assertEquals(previousMetadata.getConcreteVisibleOpenIndices(), newMetadata.getConcreteVisibleOpenIndices());
            if (i % 2 == 0 && i < generations) {
        if (checkVersionIncrement == true) {
            .numberOfShards(1)
                MapperPlugin.NOOP_FIELD_FILTER
            .build();
        );
                }
        }
                index -> field -> (index.equals("index3") && field.endsWith("keyword"))
            .clusterUUID("uuid" + randomAlphaOfLength(3))
    private static CreateIndexResult createIndices(int numIndices, int numBackingIndices, String dataStreamName) {
        }
            .settings(builder)
            assertNotNull(indicesLookup.get(index.getName()).getParentDataStream());
        DataStreamMetadata dataStreamMetadata = new DataStreamMetadata(Map.of(dataStreamName, dataStream));
            assertNotSame(originalMappingMetadata, mappingMetadata);
                    + dataStreamName
        for (int i = 1; i <= generations; i++) {
        } catch (Exception e) {
            b.put(new DataStream(name, createTimestampField("@timestamp"), indices, indices.size()));
            assertIndexMappingsNotFiltered(mappings, "index1");
        while (nodes.size() < size) {
        assertEquals(previousMetadata.coordinationMetadata(), newMetadata.coordinationMetadata());
        + "              \"type\": \"text\",\n"
        orig.writeTo(out);
            assertEquals(1, valueProperties.size());
import static org.hamcrest.Matchers.startsWith;
        final Metadata metadata;
        // alias with multiple indices
        assertThat(
        + "              \"fields\": {\n"
        );
        assertEquals(2, address.size());
        // aliases with multiple indices
                IndexMetadata.builder("index")
        } catch (IllegalArgumentException ex) {
        + "  }\n"
    }
            .put(
            .put("index_template_v2_" + randomAlphaOfLength(3), ComposableIndexTemplateTests.randomInstance());
                        Settings.builder()
 * specific language governing permissions and limitations
        + "        \"age\": {\n"
                    )
    }
                    + conflictingIndex
            .build();
            MappingMetadata mappingMetadata = mappings.get("index1");
        }
        Metadata.Builder b = Metadata.builder();
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));
                    )
        BytesReference metadata = BytesReference.bytes(
        assertTrue(metadata.isSegmentReplicationEnabled(indexName));
            randomVotingConfigExclusions()
            assertNotNull(docMapping);
        for (Index index : result.backingIndices) {
            randomVotingConfig(),
        + "          }\n"
        );
                    .numberOfReplicas(0)
        // alias with index routing.
                    .putAlias(AliasMetadata.builder("alias1").build())
        AliasMetadata.Builder aliasZeroBuilder = AliasMetadata.builder("alias0");
        builtMetadata = spyBuilder.indices(
            }
            bWriteIndex = randomFrom(Boolean.TRUE, Boolean.FALSE, null);
    public void testXContentClusterUUID() throws IOException {
        + "          \"properties\": {\n"
            .numberOfReplicas(1);
 * not use this file except in compliance with the License.
    }
                    .settings(
        verify(spyBuilder, times(1)).buildMetadataWithRecomputedIndicesLookups();
            assertTrue(properties.containsKey("type"));
            .numberOfShards(1)
        } catch (IllegalStateException e) {
            metadata.resolveIndexRouting("0", "alias1");
        Metadata metadataTwoIndices = Metadata.builder(metadata).put(builder2).build();
    private static void assertIndexMappingsNotFiltered(final Map<String, MappingMetadata> mappings, String index) {
            backingIndices.add(idx);
            exception.getMessage(),
                )
        Metadata metadata = Metadata.builder().put(buildIndexMetadata(indexA, alias, aWriteIndex)).build();
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        final int numBackingIndices = randomIntBetween(2, 5);
        spyBuilder = spy(Metadata.builder(previousMetadata));
        final Map<String, IndexAbstraction.DataStream> dataStreams = result.metadata.findDataStreams(concreteIndices);
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);
        try {
            dataStreamName,
                    .patterns(Arrays.asList("bar-*", "foo-*"))
        for (int k = 1; k <= numBackingIndices; k++) {
            .transientSettings(Settings.builder().put(setting.getKey(), "transient-value").build())
                .numberOfReplicas(1)
            try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        Metadata metadata = Metadata.builder()
        Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");
                "data stream ["
                new IndexMetadata.Builder(dataStreamName + randomAlphaOfLength(10)).settings(settings(Version.CURRENT))
        if (randomBoolean()) {
            .put(validIdx, false)
        + "  \"_doc\": {\n"
            Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");
            final Map<String, MappingMetadata> mappings = metadata.findMappings(
            )
    }
        + "              \"tree\": \"quadtree\",\n"
        final Metadata metadata2 = Metadata.builder(metadata1).indexGraveyard(builder.build()).build();
        final String dataStreamName = "my-data-stream";
            )
 */
            Metadata.Builder.fromXContent(parser);
        assertEquals(1, name.size());
        {
        + "      \"_source\": {\n"
        final Metadata metadata2 = Metadata.builder(metadata1).clusterUUID(UUIDs.randomBase64UUID()).build();
    }
                index -> field -> randomBoolean()
            randomVotingConfig(),
        Map<String, Object> subFieldsDef = (Map<String, Object>) fieldProp.get("fields");
            is(
            IndexMetadata im = IndexMetadata.builder(DataStream.getDefaultBackingIndexName(dataStreamName, lastBackingIndexNum))
                IndexMetadata.builder("index2")
        Metadata metadata = Metadata.builder(createIndices(10, 10, dataStreamName).metadata)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        String indexB = randomAlphaOfLength(7);
/*
            });
            .put(
        int generations = 10;
        });
 */
    }
            .put(IndexMetadata.builder("foo-index").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
 * Licensed to Elasticsearch under one or more contributor
        }
    }
            aliasZeroBuilder.writeIndex(false);
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        {
                .numberOfShards(1)
        assertEquals(metadata.resolveWriteIndexRouting(null, "index"), null);
            assertEquals(2, addressProperties.size());
        // when only one index/alias pair exist
        final Metadata.Builder builder = Metadata.builder();
        MappingMetadata docMapping = mappings.get(index);
        Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
    public static Metadata randomMetadata() {
            assertThat(fromXContentMeta.indexGraveyard(), equalTo(originalMeta.indexGraveyard()));
            assertEquals(3, sourceAsMap.size());
        final Metadata.Builder builder = Metadata.builder();
}
    }
        DataStream dataStream = DataStreamTests.randomInstance();
        assertEquals(2, propertiesProperties.size());
            assertEquals(1, value.size());
            fail();
        + "        \"name\": {\n"
            List<AliasMetadata> aliasMetadataList = aliases.get("index");
            assertEquals(previousMetadata.getConcreteVisibleIndices(), newMetadata.getConcreteVisibleIndices());
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            // for the indices that we added in the data stream with a "shrink-" prefix, add the non-prefixed indices to the lookup
            )
            assertEquals(previousMetadata.getCustoms().get(DataStreamMetadata.TYPE), newMetadata.getCustoms().get(DataStreamMetadata.TYPE));
                e.getMessage(),
        final Metadata metadata = Metadata.builder()
        final Metadata originalMeta = Metadata.builder().indexGraveyard(graveyard).build();
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        );
import java.util.HashMap;
            assertNotNull(propertiesProperties);
                builder.map(doc);
        Exception exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting("0", "alias1"));
            List<AliasMetadata> aliasMetadataList = aliases.get("index");
        assertTrue("metadata equal when not adding index deletions", Metadata.isGlobalStateEquals(metadata2, metadata3));
        validateDataStreams(metadata.getIndicesLookup(), (DataStreamMetadata) metadata.customs().get(DataStreamMetadata.TYPE));
        }
        AliasMetadata.Builder aliasZeroBuilderTwo = AliasMetadata.builder("alias0");
            assertTrue(sourceAsMap.containsKey("_routing"));
            fail("should fail");
            assertThat(
            .get("index");
                new String[] { "index1", "index2", "index3" },
        verify(spyBuilder, times(0)).buildMetadataWithRecomputedIndicesLookups();
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
            )
            .coordinationMetadata(coordinationMetadata1)
        );
                    .putAlias(AliasMetadata.builder("alias2").build())
                if (index.equals("index2")) {
        {
            indicesLookup.put(indexMeta.getIndex().getName(), new IndexAbstraction.Index(indexMeta, dataStreamAbstraction));
    }
 * this file be licensed under the Apache-2.0 license or a
            new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)
        for (int i = 0; i < properAliases; i++) {
                    .build()
        }
    public void testIndexAndAliasWithSameName() {
        assertEquals(7, typeProperties.size());
                    )
            );
            assertNotNull(fieldProp);
        + "        },\n"
            assertThat(aliasMetadataList.size(), equalTo(2));
            MappingMetadata docMapping = mappings.get("index1");
            assertNotNull(typeProperties);
    public void testFindAliasWithExclusion() {
        for (int i = 0; i < numberOfTemplates; i++) {
            Metadata.builder().put(metaA).put(metaB).build();
        Metadata.Builder b = Metadata.builder();
    private static CoordinationMetadata.VotingConfiguration randomVotingConfig() {
        final List<Index> backingIndices;
        builder.addTombstone(new Index("idx1", UUIDs.randomBase64UUID()));
            assertIndexMappingsNoFields(mappings, "index2");
            .numberOfReplicas(0)
    }
        assertThat(exception.getMessage(), startsWith("Alias [alias0] has more than one index associated with it"));
        }
        CreateIndexResult(List<Index> indices, List<Index> backingIndices, Metadata metadata) {
            IndexMetadata idx = createBackingIndex(dataStreamName, i).build();
    }
            assertThat(aliases.size(), equalTo(0));
        assertTrue(sourceAsMap.containsKey("_routing"));
import org.opensearch.indices.replication.common.ReplicationType;
            assertEquals(previousMetadata.getIndicesLookup(), newMetadata.getIndicesLookup());
        {
        // create some indices that do not back a data stream
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
                equalTo(DataStream.getDefaultBackingIndexName(name, ds.getGeneration()))
        final XContentBuilder builder = JsonXContent.contentBuilder();
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        String dataStreamName = "foo-datastream";
        assertThat(metadata.dataStreams().size(), equalTo(numDataStreams));
            metadataBuilder.put(indexBuilder);
        assertEquals(metadata.resolveWriteIndexRouting(null, "alias1"), "1");
    }
        String indexA = randomAlphaOfLength(6);
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                new GetAliasesRequest("alias1"),
        + "          }\n"
                    .putAlias(AliasMetadata.builder("ab").build())
            Map<String, Object> fieldProp = (Map<String, Object>) properties.get(field);
        assertTrue(typeProperties.containsKey("birth"));
            final CoordinationMetadata fromXContentMeta = Metadata.fromXContent(parser).coordinationMetadata();
            randomNonNegativeLong(),
        + "      },"
            () -> validateDataStreams(indicesLookup, dataStreamMetadata)
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        validateDataStreams(metadata.getIndicesLookup(), (DataStreamMetadata) metadata.customs().get(DataStreamMetadata.TYPE));
            assertThat(aliases.size(), equalTo(1));
            is("index/alias [alias2] provided with routing value [1,2] that resolved to several routing values, rejecting operation")
    public void testValidateAliasWriteOnly() {
        try {
    }
 *
        }
        TemplatesMetadata templatesMetadata1 = TemplatesMetadata.builder()
            .putAlias(AliasMetadata.builder("alias2").routing("1,2").build());
        validateDataStreams(metadata.getIndicesLookup(), (DataStreamMetadata) metadata.customs().get(DataStreamMetadata.TYPE));
            final Map<String, MappingMetadata> mappings = metadata.findMappings(
        }
import static org.opensearch.cluster.metadata.Metadata.Builder.validateDataStreams;
            assertLeafs(propertiesProperties, "key");
            assertNotNull(propertiesProperties);
        verify(spyBuilder, times(0)).buildMetadataWithRecomputedIndicesLookups();
            );
            aliasToIndices.put(randomAlphaOfLength(5), new HashSet<>(randomSubsetOf(randomIntBetween(1, 3), indices)));
        // don't expect any exception when validating against non-backing indices that don't conform to the backing indices naming
        assertThat(metadata.dataStreams().get(dataStreamName).getName(), equalTo(dataStreamName));
        assertTrue(sourceAsMap.containsKey("_routing"));
        final boolean compareTemplates,
            assertTrue(nodes.add(new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10))));
                    + " (alias of ["
    }
    @SuppressWarnings("unchecked")
                    + "]) conflicts with data stream]"
        assertEquals(previousMetadata.settings(), newMetadata.settings());
    @SuppressWarnings("unchecked")
            .build();
        + "        },\n"
        assertEquals(previousMetadata.hashesOfConsistentSettings(), newMetadata.hashesOfConsistentSettings());
    }
            builder.put(
            assertThat(dataStreams.containsKey(backingIndex.getName()), is(true));
    }
            assertIndexMappingsNoFields(mappings, "index1");
    public void testMetadataGlobalStateChangesOnClusterUUIDChanges() {
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        CoordinationMetadata coordinationMetadata1 = new CoordinationMetadata(
            }
                request.replaceAliases(Strings.EMPTY_ARRAY);
        // verify that new write index is used
        // convention
        spyBuilder = spy(Metadata.builder(previousMetadata));
        assertTrue(address.containsKey("type"));
                    .putMapping(mapping)
        + "        },\n"
            assertThat(aliasMetadataList.size(), equalTo(2));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            metadata.resolveIndexRouting(null, "alias2");
        compareMetadata(previousMetadata, builtMetadata, true, true, true);
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).putAlias(AliasMetadata.builder(dataStreamName).build()).build();
    public void testSerializationWithIndexGraveyard() throws IOException {
                    return field -> false;
        assertLeafs(nameProperties, "first", "last");
        + "                \"keyword\" : {\n"
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        originalMeta.writeTo(out);
            )
                )
        final String indexName = "test";
        + "              \"type\": \"keyword\"\n"
            String name = "data-stream-" + i;
            final Map<String, MappingMetadata> mappings = metadata.findMappings(
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            assertNotNull(name);
        final Setting setting = Setting.simpleString("key");
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);
        assertTrue(typeProperties.containsKey("suggest"));
        {
            randomVotingConfig(),
        final Metadata fromStreamMeta = Metadata.readFrom(
            Map<String, Object> sourceAsMap = mappingMetadata.getSourceAsMap();
        + "                }\n"
        CreateIndexResult result = createIndices(numIndices, numBackingIndices, dataStreamName);
        @SuppressWarnings("unchecked")
    public void testTransientSettingsOverridePersistentSettings() {
        );
            assertThat(fromXContentMeta, equalTo(originalMeta));
        return md.build();
        final Metadata fromStreamMeta = Metadata.readFrom(
            IndexMetadata im = IndexMetadata.builder(DataStream.getDefaultBackingIndexName("index", lastIndexNum))
                    settings(Version.CURRENT)
            .indexGraveyard(IndexGraveyardTests.createRandom())
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        compareMetadata(Metadata.EMPTY_METADATA, builtMetadata, true, true, false);
        IndexGraveyard.Builder builder = IndexGraveyard.builder();
        Metadata.Builder spyBuilder;
        assertEquals(3, addressProperties.size());
        Metadata metadata = Metadata.builder()
        + "            },\n"
            Map<String, Object> key = (Map<String, Object>) propertiesProperties.get("key");
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            .version(randomNonNegativeLong())
                IndexMetadata.builder(dataStreamName).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1).build(),
        }
            .build();
            .numberOfReplicas(0)
        if (compareIndicesLookups == true && compareTemplates == true) {
        String mapping = FIND_MAPPINGS_TEST_ITEM;
        }
        assertTrue(Metadata.isGlobalStateEquals(metadata1, metadata1));
            IndexAbstraction value = metadata.getIndicesLookup().get(name);
 * the Apache License, Version 2.0 (the "License"); you may
        // no alias, no index
        final String conflictingIndex = DataStream.getDefaultBackingIndexName(dataStreamName, 2);
        + "            \"street\": {\n"
            "_doc",
                    .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())
        final Metadata fromStreamMeta = Metadata.readFrom(
        assertEquals(metadata.resolveIndexRouting(null, "alias0"), null);
        + "          \"type\": \"nested\",\n"
                is(
        Index index = standaloneIndexConflictingWithBackingIndices.getIndex();
            .build();
                    + dataStreamName
                        + "and was provided with routing value [0], rejecting operation"
        Metadata.FORMAT.toXContent(builder, originalMeta);
        }
            )
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(typeProperties.containsKey("ip"));
            List<AliasMetadata> aliasMetadataList = aliases.get("index");
            b.put(im, false);
        Metadata metadata = b.build();
        assertThat(indicesLookup.size(), equalTo(result.indices.size() + result.backingIndices.size() + 1));
        builder.endObject();
    }
            .putAlias(AliasMetadata.builder("alias0").build())
            assertTrue(typeProperties.containsKey("suggest"));
                    )
                IndexMetadata.builder(index).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1).build()
        IndexMetadata.Builder indexBMeta = IndexMetadata.builder(indexBName)
        assertTrue(properties.containsKey(field));
            assertEquals(1, mappings.size());
            assertTrue(sourceAsMap.containsKey("_routing"));
        List<AliasMetadata> aliases = metadata.findAliases(new GetAliasesRequest().aliases("a*", "-*b", "b*"), new String[] { "index" })
                IndexMetadata.builder("index1")
import org.opensearch.test.OpenSearchTestCase;
        }
            metadata.resolveIndexRouting("1", "alias2");
            is("index/alias [alias4] provided with routing value [1,2] that resolved to several routing values, rejecting operation")
            assertEquals(previousMetadata.templates(), newMetadata.templates());
            .numberOfReplicas(0)
        Metadata metadata = Metadata.builder().coordinationMetadata(originalMeta).build();
            Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
                    + "'"
                    .numberOfReplicas(1)
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
        final Metadata orig = randomMetadata();
            .build();
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            .putAlias(AliasMetadata.builder("alias3").writeIndex(false).build())
        assertThat(metadata1.templates(), is(templatesMetadata1.getTemplates()));
        );
            final Metadata fromXContentMeta = Metadata.fromXContent(parser);
            assertTrue(address.containsKey("type"));
        final Metadata originalMeta = Metadata.builder().indexGraveyard(graveyard).build();
        Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
                        Settings.builder()
        assertMultiField(propertiesProperties, "value", "keyword");
            assertEquals(1, name.size());
                    + dataStreamName
            assertEquals(2, mappings.size());
            is("index/alias [alias2] provided with routing value [1,2] that resolved to several routing values, rejecting operation")
                    .patterns(Arrays.asList("bar-*", "foo-*"))
        + "    }\n"
        List<AliasMetadata> aliases = metadata.findAliases(new GetAliasesRequest().aliases("*", "-alias1"), new String[] { "index" })
        // manually building the indices lookup as going through Metadata.Builder#build would trigger the validate method and would fail
        builtMetadata = spyBuilder.version(previousMetadata.version() + 1).build();
            assertIndexMappingsNoFields(mappings, "index2");
        return IndexMetadata.builder(name)
            .numberOfShards(1)
        compareMetadata(previousMetadata, builtMetadata, false, true, true);
                is(
    }
        }
            illegalStateException.getMessage(),
    public void testXContentWithTemplateMetadata() throws IOException {
        );
            .put(
                new String[] { "index1" },
        }
            assertEquals(1, keyProperties.size());
        IndexAbstraction.DataStream dataStreamAbstraction = new IndexAbstraction.DataStream(dataStream, backingIndices);
        + "      },"
        assertThat(fromStreamMeta.clusterUUID(), equalTo(originalMeta.clusterUUID()));
        // adding new templates - indices lookups should not get recomputed
        + "            \"value\" : {\n"
            randomVotingConfig(),
            .build();
        assertEquals(metadata.resolveIndexRouting("0", "alias0"), "0");
        try {
        assertEquals(metadata.resolveWriteIndexRouting("0", null), "0");
            assertThat(aliases.size(), equalTo(1));
        for (String alias : randomSubsetOf(randomIntBetween(1, 10), indices)) {
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(validIdx.getIndex())));
        final String key = randomAlphaOfLength(10);
        final int numIndices = randomIntBetween(2, 5);
            .numberOfShards(1)
            )
                    .putMapping(mapping)
        final List<Index> backingIndices = new ArrayList<>();
        final String conflictingName = DataStream.getDefaultBackingIndexName(dataStreamName, 2);
        List<Index> allIndices = new ArrayList<>(result.indices);
        final Metadata metadata3 = Metadata.builder(metadata2).build();
            .coordinationMetadata(coordinationMetadata2)
        );
        }
            DataStream ds = metadata.dataStreams().get(name);
        if (compareTemplates == true) {
        verify(spyBuilder, times(0)).buildMetadataWithPreviousIndicesLookups();
        if (randomBoolean()) {
        final int size = randomIntBetween(0, 10);
        assertTrue(Metadata.isGlobalStateEquals(orig, fromStreamMeta));
        {
        + "              \"fields\": {\n"
        + "          \"properties\": {\n"
 *
            if (i % 2 == 0 && i < generations) {
        }
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
        if (compareIndicesLookups == true) {
        + "            }\n"
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        assertThat(fromStreamMeta.clusterUUIDCommitted(), equalTo(originalMeta.clusterUUIDCommitted()));
        assertThat(expectThrows(NullPointerException.class, () -> builder.putCustom(key, null)).getMessage(), containsString(key));
            assertThat(ex.getMessage(), containsString("has is_hidden set to true on indices"));
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
        final String dataStreamName = "my-data-stream";
            .put(
        }
                () -> buildMetadataWithHiddenIndexMix(alias, indexA, true, indexB, randomFrom(false, null)).build()
    public void testFindAliasWithExclusionAndOverride() {
        spyBuilder = spy(Metadata.builder());
import org.opensearch.core.common.Strings;
        {
            assertThat(fromXContentMeta.clusterUUIDCommitted(), equalTo(originalMeta.clusterUUIDCommitted()));
        int indexCount = randomIntBetween(10, 100);
import static org.mockito.Mockito.reset;
                    .numberOfShards(1)
                    .numberOfShards(1)
            backingIndices.size()
                    .putMapping(FIND_MAPPINGS_TEST_ITEM)
    public void testGlobalStateEqualsCoordinationMetadata() {
        assertNotNull(nameProperties);
            md.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
            .put(
        for (int k = 1; k <= numIndices; k++) {
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
        for (int i = 1; i <= generations; i++) {
    public void testFindAliases() {
        for (int i = 1; i <= generations; i++) {
                IndexMetadata.builder("index")
                    .settings(
                    + "'"
            String name = "data-stream-" + i;
                        Settings.builder()
        final Metadata metadata4 = Metadata.builder(metadata2).clusterUUID(metadata1.clusterUUID()).build();
import static org.hamcrest.Matchers.equalTo;
                        + "of [index]) conflicts with index]"
            .numberOfReplicas(0)
        final int numBackingIndices = randomIntBetween(2, 5);
        + "                \"keyword\" : {\n"
            .put("index_template_v2_new_" + randomAlphaOfLength(3), ComposableIndexTemplateTests.randomInstance())
    }
            assertThat(aliasMetadataList.get(1).alias(), equalTo("alias2"));
        int numDataStreams = randomIntBetween(2, 8);
            is("Alias [alias1] has index routing associated with it [1], and was provided with routing value [0], rejecting operation")
            .putAlias(AliasMetadata.builder("alias2").writeIndex(true).build());
        }
            IndexMetadata im = IndexMetadata.builder(DataStream.getDefaultBackingIndexName(dataStreamName, lastBackingIndexNum))
        int lastBackingIndexNum = 0;
            .putAlias(AliasMetadata.builder("alias1").routing("1").build())
        assertThat(aliases.get(0).alias(), equalTo("aa"));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.util.set.Sets;
                    .patterns(Arrays.asList("bar-*", "foo-*"))
                return MapperPlugin.NOOP_FIELD_PREDICATE;
            backingIndices.add(im.getIndex());
        builder.endObject();
        // when alias points to two indices, but valid
                    .settings(
            assertEquals("Unexpected field [random]", e.getMessage());
import static org.mockito.Mockito.spy;
            assertThat(aliases.size(), equalTo(1));
        // index, no alias
        CoordinationMetadata originalMeta = new CoordinationMetadata(
            );
            e.getMessage(),
import java.util.Collections;
        + "        \"ip\": {\n"
        Metadata.Builder metadataBuilder = Metadata.builder();
                        && field.equals("age") == false
            exception.getMessage(),
            Collections.singletonMap(
        assertNotNull(properties);
            .build();
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);
    private void verifyTemplatesMetadata(TemplatesMetadata templatesMetadata) throws IOException {
        }
        + "            \"location\": {\n"
            );
        String aliasName,
            .hashesOfConsistentSettings(Map.of("b", "a"))
            .putAlias(AliasMetadata.builder("alias4").routing("1,2").writeIndex(true).build());
        Metadata metadata = Metadata.builder(createIndices(10, 10, dataStreamName).metadata)
    }
            IndexMetadata.Builder metaB = buildIndexMetadata(indexB, alias, true);
            assertNotNull(nameProperties);
            MappingMetadata mappingMetadata = mappings.get("index1");
        Metadata metadata = metadataBuilder.build();
    public void testValidateDataStreamsAllowsNamesThatStartsWithPrefix() {
        builtMetadata = spyBuilder.put("component_template_new_" + randomAlphaOfLength(3), ComponentTemplateTests.randomInstance())
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertNotNull(addressProperties);
    public static void assertMultiField(Map<String, Object> properties, String field, String... subFields) {
        + "        },\n"
import org.opensearch.Version;
            assertNull(indicesLookup.get(index.getName()).getParentDataStream());
    private static class CreateIndexResult {
 * under the License.
            );
    }
        builder.addTombstone(new Index("idx2", UUIDs.randomBase64UUID()));
                IndexMetadata.builder("index1")
public class MetadataTests extends OpenSearchTestCase {
        final String dataStreamName = "my-data-stream";
        + "            \"first\": {\n"
    private static void compareMetadata(
            .put(
        Metadata.FORMAT.toXContent(builder, metadata);
        assertTrue(Metadata.isGlobalResourcesMetadataEquals(metadata1, metadata2));
            assertEquals(2, propertiesProperties.size());
            assertThat(value.isHidden(), is(false));
        // no alias, no index
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            aliasToIndices.put(alias, new HashSet<>(randomSubsetOf(randomIntBetween(1, 3), indices)));
        assertNotNull(address);
                    + dataStreamName
        Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");
                    .numberOfShards(1)
        Boolean indexAHidden,
            )
            )
        final Map<String, Metadata.Custom> mapBuilder = new HashMap<>();
            assertThat(
            fail("did not expect exception when validating a system without any data streams but got " + e.getMessage());
        int lastBackingIndexNum = 0;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            JsonXContent.contentBuilder().startObject().startObject("index_name").field("random", "value").endObject().endObject()
        builtMetadata = spyBuilder.build();
        assertNotNull(propertiesProperties);
        for (int i = 0; i < numDataStreams; i++) {
            Map<String, Object> sourceAsMap = docMapping.getSourceAsMap();
        }
        assertThat("0", equalTo(metadataTwoIndices.resolveWriteIndexRouting("0", "alias1")));
        if (randomBoolean()) {
        BytesReference metadata = BytesReference.bytes(
            .numberOfShards(1)
            lastIndexNum = randomIntBetween(lastIndexNum + 1, lastIndexNum + 50);
            spyBuilder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(backingIndex));
        Metadata.Builder b = Metadata.builder()
            randomVotingConfigExclusions()
        }
            assertEquals(previousMetadata.getConcreteAllClosedIndices(), newMetadata.getConcreteAllClosedIndices());
        + "                  \"type\" : \"keyword\"\n"
        assertTrue(sourceAsMap.containsKey("_source"));
        Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");
                idx = createBackingIndex(dataStreamName, i).build();
            Map<String, Object> keyProperties = (Map<String, Object>) key.get("properties");
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata3));
import java.util.TreeMap;
            e.getMessage(),
                () -> buildMetadataWithHiddenIndexMix(alias, indexA, randomFrom(false, null), indexB, true).build()
    public void testValidateDataStreamsAllowsPrefixedBackingIndices() {
            IndexMetadata.Builder metaA = buildIndexMetadata(indexA, alias, true);
            MappingMetadata mappingMetadata = mappings.get("index3");
        assertTrue(typeProperties.containsKey("age"));
        }
                        && field.equals("address.location") == false;
            .put("component_template_" + randomAlphaOfLength(3), ComponentTemplateTests.randomInstance())
                    .settings(
        builder.endObject();
    }
            );
            assertLeafs(valueProperties, "keyword");
    }
        assertLeafs(subFieldsDef, subFields);
        Metadata metadata = Metadata.builder()
                    "Alias [alias1] has index routing associated with it [1], "
            this.indices = indices;
            .put(idx, false)
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
    public void testValidateHiddenAliasConsistency() {
            } else {
        }
            assertTrue(properties.containsKey("type"));
        assertThat(
            JsonXContent.contentBuilder().startObject().startObject("meta-data").field("random", "value").endObject().endObject()
            Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
    }
        );
    private static final String FIND_MAPPINGS_TEST_ITEM = "{\n"
            this.metadata = metadata;
                .numberOfShards(1)
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        }
        CoordinationMetadata coordinationMetadata2 = new CoordinationMetadata(
                }
            randomVotingConfig(),
        DataStream dataStream = new DataStream(
            .clusterUUID(randomAlphaOfLength(11))
            assertThat(value, notNullValue());
    public void testIsSegmentReplicationEnabled() {
            );
import org.opensearch.core.index.Index;
    public void testValidateDataStreamsIgnoresIndicesWithoutCounter() {
            );
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata2));
            backingIndices.add(idx);
        assertEquals(metadata.resolveWriteIndexRouting("0", "index"), "0");
    public void testSerializationClusterUUID() throws IOException {
            assertEquals(previousMetadata.getCustoms(), newMetadata.getCustoms());
        assertThat(metadata.dataStreams().size(), equalTo(1));
            );
        final XContentBuilder builder = JsonXContent.contentBuilder();
            assertThat(
        Metadata metadata2 = Metadata.builder(metadata1).templates(templatesMetadata2).build();
        verifyTemplatesMetadata(templatesMetadata2);
        Metadata.Builder md = Metadata.builder()
        + "            \"key\" : {\n"
    }
    }
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .build();
        );
        final XContentBuilder builder = JsonXContent.contentBuilder();
    public void testGlobalResourcesStateEqualsCoordinationMetadata() {
                )
            assertEquals(previousMetadata.getConcreteVisibleClosedIndices(), newMetadata.getConcreteVisibleClosedIndices());
            assertEquals(2, properties.size());
        {
        }
import org.opensearch.common.io.stream.BytesStreamOutput;
        {
            .numberOfShards(1)
        verifyTemplatesMetadata(templatesMetadata);
            .settings(settings(Version.CURRENT))
        + "        \"required\":true\n"
            .putAlias(AliasMetadata.builder("alias1").routing("0").writeIndex(true).build())
                "data stream [foo-datastream] could create backing indices that conflict with 1 existing index(s) or alias(s) "
    public void testFindDataStreams() {
    public void testValidateDataStreamsForNullDataStreamMetadata() {
            randomVotingConfig(),
        for (Index index : randomDataStream.getIndices()) {
import org.opensearch.common.xcontent.json.JsonXContent;
        // alias with invalid index routing.
        // manually building the indices lookup as going through Metadata.Builder#build would trigger the validate method already
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(metadata.resolveIndexRouting("0", null), "0");
            assertEquals(previousMetadata.getConcreteAllOpenIndices(), newMetadata.getConcreteAllOpenIndices());
            final Map<String, MappingMetadata> mappings = metadata.findMappings(Strings.EMPTY_ARRAY, MapperPlugin.NOOP_FIELD_FILTER);
            )
                    .numberOfReplicas(0)
            assertEquals(1, key.size());
        Metadata builtMetadata;
    }
        Metadata metadata = b.build();
            assertThat(aliases.size(), equalTo(0));
            assertIndexMappingsNoFields(mappings, "index1");
        Metadata metadata = Metadata.builder().put(builder).build();
            if (randomBoolean()) {
    public void testFindMappings() throws IOException {
            .clusterUUID(UUIDs.randomBase64UUID())
            )
        Map<String, Set<String>> aliasToIndices = new HashMap<>();
        }
        assertEquals(metadata.resolveIndexRouting("0", "index"), "0");
        List<IndexMetadata> backingIndices = new ArrayList<>(generations);
            );
    }
        IndexMetadata.Builder builder = IndexMetadata.builder("index")
                    .putMapping(originalMappingMetadata)
            assertThat(e.getMessage(), startsWith("index, alias, and data stream names need to be unique"));
        for (int i = 0; i < indexCount; i++) {
        return new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(randomInt(10), 20, false)));
    }
                .build();
    private static IndexMetadata.Builder buildIndexMetadata(String name, String alias, Boolean writeIndex) {
        + "        \"enabled\":false\n"
        + "        \"birth\": {\n"
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(idx.getIndex())));
            .clusterUUID(UUIDs.randomBase64UUID())
                    .putAlias(AliasMetadata.builder("bb").build())
            .put(
        );
        Metadata.Builder b = Metadata.builder();
            final Map<String, List<AliasMetadata>> aliases = metadata.findAllAliases(Strings.EMPTY_ARRAY);
    }
            new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)
            .put(invalidIdx, false)
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;
    public void testBuilderRejectsDataStreamWithConflictingBackingAlias() {
            assertIndexMappingsNoFields(mappings, "index3");
                    .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())
            .build();
            .build();
            indices.add(im.getIndex());
            .numberOfShards(1)
            assertThat(
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata2));
        );
            assertTrue(properties.containsKey(field));
        assertThat(
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, metadata)) {
    public void testBuilderRejectsDataStreamThatConflictsWithIndex() {
        Boolean indexBHidden
                    .build()
    }
                    .putAlias(AliasMetadata.builder("alias2").build())
        final String indexName = "test";
            new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)
        Boolean bWriteIndex;
        // alias with no index routing
                indices.add(idx.getIndex());
        for (Index backingIndex : dataStream.getIndices()) {
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(
        assertFalse("metadata not equal after adding index deletions", Metadata.isGlobalStateEquals(metadata1, metadata2));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
        // when too many write indices
        final TemplatesMetadata templatesMetadata2 = getTemplatesMetadata(2);
        Metadata.Builder b = Metadata.builder()
            });
            assertEquals(0, mappings.size());
        + "        \"suggest\" : {\n"
                "data stream ["
                    .patterns(Arrays.asList(randomAlphaOfLength(3) + "-*"))
            assertThat(fromXContentMeta.templates(), equalTo(originalMeta.templates()));
            assertThat(ex.getMessage(), containsString("has is_hidden set to true on indices"));
                .numberOfReplicas(1)
        Metadata metadata2 = Metadata.builder().coordinationMetadata(coordinationMetadata2).build();
                    .putMapping(FIND_MAPPINGS_TEST_ITEM)
            indices.add(randomAlphaOfLength(10));
            containsString(
                .build();
 *
            )
                new GetAliasesRequest("alias*"),
                new String[] { "index" }
        Metadata metadata2 = Metadata.builder()
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(new GetAliasesRequest(), Strings.EMPTY_ARRAY);
            assertNotNull(properties);
        + "                }\n"
            randomNonNegativeLong(),
        b.put(new DataStream(dataStreamName, createTimestampField("@timestamp"), backingIndices, lastBackingIndexNum));
            fail("should fail");
 * this work for additional information regarding copyright
                "index, alias, and data stream names need to be unique, but the following duplicates were found ["
            assertTrue(typeProperties.containsKey("birth"));
        }
        Metadata.Builder b = Metadata.builder()
            final Map<String, List<AliasMetadata>> aliases = metadata.findAllAliases(new String[] { "index" });
            exception.getMessage(),
        // add the offending index to the indices lookup
            .put(
        Metadata metadata = Metadata.builder()
                    .numberOfShards(1)
            b.put(im, false);
 *     http://www.apache.org/licenses/LICENSE-2.0
            .putAlias(aliasZeroBuilderTwo.build())
        }
            final Map<String, MappingMetadata> mappings = metadata.findMappings(new String[] { "index1", "index2", "index3" }, index -> {
            .putAlias(AliasMetadata.builder("alias2").routing("1,2").build())
                    return field -> field.startsWith("name.") == false
    ) {
import java.util.Set;
    }
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                indicesLookup.put(indexMeta.getIndex().getName(), new IndexAbstraction.Index(indexMeta, dataStreamAbstraction));
            )
        Metadata metadata = Metadata.builder()
        + "      \"properties\": {\n"
            )
import java.util.List;
        if (Boolean.TRUE.equals(aWriteIndex)) {
                        + " resolved to several routing values, rejecting operation"
        try {
        // adding new data stream - indices lookups should get re-computed
                    + "] conflicts with index]"
            assertNotNull(properties);
        + "          \"type\": \"integer\"\n"
        assertThat(
                ex.getMessage(),
        b.put(new DataStream(dataStreamName, createTimestampField("@timestamp"), backingIndices, lastBackingIndexNum));
                    + conflictingName
        for (int i = 0; i < numDataStreams; i++) {
        verify(spyBuilder, times(1)).buildMetadataWithPreviousIndicesLookups();
            .build();
        assertThat(fromStreamMeta.indexGraveyard(), equalTo(fromStreamMeta.indexGraveyard()));
                IndexMetadata.builder("index1")
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(new GetAliasesRequest(), new String[] { "index" });
        final Metadata originalMeta = Metadata.builder()
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting(randomFrom("1", null), "alias4"));
            .clusterUUIDCommitted(false)
        reset(spyBuilder);
        // one of the following combinations: [(null, null), (null, true), (null, false), (false, false)]
            Map<String, Object> stringObjectMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, FIND_MAPPINGS_TEST_ITEM, false);
    private Metadata.Builder buildMetadataWithHiddenIndexMix(
        assertNotNull(fieldProp);
        Metadata.Builder metadataBuilder = Metadata.builder().put(indexMetadataBuilder);
        }
            assertEquals(2, properties.size());
 * Modifications Copyright OpenSearch Contributors. See
import java.util.SortedMap;
    }
        assertEquals(previousMetadata.transientSettings(), newMetadata.transientSettings());
        assertTrue(fieldProp.containsKey("fields"));
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            .build();
        // additional text before number
 * You may obtain a copy of the License at
                new String[] { "index" }
                ex.getMessage(),
        CoordinationMetadata coordinationMetadata2 = new CoordinationMetadata(
            randomVotingConfigExclusions()
        final IndexGraveyard graveyard = IndexGraveyardTests.createRandom();
        final Set<VotingConfigExclusion> nodes = new HashSet<>(size);
        allIndices.addAll(result.backingIndices);
        int properAliases = randomIntBetween(0, 3);
        + "                  \"type\" : \"keyword\"\n"
                .numberOfShards(1)
                    .numberOfReplicas(1)
        verify(spyBuilder, times(1)).buildMetadataWithPreviousIndicesLookups();
import static org.hamcrest.Matchers.containsString;
                    .numberOfReplicas(1)
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .get("index");
            .put(
                    .build()
            final Metadata fromXContentMeta = Metadata.fromXContent(parser);
        final Metadata metadata1 = Metadata.builder().indexGraveyard(builder.build()).build();
        builtMetadata = spyBuilder.put(dataStream).version(previousMetadata.version() + 1).build();
                IndexMetadata idx = createBackingIndex(name, j).build();
        IndexMetadata.Builder builder2 = IndexMetadata.builder("index2")
                .numberOfShards(1)
    public void testBuilderForDataStreamWithRandomlyNumberedBackingIndices() {
        String indexBName,
import static org.hamcrest.Matchers.is;
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).putAlias(new AliasMetadata.Builder(conflictingName)).build();
                if (value.contains(index)) {
        final Metadata previousMetadata = randomMetadata();
        final BytesStreamOutput out = new BytesStreamOutput();
        IndexMetadata.Builder builder = IndexMetadata.builder("index")
        @SuppressWarnings("unchecked")
            .numberOfReplicas(1);
        }
import java.util.Arrays;
                request = new GetAliasesRequest(randomFrom("alias1", "alias2"));
                    .settings(
        IndexMetadata standaloneIndexConflictingWithBackingIndices = createBackingIndex(dataStreamName, 2 * generations).build();
        );
            assertEquals(1, typeProperties.size());
    }
        }
    public void testXContentWithCoordinationMetadata() throws IOException {
        // no changes in builder method after initialization from previous Metadata - indices lookups should not be re-computed
    }
            .numberOfReplicas(0);
        } catch (IllegalStateException e) {
        assertTrue(Metadata.isGlobalStateEquals(metadata1, metadata4));
        + "          \"type\": \"date\"\n"
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(idx.getIndex())));
        IndexMetadata.Builder builder = IndexMetadata.builder("index")
            this.backingIndices = backingIndices;
        assertNotNull(docMapping);
        assertNotNull(name);
import java.util.ArrayList;
            .numberOfReplicas(0)
                    "index/alias [alias2] provided with routing value [1,2] that"
            randomVotingConfigExclusions()
        String[] concreteIndices = allIndices.stream().map(Index::getName).collect(Collectors.toList()).toArray(new String[] {});
            fail("exception should have been thrown");
    public void testBuilderRejectsNullInCustoms() {
            .hashesOfConsistentSettings(Map.of("a", "b"))
        SortedMap<String, IndexAbstraction> indicesLookup = result.metadata.getIndicesLookup();
        for (int k = 1; k <= numBackingIndices; k++) {
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));
        Metadata metadata1 = Metadata.builder().coordinationMetadata(coordinationMetadata1).build();
        {
        for (Index backingIndex : result.backingIndices) {
            .put(
            .build();
        final TemplatesMetadata templatesMetadata = getTemplatesMetadata(0);
            } else {
            assertEquals(2, propertiesProperties.size());
        final Metadata metadata1 = Metadata.builder().clusterUUID(UUIDs.randomBase64UUID()).clusterUUIDCommitted(randomBoolean()).build();
    public void testValidateDataStreamsThrowsExceptionOnConflict() {
        spyBuilder = spy(Metadata.builder(previousMetadata));
        assertTrue(Metadata.isGlobalStateEquals(metadata1, metadata1));
        }
        spyBuilder = spy(Metadata.builder(previousMetadata));
        IndexAbstraction.DataStream dataStreamAbstraction = new IndexAbstraction.DataStream(dataStream, backingIndices);
            metadataBuilder.build();
                .numberOfReplicas(1)
        final String dataStreamName = "my-data-stream";
            randomVotingConfig(),
            assertIndexMappingsNotFiltered(mappings, "index1");
            .creationDate(randomNonNegativeLong())
        assertLeafs(addressProperties, "street", "location", "area");
        CoordinationMetadata coordinationMetadata1 = new CoordinationMetadata(
                .numberOfReplicas(0);
            .put(buildIndexMetadata("index", "alias", randomBoolean() ? null : randomBoolean()).build(), randomBoolean())
            .putAlias(AliasMetadata.builder(alias).writeIndex(writeIndex))
                mapping = builder.toString();
                    indexBuilder.putAlias(AliasMetadata.builder(key).build());
        final boolean compareIndicesLookups,
        assertEquals(previousMetadata.clusterUUIDCommitted(), newMetadata.clusterUUIDCommitted());
        Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
        Metadata metadata = Metadata.builder().put(builder).build();
            validateDataStreams(metadata.getIndicesLookup(), null);
                .settings(settings(Version.CURRENT))
            }
        final String dataStreamName = "my-data-stream";
                    + "stream ["
        assertThat(
        IndexMetadata.Builder indexAMeta = IndexMetadata.builder(indexAName)
            randomNonNegativeLong(),
            Exception ex = expectThrows(
            final Map<String, MappingMetadata> mappings = metadata.findMappings(
        assertThat(aliases.get(0).alias(), equalTo("alias2"));
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testSerialization() throws IOException {
            final GetAliasesRequest request;
            assertTrue(sourceAsMap.containsKey("_source"));
 * Unless required by applicable law or agreed to in writing,
                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
            Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");
        + "          \"type\": \"ip\"\n"
        }
        for (String index : indices) {
                    .putAlias(AliasMetadata.builder("aa").build())
            );
            assertThat(value.getType(), equalTo(IndexAbstraction.Type.DATA_STREAM));
                is(
            assertMultiField(propertiesProperties, "value", "keyword");
import org.opensearch.common.settings.Settings;
        );
                    .putMapping(mapping)
        {
import org.opensearch.cluster.ClusterModule;
import org.opensearch.common.settings.Setting;
import org.opensearch.core.common.bytes.BytesReference;
        // alias with invalid index routing.
            assertThat(ds, notNullValue());
        assertTrue(typeProperties.containsKey("ip"));
        + "            \"last\": {\n"
        }
    }
        assertEquals(2, nameProperties.size());
import java.util.HashSet;
        mapBuilder.put(key, null);
            .clusterUUIDCommitted(randomBoolean())
            containsString(
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting("1", "alias2"));
 * ownership. Elasticsearch licenses this file to you under
    private static void assertIndexMappingsNoFields(final Map<String, MappingMetadata> mappings, String index) {
                        && field.startsWith("properties.key.") == false
        return builder.build();
        return nodes;
        }
            IndexMetadata.Builder.fromXContent(parser);
        final IndexGraveyard graveyard = IndexGraveyardTests.createRandom();
                new String[] { "index1", "index2", "index3" },
                    )
            createTimestampField("@timestamp"),
            .put(
    public void testMetadataGlobalStateChangesOnIndexDeletions() {
        );
    @SuppressWarnings("unchecked")
        Metadata.builder(metadata).put(buildIndexMetadata(indexB, alias, bWriteIndex)).build();
        assertEquals(2, properties.size());
    }
            )
                idx = IndexMetadata.builder("shrink-" + DataStream.getDefaultBackingIndexName(dataStreamName, i))
                    .settings(
        );
            indicesLookup.put(indexMeta.getIndex().getName(), new IndexAbstraction.Index(indexMeta, dataStreamAbstraction));
            .putAlias(aliasZeroBuilder.build())
    public void testBuilderRejectsNullCustom() {
            backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList()),
            IllegalArgumentException.class,
            .put(
            assertEquals(previousMetadata.templatesV2(), newMetadata.templatesV2());
            );
        builder.startObject();
        assertThat(setting.get(metadata.settings()), equalTo("transient-value"));
import org.opensearch.common.xcontent.XContentHelper;
                .settings(settings(Version.CURRENT))
                new IndexMetadata.Builder(randomAlphaOfLength(10)).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1)
            .numberOfReplicas(0)
                    .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())
    }
/*
    public void testIsSegmentReplicationDisabled() {
    private Set<VotingConfigExclusion> randomVotingConfigExclusions() {
        String dataStreamName = "foo-datastream";
                    )
        + "        },\n"
import org.opensearch.cluster.coordination.CoordinationMetadata;
            assertNotNull(addressProperties);
        String alias = randomAlphaOfLength(5);
                    .numberOfReplicas(0)
        final BytesStreamOutput out = new BytesStreamOutput();
package org.opensearch.cluster.metadata;
            backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList()),
            .putAlias(AliasMetadata.builder("alias1").routing("1").build())
            )
        assertTrue(sourceAsMap.containsKey("_source"));
            assertEquals(previousMetadata.indices(), newMetadata.indices());
            .put(idx, false)
        for (IndexMetadata indexMeta : backingIndices) {
        // alias with no index routing
import java.util.stream.Collectors;
        }
                    "index/alias [alias2] provided with routing value [1,2] that"
    public void testValidateDataStreamsNoConflicts() {
        Metadata metadata = metadataBuilder.build();
                    .putAlias(AliasMetadata.builder("alias1").build())
    }
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
        builder.startObject();
                IndexMetadata.builder("index3")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, metadata)) {
        {
            Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
    public void testBuildIndicesLookupForDataStreams() {
        + "            }\n"
            .build();
        Map<String, Object> sourceAsMap = docMapping.getSourceAsMap();
        + "          \"type\": \"completion\"\n"
        // index, no alias
        // alias with no write index
            dataStreamName,
        md.put(randomDataStream);
        assertThat(
            .numberOfReplicas(0)
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();
    }
            assertTrue(indicesLookup.containsKey(index.getName()));
        }
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        + "              \"type\": \"geo_shape\",  \n"
    }
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).build();
            assertEquals(previousMetadata.getConcreteAllIndices(), newMetadata.getConcreteAllIndices());
        {
            Map<String, Object> doc = (Map<String, Object>) stringObjectMap.get("_doc");
            .putAlias(AliasMetadata.builder("alias0").build());
            assertThat(aliasMetadataList.get(1).alias(), equalTo("alias2"));
        Metadata metadata = Metadata.builder()
        }
            .put(
            fail();
        + "              }\n"
            randomVotingConfig(),
            bWriteIndex = randomFrom(Boolean.FALSE, null);
        verify(spyBuilder, times(1)).buildMetadataWithRecomputedIndicesLookups();
                value.getWriteIndex().getIndex().getName(),
            aliasZeroBuilder.writeIndex(true);
 * KIND, either express or implied.  See the License for the
        String alias = randomAlphaOfLength(5);
                    .numberOfShards(1)
            final Map<String, MappingMetadata> mappings = metadata.findMappings(new String[] { "index1" }, MapperPlugin.NOOP_FIELD_FILTER);
    public void testXContentWithIndexGraveyard() throws IOException {
            fail("should fail");
        MappingMetadata docMapping = mappings.get(index);
            IndexMetadata idx;
        Boolean aWriteIndex = randomBoolean() ? null : randomBoolean();
                IndexTemplateMetadata.builder("template_2")
                    + index.getName()
            .numberOfShards(1)
        String index = "new_index_" + randomAlphaOfLength(3);
import java.util.Map;
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));
        // prefixed indices with a lower generation than the data stream's generation are allowed even if the non-prefixed, matching the
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(idx.getIndex())));
 * software distributed under the License is distributed on an
        + "              \"precision\": \"1m\"\n"
                b.put(idx, true);
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata2));
import org.opensearch.plugins.MapperPlugin;
            randomNonNegativeLong(),
        {
                .settings(settings(Version.CURRENT))
                        Settings.builder()
            )
            .clusterUUIDCommitted(randomBoolean())
    public void testFindMappingsNoOpFilters() throws IOException {
        int lastIndexNum = randomIntBetween(9, 50);
        assertEquals(metadata.resolveWriteIndexRouting(null, "alias0"), null);
        assertEquals(0, typeProperties.size());
        }
                    .build()
    }
                index,
        String indexB = randomAlphaOfLength(7);
        Metadata metadata1 = Metadata.builder()
                index -> field -> (index.equals("index2"))
        assertThat(
                    .settings(
            .put(
        builder.startObject();
                if (index.equals("index1")) {
                IllegalStateException.class,
        } else {
    }
/*
            Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
        for (IndexMetadata indexMeta : backingIndices) {
            lastBackingIndexNum = randomIntBetween(lastBackingIndexNum + 1, lastBackingIndexNum + 50);
            .settings(settings(Version.CURRENT))
            randomVotingConfigExclusions()
        assertEquals(previousMetadata.clusterUUID(), newMetadata.clusterUUID());
            .put(
                new IndexMetadata.Builder(dataStreamName + "-index-without-counter").settings(settings(Version.CURRENT))
        );
        Metadata.FORMAT.toXContent(builder, originalMeta);
            aliasToIndices.forEach((key, value) -> {
                request = new GetAliasesRequest();
            .put(idx, false)
        + "              \"type\": \"geo_point\"\n"
        }
        Map<String, Object> sourceAsMap = docMapping.getSourceAsMap();
    public void testFindMappingsWithFilters() throws IOException {
import static org.mockito.Mockito.verify;
    public void testResolveIndexRouting() {
    public void testResolveWriteIndexRouting() {
        Metadata metadata1 = Metadata.builder().templates(templatesMetadata1).build();
        + "              \"type\": \"keyword\"\n"
    }
        TemplatesMetadata.Builder builder = TemplatesMetadata.builder();
        }
            assertEquals(previousMetadata.version() + 1, newMetadata.version());
        Metadata.FORMAT.toXContent(builder, originalMeta);
        + "          \"type\": \"object\",\n"
        final List<Index> backingIndices = new ArrayList<>();
                    .numberOfShards(1)
            )
        IllegalStateException illegalStateException = expectThrows(
                    + "including '"
        try {
        ).build();
        + "        \"properties\": {\n"
    public void testMetadataBuildInvocations() {
        DataStream randomDataStream = DataStreamTests.randomInstance();
        verify(spyBuilder, times(0)).buildMetadataWithPreviousIndicesLookups();
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String indexA = randomAlphaOfLength(6);
            assertThat(aliasMetadataList.size(), equalTo(1));
        verify(spyBuilder, times(0)).buildMetadataWithPreviousIndicesLookups();
    public void testUnknownFieldIndexMetadata() throws IOException {
    }
            () -> metadataTwoIndices.resolveIndexRouting("1", "alias0")
    }
import org.opensearch.common.UUIDs;
            .persistentSettings(Settings.builder().put(setting.getKey(), "persistent-value").build())
        + "              }\n"
            assertEquals(previousMetadata.componentTemplates(), newMetadata.componentTemplates());
        + "          \"properties\": {\n"
            IllegalStateException.class,
            assertTrue(sourceAsMap.containsKey("_source"));
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        + "            },\n"
        } catch (IllegalArgumentException ex) {
            )
        + "            },\n"
        assertThat(expectThrows(NullPointerException.class, () -> builder.customs(mapBuilder)).getMessage(), containsString(key));
            createTimestampField("@timestamp"),
        {
            assertThat(
        }
            e.getMessage(),
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting(null, "alias2"));
    }
        reset(spyBuilder);
        compareMetadata(previousMetadata, builtMetadata, false, true, false);
            assertFalse(fieldProp.containsKey("properties"));
        assertThat(
        final Metadata newMetadata,
        final List<Index> indices = new ArrayList<>();
            assertThat(value.getIndices().size(), equalTo(ds.getIndices().size()));
            .build();
                ex.getMessage(),
        final Metadata originalMeta = Metadata.builder().templates(templatesMetadata).build();
        TemplatesMetadata templatesMetadata2 = TemplatesMetadata.builder()
        );
            assertThat(aliasMetadataList.get(1).alias(), equalTo("alias2"));
    }
        assertThat(aliases.size(), equalTo(2));
            .clusterUUID(randomAlphaOfLength(10))
        IndexMetadata.Builder builder2 = IndexMetadata.builder("index2")
            assertThat(aliases.size(), equalTo(1));
            assertTrue(indicesLookup.containsKey(index.getName()));
            .putAlias(AliasMetadata.builder(aliasName).isHidden(indexAHidden).build());
    public void testTemplatesMetadata() {
            e.getMessage(),
        Metadata.Builder b = Metadata.builder()
        + "      }\n"
        indicesLookup.put(index.getName(), new IndexAbstraction.Index(standaloneIndexConflictingWithBackingIndices, null));
            containsString(
        // previous Metadata state was not provided to Builder during assignment - indices lookups should get re-computed
        assertMultiField(propertiesProperties, "key", "keyword");
                new IndexMetadata.Builder(DataStream.BACKING_INDEX_PREFIX + dataStreamName + "-something-100012").settings(
    private static TemplatesMetadata getTemplatesMetadata(int numberOfTemplates) {
        validateDataStreams(indicesLookup, dataStreamMetadata);
            fail("exception should have been thrown");
            assertThat(fromXContentMeta.clusterUUID(), equalTo(originalMeta.clusterUUID()));
        for (String field : fields) {
            IndexMetadata.Builder indexBuilder = IndexMetadata.builder(index)
        String indexAName,
        }
            Map<String, Object> valueProperties = (Map<String, Object>) value.get("properties");
        MappingMetadata originalMappingMetadata = new MappingMetadata(
            .numberOfShards(1)
            backingIndices.size()
        }
        for (Index index : result.indices) {
    }
        builder.endObject();
        CreateIndexResult result = createIndices(numIndices, numBackingIndices, dataStreamName);
            assertEquals(2, address.size());
                }
        return Metadata.builder().put(indexAMeta).put(indexBMeta);
        assertEquals(metadata.resolveIndexRouting(null, null), null);
                IndexTemplateMetadata.builder("template" + i)
        final Metadata originalMeta = Metadata.builder()
                        Settings.builder()
        }
        + "        }\n"
        Map<String, Object> fieldProp = (Map<String, Object>) properties.get(field);
        }
    public void testBuilderRejectsDataStreamThatConflictsWithAlias() {
    }
            b.put(im, false);
    public void testIndicesLookupRecordsDataStreamForBackingIndices() {
        assertThat(exception.getMessage(), is("alias [alias3] does not have a write index"));
                )
            .clusterUUIDCommitted(true)
        + "        \"address\": {\n"
        // data stream backing indices naming pattern, indices are already in the system
            assertThat(indicesLookup.get(index.getName()).getParentDataStream().getName(), equalTo(dataStreamName));
            Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
        final String dataStreamName = "my-data-stream";
            .put(
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting("1", "alias3"));
        String dataStreamName = "foo-datastream";
            .numberOfShards(1)
        } catch (IllegalArgumentException e) {
        + "              \"type\": \"keyword\"\n"
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
    }
        DataStreamMetadata dataStreamMetadata = new DataStreamMetadata(Map.of(dataStreamName, dataStream));
            containsString(
            assertLeafs(addressProperties, "street", "area");
        IllegalArgumentException exception = expectThrows(
            .putAlias(AliasMetadata.builder("index").build());
                equalTo(
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
import static org.mockito.Mockito.times;
            List<Index> indices = new ArrayList<>(numBackingIndices);
        assertEquals(metadata.resolveIndexRouting(null, "alias1"), "1");
        }
            exception.getMessage(),
        final XContentBuilder builder = JsonXContent.contentBuilder();
            .persistentSettings(Settings.builder().put("setting" + randomAlphaOfLength(3), randomAlphaOfLength(4)).build())
            for (int j = 1; j <= numBackingIndices; j++) {
        assertNotNull(docMapping);
        assertEquals(metadata.resolveWriteIndexRouting("0", "alias0"), "0");
        }
            final Map<String, MappingMetadata> mappings = metadata.findMappings(new String[] { "index1" }, MapperPlugin.NOOP_FIELD_FILTER);
        }
        assertEquals(previousMetadata.persistentSettings(), newMetadata.persistentSettings());
    }
                IndexMetadata.builder("index2")
            randomVotingConfig(),
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(
            backingIndices.add(im.getIndex());
        + "        },\n"
        );
        }
        int generations = 10;
                    )
                false
        assertEquals(metadata.resolveWriteIndexRouting(null, null), null);
        return new CreateIndexResult(indices, backingIndices, b.build());
        Metadata metadataTwoIndices = Metadata.builder(metadata).put(builder2).build();
    public void testBuilderRejectsDataStreamWithConflictingBackingIndices() {
                    .settings(OpenSearchTestCase.settings(Version.CURRENT).put("index.hidden", true))
                    + DataStream.getDefaultBackingIndexName(dataStreamName, 1)
            List<AliasMetadata> aliasMetadataList = aliases.get("index");
        assertThat(exception.getMessage(), startsWith("alias [" + alias + "] has more than one write index ["));
        assertTrue(properties.containsKey("type"));
        + "            \"area\": {\n"
        List<IndexMetadata> backingIndices = new ArrayList<>(generations);
            );
            assertEquals(0, nameProperties.size());
            }
        final List<Index> indices;
import org.opensearch.cluster.DataStreamTestHelper;
            assertNotNull(address);
        IndexMetadata validIdx = createFirstBackingIndex(dataStreamName).build();
        // don't expect any exception when validating against (potentially backing) indices that can't create conflict because of
    public void testUnknownFieldClusterMetadata() throws IOException {
        assertThat(aliases.get(1).alias(), equalTo("bb"));
                    "index, alias, and data stream names need to be unique, but the following duplicates were found [index (alias "
            )
            assertEquals(6, typeProperties.size());
import org.opensearch.core.xcontent.XContentParser;
        assertFalse(metadata.isSegmentReplicationEnabled(indexName));
        assertThat(aliases.size(), equalTo(1));
            assertIndexMappingsNotFiltered(mappings, "index2");
            .build();
        assertThat(
    public void testAliasCollidingWithAnExistingIndex() {
    }
                IndexMetadata.builder("index")
            assertFalse(fieldProp.containsKey("fields"));
        final boolean checkVersionIncrement
        final int numIndices = randomIntBetween(2, 5);
            final Metadata fromXContentMeta = Metadata.fromXContent(parser);
                        Settings.builder()
            )
    public static void assertLeafs(Map<String, Object> properties, String... fields) {
                // replacing with empty aliases behaves as if aliases were unspecified at request building
            assertIndexMappingsNotFiltered(mappings, "index2");
        } catch (IllegalArgumentException e) {
    }
        compareMetadata(previousMetadata, builtMetadata, true, false, false);
import org.opensearch.core.xcontent.XContentBuilder;
            )
                IllegalStateException.class,
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
        String dataStreamName = "foo-datastream";
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(metadata2.templates(), is(templatesMetadata2.getTemplates()));
        }
        // create some backing indices for a data stream
        Set<String> indices = new HashSet<>(indexCount);
 * GitHub history for details.
            Metadata.builder().put(builder).build();
        try {
                        + " resolved to several routing values, rejecting operation"
            Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
        final String key = randomAlphaOfLength(10);
            assertIndexMappingsNotFiltered(mappings, "index3");
            assertEquals(3, sourceAsMap.size());
            )
            );
        final String dataStreamName = "my-data-stream";
    }
            assertSame(originalMappingMetadata, mappingMetadata);
        + "              \"type\": \"text\",\n"
    }
        );
            randomVotingConfig(),
        }
        );
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                    .order(1234)
            .putAlias(AliasMetadata.builder(aliasName).isHidden(indexBHidden).build());
                IndexTemplateMetadata.builder("template_1")
        // alias with index routing.
        }
        Exception exception = expectThrows(IllegalStateException.class, () -> {
            XContentHelper.convertToMap(JsonXContent.jsonXContent, FIND_MAPPINGS_TEST_ITEM, true)
        Settings.Builder builder = settings(Version.CURRENT).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
        builder.startObject();
    }
                    + "] could create backing indices that conflict with 1 existing index(s) or alias(s) including '"
        } catch (IllegalArgumentException ex) {
        final Metadata previousMetadata,
        reset(spyBuilder);
        + "      \"_routing\": {\n"
        DataStream dataStream = new DataStream(
        assertEquals(3, sourceAsMap.size());
        + "            }\n"
    @SuppressWarnings("unchecked")
 */
