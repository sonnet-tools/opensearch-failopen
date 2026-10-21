        DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest(dataStreamName);
        );
        assertThat(withoutPatternError.validationErrors(), contains("index patterns are missing"));
            )
        assertThat(aliasExists(alias2), equalTo(true));
        assertEquals("2", indexSettings.get("number_of_shards"));
        createIndex(index, Settings.EMPTY);
        assertThat(unknownSettingError.getDetailedMessage(), containsString("unknown setting [index.this-setting-does-not-exist]"));
        assertThat(backingIndices, equalTo(1));
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));
        OpenIndexResponse lenientOpenIndexResponse = execute(
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
            () -> execute(
        }
        );
        );
        GetIndexTemplatesResponse getTemplate2 = execute(
            () -> execute(getIndexRequest, highLevelClient().indices()::get, highLevelClient().indices()::getAsync)
            assertThat(getAliasesResponse.getAliases().size(), equalTo(3));
            GetAliasesResponse getAliasesResponse = execute(
        List<String> names = randomBoolean() ? Arrays.asList("*plate-1", "template-2") : Arrays.asList("template-*");
        Map<String, Object> props = (Map<String, Object>) template2.mappings().sourceAsMap().get("properties");
        );
        assertThat(extractRawValues("my-template.index_patterns", templates), contains("name-*"));
        {
        {
            assertThat(getAliasesResponse.getError(), nullValue());
        assertTrue(closeIndexResponse.isShardsAcknowledged());
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
                assertTrue(execute(existsRequest, client.indices()::existsTemplate, client.indices()::existsTemplateAsync));
             "index": {
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
import org.opensearch.client.indices.SimulateIndexTemplateResponse;
                    new DeleteIndexTemplateRequest("template-1"),
        assertEquals(1, getSettingsResponse.getIndexToDefaultSettings().get("get_settings_index").size());
    public void testGetAliasesNonExistentIndexOrAlias() throws IOException {
            highLevelClient().indices()::getSettingsAsync
        createIndex(index, Settings.EMPTY);
    public void testSimulateIndexTemplate() throws Exception {
            Collections.emptyList(),
            assertThat(forceMergeResponse.getFailedShards(), equalTo(0));
                highLevelClient().indices()::flushAsync
        assertFalse(response.isValid());
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("non_existent_alias*");
        createIndex(indexName, basicSettings, mappings);
            .includeDefaults(true);
        assertThat(
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
        OpenSearchStatusException e = expectThrows(
        assertThat(
import org.opensearch.client.indices.CreateIndexResponse;
               }
            assertTrue(conditionStatus.get("[max_age: 1ms]"));
        );
            .alias(new Alias("alias-1").indexRouting("abc"))
    public void testGetFieldMapping() throws IOException {
                MediaTypeRegistry.JSON
        Object o = mappingMetadata.getSourceAsMap().get("properties");
            execute(new GetIndexTemplatesRequest("template-*"), client.indices()::getIndexTemplate, client.indices()::getIndexTemplateAsync)
        OpenIndexResponse openIndexResponse = execute(
        assertNotNull(aliasData);
        updateIndexSettings(indexName, Settings.builder().put("refresh_interval", "30s"));
        indexUpdateSettingsRequest.settings(Settings.builder().put(setting, value).build());
                highLevelClient().indices()::create,
        DataStreamsStatsRequest dataStreamsStatsRequest = new DataStreamsStatsRequest();
        OpenSearchException exception = expectThrows(
            String index = "index";
            new org.opensearch.action.admin.indices.create.CreateIndexRequest("target").settings(targetSettings).alias(new Alias("alias"))
        String alias = "alias";
                    highLevelClient().indices()::putSettingsAsync
        PutComposableIndexTemplateRequest newIndexTemplateReq = new PutComposableIndexTemplateRequest().name("used-for-simulation")
        GetDataStreamResponse getDataStreamResponse = execute(getDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync);
        Settings basicSettings = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build();
            highLevelClient().indices()::putTemplate,
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(indices);
            ForceMergeRequest forceMergeRequest = new ForceMergeRequest(index);
            client.indices()::getIndexTemplate,
                nonExistentIndexRequest,
        postDoc.setJsonEntity(
        assertThat(indexSettingsAsMap.get(staticSettingKey), equalTo(staticSettingValue));
            ).status(),
        Template template = new Template(settings, mappings, Collections.singletonMap("alias", alias));
            .mapping("{\"properties\": { \"name\": { \"type\": \"text\" }}}", MediaTypeRegistry.JSON)
        assertTrue(resizeResponse.isShardsAcknowledged());
        assertThat(dataStream.getGeneration(), equalTo(1L));
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(indices);
                .get(0)
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
            assertThat(refreshResponse.getFailedShards(), equalTo(0));
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest("my-template").source(
            assertThat(aliasMetadata1, notNullValue());
            .settings(Settings.builder().put("number_of_shards", "3").put("number_of_replicas", "0"))
                highLevelClient().indices()::createAsync
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
            assertThat(aliasMetadata2, notNullValue());
            )
        }
        Map<String, String> type = new HashMap<>();
        GetSettingsResponse getSettingsResponse = execute(
    }
        }
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        assertThat(indexExists(index), equalTo(false));
            Collections.emptyList(),
        getAliasesRequest2.aliases("alias");
            highLevelClient().indices()::updateAliasesAsync
        }
        assertThat(dataStream.getTimeStampField(), equalTo("@timestamp"));
        assertEquals(0, getSettingsResponse.getIndexToSettings().get("get_settings_index").size());
        assertTrue(template2.mappings().sourceAsMap().containsKey("properties"));
import org.opensearch.client.indices.GetDataStreamRequest;
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));
    }
        assertNull(getSettingsResponse.getSetting(indexName, "index.number_of_replicas"));
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
            highLevelClient().indices()::close,
        assertThat(extractValue("my-template.settings.index.number_of_replicas", templates), equalTo("0"));
        }
        final int dynamicSettingValue = 0;
    }
        assertFalse(execute(getAliasesRequest, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));
        );
    public void testGetSettingsWithDefaults() throws IOException {
                .put("index.number_of_replicas", 0)
        );
            assertEquals(2016, term.get("year"));
        Map<String, Object> getIndexResponse = getAsMap("target");
            rolloverRequest.dryRun(true);
            highLevelClient().indices()::openAsync
        }
                highLevelClient().indices()::delete,
            for (String suffix : Arrays.asList("1", "2")) {
        String indexName = "get_settings_index";
            assertThat(forceMergeResponse.getTotalShards(), equalTo(1));
        assertFalse(execute(getAliasesRequest2, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));
        addAction = new AliasActions(AliasActions.Type.ADD).indices(index).alias(alias2);
            openIndexRequest,
            highLevelClient().indices()::shrink,
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(nonExistentIndex);
            assertThat(clearCacheResponse.getSuccessfulShards(), equalTo(1));
        );
        ResizeResponse resizeResponse = execute(resizeRequest, highLevelClient().indices()::split, highLevelClient().indices()::splitAsync);
            RolloverResponse rolloverResponse = execute(
                getIndexResponse
        );
            highLevelClient().indices()::getSettings,
            );
        assertEquals(RestStatus.NOT_FOUND, strictException.status());
            assertThat(
                () -> execute(
                .isAcknowledged()
        ResponseException exception = expectThrows(
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
        assertThat(exception.getMessage(), equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]"));
        )
            highLevelClient().indices()::validateQueryAsync
        }
            XContentFactory.jsonBuilder()
            aliasesAddRemoveRequest,
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
            createIndexRequest.mapping(mappingBuilder);
        exist = execute(
            createIndex(index, settings);
        assertNotNull(getSettingsResponse.getSetting(indexName, "index.creation_date"));
            );
            assertTrue(createIndexResponse.isAcknowledged());
            .create(true)
            highLevelClient().indices()::get,
            .alias(new Alias("{index}-write").searchRouting("xyz"));
        mappingBuilder.endObject().endObject().endObject();
            GetAliasesResponse getAliasesResponse = execute(
 * KIND, either express or implied.  See the License for the
        assertThat(aliasExists(alias), equalTo(false));
        assertThat(response.isAcknowledged(), equalTo(true));
 *
        assertNotNull(getIndexResponse.getMappings().get(indexName));
            assertFalse(indexExists(nonExistentIndex));
            putTemplateRequest,
            assertFalse(execute(neitherRequest, client.indices()::existsTemplate, client.indices()::existsTemplateAsync));
            // Create index and attempt to update creation_date - should fail as it's a final setting
        assertThat(mappings, equalTo(expected));
        assertTrue(aliasResponse.isAcknowledged());
            client.indices()::getIndexTemplate,
                )
        lenientOpenIndexRequest.indicesOptions(IndicesOptions.lenientExpandOpen());
            () -> execute(openIndexRequest, highLevelClient().indices()::open, highLevelClient().indices()::openAsync)
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
            assertThat(aliasMetadata.getFilter(), nullValue());
import org.opensearch.common.settings.Settings;
            assertTrue(conditionStatus.get("[max_docs: 1]"));
import org.opensearch.client.indices.GetIndexTemplatesRequest;
            aliasesRemoveIndexRequest,
            simulateIndexTemplateRequest,
        DataStreamStats dataStreamStat = dataStreamsStats.get(dataStreamName);
    }
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = new PutComposableIndexTemplateRequest().name("ds-template")
            .create(true)
        assertThat(aliasExists(alias), equalTo(false));
        type.put("type", "text");
        assertThat(aliasExists(alias), equalTo(true));
