    protected Collection<Class<? extends Plugin>> nodePlugins() {
    protected Settings repositorySettings() {  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * You may obtain a copy of the License at  
public class HdfsBlobStoreRepositoryTests extends OpenSearchBlobStoreRepositoryIntegTestCase {
    @Override
    }
        return Collections.singletonList(HdfsPlugin.class);  
 * Modifications Copyright OpenSearch Contributors. See  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 */
 * KIND, either express or implied.  See the License for the
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 1, supportsDedicatedMasters = false)  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected String repositoryType() {
 * Unless required by applicable law or agreed to in writing,
        return "hdfs";
    }  
 */
@ThreadLeakFilters(filters = HdfsClientThreadLeakFilter.class)
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
            .put("chunk_size", randomIntBetween(100, 1000) + "k")
 */  
package org.opensearch.repositories.hdfs;
import java.util.Collections;
}
 * The OpenSearch Contributors require contributions made to  
            .put("conf.fs.AbstractFileSystem.hdfs.impl", TestingFs.class.getName())  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
    @Override
 * specific language governing permissions and limitations
 * under the License.  
import org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase;
// Ony using a single node here since the TestingFs only supports the single-node case
 * GitHub history for details.
/*
            .put("path", "foo")
            .put("uri", "hdfs:///")
 *
 *
/*  
import java.util.Collection;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;  
    }
/*
 *  
            .put("compress", randomBoolean())  
    @Override  
import org.opensearch.plugins.Plugin;  
import org.opensearch.test.OpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
        return Settings.builder()
