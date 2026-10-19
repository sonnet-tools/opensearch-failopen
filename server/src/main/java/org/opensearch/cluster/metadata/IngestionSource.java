            }
        }
        // Warmup configuration
                mapperSettings,  
    /**  
        if (this == o) return true;
    private final IngestionErrorStrategy.ErrorStrategy errorStrategy;
    private int numProcessorThreads;  
            this.allActiveIngestion = ingestionSource.allActiveIngestion;
            + mapperType  
    private final long maxPollSize;
            && Objects.equals(decoderType, ingestionSource.decoderType)
/**
        private final String value;
        public Builder setNumProcessorThreads(int numProcessorThreads) {  
        return pointerBasedLagUpdateInterval;  
            && Objects.equals(errorStrategy, ingestionSource.errorStrategy)
    public WarmupConfig getWarmupConfig() {
    }
            return this;
    }  
            return this;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING;
        }
     *
    }
        int blockingQueueSize,
        private int numProcessorThreads = INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING.getDefault(Settings.EMPTY);  
            + allActiveIngestion
    @PublicApi(since = "3.6.0")
            this.type = ingestionSource.type;  
            && Objects.equals(pollTimeout, ingestionSource.pollTimeout)
        this.pointerBasedLagUpdateInterval = pointerBasedLagUpdateInterval;
    private final Map<String, Object> decoderSettings;
        return sourcePartitionStrategy;  
    }
            + pointerInitReset
        @Override
        if (o == null || getClass() != o.getClass()) return false;  
    @PublicApi(since = "3.6.0")
        public String toString() {
        return decoderSettings;
            return this;
    private final PointerInitReset pointerInitReset;
                pointerBasedLagUpdateInterval,
            + errorStrategy
        public static SourcePartitionStrategy fromString(String name) {
        this.errorStrategy = errorStrategy;
        return type;  
            warmupConfig,
            + ",error_strategy='"  
        this.decoderSettings = decoderSettings != null ? Collections.unmodifiableMap(decoderSettings) : Collections.emptyMap();  
            this.blockingQueueSize = ingestionSource.blockingQueueSize;
        /**
            + ", decoderType='"
            this.maxPollSize = maxPollSize;
        public Builder setWarmupConfig(WarmupConfig warmupConfig) {
                    return strategy;
                pointerInitReset,
            + numProcessorThreads
     * Strategy for mapping source stream partitions to OpenSearch shards.  
    }  
    }
            pointerInitReset,  
        }  
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING;
        }  
        public String getName() {
            + maxPollSize  
        }  
    private final Map<String, Object> params;  
        SourcePartitionStrategy(String name) {  
        }
         */  
import java.util.Collections;
     * Builder for {@link IngestionSource}.
            this.warmupTimeout = wc.timeout();
        return pointerInitReset;
            maxPollSize,  
        public Builder setPollTimeout(int pollTimeout) {
                mapperType,
    }
        }  
