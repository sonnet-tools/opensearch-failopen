            fail("should fail");  
 */
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            IndexMetadata idx = createBackingIndex(dataStreamName, i).build();
        + "          \"type\": \"date\"\n"
            .settings(builder)
        reset(spyBuilder);  
            assertIndexMappingsNotFiltered(mappings, "index1");  
        assertNotNull(name);
        // when alias points to two indices, but valid  
                "index, alias, and data stream names need to be unique, but the following duplicates were found [data "  
            Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
            Map<String, Object> value = (Map<String, Object>) propertiesProperties.get("value");
        validateDataStreams(metadata.getIndicesLookup(), (DataStreamMetadata) metadata.customs().get(DataStreamMetadata.TYPE));
    private static class CreateIndexResult {
                // replacing with empty aliases behaves as if aliases were unspecified at request building
        Metadata.FORMAT.toXContent(builder, originalMeta);
                        && field.equals("age") == false
                    .putAlias(AliasMetadata.builder("alias1").build())
        originalMeta.writeTo(out);
        assertTrue(Metadata.isGlobalStateEquals(metadata1, metadata1));  
        // convention
                    .settings(  
            )  
            assertIndexMappingsNoFields(mappings, "index2");
 * compatible open source license.
            assertTrue(indicesLookup.containsKey(index.getName()));  
    public void testFindMappingsWithFilters() throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(
import static org.opensearch.cluster.metadata.Metadata.Builder.validateDataStreams;
        return Metadata.builder().put(indexAMeta).put(indexBMeta);
        // data stream backing indices naming pattern, indices are already in the system  
            .indexGraveyard(IndexGraveyardTests.createRandom())  
                    + dataStreamName
        }
        for (int k = 1; k <= numBackingIndices; k++) {  
        );  
    public void testXContentWithIndexGraveyard() throws IOException {
        return IndexMetadata.builder(name)  
                new IndexMetadata.Builder(randomAlphaOfLength(10)).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1)
        assertEquals(metadata.resolveIndexRouting(null, "alias0"), null);
                    .numberOfReplicas(1)
        final Setting setting = Setting.simpleString("key");
                "data stream ["  
            .numberOfShards(1)
    public void testFindDataStreams() {  
                new GetAliasesRequest("alias*"),
        Map<String, Object> fieldProp = (Map<String, Object>) properties.get(field);
    }
            assertThat(fromXContentMeta.clusterUUID(), equalTo(originalMeta.clusterUUID()));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
        assertThat(exception.getMessage(), startsWith("Alias [alias0] has more than one index associated with it"));
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).build();
                .numberOfShards(1)
            assertThat(fromXContentMeta.clusterUUIDCommitted(), equalTo(originalMeta.clusterUUIDCommitted()));  
            final Map<String, MappingMetadata> mappings = metadata.findMappings(new String[] { "index1" }, MapperPlugin.NOOP_FIELD_FILTER);  
        // alias with invalid index routing.
            } else {
                    + "'"
            )
        for (int i = 0; i < numDataStreams; i++) {
        assertLeafs(addressProperties, "street", "location", "area");
                    + conflictingIndex  
        Metadata metadata1 = Metadata.builder()  
 * KIND, either express or implied.  See the License for the
            assertEquals(2, properties.size());  
                    )  
        assertThat(fromStreamMeta.clusterUUID(), equalTo(originalMeta.clusterUUID()));  
            randomNonNegativeLong(),  
        assertThat(setting.get(metadata.settings()), equalTo("transient-value"));
        Map<String, Set<String>> aliasToIndices = new HashMap<>();
        + "            }\n"
        final String dataStreamName = "my-data-stream";
        // alias with index routing.
                    "index, alias, and data stream names need to be unique, but the following duplicates were found [index (alias "
            );
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
/*  
        {
            .putAlias(aliasZeroBuilderTwo.build())
    public void testIndicesLookupRecordsDataStreamForBackingIndices() {  
        + "        }\n"
        assertThat(aliases.get(0).alias(), equalTo("alias2"));  
    }  
        for (Index index : result.backingIndices) {  
                    .numberOfReplicas(0)
            .put(
        + "            \"location\": {\n"
        IndexAbstraction.DataStream dataStreamAbstraction = new IndexAbstraction.DataStream(dataStream, backingIndices);  
        b.put(new DataStream(dataStreamName, createTimestampField("@timestamp"), backingIndices, lastBackingIndexNum));
        Map<String, Object> sourceAsMap = docMapping.getSourceAsMap();
        Metadata.Builder b = Metadata.builder()  
            this.metadata = metadata;  
        + "          \"properties\": {\n"
        assertEquals(metadata.resolveWriteIndexRouting(null, "alias0"), null);  
            assertEquals(1, typeProperties.size());  
        final List<Index> backingIndices;  
import org.opensearch.cluster.ClusterModule;  
            .clusterUUIDCommitted(randomBoolean())  
            final Map<String, MappingMetadata> mappings = metadata.findMappings(
            .putAlias(AliasMetadata.builder("alias3").writeIndex(false).build())
        assertMultiField(propertiesProperties, "value", "keyword");
            try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        Metadata metadata = Metadata.builder()
    }  
    }
        int properAliases = randomIntBetween(0, 3);  
        Metadata metadata = Metadata.builder().coordinationMetadata(originalMeta).build();
        }
 * license agreements. See the NOTICE file distributed with
            .build();
        Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");  
        + "        \"name\": {\n"  
            assertEquals(previousMetadata.version() + 1, newMetadata.version());  
        final String dataStreamName = "my-data-stream";
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())  
        + "      \"_source\": {\n"
        assertEquals(previousMetadata.coordinationMetadata(), newMetadata.coordinationMetadata());
        assertTrue(Metadata.isGlobalStateEquals(metadata1, metadata1));
            assertEquals(1, name.size());
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
            JsonXContent.contentBuilder().startObject().startObject("index_name").field("random", "value").endObject().endObject()
        + "        },\n"
            Exception ex = expectThrows(  
        // alias with no write index
                    )
        + "            \"street\": {\n"
        assertEquals(metadata.resolveWriteIndexRouting(null, "alias1"), "1");
            randomVotingConfig(),
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
                    .numberOfShards(1)
            Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
                    .patterns(Arrays.asList(randomAlphaOfLength(3) + "-*"))  
            IndexMetadata im = IndexMetadata.builder(DataStream.getDefaultBackingIndexName("index", lastIndexNum))
        for (int i = 0; i < indexCount; i++) {
        }
        CoordinationMetadata coordinationMetadata1 = new CoordinationMetadata(
            .numberOfReplicas(0)
        orig.writeTo(out);
                new GetAliasesRequest("alias1"),  
            .put(idx, false)
            .numberOfShards(1)
        builder.startObject();  
            Map<String, Object> keyProperties = (Map<String, Object>) key.get("properties");
        assertTrue(typeProperties.containsKey("birth"));
        + "              \"type\": \"text\",\n"  
        assertTrue(sourceAsMap.containsKey("_routing"));  
            assertIndexMappingsNotFiltered(mappings, "index2");
                    + "'"
            .numberOfShards(1)  
        );
            final Map<String, List<AliasMetadata>> aliases = metadata.findAllAliases(Strings.EMPTY_ARRAY);
        + "          \"type\": \"completion\"\n"
        if (randomBoolean()) {
        }
                IndexMetadata.builder(index).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1).build()  
        }
        builder.endObject();
            exception.getMessage(),
        indicesLookup.put(index.getName(), new IndexAbstraction.Index(standaloneIndexConflictingWithBackingIndices, null));
            assertEquals(previousMetadata.getConcreteAllIndices(), newMetadata.getConcreteAllIndices());  
        Metadata metadata = metadataBuilder.build();
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting(randomFrom("1", null), "alias4"));
    }
        // adding new templates - indices lookups should not get recomputed
            IndexMetadata idx;  
                )
            createTimestampField("@timestamp"),
            .clusterUUIDCommitted(randomBoolean())
            .putAlias(AliasMetadata.builder("alias0").build())  
import java.util.List;
        + "                \"keyword\" : {\n"
                new String[] { "index" }
        builtMetadata = spyBuilder.put("component_template_new_" + randomAlphaOfLength(3), ComponentTemplateTests.randomInstance())
            .build();  
            .put(  
            .numberOfReplicas(0)
        Boolean indexAHidden,
            assertThat(ex.getMessage(), containsString("has is_hidden set to true on indices"));
        final List<Index> indices = new ArrayList<>();  
    public void testXContentWithCoordinationMetadata() throws IOException {  
                idx = IndexMetadata.builder("shrink-" + DataStream.getDefaultBackingIndexName(dataStreamName, i))
        Metadata metadata = Metadata.builder(createIndices(10, 10, dataStreamName).metadata)
    public void testUnknownFieldIndexMetadata() throws IOException {
        }  
            .build();  
            MappingMetadata mappingMetadata = mappings.get("index1");  
    public void testIndexAndAliasWithSameName() {  
        Set<String> indices = new HashSet<>(indexCount);
    public void testBuilderRejectsDataStreamWithConflictingBackingAlias() {  
    public void testValidateDataStreamsForNullDataStreamMetadata() {
                new String[] { "index1", "index2" },
        final BytesStreamOutput out = new BytesStreamOutput();  
                    + dataStreamName
        Metadata metadata = Metadata.builder()
                    "Alias [alias1] has index routing associated with it [1], "
        + "              }\n"
            String name = "data-stream-" + i;  
        Metadata metadata = b.build();
        TemplatesMetadata templatesMetadata2 = TemplatesMetadata.builder()
        Metadata metadata = Metadata.builder().put(builder).build();
        final String dataStreamName = "my-data-stream";  
        Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
    }
        CreateIndexResult(List<Index> indices, List<Index> backingIndices, Metadata metadata) {  
            assertEquals(1, value.size());
            )  
                    .putAlias(AliasMetadata.builder("ab").build())
            randomVotingConfig(),  
            assertIndexMappingsNoFields(mappings, "index3");  
        } catch (IllegalStateException e) {  
import org.opensearch.common.xcontent.XContentHelper;  
        final String key = randomAlphaOfLength(10);  
        verify(spyBuilder, times(0)).buildMetadataWithPreviousIndicesLookups();
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);
                if (value.contains(index)) {
        Metadata metadata = Metadata.builder()
            IndexMetadata.Builder metaB = buildIndexMetadata(indexB, alias, true);
        assertTrue(fieldProp.containsKey("fields"));  
        // when only one index/alias pair exist  
import org.opensearch.core.common.bytes.BytesReference;  
}  
            assertEquals(3, sourceAsMap.size());
            .coordinationMetadata(coordinationMetadata2)
import org.opensearch.cluster.coordination.CoordinationMetadata;
        for (String index : indices) {
        }
            .put(idx, false)  
            containsString(
        final Metadata metadata;
        }
            randomNonNegativeLong(),
        // add the offending index to the indices lookup
            assertThat(aliases.size(), equalTo(1));  
            assertLeafs(keyProperties, "keyword");  
        builder.endObject();
                indices.add(idx.getIndex());
 *  
            .put(
    public void testMetadataGlobalStateChangesOnClusterUUIDChanges() {
        );
            assertThat(dataStreams.containsKey(backingIndex.getName()), is(true));  
            assertNotNull(properties);
                    + "stream ["
        );
        final Metadata metadata1 = Metadata.builder().clusterUUID(UUIDs.randomBase64UUID()).clusterUUIDCommitted(randomBoolean()).build();
            .put(
                .settings(settings(Version.CURRENT))  
            IndexMetadata im = IndexMetadata.builder(DataStream.getDefaultBackingIndexName(dataStreamName, lastBackingIndexNum))
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).putAlias(new AliasMetadata.Builder(conflictingName)).build();  
    }
            new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)  
        spyBuilder = spy(Metadata.builder(previousMetadata));
        try {  
        assertTrue(sourceAsMap.containsKey("_routing"));
            assertTrue(nodes.add(new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10))));
        {
        + "              \"tree\": \"quadtree\",\n"  
                    .settings(  
            assertEquals(2, propertiesProperties.size());
            randomVotingConfig(),
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).putAlias(AliasMetadata.builder(dataStreamName).build()).build();
            }
    private static IndexMetadata.Builder buildIndexMetadata(String name, String alias, Boolean writeIndex) {
        builder.endObject();
    }
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
    public void testBuilderRejectsDataStreamThatConflictsWithAlias() {
        spyBuilder = spy(Metadata.builder(previousMetadata));
        + "              \"fields\": {\n"  
            assertThat(ex.getMessage(), containsString("has is_hidden set to true on indices"));
        assertThat(expectThrows(NullPointerException.class, () -> builder.putCustom(key, null)).getMessage(), containsString(key));
            assertTrue(typeProperties.containsKey("birth"));
 * SPDX-License-Identifier: Apache-2.0
        final IndexGraveyard graveyard = IndexGraveyardTests.createRandom();  
            IllegalStateException.class,  
    public void testGlobalStateEqualsCoordinationMetadata() {  
                    .numberOfShards(1)
import org.opensearch.cluster.DataStreamTestHelper;
        assertFalse(metadata.isSegmentReplicationEnabled(indexName));
        + "              \"type\": \"keyword\"\n"  
        CoordinationMetadata coordinationMetadata2 = new CoordinationMetadata(
        for (Index index : randomDataStream.getIndices()) {  
        // no alias, no index
        }  
            assertThat(
        assertFalse("metadata not equal after adding index deletions", Metadata.isGlobalStateEquals(metadata1, metadata2));  
        builder.addTombstone(new Index("idx1", UUIDs.randomBase64UUID()));
            randomNonNegativeLong(),
        }  
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(idx.getIndex())));  
                    .putMapping(mapping)
        SortedMap<String, IndexAbstraction> indicesLookup = result.metadata.getIndicesLookup();  
        + "      }\n"
        try {
        + "        },\n"  
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(idx.getIndex())));
        + "  }\n"
        }
        assertEquals(metadata.resolveIndexRouting("0", "alias0"), "0");  
                ex.getMessage(),  
        // index, no alias  
            assertNotNull(address);
                IndexMetadata.builder("index1")
                ex.getMessage(),  
 * the Apache License, Version 2.0 (the "License"); you may
        + "            },\n"
            assertTrue(typeProperties.containsKey("suggest"));
        return new CreateIndexResult(indices, backingIndices, b.build());
        MappingMetadata docMapping = mappings.get(index);
            assertEquals(3, sourceAsMap.size());
        + "              \"precision\": \"1m\"\n"
        compareMetadata(previousMetadata, builtMetadata, true, false, false);  
            dataStreamName,
        assertEquals(previousMetadata.clusterUUID(), newMetadata.clusterUUID());
            new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)
                )  
        assertEquals(0, typeProperties.size());
        assertThat(exception.getMessage(), is("alias [alias3] does not have a write index"));  
        for (Index backingIndex : result.backingIndices) {
                () -> buildMetadataWithHiddenIndexMix(alias, indexA, randomFrom(false, null), indexB, true).build()
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        Metadata.Builder metadataBuilder = Metadata.builder();
            assertTrue(properties.containsKey("type"));
            String name = "data-stream-" + i;
        final Metadata fromStreamMeta = Metadata.readFrom(  
        assertEquals(2, properties.size());
                    .order(1234)
        assertTrue(sourceAsMap.containsKey("_source"));
            .put(invalidIdx, false)
    }  
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;
                    return field -> field.startsWith("name.") == false
    }
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(idx.getIndex())));  
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        String aliasName,  
                .numberOfReplicas(1)
 *
        builder.startObject();  
        assertNotNull(docMapping);
            metadata.resolveIndexRouting(null, "alias2");
            e.getMessage(),
        assertThat(fromStreamMeta.indexGraveyard(), equalTo(fromStreamMeta.indexGraveyard()));
        spyBuilder = spy(Metadata.builder(previousMetadata));
            assertEquals(2, addressProperties.size());
                IndexMetadata.builder("index")  
                    .numberOfReplicas(0)  
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(new GetAliasesRequest(), new String[] { "index" });
            }  
            assertMultiField(propertiesProperties, "value", "keyword");  
        );
                    "index/alias [alias2] provided with routing value [1,2] that"
            final Map<String, MappingMetadata> mappings = metadata.findMappings(Strings.EMPTY_ARRAY, MapperPlugin.NOOP_FIELD_FILTER);  
        + "                \"keyword\" : {\n"
            assertIndexMappingsNoFields(mappings, "index2");
        assertTrue(Metadata.isGlobalStateEquals(metadata1, metadata4));
        + "                }\n"  
        Map<String, Object> sourceAsMap = docMapping.getSourceAsMap();  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
        assertEquals(1, name.size());  
            assertNotNull(nameProperties);
            lastIndexNum = randomIntBetween(lastIndexNum + 1, lastIndexNum + 50);
                        Settings.builder()  
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
            Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
        final int numIndices = randomIntBetween(2, 5);
        final String indexName = "test";
            backingIndices.size()
            Map<String, Object> stringObjectMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, FIND_MAPPINGS_TEST_ITEM, false);  
            .numberOfReplicas(0)
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
    private Metadata.Builder buildMetadataWithHiddenIndexMix(
        // verify that new write index is used
            IllegalArgumentException.class,
            IndexMetadata.Builder.fromXContent(parser);
            exception.getMessage(),
            .putAlias(AliasMetadata.builder("alias2").routing("1,2").build());
            final Map<String, MappingMetadata> mappings = metadata.findMappings(
        IndexMetadata validIdx = createFirstBackingIndex(dataStreamName).build();  
    private static CoordinationMetadata.VotingConfiguration randomVotingConfig() {
            assertIndexMappingsNotFiltered(mappings, "index2");  
    private static CreateIndexResult createIndices(int numIndices, int numBackingIndices, String dataStreamName) {
    public void testBuilderRejectsNullInCustoms() {
            assertNotSame(originalMappingMetadata, mappingMetadata);
            fail("exception should have been thrown");
            );
            fail("should fail");
    public void testMetadataBuildInvocations() {
        CoordinationMetadata coordinationMetadata2 = new CoordinationMetadata(
        assertThat(aliases.get(1).alias(), equalTo("bb"));  
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);
    public void testValidateDataStreamsAllowsNamesThatStartsWithPrefix() {
            new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)
        Metadata.Builder b = Metadata.builder()  
    public void testValidateDataStreamsNoConflicts() {  
        @SuppressWarnings("unchecked")
            randomVotingConfigExclusions()  
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertNotNull(fieldProp);
    }  
        verify(spyBuilder, times(1)).buildMetadataWithRecomputedIndicesLookups();
        );
        + "            \"value\" : {\n"
        + "  \"_doc\": {\n"
                .build();
            assertEquals(0, nameProperties.size());
            containsString(
            .putAlias(AliasMetadata.builder(alias).writeIndex(writeIndex))  
        assertThat(  
            Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");  
        if (compareTemplates == true) {
            Collections.singletonMap(
        assertMultiField(propertiesProperties, "key", "keyword");
        assertEquals(metadata.resolveIndexRouting(null, "index"), null);
                    indexBuilder.putAlias(AliasMetadata.builder(key).build());  
            .put(
                    )
            assertThat(value, notNullValue());
        + "            }\n"
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IllegalStateException illegalStateException = expectThrows(
        builder = IndexGraveyard.builder(metadata1.indexGraveyard());  
            .putAlias(AliasMetadata.builder(aliasName).isHidden(indexBHidden).build());  
                is(  
    public void testTransientSettingsOverridePersistentSettings() {
                IllegalStateException.class,
        Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
        spyBuilder = spy(Metadata.builder(previousMetadata));  
                    .build();  
            List<AliasMetadata> aliasMetadataList = aliases.get("index");
        Metadata metadata = Metadata.builder(createIndices(10, 10, dataStreamName).metadata)
        {
    public void testIsSegmentReplicationEnabled() {  
        assertTrue(Metadata.isGlobalResourcesMetadataEquals(metadata1, metadata2));
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            randomNonNegativeLong(),
                new IndexMetadata.Builder(DataStream.BACKING_INDEX_PREFIX + dataStreamName + "-something-100012").settings(  
            .build();
        + "        },\n"  
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
        // prefixed indices with a lower generation than the data stream's generation are allowed even if the non-prefixed, matching the
                new String[] { "index1", "index2", "index3" },
        assertNotNull(docMapping);
        // create some indices that do not back a data stream
                        Settings.builder()
                index -> field -> (index.equals("index2"))
        AliasMetadata.Builder aliasZeroBuilderTwo = AliasMetadata.builder("alias0");  
        + "          \"type\": \"ip\"\n"
        + "              \"fields\": {\n"
        final Map<String, IndexAbstraction.DataStream> dataStreams = result.metadata.findDataStreams(concreteIndices);  
            .put("index_template_v2_new_" + randomAlphaOfLength(3), ComposableIndexTemplateTests.randomInstance())
        );
            b.put(im, false);  
        Metadata metadata = Metadata.builder().put(builder).build();  
            )
            final Map<String, MappingMetadata> mappings = metadata.findMappings(new String[] { "index1" }, MapperPlugin.NOOP_FIELD_FILTER);
            .settings(settings(Version.CURRENT))
        final int numBackingIndices = randomIntBetween(2, 5);
    }
            Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");
    private static TemplatesMetadata getTemplatesMetadata(int numberOfTemplates) {  
            containsString(  
        + "        },\n"  
                    .numberOfShards(1)  
        builtMetadata = spyBuilder.build();
        assertEquals(3, addressProperties.size());  
            .coordinationMetadata(coordinationMetadata1)
        final String key = randomAlphaOfLength(10);  
        assertEquals(metadata.resolveIndexRouting("0", "index"), "0");
        verify(spyBuilder, times(0)).buildMetadataWithPreviousIndicesLookups();
 * specific language governing permissions and limitations
            .put(  
    ) {
    public void testGlobalResourcesStateEqualsCoordinationMetadata() {
        final boolean compareIndicesLookups,
        {
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
            assertThat(aliasMetadataList.get(1).alias(), equalTo("alias2"));
        } catch (IllegalArgumentException e) {  
            randomVotingConfigExclusions()
        assertThat(metadata1.templates(), is(templatesMetadata1.getTemplates()));  
            builder.put(  
        );  
            .putAlias(AliasMetadata.builder("alias1").routing("1").build())
        + "      \"properties\": {\n"
        Exception exception = expectThrows(IllegalStateException.class, () -> {
            .put(
                e.getMessage(),
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(
        return new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(randomInt(10), 20, false)));  
            assertEquals(previousMetadata.indices(), newMetadata.indices());
import java.util.TreeMap;
        assertEquals(previousMetadata.persistentSettings(), newMetadata.persistentSettings());
            List<Index> indices = new ArrayList<>(numBackingIndices);
        String alias = randomAlphaOfLength(5);
        + "          }\n"
            assertEquals(previousMetadata.getConcreteVisibleClosedIndices(), newMetadata.getConcreteVisibleClosedIndices());
            randomVotingConfig(),
    @SuppressWarnings("unchecked")
                    .putAlias(AliasMetadata.builder("alias2").build())  
            Metadata.builder().put(metaA).put(metaB).build();
        }  
    public void testSerializationWithIndexGraveyard() throws IOException {
        // when too many write indices
 * The OpenSearch Contributors require contributions made to  
            .build();  
                }  
                    .settings(
            .transientSettings(Settings.builder().put(setting.getKey(), "transient-value").build())
                IndexMetadata idx = createBackingIndex(name, j).build();
import org.opensearch.common.settings.Setting;  
        CoordinationMetadata originalMeta = new CoordinationMetadata(
    }
    private Set<VotingConfigExclusion> randomVotingConfigExclusions() {  
import static org.mockito.Mockito.reset;
        final String dataStreamName = "my-data-stream";
            IndexMetadata.Builder metaA = buildIndexMetadata(indexA, alias, true);  
        }  
                () -> buildMetadataWithHiddenIndexMix(alias, indexA, true, indexB, randomFrom(false, null)).build()  
        assertThat(aliases.get(0).alias(), equalTo("aa"));
            aliasZeroBuilder.writeIndex(false);
        int generations = 10;
            } else {
            .numberOfReplicas(0)
            .numberOfShards(1)
            )
        IndexGraveyard.Builder builder = IndexGraveyard.builder();  
            fail("exception should have been thrown");
        builder.startObject();
                    .putAlias(AliasMetadata.builder("alias2").build())
            lastBackingIndexNum = randomIntBetween(lastBackingIndexNum + 1, lastBackingIndexNum + 50);
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();  
        });  
        // no alias, no index  
            )  
import static org.hamcrest.Matchers.is;
        final TemplatesMetadata templatesMetadata = getTemplatesMetadata(0);  
                IndexMetadata indexMeta = createBackingIndex(dataStreamName, i).build();
            IndexMetadata im = IndexMetadata.builder(DataStream.getDefaultBackingIndexName(dataStreamName, lastBackingIndexNum))
                IndexMetadata.builder("index1")
        // alias with index routing.  
        );
import static org.opensearch.cluster.DataStreamTestHelper.createFirstBackingIndex;  
        Metadata metadata2 = Metadata.builder(metadata1).templates(templatesMetadata2).build();
        + "            },\n"  
        int lastIndexNum = randomIntBetween(9, 50);
            );  
        final String dataStreamName = "my-data-stream";  
    public void testResolveIndexRouting() {
    private static void assertIndexMappingsNotFiltered(final Map<String, MappingMetadata> mappings, String index) {  
 *
        );
        assertThat(dataStreams.size(), equalTo(numBackingIndices));
            assertThat(aliases.size(), equalTo(1));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, metadata)) {  
        IndexMetadata.Builder indexBMeta = IndexMetadata.builder(indexBName)
            );  
        final Metadata metadata4 = Metadata.builder(metadata2).clusterUUID(metadata1.clusterUUID()).build();
            .hashesOfConsistentSettings(Map.of("b", "a"))
            is("index/alias [alias2] provided with routing value [1,2] that resolved to several routing values, rejecting operation")  
        {
            backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList()),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
            )
        IndexMetadata.Builder builder2 = IndexMetadata.builder("index2")
                    .settings(
        String mapping = FIND_MAPPINGS_TEST_ITEM;
            assertEquals(1, valueProperties.size());
        // previous Metadata state was not provided to Builder during assignment - indices lookups should get re-computed  
        ).build();
            .put(idx, false)
        String index = "new_index_" + randomAlphaOfLength(3);
                    )  
        }
    }
                    .numberOfShards(1)  
            assertThat(
            .persistentSettings(Settings.builder().put("setting" + randomAlphaOfLength(3), randomAlphaOfLength(4)).build())
        if (randomBoolean()) {
            Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
        compareMetadata(previousMetadata, builtMetadata, false, true, false);
        for (int i = 1; i <= generations; i++) {
        for (int k = 1; k <= numIndices; k++) {  
        DataStreamMetadata dataStreamMetadata = new DataStreamMetadata(Map.of(dataStreamName, dataStream));  
            assertEquals(2, propertiesProperties.size());
                        + " resolved to several routing values, rejecting operation"
            .build();  
        Settings.Builder builder = settings(Version.CURRENT).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
            .putAlias(AliasMetadata.builder("alias4").routing("1,2").writeIndex(true).build());  
            assertEquals(2, address.size());  
    public void testBuilderRejectsNullCustom() {
            .build();  
            .putAlias(AliasMetadata.builder("alias1").routing("1").build())  
        // alias with multiple indices  
        }  
        final List<Index> backingIndices = new ArrayList<>();  
 */  
                    .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())
    }  
        {
        final Metadata fromStreamMeta = Metadata.readFrom(
    }  
    }  
        }
        assertEquals(previousMetadata.hashesOfConsistentSettings(), newMetadata.hashesOfConsistentSettings());
        + "    }\n"  
        }
            is(
        String indexAName,
        try {  
        }  
        }
    }
                        Settings.builder()
            assertNull(indicesLookup.get(index.getName()).getParentDataStream());
            final Metadata fromXContentMeta = Metadata.fromXContent(parser);
    public void testAliasCollidingWithAnExistingIndex() {
        }  
                    .patterns(Arrays.asList("bar-*", "foo-*"))
        assertThat(exception.getMessage(), startsWith("alias [" + alias + "] has more than one write index ["));
                builder.map(doc);  
            assertEquals("Unexpected field [random]", e.getMessage());
        + "                  \"type\" : \"keyword\"\n"
            .numberOfReplicas(0)  
            backingIndices.add(idx);  
        + "              \"type\": \"text\",\n"
        }  
            .putAlias(AliasMetadata.builder("alias1").routing("0").writeIndex(true).build())  
            randomVotingConfig(),
    public static void assertLeafs(Map<String, Object> properties, String... fields) {  
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        AliasMetadata.Builder aliasZeroBuilder = AliasMetadata.builder("alias0");  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            fail("should fail");  
                .numberOfReplicas(1)
        }  
        // aliases with multiple indices
                        && field.equals("address.location") == false;
        CreateIndexResult result = createIndices(numIndices, numBackingIndices, dataStreamName);
                    .build()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, metadata)) {  
            assertThat(aliases.size(), equalTo(1));
        DataStream randomDataStream = DataStreamTests.randomInstance();
        );  
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));
        );  
        Metadata.FORMAT.toXContent(builder, metadata);  
        for (int i = 0; i < numDataStreams; i++) {
            );
            );
    }
            .build();
        Metadata metadata = Metadata.builder()
        final Map<String, Metadata.Custom> mapBuilder = new HashMap<>();
                    + "including '"
            .put(
        final Metadata originalMeta = Metadata.builder().templates(templatesMetadata).build();
            assertTrue(sourceAsMap.containsKey("_routing"));  
        assertNotNull(properties);
        final Metadata originalMeta = Metadata.builder()
        assertThat(  
        + "          \"properties\": {\n"
        assertNotNull(nameProperties);
            }
            randomVotingConfig(),  
    }
            Map<String, Object> fieldProp = (Map<String, Object>) properties.get(field);  
                    )  
