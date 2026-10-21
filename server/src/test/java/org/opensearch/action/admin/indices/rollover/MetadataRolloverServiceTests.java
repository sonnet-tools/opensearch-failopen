            .patterns(Collections.singletonList("*"))
        );
                systemIndices,
            .build();
            IllegalArgumentException.class,
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
            indexRouting,
                clusterState,
import java.util.Collections;
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, settingReq)
            assertThat(ds.getWriteIndex(), equalTo(rolloverIndexMetadata));
            Collections.singletonMap(randomAlphaOfLength(2), randomAlphaOfLength(2)),
                .settings(settings(Version.CURRENT))
            } else {
        String alias = randomAlphaOfLength(10);
        } else {
            MetadataFieldMapper mockedTimestampField = mock(MetadataFieldMapper.class);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(info.getTime(), greaterThanOrEqualTo(before));
            AliasAction.Add addAction = (AliasAction.Add) action;
        assertThat(exception.getMessage(), equalTo("new index name may not be specified when rolling over a data stream"));
                foundRemoveWrite = true;
            .putAlias(AliasMetadata.builder("foo-write"))
import org.opensearch.index.mapper.FieldMapper;
        rolloverRequest.getCreateIndexRequest().waitForActiveShards(activeShardCount);
            rolloverTarget = dataStream.getName();
                assertEquals(aliasMetadata.filter().string(), addAction.getFilter());
        } finally {
            null,
 * ownership. Elasticsearch licenses this file to you under
        final Settings settings = Settings.builder()
                createIndexRequest,
        String indexName = randomFrom("foo-123", "bar-xyz");
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            newIndexName = newIndexName == null ? indexPrefix + "2" : newIndexName;
        doThrow(new InvalidIndexNameException("test", "invalid")).when(createIndexService).validateIndexName(any(), any());
            );
            rolloverIndex,
        String sourceAlias = randomAlphaOfLength(10);
                env,
            long after = testThreadPool.absoluteTimeInMillis();
            null,
        verify(createIndexService).validateIndexName(any(), same(clusterState));
    private static IndexMetadata createMetadata(String indexName) {
            );
        );
            null,
            assertThat(info.getMetConditions(), hasSize(1));
        builder.put("template", template);
        DataStream randomDataStream = DataStreamTests.randomInstance();
            sourceIndex,
            .build();
            sourceAlias,
        DataStream dataStream = DataStreamTests.randomInstance();
