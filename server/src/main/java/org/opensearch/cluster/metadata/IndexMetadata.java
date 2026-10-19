                                currentFieldName = parser.currentName();  
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_PARAM;  
        private final Settings settings;
                    builder.field(mmd.type());
        Setting.Property.Final  
            return false;  
    );
        assert otherUUID != null;
            .append(splitShardsMetadata)
            }
            @Override
            return this;  
            isSystem = after.isSystem;  
            }
                    }
        @Override  
                }
             */
     * with their primary.  Search replicas require the use of Segment Replication on the index and poll their {@link SegmentReplicationSource} for  
     * @param sourceNumberOfShards the total number of shards in the source index
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
        },
        for (final AliasMetadata cursor : aliases.values()) {  
                final List<Setting<?>> settings = List.of(INDEX_REMOTE_STORE_ENABLED_SETTING);
        false,
                            } else {  
     * For example, the {@code field_mapping} mapper type uses {@code id_field}, {@code version_field},
            }
                parser.nextToken();
        if (isSystem != that.isSystem) {
            .append(version)
        return initialRecoveryFilters;
        Property.Dynamic,  
                    + " is set to true"
        false,  
     * Defines the internal blocking queue size that is used to decouple poller and processor in pull-based ingestion.  
                    final String resetValue = (String) settings.get(INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING);  
        Property.Dynamic
     * @opensearch.api
        final int numberOfShards,
                } else if (token == XContentParser.Token.START_OBJECT) {
            builder.version(version);
    );  
                                Map<String, Object> mappingSource = MapBuilder.<String, Object>newMapBuilder()
        result = 31 * result + Objects.hashCode(ingestionStatus);  
            return this;
     */
    );  
    public enum State {
import java.util.Collections;
    public static final Setting<Integer> INGESTION_SOURCE_POLL_TIMEOUT = Setting.intSetting(  
    public static final Setting<Boolean> INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING = Setting.boolSetting(  
            }  
             * We expect that the metadata has been properly built to set the number of shards and the number of replicas, and do not rely  
    static final String DEFAULT_NUMBER_OF_SHARDS = "opensearch.index.default_number_of_shards";
                        + (numberOfReplicas + 1)
    }
     * to shards based on their ID or their specific routing value. The default value is {@link #getNumberOfShards()}. This value only
     * Returns -1 if virtual shards are disabled.
    public static final Setting<Integer> INDEX_FORMAT_SETTING = Setting.intSetting(
    /**
        key -> new Setting<>(key, "", (value) -> value, Property.IndexScope, Property.Final)
        }
            for (int shard = 0; shard < primaryTerms.length; shard++) {  
 * Licensed to Elasticsearch under one or more contributor  
                        // throw new IllegalArgumentException("Warmers are not supported anymore");  
        return new ShardId(sourceIndexMetadata.getIndex(), shardId);
        }  
     * "simple" (default): 1:1 mapping where shard N consumes partition N.
            @Override
    }
        private static final DiffableUtils.DiffableValueReader<String, RolloverInfo> ROLLOVER_INFO_DIFF_VALUE_READER =
        public IndexMetadata apply(IndexMetadata part) {
                }  
                splitMetadata = SplitShardsMetadata.readDiffFrom(in);  
    }
                initialRecoveryFilters,
                            + "]"
    public static IndexMetadata readFrom(StreamInput in) throws IOException {
                assert primaryTerms != null;  
        }
                        }
            customData = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), CUSTOM_DIFF_VALUE_READER);
            builder.put(SETTING_VERSION_UPGRADED_STRING, versionUpgraded.toString());
                    AliasMetadata.Builder.toXContent(cursor, builder, params);
        TimeValue.timeValueMillis(-1),  
            builder.settings(settings);
    public static final Setting<Boolean> INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING = Setting.boolSetting(  
     * @param numTargetShards     the total number of shards in the target index
             * on the default values here. Those must have been set upstream.
            return false;  
            splitMetadata = after.splitShardsMetadata.diff(before.splitShardsMetadata);  
            if (entry.getKey() < numberOfShards) {
                } else if (token == XContentParser.Token.START_ARRAY) {  
    /**
            builder.primaryTermsMap(primaryTermsMap);
                            + "]"  
                    if (KEY_STATE.equals(currentFieldName)) {  
            this.mappingVersion = mappingVersion;
                        }  
                new Index(index, uuid),
        if (!mappings.equals(that.mappings)) {
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        final int indexTotalPrimaryShardsPerNodeLimit,
        Property.IndexScope
                        "To enable "
                        throw new IllegalArgumentException(
        }
                            + index
        Property.Final
                DiffableUtils.getVIntKeySerializer(),
            return true;
import org.opensearch.indices.pollingingest.StreamPoller;
     * @return the routing factor for and shrunk index with the given number of target shards.
    public enum APIBlock implements Writeable {
    public static final Setting<Integer> INDEX_NUMBER_OF_REPLICAS_SETTING = Setting.intSetting(  
            }  
        final Map<String, AliasMetadata> aliases,
        }
                            + " is not enabled"
                context,
        }
    public static final Setting<AutoExpandReplicas> INDEX_AUTO_EXPAND_REPLICAS_SETTING = AutoExpandReplicas.SETTING;
        return routingNumShards;  
    private final int numberOfReplicas;
                "[%s] is not present in the index settings for index with UUID [%s]",
        NONE_INGESTION_SOURCE_TYPE,
    public static Version indexCreated(final Settings indexSettings) {
    public Diff<IndexMetadata> diff(IndexMetadata previousState) {  
            builder.putCustom(key, custom);
    public static final String SETTING_HISTORY_UUID = "index.history.uuid";
                .setMaxPollSize(maxPollSize)
     * Settings for configuring the number of virtual shards on an index.
                            + numberOfShards  
                    );  
                                Map<String, Object> mapping = parser.mapOrdered();  
            for (APIBlock block : APIBlock.values()) {
            }
                DiffableUtils.StringSetValueSerializer.getInstance()
    public Map<String, AliasMetadata> getAliases() {  
     */  
    public static final String SETTING_INDEX_UUID = "index.uuid";
                    } else {
        /**  
                        builder.value(mmd.source().compressed());
        private final Map<String, DiffableStringMap> customMetadata;
     * updates.  //TODO: Once physical isolation is introduced, reference the setting here.
    static final String KEY_SETTINGS = "settings";  
        final DiscoveryNodeFilters excludeFilters,
        Property.Dynamic
            @Override  
                indexName.substring(numberIndex + 1, indexName.endsWith(">") ? indexName.length() - 1 : indexName.length())
                                + " should be set when resetting consumer position"
        this.mappingVersion = mappingVersion;
            builder.endObject();
        if (isRemoteSegmentStoreEnabled == false) {
                MappingMetadata mmd = indexMetadata.mapping();
 *
        }
    public static class Builder {
            builder.system(isSystem);
    public static final String SETTING_INGESTION_SOURCE_NUM_PROCESSOR_THREADS = "index.ingestion_source.num_processor_threads";
    );
    );  
import org.opensearch.core.xcontent.ToXContentFragment;
        final String name;  
    /**
        }
                    // Validate that the path prefix doesn't contain invalid characters for file paths
            @Override  
        final int routingFactor = getRoutingFactor(numSourceShards, numTargetShards);  
        0,
    private final Settings settings;
     * Defines the setting for the value to be used when resetting by offset or timestamp.  
        private final Diff<Map<String, AliasMetadata>> aliases;
            return false;  
     */  
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        final String settingName;
        INDEX_ROUTING_INCLUDE_GROUP_PREFIX + ".",
        false,
            }
    public static Set<ShardId> selectShrinkShards(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {  
                filledInSyncAllocationIds,
        false,
        Property.IndexScope
        IngestionErrorStrategy.ErrorStrategy::parseFromString,
            out.writeOptionalWriteable(context);  
    public static final String SETTING_REMOTE_STORE_FENCING_ENABLED = "index.remote_store.fencing.enabled";
        }
        Property.IndexScope,
                                currentFieldName = parser.currentName();
                    primaryTermsMap.put(i, SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
        }
        }  
    /**
                    + "which is not supported. Please disable bulk adaptive shard selection or set index to append-only index."
    /**  
            builder.startObject(KEY_SETTINGS);
    public int hashCode() {  
                    currentFieldName = parser.currentName();  
    /**
        }  
                            if (token == XContentParser.Token.VALUE_NUMBER) {
        SETTING_INDEX_UUID,
    /**  
import java.time.ZoneOffset;
        if (ingestionSourceType != null && !(NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType))) {
                "Settings "  
            throw new IllegalStateException(message);
        12,
        assert shardId >= 0 && shardId < numberOfShards;
    );
        }
                    if (binary) {
        WRITE("write", INDEX_WRITE_BLOCK),
            assert settingsVersion : "settings version should be present for indices";
                }
                int numShards = (int) settings.get(INDEX_NUMBER_OF_SHARDS_SETTING);  
        Property.NotCopyableOnResize
    public static final String KEY_IN_SYNC_ALLOCATIONS = "in_sync_allocations";  
        SETTING_REPLICATION_TYPE,
        Property.Final
                }
     * (e.g., writer node ID) into the remote store path to support clusterless configurations where multiple
        for (Map.Entry<Integer, Long> entry : primaryTermsMap.entrySet()) {
        SETTING_ROUTING_PARTITION_SIZE,
            } else {
         * Sets the number of shards that should be used for routing. This should only be used if the number of shards in
            builder.endObject();
            final String pointerInitResetValue = INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING.get(settings);  
            @Override  
    /**
    private final long version;  
        METADATA("metadata", INDEX_METADATA_BLOCK),
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_ENABLED_SETTING);
     *
        }  
        // this is important to special case here since we use this to validate this in various places in the code but allow to split form
        int customSize = in.readVInt();  
            .append(aliases)
            throw new IllegalStateException("No state match for [" + state + "]");
        if (sourceNumberOfShards < targetNumberOfShards) { // split
            final int indexTotalRemoteCapableShardsPerNodeLimit =
                    throw new IllegalArgumentException(
     * Used to enable object-store-backed primary fencing for remote-store-backed indices. When enabled, every
        Setting.Property.Dynamic,  
                            if (token != XContentParser.Token.FIELD_NAME) {  
        if (numberIndex == -1) {
                        "Invalid value for " + SETTING_INGESTION_SOURCE_POINTER_INIT_RESET + " [" + value + "]"  
import java.time.ZonedDateTime;
        SETTING_INGESTION_SOURCE_NUM_PROCESSOR_THREADS,
    }  
        final DiscoveryNodeFilters includeFilters,  
            }
                }  
        return this.customData;  
    public static final String INDEX_ROUTING_EXCLUDE_GROUP_PREFIX = "index.routing.allocation.exclude";
    }
                            }
            new DiffableUtils.DiffableValueReader<>(RolloverInfo::new, RolloverInfo::readDiffFrom);
        return new Builder(indexMetadata);
                    }
        Property.IndexScope,
     * - For "&lt;logs-{now/d}-3&gt;" it'll return 3
                return CLOSE;
        final int numberOfSearchOnlyReplicas,
                DEFAULT_NUMBER_OF_SHARDS  
    );
                }
        new Setting.Validator<>() {  
            return this;
            if (indexMetadata.splitShardsMetadata != null) {
            .append(", ingestionStatus=")
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
                    "the number of source shards [" + sourceNumberOfShards + "] must be a " + "multiple of [" + targetNumberOfShards + "]"  
            .append(settings)  
        final Index index,
        out.writeVInt(inSyncAllocationIds.size());
                            primaryTermsMap.put(shard, parser.longValue());
                                + " membership while the departed primary may still be alive, and only the fence"
            return this;  
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Nullable  
        builder.aliasesVersion(in.readVLong());  
        }
                        }  
                ingestionStatus,
                                + SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED  
            out.writeVLong(aliasesVersion);
            this.index = index;  
        private Context context;
    /**
import org.opensearch.index.seqno.SequenceNumbers;  
            final DiscoveryNodeFilters initialRecoveryFilters;
        }
            );
        this.version = version;  
        return pTerm;
                return settings.iterator();  
        }
        public Builder setRoutingNumShards(int routingNumShards) {
     * Whether the index is considered hidden or not. A hidden index will not be resolved in
        }  
     */  
            inSyncAllocationIds.writeTo(out);  
    public static Set<ShardId> selectRecoverFromShards(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {  
                ingestionStatus = null;
                            + " should be provided with non-empty repository ID"
                                    if (token == XContentParser.Token.VALUE_STRING) {  
        Setting.Property.Final  
        }
        return isSystem;
                builder.endObject();  
                numberOfSearchReplicas,  
import org.opensearch.common.collect.MapBuilder;
            .append(", mappingVersion=")  
            out.writeVInt(cursor.getKey());
        final Version indexVersion;  
     */  
            builder.put(SETTING_CREATION_DATE_STRING, creationDateTime.toString());
        return context;
        return this.aliases;
            Set<String> allocationIds = DiffableUtils.StringSetValueSerializer.getInstance().read(in, key);  
        new Setting.Validator<>() {
            Builder builder = new Builder(parser.currentName());  
        return ingestionStatus;
                    + setting.getKey()
                            + ", "
    public static final String SETTING_INDEX_PROVIDED_NAME = "index.provided_name";  
    /**  
        new Setting.Validator<>() {  
        /**
    /**
        }
                            + " is not supported in pull-based ingestion when "
            return false;  
            builder.endObject();
 * The OpenSearch Contributors require contributions made to  
        }  
        return totalNumberOfShards;  
 * ownership. Elasticsearch licenses this file to you under  
    public static final String KEY_PRIMARY_TERMS = "primary_terms";
                if (isResetState(value)) {
        this.aliases = Collections.unmodifiableMap(aliases);
                        );
        // this is just an additional assertion that ensures we are a factor of the routing num shards.  
        }  
     * physical shards instead of default modulo hashing. This ensures contiguous bucket mapping
                for (int i = 0; i < numberOfShards; i++) {  
    );  
                        builder.primaryTermsMap(primaryTermsMap);
            }  
                        throw new IllegalArgumentException(
        Property.PrivateIndex,  
    public static final String SETTING_INGESTION_SOURCE_TYPE = "index.ingestion_source.type";  
            mappingVersion = after.mappingVersion;
                if (isPullBasedIngestionEnabled && ReplicationType.SEGMENT.equals(replicationType) && value) {  
                                + " can only be set/enabled when "
package org.opensearch.cluster.metadata;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final String SETTING_AUTO_EXPAND_REPLICAS = "index.auto_expand_replicas";
     * @return a the source shard ID to split off from  
            XContentParser.Token token = parser.nextToken();  
                return settings.iterator();  
    static final String KEY_ROUTING_NUM_SHARDS = "routing_num_shards";
        SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED,
                mappingVersion,  
    public int getNumberOfSearchOnlyReplicas() {
        private long version = 1;  
        if (!settings.equals(that.settings)) {
        final String ingestionSourceType = INGESTION_SOURCE_TYPE_SETTING.get(settings);
                pointerInitResetValue  
            return this;
                    "primaryTerms length is ["
                        "number of virtual shards ["
    public static final String INDEX_RESIZE_SOURCE_UUID_KEY = "index.resize.source.uuid";  
        Property.IndexScope,
            @Override  
        }  
     */
    public static final String SETTING_CREATION_DATE_STRING = "index.creation_date_string";  
        final int routingPartitionSize,
        }
                        mapping = (Map<String, Object>) mapping.get(mmd.type());  
     * This controls how frequently the lag between the latest available message and the last consumed message is calculated.
    }
     * The term of the current selected primary. This is a non-negative number incremented when  
    /**
        true,
    public static final ClusterBlock INDEX_READ_BLOCK = new ClusterBlock(  
                .setDecoderSettings(decoderSettings)
    public static final String INDEX_RESIZE_SOURCE_NAME_KEY = "index.resize.source.name";
            }  
            @Override  
    public static final String KEY_PRIMARY_TERMS_MAP = "primary_terms_map";
                    } else {
                            } else {
    public boolean isSystem() {  
            out.writeMap(primaryTermsMap, StreamOutput::writeInt, StreamOutput::writeLong);
        Property.UnmodifiableOnRestore  
                terms[entry.getKey()] = entry.getValue();  
        public Builder settings(Settings.Builder settings) {
        return rolloverInfos;  
     *
            this.context = context;
    public String toString() {
    }
                    validateRemoteStoreSettingEnabled(settings, INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING);
        private final long aliasesVersion;  
        Property.Final
                out.writeOptionalWriteable(ingestionStatus);
                                throw new IllegalArgumentException("Unexpected token: " + token);  
        if (out.getVersion().onOrAfter(Version.V_3_6_0)) {  
        assert aliasesVersion >= 0 : aliasesVersion;
                final List<Setting<?>> settings = List.of(INDEX_REPLICATION_TYPE_SETTING);
            }  
        return this.indexTotalRemoteCapablePrimaryShardsPerNodeLimit;
     * - For ".ds-logs-000002" it will return 2  
                if (mmd != null) {  
     * Used to specify if the index data should be persisted in the remote store.
    public long getAliasesVersion() {
     * Defines the poll timeout for pull-based ingestion in milliseconds.  
    /**
            }
            throw new IllegalArgumentException("unable to parse the index name [" + indexName + "] to extract the counter", e);
    public static final Setting<Integer> INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING = Setting.intSetting(  
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalStateException("No state match for id [" + id + "]");
            }
                    builder.map(mapping);  
            builder.settingsVersion(settingsVersion);  
                        + "]: cannot be greater than "
                .setErrorStrategy(errorStrategy)  
            public void validate(final String value) {}  
            final DiscoveryNodeFilters requireFilters;
    }
        }  
        this.rolloverInfos = Collections.unmodifiableMap(rolloverInfos);
     * translog upload on the acknowledgement path performs a compare-and-swap on a per-shard fence blob in the  
                            }
            splitShardsMetadata.writeTo(out);
    public static final String SETTING_NUMBER_OF_SEARCH_REPLICAS = "index.number_of_search_replicas";  
    public static final Setting<Integer> INDEX_NUMBER_OF_SHARDS_SETTING = buildNumberOfShardsSetting();  
                throw new IllegalArgumentException("must specify number of replicas for index [" + index + "]");
                            + numberOfShards
    private final long settingsVersion;
        },  
    /**
            }
        out.writeMapValues(mappings, (stream, val) -> val.writeVerifiableTo((BufferedChecksumStreamOutput) stream));
     * @param shardId             the id of the target shard to shrink to
            if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {  
    public static final Setting<IngestionSource.SourcePartitionStrategy> INGESTION_SOURCE_PARTITION_STRATEGY_SETTING = new Setting<>(
     *  
            final int numberOfShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);  
    public static final Setting.AffixSetting<String> INDEX_ROUTING_INCLUDE_GROUP_SETTING = Setting.prefixKeySetting(  
            public void validate(final String value) {
                }
                        builder.splitShardsMetadata(SplitShardsMetadata.parse(parser));
                                list.add(parser.longValue());
            if (excludeMap.isEmpty()) {
                initialRecoveryFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, OR, initialRecoveryMap);  
     */  
    }  
        IngestionSource.SourcePartitionStrategy::fromString,
    public static final Setting.AffixSetting<Object> INGESTION_SOURCE_DECODER_SETTINGS = Setting.prefixKeySetting(  
                            + " is enabled"  
                    }
        out.writeVLong(mappingVersion);
            inSyncAllocationIds = DiffableUtils.diff(
            new DiffableUtils.DiffableValueReader<>(DiffableStringMap::readFrom, DiffableStringMap::readDiffFrom);  
                        }  
        public Builder putRolloverInfo(RolloverInfo rolloverInfo) {
                // TODO: validate this with the registered types in the ingestion source plugin  
                .setAllActiveIngestion(allActiveIngestionEnabled)
        Property.Dynamic
        );
            out.writeBoolean(isSystem);
            final DiscoveryNodeFilters includeFilters;  
        READ_ONLY_ALLOW_DELETE("read_only_allow_delete", INDEX_READ_ONLY_ALLOW_DELETE_BLOCK),  
            .append(", index=")
    public static final Setting<String> INGESTION_SOURCE_POINTER_INIT_RESET_SETTING = Setting.simpleString(  
    /**
        out.writeByte(state.id());
        if (!index.equals(that.index)) {
            return this;  
            this.id = id;  
        return excludeFilters;
     * @param shardId             the id of the target shard to clone into
            Settings.writeSettingsToStream(settings, out);
        Setting.Property.Final
        public Builder putMapping(MappingMetadata mappingMd) {
        return INDEX_RESIZE_SOURCE_UUID.exists(settings)  
/*  
    }  
    }  
        Property.Dynamic
 *  
            return routingNumShards == null ? numberOfShards() : routingNumShards;  
    private IndexMetadata(
                requireFilters,  
        final int defaultNumShards = Integer.parseInt(System.getProperty(DEFAULT_NUMBER_OF_SHARDS, "1"));  
        INDEX_SEARCH_ONLY_BLOCK_ID,
                        "Setting " + INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey() + " should be provided with non-empty repository ID"
            out.writeString(cursor.getKey());
                settingsVersion,
                            "Setting "  
                        builder.version(parser.longValue());  
            (stream, val) -> DiffableUtils.StringSetValueSerializer.getInstance().write(new TreeSet<>(val), stream)
     */
        new Setting.Validator<>() {  
            public Iterator<Setting<?>> settings() {  
                    + numTargetShards
                        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            public Iterator<Setting<?>> settings() {
    public int getRoutingPartitionSize() {  
        }
            return settingName;
        INDEX_ROUTING_REQUIRE_GROUP_PREFIX + ".",  
        return index;  
                out.writeVLongArray(primaryTermsArray);
            final StreamPoller.ResetState pointerInitResetType = StreamPoller.ResetState.valueOf(  
    public static final String SETTING_VERSION_UPGRADED = "index.version.upgraded";
                    } else if (KEY_IN_SYNC_ALLOCATIONS.equals(currentFieldName)) {
                        + "["  
     */
/**
        return INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings);  
        this.inSyncAllocationIds = Collections.unmodifiableMap(inSyncAllocationIds);  
                .setDecoderType(decoderType)  
                indexMetadata.ingestionStatus.toXContent(builder, params);
        Property.IndexScope
        return this.bulkAdaptiveShardSelectionEnabled;  
                    final Boolean isRemoteTranslogStoreEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);
            Builder.toXContent(state, builder, FORMAT_PARAMS);
            builder.startObject(KEY_ROLLOVER_INFOS);
        Property.Final
    public long getCreationDate() {  
     * migration never touches the fence, so it could not be fenced by it. Enable only on indices that are  
     * Used to enable automatic restore of a remote-store-backed primary whose last copy was lost with the node that
            for (final RolloverInfo cursor : indexMetadata.getRolloverInfos().values()) {
            rolloverInfos = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), ROLLOVER_INFO_DIFF_VALUE_READER);
        false,
        }
                    + " can only be set/enabled when "
     * a primary shard is assigned after a full cluster restart or a replica shard is promoted to a primary.
     * The number of active shard copies to check for before proceeding with a write operation.
                }
import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;  
     * additional decoder names (e.g. {@code avro}).  
                builder.endObject();
        } else if (sourceNumberOfShards > targetNumberOfShards) { // shrink
                                }  
        0,
                } else {
                return settings.iterator();  
            if (context != Metadata.XContentContext.API) {
                                builder.putMapping(new MappingMetadata(new CompressedXContent(parser.binaryValue())));
                    throw new IllegalArgumentException(
    public static final String CONTEXT_KEY = "context";  
                throw new IllegalArgumentException(  
    );
                .setMapperType(mapperType)
            return false;  
            builder.startObject(indexMetadata.getIndex().getName());
    public static final Setting<String> INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING = Setting.simpleString(  
    public static final Setting<Integer> INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING = Setting.intSetting(
                indexTotalPrimaryShardsPerNodeLimit,  
        this.state = state;  
            private boolean isResetState(String value) {
        }
                "the number of target shards (" + numTargetShards + ") must be greater than the shard id: " + shardId  
                out.writeMap(primaryTermsMap, StreamOutput::writeInt, StreamOutput::writeLong);  
 * You may obtain a copy of the License at  
            public void validate(final Boolean value) {}  
        this.isAppendOnlyIndex = isAppendOnlyIndex;  
            }  
            this.index = indexMetadata.getIndex().getName();
            Property.IndexScope,
        public SplitShardsMetadata getSplitShardsMetadata() {  
            @Override
    private final int routingNumShards;  
                    throw new IllegalArgumentException("Unexpected token " + token);  
            1,
import org.opensearch.common.Nullable;  
                "index ["
     * Adds human readable version and creation date settings.  
            public Iterator<Setting<?>> settings() {
    /**  
        if (!aliases.equals(that.aliases)) {
            return false;  
            @Override
         */
                Locale.ROOT,  
    public static final Setting<Boolean> INDEX_BLOCKS_SEARCH_ONLY_SETTING = APIBlock.SEARCH_ONLY.setting();
        this.settingsVersion = settingsVersion;
        SETTING_INGESTION_SOURCE_ALL_ACTIVE_INGESTION,
                return settings.iterator();  
    public static final String SETTING_INGESTION_SOURCE_POLL_TIMEOUT = "index.ingestion_source.poll.timeout";
            }
        return builder;  
                    throw new IllegalArgumentException(
                    );
    public static final Setting<Long> INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING = Setting.longSetting(
            builder.field(KEY_VERSION, indexMetadata.getVersion());  
                        + " less than the number of shards ["  
    public static final Setting<Version> SETTING_INDEX_VERSION_CREATED = Setting.versionSetting(
            this.isSystem = false;  
        if (out.getVersion().before(Version.V_3_6_0)) {
            builder.putAlias(aliasMd);
    public static final String SETTING_INGESTION_SOURCE_POINTER_INIT_RESET_VALUE = "index.ingestion_source.pointer.init.reset.value";
    }  
                            if (token == XContentParser.Token.FIELD_NAME) {  
                initializePrimaryTerms();  
                settings
            settings = Settings.builder().put(settings).put(SETTING_NUMBER_OF_SHARDS, numberOfShards).build();  
        private long aliasesVersion = 1;  
    public static final Setting<IngestionMessageMapper.MapperType> INGESTION_SOURCE_MAPPER_TYPE_SETTING = new Setting<>(  
        }
            this.routingNumShards = routingNumShards;  
    public static final Setting<Boolean> INDEX_READ_ONLY_SETTING = APIBlock.READ_ONLY.setting();
     * Used to specify if the bulk should use adaptive shard selection to select one shard.
        public void writeTo(StreamOutput out) throws IOException {
                            + " should be set to "  
        1,
                                    }
                    }
        private static final DiffableUtils.DiffableValueReader<String, MappingMetadata> MAPPING_DIFF_VALUE_READER =  
 */
    public static final String SETTING_INGESTION_SOURCE_MAPPER_TYPE = "index.ingestion_source.mapper_type";
    public ActiveShardCount getWaitForActiveShards() {
     * @param sourceIndexMetadata the source index metadata  
            Builder builder = builder(index);  
                throw new IllegalStateException(
        SETTING_INGESTION_SOURCE_WARMUP_TIMEOUT,
            );
            .append("}")
        private void primaryTermsMap(Map<Integer, Long> primaryTermsMap) {
            }  
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.IndexScope)  
        public Builder removeAlias(String alias) {  
            }
     * to an active shard count of 1 if not specified.
                builder.endArray();
        final Version indexCreatedVersion,
            return false;  
            public void validate(final ReplicationType value, final Map<Setting<?>, Object> settings) {
        -1,
        }
            final TimeValue pointerBasedLagUpdateInterval = INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING.get(settings);
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.OR;  
    public static final Setting<ActiveShardCount> SETTING_WAIT_FOR_ACTIVE_SHARDS = new Setting<>(
     * Setting to control the number of search only replicas for an index.  
            .append(aliasesVersion)  
            @Override  
     * A value of -1 means warmup is disabled (the default). A value >= 0 enables warmup with that timeout.
            if (context != Metadata.XContentContext.API) {
    private final long aliasesVersion;  
        }
                builder.startObject(KEY_MAPPINGS);  
        builder.setRoutingNumShards(in.readInt());
        SETTING_INGESTION_SOURCE_POLL_TIMEOUT,
                    + "]"
            return false;  
     * @see #getRoutingFactor(int, int) for details  
     * Return the {@link Version} on which this index has been upgraded. This
     * Return the concrete mapping for this index or {@code null} if this index has no mappings at all.
            splitShardsMetadata.writeTo(out);
            }
            if (ingestionStatus == null) {
    private final int indexTotalShardsPerNodeLimit;
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
                .setPollTimeout(pollTimeout)
        final DiscoveryNodeFilters initialRecoveryFilters,
        Property.Dynamic
    }
                builder.startArray(KEY_ALIASES);
            if (out.getVersion().before(Version.V_3_6_0)) {
     * {@code index.ingestion_source.decoder_settings.schema_registry_url: https://...}
         */  
        }
            }
            // TODO: support ingestion source
     */
        },
        StreamPoller.ResetState.LATEST.name(),
        Property.Final
import org.opensearch.gateway.MetadataStateFormat;
            return context;
    public static final Setting<String> INDEX_RESIZE_SOURCE_UUID = Setting.simpleString(INDEX_RESIZE_SOURCE_UUID_KEY);
        Property.Dynamic,
            aliases = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), ALIAS_METADATA_DIFF_VALUE_READER);  
        false,
                return OPEN;  
                this.primaryTermsMap = primaryTermsMap;  
                if (block.name.equals(name)) {
        }
    /**  
            );
            @Override
        Property.IndexScope,
            public Iterator<Setting<?>> settings() {
        1,  
    public boolean isAppendOnlyIndex() {
        INDEX_NUMBER_OF_SHARDS_SETTING,
    public Map<String, String> getCustomData(final String key) {  
            rolloverInfos.writeTo(out);
     *
            builder.field(KEY_ROUTING_NUM_SHARDS, indexMetadata.getRoutingNumShards());
            boolean binary = params.paramAsBoolean("binary", false);
         * @see #setRoutingNumShards(int)
    public static final String SETTING_BLOCKS_READ = APIBlock.READ.settingName();
    public DiscoveryNodeFilters requireFilters() {
        return isRemoteSnapshot;  
    }
        public Setting<Boolean> setting() {
        }  
            for (APIBlock block : APIBlock.values()) {
     * that can be indexed into) is larger than 0. See {@link IndexMetadataUpdater#applyChanges}.
    /**  
            this.rolloverInfos = new HashMap<>(indexMetadata.rolloverInfos);
     * Prefix setting for mapper-specific options. These settings are passed to the configured mapper type.
                }  
                                + " is set to true"  
    }
                        mappingVersion = true;
         * See {@link IndexMetadata#primaryTerm(int)} for more information.
        if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
            } else {
        Property.Dynamic,
     */
        public long aliasesVersion() {  
        private SplitShardsMetadata splitShardsMetadata;  
        SETTING_VERSION_CREATED,  
                before.inSyncAllocationIds,  
            return APIBlock.values()[input.readVInt()];  
     * normal wildcard searches unless explicitly allowed  
        for (int i = shardId * routingFactor; i < routingFactor * shardId + routingFactor; i++) {
                        );  
            return Collections.singleton(selectSplitShard(shardId, sourceIndexMetadata, numTargetShards));
    /**  
        }
        Property.IndexScope,
                    } else {  
        private static final DiffableUtils.DiffableValueReader<String, DiffableStringMap> CUSTOM_DIFF_VALUE_READER =
            return this;  
        }
                primaryTerms = in.readVLongArray();  
    }  
                );
     * isolation from writers (primary shards).  This means they are not primary eligible and do not have any direct communication
        return routingPartitionSize != 1;
        Property.IndexScope,  
    private final transient int totalNumberOfShards;
        CLOSE((byte) 1);
            builder.primaryTermsMap(in.readMap(StreamInput::readInt, StreamInput::readLong));
            .append(mappingVersion)
        SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY,
        public Builder(IndexMetadata indexMetadata) {  
        IngestionMessageMapper.MapperType.DEFAULT.getName(),
                customMetadata,
                    filledInSyncAllocationIds.put(i, Collections.unmodifiableSet(new HashSet<>(inSyncAllocationIds.get(i))));
            mappings.writeTo(out);  
    @Override
     * Returns the routing factor for this index. The default is {@code 1}.
        100,
            this.aliases = new HashMap<>(indexMetadata.aliases);
                return settings.iterator();
    public static final MetadataStateFormat<IndexMetadata> FORMAT = new MetadataStateFormat<>(INDEX_STATE_FILE_PREFIX) {
     * an internal index format description, allowing us to find out if this index is upgraded or needs upgrading
                throw new IllegalArgumentException("expected object but got a " + token);
        SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
                    + "1 and "
        Property.PrivateIndex,
    }
                indexTotalShardsPerNodeLimit,
    }
                if (mmd != null) {
    /**
    public static final String SETTING_INGESTION_SOURCE_WARMUP_TIMEOUT = "index.ingestion_source.warmup.timeout";  
     * failover. Requires the translog repository to support conditional writes.
                                String shardId = currentFieldName;  
                indexCreatedVersion,
        }  
            version = in.readLong();
import org.opensearch.core.common.io.stream.StreamInput;
        final SplitShardsMetadata splitShardsMetadata,
            builder.putInSyncAllocationIds(key, allocationIds);
            if (primaryTermsMap.isEmpty()) {
                    }
            final int indexTotalShardsPerNodeLimit = ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.get(settings);  
        Property.IndexScope,  
        false,  
    }
        }
                INGESTION_SOURCE_POINTER_INIT_RESET_SETTING.get(settings).toUpperCase(Locale.ROOT)
                }  
    static final String KEY_SETTINGS_VERSION = "settings_version";  
            if (in.getVersion().onOrAfter(Version.V_2_17_0)) {  
        return settings.getAsLong(SETTING_CREATION_DATE, -1L);
import org.opensearch.cluster.block.ClusterBlockLevel;
            } else {
    public static final String SETTING_READ_ONLY_ALLOW_DELETE = APIBlock.READ_ONLY_ALLOW_DELETE.settingName();
import org.opensearch.common.unit.TimeValue;
        "",
     * Builder of index metadata.  
     * translog repository, so a stale primary fails itself instead of acknowledging writes that would be lost on
    );  
            aliases.put(aliasMetadata.alias(), aliasMetadata.build());
     * @param sourceIndexMetadata the source index metadata
            ? new Index(INDEX_RESIZE_SOURCE_NAME.get(settings), INDEX_RESIZE_SOURCE_UUID.get(settings))
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        this.bulkAdaptiveShardSelectionEnabled = INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED.get(settings);
                isSystem,
            final Map<Integer, Set<String>> filledInSyncAllocationIds = new HashMap<>();
                final Object remoteStoreEnabled = settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);
                                + " can only be set when "
        private final String index;
     * Defines the acceptable pointer-based lag threshold. Warmup completes when lag is at or below this value.
    public static final String SETTING_BLOCKS_WRITE = APIBlock.WRITE.settingName();
    public static final String SETTING_INGESTION_SOURCE_ERROR_STRATEGY = "index.ingestion_source.error_strategy";
            );  
            return inSyncAllocationIds.get(shardId);
    }
     * <p>
        return indexUpgradedVersion;  
    private final IngestionStatus ingestionStatus;  
        IndexMetadata that = (IndexMetadata) o;
        Property.IndexScope,  
    public static final String NONE_INGESTION_SOURCE_TYPE = "none";
                for (String allocationId : cursor.getValue()) {  
import org.opensearch.core.xcontent.ToXContent;
     * Return the version the index was created from the provided index settings
            builder.context(context);  
        public Builder putMapping(String source) throws IOException {  
                Locale.ROOT,
        if (Objects.equals(ingestionStatus, that.ingestionStatus) == false) {
    public static final int INDEX_SEARCH_ONLY_BLOCK_ID = 20;  
        Property.IndexScope,
     * Defines the maximum time to wait for lag to catch up during warmup phase.  
     * supported and required keys. Example:  
                        builder.settings(Settings.fromXContent(parser));  
            if (id == 0) {
                "the number of target shards (" + numTargetShards + ") must be greater than the shard id: " + shardId  
            if (factor * targetNumberOfShards != sourceNumberOfShards || factor <= 1) {
                    } else if (KEY_SYSTEM.equals(currentFieldName)) {  
            int routingPartitionSize = INDEX_ROUTING_PARTITION_SIZE_SETTING.get(settings);  
    public static final String SETTING_ROUTING_PARTITION_SIZE = "index.routing_partition_size";  
                        builder.system(parser.booleanValue());
                builder.endObject();  
            out.writeMap(primaryTermsMap, StreamOutput::writeInt, StreamOutput::writeLong);
        if (sourceIndexMetadata.getNumberOfShards() > numTargetShards) {
    public Settings getSettings() {
            throw new IllegalArgumentException(
        }
    }
     */  
        boolean isAppendOnlyIndex,
    public static final Setting<Integer> INDEX_PRIORITY_SETTING = Setting.intSetting(
                );
            .append(index)
 * this work for additional information regarding copyright
        this.indexTotalPrimaryShardsPerNodeLimit = indexTotalPrimaryShardsPerNodeLimit;  
                    || StreamPoller.ResetState.EARLIEST.name().equalsIgnoreCase(value)
                            "Setting "
    /**
            }
    public static final String TRANSLOG_METADATA_KEY = "translog_metadata";
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING);
    private final long mappingVersion;
        public IndexMetadata fromXContent(XContentParser parser) throws IOException {  
    );
                numberOfReplicas,
    }  
            this.settingsVersion = indexMetadata.settingsVersion;
        } else if (sourceIndexMetadata.getNumberOfShards() < numTargetShards) {  
    private final boolean isAppendOnlyIndex;
                                + INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey()  
                            + numberOfVirtualShards
            Map<Integer, Long> primaryTermsMapFromArray = new HashMap<>();
                                + " is enabled: the auto-restore trigger fires on the cluster manager's view of node"  
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_ENABLED_SETTING);
            MappingMetadata mappingMd = new MappingMetadata(in);
                ? INDEX_APPEND_ONLY_ENABLED_SETTING.get(settings)  
                return OPEN;  
            settings = Settings.builder().put(settings).put(SETTING_NUMBER_OF_SEARCH_REPLICAS, numberOfSearchReplicas).build();  
            }
                DiffableUtils.StringSetValueSerializer.getInstance()  
        public ClusterBlock getBlock() {
    }  
        false,
            }
            aliases = DiffableUtils.diff(before.aliases, after.aliases, DiffableUtils.getStringKeySerializer());  
                            } else {  
    public static final String SETTING_INGESTION_SOURCE_POINTER_INIT_RESET = "index.ingestion_source.pointer.init.reset";
    };  
            throw new IllegalArgumentException(
            settings = Settings.builder().put(settings).put(SETTING_CREATION_DATE, creationDate).build();
     */
                            } else if (token == XContentParser.Token.START_OBJECT) {
                this.primaryTermsMap.put(i, SequenceNumbers.UNASSIGNED_PRIMARY_TERM);  
        return null;  
            if (factor * sourceNumberOfShards != targetNumberOfShards || factor <= 1) {  
    public int getNumberOfShards() {
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {  
     */
            return this;  
            throw new IllegalArgumentException(  
        assert primaryTermsMap.size() == numberOfShards;
            throw new IllegalArgumentException("No block found with name " + name);  
            settings = after.settings;
        this.requireFilters = requireFilters;
            public Iterator<Setting<?>> settings() {
        private final Diff<Map<Integer, Set<String>>> inSyncAllocationIds;  
        private static final DiffableUtils.DiffableValueReader<String, AliasMetadata> ALIAS_METADATA_DIFF_VALUE_READER =
                    || isResetState(value);
            .append(ingestionStatus)
            } else {
                            "Settings "
    /**
            return this.id;
    private final int numberOfShards;
     */  
        public Builder putAlias(AliasMetadata.Builder aliasMetadata) {
     * Prefix setting for decoder-specific options. Each decoder factory validates
                        builder.primaryTerms(list.stream().mapToLong(i -> i).toArray());
    /**
                    builder.value(indexMetadata.primaryTerm(i));
        for (final RolloverInfo cursor : rolloverInfos.values()) {
        writeSettingsToStream(settings, out);  
            long[] primaryTerms = null;
                                builder.putMapping(new MappingMetadata(mappingType, mappingSource));
     * Returns the source shard ID to split the given target shard off
            Map<String, String> initialRecoveryMap = INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING.getAsMap(settings);
                                Set<String> allocationIds = new HashSet<>();
     */  
    );  
        Property.IndexScope  
        return aliasesVersion;
         */
        public byte id() {  
            public void validate(final Boolean value, final Map<Setting<?>, Object> settings) {
        false,  
        params.put("binary", "true");
                    + "]"
        builder.settingsVersion(in.readVLong());
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE, ClusterBlockLevel.WRITE)
    );  
     */
                                currentFieldName = parser.currentName();
                        "To enable "
         * kills the entire cluster with OOM on the spot.*/
            }
            }
            );
     * This mode is currently not supported with segment replication.
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.get(settings);
        final Setting<Boolean> setting;
            }
        }
                    } else {
    static final String KEY_VERSION = "version";
        Property.IndexScope,
    }
     */
    private final Map<Integer, Long> primaryTermsMap;
        },
            this.primaryTermsMap = new HashMap<>(primaryTermsMap);  
        INDEX_UUID_NA_VALUE,  
            builder.ingestionStatus(ingestionStatus);
        public Context context() {  
        Property.IndexScope,  
        public Builder numberOfReplicas(int numberOfReplicas) {  
    private static void validateRemoteStoreSettingEnabled(final Map<Setting<?>, Object> settings, Setting<?> setting) {
            return this;
        }  
        out.writeLong(version);  
        return new IndexMetadataDiff(in);
    );  
import java.util.EnumSet;
            .append(", rolloverInfos=")
                    "the number of source shards [" + sourceNumberOfShards + "] must be a " + "factor of [" + targetNumberOfShards + "]"
        try {
    public long getMappingVersion() {
import java.util.Map;
                        + "] should be a positive number"
    }
    public static final Setting<Boolean> INDEX_REMOTE_STORE_ENABLED_SETTING = Setting.boolSetting(  
    public static final Setting<String> INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX = Setting.simpleString(
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
            }
        }
                }
        private final Diff<Map<String, RolloverInfo>> rolloverInfos;
        false,  
            @Override
        return builder.build();
     * Used to specify initial reset policy for the ingestion pointer. If not specified, default to the latest  
        if (this == o) {
 * Modifications Copyright OpenSearch Contributors. See
        }
                            }
     * store (the state that otherwise parks at {@code NO_VALID_SHARD_COPY}, RED) into a remote-store recovery on a  
import org.opensearch.cluster.routing.allocation.IndexMetadataUpdater;
                                    .map();  
        Builder.toXContent(this, builder, params);
        0,  
                this.primaryTermsMap.put(shard, primaryTerms[shard]);
    /**
        return new Builder(index);
                        builder.mappingVersion(parser.longValue());  
                waitForActiveShards,
        this.indexTotalRemoteCapablePrimaryShardsPerNodeLimit = indexTotalRemoteCapablePrimaryShardsPerNodeLimit;
        public static void toXContent(IndexMetadata indexMetadata, XContentBuilder builder, ToXContent.Params params) throws IOException {
            maxNumShards,  
        },
            out.writeString(index);  
        // now we verify that the numRoutingShards is valid in the source index
            }  
            if (includeMap.isEmpty()) {
                aliasesVersion,
            );
import org.opensearch.core.xcontent.XContentParser;
        private String index;
        SETTING_INGESTION_SOURCE_TYPE,  
    public boolean bulkAdaptiveShardSelectionEnabled() {
                }
        this.context = context;
        SETTING_INDEX_HIDDEN,  
    public static final String SETTING_INGESTION_SOURCE_MAX_POLL_SIZE = "index.ingestion_source.poll.max_batch_size";
            this.isSystem = indexMetadata.isSystem;  
        if (routingNumShards != that.routingNumShards) {
            this.primaryTermsMap = new HashMap<>(indexMetadata.primaryTermsMap);
    public static final Setting<ReplicationType> INDEX_REPLICATION_TYPE_SETTING = new Setting<>(  
        out.writeVLong(mappingVersion);
    public static final String SETTING_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED = "index.bulk.adaptive_shard_selection.enabled";  
    public boolean useIngestionSource() {  
                        + "]"  
                        builder.putCustom(currentFieldName, parser.mapStrings());
            }
     */
    );
        assert numberOfShards * routingFactor == routingNumShards : routingNumShards + " must be a multiple of " + numberOfShards;
            }  
     * @return a set of shard IDs to shrink into the given shard ID.
        }
        SETTING_REMOTE_STORE_ENABLED,
        }
         * Returns number of shards that should be used for routing. By default this method will return the number of shards
                        + index  
        this.isRemoteSnapshot = IndexModule.Type.REMOTE_SNAPSHOT.match(this.settings);
        private final int routingNumShards;
        this.totalNumberOfShards = numberOfShards * (numberOfReplicas + numberOfSearchOnlyReplicas + 1);
        "disk usage exceeded flood-stage watermark, index has read-only-allow-delete block",
            final int indexTotalPrimaryShardsPerNodeLimit = ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(
            out.writeVLong(settingsVersion);
                    + index.getName()
        final Settings settings,
    );
     * Test whether the current index UUID is the same as the given one. Returns true if either are _na_
     * writers may write to the same shard.
                );  
                builder.field(cursor.getKey());  
        if (!customData.equals(that.customData)) {
                    + "] must be less that the number of target shards ["  
        private long mappingVersion = 1;
                    );  
                out.writeOptionalWriteable(context);
            state = after.state;  
            builder.primaryTermsMap(primaryTermsMapFromArray);
            factor = targetNumberOfShards / sourceNumberOfShards;
