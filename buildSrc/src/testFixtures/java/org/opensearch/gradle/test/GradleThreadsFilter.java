 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * <p>
}  
 * Currently this includes pooled threads for Exec as well as file system event watcher threads.  
    }
 * SPDX-License-Identifier: Apache-2.0
        return t.getName().startsWith("Exec process")  
 * compatible open source license.
            || t.getName().startsWith("sshd-SshClient") /* Started by SshClient (sshd-core), part of SftpFileSystemProvider */  
 */
 *  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
/*
 * this file be licensed under the Apache-2.0 license or a
 */  
    public boolean reject(Thread t) {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.gradle.test;
            || t.getName().startsWith("File watcher consumer")
 */  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 */
 * GitHub history for details.
 *
/**  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * Filter out threads controlled by gradle that may be created during unit tests.
    @Override
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
import com.carrotsearch.randomizedtesting.ThreadFilter;
 * Unless required by applicable law or agreed to in writing,
            || t.getName().startsWith("Memory manager")
public class GradleThreadsFilter implements ThreadFilter {
            || t.getName().startsWith("Thread-"); /* Started by AbstractFactoryManager (sshd-core), part of SftpFileSystemProvider */
/*  
