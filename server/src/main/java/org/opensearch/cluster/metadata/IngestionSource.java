     *
            + ", decoderType='"
            + pointerBasedLagUpdateInterval
        }
        }
     * Class encapsulating the configuration of a pointer initialization.
        public Builder setDecoderType(String decoderType) {
    public Map<String, Object> getMapperSettings() {
                allActiveIngestion,
    public Map<String, Object> params() {
            + ", numProcessorThreads="
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING;
/**
            + pollTimeout
            + ", blockingQueueSize="
            this.params = params;
        }
        private int blockingQueueSize = INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING.getDefault(Settings.EMPTY);
            this.warmupLagThreshold = wc.lagThreshold();
    private int blockingQueueSize;
        }
    @Override
            return this;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_PARTITION_STRATEGY_SETTING;
    public int getNumProcessorThreads() {
            && Objects.equals(decoderSettings, ingestionSource.decoderSettings)
        private int pollTimeout = INGESTION_SOURCE_POLL_TIMEOUT.getDefault(Settings.EMPTY);
        }
            + '\''
    public long getMaxPollSize() {
        IngestionSource ingestionSource = (IngestionSource) o;
        }
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING;
            this.decoderType = decoderType;
        public String toString() {
            && Objects.equals(allActiveIngestion, ingestionSource.allActiveIngestion)
    public String toString() {
            + decoderType
                blockingQueueSize,
            decoderType,
            + '\''
            this.params = new HashMap<>();
        return blockingQueueSize;
    private IngestionSource(
            this.blockingQueueSize = ingestionSource.blockingQueueSize;
    public PointerInitReset getPointerInitReset() {
            && Objects.equals(sourcePartitionStrategy, ingestionSource.sourcePartitionStrategy);
            mapperType,
        public Builder setParams(Map<String, Object> params) {
        );
        PointerInitReset pointerInitReset,
        return pointerBasedLagUpdateInterval;
        }
    public boolean isAllActiveIngestionEnabled() {
        TimeValue pointerBasedLagUpdateInterval,
 * Class encapsulating the configuration of an ingestion source.
            return timeout.millis() >= 0;
            + "type='"
        public String getName() {
            return this;
            this.warmupTimeout = warmupConfig.timeout();
            + mapperType
    private final PointerInitReset pointerInitReset;
            + type
        }
        @Override
        public StreamPoller.ResetState getType() {
        return pointerInitReset;
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;
                sourcePartitionStrategy
        }
            + '\''
        public boolean isEnabled() {
        this.decoderType = decoderType;
        private final StreamPoller.ResetState type;
    private int numProcessorThreads;
            + ",error_strategy='"
            + numProcessorThreads
        return pollTimeout;
    }
        Map<String, Object> mapperSettings,
            return this;
    @PublicApi(since = "3.6.0")
        String type,
            throw new IllegalArgumentException("Unknown partition strategy: [" + name + "]. Valid values are [simple, modulo]");
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_DECODER_TYPE_SETTING;
        public Builder setWarmupTimeout(TimeValue warmupTimeout) {
                decoderType,
        long maxPollSize,
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_MAX_POLL_SIZE;
        public String toString() {
            this.type = ingestionSource.type;
            + allActiveIngestion
        IngestionErrorStrategy.ErrorStrategy errorStrategy,
                decoderSettings,
            mapperSettings,
            + blockingQueueSize
        return allActiveIngestion;
        return maxPollSize;
    public int getBlockingQueueSize() {
        this.errorStrategy = errorStrategy;
    private final IngestionErrorStrategy.ErrorStrategy errorStrategy;
            this.sourcePartitionStrategy = sourcePartitionStrategy;
            + ", pollTimeout="
    private final Map<String, Object> decoderSettings;
    public int getPollTimeout() {
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING;
    public record WarmupConfig(TimeValue timeout, long lagThreshold) {
        Map<String, Object> decoderSettings,
        }
        public Builder setPollTimeout(int pollTimeout) {
            && Objects.equals(mapperType, ingestionSource.mapperType)
    }
        this.blockingQueueSize = blockingQueueSize;
            this.blockingQueueSize = blockingQueueSize;
                type,
        private long warmupLagThreshold = INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING.getDefault(Settings.EMPTY);
        }
            allActiveIngestion,
            && Objects.equals(blockingQueueSize, ingestionSource.blockingQueueSize)
        public Builder setBlockingQueueSize(int blockingQueueSize) {
        public Builder setAllActiveIngestion(boolean allActiveIngestion) {
            this.pointerBasedLagUpdateInterval = pointerBasedLagUpdateInterval;
package org.opensearch.cluster.metadata;
            return "PointerInitReset{" + "type='" + type + '\'' + ", value=" + value + '}';
        public Builder setSourcePartitionStrategy(SourcePartitionStrategy sourcePartitionStrategy) {
        private TimeValue warmupTimeout = INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING.getDefault(Settings.EMPTY);
    }
            + ", params="
        this.sourcePartitionStrategy = sourcePartitionStrategy;
import java.util.HashMap;
            + ", sourcePartitionStrategy='"
        String decoderType,
            return this;
                }
            errorStrategy,
        private final String name;
            return this;
            blockingQueueSize,
            pointerBasedLagUpdateInterval,
            WarmupConfig warmupConfig = new WarmupConfig(warmupTimeout, warmupLagThreshold);
    public String getType() {
            this.sourcePartitionStrategy = ingestionSource.sourcePartitionStrategy;
            pollTimeout,
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING;
 *
            return value;
            type,
        return params;
    private final SourcePartitionStrategy sourcePartitionStrategy;
    public TimeValue getPointerBasedLagUpdateInterval() {
        }
                if (strategy.getName().equalsIgnoreCase(name)) {
    }
            }
    public WarmupConfig getWarmupConfig() {
            this.decoderType = ingestionSource.decoderType;
        public Builder setDecoderSettings(Map<String, Object> decoderSettings) {
            if (this == o) return true;
    public enum SourcePartitionStrategy {
        public Builder setMapperSettings(Map<String, Object> mapperSettings) {
            this.params.put(key, value);
    }
        private final String value;
        }
    }
            + '}';
            this.allActiveIngestion = allActiveIngestion;
        WarmupConfig warmupConfig,
            pointerInitReset,
        public static SourcePartitionStrategy fromString(String name) {
     */
            + ", decoderSettings="
    }
                warmupConfig,
            return name;
            this.warmupLagThreshold = warmupConfig.lagThreshold();
    @Override
                pointerInitReset,
        @Override
        return Objects.equals(type, ingestionSource.type)
        }
     * after node restart or shard relocation. A timeout of -1 means warmup is disabled.
            return this;
        public Builder(IngestionSource ingestionSource) {
        private TimeValue pointerBasedLagUpdateInterval = INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING.getDefault(
    private final int pollTimeout;
        @Override
        this.pointerBasedLagUpdateInterval = pointerBasedLagUpdateInterval;
        private PointerInitReset pointerInitReset;
    }
        public Builder setMaxPollSize(long maxPollSize) {
    }
        return mapperType;
            + '\''
        MODULO("modulo");
            + params
            this.value = value;
    /**
        SourcePartitionStrategy sourcePartitionStrategy
        int numProcessorThreads,
            && Objects.equals(mapperSettings, ingestionSource.mapperSettings)
            + ",pointer_init_reset='"
     * When warmup is enabled (timeout >= 0), shards will wait for lag to catch up before serving queries
            for (SourcePartitionStrategy strategy : values()) {
            && Objects.equals(decoderType, ingestionSource.decoderType)
                mapperSettings,
        public Builder setPointerInitReset(PointerInitReset pointerInitReset) {
            + ", allActiveIngestion="
            + ", maxPollSize="
    /**
        return Objects.hash(
            this.decoderSettings = decoderSettings;
        return sourcePartitionStrategy;
        public Builder setNumProcessorThreads(int numProcessorThreads) {
            && Objects.equals(pollTimeout, ingestionSource.pollTimeout)
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING;
     */
        this.warmupConfig = warmupConfig;
        return decoderSettings;
            + ", pointerBasedLagUpdateInterval="
        this.params = params;
    private final String decoderType;
            return this;
import org.opensearch.common.unit.TimeValue;
     */
        private boolean allActiveIngestion = INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getDefault(Settings.EMPTY);
        }
        if (o == null || getClass() != o.getClass()) return false;
            && Objects.equals(params, ingestionSource.params)
            && Objects.equals(numProcessorThreads, ingestionSource.numProcessorThreads)
        }
    }
        return "IngestionSource{"
            && Objects.equals(warmupConfig, ingestionSource.warmupConfig)
            return this;
        }
        this.decoderSettings = decoderSettings != null ? Collections.unmodifiableMap(decoderSettings) : Collections.emptyMap();
    public String getDecoderType() {
            return this;
        public Builder setWarmupLagThreshold(long warmupLagThreshold) {
                mapperType,
            return this;
            return this;
    }
    public int hashCode() {
        return mapperSettings;
        private IngestionErrorStrategy.ErrorStrategy errorStrategy;
    }
        /**
            this.mapperSettings = mapperSettings;
            return this;
    }
            return this;
    }
            PointerInitReset pointerInitReset = (PointerInitReset) o;
            this.mapperSettings = new HashMap<>(ingestionSource.mapperSettings);
    public static class Builder {
            this.mapperType = mapperType;
            );
        if (this == o) return true;
    private final Map<String, Object> params;
            + ", mapperType='"
     * Strategy for mapping source stream partitions to OpenSearch shards.
    private final long maxPollSize;
        this.maxPollSize = maxPollSize;
    private final IngestionMessageMapper.MapperType mapperType;
        this.numProcessorThreads = numProcessorThreads;
                pollTimeout,
    }
    public static class PointerInitReset {
        SourcePartitionStrategy(String name) {
        }
        private Map<String, Object> params;
            this.errorStrategy = ingestionSource.errorStrategy;
        }
            if (o == null || getClass() != o.getClass()) return false;
            this.pointerInitReset = ingestionSource.pointerInitReset;
import java.util.Objects;
 */
                maxPollSize,
    private final WarmupConfig warmupConfig;
            this.warmupLagThreshold = warmupLagThreshold;
    public IngestionErrorStrategy.ErrorStrategy getErrorStrategy() {
            return Objects.equals(type, pointerInitReset.type) && Objects.equals(value, pointerInitReset.value);
            + maxPollSize
                numProcessorThreads,
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING;
            + ", mapperSettings="
    }
            this.pointerBasedLagUpdateInterval = ingestionSource.pointerBasedLagUpdateInterval;
 * SPDX-License-Identifier: Apache-2.0
        }
            numProcessorThreads,
            return this;
        }
    @PublicApi(since = "3.7.0")
            this.allActiveIngestion = ingestionSource.allActiveIngestion;
     * Record encapsulating the warmup configuration for pull-based ingestion.
        private long maxPollSize = INGESTION_SOURCE_MAX_POLL_SIZE.getDefault(Settings.EMPTY);
            && Objects.equals(pointerInitReset, ingestionSource.pointerInitReset)
