            CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        // tag::indices-validate-query-execute-async
                AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
        }
    }
            client.indices().existsAliasAsync(request, RequestOptions.DEFAULT, listener); // <1>
        }
            ClearIndicesCacheRequest requestAll = new ClearIndicesCacheRequest(); // <3>
                }
        Template template = new Template(settings, null, null); // <2>
            @Override
                };
        // tag::get-index-templates-v2-request
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
        // tag::get-index-templates-v2-execute-async
            // tag::get-alias-request-alias
            try {
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <2>
              "aliases": {
                }
            // tag::put-index-template-v2-request-settings
            // tag::open-index-request-waitForActiveShards
                    // <1>
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest().name("my-template");
        }
            AcknowledgedResponse putTemplateResponse = client.indices().putIndexTemplate(request, RequestOptions.DEFAULT);
                    // <2>
                public void onFailure(Exception e) {
        {
        }
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            AcknowledgedResponse indicesAliasesResponse = client.indices().updateAliases(request, RequestOptions.DEFAULT);
                null
            new ActionListener<AcknowledgedResponse>() {
        // end::get-field-mappings-request-local
            // tag::flush-execute-async
        // tag::put-template-request-aliases
                        // <1>
                .endObject()
            Map<String, Object> nodes = getAsMap("_nodes");
        request.clusterManagerNodeTimeout("1m"); // <2>
        // tag::delete-index-template-v2-request-masterTimeout
            // end::get-mappings-request
                }
              }
        // tag::delete-index-template-v2-execute-async
        {
 * This class is used to generate the Java Indices API documentation.
            // Use a blocking listener in the test
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        assertEquals(
            listener = new LatchedActionListener<>(listener, latch);
            final CountDownLatch latch = new CountDownLatch(1);
            public void onFailure(Exception e) {
            client.cluster()
        // end::split-index-execute-listener
            listener = new LatchedActionListener<>(listener, latch);
            }
                {
                  "message": {
        // end::get-settings-request-names
                assertTrue(createIndexResponse.isAcknowledged());
    public void testGetFieldMapping() throws IOException, InterruptedException {
        // end::clone-index-request
                        // <2>
        RestHighLevelClient client = highLevelClient();
import java.util.Arrays;
        final CountDownLatch latch = new CountDownLatch(1);
        // tag::split-index-request
        assertFalse(acknowledged);
            GetAliasesResponse response = client.indices().getAlias(request, RequestOptions.DEFAULT);
            // tag::indices-exists-request-optionals
                    // <2>
            String explanationString = explanation.getExplanation(); // <12>
            AliasActions removeAction =
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // end::delete-index-template-v2-execute-async
    }
        {
                client.indices().refresh(request, RequestOptions.DEFAULT);
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
            // tag::get-mappings-execute-async
 */
                {
        // tag::get-index-execute
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::clear-cache-execute
        // tag::delete-index-template-v2-request
            public void onResponse(AcknowledgedResponse updateSettingsResponse) {
            };
import org.opensearch.client.indices.IndexTemplatesExistRequest;
        assertThat(simulateIndexTemplateResponse.resolvedTemplate().settings().get("index.number_of_shards"), is("6")); // <1>
            // tag::analyze-index-request
            DeleteIndexRequest request = new DeleteIndexRequest("posts");
        }
                }
        }
            // tag::get-mappings-request
            listener = new LatchedActionListener<>(listener, latch);
 * Licensed to Elasticsearch under one or more contributor
            ClearIndicesCacheResponse clearCacheResponse = client.indices().clearCache(request, RequestOptions.DEFAULT);
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
                            }
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // end::exists-alias-execute-async
            // end::get-alias-response-error
        );
            Settings settings = Settings.builder().put("number_of_shards", 3).build();
        {
        // end::get-index-templates-v2-request-masterTimeout
 * not use this file except in compliance with the License.
        client.indices().getIndexTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);
                    {
            try {
                // tag::put-mapping-request-source
            // end::get-field-mappings-response
            }
        // Replace the empty listener by a blocking listener in test
                @Override
                if (exception.status() == RestStatus.BAD_REQUEST) {
                new ActionListener<AcknowledgedResponse>() {
        // end::delete-template-response
            } catch (OpenSearchException exception) {
            .boolQuery() // <1>
        // tag::put-template-request-settings
 */
            // Replace the empty listener by a blocking listener in test
                @Override
            RefreshRequest requestMultiple = new RefreshRequest("index1", "index2"); // <2>
            // end::open-index-request
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
            // tag::delete-index-request-masterTimeout
        );
            // tag::flush-request
                  "properties": {
        }
            // end::put-index-template-v2-request-priority
            // end::get-alias-request
            // tag::clear-cache-request
import org.opensearch.client.indices.GetMappingsResponse;
        // tag::split-index-request-settings
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                    // <1>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index1"), RequestOptions.DEFAULT);
import org.opensearch.client.indices.SimulateIndexTemplateResponse;
        request.allShards(true); // <1>
                "some text to analyze"
                      "index.number_of_replicas": "2"
                AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
        {
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                @Override
        final CountDownLatch latch = new CountDownLatch(1);
                OpenIndexRequest request = new OpenIndexRequest("does_not_exist");
            // tag::get-field-mappings-execute-async
                }
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
        // end::shrink-index-request-masterTimeout
        // tag::split-index-request-aliases
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        {
            .filter(QueryBuilders.termQuery("user", "foobar"));
        {
                builder.startObject();
                  }
            CloseIndexRequest request = new CloseIndexRequest("index"); // <1>
                .startObject()
            assertTrue(createIndexResponse.isAcknowledged());
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // end::get-index-templates-v2-request
            // tag::exists-alias-execute-listener
            createIndex("index1", Settings.EMPTY);
            int totalShards = forceMergeResponse.getTotalShards(); // <1>
        RestHighLevelClient client = highLevelClient();
        {
            client.indices().deleteAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // tag::templates-exist-request
            // tag::force-merge-execute-async
            // tag::indices-put-settings-settings-builder
            final GetFieldMappingsResponse.FieldMappingMetadata metadata =
                    // <2>
        request.explain(true); // <1>
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest().name("my-template"); // <1>
        assertNull("refresh_interval returned but was never set!", getSettingsResponse.getSetting("index", "index.refresh_interval"));
        // tag::put-template-execute-listener
            // tag::put-mapping-execute
                    // <2>
 *    http://www.apache.org/licenses/LICENSE-2.0
            createIndex("index1", Settings.EMPTY);
        // end::rollover-index-request-settings
            ForceMergeRequest request = new ForceMergeRequest("index1"); // <1>
                .put("index.number_of_shards", 3)
        RestHighLevelClient client = highLevelClient();
        assertFalse(isRolledOver);
            PutMappingRequest request = new PutMappingRequest("twitter");
                }
            });
            boolean exists = client.indices().existsTemplate(request, RequestOptions.DEFAULT);
        request.names("index.number_of_shards"); // <1>
                }
            @Override
        RestHighLevelClient client = highLevelClient();
            // end::update-aliases-execute-async
            // end::exists-alias-request-alias
                public void onResponse(RefreshResponse refreshResponse) {
            @Override
            XContentBuilder builder = XContentFactory.jsonBuilder();
        // end::put-template-request-version
        {
                    new AliasActions(AliasActions.Type.ADD)
                null
            // tag::create-index-request
                    {
        // tag::clone-index-execute
            // tag::close-index-request-timeout
            // end::open-index-request-waitForActiveShards
        // tag::shrink-index-execute
                request.mapping(builder); // <1>
                        }
            request = AnalyzeRequest.withField("my_index", "my_field", "some text to analyze");
                client.indices().clearCache(request, RequestOptions.DEFAULT);
                @Override
        request.timeout("2m"); // <2>
        }
                }
            // end::force-merge-request-segments-num
            boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
                        // <2>
            Settings settings = Settings.builder() // <1>
            // tag::force-merge-execute-listener
            DefaultShardOperationFailedException[] failures = clearCacheResponse.getShardFailures(); // <4>
        // end::shrink-index-execute-async
            ActionListener<ClearIndicesCacheResponse> listener = new ActionListener<ClearIndicesCacheResponse>() {
    public void testCloneIndex() throws Exception {
            // tag::put-template-request-mappings-json
        {
        // end::rollover-index-request-masterTimeout
                @Override
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
        }
            request.fieldDataCache(true); // <1>
        request.order(20);  // <1>
            public void onFailure(Exception e) {
            // Replace the empty listener by a blocking listener in test
                    }
        request.timeout("2m"); // <2>
            ActionListener<AcknowledgedResponse> listener =
                }
        // end::delete-template-execute-listener
            };
        }
        RestHighLevelClient client = highLevelClient();
        {
                  }
            assertTrue(createIndexResponse.isAcknowledged());
            // end::analyze-field-request
            }
        // tag::get-index-templates-v2-request-masterTimeout
                    // <1>
                "my_normalizer",        // <2>
                // <1>
        final RestHighLevelClient client = highLevelClient();
            // end::update-aliases-request-timeout
    public void testAnalyze() throws IOException, InterruptedException {
            };
import org.opensearch.OpenSearchException;
            DeleteAliasRequest request = new DeleteAliasRequest("index1", "alias2"); // <1>
        // end::get-settings-defaults-response
import org.opensearch.cluster.metadata.AliasMetadata;
            RefreshRequest requestAll = new RefreshRequest(); // <3>
            putRequest.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1));
                }
            // tag::get-alias-request-local
            );
            FlushResponse flushResponse = client.indices().flush(request, RequestOptions.DEFAULT);
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
            AnalyzeRequest request = AnalyzeRequest.buildCustomAnalyzer("standard")  // <2>
            {
        // tag::delete-template-execute
            ActionListener<AcknowledgedResponse> listener =
                        MediaTypeRegistry.JSON);
            request.waitForActiveShards(ActiveShardCount.DEFAULT); // <2>
        // end::split-index-request
        }
        // tag::split-index-request-waitForActiveShards
                        public void onFailure(Exception e) {
            // tag::flush-request-force
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
            // Replace the empty listener by a blocking listener in test
            }
                    message.put("type", "text");
        GetSettingsRequest request = new GetSettingsRequest().indices("index");
            Template template = new Template(Settings.builder().put("index.number_of_replicas", 3).build(), null, null);
import org.opensearch.index.IndexSettings;
            // tag::close-index-response
            // end::clear-cache-request-query
