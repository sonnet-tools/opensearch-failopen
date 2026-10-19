        private Integer mergeDeferredColumnThreshold;  
        }
            this.mergeRayonThreads = v;
        this.bloomFilterEnabled = builder.bloomFilterEnabled;  
        this.rowGroupMaxBytes = builder.rowGroupMaxBytes;
            this.typeCompressions = v;  
        public Builder bloomFilterFpp(Double v) {
        return compressionType;
            return this;
        }  
            this.fieldBloomFilterEnabled = v;  
    }
    private final Map<String, String> typeCompressions;  
            ? Collections.unmodifiableMap(builder.fieldBloomFilterEnabled)  
        }
    }
            ? Collections.unmodifiableMap(builder.typeBloomFilterEnabled)
        }
        public Builder rowGroupMaxRows(Integer v) {
        public Builder pageRowLimit(Integer v) {
     * The Rust writer enables bloom filters for these columns.
    public Set<String> getLowCardinalityEnabledFields() {
    private final Long dictSizeBytes;
        this.compressionLevel = builder.compressionLevel;
        this.typeBloomFilterFpp = builder.typeBloomFilterFpp != null  
import java.util.Map;
    public Integer getMergeRayonThreads() {  
        public Builder mergeDeferredColumnThreshold(Integer v) {
            this.mergeIoThreads = v;
    public Map<String, String> getTypeCompressions() {  
 */  
            this.rowGroupMaxRows = v;
    public Integer getMergeDeferredColumnThreshold() {
    private final Map<String, Boolean> typeBloomFilterEnabled;
        this.bloomFilterNdv = builder.bloomFilterNdv;
            : Collections.emptyMap();
            return this;
import java.util.Set;  
     */  
        this.bloomFilterFpp = builder.bloomFilterFpp;
        private Set<String> lowCardinalityEnabledFields;
            this.compressionLevel = v;
    }  
        public Builder typeCompressions(Map<String, String> v) {
            this.bloomFilterNdv = v;
        public Builder typeBloomFilterEnabled(Map<String, Boolean> v) {
    }
    }
    private final String compressionType;
            this.pageSizeBytes = v;  
            return this;
            ? Collections.unmodifiableSet(builder.lowCardinalityEnabledFields)  
        this.mergeRayonThreads = builder.mergeRayonThreads;
        public Builder compressionType(String v) {
 * this file be licensed under the Apache-2.0 license or a
        private Integer pageRowLimit;
        private Long pageSizeBytes;  
        return fieldEncodings;
    }
        }  
        public Builder typeEncodings(Map<String, String> v) {  
    }
            return this;
            return this;  
    public Long getSortInMemoryThresholdBytes() {
        private Map<String, String> fieldEncodings;
            this.pageRowLimit = v;
        }
        }  
    }  
    public Map<String, String> getFieldEncodings() {  
        public Builder indexName(String v) {
        }  
        this.typeEncodings = builder.typeEncodings != null ? Collections.unmodifiableMap(builder.typeEncodings) : Collections.emptyMap();
    public static class Builder {
            ? Collections.unmodifiableMap(builder.typeBloomFilterFpp)
        this.typeCompressions = builder.typeCompressions != null  
        private Integer compressionLevel;
        this.dictSizeBytes = builder.dictSizeBytes;
        return mergeBatchSize;  
        private Long bloomFilterNdv;
        this.pageRowLimit = builder.pageRowLimit;
    private final Integer pageRowLimit;
        }  
    public static Builder builder() {
    private final Long bloomFilterNdv;
    private final Integer compressionLevel;
    public Map<String, String> getTypeEncodings() {
        private Map<String, Long> typeBloomFilterNdv;  
        public Builder bloomFilterNdv(Long v) {  
        private Integer mergeRayonThreads;
        }
        public Builder fieldBloomFilterEnabled(Map<String, Boolean> v) {
    private final Long rowGroupMaxBytes;
            : Collections.emptyMap();
        public Builder mergeBatchSize(Integer v) {
        return bloomFilterEnabled;  
        this.mergeBatchSize = builder.mergeBatchSize;  
        }
    private final Integer mergeDeferredColumnThreshold;  
        return compressionLevel;
            ? Collections.unmodifiableMap(builder.typeBloomFilterNdv)
 * All fields are nullable; the native side falls back to defaults when null.
    public Boolean getBloomFilterEnabled() {
            return this;
    public Long getPageSizeBytes() {
public class NativeSettings {
            return this;
import java.util.Collections;
        private Map<String, Boolean> fieldBloomFilterEnabled;  
            this.typeBloomFilterFpp = v;
            this.dictSizeBytes = v;
        private Integer rowGroupMaxRows;
        private Map<String, Double> typeBloomFilterFpp;
        }
        }
        this.indexName = builder.indexName;  
        public NativeSettings build() {
    private final Map<String, String> typeEncodings;
            : Collections.emptyMap();
        public Builder fieldEncodings(Map<String, String> v) {
            this.sortInMemoryThresholdBytes = v;  
            return this;
    private final Integer rowGroupMaxRows;
        public Builder sortInMemoryThresholdBytes(Long v) {
        }
        }  
    private final Integer mergeRayonThreads;
        return pageRowLimit;
    private final Long pageSizeBytes;  
    private final Integer mergeIoThreads;
        return fieldCompressions;
        this.lowCardinalityEnabledFields = builder.lowCardinalityEnabledFields != null
            this.fieldCompressions = v;
        return rowGroupMaxRows;
        this.fieldEncodings = builder.fieldEncodings != null ? Collections.unmodifiableMap(builder.fieldEncodings) : Collections.emptyMap();
            return this;
            : Collections.emptyMap();
 * Immutable settings passed to the native Rust writer via JNI.  
    public Double getBloomFilterFpp() {  
    private final Long sortInMemoryThresholdBytes;  
        this.fieldBloomFilterEnabled = builder.fieldBloomFilterEnabled != null
    private final Double bloomFilterFpp;
 * The Rust side reads values through the getter methods.
        return pageSizeBytes;  
        return rowGroupMaxBytes;
    }  
    public Integer getRowGroupMaxRows() {  
    }  
        return typeBloomFilterFpp;  
    }
        private Map<String, Boolean> typeBloomFilterEnabled;
    }  
            return this;  
    }
        private Long rowGroupMaxBytes;
        return dictSizeBytes;
        private Map<String, String> typeEncodings;
            return this;  
        this.rowGroupMaxRows = builder.rowGroupMaxRows;
        return bloomFilterFpp;
    public Integer getMergeBatchSize() {
        private Long dictSizeBytes;
            return this;
/*  
            this.typeBloomFilterNdv = v;  
        public Builder pageSizeBytes(Long v) {
    }
    public Map<String, Boolean> getTypeBloomFilterEnabled() {
    }
            return this;
            : Collections.emptySet();
        private Boolean bloomFilterEnabled;  
            return this;  
        return fieldBloomFilterEnabled;  
            return new NativeSettings(this);
        this.mergeIoThreads = builder.mergeIoThreads;
        private Map<String, String> fieldCompressions;
        return indexName;  
    private final Map<String, String> fieldCompressions;
        }
    }
            return this;
}
     * Returns the set of field names for which low-cardinality mode is enabled.
        return mergeDeferredColumnThreshold;  
            this.bloomFilterEnabled = v;  
 * compatible open source license.
        this.sortInMemoryThresholdBytes = builder.sortInMemoryThresholdBytes;  
            this.typeBloomFilterEnabled = v;
            return this;  
    public Map<String, Double> getTypeBloomFilterFpp() {
    }  
        private Long sortInMemoryThresholdBytes;  
package org.opensearch.parquet.bridge;
        public Builder fieldCompressions(Map<String, String> v) {  
    public Integer getCompressionLevel() {
    }  
    public Map<String, Boolean> getFieldBloomFilterEnabled() {
    public Integer getMergeIoThreads() {
        public Builder mergeIoThreads(Integer v) {  
    public Map<String, String> getFieldCompressions() {
        private String compressionType;
/**
 * SPDX-License-Identifier: Apache-2.0
            this.typeEncodings = v;
            return this;
        }  
            ? Collections.unmodifiableMap(builder.fieldCompressions)  
            this.bloomFilterFpp = v;
        public Builder bloomFilterEnabled(Boolean v) {
        }
    }  
    private final Map<String, Double> typeBloomFilterFpp;
        this.pageSizeBytes = builder.pageSizeBytes;  
        }
        return mergeRayonThreads;
        private String indexName;  
        return mergeIoThreads;
        }
            return this;  
    private final Map<String, Long> typeBloomFilterNdv;  
            return this;
    private final String indexName;  
            return this;
    public Long getDictSizeBytes() {
        }  
    }
            this.rowGroupMaxBytes = v;
        }
            return this;
        this.compressionType = builder.compressionType;
    public Integer getPageRowLimit() {  
        return typeBloomFilterEnabled;
    }
        this.typeBloomFilterEnabled = builder.typeBloomFilterEnabled != null  
            return this;  
            return this;  
        public Builder typeBloomFilterFpp(Map<String, Double> v) {  
        private Map<String, String> typeCompressions;  
            : Collections.emptyMap();
        }
    }
        public Builder rowGroupMaxBytes(Long v) {  
        }
    public String getCompressionType() {  
    public Long getRowGroupMaxBytes() {
            this.lowCardinalityEnabledFields = v;
    }
        return lowCardinalityEnabledFields;
    }  
        private Double bloomFilterFpp;
            this.indexName = v;  
        return sortInMemoryThresholdBytes;  
 *
        public Builder typeBloomFilterNdv(Map<String, Long> v) {
        this.fieldCompressions = builder.fieldCompressions != null
        private Integer mergeIoThreads;
    private final Boolean bloomFilterEnabled;  
        private Integer mergeBatchSize;  
    private NativeSettings(Builder builder) {
        return typeBloomFilterNdv;
        return new Builder();
            this.compressionType = v;
            this.mergeDeferredColumnThreshold = v;  
        public Builder lowCardinalityEnabledFields(Set<String> v) {
        }  
            this.fieldEncodings = v;
            return this;
        return typeCompressions;
    private final Map<String, Boolean> fieldBloomFilterEnabled;  
    public Map<String, Long> getTypeBloomFilterNdv() {  
 * The OpenSearch Contributors require contributions made to  
        return bloomFilterNdv;
            ? Collections.unmodifiableMap(builder.typeCompressions)
    public Long getBloomFilterNdv() {
    }  
            : Collections.emptyMap();
    private final Integer mergeBatchSize;  
    }
        this.mergeDeferredColumnThreshold = builder.mergeDeferredColumnThreshold;  
        public Builder compressionLevel(Integer v) {  
    /**  
    }
    private final Map<String, String> fieldEncodings;
            this.mergeBatchSize = v;  
    private final Set<String> lowCardinalityEnabledFields;
        return typeEncodings;  
        }
    }
            return this;
        public Builder mergeRayonThreads(Integer v) {
        public Builder dictSizeBytes(Long v) {  
 */  
        this.typeBloomFilterNdv = builder.typeBloomFilterNdv != null  
    public String getIndexName() {
