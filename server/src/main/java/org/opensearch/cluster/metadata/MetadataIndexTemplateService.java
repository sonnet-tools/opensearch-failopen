        final List<String> missingComponentTemplates = template.composedOf()
            if (systemTemplateUsed != null) {  
    }
    }
        Index createdIndex = null;
    private final ClusterManagerTaskThrottler.ThrottlingKey removeComponentTemplateTaskKey;
        clusterService.submitStateUpdateTask("remove-component-template [" + name + "]", new ClusterStateUpdateTask(Priority.URGENT) {  
import static org.opensearch.cluster.metadata.MetadataUpdateSettingsService.validateIndexTotalPrimaryShardsPerNodeSetting;  
            // index-local remote_store flag, so use the cluster-aware overload like the _settings update path).
        final List<String> indexPatterns,
            );
                    // if its a match all pattern, and no templates are found (we have none), don't
                }
            if (indexPattern.contains("#")) {
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
import java.util.ArrayList;
     *
            stringMappings == null ? null : new CompressedXContent(stringMappings),  
        if (name.contains(" ")) {
     *                 not be returned  
            && IndexMetadata.INDEX_HIDDEN_SETTING.exists(resolveSettings(metadata, winnerName))) {
        for (String templateName : templateNames) {
        final ClusterState currentState,
                validationErrors.add("index_patterns [" + indexPattern + "] must not contain a space");  
            )) {
                );
                // the context is only used for validation so it's fine to pass fake values for the  
        validateComponentTemplateRequest(template);  
            Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, mappings),
    }
            .filter(name -> Regex.simpleMatch(templateNameOrWildcard, name))  
                "component templates "
            try {
        final Map<String, ComponentTemplate> componentTemplates = metadata.componentTemplates();
        }
    /**
            "create-index-template [" + request.name + "], cause [" + request.cause + "]",
                        candidateName,
                            + String.join(",", globalTemplatesThatUseThisComponent)  
                return templateName.equals(usingTemplate);
    /**  
     *
        }  
        final Set<String> dataStreams = state.metadata().dataStreams().keySet();
import org.apache.logging.log4j.Logger;
        ClusterSettings settings
                }
    private final AliasValidator aliasValidator;
            } catch (IllegalArgumentException iae) {
 * SPDX-License-Identifier: Apache-2.0
            + "     \"properties\": {\n"  
                .put(settings)
        return a;
    ) {  
        if (template.context() != null && !isContextAllowed) {
        }  
    }  
                    return request.clusterManagerTimeout;
                    + "] "  
import org.opensearch.threadpool.ThreadPool;  
            .filter(Objects::nonNull)  
            throw new InvalidIndexTemplateException(
            .map(name -> state.metadata().componentTemplates().get(name))  
                    // fail with index missing...  
    static Set<String> dataStreamsUsingTemplate(final ClusterState state, final String templateName) {  
     * @opensearch.internal  
    }
                    mapperService.merge(MapperService.SINGLE_MAPPING_NAME, mapping, MergeReason.INDEX_TEMPLATE);
            }
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID());
        }
     *  
            }
        final TimeValue masterTimeout,
    private static void validateTemplate(  
            .map(coll -> coll.get(context.name()))
    private void validateComponentTemplateRequest(ComponentTemplate componentTemplate) {  
     * supports simple regex wildcards for removing multiple index templates at a time.  
                // validate that hidden didn't change
                Collections.emptySet(),
                            + "] setting: ["
        if (template.equals(existingTemplate)) {
                            + name
        ThreadPool threadPool
            // Parse mappings to ensure they are valid after being composed
                    validateTimestampFieldMapping(mapperService);  
                request.name
                validationErrors.add(  
        int dummyPartitionSize = IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.get(resolvedSettings);
    private static void validateTemplate(  
            + "       }\n"
        List<Map<String, AliasMetadata>> aliases = template.composedOf()  
                return currentState;  
        // of precedence (with the index template first)
        final List<IndexTemplateMetadata> matchedTemplates = new ArrayList<>();  
            // If an inner template was specified, its mappings may need to be
                @Override
        return ClusterState.builder(currentState).metadata(builder).build();  
        );
                template.version(),  
            .filter(e -> e.getValue().composedOf().contains(name))
                    + templatesStillUsing
                    return innerPutTemplate(currentState, request, templateBuilder);  
            + templateName
    }
    }  
                    );
            return this;  
                }
            return currentState;  
                    if (templateV2.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)) {
    private void validate(String name, ComponentTemplate template) {
                final String composableTemplateName = entry.getKey();
        Optional.ofNullable(template.template()).map(Template::aliases).ifPresent(aliases::add);
    public static String findV2Template(Metadata metadata, String indexName, boolean isHidden) {
            return Collections.emptyList();
            return;
        public PutRequest create(boolean create) {
                })
        CollectionUtil.timSort(matchedTemplates, Comparator.comparingInt(IndexTemplateMetadata::order).reversed());
    private final IndicesService indicesService;
                        ? "with component templates " + finalIndexTemplate.composedOf() + " "
                    );
                resolvedAliases.add(aliasMeta);  
        }  
            return false;
            CompressedXContent mappings = innerTemplate.mappings();  
                return removeIndexTemplateV2TaskKey;  
     * Resolve the given v1 templates into an ordered list of aliases
                    return createComponentTemplateTaskKey;
     * Based on the provided checkPriority and priority parameters this aims to report the overlapping
                            e
            return currentState;  
        if (isHidden == null) {  
            + "] that did not exist in the cluster state";
            );  
        Settings.Builder templateSettings = Settings.builder();
                if (templatedIsHidden) {  
    // Package visible for testing  
            public ClusterState execute(ClusterState currentState) {  
        final Predicate<String> patternMatchPredicate = pattern -> Regex.simpleMatch(pattern, indexName);  
        if (name.startsWith("_")) {
    private static String getTimestampFieldMapping(String timestampFieldName) {  
    public static List<CompressedXContent> collectMappings(final ClusterState state, final String templateName, final String indexName)  
 * Service responsible for submitting index templates updates
                    + newlyUnreferenced  
        final IndexMetadata tmpIndexMetadata = stateWithIndex.metadata().index(temporaryIndexName);  
        }  
        }
     * The PUT response.
import org.opensearch.index.translog.Translog;
                }  
import org.opensearch.common.UUIDs;
                    + newTemplate.indexPatterns()  
                @Override
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, shardReplicas)  
                }  
        // mappings, and aliases are valid after it's been composed with the component templates  
        }
                    listener.onFailure(e);  
        Optional<Template> maybeTemplate = Optional.ofNullable(template);
        }  
            + "\": {\n"  
    /**
        final ComposableIndexTemplate template = metadata.templatesV2().get(templateName);
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            );  
        assert template != null : "attempted to resolve settings for a template ["
        }
        }
import org.opensearch.indices.IndexTemplateMissingException;  
            String warning = String.format(  
                "index template [" + name + "] specifies component templates " + missingComponentTemplates + " that do not exist"  
                    listener.onFailure(e);  
            );
            validateIndexTotalPrimaryShardsPerNodeSetting(settings, clusterService);  
        final ComponentTemplate existing = currentState.metadata().componentTemplates().get(name);
            throw new IllegalArgumentException(  
import org.opensearch.Version;  
     * exception will be thrown if the component template already exists
        public boolean acknowledged() {  
        Settings validateSettings,
            }
     */
            .build();
            String stringMappings = mappings == null ? null : mappings.string();
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;  
            "create-component-template [" + name + "], cause [" + cause + "]",
            for (Map.Entry<String, String> entry : mappings.entrySet()) {
        }
        }
        final boolean create,  
                    .put(IndexMetadata.builder(temporaryIndexName).settings(finalResolvedSettings))
    }  
     */
            throw new IllegalArgumentException("index_template [" + request.name + "] already exists");  
        templates.forEach(template -> {  
                for (String templateName : templateNames) {
                    + "], composed of component templates ["  
                    if (Regex.isMatchAllPattern(name)) {
 */
                name,
        final String name;
                }
            List<CompressedXContent> mappings = collectMappings(stateWithIndex, templateName, indexName);
        public PutRequest version(Integer version) {  
import org.opensearch.common.logging.HeaderWarning;
import java.util.Comparator;  
import org.opensearch.common.util.set.Sets;  
                if (checkPriority == false || priority == template.priorityOrZero()) {
            validationErrors.add("name must not contain a ','");
            if (Regex.simpleMatch(p1Array, p2.replace("*", ""))) {  
                return ClusterState.builder(currentState).metadata(metadata).build();  
                name,  
        if (overlaps.size() > 0) {
     *                 of template application results in a hidden index, then global templates will
            ClusterState tempStateWithComponentTemplateAdded = ClusterState.builder(currentState)  
        final boolean create,
                        return currentState;
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        void onResponse(RemoveResponse response);  
            .map(componentTemplates::get)
        final ComponentTemplate finalComponentTemplate = new ComponentTemplate(finalTemplate, template.version(), template.metadata());  
        if (template == null || template.getDataStreamTemplate() == null) {
        return false;
                    "global composable templates may not specify the setting " + IndexMetadata.INDEX_HIDDEN_SETTING.getKey()
        validateTemplate(  
    private static Alias toAlias(AliasMetadata aliasMeta) {
        if (template == null) {
    }  
        assert template != null : "attempted to resolve mappings for a template ["  
        // Find data streams that are currently unreferenced  
        for (Map.Entry<String, ComposableIndexTemplate> entry : metadata.templatesV2().entrySet()) {
            // fail with index missing...
        boolean clusterPluggableDataFormatEnabled,
            }
 * Modifications Copyright OpenSearch Contributors. See  
                if (isNotMatchAllTemplate) {
    }
                    throw new IllegalStateException(
            }
        this.threadPool = threadPool;  
                    logger.info("removing component template [{}]", templateName);  
import java.util.Map;  
            this.clusterManagerTimeout = clusterManagerTimeout;
            validateTranslogFlushIntervalSettingsForCompositeIndex(settings, clusterService.getClusterSettings());
            finalSettings = Settings.builder().put(finalSettings).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX).build();  
                    throw new IndexTemplateMissingException(request.name);
     * to produce its "minimum matching string". If that minimum string matches any pattern in the other
            int dummyPartitionSize = IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.get(settings);  
        }
        IndexTemplateMetadata existingTemplate = currentState.metadata().templates().get(request.name);  
    /**
        if (name.contains("#")) {
    ) {
            if (finalSettings != null) {
        } finally {
        try {
        // Only include timestamp mapping snippet if creating backing index.
                name
        }
    public static Map<String, List<String>> findConflictingV2Templates(
        boolean create;  
            template.priorityOrZero()
     * generated by the composable template and all of its component templates contains valid  
    /**
        // Mappings in component templates don't include _doc, so update the mappings to include this single type
        createComponentTemplateTaskKey = clusterService.registerClusterManagerTask(CREATE_COMPONENT_TEMPLATE, true);
        return Collections.unmodifiableList(aliases);
     * @opensearch.internal
        );
            }
                    return masterTimeout;
                listener.onFailure(e);  
                name,
     * names. The minimum-string heuristic restricts conflict detection to cases where "natural" index  
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
    ) {
                );  
                    + " of a composable template at index creation time",  
    }
            validationErrors.add("name must be lower cased");
                    name,
                if (templateNames.isEmpty()) {
            templateBuilder.putAlias(aliasMetadata);  
                final Optional<IndexTemplateMetadata> templateWithHiddenSettingPostRemoval = matchedTemplates.stream()
            }
            Settings finalSettings = innerTemplate.settings();  
     * A remove Request.  
        createIndexTemplateTaskKey = clusterService.registerClusterManagerTask(CREATE_INDEX_TEMPLATE, true);  
        }
            new ClusterStateUpdateTask(Priority.URGENT) {  
                validationErrors.add("global templates may not specify the setting " + IndexMetadata.INDEX_HIDDEN_SETTING.getKey());
                @Override
                    logger.debug(
        if (newlyUnreferenced.size() > currentlyUnreferenced.size()) {
            }  
                @Override
     */
                    if (validationFailure == null) {  
        final ClusterState currentState,
                    + " cannot be removed as they are still in use by index templates "  
    /**  
            .metadata(Metadata.builder(currentState.metadata()).put(name, finalComponentTemplate))  
            .map(ComponentTemplate::template)  
        // Validate all composable index templates that use this component template
                Locale.ROOT,  
                    overlappingTemplates.put(name, template.indexPatterns());  
                    try {
                    + SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey()
     * if the {@code cluster.remote_store.index.restrict.async-durability} is set to true.
                .ifPresent(mappings::add);  
        }
            );  
        NamedXContentRegistry xContentRegistry,
            indexPatterns,  
                    + (finalIndexTemplate.composedOf().size() > 0
                && clusterPluggableDataFormatValue.isEmpty() == false
                            + "] because the following global templates would resolve to specifying the ["  
                finalIndexTemplate,
    private void validate(String name, Template template, List<String> indexPatterns) {
                throw new MapperParsingException("Failed to parse mapping: {}", e, request.mappings);
        if (indexPatterns.stream().anyMatch(Regex::isMatchAllPattern)) {  
        templateBuilder.order(request.order);
                        + " as they are in use by a data streams "
        );
     * Collect the given v2 template into an ordered list of mappings.
 * GitHub history for details.
     * Validates {@code index.translog.durability} is not async with the incoming index template  
    }
        if (isContextAllowed
            finalSettings,
        if (clusterPluggableDataFormatEnabled && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(resolvedSettings) == false) {
 */  
            return;  
        return ClusterState.builder(currentState)
            return null;
        final List<Map<String, AliasMetadata>> resolvedAliases = new ArrayList<>();
        String[] p2Array = patterns2.toArray(Strings.EMPTY_ARRAY);
            && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(resolvedSettings) == false) {
    private void validate(PutRequest putRequest) {
                temporaryIndexName,
import java.util.List;
                "index template [" + name + "] specifies a component templates which can only be used in context."  
        String clusterPluggableDataFormatValue  
                indexScopedSettings.validate(settings, true);  
                if (matchingTemplate == null) {
        String mappings,
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            String indexName = DataStream.BACKING_INDEX_PREFIX + temporaryIndexName;
            // Mappings in index templates don't include _doc, so update the mappings to include this single type  
    }
            }  
        ComposableIndexTemplate template,  
    }
    ) {
            );
                    unreferenced.add(dataStream);  
                    if (meta.templatesV2().get(matchingTemplate).getDataStreamTemplate() == null) {
        final List<String> indexPatterns
        final boolean searchSpecificVersion = !Context.LATEST_VERSION.equals(context.version());  
     * with the given v2 template's index patterns.
                xContentRegistry,
        final String cause,
                        .startObject()
                @Override
        }  
            listener.onFailure(e);
                        templateNames.add(templateName);
            ValidationException validationException = new ValidationException();
            );  
        );  
    }  
                        throw new MapperParsingException("Failed to parse mapping [{}]: {}", e, entry.getKey(), e.getMessage());
        }
                        // global templates don't support configuring the `index.hidden` setting so we don't need to resolve the settings as  
    }
import java.util.Locale;
        Metadata metadata,
/*  
        }
        validate(name, finalComponentTemplate);
                }
        IndexTemplateMetadata.Builder templateBuilder  
            @Override  
                "index template ["
import org.opensearch.index.IndexSettings;
        if (settings == null) {
        // Add the actual index template's aliases now if they exist  
            int shardReplicas = settings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
import java.util.stream.Collectors;
                request.name,
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        // If we found any data streams that used to be covered, but will no longer be covered by
                }  
import org.opensearch.index.mapper.MapperParsingException;
        String[] p1Array = patterns1.toArray(Strings.EMPTY_ARRAY);
            finalResolvedSettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);
                .orElse(Collections.emptyMap())
                    ComposableIndexTemplate templateV2 = entry.getValue();
        final Metadata updatedMetadata = Metadata.builder(state.metadata()).put(templateName, newTemplate).build();
            }
            .filter(Objects::nonNull)
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
     */  
    private void validate(String name, @Nullable Settings settings, List<String> indexPatterns, List<Alias> aliases) {
            if (IndexMetadata.INDEX_HIDDEN_SETTING.exists(mergedSettings)) {
            return;
        // a restored index cluster state that modified a component template used by this global template such that it has this setting)
                .filter(template -> IndexMetadata.INDEX_HIDDEN_SETTING.exists(template.settings()))
            if (isHidden == null || isHidden == Boolean.FALSE) {
        final String candidateName,  
                template.getDataStreamTemplate(),
                public ClusterState execute(ClusterState currentState) throws Exception {  
                        new CompressedXContent(entry.getValue());
            validate(request);
                }
                .collect(Collectors.toList())  
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
            indicesService,
     * the event that no templates are matched, {@code null} is returned.
    public static class PutRequest {  
                }  
    private void validate(String name, ComposableIndexTemplate template) {  
            finalResolvedSettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), clusterPluggableDataFormatValue);  
            for (String dataStream : dataStreams) {  
        return matches;
import org.opensearch.core.index.Index;
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)  
        }
        }
    public ClusterState addIndexTemplateV2(  
    /**  
        // Flag for whether this is updating an existing template or adding a new one
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX_TEMPLATE_V2;  
        overlaps.remove(name);  
        // we will fail and the user will have to update the index template and remove this setting or update the corresponding component
        ComposableIndexTemplate winner = null;
        }  
                finalTemplate,  
                dummyPartitionSize == 1 ? 1 : dummyPartitionSize + 1  
            finalIndexTemplate = new ComposableIndexTemplate(
                        : "")  
                if (parsedMappings.size() > 0) {  
            IndexTemplateMetadata template = cursor.getValue();  
        removeIndexTemplateV2TaskKey = clusterService.registerClusterManagerTask(REMOVE_INDEX_TEMPLATE_V2, true);  
            } else {  
        }
            name,
        Map<String, List<String>> overlappingTemplates = new HashMap<>();
            return this;
        final Template finalTemplate = new Template(
            .templatesV2()
            clusterPluggableDataFormatEnabled,
                return removeComponentTemplateTaskKey;
        Settings settings = validateSettings;  
     * supports simple regex wildcards for removing multiple component templates at a time.  
                return removeIndexTemplateTaskKey;
            // adding this template last, since timestamp field should have highest precedence:
        }
    }
        final IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder(request.name);
            clusterPluggableDataFormatValue
     * no unreferenced data streams. Note that this scenario is still possible
        if (durability.equals(Translog.Durability.ASYNC)) {  
                    matchedTemplates.removeIf(current -> current.patterns().stream().anyMatch(Regex::isMatchAllPattern));
            this.mappings = mappings;  
        if (create == false && finalSettings != null) {
        for (Alias alias : request.aliases) {  
                );
                    + newTemplate.priority()
        if (mappings != null) {
                        "A global index template ["
        // creation anyway (no data format), so there is nothing to reject here.
                .build();
    ) throws Exception {  
        IndicesService indicesService,  
            }
                Set<String> templateNames = new HashSet<>();
     * Remove the given index template from the cluster state. The index template name
            // setting index:true is rejected here rather than failing every index the template creates.
                template.priority(),
            throw new IndexTemplateMissingException(name);
        final TimeValue masterTimeout,
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_INDEX_TEMPLATE_V2;  
        private final boolean acknowledged;  
        componentSettings.forEach(templateSettings::put);
        int shardReplicas = resolvedSettings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
            validateCompositeTemplate(
                        indexPatterns,  
    /**
    private final ClusterManagerTaskThrottler.ThrottlingKey createIndexTemplateV2TaskKey;
        Alias a = new Alias(aliasMeta.alias());
            );  
            }
            }
        if (indexName.startsWith(DataStream.BACKING_INDEX_PREFIX)) {
     * hidden indices, a template with a match all pattern or global template will not be returned.
                referredComponentTemplates.add(systemTemplateUsed);
        }  
import org.opensearch.cluster.ClusterState;
        }  
            @Override
            return acknowledged;
            new ClusterStateUpdateTask(Priority.URGENT) {  
    ) {
        }
        final ComposableIndexTemplate existing = currentState.metadata().templatesV2().get(name);  
     */
            @Override
            if (templateWithHiddenSetting.isPresent()) {
            MetadataCreateIndexService.resolveAndValidateAliases(  
     */
 *
import java.util.Collections;
                final boolean templatedIsHidden = IndexMetadata.INDEX_HIDDEN_SETTING.get(templateWithHiddenSetting.get().settings());
        return ClusterState.builder(currentState).metadata(metadata).build();  
import static org.opensearch.common.util.concurrent.ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME;
        IndicesService indicesService,  
                .values()  
            .map(Template::settings)  
     */  
     * templates with the same priority as the given priority parameter (this is useful when trying to  
        for (Alias alias : aliases) {  
        a.searchRouting(aliasMeta.searchRouting());  
                    if (Regex.isMatchAllPattern(request.name)) {
                    + String.join(",", winner.composedOf())
        this.xContentRegistry = xContentRegistry;
            }  
                template.metadata(),
                    + "existing templates [%s] with patterns (%s) that have the same priority [%d], multiple index templates may not "
    }  
            // pluggable index would see it — unless the template opts out explicitly — so that a field  
    public interface RemoveListener {
            indicesService,  
     * @return a list of templates sorted by {@link IndexTemplateMetadata#order()} descending.
import org.opensearch.common.regex.Regex;  
                long priority = template.priorityOrZero();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                }
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)  
            validateRefreshIntervalSettings(settings, clusterService.getClusterSettings());  
        }
        public boolean acknowledged() {  
            return acknowledged;
            validationErrors.add("name must not start with '_'");
            .map(ComponentTemplate::template)
        final String candidateName,  
        String mappings = null;
    }
     * @param requestSettings settings passed during template creation  
            }  
                }  
                    // remove the global templates
            // configured there is no format to validate against; such an index cannot start its shards at
import org.opensearch.index.IndexService;  
import org.opensearch.cluster.service.ClusterService;
        return templateSettings.build();
        Optional.ofNullable(componentTemplate).map(ComponentTemplate::template).map(Template::settings).ifPresent(templateSettings::put);
    }
    /**  
                Strings.collectionToCommaDelimitedString(overlaps.keySet()),  
     * index templates with the same priority).
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, shardReplicas)
        if (create && existing != null) {
                    .build()  
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_COMPONENT_TEMPLATE;
import java.io.IOException;
                template.composedOf(),
                final boolean matched = template.patterns().stream().anyMatch(patternMatchPredicate);  
        }
        final Predicate<String> patternMatchPredicate = pattern -> Regex.simpleMatch(pattern, indexName);
        Settings.Builder templateSettings = Settings.builder();
        Function<Metadata, Set<String>> findUnreferencedDataStreams = meta -> {
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_INDEX_TEMPLATE;
            final ComposableIndexTemplate template = entry.getValue();
            // For each data stream that we have, see whether it's covered by a different
        removeComponentTemplateTaskKey = clusterService.registerClusterManagerTask(REMOVE_COMPONENT_TEMPLATE, true);
            Exception validationFailure = null;  
                "composable template ["
            );
            if (validationFailure != null) {
                    );
            }  
    /**  
            maybeTemplate.map(Template::aliases)
            throw new IllegalArgumentException("component template [" + name + "] already exists");  
            Map<String, Object> parsedMappings = MapperService.parseMapping(xContentRegistry, stringMappings);  
                finalSettings,  
        }
     * @opensearch.internal
                    + name
            }
        // if the winner template is a global template that specifies the `index.hidden` setting (which is not allowed, so it'd be due to  
                    throw new IllegalArgumentException(  
        void onFailure(Exception e);
        templateBuilder.version(request.version);  
                final boolean isNotMatchAllTemplate = template.indexPatterns().stream().noneMatch(Regex::isMatchAllPattern);
        validateV2TemplateRequest(clusterService.state().metadata(), name, template, clusterService.getClusterSettings());  
        final ClusterState state,
    /**
            }
        IndexScopedSettings indexScopedSettings,
            Settings.Builder dummySettingsBuilder = Settings.builder()
     */
                    listener.onResponse(new PutResponse(true));
            String systemTemplateUsed = findContextTemplateName(metadata, e.getValue().context());
        }
        validate(name, finalIndexTemplate);
            throw new IllegalArgumentException(error);
        // this for validating that they're still going to be valid after this component template
        return Optional.ofNullable(componentTemplate)
        Map<String, Map<String, Object>> mappingsForValidation = new HashMap<>();  
        overlaps = findConflictingV1Templates(currentState, name, template.indexPatterns());
        Settings validateSettings,
        }
        TimeValue clusterManagerTimeout = ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
    public static List<Map<String, AliasMetadata>> resolveAliases(final Metadata metadata, final String templateName) {  
                    return addIndexTemplateV2(currentState, create, name, template);
            if (stringMappings != null) {
            );
import java.util.HashSet;
            this.clusterManagerTimeout = clusterManagerTimeout;
        });
                if (template.getDataStreamTemplate() != null) {
            dummyPartitionSize == 1 ? 1 : dummyPartitionSize + 1
        }
                }  
            public void onFailure(String source, Exception e) {
            @Override
 *  
        Map<String, String> mappings,
            }
    private void validateTranslogDurabilitySettingsInTemplate(Settings requestSettings, ClusterSettings clusterSettings) {  
            throw new IllegalArgumentException("A system template can only be created/updated/deleted with a repository");
                                + name  
    /**
            }  
            }
                // templates must be consistent with regards to dependencies
        }  
        );  
        );  
                    } catch (IOException e) {
                .build();
        boolean isUpdate = currentState.metadata().templates().containsKey(request.name);
    private final ClusterManagerTaskThrottler.ThrottlingKey createComponentTemplateTaskKey;
            );
                throw new IllegalArgumentException(
                if (winner == null || priority > highestPriority) {  
            validationErrors.add("name must not contain a space");
            }
        if (templatesUsingComponent.size() > 0) {
        validate(name, template.template(), template.indexPatterns());
        public PutRequest patterns(List<String> indexPatterns) {
            );
            return unreferenced;  
                    listener.onResponse(new AcknowledgedResponse(true));  
        // Aliases are applied in order, but subsequent alias configuration from the same name is  
                for (CompressedXContent mapping : mappings) {
                        request.settings,
                for (final Map.Entry<String, AliasMetadata> cursor : template.aliases().entrySet()) {  
            .collect(Collectors.toCollection(LinkedList::new));  
        }  
                .findFirst();  
     */
        }
     *
        final boolean create,  
                if (templateWithHiddenSettingPostRemoval.isPresent() == false
                        );
     */  
                        "legacy template {} and composable template {} would overlap: {} <=> {}",  
            throw new IllegalStateException(  
            public TimeValue timeout() {  
                if (globalTemplatesThatUseThisComponent.isEmpty() == false) {
    public static boolean isSystemTemplate(ComponentTemplate componentTemplate) {
            xContentRegistry,  
            // if its a match all pattern, and no templates are found (we have none), don't  
                    + "] with index patterns "
                        xContentRegistry,
        public String getMappings() {
                MetadataIndexTemplateService.resolveAliases(stateWithIndex.metadata(), templateName),  
                    highestPriority = priority;  
                for (Throwable t : iae.getSuppressed()) {  
        public PutResponse(boolean acknowledged) {
        final String templateName,
            .put(resolvedSettings)  
            stringMappings,
    static boolean patternsActuallyOverlap(List<String> patterns1, List<String> patterns2) {  
        List<CompressedXContent> mappings = template.composedOf()
            maybeTemplate.map(Template::settings).orElse(Settings.EMPTY),
                listener.onResponse(new RemoveResponse(true));
                Metadata.Builder metadata = Metadata.builder(currentState.metadata());  
 * this file be licensed under the Apache-2.0 license or a
            + "] that did not exist in the cluster state";
                    throw new IndexTemplateMissingException(name);
                        unreferenced.add(dataStream);
                    // TODO: perhaps introduce a ComponentTemplateMissingException?
 * software distributed under the License is distributed on an
            }
            if (set.size() > 0) {  
            for (Map.Entry<String, ComposableIndexTemplate> entry : templatesUsingComponent.entrySet()) {
        }  
        }  
            "{} index template [{}] for index patterns {}",  
            return this;
                true,  
            Settings mergedSettings = resolveSettings(metadata, template);
        NamedXContentRegistry xContentRegistry,
        if (context == null) {  
/*
                matched = template.indexPatterns().stream().anyMatch(patternMatchPredicate);
     * <p>  
                public TimeValue timeout() {  
            .filter(ob -> SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE.equals(ob.toString()))
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;
                        builder.value(mapping);  
        this.indexScopedSettings = indexScopedSettings;
                "index template [%s] has index patterns %s matching patterns from "
     * {@code app-test--some_other--some-}), but these synthetic strings would never appear as real index
        public PutRequest aliases(Set<Alias> aliases) {
                .map(MetadataIndexTemplateService::toAlias)
            + " }";
                            + IndexMetadata.SETTING_INDEX_HIDDEN
            + "   }\n"
        final String name,  
    ClusterState addComponentTemplate(
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            HeaderWarning.addWarning(warning);
                for (Map.Entry<String, ComposableIndexTemplate> entry : templatesUsingComponent.entrySet()) {  
        final String name,  
            aliasValidator.validateAliasStandalone(alias);
    /**  
     * A PUT request.
            this.name = name;  
                @Override  
import org.opensearch.core.action.ActionListener;
        // template that contributes to the index template resolved settings  
    // Package visible for testing  
            public void onFailure(String source, Exception e) {  
                xContentRegistry,
        final String cause,
            name,
        // Validate index metadata (settings)
                }
        // if we're updating a component template, let's check if it's part of any V2 template that will yield the CT update invalid
    }
                );  
                    stringMappings = XContentFactory.jsonBuilder()
            }  
                overlappingTemplates.put(name, template.patterns());  
                        validationFailure = new IllegalArgumentException(
            .reduce(Sets::union);
        return Optional.ofNullable(metadata.systemTemplatesLookup())
        // setting index:true is rejected here rather than failing every index the template creates.  
import java.util.HashMap;
     * <p>
                }
                .filter(alias.filter())
        public PutRequest settings(Settings settings) {  
            String name = cursor.getKey();
                validationErrors.add("index_pattern [" + indexPattern + "] must not contain a ','");  
        final ComposableIndexTemplate template = state.metadata().templatesV2().get(templateName);
        }  
            Optional.ofNullable(template.getDataStreamTemplate())
    /**  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        // When a pluggable data format is the cluster-wide default, validate the composed mapping as a
     */
        if (templatesStillUsing.size() > 0) {
        }  
     *                 being hidden has not been explicitly requested. When {@code null} if the result
            .map(ComponentTemplate::template)
import org.opensearch.common.inject.Inject;
    }
import org.opensearch.index.mapper.MapperService;  
        return Collections.unmodifiableList(matchedTemplates);  
     * templates, throwing an error if it is still in use  
        return resolveSettings(metadata, template);
     * @param metadata The {@link Metadata} containing all of the {@link IndexTemplateMetadata} values
            // adjusted (to add _doc) and it should be validated
        try {
            );
            // straightforward as all backing indices are required to have a timestamp field
    /**
                    + name
                return true;
        for (String p1 : patterns1) {
        String name,
            xContentRegistry,
            }
                if (isNotMatchAllTemplate) {
        final boolean isContextAllowed = FeatureFlags.isEnabled(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES);
        });  
            if (indexPatterns.contains(alias.name())) {  
        }  
    public static class RemoveResponse {
    private static void validateDataStreamsStillReferenced(ClusterState state, String templateName, ComposableIndexTemplate newTemplate) {
        }).map(Map.Entry::getKey).collect(Collectors.toList());  
        // has been updated
        // apply templates, here, in reverse order, since first ones are better matching
    }
            public TimeValue timeout() {  
                "index template [%s] has index patterns %s matching patterns from "
     * Return a map of v2 template names to their index patterns for v2 templates that would overlap
        return metadata.componentTemplates().getOrDefault(contextTemplateName, null);
            // The template is unchanged, therefore there is no need for a cluster state update
        // Generate a metadata as if the new template were actually in the cluster state  
        }
                Locale.ROOT,
                        return new CompressedXContent(BytesReference.bytes(builder));
            .filter(Objects::nonNull)
            if (createdIndex != null) {
     */
                        xContentRegistry,
            }
            }
            this.name = name;  
        logger.info(
        final ComposableIndexTemplate template = metadata.templatesV2().get(templateName);
            mappings.add(0, new CompressedXContent(getTimestampFieldMapping(timestampFieldName)));
        final String clusterPluggableDataFormatValue
            && clusterPluggableDataFormatValue.isEmpty() == false
                .stream()
            }
                    + IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey()  
                name,
            Set<String> referredComponentTemplates = new HashSet<>(e.getValue().composedOf());
            Settings dummySettings = dummySettingsBuilder.build();
        // configured there is no format to validate against; such an index cannot start its shards at
    ) throws Exception {
                        request.mappings,  
                request.indexPatterns,
                @Override
            // Validate aliases
        Optional.ofNullable(template.template()).map(Template::mappings).ifPresent(mappings::add);
        final ComposableIndexTemplate template = state.metadata().templatesV2().get(templateName);
                    // is a data stream template, as it's only useful if it has a data stream definition  
        final ComponentTemplate template,  
                return masterTimeout;
        });
                        + new TreeSet<>(templateNames)  
    }
            // triggers inclusion of _timestamp field and its validation:  
                }  
                    indexPatterns,  
    ) {
            .map(componentTemplates::get)
                    return addComponentTemplate(currentState, create, name, template);
                    "index_pattern [" + indexPattern + "] must not contain the following characters " + Strings.INVALID_FILENAME_CHARS
        Metadata.Builder builder = Metadata.builder(currentState.metadata()).put(template);  
                overlaps.entrySet().stream().map(e -> e.getKey() + " => " + e.getValue()).collect(Collectors.joining(",")),
                            + templateWithHiddenSetting.get().name()  
        // Collect all the composable (index) templates that use this component template, we'll use  
            )
                listener.onFailure(e);  
                    metadata.removeTemplate(templateName);  
            }
            int dummyShards = settings.getAsInt(
            }  
            @Override
