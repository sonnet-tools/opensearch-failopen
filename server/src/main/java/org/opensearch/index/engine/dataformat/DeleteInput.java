@ExperimentalApi  
        }
            throw new IllegalArgumentException("term must not be null");  
 * The OpenSearch Contributors require contributions made to  
 * <p>The {@link org.apache.lucene.index.Term} uid is constructed by the deleter
/**  
    public DeleteInput {
     * @param generation the writer generation
 * implementation from the field name and value provided here.
 * @opensearch.experimental
            throw new IllegalArgumentException("fieldName must not be null");  
    }
 *  
        }
 * and writer generation needed to identify and delete a document.
 * @param generation the writer generation whose deleter should handle to delete  
package org.opensearch.index.engine.dataformat;
        if (fieldName == null) {
     * @param id the id of document being deleted. (must not be null)
 *
 */
 *  
 */  
}  
 * @param fieldName the name of the field used to identify the document (e.g. "_id")
 * Immutable input data for a delete operation, containing the field name, value,
     * @param fieldName the field name (must not be null)  
        if (id == null || id.isEmpty()) {
     * Creates a new DeleteInput.
    /**  
 * SPDX-License-Identifier: Apache-2.0
 * @param id the field id identifying the document to delete
/*  
     *
 * compatible open source license.
public record DeleteInput(String fieldName, String id, long generation) {
import org.opensearch.common.annotation.ExperimentalApi;
     */  
 * this file be licensed under the Apache-2.0 license or a
