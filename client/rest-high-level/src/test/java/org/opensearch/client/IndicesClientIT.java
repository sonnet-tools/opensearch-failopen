 * compatible open source license.
        assertThat(exception.getMetadata("opensearch.index"), hasItem(nonExistentIndex));  
        assertThat(aliasExists(index, alias2), equalTo(false));  
        }
                OpenSearchException.class,
            getSettingsRequest,
        response = execute(createDataStreamRequest, indices::createDataStream, indices::createDataStreamAsync);
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
        String alias = "alias";  
            new HashMap<>(),  
            OpenSearchException.class,
                refreshRequest,  
                highLevelClient().indices()::getIndexTemplate,  
import org.opensearch.client.indices.GetMappingsRequest;  
            highLevelClient().indices()::getSettingsAsync
        putMappingRequest.source(mappingBuilder);  
            putTemplateRequest,
            }
            getBothRequest,
        ComposableIndexTemplateExistRequest composableIndexTemplateExistRequest = new ComposableIndexTemplateExistRequest(templateName);
        createIndex(index, Settings.EMPTY);  
 * You may obtain a copy of the License at  
        GetIndexTemplatesResponse getTemplate1 = execute(  
        GetMappingsRequest request = new GetMappingsRequest().indices(indexName);  
        );  
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));  
    }
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
                highLevelClient().indices()::putSettings,
        );  
            assertFalse(conditionStatus.get("[max_docs: 1]"));
            assertFalse(rolloverResponse.isRolledOver());
            );
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName);
            assertEquals("test_new", rolloverResponse.getNewIndex());
            highLevelClient().indices()::deleteIndexTemplateAsync
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();  
            final List<String> templateNames = randomBoolean() ? Arrays.asList("*plate-1", "template-2") : Arrays.asList("template-*");
                assertTrue(execute(putRequest, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged());  
        updateIndexSettings(indexName, Settings.builder().put("refresh_interval", "30s"));
        String indexName = "get_index_test";
        );