import static org.hamcrest.Matchers.notNullValue;  
        Metadata.Builder b = Metadata.builder()
        );
        final Metadata originalMeta = Metadata.builder()
    public void testBuilderRejectsDataStreamThatConflictsWithIndex() {  
import java.util.SortedMap;
        Metadata.Builder md = Metadata.builder()  
            if (randomBoolean()) {  
                    return field -> false;
        + "            },\n"  
            assertThat(value.getType(), equalTo(IndexAbstraction.Type.DATA_STREAM));  
        int numDataStreams = randomIntBetween(2, 8);
            IndexMetadata.Builder indexBuilder = IndexMetadata.builder(index)  
        + "              \"type\": \"geo_point\"\n"
        assertTrue(Metadata.isGlobalStateEquals(orig, fromStreamMeta));  
        }
                request = new GetAliasesRequest(randomFrom("alias1", "alias2"));  
            assertEquals(previousMetadata.getConcreteVisibleIndices(), newMetadata.getConcreteVisibleIndices());  
        String indexB = randomAlphaOfLength(7);
                    + "] could create backing indices that conflict with 1 existing index(s) or alias(s) including '"
        } catch (Exception e) {
        assertEquals(7, typeProperties.size());
            e.getMessage(),
                is(
            assertThat(aliases.size(), equalTo(1));
            assertThat(fromXContentMeta, equalTo(originalMeta));
            );
        assertTrue(address.containsKey("type"));  
            Map<String, Object> key = (Map<String, Object>) propertiesProperties.get("key");
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);
        // no changes in builder method after initialization from previous Metadata - indices lookups should not be re-computed
        String dataStreamName = "foo-datastream";
            backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList()),  
 * software distributed under the License is distributed on an
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata3));  
        CreateIndexResult result = createIndices(numIndices, numBackingIndices, dataStreamName);
        + "        \"ip\": {\n"
            assertSame(originalMappingMetadata, mappingMetadata);
    public void testXContentWithTemplateMetadata() throws IOException {
        Map<String, Object> subFieldsDef = (Map<String, Object>) fieldProp.get("fields");
            .putAlias(aliasZeroBuilder.build())
            indicesLookup.put(indexMeta.getIndex().getName(), new IndexAbstraction.Index(indexMeta, dataStreamAbstraction));
        }  
                    )  
                    )
            assertNotNull(docMapping);
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting(null, "alias2"));  
            );  
        + "          \"type\": \"integer\"\n"
            assertThat(aliases.size(), equalTo(0));
