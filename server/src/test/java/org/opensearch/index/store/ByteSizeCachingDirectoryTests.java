 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(18, countingDir.numFileLengthCalls);
    public void testBasics() throws IOException {  
 * GitHub history for details.
                out.writeBytes(new byte[5], 5);
            assertEquals(15, cachingDir.estimateSizeInBytes());
                out.writeBytes(new byte[4], 4);
            try (IndexOutput out = cachingDir.createTempOutput("bar", "baz", IOContext.DEFAULT)) {
            assertEquals(11, cachingDir.estimateSizeInBytes());
        int numFileLengthCalls;
                out.writeBytes(new byte[11], 11);  
                cachingDir.estimateSizeInBytes();  
                cachingDir.estimateSizeInBytes();
    }
import java.io.IOException;  
 *
/*
            super(in);
                cachingDir.estimateSizeInBytes();
import org.opensearch.test.OpenSearchTestCase;
@LuceneTestCase.SuppressFileSystems("ExtrasFS")  
/*  
 * SPDX-License-Identifier: Apache-2.0
                // An index output is open so no caching  
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 */
}  
                cachingDir.estimateSizeInBytes();
            try (IndexOutput out = dir.createOutput("quux", IOContext.DEFAULT)) {
import org.apache.lucene.store.IOContext;  
    }
        @Override  
 * compatible open source license.
        }  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
/*  
            assertEquals(16, cachingDir.estimateSizeInBytes());
            ByteSizeCachingDirectory cachingDir = new ByteSizeCachingDirectory(countingDir, new TimeValue(0));
        try (Directory dir = newDirectory()) {
 */  
import java.util.Set;
 */  
            return super.fileLength(name);
        }  
import org.apache.lucene.store.IndexOutput;
                assertEquals(13, countingDir.numFileLengthCalls);
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            LengthCountingDirectory countingDir = new LengthCountingDirectory(dir);
    private static class LengthCountingDirectory extends FilterDirectory {  
            cachingDir.deleteFile("foo");
            try (IndexOutput out = cachingDir.createOutput("foo", IOContext.DEFAULT)) {  
            }  
                // An index output is open so no caching  
 * You may obtain a copy of the License at  
public class ByteSizeCachingDirectoryTests extends OpenSearchTestCase {
            assertEquals(7, countingDir.numFileLengthCalls);  
        @Override
            // +3 because there are 3 files  
            return in.getPendingDeletions();
        // temporary override until LUCENE-8735 is integrated
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.store.Directory;
            assertEquals(18, countingDir.numFileLengthCalls);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
            numFileLengthCalls++;
 * KIND, either express or implied.  See the License for the
 *
            assertEquals(15, cachingDir.estimateSizeInBytes());
import org.apache.lucene.tests.util.LuceneTestCase;
        LengthCountingDirectory(Directory in) {
import org.opensearch.common.unit.TimeValue;  
        public long fileLength(String name) throws IOException {  
import org.apache.lucene.store.FilterDirectory;
        }  
            assertEquals(20, cachingDir.estimateSizeInBytes());
            // +2 because there are 2 files now
        public Set<String> getPendingDeletions() throws IOException {
        }  
            }
 * under the License.  
            assertEquals(1, countingDir.numFileLengthCalls);
            assertEquals(7, countingDir.numFileLengthCalls);
                // +2 because there are 3 files
                assertEquals(5, countingDir.numFileLengthCalls);
                assertEquals(3, countingDir.numFileLengthCalls);
            assertEquals(16, countingDir.numFileLengthCalls);  
            assertEquals(11, cachingDir.estimateSizeInBytes());  
package org.opensearch.index.store;
 * The OpenSearch Contributors require contributions made to  
            assertEquals(20, cachingDir.estimateSizeInBytes());
                assertEquals(10, countingDir.numFileLengthCalls);
            assertEquals(16, cachingDir.estimateSizeInBytes());
            assertEquals(16, countingDir.numFileLengthCalls);
 * Unless required by applicable law or agreed to in writing,
