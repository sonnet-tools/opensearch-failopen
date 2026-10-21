     * For example, the {@code field_mapping} mapper type uses {@code id_field}, {@code version_field},
        Property.IndexScope,
    private final DiscoveryNodeFilters excludeFilters;
                } else {
                                + INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey()
    }
    public int getNumberOfVirtualShards() {
            if (requireMap.isEmpty()) {
        public SplitShardsMetadata getSplitShardsMetadata() {
         * @see #numberOfShards()
    public Index getResizeSourceIndex() {
        int numSourceShards = sourceIndexMetadata.getNumberOfShards();
                    }
        WRITE("write", INDEX_WRITE_BLOCK),
        Property.PrivateIndex,
     * The user provided name for an index. This is the plain string provided by the user when the index was created.
        private final boolean isSystem;
            }
            .append(", index=")
     */
    public static final MetadataStateFormat<IndexMetadata> FORMAT = new MetadataStateFormat<>(INDEX_STATE_FILE_PREFIX) {
            }
            context = after.context;
    public static final Setting<Boolean> INDEX_APPEND_ONLY_ENABLED_SETTING = Setting.boolSetting(
        }
    private final Map<String, DiffableStringMap> customData;
    public static final String INDEX_SETTING_PREFIX = "index.";
        }
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
        Property.PrivateIndex,
    public static final Setting<Integer> INDEX_ROUTING_PARTITION_SIZE_SETTING = Setting.intSetting(
            primaryTerms = in.readVLongArray();
        Setting.Property.Dynamic,
            );
        if (shardId >= numTargetShards) {
    public String toString() {
        SETTING_REMOTE_STORE_FENCING_ENABLED,
                    }
        }
                if (ReplicationType.SEGMENT.equals(replicationType) == false && value) {
     * held it. When enabled, the allocator converts a primary it has proven unrecoverable from any live node's local
        EnumSet.of(ClusterBlockLevel.WRITE)
    public long getMappingVersion() {
    }
            routingNumShards = after.routingNumShards;
import org.opensearch.indices.replication.common.ReplicationType;
    public static final String SETTING_CREATION_DATE_STRING = "index.creation_date_string";
        if (in.getVersion().before(Version.V_3_6_0)) {
            out.writeInt(routingNumShards);
            return false;
        public Builder state(State state) {
                                + " cannot contain path separators (/ or \\) or drive specifiers (:)"
            this.mappingVersion = indexMetadata.mappingVersion;
    public static final Setting<Boolean> INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING = APIBlock.READ_ONLY_ALLOW_DELETE.setting();
        SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED,
                indexSettings.get(IndexMetadata.SETTING_INDEX_UUID)
        out.writeVLong(settingsVersion);
            throw new IllegalArgumentException(
        return routingPartitionSize;
                requireFilters = null;
         * if a cluster should allow to create more than 1024 shards per index. NOTE: this does not limit the number of shards
                        primaryTermsArray[entry.getKey()] = entry.getValue();
                return OPEN;
                    }
            String currentFieldName = null;
     * Used to specify the replication type for the index. By default, document replication is used.
        // this is important to special case here since we use this to validate this in various places in the code but allow to split form
 * GitHub history for details.
     * Builds a primaryTerms long array from primaryTermsMap for backward-compatible wire serialization
        int rolloverAliasesSize = in.readVInt();
            return ingestionStatus;
        // this is just an additional assertion that ensures we are a factor of the routing num shards.
    static final String DEFAULT_NUMBER_OF_SHARDS = "opensearch.index.default_number_of_shards";
        100,
            new DiffableUtils.DiffableValueReader<>(DiffableStringMap::readFrom, DiffableStringMap::readDiffFrom);
                            }
            );
     * @param shardId             the id of the target shard to clone into
        assert mappingVersion >= 0 : mappingVersion;
import org.opensearch.core.common.io.stream.StreamInput;
        12,
     * @return a the source shard ID to clone from
import org.opensearch.cluster.DiffableUtils;
     */
            if (ingestionStatus == null) {
    /**
                    // Validate that the path prefix doesn't contain invalid characters for file paths
        if (sourceIndexMetadata.getNumberOfShards() > numTargetShards) {
            this.customMetadata = new HashMap<>(indexMetadata.customData);
                builder.endArray();
    );
            builder.customMetadata.putAll(customData.apply(part.customData));
    /**
        final long version,
     * Setting to control the number of search only replicas for an index.
                    } else {
                MappingMetadata mmd = indexMetadata.mapping();
        SETTING_INGESTION_SOURCE_POINTER_INIT_RESET_VALUE,
     * @param shardId             the id of the target shard to shrink to
                    builder.value(allocationId);
        assert numberOfShards * routingFactor == routingNumShards : routingNumShards + " must be a multiple of " + numberOfShards;
    public int getRoutingNumShards() {
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.IndexScope)
    public Map<Integer, Set<String>> getInSyncAllocationIds() {
    }
        true,
                        builder.context(Context.fromXContent(parser));
    /**
     */
            final int blockingQueueSize = INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING.get(settings);
            public Iterator<Setting<?>> settings() {
    );
            return this;
    private static void assertSplitMetadata(int numSourceShards, int numTargetShards, IndexMetadata sourceIndexMetadata) {
                }
                if (value != null && !value.trim().isEmpty()) {
    /**
    public static final String SETTING_READ_ONLY_ALLOW_DELETE = APIBlock.READ_ONLY_ALLOW_DELETE.settingName();
    /**
            final String decoderType = INGESTION_SOURCE_DECODER_TYPE_SETTING.get(settings);
        out.writeString(index.getName()); // uuid will come as part of settings
            maxNumShards,
    private final long version;
                    throw new IllegalArgumentException(
                }
 * this work for additional information regarding copyright
                    filledInSyncAllocationIds.put(i, Collections.emptySet());
            aliases.put(aliasMetadata.alias(), aliasMetadata);
        Version version = SETTING_INDEX_VERSION_CREATED.get(settings);
            return false;
    public static final Setting<AutoExpandReplicas> INDEX_AUTO_EXPAND_REPLICAS_SETTING = AutoExpandReplicas.SETTING;
            public void validate(final Boolean value) {}
            throw new IllegalArgumentException(
        Property.PrivateIndex,
        return this.indexTotalRemoteCapablePrimaryShardsPerNodeLimit;
            defaultNumShards,
    public static final Setting<String> INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING = Setting.simpleString(
import org.opensearch.common.xcontent.XContentHelper;
            }
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE, ClusterBlockLevel.METADATA_READ)
            if (splitShardsMetadata == null) {
        public Context context() {
                    throw new IllegalArgumentException("Unexpected token " + token);
import org.opensearch.cluster.Diff;
        /**
                "index with UUID [%s] created on version [%s] is not supported by version [%s]",
    /**
        IngestionErrorStrategy.ErrorStrategy::parseFromString,
        Property.Final
    public static final String SETTING_NUMBER_OF_SHARDS = "index.number_of_shards";
    public static final Setting<String> INDEX_UUID_SETTING = Setting.simpleString(
        final int numberOfShards,
        false,
    /**
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
        this.settings = settings;
 * Unless required by applicable law or agreed to in writing,
                numberOfSearchReplicas,
    public static final String INGESTION_SOURCE_KEY = "ingestion_source";
    public static final String SETTING_REMOTE_STORE_FENCING_ENABLED = "index.remote_store.fencing.enabled";
    private static final String INDEX_FORMAT = "index.format";
        Property.Final
                context = null;
                                builder.putRolloverInfo(RolloverInfo.parse(parser, currentFieldName));
    static final String KEY_MAPPINGS = "mappings";
            }
     * Return the {@link Version} on which this index has been created. This
    }
        },
    /**
     */
            throw new IllegalArgumentException("No block found with name " + name);
    }
    public boolean isAllActiveIngestionEnabled() {
        Property.IndexScope,
            }
        Property.Final
                settingsVersion,
                out.writeOptionalWriteable(context);
            public void validate(final Integer value) {
                    } else if (KEY_PRIMARY_TERMS.equals(currentFieldName)) {
        assert shardId >= 0 && shardId < numberOfShards;
/*
                            } else {
    public boolean isAppendOnlyIndex() {
    private final int routingFactor;
            }
                                String mappingType = currentFieldName;
            .append(", splitShardsMetadata=")
     */
                                + " should be set when resetting consumer position"
            out.writeVLongArray(buildPrimaryTermsArray());
    public static final Setting<Integer> INDEX_NUMBER_OF_SHARDS_SETTING = buildNumberOfShardsSetting();
     * <p>
                Version.CURRENT.toString()
            return selectShrinkShards(shardId, sourceIndexMetadata, numTargetShards);
    @Override
            public Iterator<Setting<?>> settings() {
        }
        State(byte id) {
                if (value) {
        final String ingestionSourceType = INGESTION_SOURCE_TYPE_SETTING.get(settings);
        final int indexTotalRemoteCapablePrimaryShardsPerNodeLimit,
     */
    public static final Setting<ReplicationType> INDEX_REPLICATION_TYPE_SETTING = new Setting<>(
                "the number of target shards (" + numTargetShards + ") must be greater than the shard id: " + shardId
            this.routingNumShards = routingNumShards;
                final Object ingestionSourceType = settings.get(INGESTION_SOURCE_TYPE_SETTING);
    }
        Property.Dynamic,
    public static final Setting<Boolean> INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING = Setting.boolSetting(
        Property.IndexScope,
    /**
        }
            this.ingestionStatus = indexMetadata.ingestionStatus;
                        "Setting " + INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey() + " should be provided with non-empty repository ID"
    );
            return Collections.singleton(selectCloneShard(shardId, sourceIndexMetadata, numTargetShards));
        TimeValue.timeValueMillis(-1),
                int numShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
                // ingestionStatus field is introduced from OS 3.x. But this field is included in XContent serialization only from OS 3.3
            }
                Locale.ROOT,
        this.version = version;
        public void toXContent(XContentBuilder builder, IndexMetadata state) throws IOException {
    );
                        );
        }
                throw new IllegalArgumentException(
     */
        },
    }
        }
    public int getIndexTotalPrimaryShardsPerNodeLimit() {
    public int getIndexTotalRemoteCapableShardsPerNodeLimit() {
    public IngestionStatus getIngestionStatus() {
            StreamOutput::writeVInt,
     * Blocks the API.
 */
                    + ")"
        for (final RolloverInfo cursor : rolloverInfos.values()) {
    public boolean bulkAdaptiveShardSelectionEnabled() {
            builder.splitShardsMetadata(new SplitShardsMetadata(in));
                }
            factor = targetNumberOfShards / sourceNumberOfShards;
            return APIBlock.values()[input.readVInt()];
            builder.field(KEY_SYSTEM, indexMetadata.isSystem);
            builder.primaryTermsMap(primaryTermsMap);
            @Override
                        }
            public Iterator<Setting<?>> settings() {
            version = in.readLong();
            return this;
                    + "bulk adaptive shard selection is enabled, "
        return result;
     */
    public static final Setting<String> INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX = Setting.simpleString(
            }
    /**
            .toString();
            int routingPartitionSize = INDEX_ROUTING_PARTITION_SIZE_SETTING.get(settings);
            builder.startObject(KEY_SETTINGS);
        }
    }
            }
                .setErrorStrategy(errorStrategy)
        if (maxNumShards < 1) {
        private final long aliasesVersion;
        final DiscoveryNodeFilters requireFilters,
            for (final Map.Entry<Integer, Set<String>> cursor : indexMetadata.inSyncAllocationIds.entrySet()) {
        }
     * Gets the ingestion source.
        }
        final int numberOfReplicas,
    static final String KEY_VERSION = "version";
                final List<Setting<?>> settings = Collections.singletonList(INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING);
                        builder.map(XContentHelper.convertToMap(mmd.source().uncompressed(), true).v2());
        for (int i = 0; i < aliasesSize; i++) {
     * @see #getRoutingFactor(int, int) for details
    }
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                    throw new IllegalArgumentException(
                ? INDEX_APPEND_ONLY_ENABLED_SETTING.get(settings)
 * the Apache License, Version 2.0 (the "License"); you may
            return builder.build();
import org.opensearch.common.Nullable;
        }
                            + INDEX_REPLICATION_TYPE_SETTING.getKey()
                    primaryTermsMap.put(shardId, primaryTerms[shardId]);
        "disk usage exceeded flood-stage watermark, index has read-only-allow-delete block",
        SETTING_INDEX_HIDDEN,
            }
     */
        }
    public static Set<ShardId> selectRecoverFromShards(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {
            @Override
                            + "] must be >= number of shards ["
        Property.IndexScope,
    }
    public IngestionSource getIngestionSource() {
        result = 31 * result + primaryTermsMap.hashCode();
     *
        100000,
            return routingNumShards == null ? numberOfShards() : routingNumShards;
            version = after.version;
    /**
        false,
    static final String KEY_MAPPING_VERSION = "mapping_version";
        }
        }
            }
    }
     * <p>
        int customSize = in.readVInt();
        this.indexTotalPrimaryShardsPerNodeLimit = indexTotalPrimaryShardsPerNodeLimit;
            }
                            "Setting "
import org.opensearch.common.unit.TimeValue;
            return this.version;
    /**
                pointerInitResetValue
    public static final String SETTING_INGESTION_SOURCE_INTERNAL_QUEUE_SIZE = "index.ingestion_source.internal_queue_size";
    /**
    public static final String SETTING_AUTO_EXPAND_REPLICAS = "index.auto_expand_replicas";
            return this;
                            + numberOfVirtualShards
            Version indexCreatedVersion = indexCreated(settings);
        Property.IndexScope,
        return splitShardsMetadata;
    public static Set<ShardId> selectShrinkShards(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {
                            + INDEX_REPLICATION_TYPE_SETTING.getKey()
        "index.priority",
    private final int indexTotalShardsPerNodeLimit;
        public Builder removeAlias(String alias) {
            .append(aliases)
        }
 * under the License.
            .append(", ingestionStatus=")
                }
        @Override
    public static final String TRANSLOG_METADATA_KEY = "translog_metadata";
            for (int i = 0; i < numberOfShards(); i++) {
        RestStatus.FORBIDDEN,
            }
            builder.field(KEY_ROUTING_NUM_SHARDS, indexMetadata.getRoutingNumShards());
    );
                // Only validate if the value is not null and not empty
     * A value of -1 means warmup is disabled (the default). A value >= 0 enables warmup with that timeout.
            throw new IllegalArgumentException("unable to parse the index name [" + indexName + "] to extract the counter", e);
    };
        final Boolean isRemoteSegmentStoreEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);
    private final boolean isRemoteSnapshot;
        public static APIBlock fromName(String name) {
                final List<Setting<?>> settings = List.of(INDEX_REPLICATION_TYPE_SETTING);
            }
    public static final String INGESTION_STATUS_KEY = "ingestion_status";
            this.version = version;
                    throw new IllegalArgumentException(
        return factor;
            rolloverInfos = DiffableUtils.diff(before.rolloverInfos, after.rolloverInfos, DiffableUtils.getStringKeySerializer());
            throw new IllegalArgumentException(
                indexMetadata.getSettings().toXContent(builder, params);
         * See {@link IndexMetadata#primaryTerm(int)} for more information.
        final ClusterBlock block;
                    + "]"
import java.util.Locale;
    );
     * Must not be enabled for an index migrating between document replication and remote store: fencing assumes
        } else if (sourceNumberOfShards > targetNumberOfShards) { // shrink
                                + SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED
                return settings.iterator();
            private boolean isResetState(String value) {
    /**
        return requireFilters;
    private final int numberOfSearchOnlyReplicas;
    public DiscoveryNodeFilters includeFilters() {
        out.writeMap(
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
    public static final String SETTING_REMOTE_STORE_ENABLED = "index.remote_store.enabled";
                }
                .setAllActiveIngestion(allActiveIngestionEnabled)
                            + INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey()
    );
            .append(mappings)
            }
        if (isSystem != that.isSystem) {
        private long settingsVersion = 1;
        }
                    } else if (KEY_IN_SYNC_ALLOCATIONS.equals(currentFieldName)) {
                if (isPullBasedIngestionEnabled && ReplicationType.DOCUMENT.equals(replicationType) && value == false) {
        final int numberOfSearchOnlyReplicas,
                numberOfShards,
        SETTING_INGESTION_SOURCE_PARTITION_STRATEGY,
            state = State.fromId(in.readByte());
        result = 31 * result + Long.hashCode(version);
     */
    public static final String SETTING_INGESTION_SOURCE_WARMUP_LAG_THRESHOLD = "index.ingestion_source.warmup.lag_threshold";
                    || StreamPoller.ResetState.EARLIEST.name().equalsIgnoreCase(value)
        return new IndexMetadataDiff(in);
            if (in.getVersion().onOrAfter(Version.V_3_6_0)) {
     * @param numTargetShards     the total number of shards in the target index
        false,
            } else {
        false,
        public Builder settings(Settings settings) {
    /**
    public static final String CONTEXT_KEY = "context";
        result = 31 * result + Objects.hashCode(splitShardsMetadata);
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
            new DiffableUtils.DiffableValueReader<>(RolloverInfo::new, RolloverInfo::readDiffFrom);
            builder.context(in.readOptionalWriteable(Context::new));
        new TimeValue(10, TimeUnit.SECONDS),
            builder.field(KEY_VERSION, indexMetadata.getVersion());
        }
            final int pollTimeout = INGESTION_SOURCE_POLL_TIMEOUT.get(settings);
        -1,
            inSyncAllocationIds = DiffableUtils.readJdkMapDiff(
        if (in.getVersion().onOrAfter(Version.V_3_6_0)) {
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE, ClusterBlockLevel.WRITE)
    public Map<String, String> getCustomData(final String key) {
                mappingVersion,
                splitShardsMetadata = new SplitShardsMetadata.Builder(numberOfShards).build();
         */
                }
                routingPartitionSize,
                                list.add(parser.longValue());
    public enum APIBlock implements Writeable {
        }
            return false;
                    final String resetValue = (String) settings.get(INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING);
     * @param numTargetShards     the total number of shards in the target index
     */
                        }
        public Builder ingestionStatus(IngestionStatus ingestionStatus) {
        return isSystem;
            final TimeValue pointerBasedLagUpdateInterval = INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING.get(settings);
        private final Diff<Map<Integer, Set<String>>> inSyncAllocationIds;
        }
        if (!aliases.equals(that.aliases)) {
            settings = Settings.builder().put(settings).put(SETTING_NUMBER_OF_SHARDS, numberOfShards).build();
        "remote index is read-only",
        public Builder numberOfSearchReplicas(int numberOfSearchReplicas) {
                final Object replicationType = settings.get(INDEX_REPLICATION_TYPE_SETTING);
        }
                    + numTargetShards
                        );
                indexTotalShardsPerNodeLimit,
            aliasesVersion = in.readVLong();
    );
        false,
            if (id == 0) {
            this.index = index;
            return this;
        result = 31 * result + settings.hashCode();
        }
                builder.startObject(KEY_SPLIT_SHARDS_METADATA);
        }
            }
                pointerInitResetType,
        }
     * Return the version the index was created from the provided index settings
            final Map<Integer, Set<String>> filledInSyncAllocationIds = new HashMap<>();
        }
            }
            return false;
    public static final String SETTING_DATA_PATH = "index.data_path";
                        + "] should be a positive number"
                        // assume it's custom index metadata
        if (state != that.state) {
        if (Objects.equals(ingestionStatus, that.ingestionStatus) == false) {
     * @opensearch.api
                            + " is not supported in pull-based ingestion when "
                .setDecoderSettings(decoderSettings)
import java.util.HashMap;
            return this;
            if (factor * targetNumberOfShards != sourceNumberOfShards || factor <= 1) {
     * Selects the source shards for a local shard recovery. This might either be a split or a shrink operation.
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.OR;
    public static final String SETTING_BLOCKS_METADATA = APIBlock.METADATA.settingName();
    private final State state;
        Property.Dynamic
        if (o == null || getClass() != o.getClass()) {
            return aliasesVersion;
            @Override
            inSyncAllocationIds,
        for (final MappingMetadata cursor : mappings.values()) {
        if (version != that.version) {
                final Object remoteStoreEnabled = settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);
            .append(inSyncAllocationIds)
     */
        }
     */
            return splitShardsMetadata;
            public void validate(final Boolean value) {}
            return this;
                )
     * Permanent cluster block applied to indices in search-only mode.
            .append(", mappingVersion=")
                DEFAULT_NUMBER_OF_SHARDS
            final Map<String, Object> mapperSettings = INGESTION_SOURCE_MAPPER_SETTINGS.getAsMap(settings);
        if (INDEX_UUID_NA_VALUE.equals(otherUUID) || INDEX_UUID_NA_VALUE.equals(getIndexUUID())) {
     */
            builder.putRolloverInfo(new RolloverInfo(in));
import org.opensearch.core.index.Index;
                                + " membership while the departed primary may still be alive, and only the fence"
import java.util.HashSet;
            }
            @Override
                                    String mappingType = mapping.keySet().iterator().next();
                builder.startObject(KEY_ALIASES);
        private final IngestionStatus ingestionStatus;
        public static APIBlock fromSetting(String settingName) {
         */
        public Builder putAlias(AliasMetadata.Builder aliasMetadata) {
                                Map<String, Object> mappingSource = MapBuilder.<String, Object>newMapBuilder()
                        );
 *     http://www.apache.org/licenses/LICENSE-2.0
                        + "]"
        result = 31 * result + rolloverInfos.hashCode();
            builder.endObject();
     * Note: Virtual Shards uses range-based mapping (e.g., {@code vShardId / (V / P)}) to route to
    );
            this.customMetadata = new HashMap<>();
        private static final DiffableUtils.DiffableValueReader<String, MappingMetadata> MAPPING_DIFF_VALUE_READER =
                            } else {
            );
                            + ReplicationType.SEGMENT
                    validateRemoteStoreSettingEnabled(settings, INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING);
     * Requires {@link #INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING}: the trigger fires on the cluster manager's
        private long mappingVersion = 1;
        Long creationDate = settings.getAsLong(SETTING_CREATION_DATE, null);
        int result = index.hashCode();
                .setPointerInitReset(pointerInitReset)
        SETTING_INGESTION_SOURCE_INTERNAL_QUEUE_SIZE,
    }
            }
    public DiscoveryNodeFilters requireFilters() {
    public static final Setting.AffixSetting<String> INDEX_ROUTING_EXCLUDE_GROUP_SETTING = Setting.prefixKeySetting(
    public static final String SETTING_VERSION_UPGRADED_STRING = "index.version.upgraded_string";
                    builder.map(mapping);
                new MappingMetadata(
                indexMetadata.ingestionStatus.toXContent(builder, params);
    }
                return CLOSE;
        false,
        ReplicationType.DOCUMENT.toString(),
                builder.field(cursor.getKey());
     * membership view, and the departed primary is typically still alive behind a partition, still able to reach the
            boolean mappingVersion = false;
        result = 31 * result + inSyncAllocationIds.hashCode();
        writeSettingsToStream(settings, out);
                    if (isRemoteSegmentStoreEnabled == null || isRemoteSegmentStoreEnabled == false) {
            public void validate(final Boolean value, final Map<Setting<?>, Object> settings) {
                            } else if (token == XContentParser.Token.START_OBJECT) {
            return false;
                            + numberOfShards
     * @opensearch.api
                        builder.system(parser.booleanValue());
        Property.Dynamic
                    if (binary) {
            return Collections.singleton(selectSplitShard(shardId, sourceIndexMetadata, numTargetShards));
/*
                indexTotalPrimaryShardsPerNodeLimit,
        Property.PrivateIndex,
import org.opensearch.common.settings.Setting;
        Set<ShardId> shards = new HashSet<>(routingFactor);
import org.opensearch.core.common.io.stream.StreamOutput;
            inSyncAllocationIds.writeTo(out);
    /**
                        + "]: cannot be greater than "
 */
        IngestionMessageMapper.MapperType.DEFAULT.getName(),
                    "invalid "
            builder.version(version);
                }
        Property.Dynamic,
                e.getVersionString(),
                }
            }
                    + sourceIndexMetadata.getNumberOfShards()
                                currentFieldName = parser.currentName();
            }
        if (!mappings.equals(that.mappings)) {
            }
    public static final String SETTING_INGESTION_SOURCE_NUM_PROCESSOR_THREADS = "index.ingestion_source.num_processor_threads";
        this.totalNumberOfShards = numberOfShards * (numberOfReplicas + numberOfSearchOnlyReplicas + 1);
                                    builder.putMapping(new MappingMetadata(mappingType, mapping));
        if (versionUpgraded != null) {
                            + " should be set to "
            throw new IllegalArgumentException(
            Map<Integer, Long> primaryTermsMapFromArray = new HashMap<>();
        return numberOfSearchOnlyReplicas;
            return mappingVersion;
                        mapping = (Map<String, Object>) mapping.get(mmd.type());
    public String getIndexUUID() {
import java.io.IOException;
        this.index = index;
    public MappingMetadata mapping() {
         * Returns number of shards that should be used for routing. By default this method will return the number of shards
                        + "]"
        SETTING_HISTORY_UUID,
    );
    public Version getCreationVersion() {
    /**
                .setMapperSettings(mapperSettings)
    }
        public static APIBlock readFrom(StreamInput input) throws IOException {
        this.isSystem = isSystem;
                builder.splitShardsMetadata(splitMetadata.apply(part.splitShardsMetadata));
            new DiffableUtils.DiffableValueReader<>(MappingMetadata::new, MappingMetadata::readDiffFrom);
            public void validate(final String value) {}
        result = 31 * result + Objects.hashCode(context);
     * E.g.
            Builder.toXContent(state, builder, FORMAT_PARAMS);
            return this;
            return this;
        Property.IndexScope,
        final String name;
                                throw new IllegalArgumentException("Unexpected token: " + token);
    }
            mappingVersion = after.mappingVersion;
     * "simple" (default): 1:1 mapping where shard N consumes partition N.
            }
        public IndexMetadata build() {
        return settings;
            this.splitShardsMetadata = indexMetadata.splitShardsMetadata;
            out.writeOptionalWriteable(ingestionStatus);
                mappings,
    public static Settings addHumanReadableSettings(Settings settings) {
    );
        },
                    "the number of source shards [" + sourceNumberOfShards + "] must be a " + "factor of [" + targetNumberOfShards + "]"
    public static final String SETTING_INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL =
        Property.IndexScope,
        int numberIndex = indexName.lastIndexOf("-");
            );
            private boolean isValidResetState(String value) {
        }
        }
    @Nullable
        }
        SETTING_INGESTION_SOURCE_MAPPER_TYPE,
    }
                splitMetadata = SplitShardsMetadata.readDiffFrom(in);
     */
        /**
    public static final Setting<Integer> INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING = Setting.intSetting(
                excludeFilters,
     * @param numTargetShards     the number of target shards
        0,
        Long pTerm = this.primaryTermsMap.get(shardId);
    );
            @Override
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            }
     * The term of the current selected primary. This is a non-negative number incremented when
        Version versionUpgraded = settings.getAsVersion(SETTING_VERSION_UPGRADED, null);
        for (int i = shardId * routingFactor; i < routingFactor * shardId + routingFactor; i++) {
        SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY,
                if (value == null || value.isEmpty()) {
    public static final Setting<String> INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING = Setting.simpleString(
        1,
                for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
             * on the default values here. Those must have been set upstream.
     * translog repository, so a stale primary fails itself instead of acknowledging writes that would be lost on
    private final boolean isAppendOnlyIndex;
            .append(", settingsVersion=")
            this.isSystem = system;
            }
                splitMetadata.writeTo(out);
                final List<Setting<?>> settings = Collections.singletonList(INDEX_NUMBER_OF_SHARDS_SETTING);
                        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        private String index;
    private final DiscoveryNodeFilters initialRecoveryFilters;
     */
                            + "] for ["
        public Builder context(Context context) {
     * Defines the acceptable pointer-based lag threshold. Warmup completes when lag is at or below this value.
     * Defines the max poll size per batch for pull-based ingestion.
    }
                for (int i = 0; i < numberOfShards; i++) {
        assert aliasesVersion >= 0 : aliasesVersion;
        Property.IndexScope,
            public void validate(final Boolean value, final Map<Setting<?>, Object> settings) {
        Property.Final
     * Return the concrete mapping for this index or {@code null} if this index has no mappings at all.
     * to an active shard count of 1 if not specified.
                    builder.value(cursor);
        public Builder putInSyncAllocationIds(int shardId, Set<String> allocationIds) {
    public static final String SETTING_NUMBER_OF_REPLICAS = "index.number_of_replicas";
    public static final String SETTING_INDEX_APPEND_ONLY_ENABLED = "index.append_only.enabled";
import org.opensearch.core.xcontent.XContentParser;
            return false;
        private final Settings settings;
        RestStatus.FORBIDDEN,
                    final Boolean isRemoteSegmentStoreEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);
            }
                in,
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
    public static final String KEY_PRIMARY_TERMS_MAP = "primary_terms_map";
                    if (mapping.size() == 1 && mapping.containsKey(mmd.type())) {
                indexUpgradedVersion,
        public Builder settings(Settings.Builder settings) {
        }
import org.opensearch.common.settings.Settings;
            settings = Settings.builder().put(settings).put(SETTING_ROUTING_PARTITION_SIZE, routingPartitionSize).build();
            public void validate(final ReplicationType value, final Map<Setting<?>, Object> settings) {
                        builder.ingestionStatus(IngestionStatus.fromXContent(parser));
            }
        this.requireFilters = requireFilters;
            Set<String> allocationIds = DiffableUtils.StringSetValueSerializer.getInstance().read(in, key);
                            + ", "
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
        private final State state;
                initialRecoveryFilters,
        final Settings settings,
        SETTING_ROUTING_PARTITION_SIZE,
        final Version indexCreatedVersion,
                for (String allocationId : cursor.getValue()) {
            );
            return new IngestionSource.Builder(ingestionSourceType).setParams(ingestionSourceParams)
            this.setting = Setting.boolSetting(settingName, false, Property.Dynamic, Property.IndexScope);
        final int defaultNumShards = Integer.parseInt(System.getProperty(DEFAULT_NUMBER_OF_SHARDS, "1"));
    public boolean isSameUUID(String otherUUID) {
        Map<String, String> params = new HashMap<>(2);
        if (!settings.equals(that.settings)) {
         *
        builder.setRoutingNumShards(in.readInt());
     */
        this.mappings = Collections.unmodifiableMap(mappings);
        out.writeBoolean(isSystem);
        "index.number_of_routing_shards",
                if (ReplicationType.SEGMENT.equals(value) == false && Objects.equals(remoteStoreEnabled, true)) {
        new Setting.Validator<>() {
            @Override
     * remote-store-backed end to end.
            cursor.writeTo(out);
        this.routingPartitionSize = routingPartitionSize;
    }
    public static final Setting.AffixSetting<String> INDEX_ROUTING_INCLUDE_GROUP_SETTING = Setting.prefixKeySetting(
    /**
        out.writeMap(customData, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));
            this.settingsVersion = indexMetadata.settingsVersion;
            final int numberOfSearchReplicas = INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(settings);
     * This block prevents write operations to the index while allowing read operations.
        /* This property should be provided if the default number of shards for any new index has to be changed to a value
            this.primaryTermsMap = new HashMap<>(indexMetadata.primaryTermsMap);
                                builder.putMapping(new MappingMetadata(new CompressedXContent(parser.binaryValue())));
    public Version getUpgradedVersion() {
    public static final Setting<Boolean> INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED = Setting.boolSetting(
    public static final int INDEX_SEARCH_ONLY_BLOCK_ID = 20;
        return this.version;
        }
     */
                    } else {
     *
            }
    public static final Setting<Boolean> INDEX_BLOCKS_METADATA_SETTING = APIBlock.METADATA.setting();
        return index.getUUID();
     */
         * for this index.
            state = after.state;
                return StreamPoller.ResetState.LATEST.name().equalsIgnoreCase(value)
    public static final String INDEX_RESIZE_SOURCE_UUID_KEY = "index.resize.source.uuid";
        }
                    } else if (INGESTION_STATUS_KEY.equals(currentFieldName)) {
                    + index.getName()
import org.opensearch.core.common.io.stream.VerifiableWriteable;
                throw new IllegalStateException("you must set the number of shards before setting/reading primary terms");
        int routingFactor = getRoutingFactor(sourceIndexMetadata.getNumberOfShards(), numTargetShards);
        long[] terms = new long[numberOfShards];
        if (!primaryTermsMap.equals(that.primaryTermsMap)) {
        for (final Map.Entry<String, DiffableStringMap> cursor : customData.entrySet()) {
    public boolean isRemoteSnapshot() {
                .build();
                builder.startObject(IndexMetadata.KEY_PRIMARY_TERMS);
                for (Map.Entry<Integer, Long> entry : primaryTermsMap.entrySet()) {
    );
        out.writeVInt(mappings.size());
        return settings.getAsInt(SETTING_NUMBER_OF_VIRTUAL_SHARDS, -1);
        this.customData = Collections.unmodifiableMap(customData);
                // TODO: validate this with the registered types in the ingestion source plugin
            return context;
    }
            if (excludeMap.isEmpty()) {
        Property.UnmodifiableOnRestore
                INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING.get(settings)
                isSystem,
            this.aliases = new HashMap<>(indexMetadata.aliases);
                    + numTargetShards
        private final long mappingVersion;
            if (out.getVersion().before(Version.V_3_6_0)) {
    public Diff<IndexMetadata> diff(IndexMetadata previousState) {
        "index read (api)",
        }
        }
        public long settingsVersion() {
            }
        5,
            return false;
            }
    public static final String SETTING_VERSION_CREATED_STRING = "index.version.created_string";
    @Override
        new Setting.Validator<>() {
    );
                .setPointerBasedLagUpdateInterval(pointerBasedLagUpdateInterval)
            .append(settingsVersion)
    public enum State {
            );
                settings
        Property.IndexScope,
                            + index
        return builder.build();
    public DiscoveryNodeFilters excludeFilters() {
                                + SETTING_REMOTE_STORE_FENCING_ENABLED
     * Used to specify a custom path prefix for remote store segments. This allows injecting a unique identifier
                boolean isPullBasedIngestionEnabled = NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType) == false;
import org.opensearch.indices.replication.SegmentReplicationSource;
        final boolean isSystem,
    @Override
            @Override
        }
import java.time.ZonedDateTime;
        public Builder creationDate(long creationDate) {
 * @opensearch.api
    }
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.MapperService;
        final Map<Integer, Set<String>> inSyncAllocationIds,
            }
    public static final Setting<Boolean> INDEX_READ_ONLY_SETTING = APIBlock.READ_ONLY.setting();
            out.writeVInt(cursor.getKey());
import org.opensearch.common.collect.MapBuilder;
                        "Invalid value for " + SETTING_INGESTION_SOURCE_POINTER_INIT_RESET + " [" + value + "]"
        final DiscoveryNodeFilters includeFilters,
                splitMetadata = null;
 * The OpenSearch Contributors require contributions made to
        -1,
            .append(mappingVersion)
                            + ReplicationType.SEGMENT
    /**
                }
                if (numberOfVirtualShards % numberOfShards != 0) {
     * @param shardId             the target shard ID to select the source shards for
            public Iterator<Setting<?>> settings() {
                    throw new IllegalArgumentException(
                    if (entry.getKey() < numShards) {
        IngestionSource.SourcePartitionStrategy::fromString,
     * @return a set of shard IDs to shrink into the given shard ID.
import org.opensearch.Version;
        }
     * Parses the number from the rolled over index name. It also supports the date-math format (ie. index name is wrapped in &lt; and &gt;)
        false,
            }
                return StreamPoller.ResetState.RESET_BY_OFFSET.name().equalsIgnoreCase(value)
            .append("}")
            final int numProcessorThreads = INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING.get(settings);
                        );
        false,
        false,
                params.param(CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API)
        false,
        public void writeTo(StreamOutput out) throws IOException {
        if (isRemoteSegmentStoreEnabled == false) {
        },
         * 99% of the users have less than 1024 shards per index. We also make it a hard check that requires restart of nodes
     *
            @Override
    private static final ToXContent.Params FORMAT_PARAMS;
        final Map<String, DiffableStringMap> customData,
            final int indexTotalRemoteCapableShardsPerNodeLimit =
            public Iterator<Setting<?>> settings() {
        9,
            if ("open".equals(state)) {
            ingestionStatus = after.ingestionStatus;
                INGESTION_SOURCE_POINTER_INIT_RESET_SETTING.get(settings).toUpperCase(Locale.ROOT)
        }
        }
            for (int shard = 0; shard < primaryTerms.length; shard++) {
                    builder.value(indexMetadata.primaryTerm(i));
                .setMaxPollSize(maxPollSize)
                    "primaryTerms length is ["
     * - For ".ds-logs-000002" it will return 2
    }
     * This method is used to display the settings in a human readable format in REST API
            rolloverInfos.writeTo(out);
                        "Setting "
            builder.startObject(KEY_ROLLOVER_INFOS);
                if (value == null || value.isEmpty()) {
    /**
        Property.Dynamic,
                }
     * failover. Requires the translog repository to support conditional writes.
        false,
            if (INDEX_NUMBER_OF_SHARDS_SETTING.exists(settings) == false) {
        }
        return settings.getAsLong(SETTING_CREATION_DATE, -1L);
            .append(", state=")
import java.util.TreeSet;
        if (indexVersion.equals(Version.V_EMPTY)) {
        INDEX_NUMBER_OF_SHARDS_SETTING,
            );
     */
     *
                this.primaryTermsMap = primaryTermsMap;
    /**
                "the number of target shards ("
        }
         * kills the entire cluster with OOM on the spot.*/
    public static final String SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY = "index.remote_store.translog.repository";
    );
            splitShardsMetadata.writeTo(out);
     * Settings for configuring the number of virtual shards on an index.
     * Returns the routing factor for this index. The default is {@code 1}.
        }
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
    );
import java.util.EnumSet;
    public static final Setting<String> INGESTION_SOURCE_POINTER_INIT_RESET_SETTING = Setting.simpleString(
    @Nullable
            } else {
                }
import org.opensearch.core.xcontent.ToXContent;
            builder.aliases.putAll(aliases.apply(part.aliases));
        out.writeString(index.getName()); // uuid will come as part of settings
            if (context != Metadata.XContentContext.API) {
                this.primaryTermsMap.put(shard, primaryTerms[shard]);
        0,
                            "Setting "
        SETTING_INDEX_APPEND_ONLY_ENABLED,
                initialRecoveryFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, OR, initialRecoveryMap);
    }
    /**
                        // throw new IllegalArgumentException("Warmers are not supported anymore");
 *
                    final Boolean fencingEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING);
            final DiscoveryNodeFilters requireFilters;
        private final String index;
            }
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
                                + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
            builder.settingsVersion(settingsVersion);
 * Index metadata information
    private final Map<String, AliasMetadata> aliases;
    }
        if (routingFactor != that.routingFactor) {
        result = 31 * result + Long.hashCode(routingNumShards);
        EnumSet.of(ClusterBlockLevel.WRITE)
        "index.ingestion_source.param.",
        public Builder settingsVersion(final long settingsVersion) {
            if (waitForActiveShards.validate(numberOfReplicas) == false) {
    public static final String SETTING_INDEX_PROVIDED_NAME = "index.provided_name";
    }
import org.opensearch.cluster.node.DiscoveryNodeFilters;
     * @return ingestion source, or null if ingestion source is not enabled
        Property.IndexScope,
    static final String KEY_SPLIT_SHARDS_METADATA = "split_shards_metadata";
    public static final Setting<Integer> INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING = Setting.intSetting(
        return this.customData;
        }
        1,
            this.settingsVersion = settingsVersion;
     * Builder of index metadata.
        return indexUpgradedVersion;
                return settings.iterator();
                version,
                    if (KEY_SETTINGS.equals(currentFieldName)) {
        private final Map<Integer, Set<String>> inSyncAllocationIds;
    }
    );
        for (final MappingMetadata cursor : mappings.values()) {
    public static final Setting<Long> INGESTION_SOURCE_MAX_POLL_SIZE = Setting.longSetting(
     * The built-in decoder is {@code xcontent} (JSON). Plugins may register
                        aliasesVersion = true;
    public long getVersion() {
        return new ShardId(sourceIndexMetadata.getIndex(), shardId);
    }
import org.opensearch.core.rest.RestStatus;
            final int numberOfVirtualShards = INDEX_NUMBER_OF_VIRTUAL_SHARDS_SETTING.get(settings);
                        + "number of shard copies ["
            }
            @Override
    public static final ClusterBlock INDEX_SEARCH_ONLY_BLOCK = new ClusterBlock(
            return this;
    public static final ClusterBlock INDEX_WRITE_BLOCK = new ClusterBlock(
            builder.put(SETTING_VERSION_CREATED_STRING, version.toString());
import java.util.Objects;
    private final IngestionStatus ingestionStatus;
        private static final DiffableUtils.DiffableValueReader<String, AliasMetadata> ALIAS_METADATA_DIFF_VALUE_READER =
            out.writeVLong(settingsVersion);
            customData = DiffableUtils.diff(before.customData, after.customData, DiffableUtils.getStringKeySerializer());
                .setNumProcessorThreads(numProcessorThreads)
             * We expect that the metadata has been properly built to set the number of shards and the number of replicas, and do not rely
    private final Context context;
    private final Settings settings;
            Property.IndexScope,
     */
                .setWarmupConfig(warmupConfig)
            builder.endObject();
        1,
    }
                    + "]"
            final DiscoveryNodeFilters initialRecoveryFilters;
            );
                return OPEN;
        private final int routingNumShards;
                out.writeOptionalWriteable(ingestionStatus);
        SETTING_INGESTION_SOURCE_ERROR_STRATEGY,
                    throw new IllegalArgumentException(
    private final int numberOfReplicas;
    Map<String, DiffableStringMap> getCustomData() {
        Property.PrivateIndex,
        public static IndexMetadata fromXContent(XContentParser parser) throws IOException {
        }
    }
            assert primaryTermsMap.isEmpty();
                        + waitForActiveShards
            return this.id;
    );
        Property.Dynamic
    public static final Setting<Boolean> INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING = Setting.boolSetting(
        for (int i = 0; i < rolloverAliasesSize; i++) {
        false,
    static final String KEY_ALIASES = "aliases";
                    + " source shards ("
            ? new Index(INDEX_RESIZE_SOURCE_NAME.get(settings), INDEX_RESIZE_SOURCE_UUID.get(settings))
                    XContentHelper.convertToMap(MediaTypeRegistry.xContent(source).xContent(), source, true)
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  // on a start object move to next token
        INDEX_ROUTING_REQUIRE_GROUP_PREFIX + ".",
    }
        1,
        out.writeMapValues(rolloverInfos, (stream, val) -> val.writeTo(stream));
import java.util.Set;
        if (defaultNumShards < 1 || defaultNumShards > maxNumShards) {
    private final int routingPartitionSize;
        IndexMetadataDiff(StreamInput in) throws IOException {
                Map<Integer, Long> primaryTermsMap = new HashMap<>();
        public Builder splitShardsMetadata(SplitShardsMetadata splitShardsMetadata) {
            } else {
        return ingestionStatus;
            return isSystem;
        private Context context;
 */
        }
        }, Property.IndexScope, Property.Dynamic)
        out.writeVLong(aliasesVersion);
            builder.primaryTermsMap(primaryTermsMapFromArray);
    /**
                throw new IllegalArgumentException("must specify number of replicas for index [" + index + "]");
                    + "] must be less that the number of source shards ["
                parser.nextToken();
     */
            }
        if (sourceNumberOfShards < targetNumberOfShards) { // split
    }
            @Override
    @PublicApi(since = "1.0.0")
    );
            );
    public static final String SETTING_AUTO_EXPAND_SEARCH_REPLICAS = "index.auto_expand_search_replicas";
            @Override
            @Override
        Property.IndexScope,
        false,
    /**
                            + ReplicationType.DOCUMENT
            if (initialRecoveryMap.isEmpty()) {
                        + routingPartitionSize
        new Setting.Validator<>() {
                } else if (token.isValue()) {
                        builder.state(State.fromString(parser.text()));
    private static void validateRemoteStoreSettingEnabled(final Map<Setting<?>, Object> settings, Setting<?> setting) {
            Builder builder = new Builder(parser.currentName());
        final Version indexUpgradedVersion,
        if (routingNumShards % numTargetShards != 0) {
        return this.indexTotalRemoteCapableShardsPerNodeLimit;
            if (indexMetadata.getCreationVersion().onOrAfter(Version.V_3_3_0) && indexMetadata.ingestionStatus != null) {
        assert primaryTermsMap.size() == numberOfShards;
     * restore point impossible; without it the trigger loses acknowledged writes
    public static final String SETTING_PRIORITY = "index.priority";
                DiffableUtils.getVIntKeySerializer(),
            return false;
     * @throws IllegalArgumentException if the index doesn't contain a "-" separator or if the last token after the separator is not a
     * Returns the source shard ID to clone the given target shard off
            this.inSyncAllocationIds = new HashMap<>();
                builder.endObject();
                    );
                                + " prevents it from acknowledging writes the restored copy will never see"
 * software distributed under the License is distributed on an
    }
        private static final DiffableUtils.DiffableValueReader<String, DiffableStringMap> CUSTOM_DIFF_VALUE_READER =
                            if (token == XContentParser.Token.FIELD_NAME) {
    public static final ClusterBlock INDEX_READ_ONLY_BLOCK = new ClusterBlock(
                "the number of target shards ["
    public boolean isRoutingPartitionedIndex() {
            }
    static class IndexMetadataDiff implements Diff<IndexMetadata> {
        }
            );
                builder.field(CONTEXT_KEY);
                    "the number of source shards [" + sourceNumberOfShards + "] must be a " + "multiple of [" + targetNumberOfShards + "]"
                Locale.ROOT,
        "index write (api)",
    }
            mappingVersion = in.readVLong();
    public static final Setting<String> INDEX_DATA_PATH_SETTING = new Setting<>(
    }
     * This looks for the presence of the {@link Version} object with key {@link IndexMetadata#SETTING_VERSION_CREATED}
            rolloverInfos.put(rolloverInfo.getAlias(), rolloverInfo);
    );
        private final Diff<Map<String, AliasMetadata>> aliases;
    );
        return index;
        out.writeVLong(mappingVersion);
        return this.indexTotalShardsPerNodeLimit;
        }
            );
                .setBlockingQueueSize(blockingQueueSize)
            mappings = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), MAPPING_DIFF_VALUE_READER);
                    + setting.getKey()
        private long version = 1;
        if (version != Version.V_EMPTY) {
        if (out.getVersion().before(Version.V_3_6_0)) {
                        throw new IllegalArgumentException(
            1,
    static final String MAX_NUMBER_OF_SHARDS = "opensearch.index.max_number_of_shards";
        Property.UnmodifiableOnRestore
        out.writeInt(routingNumShards);
    }
            } else {
        }
        private SplitShardsMetadata splitShardsMetadata;
            this.aliases = new HashMap<>();
    );
                                    if (token == XContentParser.Token.VALUE_STRING) {
        out.writeLong(version);
    public static final String INDEX_ROUTING_REQUIRE_GROUP_PREFIX = "index.routing.allocation.require";
                    + MAX_NUMBER_OF_SHARDS
            aliases = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), ALIAS_METADATA_DIFF_VALUE_READER);
                    + " value ["
        public int numberOfShards() {
            return this;
                builder.endArray();
            // Warmup settings
                MappingMetadata mmd = indexMetadata.mapping();
import java.time.Instant;
        Builder.toXContent(this, builder, params);
    public static final Setting<String> INDEX_RESIZE_SOURCE_NAME = Setting.simpleString(INDEX_RESIZE_SOURCE_NAME_KEY);
                    );
        out.writeVInt(inSyncAllocationIds.size());
        out.writeMapValues(aliases, (stream, val) -> val.writeTo(stream));
    public int getRoutingPartitionSize() {
                context = in.readOptionalWriteable(Context::new);
                requireFilters,
    }
    /**
            DiffableUtils.StringSetValueSerializer.getInstance().write(cursor.getValue(), out);
            out.writeVLongArray(buildPrimaryTermsArray());
        }
     * Used to specify if the bulk should use adaptive shard selection to select one shard.
     */
    public static final String SETTING_HISTORY_UUID = "index.history.uuid";
                                currentFieldName = parser.currentName();
        result = 31 * result + aliases.hashCode();
        public long aliasesVersion() {
        0L,
                if (mmd != null) {
            isSystem = in.readBoolean();
        public Builder numberOfReplicas(int numberOfReplicas) {
        this.inSyncAllocationIds = Collections.unmodifiableMap(inSyncAllocationIds);
        this.isAppendOnlyIndex = isAppendOnlyIndex;
        0,
            return this;
                    if (resetValue == null || resetValue.isEmpty()) {
        }
                rolloverInfos,
                context,
        final int routingFactor = getRoutingFactor(numSourceShards, numTargetShards);
            (stream, val) -> DiffableUtils.StringSetValueSerializer.getInstance().write(new TreeSet<>(val), stream)
            aliases.remove(alias);
        this.mappingVersion = mappingVersion;
        if (numberIndex == -1) {
 * KIND, either express or implied.  See the License for the
        ReplicationType::parseString,
            settings = Settings.builder().put(settings).put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas).build();
        } else if (sourceIndexMetadata.getNumberOfShards() < numTargetShards) {
            return Integer.parseInt(
                initializePrimaryTerms();
                }
package org.opensearch.cluster.metadata;
        READ_ONLY_ALLOW_DELETE("read_only_allow_delete", INDEX_READ_ONLY_ALLOW_DELETE_BLOCK),
import org.opensearch.core.common.io.stream.Writeable;
    public static final Setting<Boolean> INDEX_BLOCKS_READ_SETTING = APIBlock.READ.setting();
        "",
    }
            XContentParser.Token token = parser.nextToken();
                            primaryTermsMap.put(shard, parser.longValue());
        new Setting.Validator<>() {
            if (indexMetadata.splitShardsMetadata != null) {
    }
     * - For "&lt;logs-{now/d}-3&gt;" it'll return 3
                            } else {
     * Used to specify initial reset policy for the ingestion pointer. If not specified, default to the latest
        Property.IndexScope,
            this.primaryTermsMap = new HashMap<>(primaryTermsMap);
                .setDecoderType(decoderType)
    public int getIndexTotalRemoteCapablePrimaryShardsPerNodeLimit() {
        if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
        return totalNumberOfShards;
    );
    public int getNumberOfShards() {
     */
                throw new IllegalArgumentException("must specify number of shards for index [" + index + "]");
        private void primaryTerms(long[] primaryTerms) {
        this.indexTotalRemoteCapableShardsPerNodeLimit = indexTotalRemoteCapableShardsPerNodeLimit;
            }
        }
                before.inSyncAllocationIds,
                    );
        }
                    currentFieldName = parser.currentName();
        // note: if the number of shards is 1 in the source index we can just assume it's correct since from 1 we can split into anything
            );
            );
        Property.Dynamic
            final String message = String.format(
     *
    public int getRoutingFactor() {
    }
            }
/**
            final Map<String, Object> ingestionSourceParams = INGESTION_SOURCE_PARAMS_SETTING.getAsMap(settings);
                            builder.putAlias(AliasMetadata.Builder.fromXContent(parser));
     *
                            Integer shard = Integer.parseInt(parser.currentName());
        out.writeVInt(rolloverInfos.size());
                builder.startArray(KEY_ALIASES);
        final Map<String, MappingMetadata> mappings,
        SETTING_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED,
                    }
     * The number of active shard copies to check for before proceeding with a write operation.
        "index.remote_store.segment.path_prefix",
    private final int routingNumShards;
            mappings = DiffableUtils.diff(before.mappings, after.mappings, DiffableUtils.getStringKeySerializer());
         * an index has changed ie if the index is shrunk.
        new Setting.Validator<>() {
        this.includeFilters = includeFilters;
        }
                        "number of virtual shards ["
     * Returns the configured {@link #SETTING_WAIT_FOR_ACTIVE_SHARDS}, which defaults
                "Settings "
            SETTING_NUMBER_OF_SHARDS,
            builder.startObject(KEY_PRIMARY_TERMS_MAP);
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
        "index.ingestion_source.pointer_based_lag_update_interval";
    static final String KEY_STATE = "state";
        this.numberOfReplicas = numberOfReplicas;
        Property.IndexScope
                builder.startArray(KEY_PRIMARY_TERMS);
            );
        IndexMetadataDiff(IndexMetadata before, IndexMetadata after) {
                }
        public Builder system(boolean system) {
                                builder.putInSyncAllocationIds(Integer.valueOf(shardId), allocationIds);
        SETTING_NUMBER_OF_SEARCH_REPLICAS,
        },
    public static final String SETTING_INGESTION_SOURCE_PARTITION_STRATEGY = "index.ingestion_source.source_partition_strategy";
        RestStatus.FORBIDDEN,
        Property.IndexScope,
        final Map<String, AliasMetadata> aliases,
            int key = in.readVInt();
import org.opensearch.cluster.Diffable;
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
import java.util.Collections;
     *
        if (out.getVersion().onOrAfter(Version.V_3_6_0)) {
 *
     */
                ingestionStatus,
                        + getRoutingNumShards()
        } catch (Version.UnsupportedVersionException e) {
    );
         */
    static final String KEY_ROUTING_NUM_SHARDS = "routing_num_shards";
    public int getNumberOfSearchOnlyReplicas() {
         * @see #setRoutingNumShards(int)
    public static final Setting.AffixSetting<Object> INGESTION_SOURCE_MAPPER_SETTINGS = Setting.prefixKeySetting(
                    builder.field(Integer.toString(shard), indexMetadata.primaryTerm(shard));
    static final String KEY_SETTINGS_VERSION = "settings_version";
    /**
        out.writeByte(state.id());
        1,
            customData = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), CUSTOM_DIFF_VALUE_READER);
     */
                return CLOSE;
     * @return a the source shard ID to split off from
        /**
                            + "]"
        }
            for (final RolloverInfo cursor : indexMetadata.getRolloverInfos().values()) {
    @Override
            this.block = block;
        }
                                String shardId = currentFieldName;
    );
            .append(routingNumShards)
    /**
        false,
        new Setting.Validator<>() {
        OPEN((byte) 0),
        if (routingNumShards != that.routingNumShards) {
        ActiveShardCount::parseString,
            if (includeMap.isEmpty()) {
     */
     * State format for {@link IndexMetadata} to write to and load from disk
     * {@code index.ingestion_source.decoder_settings.schema_registry_url: https://...}
        false,
        RestStatus.TOO_MANY_REQUESTS,
     * object store. The fence's strictly-greater-term takeover is what makes acknowledging past the restored copy's
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;
            out.writeString(cursor.getKey());
    private final Map<String, RolloverInfo> rolloverInfos;
            }
                getRoutingFactor(numShards, numRoutingShards);
import org.opensearch.cluster.block.ClusterBlockLevel;
        Function.identity(),
    /**
            settings = after.settings;
            new DiffableUtils.DiffableValueReader<>(AliasMetadata::new, AliasMetadata::readDiffFrom);
            isSystem = after.isSystem;
                    } else if (KEY_SETTINGS_VERSION.equals(currentFieldName)) {
        final int routingPartitionSize,
    private final int indexTotalRemoteCapableShardsPerNodeLimit;
                }
        READ_ONLY("read_only", INDEX_READ_ONLY_BLOCK),
            this.settingName = "index.blocks." + name;
                return settings.iterator();
     * This controls how frequently the lag between the latest available message and the last consumed message is calculated.
 * Licensed to Elasticsearch under one or more contributor
    );
     * Defines the setting for the value to be used when resetting by offset or timestamp.
    /**
    public long getAliasesVersion() {
    public static final String SETTING_INGESTION_SOURCE_MAPPER_TYPE = "index.ingestion_source.mapper_type";
            this.state = indexMetadata.state;
        return excludeFilters;
            }
        final Map<String, RolloverInfo> rolloverInfos,
                    }
     * live node, so the shard goes unassigned &rarr; recovering &rarr; started with no operator action.
    );
}
            }
        }
     * <p>
        INDEX_UUID_NA_VALUE,
    public static final String SETTING_REMOTE_SEGMENT_STORE_REPOSITORY = "index.remote_store.segment.repository";
    }
    private final long mappingVersion;
    }
     * with their primary.  Search replicas require the use of Segment Replication on the index and poll their {@link SegmentReplicationSource} for
    );
        }
        13,
                assert primaryTerms != null;
import org.opensearch.core.common.Strings;
                            + "] for ["
    }
            return false;
                            + numberOfShards
    /**
    /**
        }
        public Builder putCustom(String type, Map<String, String> customIndexMetadata) {
    public boolean useIngestionSource() {
     * Returns the routing factor for and shrunk index with the given number of target shards.
                DiffableUtils.getVIntKeySerializer(),
            Version indexUpgradedVersion = settings.getAsVersion(IndexMetadata.SETTING_VERSION_UPGRADED, indexCreatedVersion);
     */
    public static final Setting<Boolean> INDEX_REMOTE_STORE_ENABLED_SETTING = Setting.boolSetting(
        params.put("binary", "true");
        }
                    );
        return inSyncAllocationIds.get(shardId);
            .append(", settings=")
    );
     * physical shards instead of default modulo hashing. This ensures contiguous bucket mapping
                            }
    }
        result = 31 * result + customData.hashCode();
                .setPollTimeout(pollTimeout)
                    + " ["
    public static final Setting<Boolean> INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING = Setting.boolSetting(
            builder.putInSyncAllocationIds(key, allocationIds);
            settings = Settings.readSettingsFromStream(in);
            return this;
     * {@link org.opensearch.cluster.routing.OperationRouting#generateShardId(IndexMetadata, String, String)} to guarantee consistent
     * {@link org.opensearch.cluster.routing.OperationRouting#generateShardId(IndexMetadata, String, String)} to route documents
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_ENABLED_SETTING);
            );
        @Override
        this.ingestionStatus = ingestionStatus;
import org.opensearch.core.xcontent.ToXContentFragment;
                    } else if (KEY_ALIASES_VERSION.equals(currentFieldName)) {
    private final long aliasesVersion;
        return new IndexMetadataDiff(previousState, this);
            return mappings.get(MapperService.SINGLE_MAPPING_NAME);
 * SPDX-License-Identifier: Apache-2.0
                    } else {
                                + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
     * Prefix setting for mapper-specific options. These settings are passed to the configured mapper type.
        private void primaryTermsMap(Map<Integer, Long> primaryTermsMap) {
    );
    }
        out.writeBoolean(isSystem);
                int numShards = (int) settings.get(INDEX_NUMBER_OF_SHARDS_SETTING);
        this.indexTotalShardsPerNodeLimit = indexTotalShardsPerNodeLimit;
        }
    ) {
        } else {
                "the number of routing shards [" + routingNumShards + "] must be a multiple of the target shards [" + numTargetShards + "]"
    /**
            shards.add(new ShardId(sourceIndexMetadata.getIndex(), i));
            throw new IllegalArgumentException("No primary term available for shard " + shardId);
        Setting.Property.IndexScope
             */
 * You may obtain a copy of the License at
        Property.IndexScope,
        return numberOfShards;
                            } else {
            return this;
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.AND;
            } else {
     *                                  number
            if (token != XContentParser.Token.START_OBJECT) {
            Map<String, String> excludeMap = INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getAsMap(settings);
        if (sourceIndexMetadata.getNumberOfShards() < numTargetShards) {
        100L,
    }
            this.aliasesVersion = indexMetadata.aliasesVersion;
            return setting;
    public State getState() {
    /**
                        throw new IllegalArgumentException(
            throw new IllegalArgumentException(MAX_NUMBER_OF_SHARDS + " must be > 0");
    /**
                    throw new IllegalArgumentException(
                    throw new IllegalArgumentException(
        }
     * @param numTargetShards     the total number of shards in the target index
     * Adds human readable version and creation date settings.
                splitShardsMetadata,
        Setting.Property.Final
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
                for (final AliasMetadata cursor : indexMetadata.getAliases().values()) {
        }
                    );
                        assert Version.CURRENT.major <= 5;
        }
        final Setting<Boolean> setting;
                }
                    }
        public Builder putRolloverInfo(RolloverInfo rolloverInfo) {
                    } else if (KEY_SPLIT_SHARDS_METADATA.equals(currentFieldName)) {
                    if (KEY_MAPPINGS.equals(currentFieldName)) {
        Property.IndexScope,
        }
            this.aliasesVersion = aliasesVersion;
        try {
        out.writeVLong(settingsVersion);
        public IndexMetadata apply(IndexMetadata part) {
            assert settingsVersion : "settings version should be present for indices";
    static {
    public int getNumberOfReplicas() {
        this.indexTotalRemoteCapablePrimaryShardsPerNodeLimit = indexTotalRemoteCapablePrimaryShardsPerNodeLimit;
        Property.Dynamic
        public Builder aliasesVersion(final long aliasesVersion) {
    );
    }
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        public Builder putAlias(AliasMetadata aliasMetadata) {
        }
         * other than 1. This value is applicable only if the index.number_of_shards setting is not provided as part of the
import org.opensearch.common.annotation.PublicApi;
         * See {@link IndexMetadata#primaryTerm(int)} for more information.
        public boolean isSystem() {
    public static final String SETTING_VERSION_UPGRADED = "index.version.upgraded";
            return false;
        for (final Map.Entry<Integer, Set<String>> cursor : inSyncAllocationIds.entrySet()) {
            if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
     * to shards based on their ID or their specific routing value. The default value is {@link #getNumberOfShards()}. This value only
        final long settingsVersion,
            return this;
            final boolean allActiveIngestionEnabled = INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings);
                throw new IllegalArgumentException(
import java.time.ZoneOffset;
            putMapping(
            }
        return new StringBuilder().append("IndexMetadata{routingNumShards=")
    }
 * license agreements. See the NOTICE file distributed with
                );
        builder.system(in.readBoolean());
        Property.Dynamic
                }
import org.opensearch.common.compress.CompressedXContent;
    }
            builder.aliasesVersion(aliasesVersion);
            final DiscoveryNodeFilters excludeFilters;
                builder.endArray();
        }
     * streaming source and process the updates. In the default document replication mode, this setting must be enabled.
        INDEX_ROUTING_INCLUDE_GROUP_PREFIX + ".",
            @Override
     */
                initializePrimaryTerms();
        Property.Final
            if (numberOfVirtualShards != -1) {
        }
                        }
                    }
                                + " is enabled: the auto-restore trigger fires on the cluster manager's view of node"
            return value;
    public static final String REMOTE_STORE_SSE_ENABLED_INDEX_KEY = "sse_enabled_index";
            .append(", rolloverInfos=")
                            }
        }
    }
        public Builder version(long version) {
                settings
        }
        SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
            }
        RestStatus.FORBIDDEN,
         */
            }
     *                                  are not divisible by the number of target shards.
            cursor.writeTo(out);
        false,
                            if (token == XContentParser.Token.FIELD_NAME) {
        /**
            } else {
     * Returns the number of shards that should be used for routing. This basically defines the hash space we use in
                indexMetadata.splitShardsMetadata.toXContent(builder, params);
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.IndexScope)
        public long mappingVersion() {
    public static final Setting<Integer> INDEX_NUMBER_OF_VIRTUAL_SHARDS_SETTING = Setting.intSetting(
    }
        SETTING_VERSION_CREATED,
        Property.IndexScope,
        final int indexTotalShardsPerNodeLimit,
    public Settings getSettings() {
            if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
                for (int shard = 0; shard < indexMetadata.getNumberOfShards(); shard++) {
            return this.customMetadata.remove(type);
                );
        private final Diff<SplitShardsMetadata> splitMetadata;
     * This factor is used in the hash function in
        return INDEX_RESIZE_SOURCE_UUID.exists(settings)
        for (int i = 0; i < mappingsSize; i++) {
        }
 *
        }
    private final DiscoveryNodeFilters includeFilters;
        private final long version;
            if (mappingMd != null) {
        false,
     * A value of 0 means fully caught up (no lag).
            this.context = context;
        this.aliases = Collections.unmodifiableMap(aliases);
        return pTerm;
    }
        Property.IndexScope
    public static final ClusterBlock INDEX_READ_ONLY_ALLOW_DELETE_BLOCK = new ClusterBlock(
        }
    private final int numberOfShards;
        out.writeLong(version);
import java.util.Map;
        Property.IndexScope,
                            + "]"
        READ("read", INDEX_READ_BLOCK),
                                throw new IllegalArgumentException("Unexpected token: " + token);
import org.opensearch.cluster.block.ClusterBlock;
        return shards;
            .append(state)
            this.settings = indexMetadata.getSettings();
        SETTING_NUMBER_OF_VIRTUAL_SHARDS,
    }
            if (numberOfShards() < 0) {
    public static final String SETTING_INGESTION_SOURCE_DECODER_TYPE = "index.ingestion_source.decoder_type";
                        builder.setRoutingNumShards(parser.intValue());
        if (shardId >= numTargetShards) {
                        builder.settings(Settings.fromXContent(parser));
                after.inSyncAllocationIds,
     * Defines the poll timeout for pull-based ingestion in milliseconds.
        Setting.Property.Dynamic,
                    } else {
         * index creation request. */
        new Setting.Validator<Integer>() {
     * @param sourceNumberOfShards the total number of shards in the source index
                excludeFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, OR, excludeMap);
            out.writeVLong(aliasesVersion);
     * <p>
        @Override
        final int maxNumShards = Integer.parseInt(System.getProperty(MAX_NUMBER_OF_SHARDS, "1024"));
     * <p>
            return false;
    /**
        }
        private IngestionStatus ingestionStatus;
        final Index index,
            Map<String, String> includeMap = INDEX_ROUTING_INCLUDE_GROUP_SETTING.getAsMap(settings);
        );
                                + " can only be set/enabled when "
            return this;
            public void validate(final ReplicationType value) {}
            String key = in.readString();
            final String pointerInitResetValue = INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING.get(settings);
                includeFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, OR, includeMap);
import org.opensearch.action.support.ActiveShardCount;
        Property.Final
        }
            .append(", primaryTerms=")
        public Map<String, String> removeCustom(String type) {
                            "Setting "
@PublicApi(since = "1.0.0")
        1,
     * @param shardId             the id of the target shard to split into
                if (block.settingName.equals(settingName)) {
            if (parser.currentToken() == null) { // fresh parser? move to the first token
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
    /**
            public void validate(final Boolean value, final Map<Setting<?>, Object> settings) {
                    throw new IllegalArgumentException(
        return INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings);
                this.primaryTermsMap.put(i, SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
            builder.putCustom(key, custom);
                parser.nextToken();
    /**
        public Builder removeAllAliases() {
        result = 31 * result + Long.hashCode(routingFactor);
            this.version = indexMetadata.version;
            this.ingestionStatus = ingestionStatus;
                if (block.name.equals(name)) {
    @Override
            throw new IllegalArgumentException("No block found with setting name " + settingName);
            final String message = String.format(
            public void validate(final Boolean value) {}
    );
        private final Map<String, RolloverInfo> rolloverInfos;
 * this file be licensed under the Apache-2.0 license or a
        1,
            }
                        + SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey()
            throw new IllegalStateException("No state match for id [" + id + "]");
     * Defines if all-active pull-based ingestion is enabled. In this mode, replicas will directly consume from the
    public static class Builder {
            .append(index)
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.IndexScope)
     * @param sourceIndexMetadata the source metadata
    public static final String INDEX_STATE_FILE_PREFIX = "state-";
    public static final String SETTING_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED = "index.bulk.adaptive_shard_selection.enabled";
        "index.ingestion_source.mapper_settings.",
                indexMetadata.getSettings().toXContent(builder, new MapParams(Collections.singletonMap("flat_settings", "true")));
        }
            out.writeString(index);
    /**
    public static final String SETTING_INGESTION_SOURCE_POINTER_INIT_RESET = "index.ingestion_source.pointer.init.reset";
            builder.field(KEY_SETTINGS_VERSION, indexMetadata.getSettingsVersion());
    );
    public static final String INDEX_UUID_NA_VALUE = Strings.UNKNOWN_UUID_VALUE;
        SETTING_INGESTION_SOURCE_POLL_TIMEOUT,
                        builder.aliasesVersion(parser.longValue());
        SETTING_REMOTE_STORE_ENABLED,
            if (indexMetadata.context != null) {
        "1",
            factor = 1;
            .append(ingestionStatus)
            }
            }
     */
                            + "] must be a multiple of number of shards ["
    public static final Setting<Boolean> INDEX_BLOCKS_SEARCH_ONLY_SETTING = APIBlock.SEARCH_ONLY.setting();
        public Setting<Boolean> setting() {
    public static final String SETTING_VERSION_CREATED = "index.version.created";
     * Defines how the incoming ingestion message payload is mapped to the internal message format.
            return false;
            this.id = id;
        key -> new Setting<>(key, "", (value) -> {
            .append(context)
     * updates.  //TODO: Once physical isolation is introduced, reference the setting here.
    public static final String INDEX_ROUTING_EXCLUDE_GROUP_PREFIX = "index.routing.allocation.exclude";
        int mappingsSize = in.readVInt();
            .append(settings)
    private final SplitShardsMetadata splitShardsMetadata;
        }
                                        allocationIds.add(parser.text());
    );
                }
        /* This is a safety limit that should only be exceeded in very rare and special cases. The assumption is that
        final Context context,
        }
        public Builder(IndexMetadata indexMetadata) {
    public static final String SETTING_INGESTION_SOURCE_TYPE = "index.ingestion_source.type";
                state,
        }
     */
            return builder.build();
                        builder.value(mmd.source().compressed());
                includeFilters,
                    } else if (KEY_ROUTING_NUM_SHARDS.equals(currentFieldName)) {
        }
            @Override
    public static final String SETTING_INGESTION_SOURCE_POLL_TIMEOUT = "index.ingestion_source.poll.timeout";
            primaryTermsMap.put(shardId, primaryTerm);
            IngestionSource.PointerInitReset pointerInitReset = new IngestionSource.PointerInitReset(
     * A diff of index metadata.
        }