import org.opensearch.client.indices.GetIndexResponse;  
            // Delete index if exists
            indices::dataStreamsStatsAsync  
            "source",
        XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
            assertTrue("Index should exist after creation with creation_date setting", indexExists(indexName));
            .indexTemplate(indexTemplate);
        request.explain(true);
            .alias(new Alias("alias-1").indexRouting("abc"))  
        closeIndex(index);  
        );
        mappingBuilder.endObject().endObject().endObject();
                highLevelClient().indices()::getAlias,
    public void testUpdateIndexSettingsFailFinalSetting() throws IOException {
        assertThat(dataStreamStat.getBackingIndices(), equalTo(1));  
            boolean response = execute(request, highLevelClient().indices()::exists, highLevelClient().indices()::existsAsync);
        assertThat(e.status(), equalTo(RestStatus.NOT_FOUND));
        Boolean isWriteIndex = (Boolean) getAlias.get("is_write_index");
    public void testPutTemplateWithTypesUsingUntypedAPI() throws Exception {
            );
        assertNotNull(mappingMetadata);
    }  
            assertThat(aliasMetadata1, notNullValue());
        int backingIndices = dataStreamsStatsResponse.getBackingIndices();
            assertFalse(indexExists(nonExistentIndex));
            hasSize(1)  
                unmodifiableSettingRequest,  
            alreadyExistsError.getDetailedMessage(),  
        Map<String, Object> fieldMapping = (Map<String, Object>) ((Map<String, Object>) o).get("field-1");
    public void testOpenNonExistentIndex() throws IOException {
        {  
        assertEquals(2016, term.get("year"));  
import org.opensearch.action.support.IndicesOptions;
        {
        // Index present
            GetAliasesResponse getAliasesResponse = execute(
            assertThat(refreshResponse.getTotalShards(), equalTo(1));
                clearCacheRequest,
        assertThat(o, instanceOf(Map.class));  
        );
        AliasActions addAction = new AliasActions(AliasActions.Type.ADD).index(index).aliases(alias);
    }
        GetAliasesRequest getAliasesRequest2 = new GetAliasesRequest();  
            String existingIndex = "apples";  
            createIndex(index, settings);  
            OpenSearchStatusException.class,  
        );
                 "alias": {}
    @SuppressWarnings("unchecked")
        );
        // Rejected due to unknown settings  
        MappingMetadata mappingMetadata = getIndexResponse.getMappings().get(indexName);
            Settings.builder()  
        assertThat(template2.settings().get("index.number_of_replicas"), equalTo("0"));
        {
            highLevelClient().indices()::updateAliasesAsync
        }
            .mapping(  
        assertThat(templates.keySet(), hasSize(1));
            assertThat(aliasMetadata.alias(), equalTo("alias1"));  
            dynamicSettingRequest,
                "Exception message should indicate that index.creation_date cannot be updated. Got: " + exception.getMessage(),
            .mapping("{\"properties\": { \"name\": { \"type\": \"text\" }}}", MediaTypeRegistry.JSON)
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(nonExistentIndex);
            highLevelClient().indices()::validateQuery,
        int value = 10;
        assertEquals("0", indexSettings.get("number_of_replicas"));  
    }  
        removeIndexRequest.addAliasAction(new AliasActions(AliasActions.Type.REMOVE_INDEX).indices(nonExistentIndex));
        );  
            .create(true)  
            client.indices()::getIndexTemplateAsync
        );  
            String nonExistentIndex = "non_existent_index";
            () -> execute(unknownSettingTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync)
            OpenSearchException.class,  
        Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue("target.aliases.alias", getIndexResponse);
        String alias = "alias";
                + "  \"speech_number\": \"\","  
        {
            client.indices()::getIndexTemplateAsync  
        ResponseException exception = expectThrows(  
                getAliasesRequest,
        AcknowledgedResponse putMappingResponse = execute(
import org.opensearch.client.indices.GetDataStreamResponse;
        PutIndexTemplateRequest unknownSettingTemplate = new PutIndexTemplateRequest("t3").patterns(Collections.singletonList("any"))
        assertThat(  
        createIndex(indexName, basicSettings, mappings);
            execute(putTemplate2, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged(),
import org.opensearch.client.indices.CreateIndexRequest;
        highLevelClient().indices().create(new CreateIndexRequest("test").alias(new Alias("alias")), RequestOptions.DEFAULT);  
            GetIndexRequest request = new GetIndexRequest(existingIndex, nonExistentIndex);
            Map<String, Object> term = (Map) filter.get("term");  
                highLevelClient().indices()::clearCacheAsync
            GetAliasesResponse getAliasesResponse = execute(
                highLevelClient().indices()::createAsync  
            () -> execute(openIndexRequest, highLevelClient().indices()::open, highLevelClient().indices()::openAsync)
        UpdateSettingsRequest unmodifiableSettingRequest = new UpdateSettingsRequest(index);
    public void testDeleteIndex() throws IOException {  
        assertThat(template2.patterns(), contains("pattern-2", "name-2"));
    }
        AcknowledgedResponse aliasesAddRemoveResponse = execute(
        );  
        );
        dataStreams = getDataStreamResponse.getDataStreams();
        assertNotNull(indexSettings);
        );
        {
import org.opensearch.client.indices.CreateDataStreamRequest;
        String indexName = "get_settings_index";  
        aliasesAddRemoveRequest.addAliasAction(addAction);
            aliasesRemoveIndexRequest,
            );
        assertEquals(RestStatus.NOT_FOUND, exception.status());
        assertThat(getResponse.getIndexTemplates().get(templateName), equalTo(indexTemplate));
            .includeDefaults(true);
        );
        String index = "index";
            assertFalse(response);
            OpenSearchException exception = expectThrows(  
            putComposableIndexTemplateRequest,
    public void testAliasesNonExistentIndex() throws IOException {
            );
    public void testDataStreams() throws Exception {  
            String indexName = "test_index_exists_index_present";  
                .get(0)
            String mappings = "{\"properties\":{\"field2\":{\"type\":\"keyword\"}}}";
            CreateIndexResponse createIndexResponse = execute(
            );
                OpenSearchException.class,
            "existing template overlaps the higher priority template we provided for the simulation",  
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            );
        for (int i = 0; i < indices.length; i++) {
import java.util.Collections;
        {  
                final IndexTemplatesExistRequest existsRequest = new IndexTemplatesExistRequest("template-" + suffix);
            FlushRequest flushRequest = new FlushRequest(nonExistentIndex);
 *
        mappingBuilder.field("type", "text");
            highLevelClient().indices()::get,  
            getBoth.getIndexTemplates().stream().map(IndexTemplateMetadata::name).toArray(),
        assertTrue(resizeResponse.isShardsAcknowledged());
        );
                getAliasesRequest,
        ResizeResponse resizeResponse = execute(resizeRequest, highLevelClient().indices()::clone, highLevelClient().indices()::cloneAsync);
        assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(RestStatus.BAD_REQUEST.getStatus()));
    public void testAnalyze() throws Exception {
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
        assertTrue(resizeResponse.isShardsAcknowledged());
            ForceMergeRequest forceMergeRequest = new ForceMergeRequest(nonExistentIndex);
        }
                getAliasesRequest,  
        );  
            assertThat(getAliasesResponse.getAliases().get("index3").size(), equalTo(0));
import static org.hamcrest.Matchers.hasSize;
            equalTo(RestStatus.NOT_FOUND)  
            );
        final int unmodifiableSettingValue = 3;
            Settings.builder().put("index.routing.allocation.require._name", firstNode).put("index.blocks.write", true)  
        );
    }
                .put("index.number_of_routing_shards", 4)  
            highLevelClient().indices()::putTemplate,
            ).status(),
            Collections.emptyList(),
        assertThat(unmodifiableSetting.getDefault(Settings.EMPTY), not(unmodifiableSettingValue));  
            highLevelClient().indices()::getSettings,  
                .name(),  
        assertThat(
        Settings targetSettings = Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build();
            .put("index.number_of_replicas", 0)
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"@timestamp\":{\"type\":\"date\"}}}");  
        getAliasesRequest2.indices("does_not_exist");
        assertFalse(execute(getAliasesRequest, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));  
        assertThat(aliasExists(index, alias), equalTo(false));
        }
            final IndexTemplatesExistRequest neitherRequest = new IndexTemplatesExistRequest("neither-*");  
        assertEquals("0", indexSettings.get("number_of_replicas"));  
            getComposableIndexTemplateRequest,  
            ForceMergeRequest forceMergeRequest = new ForceMergeRequest(index);
        assertTrue(resizeResponse.isAcknowledged());  
        );
        // default settings should be null
        String indexName = "get_settings_index";
        {  
        );  
        getDataStreamResponse = execute(getDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync);  
        }
            assertFalse(indexExists(indexName));
    public void testShrink() throws IOException {  
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/60461")
        assertThat(
        response = execute(
        aliasesAddRemoveRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).indices(index).alias(alias + "2"));
        OpenSearchException alreadyExistsError = expectThrows(
        Map<String, Object> getAlias = getAlias(index, alias);
            assertThat(aliasMetadata1, notNullValue());
            rolloverRequest.dryRun(true);
            assertThat(aliasMetadata1, notNullValue());  
            String indexName = "plain_index";
        );
import static org.hamcrest.Matchers.nullValue;  
            .filter(QueryBuilders.termQuery("user", "foobar"));  
        assertEquals("1", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_SHARDS));  
                highLevelClient().indices()::getAliasAsync
            request,  
        }
        highLevelClient().index(new IndexRequest("test").id("1").source("field", "value"), RequestOptions.DEFAULT);
        final String[] indices = new String[randomIntBetween(1, 5)];
            );
        assertNull(getSettingsResponse.getSetting(indexName, "index.number_of_replicas"));
        createIndex(index, Settings.EMPTY);
        {
            /*
            CreateIndexResponse createIndexResponse = execute(
        {  
        String index = "index";  
                highLevelClient().indices()::putSettingsAsync  
        assertThat(extractRawValues("my-template.index_patterns", templates), contains("pattern-1", "name-*"));
                    client.indices()::getIndexTemplateAsync
            new Template(null, null, Map.of("simulation-alias", simulationAlias)),
         * This test is quite extensive as this is the only way we can check that we haven't slid out of sync with the server
        }  
        aliasesRemoveIndexRequest.addAliasAction(removeIndexAction);
        assertNotNull(getIndexResponse.getMappings().get(indexName));
            assertThat(getAliasesResponse.getError(), nullValue());
        {  
            ClearIndicesCacheResponse clearCacheResponse = execute(
        assertThat(getBoth.getIndexTemplates(), hasSize(2));  
        );  
            highLevelClient().indices()::close,
        assertThat(dataStream.getName(), equalTo(dataStreamName));  
        );
            highLevelClient().indices()::updateAliasesAsync
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));  
    public void testUpdateAliases() throws IOException {
        String nonExistentIndex = "non_existent_index";
        }
        String alias2 = "alias2";
            );
/*  
            );
                    Arrays.asList("pattern-" + suffix, "name-" + suffix)
import org.opensearch.client.indices.DataStreamsStatsRequest;
                .isAcknowledged()  
        IndicesAliasesRequest mixedRequest = new IndicesAliasesRequest();  
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("_all");  
            highLevelClient().indices()::updateAliases,
            );
            settings.put(SETTING_CREATION_DATE, 9876543210L);
        mixedRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).indices(index).aliases(alias));
            highLevelClient().indices()::putIndexTemplate,
        createIndex("source", Settings.builder().put("index.number_of_shards", 4).put("index.number_of_replicas", 0).build());  
        type.put("type", "text");
        );
            assertThat(aliasMetadata1, notNullValue());
        assertThat(dynamicSetting.getDefault(Settings.EMPTY), not(dynamicSettingValue));
        assertThat(
        assertThat(template1.patterns(), contains("pattern-1", "name-1"));
            );
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                "OpenSearch exception [type=settings_exception, "
        assertFalse(response.isValid());
            Alias alias = new Alias("alias_name");
             "index": {  
            putTemplateRequest,
        assertTrue(props.containsKey("name"));  
        GetFieldMappingsRequest getFieldMappingsRequest = new GetFieldMappingsRequest().indices(indexName).fields("field");  
        );
        String templateName = "my-template";
import org.opensearch.core.xcontent.XContentBuilder;  
        String index = "index";
        addAction = new AliasActions(AliasActions.Type.ADD).indices(index).alias(alias2);  
            rolloverRequest.dryRun(false);
        }  
            request,
        final Setting<Integer> unmodifiableSetting = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;  
import org.opensearch.common.ValidationException;
    }  
            UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(indexName);
            );
        assertThat(dataStreamStat.getMaximumTimestamp(), equalTo(0L)); // No data in here
        assertThat(response.isAcknowledged(), equalTo(true));
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
        assertThat(indexSettingsAsMap.get(dynamicSettingKey), equalTo(String.valueOf(dynamicSettingValue)));  
            );
        CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest(dataStreamName);  
            assertThat(flushResponse.getSuccessfulShards(), equalTo(1));  
        createIndex(
        GetComposableIndexTemplatesResponse getResponse = execute(
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);  
        String nonExistentIndex = "index_that_doesnt_exist";  
    }  
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest("alias");
            );  
            assertThat(flushResponse.getTotalShards(), equalTo(1));
import org.apache.hc.client5.http.classic.methods.HttpPost;
                highLevelClient().indices()::getAlias,  
            highLevelClient().indices()::getSettingsAsync  
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index, "non_existent_index");  
    public void testPutMapping() throws IOException {
                .startObject("settings")  
import org.opensearch.common.unit.TimeValue;
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
    }
        assertNull(getIndexResponse.getSetting(indexName, "index.refresh_interval"));
        assertTrue(putMappingResponse.isAcknowledged());  
        );
    public void testDeleteAlias() throws IOException {
        assertTrue(execute(getAliasesRequest, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));
        assertThat(aliasExists(alias2), equalTo(true));  
        assertThat(dataStream.getName(), equalTo(dataStreamName));
            assertEquals("1", aliasData.get("index_routing"));
                highLevelClient().indices()::createAsync
        assertThat(dataStream.getGeneration(), equalTo(1L));
            null  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            String nonExistentIndex = "non_existent_index";  
            execute(new DeleteIndexTemplateRequest("template-1"), client.indices()::deleteTemplate, client.indices()::deleteTemplateAsync)
            highLevelClient().indices()::putMapping,  
            assertEquals("text", XContentMapValues.extractValue(indexName + ".mappings.properties.field.type", getIndexResponse));  
        assertThat(isWriteIndex, equalTo(addAction.writeIndex()));
                highLevelClient().indices()::flush,
            getSettingsRequest,  
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
        createIndex(index, Settings.EMPTY);
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));  
}
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest("my-template").patterns(
            OpenSearchException.class,
        assertThat(getAll.getIndexTemplates().size(), greaterThanOrEqualTo(2));  
            GetAliasesResponse getAliasesResponse = execute(
import org.opensearch.client.indices.GetDataStreamRequest;
            highLevelClient().indices()::validateQuery,
            boolean response = execute(request, highLevelClient().indices()::exists, highLevelClient().indices()::existsAsync);
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();  
            String indexName = "creation_date_index";
    public void testSplit() throws IOException {  
        assertNull(getSettingsResponse.getSetting(indexName, "index.refresh_interval"));
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
        assertTrue(execute(goodTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged());
            highLevelClient().indices()::shrink,  
                + "  \"type\": \"act\","  
                highLevelClient().indices()::putSettings,
        );  
        assertThat(fieldMappingMap, equalTo(Collections.singletonMap("field", metadata)));  
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));  
            )
        );
    public void testIndexPutSettingNonExistent() throws IOException {
            OpenSearchException exception = expectThrows(
                .getIndexTemplates(),
import java.util.Map;
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("alias1");
    public void testCreateIndexWithCreationDate() throws IOException {
        {
            highLevelClient().indices()::putMappingAsync
        String index = "shakespeare";  
                highLevelClient().indices()::flushAsync  
            ResponseException exception = expectThrows(
                getAliasesRequest,
            );
        GetFieldMappingsResponse getFieldMappingsResponse = execute(
            ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest(nonExistentIndex);
            assertThat(aliasMetadata.getIndexRouting(), nullValue());
            // Create index and attempt to update creation_date - should fail as it's a final setting
        OpenSearchStatusException unknownSettingError = expectThrows(  
        ComposableIndexTemplate simulationTemplate = new ComposableIndexTemplate(  
import java.io.IOException;
            assertTrue(conditionStatus.get("[max_age: 1ms]"));  
    @SuppressWarnings("unchecked")
            )
        );  
                rolloverRequest,
import org.apache.hc.client5.http.classic.methods.HttpGet;
                exception.getMessage().contains("Can't update non dynamic settings [[index.creation_date]]")
        // noinspection unchecked
            .put("index.number_of_shards", 2)  
import org.opensearch.client.indices.AnalyzeResponse;  
import org.opensearch.common.settings.Settings;
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            assertEquals("test", rolloverResponse.getOldIndex());  
            assertThat(aliasMetadata.getFilter(), nullValue());
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(index);
 * Modifications Copyright OpenSearch Contributors. See
        GetDataStreamResponse getDataStreamResponse = execute(getDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync);
        assertThat(
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(indices);  
        String index = "index";
            createIndexRequest.settings(settings);
        AcknowledgedResponse putMappingResponse = execute(
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
                    client.indices()::getIndexTemplateAsync
        AcknowledgedResponse putTemplateResponse = execute(  
        assertTrue(closeIndexResponse.isAcknowledged());
            pattern,
/*  
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"host_name\":{\"type\":\"keyword\"}}}");
            highLevelClient().indices()::updateAliases,
    }
            assertFalse(rolloverResponse.isRolledOver());
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.OK));
    }
        );
                OpenSearchException.class,
        );  
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("non_existent_alias*");  
        expected.put("properties", field);
        );
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));  
                .put("index.number_of_shards", 2)
            highLevelClient().indices()::deleteAliasAsync
        );
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));  
        IndicesAliasesRequest aliasesRemoveIndexRequest = new IndicesAliasesRequest();  
                OpenSearchException.class,  
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
                highLevelClient().indices()::create,  
        DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest(dataStreamName);
        );  
         * because the server renders the xcontent in a spot that is difficult for us to access in a unit test.
        );
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
                equalTo(3)
        assertEquals("1", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_SHARDS));  
            OpenSearchException exception = expectThrows(
        OpenIndexResponse openIndexResponse = execute(
                + "  \"text_entry\": \"ACT I\""  
            }
        assertThat(
            assertThat(
            assertEquals("test", rolloverResponse.getOldIndex());
            highLevelClient().indices()::updateAliases,
        }
        );
        assertThat(
        assertThat(
        );
    }
                highLevelClient().indices()::getAliasAsync
        PutIndexTemplateRequest putTemplate1 = new PutIndexTemplateRequest("template-1").patterns(Arrays.asList("pattern-1", "name-1"))
            client.indices()::getIndexTemplate,  
    public void testGetSettingsNonExistentIndex() throws IOException {
        assertTrue(aliasResponse.isAcknowledged());
            client.indices()::getIndexTemplateAsync
            assertFalse(indexExists(nonExistentIndex));
        indexSettingsAsMap = getIndexSettingsAsMap(index);  
                .endObject()  
        assertThat(exception.validationErrors().get(0), equalTo("index is missing"));
        );  
            ResponseException.class,
        DataStreamStats dataStreamStat = dataStreamsStats.get(dataStreamName);  
            highLevelClient().indices()::putTemplateAsync  
        }  
            assertThat(flushResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
        assertThat(aliasExists(alias), equalTo(false));  
        String dataStreamName = "data-stream";
            settings.put(SETTING_NUMBER_OF_REPLICAS, 2);
            GetIndexRequest request = new GetIndexRequest(indexName);
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.OK));  
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
                ).alias(new Alias("alias-" + suffix));
        assertThat(indexSettingsAsMap.get(staticSettingKey), equalTo(staticSettingValue));
        AcknowledgedResponse putTemplateResponse = execute(
        );
        assertThat(closeIndexResponse.getIndices(), notNullValue());
            Arrays.asList("pattern-1", "name-*")
            client().performRequest(new Request(HttpPut.METHOD_NAME, "/index1/_alias/alias1"));
            RefreshResponse refreshResponse = execute(
        assertEquals("text", XContentMapValues.extractValue(indexName + ".mappings.properties.field.type", getIndexResponse));  
            OpenSearchException.class,
            highLevelClient().indices()::getAsync
            mappingBuilder.endObject().endObject().endObject();
            badMappingError.getDetailedMessage(),
                indexUpdateSettingsRequest,
            assertThat(aliasMetadata.getSearchRouting(), nullValue());  
            String indexName = "test_index";  
        GetSettingsResponse getSettingsResponse = execute(
            aliasesAddRemoveRequest,  
            String nonExistentIndex = "non_existent_index";
            Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue(
            assertThat(getAliasesResponse.getException(), nullValue());
    @SuppressWarnings("unchecked")
                getAliasesResponse.getAliases().size(),  
            createIndex("index2", Settings.EMPTY);
            request,  
        assertThat(
        updateIndexSettings("source", Settings.builder().put("index.blocks.write", true));  
        assertTrue(putMappingResponse.isAcknowledged());
            addAction.writeIndex(randomBoolean());
        ValidateQueryRequest request = new ValidateQueryRequest(index).query(builder);  
import org.opensearch.action.admin.indices.shrink.ResizeResponse;
                getIndexResponse
            );
        assertEquals("1", getSettingsResponse.getSetting(indexName, "index.number_of_shards"));  
            highLevelClient().indices()::getSettingsAsync
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();  
        assertThat(
            // Create index with creation_date setting - should succeed now that it's not private  
            GetAliasesResponse getAliasesResponse = execute(
             "status": 404,
        OpenSearchStatusException badMappingError = expectThrows(  
        org.opensearch.client.core.AcknowledgedResponse aliasDeleteResponse = execute(
        mappingBuilder.field("type", "text");
        GetMappingsResponse getMappingsResponse = execute(
        final String staticSettingValue = "true";
        assertThat(exception.getMetadata("opensearch.index"), hasItem(nonExistentIndex));
            () -> execute(
        );
            () -> execute(removeIndexRequest, highLevelClient().indices()::updateAliases, highLevelClient().indices()::updateAliasesAsync)
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
    @SuppressWarnings("unchecked")
            assertThat(clearCacheResponse.getTotalShards(), equalTo(1));  
                highLevelClient().indices()::getAliasAsync  
        assertThat(staticSetting.getDefault(Settings.EMPTY), not(staticSettingValue));
        assertThat(aliasExists(alias2), equalTo(false));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        assertThat(
        IndicesAliasesRequest aliasesAddRemoveRequest = new IndicesAliasesRequest();
        Map<String, Object> getIndexResponse = getAsMap("target");
        Map<String, Object> indexSettings = (Map<String, Object>) XContentMapValues.extractValue("target.settings.index", getIndexResponse);  
            assertThat(getAliasesResponse.getAliases().size(), equalTo(2));
        );
        getDataStreamRequest = new GetDataStreamRequest(null);
            assertThat(getAliasesResponse.getAliases().get(index).size(), equalTo(1));  
                .put("index.number_of_routing_shards", 4)  
import org.opensearch.client.indices.rollover.RolloverRequest;  
            FlushRequest flushRequest = new FlushRequest(index);
        assertEquals("30s", updatedResponse.getSetting(indexName, "index.refresh_interval"));
        String setting = "no_idea_what_you_are_talking_about";  
    }
        assertThat(aliasExists(index, alias), equalTo(false));
                OpenSearchException.class,  
        assertTrue(putMappingResponse.isAcknowledged());
        assertThat(dataStreams, hasSize(1));  
import org.opensearch.client.indices.SimulateIndexTemplateResponse;
            );  
        String alias = "alias";  
import org.opensearch.client.indices.DataStreamsStatsResponse;  
            assertEquals(1, conditionStatus.size());
import static org.hamcrest.CoreMatchers.hasItem;  
            assertEquals(RestStatus.NOT_FOUND, exception.status());
            */  
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
            )
        rolloverRequest.addMaxIndexDocsCondition(1);
            simulateResponse.overlappingTemplates().get("my-template").get(0),
            String nonExistentIndex = "non_existent_index";  
        );
        GetSettingsResponse updatedResponse = execute(  
                "Index creation should be acknowledged when setting creation_date during index creation",
        {
            OpenSearchException.class,
        assertThat(
        assertTrue(execute(goodTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged());
            OpenSearchException.class,
            1L,
                highLevelClient().indices()::getAlias,  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
            RefreshRequest refreshRequest = new RefreshRequest(nonExistentIndex);  
            // Create index  
        final String staticSettingKey = IndexSettings.INDEX_CHECK_ON_STARTUP.getKey();  
            );  
            assertTrue(conditionStatus.get("[max_age: 1ms]"));
        assertThat(getAlias.get("index_routing"), equalTo("routing"));
            RolloverResponse rolloverResponse = execute(
            OpenSearchStatusException.class,
        Map<String, AliasMetadata> aliases = simulateResponse.resolvedTemplate().aliases();  
                    + "reason=Can't update non dynamic settings [[index.number_of_shards]] for open indices [[index/"  
        String indexName = "mapping_index";  
        AcknowledgedResponse putMappingResponse = execute(
        String indexName = "get_settings_index";
        assertTrue(template2.mappings().sourceAsMap().containsKey("properties"));  
        OpenSearchStatusException e = expectThrows(  
            putMappingRequest,  
        assertTrue(aliasesRemoveIndexResponse.isAcknowledged());
    }  
        }
            hasItems("template-1", "template-2")  
        OpenSearchException exception = expectThrows(
                highLevelClient().indices()::getAliasAsync
import org.opensearch.core.common.unit.ByteSizeValue;  
import org.opensearch.client.indices.PutMappingRequest;  
        final int dynamicSettingValue = 0;  
        PutMappingRequest putMappingRequest = new PutMappingRequest(indexName);  
import org.opensearch.index.query.QueryBuilders;  
                rolloverRequest,  
        assertThat(statusException.status(), equalTo(RestStatus.NOT_FOUND));
            getAll.getIndexTemplates().stream().map(IndexTemplateMetadata::name).collect(Collectors.toList()),
            new ComposableIndexTemplate.DataStreamTemplate()  
    public void testIndexTemplatesExist() throws Exception {  
        );
            assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(RestStatus.BAD_REQUEST.getStatus()));
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));  
            assertThat(getAliasesResponse.getError(), equalTo("alias [" + alias + "] missing"));  
        exception = expectThrows(
        assertThat(aliasExists(index, alias2), equalTo(true));
            "the template we provided for the simulation has a higher priority than the one in the system",  
            pattern,  
            "field",  
            1L,  
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
import org.opensearch.client.indices.GetIndexRequest;
/*
        assertTrue(  
import static org.hamcrest.Matchers.equalTo;
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]")
        }
            )
        }  
            assertEquals(3, conditionStatus.size());
            highLevelClient().indices()::putTemplateAsync,
        String mappings = "\"properties\":{\"field-1\":{\"type\":\"integer\"}}";  
            Settings.Builder settings = Settings.builder();  
        );
    public void testClone() throws IOException {  
        String mappings = "\"properties\":{\"field-1\":{\"type\":\"integer\"}}";  
            deleteComposableIndexTemplateRequest,
        @SuppressWarnings("unchecked")
 *
                )
        assertThat(byteSizeValue.getBytes(), not(equalTo(0L)));
                getAliasesRequest,
    public void testCloseNonExistentIndex() throws IOException {
            equalTo(true)  
            assertThat(refreshResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));
        );  
        );
        addAction.routing("routing").searchRouting("search_routing").filter("{\"term\":{\"year\":2016}}");  
        assertNotNull(getSettingsResponse.getSetting(indexName, "index.uuid"));
            expectThrows(
        assertThat(aliasExists(index, alias2), equalTo(true));
            assertFalse(indexExists(indexName));
        putMappingRequest.source(mappingBuilder);  
        String indexName = "test";
            highLevelClient().indices()::openAsync
            createIndex(existingIndex, Settings.EMPTY);
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;
            assertThat(aliasMetadata2, notNullValue());
            ).status(),
            assertEquals("test_new", rolloverResponse.getNewIndex());
                highLevelClient().indices()::create,  
            .settings(Settings.builder().put("this-setting-does-not-exist", 100));
                highLevelClient().indices()::getAliasAsync
                nonExistentIndexRequest,
    public void testInvalidValidateQuery() throws IOException {
        Map<String, DataStreamStats> dataStreamsStats = dataStreamsStatsResponse.getDataStreams();  
        Settings basicSettings = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build();
            execute(putTemplate1, client.indices()::putTemplate, client.indices()::putTemplateAsync).isAcknowledged(),
        aliasesAddRemoveRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).indices(index).alias(alias));  
            )
        );
import org.opensearch.action.index.IndexRequest;  
                    new GetIndexTemplatesRequest("template-1"),
            equalTo("template-2")
            createIndex(indexName, Settings.EMPTY);
        final GetFieldMappingsResponse.FieldMappingMetadata metadata = new GetFieldMappingsResponse.FieldMappingMetadata(
import org.opensearch.client.indices.AnalyzeRequest;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
        assertEquals("1", getSettingsResponse.getSetting(indexName, "index.number_of_shards"));  
        assertThat(dataStreams, hasSize(0));
            createIndexRequest.alias(alias);
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName);  
                highLevelClient().indices()::getAliasAsync  
            highLevelClient().indices()::putTemplate,  
        Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue("target.aliases.alias", getIndexResponse);
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest("my-template").patterns(  
        Object o = mappingMetadata.getSourceAsMap().get("properties");
                highLevelClient().indices()::getAliasAsync
    }  
    public void testGetIndexWithDefaults() throws IOException {  
 * KIND, either express or implied.  See the License for the
            assertThat(forceMergeResponse.getFailedShards(), equalTo(0));  
                + "  \"line_number\": \"\","
        }
import org.opensearch.common.settings.Setting;  
        assertNotNull(aliasData);
            .indexTemplate(indexTemplate);
        assertEquals(RestStatus.NOT_FOUND, exception.status());
        assertThat(dataStream.getGeneration(), equalTo(1L));  
            highLevelClient().indices()::validateQueryAsync
        Map<String, Object> templates = getAsMap("/_template/my-template");
        );  
            Arrays.asList("pattern-1", "name-*")
import org.opensearch.client.indices.GetMappingsResponse;
                "OpenSearch exception [type=illegal_argument_exception, "  
        getAliasesRequest2.indices("index");
            1L,
                indexUpdateSettingsRequest,
        List<String> pattern = Collections.singletonList("pattern");
                () -> execute(forceMergeRequest, highLevelClient().indices()::forcemerge, highLevelClient().indices()::forcemergeAsync)
            .settings(Settings.builder().put("number_of_shards", "2").put("number_of_replicas", "0"));  
 * GitHub history for details.
            assertThat(
                OpenSearchException.class,
    public void testCloseExistingIndex() throws IOException {  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
        Map<String, Object> filter = (Map<String, Object>) getAlias.get("filter");
        assertThat(response.isAcknowledged(), equalTo(true));  
                    client.indices()::getIndexTemplate,
                rolloverRequest,  
            );
        assertThat(aliasExists(index, alias), equalTo(false));
        UpdateSettingsRequest staticSettingRequest = new UpdateSettingsRequest(index);  
            assertThat(forceMergeRequest.getDescription(), containsString(index));  
                getAliasesRequest,
        OpenSearchException strictException = expectThrows(
        {
            containsString("Root mapping definition has unsupported parameters:  [my_doc_type")  
               "aliases": {
                highLevelClient().indices()::putSettingsAsync  
                getAliasesResponse.getException().getMessage(),  
        createIndex(indexName, Settings.EMPTY);
        {  
    }
    public void testPutTemplateWithDeprecatedTemplateField() throws Exception {  
            ).status(),  
        {
        assertThat(aliasExists(alias2), equalTo(true));
        String index = "test";  
        );
    }
            exception.getMessage(),
        RestHighLevelClient client = highLevelClient();
            assertTrue(createIndexResponse.isAcknowledged());  
            .create(randomBoolean())
        OpenSearchException exception = expectThrows(
            assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
        Map<String, Object> fieldMapping = (Map<String, Object>) ((Map<String, Object>) o).get("field-1");
        PutMappingRequest putMappingRequest = new PutMappingRequest(indexName);
    public void testGetAliasesNonExistentIndexOrAlias() throws IOException {
        assertNotNull(getSettingsResponse.getSetting(indexName, "index.refresh_interval"));
            createIndex(index, settings);
            assertThat(getAliasesResponse.getAliases().get("index3").size(), equalTo(0));  
            .order(10)
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
        assertNotNull(aliasData);
            RequestOptions.DEFAULT
            () -> execute(mixedRequest, highLevelClient().indices()::updateAliases, highLevelClient().indices()::updateAliasesAsync)
            OpenSearchException exception = expectThrows(
            highLevelClient().indices()::putIndexTemplate,
            OpenSearchException.class,
        assertNotNull(getIndexResponse.getMappings().get(indexName));
            OpenSearchException.class,  
    }  
            highLevelClient().indices()::existsIndexTemplateAsync
                highLevelClient().indices()::create,
            );
            );
            highLevelClient().indices()::getIndexTemplateAsync
        RolloverRequest rolloverRequest = new RolloverRequest("alias", "test_new");
    }  
import org.opensearch.core.common.bytes.BytesArray;
        assertTrue(template1.aliases().containsKey("alias-1"));  
                    client.indices()::deleteTemplateAsync  
        assertEquals("integer", fieldMapping.get("type"));
        assertThat(response.isAcknowledged(), equalTo(true));  
    }
        resizeRequest.setTargetIndex(
    public void testExistsAlias() throws IOException {
        AcknowledgedResponse response = execute(  
        QueryBuilder builder = QueryBuilders.boolQuery()
        GetIndexResponse getIndexResponse = execute(
            );  
        assertNotNull(getIndexResponse.getMappings().get(indexName));  
                highLevelClient().indices()::getAlias,  
        GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest(dataStreamName);  
            equalTo(RestStatus.NOT_FOUND)
        closeIndex(index);
        assertThat(dataStreamStat.getDataStream(), equalTo(dataStreamName));
    public void testGetSettingsWithDefaultsFiltered() throws IOException {  
            assertFalse(indexExists(nonExistentIndex));
                    highLevelClient().indices()::putSettingsAsync  
            assertTrue(  
        GetSettingsResponse getSettingsResponse = execute(  
            GetAliasesResponse getAliasesResponse = execute(  
        assertThat(aliases, is(notNullValue()));
        });
            assertThat(flushResponse.getFailedShards(), equalTo(0));
            )
        indexSettingsAsMap = getIndexSettingsAsMap(index);
        SimulateIndexTemplateRequest simulateIndexTemplateRequest = new SimulateIndexTemplateRequest("pattern");
        createIndex(indexName1, Settings.builder().put("number_of_shards", 2).build());
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            client().performRequest(new Request(HttpPut.METHOD_NAME, "/index2/_alias/alias2"));
        createIndex(indexName, basicSettings, mappings);
            getIndexRequest,
            createIndex(index, Settings.EMPTY);
            String indexName = "final_setting_index";
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(nonExistentIndex);
import org.opensearch.cluster.metadata.MappingMetadata;
            startsWith(
        /*  
        );  
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest();  
        List<String> pattern = List.of("pattern");
                "OpenSearch exception [type=illegal_argument_exception, "
            );
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest(alias);
        // Index doesn't exist  
            .alias(new Alias("alias-1").indexRouting("abc"))
        assertTrue(aliasesAddResponse.isAcknowledged());
        Map<String, Object> props = (Map<String, Object>) template2.mappings().sourceAsMap().get("properties");
 * license agreements. See the NOTICE file distributed with
                highLevelClient().indices()::getAliasAsync  
        assertTrue(aliasesAddRemoveResponse.isAcknowledged());  
            .get(indexName);  
            client.indices()::getIndexTemplate,  
        PutIndexTemplateRequest putTemplate2 = new PutIndexTemplateRequest("template-2").patterns(Arrays.asList("pattern-2", "name-2"))
        exception = expectThrows(
        assertThat(aliasExists(alias), equalTo(true));
    }  
        updateIndexSettings("source", Settings.builder().put("index.blocks.write", true));  
        );
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(nonExistentIndex);  
    }
                .put("index.number_of_replicas", 0)
        );  
            () -> execute(finalGetDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync)
        assertNull(indexSettingsAsMap.get(staticSettingKey));  
            highLevelClient().indices()::open,
        );
        AnalyzeRequest detailsRequest = AnalyzeRequest.withGlobalAnalyzer("english", "One two three").explain(true);
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
                () -> execute(refreshRequest, highLevelClient().indices()::refresh, highLevelClient().indices()::refreshAsync)  
        GetIndexTemplatesResponse getAll = execute(
                    + "}",  
            assertTrue(rolloverResponse.isDryRun());
        List<DataStream> dataStreams = getDataStreamResponse.getDataStreams();
        assertThat(getTemplate1.getIndexTemplates(), hasSize(1));
import org.opensearch.client.indices.IndexTemplateMetadata;
import org.opensearch.core.common.Strings;  
            OpenSearchException.class,
            template,
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
        ValidationException withoutPatternError = expectThrows(  
        AnalyzeRequest noindexRequest = AnalyzeRequest.withGlobalAnalyzer("english", "One two three");  
            assertEquals(2, conditionStatus.size());
                .build()
        PutIndexTemplateRequest withoutPattern = new PutIndexTemplateRequest("t1");
        dataStream = dataStreams.get(0);
        {
        field.put("field", type);  
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices("get_multiple_settings*");  
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
            // Create index with mappings, aliases and settings
        );  
        );  
        Response response = client().performRequest(new Request(HttpGet.METHOD_NAME, "/" + index + "/_search"));  
        resizeRequest.setTargetIndex(
 * The OpenSearch Contributors require contributions made to  
            createIndexRequest.settings(settings);
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        goodTemplate.create(true);  
            assertThat(aliasMetadata2, notNullValue());
            new org.opensearch.action.admin.indices.create.CreateIndexRequest("target").settings(targetSettings).alias(new Alias("alias"))
        assertThat(exception.getMessage().contains(index), equalTo(true));
                    updateSettingsRequest,
    public void testGetIndexNonExistentIndex() throws IOException {
        assertThat(extractValue("my-template.settings.index.number_of_shards", templates), equalTo("3"));
        assertThat(getAlias.get("search_routing"), equalTo("search_routing"));  
        goodTemplate.create(false);  
            "{"
        Settings basicSettings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();  
            String indexName = "non_existent_index";
            assertThat(getAliasesResponse.getAliases().size(), equalTo(3));  
                flushRequest,
        {  
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices("_all");  
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
            () -> execute(withoutPattern, client.indices()::putTemplate, client.indices()::putTemplateAsync)
            assertThat(getAliasesResponse.getAliases().size(), equalTo(3));
    public void testGetPrivateSettings() throws IOException {
        );  
        assertThat(backingIndices, equalTo(1));
        }
    }
                highLevelClient().indices()::getAlias,  
            rolloverRequest.addMaxIndexAgeCondition(new TimeValue(1));  
                getAliasesRequest,
                MediaTypeRegistry.JSON
                "Unexpected number of aliases, got: " + getAliasesResponse.getAliases().toString(),
        createIndex(indexName, basicSettings);
        assertThat(extractRawValues("my-template.index_patterns", templates), contains("name-*"));  
        assertThat(aliasExists(alias), equalTo(false));
            getSettingsRequest,  
            () -> execute(closeIndexRequest, highLevelClient().indices()::close, highLevelClient().indices()::closeAsync)  
            This is the above response in json format:
            rolloverRequest.getCreateIndexRequest().mapping(mappings, MediaTypeRegistry.JSON);  
            )
            Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();
                forceMergeRequest,  
        {
        );  
        GetComposableIndexTemplateRequest getComposableIndexTemplateRequest = new GetComposableIndexTemplateRequest(templateName);
        assertThat(unknownSettingError.getDetailedMessage(), containsString("unknown setting [index.this-setting-does-not-exist]"));
    }  
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
        )  
        assertThat(getResponse.getIndexTemplates().size(), equalTo(1));
                highLevelClient().indices()::putSettingsAsync
    }
        createIndex(indexName, basicSettings);  
            highLevelClient().indices()::getSettingsAsync
        GetIndexRequest getIndexRequest = new GetIndexRequest(nonExistentIndex);  
        nonExistentIndexRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).index(nonExistentIndex).alias(alias));
            highLevelClient().indices()::get,  
        );
                highLevelClient().indices()::refresh,
            composableIndexTemplateExistRequest,
        String index = "some_index";
            assertFalse(indexExists(nonExistentIndex));
        assertThat(
        assertThat(  
    public void testGetSettingsFromMultipleIndices() throws IOException {
            assertThat(aliasMetadata, notNullValue());
        String alias2 = "alias2";
        // One index exists, one doesn't
                highLevelClient().indices()::getIndexTemplateAsync
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
            assertThat(getAliasesResponse.getError(), nullValue());
            OpenSearchException.class,
            );
            highLevelClient().indices()::putMappingAsync
import org.opensearch.client.indices.CloseIndexResponse;
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName)
        Object o = getIndexResponse.getMappings().get(indexName).getSourceAsMap().get("properties");
            XContentFactory.jsonBuilder()
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        assertEquals("0", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_REPLICAS));
import org.opensearch.action.admin.indices.flush.FlushRequest;
        {  
                .field("order", 10)
        mappingBuilder.endObject().endObject().endObject();
            exception.getMessage(),
                getAliasesRequest,
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest("my-template").source(
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName).includeDefaults(false);  
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();  
import org.opensearch.client.indices.DataStream;
import org.opensearch.client.indices.PutIndexTemplateRequest;
            putComposableIndexTemplateRequest,
            composableIndexTemplateExistRequest,  
        assertFalse(indexExists(nonExistentIndex));  
            assertThat(getAliasesResponse.getAliases().size(), equalTo(2));
            assertEquals(RestStatus.NOT_FOUND, exception.status());  
        client().performRequest(new Request(HttpPut.METHOD_NAME, "/index/_alias/alias"));  
        {
        AcknowledgedResponse response = execute(
        assertNotNull(detailsResponse.detail());
            assertTrue(indexExists(indexName));
        assertEquals("4", indexSettings.get("number_of_shards"));
        assertThat(dataStreams, hasSize(1));
        assertThat(exception.getMetadata("opensearch.index"), hasItem(nonExistentIndex));  
             }
    public void testRefresh() throws IOException {
            putMappingRequest,
        assertEquals(0, getSettingsResponse.getIndexToSettings().get("get_settings_index").size());
            assertThat(aliasMetadata1, notNullValue());
    }  
            assertEquals(RestStatus.NOT_FOUND, exception.status());
        String indexName = "get_settings_index";  
        exception = expectThrows(
        resizeRequest.setResizeType(ResizeType.CLONE);  
import org.apache.hc.client5.http.classic.methods.HttpPut;  
        assertNotNull(getIndexResponse.getMappings().get(indexName));  
            )
    public void testCRUDIndexTemplate() throws Exception {
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices("non_existent_index*");
        indexUpdateSettingsRequest.settings(Settings.builder().put(setting, value).build());
               }  
        OpenSearchException exception = expectThrows(
                    + "  }"
            GetAliasesResponse getAliasesResponse = execute(
        }
    }  
            "source",
        openIndex(index);
        assertThat(response.isAcknowledged(), equalTo(true));
            exception.getMessage(),
        assertThat(dataStreamsStats, notNullValue());
import org.opensearch.action.admin.indices.open.OpenIndexResponse;  
        assertThat(dataStreamsCount, equalTo(1));  
import org.opensearch.client.indices.SimulateIndexTemplateRequest;
            Map<String, Object> filter = (Map) aliasData.get("filter");
        }
                highLevelClient().indices()::getAlias,
        IndicesAliasesRequest removeIndexRequest = new IndicesAliasesRequest();
            highLevelClient().indices()::putIndexTemplateAsync  
        assertThat(withoutPatternError.validationErrors(), contains("index patterns are missing"));
import org.opensearch.common.compress.CompressedXContent;
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(indices);
        }
        );
        assertThat(byteSizeValue, notNullValue());
        resizeRequest.setResizeType(ResizeType.SHRINK);
                highLevelClient().indices()::putSettings,
                highLevelClient().indices()::getAliasAsync
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
        List<String> names = randomBoolean() ? Arrays.asList("*plate-1", "template-2") : Arrays.asList("template-*");
    public void testCreateIndex() throws IOException {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            new HashMap<>(),
        OpenIndexResponse lenientOpenIndexResponse = execute(
 * ownership. Elasticsearch licenses this file to you under  
        );
import org.opensearch.client.indices.CreateIndexResponse;  
        assertThat(aliasExists(index, alias), equalTo(true));  
        );
            exception.getMessage(),
        )
            .build();  
                highLevelClient().indices()::rollover,
import static org.opensearch.common.xcontent.support.XContentMapValues.extractRawValues;
            template,
    }
            highLevelClient().indices()::validateQueryAsync  
        );
        assertThat(closeIndexResponse.getIndices(), hasSize(indices.length));
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));  
            exception.getMessage(),  
                highLevelClient().indices()::forcemerge,
                ResponseException.class,
                .build()
            assertEquals("test", rolloverResponse.getOldIndex());  
        assertEquals("0", indexSettings.get("number_of_replicas"));  
                .field("number_of_replicas", 0)
        exception = expectThrows(  
import org.opensearch.client.indices.DeleteDataStreamRequest;
        );
 *  
            assertEquals("test_new", rolloverResponse.getNewIndex());
import org.opensearch.client.indices.DataStreamsStatsResponse.DataStreamStats;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
        assertEquals("_doc", mappingMetadata.type());  
            .alias(new Alias("alias-1"));
        AcknowledgedResponse aliasesRemoveIndexResponse = execute(  
                final PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("template-" + suffix).patterns(  
            assertThat(getAliasesResponse.getAliases().size(), equalTo(1));
        assertEquals(RestStatus.NOT_FOUND, exception.status());
            createIndex(index, settings);  
            assertThat(forceMergeRequest.getDescription(), containsString(nonExistentIndex));  
            aliasesAddRequest,  
            .create(randomBoolean())
        ComposableIndexTemplate indexTemplate = new ComposableIndexTemplate(
            // Return 404 if index doesn't exist
            highLevelClient().indices()::getSettings,
        assertThat(((Map<String, Object>) o).get("field-1"), instanceOf(Map.class));  
        assertThat(
import org.opensearch.OpenSearchStatusException;
        );
        assertEquals(
                getAliasesRequest,
        assertThat(template1.name(), equalTo("template-1"));
            getAllRequest,
        assertThat(template2.name(), equalTo("template-2"));  
        Map<String, Object> indexSettings = (Map<String, Object>) XContentMapValues.extractValue("target.settings.index", getIndexResponse);  
 */  
            GetAliasesResponse getAliasesResponse = execute(
import org.opensearch.action.admin.indices.flush.FlushResponse;
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
            closeIndexRequest,
            .indexTemplate(indexTemplate);
import org.opensearch.cluster.metadata.AliasMetadata;
        AcknowledgedResponse response = execute(  
        Map<String, Object> getIndexResponse = getAsMap("target");
    }  
                    + "reason=unknown setting [index.no_idea_what_you_are_talking_about] please check that any required plugins are installed, "
import org.opensearch.action.support.WriteRequest;
            equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
            simulateIndexTemplateRequest,
        putMappingRequest.source(mappingBuilder);
        PutComposableIndexTemplateRequest newIndexTemplateReq = new PutComposableIndexTemplateRequest().name("used-for-simulation")  
        Settings targetSettings = Settings.builder()
        assertThat(aliasExists(alias2), equalTo(true));  
        String nonExistentIndex = "non_existent_index";
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));  
        ResizeResponse resizeResponse = execute(resizeRequest, highLevelClient().indices()::split, highLevelClient().indices()::splitAsync);
        Map<String, Object> indexSettingsAsMap = getIndexSettingsAsMap(index);
                highLevelClient().indices()::clearCache,  
                getAliasesResponse.getException().getMessage(),  
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();  
                highLevelClient().indices()::rollover,
    public void testOpenExistingIndex() throws IOException {
            OpenSearchException exception = expectThrows(
        aliasesAddRequest.addAliasAction(addAction);
        }  
        XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
    public void testGetSettingsWithDefaults() throws IOException {
            highLevelClient().indices()::getFieldMapping,
        }  
        staticSettingRequest.settings(Settings.builder().put(staticSettingKey, staticSettingValue).build());
        );  
                createIndexResponse.isAcknowledged()
import org.opensearch.client.indices.IndexTemplatesExistRequest;  
        OpenSearchException exception = expectThrows(  
            for (String suffix : Arrays.asList("1", "2")) {
                getAliasesResponse.getException().getMessage(),
        mappingBuilder.field("type", "text");  
    }
        assertThat(getTemplate2.getIndexTemplates(), hasSize(1));
import org.opensearch.client.indices.GetIndexTemplatesResponse;
            Map<String, Object> getIndexResponse = getAsMap(indexName);
            resizeRequest,
        UpdateSettingsRequest dynamicSettingRequest = new UpdateSettingsRequest(index);
    public void testIndicesExists() throws IOException {  
            highLevelClient().indices()::getSettingsAsync
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));  
import static org.hamcrest.Matchers.startsWith;
                highLevelClient().indices()::getAlias,
 * specific language governing permissions and limitations
        ComposableIndexTemplate indexTemplate = new ComposableIndexTemplate(
        assertNull(getSettingsResponse.getSetting(indexName, "index.number_of_replicas"));
            getSettingsRequest,
            createIndex("index3", Settings.EMPTY);
        final Setting<String> staticSetting = IndexSettings.INDEX_CHECK_ON_STARTUP;
        client().performRequest(new Request(HttpPut.METHOD_NAME, "/" + index + "/_alias/" + alias));
        assertFalse(execute(getAliasesRequest2, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));
                createIndexRequest,
            execute(new GetIndexTemplatesRequest("template-*"), client.indices()::getIndexTemplate, client.indices()::getIndexTemplateAsync)
                highLevelClient().indices()::putSettingsAsync  
        createIndex(indexName, Settings.EMPTY);
        assertThat(aliasExists(index, alias), equalTo(false));
        assertNotNull(indexSettings);
        {  
            );  
        Template template = new Template(null, mappings, null);
            FlushResponse flushResponse = execute(  
import org.opensearch.client.indices.DeleteAliasRequest;
        );
    }  
        assertThat(  
        assertThat(dataStreamStat, notNullValue());
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;  
                + "  \"line_id\": 1,"
        assertEquals(RestStatus.NOT_FOUND, exception.status());  
        assertEquals("{\"properties\":{\"field-1\":{\"type\":\"integer\"}}}", mappingMetadata.source().string());
        QueryBuilder builder = QueryBuilders.queryStringQuery("line_id:foo").lenient(false);
import org.opensearch.index.IndexSettings;
        );
            String nonExistentIndex = "non_existent_index";  
import static org.hamcrest.Matchers.notNullValue;
            GetAliasesResponse getAliasesResponse = execute(
        GetSettingsResponse getSettingsResponse = execute(
        assertThat(dataStream.getIndices(), hasSize(1));
            OpenSearchStatusException.class,
        assertThat(aliasExists(alias), equalTo(false));
        String index = "index";  
    public void testRollover() throws IOException {
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
        assertThat(indexExists(index), equalTo(false));
        Map<String, Object> nodes = getAsMap("_nodes");
        // noinspection unchecked  
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = new PutComposableIndexTemplateRequest().name("ds-template")
            assertThat(getAliasesResponse.getError(), equalTo("alias [non_existent_alias] missing"));  
        assertEquals(RestStatus.NOT_FOUND, strictException.status());  
        unmodifiableSettingRequest.settings(Settings.builder().put(unmodifiableSettingKey, unmodifiableSettingValue).build());
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();  
        }
import org.opensearch.common.xcontent.json.JsonXContent;
        PutIndexTemplateRequest goodTemplate = new PutIndexTemplateRequest("t2").patterns(Arrays.asList("qa-*", "prod-*"));
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
            new IndexRequest("test").id("2").source("field", "value").setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL),  
import org.opensearch.OpenSearchException;
        mappingBuilder.startObject().startObject("properties").startObject("field");
        );  
 */  
        AliasActions removeAction = new AliasActions(AliasActions.Type.REMOVE).index(index).alias(alias);
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();  
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
        String[] indices = randomBoolean() ? Strings.EMPTY_ARRAY : null;
import static org.hamcrest.Matchers.is;  
        String indexName2 = "get_multiple_settings_two";  
                indexName + ".aliases.alias_name",  
            )
        );
