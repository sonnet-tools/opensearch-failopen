import org.opensearch.index.compositeindex.CompositeIndexSettings;
            currentState,  
                request.context().name(),
     * @param settingsBuilder index settings builder to be updated with relevant settings
    }  
    public void addAdditionalIndexSettingProvider(IndexSettingProvider provider) {
                : null;  
    /**  
        } else if (isRemoteDataAttributePresent(nodeSettings)) {  
            Object docObj = mapping.get(MapperService.SINGLE_MAPPING_NAME);  
        logger.trace("executing IndexCreationTask for [{}] against cluster state version [{}]", request, currentState.version());
        final List<IndexTemplateMetadata> templates,
                activeShardsObserver.waitForActiveShards(
        final String initialRecoveryIdFilter = IndexMetadata.INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING.getKey() + "_id";
                request.aliases(),  
                    + INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()  
            "applying create index request using legacy templates {}",
        RemoteStorePathStrategy newPathStrategy = remoteStoreCustomMetadataResolver.getPathStrategy();
        @Nullable IndexMetadata sourceMetadata,
        } catch (UnsupportedEncodingException e) {  
        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(indexSettings) == false
        IndexMetadata indexMetadata,
        boolean isSystem,
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(updatedState.routingTable())  
import org.opensearch.cluster.block.ClusterBlocks;  
    }  
        }
    private static void validateErrors(String indexName, List<String> validationErrors) {
            searchReplicaValidationError.ifPresent(validationErrors::add);  
        final ClusterState currentState,  
                @Override  
                .max()  
import org.opensearch.indices.ShardLimitValidator;
                if (setting == null) {
        // combination the restore path itself must reject, with a SnapshotRestoreException. Validating it here instead  
        final SystemIndices systemIndices,  
        // ensure write operations on the source index is blocked  
     * it will return the value configured for that index.
        List<String> validationErrors = getIndexSettingsValidationErrors(settings, forbidPrivateIndexSettings, Optional.of(indexName));
        boolean isRestoreFromSnapshot = !assertNullOldType;
    }
            }  
            silent,
                    validationErrors.add("expected [" + key + "] to be private but it was not");  
import java.util.stream.Collectors;
 * this file be licensed under the Apache-2.0 license or a
                }
                name,
        }  
        }  
                });  
        if (IndexMetadata.INGESTION_SOURCE_PARTITION_STRATEGY_SETTING.exists(settings)) {  
        } else {
            indexScopedSettings,
    }  
                } else {  
        Translog.Durability durability = IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.get(requestSettings);  
        final IndicesService indicesService,
        }
    public ClusterState applyCreateIndexRequest(ClusterState currentState, CreateIndexClusterStateUpdateRequest request, boolean silent)  
            );
            final String name = request.dataStreamName() != null ? request.dataStreamName() : request.index();  
        this.systemIndices = systemIndices;  
import org.opensearch.indices.IndicesService;  
    public static void updateRemoteStoreSettings(
            List<Map<String, Object>> updatedMappings = new ArrayList<>();  
    ) {  
        final int numTargetShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(indexSettings);
import org.opensearch.common.compress.CompressedXContent;  
     * when {@code cluster.index.restrict.replication.type} is set to true.
        if (IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexSettings)) {
            return;
                : "index.number_of_routing_shards should not be present on the target index on resize";  
                continue; // Skip null mappings  
        updateReplicationStrategy(indexSettingsBuilder, request.settings(), settings, combinedTemplateSettings, clusterSettings);
            );
     */
        // until we have a fully upgraded cluster. Additionally it will make integratin testing easier since mixed clusters
            request,
        String index,
        return indexMetadataBuilder.build();
                throw new IllegalArgumentException(  
            );  
 * Service responsible for submitting create index requests
     */
            }
            }
        Map<String, Object> mappings = MapperService.parseMapping(xContentRegistry, requestMappings);
            validateCloneIndex(currentState, resizeSourceIndex.getName(), resizeIntoName, indexSettingsBuilder.build());
            throw new IllegalArgumentException(
            .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID.getKey(), resizeSourceIndex.getUUID());
        if (index.charAt(0) == '.') {
        Supplier<Version> minNodeVersionSupplier = () -> clusterService.state().nodes().getMinNodeVersion();
            CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING
 * GitHub history for details.
/*  
                final List<IndexTemplateMetadata> v1Templates = MetadataIndexTemplateService.findV1Templates(
    }
     * Handles the cluster state transition to a version that reflects the {@link CreateIndexClusterStateUpdateRequest}.  
        }
import org.opensearch.common.util.FeatureFlags;
            );  
            for (final String key : sourceMetadata.getSettings().keySet()) {
                listener.onResponse(new CreateIndexClusterStateUpdateResponse(false, false));  
            }
        final boolean silent,  
                        + "] or later, but the minimum node version is ["  
            validationErrors.addAll(validatePrivateSettingsNotExplicitlySet(settings, indexScopedSettings));
        this.env = env;
        for (MappingMetadata mappingMd : mappingsMetadata.values()) {  
            // we have a source index with 1 shard and without an explicit split factor  
    static void prepareResizeIndexSettings(  
        Supplier<DocumentMapper> documentMapperSupplier,  
        final IndexScopedSettings indexScopedSettings
        if (translogFlushSize.compareTo(compositeIndexMaxFlushSize) > 0) {  
    ) throws Exception {
        }
            && clusterSettings.get(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED)) {
     * @param requestSettings settings passed in during index update request
                    continue;
        for (CompressedXContent templateMapping : templateMappings) {
     * validate the configuration with an actual index service as return a new cluster state with
            assert request.resizeType() != null;
            throw new IndexNotFoundException(sourceIndex);
            // in which case templates don't apply, so create the index from the source metadata
        final ActionListener<ClusterStateUpdateResponse> listener
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;  
            // setting. For example, if a plugin had as an explicit setting:
    /**
import java.util.Locale;
        }  
    static IndexMetadata validateResize(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {
                    tmpSettingsBuilder.build(),
                    },
                    logger.debug(
 * Licensed to Elasticsearch under one or more contributor  
     * Validates the {@code index.routing.allocation.total_primary_shards_per_node} setting during index creation.  
        // The replication setting is applied in the following order:
                    request.waitForActiveShards(),
            }
                    + "or other file systems instead."  
        final Settings.Builder indexSettingsBuilder = Settings.builder();
        IndexMetadata tmpImd = buildAndValidateTemporaryIndexMetadata(aggregatedIndexSettings, request, routingNumShards, currentState);
        try {
            .getNodes()
     * {@code cluster.pluggable.dataformat.restrict.allowlist} setting, meaning it should bypass
import java.util.Optional;
 * ownership. Elasticsearch licenses this file to you under  
     *
            Optional<String> replicaValidationError = awarenessReplicaBalance.validate(replicaCount, autoExpandReplica);  
                "index specifies a context which is not loaded on the cluster."  
    private final ClusterManagerTaskThrottler.ThrottlingKey createIndexTaskKey;
        indexCreationValidators.add(validator);
        if (index.charAt(0) == '_' || index.charAt(0) == '-' || index.charAt(0) == '+') {  
                        throw new IndexCreationException(indexName, validationException);
     * @return the list of resolved aliases, with the explicitly provided aliases occurring first (having a higher priority) followed by
                "index setting [index.translog.durability=async] is not allowed as cluster setting ["  
            null,
        return numShards * 1 << numSplits;
        CreateIndexClusterStateUpdateRequest request,  
    }
    IndexMetadata buildAndValidateTemporaryIndexMetadata(
                    );  
                if (requestSettings.keys().contains(explicitSetting) && requestSettings.get(explicitSetting) == null) {
 * this work for additional information regarding copyright
                templatesApplied,
            request.index()
    public static void validateIndexTotalPrimaryShardsPerNodeSetting(Settings indexSettings) {
                    sourceMetadata,
                    validationException.addValidationError(message);
    ) {
        if (indexSettingsBuilder.get(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey()) == null) {
                        + minNodeVersion  
            );
                    Map<String, Object> doc = (Map<String, Object>) docObj;  
            (indexService, contextAlias) -> resolveAndValidateAliases(  
        });
import org.opensearch.cluster.block.ClusterBlock;
     * before sending the response on the listener. If the index creation was successfully applied on  
        final boolean isSystem = validateDotIndex(request.index(), isHiddenAfterTemplates);
            .findFirst();  
        if (mappings == null || mappings.size() <= 1) {
     * index metadata at creation time when no explicit override is supplied. No-op when the  
        // 1. Strictly SEGMENT if cluster is undergoing remote store migration
                Stream.concat(  
import org.opensearch.index.IndexModule;  
        if (Strings.validFileName(index) == false) {  
    private final ShardLimitValidator shardLimitValidator;  
        }
            tmpImdBuilder.context(request.context());
        addRemoteStoreCustomMetadata(tmpImdBuilder, true, clusterState);
        if (Strings.isEmpty(customPath) == false) {
        final ActionListener<CreateIndexClusterStateUpdateResponse> listener
    private static List<String> validatePrivateSettingsNotExplicitlySet(Settings settings, IndexScopedSettings indexScopedSettings) {
     * index meta data is provided (this represents the case where we're shrinking/splitting an index and the primary term for the newly  
                if (aliasMetadata.filter() != null) {
    }
        validatePluggableDataFormatSettings(settings, clusterService.getClusterSettings(), indexName).ifPresent(validationErrors::add);
        if (mappings.isEmpty() == false) {
        if (IndexMetadata.INGESTION_SOURCE_DECODER_TYPE_SETTING.exists(settings)  
                "invalid index.refresh_interval ["
        this.forbidPrivateIndexSettings = forbidPrivateIndexSettings;
            // in this case we either have no index to recover from or
            );
        if (state.routingTable().hasIndex(index)) {  
    }  
    public static void validateStoreTypeSettings(Settings settings) {  
            currentState,
            request,
                }  
    /**  
                Path resolvedPath = PathUtils.get(new Path[] { sharedDataPath }, customPath);
                    if (translogRepo != null) {
        this.xContentRegistry = xContentRegistry;
        return false;
                    + "use create data stream api instead"
                    continue;
                )
        Metadata newMetadata = builder.build();
        return validationErrors;
        return result;  
            || clusterSettings.get(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING) == false) {  
    /**  
                    request.index(),  
                xContentRegistry,
            // and see if either a template or the request has "cancelled out" an explicit default  
    static void applyDisableObjectsOverrides(List<Map<String, Object>> mappings) {
import java.io.IOException;
     * Later mappings in the list override earlier ones for the disable_objects setting,
                );
            for (IndexSettingProvider provider : indexSettingProviders) {
        // (the index setting is final), so stamping an explicit false would add metadata without changing semantics.
                indexService.newQueryShardContext(0, null, () -> 0L, null)  
        final ClusterState currentState,
    private static boolean isAllowedForPluggableDataFormat(String indexName, ClusterSettings clusterSettings) {
            MetadataCreateDataStreamService.validateTimestampFieldMapping(mapperService);
                    throw new IndexCreationException(indexName, validationException);
            settings,  
     * in here means flipping the cluster setting only affects indices created afterwards.
                            )
            indexReplicationType = ReplicationType.SEGMENT;
                .mapToLong(sourceMetadata::primaryTerm)
     * @param indexSettings index settings
                || IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.exists(indexSettings)) {
                        validationException.addValidationErrors(
            );
                || s.startsWith("index.sort.")  
                        explicitSetting,
            );
                builder.primaryTerm(shardId, primaryTerm);  
            throw new ResourceAlreadyExistsException(state.metadata().index(targetIndexName).getIndex());  
                // Mappings added at last (priority to mappings provided)  
            routingNumShards = sourceMetadata.getRoutingNumShards();
                // if an alias with same name was already processed, ignore this one  
        validateIndexReplicationTypeSettings(settings, clusterService.getClusterSettings()).ifPresent(validationErrors::add);  
        // Check if remote store is enabled
                    "index.ingestion_source.source_partition_strategy requires all nodes in the cluster to be on version ["
    static void validateSplitIndex(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {  
                        xContentRegistry  
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                // shard id and the current timestamp
            || StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.exists(indexSettings) == false
        final RemoteStoreSettings remoteStoreSettings,  
            // handle aliases
            );
                "index setting ["
        ByteSizeValue translogFlushSize = INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(requestSettings);
     * Creates an index in the cluster state and waits for the specified number of shard copies to
        Settings indexSettings = indexSettingsBuilder.build();
     * table based on the live nodes.  
            tmpImd,
        BiFunction<ClusterState, String, ClusterState> rerouteRoutingTable,  
     * @return a list containing validaton errors or an empty list if there aren't any errors
     * @return the list of nodes at least one instance of the source index shards are allocated
    /**
     * @param metadataTransformer if provided, a function that may alter cluster metadata in the same cluster state update that
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
            clusterService.getClusterSettings()  
        String indexName,
        this.clusterService = clusterService;
        // would pre-empt that with an IllegalArgumentException from a read that only ever wanted a boolean. Deciding
     * {@code cluster.pluggable.dataformat} when
        if (waitForActiveShards.validate(indexMetadata.getNumberOfReplicas()) == false) {  
        int routingNumShards,
        validateRefreshIntervalSettings(request.settings(), clusterSettings);
        List<Map<String, AliasMetadata>> templateAliases,
        MapperService mapperService = indexService.mapperService();
                    DEPRECATION_LOGGER.deprecate(
            remoteCustomData.put(PathHashAlgorithm.NAME, newPathStrategy.getHashAlgorithm().name());
            int replicaCount = settings.getAsInt(
                    );
                blocksBuilder.addIndexBlock(index, block);
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;  
 */  
        }
            AliasMetadata aliasMetadata = AliasMetadata.builder(alias.name())
                if (!indexScopedSettings.isPrivateSetting(key)) {
     */
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());
    ) throws Exception {  
        }
        // Reject any explicit value (including the default "xcontent") on mixed clusters where some nodes
            }
        // If we found a disable_objects value, apply it to all mappings that have a _doc section