import java.util.ArrayList;
        int aliasesSize = in.readVInt();
     * store (the state that otherwise parks at {@code NO_VALID_SHARD_COPY}, RED) into a remote-store recovery on a
        if (!inSyncAllocationIds.equals(that.inSyncAllocationIds)) {
                    } else if (KEY_ALIASES.equals(currentFieldName)) {
                    + numTargetShards
                    return block;
            .append(", aliases=")
                        "index.number_of_routing_shards [" + numRoutingShards + "] must be >= index.number_of_shards [" + numShards + "]"
        private final Diff<Map<String, MappingMetadata>> mappings;
            }
        IndexMetadata that = (IndexMetadata) o;
        Property.IndexScope,
     * Setting this to 0 disables pointer-based lag calculation entirely.
     */
            primaryTermsMap = after.primaryTermsMap;
     * Used to specify if the index data should be persisted in the remote store.
    }
     */
                    }
            routingNumShards = in.readInt();
            return settingName;
                        }
        return routingFactor;
                DiffableUtils.StringSetValueSerializer.getInstance()
            if (out.getVersion().onOrAfter(Version.V_3_6_0)) {
     * @param sourceIndexMetadata the source index metadata
        }
                    || isResetState(value);
     */
     * every writer acknowledges through the remote translog upload path, and a docrep-backed writer during
        }
    public static final ClusterBlock REMOTE_READ_ONLY_ALLOW_DELETE = new ClusterBlock(
    public static int getRoutingFactor(int sourceNumberOfShards, int targetNumberOfShards) {
                            token = parser.nextToken();
    public static final Setting<String> SETTING_INDEX_HISTORY_UUID = Setting.simpleString(
            } else if (id == 1) {
        Property.Final
    }
                }
            return this;
import org.opensearch.cluster.routing.allocation.IndexMetadataUpdater;
     */
    }
        public void writeTo(StreamOutput out) throws IOException {
     * an internal index format description, allowing us to find out if this index is upgraded or needs upgrading
     * @param targetNumberOfShards the total number of shards in the target index
            );
        "",
    public DiscoveryNodeFilters getInitialRecoveryFilters() {
    }
    public static final String SETTING_INGESTION_SOURCE_POINTER_INIT_RESET_VALUE = "index.ingestion_source.pointer.init.reset.value";
            builder.ingestionStatus(in.readOptionalWriteable(IngestionStatus::new));
            for (APIBlock block : APIBlock.values()) {
                        + "] but should be equal to number of shards ["
                            + index
    /**
                out.writeVLongArray(primaryTermsArray);
        }
                    primaryTermsMap.put(i, SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
                throw new IllegalArgumentException(
     * Defines the error strategy for pull-based ingestion.
    /**
                    } else if (KEY_MAPPING_VERSION.equals(currentFieldName)) {
            @Override
    private final Map<Integer, Long> primaryTermsMap;
            Builder builder = builder(index);
        }
     * "modulo": each shard consumes all partitions where partition % numShards == shardId.
    public static final String SETTING_INGESTION_SOURCE_WARMUP_TIMEOUT = "index.ingestion_source.warmup.timeout";
    public static final String SETTING_NUMBER_OF_VIRTUAL_SHARDS = "index.number_of_virtual_shards";
        private final Map<String, AliasMetadata> aliases;
            builder.field(KEY_ALIASES_VERSION, indexMetadata.getAliasesVersion());
    }
            return this;
            @Override
     * information is typically useful for backward compatibility.
     * <p>
     * A search only replica exists solely to perform read operations for a shard and are designed to achieve
    public static Version indexCreated(final Settings indexSettings) {
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_ENABLED_SETTING);
                } else if (token == XContentParser.Token.START_ARRAY) {
            out.writeOptionalWriteable(context);
        private boolean isSystem;
    private final Index index;
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
                    // Validate that remote store is enabled when this setting is used
        }
        int numSourceShards = sourceIndexMetadata.getNumberOfShards();
            } else if ("close".equals(state)) {
                            } else if (token == XContentParser.Token.START_OBJECT) {
            }
                        mappingVersion = true;
        public Builder putMapping(MappingMetadata mappingMd) {
    public Index getIndex() {
        SETTING_INGESTION_SOURCE_WARMUP_TIMEOUT,
        Setting.Property.IndexScope,
        @Override
            }
    private final transient int totalNumberOfShards;
            // TODO: support ingestion source
            }
        return this.customData.get(key);
    public static final Setting<TimeValue> INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING = Setting.timeSetting(
            final Map<String, String> requireMap = INDEX_ROUTING_REQUIRE_GROUP_SETTING.getAsMap(settings);
                .setMapperType(mapperType)
        return null;
                );
            }
    private final int indexTotalRemoteCapablePrimaryShardsPerNodeLimit;
    /**
                numberOfReplicas,
        }
        },
    );
    }
        this.excludeFilters = excludeFilters;
        }
     * Used to enable automatic restore of a remote-store-backed primary whose last copy was lost with the node that
                    Map<String, Object> mapping = XContentHelper.convertToMap(mmd.source().uncompressed(), false).v2();
        8,
    private IndexMetadata(
    public SplitShardsMetadata getSplitShardsMetadata() {
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE, ClusterBlockLevel.WRITE)
            : null;
            this.isSystem = false;
        CLOSE((byte) 1);
                final List<Setting<?>> settings = List.of(INDEX_REMOTE_STORE_ENABLED_SETTING);
            if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
                            if (token == XContentParser.Token.VALUE_NUMBER) {
            || getRoutingFactor(numTargetShards, routingNumShards) >= 0;
        0,
        final ActiveShardCount waitForActiveShards,
            final int indexTotalPrimaryShardsPerNodeLimit = ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(
     *
            boolean settingsVersion = false;
            .append(", context=")
            @Override
        private static final DiffableUtils.DiffableValueReader<String, RolloverInfo> ROLLOVER_INFO_DIFF_VALUE_READER =
            MappingMetadata mappingMd = new MappingMetadata(in);
            this.inSyncAllocationIds = new HashMap<>(indexMetadata.inSyncAllocationIds);
            }
        false,
        }
    }
            }
        this.aliasesVersion = aliasesVersion;
            }
        false,
        false,
        public static State fromId(byte id) {
                        }
         * sets the primary term for the given shard.
    public static final Setting<IngestionSource.SourcePartitionStrategy> INGESTION_SOURCE_PARTITION_STRATEGY_SETTING = new Setting<>(
        public Builder index(String index) {
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
     *
    public static final String INDEX_RESIZE_SOURCE_NAME_KEY = "index.resize.source.name";
            builder.inSyncAllocationIds.putAll(inSyncAllocationIds.apply(part.inSyncAllocationIds));
                            }
        public int getRoutingNumShards() {
        final int indexTotalPrimaryShardsPerNodeLimit,
         */
            public void validate(final Integer numRoutingShards, final Map<Setting<?>, Object> settings) {
     * Prefix setting for decoder-specific options. Each decoder factory validates
                        throw new IllegalArgumentException(
    }
        SETTING_INGESTION_SOURCE_TYPE,
            final Map<String, AliasMetadata> tmpAliases = aliases;
        }
            index = in.readString();
        assert getIndexUUID() != null;
        }
        RestStatus.FORBIDDEN,
                builder.startObject(KEY_MAPPINGS);
        this.bulkAdaptiveShardSelectionEnabled = INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED.get(settings);
     * Whether the index is considered hidden or not. A hidden index will not be resolved in
        return otherUUID.equals(getIndexUUID());
                            + INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.getKey()
                        + numberOfShards()
     * Defines the strategy for mapping source stream partitions to OpenSearch shards.
            builder.startObject(KEY_IN_SYNC_ALLOCATIONS);
         * Sets the number of shards that should be used for routing. This should only be used if the number of shards in
     */
            return this;
                    }
            builder.ingestionStatus(ingestionStatus);
        false,
            out.writeMap(primaryTermsMap, StreamOutput::writeInt, StreamOutput::writeLong);
                ingestionStatus = in.readOptionalWriteable(IngestionStatus::new);
        Property.IndexScope,
            return settings(settings.build());
        this.rolloverInfos = Collections.unmodifiableMap(rolloverInfos);
                builder.field(String.valueOf(cursor.getKey()), cursor.getValue());
        return initialRecoveryFilters;
            return this;
                initialRecoveryFilters = null;
        Property.Dynamic
    private final DiscoveryNodeFilters requireFilters;
        return indexCreatedVersion;
            return true;
        }
    static final String KEY_SYSTEM = "system";
            if (entry.getKey() < numberOfShards) {
                }
                            + " should be provided with non-empty repository ID"
        SETTING_INGESTION_SOURCE_DECODER_TYPE,
     * Defines the internal blocking queue size that is used to decouple poller and processor in pull-based ingestion.
        public Builder mappingVersion(final long mappingVersion) {
        final SplitShardsMetadata splitShardsMetadata,
        assert otherUUID != null;
import org.opensearch.index.IndexModule;
        }
                                + INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey()
                                + " is set to true"
                        }
                        parser.skipChildren();
    public static final String SETTING_INGESTION_SOURCE_MAX_POLL_SIZE = "index.ingestion_source.poll.max_batch_size";
                            + " should be set to "
                        "number of virtual shards ["
            return false;
            builder.put(SETTING_CREATION_DATE_STRING, creationDateTime.toString());
            this.index = index;
        SETTING_REPLICATION_TYPE,
        "index.routing.allocation.initial_recovery.",
            cursor.getValue().writeTo(out);
            cursor.writeTo(out);
     *
    public long getCreationDate() {
                        + primaryTermsMap.size()
                    + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
        this.numberOfShards = numberOfShards;
                    + "which is not supported. Please disable bulk adaptive shard selection or set index to append-only index."
                    if (value.contains("/") || value.contains("\\") || value.contains(":")) {
     * @return the routing factor for and shrunk index with the given number of target shards.
    );
        this.routingNumShards = routingNumShards;
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_PARAM;
        return rolloverInfos;
        final int indexTotalRemoteCapableShardsPerNodeLimit,
            }
                    );
            .append(", mappings=")
        Property.Final
        Property.UnmodifiableOnRestore
    }
    public static final Setting<String> INDEX_RESIZE_SOURCE_UUID = Setting.simpleString(INDEX_RESIZE_SOURCE_UUID_KEY);
        }
        Property.IndexScope,
        IngestionMessageMapper.MapperType::fromString,
        1000,
         * returns the primary term for the given shard.
    public Context context() {
            return value;
                        builder.putCustom(currentFieldName, parser.mapStrings());
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.get(settings);
        }
                    } else if (KEY_MAPPINGS.equals(currentFieldName)) {
    );
     */
        Property.PrivateIndex,
        final IngestionStatus ingestionStatus,
     * The state of the index.
        private Settings settings = Settings.Builder.EMPTY_SETTINGS;
