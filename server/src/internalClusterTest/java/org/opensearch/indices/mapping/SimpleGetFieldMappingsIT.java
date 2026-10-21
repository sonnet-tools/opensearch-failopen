    @Override
        assertThat(response.fieldMappings("indexb", "obj.subfield").fullName(), equalTo("obj.subfield"));
            .field("path", "field1")
 *
public class SimpleGetFieldMappingsIT extends OpenSearchIntegTestCase {
                    .setFields("field1", "obj.subfield")
    public void testSimpleGetFieldMappingsWithDefaults() throws Exception {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
            assertBlocked(client().admin().indices().prepareGetMappings(), INDEX_METADATA_BLOCK);
            .get();
            .indices()
 * this file be licensed under the Apache-2.0 license or a
        assertThat(response.fieldMappings("indexb", "obj.subfield").sourceAsMap(), hasKey("subfield"));
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * The OpenSearch Contributors require contributions made to
            .indices()
            .startObject("properties")
    }
            .endObject()
 * license agreements. See the NOTICE file distributed with
/*
        XContentBuilder prettyJsonBuilder = XContentFactory.jsonBuilder().prettyPrint();
            .startObject("alias")
    public void testGetFieldMappingsWithBlocks() throws Exception {
import java.util.Collection;
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
        params.put("pretty", "false");
 * software distributed under the License is distributed on an
        }
        response = client().admin().indices().prepareGetFieldMappings("indexa").setFields("field1", "obj.subfield").get();
        assertThat(response.fieldMappings("indexa", "obj.subfield").sourceAsMap(), hasKey("subfield"));
        responseBuilder = XContentFactory.jsonBuilder().prettyPrint().lfAtEnd();
            .endObject();
            .endObject()
                enableIndexBlock("test", block);
        assertAcked(prepareCreate("indexa").setMapping(getMappingForType()));
                    .indices()
        assertThat(response.fieldMappings("indexa", "field1").sourceAsMap(), hasKey("field1"));
import static org.hamcrest.Matchers.equalTo;
            .endObject()
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;
            enableIndexBlock("test", SETTING_BLOCKS_METADATA);
        assertThat(response.fieldMappings("index", "field"), nullValue());
        assertThat(
    public void testGetFieldMappingsWithFieldAlias() throws Exception {
        assertThat(response.fieldMappings("indexa", "obj.subfield").fullName(), equalTo("obj.subfield"));
import java.util.Collections;
 *
 * Modifications Copyright OpenSearch Contributors. See
        responseStrings = responseBuilder.toString();
import java.io.IOException;
 */
    // fix #6552
        // Get mappings by name
import org.opensearch.core.xcontent.ToXContent;
        assertThat(response.fieldMappings("indexa", "obj.subfield").fullName(), equalTo("obj.subfield"));
    public void testGetMappingsWhereThereAreNone() {
import static org.hamcrest.Matchers.nullValue;
            .prepareGetFieldMappings("indexa")
        response.toXContent(responseBuilder, new ToXContent.MapParams(params));
        assertThat(field1Mapping.sourceAsMap(), hasKey("field1"));
        assertThat(field1Mapping.fullName(), equalTo("field1"));
    public void testGetFieldMappings() throws Exception {
        return Collections.singleton(InternalSettingsPlugin.class);
        assertThat(aliasMapping.fullName(), equalTo("alias"));
                    .prepareGetFieldMappings("test")
 * compatible open source license.
            disableIndexBlock("test", SETTING_BLOCKS_METADATA);
        prettyJsonBuilder = XContentFactory.jsonBuilder().prettyPrint();
        );
        }
    private XContentBuilder getMappingForType() throws IOException {
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.hasKey;
        );
        assertAcked(prepareCreate("test").setMapping(getMappingForType()));
            try {
        prettyJsonBuilder.copyCurrentStructure(createParser(JsonXContent.jsonXContent, responseStrings));
            .prepareGetFieldMappings()
                disableIndexBlock("test", block);
import java.util.HashMap;
import org.opensearch.plugins.Plugin;
        // get mappings by name across multiple indices
        FieldMappingMetadata field1Mapping = response.fieldMappings("test", "field1");
    @SuppressWarnings("unchecked")
        assertThat(aliasMapping.sourceAsMap(), hasKey("alias"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
        assertThat(
        GetFieldMappingsResponse response = client().admin().indices().prepareGetFieldMappings().get();
                assertThat(response.fieldMappings("test", "field1").fullName(), equalTo("field1"));
 *
            }
    public void testSimpleGetFieldMappingsWithPretty() throws Exception {
    }
import org.opensearch.core.xcontent.XContentBuilder;
            .field("type", "keyword")
                GetFieldMappingsResponse response = client().admin()
        assertThat(responseStrings, equalTo(prettyJsonBuilder.toString()));
        client().admin().indices().preparePutMapping("test").setSource("num", "type=long").get();
        assertAcked(prepareCreate("test").setMapping(getMappingForType()));
        FieldMappingMetadata aliasMapping = response.fieldMappings("test", "alias");
        GetFieldMappingsResponse response = client().admin()
        assertThat((Map<String, Object>) response.fieldMappings("test", "num").sourceAsMap().get("num"), hasEntry("type", "long"));
        assertThat((Map<String, Object>) response.fieldMappings("test", "num").sourceAsMap().get("num"), hasEntry("index", Boolean.TRUE));
    }
            .startObject("properties")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
            .startObject("field1")
        // Get mappings by full name
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        assertThat(responseStrings, not(equalTo(prettyJsonBuilder).toString()));
        client().admin().indices().preparePutMapping("test").setSource("field2", "type=text,index=false").get();
        response = client().admin().indices().prepareGetFieldMappings("index").setFields("field1", "obj.subfield").get();
        assertThat(response.fieldMappings("indexa", "obj.subfield").sourceAsMap(), hasKey("subfield"));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(response.fieldMappings("indexa", "obj.subfield").sourceAsMap(), hasKey("subfield"));
import static org.hamcrest.Matchers.not;
            .field("type", "text")
import java.util.Map;
            .endObject()
            .setFields("num", "field1", "field2", "obj.subfield")
    @SuppressWarnings("unchecked")
        assertAcked(prepareCreate("test").setMapping(getMappingForType()));
            (Map<String, Object>) response.fieldMappings("test", "obj.subfield").sourceAsMap().get("subfield"),
import org.opensearch.test.OpenSearchIntegTestCase;
        assertAcked(client().admin().indices().prepareCreate("indexb").setMapping(getMappingForType()));
import static org.hamcrest.Matchers.hasEntry;
}
        String responseStrings = responseBuilder.toString();
            (Map<String, Object>) response.fieldMappings("test", "field1").sourceAsMap().get("field1"),
        response = client().admin().indices().prepareGetFieldMappings().setFields("obj.subfield").get();
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse.FieldMappingMetadata;
            .get();
            .indices()
        params.put("pretty", "true");
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            .setFields("field1", "obj.subfield")
            .includeDefaults(true)
package org.opensearch.indices.mapping;
/*
            } finally {
                    .get();
            .endObject()
import java.util.Arrays;
 * under the License.
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
 * Licensed to Elasticsearch under one or more contributor
 * GitHub history for details.
import org.opensearch.common.xcontent.json.JsonXContent;
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
            .startObject("obj")
        assertThat(response.fieldMappings("indexa", "field1").fullName(), equalTo("field1"));
    }
    }
        Map<String, String> params = new HashMap<>();
            .prepareGetFieldMappings("index")
import org.opensearch.common.xcontent.XContentFactory;
            .endObject()
    }
        GetFieldMappingsResponse response = client().admin()
        try {
        return jsonBuilder().startObject()
 * Unless required by applicable law or agreed to in writing,
        prettyJsonBuilder.copyCurrentStructure(createParser(JsonXContent.jsonXContent, responseStrings));
        assertThat((Map<String, Object>) response.fieldMappings("test", "field1").sourceAsMap().get("field1"), hasEntry("type", "text"));
            .field("type", "alias")
            .startObject("subfield")
        createIndex("index");
import org.opensearch.test.InternalSettingsPlugin;
        assertThat(response.fieldMappings("indexa", "field1").sourceAsMap(), hasKey("field1"));
        assertThat((Map<String, Object>) response.fieldMappings("test", "field2").sourceAsMap().get("field2"), hasEntry("type", "text"));
        assertThat(response.mappings().get("index").size(), equalTo(0));
        } finally {
        assertAcked(prepareCreate("index").setMapping(getMappingForType()));
        assertThat(response.fieldMappings("indexa", "field1").fullName(), equalTo("field1"));
        assertThat(response.mappings().size(), equalTo(1));
        response.toXContent(responseBuilder, new ToXContent.MapParams(params));
 * this work for additional information regarding copyright
        GetFieldMappingsResponse response = client().admin().indices().prepareGetFieldMappings().setFields("alias", "field1").get();
            hasEntry("type", "keyword")
            .setFields("field1", "obj.subfield")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
 */
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE, SETTING_READ_ONLY)) {
 */
        assertThat(response.fieldMappings("indexa", "obj.subfield").fullName(), equalTo("obj.subfield"));
        GetFieldMappingsResponse response = client().admin()
        assertThat((Map<String, Object>) aliasMapping.sourceAsMap().get("alias"), hasEntry("type", "alias"));
            .get();
            hasEntry("index", Boolean.TRUE)
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        XContentBuilder responseBuilder = XContentFactory.jsonBuilder().prettyPrint();
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