@PublicApi(since = "3.6.0")
    }
            && Objects.equals(errorStrategy, ingestionSource.errorStrategy)
            return this;
        private Map<String, Object> mapperSettings = new HashMap<>();
import org.opensearch.common.annotation.PublicApi;
         * Returns true if warmup is enabled (timeout >= 0).
            this.mapperType = ingestionSource.mapperType;
        }
    @Override
            this.params = ingestionSource.params;
            return Objects.hash(type, value);
    public IngestionMessageMapper.MapperType getMapperType() {
import java.util.Collections;
                errorStrategy,
        }
        public int hashCode() {
            params,
 * The OpenSearch Contributors require contributions made to
    }
            Settings.EMPTY
            this.type = type;
        }
        public Builder setErrorStrategy(IngestionErrorStrategy.ErrorStrategy errorStrategy) {
                pointerBasedLagUpdateInterval,
        int pollTimeout,
            WarmupConfig wc = ingestionSource.warmupConfig;
            sourcePartitionStrategy
        @Override
    private final String type;
            + warmupConfig
            && Objects.equals(maxPollSize, ingestionSource.maxPollSize)
            this.errorStrategy = errorStrategy;
            + decoderSettings
    public boolean equals(Object o) {
            this.type = type;
        public String getValue() {
            maxPollSize,
    private final TimeValue pointerBasedLagUpdateInterval;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING;
        private SourcePartitionStrategy sourcePartitionStrategy = INGESTION_SOURCE_PARTITION_STRATEGY_SETTING.getDefault(Settings.EMPTY);
        }
            // Copy warmup config
            this.warmupTimeout = warmupTimeout;
        }
            this.maxPollSize = maxPollSize;
            return this;
    }
            return this;
        int blockingQueueSize,
    public Map<String, Object> getDecoderSettings() {
        // Warmup configuration
        }
        this.pollTimeout = pollTimeout;
        private String type;
