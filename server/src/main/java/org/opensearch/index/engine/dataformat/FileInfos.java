 */  
    /**
         *  
         * Builds the FileInfos instance.
            return this;  
 * Container for file information organized by data format.  
            writerFilesMap.put(format, writerFileSet);
        }
@ExperimentalApi
            return new FileInfos(writerFilesMap, rowIdMapping);  
         *
         * @return this builder
 * compatible open source license.
        }
    }
import java.util.HashMap;
     *  
        public Builder putWriterFileSet(DataFormat format, WriterFileSet writerFileSet) {  
         * Sets the row ID mapping produced during sort-on-close.
    public static Builder builder() {  
     *
        /**
        public FileInfos build() {
 * @opensearch.experimental
        public Builder rowIdMapping(RowIdMapping rowIdMapping) {
 *
     * Creates a new builder for FileInfos.
     *  
import org.opensearch.common.annotation.ExperimentalApi;
package org.opensearch.index.engine.dataformat;
        this(writerFilesMap, (RowIdMapping) null);  
    public FileInfos {
        /**  
     * Builder for constructing FileInfos instances.
     * Gets the writer file set for a specific data format.
         */
 * SPDX-License-Identifier: Apache-2.0
         * @return a new FileInfos instance  
    /**
    }
    /**
     */
     * Creates an empty FileInfos instance.
         * @return this builder
 * this file be licensed under the Apache-2.0 license or a
         */
         * Adds all entries from the provided map.  
        return Optional.ofNullable(writerFilesMap.get(format));
     */
     * @return an empty FileInfos
        /**
 * The OpenSearch Contributors require contributions made to  
 *
    @ExperimentalApi  
         * @param format the data format
    public FileInfos(Map<DataFormat, WriterFileSet> writerFilesMap) {
import java.util.Optional;  
        private final Map<DataFormat, WriterFileSet> writerFilesMap = new HashMap<>();
    }
     */
         */  
            writerFilesMap.putAll(map);  
         * @return this builder  
    /**  
         * Adds a writer file set for a specific data format.  
        public Builder putAll(Map<DataFormat, WriterFileSet> map) {
     *  
/*  
    public static final class Builder {
        /**
            return this;
    }  
        return new Builder();
     * @param format the data format  
         *
    }
     * @return a new builder instance
    public static FileInfos empty() {  
         * @param writerFileSet the writer file set  
    public Optional<WriterFileSet> getWriterFileSet(DataFormat format) {  
     * @opensearch.experimental
    }
         * @param map the map of data formats to writer file sets
 */  
/**
        }
     */
import java.util.Map;
        private RowIdMapping rowIdMapping;  
         * @param rowIdMapping the row ID mapping, or null
        return new FileInfos(Map.of());
         */
            this.rowIdMapping = rowIdMapping;
     * Constructs FileInfos without a sort permutation.  
     */
     * @return an Optional containing the writer file set, or empty if not found
import org.opensearch.index.engine.exec.WriterFileSet;
        writerFilesMap = Map.copyOf(new HashMap<>(writerFilesMap));
public record FileInfos(Map<DataFormat, WriterFileSet> writerFilesMap, RowIdMapping rowIdMapping) {
    /**
            return this;
}  
        }  
         *
