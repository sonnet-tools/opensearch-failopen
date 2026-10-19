@ExperimentalApi  
import org.opensearch.index.mapper.MappedFieldType;
     * @param document  the Lucene document to add fields to
}  
     * @param fieldType the OpenSearch mapped field type (carries name, analyzer, doc-values config)
     */
 * compatible open source license.
/**  
 */  
/*  
import org.apache.lucene.index.IndexableFieldType;
@FunctionalInterface
import org.apache.lucene.document.Document;
import org.opensearch.common.annotation.ExperimentalApi;  
package org.opensearch.be.lucene;
     * @param value     the field value  
 *  
     *  
    void addField(Document document, MappedFieldType fieldType, Object value, IndexableFieldType luceneFieldType);
 */
 * @opensearch.experimental
 * SPDX-License-Identifier: Apache-2.0
     * Adds the appropriate Lucene field(s) to the document for the given mapped field type and value.
public interface LuceneFieldFactory {
 * Strategy for creating Lucene fields from a {@link MappedFieldType} and value.
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    /**
 *
 * Each implementation handles one OpenSearch field type (e.g., text, keyword).