import java.util.Map;
        public Builder setWarmupConfig(WarmupConfig warmupConfig) {
        private IngestionMessageMapper.MapperType mapperType = INGESTION_SOURCE_MAPPER_TYPE_SETTING.getDefault(Settings.EMPTY);
        this.mapperSettings = mapperSettings != null ? Collections.unmodifiableMap(mapperSettings) : Collections.emptyMap();
        this.type = type;
            return new IngestionSource(
        }
public class IngestionSource {
            decoderSettings,
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            + ", warmupConfig="
        public PointerInitReset(StreamPoller.ResetState type, String value) {
}
            return name;
            + '\''
        this.mapperType = mapperType;
 */
    @PublicApi(since = "3.6.0")
        public Builder setMapperType(IngestionMessageMapper.MapperType mapperType) {
import org.opensearch.indices.pollingingest.StreamPoller;
                    return strategy;
    }
            return this;
/*
        Map<String, Object> params,
        public Builder addParam(String key, Object value) {
            + '\''
            this.decoderSettings = new HashMap<>(ingestionSource.decoderSettings);
            + pointerInitReset
            + errorStrategy
            this.name = name;
    public SourcePartitionStrategy getSourcePartitionStrategy() {
        }
        return errorStrategy;
            warmupConfig,
    @PublicApi(since = "3.6.0")
    /**
        private Map<String, Object> decoderSettings = new HashMap<>();
                params,
        public Builder setPointerBasedLagUpdateInterval(TimeValue pointerBasedLagUpdateInterval) {
    private final boolean allActiveIngestion;
            this.pollTimeout = pollTimeout;
        public boolean equals(Object o) {
        return numProcessorThreads;
    }
        );
            this.warmupTimeout = wc.timeout();
        private int numProcessorThreads = INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING.getDefault(Settings.EMPTY);
    }
    /**
        public IngestionSource build() {
        IngestionMessageMapper.MapperType mapperType,
    ) {
        this.allActiveIngestion = allActiveIngestion;
         */
        }
        return type;
import org.opensearch.indices.pollingingest.IngestionErrorStrategy;
            this.pointerInitReset = pointerInitReset;
            + sourcePartitionStrategy
        return warmupConfig;
import org.opensearch.common.settings.Settings;
        }
    }
     */
        private String decoderType = INGESTION_SOURCE_DECODER_TYPE_SETTING.getDefault(Settings.EMPTY);
        boolean allActiveIngestion,
    private final Map<String, Object> mapperSettings;
        return decoderType;
    }
            return type;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_POLL_TIMEOUT;
        this.pointerInitReset = pointerInitReset;
            + mapperSettings
            this.numProcessorThreads = numProcessorThreads;
     * Builder for {@link IngestionSource}.
        }
        SIMPLE("simple"),
            && Objects.equals(pointerBasedLagUpdateInterval, ingestionSource.pointerBasedLagUpdateInterval)
        public Builder(String type) {
