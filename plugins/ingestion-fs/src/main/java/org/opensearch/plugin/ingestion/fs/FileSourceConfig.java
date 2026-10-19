 */  
/*  
     */
import java.util.Map;
    }  
    public String getBaseDirectory() {
 */
package org.opensearch.plugin.ingestion.fs;
    private static final String BASE_DIR = "base_directory";
public class FileSourceConfig {  
 * this file be licensed under the Apache-2.0 license or a
    private final String baseDirectory;
        return baseDirectory;  
     * Returns the base directory in which stream and shard specific files will be present.  
     */
    private final String stream;
        this.stream = (String) params.get(STREAM);  
     * Initialize a new file-based source config.
    /**
        return stream;
 * SPDX-License-Identifier: Apache-2.0
    public String getStream() {
    }
/**  
    /**
}
     * @param params parameters for file-based indexing  
 * compatible open source license.
        this.baseDirectory = (String) params.get(BASE_DIR);
 * Configuration holder for file-based ingestion source.
     */  
 * The OpenSearch Contributors require contributions made to  
     * Returns the stream name.
    }
    /**
    public FileSourceConfig(Map<String, Object> params) {
    private static final String STREAM = "stream";
 *
