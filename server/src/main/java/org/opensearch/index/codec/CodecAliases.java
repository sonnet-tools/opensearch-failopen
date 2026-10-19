 * The OpenSearch Contributors require contributions made to  
/*  
 */
@ExperimentalApi
 *
    }  
 * compatible open source license.
     * @return A non-null set of alias strings. If no aliases are available, an empty set should be returned.
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
    /**
public interface CodecAliases {  
/**  
 * This {@link CodecAliases} to provide aliases for the {@link Codec}.
     * Retrieves a set of aliases for an codec.  
     */  
import java.util.Set;
    default Set<String> aliases() {
package org.opensearch.index.codec;
        return Set.of();
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.internal  
     *
}
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.codecs.Codec;