import org.opensearch.cluster.block.ClusterBlock;
                    + "]"  
            throw new IllegalArgumentException(
        this.indexTotalRemoteCapableShardsPerNodeLimit = indexTotalRemoteCapableShardsPerNodeLimit;
                after.inSyncAllocationIds,
                    builder.value(allocationId);
                indexMetadata.getSettings().toXContent(builder, new MapParams(Collections.singletonMap("flat_settings", "true")));  
                        "Replication type "  
            return false;  
        }  
                for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {  
                        + "number of shard copies ["  
    private static final ToXContent.Params FORMAT_PARAMS;  
        int mappingsSize = in.readVInt();
         * sets the primary term for the given shard.  
            throw new IllegalArgumentException(
        public static State fromId(byte id) {
    }
    public long getSettingsVersion() {  
        out.writeBoolean(isSystem);
        assertSplitMetadata(numSourceShards, numTargetShards, sourceIndexMetadata);
        RestStatus.FORBIDDEN,
    public boolean isRoutingPartitionedIndex() {
            settings = Settings.readSettingsFromStream(in);  
    private final Index index;
                        + getRoutingNumShards()
                primaryTermsMap
            builder.context(in.readOptionalWriteable(Context::new));
    public static final Setting<Boolean> INDEX_APPEND_ONLY_ENABLED_SETTING = Setting.boolSetting(
        0L,
            return block;  
        public long version() {  
                    + defaultNumShards
            return isSystem;
                }
        public long primaryTerm(int shardId) {
     * remote-store-backed end to end.
        EnumSet.of(ClusterBlockLevel.WRITE)
    public static final String SETTING_CREATION_DATE = "index.creation_date";
                        }
            factor = 1;
            @Override
            final IngestionErrorStrategy.ErrorStrategy errorStrategy = INGESTION_SOURCE_ERROR_STRATEGY_SETTING.get(settings);  
            throw new IllegalStateException(
            index = after.index.getName();  
            Version indexUpgradedVersion = settings.getAsVersion(IndexMetadata.SETTING_VERSION_UPGRADED, indexCreatedVersion);  
            DiffableStringMap custom = DiffableStringMap.readFrom(in);  
            primaryTermsMap = after.primaryTermsMap;
        private final State state;
     * Note: since we increment the term every time a shard is assigned, the term for any operational shard (i.e., a shard  
        -1,  
            public void validate(final Integer numRoutingShards, final Map<Setting<?>, Object> settings) {
        Property.IndexScope,  
    }
            this.mappings = new HashMap<>(indexMetadata.mappings);  
                .setNumProcessorThreads(numProcessorThreads)  
            if (mappingMd != null) {  
            DiffableUtils.StringSetValueSerializer.getInstance().write(cursor.getValue(), out);
        public void toXContent(XContentBuilder builder, IndexMetadata state) throws IOException {
                splitShardsMetadata,  
        return true;
        public Builder(String index) {
        "index scaled down",  
    public static final Setting<Boolean> INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING = APIBlock.READ_ONLY_ALLOW_DELETE.setting();
            return this.version;
        }, Property.IndexScope, Property.Final)  
        Function.identity(),
            }  
        public Builder putAlias(AliasMetadata aliasMetadata) {
        key -> Setting.simpleString(key)
    );
            public void validate(final String value, final Map<Setting<?>, Object> settings) {  
            public void validate(final ReplicationType value) {}
    }  
            context = after.context;
            this.state = indexMetadata.state;
                builder.startArray(String.valueOf(cursor.getKey()));
        private final Map<String, RolloverInfo> rolloverInfos;
        SETTING_INGESTION_SOURCE_POINTER_INIT_RESET,
                                + " cannot contain path separators (/ or \\) or drive specifiers (:)"  
        out.writeString(index.getName()); // uuid will come as part of settings
                                throw new IllegalStateException("found a non-numeric value under [" + KEY_PRIMARY_TERMS + "]");
        }  
        }
                    if (entry.getKey() < numShards) {  
     */
        /**
        return terms;  
                            "Setting "
            @Override  
            }  
    public static int getRoutingFactor(int sourceNumberOfShards, int targetNumberOfShards) {
    public DiscoveryNodeFilters includeFilters() {
import org.opensearch.common.annotation.PublicApi;
    );
        out.writeString(index.getName()); // uuid will come as part of settings
        Property.PrivateIndex,
                    XContentHelper.convertToMap(MediaTypeRegistry.xContent(source).xContent(), source, true)
    }
     * @param shardId             the id of the target shard to split into  
    }  
        this.numberOfSearchOnlyReplicas = numberOfSearchOnlyReplicas;  
        public static State fromString(String state) {
    }
                    + maxNumShards
                "the number of routing shards [" + routingNumShards + "] must be a multiple of the target shards [" + numTargetShards + "]"  
        if (maxNumShards < 1) {  
        final Map<String, MappingMetadata> mappings,  
        }
        Property.IndexScope,
            builder.field(KEY_SYSTEM, indexMetadata.isSystem);  
    public MappingMetadata mapping() {
            StreamOutput::writeVInt,  
    /**
                        + routingPartitionSize
        return this.indexTotalPrimaryShardsPerNodeLimit;  
     */  
                                    String mappingType = mapping.keySet().iterator().next();
            final Map<String, AliasMetadata> tmpAliases = aliases;
                        }  
    );  
            builder.startObject(KEY_IN_SYNC_ALLOCATIONS);  
        Property.Dynamic
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
    }  
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE, ClusterBlockLevel.METADATA_READ)
                    } else if (INGESTION_STATUS_KEY.equals(currentFieldName)) {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final long mappingVersion;
     * Used to specify if the index data should be persisted in the remote store.
            }
                            + "] for ["  
         */
            final Map<String, Object> ingestionSourceParams = INGESTION_SOURCE_PARAMS_SETTING.getAsMap(settings);
        result = 31 * result + Boolean.hashCode(isSystem);
        this.indexTotalShardsPerNodeLimit = indexTotalShardsPerNodeLimit;
    /**  
            if (waitForActiveShards.validate(numberOfReplicas) == false) {
                        + "] for ["
 */
     * The state of the index.  
            @Override  
     *
            }
    /**
                Version.CURRENT.toString()  
            rolloverInfos.put(rolloverInfo.getAlias(), rolloverInfo);
                } else {
        }
        }
                                + INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey()  
            builder.splitShardsMetadata(new SplitShardsMetadata(in));  
                    primaryTermsMap.put(shardId, primaryTerms[shardId]);
        }
                        throw new IllegalArgumentException(  
    /**  
    public static final ClusterBlock INDEX_READ_ONLY_ALLOW_DELETE_BLOCK = new ClusterBlock(  
                requireFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, AND, requireMap);  
     * and {@code op_type_field} settings.  
        Property.IndexScope,  
            public void validate(final Boolean value, final Map<Setting<?>, Object> settings) {  
            .append(primaryTermsMap)
        out.writeVLong(aliasesVersion);  
        try {
                builder.startArray(KEY_PRIMARY_TERMS);
            final String message = String.format(
        false,
        }
        -1,  
     */
                getRoutingFactor(numShards, numRoutingShards);  
        return builder.build();  
    public Version getCreationVersion() {  
            .append(", primaryTerms=")
            }
    );  
                    } else if (KEY_ROUTING_NUM_SHARDS.equals(currentFieldName)) {
            routingNumShards = after.routingNumShards;
        key -> new Setting<>(key, "", (value) -> {  
     */  
    );
        this.primaryTermsMap = Collections.unmodifiableMap(primaryTermsMap);
        Property.Final
        }, Property.IndexScope, Property.Dynamic)  
        }
         *
     * @param numTargetShards     the number of target shards
     * State format for {@link IndexMetadata} to write to and load from disk
    }
                    } else if (KEY_ALIASES.equals(currentFieldName)) {  
                    MapperService.SINGLE_MAPPING_NAME,  
            );  
        return inSyncAllocationIds.get(shardId);
         * @see #numberOfShards()  
            );  
        final ActiveShardCount waitForActiveShards,  
        if (!Objects.equals(context, that.context)) {
            if (initialRecoveryMap.isEmpty()) {  
            final Map<String, String> requireMap = INDEX_ROUTING_REQUIRE_GROUP_SETTING.getAsMap(settings);
            }
    public static final Setting<Boolean> INDEX_BLOCKS_WRITE_SETTING = APIBlock.WRITE.setting();
            new DiffableUtils.DiffableValueReader<>(MappingMetadata::new, MappingMetadata::readDiffFrom);
        }
        public static APIBlock fromName(String name) {  
     */
     * The user provided name for an index. This is the plain string provided by the user when the index was created.  
        INDEX_FORMAT,  
                    throw new IllegalArgumentException(
            .append(", aliases=")  
            Map<String, String> excludeMap = INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getAsMap(settings);  
     * @param numTargetShards     the total number of shards in the target index  
            this.routingNumShards = indexMetadata.routingNumShards;  
        return routingPartitionSize;
    @PublicApi(since = "1.0.0")
                    if (mapping.size() == 1 && mapping.containsKey(mmd.type())) {
                // ingestionStatus field is introduced from OS 3.x. But this field is included in XContent serialization only from OS 3.3
            }
    /**  
    }  
        out.writeMapValues(aliases, (stream, val) -> val.writeTo(stream));
                for (final String cursor : indexMetadata.getAliases().keySet()) {  
            );  
     * A search only replica exists solely to perform read operations for a shard and are designed to achieve
            @Override
            // Warmup settings
        Map<String, String> params = new HashMap<>(2);  
        private final byte id;  
                indexMetadata.context.toXContent(builder, params);
    public int getNumberOfReplicas() {
        }
            );
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
    static final String MAX_NUMBER_OF_SHARDS = "opensearch.index.max_number_of_shards";
     * @opensearch.api
            this.customMetadata = new HashMap<>();  
        this.excludeFilters = excludeFilters;  
    /**
            Property.UnmodifiableOnRestore  
            throw new IllegalArgumentException("No block found with setting name " + settingName);  
            return false;
                    "invalid "
                DiffableUtils.getVIntKeySerializer(),
                    final Boolean isRemoteSegmentStoreEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);
            Map<String, String> includeMap = INDEX_ROUTING_INCLUDE_GROUP_SETTING.getAsMap(settings);
    private long[] buildPrimaryTermsArray() {
    public Context context() {
            if (splitShardsMetadata == null) {
            || getRoutingFactor(numTargetShards, routingNumShards) >= 0;
        this.isSystem = isSystem;  
        }
 *  
     * Requires {@link #INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING}: the trigger fires on the cluster manager's  
        }
        }
                final Object replicationType = settings.get(INDEX_REPLICATION_TYPE_SETTING);
            if (numberOfShards() < 0) {
         * Returns the number of shards.
            settings = Settings.builder().put(settings).put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas).build();
            this.customMetadata.put(type, new DiffableStringMap(customIndexMetadata));
     * Defines the number of processor threads that will write to the lucene index.  
import org.opensearch.common.settings.Setting.Property;
        final ClusterBlock block;  
    public IngestionStatus getIngestionStatus() {  
                        builder.setRoutingNumShards(parser.intValue());
        Setting.Property.IndexScope,
            settingsVersion = after.settingsVersion;  
                "the number of target shards ("
        0,  
            return this;
import org.opensearch.indices.replication.common.ReplicationType;  
     */
                        }  
    }
            return this;  
        },
                    throw new IllegalArgumentException(
        out.writeVInt(rolloverInfos.size());
        }
            this.setting = Setting.boolSetting(settingName, false, Property.Dynamic, Property.IndexScope);
        final long settingsVersion,
