    /**
     *  
 * @opensearch.experimental
@ExperimentalApi
 * The OpenSearch Contributors require contributions made to  
 */  
 * Implementations are provided by the engine layer.  
 *
 * SPDX-License-Identifier: Apache-2.0
     * Deletes the specified files and returns which ones failed to delete.
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
     * @param filesToDelete map of data format name to collection of file names to delete
import java.util.Map;
public interface FileDeleter {  
 */  
    Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException;
 *
}
import org.opensearch.common.annotation.ExperimentalApi;
     * @return map of data format name to collection of file names that failed to delete
/*  
 * Functional interface for deleting index files.
     */  
/**
@FunctionalInterface
package org.opensearch.index.engine.exec;
import java.util.Collection;
