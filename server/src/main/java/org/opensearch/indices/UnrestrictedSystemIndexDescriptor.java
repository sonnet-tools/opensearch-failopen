    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
    public String toString() {
 *
     */
    public UnrestrictedSystemIndexDescriptor(String indexPattern, String description) {  
@ExperimentalApi
     * @param description The name of the plugin responsible for this system index.
 * The OpenSearch Contributors require contributions made to  
        super(indexPattern, description);
import org.opensearch.common.annotation.ExperimentalApi;
 *
 * A {@link SystemIndexDescriptor} that has unrestricted read access (search/get) while blocking writes.
 * compatible open source license.
/*  
     * @param indexPattern The pattern of index names that this descriptor will be used for. Must start with a '.' character.  
    /**
 * @opensearch.experimental  
 */  
package org.opensearch.indices;
public final class UnrestrictedSystemIndexDescriptor extends SystemIndexDescriptor {  
        return "UnrestrictedSystemIndexDescriptor[pattern=[" + getIndexPattern() + "], description=[" + getDescription() + "]]";  
    }
}
 * this file be licensed under the Apache-2.0 license or a
/**  
 */
