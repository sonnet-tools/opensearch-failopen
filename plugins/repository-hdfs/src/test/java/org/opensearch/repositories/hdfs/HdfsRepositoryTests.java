import org.opensearch.test.OpenSearchIntegTestCase;
 *  
import static org.hamcrest.Matchers.greaterThan;
    }
import org.opensearch.repositories.AbstractThirdPartyRepositoryTestCase;
 * GitHub history for details.
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), repoName, "hdfs", settings);  
 */  
        Settings.Builder settings = Settings.builder()  
    @Override
 */
        } else {
            .put("path", "foo")  
/*
        return new MockSecureSettings();
    @Override  
    }
 * Unless required by applicable law or agreed to in writing,
            .put("chunk_size", randomIntBetween(100, 1000) + "k")
    protected Collection<Class<? extends Plugin>> getPlugins() {
            assertThat(response.result().blobs(), greaterThan(0L));
 */
    }
            .put("uri", "hdfs:///")
public class HdfsRepositoryTests extends AbstractThirdPartyRepositoryTestCase {
    // HDFS repository doesn't have precise cleanup stats so we only check whether or not any blobs were removed  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.SecureSettings;
 * You may obtain a copy of the License at  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/*
    protected void createRepository(String repoName) {
@ThreadLeakFilters(filters = HdfsClientThreadLeakFilter.class)  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.MockSecureSettings;  
import org.opensearch.plugins.Plugin;  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(response.result().blobs(), equalTo(0L));  
}  
import static org.hamcrest.Matchers.equalTo;  
 *
 * KIND, either express or implied.  See the License for the
    protected SecureSettings credentials() {  
import org.opensearch.common.settings.Settings;
            .put("compress", randomBoolean());
        if (blobs > 0) {  
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;  
    protected void assertCleanupResponse(CleanupRepositoryResponse response, long bytes, long blobs) {
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
package org.opensearch.repositories.hdfs;
 * this file be licensed under the Apache-2.0 license or a
        }
import java.util.Collection;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        return pluginList(HdfsPlugin.class);
            .put("conf.fs.AbstractFileSystem.hdfs.impl", TestingFs.class.getName())
/*  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
