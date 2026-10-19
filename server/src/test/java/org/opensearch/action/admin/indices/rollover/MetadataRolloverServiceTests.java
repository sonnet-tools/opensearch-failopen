    }
        }
            IndicesService indicesService = mockIndicesServices();
        assertTrue(foundRemoveWrite);
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), randomAlphaOfLength(5), req)  
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
        final ComponentTemplate ct = new ComponentTemplate(new Template(null, null, aliases), null, null);
                indicesService,  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                createIndexService,
            }  
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
        IndicesService indicesService = mock(IndicesService.class);
        String targetIndex = randomAlphaOfLength(10);
            } else {  
            .putAlias(AliasMetadata.builder(aliasName).writeIndex(true).build())
    }
        );
        );
import java.util.Arrays;
                assertEquals(sourceAlias, addAction.getAlias());
    public void testRolloverAliasActionsWithFilterAndHiddenAliasAndImplicitWriteIndex() {
        AllocationService allocationService = mock(AllocationService.class);  
                Version.CURRENT
        String sourceAlias = randomAlphaOfLength(10);  
                foundRemoveWrite = true;  
            .build();
 * this file be licensed under the Apache-2.0 license or a
            );  
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
        CreateIndexRequest req = new CreateIndexRequest();
            MetadataIndexAliasesService indexAliasesService = new MetadataIndexAliasesService(
            );
        IndicesService indicesService = mockIndicesServices();
        );
                false
            List<Condition<?>> metConditions = Collections.singletonList(condition);  
            long before = testThreadPool.absoluteTimeInMillis();
            )  
                foundAdd = true;  
        assertTrue(foundRemoveWrite);
 * the Apache License, Version 2.0 (the "License"); you may
    public void testRolloverClusterStateForDataStream() throws Exception {
            null,
        assertThat(actions, hasSize(2));
            false,
            .numberOfReplicas(1);
        String index1 = randomAlphaOfLength(10);
public class MetadataRolloverServiceTests extends OpenSearchTestCase {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .build();
        MetadataRolloverService rolloverService = new MetadataRolloverService(
            Collections.singletonMap(randomAlphaOfLength(2), randomAlphaOfLength(2)),
        verify(createIndexService).validateIndexName(any(), same(clusterState));
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());  
            null,
            sourceAlias  
            when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).then(returnsFirstArg());  
        }  
        String indexName = randomFrom("foo-123", "bar-xyz");  
import java.util.List;
                assertEquals(aliasMetadata.filter().string(), addAction.getFilter());
        String targetIndex = randomAlphaOfLength(10);  
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.common.UUIDs;
            null,
            equalTo(indexPrefix + "-" + String.format(Locale.ROOT, "%06d", num + 1))  
            Mapper.BuilderContext builderContext = new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0));
            if (action.getIndex().equals(targetIndex)) {  
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
                testThreadPool,
        // not hidden will throw
                builder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
import org.opensearch.index.mapper.MappedFieldType;
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, aliasReq)
            aliasMetadata,
                Collections.singletonList(dataStream.getName() + "*"),
            );  
        });  
            equalTo("aliases, mappings, and index settings may not be specified when rolling over a data stream")
                foundAddWrite = true;
                assertTrue(addAction.isHidden());
        boolean foundAddWrite = false;
        // hidden shouldn't throw  
                randomFrom(Boolean.FALSE, null)  
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
            () -> MetadataRolloverService.generateRolloverIndexName(invalidIndexName, indexNameExpressionResolver)
            MappingLookup mappingLookup = new MappingLookup(
                assertEquals(sourceRouting, addAction.getSearchRouting());
        );
            MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
            .isHidden(isHidden)
            null,  
        rolloverRequest.getCreateIndexRequest().settings(settings);
        String sourceIndex = randomAlphaOfLength(10);
import org.opensearch.cluster.DataStreamTestHelper;  
        );
        );
        int num = randomIntBetween(0, 100);
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
                assertEquals(sourceAlias, addAction.getAlias());  
                createIndexRequest,  
        boolean foundRemoveWrite = false;  
                false,
                null,
            );  
import java.io.IOException;  
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)  
            builder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
            MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
            .put("test-template", template)  
        return AliasMetadata.builder(alias).isHidden(isHidden).build();  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.common.util.concurrent.ThreadContext;
        MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, Boolean.TRUE);
            assertThat(ds.getIndices(), hasItem(rolloverMetadata.index(sourceIndexName)));
            assertThat(rolloverIndexMetadata.getNumberOfShards(), equalTo(numberOfShards));
            IllegalArgumentException.class,  
            IllegalArgumentException.class,
import org.opensearch.cluster.metadata.DataStreamTests;
            String newIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration() + 1);
                Settings.EMPTY,
    }
        return indicesService;
        String aliasWithNoWriteIndex = randomAlphaOfLength(10);
                assertEquals(sourceAlias, addAction.getAlias());  
            new CreateIndexRequest("_na_"),  
 * software distributed under the License is distributed on an
        final DataStream dataStream = DataStreamTests.randomInstance();  
            xContentRegistry()
            IllegalArgumentException.class,
        );  
                Collections.emptyList(),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            assertEquals(dataStream.getIndices().size() + 1, rolloverMetadata.indices().size());
                clusterService,  
    }
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        String sourceAlias = randomAlphaOfLength(10);
            .settings(settings(Version.CURRENT))  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            when(env.sharedDataDir()).thenReturn(null);
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(builder).build();
            long after = testThreadPool.absoluteTimeInMillis();
            indexAliasesService,
            assertThat(info.getTime(), lessThanOrEqualTo(after));
        String aliasName = randomFrom("foo-write", "bar-write");  
    }
            String newIndexName = randomBoolean() ? "logs-index-9" : null;
            new Template(null, null, aliases),  
 *  
            sourceAlias,  