import org.opensearch.common.annotation.PublicApi;
            + '\''
        private TimeValue pointerBasedLagUpdateInterval = INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING.getDefault(  
        public Builder setPointerBasedLagUpdateInterval(TimeValue pointerBasedLagUpdateInterval) {  
            );
            this.mapperSettings = new HashMap<>(ingestionSource.mapperSettings);
        return blockingQueueSize;
            + '\''
            this.decoderType = ingestionSource.decoderType;  
    private final int pollTimeout;
        return maxPollSize;
    public long getMaxPollSize() {  
            this.blockingQueueSize = blockingQueueSize;  
            this.sourcePartitionStrategy = sourcePartitionStrategy;
        }
    public Map<String, Object> getMapperSettings() {
            return this;
            this.pointerInitReset = pointerInitReset;
        }
        public Builder addParam(String key, Object value) {
        SourcePartitionStrategy sourcePartitionStrategy  
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING;  
        String type,  
        }
                decoderType,
     */
            this.decoderSettings = decoderSettings;  
        public int hashCode() {
            return new IngestionSource(  
        return warmupConfig;
        this.mapperSettings = mapperSettings != null ? Collections.unmodifiableMap(mapperSettings) : Collections.emptyMap();
 * SPDX-License-Identifier: Apache-2.0
        }
            numProcessorThreads,
    }
    }  
        }  
     */
            return this;
        this.decoderType = decoderType;
    public String getType() {
    @Override  
    public static class PointerInitReset {  
    public IngestionMessageMapper.MapperType getMapperType() {  
    }  
            params,
        this.pointerInitReset = pointerInitReset;  
    public String toString() {
    public SourcePartitionStrategy getSourcePartitionStrategy() {
}  
            && Objects.equals(pointerInitReset, ingestionSource.pointerInitReset)  
    public TimeValue getPointerBasedLagUpdateInterval() {
        return mapperType;
            this.pointerInitReset = ingestionSource.pointerInitReset;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING;
            + ", params="  
            + blockingQueueSize  
        @Override
        IngestionMessageMapper.MapperType mapperType,
        }
    @PublicApi(since = "3.6.0")
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING;
            pointerBasedLagUpdateInterval,
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_PARTITION_STRATEGY_SETTING;
        public Builder setWarmupLagThreshold(long warmupLagThreshold) {
            this.decoderSettings = new HashMap<>(ingestionSource.decoderSettings);
            + type
            this.value = value;  
            sourcePartitionStrategy
            WarmupConfig wc = ingestionSource.warmupConfig;
                warmupConfig,  
        boolean allActiveIngestion,
                }  
 * Class encapsulating the configuration of an ingestion source.
            + decoderType
    }  
    public IngestionErrorStrategy.ErrorStrategy getErrorStrategy() {
            WarmupConfig warmupConfig = new WarmupConfig(warmupTimeout, warmupLagThreshold);
import org.opensearch.indices.pollingingest.StreamPoller;
        }  
    private final String type;  
        }
        }  
    }  
