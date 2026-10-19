        Template templateWithIndexHiddenSetting = new Template(
                return MapperService.parseMapping(new NamedXContentRegistry(Collections.emptyList()), m.string());  
        assertThat(throwables.get(0).getMessage(), containsString("[2]: cannot be greater than number of shard copies [1]"));
    @Override  
        assertThat(
            List.of("logs-*"),
        if (randomBoolean()) {  
        }
    }
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        assertFalse(
            )
            Settings.builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(),  
    }
                        + "    \"properties\": {\n"
            List.of("*"),
            1L,  
                null,  
                    ),  
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo2", componentTemplate2)
            null,
            null  
        );  
                null,
                e.getMessage(),  
import static org.hamcrest.CoreMatchers.equalTo;
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {
    }
            equalTo(  
                        + "    }\n"
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date_nanos")))
        assertNotNull(clusterState.metadata().templatesV2().get("foo"));  
                    fail("failed to parse mappings: " + m.string());
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
 * ownership. Elasticsearch licenses this file to you under  
                    + "cause data streams [unreferenced, logs-mysql-default] to no longer match a data stream template"  
        assertThat(lowPriorityDataStreams, empty());
    /**
                    latch.countDown();  
        assertThat(
        );
            Collections.singletonList("ct"),
        request.settings(builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "0").build());
            List.of(),
        ComposableIndexTemplate template = new ComposableIndexTemplate(  
    }  
                ),  
                        + "      \"properties\": {\n"  
            null,  
        request.patterns(singletonList("test_shards_wait*"));  
                null,
        assertTemplatesEqual(clusterState.metadata().templatesV2().get("foo"), templateToRemove);
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");
        assertThat(
        // Great, the templates aren't invalid
                        + "  }"  
        state = service.addComponentTemplate(state, true, "c1", ct1);  
        );  
                Map<String, Object> actualMappings;
        assertThat(errors.size(), equalTo(1));
            null,  
            Map<String, Object> firstMapping = Map.of(
        assertNotNull(state.metadata().componentTemplates().get("foo"));
     * when updating a component template
        assertFalse(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("foo-*"), Arrays.asList("bar-*")));  
        a3.put("baz", AliasMetadata.newAliasMetadataBuilder("baz").build());
            new Template(
                    new CompressedXContent(
            Collections.singletonList("i*"),
        Context context = new Context(systemTemplateMetadata.name(), contextVersion, Map.of());
            public void onFailure(Exception e) {  
                + " this template [v1-template] may be ignored in favor of a composable template at index creation time"
                            .settings(
            );
                null
        PutRequest pr = new PutRequest("api", "id");
            .put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "2");
            assertThat(actualTemplate.aliases(), equalTo(expectedTemplate.aliases()));  
                    fail("failed to parse mappings: " + m.string());
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(
            IllegalArgumentException e = expectThrows(  
            null
            null
        MetadataIndexTemplateService.innerPutTemplate(state, req, IndexTemplateMetadata.builder("v1-template"));
                "test",  
                "test",  
                    "_doc",
import java.util.HashMap;
import java.util.HashSet;  
            );
            assertThat(
            null,  
        InvalidIndexTemplateException ex = expectThrows(
        }).collect(Collectors.toList());  
                            LoggingDeprecationHandler.INSTANCE,
import java.util.Collections;
            state = service.addIndexTemplateV2(state, true, "timeseries-template", it);  
        // We should be able to replace the "logs" template, because we have the "logs-mysql" template that can handle the data stream
                List.of("ct1"),  
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
import static org.hamcrest.Matchers.is;
        ComponentTemplate componentTemplate = ComponentTemplateTests.randomInstance();
            Map<String, Object> secondMapping = Map.of("_doc", Map.of("properties", Map.of("field2", Map.of("type", "integer"))));
        }  
            null,
        ClusterState state = ClusterState.EMPTY_STATE;
                        + "      }\n"  
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
            new Context(systemTemplateMetadata.name())
        assertThat(settings.get("index.number_of_replicas"), equalTo("2"));
     * Tests that we check that settings/mappings/etc are valid even after template composition,
     * Test that if we have a pre-existing v2 template and put a v1 template that would match the same indices, we generate a warning  
            DefaultRemoteStoreSettings.INSTANCE,
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                            "logs-mysql",
        ComponentTemplate systemTemplateV2 = new ComponentTemplate(
            null,
import org.opensearch.repositories.RepositoriesService;  
            metadataIndexTemplateService.putComponentTemplate(
            () -> metadataIndexTemplateService.putIndexTemplateV2(
            null,
            "legacy template [v1-template] has index patterns [egg*, baz] matching patterns "
                    .build()
import java.util.Map;
                "composable template [logs2] with index patterns [logs-my*-*], priority [105] and no data stream "
import java.util.stream.Collectors;  
                    .build()  
                Collections.singletonMap(
        assertNotNull(mappings);
import org.opensearch.env.Environment;
            assertThat(parsedMappings.get(0), equalTo(firstMapping));
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
            public void onFailure(Exception e) {
            getInstanceFromNode(ThreadPool.class).getThreadContext().putTransient(ACTION_ORIGIN_TRANSIENT_NAME, TEMPLATE_LOADER_IDENTIFIER);
            assertNotNull(mappings);  
                    new CompressedXContent(
     * template *AND* change the index patterns that a warning is generated
        );
        );
                100L,  
            null,  
                            .settings(  
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            List.of("*"),  
                        + "      \"properties\": {\n"  
            .put(IndexMetadata.SETTING_PRIORITY, randomIntBetween(0, 100000))  
            service.putIndexTemplateV2(
 * KIND, either express or implied.  See the License for the
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")  
                "logs-data-stream-template",
                        @Override  
                            + "      \"field2\": {\n"
            null
        return true;  
                ) {
     */
                        + "      }\n"  
            Collections.singletonList("a"),
    @SuppressWarnings("unchecked")  
                .map(IndexTemplateMetadata::name)
                .putCustom(
                "test",
            metadataIndexTemplateService.addComponentTemplate(state, false, "foo", updatedComponentTemplate);
     * Test that if we have a pre-existing v1 template and put a v2 template that would match the same indices, we generate a warning
            )
                return null;
            );  
        assertNull(MetadataIndexTemplateService.findV2Template(state.metadata(), "index", randomBoolean()));  
        );
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
            );  
    public void testResolveSettingsWithContextVersion() throws Exception {  
            Arrays.asList("foo-bar-*", "eggplant"),
        );
import org.opensearch.common.settings.IndexScopedSettings;  
        );  
        request.patterns(singletonList("test_shards_wait*"));  
        assertNotNull(state.metadata().templatesV2().get("foo"));  
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);
                    return null;
                + "from existing composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]); "
        );
                null,  
        );
                @Override
            );
            public void onResponse(MetadataIndexTemplateService.PutResponse response) {  
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),  
            Collections.singletonList("logs-postgres-*"),  
        Map<String, AliasMetadata> a2 = new HashMap<>();
            throwables.get(0).getMessage(),
            () -> metadataIndexTemplateService.putIndexTemplateV2(
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
        );
            // a default @timestamp mapping will not be added if the matching template doesn't have the data stream field configured, even
            ComposableIndexTemplate it = new ComposableIndexTemplate(  
        ClusterState state = ClusterState.EMPTY_STATE;
            InvalidIndexTemplateException.class,  
                } catch (IOException e) {
    }  
            Collections.singletonList("ct"),
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        );
            null
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date_nanos")))  
            )
                new CompressedXContent(
            actual.priority(),  
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(
        assertThat(errors.get(0), instanceOf(MapperParsingException.class));  
                Metadata.builder(state.metadata())  
                            Collections.singletonList(new Index(".ds-logs-mysql-default-000001", "uuid"))
                ),
                1L,  
            Collections.singletonList("i*"),
        return putTemplate(xContentRegistry, request, Settings.EMPTY);
            throwables.get(0).getMessage(),
                        fail("the listener should not be invoked as validation should fail");
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("ct-best-compression-codec" + System.nanoTime(), 1);
        assertThat(settings.get("index.blocks.write"), equalTo("false"));
            public void onFailure(Exception e) {  
    }
                .build();  
                0L,
                    "template-referencing-context-as-ct",
            parsedMappings.get(1),
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
    public void testIndexTemplateValidationErrorsWithSpecifiedReplicas() throws Exception {
        CountDownLatch waitForIndexTemplate = new CountDownLatch(1);  
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", false)
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(settings.get("index.number_of_shards"), equalTo("3"));
                    public void onFailure(Exception e) {
            new Template(  
    public void testResolveMappings() throws Exception {  
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
        assertThat(  
                            + "      \"field2\": {\n"
                null  
        req.patterns(Arrays.asList("egg*", "baz"));
        );  
            );
        assertTemplatesEqual(
                    fail("failed to parse mappings: " + m.string());  
        // when(indicesServices.getRepositoriesServiceSupplier()).thenReturn(() -> repositoriesService);
                        new DataStream(
            ),
            }).collect(Collectors.toList());  
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();
            null,
                null,
                null,
import static org.opensearch.common.util.concurrent.ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME;
            .build();
        // Patterns with a common prefix and different literal suffixes after a wildcard
            createTestShardLimitService(randomIntBetween(1, 1000), false),
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "131m");
        ComponentTemplate ct2 = new ComponentTemplate(
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
                try {  
 * You may obtain a copy of the License at  
            InvalidIndexTemplateException.class,  
            assertThat(mappings.size(), equalTo(2));
        assertThat(throwables.get(0).getMessage(), containsString("name must not contain a space"));  
                Map<String, Object> expectedMappings;  
                        + "        }\n"
        {
            null,
                null,  
            1L,
                0L,
                            )
        assertTrue("Could not create component templates", waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS));  
                    "_doc",
        assertThat(errors.get(0).getMessage(), equalTo("failed to parse filter for alias [invalid_alias]"));
        assertEquals(
        request.patterns(singletonList("test_shards_wait*"));
        assertNotNull(state.metadata().componentTemplates().get("foo"));  
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
    }
        state = service.addComponentTemplate(state, true, "ct1", ct1);
                    null,
 */  
            contains("bar")  
                        "{\n"  
     */
            new ComposableIndexTemplate.DataStreamTemplate()
        assertThat(
        );  
        ClusterState state = ClusterState.EMPTY_STATE;
                null
            )  
        ComponentTemplate componentTemplate = new ComponentTemplate(templateApplier.apply(CodecService.DEFAULT_CODEC), 1L, new HashMap<>());
import org.opensearch.indices.IndexTemplateMissingException;
        assertThat(result, equalTo("my-template"));  
            // indices matched by templates without the data stream field defined don't get the default @timestamp mapping
            throwables.get(0).getMessage(),  
                }
            Arrays.asList("app-test-*-some_other-*"),
            TimeValue.timeValueSeconds(30L),  
            new Template(null, null, a3),
        Map<String, AliasMetadata> a3 = new HashMap<>();  
                        + "          \"properties\": {\n"
            null,
import static org.hamcrest.Matchers.empty;
    public void testIndexPrimaryShardsSetting() {
        );
    }
        assertThat(
            ComposableIndexTemplateTests::randomInstance  
            "testing",
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
            );  
            Collections.singletonList("i*"),
            null,
            null,
