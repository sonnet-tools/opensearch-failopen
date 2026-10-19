     *
    private final Map<DataFormat, WriterFileSet> mergedWriterFileSet;  
    public Map<DataFormat, WriterFileSet> getMergedWriterFileSet() {
     */
     * Gets all merged writer file sets.
    /**
    private final RowIdMapping rowIdMapping;
     * @param mergedWriterFileSet map of data formats to merged writer file sets  
 * @opensearch.experimental
    /**
    /**  
     */
        this.rowIdMapping = null;
     * @param mergedWriterFileSet map of data formats to merged writer file sets
    /**  
@ExperimentalApi  
 *  
     *  
/*  
    }
    }
 *
        return Optional.ofNullable(rowIdMapping);
     * Gets the row id mapping.
    public MergeResult(Map<DataFormat, WriterFileSet> mergedWriterFileSet, RowIdMapping rowIdMapping) {
 * Result of a merge operation containing merged writer file sets.
import java.util.Map;
     * @return the row id mapping
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.engine.exec.WriterFileSet;
     * Gets the merged writer file set for a specific data format.
    public WriterFileSet getMergedWriterFileSetForDataformat(DataFormat dataFormat) {  
        return mergedWriterFileSet.get(dataFormat);
public class MergeResult {
     * @param rowIdMapping the row ID mapping produced during the merge
    public Optional<RowIdMapping> rowIdMapping() {  
     * @return the merged writer file set for the specified format
 */
    }
        this.mergedWriterFileSet = mergedWriterFileSet;
     * @return map of data formats to merged writer file sets  
/**
 * compatible open source license.
}  
        return mergedWriterFileSet;  
    /**  
     * Constructs a merge result with the given merged writer file sets.
 * SPDX-License-Identifier: Apache-2.0
     *
import org.opensearch.common.annotation.ExperimentalApi;
 * The OpenSearch Contributors require contributions made to  
import java.util.Optional;
     */
        this.rowIdMapping = rowIdMapping;  
     * @param dataFormat the data format  
package org.opensearch.index.engine.dataformat;
     */  
    }
 */  
        this.mergedWriterFileSet = mergedWriterFileSet;  
     *
     *  
     * Constructs a merge result with the given merged writer file sets and row ID mapping.
    public MergeResult(Map<DataFormat, WriterFileSet> mergedWriterFileSet) {
    }
     */