package org.opensearch.cluster.metadata;
            return timeout.millis() >= 0;
        public Builder setPointerInitReset(PointerInitReset pointerInitReset) {  
            && Objects.equals(sourcePartitionStrategy, ingestionSource.sourcePartitionStrategy);
            this.warmupTimeout = warmupTimeout;
    }
        private Map<String, Object> mapperSettings = new HashMap<>();
        this.blockingQueueSize = blockingQueueSize;  
            + ", decoderSettings="
 * compatible open source license.
                if (strategy.getName().equalsIgnoreCase(name)) {
            + ", mapperSettings="
        int pollTimeout,
            + decoderSettings
            + ", allActiveIngestion="
        }  
        public Builder setDecoderSettings(Map<String, Object> decoderSettings) {
        private IngestionMessageMapper.MapperType mapperType = INGESTION_SOURCE_MAPPER_TYPE_SETTING.getDefault(Settings.EMPTY);  
            this.errorStrategy = errorStrategy;  
        private SourcePartitionStrategy sourcePartitionStrategy = INGESTION_SOURCE_PARTITION_STRATEGY_SETTING.getDefault(Settings.EMPTY);
            + pointerBasedLagUpdateInterval
 */  
        this.pollTimeout = pollTimeout;
        public Builder setParams(Map<String, Object> params) {
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING;
     * after node restart or shard relocation. A timeout of -1 means warmup is disabled.  
    /**
import java.util.HashMap;  
    }
    public String getDecoderType() {
            if (this == o) return true;
        );  
        private String decoderType = INGESTION_SOURCE_DECODER_TYPE_SETTING.getDefault(Settings.EMPTY);
            return this;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_POLL_TIMEOUT;  
        return Objects.equals(type, ingestionSource.type)
                params,
        return numProcessorThreads;  
        public Builder(IngestionSource ingestionSource) {
        long maxPollSize,
        }
        }  
                decoderSettings,
            this.pointerBasedLagUpdateInterval = ingestionSource.pointerBasedLagUpdateInterval;  
        private int pollTimeout = INGESTION_SOURCE_POLL_TIMEOUT.getDefault(Settings.EMPTY);
        Map<String, Object> mapperSettings,
            decoderSettings,  
        @Override
            + '\''
            return this;  
            && Objects.equals(numProcessorThreads, ingestionSource.numProcessorThreads)
        TimeValue pointerBasedLagUpdateInterval,  
        private int blockingQueueSize = INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING.getDefault(Settings.EMPTY);
            // Copy warmup config  
        Map<String, Object> decoderSettings,
/*  
        public StreamPoller.ResetState getType() {  
    }
    }
        private Map<String, Object> decoderSettings = new HashMap<>();  
        public Builder setErrorStrategy(IngestionErrorStrategy.ErrorStrategy errorStrategy) {
            blockingQueueSize,  
    @PublicApi(since = "3.7.0")
            for (SourcePartitionStrategy strategy : values()) {  
            + '}';
    public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
        return "IngestionSource{"
     */  
        public Builder setSourcePartitionStrategy(SourcePartitionStrategy sourcePartitionStrategy) {
            this.warmupTimeout = warmupConfig.timeout();
        }
            return this;  
        private final String name;
        public Builder setAllActiveIngestion(boolean allActiveIngestion) {
            type,
        private IngestionErrorStrategy.ErrorStrategy errorStrategy;
            return Objects.equals(type, pointerInitReset.type) && Objects.equals(value, pointerInitReset.value);
            errorStrategy,
            + "type='"  
    /**
            mapperType,  
            return this;
        WarmupConfig warmupConfig,
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;  
            + '\''  
        public PointerInitReset(StreamPoller.ResetState type, String value) {
        }
        public Builder setBlockingQueueSize(int blockingQueueSize) {
            + mapperSettings  
            Settings.EMPTY
            + '\''
    @Override
            + ", maxPollSize="
        public Builder setMapperType(IngestionMessageMapper.MapperType mapperType) {
            return this;
    }
        return params;  
    public static class Builder {
            this.warmupLagThreshold = warmupLagThreshold;  
            + warmupConfig
    private final boolean allActiveIngestion;
            && Objects.equals(maxPollSize, ingestionSource.maxPollSize)  
        return mapperSettings;
            + ", sourcePartitionStrategy='"
            this.params.put(key, value);  
            + ", pointerBasedLagUpdateInterval="  
        MODULO("modulo");
            + '\''
            return this;  
            this.mapperType = ingestionSource.mapperType;
            this.allActiveIngestion = allActiveIngestion;
    public int hashCode() {  
        public Builder setMaxPollSize(long maxPollSize) {  
        @Override  
        }
            PointerInitReset pointerInitReset = (PointerInitReset) o;  
            + ", mapperType='"
        public boolean isEnabled() {
import org.opensearch.common.settings.Settings;
    }
        private long warmupLagThreshold = INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING.getDefault(Settings.EMPTY);
                errorStrategy,  
         * Returns true if warmup is enabled (timeout >= 0).
            this.mapperSettings = mapperSettings;
    }
        private boolean allActiveIngestion = INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING.getDefault(Settings.EMPTY);
            this.pointerBasedLagUpdateInterval = pointerBasedLagUpdateInterval;
            + pollTimeout
    public int getNumProcessorThreads() {
        public String toString() {  
        PointerInitReset pointerInitReset,
            this.pollTimeout = pollTimeout;
    private final String decoderType;  
    private final TimeValue pointerBasedLagUpdateInterval;  
        this.maxPollSize = maxPollSize;  
            return this;  
            return this;
        this.allActiveIngestion = allActiveIngestion;
        }  
            return this;  
 * this file be licensed under the Apache-2.0 license or a
            return name;
            return value;
            throw new IllegalArgumentException("Unknown partition strategy: [" + name + "]. Valid values are [simple, modulo]");
        public Builder setMapperSettings(Map<String, Object> mapperSettings) {
    public int getPollTimeout() {
     */
            this.name = name;
            return this;
    public Map<String, Object> params() {
        this.warmupConfig = warmupConfig;
        );
            this.params = ingestionSource.params;  
            && Objects.equals(mapperSettings, ingestionSource.mapperSettings)
        }
    }  
public class IngestionSource {
            && Objects.equals(allActiveIngestion, ingestionSource.allActiveIngestion)
import org.opensearch.common.unit.TimeValue;  
        this.params = params;
        SIMPLE("simple"),
            this.params = params;
            && Objects.equals(params, ingestionSource.params)
        }  
     * Record encapsulating the warmup configuration for pull-based ingestion.
        }
    }
                maxPollSize,
            this.warmupLagThreshold = wc.lagThreshold();  
    public record WarmupConfig(TimeValue timeout, long lagThreshold) {  
            return Objects.hash(type, value);  
            this.warmupLagThreshold = warmupConfig.lagThreshold();  
        }
        public boolean equals(Object o) {  
            + ",pointer_init_reset='"  
            return name;
        return Objects.hash(
            this.sourcePartitionStrategy = ingestionSource.sourcePartitionStrategy;
    private IngestionSource(
    public enum SourcePartitionStrategy {  
    public int getBlockingQueueSize() {  
            + ", pollTimeout="
        }  
    private final SourcePartitionStrategy sourcePartitionStrategy;  
            && Objects.equals(pointerBasedLagUpdateInterval, ingestionSource.pointerBasedLagUpdateInterval)
                pollTimeout,  
        }
            + ", blockingQueueSize="
     * Class encapsulating the configuration of a pointer initialization.  
            + ", warmupConfig="  
        this.mapperType = mapperType;  
    }  
        return errorStrategy;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_MAX_POLL_SIZE;
    private final WarmupConfig warmupConfig;
            && Objects.equals(blockingQueueSize, ingestionSource.blockingQueueSize)  
        this.numProcessorThreads = numProcessorThreads;
        }  
            && Objects.equals(decoderSettings, ingestionSource.decoderSettings)  
            this.mapperType = mapperType;  
        private Map<String, Object> params;  
 * The OpenSearch Contributors require contributions made to  
            + sourcePartitionStrategy  
            this.params = new HashMap<>();
            return this;
        IngestionSource ingestionSource = (IngestionSource) o;
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING;  
            pollTimeout,
            return this;
        this.type = type;
            this.type = type;
import java.util.Map;
        private long maxPollSize = INGESTION_SOURCE_MAX_POLL_SIZE.getDefault(Settings.EMPTY);
            mapperSettings,
        }
        }
    }