import org.opensearch.common.settings.IndexScopedSettings;
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
            sourceIndexName = indexPrefix + "1";
        when(indicesService.withTempIndexService(any(IndexMetadata.class), any(CheckedFunction.class))).then(invocationOnMock -> {  
                .settings(settings(Version.CURRENT))  
import org.opensearch.test.OpenSearchTestCase;
        MetadataIndexAliasesService indexAliasesService = new MetadataIndexAliasesService(  
}
                null
        for (AliasAction action : actions) {  
            false,
        return AliasMetadata.builder(alias)
 *
            when(indexService.getIndexSortSupplier()).thenReturn(() -> null);  
        );
            null,
        ComposableIndexTemplate template = new ComposableIndexTemplate(
        Metadata.Builder metadataBuilder = Metadata.builder()  
            exception.getMessage(),  
        Map<String, AliasMetadata> aliases = new HashMap<>();
                false  
        verify(createIndexService).validateIndexName(any(), same(clusterState));
        assertThat(
/*  
 * specific language governing permissions and limitations
        MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
            null,
                randomBoolean(),
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
    }
         */
import static org.mockito.Mockito.verify;  
        ThreadPool testThreadPool = new TestThreadPool(getTestName());
        );
            () -> rolloverService.rolloverClusterState(
import org.opensearch.index.mapper.DateFieldMapper;
            sourceIndexName = dataStream.getIndices().get(dataStream.getIndices().size() - 1).getName();
        assertTrue(foundRemoveWrite);  
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
    }  
        );  
                null,
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
import org.opensearch.cluster.metadata.Template;  
            final SystemIndices systemIndices = new SystemIndices(emptyMap());
                indexName,
        assertThat(  
                Collections.emptyList(),
            null,
            );  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;  
        // not hidden will throw
            builder.put(indexMetadata);  
                null,  
    }
        for (AliasAction action : actions) {  
    public void testRejectDuplicateAliasV2() {  
            assertThat(alias.getIndices(), hasItem(rolloverIndexMetadata));
        return mockIndicesServices(null);
            Environment env = mock(Environment.class);
                null,
        String sourceRouting = randomAlphaOfLength(10);
            when(mockedTimestampField.fieldType()).thenReturn(mockedTimestampFieldType);
            .build();
        MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, req);
            when(allocationService.reroute(any(ClusterState.class), any(String.class))).then(i -> i.getArguments()[0]);
        );  
            DefaultRemoteStoreSettings.INSTANCE,  
        String aliasName = randomFrom("foo-write", "bar-write");  
            () -> MetadataRolloverService.validate(metadata, randomFrom(index1, index2), randomAlphaOfLength(5), req)
     * Test the main rolloverClusterState method. This does not validate every detail to depth, rather focuses on observing that each  
            when(indexService.getIndexEventListener()).thenReturn(new IndexEventListener() {
import org.opensearch.test.ClusterServiceUtils;
                null,
                createIndexRequest,
            targetIndex,
            .build();  
            sourceIndex,  
            DateFieldMapper dateFieldMapper = new DateFieldMapper.Builder(  
            builder.put("template", template);  
                randomBoolean()  
        Metadata metadata = md.build();
import org.opensearch.index.mapper.MetadataFieldMapper;
        );
                mockIndexNameExpressionResolver
        final Settings settings = Settings.builder()  
                foundAddWrite = true;
                null,  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            sourceAlias
        exception = expectThrows(
                aliasName,
        );
        String targetIndex = randomAlphaOfLength(10);  
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            .patterns(Collections.singletonList("*"))
                metadata,  
            MapperService mapperService = mock(MapperService.class);
        final String rolloverTarget;
    }  
        // not hidden will throw
                new AliasValidator(),  
            equalTo("index-name-000003")
        }
            } else if (action.getIndex().equals(sourceIndex)) {
     */
import org.opensearch.cluster.metadata.AliasValidator;  
        MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, Boolean.TRUE);  
        assertThat(
                null
import org.opensearch.threadpool.TestThreadPool;  
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, randomBoolean())
        );
        String alias = randomAlphaOfLength(10);
    }
                "@timestamp",
        Metadata.Builder md = Metadata.builder();
                clusterState,  
            mockIndexNameExpressionResolver  
        String indexName = randomFrom("foo-123", "bar-xyz");
                xContentRegistry()  
            null,
            assertEquals(2, rolloverMetadata.indices().size());
        for (Index index : dataStream.getIndices()) {  
                testThreadPool,
            assertThat(info.getTime(), lessThanOrEqualTo(after));
                null,
            null,
import org.opensearch.index.IndexService;
        assertThat(ex.getMessage(), containsString("index template [test-template]"));  
    public void testDataStreamValidation() throws IOException {
            } else if (action.getIndex().equals(sourceIndex)) {
                Settings.EMPTY,  
        try {
        boolean foundRemove = false;
            .build();
        assertTrue(foundAddWrite);
        }
        final IllegalArgumentException ex = expectThrows(
        );
            dataStream.getName(),
                assertThat(action, instanceOf(AliasAction.Add.class));
        String sourceIndex = randomAlphaOfLength(10);
 * this work for additional information regarding copyright
        boolean foundRemoveWrite = false;
            Environment env = mock(Environment.class);
import static org.hamcrest.Matchers.hasItem;
            } else {
        final Metadata metadata = Metadata.builder()
                indexName,  
            null  
        assertEquals(sourceIndexName, rolloverResult.sourceIndexName);
            ShardLimitValidator shardLimitValidator = new ShardLimitValidator(Settings.EMPTY, clusterService, systemIndices);
        final IllegalArgumentException ex = expectThrows(  
 * under the License.  
                assertThat(action, instanceOf(AliasAction.Remove.class));  
    }
        CreateIndexRequest req = new CreateIndexRequest();  
        exception = expectThrows(
                allocationService,
            );
        exception = expectThrows(
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
import static org.mockito.Mockito.reset;
                false,
                .numberOfReplicas(1);
                null,
                .putAlias(AliasMetadata.builder(rolloverTarget).writeIndex(true).build())
import org.opensearch.index.mapper.RoutingFieldMapper;  
            when(documentMapper.type()).thenReturn("_doc");
                randomBoolean(),
        CreateIndexRequest aliasReq = new CreateIndexRequest().alias(new Alias("no_aliases_permitted"));
import org.opensearch.indices.ShardLimitValidator;
        assertThat(actions, hasSize(2));  
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
        );  
            targetIndex,  
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());  
        String mapping = JsonXContent.contentBuilder().startObject().startObject("_doc").endObject().endObject().toString();
            createDefaultAliasMetadata(sourceAlias, null),
        assertTrue(foundAddWrite);
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
            createDefaultAliasMetadata(sourceAlias, true),
 * compatible open source license.
        String indexRouting = randomAlphaOfLength(10);  
            when(env.sharedDataDir()).thenReturn(null);  
                foundRemoveWrite = true;
            when(mockedTimestampField.multiFields()).thenReturn(FieldMapper.MultiFields.empty());
        );  
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)
        String sourceIndexName = indexPrefix + "1";  
                assertThat(addAction.writeIndex(), nullValue());
