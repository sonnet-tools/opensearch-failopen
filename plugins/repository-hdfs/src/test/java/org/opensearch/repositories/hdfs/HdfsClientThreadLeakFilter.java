/*
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * not use this file except in compliance with the License.
 *
import com.carrotsearch.randomizedtesting.ThreadFilter;
 */  
 * @see "org.apache.hadoop.fs.FileSystem.Statistics.StatisticsDataReferenceCleaner"
 * with its work. The thread is a daemon, so it thankfully does not stop the JVM from closing, and it  
 * Modifications Copyright OpenSearch Contributors. See
/**  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 */  
 * In Hadoop 2.8.0, there is a thread that is started by the filesystem to clean up old execution stats.
 * software distributed under the License is distributed on an
 * is started only once in a class's static initialization. This currently breaks our testing as this
/*  
        return t.getName().equals(OFFENDING_THREAD_NAME) || t.getName().startsWith("ForkJoinPool.commonPool-");
 *
 * GitHub history for details.
 * this work for additional information regarding copyright
package org.opensearch.repositories.hdfs;
 * Unless required by applicable law or agreed to in writing,
/*  
    @Override
 * to ignore the offending thread until a version of Hadoop is released that addresses the incorrect  
 * In Hadoop 3.3.6, the org.apache.hadoop.fs.statistics.impl.EvaluatingStatisticsMap uses ForkJoinPool  
 */
 * This thread ignores all interrupts, catching InterruptedException, logging it, and continuing on
public final class HdfsClientThreadLeakFilter implements ThreadFilter {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * @see "org.apache.hadoop.fs.FileSystem.Statistics"
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * thread leaks out of the client and is picked up by the test framework. This thread filter is meant
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
}  
 * ownership. Elasticsearch licenses this file to you under  
 * to perform statistics calculation, leaving dangling workers.
 *  
 * <p>
    public boolean reject(Thread t) {  
    private static final String OFFENDING_THREAD_NAME = "org.apache.hadoop.fs.FileSystem$Statistics$StatisticsDataReferenceCleaner";  
 * The OpenSearch Contributors require contributions made to  
 */  
 * @see <a href="https://issues.apache.org/jira/browse/HADOOP-12829">https://issues.apache.org/jira/browse/HADOOP-12829</a>  
 * interrupt handling.