import static org.opensearch.cluster.metadata.IndexMetadata.INGESTION_SOURCE_DECODER_TYPE_SETTING;
                numProcessorThreads,
        private String type;  
        IngestionErrorStrategy.ErrorStrategy errorStrategy,
            this.decoderType = decoderType;
    public boolean isAllActiveIngestionEnabled() {
            allActiveIngestion,
    public PointerInitReset getPointerInitReset() {  
            return this;
    /**  
        private PointerInitReset pointerInitReset;
import org.opensearch.indices.pollingingest.IngestionErrorStrategy;
 *
        return allActiveIngestion;
            && Objects.equals(mapperType, ingestionSource.mapperType)  
@PublicApi(since = "3.6.0")
        public Builder(String type) {  
    private int blockingQueueSize;
        return decoderType;  
        private TimeValue warmupTimeout = INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING.getDefault(Settings.EMPTY);  
                allActiveIngestion,  
        int numProcessorThreads,  
                sourcePartitionStrategy
            this.type = type;
            return type;
                type,
            && Objects.equals(warmupConfig, ingestionSource.warmupConfig)
        private final StreamPoller.ResetState type;
    ) {
        public Builder setWarmupTimeout(TimeValue warmupTimeout) {  
            + params
        Map<String, Object> params,  
import java.util.Objects;
                blockingQueueSize,
    @Override  
    }  
        return pollTimeout;
        String decoderType,  
        public String getValue() {
            decoderType,
     * When warmup is enabled (timeout >= 0), shards will wait for lag to catch up before serving queries
            return "PointerInitReset{" + "type='" + type + '\'' + ", value=" + value + '}';
    private final IngestionMessageMapper.MapperType mapperType;
        this.sourcePartitionStrategy = sourcePartitionStrategy;
        public Builder setDecoderType(String decoderType) {  
    private final Map<String, Object> mapperSettings;
    public Map<String, Object> getDecoderSettings() {  
            + ", numProcessorThreads="  
            this.numProcessorThreads = numProcessorThreads;
            this.errorStrategy = ingestionSource.errorStrategy;
        public IngestionSource build() {
 */  
