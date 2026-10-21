        validateIngestionSourceSettings(request.settings(), state);
                request.index(),
                    if (translogRepo != null) {
        this.indicesService = indicesService;
                // see: https://github.com/opensearch-project/OpenSearch/issues/1019
     * node attributes
        }
                    Map<String, Object> doc = (Map<String, Object>) docObj;
                AliasMetadata aliasMetadata = entry.getValue();
        final CreateIndexClusterStateUpdateRequest request,
                }
        // we use "i.r.a.initial_recovery" rather than "i.r.a.require|include" since we want the replica to allocate right away
     * All the requested changes are firstly validated before mutating the {@link ClusterState}.
            return;
     * Updates index settings to set replication strategy by default based on cluster level settings or remote store
    public void addAdditionalIndexSettingProvider(IndexSettingProvider provider) {
 */
        List<String> allowlist = clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST);
        // apply templates, merging the mappings into the request mapping if exists
                )
        if (translogFlushSize.compareTo(compositeIndexMaxFlushSize) > 0) {
            .filter(DiscoveryNode::isRemoteSegmentStoreNode)
            }
                    + (indexMetadata.getNumberOfReplicas() + 1)
import org.opensearch.cluster.routing.allocation.AllocationService;
     *                            creates the index
    ) throws Exception {
            );
                validateOverlap(settingsBuilder.keys(), componentTemplate.template().settings(), request.index()).ifPresent(message -> {
    }
    }
        // 5. Defaults to segment if remote store attributes on the cluster