import java.time.Instant;  
        EnumSet.of(ClusterBlockLevel.WRITE)
        if (numSourceShards > numTargetShards) {
                for (Map.Entry<Integer, Long> entry : primaryTermsMap.entrySet()) {
    public static final String SETTING_READ_ONLY = APIBlock.READ_ONLY.settingName();
     * Setting for the payload decoder type.
        }
        Property.Final
                        throw new IllegalArgumentException("Unexpected field [" + currentFieldName + "]");  
        return factor;  
                return settings.iterator();  
            this.mappings = new HashMap<>();
        private long settingsVersion = 1;
    public DiscoveryNodeFilters getInitialRecoveryFilters() {  
                    );
            final Map<String, Object> mapperSettings = INGESTION_SOURCE_MAPPER_SETTINGS.getAsMap(settings);  
            public void validate(final Boolean value) {}
     * Permanent cluster block applied to indices in search-only mode.  
     */  
     */
        EnumSet.of(ClusterBlockLevel.READ)
    public boolean equals(Object o) {  
                builder.field(CONTEXT_KEY);  
            builder.rolloverInfos.putAll(rolloverInfos.apply(part.rolloverInfos));
        "index.write.wait_for_active_shards",
        SETTING_NUMBER_OF_SEARCH_REPLICAS,
            out.writeOptionalWriteable(context);
                    // Ensure the reset value setting is provided when resetting consumer position.
    public static final String SETTING_NUMBER_OF_SHARDS = "index.number_of_shards";
    public static IndexMetadata fromXContent(XContentParser parser) throws IOException {
            } else if ("close".equals(state)) {
        return result;
    public long getVersion() {
        (errorStrategy) -> {},  
     * The built-in decoder is {@code xcontent} (JSON). Plugins may register
    /**  
    private final Map<String, MappingMetadata> mappings;
                parser.nextToken();
            this.aliasesVersion = indexMetadata.aliasesVersion;  
            }
        1,
                .setSourcePartitionStrategy(sourcePartitionStrategy)
        State(byte id) {
                }  
        }
            return this.customMetadata.remove(type);
        for (int i = 0; i < inSyncAllocationIdsSize; i++) {
        "index.ingestion_source.pointer_based_lag_update_interval";  
    private final boolean isSystem;
        XContentIngestionPayloadDecoder.NAME,
                cursor.toXContent(builder, params);  
        },
            /*
            .append(", customData=")  
    public Map<Integer, Set<String>> getInSyncAllocationIds() {
            // TODO: add ingestion source params validation
        return routingFactor;  
import java.util.List;  
    }
    private final Map<String, RolloverInfo> rolloverInfos;  
        Version versionUpgraded = settings.getAsVersion(SETTING_VERSION_UPGRADED, null);  
        OPEN((byte) 0),  
            final int pollTimeout = INGESTION_SOURCE_POLL_TIMEOUT.get(settings);  
        public long mappingVersion() {  
                        + SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey()
        READ("read", INDEX_READ_BLOCK),  
                    if (fencingEnabled == null || fencingEnabled == false) {  
        Property.IndexScope,
            }
            }  
            aliasesVersion = in.readVLong();
     * streaming source and process the updates. In the default document replication mode, this setting must be enabled.  
            .append(", inSyncAllocationIds=")
            .append(", context=")
    public static final Setting<String> INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING = Setting.simpleString(
     * information is typically useful for backward compatibility.
        private final IngestionStatus ingestionStatus;
                rolloverInfos,  
    private final Version indexCreatedVersion;
    );
    public static final String SETTING_AUTO_EXPAND_SEARCH_REPLICAS = "index.auto_expand_search_replicas";  
        }
            return this;  
     * @param numTargetShards     the total number of shards in the target index
        private final Diff<Map<String, MappingMetadata>> mappings;  
                    throw new IllegalArgumentException(
        this.numberOfShards = numberOfShards;
     * <p>
import org.opensearch.index.mapper.MapperService;
        assert mappingVersion >= 0 : mappingVersion;
                if (value != null && !value.trim().isEmpty()) {  
            if (splitMetadata != null) {
            throw new IllegalArgumentException("no - separator found in index name [" + indexName + "]");  
        SETTING_INDEX_APPEND_ONLY_ENABLED,
        out.writeVLong(aliasesVersion);  
            aliases.writeTo(out);
        INDEX_UUID_NA_VALUE,
     */
                            } else {
        final int indexTotalShardsPerNodeLimit,  
        }
                final Object ingestionSourceType = settings.get(INGESTION_SOURCE_TYPE_SETTING);  
    }
        Property.IndexScope  
     * hashing / routing of documents even if the number of shards changed (ie. a shrunk index).  
import java.util.Set;
        if (isAppendOnlyIndex == false && bulkAdaptiveShardSelectionEnabled) {
     *
import org.opensearch.cluster.Diff;
        Property.IndexScope,
            builder.ingestionStatus(in.readOptionalWriteable(IngestionStatus::new));
    );
        }  
    public static final Setting<AutoExpandSearchReplicas> INDEX_AUTO_EXPAND_SEARCH_REPLICAS_SETTING = AutoExpandSearchReplicas.SETTING;
        private boolean isSystem;  
            shards.add(new ShardId(sourceIndexMetadata.getIndex(), i));  
     * It might still contain date math expressions etc. (added in 5.0)
                in,  
            SETTING_NUMBER_OF_SHARDS,  
            builder.put(SETTING_VERSION_CREATED_STRING, version.toString());
        if (out.getVersion().onOrAfter(Version.V_3_6_0)) {  
            Settings tmpSettings = settings;  
            // fill missing slots in inSyncAllocationIds with empty set if needed and make all entries immutable
            builder.startObject(KEY_PRIMARY_TERMS_MAP);  
     * Defines the error strategy for pull-based ingestion.
        }
        int routingNumShards = numSourceShards == 1 ? numTargetShards : sourceIndexMetadata.getRoutingNumShards();  
         * other than 1. This value is applicable only if the index.number_of_shards setting is not provided as part of the
        if (version != Version.V_EMPTY) {  
        return new StringBuilder().append("IndexMetadata{routingNumShards=")
                    if (value.contains("/") || value.contains("\\") || value.contains(":")) {
            this.settingsVersion = settingsVersion;
        }
            this.state = state;
                );  
            builder.customMetadata.putAll(customData.apply(part.customData));
        SETTING_INGESTION_SOURCE_POINTER_INIT_RESET_VALUE,
                        Map<Integer, Long> primaryTermsMap = new HashMap<>();
            for (int i = 0; i < numberOfShards(); i++) {
        ReplicationType::parseString,  
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
                initializePrimaryTerms();
     * must be a multiple of the number of physical shards {@code (V % P == 0)}.
                            if (token != XContentParser.Token.VALUE_NUMBER) {
    );
                    );
        return inSyncAllocationIds;
            return false;  
                builder.startObject(IndexMetadata.KEY_PRIMARY_TERMS);
        public Builder removeAllAliases() {
        final Map<Integer, Set<String>> inSyncAllocationIds,  
            this.context = indexMetadata.context;
            this.inSyncAllocationIds = new HashMap<>(indexMetadata.inSyncAllocationIds);
                    if (resetValue == null || resetValue.isEmpty()) {
        return index.getUUID();
        "index read (api)",
    public boolean isAllActiveIngestionEnabled() {
    /**
     */
     * Gets the ingestion source.
        if (sourceIndexMetadata.getNumberOfShards() < numTargetShards) {  
            ingestionStatus = after.ingestionStatus;
                    }
        public Builder state(State state) {  
    public static final String SETTING_REMOTE_SEGMENT_STORE_REPOSITORY = "index.remote_store.segment.repository";
        "",  
        out.writeVInt(customData.size());  
        false,
        false,
    ) {  
    }
            builder.state(state);  
    public static final Setting<Boolean> INDEX_BLOCKS_METADATA_SETTING = APIBlock.METADATA.setting();
            }  
    public static final String SETTING_INGESTION_SOURCE_WARMUP_LAG_THRESHOLD = "index.ingestion_source.warmup.lag_threshold";
        }  
                        builder.ingestionStatus(IngestionStatus.fromXContent(parser));  
        out.writeMap(
                builder.map(cursor.getValue());
        result = 31 * result + settings.hashCode();
        for (int i = 0; i < rolloverAliasesSize; i++) {
    public static final String SETTING_INGESTION_SOURCE_PARTITION_STRATEGY = "index.ingestion_source.source_partition_strategy";
    public static final String INDEX_SETTING_PREFIX = "index.";
    public int getRoutingFactor() {
        false,  
    private final SplitShardsMetadata splitShardsMetadata;
                version,
        Setting.Property.IndexScope,
            if (routingPartitionSize != 1 && routingPartitionSize >= getRoutingNumShards()) {
    static Setting<Integer> buildNumberOfShardsSetting() {
    public static final ClusterBlock INDEX_READ_ONLY_BLOCK = new ClusterBlock(  
            );
            putMapping(
            return false;  
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE, ClusterBlockLevel.WRITE)
    }
            .append(", settingsVersion=")
            return setting;
        }  
        "index read-only (api)",
import org.opensearch.indices.replication.SegmentReplicationSource;
    /**  
     */
    public static final String INDEX_ROUTING_REQUIRE_GROUP_PREFIX = "index.routing.allocation.require";
import org.opensearch.core.index.Index;  
            for (final Map.Entry<String, DiffableStringMap> cursor : indexMetadata.customData.entrySet()) {
        Property.Dynamic
    public static final Setting<String> INDEX_UUID_SETTING = Setting.simpleString(
                throw new IllegalArgumentException(
            this.splitShardsMetadata = indexMetadata.splitShardsMetadata;  
                                    .put(mappingType, parser.mapOrdered())
                getRoutingNumShards(),  
            int key = in.readVInt();
        builder.settings(readSettingsFromStream(in));  
 *
            final DiscoveryNodeFilters excludeFilters;
        return new IndexMetadataDiff(previousState, this);
            this.name = name;  
        private final long version;  
        out.writeMapValues(rolloverInfos, (stream, val) -> val.writeTo(stream));  
        // 1 to N but we never modify the sourceIndexMetadata to accommodate for that
        this.mappings = Collections.unmodifiableMap(mappings);  
                }
                : IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(settings);
import java.util.HashSet;
     * live node, so the shard goes unassigned &rarr; recovering &rarr; started with no operator action.
                builder.field(String.valueOf(cursor.getKey()), cursor.getValue());
        1,
                if (numberOfVirtualShards % numberOfShards != 0) {  
        RestStatus.FORBIDDEN,  
import java.util.function.Function;
        result = 31 * result + Objects.hashCode(splitShardsMetadata);
            inSyncAllocationIds.put(shardId, new HashSet<>(allocationIds));  
            }
import java.io.IOException;
        int rolloverAliasesSize = in.readVInt();  
            settings = Settings.builder().put(settings).put(SETTING_ROUTING_PARTITION_SIZE, routingPartitionSize).build();
        public Builder numberOfSearchReplicas(int numberOfSearchReplicas) {
        if (!inSyncAllocationIds.equals(that.inSyncAllocationIds)) {
    public static final String SETTING_VERSION_CREATED_STRING = "index.version.created_string";
        this.indexCreatedVersion = indexCreatedVersion;
        }  
                    + " value ["
            final int numberOfReplicas = INDEX_NUMBER_OF_REPLICAS_SETTING.get(settings);  
import java.util.Locale;
            }
    private final ActiveShardCount waitForActiveShards;
            return ingestionStatus;
        "index.ingestion_source.mapper_settings.",  
            return this;
    @Nullable  
                    if (isRemoteSegmentStoreEnabled == null || isRemoteSegmentStoreEnabled == false) {  
     *
        },
            .append(settingsVersion)
            builder.endObject();
                    } else if (KEY_ROLLOVER_INFOS.equals(currentFieldName)) {  
                        throw new IllegalArgumentException(
import java.util.ArrayList;  
        public static IndexMetadata fromXContent(XContentParser parser) throws IOException {
        final int factor;  
        result = 31 * result + Long.hashCode(routingNumShards);  
                        builder.settingsVersion(parser.longValue());  
        public static APIBlock fromSetting(String settingName) {  
    }
                throw new IllegalArgumentException("expected field name but got a " + parser.currentToken());
     *
        final Context context,
            return new IngestionSource.Builder(ingestionSourceType).setParams(ingestionSourceParams)
     * Setting this to 0 disables pointer-based lag calculation entirely.  
        this.initialRecoveryFilters = initialRecoveryFilters;
import org.opensearch.Version;
        return Setting.intSetting(
        }  
            if (in.getVersion().before(Version.V_3_6_0)) {
        "index.number_of_routing_shards",  
            } else if (id == 1) {
                INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING.get(settings),  
        }
        1000,
                        builder.aliasesVersion(parser.longValue());  
         * returns the primary term for the given shard.
        public Builder primaryTerm(int shardId, long primaryTerm) {  
        public Builder splitShardsMetadata(SplitShardsMetadata splitShardsMetadata) {
                            } else if (token == XContentParser.Token.START_OBJECT) {
        if (in.getVersion().onOrAfter(Version.V_3_6_0)) {
        SETTING_INGESTION_SOURCE_WARMUP_LAG_THRESHOLD,  
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
        }
            public void validate(final String value) {}
    );
    }
                    // Validate that remote store is enabled when this setting is used
         * index creation request. */
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
     * information is typically useful for backward compatibility.  
    );
     * <p>  
        key -> new Setting<>(key, "", (value) -> {
                    }
     * A value of 0 means fully caught up (no lag).
        SEARCH_ONLY("search_only", INDEX_SEARCH_ONLY_BLOCK);
            throw new IllegalArgumentException(  
        }
                )
        return this.indexTotalShardsPerNodeLimit;
    private final Context context;
    private final DiscoveryNodeFilters includeFilters;
                INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING.get(settings)
                                throw new IllegalArgumentException("Unexpected token: " + token);  
                                throw new IllegalArgumentException("Unexpected token: " + token);  
                                if (mapping.size() == 1) {
            @Override  
        this.routingNumShards = routingNumShards;
                new MappingMetadata(
    public static final Setting<Integer> INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING = Setting.intSetting(  
     * Note: Virtual Shards uses range-based mapping (e.g., {@code vShardId / (V / P)}) to route to
            final int numProcessorThreads = INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING.get(settings);
                MappingMetadata mmd = indexMetadata.mapping();
    /**
        return splitShardsMetadata;  
    public static final Setting<Boolean> INDEX_BLOCKS_READ_SETTING = APIBlock.READ.setting();
                        "Replication type "
        }
            );
            return false;  
        if (versionUpgraded != null) {
     * This method is used to display the settings in a human readable format in REST API
     * every writer acknowledges through the remote translog upload path, and a docrep-backed writer during
     * @throws IllegalArgumentException if the number of source shards is less than the number of target shards or if the source shards
    public static final String SETTING_INGESTION_SOURCE_ALL_ACTIVE_INGESTION = "index.ingestion_source.all_active";  
        Property.IndexScope,  
        SETTING_DATA_PATH,
                                + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
    /**
                    builder.value(cursor);
    public static final String INGESTION_SOURCE_KEY = "ingestion_source";
        long[] terms = new long[numberOfShards];  
        READ_ONLY("read_only", INDEX_READ_ONLY_BLOCK),
    public SplitShardsMetadata getSplitShardsMetadata() {
        INDEX_ROUTING_EXCLUDE_GROUP_PREFIX + ".",
    );
     * A diff of index metadata.
    public static final Setting<String> INDEX_RESIZE_SOURCE_NAME = Setting.simpleString(INDEX_RESIZE_SOURCE_NAME_KEY);  
            mappings = DiffableUtils.diff(before.mappings, after.mappings, DiffableUtils.getStringKeySerializer());
     * @opensearch.internal  
    }  
                return StreamPoller.ResetState.RESET_BY_OFFSET.name().equalsIgnoreCase(value)  
        return this.state;
            return this;
            }
            if (parser.currentToken() == null) { // fresh parser? move to the first token  
    }  
        }  
        }
                    throw new IllegalArgumentException(
    }
        "remote index is read-only",  
            for (final Map.Entry<Integer, Long> cursor : indexMetadata.primaryTermsMap.entrySet()) {
 * this file be licensed under the Apache-2.0 license or a
                splitMetadata.writeTo(out);
        Long creationDate = settings.getAsLong(SETTING_CREATION_DATE, null);
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.indices.pollingingest.IngestionErrorStrategy;
        }
    }
            Metadata.XContentContext context = Metadata.XContentContext.valueOf(  
    static final String KEY_SPLIT_SHARDS_METADATA = "split_shards_metadata";  
    public static int parseIndexNameCounter(String indexName) {  
        Property.Dynamic
            public void validate(final String value, final Map<Setting<?>, Object> settings) {  
    /**
            .append(state)  
    public Index getResizeSourceIndex() {
        if (!Objects.equals(splitShardsMetadata, that.splitShardsMetadata)) {
                    if (KEY_SETTINGS.equals(currentFieldName)) {
    public Map<String, RolloverInfo> getRolloverInfos() {
                    + " ["  
    public static final Setting<Integer> INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING = Setting.intSetting(
        public int getRoutingNumShards() {
                            + "] must be >= number of shards ["
            final long maxPollSize = INGESTION_SOURCE_MAX_POLL_SIZE.get(settings);
    /**  
    }  
     */
        public Builder routingPartitionSize(int routingPartitionSize) {
            } else {  
     */  
            );
     * @opensearch.api
    }
        final Map<String, RolloverInfo> rolloverInfos,
     */
        int numSourceShards = sourceIndexMetadata.getNumberOfShards();  
    /**  
            }
            this.inSyncAllocationIds = new HashMap<>();
            .append(customData)
        private final long settingsVersion;
    /**
            assert primaryTerms != null;  
        if (INDEX_UUID_NA_VALUE.equals(otherUUID) || INDEX_UUID_NA_VALUE.equals(getIndexUUID())) {
            return false;
        int numSourceShards = sourceIndexMetadata.getNumberOfShards();
                            token = parser.nextToken();
     * ({@code FenceAutoRestore.tla} refutes the ungated design).
    public static final Setting<Integer> INDEX_NUMBER_OF_VIRTUAL_SHARDS_SETTING = Setting.intSetting(  
import org.opensearch.cluster.Diffable;
            cursor.getValue().writeTo(out);  
        new Setting.Validator<>() {  
                    throw new IllegalArgumentException(
    static final String KEY_MAPPINGS = "mappings";
            if (indexMetadata.getCreationVersion().onOrAfter(Version.V_3_3_0) && indexMetadata.ingestionStatus != null) {
    );  
        assert settingsVersion >= 0 : settingsVersion;  
    }
            @Override  
    /**
            out.writeVLong(mappingVersion);  
        builder.state(State.fromId(in.readByte()));
    public static final Setting<String> INGESTION_SOURCE_DECODER_TYPE_SETTING = Setting.simpleString(  
            .append(", state=")
     * @return a the source shard ID to clone from
            public Iterator<Setting<?>> settings() {
import java.util.concurrent.TimeUnit;  
                            }
    }
        if (o == null || getClass() != o.getClass()) {
            this.aliases = new HashMap<>();
    }
                if (value == null || value.isEmpty()) {
import org.opensearch.core.common.io.stream.Writeable;
                        // the type name is the root value, reduce it
        }
        }
            }
        final int routingNumShards,
        return mappingVersion;  
        ReplicationType.DOCUMENT.toString(),
                return CLOSE;
    /**
        }
    public static final String INGESTION_STATUS_KEY = "ingestion_status";
        } else {
            inSyncAllocationIds = DiffableUtils.readJdkMapDiff(
    static final String KEY_SYSTEM = "system";
            @Override
        public String settingName() {  
                                + " is set to true"  
    public static Builder builder(IndexMetadata indexMetadata) {
        Property.PrivateIndex,
    /**
     * E.g.
                for (int shardId = 0; shardId < primaryTerms.length; shardId++) {  
        Property.IndexScope,  
            return this;
        if (pTerm == null) {
                if (!isValidResetState(value)) {
    public static final String SETTING_INDEX_APPEND_ONLY_ENABLED = "index.append_only.enabled";
        }  
    }  
        int routingFactor = getRoutingFactor(sourceIndexMetadata.getNumberOfShards(), numTargetShards);  
                context = null;  
        for (final MappingMetadata cursor : mappings.values()) {  
            }  
                primaryTermsMapFromArray.put(shardId, primaryTerms[shardId]);  
    /**
        Property.Final
            public Iterator<Setting<?>> settings() {
                if (value == null || value.isEmpty()) {  
            builder.inSyncAllocationIds.putAll(inSyncAllocationIds.apply(part.inSyncAllocationIds));  
            customData = DiffableUtils.diff(before.customData, after.customData, DiffableUtils.getStringKeySerializer());
                indexUpgradedVersion,
    private final int indexTotalRemoteCapablePrimaryShardsPerNodeLimit;
     */  
            .append(routingNumShards)  
        SETTING_CREATION_DATE,
        this.includeFilters = includeFilters;
    public int getIndexTotalRemoteCapableShardsPerNodeLimit() {
        return waitForActiveShards;
            if (in.getVersion().onOrAfter(Version.V_3_6_0)) {
        if (defaultNumShards < 1 || defaultNumShards > maxNumShards) {
        }
     * Return the {@link Version} on which this index has been created. This  
                            + ReplicationType.SEGMENT  
        public Builder system(boolean system) {
    @PublicApi(since = "1.0.0")
                return StreamPoller.ResetState.LATEST.name().equalsIgnoreCase(value)  
        Property.Dynamic  
    public static final String SETTING_REPLICATION_TYPE = "index.replication.type";
            this.rolloverInfos = new HashMap<>();
                    + " source shards ("
    /**
            return aliasesVersion;
        if (rolloverInfos.equals(that.rolloverInfos) == false) {
                long[] primaryTermsArray = new long[numShards];
                .setPointerInitReset(pointerInitReset)
        public boolean isSystem() {  
                builder.startObject(KEY_SPLIT_SHARDS_METADATA);  
        builder.version(in.readLong());  
                                    builder.putMapping(new MappingMetadata(mappingType, mapping));  
                boolean isPullBasedIngestionEnabled = NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType) == false;
    );  
     * <p>
            final boolean allActiveIngestionEnabled = INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.get(settings);  
     * "modulo": each shard consumes all partitions where partition % numShards == shardId.
                for (int shard = 0; shard < indexMetadata.getNumberOfShards(); shard++) {  
    private final DiscoveryNodeFilters requireFilters;  
                                + " prevents it from acknowledging writes the restored copy will never see"
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
            boolean aliasesVersion = false;  
import java.util.TreeSet;
        }
                mappings.put(mappingMd.type(), mappingMd);
    public static final String REMOTE_STORE_CUSTOM_KEY = "remote_store";  
        public Builder numberOfShards(int numberOfShards) {
        false,  
import org.opensearch.common.xcontent.XContentHelper;
    /**
    }  
                        builder.state(State.fromString(parser.text()));
                builder.splitShardsMetadata(splitMetadata.apply(part.splitShardsMetadata));  
     */
        out.writeBoolean(isSystem);
    public State getState() {
            return value;
        }  
            out.writeLong(version);
    /**
                    return block;  
            aliasesVersion = after.aliasesVersion;
            this.aliasesVersion = aliasesVersion;
        }
     * @param targetNumberOfShards the total number of shards in the target index  
        if (out.getVersion().before(Version.V_3_6_0)) {
                    );
            builder.mappings.putAll(mappings.apply(part.mappings));  
    public static final ClusterBlock INDEX_SEARCH_ONLY_BLOCK = new ClusterBlock(
        out.writeInt(routingNumShards);
            this.settings = settings;
import org.opensearch.cluster.node.DiscoveryNodeFilters;  
    }
                }
            final Map<String, Object> decoderSettings = INGESTION_SOURCE_DECODER_SETTINGS.getAsMap(settings);
        final int maxNumShards = Integer.parseInt(System.getProperty(MAX_NUMBER_OF_SHARDS, "1024"));
    );
     * Blocks the API.
                        builder.map(XContentHelper.convertToMap(mmd.source().uncompressed(), true).v2());
    public static final ClusterBlock INDEX_METADATA_BLOCK = new ClusterBlock(  
                            }
            .append(rolloverInfos)
                excludeFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, OR, excludeMap);
            return primaryTermsMap.getOrDefault(shardId, SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
import org.opensearch.cluster.DiffableUtils;  
            primaryTerms = in.readVLongArray();  
        -1,
            .append(", aliasesVersion=")
                .build();
    public boolean isSameUUID(String otherUUID) {
                    } else if (KEY_PRIMARY_TERMS_MAP.equals(currentFieldName)) {  
 * SPDX-License-Identifier: Apache-2.0
            @Override
    @Override
     * Used to specify the replication type for the index. By default, document replication is used.  
        }
     * Returns the routing factor for and shrunk index with the given number of target shards.  
     */  
    public static final String SETTING_NUMBER_OF_VIRTUAL_SHARDS = "index.number_of_virtual_shards";  
                            } else if (token == XContentParser.Token.START_ARRAY) {
            throw new IllegalArgumentException(message, e);
        "",  
        public Builder index(String index) {  
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.AND;
                    + "bulk adaptive shard selection is enabled, "
        public MappingMetadata mapping() {
        this.waitForActiveShards = waitForActiveShards;
            .append(inSyncAllocationIds)  
     * changes if and index is shrunk.  
        Property.PrivateIndex,
                indexMetadata.getSettings().toXContent(builder, params);
    private final int routingFactor;
    static final String KEY_ROLLOVER_INFOS = "rollover_info";
            for (int shardId = 0; shardId < primaryTerms.length; shardId++) {
    public static final String SETTING_INGESTION_SOURCE_DECODER_TYPE = "index.ingestion_source.decoder_type";
                    + "] must between "  
            index = in.readString();
            builder.field(KEY_ALIASES_VERSION, indexMetadata.getAliasesVersion());  
            routingNumShards = in.readInt();  
            return builder.build();  
        new Setting.Validator<>() {
import org.opensearch.core.rest.RestStatus;
            return mappings.get(MapperService.SINGLE_MAPPING_NAME);  
        false,
            );
            cursor.writeTo(out);  
                            + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
        if (routingFactor != that.routingFactor) {
        if (shardId >= numTargetShards) {
                            + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()  
        Property.Dynamic,
        out.writeVInt(aliases.size());
                        + numberOfShards()
        }
            public void validate(final String value) {}
    public static final String INDEX_ROUTING_INCLUDE_GROUP_PREFIX = "index.routing.allocation.include";  
        }
        return settings;  
        assert sourceIndexMetadata.getNumberOfShards() == 1 // special case - we can split into anything from 1 shard
                    filledInSyncAllocationIds.put(i, Collections.emptySet());
import org.opensearch.index.IndexSettings;
        }  
    );  
    @Nullable
        for (int i = 0; i < aliasesSize; i++) {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public static Builder builder(String index) {  
            mappingVersion = in.readVLong();
        final String ingestionSourceType = INGESTION_SOURCE_TYPE_SETTING.get(settings);
    public static final Setting<String> INGESTION_SOURCE_TYPE_SETTING = Setting.simpleString(
    public int getRoutingNumShards() {
        RestStatus.FORBIDDEN,
            builder.field(KEY_STATE, indexMetadata.getState().toString().toLowerCase(Locale.ENGLISH));  
        return this.version;
                                String mappingType = currentFieldName;  
            @Override
                                builder.putInSyncAllocationIds(Integer.valueOf(shardId), allocationIds);
            return Integer.parseInt(  
        IngestionSource.SourcePartitionStrategy.SIMPLE.getName(),
        SETTING_INGESTION_SOURCE_MAX_POLL_SIZE,
            assert mappingVersion : "mapping version should be present for indices";
                        );
            return this;  
        out.writeMap(customData, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));  
            throw new IllegalArgumentException(
     */
    }  
        13,
        for (final MappingMetadata cursor : mappings.values()) {
                        );
            } else {
                }
        Setting.Property.IndexScope
            public void validate(final Integer value) {  
            this.isSystem = system;
                            } else {
     * This factor is used in the hash function in
        false,  
        Long pTerm = this.primaryTermsMap.get(shardId);
    }
     * @return the number of virtual shards or -1
        if (version != that.version) {
                if (numberOfVirtualShards < numberOfShards) {
            final int numberOfVirtualShards = INDEX_NUMBER_OF_VIRTUAL_SHARDS_SETTING.get(settings);
            this.index = index;
                indexTotalRemoteCapablePrimaryShardsPerNodeLimit,
        RestStatus.FORBIDDEN,  
            );
import org.opensearch.core.common.Strings;  
            if (token != XContentParser.Token.START_OBJECT) {
        100000,
        final long aliasesVersion,  
    );  
                    } else if (KEY_MAPPING_VERSION.equals(currentFieldName)) {
                        "index.number_of_routing_shards [" + numRoutingShards + "] must be >= index.number_of_shards [" + numShards + "]"  
            boolean mappingVersion = false;
        }  
        Property.IndexScope,  
     * Returns the number of shards that should be used for routing. This basically defines the hash space we use in  
        }
                "the number of target shards ["
     *  
    public static final String SETTING_BLOCKS_METADATA = APIBlock.METADATA.settingName();
        }  
         * 99% of the users have less than 1024 shards per index. We also make it a hard check that requires restart of nodes
                builder.endArray();  
        public IngestionStatus getIngestionStatus() {  
        IngestionErrorStrategy.ErrorStrategy.DROP.name(),
        false,  
        @Override  
                // onwards.  
    );
        }
                if (inSyncAllocationIds.containsKey(i)) {
        Property.IndexScope
        SETTING_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED,
            this.settings = indexMetadata.getSettings();
     * @return ingestion source, or null if ingestion source is not enabled
     * {@link org.opensearch.cluster.routing.OperationRouting#generateShardId(IndexMetadata, String, String)} to guarantee consistent
        }
        private final Map<String, AliasMetadata> aliases;
            aliases.clear();  
     * membership view, and the departed primary is typically still alive behind a partition, still able to reach the
    }
            }
    public static final String SETTING_INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL =
@PublicApi(since = "1.0.0")  
        }
    private final Version indexUpgradedVersion;  
                            + ReplicationType.DOCUMENT
        "index metadata (api)",
        public void writeTo(StreamOutput out) throws IOException {
            builder.mappingVersion(mappingVersion);
    );
    public static final Setting<Boolean> INDEX_HIDDEN_SETTING = Setting.boolSetting(
     * restore point impossible; without it the trigger loses acknowledged writes  
            return Collections.singleton(selectCloneShard(shardId, sourceIndexMetadata, numTargetShards));  
    public static final Setting<TimeValue> INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING = Setting.timeSetting(
        return this.customData.get(key);
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;
            return settings.getAsInt(SETTING_NUMBER_OF_SHARDS, -1);  
                tmpAliases,  
    );
            if (out.getVersion().onOrAfter(Version.V_3_0_0)) {  
            assert aliasesVersion : "aliases version should be present for indices";  
        Property.IndexScope,  
        public Builder context(Context context) {
    @Override
        1000,
    private static final String INDEX_FORMAT = "index.format";
            if (primaryTermsMap.isEmpty()) {
        }
import java.util.Iterator;
                        "Setting "  
            }  
        "index.remote_store.segment.path_prefix",
        out.writeInt(routingNumShards);
 * software distributed under the License is distributed on an
    public static final String SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED = "index.remote_store.auto_restore.enabled";
        return ingestionSourceType != null && !(NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType));
                final Object replicationType = settings.get(INDEX_REPLICATION_TYPE_SETTING);
            this.version = indexMetadata.version;  
 * specific language governing permissions and limitations
    public Version getUpgradedVersion() {
                    + ")"
        }  
     */
    public int getTotalNumberOfShards() {
        final int indexTotalRemoteCapableShardsPerNodeLimit,
    public int getNumberOfVirtualShards() {  
                    + numSourceShards
                settings
        Property.IndexScope,
                indexTotalRemoteCapableShardsPerNodeLimit,
                    } else if ("warmers".equals(currentFieldName)) {
    public static final Setting<Long> SETTING_INDEX_CREATION_DATE = Setting.longSetting(  
 * compatible open source license.
    private final Map<Integer, Set<String>> inSyncAllocationIds;
            .toString();  
     */
    public static final Setting.AffixSetting<String> INDEX_ROUTING_EXCLUDE_GROUP_SETTING = Setting.prefixKeySetting(
        private Settings settings = Settings.Builder.EMPTY_SETTINGS;
    public static final String SETTING_NUMBER_OF_REPLICAS = "index.number_of_replicas";
    public boolean isRemoteSnapshot() {
                if (ReplicationType.SEGMENT.equals(value) == false && Objects.equals(remoteStoreEnabled, true)) {  
            if ("open".equals(state)) {
    @Override  
 * KIND, either express or implied.  See the License for the
    public static ShardId selectCloneShard(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {
        8,
    private final int routingPartitionSize;
            indexVersion = SETTING_INDEX_VERSION_CREATED.get(indexSettings);
    );  
        Property.IndexScope,
        Version.V_EMPTY,
    public static final Setting<IngestionErrorStrategy.ErrorStrategy> INGESTION_SOURCE_ERROR_STRATEGY_SETTING = new Setting<>(
            final int numberOfSearchReplicas = INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(settings);
            return this;  
            state = State.fromId(in.readByte());
     * Returns the source shard ID to clone the given target shard off  
        result = 31 * result + Objects.hashCode(context);
    public void writeTo(StreamOutput out) throws IOException {
            .append(isSystem)
        // note: if the number of shards is 1 in the source index we can just assume it's correct since from 1 we can split into anything  
            @Override
        @Override
    public static final Setting<Boolean> INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED = Setting.boolSetting(  
         * per cluster. this also prevents creating stuff like a new index with millions of shards by accident which essentially  
        return indexVersion;
            return selectShrinkShards(shardId, sourceIndexMetadata, numTargetShards);
            out.writeVInt(ordinal());
    public static final Setting<Integer> INDEX_ROUTING_PARTITION_SIZE_SETTING = Setting.intSetting(
     *
        "1",  
        for (final Map.Entry<String, DiffableStringMap> cursor : customData.entrySet()) {
    public static final ClusterBlock INDEX_WRITE_BLOCK = new ClusterBlock(  
                        + "] but should be equal to number of shards ["
import org.opensearch.common.settings.Settings;  
         * @return the provided value or -1 if it has not been set.  
        this.routingFactor = routingNumShards / numberOfShards;
import org.opensearch.core.index.shard.ShardId;
                builder.endArray();  
        }
                builder.endObject();
     * object store. The fence's strictly-greater-term takeover is what makes acknowledging past the restored copy's
    public IngestionSource getIngestionSource() {  
        /* This is a safety limit that should only be exceeded in very rare and special cases. The assumption is that  
        0,  
import java.util.HashMap;  
            customData.writeTo(out);
            }
        if (in.getVersion().before(Version.V_3_6_0)) {
    }  
     * Defines the strategy for mapping source stream partitions to OpenSearch shards.  
            cursor.writeTo(out);  
            }  
    }  
            Property.Final,
        this.settings = settings;
                    throw new IllegalArgumentException(  
}
                            + ReplicationType.SEGMENT  
    }
     */
        Setting.Property.Final
     * Builds a primaryTerms long array from primaryTermsMap for backward-compatible wire serialization
        FORMAT_PARAMS = new MapParams(params);  
 * GitHub history for details.
        out.writeVLong(settingsVersion);
        out.writeLong(version);  
    );  
        }  
                "the number of source shards ["
    }
            }
        if (shardId >= numTargetShards) {
        new Setting.Validator<>() {
                            + INDEX_REPLICATION_TYPE_SETTING.getKey()
    );
        final long mappingVersion,
        result = 31 * result + mappings.hashCode();  
    public int getIndexTotalPrimaryShardsPerNodeLimit() {
                        // assume it's custom index metadata  
                                throw new IllegalArgumentException("Unexpected token: " + token);
                            if (token == XContentParser.Token.FIELD_NAME) {
        final Boolean isRemoteSegmentStoreEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_ENABLED_SETTING);  
    @Nullable
    public static Diff<IndexMetadata> readDiffFrom(StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            public Iterator<Setting<?>> settings() {
public class IndexMetadata implements Diffable<IndexMetadata>, ToXContentFragment, VerifiableWriteable {
    /**
         * for this index.  
        "index.routing.allocation.initial_recovery.",  
                    + ") must be the same as the number of"
    public static final String SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY = "index.remote_store.translog.repository";
                    + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()  
            this.mappingVersion = indexMetadata.mappingVersion;
        builder.system(in.readBoolean());
        }  
    }
            return this;
            String currentFieldName = null;
    );  
        false,
                .setPointerBasedLagUpdateInterval(pointerBasedLagUpdateInterval)  
            final ActiveShardCount waitForActiveShards = SETTING_WAIT_FOR_ACTIVE_SHARDS.get(settings);
        Settings.Builder builder = Settings.builder().put(settings);
    );
    );
        Property.IndexScope,
            final IngestionSource.WarmupConfig warmupConfig = new IngestionSource.WarmupConfig(
            this.customMetadata = new HashMap<>(indexMetadata.customData);
     *  
        },
            final int indexTotalRemoteCapablePrimaryShardsPerNodeLimit =  
                    Map<String, Object> mapping = XContentHelper.convertToMap(mmd.source().uncompressed(), false).v2();  
            return this;  
 */  
                            + "] must be a multiple of number of shards ["
                throw new IllegalArgumentException(
    );  
        return otherUUID.equals(getIndexUUID());
                    builder.field(Integer.toString(shard), indexMetadata.primaryTerm(shard));
                    }
import org.opensearch.action.support.ActiveShardCount;  
            throw new IllegalArgumentException(
import static org.opensearch.cluster.node.DiscoveryNodeFilters.IP_VALIDATOR;
            return false;  
            mappings = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), MAPPING_DIFF_VALUE_READER);
            public void validate(final Boolean value) {}  
                            }
        result = 31 * result + inSyncAllocationIds.hashCode();
    /**
        Property.IndexScope,
    }
                ingestionStatus = in.readOptionalWriteable(IngestionStatus::new);  
                state,  
    public static final String REMOTE_STORE_SSE_ENABLED_INDEX_KEY = "sse_enabled_index";
        EnumSet.of(ClusterBlockLevel.WRITE, ClusterBlockLevel.METADATA_WRITE)
    );  
        RestStatus.FORBIDDEN,  
import org.opensearch.core.common.io.stream.VerifiableWriteable;
            }
        public Builder aliasesVersion(final long aliasesVersion) {
                        final List<Long> list = new ArrayList<>();
    }  
                    "routing partition size ["  
        private Map<Integer, Long> primaryTermsMap = new HashMap<>();
        new Setting.Validator<>() {
                pointerInitResetType,
     * Used to specify a custom path prefix for remote store segments. This allows injecting a unique identifier  
        public Map<String, String> removeCustom(String type) {  
            return settings(settings.build());  
                }
            final IngestionSource.SourcePartitionStrategy sourcePartitionStrategy = INGESTION_SOURCE_PARTITION_STRATEGY_SETTING.get(  
        long[] primaryTerms = null;
            return false;  
     * Must not be enabled for an index migrating between document replication and remote store: fencing assumes
            builder.putMapping(mappingMd);
    public static final Setting<TimeValue> INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING = Setting.positiveTimeSetting(
     */  
            return settingsVersion;
    /**
            }
    public static final Setting.AffixSetting<String> INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING = Setting.prefixKeySetting(
                        + waitForActiveShards
        return this.indexTotalRemoteCapableShardsPerNodeLimit;
     */
                    + "] is not append-only index, "  
    );  
                .setBlockingQueueSize(blockingQueueSize)
     * {@link org.opensearch.cluster.routing.OperationRouting#generateShardId(IndexMetadata, String, String)} to route documents
            }  
            .append(context)  
     * Defines if all-active pull-based ingestion is enabled. In this mode, replicas will directly consume from the
            }
                "index with UUID [%s] created on version [%s] is not supported by version [%s]",  
    }  
                }
     */
        final int indexTotalRemoteCapablePrimaryShardsPerNodeLimit,  
            }  
            }
        }
     */  
                mappings,
        Setting.Property.Dynamic,
        }
        return shards;
            if (requireMap.isEmpty()) {  
                            + INDEX_REPLICATION_TYPE_SETTING.getKey()
            );
                    }
                requireFilters = null;
        } catch (NumberFormatException e) {  
     **/
            }
        false,
        7,
            }
                if (isPullBasedIngestionEnabled && ReplicationType.DOCUMENT.equals(replicationType) && value == false) {
                routingPartitionSize,
            inSyncAllocationIds,
        int result = index.hashCode();
            }
import org.opensearch.index.IndexModule;  
        }
        if (routingNumShards % numTargetShards != 0) {
        private IngestionStatus ingestionStatus;
    /**  
    }
                // Only validate if the value is not null and not empty
                                + INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.getKey()
    @Override  
        }
            return cursor;
            @Override  
            .append(", version=")  
    public static final String SETTING_REMOTE_STORE_ENABLED = "index.remote_store.enabled";
        RestStatus.TOO_MANY_REQUESTS,  
                    throw new IllegalArgumentException(
                return settings.iterator();
                primaryTermsMap = in.readMap(StreamInput::readInt, StreamInput::readLong);
        @Override
                    } else if (KEY_SETTINGS_VERSION.equals(currentFieldName)) {
 * license agreements. See the NOTICE file distributed with
     * held it. When enabled, the allocator converts a primary it has proven unrecoverable from any live node's local
        final Version indexUpgradedVersion,  
            return new IndexMetadata(  
                    }
    /**
        }
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
            cursor.writeTo(out);
     * <p>  
         * if a cluster should allow to create more than 1024 shards per index. NOTE: this does not limit the number of shards
            final boolean isAppendOnlyIndex = INDEX_APPEND_ONLY_ENABLED_SETTING.exists(settings)
     */
        result = 31 * result + customData.hashCode();
                    );  
        SETTING_NUMBER_OF_REPLICAS,
        final Map<Integer, Long> primaryTermsMap
            @Override
                }  
     * <p>
                }
                            if (token == XContentParser.Token.FIELD_NAME) {  
        }
        5,
                final List<Setting<?>> settings = List.of(INDEX_REPLICATION_TYPE_SETTING, INGESTION_SOURCE_TYPE_SETTING);
                            + ReplicationType.SEGMENT
                            + " is not supported in pull-based ingestion when "
    }
                            + "] for ["
                            + INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.getKey()
        }
        false,
 * @opensearch.api
    public static final String SETTING_VERSION_CREATED = "index.version.created";  
        "index.priority",  
                    + "] must be less that the number of source shards ["
        SETTING_INGESTION_SOURCE_MAPPER_TYPE,
    static {
        public Builder creationDate(long creationDate) {  
        }
    }
            if (numberOfVirtualShards != -1) {  
            for (final Map.Entry<Integer, Set<String>> cursor : indexMetadata.inSyncAllocationIds.entrySet()) {
                        builder.context(Context.fromXContent(parser));
     *  
        },  
        int numberIndex = indexName.lastIndexOf("-");
            builder.field(KEY_SETTINGS_VERSION, indexMetadata.getSettingsVersion());
    /**
                    } else if (KEY_ALIASES_VERSION.equals(currentFieldName)) {
            }
                    return block;  
            out.writeOptionalWriteable(ingestionStatus);  
            factor = sourceNumberOfShards / targetNumberOfShards;  
        assert getIndexUUID() != null;  
            }
                        aliasesVersion = true;
            return false;  
            for (int i = 0; i < numberOfShards; i++) {  
        SETTING_NUMBER_OF_VIRTUAL_SHARDS,
                initialRecoveryFilters = null;
                            + ", "  
                            }
                e.getVersionString(),
                    + numSourceShards  
            );
    }  
            private boolean isValidResetState(String value) {
                    );
import java.util.Objects;  
        new TimeValue(10, TimeUnit.SECONDS),  
            }
    public static final Setting<Long> INGESTION_SOURCE_MAX_POLL_SIZE = Setting.longSetting(  
            }
     * Selects the source shards for a local shard recovery. This might either be a split or a shrink operation.  
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
        );
     * Used to specify the type for the ingestion index. If not specified, the ingestion source not enabled
        for (int i = 0; i < mappingsSize; i++) {  
            if (out.getVersion().onOrAfter(Version.V_2_17_0)) {  
    }  
                }
     */
                            + INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey()  
    // Block ID and block for scale operations (IDs 20-29 reserved for scaling)
                            + " should be set to "
        Property.UnmodifiableOnRestore
        final Map<String, DiffableStringMap> customData,
        }
        final long version,  
                    if (KEY_MAPPINGS.equals(currentFieldName)) {
        9,
    /**
        result = 31 * result + aliases.hashCode();
    private final int indexTotalRemoteCapableShardsPerNodeLimit;  
                .setWarmupConfig(warmupConfig)  
                builder.startArray(KEY_MAPPINGS);
     */
        private void initializePrimaryTerms() {  
        RestStatus.FORBIDDEN,  
        }
        int inSyncAllocationIdsSize = in.readVInt();  
                        assert Version.CURRENT.major <= 5;
                    } else if (KEY_VERSION.equals(currentFieldName)) {
                    } else if (KEY_PRIMARY_TERMS.equals(currentFieldName)) {
                                }
        }
        } else {  
        public Builder putCustom(String type, Map<String, String> customIndexMetadata) {
    }  
     * Defines the pointer-based lag update interval for pull-based ingestion.
    }  
            if (out.getVersion().onOrAfter(Version.V_3_6_0)) {
        }
        result = 31 * result + Long.hashCode(version);
            this.ingestionStatus = ingestionStatus;
    }  
        public static APIBlock readFrom(StreamInput input) throws IOException {
            } else if (primaryTermsMap.size() != numberOfShards) {  
                if (ReplicationType.SEGMENT.equals(replicationType) == false && value) {
        public Builder settingsVersion(final long settingsVersion) {
            );  
        builder.mappingVersion(in.readVLong());
            .append(", isSystem=")  
            }  
                            + INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getKey()
                includeFilters = DiscoveryNodeFilters.buildOrUpdateFromKeyValue(null, OR, includeMap);
    private final State state;
        Property.Final
            aliases.remove(alias);
    private final Map<String, DiffableStringMap> customData;  
        0,  
        false,
        ActiveShardCount::parseString,
        this.splitShardsMetadata = splitShardsMetadata;
        public Set<String> getInSyncAllocationIds(int shardId) {
            builder.endObject();
    public static final Setting<String> INDEX_DATA_PATH_SETTING = new Setting<>(
        SETTING_HISTORY_UUID,
                if (token == XContentParser.Token.FIELD_NAME) {
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.get(settings);
        }
                    } else if (KEY_MAPPINGS.equals(currentFieldName)) {
        }
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.IndexScope)
                }
                        primaryTermsArray[entry.getKey()] = entry.getValue();
            @Override
                builder.endArray();  
        }
        Property.IndexScope,
                    + sourceIndexMetadata.getNumberOfShards()
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
            out.writeInt(routingNumShards);
        public IndexMetadata build() {
        result = 31 * result + primaryTermsMap.hashCode();
        }
            builder.aliases.putAll(aliases.apply(part.aliases));
                    );
/*  
            final IngestionMessageMapper.MapperType mapperType = INGESTION_SOURCE_MAPPER_TYPE_SETTING.get(settings);
            } else {
    /**
        final IngestionStatus ingestionStatus,  
    public static final Setting<String> SETTING_INDEX_HISTORY_UUID = Setting.simpleString(  
            return this;
                }
        final int numberOfReplicas,  
        Property.IndexScope
    );  
        }
            return mappingVersion;
        @Override
                throw new IllegalStateException("you must set the number of shards before setting/reading primary terms");  
    /**
        if (!primaryTermsMap.equals(that.primaryTermsMap)) {
        true,  
                        // TODO: This was removed in 2015. We should throw an exception in OpenSearch 4.0.
        }
            out.writeVLongArray(buildPrimaryTermsArray());
            return value;
    public static final String INDEX_STATE_FILE_PREFIX = "state-";
            mappings.clear();
                final List<Setting<?>> settings = Collections.singletonList(INDEX_NUMBER_OF_SHARDS_SETTING);
            return true;
     * Defines how the incoming ingestion message payload is mapped to the internal message format.  
            this.version = version;
                excludeFilters = null;  
                splitMetadata = null;
            }
    private static void assertSplitMetadata(int numSourceShards, int numTargetShards, IndexMetadata sourceIndexMetadata) {
                } else {  
        SETTING_INGESTION_SOURCE_INTERNAL_QUEUE_SIZE,
                indexSettings.get(IndexMetadata.SETTING_INDEX_UUID),
        }  
                SETTING_INDEX_VERSION_CREATED.getKey(),
            } else {
            }
        for (final Map.Entry<Integer, Set<String>> cursor : inSyncAllocationIds.entrySet()) {  
                        "number of virtual shards ["  
                } else if (token.isValue()) {
            }  
        return numberOfSearchOnlyReplicas;  
                        + primaryTermsMap.size()  
        SETTING_REMOTE_STORE_FENCING_ENABLED,
    public static final String INDEX_UUID_NA_VALUE = Strings.UNKNOWN_UUID_VALUE;
     */
        public Builder version(long version) {
                    );
        Property.Final  
     * @param shardId             the target shard ID to select the source shards for
        return requireFilters;
        false,
            this.settingName = "index.blocks." + name;
        /* This property should be provided if the default number of shards for any new index has to be changed to a value  
            if (context != Metadata.XContentContext.API) {  
        return includeFilters;  
                                + INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING.getKey()
            aliases.put(aliasMetadata.alias(), aliasMetadata);  
        return indexCreatedVersion;
            }
            }
                    } else if (KEY_SPLIT_SHARDS_METADATA.equals(currentFieldName)) {
            isSystem = in.readBoolean();
        return settings.getAsInt(SETTING_NUMBER_OF_VIRTUAL_SHARDS, -1);
        1,
            boolean settingsVersion = false;
            this.splitShardsMetadata = splitShardsMetadata;
            settingsVersion = in.readVLong();  
            return this;  
        Property.PrivateIndex,
                excludeFilters,  
            builder.field(KEY_MAPPING_VERSION, indexMetadata.getMappingVersion());
            return this;
     * Returns the configured {@link #SETTING_WAIT_FOR_ACTIVE_SHARDS}, which defaults
import org.opensearch.common.compress.CompressedXContent;  
                                + SETTING_REMOTE_STORE_FENCING_ENABLED
            if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
                    } else if (CONTEXT_KEY.equals(currentFieldName)) {  
        }
        }  
        return numberOfShards;  
        IndexMetadataDiff(IndexMetadata before, IndexMetadata after) {
        result = 31 * result + Long.hashCode(routingFactor);
        private final Map<Integer, Set<String>> inSyncAllocationIds;  
        }
     */
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
            } else {
    );
    public static final String SETTING_VERSION_UPGRADED_STRING = "index.version.upgraded_string";  
     * Returns the number of virtual shards for this index.
    public int getIndexTotalShardsPerNodeLimit() {  
                }
    private final Map<String, AliasMetadata> aliases;  
    Map<String, DiffableStringMap> getCustomData() {
        new Setting.Validator<>() {
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            @Override  
                    + MAX_NUMBER_OF_SHARDS
                return settings.iterator();
        false,
        APIBlock(String name, ClusterBlock block) {
        private final boolean isSystem;
        }
                            if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {  
        this.index = index;
        Version version = SETTING_INDEX_VERSION_CREATED.get(settings);
        if (indexVersion.equals(Version.V_EMPTY)) {
    public String getIndexUUID() {  
        Setting.Property.IndexScope  
                }  
import org.opensearch.core.xcontent.XContentBuilder;  
        Property.IndexScope,
                                builder.putRolloverInfo(RolloverInfo.parse(parser, currentFieldName));
        false,
        private State state = State.OPEN;
        }
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.IndexScope)
        }  
            String key = in.readString();
                            "Setting "
    public static final Setting.AffixSetting<String> INDEX_ROUTING_REQUIRE_GROUP_SETTING = Setting.prefixKeySetting(
        private final Diff<SplitShardsMetadata> splitMetadata;
                indexSettings.get(IndexMetadata.SETTING_INDEX_UUID)  
     */
            builder.setRoutingNumShards(routingNumShards);
        }
        return new ShardId(sourceIndexMetadata.getIndex(), shardId / routingFactor);
    );  
        1,  
    }
    public static final Setting<String> INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING = Setting.simpleString(  
        public Builder ingestionStatus(IngestionStatus ingestionStatus) {
                        + "]"
     * Used to specify remote store repository to use for this index.
        }
 */  
                } else {
            this.block = block;  
                    || StreamPoller.ResetState.RESET_BY_TIMESTAMP.name().equalsIgnoreCase(value);
        SETTING_INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL,
            return this;  
     */
     * This looks for the presence of the {@link Version} object with key {@link IndexMetadata#SETTING_VERSION_CREATED}  
        100L,
                        settingsVersion = true;
        out.writeVInt(mappings.size());
        return numberOfReplicas;
        SETTING_INGESTION_SOURCE_ERROR_STRATEGY,  
     */
    );
                builder.field(INGESTION_STATUS_KEY);
        Property.PrivateIndex,  
    }
/*
            : null;
        }
                for (final AliasMetadata cursor : indexMetadata.getAliases().values()) {  
                                + INDEX_REMOTE_STORE_ENABLED_SETTING.getKey()
            .append(", splitShardsMetadata=")  
        for (int i = 0; i < customSize; i++) {
        this.ingestionStatus = ingestionStatus;  
    private final DiscoveryNodeFilters initialRecoveryFilters;  
                            + numberOfVirtualShards  
                splitShardsMetadata = new SplitShardsMetadata.Builder(numberOfShards).build();  
     * @param sourceIndexMetadata the source index metadata
     *                                  are not divisible by the number of target shards.  
        Property.Final
                                        allocationIds.add(parser.text());
        }  
        /**  
            if (primaryTermsMap.isEmpty()) {
        if (state != that.state) {
            assert primaryTermsMap.isEmpty();
    @PublicApi(since = "1.0.0")  
        SETTING_INGESTION_SOURCE_PARTITION_STRATEGY,  
         * an index has changed ie if the index is shrunk.  
        this.customData = Collections.unmodifiableMap(customData);
    }
    );
            @Override  
        public Builder putInSyncAllocationIds(int shardId, Set<String> allocationIds) {
        int aliasesSize = in.readVInt();
     */
        0,
        /**
        private final Diff<Map<String, DiffableStringMap>> customData;
        return Builder.fromXContent(parser);  
            out.writeByte(state.id);  
        this.aliasesVersion = aliasesVersion;  
import org.opensearch.common.settings.Setting;
        } else {
        final boolean isSystem,
                includeFilters,
        public long settingsVersion() {  
            if (indexMetadata.context != null) {
            return builder.build();
    private final DiscoveryNodeFilters excludeFilters;
                params.param(CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API)
                        throw new IllegalArgumentException("Unexpected field for an array " + currentFieldName);  
                // TODO: validate this with the ingestion source params
            AliasMetadata aliasMd = new AliasMetadata(in);  
            return Builder.fromXContent(parser);
        new Setting.Validator<Integer>() {  
        1,  
        this.indexUpgradedVersion = indexUpgradedVersion;  
     * to pre-V_3_6_0 nodes.  
    private final boolean isRemoteSnapshot;
            new DiffableUtils.DiffableValueReader<>(AliasMetadata::new, AliasMetadata::readDiffFrom);
                        throw new IllegalArgumentException(
    public static final String SETTING_INDEX_HIDDEN = "index.hidden";  
            return this;
    static final String KEY_ALIASES_VERSION = "aliases_version";
            out.writeVLongArray(buildPrimaryTermsArray());
    public static ShardId selectSplitShard(int shardId, IndexMetadata sourceIndexMetadata, int numTargetShards) {
            builder.aliasesVersion(aliasesVersion);
            final String uuid = settings.get(SETTING_INDEX_UUID, INDEX_UUID_NA_VALUE);  
            primaryTermsMap.put(shardId, primaryTerm);
     *
                numberOfShards,
    public long primaryTerm(int shardId) {  
         */
            builder.putRolloverInfo(new RolloverInfo(in));
        Set<ShardId> shards = new HashSet<>(routingFactor);
                Map<Integer, Long> primaryTermsMap = new HashMap<>();
     * This block prevents write operations to the index while allowing read operations.
    @Override  
            }
            defaultNumShards,
        Builder builder = new Builder(in.readString());
                    }
                        + "]"
        if (numSourceShards != numTargetShards) {  
    public Set<String> inSyncAllocationIds(int shardId) {  
        public int numberOfShards() {
            @Override
                tmpSettings,
     * @param sourceIndexMetadata the source metadata  
    public static final String SETTING_INGESTION_SOURCE_INTERNAL_QUEUE_SIZE = "index.ingestion_source.internal_queue_size";
                builder.startObject(KEY_ALIASES);
            }  
        final DiscoveryNodeFilters requireFilters,
        Property.UnmodifiableOnRestore
    public static final Setting<Boolean> INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING = Setting.boolSetting(
    public Index getIndex() {
    );
    static class IndexMetadataDiff implements Diff<IndexMetadata> {
        return null;  
         * See {@link IndexMetadata#primaryTerm(int)} for more information.
     */
    static final String KEY_ALIASES = "aliases";  
        Property.Final
            return this;
        result = 31 * result + state.hashCode();  
        writeSettingsToStream(settings, out);  
        private void primaryTerms(long[] primaryTerms) {
        Property.IndexScope,  
    );
            .append(", settings=")
        }  
                    final Boolean fencingEnabled = (Boolean) settings.get(INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING);
                .setMapperSettings(mapperSettings)
        1,
    }
                    if (isRemoteTranslogStoreEnabled == null || isRemoteTranslogStoreEnabled == false) {  
 * under the License.  
                includeFilters = null;
        TimeValue.timeValueMillis(-1),
            .append(mappings)
        SETTING_INGESTION_SOURCE_DECODER_TYPE,
    static final String KEY_STATE = "state";
                int numShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);  
     * Parses the number from the rolled over index name. It also supports the date-math format (ie. index name is wrapped in &lt; and &gt;)
                final List<Setting<?>> settings = Collections.singletonList(INDEX_REMOTE_STORE_ENABLED_SETTING);
    public static final Setting.AffixSetting<Object> INGESTION_SOURCE_PARAMS_SETTING = Setting.prefixKeySetting(
        "index.ingestion_source.param.",
            public Iterator<Setting<?>> settings() {  
        private final Map<String, MappingMetadata> mappings;  
            version = after.version;
            final String decoderType = INGESTION_SOURCE_DECODER_TYPE_SETTING.get(settings);
     * and safe physical shard merging operations later in the lifecycle. The number of virtual shards  
            return this;
        final State state,
            ZonedDateTime creationDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(creationDate), ZoneOffset.UTC);  
            );  
        private final Context context;  
     * @throws IllegalArgumentException if the index doesn't contain a "-" separator or if the last token after the separator is not a  
            );
    public static final Setting.AffixSetting<Object> INGESTION_SOURCE_MAPPER_SETTINGS = Setting.prefixKeySetting(
        this.numberOfReplicas = numberOfReplicas;
                return settings.iterator();  
                indexMetadata.splitShardsMetadata.toXContent(builder, params);
        }  
    static final String KEY_MAPPING_VERSION = "mapping_version";
            IngestionSource.PointerInitReset pointerInitReset = new IngestionSource.PointerInitReset(
            }
    @Override  
    public int getIndexTotalRemoteCapablePrimaryShardsPerNodeLimit() {  
                isAppendOnlyIndex,  
            Version indexCreatedVersion = indexCreated(settings);
    public static final ClusterBlock REMOTE_READ_ONLY_ALLOW_DELETE = new ClusterBlock(
     * Returns the source shard ids to shrink into the given shard id.
        return settingsVersion;
        out.writeByte(state.id());
            @Override
            throw new IllegalArgumentException("No primary term available for shard " + shardId);  
        private final Map<Integer, Long> primaryTermsMap;  
    @Nullable
        public Builder settings(Settings settings) {  
                }
            final String message = String.format(
                context = in.readOptionalWriteable(Context::new);
            rolloverInfos = DiffableUtils.diff(before.rolloverInfos, after.rolloverInfos, DiffableUtils.getStringKeySerializer());
        IngestionMessageMapper.MapperType::fromString,  
        "index write (api)",
    public static final String SETTING_PRIORITY = "index.priority";
                                throw new IllegalArgumentException("Unexpected token: " + token);
            public void validate(final String value) {  
        out.writeVLong(settingsVersion);
            this.ingestionStatus = indexMetadata.ingestionStatus;
            .append(", mappings=")
        result = 31 * result + rolloverInfos.hashCode();  
                        );  
            return splitShardsMetadata;
                throw new IllegalArgumentException(
                if (numRoutingShards < numShards) {
        "index.ingestion_source.decoder_settings.",
            } else {
                    + numTargetShards  
                final List<Setting<?>> settings = Collections.singletonList(INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING);  
        if (creationDate != null) {
        } catch (Version.UnsupportedVersionException e) {  
                ingestionStatus = IngestionStatus.getDefaultValue();  
     *                                  number
        IndexMetadataDiff(StreamInput in) throws IOException {
                            + index
    );  
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  // on a start object move to next token  
                                + " can only be enabled when "
 * Index metadata information
                        parser.skipChildren();
            if (INDEX_NUMBER_OF_SHARDS_SETTING.exists(settings) == false) {  
    private final boolean bulkAdaptiveShardSelectionEnabled;  
    private final int numberOfSearchOnlyReplicas;  
         *
     * Defines the max poll size per batch for pull-based ingestion.  
    }
            if (INDEX_NUMBER_OF_REPLICAS_SETTING.exists(settings) == false) {  
            );
            public void validate(final Boolean value, final Map<Setting<?>, Object> settings) {  
                            Integer shard = Integer.parseInt(parser.currentName());  
            );
                if (value) {
    public DiscoveryNodeFilters excludeFilters() {
        this.routingPartitionSize = routingPartitionSize;  
        private Integer routingNumShards;
                throw new IllegalArgumentException("must specify number of shards for index [" + index + "]");
        false,
                if (block.settingName.equals(settingName)) {
                );
        return this.isAppendOnlyIndex;
        public Builder mappingVersion(final long mappingVersion) {
            final int blockingQueueSize = INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING.get(settings);
            return this;  
    }
                    + numTargetShards  
    /**
            }
                            builder.putAlias(AliasMetadata.Builder.fromXContent(parser));
    private final int indexTotalPrimaryShardsPerNodeLimit;
    public static final String SETTING_DATA_PATH = "index.data_path";  
            throw new IllegalArgumentException(MAX_NUMBER_OF_SHARDS + " must be > 0");
    public static Settings addHumanReadableSettings(Settings settings) {  
