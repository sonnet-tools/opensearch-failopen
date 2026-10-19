    }  
    }
            .setFields("*")  
            new FieldCapabilities("old_field", "unmapped", false, false, new String[] { "new_index" }, null, null, Collections.emptyMap()),
            .setIndexFilter(QueryBuilders.rangeQuery("timestamp").lte("2017-01-01"))
    public void testWithIndexAlias() {
            .startObject("route_length_miles")
            new FieldCapabilities("distance", "double", true, true, new String[] { "old_index" }, null, null, Collections.emptyMap()),
import org.opensearch.action.index.IndexRequestBuilder;
 * software distributed under the License is distributed on an
        assertTrue(newField.containsKey("long"));  
 * Modifications Copyright OpenSearch Contributors. See
            .field("path", "old_field")
        assertIndices(response, "index-2");  
        assertEquals(  
        assertTrue(response.get().containsKey("distance"));
            .startObject()
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
            .startObject("properties")  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
/*
 * not use this file except in compliance with the License.
            distance.get("text")
        // Check the capabilities for the 'route_length_miles' alias.
            .endObject()
    }
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("distance", "route_length_miles").get();  
        super.setUp();
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("secret-soundtrack", "route_length_miles").get();
            new FieldCapabilities("route_length_miles", "double", true, true, null, null, null, Collections.emptyMap()),
        FieldCapabilitiesResponse response = client().prepareFieldCaps("index-*").setFields("*").get();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;  
        );
            routeLength.get("double")  
 */
        assertEquals(2, newField.size());
            .setFields("*")  
        assertTrue(response.get().containsKey("distance"));
        @Override  
import org.opensearch.common.xcontent.XContentFactory;
            .startObject("properties")  
            .field("type", "double")
        assertEquals(1, response.get().size());  
        assertTrue(newField.containsKey("keyword"));  
        response = client().prepareFieldCaps("index-*")
            .endObject()
            .endObject()
            return index -> field -> !field.equals("playlist");
            newField.get("long")  
    public FieldCapabilitiesIT(Settings staticSettings) {
        assertAcked(client().admin().indices().prepareAliases().addAlias("new_index", "current"));
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("new_field", "old_field").setIncludeUnmapped(true).get();  
import org.opensearch.index.query.QueryBuilders;  
            .field("type", "double")
        assertTrue(newField.containsKey("keyword"));  
            new FieldCapabilities("old_field", "long", true, true, new String[] { "old_index" }, null, null, Collections.emptyMap()),
            .endObject()  
            oldField.get("long")  
            oldField.get("unmapped")  
            .endObject()  
        assertEquals(
        reqs.add(client().prepareIndex("index-1").setSource("timestamp", "2018-07-08"));
 *
}  
 * the Apache License, Version 2.0 (the "License"); you may
        assertIndices(response, "old_index", "new_index");  
            .startObject("new_field")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            .startObject("_doc")
            .endObject()
        super(staticSettings);  
        return Collections.singleton(FieldFilterPlugin.class);
            .field("type", "alias")
        assertEquals(2, response.get().size());  
    }  
 * this work for additional information regarding copyright
        assertEquals(1, routeLength.size());
        assertTrue(response.get().containsKey("old_field"));
import java.util.List;
            .field("type", "text")  
        assertTrue(response.get().containsKey("route_length_miles"));  
            .field("type", "alias")
            .startObject("_doc")
            .field("type", "long")
import java.util.function.Predicate;
        assertIndices(response1, "old_index", "new_index");  
        reqs.add(client().prepareIndex("index-1").setSource("timestamp", "2015-07-08"));
            .startObject("old_field")  
    @Before
        assertEquals(
    public void testWithUnmapped() {
    public void testFieldAliasWithWildcard() {
        assertTrue(newField.containsKey("long"));
        );
        assertAcked(prepareCreate("new_index").setMapping(newIndexMapping));
            .field("path", "playlist")
    }
/*  
        // Check the capabilities for the 'distance' field.
        assertEquals(
import java.util.ArrayList;  
        assertEquals(1, response.get().size());
        FieldCapabilitiesResponse response = client().prepareFieldCaps("current").setFields("*").get();
import java.util.Map;
        assertTrue(response.get().containsKey("route_length_miles"));
public class FieldCapabilitiesIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            .get();
        );  
            .startObject("secret_soundtrack")
            .field("type", "long")
        }  
        assertTrue(oldField.containsKey("long"));  
        assertIndices(response, "index-1");  
    @ParametersFactory  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertTrue(distance.containsKey("text"));
    public static class FieldFilterPlugin extends Plugin implements MapperPlugin {
    public void setUp() throws Exception {  
        assertAcked(prepareCreate("index-1").setMapping("timestamp", "type=date", "field1", "type=keyword"));  
            .startObject("route_length_miles")
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 */  
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("distance", "secret*").get();
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, newField.size());
            distance.get("double")
        FieldCapabilitiesResponse response1 = client().prepareFieldCaps("current", "old_index").setFields("*").get();
        // Ensure the response has entries for both requested fields.  
        assertTrue(newField.containsKey("long"));  
            new FieldCapabilities("distance", "text", true, false, new String[] { "new_index" }, null, null, Collections.emptyMap()),
import org.junit.Before;
        assertIndices(response, "old_index", "new_index");
    }  
    }  
        XContentBuilder oldIndexMapping = XContentFactory.jsonBuilder()  
    public void testFieldAlias() {
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
        assertEquals(2, distance.size());  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.plugins.MapperPlugin;
 * GitHub history for details.
        Map<String, FieldCapabilities> newField = response.getField("new_field");  
        assertEquals(1, response.get().size());
    public static Collection<Object[]> parameters() {
        assertAcked(prepareCreate("old_index").setMapping(oldIndexMapping));
            .startObject("distance")
            .endObject()
/*  
        assertIndices(response, "index-1", "index-2");
        assertIndices(response, "old_index", "new_index");
        Arrays.sort(response.getIndices());  
        FieldCapabilitiesResponse response2 = client().prepareFieldCaps("current", "old_index", "new_index").setFields("*").get();
            .startObject("playlist")
import org.opensearch.plugins.Plugin;
 * specific language governing permissions and limitations
 */  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("route*").get();
        Arrays.sort(indices);
        reqs.add(client().prepareIndex("index-2").setSource("timestamp", "2020-07-08"));
        assertIndices(response, "new_index");  
    public void testWithIndexFilter() throws InterruptedException {
            .field("type", "alias")  
            .startObject()
        response = client().prepareFieldCaps("index-*")
            new FieldCapabilities("new_field", "long", true, true, null, null, null, Collections.emptyMap()),
        );
        assertTrue(distance.containsKey("double"));
 * SPDX-License-Identifier: Apache-2.0
            .get();
        Map<String, FieldCapabilities> routeLength = response.getField("route_length_miles");  
            .field("type", "text")
        Map<String, FieldCapabilities> newField = response.getField("field1");  
    }
import java.util.Collection;
    private void assertIndices(FieldCapabilitiesResponse response, String... indices) {  
    }
            .startObject("new_field")
    }
 *  
    public void testFieldAliasFilteringWithWildcard() {
            .field("path", "distance")  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        assertAcked(prepareCreate("index-2").setMapping("timestamp", "type=date", "field1", "type=long"));
        );
    }
            .endObject()
        );  
        assertNotNull(response.getIndices());
        assertTrue(routeLength.containsKey("double"));  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(1, newField.size());
        public Function<String, Predicate<String>> getFieldFilter() {
            .endObject()  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, newField.size());
        indexRandom(true, reqs);
        newField = response.getField("field1");
        Map<String, FieldCapabilities> distance = response.getField("distance");
        assertEquals(  
        assertIndices(response, "old_index", "new_index");
        assertEquals(
        assertEquals(response1, response2);
            .setIndexFilter(QueryBuilders.rangeQuery("timestamp").gte("2019-11-01"))
            .endObject();  
import java.util.function.Function;  
package org.opensearch.search.fieldcaps;
 *
import java.util.Arrays;
            .endObject()
            .endObject();  
        assertTrue(oldField.containsKey("unmapped"));  
        assertIndices(response, "old_index", "new_index");
    public void testFieldAliasFiltering() {  
 * compatible open source license.
import java.util.Collections;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.core.xcontent.XContentBuilder;
            .endObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(response.get().containsKey("route_length_miles"));
    @Override  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        assertArrayEquals(indices, response.getIndices());
import org.opensearch.action.fieldcaps.FieldCapabilities;  
            .startObject("distance")
        Map<String, FieldCapabilities> oldField = response.getField("old_field");  
        );
        return Arrays.asList(
        reqs.add(client().prepareIndex("index-2").setSource("timestamp", "2019-10-12"));  
        assertEquals(2, oldField.size());
            .endObject()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            .endObject()  
    }
        newField = response.getField("field1");
        XContentBuilder newIndexMapping = XContentFactory.jsonBuilder()  