import java.util.function.Predicate;  
            final String name = entry.getKey();  
            currentState,  
                        globalTemplatesThatUseThisComponent.add(entry.getKey());
            String timestampFieldName = template.getDataStreamTemplate().getTimestampField().getName();  
            boolean matched = false;
                listener.onResponse(new AcknowledgedResponse(true));
        }
        CompressedXContent mappings = template.template().mappings();  
        }
            }
                return masterTimeout;
                MapperService mapperService = tempIndexService.mapperService();  
        if (template == null) {  
        Settings finalResolvedSettings = finalResolvedSettingsBuilder.build();
        }  
     * order since they should be provided in order of priority/order
     * add a new template, as we don't support multiple overlapping, from an index pattern perspective,
                validationErrors.add("index_pattern [" + indexPattern + "] must not contain a '#'");  
                    + templateName
                }  
     * <p>  
            .entrySet()
            this.settings = settings;
            }
        }
                        .endObject()
        if (finalComponentTemplate.equals(existing)) {
        final ComposableIndexTemplate template,  
                dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);  
                Metadata.Builder metadata = Metadata.builder(currentState.metadata());
            // Only if template has data stream definition this should be added and  
    public static Settings resolveSettings(final Metadata metadata, final String templateName) {  
                return ClusterState.builder(currentState).metadata(metadata).build();
                public TimeValue timeout() {  
    }
        }  
                stateWithIndex.metadata(),
            .stream()
        }  
        boolean checkPriority,
            .filter(componentTemplate -> componentTemplates.containsKey(componentTemplate) == false)  
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX_TEMPLATE;
        final ClusterState stateWithIndex = ClusterState.builder(stateWithTemplate)
        if (request.name == null) {
                templateNames.add(templateName);
            }
        final String cause;
                @Override  
        validateNotInUse(clusterService.state().metadata(), name);
            final IndexMetadata tmpIndexMetadata = IndexMetadata.builder(temporaryIndexName).settings(dummySettings).build();
    /**  
                return request.clusterManagerTimeout;
            metadata.removeIndexTemplate(templateName);
                }
            .map(Template::mappings)
        Map<String, List<String>> overlaps = findConflictingV2Templates(
        return "{\n"
    public void putComponentTemplate(
                for (final String templateName : currentState.metadata().templates().keySet()) {
        // First check to see if mappings are valid XContent
                    + " to no longer match a data stream template"
            .map(ctx -> findContextTemplateName(state.metadata(), ctx))
                    if (Regex.simpleMatch(request.name, templateName)) {  
        // Hard to validate settings if they're non-existent, so used empty ones if none were provided
    public static Map<String, List<String>> findConflictingV1Templates(
        templateBuilder.settings(request.settings);
import org.opensearch.common.Nullable;
        if (template.getDataStreamTemplate() != null && indexName.startsWith(DataStream.BACKING_INDEX_PREFIX)) {  
 * The OpenSearch Contributors require contributions made to  
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
                template.priorityOrZero()
                    + ", priority ["
    /**
            validationErrors.add("name must not contain a '*'");
        // Finally, right before adding the template, we need to ensure that the composite settings,
     * Given a state and a composable template, validate that the final composite template
        Translog.Durability durability = IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.get(requestSettings);
        if (winner.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)
        }
        String winnerName = null;
                                + composableTemplateName
     * For each pattern in either set, the wildcard character {@code *} is replaced with the empty string
                throw validationFailure;  
            return this;
                }  
            // dummy index resolves a format and the capability path can reject index:true. When no name is  
        final TimeValue masterTimeout,
            return mappings;
        // dummy index resolves a format and the capability path can reject index:true. When no name is  
        } catch (Exception e) {  
import java.util.Optional;
    private final ClusterManagerTaskThrottler.ThrottlingKey removeIndexTemplateV2TaskKey;  
     *  
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
                    }
        final ClusterState state,
                public void onFailure(String source, Exception e) {
            }
        Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                );  
            String error = String.format(
            && template.composedOf().stream().anyMatch(componentTemplate -> isSystemTemplate(componentTemplates.get(componentTemplate)))) {  
        final ComposableIndexTemplate template,  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            final ComponentTemplate componentTemplate = findComponentTemplate(metadata, template.context());
        Map<String, List<String>> overlappingTemplates = new HashMap<>();  
            throw new InvalidIndexTemplateException(
                // shard id and the current timestamp
                        composableTemplate,
            + "] that did not exist in the cluster state";
    ) throws Exception {
                overlaps.entrySet().stream().map(e -> e.getKey() + " => " + e.getValue()).collect(Collectors.joining(",")),
        final Set<String> componentsBeingUsed = new HashSet<>();
                "global index template ["
            .filter(Objects::nonNull)
        // ignored, so in order for the order to be correct, alias configuration should be in order
            this.cause = cause;
        a.writeIndex(aliasMeta.writeIndex());  
        validateTemplate(
                            + "]"
                    }
                currentState,  
        });  
                return innerRemoveIndexTemplateV2(currentState, name);
        final Map<String, ComponentTemplate> componentTemplates = metadata.componentTemplates();  
        final Map<String, ComponentTemplate> componentTemplates = metadata.componentTemplates();
        Map<String, List<String>> overlaps = findConflictingV2Templates(currentState, request.name, request.indexPatterns);  
                    matchedTemplates.add(template);
     */
        return Collections.unmodifiableList(resolvedAliases);  
                    // We found a template that still matches, great! Buuuuttt... check whether it
        return overlappingTemplates;  
 * Licensed to Elasticsearch under one or more contributor  
        String contextTemplateName = findContextTemplateName(metadata, context);
     * This approach is intentionally more lenient than a full automaton intersection. Full automaton
                clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
            if (patternsActuallyOverlap(indexPatterns, template.patterns())) {
        }  
                stringMappings = XContentFactory.jsonBuilder()
            this.version = version;
                        + new TreeSet<>(set)
            // We may need to normalize index settings, so do that also
        for (Map.Entry<String, ComposableIndexTemplate> entry : state.metadata().templatesV2().entrySet()) {  
import org.opensearch.common.Priority;  
                    "unable to remove composable templates "
            return this;
            return currentState;
                        matchedTemplates.add(template);  
import org.opensearch.indices.IndicesService;
        final boolean create,  
        long highestPriority = -1;  
import org.apache.logging.log4j.LogManager;  
     * Add the given index template to the cluster state. If {@code create} is true, an
    /**  
            logger.warn(warning);
    }
        }
     * A remove Response.
    }
import org.opensearch.common.util.FeatureFlags;
        if (missingComponentTemplates.size() > 0) {  
                        templateNames.add(templateName);
            // if the CT is specifying the `index.hidden` setting it cannot be part of any global template  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        if (stringMappings != null) {
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex;
        final List<String> indexPatterns
                @Override
            createdIndex = dummyIndexService.index();  
            dataStreams.stream().filter(stream -> Regex.simpleMatch(indexPattern, stream)).filter(stream -> {
        );
        updatedSettingsBuilder.put(request.settings).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
                    return masterTimeout;
                }
                    + "=true]"
            String warning = String.format(
    /**  
        }
            @Override
        createIndexTemplateV2TaskKey = clusterService.registerClusterManagerTask(CREATE_INDEX_TEMPLATE_V2, true);
                    validationErrors.add(t.getMessage());
        return templateSettings.build();  
            validationErrors.add("name must not contain a '#'");
        public RemoveResponse(boolean acknowledged) {
                Locale.ROOT,  
 *
import org.opensearch.common.settings.Settings;  
            .map(ComponentTemplate::template)
                tempIndexService.newQueryShardContext(0, null, () -> 0L, null)  
        Settings.Builder updatedSettingsBuilder = Settings.builder();  
    ) {
        final ClusterState currentState,
            .isPresent();  
        final String name;
        clusterService.submitStateUpdateTask("remove-index-template [" + request.name + "]", new ClusterStateUpdateTask(Priority.URGENT) {  
            if (settings != null && IndexMetadata.INDEX_HIDDEN_SETTING.exists(settings)) {
                validationErrors.add("index_pattern [" + indexPattern + "] must not contain a ':'");  
                Map<String, Object> parsedMappings = MapperService.parseMapping(xContentRegistry, stringMappings);
     * @opensearch.internal
                        .field(MapperService.SINGLE_MAPPING_NAME, parsedMappings)  
            }
    private final MetadataCreateIndexService metadataCreateIndexService;  
                }
            logger.info("removing index template [{}]", templateName);  
            throw new InvalidIndexTemplateException(
        clusterService.submitStateUpdateTask(
            + "         \"type\": \"date\"\n"
            existing == null ? "adding" : "updating",
     */
                    winnerName = name;
                    candidateName,
        overlappingTemplates.remove(candidateName);  
            ComposableIndexTemplate template = entry.getValue();
    public void putTemplate(final PutRequest request, final PutListener listener) {
        }
                Strings.collectionToCommaDelimitedString(overlaps.keySet()),  
        // Also carry the cluster's default data format name (mirroring MetadataCreateIndexService) so the
    public static Settings resolveSettings(final List<IndexTemplateMetadata> templates) {  
     * Return the name (id) of the highest matching index template for the given index name. In
                Set<String> templateNames = new HashSet<>();
        final Set<String> currentlyUnreferenced = findUnreferencedDataStreams.apply(state.metadata());
            final Optional<IndexTemplateMetadata> templateWithHiddenSetting = matchedTemplates.stream()
            // validate index refresh interval and translog durability settings
    private final ThreadPool threadPool;  
    /**
        }
                name,
import org.opensearch.common.xcontent.XContentFactory;
    }  
            // validate index total primary shards per node setting against the cluster (a template has no
    public static class PutResponse {
        final ComponentTemplate template
    public void removeIndexTemplateV2(
        if (validationErrors.size() > 0) {  
                template.context()  
        }
            this.indexPatterns = indexPatterns;  
            && !ClusterStateSystemTemplateLoader.TEMPLATE_LOADER_IDENTIFIER.equals(
            .filter(Objects::nonNull)  
                }
                overlaps.entrySet().stream().map(e -> e.getKey() + " => " + e.getValue()).collect(Collectors.joining(",")),
        if (create && existing != null) {
                } catch (Exception e) {
            listener.onFailure(new IllegalArgumentException("index_template must provide a template"));  
        public PutRequest order(int order) {  
    }  
        MetadataCreateIndexService metadataCreateIndexService,
        }
                && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(settings) == false) {
        Settings.Builder finalResolvedSettingsBuilder = Settings.builder()
            @Override
            throw new IllegalArgumentException(  
            try {
            .stream()
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateRefreshIntervalSettings;
     */  
                        indicesService,
                }
            .collect(Collectors.toSet());
    static void validateNotInUse(Metadata metadata, String templateNameOrWildcard) {
        int order;
     *
                public TimeValue timeout() {  
    private final NamedXContentRegistry xContentRegistry;
        if (templateNames.isEmpty()) {
            if (clusterPluggableDataFormatEnabled && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(settings) == false) {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                                + "] results in invalid composable template ["
     * A remove listener.  
            .stream()
                finalSettings = Settings.builder().put(finalSettings).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX).build();
                IndexMetadata.SETTING_NUMBER_OF_SHARDS,
                assert isHidden == Boolean.TRUE;
 */
     */
        for (final Map.Entry<String, IndexTemplateMetadata> cursor : state.metadata().templates().entrySet()) {
     * Resolve index settings for the given list of v1 templates, templates are apply in reverse  
            // template (which is great), or whether it's now uncovered by any template
        final ActionListener<AcknowledgedResponse> listener
     *  
                listener.onResponse(new AcknowledgedResponse(true));
import java.util.TreeSet;
            throw new InvalidIndexTemplateException(name, validationException.getMessage());  
        if (clusterPluggableDataFormatEnabled  
        }
     * Remove the given component template from the cluster state. The component template name
                validationErrors.add(iae.getMessage());
                name,
        Set<String> matches = new HashSet<>();  
            }
        final ClusterState state,
            @Override  
        AliasValidator aliasValidator,  
            validationException.addValidationErrors(validationErrors);
     * Checks whether two sets of index patterns practically overlap, using a minimum-string heuristic.
        Optional<Set<String>> dataStreamsUsingTemplates = templateNames.stream()
            + "     }\n"  
            @Override
                return true;  
                public void onFailure(String source, Exception e) {
import static org.opensearch.cluster.metadata.MetadataCreateDataStreamService.validateTimestampFieldMapping;  
            return this;
            }
            );
    private static Settings resolveSettings(Metadata metadata, ComposableIndexTemplate template) {
        ClusterService clusterService,
     * exception will be thrown if the component template already exists
        dataStreamsUsingTemplates.ifPresent(set -> {
        for (String indexPattern : indexPatterns) {
        Set<String> templateNames = new HashSet<>();
        return Collections.unmodifiableList(mappings);
        final List<String> templatesStillUsing = metadata.templatesV2().entrySet().stream().filter(e -> {  
                    }  
                    }
        Optional.ofNullable(template.context())
        final ClusterState stateWithTemplate = ClusterState.builder(state)  
        PutRequest request,
    }
        Optional.ofNullable(template.template()).map(Template::settings).ifPresent(templateSettings::put);
                        // no other component template can remove this setting from the resolved settings, so just invalidate this update
            .ifPresent(mappings::add);  
    static ClusterState innerPutTemplate(  
            @Override
            .orElse(null);
                            "updating component template ["
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            dummyIndexService.mapperService().merge(mappingsForValidation, MergeReason.MAPPING_UPDATE);
     * Listener for putting metadata in the template
            @Override
/*
    ) throws Exception {
        // results
            "create-index-template-v2 [" + name + "], cause [" + cause + "]",
     * Validates that the given component template is not used by any index
        validate(  
        if (overlaps.size() > 0) {
                innerTemplate.aliases()
        final String candidateName,  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.common.compress.CompressedXContent;  
                    template.patterns()
                    + "match during index creation, please use a different priority",  
 * under the License.  
                    } catch (Exception e) {
        // Add the actual index template's mappings, since it takes the next precedence
                    }  
        Settings resolvedSettings = resolveSettings(stateWithTemplate.metadata(), templateName);
            // Also carry the cluster's default data format name (mirroring MetadataCreateIndexService) so the
            + templateName  
import org.opensearch.common.unit.TimeValue;
            IndexMetadata.SETTING_NUMBER_OF_SHARDS,
            throw new InvalidIndexTemplateException(
            .map(md -> md.get(ClusterStateSystemTemplateLoader.TEMPLATE_TYPE_KEY))
     * with the given template's index patterns.
import org.opensearch.cluster.ClusterStateUpdateTask;
            return Collections.emptySet();  
                    .field(MapperService.SINGLE_MAPPING_NAME, parsedMappings)
            throw new IllegalArgumentException(
        final boolean clusterPluggableDataFormatEnabled,  
        removeIndexTemplateTaskKey = clusterService.registerClusterManagerTask(REMOVE_INDEX_TEMPLATE, true);
        void onFailure(Exception e);
                "index setting [index.translog.durability=async] is not allowed as cluster setting ["
            }
        final Set<String> newlyUnreferenced = findUnreferencedDataStreams.apply(updatedMetadata);  
                for (String templateName : templateNames) {
        throws Exception {
                    // fail with index missing...  
        final ComposableIndexTemplate template
    }
        final Set<String> dataStreams = state.metadata().dataStreams().keySet();  
                    // if its a match all pattern, and no templates are found (we have none), don't
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
    }
    ) throws Exception {
            || clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING) == false) {
            final Template finalTemplate = new Template(
        // Add the actual index template's settings now, since it takes the next precedence.  
        );
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),  
        if (request.create && isUpdate) {
        List<String> validationErrors = new ArrayList<>();  
        clusterService.submitStateUpdateTask("remove-index-template-v2 [" + name + "]", new ClusterStateUpdateTask(Priority.URGENT) {
        IndexTemplateMetadata template = templateBuilder.build();
        for (String p2 : patterns2) {
        // Add the template referred by context since it will take the highest precedence.  
                name,  
            validateSettings,  
                    try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
        }
                @Override
 * specific language governing permissions and limitations
            Optional.ofNullable(componentTemplate.template()).map(Template::aliases).ifPresent(aliases::add);  
        if (isSystemTemplate(componentTemplate)
        // use the provided values, otherwise just pick valid dummy values
    public static class RemoveRequest {
                @Override
     * @opensearch.internal
            return this;  
    @Inject
    }  
package org.opensearch.cluster.metadata;
            if (intersecting.size() > 0) {
                template.indexPatterns(),
            return Settings.EMPTY;  
        return overlappingTemplates;
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                }  
                .searchRouting(alias.searchRouting())
        // changing this template, then blow up with as much helpful information as we can muster  
        Collections.reverse(aliases);  
            if (Regex.isMatchAllPattern(name)) {
    }
            try {
import java.io.UncheckedIOException;  
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                } else {
            .stream()  
        for (int i = templates.size() - 1; i >= 0; i--) {  
            if (Strings.validFileNameExcludingAsterisk(indexPattern) == false) {
        final String name,  
                    .endObject()
            .map(Template::mappings)
    @Nullable
                    name,
            }  
    }
import org.opensearch.indices.InvalidIndexTemplateException;
     */  
    }
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        this.clusterService = clusterService;  
        if (name.contains("*")) {
                @Override
}
    }
import org.opensearch.common.settings.IndexScopedSettings;
        final TimeValue masterTimeout,
        }
                if (templateNames.isEmpty()) {
        try {
        clusterService.submitStateUpdateTask(
    /**  
     * @param indexName The name of the index that templates are being found for
        final String name,
            if (indexPattern.contains(":")) {
                .map(mapping -> {
                dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), clusterPluggableDataFormatValue);  
            validationErrors.addAll(indexSettingsValidation);  
    public MetadataIndexTemplateService(  
                indicesService,  
        int dummyShards = resolvedSettings.getAsInt(  
        this.aliasValidator = aliasValidator;
            return null;
        // Now use context mappings which take the highest precedence  
import org.opensearch.core.common.Strings;  
                        validationFailure.addSuppressed(e);
/**
     * settings, mappings, and aliases.
        private final boolean acknowledged;  
            + "       \""
        }
            }
                    );
                throw new IllegalArgumentException(
            );
                    + " from existing composable templates [%s] with patterns (%s); this template [%s] may be ignored in favor"
                    + winnerName
    }
                }
                settings,
                return true;
     * @param clusterSettings current cluster settings
        request.settings(updatedSettingsBuilder.build());
        // if the candidate was a V2 template that already exists in the cluster state it will "overlap" with itself so remove it from the
    public static List<Map<String, AliasMetadata>> resolveAliases(final List<IndexTemplateMetadata> templates) {
import org.opensearch.core.xcontent.XContentBuilder;
        if (name.contains(",")) {
        for (final IndexTemplateMetadata template : metadata.templates().values()) {
     * Resolve the given v2 template into an ordered list of aliases
import java.util.LinkedList;  
        }  
        if (overlaps.size() > 0) {
            return this;
    public void removeTemplates(final RemoveRequest request, final RemoveListener listener) {
     * Return a map of v1 template names to their index patterns for v1 templates that would overlap
        });
            } catch (Exception e) {
            settings = Settings.EMPTY;
        );
            }  
        if (request.indexPatterns == null) {
                    }
        templateBuilder.patterns(request.indexPatterns);
     * Validate that by changing or adding {@code newTemplate}, there are  
        // then we need to exclude global templates
                    if (template.patterns().stream().anyMatch(patternMatchPredicate)) {
                final String usingTemplate = findV2Template(state.metadata(), stream, false);
     */  
                    + "would cause data streams "
            }
            .filter(Objects::nonNull)
                listener.onFailure(e);
            }
        if (IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.exists(requestSettings) == false
import org.opensearch.common.settings.ClusterSettings;
            }
            .stream()  
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            }
import org.opensearch.action.admin.indices.alias.Alias;
                    }  
                throw new InvalidIndexTemplateException(  
        }
    }  
        if (template.context() != null) {
        NamedXContentRegistry xContentRegistry,  
    }
                }
        logger.info("adding template [{}] for index patterns {}", request.name, request.indexPatterns);
     * Finds index templates whose index pattern matched with the given index name. In the case of
        final String name,
                }
                    listener.onFailure(e);  
            this.acknowledged = acknowledged;  
        if (innerTemplate != null) {
 * this work for additional information regarding copyright
import java.util.Objects;
            return;  
        String clusterPluggableDataFormatValue  
            this.order = order;
                    metadata.removeComponentTemplate(templateName);
        }
        if (settings != null) {  
import java.util.function.Function;
    ) {
     * names would match both patterns simultaneously.
            finalSettings,
        Settings finalSettings = template.template().settings();
                @Override
 * not use this file except in compliance with the License.
            @Override  
                    + "] defined the index.hidden setting, which is not allowed"
            .build();
            if (indexPattern.contains(" ")) {
                    return createIndexTemplateV2TaskKey;
                    .findFirst();
        template.indexPatterns().forEach(indexPattern -> {
                Metadata.builder(stateWithTemplate.metadata())
                    "alias [" + alias.name() + "] cannot be the same as any pattern in [" + String.join(", ", indexPatterns) + "]"
            new ClusterStateUpdateTask(Priority.URGENT) {  
            // creation anyway (no data format), so there is nothing to reject here.
            AliasMetadata aliasMetadata = AliasMetadata.builder(alias.name())
     * set, the two pattern sets are considered to overlap.  
 * compatible open source license.
        this.indicesService = indicesService;
        logger.info("{} component template [{}]", existing == null ? "adding" : "updating", name);
        clusterService.submitStateUpdateTask(
    }  
            if (parsedMappings.size() > 0) {
            .metadata(Metadata.builder(state.metadata()).put(templateName, template))
            if (matched) {
        }
            .keySet()
            // use the provided values, otherwise just pick valid dummy values
            } catch (Exception e) {
 * You may obtain a copy of the License at  
     * Returns the default mapping snippet for the timestamp field by configuring it as a 'date' type.  
        }
                componentsBeingUsed.addAll(intersecting);
                for (String templateName : currentState.metadata().componentTemplates().keySet()) {
                    }  
        Template innerTemplate = template.template();  
                    "composable template {} and legacy template {} would overlap: {} <=> {}",  
        final String temporaryIndexName = "validate-template-" + UUIDs.randomBase64UUID().toLowerCase(Locale.ROOT);
     */  
        List<Settings> componentSettings = template.composedOf()
     * addition/update time  
        }  
                    matched = template.indexPatterns().stream().anyMatch(patternMatchPredicate);  
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;
            .map(Template::aliases)
            .map(templateName -> dataStreamsUsingTemplate(currentState, templateName))  
            } else {
            .map(coll -> coll.get(searchSpecificVersion ? Long.parseLong(context.version()) : coll.lastKey()))  
        }  
                    || templateWithHiddenSetting.get() != templateWithHiddenSettingPostRemoval.get()) {  
            template.indexPatterns()  
            if (indexPattern.contains(",")) {
        // Now use context referenced template's aliases which take the highest precedence  
        validate(name, template.template(), Collections.emptyList());  
            .build();
                final String matchingTemplate = findV2Template(meta, dataStream, false);
                public ClusterState execute(ClusterState currentState) throws Exception {  
            this.acknowledged = acknowledged;  
            @Override
        }
        void onResponse(PutResponse response);
            .map(ComponentTemplate::metadata)  
            .map(componentTemplates::get)  
                        tempStateWithComponentTemplateAdded,  
        if (winner == null) {
        Integer version;
        // TODO: in 8.0+, only allow updating index templates, not adding new ones  
            .collect(Collectors.toList());
     *
        a.isHidden(aliasMeta.isHidden());
        List<Alias> aliases = new ArrayList<>();  
                logger.debug(
                template.indexPatterns(),
                    );
        public PutRequest clusterManagerTimeout(TimeValue clusterManagerTimeout) {
                }  
     */
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_COMPONENT_TEMPLATE;
        if (request.mappings != null) {
        IndicesService indicesService,
                    + (newTemplate.getDataStreamTemplate() == null ? "and no data stream configuration " : "")
                }
    static String findContextTemplateName(Metadata metadata, Context context) {
     */
     */  
            }  
     * @param isHidden Whether or not the index is known to be hidden. May be {@code null} if the index  
                    if (Regex.simpleMatch(name, templateName)) {  
     */
        if (template.context() != null && findContextTemplateName(metadata, template.context()) == null) {
                .metadata(Metadata.builder(currentState.metadata()).put(name, finalComponentTemplate))
     * with the given template's index patterns.
    public interface PutListener {  
                    logger.info("removing template [{}]", templateName);
        }
            }).forEach(matches::add);  
     * intersection correctly identifies theoretical overlaps that arise only from creative wildcard usage  
            }
                clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)  
        this.metadataCreateIndexService = metadataCreateIndexService;  
                    + "existing older templates [%s] with patterns (%s); this template [%s] will take precedence during new index creation",  
                }
        }  
                "index template [" + name + "] specifies a context which is not loaded on the cluster."
                        template.indexPatterns()
            name,
    private final ClusterManagerTaskThrottler.ThrottlingKey createIndexTemplateTaskKey;  
    }  
        boolean clusterPluggableDataFormatEnabled,
                template.indexPatterns(),
            return this;
        });
            if (clusterPluggableDataFormatEnabled  
 * @opensearch.internal
        if (finalIndexTemplate.equals(existing)) {
            IndexService dummyIndexService = indicesService.createIndex(tmpIndexMetadata, Collections.emptyList(), false);
            + templateName  
            return Collections.emptyList();  
                throw new IllegalArgumentException("invalid composite mappings for [" + templateName + "]", e);  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, dummyShards)
                        return currentState;
    private final ClusterService clusterService;  
            // we validate the alias only partially, as we don't know yet to which index it'll get applied to
    }
            List<String> indexSettingsValidation = metadataCreateIndexService.getIndexSettingsValidationErrors(
        validateComponentTemplateRequest(clusterService.state().metadata().componentTemplates().get(name));
        // Create the final aggregate settings, which will be used to create the temporary index metadata to validate everything  
                        mappingsForValidation.put(entry.getKey(), MapperService.parseMapping(xContentRegistry, entry.getValue()));  
                    winner = template;
            // When a pluggable data format is the cluster-wide default, validate the mapping as a
                    aliasMeta.put(cursor.getKey(), cursor.getValue());
            public ClusterState execute(ClusterState currentState) {  
import org.opensearch.common.ValidationException;
 * KIND, either express or implied.  See the License for the
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID());  
                Map<String, AliasMetadata> aliasMeta = new HashMap<>();
        final Map<String, ComposableIndexTemplate> templatesUsingComponent = currentState.metadata()  
            }
            true,  
