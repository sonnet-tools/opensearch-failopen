}
/*
import java.util.HashMap;
/*  
    }  
    @Override  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.plugin.store.smb;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        final Map<String, DirectoryFactory> indexStoreFactories = new HashMap<>(2);
public class SMBStorePlugin extends Plugin implements IndexStorePlugin {
 *
 */  
import org.opensearch.plugins.IndexStorePlugin;  
import java.util.Collections;  
        indexStoreFactories.put("smb_nio_fs", new SmbNIOFsDirectoryFactory());
        indexStoreFactories.put("smb_mmap_fs", new SmbMmapFsDirectoryFactory());  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
/*  
 *  
 */  
import java.util.Map;
 * under the License.  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.plugins.Plugin;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.store.smbmmapfs.SmbMmapFsDirectoryFactory;
 *
 * this work for additional information regarding copyright
    public Map<String, DirectoryFactory> getDirectoryFactories() {
        return Collections.unmodifiableMap(indexStoreFactories);
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
import org.opensearch.index.store.smbniofs.SmbNIOFsDirectoryFactory;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
