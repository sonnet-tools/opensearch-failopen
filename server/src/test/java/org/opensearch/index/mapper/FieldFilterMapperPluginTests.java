        + "            \"street\": {\n"
        for (String field : expectedFields) {
        assertEquals("Some unexpected fields were returned: " + fields.keySet(), 0, fields.size());
        + "  \"_doc\": {\n"
    }
        "birth",
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
import org.opensearch.plugins.MapperPlugin;
        assertMappingsAreValid(filtered.getSourceAsMap());
        assertEquals(1, response.mappings().size());
        + "          \"properties\": {\n"
        assertEquals(0, fieldmapping.size());
        Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fields = new HashMap<>(actual);
        Set<String> metadataFields = expectedMetadataFields();
        assertEquals(1, nameProperties.size());
        + "            }\n"
        "address.location",
     * installed. The mapper registry is node-wide, so any index reports the same set.
        @Override
        FieldCapabilitiesResponse index1 = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("index1")).actionGet();
        + "      }\n"
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.MappingMetadata;
    public void putMappings() {
        assertEquals(2, mappings.size());
        + "                \"keyword_visible\" : {\n"
 */
        + "          \"type\": \"date\"\n"
        }
            .get();
import org.junit.Before;
        + "            \"value\" : {\n"
        assertLeafs(typeProperties, "birth", "age_visible");
        + "}";
        assertEquals(1, addressProperties.size());
        + "      \"_source\": {\n"
    );
        assertLeafs(nameProperties, "first", "last_visible");
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("filtered").get();
        }
        // check that the returned filtered mappings are still valid mappings by submitting them and retrieving them back
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        + "        \"name\": {\n"
        assertLeafs(valueProperties, "keyword_visible");
        assertMultiField(propertiesProperties, "value", "keyword_visible");
import static org.opensearch.cluster.metadata.MetadataTests.assertMultiField;
    }
        Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
        + "        \"age_visible\": {\n"
        + "            \"key_visible\" : {\n"
        assertFieldMappings(response.mappings().get("test"), FILTERED_FLAT_FIELDS);
        }
        for (String field : expectedFields) {
    }
        assertNotNull(properties);
     */
        + "            \"location\": {\n"
import org.opensearch.indices.IndicesModule;
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
        assertLeafs(typeProperties, "age_visible");
            assertNotNull(" expected field [" + field + "] not found", remove);
        + "          }\n"
        + "          }\n"
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        assertLeafs(propertiesProperties, "key_visible");
        // double check that submitting the filtered mappings to an unfiltered index leads to the same field_caps output
 */
        + "              }\n"
     * (DocumentInput.ROW_ID_FIELD) that the composite-engine plugin registers node-wide when the sandbox stack is