import static org.mockito.Mockito.verify;
                assertEquals(indexRouting, addAction.getIndexRouting());
        String sourceIndex = randomAlphaOfLength(10);
                clusterState,
            if (action.getIndex().equals(targetIndex)) {
            .build();
/*
            if (action.getIndex().equals(targetIndex)) {
        }
        // not hidden will throw
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());
                systemIndices,
        verify(createIndexService).validateIndexName(any(), same(clusterState));
         * else.
 * this file be licensed under the Apache-2.0 license or a
            } else if (action.getIndex().equals(sourceIndex)) {
import org.opensearch.action.admin.indices.alias.Alias;
        String aliasWithWriteIndex = randomAlphaOfLength(10);
            String sourceIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration());
            assertThat(settings.get(settingKey), equalTo(createIndexRequest.settings().get(settingKey)));
/*
                null,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            sourceAlias
                null,
            sourceAlias,
            assertThat(info.getTime(), greaterThanOrEqualTo(before));
        );
        final DataStream dataStream = DataStreamTests.randomInstance();
        );
            indexAliasesService,
                    .putAlias(AliasMetadata.builder(aliasWithWriteIndex))
            .patterns(Arrays.asList("foo-*", "bar-*"))
        try {
        CreateIndexRequest mappingReq = new CreateIndexRequest().mapping(mapping);
                testThreadPool,
import org.opensearch.common.UUIDs;
        );
                assertEquals(sourceAlias, removeAction.getAlias());
import org.opensearch.index.mapper.MapperService;
                assertTrue(addAction.writeIndex());
            assertEquals(newIndexName, rolloverResult.rolloverIndexName);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.common.settings.Settings;
                null,
            xContentRegistry()
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(sourceIndexName)
            long after = testThreadPool.absoluteTimeInMillis();
        Map<String, AliasMetadata> aliases = new HashMap<>();
            );
        CreateIndexRequest req = new CreateIndexRequest();
import org.opensearch.index.mapper.Mapper;
            assertThat(info.getMetConditions().get(0).value(), equalTo(condition.value()));
        assertTrue(foundRemoveWrite);
        String aliasWithNoWriteIndex = randomAlphaOfLength(10);
        );
        );
            indexRouting,
            equalTo("aliases, mappings, and index settings may not be specified when rolling over a data stream")
import static org.mockito.Mockito.same;
        );
            when(documentMapper.mappingSource()).thenReturn(mapping);
    public void testCreateIndexRequestForDataStream() {
    public void testRolloverAliasActionsWithHiddenAliasAndExplicitWriteIndex() {
                assertFalse(addAction.writeIndex());
            .searchRouting(searchRouting)
        final Settings settings = Settings.builder()
            null,
            .putAlias(AliasMetadata.builder("bar-write").writeIndex(randomBoolean()))
import org.opensearch.cluster.service.ClusterService;
 *
            createDefaultAliasMetadata(sourceAlias, true),
                clusterService,
            new SystemIndices(emptyMap()),
        MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, req);
        Map<String, AliasMetadata> aliases = new HashMap<>();
                assertEquals(sourceAlias, addAction.getAlias());
            IllegalArgumentException.class,
        assertThat(createIndexRequest.index(), equalTo(newWriteIndexName));
            true
                mockIndexNameExpressionResolver
                assertEquals(aliasMetadata.filter().string(), addAction.getFilter());
            Metadata rolloverMetadata = rolloverResult.clusterState.metadata();
            for (Index index : dataStream.getIndices()) {
        boolean foundRemoveWrite = false;
    public void testRolloverAliasActionsWithExplicitWriteIndex() {
                foundRemove = true;
            when(env.sharedDataDir()).thenReturn(null);
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
                Collections.singletonList(dataStream.getName() + "*"),
                assertThat(addAction.writeIndex(), nullValue());
    }
                assertEquals(sourceRouting, addAction.getSearchRouting());
            new ComposableIndexTemplate.DataStreamTemplate()
            when(mockedTimestampFieldType.name()).thenReturn("_data_stream_timestamp");
        String indexRouting = randomAlphaOfLength(10);
            Collections.singletonList("ct"),
        String sourceIndex = randomAlphaOfLength(10);
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
import org.opensearch.common.compress.CompressedXContent;
        final DataStream dataStream = DataStreamTests.randomInstance();
import static org.hamcrest.Matchers.hasSize;
            true,
        final ComponentTemplate ct = new ComponentTemplate(new Template(null, null, aliases), null, null);
        String invalidIndexName = randomAlphaOfLength(10) + "A";
            createDefaultAliasMetadata(sourceAlias, null),
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
 * under the License.
            null,
            MetadataRolloverService.generateRolloverIndexName(indexEndingInNumbers, indexNameExpressionResolver),
            MaxDocsCondition condition = new MaxDocsCondition(randomNonNegativeLong());
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        // hidden shouldn't throw
            null
    }
    public void testValidation() throws Exception {
        String aliasName = randomFrom("foo-write", "bar-write");
            sourceIndex,
    private static AliasMetadata createAliasMetadata(
            Metadata rolloverMetadata = rolloverResult.clusterState.metadata();
            clusterService,
                new StandardAnalyzer()
            null,
        return mockIndicesServices(null);
import org.opensearch.core.index.Index;
        // hidden shouldn't throw
            null,
    public void testCreateIndexRequest() {
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue(foundAddWrite);
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            defaultRolloverIndexName = indexPrefix + "2";
            );
            .settings(settings)
            } else {
        }
        assertThat(createIndexRequest.index(), equalTo(rolloverIndex));
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.indices.InvalidIndexNameException;
        assertThat(
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)
                indicesService,
 * this work for additional information regarding copyright
    }
}
        assertTrue(foundAdd);
        final String newWriteIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration() + 1);
            targetIndex,
        Map<String, AliasMetadata> aliases = new HashMap<>();
            defaultRolloverIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration() + 1);
            mockIndexNameExpressionResolver
            assertThat(info.getMetConditions(), hasSize(1));
            } else {
        final boolean useDataStream = randomBoolean();
         */
            .isHidden(isHidden)
            testThreadPool,
            when(allocationService.reroute(any(ClusterState.class), any(String.class))).then(i -> i.getArguments()[0]);
        String indexName = randomFrom("foo-123", "bar-xyz");
            assertThat(action, instanceOf(AliasAction.Add.class));
        String newIndexName = useDataStream == false && randomBoolean() ? "logs-index-9" : null;
            } else {
    }
    }
            targetIndex,
            ClusterService clusterService = ClusterServiceUtils.createClusterService(testThreadPool);
        assertThat(createIndexRequest.settings(), equalTo(settings));
            IndicesService indicesService = mockIndicesServices(documentMapper);
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
            new AliasValidator(),
            assertThat(alias.getIndices(), hasSize(2));
    ) {
                .numberOfShards(1)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testRejectDuplicateAliasV2() {
                DefaultRemoteStoreSettings.INSTANCE,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String sourceAlias = randomAlphaOfLength(10);
                null,
                assertTrue(addAction.isHidden());
            .put("ct", ct)
        final String rolloverTarget;
import static org.mockito.Mockito.when;
        );
        if (useDataStream) {
            indexTwoBuilder.putAlias(AliasMetadata.builder(aliasWithNoWriteIndex).writeIndex(randomFrom(false, null)));
        final Metadata metadata = Metadata.builder()
        );
        return AliasMetadata.builder(alias).isHidden(isHidden).build();
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            } else {
        try {
        assertThat(actions, hasSize(2));
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, randomBoolean())
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
import java.util.Locale;
            Settings.EMPTY,
                clusterService,
        String targetIndex = randomAlphaOfLength(10);
        final Metadata metadata = Metadata.builder()
                createIndexService,
import org.opensearch.index.shard.IndexEventListener;
            .build();
            sourceRouting,
            );
            );
            null,
            false,