import org.opensearch.indices.IndicesService;  
import org.opensearch.cluster.metadata.AliasAction;
    public void testRolloverAliasActions() {  
import org.opensearch.cluster.metadata.AliasMetadata;
                mockIndexNameExpressionResolver  
                AliasAction.Add addAction = (AliasAction.Add) action;  
import org.opensearch.index.mapper.Mapper;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.service.ClusterService;  
            defaultRolloverIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration() + 1);
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),  
 * The OpenSearch Contributors require contributions made to  
        );  
        String targetIndex = randomAlphaOfLength(10);
            } else {
        exception = expectThrows(
        when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).then(returnsFirstArg());
import static org.hamcrest.Matchers.hasSize;
        ThreadPool testThreadPool = mock(ThreadPool.class);  
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
                assertTrue(addAction.isHidden());  
                foundAddWrite = true;
                randomBoolean(),
            }
            if (action.getIndex().equals(targetIndex)) {
                assertEquals(sourceAlias, removeAction.getAlias());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Boolean isHidden
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test"))  
            MetadataFieldMapper mockedTimestampField = mock(MetadataFieldMapper.class);
        final IndexTemplateMetadata template = IndexTemplateMetadata.builder("test-template")  
        final Metadata metadata = Metadata.builder().put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false).put(template).build();
            MaxDocsCondition condition = new MaxDocsCondition(randomNonNegativeLong());
                randomFrom(Boolean.FALSE, null)
                metConditions,  
            .filter(filter)  
        for (AliasAction action : actions) {  
            .patterns(Arrays.asList("foo-*", "bar-*"))
            );
            IllegalArgumentException.class,
            createIndexService,  
            assertEquals(sourceIndexName, rolloverResult.sourceIndexName);
            // noinspection unchecked
            rolloverTarget = dataStream.getName();  
