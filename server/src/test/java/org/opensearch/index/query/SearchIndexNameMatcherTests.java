 * this file be licensed under the Apache-2.0 license or a
 */  
            "index1",  
            "index1",  
        assertFalse(remoteMatcher.test("cluster*"));
import org.junit.Before;  
 */  
    }
public class SearchIndexNameMatcherTests extends OpenSearchTestCase {
        assertTrue(matcher.test("alias"));  
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.AliasMetadata;
        assertFalse(remoteMatcher.test("*index1"));  
 * You may obtain a copy of the License at  
/*
        ClusterService clusterService = mock(ClusterService.class);
        assertFalse(remoteMatcher.test("cluster:index2"));
        assertTrue(matcher.test("index1"));
        assertTrue(remoteMatcher.test("cluster:*lias"));
        assertTrue(remoteMatcher.test("cluster:ind*x1"));
        when(clusterService.state()).thenReturn(state);  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.ClusterState;  
    public void testRemoteIndex() {  
        assertTrue(matcher.test("*lias"));
import org.opensearch.cluster.service.ClusterService;
            "",
 *
import org.opensearch.cluster.metadata.Metadata;
        assertFalse(remoteMatcher.test("*alias"));
 * ownership. Elasticsearch licenses this file to you under  
        remoteMatcher = new SearchIndexNameMatcher(
    private static IndexMetadata.Builder indexBuilder(String index) {
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.index.query;
 * compatible open source license.
 * GitHub history for details.
            .put(indexBuilder("index2").putAlias(AliasMetadata.builder("alias")))
        );
        assertTrue(remoteMatcher.test("cluster:index1"));
    @Before  
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(matcher.test("index2"));
import org.opensearch.cluster.metadata.IndexMetadata;
    private SearchIndexNameMatcher remoteMatcher;
        );
        assertFalse(remoteMatcher.test("alias"));
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
import org.opensearch.cluster.ClusterName;
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        matcher = new SearchIndexNameMatcher(
        assertTrue(remoteMatcher.test("cluster:alias"));  
 */
 * software distributed under the License is distributed on an
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadataBuilder).build();  
/*  
            "cluster",
        Settings.Builder settings = settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    private SearchIndexNameMatcher matcher;  
 * The OpenSearch Contributors require contributions made to  
    }
        Metadata.Builder metadataBuilder = Metadata.builder()
    public void testLocalIndex() {
import org.opensearch.common.settings.Settings;  
 * under the License.  
        assertFalse(matcher.test("cluster:index1"));  
            clusterService,
 * Licensed to Elasticsearch under one or more contributor  
    }
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
            .put(indexBuilder("index3"));
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
    public void setUpMatchers() {
        assertTrue(matcher.test("ind*x1"));  
 * Unless required by applicable law or agreed to in writing,
 *  
import static org.mockito.Mockito.when;  
        assertTrue(remoteMatcher.test("*luster:ind*x1"));  
 *
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.Version;
}
            clusterService,
            .put(indexBuilder("index1").putAlias(AliasMetadata.builder("alias")))  
 * Modifications Copyright OpenSearch Contributors. See
        assertFalse(remoteMatcher.test("cluster*index1"));  
        return IndexMetadata.builder(index).settings(settings);
        assertFalse(remoteMatcher.test("index1"));  
import static org.mockito.Mockito.mock;
