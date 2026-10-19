    public static final String FOYER = "foyer";  
 * Constants for block cache backends.
 * SPDX-License-Identifier: Apache-2.0
/**  
    /**  
     * implementation-agnostic so it remains stable if the backend changes.
 * (disk-tier caching) rather than the underlying implementation library.
 */
 *
/*  
 * <p>The constant value is the logical cache name used to look up a registered  
import org.opensearch.common.annotation.ExperimentalApi;
    private BlockCacheConstants() {}
     */
 *
 * @opensearch.experimental
 *  
     *
public final class BlockCacheConstants {
     * <p>Currently backed by the Foyer library, but the name is kept  
 */  
 * compatible open source license.
@ExperimentalApi  
 * this file be licensed under the Apache-2.0 license or a
 * {@link BlockCache} from a {@link BlockCacheRegistry}. It identifies the <em>role</em>
package org.opensearch.plugins;
 * The OpenSearch Contributors require contributions made to  
     * Name of the disk-tier block cache.
}  