/*
        IndicesAliasesRequest aliasesAddRequest = new IndicesAliasesRequest();
                .endObject()
                rolloverRequest,
            );
                () -> execute(deleteIndexRequest, highLevelClient().indices()::delete, highLevelClient().indices()::deleteAsync)
            );
        );
            // Delete index if exists
    }
                    client.indices()::getIndexTemplateAsync
        );
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
            Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();
        AcknowledgedResponse putMappingResponse = execute(
                .getIndexTemplates(),
            );
import org.opensearch.client.indices.CreateDataStreamRequest;
    @SuppressWarnings({ "unchecked", "rawtypes" })
        assertThat(aliasExists(index, alias), equalTo(false));
            )
    public void testGetSettingsNonExistentIndex() throws IOException {
            String nonExistentIndex = "non_existent_index";
            highLevelClient().indices()::putIndexTemplateAsync
        AcknowledgedResponse response = execute(
            resizeRequest,
        String alias = "alias";
        String indexName = "test";
            "source",
        Request postDoc = new Request(HttpPost.METHOD_NAME, "/" + index + "/_doc");
        resizeRequest.setResizeType(ResizeType.SHRINK);
        );
                .name(),
        String index = "shakespeare";
        createIndex(
            OpenSearchException exception = expectThrows(
    }
        assertThat(
        assertEquals(RestStatus.NOT_FOUND, exception.status());
        createIndex(index, Settings.EMPTY);
            equalTo(true)
            RolloverResponse rolloverResponse = execute(
/*
                getAliasesResponse.getException().getMessage(),
        assertEquals(2016, term.get("year"));
        OpenSearchException exception = expectThrows(
        AnalyzeResponse detailsResponse = execute(detailsRequest, client.indices()::analyze, client.indices()::analyzeAsync);
            createIndex(indexName, Settings.EMPTY);
        closeIndex(index);
            highLevelClient().indices()::updateAliasesAsync
            RequestOptions.DEFAULT
        assertThat(exception.getMessage().contains(index), equalTo(true));
            );
import org.opensearch.core.rest.RestStatus;
            String nonExistentIndex = "non_existent_index";
            highLevelClient().indices()::getMapping,
        unmodifiableSettingRequest.settings(Settings.builder().put(unmodifiableSettingKey, unmodifiableSettingValue).build());
            UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(indexName);
                    + "  }"
        );
        );
            template,
        dataStreams = getDataStreamResponse.getDataStreams();
                .put("index.number_of_routing_shards", 4)
 * this file be licensed under the Apache-2.0 license or a
        assertThat(putTemplateResponse.isAcknowledged(), equalTo(true));
        Map<String, Object> mappings = getMappingsResponse.mappings().get(indexName).sourceAsMap();
    @SuppressWarnings("unchecked")
        assertTrue(aliasesRemoveIndexResponse.isAcknowledged());
            createIndex(existingIndex, Settings.EMPTY);
            assertThat(aliasMetadata1, notNullValue());
        Map<String, Object> field = new HashMap<>();
            assertThat(flushResponse.getSuccessfulShards(), equalTo(1));
        }
        assertThat(
        mappingBuilder.field("type", "text");
import org.opensearch.action.admin.indices.shrink.ResizeRequest;
        assertThat(getAlias.get("search_routing"), equalTo("search_routing"));
        Map<String, Object> term = (Map<String, Object>) filter.get("term");
            assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(RestStatus.BAD_REQUEST.getStatus()));
        assertThat(noindexResponse.getTokens(), hasSize(3));
        );
        closeIndexResponse.getIndices().forEach(indexResult -> {
        AcknowledgedResponse response = execute(
        assertThat(templates.keySet(), hasSize(1));
        assertEquals("1", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_SHARDS));
                highLevelClient().indices()::getAlias,
            addAction.writeIndex(randomBoolean());
        assertThat(aliasExists(index, alias), equalTo(false));
        );
import java.io.IOException;
        assertThat(aliasExists(index, alias), equalTo(false));
        String alias = "alias";
        assertThat(getResponse.getIndexTemplates().size(), equalTo(1));
import org.opensearch.action.admin.indices.shrink.ResizeType;
    }
}
            OpenSearchException.class,
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
                + "  \"speech_number\": \"\","
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.cluster.metadata.AliasMetadata;
         * because the server renders the xcontent in a spot that is difficult for us to access in a unit test.
import org.opensearch.client.indices.DeleteDataStreamRequest;
        IndicesAliasesRequest aliasesAddRemoveRequest = new IndicesAliasesRequest();
                highLevelClient().indices()::getAlias,
            )
                    + "}",
        );
        AnalyzeRequest detailsRequest = AnalyzeRequest.withGlobalAnalyzer("english", "One two three").explain(true);
        ValidateQueryResponse response = execute(
            OpenSearchStatusException.class,
            mappingBuilder.startObject().startObject("properties").startObject("field");
 * Licensed to Elasticsearch under one or more contributor
        String indexName = "get_settings_index";
            AliasMetadata aliasMetadata = getAliasesResponse.getAliases().get("index1").iterator().next();
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices("_all");
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(nonExistentIndex);
        {
        removeIndexRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).index(nonExistentIndex).alias(alias));
            new IndexRequest("test").id("2").source("field", "value").setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL),
import org.opensearch.core.common.unit.ByteSizeUnit;
                    updateSettingsRequest,
        Map<String, Object> fieldMapping = (Map<String, Object>) ((Map<String, Object>) o).get("field-1");
        RestHighLevelClient client = highLevelClient();
                rolloverRequest,
            GetAliasesResponse getAliasesResponse = execute(
        AliasMetadata simulationAlias = AliasMetadata.builder("simulation-alias").writeIndex(true).build();
        mappingBuilder.startObject().startObject("properties").startObject("field");
        );
import org.opensearch.action.admin.indices.shrink.ResizeResponse;
    }
import static org.opensearch.common.xcontent.support.XContentMapValues.extractRawValues;
        assertFalse(indexExists(nonExistentIndex));
                highLevelClient().indices()::rollover,
            highLevelClient().indices()::getSettings,
    public void testPutTemplateBadRequests() throws Exception {
            assertThat(refreshResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));
        assertThat(exception.getMetadata("opensearch.index"), not(hasItem(index)));
        assertThat(extractValue("my-template.settings.index.number_of_replicas", templates), equalTo("0"));
        closeIndex(index);
        assertEquals("0", indexSettings.get("number_of_replicas"));
    }
            aliasesAddRequest,
            assertEquals("2", XContentMapValues.extractValue(indexName + ".settings.index.number_of_replicas", getIndexResponse));
        assertEquals("30s", updatedResponse.getSetting(indexName, "index.refresh_interval"));
        createIndex(
                getAliasesResponse.getAliases().size(),
        }
        openIndex(index);
            RefreshRequest refreshRequest = new RefreshRequest(index);
import org.opensearch.index.query.QueryBuilders;
            }
            assertThat(
                highLevelClient().indices()::putSettings,
            ResponseException.class,
            assertFalse(indexExists(indexName));
        {
            assertFalse(rolloverResponse.isRolledOver());
                    highLevelClient().indices()::putSettings,
        );
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
        createIndex(indexName, basicSettings, mappings);
import org.opensearch.index.query.QueryBuilder;
            client.indices()::getIndexTemplate,
    }
            assertThat(indexResult.hasFailures(), is(false));
                () -> execute(
                final PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("template-" + suffix).patterns(
        GetIndexResponse getIndexResponse = execute(
        );
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
            RefreshRequest refreshRequest = new RefreshRequest(nonExistentIndex);
    public void testGetPrivateSettings() throws IOException {
        assertFalse(exist);
            createIndexRequest.alias(alias);
        highLevelClient().index(new IndexRequest("test").id("1").source("field", "value"), RequestOptions.DEFAULT);
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
        ResizeResponse resizeResponse = execute(resizeRequest, highLevelClient().indices()::clone, highLevelClient().indices()::cloneAsync);
import java.util.stream.Collectors;
        UpdateSettingsRequest unmodifiableSettingRequest = new UpdateSettingsRequest(index);
        XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
            composableIndexTemplateExistRequest,
import static org.hamcrest.Matchers.not;
        XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
    }
        simulateIndexTemplateRequest.indexTemplateV2Request(newIndexTemplateReq);
        assertEquals("1", getSettingsResponse.getSetting(indexName, "index.number_of_shards"));
        // Index present
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]")
            client.indices()::getIndexTemplateAsync
    }
        UpdateSettingsRequest dynamicSettingRequest = new UpdateSettingsRequest(index);
                getAliasesResponse.getException().getMessage(),
            assertThat(refreshResponse.getSuccessfulShards(), equalTo(1));
                highLevelClient().indices()::getAliasAsync
         * This test is quite extensive as this is the only way we can check that we haven't slid out of sync with the server
            String indexName = "test_index";
            GetAliasesResponse getAliasesResponse = execute(
        Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue("target.aliases.alias", getIndexResponse);
import org.opensearch.action.admin.indices.flush.FlushResponse;
        final String staticSettingKey = IndexSettings.INDEX_CHECK_ON_STARTUP.getKey();
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        AliasActions removeIndexAction = new AliasActions(AliasActions.Type.REMOVE_INDEX).index(index);
            highLevelClient().indices()::existsIndexTemplate,
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index, "non_existent_index");
        assertTrue(resizeResponse.isShardsAcknowledged());
    }
            highLevelClient().indices()::putSettings,
        AcknowledgedResponse response = execute(
        assertThat(aliasExists(index, alias), equalTo(true));
            highLevelClient().indices()::get,
        );
            1L,
        org.opensearch.client.ValidationException exception = expectThrows(
        createIndex(index, Settings.EMPTY);
            .settings(Settings.builder().put("number_of_shards", "3").put("number_of_replicas", "0"))
    }
        );
            String index = "index";
        mappingBuilder.startObject().startObject("properties").startObject("field");
            assertThat(getAliasesResponse.getAliases().size(), equalTo(3));
            ForceMergeResponse forceMergeResponse = execute(
                getAliasesRequest,
                highLevelClient().indices()::getAliasAsync
        Settings targetSettings = Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build();
        OpenSearchException exception = expectThrows(
                highLevelClient().indices()::putSettings,
import org.opensearch.action.support.IndicesOptions;
            CreateIndexResponse createIndexResponse = execute(
        createIndex(indexName2, Settings.builder().put("number_of_shards", 3).build());
            assertThat(clearCacheResponse.getFailedShards(), equalTo(0));
            Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            () -> execute(
            GetIndexRequest request = new GetIndexRequest(indexName);
        }
    }
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
        if (randomBoolean()) {
        GetFieldMappingsResponse getFieldMappingsResponse = execute(
        assertThat(extractValue("my-template.settings.index.number_of_shards", templates), equalTo("3"));
            badMappingError.getDetailedMessage(),
    }
            Map<String, Object> term = (Map) filter.get("term");
        String indexName = "get_settings_index";
import org.opensearch.action.admin.indices.alias.Alias;
            .indexTemplate(indexTemplate);
                indexName + ".aliases.alias_name",
        AcknowledgedResponse putTemplateResponse = execute(
                createIndexResponse.isAcknowledged()
        for (int i = 0; i < indices.length; i++) {
            GetAliasesResponse getAliasesResponse = execute(
                getAliasesRequest,
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
        {
            assertThat(getAliasesResponse.getError(), equalTo("alias [non_existent_alias] missing"));
        Map<String, Object> getIndexResponse = getAsMap("target");
            1L,
            new Template(null, null, Map.of("simulation-alias", simulationAlias)),
        assertTrue(openIndexResponse.isAcknowledged());
            "the template we provided for the simulation has a higher priority than the one in the system",
        response = execute(staticSettingRequest, highLevelClient().indices()::putSettings, highLevelClient().indices()::putSettingsAsync);
import static org.hamcrest.Matchers.is;
import org.opensearch.core.common.bytes.BytesArray;
    public void testCreateIndex() throws IOException {
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices("get_multiple_settings*");
        );
            String nonExistentIndex = "non_existent_index";
            highLevelClient().indices()::openAsync
            assertTrue(
        assertThat(
        );
        {
                highLevelClient().indices()::createAsync
 */
            Settings.Builder settings = Settings.builder();
        String templateName = "my-template";
        String indexName = "mapping_index";
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.OK));
        assertTrue(exist);
        assertNotNull(getSettingsResponse.getSetting(indexName, "index.refresh_interval"));
        assertNotNull(mappingMetadata);
            assertThat(getAliasesResponse.getException(), nullValue());
        // without the refresh the rollover may not happen as the number of docs seen may be off
            new HashMap<>(),
        );
    }
            );
    public void testRefresh() throws IOException {
                    + "    }"
        updateIndexSettings("source", Settings.builder().put("index.blocks.write", true));
            ).status(),
        DeleteComposableIndexTemplateRequest deleteComposableIndexTemplateRequest = new DeleteComposableIndexTemplateRequest(templateName);
            new HashMap<>(),
        Map<String, Object> getIndexResponse = getAsMap(indexName);
                highLevelClient().indices()::putSettings,
        );
        assertThat(template2.name(), equalTo("template-2"));
    }
            client().performRequest(new Request(HttpPut.METHOD_NAME, "/index1/_alias/alias1"));
    }
        assertThat(aliasExists(index, alias2), equalTo(true));
            .names("index.refresh_interval")
        String mappings = "\"properties\":{\"field-1\":{\"type\":\"integer\"}}";
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
        assertEquals("0", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_REPLICAS));
 * ownership. Elasticsearch licenses this file to you under
            highLevelClient().indices()::closeAsync
            String index = "index";
        getDataStreamRequest = new GetDataStreamRequest(null);
            assertFalse(rolloverResponse.isDryRun());
        AliasMetadata alias = AliasMetadata.builder("alias").writeIndex(true).build();