import org.opensearch.index.IndexSettings;  
        if (INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.exists(requestSettings) == false
                Map<String, Object> templateMapping = MapperService.parseMapping(xContentRegistry, mapping.string());
            // And either a template or create index request had:  
            waitForActiveShards = indexMetadata.getWaitForActiveShards();
 * compatible open source license.
            metadataTransformer  
            );
import org.opensearch.cluster.block.ClusterBlockLevel;
                    Locale.ROOT,
            Version minNodeVersion = state.nodes().getMinNodeVersion();
import org.opensearch.Version;
            assert IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.exists(indexSettings) == false
        ClusterState clusterState,  
    ) {
                        queryShardContext,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
                if (templateMapping.isEmpty()) {  
            final List<AliasMetadata> aliases = aliasSupplier.apply(  
     * Validates {@code index.replication.type} is matches with cluster level setting {@code cluster.indices.replication.strategy}  
            throw new IllegalStateException(
                currentState,
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;
                // pre-8x templates may have a wrapper type other than _doc, so we re-wrap things here  
            for (Map<String, Object> mapping : mappings) {
                templatesAliases.put(aliasMetadata.alias(), aliasMetadata);  
            .put(IndexMetadata.SETTING_VERSION_UPGRADED, sourceMetadata.getUpgradedVersion())  
                    source.getParentDataStream().getName()
        IndexMetadata.Builder indexMetadataBuilder = createIndexMetadataBuilder(indexName, sourceMetadata, indexSettings, routingNumShards);
    ) throws Exception {
        }  
            metadataTransformer
            request,  
                request.resizeType(),
             * document-level semantics regarding sequence numbers in the shrunken index.
                        + "and [index.translog.retention.size] are deprecated and effectively ignored. "
        boolean isRemoteStoreEnabled = IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings);  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.isMigratingToRemoteStore;
        ClusterState currentState,
    }  
                request.index(),  
    }
            validator.validate(mapperService, indexService.getIndexSettings());
                    + "] to continue using the context for index: "
            throw new IllegalArgumentException(
    private final AliasValidator aliasValidator;  
                    ValidationException validationException = new ValidationException();
                request.aliases(),
            if (componentTemplate.template().mappings() != null) {
                .build();
            }  
        final Settings.Builder requestSettings = Settings.builder().put(request.settings());  
            indexSettingsBuilder.put(SETTING_NUMBER_OF_REPLICAS, clusterSettings.get(DEFAULT_REPLICA_COUNT_SETTING));
                // name of the index that we are applying it to  
        boolean silent,  
            // "index.mysetting": null
        if (FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG) == false) {
        // do not recognise the setting key at all — they would fail to load the index metadata.
     * to the head of the list, templates have the highest {@link IndexTemplateMetadata#order()})
                    if (e instanceof ResourceAlreadyExistsException) {  
                    + IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey()
        final String resizeIntoName,
     * true, otherwise it will return false and no waiting will occur for started shards
                Map<String, Object> doc = (Map<String, Object>) docObj;  
                "cannot create index with name ["
            if (mapping == null) {
import org.opensearch.action.admin.indices.shrink.ResizeType;
        int byteCount = 0;  
import java.util.function.BiFunction;
        if (sourceMetadata != null) {  
                        + "They will be removed in a future version."
                return applyCreateIndexRequestWithV1Templates(currentState, request, silent, v1Templates, metadataTransformer);
        // Version check for mixed cluster compatibility
            // prior to resolving which templates it matches  
                    continue;  
        }
            List.of(),  
        if (indexPrimaryShardsPerNode == -1 && indexRemoteCapablePrimaryShardsPerNode == -1) {
    public static Optional<String> validateTranslogFlushIntervalSettingsForCompositeIndex(  
                logger.trace("index [{}] is a hidden index", index);  
        IndexMetadata sourceMetadata = validateResize(state, sourceIndex, targetIndexName, targetIndexSettings);  
     * @param requestSettings settings resulting from merging request, templates, and cluster-level defaults
            mappings,
     * @param indexName name of index
                remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, Boolean.toString(true));
            ? null  
            // or one that is valid in that case we can split into whatever and auto-generate a new factor.
        } else {
        if (hasDisableObjects) {  
        List<String> validationErrors = validateIndexCustomPath(settings, env.sharedDataDir());
        throws IndexCreationException {
    }
import org.opensearch.common.UUIDs;
                }  
        this.indicesService = indicesService;
        Settings nodeSettings,
            byteCount = index.getBytes("UTF-8").length;
        // If the refresh interval supplied is -1, we allow the index to be created because -1 means no periodic refresh.
        IndexMetadata.selectCloneShard(0, sourceMetadata, IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings));
        if (request.context() != null) {  
import java.util.Objects;  
     *
        if (sourceMetadata == null) {
            null,  
                .getAsLong();
                        Collections.singletonList("Cluster is migrating to remote store but no remote node found, failing index creation")  
            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX)
            indexSettingsBuilder.put(initialRecoveryIdFilter, Strings.arrayToCommaDelimitedString(nodesToAllocateOn.toArray()));  
        throws Exception {
        return collectV2Mappings(requestMappings, templateMappings, xContentRegistry);  
        // Determine if the ckp would be stored as translog metadata  
        );  
            }
            }
            // If source metadata was provided, it means we're recovering from an existing index,
        }  
            .addAsNew(updatedState.metadata().index(indexName));
    }
                request.index(),
        );
                "index specifies a context which cannot be used without enabling: "  
                    return applyCreateIndexRequest(currentState, request, false);
        updatedState = ClusterState.builder(updatedState).routingTable(routingTableBuilder.build()).build();
        Settings requestSettings,
            Settings.EMPTY,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
import org.opensearch.index.compositeindex.CompositeIndexValidator;
     * the ones inherited from the templates
     * @param listener the listener on which to send the index creation cluster state update response  
        }
                }  
    }  
    void validateContext(CreateIndexClusterStateUpdateRequest request) {
        for (Map<String, Object> mapping : mappings) {
        final Map<String, Object> mappings = Collections.unmodifiableMap(  
                clusterService.getClusterSettings().get(DEFAULT_REPLICA_COUNT_SETTING)
    public void validateIndexName(String index, ClusterState state) {
        TimeValue requestRefreshInterval = IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.get(requestSettings);  
    }
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
                        listener.onResponse(new CreateIndexClusterStateUpdateResponse(response.isAcknowledged(), shardsAcknowledged));
                    + IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey()
        final IndexScopedSettings indexScopedSettings,  
     */
        }
            request,
            (indexService, contextTemplate) -> resolveAndValidateAliases(
     * Applies disable_objects override logic to a list of mappings.
                validationErrors.add("private index setting [" + key + "] can not be set explicitly");  
        // Read the raw value rather than going through INDEX_REMOTE_STORE_ENABLED_SETTING.get(). That setting carries a  
    /**
                    ValidationException validationException = new ValidationException();  
                ? IndexMetadata.INDEX_HIDDEN_SETTING.get(request.settings())
            indexSettingsBuilder.putNull(initialRecoveryIdFilter);  
                request.index(),
import org.opensearch.common.xcontent.XContentHelper;
        } else if (type == ResizeType.SPLIT) {
        CreateIndexClusterStateUpdateRequest request,  
                    "You can configure '%s' with upto '%s' for composite index",
    public static List<Map<String, Object>> collectV2Mappings(  
        if (index.equals(".") || index.equals("..")) {
                        + Version.V_3_8_0
            );
     */
        final boolean remoteStoreEnabled = current.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false);  
     * @param nodeSettings node level settings
    }
        IndexMetadata tmpImd = buildAndValidateTemporaryIndexMetadata(aggregatedIndexSettings, request, routingNumShards, currentState);
    static List<String> validateShrinkIndex(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {  
            );
        // 6. Default cluster level setting
     * @param aliasSupplier a function that takes the real {@link IndexService} and returns a list of {@link AliasMetadata} aliases  
        // in the remote store custom data map.  
     * per-index setting at creation time, for remote-store-backed indices that do not set it explicitly. The index
     * Validate the name for an index against some static rules and a cluster state.
     * Given the state and a request as well as the metadata necessary to build a new index,  
                currentState.metadata(),
                        }  
        }
                indexService.newQueryShardContext(0, null, () -> 0L, null)
                if (mapping == null) {
                    temporaryIndexMeta.getRoutingNumShards(),  
        // Apply disable_objects override logic to ensure template priority ordering is respected  
        int indexPrimaryShardsPerNode = INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);  
                        "index_template_multiple_match",  
        final List<CompressedXContent> templateMappings,
        return resolvedAliases;
     * Also validates that mapper_settings keys are recognized for the configured mapper_type.
            return Optional.empty();  
        // as {@code numShards * 2^x`} that is less than or equal to the maximum number of shards: 1024.  
        indexScopedSettings.validate(build, true);
                silent ? Level.DEBUG : Level.INFO,  
        validateTranslogDurabilitySettings(request.settings(), clusterSettings, settings);
