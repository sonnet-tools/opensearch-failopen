    }
import java.util.Map;
    }
        this.rowGroupMaxBytes = builder.rowGroupMaxBytes;
        return pageSizeBytes;
    private final Integer compressionLevel;
            this.mergeBatchSize = v;
        return fieldCompressions;
        }
        }
    private final Long dictSizeBytes;
    public Map<String, Boolean> getTypeBloomFilterEnabled() {
        return dictSizeBytes;
        private Set<String> lowCardinalityEnabledFields;
        }
        return fieldEncodings;
        private Integer mergeRayonThreads;
    }
        public Builder dictSizeBytes(Long v) {
        }
import java.util.Set;
    }
            return this;
 * compatible open source license.
    }
            this.typeBloomFilterFpp = v;
    }
            : Collections.emptyMap();
        public NativeSettings build() {
        public Builder indexName(String v) {
            ? Collections.unmodifiableMap(builder.typeBloomFilterEnabled)
    }
            this.indexName = v;
            return this;
        this.typeBloomFilterNdv = builder.typeBloomFilterNdv != null
    }
        this.fieldCompressions = builder.fieldCompressions != null
        }
    /**
    private final Long sortInMemoryThresholdBytes;
            this.typeBloomFilterNdv = v;
    public Map<String, String> getFieldEncodings() {
            return this;
            return this;
        public Builder mergeBatchSize(Integer v) {
    public Integer getPageRowLimit() {
            return this;
 * The Rust side reads values through the getter methods.
        this.indexName = builder.indexName;
    private final Long bloomFilterNdv;
        public Builder rowGroupMaxBytes(Long v) {
            return this;
        public Builder fieldEncodings(Map<String, String> v) {
    }
        private Boolean bloomFilterEnabled;
            this.typeEncodings = v;
        }
    private final Integer pageRowLimit;
            : Collections.emptySet();
            ? Collections.unmodifiableMap(builder.fieldCompressions)
        return mergeDeferredColumnThreshold;
        private Map<String, String> typeEncodings;
 * SPDX-License-Identifier: Apache-2.0
            this.rowGroupMaxBytes = v;
        public Builder rowGroupMaxRows(Integer v) {
            this.mergeRayonThreads = v;
    }
        this.mergeIoThreads = builder.mergeIoThreads;
 */
        }
            return this;
        return typeBloomFilterFpp;
    public Map<String, String> getTypeEncodings() {
        }
            this.fieldEncodings = v;
            return this;
        }
    public Map<String, Double> getTypeBloomFilterFpp() {
        private Integer pageRowLimit;
            this.mergeDeferredColumnThreshold = v;
    }
            this.fieldBloomFilterEnabled = v;
    public Map<String, Boolean> getFieldBloomFilterEnabled() {
            : Collections.emptyMap();
            this.compressionLevel = v;
        return rowGroupMaxBytes;
            return this;
        this.typeBloomFilterFpp = builder.typeBloomFilterFpp != null
            this.pageRowLimit = v;
    }
    public String getCompressionType() {
        public Builder typeEncodings(Map<String, String> v) {
        this.pageRowLimit = builder.pageRowLimit;
        this.fieldEncodings = builder.fieldEncodings != null ? Collections.unmodifiableMap(builder.fieldEncodings) : Collections.emptyMap();
        this.bloomFilterFpp = builder.bloomFilterFpp;
    public String getIndexName() {
    public Integer getMergeRayonThreads() {
    public Set<String> getLowCardinalityEnabledFields() {
    private final Map<String, String> fieldEncodings;
/*
        return typeCompressions;
        public Builder mergeDeferredColumnThreshold(Integer v) {
            ? Collections.unmodifiableSet(builder.lowCardinalityEnabledFields)
        }
        this.mergeBatchSize = builder.mergeBatchSize;
 * All fields are nullable; the native side falls back to defaults when null.
        return new Builder();
    public Boolean getBloomFilterEnabled() {
        }
            this.mergeIoThreads = v;
        public Builder typeBloomFilterFpp(Map<String, Double> v) {
        public Builder mergeRayonThreads(Integer v) {
        this.compressionLevel = builder.compressionLevel;
        private Map<String, String> fieldEncodings;
    private final Map<String, Boolean> fieldBloomFilterEnabled;
    public static Builder builder() {
 *
     */
    private final Set<String> lowCardinalityEnabledFields;
        public Builder pageSizeBytes(Long v) {
    }
            return this;
        return bloomFilterFpp;
            return this;
        public Builder lowCardinalityEnabledFields(Set<String> v) {
    private final Map<String, String> fieldCompressions;
            : Collections.emptyMap();
    private final Double bloomFilterFpp;
    }
        this.lowCardinalityEnabledFields = builder.lowCardinalityEnabledFields != null
    public Integer getMergeIoThreads() {
    public Long getDictSizeBytes() {
    }
            : Collections.emptyMap();
        public Builder fieldCompressions(Map<String, String> v) {
            return this;
    }
        public Builder sortInMemoryThresholdBytes(Long v) {
            return this;
        return mergeIoThreads;
    public Integer getRowGroupMaxRows() {
    public Long getSortInMemoryThresholdBytes() {
        public Builder bloomFilterFpp(Double v) {
    private final Integer mergeRayonThreads;
        }
        private Map<String, Boolean> typeBloomFilterEnabled;
 * Immutable settings passed to the native Rust writer via JNI.
        this.dictSizeBytes = builder.dictSizeBytes;
    public Map<String, String> getTypeCompressions() {
            return this;
        this.compressionType = builder.compressionType;
            return this;
    private final Integer mergeDeferredColumnThreshold;
    private final Map<String, Boolean> typeBloomFilterEnabled;
        }
        return pageRowLimit;
        this.typeCompressions = builder.typeCompressions != null
            ? Collections.unmodifiableMap(builder.typeBloomFilterFpp)
        }
        }
        this.mergeRayonThreads = builder.mergeRayonThreads;
        this.bloomFilterEnabled = builder.bloomFilterEnabled;
        return typeEncodings;
    private NativeSettings(Builder builder) {
        }
    private final Map<String, Long> typeBloomFilterNdv;
        private Long pageSizeBytes;
            this.fieldCompressions = v;
        }
    private final Map<String, Double> typeBloomFilterFpp;
        private Integer mergeDeferredColumnThreshold;
        private Long rowGroupMaxBytes;
            this.sortInMemoryThresholdBytes = v;
    }
        return mergeBatchSize;
        this.pageSizeBytes = builder.pageSizeBytes;
        public Builder bloomFilterNdv(Long v) {
    private final Integer rowGroupMaxRows;
            return this;
            return this;
    private final Boolean bloomFilterEnabled;
    public Long getPageSizeBytes() {
    }
        public Builder fieldBloomFilterEnabled(Map<String, Boolean> v) {
            this.dictSizeBytes = v;
            return new NativeSettings(this);
        public Builder bloomFilterEnabled(Boolean v) {
 * this file be licensed under the Apache-2.0 license or a
        this.typeBloomFilterEnabled = builder.typeBloomFilterEnabled != null
        public Builder compressionLevel(Integer v) {
    public Integer getCompressionLevel() {
    }
        }
    private final Long rowGroupMaxBytes;
        this.fieldBloomFilterEnabled = builder.fieldBloomFilterEnabled != null
        public Builder mergeIoThreads(Integer v) {
            : Collections.emptyMap();
        private Integer mergeBatchSize;
        private Double bloomFilterFpp;
            this.pageSizeBytes = v;
        private Integer mergeIoThreads;
    }
            return this;
        private Map<String, Long> typeBloomFilterNdv;
            return this;
        return bloomFilterNdv;
    private final Long pageSizeBytes;
    private final Integer mergeIoThreads;
            this.typeBloomFilterEnabled = v;
    private final Map<String, String> typeCompressions;
        return rowGroupMaxRows;
        public Builder typeCompressions(Map<String, String> v) {
 * The OpenSearch Contributors require contributions made to
    }
    public Integer getMergeBatchSize() {
    }
        this.mergeDeferredColumnThreshold = builder.mergeDeferredColumnThreshold;
    }
        return typeBloomFilterNdv;
            : Collections.emptyMap();
    public Long getBloomFilterNdv() {
        return typeBloomFilterEnabled;
    private final Map<String, String> typeEncodings;
        private Map<String, Double> typeBloomFilterFpp;
    }
        private Map<String, String> fieldCompressions;
            return this;
        private Map<String, Boolean> fieldBloomFilterEnabled;
        public Builder typeBloomFilterNdv(Map<String, Long> v) {
        }
    public Map<String, Long> getTypeBloomFilterNdv() {
    public Long getRowGroupMaxBytes() {
            return this;
            this.typeCompressions = v;
    private final String compressionType;
    }
        private Map<String, String> typeCompressions;
    }
        this.sortInMemoryThresholdBytes = builder.sortInMemoryThresholdBytes;
    public Double getBloomFilterFpp() {
            this.rowGroupMaxRows = v;
        this.typeEncodings = builder.typeEncodings != null ? Collections.unmodifiableMap(builder.typeEncodings) : Collections.emptyMap();
            this.bloomFilterEnabled = v;
        private Long dictSizeBytes;
        public Builder compressionType(String v) {
        private Integer rowGroupMaxRows;
        private Long bloomFilterNdv;
}
        public Builder pageRowLimit(Integer v) {
    public Integer getMergeDeferredColumnThreshold() {
        private String indexName;
            ? Collections.unmodifiableMap(builder.typeBloomFilterNdv)
public class NativeSettings {
        }
     * The Rust writer enables bloom filters for these columns.
            ? Collections.unmodifiableMap(builder.fieldBloomFilterEnabled)
            this.lowCardinalityEnabledFields = v;
        return compressionLevel;
        return lowCardinalityEnabledFields;
            return this;
        }
            return this;
    }
        this.rowGroupMaxRows = builder.rowGroupMaxRows;
        }
        private Long sortInMemoryThresholdBytes;
        return fieldBloomFilterEnabled;
            return this;
        }
        return bloomFilterEnabled;
        this.bloomFilterNdv = builder.bloomFilterNdv;
            this.bloomFilterNdv = v;
        private Integer compressionLevel;
            return this;
        return mergeRayonThreads;
 */
            ? Collections.unmodifiableMap(builder.typeCompressions)
    public Map<String, String> getFieldCompressions() {
    private final Integer mergeBatchSize;
     * Returns the set of field names for which low-cardinality mode is enabled.
        return compressionType;
import java.util.Collections;
            this.bloomFilterFpp = v;
        }
/**
        }
        private String compressionType;
        return sortInMemoryThresholdBytes;
            this.compressionType = v;
    private final String indexName;
package org.opensearch.parquet.bridge;
        }
    public static class Builder {
        public Builder typeBloomFilterEnabled(Map<String, Boolean> v) {
    }
        return indexName;