import org.opensearch.common.xcontent.json.JsonXContent;
    }
                    .settings(OpenSearchTestCase.settings(Version.CURRENT).put("index.hidden", true))  
            .put("component_template_" + randomAlphaOfLength(3), ComponentTemplateTests.randomInstance())
            .numberOfShards(1)
        String indexA = randomAlphaOfLength(6);  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
    public void testMetadataGlobalStateChangesOnIndexDeletions() {
 */  
        + "            \"last\": {\n"
        }  
            .putAlias(AliasMetadata.builder("alias0").build());  
            assertEquals(previousMetadata.componentTemplates(), newMetadata.componentTemplates());
            assertEquals(previousMetadata.templates(), newMetadata.templates());
        assertThat(
            }
                .numberOfReplicas(0);  
            fail("did not expect exception when validating a system without any data streams but got " + e.getMessage());  
        }
        }  
            );
            )
    }  
        );  
            aliasToIndices.put(randomAlphaOfLength(5), new HashSet<>(randomSubsetOf(randomIntBetween(1, 3), indices)));
        String dataStreamName = "foo-datastream";  
            .put(
            final CoordinationMetadata fromXContentMeta = Metadata.fromXContent(parser).coordinationMetadata();
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                }
        final Metadata metadata2 = Metadata.builder(metadata1).indexGraveyard(builder.build()).build();
        final XContentBuilder builder = JsonXContent.contentBuilder();
            assertEquals(previousMetadata.getConcreteVisibleOpenIndices(), newMetadata.getConcreteVisibleOpenIndices());
        assertLeafs(nameProperties, "first", "last");
        assertThat(metadata.dataStreams().size(), equalTo(1));
        for (int i = 0; i < numberOfTemplates; i++) {
            assertThat(aliasMetadataList.size(), equalTo(2));  
    }  
            .numberOfShards(1)  
                    + dataStreamName
        Metadata.Builder metadataBuilder = Metadata.builder().put(indexMetadataBuilder);
            );
            assertThat(fromXContentMeta.indexGraveyard(), equalTo(originalMeta.indexGraveyard()));
            assertThat(aliasMetadataList.size(), equalTo(2));  
            )  
        }  
        + "        \"properties\": {\n"
                IndexMetadata.builder("index2")  
            assertFalse(fieldProp.containsKey("fields"));  
            Metadata.Builder.fromXContent(parser);
            md.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
    }
                    .numberOfReplicas(1)
                new IndexMetadata.Builder(dataStreamName + randomAlphaOfLength(10)).settings(settings(Version.CURRENT))
    public void testValidateDataStreamsThrowsExceptionOnConflict() {  
            .put(
            .build();
            .putAlias(AliasMetadata.builder(aliasName).isHidden(indexAHidden).build());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            assertTrue(properties.containsKey(field));
        // one of the following combinations: [(null, null), (null, true), (null, false), (false, false)]
        final int size = randomIntBetween(0, 10);
        Metadata.builder(metadata).put(buildIndexMetadata(indexB, alias, bWriteIndex)).build();
            randomVotingConfig(),  
        // alias with no index routing
        } catch (IllegalArgumentException e) {  
    }  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String dataStreamName = "foo-datastream";
    }
                    .patterns(Arrays.asList("bar-*", "foo-*"))  
