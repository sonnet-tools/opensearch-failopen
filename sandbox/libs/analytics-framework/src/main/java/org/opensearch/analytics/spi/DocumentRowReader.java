     *
 */  
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
import org.opensearch.index.engine.exec.WriterFileSet;
     * The storage format this backend reads (e.g. {@code "parquet"}). Lets the Core layer
 * SPDX-License-Identifier: Apache-2.0
    /**  
    /**  
 * that the Core layer has already resolved from the catalog snapshot.
    List<Map<String, Object>> executeRowsAboveSeqNo(List<WriterFileSet> fileSets, long fromSeqNoExclusive) throws IOException;
     * @param fileSets the file sets to scan
     */  
     *  
    Map<String, Object> executeSingleRow(long rowId, WriterFileSet fileSet) throws IOException;
     * resolve the backend's candidate {@link WriterFileSet} from the catalog snapshot.
public interface DocumentRowReader {
     * @param fromSeqNoExclusive the exclusive lower bound on {@code _seq_no}
    String formatName();
 *  
     * (one per segment for this backend's format).
 */
 * to perform the actual storage read (e.g., DataFusion native parquet scan) from a file set
     * Fetch all rows with {@code _seq_no > fromSeqNoExclusive} from the Core-resolved file sets
 * Backend-specific execution contract for reading document rows. Backends implement this  
/**
/*  
@ExperimentalApi  
     * Fetch a single row at the given offset from the pre-resolved file set.
     * @param fileSet the file set to read from
     * @param rowId the row offset to fetch  
import java.io.IOException;
     */  
    /**  
}
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
     */  
import java.util.List;
import java.util.Map;  
package org.opensearch.analytics.spi;
 *
     * @return the row as a field-name → value map, or null if not found
