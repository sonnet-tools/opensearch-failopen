            )
                null,
            assertThat(parsedMappings.get(2), equalTo(thirdMapping));
                .collect(Collectors.toList()),
            assertThat(parsedMappings.get(0), equalTo(firstMapping));
        a3.put("baz", AliasMetadata.newAliasMetadataBuilder("baz").build());
        {
            null,
                100L,
        when(clusterService.state()).thenReturn(clusterState);
            null,
        req.patterns(Arrays.asList("egg*", "baz"));
                null,
 * You may obtain a copy of the License at
                            + "      }\n"
                        + "      }\n"
            Arrays.asList("ct_low", "ct_high"),
                    .build()
        List<Throwable> throwables = putTemplateDetail(request);
            contains("sneaky-hidden")
            indicesServices,
            public void onFailure(Exception e) {
import static org.hamcrest.CoreMatchers.not;
                        + "      }\n"
 * under the License.
                1L,
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());
        assertThat(
        metadataIndexTemplateService.putIndexTemplateV2(
            )
        Set<String> lowPriorityDataStreams = MetadataIndexTemplateService.dataStreamsUsingTemplate(state, "low-priority-template");
            new Template(
        Settings settings = MetadataIndexTemplateService.resolveSettings(clusterService.state().metadata(), indexTemplateName);
                .map(IndexTemplateMetadata::name)
        state = service.addComponentTemplate(state, true, "ct_low", ct2);
            componentTemplate,
        ComponentTemplate ct = ComponentTemplateTests.randomInstance();
    }
                            + "      \"field2\": {\n"
                1L,
        ComposableIndexTemplate nonDSTemplate = new ComposableIndexTemplate(
        );
                .stream()
            );
            parsedMappings.get(2),
            Collections.singletonList("a"),
    }
    public void testResolveSettings() throws Exception {
    public void testUpdateIndexTemplateV2() throws Exception {
import org.opensearch.core.index.Index;
                new ActionListener<AcknowledgedResponse>() {
            Collections.singletonList("in*"),
        state = metadataIndexTemplateService.addIndexTemplateV2(state, true, "foopatternindextemplate", fooPatternIndexTemplate);
                            .settings(
    }
            null
            1L,
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
                        new DataStream(
            } catch (Exception e) {
            null,
        assertThat(errors.size(), is(1));
                () -> metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo2", newTemplate)
            @Override
                        + "          \"properties\": {\n"
    }
                )
        state = ClusterState.builder(state)
                    .put(
        a3.put("eggplant", AliasMetadata.newAliasMetadataBuilder("eggplant").build());
            templateApplier.apply(CodecService.ZLIB),
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", randomBoolean())
            1L,
                        + "      \"properties\": {\n"
        req.patterns(Arrays.asList("*", "baz"));
        Template expectedTemplate = expected.template();
        assertThat(state.metadata().templates().get("v1-template").patterns(), containsInAnyOrder("fo*", "baz"));
            Collections.singletonList("ct"),
            null,
                state,
            null
                    "{\n"
        request.mappings("{}");
                TimeValue.timeValueSeconds(30L),
        ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "v2-template", v2Template);
            null
            null
        service.putComponentTemplate(
        ComposableIndexTemplate it = new ComposableIndexTemplate(
                    throw new AssertionError(e);
                                Settings.builder()
                        + "    \"properties\": {\n"
                }
            null,
        }
            new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS),
        assertThat(throwables.get(0), instanceOf(InvalidIndexTemplateException.class));
        ComposableIndexTemplate template = new ComposableIndexTemplate(
            null,
        List<String> patterns = new ArrayList<>(template.indexPatterns());
            "template",
            containsInAnyOrder("foo-2", "foo-1")
            List.of("foo"),
            ),
                    public void onResponse(AcknowledgedResponse response) {
                new CompressedXContent(
 *
        }
        // Add an additional template that matches our data stream at a lower priority
            null,
            @Override
        final ClusterState clusterState = metadataIndexTemplateService.addIndexTemplateV2(stateWithDS, false, "foo", templateToRemove);
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(
                        + "      \"properties\": {\n"
        } catch (IllegalStateException e) {
            "legacy template [v1-template] has index patterns [egg*, baz] matching patterns "
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                    "{\n"
                        fail("the listener should not be invoked as validation should fail");
import org.opensearch.repositories.RepositoriesService;
                "logs-data-stream-template",
            assertThat(mappings.size(), equalTo(3));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                DataStream.getDefaultBackingIndexName("timeseries-template", 1L)
        ClusterState stateWithDS = ClusterState.builder(state)
                    Collections.singletonMap("properties", Collections.singletonMap("field3", Collections.singletonMap("type", "integer")))
                "expected both templates to have either mappings or no mappings",
        );
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo2", componentTemplate2)
                        .createParser(
import org.opensearch.Version;
    public void testModifySystemTemplateViaUnknownSource() throws Exception {
            TimeValue.timeValueSeconds(30L),
                        + "          \"properties\": {\n"
            null,
        assertWarnings(
            true,
    }
                .collect(Collectors.toList()),
            contains("global")
        assertThat(resolvedAliases, equalTo(Arrays.asList(a4, a3, a1, a2)));
        return indexTemplateName;
            "Invalid exception message." + ex.getMessage(),
                        )
        // invalid json: put index template fails
            );
                null,
 * this work for additional information regarding copyright
            Arrays.asList("i*"),
                + "composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]); this template [v1-template] may "
                new ComposableIndexTemplate.DataStreamTemplate()
                    public void onFailure(Exception e) {
                    ComposableIndexTemplateMetadata.TYPE,
                globalIndexTemplate,
        String indexTemplateName = "template-referencing-ct-and-context";
        // Now try to update the existing v1-template
        CountDownLatch latch = new CountDownLatch(1);
            firstMapping = Map.of("_doc", Map.of("properties", Map.of("field1", Map.of("type", "keyword"))));
                List.of("ct"),
            1L,
        assertThat(
            assertThat(parsedMappings.get(0), equalTo(firstParsedMapping));
    }
        assertNotNull(state.metadata().templatesV2().get("foo"));
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
            parsedMappings.get(0),
            equalTo(Objects.nonNull(expectedTemplate))
            null
    }
            Collections.singletonList("logs-postgres-*"),
            ),
    }
        assertTrue("Could not create component templates", waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS));
    public void testFindV2Templates() throws Exception {
        // Explicitly disable the FF
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;
            new ComposableIndexTemplate.DataStreamTemplate()
                        + "      }\n"
            null,
                                Settings.builder()
            List.of("*"),
     * when adding/updating a composable index template
            actual.metadata(),
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        );
        state = service.addIndexTemplateV2(state, true, "my-template2", it2);
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1)
        assertThat(
        IllegalArgumentException ex = expectThrows(
            2L,
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
            AtomicReference<Exception> err = new AtomicReference<>();
import static org.hamcrest.Matchers.contains;
                .map(IndexTemplateMetadata::name)
            Collections.singletonList("i*"),
    public void testFindTemplatesWithHiddenIndices() throws Exception {
        return Settings.builder().put(super.featureFlagSettings()).put(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false).build();
        assertThat(
                .stream()
                .map(IndexTemplateMetadata::name)
                        )
                } catch (Exception e) {
        );
        // This must not throw: the second pattern is distinguishable from the first because
            InvalidIndexTemplateException.class,
        );
import java.util.HashMap;
        });
                "test",
            new ActionListener<AcknowledgedResponse>() {
                TimeValue.timeValueSeconds(30L),
            indexPatterns,
        );
        assertThat(state.metadata().componentTemplates().get("foo"), equalTo(componentTemplate));
            parsedMappings.get(2),
                        new DataStream(
                    "{\n"
            new ComposableIndexTemplate.DataStreamTemplate()
        MetadataIndexTemplateService.innerPutTemplate(state, req, IndexTemplateMetadata.builder("v1-template"));
                    return null;
        client().admin().indices().prepareDeleteTemplate("*").get(); // Delete all existing templates
            }
                        + "        }\n"
        request.patterns(singletonList("test_shards_wait*"));
                        + "        \"field2\": {\n"