import org.opensearch.common.UUIDs;
    }  
        assertEquals(2, nameProperties.size());  
                idx = createBackingIndex(dataStreamName, i).build();
            assertEquals(previousMetadata.getConcreteAllClosedIndices(), newMetadata.getConcreteAllClosedIndices());
            )  
        verify(spyBuilder, times(1)).buildMetadataWithRecomputedIndicesLookups();  
        assertEquals(metadata.resolveIndexRouting(null, null), null);  
    public void testValidateHiddenAliasConsistency() {
                        Settings.builder()
            assertThat(dataStreams.get(backingIndex.getName()).getName(), equalTo(dataStreamName));
                    + DataStream.getDefaultBackingIndexName(dataStreamName, 1)
        assertTrue(metadata.isSegmentReplicationEnabled(indexName));  
    }  
        IndexMetadata.Builder builder = IndexMetadata.builder("index")
                new String[] { "index1", "index2", "index3" },
import java.util.Map;
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");  
    }
                .settings(settings(Version.CURRENT))
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(  
            XContentHelper.convertToMap(JsonXContent.jsonXContent, FIND_MAPPINGS_TEST_ITEM, true)
import static org.hamcrest.Matchers.equalTo;
    public void testValidateDataStreamsIgnoresIndicesWithoutCounter() {
        assertNotNull(propertiesProperties);
        // adding new data stream - indices lookups should get re-computed  
            backingIndices.add(im.getIndex());
            assertEquals(1, mappings.size());
            final Map<String, MappingMetadata> mappings = metadata.findMappings(new String[] { "index1", "index2", "index3" }, index -> {  
            Map<String, Object> sourceAsMap = docMapping.getSourceAsMap();
        final Metadata originalMeta = Metadata.builder().indexGraveyard(graveyard).build();
            assertEquals("Unexpected field [random]", e.getMessage());
import static org.hamcrest.Matchers.containsString;  
            randomVotingConfigExclusions()
            .version(randomNonNegativeLong())
import java.util.Collections;
    }  
            assertThat(fromXContentMeta.templates(), equalTo(originalMeta.templates()));
                request = new GetAliasesRequest();
        CoordinationMetadata coordinationMetadata1 = new CoordinationMetadata(  
                "data stream ["  
    }  
    }  
            assertThat(
        }
    public static void assertMultiField(Map<String, Object> properties, String field, String... subFields) {
        final Metadata newMetadata,  
            )
            .putAlias(AliasMetadata.builder("alias2").routing("1,2").build())
        + "      },"
        final Metadata.Builder builder = Metadata.builder();
        for (int i = 1; i <= generations; i++) {
        Metadata.Builder spyBuilder;
        }
        + "          }\n"  
            assertEquals(1, keyProperties.size());
public class MetadataTests extends OpenSearchTestCase {
    public void testUnknownFieldClusterMetadata() throws IOException {
    }
            Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");  
        assertThat(  
        assertEquals(metadata.resolveWriteIndexRouting(null, null), null);
                MapperPlugin.NOOP_FIELD_FILTER
            b.put(new DataStream(name, createTimestampField("@timestamp"), indices, indices.size()));
        validateDataStreams(metadata.getIndicesLookup(), (DataStreamMetadata) metadata.customs().get(DataStreamMetadata.TYPE));  
        assertThat(  
            .put("index_template_v2_" + randomAlphaOfLength(3), ComposableIndexTemplateTests.randomInstance());  
            .settings(settings(Version.CURRENT))  
        assertThat(indicesLookup.size(), equalTo(result.indices.size() + result.backingIndices.size() + 1));
        Metadata builtMetadata;  
        Metadata metadata = b.build();  
            )
        Boolean aWriteIndex = randomBoolean() ? null : randomBoolean();
        }
            assertEquals(2, properties.size());  
            assertNotNull(indicesLookup.get(index.getName()).getParentDataStream());
        try {  
        );
            randomVotingConfig(),  
                    .putAlias(AliasMetadata.builder("aa").build())  
 * Modifications Copyright OpenSearch Contributors. See
import static org.mockito.Mockito.times;
        assertThat(metadata.dataStreams().size(), equalTo(numDataStreams));  
        for (int k = 1; k <= numBackingIndices; k++) {
                if (index.equals("index1")) {
        try {
        compareMetadata(Metadata.EMPTY_METADATA, builtMetadata, true, true, false);
        + "            \"first\": {\n"
        try {
        Metadata metadata2 = Metadata.builder()
            e.getMessage(),
                    + index.getName()
                        Settings.builder().put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
            assertIndexMappingsNoFields(mappings, "index1");
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        + "            \"area\": {\n"
import java.util.ArrayList;
            final Map<String, List<AliasMetadata>> aliases = metadata.findAllAliases(new String[] { "index" });  
        b.put(new DataStream(dataStreamName, createTimestampField("@timestamp"), backingIndices, lastBackingIndexNum));  
            aliasToIndices.put(alias, new HashSet<>(randomSubsetOf(randomIntBetween(1, 3), indices)));
        // additional text before number  
        while (nodes.size() < size) {  
        verify(spyBuilder, times(0)).buildMetadataWithRecomputedIndicesLookups();
    }  
            is("Alias [alias1] has index routing associated with it [1], and was provided with routing value [0], rejecting operation")
        verify(spyBuilder, times(1)).buildMetadataWithPreviousIndicesLookups();
        );
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                new String[] { "index1" },  
            b.put(im, false);
            indicesLookup.put(indexMeta.getIndex().getName(), new IndexAbstraction.Index(indexMeta, dataStreamAbstraction));
            for (int j = 1; j <= numBackingIndices; j++) {  
                        Settings.builder()
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import java.io.IOException;
            metadataBuilder.build();  
        compareMetadata(previousMetadata, builtMetadata, true, true, true);  
        DataStream dataStream = DataStreamTests.randomInstance();
        builtMetadata = spyBuilder.put(dataStream).version(previousMetadata.version() + 1).build();  
        }
        assertEquals(previousMetadata.transientSettings(), newMetadata.transientSettings());  
        builder.endObject();
        );
        assertTrue(typeProperties.containsKey("suggest"));
        final Metadata metadata3 = Metadata.builder(metadata1).clusterUUIDCommitted(!metadata1.clusterUUIDCommitted()).build();
                    .putMapping(mapping)
                IndexMetadata.builder("index2")
        if (checkVersionIncrement == true) {
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(validIdx.getIndex())));  
            .build();
                IndexMetadata.builder(dataStreamName).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1).build(),  
            .put(
                    .numberOfReplicas(1)
            this.backingIndices = backingIndices;
        for (IndexMetadata indexMeta : backingIndices) {
    }
                is(
                    .numberOfShards(1)
        + "              \"type\": \"keyword\"\n"
        + "          \"properties\": {\n"  
        builder.addTombstone(new Index("idx2", UUIDs.randomBase64UUID()));
        final Metadata orig = randomMetadata();
            assertEquals(previousMetadata.templatesV2(), newMetadata.templatesV2());  
        }
            is("index/alias [alias4] provided with routing value [1,2] that resolved to several routing values, rejecting operation")
        // don't expect any exception when validating a system without indices that would conflict with future backing indices
        TemplatesMetadata.Builder builder = TemplatesMetadata.builder();
            aliasToIndices.forEach((key, value) -> {
        Metadata.Builder b = Metadata.builder();
                    .putAlias(AliasMetadata.builder("alias1").build())
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
            backingIndices.size()  
        }
        builder.startObject();  
            .clusterUUID(randomAlphaOfLength(11))
        }  
        }
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                ).numberOfShards(1).numberOfReplicas(1)
            indices.add(randomAlphaOfLength(10));  
        }  
                        Settings.builder()
                new String[] { "index" }
            )  
                value.getWriteIndex().getIndex().getName(),  
        spyBuilder = spy(Metadata.builder());