import org.opensearch.action.fieldcaps.FieldCapabilities;
        assertEquals(1, name.size());
    public void testGetFieldMappings() {
        for (String field : metadataFields) {
        assertNotNull(valueProperties);
    public void testGetNonExistentFieldMapping() {
 * ownership. Elasticsearch licenses this file to you under
        assertTrue(sourceAsMap.containsKey("_routing"));
    private Set<String> expectedMetadataFields() {
 * The OpenSearch Contributors require contributions made to
        + "          }\n"
        + "              \"type\": \"keyword\"\n"
    private static final Collection<String> FILTERED_FLAT_FIELDS = Arrays.asList(
    private static final Collection<String> ALL_FLAT_FIELDS = Arrays.asList(
        assertNotNull(mappingMetadata);
        + "              \"fields\": {\n"
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(filteredMapping.getSourceAsMap()));
        assertEquals(2, propertiesProperties.size());
        Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");
        MappingMetadata filteredMapping = getMappingsResponse.getMappings().get("filtered");
        assertNotNull(propertiesProperties);
        assertEquals(1, mappings.size());
        assertExpectedMappings(getIndexResponse.mappings());
        "name.last_visible",
    public void testGetMappings() {
        + "              \"type\": \"geo_point\"\n"
import java.util.function.Predicate;
        }
        "age_visible",
    protected Collection<Class<? extends Plugin>> getPlugins() {
 * not use this file except in compliance with the License.
        }
            assertNotNull(" expected field [" + field + "] not found", fieldMappingMetadata);
import java.util.HashMap;
        Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");
        assertTrue(sourceAsMap.containsKey("_meta"));
        Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");
        assertFieldCaps(test, filteredFields);
        + "            }\n"
import org.opensearch.plugins.Plugin;
        assertLeafs(addressProperties, "street", "location", "area_visible");
        Map<String, Object> sourceAsMap = mappingMetadata.getSourceAsMap();
        return Arrays.asList(FieldFilterPlugin.class, TestGeoShapeFieldMapperPlugin.class);
        assertFiltered(testMappingsResponse.getMappings().get("test"));
        assertNotNull(value);
        assertEquals(1, address.size());
        assertEquals(2, propertiesProperties.size());
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");
        assertAcked(client().admin().indices().preparePutMapping("index1", "filtered").setSource(TEST_ITEM, MediaTypeRegistry.JSON));
    private void assertExpectedMappings(Map<String, MappingMetadata> mappings) {
        + "      \"_routing\": {\n"
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings().get();
        Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
        filteredFields.addAll(ALL_OBJECT_FIELDS);
        "name.first",
        assertAcked(client().admin().indices().prepareCreate("filtered"));
        + "          \"properties\": {\n"
        List<String> allFields = new ArrayList<>(ALL_FLAT_FIELDS);
 *
        assertNotFiltered(mappings.get("index1"));
            Map<String, FieldCapabilities> remove = responseMap.remove(field);
    private void assertMappingsAreValid(Map<String, Object> sourceAsMap) {
    private static void assertFiltered(MappingMetadata mappingMetadata) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        + "            \"area_visible\": {\n"
        assertNotNull(mappingMetadata);
        assertTrue(sourceAsMap.containsKey("_source"));
 * under the License.
        assertFieldCaps(index1, allFields);
        }
        + "        \"required\":true\n"
            .indices()
    }
        + "      },"
        List<String> filteredFields = new ArrayList<>(FILTERED_FLAT_FIELDS);
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
        Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");
        return metadataFields;
        assertNotNull(addressProperties);
        assertAcked(client().admin().indices().prepareCreate("index1"));
            GetFieldMappingsResponse.FieldMappingMetadata fieldMappingMetadata = fields.remove(field);
        assertEquals(1, value.size());
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldmapping = mappings.get("index1");
        assertEquals(2, properties.size());
        assertTrue(sourceAsMap.containsKey("_meta"));
        assertNotNull(addressProperties);
        for (String field : metadataFields) {
        + "              \"type\": \"text\",\n"
        GetFieldMappingsResponse getFieldMappingsResponse = client().admin().indices().prepareGetFieldMappings().setFields("*").get();
        // as the one coming from a filtered index with same mappings
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.Map;
        + "              \"tree\": \"quadtree\",\n"
        assertEquals(1, valueProperties.size());
        GetIndexResponse getIndexResponse = client().admin()
        + "        \"birth\": {\n"
        + "            },\n"
        + "        \"version\":0.19\n"
        assertEquals(1, name.size());
    }
        allFields.addAll(ALL_OBJECT_FIELDS);
public class FieldFilterMapperPluginTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        // the mappings are returned unfiltered for this index, yet they are the same as the previous ones that were returned filtered
        assertEquals(4, sourceAsMap.size());
        // properties.value is an object field in the new mapping
    }
import org.opensearch.index.engine.dataformat.DocumentInput;
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
        "age_visible",
    private void assertFieldMappings(Map<String, GetFieldMappingsResponse.FieldMappingMetadata> actual, Collection<String> expectedFields) {
        + "          \"type\": \"object\",\n"
        + "      \"properties\": {\n"
        "properties.key_visible",
import org.opensearch.action.admin.indices.get.GetIndexRequest;
import java.util.Set;
        + "    }\n"
        assertLeafs(nameProperties, "last_visible");
        assertMultiField(propertiesProperties, "key_visible", "keyword");
    private void assertFieldCaps(FieldCapabilitiesResponse fieldCapabilitiesResponse, Collection<String> expectedFields) {
        + "          \"type\": \"nested\",\n"
        assertLeafs(addressProperties, "area_visible");
        + "              \"type\": \"keyword\"\n"
import org.opensearch.core.xcontent.MediaTypeRegistry;
        + "        },\n"
        + "              \"type\": \"text\",\n"
        + "            \"last_visible\": {\n"
            return index -> index.equals("filtered") ? field -> field.endsWith("visible") : MapperPlugin.NOOP_FIELD_PREDICATE;
        assertFieldMappings(mappings.get("index1"), ALL_FLAT_FIELDS);
import java.util.function.Function;
    public static class FieldFilterPlugin extends Plugin implements MapperPlugin {
        + "                }\n"
        assertTrue(sourceAsMap.containsKey("_routing"));
        "properties.value.keyword_visible"
        + "      },"
        MappingMetadata filtered = getMappingsResponse.getMappings().get("filtered");
        + "            },\n"
        public Function<String, Predicate<String>> getFieldFilter() {
    }
        assertExpectedMappings(getMappingsResponse.mappings());
        + "              \"precision\": \"1m\"\n"
 * compatible open source license.
        assertEquals(4, sourceAsMap.size());
        assertEquals(1, address.size());
        assertFieldMappings(mappings.get("filtered"), FILTERED_FLAT_FIELDS);
        "properties.value",
        Map<String, Map<String, FieldCapabilities>> responseMap = new HashMap<>(fieldCapabilitiesResponse.get());
        + "            }\n"
        GetMappingsResponse testMappingsResponse = client().admin().indices().prepareGetMappings("test").get();
    @SuppressWarnings("unchecked")
        + "        },\n"
    }
        + "              }\n"
        assertNotNull(address);
import static org.opensearch.cluster.metadata.MetadataTests.assertLeafs;
/*
        + "              \"type\": \"keyword\"\n"
    }
        assertTrue(sourceAsMap.containsKey("_source"));
        + "            },\n"
        assertEquals(2, properties.size());
        + "            \"first\": {\n"
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
        if (shouldInstallSandboxStack()) {
            Map<String, FieldCapabilities> remove = responseMap.remove(field);
            .setFeatures(GetIndexRequest.Feature.MAPPINGS)
        assertEquals(5, typeProperties.size());
    /**
            .prepareGetIndex()
 * Licensed to Elasticsearch under one or more contributor
        Map<String, Object> valueProperties = (Map<String, Object>) value.get("properties");
        Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
package org.opensearch.index.mapper;
        + "        },\n"
        + "        \"enabled\":false\n"
}
            GetFieldMappingsResponse.FieldMappingMetadata fieldMappingMetadata = fields.remove(field);
        assertNotNull(propertiesProperties);
        + "        },\n"
        "name.last_visible",
        assertEquals("Some unexpected fields were returned: " + responseMap.keySet(), 0, responseMap.size());
        "address.area_visible",
        Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
        + "              \"fields\": {\n"
        assertFieldCaps(filtered, filteredFields);
        + "        \"address\": {\n"
        Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");
        + "      },"
        GetFieldMappingsResponse response = client().admin().indices().prepareGetFieldMappings("test").setFields("*").get();
        + "          \"type\": \"integer\"\n"
    }
        Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
    );
 * Unless required by applicable law or agreed to in writing,
        Set<String> metadataFields = new HashSet<>(IndicesModule.getBuiltInMetadataFields());
import java.util.HashSet;
        filteredFields.add("properties.value");
 * GitHub history for details.
        + "                \"keyword\" : {\n"
    public void testGetIndex() {
        "address.area_visible",
        assertEquals(1, testMappingsResponse.getMappings().size());
        + "      \"_meta\": {\n"
        FieldCapabilitiesResponse filtered = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("filtered")).actionGet();
 * this work for additional information regarding copyright
    private static final Collection<String> ALL_OBJECT_FIELDS = Arrays.asList("name", "address", "properties");
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(filtered.getSourceAsMap()));
        + "                }\n"
    public void testFieldCapabilities() {
        Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings = getFieldMappingsResponse.mappings();
    @Override
        Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
     * The metadata fields expected on every index on the node: the built-ins plus the system-managed row-id field
        GetFieldMappingsResponse response = client().admin().indices().prepareGetFieldMappings("index1").setFields("non-existent").get();
        // double check that submitting the filtered mappings to an unfiltered index leads to the same get field mappings output
        "properties.value.keyword_visible"
        "properties.key_visible.keyword",
        + "                  \"type\" : \"keyword\"\n"
        assertEquals(3, addressProperties.size());
        assertEquals(4, typeProperties.size());
 * You may obtain a copy of the License at
        assertNotNull(properties);
    }
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> sourceAsMap = mappingMetadata.getSourceAsMap();
            assertNotNull(" expected field [" + field + "] not found", remove);
        FieldCapabilitiesResponse test = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();
    @SuppressWarnings("unchecked")
    private static final String TEST_ITEM = "{\n"
        + "                  \"type\" : \"keyword\"\n"
/*
        Map<String, Object> value = (Map<String, Object>) propertiesProperties.get("value");
    }
        "address.street",
import java.util.ArrayList;
        assertNotNull(address);
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collection;
        + "        \"properties\": {\n"
        + "              \"type\": \"geo_shape\",  \n"
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("filtered").get();
 *
import java.util.List;
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
 * software distributed under the License is distributed on an
        assertTrue(properties.containsKey("type"));
        Set<String> metadataFields = expectedMetadataFields();
/*
    private static void assertNotFiltered(MappingMetadata mappingMetadata) {
        assertEquals(2, nameProperties.size());
import java.util.Arrays;
    @Before
        + "  }\n"
        "properties.key_visible",
        + "          \"properties\": {\n"
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(2, mappings.size());
        // as the one coming from a filtered index with same mappings
        assertEquals("nested", properties.get("type"));
        + "        }\n"
        Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");
            assertNotNull("expected field [" + field + "] not found", fieldMappingMetadata);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings = response.mappings();
        assertFiltered(filtered);
            metadataFields.add(DocumentInput.ROW_ID_FIELD);
        + "            },\n"
        MappingMetadata filtered = mappings.get("filtered");
 *
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(sourceAsMap));
