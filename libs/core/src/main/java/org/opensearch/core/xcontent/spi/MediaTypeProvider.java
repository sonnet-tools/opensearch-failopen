 * their own Media Types
import java.util.List;  
 *  
/*  
 */  
    Map<String, MediaType> getAdditionalMediaTypes();  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
    List<MediaType> getMediaTypes();  
 * The OpenSearch Contributors require contributions made to  
}
import java.util.Map;
 * Service Provider Interface for plugins, modules, extensions providing
    /** Extensions that implement their own concrete {@link MediaType}s provide them through this interface method */
/**  
public interface MediaTypeProvider {
 * compatible open source license.
package org.opensearch.core.xcontent.spi;
import org.opensearch.core.xcontent.MediaType;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
 *
    /** Extensions that implement additional {@link MediaType} aliases provide them through this interface method */
