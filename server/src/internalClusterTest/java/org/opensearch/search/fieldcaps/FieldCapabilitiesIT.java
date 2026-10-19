 */
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        public Function<String, Predicate<String>> getFieldFilter() {
            .field("type", "alias")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .endObject()
            .setFields("*")
    }
        reqs.add(client().prepareIndex("index-2").setSource("timestamp", "2020-07-08"));
 * compatible open source license.
            .startObject("properties")
    }
            oldField.get("long")
            new FieldCapabilities("old_field", "long", true, true, new String[] { "old_index" }, null, null, Collections.emptyMap()),
        Map<String, FieldCapabilities> newField = response.getField("field1");
        Map<String, FieldCapabilities> routeLength = response.getField("route_length_miles");
    }
        assertTrue(newField.containsKey("keyword"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    public static class FieldFilterPlugin extends Plugin implements MapperPlugin {
    }
        assertEquals(
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("route*").get();
    }
        XContentBuilder newIndexMapping = XContentFactory.jsonBuilder()
        );
    }
            new FieldCapabilities("old_field", "unmapped", false, false, new String[] { "new_index" }, null, null, Collections.emptyMap()),
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("new_field", "old_field").setIncludeUnmapped(true).get();
 * KIND, either express or implied.  See the License for the
        assertEquals(response1, response2);