import org.opensearch.index.IndexSettings;
            .append(splitShardsMetadata)
        builder.settings(readSettingsFromStream(in));
    public static final Setting.AffixSetting<String> INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING = Setting.prefixKeySetting(
        out.writeVLong(mappingVersion);
            );
            final IngestionErrorStrategy.ErrorStrategy errorStrategy = INGESTION_SOURCE_ERROR_STRATEGY_SETTING.get(settings);
        }
        if (out.getVersion().onOrAfter(Version.V_3_6_0)) {
                if (!isValidResetState(value)) {
        Property.IndexScope
    public static final Setting<Boolean> INDEX_HIDDEN_SETTING = Setting.boolSetting(
        long[] primaryTerms = null;
        return numberOfReplicas;
    public static final String SETTING_INDEX_HIDDEN = "index.hidden";
            final IngestionSource.WarmupConfig warmupConfig = new IngestionSource.WarmupConfig(
            Metadata.XContentContext context = Metadata.XContentContext.valueOf(
            return settingsVersion;
    );
     * Used to enable object-store-backed primary fencing for remote-store-backed indices. When enabled, every
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.get(settings);
        public Set<String> getInSyncAllocationIds(int shardId) {
        return new ShardId(sourceIndexMetadata.getIndex(), shardId / routingFactor);
     * Test whether the current index UUID is the same as the given one. Returns true if either are _na_
            for (final Map.Entry<String, DiffableStringMap> cursor : indexMetadata.customData.entrySet()) {
            for (final Map.Entry<Integer, Long> cursor : indexMetadata.primaryTermsMap.entrySet()) {
        Setting.Property.Final
        INDEX_ROUTING_EXCLUDE_GROUP_PREFIX + ".",
        assert settingsVersion >= 0 : settingsVersion;
                        "Replication type "
            throw new IllegalStateException(message);
                }
        if (numSourceShards > numTargetShards) {
    }
                // onwards.
    private final ActiveShardCount waitForActiveShards;
        final String settingName;
     * supported and required keys. Example:
        out.writeVInt(customData.size());
    public static final ClusterBlock INDEX_READ_BLOCK = new ClusterBlock(
    public ActiveShardCount getWaitForActiveShards() {
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
    @Override
            }
            customData.writeTo(out);
                primaryTermsMap = in.readMap(StreamInput::readInt, StreamInput::readLong);
            this.name = name;
        return this.indexTotalPrimaryShardsPerNodeLimit;
        private final Map<Integer, Long> primaryTermsMap;
public class IndexMetadata implements Diffable<IndexMetadata>, ToXContentFragment, VerifiableWriteable {
                    } else if (CONTEXT_KEY.equals(currentFieldName)) {
                "index ["
                                }
                getRoutingNumShards(),
    /**
            } else {
                            + " is not supported in pull-based ingestion when "
            }
                // TODO: validate this with the ingestion source params
            return this;
        return terms;
        true,
import org.opensearch.gateway.MetadataStateFormat;
    public static final String INDEX_ROUTING_INCLUDE_GROUP_PREFIX = "index.routing.allocation.include";
    );
            return this;
    }
                    } else if ("warmers".equals(currentFieldName)) {
            );
            this.index = indexMetadata.getIndex().getName();
            .append(primaryTermsMap)
    public static final Setting<Integer> INDEX_NUMBER_OF_REPLICAS_SETTING = Setting.intSetting(
            out.writeMap(primaryTermsMap, StreamOutput::writeInt, StreamOutput::writeLong);
        FORMAT_PARAMS = new MapParams(params);
                            + ", "
                            + INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey()
                                    }
            builder.field(KEY_MAPPING_VERSION, indexMetadata.getMappingVersion());
        public byte id() {
    public static final Setting<IngestionErrorStrategy.ErrorStrategy> INGESTION_SOURCE_ERROR_STRATEGY_SETTING = new Setting<>(
                return settings.iterator();
    /**
                    + numSourceShards
        for (final AliasMetadata cursor : aliases.values()) {
 * ownership. Elasticsearch licenses this file to you under
    public static final Setting<Boolean> INDEX_BLOCKS_WRITE_SETTING = APIBlock.WRITE.setting();
    private long[] buildPrimaryTermsArray() {
            public Iterator<Setting<?>> settings() {
        private final long settingsVersion;
            DiffableStringMap custom = DiffableStringMap.readFrom(in);
                }
     */
            boolean binary = params.paramAsBoolean("binary", false);
                                Map<String, Object> mapping = parser.mapOrdered();
            builder.putMapping(mappingMd);
            } else {
            boolean aliasesVersion = false;
    /**
    );
            Settings.writeSettingsToStream(settings, out);
    static Setting<Integer> buildNumberOfShardsSetting() {
        public IngestionStatus getIngestionStatus() {
            return Builder.fromXContent(parser);
                                Set<String> allocationIds = new HashSet<>();
    /**
     * It might still contain date math expressions etc. (added in 5.0)
        return this.state;
            return false;
            }
            for (APIBlock block : APIBlock.values()) {
                builder.endObject();
    public static final ClusterBlock INDEX_METADATA_BLOCK = new ClusterBlock(
                        builder.primaryTermsMap(primaryTermsMap);
        key -> Setting.simpleString(key)
     * @param sourceIndexMetadata the source index metadata
            final DiscoveryNodeFilters includeFilters;
        Settings.Builder builder = Settings.builder().put(settings);
        Property.Final
                        Map<Integer, Long> primaryTermsMap = new HashMap<>();
        return isRemoteSnapshot;
            }
        "index metadata (api)",
        }
import org.opensearch.core.xcontent.XContentBuilder;
    }
        builder.state(State.fromId(in.readByte()));
            final int numberOfReplicas = INDEX_NUMBER_OF_REPLICAS_SETTING.get(settings);
    public boolean isSystem() {
        private long aliasesVersion = 1;
            builder.rolloverInfos.putAll(rolloverInfos.apply(part.rolloverInfos));
    );
        if (!customData.equals(that.customData)) {
    @PublicApi(since = "1.0.0")
            // TODO: add ingestion source params validation
         * per cluster. this also prevents creating stuff like a new index with millions of shards by accident which essentially
        this.waitForActiveShards = waitForActiveShards;
            if (splitMetadata != null) {
            aliasesVersion = after.aliasesVersion;
        int routingNumShards = numSourceShards == 1 ? numTargetShards : sourceIndexMetadata.getRoutingNumShards();
                    + " is set to true"
        Property.IndexScope,
                    final Boolean isRemoteTranslogStoreEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);
            return settings.getAsInt(SETTING_NUMBER_OF_SHARDS, -1);
                            } else if (token == XContentParser.Token.START_ARRAY) {
                                }
                        builder.settingsVersion(parser.longValue());
            return inSyncAllocationIds.get(shardId);
     * a primary shard is assigned after a full cluster restart or a replica shard is promoted to a primary.
        new Setting.Validator<>() {
                tmpSettings,
        Property.IndexScope,
    /**
            return this;
            for (int i = 0; i < numberOfShards; i++) {
                        // TODO: This was removed in 2015. We should throw an exception in OpenSearch 4.0.
    );
     */
     *
        }
    );
                                + " can only be enabled when "
        }
    public static final String SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED = "index.remote_store.auto_restore.enabled";
        }, Property.IndexScope, Property.Final)
    );
            return this;
                DiffableUtils.StringSetValueSerializer.getInstance()
    private final boolean isSystem;
            builder.context(context);
    public static ShardId selectSplitShard(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {
            this.splitShardsMetadata = splitShardsMetadata;
                builder.startArray(KEY_MAPPINGS);
    private final int indexTotalPrimaryShardsPerNodeLimit;
import org.opensearch.index.seqno.SequenceNumbers;
        if (!Objects.equals(context, that.context)) {
        final long aliasesVersion,
     */
            inSyncAllocationIds = DiffableUtils.diff(
        final DiscoveryNodeFilters excludeFilters,
    public int getIndexTotalShardsPerNodeLimit() {
    /**
            Property.UnmodifiableOnRestore
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * and safe physical shard merging operations later in the lifecycle. The number of virtual shards
    public static final Setting<Integer> INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING = Setting.intSetting(
                out.writeMap(primaryTermsMap, StreamOutput::writeInt, StreamOutput::writeLong);
                    }
    public static Builder builder(IndexMetadata indexMetadata) {
     * @return the number of virtual shards or -1
            }
        }
                            "Settings "
    public Set<String> inSyncAllocationIds(int shardId) {
            .append(customData)
    public static final String SETTING_ROUTING_PARTITION_SIZE = "index.routing_partition_size";
    }
        return Builder.fromXContent(parser);
        this.indexCreatedVersion = indexCreatedVersion;
                return settings.iterator();
        }
 * not use this file except in compliance with the License.
                                if (mapping.size() == 1) {
     * translog upload on the acknowledgement path performs a compare-and-swap on a per-shard fence blob in the
                    // Ensure the reset value setting is provided when resetting consumer position.
        Setting.Property.Final
        }
        Property.IndexScope,
     */
     * normal wildcard searches unless explicitly allowed
        Setting.Property.Final
    public static int parseIndexNameCounter(String indexName) {
        } else {
        "index scaled down",
import org.opensearch.indices.pollingingest.IngestionErrorStrategy;
                includeFilters = null;
    public static final Setting<String> INGESTION_SOURCE_TYPE_SETTING = Setting.simpleString(
            return cursor;
                        );
    public static final String SETTING_BLOCKS_READ = APIBlock.READ.settingName();
        public Builder primaryTerm(int shardId, long primaryTerm) {
                                throw new IllegalStateException("found a non-numeric value under [" + KEY_PRIMARY_TERMS + "]");
                            if (token != XContentParser.Token.VALUE_NUMBER) {
    );
    /**
        return context;
                    + "]"
    /**
     *
    public static final String SETTING_CREATION_DATE = "index.creation_date";
                if (numberOfVirtualShards < numberOfShards) {
    public static final Setting<Integer> INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING = Setting.intSetting(
            } else {
                        builder.splitShardsMetadata(SplitShardsMetadata.parse(parser));
                        settingsVersion = true;
        return true;
        7,
                        + "["
        public Builder(String index) {
            @Override
            .append(isSystem)
        Property.IndexScope
        out.writeInt(routingNumShards);
            }
     */
        return indexVersion;
            this.state = state;
    );
            }
        }
            .append(version)
        result = 31 * result + Objects.hashCode(ingestionStatus);
        SETTING_INDEX_UUID,
        for (int i = 0; i < inSyncAllocationIdsSize; i++) {
        RestStatus.FORBIDDEN,
                for (int shardId = 0; shardId < primaryTerms.length; shardId++) {
                return settings.iterator();
    public long getSettingsVersion() {
                indexCreatedVersion,
        }
        this.primaryTermsMap = Collections.unmodifiableMap(primaryTermsMap);
     */
            builder.endObject();
    }
                isAppendOnlyIndex,
                            + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
            throw new IllegalArgumentException("no - separator found in index name [" + indexName + "]");
            }
        int inSyncAllocationIdsSize = in.readVInt();
        SETTING_INGESTION_SOURCE_MAX_POLL_SIZE,
            builder.system(isSystem);
            return false;
        METADATA("metadata", INDEX_METADATA_BLOCK),
     * @opensearch.api
        if (out.getVersion().before(Version.V_3_6_0)) {
        private final Context context;
                            "Setting "
        SEARCH_ONLY("search_only", INDEX_SEARCH_ONLY_BLOCK);
        }
    public static ShardId selectCloneShard(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {
import java.util.function.Function;
        }
                                throw new IllegalArgumentException("Unexpected token: " + token);
                        + "]"
        this.state = state;
            @Override
        SETTING_DATA_PATH,
        false,
                            + numberOfVirtualShards
                }
            out.writeOptionalWriteable(context);
    public boolean equals(Object o) {
            out.writeLong(version);
     * Setting for the payload decoder type.
     * This mode is currently not supported with segment replication.
    );
                final List<Setting<?>> settings = List.of(INDEX_REPLICATION_TYPE_SETTING, INGESTION_SOURCE_TYPE_SETTING);
        return this.isAppendOnlyIndex;
import java.util.List;
            index = after.index.getName();
            this.context = indexMetadata.context;
            }
                    + ") must be the same as the number of"
    static final String KEY_ROLLOVER_INFOS = "rollover_info";
                        builder.mappingVersion(parser.longValue());
    public static final String SETTING_READ_ONLY = APIBlock.READ_ONLY.settingName();
                return settings.iterator();
        builder.mappingVersion(in.readVLong());
        Property.Final
                        + index
        }
     * changes if and index is shrunk.
            throw new IllegalStateException(
        public MappingMetadata mapping() {
        }
                            } else {
            out.writeBoolean(isSystem);
                    filledInSyncAllocationIds.put(i, Collections.unmodifiableSet(new HashSet<>(inSyncAllocationIds.get(i))));
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
                            }
    public static final String SETTING_INDEX_UUID = "index.uuid";
                                + " is set to true"
        1,
            if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
     * isolation from writers (primary shards).  This means they are not primary eligible and do not have any direct communication
                        throw new IllegalArgumentException("Unexpected field for an array " + currentFieldName);
    public static final Setting<Integer> INDEX_PRIORITY_SETTING = Setting.intSetting(
        }
                indexName.substring(numberIndex + 1, indexName.endsWith(">") ? indexName.length() - 1 : indexName.length())
                }
        Builder builder = new Builder(in.readString());
    public Map<String, RolloverInfo> getRolloverInfos() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            aliases.put(aliasMetadata.alias(), aliasMetadata.build());
            public Iterator<Setting<?>> settings() {
        Setting.Property.IndexScope,
            if (in.getVersion().before(Version.V_3_6_0)) {
            final boolean isAppendOnlyIndex = INDEX_APPEND_ONLY_ENABLED_SETTING.exists(settings)
        out.writeMapValues(mappings, (stream, val) -> val.writeVerifiableTo((BufferedChecksumStreamOutput) stream));
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_ENABLED_SETTING);
                            if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {
     */
        }
        final int routingNumShards,
    static final String KEY_ALIASES_VERSION = "aliases_version";
                        throw new IllegalArgumentException(
        return routingPartitionSize != 1;
        if (this == o) {
        return inSyncAllocationIds;
        if (pTerm == null) {
        Property.Dynamic
            this.routingNumShards = indexMetadata.routingNumShards;
     * additional decoder names (e.g. {@code avro}).
    private final Map<String, MappingMetadata> mappings;
                    } else if (KEY_VERSION.equals(currentFieldName)) {
    public static final String KEY_IN_SYNC_ALLOCATIONS = "in_sync_allocations";
        result = 31 * result + Boolean.hashCode(isSystem);
     * Note: since we increment the term every time a shard is assigned, the term for any operational shard (i.e., a shard
    /**
        if (ingestionSourceType != null && !(NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType))) {
     * Return the {@link Version} on which this index has been upgraded. This
        result = 31 * result + mappings.hashCode();
            builder.putAlias(aliasMd);
                if (isResetState(value)) {
        }
            builder.mappings.putAll(mappings.apply(part.mappings));
                    } else if (KEY_SYSTEM.equals(currentFieldName)) {
    public static final Setting.AffixSetting<Object> INGESTION_SOURCE_DECODER_SETTINGS = Setting.prefixKeySetting(
        for (Map.Entry<Integer, Long> entry : primaryTermsMap.entrySet()) {
     * Defines the pointer-based lag update interval for pull-based ingestion.
        result = 31 * result + state.hashCode();
                        builder.primaryTerms(list.stream().mapToLong(i -> i).toArray());
    private final Version indexUpgradedVersion;
            }
        IngestionSource.SourcePartitionStrategy.SIMPLE.getName(),
import org.opensearch.core.xcontent.MediaTypeRegistry;
                                + INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey()
                    );
        public Builder routingPartitionSize(int routingPartitionSize) {
        final DiscoveryNodeFilters initialRecoveryFilters,
        return ingestionSourceType != null && !(NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType));
    public static IndexMetadata readFrom(StreamInput in) throws IOException {
            mappings.clear();
                );
            builder.startObject(indexMetadata.getIndex().getName());
    public Map<String, AliasMetadata> getAliases() {
            public void validate(final String value) {}
                                currentFieldName = parser.currentName();
        new Setting.Validator<>() {
    public static final Setting<Long> SETTING_INDEX_CREATION_DATE = Setting.longSetting(
                return settings.iterator();
    public static final String SETTING_BLOCKS_WRITE = APIBlock.WRITE.settingName();
            mappings.writeTo(out);
        },
            .append(rolloverInfos)
            throw new IllegalArgumentException(
        try {
                    AliasMetadata.Builder.toXContent(cursor, builder, params);
                new Index(index, uuid),
        public Builder numberOfShards(int numberOfShards) {
                        "To enable "
            builder.endObject();
            }
 *
            );
    }
    public static Builder builder(String index) {
    );
        this.splitShardsMetadata = splitShardsMetadata;
        return includeFilters;
         *
        private Integer routingNumShards;
        return waitForActiveShards;
                primaryTermsMapFromArray.put(shardId, primaryTerms[shardId]);
            public Iterator<Setting<?>> settings() {
        1000,
            this.customMetadata.put(type, new DiffableStringMap(customIndexMetadata));
                throw new IllegalArgumentException(
                            + " is not enabled"
            public void validate(final String value) {
            if (INDEX_NUMBER_OF_REPLICAS_SETTING.exists(settings) == false) {
                aliasesVersion,
        return settingsVersion;
    public static final Setting<String> INGESTION_SOURCE_DECODER_TYPE_SETTING = Setting.simpleString(
            indexVersion = SETTING_INDEX_VERSION_CREATED.get(indexSettings);
        "index.write.wait_for_active_shards",
                long[] primaryTermsArray = new long[numShards];
            ZonedDateTime creationDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(creationDate), ZoneOffset.UTC);
                    throw new IllegalArgumentException(
     * Used to specify the type for the ingestion index. If not specified, the ingestion source not enabled
        this.routingFactor = routingNumShards / numberOfShards;
                if (numRoutingShards < numShards) {
     */
    public static final Setting<IngestionMessageMapper.MapperType> INGESTION_SOURCE_MAPPER_TYPE_SETTING = new Setting<>(
        out.writeVInt(aliases.size());
        if (!Objects.equals(splitShardsMetadata, that.splitShardsMetadata)) {
        }
            /*
                    } else if (KEY_PRIMARY_TERMS_MAP.equals(currentFieldName)) {
    private final Version indexCreatedVersion;
                return settings.iterator();
        final int factor;
        }
            final StreamPoller.ResetState pointerInitResetType = StreamPoller.ResetState.valueOf(
        builder.version(in.readLong());
        this.isRemoteSnapshot = IndexModule.Type.REMOTE_SNAPSHOT.match(this.settings);
    /**
import org.opensearch.common.settings.Setting.Property;
        private final Map<String, MappingMetadata> mappings;
        return null;
                }
     * Used to specify remote store repository to use for this index.
        if (numSourceShards != numTargetShards) {
                    MapperService.SINGLE_MAPPING_NAME,
        );
            return block;
                    "routing partition size ["
            inSyncAllocationIds.put(shardId, new HashSet<>(allocationIds));
    @Nullable
    public static final Setting<TimeValue> INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING = Setting.positiveTimeSetting(
     * Defines the number of processor threads that will write to the lucene index.
     * Returns the number of virtual shards for this index.
        key -> new Setting<>(key, "", (value) -> value, Property.IndexScope, Property.Final)
            this.rolloverInfos = new HashMap<>();
            splitShardsMetadata.writeTo(out);
                for (final String cursor : indexMetadata.getAliases().keySet()) {
                );
    }
        Property.Dynamic,
import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;
 * Modifications Copyright OpenSearch Contributors. See
                throw new IllegalStateException(
                builder.field(INGESTION_STATUS_KEY);
    public static final Setting<Integer> INGESTION_SOURCE_POLL_TIMEOUT = Setting.intSetting(
            if (context != Metadata.XContentContext.API) {
        SETTING_INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL,
            AliasMetadata aliasMd = new AliasMetadata(in);
            return this;
        Property.IndexScope
            }
        APIBlock(String name, ClusterBlock block) {
            if (primaryTermsMap.isEmpty()) {
                    + "] must between "
        if (rolloverInfos.equals(that.rolloverInfos) == false) {
            aliases.writeTo(out);
    );
                primaryTerms = in.readVLongArray();
            @Override
                            + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
            Settings tmpSettings = settings;
        private final byte id;
                                builder.putMapping(new MappingMetadata(mappingType, mappingSource));
                "[%s] is not present in the index settings for index with UUID [%s]",
        SETTING_CREATION_DATE,
        this.context = context;
                primaryTermsMap
            return this;
            public void validate(final String value) {}
                throw new IllegalArgumentException("expected field name but got a " + parser.currentToken());
        return builder.build();
    public void writeTo(StreamOutput out) throws IOException {
    public static final String REMOTE_STORE_CUSTOM_KEY = "remote_store";
import org.opensearch.core.index.shard.ShardId;
    public static final String KEY_PRIMARY_TERMS = "primary_terms";
            @Override
        key -> new Setting<>(key, "", (value) -> {
        public Builder setRoutingNumShards(int routingNumShards) {
            .append(", version=")
     * Returns -1 if virtual shards are disabled.
    public int hashCode() {
                requireFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, AND, requireMap);
            @Override
            settings = Settings.builder().put(settings).put(SETTING_CREATION_DATE, creationDate).build();
            out.writeVInt(ordinal());
        Property.NotCopyableOnResize
    public static final String SETTING_INGESTION_SOURCE_ALL_ACTIVE_INGESTION = "index.ingestion_source.all_active";
     * @param sourceIndexMetadata the source index metadata
        public Builder putMapping(String source) throws IOException {
        builder.aliasesVersion(in.readVLong());
                "the number of source shards ["
        Property.Final
            .append(", aliasesVersion=")
            .append(", isSystem=")
        }
            this.mappingVersion = mappingVersion;
            }
            final int numberOfShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
    /**
        SETTING_NUMBER_OF_REPLICAS,
            }
            factor = sourceNumberOfShards / targetNumberOfShards;
            this.rolloverInfos = new HashMap<>(indexMetadata.rolloverInfos);
                excludeFilters = null;
            settingsVersion = in.readVLong();
    }
                            + " is enabled"
        Property.IndexScope,
            @Override
     */
                        builder.version(parser.longValue());
    public static final Setting.AffixSetting<Object> INGESTION_SOURCE_PARAMS_SETTING = Setting.prefixKeySetting(
        Setting.Property.IndexScope
            @Override
            for (int shardId = 0; shardId < primaryTerms.length; shardId++) {
            final String uuid = settings.get(SETTING_INDEX_UUID, INDEX_UUID_NA_VALUE);
        XContentIngestionPayloadDecoder.NAME,
        final Version indexVersion;
     * (e.g., writer node ID) into the remote store path to support clusterless configurations where multiple
     * @throws IllegalArgumentException if the number of source shards is less than the number of target shards or if the source shards
        public IndexMetadata fromXContent(XContentParser parser) throws IOException {
        false,
    );
        -1,
            settingsVersion = after.settingsVersion;
                cursor.toXContent(builder, params);
        return new Builder(indexMetadata);
                final Object replicationType = settings.get(INDEX_REPLICATION_TYPE_SETTING);
        return routingNumShards;
                } else if (token == XContentParser.Token.START_OBJECT) {
    }
        false,
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        public static void toXContent(IndexMetadata indexMetadata, XContentBuilder builder, ToXContent.Params params) throws IOException {
                waitForActiveShards,
     * Used to specify if the index data should be persisted in the remote store.
            return primaryTermsMap.getOrDefault(shardId, SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
        public ClusterBlock getBlock() {
                    + maxNumShards
                builder.endObject();
                }
            settings = Settings.builder().put(settings).put(SETTING_NUMBER_OF_SEARCH_REPLICAS, numberOfSearchReplicas).build();
    @Override
                    if (isRemoteTranslogStoreEnabled == null || isRemoteTranslogStoreEnabled == false) {
        }
            if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
            }
         * @return the provided value or -1 if it has not been set.
        Property.IndexScope,
    public static Diff<IndexMetadata> readDiffFrom(StreamInput in) throws IOException {
     * Returns the source shard ID to split the given target shard off
 */
        0,
        private final Map<String, DiffableStringMap> customMetadata;
                    );
        "index.ingestion_source.decoder_settings.",
                builder.startArray(String.valueOf(cursor.getKey()));
                        + "] for ["
        Version.V_EMPTY,
        Property.Dynamic
                indexSettings.get(IndexMetadata.SETTING_INDEX_UUID),
            @Override
import static org.opensearch.cluster.node.DiscoveryNodeFilters.IP_VALIDATOR;
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        SETTING_INGESTION_SOURCE_POINTER_INIT_RESET,
        final State state,
                builder.endArray();
                        throw new IllegalArgumentException(
                customMetadata,
     */
    }
            aliases = DiffableUtils.diff(before.aliases, after.aliases, DiffableUtils.getStringKeySerializer());
                            if (token == XContentParser.Token.FIELD_NAME) {
                    + "1 and "
     * writers may write to the same shard.
        /**
        final Map<Integer, Long> primaryTermsMap
            final IngestionMessageMapper.MapperType mapperType = INGESTION_SOURCE_MAPPER_TYPE_SETTING.get(settings);
                                throw new IllegalArgumentException("Unexpected token: " + token);
            public Iterator<Setting<?>> settings() {
     */
     */
    /**
        if (!index.equals(that.index)) {
            }
                } else {
     * hashing / routing of documents even if the number of shards changed (ie. a shrunk index).
    /**
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING);
            Property.Final,
    }
        assert sourceIndexMetadata.getNumberOfShards() == 1 // special case - we can split into anything from 1 shard
        Property.IndexScope
        0,
        if (isAppendOnlyIndex == false && bulkAdaptiveShardSelectionEnabled) {
import java.util.concurrent.TimeUnit;
                                + INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING.getKey()
        }
    }
     * to pre-V_3_6_0 nodes.
    /**
        } else {
            return this;
                            }
                throw new IllegalArgumentException("expected object but got a " + token);
        }
        if (creationDate != null) {
                .setSourcePartitionStrategy(sourcePartitionStrategy)
        IngestionErrorStrategy.ErrorStrategy.DROP.name(),
            throw new IllegalArgumentException(message, e);
        },
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        SETTING_INGESTION_SOURCE_NUM_PROCESSOR_THREADS,
        return new Builder(index);
            .append(", inSyncAllocationIds=")
        assertSplitMetadata(numSourceShards, numTargetShards, sourceIndexMetadata);
    static final String KEY_SETTINGS = "settings";
        (errorStrategy) -> {},
                    + " can only be set/enabled when "
    }
                            + ReplicationType.SEGMENT
                    || StreamPoller.ResetState.RESET_BY_TIMESTAMP.name().equalsIgnoreCase(value);
    public static final String SETTING_NUMBER_OF_SEARCH_REPLICAS = "index.number_of_search_replicas";
    public static final Setting<Integer> INDEX_FORMAT_SETTING = Setting.intSetting(
    }
                        + (numberOfReplicas + 1)
        NONE_INGESTION_SOURCE_TYPE,
        private State state = State.OPEN;
    public static final Setting.AffixSetting<String> INDEX_ROUTING_REQUIRE_GROUP_SETTING = Setting.prefixKeySetting(
        this.initialRecoveryFilters = initialRecoveryFilters;
        this.indexUpgradedVersion = indexUpgradedVersion;
                    + "] must be less that the number of target shards ["
    public static final Setting<String> INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING = Setting.simpleString(
        private final Diff<Map<String, RolloverInfo>> rolloverInfos;
                INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING.get(settings),
        public long primaryTerm(int shardId) {
        } catch (NumberFormatException e) {
            return false;
            return true;
            );
        }
            final ActiveShardCount waitForActiveShards = SETTING_WAIT_FOR_ACTIVE_SHARDS.get(settings);
                        final List<Long> list = new ArrayList<>();
    public static IndexMetadata fromXContent(XContentParser parser) throws IOException {
        Property.IndexScope,
    public static final Setting<Long> INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING = Setting.longSetting(
    public static final String NONE_INGESTION_SOURCE_TYPE = "none";
                : IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(settings);
            @Override
        }
        return this.aliases;
                ingestionStatus = IngestionStatus.getDefaultValue();
        }
        new Setting.Validator<>() {
            assert mappingVersion : "mapping version should be present for indices";
            throw new IllegalArgumentException(
            @Override
    );
    public static final String SETTING_REPLICATION_TYPE = "index.replication.type";
                if (isPullBasedIngestionEnabled && ReplicationType.SEGMENT.equals(replicationType) && value) {
        INDEX_FORMAT,
            builder.mappingVersion(mappingVersion);
     */
                SETTING_INDEX_VERSION_CREATED.getKey(),
            .append(aliasesVersion)
     */
     */
                        "Replication type "
         * Returns the number of shards.
        SETTING_INGESTION_SOURCE_WARMUP_LAG_THRESHOLD,
     * Returns the source shard ids to shrink into the given shard id.
        private Map<Integer, Long> primaryTermsMap = new HashMap<>();
                        throw new IllegalArgumentException("Unexpected field [" + currentFieldName + "]");
        out.writeByte(state.id());
                "the number of target shards (" + numTargetShards + ") must be greater than the shard id: " + shardId
                builder.endObject();
            builder.field(KEY_STATE, indexMetadata.getState().toString().toLowerCase(Locale.ENGLISH));
            );
            long[] primaryTerms = null;
                    );
            if (factor * sourceNumberOfShards != targetNumberOfShards || factor <= 1) {
                                    .map();
                    throw new IllegalArgumentException(
            if (primaryTermsMap.isEmpty()) {
        private final Diff<Map<String, DiffableStringMap>> customData;
                    return block;
        // now we verify that the numRoutingShards is valid in the source index
    @Nullable
            out.writeByte(state.id);
            aliases.clear();
            } else if (primaryTermsMap.size() != numberOfShards) {
     * ({@code FenceAutoRestore.tla} refutes the ungated design).
            }
        -1,
                terms[entry.getKey()] = entry.getValue();
    );
     */
            );
        0,
                tmpAliases,
        Property.IndexScope,
            this.settings = settings;
        false,
    }
        EnumSet.of(ClusterBlockLevel.WRITE, ClusterBlockLevel.METADATA_WRITE)
                        + " less than the number of shards ["
    }
                indexMetadata.context.toXContent(builder, params);
     * and {@code op_type_field} settings.
            final IngestionSource.SourcePartitionStrategy sourcePartitionStrategy = INGESTION_SOURCE_PARTITION_STRATEGY_SETTING.get(
        for (int i = 0; i < customSize; i++) {
            if (context != Metadata.XContentContext.API) {
    private final long settingsVersion;
     * information is typically useful for backward compatibility.
                ingestionStatus = null;
        Property.PrivateIndex,
        }
    public static final Setting<AutoExpandSearchReplicas> INDEX_AUTO_EXPAND_SEARCH_REPLICAS_SETTING = AutoExpandSearchReplicas.SETTING;
     * migration never touches the fence, so it could not be fenced by it. Enable only on indices that are
            .append(", customData=")
            final Map<String, Object> decoderSettings = INGESTION_SOURCE_DECODER_SETTINGS.getAsMap(settings);
 * compatible open source license.
    public static final Setting<ActiveShardCount> SETTING_WAIT_FOR_ACTIVE_SHARDS = new Setting<>(
        "",
        EnumSet.of(ClusterBlockLevel.READ)
    public static final String SETTING_INGESTION_SOURCE_ERROR_STRATEGY = "index.ingestion_source.error_strategy";
                mappings.put(mappingMd.type(), mappingMd);
        }
                filledInSyncAllocationIds,
            builder.state(state);
            final long maxPollSize = INGESTION_SOURCE_MAX_POLL_SIZE.get(settings);
        return builder;
        Property.IndexScope
                    }
        }
                if (mmd != null) {
                }
     * that can be indexed into) is larger than 0. See {@link IndexMetadataUpdater#applyChanges}.
/*
import org.opensearch.indices.pollingingest.StreamPoller;
        INDEX_SEARCH_ONLY_BLOCK_ID,
                    } else if (KEY_ROLLOVER_INFOS.equals(currentFieldName)) {
        }
                            }
        }
            splitMetadata = after.splitShardsMetadata.diff(before.splitShardsMetadata);
            assert primaryTerms != null;
        return Setting.intSetting(
        return this.bulkAdaptiveShardSelectionEnabled;
        @Override
                        "To enable "
import java.util.Iterator;
    private final boolean bulkAdaptiveShardSelectionEnabled;
    public long primaryTerm(int shardId) {
     * @opensearch.internal
        }
                } else {
            builder.setRoutingNumShards(routingNumShards);
    // Block ID and block for scale operations (IDs 20-29 reserved for scaling)
            this.mappings = new HashMap<>();
        builder.settingsVersion(in.readVLong());
        }
    @PublicApi(since = "1.0.0")
                        // the type name is the root value, reduce it
            assert aliasesVersion : "aliases version should be present for indices";
        }
        }
                indexTotalRemoteCapableShardsPerNodeLimit,
        INDEX_UUID_NA_VALUE,
            builder.endObject();
            return false;
                        }
        TimeValue.timeValueMillis(-1),
            }
     * Defines the maximum time to wait for lag to catch up during warmup phase.
     *
            return new IndexMetadata(
                    + numSourceShards
        writeSettingsToStream(settings, out);
        out.writeVLong(aliasesVersion);
        StreamPoller.ResetState.LATEST.name(),
            final int indexTotalRemoteCapablePrimaryShardsPerNodeLimit =
        return mappingVersion;
            } else {
                            if (token != XContentParser.Token.FIELD_NAME) {
            if (primaryTermsMap.isEmpty()) {
                indexTotalRemoteCapablePrimaryShardsPerNodeLimit,
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
            rolloverInfos = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), ROLLOVER_INFO_DIFF_VALUE_READER);
        public String settingName() {
            @Override
                } else {
                builder.map(cursor.getValue());
        final String ingestionSourceType = INGESTION_SOURCE_TYPE_SETTING.get(settings);
        SETTING_INGESTION_SOURCE_ALL_ACTIVE_INGESTION,
            throw new IllegalStateException("No state match for [" + state + "]");
        }
            this.mappings = new HashMap<>(indexMetadata.mappings);
            builder.settings(settings);
            // fill missing slots in inSyncAllocationIds with empty set if needed and make all entries immutable
                                    .put(mappingType, parser.mapOrdered())
                                + " can only be set when "
            if (routingPartitionSize != 1 && routingPartitionSize >= getRoutingNumShards()) {
            this.isSystem = indexMetadata.isSystem;
        return aliasesVersion;
                    if (KEY_STATE.equals(currentFieldName)) {
                    );
            @Override
            return this;
     **/
            Map<String, String> initialRecoveryMap = INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING.getAsMap(settings);
        this.settingsVersion = settingsVersion;
        },
            final int indexTotalShardsPerNodeLimit = ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.get(settings);
        Property.Final
    }
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
                }
                    + "] is not append-only index, "
            throw new IllegalArgumentException(
    }
        },
        false,
                    + defaultNumShards
                if (token == XContentParser.Token.FIELD_NAME) {
            public void validate(final String value) {
        final long mappingVersion,
        this.numberOfSearchOnlyReplicas = numberOfSearchOnlyReplicas;
    private final Map<Integer, Set<String>> inSyncAllocationIds;
     * must be a multiple of the number of physical shards {@code (V % P == 0)}.
        public static State fromString(String state) {
        boolean isAppendOnlyIndex,
                if (inSyncAllocationIds.containsKey(i)) {
                                throw new IllegalArgumentException("Unexpected token: " + token);
        }
            builder.primaryTermsMap(in.readMap(StreamInput::readInt, StreamInput::readLong));
        public long version() {
            builder.put(SETTING_VERSION_UPGRADED_STRING, versionUpgraded.toString());
                    if (fencingEnabled == null || fencingEnabled == false) {
     */
        private void initializePrimaryTerms() {
                    builder.field(mmd.type());
    public int getTotalNumberOfShards() {
            out.writeVLong(mappingVersion);
    @Nullable
    /**
        }
        "index read-only (api)",
        }
            }
        // 1 to N but we never modify the sourceIndexMetadata to accommodate for that
    public static final Setting<Version> SETTING_INDEX_VERSION_CREATED = Setting.versionSetting(
            throw new IllegalArgumentException(
