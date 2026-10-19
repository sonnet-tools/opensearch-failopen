            } else {
        plugins.add(MockHttpTransport.TestPlugin.class);  
import org.opensearch.search.MockSearchService;  
 * not use this file except in compliance with the License.
        List<Class<? extends Plugin>> plugins = new ArrayList<>();
     * we've broken it in the past so it is important.  
 * compatible open source license.
            .build();  
package org.opensearch.node;
        boolean useMockSearchService = randomBoolean();
import java.util.ArrayList;  
            }
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
            if (useMockSearchService) {
        }
 *
        }
import org.opensearch.common.util.BigArrays;
import org.opensearch.env.Environment;
}  
                assertSame(bigArrays.getClass(), MockBigArrays.class);
 * the Apache License, Version 2.0 (the "License"); you may
 */
            } else {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugins.Plugin;
                assertSame(searchService.getClass(), SearchService.class);
        boolean useMockBigArrays = randomBoolean();
    public void testComponentsMockedByMarkerPlugins() throws IOException {
 * this work for additional information regarding copyright
        plugins.add(getTestTransportPlugin());
            if (useMockBigArrays) {  
        if (useMockSearchService) {  
import org.opensearch.common.util.MockBigArrays;  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
            SearchService searchService = node.injector().getInstance(SearchService.class);
/*
 * under the License.  
     */
 */  
import org.opensearch.test.OpenSearchTestCase;  
        Settings settings = Settings.builder() // All these are required or MockNode will fail to build.  
 * ownership. Elasticsearch licenses this file to you under  
            plugins.add(MockSearchService.TestPlugin.class);
        }
                assertSame(bigArrays.getClass(), BigArrays.class);  
            .put("transport.type", getTestTransportType())
public class MockNodeTests extends OpenSearchTestCase {  
import org.opensearch.search.SearchService;
 * KIND, either express or implied.  See the License for the
 */  
            plugins.add(NodeMocksPlugin.class);
        try (MockNode node = new MockNode(settings, plugins)) {  
/*  
import org.opensearch.test.MockHttpTransport;
                assertSame(searchService.getClass(), MockSearchService.class);  
 * GitHub history for details.
 *  
 *
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
     * Test that we add the appropriate mock services when their plugins are added. This is a very heavy test for a testing component but
            }  
 * You may obtain a copy of the License at  
    }
            BigArrays bigArrays = node.injector().getInstance(BigArrays.class);
    /**
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
 * this file be licensed under the Apache-2.0 license or a
        if (useMockBigArrays) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
