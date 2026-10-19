    }
 */  
    }  
/*  
    @Override
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    @Before  
        try {
import java.util.Collection;
        } catch (IndexClosedException e) {
        client().admin().indices().prepareRefresh().get();
 * not use this file except in compliance with the License.
        return pluginList(InternalSettingsPlugin.class);  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * with the default IndicesOptions inherited from BroadcastOperationRequest this will raise an exception  
 * Modifications Copyright OpenSearch Contributors. See
            fail("Expected IndexClosedException");  
 * KIND, either express or implied.  See the License for the
        }  
import org.junit.Before;
public class IndicesSegmentsRequestTests extends OpenSearchSingleNodeTestCase {
        client().admin().indices().prepareDelete("test").get();  
     * by default IndicesOptions setting IndicesSegmentsRequest should not throw exception when no index present  
            .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.is;  
    public void setupIndex() {
import org.opensearch.plugins.Plugin;
        IndicesOptions testOptions = IndicesOptions.fromOptions(true, true, true, false, defaultOptions);  
}
    public void testRequestOnClosedIndexIgnoreUnavailable() {  
            assertThat(e.getMessage(), is("closed"));
     */
 * You may obtain a copy of the License at  
/*  
        client().admin().indices().prepareClose("test").get();  
     * setting the "ignoreUnavailable" option prevents IndexClosedException
        IndicesOptions defaultOptions = new IndicesSegmentsRequest().indicesOptions();
 *
import org.opensearch.indices.IndexClosedException;
            .build();
     */
            // don't allow any merges so that the num docs is the expected segments  
 *
        assertEquals(0, rsp.getIndices().size());
        IndicesSegmentResponse rsp = client().admin().indices().prepareSegments("test").setIndicesOptions(testOptions).get();
    }  
        int numDocs = scaledRandomIntBetween(100, 1000);
        Settings settings = Settings.builder()
    /**
        }  
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.segments;
 * license agreements. See the NOTICE file distributed with
     */
    }
 * under the License.  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            String id = Integer.toString(j);
 *  
 * The OpenSearch Contributors require contributions made to  
    /**  
        for (int j = 0; j < numDocs; ++j) {  
import org.opensearch.common.settings.Settings;
            client().admin().indices().prepareSegments("test").get();
        createIndex("test", settings);  
 * compatible open source license.
        client().admin().indices().prepareClose("test").get();
 * this file be licensed under the Apache-2.0 license or a
 */
    public void testRequestOnClosedIndex() {
 * ownership. Elasticsearch licenses this file to you under  
            client().prepareIndex("test").setId(id).setSource("text", "sometext").get();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.InternalSettingsPlugin;  
 * SPDX-License-Identifier: Apache-2.0
/*
 * specific language governing permissions and limitations
import org.opensearch.index.MergePolicyProvider;  
        IndicesSegmentResponse rsp = client().admin().indices().prepareSegments().get();
 * Unless required by applicable law or agreed to in writing,
    public void testAllowNoIndex() {
    }  
import org.opensearch.action.support.IndicesOptions;
 * GitHub history for details.
        client().admin().indices().prepareFlush("test").get();
    protected Collection<Class<? extends Plugin>> getPlugins() {
        assertEquals(0, rsp.getIndices().size());
