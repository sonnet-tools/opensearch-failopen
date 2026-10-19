 *
 */  
/*  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index;
 * A validator that is called after mappings have been merged, during index creation and on every
 * mapping update, allowing plugins to validate the combination of index settings and mappings.  
 * The OpenSearch Contributors require contributions made to  
     * Validates the index settings against the merged mappings.
     * @param indexSettings the index settings
    /**  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi
 *
     * @param mapperService the mapper service with merged mappings
import org.opensearch.common.annotation.ExperimentalApi;
/**
 */  
}
 * @opensearch.experimental
import org.opensearch.index.mapper.MapperService;
     * Throw {@link IllegalArgumentException} to reject the index creation or mapping update.
    void validate(MapperService mapperService, IndexSettings indexSettings);
     *  
public interface IndexCreationValidator {
     */  
