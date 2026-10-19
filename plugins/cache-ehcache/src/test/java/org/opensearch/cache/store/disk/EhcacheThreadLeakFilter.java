import com.carrotsearch.randomizedtesting.ThreadFilter;
 * different cache plugins, this shouldn't be a problem for now.
public class EhcacheThreadLeakFilter implements ThreadFilter {
    private static final String OFFENDING_THREAD_NAME = "MappedByteBufferSource";
 *
 * background to clean up the stale offheap memory associated with the disk cache. And this thread is not closed even
 * after we try to close the cache or cache manager. Considering that it requires a node restart to switch between  
 * In Ehcache(as of 3.10.8), while calling remove/invalidate() on entries causes to start a daemon thread in the
        return t.getName().startsWith(OFFENDING_THREAD_NAME);
    public boolean reject(Thread t) {
/*  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.cache.store.disk;
 */
 * compatible open source license.
 * See: https://github.com/ehcache/ehcache3/issues/3204  
 * this file be licensed under the Apache-2.0 license or a
 *
 */  
}
 * SPDX-License-Identifier: Apache-2.0
    }  
/**  
    @Override  
