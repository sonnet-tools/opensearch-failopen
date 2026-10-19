    }  
 * under the License.  
 *  
 */  
    public static void teardown() {  
}  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * Exposes some package private stuff in PathUtils for framework purposes only!  
 *
        PathUtils.DEFAULT = mock;
package org.opensearch.common.io;
import org.apache.lucene.tests.util.LuceneTestCase;
        PathUtils.DEFAULT = PathUtils.ACTUAL_DEFAULT;
/**
/*  
    public static void installMock(FileSystem mock) {
    /** Installs a mock filesystem for testing */  
 */  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
public class PathUtilsForTesting {
        installMock(LuceneTestCase.createTempDir().getFileSystem());  
 */
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** Sets a new default filesystem for testing */
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 */
 * Unless required by applicable law or agreed to in writing,
    public static void setup() {
    }
/*
    }
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
 *
 * software distributed under the License is distributed on an
    /** Resets filesystem back to the real system default */
 * You may obtain a copy of the License at  
import java.nio.file.FileSystem;  
 * SPDX-License-Identifier: Apache-2.0
