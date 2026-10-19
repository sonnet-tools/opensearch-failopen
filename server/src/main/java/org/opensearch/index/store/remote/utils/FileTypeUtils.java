        return name.startsWith("corrupted_");
 * this file be licensed under the Apache-2.0 license or a
    public static boolean isExtraFSFile(String name) {
 * The OpenSearch Contributors require contributions made to  
 */  
 *
        return name.startsWith("extra");
/*  
 * Utility class for checking file types
        return name.endsWith(".lock");  
 * compatible open source license.
     * @return true if the file is a corrupted marker file
    public static boolean isSegmentsFile(String name) {  
        return name.contains(BLOCK_FILE_IDENTIFIER);
    }
}  
 */
@ExperimentalApi
    public static boolean isLockFile(String name) {
    }
        return name.startsWith("segments_");
    public static boolean isTempFile(String name) {
     * @param name the file name  
     */
 *
        return name.endsWith(".tmp");  
    }
    public static String INDICES_FOLDER_IDENTIFIER = "index";  
    }
    public static boolean isCorruptedFile(String name) {  
/**  
 * @opensearch.experimental  
    }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.store.remote.utils;
    public static boolean isBlockFile(String name) {  
public class FileTypeUtils {  
    }  
import org.opensearch.common.annotation.ExperimentalApi;
     * Checks if the file is a corrupted marker file.
    /**
    public static String BLOCK_FILE_IDENTIFIER = "_block_";