import org.opensearch.index.mapper.DateFieldMapper;
        for (Index index : dataStream.getIndices()) {
        );
            MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
    public void testRolloverClusterStateForDataStream() throws Exception {
        Metadata.Builder builder = Metadata.builder();
            IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
            when(mockedTimestampField.copyTo()).thenReturn(FieldMapper.CopyTo.empty());
            when(env.sharedDataDir()).thenReturn(null);
            .indexRouting(indexRouting)
            MaxDocsCondition condition = new MaxDocsCondition(randomNonNegativeLong());
                assertEquals(sourceAlias, addAction.getAlias());
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
        exception = expectThrows(
        );
        }
            );
                foundRemoveWrite = true;
            rolloverTarget,
            metadataIndexAliasesService,
            targetIndex,
        assertTrue(foundRemoveWrite);
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        List<Condition<?>> metConditions = Collections.singletonList(condition);
        assertTrue(foundRemove);
            Environment env = mock(Environment.class);
        boolean foundAddWrite = false;
        AllocationService allocationService = mock(AllocationService.class);
                new CreateIndexRequest("_na_"),
import org.opensearch.indices.SystemIndices;
        String index2 = randomAlphaOfLength(10);
                metConditions,
                new AliasValidator(),
    }
            builder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
        assertThat(actions, hasSize(2));
                xContentRegistry()
        CreateIndexRequest settingReq = new CreateIndexRequest().settings(Settings.builder().put("foo", "bar"));
            }
        String sourceAlias = randomAlphaOfLength(10);
            equalTo("aliases, mappings, and index settings may not be specified when rolling over a data stream")
                0,
            null,
            assertThat(ds.getIndices(), hasItem(rolloverMetadata.index(sourceIndexName)));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                metadata,
        final Metadata metadata = Metadata.builder()
            null,
            DocumentMapper documentMapper = mock(DocumentMapper.class);
            builder.put(dataStream);
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
                clusterState,
            final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(sourceIndexName)
        final String indexPrefix = randomAlphaOfLength(10);
                foundAddWrite = true;
            null,
        final String aliasName = randomAlphaOfLength(5);
            () -> rolloverService.rolloverClusterState(
            sourceAlias
            ).build(builderContext);
import org.opensearch.index.mapper.MetadataFieldMapper;
            newWriteIndexName,
            null,
            true
        verifyNoMoreInteractions(metadataIndexAliasesService);
                null,
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)
        final Metadata metadata = Metadata.builder()
import org.opensearch.index.mapper.DocumentMapper;
            String newIndexName = randomBoolean() ? "logs-index-9" : null;
    }
        String alias,
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;
                assertThat(action, instanceOf(AliasAction.Add.class));
            RoutingFieldMapper routingFieldMapper = mock(RoutingFieldMapper.class);
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
                null,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            targetIndex,
            .build();
                AliasAction.Remove removeAction = (AliasAction.Remove) action;
        );
            builder.put(indexMetadata);
            sourceIndex,
        IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        if (firstIsWriteIndex == null) {
                metConditions,
        boolean foundAdd = false;
            } else if (action.getIndex().equals(sourceIndex)) {
                false
 * You may obtain a copy of the License at
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                null,
import java.util.List;
import org.opensearch.common.unit.TimeValue;
                null
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            rolloverRequest.getCreateIndexRequest()
        when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).then(returnsFirstArg());
            ComposableIndexTemplate template = new ComposableIndexTemplate(
            true,
            IllegalArgumentException.class,
        );
                .putAlias(AliasMetadata.builder(rolloverTarget).writeIndex(true).build())
            assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                assertEquals(sourceRouting, addAction.getSearchRouting());
                assertTrue(addAction.isHidden());
import org.opensearch.common.CheckedFunction;
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
    }
            ShardLimitValidator shardLimitValidator = new ShardLimitValidator(Settings.EMPTY, clusterService, systemIndices);
import org.opensearch.indices.ShardLimitValidator;
            md.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
            when(indexService.index()).thenReturn(indexMetadata.getIndex());
            String newIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration() + 1);
        String targetIndex = randomAlphaOfLength(10);
            new CreateIndexRequest("_na_"),
                null,
        assertThat(
                null,
            IllegalArgumentException.class,
            )
            Collections.singletonMap(randomAlphaOfLength(2), randomAlphaOfLength(2)),
                assertFalse(addAction.writeIndex());
        builder.put(dataStream);
        assertThat(
        assertThat(
            ClusterService clusterService = ClusterServiceUtils.createClusterService(testThreadPool);
            .put("test-template", template)
        final IllegalArgumentException ex = expectThrows(
        final IllegalArgumentException ex = expectThrows(
        Metadata metadata = metadataBuilder.build();
                indicesService,
                assertEquals(indexRouting, addAction.getIndexRouting());
import static org.hamcrest.Matchers.equalTo;
            } else {
import org.opensearch.indices.DefaultRemoteStoreSettings;
        int num = randomIntBetween(0, 100);
                testThreadPool,
import org.opensearch.cluster.routing.allocation.AllocationService;
            when(mockedTimestampField.fieldType()).thenReturn(mockedTimestampFieldType);
                foundAddWrite = true;
        String targetIndex = randomAlphaOfLength(10);
        String sourceRouting = randomAlphaOfLength(10);
            List<Condition<?>> metConditions = Collections.singletonList(condition);
            .putAlias(AliasMetadata.builder(aliasName).writeIndex(true).build())
 * specific language governing permissions and limitations
            null,
                IndexMetadata.builder(index1)
     */
        final IndexTemplateMetadata template = IndexTemplateMetadata.builder("test-template")
            Collections.singletonList("*"),
            null
                foundAddWrite = true;
            assertThat(alias.getIndices(), hasItem(rolloverIndexMetadata));
        boolean foundRemoveWrite = false;
        exception = expectThrows(
        Metadata.Builder metadataBuilder = Metadata.builder()
        Map<String, AliasMetadata> aliases = new HashMap<>();
            }
                metConditions,
            null,
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(
            MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());
            sourceIndexName = indexPrefix + "1";
            IndexMetadata indexMetadata = (IndexMetadata) invocationOnMock.getArguments()[0];
            equalTo("aliases, mappings, and index settings may not be specified when rolling over a data stream")
                assertEquals(sourceAlias, addAction.getAlias());
                AliasAction.Remove removeAction = (AliasAction.Remove) action;
                aliasName,
            new Template(null, null, aliases),
    }
        );
        );
        assertThat(createIndexRequest.cause(), equalTo("rollover_index"));
import org.opensearch.env.Environment;
            IndexAbstraction ds = rolloverMetadata.getIndicesLookup().get(dataStream.getName());
        verifyNoMoreInteractions(createIndexService);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(builder).build();
        );
            null,
        assertThat(createIndexRequest.cause(), equalTo("rollover_data_stream"));
            new Template(null, null, aliases),
