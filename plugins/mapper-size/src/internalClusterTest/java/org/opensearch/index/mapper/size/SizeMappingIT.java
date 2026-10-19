        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));  
        assertAcked(putMappingResponse);
        assertThat(sizeAsString, is(notNullValue()));
 *    http://www.apache.org/licenses/LICENSE-2.0
        XContentBuilder updateMappingBuilder = jsonBuilder().startObject()  
 * You may obtain a copy of the License at  
        // update some field in the mapping
        String index = "foo";  
import org.opensearch.test.OpenSearchIntegTestCase;
 * this work for additional information regarding copyright
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
    public void testThatSizeCanBeSwitchedOnAndOff() throws Exception {
            .endObject()  
 * under the License.  
            .endObject()
            .endObject()
/*  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        GetResponse getResponse = client().prepareGet("test", "1").setStoredFields("_size").get();  
    }  
 * compatible open source license.
        // make sure size field is still in mapping
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.mapper.size;
            .endObject();  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
            .field("type", "text")  
/*
        // update some field in the mapping
        AcknowledgedResponse putMappingResponse = client().admin().indices().preparePutMapping(index).setSource(updateMappingBuilder).get();
    public void testBasic() throws Exception {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.hamcrest.Matchers.hasKey;
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));  
 *  
        assertSizeMappingEnabled(index, true);
        String index = "foo";  
        XContentBuilder builder = jsonBuilder().startObject().startObject("_size").field("enabled", true).endObject().endObject();
 */
        // make sure size field is still in mapping
        XContentBuilder updateMappingBuilder = jsonBuilder().startObject()  
        assertSizeMappingEnabled(index, false);  
 * SPDX-License-Identifier: Apache-2.0
    private void assertSizeMappingEnabled(String index, boolean enabled) throws IOException {  
        assertEquals(source.length(), (int) getResponse.getField("_size").getValue());
import static org.hamcrest.Matchers.notNullValue;
        AcknowledgedResponse putMappingResponse = client().admin().indices().preparePutMapping(index).setSource(updateMappingBuilder).get();
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
            "Expected size field mapping to be " + (enabled ? "enabled" : "disabled") + " for %s",  
        );
 * specific language governing permissions and limitations
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testThatUpdatingMappingShouldNotRemoveSizeMappingConfiguration() throws Exception {
        String sizeAsString = mappingSource.get("_size").toString();  
            .endObject();
        XContentBuilder builder = jsonBuilder().startObject().startObject("_size").field("enabled", true).endObject().endObject();
        assertSizeMappingEnabled(index, true);  
            Locale.ROOT,
 * Modifications Copyright OpenSearch Contributors. See  
    }
    }
        assertThat(errMsg, mappingSource, hasKey("_size"));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.plugins.Plugin;  
 * software distributed under the License is distributed on an
        return Arrays.asList(MapperSizePlugin.class);
            index
        // check mapping again
    // issue 5053
import static org.hamcrest.Matchers.is;  
            .startObject("otherField")
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings(index).get();  
    }  
import java.util.Collection;
        indexRandom(true, client().prepareIndex("test").setId("1").setSource(source, MediaTypeRegistry.JSON));
import java.util.Arrays;
        String errMsg = String.format(
    }  
import java.util.Locale;  
        assertAcked(putMappingResponse);  
public class SizeMappingIT extends OpenSearchIntegTestCase {  
            .field("enabled", false)
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
/*
        assertThat(errMsg, sizeAsString, is("{enabled=" + (enabled) + "}"));
        assertSizeMappingEnabled(index, true);  
        // check mapping again
    @Override
        assertAcked(prepareCreate("test").setMapping("_size", "enabled=true"));  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;  
import org.opensearch.core.xcontent.XContentBuilder;
 * this file be licensed under the Apache-2.0 license or a
}
 */
            .startObject("_size")
        Map<String, Object> mappingSource = getMappingsResponse.getMappings().get(index).getSourceAsMap();
 *
        assertNotNull(getResponse.getField("_size"));
import org.opensearch.action.get.GetResponse;
import org.opensearch.plugin.mapper.MapperSizePlugin;
 */  
 * ownership. Elasticsearch licenses this file to you under  
            .startObject("properties")
        final String source = "{\"f\":10}";
 *