/*
        List<DataStream> dataStreams = getDataStreamResponse.getDataStreams();
            getBothRequest,
                forceMergeRequest,
        DataStream dataStream = dataStreams.get(0);
            client.indices()::getIndexTemplateAsync
            () -> execute(staticSettingRequest, highLevelClient().indices()::putSettings, highLevelClient().indices()::putSettingsAsync)
        OpenSearchStatusException badMappingError = expectThrows(
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;
        PutIndexTemplateRequest withoutPattern = new PutIndexTemplateRequest("t1");
            startsWith(
            () -> execute(openIndexRequest, highLevelClient().indices()::open, highLevelClient().indices()::openAsync)
            )
    }
            );
                getAliasesRequest,
            OpenSearchException.class,
        );
        staticSettingRequest.settings(Settings.builder().put(staticSettingKey, staticSettingValue).build());
    @SuppressWarnings("unchecked")
import org.opensearch.client.indices.ComposableIndexTemplateExistRequest;
    public void testForceMerge() throws IOException {
            "{"
        ensureHealth(dataStreamName, (request -> { request.addParameter("wait_for_status", "yellow"); }));
        );
import static org.hamcrest.CoreMatchers.hasItem;
                    Arrays.asList("pattern-" + suffix, "name-" + suffix)
            assertTrue(
                OpenSearchException.class,
            assertThat(clearCacheResponse.getTotalShards(), equalTo(1));
        GetComposableIndexTemplateRequest getComposableIndexTemplateRequest = new GetComposableIndexTemplateRequest(templateName);
            ResponseException exception = expectThrows(
            settings.put(SETTING_CREATION_DATE, 9876543210L);
        GetSettingsResponse updatedResponse = execute(
    public void testIndexTemplates() throws Exception {
            getComposableIndexTemplateRequest,
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
            new ComposableIndexTemplate.DataStreamTemplate()
            .create(true)
    public void testAnalyze() throws Exception {
        assertThat(aliasExists(index, alias), equalTo(true));
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
    }
import org.opensearch.client.indices.GetFieldMappingsResponse;
        Map<String, DataStreamStats> dataStreamsStats = dataStreamsStatsResponse.getDataStreams();
                highLevelClient().indices()::getAliasAsync
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;
                highLevelClient().indices()::putSettings,
        assertThat(aliasExists(index, alias), equalTo(false));
        }
                .build()
        AcknowledgedResponse response = execute(
        SimulateIndexTemplateRequest simulateIndexTemplateRequest = new SimulateIndexTemplateRequest("pattern");
            createIndex(index, Settings.EMPTY);
            template,
                equalTo(3)
        assertThat(response.isAcknowledged(), equalTo(true));
        );
        removeIndexRequest.addAliasAction(new AliasActions(AliasActions.Type.REMOVE_INDEX).indices(nonExistentIndex));
        IndicesAliasesRequest removeIndexRequest = new IndicesAliasesRequest();
        assertThat(dataStream.getIndices(), hasSize(1));
            );
        createIndex(indexName, Settings.EMPTY);
    public void testGetSettings() throws IOException {
    public void testInvalidValidateQuery() throws IOException {
            assertEquals("test", rolloverResponse.getOldIndex());
        Boolean isWriteIndex = (Boolean) getAlias.get("is_write_index");
                highLevelClient().indices()::rolloverAsync
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        {
                ResponseException.class,
            highLevelClient().indices()::open,
            GetAliasesResponse getAliasesResponse = execute(
import static org.hamcrest.Matchers.contains;
        assertThat(template2.settings().get("index.number_of_replicas"), equalTo("0"));
        );
        closeIndex(index);
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
        assertThat((Map<String, String>) extractValue("my-template.aliases.alias-1", templates), hasEntry("index_routing", "abc"));
                    + "reason=Can't update non dynamic settings [[index.number_of_shards]] for open indices [[index/"
        aliasesAddRemoveRequest.addAliasAction(addAction);
                createIndexRequest,
        );
        String indexName = "get_index_test";
    }
import java.util.HashMap;
                .getIndexTemplates()
            );
        createIndex(indexName, Settings.EMPTY);
            highLevelClient().indices()::updateAliases,
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
        AcknowledgedResponse aliasResponse = execute(
        String indexName = "get_settings_index";
        }
        );
        int value = 10;
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
            exception.getMessage(),
    public void testOpenNonExistentIndex() throws IOException {
        createIndex(indexName, basicSettings);
    public void testGetIndexNonExistentIndex() throws IOException {
import org.opensearch.client.indices.DataStream;
            assertEquals("test_new", rolloverResponse.getNewIndex());
            .order(10)
        {
    public void testGetSettingsFiltered() throws IOException {
                + "}"
 * SPDX-License-Identifier: Apache-2.0
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));
                highLevelClient().indices()::getAlias,
                highLevelClient().indices()::getAlias,
        OpenSearchException exception = expectThrows(
            String index = "index-" + i;
            expectThrows(
        assertTrue(execute(goodTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged());
            "source",
        assertTrue(response.isAcknowledged());
            putComposableIndexTemplateRequest,
        assertThat(response.isAcknowledged(), equalTo(true));
 *
            assertEquals("1", aliasData.get("index_routing"));
            createIndex(index, settings);
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
        {
            );
            assertThat(refreshResponse.getTotalShards(), equalTo(1));
            GetAliasesResponse getAliasesResponse = execute(
        AcknowledgedResponse aliasesAddResponse = execute(
            RefreshResponse refreshResponse = execute(
                () -> execute(
import org.opensearch.client.indices.GetFieldMappingsRequest;
                )
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
        );
        PutMappingRequest putMappingRequest = new PutMappingRequest(indexName);
    public void testFlush() throws IOException {
        assertThat(extractRawValues("my-template.index_patterns", templates), contains("pattern-1", "name-*"));
        DataStreamsStatsResponse dataStreamsStatsResponse = execute(
            assertEquals("text", XContentMapValues.extractValue(indexName + ".mappings.properties.field.type", getIndexResponse));
        IndicesAliasesRequest aliasesAddRemoveRequest = new IndicesAliasesRequest();
            assertTrue(conditionStatus.get("[max_age: 1ms]"));
        }
        assertThat(
        );
    public void testGetAlias() throws IOException {
import org.opensearch.client.indices.DataStreamsStatsResponse;
            () -> execute(
            assertEquals(1, conditionStatus.size());
            arrayContainingInAnyOrder("template-1", "template-2")
        }
        assertThat(statusException.status(), equalTo(RestStatus.NOT_FOUND));
            // Create index with mappings, aliases and settings
            createIndex(indexName, Settings.EMPTY);
            getAllRequest,
        }
        assertEquals("4", indexSettings.get("number_of_shards"));
        createIndex(indexName, basicSettings);
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
                highLevelClient().indices()::getAlias,
            assertThat(getAliasesResponse.getAliases().size(), equalTo(2));
            () -> client().performRequest(new Request(HttpGet.METHOD_NAME, "/" + index + "/_search"))
                highLevelClient().indices()::getAliasAsync
            assertThat(aliasMetadata.alias(), equalTo(alias));
        assertTrue(resizeResponse.isShardsAcknowledged());
        String index = "index";
            */
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName).includeDefaults(true);
        Map<String, Object> indexSettings = (Map<String, Object>) XContentMapValues.extractValue("target.settings.index", getIndexResponse);
        assertThat(aliasExists(alias2), equalTo(true));
            assertEquals(RestStatus.NOT_FOUND, exception.status());
        createIndex(indexName1, Settings.builder().put("number_of_shards", 2).build());
            () -> execute(
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("alias*");
        assertThat(aliasExists(alias), equalTo(false));
                highLevelClient().indices()::updateAliases,
        OpenSearchException alreadyExistsError = expectThrows(
                highLevelClient().indices()::putSettingsAsync
        );
        PutMappingRequest putMappingRequest = new PutMappingRequest(indexName);
        String firstNode = ((Map<String, Object>) nodes.get("nodes")).keySet().iterator().next();
        assertThat(isWriteIndex, equalTo(addAction.writeIndex()));
        );
        assertNotNull(getSettingsResponse.getSetting(indexName, "index.uuid"));
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"host_name\":{\"type\":\"keyword\"}}}");
        assertThat(o, instanceOf(Map.class));
            () -> execute(getSettingsRequest, highLevelClient().indices()::getSettings, highLevelClient().indices()::getSettingsAsync)