public class IndicesClientIT extends OpenSearchRestHighLevelClientTestCase {
        assertEquals(RestStatus.NOT_FOUND, exception.status());
        GetIndexTemplatesResponse getBoth = execute(
                getAliasesRequest,
            );  
            highLevelClient().indices()::getSettingsAsync
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = new PutComposableIndexTemplateRequest().name(templateName)
            Settings.Builder settings = Settings.builder();  
        exception = expectThrows(  
                highLevelClient().indices()::forcemergeAsync
        IndicesClient indices = highLevelClient().indices();
            client.indices()::getIndexTemplateAsync
        );  
        request.explain(randomBoolean());
                unmodifiableSettingRequest,
            highLevelClient().indices()::getMappingAsync
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));
        createIndex(index, Settings.EMPTY);  
        assertThat(dataStream.getTimeStampField(), equalTo("@timestamp"));
        AliasMetadata alias = AliasMetadata.builder("alias").writeIndex(true).build();
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
                .put("index.number_of_replicas", 0)
        GetSettingsResponse getSettingsResponse = execute(
 */
        getAliasesRequest2.aliases("alias");
            highLevelClient().indices()::putMapping,
            .putNull("index.routing.allocation.require._name")
            )  
                    + "    }"
            assertThat(aliasMetadata2, notNullValue());
        assertThat(
            null  
            String index = "index";
                getAliasesRequest,
        DataStreamsStatsResponse dataStreamsStatsResponse = execute(  
            ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest(index);  
            {  
            highLevelClient().indices()::closeAsync  
        Settings basicSettings = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        getDataStreamRequest = new GetDataStreamRequest(null);
                highLevelClient().indices()::getAliasAsync
        assertTrue(exist);
import org.opensearch.action.admin.indices.alias.Alias;  
        assertThat(aliasExists(alias), equalTo(false));
            highLevelClient().indices()::putIndexTemplateAsync
             "error": "alias [something] missing",
                "{"
        {
            exception.getMessage(),  
            RolloverResponse rolloverResponse = execute(  
            );
            highLevelClient().indices()::getSettings,
 * not use this file except in compliance with the License.
import org.opensearch.client.indices.GetFieldMappingsResponse;
        mappingBuilder.startObject().startObject("properties").startObject("field");  
            new org.opensearch.action.admin.indices.create.CreateIndexRequest("target").settings(targetSettings).alias(new Alias("alias"))  
            assertNotNull(aliasData);  
import org.opensearch.cluster.metadata.Template;  
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        GetIndexTemplatesRequest getBothRequest = new GetIndexTemplatesRequest(names);  
        );
        {
        );
            assertThat(clearCacheResponse.getFailedShards(), equalTo(0));
        createIndex(indexName, Settings.EMPTY);
import org.opensearch.common.xcontent.XContentFactory;  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNull(getSettingsResponse.getSetting(indexName, "index.number_of_shards"));  
        Map<String, Object> getIndexResponse = getAsMap("target");
            equalTo(RestStatus.NOT_FOUND)
                highLevelClient().indices()::rolloverAsync
            String index = "index";  
            () -> execute(  
            );
        assertThat(aliasExists(index, alias2), equalTo(true));
        dynamicSettingRequest.settings(Settings.builder().put(dynamicSettingKey, dynamicSettingValue).build());  
    public void testPutTemplateBadRequests() throws Exception {
            assertThat(aliasMetadata.alias(), equalTo(alias));  
                highLevelClient().indices()::delete,  
                highLevelClient().indices()::getAliasAsync
        dataStreams = getDataStreamResponse.getDataStreams();  
        assertThat(  
        );  
        assertThat(lenientOpenIndexResponse.isAcknowledged(), equalTo(true));
        final RestHighLevelClient client = highLevelClient();
            highLevelClient().indices()::open,
            assertThat(aliasMetadata, notNullValue());
        );
        Map<String, Object> mappings = getMappingsResponse.mappings().get(indexName).sourceAsMap();
        ensureHealth(dataStreamName, (request -> { request.addParameter("wait_for_status", "yellow"); }));
        AliasMetadata simulationAlias = AliasMetadata.builder("simulation-alias").writeIndex(true).build();
        boolean exist = execute(
            "source",
                highLevelClient().indices()::getAlias,  
                () -> client().performRequest(new Request(HttpGet.METHOD_NAME, "/" + indexResult.getIndex() + "/_search"))  
 * software distributed under the License is distributed on an
        int dataStreamsCount = dataStreamsStatsResponse.getDataStreamCount();
            1L,  
        GetDataStreamRequest finalGetDataStreamRequest = getDataStreamRequest;
            highLevelClient().indices()::deleteAlias,
            CreateIndexResponse createIndexResponse = execute(  
        }
            putMappingRequest,  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
            () -> execute(
    public void testIndexPutSettings() throws IOException {
        highLevelClient().index(
                    highLevelClient().indices()::putSettings,
        assertThat((Map<String, String>) extractValue("my-template.aliases.alias-1", templates), hasEntry("index_routing", "abc"));
        GetIndexTemplatesRequest getAllRequest = new GetIndexTemplatesRequest();  
            RefreshRequest refreshRequest = new RefreshRequest(index);
            final IndexTemplatesExistRequest bothRequest = new IndexTemplatesExistRequest(templateNames);
                getAliasesRequest,
            assertThat(  
    }
    public void testGetIndex() throws IOException {  
            RolloverResponse rolloverResponse = execute(
 * Unless required by applicable law or agreed to in writing,
        assertThat(response.isAcknowledged(), equalTo(true));  
        GetIndexResponse getIndexResponse = execute(
            assertThat(clearCacheResponse.getSuccessfulShards(), equalTo(1));
        );
    public void testGetSettingsFiltered() throws IOException {
        final Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldMappingMap = getFieldMappingsResponse.mappings()
        assertOK(client().performRequest(postDoc));  
import static org.hamcrest.Matchers.containsString;  
        assertThat(dataStreamStat.getStoreSize().getBytes(), not(equalTo(0L))); // but still takes up some space on disk
        mixedRequest.addAliasAction(new AliasActions(AliasActions.Type.REMOVE).indices(nonExistentIndex).alias(alias));
            .names("index.refresh_interval")  
import static org.hamcrest.Matchers.hasEntry;  
        newIndexTemplateReq.indexTemplate(simulationTemplate);  
                    + "        \"type\": \"keyword\""
            new org.opensearch.action.admin.indices.create.CreateIndexRequest("target").settings(targetSettings).alias(new Alias("alias"))  
            assertTrue(conditionStatus.get("[max_docs: 1]"));  
            getFieldMappingsRequest,  
            highLevelClient().indices()::openAsync
            AliasMetadata aliasMetadata = getAliasesResponse.getAliases().get("index1").iterator().next();
            GetAliasesResponse getAliasesResponse = execute(  
        assertEquals("1", getSettingsResponse.getSetting(indexName, "index.number_of_shards"));
            .alias(new Alias("alias-1").indexRouting("abc"))  
        resizeRequest.setTargetIndex(
            mappingBuilder.startObject().startObject("properties").startObject("field");
        }
        assertThat(aliases.get("simulation-alias").getAlias(), is("simulation-alias"));
                "OpenSearch exception [type=settings_exception, " + "reason=final index setting [index.number_of_shards], not updateable"  
        Map<String, Object> templates = getAsMap("/_template/my-template");  
            equalTo(  
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("*");  
            indices[i] = index;
            execute(new DeleteIndexTemplateRequest("template-*"), client.indices()::deleteTemplate, client.indices()::deleteTemplateAsync)
        createIndex(index, Settings.EMPTY);
            assertEquals("2", XContentMapValues.extractValue(indexName + ".settings.index.number_of_replicas", getIndexResponse));  
        GetSettingsResponse getSettingsResponse = execute(
            assertTrue(createIndexResponse.isAcknowledged());
            );
            OpenSearchException.class,
        );
        assertThat(putTemplateResponse.isAcknowledged(), equalTo(true));
        assertTrue(response.isAcknowledged());
        AnalyzeResponse detailsResponse = execute(detailsRequest, client.indices()::analyze, client.indices()::analyzeAsync);  
            createIndex(indexName, Settings.EMPTY);
            expectWarningsOnce("Deprecated field [template] used, replaced by [index_patterns]")
        String templateName = "my-template";
        assertFalse(indexExists(nonExistentIndex));
        assertNull(getSettingsResponse.getSetting(indexName, "index.refresh_interval"));  
                .field("template", "name-*")
                highLevelClient().indices()::rolloverAsync  
            () -> execute(putTemplateRequest, highLevelClient().indices()::putTemplate, highLevelClient().indices()::putTemplateAsync)
        ResizeResponse resizeResponse = execute(
                highLevelClient().indices()::getAlias,
        createIndex(index, Settings.EMPTY);
        IndexTemplateMetadata template2 = getTemplate2.getIndexTemplates().get(0);
            assertTrue(execute(bothRequest, client.indices()::existsTemplate, client.indices()::existsTemplateAsync));
        {
            assertThat(getAliasesResponse.getException(), nullValue());
        Template template = new Template(settings, mappings, Map.of("alias", alias));  
        GetIndexTemplatesResponse getTemplate2 = execute(
        String index = "index";
    }
        assertEquals(1, getSettingsResponse.getIndexToSettings().get("get_settings_index").size());
    public void testSimulateIndexTemplate() throws Exception {
                    client.indices()::deleteTemplate,
        {
                + "  \"play_name\": \"Henry IV\","
        }
            String nonExistentIndex = "oranges";  
                    new GetIndexTemplatesRequest("template-*"),  
            new HashMap<>(),
            assertFalse(rolloverResponse.isDryRun());  
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;  
        mappingBuilder.startObject().startObject("properties").startObject("field");  
            OpenSearchStatusException.class,
import org.opensearch.common.xcontent.support.XContentMapValues;
        assertThat(putTemplateResponse.isAcknowledged(), equalTo(true));
        assertThat(extractValue("my-template.settings.index.number_of_replicas", templates), equalTo("0"));  
import org.opensearch.action.admin.indices.shrink.ResizeType;
        Request postDoc = new Request(HttpPost.METHOD_NAME, "/" + index + "/_doc");  
            highLevelClient().indices()::getSettingsAsync  
        OpenSearchStatusException statusException = expectThrows(
        );
        createIndex(index, Settings.EMPTY);  
import org.opensearch.core.rest.RestStatus;
        assertTrue(
        IndicesAliasesRequest aliasesAddRemoveRequest = new IndicesAliasesRequest();
        assertThat(extractValue("my-template.settings.index.number_of_replicas", templates), equalTo("0"));
    }
        assertEquals("2", indexSettings.get("number_of_shards"));
        OpenIndexRequest strictOpenIndexRequest = new OpenIndexRequest(nonExistentIndex);  
        DeleteComposableIndexTemplateRequest deleteComposableIndexTemplateRequest = new DeleteComposableIndexTemplateRequest(templateName);  
        }
            ForceMergeResponse forceMergeResponse = execute(
            String index = "index-" + i;  
            assertTrue(rolloverResponse.isRolledOver());
import org.opensearch.client.indices.GetFieldMappingsRequest;  
            updateSettingsRequest.settings(settings);
        assertThat(aliasExists(alias), equalTo(false));  
        assertTrue(response.isAcknowledged());
    @SuppressWarnings({ "unchecked", "rawtypes" })  
                .getIndexTemplates()
        createIndex(indexName, basicSettings);  
                OpenSearchException.class,  
        String alias = "alias";
        OpenSearchException exception = expectThrows(
                highLevelClient().indices()::deleteAsync
            openIndexRequest,  
        {
    @SuppressWarnings("unchecked")
            .mapping("{ \"properties\": { \"host_name\": { \"type\": \"keyword\" } } }", MediaTypeRegistry.JSON)
        closeIndexResponse.getIndices().forEach(indexResult -> {  
            exception.getMessage(),  
            highLevelClient().indices()::getIndexTemplate,
            .create(true)
        assertEquals("2", indexSettings.get("number_of_shards"));
            highLevelClient().indices()::putMapping,
        assertThat(o, instanceOf(Map.class));
            .indexTemplate(indexTemplate);
        assertThat(aliasExists(index, alias), equalTo(false));
    public void testPutTemplate() throws Exception {  
            assertThat(indexResult.getIndex(), startsWith("index-"));
        String nonExistentIndex = "index_that_doesnt_exist";  
        String indexName1 = "get_multiple_settings_one";  
                highLevelClient().indices()::getAlias,
            AliasMetadata aliasMetadata2 = getAliasesResponse.getAliases().get("index2").iterator().next();
        ValidateQueryRequest request = new ValidateQueryRequest(index).query(builder);
            .alias(new Alias("{index}-write").searchRouting("xyz"));
        {
        {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(template2.settings().get("index.number_of_shards"), equalTo("2"));  
            getSettingsRequest,
            ValidationException.class,
            );  
            highLevelClient().indices()::updateAliasesAsync  
        CloseIndexResponse closeIndexResponse = execute(  
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
        Map<String, Object> getIndexResponse = getAsMap(indexName);  
            rolloverRequest.addMaxIndexSizeCondition(new ByteSizeValue(1, ByteSizeUnit.MB));
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index);
    @SuppressWarnings("unchecked")
        assertThat(((Map<String, Object>) o).get("field-1"), instanceOf(Map.class));
        assertThat(dataStream.getIndices(), hasSize(1));  
        assertThat(dataStreamsStats.size(), equalTo(1));
                highLevelClient().indices()::putSettings,
        AliasMetadata alias = AliasMetadata.builder("alias").writeIndex(true).build();
            assertFalse(conditionStatus.get("[max_size: 1mb]"));
        );
        String indexName = "get_settings_index";
        response = execute(deleteDataStreamRequest, indices::deleteDataStream, indices::deleteDataStreamAsync);
        Settings targetSettings = Settings.builder().put("index.number_of_shards", 4).put("index.number_of_replicas", 0).build();
        RestHighLevelClient client = highLevelClient();
            startsWith(
            );  
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");  
            highLevelClient().indices()::shrinkAsync
            () -> execute(openIndexRequest, highLevelClient().indices()::open, highLevelClient().indices()::openAsync)
        exist = execute(
        }
        {
        ByteSizeValue byteSizeValue = dataStreamsStatsResponse.getTotalStoreSize();  
        XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
                () -> execute(  
            highLevelClient().indices()::putIndexTemplate,
 * SPDX-License-Identifier: Apache-2.0
            template,
        assertTrue(resizeResponse.isAcknowledged());  
        Map<String, Object> indexSettings = (Map<String, Object>) XContentMapValues.extractValue("target.settings.index", getIndexResponse);  
        Template template = new Template(settings, mappings, Collections.singletonMap("alias", alias));  
            OpenSearchException.class,  
            );  
        );  
            startsWith(
            () -> execute(goodTemplate, client.indices()::putTemplate, client.indices()::putTemplateAsync)  
    }
        assertThat(templates.keySet(), hasSize(1));
        assertThat(aliasExists(alias), equalTo(false));
            arrayContainingInAnyOrder("template-1", "template-2")  
    public void testValidateQuery() throws IOException {
            assertThat(aliasMetadata2, notNullValue());  
            XContentBuilder mappingBuilder = JsonXContent.contentBuilder();
import java.util.Arrays;  
            assertTrue(conditionStatus.get("[max_docs: 1]"));
import java.util.List;  
        createIndex(indexName, basicSettings);
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();  
            highLevelClient().indices()::putMappingAsync
                highLevelClient().indices()::updateAliasesAsync
            assertThat(indexResult.hasFailures(), is(false));
        Map<String, Object> term = (Map<String, Object>) filter.get("term");
                + "}"
        {
                OpenSearchException.class,
        );
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));  
    }  
        assertTrue(resizeResponse.isAcknowledged());  
        );
                .put("index.number_of_shards", 2)
        }
            assertEquals(RestStatus.NOT_FOUND, exception.status());
 * Licensed to Elasticsearch under one or more contributor  
            highLevelClient().indices()::getMapping,
    }  
        );
    }  
            dataStreamsStatsRequest,
        }  
        RestHighLevelClient client = highLevelClient();
    }
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));  
                getAliasesRequest,  
        }
        assertEquals("0", getIndexResponse.getSetting(indexName, SETTING_NUMBER_OF_REPLICAS));
 * this work for additional information regarding copyright
        assertFalse(indexExists(nonExistentIndex));
    public void testGetAlias() throws IOException {
        );
                () -> execute(
                () -> execute(  
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
    public void testForceMerge() throws IOException {
            )
            assertThat(aliasMetadata2, notNullValue());
        assertFalse(exist);
                highLevelClient().indices()::updateAliases,  
                getComposableIndexTemplateRequest,
            GetAliasesResponse getAliasesResponse = execute(  
                    new DeleteIndexTemplateRequest("template-1"),
            String index = "index";
            );
        UpdateSettingsRequest indexUpdateSettingsRequest = new UpdateSettingsRequest(index);
                () -> execute(deleteIndexRequest, highLevelClient().indices()::delete, highLevelClient().indices()::deleteAsync)
        assertThat(aliasExists(index, alias), equalTo(false));  
            is(notNullValue())
                    client.indices()::getIndexTemplate,  
            () -> execute(  
            assertThat(refreshResponse.getSuccessfulShards(), equalTo(1));
        DataStreamsStatsRequest dataStreamsStatsRequest = new DataStreamsStatsRequest();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));  
            Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();  
            highLevelClient().indices()::simulateIndexTemplate,
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index).aliases(alias, "non_existent_alias");
import org.opensearch.client.indices.GetComposableIndexTemplatesResponse;  
            assertFalse(response);
            highLevelClient().indices()::getSettings,  
                highLevelClient().indices()::rolloverAsync
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
            GetAliasesResponse getAliasesResponse = execute(
        OpenSearchException exception = expectThrows(  
        );
        assertNotNull(indexSettings);
        assertThat(extractValue("my-template.order", templates), equalTo(10));  
    public void testGetFieldMapping() throws IOException {  
            GetAliasesResponse getAliasesResponse = execute(  
        // New API returns a MappingMetadata class rather than CompressedXContent for the mapping
            OpenSearchException exception = expectThrows(  
            assertThat(getAliasesResponse.getAliases().get("index1").size(), equalTo(1));
        DataStream dataStream = dataStreams.get(0);
            highLevelClient().indices()::existsIndexTemplate,
            createIndex("index1", Settings.EMPTY);
            lenientOpenIndexRequest,  
        );
            highLevelClient().indices()::putSettingsAsync
            new BytesArray("{\"field\":{\"type\":\"text\"}}")
                highLevelClient().indices()::getAlias,  
                )
        );
    }
        Map<String, Object> expected = new HashMap<>();
        );
            highLevelClient().indices()::getSettings,
        assertThat(aliasExists(alias), equalTo(true));
        assertThat(dataStream.getTimeStampField(), equalTo("@timestamp"));
            mappingBuilder.field("type", "text");  
        );  
 * the Apache License, Version 2.0 (the "License"); you may
            () -> execute(getIndexRequest, highLevelClient().indices()::get, highLevelClient().indices()::getAsync)  
        assertFalse(indexExists(nonExistentIndex));  
                highLevelClient().indices()::getAlias,  
        {
import org.opensearch.client.indices.GetIndexTemplatesRequest;
            equalTo(true)
        OpenIndexRequest lenientOpenIndexRequest = new OpenIndexRequest(nonExistentIndex);  
    }  
            assertThat(
        String nonExistentIndex = "non_existent_index";
        assertEquals("text", XContentMapValues.extractValue(indexName + ".mappings.properties.field.type", getIndexResponse));
        AcknowledgedResponse response = execute(
        ValidateQueryResponse response = execute(
            assertThat(getAliasesResponse.getAliases().size(), equalTo(2));
            highLevelClient().indices()::getAsync
    }  
            highLevelClient().indices()::updateAliasesAsync
            createIndex(index, settings);
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
            getSettingsRequest,
        {
                highLevelClient().indices()::getAlias,  
        ComposableIndexTemplate indexTemplate = new ComposableIndexTemplate(
            assertFalse(rolloverResponse.isDryRun());
        GetSettingsResponse getSettingsResponse = execute(
                () -> execute(
            getSettingsRequest,
        );  
        assertEquals("integer", fieldMapping.get("type"));
 *    http://www.apache.org/licenses/LICENSE-2.0
                highLevelClient().indices()::getAliasAsync
            assertThat(forceMergeResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));
            alias.filter("{\"term\":{\"year\":2016}}");
            () -> execute(getSettingsRequest, highLevelClient().indices()::getSettings, highLevelClient().indices()::getSettingsAsync)  
        }
            assertTrue(response);  
                )
import org.opensearch.client.indices.CloseIndexRequest;
import static org.hamcrest.Matchers.contains;
        AcknowledgedResponse aliasesAddResponse = execute(
            () -> execute(
        }  
        simulateIndexTemplateRequest.indexTemplateV2Request(newIndexTemplateReq);
                assertTrue(execute(existsRequest, client.indices()::existsTemplate, client.indices()::existsTemplateAsync));  
        assertTrue(template2.aliases().isEmpty());
        assertThat(exception.getMetadata("opensearch.index"), not(hasItem(index)));
            request,  
        postDoc.setJsonEntity(
                deleteIndexRequest,
        );
                .field("number_of_shards", 3)
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();  
            assertFalse(execute(neitherRequest, client.indices()::existsTemplate, client.indices()::existsTemplateAsync));
            assertFalse(indexExists(indexName));  
        }  
        org.opensearch.client.ValidationException exception = expectThrows(
package org.opensearch.client;
    }  
        {
                .isAcknowledged()
            getSettingsResponse.getIndexToDefaultSettings().get("get_settings_index").getAsTime("index.refresh_interval", null)
            expectThrows(
                .endObject()
        );  
                    + "  \"my_doc_type\": {"
            Settings.Builder settings = Settings.builder();  
                createIndexRequest,
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName).includeDefaults(true);  
        createIndex("index", Settings.EMPTY);
        {
            Collections.emptyList(),
            highLevelClient().indices()::existsIndexTemplateAsync
            .must(QueryBuilders.queryStringQuery("*:*"))
        aliasesAddRemoveRequest.addAliasAction(removeAction);  
        assertThat(exception.getMessage(), equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]"));
            settings.put(SETTING_CREATION_DATE, 1234567890L);
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices(index, "non_existent_index").aliases(alias);  
            .settings(Settings.builder().put("number_of_shards", "3").put("number_of_replicas", "0"))
            AliasMetadata aliasMetadata1 = getAliasesResponse.getAliases().get("index1").iterator().next();
            highLevelClient().indices()::putSettings,  
            assertThat(getAliasesResponse.getAliases().get("index2").size(), equalTo(1));  
            .create(true)  
            );  
            );  
    public void testFlush() throws IOException {  
            highLevelClient().indices()::getFieldMappingAsync
        assertThat(extractValue("my-template.order", templates), equalTo(10));
        // without the refresh the rollover may not happen as the number of docs seen may be off  
            aliasesAddRemoveRequest,
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName).includeDefaults(true);  
            String index = "index";
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
    public void testCloseEmptyOrNullIndex() {
        assertEquals(
            aliases.get("simulation-alias"),
        removeIndexRequest.addAliasAction(new AliasActions(AliasActions.Type.ADD).index(nonExistentIndex).alias(alias));  
            assertThat(refreshResponse.getFailedShards(), equalTo(0));  
        String indexName = "get_index_test";
        assertTrue(openIndexResponse.isAcknowledged());
        );  
        assertNotNull(getSettingsResponse.getSetting(indexName, "index.creation_date"));
        assertTrue(execute(getAliasesRequest2, highLevelClient().indices()::existsAlias, highLevelClient().indices()::existsAliasAsync));  
    }  
            createIndexRequest.mapping(mappingBuilder);
                    + "reason=Can't update non dynamic settings [[index.shard.check_on_startup]] for open indices [[index/"
        AliasActions removeIndexAction = new AliasActions(AliasActions.Type.REMOVE_INDEX).index(index);
            AliasMetadata aliasMetadata = getAliasesResponse.getAliases().get(index).iterator().next();
            assertEquals(2016, term.get("year"));
                highLevelClient().indices()::getAliasAsync  
    }  
                    + "    \"properties\": {"  
        Map<String, Object> getIndexResponse = getAsMap(indexName);
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));
        createIndex(indexName, basicSettings);
        }
            Settings.builder()  
        {
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().aliases("alias*");  
            () -> execute(  
        response = execute(staticSettingRequest, highLevelClient().indices()::putSettings, highLevelClient().indices()::putSettingsAsync);  
            .settings(Settings.builder().put("number_of_shards", "3").put("number_of_replicas", "0"))  
        }
            1L,
        assertNotNull(aliasData);
            .create(true)  
            assertThat(forceMergeResponse.getSuccessfulShards(), equalTo(1));
            getIndexResponse.getDefaultSettings().get(indexName).getAsTime("index.refresh_interval", null)
        );
            assertFalse(indexExists(indexName));
        );  
                    + "      }"  
import java.util.stream.Collectors;
            OpenSearchException.class,  
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(nonExistentIndex);  
        {
            Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();  
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
        );
            org.opensearch.client.ValidationException.class,
            Collections.singletonList(dataStreamName),  
            1L,
import org.opensearch.client.indices.rollover.RolloverResponse;
    @SuppressWarnings("unchecked")
        }
    }  
            AcknowledgedResponse deleteIndexResponse = execute(
                highLevelClient().indices()::getAliasAsync
        assertThat(response.isAcknowledged(), equalTo(true));
        assertThat(extractValue("my-template.settings.index.number_of_shards", templates), equalTo("3"));
            client.indices()::getIndexTemplate,
        createIndex(
        // Failed to validate because index patterns are missing
        IndicesAliasesRequest nonExistentIndexRequest = new IndicesAliasesRequest();  
        ValidateQueryResponse response = execute(  
            IndexSettings.DEFAULT_REFRESH_INTERVAL,  
        assertEquals("3", getSettingsResponse.getSetting(indexName2, "index.number_of_shards"));
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest().indices("ind*");
            alias.routing("1");  
            highLevelClient().indices()::getSettings,
            assertThat(getAliasesResponse.getAliases().get("index3").size(), equalTo(0));
            new GetIndexTemplatesRequest("template-1"),
    }
            assertThat(aliasMetadata2, notNullValue());
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = new PutComposableIndexTemplateRequest().name(templateName)
        AcknowledgedResponse aliasResponse = execute(
        assertThat(  
        assertTrue(response.isValid());
                createIndexRequest,
        assertThat(getResponse.getIndexTemplates().containsKey(templateName), equalTo(true));  
        final Setting<Integer> dynamicSetting = IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
            GetIndexRequest request = new GetIndexRequest(indexName);  
        {
        updateIndexSettings(
            containsString("[type=illegal_argument_exception, reason=index_template [t2] already exists]")
            equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")  
            String indexName = "rich_index";
 * this file be licensed under the Apache-2.0 license or a
            () -> client().performRequest(new Request(HttpGet.METHOD_NAME, "/" + index + "/_search"))
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));  
            .order(10)  
            getIndexRequest,
            assertThat(getAliasesResponse.getAliases().size(), equalTo(0));
        if (randomBoolean()) {  
        );
        assertThat(
        getDataStreamResponse = execute(getDataStreamRequest, indices::getDataStream, indices::getDataStreamAsync);
    public void testGetSettings() throws IOException {
                highLevelClient().indices()::createAsync
            assertThat(exception.getMessage().contains(indexResult.getIndex()), equalTo(true));  
            new HashMap<>(),
        PutMappingRequest putMappingRequest = new PutMappingRequest(indexName);
            );
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;  
            pattern,  
        assertThat(mappings, equalTo(expected));  
            highLevelClient().indices()::existsIndexTemplate,  
            assertTrue(deleteIndexResponse.isAcknowledged());  
            boolean response = execute(request, highLevelClient().indices()::exists, highLevelClient().indices()::existsAsync);  
        strictOpenIndexRequest.indicesOptions(IndicesOptions.strictExpandOpen());
        OpenSearchException exception = expectThrows(
        final String dynamicSettingKey = IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import org.opensearch.action.support.broadcast.BroadcastResponse;  
            Collections.emptyList(),
            highLevelClient().indices()::putIndexTemplateAsync  
            createIndex(indexName, Settings.EMPTY);  
            Collections.emptyList(),  
            );
            assertThat(aliasMetadata1, notNullValue());
        );
        );
        }
            assertThat(aliasMetadata2.alias(), equalTo("alias2"));  
        closeIndex(index);
                () -> execute(flushRequest, highLevelClient().indices()::flush, highLevelClient().indices()::flushAsync)
            assertThat(clearCacheResponse.getShardFailures(), equalTo(BroadcastResponse.EMPTY));  
 * under the License.  
                highLevelClient().indices()::getAlias,
        SimulateIndexTemplateResponse simulateResponse = execute(  
            client.indices()::getIndexTemplate,
import org.opensearch.client.indices.ComposableIndexTemplateExistRequest;  
            assertTrue(  
            execute(new GetIndexTemplatesRequest("template-*"), client.indices()::getIndexTemplate, client.indices()::getIndexTemplateAsync)  
        assertEquals("2", getSettingsResponse.getSetting(indexName1, "index.number_of_shards"));
                highLevelClient().indices()::rollover,
import java.util.HashMap;
        Map<String, Object> field = new HashMap<>();
            GetAliasesResponse getAliasesResponse = execute(
        );  
            IndexSettings.DEFAULT_REFRESH_INTERVAL,  
                .startObject()  
        Map<String, Object> aliasData = (Map<String, Object>) XContentMapValues.extractValue("target.aliases.alias", getIndexResponse);
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
            highLevelClient().indices()::deleteIndexTemplate,  
    public void testGetMapping() throws IOException {  
            2L,
import org.opensearch.index.query.QueryBuilder;
        final String unmodifiableSettingKey = IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            highLevelClient().indices()::simulateIndexTemplateAsync  
            equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
        assertThat(noindexResponse.getTokens(), hasSize(3));  
                )  
        assertThat(response.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));
        createIndex(index, Settings.EMPTY);  
                + "  \"speaker\": \"\","
    }  
        assertThat(exception.getMetadata("opensearch.index"), not(hasItem(index)));  
            () -> execute(closeIndexRequest, highLevelClient().indices()::close, highLevelClient().indices()::closeAsync)
        String indexName = "test";
    }  
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
        }  
        );  
        Map<String, String> type = new HashMap<>();  
