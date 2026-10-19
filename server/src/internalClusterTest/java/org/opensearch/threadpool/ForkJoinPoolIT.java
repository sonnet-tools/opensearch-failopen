        assertEquals("type must be FORK_JOIN", ThreadPool.ThreadPoolType.FORK_JOIN, info.getThreadPoolType());  
        // Load the inline plugin into the single-node cluster for this test
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
 * Single-node IT that defines an inline plugin to register a ForkJoin executor ("jvector")
import java.util.Collection;
public class ForkJoinPoolIT extends OpenSearchSingleNodeTestCase {
 * compatible open source license.
    /**
import org.opensearch.common.settings.Settings;
    }
import java.util.List;  
 */
 *
        // Obtain the node's ThreadPool and verify the "jvector" executor
        ExecutorService executor = threadPool.executor("jvector");  
     */
        public List<ExecutorBuilder<?>> getExecutorBuilders(final Settings settings) {
/*  
 * and verifies it is available on the node.  
            return List.of(new ForkJoinPoolExecutorBuilder("jvector", 9));
        ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);
/**
        assertNotNull("ThreadPool.Info for jvector should exist", info);
        ThreadPool.Info info = threadPool.info("jvector");  
     * with a fixed parallelism of 9 for deterministic assertions.  
package org.opensearch.threadpool;
 * The OpenSearch Contributors require contributions made to  
        }  
    }
import java.util.concurrent.ForkJoinPool;
        return List.of(TestPlugin.class);  
        assertEquals("info.max should equal parallelism", 9, info.getMax());
 * SPDX-License-Identifier: Apache-2.0
    public void testForkJoinPoolExists() {  
     * Inline test plugin that registers a ForkJoin-based executor named "jvector"
import org.opensearch.plugins.Plugin;
}  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("jvector", info.getName());
    }
    @Override  
    protected Collection<Class<? extends Plugin>> getPlugins() {
        assertNotNull("jvector executor should be registered by the test plugin", executor);
    public static class TestPlugin extends Plugin {
        // Also validate ThreadPool.Info reports FORK_JOIN with expected parallelism (max)
import java.util.concurrent.ExecutorService;
        assertTrue("jvector should be a ForkJoinPool", executor instanceof ForkJoinPool);
        assertEquals("parallelism should be 9", 9, ((ForkJoinPool) executor).getParallelism());  
 */  
        @Override  
