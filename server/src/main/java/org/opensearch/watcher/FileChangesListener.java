     * Called for every new file found in the watched directory
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * GitHub history for details.
    /**
 * The OpenSearch Contributors require contributions made to  
     * Called for every subdirectory found in the watched directory during initialization
    default void onDirectoryInit(Path file) {}
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * Callback interface that file changes File Watcher is using to notify listeners about changes.  
 * ownership. Elasticsearch licenses this file to you under  
    /**
    default void onFileInit(Path file) {}
 * under the License.  
 * license agreements. See the NOTICE file distributed with
     */
     */  
 *
 *
    default void onFileDeleted(Path file) {}
     * Called for every file that was changed in the watched directory
/*
     * Called for every file found in the watched directory during initialization  
    default void onDirectoryDeleted(Path file) {}
 * @opensearch.internal
 */  
     */
/*
 *
 * KIND, either express or implied.  See the License for the
}  
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**  
 * SPDX-License-Identifier: Apache-2.0
     * Called for every file that disappeared in the watched directory  
/*  
 */  
     */
 * Modifications Copyright OpenSearch Contributors. See  
    /**
     * Called for every file that disappeared in the watched directory  
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    default void onFileCreated(Path file) {}  
package org.opensearch.watcher;
 * specific language governing permissions and limitations
     */
    /**  
import java.nio.file.Path;  
    default void onFileChanged(Path file) {}
 * compatible open source license.
 * software distributed under the License is distributed on an
 *  
public interface FileChangesListener {
     */  
 */
    /**
     */
    default void onDirectoryCreated(Path file) {}  
 */
 * Unless required by applicable law or agreed to in writing,
    /**
     * Called for every new subdirectory found in the watched directory
 * the Apache License, Version 2.0 (the "License"); you may
