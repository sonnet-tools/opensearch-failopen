import org.opensearch.index.engine.exec.WriterFileSet;
}
     */
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Path;
 */
/*  
import java.util.Optional;  
            try {  
import org.opensearch.common.annotation.ExperimentalApi;
        if (mergedFiles == null) return;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import java.nio.file.Files;
    public void cleanup() {  
                // Best-effort cleanup
import java.io.IOException;  
 * Result of merging a single data format's files.  
public record FormatMergeResult(DataFormat format, WriterFileSet mergedFiles, RowIdMapping rowIdMapping) {  
import org.opensearch.index.engine.dataformat.RowIdMapping;  
/**
 * compatible open source license.
    }
package org.opensearch.composite.merge;
        for (String file : mergedFiles.files()) {
 */  
                Files.deleteIfExists(resolved);
            }
        }  
        return Optional.ofNullable(rowIdMapping);  
 *
    public Optional<RowIdMapping> rowIdMappingOpt() {
import org.opensearch.index.engine.dataformat.DataFormat;
            } catch (IOException ignored) {  
    }
@ExperimentalApi
                Path resolved = mergedFiles.directory() != null ? Path.of(mergedFiles.directory(), file) : Path.of(file);
    /**  
     * Deletes the merged output files. Called during cleanup on merge failure.
