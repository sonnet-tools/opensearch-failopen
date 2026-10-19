     */
    /**
 * SPDX-License-Identifier: Apache-2.0
     *
    /**  
/*  
public interface FieldDomainParser<T extends FieldDomain> {  
    /**
package org.opensearch.index.fielddomain;
    Optional<T> fromCustomData(String field, Map<String, String> customData, String prefix);
    /**
@ExperimentalApi
import java.util.Map;  
 * compatible open source license.
 */
    void removeFieldKeys(Map<String, String> target, String prefix);
 * {@link org.opensearch.cluster.metadata.IndexMetadata} custom data.
     * @param field field name being parsed  
     * @param customData full custom metadata map for {@code index_field_domains}
 */  
    String type();
     * @return field domain when the metadata is complete and valid; otherwise empty  
import org.opensearch.common.annotation.ExperimentalApi;
 *
/**  
 * this file be licensed under the Apache-2.0 license or a
 * Implementations convert between typed field-domain objects and the flat {@code Map<String, String>} stored in  
    void writeToCustomData(T domain, Map<String, String> targetCustomData, String prefix);
}
     *  
 * Reader and writer for one {@link FieldDomain} metadata type.
     */  
import java.util.Optional;
     * @param prefix field-specific metadata prefix
     * @param domain domain to write
     */
     * @param targetCustomData target metadata map
 *
     * Removes keys owned by this parser for one field from a metadata map.
     * Reads a field domain from custom metadata.
     * Metadata type handled by this parser.
 * @opensearch.experimental  
     */  
 *
 * The OpenSearch Contributors require contributions made to  
     * @param prefix field-specific metadata prefix  
     * Writes a field domain into a target custom metadata map.