import org.opensearch.OpenSearchException;
                        ValidationException validationException = new ValidationException();
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
                routingNumShards = calculateNumRoutingShards(numTargetShards, indexVersionCreated);
            final Settings.Builder additionalIndexSettings = Settings.builder();
        if (isMigratingToRemoteStore(clusterSettings)) {
                // the index using that template and the request's specified settings
                request.index(),
        tmpImdBuilder.system(isSystem);  
                AliasMetadata aliasMetadata = entry.getValue();  
                        request.index()
    private final List<IndexCreationValidator> indexCreationValidators = new ArrayList<>();  
            .values()  
     * @param clusterSettings cluster setting
     * Updates index settings to enable remote store by default based on node attributes  
     * for composite indices based on {{@code index.composite_index}}
                } else {
        final ClusterState currentState,  
                }  
            );
            return Optional.of(
                            );
                .equals(clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING)) == false) {
             */  
    ) throws Exception {
        }  
            // The backing index may have a different name or prefix than the data stream name.
        if (state.metadata().hasAlias(index)) {  
            throw new IllegalStateException("unknown resize type is " + type);
        // Only materialized when the cluster default is enabled: an absent key already resolves to false forever
        // NOTE: dot-prefixed index names are validated after template application, not here
                        "removing default [{}] setting as it in set to null in a template for [{}] creation",  
            if (IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.exists(indexSettings)
import org.opensearch.indices.InvalidIndexContextException;
                    logger.debug(
                // A v2 template wasn't found, check the v1 templates, in the event no templates are
            throw new IllegalArgumentException(
        }
        final Index recoverFromIndex = request.recoverFrom();  
import org.opensearch.indices.replication.common.ReplicationType;
     * Validate and resolve the aliases explicitly set for the index, together with the ones inherited from the specified
import org.opensearch.cluster.routing.ShardRouting;
        if (clusterSettings.get(IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING) == false) {
        if (sourceMetadata == null || sourceMetadata.getNumberOfShards() == 1) {
                    INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
        tmpImdBuilder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);
     * The template mappings are applied in the order they are encountered in the list (clients  
        String customPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(settings);
        }
        assert source != null;
    ) {
            );
    private final NamedXContentRegistry xContentRegistry;
    }  
        logger.debug(
                    + "], because it matches with template ["
                )
        }
     * @param mappings a list of all mapping definitions to apply, in order
                    super.onFailure(source, e);
     * This is used during update index settings flow  
        final Settings aggregatedIndexSettings = aggregateIndexSettings(  
        List<String> allowlist = clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST);  
    public static void validateRefreshIntervalSettings(Settings requestSettings, ClusterSettings clusterSettings) {
        final String requestMappings,
    }
            throw new IllegalArgumentException("provider already added");
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
        }
     */  
            return;  
                    doc.put("disable_objects", finalDisableObjectsValue);
            if (INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(indexSettings) > 0  
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer  
        }
        ClusterState updatedState = ClusterState.builder(currentState).blocks(blocks).metadata(newMetadata).build();
    // TODO : Update this check for SegRep to DocRep migration on need basis  
        final boolean isHiddenAfterTemplates = IndexMetadata.INDEX_HIDDEN_SETTING.get(aggregatedIndexSettings);  
    /**  
        final Settings aggregatedIndexSettings = aggregateIndexSettings(
        String indexName,
                resizeIntoName,  
    }
        // we use "i.r.a.initial_recovery" rather than "i.r.a.require|include" since we want the replica to allocate right away  
     */
                    + SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey()
            }  
            // Do not apply any templates to system indices
                request.mappings(),
        if (!blocks.isEmpty()) {
        // with null template as applyCreateIndexRequestWithV2Template has assertions when template is null
     * Updates index settings to set replication strategy by default based on cluster level settings or remote store
        );  
            settingsBuilder.put(
    /**
        // Store type of `remote_snapshot` is intended to be system-managed for searchable snapshot indexes so a special case is needed here
        // index (see more comments below)
     * which would cause failures when those nodes try to initialize the ingestion engine.  
                }
            }
            final DiscoveryNodes nodes = currentState.nodes();
        CreateIndexClusterStateUpdateRequest request,
        }  
/*
        ClusterState currentState,
            indexSettingsBuilder.put(SETTING_NUMBER_OF_SHARDS, INDEX_NUMBER_OF_SHARDS_SETTING.get(settings));
            throw new InvalidIndexContextException(  
    /**
                if (docObj instanceof Map) {
     * return true, otherwise if the operation timed out, then it will return false.  
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteDataAttributePresent;
            return;
            if (setting == null) {  
            remoteCustomData.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, sseEnabledIndex);  
                    additionalIndexSettings.remove(explicitSetting);
            if (minNodeVersion.before(Version.V_3_7_0)) {
                        );  
            throw exceptionCtor.apply(index, "must not contain the following characters " + Strings.INVALID_FILENAME_CHARS);
        int log2NumShards = 32 - Integer.numberOfLeadingZeros(numShards - 1); // ceil(logBase2(numShards))
            if (minNodeVersion.before(Version.V_3_8_0)) {  
        createIndexClusterStateRequest.settings(build);
            }  
            }
            settings,  
            metadataTransformer.accept(builder, indexMetadata);
        return nodesToAllocateOn;  
        final ThreadPool threadPool,
            }  
                // If a v2 template was found, it takes precedence over all v1 templates, so create
        // now, update the mappings with the actual source
            throw new IllegalArgumentException("provider must not be null");
            }
            if (sharedDataPath == null) {
     * definitions, as may result in an invalid field definition  
    }
            } else {
        return applyCreateIndexRequestWithV1Templates(currentState, request, silent, Collections.emptyList(), metadataTransformer);  
        Map<String, String> remoteCustomData = new HashMap<>();
        List<String> validationErrors = new ArrayList<>();  
                    @SuppressWarnings("unchecked")
        // will always have the behavior of the min node in the cluster.  
            // this method applies all necessary checks ie. if the target shards are less than the source shards
        }  
            }  
        BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
            throw new IllegalArgumentException(
        }
                .searchRouting(alias.searchRouting())
import org.opensearch.common.ValidationException;
            throw new IllegalArgumentException(
        }  
                builder.copy(key, sourceMetadata.getSettings());
        Settings indexSettings,
    ) {
            if (numAllocations == numShards) {
/*  
                if (aliases.contains(new Alias(aliasMetadata.alias()))) {  
            } catch (Exception e) {
        ClusterState currentState,  
    }
        }
                    temporaryIndexMeta.isSystem(),
     * Stamps the dynamic cluster-level fencing default ({@code cluster.remote_store.fencing.enabled}) into the final
        // Create builders for the template and request settings. We transform these into builders
        return null;
    public static List<Map<String, Object>> collectV2Mappings(
     */
                }
                    + "=true]"
                templateMapping = Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, templateMapping.values().iterator().next());
/**  
            assert numAllocations <= numShards : "wait what? " + numAllocations + " is > than num shards " + numShards;
                        "removing default [{}] setting as it in set to null in the request for [{}] creation",  
            if (indexSettings.get(IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.getKey()) != null) {
                    request.ackTimeout(),
    }
    private ClusterState applyCreateIndexWithTemporaryService(  
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findContextTemplateName;
    }
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        Map<String, Object> mapperSettings = IndexMetadata.INGESTION_SOURCE_MAPPER_SETTINGS.getAsMap(settings);
        }
        final IndexMetadata.Builder tmpImdBuilder = IndexMetadata.builder(request.index());  
                indexSettingsBuilder.build()
            }  
        final Settings current = settingsBuilder.build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param settingsBuilder index settings builder to be updated with relevant settings
            indexScopedSettings,
        if (provider == null) {  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;  
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;  
        if (metadataTransformer != null) {
    }  
import org.opensearch.common.settings.IndexScopedSettings;
                    indexService.mapperService()::documentMapper,
        if (requestRefreshInterval.millis() < clusterMinimumRefreshInterval.millis()) {  
        assert assertNullOldType == false || Objects.isNull(existingCustomData);
            || requestSettings.get(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey()) == null  
        return mappings;  
        final boolean forbidPrivateIndexSettings,
        if (request.dataStreamName() != null) {  
         * that will be used to create this index.
        }  
            final Predicate<String> sourceSettingsPredicate = (s) -> (s.startsWith("index.similarity.")
    ) {
     */
    }  
        // a different strategy (e.g., modulo), which might cause correctness issues.
        return sourceMetadata;  
        List<String> validationErrors = new ArrayList<>();  
            );  
     * @param indexName name of the index being created
                    "mapper_type [field_mapping] requires all nodes in the cluster to be on version ["  
            );