import static org.mockito.Mockito.reset;
            aliasMetadata,
        );
import static org.mockito.AdditionalAnswers.returnsFirstArg;
     * parameter is used for the purpose intended.
        String indexEndingInNumbers = indexPrefix + "-" + num;
        final IndexTemplateMetadata template = IndexTemplateMetadata.builder("test-template")
            when(routingFieldMapper.required()).thenReturn(false);
            .build();
                assertThat(action, instanceOf(AliasAction.Remove.class));
        expectThrows(
import static java.util.Collections.emptyMap;
        MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, Boolean.TRUE);
        String index1 = randomAlphaOfLength(10);
        }
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import static org.hamcrest.Matchers.nullValue;
        );
                new ComposableIndexTemplate.DataStreamTemplate()
import org.opensearch.cluster.metadata.AliasMetadata;
        );
            CompressedXContent mapping = new CompressedXContent(
        assertThat(createIndexRequest.settings().get("index.hidden"), equalTo("true"));
                shardLimitValidator,
        final RolloverRequest rolloverRequest = new RolloverRequest(alias, randomAlphaOfLength(10));
 *    http://www.apache.org/licenses/LICENSE-2.0
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());
            MapperService mapperService = mock(MapperService.class);
            if (action.getIndex().equals(targetIndex)) {
        boolean foundAddWrite = false;
    public void testDataStreamValidation() throws IOException {
                randomBoolean(),
 * not use this file except in compliance with the License.
                randomBoolean(),
package org.opensearch.action.admin.indices.rollover;
        String aliasName = randomFrom("foo-write", "bar-write");
import org.opensearch.index.mapper.MappingLookup;
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
import org.opensearch.cluster.metadata.DataStreamTests;
            return ((CheckedFunction) invocationOnMock.getArguments()[1]).apply(indexService);
                aliasName,
 * software distributed under the License is distributed on an
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
        );
 * compatible open source license.
        assertThat(actions, hasSize(2));
            );
        String indexName = randomFrom("foo-123", "bar-xyz");
    }
            null,
import java.io.IOException;
            () -> MetadataRolloverService.validate(metadata, aliasWithNoWriteIndex, randomAlphaOfLength(5), req)
            equalTo("index-name-000002")
            newIndexName,
    }
        assertThat(actions, hasSize(2));
                    .settings(settings)
            InvalidIndexNameException.class,
            assertEquals(sourceIndexName, rolloverResult.sourceIndexName);
    private IndicesService mockIndicesServices() throws Exception {
import org.opensearch.cluster.ClusterState;
            RolloverInfo info = rolloverMetadata.index(sourceIndexName).getRolloverInfos().get(aliasName);
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                indexName,
        assertTrue(foundAddWrite);
import org.opensearch.cluster.ClusterName;
        // not hidden will throw
        for (AliasAction action : actions) {
                createIndexService,
                false,
        }
    }
        ThreadPool testThreadPool = new TestThreadPool(getTestName());
    public void testAliasValidation() {
        Map filter,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
                AliasAction.Add addAction = (AliasAction.Add) action;
            .metadata(Metadata.builder().put(indexMetadata))
            true,
            null,
        MetadataCreateIndexService createIndexService = mock(MetadataCreateIndexService.class);
        String indexRouting,
                dataStream.getName(),
        );
            .putAlias(AliasMetadata.builder("bar-write").writeIndex(randomBoolean()))
                assertEquals(sourceAlias, addAction.getAlias());
            "<index-name-{now/d}-000002>",
                createIndexRequest,
                assertEquals(sourceAlias, removeAction.getAlias());
            AllocationService allocationService = mock(AllocationService.class);
                foundRemoveWrite = true;
    public void testGenerateRolloverIndexName() {
                Collections.emptyList(),
         * Throws Exception because Eclipse uses the lower bound for
                assertEquals(sourceAlias, ((AliasAction.Add) action).getAlias());
        String targetIndex = randomAlphaOfLength(10);
            sourceAlias
            exception.getMessage(),
            clusterState,
            MetadataRolloverService rolloverService = new MetadataRolloverService(
                foundAdd = true;
        String indexName = randomFrom("foo-123", "bar-xyz");
        ThreadPool testThreadPool = mock(ThreadPool.class);
            }
import org.opensearch.cluster.metadata.Template;
            Collections.singletonList("*"),
                AliasAction.Add addAction = (AliasAction.Add) action;
import org.opensearch.common.xcontent.json.JsonXContent;
                createIndexRequest,
            IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        assertThat(actions, hasSize(2));
            IllegalArgumentException.class,
                assertThat(action, instanceOf(AliasAction.Remove.class));
    }
                newIndexName,
        verifyNoMoreInteractions(metadataIndexAliasesService);
            Environment env = mock(Environment.class);
        boolean foundRemoveWrite = false;
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(
            false,
        MaxDocsCondition condition = new MaxDocsCondition(randomNonNegativeLong());
            null,
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, aliasReq)
            String indexPrefix = "logs-index-00000";
            assertEquals(newIndexName, rolloverResult.rolloverIndexName);
        verifyNoMoreInteractions(createIndexService);