import static org.hamcrest.Matchers.not;
            new GetIndexTemplatesRequest("template-2"),  
        mappingBuilder.endObject().endObject().endObject();
        IndicesAliasesRequest aliasesAddRequest = new IndicesAliasesRequest();
    public void testClearCache() throws IOException {
    }
        assertThat(extractValue("my-template.mappings.properties.host_name.type", templates), equalTo("keyword"));
                highLevelClient().indices()::refreshAsync
            assertFalse(indexExists(nonExistentIndex));  
        DeleteAliasRequest request = new DeleteAliasRequest(index, alias);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    + "      \"host_name\": {"
        assertEquals(1, getSettingsResponse.getIndexToDefaultSettings().get("get_settings_index").size());
            assertThat(forceMergeResponse.getTotalShards(), equalTo(1));
    public void testIndexTemplates() throws Exception {
        }  
        );  
        IndexTemplateMetadata template1 = getTemplate1.getIndexTemplates().get(0);  
        AnalyzeResponse noindexResponse = execute(noindexRequest, client.indices()::analyze, client.indices()::analyzeAsync);
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indexName).names("index.number_of_shards");
            highLevelClient().indices()::updateAliases,  
import org.opensearch.core.common.unit.ByteSizeUnit;
import static org.hamcrest.Matchers.hasItems;
            putComposableIndexTemplateRequest,  
                    + "or check the breaking changes documentation for removed settings]"  
                () -> execute(clearCacheRequest, highLevelClient().indices()::clearCache, highLevelClient().indices()::clearCacheAsync)
        getDataStreamRequest = new GetDataStreamRequest(dataStreamName);
            );
            OpenSearchStatusException.class,
                OpenSearchException.class,
            assertEquals(RestStatus.NOT_FOUND, exception.status());  
        createIndex(index, Settings.EMPTY);
            assertThat(aliasMetadata1.alias(), equalTo("alias1"));
            null
                getAliasesRequest,
        assertThat((Map<String, String>) extractValue("my-template.aliases.{index}-write", templates), hasEntry("search_routing", "xyz"));  
            () -> execute(staticSettingRequest, highLevelClient().indices()::putSettings, highLevelClient().indices()::putSettingsAsync)
        );
        resizeRequest.setResizeType(ResizeType.SPLIT);  
        // Create-only specified but an template exists already  
        String firstNode = ((Map<String, Object>) nodes.get("nodes")).keySet().iterator().next();
            .alias(new Alias("{index}-write").searchRouting("xyz"));
            1L,  
            is("pattern")
            indices::dataStreamsStats,
            GetAliasesResponse getAliasesResponse = execute(
         */  
        assertTrue(closeIndexResponse.isShardsAcknowledged());  
        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"host_name\":{\"type\":\"keyword\"}}}");
        assertNotNull(getIndexResponse.getSetting(indexName, "index.refresh_interval"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        }
        lenientOpenIndexRequest.indicesOptions(IndicesOptions.lenientExpandOpen());
        createIndex(indexName2, Settings.builder().put("number_of_shards", 3).build());
            expectThrows(  
import org.opensearch.action.admin.indices.shrink.ResizeRequest;  
        {
        assertTrue(resizeResponse.isShardsAcknowledged());
        assertThat(aliasExists(index, alias), equalTo(true));
    }  
            highLevelClient().indices()::getSettings,  