import java.util.function.Function;
import org.opensearch.common.compress.CompressedXContent;
        String componentTemplateName = "ct-default-codec" + System.nanoTime();
        assertThat(errors.size(), equalTo(1));
            null,
                equalTo(Objects.nonNull(expectedTemplate.mappings()))
            SettingsException.class,
            Map<String, Object> secondMapping = Map.of(
import static org.hamcrest.CoreMatchers.equalTo;
                null
            state = service.addIndexTemplateV2(state, true, "timeseries-template", it);
        assertThat(
                    actualMappings = (Map<String, Object>) actualMappings.get(MapperService.SINGLE_MAPPING_NAME);
            "Invalid exception message." + ex.getMessage(),
        Template template = new Template(Settings.builder().build(), null, ComponentTemplateTests.randomAliases());
        ComposableIndexTemplate t2 = new ComposableIndexTemplate(
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("ct-best-compression-codec" + System.nanoTime(), 1);
        expectThrows(
            List.of("foo-*"),
                    logger.error(e);
                List.of("ct1"),
                null,
    public void testUpdateComponentTemplateFailsIfResolvedIndexTemplatesWouldBeInvalid() throws Exception {
            // a default @timestamp mapping will not be added if the matching template doesn't have the data stream field configured, even
        assertNotNull(e.getCause().getCause());
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
                } catch (Exception e) {
        latch.await(5, TimeUnit.SECONDS);
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
                List.of("ct1"),
            null,
        PutRequest request = new PutRequest("test", "putTemplate shards");
            ct,
        ComposableIndexTemplate it2 = new ComposableIndexTemplate(
                        + "          \"type\": \"keyword\"\n"
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("context-best-compression-codec" + System.nanoTime(), 1);
            null,
    @SuppressWarnings("unchecked")
 * Licensed to Elasticsearch under one or more contributor
            service.removeComponentTemplate(
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
        ThreadContext threadContext = getInstanceFromNode(ThreadPool.class).getThreadContext();
            } catch (Exception e) {
                    )
                    public void onFailure(Exception e) {
                null,
                null,
        };
import java.util.Set;
    public void testPutGlobalV2TemplateWhichProvidesContextInComposedOfSection() throws Exception {
                new ActionListener<AcknowledgedResponse>() {
            Settings.builder().put("invalid", "invalid").build(),
            null
            );
        // Now try to update the existing v1-template
            containsString("can't merge a non object mapping [field2] with an object mapping")
                .field("type", "text")
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());
     * template *AND* change the index patterns that a warning is generated
            ComposableIndexTemplate it = new ComposableIndexTemplate(
        final ClusterState throwState = ClusterState.builder(state).build();
            "Invalid exception message." + ex.getMessage(),
        assertNull(updatedState.metadata().templatesV2().get("foo"));
        PutRequest request = new PutRequest("api", "foobar_template");
                    "global index template [invalid_global_template], composed of component templates [ct] "
                }
        );
            containsString(
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                null,
                    "_doc",
            template.metadata(),
        // when(indicesServices.getRepositoriesServiceSupplier()).thenReturn(() -> repositoriesService);
                + "take precedence during new index creation"
            Arrays.asList("ct_low", "ct_high"),
    @Override
     * Test that if we have a pre-existing v1 template and put a v2 template that would match the same indices, we generate a warning
        });
            null,
                        IndexMetadata.builder(".ds-logs-mysql-000001")
        ClusterState state = ClusterState.EMPTY_STATE;
            null,
                .endObject()
            componentTemplateName,
            Arrays.asList("foo-bar-*", "eggplant"),
    }
                .toString()
        ClusterService clusterService = node().injector().getInstance(ClusterService.class);
        assertThat(settings.get("index.number_of_shards"), equalTo("3"));
                .map(IndexTemplateMetadata::name)
        a2.put("bar", AliasMetadata.newAliasMetadataBuilder("bar").build());
        Template templateWithIndexHiddenSetting = new Template(
    }
        final ClusterState finalState = state;
                randomBoolean(),
    }
                createComponentTemplateListener
            new Template(
            .put(IndexMetadata.SETTING_BLOCKS_READ, randomBoolean())
            1L,
import static org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata.fromComponentTemplateInfo;
import org.opensearch.index.mapper.MapperService;
        assertNotNull(state.metadata().templatesV2().get("foo"));
        CompressedXContent mappings = new CompressedXContent(
            null,
            null,
    }
            null
            );
                            + "      }\n"
                    err.set(exception);
                e.getMessage(),
            false,
            Exception.class,
        );
        ComponentTemplate ct2 = new ComponentTemplate(new Template(null, null, a2), null, null);
            ComposableIndexTemplateTests::randomInstance
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),
            null,
            null
        );
            if (err.get() != null) {
        ComposableIndexTemplate it = new ComposableIndexTemplate(
import static org.opensearch.common.util.concurrent.ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME;
            containsString("can't merge a non object mapping [field2] with an object mapping")
                        + "              \"type\": \"integer\"\n"
                        + "        }\n"
            List.of(),
        );
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            .build();
                    }
                                + "are issued"
        );
                }
                Collections.singletonMap(
            new Template(
    public void testPuttingV1StarTemplateGeneratesWarning() throws Exception {
            new Template(
                .settings(Settings.builder().put("index.hidden", true).build())
    public void testIndexTemplateWithAliasNameEqualToTemplatePattern() {
        assertFalse(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("foo-*-bar"), Arrays.asList("foo-*-baz")));
        Map<String, Object> meta = Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4));
                100L,
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo", componentTemplate)
        );
    public void testIndexTemplateValidationWithDefaultReplicas() throws Exception {
            new Template(
        assertWarnings(
import org.opensearch.cluster.ClusterState;
import java.util.ArrayList;
                        fail("the listener should not be invoked as validation should fail");
            assertThat(parsedMappings.get(0), equalTo(firstMapping));
        assertThat(e.getCause().getMessage(), containsString("invalid composite mappings for [my-template]"));
            "{\"properties\":{\"" + randomAlphaOfLength(5) + "\":{\"type\":\"keyword\"}}}"
            assertNotNull(mappings);
    }
            0L,
                List.of("timeseries*"),
                try {
    @Override
            public void onFailure(Exception e) {
                            + "    }\n"
import static org.hamcrest.CoreMatchers.instanceOf;
            IllegalArgumentException.class,
            expected.getDataStreamTemplate()
                            Collections.singletonList(new Index(".ds-logs-mysql-default-000001", "uuid"))
        assertFalse(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("foo-*"), Arrays.asList("bar-*")));
            true,
        request.settings(settingsBuilder.build());
                waitToCreateComponentTemplate.countDown();
                .stream()
                .stream()
        putTemplateDetail(new PutRequest("test", "foo-2").patterns(singletonList("foo-*")).order(2));
                .map(IndexTemplateMetadata::name)
            @Override
    }
        assertThat(settings.get("index.blocks.write"), equalTo("false"));
                + "from existing older templates [v1-template] with patterns (v1-template => [fo*, baz]); this template [v2-template] will "
            "ct-with-index-hidden-setting",
 */
import java.util.concurrent.TimeUnit;
            "api",
        assertTrue("Expected index template to have been created.", waitForIndexTemplate.await(10, TimeUnit.SECONDS));
                null,
            null
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
                new Template(
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
        );
    public void testFindV2TemplatesForHiddenIndex() throws Exception {
            null,
            10L,
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                Metadata.builder(state.metadata())
                0L,
     * Tests that we check that settings/mappings/etc are valid even after template composition,
                        + "      \"properties\": {\n"
            assertThat(
                new ActionListener<AcknowledgedResponse>() {
    public void testPutGlobalV2TemplateWhichProvidesContextWithLatestVersion() throws Exception {
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
            true,
                    Collections.singletonMap("properties", Collections.singletonMap("field", Collections.singletonMap("type", "keyword")))
            metadataIndexTemplateService.addComponentTemplate(state, false, "foo", updatedComponentTemplate);
        ComponentTemplate systemTemplateV2 = new ComponentTemplate(
import org.opensearch.index.IndexSettings;
        );
        assertTrue(
                + "from existing older templates [v1-template] with patterns (v1-template => [fo*, baz]); this template [v2-template] will "
                Arrays.asList("app-test-*-some_other-*")
            null,
                        + "        }\n"
    public void testResolveConflictingMappings() throws Exception {
        );
        );
            null,
 * ownership. Elasticsearch licenses this file to you under
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date")))
            new Template(
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {
            1L,
            null,
                            new DataStream.TimestampField("@timestamp"),
                            )
                    + "cause data streams [unreferenced, logs-mysql-default] to no longer match a data stream template"
                systemTemplateV2,
        );
import java.util.Collections;
            }
        );
                true,
    /**
                )
                TimeValue.timeValueSeconds(30L),
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                            + "    }"
                Objects.nonNull(actualTemplate.mappings()),
            null,
                .startObject()
            template.priority(),
            1L,
                    new ActionListener<AcknowledgedResponse>() {
                        + "        }\n"
                            "the listener should not be invoked as the validation should be executed before any cluster state updates "
    }
            null,
        assertNotNull(state.metadata().componentTemplates().get("bar"));
        assertThat(
            null,
        );
        ClusterService clusterService = node().injector().getInstance(ClusterService.class);
        );
            null,
                    logger.error(e);
            public void onFailure(Exception e) {
                null
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {
                "template-referencing-context-as-ct",
        ComponentTemplate ct1 = new ComponentTemplate(
            null,
    }
        PutRequest request = new PutRequest("test", "test_replicas");
                new CompressedXContent(
                        + "        \"@timestamp\": {\n"
     * Test that if we have a pre-existing v1 and v2 template, and we update the existing v1
                Collections.singletonMap(
        assertThat(
            new Template(
                List.of("logs*"),
                new CompressedXContent(
                    logger.error(e);
                        )
            containsInAnyOrder("global", "sneaky-hidden")
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            new Template(null, null, a3),
                    public void onFailure(Exception e) {
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            t -> Objects.equals(template.priority(), t.priority()),
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, clusterSettings);
                            + "    \"properties\": {\n"
            // user defines a @timestamp mapping as part of a component template
                        "{\n"
                null
            0L,
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
            );
                    ),
            new Environment(builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build(), null),
        ClusterState updatedState = MetadataIndexTemplateService.innerRemoveIndexTemplateV2(state, "low-priority-template");
            new Template(
        final List<Throwable> throwables = new ArrayList<>();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        );
            }
            contains("bar")
        );
        ClusterState state = ClusterState.EMPTY_STATE;
                        + "      }\n"
        ClusterState state = ClusterState.EMPTY_STATE;
            e.getMessage(),
                new CompressedXContent(
                    return null;
        assertThat(
import java.util.stream.Collectors;
                return MapperService.parseMapping(new NamedXContentRegistry(Collections.emptyList()), m.string());
            public void onResponse(AcknowledgedResponse response) {
            ex.getMessage().contains("specifies a component templates which can only be used in context")
            null
                    }
                new CompressedXContent(
                .startObject("field2")
                            + "        \"@timestamp\": {\n"
    }
                    + "configuration would cause data streams [unreferenced, logs-mysql-default] to no longer match a data stream template"
                            "foo",
            ComposableIndexTemplate template = new ComposableIndexTemplate(Arrays.asList("egg*", "baz"), null, null, 1L, null, null, null);
            null,
                try {
            null,
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        state = service.addComponentTemplate(state, true, "ct_high", ct1);
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
                + "be ignored in favor of a composable template at index creation time"
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async");
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        request.patterns(singletonList("te*"));
            null,
            ComposableIndexTemplate newTemplate = new ComposableIndexTemplate(
            template.version(),
        // The order of mappings should be:
        List<Throwable> errors = putTemplateDetail(request);
        assertNotNull(state.metadata().templatesV2().get("foo"));
            new Context("any")
}
    }
            expected.priority(),
        );
        request.patterns(singletonList("test_shards_wait*"));
            ),
                                    .build()
        }
                        "{\n"
        ComponentTemplate ct = new ComponentTemplate(new Template(Settings.EMPTY, null, null), null, null);
import static org.opensearch.common.util.FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES;
                        + "          \"type\": \"date_nanos\"\n"
        );
            }
            expected.version(),
        ClusterState state = ClusterState.EMPTY_STATE;
        assertNull(updatedState.metadata().templatesV2().get("foo"));
        );
                DataStream.getDefaultBackingIndexName("timeseries", 1L)
 * the Apache License, Version 2.0 (the "License"); you may
                }
    }
        waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS);
                        + "        }\n"
                    null,
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
import org.opensearch.index.compositeindex.CompositeIndexSettings;
            }
            patterns,
                }
                ),
        assertThat(metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template), equalTo(state));
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),
        assertNotNull(state.metadata().templates().get("v1-template"));
        request.patterns(singletonList("test_shards_wait*"));
                )
                .collect(Collectors.toList()),
        state = metadataIndexTemplateService.addComponentTemplate(state, false, "foo", componentTemplate);
                systemTemplateMetadata.fullyQualifiedName(),
    }
        e = expectThrows(IllegalArgumentException.class, () -> {
        );
        request.settings(settingsBuilder.build());
import static org.mockito.Mockito.mock;
import org.opensearch.indices.SystemIndices;
        );
        } catch (IllegalArgumentException e) {
            ),
            contains("sneaky-hidden")
 * specific language governing permissions and limitations
    public void testFindV2InvalidGlobalTemplate() {
                null
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");
        List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
            ),
                        )
            null,
        );
            null,
            );
                public void onFailure(Exception e) {
                createComponentTemplateListener
            null,
                null,
                    true,
                    expectedMappings = parser.map();
                systemTemplate,
        assertThat(throwables, is(empty()));
            ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "foo", template);
                null,
                is(
        assertNotNull(state.metadata().templates().get("id"));
     */
            () -> metadataIndexTemplateService.putComponentTemplate(
        assertNotNull(state.metadata().componentTemplates().get("foo"));
            ),
                    public void onResponse(AcknowledgedResponse response) {
        ClusterState state = ClusterState.EMPTY_STATE;
                    fail("failed to parse mappings: " + m.string());
                systemTemplateMetadata.fullyQualifiedName(),
            List.of("ct-with-index-hidden-setting"),
            .put(IndexMetadata.SETTING_PRIORITY, randomIntBetween(0, 100000))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
                        + "          \"type\": \"object\",\n"
        assertNull(updatedState.metadata().templatesV2().get("low-priority-template"));
        assertNotNull(state.metadata().templates().get("v1-template"));
        PutRequest request,
            new Template(Settings.builder().put("index.blocks.write", false).put("index.number_of_shards", 3).build(), null, null),
            contains("bar")
            0L,
    public void testUpdatingV1NonStarWithChangedPatternsTemplateGeneratesWarning() throws Exception {
            null,
        assertWarnings(
            null,
        assertTemplatesEqual(clusterState.metadata().templatesV2().get("foo"), templateToRemove);
        ComponentTemplate systemTemplate = new ComponentTemplate(
                null,
                new ComposableIndexTemplate.DataStreamTemplate()
                    null
                List.of("timeseries*"),
                        + "      }\n"
            );
        assertThat(
                null,
                            + "        \"type\": \"integer\"\n"
            "legacy template [v1-template] has index patterns [egg*, baz] matching patterns "
        }
            template.template(),
                List.of("*"),
            try {
            Collections.singletonList("i*"),
            null
                null,
    public void testDefinedTimestampMappingIsAddedForDataStreamTemplates() throws Exception {
                ),
        ClusterState state = ClusterState.EMPTY_STATE;
        );
                        + "    }"
        );
            .metadata(
            randomBoolean() ? null : randomNonNegativeLong(),
            null,
            })
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)
                .collect(Collectors.toList()),
            CountDownLatch errLatch = new CountDownLatch(1);
        assertThat(errors.get(0).getMessage(), equalTo("alias [foobar] cannot be the same as any pattern in [foo, foobar]"));
            assertThat(mappings.size(), equalTo(4));
            "good",
                TimeValue.timeValueSeconds(30L),
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);
        );
            }
        Settings clusterSettings = Settings.builder().build();
                        + "        \"field1\": {\n"
            Collections.singletonList("i*"),
        );
            new Template(Settings.builder().put("number_of_replicas", 2).put("index.blocks.write", true).build(), null, null),
                            "unreferenced",
        Settings settings = Settings.builder()
    public void testIndexTemplateValidationWithSpecifiedReplicas() throws Exception {
            null
            contains("global")
                ),
     * when updating a component template
        pr.patterns(Arrays.asList("foo", "bar"));
        List<Throwable> throwables = putTemplateDetail(request);
        ThreadContext threadContext = getInstanceFromNode(ThreadPool.class).getThreadContext();
        ComponentTemplate componentTemplate2 = new ComponentTemplate(template, 1L, new HashMap<>());
        // Test adding a higher priority version that would cause problems
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new PutRequest("testFindTemplatesWithHiddenIndices", "sneaky-hidden").patterns(singletonList("sneaky*"))
        PutRequest request = new PutRequest("test", "test_index_primary_shard_constraint");
            )
                    null
            Metadata invalidGlobalTemplateMetadata = Metadata.builder()
        ComposableIndexTemplate expectedNoTemplate = new ComposableIndexTemplate(
        );
    public void testAddIndexTemplateV2() throws Exception {
            ActionListener.wrap(r -> latch.countDown(), e -> fail("unexpected error"))
            );
                createComponentTemplateListener
            equalTo(
                systemTemplateV2Metadata.fullyQualifiedName(),
                try (
            XContentFactory.jsonBuilder()
     */
            ex.getMessage().contains("specifies a context which is not loaded on the cluster")
            null,
            assertThat(
                        + "          }\n"
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }
                    "_doc",
        state = metadataIndexTemplateService.addComponentTemplate(state, false, "foo", componentTemplate);
        );
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
            );
        Template actualTemplate = actual.template();
            }
            equalTo(
        client().admin().indices().prepareDeleteTemplate("*").get(); // Delete all existing templates
        );
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {
                } catch (IOException e) {
            "index template [v2-template] has index patterns [foo-bar-*, eggplant] matching patterns "
                    "{\n"
            null
            null
        ComposableIndexTemplate it = new ComposableIndexTemplate(
    private List<Throwable> putTemplateDetail(PutRequest request) throws Exception {
        // Patterns with a common prefix and different literal suffixes after a wildcard
                        IndexMetadata.builder(".ds-logs-mysql-default-000001")
                + "take precedence during new index creation"
        assertThat(e.name(), equalTo("template"));
        Settings settings = Settings.builder().put(incomingNodeScopedSettings).put(PATH_HOME_SETTING.getKey(), "dummy").build();
            parsedMappings.get(0),
        service.addIndexTemplateV2(stateWithDSAndTemplate, false, "logs", nonDSTemplate);
        latch.await();
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
    public void testPutGlobalTemplateWithIndexHiddenSetting() throws Exception {
            )
                systemTemplate,
                Map<String, Object> expectedMappings;
    public void testUpdatingV1NonStarTemplateWithUnchangedPatternsGeneratesWarning() throws Exception {
                "test",
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            ComposableIndexTemplate nonDSTemplate = new ComposableIndexTemplate(
                @Override
                    @Override
    public void testUpdateComponentTemplateWithIndexHiddenSetting() throws Exception {
        }
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 2L)
/*
    }
        ComponentTemplate componentTemplate3 = new ComponentTemplate(template, 1L, new HashMap<>());
                        + "        }\n"
                                Settings.builder()
            MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;
            matchesRegex("composable template \\[my-template\\] template after composition with component templates .+ is invalid")
        request.settings(builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "0").put("index.shard.check_on_startup", "blargh").build());
                null,
        CountDownLatch ctLatch = new CountDownLatch(1);
                    ),
            new Context(systemTemplateMetadata.name())
        SystemTemplateMetadata systemTemplateV2Metadata = fromComponentTemplateInfo(systemTemplateMetadata.name(), 2);
    public void testIndexTemplateInvalidNumberOfShards() {
import static org.hamcrest.Matchers.is;
            public void onFailure(Exception e) {
        // update the component template to set the index.hidden setting
        }
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, clusterSettings);
            template,
            Arrays.asList("i*"),
            new Template(
                    }
import org.opensearch.indices.replication.common.ReplicationType;
                    "{\n"
            Collections.singletonList("logs-*-*"),
                systemTemplateMetadata.fullyQualifiedName(),
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);
                1L,
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");
            ex.getMessage().contains("specifies a context which is not loaded on the cluster")
                Collections.singletonMap(
        // the literal segment after the first wildcard differs (_other vs nothing).
 * Unless required by applicable law or agreed to in writing,
                "test",
                null,
                    new ComposableIndexTemplateMetadata(Map.of("invalid_global_template", invalidGlobalTemplate))
                    }
                        + "            }\n"
import org.opensearch.common.settings.SettingsException;
        Function<String, Template> templateApplier = codec -> new Template(
            ComponentTemplate ct1 = new ComponentTemplate(
            new PutRequest("testPutGlobalTemplateWithIndexHiddenSetting", "sneaky-hidden").patterns(singletonList("*"))
        final String indexTemplateName = verifyTemplateCreationUsingContext("1");
            containsString("unknown value for [index.shard.check_on_startup] " + "must be one of [true, false, checksum] but was: blargh")
            assertThat(actualTemplate.settings(), equalTo(expectedTemplate.settings()));
        assertThat(MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", randomBoolean()), empty());
            1L,
            null,
            }
        assertNotNull(e.getCause());
                    @Override
                null
            ComponentTemplateTests.randomAliases()
        state = service.addIndexTemplateV2(state, true, "my-template", it);
            .build();
                        + "          \"type\": \"text\"\n"
        ComponentTemplate componentTemplate = ComponentTemplateTests.randomInstance();
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(
            componentTemplate,
            assertTrue(
            null,
                null,
 * this file be licensed under the Apache-2.0 license or a
                .collect(Collectors.toList()),
                    "_doc",
    public void testPuttingV1NonStarTemplateGeneratesWarning() throws Exception {
            }).collect(Collectors.toList());
        List<Throwable> errors = putTemplateDetail(
            ComponentTemplateTests.randomAliases()
            null,
            null,
            List.of("logs-*"),
                    + "setting"
        );
                                Settings.builder()
            @Override
                null,
        putTemplateDetail(new PutRequest("test", "foo-1").patterns(singletonList("foo-*")).order(1));
    public void testBrokenMapping() throws Exception {
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.common.settings.ClusterSettings;
                            LoggingDeprecationHandler.INSTANCE,
        }
                "test",
        assertNotNull(state.metadata().templatesV2().get("foo"));
                        }
        });
                            expectedTemplate.mappings().string()
        expectThrows(
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);
            TimeValue.timeValueSeconds(30L),
                null,
                TimeValue.timeValueSeconds(30),
            @Override
        assertThat(
    public void testRemoveComponentTemplateInUse() throws Exception {
            0L,
            null,
        final String indexTemplateName = verifyTemplateCreationUsingContext(Context.LATEST_VERSION);
        request.patterns(singletonList("test_shards*"));
        );
        );
            state = service.addIndexTemplateV2(state, true, "logs-template", it);
            null,
                equalTo(
                        + "          \"type\": \"text\"\n"
                        + "      \"field3\": {\n"
            @Override
                    )
                    XContentParser parser = MediaTypeRegistry.JSON.xContent()
        );
            .build();
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
                    Collections.singletonMap("properties", Collections.singletonMap("field2", Collections.singletonMap("type", "text")))
        assertNotNull(state.metadata().templatesV2().get("v2-template"));
        // - ct_low
    public void testDistinguishableMultiWildcardTemplatesAccepted() throws Exception {
            MetadataIndexTemplateService.findV2Template(invalidGlobalTemplateMetadata, "index-name", false);
                        + "      }\n"
            2L,
            ),
            Arrays.asList("app-test-*-some_other-*"),
        assertThat(metadataIndexTemplateService.addComponentTemplate(state, false, "foo", componentTemplate), equalTo(state));
            // indices matched by templates without the data stream field defined don't get the default @timestamp mapping
            100L,
                true,
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
            Map<String, Object> secondMapping = Map.of(
        request.patterns(singletonList("test_shards_wait*"));
            "ct",
            TimeValue.timeValueSeconds(5),
                1L,
                            + "    \"properties\": {\n"
        ComponentTemplate updatedComponentTemplate = new ComponentTemplate(templateWithIndexHiddenSetting, 2L, new HashMap<>());
            Map<String, Object> firstMapping = Map.of("_doc", Map.of("properties", Map.of("field1", Map.of("type", "keyword"))));
        );
                            new NamedXContentRegistry(Collections.emptyList()),
            1L,
                .map(IndexTemplateMetadata::name)
            null,
            ),
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
        pr.order(randomIntBetween(0, 10));
        final CountDownLatch latch = new CountDownLatch(1);
        request.mappings(
                null,
        request.aliases(aliases);
    public void testPutGlobalV2TemplateWhichProvidesContextWithNonExistingVersion() throws Exception {
                        + "        \"field2\": {\n"
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        final ClusterState finalState = state;
            null
        Context context = new Context(systemTemplateMetadata.name(), contextVersion, Map.of());
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),
                "_doc",
                    "_doc",
        );
import static org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader.TEMPLATE_LOADER_IDENTIFIER;
import java.util.HashSet;
        );
                            + "        }\n"
                Collections.singletonMap(
        IllegalArgumentException e = expectThrows(
            null
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);
        template = new Template(
                        + "      \"properties\": {\n"
                )
public class MetadataIndexTemplateServiceTests extends OpenSearchSingleNodeTestCase {
        // Patterns that share a genuine conflict: baz matches baz*
                }
        ComposableIndexTemplate secondGlobalIndexTemplate = new ComposableIndexTemplate(
                        public void onFailure(Exception e) {
                null,
                    "{\n"
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
                        + "    }"
            containsInAnyOrder("foo-2", "foo-1", "global")
        state = MetadataIndexTemplateService.innerPutTemplate(state, req, IndexTemplateMetadata.builder("v1-template"));
        request.mappings("abcde");
        request.aliases(Collections.singleton(new Alias("foobar")));
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        + "    }"
                createComponentTemplateListener
        service.putTemplate(request, new MetadataIndexTemplateService.PutListener() {
            Settings.builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(),
            null,
import org.opensearch.common.util.FeatureFlags;
            );
                    return null;
                }
        assertTemplatesEqual(state.metadata().templatesV2().get("v2-template"), v2Template);
    }
            null,
    }
            "index template [v2-template] has index patterns [foo-bar-*, eggplant] matching patterns "
                TimeValue.timeValueSeconds(30L),
                            "logs-mysql-default",
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        ComponentTemplate ct = ComponentTemplateTests.randomInstance();
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(
            .build();
            Map<String, Object> secondMapping = Map.of("_doc", Map.of("properties", Map.of("field1", Map.of("type", "keyword"))));
package org.opensearch.cluster.metadata;
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        );
                            "logs-mysql",
        );
            e.getMessage(),
                true,
            2L,
                    "{\n"
                        )
            50L,
        state = metadataIndexTemplateService.addIndexTemplateV2(state, true, "globalindextemplate2", secondGlobalIndexTemplate);
        List<Throwable> errors = putTemplateDetail(request);
        );
                        fail(
import org.opensearch.common.settings.Settings;
                true,
        }
        Settings settings = MetadataIndexTemplateService.resolveSettings(state.metadata(), "my-template");
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();
            null,
import org.opensearch.common.util.concurrent.ThreadContext;
                .endObject()
        expectThrows(
            null
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "131m");
            containsString(
                    err.set(exception);
            );
            );
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", true)
        // Patterns with multi-wildcards where literal segments after the first wildcard distinguish them
                ),
                    "index template [foo2] has index patterns [abc, baz*] matching patterns from existing "
                TimeValue.timeValueSeconds(30L),
                throw err.get();
        state = metadataIndexTemplateService.addComponentTemplate(state, true, "foo", componentTemplate);
                            )
            fail(
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date_nanos")))
            null,
                )
                        IndexMetadata.builder(".ds-foo-000001")
        state = service.addComponentTemplate(state, true, "ct_high", ct1);
    public void testPutExistingComponentTemplateIsNoop() throws Exception {
    }
        assertThat(
                Arrays.asList("abc", "baz*"),
            try {
            if (err.get() != null) {
                    @Override
        ComponentTemplate changedCt2 = new ComponentTemplate(
            state = service.addIndexTemplateV2(state, true, "logs-data-stream-template", it);
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
        );
                        + "        }\n"
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();
            null,
            null,
            ),
import org.opensearch.index.codec.CodecService;
                null,
        InvalidIndexTemplateException e = expectThrows(InvalidIndexTemplateException.class, () -> {
            Settings.builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(),
        );
                    new CompressedXContent(
            ),
                        + "templates [foo] with patterns (foo => [egg*, baz]) that have the same priority [0], multiple index templates may not "
            .build();
                ),
        ComposableIndexTemplate it2 = new ComposableIndexTemplate(
import org.opensearch.common.settings.IndexScopedSettings;
        assertThat(
                null
            throwables.get(0).getMessage()
        assertTemplatesEqual(
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
                    "testing",
        ClusterState stateWithDSAndTemplate = service.addIndexTemplateV2(stateWithDS, false, "logs-mysql", mysqlTemplate);
 * GitHub history for details.
            }).collect(Collectors.toList());
                            + "    }\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
                        + "      \"field\": {\n"
        ActionListener<AcknowledgedResponse> createComponentTemplateListener = new ActionListener<AcknowledgedResponse>() {
            containsString("Failed to parse value [0] for setting [index.number_of_shards] must be >= 1")
            null,
                        + "          }\n"
            .put(IndexMetadata.SETTING_BLOCKS_WRITE, randomBoolean())
        );
            e.getMessage(),
                @Override
        ClusterState state = ClusterState.EMPTY_STATE;
import static org.opensearch.index.mapper.DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD;
                Collections.singletonMap(
            null
                    logger.error(e);
            null,
                        + "    }"
            new Template(
                "_doc",
        );
                if (expectedMappings.size() == 1 && expectedMappings.containsKey(MapperService.SINGLE_MAPPING_NAME)) {
            new AliasValidator(),
        List<String> componentTemplates = randomList(0, 10, () -> randomAlphaOfLength(5));
                new ComposableIndexTemplate.DataStreamTemplate()
                        + "    }"
                        + "    }"
        List<Throwable> errors = putTemplate(xContentRegistry(), request);
import static org.opensearch.indices.ShardLimitValidatorTests.createTestShardLimitService;
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", null)
        PutRequest request = new PutRequest("test", "test_replicas");
        assertNotNull(e.getCause());
            ComposableIndexTemplate nonDSTemplate = new ComposableIndexTemplate(
        );
            () -> metadataIndexTemplateService.putIndexTemplateV2(
                        + "        \"field2\": {\n"
import org.opensearch.threadpool.ThreadPool;
            new Template(null, null, a4),
                + "from existing composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]); "
        InvalidIndexTemplateException ex = expectThrows(
                    fail("failed to parse mappings: " + m.string());
    }
            null,
        assertThat(settings.get("index.blocks.read"), equalTo("true"));
                null,
            );
            null,
            }).collect(Collectors.toList());
            ),
            List.of("*"),
            1L,
                TimeValue.timeValueSeconds(30L),
            MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                waitToCreateComponentTemplate.countDown();
                        + "      }\n"
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);
            actual.priority(),
                    .put(
                null,
                .stream()
            new Template(null, null, null),
            Arrays.asList("ct_low", "ct_high"),
                        fail("the listener should not be invoked as validation should fail");
            assertThat(mappings.size(), equalTo(2));
            e.getMessage(),
        assertWarnings(
        state = service.addIndexTemplateV2(state, false, "app-test-some-other", t2);
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);
        );
    }
                ) {
        ClusterState state = ClusterState.EMPTY_STATE;
                        );
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                ),
        ComponentTemplate ct1 = new ComponentTemplate(
                null,
        List<String> indexPatterns = List.of("foo*");
        state = service.addComponentTemplate(state, true, "c2", ct2);
        assertTrue(
        // Completely disjoint literal prefixes do not overlap
    }
            new CompressedXContent("{\"invalid\"}"),
            0L,
        ComponentTemplate componentTemplate = new ComponentTemplate(templateApplier.apply(CodecService.DEFAULT_CODEC), 1L, new HashMap<>());
        Map<String, AliasMetadata> a1 = new HashMap<>();
            "legacy template [v1-template] has index patterns [fo*, baz] matching patterns from existing "
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(
            .put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "2");
            MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                .stream()
                    null,
            .build();
        );
            .put(CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "130m")
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "sneaky1", true)
            ComposableIndexTemplate it = new ComposableIndexTemplate(
        ClusterState state = ClusterState.EMPTY_STATE;
                        + "      }\n"
            )
            "api",
        if (actualTemplate != null) {
        assertThat(errors.size(), equalTo(1));
                null,
            null,
                DataStream.getDefaultBackingIndexName("logs", 1L)
        );
            }).collect(Collectors.toList());
    }
            List.of("*"),
            null,
                Arrays.asList("abc", "baz*"),
                null,
    }
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                        + "      }\n"
            List.of("*"),
                null,
                latch.countDown();
            null
                TimeValue.timeValueSeconds(30L),
            actual.indexPatterns(),
        assertThat(mappings.size(), equalTo(3));
            new ComposableIndexTemplate.DataStreamTemplate()
    }
            clusterService,
            List.of("logs-*"),
            // add an invalid global template that specifies the `index.hidden` setting
        PutRequest request = new PutRequest("api", "validate_template");
        return true;
        ClusterState state = ClusterState.EMPTY_STATE;
            null
                            )
            null,
            Collections.singletonList("*"),
        InvalidIndexTemplateException ex = expectThrows(
     * Test that if we have a pre-existing v2 template and put a "*" v1 template, we generate a warning
            List.of("*"),
            null,
                    .build()
            }
            null,
            Settings.EMPTY,
            TimeValue.timeValueSeconds(30),
            1L,
        }).collect(Collectors.toList());
    public void testPatternsActuallyOverlap() {
            public void onResponse(AcknowledgedResponse response) {
                Metadata.builder(state.metadata())
                Arrays.asList("app-test-*-some-*"),
                    "{\n"
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                "test",
        return throwables;
            Map<String, Object> firstParsedMapping = Map.of(
            null,
        RepositoriesService repositoriesService = mock(RepositoriesService.class);
            null
        if (randomBoolean()) {
            ),
                        fail("the listener should not be invoked as validation should fail");
    public void testPutGlobalV2TemplateWhichProvidesContextWithContextDisabled() throws Exception {
                null,
                    new CompressedXContent(
        ComposableIndexTemplate newTemplate = randomValueOtherThanMany(
            expected.indexPatterns(),
                null,
                    + "configuration would cause data streams [unreferenced, logs-mysql-default] to no longer match a data stream template"
                Collections.singletonList("logs-my*-*"),
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(
            }).collect(Collectors.toList());
            null,
            ComposableIndexTemplate template = new ComposableIndexTemplate(
            assertThat(e.getMessage(), not(containsStringIgnoringCase("foopatternindextemplate")));
                                    .build()
        // Because the first elements when merging mappings have the lowest precedence
        CountDownLatch waitForIndexTemplate = new CountDownLatch(1);
            }
        expectThrows(
    public void testIndexTemplateFailsToOverrideComponentTemplateMappingField() throws Exception {
            new CompressedXContent("{}"),
        // not hidden
                .field("analyzer", "custom_1")
                        + "        \"type\": \"integer\"\n"
        ComponentTemplate ct1 = new ComponentTemplate(
    }
        Function<String, Template> templateApplier = codec -> new Template(
        request.patterns(singletonList("te*"));
            @Override
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
                        + "          \"type\": \"text\"\n"
            Arrays.asList("foo-bar-*", "eggplant"),
                ),
            Map<String, Object> thirdMapping = Map.of("_doc", Map.of("properties", Map.of("field2", Map.of("type", "integer"))));
            null
            public void onFailure(Exception e) {
        ComponentTemplate ct2 = new ComponentTemplate(
            .metadata(metadata)
            expected.composedOf(),
                null,
                        + "        }\n"
        assertTemplatesEqual(state.metadata().templatesV2().get("v2-template"), v2Template);
            )
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();
            IllegalArgumentException.class,
                        + "            }\n"
            null,
                    globalIndexTemplate,
                null,
            throwables.get(0).getMessage(),
            null,
        });
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", false)
                waitToCreateComponentTemplate.countDown();
        assertThat(e.getMessage(), equalTo("index_template [foo] missing"));
                null
import org.opensearch.index.engine.EngineConfig;
        state = ClusterState.builder(state)
        request.patterns(singletonList("test_shards_wait*"));
                        + "      \"properties\": {\n"
        MetadataIndexTemplateService service = new MetadataIndexTemplateService(
                systemTemplateMetadata.fullyQualifiedName(),
        ComposableIndexTemplate highPriorityTemplate = new ComposableIndexTemplate(
            assertThat(parsedMappings.get(0), equalTo(firstMapping));
            null
        );
            null,
                    public void onResponse(AcknowledgedResponse response) {
            );
                        fail("the listener should not be invoked as validation should fail");
                        + "        \"field2\": {\n"
                true,
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();
        ClusterState state = ClusterState.EMPTY_STATE;
            getInstanceFromNode(ThreadPool.class).getThreadContext().putTransient(ACTION_ORIGIN_TRANSIENT_NAME, TEMPLATE_LOADER_IDENTIFIER);
                    )
/*
    public void testUnreferencedDataStreamsWhenAddingTemplate() throws Exception {
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
        });
    }
        );
            )
     * Tests that we check that settings/mappings/etc are valid even after template composition,
        Settings.Builder settingsBuilder = builder().put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), "true")
        ClusterState stateWithDS = ClusterState.builder(state)
import static org.hamcrest.Matchers.containsInAnyOrder;
            randomBoolean() ? Arrays.asList("c1", "c2") : Arrays.asList("c2", "c1"),
                        + "      }\n"
                        public void onResponse(AcknowledgedResponse response) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                null
    private String verifyTemplateCreationUsingContext(String contextVersion) throws Exception {
        state = service.addComponentTemplate(state, true, "ct", ct);
                    .build()
    public void testAddComponentTemplate() throws Exception {
            Settings.builder().build(),
                })
/*
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            "api",
        state = service.addComponentTemplate(state, true, "ct_low", ct2);
        assertThat(errors.get(0).getMessage(), containsString("global templates may not specify the setting index.hidden"));
        service.putComponentTemplate(
                .collect(Collectors.toList()),
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            );
            metadataIndexTemplateService.putComponentTemplate(
    }
        assertWarnings(
            1L,
            ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
        );
        ClusterState state = ClusterState.EMPTY_STATE;
        );
    public static void assertTemplatesEqual(ComposableIndexTemplate actual, ComposableIndexTemplate expected) {
        a1.put("foo", AliasMetadata.newAliasMetadataBuilder("foo").build());
        ComponentTemplate ct1 = new ComponentTemplate(
            null,
        IndexTemplateMissingException e = expectThrows(
        );
            }
            () -> MetadataIndexTemplateService.innerRemoveIndexTemplateV2(ClusterState.EMPTY_STATE, "foo")
                1L,
            @Override
            null,
            throwables.get(0).getMessage(),
            new PutRequest("testFindTemplatesWithHiddenIndices", "bar").patterns(singletonList("bar-*")).order(between(0, 100))
        assertTrue("Could not create component templates", waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS));
        // - index template
        // Create two templates with different priorities that match the same data stream
            100L,
        state = metadataIndexTemplateService.addIndexTemplateV2(state, true, "globalindextemplate1", firstGlobalIndexTemplate);
                + "from existing older templates [v1-template] with patterns (v1-template => [fo*, baz]); this template [v2-template] will "
        assertThat(
            null,
            containsString("component templates [ct] cannot be removed as they are still in use by index templates [template]")
                        + "    }"
        );
        assertThat(settings.get("index.codec"), equalTo(CodecService.ZLIB));
        );
        IndicesService indicesServices = mock(IndicesService.class);
                new CompressedXContent(
                }
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
        {
                Arrays.asList("egg*", "baz"),
                    .put(
                .map(IndexTemplateMetadata::name)
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
        );
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
                        + "match during index creation, please use a different priority"
        );
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
        assertThat(
                null
            null
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);
                "testing",
    }
    }
        assertTrue(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("app-*"), Arrays.asList("app-*")));
        FeatureFlags.TestUtils.with(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false, () -> {
                "expecting an exception as updating the component template would yield the global templates to include the index.hidden "
        ctLatch.await(5, TimeUnit.SECONDS);
                        + "    }"
        List<Throwable> throwables = putTemplate(xContentRegistry(), request);
import org.opensearch.core.action.ActionListener;
            1L,
                0L,
    public void testFindTemplates() throws Exception {
                    TimeValue.timeValueSeconds(30L),
                        + "defined the index.hidden setting, which is not allowed"
    public void testAliasInvalidFilterInvalidJson() throws Exception {
                latch.countDown();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))
        );
        );
            null
                ),
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
        assertFalse(
                state,
                throwables.add(e);
            service.addIndexTemplateV2(stateWithDS, false, "logs", nonDSTemplate);
                        )
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
    }
        ComponentTemplate systemTemplate = new ComponentTemplate(
                null,
            throwables.get(0).getMessage(),
            CountDownLatch latch = new CountDownLatch(1);
                } catch (Exception e) {
            new Template(
                try {
                                + "are issued"
                    fail("failed to parse mappings: " + m.string());
            null,
import java.util.concurrent.CountDownLatch;
                logger.error("unexpected error", e);
        assertThat(highPriorityDataStreams, contains("logs-mysql"));
            mappings = MetadataIndexTemplateService.collectMappings(
        // Great, the templates aren't invalid
                fail("failed to parse mappings: " + m.string());
        }
        PutRequest request = new PutRequest("test", "test_default_replicas");
        ComponentTemplate componentTemplate = new ComponentTemplate(template, 1L, new HashMap<>());
            Settings.builder().build(),
        });
                    @Override
        assertWarnings(
                null,
            2L,
            ex.getMessage().contains("A system template can only be created/updated/deleted with a repository")
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
            0L,
import static org.hamcrest.CoreMatchers.containsString;
    protected boolean resetNodeAfterTest() {
        // unknown
        assertThat(e.getMessage(), containsString("index template [template] specifies " + "component templates [bad] that do not exist"));
                        + "templates [foo] with patterns (foo => [egg*, baz]) that have the same priority [1], multiple index templates may not "
            null,
                ex.getMessage().contains("specifies a context which cannot be used without enabling")
        ComponentTemplate componentTemplate = new ComponentTemplate(templateWithIndexHiddenSetting, 1L, new HashMap<>());
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        state = service.addIndexTemplateV2(state, true, "high-priority-template", highPriorityTemplate);
    ) {
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        String result = MetadataIndexTemplateService.findV2Template(state.metadata(), "index", randomBoolean());
            );
        );
                        + "            \"foo\": {\n"
                null
                ),
    public void testResolveMappings() throws Exception {
    }
                null
                    Collections.singletonMap("properties", Collections.singletonMap("field2", Collections.singletonMap("type", "keyword")))
    public void testPuttingOverlappingV2Template() throws Exception {
                true,
                "testing",
            ComposableIndexTemplate it = new ComposableIndexTemplate(
                ),
            );
    }
    /**
            new ComposableIndexTemplate.DataStreamTemplate()
import org.opensearch.core.xcontent.XContentParser;
        );
            null
            Map<String, Object> firstMapping = Map.of(
        );
        ClusterState state = ClusterState.EMPTY_STATE;
        state = service.addIndexTemplateV2(state, false, "app-test-some", t1);
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
        assertTemplatesEqual(state.metadata().templatesV2().get("foo"), template);
            1L,
                .collect(Collectors.toList()),
        request.patterns(singletonList("test_wait_shards_default_replica*"));
            null,
        assertThat(throwables.get(0).getMessage(), containsString("name must not contain a space"));
        state = MetadataIndexTemplateService.innerPutTemplate(state, req, IndexTemplateMetadata.builder("v1-template"));
                    .put(
        );
        request.patterns(singletonList("te*"));
                    }
        ComposableIndexTemplate it = new ComposableIndexTemplate(
                null
            service.putIndexTemplateV2(
        ComposableIndexTemplate lowPriorityTemplate = new ComposableIndexTemplate(
        );
            null,
                TimeValue.timeValueSeconds(30),
            Collections.singletonList("logs-mysql-*"),
            pr.mappings("{}");
                        + "    \"properties\": {\n"
        );
                }
    }
        );
            expected.metadata(),
            new SystemIndices(Collections.emptyMap()),
        assertThat(
            )
    }
            createComponentTemplateListener
            null
        ComposableIndexTemplate fooPatternIndexTemplate = new ComposableIndexTemplate(
            if (actualTemplate.mappings() != null) {
                            + "      \"properties\": {\n"
    public void testIndexTemplateValidationAccumulatesValidationErrors() {
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 5))
            null,
            null
            }
     */
                return null;
                        + "          \"type\": \"text\"\n"
                1L,
        );
        assertNotNull(state.metadata().componentTemplates().get("foo"));
        );
        Function<String, Template> templateApplier = codec -> new Template(
import org.opensearch.action.admin.indices.alias.Alias;
                    )
            InvalidIndexTemplateException.class,
                )
            null,
            state = service.addIndexTemplateV2(state, true, "timeseries-template", it);
            );
            null,
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", null)
 * The OpenSearch Contributors require contributions made to
            template.composedOf(),
        );
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");
                    logger.error(e);