import org.opensearch.client.indices.rollover.RolloverResponse;
        {
        Map<String, AliasMetadata> aliases = simulateResponse.resolvedTemplate().aliases();
            simulateResponse.overlappingTemplates().get("my-template").get(0),
 * software distributed under the License is distributed on an
            closeIndexRequest,
            );
            RolloverResponse rolloverResponse = execute(
            execute(putTemplate2, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged(),
        assertEquals("1", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_SHARDS));
        Map<String, Object> getAlias = getAlias(index, alias);
        ValidateQueryRequest request = new ValidateQueryRequest(index).query(builder);
        RolloverRequest rolloverRequest = new RolloverRequest("alias", "test_new");
        );
            getSettingsRequest,
            assertThat(exception.getMessage().contains(indexResult.getIndex()), equalTo(true));
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName);
            ValidationException.class,
        );
            highLevelClient().indices()::validateQueryAsync
                highLevelClient().indices()::getAliasAsync
        assertTrue(resizeResponse.isAcknowledged());
            () -> execute(mixedRequest, highLevelClient().indices()::updateAliases, highLevelClient().indices()::updateAliasesAsync)
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
            );
                highLevelClient().indices()::getIndexTemplateAsync
        assertNotNull(getIndexResponse.getMappings().get(indexName));
                "Unexpected number of aliases, got: " + getAliasesResponse.getAliases().toString(),
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
                highLevelClient().indices()::getAliasAsync
            pattern,
    }
        assertTrue(
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        );
        );
        GetMappingsResponse getMappingsResponse = execute(
        GetIndexRequest getIndexRequest = new GetIndexRequest(nonExistentIndex);
            assertThat(forceMergeResponse.getSuccessfulShards(), equalTo(1));
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index).aliases(alias, "non_existent_alias");
        assertThat(getResponse.getIndexTemplates().containsKey(templateName), equalTo(true));
            highLevelClient().indices()::open,
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
import java.util.Collections;
        UpdateSettingsRequest staticSettingRequest = new UpdateSettingsRequest(index);
    public void testGetIndex() throws IOException {
    }
        final GetFieldMappingsResponse.FieldMappingMetadata metadata = new GetFieldMappingsResponse.FieldMappingMetadata(
            Map<String, Object> getIndexResponse = getAsMap(indexName);
                highLevelClient().indices()::getAliasAsync
            final IndexTemplatesExistRequest bothRequest = new IndexTemplatesExistRequest(templateNames);
        Template template = new Template(null, mappings, null);
            rolloverRequest.addMaxIndexSizeCondition(new ByteSizeValue(1, ByteSizeUnit.MB));
                highLevelClient().indices()::refreshAsync
                () -> execute(flushRequest, highLevelClient().indices()::flush, highLevelClient().indices()::flushAsync)
        GetFieldMappingsRequest getFieldMappingsRequest = new GetFieldMappingsRequest().indices(indexName).fields("field");
            boolean response = execute(request, highLevelClient().indices()::exists, highLevelClient().indices()::existsAsync);
                + "  \"line_number\": \"\","
        assertThat(templates.keySet(), hasSize(1));
                unmodifiableSettingRequest,
import org.opensearch.common.settings.Setting;
            );
        mappingBuilder.startObject().startObject("properties").startObject("field");
        @SuppressWarnings("unchecked")
import static org.hamcrest.Matchers.containsString;
        );
        GetSettingsResponse getSettingsResponse = execute(
        assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(RestStatus.BAD_REQUEST.getStatus()));
            client.indices()::getIndexTemplateAsync
        assertThat(dataStream.getGeneration(), equalTo(1L));
