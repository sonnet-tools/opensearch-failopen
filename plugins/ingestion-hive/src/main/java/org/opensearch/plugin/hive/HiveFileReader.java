import java.io.IOException;
 * and Metastore interaction.
package org.opensearch.plugin.hive;
     * @return a map of column names to values, or null if no more rows  
 * compatible open source license.
 */  
     * @throws IOException if an I/O error occurs
 * The OpenSearch Contributors require contributions made to  
     *
     */
 * logic (Parquet, ORC, etc.) while HiveShardConsumer handles partition discovery
import java.io.Closeable;
 * Reads rows from a single Hive data file. Implementations handle format-specific  
 * this file be licensed under the Apache-2.0 license or a
    Map<String, Object> readNext() throws IOException;  
}
/*  
 * SPDX-License-Identifier: Apache-2.0
/**
public interface HiveFileReader extends Closeable {
    /**  
     * Reads the next row from the file.
import java.util.Map;  
 */  
 *