import org.opensearch.common.util.concurrent.ThreadContext;
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
        final CreateIndexClusterStateUpdateRequest createIndexRequest = MetadataRolloverService.prepareCreateIndexRequest(
            }
        );
                null,
                randomBoolean(),
        for (AliasAction action : actions) {
            IllegalArgumentException.class,
        String aliasName = randomFrom("foo-write", "bar-write");
        );
                false,
                assertEquals(sourceAlias, addAction.getAlias());
        rolloverRequest.getCreateIndexRequest().settings(settings);
        final Metadata metadata = Metadata.builder().put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false).put(template).build();
                DateFieldMapper.Resolution.MILLISECONDS,
    }
            long before = testThreadPool.absoluteTimeInMillis();
        for (AliasAction action : actions) {
            IllegalArgumentException.class,
        Boolean firstIsWriteIndex = randomFrom(false, null);
            RolloverInfo info = rolloverMetadata.index(sourceIndexName).getRolloverInfos().get(dataStream.getName());
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
            when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).then(returnsFirstArg());
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        for (AliasAction action : actions) {
            builder.put("template", template);
        }
            );
        final IllegalArgumentException ex = expectThrows(
            IllegalArgumentException.class,
            assertThat(info.getMetConditions().get(0).value(), equalTo(condition.value()));
                assertTrue(addAction.writeIndex());
 */
    }
import org.opensearch.cluster.metadata.AliasValidator;
 * SPDX-License-Identifier: Apache-2.0
        boolean foundRemove = false;
                randomBoolean()
            if (action.getIndex().equals(targetIndex)) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            createIndexRequest.settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards));
            when(documentMapper.routingFieldMapper()).thenReturn(routingFieldMapper);
                assertTrue(addAction.isHidden());
        ThreadPool testThreadPool = new TestThreadPool(getTestName());