import java.util.List;
        AcknowledgedResponse putTemplateResponse = execute(
        PutIndexTemplateRequest goodTemplate = new PutIndexTemplateRequest("t2").patterns(Arrays.asList("qa-*", "prod-*"));
            pattern,
            rolloverRequest.addMaxIndexAgeCondition(new TimeValue(1));
            new org.opensearch.action.admin.indices.create.CreateIndexRequest("target").settings(targetSettings).alias(new Alias("alias"))
            highLevelClient().indices()::getSettings,
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
        assertThat(byteSizeValue.getBytes(), not(equalTo(0L)));
    public void testDataStreams() throws Exception {
 * not use this file except in compliance with the License.
            assertFalse(indexExists(nonExistentIndex));
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        );
        aliasesAddRemoveRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).indices(index).alias(alias));
        String dataStreamName = "data-stream";
            settings.put(SETTING_CREATION_DATE, 1234567890L);
    }
        assertTrue(template2.aliases().isEmpty());
             "error": "alias [something] missing",
        String index = "some_index";
        Map<String, Object> indexSettings = (Map<String, Object>) XContentMapValues.extractValue("target.settings.index", getIndexResponse);
        assertThat(getTemplate1.getIndexTemplates(), hasSize(1));
        assertThat(aliasExists(alias2), equalTo(false));
            execute(putTemplate1, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged(),
            request,
        Map<String, Object> templates = getAsMap("/_template/my-template");
        OpenSearchException strictException = expectThrows(
                () -> client().performRequest(new Request(HttpGet.METHOD_NAME, "/" + indexResult.getIndex() + "/_search"))
import org.opensearch.client.indices.GetDataStreamResponse;
        assertThat(
            dynamicSettingRequest,
            assertThat(getAliasesResponse.getAliases().size(), equalTo(2));
        field.put("field", type);
                    + "or check the breaking changes documentation for removed settings]"
        Settings targetSettings = Settings.builder().put("index.number_of_shards", 4).put("index.number_of_replicas", 0).build();
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            highLevelClient().indices()::getFieldMappingAsync
                highLevelClient().indices()::getAlias,
import org.opensearch.client.indices.GetIndexTemplatesResponse;
                highLevelClient().indices()::rollover,
import org.opensearch.index.IndexSettings;
            )
            indices::dataStreamsStatsAsync
        assertTrue(resizeResponse.isAcknowledged());
    public void testClone() throws IOException {
                getAliasesRequest,
        assertThat(template2.patterns(), contains("pattern-2", "name-2"));
            // Return 404 if index doesn't exist
        Map<String, Object> getIndexResponse = getAsMap("target");
                highLevelClient().indices()::forcemerge,
 * specific language governing permissions and limitations
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
            String indexName = "non_existent_index";
            Collections.emptyList(),
        );
        exception = expectThrows(
            assertFalse(indexExists(indexName));
        });
        final Setting<String> staticSetting = IndexSettings.INDEX_CHECK_ON_STARTUP;
            highLevelClient().indices()::getSettingsAsync
            String nonExistentIndex = "oranges";
            is(notNullValue())
        getDataStreamResponse = execute(getDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync);
        assertEquals(
            exception.getMessage(),
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName).includeDefaults(true);
                highLevelClient().indices()::getAlias,
            highLevelClient().indices()::putTemplate,
            final IndexTemplatesExistRequest neitherRequest = new IndexTemplatesExistRequest("neither-*");
                () -> execute(
        AliasActions addAction = new AliasActions(AliasActions.Type.ADD).index(index).aliases(alias);
        goodTemplate.create(true);
            // Create index
        String index = "index";
            org.opensearch.client.ValidationException.class,
                "Exception message should indicate that index.creation_date cannot be updated. Got: " + exception.getMessage(),
 *
                highLevelClient().indices()::putSettingsAsync
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index);
            assertEquals(2, conditionStatus.size());
            assertFalse(response);
            getSettingsRequest,
            );
                rolloverRequest,
                highLevelClient().indices()::clearCacheAsync
        exception = expectThrows(
                indexUpdateSettingsRequest,
        }
            execute(new DeleteIndexTemplateRequest("template-1"), client.indices()::deleteTemplate, client.indices()::deleteTemplateAsync)
            OpenSearchException exception = expectThrows(
        dataStreams = getDataStreamResponse.getDataStreams();
        goodTemplate.create(false);
        assertThat(
    public void testIndexPutSettingNonExistent() throws IOException {
    public void testCRUDIndexTemplate() throws Exception {
        );
            highLevelClient().indices()::updateAliasesAsync
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            assertThat(aliasMetadata2, notNullValue());
        assertFalse(indexExists(nonExistentIndex));
        QueryBuilder builder = QueryBuilders.boolQuery()
        AcknowledgedResponse aliasesAddRemoveResponse = execute(
            .build();
            highLevelClient().indices()::simulateIndexTemplateAsync
    public void testShrink() throws IOException {
            Arrays.asList("pattern-1", "name-*")
        createIndex(indexName, basicSettings);
        expected.put("properties", field);
        final int unmodifiableSettingValue = 3;
        assertThat(
                highLevelClient().indices()::forcemergeAsync
             "status": 404,
        String indexName = "get_index_test";
                + "  \"text_entry\": \"ACT I\""
        strictOpenIndexRequest.indicesOptions(IndicesOptions.strictExpandOpen());
        {
            template,
            highLevelClient().indices()::putIndexTemplateAsync
import org.opensearch.cluster.metadata.MappingMetadata;
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("*");
            new org.opensearch.action.admin.indices.create.CreateIndexRequest("target").settings(targetSettings).alias(new Alias("alias"))
            getFieldMappingsRequest,
        );
            highLevelClient().indices()::getSettingsAsync
        assertThat(
        OpenSearchException exception = expectThrows(
        GetIndexTemplatesRequest getBothRequest = new GetIndexTemplatesRequest(names);
        );
        );
        assertTrue(response.isValid());
        assertTrue(putMappingResponse.isAcknowledged());
        );
import org.apache.hc.client5.http.classic.methods.HttpPut;
        assertThat(dataStreamStat.getBackingIndices(), equalTo(1));
                createIndexRequest,
                "OpenSearch exception [type=settings_exception, "
        ComposableIndexTemplate indexTemplate = new ComposableIndexTemplate(
            OpenSearchException.class,
    @SuppressWarnings("unchecked")
            GetAliasesResponse getAliasesResponse = execute(
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices("ind*");
            OpenSearchException.class,
        assertFalse(indexExists(nonExistentIndex));
            .create(randomBoolean())
        );
import static org.hamcrest.core.IsInstanceOf.instanceOf;
            assertThat(getAliasesResponse.getAliases().get("index3").size(), equalTo(0));
            String indexName = "creation_date_index";
        }
            updateSettingsRequest.settings(settings);
            null
            assertThat(forceMergeResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));
        SimulateIndexTemplateResponse simulateResponse = execute(
            ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest(index);
        }
            /*
                + "  \"line_id\": 1,"
            .create(randomBoolean())
            .alias(new Alias("alias-1").indexRouting("abc"))
    @SuppressWarnings("unchecked")
                highLevelClient().indices()::rollover,
            GetAliasesResponse getAliasesResponse = execute(
        {
        putMappingRequest.source(mappingBuilder);
            equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
            );
            );
        PutIndexTemplateRequest unknownSettingTemplate = new PutIndexTemplateRequest("t3").patterns(Collections.singletonList("any"))
            highLevelClient().indices()::putMapping,
        assertThat(dataStreamStat.getMaximumTimestamp(), equalTo(0L)); // No data in here
        // Rejected due to unknown settings
            exception.getMessage(),
            () -> execute(removeIndexRequest, highLevelClient().indices()::updateAliases, highLevelClient().indices()::updateAliasesAsync)
            IndexSettings.DEFAULT_REFRESH_INTERVAL,
        mappingBuilder.endObject().endObject().endObject();
        );
            highLevelClient().indices()::getSettingsAsync
        assertThat(
        List<String> pattern = Collections.singletonList("pattern");
        putMappingRequest.source(mappingBuilder);
            String nonExistentIndex = "non_existent_index";
        RestHighLevelClient client = highLevelClient();
            putComposableIndexTemplateRequest,
                    client.indices()::getIndexTemplate,
            hasSize(1)
import org.opensearch.client.indices.CloseIndexRequest;
            OpenSearchStatusException.class,
    public void testIndexPutSettings() throws IOException {
            )
        {
        );
        {
            boolean response = execute(request, highLevelClient().indices()::exists, highLevelClient().indices()::existsAsync);
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName).includeDefaults(false);
    }
        dynamicSettingRequest.settings(Settings.builder().put(dynamicSettingKey, dynamicSettingValue).build());
            assertEquals(3, conditionStatus.size());
            1L,
        getAliasesRequest2.indices("index");
            assertThat(getAliasesResponse.getAliases().get(index).size(), equalTo(1));
import org.apache.hc.client5.http.classic.methods.HttpGet;
        AcknowledgedResponse putMappingResponse = execute(
        );
        GetSettingsResponse getSettingsResponse = execute(
            () -> execute(withoutPattern, client.indices()::putTemplate, client.indices()::putTemplateAsync)
            GetAliasesResponse getAliasesResponse = execute(
                clearCacheRequest,
                highLevelClient().indices()::getAlias,
    @SuppressWarnings("unchecked")
            assertThat(getAliasesResponse.getAliases().size(), equalTo(2));
        assertTrue(
            .put("index.number_of_replicas", 0)
    public void testPutTemplate() throws Exception {
        }
        assertThat(template1.name(), equalTo("template-1"));
            assertTrue(rolloverResponse.isRolledOver());
            highLevelClient().indices()::updateAliases,
            assertThat(aliasMetadata1, notNullValue());
                getAliasesRequest,
            assertNotNull(aliasData);
        resizeRequest.setResizeType(ResizeType.CLONE);
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
                ).alias(new Alias("alias-" + suffix));
            highLevelClient().indices()::deleteIndexTemplate,
    }
        assertTrue(template1.aliases().containsKey("alias-1"));
        assertNull(getSettingsResponse.getSetting(indexName, "index.refresh_interval"));
        assertThat(aliasExists(alias2), equalTo(true));
            () -> execute(unknownSettingTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync)
            putComposableIndexTemplateRequest,
        {
        );
        assertEquals("0", indexSettings.get("number_of_replicas"));
            new HashMap<>(),
        assertThat(dataStreamsStats.size(), equalTo(1));
            createIndexRequest.settings(settings);
                highLevelClient().indices()::getAlias,
        mixedRequest.addAliasAction(new AliasActions(AliasActions.Type.REMOVE).indices(nonExistentIndex).alias(alias));
        );
                    + "      }"
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
        String alias2 = "alias2";
        assertEquals("2", indexSettings.get("number_of_shards"));
        {
        getDataStreamRequest = new GetDataStreamRequest(dataStreamName);
                highLevelClient().indices()::getAlias,
            OpenSearchStatusException.class,
                OpenSearchException.class,
                    + "        \"type\": \"keyword\""
            );
import org.opensearch.client.indices.PutIndexTemplateRequest;
            );
            .put("index.number_of_shards", 2)
        indexSettingsAsMap = getIndexSettingsAsMap(index);
import org.opensearch.action.support.broadcast.BroadcastResponse;
                highLevelClient().indices()::getAliasAsync
            alreadyExistsError.getDetailedMessage(),
            containsString("Root mapping definition has unsupported parameters:  [my_doc_type")
import org.opensearch.client.indices.DataStreamsStatsRequest;
package org.opensearch.client;
        IndicesAliasesRequest mixedRequest = new IndicesAliasesRequest();
        }
                highLevelClient().indices()::getAliasAsync
            getIndexRequest,
        assertTrue(execute(goodTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged());
        {
        // One index exists, one doesn't
        assertThat(dataStream.getName(), equalTo(dataStreamName));
            settings.put(SETTING_NUMBER_OF_REPLICAS, 2);
        IndicesAliasesRequest nonExistentIndexRequest = new IndicesAliasesRequest();
        createIndex(index, Settings.EMPTY);
        );
                .field("template", "name-*")
            );
                    + "      \"host_name\": {"
                getAliasesRequest,
            mappingBuilder.endObject().endObject().endObject();
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.opensearch.common.compress.CompressedXContent;
        ComposableIndexTemplate indexTemplate = new ComposableIndexTemplate(
        PutIndexTemplateRequest putTemplate1 = new PutIndexTemplateRequest("template-1").patterns(Arrays.asList("pattern-1", "name-1"))
                highLevelClient().indices()::getAliasAsync
 * Unless required by applicable law or agreed to in writing,
        );
            mappingBuilder.field("type", "text");
    public void testDeleteAlias() throws IOException {
        createIndex(index, Settings.EMPTY);
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
            String mappings = "{\"properties\":{\"field2\":{\"type\":\"keyword\"}}}";
            Arrays.asList("pattern-1", "name-*")
        assertThat(((Map<String, Object>) o).get("field-1"), instanceOf(Map.class));
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest("my-template").patterns(
                highLevelClient().indices()::getAliasAsync
            rolloverRequest.getCreateIndexRequest().mapping(mappings, MediaTypeRegistry.JSON);
            highLevelClient().indices()::putIndexTemplate,
                .startObject()
            client.indices()::getIndexTemplate,
        assertThat(dataStreamStat.getStoreSize().getBytes(), not(equalTo(0L))); // but still takes up some space on disk
            OpenSearchStatusException.class,
        assertNotNull(getIndexResponse.getMappings().get(indexName));
        Map<String, Object> fieldMapping = (Map<String, Object>) ((Map<String, Object>) o).get("field-1");
            Settings.builder().put("index.routing.allocation.require._name", firstNode).put("index.blocks.write", true)
            highLevelClient().indices()::updateAliasesAsync
            );
        createIndex(index, Settings.EMPTY);
        response = execute(deleteDataStreamRequest, indices::deleteDataStream, indices::deleteDataStreamAsync);
            ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest(nonExistentIndex);
            Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();
            assertThat(getAliasesResponse.getException(), nullValue());
            startsWith(
            highLevelClient().indices()::simulateIndexTemplate,
            OpenSearchException.class,
        );
                .build()
            () -> execute(closeIndexRequest, highLevelClient().indices()::close, highLevelClient().indices()::closeAsync)
            composableIndexTemplateExistRequest,
        assertEquals(RestStatus.NOT_FOUND, exception.status());
    public void testValidateQuery() throws IOException {
        assertThat(exception.getMetadata("opensearch.index"), not(hasItem(index)));
            assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
        Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue("target.aliases.alias", getIndexResponse);
        putMappingRequest.source(mappingBuilder);
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            {
        assertThat(
        }
               "aliases": {
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
        assertNotNull(indexSettings);
            equalTo("template-2")
        {
            assertTrue(rolloverResponse.isDryRun());
        Map<String, Object> indexSettings = (Map<String, Object>) XContentMapValues.extractValue("target.settings.index", getIndexResponse);
        {
            assertFalse(indexExists(nonExistentIndex));
    public void testPutMapping() throws IOException {
            }
        OpenSearchException exception = expectThrows(
        String[] indices = randomBoolean() ? Strings.EMPTY_ARRAY : null;
            );
            IndexSettings.DEFAULT_REFRESH_INTERVAL,
import org.opensearch.client.indices.PutMappingRequest;
            getBoth.getIndexTemplates().stream().map(IndexTemplateMetadata::name).toArray(),
            OpenSearchException exception = expectThrows(
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
 * this work for additional information regarding copyright
            OpenSearchException.class,
import org.opensearch.OpenSearchException;
            getSettingsRequest,
            highLevelClient().indices()::putIndexTemplate,
            1L,
            // Create index with creation_date setting - should succeed now that it's not private
            assertEquals(RestStatus.NOT_FOUND, exception.status());
import org.opensearch.client.indices.GetComposableIndexTemplatesResponse;
                getAliasesRequest,
        aliasesAddRequest.addAliasAction(addAction);
import org.opensearch.action.admin.indices.flush.FlushRequest;
        );
                highLevelClient().indices()::rolloverAsync
import org.opensearch.action.index.IndexRequest;
        IndexTemplateMetadata template1 = getTemplate1.getIndexTemplates().get(0);
        assertEquals("2", getSettingsResponse.getSetting(indexName1, "index.number_of_shards"));
            OpenSearchException exception = expectThrows(
        // noinspection unchecked
            Settings.builder()
                getAliasesRequest,
        aliasesAddRemoveRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).indices(index).alias(alias + "2"));
        assertEquals(1, getSettingsResponse.getIndexToSettings().get("get_settings_index").size());
            assertThat(aliasMetadata1, notNullValue());
            assertThat(aliasMetadata2, notNullValue());
import org.opensearch.common.xcontent.support.XContentMapValues;
        assertNotNull(aliasData);
        );
        assertThat(dataStreamStat, notNullValue());
        aliasesRemoveIndexRequest.addAliasAction(removeIndexAction);
            deleteComposableIndexTemplateRequest,
        assertThat(((Map<String, Object>) o).get("field-1"), instanceOf(Map.class));
                    new GetIndexTemplatesRequest("template-*"),
        getAliasesRequest2.indices("does_not_exist");
            highLevelClient().indices()::deleteAliasAsync
    }
                    client.indices()::getIndexTemplate,
        {
            assertThat(flushResponse.getFailedShards(), equalTo(0));
        );
            () -> execute(
            highLevelClient().indices()::validateQuery,
import org.opensearch.client.indices.SimulateIndexTemplateRequest;
            1L,
    }
            assertThat(aliasMetadata, notNullValue());
import java.util.Map;
        String indexName2 = "get_multiple_settings_two";
        {
            putTemplateRequest,
            null
            Map<String, Object> filter = (Map) aliasData.get("filter");
            assertThat(aliasMetadata2, notNullValue());
                .put("index.number_of_routing_shards", 4)
        assertEquals("text", XContentMapValues.extractValue(indexName + ".mappings.properties.field.type", getIndexResponse));
 * compatible open source license.
    }
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("_all");
        String alias = "alias";
            );
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest("alias");
            );
                getAliasesRequest,
        OpenIndexRequest strictOpenIndexRequest = new OpenIndexRequest(nonExistentIndex);
            getSettingsRequest,
            GetAliasesResponse getAliasesResponse = execute(
                createIndexRequest,
        // Create-only specified but an template exists already
        assertThat(e.status(), equalTo(RestStatus.NOT_FOUND));
        Settings targetSettings = Settings.builder()
            .indexTemplate(indexTemplate);
        {
            highLevelClient().indices()::validateQuery,
            client().performRequest(new Request(HttpPut.METHOD_NAME, "/index2/_alias/alias2"));
        }
import org.opensearch.core.common.Strings;
            exception.getMessage(),
                "Index creation should be acknowledged when setting creation_date during index creation",
        GetIndexTemplatesResponse getBoth = execute(
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName);
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
        {
                highLevelClient().indices()::putSettingsAsync
        aliasesAddRemoveRequest.addAliasAction(removeAction);
            FlushRequest flushRequest = new FlushRequest(nonExistentIndex);
    }
        {
                    new GetIndexTemplatesRequest("template-1"),
        assertThat(getBoth.getIndexTemplates(), hasSize(2));
            highLevelClient().indices()::putTemplateAsync
        CloseIndexResponse closeIndexResponse = execute(
        assertEquals(RestStatus.NOT_FOUND, exception.status());
            This is the above response in json format:
        int dataStreamsCount = dataStreamsStatsResponse.getDataStreamCount();
import static org.hamcrest.Matchers.notNullValue;
            expectThrows(
        );
        assertTrue(putMappingResponse.isAcknowledged());
        );
        );
            AcknowledgedResponse deleteIndexResponse = execute(
            hasItems("template-1", "template-2")
            request,
    public void testGetSettingsFromMultipleIndices() throws IOException {
        assertEquals("0", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_REPLICAS));
 * You may obtain a copy of the License at
            GetAliasesResponse getAliasesResponse = execute(
        newIndexTemplateReq.indexTemplate(simulationTemplate);
        assertThat(
        );
             }
            getSettingsRequest,
    }
            assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
    public void testSplit() throws IOException {
        String alias2 = "alias2";
            () -> execute(closeIndexRequest, highLevelClient().indices()::close, highLevelClient().indices()::closeAsync)
        assertNull(indexSettingsAsMap.get(staticSettingKey));
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
        assertThat(aliasExists(index, alias), equalTo(false));
        );
                .endObject()
import org.opensearch.cluster.metadata.IndexMetadata;
            dataStreamsStatsRequest,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            );
        String mappings = "\"properties\":{\"field-1\":{\"type\":\"integer\"}}";
            GetIndexRequest request = new GetIndexRequest(existingIndex, nonExistentIndex);
        );
        );
            () -> execute(putTemplateRequest, highLevelClient().indices()::putTemplate, highLevelClient().indices()::putTemplateAsync)
        DeleteAliasRequest request = new DeleteAliasRequest(index, alias);
                .field("number_of_replicas", 0)
            assertThat(getAliasesResponse.getError(), nullValue());
            request,
        GetIndexTemplatesResponse getAll = execute(
    }
    public void testAliasesNonExistentIndex() throws IOException {
        assertEquals("3", getSettingsResponse.getSetting(indexName2, "index.number_of_shards"));
                highLevelClient().indices()::create,
        assertThat(
            );
        assertOK(client().performRequest(postDoc));
        assertThat(response.isAcknowledged(), equalTo(true));
        ValidationException withoutPatternError = expectThrows(
        PutMappingRequest putMappingRequest = new PutMappingRequest(indexName);
            );
                OpenSearchException.class,
            equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
import org.opensearch.client.indices.IndexTemplatesExistRequest;
        final String staticSettingValue = "true";
            highLevelClient().indices()::getIndexTemplateAsync
            indices::dataStreamsStats,
        {
        assertNotNull(detailsResponse.detail());
        final String dynamicSettingKey = IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 */
        );
        assertThat(dataStream.getIndices(), hasSize(1));
            assertThat(aliasMetadata2, notNullValue());
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        assertNull(getSettingsResponse.getSetting(indexName, "index.number_of_shards"));
                highLevelClient().indices()::create,
            Settings.Builder settings = Settings.builder();
            assertThat(
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
            Collections.singletonList(dataStreamName),
            AliasMetadata aliasMetadata = getAliasesResponse.getAliases().get(index).iterator().next();
        MappingMetadata mappingMetadata = getIndexResponse.getMappings().get(indexName);
                .startObject("settings")
            highLevelClient().indices()::getSettings,
        assertThat(
            assertTrue(response);
            highLevelClient().indices()::getFieldMapping,
            .alias(new Alias("{index}-write").searchRouting("xyz"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        GetMappingsRequest request = new GetMappingsRequest().indices(indexName);
        {
            assertTrue(indexExists(indexName));
            assertEquals("test_new", rolloverResponse.getNewIndex());
        createIndex(indexName, basicSettings);
        String indexName1 = "get_multiple_settings_one";
        ValidateQueryRequest request = new ValidateQueryRequest(index).query(builder);
        exception = expectThrows(
        assertThat(
                    + "  \"my_doc_type\": {"
        String nonExistentIndex = "index_that_doesnt_exist";
 * under the License.
        assertThat(lenientOpenIndexResponse.isAcknowledged(), equalTo(true));
        );
        );
            highLevelClient().indices()::shrinkAsync
        Map<String, Object> filter = (Map<String, Object>) getAlias.get("filter");
            2L,
            );
            String index = "index";
        );
    }
import static org.hamcrest.Matchers.hasItems;
                .put("index.number_of_replicas", 0)
            assertEquals("test_new", rolloverResponse.getNewIndex());
            );
        assertThat(getAlias.get("index_routing"), equalTo("routing"));
        );
        assertThat(aliasExists(index, alias), equalTo(false));
        exception = expectThrows(
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
        AcknowledgedResponse putMappingResponse = execute(
        )
        mappingBuilder.endObject().endObject().endObject();
        /*
            Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue(
            String indexName = "test_index_exists_index_present";
        assertThat(aliases.get("simulation-alias").getAlias(), is("simulation-alias"));
            assertThat(getAliasesResponse.getAliases().get("index3").size(), equalTo(0));
import org.opensearch.client.indices.rollover.RolloverRequest;
 * The OpenSearch Contributors require contributions made to
                + "  \"type\": \"act\","
        assertEquals(RestStatus.NOT_FOUND, exception.status());
        mappingBuilder.field("type", "text");
            OpenSearchException.class,
        assertThat(aliasExists(alias), equalTo(false));
        );
            assertThat(forceMergeRequest.getDescription(), containsString(index));
        );
                .put("index.number_of_shards", 2)
        assertThat(aliasExists(alias), equalTo(false));
import org.opensearch.client.indices.CloseIndexResponse;
        Map<String, Object> nodes = getAsMap("_nodes");
        );
import org.opensearch.common.ValidationException;
        assertThat(o, instanceOf(Map.class));
        String setting = "no_idea_what_you_are_talking_about";
            alias.filter("{\"term\":{\"year\":2016}}");
        {
                () -> execute(refreshRequest, highLevelClient().indices()::refresh, highLevelClient().indices()::refreshAsync)
            exception.getMessage(),
        // Index doesn't exist
import org.opensearch.cluster.metadata.Template;
                getComposableIndexTemplateRequest,
                highLevelClient().indices()::updateAliasesAsync
 */
    }
        assertThat(putTemplateResponse.isAcknowledged(), equalTo(true));
            );
        ComposableIndexTemplate indexTemplate = new ComposableIndexTemplate(
import org.opensearch.client.indices.GetMappingsResponse;
            assertEquals(RestStatus.NOT_FOUND, exception.status());
        // default settings should be null
            assertTrue(createIndexResponse.isAcknowledged());
        );
    }
            highLevelClient().indices()::getMappingAsync
            "source",
    }
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest("my-template").patterns(
            request,
                exception.getMessage().contains("Can't update non dynamic settings [[index.creation_date]]")
        assertNull(getSettingsResponse.getSetting(indexName, "index.refresh_interval"));
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = new PutComposableIndexTemplateRequest().name(templateName)
                )
            highLevelClient().indices()::deleteAlias,
        );
        assertTrue(execute(getAliasesRequest, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));
                    + "    \"properties\": {"