import org.opensearch.plugins.Plugin;
            .setIndexFilter(QueryBuilders.rangeQuery("timestamp").gte("2019-11-01"))
            .field("type", "text")
        // Ensure the response has entries for both requested fields.
            .setFields("*")
        assertEquals(
/*
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
            .startObject("new_field")
        assertTrue(routeLength.containsKey("double"));
            .startObject("route_length_miles")
    public FieldCapabilitiesIT(Settings staticSettings) {
        assertEquals(
        FieldCapabilitiesResponse response = client().prepareFieldCaps("current").setFields("*").get();
            .field("path", "old_field")
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
            .startObject("distance")
            newField.get("long")
    public static Collection<Object[]> parameters() {
        assertEquals(1, newField.size());
        assertTrue(distance.containsKey("double"));
            .field("type", "alias")
        assertEquals(2, newField.size());
            new FieldCapabilities("route_length_miles", "double", true, true, null, null, null, Collections.emptyMap()),
import org.opensearch.common.xcontent.XContentFactory;
        assertNotNull(response.getIndices());
        assertEquals(1, newField.size());
        assertTrue(oldField.containsKey("unmapped"));
            .endObject();
        assertTrue(newField.containsKey("long"));
        assertIndices(response, "old_index", "new_index");
            .endObject()
 * software distributed under the License is distributed on an
        assertIndices(response, "index-1", "index-2");
            new FieldCapabilities("distance", "text", true, false, new String[] { "new_index" }, null, null, Collections.emptyMap()),
        Map<String, FieldCapabilities> oldField = response.getField("old_field");
        assertAcked(client().admin().indices().prepareAliases().addAlias("new_index", "current"));
            .startObject("new_field")
        assertIndices(response, "index-2");
}
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("distance", "route_length_miles").get();
import org.opensearch.plugins.MapperPlugin;
        newField = response.getField("field1");
        Map<String, FieldCapabilities> distance = response.getField("distance");
    @ParametersFactory
            .startObject("playlist")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertEquals(
import java.util.Arrays;
import org.opensearch.common.settings.Settings;
import java.util.List;
        super(staticSettings);
 *
        assertEquals(1, response.get().size());
            .endObject()
import java.util.function.Function;
        );
 * specific language governing permissions and limitations
            .startObject("properties")
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("secret-soundtrack", "route_length_miles").get();
            .endObject()
            .field("type", "double")
    public void testFieldAliasWithWildcard() {
 * Unless required by applicable law or agreed to in writing,
    @Override
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.junit.Before;
    public void testFieldAlias() {
 * GitHub history for details.
import java.util.ArrayList;
        assertIndices(response, "old_index", "new_index");
    }
            .get();
        FieldCapabilitiesResponse response1 = client().prepareFieldCaps("current", "old_index").setFields("*").get();
import org.opensearch.action.index.IndexRequestBuilder;
        assertAcked(prepareCreate("index-2").setMapping("timestamp", "type=date", "field1", "type=long"));
 * The OpenSearch Contributors require contributions made to
        );
        assertTrue(newField.containsKey("keyword"));
        assertEquals(2, oldField.size());
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
        assertIndices(response, "old_index", "new_index");
            .field("type", "long")
        assertEquals(1, routeLength.size());
        // Check the capabilities for the 'distance' field.
            .endObject();
        reqs.add(client().prepareIndex("index-2").setSource("timestamp", "2019-10-12"));
        assertTrue(newField.containsKey("long"));
            .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
 *
        super.setUp();
    public void testWithIndexFilter() throws InterruptedException {
            .field("type", "double")
    public void testFieldAliasFilteringWithWildcard() {
import org.opensearch.action.fieldcaps.FieldCapabilities;
        Arrays.sort(response.getIndices());
        newField = response.getField("field1");
        assertIndices(response, "new_index");
            oldField.get("unmapped")
            .startObject("_doc")
            .startObject()
        @Override
            .endObject()
        assertEquals(
        assertTrue(response.get().containsKey("old_field"));
            .endObject()
        reqs.add(client().prepareIndex("index-1").setSource("timestamp", "2015-07-08"));
            distance.get("double")
        assertAcked(prepareCreate("index-1").setMapping("timestamp", "type=date", "field1", "type=keyword"));
    public void testWithUnmapped() {
import java.util.Collection;
        assertAcked(prepareCreate("old_index").setMapping(oldIndexMapping));
            distance.get("text")
        assertTrue(response.get().containsKey("route_length_miles"));
 *
        assertIndices(response1, "old_index", "new_index");
        assertTrue(oldField.containsKey("long"));
import java.util.Collections;
        assertIndices(response, "index-1");
    public void testFieldAliasFiltering() {
    private void assertIndices(FieldCapabilitiesResponse response, String... indices) {
        );
        assertArrayEquals(indices, response.getIndices());
            .startObject("distance")
    }
 * You may obtain a copy of the License at
            return index -> field -> !field.equals("playlist");
            .get();
        return Collections.singleton(FieldFilterPlugin.class);
        FieldCapabilitiesResponse response = client().prepareFieldCaps("index-*").setFields("*").get();
 * ownership. Elasticsearch licenses this file to you under
        assertIndices(response, "old_index", "new_index");
 * under the License.
public class FieldCapabilitiesIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            new FieldCapabilities("new_field", "long", true, true, null, null, null, Collections.emptyMap()),
    }
            .field("path", "playlist")
import org.opensearch.index.query.QueryBuilders;
            .endObject()
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(
            .startObject("route_length_miles")
 */
        FieldCapabilitiesResponse response = client().prepareFieldCaps().setFields("distance", "secret*").get();
            .startObject("old_field")
        assertEquals(2, response.get().size());
package org.opensearch.search.fieldcaps;
 */
    }
        // Check the capabilities for the 'route_length_miles' alias.
            .field("path", "distance")
            .field("type", "alias")
 * the Apache License, Version 2.0 (the "License"); you may
    public void setUp() throws Exception {
            .setIndexFilter(QueryBuilders.rangeQuery("timestamp").lte("2017-01-01"))
import java.util.function.Predicate;
            routeLength.get("double")
            .startObject("secret_soundtrack")
import java.util.Map;
    }
 * license agreements. See the NOTICE file distributed with
            .field("type", "text")
            .field("type", "long")
        assertAcked(prepareCreate("new_index").setMapping(newIndexMapping));
    }
        assertTrue(newField.containsKey("long"));
        assertEquals(1, response.get().size());
        FieldCapabilitiesResponse response2 = client().prepareFieldCaps("current", "old_index", "new_index").setFields("*").get();
            .startObject("_doc")
        reqs.add(client().prepareIndex("index-1").setSource("timestamp", "2018-07-08"));
    }
        assertIndices(response, "old_index", "new_index");
        indexRandom(true, reqs);
        assertTrue(response.get().containsKey("route_length_miles"));
        response = client().prepareFieldCaps("index-*")
        );
        Map<String, FieldCapabilities> newField = response.getField("new_field");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
            new FieldCapabilities("distance", "double", true, true, new String[] { "old_index" }, null, null, Collections.emptyMap()),
            .endObject()
        assertTrue(response.get().containsKey("route_length_miles"));
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void testWithIndexAlias() {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * not use this file except in compliance with the License.
        return Arrays.asList(
            .startObject()
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(response.get().containsKey("distance"));
            .endObject()
            .endObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(2, distance.size());
        XContentBuilder oldIndexMapping = XContentFactory.jsonBuilder()
 * this work for additional information regarding copyright
        assertTrue(distance.containsKey("text"));
/*
        Arrays.sort(indices);
        assertEquals(1, newField.size());
    @Before
        assertTrue(response.get().containsKey("distance"));
        }
        response = client().prepareFieldCaps("index-*")
        assertEquals(1, response.get().size());
