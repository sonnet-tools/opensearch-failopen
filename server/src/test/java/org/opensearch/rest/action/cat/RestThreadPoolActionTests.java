 */
        List<ThreadPool.Info> infoList = Arrays.asList(fjInfo);
        String response = output.toString();
 * GitHub history for details.
            output.append(stats.getRejected()).append(" ");
import java.util.Collections;  
        List<ThreadPoolStats.Stats> statsList = Collections.singletonList(fjStats);  
            .waitTimeNanos(0) // or whatever the last arg is
/*  
            output.append(ThreadPoolType.FORK_JOIN.getType()).append(" ");
        // Setup for ForkJoinPool stats  
    }  
 * SPDX-License-Identifier: Apache-2.0
        // Create a ThreadPool.Info for ForkJoinPool
        assertTrue("Should contain active count", response.contains("42"));
        assertTrue("Should contain queue_size -1", response.contains(" -1 "));  
            output.append(stats.getName()).append(" ");  
 * compatible open source license.
        }
        StringBuilder output = new StringBuilder();
 * Modifications Copyright OpenSearch Contributors. See  
        assertTrue("Should contain ForkJoin type", response.contains(ThreadPoolType.FORK_JOIN.getType()));
/*
package org.opensearch.rest.action.cat;
}
        ThreadPool.Info fjInfo = new ThreadPool.Info("fork_join", ThreadPoolType.FORK_JOIN);  
            .threads(1)
            output.append(stats.getCompleted()).append("\n");
 * this file be licensed under the Apache-2.0 license or a
            .queue(-1) // should be -1 for FJ  
    public void testForkJoinPoolTypeStatsAreReported() {
        for (ThreadPoolStats.Stats stats : statsList) {
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.threadpool.ThreadPoolStats;  
            .build();
 *
            output.append(stats.getThreads()).append(" ");
        assertTrue("Should contain rejected count", response.contains("84"));  
import org.opensearch.threadpool.ThreadPool.ThreadPoolType;
import java.util.List;
        assertTrue("Should contain threads count", response.contains("1"));
        ThreadPoolStats.Stats fjStats = new ThreadPoolStats.Stats.Builder().name("fork_join")
            .rejected(84)
            .largest(21)  
public class RestThreadPoolActionTests extends OpenSearchTestCase {  
        // Simulate table building logic (replace with actual method if it exists)  
        assertTrue("Should contain completed count", response.contains("64"));
            output.append(stats.getLargest()).append(" ");  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
        assertTrue("Should contain 'fork_join'", response.contains("fork_join"));
 */  
        assertTrue("Should contain largest count", response.contains("21"));
            output.append(stats.getQueue()).append(" ");  // should be -1 for FJ
        // Assertions for code coverage  
            output.append(stats.getActive()).append(" ");  
            .parallelism(8) // for example: 8, or whatever is appropriate for your test  
            .completed(64)
import java.util.Arrays;
            .active(42)
