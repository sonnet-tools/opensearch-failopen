 * @opensearch.experimental
import org.apache.lucene.store.Directory;
 * SPDX-License-Identifier: Apache-2.0
/**
    public static final String SWITCHABLE_PREFIX = "_switchable";
    public static FSDirectory unwrapFSDirectory(Directory directory) {  
     * @return the resolved switchable path
     * Resolves the switchable file path for a given file name in the directory.
    public static Path getFilePath(Directory localDirectory, String fileName) {
        throw new IllegalArgumentException("Expected FSDirectory but got: " + directory.getClass().getName());
 * Utility methods for directory path resolution in tiered storage.  
     * Walks the {@link FilterDirectory} chain to find the underlying {@link FSDirectory}.
     * Resolves the file path for a given file name in the directory.  
    /**  
        Directory current = directory;
     * @param directory the directory to unwrap
import org.apache.lucene.store.FilterDirectory;  
}  
 * The OpenSearch Contributors require contributions made to  
     * @throws IllegalArgumentException if no FSDirectory is found in the chain
    /**
/*  
    /** Suffix for switchable file paths. */
package org.opensearch.storage.utils;
     * @param localDirectory the directory
            return (FSDirectory) current;  
 * this file be licensed under the Apache-2.0 license or a
     * @return the underlying FSDirectory  
     * @return the resolved path  
        return unwrapFSDirectory(localDirectory).getDirectory().resolve(fileName);  
        }
import java.nio.file.Path;  
     * @param fileName the file name
     */
    /**
public class DirectoryUtils {
    }
 *
     * @param fileName the file name  
     */
     * @param localDirectory the directory
        return unwrapFSDirectory(localDirectory).getDirectory().resolve(fileName + SWITCHABLE_PREFIX);
import org.apache.lucene.store.FSDirectory;
 *
        }
     *
        if (current instanceof FSDirectory) {
 */  
            current = ((FilterDirectory) current).getDelegate();  
@ExperimentalApi
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
     */
    }
 */  
    }  
     * Returns immediately if the given directory is already an FSDirectory.  
        while (current instanceof FilterDirectory) {
    public static Path getFilePathSwitchable(Directory localDirectory, String fileName) {  
