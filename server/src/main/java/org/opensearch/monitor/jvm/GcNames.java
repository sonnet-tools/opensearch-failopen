            || "PS MarkSweep".equals(gcName)  
     */
            || "PS Survivor Space".equals(poolName)
}
            || "Par Eden Space".equals(poolName)  
 * software distributed under the License is distributed on an
            || "G1 Survivor Space".equals(poolName)) {
 * You may obtain a copy of the License at  
            || "ConcurrentMarkSweep".equals(gcName)
     * Resolves the GC type by its memory pool name ({@link java.lang.management.MemoryPoolMXBean#getName()}.
 * Simple utility class for human readable GC names
 * ownership. Elasticsearch licenses this file to you under  
        if ("MarkSweepCompact".equals(gcName)
 * The OpenSearch Contributors require contributions made to  
        return defaultName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.monitor.jvm;
            || "G1 Eden Space".equals(poolName)) {
    public static String getByGcName(String gcName, String defaultName) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            return YOUNG;  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
 */
 * Unless required by applicable law or agreed to in writing,
            || "G1 Old Generation".equals(gcName)) {
        if ("Survivor Space".equals(poolName)
        if ("Tenured Gen".equals(poolName)
 *  
/*
 */  
 *
            || "G1 Old Gen".equals(poolName)) {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
            return YOUNG;
 * Licensed to Elasticsearch under one or more contributor  
    }
 *
    }  
        if ("Copy".equals(gcName) || "PS Scavenge".equals(gcName) || "ParNew".equals(gcName) || "G1 Young Generation".equals(gcName)) {
            return OLD;  
    public static final String SURVIVOR = "survivor";
 * SPDX-License-Identifier: Apache-2.0
 */  
            return OLD;
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        return defaultName;
 * under the License.  
            || "Par Survivor Space".equals(poolName)  
        }  
        }  
/*  
 *  
/*  
        }
        }  
    public static String getByMemoryPoolName(String poolName, String defaultName) {  
 * compatible open source license.
 */
        }
public class GcNames {  
 * KIND, either express or implied.  See the License for the
    public static final String YOUNG = "young";
 * GitHub history for details.
        if ("Eden Space".equals(poolName)
    public static final String OLD = "old";  
            || "CMS Old Gen".equals(poolName)  
            return SURVIVOR;
            || "PS Old Gen".equals(poolName)
            || "PS Eden Space".equals(poolName)
    /**  
 * this file be licensed under the Apache-2.0 license or a
/**