import org.opensearch.index.translog.Translog;
                .build();
        // The replication setting is applied in the following order:
    public boolean validateDotIndex(String index, @Nullable Boolean isHidden) {
            String segmentRepo, translogRepo;
        }
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(MetadataCreateIndexService.class);
        if (settings.get(SETTING_AUTO_EXPAND_REPLICAS) != null && indexSettingsBuilder.get(SETTING_AUTO_EXPAND_REPLICAS) == null) {
            // (excess source partitions are silently never consumed) and an error when
                request.index(),
    private final ClusterManagerTaskThrottler.ThrottlingKey createIndexTaskKey;
                        if (shardsAcknowledged == false) {
     * for composite indices based on {{@code index.composite_index}}
     *
        final int routingNumShards,
import org.opensearch.index.remote.RemoteStoreCustomMetadataResolver;
     * ensuring template priority ordering is respected.
                    + "] that creates data streams only, "
                    "index.ingestion_source.decoder_type and index.ingestion_source.decoder_settings require all nodes "
        });
        assert assertNullOldType == false || Objects.isNull(existingCustomData);
                    continue;
            metadataTransformer
                    new String[] { request.index() },
        Settings.Builder settingsBuilder,
                    } else if (isMigratingToRemoteStore(clusterSettings)) {
    private final IndexScopedSettings indexScopedSettings;
        validateTranslogFlushIntervalSettingsForCompositeIndex(request.settings(), clusterSettings);
                    } else {
        if (translogFlushSize.compareTo(compositeIndexMaxFlushSize) > 0) {
        // now check that index is all on one node
                // A v2 template wasn't found, check the v1 templates, in the event no templates are
     * Validates (if this index has a dot-prefixed name) whether it follows the rules for dot-prefixed indices.
            // And either a template or create index request had:
        List<String> validationErrors = new ArrayList<>();
     */
        Map<String, String> existingCustomData = tmpImdBuilder.removeCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
            return; // No overrides needed for null, empty, or single mapping
        Map<String, DiffableStringMap> customData,
            return;
                    @SuppressWarnings("unchecked")
            if (remoteNode.isPresent()) {
        }
        final ThreadPool threadPool,
        if (index.contains("#")) {
        // And in that case the index metadata replicated to older nodes would carry unknown settings.
                resizeSourceIndex.getName(),
            ValidationException validationException = new ValidationException();
    }
import static org.opensearch.index.IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING;
                "[{}] creating index, cause [{}], templates {}, shards [{}]/[{}]",
        validateIndexSettings(request.index(), request.settings(), forbidPrivateIndexSettings);
import org.apache.logging.log4j.message.ParameterizedMessage;
    private final Set<IndexSettingProvider> indexSettingProviders = new HashSet<>();
                }
     * @param settingsBuilder index settings builder to be updated with relevant settings
            );
        }
    @Nullable
    }
                DEPRECATION_LOGGER.deprecate(
        CreateIndexClusterStateUpdateRequest request,
            throw new OpenSearchException("Unable to determine length of index name", e);
            );
            logger.log(
            // Requires consumerFactory.getSourcePartitionCount() which is added in a follow-up PR
        updateRemoteStoreFencingSetting(settingsBuilder, clusterSettings);
            return;
        final boolean silent,
            ),
 */
            // Finally, we actually add the explicit defaults prior to the template settings and the
        // Determine if the ckp would be stored as translog metadata
                xContentRegistry,
        }
        int log2NumShards = 32 - Integer.numberOfLeadingZeros(numShards - 1); // ceil(logBase2(numShards))
        List<String> validationErrors = getIndexSettingsValidationErrors(settings, forbidPrivateIndexSettings, Optional.of(indexName));
        List<CompressedXContent> templateMappings,
    public static Optional<String> validateTranslogFlushIntervalSettingsForCompositeIndex(
     * Calculates the number of routing shards based on the configured value in indexSettings or if recovering from another index
    ) throws Exception {
            );
        // Store type of `remote_snapshot` is intended to be system-managed for searchable snapshot indexes so a special case is needed here
        indexSettingsBuilder.put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), sourceMetadata.getCreationVersion())
     * @param settings the index configured settings
        return applyCreateIndexWithTemporaryService(
        final boolean forbidPrivateIndexSettings,
                ).collect(toList()),
    private final AllocationService allocationService;
     * allow any index to be split at least once and at most 10 times by a factor of two. The closer the number or shards gets to 1024
                        "index_template_multiple_match",
        Optional<DiscoveryNode> remoteNode = clusterState.nodes()
        shardLimitValidator.validateShardLimit(request.index(), indexSettings, currentState);
    /**
            throw new IllegalArgumentException(
     * Ensures this setting is only specified for remote store enabled clusters.
    // TODO : Update this check for SegRep to DocRep migration on need basis
     * {@code cluster.pluggable.dataformat.restrict.allowlist} setting, meaning it should bypass
import org.opensearch.indices.InvalidIndexNameException;
        createIndexClusterStateRequest.settings(build);
        // Check if remote store is enabled
        if (waitForActiveShards.validate(indexMetadata.getNumberOfReplicas()) == false) {
        final IndicesService indicesService,
                    + "], because it matches with template ["
        Settings indexSettings
    /**
                templatesApplied,
 * @opensearch.internal
                    validationException.addValidationErrors(
        return resolvedAliases;
                    + "] or ["
            if (minNodeVersion.before(Version.V_3_7_0)) {
    private ClusterState applyCreateIndexWithTemporaryService(
        ClusterState currentState,
            for (IndexSettingProvider provider : indexSettingProviders) {
                // If a v2 template was found, it takes precedence over all v1 templates, so create
     */
            }
            templates.stream().map(IndexTemplateMetadata::getName).collect(toList()),
        validateTranslogRetentionSettings(indexSettings);
        // Also, older nodes would silently fall back to the default mapping while the user configured
        ClusterSettings clusterSettings
        if (!blocks.isEmpty()) {
            (indexService, contextAlias) -> resolveAndValidateAliases(
     * @param mappings List of mapping objects to process
            final List<String> nodesToAllocateOn = validateShrinkIndex(
            validationException.addValidationErrors(validationErrors);
        // 4. Replication type according to cluster level settings
        Settings.Builder settingsBuilder,
    ) {
        validateErrors(request.index(), validationErrors);
                // ignore this one taken from the index template
        Map<String, String> remoteCustomData = new HashMap<>();
                || s.equals("index.soft_deletes.enabled")) && indexSettingsBuilder.keys().contains(s) == false;
        }
                    additionalIndexSettings.remove(explicitSetting);
        try {
        final String initialRecoveryIdFilter = IndexMetadata.INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING.getKey() + "_id";
        // once we are allocated.
            indexReplicationType = INDEX_REPLICATION_TYPE_SETTING.get(combinedTemplateSettings);
        if (isAllowedForPluggableDataFormat(indexName, clusterSettings)) {
        }
                || s.startsWith("index.sort.")
        this.aliasValidator = aliasValidator;
                activeShardsObserver.waitForActiveShards(
                }
    }
        // combination the restore path itself must reject, with a SnapshotRestoreException. Validating it here instead
import org.apache.logging.log4j.Level;
    /**
            return Optional.empty();
        }
                IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(),
     * Also validates that mapper_settings keys are recognized for the configured mapper_type.
    ) throws IOException {
        // Read the raw value rather than going through INDEX_REMOTE_STORE_ENABLED_SETTING.get(). That setting carries a
            );
            // request settings, so that the precedence goes:
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
            );
        if (Strings.isEmpty(customPath) == false) {
        if (indexName.isEmpty() || indexName.get().charAt(0) != '.') {
 * SPDX-License-Identifier: Apache-2.0
                        + Version.V_3_8_0
        @Nullable IndexMetadata sourceMetadata,
        if (type == ResizeType.SHRINK) {
    ) {
        if (source.getParentDataStream() != null
                }
     */
                // the context is only used for validation so it's fine to pass fake values for the
        final int routingNumShards;
            // "index.mysetting": null
                    sourceIndex,
            for (Map.Entry<String, AliasMetadata> entry : templateAliasConfig.entrySet()) {
import org.opensearch.index.IndexSettings;
            searchReplicaValidationError.ifPresent(validationErrors::add);
    ) throws Exception {
                .searchRouting(alias.searchRouting())
     * Given the state and a request as well as the metadata necessary to build a new index,
            request.index()
                    );
                public void onFailure(String source, Exception e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return sourceMetadata;
                        settingsBuilder.put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, translogRepo);
        final boolean remoteStoreEnabled = current.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false);
            );
        List<Map<String, AliasMetadata>> templateAliases,
    }
        ClusterBlocks.Builder blocks = createClusterBlocksBuilder(currentState, indexName, clusterBlocks);
    }
        ByteSizeValue compositeIndexMaxFlushSize = clusterSettings.get(
    ) throws Exception {
                    validationException.addValidationError(message);
            indexReplicationType = INDEX_REPLICATION_TYPE_SETTING.get(requestSettings);
    Template applyContext(
import org.opensearch.action.support.ActiveShardsObserver;
     * @param mappings a list of all mapping definitions to apply, in order
            tmpImdBuilder.context(request.context());
     * <p>
     */
     * @param templatesApplied a list of the names of the templates applied, for logging
import org.opensearch.index.IndexModule;
        }
        Supplier<Version> minNodeVersionSupplier = () -> clusterService.state().nodes().getMinNodeVersion();
            clusterService.getClusterSettings()
        for (final String key : settings.keySet()) {
                    + "]"
                    request.index(),
                }
        final Settings.Builder builder = Settings.builder();
import org.opensearch.index.shard.IndexSettingProvider;
                if (templateSettings.keys().contains(explicitSetting) && templateSettings.get(explicitSetting) == null) {
        final IndexMetadata sourceMetadata,
            indexSettingsBuilder.putNull(initialRecoveryIdFilter);
                    + "or other file systems instead."
                mappings.add(MapperService.parseMapping(xContentRegistry, componentTemplate.template().mappings().toString()));
        final Settings current = settingsBuilder.build();
        MapperService mapperService = indexService.mapperService();
     */
                    "cannot resize the write index [%s] for data stream [%s]",
    private final Settings settings;
 *
            // now that the mapping is merged we can validate the index sort.
                    continue; // Skip null mappings
                    + SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey()
    static IndexMetadata buildIndexMetadata(
 * The OpenSearch Contributors require contributions made to
        return indicesService.<ClusterState, Exception>withTempIndexService(temporaryIndexMeta, indexService -> {
        List<CompressedXContent> templateMappings = MetadataIndexTemplateService.collectMappings(currentState, templateName, indexName);
                if (templateMapping.isEmpty()) {
            assert request.resizeType() != null;
import org.opensearch.common.unit.TimeValue;
            // of if the source shards are divisible by the number of target shards
                .getAsLong();
                indexService.newQueryShardContext(0, null, () -> 0L, null)
        final boolean isHiddenAfterTemplates = IndexMetadata.INDEX_HIDDEN_SETTING.get(aggregatedIndexSettings);
        applyDisableObjectsOverrides(result);
            return;
                if (aliasMetadata.alias().contains("{index}")) {
        indexSettingsBuilder.put(SETTING_INDEX_UUID, UUIDs.randomBase64UUID());
                    throw validationException;
     * @param clusterSettings cluster setting
                if (docObj instanceof Map) {
                    + "] to continue using the context for index: "
                );
        // now, update the mappings with the actual source
        }
        if (mappings.isEmpty() == false) {
    ) {
                    doc.put("disable_objects", finalDisableObjectsValue);
        );
            }
        }
        validateIndexOrAliasName(index, InvalidIndexNameException::new);
                }
import java.util.List;
            return clusterStateCreateIndex(currentState, request.blocks(), indexMetadata, allocationService::reroute, metadataTransformer);
        DocumentMapper mapper = documentMapperSupplier.get();
                )
        }
                settingsBuilder.put(componentTemplate.template().settings());
            mappingsMetadata.put(mapper.type(), mappingMd);
     * Later mappings in the list override earlier ones for the disable_objects setting,
        if (indexSettingsBuilder.get(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey()) == null) {
        return Optional.empty();
        if (remoteStoreCustomMetadataResolver == null) {
        // 2. Explicit index creation request parameter
                    temporaryIndexMeta.context()
        return tempMetadata;
        return rerouteRoutingTable.apply(updatedState, "index [" + indexName + "] created");
            }
        int indexRemoteCapablePrimaryShardsPerNode = INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);
            if (systemIndices.isSystemIndex(name)) {
    /**
            if (INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(indexSettings) > 0
                    assert indexScopedSettings.isPrivateSetting(key) : key;
public class MetadataCreateIndexService {
                );
            if (numAllocations == numShards) {
        }
        validate(request, currentState);
                @Override
                    + "] cannot differ from cluster default ["
     * @param requestSettings settings passed in during index create/update request
     * @param request the create index request
            throw exceptionCtor.apply(index, "must not contain the following characters " + Strings.INVALID_FILENAME_CHARS);
    public static int calculateNumRoutingShards(int numShards, Version indexVersionCreated) {
                    aliasMetadata = AliasMetadata.newAliasMetadata(aliasMetadata, templatedAlias);
                .writeIndex(alias.writeIndex())
        if (index.equals(".") || index.equals("..")) {
        final int routingNumShards = getIndexNumberOfRoutingShards(aggregatedIndexSettings, sourceMetadata);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
            throw new IllegalArgumentException(
            (indexService, contextAlias) -> resolveAndValidateAliases(
        final ClusterState currentState,
            templates.stream().map(IndexTemplateMetadata::name).collect(Collectors.toList())
     */
                            logger.debug(
        if (validationErrors.isEmpty() == false) {
                routingNumShards = calculateNumRoutingShards(numTargetShards, indexVersionCreated);
            && IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.exists(current) == false
        Context context
        if (mappings == null || mappings.size() <= 1) {
    ) {
         */
        return validationErrors;
                routingNumShards = IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(indexSettings);
        if (sourceMetadata.getNumberOfShards() == 1) {
        if (clusterSettings.get(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING) == false) {
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
            && clusterSettings.get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(RemoteStoreNodeService.CompatibilityMode.STRICT))
            }
    private final boolean forbidPrivateIndexSettings;
    private final List<IndexCreationValidator> indexCreationValidators = new ArrayList<>();
                        + "]"
        final ClusterState clusterState
                    + "=true]"
            }
    }
        }
        logger.debug(
                    tmpSettingsBuilder.build(),
        // Version check for mixed cluster compatibility
            || indexSettings.get(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey()) == null) {
        for (ShardRouting routing : table.shardsWithState(ShardRoutingState.STARTED)) {
    /**
        }
                resizeIntoName,
                remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, Boolean.toString(true));
    static void applyDisableObjectsOverrides(List<Map<String, Object>> mappings) {
        IngestionMessageMapper.validateSettings(mapperType, mapperSettings);
                String.format(
    }
     * @param assertNullOldType flag to verify that the old remote store path type is null
     * <p>
        }
        if (request.context() != null) {
                    + waitForActiveShards
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());
            }
            : null;
    static void validateSplitIndex(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {
     * created index needs to be gte than the maximum term in the source index).
     * This is used during update index settings flow
            return;
            throw new IllegalArgumentException(
     * the ones inherited from the templates
     * @param request the index creation cluster state update request
import org.opensearch.core.action.ActionListener;
            prepareResizeIndexSettings(
            indexSettingsBuilder.put(SETTING_NUMBER_OF_SHARDS, INDEX_NUMBER_OF_SHARDS_SETTING.get(settings));
    public static void validateRefreshIntervalSettings(Settings requestSettings, ClusterSettings clusterSettings) {
    /**
                request.cause(),
            validationErrors::add
     * @param silent a boolean for whether logging should be at a lower or higher level
        // Partition strategy validation. The setting key itself was introduced in V_3_7_0; reject any explicit
        // 1. Strictly SEGMENT if cluster is undergoing remote store migration
        } else if (INDEX_REPLICATION_TYPE_SETTING.exists(requestSettings)) {
            // also from the template and request settings, so that from the newly create index's
        }
                    request.waitForActiveShards(),
                updateIndexMappingsAndBuildSortOrder(indexService, request, updatedMappings, sourceMetadata, indexCreationValidators);
                .equals(clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)) == false) {
import org.opensearch.cluster.ack.CreateIndexClusterStateUpdateResponse;
     */
        Settings combinedTemplateSettings,
    /**
    }
                        + minNodeVersion
                currentState,
            final String name = request.dataStreamName() != null ? request.dataStreamName() : request.index();
                } else if (setting.getProperties().contains(Setting.Property.NotCopyableOnResize)) {
                nodesToAllocateOn.add(entries.getKey());
        String requestMappings,
                indexMetadata.getNumberOfShards(),
        final ClusterState currentState,
        int routingNumShards = getIndexNumberOfRoutingShards(aggregatedIndexSettings, null);
        if (hasDisableObjects) {
    }
     * the timeout, then {@link CreateIndexClusterStateUpdateResponse#isShardsAcknowledged()} will
                    + "use create data stream api instead"
        ClusterSettings clusterSettings,
            null,
        return blocksBuilder;
                    + IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey()
        if (byteCount > MAX_INDEX_NAME_BYTES) {
            if (componentTemplate.template().settings() != null) {
                "store_type_setting",
        List<String> nodesToAllocateOn = new ArrayList<>();
        if (sourceMetadata == null || sourceMetadata.getNumberOfShards() == 1) {
            throw new IllegalArgumentException("validator must not be null");
                .max()
import java.util.function.Predicate;
        }
    public static List<Map<String, Object>> collectV2Mappings(
     * templates.
            ),
            }
    }
                }
import org.opensearch.common.Priority;
        return applyCreateIndexWithTemporaryService(
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
            nodesToNumRouting.computeIfAbsent(routing.currentNodeId(), (s) -> new AtomicInteger(0)).incrementAndGet();
                        + "] or later, but the minimum node version is ["
package org.opensearch.cluster.metadata;
     * {@link IndexTemplateMetadata#order()}). This merging makes no distinction between field
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
import org.opensearch.index.compositeindex.CompositeIndexValidator;
        if (isRestoreFromSnapshot && sseEnabledIndex != null) {
        }
     * index meta data is provided (this represents the case where we're shrinking/splitting an index and the primary term for the newly
        }
                        aliasMetadata.filter().uncompressed(),
                "index specifies a context which cannot be used without enabling: "
                    );
                    templateSettings.remove(explicitSetting);
        IndexMetadata tmpImd = buildAndValidateTemporaryIndexMetadata(aggregatedIndexSettings, request, routingNumShards, currentState);
                Stream.concat(
        if (copySettings) {
                .stream()
     * @param settingsBuilder index settings builder to be updated with relevant settings
            // Hidden indices apply templates slightly differently (ignoring wildcard '*'
            // Explicit Defaults -> Template -> Request -> Necessary Settings (# of shards, uuid, etc)
            );
                    indexService.mapperService()::documentMapper,
     * Handles the cluster state transition to a version that reflects the {@link CreateIndexClusterStateUpdateRequest}.
        if (StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.exists(requestSettings) == false
import org.opensearch.cluster.block.ClusterBlocks;
    }
        this.settings = settings;
                        logger.trace(() -> new ParameterizedMessage("[{}] failed to create", request.index()), e);
            indexService.getIndexSortSupplier().get();
        Settings requestSettings,
    /**
            }
        remoteStoreCustomMetadataResolver = RemoteStoreNodeAttribute.isSegmentRepoConfigured(settings)
     * @param clusterState state of cluster
            (indexService, contextTemplate) -> resolveAndValidateAliases(
                    Stream.of(contextAlias),
            )
            indexSettingsBuilder.put(SETTING_CREATION_DATE, Instant.now().toEpochMilli());
        validateErrors(indexName, validationErrors);
                    + templateName
            indexMetadataBuilder.putMapping(mappingMd);
        ClusterState clusterState,
         * We can not validate settings until we have applied templates, otherwise we do not know the actual settings
        if (IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(current) == false) {
    /**
                    temporaryIndexMeta.getRoutingNumShards(),
     * @param sharedDataPath the configured `path.shared_data` (if any)
                additionalIndexSettings.put(
                String.format(
                }
                @Override
            clusterService.getClusterSettings()
        return validationErrors;
import org.opensearch.index.mapper.MapperService.MergeReason;
     * Validates and creates the settings for the new index based on the explicitly configured settings via the
    }
        final List<String> templatesApplied,
        // now, put the request settings, so they override templates
            currentState,
        validateActiveShardCount(request.waitForActiveShards(), tempMetadata);
                    + "]"
 * this work for additional information regarding copyright
        String indexName,
        return validationErrors;
        );
                    "You can configure '%s' with upto '%s' for composite index",
     */
import org.opensearch.cluster.routing.ShardRoutingState;
        ClusterState currentState,
        int numSplits = log2MaxNumShards - log2NumShards;
            // prior to resolving which templates it matches
                builder.copy(key, sourceMetadata.getSettings());
        final Settings current = settingsBuilder.build();
        // with null template as applyCreateIndexRequestWithV2Template has assertions when template is null
            settings,
            try {
        for (Map<String, Object> mapping : mappings) {
        }
    }
    public static List<AliasMetadata> resolveAndValidateAliases(
    }
        if (requestSettings.hasValue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey())
        if (mapper != null) {
            .addAsNew(updatedState.metadata().index(indexName));
        if (state.metadata().hasAlias(index)) {
        final boolean silent,
        final IndexMetadata temporaryIndexMeta,
                // the context is only used for validation so it's fine to pass fake values for the
            }
        }
            );
                    throw new IndexCreationException(indexName, validationException);
        result.add(parsedRequestMappings);
import java.io.UnsupportedEncodingException;
                segmentRepo = RemoteStoreNodeAttribute.getSegmentRepoName(remoteNode.get().getAttributes());
    }
            indexMetadataBuilder.putCustom(entry.getKey(), entry.getValue());
    /**
        ClusterSettings clusterSettings,
        final Settings aggregatedIndexSettings = aggregateIndexSettings(
        List<IndexCreationValidator> indexCreationValidators
        indexSettingsBuilder.put(IndexMetadata.SETTING_INDEX_PROVIDED_NAME, request.getProvidedName());
                AutoExpandSearchReplicas.SETTING.get(settings)
            settingsBuilder.put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true);
import org.opensearch.action.admin.indices.shrink.ResizeType;
    private void normalizeRequestSetting(CreateIndexClusterStateUpdateRequest createIndexClusterStateRequest) {
        final String requestMappings,
        Settings build = updatedSettingsBuilder.put(createIndexClusterStateRequest.settings())
        if (storeTypeSetting != null && storeTypeSetting.equals(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT.toString())) {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING;
        }
                templatesAliases.put(aliasMetadata.alias(), aliasMetadata);
 * KIND, either express or implied.  See the License for the
        }
        if (!index.toLowerCase(Locale.ROOT).equals(index)) {
            throw exceptionCtor.apply(index, "must not be '.' or '..'");
        }
        }
            DEPRECATION_LOGGER.deprecate(
import org.opensearch.env.Environment;
     * Validates that the configured index data path (if any) is a sub-path of the configured shared data path (if any)
 * Modifications Copyright OpenSearch Contributors. See
                );
    /**
            settingsBuilder.put(IndexSettings.INDEX_CONTEXT_CREATED_VERSION.getKey(), componentTemplate.version());
        final Settings.Builder requestSettings = Settings.builder().put(request.settings());
     * @param indexName name of the index being created
                : null;
     * @param aliasSupplier a function that takes the real {@link IndexService} and returns a list of {@link AliasMetadata} aliases
    }
        // (the index setting is final), so stamping an explicit false would add metadata without changing semantics.
            null,
        if (index.charAt(0) == '.') {
import org.opensearch.common.settings.ClusterSettings;
    /**
            throw new InvalidIndexContextException(
        for (CompressedXContent mapping : templateMappings) {
import org.opensearch.index.remote.RemoteStorePathStrategy;
     * @return the list of resolved aliases, with the explicitly provided aliases occurring first (having a higher priority) followed by
        }
                currentState,
                    continue;
        if (IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexSettings)) {
                validationErrors.add("path.shared_data must be set in order to use custom data paths");
            if (componentTemplate.template().mappings() != null) {
            final Settings templateAndRequestSettings = Settings.builder().put(combinedTemplateSettings).put(request.settings()).build();
        // If default value (-1), no validation needed
    public void validateIndexName(String index, ClusterState state) {
     * @param clusterSettings cluster setting
    }
    /**
     * Creates an index in the cluster state and waits for the specified number of shard copies to
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;
    public static void updateRemoteStoreSettings(
            throw exceptionCtor.apply(index, "index name is too long, (" + byteCount + " > " + MAX_INDEX_NAME_BYTES + ")");
import java.util.function.BiConsumer;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        int routingNumShards = getIndexNumberOfRoutingShards(aggregatedIndexSettings, null);
            .stream()
        Map<String, Object> mappings = MapperService.parseMapping(xContentRegistry, requestMappings);
                if (mappings.isEmpty()) {
                );
 * compatible open source license.
                    "Translog retention settings "
            Collections.singletonList(mappings),
                    logger.debug(
 * the Apache License, Version 2.0 (the "License"); you may
            }
                Stream.concat(Stream.of(contextAlias), MetadataIndexTemplateService.resolveAliases(templates).stream()).collect(toList()),
    private static boolean isAllowedForPluggableDataFormat(String indexName, ClusterSettings clusterSettings) {
import org.opensearch.index.IndexCreationValidator;
                if (setting == null) {
        if ((isRemoteDataAttributePresent(nodeSettings)
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(updatedState.routingTable())
        } else {
                        + "]"
            "applying create index request using legacy templates {}",
                        + minNodeVersion
        IndexMetadata indexMetadata,
     * creation in the cluster state was successful and the requisite shard copies were started before
             * the maximum primary term on all the shards in the source index. This ensures that we have correct
    }
    ) throws Exception {
        }
                "invalid wait_for_active_shards["
            return Optional.empty();
        }
        return applyCreateIndexRequestWithV1Templates(currentState, request, silent, Collections.emptyList(), metadataTransformer);
import org.opensearch.indices.ShardLimitValidator;
                silent ? Level.DEBUG : Level.INFO,
        return nodesToAllocateOn;
            Template contextTemplate = applyContext(request, currentState, updatedMappings, tmpSettingsBuilder);
        }
        if (clusterSettings.get(IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING)
            settings,
            // If source metadata was provided, it means we're recovering from an existing index,
                        throw new IndexCreationException(indexName, validationException);
                request.mappings(),
        final IndexScopedSettings indexScopedSettings,
            throw new IllegalArgumentException("provider must not be null");
    static ClusterState clusterStateCreateIndex(
     * Validates {@code index.refresh_interval} is equal or below the {@code cluster.minimum.index.refresh_interval}.
                request.index(),
                throw new IllegalArgumentException(
            routingNumShards = sourceMetadata.getRoutingNumShards();
        Settings settings,
        // It is possible that remote custom data exists already. In such cases, we need to only update the path type
        if (sourceMetadata != null) {
            final long primaryTerm = IntStream.range(0, sourceMetadata.getNumberOfShards())
                xContentRegistry
                        }
            throw new ResourceAlreadyExistsException(state.metadata().index(targetIndexName).getIndex());
        }
                        + "They will be removed in a future version."
            // TODO: For source_partition_strategy=simple, surface a warning when numSourcePartitions > numShards
        // If we found a disable_objects value, apply it to all mappings that have a _doc section
            && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(requestSettings)
                translogRepo = RemoteStoreNodeAttribute.getTranslogRepoName(remoteNode.get().getAttributes());
        }
                    + IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey()
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        @Nullable IndexMetadata sourceMetadata,
            settingsBuilder.put(
        if (IndexMetadata.INGESTION_SOURCE_DECODER_TYPE_SETTING.exists(settings)
                return applyCreateIndexRequestWithNoTemplates(currentState, request, silent, metadataTransformer);
        // validator which cross-checks index.replication.type, and this helper also runs from snapshot restore's
        // deprecate simplefs store type:
            );
        validatePluggableDataFormatSettings(indexSettingsBuilder.build(), clusterSettings, request.index()).ifPresent(
            tmpImd,
        for (Map.Entry<String, DiffableStringMap> entry : customData.entrySet()) {
/**
            metadataTransformer.accept(builder, indexMetadata);
import org.opensearch.cluster.routing.ShardRouting;
     * in here means flipping the cluster setting only affects indices created afterwards.
            indexSettingsBuilder.put(initialRecoveryIdFilter, Strings.arrayToCommaDelimitedString(nodesToAllocateOn.toArray()));
    /**
                    additionalIndexSettings.remove(explicitSetting);
            return;
    List<String> getIndexSettingsValidationErrors(
        Map<String, AtomicInteger> nodesToNumRouting = new HashMap<>();
            // we have a source index with 1 shard and without an explicit split factor
        if (validator == null) {
import org.opensearch.index.mapper.DocumentMapper;
    static int getIndexNumberOfRoutingShards(Settings indexSettings, @Nullable IndexMetadata sourceMetadata) {
                indexSettingsBuilder,
import org.opensearch.common.UUIDs;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        final ClusterState currentState,
        // Using applyCreateIndexRequestWithV1Templates with empty list instead of applyCreateIndexRequestWithV2Template
            }
     * return true, otherwise if the operation timed out, then it will return false.
        boolean isSystem,
                    return applyCreateIndexRequest(currentState, request, false);
        // as {@code numShards * 2^x`} that is less than or equal to the maximum number of shards: 1024.
         * that will be used to create this index.
        NamedXContentRegistry xContentRegistry,
                    + "]: cannot be smaller than cluster.minimum.index.refresh_interval ["
    }
     * @return the aggregated settings for the new index
    public ClusterState applyCreateIndexRequest(
                    listener::onFailure
                    "index.ingestion_source.source_partition_strategy requires all nodes in the cluster to be on version ["
        this.shardLimitValidator = shardLimitValidator;
        final CreateIndexClusterStateUpdateRequest request,
import org.opensearch.cluster.routing.IndexRoutingTable;
        final ClusterState currentState,
            // We want to remove the explicit setting not only from the explicitly set settings, but
     * @param indexName name of index
            currentState,
            throw new IllegalArgumentException("can't shrink an index with only one shard");
        );
            );
     * Returns {@code true} if the given index name matches any prefix in the
    private ClusterState applyCreateIndexRequestWithNoTemplates(
            request,
        normalizeRequestSetting(request);
        if (IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING.exists(settings) == false) {
        if (sourceMetadata == null) {
        }
        if (FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG) == false) {
        ClusterState currentState,
     * @param clusterSettings cluster level settings
            throw new IllegalArgumentException(
    /**
                    index
import java.util.Optional;
                    + IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey()
        // Determine the path type for use using the remoteStorePathResolver.
    }
        ShardLimitValidator shardLimitValidator,
}
        IndexAbstraction source = state.metadata().getIndicesLookup().get(sourceIndex);
        }
     * {@code cluster.pluggable.dataformat} when
     * Validates {@code index.translog.flush_threshold_size} is equal or below the {@code indices.composite_index.translog.max_flush_threshold_size}
            .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID.getKey(), resizeSourceIndex.getUUID());
            // Check to see if a v2 template matched
        TimeValue clusterMinimumRefreshInterval = clusterSettings.get(IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING);
                builder.primaryTerm(shardId, primaryTerm);
     */
            Version minNodeVersion = state.nodes().getMinNodeVersion();
     * Validates the {@code index.routing.allocation.total_primary_shards_per_node} setting during index creation.
        this.indexSettingProviders.add(provider);
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
                    + "] when ["
        final IndexMetadata.Builder builder = IndexMetadata.builder(indexName);
            request,
                currentState.metadata(),
            if (mapping != null) {
        return Optional.empty();
    }
import static org.opensearch.cluster.metadata.Metadata.DEFAULT_REPLICA_COUNT_SETTING;
            );
                        "index [{}] matches multiple legacy templates [{}], composable templates will only match a single template",
 * Licensed to Elasticsearch under one or more contributor
        validateIndexName(request.index(), state);
            null,
                if (aliases.contains(new Alias(aliasMetadata.alias()))) {
        if (INDEX_NUMBER_OF_REPLICAS_SETTING.exists(indexSettingsBuilder) == false
        this.allocationService = allocationService;
    public static void validateStoreTypeSettings(Settings settings) {
        } else if (combinedTemplateSettings != null && INDEX_REPLICATION_TYPE_SETTING.exists(combinedTemplateSettings)) {
    ) {
                    source.getParentDataStream().getName()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteDataAttributePresent;
                final Setting<?> setting = indexScopedSettings.get(key);
        );
        Set<Alias> aliases,
        // to prevent a user specifying this value when creating an index
            }
        if (sourceMetadata == null) {
        }
            );
import java.io.IOException;
     * Creates the index into the cluster state applying the provided blocks. The final cluster state will contain an updated routing
                    return createIndexTaskKey;
            throw new IllegalArgumentException(
                request.aliases(),
                throw new IllegalArgumentException(
        validateContext(request);
                Optional.ofNullable(contextTemplate).map(Template::aliases).orElse(Map.of())
        }
            shardLimitValidator,
        }
     * @param requestSettings settings resulting from merging request, templates, and cluster-level defaults
            .put(IndexMetadata.SETTING_ROUTING_PARTITION_SIZE, sourceMetadata.getRoutingPartitionSize())
        } else if (remoteNode.isPresent()
            || IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.exists(requestSettings) == false
                templateMapping = Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, templateMapping.values().iterator().next());
        for (int i = aliases.size() - 1; i >= 0; i--) {
    private static Optional<String> validatePluggableDataFormatSettings(
            // copy all settings and non-copyable settings and settings that have already been set (e.g., from the request)
        // because we may want settings to be "removed" from these prior to being set on the new
            );
        final List<CompressedXContent> templateMappings,
                // shard id and the current timestamp
    }
            MetadataIndexTemplateService.resolveSettings(currentState.metadata(), templateName),
        this.awarenessReplicaBalance = awarenessReplicaBalance;
        this.xContentRegistry = xContentRegistry;
                    Locale.ROOT,
        // override-settings step - where restoring a remote-store snapshot onto a document-replication index is a
        }
        if (requestRefreshInterval.millis() == -1) {
        BiFunction<ClusterState, String, ClusterState> rerouteRoutingTable,
     * Validates {@code index.translog.durability} is not async if the {@code cluster.remote_store.index.restrict.async-durability} is set to true.
        }
        final IndexScopedSettings indexScopedSettings
                        logger.debug(() -> new ParameterizedMessage("[{}] failed to create", request.index()), e);
    }
                    + "]: cannot be greater than number of shard copies ["
                }
                    + IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey()
                )
                .isHidden(alias.isHidden())
                            );
        // NOTE: dot-prefixed index names are validated after template application, not here
        ClusterSettings clusterSettings
        }
    /**
        return routingNumShards;
        indexMetadataBuilder.context(context);
            ComponentTemplate componentTemplate = MetadataIndexTemplateService.findComponentTemplate(
    static List<String> validateShrinkIndex(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {
import static org.opensearch.node.remotestore.RemoteStoreNodeService.isMigratingToRemoteStore;
        this.forbidPrivateIndexSettings = forbidPrivateIndexSettings;
        String customPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(settings);
                "index setting [index.translog.durability=async] is not allowed as cluster setting ["
    }
            throw new InvalidIndexNameException(index, "already exists as alias");
     * @param clusterSettings cluster setting
import org.opensearch.indices.InvalidIndexContextException;
        // would pre-empt that with an IllegalArgumentException from a read that only ever wanted a boolean. Deciding
        return Optional.empty();
            Optional<String> searchReplicaValidationError = awarenessReplicaBalance.validate(
            indexScopedSettings,
     * the less default split operations are supported
    }
            currentState,
            }
     */
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        logger.info("applying create index request using existing index [{}] metadata", sourceMetadata.getIndex().getName());
                "Creating indices with soft-deletes disabled is no longer supported. "
        IndexService indexService,
        List<AliasMetadata> resolvedAliases = new ArrayList<>();
    /**
        }
        );
            silent,
            return Optional.empty();
import org.opensearch.common.Nullable;
        int numShards = sourceMetadata.getNumberOfShards();
        final boolean silent,
            if (indexSettings.get(IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey()) != null) {
        if (INDEX_NUMBER_OF_SHARDS_SETTING.exists(indexSettingsBuilder) == false) {
    /**
                Collections.emptyList(),
    ) {
        );
    }
            && !isRestoreFromSnapshot
    }
                @Override
            updatedMappings.addAll(mappings);
import org.opensearch.cluster.block.ClusterBlock;
        boolean silent,
    }
    }
                        + "] or later, but the minimum node version is ["
        }
     * clone), the resize settings.
     * pluggable data-format default-stamping and restrict validation.
        QueryShardContext queryShardContext
                    hasDisableObjects = true;
    ) throws Exception {
                throw new IllegalArgumentException(
            request,
                .equals(clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING)) == false) {
        CreateIndexClusterStateUpdateRequest request,
        );
                continue; // Skip null mappings
        final Map<String, Object> mappings = MapperService.parseMapping(xContentRegistry, request.mappings());
import org.opensearch.core.xcontent.NamedXContentRegistry;
            );
        }
     * Validate the name for an index against some static rules and a cluster state.
        final Version indexVersionCreated = IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(indexSettings);
        return applyCreateIndexWithTemporaryService(
            }
            // handle aliases
import java.util.stream.IntStream;
            .values()
        Set<ClusterBlock> clusterBlocks,
            );
import java.util.Objects;
 * under the License.
    }
        if (remoteStoreEnabled
            Object docObj = mapping.get(MapperService.SINGLE_MAPPING_NAME);
                || s.startsWith("index.analysis.")
    ) throws Exception {
        CreateIndexClusterStateUpdateRequest request,
            }
     */
            ),