import org.opensearch.cluster.routing.ShardRoutingState;  
                    + requestRefreshInterval  
        final ClusterState clusterState  
                        + minNodeVersion  
                    }
                // the context is only used for validation so it's fine to pass fake values for the  
                if (v1Templates.size() > 1) {
     * <p>
                        request.index()
                    validationException.addValidationErrors(
                    } else if (isMigratingToRemoteStore(clusterSettings)) {  
        if (isAllowedForPluggableDataFormat(indexName, clusterSettings)) {
        validateIndexName(request.index(), state);  
                    + IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey()
    /**
     * @param combinedTemplateSettings combined template settings which satisfy the index
        List<Map<String, Object>> result = new ArrayList<>();
     *
     * become active (as specified in {@link CreateIndexClusterStateUpdateRequest#waitForActiveShards()})
        BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
                    );
            }
import org.apache.logging.log4j.LogManager;
            // now that the mapping is merged we can validate the index sort.  
        this.awarenessReplicaBalance = awarenessReplicaBalance;  
        validateTranslogFlushIntervalSettingsForCompositeIndex(request.settings(), clusterSettings);  
 * Unless required by applicable law or agreed to in writing,
    }
            throw new InvalidIndexContextException(  
        Set<ClusterBlock> clusterBlocks,
            for (int shardId = 0; shardId < builder.numberOfShards(); shardId++) {
    ) {
        );
        }  
            // Check to see if a v2 template matched
        );
        }
    public static void validateIndexOrAliasName(String index, BiFunction<String, String, ? extends RuntimeException> exceptionCtor) {
            && !isRestoreFromSnapshot
     *
    }  
            indexScopedSettings,  
            final Version createdVersion = Version.min(Version.CURRENT, nodes.getSmallestNonClientNodeVersion());  
     */
        // Partition strategy validation. The setting key itself was introduced in V_3_7_0; reject any explicit
                currentState.metadata(),
     * @param requestSettings settings passed in during index create/update request  
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
    }  
import org.opensearch.action.admin.indices.alias.Alias;  
     * Validates {@code index.translog.flush_threshold_size} is equal or below the {@code indices.composite_index.translog.max_flush_threshold_size}
            indexReplicationType = CLUSTER_REPLICATION_TYPE_SETTING.get(nodeSettings);
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX;
            indexMetadataBuilder.putCustom(entry.getKey(), entry.getValue());
                    continue;
    /**  
import org.opensearch.common.logging.DeprecationLogger;
    private ClusterState applyCreateIndexRequestWithNoTemplates(
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
        String indexName  
            throw new OpenSearchException("Unable to determine length of index name", e);
        this.allocationService = allocationService;  
        Map<String, Object> parsedRequestMappings = MapperService.parseMapping(xContentRegistry, requestMappings);  
        Map<String, String> existingCustomData = tmpImdBuilder.removeCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
        final Settings settings,
        if (requestRefreshInterval.millis() == -1) {
        }  
                logger.log(silent ? Level.DEBUG : Level.INFO, "failed on parsing mappings on index creation [{}]", request.index(), e);
                    isHiddenFromRequest
        IndexMetadata.selectShrinkShards(0, sourceMetadata, IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings));  
                        v1Templates.stream().map(IndexTemplateMetadata::name).sorted().collect(Collectors.joining(", "))  
    }  
     * pluggable data-format default-stamping and restrict validation.  
            metadataTransformer
        int routingNumShards
                "index " + sourceIndex + " must block write operations to resize index. use \"index.blocks.write=true\""  
    public static List<AliasMetadata> resolveAndValidateAliases(
        // deprecate simplefs store type:
     * Returns {@code true} if the given index name matches any prefix in the
                && Boolean.parseBoolean(indexSettings.get(SETTING_REMOTE_STORE_ENABLED)) == false) {
                    + waitForActiveShards  
        //
        // Using applyCreateIndexRequestWithV1Templates with empty list instead of applyCreateIndexRequestWithV2Template
        if (sourceMetadata == null) {
        final Environment env,
    }
        numSplits = Math.max(1, numSplits); // Ensure the index can be split at least once
     */  
     * Validates (if this index has a dot-prefixed name) whether it follows the rules for dot-prefixed indices.  
        QueryShardContext queryShardContext
                        explicitSetting,
                logger.info("failed to build index metadata [{}]", request.index());
            throw new IllegalArgumentException("can't shrink an index with only one shard");  
import org.opensearch.index.remote.RemoteStorePathStrategy;
        }
            indexSettingProviders,  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;  
        // Determine the path type for use using the remoteStorePathResolver.
            || indexSettings.get(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey()) == null) {
     * @param clusterSettings cluster setting  
            if (minNodeVersion.before(Version.V_3_6_0)) {
    private static IndexMetadata.Builder createIndexMetadataBuilder(  
                    continue;
     *  
            } else {
        final int routingNumShards = getIndexNumberOfRoutingShards(aggregatedIndexSettings, sourceMetadata);  
        IngestionMessageMapper.MapperType mapperType = IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING.get(settings);
import org.opensearch.common.Nullable;
                    finalDisableObjectsValue = doc.get("disable_objects");
import java.io.UnsupportedEncodingException;
            && requestSettings.get(INDEX_REPLICATION_TYPE_SETTING.getKey())  
                .writeIndex(alias.writeIndex())
     * {@link IndexTemplateMetadata#order()}). This merging makes no distinction between field
                    mappings = templateMapping;  
    }
 */  
        final List<String> templatesApplied,
    public void validateIndexSettings(String indexName, final Settings settings, final boolean forbidPrivateIndexSettings)  
            && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(requestSettings)
            final Settings templateAndRequestSettings = Settings.builder().put(combinedTemplateSettings).put(request.settings()).build();  
     * to the head of the list, templates have the highest {@link IndexTemplateMetadata#order()})
            settings,
    public MetadataCreateIndexService(
                final Setting<?> setting = indexScopedSettings.get(key);  
import org.opensearch.index.translog.Translog;
import org.opensearch.common.util.set.Sets;  
                indexMetadata.getNumberOfReplicas()  
     * @param isHidden Whether or not this is a hidden index
        final Settings settings,
    private void validate(CreateIndexClusterStateUpdateRequest request, ClusterState state) {
     * Adds the 1) remote store path type 2) ckp as translog metadata information in custom data of index metadata.  
            MetadataIndexTemplateService.resolveSettings(templates),
        NamedXContentRegistry xContentRegistry,
                if (resolvedPath == null) {  
            throw new InvalidIndexNameException(index, "must be lowercase");
        }
            }  
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(MetadataCreateIndexService.class);
                return applyCreateIndexRequestWithNoTemplates(currentState, request, silent, metadataTransformer);
            indexReplicationType = INDEX_REPLICATION_TYPE_SETTING.get(combinedTemplateSettings);  
 */
    ) throws Exception {  
     * {@code cluster.restrict.pluggable.dataformat} is set to true.  
            .put(IndexMetadata.SETTING_ROUTING_PARTITION_SIZE, sourceMetadata.getRoutingPartitionSize())
            resolvedAliases.add(aliasMetadata);
                isHiddenFromRequest == null ? false : isHiddenFromRequest  
            }
        final Index resizeSourceIndex,  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING;
            try {
                currentState.metadata(),
        return validationErrors;
        final ShardLimitValidator shardLimitValidator,
     * created index needs to be gte than the maximum term in the source index).
import java.nio.file.Path;  
        Settings combinedTemplateSettings,
            return;
                searchReplicaCount,  
        ClusterState currentState,
        }
                request.context()
        final Settings.Builder builder = Settings.builder();
            );
                    + "=true]"