import static org.mockito.Mockito.when;
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("ct-best-compression-codec" + System.nanoTime(), 1);
            null
        metadataIndexTemplateService.putComponentTemplate(
            null,
                new CompressedXContent(
        assertThat(mappings.size(), equalTo(3));
                .collect(Collectors.toList()),
                    .put(
        );
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date_nanos")))
        state = service.addComponentTemplate(state, true, "c1", ct1);
        req.patterns(Arrays.asList("egg*", "baz"));
                    "{\n"
            null,
                .settings(Settings.builder().put("index.hidden", true).build())
            xContentRegistry,
            null,
            List.of("*"),
            .put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true)
            null,
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(3);
        // Test that only the high priority template reports the data stream as using it
        );
        );
        assertTrue(
            null,
        state = metadataIndexTemplateService.addComponentTemplate(state, randomBoolean(), "bar", componentTemplate);
        assertThat(throwables.get(0).getMessage(), containsString("index_pattern [_test_shards*] must not start with '_'"));
                } catch (Exception e) {
            null,
            null
    public void testPutGlobalV2TemplateWhichProvidesContextWithSpecificVersion() throws Exception {
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            node().injector().getInstance(ClusterService.class).state().metadata().templatesV2().get(indexTemplateName),
                            actualTemplate.mappings().string()
                null,
                        );
                IllegalArgumentException.class,
                null,
                } catch (IOException e) {
                + "take precedence during new index creation"
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(
        // Add a data stream
                null,
                return null;
        ComposableIndexTemplate template = new ComposableIndexTemplate(
        );
                0L,
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),
                    @Override
            assertNotNull(mappings);
                + " this template [v1-template] may be ignored in favor of a composable template at index creation time"
            );
                if (actualMappings.size() == 1 && actualMappings.containsKey(MapperService.SINGLE_MAPPING_NAME)) {
        ComponentTemplate componentTemplate = new ComponentTemplate(template, 1L, new HashMap<>());
                } catch (Exception e) {
        );
                logger.error(e);
            TimeValue.timeValueSeconds(5),
            10L,
                    throw new AssertionError(e);
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);
                null,
        assertThat(throwables.get(0).getMessage(), containsString("[2]: cannot be greater than number of shard copies [1]"));
                        + "    }"
            assertThat(mappings.size(), equalTo(3));
        assertEquals(throwables.size(), 1);
        );
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
            Arrays.asList("ct_low", "ct_high"),
                    "_doc",
                fail("unexpected error");
                return MapperService.parseMapping(new NamedXContentRegistry(Collections.emptyList()), m.string());
        request.settings(settingsBuilder.build());
        template = new ComposableIndexTemplate(
        ComposableIndexTemplate template = new ComposableIndexTemplate(
                        + "            \"foo\": {\n"
                null,
        PutRequest request = new PutRequest("test", "test_replicas");
        }
                    null
                .collect(Collectors.toList()),
        ClusterService clusterService = mock(ClusterService.class);
            )
        );
                        + "      \"properties\": {\n"
                new CompressedXContent(
        assertThat(
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
                    waitForIndexTemplate.countDown();
        assertTrue(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("egg*", "baz"), Arrays.asList("abc", "baz*")));
                .collect(Collectors.toList()),
            containsString("Failed to parse value [0] for setting [index.number_of_shards] must be >= 1")
        ClusterState state = ClusterState.EMPTY_STATE;
        assertNotNull(mappings);
        state = service.addComponentTemplate(state, true, "c1", ct1);
                            + "        \"type\": \"integer\"\n"
            .metadata(
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "sneaky1", false)
            Collections.singletonList("ct"),
                        + "    }"
        assertThat(e.getMessage(), containsString("index template [foo] already exists"));
        );
            @Override
            equalTo(
            );
            containsString(
            null,
                public void onResponse(AcknowledgedResponse response) {
                            + "          \"type\": \"date_nanos\"\n"
            randomBoolean() ? Arrays.asList("c1", "c2") : Arrays.asList("c2", "c1"),
                .stream()
            null
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "sneaky1", null)
            0L,
                .startObject("properties")
            () -> service.addComponentTemplate(finalState, false, "c2", changedCt2)
                globalIndexTemplate,
        );
        request.settings(builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "0").build());
                state,
        state = service.addIndexTemplateV2(state, false, "logs", template);
            public void onFailure(Exception e) {
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
        ComponentTemplate systemTemplate = new ComponentTemplate(
        final ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "foo", template);
            public void onResponse(AcknowledgedResponse response) {
            parsedMappings.get(1),
                    fail("the listener should not be invoked as the template should succeed");
            new Template(
            componentTemplates,
        assertThat(
                null,
            "expected both templates to have either a template or no template",
        putTemplateDetail(
            null,
        );
        assertNotNull(state.metadata().templatesV2().get("app-test-some-other"));
                }
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)
    }
            template,
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();
            state = service.addComponentTemplate(state, true, "ct1", ct1);
                        + "      \"properties\": {\n"
        };
 * KIND, either express or implied.  See the License for the
            null,
                + "from existing composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]);"
    }
            equalTo(
                "template",
        request.patterns(singletonList("_test_shards*"));
    public void testMaxTranslogFlushSizeWithCompositeIndex() {
import org.opensearch.cluster.metadata.MetadataIndexTemplateService.PutRequest;
                throwables.add(e);
                            )
        state = service.addIndexTemplateV2(state, true, "low-priority-template", lowPriorityTemplate);
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),
        ComposableIndexTemplate it = new ComposableIndexTemplate(
        e = expectThrows(IllegalArgumentException.class, () -> {
        );
        );
            ct,
                e.getMessage(),
    public void testAddInvalidTemplate() throws Exception {
            null,
        List<Throwable> errors = putTemplateDetail(request);
                "logs-template",
            getInstanceFromNode(ThreadPool.class).getThreadContext().putTransient(ACTION_ORIGIN_TRANSIENT_NAME, TEMPLATE_LOADER_IDENTIFIER);
    public void testIndexTemplateWithValidateMapping() throws Exception {
                    "index template [foo2] has index patterns [abc, baz*] matching patterns from existing "
            true,
        }).collect(Collectors.toList());
        aliases.add(new Alias("invalid_alias").filter("abcde"));
            0L,
                new CompressedXContent(
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    @Override
        assertThat(
        when(clusterService.getSettings()).thenReturn(settings);
        assertNotNull(state.metadata().templatesV2().get("bar"));
                        + "  }"
            ComposableIndexTemplate invalidGlobalTemplate = new ComposableIndexTemplate(
        ClusterState state = ClusterState.EMPTY_STATE;
        state = service.addComponentTemplate(state, true, "c2", ct2);
            template,
            Arrays.asList("i*"),
            null,
                    expectedMappings = (Map<String, Object>) expectedMappings.get(MapperService.SINGLE_MAPPING_NAME);
            null
        ComposableIndexTemplate actualNoTemplate = new ComposableIndexTemplate(
        assertThat(errors.get(0), instanceOf(MapperParsingException.class));
                Collections.singletonList("logs-*-*"),
            indexTemplateName,
            null,
            fail("expecting an exception as the matching global template is invalid");
            actual.composedOf(),
            )
        return getInstanceFromNode(MetadataIndexTemplateService.class);
        );
        // These should be order of precedence, so the context(a4), index template (a3), then ct_high (a1), then ct_low (a2)
            Collections.singletonList("i*"),
        // Test remove the low priority template
            }
            MapperParsingException.class,
            "Invalid exception message." + ex.getMessage(),
        Set<Alias> aliases = new HashSet<>();
        Template templateWithHiddenSetting = new Template(builder().put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build(), null, null);
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo2", componentTemplate3)
            public void onResponse(MetadataIndexTemplateService.PutResponse response) {
        );
        final List<Throwable> throwables = new ArrayList<>();
        assertThat(errors.get(0), instanceOf(MapperParsingException.class));
            .build();
                )
                "timeseries-template",
                IllegalArgumentException.class,
                        + "              \"type\": \"integer\"\n"
            null
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
            @Override
                .map(IndexTemplateMetadata::name)
            ComposableIndexTemplate it = new ComposableIndexTemplate(
        assertNotNull(state.metadata().templatesV2().get("v2-template"));
        state = service.addIndexTemplateV2(state, true, "my-template", it);
            )
                        + "  }"
    public void testIndexPrimaryShardsSetting() {
        request.settings(settingsBuilder.build());
    }
    public void testPutGlobalV2TemplateWhichResolvesIndexHiddenSetting() throws Exception {
            null,
            }
        MetadataIndexTemplateService service = getMetadataIndexTemplateService();
        );
                logger.error(e);