import org.opensearch.action.admin.indices.alias.Alias;
            throw exceptionCtor.apply(index, "must not contain ':'");
        AliasValidator aliasValidator,
                clusterService.getClusterSettings().get(DEFAULT_REPLICA_COUNT_SETTING)
        }
                && Boolean.parseBoolean(indexSettings.get(SETTING_REMOTE_STORE_ENABLED)) == false) {
 */
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING;
import org.opensearch.cluster.block.ClusterBlockLevel;
        List<Map<String, Object>> mappings,
        for (Map.Entry<String, AtomicInteger> entries : nodesToNumRouting.entrySet()) {
        final CreateIndexClusterStateUpdateRequest request,
            if (docObj instanceof Map) {
        normalizeRequestSetting(request);
            throw new IllegalArgumentException(
            Settings.Builder tmpSettingsBuilder = Settings.builder().put(temporaryIndexMeta.getSettings());
                indexSettingsBuilder.build()
        final CreateIndexClusterStateUpdateRequest request,
     * Stamps the dynamic cluster-level fencing default ({@code cluster.remote_store.fencing.enabled}) into the final
     *
                request.context()
            AliasMetadata aliasMetadata = AliasMetadata.builder(alias.name())
                    logger.debug(
     */
            || requestSettings.get(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey()) == null) {
    }
     * the cluster state, then {@link CreateIndexClusterStateUpdateResponse#isAcknowledged()} will return
    /**
            );
            null,
    private void validate(CreateIndexClusterStateUpdateRequest request, ClusterState state) {
            }
                "Cannot apply context template as user provide settings have overlap with the included context template."
                    request.ackTimeout(),
        indexMetadataBuilder.system(isSystem);
            return Optional.of(
            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX)
                    + "] can only be used with remote store enabled clusters"
    }
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
     * {@link CreateIndexClusterStateUpdateRequest}, inherited from templates and, if recovering from another index (ie. split, shrink,
        }
     */
            throw new IllegalStateException("index " + sourceIndex + " must have all shards allocated on the same node to shrink index");
        Settings requestSettings,
        // If the refresh interval supplied is -1, we allow the index to be created because -1 means no periodic refresh.
                }
     * The template mappings are applied in the order they are encountered in the list (clients should make sure the lower index, closer
     * Stamps the cluster-scope defaults for the pluggable data-format index settings into the
        }
            request,
            tmpImd,
            final Version createdVersion = Version.min(Version.CURRENT, nodes.getSmallestNonClientNodeVersion());
        // in the remote store custom data map.
     * @param clusterSettings cluster level settings
                    ValidationException validationException = new ValidationException();
     * Validates the settings and mappings for shrinking an index.
                mapperService.merge(MapperService.SINGLE_MAPPING_NAME, mapping, MergeReason.INDEX_TEMPLATE);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
 * ownership. Elasticsearch licenses this file to you under
        Map<String, Object> parsedRequestMappings = MapperService.parseMapping(xContentRegistry, requestMappings);
            result.add(parsedTemplateMapping);
     * Adds the 1) remote store path type 2) ckp as translog metadata information in custom data of index metadata.
            clusterService.getClusterSettings()
        IndexMetadata tempMetadata = tmpImdBuilder.build();
    }
        if (index.isEmpty()) {
        if (index.charAt(0) == '_' || index.charAt(0) == '-' || index.charAt(0) == '+') {
     * Applies disable_objects override logic to a list of mappings.
                    shardsAcknowledged -> {
    private final Environment env;
        Object finalDisableObjectsValue = null;
        }
import java.util.Map;
        return Optional.empty();
        }
        IndexMetadata.selectSplitShard(0, sourceMetadata, IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings));
                logger.log(silent ? Level.DEBUG : Level.INFO, "failed on parsing mappings on index creation [{}]", request.index(), e);
     * pluggable data-format feature flag is disabled or the index matches the allowlist.
        final IndexMetadata sourceMetadata,
        if (requestSettings.stream().anyMatch(contextTemplateSettings::hasValue)) {
                    + clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING)
     * @return a list containing validaton errors or an empty list if there aren't any errors
        numSplits = Math.max(1, numSplits); // Ensure the index can be split at least once
 *
            /*
        updatedState = ClusterState.builder(updatedState).routingTable(routingTableBuilder.build()).build();
            throw new IllegalArgumentException(
    private final NamedXContentRegistry xContentRegistry;
        }
        List<String> validationErrors = new ArrayList<>();
            if (setting == null) {
        if (index.contains(":")) {
        // ensure write operations on the source index is blocked
            AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
            currentState,
            return applyCreateIndexRequestWithExistingMetadata(currentState, request, silent, sourceMetadata, metadataTransformer);
    public static void validateIndexTotalPrimaryShardsPerNodeSetting(Settings indexSettings) {
    private static ClusterBlocks.Builder createClusterBlocksBuilder(ClusterState currentState, String index, Set<ClusterBlock> blocks) {
                templates.stream().map(IndexTemplateMetadata::getMappings).collect(toList()),
                    + request.index()
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
    private final IndicesService indicesService;
        // create the index here (on the master) to validate it can be created, as well as adding the mapping
            builder.put(sourceMetadata.getSettings().filter(sourceSettingsPredicate));
        builder.setRoutingNumShards(routingNumShards);
import java.nio.file.Path;
        IndexMetadata.selectShrinkShards(0, sourceMetadata, IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings));
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
        this.clusterService = clusterService;
    static void prepareResizeIndexSettings(
        }
    private static IndexMetadata.Builder createIndexMetadataBuilder(
import org.opensearch.common.util.set.Sets;
import org.opensearch.common.compress.CompressedXContent;
        Optional<String> indexName
    private ClusterState applyCreateIndexRequestWithExistingMetadata(
     * <p>
     */
        // Apply disable_objects override logic to ensure template priority ordering is respected
     * true, otherwise it will return false and no waiting will occur for started shards
        final ReplicationType indexReplicationType;
            final IndexMetadata indexMetadata;
                    + "Please remove the settings ["
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;
        );
        final Settings.Builder templateSettings = Settings.builder().put(combinedTemplateSettings);
 * Unless required by applicable law or agreed to in writing,
    /**
        if (nodesToAllocateOn.isEmpty()) {
            throw new ResourceAlreadyExistsException(state.routingTable().index(index).getIndex());
        validatePluggableDataFormatSettings(settings, clusterService.getClusterSettings(), indexName).ifPresent(validationErrors::add);
             * We need to arrange that the primary term on all the shards in the shrunken index is at least as large as
                        "removing default [{}] setting as it in set to null in a template for [{}] creation",
            int numAllocations = entries.getValue().get();
                final List<IndexTemplateMetadata> v1Templates = MetadataIndexTemplateService.findV1Templates(
            }
                request.resizeType(),
import java.util.stream.Stream;
                if (templatesAliases.containsKey(entry.getKey())) {
        // Set up everything, now locally create the index to see that things are ok, and apply
     * into a map.
        clusterService.submitStateUpdateTask(
                    + INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
        } else if (type == ResizeType.SPLIT) {
     * before sending the response on the listener. If the index creation was successfully applied on
        if (durability.equals(Translog.Durability.ASYNC)) {
            } catch (Exception e) {
     * Validate the name for an index or alias against some static rules.
        }, listener::onFailure));
                request.index(),
                clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING)
        final Index recoverFromIndex = request.recoverFrom();
     * when {@code cluster.index.restrict.replication.type} is set to true.
                request.aliases(),
            parseV1Mappings(
     * @param sourceMetadata when recovering from an existing index, metadata that should be copied to the new index
     * it will return the value configured for that index.
            && remoteStoreCustomMetadataResolver.isRemoteStoreRepoServerSideEncryptionEnabled()) {
                    Locale.ROOT,
                    continue;
                indexService.newQueryShardContext(0, null, () -> 0L, null)
        List<Map<String, Object>> result = new ArrayList<>();
    }
                .findFirst();
    ) {
            for (Map<String, Object> mapping : mappings) {
            // Do not apply any templates to system indices
                } else {
        if (sourceMetadata == null) {
     * In a mixed cluster, older nodes may not recognize newer mapper types (e.g., field_mapping),
            );
                    + requestRefreshInterval
        ClusterSettings clusterSettings,
            throw new IllegalArgumentException(
     * @param clusterSettings cluster setting
        Settings indexSettings,
            indexReplicationType = ReplicationType.SEGMENT;
            && clusterSettings.get(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED)) {
        if (mapperType == IngestionMessageMapper.MapperType.FIELD_MAPPING) {
                IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings)
    private final ClusterService clusterService;
                        + Version.V_3_7_0
        Metadata newMetadata = builder.build();
            // at this point. The validation will take place later in the process
    private static void updateIndexMappingsAndBuildSortOrder(
        }
                "index setting ["
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
     *
     * definitions, as may result in an invalid field definition
                } else {
     */
            .findFirst();
                indexService.newQueryShardContext(0, null, () -> 0L, null)
    }
            } else {
        }
        Settings nodeSettings,
                .getNodes()
     * Validate and resolve the aliases explicitly set for the index, together with the ones inherited from the specified
                .equals(clusterSettings.get(CLUSTER_REPLICATION_TYPE_SETTING).name()) == false) {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
        throws Exception {
    }
    private static void validateSearchOnlyReplicasSettings(Settings indexSettings) {
        IndexScopedSettings indexScopedSettings,
                    ValidationException validationException = new ValidationException();
                        + "and [index.translog.retention.size] are deprecated and effectively ignored. "
        }
    static Settings aggregateIndexSettings(
            } catch (Exception e) {
                blocksBuilder.addIndexBlock(index, block);
    List<String> getIndexSettingsValidationErrors(final Settings settings, final boolean forbidPrivateIndexSettings, String indexName) {
            // we cannot validate for index shrinking since the mapping is empty
                if (segmentRepo != null) {
        Map<String, MappingMetadata> mappingsMetadata = new HashMap<>();
import org.opensearch.repositories.RepositoriesService;
            // For all the explicit settings, we go through the template and request level settings
        final IndexMetadata.Builder tmpImdBuilder = IndexMetadata.builder(request.index());
            && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(requestSettings)
        } else {
        // only select this automatically for indices that are created on or after 7.0 this will prevent this new behaviour
    }
            indexSettingProviders,
        if (state.metadata().hasIndex(index)) {
                    }
        final Supplier<RepositoriesService> repositoriesServiceSupplier
import java.util.HashSet;
            || requestSettings.get(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey()) == null) {
                .filter(alias.filter())
        this.indexScopedSettings = indexScopedSettings;
            }
                .indexRouting(alias.indexRouting())
        BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
        }
import org.opensearch.common.io.PathUtils;
            throw new IllegalArgumentException(
        final boolean copySettings,
        final AliasValidator aliasValidator,
        logger.trace(
     * ({@link CreateIndexClusterStateUpdateResponse#isShardsAcknowledged()} will also be false).  If the index
        );
import java.util.function.Supplier;
        }
    private ClusterState applyCreateIndexRequestWithV2Template(
        return indexSettings;
                Object docObj = mapping.get(MapperService.SINGLE_MAPPING_NAME);
        if (indexSettingProviders.contains(provider)) {
        String sseEnabledIndex = existingCustomData == null
        return null;
        validateStoreTypeSettings(indexSettings);
    }
            int searchReplicaCount = settings.getAsInt(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0);
    }
        ClusterSettings clusterSettings,
    }
                    + clusterMinimumRefreshInterval
                    "index name [{}] starts with a dot '.', in the next major version, index names "
                }
        for (MappingMetadata mappingMd : mappingsMetadata.values()) {
                    Locale.ROOT,
        boolean hasDisableObjects = false;
            if (systemIndices.validateSystemIndex(index)) {
        }
        if (FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG) == false) {
     * become active (as specified in {@link CreateIndexClusterStateUpdateRequest#waitForActiveShards()})
                request.index(),
     * @param tmpImdBuilder     index metadata builder.
            sourceMetadata,
                    if (e instanceof ResourceAlreadyExistsException) {
            indexSettingsBuilder.put(templateSettings.build());
                );
            silent,
            || clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING) == false) {
     * table based on the live nodes.
                aliasValidator.validateAliasFilter(alias.name(), alias.filter(), queryShardContext, xContentRegistry);
            throw new IndexNotFoundException(sourceIndex);
        if (INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.exists(requestSettings) == false
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
        blocks.updateBlocks(indexMetadata);
import org.opensearch.cluster.ClusterState;
        }
        final IndexRoutingTable table = state.routingTable().index(sourceIndex);
        if (Strings.validFileName(index) == false) {
     */
        //
    /**
     * the index added (and rerouted)
     * Updates index settings to enable remote store by default based on node attributes
            MetadataIndexTemplateService.resolveSettings(templates),
    public static void validateTranslogFlushIntervalSettingsForCompositeIndex(Settings requestSettings, ClusterSettings clusterSettings) {
        /*
import org.opensearch.OpenSearchException;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            // or one that is valid in that case we can split into whatever and auto-generate a new factor.
import org.apache.logging.log4j.LogManager;
            );
            if (minNodeVersion.before(Version.V_3_8_0)) {
        }
        final Map<String, Object> mappings = Collections.unmodifiableMap(
            validateSplitIndex(currentState, resizeSourceIndex.getName(), resizeIntoName, indexSettingsBuilder.build());
    private static List<String> validateIndexCustomPath(Settings settings, @Nullable Path sharedDataPath) {
            }
    ) throws IOException {
        return result;
        @Nullable IndexMetadata sourceMetadata,
            }
                logger.trace("index [{}] is a hidden index", index);
        updatePluggableDataFormatSettings(indexSettingsBuilder, clusterSettings, request.index());
            // in this case we either have no index to recover from or
        }
        final Environment env,
        Settings combinedTemplateSettings,
            try {
import org.opensearch.common.settings.Settings;
        Settings indexSettings,
                    validationErrors.add("custom path [" + customPath + "] is not a sub-path of path.shared_data [" + sharedDataPath + "]");
    public void addIndexCreationValidator(IndexCreationValidator validator) {
    private static void validateActiveShardCount(ActiveShardCount waitForActiveShards, IndexMetadata indexMetadata) {
     * @param requestSettings settings passed in during index create/update request
                );
        tmpImdBuilder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);
            }
     * Parses the provided mappings json and the inheritable mappings from the templates (if any)
    IndexMetadata buildAndValidateTemporaryIndexMetadata(
        indexCreationValidators.add(validator);
     */
        int indexPrimaryShardsPerNode = INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);
    }
            // and see if either a template or the request has "cancelled out" an explicit default
import org.opensearch.common.logging.DeprecationLogger;
     * the new index, returning an {@link IndexMetadata} for the new index.
    /**
                "Setting ["
            throw new IllegalArgumentException("provider already added");
        updateReplicationStrategy(indexSettingsBuilder, request.settings(), settings, combinedTemplateSettings, clusterSettings);
    private static void updateRemoteStoreFencingSetting(Settings.Builder settingsBuilder, ClusterSettings clusterSettings) {
        // do not recognise the setting key at all — they would fail to load the index metadata.
                        aliasMetadata.alias(),
            }
            validationErrors.addAll(validatePrivateSettingsNotExplicitlySet(settings, indexScopedSettings));
        tmpImdBuilder.system(isSystem);
     * per-index setting at creation time, for remote-store-backed indices that do not set it explicitly. The index
                clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
            // Loop through all the explicit index setting providers, adding them to the
            int replicaCount = settings.getAsInt(
        // index (see more comments below)
                    + "Please do not specify a value for setting [index.soft_deletes.enabled]."
        for (Map<String, Object> mapping : mappings) {
        indexMetadataBuilder.state(IndexMetadata.State.OPEN);
            );
     */
        validateRefreshIntervalSettings(request.settings(), clusterSettings);
     * The access level of the method changed to default level for visibility to test.
                        xContentRegistry
     */
     * cluster-level defaults {@code cluster.pluggable.dataformat.enabled} and
        final String requestMappings,
        }
                "index specifies a context which is not loaded on the cluster."
                        );
                    requestSettings.remove(explicitSetting);
        final ActionListener<CreateIndexClusterStateUpdateResponse> listener
        settingsBuilder.put(SETTING_REPLICATION_TYPE, indexReplicationType);
     * Add a provider to be invoked to get additional index settings prior to an index being created
    private final AliasValidator aliasValidator;
                @Override
        return numShards * 1 << numSplits;
                assert templateMapping.size() == 1 : "expected exactly one mapping value, got: " + templateMapping;
            indexScopedSettings,
                    currentState.metadata(),
 * GitHub history for details.
        if (metadataTransformer != null) {
                DEPRECATION_LOGGER.deprecate(
            indexMetadataBuilder.putAlias(aliases.get(i));
                // shard id and the current timestamp
import org.opensearch.ResourceAlreadyExistsException;
     */
     * Validates {@code index.replication.type} is matches with cluster level setting {@code cluster.indices.replication.strategy}
        Metadata metadata,
            .getNodes()
import static java.util.stream.Collectors.toList;
                    temporaryIndexMeta.isSystem(),
        final boolean silent,
            List<Map<String, Object>> updatedMappings = new ArrayList<>();
     * @param currentState the current state to base the new state off of
        logger.debug("applying create index request using composable template [{}]", templateName);
        if (provider == null) {
import org.opensearch.cluster.service.ClusterService;
            aliasValidator.validateAlias(alias, index, metadata);
            if (mapping.isEmpty() == false) {
            .put(builder.build())
        // 6. Default cluster level setting
            if (response.isAcknowledged()) {
        final IndexMetadata sourceMetadata = currentState.metadata().index(resizeSourceIndex.getName());
                request.context().name(),
        // Create builders for the template and request settings. We transform these into builders
            // "index.mysetting": "blah
     * @param temporaryIndexMeta metadata for the new index built from templates, source metadata, and request settings
                name,
        TimeValue requestRefreshInterval = IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.get(requestSettings);
            currentState,
                        + "starting with a dot are reserved for hidden indices and system indices",
            indexSettingsBuilder.put(SETTING_AUTO_EXPAND_REPLICAS, settings.get(SETTING_AUTO_EXPAND_REPLICAS));
            validateCloneIndex(currentState, resizeSourceIndex.getName(), resizeIntoName, indexSettingsBuilder.build());
    }
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            indexSettingsBuilder.put(SETTING_NUMBER_OF_REPLICAS, clusterSettings.get(DEFAULT_REPLICA_COUNT_SETTING));
            }
        }
                    request.index(),
        final Settings aggregatedIndexSettings = aggregateIndexSettings(
        }
        final String templateName,
                        + Version.V_3_6_0
            if (mapping == null) {
        final ActionListener<ClusterStateUpdateResponse> listener
    static void validateCloneIndex(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {
        CreateIndexClusterStateUpdateRequest request,
        }
        final Index resizeSourceIndex,
                throw e;
    }
            final Predicate<String> sourceSettingsPredicate = (s) -> (s.startsWith("index.similarity.")
        List<String> validationErrors = getIndexSettingsValidationErrors(settings, forbidPrivateIndexSettings, indexName);
            }
            for (String explicitSetting : additionalIndexSettings.keys()) {
            // setting. For example, if a plugin had as an explicit setting:
    public void createIndex(
            IndexMetadata.getRoutingFactor(
        }
                // Mappings added at last (priority to mappings provided)
    ) {
            throw new InvalidIndexContextException(
        }
                // Settings applied at last
     *
        final Settings.Builder indexSettingsBuilder,
    private static final Logger logger = LogManager.getLogger(MetadataCreateIndexService.class);
                .mapToLong(sourceMetadata::primaryTerm)
     * which would cause failures when those nodes try to initialize the ingestion engine.
            );
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                        queryShardContext,
        assert source != null;
        } catch (UnsupportedEncodingException e) {
        IndexMetadata sourceMetadata = validateResize(state, sourceIndex, targetIndexName, targetIndexSettings);
            Collections.singletonList(mappings),
 * You may obtain a copy of the License at
        final ResizeType type,
     * The template mappings are applied in the order they are encountered in the list (clients
            Collections.singletonList(templateName),
import java.util.concurrent.atomic.AtomicInteger;
     */
                            Collections.singletonList(
                // name of the index that we are applying it to
        List<String> validationErrors = new ArrayList<>();
            // UTF-8 should always be supported, but rethrow this if it is not for some reason
        if (requestSettings.hasValue(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey())
                    compositeIndexMaxFlushSize
import org.opensearch.common.settings.IndexScopedSettings;
        if (request.dataStreamName() == null && template.getDataStreamTemplate() != null) {
        final BiFunction<IndexService, Map<String, AliasMetadata>, List<AliasMetadata>> aliasSupplier,
        if ((isRemoteDataAttributePresent(settings) == false && isMigratingToRemoteStore(clusterSettings) == false)
        final CreateIndexClusterStateUpdateRequest request,
        if (forbidPrivateIndexSettings) {
            // value).
        Settings indexSettings = indexSettingsBuilder.build();
            );
                validationErrors.add("private index setting [" + key + "] can not be set explicitly");
                            )
                    MetadataIndexTemplateService.resolveAliases(currentState.metadata(), templateName).stream()
    /**
        tmpImdBuilder.settings(aggregatedIndexSettings);
 *     http://www.apache.org/licenses/LICENSE-2.0
        final CreateIndexClusterStateUpdateRequest request,
                "index setting [index.replication.type] is not allowed to be set as ["
     *
            waitForActiveShards = indexMetadata.getWaitForActiveShards();
        // apply the aliases in reverse order as the lower index ones have higher order
    static void validateIngestionSourceSettings(Settings settings, ClusterState state) {
import org.opensearch.cluster.node.DiscoveryNode;
        if (request.context() != null && !isContextAllowed) {
    private final RemoteStoreCustomMetadataResolver remoteStoreCustomMetadataResolver;
            .build();
        } else {
                    + INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
     * setting is final because the fence is the primary's write witness: toggling it on a live index would leave a
        return collectV2Mappings(requestMappings, templateMappings, xContentRegistry);
    /**
import java.util.stream.Collectors;
            settingsBuilder.put(IndexSettings.INDEX_CONTEXT_CURRENT_VERSION.getKey(), componentTemplate.version());
        if (Objects.nonNull(newPathStrategy.getHashAlgorithm())) {
                if (!indexScopedSettings.isPrivateSetting(key)) {
                .values()
        } else {
        tmpImdBuilder.setRoutingNumShards(routingNumShards);
            CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING
import org.apache.logging.log4j.Logger;
        validateIndexReplicationTypeSettings(settings, clusterService.getClusterSettings()).ifPresent(validationErrors::add);
                indexService,
                : "index.number_of_routing_shards should not be present on the target index on resize";
                    + "] cannot differ from cluster default ["
                currentState.metadata(),
        return builder;
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        }
            () -> new ParameterizedMessage("Added newCustomData={}, replaced oldCustomData={}", remoteCustomData, existingCustomData)
        Metadata.Builder builder = Metadata.builder(currentState.metadata()).put(indexMetadata, false);
        return applyCreateIndexRequest(currentState, request, silent, null);
        final IndexMetadata sourceMetadata = recoverFromIndex == null ? null : currentState.metadata().getIndexSafe(recoverFromIndex);
     *
        return false;
     * @param requestSettings settings passed in during index create/update request
     * Returns a default number of routing shards based on the number of shards of the index. The default number of routing shards will
        ByteSizeValue translogFlushSize = INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(requestSettings);
            // (multi-partition consumer factory). The check will be wired here once available.
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findContextTemplateName;
                if (requestSettings.keys().contains(explicitSetting) && requestSettings.get(explicitSetting) == null) {
import org.opensearch.core.index.Index;
            // numSourcePartitions < numShards (shards beyond numSourcePartitions-1 fail to initialize).
                    finalDisableObjectsValue = doc.get("disable_objects");
            // (when all shards are copied in a single place).
        List<AliasMetadata> aliases,
                        Collections.singletonList("Cluster is migrating to remote store but no remote node found, failing index creation")
            byteCount = index.getBytes("UTF-8").length;
        }
            remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, sseEnabledIndex);
            }
    }
                indexMetadata.getNumberOfReplicas()
                request.recoverFrom(),
    /**
    ) throws Exception {
                    + IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey()
                    "mapper_type [field_mapping] requires all nodes in the cluster to be on version ["
            indexReplicationType = CLUSTER_REPLICATION_TYPE_SETTING.get(nodeSettings);
        // Get the setting value
        Settings requestSettings,
            indexSettingsBuilder.put(additionalIndexSettings.build());
                    DEPRECATION_LOGGER.deprecate(
        );
        this.env = env;
            settings,
        }
                aliasValidator,
        }
     * @param requestSettings settings passed in during index update request
            );
        IndexMetadata.Builder indexMetadataBuilder = createIndexMetadataBuilder(indexName, sourceMetadata, indexSettings, routingNumShards);
     * @param metadataTransformer if provided, a function that may alter cluster metadata in the same cluster state update that
        String indexName
import java.util.HashMap;
            );
import org.opensearch.common.xcontent.XContentHelper;
                }
        int routingNumShards
                throw e;
import org.opensearch.core.common.unit.ByteSizeValue;
    public MetadataCreateIndexService(
            if (Strings.hasLength(alias.filter())) {
            }
            // this method applies all necessary checks ie. if the target shards are less than the source shards
            );
 * specific language governing permissions and limitations
                );
    /**
        if (IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.exists(requestSettings) == false
            if (IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.exists(indexSettings)
        if (IndexModule.Type.SIMPLEFS.match(IndexModule.INDEX_STORE_TYPE_SETTING.get(settings))) {
            // The backing index may have a different name or prefix than the data stream name.
     */
        ByteSizeValue compositeIndexMaxFlushSize = clusterSettings.get(
            Optional<DiscoveryNode> remoteNode = clusterState.nodes()
                    }
                return applyCreateIndexRequestWithV2Template(currentState, request, silent, v2Template, metadataTransformer);
            for (final String key : sourceMetadata.getSettings().keySet()) {
                sourceMetadata.getNumberOfShards(),
        final CreateIndexClusterStateUpdateRequest request,
    private static Optional<String> validateIndexReplicationTypeSettings(Settings requestSettings, ClusterSettings clusterSettings) {
        String storeTypeSetting = request.settings().get(INDEX_STORE_TYPE_SETTING.getKey());
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
                        v1Templates.stream().map(IndexTemplateMetadata::name).sorted().collect(Collectors.joining(", "))
                        + "]"
                currentState.metadata(),
                if (aliasMetadata.filter() != null) {
        // will always have the behavior of the min node in the cluster.
            } else {
        final IndexMetadata sourceMetadata = state.metadata().index(sourceIndex);
        final AllocationService allocationService,
            final Boolean isHiddenFromRequest = IndexMetadata.INDEX_HIDDEN_SETTING.exists(request.settings())
        final int numTargetShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(indexSettings);
            } else {
                // shard id and the current timestamp
            return Optional.of(
    /**
                IndexMetadata.SETTING_NUMBER_OF_REPLICAS,
        throws IndexCreationException {
                    return new ClusterStateUpdateResponse(acknowledged);
        if (mapperService.isCompositeIndexPresent()) {
     * @param listener the listener on which to send the index creation cluster state update response
                    INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
            return;
        );
            currentState,
            return;
    public IndexScopedSettings getIndexScopedSettings() {
        IndexMetadata sourceMetadata = validateResize(state, sourceIndex, targetIndexName, targetIndexSettings);
            shardLimitValidator,
import org.opensearch.indices.IndicesService;
        }
     * for composite indices based on {{@code index.composite_index}}
        return indexScopedSettings;
                        + "] or later, but the minimum node version is ["
            } else {
 * this file be licensed under the Apache-2.0 license or a
            || indexSettingsBuilder.get(SETTING_NUMBER_OF_REPLICAS) == null) {
            assert numAllocations <= numShards : "wait what? " + numAllocations + " is > than num shards " + numShards;
        Set<IndexSettingProvider> indexSettingProviders,
            : existingCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY);
                searchReplicaCount,
        final List<Map<String, Object>> mappings,
        }
                    mappings = templateMapping;
            xContentRegistry,
     * @return a new cluster state with the index added
                xContentRegistry,
                }
    }
        for (IndexCreationValidator validator : indexCreationValidators) {
        }
        List<Map<String, Object>> mappings,
     * Validates that {@code index.pluggable.dataformat.enabled} and {@code index.pluggable.dataformat} match the
     * @param clusterSettings cluster setting
            settingsBuilder.put(
                Map<String, Object> templateMapping = MapperService.parseMapping(xContentRegistry, mapping.string());
        }
        } else if (CLUSTER_REPLICATION_TYPE_SETTING.exists(nodeSettings)) {
    ) throws Exception {
                    + "=true]"
                "[simplefs] is deprecated and will be removed in 2.0. Use [niofs], which offers equal or better performance, "
            ? null
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
    void validateContext(CreateIndexClusterStateUpdateRequest request) {
            );
    ) {
                        request.index(),
    }
        final NamedXContentRegistry xContentRegistry,
    public ClusterState applyCreateIndexRequest(ClusterState currentState, CreateIndexClusterStateUpdateRequest request, boolean silent)
            MetadataCreateDataStreamService.validateTimestampFieldMapping(mapperService);
        IndexMetadata sourceMetadata = validateResize(state, sourceIndex, targetIndexName, targetIndexSettings);
            throw new IllegalArgumentException(
     * {@code cluster.restrict.pluggable.dataformat} is set to true.
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
        if (sourceMetadata != null) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
 * software distributed under the License is distributed on an
            Map<String, Object> parsedTemplateMapping = MapperService.parseMapping(xContentRegistry, templateMapping.string());
                        explicitSetting,
        final Settings settings,
                // found creation still works using the request's specified index settings
    private final ShardLimitValidator shardLimitValidator;
        Translog.Durability durability = IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.get(requestSettings);
            final DiscoveryNodes nodes = currentState.nodes();
import org.opensearch.indices.replication.common.ReplicationType;
                        validationException.addValidationErrors(
        final boolean isSystem = validateDotIndex(request.index(), isHiddenAfterTemplates);
    ) {
            final Setting<?> setting = indexScopedSettings.get(key);
     *
            } else if (isHidden) {
     * @return the list of nodes at least one instance of the source index shards are allocated
     *
        Settings.Builder updatedSettingsBuilder = Settings.builder();
                });
        );
            final Settings.Builder additionalIndexSettings = Settings.builder();
                Path resolvedPath = PathUtils.get(new Path[] { sharedDataPath }, customPath);
     * Validates {@code index.translog.flush_threshold_size} is equal or below the {@code indices.composite_index.translog.max_flush_threshold_size}
     * <p>
                aliasValidator,
            tmpImd,
            throw exceptionCtor.apply(index, "must not contain '#'");
        if (state.metadata().hasIndex(targetIndexName)) {
import org.opensearch.indices.SystemIndices;
            Optional<String> replicaValidationError = awarenessReplicaBalance.validate(replicaCount, autoExpandReplica);
     */
                "cannot create index with index setting \"index.store.type\" set to \"remote_snapshot\". Store type can be set to \"remote_snapshot\" only when restoring a remote snapshot by using \"storage_type\": \"remote_snapshot\""
import java.util.Set;
            List.of(),
        return mappings;
        createIndexTaskKey = clusterService.registerClusterManagerTask(CREATE_INDEX, true);
        final NamedXContentRegistry xContentRegistry
     * Validates ingestion source settings for version compatibility and mapper settings correctness.
 *
    ) {
        }
                    );
import org.opensearch.indices.IndexCreationException;
        for (CompressedXContent templateMapping : templateMappings) {
            templateName,
     * @param isHidden Whether or not this is a hidden index
    }
        }
    private ClusterState applyCreateIndexRequestWithV1Templates(
                    INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
                    settingsBuilder.put(SETTING_REMOTE_STORE_ENABLED, true).put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, segmentRepo);
        }
    }
        NamedXContentRegistry xContentRegistry
        if (requestRefreshInterval.millis() < clusterMinimumRefreshInterval.millis()) {
import org.opensearch.common.ValidationException;
     *
    public static final int MAX_INDEX_NAME_BYTES = 255;
        if (indexSettingsBuilder.get(SETTING_CREATION_DATE) == null) {
        } else {
        indexScopedSettings.validate(build, true);
                if (mapping == null) {
        RemoteStorePathStrategy newPathStrategy = remoteStoreCustomMetadataResolver.getPathStrategy();
        assert IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexSettings);
                request.copySettings(),
     * @param index The name of the index in question
        final String indexName
            MappingMetadata mappingMd = new MappingMetadata(mapper);
                // the context is only used for validation so it's fine to pass fake values for the
                    "To set " + SETTING_NUMBER_OF_SEARCH_REPLICAS + ", " + SETTING_REMOTE_STORE_ENABLED + " must be set to true"
        // Only materialized when the cluster default is enabled: an absent key already resolves to false forever
            indexSettingsBuilder.put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), createdVersion);
        }
    ) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            request.mappings(),
        remoteCustomData.put(IndexMetadata.TRANSLOG_METADATA_KEY, Boolean.toString(isTranslogMetadataEnabled));
                    + "=true]"
        // 3. Template property for replication type
    public static void validateTranslogRetentionSettings(Settings indexSettings) {
                                "[{}] index created, but the operation timed out while waiting for " + "enough shards to be started.",
                                request.index()
        }
        String indexName,
            && requestSettings.get(INDEX_REPLICATION_TYPE_SETTING.getKey())
        final ClusterService clusterService,
     */
        int byteCount = 0;
                public ClusterState execute(ClusterState currentState) throws Exception {
                    + "=true]"
 */
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
        int routingNumShards,
     */
    static Optional<String> validateOverlap(Set<String> requestSettings, Settings contextTemplateSettings, String indexName) {
                logger.info("failed to build index metadata [{}]", request.index());
        boolean isRestoreFromSnapshot = !assertNullOldType;
            // in which case templates don't apply, so create the index from the source metadata
    ) {
                    );
            }
                    + "] when ["
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX;
        }
     * index metadata at creation time when no explicit override is supplied. No-op when the
                // if an alias with same name was already processed, ignore this one
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;
        }
    public static List<Map<String, Object>> collectV2Mappings(
            Version minNodeVersion = state.nodes().getMinNodeVersion();
import org.opensearch.action.support.ActiveShardCount;
                "mappings are not allowed when creating an index from a source index, " + "all mappings are copied from the source index"
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;
    }
        }
            || IndexMetadata.INGESTION_SOURCE_DECODER_SETTINGS.exists(settings)) {
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {
            // templates), so we need to check to see if the request is creating a hidden index
            ? new RemoteStoreCustomMetadataResolver(remoteStoreSettings, minNodeVersionSupplier, repositoriesServiceSupplier, settings)
import org.opensearch.common.settings.Setting;
            sourceMetadata,
        BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
            if (v2Template != null) {
        if (indexPrimaryShardsPerNode == -1 && indexRemoteCapablePrimaryShardsPerNode == -1) {
                xContentRegistry,
        if (isMigratingToRemoteStore(clusterSettings)) {
        // We use as a default number of routing shards the higher number that can be expressed
                }
        final boolean isContextAllowed = FeatureFlags.isEnabled(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES);
        }
import org.opensearch.indices.RemoteStoreSettings;
        if (waitForActiveShards == ActiveShardCount.DEFAULT) {
        // whether to stamp a default is not this method's place to validate the settings it is handed.
        return indexMetadataBuilder.build();
import org.opensearch.cluster.node.DiscoveryNodes;
     * @param requestSettings settings passed in during index create request
import org.opensearch.index.query.QueryShardContext;
                listener.onResponse(new CreateIndexClusterStateUpdateResponse(false, false));
                    // Someone provided an empty '{}' for mappings, which is okay, but to avoid
     * @param nodeSettings node level settings
            && source.getParentDataStream().getWriteIndex().getIndex().equals(sourceMetadata.getIndex())) {
                    super.onFailure(source, e);
     *
    ) {
import java.util.function.BiFunction;
        boolean isRemoteStoreEnabled = IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings);
            if (minNodeVersion.before(Version.V_3_6_0)) {
        // Settings validation to the mapper
        validateIndexTotalPrimaryShardsPerNodeSetting(indexSettings);
    }
        final AwarenessReplicaBalance awarenessReplicaBalance,
        if (state.routingTable().hasIndex(index)) {
        );
     */
    static Map<String, Object> parseV1Mappings(
                // do not override settings that have already been set (for example, from the request)
     * @param clusterSettings cluster setting
                // if an alias with same name came with the create index request itself,
                Map<String, Object> doc = (Map<String, Object>) docObj;
        final Settings aggregatedIndexSettings = aggregateIndexSettings(
        return allowlist.stream().anyMatch(indexName::startsWith);
            "create-index [" + request.index() + "], cause [" + request.cause() + "]",
                }
        final NamedXContentRegistry xContentRegistry,
import org.opensearch.index.compositeindex.CompositeIndexSettings;
        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(indexSettings)) {
                "cannot create index with name ["
        // Decoder settings validation. Both decoder_type and decoder_settings.* were introduced in V_3_8_0.
            );
            metadataTransformer
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
                    isHiddenFromRequest
        }
        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(indexSettings) == false
        final boolean forbidPrivateIndexSettings,
            } else if (setting.isPrivateIndex()) {
        IndexMetadata tmpImd = buildAndValidateTemporaryIndexMetadata(aggregatedIndexSettings, request, routingNumShards, currentState);
                // pre-8x templates may have a wrapper type other than _doc, so we re-wrap things here
        }
                        explicitSetting,
                request.aliases(),
                    // Override with the final disable_objects value
        final List<Map<String, Object>> mappings = collectV2Mappings(
            throw new IllegalStateException("unknown resize type is " + type);
            return Optional.of(
        }
            throw new ResourceAlreadyExistsException(state.metadata().index(index).getIndex());
                if (v1Templates.size() > 1) {
                        + "in the cluster to be on version ["
        if (IndexMetadata.INGESTION_SOURCE_PARTITION_STRATEGY_SETTING.exists(settings)) {
import org.opensearch.index.IndexNotFoundException;
    private final SystemIndices systemIndices;
                    temporaryIndexMeta.getCustomData(),
        if (sourceMetadata != null) {
                    XContentHelper.mergeDefaults(mappings, templateMapping);
                isHiddenFromRequest == null ? false : isHiddenFromRequest
            assert IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.exists(indexSettings) == false
             */
import org.opensearch.index.mapper.MapperService;
        boolean isTranslogMetadataEnabled = remoteStoreCustomMetadataResolver.isTranslogMetadataEnabled();
                        "removing default [{}] setting as it in set to null in the request for [{}] creation",
    /**
                "index setting ["
            && requestSettings.hasValue(SETTING_REPLICATION_TYPE)
                        ValidationException validationException = new ValidationException();
                // the index using that template and the request's specified settings
            throw new IllegalStateException(
        Supplier<DocumentMapper> documentMapperSupplier,
     * Given a state and index settings calculated after applying templates, validate metadata for
/*
                request.index(),
        final ClusterState currentState,
        if (request.context() != null) {
            throw exceptionCtor.apply(index, "must not start with '_', '-', or '+'");
             * document-level semantics regarding sequence numbers in the shrunken index.
        String index,
                );
        Settings.Builder settingsBuilder,
     */
        }
        }
            throw new IndexCreationException(indexName, validationException);
import org.opensearch.core.common.Strings;
 *
            indexSettingProviders,
            CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING
        final CreateIndexClusterStateUpdateRequest request,
     */
                        request.index()
            validator.validate(mapperService, indexService.getIndexSettings());
import java.util.ArrayList;
    }
     * to the head of the list, templates have the highest {@link IndexTemplateMetadata#order()})
        }
            indexScopedSettings,
    public void addRemoteStoreCustomMetadata(IndexMetadata.Builder tmpImdBuilder, boolean assertNullOldType, ClusterState clusterState) {
import java.util.Collections;
        ByteSizeValue translogFlushSize = INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(requestSettings);
     *
        final String resizeIntoName,
     * window in which a stale primary is checked against neither the fence nor the replicas. Baking the cluster value
            resolvedAliases.add(aliasMetadata);
        final ClusterState currentState,
import org.opensearch.threadpool.ThreadPool;
        final ClusterState currentState,
        @Nullable IndexMetadata sourceMetadata,
            CompositeIndexValidator.validate(mapperService, indexService.getCompositeIndexSettings(), indexService.getIndexSettings());
                ? IndexMetadata.INDEX_HIDDEN_SETTING.get(request.settings())
                }
        }
                    provider.getAdditionalIndexSettings(request.index(), isDataStreamIndex, templateAndRequestSettings)
     * to the head of the list, templates have the highest {@link IndexTemplateMetadata#order()})
 * license agreements. See the NOTICE file distributed with
            Settings.EMPTY,
        String indexName
        IndexMetadata.selectCloneShard(0, sourceMetadata, IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings));
    }
            // additionalIndexSettings map
                    sourceMetadata,
import org.opensearch.index.IndexService;
                    );
                    "index_name_starts_with_dot",
            return Optional.of(
     * validate the configuration with an actual index service as return a new cluster state with
                    "You can configure '%s' with upto '%s' for composite index",
    static void validateTranslogDurabilitySettings(Settings requestSettings, ClusterSettings clusterSettings, Settings settings) {
        this.systemIndices = systemIndices;
                aliasValidator.validateAliasMetadata(aliasMetadata, index, metadata);
            if (sharedDataPath == null) {
     * @param combinedTemplateSettings combined template settings which satisfy the index
                currentState.metadata(),
                "invalid index.refresh_interval ["
    /**
                // Allow templatesAliases to be templated by replacing a token with the
            shardLimitValidator,
            request,
                    aliases,
                    },
                IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(),
    private final ActiveShardsObserver activeShardsObserver;
            // perspective it is as though the setting has not been set at all (using the default
                String.format(
 * Service responsible for submitting create index requests
            return Optional.of(
        // a different strategy (e.g., modulo), which might cause correctness issues.
        final SystemIndices systemIndices,
            Version minNodeVersion = state.nodes().getMinNodeVersion();
            indexSettingProviders,
            remoteCustomData.put(PathHashAlgorithm.NAME, newPathStrategy.getHashAlgorithm().name());
                );
        }
import org.opensearch.common.util.FeatureFlags;
    public static void validateIndexOrAliasName(String index, BiFunction<String, String, ? extends RuntimeException> exceptionCtor) {
        }
            return Optional.empty();
        }
                request.context().name(),
     * Creates an {@link IndexMetadata.Builder} for the provided index and sets a valid primary term for all the shards if a source
    }
        // Reject any explicit value (including the default "xcontent") on mixed clusters where some nodes
    private static List<String> validatePrivateSettingsNotExplicitlySet(Settings settings, IndexScopedSettings indexScopedSettings) {
        }
    }
    }
    public static void updateReplicationStrategy(
                );
        validateIndexReplicationTypeSettings(indexSettingsBuilder.build(), clusterSettings).ifPresent(validationErrors::add);
            );
        onlyCreateIndex(request, ActionListener.wrap(response -> {
        Map<String, AliasMetadata> templatesAliases = new HashMap<>();
        }
                @SuppressWarnings("unchecked")
        if (!isRemoteStoreEnabled) {
            }
            throw exceptionCtor.apply(index, "must not be empty");
    public static void updatePluggableDataFormatSettings(
        }
        Map<String, Object> mapperSettings = IndexMetadata.INGESTION_SOURCE_MAPPER_SETTINGS.getAsMap(settings);
                        listener.onResponse(new CreateIndexClusterStateUpdateResponse(response.isAcknowledged(), shardsAcknowledged));
        ComposableIndexTemplate template = currentState.getMetadata().templatesV2().get(templateName);
                        + minNodeVersion
        if (request.context() != null && findContextTemplateName(clusterService.state().metadata(), request.context()) == null) {
        logger.trace("executing IndexCreationTask for [{}] against cluster state version [{}]", request, currentState.version());
        String indexName
        Settings.Builder settingsBuilder
                return applyCreateIndexRequestWithV1Templates(currentState, request, silent, v1Templates, metadataTransformer);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            || isMigratingToRemoteStore(clusterSettings)) {
        final RemoteStoreSettings remoteStoreSettings,
                    validationErrors.add("expected [" + key + "] to be private but it was not");
    }
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
    public void validateIndexSettings(String indexName, final Settings settings, final boolean forbidPrivateIndexSettings)
                resolvedAliases.add((aliasMetadata));
        updateRemoteStoreSettings(indexSettingsBuilder, currentState, clusterSettings, settings, request.index());
     *
            indexReplicationType = ReplicationType.SEGMENT;
            silent,
        validateTranslogDurabilitySettings(request.settings(), clusterSettings, settings);
                    + IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey()
            } else {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        ClusterState currentState,
     */
        final Settings settings,
            for (int shardId = 0; shardId < builder.numberOfShards(); shardId++) {
        } else if (isRemoteDataAttributePresent(nodeSettings)) {
            return;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
                    + clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
            throw new InvalidIndexNameException(index, "must be lowercase");
                }
        if (state.blocks().indexBlocked(ClusterBlockLevel.WRITE, sourceIndex) == false) {
        remoteCustomData.put(PathType.NAME, newPathStrategy.getType().name());
        indexSettingsBuilder.put(requestSettings.build());
        // Find the last (highest priority) disable_objects value
        if (isAllowedForPluggableDataFormat(indexName, clusterSettings)) {
            for (ClusterBlock block : blocks) {
                "index " + sourceIndex + " must block write operations to resize index. use \"index.blocks.write=true\""
    }
            return componentTemplate.template();
        final List<IndexTemplateMetadata> templates,
        final String templateName,
        final Settings aggregatedIndexSettings,
    /**
    }
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        final ShardLimitValidator shardLimitValidator,
        }
            );
        if (request.dataStreamName() != null) {
        ClusterState updatedState = ClusterState.builder(currentState).blocks(blocks).metadata(newMetadata).build();
                currentState.metadata(),
    }
        String indexName = indexMetadata.getIndex().getName();
        final boolean silent,
            .put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), resizeSourceIndex.getName())
        final Settings.Builder indexSettingsBuilder = Settings.builder();
            metadataTransformer
        IndexMetadata tmpImd = buildAndValidateTemporaryIndexMetadata(aggregatedIndexSettings, request, routingNumShards, currentState);
     */
                throw new IllegalArgumentException(
            replicaValidationError.ifPresent(validationErrors::add);
     *
            || requestSettings.get(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey()) == null
            && IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(indexSettings).onOrAfter(Version.V_2_0_0)) {
     * should make sure the lower index, closer to the head of the list, templates have the highest
    }
/*
            }
                indexMetadata = buildIndexMetadata(
    static IndexMetadata validateResize(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {
        return validationErrors;
                }
                    // tripping the below assertion, we can safely ignore it
                if (doc.containsKey("disable_objects")) {
            mappings,
                    compositeIndexMaxFlushSize
        }
        }
        }
            }
            final List<AliasMetadata> aliases = aliasSupplier.apply(
                indexScopedSettings
                    + Sets.intersection(requestSettings, contextTemplateSettings.keySet())
                if (indexSettingsBuilder.keys().contains(key)) {
        validateSearchOnlyReplicasSettings(indexSettings);
            final String v2Template = MetadataIndexTemplateService.findV2Template(
                                "Cluster is migrating to remote store but remote translog is not configured, failing index creation"
        }
        // value (including [simple], the default) on mixed clusters where some nodes don't recognize the key.
        }
            indexService.getIndexEventListener().beforeIndexAddedToCluster(indexMetadata.getIndex(), indexMetadata.getSettings());
        for (Alias alias : aliases) {
                }
    /**
        Settings nodeSettings,
import org.opensearch.cluster.routing.RoutingTable;
    private static void validateErrors(String indexName, List<String> validationErrors) {
                    aliasValidator.validateAliasFilter(
            || StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.exists(indexSettings) == false
    /**
                    + indexName
                aliasValidator,
        IngestionMessageMapper.MapperType mapperType = IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING.get(settings);
                    continue;
                        request.index()
     */
                || IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.exists(indexSettings)) {
import java.util.Locale;
            // Apply aware replica balance validation only to non system indices
                }
import org.opensearch.Version;
        // until we have a fully upgraded cluster. Additionally it will make integratin testing easier since mixed clusters
                    "translog_retention",
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
    ) {
                        + "[index.translog.retention.age] "
    }
            }
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
            .put(IndexMetadata.SETTING_VERSION_UPGRADED, sourceMetadata.getUpgradedVersion())
                .filter(DiscoveryNode::isRemoteSegmentStoreNode)
        int log2MaxNumShards = 10; // logBase2(1024)
                    continue;
        }
 * not use this file except in compliance with the License.
        List<String> validationErrors = validateIndexCustomPath(settings, env.sharedDataDir());
    private AwarenessReplicaBalance awarenessReplicaBalance;
            currentState,
            indexReplicationType = CLUSTER_REPLICATION_TYPE_SETTING.getDefault(nodeSettings);
        for (Map<String, AliasMetadata> templateAliasConfig : templateAliases) {
        if (INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.exists(indexSettings) && indexSettings.get(SETTING_NUMBER_OF_SEARCH_REPLICAS) != null) {
        );
     * The template mappings are applied in the order they are encountered in the list (clients should make sure the lower index, closer
        if (IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(current) == false) {
            final boolean isDataStreamIndex = request.dataStreamName() != null;
            request,
        }
/*
        } else if (type == ResizeType.CLONE) {
                request.index(),
        }
     * @param requestSettings settings passed in during index create request
    }
        builder.settings(indexSettings);
                if (resolvedPath == null) {
                    String templatedAlias = aliasMetadata.alias().replace("{index}", index);
    private void onlyCreateIndex(
     * @param indexSettings index settings
                }
    ) {
import java.time.Instant;
            indexSettingsBuilder.putNull(initialRecoveryIdFilter);
     */
            );
        addRemoteStoreCustomMetadata(tmpImdBuilder, true, clusterState);
                return true;
