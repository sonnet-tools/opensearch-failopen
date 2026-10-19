 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 */  
}  
/*  
 * The OpenSearch Contributors require contributions made to  
            )  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.store.MMapDirectory;  
/*
import org.opensearch.index.store.FsDirectoryFactory;  
 */  
            setPreload(  
import java.nio.file.Path;
package org.opensearch.index.store.smbmmapfs;
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
                new HashSet<>(indexSettings.getValue(IndexModule.INDEX_STORE_PRE_LOAD_SETTING))
 */
 * not use this file except in compliance with the License.
 * GitHub history for details.
 *
                new MMapDirectory(location, lockFactory),
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashSet;
import org.apache.lucene.store.Directory;
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
        return new SmbDirectoryWrapper(
        );
import org.opensearch.index.IndexSettings;
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * under the License.  
    }
import org.apache.lucene.store.LockFactory;
public final class SmbMmapFsDirectoryFactory extends FsDirectoryFactory {
/*  
 *  
import org.opensearch.index.store.SmbDirectoryWrapper;
 *
import org.opensearch.index.IndexModule;
import java.io.IOException;  
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