import org.opensearch.common.xcontent.XContentFactory;
            e.getCause().getCause().getMessage(),
import java.util.concurrent.atomic.AtomicReference;
            Arrays.asList("foo-bar-*", "eggplant"),
                    fail("failed to parse mappings: " + m.string());
                .stream()
            List.of(componentTemplateName),
                ),
    public void testPutExistingComposableTemplateIsNoop() throws Exception {
            1L,
                        + "          \"type\": \"object\",\n"
                "c*",
        ClusterState state = ClusterState.EMPTY_STATE;
        );
        // We should be able to replace the "logs" template, because we have the "logs-mysql" template that can handle the data stream
        ComponentTemplate ct1 = new ComponentTemplate(
                    "_doc",
            getInstanceFromNode(ThreadPool.class).getThreadContext().putTransient(ACTION_ORIGIN_TRANSIENT_NAME, TEMPLATE_LOADER_IDENTIFIER);
                        + "      }\n"
        Template template = new Template(Settings.builder().build(), null, ComponentTemplateTests.randomAliases());
                ) {
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);
                            "the listener should not be invoked as the validation should be executed before any cluster state updates "
        );
                "testing",
            createTestShardLimitService(randomIntBetween(1, 1000), false),
            containsInAnyOrder("bar", "global")
        final ClusterState finalState = state;
        assertThat(
        state = service.addIndexTemplateV2(state, true, "my-template", it);
            );
                "composable template [logs] with index patterns [logs-*-*], priority [100] and no data stream "
                null,
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            actual.version(),
                true,
                        + "        \"type\": \"keyword\"\n"
        assertThat(
        ComponentTemplate componentTemplate4 = new ComponentTemplate(template, 1L, new HashMap<>());
                }
            null,
            }
        PutRequest request = new PutRequest("api", "broken_mapping");
        assertThat(e.getCause().getMessage(), containsString("invalid composite mappings for [my-template]"));
            );
        state = service.addComponentTemplate(state, true, "ct_high", ct1);
     */
            contains("foo-2", "foo-1")
        );
 *
                new CompressedXContent(
                DataStream.getDefaultBackingIndexName("logs", 1L)
    }
            null,
        Settings clusterSettings = Settings.builder()
    public void testResolveSettingsWithContextVersion() throws Exception {
import java.util.List;
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())
                null,
                fail("expecting the component template PUT to succeed but got: " + e.getMessage());
    }
            // user defines a @timestamp mapping as part of a composable index template
        assertNotNull(mappings);
                "_doc",
            ActionListener.wrap(r -> ctLatch.countDown(), e -> fail("unexpected error"))
        try {
        template = new Template(
        if (randomBoolean()) {
            () -> metadataIndexTemplateService.addComponentTemplate(throwState, true, "foo2", componentTemplate4)
            );
    public void testAsyncTranslogDurabilityBlocked() {
            .metadata(
        putTemplateDetail(new PutRequest("test", "bar").patterns(singletonList("bar-*")).order(between(0, 100)));
                        + "      }\n"
            null
                new ComposableIndexTemplate.DataStreamTemplate()
                        + "    }\n"
                    )
import org.opensearch.env.Environment;
    private static List<Throwable> putTemplate(NamedXContentRegistry xContentRegistry, PutRequest request) {
                0L,
            null,
        template = new Template(
        );
    public void testPuttingV2TemplateGeneratesWarning() throws Exception {
        assertThat(actualNoTemplate, equalTo(expectedNoTemplate));
            DefaultRemoteStoreSettings.INSTANCE,
                            new DataStream.TimestampField("@timestamp"),
            10L,
        state = service.addIndexTemplateV2(state, randomBoolean(), "my-template", it);
                0L,
                null
                        + "      }\n"
                .map(IndexTemplateMetadata::name)
        assertThat(
        List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(state, "my-template", "my-index");
                List.of(),
                List.of("ct1"),
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
        );
            pr.aliases(Collections.singleton(new Alias("alias")));
        state = service.addComponentTemplate(state, true, "ct1", ct1);
        assertThat(errors.get(0), instanceOf(IllegalArgumentException.class));
    /**
            IndexTemplateMissingException.class,
        );
            xContentRegistry,
                .map(IndexTemplateMetadata::name)
                    .put(
        Settings clusterSettings = Settings.builder()
                .endObject()
            service.addIndexTemplateV2(stateWithDS, false, "logs", newTemplate);
            pr.settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build());
 */
        ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "v2-template", v2Template);
                            + "  }"
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        {
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
        );
            IllegalArgumentException.class,
                    ),
        Function<String, Template> templateApplier = codec -> new Template(
        assertThat(state.metadata().templates().get("v1-template").patterns(), containsInAnyOrder("*", "baz"));
            metadataIndexTemplateService.putComponentTemplate(
            "test",
    public void testResolveSettingsWithContextLatest() throws Exception {
            ComposableIndexTemplate newTemplate = new ComposableIndexTemplate(
            MetadataIndexTemplateService.patternsActuallyOverlap(
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(state, "timeseries-template", "timeseries");
        );
            public void onResponse(AcknowledgedResponse response) {
                template,
        assertTrue("Could not create component templates", waitToCreateComponentTemplate.await(10, TimeUnit.SECONDS));
            assertNotNull(mappings);
        assertNotNull(e.getCause().getCause());
            Collections.singletonList("ct"),
        putTemplateDetail(new PutRequest("testFindTemplatesWithHiddenIndices", "foo-2").patterns(singletonList("foo-*")).order(2));
        assertThat(errors.get(0), instanceOf(IllegalArgumentException.class));
                    Collections.singletonMap("properties", Collections.singletonMap("field2", Collections.singletonMap("type", "text")))
                    )
        assertThat(errors.size(), equalTo(1));
                null,
            () -> metadataIndexTemplateService.putIndexTemplateV2(
                            new DataStream.TimestampField("@timestamp"),
        ComposableIndexTemplate template = ComposableIndexTemplateTests.randomInstance();
    }
            "testing",
            () -> service.addIndexTemplateV2(finalState, randomBoolean(), "my-template", it)
        ClusterState state = ClusterState.EMPTY_STATE;
        assertNotNull(state.metadata().templatesV2().get("foo"));
            null
        };
        state = service.addIndexTemplateV2(state, true, "my-template", it);
            null
                    actualMappings = parser.map();
            Arrays.asList("foo-bar-*", "eggplant"),
        );
        PutRequest request = new PutRequest("test", "test_shards");
                    public void onResponse(AcknowledgedResponse response) {
                "updating component template [c2] results in invalid " + "composable template [my-template] after templates are merged"
                ),
        state = service.addIndexTemplateV2(state, true, "my-template", it);
                            LoggingDeprecationHandler.INSTANCE,
                TimeValue.timeValueSeconds(30L),
        state = MetadataIndexTemplateService.innerPutTemplate(state, pr, new IndexTemplateMetadata.Builder("id"));
            IllegalArgumentException e = expectThrows(
            randomBoolean(),
                        + "          \"type\": \"keyword\"\n"
            Collections.singletonList("a"),
                        + "        \"field2\": {\n"
        assertTemplatesEqual(state.metadata().templatesV2().get("v2-template"), v2Template);
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)
            .put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "3");
import java.io.IOException;
        // Test replacing it with a version without the data stream config
        List<Map<String, AliasMetadata>> resolvedAliases = MetadataIndexTemplateService.resolveAliases(state.metadata(), "my-template");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        assertNull(MetadataIndexTemplateService.findV2Template(state.metadata(), "index", true));
 * compatible open source license.
                .stream()
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")
            Objects.nonNull(actualTemplate),
            null
                InvalidIndexTemplateException.class,
                ),
            equalTo(
        );
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
            );
        );
        IllegalArgumentException e = expectThrows(
                5L,
                null,
        state = service.addComponentTemplate(state, true, "ct", ct);
        );
                                    .build()
        List<Throwable> throwables = putTemplateDetail(request);
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", null)
        List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
    /**
                new ActionListener<AcknowledgedResponse>() {
            service.addIndexTemplateV2(stateWithDS, false, "logs2", nonDSTemplate);
                    "{\n"
            }
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
            containsInAnyOrder("foo-2", "foo-1", "global")
                )
                new CompressedXContent(
            List.of(),
                )
                "template-referencing-ct-with-hidden-index-setting",
                globalIndexTemplate,
            assertThat(e.getMessage(), containsStringIgnoringCase("globalindextemplate1"));
                null
    }
        assertThat(errors.size(), equalTo(1));
            null,
                        + "        \"field2\": {\n"
        ClusterState state = ClusterState.EMPTY_STATE;
        // Identical patterns overlap with themselves
                }
                    "{\n"
            assertNotNull(mappings);
                            + "      }\n"
            meta,
                    "{\n"
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
            Map<String, Object> secondMapping = Map.of("_doc", Map.of("properties", Map.of("field2", Map.of("type", "integer"))));
        PutRequest request = new PutRequest("api", "blank_mapping");
                            .settings(
            e.getCause().getCause().getMessage(),
        assertNull(MetadataIndexTemplateService.findV2Template(state.metadata(), "index", randomBoolean()));
        List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(state, "my-template", "my-index");
                        fail(
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                .stream()
        );
        ComposableIndexTemplate templateToRemove = new ComposableIndexTemplate(
import org.opensearch.index.mapper.MapperParsingException;
            false,
            )
        ClusterState state = ClusterState.EMPTY_STATE;
                            fail("the listener should not be invoked as validation should fail");
                try {
        Map<String, AliasMetadata> a3 = new HashMap<>();
    }
                templateWithHiddenSetting,
                        + "    }"
            .build();
        });
                e.getMessage(),
                new Template(
        return putTemplate(xContentRegistry, request, Settings.EMPTY);
                    )
                                    .build()
        ComponentTemplate systemTemplate = new ComponentTemplate(
            null,
            // if the index name matches that of a data stream backing index
        assertThat(errors.get(0).getMessage(), containsString("Failed to parse mapping "));
            );
                        + "      \"properties\": {\n"
                    "template-referencing-context-as-ct",
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),
            null,
                )
        assertThat(settings.get("index.number_of_replicas"), equalTo("2"));
            clusterService,
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        + "        }\n"
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
    }
        assertThat(MetadataIndexTemplateService.innerPutTemplate(state, pr, new IndexTemplateMetadata.Builder("id")), equalTo(state));
        ComposableIndexTemplate it = new ComposableIndexTemplate(
        );
        Context context = new Context(systemTemplateMetadata.name(), Long.toString(2L), Map.of());
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
                            .settings(
    public void testUserDefinedMappingTakesPrecedenceOverDefault() throws Exception {
            parsedMappings.get(1),
            "legacy template [v1-template] has index patterns [*, baz] matching patterns from existing "
                    }
    private MetadataIndexTemplateService getMetadataIndexTemplateService() {
            "test",
                null,
            20L,
    }
        assertTrue(MetadataIndexTemplateService.patternsActuallyOverlap(Arrays.asList("logs-*"), Arrays.asList("logs-prod-*")));
            ComponentTemplateTests.randomAliases()
            null,
        MetadataIndexTemplateService service = getMetadataIndexTemplateService();
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(1);
        assertThat(result, equalTo("my-template"));
            e.getMessage(),
        ComposableIndexTemplate it = new ComposableIndexTemplate(
                    }
                            + "  }"
            .build();
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
            null,
                    @Override
            List.of("foo"),
            InvalidIndexTemplateException ex = expectThrows(
            );
                null,
            )
            "index template [v2-template] has index patterns [foo-bar-*, eggplant] matching patterns "
            null
                true,
                    latch.countDown();
                ActionListener.wrap(r -> fail("should have failed!"), exception -> {
            () -> metadataIndexTemplateService.addIndexTemplateV2(throwState, true, "foo", newTemplate)
                systemTemplate,
        verifyTemplateCreationUsingContext("_latest");
        assertThat(
            null,
        assertEquals(
        updatedState = MetadataIndexTemplateService.innerRemoveIndexTemplateV2(clusterState, "foo");
                "template-referencing-context-as-ct",
            createIndexService,
import org.opensearch.cluster.service.ClusterService;
        assertThat(settings.get("index.codec"), equalTo(CodecService.BEST_COMPRESSION_CODEC));
                try (
        );
     */
    }
 * not use this file except in compliance with the License.
                "timeseries-template",
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", randomBoolean())
            null,
                    return MapperService.parseMapping(new NamedXContentRegistry(List.of()), m.string());
                            Collections.singletonList(new Index(".ds-logs-mysql-000001", "uuid"))
                    new CompressedXContent(
                "testing",
                        + "      }\n"
import org.opensearch.indices.IndexTemplateMissingException;
                .map(IndexTemplateMetadata::name)
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * Test that if we have a pre-existing v1 and v2 template, and we update the existing v1
            List.of(systemTemplateMetadata.fullyQualifiedName()),
            randomBoolean() ? null : randomNonNegativeLong(),
        state = metadataIndexTemplateService.addIndexTemplateV2(state, randomBoolean(), "bar", newTemplate);
                state,
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(1);
                List.of("logs*"),
import org.opensearch.core.xcontent.NamedXContentRegistry;
        );
        request.settings(settingsBuilder.build());
            Arrays.asList("good", "bad"),
        );
            assertThat(e.getMessage(), containsStringIgnoringCase("globalindextemplate2"));
            ClusterState state = metadataIndexTemplateService.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "foo", template);
            errLatch.await(5, TimeUnit.SECONDS);
            );
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        }
        ComposableIndexTemplate t1 = new ComposableIndexTemplate(Arrays.asList("app-test-*-some-*"), null, null, 0L, null, null, null);
        assertThat(throwables.get(0).getMessage(), containsString("[3]: cannot be greater than number of shard copies [2]"));
        return throwables;
                new CompressedXContent(
        // test remove a template which is not used by a data stream but index patterns can match
                .putCustom(
                        }
            );
        NamedXContentRegistry xContentRegistry,
                    .put(
    public void testLegacyNoopUpdate() {
                            Collections.singletonList(new Index(".ds-foo-000001", "uuid2"))
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        CountDownLatch waitToCreateComponentTemplate = new CountDownLatch(1);
        SystemTemplateMetadata systemTemplateMetadata = SystemTemplateMetadata.fromComponentTemplateInfo("sys-template", 1L);
            globalIndexTemplate,
    /**
        );
        ComponentTemplate sysTemplate = new ComponentTemplate(
            null,
                + "composable templates [v2-template] with patterns (v2-template => [foo-bar-*, eggplant]); this template [v1-template] may "
                        + "      \"properties\": {\n"
        ComposableIndexTemplate mysqlTemplate = new ComposableIndexTemplate(
            () -> metadataIndexTemplateService.putIndexTemplateV2(
        );
        );
        ctLatch.await(5, TimeUnit.SECONDS);
        );
        // Patterns where one is a superset of the other (logs-* matches any logs-prod-* index name)
            equalTo(
            globalIndexTemplate
            Collections.singletonList("i*"),
    /**
            null,
                        + "    }"
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
            IllegalArgumentException.class,
     * Test that if we have a pre-existing v2 template and put a v1 template that would match the same indices, we generate a warning
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        InvalidIndexTemplateException ex = expectThrows(
    public void testResolveAliases() throws Exception {
            }
            null
            TimeValue.timeValueSeconds(30L),
    /**
                        new DataStream(
        assertThat(
            actual.getDataStreamTemplate()
            assertThat(actualTemplate.aliases(), equalTo(expectedTemplate.aliases()));
            null,
            @Override
        );
            null,
                new Context("any")
            Arrays.asList("foo-bar-*", "eggplant"),
import java.util.Arrays;
            1L,
    }
    }
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
                }
                        + "          \"type\": \"text\"\n"
                "template-referencing-context-as-ct",
            null,
            IllegalArgumentException.class,
                Metadata.builder(state.metadata())
                assertThat(actualMappings, equalTo(expectedMappings));
            );
                    fail("failed to parse mappings: " + m.string());
                    null,
        assertThat(errors.get(0).getMessage(), containsString("analyzer [custom_1] has not been configured in mappings"));
        ComponentTemplate ct = new ComponentTemplate(new Template(null, new CompressedXContent("{}"), null), null, null);
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
            assertThat(mappings.size(), equalTo(2));
    }
            @Override
        ClusterState updatedState = MetadataIndexTemplateService.innerRemoveIndexTemplateV2(state, "foo");
            context
                }
                )
                    }
            public void onResponse(MetadataIndexTemplateService.PutResponse response) {
                Collections.singletonList("logs-postgres-*"),
 *
            null,
            null,
                        new DataStream(
            secondMapping = Map.of("_doc", Map.of("properties", Map.of("field2", Map.of("type", "integer"))));
    }
            );
        String result = MetadataIndexTemplateService.findV2Template(state.metadata(), "index", true);
            null,
            )
            .metadata(
        );
        state = service.addComponentTemplate(state, true, "ct_low", ct2);
                        + "          \"type\": \"keyword\"\n"
        SystemTemplateMetadata systemTemplateMetadata = fromComponentTemplateInfo("ct-best-compression-codec" + System.nanoTime(), 1);
                null,
            "Setting [index.routing.allocation.total_primary_shards_per_node] or [index.routing.allocation.total_remote_capable_primary_shards_per_node] can only be used with remote store enabled clusters",
import org.opensearch.common.unit.TimeValue;
                new CompressedXContent(
                        "{\n"
                ActionListener.wrap(() -> {})
        ComponentTemplate ct2 = new ComponentTemplate(
            new Template(settings, mappings, null),
        assertThat(throwables.get(0), instanceOf(IllegalArgumentException.class));
            null,
        assertThat(
        Settings settings = MetadataIndexTemplateService.resolveSettings(clusterService.state().metadata(), indexTemplateName);
        patterns.add("new-pattern");
                            + "      \"field2\": {\n"
            3L,
            );
            null,
            .build();
        request.settings(settingsBuilder.build());
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "bar-xyz", false)
        try {
                    public void onFailure(Exception e) {
        );
                        + "        }\n"
            parsedMappings = mappings.stream().map(m -> {
                    XContentParser parser = MediaTypeRegistry.JSON.xContent()
            null,
            List.of("foo"),
            )
            new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
    }
        state = service.addComponentTemplate(state, true, "ct_high", ct1);
        state = service.addIndexTemplateV2(state, true, "my-template2", it2);
            null,
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo", template);
                "_doc",
            containsInAnyOrder("bar", "global")
                ActionListener.wrap(r -> fail("should have failed!"), exception -> {
                Map<String, Object> actualMappings;
                () -> metadataIndexTemplateService.addIndexTemplateV2(state, false, "foo2", newTemplate)
    }
            latch.await(5, TimeUnit.SECONDS);
            );
        });
            )
            IllegalArgumentException e = expectThrows(
        );
            template,
            )
            new Template(Settings.builder().put("index.number_of_replicas", 1).put("index.blocks.read", true).build(), null, null),
                ),
                        fail("the listener should not be invoked as validation should fail");
            null,
                        + "match during index creation, please use a different priority"
        Metadata metadata = Metadata.builder().build();
        );
     */
        // Change the pattern to one that doesn't match the data stream
        List<Throwable> throwables = putTemplate(xContentRegistry(), request, clusterSettings);
            )
            AtomicReference<Exception> err = new AtomicReference<>();
        PutRequest pr = new PutRequest("api", "id");
            null
                + "be ignored in favor of a composable template at index creation time"
            );
        ComponentTemplate ct2 = new ComponentTemplate(
        assertThat(errors.get(0).getMessage(), equalTo("failed to parse filter for alias [invalid_alias]"));
                new Template(
                systemTemplate,
        service.putTemplate(request, new MetadataIndexTemplateService.PutListener() {
        );
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.matchesRegex;
                null
            );
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", false)
        }
        assertThat(
            null,
        IllegalArgumentException e = expectThrows(
                        + "        }\n"
                        .createParser(
                            new DataStream.TimestampField("@timestamp"),
                "composable template [logs2] with index patterns [logs-my*-*], priority [105] and no data stream "
                            fail("the listener should not be invoked as validation should fail");
            List.of("*"),
                .map(IndexTemplateMetadata::name)
        if (randomBoolean()) {
            .build();
        ComposableIndexTemplate firstGlobalIndexTemplate = new ComposableIndexTemplate(
        );
        }
                null
                        + "      \"properties\": {\n"
    }
            createComponentTemplateListener
            null
                    "{\n"
            null
            assertThat(
        );
            Template template = new Template(
    }
            Map<String, Object> firstMapping = Map.of(
                globalIndexTemplate,
            );
                null
                            Collections.singletonList(new Index(".ds-unreferenced-000001", "uuid2"))
        MetadataIndexTemplateService.innerPutTemplate(finalState, req, IndexTemplateMetadata.builder("v1-template"));
            () -> metadataIndexTemplateService.putIndexTemplateV2(
            null
        );
                .map(IndexTemplateMetadata::name)
                            new NamedXContentRegistry(Collections.emptyList()),
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
 * SPDX-License-Identifier: Apache-2.0
                Metadata.builder(state.metadata())
        {
        assertThat(
        assertThat(throwables.get(0), instanceOf(InvalidIndexTemplateException.class));
                                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")
        metadataIndexTemplateService.putComponentTemplate(
        assertWarnings(
                ),
        List<Throwable> throwables = putTemplate(xContentRegistry(), request);
        ThreadContext context = getInstanceFromNode(ThreadPool.class).getThreadContext();
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();
                () -> metadataIndexTemplateService.putIndexTemplateV2(
                .collect(Collectors.toList()),
            metadataIndexTemplateService.putComponentTemplate(
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
        PutRequest request = new PutRequest("test", "test_specified_replicas");
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())
        try (ThreadContext.StoredContext ignore = context.stashContext()) {
    public void testPutGlobalV2TemplateWhichProvidesContextNotPresentInState() throws Exception {
        assertThat(e.getMessage(), containsString("component template [foo] already exists"));
                        + "      \"properties\": {\n"
    public void testRemoveIndexTemplateV2() throws Exception {
        ComponentTemplate ct1 = new ComponentTemplate(
            null
        {
                null,
        assertThat(
        assertThat(MetadataIndexTemplateService.findV1Templates(state.metadata(), "baz", true), empty());
            Collections.singletonList("ct"),
            1L,
            assertNotNull(mappings);
    }
        assertThat(result, equalTo("my-template2"));
                null
        // - ct_high
            assertThat(
            context
            null,
                    return null;
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                "_doc",
        );
            ActionListener.wrap(r -> ctLatch.countDown(), e -> {
        assertTrue(
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
                null,
            InvalidIndexTemplateException.class,
                Collections.singletonMap(
                throw err.get();
            e.getMessage(),
        ClusterState state = ClusterState.EMPTY_STATE;
        );
        MetadataIndexTemplateService.PutRequest req = new MetadataIndexTemplateService.PutRequest("cause", "v1-template");
        req.patterns(Arrays.asList("fo*", "baz"));
            null,
        {
        assertNotNull(state.metadata().templatesV2().get("v2-template"));
        request.patterns(Arrays.asList("foo", "foobar"));
            metadataIndexTemplateService.putComponentTemplate(
import static org.hamcrest.Matchers.empty;
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString());
        ComponentTemplate ct2 = new ComponentTemplate(
        putTemplateDetail(new PutRequest("testFindTemplatesWithHiddenIndices", "foo-1").patterns(singletonList("foo-*")).order(1));
                    errLatch.countDown();
        assertThat(
import java.util.Map;
        }
 * software distributed under the License is distributed on an
        assertNotNull(state.metadata().templatesV2().get("app-test-some"));
                        + "        \"field1\": {\n"
        Template templateWithIndexHiddenSetting = new Template(
                ),
                        + "          \"type\": \"text\"\n"
        state = service.addIndexTemplateV2(state, true, "my-template", it);
            assertThat(parsedMappings.get(0), equalTo(firstMapping));
        );
            ),
            List<Map<String, Object>> parsedMappings = mappings.stream().map(m -> {
            Map.of(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY, SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE, "_version", 1L)
            null
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            MetadataIndexTemplateService.findV1Templates(state.metadata(), "foo-1234", true)
        }
        service.putIndexTemplateV2(
                    )
        Map<String, AliasMetadata> a4 = Map.of("sys", AliasMetadata.builder("sys").build());
                null
        assertNotNull(state.metadata().componentTemplates().get("foo"));
                            .settings(
                null,
    protected Settings featureFlagSettings() {
import static org.opensearch.env.Environment.PATH_HOME_SETTING;
import org.opensearch.indices.InvalidIndexTemplateException;
                + "this template [v1-template] may be ignored in favor of a composable template at index creation time"
        verifyTemplateCreationUsingContext("1");
            null,
            );
                List.of("*"),
            new Template(
            templateApplier.apply(CodecService.LZ4),
                        + "        \"field1\": {\n"
            null,
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())
                null
                .collect(Collectors.toList()),
        );
        Settings incomingNodeScopedSettings
            }
        Settings.Builder settingsBuilder = builder().put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "2");
        assertThat(
        assertNotNull(clusterState.metadata().templatesV2().get("foo"));
                .stream()
        ComponentTemplate ct2 = new ComponentTemplate(
                fail("failed to parse mappings: " + m.string());
            null,
        putTemplateDetail(
            );
            templateApplier.apply(CodecService.BEST_COMPRESSION_CODEC),
                        + "        }\n"
                ),
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                .stream()
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        final ClusterState throwState = ClusterState.builder(state).build();
            Settings.builder().put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codec).build(),
                    .build()
            null,
        };
        );
                null,
    }
            templateApplier.apply(CodecService.LZ4),
                template,
                    .put(
                }
import static java.util.Collections.singletonList;
    private static List<Throwable> putTemplate(
                        @Override
        MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        final MetadataIndexTemplateService service = getMetadataIndexTemplateService();
        Map<String, AliasMetadata> a2 = new HashMap<>();
        );
                "Invalid exception message." + ex.getMessage(),
            templateApplier.apply(CodecService.LZ4),
        );
        putTemplateDetail(new PutRequest("testFindTemplatesWithHiddenIndices", "global").patterns(singletonList("*")));
                105L,
        state = service.addComponentTemplate(state, true, systemTemplateMetadata.fullyQualifiedName(), sysTemplate);
        ComposableIndexTemplate it = new ComposableIndexTemplate(
            )
            )
        ComposableIndexTemplate globalIndexTemplate = new ComposableIndexTemplate(
            null,
                .collect(Collectors.toList()),
            InvalidIndexTemplateException.class,
                "composable template [logs] with index patterns [logs-postgres-*], priority [100] would "
                null,
     */
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date")))
        Set<String> highPriorityDataStreams = MetadataIndexTemplateService.dataStreamsUsingTemplate(state, "high-priority-template");
import java.util.Objects;
        ComponentTemplate ct1 = new ComponentTemplate(new Template(null, null, a1), null, null);
    public void testIndexTemplateValidationErrorsWithSpecifiedReplicas() throws Exception {
            ComposableIndexTemplate newTemplate = new ComposableIndexTemplate(
                        + "    }\n"
                        @Override
        assertThat(
                })
        state = service.addComponentTemplate(state, true, "ct_low", ct2);
            Collections.singletonList("ct"),
                    Collections.singletonMap("properties", Collections.singletonMap("field1", Collections.singletonMap("type", "keyword")))
        );
                try {
                    @Override
                    return null;
            List<CompressedXContent> mappings = MetadataIndexTemplateService.collectMappings(
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(
                .stream()
                        + "        \"field2\": {\n"
    public void testRemoveIndexTemplateV2ForDataStream() throws Exception {
                        + "        \"field1\": {\n"
        CountDownLatch ctLatch = new CountDownLatch(1);
 * Modifications Copyright OpenSearch Contributors. See
                true,
                null,
 */
                    }
        );
            null,
            assertThat(parsedMappings.get(1), equalTo(secondMapping));
                equalTo(
        IllegalArgumentException e = expectThrows(
            );
                new CompressedXContent(
            containsString(
import org.opensearch.indices.IndicesService;
                .build();
        // hidden
        assertThat(lowPriorityDataStreams, empty());
import static org.opensearch.common.settings.Settings.builder;
                        + "      \"properties\": {\n"
            null,
     * template without changing its index patterns, a warning is generated
                Map.of("properties", Map.of(TIMESTAMP_FIELD.getName(), Map.of("type", "date")))
        assertEquals(throwables.size(), 1);
                        IndexMetadata.builder(".ds-unreferenced-000001")
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        );
            new CompressedXContent("{\"invalid\":\"invalid\"}"),
                null
                "api",
        );
                    "{\n"
import org.opensearch.indices.DefaultRemoteStoreSettings;
                waitToCreateComponentTemplate.countDown();
                null
        assertThat(
        final MetadataIndexTemplateService metadataIndexTemplateService = getMetadataIndexTemplateService();
        );