/*  
                        .createParser(  
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());  
        request.aliases(Collections.singleton(new Alias("foobar")));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")  
                        + "      }\n"
    public void testIndexTemplateValidationAccumulatesValidationErrors() {
                        + "        \"field2\": {\n"
            MetadataIndexTemplateService.patternsActuallyOverlap(
        // Add an additional template that matches our data stream at a lower priority
                        + "defined the index.hidden setting, which is not allowed"  
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();  
                        + "          \"type\": \"keyword\"\n"
                }  
        Template templateWithIndexHiddenSetting = new Template(  
/*
                        )
        CountDownLatch latch = new CountDownLatch(1);  
                    Collections.singletonMap("properties", Collections.singletonMap("field", Collections.singletonMap("type", "keyword")))  
                null,
            try {
                null,
            );
    }
            )  
        );  
                fail("failed to parse mappings: " + m.string());  
import org.opensearch.threadpool.ThreadPool;
                1L,  
import org.opensearch.common.compress.CompressedXContent;
            assertThat(
        final List<Throwable> throwables = new ArrayList<>();
        );
        assertThat(result, equalTo("my-template2"));  
        );  
            .build();
    /**
                }
                            + "  }"  
            @Override
                ),
                    )  
            null,
            )
        a2.put("bar", AliasMetadata.newAliasMetadataBuilder("bar").build());
                            + "      }\n"  
                + "from existing composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]);"  
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    "{\n"
            null,  
            parsedMappings.get(0),
            );
import org.opensearch.common.settings.Settings;
                            "the listener should not be invoked as the validation should be executed before any cluster state updates "
        request.patterns(singletonList("_test_shards*"));  
    public void testModifySystemTemplateViaUnknownSource() throws Exception {
        );  
import java.io.IOException;
        ClusterState state = ClusterState.EMPTY_STATE;
            Metadata invalidGlobalTemplateMetadata = Metadata.builder()
import static org.hamcrest.CoreMatchers.containsString;  
                + "take precedence during new index creation"
                            Collections.singletonList(new Index(".ds-unreferenced-000001", "uuid2"))  
            contains("global")
        ComponentTemplate componentTemplate3 = new ComponentTemplate(template, 1L, new HashMap<>());  
                e.getMessage(),
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
    public void testUpdateComponentTemplateWithIndexHiddenSetting() throws Exception {  
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {
        request.patterns(singletonList("test_shards_wait*"));  
    }
            "api",
            template.template(),  
        ComposableIndexTemplate expectedNoTemplate = new ComposableIndexTemplate(
                    expectedMappings = (Map<String, Object>) expectedMappings.get(MapperService.SINGLE_MAPPING_NAME);
                    }
            assertNotNull(mappings);  
            null,
            null
    }  
                    public void onResponse(AcknowledgedResponse response) {  
            null
            InvalidIndexTemplateException.class,
        assertThat(
                true,
                    throw new AssertionError(e);
                return null;
                ),
            null,
        request.patterns(singletonList("te*"));
            .build();
                        + "      }\n"
    }  
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            new CompressedXContent("{}"),
        a1.put("foo", AliasMetadata.newAliasMetadataBuilder("foo").build());  
        Template template = new Template(Settings.builder().build(), null, ComponentTemplateTests.randomAliases());  
            MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            null,
                    .put(
        final ClusterState finalState = state;  
            @Override  
        ComposableIndexTemplate t2 = new ComposableIndexTemplate(  
                        + "      \"field\": {\n"
            1L,
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);  
        assertThat(
            assertThat(parsedMappings.get(0), equalTo(firstMapping));
        ComponentTemplate systemTemplate = new ComponentTemplate(
            ),
            randomBoolean() ? Arrays.asList("c1", "c2") : Arrays.asList("c2", "c1"),
        MetadataIndexTemplateService service = getMetadataIndexTemplateService();
    public void testPutGlobalV2TemplateWhichProvidesContextWithContextDisabled() throws Exception {
            ),
                null,  
            Objects.nonNull(actualTemplate),  
            contains("sneaky-hidden")
            null
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                null
        when(clusterService.getSettings()).thenReturn(settings);  
     */  
        state = service.addIndexTemplateV2(state, false, "app-test-some", t1);
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
        PutRequest request,
                        )
            e.getCause().getCause().getMessage(),
        // Test that only the high priority template reports the data stream as using it
        ThreadContext context = getInstanceFromNode(ThreadPool.class).getThreadContext();
            throwables.get(0).getMessage()  
                    )  
 * specific language governing permissions and limitations
     */
                        );
                is(
        );  
                            new DataStream.TimestampField("@timestamp"),  
            Arrays.asList("ct_low", "ct_high"),
        verifyTemplateCreationUsingContext("1");
            null,
            "test",  
                true,
        ClusterState state = ClusterState.EMPTY_STATE;
    public void testPutGlobalV2TemplateWhichProvidesContextWithNonExistingVersion() throws Exception {  
            1L,
                    }
                        + "        }\n"
    public void testDistinguishableMultiWildcardTemplatesAccepted() throws Exception {  
import java.util.concurrent.TimeUnit;  
    public void testPutGlobalV2TemplateWhichProvidesContextWithLatestVersion() throws Exception {  
        ComposableIndexTemplate template = new ComposableIndexTemplate(
    public void testRemoveComponentTemplateInUse() throws Exception {
            componentTemplate,
    public void testUpdatingV1NonStarWithChangedPatternsTemplateGeneratesWarning() throws Exception {
            templateApplier.apply(CodecService.LZ4),
            }
                    errLatch.countDown();
                    @Override
            }  
                null,
        PutRequest request = new PutRequest("test", "test_replicas");
                        + "        \"field1\": {\n"
                @Override
            .build();
    public void testPutExistingComponentTemplateIsNoop() throws Exception {
            null
            new Template(
            e.getMessage(),
import static org.hamcrest.Matchers.matchesRegex;  
        );
        );
    /**  
                "composable template [logs] with index patterns [logs-*-*], priority [100] and no data stream "  
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    .put(  
            null,  
        List<Throwable> errors = putTemplate(xContentRegistry(), request);
                Arrays.asList("egg*", "baz"),
        expectThrows(
                .collect(Collectors.toList()),
            ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", randomBoolean())
            );
import java.util.List;
        }).collect(Collectors.toList());  
        List<String> patterns = new ArrayList<>(template.indexPatterns());
            3L,
import org.opensearch.indices.IndicesService;
            Collections.singletonList("i*"),
                        + "    }"
        state = service.addIndexTemplateV2(state, true, "my-template", it);
                + "composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]); this template [v1-template] may "
        state = metadataIndexTemplateService.addComponentTemplate(state, false, "foo", componentTemplate);
            null
        metadataIndexTemplateService.putComponentTemplate(
        state = metadataIndexTemplateService.addComponentTemplate(state, true, "foo", componentTemplate);
            @Override
    public void testUpdatingV1NonStarTemplateWithUnchangedPatternsGeneratesWarning() throws Exception {  
        );
            null,
            TimeValue.timeValueSeconds(30),
            containsInAnyOrder("foo-2", "foo-1", "global")
            ex.getMessage().contains("specifies a context which is not loaded on the cluster")
        assertThat(
                null,
        updatedState = MetadataIndexTemplateService.innerRemoveIndexTemplateV2(clusterState, "foo");  
            new ComposableIndexTemplate.DataStreamTemplate()  
                Collections.singletonMap(
                            )
                state,  
            firstMapping = Map.of("_doc", Map.of("properties", Map.of("field1", Map.of("type", "keyword"))));  
                null,
        ComposableIndexTemplate it = new ComposableIndexTemplate(
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)  
            null,
        state = service.addIndexTemplateV2(state, true, "my-template", it);
            null,  
        assertNotNull(state.metadata().templatesV2().get("foo"));
                        + "          \"type\": \"text\"\n"  
        );  
            IllegalArgumentException e = expectThrows(
    }
            actual.getDataStreamTemplate()  
            );
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);  
        );
        );
                true,
        );
            containsString(
        ComposableIndexTemplate fooPatternIndexTemplate = new ComposableIndexTemplate(  
        );  
                    "global index template [invalid_global_template], composed of component templates [ct] "
        client().admin().indices().prepareDeleteTemplate("*").get(); // Delete all existing templates
        assertThat(state.metadata().templates().get("v1-template").patterns(), containsInAnyOrder("fo*", "baz"));  
        ComponentTemplate ct = new ComponentTemplate(new Template(null, new CompressedXContent("{}"), null), null, null);
                        }  
                        + "          }\n"  
        IllegalArgumentException e = expectThrows(
import org.opensearch.index.engine.EngineConfig;  
        metadataIndexTemplateService.putIndexTemplateV2(
    }
            null,  
            TimeValue.timeValueSeconds(30L),  
                globalIndexTemplate,  
                null,
                "timeseries-template",
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")
                null,
            template,
    }  
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");  
            Settings.builder().build(),
            if (err.get() != null) {
    }
                null
            containsString(
            assertThat(mappings.size(), equalTo(2));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                5L,
            null,  
        } catch (IllegalArgumentException e) {  
        request.settings(settingsBuilder.build());
            );
 * The OpenSearch Contributors require contributions made to  
            matchesRegex("composable template \\[my-template\\] template after composition with component templates .+ is invalid")
 *  
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")  
        service.putIndexTemplateV2(
        };  
                    waitForIndexTemplate.countDown();
        );  
    private String verifyTemplateCreationUsingContext(String contextVersion) throws Exception {
        );  
        final ClusterState throwState = ClusterState.builder(state).build();
        assertThat(e.getCause().getMessage(), containsString("invalid composite mappings for [my-template]"));  
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);  
                    return null;
    }  
                .map(IndexTemplateMetadata::name)  
            template.metadata(),
            null
                List.of("timeseries*"),
    public void testAliasInvalidFilterInvalidJson() throws Exception {
            getInstanceFromNode(ThreadPool.class).getThreadContext().putTransient(ACTION_ORIGIN_TRANSIENT_NAME, TEMPLATE_LOADER_IDENTIFIER);  
            template,  
        pr.order(randomIntBetween(0, 10));  
    }
        );  
            null,
        Map<String, AliasMetadata> a1 = new HashMap<>();
            null,
    }
    public void testIndexTemplateValidationWithDefaultReplicas() throws Exception {
                null
            // if the index name matches that of a data stream backing index
            Collections.singletonList("in*"),  
                    "index template [foo2] has index patterns [abc, baz*] matching patterns from existing "
        );
            null,  
        putTemplateDetail(new PutRequest("test", "foo-1").patterns(singletonList("foo-*")).order(1));  
                        + "templates [foo] with patterns (foo => [egg*, baz]) that have the same priority [0], multiple index templates may not "
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async");
 * license agreements. See the NOTICE file distributed with
                        + "          \"type\": \"text\"\n"
            );
            Map<String, Object> thirdMapping = Map.of("_doc", Map.of("properties", Map.of("field2", Map.of("type", "integer"))));  
            state = service.addIndexTemplateV2(state, true, "timeseries-template", it);  
        PutRequest request = new PutRequest("test", "test_replicas");  
                            )
                null,
                return MapperService.parseMapping(new NamedXContentRegistry(Collections.emptyList()), m.string());  
            new Template(
            100L,  
        assertNull(MetadataIndexTemplateService.findV2Template(state.metadata(), "index", true));  
        assertThat(throwables.get(0).getMessage(), containsString("[3]: cannot be greater than number of shard copies [2]"));
        ComposableIndexTemplate mysqlTemplate = new ComposableIndexTemplate(
        );
        request.patterns(singletonList("test_wait_shards_default_replica*"));
                    err.set(exception);  
        );  
                        + "      }\n"  
    public static void assertTemplatesEqual(ComposableIndexTemplate actual, ComposableIndexTemplate expected) {
                        + "        }\n"  
            SettingsException.class,
        );
            null,
            }
    public void testPutGlobalTemplateWithIndexHiddenSetting() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            + "        \"@timestamp\": {\n"
        ClusterService clusterService = node().injector().getInstance(ClusterService.class);
                Collections.singletonMap(
                        "{\n"  
            1L,  
            service.removeComponentTemplate(
                    .put(  
        final CountDownLatch latch = new CountDownLatch(1);  
            );
        return getInstanceFromNode(MetadataIndexTemplateService.class);  
            List.of("foo"),  
            xContentRegistry,  
                        + "      \"properties\": {\n"
        state = metadataIndexTemplateService.addIndexTemplateV2(state, true, "foopatternindextemplate", fooPatternIndexTemplate);  
        );
                    logger.error(e);
            new SystemIndices(Collections.emptyMap()),
        // Patterns that share a genuine conflict: baz matches baz*  
            .metadata(  
                Objects.nonNull(actualTemplate.mappings()),  
                .stream()  
            assertThat(e.getMessage(), not(containsStringIgnoringCase("foopatternindextemplate")));  
            }
                ),  
        // Test adding a higher priority version that would cause problems
            null,
            null
            null
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(  
            context
        state = service.addIndexTemplateV2(state, randomBoolean(), "my-template", it);  
        ComposableIndexTemplate it = new ComposableIndexTemplate(
        );
import org.opensearch.indices.SystemIndices;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")  
                .startObject("field2")
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
                    new ComposableIndexTemplateMetadata(Map.of("invalid_global_template", invalidGlobalTemplate))
                new ActionListener<AcknowledgedResponse>() {
                            new DataStream.TimestampField("@timestamp"),
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(1);  
    }  
        assertThat(  
            @Override
        aliases.add(new Alias("invalid_alias").filter("abcde"));
        state = MetadataIndexTemplateService.innerPutTemplate(state, req, IndexTemplateMetadata.builder("v1-template"));
            null,
            new PutRequest("testFindTemplatesWithHiddenIndices", "bar").patterns(singletonList("bar-*")).order(between(0, 100))
            () -> metadataIndexTemplateService.putComponentTemplate(
        request.settings(settingsBuilder.build());
            assertNotNull(mappings);
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);  
        state = ClusterState.builder(state)
            null,
        assertWarnings(  
        ComposableIndexTemplate actualNoTemplate = new ComposableIndexTemplate(
                            + "  }"
 * the Apache License, Version 2.0 (the "License"); you may
            new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS),  
            null,
            Template template = new Template(
            "index template [v2-template] has index patterns [foo-bar-*, eggplant] matching patterns "  
    }  
                } catch (Exception e) {
        assertThat(settings.get("index.codec"), equalTo(CodecService.ZLIB));
                    null,  
                            expectedTemplate.mappings().string()  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            public void onFailure(Exception e) {
    public void testFindTemplatesWithHiddenIndices() throws Exception {  
        assertThat(e.getMessage(), containsString("index template [foo] already exists"));
                0L,  
                new CompressedXContent(  
        Map<String, Object> meta = Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4));  
            List.of("*"),
                        + "      }\n"
        state = service.addIndexTemplateV2(state, false, "logs", template);
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();
        assertTrue(  
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
        state = service.addIndexTemplateV2(state, false, "app-test-some-other", t2);  
            // add an invalid global template that specifies the `index.hidden` setting  
        assertNotNull(state.metadata().templatesV2().get("foo"));  
            componentTemplateName,
            .put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true)
        // invalid json: put index template fails
                        IndexMetadata.builder(".ds-unreferenced-000001")
                            "the listener should not be invoked as the validation should be executed before any cluster state updates "
        assertThat(errors.get(0).getMessage(), containsString("analyzer [custom_1] has not been configured in mappings"));
            new Template(Settings.builder().put("number_of_replicas", 2).put("index.blocks.write", true).build(), null, null),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 5))
    public void testAsyncTranslogDurabilityBlocked() {
                        + "        }\n"
            );
            );  
            10L,
import java.util.Set;
            List.of("foo"),
        assertThat(  
                        + "  }"  
                        fail("the listener should not be invoked as validation should fail");
        ComponentTemplate componentTemplate2 = new ComponentTemplate(template, 1L, new HashMap<>());
                    actualMappings = parser.map();  
                    "{\n"  
        expectThrows(
            "Invalid exception message." + ex.getMessage(),  
        assertThat(errors.get(0).getMessage(), containsString("Failed to parse mapping "));
            null,
                .stream()
                } catch (Exception e) {
                        + "    }"
        request.patterns(singletonList("test_shards*"));
            e.getMessage(),
        );
        );
                        + "        \"field2\": {\n"  
import org.opensearch.cluster.service.ClusterService;  
    public void testIndexTemplateFailsToOverrideComponentTemplateMappingField() throws Exception {
            0L,
        Settings settings = Settings.builder().put(incomingNodeScopedSettings).put(PATH_HOME_SETTING.getKey(), "dummy").build();
                new ComposableIndexTemplate.DataStreamTemplate()
        Settings settings = MetadataIndexTemplateService.resolveSettings(clusterService.state().metadata(), indexTemplateName);
            }  
        });
                            .settings(
        assertTrue(
            .put(IndexMetadata.SETTING_BLOCKS_READ, randomBoolean())
        if (randomBoolean()) {  
                    "_doc",
    }
        );  
            null,
                    "{\n"
            null  
    public void testUserDefinedMappingTakesPrecedenceOverDefault() throws Exception {
                        fail("the listener should not be invoked as validation should fail");
import org.opensearch.common.util.concurrent.ThreadContext;
            );
            null,  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, clusterSettings);
import org.opensearch.index.IndexSettings;
            );  
                        + "      }\n"
        );
    }
        );
                        + "        \"field1\": {\n"  
        );
            );
            containsInAnyOrder("global", "sneaky-hidden")
                            new DataStream.TimestampField("@timestamp"),  
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
 * Modifications Copyright OpenSearch Contributors. See
        IndicesService indicesServices = mock(IndicesService.class);
        state = MetadataIndexTemplateService.innerPutTemplate(state, pr, new IndexTemplateMetadata.Builder("id"));
    }
            assertThat(e.getMessage(), containsStringIgnoringCase("globalindextemplate2"));
                1L,
        state = service.addComponentTemplate(state, true, "ct", ct);  
        );  
                new CompressedXContent(
    }  
        ClusterState state = ClusterState.EMPTY_STATE;  
                    "_doc",
                throw err.get();
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());  
            ex.getMessage().contains("A system template can only be created/updated/deleted with a repository")
                TimeValue.timeValueSeconds(30L),
                    XContentParser parser = MediaTypeRegistry.JSON.xContent()
        assertThat(
            null
                } catch (Exception e) {
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(  
        ClusterState updatedState = MetadataIndexTemplateService.innerRemoveIndexTemplateV2(state, "foo");
                    )  
        assertWarnings(
            null,
                "expecting an exception as updating the component template would yield the global templates to include the index.hidden "  
            null,  
                "logs-template",
            null
                .stream()  
        Metadata metadata = Metadata.builder().build();
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        );  
        // Identical patterns overlap with themselves
            null,
            null
                        );  
        latch.await(5, TimeUnit.SECONDS);  
                new CompressedXContent(
            TimeValue.timeValueSeconds(5),  
                templateWithHiddenSetting,  
import org.opensearch.core.action.ActionListener;
            Arrays.asList("i*"),  
                true,
        try (ThreadContext.StoredContext ignore = context.stashContext()) {
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", false)
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());
            ComposableIndexTemplate newTemplate = new ComposableIndexTemplate(  
            randomBoolean() ? Arrays.asList("c1", "c2") : Arrays.asList("c2", "c1"),
 */  
        List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(state, "my-template", "my-index");  
                List.of("ct1"),  
                    "{\n"
        patterns.add("new-pattern");  
            .build();
        when(clusterService.state()).thenReturn(clusterState);
                true,
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            null,
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", true)
        putTemplateDetail(
        IllegalArgumentException e = expectThrows(
            null
            equalTo(Objects.nonNull(expectedTemplate))
        List<Throwable> errors = putTemplateDetail(
        );
        );  
            assertThat(parsedMappings.get(1), equalTo(secondMapping));  
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date")))
        IllegalArgumentException ex = expectThrows(  
            equalTo(  
            expected.version(),
            null,
                "testing",
            // user defines a @timestamp mapping as part of a composable index template
                    true,
    public void testPutGlobalV2TemplateWhichProvidesContextInComposedOfSection() throws Exception {  
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", null)
        );
    }
    public void testResolveConflictingMappings() throws Exception {  
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
     */  
        // Now try to update the existing v1-template
        assertThat(e.getMessage(), containsString("component template [foo] already exists"));  
                .map(IndexTemplateMetadata::name)
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
            }  
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "sneaky1", false)
            @Override  
            );
            null,
            templateApplier.apply(CodecService.LZ4),
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            null,
            // user defines a @timestamp mapping as part of a component template
        String result = MetadataIndexTemplateService.findV2Template(state.metadata(), "index", true);
        List<Map<String, AliasMetadata>> resolvedAliases = MetadataIndexTemplateService.resolveAliases(state.metadata(), "my-template");  
        ComposableIndexTemplate it = new ComposableIndexTemplate(
                ActionListener.wrap(r -> fail("should have failed!"), exception -> {
                "_doc",
            public void onResponse(AcknowledgedResponse response) {
            20L,
            null
            new Template(
            .build();
            "index template [v2-template] has index patterns [foo-bar-*, eggplant] matching patterns "  
            new Template(settings, mappings, null),
            null,
            expected.getDataStreamTemplate()  
                        + "      \"properties\": {\n"  
                        public void onFailure(Exception e) {  
            context
            secondMapping = Map.of("_doc", Map.of("properties", Map.of("field2", Map.of("type", "integer"))));  
        assertThat(  
            expected.composedOf(),
            List.of(componentTemplateName),  
    protected Settings featureFlagSettings() {
                } catch (Exception e) {
                    "{\n"
                    "{\n"
        assertThat(  
        );
    public void testFindV2TemplatesForHiddenIndex() throws Exception {  
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        assertThat(actualNoTemplate, equalTo(expectedNoTemplate));  
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        assertThat(metadataIndexTemplateService.addComponentTemplate(state, false, "foo", componentTemplate), equalTo(state));  
                throwables.add(e);  
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())  
        CompressedXContent mappings = new CompressedXContent(
        ComposableIndexTemplate it = new ComposableIndexTemplate(
        );
                    }  
                state,
                    TimeValue.timeValueSeconds(30L),  
                DataStream.getDefaultBackingIndexName("timeseries", 1L)  
                    )
                    .put(
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "2");  
        {  
        assertThat(MetadataIndexTemplateService.innerPutTemplate(state, pr, new IndexTemplateMetadata.Builder("id")), equalTo(state));
            errLatch.await(5, TimeUnit.SECONDS);
    public void testUnreferencedDataStreamsWhenAddingTemplate() throws Exception {
                .collect(Collectors.toList()),  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, clusterSettings);  
        assertThat(
        }
    /**
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();
        );  
            "legacy template [v1-template] has index patterns [*, baz] matching patterns from existing "
        });
            )
            null,  
                "composable template [logs] with index patterns [logs-postgres-*], priority [100] would "
                    XContentParser parser = MediaTypeRegistry.JSON.xContent()
            List.of("*"),
            "good",
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
    }  
        List<String> indexPatterns = List.of("foo*");
        service.addIndexTemplateV2(stateWithDSAndTemplate, false, "logs", nonDSTemplate);
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            public void onResponse(MetadataIndexTemplateService.PutResponse response) {
            IllegalArgumentException.class,
            ComponentTemplateTests.randomAliases()
            public void onResponse(AcknowledgedResponse response) {  
            }
        if (actualTemplate != null) {
            null,  
                new CompressedXContent(  
        SystemTemplateMetadata systemTemplateV2Metadata = fromComponentTemplateInfo(systemTemplateMetadata.name(), 2);  
        {
        Context context = new Context(systemTemplateMetadata.name(), Long.toString(2L), Map.of());
        ComponentTemplate ct1 = new ComponentTemplate(
        assertThat(
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(1);  
        PutRequest request = new PutRequest("test", "test_replicas");
        );
                List.of("*"),  
            null,
            true,  
        Function<String, Template> templateApplier = codec -> new Template(  
                if (actualMappings.size() == 1 && actualMappings.containsKey(MapperService.SINGLE_MAPPING_NAME)) {
                new ActionListener<AcknowledgedResponse>() {
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();  
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", null)  
        state = service.addComponentTemplate(state, true, "ct_high", ct1);  
        );  
                }
                systemTemplateMetadata.fullyQualifiedName(),
        final ClusterState throwState = ClusterState.builder(state).build();  
        ClusterState state = ClusterState.EMPTY_STATE;
            Map<String, Object> firstMapping = Map.of("_doc", Map.of("properties", Map.of("field1", Map.of("type", "keyword"))));
                TimeValue.timeValueSeconds(30L),  
                    @Override
                List.of("timeseries*"),
            .metadata(
        request.settings(settingsBuilder.build());  
        assertNotNull(state.metadata().componentTemplates().get("bar"));  
        assertTrue(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("logs-*"), Arrays.asList("logs-prod-*")));  
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);  
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {  
        SystemTemplateMetadata systemTemplateMetadata = SystemTemplateMetadata.fromComponentTemplateInfo("sys-template", 1L);  
                createComponentTemplateListener
                        + "    }"
            clusterService,
                    )
            null,  
        List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
        ctLatch.await(5, TimeUnit.SECONDS);
            Collections.singletonList("ct"),
                        + "            }\n"
                    public void onFailure(Exception e) {
        assertNotNull(state.metadata().templates().get("id"));  
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            Map<String, Object> secondMapping = Map.of("_doc", Map.of("properties", Map.of("field1", Map.of("type", "keyword"))));  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, clusterSettings);
            e.getCause().getCause().getMessage(),
                state,  
            .build();
                        + "        \"@timestamp\": {\n"
        );
        );
            null,
        state = metadataIndexTemplateService.addIndexTemplateV2(state, true, "globalindextemplate2", secondGlobalIndexTemplate);
        assertThat(
        state = metadataIndexTemplateService.addComponentTemplate(state, false, "foo", componentTemplate);
        Set<Alias> aliases = new HashSet<>();  
            null,
                            + "    \"properties\": {\n"
            1L,  
        client().admin().indices().prepareDeleteTemplate("*").get(); // Delete all existing templates
        // test remove a template which is not used by a data stream but index patterns can match
    public void testResolveSettingsWithContextLatest() throws Exception {  
            List.of(),  
                if (expectedMappings.size() == 1 && expectedMappings.containsKey(MapperService.SINGLE_MAPPING_NAME)) {  
    /**
                equalTo(Objects.nonNull(expectedTemplate.mappings()))
            1L,
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
            null,  
                        + "        \"type\": \"keyword\"\n"  
        assertTrue("Expected index template to have been created.", waitForIndexTemplate.await(10, TimeUnit.SECONDS));
            null,  
                    Collections.singletonMap("properties", Collections.singletonMap("field2", Collections.singletonMap("type", "text")))  
            null,
                null,  
        // - index template
                .stream()
    }
            null,  
            node().injector().getInstance(ClusterService.class).state().metadata().templatesV2().get(indexTemplateName),  
                new CompressedXContent(
        );  
        assertThat(errors.size(), equalTo(1));  
        );  
            )
                }
                null,  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
                new ActionListener<AcknowledgedResponse>() {
        );  
            assertTrue(  
            }).collect(Collectors.toList());
            mappings = MetadataIndexTemplateService.collectMappings(  
                        + "          \"type\": \"object\",\n"
                        )
                true,  
        );  
                )  
                    Collections.singletonMap("properties", Collections.singletonMap("field2", Collections.singletonMap("type", "keyword")))  
        ComposableIndexTemplate it = new ComposableIndexTemplate(
                DataStream.getDefaultBackingIndexName("logs", 1L)  
        service.putTemplate(request, new MetadataIndexTemplateService.PutListener() {
        state = service.addIndexTemplateV2(state, true, "my-template", it);
            @Override
            TimeValue.timeValueSeconds(30L),
                        + "match during index creation, please use a different priority"  
    public void testIndexTemplateWithAliasNameEqualToTemplatePattern() {
        final ClusterState state = client().admin().cluster().prepareState().get().getState();  
                DataStream.getDefaultBackingIndexName("timeseries-template", 1L)
            pr.aliases(Collections.singleton(new Alias("alias")));
            null,
                .map(IndexTemplateMetadata::name)
                                Settings.builder()
    }  
                fail("failed to parse mappings: " + m.string());  
                null,  
        req.patterns(Arrays.asList("*", "baz"));
                            new NamedXContentRegistry(Collections.emptyList()),
        metadataIndexTemplateService.putComponentTemplate(
                new ComposableIndexTemplate.DataStreamTemplate()
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
            template.composedOf(),
                        + "          \"type\": \"text\"\n"
                TimeValue.timeValueSeconds(30L),  
                            new DataStream.TimestampField("@timestamp"),
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(3);
        assertThat(e.name(), equalTo("template"));  
        e = expectThrows(IllegalArgumentException.class, () -> {  
 *
            new Environment(builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build(), null),  
                }  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request);  
                Metadata.builder(state.metadata())
                        + "        \"field2\": {\n"
        ClusterState state = ClusterState.EMPTY_STATE;
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
    public void testFindTemplates() throws Exception {
        ComponentTemplate ct1 = new ComponentTemplate(
            .build();
                createComponentTemplateListener
                            fail("the listener should not be invoked as validation should fail");
            ComponentTemplateTests.randomAliases()  
                .collect(Collectors.toList()),  
            null,  
                ),  
            contains("bar")
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());  
                "template-referencing-ct-with-hidden-index-setting",
            "index template [v2-template] has index patterns [foo-bar-*, eggplant] matching patterns "  
    }
                        new DataStream(
        ComponentTemplate ct2 = new ComponentTemplate(  
                template,  
                .startObject("properties")
            null,
                + "be ignored in favor of a composable template at index creation time"
        assertNotNull(e.getCause().getCause());
        ClusterService clusterService = mock(ClusterService.class);
                waitToCreateComponentTemplate.countDown();
                ActionListener.wrap(r -> fail("should have failed!"), exception -> {
            );
                Collections.singletonMap(
        assertNotNull(state.metadata().templatesV2().get("v2-template"));
        assertThat(e.getMessage(), containsString("index template [template] specifies " + "component templates [bad] that do not exist"));
            containsInAnyOrder("foo-2", "foo-1", "global")
            new ComposableIndexTemplate.DataStreamTemplate()
            template,  
            null,
        assertThat(
        assertThat(
            .put(CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "130m")  
                        + "        }\n"  
            List.of("foo-*"),
                    new ActionListener<AcknowledgedResponse>() {
    public void testBrokenMapping() throws Exception {
            null
                ),  
        IndexTemplateMissingException e = expectThrows(
            parsedMappings.get(2),
                        + "      \"properties\": {\n"
        assertThat(errors.get(0).getMessage(), equalTo("alias [foobar] cannot be the same as any pattern in [foo, foobar]"));
            null
            ComponentTemplate ct1 = new ComponentTemplate(
                TimeValue.timeValueSeconds(30L),  
        // This must not throw: the second pattern is distinguishable from the first because
        ComponentTemplate systemTemplate = new ComponentTemplate(
    }
                        + "    }"
        );
            MetadataIndexTemplateService.findV2Template(invalidGlobalTemplateMetadata, "index-name", false);
        verifyTemplateCreationUsingContext("_latest");
            null,  
        assertThat(  
            template.priority(),
        request.aliases(aliases);
                        + "        \"field1\": {\n"
                .map(IndexTemplateMetadata::name)
        request.settings(settingsBuilder.build());  
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                try (
        );  
        assertThat(metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template), equalTo(state));
            ComposableIndexTemplate it = new ComposableIndexTemplate(  
                        + "      \"properties\": {\n"  
                            + "    \"properties\": {\n"  
        PutRequest request = new PutRequest("api", "blank_mapping");  
    public void testAddComponentTemplate() throws Exception {  
                        )  
            assertThat(parsedMappings.get(2), equalTo(thirdMapping));
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", false)  
        ComposableIndexTemplate secondGlobalIndexTemplate = new ComposableIndexTemplate(
        assertThat(
                        + "    }"
                        )
        assertThat(resolvedAliases, equalTo(Arrays.asList(a4, a3, a1, a2)));  
        return throwables;
        ComposableIndexTemplate nonDSTemplate = new ComposableIndexTemplate(
 * not use this file except in compliance with the License.
                + "be ignored in favor of a composable template at index creation time"
        );  
                .settings(Settings.builder().put("index.hidden", true).build())
                        + "      }\n"
        assertThat(  
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),
                        + "match during index creation, please use a different priority"
                null
        assertTrue(
            }).collect(Collectors.toList());
        try {
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo", componentTemplate)
        ClusterState state = ClusterState.EMPTY_STATE;
            Arrays.asList("i*"),
                        + "        }\n"
import org.opensearch.core.xcontent.XContentParser;  
            0L,
 * this file be licensed under the Apache-2.0 license or a
                .map(IndexTemplateMetadata::name)  
            }
    }
        }
            containsString("Failed to parse value [0] for setting [index.number_of_shards] must be >= 1")
        );
            Arrays.asList("foo-bar-*", "eggplant"),
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            parsedMappings.get(2),
        ComponentTemplate ct2 = new ComponentTemplate(  
                    public void onFailure(Exception e) {  
            service.addIndexTemplateV2(stateWithDS, false, "logs", nonDSTemplate);  
                    }
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "sneaky1", null)
        {  
                waitToCreateComponentTemplate.countDown();
            new Template(
            )  
    }
        assertNotNull(state.metadata().templatesV2().get("foo"));
        return indexTemplateName;
    }
        return Settings.builder().put(super.featureFlagSettings()).put(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false).build();
                        + "    }"
                null
            0L,
                systemTemplate,
                null
        assertThat(state.metadata().templates().get("v1-template").patterns(), containsInAnyOrder("*", "baz"));
import org.opensearch.common.util.FeatureFlags;
        // Test replacing it with a version without the data stream config
            null,  
            ActionListener.wrap(r -> ctLatch.countDown(), e -> fail("unexpected error"))
    public void testPuttingV2TemplateGeneratesWarning() throws Exception {
    }
                        fail("the listener should not be invoked as validation should fail");  
                "timeseries-template",
                latch.countDown();
            null,  
                null,
                        + "          \"type\": \"text\"\n"
    protected boolean resetNodeAfterTest() {
            Settings.builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(),
import org.opensearch.indices.InvalidIndexTemplateException;  
        PutRequest request = new PutRequest("api", "foobar_template");  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
            ComposableIndexTemplate template = new ComposableIndexTemplate(  
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),  
        final List<Throwable> throwables = new ArrayList<>();
        assertThat(e.getMessage(), equalTo("index_template [foo] missing"));
                            "logs-mysql-default",
            metadataIndexTemplateService.putComponentTemplate(
            List.of("ct-with-index-hidden-setting"),
            .build();
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),  
                new ActionListener<AcknowledgedResponse>() {
            assertNotNull(mappings);
            indexPatterns,
                }
                    }
            new Template(
        state = service.addComponentTemplate(state, true, "ct_low", ct2);  
 * under the License.  
            );  
            } catch (Exception e) {
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())  
            template,
            null,
                        + "              \"type\": \"integer\"\n"  
                waitToCreateComponentTemplate.countDown();
    }
        ClusterState state = ClusterState.EMPTY_STATE;
        assertTemplatesEqual(state.metadata().templatesV2().get("v2-template"), v2Template);  
                .startObject()  
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date")))  
            MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
import org.opensearch.index.mapper.MapperService;
                    new CompressedXContent(
                null  
        state = service.addIndexTemplateV2(state, true, "my-template", it);
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(  
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())  
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                0L,
            new Context("any")  
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(
        ComponentTemplate ct1 = new ComponentTemplate(  
                try {  
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(  
            }
    }  
                    public void onResponse(AcknowledgedResponse response) {  
                ActionListener.wrap(() -> {})
        );  
        );
            null,
                    return null;
        assertThat(state.metadata().componentTemplates().get("foo"), equalTo(componentTemplate));
                null  
        state = service.addComponentTemplate(state, true, "ct_high", ct1);
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
            null
        );
        req.patterns(Arrays.asList("egg*", "baz"));
        );  
            null,
                        + "          \"type\": \"object\",\n"  
            ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "foo", template);
            assertNotNull(mappings);
        PutRequest request = new PutRequest("api", "broken_mapping");  
                null,  
                                Settings.builder()  
        Settings clusterSettings = Settings.builder().build();  
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
            }  
                "test",  
                null,
            null,
import org.opensearch.index.codec.CodecService;  
    }  
        // unknown
            containsString("unknown value for [index.shard.check_on_startup] " + "must be one of [true, false, checksum] but was: blargh")  
            new Template(null, null, a4),
                null
        state = service.addComponentTemplate(state, true, "ct", ct);  
                null,
    public void testRemoveIndexTemplateV2() throws Exception {
        List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(state, "my-template", "my-index");  
                try {
            }
        );
        // update the component template to set the index.hidden setting
        putTemplateDetail(new PutRequest("testFindTemplatesWithHiddenIndices", "global").patterns(singletonList("*")));
                null,
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
            List.of("logs-*"),
            );
                    public void onFailure(Exception e) {
        putTemplateDetail(new PutRequest("testFindTemplatesWithHiddenIndices", "foo-2").patterns(singletonList("foo-*")).order(2));  
import org.opensearch.action.admin.indices.alias.Alias;
        // Now try to update the existing v1-template
                TimeValue.timeValueSeconds(30L),
        waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS);
            actual.version(),
    }
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());
            );
        assertThat(
        }
                + "composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]); this template [v1-template] may "  
                100L,
            new Template(  
import static org.opensearch.env.Environment.PATH_HOME_SETTING;  
            null,  
        );
                        + "      \"field3\": {\n"
                try {
            ComposableIndexTemplate nonDSTemplate = new ComposableIndexTemplate(  
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),  
            if (err.get() != null) {
        assertNotNull(mappings);
                .endObject()
            parsedMappings.get(1),
        state = MetadataIndexTemplateService.innerPutTemplate(state, req, IndexTemplateMetadata.builder("v1-template"));  
        ClusterState stateWithDS = ClusterState.builder(state)  
        PutRequest request = new PutRequest("test", "test_specified_replicas");
        );
                "template-referencing-context-as-ct",
                "expected both templates to have either mappings or no mappings",
    }  
                    .put(  
            "legacy template [v1-template] has index patterns [egg*, baz] matching patterns "
                .collect(Collectors.toList()),
            )
        request.patterns(Arrays.asList("foo", "foobar"));
            .metadata(
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {  
            null,  
                    public void onResponse(AcknowledgedResponse response) {  
                        + "      \"properties\": {\n"
        }
                        + "      \"properties\": {\n"  
            List.of("foo"),
                Arrays.asList("abc", "baz*"),
        assertNull(updatedState.metadata().templatesV2().get("foo"));  
        template = new Template(
    public void testUpdateComponentTemplateFailsIfResolvedIndexTemplatesWouldBeInvalid() throws Exception {
                })
        state = service.addComponentTemplate(state, true, "ct_low", ct2);
        req.patterns(Arrays.asList("fo*", "baz"));
                new ComposableIndexTemplate.DataStreamTemplate()
import static org.mockito.Mockito.when;
            null,  
        final ClusterState clusterState = metadataIndexTemplateService.addIndexTemplateV2(stateWithDS, false, "foo", templateToRemove);
                "_doc",
                })
                    actualMappings = (Map<String, Object>) actualMappings.get(MapperService.SINGLE_MAPPING_NAME);  
                null,
        state = service.addComponentTemplate(state, true, "c2", ct2);
        ComponentTemplate componentTemplate = new ComponentTemplate(template, 1L, new HashMap<>());
import org.opensearch.core.xcontent.NamedXContentRegistry;
        RepositoriesService repositoriesService = mock(RepositoriesService.class);  
            expected.indexPatterns(),  
            "template",
import org.opensearch.index.mapper.MapperParsingException;
        try {  
        Template template = new Template(Settings.builder().build(), null, ComponentTemplateTests.randomAliases());  
        // the literal segment after the first wildcard differs (_other vs nothing).
                        + "          }\n"
    public void testUpdateIndexTemplateV2() throws Exception {
        });  
            )  
                }
        );
    public void testPutGlobalV2TemplateWhichProvidesContextNotPresentInState() throws Exception {
            new PutRequest("testFindTemplatesWithHiddenIndices", "sneaky-hidden").patterns(singletonList("sneaky*"))  
        ComposableIndexTemplate template = new ComposableIndexTemplate(
            ),  
        {  
            null,
            true,
            null,
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),
        );  
        );
        e = expectThrows(IllegalArgumentException.class, () -> {
            public void onResponse(AcknowledgedResponse response) {
                Arrays.asList("app-test-*-some_other-*")
            null,
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {  
            actual.indexPatterns(),  
            actual.metadata(),
import org.opensearch.indices.replication.common.ReplicationType;
import java.util.concurrent.atomic.AtomicReference;
                        + "        }\n"  
                                Settings.builder()
                    expectedMappings = parser.map();  
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
            containsString("Failed to parse value [0] for setting [index.number_of_shards] must be >= 1")
                TimeValue.timeValueSeconds(30),
        assertThat(errors.size(), equalTo(1));
                ),  
        expectThrows(  
        List<Throwable> throwables = putTemplateDetail(request);
                null,
        state = metadataIndexTemplateService.addIndexTemplateV2(state, randomBoolean(), "bar", newTemplate);
        ClusterState state = ClusterState.EMPTY_STATE;
            }  
        ComposableIndexTemplate it = new ComposableIndexTemplate(
            null,
                        + "      }\n"
        ComponentTemplate ct2 = new ComponentTemplate(  
        ComposableIndexTemplate highPriorityTemplate = new ComposableIndexTemplate(
            null
import static org.opensearch.indices.ShardLimitValidatorTests.createTestShardLimitService;
                        + "        }\n"
    }
        });
        assertThat(
                null,
                globalIndexTemplate,
        assertWarnings(
                        IndexMetadata.builder(".ds-logs-mysql-000001")
            e.getMessage(),  
        List<Throwable> errors = putTemplateDetail(request);
            e.getMessage(),
            null  
                    }
        ComposableIndexTemplate it2 = new ComposableIndexTemplate(
                waitToCreateComponentTemplate.countDown();
            false,
            "Invalid exception message." + ex.getMessage(),  
                        + "      }\n"
            1L,
 */
            Settings.builder().build(),  
    }  
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final ClusterState state = client().admin().cluster().prepareState().get().getState();  
        );  
        NamedXContentRegistry xContentRegistry,  
                    .put(
                () -> metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo2", newTemplate)
            "api",  
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
                        + "    }"  
                            + "      }\n"
                    Collections.singletonMap("properties", Collections.singletonMap("field3", Collections.singletonMap("type", "integer")))  
                1L,
                    "testing",  
                        + "          \"type\": \"keyword\"\n"
                .map(IndexTemplateMetadata::name)
/*  
                Collections.singletonMap(
     */  
        };  
    }
            List.of("*"),
            2L,  
            @Override
            ComposableIndexTemplate newTemplate = new ComposableIndexTemplate(
                latch.countDown();
        latch.await();
                            Collections.singletonList(new Index(".ds-foo-000001", "uuid2"))
                    null
                    "{\n"
            Map<String, Object> secondMapping = Map.of(
    public void testResolveAliases() throws Exception {
            null,  
                randomBoolean(),  
    public void testFindV2InvalidGlobalTemplate() {  
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", null)
                .stream()
                try {
                ),  
        assertNull(updatedState.metadata().templatesV2().get("low-priority-template"));
                        + "    }"  
        assertNotNull(state.metadata().templates().get("v1-template"));
     * Test that if we have a pre-existing v1 and v2 template, and we update the existing v1  
            )
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
            null,  
            Arrays.asList("i*"),
                            Collections.singletonList(new Index(".ds-logs-mysql-000001", "uuid"))
                ),  
        MetadataIndexTemplateService service = new MetadataIndexTemplateService(
        // Add a data stream
    }
        MetadataIndexTemplateService service = getMetadataIndexTemplateService();  
                "template-referencing-context-as-ct",
            null,  
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
        state = service.addIndexTemplateV2(state, true, "high-priority-template", highPriorityTemplate);  
            null
            null
                                + "are issued"
            null
        assertNotNull(e.getCause());  
        assertThat(
            containsString("can't merge a non object mapping [field2] with an object mapping")  
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "sneaky1", true)
                .collect(Collectors.toList()),
        ComposableIndexTemplate it = new ComposableIndexTemplate(
            .metadata(
                    null
            null
            null,  
            );
            .build();
        Map<String, AliasMetadata> a4 = Map.of("sys", AliasMetadata.builder("sys").build());  
        );
        request.patterns(singletonList("test_shards_wait*"));
                globalIndexTemplate,  
        state = service.addIndexTemplateV2(state, true, "my-template", it);
                        + "            }\n"
            service.addIndexTemplateV2(stateWithDS, false, "logs", newTemplate);
                Collections.singletonList("logs-postgres-*"),  
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("ct-best-compression-codec" + System.nanoTime(), 1);
        ClusterState state = ClusterState.EMPTY_STATE;  
                )
                } catch (IOException e) {
                ) {
                    ComposableIndexTemplateMetadata.TYPE,  
            null,  
                new CompressedXContent(
            null,  
    }
                ),
                        + "          \"type\": \"date_nanos\"\n"
            ),  
        Set<String> lowPriorityDataStreams = MetadataIndexTemplateService.dataStreamsUsingTemplate(state, "low-priority-template");
                .endObject()  
                List.of("ct"),
            indicesServices,
            xContentRegistry,
            new ActionListener<AcknowledgedResponse>() {
     * Test that if we have a pre-existing v1 and v2 template, and we update the existing v1
                null,
                    .put(
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", randomBoolean())  
        } catch (IllegalStateException e) {
            containsInAnyOrder("foo-2", "foo-1")
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();
                            new NamedXContentRegistry(Collections.emptyList()),
    }  
                .field("analyzer", "custom_1")
}
        request.mappings(
                + "take precedence during new index creation"
                TimeValue.timeValueSeconds(30L),  
            null,
                        + "        \"type\": \"integer\"\n"  
                new CompressedXContent(  
                systemTemplate,
        // Change the pattern to one that doesn't match the data stream  
        putTemplateDetail(new PutRequest("test", "foo-2").patterns(singletonList("foo-*")).order(2));
        ComponentTemplate systemTemplate = new ComponentTemplate(  
                    return null;  
                ),
            } catch (Exception e) {
        );  
            () -> metadataIndexTemplateService.putIndexTemplateV2(
                systemTemplateMetadata.fullyQualifiedName(),
        assertThat(errors.size(), is(1));
                )
        // Patterns with multi-wildcards where literal segments after the first wildcard distinguish them  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                        .createParser(  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))  
        service.putTemplate(request, new MetadataIndexTemplateService.PutListener() {  
        state = service.addComponentTemplate(state, true, "ct_high", ct1);
            InvalidIndexTemplateException.class,  
        ClusterState state = ClusterState.EMPTY_STATE;
        CountDownLatch ctLatch = new CountDownLatch(1);  
            e.getMessage(),  
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(1);  
        ComposableIndexTemplate firstGlobalIndexTemplate = new ComposableIndexTemplate(
                .toString()
                } catch (Exception e) {  
                Collections.singletonList("logs-*-*"),
            .put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "3");
            null  
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(  
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);
        assertTrue(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("app-*"), Arrays.asList("app-*")));  
        );
            XContentFactory.jsonBuilder()
            2L,
                Arrays.asList("abc", "baz*"),  
        );
                List.of("logs*"),
                    fail("failed to parse mappings: " + m.string());
                        + "      \"properties\": {\n"
        ComponentTemplate updatedComponentTemplate = new ComponentTemplate(templateWithIndexHiddenSetting, 2L, new HashMap<>());
        );
        );  
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IllegalArgumentException.class,
        state = service.addIndexTemplateV2(state, true, "my-template2", it2);
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
    public void testPutGlobalV2TemplateWhichProvidesContextWithSpecificVersion() throws Exception {
                    @Override
            50L,  
    public void testRemoveIndexTemplateV2ForDataStream() throws Exception {
                0L,
import org.opensearch.index.compositeindex.CompositeIndexSettings;
            equalTo(  
        ComponentTemplate ct = ComponentTemplateTests.randomInstance();
            Collections.singletonList("*"),  
        };
                        + "    \"properties\": {\n"
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();  
                                    .build()  
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
            }
                null
            ComposableIndexTemplate newTemplate = new ComposableIndexTemplate(
            Collections.singletonList("a"),  
     */
        assertThat(  
        assertNull(updatedState.metadata().templatesV2().get("foo"));
    public void testAddIndexTemplateV2() throws Exception {
    private static List<Throwable> putTemplate(NamedXContentRegistry xContentRegistry, PutRequest request) {
            Settings.EMPTY,  
                () -> metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo2", newTemplate)
    }  
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo2", componentTemplate4)
            1L,  
                e.getMessage(),
        );
            100L,
        PutRequest request = new PutRequest("test", "test_shards");
            () -> metadataIndexTemplateService.putIndexTemplateV2(
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
            null,
            new Template(
        assertWarnings(
        );  
    private MetadataIndexTemplateService getMetadataIndexTemplateService() {
            null
    /**  
     * Test that if we have a pre-existing v2 template and put a "*" v1 template, we generate a warning  
                        IndexMetadata.builder(".ds-logs-mysql-default-000001")
import org.opensearch.cluster.ClusterState;
                        + "        \"field2\": {\n"
            null,  
    }
        assertNotNull(state.metadata().templatesV2().get("v2-template"));
                    return null;
            2L,
    public void testPatternsActuallyOverlap() {
            Collections.singletonList("ct"),
            templateApplier.apply(CodecService.LZ4),
            assertThat(e.getMessage(), containsStringIgnoringCase("globalindextemplate1"));
    public void testIndexTemplateWithValidateMapping() throws Exception {
            new PutRequest("testPutGlobalTemplateWithIndexHiddenSetting", "sneaky-hidden").patterns(singletonList("*"))
            pr.mappings("{}");
        ComponentTemplate systemTemplate = new ComponentTemplate(
            )
        ComposableIndexTemplate newTemplate = randomValueOtherThanMany(
            componentTemplates,  
    public void testLegacyNoopUpdate() {
                .collect(Collectors.toList()),
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            new Template(  
            );
        // not hidden
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();  
 * Unless required by applicable law or agreed to in writing,
                        + "        }\n"  
            null,
                .map(IndexTemplateMetadata::name)  
                        IndexMetadata.builder(".ds-foo-000001")  
        );  
                        new DataStream(
        ClusterState updatedState = MetadataIndexTemplateService.innerRemoveIndexTemplateV2(state, "low-priority-template");  
            meta,  
        state = service.addComponentTemplate(state, true, "ct_high", ct1);
                template,
            null,
            Collections.singletonList("logs-*-*"),
import static org.opensearch.common.settings.Settings.builder;  
        expectThrows(
                equalTo(  
            randomBoolean(),  
        );  
            null,
            );  
        Settings settings = MetadataIndexTemplateService.resolveSettings(state.metadata(), "my-template");  
     * template without changing its index patterns, a warning is generated
        Settings settings = Settings.builder()  
            }).collect(Collectors.toList());  
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);
                "_doc",  
        ComponentTemplate sysTemplate = new ComponentTemplate(
        assertTrue(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("egg*", "baz"), Arrays.asList("abc", "baz*")));
            );
            if (actualTemplate.mappings() != null) {
                        public void onResponse(AcknowledgedResponse response) {
        putTemplateDetail(new PutRequest("testFindTemplatesWithHiddenIndices", "foo-1").patterns(singletonList("foo-*")).order(1));
            Collections.singletonList("logs-mysql-*"),  
            assertThat(parsedMappings.get(0), equalTo(firstMapping));  
                    public void onResponse(AcknowledgedResponse response) {
                        + "    }"
            Arrays.asList("foo-bar-*", "eggplant"),
            new CompressedXContent("{\"invalid\":\"invalid\"}"),  
        );
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            globalIndexTemplate,  
            state = service.addIndexTemplateV2(state, true, "logs-template", it);  
                        + "      }\n"
                    )
        assertThat(throwables.get(0), instanceOf(InvalidIndexTemplateException.class));
        // Patterns where one is a superset of the other (logs-* matches any logs-prod-* index name)
                    fail("the listener should not be invoked as the template should succeed");  
                        @Override
import org.opensearch.core.xcontent.MediaTypeRegistry;
            1L,
import java.util.ArrayList;
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;
                .collect(Collectors.toList()),
            );  
        Settings clusterSettings = Settings.builder()  
                null
        assertNotNull(state.metadata().templatesV2().get("bar"));
                true,  
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            })
                null
                systemTemplateMetadata.fullyQualifiedName(),
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");  
                    + "configuration would cause data streams [unreferenced, logs-mysql-default] to no longer match a data stream template"
                            + "        \"type\": \"integer\"\n"  
    public void testDefinedTimestampMappingIsAddedForDataStreamTemplates() throws Exception {  
        assertThat(MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", true), empty());
            containsInAnyOrder("bar", "global")  
        Settings.Builder settingsBuilder = builder().put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), "true")
        );  
            assertThat(  
            List.of(systemTemplateMetadata.fullyQualifiedName()),  
        };  
        template = new Template(
                    globalIndexTemplate,
                            fail("the listener should not be invoked as validation should fail");
                        + "        \"field1\": {\n"
            "{\"properties\":{\"" + randomAlphaOfLength(5) + "\":{\"type\":\"keyword\"}}}"  
            () -> service.addIndexTemplateV2(finalState, randomBoolean(), "my-template", it)  
            null  
                    "_doc",
            @Override
    private List<Throwable> putTemplateDetail(PutRequest request) throws Exception {
        Function<String, Template> templateApplier = codec -> new Template(
            ),
        assertNotNull(e.getCause());
        Settings incomingNodeScopedSettings
        ComponentTemplate ct1 = new ComponentTemplate(
    public void testPuttingV1NonStarTemplateGeneratesWarning() throws Exception {
                () -> metadataIndexTemplateService.putIndexTemplateV2(
        assertThat(errors.get(0), instanceOf(IllegalArgumentException.class));  
    public void testIndexTemplateValidationWithSpecifiedReplicas() throws Exception {
        assertThat(
        assertNotNull(state.metadata().templatesV2().get("app-test-some-other"));  
 * this work for additional information regarding copyright
                }
            IllegalArgumentException.class,  
                true,  
            t -> Objects.equals(template.priority(), t.priority()),
            equalTo(  
            latch.await(5, TimeUnit.SECONDS);  
            state = service.addIndexTemplateV2(state, true, "logs-data-stream-template", it);
        ComponentTemplate ct1 = new ComponentTemplate(new Template(null, null, a1), null, null);
        });  
import org.opensearch.common.unit.TimeValue;  
        List<Throwable> throwables = putTemplateDetail(request);
                        + "      \"properties\": {\n"
            ex.getMessage().contains("specifies a component templates which can only be used in context")
                        + "          \"type\": \"keyword\"\n"
        });
                        + "      }\n"  
 * SPDX-License-Identifier: Apache-2.0
        ComponentTemplate ct1 = new ComponentTemplate(
                        "{\n"
        );
                + "this template [v1-template] may be ignored in favor of a composable template at index creation time"  
                new Template(  
                        + "          \"type\": \"text\"\n"
                new CompressedXContent(
            containsString("component templates [ct] cannot be removed as they are still in use by index templates [template]")  
        request.mappings("{}");
            CountDownLatch errLatch = new CountDownLatch(1);
        ComponentTemplate ct = new ComponentTemplate(new Template(Settings.EMPTY, null, null), null, null);  
import static org.opensearch.index.mapper.DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD;
            containsString(
            }
                + "from existing older templates [v1-template] with patterns (v1-template => [fo*, baz]); this template [v2-template] will "
        assertThat(e.getCause().getMessage(), containsString("invalid composite mappings for [my-template]"));
        );  
                        fail("the listener should not be invoked as validation should fail");  
                "template-referencing-context-as-ct",
                "testing",
        Settings clusterSettings = Settings.builder()
        final ClusterState finalState = state;
        assertTemplatesEqual(state.metadata().templatesV2().get("v2-template"), v2Template);  
        );  
import java.util.concurrent.CountDownLatch;
            template.version(),  
import java.util.Objects;  
        Set<String> highPriorityDataStreams = MetadataIndexTemplateService.dataStreamsUsingTemplate(state, "high-priority-template");  
            1L,  
        String componentTemplateName = "ct-default-codec" + System.nanoTime();
                throw err.get();  
                )
        ThreadContext threadContext = getInstanceFromNode(ThreadPool.class).getThreadContext();
        assertWarnings(
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            fail("expecting an exception as the matching global template is invalid");  
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)
import static org.hamcrest.CoreMatchers.instanceOf;  
        String indexTemplateName = "template-referencing-ct-and-context";
            public void onFailure(Exception e) {
            templateApplier.apply(CodecService.ZLIB),
                null,  
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),
        assertNotNull(state.metadata().templatesV2().get("foo"));
        );
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
                createComponentTemplateListener
        ComposableIndexTemplate t1 = new ComposableIndexTemplate(Arrays.asList("app-test-*-some-*"), null, null, 0L, null, null, null);
                try (
                null,
                .endObject()
            try {
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)  
            Arrays.asList("ct_low", "ct_high"),  
                            .settings(  
        ComponentTemplate ct1 = new ComponentTemplate(
        List<String> componentTemplates = randomList(0, 10, () -> randomAlphaOfLength(5));
        request.settings(settingsBuilder.build());
        IllegalArgumentException e = expectThrows(
                )
                        + "    }"
                    "{\n"
                )
        assertTrue(
            createIndexService,  
                                    .build()  
        assertTemplatesEqual(state.metadata().templatesV2().get("v2-template"), v2Template);  
                "_doc",
            ct,  
            null  
        ClusterState state = ClusterState.EMPTY_STATE;  
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(  
            null,
        ComponentTemplate componentTemplate4 = new ComponentTemplate(template, 1L, new HashMap<>());
                        + "    }\n"
        );
        );
            () -> MetadataIndexTemplateService.innerRemoveIndexTemplateV2(ClusterState.EMPTY_STATE, "foo")  
            null,
        state = service.addComponentTemplate(state, true, "c2", ct2);  
                null
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));  
        List<Throwable> errors = putTemplateDetail(request);
                1L,
        }  
            0L,
import org.opensearch.cluster.metadata.MetadataIndexTemplateService.PutRequest;
                )
 * software distributed under the License is distributed on an
package org.opensearch.cluster.metadata;
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                null,
        );  
                    Collections.singletonMap("properties", Collections.singletonMap("field1", Collections.singletonMap("type", "keyword")))  
            new Template(
        }  
                            + "    }\n"
            service.addIndexTemplateV2(stateWithDS, false, "logs2", nonDSTemplate);
            null,
import org.opensearch.common.settings.ClusterSettings;
                                + "are issued"  
            MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                    @Override
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        ClusterState state = ClusterState.EMPTY_STATE;
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");
 * GitHub history for details.
                    .build()  
            0L,
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            1L,  
import org.opensearch.Version;
                    "_doc",
            getInstanceFromNode(ThreadPool.class).getThreadContext().putTransient(ACTION_ORIGIN_TRANSIENT_NAME, TEMPLATE_LOADER_IDENTIFIER);
        state = metadataIndexTemplateService.addComponentTemplate(state, randomBoolean(), "bar", componentTemplate);
        );
import static org.hamcrest.CoreMatchers.not;
            null,
            ct,
                .collect(Collectors.toList()),
            e.getMessage(),
    public void testResolveSettings() throws Exception {  
        assertThat(
                DataStream.getDefaultBackingIndexName("logs", 1L)
                logger.error(e);
                        + "            \"foo\": {\n"
            null,  
    public void testPutGlobalV2TemplateWhichResolvesIndexHiddenSetting() throws Exception {  
                List.of("logs*"),
            );  
                + "take precedence during new index creation"
                .stream()
        );
    }
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 2L)
            false,  
        InvalidIndexTemplateException e = expectThrows(InvalidIndexTemplateException.class, () -> {
            ActionListener.wrap(r -> ctLatch.countDown(), e -> {
                ),  
    }
            ComposableIndexTemplate template = new ComposableIndexTemplate(Arrays.asList("egg*", "baz"), null, null, 1L, null, null, null);  
        );  
            Map<String, Object> secondMapping = Map.of(
                    + "setting"
            ),
        final String indexTemplateName = verifyTemplateCreationUsingContext(Context.LATEST_VERSION);
                    + "configuration would cause data streams [unreferenced, logs-mysql-default] to no longer match a data stream template"
        // Because the first elements when merging mappings have the lowest precedence  
                null,  
                null,
        );
            metadataIndexTemplateService.putComponentTemplate(
        assertThat(  
        );
        // The order of mappings should be:
                "testing",  
            1L,  
                    )
            @Override  
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            null,
        final ClusterState finalState = state;  
            createComponentTemplateListener
                TimeValue.timeValueSeconds(30L),
                Collections.singletonList("logs-my*-*"),
            assertThat(mappings.size(), equalTo(3));  
            .metadata(metadata)  
    public void testPutExistingComposableTemplateIsNoop() throws Exception {  
                TimeValue.timeValueSeconds(30L),
            );
            );
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
            ActionListener.wrap(r -> latch.countDown(), e -> fail("unexpected error"))
                null,  
        // hidden
                        + "        \"field2\": {\n"  
            null,  
        );
                            + "      \"properties\": {\n"
                null,  
        String result = MetadataIndexTemplateService.findV2Template(state.metadata(), "index", randomBoolean());
            expected.priority(),  
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")  
                new Template(
                        + "          \"properties\": {\n"
        );
                }
            actual.composedOf(),
        assertFalse(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("foo-*-bar"), Arrays.asList("foo-*-baz")));  
        ClusterState state = ClusterState.EMPTY_STATE;
                                    .build()
    }
            () -> service.addComponentTemplate(finalState, false, "c2", changedCt2)
            new AliasValidator(),
    }  
        assertEquals(throwables.size(), 1);
            null
    /**
     * when adding/updating a composable index template  
                TimeValue.timeValueSeconds(30),
                "template",
                    logger.error(e);
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),
                            + "        }\n"
        assertThat(throwables.get(0).getMessage(), containsString("index_pattern [_test_shards*] must not start with '_'"));
                        + "        }\n"  
                "_doc",  
                                Settings.builder()
        assertNotNull(state.metadata().templatesV2().get("app-test-some"));
            1L,
            null,  
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo2", componentTemplate3)  
        Template actualTemplate = actual.template();
    }
                fail("unexpected error");  
                createComponentTemplateListener
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            null
            null,
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        ClusterState state = ClusterState.EMPTY_STATE;  
            )  
            1L,  
                new CompressedXContent(
                globalIndexTemplate,  
                        )
                        + "          \"type\": \"text\"\n"
import static java.util.Collections.singletonList;
        {
            public void onFailure(Exception e) {  
        );  
                    "{\n"  
            containsInAnyOrder("bar", "global")  
                            )  
            metadataIndexTemplateService.putComponentTemplate(
            ),  
    private static List<Throwable> putTemplate(
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);  
    }  
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1)
                    @Override
            Arrays.asList("ct_low", "ct_high"),
                    .build()
            List.of("*"),
                "test",  
            null  
        state = service.addIndexTemplateV2(state, true, "low-priority-template", lowPriorityTemplate);
        assertTrue("Could not create component templates", waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS));
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();  
        );  
            null,
            TimeValue.timeValueSeconds(5),
        template = new Template(  
            )
                .stream()
        );  
        assertThat(errors.get(0), instanceOf(MapperParsingException.class));
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)
        assertThat(mappings.size(), equalTo(3));  
            null,
            null,
        Function<String, Template> templateApplier = codec -> new Template(  
    public void testMaxTranslogFlushSizeWithCompositeIndex() {
                    }
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();  
        );  
import static org.hamcrest.Matchers.contains;
            containsString(  
        Template templateWithHiddenSetting = new Template(builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(), null, null);
            @Override  
            Arrays.asList("foo-bar-*", "eggplant"),
            assertThat(
    }
                        + "    }"
                null,  
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(  
                    @Override
                ),
    public void testPuttingOverlappingV2Template() throws Exception {
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            null,
        });
        FeatureFlags.TestUtils.with(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false, () -> {  
                null,
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
                null,  
                null,
        });
            MapperParsingException.class,
        state = service.addIndexTemplateV2(state, true, "my-template", it);
                .map(IndexTemplateMetadata::name)  
        List<Throwable> throwables = putTemplateDetail(request);
            assertThat(parsedMappings.get(0), equalTo(firstMapping));
        service.putComponentTemplate(
            clusterService,
                .map(IndexTemplateMetadata::name)
        Settings settings = MetadataIndexTemplateService.resolveSettings(clusterService.state().metadata(), indexTemplateName);
            assertThat(mappings.size(), equalTo(4));
        ComponentTemplate ct2 = new ComponentTemplate(new Template(null, null, a2), null, null);
                    null,
        assertThat(throwables, is(empty()));
                systemTemplateV2Metadata.fullyQualifiedName(),
     * Tests that we check that settings/mappings/etc are valid even after template composition,
public class MetadataIndexTemplateServiceTests extends OpenSearchSingleNodeTestCase {
                new ComposableIndexTemplate.DataStreamTemplate()  
                    null
                    }
                Metadata.builder(state.metadata())
            ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "foo", template);
 *     http://www.apache.org/licenses/LICENSE-2.0
                public void onResponse(AcknowledgedResponse response) {  
        ComponentTemplate ct2 = new ComponentTemplate(  
            )
        ClusterState stateWithDS = ClusterState.builder(state)
                true,  
                    @Override  
                    ),
            null,
        ComponentTemplate ct = ComponentTemplateTests.randomInstance();
                            + "          \"type\": \"date_nanos\"\n"  
                new Template(  
                null
        );  
            contains("sneaky-hidden")
        ComponentTemplate componentTemplate = new ComponentTemplate(template, 1L, new HashMap<>());
                .collect(Collectors.toList()),
                logger.error(e);
            "legacy template [v1-template] has index patterns [fo*, baz] matching patterns from existing "  
            "Setting [index.routing.allocation.total_primary_shards_per_node] or [index.routing.allocation.total_remote_capable_primary_shards_per_node] can only be used with remote store enabled clusters",
            componentTemplate,
            Settings.builder().put("invalid", "invalid").build(),
        }
            );  
    }
            "expected both templates to have either a template or no template",
                    }  
        Template expectedTemplate = expected.template();
        request.patterns(singletonList("te*"));  
                        + "        \"field2\": {\n"  
                equalTo(
                logger.error("unexpected error", e);
                            "unreferenced",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            )  
        List<Throwable> throwables = putTemplate(xContentRegistry(), request);  
                    "{\n"
            );
        PutRequest request = new PutRequest("api", "validate_template");
                }  
            )  
                        fail(
                .field("type", "text")  
            AtomicReference<Exception> err = new AtomicReference<>();  
        InvalidIndexTemplateException ex = expectThrows(
                null,
        );
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString());  
            Arrays.asList("ct_low", "ct_high"),
        );  
            0L,
                null,
            new Template(Settings.builder().put("index.number_of_replicas", 1).put("index.blocks.read", true).build(), null, null),
        request.settings(builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "0").put("index.shard.check_on_startup", "blargh").build());
            }
            Arrays.asList("foo-bar-*", "eggplant"),
            new Template(null, null, null),  
                    )
        assertThat(errors.size(), equalTo(1));
        ComponentTemplate componentTemplate = new ComponentTemplate(templateWithIndexHiddenSetting, 1L, new HashMap<>());
            contains("global")
                + "from existing older templates [v1-template] with patterns (v1-template => [fo*, baz]); this template [v2-template] will "
            1L,  
                        + "      }\n"
        request.patterns(singletonList("te*"));
                new CompressedXContent(
        );  
                "Invalid exception message." + ex.getMessage(),
                ),
            null,
            null,
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(state, "timeseries-template", "timeseries");
                        + "      \"properties\": {\n"
        );  
        MetadataIndexTemplateService.innerPutTemplate(finalState, req, IndexTemplateMetadata.builder("v1-template"));
            ),  
        assertNotNull(state.metadata().templates().get("v1-template"));
 * Licensed to Elasticsearch under one or more contributor  
            null,
            ComposableIndexTemplate it = new ComposableIndexTemplate(  
                    Collections.singletonMap("properties", Collections.singletonMap("field2", Collections.singletonMap("type", "text")))  
        );
                null,
            assertThat(parsedMappings.get(0), equalTo(firstParsedMapping));
            ),
                null,
                }  
        ComposableIndexTemplate it2 = new ComposableIndexTemplate(
            Exception.class,  
                    throw new AssertionError(e);
        return throwables;
            new ComposableIndexTemplate.DataStreamTemplate()
                )
    }  
                        fail("the listener should not be invoked as validation should fail");
            null,  
            .build();  
                assertThat(actualMappings, equalTo(expectedMappings));
                null,
    }  
        // Explicitly disable the FF
        state = metadataIndexTemplateService.addIndexTemplateV2(state, true, "globalindextemplate1", firstGlobalIndexTemplate);
                ),
        ClusterState state = ClusterState.EMPTY_STATE;  
        final String indexTemplateName = verifyTemplateCreationUsingContext("1");
            )
        ctLatch.await(5, TimeUnit.SECONDS);  
                .map(IndexTemplateMetadata::name)  
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("context-best-compression-codec" + System.nanoTime(), 1);
            "ct",
        );
                        + "              \"type\": \"integer\"\n"
                systemTemplate,
            "api",
                        fail(  
                null,  
            state = service.addComponentTemplate(state, true, "ct1", ct1);
                null,  
            null,
                1L,
            null
            randomBoolean() ? null : randomNonNegativeLong(),
            null,  
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint");
import static org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader.TEMPLATE_LOADER_IDENTIFIER;  
        template = new ComposableIndexTemplate(
                IllegalArgumentException.class,
                .stream()
            ex.getMessage().contains("specifies a context which is not loaded on the cluster")
import org.opensearch.common.settings.SettingsException;
        state = service.addComponentTemplate(state, true, "ct_low", ct2);  
        service.putComponentTemplate(
        Function<String, Template> templateApplier = codec -> new Template(
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
        );  
        );
            expected.metadata(),
                        + "    }"
                null,  
            Collections.singletonList("i*"),
                new CompressedXContent(
                    "{\n"  
                List.of("*"),
            null,
                null,
                105L,
            ComposableIndexTemplate invalidGlobalTemplate = new ComposableIndexTemplate(
                        new DataStream(  
            new Template(  
        List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
                null,  
    public void testFindV2Templates() throws Exception {  
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
            ComponentTemplateTests.randomAliases()
 * compatible open source license.
                    logger.error(e);
                null  
                TimeValue.timeValueSeconds(30L),  
            null,
        CountDownLatch ctLatch = new CountDownLatch(1);
            null,
        ThreadContext threadContext = getInstanceFromNode(ThreadPool.class).getThreadContext();
                    "index template [foo2] has index patterns [abc, baz*] matching patterns from existing "  
            null  
            null,
            fail(
import java.util.function.Function;
        PutRequest request = new PutRequest("test", "putTemplate shards");
            IndexTemplateMissingException.class,
                systemTemplateV2,
        );
        );  
        );
            new Template(
                        + "      }\n"
import org.opensearch.core.index.Index;  
        );  
            null,  
                .stream()
        state = service.addComponentTemplate(state, true, "ct_low", ct2);  
            );  
                null,
            IllegalArgumentException.class,
        assertTrue("Could not create component templates", waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS));  
            null,  
        // These should be order of precedence, so the context(a4), index template (a3), then ct_high (a1), then ct_low (a2)
            null  
            }
        assertThat(settings.get("index.codec"), equalTo(CodecService.BEST_COMPRESSION_CODEC));
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            );  
                    ),
                InvalidIndexTemplateException.class,
            ),
            null,
                new CompressedXContent(  
                    "{\n"  
        );
            );
                    .put(
                            LoggingDeprecationHandler.INSTANCE,
        );
                    err.set(exception);
            null,
                systemTemplateMetadata.fullyQualifiedName(),
        request.settings(settingsBuilder.build());  
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();  
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
    ) {  
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)  
        assertWarnings(
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                    "{\n"
                IllegalArgumentException.class,  
                Collections.singletonMap(
            Map<String, Object> firstMapping = Map.of(
                throwables.add(e);
        ComposableIndexTemplate lowPriorityTemplate = new ComposableIndexTemplate(  
        ClusterState stateWithDSAndTemplate = service.addIndexTemplateV2(stateWithDS, false, "logs-mysql", mysqlTemplate);
        );
            IllegalArgumentException.class,
                + "from existing older templates [v1-template] with patterns (v1-template => [fo*, baz]); this template [v2-template] will "
        ComponentTemplate changedCt2 = new ComponentTemplate(
                .stream()
        );
                null,
        );  
            globalIndexTemplate
            ),
            CountDownLatch latch = new CountDownLatch(1);
        assertWarnings(
        assertThat(throwables.get(0), instanceOf(InvalidIndexTemplateException.class));
                .stream()
        List<Throwable> errors = putTemplateDetail(request);
            0L,  
            Map<String, Object> firstParsedMapping = Map.of(  
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;  
        PutRequest request = new PutRequest("test", "test_default_replicas");  
            "ct-with-index-hidden-setting",
        assertEquals(throwables.size(), 1);
                systemTemplate,  
                        + "        }\n"
                    @Override
        );
            null
        }  
                public void onFailure(Exception e) {
                new Context("any")
        // - ct_high
        // Create two templates with different priorities that match the same data stream
            null,  
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("ct-best-compression-codec" + System.nanoTime(), 1);
        if (randomBoolean()) {  
 *
                    logger.error(e);  
            10L,  
            null,
                    logger.error(e);  
        );
        }
        );
    @Override
import java.util.Arrays;  
                            + "        \"type\": \"integer\"\n"
                .map(IndexTemplateMetadata::name)  
                )
            "Invalid exception message." + ex.getMessage(),  
        assertThat(
import static org.hamcrest.Matchers.containsInAnyOrder;  
            null  
                .collect(Collectors.toList()),
            Arrays.asList("good", "bad"),
        ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "v2-template", v2Template);
    }  
        a3.put("eggplant", AliasMetadata.newAliasMetadataBuilder("eggplant").build());
                            "foo",  
    }
        );
                        + "      \"properties\": {\n"
            "Invalid exception message." + ex.getMessage(),
            @Override
                Arrays.asList("app-test-*-some-*"),  
            0L,
            }
                            actualTemplate.mappings().string()  
            null
            indexTemplateName,
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            parsedMappings.get(0),
            )
        assertThat(MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", randomBoolean()), empty());  
            null,
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
        );  
                .collect(Collectors.toList()),
                    "{\n"
        final ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "foo", template);
                                    .build()
            }).collect(Collectors.toList());
    }
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date")))
        assertNotNull(state.metadata().componentTemplates().get("foo"));
                            + "    }\n"
                List.of("ct1"),
            null
    }
            equalTo(  
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());
            ),
            null,
                state,
            patterns,
                            + "      }\n"
            10L,  
import static org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata.fromComponentTemplateInfo;
                        + "templates [foo] with patterns (foo => [egg*, baz]) that have the same priority [1], multiple index templates may not "
                        + "        \"field2\": {\n"  
import static org.mockito.Mockito.mock;
                .collect(Collectors.toList()),
                "testing",
        assertNotNull(state.metadata().templatesV2().get("v2-template"));
        assertThat(  
            new Template(Settings.builder().put("index.blocks.write", false).put("index.number_of_shards", 3).build(), null, null),  
        assertThat(errors.get(0).getMessage(), containsString("global templates may not specify the setting index.hidden"));  
        // Test remove the low priority template
    }
                        + "            \"foo\": {\n"  
                .stream()  
            null,
                null
        ComposableIndexTemplate templateToRemove = new ComposableIndexTemplate(  
            InvalidIndexTemplateException ex = expectThrows(  
                .settings(Settings.builder().put("index.hidden", true).build())  
        pr.patterns(Arrays.asList("foo", "bar"));
        ClusterService clusterService = node().injector().getInstance(ClusterService.class);
                }
                new CompressedXContent(  
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
            new CompressedXContent("{\"invalid\"}"),
            ComposableIndexTemplate it = new ComposableIndexTemplate(
import org.opensearch.indices.DefaultRemoteStoreSettings;  
            parsedMappings = mappings.stream().map(m -> {
            public void onResponse(AcknowledgedResponse response) {
        }
            assertThat(actualTemplate.settings(), equalTo(expectedTemplate.settings()));
            equalTo(  
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),  
        putTemplateDetail(
                "c*",  
    public void testIndexTemplateInvalidNumberOfShards() {  
                .collect(Collectors.toList()),  
            null,
        assertNotNull(e.getCause().getCause());  
        ClusterState state = ClusterState.EMPTY_STATE;  
        assertThat(highPriorityDataStreams, contains("logs-mysql"));  
                null  
        );
        state = service.addComponentTemplate(state, true, "c1", ct1);
                .map(IndexTemplateMetadata::name)
        ClusterState state = ClusterState.EMPTY_STATE;  
        }
            true,
                }
        putTemplateDetail(new PutRequest("test", "bar").patterns(singletonList("bar-*")).order(between(0, 100)));
                            + "    }"  
        state = service.addComponentTemplate(state, true, systemTemplateMetadata.fullyQualifiedName(), sysTemplate);
                )
            () -> metadataIndexTemplateService.addIndexTemplateV2(throwState, true, "foo", newTemplate)  
        state = service.addIndexTemplateV2(state, true, "my-template2", it2);
        // Completely disjoint literal prefixes do not overlap
                )
                null,  
                        + "        }\n"  
                        }
            pr.settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build());
                List.of(),
        );
        // - ct_low  
            2L,
            @Override
                    fail("failed to parse mappings: " + m.string());  
            );  
            assertThat(mappings.size(), equalTo(3));  
                }  
    }
        );
            Collections.singletonList("ct"),
            null
        );
        );  
        ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "v2-template", v2Template);
            containsString("can't merge a non object mapping [field2] with an object mapping")
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", true)
        IllegalArgumentException e = expectThrows(  
                Metadata.builder(state.metadata())
                "updating component template [c2] results in invalid " + "composable template [my-template] after templates are merged"
        request.mappings("abcde");
                null
    public void testAddInvalidTemplate() throws Exception {  
                ex.getMessage().contains("specifies a context which cannot be used without enabling")
        InvalidIndexTemplateException ex = expectThrows(  
import org.opensearch.common.xcontent.XContentFactory;
            null  
        );  
            "test",  
            AtomicReference<Exception> err = new AtomicReference<>();  
        assertThat(settings.get("index.blocks.read"), equalTo("true"));  
    public void testPuttingV1StarTemplateGeneratesWarning() throws Exception {
import static org.opensearch.common.util.FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES;
        ComposableIndexTemplate it = new ComposableIndexTemplate(  
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {  
            ComposableIndexTemplate nonDSTemplate = new ComposableIndexTemplate(
                null
        }
                ),
            true,
            createComponentTemplateListener
        state = ClusterState.builder(state)  
            null  
        assertThat(mappings.size(), equalTo(3));  
                .stream()  
            List.of("*"),
            null,
            randomBoolean() ? null : randomNonNegativeLong(),
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)
        }  
        assertThat(errors.get(0), instanceOf(IllegalArgumentException.class));  
            contains("foo-2", "foo-1")  
        );
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));  
                "api",
