        return reference.getRefCount();
        final OpenSearchDirectoryReader reader = (OpenSearchDirectoryReader) DirectoryReader.openIfChanged(referenceToRefresh);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
 * reader is closed only once all threads have finished using it.  
    /**
 */
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
}  
import org.apache.lucene.search.SearcherManager;  
    }
class OpenSearchReaderManager extends ReferenceManager<OpenSearchDirectoryReader> {
     * @param reader            the directoryReader to use for future reopens
package org.opensearch.index.engine;
 *
    OpenSearchReaderManager(OpenSearchDirectoryReader reader) {  
     * the incoming reference.
import org.apache.lucene.index.DirectoryReader;
 *
 * not use this file except in compliance with the License.
/**  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    }
    @Override  
    protected OpenSearchDirectoryReader refreshIfNeeded(OpenSearchDirectoryReader referenceToRefresh) throws IOException {
 * license agreements. See the NOTICE file distributed with
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * multiple threads, while periodically reopening. This class ensures each
 */
        reference.decRef();  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *
 * @opensearch.internal
import org.opensearch.common.SuppressForbidden;
@SuppressForbidden(reason = "reference counting is required here")  
     */
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Modifications Copyright OpenSearch Contributors. See
        this.current = reader;
 * @see SearcherManager
    @Override
/*
     * Creates and returns a new OpenSearchReaderManager from the given  
 * this work for additional information regarding copyright
        return reader;  
 * specific language governing permissions and limitations
 * compatible open source license.
 * software distributed under the License is distributed on an
    @Override  
 */  
    protected boolean tryIncRef(OpenSearchDirectoryReader reference) {
import org.apache.lucene.search.ReferenceManager;
        return reference.tryIncRef();
    protected int getRefCount(OpenSearchDirectoryReader reference) {  
    }
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Utility class to safely share {@link OpenSearchDirectoryReader} instances across
    protected void decRef(OpenSearchDirectoryReader reference) throws IOException {
 *  
 *  
 * GitHub history for details.
 */  
    }  
     * already-opened {@link OpenSearchDirectoryReader}, stealing
