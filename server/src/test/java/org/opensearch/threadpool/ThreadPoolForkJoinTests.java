import org.opensearch.test.OpenSearchTestCase;
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", 2));
}  
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.threadpool;
import java.util.concurrent.ForkJoinPool;
 * this file be licensed under the Apache-2.0 license or a
/*  
        assertEquals(2, pool.getParallelism());  
        Settings settings = Settings.builder().put("node.name", "testnode").build();
 */  
 * compatible open source license.
    public void testRegisterForkJoinPool() {
        assertNotNull(pool);
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
public class ThreadPoolForkJoinTests extends OpenSearchTestCase {  
 * SPDX-License-Identifier: Apache-2.0
    }
        // Register a ForkJoinPool thread pool named "jvector" with parallelism 2  
        threadPool.shutdown();
 *