import java.util.Set;
                    // <2>
        String index = "some_index";
    public void testGetMapping() throws IOException {
            };
        // end::get-index-request
                @Override
            // end::analyze-index-normalizer-request
                        "mappings" : {
                .put("index.number_of_replicas", 2)
        // end::shrink-index-execute
        // tag::rollover-index-request
                }
            final Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings =
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
import org.opensearch.action.admin.indices.flush.FlushResponse;
        RestHighLevelClient client = highLevelClient();
        {
        // tag::split-index-execute-async
                    new ActionListener<GetAliasesResponse>() {
            request.waitForActiveShards(ActiveShardCount.DEFAULT); // <2>
        // end::delete-index-template-v2-request
            // tag::put-mapping-response
                    public void onResponse(GetFieldMappingsResponse putMappingResponse) {
    public void testSimulateIndexTemplate() throws Exception {
        ActionListener<SimulateIndexTemplateResponse> listener =
                fieldMappings.get("message");// <3>
            // tag::flush-execute-listener
                builder.endObject();
            String mappings = "{\"properties\":{\"field-1\":{\"type\":\"integer\"}}}";
            // end::refresh-request-indicesOptions
import org.opensearch.client.indices.PutMappingRequest;
        assertThat(acknowledged, equalTo(true));
            OpenSearchException exception = response.getException(); // <2>
import org.opensearch.cluster.metadata.MappingMetadata;
            ); // <2>
                null,
            // tag::create-index-execute-listener
            // end::put-index-template-v2-request-component-template
            // tag::clear-cache-execute-async
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        }
                    }
            // end::put-index-template-v2-request-masterTimeout
        Settings indexSettings = getSettingsResponse.getIndexToSettings().get("index"); // <2>
            request.indexTemplate(composableIndexTemplate);
                @Override
        {
            int totalShards = clearCacheResponse.getTotalShards(); // <1>
                // <2>
        ActionListener<ResizeResponse> listener = new ActionListener<ResizeResponse>() {
                      }
                        @Override
            // end::create-index-whole-source
                client.indices().deleteAlias(request, RequestOptions.DEFAULT);
        RestHighLevelClient client = highLevelClient();
            GetMappingsRequest request = new GetMappingsRequest();
            boolean acknowledged = indicesAliasesResponse.isAcknowledged(); // <1>
                }
                    builder.startObject("properties");
            // end::delete-alias-request
            // tag::put-index-template-v2-request
            client.indices().getMappingAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // tag::split-index-response
            RestStatus status = response.status(); // <1>
            // end::create-index-request-waitForActiveShards
                    // <1>
                    .filter("{\"term\":{\"year\":2016}}"); // <1>
            request.create(false); // make test happy
            Template template = new Template(null, new CompressedXContent(mappingJson), null); // <2>
                // tag::create-index-request-mappings
            GetAliasesRequest requestWithAlias = new GetAliasesRequest("alias1");
            int shardId = explanation.getShard(); // <11>
        {
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
            request.timeout("2m"); // <2>
            request.source("""
        // end::delete-template-request
                    builder.endObject();
                    // <2>
    @SuppressWarnings("unused")
            // tag::flush-request-indicesOptions
                }
        {
            Template template = new Template(null, null, aliases); // <3>
                }
                .addTokenFilter("lowercase")
        }
/**
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
        }
        {
            ClearIndicesCacheRequest requestMultiple = new ClearIndicesCacheRequest("index1", "index2"); // <2>
                      "type": "text"
                    builder.endObject();
            assertTrue(acknowledged);
                    @Override
            // end::clear-cache-request-fielddata
        }
 * <p>
    }
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        // tag::rollover-index-request-waitForActiveShards
                """
            final ActionListener<GetMappingsResponse> latchListener = new LatchedActionListener<>(listener, latch);
            // tag::analyze-response-detail
            assertTrue(exists);
    }
        }
 *
        // end::split-index-request-timeout
        // tag::shrink-index-request
        final CountDownLatch latch = new CountDownLatch(1);
            // end::get-alias-request-indices
            // tag::get-alias-request-indices
            // tag::get-mappings-execute-listener
            request = new CreateIndexRequest("twitter6");
                        // <2>
                public void onResponse(Boolean aBoolean) {
        // end::rollover-index-request
                public void onResponse(FlushResponse flushResponse) {
            } catch (OpenSearchException exception) {
            assertTrue(client.indices().putTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            final CountDownLatch latch = new CountDownLatch(1);
        }
        // end::split-index-execute
            // end::update-aliases-request-masterTimeout
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
 * <p>
            // tag::get-mappings-execute
            // end::update-aliases-response
                .put("index.number_of_shards", 4)); // <1>
            field.put("message", type);
 * KIND, either express or implied.  See the License for the
            putRequest.patterns(Arrays.asList("pattern-1", "log-*"));
            }
        // end::clone-index-request-aliases
                public void onResponse(AcknowledgedResponse response) {
        };
            // tag::delete-alias-response
        }
        ActionListener<ResizeResponse> listener = new ActionListener<ResizeResponse>() {
                null
            }
        assertEquals(Integer.valueOf(3), numberOfShards);
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
        }
        request.setClusterManagerNodeTimeout("1m"); // <2>
        // end::get-templates-request-masterTimeout
            GetIndexRequest request = new GetIndexRequest("twitter"); // <1>
        // end::get-settings-execute
            // end::put-index-template-v2-execute-listener
            MappingMetadata indexMapping = allMappings.get("twitter"); // <2>
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
                null, null, null, 3L, null); // <1>
            //tag::put-template-request-mappings-map
        }
            int totalShards = flushResponse.getTotalShards(); // <1>
        // end::indices-validate-query-execute-listener
                }
                assertTrue(putMappingResponse.isAcknowledged());
            }
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
    public void testDeleteIndexTemplateV2() throws Exception {
        AcknowledgedResponse putTemplateResponse = client.indices().putTemplate(request, RequestOptions.DEFAULT);
                }
            assertNull(tokens);
 * Where example is your tag name.
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;
                MappingMetadata indexMapping = allMappings.get("twitter");
                {
                request.mapping(mapping); // <1>
        }
        request.indicesOptions(IndicesOptions.lenientExpandOpen());
                    // <1>
    public void testForceMergeIndex() throws Exception {
                        "aliases" : {
            };
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
            AliasMetadata placeholderAlias = AliasMetadata.builder("{index}_alias").searchRouting("xyz").build(); // <2>
                @Override
            public void onResponse(RolloverResponse rolloverResponse) {
            assertNotNull(detail.tokenizer());
            });
            containsInAnyOrder("pattern-1", "log-*")); // <2>
        // end::delete-template-execute
        Settings indexSettings = getIndexResponse.getSettings().get("index"); // <5>
 * The OpenSearch Contributors require contributions made to
        assertEquals("3", numberOfShardsString);
            builder.endObject();
            assertTrue(client.indices().putTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // tag::clone-index-response
            DefaultShardOperationFailedException[] failures = refreshResponse.getShardFailures(); // <4>
            // end::get-mappings-execute-async
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged(); // <2>
import org.opensearch.cluster.metadata.ComponentTemplate;
        ActionListener<ValidateQueryResponse> listener =
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            expected.put("properties", field);
                public void onResponse(AcknowledgedResponse deleteIndexResponse) {
                    {
            // end::delete-alias-execute
        // end::clone-index-execute-listener
        // end::put-template-execute-listener
        }
                    // <2>
            request.local(true); // <1>
                        builder.startObject("message");
        // tag::get-templates-response
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                }
                    // <2>
    public void testCreateIndexAsync() throws Exception {
    }
            @Override
        // end::put-template-request-aliases
            client.indices().getAliasAsync(request, RequestOptions.DEFAULT, listener); // <1>
    public void testDeleteIndexAsync() throws Exception {
        // tag::split-index-request-timeout
        {
            AnalyzeResponse response = client.indices().analyze(request, RequestOptions.DEFAULT);
            client.indices().clearCacheAsync(request, RequestOptions.DEFAULT, listener); // <1>
            Template template = new Template(settings, null, null); // <2>
                    .alias("alias1")
                        @Override
        // tag::delete-template-request-masterTimeout
                ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("does_not_exist");
/*
              },
        }
                Map<String, String> type = new HashMap<>();
            // tag::analyze-execute-listener
            // end::flush-execute-listener
            @Override
                public void onResponse(GetIndexTemplatesResponse response) {
        // tag::get-settings-execute
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                {
            // tag::get-mappings-response
            // end::put-index-template-v2-request-aliases
                        }
            ActionListener<AcknowledgedResponse> listener =
        request.alias(new Alias("{index}_alias").searchRouting("xyz"));  // <2>
        // end::get-index-request-indicesOptions
    public void testGetIndexTemplatesV2() throws Exception {
    }
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
                .build("<b>BaR</b>");
                    public void onResponse(AcknowledgedResponse putMappingResponse) {
            // end::put-index-template-v2-request-create
        // tag::get-templates-request
        {
            // tag::create-index-execute
            // tag::put-index-template-v2-request-version
 * this work for additional information regarding copyright
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
    }
                request = new CreateIndexRequest("twitter3");
                client.indices().getFieldMapping(request, RequestOptions.DEFAULT);
            @SuppressWarnings("unchecked")
 * specific language governing permissions and limitations
        {
    public void testOpenIndex() throws Exception {
            // tag::analyze-builtin-request
 * --------------------------------------------------
                fail("should not fail");
            assertTrue(client.indices().putTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            int successfulShards = forceMergeResponse.getSuccessfulShards(); // <2>
            assertTrue(putMappingResponse.isAcknowledged());
        request.includeDefaults(true); // <1>
            request.onlyExpungeDeletes(true); // <1>
    public void testClearCache() throws Exception {
            ComposableIndexTemplate composableIndexTemplate =
                          }
        }
        request.getTargetIndexRequest().settings(Settings.builder()
                    {
        {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        client.indices().getSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>
            new ActionListener<GetIndexResponse>() {
                    public void onResponse(GetMappingsResponse putMappingResponse) {
        // Replace the empty listener by a blocking listener in test
        request.setResizeType(ResizeType.CLONE); // <2>
            // tag::indices-put-settings-settings-source
            public void onResponse(ResizeResponse resizeResponse) {
            // tag::refresh-execute-listener
        RestHighLevelClient client = highLevelClient();
                    }
            ActionListener<AcknowledgedResponse> listener =
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("my-template"); // <1>
                Map<String, Object> expected = new HashMap<>();
            // end::put-index-template-v2-execute
            new ActionListener<GetIndexTemplatesResponse>() {
                    // <1>
                Map<String, MappingMetadata> allMappings = r.mappings();
        UpdateSettingsRequest request = new UpdateSettingsRequest("index1"); // <1>
            putRequest.settings(Settings.builder().put("index.number_of_shards", 3));
            ActionListener<ForceMergeResponse> listener = new ActionListener<ForceMergeResponse>() {
        assertTrue(indexAliases.isEmpty());
                    builder.startObject("properties");
                    }
                client.indices().flush(request, RequestOptions.DEFAULT);
            .put("index.number_of_shards", 3)
        GetSettingsRequest request = new GetSettingsRequest().indices("index"); // <1>
            // end::create-index-execute-listener
        {
            // Replace the empty listener by a blocking listener in test
            client.indices().updateAliasesAsync(request, RequestOptions.DEFAULT, listener); // <1>
                    @Override
        // end::put-template-request-create
            public void onFailure(Exception e) {}
            // tag::flush-response
        listener = new LatchedActionListener<>(listener, latch);
                .name("my-template");
        // tag::indices-put-settings-request-indicesOptions
                    public void onFailure(Exception e) {
        final CountDownLatch latch = new CountDownLatch(1);
            // tag::analyze-custom-normalizer-request
            // Replace the empty listener by a blocking listener in test
                @Override
        // end::clone-index-request-timeout
        }
        {
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
 * // tag::example
import org.opensearch.core.xcontent.MediaTypeRegistry;
                null,
                @Override
            // end::create-index-request-masterTimeout
            new ActionListener<AcknowledgedResponse>() {
                            "number_of_replicas" : 0
        // tag::clone-index-request
        }
                    @Override
            {
        // tag::shrink-index-request-masterTimeout
                public void onFailure(Exception e) {
                @Override
        {
        GetComposableIndexTemplatesResponse getTemplatesResponse = client.indices().getIndexTemplate(request, RequestOptions.DEFAULT);
        client.indices().putTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
        }
            // tag::indices-exists-execute-listener
        assertEquals("index-1", oldIndex);
        // end::get-index-execute-listener
        {
        RolloverResponse rolloverResponse = client.indices().rollover(request, RequestOptions.DEFAULT);
                }
                        builder.endObject();
            listener = new LatchedActionListener<>(listener, latch);
            ActionListener<AnalyzeResponse> listener = new ActionListener<AnalyzeResponse>() {
                .build("<b>Some text to analyze</b>");
 * the Apache License, Version 2.0 (the "License"); you may
            public void onFailure(Exception e) {
        boolean acknowledged = rolloverResponse.isAcknowledged(); // <1>
            @Override
                    public void onFailure(Exception e) {
 * compatible open source license.
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(
            // end::analyze-index-request
                }
            // end::indices-put-settings-settings-source
            AliasActions aliasAction = new AliasActions(AliasActions.Type.ADD).index("index1").alias("async");
            // end::get-alias-execute-listener
            // tag::put-mapping-execute-async
            }
        final CountDownLatch latch = new CountDownLatch(1);
        boolean shardsAcked = resizeResponse.isShardsAcknowledged(); // <2>
            request.humanReadable(true); // <2>
                    {
            );
            // tag::delete-index-request-indicesOptions
                }
        // end::shrink-index-response
            // tag::open-index-execute-async
            ForceMergeRequest requestMultiple = new ForceMergeRequest("index1", "index2"); // <2>
            assertTrue(createIndexResponse.isAcknowledged());
        request = new GetComposableIndexTemplateRequest("my-*"); // <2>
            // tag::delete-alias-request-timeout
                @Override
            {
            // tag::get-mappings-request-masterTimeout
            RequestOptions.DEFAULT);
 */
                    public void onFailure(Exception e) {
                    "message": {
    }
            // tag::delete-alias-execute-async
        }
                @Override
            listener = new LatchedActionListener<>(listener, latch);
                //end::create-index-mappings-map
        }
                field.put("message", type);
            // end::delete-alias-execute-listener
            // end::get-alias-request-local
        ActionListener<RolloverResponse> listener = new ActionListener<RolloverResponse>() {
            };
        request.includeDefaults(true); // <1>
        // end::get-settings-execute-listener
 * GitHub history for details.
                        builder.field("type", "text");
                .startObject("my_field")
                .putComponentTemplate(
            client.indices().refreshAsync(request, RequestOptions.DEFAULT, listener); // <1>
        Settings settings = Settings.builder().put("index.number_of_shards", 6).build();
        ValidateQueryRequest request = new ValidateQueryRequest(index); // <1>
                DeleteIndexRequest request = new DeleteIndexRequest("does_not_exist");
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        }
        {
            // end::open-index-request-timeout
        // end::clone-index-response
        // Replace the empty listener by a blocking listener in test
            // end::force-merge-response
            AliasActions addIndexAction =
            // end::create-index-execute
        // tag::indices-put-settings-request
            request.indexTemplate(composableIndexTemplate);
            aliases.put("twitter_alias", twitterAlias);
 * SPDX-License-Identifier: Apache-2.0
    public void testRolloverIndex() throws Exception {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            Map<String, Set<AliasMetadata>> aliases = response.getAliases(); // <1>
            // tag::create-index-execute-async
        // tag::get-settings-execute-listener
            };
                """
        // tag::get-index-execute-async
            AcknowledgedResponse indicesAliasesResponse =
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            AliasActions aliasAction = new AliasActions(AliasActions.Type.ADD).index("index1").alias("alias1");
            // end::create-index-response
                };
        // tag::delete-template-request
            // end::delete-index-request-timeout
        {
        };
    }
 * // end::example
        AcknowledgedResponse pmResp = client.indices().putMapping(pmReq, RequestOptions.DEFAULT);
            ComponentTemplate componentTemplate = new ComponentTemplate(template, null, null);
 * under the License.
        {
                    public void onResponse(org.opensearch.client.core.AcknowledgedResponse deleteAliasResponse) {
            // Replace the empty listener by a blocking listener in test
    @SuppressWarnings("unused")
            final CountDownLatch latch = new CountDownLatch(1);
                }
            }
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                request = new CreateIndexRequest("twitter2");
        // end::split-index-request-settings
                    new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"), null,
        // end::put-template-request
        // tag::clone-index-request-waitForActiveShards
            final CountDownLatch latch = new CountDownLatch(1);
        }
                @Override
            // tag::force-merge-request-segments-num
            }, e -> {
                .mapping(mappings, MediaTypeRegistry.JSON);
    }
        boolean acknowledged = resizeResponse.isAcknowledged(); // <1>
            new ActionListener<GetSettingsResponse>() {
                template, null, null, null, null); // <3>
        // end::indices-put-settings-response
            // end::close-index-request
        RestHighLevelClient client = highLevelClient();
                @Override
        request.dryRun(true); // <1>
            ForceMergeRequest requestAll = new ForceMergeRequest(); // <3>
        }
            assertTrue(createIndexResponse.isAcknowledged());
        boolean acknowledged = resizeResponse.isAcknowledged(); // <1>
                MediaTypeRegistry.JSON);
                //end::put-mapping-xcontent
            // tag::put-index-template-v2-execute-listener
        assertFalse(shardsAcked);
            assertTrue(createIndexResponse.isAcknowledged());
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
        // tag::split-index-execute
                }
    }
        // tag::get-settings-response
        request = new GetIndexTemplatesRequest("template-1", "template-2"); // <2>
        }
        }
                .field("type", "text")
        {
                    }
                builder.startObject();
            // tag::put-index-template-v2-response
            );
            assertTrue(putMappingResponse.isAcknowledged());
        // end::shrink-index-request-timeout
        // tag::rollover-index-response
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            // tag::templates-exist-execute-async
            // tag::delete-index-execute-listener
                          "type": "text"
            };
            // end::delete-index-notfound
        final CountDownLatch latch = new CountDownLatch(1);
            // tag::refresh-request
import org.opensearch.client.indices.GetIndexTemplatesRequest;
            // tag::get-field-mappings-response
                @Override
            request.indexTemplate(composableIndexTemplate);
            listener = new LatchedActionListener<>(listener, latch);
        {
                    // <2>
        RestHighLevelClient client = highLevelClient();
            FlushRequest requestMultiple = new FlushRequest("index1", "index2"); // <2>
                @Override
            // end::delete-index-execute
            request.source("{ \"properties\": { \"message\": { \"type\": \"text\" } } }", MediaTypeRegistry.JSON);
                @Override
                }
        SimulateIndexTemplateRequest simulateRequest = new SimulateIndexTemplateRequest("log-000001"); // <1>
                        "timestamp": {
                }
        assertTrue(acknowledged);
            // tag::open-index-notfound
        RestHighLevelClient client = highLevelClient();
                }
        // tag::rollover-index-request-settings
        {
        boolean shardsAcked = resizeResponse.isShardsAcknowledged(); // <2>
                          "type": "text"
            boolean acknowledged = createIndexResponse.isAcknowledged(); // <1>
                @Override
                new UpdateSettingsRequest("index1", "index2"); // <2>
        // tag::simulate-index-template-execute-listener
import java.util.Map;
        RestHighLevelClient client = highLevelClient();
            try {
            request.settings(settingsBuilder); // <1>
                        public void onResponse(GetAliasesResponse getAliasesResponse) {
            // tag::exists-alias-execute
import org.opensearch.client.indices.GetComposableIndexTemplatesResponse;
        int totalShards = response.getTotalShards(); // <2>
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                    new ActionListener<AcknowledgedResponse>() {
            assertTrue(createIndexResponse.isAcknowledged());
import static org.hamcrest.Matchers.notNullValue;
            @Override
            request.attributes("keyword", "type");      // <2>
 * Unless required by applicable law or agreed to in writing,
            assertTrue(createIndexResponse.isAcknowledged());
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("index").settings(settings)
                Map<String, Object> message = new HashMap<>();
            // tag::update-aliases-execute-async
            // tag::get-alias-response-error
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                Arrays.asList("pattern-1", "log-*"),
        assertEquals(IndexSettings.DEFAULT_REFRESH_INTERVAL, time);
            assertThat(error, nullValue());
            // end::indices-exists-execute-listener
        // end::get-templates-response
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            listener = new LatchedActionListener<>(listener, latch);
        }
                latchListener.onResponse(r);
                    // <1>
        assertThat(templates.get("my-template"), is(notNullValue()));
            request.requestCache(true); // <1>
                        {
            createIndex("source_index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
            // tag::put-index-template-v2-request-masterTimeout
        // end::get-templates-execute-async
            }
    public void testUpdateAliases() throws Exception {
        assertThat(acknowledged, equalTo(true));
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(
                }
        listener = new LatchedActionListener<>(listener, latch);
                    // <1>
        request.local(true); // <1>
            PutComposableIndexTemplateRequest putRequest = new PutComposableIndexTemplateRequest().name("my-template")
        boolean acknowledged = resizeResponse.isAcknowledged(); // <1>
                    .index("index4"); // <4>
    public void testPutIndexTemplateV2() throws Exception {
            // end::analyze-execute
            {
            assertTrue(createIndexResponse.isAcknowledged());
        // end::indices-validate-query-request
                public void onFailure(Exception e) {
            // end::analyze-request-explain
                // end::create-index-request-mappings
        // end::get-settings-execute-async
                @Override
            // tag::get-mappings-request-indicesOptions
                    // <2>
            client.indices().putIndexTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
            DetailAnalyzeResponse detail = response.detail();                   // <1>
                    {
        boolean acknowledged = updateSettingsResponse.isAcknowledged(); // <1>
        // end::split-index-request-waitForActiveShards
        GetFieldMappingsRequest request = new GetFieldMappingsRequest(); // <1>
                .create(new CreateIndexRequest("index").alias(new Alias("alias")), RequestOptions.DEFAULT);
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            createIndexResponse = client.indices().create(new CreateIndexRequest("index3"), RequestOptions.DEFAULT);
            putRequest.patterns(Arrays.asList("pattern-1", "log-*"));
        // tag::indices-put-settings-execute
    }
        // tag::indices-put-settings-request-index-settings
                // <1>
                }
                    }
                    new ActionListener<OpenIndexResponse>() {
        // end::split-index-response
            // tag::analyze-request-explain
        request.setWaitForActiveShards(2); // <1>
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
        Settings settings =
                .put("index.number_of_replicas", 1)
        ActionListener<AcknowledgedResponse> listener =
            type.put("type", "text");
            // end::open-index-notfound
        Map<String, ComposableIndexTemplate> templates = getTemplatesResponse.getIndexTemplates(); // <1>
            request = new IndexTemplatesExistRequest("template-1", "template-2"); // <2>
        }
import org.opensearch.client.indices.GetFieldMappingsResponse;
                null,
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
                new ActionListener<GetMappingsResponse>() {
        // end::get-templates-request
                //tag::create-index-mappings-xcontent
            @Override
            // end::put-index-template-v2-request
                @Override
    }
        client.indices().deleteIndexTemplateAsync(deleteRequest, RequestOptions.DEFAULT, listener); // <1>
        // tag::delete-template-response
    }
        RestHighLevelClient client = highLevelClient();
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
            ); // <2>
        request.alias(new Alias("twitter_alias").filter(QueryBuilders.termQuery("user", "foobar")));  // <1>
            // end::delete-index-request-masterTimeout
import org.opensearch.action.admin.indices.flush.FlushRequest;
            PutMappingRequest request = new PutMappingRequest("twitter");
        // end::put-template-request-settings
        String refreshInterval = getSettingsResponse.getSetting("index", "index.refresh_interval"); // <1>
                        builder.endObject();
        }
                    }
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
                    .put(settingKey, settingValue);
        {
                            "twitter_alias" : {}
                    // <1>
        ActionListener<GetIndexResponse> listener =
            // tag::delete-index-response
            // tag::delete-alias-execute-listener
                if (exception.status() == RestStatus.NOT_FOUND) {
    }
        List<AliasMetadata> indexAliases = getIndexResponse.getAliases().get("index"); // <3>
                latchListener.onFailure(e);
import org.opensearch.cluster.metadata.Template;
        request.create(true);  // <1>
            // end::get-mappings-request-indicesOptions
        // tag::indices-validate-query-request-allShards
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
    public void testShrinkIndex() throws Exception {
                    builder.endObject();
            // tag::close-index-execute
        listener = new LatchedActionListener<>(listener, latch);
                assertTrue(createIndexResponse.isAcknowledged());
                public void onResponse(GetSettingsResponse GetSettingsResponse) {
        client.indices().shrinkAsync(request, RequestOptions.DEFAULT, listener); // <1>
        }
                    MediaTypeRegistry.JSON);
        {
            createIndex(
        TimeValue time = getIndexResponse.getDefaultSettings().get("index")
            // end::analyze-custom-request
            request = new IndexTemplatesExistRequest("my-*"); // <3>
            }
            request.indicesOptions(IndicesOptions.strictExpandOpen()); // <1>
                    // <1>
            }
                // <2>
            assertTrue(acknowledged);
                    .alias("alias2")
            // end::open-index-execute
        // end::split-index-request-aliases
        {
            // end::analyze-custom-normalizer-request
            request = new IndexTemplatesExistRequest("my-template"); // <1>
            // tag::create-index-request-masterTimeout
                public void onFailure(Exception e) {
        request.settings(settings);
        // tag::get-index-request-includeDefaults
        // tag::indices-validate-query-request-rewrite
                  "properties": {
            int failedShards = forceMergeResponse.getFailedShards(); // <3>
            AliasActions aliasAction =
            // Replace the empty listener by a blocking listener in test
        RestHighLevelClient client = highLevelClient();
            // tag::force-merge-response
            String error = response.getError(); // <3>
            boolean acknowledged = putMappingResponse.isAcknowledged(); // <1>
            // tag::open-index-execute
                }
import static org.hamcrest.Matchers.containsInAnyOrder;
    }
            //end::put-template-request-mappings-map
    }
            // tag::put-mapping-execute-listener
                        }
            // end::put-mapping-request
                final Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldMappings = mappings.get("twitter");
        }
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        RestHighLevelClient client = highLevelClient();
            listener = new LatchedActionListener<>(listener, latch);
            assertThat(exception, nullValue());
            // tag::get-alias-execute
                    // <1>
        request = new GetIndexTemplatesRequest("my-*"); // <3>
            listener = new LatchedActionListener<>(listener, latch);
                    .alias("alias1"); // <2>
            );
        // tag::simulate-index-template-request
            listener = new LatchedActionListener<>(listener, latch);
        GetSettingsResponse getSettingsResponse = client.indices().getSettings(request, RequestOptions.DEFAULT);
        {
            };
                }
                message.put("type", "text");
                    "message": {
                public void onResponse(OpenIndexResponse openIndexResponse) {
                latchListener.onResponse(r);
            assertTrue(createIndexResponse.isAcknowledged());
            boolean exists = client.indices().existsAlias(request, RequestOptions.DEFAULT);
                public void onFailure(Exception e) {
        assertTrue(shardsAcked);
                @Override
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.indexTemplate(composableIndexTemplate);
            // end::close-index-execute-async
                    }""", // <1>
        GetIndexRequest request = new GetIndexRequest("index"); // <1>
                client.indices().forcemerge(request, RequestOptions.DEFAULT);
            // end::create-index-request-timeout
                .put("index.number_of_shards", 3)
        // tag::get-templates-request-masterTimeout
                XContentBuilder builder = XContentFactory.jsonBuilder();
                request.source(
        // end::get-index-templates-v2-execute-listener
            AnalyzeRequest request = AnalyzeRequest.withIndexAnalyzer(
            public void onFailure(Exception e) {
        // Replace the empty listener by a blocking listener in test
        ResizeResponse resizeResponse = client.indices().clone(request, RequestOptions.DEFAULT);
        // tag::indices-put-settings-create-settings
            //tag::put-template-request-mappings-xcontent
            // tag::delete-alias-execute
            Map<String, Object> expected = new HashMap<>();
                Map<String, Object> field = new HashMap<>();
        };
            // end::get-alias-execute
 */
            .must(QueryBuilders.queryStringQuery("*:*"))
                    // <1>
            // Replace the empty listener by a blocking listener in test
                        // <1>
            aliases.put("{index}_alias", placeholderAlias);
            putRequest.patterns(Arrays.asList("pattern-1", "log-*"));
        request.getCreateIndexRequest().waitForActiveShards(ActiveShardCount.DEFAULT); // <2>
                    }
            // end::get-alias-response
                public void onResponse(ForceMergeResponse forceMergeResponse) {
                "source_index",
        // end::put-template-execute-async
import org.opensearch.client.RequestOptions;
    }
            Template template = new Template(
                "source_index",
        SimulateIndexTemplateResponse simulateIndexTemplateResponse = client.indices().simulateIndexTemplate(simulateRequest,
        request.setWaitForActiveShards(ActiveShardCount.DEFAULT); // <2>
            // end::refresh-execute-async
        final CountDownLatch latch = new CountDownLatch(1);
        request.rewrite(true); // <1>
            .put("index.number_of_replicas", 1)
        }
            try {
        assertThat(templates.size(), is(1));
                expected.put("properties", field);
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
            client.indices().putMappingAsync(request, RequestOptions.DEFAULT, listener); // <1>
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                public void onFailure(Exception e) {
        request.query(builder); // <2>
        request.setWaitForActiveShards(2); // <1>
            // end::templates-exist-execute
        assertTrue(shardsAcked);
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        // end::get-index-templates-v2-execute-async
            PutMappingRequest request = new PutMappingRequest("twitter");
                Settings.builder()
            };
            request.force(true); // <1>
            // tag::get-alias-request-indicesOptions
            // end::delete-alias-execute-async
        // tag::get-index-templates-v2-response
        assertTrue(isDryRun);
            request.indexTemplate(composableIndexTemplate);
            new ActionListener<ValidateQueryResponse>() {
        // tag::put-template-execute
            map.put(settingKey, settingValue);
            // end::delete-alias-request-masterTimeout
        }
                .startObject("properties")
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            listener = new LatchedActionListener<>(listener, latch);
        ActionListener<GetComposableIndexTemplatesResponse> listener =
                }
            assertThat(response.getAliases().get("index").size(), equalTo(1));
            // tag::close-index-request-masterTimeout
                MediaTypeRegistry.JSON
              "order": 1,
                assertTrue(createIndexResponse.isAcknowledged());
            assertThat(mapping, equalTo(expected));
            // end::get-mappings-execute-listener
    @SuppressWarnings("unused")
        Settings indexSettings = getSettingsResponse.getIndexToSettings().get("index");
                      "properties": {
        Integer numberOfShards = indexSettings.getAsInt("index.number_of_shards", null); // <6>
                public void onFailure(Exception e) {
        boolean acknowledged = deleteTemplateAcknowledge.isAcknowledged(); // <1>
                    // <2>
            template, null, 90L, null, null);
        request.setWaitForActiveShards(ActiveShardCount.DEFAULT); // <2>
    @SuppressWarnings("unused")
            // tag::update-aliases-response
            // end::update-aliases-request2
            // tag::delete-index-request-timeout
                        {
import org.opensearch.client.indices.SimulateIndexTemplateRequest;
            request.local(true); // <1>
            CreateIndexRequest request = new CreateIndexRequest("twitter");
            // tag::create-index-request-timeout
            {
            // tag::analyze-field-request
        // end::get-field-mappings-request
            final Map<String, Object> source = metadata.sourceAsMap(); // <5>
                .addTokenFilter(stopFilter)     // <5>
            String firstNode = ((Map<String, Object>) nodes.get("nodes")).keySet().iterator().next();
                            // <2>
            request.source(
                new ActionListener<AcknowledgedResponse>() {
            // tag::get-alias-execute-async
        }
            // tag::create-index-request-aliases
        // tag::get-index-execute-listener
        request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
 * --------------------------------------------------
            ActionListener<org.opensearch.client.core.AcknowledgedResponse> listener =
                    "type": "text"
                @Override
            }, e -> {
            };
        client.indices().getIndexTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
        request.fields("message", "timestamp"); // <3>
                };
            AliasActions removeIndexAction =
        client.indices().rolloverAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::exists-alias-execute
        {
                    // <2>
        assertTrue(acknowledged);
            request = new CreateIndexRequest("twitter5");
import org.opensearch.client.indices.PutIndexTemplateRequest;
        {
                    .routing("1"); // <2>
        {
        // Replace the empty listener by a blocking listener in test
            };
        // end::get-index-execute
                Map<String, Object> message = new HashMap<>();
            int successfulShards = flushResponse.getSuccessfulShards(); // <2>
                    Settings.builder()
                    // <1>
 * You need to wrap your code between two tags like:
            // tag::update-aliases-request-timeout
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
/*
                final Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings = r.mappings();
        {
            // end::analyze-execute-async
        final CountDownLatch latch = new CountDownLatch(1);
            .put("index.number_of_shards", 2)); // <1>
        {
                client.indices().putSettings(request, RequestOptions.DEFAULT);
            // end::force-merge-request-flush
            request.addAliasAction(aliasAction); // <3>
        );
                        }
        // end::indices-put-settings-request-masterTimeout
                }
import org.opensearch.client.indices.CreateIndexRequest;
            // tag::refresh-execute-async
            // tag::update-aliases-request
            CreateIndexRequest request = new CreateIndexRequest("twitter"); // <1>
                    }
                    // <1>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);
import org.opensearch.client.indices.IndexTemplateMetadata;
            assertTrue(putMappingResponse.isAcknowledged());
                @Override
            // end::refresh-response
        // Replace the empty listener by a blocking listener in test
        {
            request.source("{ \"properties\": { \"message\": { \"type\": \"text\" } } }", MediaTypeRegistry.JSON);
            // end::delete-index-execute-listener
    }
import org.opensearch.client.indices.AnalyzeRequest;
            CreateIndexResponse createIndexResponse = client.indices()
            }
        final CountDownLatch latch = new CountDownLatch(1);
        request.setWaitForActiveShards(2); // <1>
        {
            // Replace the empty listener by a blocking listener in test
        }
            AnalyzeRequest request = AnalyzeRequest.withNormalizer(
        listener = new LatchedActionListener<>(listener, latch);
    }
            final CountDownLatch latch = new CountDownLatch(1);
        request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
            boolean acknowledged = putTemplateResponse.isAcknowledged(); // <1>
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;
            // tag::open-index-request-timeout
            assertTrue(acknowledged);
        String newIndex = rolloverResponse.getNewIndex(); // <4>
        final CountDownLatch latch = new CountDownLatch(1);
        // tag::delete-index-template-v2-execute
        }
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        ResizeResponse resizeResponse = client.indices().shrink(request, RequestOptions.DEFAULT);
            int failedShards = clearCacheResponse.getFailedShards(); // <3>
        // tag::get-field-mappings-request-local
            };
        // end::delete-template-execute-async
        // end::indices-put-settings-request-timeout
            // end::refresh-execute
        request.indices("twitter"); // <2>
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("posts"), RequestOptions.DEFAULT);
        PutMappingRequest pmReq = new PutMappingRequest("my_index").source(
            // tag::update-aliases-request2
            // tag::templates-exist-execute-listener
                    }""", // <1>
            updateIndexSettings("source_index", Settings.builder().put("index.blocks.write", true));
        }
                }
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
                    """
            // end::force-merge-execute-listener
        // tag::split-index-request-masterTimeout
        assertEquals(Integer.valueOf(3), numberOfShards);
            // end::indices-put-settings-settings-map
            // end::get-field-mappings-execute-async
    public void testDeleteTemplate() throws Exception {
            request.maxNumSegments(1); // <1>
                // <1>
        listener = new LatchedActionListener<>(listener, latch);
            @Override
            // end::delete-alias-response
        listener = new LatchedActionListener<>(listener, latch);
                .addCharFilter("html_strip")    // <3>
        {
            // tag::create-index-request-settings
        // tag::rollover-index-execute-listener
            // tag::indices-exists-request
        // end::rollover-index-request-alias
                if (exception.status() == RestStatus.NOT_FOUND) {
                    .index("index3")
                }
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("posts"), RequestOptions.DEFAULT);
            {
            // tag::get-field-mappings-execute-listener
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
        // end::indices-validate-query-request-explain
        // tag::shrink-index-response
            IndicesAliasesRequest request = new IndicesAliasesRequest();
            request.queryCache(true); // <1>
            assertTrue(acknowledged);
            // use a built-in analyzer in the test
            // tag::exists-alias-request-indices
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            request.clusterManagerNodeTimeout("1m"); // <2>
                      "properties": {
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                // <1>
            PutMappingRequest request = new PutMappingRequest("twitter"); // <1>
        // tag::get-index-response
            createIndexResponse = client.indices().create(new CreateIndexRequest("index4"), RequestOptions.DEFAULT);
        // tag::indices-put-settings-request-masterTimeout
            DeleteAliasRequest request = new DeleteAliasRequest("index1", "alias1");
    @SuppressWarnings("unused")
            client.indices().deleteAliasAsync(request, RequestOptions.DEFAULT, listener); // <1>
    }
                public void onFailure(Exception e) {
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
            // tag::delete-alias-request-masterTimeout
                }
            client.indices().getFieldMappingAsync(request, RequestOptions.DEFAULT, listener); // <1>
        }
        ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("log-*"),
                public void onFailure(Exception e) {
                builder.endObject();
            }
            GetAliasesRequest request = new GetAliasesRequest();
        // tag::get-index-templates-v2-execute
                if (exception.status() == RestStatus.NOT_FOUND) {
            stopFilter.put("stopwords", new String[]{ "to" });  // <1>
                }
        {
import org.opensearch.action.admin.indices.validate.query.QueryExplanation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            AcknowledgedResponse deleteIndexResponse = client.indices().delete(request, RequestOptions.DEFAULT);
                    .index("index1")
            IndicesAliasesRequest request = new IndicesAliasesRequest(); // <1>
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        // end::get-index-templates-v2-response
        // end::rollover-index-execute-listener
            // tag::indices-exists-execute
                    // <1>
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
        {
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(
        // end::get-settings-request-include-defaults
            @Override
        ResizeRequest request = new ResizeRequest("target_index","source_index"); // <1>
            Map<String, Object> field = new HashMap<>();
                }"""; // <1>
        {
                }
import org.opensearch.client.indices.GetIndexRequest;
            // tag::refresh-notfound
            // end::refresh-execute-listener
              "mappings": {
            }
        {
            );
        boolean acknowledged = deleteTemplateAcknowledge.isAcknowledged(); // <1>
                        }
            // tag::exists-alias-request
    }
                }
                        // <2>
            listener = ActionListener.wrap(r -> {
                public void onResponse(AnalyzeResponse analyzeTokens) {
                              "type": "text"
            // end::get-mappings-execute
                }
import org.opensearch.action.admin.indices.shrink.ResizeRequest;
            // set only expunge deletes back to its default value
                "{index}-alias": {}
        assertTrue(resp.isAcknowledged());
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            org.opensearch.client.core.AcknowledgedResponse deleteAliasResponse =
                new CompressedXContent("{ \"properties\": { \"message\": { \"type\": \"text\" } } }"),
                public void onFailure(Exception e) {
            } catch (OpenSearchException exception) {
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        // tag::shrink-index-request-aliases
            // end::get-alias-request-alias
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
            // end::get-field-mappings-execute-listener
                    new PutComponentTemplateRequest().name("ct1").componentTemplate(componentTemplate),
            request.aliases("alias"); // <1>
                null,
                .create(new CreateIndexRequest("index").settings(settings), RequestOptions.DEFAULT);
        {
        request.getCreateIndexRequest().settings(Settings.builder()
            // tag::clear-cache-request-fielddata
            Settings settings = Settings.builder().put("number_of_shards", 3).build();
            // tag::create-index-response
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        // Replace the empty listener by a blocking listener in test
        // tag::put-template-response
            request.addAliasAction(aliasAction);
            // end::put-mapping-execute-listener
                .name("my-template");
                    // <1>
        // end::rollover-index-execute
    public void testDeleteAlias() throws Exception {
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        {
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
                .create(new CreateIndexRequest("index").alias(new Alias("alias")), RequestOptions.DEFAULT);
        RestHighLevelClient client = highLevelClient();
                    // <2>
        RestHighLevelClient client = highLevelClient();
            RefreshRequest request = new RefreshRequest("index1"); // <1>
    public void testRefreshIndex() throws Exception {
            // end::flush-request-force
        }
        // end::put-template-request-masterTimeout
        // end::put-template-request-order
        {
                @Override
        // tag::rollover-index-execute
        }
            request.addAliasAction(aliasAction);
                }
            final CountDownLatch latch = new CountDownLatch(1);
                ForceMergeRequest request = new ForceMergeRequest("does_not_exist");
                    public void onFailure(Exception e) {
        request.clusterManagerNodeTimeout("1m"); // <2>
        {
                    // <2>
                }
                @Override
        }
                // <2>
        }
            GetAliasesRequest requestWithAlias = new GetAliasesRequest("alias1");
                    // <1>
            // tag::delete-alias-request
                            // <1>
        // tag::get-settings-defaults-response
            GetMappingsRequest request = new GetMappingsRequest(); // <1>
        // tag::get-settings-request
        }
    public void testPutMappingAsync() throws Exception {
                    }
            // tag::refresh-request-indicesOptions
        listener = new LatchedActionListener<>(listener, latch);
                        """
        // end::clone-index-request-waitForActiveShards
        {
            ActionListener<CloseIndexResponse> listener = new ActionListener<CloseIndexResponse>() {
        Settings indexDefaultSettings = getSettingsResponse.getIndexToDefaultSettings().get("index"); // <2>
        boolean isValid = response.isValid(); // <1>
import static org.hamcrest.Matchers.hasSize;
                Map<String, Object> jsonMap = new HashMap<>();
            AcknowledgedResponse closeIndexResponse = client.indices().close(request, RequestOptions.DEFAULT);
                    // <2>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::exists-alias-request-alias
        String numberOfShardsString = getIndexResponse.getSetting("index", "index.number_of_shards"); // <4>
            // tag::analyze-execute-async
            listener = ActionListener.wrap(r -> {
        request.setResizeType(ResizeType.SPLIT); // <2>
        }
                    new AliasActions(AliasActions.Type.ADD)
        // tag::clone-index-execute-async
                latchListener.onFailure(e);
                }
                String failedIndex = failure.index(); // <6>
        DeleteIndexTemplateRequest request = new DeleteIndexTemplateRequest();
import org.opensearch.core.rest.RestStatus;
import java.util.List;
                    """
        newIndexTemplateRequest.indexTemplate(composableIndexTemplate);
                @Override
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.waitForActiveShards(2); // <1>
                public void onResponse(AcknowledgedResponse indicesAliasesResponse) {
            createIndex("index", Settings.EMPTY);
            assertTrue(shardsAcknowledged);
            // end::put-index-template-v2-request-settings
            // end::force-merge-request
                    new ActionListener<AcknowledgedResponse>() {
                    @Override
        {
                template, null, null, null, null); // <3>
    }
                          "type": "date"
        // tag::put-template-request-version
            };
              },
    }
        assertEquals("3", numberOfShardsString);
            request.timeout("2m"); // <2>
                """
        // tag::clone-index-request-timeout
            CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
                .endObject()
        }
import org.opensearch.common.settings.Settings;
    }
        request.getTargetIndexRequest().settings(Settings.builder()
            };
            final CountDownLatch latch = new CountDownLatch(1);
                @Override
                            builder.field("type", "text");
        }
            assertTrue(createIndexResponse.isAcknowledged());
                public void onFailure(Exception e) {
                    .put("index.number_of_replicas", 0)
        {
        request.getCreateIndexRequest().waitForActiveShards(ActiveShardCount.from(2)); // <1>
        listener = new LatchedActionListener<>(listener, latch);
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
            ComposableIndexTemplate composableIndexTemplate =
            updateIndexSettings(
            OpenIndexRequest request = new OpenIndexRequest("index"); // <1>
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        }
                //tag::put-mapping-xcontent
                if (exception.status() == RestStatus.NOT_FOUND) {
                };
                    .index("index1")
            // tag::open-index-request-indicesOptions
        RestHighLevelClient client = highLevelClient();
        listener = new LatchedActionListener<>(listener, latch);
        assertEquals(Integer.valueOf(3), numberOfShards);
            FlushRequest request = new FlushRequest("index1"); // <1>
            // end::clear-cache-request
            // end::close-index-request-indicesOptions
                Map<String, Object> properties = new HashMap<>();
                @Override
        // end::rollover-index-request-mapping
    }
            // tag::clear-cache-request-indicesOptions
        assertNotNull("with defaults enabled we should get a value for refresh_interval!", refreshInterval);
        int failedShards = response.getFailedShards(); // <4>
            };
            // end::put-index-template-v2-execute-async
            assertTrue(exists);
                    Map<String, Object> message = new HashMap<>();
                    @Override
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
            } catch (OpenSearchException exception) {
            // end::clear-cache-response
            // end::get-alias-execute-async
    }
        request.source("""
            assertTrue(createIndexResponse.isAcknowledged());
            assertThat(status, equalTo(RestStatus.OK));
    public void testGetSettings() throws Exception {
        // end::clone-index-request-masterTimeout
 * software distributed under the License is distributed on an
        RestHighLevelClient client = highLevelClient();
        boolean shardsAcked = resizeResponse.isShardsAcknowledged(); // <2>
        // end::indices-put-settings-request-preserveExisting
                "log-*",
                        }
            // tag::close-index-request
                RefreshRequest request = new RefreshRequest("does_not_exist");
        }
import org.opensearch.client.GetAliasesResponse;
            // tag::put-index-template-v2-request-aliases
        ResizeRequest request = new ResizeRequest("target_index","source_index"); // <1>
            Template template = new Template(Settings.builder().put("index.number_of_replicas", 3).build(), null, null);
        {
            final CountDownLatch latch = new CountDownLatch(1);
                            Collections.singletonList("ct1"), null, null, null); // <1>
        final CountDownLatch latch = new CountDownLatch(1);
        assertTrue(pmResp.isAcknowledged());
            // end::update-aliases-execute-listener
            // end::templates-exist-execute-listener
            // end::clear-cache-request-fields
            // end::templates-exist-request
                public void onFailure(Exception e) {
        }
                }
        // end::indices-put-settings-create-settings
            assertTrue(createIndexResponse.isAcknowledged());
                }
        {
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest().name("my-template");
                            "message": {
        // tag::get-index-request-indicesOptions
            final CountDownLatch latch = new CountDownLatch(1);
    public void testPutMapping() throws IOException {
        final CountDownLatch latch = new CountDownLatch(1);
        // end::indices-validate-query-request-query
        }
                @Override
            // end::put-mapping-response
            int totalShards = refreshResponse.getTotalShards(); // <1>
    @SuppressWarnings("unused")
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
    public void testPutTemplate() throws Exception {
            }
                .addTokenFilter("lowercase")    // <4>
        // end::indices-put-settings-request-indicesOptions
        // tag::simulate-index-template-response
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
                        // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
    public void testDeleteIndex() throws IOException {
        // tag::put-template-request-masterTimeout
        final RestHighLevelClient client = highLevelClient();
    public void testGetTemplates() throws Exception {
                Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build(),
        }
import static org.hamcrest.Matchers.is;
                            builder.field("type", "text");
        ActionListener<AcknowledgedResponse> listener =
            boolean acknowledged = openIndexResponse.isAcknowledged(); // <1>
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        RestHighLevelClient client = highLevelClient();
        simulateRequest.indexTemplateV2Request(newIndexTemplateRequest); // <2>
import org.opensearch.action.admin.indices.alias.Alias;
                .indexTemplate(new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"), template, null, null, null, null));
        // end::rollover-index-request-waitForActiveShards
            // tag::get-alias-request
import org.opensearch.common.unit.TimeValue;
            request.create(true);  // <1>
            // tag::clear-cache-notfound
            final CountDownLatch latch = new CountDownLatch(1);
              "settings": {
                public void onResponse(AcknowledgedResponse response) {
            // tag::put-mapping-request-masterTimeout
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        boolean shardsAcked = rolloverResponse.isShardsAcknowledged(); // <2>
                public void onResponse(ValidateQueryResponse validateQueryResponse) {
        request.settings(Settings.builder() // <1>
                }
            request.includeDefaults(false); // <3>
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
        {
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
                    {
    public void testSplitIndex() throws Exception {
        }
            // tag::flush-request-wait
        String numberOfShardsString = getSettingsResponse.getSetting("index", "index.number_of_shards");
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
            // tag::flush-execute
            OpenIndexResponse openIndexResponse = client.indices().open(request, RequestOptions.DEFAULT);
            // tag::put-mapping-request
        GetIndexResponse getIndexResponse = client.indices().get(request, RequestOptions.DEFAULT);
            GetFieldMappingsResponse response =
            final CountDownLatch latch = new CountDownLatch(1);
                public void onFailure(Exception e) {
                        },
            assertTrue(acknowledged);
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
                null,
import org.opensearch.client.RestHighLevelClient;
            putRequest.patterns(Collections.singletonList("foo"));
            // end::create-index-request-aliases
        // end::simulate-index-template-response
            // tag::close-index-request-indicesOptions
            Settings.Builder settingsBuilder =
                client.indices().delete(request, RequestOptions.DEFAULT);
        // tag::shrink-index-request-waitForActiveShards
    }
        // end::indices-validate-query-request-rewrite
        // tag::indices-put-settings-request-preserveExisting
                // <2>
        {
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
        // end::clone-index-execute
            };
            new ActionListener<AcknowledgedResponse>() {
            request.indices("twitter");
        {
                public void onFailure(Exception e) {
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            final CountDownLatch latch = new CountDownLatch(1);
            assertTrue(createIndexResponse.isAcknowledged());
        ResizeResponse resizeResponse = client.indices().split(request, RequestOptions.DEFAULT);
                client.indices().open(request, RequestOptions.DEFAULT);
                .name("my-template");
            // tag::get-alias-response
            DeleteIndexRequest request = new DeleteIndexRequest("posts"); // <1>
            // tag::analyze-index-normalizer-request
            final CountDownLatch latch = new CountDownLatch(1);
            assertTrue(indicesAliasesResponse.isAcknowledged());
                    }
            int successfulShards = refreshResponse.getSuccessfulShards(); // <2>
            ActionListener<GetMappingsResponse> listener =
            IndicesAliasesRequest request = new IndicesAliasesRequest();
import org.opensearch.action.LatchedActionListener;
            request.indexTemplate(composableIndexTemplate);
                @Override
            }
            public void onResponse(ResizeResponse resizeResponse) {
                request.mapping(// <1>
        request.patterns(Arrays.asList("pattern-1", "log-*")); // <2>
            // end::delete-index-execute-async
                public void onResponse(Boolean exists) {
            request.timeout("2m"); // <2>
                request.source(jsonMap); // <1>
        {
        for(QueryExplanation explanation: response.getQueryExplanation()) { // <9>
    public void testCloseIndex() throws Exception {
                @Override
        listener = new LatchedActionListener<>(listener, latch);
                    new AliasActions(AliasActions.Type.ADD)
        assertThat(templates, hasSize(1));
                public void onFailure(Exception e) {
                Map<String, Object> mapping = indexMapping.sourceAsMap();
            {
            AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
        // end::split-index-execute-async
        // tag::put-template-execute-async
        // tag::shrink-index-request-timeout
        listener = new LatchedActionListener<>(listener, latch);
        // tag::get-settings-request-names
    public void testIndexPutSettings() throws Exception {
        RolloverRequest request = new RolloverRequest("alias", "index-2"); // <1>
                public void onResponse(AcknowledgedResponse putTemplateResponse) {
        // tag::put-template-request-order
            // end::create-index-request-settings
        client.indices().validateQueryAsync(request, RequestOptions.DEFAULT, listener); // <1>
        CreateIndexRequest req = new CreateIndexRequest("my_index");
import org.opensearch.client.indices.DeleteAliasRequest;
        assertEquals("index-2", newIndex);
                    // <2>
            // tag::get-field-mappings-execute
    @SuppressWarnings("unused")
import org.opensearch.common.compress.CompressedXContent;
            // tag::open-index-request
            // end::clear-cache-notfound
                builder.startObject("properties");
            }
        UpdateSettingsRequest requestAll = new UpdateSettingsRequest(); // <3>
            // tag::update-aliases-execute-listener
            // end::flush-request
        // end::indices-put-settings-execute-async
        // end::get-settings-request
        request.timeout("2m"); // <2>
            try {
        // tag::indices-validate-query-request
        // tag::indices-validate-query-request-explain
        }
                .put("index.number_of_shards", 4)); // <1>
            CreateIndexResponse createIndexResponse = client.indices()
                .name("my-template");
                    // <2>
import org.opensearch.core.common.unit.ByteSizeValue;
            request.aliases("alias"); // <1>
                properties.put("message", message);
            // end::put-mapping-execute-async
            // tag::clear-cache-request-request
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
                    , MediaTypeRegistry.JSON); // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        }
            // end::close-index-execute
            // tag::force-merge-request-indicesOptions
        assertTrue(acknowledged);
            // end::force-merge-notfound
                        }""", // <2>
            // end::clear-cache-execute-async
            // end::create-index-request
                Map<String, Object> mapping = new HashMap<>();
        RestHighLevelClient client = highLevelClient();
            // end::flush-request-indicesOptions
            // tag::clear-cache-request-fields
            client.indices().forcemergeAsync(request, RequestOptions.DEFAULT, listener); // <1>
                null,
            // end::exists-alias-request
                          "properties": {
            request.local(false); // <1>
            CreateIndexResponse createIndexResponse = client.indices()
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
    @SuppressWarnings("unused")
        final RestHighLevelClient client = highLevelClient();
            final ActionListener<GetFieldMappingsResponse> latchListener = new LatchedActionListener<>(listener, latch);
        // end::get-settings-response
        // end::indices-validate-query-execute
        // tag::shrink-index-execute-listener
            client.indices().create(new CreateIndexRequest("index-1").alias(new Alias("alias")), RequestOptions.DEFAULT);
    }
                    RequestOptions.DEFAULT
import java.util.concurrent.CountDownLatch;
                new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"), null, null, null, null, null); // <2>
        request.clusterManagerNodeTimeout("1m"); // <2>
            request.indexTemplate(composableIndexTemplate);
            // tag::create-index-request-waitForActiveShards
            public void onFailure(Exception e) {
import static org.hamcrest.Matchers.equalTo;
        // tag::indices-put-settings-execute-async
            assertTrue(exists);
        request.getTargetIndexRequest().alias(new Alias("target_alias")); // <1>
            // end::open-index-execute-listener
        {
        }
            ActionListener<RefreshResponse> listener = new ActionListener<RefreshResponse>() {
        request.timeout("2m"); // <2>
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
        {
        }
            // end::exists-alias-request-indices
            // end::force-merge-request-only-expunge-deletes
        {
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.
            // end::put-template-request-mappings-json
        }
        // tag::get-templates-execute-async
import org.opensearch.index.query.QueryBuilders;
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index"), RequestOptions.DEFAULT);
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
 * (the code indentation of the tag is not included in the width)
            // end::analyze-response-tokens
        }
            // end::open-index-execute-async
import static org.hamcrest.Matchers.nullValue;
        // end::shrink-index-request-waitForActiveShards
 * You may obtain a copy of the License at
                if (exception.status() == RestStatus.NOT_FOUND) {
            request.addAliasAction(aliasAction);
            {
        // tag::rollover-index-request-alias
                new ActionListener<GetFieldMappingsResponse>() {
            // end::create-index-execute-async
        // tag::delete-template-execute-async
        request.clusterManagerNodeTimeout("1m"); // <2>
            new ActionListener<GetComposableIndexTemplatesResponse>() {
        AcknowledgedResponse updateSettingsResponse =
            // Replace the empty listener by a blocking listener in test
                Settings.builder().put("index.routing.allocation.require._name", firstNode).put("index.blocks.write", true)
                @Override
/*
    @SuppressWarnings("unused")
import org.opensearch.action.admin.indices.shrink.ResizeResponse;
        // tag::get-field-mappings-request-indicesOptions
        RestHighLevelClient client = highLevelClient();
        RestHighLevelClient client = highLevelClient();
            final CountDownLatch latch = new CountDownLatch(1);
        UpdateSettingsRequest requestMultiple =
        request.clusterManagerNodeTimeout("1m"); // <2>
                }
            // end::flush-request-wait
            createIndexResponse = client.indices().create(new CreateIndexRequest("index2"), RequestOptions.DEFAULT);
        }
import org.opensearch.client.indices.GetIndexResponse;
            // end::delete-index-request
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
                int shardId = failure.shardId(); // <7>
        // tag::put-template-whole-source
    public void testGetSettingsWithDefaults() throws Exception {
            .name("used-for-simulation");
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
            // end::open-index-request-masterTimeout
            // end::put-index-template-v2-request-version
            request.setClusterManagerNodeTimeout("1m"); // <3>
                Arrays.asList("pattern-1", "log-*"),
 * ["source","java",subs="attributes,callouts,macros"]
        // tag::rollover-index-execute-async
                AcknowledgedResponse putMappingResponse = client.indices().putMapping(request, RequestOptions.DEFAULT);
        ActionListener<AcknowledgedResponse> listener =
        // tag::indices-put-settings-response
            DefaultShardOperationFailedException[] failures = forceMergeResponse.getShardFailures(); // <4>
        }
                }
        RestHighLevelClient client = highLevelClient();
        // end::get-templates-execute
            request.clusterManagerNodeTimeout("1m"); // <2>
            assertTrue(createIndexResponse.isAcknowledged());
                properties.put("message", message);
        List<IndexTemplateMetadata> templates = getTemplatesResponse.getIndexTemplates(); // <1>
            }
        }
        // end::get-index-templates-v2-execute
        assertEquals("3", numberOfShardsString);
                  }
                {
            request.mapping(// <1>
            CreateIndexResponse createIndexResponse = client.indices()
import org.opensearch.client.indices.GetFieldMappingsRequest;
            // end::indices-exists-execute
                @Override
        // tag::clone-index-execute-listener
        String oldIndex = rolloverResponse.getOldIndex(); // <3>
        }
        // tag::get-settings-execute-async
                    properties.put("message", message);
            Map<String, Object> mapping = indexMapping.sourceAsMap(); // <3>
            // end::close-index-request-timeout
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            int successfulShards = clearCacheResponse.getSuccessfulShards(); // <2>
                jsonMap.put("properties", properties);
            // end::exists-alias-request-local
        {
            PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");
            stopFilter.put("type", "stop");
            }
                .build(); // <1>
            request.indices("index"); // <1>
            request.waitForActiveShards(ActiveShardCount.from(2)); // <1>
        }
                }
            // Replace the empty listener by a blocking listener in test
    public void testValidateQuery() throws IOException, InterruptedException {
                        "settings" : {
        // tag::delete-index-template-v2-response
            // tag::indices-put-settings-settings-map
            // end::put-mapping-request-timeout
import org.opensearch.index.query.QueryBuilder;
        {
                public void onResponse(GetComposableIndexTemplatesResponse response) {
                    public void onResponse(AcknowledgedResponse putIndexTemplateResponse) {
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
        // tag::get-index-templates-v2-execute-listener
import org.opensearch.action.support.IndicesOptions;
                // <1>
            indexTypeMappings
                "alias-1": {},
            XContentFactory.jsonBuilder()
        // tag::simulate-index-template-execute-async
            GetIndexRequest request = new GetIndexRequest("twitter");
            }
            // end::clear-cache-execute
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        ValidateQueryResponse response = client.indices().validateQuery(request, RequestOptions.DEFAULT); // <1>
                }
    @SuppressWarnings("unused")
        Map<String, Object> indexTypeMappings = indexMappings.getSourceAsMap(); // <2>
                new ActionListener<org.opensearch.client.core.AcknowledgedResponse>() {
package org.opensearch.client.documentation;
        final CountDownLatch latch = new CountDownLatch(1);
        RestHighLevelClient client = highLevelClient();
            request.indexTemplate(composableIndexTemplate);
        // tag::get-templates-execute-listener
            // tag::open-index-execute-listener
                    }
            assertTrue(acknowledged);
            // tag::templates-exist-request-optionals
                        // <2>
                    // <2>
            ComposableIndexTemplate composableIndexTemplate = new ComposableIndexTemplate(Arrays.asList("pattern-1", "log-*"),
                public void onResponse(ClearIndicesCacheResponse clearCacheResponse) {
                assertTrue(createIndexResponse.isAcknowledged());
        client.indices().splitAsync(request, RequestOptions.DEFAULT,listener); // <1>
            Map<String, Object> map = new HashMap<>();
        {
        {
                .build();
 * this file be licensed under the Apache-2.0 license or a
            ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("index1"); // <1>
        // end::delete-index-template-v2-execute-listener
        request.addMaxIndexDocsCondition(1000); // <3>
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        }
                    // <1>
        assertEquals(3, conditionStatus.size());
                "some text to analyze"
                    @Override
                null,
        // end::rollover-index-response
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
import org.opensearch.client.indices.CreateIndexResponse;
    public void testExistsAlias() throws Exception {
    public void testGetAlias() throws Exception {
        request.setPreserveExisting(false); // <1>
            // tag::clear-cache-request-query
        // tag::indices-validate-query-response
    }
        ActionListener<GetIndexTemplatesResponse> listener =
                        // <1>
            // end::analyze-response-detail
            // end::refresh-notfound
            client.indices().existsAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.client.indices.CloseIndexResponse;
            public void onResponse(GetSettingsResponse GetSettingsResponse) {}
                //tag::put-mapping-map
                        "message": {
import org.opensearch.action.admin.indices.shrink.ResizeType;
                    // <1>
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
        RestHighLevelClient client = highLevelClient();
                {
        final RestHighLevelClient client = highLevelClient();
        // tag::rollover-index-request-timeout
        // end::simulate-index-template-execute-listener
        // tag::rollover-index-request-mapping
            };
            assertTrue(createIndexResponse.isAcknowledged());
            request.indicesOptions(indicesOptions); // <4>
        MappingMetadata indexMappings = getIndexResponse.getMappings().get("index"); // <1>
                null, null, 20L, null, null); // <1>
            }
            };
        {
        if (failedShards > 0) {
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("index1"), RequestOptions.DEFAULT);
import org.opensearch.client.indices.DetailAnalyzeResponse;
                response.mappings();// <1>
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>
                    // <1>
        request.getTargetIndexRequest().alias(new Alias("target_alias")); // <1>
    }
                            }
                    // <1>
            );
        // Replace the empty listener by a blocking listener in test
                };
            client.indices().createAsync(request, RequestOptions.DEFAULT, listener); // <1>
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
        // tag::delete-index-template-v2-execute-listener
        // end::delete-index-template-v2-response
            // tag::update-aliases-execute
            GetAliasesRequest request = new GetAliasesRequest();
        assertTrue(acknowledged);
            //end::put-template-request-mappings-xcontent
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
            Map<String, AliasMetadata> aliases = new HashMap<>();
        assertTrue(shardsAcked);
        {
        request.getCreateIndexRequest().alias(new Alias("another_alias")); // <1>
                assertThat(mapping, equalTo(expected));
                Arrays.asList("pattern-1", "log-*"),
            // tag::open-index-request-masterTimeout
            // end::analyze-execute-listener
                .putNull("index.routing.allocation.require._name")); // <2>
            request.indices("index"); // <1>
        {
            IndicesOptions indicesOptions = IndicesOptions.strictExpand();
            try {
        }
        {
        // end::simulate-index-template-execute-async
                public void onResponse(CloseIndexResponse closeIndexResponse) {
        // end::get-templates-execute-listener
            );
        {
                @Override
                //tag::create-index-mappings-map
            }""", MediaTypeRegistry.JSON); // <1>
        // end::get-index-response
            // tag::clear-cache-response
                        // <1>
            // Replace the empty listener by a blocking listener in test
            ActionListener<CreateIndexResponse> listener =
import org.opensearch.client.indices.PutComponentTemplateRequest;
        request.version(4);  // <1>
        // end::indices-validate-query-execute-async
                public void onResponse(CreateIndexResponse createIndexResponse) {
                    // <1>
            boolean acknowledged = deleteAliasResponse.isAcknowledged(); // <1>
            // tag::clear-cache-execute-listener
        createIndex(index, Settings.EMPTY);
    }
                mapping.put("properties", properties);
            // end::delete-index-request-indicesOptions
                null,
        // tag::indices-validate-query-execute
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
            listener = new LatchedActionListener<>(listener, latch);
                @Override
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
    }
                public void onFailure(Exception e) {
            client.indices().closeAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::update-aliases-request
            // end::update-aliases-execute
            };
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
        Map<String, Boolean> conditionStatus = rolloverResponse.getConditionStatus();// <7>
            int failedShards = refreshResponse.getFailedShards(); // <3>
import org.opensearch.client.indices.rollover.RolloverResponse;
            request.clusterManagerNodeTimeout("1m"); // <2>
        // tag::get-field-mappings-request
    public void testIndicesExistAsync() throws Exception {
            // Replace the empty listener by a blocking listener in test
        // end::put-template-execute
            // tag::delete-index-execute-async
            // tag::exists-alias-request-local
            AnalyzeRequest request = AnalyzeRequest.buildCustomNormalizer()
        }
                public void onFailure(Exception e) {
                    // <2>
 * Modifications Copyright OpenSearch Contributors. See
            assertTrue(createIndexResponse.isAcknowledged());
        {
        RestHighLevelClient client = highLevelClient();
            boolean acknowledged = deleteIndexResponse.isAcknowledged(); // <1>
            final String fullName = metadata.fullName();// <4>
                null,
                    @Override
                assertTrue(putMappingResponse.isAcknowledged());
        {
                final String fullName = metadata1.fullName();
                Map<String, Object> properties = new HashMap<>();
                public void onResponse(GetIndexResponse getIndexResponse) {
    }
        // tag::get-templates-execute
            ActionListener<OpenIndexResponse> listener =
            request.mapping(jsonMap); // <1>
            RefreshResponse refreshResponse = client.indices().refresh(request, RequestOptions.DEFAULT);
 * Then in the documentation, you can extract what is between tag and end tags with
            request.settings(Settings.builder() // <1>
        };
                @Override
                    }
        {
                "Some text to analyze", "Some more text to analyze");       // <2>
                final Map<String, Object> source = metadata1.sourceAsMap();
        // end::indices-put-settings-execute-listener
        // tag::put-template-request
        RestHighLevelClient client = highLevelClient();
        // Replace the empty listener by a blocking listener in test
            PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");
        }
                // <2>
        boolean acknowledged = putTemplateResponse.isAcknowledged(); // <1>
            };
        final RestHighLevelClient client = highLevelClient();
            final Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldMappings =
        // end::put-template-response
        listener = new LatchedActionListener<>(listener, latch);
        boolean isRolledOver = rolloverResponse.isRolledOver(); // <5>
                    // <1>
            // Replace the empty listener by a blocking listener in test
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
import org.opensearch.core.xcontent.XContentBuilder;
        // end::split-index-request-masterTimeout
        // Replace the empty listener by a blocking listener in test
                .name("my-template");
                    // <1>
            assertTrue(indicesAliasesResponse.isAcknowledged());
            // end::delete-index-response
            Map<String, MappingMetadata> allMappings = getMappingResponse.mappings(); // <1>
 * ownership. Elasticsearch licenses this file to you under
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
            // end::get-mappings-request-masterTimeout
        boolean isDryRun = rolloverResponse.isDryRun(); // <6>
            boolean shardsAcked = openIndexResponse.isShardsAcknowledged(); // <2>
            List<AnalyzeResponse.AnalyzeToken> tokens = response.getTokens();   // <1>
                null,
        // end::get-index-request-includeDefaults
 *
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        final CountDownLatch latch = new CountDownLatch(1);
        {
                    // <2>
            new ActionListener<SimulateIndexTemplateResponse>() {
                    new AliasActions(AliasActions.Type.REMOVE_INDEX)
        }
                    // <1>
        request.create(false); // make test happy
            assertTrue(client.indices().putTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
            assertTrue(createIndexResponse.isAcknowledged());
            // tag::analyze-response-tokens
            request.explain(true);                      // <1>
            // tag::update-aliases-request-masterTimeout
            request.indices("twitter"); // <2>
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            // end::force-merge-request-indicesOptions
            // tag::put-index-template-v2-execute-async
            @Override
        request.addMaxIndexAgeCondition(new TimeValue(7, TimeUnit.DAYS)); // <2>
            // end::indices-put-settings-settings-builder
            listener = new LatchedActionListener<>(listener, latch);
                //end::put-mapping-map
            // end::close-index-request-masterTimeout
        assertThat(templates.get(0).name(), equalTo("my-template"));
            assertTrue(createIndexResponse.isAcknowledged());
        // end::indices-validate-query-response
import java.io.IOException;
            // end::templates-exist-request-optionals
        // end::indices-put-settings-request-index-settings
            assertThat(response.getAliases().get("index").iterator().next().alias(), equalTo("alias"));
        RestHighLevelClient client = highLevelClient();
        }
            // tag::close-index-execute-async
            // end::open-index-response
        request.name("my-template"); // <1>
                // end::put-mapping-request-source
            // tag::close-index-execute-listener
            // end::indices-exists-request-optionals
            PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");
                null,
            // end::analyze-builtin-request
        final CountDownLatch latch = new CountDownLatch(1);
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.onlyExpungeDeletes(ForceMergeRequest.Defaults.ONLY_EXPUNGE_DELETES);
            AcknowledgedResponse indicesAliasesResponse = client.indices().updateAliases(request, RequestOptions.DEFAULT);
        // end::indices-validate-query-request-allShards
        request.getCreateIndexRequest().mapping(mappings, MediaTypeRegistry.JSON); // <1>
            // end::clear-cache-execute-listener
        int settingValue = 0;
import org.opensearch.client.indices.CloseIndexRequest;
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
            // tag::force-merge-request
        // tag::clone-index-request-masterTimeout
                null
            putRequest.settings(Settings.builder().put("index.number_of_shards", 3));
                    client.indices().updateAliases(request, RequestOptions.DEFAULT);
        RestHighLevelClient client = highLevelClient();
            request.flush(true); // <1>
                public void onFailure(Exception e) {
        {
            CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("twitter"), RequestOptions.DEFAULT);
            .getAsTime("index.refresh_interval", null); // <7>
        QueryBuilder builder = QueryBuilders
        assertThat(simulateIndexTemplateResponse.overlappingTemplates().get("my-template"),
                public void onFailure(Exception e) {
            }
            // tag::put-index-template-v2-request-create
                //end::create-index-mappings-xcontent
                }""",
                        builder.startObject("message");
        // tag::get-index-request
                        "message": {
        Integer numberOfShards = indexSettings.getAsInt("index.number_of_shards", null);
                final GetFieldMappingsResponse.FieldMappingMetadata metadata1 = fieldMappings.get("message");
        // tag::rollover-index-request-dryRun
        // end::delete-template-request-masterTimeout
                    // <1>
            } catch (OpenSearchException exception) {
            // end::flush-execute
        request.setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        String numberOfShardsString = getSettingsResponse.getSetting("index", "index.number_of_shards"); // <1>
        // tag::split-index-execute-listener
        // tag::delete-template-execute-listener
        listener = new LatchedActionListener<>(listener, latch);
                public void onResponse(SimulateIndexTemplateResponse response) {
        GetIndexTemplatesResponse getTemplatesResponse = client.indices().getIndexTemplate(request, RequestOptions.DEFAULT);
                assertTrue(putMappingResponse.isAcknowledged());
            request.settings(
        // end::delete-index-template-v2-request-masterTimeout
            // tag::force-merge-request-only-expunge-deletes
                        }
        }
            AliasActions aliasAction = new AliasActions(AliasActions.Type.ADD).index("index1").alias("alias2");
            // end::indices-exists-execute-async
                .endObject()
                            "number_of_shards" : 1,
                        {
import org.opensearch.client.indices.AnalyzeResponse;
            assertTrue(createIndexResponse.isAcknowledged());
            Map<String, String> type = new HashMap<>();
            DefaultShardOperationFailedException[] failures = flushResponse.getShardFailures(); // <4>
            final CountDownLatch latch = new CountDownLatch(1);
        // tag::rollover-index-request-masterTimeout
            AliasActions addIndicesAction =
        // end::clone-index-execute-async
              "index_patterns": [
                "properties": {
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::delete-index-notfound
public class IndicesClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
        // end::get-index-execute-async
                .name("my-template"); // <1>
                    .alias("alias3"); // <3>
            int failedShards = flushResponse.getFailedShards(); // <3>
                request.source(builder); // <1>
                    new ActionListener<CreateIndexResponse>() {
        ActionListener<GetSettingsResponse> listener =
        // tag::get-settings-request-include-defaults
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
        String mappings = "{\"properties\":{\"field-1\":{\"type\":\"keyword\"}}}";
            // end::force-merge-execute-async
    public void testGetIndex() throws Exception {
        AcknowledgedResponse deleteTemplateAcknowledge = client.indices().deleteIndexTemplate(deleteRequest, RequestOptions.DEFAULT);
            }
            request.settings(map); // <1>
        };
import java.util.HashMap;
        // end::get-settings-request-indicesOptions
        {
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        ActionListener<GetSettingsResponse> listener = new ActionListener<GetSettingsResponse>() {
        // end::indices-put-settings-request
              ],
        {
        listener = new LatchedActionListener<>(listener, latch);
            // end::exists-alias-request-indicesOptions
 * license agreements. See the NOTICE file distributed with
        client.indices().simulateIndexTemplateAsync(simulateRequest, RequestOptions.DEFAULT, listener); // <1>
        }
            // Replace the empty listener by a blocking listener in test
                }
            // tag::indices-exists-execute-async
        client.indices().getAsync(request, RequestOptions.DEFAULT, listener); // <1>
                public void onFailure(Exception e) {
            final CountDownLatch latch = new CountDownLatch(1);
                        },
            // end::flush-response
        RestHighLevelClient client = highLevelClient();
                    }""", MediaTypeRegistry.JSON); // <1>
            assertTrue(createIndexResponse.isAcknowledged());
                      "type": "text"
                    .put("index.number_of_routing_shards", 4)
            // tag::flush-notfound
        listener = new LatchedActionListener<>(listener, latch);
                String reason = failure.reason(); // <8>
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
            final CountDownLatch latch = new CountDownLatch(1);
                    new GetAliasesRequest(new String[]{"alias1", "alias2"});
import org.opensearch.client.indices.GetIndexTemplatesResponse;
            // end::flush-execute-async
        // end::rollover-index-request-timeout
        client.indices().putSettingsAsync(request, RequestOptions.DEFAULT, listener); // <1>
            PutMappingRequest request = new PutMappingRequest("twitter");
            request.fields("field1", "field2", "field3"); // <1>
                }
            // end::put-mapping-request-masterTimeout
            // tag::refresh-response
            AliasMetadata twitterAlias = AliasMetadata.builder("twitter_alias").build(); // <1>
        // Replace the empty listener by a blocking listener in test
    public void testFlushIndex() throws Exception {
}
            }
            // end::clear-cache-request-indicesOptions
            {
                }
        {
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
            // end::close-index-response
        GetComposableIndexTemplateRequest request = new GetComposableIndexTemplateRequest("my-template"); // <1>
        }
        PutComposableIndexTemplateRequest newIndexTemplateRequest = new PutComposableIndexTemplateRequest()
        // end::put-template-whole-source
                .put(settingKey, settingValue)
    }
            // tag::force-merge-request-flush
                @Override
                Settings.builder()
        // end::shrink-index-request
        }
            request.alias(new Alias("twitter_alias").filter(QueryBuilders.termQuery("user", "foobar")));  // <1>
                                "message" : { "type" : "text" }
            GetAliasesRequest requestWithAliases =
                Map<String, Object> properties = new HashMap<>();
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::indices-validate-query-execute-listener
            ActionListener<GetAliasesResponse> listener =
            // tag::delete-index-request
        RestHighLevelClient client = highLevelClient();
        AcknowledgedResponse deleteTemplateAcknowledge = client.indices().deleteTemplate(request, RequestOptions.DEFAULT);
            // tag::put-mapping-request-timeout
            for(DefaultShardOperationFailedException failure: response.getShardFailures()) { // <5>
            // tag::analyze-custom-request
                    }
                    .indices("index1", "index2")
        assertEquals(refreshInterval, indexDefaultSettings.get("index.refresh_interval"));
            // end::clear-cache-request-request
        client.indices().deleteTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::refresh-request
        // tag::shrink-index-execute-async
            {
        }
        // end::shrink-index-execute-listener
        ActionListener<ResizeResponse> listener = new ActionListener<ResizeResponse>() {
        // end::shrink-index-request-aliases
                    .put("index.number_of_shards", 2)
                XContentBuilder builder = XContentFactory.jsonBuilder();
        };
            request.indexTemplate(composableIndexTemplate);
        request.setClusterManagerNodeTimeout("1m"); // <2>
            AnalyzeRequest request = AnalyzeRequest.withField("my_index", "my_field", "some text to analyze");
        deleteRequest.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
                message.put("type", "text");
            request.mapping(builder); // <1>
        {
                FlushRequest request = new FlushRequest("does_not_exist");
            FlushRequest requestAll = new FlushRequest(); // <3>
        }
            };
        DeleteComposableIndexTemplateRequest deleteRequest = new DeleteComposableIndexTemplateRequest("my-template"); // <1>
                    public void onFailure(Exception e) {
            // end::templates-exist-execute-async
import org.opensearch.common.xcontent.XContentFactory;
                      }
    }
    }
                @Override
        int successfulShards = response.getSuccessfulShards(); // <3>
                    // <1>
        {
                    new GetAliasesRequest(new String[]{"alias1", "alias2"});
                    // <1>
            // tag::exists-alias-execute-async
        // tag::clone-index-request-aliases
        }
            // tag::templates-exist-execute
        {
            ActionListener<FlushResponse> listener = new ActionListener<FlushResponse>() {
            // end::get-field-mappings-execute
    }
            assertTrue(client.indices().putIndexTemplate(putRequest, RequestOptions.DEFAULT).isAcknowledged());
 * <p>
        // Replace the empty listener by a blocking listener in test
        GetIndexTemplatesRequest request = new GetIndexTemplatesRequest("my-template"); // <1>
            // tag::analyze-execute
 * The column width of the code block is 84. If the code contains a line longer
        {
            createIndex("source_index", Settings.builder().put("index.number_of_shards", 4).put("index.number_of_replicas", 0).build());
                    builder.startObject("message");
            assertTrue(client.indices().putIndexTemplate(request, RequestOptions.DEFAULT).isAcknowledged());
            @Override
            putRequest.mapping("{ \"properties\": { \"message\": { \"type\": \"text\" } } }", MediaTypeRegistry.JSON);
                    // <2>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.setClusterManagerTimeout(TimeValue.timeValueMinutes(1)); // <1>
import java.util.Collections;
            // end::put-mapping-execute
        client.indices().getSettingsAsync(request, RequestOptions.DEFAULT, listener);
        }
    }
        request.getTargetIndexRequest().alias(new Alias("target_alias")); // <1>
                @Override
                    @Override
                CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
            // end::indices-exists-request
            // tag::delete-index-execute
            };
            // tag::exists-alias-request-indicesOptions
                }
                }
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::create-index-whole-source
                public void onFailure(Exception e) {
            );
            // end::get-mappings-response
            String explanationIndex = explanation.getIndex(); // <10>
                "pattern-1"
            builder.startObject();
        RestHighLevelClient client = highLevelClient();
                    new AliasActions(AliasActions.Type.REMOVE)
                @Override
                .field("analyzer", "english")
                fail("should not fail");
            // tag::put-index-template-v2-execute
            // end::put-index-template-v2-response
 *
        {
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
            request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
import org.opensearch.client.indices.GetMappingsRequest;
        request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            request.setLocal(true); // <1>
            client.indices().analyzeAsync(request, RequestOptions.DEFAULT, listener); // <1>
            GetAliasesRequest requestWithAliases =
        }
            final CountDownLatch latch = new CountDownLatch(1);
            }
        // tag::indices-put-settings-request-timeout
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::get-field-mappings-request-indicesOptions
                    @Override
            client.indices().openAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // end::indices-put-settings-execute
import org.opensearch.core.action.ActionListener;
            // tag::open-index-response
        // end::delete-index-template-v2-execute
            // tag::force-merge-execute
                            "properties" : {
        CreateIndexResponse resp = client.indices().create(req, RequestOptions.DEFAULT);
            ActionListener<GetFieldMappingsResponse> listener =
            IndexTemplatesExistRequest request;
                mappings.get("twitter"); // <2>
                public void onFailure(Exception e) {
                "my_analyzer",        // <2>
            // tag::get-alias-execute-listener
import org.opensearch.action.support.ActiveShardCount;
        ActionListener<AcknowledgedResponse> listener =
            listener = new LatchedActionListener<>(listener, latch);
            // tag::put-index-template-v2-request-mappings-json
        }
import org.opensearch.client.indices.rollover.RolloverRequest;
        RestHighLevelClient client = highLevelClient();
    @SuppressWarnings("unused")
        // tag::shrink-index-request-settings
    public void testGetMappingAsync() throws Exception {
                "my_index",         // <1>
                );
        request.addMaxIndexSizeCondition(new ByteSizeValue(5, ByteSizeUnit.GB)); // <4>
                        },
        }
            // end::flush-notfound
            // end::exists-alias-execute-listener
            boolean acknowledged = closeIndexResponse.isAcknowledged(); // <1>
            updateIndexSettings("source_index", Settings.builder().put("index.blocks.write", true));
                new ActionListener<AcknowledgedResponse>() {
            request.indexTemplate(composableIndexTemplate);
            // end::force-merge-execute
                "number_of_shards": 1
    public void testIndicesExist() throws IOException {
        // end::shrink-index-request-settings
                .name("my-template");
            listener = new LatchedActionListener<>(listener, latch);
            assertTrue(shardsAcked);
                type.put("type", "text");
            AnalyzeRequest request = AnalyzeRequest.withGlobalAnalyzer("english", // <1>
                    .build()
            // end::open-index-request-indicesOptions
                public void onResponse(Boolean exists) {
        ResizeRequest request = new ResizeRequest("target_index","source_index"); // <1>
            assertTrue(createIndexResponse.isAcknowledged());
            assertTrue(createIndexResponse.isAcknowledged());
 * include-tagged::{doc-tests}/IndicesClientDocumentationIT.java[example]
            Map<String, Object> jsonMap = new HashMap<>();
        client.indices().cloneAsync(request, RequestOptions.DEFAULT,listener); // <1>
                builder.endObject();
import org.opensearch.core.common.unit.ByteSizeUnit;
import java.util.concurrent.TimeUnit;
                    // <2>
            } catch (OpenSearchException exception) {
                    }
            listener = new LatchedActionListener<>(listener, latch);
                }
                jsonMap.put("properties", properties);
        String settingKey = "index.number_of_replicas";
        // end::rollover-index-request-dryRun
            final PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest("my-template");
        {
            Settings settings = Settings.builder().put("number_of_shards", 3).build();
        {
                @Override
            client.indices().existsTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // tag::indices-validate-query-request-query
        request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
                template,
                    }
        {
        // Replace the empty listener by a blocking listener in test
        // tag::put-template-request-create
        request.setWaitForActiveShards(ActiveShardCount.DEFAULT); // <2>
            request.waitIfOngoing(true); // <1>
    public void testCreateIndex() throws IOException {
        request.clusterManagerNodeTimeout("1m"); // <2>
        // end::simulate-index-template-request
            String mappingJson = """
            public void onResponse(ResizeResponse resizeResponse) {
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::put-index-template-v2-request-component-template
            GetMappingsResponse getMappingResponse = client.indices().getMapping(request, RequestOptions.DEFAULT);
        // tag::get-settings-request-indicesOptions
    public void testTemplatesExist() throws Exception {
        request.getTargetIndexRequest().settings(Settings.builder()
            assertTrue(acknowledged);
            PutComposableIndexTemplateRequest request = new PutComposableIndexTemplateRequest()
            assertTrue(acknowledged);
            client.indices().flushAsync(request, RequestOptions.DEFAULT, listener); // <1>
                }
            // end::close-index-execute-listener
            // end::delete-alias-request-timeout
                @Override
                    @Override
        // tag::indices-put-settings-execute-listener
        // tag::clone-index-request-settings
            createIndex("index1", Settings.EMPTY);
        }
                template, null, null, null, null); // <4>
            ForceMergeResponse forceMergeResponse = client.indices().forcemerge(request, RequestOptions.DEFAULT);
                "my_index",             // <1>
        // end::rollover-index-execute-async
            // tag::put-index-template-v2-request-priority
                .create(new CreateIndexRequest("index").settings(settings), RequestOptions.DEFAULT);
            // end::put-index-template-v2-request-mappings-json
            IndicesAliasesRequest request = new IndicesAliasesRequest();
        GetSettingsResponse getSettingsResponse = client.indices().getSettings(request, RequestOptions.DEFAULT);
        assertTrue(acknowledged);
            // as it is mutually exclusive with max. num. segments
            // tag::refresh-execute
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::clone-index-request-settings
                .put("index.number_of_shards", 2) // <1>
            Map<String, Object> stopFilter = new HashMap<>();
                @Override
            Collections.singletonMap("properties", Collections.singletonMap("field-1", Collections.singletonMap("type", "integer"))),
            // end::get-alias-request-indicesOptions
            // tag::force-merge-notfound
        Integer numberOfShards = indexSettings.getAsInt("index.number_of_shards", null); // <3>