import org.apache.lucene.util.CollectionUtil;
                "composable template ["  
                        name,
    }  
                Strings.collectionToCommaDelimitedString(overlaps.keySet()),  
                    } else {  
        long priority  
 */
                }
        final String name,
            .stream()
     */
    static ClusterState innerRemoveIndexTemplateV2(ClusterState currentState, String name) {
                }  
        for (String templateName : currentState.metadata().templatesV2().keySet()) {  
                try {
            listener.onFailure(new IllegalArgumentException("index_template must provide a name"));
     * Return a map of v2 template names to their index patterns for v2 templates that would overlap
    /**
    private final ClusterManagerTaskThrottler.ThrottlingKey removeIndexTemplateTaskKey;
                "legacy template [%s] has index patterns %s matching patterns"
            );
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
    private static void validateCompositeTemplate(  
                threadPool.getThreadContext().getTransient(ACTION_ORIGIN_TRANSIENT_NAME)  
        if (template.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)) {  
    }
            final Set<String> unreferenced = new HashSet<>();  
                    + "is invalid",
        final ComponentTemplate componentTemplate = findComponentTemplate(metadata, template.context());
    }  
        return ClusterState.builder(currentState).metadata(Metadata.builder(currentState.metadata()).put(name, finalIndexTemplate)).build();
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
     * Add the given component template to the cluster state. If {@code create} is true, an
     */  
            HeaderWarning.addWarning(warning);
            public void onFailure(String source, Exception e) {
    static ComponentTemplate findComponentTemplate(Metadata metadata, Context context) {  
        }
        });  
    private final IndexScopedSettings indexScopedSettings;
            public TimeValue timeout() {
                stringMappings == null ? null : new CompressedXContent(stringMappings),
import org.opensearch.index.mapper.MapperService.MergeReason;
        final String temporaryIndexName = UUIDs.randomBase64UUID();  
                e
        final IndicesService indicesService,
                        "cannot update component template ["
            .metadata(  
            );
        a.indexRouting(aliasMeta.indexRouting());
        // this is complex but if the index is not hidden in the create request but is hidden as the result of template application,
            .collect(Collectors.toList());
                    + componentsBeingUsed
            + timestampFieldName
        // Find the data streams that would be unreferenced now that the template is updated/added
    private static final Logger logger = LogManager.getLogger(MetadataIndexTemplateService.class);
 *  
        }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, dummyShards)
        // pluggable index would see it — unless the template opts out explicitly — so that a field
                if (entry.getValue() != null) {  
            // create index service for parsing and validating "mappings"
        }
            @Override  
            this.aliases.addAll(aliases);  
                    .startObject()  
        } catch (Exception e) {
            // add a default mapping for the timestamp field, at the lowest precedence, to make bootstrapping data streams more
    public static List<IndexTemplateMetadata> findV1Templates(Metadata metadata, String indexName, @Nullable Boolean isHidden) {
                        .toString();
            templateSettings.put(templates.get(i).settings());
                @Override  
                    validateTemplate(
                public ClusterState execute(ClusterState currentState) throws Exception {  
                new AliasValidator(),
                        throw new UncheckedIOException(e);  
            template.template().aliases()
                .indexRouting(alias.indexRouting())  
import java.util.Set;  
            );  
            if (indexPattern.startsWith("_")) {
     * (e.g. {@code app-test-*-some-*} and {@code app-test-*-some_other-*} share the synthetic string
        validateDataStreamsStillReferenced(currentState, name, finalIndexTemplate);  
            template.indexPatterns(),
        }  
    static Map<String, List<String>> findConflictingV2Templates(
                    + "] specifies a context which cannot be used without enabling: "  
        }
    public void putIndexTemplateV2(
                if (matched) {
                        indicesService,  
            }
            }
        // We may need to normalize index settings, so do that also  
                }
        }
                    .filter(template -> IndexMetadata.INDEX_HIDDEN_SETTING.exists(template.settings()))  
        if (aliasMeta.filter() != null) {  
            return null;  
     * index templates regardless of the priority (ie. checkPriority == false) or otherwise overlapping
                final ComposableIndexTemplate composableTemplate = entry.getValue();  
        }  
                public void onFailure(String source, Exception e) {
                    + "] template after composition "  
            }
            }
                }  
     */  
                        composableTemplateName,
            throw new IllegalArgumentException("index template [" + name + "] already exists");
                Optional.empty()
            if (template.aliases() != null) {
            if (Regex.simpleMatch(p2Array, p1.replace("*", ""))) {  
        TimeValue clusterManagerTimeout = ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;  
                templateBuilder.putMapping(MapperService.SINGLE_MAPPING_NAME, request.mappings);  
                @Override  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
        if (template == null) {
    ) {  
        );  
                        clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
                indicesService.removeIndex(createdIndex, NO_LONGER_ASSIGNED, " created for parsing template mapping");  
            }
            if (isHidden == false) {
    /**  
    public static void validateV2TemplateRequest(  
            public ClusterState execute(ClusterState currentState) {
        ComposableIndexTemplate finalIndexTemplate = template;
        return winnerName;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
            logger.warn(warning);
        final Map<String, ComponentTemplate> componentTemplates = state.metadata().componentTemplates();
        public PutRequest(String cause, String name) {
            + "   \"_doc\": {\n"
     * due to snapshot restores, but this validation is best-effort at template
            String name = entry.getKey();
            validateTranslogDurabilitySettingsInTemplate(settings, clusterService.getClusterSettings());
        public RemoveRequest(String name) {
        validate(putRequest.name, putRequest.settings, putRequest.indexPatterns, putRequest.aliases);
        return findConflictingV2Templates(state, candidateName, indexPatterns, false, 0L);  
                final boolean isNotMatchAllTemplate = template.patterns().stream().noneMatch(Regex::isMatchAllPattern);  
                validationErrors.add("index_pattern [" + indexPattern + "] must not start with '_'");  
    /**
        public RemoveRequest clusterManagerTimeout(TimeValue clusterManagerTimeout) {  
        assert template != null : "attempted to resolve aliases for a template ["
            a.filter(aliasMeta.filter().string());
    ) {
        }
        final ClusterState state,
                // Check if this template is the highest priority template and used by this data stream  
        }  
                    listener.onResponse(new AcknowledgedResponse(true));  
                }
 * Unless required by applicable law or agreed to in writing,
        List<String> indexPatterns;  
        final Set<String> matchingComponentTemplates = metadata.componentTemplates()  
        }
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                    validateCompositeTemplate(
                    .toString();  
    // Package visible for testing
                }  
        }  
        if (name.toLowerCase(Locale.ROOT).equals(name) == false) {
                }
        if (finalSettings != null) {
                    }
                                + "] after templates are merged",  
        public PutRequest mappings(String mappings) {
    /**
            @Override  
            throw new IllegalArgumentException(
        final ActionListener<AcknowledgedResponse> listener
    }
public class MetadataIndexTemplateService {  
        }
            if (IndexMetadata.INDEX_HIDDEN_SETTING.exists(finalSettings)) {
                }
            }  
        };
                    }  
     *
    }
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
     * This is added at the lowest precedence to allow users to override this mapping.
        indicesService.withTempIndexService(tmpIndexMetadata, tempIndexService -> {
        final ActionListener<AcknowledgedResponse> listener
    public void removeComponentTemplate(
            if (patternsActuallyOverlap(indexPatterns, template.indexPatterns())) {  
            Set<String> intersecting = Sets.intersection(referredComponentTemplates, matchingComponentTemplates);  
        String stringMappings = mappings == null ? null : mappings.string();
                    return createIndexTemplateTaskKey;
     * @opensearch.internal  
        final ActionListener<AcknowledgedResponse> listener
            .collect(Collectors.toList());
                List<String> globalTemplatesThatUseThisComponent = new ArrayList<>();
                            + "] defined the index hidden setting, which is not allowed"
            if (Regex.simpleMatch(name, templateName)) {
            }  
            this.create = create;
     * Resolve the given v2 template into a collected {@link Settings} object
                .map(ComposableIndexTemplate.DataStreamTemplate::getDataStreamMappingSnippet)  
        final NamedXContentRegistry xContentRegistry,