import org.opensearch.core.common.Strings;  
 *  
            // Loop through all the explicit index setting providers, adding them to the  
        if (remoteStoreCustomMetadataResolver == null) {
                if (aliasMetadata.alias().contains("{index}")) {
        Map<String, MappingMetadata> mappingsMetadata = new HashMap<>();
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
        // And in that case the index metadata replicated to older nodes would carry unknown settings.  
        final ResizeType type,
    private static void validateActiveShardCount(ActiveShardCount waitForActiveShards, IndexMetadata indexMetadata) {
    private static List<String> validateIndexCustomPath(Settings settings, @Nullable Path sharedDataPath) {
            // request settings, so that the precedence goes:
                aliasValidator,
    /**  
                    currentState.metadata(),
    ) throws Exception {
            );
                @Override
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        }
                if (mappings.isEmpty()) {
                    + IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey()
    }  
                    Stream.of(contextAlias),
            throw exceptionCtor.apply(index, "index name is too long, (" + byteCount + " > " + MAX_INDEX_NAME_BYTES + ")");
                    return new ClusterStateUpdateResponse(acknowledged);  
     * @param index The name of the index in question
    public ClusterState applyCreateIndexRequest(  
                throw new IllegalArgumentException(
        if (translogFlushSize.compareTo(compositeIndexMaxFlushSize) > 0) {  
                public ClusterState execute(ClusterState currentState) throws Exception {  
                    + request.index()  
    }  
            throw new IllegalStateException("index " + sourceIndex + " must have all shards allocated on the same node to shrink index");
        final AwarenessReplicaBalance awarenessReplicaBalance,
    static void validateTranslogDurabilitySettings(Settings requestSettings, ClusterSettings clusterSettings, Settings settings) {  
        }
        final IndexMetadata sourceMetadata,
        }
        }
             * the maximum primary term on all the shards in the source index. This ensures that we have correct
            request,
                IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(),
            indexService.getIndexEventListener().beforeIndexAddedToCluster(indexMetadata.getIndex(), indexMetadata.getSettings());  
        if (validationErrors.isEmpty() == false) {  
                .equals(clusterSettings.get(CLUSTER_REPLICATION_TYPE_SETTING).name()) == false) {
    ) {
        Settings indexSettings,  
            // (multi-partition consumer factory). The check will be wired here once available.  
     * Validates that {@code index.pluggable.dataformat.enabled} and {@code index.pluggable.dataformat} match the  
        Object finalDisableObjectsValue = null;  
                    + IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey()  
        final NamedXContentRegistry xContentRegistry,
                    MetadataIndexTemplateService.resolveAliases(currentState.metadata(), templateName).stream()
            xContentRegistry,  
     * @param clusterSettings cluster level settings  
        IndexMetadata.selectSplitShard(0, sourceMetadata, IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings));
        final AllocationService allocationService,
            // at this point. The validation will take place later in the process
import java.util.Set;
        return Optional.empty();
        // only select this automatically for indices that are created on or after 7.0 this will prevent this new behaviour
        remoteCustomData.put(IndexMetadata.TRANSLOG_METADATA_KEY, Boolean.toString(isTranslogMetadataEnabled));
        for (int i = aliases.size() - 1; i >= 0; i--) {
                // do not override settings that have already been set (for example, from the request)  
            indexReplicationType = INDEX_REPLICATION_TYPE_SETTING.get(requestSettings);
            for (Map.Entry<String, AliasMetadata> entry : templateAliasConfig.entrySet()) {
                updateIndexMappingsAndBuildSortOrder(indexService, request, updatedMappings, sourceMetadata, indexCreationValidators);  
            : existingCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY);
     */
            // Apply aware replica balance validation only to non system indices
        if (copySettings) {  
        if (request.context() != null && !isContextAllowed) {
                mappings.add(MapperService.parseMapping(xContentRegistry, componentTemplate.template().mappings().toString()));
import org.apache.logging.log4j.Logger;  
    /**
 * under the License.  
                    additionalIndexSettings.remove(explicitSetting);
            final String v2Template = MetadataIndexTemplateService.findV2Template(  
 * specific language governing permissions and limitations
     *  
        String indexName = indexMetadata.getIndex().getName();  
            DEPRECATION_LOGGER.deprecate(  
    }  
            Map<String, Object> parsedTemplateMapping = MapperService.parseMapping(xContentRegistry, templateMapping.string());
            if (docObj instanceof Map) {
        return validationErrors;  
import org.opensearch.cluster.AckedClusterStateUpdateTask;
 * KIND, either express or implied.  See the License for the
                    "index name [{}] starts with a dot '.', in the next major version, index names "
        Metadata metadata,
     */
            || requestSettings.get(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey()) == null) {
        IndexMetadata sourceMetadata = validateResize(state, sourceIndex, targetIndexName, targetIndexSettings);
                validationErrors.add("path.shared_data must be set in order to use custom data paths");  
        ClusterSettings clusterSettings,
    List<String> getIndexSettingsValidationErrors(final Settings settings, final boolean forbidPrivateIndexSettings, String indexName) {
            currentState,
            throw new IllegalArgumentException("validator must not be null");
            settingsBuilder.put(IndexSettings.INDEX_CONTEXT_CREATED_VERSION.getKey(), componentTemplate.version());
                if (doc.containsKey("disable_objects")) {
                    // tripping the below assertion, we can safely ignore it
            // "index.mysetting": "blah
     * into a map.
            IndexMetadata.getRoutingFactor(
    ) {  
        logger.trace(
    private static void updateIndexMappingsAndBuildSortOrder(
                routingNumShards = IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.get(indexSettings);  
    public boolean validateDotIndex(String index, @Nullable Boolean isHidden) {
import org.opensearch.index.mapper.MapperService;
import org.opensearch.index.IndexService;
                if (indexSettingsBuilder.keys().contains(key)) {
    }  
     * In a mixed cluster, older nodes may not recognize newer mapper types (e.g., field_mapping),
     * Calculates the number of routing shards based on the configured value in indexSettings or if recovering from another index  
                }
        }
        if (sourceMetadata.getNumberOfShards() == 1) {
                throw new IllegalArgumentException(
                    "You can configure '%s' with upto '%s' for composite index",
    /**
            indexSettingsBuilder.putNull(initialRecoveryIdFilter);  
        this.indexSettingProviders.add(provider);  
            int numAllocations = entries.getValue().get();  
    }
    }  
        validateIndexOrAliasName(index, InvalidIndexNameException::new);
    private static void validateSearchOnlyReplicasSettings(Settings indexSettings) {
                "Creating indices with soft-deletes disabled is no longer supported. "
     * @param currentState the current state to base the new state off of  
        ClusterSettings clusterSettings  
    private void normalizeRequestSetting(CreateIndexClusterStateUpdateRequest createIndexClusterStateRequest) {
            if (systemIndices.isSystemIndex(name)) {  
import org.opensearch.core.common.unit.ByteSizeValue;
     *
    ) throws IOException {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;  
    /**
import org.opensearch.ResourceAlreadyExistsException;  
                "invalid wait_for_active_shards["
        }
    }
                );
        validatePluggableDataFormatSettings(indexSettingsBuilder.build(), clusterSettings, request.index()).ifPresent(  
        if (StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.exists(requestSettings) == false
 * not use this file except in compliance with the License.
                translogRepo = RemoteStoreNodeAttribute.getTranslogRepoName(remoteNode.get().getAttributes());
        /*  
                currentState,  
                    hasDisableObjects = true;  
        final IndexMetadata temporaryIndexMeta,
        }  
            );
        indexSettingsBuilder.put(requestSettings.build());
        DocumentMapper mapper = documentMapperSupplier.get();  
        }
                indexScopedSettings  
        validateErrors(indexName, validationErrors);
                indexMetadata = buildIndexMetadata(
        ByteSizeValue translogFlushSize = INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(requestSettings);
                    + "] when ["
            throw new ResourceAlreadyExistsException(state.metadata().index(index).getIndex());
                xContentRegistry,  
                // if an alias with same name came with the create index request itself,
import org.opensearch.indices.IndexCreationException;
import org.opensearch.common.settings.Setting;
        }
        if (byteCount > MAX_INDEX_NAME_BYTES) {
        Optional<String> indexName  
                    String templatedAlias = aliasMetadata.alias().replace("{index}", index);
        // 5. Defaults to segment if remote store attributes on the cluster  
     * Creates an {@link IndexMetadata.Builder} for the provided index and sets a valid primary term for all the shards if a source
                    listener::onFailure  
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {  
        final List<Map<String, Object>> mappings,  
     * Validates the settings and mappings for shrinking an index.
                        logger.trace(() -> new ParameterizedMessage("[{}] failed to create", request.index()), e);
            request.mappings(),  
        final CreateIndexClusterStateUpdateRequest request,
            validateSplitIndex(currentState, resizeSourceIndex.getName(), resizeIntoName, indexSettingsBuilder.build());
        Settings.Builder settingsBuilder,
        }
        }
            // For all the explicit settings, we go through the template and request level settings
        // Also, older nodes would silently fall back to the default mapping while the user configured
        }
                        aliasMetadata.filter().uncompressed(),
    private ClusterState applyCreateIndexRequestWithV1Templates(  
        return indexSettings;
            // value).
            .build();  
                        + "[index.translog.retention.age] "  
        }  
        validateIndexSettings(request.index(), request.settings(), forbidPrivateIndexSettings);
        result.add(parsedRequestMappings);
                    + clusterMinimumRefreshInterval
                settingsBuilder.put(componentTemplate.template().settings());
                clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
            .put(builder.build())
            );
            // of if the source shards are divisible by the number of target shards  
        } else if (combinedTemplateSettings != null && INDEX_REPLICATION_TYPE_SETTING.exists(combinedTemplateSettings)) {
        validateIngestionSourceSettings(request.settings(), state);  
import java.util.HashMap;
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) throws Exception {  
            indexSettingsBuilder.put(SETTING_CREATION_DATE, Instant.now().toEpochMilli());  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
    ) throws Exception {
        if (requestSettings.hasValue(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey())
        updateRemoteStoreFencingSetting(settingsBuilder, clusterSettings);  
            return Optional.empty();  
                "store_type_setting",
        builder.setRoutingNumShards(routingNumShards);
            settingsBuilder.put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true);  
            throw exceptionCtor.apply(index, "must not be empty");
        }  
        String requestMappings,  
            return;
     * @param templatesApplied a list of the names of the templates applied, for logging
                    compositeIndexMaxFlushSize  
        }  
                    "Translog retention settings "
        normalizeRequestSetting(request);
                    return createIndexTaskKey;
        Metadata.Builder builder = Metadata.builder(currentState.metadata()).put(indexMetadata, false);  
        final String templateName,
    }
        if (nodesToAllocateOn.isEmpty()) {  
            "create-index [" + request.index() + "], cause [" + request.cause() + "]",
            builder.put(sourceMetadata.getSettings().filter(sourceSettingsPredicate));
        IndexMetadata sourceMetadata = validateResize(state, sourceIndex, targetIndexName, targetIndexSettings);
        // to prevent a user specifying this value when creating an index
        validateActiveShardCount(request.waitForActiveShards(), tempMetadata);  
    /**  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
    /**
                    + "] cannot differ from cluster default ["  
                    + "]"  
     * @param assertNullOldType flag to verify that the old remote store path type is null  
import org.opensearch.common.settings.Settings;  
        );
                    shardsAcknowledged -> {  
    public static void updateReplicationStrategy(  
     */  
                String.format(  
     * @param requestSettings settings passed in during index create request  
            indexSettingsBuilder.put(templateSettings.build());
            replicaValidationError.ifPresent(validationErrors::add);
        validateIndexReplicationTypeSettings(indexSettingsBuilder.build(), clusterSettings).ifPresent(validationErrors::add);
                aliasValidator,  
                            Collections.singletonList(  
        for (ShardRouting routing : table.shardsWithState(ShardRoutingState.STARTED)) {
     * All the requested changes are firstly validated before mutating the {@link ClusterState}.
        for (Map<String, Object> mapping : mappings) {  
     * @param request the create index request
            () -> new ParameterizedMessage("Added newCustomData={}, replaced oldCustomData={}", remoteCustomData, existingCustomData)
        }
            } else if (setting.isPrivateIndex()) {
        for (Map.Entry<String, DiffableStringMap> entry : customData.entrySet()) {  
    public static void validateTranslogFlushIntervalSettingsForCompositeIndex(Settings requestSettings, ClusterSettings clusterSettings) {  
        return Optional.empty();
        if (request.context() != null && findContextTemplateName(clusterService.state().metadata(), request.context()) == null) {
                }
        ClusterSettings clusterSettings,
        final String requestMappings,
    private ClusterState applyCreateIndexRequestWithV2Template(
                        if (shardsAcknowledged == false) {
        final Version indexVersionCreated = IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(indexSettings);
            indexSettingsBuilder.put(additionalIndexSettings.build());  
            || isMigratingToRemoteStore(clusterSettings)) {
        if (IndexModule.Type.SIMPLEFS.match(IndexModule.INDEX_STORE_TYPE_SETTING.get(settings))) {
        }
            final List<String> nodesToAllocateOn = validateShrinkIndex(  
                    );
            silent,  
        }
                DEPRECATION_LOGGER.deprecate(  
                    + "=true]"
                mapperService.merge(MapperService.SINGLE_MAPPING_NAME, mapping, MergeReason.INDEX_TEMPLATE);
import org.opensearch.core.index.Index;
import static java.util.stream.Collectors.toList;  
     * Returns a default number of routing shards based on the number of shards of the index. The default number of routing shards will
        String indexName  
        // Get the setting value
            return Optional.empty();  
        this.aliasValidator = aliasValidator;
        if (remoteStoreEnabled  
                "[simplefs] is deprecated and will be removed in 2.0. Use [niofs], which offers equal or better performance, "
            tmpImd,
import org.opensearch.cluster.ClusterState;  
                "mappings are not allowed when creating an index from a source index, " + "all mappings are copied from the source index"  
     *  
                indexMetadata.getNumberOfShards(),
            .stream()
                    index  
    ) {
                request.cause(),  
                aliasValidator.validateAliasFilter(alias.name(), alias.filter(), queryShardContext, xContentRegistry);
        );
        }
                AutoExpandSearchReplicas.SETTING.get(settings)
        }
        return validationErrors;  
            && source.getParentDataStream().getWriteIndex().getIndex().equals(sourceMetadata.getIndex())) {
                Stream.concat(Stream.of(contextAlias), MetadataIndexTemplateService.resolveAliases(templates).stream()).collect(toList()),
                request.index(),
    private final Set<IndexSettingProvider> indexSettingProviders = new HashSet<>();
                    validationErrors.add("custom path [" + customPath + "] is not a sub-path of path.shared_data [" + sharedDataPath + "]");
import org.opensearch.indices.InvalidIndexNameException;
        TimeValue clusterMinimumRefreshInterval = clusterSettings.get(IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING);
     * the timeout, then {@link CreateIndexClusterStateUpdateResponse#isShardsAcknowledged()} will
                    + "] can only be used with remote store enabled clusters"
        if (storeTypeSetting != null && storeTypeSetting.equals(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT.toString())) {
    }
    public static void validateTranslogRetentionSettings(Settings indexSettings) {
        }  
                    temporaryIndexMeta.getCustomData(),  
                    settingsBuilder.put(SETTING_REMOTE_STORE_ENABLED, true).put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, segmentRepo);  
                    Locale.ROOT,  
        @Nullable IndexMetadata sourceMetadata,
            if (componentTemplate.template().settings() != null) {
     * @param mappings List of mapping objects to process
                    aliasValidator.validateAliasFilter(
        this.shardLimitValidator = shardLimitValidator;
            return Optional.of(  
     * Creates the index into the cluster state applying the provided blocks. The final cluster state will contain an updated routing
            throw new IllegalArgumentException(
            || IndexMetadata.INGESTION_SOURCE_DECODER_SETTINGS.exists(settings)) {
            // Requires consumerFactory.getSourcePartitionCount() which is added in a follow-up PR
            // we cannot validate for index shrinking since the mapping is empty
                // found creation still works using the request's specified index settings  
            Collections.singletonList(mappings),  
                String.format(
            if (response.isAcknowledged()) {
     */  
        Settings.Builder settingsBuilder,
            );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
                    new String[] { request.index() },  
            && remoteStoreCustomMetadataResolver.isRemoteStoreRepoServerSideEncryptionEnabled()) {  
        final boolean forbidPrivateIndexSettings,
        final ClusterState currentState,
        List<IndexCreationValidator> indexCreationValidators  
        final ClusterState currentState,
        if (waitForActiveShards == ActiveShardCount.DEFAULT) {  
import org.opensearch.indices.SystemIndices;
                            logger.debug(
        final Map<String, Object> mappings = MapperService.parseMapping(xContentRegistry, request.mappings());  
        } else if (CLUSTER_REPLICATION_TYPE_SETTING.exists(nodeSettings)) {
            throw new IllegalArgumentException(
package org.opensearch.cluster.metadata;
            }
        List<Map<String, Object>> mappings,
        // It is possible that remote custom data exists already. In such cases, we need to only update the path type
    }  
                clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING)  
                                "[{}] index created, but the operation timed out while waiting for " + "enough shards to be started.",  
    private ClusterState applyCreateIndexRequestWithExistingMetadata(  
    ) {
                    "cannot resize the write index [%s] for data stream [%s]",
        ComposableIndexTemplate template = currentState.getMetadata().templatesV2().get(templateName);
            prepareResizeIndexSettings(
            for (String explicitSetting : additionalIndexSettings.keys()) {  
            return Optional.empty();  
        validateContext(request);
     * @param requestSettings settings passed in during index create/update request
                        + "starting with a dot are reserved for hidden indices and system indices",
            } else if (isHidden) {
            nodesToNumRouting.computeIfAbsent(routing.currentNodeId(), (s) -> new AtomicInteger(0)).incrementAndGet();
                || s.startsWith("index.analysis.")
     * The access level of the method changed to default level for visibility to test.  
        final boolean copySettings,  
    /**
import java.util.function.Supplier;
                validateOverlap(settingsBuilder.keys(), componentTemplate.template().settings(), request.index()).ifPresent(message -> {
                );  
        // validator which cross-checks index.replication.type, and this helper also runs from snapshot restore's
        updateRemoteStoreSettings(indexSettingsBuilder, currentState, clusterSettings, settings, request.index());  
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
     * the cluster state, then {@link CreateIndexClusterStateUpdateResponse#isAcknowledged()} will return
     * Validate the name for an index or alias against some static rules.  
                .getNodes()
            mappingsMetadata.put(mapper.type(), mappingMd);  
                    + clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)  
        List<String> validationErrors = getIndexSettingsValidationErrors(settings, forbidPrivateIndexSettings, indexName);
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
        // whether to stamp a default is not this method's place to validate the settings it is handed.
    /**  
 *
    private AwarenessReplicaBalance awarenessReplicaBalance;
     * the index added (and rerouted)
public class MetadataCreateIndexService {
            return clusterStateCreateIndex(currentState, request.blocks(), indexMetadata, allocationService::reroute, metadataTransformer);
        return rerouteRoutingTable.apply(updatedState, "index [" + indexName + "] created");  
                    + clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING)
            // also from the template and request settings, so that from the newly create index's  
     */
                    + (indexMetadata.getNumberOfReplicas() + 1)
                    );  
        shardLimitValidator.validateShardLimit(request.index(), indexSettings, currentState);
        indexSettingsBuilder.put(SETTING_INDEX_UUID, UUIDs.randomBase64UUID());  
            silent,  
 */
        if (state.metadata().hasIndex(index)) {  
import java.util.Collections;  
        final ReplicationType indexReplicationType;  
                    + "Please do not specify a value for setting [index.soft_deletes.enabled]."  
            null,
            // TODO: For source_partition_strategy=simple, surface a warning when numSourcePartitions > numShards
        final IndexMetadata sourceMetadata,
        final IndexMetadata.Builder builder = IndexMetadata.builder(indexName);  
            throw exceptionCtor.apply(index, "must not start with '_', '-', or '+'");
 * SPDX-License-Identifier: Apache-2.0
        ClusterSettings clusterSettings,
     * Parses the provided mappings json and the inheritable mappings from the templates (if any)  
    }
        }
                IndexMetadata.SETTING_NUMBER_OF_REPLICAS,  
                        + "]"
 * @opensearch.internal  
                "Cannot apply context template as user provide settings have overlap with the included context template."
        final List<Map<String, Object>> mappings = collectV2Mappings(
    }
        IndexScopedSettings indexScopedSettings,  
            currentState,
        final NamedXContentRegistry xContentRegistry  
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
            );
    private final ActiveShardsObserver activeShardsObserver;  
                    sourceIndex,  
     * @param sourceMetadata when recovering from an existing index, metadata that should be copied to the new index  
                // shard id and the current timestamp  
            final long primaryTerm = IntStream.range(0, sourceMetadata.getNumberOfShards())
import org.opensearch.index.mapper.MapperService.MergeReason;  
                    "index_name_starts_with_dot",  
        if (IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(current) == false) {
            );
    private static final Logger logger = LogManager.getLogger(MetadataCreateIndexService.class);  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING;  
    static ClusterState clusterStateCreateIndex(
        final boolean silent,
            } else {
        return applyCreateIndexWithTemporaryService(
        // Set up everything, now locally create the index to see that things are ok, and apply
    public void addRemoteStoreCustomMetadata(IndexMetadata.Builder tmpImdBuilder, boolean assertNullOldType, ClusterState clusterState) {
            }
                    requestSettings.remove(explicitSetting);
     * allow any index to be split at least once and at most 10 times by a factor of two. The closer the number or shards gets to 1024  
import org.apache.logging.log4j.message.ParameterizedMessage;
        indexSettingsBuilder.put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), sourceMetadata.getCreationVersion())
            return;
                request.index(),
        return allowlist.stream().anyMatch(indexName::startsWith);
    ) throws IOException {
        String indexName  
                    + "=true]"  
            ),
        IndexMetadata tmpImd = buildAndValidateTemporaryIndexMetadata(aggregatedIndexSettings, request, routingNumShards, currentState);  
     * @param settings the index configured settings  
 * You may obtain a copy of the License at  
        ShardLimitValidator shardLimitValidator,
        }  
        boolean hasDisableObjects = false;
            indexMetadataBuilder.putAlias(aliases.get(i));  
                request.context().name(),
                Optional.ofNullable(contextTemplate).map(Template::aliases).orElse(Map.of())
    static Optional<String> validateOverlap(Set<String> requestSettings, Settings contextTemplateSettings, String indexName) {
            );  
            throw new IllegalArgumentException(
            /*
                }
    private final AllocationService allocationService;
        }
     */
            parseV1Mappings(
                resizeSourceIndex.getName(),
                    continue; // Skip null mappings  
     *
            // copy all settings and non-copyable settings and settings that have already been set (e.g., from the request)
 *
        if (source.getParentDataStream() != null  
            // Hidden indices apply templates slightly differently (ignoring wildcard '*'
                );
     * @param sharedDataPath the configured `path.shared_data` (if any)
     * templates.
        } else if (type == ResizeType.CLONE) {
     * ({@link CreateIndexClusterStateUpdateResponse#isShardsAcknowledged()} will also be false).  If the index  
            indexReplicationType = ReplicationType.SEGMENT;
        normalizeRequestSetting(request);  
    /**
        ClusterSettings clusterSettings
            clusterService.getClusterSettings()
        clusterService.submitStateUpdateTask(
import org.opensearch.common.io.PathUtils;
import java.util.Map;
     *
            indexSettingProviders,
        if (state.metadata().hasIndex(targetIndexName)) {
     * @param requestSettings settings passed in during index create request
        final String templateName,  
            && IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(indexSettings).onOrAfter(Version.V_2_0_0)) {  
                request.index(),
                    "To set " + SETTING_NUMBER_OF_SEARCH_REPLICAS + ", " + SETTING_REMOTE_STORE_ENABLED + " must be set to true"  
            final Boolean isHiddenFromRequest = IndexMetadata.INDEX_HIDDEN_SETTING.exists(request.settings())
                }
            indexService.getIndexSortSupplier().get();
                    request.index(),
    }
        return applyCreateIndexWithTemporaryService(  
        }  
            throw exceptionCtor.apply(index, "must not contain '#'");
        }
            }  
                    XContentHelper.mergeDefaults(mappings, templateMapping);
        }
                        + "]"
     * @param clusterSettings cluster setting  
    }
            if (remoteNode.isPresent()) {
            // (excess source partitions are silently never consumed) and an error when  
        return Optional.empty();  
    ) {
            && IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.exists(current) == false
        final String indexName  
        remoteStoreCustomMetadataResolver = RemoteStoreNodeAttribute.isSegmentRepoConfigured(settings)
                Object docObj = mapping.get(MapperService.SINGLE_MAPPING_NAME);  
                .equals(clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)) == false) {
import org.opensearch.indices.RemoteStoreSettings;  
                }  
     */  
     * the less default split operations are supported
 * software distributed under the License is distributed on an
        }
                    provider.getAdditionalIndexSettings(request.index(), isDataStreamIndex, templateAndRequestSettings)
        indexMetadataBuilder.state(IndexMetadata.State.OPEN);  
        final boolean isContextAllowed = FeatureFlags.isEnabled(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES);  
            templateName,
            && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(requestSettings)  
            return componentTemplate.template();
        CreateIndexClusterStateUpdateRequest request,
            if (mapping != null) {
     */
            sourceMetadata,
    }
                sourceMetadata.getNumberOfShards(),
    private static void updateRemoteStoreFencingSetting(Settings.Builder settingsBuilder, ClusterSettings clusterSettings) {
        }
                String.format(
                    INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
     *  
            // Finally, we actually add the explicit defaults prior to the template settings and the  
import org.opensearch.common.unit.TimeValue;
                aliasValidator,  
        // because we may want settings to be "removed" from these prior to being set on the new  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;  
        for (Map.Entry<String, AtomicInteger> entries : nodesToNumRouting.entrySet()) {
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
            Collections.singletonList(templateName),
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;
        final Settings.Builder indexSettingsBuilder,
            throw exceptionCtor.apply(index, "must not be '.' or '..'");
import org.opensearch.index.shard.IndexSettingProvider;  
     * creation in the cluster state was successful and the requisite shard copies were started before
        remoteCustomData.put(PathType.NAME, newPathStrategy.getType().name());  
    }  
        );
        createIndexTaskKey = clusterService.registerClusterManagerTask(CREATE_INDEX, true);  
import static org.opensearch.cluster.metadata.Metadata.DEFAULT_REPLICA_COUNT_SETTING;  
        } else {
        IndexAbstraction source = state.metadata().getIndicesLookup().get(sourceIndex);
                request.copySettings(),
        List<AliasMetadata> aliases,
        Settings.Builder settingsBuilder,
    /**
                    + Sets.intersection(requestSettings, contextTemplateSettings.keySet())  
        Settings settings,
    ) throws Exception {  
                );
            );
        if (settings.get(SETTING_AUTO_EXPAND_REPLICAS) != null && indexSettingsBuilder.get(SETTING_AUTO_EXPAND_REPLICAS) == null) {
        }, listener::onFailure));
                    + indexName
        }  
            }
        if (isAllowedForPluggableDataFormat(indexName, clusterSettings)) {  
    }  
     */  
        }
        if (durability.equals(Translog.Durability.ASYNC)) {
                                request.index()
import java.util.List;  
                }
                );
        if ((isRemoteDataAttributePresent(nodeSettings)
        if (!index.toLowerCase(Locale.ROOT).equals(index)) {  
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
    @Nullable
        if (requestSettings.stream().anyMatch(contextTemplateSettings::hasValue)) {
                if (segmentRepo != null) {
        Settings requestSettings,
            );  
    static void validateIngestionSourceSettings(Settings settings, ClusterState state) {  
    public void addIndexCreationValidator(IndexCreationValidator validator) {  
        } else {  
            tmpImd,
            CompositeIndexValidator.validate(mapperService, indexService.getCompositeIndexSettings(), indexService.getIndexSettings());
     */
        final IndexRoutingTable table = state.routingTable().index(sourceIndex);
        }
    Template applyContext(
            indexSettingsBuilder.put(SETTING_AUTO_EXPAND_REPLICAS, settings.get(SETTING_AUTO_EXPAND_REPLICAS));
     */  
                throw e;
import org.opensearch.action.support.ActiveShardsObserver;
            // (when all shards are copied in a single place).  
            }
        if (indexSettingsBuilder.get(SETTING_CREATION_DATE) == null) {
            if (Strings.hasLength(alias.filter())) {
            updatedMappings.addAll(mappings);
    ) {
            indexSettingProviders,  
     * <p>  
            templates.stream().map(IndexTemplateMetadata::name).collect(Collectors.toList())  
                // the context is only used for validation so it's fine to pass fake values for the
        // now, put the request settings, so they override templates
        for (CompressedXContent mapping : templateMappings) {  
                .filter(alias.filter())
            Settings.Builder tmpSettingsBuilder = Settings.builder().put(temporaryIndexMeta.getSettings());
        }
        return routingNumShards;  
            }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        this.settings = settings;  
        );
        // 3. Template property for replication type
        Settings nodeSettings,  
        logger.info("applying create index request using existing index [{}] metadata", sourceMetadata.getIndex().getName());
        String sseEnabledIndex = existingCustomData == null
        Settings indexSettings  
                        + minNodeVersion
                    + "]: cannot be greater than number of shard copies ["
        if (IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(current) == false) {  
                    } else {
                if (templatesAliases.containsKey(entry.getKey())) {
        ByteSizeValue compositeIndexMaxFlushSize = clusterSettings.get(  
        final BiFunction<IndexService, Map<String, AliasMetadata>, List<AliasMetadata>> aliasSupplier,
import org.opensearch.action.support.ActiveShardCount;  
                "index setting ["  
                        + "] or later, but the minimum node version is ["
                }  
        // If default value (-1), no validation needed  
        if (indexName.isEmpty() || indexName.get().charAt(0) != '.') {  
     * Ensures this setting is only specified for remote store enabled clusters.
     * @param clusterState state of cluster
        List<Map<String, Object>> mappings,
        final BiConsumer<Metadata.Builder, IndexMetadata> metadataTransformer
     * Validates {@code index.translog.durability} is not async if the {@code cluster.remote_store.index.restrict.async-durability} is set to true.
     * Validates ingestion source settings for version compatibility and mapper settings correctness.
        if (sourceMetadata != null) {  
                }
    }  
        final boolean silent,  
                    + "] when ["
            ValidationException validationException = new ValidationException();
     * @param requestSettings settings passed in during index create/update request  
     * @param request the index creation cluster state update request
            ),
        return builder;  
                throw new IllegalArgumentException(
    private final Settings settings;
                        + "in the cluster to be on version ["  
                indexService,
                    compositeIndexMaxFlushSize  
     * clone), the resize settings.
            );
            throw new IndexCreationException(indexName, validationException);  
                xContentRegistry,
import org.opensearch.index.remote.RemoteStoreCustomMetadataResolver;
            return; // No overrides needed for null, empty, or single mapping  
                currentState.metadata(),
        }
        final CreateIndexClusterStateUpdateRequest request,
        // Find the last (highest priority) disable_objects value  
            throw new IllegalArgumentException(
        }  
import org.opensearch.core.action.ActionListener;
        if (IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING.exists(settings) == false) {  
        for (Alias alias : aliases) {
            return applyCreateIndexRequestWithExistingMetadata(currentState, request, silent, sourceMetadata, metadataTransformer);  
            .put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), resizeSourceIndex.getName())  
            currentState,
        List<String> nodesToAllocateOn = new ArrayList<>();
                throw e;  
            Version minNodeVersion = state.nodes().getMinNodeVersion();
        }
            Template contextTemplate = applyContext(request, currentState, updatedMappings, tmpSettingsBuilder);  
        builder.settings(indexSettings);
     *
                aliasValidator.validateAliasMetadata(aliasMetadata, index, metadata);  
        }
                    templateSettings.remove(explicitSetting);
            }
            );  
            // numSourcePartitions < numShards (shards beyond numSourcePartitions-1 fail to initialize).
                @Override
        if (INDEX_NUMBER_OF_REPLICAS_SETTING.exists(indexSettingsBuilder) == false  
        }
    /**
     * The template mappings are applied in the order they are encountered in the list (clients should make sure the lower index, closer
        Context context  
    }  
        }
                ).collect(toList()),  
            if (v2Template != null) {  
                    + "] cannot differ from cluster default ["
            final Setting<?> setting = indexScopedSettings.get(key);
        Settings requestSettings,
import java.util.HashSet;
            }
     */
}
        final CreateIndexClusterStateUpdateRequest request,  
            sourceMetadata,
        final IndexMetadata sourceMetadata = recoverFromIndex == null ? null : currentState.metadata().getIndexSafe(recoverFromIndex);
import java.util.function.BiConsumer;
        }  
        List<CompressedXContent> templateMappings = MetadataIndexTemplateService.collectMappings(currentState, templateName, indexName);
                || s.equals("index.soft_deletes.enabled")) && indexSettingsBuilder.keys().contains(s) == false;
                }
import org.opensearch.cluster.routing.IndexRoutingTable;  
            settingsBuilder.put(IndexSettings.INDEX_CONTEXT_CURRENT_VERSION.getKey(), componentTemplate.version());  
     * cluster-level defaults {@code cluster.pluggable.dataformat.enabled} and
    private final RemoteStoreCustomMetadataResolver remoteStoreCustomMetadataResolver;
        // apply templates, merging the mappings into the request mapping if exists
    /**
     * Validates {@code index.refresh_interval} is equal or below the {@code cluster.minimum.index.refresh_interval}.
        return tempMetadata;
    }
    public IndexScopedSettings getIndexScopedSettings() {
                );
                DEPRECATION_LOGGER.deprecate(
        return indexScopedSettings;
        // Settings validation to the mapper  
        assert IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexSettings);
                );
    List<String> getIndexSettingsValidationErrors(  
                    aliases,  
            shardLimitValidator,
import org.opensearch.cluster.routing.RoutingTable;
     */  
        final NamedXContentRegistry xContentRegistry,
            request,  
        validateTranslogRetentionSettings(indexSettings);  
        }
    static int getIndexNumberOfRoutingShards(Settings indexSettings, @Nullable IndexMetadata sourceMetadata) {  
        boolean isTranslogMetadataEnabled = remoteStoreCustomMetadataResolver.isTranslogMetadataEnabled();
import org.opensearch.index.mapper.DocumentMapper;
        } else if (remoteNode.isPresent()
                assert templateMapping.size() == 1 : "expected exactly one mapping value, got: " + templateMapping;
            );
        if (type == ResizeType.SHRINK) {
        final int routingNumShards,
    private void onlyCreateIndex(
        return indicesService.<ClusterState, Exception>withTempIndexService(temporaryIndexMeta, indexService -> {  
     * <p>  
            || IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.exists(requestSettings) == false
            : null;
        if (requestSettings.hasValue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey())  
        if (indexSettingProviders.contains(provider)) {  
        @Nullable IndexMetadata sourceMetadata,
        List<CompressedXContent> templateMappings,
        }
        }
    /**
        if (IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.exists(requestSettings) == false
    }  
            || indexSettingsBuilder.get(SETTING_NUMBER_OF_REPLICAS) == null) {
            aliasValidator.validateAlias(alias, index, metadata);  
     * {@link CreateIndexClusterStateUpdateRequest}, inherited from templates and, if recovering from another index (ie. split, shrink,
    /**
import java.time.Instant;
import org.opensearch.env.Environment;
    private static Optional<String> validatePluggableDataFormatSettings(  
        }
import org.opensearch.common.settings.ClusterSettings;  
        final ClusterService clusterService,  
                    }
        final Settings aggregatedIndexSettings = aggregateIndexSettings(
        final IndexMetadata sourceMetadata = currentState.metadata().index(resizeSourceIndex.getName());
            throw new InvalidIndexNameException(index, "already exists as alias");
                @SuppressWarnings("unchecked")
        validateSearchOnlyReplicasSettings(indexSettings);
    }
                }
                // the context is only used for validation so it's fine to pass fake values for the
                )
        IngestionMessageMapper.validateSettings(mapperType, mapperSettings);
            CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING
        }
     * @param clusterSettings cluster setting
                IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings)  
        if (INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.exists(indexSettings) && indexSettings.get(SETTING_NUMBER_OF_SEARCH_REPLICAS) != null) {
    /**
        return applyCreateIndexRequest(currentState, request, silent, null);
    }  
        if (index.contains(":")) {  
            String segmentRepo, translogRepo;
        }
            // UTF-8 should always be supported, but rethrow this if it is not for some reason
import java.util.stream.Stream;
        for (Map<String, AliasMetadata> templateAliasConfig : templateAliases) {  
                .isHidden(alias.isHidden())  
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * Modifications Copyright OpenSearch Contributors. See
                currentState.metadata(),
            // Explicit Defaults -> Template -> Request -> Necessary Settings (# of shards, uuid, etc)
     * @return a new cluster state with the index added
            ? new RemoteStoreCustomMetadataResolver(remoteStoreSettings, minNodeVersionSupplier, repositoriesServiceSupplier, settings)  
        }
            AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
            return;  
                }  
            indexMetadataBuilder.putMapping(mappingMd);
            null,
     * the new index, returning an {@link IndexMetadata} for the new index.
        int routingNumShards = getIndexNumberOfRoutingShards(aggregatedIndexSettings, null);
    }  
        }
     * window in which a stale primary is checked against neither the fence nor the replicas. Baking the cluster value
        if (sourceMetadata != null) {
                    + IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING.getKey()
        return applyCreateIndexWithTemporaryService(  
                        settingsBuilder.put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, translogRepo);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
        }
        if (forbidPrivateIndexSettings) {  
            validationErrors::add
     */
        Map<String, DiffableStringMap> customData,
        for (IndexCreationValidator validator : indexCreationValidators) {
    }
        // 4. Replication type according to cluster level settings
                }  
     * Validates {@code index.translog.flush_threshold_size} is equal or below the {@code indices.composite_index.translog.max_flush_threshold_size}  
     * @param temporaryIndexMeta metadata for the new index built from templates, source metadata, and request settings
            return;  
                // Settings applied at last
            return Optional.of(  
                segmentRepo = RemoteStoreNodeAttribute.getSegmentRepoName(remoteNode.get().getAttributes());  
            );
        int routingNumShards = getIndexNumberOfRoutingShards(aggregatedIndexSettings, null);  
    static Settings aggregateIndexSettings(  
            final IndexMetadata indexMetadata;
                        "index [{}] matches multiple legacy templates [{}], composable templates will only match a single template",
import org.opensearch.cluster.routing.allocation.AllocationService;
        final CreateIndexClusterStateUpdateRequest request,  
                xContentRegistry
        Map<String, AtomicInteger> nodesToNumRouting = new HashMap<>();
        if (sourceMetadata == null) {  
        // once we are allocated.
                        aliasMetadata.alias(),  
        logger.debug("applying create index request using composable template [{}]", templateName);  
        if (mapperType == IngestionMessageMapper.MapperType.FIELD_MAPPING) {
        return blocksBuilder;
                        logger.debug(() -> new ParameterizedMessage("[{}] failed to create", request.index()), e);  
        }
            || requestSettings.get(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey()) == null) {  
        if (request.dataStreamName() == null && template.getDataStreamTemplate() != null) {  
            shardLimitValidator,
        validateErrors(request.index(), validationErrors);  
            indexSettingsBuilder.put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), createdVersion);
import org.opensearch.index.IndexNotFoundException;
    private static ClusterBlocks.Builder createClusterBlocksBuilder(ClusterState currentState, String index, Set<ClusterBlock> blocks) {  
            settingsBuilder.put(
    private final Environment env;
            ),
            clusterService.getClusterSettings()
        updatePluggableDataFormatSettings(indexSettingsBuilder, clusterSettings, request.index());
     */
     * @param clusterSettings cluster setting
     * Given a state and index settings calculated after applying templates, validate metadata for  
        final CreateIndexClusterStateUpdateRequest request,
        if ((isRemoteDataAttributePresent(settings) == false && isMigratingToRemoteStore(clusterSettings) == false)
                    + "] or ["
        if (INDEX_NUMBER_OF_SHARDS_SETTING.exists(indexSettingsBuilder) == false) {  
        // create the index here (on the master) to validate it can be created, as well as adding the mapping
    public static void updatePluggableDataFormatSettings(  
        );
import org.opensearch.cluster.ack.CreateIndexClusterStateUpdateResponse;
        final int routingNumShards;  
        settingsBuilder.put(SETTING_REPLICATION_TYPE, indexReplicationType);
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        }
     * node attributes  
                // ignore this one taken from the index template
        int indexRemoteCapablePrimaryShardsPerNode = INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);
        IndexService indexService,
            if (systemIndices.validateSystemIndex(index)) {  
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
        return Optional.empty();
                // Allow templatesAliases to be templated by replacing a token with the
                    // Override with the final disable_objects value
            throw new IllegalArgumentException(
        );
        final IndexMetadata sourceMetadata = state.metadata().index(sourceIndex);
        Set<IndexSettingProvider> indexSettingProviders,
                resolvedAliases.add((aliasMetadata));
                    temporaryIndexMeta.context()
        // value (including [simple], the default) on mixed clusters where some nodes don't recognize the key.
        if (FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG) == false) {
        );
        Settings combinedTemplateSettings,  
                        + "] or later, but the minimum node version is ["
        onlyCreateIndex(request, ActionListener.wrap(response -> {  
        if (request.context() != null) {
    }
        blocks.updateBlocks(indexMetadata);
    private final boolean forbidPrivateIndexSettings;
                @Override
            }
                .indexRouting(alias.indexRouting())  
    ) {
                "index setting [index.replication.type] is not allowed to be set as ["  
    public static final int MAX_INDEX_NAME_BYTES = 255;  
        );
     * @param tmpImdBuilder     index metadata builder.
            ComponentTemplate componentTemplate = MetadataIndexTemplateService.findComponentTemplate(  
    }  
    }  
            } catch (Exception e) {  
        // We use as a default number of routing shards the higher number that can be expressed
                        + Version.V_3_6_0
             * We need to arrange that the primary term on all the shards in the shrunken index is at least as large as  
        );
                    + "]: cannot be smaller than cluster.minimum.index.refresh_interval ["
        Settings build = updatedSettingsBuilder.put(createIndexClusterStateRequest.settings())
        }
        List<AliasMetadata> resolvedAliases = new ArrayList<>();
    static Map<String, Object> parseV1Mappings(
        Optional<DiscoveryNode> remoteNode = clusterState.nodes()
        tmpImdBuilder.settings(aggregatedIndexSettings);
        // now check that index is all on one node  
        final Settings current = settingsBuilder.build();
                    + "]"  
            result.add(parsedTemplateMapping);  
import java.util.function.Predicate;  
        IndexMetadata tempMetadata = tmpImdBuilder.build();
                .findFirst();  
                indexService.newQueryShardContext(0, null, () -> 0L, null)
            MetadataIndexTemplateService.resolveSettings(currentState.metadata(), templateName),  
                .stream()
            Optional<String> searchReplicaValidationError = awarenessReplicaBalance.validate(
    /**
                        + "]"
        if (index.contains("#")) {  
        // 2. Explicit index creation request parameter  
            } else {
    public static int calculateNumRoutingShards(int numShards, Version indexVersionCreated) {  
            // templates), so we need to check to see if the request is creating a hidden index
                    assert indexScopedSettings.isPrivateSetting(key) : key;
        // Decoder settings validation. Both decoder_type and decoder_settings.* were introduced in V_3_8_0.  
        if (index.isEmpty()) {  
                    aliasMetadata = AliasMetadata.newAliasMetadata(aliasMetadata, templatedAlias);  
     * ensuring template priority ordering is respected.  
            } else {
            Collections.singletonList(mappings),  
                    + "Please remove the settings ["
        } else if (INDEX_REPLICATION_TYPE_SETTING.exists(requestSettings)) {  
        NamedXContentRegistry xContentRegistry
        String storeTypeSetting = request.settings().get(INDEX_STORE_TYPE_SETTING.getKey());  
                additionalIndexSettings.put(  
            && clusterSettings.get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(RemoteStoreNodeService.CompatibilityMode.STRICT))  
        }  
     * @return the aggregated settings for the new index
 * license agreements. See the NOTICE file distributed with
            currentState,
import org.opensearch.index.query.QueryShardContext;
        ClusterBlocks.Builder blocks = createClusterBlocksBuilder(currentState, indexName, clusterBlocks);
         */  
        final Supplier<RepositoriesService> repositoriesServiceSupplier
                nodesToAllocateOn.add(entries.getKey());  
        }
    }
            indexReplicationType = CLUSTER_REPLICATION_TYPE_SETTING.getDefault(nodeSettings);  
                return applyCreateIndexRequestWithV2Template(currentState, request, silent, v2Template, metadataTransformer);  
        indexMetadataBuilder.system(isSystem);  
            return;  
            }
                public void onFailure(String source, Exception e) {
        }  
        }
        int log2MaxNumShards = 10; // logBase2(1024)
        ClusterSettings clusterSettings,
        } else {
        }  
                    + "] that creates data streams only, "  
        final ClusterState currentState,
     * <p>
     * Validates and creates the settings for the new index based on the explicitly configured settings via the  
            int searchReplicaCount = settings.getAsInt(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0);  
                Collections.emptyList(),
                "[{}] creating index, cause [{}], templates {}, shards [{}]/[{}]",
                }  
                                "Cluster is migrating to remote store but remote translog is not configured, failing index creation"
        }
    }
        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(indexSettings)) {  
        }
        }
                return true;
                IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(),  
                } else if (setting.getProperties().contains(Setting.Property.NotCopyableOnResize)) {  
     * Stamps the cluster-scope defaults for the pluggable data-format index settings into the
    ) {
        AliasValidator aliasValidator,  
                    "index.ingestion_source.decoder_type and index.ingestion_source.decoder_settings require all nodes "
        final Settings aggregatedIndexSettings,  
     * for composite indices based on {{@code index.composite_index}}
import org.opensearch.threadpool.ThreadPool;
        validateStoreTypeSettings(indexSettings);
        if (validator == null) {
        validateIndexTotalPrimaryShardsPerNodeSetting(indexSettings);  
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;  
                );  
    }
        }
    }
        }  
        final boolean silent,
            try {  
    }
     */
     *                            creates the index  
        ByteSizeValue compositeIndexMaxFlushSize = clusterSettings.get(  
        if (clusterSettings.get(IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING)
                // shard id and the current timestamp
                request.recoverFrom(),
            && requestSettings.hasValue(SETTING_REPLICATION_TYPE)
                    // Someone provided an empty '{}' for mappings, which is okay, but to avoid
            return Optional.of(
     * pluggable data-format feature flag is disabled or the index matches the allowlist.
    private final IndicesService indicesService;
        indexMetadataBuilder.context(context);
            .filter(DiscoveryNode::isRemoteSegmentStoreNode)
     * should make sure the lower index, closer to the head of the list, templates have the highest
        if (mapperService.isCompositeIndexPresent()) {  
        tmpImdBuilder.setRoutingNumShards(routingNumShards);
        // apply the aliases in reverse order as the lower index ones have higher order
    /**
            throw new ResourceAlreadyExistsException(state.routingTable().index(index).getIndex());
        int numShards = sourceMetadata.getNumberOfShards();  
                    + INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
     * Add a provider to be invoked to get additional index settings prior to an index being created  
                    "translog_retention",
        @Nullable IndexMetadata sourceMetadata,  
        }  
        final CreateIndexClusterStateUpdateRequest request,
                if (templateSettings.keys().contains(explicitSetting) && templateSettings.get(explicitSetting) == null) {
    ) {
            )
        }
     */
            Optional<DiscoveryNode> remoteNode = clusterState.nodes()
         * We can not validate settings until we have applied templates, otherwise we do not know the actual settings
     * The template mappings are applied in the order they are encountered in the list (clients should make sure the lower index, closer
import org.opensearch.cluster.service.ClusterService;
            if (mapping.isEmpty() == false) {
                    Locale.ROOT,  
        final Settings.Builder templateSettings = Settings.builder().put(combinedTemplateSettings);
                }
    public void createIndex(
        if (mapper != null) {
            validationException.addValidationErrors(validationErrors);
                .values()  
                .filter(DiscoveryNode::isRemoteSegmentStoreNode)
        indexSettingsBuilder.put(IndexMetadata.SETTING_INDEX_PROVIDED_NAME, request.getProvidedName());
        }
    private final SystemIndices systemIndices;
     *
        Map<String, AliasMetadata> templatesAliases = new HashMap<>();
                templates.stream().map(IndexTemplateMetadata::getMappings).collect(toList()),  
     * @param clusterSettings cluster level settings  
        if (isRestoreFromSnapshot && sseEnabledIndex != null) {
            MappingMetadata mappingMd = new MappingMetadata(mapper);
            }
        if (state.blocks().indexBlocked(ClusterBlockLevel.WRITE, sourceIndex) == false) {
            currentState,
        Set<Alias> aliases,  
            (indexService, contextAlias) -> resolveAndValidateAliases(
            // We want to remove the explicit setting not only from the explicitly set settings, but
        this.indexScopedSettings = indexScopedSettings;  
     * Validates that the configured index data path (if any) is a sub-path of the configured shared data path (if any)
        final ClusterState currentState,
     * @param silent a boolean for whether logging should be at a lower or higher level
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
        }
            // additionalIndexSettings map
    /**
        }
import org.opensearch.common.Priority;  
import java.util.stream.IntStream;  
            // perspective it is as though the setting has not been set at all (using the default
                    throw validationException;
     */
    private final IndexScopedSettings indexScopedSettings;
    static void validateCloneIndex(ClusterState state, String sourceIndex, String targetIndexName, Settings targetIndexSettings) {
            return Optional.of(
     * setting is final because the fence is the primary's write witness: toggling it on a live index would leave a  
                // see: https://github.com/opensearch-project/OpenSearch/issues/1019
        // override-settings step - where restoring a remote-store snapshot onto a document-replication index is a
            }
    /**
                indexSettingsBuilder,
     */
        final CreateIndexClusterStateUpdateRequest request,
     * @param clusterSettings cluster setting
import org.opensearch.index.IndexCreationValidator;
     */
            shardLimitValidator,
        }  
            templates.stream().map(IndexTemplateMetadata::getName).collect(toList()),  
            Version minNodeVersion = state.nodes().getMinNodeVersion();  
    /**
 *
    private final ClusterService clusterService;  
    /**  
    private static Optional<String> validateIndexReplicationTypeSettings(Settings requestSettings, ClusterSettings clusterSettings) {  
    static IndexMetadata buildIndexMetadata(  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                "Setting ["  
        final AliasValidator aliasValidator,  
            logger.log(
                request.aliases(),  
 * the Apache License, Version 2.0 (the "License"); you may
        for (final String key : settings.keySet()) {
            for (ClusterBlock block : blocks) {  
                    + templateName
import static org.opensearch.index.IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING;  
        if (Objects.nonNull(newPathStrategy.getHashAlgorithm())) {
        Settings.Builder settingsBuilder  
        applyDisableObjectsOverrides(result);
                "cannot create index with index setting \"index.store.type\" set to \"remote_snapshot\". Store type can be set to \"remote_snapshot\" only when restoring a remote snapshot by using \"storage_type\": \"remote_snapshot\""  
        if (!isRemoteStoreEnabled) {
                        request.index(),
        int numSplits = log2MaxNumShards - log2NumShards;  
import org.opensearch.cluster.node.DiscoveryNode;
        final boolean silent,  
                        + Version.V_3_7_0
import org.apache.logging.log4j.Level;
        final CreateIndexClusterStateUpdateRequest request,  
                );
        List<String> validationErrors = new ArrayList<>();
            throw exceptionCtor.apply(index, "must not contain ':'");
        validate(request, currentState);
        Settings.Builder updatedSettingsBuilder = Settings.builder();  
import org.opensearch.cluster.node.DiscoveryNodes;
            final boolean isDataStreamIndex = request.dataStreamName() != null;
import java.util.concurrent.atomic.AtomicInteger;  
     */