import org.opensearch.client.indices.DeleteAliasRequest;
            .alias(new Alias("alias-1"));
        {
        );
        final String unmodifiableSettingKey = IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            highLevelClient().indices()::getSettingsAsync
    public void testUpdateAliases() throws IOException {
        }
                    client.indices()::deleteTemplateAsync
        assertEquals("_doc", mappingMetadata.type());
            );
        );
        {
            highLevelClient().indices()::getSettingsAsync
                highLevelClient().indices()::rolloverAsync
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index, "non_existent_index").aliases(alias);
            OpenSearchStatusException.class,
    public void testRollover() throws IOException {
            assertTrue(execute(bothRequest, client.indices()::existsTemplate, client.indices()::existsTemplateAsync));
            Collections.emptyList(),
            .must(QueryBuilders.queryStringQuery("*:*"))
        }
            highLevelClient().indices()::existsIndexTemplate,
        assertThat(
                unmodifiableSettingRequest,
        }
            highLevelClient().indices()::getSettings,
        assertEquals("integer", fieldMapping.get("type"));
            expectThrows(
            highLevelClient().indices()::existsIndexTemplateAsync
            getSettingsResponse.getIndexToDefaultSettings().get("get_settings_index").getAsTime("index.refresh_interval", null)
            assertEquals(RestStatus.NOT_FOUND, exception.status());
        assertThat(dataStreamsCount, equalTo(1));
    }
        updateIndexSettings("source", Settings.builder().put("index.blocks.write", true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
        );
            OpenSearchException.class,
        }
        org.opensearch.client.core.AcknowledgedResponse aliasDeleteResponse = execute(
                    + "reason=unknown setting [index.no_idea_what_you_are_talking_about] please check that any required plugins are installed, "
                highLevelClient().indices()::deleteAsync
        );
        assertThat(exception.getMetadata("opensearch.index"), hasItem(nonExistentIndex));
            lenientOpenIndexRequest,
        AnalyzeRequest noindexRequest = AnalyzeRequest.withGlobalAnalyzer("english", "One two three");
            assertThat(getAliasesResponse.getAliases().get("index3").size(), equalTo(0));
            assertTrue("Index should exist after creation with creation_date setting", indexExists(indexName));
                )
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
            .settings(Settings.builder().put("number_of_shards", "2").put("number_of_replicas", "0"));
        assertEquals(RestStatus.NOT_FOUND, exception.status());
            highLevelClient().indices()::putMapping,
        assertFalse(indexExists(nonExistentIndex));
import java.util.Arrays;
            Settings.builder()
        Object o = getIndexResponse.getMappings().get(indexName).getSourceAsMap().get("properties");
            assertFalse(rolloverResponse.isRolledOver());
        String indexName = "get_settings_index";
        AliasActions removeAction = new AliasActions(AliasActions.Type.REMOVE).index(index).alias(alias);
        String index = "index";
            assertThat(flushResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));
        request.explain(true);
                refreshRequest,
            putMappingRequest,
        GetComposableIndexTemplatesResponse getResponse = execute(
        assertEquals("text", XContentMapValues.extractValue(indexName + ".mappings.properties.field.type", getIndexResponse));
        assertThat(aliasExists(index, alias2), equalTo(true));
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
        assertThat(closeIndexResponse.getIndices(), hasSize(indices.length));
        final Setting<Integer> unmodifiableSetting = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
            "existing template overlaps the higher priority template we provided for the simulation",
    }
        Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue("target.aliases.alias", getIndexResponse);
            Alias alias = new Alias("alias_name");
