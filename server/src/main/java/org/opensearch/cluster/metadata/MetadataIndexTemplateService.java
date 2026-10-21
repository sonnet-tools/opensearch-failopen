    private void validate(PutRequest putRequest) {
            );
            }
    }
                    validateCompositeTemplate(
            .stream()
            int shardReplicas = settings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
                .map(ComposableIndexTemplate.DataStreamTemplate::getDataStreamMappingSnippet)
            .filter(componentTemplate -> componentTemplates.containsKey(componentTemplate) == false)
        final boolean create,
     * hidden indices, a template with a match all pattern or global template will not be returned.
     *                 not be returned
    /**
            }
            && IndexMetadata.INDEX_HIDDEN_SETTING.exists(resolveSettings(metadata, winnerName))) {
        Set<String> templateNames = new HashSet<>();
        }
            ClusterState tempStateWithComponentTemplateAdded = ClusterState.builder(currentState)
        // Add the actual index template's settings now, since it takes the next precedence.
     * Add the given component template to the cluster state. If {@code create} is true, an
                    + " from existing composable templates [%s] with patterns (%s); this template [%s] may be ignored in favor"
                Strings.collectionToCommaDelimitedString(overlaps.keySet()),
            } catch (Exception e) {
                } else {
        private final boolean acknowledged;
            dataStreams.stream().filter(stream -> Regex.simpleMatch(indexPattern, stream)).filter(stream -> {
        }
import org.opensearch.common.UUIDs;
        }
import org.opensearch.core.common.bytes.BytesReference;
        }
            .map(componentTemplates::get)
            @Override
            .map(coll -> coll.get(searchSpecificVersion ? Long.parseLong(context.version()) : coll.lastKey()))
import org.opensearch.common.unit.TimeValue;
     */
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                template.indexPatterns(),
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            if (IndexMetadata.INDEX_HIDDEN_SETTING.exists(mergedSettings)) {
            return this;
import java.util.Locale;
        }
        final String name,
 * The OpenSearch Contributors require contributions made to
            try {
import java.util.HashSet;
            }
            name,
    /**
                Set<String> templateNames = new HashSet<>();
            if (isHidden == null || isHidden == Boolean.FALSE) {
        });
                "composable template ["
            if (clusterPluggableDataFormatEnabled
        final List<Map<String, AliasMetadata>> resolvedAliases = new ArrayList<>();
        // dummy index resolves a format and the capability path can reject index:true. When no name is
            .filter(name -> Regex.simpleMatch(templateNameOrWildcard, name))
    }
     * exception will be thrown if the component template already exists
                currentState,
    ) {
        final ClusterState currentState,
                listener.onFailure(e);
        a.indexRouting(aliasMeta.indexRouting());
import org.opensearch.index.mapper.MapperService;
    private final MetadataCreateIndexService metadataCreateIndexService;
                throw new MapperParsingException("Failed to parse mapping: {}", e, request.mappings);
            Optional.ofNullable(template.getDataStreamTemplate())
        clusterService.submitStateUpdateTask(
        }
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex;
            );
        }
                        indexPatterns,
        for (Map.Entry<String, ComposableIndexTemplate> entry : metadata.templatesV2().entrySet()) {
                public void onFailure(String source, Exception e) {
            if (indexPattern.startsWith("_")) {
            // use the provided values, otherwise just pick valid dummy values
                }
            validationErrors.add("name must be lower cased");
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_INDEX_TEMPLATE_V2;
            } else {
            );
    public static List<CompressedXContent> collectMappings(final ClusterState state, final String templateName, final String indexName)
            // if its a match all pattern, and no templates are found (we have none), don't
            .build();
            + "] that did not exist in the cluster state";
import org.opensearch.cluster.ClusterStateUpdateTask;
            indexPatterns,
    /**
                        .field(MapperService.SINGLE_MAPPING_NAME, parsedMappings)
    static void validateNotInUse(Metadata metadata, String templateNameOrWildcard) {
        // has been updated
                return innerRemoveIndexTemplateV2(currentState, name);
    @Inject
            this.name = name;
                for (Map.Entry<String, ComposableIndexTemplate> entry : templatesUsingComponent.entrySet()) {
        }
                .orElse(Collections.emptyMap())
import java.util.stream.Collectors;
            throw new IllegalArgumentException(error);
/*
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            for (Map.Entry<String, ComposableIndexTemplate> entry : templatesUsingComponent.entrySet()) {
    }
import org.opensearch.common.util.set.Sets;
        List<Settings> componentSettings = template.composedOf()
                    // if its a match all pattern, and no templates are found (we have none), don't
                request.name,
     * @param clusterSettings current cluster settings
        }
        String name,
                    "alias [" + alias.name() + "] cannot be the same as any pattern in [" + String.join(", ", indexPatterns) + "]"
            }
        if (template.getDataStreamTemplate() != null && indexName.startsWith(DataStream.BACKING_INDEX_PREFIX)) {
                for (final Map.Entry<String, AliasMetadata> cursor : template.aliases().entrySet()) {
        Settings.Builder updatedSettingsBuilder = Settings.builder();
     * no unreferenced data streams. Note that this scenario is still possible
                if (templateWithHiddenSettingPostRemoval.isPresent() == false
                Collections.emptySet(),
    ) {
            throw new IllegalArgumentException("index template [" + name + "] already exists");
    private void validate(String name, @Nullable Settings settings, List<String> indexPatterns, List<Alias> aliases) {
        final Set<String> matchingComponentTemplates = metadata.componentTemplates()
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            }
            int dummyShards = settings.getAsInt(
        boolean isUpdate = currentState.metadata().templates().containsKey(request.name);
            + " }";
import org.opensearch.common.logging.HeaderWarning;
            if (settings != null && IndexMetadata.INDEX_HIDDEN_SETTING.exists(settings)) {
                e
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
            .build();
            }
                return request.clusterManagerTimeout;
        overlappingTemplates.remove(candidateName);
                assert isHidden == Boolean.TRUE;
        if (settings != null) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
     *                 being hidden has not been explicitly requested. When {@code null} if the result
                    name,
        throws Exception {
                }
            );
            final IndexMetadata tmpIndexMetadata = IndexMetadata.builder(temporaryIndexName).settings(dummySettings).build();
     */
     * with the given template's index patterns.
                template.priorityOrZero()
import org.apache.logging.log4j.Logger;
        final ClusterState currentState,
        if (create && existing != null) {
            this.clusterManagerTimeout = clusterManagerTimeout;
        } catch (Exception e) {
                .values()
        // if the candidate was a V2 template that already exists in the cluster state it will "overlap" with itself so remove it from the
     */
        validateV2TemplateRequest(clusterService.state().metadata(), name, template, clusterService.getClusterSettings());
            String error = String.format(
            existing == null ? "adding" : "updating",
import static org.opensearch.cluster.metadata.MetadataCreateDataStreamService.validateTimestampFieldMapping;
                }
                    metadata.removeComponentTemplate(templateName);
        final TimeValue masterTimeout,
        if (name.contains(" ")) {
                            + IndexMetadata.SETTING_INDEX_HIDDEN
        overlaps = findConflictingV1Templates(currentState, name, template.indexPatterns());
    /**
        for (String templateName : templateNames) {
     */
        if (aliasMeta.filter() != null) {
                "legacy template [%s] has index patterns %s matching patterns"
                    // fail with index missing...
        Settings settings = validateSettings;
        return false;
        }
            public ClusterState execute(ClusterState currentState) {
    public static Settings resolveSettings(final List<IndexTemplateMetadata> templates) {
                overlappingTemplates.put(name, template.patterns());
        // Add the template referred by context since it will take the highest precedence.
        if (IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.exists(requestSettings) == false
                    return masterTimeout;
            validationErrors.addAll(indexSettingsValidation);
     * @return a list of templates sorted by {@link IndexTemplateMetadata#order()} descending.
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_COMPONENT_TEMPLATE;
     * Collect the given v2 template into an ordered list of mappings.
import org.opensearch.common.inject.Inject;
        }
     *                 of template application results in a hidden index, then global templates will
                    listener.onResponse(new PutResponse(true));
        final String candidateName,
    private static void validateCompositeTemplate(
        // Find the data streams that would be unreferenced now that the template is updated/added
            && !ClusterStateSystemTemplateLoader.TEMPLATE_LOADER_IDENTIFIER.equals(
        final List<String> missingComponentTemplates = template.composedOf()
        }
            if (Strings.validFileNameExcludingAsterisk(indexPattern) == false) {
                MapperService mapperService = tempIndexService.mapperService();
                public TimeValue timeout() {
            validateCompositeTemplate(
     * This is added at the lowest precedence to allow users to override this mapping.
        if (name.contains("#")) {
        PutRequest request,
        Index createdIndex = null;
                .collect(Collectors.toList())
            }
                        validationFailure = new IllegalArgumentException(
                xContentRegistry,
        clusterService.submitStateUpdateTask("remove-index-template-v2 [" + name + "]", new ClusterStateUpdateTask(Priority.URGENT) {
            IndexService dummyIndexService = indicesService.createIndex(tmpIndexMetadata, Collections.emptyList(), false);
import org.opensearch.core.index.Index;
            finalSettings = Settings.builder().put(finalSettings).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX).build();
                return removeIndexTemplateV2TaskKey;
            .map(coll -> coll.get(context.name()))
            }
        }
        final ComposableIndexTemplate template = state.metadata().templatesV2().get(templateName);
            }
        );
                    overlappingTemplates.put(name, template.indexPatterns());
            List<String> indexSettingsValidation = metadataCreateIndexService.getIndexSettingsValidationErrors(
    public static String findV2Template(Metadata metadata, String indexName, boolean isHidden) {
        Settings validateSettings,
        a.isHidden(aliasMeta.isHidden());
            if (patternsActuallyOverlap(indexPatterns, template.patterns())) {
                template.indexPatterns(),
        request.settings(updatedSettingsBuilder.build());
    ClusterState addComponentTemplate(
        }
                        tempStateWithComponentTemplateAdded,
import org.opensearch.index.mapper.MapperParsingException;
                validationErrors.add(
                throw new IllegalArgumentException(
                resolvedAliases.add(aliasMeta);
            throw new IllegalArgumentException(
        if (settings == null) {
    private final IndicesService indicesService;
        }
    /**
                if (parsedMappings.size() > 0) {
            if (Regex.simpleMatch(p1Array, p2.replace("*", ""))) {
            }
            String indexName = DataStream.BACKING_INDEX_PREFIX + temporaryIndexName;
     * to produce its "minimum matching string". If that minimum string matches any pattern in the other
                    + templateName
            throw new IllegalArgumentException("component template [" + name + "] already exists");
                }
        boolean checkPriority,
                dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), clusterPluggableDataFormatValue);
                temporaryIndexName,
    }
    private final ClusterManagerTaskThrottler.ThrottlingKey removeComponentTemplateTaskKey;
    private final ClusterManagerTaskThrottler.ThrottlingKey createIndexTemplateTaskKey;
                Optional.empty()
                        + new TreeSet<>(set)
                "index template [" + name + "] specifies component templates " + missingComponentTemplates + " that do not exist"
                .put(settings)
        String clusterPluggableDataFormatValue
                        "legacy template {} and composable template {} would overlap: {} <=> {}",
            // add a default mapping for the timestamp field, at the lowest precedence, to make bootstrapping data streams more
    static ClusterState innerRemoveIndexTemplateV2(ClusterState currentState, String name) {
     */
            if (isHidden == false) {
     */
                try {
            public ClusterState execute(ClusterState currentState) {
                throw new IllegalArgumentException(
            // Also carry the cluster's default data format name (mirroring MetadataCreateIndexService) so the
                    }
            + timestampFieldName
        }
                }
            validateTranslogFlushIntervalSettingsForCompositeIndex(settings, clusterService.getClusterSettings());
        }
                logger.debug(
/*
                return true;
     * Remove the given index template from the cluster state. The index template name
            // When a pluggable data format is the cluster-wide default, validate the mapping as a
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        return currentState;
                    + "is invalid",
            );
     * @opensearch.internal
     *
        // a restored index cluster state that modified a component template used by this global template such that it has this setting)
    private static void validateDataStreamsStillReferenced(ClusterState state, String templateName, ComposableIndexTemplate newTemplate) {
            }
            validationErrors.add("name must not contain a ','");
        if (missingComponentTemplates.size() > 0) {
        for (String p2 : patterns2) {
        final Metadata updatedMetadata = Metadata.builder(state.metadata()).put(templateName, newTemplate).build();
                @Override
        }
            String name = cursor.getKey();
            clusterPluggableDataFormatEnabled,
        Settings resolvedSettings = resolveSettings(stateWithTemplate.metadata(), templateName);
    }
     * order since they should be provided in order of priority/order
    }
        public PutRequest aliases(Set<Alias> aliases) {
        this.indexScopedSettings = indexScopedSettings;
    }
        final ClusterState state,
                public TimeValue timeout() {
        template.indexPatterns().forEach(indexPattern -> {
            template.priorityOrZero()
            ValidationException validationException = new ValidationException();
                    );
            }
                    if (template.patterns().stream().anyMatch(patternMatchPredicate)) {
        assert template != null : "attempted to resolve aliases for a template ["
            @Override
        }
                    unreferenced.add(dataStream);
import java.io.IOException;
            indicesService,
                matched = template.indexPatterns().stream().anyMatch(patternMatchPredicate);
 * Modifications Copyright OpenSearch Contributors. See
        // apply templates, here, in reverse order, since first ones are better matching
        if (request.create && isUpdate) {
            }
        }
    static Map<String, List<String>> findConflictingV2Templates(
     * <p>
                validationErrors.add("index_patterns [" + indexPattern + "] must not contain a space");
            .filter(Objects::nonNull)
                .metadata(Metadata.builder(currentState.metadata()).put(name, finalComponentTemplate))
        final boolean isContextAllowed = FeatureFlags.isEnabled(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES);
import org.opensearch.action.admin.indices.alias.Alias;
import org.opensearch.common.util.FeatureFlags;
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
import org.opensearch.core.common.Strings;
                    indexPatterns,
 * Unless required by applicable law or agreed to in writing,
                }
                @Override
            return;
                }
        templateBuilder.patterns(request.indexPatterns);
        for (Map.Entry<String, ComposableIndexTemplate> entry : state.metadata().templatesV2().entrySet()) {
                if (templateNames.isEmpty()) {
            throw new IllegalArgumentException("index_template [" + request.name + "] already exists");
                    // We found a template that still matches, great! Buuuuttt... check whether it
                }
        return Optional.ofNullable(componentTemplate)
                        return currentState;
     * (e.g. {@code app-test-*-some-*} and {@code app-test-*-some_other-*} share the synthetic string
            throw new IllegalArgumentException(
     *
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                stringMappings == null ? null : new CompressedXContent(stringMappings),
        final boolean create,
        logger.info("{} component template [{}]", existing == null ? "adding" : "updating", name);
    }
                    return addIndexTemplateV2(currentState, create, name, template);
        final List<IndexTemplateMetadata> matchedTemplates = new ArrayList<>();
        }
    /**
     * Validates that the given component template is not used by any index
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                overlaps.entrySet().stream().map(e -> e.getKey() + " => " + e.getValue()).collect(Collectors.joining(",")),
                        : "")
        }
 * license agreements. See the NOTICE file distributed with
     * Resolve the given v2 template into a collected {@link Settings} object
                        template.indexPatterns()
            String name = entry.getKey();
                }
                    + " of a composable template at index creation time",
            )) {
    public void removeTemplates(final RemoveRequest request, final RemoveListener listener) {
        List<Map<String, AliasMetadata>> aliases = template.composedOf()
            List<CompressedXContent> mappings = collectMappings(stateWithIndex, templateName, indexName);
 * compatible open source license.
     * @opensearch.internal
        }
        final ComponentTemplate template
            if (patternsActuallyOverlap(indexPatterns, template.indexPatterns())) {
            String warning = String.format(
            stringMappings,
import java.io.UncheckedIOException;
                .map(mapping -> {
                    throw new IndexTemplateMissingException(name);
        Settings finalSettings = template.template().settings();
            this.version = version;
        Optional.ofNullable(template.template()).map(Template::mappings).ifPresent(mappings::add);
        final Predicate<String> patternMatchPredicate = pattern -> Regex.simpleMatch(pattern, indexName);
                }
        if (clusterPluggableDataFormatEnabled && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(resolvedSettings) == false) {
            validateSettings,
        removeComponentTemplateTaskKey = clusterService.registerClusterManagerTask(REMOVE_COMPONENT_TEMPLATE, true);
            .filter(Objects::nonNull)
        logger.info(
            }
        // Validate all composable index templates that use this component template
                if (entry.getValue() != null) {
        // template that contributes to the index template resolved settings
            throw new InvalidIndexTemplateException(
        }
            }
                }
        templates.forEach(template -> {
                                + "] after templates are merged",
        }).map(Map.Entry::getKey).collect(Collectors.toList());
            new ClusterStateUpdateTask(Priority.URGENT) {
            @Override
            if (stringMappings != null) {
                    + templatesStillUsing
                    }
            .filter(Objects::nonNull)
        String[] p1Array = patterns1.toArray(Strings.EMPTY_ARRAY);
    public static boolean isSystemTemplate(ComponentTemplate componentTemplate) {
            // adjusted (to add _doc) and it should be validated
                "global index template ["
                return ClusterState.builder(currentState).metadata(metadata).build();
                    logger.info("removing template [{}]", templateName);
                // templates must be consistent with regards to dependencies
    private final ClusterManagerTaskThrottler.ThrottlingKey removeIndexTemplateV2TaskKey;
import java.util.LinkedList;
                }
                for (final String templateName : currentState.metadata().templates().keySet()) {
            return acknowledged;
            @Override
     * @opensearch.internal
            this.acknowledged = acknowledged;
        }
        NamedXContentRegistry xContentRegistry,
            // validate index total primary shards per node setting against the cluster (a template has no
                    mapperService.merge(MapperService.SINGLE_MAPPING_NAME, mapping, MergeReason.INDEX_TEMPLATE);
        validate(
                        ? "with component templates " + finalIndexTemplate.composedOf() + " "
                templateBuilder.putMapping(MapperService.SINGLE_MAPPING_NAME, request.mappings);
            @Override
                // validate that hidden didn't change
        if (template.context() != null && !isContextAllowed) {
        int order;
                        templateNames.add(templateName);
        for (Alias alias : request.aliases) {
                    }
        }
    /**
                        candidateName,
        // Now use context mappings which take the highest precedence
                "index setting [index.translog.durability=async] is not allowed as cluster setting ["
    private static void validateTemplate(
        final String cause;
                    + "] defined the index.hidden setting, which is not allowed"
        }
        componentSettings.forEach(templateSettings::put);
        // results
        AliasValidator aliasValidator,
        Settings validateSettings,
    }
                indexScopedSettings.validate(settings, true);
        assert template != null : "attempted to resolve settings for a template ["
            public void onFailure(String source, Exception e) {
            .reduce(Sets::union);
import org.opensearch.common.settings.ClusterSettings;
        removeIndexTemplateTaskKey = clusterService.registerClusterManagerTask(REMOVE_INDEX_TEMPLATE, true);
                clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
                @Override
            .map(templateName -> dataStreamsUsingTemplate(currentState, templateName))
                Locale.ROOT,
        templateBuilder.order(request.order);
            // creation anyway (no data format), so there is nothing to reject here.
        );
        final IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder(request.name);
        // First check to see if mappings are valid XContent
                    // fail with index missing...
                    return request.clusterManagerTimeout;
            @Override
            .collect(Collectors.toList());
            name,
                            + name
                validationErrors.add("index_pattern [" + indexPattern + "] must not contain a '#'");
    private static String getTimestampFieldMapping(String timestampFieldName) {
     */
            return null;
     * names would match both patterns simultaneously.
            .collect(Collectors.toCollection(LinkedList::new));
            .filter(Objects::nonNull)
     * names. The minimum-string heuristic restricts conflict detection to cases where "natural" index
            String warning = String.format(
        // this for validating that they're still going to be valid after this component template
        if (template == null || template.getDataStreamTemplate() == null) {
                    aliasMeta.put(cursor.getKey(), cursor.getValue());
                "index template [" + name + "] specifies a context which is not loaded on the cluster."
            // configured there is no format to validate against; such an index cannot start its shards at
     * Resolve index settings for the given list of v1 templates, templates are apply in reverse
        templateBuilder.version(request.version);
            );
                    throw new IndexTemplateMissingException(request.name);
        String clusterPluggableDataFormatValue
import org.opensearch.index.IndexService;
    ) {
import static org.opensearch.common.util.concurrent.ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME;
                    }
        int dummyPartitionSize = IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.get(resolvedSettings);
            if (parsedMappings.size() > 0) {
        Map<String, List<String>> overlaps = findConflictingV2Templates(
            .map(name -> state.metadata().componentTemplates().get(name))
            return currentState;
            @Override
import org.opensearch.core.xcontent.NamedXContentRegistry;
            }
        };
        Optional.ofNullable(template.context())
                }
            .ifPresent(mappings::add);
    ) throws Exception {
    private static Settings resolveSettings(Metadata metadata, ComposableIndexTemplate template) {
                    highestPriority = priority;
    ) throws Exception {
                if (template.getDataStreamTemplate() != null) {
            .templatesV2()
        if (templateNames.isEmpty()) {
        if (finalIndexTemplate.equals(existing)) {
                .filter(alias.filter())
            } else {
        Map<String, List<String>> overlaps = findConflictingV2Templates(currentState, request.name, request.indexPatterns);
                template.composedOf(),
    }
import org.opensearch.cluster.ClusterState;
        for (int i = templates.size() - 1; i >= 0; i--) {
            if (indexPattern.contains(" ")) {
            final String name = entry.getKey();
            @Override
        // When a pluggable data format is the cluster-wide default, validate the composed mapping as a
    /**
    public static void validateV2TemplateRequest(
        CompressedXContent mappings = template.template().mappings();
                        .toString();
        return ClusterState.builder(currentState).metadata(builder).build();
            boolean matched = false;
                            "updating component template ["
            return false;
                @Override
    private final ClusterManagerTaskThrottler.ThrottlingKey removeIndexTemplateTaskKey;
                }
 * KIND, either express or implied.  See the License for the
    /**
        for (String indexPattern : indexPatterns) {
        if (validationErrors.size() > 0) {
    @Nullable
    }
 * the Apache License, Version 2.0 (the "License"); you may
        });
        final String temporaryIndexName = UUIDs.randomBase64UUID();
        this.metadataCreateIndexService = metadataCreateIndexService;
            }
                listener.onResponse(new AcknowledgedResponse(true));
            + "       }\n"
import java.util.HashMap;
        validate(name, finalIndexTemplate);
        for (Alias alias : aliases) {
        Optional.ofNullable(componentTemplate).map(ComponentTemplate::template).map(Template::settings).ifPresent(templateSettings::put);
        if (templatesUsingComponent.size() > 0) {
                    + name
            + "\": {\n"
        if (indexPatterns.stream().anyMatch(Regex::isMatchAllPattern)) {
                template.priority(),
        // of precedence (with the index template first)
            .map(ComponentTemplate::template)
            public void onFailure(String source, Exception e) {
            return this;
        return Collections.unmodifiableList(resolvedAliases);
            @Override
                @Override
        final IndexMetadata tmpIndexMetadata = stateWithIndex.metadata().index(temporaryIndexName);
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                if (isNotMatchAllTemplate) {
            } catch (IllegalArgumentException iae) {
                public void onFailure(String source, Exception e) {
                    + "existing templates [%s] with patterns (%s) that have the same priority [%d], multiple index templates may not "
            .map(ComponentTemplate::template)
                @Override
                    + "existing older templates [%s] with patterns (%s); this template [%s] will take precedence during new index creation",
import org.opensearch.index.mapper.MapperService.MergeReason;
 * this file be licensed under the Apache-2.0 license or a
        } catch (Exception e) {
                    listener.onResponse(new AcknowledgedResponse(true));
                    matchedTemplates.add(template);
            finalSettings,
                validationErrors.add("index_pattern [" + indexPattern + "] must not contain a ':'");
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX_TEMPLATE_V2;
     * Finds index templates whose index pattern matched with the given index name. In the case of
     */
        });
                        throw new UncheckedIOException(e);
                );
            // fail with index missing...
        });
     */
        TimeValue clusterManagerTimeout = ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
    }
     */
        } finally {
        IndexTemplateMetadata template = templateBuilder.build();
        final ComposableIndexTemplate template = metadata.templatesV2().get(templateName);
    static String findContextTemplateName(Metadata metadata, Context context) {
                name,
        }
                validationErrors.add("index_pattern [" + indexPattern + "] must not contain a ','");
    }
    public interface RemoveListener {
    private void validateComponentTemplateRequest(ComponentTemplate componentTemplate) {
import org.apache.lucene.util.CollectionUtil;
                        // global templates don't support configuring the `index.hidden` setting so we don't need to resolve the settings as
                        "cannot update component template ["
            .map(componentTemplates::get)
        for (String templateName : currentState.metadata().templatesV2().keySet()) {
                    + (newTemplate.getDataStreamTemplate() == null ? "and no data stream configuration " : "")
                    template.patterns()
                    || templateWithHiddenSetting.get() != templateWithHiddenSettingPostRemoval.get()) {
        int dummyShards = resolvedSettings.getAsInt(
                    if (meta.templatesV2().get(matchingTemplate).getDataStreamTemplate() == null) {
 * Licensed to Elasticsearch under one or more contributor
                clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
            .stream()
            throw new InvalidIndexTemplateException(
                listener.onFailure(e);
                        );
        IndicesService indicesService,
                    .field(MapperService.SINGLE_MAPPING_NAME, parsedMappings)
            // setting index:true is rejected here rather than failing every index the template creates.
        );
        final IndicesService indicesService,
import org.opensearch.threadpool.ThreadPool;
                    logger.info("removing component template [{}]", templateName);
                    listener.onFailure(e);
        );
                }
        if (isContextAllowed
            this.mappings = mappings;
            "{} index template [{}] for index patterns {}",
        // Generate a metadata as if the new template were actually in the cluster state
    /**
        }
            }
            CompressedXContent mappings = innerTemplate.mappings();
    ) {
            }
            this.create = create;
                .findFirst();
        IndexTemplateMetadata existingTemplate = currentState.metadata().templates().get(request.name);
     * supports simple regex wildcards for removing multiple component templates at a time.
                    + ", priority ["
                }
        final List<String> templatesStillUsing = metadata.templatesV2().entrySet().stream().filter(e -> {
                        matchedTemplates.add(template);
    /**
        final ComponentTemplate existing = currentState.metadata().componentTemplates().get(name);
                .ifPresent(mappings::add);
        int shardReplicas = resolvedSettings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
        ThreadPool threadPool
        }
        Settings.Builder templateSettings = Settings.builder();
            IndexTemplateMetadata template = cursor.getValue();
                }
        final Set<String> componentsBeingUsed = new HashSet<>();
        }
    /**
                Map<String, Object> parsedMappings = MapperService.parseMapping(xContentRegistry, stringMappings);
                @Override
            public TimeValue timeout() {
        if (newlyUnreferenced.size() > currentlyUnreferenced.size()) {
        createIndexTemplateTaskKey = clusterService.registerClusterManagerTask(CREATE_INDEX_TEMPLATE, true);
            validationErrors.add("name must not contain a '#'");
 * SPDX-License-Identifier: Apache-2.0
                    return masterTimeout;
            throw new InvalidIndexTemplateException(
        Map<String, String> mappings,
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                }
        }
                    // remove the global templates
        if (request.name == null) {
        public PutRequest settings(Settings settings) {
        private final boolean acknowledged;
        final ClusterState state,
            Settings mergedSettings = resolveSettings(metadata, template);
                // shard id and the current timestamp
                    throw new IllegalStateException(
        }
     * <p>
        }
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID());
            finalResolvedSettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);
                name,
    }
            .map(Template::settings)
            );
        String contextTemplateName = findContextTemplateName(metadata, context);
        final List<String> indexPatterns
                    winner = template;
        long highestPriority = -1;
        final ClusterState stateWithIndex = ClusterState.builder(stateWithTemplate)
            // index-local remote_store flag, so use the cluster-aware overload like the _settings update path).
                stringMappings = XContentFactory.jsonBuilder()
        // Find data streams that are currently unreferenced
import org.opensearch.common.regex.Regex;
        return ClusterState.builder(currentState)
     * @param metadata The {@link Metadata} containing all of the {@link IndexTemplateMetadata} values
public class MetadataIndexTemplateService {
            .metadata(Metadata.builder(currentState.metadata()).put(name, finalComponentTemplate))
                .build();
        public boolean acknowledged() {
        });
                public ClusterState execute(ClusterState currentState) throws Exception {
        );
     * Return a map of v2 template names to their index patterns for v2 templates that would overlap
                    } catch (Exception e) {
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;
import org.opensearch.common.Nullable;
        final ClusterState stateWithTemplate = ClusterState.builder(state)
        }
            Exception validationFailure = null;
            finalSettings,
     */
        }
    }
        validate(name, template.template(), template.indexPatterns());
                referredComponentTemplates.add(systemTemplateUsed);
        final String name;
            return null;
                    validateTemplate(
            );
        // use the provided values, otherwise just pick valid dummy values
            );
            + "       \""
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            .map(ctx -> findContextTemplateName(state.metadata(), ctx))
        final ComposableIndexTemplate template,
        ClusterService clusterService,
                Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                    + newTemplate.indexPatterns()
                tempIndexService.newQueryShardContext(0, null, () -> 0L, null)
                template.context()
            );
        return Collections.unmodifiableList(aliases);
        // Aliases are applied in order, but subsequent alias configuration from the same name is
        public PutRequest(String cause, String name) {
                if (matchingTemplate == null) {
        validate(name, template.template(), Collections.emptyList());
                template.getDataStreamTemplate(),
        if (isHidden == null) {
        final Map<String, ComponentTemplate> componentTemplates = metadata.componentTemplates();
        this.aliasValidator = aliasValidator;
            this.acknowledged = acknowledged;
     * add a new template, as we don't support multiple overlapping, from an index pattern perspective,
        }
        MetadataCreateIndexService metadataCreateIndexService,
        }
            return currentState;
            .map(componentTemplates::get)
            for (String dataStream : dataStreams) {
        return a;
                }
    static ClusterState innerPutTemplate(
        if (winner == null) {
        }
        if (indexName.startsWith(DataStream.BACKING_INDEX_PREFIX)) {
                                + name
            }
        if (innerTemplate != null) {
            listener.onFailure(new IllegalArgumentException("index_template must provide a template"));
    public static List<Map<String, AliasMetadata>> resolveAliases(final List<IndexTemplateMetadata> templates) {
        final String candidateName,
                IndexMetadata.SETTING_NUMBER_OF_SHARDS,
            .filter(ob -> SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE.equals(ob.toString()))
            public TimeValue timeout() {
                Metadata.Builder metadata = Metadata.builder(currentState.metadata());
import org.opensearch.common.ValidationException;
        return resolveSettings(metadata, template);
                            + String.join(",", globalTemplatesThatUseThisComponent)
                componentsBeingUsed.addAll(intersecting);
                && clusterPluggableDataFormatValue.isEmpty() == false
            + "     \"properties\": {\n"
                );
                if (checkPriority == false || priority == template.priorityOrZero()) {
            Settings.Builder dummySettingsBuilder = Settings.builder()
                    throw new IllegalArgumentException(
        if (template.context() != null) {
            this.clusterManagerTimeout = clusterManagerTimeout;
    public static Map<String, List<String>> findConflictingV2Templates(
    private final IndexScopedSettings indexScopedSettings;
                Locale.ROOT,
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            || clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING) == false) {
            if (indexPatterns.contains(alias.name())) {
            }
        return templateSettings.build();
            );
                    if (Regex.simpleMatch(request.name, templateName)) {
    ) throws Exception {
        this.clusterService = clusterService;
     * Listener for putting metadata in the template
    }
        final String name,
                final boolean templatedIsHidden = IndexMetadata.INDEX_HIDDEN_SETTING.get(templateWithHiddenSetting.get().settings());
                    listener.onFailure(e);
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
     */
                public void onFailure(String source, Exception e) {
                    // if its a match all pattern, and no templates are found (we have none), don't
        ComposableIndexTemplate finalIndexTemplate = template;
        if (name.toLowerCase(Locale.ROOT).equals(name) == false) {
    static boolean patternsActuallyOverlap(List<String> patterns1, List<String> patterns2) {
            aliasValidator.validateAliasStandalone(alias);
import org.opensearch.indices.InvalidIndexTemplateException;
                    "index_pattern [" + indexPattern + "] must not contain the following characters " + Strings.INVALID_FILENAME_CHARS
                finalSettings = Settings.builder().put(finalSettings).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX).build();
            }
import org.opensearch.common.settings.IndexScopedSettings;
        boolean clusterPluggableDataFormatEnabled,
        }
        }
                    } else {
            if (indexPattern.contains("#")) {
            validationErrors.add("name must not contain a space");
                            e
        if (mappings != null) {
    }
                    validateTimestampFieldMapping(mapperService);
        final String templateName,
    ) {
                final Optional<IndexTemplateMetadata> templateWithHiddenSettingPostRemoval = matchedTemplates.stream()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, shardReplicas)
        if (context == null) {
        for (final Map.Entry<String, IndexTemplateMetadata> cursor : state.metadata().templates().entrySet()) {
        }
        // Flag for whether this is updating an existing template or adding a new one
     * Returns the default mapping snippet for the timestamp field by configuring it as a 'date' type.
    /**
        );
    public void putComponentTemplate(
        // Validate index metadata (settings)
            }
            );
                }
        if (finalComponentTemplate.equals(existing)) {
                        globalTemplatesThatUseThisComponent.add(entry.getKey());
                template.metadata(),
        return templateSettings.build();
                dummyPartitionSize == 1 ? 1 : dummyPartitionSize + 1
        Metadata.Builder builder = Metadata.builder(currentState.metadata()).put(template);
        final ActionListener<AcknowledgedResponse> listener
        final Set<String> dataStreams = state.metadata().dataStreams().keySet();
        // If we found any data streams that used to be covered, but will no longer be covered by
                        indicesService,
        final List<String> indexPatterns
                    );
        public PutRequest patterns(List<String> indexPatterns) {
            finalIndexTemplate = new ComposableIndexTemplate(
            + "   }\n"
        Optional<Set<String>> dataStreamsUsingTemplates = templateNames.stream()
                    if (Regex.simpleMatch(name, templateName)) {
                template.indexPatterns(),
    // Package visible for testing
            // adding this template last, since timestamp field should have highest precedence:
            throw new InvalidIndexTemplateException(
import org.opensearch.indices.IndexTemplateMissingException;
        public RemoveResponse(boolean acknowledged) {
        final TimeValue masterTimeout,
            public ClusterState execute(ClusterState currentState) {
                    return createComponentTemplateTaskKey;
            this.settings = settings;
            }
        this.xContentRegistry = xContentRegistry;
            Settings dummySettings = dummySettingsBuilder.build();
            } catch (Exception e) {
                );
            createdIndex = dummyIndexService.index();
                request.indexPatterns,
                        + new TreeSet<>(templateNames)
                listener.onResponse(new RemoveResponse(true));
            }
     */
            validationErrors.add("name must not start with '_'");
        if (template.equals(existingTemplate)) {
                }
                public ClusterState execute(ClusterState currentState) throws Exception {
        final ClusterState state,
        if (template == null) {
                final boolean isNotMatchAllTemplate = template.patterns().stream().noneMatch(Regex::isMatchAllPattern);
            throw new IllegalStateException(
        indicesService.withTempIndexService(tmpIndexMetadata, tempIndexService -> {
        return "{\n"
                for (String templateName : currentState.metadata().componentTemplates().keySet()) {
        clusterService.submitStateUpdateTask("remove-index-template [" + request.name + "]", new ClusterStateUpdateTask(Priority.URGENT) {
            // Validate aliases
        }
        // Now use context referenced template's aliases which take the highest precedence
            if (createdIndex != null) {
            .entrySet()
        public PutRequest order(int order) {
            return this;
import org.opensearch.index.translog.Translog;
    public void putIndexTemplateV2(
        public RemoveRequest(String name) {
            );
        if (winner.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)
    }
 * GitHub history for details.
 * You may obtain a copy of the License at
                // the context is only used for validation so it's fine to pass fake values for the
    }
            Settings finalSettings = innerTemplate.settings();
            .metadata(
        // Collect all the composable (index) templates that use this component template, we'll use
        // ignored, so in order for the order to be correct, alias configuration should be in order
            return mappings;
                validationErrors.add("index_pattern [" + indexPattern + "] must not start with '_'");
            return Collections.emptySet();
            }
                dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);
                templateNames.add(templateName);
        final Map<String, ComponentTemplate> componentTemplates = metadata.componentTemplates();
    /**
        return Optional.ofNullable(metadata.systemTemplatesLookup())
                    matchedTemplates.removeIf(current -> current.patterns().stream().anyMatch(Regex::isMatchAllPattern));
        List<String> validationErrors = new ArrayList<>();
            .isPresent();
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX_TEMPLATE;
                    + "] template after composition "
        }
                List<String> globalTemplatesThatUseThisComponent = new ArrayList<>();
                    "global composable templates may not specify the setting " + IndexMetadata.INDEX_HIDDEN_SETTING.getKey()
                    }
                for (String templateName : templateNames) {
    private void validate(String name, ComposableIndexTemplate template) {
     * @param indexName The name of the index that templates are being found for
        if (create == false && finalSettings != null) {
        final String candidateName,
                request.name
                listener.onFailure(e);
        final ClusterState currentState,
            return this;
            // Mappings in index templates don't include _doc, so update the mappings to include this single type
            }
import static org.opensearch.cluster.metadata.MetadataUpdateSettingsService.validateIndexTotalPrimaryShardsPerNodeSetting;
                    "composable template {} and legacy template {} would overlap: {} <=> {}",
                    + SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey()
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, shardReplicas)
                    + "would cause data streams "
            validate(request);
            && template.composedOf().stream().anyMatch(componentTemplate -> isSystemTemplate(componentTemplates.get(componentTemplate)))) {
        final boolean create,
            }
            );
        }
                    }
        if (name.contains(",")) {
        clusterService.submitStateUpdateTask(
                            + "] because the following global templates would resolve to specifying the ["
        final boolean create,
            // We may need to normalize index settings, so do that also
 * under the License.
            + templateName
            name,
        return winnerName;
        final boolean clusterPluggableDataFormatEnabled,
                finalSettings,
import java.util.Collections;
        public PutResponse(boolean acknowledged) {
    public static List<IndexTemplateMetadata> findV1Templates(Metadata metadata, String indexName, @Nullable Boolean isHidden) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        List<Alias> aliases = new ArrayList<>();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, dummyShards)
                name,
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            return;
     * if the {@code cluster.remote_store.index.restrict.async-durability} is set to true.
        if (overlaps.size() > 0) {
                }
     */
            return acknowledged;
                    + "] with index patterns "
            "create-component-template [" + name + "], cause [" + cause + "]",
     * For each pattern in either set, the wildcard character {@code *} is replaced with the empty string
        // Mappings in component templates don't include _doc, so update the mappings to include this single type
            this.name = name;
                final String matchingTemplate = findV2Template(meta, dataStream, false);
                        indicesService,
        Settings.Builder templateSettings = Settings.builder();
        if (name.contains("*")) {
    }
        Optional.ofNullable(template.template()).map(Template::aliases).ifPresent(aliases::add);
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID());
            return currentState;
     *
        logger.info("adding template [{}] for index patterns {}", request.name, request.indexPatterns);
        final ComponentTemplate finalComponentTemplate = new ComponentTemplate(finalTemplate, template.version(), template.metadata());
            }
                @Override
        // if we're updating a component template, let's check if it's part of any V2 template that will yield the CT update invalid
            .put(resolvedSettings)
    /**
            String systemTemplateUsed = findContextTemplateName(metadata, e.getValue().context());
            + "] that did not exist in the cluster state";
        NamedXContentRegistry xContentRegistry,
        templateBuilder.settings(request.settings);
    private static void validateTemplate(
                validationErrors.add(iae.getMessage());
                    metadata.removeTemplate(templateName);
                    + (finalIndexTemplate.composedOf().size() > 0
                if (templateNames.isEmpty()) {
            }
            .map(Template::aliases)
        }
        final NamedXContentRegistry xContentRegistry,
        }
                @Override
                }
            public TimeValue timeout() {
                name,
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final Logger logger = LogManager.getLogger(MetadataIndexTemplateService.class);
    /**
                name
        return findConflictingV2Templates(state, candidateName, indexPatterns, false, 0L);
            Set<String> referredComponentTemplates = new HashSet<>(e.getValue().composedOf());
                .stream()
     * settings, mappings, and aliases.
            }
        a.writeIndex(aliasMeta.writeIndex());
                        .endObject()
        if (request.indexPatterns == null) {
            IndexMetadata.SETTING_NUMBER_OF_SHARDS,
                        validationFailure.addSuppressed(e);
            new ClusterStateUpdateTask(Priority.URGENT) {
                                + composableTemplateName
                    candidateName,
        }
            .map(ComponentTemplate::metadata)
            settings = Settings.EMPTY;
        Map<String, List<String>> overlappingTemplates = new HashMap<>();
import java.util.function.Function;
            + templateName
        void onResponse(RemoveResponse response);
            .map(md -> md.get(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY))
        }
import org.apache.logging.log4j.LogManager;
 * not use this file except in compliance with the License.
        void onResponse(PutResponse response);
                "composable template ["
        // Only include timestamp mapping snippet if creating backing index.
        validateTemplate(
                    .filter(template -> IndexMetadata.INDEX_HIDDEN_SETTING.exists(template.settings()))
        }
            )
    private void validateTranslogDurabilitySettingsInTemplate(Settings requestSettings, ClusterSettings clusterSettings) {
                for (CompressedXContent mapping : mappings) {
     * Add the given index template to the cluster state. If {@code create} is true, an
        final ComposableIndexTemplate template,
                return true;
            // straightforward as all backing indices are required to have a timestamp field
        // Finally, right before adding the template, we need to ensure that the composite settings,
            .filter(Objects::nonNull)
     * The PUT response.
    }
    public static class PutResponse {
        }
    ) throws Exception {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
    public static Settings resolveSettings(final Metadata metadata, final String templateName) {
        );
            return this;
                return ClusterState.builder(currentState).metadata(metadata).build();
    }
        final Predicate<String> patternMatchPredicate = pattern -> Regex.simpleMatch(pattern, indexName);
        final String cause,
            maybeTemplate.map(Template::aliases)
                template.version(),
        clusterService.submitStateUpdateTask(
            // If an inner template was specified, its mappings may need to be
            + "     }\n"
        try {
import org.opensearch.indices.IndicesService;
    }
        CollectionUtil.timSort(matchedTemplates, Comparator.comparingInt(IndexTemplateMetadata::order).reversed());
            a.filter(aliasMeta.filter().string());
        // Add the actual index template's mappings, since it takes the next precedence
            .orElse(null);
                    }
     * A remove Request.
            throw new IllegalArgumentException("A system template can only be created/updated/deleted with a repository");
                }
            validationException.addValidationErrors(validationErrors);
            try {
        public boolean acknowledged() {
        final String name,
        return Collections.unmodifiableList(mappings);
            if (template.aliases() != null) {
        }
                final boolean matched = template.patterns().stream().anyMatch(patternMatchPredicate);
            for (Map.Entry<String, String> entry : mappings.entrySet()) {
     * intersection correctly identifies theoretical overlaps that arise only from creative wildcard usage
    public static List<Map<String, AliasMetadata>> resolveAliases(final Metadata metadata, final String templateName) {
                    return createIndexTemplateTaskKey;
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;
     * @param isHidden Whether or not the index is known to be hidden. May be {@code null} if the index
        // Hard to validate settings if they're non-existent, so used empty ones if none were provided
     *
            listener.onFailure(e);
            if (clusterPluggableDataFormatEnabled && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(settings) == false) {
import java.util.Objects;
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_INDEX_TEMPLATE;
                stateWithIndex.metadata(),
        }
        // Create the final aggregate settings, which will be used to create the temporary index metadata to validate everything
        for (final IndexTemplateMetadata template : metadata.templates().values()) {
                        new CompressedXContent(entry.getValue());
     * Return a map of v2 template names to their index patterns for v2 templates that would overlap
        }
import org.opensearch.index.IndexSettings;
        return Collections.unmodifiableList(matchedTemplates);
                        .startObject()
     * Return a map of v1 template names to their index patterns for v1 templates that would overlap
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            );
    }
                public TimeValue timeout() {
                    + winnerName
                Metadata.builder(stateWithTemplate.metadata())
        try {
        // Also carry the cluster's default data format name (mirroring MetadataCreateIndexService) so the
                name,
            Set<String> intersecting = Sets.intersection(referredComponentTemplates, matchingComponentTemplates);
        IndicesService indicesService,
        validateComponentTemplateRequest(template);
            if (intersecting.size() > 0) {
                    + newTemplate.priority()
    /**
    private final ClusterService clusterService;
            }
import java.util.function.Predicate;
            // triggers inclusion of _timestamp field and its validation:
            if (matched) {
    /**
            if (Regex.simpleMatch(name, templateName)) {
            .metadata(Metadata.builder(state.metadata()).put(templateName, template))
    public interface PutListener {
            );
    /**
                if (templatedIsHidden) {
                }
     *
                @Override
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                    + " to no longer match a data stream template"
 *
        if (overlaps.size() > 0) {
                        mappingsForValidation.put(entry.getKey(), MapperService.parseMapping(xContentRegistry, entry.getValue()));
    ) {
            indicesService,
        this.indicesService = indicesService;
        // this is complex but if the index is not hidden in the create request but is hidden as the result of template application,
            + templateName
            }
        Map<String, List<String>> overlappingTemplates = new HashMap<>();
        final ClusterState state,
                final boolean isNotMatchAllTemplate = template.indexPatterns().stream().noneMatch(Regex::isMatchAllPattern);
            // pluggable index would see it — unless the template opts out explicitly — so that a field
                long priority = template.priorityOrZero();
        final boolean searchSpecificVersion = !Context.LATEST_VERSION.equals(context.version());
        createIndexTemplateV2TaskKey = clusterService.registerClusterManagerTask(CREATE_INDEX_TEMPLATE_V2, true);
     * the event that no templates are matched, {@code null} is returned.
        // mappings, and aliases are valid after it's been composed with the component templates
        }
                    ComposableIndexTemplate templateV2 = entry.getValue();
            }
                            + "] setting: ["
    /**
        List<CompressedXContent> mappings = template.composedOf()
        if (templatesStillUsing.size() > 0) {
                    + "] "
 * @opensearch.internal
}
                        templateNames.add(templateName);
                Strings.collectionToCommaDelimitedString(overlaps.keySet()),
     * Resolve the given v1 templates into an ordered list of aliases
                                + "] results in invalid composable template ["
            .map(ComponentTemplate::template)
            .filter(Objects::nonNull)
                    + newlyUnreferenced
                }
        // creation anyway (no data format), so there is nothing to reject here.
            logger.info("removing index template [{}]", templateName);
        if (overlaps.size() > 0) {
            validateTranslogDurabilitySettingsInTemplate(settings, clusterService.getClusterSettings());
                true,
        if (name.startsWith("_")) {
            + "   \"_doc\": {\n"
                        request.mappings,
        );
            clusterPluggableDataFormatValue
     * Validate that by changing or adding {@code newTemplate}, there are
                return currentState;
        }
        overlaps.remove(name);
        updatedSettingsBuilder.put(request.settings).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
            templateSettings.put(templates.get(i).settings());
    public static class RemoveRequest {
        ClusterSettings settings
    }
        final ActionListener<AcknowledgedResponse> listener
            .map(ComponentTemplate::template)
        Function<Metadata, Set<String>> findUnreferencedDataStreams = meta -> {
                    .startObject()
            }).forEach(matches::add);
        validateComponentTemplateRequest(clusterService.state().metadata().componentTemplates().get(name));
        String mappings,
        return ClusterState.builder(currentState).metadata(Metadata.builder(currentState.metadata()).put(name, finalIndexTemplate)).build();
                );
                }
    }
    private final ClusterManagerTaskThrottler.ThrottlingKey createIndexTemplateV2TaskKey;
            // The template is unchanged, therefore there is no need for a cluster state update
            this.indexPatterns = indexPatterns;
                final String usingTemplate = findV2Template(state.metadata(), stream, false);
                    .put(IndexMetadata.builder(temporaryIndexName).settings(finalResolvedSettings))
     * supports simple regex wildcards for removing multiple index templates at a time.
            }
    }
            return Settings.EMPTY;
                    "unable to remove composable templates "
            "create-index-template [" + request.name + "], cause [" + request.cause + "]",
    private final ThreadPool threadPool;
                    .build()
            // if the CT is specifying the `index.hidden` setting it cannot be part of any global template
            return this;
            template.indexPatterns(),
                listener.onResponse(new AcknowledgedResponse(true));
                @Override
    private void validate(String name, ComponentTemplate template) {
            .stream()
                }
     *
        return matches;
                && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(settings) == false) {
     * Given a state and a composable template, validate that the final composite template
    }
            return unreferenced;
        }
                // Check if this template is the highest priority template and used by this data stream
                );
/*
            }
        public PutRequest create(boolean create) {
                    + " cannot be removed as they are still in use by index templates "
    }
            @Override
        final ActionListener<AcknowledgedResponse> listener
        validateTemplate(
            this.aliases.addAll(aliases);
                        xContentRegistry,
                    + name
     * addition/update time
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
    }
            final Optional<IndexTemplateMetadata> templateWithHiddenSetting = matchedTemplates.stream()
        ComposableIndexTemplate winner = null;
     * @param requestSettings settings passed during template creation
            throw new IllegalArgumentException(
        }
            @Override
    public MetadataIndexTemplateService(
        boolean clusterPluggableDataFormatEnabled,
            .stream()
                    } catch (IOException e) {
import java.util.TreeSet;
                }
            public void onFailure(String source, Exception e) {
            }
                    if (Regex.isMatchAllPattern(request.name)) {
     */
            }
                }
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
                throw new IllegalArgumentException("invalid composite mappings for [" + templateName + "]", e);
        final String clusterPluggableDataFormatValue
        boolean create;
        // setting index:true is rejected here rather than failing every index the template creates.
     */
     */
            "create-index-template-v2 [" + name + "], cause [" + cause + "]",
                name,
                    + "] specifies a context which cannot be used without enabling: "
            Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, mappings),
            throw new IllegalArgumentException(
 */
        }
     * exception will be thrown if the component template already exists
                    if (Regex.isMatchAllPattern(name)) {
        String mappings = null;
                    + String.join(",", winner.composedOf())
        // we will fail and the user will have to update the index template and remove this setting or update the corresponding component
        }
    // Package visible for testing
    // Package visible for testing
     * A remove listener.
    ) throws Exception {
            true,
        if (template == null) {
    ) {
    }
    }
                        composableTemplateName,
        validate(name, finalComponentTemplate);
        Set<String> matches = new HashSet<>();
                final String composableTemplateName = entry.getKey();
            .map(Template::mappings)
                    }
            xContentRegistry,
                        // no other component template can remove this setting from the resolved settings, so just invalidate this update
        }
        ComposableIndexTemplate template,
     * index templates with the same priority).
        validate(putRequest.name, putRequest.settings, putRequest.indexPatterns, putRequest.aliases);
                }
        final ComposableIndexTemplate existing = currentState.metadata().templatesV2().get(name);
                        request.settings,
                    listener.onFailure(e);
    /**
        final String cause,
        }
        );
                return templateName.equals(usingTemplate);
     */
            this.cause = cause;
    }
                    try {
                indicesService.removeIndex(createdIndex, NO_LONGER_ASSIGNED, " created for parsing template mapping");
        Metadata metadata,
    }
import java.util.Comparator;
 * specific language governing permissions and limitations
        removeIndexTemplateV2TaskKey = clusterService.registerClusterManagerTask(REMOVE_INDEX_TEMPLATE_V2, true);
        }
import java.util.List;
            String timestampFieldName = template.getDataStreamTemplate().getTimestampField().getName();
            }
            .filter(e -> e.getValue().composedOf().contains(name))
            && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(resolvedSettings) == false) {
     *
import org.opensearch.common.settings.Settings;
    public static class RemoveResponse {
            }
     * This approach is intentionally more lenient than a full automaton intersection. Full automaton
            // we validate the alias only partially, as we don't know yet to which index it'll get applied to
                    try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
            if (Regex.isMatchAllPattern(name)) {
            if (IndexMetadata.INDEX_HIDDEN_SETTING.exists(finalSettings)) {
    private static Alias toAlias(AliasMetadata aliasMeta) {
            validationErrors.add("name must not contain a '*'");
        Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                    return innerPutTemplate(currentState, request, templateBuilder);
    ) {
    private final ClusterManagerTaskThrottler.ThrottlingKey createComponentTemplateTaskKey;
                overlaps.entrySet().stream().map(e -> e.getKey() + " => " + e.getValue()).collect(Collectors.joining(",")),
    static Set<String> dataStreamsUsingTemplate(final ClusterState state, final String templateName) {
                return removeComponentTemplateTaskKey;
        String stringMappings = mappings == null ? null : mappings.string();
        public PutRequest version(Integer version) {
    /**
            this.order = order;
            }
    }
    }
                }
        return overlappingTemplates;
            + "         \"type\": \"date\"\n"
                        + " as they are in use by a data streams "
            ComposableIndexTemplate template = entry.getValue();
                    .endObject()
        IndexTemplateMetadata.Builder templateBuilder
                        xContentRegistry,
     * Resolve the given v2 template into an ordered list of aliases
                xContentRegistry,
                        unreferenced.add(dataStream);
        final Template finalTemplate = new Template(
        final String temporaryIndexName = "validate-template-" + UUIDs.randomBase64UUID().toLowerCase(Locale.ROOT);
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
import java.util.Set;
    }
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateRefreshIntervalSettings;
import java.util.Map;
package org.opensearch.cluster.metadata;
            final Template finalTemplate = new Template(
        validateDataStreamsStillReferenced(currentState, name, finalIndexTemplate);
        clusterService.submitStateUpdateTask("remove-component-template [" + name + "]", new ClusterStateUpdateTask(Priority.URGENT) {
            return Collections.emptyList();
                indicesService,
            }
     * due to snapshot restores, but this validation is best-effort at template
                            + templateWithHiddenSetting.get().name()
                        builder.value(mapping);
     * generated by the composable template and all of its component templates contains valid
     */
    /**
        Template innerTemplate = template.template();
import org.opensearch.common.xcontent.XContentFactory;
            }
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            // create index service for parsing and validating "mappings"
                Locale.ROOT,
                return masterTimeout;
            if (systemTemplateUsed != null) {
            }
     * set, the two pattern sets are considered to overlap.
        // We may need to normalize index settings, so do that also
 */
     */
                finalTemplate,
        final ComponentTemplate componentTemplate = findComponentTemplate(metadata, template.context());
        }
    }
                }
import org.opensearch.core.xcontent.XContentBuilder;
        }
    }
            HeaderWarning.addWarning(warning);
            return;
                            + "]"
import org.opensearch.cluster.service.ClusterService;
    ) {
        }
        final List<String> indexPatterns,
                name,
import org.opensearch.core.action.ActionListener;
            // For each data stream that we have, see whether it's covered by a different
        for (String p1 : patterns1) {
    }
                "index template [" + name + "] specifies a component templates which can only be used in context."
                }
     * @opensearch.internal
     */
    private final AliasValidator aliasValidator;
        try {
        }
            // template (which is great), or whether it's now uncovered by any template
            .collect(Collectors.toList());
            }
            return this;
    /**
import org.opensearch.common.Priority;
                final ComposableIndexTemplate composableTemplate = entry.getValue();
 */
        if (durability.equals(Translog.Durability.ASYNC)) {
                new AliasValidator(),
                    + IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey()
     *
        final ComposableIndexTemplate template = metadata.templatesV2().get(templateName);
                validationErrors.add("global templates may not specify the setting " + IndexMetadata.INDEX_HIDDEN_SETTING.getKey());
            if (set.size() > 0) {
        return overlappingTemplates;
import org.opensearch.Version;
            dummyIndexService.mapperService().merge(mappingsForValidation, MergeReason.MAPPING_UPDATE);
            final ComposableIndexTemplate template = entry.getValue();
                return removeIndexTemplateTaskKey;
            final Set<String> unreferenced = new HashSet<>();
                threadPool.getThreadContext().getTransient(ACTION_ORIGIN_TRANSIENT_NAME)
     * @opensearch.internal
        final Set<String> currentlyUnreferenced = findUnreferencedDataStreams.apply(state.metadata());
        return ClusterState.builder(currentState).metadata(metadata).build();
 * Service responsible for submitting index templates updates
            Optional.ofNullable(componentTemplate.template()).map(Template::aliases).ifPresent(aliases::add);
        NamedXContentRegistry xContentRegistry,
                    listener.onResponse(new AcknowledgedResponse(true));
    private final NamedXContentRegistry xContentRegistry;
        String[] p2Array = patterns2.toArray(Strings.EMPTY_ARRAY);
        final Map<String, ComponentTemplate> componentTemplates = state.metadata().componentTemplates();
    }
                    logger.debug(
        final TimeValue masterTimeout,
        }
                        "A global index template ["
                    if (validationFailure == null) {
                "component templates "
        TimeValue clusterManagerTimeout = ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
    public static class PutRequest {
        Optional<Template> maybeTemplate = Optional.ofNullable(template);
            }
        public RemoveRequest clusterManagerTimeout(TimeValue clusterManagerTimeout) {
                    winnerName = name;
            @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, dummyShards)
            }
                    matched = template.indexPatterns().stream().anyMatch(patternMatchPredicate);
        final Set<String> newlyUnreferenced = findUnreferencedDataStreams.apply(updatedMetadata);
        final ComposableIndexTemplate template = state.metadata().templatesV2().get(templateName);
        }
                }
        Optional.ofNullable(template.template()).map(Template::settings).ifPresent(templateSettings::put);
            validateIndexTotalPrimaryShardsPerNodeSetting(settings, clusterService);
                    validationErrors.add(t.getMessage());
    /**
     */
            return this;
            template.template().aliases()
import java.util.ArrayList;
        }
            dummyPartitionSize == 1 ? 1 : dummyPartitionSize + 1
    }
        IndexScopedSettings indexScopedSettings,
        Translog.Durability durability = IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.get(requestSettings);
                "index template [%s] has index patterns %s matching patterns from "
            // Parse mappings to ensure they are valid after being composed
            }
                throw new InvalidIndexTemplateException(
            + "] that did not exist in the cluster state";
        // configured there is no format to validate against; such an index cannot start its shards at
                    );
                .build();
        }
                    );
                if (matched) {
        }
     *
    }
            try {
        Integer version;
                MetadataIndexTemplateService.resolveAliases(stateWithIndex.metadata(), templateName),
        public PutRequest clusterManagerTimeout(TimeValue clusterManagerTimeout) {
            String stringMappings = mappings == null ? null : mappings.string();
        if (request.mappings != null) {
            }
        dataStreamsUsingTemplates.ifPresent(set -> {
            if (indexPattern.contains(":")) {
            final ComponentTemplate componentTemplate = findComponentTemplate(metadata, template.context());
            && clusterPluggableDataFormatValue.isEmpty() == false
        if (template == null) {
            return Collections.emptyList();
                return masterTimeout;
 * software distributed under the License is distributed on an
     */
                innerTemplate.aliases()
        if (stringMappings != null) {
        }
                @Override
        });
        // then we need to exclude global templates
            // dummy index resolves a format and the capability path can reject index:true. When no name is
        }
            if (finalSettings != null) {
                @Override
                public ClusterState execute(ClusterState currentState) throws Exception {
                    + "], composed of component templates ["
        void onFailure(Exception e);
                .indexRouting(alias.indexRouting())
        IndicesService indicesService,
            new ClusterStateUpdateTask(Priority.URGENT) {
                "index template [%s] has index patterns %s matching patterns from "
        if (clusterPluggableDataFormatEnabled
            logger.warn(warning);
        // if the winner template is a global template that specifies the `index.hidden` setting (which is not allowed, so it'd be due to
import org.opensearch.common.compress.CompressedXContent;
            if (Regex.simpleMatch(p2Array, p1.replace("*", ""))) {
    public void removeIndexTemplateV2(
     * with the given v2 template's index patterns.
            AliasMetadata aliasMetadata = AliasMetadata.builder(alias.name())
     * templates, throwing an error if it is still in use
                throw validationFailure;
                    return addComponentTemplate(currentState, create, name, template);
                Map<String, AliasMetadata> aliasMeta = new HashMap<>();
            .stream()
            return this;
    private void validate(String name, Template template, List<String> indexPatterns) {
                @Override
                    + componentsBeingUsed
            templateBuilder.putAlias(aliasMetadata);
            MetadataCreateIndexService.resolveAndValidateAliases(
    public void removeComponentTemplate(
                    // TODO: perhaps introduce a ComponentTemplateMissingException?
            HeaderWarning.addWarning(warning);
                finalIndexTemplate,
        });
            stringMappings == null ? null : new CompressedXContent(stringMappings),
            @Override
    }
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    + "=true]"
            @Override
                }
                } catch (Exception e) {
    }
            .build();
            throw new InvalidIndexTemplateException(name, validationException.getMessage());
            .stream()
 *
    public ClusterState addIndexTemplateV2(
        String winnerName = null;
    public static Map<String, List<String>> findConflictingV1Templates(
        final Map<String, ComposableIndexTemplate> templatesUsingComponent = currentState.metadata()
        }
                for (String templateName : templateNames) {
            return;
            maybeTemplate.map(Template::settings).orElse(Settings.EMPTY),
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
        }
            .collect(Collectors.toList());
            throw new IndexTemplateMissingException(name);
        if (isSystemTemplate(componentTemplate)
            validateRefreshIntervalSettings(settings, clusterService.getClusterSettings());
            );
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_COMPONENT_TEMPLATE;
                    return createIndexTemplateV2TaskKey;
 * ownership. Elasticsearch licenses this file to you under
                if (winner == null || priority > highestPriority) {
                })
                }
                .map(MetadataIndexTemplateService::toAlias)
            @Override
            xContentRegistry,
            listener.onFailure(new IllegalArgumentException("index_template must provide a name"));
        final Map<String, ComponentTemplate> componentTemplates = metadata.componentTemplates();
        final String name,
                    }
            if (templateWithHiddenSetting.isPresent()) {
            mappings.add(0, new CompressedXContent(getTimestampFieldMapping(timestampFieldName)));
        public String getMappings() {
        Alias a = new Alias(aliasMeta.alias());
        // TODO: in 8.0+, only allow updating index templates, not adding new ones
/**
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            logger.warn(warning);
        }
     * Checks whether two sets of index patterns practically overlap, using a minimum-string heuristic.
    }
                        return new CompressedXContent(BytesReference.bytes(builder));
        final ActionListener<AcknowledgedResponse> listener
    }
                Set<String> templateNames = new HashSet<>();
        void onFailure(Exception e);
     */
     * with the given template's index patterns.
        // pluggable index would see it — unless the template opts out explicitly — so that a field
            );
            }
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;
                    );
                    stringMappings = XContentFactory.jsonBuilder()
     */
                if (globalTemplatesThatUseThisComponent.isEmpty() == false) {
        }
import java.util.Optional;
        final ComponentTemplate template,
            currentState,
                .filter(template -> IndexMetadata.INDEX_HIDDEN_SETTING.exists(template.settings()))
        final String name,
                        throw new MapperParsingException("Failed to parse mapping [{}]: {}", e, entry.getKey(), e.getMessage());
            }
                        composableTemplate,
        }
        if (create && existing != null) {
        assert template != null : "attempted to resolve mappings for a template ["
        return metadata.componentTemplates().getOrDefault(contextTemplateName, null);
            finalResolvedSettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), clusterPluggableDataFormatValue);
     * A remove Response.
                @Override
        a.searchRouting(aliasMeta.searchRouting());
            // Only if template has data stream definition this should be added and
            .map(Template::mappings)
        // Add the actual index template's aliases now if they exist
        if (finalSettings != null) {
    public void putTemplate(final PutRequest request, final PutListener listener) {
        }
                    if (templateV2.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)) {
            Map<String, Object> parsedMappings = MapperService.parseMapping(xContentRegistry, stringMappings);
    static ComponentTemplate findComponentTemplate(Metadata metadata, Context context) {
     * Validates {@code index.translog.durability} is not async with the incoming index template
                    .toString();
     * A PUT request.
        );
                    .findFirst();
            if (validationFailure != null) {
        this.threadPool = threadPool;
            }
                Strings.collectionToCommaDelimitedString(overlaps.keySet()),
                            + "] defined the index hidden setting, which is not allowed"
            metadata.removeIndexTemplate(templateName);
        public PutRequest mappings(String mappings) {
        final Set<String> dataStreams = state.metadata().dataStreams().keySet();
                if (isNotMatchAllTemplate) {
     * Return the name (id) of the highest matching index template for the given index name. In
        Map<String, Map<String, Object>> mappingsForValidation = new HashMap<>();
        }
        Collections.reverse(aliases);
            }
                return true;
    /**
            .keySet()
        if (template.context() != null && findContextTemplateName(metadata, template.context()) == null) {
                    }
            return null;
        long priority
            int dummyPartitionSize = IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.get(settings);
            }
 *
        final String name;
        }
        Settings finalResolvedSettings = finalResolvedSettingsBuilder.build();
            // validate index refresh interval and translog durability settings
        if (template.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)) {
        }
     * Remove the given component template from the cluster state. The component template name
        final String name,
                }
            if (indexPattern.contains(",")) {
        createComponentTemplateTaskKey = clusterService.registerClusterManagerTask(CREATE_COMPONENT_TEMPLATE, true);
     * index templates regardless of the priority (ie. checkPriority == false) or otherwise overlapping
        }
                    + "match during index creation, please use a different priority",
     * templates with the same priority as the given priority parameter (this is useful when trying to
     * Based on the provided checkPriority and priority parameters this aims to report the overlapping
        final TimeValue masterTimeout,
                    // is a data stream template, as it's only useful if it has a data stream definition
        // changing this template, then blow up with as much helpful information as we can muster
        validateNotInUse(clusterService.state().metadata(), name);
                for (Throwable t : iae.getSuppressed()) {
        final ComposableIndexTemplate template
     * @opensearch.internal
                    name,
 */
                settings,
     * <p>
                "index template ["
     * {@code app-test--some_other--some-}), but these synthetic strings would never appear as real index
    }
        List<String> indexPatterns;
     */
    ) {
 * this work for additional information regarding copyright
                .searchRouting(alias.searchRouting())
        Settings.Builder finalResolvedSettingsBuilder = Settings.builder()
            .collect(Collectors.toSet());
            template.indexPatterns()
                        name,
                overlaps.entrySet().stream().map(e -> e.getKey() + " => " + e.getValue()).collect(Collectors.joining(",")),
