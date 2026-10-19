                    }
            GetAliasesRequest requestWithAlias = new GetAliasesRequest("alias1");
            // end::clear-cache-execute
                    new ActionListener<AcknowledgedResponse>() {
                Settings.builder()  
        // tag::rollover-index-request-dryRun  
                .build("<b>Some text to analyze</b>");  
                @Override
            {
                    new AliasActions(AliasActions.Type.REMOVE_INDEX)
            // tag::refresh-execute-listener  
            // tag::delete-index-response
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
            }  
                }
                    // <1>
        {
            assertTrue(createIndexResponse.isAcknowledged());  
        }
        // end::simulate-index-template-execute-async
            DetailAnalyzeResponse detail = response.detail();                   // <1>  
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                        }  
                public void onResponse(ValidateQueryResponse validateQueryResponse) {  
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
        }
                }""",
        {
        // tag::rollover-index-response
            // end::delete-alias-request-timeout  
            // tag::delete-index-request-indicesOptions  
            // end::open-index-request-indicesOptions
                type.put("type", "text");  
        request.getCreateIndexRequest().waitForActiveShards(ActiveShardCount.DEFAULT); // <2>
            // end::force-merge-request
            // end::analyze-index-normalizer-request
                @Override
        // tag::shrink-index-request
            // tag::put-mapping-response
        // end::get-settings-request-names  
        RestHighLevelClient client = highLevelClient();
                @Override  
                null,
                            "properties" : {
            assertTrue(createIndexResponse.isAcknowledged());  
            // end::force-merge-request-indicesOptions  
        }  
    public void testGetSettings() throws Exception {
                .name("my-template");
            // tag::put-index-template-v2-request-mappings-json
        // tag::delete-template-request
import org.opensearch.client.indices.SimulateIndexTemplateRequest;  
            AliasMetadata twitterAlias = AliasMetadata.builder("twitter_alias").build(); // <1>
        // tag::get-settings-request-indicesOptions
            final CountDownLatch latch = new CountDownLatch(1);
            updateIndexSettings("source_index", Settings.builder().put("index.blocks.write", true));  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            ); // <2>
                    new ActionListener<OpenIndexResponse>() {
            Template template = new Template(settings, null, null); // <2>  
              }
            // tag::create-index-execute  
                client.indices().deleteAlias(request, RequestOptions.DEFAULT);
        // tag::get-settings-execute-listener  
            @Override
                }
        // tag::put-template-execute
            // end::create-index-request-masterTimeout
                    builder.startObject("properties");
            // end::put-index-template-v2-request-component-template  
        {
            RefreshResponse refreshResponse = client.indices().refresh(request, RequestOptions.DEFAULT);
            // tag::indices-exists-execute-async
        {
                XContentBuilder builder = XContentFactory.jsonBuilder();
            ActionListener<GetFieldMappingsResponse> listener =  
            // tag::indices-exists-execute-listener
import org.opensearch.client.indices.DetailAnalyzeResponse;
            // end::get-alias-execute-listener
        request.timeout("2m"); // <2>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);  
            // tag::open-index-notfound
                // <1>  
        assertEquals(Integer.valueOf(3), numberOfShards);  
                    properties.put("message", message);
        {
            // tag::indices-put-settings-settings-map
                @Override  
                    """  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            client.indices().forcemergeAsync(request, RequestOptions.DEFAULT, listener); // <1>
    }
            DefaultShardOperationFailedException[] failures = flushResponse.getShardFailures(); // <4>
            // end::create-index-request-aliases  
        request.settings(Settings.builder() // <1>  
 * Modifications Copyright OpenSearch Contributors. See
                                "message" : { "type" : "text" }  
        assertEquals(Integer.valueOf(3), numberOfShards);
            @Override
        client.indices().getSettingsAsync(request, RequestOptions.DEFAULT, listener);
                      "properties": {
            // end::get-alias-request-indices
            Map<String, Set<AliasMetadata>> aliases = response.getAliases(); // <1>
            request.create(true);  // <1>  
                public void onFailure(Exception e) {
            request.indexTemplate(composableIndexTemplate);  
            assertTrue(createIndexResponse.isAcknowledged());
                    """  
                .addCharFilter("html_strip")    // <3>  
        {
            assertTrue(client.indices().putTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
                .putComponentTemplate(
        {  
                @Override
        int settingValue = 0;
            // end::put-index-template-v2-request-mappings-json  
            {  
            int totalShards = forceMergeResponse.getTotalShards(); // <1>
        assertThat(templates, hasSize(1));  
    @SuppressWarnings("unused")
        // tag::get-index-execute
                .put("index.number_of_shards", 3)  
            // tag::open-index-request-masterTimeout
        AcknowledgedResponse putTemplateResponse = client.indices().putTemplate(request, RequestOptions.DEFAULT);  
        final CountDownLatch latch = new CountDownLatch(1);
            // end::get-alias-request-indicesOptions
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        request.settings(settings);
            final CountDownLatch latch = new CountDownLatch(1);  
            // end::get-alias-execute
                .put("index.number_of_replicas", 1)
        final RestHighLevelClient client = highLevelClient();
            request.source("""
            assertTrue(putMappingResponse.isAcknowledged());
            // end::indices-exists-execute  
        // Replace the empty listener by a blocking listener in test
        // end::shrink-index-execute-async
                //tag::put-mapping-xcontent
            // Replace the empty listener by a blocking listener in test
                public void onFailure(Exception e) {  
            // tag::close-index-execute-async
            final CountDownLatch latch = new CountDownLatch(1);
            IndexTemplatesExistRequest request;
                @Override
        final RestHighLevelClient client = highLevelClient();
            listener = new LatchedActionListener<>(listener, latch);
    @SuppressWarnings("unused")
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
        {
    @SuppressWarnings("unused")  
    }
                //tag::create-index-mappings-xcontent  
            // end::open-index-request
            // tag::refresh-execute-async  
                message.put("type", "text");  
            }
            final GetFieldMappingsResponse.FieldMappingMetadata metadata =
        assertThat(templates.get(0).name(), equalTo("my-template"));
            client.indices().getMappingAsync(request, RequestOptions.DEFAULT, listener); // <1>
                .name("my-template"); // <1>
                };
            // end::delete-index-execute-async  
        }  
                    public void onFailure(Exception e) {  
                    @Override  
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
        client.indices().deleteIndexTemplateAsync(deleteRequest, RequestOptions.DEFAULT, listener); // <1>
            updateIndexSettings(
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            assertTrue(exists);
                    .put("index.number_of_routing_shards", 4)  
import static org.hamcrest.Matchers.notNullValue;
                fieldMappings.get("message");// <3>  
            // tag::close-index-response  
            }
                // end::put-mapping-request-source  
                            "number_of_shards" : 1,
        }  
            ); // <2>
                builder.endObject();
            @Override
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
        }
                    new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"), null,
                }
                @Override
                request = new CreateIndexRequest("twitter3");
                    {
        RestHighLevelClient client = highLevelClient();
                @Override
        {  
                    // <1>
                @Override
            // end::exists-alias-request-indicesOptions
            // tag::put-index-template-v2-request-create
                }
        request.query(builder); // <2>  
        // end::clone-index-request-timeout
              "mappings": {
        RestHighLevelClient client = highLevelClient();  
    public void testGetIndex() throws Exception {
            // tag::refresh-notfound
            ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("index1"); // <1>
            assertTrue(createIndexResponse.isAcknowledged());
                request = new CreateIndexRequest("twitter2");  
            listener = ActionListener.wrap(r -> {  
        {
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
            //tag::put-template-request-mappings-map
            DefaultShardOperationFailedException[] failures = refreshResponse.getShardFailures(); // <4>  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));  
            @Override
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
import java.util.HashMap;  
        {
                public void onFailure(Exception e) {
        }  
        RestHighLevelClient client = highLevelClient();  
                "my_index",         // <1>
        assertEquals("index-1", oldIndex);
        RestHighLevelClient client = highLevelClient();
        GetSettingsResponse getSettingsResponse = client.indices().getSettings(request, RequestOptions.DEFAULT);
                }  
        // tag::indices-validate-query-execute-async  
        request.setClusterManagerNodeTimeout("1m"); // <2>
            request.mapping(// <1>
                public void onResponse(AcknowledgedResponse response) {
            CreateIndexResponse createIndexResponse = client.indices()
        {  
            try {  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                        {
                @Override  
        {
            final CountDownLatch latch = new CountDownLatch(1);
                properties.put("message", message);
/*  
        boolean acknowledged = deleteTemplateAcknowledge.isAcknowledged(); // <1>
            request.indexTemplate(composableIndexTemplate);  
            // end::get-alias-response
                }
            // tag::update-aliases-response
            // tag::delete-alias-request-masterTimeout
                    .alias("alias1"); // <2>
            boolean acknowledged = createIndexResponse.isAcknowledged(); // <1>
        // tag::rollover-index-execute-async
                    }
        assertThat(acknowledged, equalTo(true));  
import org.opensearch.client.RestHighLevelClient;
                .create(new CreateIndexRequest("index").alias(new Alias("alias")), RequestOptions.DEFAULT);
                    // <1>  
        boolean isRolledOver = rolloverResponse.isRolledOver(); // <5>
            boolean acknowledged = closeIndexResponse.isAcknowledged(); // <1>
import org.opensearch.client.indices.IndexTemplateMetadata;  
                    "message": {
            // end::refresh-request
            // end::update-aliases-response  
        };
            ActionListener<AcknowledgedResponse> listener =
            // tag::delete-index-execute-async
            request.addAliasAction(aliasAction);  
            request.includeDefaults(false); // <3>  
            // tag::put-index-template-v2-request-component-template  
        }
            // tag::analyze-execute
            };  
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;  
        {
            }  
        {  
            assertTrue(createIndexResponse.isAcknowledged());
        RestHighLevelClient client = highLevelClient();
        client.indices().putSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>  
            // tag::analyze-builtin-request  
            // end::refresh-request-indicesOptions
        // tag::put-template-request-order  
                // tag::put-mapping-request-source
        // tag::split-index-request-aliases  
import org.opensearch.core.xcontent.XContentBuilder;
            request.maxNumSegments(1); // <1>  
        Settings indexSettings = getSettingsResponse.getIndexToSettings().get("index"); // <2>  
        RestHighLevelClient client = highLevelClient();  
            public void onResponse(RolloverResponse rolloverResponse) {
            {
                    .index("index4"); // <4>
 * <p>
        // end::get-field-mappings-request-local
                };  
                    }
            // tag::analyze-response-tokens
            request.indicesOptions(indicesOptions); // <4>
            updateIndexSettings("source_index", Settings.builder().put("index.blocks.write", true));  
import org.opensearch.client.indices.GetMappingsResponse;
                        "aliases" : {  
 * this file be licensed under the Apache-2.0 license or a
            request.addAliasAction(aliasAction);
            };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
        AcknowledgedResponse updateSettingsResponse =  
        UpdateSettingsRequest requestMultiple =  
        // end::rollover-index-request-alias
        {
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        RolloverRequest request = new RolloverRequest("alias", "index-2"); // <1>  
        {
        // tag::get-field-mappings-request
            listener = new LatchedActionListener<>(listener, latch);
            GetAliasesRequest requestWithAlias = new GetAliasesRequest("alias1");  
            Map<String, Object> map = new HashMap<>();  
        );  
            }
        }
            assertTrue(createIndexResponse.isAcknowledged());
            // end::force-merge-request-segments-num
            // end::exists-alias-request
        }  
                    // <2>  
                }
        client.indices().getIndexTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
                //tag::create-index-mappings-map
            boolean acknowledged = deleteAliasResponse.isAcknowledged(); // <1>
            // tag::delete-index-notfound  
            }
        // tag::shrink-index-request-settings  
            // end::get-field-mappings-execute-listener  
    public void testCreateIndex() throws IOException {  
            // end::refresh-execute-async
            // tag::update-aliases-request-masterTimeout  
            // end::clear-cache-request-fielddata  
import org.opensearch.client.indices.AnalyzeResponse;  
                    @Override
            // tag::analyze-custom-request
    }
        boolean acknowledged = deleteTemplateAcknowledge.isAcknowledged(); // <1>
        {
    public void testRefreshIndex() throws Exception {
            request.waitForActiveShards(ActiveShardCount.from(2)); // <1>  
        }  
        String settingKey = "index.number_of_replicas";  
            // end::open-index-notfound
            };
                );
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            // tag::flush-execute-async
            // end::close-index-execute-listener
                        public void onFailure(Exception e) {
                    public void onFailure(Exception e) {
            client.indices().deleteAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;  
        // tag::get-index-templates-v2-execute-listener  
            public void onFailure(Exception e) {
            // tag::get-alias-request
        assertTrue(shardsAcked);
            // tag::clear-cache-request-query
            };
        ActionListener<ValidateQueryResponse> listener =  
        RestHighLevelClient client = highLevelClient();  
    }
            DeleteAliasRequest request = new DeleteAliasRequest("index1", "alias1");
                .put("index.number_of_shards", 4)); // <1>
            GetAliasesRequest requestWithAliases =
                }
        ActionListener<SimulateIndexTemplateResponse> listener =  
            request.indexTemplate(composableIndexTemplate);  
            new ActionListener<GetIndexResponse>() {
            // tag::templates-exist-request-optionals
    }  
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
            final Map<String, Object> source = metadata.sourceAsMap(); // <5>  
            createIndex("index1", Settings.EMPTY);  
                        }
                Map<String, Object> properties = new HashMap<>();
                    {  
        // end::shrink-index-request-masterTimeout
        String numberOfShardsString = getSettingsResponse.getSetting("index", "index.number_of_shards");
    }  
                "pattern-1"
                final Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings = r.mappings();  
            PutMappingRequest request = new PutMappingRequest("twitter");  
                @Override  
            // end::create-index-whole-source
        // tag::put-template-execute-async  
    }
                    new AliasActions(AliasActions.Type.ADD)  
            // tag::refresh-request-indicesOptions  
            final ActionListener<GetFieldMappingsResponse> latchListener = new LatchedActionListener<>(listener, latch);
                    // <1>
            final CountDownLatch latch = new CountDownLatch(1);  
        // end::get-index-templates-v2-request  
            @Override
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
        }
        Settings indexDefaultSettings = getSettingsResponse.getIndexToDefaultSettings().get("index"); // <2>
            // tag::force-merge-request-indicesOptions
        // end::split-index-execute-async
        }  
            // end::create-index-execute-listener  
        request.setWaitForActiveShards(ActiveShardCount.DEFAULT); // <2>  
            // tag::clear-cache-request-fielddata
            // end::delete-index-notfound  
            // end::force-merge-execute
                jsonMap.put("properties", properties);
            // end::flush-response  
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
            // tag::delete-index-request-masterTimeout
            // end::force-merge-execute-async  
                }  
    public void testPutMappingAsync() throws Exception {
                }
            request.fields("field1", "field2", "field3"); // <1>  
                }  
        // tag::indices-validate-query-execute  
        RestHighLevelClient client = highLevelClient();
        deleteRequest.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                // <2>  
        {
        Integer numberOfShards = indexSettings.getAsInt("index.number_of_shards", null);
        // Replace the empty listener by a blocking listener in test
        }
        // Replace the empty listener by a blocking listener in test  
        // end::get-index-request-includeDefaults  
            type.put("type", "text");
            request.indexTemplate(composableIndexTemplate);  
                      }
                public void onFailure(Exception e) {  
                client.indices().delete(request, RequestOptions.DEFAULT);  
import org.opensearch.client.RequestOptions;  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
            // tag::open-index-request  
        // Replace the empty listener by a blocking listener in test  
        );  
        // tag::simulate-index-template-execute-listener
            request.timeout("2m"); // <2>
            createIndex("index", Settings.EMPTY);  
            assertTrue(acknowledged);
            new ActionListener<GetComposableIndexTemplatesResponse>() {
        assertTrue(shardsAcked);
                    // <2>  
            // end::put-mapping-request-masterTimeout
        final CountDownLatch latch = new CountDownLatch(1);  
        // tag::get-templates-execute
                .endObject()  
            // tag::put-index-template-v2-request-settings
import org.opensearch.action.support.ActiveShardCount;
        request.clusterManagerNodeTimeout("1m"); // <2>  
        {
            };  
            // tag::indices-exists-execute
                        },
                @Override
                Arrays.asList("pattern-1", "log-*"),
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        // tag::get-index-templates-v2-request  
        }
        request.addMaxIndexSizeCondition(new ByteSizeValue(5, ByteSizeUnit.GB)); // <4>  
                AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
        // end::split-index-execute  
                    // <1>
                DeleteIndexRequest request = new DeleteIndexRequest("does_not_exist");
import java.util.Collections;
            // end::analyze-custom-normalizer-request  
 * under the License.  
        }
                client.indices().getFieldMapping(request, RequestOptions.DEFAULT);  
        final RestHighLevelClient client = highLevelClient();  
            // end::force-merge-execute-listener
            // end::clear-cache-request-indicesOptions  
        {  
        // end::rollover-index-request-dryRun
import org.opensearch.client.indices.CreateIndexResponse;
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("index").settings(settings)
            CloseIndexRequest request = new CloseIndexRequest("index"); // <1>  
            // tag::refresh-response
                    // <1>
        AcknowledgedResponse deleteTemplateAcknowledge = client.indices().deleteTemplate(request, RequestOptions.DEFAULT);  
            assertTrue(putMappingResponse.isAcknowledged());
            // tag::get-field-mappings-response  
 * compatible open source license.
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>  
                    public void onResponse(AcknowledgedResponse putIndexTemplateResponse) {
            // tag::put-index-template-v2-request-version
            listener = new LatchedActionListener<>(listener, latch);  
            request.clusterManagerNodeTimeout("1m"); // <2>
                    .index("index1")  
            );
                new ActionListener<AcknowledgedResponse>() {  
            request.aliases("alias"); // <1>
                        // <1>
        }
    }  
            RefreshRequest request = new RefreshRequest("index1"); // <1>
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            boolean acknowledged = putMappingResponse.isAcknowledged(); // <1>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("posts"), RequestOptions.DEFAULT);
        TimeValue time = getIndexResponse.getDefaultSettings().get("index")
            // Replace the empty listener by a blocking listener in test  
            // tag::force-merge-response
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
            ForceMergeRequest requestAll = new ForceMergeRequest(); // <3>
        request.clusterManagerNodeTimeout("1m"); // <2>  
            }  
        final CountDownLatch latch = new CountDownLatch(1);  
              ],
                    new AliasActions(AliasActions.Type.REMOVE)  
                    // <2>
 *  
                if (exception.status() == RestStatus.BAD_REQUEST) {
                @Override  
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("my-template"); // <1>
            Map<String, Object> nodes = getAsMap("_nodes");
 * <p>  
        // tag::rollover-index-request-masterTimeout  
        final CountDownLatch latch = new CountDownLatch(1);
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
                template, null, null, null, null); // <4>
                public void onFailure(Exception e) {
        // end::indices-validate-query-request
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>  
                    RequestOptions.DEFAULT  
            // tag::close-index-request-indicesOptions
                public void onResponse(CloseIndexResponse closeIndexResponse) {
import org.opensearch.client.indices.GetIndexTemplatesRequest;
            AliasActions addIndexAction =
            // use a built-in analyzer in the test  
        {
            boolean shardsAcked = openIndexResponse.isShardsAcknowledged(); // <2>  
                }  
        request.setWaitForActiveShards(2); // <1>
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
        // end::shrink-index-request-timeout  
        // end::clone-index-request-masterTimeout  
        // tag::shrink-index-request-timeout  
        RestHighLevelClient client = highLevelClient();
            // tag::create-index-request
            // tag::delete-alias-response
            DeleteIndexRequest request = new DeleteIndexRequest("posts"); // <1>
                              "type": "text"
import org.opensearch.core.rest.RestStatus;
                            "twitter_alias" : {}
            // tag::delete-alias-request  
            final CountDownLatch latch = new CountDownLatch(1);  
            boolean acknowledged = putTemplateResponse.isAcknowledged(); // <1>
        // end::split-index-request-timeout
                }
                {  
import org.opensearch.action.admin.indices.shrink.ResizeType;
            final CountDownLatch latch = new CountDownLatch(1);
            // end::refresh-notfound
            request.waitForActiveShards(2); // <1>
                latchListener.onResponse(r);  
            // tag::close-index-execute-listener
        assertTrue(pmResp.isAcknowledged());
import org.opensearch.client.indices.SimulateIndexTemplateResponse;
                }
                    builder.endObject();
    }
                    builder.endObject();  
        // tag::indices-validate-query-request-allShards
        // tag::get-index-templates-v2-request-masterTimeout
            request = new IndexTemplatesExistRequest("template-1", "template-2"); // <2>  
        {
        request.clusterManagerNodeTimeout("1m"); // <2>
            try {
 * not use this file except in compliance with the License.
            request.setLocal(true); // <1>
            ActionListener<GetAliasesResponse> listener =
                    @Override
            final CountDownLatch latch = new CountDownLatch(1);
                            builder.field("type", "text");  
        // end::get-field-mappings-request-indicesOptions  
            assertTrue(createIndexResponse.isAcknowledged());
            // tag::flush-request-force
            Template template = new Template(Settings.builder().put("index.number_of_replicas", 3).build(), null, null);
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                field.put("message", type);
import org.opensearch.core.common.unit.ByteSizeValue;
        assertFalse(shardsAcked);  
            listener = new LatchedActionListener<>(listener, latch);
            // tag::put-index-template-v2-response
                @Override  
                    @Override  
            // end::get-alias-request  
                };  
        };
            CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            ActionListener<AcknowledgedResponse> listener =
            DeleteAliasRequest request = new DeleteAliasRequest("index1", "alias2"); // <1>
        {  
                };
            // Replace the empty listener by a blocking listener in test  
        // end::put-template-request-order
            // end::open-index-request-masterTimeout
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());  
                .addTokenFilter("lowercase")    // <4>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);
        Settings indexSettings = getSettingsResponse.getIndexToSettings().get("index");  
        assertThat(simulateIndexTemplateResponse.overlappingTemplates().get("my-template"),
            request.source(
                    {
            // Replace the empty listener by a blocking listener in test
        // Replace the empty listener by a blocking listener in test  
                        }
    }
            listener = new LatchedActionListener<>(listener, latch);  
        // end::delete-template-execute-listener  
        assertEquals("index-2", newIndex);
        GetFieldMappingsRequest request = new GetFieldMappingsRequest(); // <1>
        // tag::indices-put-settings-response
                @Override
            // end::open-index-request-waitForActiveShards  
                assertTrue(putMappingResponse.isAcknowledged());
            client.indices().deleteAliasAsync(request, RequestOptions.DEFAULT, listener); // <1>  
import org.opensearch.client.indices.DeleteAliasRequest;
 * ownership. Elasticsearch licenses this file to you under  
                """
        // end::get-index-request
            // end::close-index-request-timeout
        // tag::get-settings-execute-async
            // tag::update-aliases-execute-async
        request.includeDefaults(true); // <1>
        assertTrue(indexAliases.isEmpty());  
        ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("log-*"),
                }
        // tag::put-template-request-masterTimeout
            AliasActions aliasAction = new AliasActions(AliasActions.Type.ADD).index("index1").alias("alias2");  
import org.opensearch.action.admin.indices.validate.query.QueryExplanation;
            // end::create-index-request-waitForActiveShards
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        String newIndex = rolloverResponse.getNewIndex(); // <4>  
            @Override  
            // end::delete-alias-execute-async
                        }
                null,
 */
            createIndex("index1", Settings.EMPTY);
        String mappings = "{\"properties\":{\"field-1\":{\"type\":\"keyword\"}}}";  
        {
        client.indices().simulateIndexTemplateAsync(simulateRequest, RequestOptions.DEFAULT, listener); // <1>  
        // end::delete-index-template-v2-response
        request.getTargetIndexRequest().alias(new Alias("target_alias")); // <1>
                mapping.put("properties", properties);
        {  
                client.indices().clearCache(request, RequestOptions.DEFAULT);
            ActionListener<ForceMergeResponse> listener = new ActionListener<ForceMergeResponse>() {  
                @Override
            request.flush(true); // <1>  
import java.util.concurrent.CountDownLatch;
        RestHighLevelClient client = highLevelClient();
            AliasActions removeIndexAction =  
        request.create(true);  // <1>
            // end::put-index-template-v2-execute-async
            request = new CreateIndexRequest("twitter6");
                .put("index.number_of_replicas", 2)
            //end::put-template-request-mappings-xcontent  
        }  
            // end::update-aliases-request
            request.waitIfOngoing(true); // <1>
                fail("should not fail");  
        PutMappingRequest pmReq = new PutMappingRequest("my_index").source(
            String firstNode = ((Map<String, Object>) nodes.get("nodes")).keySet().iterator().next();  
                    Map<String, Object> message = new HashMap<>();  
                assertTrue(putMappingResponse.isAcknowledged());
                latchListener.onFailure(e);
        assertThat(simulateIndexTemplateResponse.resolvedTemplate().settings().get("index.number_of_shards"), is("6")); // <1>  
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>
        // end::rollover-index-request-mapping
                expected.put("properties", field);
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
                "my_index",             // <1>
                client.indices().refresh(request, RequestOptions.DEFAULT);
                .create(new CreateIndexRequest("index").settings(settings), RequestOptions.DEFAULT);
            FlushResponse flushResponse = client.indices().flush(request, RequestOptions.DEFAULT);
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);  
        // end::get-settings-request-include-defaults
            // end::put-index-template-v2-request
            .put("index.number_of_shards", 2)); // <1>
    @SuppressWarnings("unused")
                    // <1>
        // end::indices-put-settings-create-settings  
            request.timeout("2m"); // <2>  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                }
            assertTrue(indicesAliasesResponse.isAcknowledged());
            // tag::force-merge-execute-async
 * Licensed to Elasticsearch under one or more contributor  
                public void onResponse(SimulateIndexTemplateResponse response) {  
            // end::clear-cache-request-query
                jsonMap.put("properties", properties);  
        assertTrue(isDryRun);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
            // end::analyze-builtin-request  
            .filter(QueryBuilders.termQuery("user", "foobar"));
        {
            // tag::force-merge-request
                  }
        // tag::delete-template-execute-async  
        RestHighLevelClient client = highLevelClient();  
                    // <1>  
            // tag::force-merge-execute-listener
            } catch (OpenSearchException exception) {
            new ActionListener<SimulateIndexTemplateResponse>() {
            putRequest.mapping("{ \"properties\": { \"message\": { \"type\": \"text\" } } }", MediaTypeRegistry.JSON);
                    // <2>
            GetAliasesRequest requestWithAliases =  
    public void testCreateIndexAsync() throws Exception {
            // tag::create-index-request-aliases
        assertEquals(IndexSettings.DEFAULT_REFRESH_INTERVAL, time);
        // end::get-settings-execute-async  
                    // <2>  
        RestHighLevelClient client = highLevelClient();
                            builder.field("type", "text");
            request.alias(new Alias("twitter_alias").filter(QueryBuilders.termQuery("user", "foobar")));  // <1>
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
                {
        // tag::clone-index-request-aliases  
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.action.admin.indices.alias.Alias;  
        ActionListener<GetSettingsResponse> listener = new ActionListener<GetSettingsResponse>() {
                    // <1>
            int successfulShards = clearCacheResponse.getSuccessfulShards(); // <2>  
    }
            .must(QueryBuilders.queryStringQuery("*:*"))
    public void testDeleteAlias() throws Exception {
        // end::indices-validate-query-response  
        }
        // end::clone-index-request-aliases
                .build(); // <1>
            // end::templates-exist-execute-async
        boolean acknowledged = rolloverResponse.isAcknowledged(); // <1>  
        ActionListener<GetIndexResponse> listener =  
            request.mapping(jsonMap); // <1>  
            try {
        // end::indices-validate-query-execute-listener  
            request.addAliasAction(aliasAction);
        }
            // end::indices-exists-execute-async  
        final CountDownLatch latch = new CountDownLatch(1);
                .addTokenFilter(stopFilter)     // <5>
            AcknowledgedResponse putTemplateResponse = client.indices().putIndexTemplate(request, RequestOptions.DEFAULT);
            client.indices().putIndexTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.cluster.metadata.AliasMetadata;
            new ActionListener<ValidateQueryResponse>() {
import org.opensearch.client.indices.CloseIndexResponse;
                    // <2>  
            // tag::analyze-field-request  
        {
        assertTrue(acknowledged);
                public void onResponse(AcknowledgedResponse putTemplateResponse) {  
            listener = new LatchedActionListener<>(listener, latch);  
            request.create(false); // make test happy
                public void onResponse(CreateIndexResponse createIndexResponse) {  
            );  
            // Replace the empty listener by a blocking listener in test  
import org.opensearch.OpenSearchException;
                }
            listener = new LatchedActionListener<>(listener, latch);  
                // <2>
            int totalShards = refreshResponse.getTotalShards(); // <1>  
            String explanationIndex = explanation.getIndex(); // <10>
            Settings settings = Settings.builder().put("number_of_shards", 3).build();  
            stopFilter.put("type", "stop");  
        // end::get-index-templates-v2-execute-listener
                      "index.number_of_replicas": "2"
        // Replace the empty listener by a blocking listener in test
        QueryBuilder builder = QueryBuilders
        // end::delete-template-execute
            request.humanReadable(true); // <2>
        ValidateQueryRequest request = new ValidateQueryRequest(index); // <1>
            // end::open-index-request-timeout
            // end::exists-alias-request-alias  
        {
                    }  
        listener = new LatchedActionListener<>(listener, latch);  
            RefreshRequest requestAll = new RefreshRequest(); // <3>  
        // Replace the empty listener by a blocking listener in test
            // tag::force-merge-execute  
            FlushRequest requestMultiple = new FlushRequest("index1", "index2"); // <2>
                @Override
            // tag::get-mappings-execute-listener  
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
            createIndex(
            // tag::put-index-template-v2-request-aliases
            AliasActions removeAction =
            IndicesAliasesRequest request = new IndicesAliasesRequest();
 * specific language governing permissions and limitations
            // tag::exists-alias-request-indices
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // tag::get-index-request-indicesOptions  
                @Override  
        int successfulShards = response.getSuccessfulShards(); // <3>
                request.mapping(// <1>
            final CountDownLatch latch = new CountDownLatch(1);
            Collections.singletonMap("properties", Collections.singletonMap("field-1", Collections.singletonMap("type", "integer"))),  
            // end::update-aliases-execute-async  
                null,  
            public void onFailure(Exception e) {
                public void onResponse(GetComposableIndexTemplatesResponse response) {
            boolean acknowledged = deleteIndexResponse.isAcknowledged(); // <1>  
            ForceMergeRequest requestMultiple = new ForceMergeRequest("index1", "index2"); // <2>  
    }  
            assertTrue(createIndexResponse.isAcknowledged());
    public void testShrinkIndex() throws Exception {  
                null
            }  
        // tag::rollover-index-request-mapping
        // end::clone-index-request-waitForActiveShards
            client.indices().create(new CreateIndexRequest("index-1").alias(new Alias("alias")), RequestOptions.DEFAULT);
                .name("my-template");  
        listener = new LatchedActionListener<>(listener, latch);  
            // end::exists-alias-execute-async
            // tag::get-alias-execute
                        "mappings" : {
        {
            // tag::flush-notfound
                .startObject("properties")
                }  
        }
            // end::close-index-request-indicesOptions  
            }
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        // tag::clone-index-request-timeout
                Map<String, Object> jsonMap = new HashMap<>();
                    public void onFailure(Exception e) {
            request.indices("index"); // <1>
            try {
                @Override
            // end::exists-alias-execute  
            @Override  
        }
                // <1>
            new ActionListener<GetSettingsResponse>() {
            // tag::open-index-execute-async  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        String oldIndex = rolloverResponse.getOldIndex(); // <3>
            };  
            // tag::clear-cache-notfound
            public void onResponse(ResizeResponse resizeResponse) {
            // Replace the empty listener by a blocking listener in test
        {
                    // <2>
                public void onResponse(ClearIndicesCacheResponse clearCacheResponse) {
                }  
                @Override
        // tag::put-template-request  
                    .alias("alias1")
        assertEquals(refreshInterval, indexDefaultSettings.get("index.refresh_interval"));  
                }
            listener = new LatchedActionListener<>(listener, latch);
            // end::put-index-template-v2-request-version  
            // end::create-index-request-timeout
            PutComposableIndexTemplateRequest putRequest = new PutComposableIndexTemplateRequest().name("my-template")
        // Replace the empty listener by a blocking listener in test  
                    }""", // <1>  
        // end::rollover-index-execute  
                    // <2>
        for(QueryExplanation explanation: response.getQueryExplanation()) { // <9>
                .field("analyzer", "english")
        request.source("""  
import org.opensearch.action.admin.indices.open.OpenIndexResponse;  
            aliases.put("twitter_alias", twitterAlias);
            int failedShards = clearCacheResponse.getFailedShards(); // <3>
        RestHighLevelClient client = highLevelClient();  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                    }
            // tag::create-index-execute-async  
        // tag::split-index-request-masterTimeout  
                    // <1>
        String refreshInterval = getSettingsResponse.getSetting("index", "index.refresh_interval"); // <1>
        }
        // tag::split-index-request-timeout
            request.settings(settingsBuilder); // <1>
        // end::indices-validate-query-execute
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                public void onFailure(Exception e) {
                    // <2>
        listener = new LatchedActionListener<>(listener, latch);
        final CountDownLatch latch = new CountDownLatch(1);  
                if (exception.status() == RestStatus.NOT_FOUND) {  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
            boolean exists = client.indices().existsTemplate(request, RequestOptions.DEFAULT);
            // end::delete-index-request-timeout
                @Override
            // tag::analyze-response-detail
            request = new IndexTemplatesExistRequest("my-*"); // <3>
            final CountDownLatch latch = new CountDownLatch(1);  
        assertThat(acknowledged, equalTo(true));  
            assertTrue(createIndexResponse.isAcknowledged());
        }
        // end::delete-template-response
            // end::update-aliases-execute
import org.opensearch.action.LatchedActionListener;
                    new ActionListener<AcknowledgedResponse>() {
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            final CountDownLatch latch = new CountDownLatch(1);
            assertTrue(createIndexResponse.isAcknowledged());
                          "properties": {
                    }
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        }  
            }  
            DeleteIndexRequest request = new DeleteIndexRequest("posts");
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            Template template = new Template(
            createIndexResponse = client.indices().create(new CreateIndexRequest("index4"), RequestOptions.DEFAULT);
        UpdateSettingsRequest request = new UpdateSettingsRequest("index1"); // <1>
                }
                }
            }
                    }""", MediaTypeRegistry.JSON); // <1>  
    public void testGetSettingsWithDefaults() throws Exception {
                // <2>
    public void testGetAlias() throws Exception {  
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        // tag::get-templates-execute-async
            // end::indices-exists-request  
            );
        listener = new LatchedActionListener<>(listener, latch);
        {  
                    public void onResponse(org.opensearch.client.core.AcknowledgedResponse deleteAliasResponse) {
            request.indexTemplate(composableIndexTemplate);
        client.indices().cloneAsync(request, RequestOptions.DEFAULT,listener); // <1>
        // tag::shrink-index-execute-async
            ActionListener<GetMappingsResponse> listener =
    public void testDeleteTemplate() throws Exception {
            // as it is mutually exclusive with max. num. segments
        SimulateIndexTemplateResponse simulateIndexTemplateResponse = client.indices().simulateIndexTemplate(simulateRequest,
            // end::analyze-custom-request
            {
        {  
    }
                    }  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();// <7>  
            listener = new LatchedActionListener<>(listener, latch);
        }
        request.allShards(true); // <1>
            client.indices().clearCacheAsync(request, RequestOptions.DEFAULT, listener); // <1>  
                final Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldMappings = mappings.get("twitter");
                "my_normalizer",        // <2>
        ActionListener<AcknowledgedResponse> listener =  
                //end::create-index-mappings-map  
        GetComposableIndexTemplateRequest request = new GetComposableIndexTemplateRequest("my-template"); // <1>
    public void testGetMapping() throws IOException {
                {
                    // <1>
        listener = new LatchedActionListener<>(listener, latch);  
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
 */
            assertTrue(exists);
        {  
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
import org.opensearch.client.indices.rollover.RolloverRequest;
            assertTrue(putMappingResponse.isAcknowledged());
            request.settings(
            // end::get-mappings-request
        {
                        // <2>
            ActionListener<ClearIndicesCacheResponse> listener = new ActionListener<ClearIndicesCacheResponse>() {  
        // end::shrink-index-request-settings
        // end::rollover-index-request-timeout
        request.setResizeType(ResizeType.SPLIT); // <2>
        request.setWaitForActiveShards(2); // <1>
        request.timeout("2m"); // <2>
                MediaTypeRegistry.JSON);
            assertTrue(exists);
import org.opensearch.client.indices.CloseIndexRequest;
        request.addMaxIndexDocsCondition(1000); // <3>
            // end::exists-alias-execute-listener  
              "aliases": {
        ActionListener<GetComposableIndexTemplatesResponse> listener =
        // tag::delete-index-template-v2-execute
            assertTrue(shardsAcked);  
            };
        request.getCreateIndexRequest().alias(new Alias("another_alias")); // <1>
        {  
                }  
                .startObject()
        // tag::delete-template-execute-listener
            OpenIndexRequest request = new OpenIndexRequest("index"); // <1>
                .addTokenFilter("lowercase")
        // end::delete-index-template-v2-request-masterTimeout  
                      }  
            createIndex("source_index", Settings.builder().put("index.number_of_shards", 4).put("index.number_of_replicas", 0).build());
        request.getTargetIndexRequest().alias(new Alias("target_alias")); // <1>
 * KIND, either express or implied.  See the License for the
            IndicesAliasesRequest request = new IndicesAliasesRequest();
        // end::put-template-request-version  
                if (exception.status() == RestStatus.NOT_FOUND) {  
                final String fullName = metadata1.fullName();
            builder.endObject();
            RefreshRequest requestMultiple = new RefreshRequest("index1", "index2"); // <2>
            client.indices().createAsync(request, RequestOptions.DEFAULT, listener); // <1>
            FlushRequest request = new FlushRequest("index1"); // <1>
            // tag::create-index-request-waitForActiveShards
            assertTrue(createIndexResponse.isAcknowledged());
        // tag::indices-put-settings-request
                        }  
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
            request.indexTemplate(composableIndexTemplate);  
        assertTrue(acknowledged);  
                template, null, null, null, null); // <3>
        {
        int totalShards = response.getTotalShards(); // <2>  
                public void onResponse(AnalyzeResponse analyzeTokens) {
                          "type": "text"
        }
            request.queryCache(true); // <1>  
            indexTypeMappings
        // tag::put-template-whole-source
            // tag::put-mapping-request-timeout
        // end::clone-index-execute  
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index1"), RequestOptions.DEFAULT);  
        assertTrue(resp.isAcknowledged());  
        boolean acknowledged = resizeResponse.isAcknowledged(); // <1>  
                """  
                        "settings" : {  
import org.opensearch.index.IndexSettings;
            GetFieldMappingsResponse response =
                public void onFailure(Exception e) {  
                }  
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
                    // <2>
        // end::get-settings-response
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
            assertThat(error, nullValue());
        Template template = new Template(settings, null, null); // <2>
                Map<String, Object> message = new HashMap<>();
                String failedIndex = failure.index(); // <6>
            request.aliases("alias"); // <1>  
                public void onFailure(Exception e) {
 * the Apache License, Version 2.0 (the "License"); you may
        client.indices().validateQueryAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // tag::rollover-index-request-settings
        String numberOfShardsString = getSettingsResponse.getSetting("index", "index.number_of_shards"); // <1>
            // tag::analyze-custom-normalizer-request
            // tag::clear-cache-request
        // end::clone-index-response
            AnalyzeRequest request = AnalyzeRequest.withNormalizer(  
    }
        boolean acknowledged = resizeResponse.isAcknowledged(); // <1>  
                @Override  
                }
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
            ActionListener<RefreshResponse> listener = new ActionListener<RefreshResponse>() {
        // end::rollover-index-request-settings
            // end::close-index-execute-async
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("posts"), RequestOptions.DEFAULT);
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
            // end::close-index-request-masterTimeout
        {  
            @Override
    @SuppressWarnings("unused")
            try {  
import org.opensearch.client.indices.PutMappingRequest;
            containsInAnyOrder("pattern-1", "log-*")); // <2>
        RestHighLevelClient client = highLevelClient();
                //end::put-mapping-xcontent
            //end::put-template-request-mappings-map
                null,  
                @Override
            putRequest.patterns(Arrays.asList("pattern-1", "log-*"));
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
        GetComposableIndexTemplatesResponse getTemplatesResponse = client.indices().getIndexTemplate(request, RequestOptions.DEFAULT);
                OpenIndexRequest request = new OpenIndexRequest("does_not_exist");
            // end::create-index-execute
                public void onFailure(Exception e) {
        // end::delete-index-template-v2-execute-async  
            // tag::force-merge-notfound  
                {  
            // Replace the empty listener by a blocking listener in test
        // end::indices-put-settings-request-masterTimeout  
            // Replace the empty listener by a blocking listener in test
            // tag::force-merge-request-flush
                }  
            final Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldMappings =  
                    .routing("1"); // <2>
            listener = new LatchedActionListener<>(listener, latch);
        request.indices("twitter"); // <2>  
                            Collections.singletonList("ct1"), null, null, null); // <1>
        {  
                }  
            // end::delete-index-execute  
            AliasActions aliasAction = new AliasActions(AliasActions.Type.ADD).index("index1").alias("async");  
            // end::open-index-execute-async
            CreateIndexResponse createIndexResponse = client.indices()
        RestHighLevelClient client = highLevelClient();
                builder.startObject();  
                //end::create-index-mappings-xcontent
                            "number_of_replicas" : 0
            // tag::put-mapping-request
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
        // tag::indices-put-settings-request-masterTimeout  
            // tag::get-mappings-execute-async  
            try {
            }  
                builder.endObject();
        // tag::put-template-execute-listener
            Map<String, MappingMetadata> allMappings = getMappingResponse.mappings(); // <1>
            // tag::clear-cache-request-request  
            // tag::put-mapping-execute  
                }
            putRequest.patterns(Arrays.asList("pattern-1", "log-*"));
                    // <2>
            final CountDownLatch latch = new CountDownLatch(1);
            client.indices().updateAliasesAsync(request, RequestOptions.DEFAULT, listener); // <1>
                "log-*",  
            // tag::delete-alias-request-timeout
            CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        }
        assertTrue(acknowledged);
        // end::delete-template-execute-async
            new ActionListener<GetIndexTemplatesResponse>() {
            AnalyzeRequest request = AnalyzeRequest.buildCustomAnalyzer("standard")  // <2>
                AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);  
            @Override  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
                Map<String, MappingMetadata> allMappings = r.mappings();
    }  
                public void onFailure(Exception e) {
            builder.startObject();
        DeleteIndexTemplateRequest request = new DeleteIndexTemplateRequest();
            putRequest.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1));  
                }
        // tag::clone-index-execute-listener  
        // tag::get-templates-response
                    .indices("index1", "index2")
            boolean exists = client.indices().existsAlias(request, RequestOptions.DEFAULT);
            CreateIndexResponse createIndexResponse = client.indices()
            client.indices().existsTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>  
            IndicesAliasesRequest request = new IndicesAliasesRequest(); // <1>
            // tag::get-alias-request-indices
                properties.put("message", message);
            // tag::delete-index-execute-listener  
            int successfulShards = refreshResponse.getSuccessfulShards(); // <2>
            request.onlyExpungeDeletes(true); // <1>
        // end::get-index-templates-v2-response
                public void onResponse(Boolean aBoolean) {  
            // tag::clear-cache-request-fields
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                response.mappings();// <1>
            // tag::delete-alias-execute
            ForceMergeResponse forceMergeResponse = client.indices().forcemerge(request, RequestOptions.DEFAULT);
        // tag::split-index-request-settings
            IndicesAliasesRequest request = new IndicesAliasesRequest();
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>  
import org.opensearch.action.admin.indices.flush.FlushResponse;
        GetSettingsRequest request = new GetSettingsRequest().indices("index");  
        RestHighLevelClient client = highLevelClient();
                }
            // tag::open-index-request-timeout
            // end::get-alias-request-local  
        assertTrue(acknowledged);  
            };
            // end::analyze-response-tokens
                public void onResponse(AcknowledgedResponse response) {  
                template,
        }
            // tag::flush-execute  
import org.opensearch.client.GetAliasesResponse;
        client.indices().rolloverAsync(request, RequestOptions.DEFAULT, listener); // <1>
                }
                        // <1>
        request.getTargetIndexRequest().settings(Settings.builder()  
        {
        }
            };
            ForceMergeRequest request = new ForceMergeRequest("index1"); // <1>
                    // <1>
            // end::update-aliases-request2  
            // end::clear-cache-notfound
            FlushRequest requestAll = new FlushRequest(); // <3>  
        }
        }
    }
                    public void onFailure(Exception e) {
            request.indices("index"); // <1>  
            ComponentTemplate componentTemplate = new ComponentTemplate(template, null, null);
            Map<String, Object> jsonMap = new HashMap<>();
        createIndex(index, Settings.EMPTY);
        {
            // tag::clear-cache-execute-listener
            {
            DefaultShardOperationFailedException[] failures = clearCacheResponse.getShardFailures(); // <4>
                        "timestamp": {
            // Replace the empty listener by a blocking listener in test
        RestHighLevelClient client = highLevelClient();
import org.opensearch.client.indices.GetIndexResponse;
                null,
 * The column width of the code block is 84. If the code contains a line longer
        client.indices().deleteTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // tag::shrink-index-request-masterTimeout
                }"""; // <1>  
        // end::get-templates-request  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
                "my_analyzer",        // <2>
            // tag::get-alias-execute-async
        boolean acknowledged = resizeResponse.isAcknowledged(); // <1>
            // end::analyze-execute  
                    // <1>
            };
                            // <1>  
        assertNotNull("with defaults enabled we should get a value for refresh_interval!", refreshInterval);
        // tag::split-index-request  
                    {
            // end::delete-alias-response  
        }  
            // tag::exists-alias-request  
                    builder.endObject();  
import java.util.Set;  
        // Replace the empty listener by a blocking listener in test
        // tag::indices-validate-query-execute-listener
            // end::get-mappings-execute-listener
            AcknowledgedResponse indicesAliasesResponse =  
            Map<String, String> type = new HashMap<>();
                //tag::put-mapping-map  
        // tag::get-index-request-includeDefaults
            for(DefaultShardOperationFailedException failure: response.getShardFailures()) { // <5>
        }
              "index_patterns": [
        // tag::put-template-request-version
                .create(new CreateIndexRequest("index").alias(new Alias("alias")), RequestOptions.DEFAULT);
            PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");  
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest().name("my-template");
        assertTrue(latch.await(30L, TimeUnit.SECONDS));  
            // end::analyze-execute-listener
            // end::put-index-template-v2-response  
                assertTrue(createIndexResponse.isAcknowledged());  
        // tag::get-index-templates-v2-execute-async
        request.getTargetIndexRequest().alias(new Alias("target_alias")); // <1>  
            // tag::force-merge-request-only-expunge-deletes  
        // end::split-index-request-waitForActiveShards
    }  
            // end::refresh-response
            final CountDownLatch latch = new CountDownLatch(1);  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
                new ActionListener<GetFieldMappingsResponse>() {
            listener = new LatchedActionListener<>(listener, latch);
import org.opensearch.common.unit.TimeValue;
                }  
            request = new IndexTemplatesExistRequest("my-template"); // <1>
            // end::flush-request-indicesOptions
        // tag::rollover-index-request
            // tag::get-alias-request-local
    }  
            putRequest.settings(Settings.builder().put("index.number_of_shards", 3));  
        }
                    // <1>  
    public void testSimulateIndexTemplate() throws Exception {
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);  
                    // <1>  
                "number_of_shards": 1
            } catch (OpenSearchException exception) {
            // tag::delete-alias-execute-async
 * This class is used to generate the Java Indices API documentation.  
        // tag::get-settings-defaults-response  
        assertTrue(acknowledged);  
                // <2>
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
        // end::get-settings-request
            // tag::templates-exist-execute
            // Replace the empty listener by a blocking listener in test
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
    }  
        request.patterns(Arrays.asList("pattern-1", "log-*")); // <2>
        // tag::get-index-templates-v2-execute
                @Override
        // end::split-index-execute-listener  
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
 */  
        // tag::delete-index-template-v2-request  
        }
                public void onFailure(Exception e) {  
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(  
                latchListener.onResponse(r);  
                @Override
                        }""", // <2>
            // end::get-mappings-response
    }  
        final RestHighLevelClient client = highLevelClient();
                Arrays.asList("pattern-1", "log-*"),  
        request.alias(new Alias("twitter_alias").filter(QueryBuilders.termQuery("user", "foobar")));  // <1>
            public void onResponse(ResizeResponse resizeResponse) {  
            // tag::open-index-execute  
            // tag::get-mappings-request-indicesOptions
        {
            // end::put-index-template-v2-request-settings  
    public void testIndicesExistAsync() throws Exception {
                .build();
            PutMappingRequest request = new PutMappingRequest("twitter");
        GetIndexResponse getIndexResponse = client.indices().get(request, RequestOptions.DEFAULT);  
    }  
                        {
        assertThat(templates.size(), is(1));  
        request.includeDefaults(true); // <1>
        RestHighLevelClient client = highLevelClient();  
            assertNull(tokens);  
            // tag::update-aliases-request-timeout
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());  
                public void onFailure(Exception e) {  
                }  
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>  
            field.put("message", type);
        ResizeRequest request = new ResizeRequest("target_index","source_index"); // <1>
                @Override
            client.indices().openAsync(request, RequestOptions.DEFAULT, listener); // <1>
        listener = new LatchedActionListener<>(listener, latch);
            };
            // end::indices-put-settings-settings-map  
            // end::get-alias-execute-async
        // tag::rollover-index-execute-listener
        // end::get-index-execute
              },
            // end::close-index-response
            request.addAliasAction(aliasAction); // <3>  
            XContentFactory.jsonBuilder()  
            final String fullName = metadata.fullName();// <4>
        assertNull("refresh_interval returned but was never set!", getSettingsResponse.getSetting("index", "index.refresh_interval"));
                .put("index.number_of_shards", 2) // <1>
            String mappings = "{\"properties\":{\"field-1\":{\"type\":\"integer\"}}}";
            // tag::analyze-request-explain
                    .put(settingKey, settingValue);  
              "settings": {
import org.opensearch.client.indices.AnalyzeRequest;
                request.source(
            // tag::get-mappings-request-masterTimeout
        // tag::shrink-index-request-waitForActiveShards
            AcknowledgedResponse indicesAliasesResponse = client.indices().updateAliases(request, RequestOptions.DEFAULT);
                        builder.field("type", "text");
            ComposableIndexTemplate composableIndexTemplate =  
            ActionListener<AcknowledgedResponse> listener =
            }
                public void onFailure(Exception e) {  
                  "properties": {
                // <1>  
            GetIndexRequest request = new GetIndexRequest("twitter");
            request.onlyExpungeDeletes(ForceMergeRequest.Defaults.ONLY_EXPUNGE_DELETES);  
    }  
        }  
        // end::shrink-index-execute
        ResizeRequest request = new ResizeRequest("target_index","source_index"); // <1>
    @SuppressWarnings("unused")
                    }
        }
            final CountDownLatch latch = new CountDownLatch(1);
            IndicesOptions indicesOptions = IndicesOptions.strictExpand();
                public void onResponse(RefreshResponse refreshResponse) {  
        List<AliasMetadata> indexAliases = getIndexResponse.getAliases().get("index"); // <3>  
        ActionListener<RolloverResponse> listener = new ActionListener<RolloverResponse>() {
        request.setWaitForActiveShards(ActiveShardCount.DEFAULT); // <2>
import java.io.IOException;  
            putRequest.patterns(Collections.singletonList("foo"));
                    // <1>  
                .build("<b>BaR</b>");
                @Override
        Settings settings =
                Map<String, Object> mapping = indexMapping.sourceAsMap();  
                assertTrue(putMappingResponse.isAcknowledged());
            // tag::flush-request-indicesOptions  
            // tag::exists-alias-request-alias
        {
        }
        {  
import org.opensearch.client.indices.GetFieldMappingsResponse;
                @Override  
            // end::analyze-response-detail
            // tag::put-mapping-execute-listener
        Map<String, ComposableIndexTemplate> templates = getTemplatesResponse.getIndexTemplates(); // <1>  
                @Override
        // end::clone-index-request-settings
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
            {  
                    new PutComponentTemplateRequest().name("ct1").componentTemplate(componentTemplate),
                // <1>
        // Replace the empty listener by a blocking listener in test  
            // tag::exists-alias-execute-listener  
            }
 * --------------------------------------------------  
        request = new GetIndexTemplatesRequest("my-*"); // <3>
        }
        client.indices().getAsync(request, RequestOptions.DEFAULT, listener); // <1>
                public void onFailure(Exception e) {
            // tag::open-index-execute-listener
        }
/*  
            assertTrue(createIndexResponse.isAcknowledged());  
            });
            public void onFailure(Exception e) {}  
                        @Override
    }
                new ActionListener<org.opensearch.client.core.AcknowledgedResponse>() {  
    public void testSplitIndex() throws Exception {  
public class IndicesClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
            // end::delete-index-request-indicesOptions
                .putNull("index.routing.allocation.require._name")); // <2>  
            assertTrue(acknowledged);
                XContentBuilder builder = XContentFactory.jsonBuilder();
                public void onResponse(GetIndexResponse getIndexResponse) {  
            String mappingJson = """
    }
import org.opensearch.common.compress.CompressedXContent;  
        }
            // tag::flush-request-wait
        newIndexTemplateRequest.indexTemplate(composableIndexTemplate);
        {
            AnalyzeRequest request = AnalyzeRequest.withIndexAnalyzer(  
            // tag::create-index-request-settings
        };
        final CountDownLatch latch = new CountDownLatch(1);
            ComposableIndexTemplate composableIndexTemplate =  
        final CountDownLatch latch = new CountDownLatch(1);
            request.clusterManagerNodeTimeout("1m"); // <2>
                null, null, null, 3L, null); // <1>
                }
                client.indices().open(request, RequestOptions.DEFAULT);
            AcknowledgedResponse indicesAliasesResponse = client.indices().updateAliases(request, RequestOptions.DEFAULT);
            AnalyzeRequest request = AnalyzeRequest.withField("my_index", "my_field", "some text to analyze");
                }
            // tag::create-index-response
            ActionListener<CloseIndexResponse> listener = new ActionListener<CloseIndexResponse>() {  
            }
    public void testOpenIndex() throws Exception {  
        final CountDownLatch latch = new CountDownLatch(1);  
        request.name("my-template"); // <1>  
            int totalShards = clearCacheResponse.getTotalShards(); // <1>
                    // <1>
                }
            assertTrue(createIndexResponse.isAcknowledged());  
                assertThat(mapping, equalTo(expected));
            // tag::open-index-response
        ActionListener<AcknowledgedResponse> listener =
                @Override
import org.opensearch.core.action.ActionListener;
            // tag::clear-cache-execute  
            @Override
            public void onResponse(ResizeResponse resizeResponse) {  
            assertTrue(createIndexResponse.isAcknowledged());
                @Override
        // tag::get-templates-execute-listener  
            PutMappingRequest request = new PutMappingRequest("twitter");
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
 * Then in the documentation, you can extract what is between tag and end tags with
                    , MediaTypeRegistry.JSON); // <1>
        {
                assertTrue(createIndexResponse.isAcknowledged());
            int shardId = explanation.getShard(); // <11>  
            request.timeout("2m"); // <2>  
        // tag::get-field-mappings-request-local
        }
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
 * license agreements. See the NOTICE file distributed with
            // end::put-mapping-execute-listener
        request.indicesOptions(IndicesOptions.lenientExpandOpen());
        // end::simulate-index-template-request
            public void onResponse(GetSettingsResponse GetSettingsResponse) {}  
                    @Override
        {  
                request.mapping(mapping); // <1>
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // end::clear-cache-request-fields
            // end::flush-execute
        client.indices().getSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // end::rollover-index-execute-listener
            // end::flush-notfound
 * // tag::example
                    @Override
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(
            assertTrue(client.indices().putIndexTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());  
            // Replace the empty listener by a blocking listener in test
        boolean shardsAcked = resizeResponse.isShardsAcknowledged(); // <2>  
                        // <2>
            ActionListener<AnalyzeResponse> listener = new ActionListener<AnalyzeResponse>() {
            int failedShards = forceMergeResponse.getFailedShards(); // <3>
                @Override
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::put-template-response
                    MediaTypeRegistry.JSON);
        request.clusterManagerNodeTimeout("1m"); // <2>
            } catch (OpenSearchException exception) {
        }
import org.opensearch.client.indices.CreateIndexRequest;  
        // tag::rollover-index-request-timeout  
        ResizeResponse resizeResponse = client.indices().clone(request, RequestOptions.DEFAULT);
        {  
            // tag::put-index-template-v2-execute  
        }  
        request.setResizeType(ResizeType.CLONE); // <2>
    public void testExistsAlias() throws Exception {
        listener = new LatchedActionListener<>(listener, latch);
                null,  
                    public void onResponse(AcknowledgedResponse putMappingResponse) {
            GetMappingsRequest request = new GetMappingsRequest();  
            // end::flush-request-wait  
        // tag::indices-put-settings-create-settings
        ValidateQueryResponse response = client.indices().validateQuery(request, RequestOptions.DEFAULT); // <1>
            request.waitForActiveShards(ActiveShardCount.DEFAULT); // <2>
        request.rewrite(true); // <1>  
            request = AnalyzeRequest.withField("my_index", "my_field", "some text to analyze");
                request.source(jsonMap); // <1>
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
        }  
        }
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
        GetIndexTemplatesRequest request = new GetIndexTemplatesRequest("my-template"); // <1>  
import org.opensearch.client.indices.PutIndexTemplateRequest;
                    new ActionListener<GetAliasesResponse>() {  
        }
        ActionListener<GetIndexTemplatesResponse> listener =
            RequestOptions.DEFAULT);
import java.util.concurrent.TimeUnit;
 * ["source","java",subs="attributes,callouts,macros"]
                    new GetAliasesRequest(new String[]{"alias1", "alias2"});
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
        // tag::indices-put-settings-request-index-settings
            // tag::put-index-template-v2-execute-async  
                Map<String, Object> message = new HashMap<>();
                    // <1>
            } catch (OpenSearchException exception) {  
        // tag::indices-validate-query-request-rewrite
            final ActionListener<GetMappingsResponse> latchListener = new LatchedActionListener<>(listener, latch);
        // tag::clone-index-request-masterTimeout  
        // tag::indices-put-settings-request-timeout
            );
                null, null, 20L, null, null); // <1>
        final RestHighLevelClient client = highLevelClient();  
            // tag::clear-cache-execute-async
                        // <1>
                    }""", // <1>
        // tag::get-field-mappings-request-indicesOptions
    public void testIndexPutSettings() throws Exception {
            // tag::indices-exists-request
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);  
                @Override  
                .put(settingKey, settingValue)
        // tag::get-templates-request
                            "message": {  
        ActionListener<AcknowledgedResponse> listener =  
        // tag::put-template-response  
            client.indices().analyzeAsync(request, RequestOptions.DEFAULT, listener); // <1>
                    // <1>
                Settings.builder().put("index.routing.allocation.require._name", firstNode).put("index.blocks.write", true)
        request.setPreserveExisting(false); // <1>  
        RestHighLevelClient client = highLevelClient();
    public void testPutMapping() throws IOException {
        // end::shrink-index-request
            @Override
        }
        }
        // tag::rollover-index-request-waitForActiveShards  
                builder.startObject();
            CreateIndexRequest request = new CreateIndexRequest("twitter");
                }
            // end::close-index-request
        boolean shardsAcked = rolloverResponse.isShardsAcknowledged(); // <2>
            {
        {
                int shardId = failure.shardId(); // <7>  
                // <2>  
                String reason = failure.reason(); // <8>
            int successfulShards = flushResponse.getSuccessfulShards(); // <2>  
        // end::put-template-request-settings
        // end::get-templates-execute-async  
            // tag::update-aliases-execute-listener  
        client.indices().splitAsync(request, RequestOptions.DEFAULT,listener); // <1>
            assertTrue(createIndexResponse.isAcknowledged());
            client.indices().getAliasAsync(request, RequestOptions.DEFAULT, listener); // <1>  
        simulateRequest.indexTemplateV2Request(newIndexTemplateRequest); // <2>  
import org.opensearch.action.admin.indices.shrink.ResizeRequest;  
            request.indices("twitter"); // <2>
            {  
        {
            client.indices().refreshAsync(request, RequestOptions.DEFAULT, listener); // <1>
        }  
        final CountDownLatch latch = new CountDownLatch(1);
            listener = new LatchedActionListener<>(listener, latch);  
            client.indices().existsAliasAsync(request, RequestOptions.DEFAULT, listener); // <1>
 * GitHub history for details.
            // tag::create-index-execute-listener
        // end::delete-index-template-v2-execute
    }
    public void testRolloverIndex() throws Exception {
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        boolean shardsAcked = resizeResponse.isShardsAcknowledged(); // <2>
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                "properties": {
                final GetFieldMappingsResponse.FieldMappingMetadata metadata1 = fieldMappings.get("message");
            Settings.Builder settingsBuilder =
        request.timeout("2m"); // <2>
            // end::get-field-mappings-response
        // tag::get-index-templates-v2-response
    public void testGetFieldMapping() throws IOException, InterruptedException {  
    }
                .name("my-template");  
                    }
        {  
                }
                """
        // end::split-index-request-settings
            listener = new LatchedActionListener<>(listener, latch);
            };
        request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest().name("my-template");  
            }, e -> {
        // end::delete-template-request
        request.getCreateIndexRequest().waitForActiveShards(ActiveShardCount.from(2)); // <1>
            // end::delete-index-execute-listener
            // end::indices-put-settings-settings-builder
                    .index("index3")
        }
            ActionListener<CreateIndexResponse> listener =
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        ActionListener<ResizeResponse> listener = new ActionListener<ResizeResponse>() {
    public void testPutTemplate() throws Exception {  
                {
import org.opensearch.index.query.QueryBuilders;
            // end::force-merge-response  
 * --------------------------------------------------
            // end::open-index-execute-listener  
        }
            assertTrue(client.indices().putTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // tag::get-settings-request-names
                ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("does_not_exist");  
            // end::exists-alias-request-indices  
                .endObject()
            DefaultShardOperationFailedException[] failures = forceMergeResponse.getShardFailures(); // <4>
    @SuppressWarnings("unused")  
            .put("index.number_of_replicas", 1)
        List<IndexTemplateMetadata> templates = getTemplatesResponse.getIndexTemplates(); // <1>  
            // tag::put-index-template-v2-request-masterTimeout  
        }
            assertNotNull(detail.tokenizer());
            listener = new LatchedActionListener<>(listener, latch);  
            PutMappingRequest request = new PutMappingRequest("twitter");
        }  
            // end::flush-request-force
                        "message": {
            PutMappingRequest request = new PutMappingRequest("twitter"); // <1>  
                        builder.endObject();
                AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);  
            // tag::open-index-request-indicesOptions
            request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <2>  
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);  
        // end::put-template-execute
            };
            AliasMetadata placeholderAlias = AliasMetadata.builder("{index}_alias").searchRouting("xyz").build(); // <2>
            aliases.put("{index}_alias", placeholderAlias);
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // end::put-mapping-request
            Settings settings = Settings.builder().put("number_of_shards", 3).build();  
            request.indexTemplate(composableIndexTemplate);
    public void testCloneIndex() throws Exception {
            // end::refresh-execute-listener  
        }
                }
                    // <2>  
            ActionListener<AcknowledgedResponse> listener =
                client.indices().forcemerge(request, RequestOptions.DEFAULT);  
                    .filter("{\"term\":{\"year\":2016}}"); // <1>
        request.dryRun(true); // <1>
                Settings.builder()  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
            Template template = new Template(null, new CompressedXContent(mappingJson), null); // <2>  
            GetMappingsResponse getMappingResponse = client.indices().getMapping(request, RequestOptions.DEFAULT);
                    // <1>  
            // tag::flush-execute-listener
        request.getCreateIndexRequest().mapping(mappings, MediaTypeRegistry.JSON); // <1>
                new ActionListener<GetMappingsResponse>() {
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
                    @Override
                }
        RestHighLevelClient client = highLevelClient();  
            // end::put-index-template-v2-request-priority  
            }""", MediaTypeRegistry.JSON); // <1>  
        RestHighLevelClient client = highLevelClient();
        listener = new LatchedActionListener<>(listener, latch);
            };
            {  
        // tag::clone-index-request-waitForActiveShards
                      "properties": {
        assertEquals("3", numberOfShardsString);
    }  
    }  
                    public void onResponse(GetMappingsResponse putMappingResponse) {
    public void testDeleteIndex() throws IOException {  
                MediaTypeRegistry.JSON
                new ActionListener<AcknowledgedResponse>() {
                Map<String, Object> mapping = new HashMap<>();  
            );
 * The OpenSearch Contributors require contributions made to  
                    // <1>
        RestHighLevelClient client = highLevelClient();
            request.settings(map); // <1>
            // tag::create-index-whole-source  
            // tag::get-alias-request-indicesOptions  
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
import org.opensearch.common.settings.Settings;
 * // end::example  
        // tag::indices-validate-query-request-query
package org.opensearch.client.documentation;
            .put("index.number_of_shards", 3)
                    }  
 * Unless required by applicable law or agreed to in writing,
        request.setWaitForActiveShards(ActiveShardCount.DEFAULT); // <2>  
            // tag::get-field-mappings-execute
                FlushRequest request = new FlushRequest("does_not_exist");  
            // end::create-index-request-settings
                        // <2>
        }
    public void testGetIndexTemplatesV2() throws Exception {
                }
                    // <2>
            // end::delete-alias-execute
        // end::get-index-request-indicesOptions
                        // <2>  
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        // tag::clone-index-request-settings
        }  
        // tag::split-index-execute-async  
            client.indices().flushAsync(request, RequestOptions.DEFAULT, listener); // <1>  
        request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
            AliasActions aliasAction =
            // end::force-merge-notfound  
        CreateIndexResponse resp = client.indices().create(req, RequestOptions.DEFAULT);
                public void onFailure(Exception e) {
        {  
                @Override
 *
            // tag::refresh-execute
    public void testFlushIndex() throws Exception {
        request.order(20);  // <1>
        // end::indices-put-settings-execute-listener
                    }
        RestHighLevelClient client = highLevelClient();  
            assertTrue(createIndexResponse.isAcknowledged());  
                    // <2>
        boolean shardsAcked = resizeResponse.isShardsAcknowledged(); // <2>
        GetIndexTemplatesResponse getTemplatesResponse = client.indices().getIndexTemplate(request, RequestOptions.DEFAULT);
        // end::shrink-index-request-waitForActiveShards
                @Override
            // end::flush-execute-listener
            assertThat(mapping, equalTo(expected));
            });
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
        {  
                        builder.startObject("message");
            Map<String, Object> expected = new HashMap<>();
                "some text to analyze"  
                fail("should not fail");  
        };
        // tag::shrink-index-execute  
                        },
                          "type": "date"  
            createIndexResponse = client.indices().create(new CreateIndexRequest("index3"), RequestOptions.DEFAULT);
            // tag::templates-exist-request  
            request.indexTemplate(composableIndexTemplate);  
                RefreshRequest request = new RefreshRequest("does_not_exist");
            AnalyzeRequest request = AnalyzeRequest.buildCustomNormalizer()  
            }
        client.indices().getIndexTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
        request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
            // end::analyze-request-explain
    public void testUpdateAliases() throws Exception {  
    public void testGetMappingAsync() throws Exception {
                @Override  
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;  
            stopFilter.put("stopwords", new String[]{ "to" });  // <1>
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
        // tag::rollover-index-execute
        // end::indices-validate-query-request-rewrite
        ActionListener<GetSettingsResponse> listener =
                @Override
                    Settings.builder()
                .put("index.number_of_shards", 3)
                null,
                null,  
        {
                    // <2>  
    public void testCloseIndex() throws Exception {
            request.attributes("keyword", "type");      // <2>
        request.alias(new Alias("{index}_alias").searchRouting("xyz"));  // <2>  
            // end::get-mappings-execute
                    .put("index.number_of_replicas", 0)
                  }  
                    }
        assertFalse(isRolledOver);  
            request.local(false); // <1>
                    // <1>
        // tag::indices-put-settings-execute-listener  
        // tag::rollover-index-request-alias  
            listener = new LatchedActionListener<>(listener, latch);
            {  
                    .alias("alias2")  
                final Map<String, Object> source = metadata1.sourceAsMap();
            // tag::templates-exist-execute-listener  
                    "type": "text"
import static org.hamcrest.Matchers.is;
                request.mapping(builder); // <1>  
            // tag::analyze-index-normalizer-request
        boolean acknowledged = putTemplateResponse.isAcknowledged(); // <1>
            }
            // end::get-field-mappings-execute
            // end::templates-exist-request
import org.opensearch.client.indices.IndexTemplatesExistRequest;
            // end::update-aliases-request-masterTimeout  
        // tag::shrink-index-response
        request.clusterManagerNodeTimeout("1m"); // <2>
                public void onFailure(Exception e) {
                // <1>
            // tag::close-index-execute
        request.explain(true); // <1>
        // end::put-template-execute-async
            AcknowledgedResponse closeIndexResponse = client.indices().close(request, RequestOptions.DEFAULT);  
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>  
        // tag::simulate-index-template-execute-async
                public void onFailure(Exception e) {
        // tag::shrink-index-execute-listener
            // end::clear-cache-execute-async
                          }  
            AnalyzeResponse response = client.indices().analyze(request, RequestOptions.DEFAULT);
            // tag::get-field-mappings-execute-listener
            // end::delete-alias-request-masterTimeout  
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest().name("my-template"); // <1>  
            // tag::put-index-template-v2-request  
                }
                    builder.startObject("properties");
                Map<String, Object> field = new HashMap<>();
        // end::delete-index-template-v2-execute-listener
import org.opensearch.client.indices.rollover.RolloverResponse;  
            // tag::close-index-request
        {
            String explanationString = explanation.getExplanation(); // <12>
                    @Override
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                        @Override  
                {
        listener = new LatchedActionListener<>(listener, latch);
                      "type": "text"
                  "message": {  
        // end::shrink-index-request-aliases
            request = new CreateIndexRequest("twitter5");  
            PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");
                }
        {
        // tag::delete-template-execute
            // tag::open-index-request-waitForActiveShards  
        }  
                MappingMetadata indexMapping = allMappings.get("twitter");
                //end::put-mapping-map
            //tag::put-template-request-mappings-xcontent
                    @Override  
        }
            Template template = new Template(null, null, aliases); // <3>  
        }
            };  
            public void onFailure(Exception e) {
        // end::indices-validate-query-execute-async
        );
        final CountDownLatch latch = new CountDownLatch(1);  
            // tag::close-index-request-timeout  
            assertTrue(createIndexResponse.isAcknowledged());  
                    builder.startObject("message");
        // tag::delete-index-template-v2-execute-listener
            // end::templates-exist-request-optionals
            // end::put-index-template-v2-request-aliases  
            // tag::refresh-request  
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>  
                }
        // end::get-index-templates-v2-execute  
            int totalShards = flushResponse.getTotalShards(); // <1>
        }  
    public void testDeleteIndexTemplateV2() throws Exception {
        // tag::put-template-request-settings
            // tag::update-aliases-request2  
            // end::flush-execute-async
                        builder.startObject("message");  
    public void testClearCache() throws Exception {
            };  
            Map<String, AliasMetadata> aliases = new HashMap<>();  
            .getAsTime("index.refresh_interval", null); // <7>
import static org.hamcrest.Matchers.nullValue;  
    @SuppressWarnings("unused")
        }
        AcknowledgedResponse pmResp = client.indices().putMapping(pmReq, RequestOptions.DEFAULT);
        // end::rollover-index-execute-async  
        {
                if (exception.status() == RestStatus.NOT_FOUND) {
            // tag::indices-put-settings-settings-source  
import org.opensearch.client.indices.GetComposableIndexTemplatesResponse;  
        RestHighLevelClient client = highLevelClient();  
        {
        // end::clone-index-execute-listener  
            List<AnalyzeResponse.AnalyzeToken> tokens = response.getTokens();   // <1>  
import static org.hamcrest.Matchers.equalTo;
                public void onResponse(FlushResponse flushResponse) {
        // end::get-index-execute-async
                }  
                    // <2>
        request.timeout("2m"); // <2>
    public void testTemplatesExist() throws Exception {  
        assertEquals(3, conditionStatus.size());
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);  
        GetSettingsRequest request = new GetSettingsRequest().indices("index"); // <1>
import org.opensearch.client.indices.GetFieldMappingsRequest;
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
                    .alias("alias3"); // <3>
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()  
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
            final Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings =
import static org.hamcrest.Matchers.containsInAnyOrder;
            // end::delete-index-request
        // tag::get-index-response  
        // end::get-templates-execute  
        {
                }  
                    message.put("type", "text");
        // end::split-index-request-masterTimeout  
    }
        }
        // end::rollover-index-request-waitForActiveShards  
        SimulateIndexTemplateRequest simulateRequest = new SimulateIndexTemplateRequest("log-000001"); // <1>  
            }
        {  
                Map<String, Object> expected = new HashMap<>();  
            // Use a blocking listener in the test
    }
        request.addMaxIndexAgeCondition(new TimeValue(7, TimeUnit.DAYS)); // <2>
                @Override
            // tag::clear-cache-request-indicesOptions
            map.put(settingKey, settingValue);
            AliasActions addIndicesAction =  
            // end::get-mappings-execute-async
            // tag::exists-alias-execute-async  
                }  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
                    new AliasActions(AliasActions.Type.ADD)
            request.mapping(builder); // <1>
            // end::put-index-template-v2-request-create
            listener = new LatchedActionListener<>(listener, latch);  
        }
            MappingMetadata indexMapping = allMappings.get("twitter"); // <2>  
            // end::indices-exists-execute-listener
                .endObject()
                Map<String, Object> properties = new HashMap<>();
        {  
                "Some text to analyze", "Some more text to analyze");       // <2>
        // tag::split-index-response
            public void onResponse(AcknowledgedResponse updateSettingsResponse) {
                Map<String, Object> properties = new HashMap<>();
        {
        RestHighLevelClient client = highLevelClient();  
            client.cluster()  
            );  
        RestHighLevelClient client = highLevelClient();
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            // end::put-index-template-v2-execute-listener
        // tag::get-settings-execute  
        request.getCreateIndexRequest().settings(Settings.builder()
import org.opensearch.cluster.metadata.ComponentTemplate;
            // end::put-mapping-response  
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
        // tag::get-index-execute-listener
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged(); // <2>  
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(
                    // <2>  
        RestHighLevelClient client = highLevelClient();  
        request.getTargetIndexRequest().settings(Settings.builder()
                template, null, null, null, null); // <3>
            createIndex("index1", Settings.EMPTY);
import java.util.List;
            Map<String, Object> field = new HashMap<>();  
        // end::get-index-execute-listener  
            public void onFailure(Exception e) {  
        {  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;  
            GetAliasesRequest request = new GetAliasesRequest();
            PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");
                    // <1>
            // end::clear-cache-request
                null
            // tag::delete-index-request-timeout
            // end::create-index-request  
        request.getTargetIndexRequest().settings(Settings.builder()  
            assertTrue(createIndexResponse.isAcknowledged());
            // tag::get-mappings-execute  
        final CountDownLatch latch = new CountDownLatch(1);
        final CountDownLatch latch = new CountDownLatch(1);  
        }  
                new ActionListener<AcknowledgedResponse>() {
                    // <2>
            request.force(true); // <1>  
                        }
            request.setClusterManagerNodeTimeout("1m"); // <3>
        // end::indices-put-settings-response  
                .indexTemplate(new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"), template, null, null, null, null));
            request.indexTemplate(composableIndexTemplate);  
            // tag::create-index-request-timeout
                // end::create-index-request-mappings  
            // tag::update-aliases-execute
                client.indices().flush(request, RequestOptions.DEFAULT);
        // tag::get-index-execute-async  
            // tag::get-alias-response  
                            }
                    }
        ResizeResponse resizeResponse = client.indices().shrink(request, RequestOptions.DEFAULT);
    public void testAnalyze() throws IOException, InterruptedException {
                .name("my-template");
            assertThat(status, equalTo(RestStatus.OK));  
        {  
        // end::put-template-request-aliases
        RestHighLevelClient client = highLevelClient();
import org.opensearch.action.admin.indices.shrink.ResizeResponse;
                if (exception.status() == RestStatus.NOT_FOUND) {
                        },  
 * SPDX-License-Identifier: Apache-2.0
        }
        String index = "some_index";  
                "{index}-alias": {}
        {
            }  
        {  
            request.indices("twitter");
            };
                .startObject("my_field")  
                    {  
                public void onResponse(Boolean exists) {
    }  
        boolean isDryRun = rolloverResponse.isDryRun(); // <6>
    public void testIndicesExist() throws IOException {
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>  
        // tag::simulate-index-template-response  
            request.local(true); // <1>
        assertEquals("3", numberOfShardsString);
        // end::indices-validate-query-request-allShards  
            assertTrue(createIndexResponse.isAcknowledged());
                assertTrue(createIndexResponse.isAcknowledged());
import org.opensearch.cluster.metadata.MappingMetadata;
        request.create(false); // make test happy  
        PutComposableIndexTemplateRequest newIndexTemplateRequest = new PutComposableIndexTemplateRequest()
        // Replace the empty listener by a blocking listener in test
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
        RestHighLevelClient client = highLevelClient();  
                mappings.get("twitter"); // <2>
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
                        {
        };
            // tag::get-alias-execute-listener
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
        request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
                        MediaTypeRegistry.JSON);
            // tag::put-mapping-execute-async
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>  
            // tag::clear-cache-response
        // tag::split-index-execute-listener  
        // tag::indices-validate-query-response
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);  
                latchListener.onFailure(e);
            expected.put("properties", field);  
            AliasActions aliasAction = new AliasActions(AliasActions.Type.ADD).index("index1").alias("alias1");
            listener = ActionListener.wrap(r -> {
                }  
        request.setClusterManagerNodeTimeout("1m"); // <2>
        {
        UpdateSettingsRequest requestAll = new UpdateSettingsRequest(); // <3>
            // tag::put-template-request-mappings-json
            }
                public void onFailure(Exception e) {
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                .name("my-template");
        DeleteComposableIndexTemplateRequest deleteRequest = new DeleteComposableIndexTemplateRequest("my-template"); // <1>
            int failedShards = refreshResponse.getFailedShards(); // <3>
 * Where example is your tag name.
            ClearIndicesCacheResponse clearCacheResponse = client.indices().clearCache(request, RequestOptions.DEFAULT);
        // end::get-settings-execute
        Integer numberOfShards = indexSettings.getAsInt("index.number_of_shards", null); // <6>  
            final CountDownLatch latch = new CountDownLatch(1);
                }
import org.opensearch.client.indices.PutComponentTemplateRequest;
        }
        }  
        ActionListener<AcknowledgedResponse> listener =
            final CountDownLatch latch = new CountDownLatch(1);  
        // end::get-settings-execute-listener
            Map<String, Object> stopFilter = new HashMap<>();
                null,
            ActionListener<org.opensearch.client.core.AcknowledgedResponse> listener =
            // tag::put-mapping-request-masterTimeout
            request.source("{ \"properties\": { \"message\": { \"type\": \"text\" } } }", MediaTypeRegistry.JSON);  
 */  
        // end::indices-put-settings-request  
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
    }  
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                public void onResponse(OpenIndexResponse openIndexResponse) {  
                public void onFailure(Exception e) {
            // tag::exists-alias-request-local  
            // end::analyze-field-request
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
        listener = new LatchedActionListener<>(listener, latch);
import org.opensearch.client.indices.GetIndexRequest;  
        // end::simulate-index-template-response  
            boolean acknowledged = openIndexResponse.isAcknowledged(); // <1>
import org.opensearch.action.admin.indices.flush.FlushRequest;
            final CountDownLatch latch = new CountDownLatch(1);  
    public void testValidateQuery() throws IOException, InterruptedException {  
            assertTrue(acknowledged);
        ActionListener<ResizeResponse> listener = new ActionListener<ResizeResponse>() {  
            Template template = new Template(Settings.builder().put("index.number_of_replicas", 3).build(), null, null);
        {
        // tag::indices-put-settings-request-indicesOptions
        Integer numberOfShards = indexSettings.getAsInt("index.number_of_shards", null); // <3>
                    .put("index.number_of_shards", 2)
        // end::indices-put-settings-request-index-settings  
import org.opensearch.action.support.IndicesOptions;
            request.indexTemplate(composableIndexTemplate);
                    // <1>
        assertEquals(
            Settings settings = Settings.builder() // <1>
        {
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        {
                    new AliasActions(AliasActions.Type.ADD)
        {
                if (exception.status() == RestStatus.NOT_FOUND) {
    public void testGetTemplates() throws Exception {
            }  
            // end::clear-cache-request-request
            // end::put-mapping-execute-async
        Settings indexSettings = getIndexResponse.getSettings().get("index"); // <5>
    public void testDeleteIndexAsync() throws Exception {
            } catch (OpenSearchException exception) {  
            ActionListener<OpenIndexResponse> listener =  
        Settings settings = Settings.builder().put("index.number_of_shards", 6).build();  
                assertTrue(createIndexResponse.isAcknowledged());
        request = new GetComposableIndexTemplateRequest("my-*"); // <2>
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());  
        client.indices().putTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
                  }
            request.indicesOptions(IndicesOptions.strictExpandOpen()); // <1>  
            assertTrue(createIndexResponse.isAcknowledged());
                }
        // tag::split-index-request-waitForActiveShards
            request.waitForActiveShards(ActiveShardCount.DEFAULT); // <2>
            assertThat(response.getAliases().get("index").size(), equalTo(1));
        if (failedShards > 0) {  
            createIndexResponse = client.indices().create(new CreateIndexRequest("index2"), RequestOptions.DEFAULT);  
        // end::shrink-index-response
    }
            // tag::put-index-template-v2-execute-listener  
            // end::analyze-index-request
                builder.endObject();  
        // tag::indices-put-settings-request-preserveExisting
            // end::templates-exist-execute-listener  
            // end::close-index-execute
            // end::put-template-request-mappings-json  
        request.setWaitForActiveShards(2); // <1>  
            // end::force-merge-request-only-expunge-deletes
            assertThat(exception, nullValue());
import org.opensearch.index.query.QueryBuilder;  
            // Replace the empty listener by a blocking listener in test  
                };
        }
        }
        // end::rollover-index-response
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
            // Replace the empty listener by a blocking listener in test
    }
            // end::put-index-template-v2-execute
                public void onResponse(AcknowledgedResponse deleteIndexResponse) {
        {
            // end::clear-cache-execute-listener
            // end::exists-alias-request-local
        {
                        // <2>
            createIndex("source_index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
        boolean acknowledged = updateSettingsResponse.isAcknowledged(); // <1>
        {  
            );
                .field("type", "text")
                            }
            ActionListener<FlushResponse> listener = new ActionListener<FlushResponse>() {  
                .mapping(mappings, MediaTypeRegistry.JSON);  
            AcknowledgedResponse deleteIndexResponse = client.indices().delete(request, RequestOptions.DEFAULT);
        {
                }
        }
        assertEquals(Integer.valueOf(3), numberOfShards);  
                        }
        }
                null,
    }  
            putRequest.patterns(Arrays.asList("pattern-1", "log-*"));
        // end::put-template-whole-source
        }
            request.explain(true);                      // <1>  
            AnalyzeRequest request = AnalyzeRequest.withGlobalAnalyzer("english", // <1>
            // tag::delete-index-request  
        // end::rollover-index-request-masterTimeout
            };
            // end::delete-index-response
        }
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>  
        request = new GetIndexTemplatesRequest("template-1", "template-2"); // <2>
            // tag::indices-exists-request-optionals  
        // end::get-field-mappings-request
        // tag::split-index-execute
            }, e -> {
                    public void onResponse(GetFieldMappingsResponse putMappingResponse) {  
              "order": 1,  
                public void onFailure(Exception e) {  
    @SuppressWarnings("unused")
        // tag::clone-index-execute-async  
            template, null, 90L, null, null);  
        request.names("index.number_of_shards"); // <1>
            // end::create-index-response
        // tag::indices-validate-query-request-explain  
                        builder.endObject();
    @SuppressWarnings("unused")
        assertTrue(shardsAcked);  
        }  
        // end::indices-validate-query-request-explain
                Arrays.asList("pattern-1", "log-*"),
 * You may obtain a copy of the License at  
        }  
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index1"), RequestOptions.DEFAULT);
              },  
            request.requestCache(true); // <1>
            Map<String, Object> mapping = indexMapping.sourceAsMap(); // <3>
            // end::get-alias-request-alias
            assertTrue(client.indices().putTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            // tag::indices-put-settings-settings-builder  
                        "message": {  
        // tag::get-settings-request-include-defaults  
        client.indices().shrinkAsync(request, RequestOptions.DEFAULT, listener); // <1>  
        // end::indices-put-settings-request-preserveExisting
            // end::delete-alias-execute-listener
            // tag::get-mappings-response
            // end::delete-alias-request
            // tag::analyze-execute-listener
            org.opensearch.client.core.AcknowledgedResponse deleteAliasResponse =  
        // end::clone-index-request  
        // tag::delete-index-template-v2-request-masterTimeout
            // tag::force-merge-request-segments-num
            client.indices().putMappingAsync(request, RequestOptions.DEFAULT, listener); // <1>  
                message.put("type", "text");  
            // end::update-aliases-request-timeout
    @SuppressWarnings("unused")
            // Replace the empty listener by a blocking listener in test
        // tag::indices-put-settings-execute
        }
                    // <1>
        // tag::put-template-request-create  
                    // <2>  
            }
                    // <2>
                            // <2>
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;  
        // end::rollover-index-request
            };
            XContentBuilder builder = XContentFactory.jsonBuilder();  
        request.version(4);  // <1>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);  
            // tag::templates-exist-execute-async
            // end::force-merge-request-flush
        {  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // end::put-mapping-execute
            // set only expunge deletes back to its default value
        }  
                null  
import java.util.Map;
        ResizeResponse resizeResponse = client.indices().split(request, RequestOptions.DEFAULT);
        // end::get-settings-request-indicesOptions
        }  
        // end::indices-put-settings-request-indicesOptions  
        {
                builder.startObject("properties");  
        // end::get-templates-response
        };  
            GetAliasesResponse response = client.indices().getAlias(request, RequestOptions.DEFAULT);  
                "source_index",
                client.indices().putSettings(request, RequestOptions.DEFAULT);
            // end::get-mappings-request-masterTimeout  
                @Override
        final CountDownLatch latch = new CountDownLatch(1);
        }  
                    public void onFailure(Exception e) {  
        request.local(true); // <1>  
        // end::indices-put-settings-execute-async
            int successfulShards = forceMergeResponse.getSuccessfulShards(); // <2>  
        ResizeRequest request = new ResizeRequest("target_index","source_index"); // <1>  
                public void onResponse(GetIndexTemplatesResponse response) {
        // tag::delete-index-template-v2-execute-async
                        // <1>  
        {
        // Replace the empty listener by a blocking listener in test
                ForceMergeRequest request = new ForceMergeRequest("does_not_exist");
            // tag::analyze-execute-async  
            boolean acknowledged = indicesAliasesResponse.isAcknowledged(); // <1>
                @Override
                @Override  
                public void onFailure(Exception e) {
            // tag::delete-index-execute
            assertTrue(acknowledged);
            // tag::exists-alias-request-indicesOptions
                }
            }
        // tag::indices-put-settings-execute-async
        // tag::simulate-index-template-request
                Map<String, String> type = new HashMap<>();
        // end::split-index-request  
        // end::put-template-execute-listener  
                @Override
                    new GetAliasesRequest(new String[]{"alias1", "alias2"});
                Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build(),  
            // end::indices-put-settings-settings-source
        // end::clone-index-execute-async
            // end::put-index-template-v2-request-masterTimeout
/**
                "alias-1": {},  
        // end::shrink-index-execute-listener
            .name("used-for-simulation");
            assertTrue(shardsAcknowledged);  
            assertTrue(indicesAliasesResponse.isAcknowledged());  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        listener = new LatchedActionListener<>(listener, latch);
import org.opensearch.client.indices.GetIndexTemplatesResponse;  
        // end::get-templates-request-masterTimeout
        {
        {
                        public void onResponse(GetAliasesResponse getAliasesResponse) {
            };
            assertTrue(acknowledged);
        ActionListener<ResizeResponse> listener = new ActionListener<ResizeResponse>() {
        // end::indices-validate-query-request-query
            // Replace the empty listener by a blocking listener in test
        }
        }
        // end::put-template-request  
        int failedShards = response.getFailedShards(); // <4>
        // tag::shrink-index-request-aliases
            client.indices().existsAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // tag::delete-template-response  
                new UpdateSettingsRequest("index1", "index2"); // <2>
        // end::delete-template-request-masterTimeout  
        RestHighLevelClient client = highLevelClient();  
                // tag::create-index-request-mappings
                    }  
        }
                .create(new CreateIndexRequest("index").settings(settings), RequestOptions.DEFAULT);
        // end::put-template-request-create
            new ActionListener<AcknowledgedResponse>() {  
        {
            assertTrue(acknowledged);  
import org.opensearch.client.indices.GetMappingsRequest;
                    .index("index1")
                public void onResponse(AcknowledgedResponse indicesAliasesResponse) {
        RestHighLevelClient client = highLevelClient();  
        // tag::clone-index-request  
/*
        // end::indices-put-settings-request-timeout
                    client.indices().updateAliases(request, RequestOptions.DEFAULT);
            // tag::put-index-template-v2-request-priority
            RestStatus status = response.status(); // <1>
            // end::get-alias-response-error
        // tag::get-templates-request-masterTimeout
        // tag::get-settings-request  
            // end::open-index-execute
        // end::get-settings-defaults-response  
            GetIndexRequest request = new GetIndexRequest("twitter"); // <1>
 * include-tagged::{doc-tests}/IndicesClientDocumentationIT.java[example]
        RestHighLevelClient client = highLevelClient();  
                }
            int failedShards = flushResponse.getFailedShards(); // <3>
            @Override
        RestHighLevelClient client = highLevelClient();
        // tag::get-settings-response
            // tag::update-aliases-request  
        // tag::indices-validate-query-request  
            GetAliasesRequest request = new GetAliasesRequest();
            };  
            final CountDownLatch latch = new CountDownLatch(1);
        }
            // tag::flush-request  
            new ActionListener<AcknowledgedResponse>() {
            OpenIndexResponse openIndexResponse = client.indices().open(request, RequestOptions.DEFAULT);
                null
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;  
        listener = new LatchedActionListener<>(listener, latch);
            assertTrue(acknowledged);
        AcknowledgedResponse deleteTemplateAcknowledge = client.indices().deleteIndexTemplate(deleteRequest, RequestOptions.DEFAULT);  
                public void onResponse(ForceMergeResponse forceMergeResponse) {
                null,
                }
            .boolQuery() // <1>  
            };  
            assertTrue(createIndexResponse.isAcknowledged());  
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        }
            // tag::exists-alias-execute
        // end::indices-put-settings-execute
                    .build()
        RolloverResponse rolloverResponse = client.indices().rollover(request, RequestOptions.DEFAULT);
        {
            // end::update-aliases-execute-listener
                public void onFailure(Exception e) {
                .name("my-template");  
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        // tag::put-template-request-aliases
                    }  
                @Override
            );  
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                    {  
                    @Override  
        // end::put-template-request-masterTimeout
        // end::simulate-index-template-execute-listener  
            CreateIndexResponse createIndexResponse = client.indices()  
        // end::split-index-request-aliases
        {
        CreateIndexRequest req = new CreateIndexRequest("my_index");
        {
 * software distributed under the License is distributed on an
        }
            // end::analyze-execute-async
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                    new ActionListener<CreateIndexResponse>() {  
        {
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>  
                    // <2>  
    }
            // tag::flush-response
        assertTrue(latch.await(30L, TimeUnit.SECONDS));  
 * <p>  
        GetSettingsResponse getSettingsResponse = client.indices().getSettings(request, RequestOptions.DEFAULT);
            String error = response.getError(); // <3>
            GetMappingsRequest request = new GetMappingsRequest(); // <1>  
            request.fieldDataCache(true); // <1>
            new ActionListener<AcknowledgedResponse>() {
        // end::delete-index-template-v2-request
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
                "source_index",  
            request.local(true); // <1>
            // tag::get-alias-request-alias
                @Override
                        // <1>  
            }  
    }
        request.fields("message", "timestamp"); // <3>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
 * (the code indentation of the tag is not included in the width)  
            // end::delete-index-request-masterTimeout
            // tag::get-alias-response-error
        // tag::delete-index-template-v2-response  
            putRequest.settings(Settings.builder().put("index.number_of_shards", 3));
                  "properties": {
                    // <2>  
        }  
        boolean isValid = response.isValid(); // <1>
                .put("index.number_of_shards", 4)); // <1>  
                "some text to analyze"  
            // tag::analyze-index-request
import org.opensearch.common.xcontent.XContentFactory;  
            // end::get-field-mappings-execute-async
    public void testForceMergeIndex() throws Exception {
            // end::templates-exist-execute  
            }
                        """  
            OpenSearchException exception = response.getException(); // <2>  
                    // <1>  
        // tag::get-index-request
            client.indices().getFieldMappingAsync(request, RequestOptions.DEFAULT, listener); // <1>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
            // end::open-index-response
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                    "message": {  
            request.clusterManagerNodeTimeout("1m"); // <2>
        // end::get-index-templates-v2-request-masterTimeout
        }
                    {  
            client.indices().closeAsync(request, RequestOptions.DEFAULT, listener); // <1>  
                          "type": "text"  
        listener = new LatchedActionListener<>(listener, latch);
        // tag::clone-index-response
        listener = new LatchedActionListener<>(listener, latch);
        // end::split-index-response
import java.util.Arrays;
                new CompressedXContent("{ \"properties\": { \"message\": { \"type\": \"text\" } } }"),
            // end::get-mappings-request-indicesOptions
            // end::refresh-execute  
            // tag::delete-alias-execute-listener
            final PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");  
            // end::flush-request
            }  
            // end::put-mapping-request-timeout  
            // end::indices-exists-request-optionals
            @SuppressWarnings("unchecked")
        GetIndexRequest request = new GetIndexRequest("index"); // <1>  
            } catch (OpenSearchException exception) {
            // tag::get-mappings-request
            request.settings(Settings.builder() // <1>  
            ClearIndicesCacheRequest requestMultiple = new ClearIndicesCacheRequest("index1", "index2"); // <2>  
            assertThat(response.getAliases().get("index").iterator().next().alias(), equalTo("alias"));
            ClearIndicesCacheRequest requestAll = new ClearIndicesCacheRequest(); // <3>
import org.opensearch.core.common.unit.ByteSizeUnit;  
                public void onResponse(Boolean exists) {  
            // tag::get-field-mappings-execute-async  
        String numberOfShardsString = getIndexResponse.getSetting("index", "index.number_of_shards"); // <4>
        MappingMetadata indexMappings = getIndexResponse.getMappings().get("index"); // <1>
        // tag::clone-index-execute
            CreateIndexRequest request = new CreateIndexRequest("twitter"); // <1>
            assertTrue(createIndexResponse.isAcknowledged());
        // tag::delete-template-request-masterTimeout  
                request.source(builder); // <1>
        // end::get-index-response  
 *
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
    public void testPutIndexTemplateV2() throws Exception {
import org.opensearch.cluster.metadata.Template;
            boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        assertThat(templates.get("my-template"), is(notNullValue()));
        assertFalse(acknowledged);
import static org.hamcrest.Matchers.hasSize;  
            // end::create-index-execute-async
                new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"), null, null, null, null, null); // <2>
 * You need to wrap your code between two tags like:
            Settings settings = Settings.builder().put("number_of_shards", 3).build();  
            // end::clear-cache-response  
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                    // <1>
        // end::get-index-templates-v2-execute-async  
            request.source("{ \"properties\": { \"message\": { \"type\": \"text\" } } }", MediaTypeRegistry.JSON);
        request.clusterManagerNodeTimeout("1m"); // <2>
            public void onFailure(Exception e) {
        // end::get-templates-execute-listener
        {
}  
                    // <1>
        Map<String, Object> indexTypeMappings = indexMappings.getSourceAsMap(); // <2>
            };
                      "type": "text"  
                public void onResponse(GetSettingsResponse GetSettingsResponse) {
        {  
 * this work for additional information regarding copyright
            assertTrue(acknowledged);
            // tag::close-index-request-masterTimeout  
        listener = new LatchedActionListener<>(listener, latch);
            // tag::create-index-request-masterTimeout
        // Replace the empty listener by a blocking listener in test
                }
        assertEquals("3", numberOfShardsString);
    }