import org.opensearch.core.index.Index;  
        for (int i = 0; i < properAliases; i++) {
            .putAlias(AliasMetadata.builder("index").build());
        originalMeta.writeTo(out);  
            metadata.resolveIndexRouting("0", "alias1");
            metadata.resolveIndexRouting("1", "alias2");
    public void testIsSegmentReplicationDisabled() {  
                .build();  
        MappingMetadata originalMappingMetadata = new MappingMetadata(
/*
        assertThat("0", equalTo(metadataTwoIndices.resolveWriteIndexRouting("0", "alias1")));
            fail();
        assertEquals(metadata.resolveWriteIndexRouting("0", "index"), "0");  
            assertThat(aliasMetadataList.get(1).alias(), equalTo("alias2"));  
            assertThat(e.getMessage(), startsWith("index, alias, and data stream names need to be unique"));  
            )
            randomVotingConfigExclusions()
        + "        },\n"  
            indices.add(im.getIndex());
        IndexMetadata.Builder builder = IndexMetadata.builder("index")
            spyBuilder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(backingIndex));
            lastBackingIndexNum = randomIntBetween(lastBackingIndexNum + 1, lastBackingIndexNum + 50);  
    }  
        }
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        // don't expect any exception when validating against non-backing indices that don't conform to the backing indices naming  
        );  
    }
            .build();
        final IndexGraveyard graveyard = IndexGraveyardTests.createRandom();  
        + "        \"birth\": {\n"
        Metadata.FORMAT.toXContent(builder, originalMeta);
        if (compareIndicesLookups == true) {
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata2));
        verifyTemplatesMetadata(templatesMetadata);
                )
            assertEquals(2, mappings.size());
            .put(buildIndexMetadata("index", "alias", randomBoolean() ? null : randomBoolean()).build(), randomBoolean())
            )
            assertEquals(0, mappings.size());
import static org.mockito.Mockito.spy;  
        int lastBackingIndexNum = 0;
        Boolean indexBHidden
            assertLeafs(addressProperties, "street", "area");
        final Metadata metadata3 = Metadata.builder(metadata2).build();
import java.util.Set;  
        List<IndexMetadata> backingIndices = new ArrayList<>(generations);
                    .patterns(Arrays.asList("bar-*", "foo-*"))
    }  
                            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            );  
        + "            }\n"
                    .numberOfShards(1)
        assertEquals(2, address.size());
        final TemplatesMetadata templatesMetadata2 = getTemplatesMetadata(2);
                    + "]) conflicts with data stream]"
        assertEquals(metadata.resolveWriteIndexRouting(null, "index"), null);
            createTimestampField("@timestamp"),
        // don't expect any exception when validating against (potentially backing) indices that can't create conflict because of
        assertThat(
            int numBackingIndices = randomIntBetween(1, 4);
            )
    @SuppressWarnings("unchecked")
        {
                IndexTemplateMetadata.builder("template_1")
 *     http://www.apache.org/licenses/LICENSE-2.0
        String dataStreamName = "foo-datastream";  
import org.opensearch.core.xcontent.XContentParser;
            final Metadata fromXContentMeta = Metadata.fromXContent(parser);
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
        // index, no alias
        assertThat(expectThrows(NullPointerException.class, () -> builder.customs(mapBuilder)).getMessage(), containsString(key));  
        mapBuilder.put(key, null);
        {  
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));
        BytesReference metadata = BytesReference.bytes(  
        for (String alias : randomSubsetOf(randomIntBetween(1, 10), indices)) {  
        Metadata metadata2 = Metadata.builder().coordinationMetadata(coordinationMetadata2).build();
        );
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
                "data stream [foo-datastream] could create backing indices that conflict with 1 existing index(s) or alias(s) "  
            .numberOfShards(1)
        Metadata metadataTwoIndices = Metadata.builder(metadata).put(builder2).build();
        final XContentBuilder builder = JsonXContent.contentBuilder();
import java.util.HashMap;
                    .putMapping(mapping)  
            assertNotNull(typeProperties);
    }
        Metadata.Builder b = Metadata.builder()
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
import java.util.HashSet;  
        {
        }
        assertTrue(typeProperties.containsKey("age"));  
 * this file be licensed under the Apache-2.0 license or a
            List<AliasMetadata> aliasMetadataList = aliases.get("index");
        // adding new index - all indices lookups should get re-computed  
        + "        \"address\": {\n"
                    .build()  
            assertThat(indicesLookup.get(index.getName()).getParentDataStream().getName(), equalTo(dataStreamName));  
            final Map<String, MappingMetadata> mappings = metadata.findMappings(  
                    + conflictingName  
            .numberOfReplicas(0)
            assertEquals(previousMetadata.getCustoms(), newMetadata.getCustoms());
            this.indices = indices;
        assertNotNull(address);
        }
                    .putMapping(originalMappingMetadata)
        return nodes;  
    }
            exception.getMessage(),  
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(
        int generations = 10;  
        + "          }\n"  
            bWriteIndex = randomFrom(Boolean.FALSE, null);
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
import java.util.stream.Collectors;  
                    .putMapping(FIND_MAPPINGS_TEST_ITEM)
                        + " resolved to several routing values, rejecting operation"  
            .numberOfReplicas(1);  
import org.opensearch.core.common.Strings;
    }
        IndexMetadata standaloneIndexConflictingWithBackingIndices = createBackingIndex(dataStreamName, 2 * generations).build();
                .numberOfShards(1)  
    public void testFindAliases() {  
            assertNotNull(name);
            metadataBuilder.put(indexBuilder);  
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata2));
        assertTrue(typeProperties.containsKey("ip"));
        }  
            )  
        Metadata.Builder b = Metadata.builder();
    public void testBuilderRejectsDataStreamWithConflictingBackingIndices() {
            b.put(im, false);  
        // manually building the indices lookup as going through Metadata.Builder#build would trigger the validate method and would fail
                    "index/alias [alias2] provided with routing value [1,2] that"
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertTrue(sourceAsMap.containsKey("_source"));
    public void testValidateDataStreamsAllowsPrefixedBackingIndices() {
            .numberOfShards(1)
            assertThat(aliasMetadataList.get(1).alias(), equalTo("alias2"));
            dataStreamName,  
            });
        + "              \"type\": \"geo_shape\",  \n"
            e.getMessage(),
        assertEquals(3, sourceAsMap.size());
        assertTrue(sourceAsMap.containsKey("_source"));  
                equalTo(DataStream.getDefaultBackingIndexName(name, ds.getGeneration()))
            if (i % 2 == 0 && i < generations) {
            });
        }
        final Metadata metadata = Metadata.builder()  
        + "        \"enabled\":false\n"  
        if (randomBoolean()) {
        if (compareIndicesLookups == true && compareTemplates == true) {
import static org.hamcrest.Matchers.startsWith;
                "index, alias, and data stream names need to be unique, but the following duplicates were found ["
        final BytesStreamOutput out = new BytesStreamOutput();  
            MappingMetadata docMapping = mappings.get("index1");
            MappingMetadata mappingMetadata = mappings.get("index1");
            assertLeafs(propertiesProperties, "key");
                    + "'"  
        assertThat(  
        Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");
                        + "of [index]) conflicts with index]"
        DataStream dataStream = new DataStream(  
        + "                }\n"
        } catch (IllegalArgumentException ex) {  
        // manually building the indices lookup as going through Metadata.Builder#build would trigger the validate method already
            Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
        return builder.build();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
            assertThat(value.getIndices().size(), equalTo(ds.getIndices().size()));
    public void testSerializationClusterUUID() throws IOException {
                        + "and was provided with routing value [0], rejecting operation"  
                    .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        + "        },\n"  
    public void testTemplatesMetadata() {
        assertTrue(properties.containsKey(field));
                    .settings(
        final XContentBuilder builder = JsonXContent.contentBuilder();
        assertTrue("metadata equal when not adding index deletions", Metadata.isGlobalStateEquals(metadata2, metadata3));
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        + "        \"required\":true\n"  
        IllegalStateException e = expectThrows(IllegalStateException.class, b::build);  
        @SuppressWarnings("unchecked")  
        IndexAbstraction.DataStream dataStreamAbstraction = new IndexAbstraction.DataStream(dataStream, backingIndices);
        }  
                .numberOfShards(1)
            assertIndexMappingsNotFiltered(mappings, "index3");
        assertEquals(metadata.resolveWriteIndexRouting("0", null), "0");
 * Unless required by applicable law or agreed to in writing,
        + "      },"
            assertNotNull(propertiesProperties);  
        Metadata metadata = Metadata.builder()  
        verifyTemplatesMetadata(templatesMetadata2);  
        final String dataStreamName = "my-data-stream";
        DataStream dataStream = new DataStream(
    }
    @SuppressWarnings("unchecked")
        }
            assertTrue(sourceAsMap.containsKey("_source"));  
        int lastBackingIndexNum = 0;
    public void testXContentClusterUUID() throws IOException {  
        + "          \"type\": \"object\",\n"
            .put(  
        int indexCount = randomIntBetween(10, 100);  
                b.put(idx, true);  
        {
        final Metadata metadata2 = Metadata.builder(metadata1).clusterUUID(UUIDs.randomBase64UUID()).build();  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        final Metadata fromStreamMeta = Metadata.readFrom(  
            .put(IndexMetadata.builder("foo-index").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
                IndexMetadata.builder("index")
                    .numberOfReplicas(0)
                IndexTemplateMetadata.builder("template_2")
            exception.getMessage(),
        }
        compareMetadata(previousMetadata, builtMetadata, false, true, true);  
            backingIndices.add(idx);
            assertFalse(fieldProp.containsKey("properties"));
    }
                false
            containsString(
            IndexAbstraction value = metadata.getIndicesLookup().get(name);  
                return MapperPlugin.NOOP_FIELD_PREDICATE;
        String alias = randomAlphaOfLength(5);
        verify(spyBuilder, times(0)).buildMetadataWithRecomputedIndicesLookups();
                    .build()
        }  
    @SuppressWarnings("unchecked")
    }  
        Index index = standaloneIndexConflictingWithBackingIndices.getIndex();  
        Metadata metadata = metadataBuilder.build();
        );  
        md.put(randomDataStream);  
            .numberOfReplicas(1);
                IllegalStateException.class,
        assertThat(  
        + "      \"_routing\": {\n"
        IndexMetadata invalidIdx = createBackingIndex(dataStreamName, 2).build();
        MappingMetadata docMapping = mappings.get(index);
            assertTrue(address.containsKey("type"));
        verify(spyBuilder, times(1)).buildMetadataWithRecomputedIndicesLookups();  
    }  
    private static final String FIND_MAPPINGS_TEST_ITEM = "{\n"  
        }
        Metadata metadata1 = Metadata.builder().templates(templatesMetadata1).build();
        List<AliasMetadata> aliases = metadata.findAliases(new GetAliasesRequest().aliases("a*", "-*b", "b*"), new String[] { "index" })
    public void testValidateAliasWriteOnly() {
        Metadata metadata = Metadata.builder().put(buildIndexMetadata(indexA, alias, aWriteIndex)).build();
        String indexB = randomAlphaOfLength(7);
        final boolean compareTemplates,
    }
    public void testSerialization() throws IOException {
            JsonXContent.contentBuilder().startObject().startObject("meta-data").field("random", "value").endObject().endObject()
            .build();  
        assertEquals(3, sourceAsMap.size());
        final String conflictingIndex = DataStream.getDefaultBackingIndexName(dataStreamName, 2);
            .build();  
            assertNotNull(propertiesProperties);  
    public void testFindMappings() throws IOException {
        + "                  \"type\" : \"keyword\"\n"  
                }  
        } catch (IllegalArgumentException ex) {
import org.opensearch.plugins.MapperPlugin;
        Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");
            )
            )  
    }  
        // alias with invalid index routing.
        Boolean bWriteIndex;  
        for (String field : fields) {
                    .build()
        Metadata.Builder metadataBuilder = Metadata.builder().put(indexMetadataBuilder);  
            .clusterUUID("uuid" + randomAlphaOfLength(3))
            DataStream ds = metadata.dataStreams().get(name);
            MappingMetadata mappingMetadata = mappings.get("index3");
    public static Metadata randomMetadata() {
                    .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())
        assertThat(
        assertThat(metadata2.templates(), is(templatesMetadata2.getTemplates()));
        }  
            illegalStateException.getMessage(),
        // create some backing indices for a data stream
            Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
        String indexA = randomAlphaOfLength(6);  
        assertThat(aliases.size(), equalTo(2));
            assertEquals(6, typeProperties.size());
    public void testFindAliasWithExclusionAndOverride() {
            assertNotNull(addressProperties);  
            List<AliasMetadata> aliasMetadataList = aliases.get("index");
            .put(
        {  
 * not use this file except in compliance with the License.
        }
    public void testBuilderForDataStreamWithRandomlyNumberedBackingIndices() {  
            .numberOfReplicas(0);
        + "}";
            .numberOfShards(1)  
        } catch (IllegalStateException e) {
            "_doc",  
        + "          \"type\": \"nested\",\n"  
            Map<String, Object> valueProperties = (Map<String, Object>) value.get("properties");  
        Metadata.FORMAT.toXContent(builder, originalMeta);
                IndexMetadata.builder("index")
            .build();
        );
        verify(spyBuilder, times(1)).buildMetadataWithPreviousIndicesLookups();
import org.opensearch.common.settings.Settings;
        }
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));  
                    + "] conflicts with index]"  
                ex.getMessage(),
 * this work for additional information regarding copyright
        {  
        for (IndexMetadata indexMeta : backingIndices) {  
            if (i % 2 == 0 && i < generations) {
            .get("index");  
            Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");  
            randomVotingConfig(),
            .clusterUUID(UUIDs.randomBase64UUID())  
        for (Index backingIndex : dataStream.getIndices()) {  
                    .settings(
        + "            },\n"  
                    .settings(Settings.builder().put("random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build())  
            );
        assertThat(fromStreamMeta.clusterUUIDCommitted(), equalTo(originalMeta.clusterUUIDCommitted()));
    }  
            final Map<String, List<AliasMetadata>> aliases = metadata.findAliases(new GetAliasesRequest(), Strings.EMPTY_ARRAY);
        assertThat(metadata.dataStreams().get(dataStreamName).getName(), equalTo(dataStreamName));
            .put(validIdx, false)
        List<IndexMetadata> backingIndices = new ArrayList<>(generations);  
        for (Index index : result.indices) {
    }
            randomVotingConfig(),
import org.opensearch.indices.replication.common.ReplicationType;  
            .build();
        Metadata metadata = Metadata.builder()
        if (Boolean.TRUE.equals(aWriteIndex)) {
                    + "] could create backing indices that conflict with 1 existing index(s) or alias(s) including '"
        reset(spyBuilder);
    public void testFindAliasWithExclusion() {
            assertThat(value.isHidden(), is(false));
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .numberOfShards(1)
        } else {  
    ) {
    }
 * under the License.  
        }
            )
        builtMetadata = spyBuilder.version(previousMetadata.version() + 1).build();  
                IndexMetadata.builder("index1")  
        assertEquals(previousMetadata.settings(), newMetadata.settings());
import org.opensearch.common.util.set.Sets;
                .build();
        );
            backingIndices.add(im.getIndex());
            Map<String, Object> doc = (Map<String, Object>) stringObjectMap.get("_doc");
    private static void assertIndexMappingsNoFields(final Map<String, MappingMetadata> mappings, String index) {  
            .putAlias(AliasMetadata.builder("alias2").writeIndex(true).build());
        );
        assertEquals(previousMetadata.clusterUUIDCommitted(), newMetadata.clusterUUIDCommitted());  
        }  
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting("1", "alias2"));
        Exception exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting("0", "alias1"));
        + "              \"type\": \"keyword\"\n"  
        final int numBackingIndices = randomIntBetween(2, 5);
            );
        final boolean checkVersionIncrement  
    public void testResolveWriteIndexRouting() {
        verify(spyBuilder, times(0)).buildMetadataWithPreviousIndicesLookups();
                    settings(Version.CURRENT)
            assertTrue(typeProperties.containsKey("ip"));  
            () -> metadataTwoIndices.resolveIndexRouting("1", "alias0")  
        final Metadata.Builder builder = Metadata.builder();
            () -> validateDataStreams(indicesLookup, dataStreamMetadata)
        assertFalse(Metadata.isGlobalStateEquals(metadata1, metadata2));
        {
 * You may obtain a copy of the License at  
        validateDataStreams(indicesLookup, dataStreamMetadata);
import static org.mockito.Mockito.verify;
        String indexBName,  
        assertThat(aliases.size(), equalTo(1));
            assertThat(ds, notNullValue());  
        }
            final Metadata fromXContentMeta = Metadata.fromXContent(parser);
    }
            .persistentSettings(Settings.builder().put(setting.getKey(), "persistent-value").build())
            assertNotNull(fieldProp);
        IndexMetadata.Builder builder = IndexMetadata.builder("index")
    private static void compareMetadata(
        final String conflictingName = DataStream.getDefaultBackingIndexName(dataStreamName, 2);
        BytesReference metadata = BytesReference.bytes(  
            .creationDate(randomNonNegativeLong())
            assertIndexMappingsNotFiltered(mappings, "index1");
        DataStreamMetadata dataStreamMetadata = new DataStreamMetadata(Map.of(dataStreamName, dataStream));  
            assertTrue(properties.containsKey("type"));
            assertThat(aliases.size(), equalTo(0));  
                equalTo(  
            )
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        validateDataStreams(metadata.getIndicesLookup(), (DataStreamMetadata) metadata.customs().get(DataStreamMetadata.TYPE));
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");  
        assertEquals(2, propertiesProperties.size());  
            .clusterUUID(randomAlphaOfLength(10))
            assertEquals(previousMetadata.getConcreteAllOpenIndices(), newMetadata.getConcreteAllOpenIndices());
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            assertThat(aliasMetadataList.size(), equalTo(2));
            // for the indices that we added in the data stream with a "shrink-" prefix, add the non-prefixed indices to the lookup  
        final int numIndices = randomIntBetween(2, 5);
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            .clusterUUIDCommitted(randomBoolean())
            validateDataStreams(metadata.getIndicesLookup(), null);
                new IndexMetadata.Builder(dataStreamName + "-index-without-counter").settings(settings(Version.CURRENT))  
            aliasZeroBuilder.writeIndex(true);
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)  
        {  
            assertNotNull(properties);
            bWriteIndex = randomFrom(Boolean.TRUE, Boolean.FALSE, null);
/*  
        final String indexName = "test";
        final Metadata previousMetadata = randomMetadata();
            .clusterUUIDCommitted(true)  
        {
                    .putMapping(FIND_MAPPINGS_TEST_ITEM)  
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }  
        final Set<VotingConfigExclusion> nodes = new HashSet<>(size);
            .transientSettings(Settings.builder().put("other_setting" + randomAlphaOfLength(3), randomAlphaOfLength(4)).build())  
                index -> field -> randomBoolean()
                indicesLookup.put(indexMeta.getIndex().getName(), new IndexAbstraction.Index(indexMeta, dataStreamAbstraction));  
        final Metadata originalMeta = Metadata.builder().indexGraveyard(graveyard).build();
                .numberOfShards(1)  
        List<Index> allIndices = new ArrayList<>(result.indices);  
            .put(
        // alias with no index routing
            randomVotingConfigExclusions()
        Metadata metadata = createIndices(5, 10, "foo-datastream").metadata;
        builtMetadata = spyBuilder.indices(  
            );
        Metadata metadataTwoIndices = Metadata.builder(metadata).put(builder2).build();
                    + dataStreamName
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 1; i <= generations; i++) {
        }
    }
            assertLeafs(valueProperties, "keyword");
            }  
        assertNotNull(addressProperties);
                request.replaceAliases(Strings.EMPTY_ARRAY);
            assertTrue(sourceAsMap.containsKey("_routing"));
            .hashesOfConsistentSettings(Map.of("a", "b"))
        TemplatesMetadata templatesMetadata1 = TemplatesMetadata.builder()  
        assertLeafs(subFieldsDef, subFields);  
        assertTrue(properties.containsKey("type"));  
            .put(
            .build();
            Exception ex = expectThrows(
            .put(
        } catch (IllegalArgumentException ex) {
        final int numBackingIndices = randomIntBetween(2, 5);  
        return md.build();
            fail();
        exception = expectThrows(IllegalArgumentException.class, () -> metadata.resolveWriteIndexRouting("1", "alias3"));
            .clusterUUIDCommitted(false)  
                .settings(settings(Version.CURRENT))
                IndexMetadata.builder("index3")  
                        && field.startsWith("properties.key.") == false  
    }
                )  
                .numberOfReplicas(1)
            .numberOfReplicas(0)
    }
import java.util.Arrays;  
                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))  
        final List<Index> backingIndices = new ArrayList<>();
        Metadata metadata1 = Metadata.builder().coordinationMetadata(coordinationMetadata1).build();
        }
import org.opensearch.Version;
        IndexMetadata.Builder indexAMeta = IndexMetadata.builder(indexAName)  
        final Metadata previousMetadata,
            randomNonNegativeLong(),
            .build();
        assertEquals(metadata.resolveIndexRouting(null, "alias1"), "1");  
            .clusterUUID(UUIDs.randomBase64UUID())
        + "        \"age\": {\n"
            Map<String, Object> sourceAsMap = mappingMetadata.getSourceAsMap();  
        IllegalArgumentException exception = expectThrows(
        String[] concreteIndices = allIndices.stream().map(Index::getName).collect(Collectors.toList()).toArray(new String[] {});
        reset(spyBuilder);
 * GitHub history for details.
        + "            \"key\" : {\n"
    public void testFindMappingsNoOpFilters() throws IOException {
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
            assertEquals(previousMetadata.getCustoms().get(DataStreamMetadata.TYPE), newMetadata.getCustoms().get(DataStreamMetadata.TYPE));
        Metadata metadata = Metadata.builder()  
            assertTrue(indicesLookup.containsKey(index.getName()));
        {
        }  
    }
        + "              }\n"
        final BytesStreamOutput out = new BytesStreamOutput();
        final XContentBuilder builder = JsonXContent.contentBuilder();
                index,
        final List<Index> indices;
            assertThat(aliasMetadataList.size(), equalTo(1));
        assertEquals(metadata.resolveWriteIndexRouting("0", "alias0"), "0");
            .put(
            List<AliasMetadata> aliasMetadataList = aliases.get("index");  
                if (index.equals("index2")) {
        );
            )
                    + " (alias of ["  
    private void verifyTemplatesMetadata(TemplatesMetadata templatesMetadata) throws IOException {  
    }
package org.opensearch.cluster.metadata;
            is("index/alias [alias2] provided with routing value [1,2] that resolved to several routing values, rejecting operation")
            assertIndexMappingsNoFields(mappings, "index1");  
                index -> field -> (index.equals("index3") && field.endsWith("keyword"))  
        List<AliasMetadata> aliases = metadata.findAliases(new GetAliasesRequest().aliases("*", "-alias1"), new String[] { "index" })  
            assertEquals(1, key.size());  
        final String dataStreamName = "my-data-stream";  
            assertEquals(previousMetadata.getIndicesLookup(), newMetadata.getIndicesLookup());  
        Metadata.Builder b = Metadata.builder();  
            final Map<String, MappingMetadata> mappings = metadata.findMappings(  
        allIndices.addAll(result.backingIndices);
            assertThat(aliasMetadataList.get(0).alias(), equalTo("alias1"));
                mapping = builder.toString();
        }
            final GetAliasesRequest request;
                    .settings(
            Metadata.builder().put(builder).build();
        + "        \"suggest\" : {\n"
                IndexTemplateMetadata.builder("template" + i)
        IndexMetadata.Builder builder2 = IndexMetadata.builder("index2")
        }
                    .putAlias(AliasMetadata.builder("bb").build())
            )
        assertEquals(metadata.resolveIndexRouting("0", null), "0");
            .get("index");
        final Metadata metadata1 = Metadata.builder().indexGraveyard(builder.build()).build();
    }
    }  
    public void testBuildIndicesLookupForDataStreams() {