import static org.hamcrest.Matchers.nullValue;
        CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest(dataStreamName);
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
        }
            equalTo(true)
                deleteIndexRequest,
        );
        {
                getAliasesResponse.getException().getMessage(),
        String index = "index";
            Settings.Builder settings = Settings.builder();
        );
            .alias(new Alias("alias-1").indexRouting("abc"))
        assertNotNull(aliasData);
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();
            ForceMergeRequest forceMergeRequest = new ForceMergeRequest(nonExistentIndex);
        assertTrue(execute(getAliasesRequest2, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));
        assertThat(fieldMappingMap, equalTo(Collections.singletonMap("field", metadata)));
        );
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = new PutComposableIndexTemplateRequest().name(templateName)
        }
import org.opensearch.client.indices.CreateIndexRequest;
        assertThat((Map<String, String>) extractValue("my-template.aliases.{index}-write", templates), hasEntry("search_routing", "xyz"));
        nonExistentIndexRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).index(nonExistentIndex).alias(alias));
        Template template = new Template(settings, mappings, Map.of("alias", alias));
            highLevelClient().indices()::existsIndexTemplateAsync
        highLevelClient().index(
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
        assertEquals("0", indexSettings.get("number_of_replicas"));
        AcknowledgedResponse aliasesRemoveIndexResponse = execute(
    }
            assertEquals(RestStatus.NOT_FOUND, exception.status());
                highLevelClient().indices()::getAlias,
    public void testGetIndexWithDefaults() throws IOException {
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
            "field",
            )
            XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
        );
        assertNotNull(indexSettings);
            client.indices()::getIndexTemplateAsync
            CreateIndexResponse createIndexResponse = execute(
            );
        {
                getAliasesRequest,
        OpenSearchException exception = expectThrows(
        request.explain(randomBoolean());
            assertFalse(indexExists(indexName));
import org.opensearch.client.indices.GetMappingsRequest;
        Map<String, Object> getIndexResponse = getAsMap(indexName);
        {
            highLevelClient().indices()::getSettingsAsync
        indexSettingsAsMap = getIndexSettingsAsMap(index);
        createIndex(index, Settings.EMPTY);
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
        assertTrue(putMappingResponse.isAcknowledged());
                OpenSearchException.class,
        AliasMetadata alias = AliasMetadata.builder("alias").writeIndex(true).build();
            .indexTemplate(indexTemplate);
            GetIndexRequest request = new GetIndexRequest(indexName);
    public void testPutTemplateWithTypesUsingUntypedAPI() throws Exception {
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName).names("index.number_of_shards");
            assertThat(aliasMetadata1, notNullValue());
    public void testOpenExistingIndex() throws IOException {
        mixedRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).indices(index).aliases(alias));
import org.opensearch.client.indices.AnalyzeRequest;
        assertThat(
        );
        assertThat(unmodifiableSetting.getDefault(Settings.EMPTY), not(unmodifiableSettingValue));
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
        assertTrue(response.isAcknowledged());
        assertNull(getSettingsResponse.getSetting(indexName, "index.number_of_replicas"));
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
        assertThat(dataStreamStat.getDataStream(), equalTo(dataStreamName));
        assertThat(closeIndexResponse.getIndices(), notNullValue());
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
    public void testClearCache() throws IOException {
        Map<String, Object> expected = new HashMap<>();
        assertNotNull(indexSettings);
            exception.getMessage(),
                OpenSearchException.class,
            assertThat(flushResponse.getTotalShards(), equalTo(1));
        assertThat(extractValue("my-template.settings.index.number_of_shards", templates), equalTo("3"));
            CreateIndexResponse createIndexResponse = execute(
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(nonExistentIndex);
            assertThat(clearCacheResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));
                highLevelClient().indices()::getIndexTemplate,
        OpenSearchStatusException statusException = expectThrows(
    @SuppressWarnings("unchecked")
            highLevelClient().indices()::getIndexTemplate,
            putMappingRequest,
        }
    }
        AnalyzeResponse noindexResponse = execute(noindexRequest, client.indices()::analyze, client.indices()::analyzeAsync);
 * Modifications Copyright OpenSearch Contributors. See
            highLevelClient().indices()::putMappingAsync
                "{"
            .mapping("{ \"properties\": { \"host_name\": { \"type\": \"keyword\" } } }", MediaTypeRegistry.JSON)
        resizeRequest.setResizeType(ResizeType.SPLIT);
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
        OpenIndexRequest lenientOpenIndexRequest = new OpenIndexRequest(nonExistentIndex);
            assertThat(indexResult.getIndex(), startsWith("index-"));
        {
            assertEquals("test", rolloverResponse.getOldIndex());
        createIndex("source", Settings.builder().put("index.number_of_shards", 4).put("index.number_of_replicas", 0).build());
        assertThat(getResponse.getIndexTemplates().get(templateName), equalTo(indexTemplate));
        boolean exist = execute(
            getAll.getIndexTemplates().stream().map(IndexTemplateMetadata::name).collect(Collectors.toList()),
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName)
        Settings basicSettings = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build();
        assertThat(
        {
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
        String index = "test";
            GetAliasesResponse getAliasesResponse = execute(
            highLevelClient().indices()::updateAliases,
        getDataStreamResponse = execute(getDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync);
            assertEquals("test", rolloverResponse.getOldIndex());
        createIndex(indexName, Settings.EMPTY);
            );
            indices[i] = index;
            1L,
        Map<String, Object> indexSettingsAsMap = getIndexSettingsAsMap(index);
        assertThat(exception.validationErrors().get(0), equalTo("index is missing"));
        GetIndexResponse getIndexResponse = execute(
        dataStream = dataStreams.get(0);
                highLevelClient().indices()::getAliasAsync
            startsWith(
            FlushResponse flushResponse = execute(
            () -> execute(goodTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync)
            boolean response = execute(request, highLevelClient().indices()::exists, highLevelClient().indices()::existsAsync);
        assertThat(template2.settings().get("index.number_of_shards"), equalTo("2"));
import org.opensearch.client.indices.GetIndexRequest;
        final Setting<Integer> dynamicSetting = IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
            highLevelClient().indices()::putSettingsAsync
        }
    }
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
import org.opensearch.client.indices.DataStreamsStatsResponse.DataStreamStats;
        GetSettingsResponse getSettingsResponse = execute(
            putMappingRequest,
                OpenSearchException.class,
    public void testDeleteIndex() throws IOException {
            new BytesArray("{\"field\":{\"type\":\"text\"}}")
            .settings(Settings.builder().put("this-setting-does-not-exist", 100));
            assertFalse(response);
    public void testGetMapping() throws IOException {
            highLevelClient().indices()::putIndexTemplateAsync
        ComposableIndexTemplate simulationTemplate = new ComposableIndexTemplate(
                highLevelClient().indices()::getAlias,
                    client.indices()::getIndexTemplateAsync
        assertThat(dataStreams, hasSize(1));
                "OpenSearch exception [type=illegal_argument_exception, "
            assertThat(aliasMetadata.getSearchRouting(), nullValue());
        IndicesClient indices = highLevelClient().indices();
                .field("order", 10)
        assertEquals("1", getSettingsResponse.getSetting(indexName, "index.number_of_shards"));
            getSettingsRequest,
            getSettingsRequest,
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));
        String nonExistentIndex = "non_existent_index";
            assertFalse(conditionStatus.get("[max_size: 1mb]"));
        assertTrue(aliasesAddRemoveResponse.isAcknowledged());
            assertThat(aliasMetadata.alias(), equalTo("alias1"));
            String indexName = "plain_index";
                getAliasesRequest,
    public void testUpdateIndexSettingsFailFinalSetting() throws IOException {
            String indexName = "rich_index";
            );
        exception = expectThrows(
        {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        assertThat(dataStreams, hasSize(1));
                    client.indices()::deleteTemplate,
        }
        );
                highLevelClient().indices()::clearCache,
            ClearIndicesCacheResponse clearCacheResponse = execute(
            )
    public void testPutTemplateWithDeprecatedTemplateField() throws Exception {
        }
            assertFalse(indexExists(nonExistentIndex));
import static org.hamcrest.Matchers.startsWith;
        resizeRequest.setTargetIndex(
        assertTrue(resizeResponse.isAcknowledged());
        assertTrue(props.containsKey("name"));
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest(alias);
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
                highLevelClient().indices()::getAliasAsync
            .get(indexName);
        assertThat(aliasExists(index, alias2), equalTo(false));
            .create(true)
        assertThat(extractValue("my-template.order", templates), equalTo(10));
        assertThat(staticSetting.getDefault(Settings.EMPTY), not(staticSettingValue));
        assertThat(dataStreams, hasSize(0));
                indexUpdateSettingsRequest,
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
        IndexTemplateMetadata template2 = getTemplate2.getIndexTemplates().get(0);
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
        Map<String, Object> templates = getAsMap("/_template/my-template");
            aliasesAddRemoveRequest,
        GetAliasesRequest getAliasesRequest2 = new GetAliasesRequest();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            OpenSearchException.class,
        );
        assertThat(template1.patterns(), contains("pattern-1", "name-1"));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testCloseEmptyOrNullIndex() {
        assertThat(exception.getMetadata("opensearch.index"), hasItem(nonExistentIndex));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        final String[] indices = new String[randomIntBetween(1, 5)];
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
    }
        // noinspection unchecked
            highLevelClient().indices()::getSettings,
import org.opensearch.common.unit.TimeValue;
        ResizeResponse resizeResponse = execute(
         */
            assertFalse(conditionStatus.get("[max_docs: 1]"));
            .filter(QueryBuilders.termQuery("user", "foobar"));
import org.opensearch.client.indices.GetIndexResponse;
            );
                assertTrue(execute(putRequest, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged());
        }
            final List<String> templateNames = randomBoolean() ? Arrays.asList("*plate-1", "template-2") : Arrays.asList("template-*");
            .mapping(
        }
            execute(new GetIndexTemplatesRequest("template-*"), client.indices()::getIndexTemplate, client.indices()::getIndexTemplateAsync)
                highLevelClient().indices()::createAsync
                .field("number_of_shards", 3)
            containsString("[type=illegal_argument_exception, reason=index_template [t2] already exists]")
import org.opensearch.client.indices.AnalyzeResponse;
        assertThat(aliases, is(notNullValue()));
        );
            );
                final IndexTemplatesExistRequest existsRequest = new IndexTemplatesExistRequest("template-" + suffix);
        assertThat(aliasExists(alias), equalTo(true));
            equalTo(RestStatus.NOT_FOUND)
            )
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices("non_existent_index*");
        GetSettingsResponse getSettingsResponse = execute(
            highLevelClient().indices()::getSettings,
            );
        // New API returns a MappingMetadata class rather than CompressedXContent for the mapping
                highLevelClient().indices()::refresh,
 * GitHub history for details.
                highLevelClient().indices()::getAlias,
        client().performRequest(new Request(HttpPut.METHOD_NAME, "/" + index + "/_alias/" + alias));
            assertFalse(indexExists(nonExistentIndex));
            aliases.get("simulation-alias"),
        String nonExistentIndex = "non_existent_index";
            createIndex("index2", Settings.EMPTY);
                + "  \"play_name\": \"Henry IV\","
        assertTrue(aliasesAddResponse.isAcknowledged());
        String nonExistentIndex = "index_that_doesnt_exist";
                getAliasesRequest,
        IndicesAliasesRequest aliasesRemoveIndexRequest = new IndicesAliasesRequest();
            OpenSearchException.class,
        assertThat(dynamicSetting.getDefault(Settings.EMPTY), not(dynamicSettingValue));
        assertThat(
        assertThat(dataStreamsStats, notNullValue());
        );
        Response response = client().performRequest(new Request(HttpGet.METHOD_NAME, "/" + index + "/_search"));
    }
        assertEquals("integer", fieldMapping.get("type"));
            String indexName = "final_setting_index";
import static org.hamcrest.Matchers.hasEntry;
 * license agreements. See the NOTICE file distributed with
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(index);
        GetSettingsResponse getSettingsResponse = execute(
        assertEquals(
            assertThat(
        assertTrue(closeIndexResponse.isAcknowledged());
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(nonExistentIndex);
        rolloverRequest.addMaxIndexDocsCondition(1);
        );
            new GetIndexTemplatesRequest("template-2"),
            );
        assertThat(extractValue("my-template.mappings.properties.host_name.type", templates), equalTo("keyword"));
            highLevelClient().indices()::getAsync
        String nonExistentIndex = "non_existent_index";
            rolloverRequest.dryRun(false);
        String templateName = "my-template";
        assertEquals("1", getSettingsResponse.getSetting(indexName, "index.number_of_shards"));
            assertFalse(rolloverResponse.isDryRun());
            highLevelClient().indices()::putIndexTemplate,
            FlushRequest flushRequest = new FlushRequest(index);
        );
        }
        );
        assertThat(aliasExists(index, alias2), equalTo(true));
        highLevelClient().indices().create(new CreateIndexRequest("test").alias(new Alias("alias")), RequestOptions.DEFAULT);
        assertThat(response.isAcknowledged(), equalTo(true));
        }
                highLevelClient().indices()::getAlias,
        assertThat(dataStream.getName(), equalTo(dataStreamName));
            OpenSearchException.class,
        assertNull(getIndexResponse.getSetting(indexName, "index.refresh_interval"));
public class IndicesClientIT extends OpenSearchRestHighLevelClientTestCase {
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/60461")
            assertFalse(indexExists(indexName));
 *    http://www.apache.org/licenses/LICENSE-2.0
                .put("index.number_of_shards", 2)
            new HashMap<>(),
            .putNull("index.routing.allocation.require._name")
        addAction.routing("routing").searchRouting("search_routing").filter("{\"term\":{\"year\":2016}}");
        );
    public void testCloseNonExistentIndex() throws IOException {
        String index = "index";
    @SuppressWarnings("unchecked")
            highLevelClient().indices()::updateAliases,
        {
        ComposableIndexTemplateExistRequest composableIndexTemplateExistRequest = new ComposableIndexTemplateExistRequest(templateName);
                highLevelClient().indices()::putSettingsAsync
            assertThat(aliasMetadata2, notNullValue());
            .order(10)
            null
    }
            OpenSearchException.class,
            equalTo(RestStatus.NOT_FOUND)
            createIndex(indexName, Settings.EMPTY);
        assertThat(getTemplate2.getIndexTemplates(), hasSize(1));
        response = execute(
            assertTrue(conditionStatus.get("[max_docs: 1]"));
        );
            OpenSearchException exception = expectThrows(
            exception.getMessage(),
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
    }
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
        }
            createIndex("index1", Settings.EMPTY);
        assertNotNull(getIndexResponse.getMappings().get(indexName));
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        assertThat(byteSizeValue, notNullValue());
        );
                OpenSearchException.class,