import org.opensearch.action.admin.indices.alias.Alias;  
                DefaultRemoteStoreSettings.INSTANCE,  
            null,
            InvalidIndexNameException.class,
        boolean foundAddWrite = false;
                systemIndices,  
        );
            String sourceIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration());  
        String sourceAlias = randomAlphaOfLength(10);
                indexName,
        assertThat(
        } finally {
                clusterService,
            .build();
            null,  
            allocationService,
            Collections.singletonList("*"),  
            true,
            testThreadPool.shutdown();
            Metadata rolloverMetadata = rolloverResult.clusterState.metadata();
            .build();
            IllegalArgumentException.class,
        Metadata.Builder builder = Metadata.builder();
        String aliasName = randomFrom("foo-write", "bar-write");
                metadata,
            if (action.getIndex().equals(targetIndex)) {
 * You may obtain a copy of the License at  
        CreateIndexRequest mappingReq = new CreateIndexRequest().mapping(mapping);  
        final Metadata metadata = Metadata.builder().put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false).put(template).build();
            .putAlias(AliasMetadata.builder("bar-write").writeIndex(randomBoolean()))  
        boolean foundAddWrite = false;
        final CreateIndexClusterStateUpdateRequest createIndexRequest = MetadataRolloverService.prepareDataStreamCreateIndexRequest(
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(sourceIndexName)
        Map<String, AliasMetadata> aliases = new HashMap<>();
            assertThat(ds.getType(), equalTo(IndexAbstraction.Type.DATA_STREAM));  
            sourceAlias
            when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).then(returnsFirstArg());
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
            } else {
        boolean foundAddWrite = false;
import org.opensearch.index.mapper.FieldMapper;  
    private static IndexMetadata createMetadata(String indexName) {
                clusterState,
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(  
                assertTrue(addAction.writeIndex());
                assertTrue(addAction.writeIndex());
            IllegalArgumentException.class,  
                testThreadPool,  
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                assertFalse(addAction.writeIndex());
            Collections.singletonList(dataStream.getName() + "*"),
            assertThat(info.getTime(), greaterThanOrEqualTo(before));
        expectThrows(  
    public void testCreateIndexRequest() {
            MetadataRolloverService.generateRolloverIndexName(indexEndingInNumbers, indexNameExpressionResolver),
                    .putAlias(AliasMetadata.builder(aliasWithNoWriteIndex).writeIndex(firstIsWriteIndex))
        String aliasName = randomFrom("foo-write", "bar-write");
            MetadataRolloverService.generateRolloverIndexName("index-name-1", indexNameExpressionResolver),  
        String sourceIndex = randomAlphaOfLength(10);
import java.util.HashMap;  
            sourceIndex,
            true
        final String aliasName = "logs-alias";
        List<Condition<?>> metConditions = Collections.singletonList(condition);  
        String sourceIndex = randomAlphaOfLength(10);
            assertThat(ds.getWriteIndex(), equalTo(rolloverIndexMetadata));
    public void testHiddenAffectsResolvedTemplates() {
            () -> rolloverService.rolloverClusterState(
                systemIndices,
            IndexMetadata rolloverIndexMetadata = rolloverMetadata.index(newIndexName);  
            targetIndex,  
            exception.getMessage(),
            null
            randomBoolean(),
import org.opensearch.cluster.ClusterState;
        assertThat(exception.getMessage(), equalTo("rollover target [" + aliasName + "] does not exist"));  
        );  
            IllegalArgumentException.class,  
                indicesService,
            indexTwoBuilder.putAlias(AliasMetadata.builder(aliasWithNoWriteIndex).writeIndex(randomFrom(false, null)));  
        assertThat(createIndexRequest.index(), equalTo(rolloverIndex));
        Boolean firstIsWriteIndex = randomFrom(false, null);
            ).build(builderContext);  
            );
        for (AliasAction action : actions) {
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, mappingReq)  
        assertThat(e.getMessage(), equalTo("no matching index template found for data stream [" + dataStream.getName() + "]"));  
                assertEquals(sourceAlias, ((AliasAction.Add) action).getAlias());
        String sourceAlias = randomAlphaOfLength(10);
                null,  
                false,
        String index2 = randomAlphaOfLength(10);  
        );
import org.opensearch.index.mapper.MapperService;  
            sourceRouting,  
import static org.mockito.AdditionalAnswers.returnsFirstArg;  
            sourceAlias
                AliasAction.Remove removeAction = (AliasAction.Remove) action;
                new CreateIndexRequest("_na_"),  
        assertSame(rolloverResult.clusterState, clusterState);  
            assertThat(action, instanceOf(AliasAction.Add.class));  
            return ((CheckedFunction) invocationOnMock.getArguments()[1]).apply(indexService);
                null,
        String sourceAlias = randomAlphaOfLength(10);
            assertEquals(newIndexName, rolloverResult.rolloverIndexName);  
        String aliasName = randomFrom("foo-write", "bar-write");
        String rolloverIndex = randomAlphaOfLength(10);  
            null,  
        final IllegalArgumentException ex = expectThrows(  
        assertThat(  
        verifyNoMoreInteractions(metadataIndexAliasesService);  
        MetadataRolloverService.validate(metadata, aliasWithWriteIndex, randomAlphaOfLength(5), req);
 * SPDX-License-Identifier: Apache-2.0
        MetadataIndexAliasesService metadataIndexAliasesService = mock(MetadataIndexAliasesService.class);
                newIndexName,
            ComposableIndexTemplate template = new ComposableIndexTemplate(  
        ClusterService clusterService = ClusterServiceUtils.createClusterService(testThreadPool);
                indexAliasesService,
                rolloverTarget,
        );
                assertEquals(sourceAlias, removeAction.getAlias());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            metadataIndexAliasesService,
import org.opensearch.indices.SystemIndices;  
        DataStream dataStream = DataStreamTests.randomInstance();
    public void testCreateIndexRequestForDataStream() {  
                allocationService,  
        String targetIndex = randomAlphaOfLength(10);  
import org.opensearch.index.mapper.ContentPath;  
    public void testHiddenAffectsResolvedV2ComponentTemplates() {  
            assertEquals(sourceIndexName, rolloverResult.sourceIndexName);
            targetIndex,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        }  
    public void testRolloverAliasActionsWithExplicitWriteIndex() {  
        for (AliasAction action : actions) {
        }
                null,
                aliasName,
        for (AliasAction action : actions) {  
            true,  
        for (Index index : randomDataStream.getIndices()) {
        expectThrows(  
            MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
        String aliasName = randomFrom("foo-write", "bar-write");
                    .settings(settings)  
        IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);  
        DataStream randomDataStream = DataStreamTests.randomInstance();  
                foundAddWrite = true;  
            null,  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                assertThat(action, instanceOf(AliasAction.Add.class));
                null,
        final RolloverRequest rolloverRequest = new RolloverRequest(alias, randomAlphaOfLength(10));
            DataStream dataStream = DataStreamTests.randomInstance();
            final SystemIndices systemIndices = new SystemIndices(emptyMap());  
        Metadata metadata = metadataBuilder.build();  
                clusterState,  
        rolloverRequest.getCreateIndexRequest().settings(settings);  
import static org.mockito.Mockito.verifyNoMoreInteractions;
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())  
            "<index-name-{now/d}-000002>",
        Metadata.Builder builder = Metadata.builder();
        assertTrue(foundRemoveWrite);  
            when(documentMapper.mappingSource()).thenReturn(mapping);  
            MetadataRolloverService rolloverService = new MetadataRolloverService(
                assertFalse(addAction.writeIndex());  
        final DataStream dataStream = DataStreamTests.randomInstance();
            IllegalArgumentException.class,  
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
            null,  
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(
    }  
import static org.mockito.Mockito.any;
            new Template(null, null, aliases),  
                foundAddWrite = true;
                testThreadPool,
                assertEquals(sourceAlias, addAction.getAlias());
            )
                assertTrue(addAction.isHidden());  
            MetadataRolloverService rolloverService = new MetadataRolloverService(
                assertEquals(sourceAlias, addAction.getAlias());  
        );  
            IndexMetadata indexMetadata = (IndexMetadata) invocationOnMock.getArguments()[0];
            null
        String sourceRouting = randomAlphaOfLength(10);
 * Licensed to Elasticsearch under one or more contributor  
                env,
import org.opensearch.action.support.ActiveShardCount;  
            .put("test-template", template)
        );  
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(
            rolloverIndex,
        );
            assertThat(alias.getWriteIndex(), equalTo(rolloverIndexMetadata));
            new ComposableIndexTemplate.DataStreamTemplate()
        metadataBuilder.put(indexTwoBuilder);
            .build();  
        final String newWriteIndexName = DataStream.getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration() + 1);
                IndexMetadata.builder(index1)
        return IndexMetadata.builder(indexName)
 * license agreements. See the NOTICE file distributed with
            equalTo("aliases, mappings, and index settings may not be specified when rolling over a data stream")
            () -> MetadataRolloverService.validate(metadata, randomDataStream.getName(), null, settingReq)
        String searchRouting,
            defaultRolloverIndexName = indexPrefix + "2";  
            }  
import org.opensearch.common.unit.TimeValue;  
                clusterService,
        IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
                    .putAlias(AliasMetadata.builder(aliasWithWriteIndex))
        doThrow(new InvalidIndexNameException("test", "invalid")).when(createIndexService).validateIndexName(any(), any());
            final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(sourceIndexName)
         * CheckedFunction's exception type so it thinks the "when" call
        boolean foundRemoveWrite = false;
        List<AliasAction> actions = MetadataRolloverService.rolloverAliasToNewIndex(
    }
            .put("test-template", template)  
            assertThat(alias.getIndices(), hasItem(rolloverMetadata.index(sourceIndexName)));  
            Collections.singletonList("ct"),
            AliasAction.Add addAction = (AliasAction.Add) action;
            newWriteIndexName,  
        }
            when(allocationService.reroute(any(ClusterState.class), any(String.class))).then(i -> i.getArguments()[0]);
                env,  
import org.opensearch.cluster.metadata.Metadata;  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
                null,
    public void testRolloverAliasActionsWithHiddenAliasAndExplicitWriteIndex() {
            .putAlias(AliasMetadata.builder("bar-write").writeIndex(randomBoolean()))  
    public void testRolloverAliasActionsWithFilterAndExplicitWriteIndex() {  
            newIndexName = newIndexName == null ? indexPrefix + "2" : newIndexName;
        String indexEndingInNumbers = indexPrefix + "-" + num;  
        MetadataRolloverService rolloverService = new MetadataRolloverService(
import java.util.Collections;
            for (Index index : dataStream.getIndices()) {
            RolloverInfo info = rolloverMetadata.index(sourceIndexName).getRolloverInfos().get(aliasName);
import static org.hamcrest.Matchers.instanceOf;  
        );
        final Settings settings = Settings.builder()  
                shardLimitValidator,
        final String aliasName = randomAlphaOfLength(5);
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
import static org.mockito.Mockito.when;
            assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
                null,
            Metadata rolloverMetadata = rolloverResult.clusterState.metadata();
            rolloverTarget = "logs-alias";
        assertThat(exception.getMessage(), equalTo("new index name may not be specified when rolling over a data stream"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Collections.singletonMap(randomAlphaOfLength(2), randomAlphaOfLength(2)),
        );  
        /*
import org.opensearch.common.settings.Settings;
            }  
            when(documentMapper.mappers()).thenReturn(mappingLookup);
    public void testRolloverClusterStateForDataStreamNoTemplate() throws Exception {  
        final IllegalArgumentException ex = expectThrows(
 * ownership. Elasticsearch licenses this file to you under  
    public void testHiddenAffectsResolvedV2Templates() {  
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
import static org.hamcrest.Matchers.equalTo;
                dataStream.getName(),  
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)
        assertThat(exception.getMessage(), equalTo("rollover target is a [concrete index] but one of [alias,data_stream] was expected"));  
            env,
        );
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());  
        IllegalArgumentException exception = expectThrows(  
            false,
        final Settings settings = Settings.builder()
            .build();
        String sourceAlias = randomAlphaOfLength(10);  
            .build();
import java.util.Map;  
import org.opensearch.index.mapper.MappingLookup;
                metConditions,
            when(routingFieldMapper.required()).thenReturn(false);
                assertEquals(indexRouting, addAction.getIndexRouting());
        }
        }
            IllegalArgumentException.class,
            builder.put(dataStream);
    public void testRolloverClusterState() throws Exception {  
        final Metadata metadata = Metadata.builder()  
        assertTrue(foundAddWrite);
            MetadataRolloverService.generateRolloverIndexName("index-name-2", indexNameExpressionResolver),
            createDefaultAliasMetadata(sourceAlias, null),  
            IllegalArgumentException.class,
            IllegalArgumentException.class,  
                DefaultRemoteStoreSettings.INSTANCE,
        AliasMetadata aliasMetadata = createAliasMetadata(
            () -> MetadataRolloverService.validate(metadata, aliasName, randomAlphaOfLength(5), req)
            Collections.singletonList("ct"),
import static org.mockito.Mockito.mock;  
    }
    /**
        assertTrue(foundAdd);
        final Metadata.Builder builder = Metadata.builder();  
            AliasAction.Add addAction = (AliasAction.Add) action;
            createIndexRequest.settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards));
            Settings.EMPTY,
        IllegalArgumentException exception = expectThrows(
            null,
        String alias,
        assertTrue(foundAddWrite);
        final String indexPrefix = "logs-index-00000";
            sourceIndex,
        );  
        assertThat(  
            assertThat(info.getTime(), greaterThanOrEqualTo(before));  
        rolloverRequest.getCreateIndexRequest().waitForActiveShards(activeShardCount);
            sourceAlias,
            true,
        builder.put("template", template);
        if (firstIsWriteIndex == null) {
        final IllegalArgumentException ex = expectThrows(
        try {
                shardLimitValidator,
        AliasMetadata aliasMetadata = createAliasMetadata(  
            null,  
        final Metadata metadata = Metadata.builder()  
            IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);  
        }
        assertThat(ex.getMessage(), containsString("index template [test-template]"));  
                "{\"_doc\":" + generateMapping(dataStream.getTimeStampField().getName(), "date") + "}"
                assertEquals(aliasMetadata.filter().string(), addAction.getFilter());
        assertThat(actions, hasSize(2));  
import static org.hamcrest.Matchers.nullValue;
            );
            IndicesService indicesService = mockIndicesServices(documentMapper);
            () -> MetadataRolloverService.validate(metadata, aliasWithNoWriteIndex, randomAlphaOfLength(5), req)
            equalTo("index-name-000002")
            null  
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
        boolean foundAddWrite = false;  
            assertThat(info.getMetConditions(), hasSize(1));
            .indexRouting(indexRouting)
            CompressedXContent mapping = new CompressedXContent(  
        final String defaultRolloverIndexName;
        String indexName = randomFrom("foo-123", "bar-xyz");  
import static org.hamcrest.Matchers.containsString;
            equalTo("aliases, mappings, and index settings may not be specified when rolling over a data stream")
import org.opensearch.threadpool.ThreadPool;
            assertThat(info.getMetConditions().get(0).value(), equalTo(condition.value()));
            MappedFieldType mockedTimestampFieldType = mock(MappedFieldType.class);  
                aliasName,
        );
            when(documentMapper.routingFieldMapper()).thenReturn(routingFieldMapper);  
        String sourceIndex = randomAlphaOfLength(10);
        final RolloverRequest rolloverRequest = new RolloverRequest(dataStream.getName(), randomAlphaOfLength(10));  
        builder.put(dataStream);  
            when(indexService.index()).thenReturn(indexMetadata.getIndex());  
            exception.getMessage(),
            RolloverInfo info = rolloverMetadata.index(sourceIndexName).getRolloverInfos().get(dataStream.getName());  
            null,
            ShardLimitValidator shardLimitValidator = new ShardLimitValidator(Settings.EMPTY, clusterService, systemIndices);  
            } else if (action.getIndex().equals(sourceIndex)) {
    ) {  
            .put(
        );
 */  
            MaxDocsCondition condition = new MaxDocsCondition(randomNonNegativeLong());  
        );
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
            long after = testThreadPool.absoluteTimeInMillis();
        aliases.put("bar-write", AliasMetadata.builder("bar-write").writeIndex(randomBoolean()).build());  
            null,
                new AliasValidator(),
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
        } finally {  
            } else if (action.getIndex().equals(sourceIndex)) {  
            if (action.getIndex().equals(targetIndex)) {
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
            null,
            null,
                throw new AssertionError("Unknown index [" + action.getIndex() + "]");
    private static AliasMetadata createDefaultAliasMetadata(String alias, Boolean isHidden) {
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(builder).build();
        boolean foundRemoveWrite = false;
            clusterState,  
 *
            testThreadPool.shutdown();  
            new SystemIndices(emptyMap()),  
                foundRemove = true;  
            when(mapperService.documentMapper()).thenReturn(documentMapper);  
            newIndexName,
                Arrays.asList(mockedTimestampField, dateFieldMapper),  
            .put(createMetadata(randomAlphaOfLengthBetween(5, 7)), false)  
        );
            .putAlias(AliasMetadata.builder("foo-write"))
            }  
            IndexMetadata rolloverIndexMetadata = rolloverMetadata.index(newIndexName);  
            IndexAbstraction ds = rolloverMetadata.getIndicesLookup().get(dataStream.getName());
    public void testGenerateRolloverIndexName() {  
        final CreateIndexClusterStateUpdateRequest createIndexRequest = MetadataRolloverService.prepareCreateIndexRequest(
            indicesService,
        final boolean useDataStream = randomBoolean();
package org.opensearch.action.admin.indices.rollover;
        );
        final IndexTemplateMetadata template = IndexTemplateMetadata.builder("test-template")  
            rolloverRequest.getCreateIndexRequest()
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
        assertEquals(
            Collections.singletonList("*"),
    }
            rolloverIndex,  
import org.opensearch.indices.InvalidIndexNameException;
            createDefaultAliasMetadata(sourceAlias, true),
            } else {  
        } else {
 */  
    }
        ThreadPool testThreadPool = new TestThreadPool(getTestName());  
        IndexMetadata.Builder indexTwoBuilder = IndexMetadata.builder(index2).settings(settings);
                assertThat(action, instanceOf(AliasAction.Remove.class));  
        );
 * GitHub history for details.
         * Throws Exception because Eclipse uses the lower bound for  
            int numberOfShards = randomIntBetween(1, 5);  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            IllegalArgumentException.class,
            IndexService indexService = mock(IndexService.class);
            new AliasValidator(),  
                foundRemoveWrite = true;
 * KIND, either express or implied.  See the License for the
        assertEquals(newIndexName, rolloverResult.rolloverIndexName);
            MetadataRolloverService.generateRolloverIndexName("<index-name-{now/d}-1>", indexNameExpressionResolver)  
    }
import org.opensearch.env.Environment;
        assertTrue(foundRemove);  
        assertThat(actions, hasSize(2));
import org.opensearch.core.index.Index;  
         * else.  
            .build();
/*
        );
                new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                new StandardAnalyzer()
        for (Index index : dataStream.getIndices()) {  
            createIndexService,
            )
            sourceIndex,  
                createIndexRequest,  
            null,
            null,  
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                assertEquals(sourceAlias, addAction.getAlias());
                randomBoolean()  
                assertEquals(sourceRouting, addAction.getSearchRouting());  
        );
        final Settings settings = Settings.builder()
        // hidden shouldn't throw
            } else {
        String aliasWithWriteIndex = randomAlphaOfLength(10);
            indexRouting,  
        Map filter,
            .putAlias(AliasMetadata.builder("foo-write"))
        exception = expectThrows(
            when(mockedTimestampField.copyTo()).thenReturn(FieldMapper.CopyTo.empty());  
            if (action.getIndex().equals(targetIndex)) {
import org.opensearch.index.mapper.DocumentMapper;
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(builder).build();
                clusterService,
        builder.put(dataStream);  
            assertThat(ds.getIndices(), hasSize(dataStream.getIndices().size() + 1));
            assertThat(info.getMetConditions().get(0).value(), equalTo(condition.value()));
        String indexRouting = randomAlphaOfLength(10);
            null,
        String indexName = randomFrom("foo-123", "bar-xyz");  
            aliasMetadata,  
        assertThat(createIndexRequest.index(), equalTo(newWriteIndexName));
        }
            sourceRouting,
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(foundRemoveWrite);  
                assertEquals(indexRouting, addAction.getIndexRouting());  
    }
                assertTrue(addAction.writeIndex());  
            targetIndex,
        String indexName = randomFrom("foo-123", "bar-xyz");  
import org.opensearch.cluster.metadata.IndexMetadata;  
 * not use this file except in compliance with the License.
        assertThat(exception.getMessage(), equalTo("rollover target [" + aliasWithNoWriteIndex + "] does not point to a write index"));
        if (useDataStream) {
            .numberOfShards(1)
        Environment env = mock(Environment.class);
        for (String settingKey : settings.keySet()) {  
        final ComposableIndexTemplate template = new ComposableIndexTemplate(
            RoutingFieldMapper routingFieldMapper = mock(RoutingFieldMapper.class);
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        assertThat(createIndexRequest.cause(), equalTo("rollover_data_stream"));
            } else if (action.getIndex().equals(sourceIndex)) {
        String sourceIndex = randomAlphaOfLength(10);
                null,  
import org.opensearch.cluster.routing.allocation.AllocationService;
    }
    public void testValidation() throws Exception {
                foundRemoveWrite = true;  
                indexAliasesService,
            .build();
                assertTrue(addAction.isHidden());
            List<Condition<?>> metConditions = Collections.singletonList(condition);
            IllegalArgumentException.class,
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(
                metadata,  
import static org.mockito.Mockito.same;
                metConditions,
            .metadata(Metadata.builder().put(indexMetadata))
        String invalidIndexName = randomAlphaOfLength(10) + "A";
            null,
            assertThat(info.getMetConditions(), hasSize(1));  
import org.opensearch.index.shard.IndexEventListener;
    public void testRejectDuplicateAlias() {
                clusterState,  
        );
        // hidden shouldn't throw  
        String newIndexName = useDataStream == false && randomBoolean() ? "logs-index-9" : null;  
                aliasName,
            MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
        String targetIndex = randomAlphaOfLength(10);  
    }
                foundRemoveWrite = true;  
        verifyNoMoreInteractions(metadataIndexAliasesService);
            builder.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
     * parameter is used for the purpose intended.
        newIndexName = newIndexName == null ? defaultRolloverIndexName : newIndexName;  
            indexRouting,
            if (action.getIndex().equals(targetIndex)) {
        MetadataCreateIndexService createIndexService = mock(MetadataCreateIndexService.class);
        assertThat(ex.getMessage(), containsString("index template [test-template]"));  
import org.opensearch.Version;
            clusterService,
    private static AliasMetadata createAliasMetadata(  
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        );  
            }
            rolloverRequest.getCreateIndexRequest()
            .put("ct", ct)
            AliasAction.Add addAction = (AliasAction.Add) action;
            }  
            null,  
import static java.util.Collections.emptyMap;
import org.opensearch.common.xcontent.json.JsonXContent;
            targetIndex,  
    }
            when(mockedTimestampField.name()).thenReturn("_data_stream_timestamp");
            ClusterService clusterService = ClusterServiceUtils.createClusterService(testThreadPool);  
                DateFieldMapper.Resolution.MILLISECONDS,
            )
    private IndicesService mockIndicesServices(DocumentMapper documentMapper) throws Exception {
        reset(createIndexService);  
        final IllegalArgumentException ex = expectThrows(
         * can throw Exception. javac seems to be ok inferring something
            .put("ct", ct)
            rolloverTarget,
            assertThat(settings.get(settingKey), equalTo(createIndexRequest.settings().get(settingKey)));
                indicesService,
        String indexRouting,  
        assertThat(ex.getMessage(), containsString("index template [test-template]"));  
import org.opensearch.cluster.metadata.ComponentTemplate;
    private IndicesService mockIndicesServices() throws Exception {  
                assertThat(addAction.writeIndex(), nullValue());
            null,
        assertTrue(foundAddWrite);
            IllegalArgumentException.class,  
        );  
        assertThat(actions, hasSize(2));  
            IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
    public void testRolloverAliasActionsWithHiddenAliasAndImplicitWriteIndex() {  
            mockIndexNameExpressionResolver
        final ComponentTemplate ct = new ComponentTemplate(new Template(null, null, aliases), null, null);
        Map<String, AliasMetadata> aliases = new HashMap<>();
 */
                .numberOfShards(1)
import java.util.Locale;
    }  
            .searchRouting(searchRouting)
                createIndexService,  
            .settings(settings)
            clusterService,  
            IndexAbstraction alias = rolloverMetadata.getIndicesLookup().get(aliasName);  
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, randomBoolean())
import org.opensearch.cluster.metadata.DataStream;  
            AllocationService allocationService = mock(AllocationService.class);  
        );
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
import org.opensearch.cluster.ClusterName;
            String indexPrefix = "logs-index-00000";  
            DocumentMapper documentMapper = mock(DocumentMapper.class);  
        assertThat(actions, hasSize(2));  
                xContentRegistry()
            Arrays.asList("foo-*", "bar-*"),
 * Unless required by applicable law or agreed to in writing,
            .put("test-template", template)
        );
import org.opensearch.indices.DefaultRemoteStoreSettings;
            indicesService,
            assertEquals(newIndexName, rolloverResult.rolloverIndexName);  
            AllocationService allocationService = mock(AllocationService.class);
            Arrays.asList("foo-*", "bar-*"),  
            when(mockedTimestampFieldType.name()).thenReturn("_data_stream_timestamp");
    public void testAliasValidation() {  
            testThreadPool,
                new ComposableIndexTemplate.DataStreamTemplate()
        assertThat(createIndexRequest.cause(), equalTo("rollover_index"));  
        String indexName = randomFrom("foo-123", "bar-xyz");
                assertEquals(sourceAlias, addAction.getAlias());
            when(indexService.mapperService()).thenReturn(mapperService);
    }  
        }
        verifyNoMoreInteractions(createIndexService);
            null,  
                dataStream.getName(),
