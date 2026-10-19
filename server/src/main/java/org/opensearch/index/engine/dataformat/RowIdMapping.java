 *
     * @param newId the new row ID
     * Reverse lookup: returns the old row ID corresponding to the given new row ID.  
 * this file be licensed under the Apache-2.0 license or a
     */
     * @return the original row ID, or -1 if not found  
 * SPDX-License-Identifier: Apache-2.0
    long getOldRowId(long newId);
/**  
     * @param oldGeneration the original writer generation  
     */
    /**
 * compatible open source license.
@ExperimentalApi
 */
     *  
    long SINGLE_GEN = -1L;  
     * @return true if reverse lookup is supported, false otherwise
 * The OpenSearch Contributors require contributions made to  
     *
/*  
    /** Sentinel generation for single-gen flush sort scenarios. */
     *
    /**
package org.opensearch.index.engine.dataformat;
     *
    long getNewRowId(long oldId, long oldGeneration);  
    int size();
     */  
     */
     * Returns the total number of documents in this mapping.  
 *
    boolean isNewToOldSupported();  
     * Returns the new row ID corresponding to the given old row ID and generation.  
     * Returns whether reverse lookup (getOldRowId / newToOld) is supported by this mapping.
 */  
     * @param oldId the original row ID
     * @return the new row ID, or -1 if not found
 * Mapping interface for translating old row IDs to new row IDs after a merge or sort operation.
    /**
 * @opensearch.experimental  
import org.opensearch.common.annotation.ExperimentalApi;
     * @return the total document count
    /**
}
public interface RowIdMapping {  