import org.opensearch.client.indices.IndexTemplateMetadata;
                getAliasesRequest,
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
        response = execute(createDataStreamRequest, indices::createDataStream, indices::createDataStreamAsync);
        resizeRequest.setTargetIndex(
            assertThat(aliasMetadata.getIndexRouting(), nullValue());
        assertEquals("{\"properties\":{\"field-1\":{\"type\":\"integer\"}}}", mappingMetadata.source().string());
            getIndexResponse.getDefaultSettings().get(indexName).getAsTime("index.refresh_interval", null)
        assertThat(dataStream.getTimeStampField(), equalTo("@timestamp"));
    }
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();
        assertThat(indexSettingsAsMap.get(dynamicSettingKey), equalTo(String.valueOf(dynamicSettingValue)));
    public void testExistsAlias() throws IOException {
            assertThat(aliasMetadata1, notNullValue());
    }
import static org.hamcrest.Matchers.hasSize;
                    + "reason=Can't update non dynamic settings [[index.shard.check_on_startup]] for open indices [[index/"
        // Failed to validate because index patterns are missing
                .isAcknowledged()
            createIndex(index, settings);
        );
            createIndex(index, settings);
                "OpenSearch exception [type=illegal_argument_exception, "
            assertThat(aliasMetadata, notNullValue());
import org.opensearch.core.common.unit.ByteSizeValue;
        assertThat(response.isAcknowledged(), equalTo(true));
        ByteSizeValue byteSizeValue = dataStreamsStatsResponse.getTotalStoreSize();
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.OK));
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
            highLevelClient().indices()::putTemplateAsync,
    }
        UpdateSettingsRequest indexUpdateSettingsRequest = new UpdateSettingsRequest(index);
        getDataStreamRequest = new GetDataStreamRequest(null);
    public void testCloseExistingIndex() throws IOException {
        ValidateQueryResponse response = execute(
        QueryBuilder builder = QueryBuilders.queryStringQuery("line_id:foo").lenient(false);
        RestHighLevelClient client = highLevelClient();
        assertThat(getAll.getIndexTemplates().size(), greaterThanOrEqualTo(2));
        createIndex("index", Settings.EMPTY);
import org.apache.hc.client5.http.classic.methods.HttpPost;
        assertThat(exception.getMetadata("opensearch.index"), hasItem(nonExistentIndex));
                getAliasesRequest,
        final RestHighLevelClient client = highLevelClient();
        int backingIndices = dataStreamsStatsResponse.getBackingIndices();
import org.opensearch.common.xcontent.XContentFactory;
        GetIndexTemplatesResponse getTemplate1 = execute(
        GetDataStreamRequest finalGetDataStreamRequest = getDataStreamRequest;
        assertThat(extractValue("my-template.order", templates), equalTo(10));
        {
import org.opensearch.OpenSearchStatusException;
                () -> execute(clearCacheRequest, highLevelClient().indices()::clearCache, highLevelClient().indices()::clearCacheAsync)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
            String nonExistentIndex = "non_existent_index";
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"@timestamp\":{\"type\":\"date\"}}}");
            pattern,
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
            highLevelClient().indices()::putMappingAsync
                highLevelClient().indices()::flush,
        OpenSearchStatusException unknownSettingError = expectThrows(
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
            )
                + "  \"speaker\": \"\","
        List<String> pattern = List.of("pattern");
            1L,
            OpenSearchException exception = expectThrows(
        updateIndexSettings(
    public void testGetSettingsWithDefaultsFiltered() throws IOException {
        mappingBuilder.field("type", "text");
        String index = "index";
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("alias1");
        }
                 "alias": {}
            () -> execute(
import org.opensearch.core.xcontent.XContentBuilder;
        );
        GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest(dataStreamName);
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
            String existingIndex = "apples";
                "OpenSearch exception [type=settings_exception, " + "reason=final index setting [index.number_of_shards], not updateable"
            is("pattern")
            alias.routing("1");
            assertTrue(deleteIndexResponse.isAcknowledged());
        );
    public void testIndexTemplatesExist() throws Exception {
        resizeRequest.setTargetIndex(
        assertThat(aliasExists(alias), equalTo(false));
        assertNotNull(getIndexResponse.getSetting(indexName, "index.refresh_interval"));
    }
        PutIndexTemplateRequest putTemplate2 = new PutIndexTemplateRequest("template-2").patterns(Arrays.asList("pattern-2", "name-2"))
import org.opensearch.action.support.WriteRequest;
    public void testCreateIndexWithCreationDate() throws IOException {
            createIndexRequest.settings(settings);
            assertThat(getAliasesResponse.getError(), equalTo("alias [" + alias + "] missing"));
        }
            getIndexRequest,
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"host_name\":{\"type\":\"keyword\"}}}");
            equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
                OpenSearchException.class,
            highLevelClient().indices()::putMapping,
        GetIndexTemplatesRequest getAllRequest = new GetIndexTemplatesRequest();
            assertThat(forceMergeRequest.getDescription(), containsString(nonExistentIndex));
            highLevelClient().indices()::deleteIndexTemplateAsync
        }
            () -> execute(finalGetDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync)
            equalTo(RestStatus.NOT_FOUND)
        assertThat(response.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));
        XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
            );
            expectWarningsOnce("Deprecated field [template] used, replaced by [index_patterns]")
        client().performRequest(new Request(HttpPut.METHOD_NAME, "/index/_alias/alias"));
            equalTo(
            new GetIndexTemplatesRequest("template-1"),
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
            ).status(),
            highLevelClient().indices()::putMappingAsync
                () -> execute(forceMergeRequest, highLevelClient().indices()::forcemerge, highLevelClient().indices()::forcemergeAsync)
        createIndex(indexName, basicSettings);
        {
        );
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
                flushRequest,
                highLevelClient().indices()::getAliasAsync
            highLevelClient().indices()::getAsync
            OpenSearchException.class,
        final Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldMappingMap = getFieldMappingsResponse.mappings()
    }
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
    public void testIndicesExists() throws IOException {
            createIndex("index3", Settings.EMPTY);
            GetAliasesResponse getAliasesResponse = execute(
            execute(new DeleteIndexTemplateRequest("template-*"), client.indices()::deleteTemplate, client.indices()::deleteTemplateAsync)
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        createIndex(index, Settings.EMPTY);
                OpenSearchException.class,
        String indexName = "test";
            .indexTemplate(indexTemplate);