import org.opensearch.common.CheckedFunction;
        }  
            sourceIndex,
        Map<String, AliasMetadata> aliases = new HashMap<>();
            IllegalArgumentException.class,  
            long before = testThreadPool.absoluteTimeInMillis();  
import org.opensearch.common.compress.CompressedXContent;  
                assertEquals(sourceAlias, ((AliasAction.Remove) action).getAlias());
                null,  
        rolloverRequest.getCreateIndexRequest().waitForActiveShards(activeShardCount);  
            testThreadPool,
            false,
            null,
            true
                assertEquals(sourceAlias, addAction.getAlias());
                assertFalse(addAction.writeIndex());
        CreateIndexRequest settingReq = new CreateIndexRequest().settings(Settings.builder().put("foo", "bar"));
    public void testRejectDuplicateAliasV2UsingComponentTemplates() {  
    }  
        final String indexPrefix = randomAlphaOfLength(10);
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
            () -> MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, randomBoolean())  
            } else if (action.getIndex().equals(sourceIndex)) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        final Metadata metadata = Metadata.builder()
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(3).getMillis())  
            );  
        MetadataRolloverService.checkNoDuplicatedAliasInIndexTemplate(metadata, indexName, aliasName, Boolean.TRUE);
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
                AliasAction.Remove removeAction = (AliasAction.Remove) action;
        }
            sourceAlias  
        boolean foundAdd = false;
            )
        assertThat(createIndexRequest.settings().get("index.hidden"), equalTo("true"));  
            assertThat(ds.getIndices(), hasItem(rolloverIndexMetadata));  
        verifyNoMoreInteractions(createIndexService);  
                false,
        boolean foundRemoveWrite = false;
                randomFrom(Boolean.FALSE, null)  
            .build();
            MetadataIndexAliasesService indexAliasesService = new MetadataIndexAliasesService(  
                AliasAction.Add addAction = (AliasAction.Add) action;  
        );
        md.put(randomDataStream);
                0,  
        assertThat(createIndexRequest.settings(), equalTo(settings));
            assertThat(alias.getIndices(), hasSize(2));
/*  
            );
        final String sourceIndexName;  
import static org.mockito.Mockito.doThrow;
            true  
            null
            md.put(DataStreamTestHelper.getIndexMetadataBuilderForIndex(index));
    }  
            });
            sourceAlias  
                indicesService,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        aliases.put("foo-write", AliasMetadata.builder("foo-write").build());
            ClusterService clusterService = ClusterServiceUtils.createClusterService(testThreadPool);
        assertThat(ex.getMessage(), containsString("index template [test-template]"));
        Exception e = expectThrows(  
            );
        MaxDocsCondition condition = new MaxDocsCondition(randomNonNegativeLong());
import org.opensearch.cluster.metadata.IndexAbstraction;
            sourceIndex,
