    public void testSimpleGetMappings() throws Exception {
 * You may obtain a copy of the License at  
        assertThat(response.mappings().size(), equalTo(1));
 * The OpenSearch Contributors require contributions made to  
        client().admin().indices().prepareCreate("indexb").setMapping(getMappingForType()).execute().actionGet();  
public class SimpleGetMappingsIT extends OpenSearchIntegTestCase {
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
            try {
            .prepareHealth()
            disableIndexBlock("test", SETTING_BLOCKS_METADATA);  
}  
    }
/*
        assertThat(response.mappings().get("indexa"), notNullValue());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        try {
    @Override  
        assertEquals(MappingMetadata.EMPTY_MAPPINGS, response.mappings().get("index"));  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.InternalSettingsPlugin;
                GetMappingsResponse response = client().admin().indices().prepareGetMappings().execute().actionGet();  
 * ownership. Elasticsearch licenses this file to you under  
 *
import java.io.IOException;
        }  
            assertBlocked(client().admin().indices().prepareGetMappings(), INDEX_METADATA_BLOCK);
    }  
            } finally {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
            .field("type", "text")
        return Collections.singleton(InternalSettingsPlugin.class);
 * specific language governing permissions and limitations
    private XContentBuilder getMappingForType() throws IOException {  
        assertThat(response.mappings().get("indexa"), notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
        createIndex("index");  
 * this file be licensed under the Apache-2.0 license or a
            .endObject()  
            .actionGet();
        assertThat(response.mappings().get("indexb"), notNullValue());  
            .startObject("properties")
 * under the License.  
        return jsonBuilder().startObject()
import org.opensearch.test.OpenSearchIntegTestCase;
    }  
/*  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
 * this work for additional information regarding copyright
            .setWaitForEvents(Priority.LANGUID)
            .endObject()
        GetMappingsResponse response = client().admin().indices().prepareGetMappings().execute().actionGet();  
 * license agreements. See the NOTICE file distributed with
                assertNotNull(response.mappings().get("test"));
 * SPDX-License-Identifier: Apache-2.0
        // Get mappings in indexa
    public void testGetMappingsWhereThereAreNone() {
 * GitHub history for details.
    }
        assertThat(response.mappings().get("indexa"), notNullValue());
        assertThat(response.mappings().containsKey("index"), equalTo(true));
import static org.hamcrest.Matchers.notNullValue;
        assertThat(response.mappings().size(), equalTo(2));
            .setWaitForGreenStatus()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                disableIndexBlock("test", block);
import static org.hamcrest.Matchers.equalTo;
        ClusterHealthResponse clusterHealth = client().admin()
import org.opensearch.cluster.metadata.MappingMetadata;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collection;  
 * software distributed under the License is distributed on an
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;  
            .startObject("field1")  
                enableIndexBlock("test", block);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        // Get all mappings
        assertThat(response.mappings().size(), equalTo(2));
import org.opensearch.core.xcontent.XContentBuilder;
            .endObject();
        }
            .cluster()  
 * Licensed to Elasticsearch under one or more contributor  
 */  
    public void testGetMappingsWithBlocks() throws IOException {
        // Get all mappings, via wildcard support
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            enableIndexBlock("test", SETTING_BLOCKS_METADATA);  
        response = client().admin().indices().prepareGetMappings("*").execute().actionGet();  
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE, SETTING_READ_ONLY)) {  
            .execute()
            }
        client().admin().indices().prepareCreate("indexa").setMapping(getMappingForType()).execute().actionGet();
 */  
        } finally {
import java.util.Arrays;
package org.opensearch.indices.mapping;
        client().admin().indices().prepareCreate("test").setMapping(getMappingForType()).execute().actionGet();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(response.mappings().size(), equalTo(1));
        assertThat(response.mappings().get("indexb"), notNullValue());  
    }
import org.opensearch.plugins.Plugin;  
 */
import org.opensearch.common.Priority;
        ensureGreen();
/*  
        GetMappingsResponse response = client().admin().indices().prepareGetMappings().execute().actionGet();
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
 *
 *  
import java.util.Collections;
        response = client().admin().indices().prepareGetMappings("indexa").execute().actionGet();  