import org.opensearch.cluster.metadata.ComponentTemplate;
            } else if (action.getIndex().equals(sourceIndex)) {
        boolean foundRemoveWrite = false;
        );
        final IllegalArgumentException ex = expectThrows(
        );
        );
        String searchRouting,
                "{\"_doc\":" + generateMapping(dataStream.getTimeStampField().getName(), "date") + "}"
        for (AliasAction action : actions) {
import org.opensearch.index.mapper.ContentPath;
 * The OpenSearch Contributors require contributions made to
        assertEquals(sourceIndexName, rolloverResult.sourceIndexName);
        final ComponentTemplate ct = new ComponentTemplate(new Template(null, null, aliases), null, null);
            .put("test-template", template)
        boolean foundRemoveWrite = false;
import org.opensearch.test.ClusterServiceUtils;
                indexAliasesService,
                null,
            dataStream.getName(),
            MappingLookup mappingLookup = new MappingLookup(
            assertEquals(dataStream.getIndices().size() + 1, rolloverMetadata.indices().size());
            when(indexService.getIndexEventListener()).thenReturn(new IndexEventListener() {
            MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
        String targetIndex = randomAlphaOfLength(10);
        assertThat(e.getMessage(), equalTo("no matching index template found for data stream [" + dataStream.getName() + "]"));
    public void testRolloverClusterState() throws Exception {
                mockIndexNameExpressionResolver
            Arrays.asList("foo-*", "bar-*"),
         * can throw Exception. javac seems to be ok inferring something
            } else if (action.getIndex().equals(sourceIndex)) {
            testThreadPool.shutdown();
        String aliasName = randomFrom("foo-write", "bar-write");
                assertThat(action, instanceOf(AliasAction.Add.class));
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
            sourceIndex,
        metadataBuilder.put(indexTwoBuilder);
            assertThat(ds.getIndices(), hasItem(rolloverIndexMetadata));
            null
            targetIndex,
            sourceRouting,
            testThreadPool.shutdown();
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
 * KIND, either express or implied.  See the License for the
            MetadataRolloverService.generateRolloverIndexName("<index-name-{now/d}-1>", indexNameExpressionResolver)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            null,
        );
        boolean foundAddWrite = false;
        assertThat(
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
                assertThat(addAction.writeIndex(), nullValue());
        String sourceIndex = randomAlphaOfLength(10);
            false,
                builder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
            .put("test-template", template)
import org.opensearch.Version;
        );
        );
        assertTrue(foundRemoveWrite);
 * license agreements. See the NOTICE file distributed with
        String sourceRouting = randomAlphaOfLength(10);
            }
                metadata,
            )
                Arrays.asList(mockedTimestampField, dateFieldMapper),
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
        });
                "@timestamp",
            MetadataIndexAliasesService indexAliasesService = new MetadataIndexAliasesService(
    public void testRolloverAliasActionsWithFilterAndExplicitWriteIndex() {
        Boolean isHidden
            if (action.getIndex().equals(targetIndex)) {
            allocationService,
        for (Index index : dataStream.getIndices()) {
        MetadataRolloverService rolloverService = new MetadataRolloverService(
            () -> MetadataRolloverService.generateRolloverIndexName(invalidIndexName, indexNameExpressionResolver)
import org.opensearch.common.settings.IndexScopedSettings;
            assertThat(ds.getIndices(), hasSize(dataStream.getIndices().size() + 1));
            null,
            rolloverRequest.getCreateIndexRequest()
            assertThat(info.getTime(), lessThanOrEqualTo(after));
            when(documentMapper.mappers()).thenReturn(mappingLookup);
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());
            createIndexService,
            MetadataRolloverService.generateRolloverIndexName("index-name-2", indexNameExpressionResolver),
    public void testRolloverAliasActionsWithHiddenAliasAndImplicitWriteIndex() {
import static org.mockito.Mockito.any;
            true
        reset(createIndexService);
                assertTrue(addAction.writeIndex());
            AllocationService allocationService = mock(AllocationService.class);
            exception.getMessage(),
                assertTrue(addAction.isHidden());
import org.opensearch.threadpool.ThreadPool;
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
 */
            null,
                .numberOfReplicas(1);
            IndicesService indicesService = mockIndicesServices();
                indicesService,
            sourceAlias
    }
                new AliasValidator(),
        IllegalArgumentException exception = expectThrows(
            .build();
        );
        for (String settingKey : settings.keySet()) {
        );
        rolloverRequest.getCreateIndexRequest().settings(settings);
            Mapper.BuilderContext builderContext = new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0));
            sourceAlias
    }
            IndexMetadata rolloverIndexMetadata = rolloverMetadata.index(newIndexName);
        newIndexName = newIndexName == null ? defaultRolloverIndexName : newIndexName;
/*
            AliasAction.Add addAction = (AliasAction.Add) action;
        String sourceIndex = randomAlphaOfLength(10);
            null,
import org.opensearch.cluster.metadata.IndexAbstraction;
        final IllegalArgumentException ex = expectThrows(
        final Metadata.Builder builder = Metadata.builder();
 * Unless required by applicable law or agreed to in writing,
            IllegalArgumentException.class,
            env,
import static org.mockito.Mockito.mock;
            MetadataRolloverService.generateRolloverIndexName("index-name-1", indexNameExpressionResolver),
            null,
import org.opensearch.cluster.metadata.DataStream;
            DateFieldMapper dateFieldMapper = new DateFieldMapper.Builder(
 * GitHub history for details.
        } finally {
                randomFrom(Boolean.FALSE, null)
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
                aliasName,
            builder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
            .put("ct", ct)
                null
        String sourceAlias = randomAlphaOfLength(10);
                Settings.EMPTY,
        final CreateIndexClusterStateUpdateRequest createIndexRequest = MetadataRolloverService.prepareDataStreamCreateIndexRequest(
        md.put(randomDataStream);
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
        );
            equalTo("index-name-000003")
            when(documentMapper.type()).thenReturn("_doc");
        String indexName = randomFrom("foo-123", "bar-xyz");
            assertThat(alias.getWriteIndex(), equalTo(rolloverIndexMetadata));
        Metadata.Builder md = Metadata.builder();
import org.opensearch.index.mapper.RoutingFieldMapper;
            ShardLimitValidator shardLimitValidator = new ShardLimitValidator(Settings.EMPTY, clusterService, systemIndices);
        String sourceIndex = randomAlphaOfLength(10);
    }
            when(indexService.getIndexSortSupplier()).thenReturn(() -> null);
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
        String rolloverIndex = randomAlphaOfLength(10);
                assertEquals(sourceAlias, addAction.getAlias());
                null,
            () -> MetadataRolloverService.validate(metadata, randomFrom(index1, index2), randomAlphaOfLength(5), req)
            exception.getMessage(),
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, mappingReq)
        }
     * Test the main rolloverClusterState method. This does not validate every detail to depth, rather focuses on observing that each
        String sourceIndexName = indexPrefix + "1";
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
        String sourceAlias = randomAlphaOfLength(10);
            .build();
                clusterService,
        );
                Settings.EMPTY,
            final SystemIndices systemIndices = new SystemIndices(emptyMap());
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)
                assertEquals(sourceAlias, addAction.getAlias());
        String aliasName = randomFrom("foo-write", "bar-write");
                Version.CURRENT
    private static AliasMetadata createDefaultAliasMetadata(String alias, Boolean isHidden) {
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        );
            .put("test-template", template)
        AliasMetadata aliasMetadata = createAliasMetadata(
        IndicesService indicesService = mock(IndicesService.class);
            )
        MetadataRolloverService rolloverService = new MetadataRolloverService(
        IndicesService indicesService = mockIndicesServices();
        // hidden shouldn't throw
            rolloverTarget = "logs-alias";
            }
            final SystemIndices systemIndices = new SystemIndices(emptyMap());
        String sourceAlias = randomAlphaOfLength(10);
            List<Condition<?>> metConditions = Collections.singletonList(condition);
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, randomBoolean())
            } else if (action.getIndex().equals(sourceIndex)) {
            sourceIndex,
        MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, Boolean.TRUE);
                indexAliasesService,
            Arrays.asList("foo-*", "bar-*"),
        ComposableIndexTemplate template = new ComposableIndexTemplate(
import org.opensearch.cluster.DataStreamTestHelper;
    public void testRolloverClusterStateForDataStreamNoTemplate() throws Exception {
        return IndexMetadata.builder(indexName)
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        assertTrue(foundAddWrite);
import org.opensearch.cluster.metadata.Metadata;
        Metadata metadata = md.build();
        CreateIndexRequest aliasReq = new CreateIndexRequest().alias(new Alias("no_aliases_permitted"));
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
                null,
            indicesService,
            randomBoolean(),
import org.opensearch.threadpool.TestThreadPool;
            null
        CreateIndexRequest req = new CreateIndexRequest();
        }
                assertEquals(sourceAlias, ((AliasAction.Remove) action).getAlias());
        return indicesService;
    }
                aliasName,
            assertThat(alias.getIndices(), hasItem(rolloverMetadata.index(sourceIndexName)));
        final String aliasName = "logs-alias";
            createDefaultAliasMetadata(sourceAlias, null),
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
            sourceAlias
    /**
    }
        builder.put(dataStream);
        final IllegalArgumentException ex = expectThrows(
            } else if (action.getIndex().equals(sourceIndex)) {
import org.opensearch.cluster.metadata.AliasAction;
                randomFrom(Boolean.FALSE, null)
        Environment env = mock(Environment.class);
            IndexService indexService = mock(IndexService.class);
        for (Index index : randomDataStream.getIndices()) {
        assertThat(
        );
            () -> rolloverService.rolloverClusterState(
        String aliasName = randomFrom("foo-write", "bar-write");
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
import org.opensearch.cluster.metadata.IndexMetadata;
        String indexName = randomFrom("foo-123", "bar-xyz");
            IndexAbstraction alias = rolloverMetadata.getIndicesLookup().get(aliasName);
            MetadataRolloverService rolloverService = new MetadataRolloverService(
                null,
            );
 *
            DataStream dataStream = DataStreamTests.randomInstance();
    public void testHiddenAffectsResolvedV2ComponentTemplates() {
            long before = testThreadPool.absoluteTimeInMillis();
            if (action.getIndex().equals(targetIndex)) {
                shardLimitValidator,
                clusterService,
    }
            indicesService,
            assertThat(rolloverIndexMetadata.getNumberOfShards(), equalTo(numberOfShards));
        }
                foundRemoveWrite = true;
        // not hidden will throw
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                randomFrom(Boolean.FALSE, null)
                indexName,
            .settings(settings(Version.CURRENT))
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
                assertEquals(sourceAlias, addAction.getAlias());
                indicesService,
            .putAlias(AliasMetadata.builder("foo-write"))
        final Settings settings = Settings.builder()
            Collections.singletonList("ct"),
    public void testRejectDuplicateAlias() {
            .numberOfShards(1)
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Metadata.Builder builder = Metadata.builder();
                indexName,
            createDefaultAliasMetadata(sourceAlias, true),
        final Settings settings = Settings.builder()
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
        assertThat(exception.getMessage(), equalTo("rollover target [" + aliasWithNoWriteIndex + "] does not point to a write index"));
import java.util.HashMap;
            .build();
                false
    }
            );
                randomBoolean()
            int numberOfShards = randomIntBetween(1, 5);
                dataStream.getName(),
            aliasMetadata,
        String sourceIndex = randomAlphaOfLength(10);
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(
        );
            .build();
                Collections.emptyList(),
                testThreadPool,
        assertThat(exception.getMessage(), equalTo("rollover target is a [concrete index] but one of [alias,data_stream] was expected"));
            assertThat(ds.getType(), equalTo(IndexAbstraction.Type.DATA_STREAM));
        }
            when(mapperService.documentMapper()).thenReturn(documentMapper);
        String mapping = JsonXContent.contentBuilder().startObject().startObject("_doc").endObject().endObject().toString();
        final Metadata metadata = Metadata.builder().put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false).put(template).build();
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(3).getMillis())
        );
 * Modifications Copyright OpenSearch Contributors. See
            sourceIndex,
        }
        );
import static org.hamcrest.Matchers.hasItem;
                null,
         * CheckedFunction's exception type so it thinks the "when" call
 *
            }
import static org.hamcrest.Matchers.instanceOf;
                allocationService,
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, randomBoolean())
        MetadataIndexAliasesService indexAliasesService = new MetadataIndexAliasesService(
            assertEquals(sourceIndexName, rolloverResult.sourceIndexName);
                assertFalse(addAction.writeIndex());
            testThreadPool,
    public void testHiddenAffectsResolvedTemplates() {
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
import org.opensearch.test.OpenSearchTestCase;
            when(allocationService.reroute(any(ClusterState.class), any(String.class))).then(i -> i.getArguments()[0]);
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
        }
        );
    public void testRolloverAliasActions() {
    }
            .filter(filter)
        ClusterService clusterService = ClusterServiceUtils.createClusterService(testThreadPool);
        final RolloverRequest rolloverRequest = new RolloverRequest(dataStream.getName(), randomAlphaOfLength(10));
        exception = expectThrows(
        assertThat(actions, hasSize(2));
        exception = expectThrows(
        );
import static org.hamcrest.Matchers.containsString;
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)
            IllegalArgumentException.class,
        assertEquals(newIndexName, rolloverResult.rolloverIndexName);
            createIndexService,
        MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, Boolean.TRUE);
        assertSame(rolloverResult.clusterState, clusterState);
            AliasAction.Add addAction = (AliasAction.Add) action;
    }
        boolean foundAddWrite = false;
            assertEquals(2, rolloverMetadata.indices().size());
            when(indexService.mapperService()).thenReturn(mapperService);
        final String sourceIndexName;
            null
        String indexRouting = randomAlphaOfLength(10);
            IllegalArgumentException.class,
            sourceIndexName = dataStream.getIndices().get(dataStream.getIndices().size() - 1).getName();
                foundAddWrite = true;
        final String defaultRolloverIndexName;
    public void testRejectDuplicateAliasV2UsingComponentTemplates() {
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
            when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).then(returnsFirstArg());
            mockIndexNameExpressionResolver
        MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
            false,
 */
        return AliasMetadata.builder(alias)
import org.opensearch.index.IndexService;
                    .putAlias(AliasMetadata.builder(aliasWithNoWriteIndex).writeIndex(firstIsWriteIndex))
import java.util.Map;
    }
            .numberOfReplicas(1);
        assertTrue(foundRemoveWrite);
            null,
                allocationService,
            MappedFieldType mockedTimestampFieldType = mock(MappedFieldType.class);
            .put(
                DefaultRemoteStoreSettings.INSTANCE,
            // noinspection unchecked
                foundAddWrite = true;
                null,
            IndexMetadata rolloverIndexMetadata = rolloverMetadata.index(newIndexName);
        for (AliasAction action : actions) {
            null,
        IllegalArgumentException exception = expectThrows(
public class MetadataRolloverServiceTests extends OpenSearchTestCase {
            null,
            MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
        /*
import static org.mockito.Mockito.doThrow;
        MetadataRolloverService.validate(metadata, aliasWithWriteIndex, randomAlphaOfLength(5), req);
    private IndicesService mockIndicesServices(DocumentMapper documentMapper) throws Exception {
            );
        assertTrue(foundAddWrite);
    public void testRolloverAliasActionsWithFilterAndHiddenAliasAndImplicitWriteIndex() {
                metadata,
            .build();
        expectThrows(
import org.opensearch.indices.IndicesService;
            when(mockedTimestampField.name()).thenReturn("_data_stream_timestamp");
                env,
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        when(indicesService.withTempIndexService(any(IndexMetadata.class), any(CheckedFunction.class))).then(invocationOnMock -> {
                testThreadPool,
            IllegalArgumentException.class,
        }
    public void testHiddenAffectsResolvedV2Templates() {
            rolloverIndex,
import org.opensearch.action.support.ActiveShardCount;
            .build();
        );
        assertThat(exception.getMessage(), equalTo("rollover target [" + aliasName + "] does not exist"));
                clusterState,
import org.opensearch.index.mapper.MappedFieldType;
        AliasMetadata aliasMetadata = createAliasMetadata(
            assertThat(info.getTime(), lessThanOrEqualTo(after));
            equalTo(indexPrefix + "-" + String.format(Locale.ROOT, "%06d", num + 1))
            DefaultRemoteStoreSettings.INSTANCE,
                rolloverTarget,
            )
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
        String targetIndex = randomAlphaOfLength(10);
            null,
                false,
                xContentRegistry()
        boolean foundAddWrite = false;
            targetIndex,
            () -> MetadataRolloverService.validate(metadata, aliasName, randomAlphaOfLength(5), req)
        assertEquals(
            IllegalArgumentException.class,
        assertTrue(foundRemoveWrite);
        assertTrue(foundAddWrite);
            MetadataIndexAliasesService indexAliasesService = new MetadataIndexAliasesService(
            null,
            when(mockedTimestampField.multiFields()).thenReturn(FieldMapper.MultiFields.empty());
        Exception e = expectThrows(
            Collections.singletonList(dataStream.getName() + "*"),
            )
                false,
            });
            .build();
        final String indexPrefix = "logs-index-00000";
        MetadataIndexAliasesService metadataIndexAliasesService = mock(MetadataIndexAliasesService.class);
        IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(builder).build();
        IndexMetadata.Builder indexTwoBuilder = IndexMetadata.builder(index2).settings(settings);
                foundRemoveWrite = true;
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), randomAlphaOfLength(5), req)
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(builder).build();
        exception = expectThrows(
            clusterService,
        }
        rolloverRequest.getCreateIndexRequest().waitForActiveShards(activeShardCount);
