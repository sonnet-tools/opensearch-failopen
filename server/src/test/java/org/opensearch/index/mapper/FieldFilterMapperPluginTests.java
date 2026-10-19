        + "            \"value\" : {\n"  
        assertTrue(sourceAsMap.containsKey("_meta"));  
        + "                }\n"  
        assertFieldCaps(filtered, filteredFields);  
            GetFieldMappingsResponse.FieldMappingMetadata fieldMappingMetadata = fields.remove(field);
        for (String field : metadataFields) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
        assertEquals(1, value.size());  
import org.opensearch.plugins.Plugin;
        filteredFields.addAll(ALL_OBJECT_FIELDS);
        + "          }\n"
        Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
 *
        + "              \"type\": \"keyword\"\n"
import java.util.Map;  
        "name.first",  
import java.util.HashSet;
    );  
    }
        assertLeafs(typeProperties, "birth", "age_visible");  
        assertFieldCaps(index1, allFields);
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertNotNull(value);
        assertEquals("Some unexpected fields were returned: " + responseMap.keySet(), 0, responseMap.size());  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fields = new HashMap<>(actual);
    @Before
        + "              \"fields\": {\n"  
 * Licensed to Elasticsearch under one or more contributor  
        GetFieldMappingsResponse response = client().admin().indices().prepareGetFieldMappings("test").setFields("*").get();  
/*
        + "              \"fields\": {\n"
        assertFieldCaps(test, filteredFields);  
        for (String field : expectedFields) {
        assertEquals(1, name.size());
        assertTrue(sourceAsMap.containsKey("_source"));
        + "        \"age_visible\": {\n"  
        + "            }\n"  
        FieldCapabilitiesResponse test = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();  
        + "        \"required\":true\n"
        "name.last_visible",
        assertNotNull(propertiesProperties);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertEquals(2, properties.size());  
}
        + "              \"type\": \"geo_shape\",  \n"
        assertEquals(1, address.size());
        assertAcked(client().admin().indices().prepareCreate("index1"));  
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings().get();  
 * ownership. Elasticsearch licenses this file to you under  
/*  
import java.util.HashMap;  
        Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
        assertEquals(4, sourceAsMap.size());
        Map<String, Object> value = (Map<String, Object>) propertiesProperties.get("value");
        assertNotNull(addressProperties);  
        "properties.key_visible",
    }
 * KIND, either express or implied.  See the License for the
        + "        \"name\": {\n"
        + "                }\n"
            assertNotNull(" expected field [" + field + "] not found", fieldMappingMetadata);
        + "          }\n"
        Map<String, Object> properties = (Map<String, Object>) typeProperties.get("properties");
    }  
        "age_visible",
        "address.area_visible",  
        if (shouldInstallSandboxStack()) {
        allFields.addAll(ALL_OBJECT_FIELDS);  
import java.util.Set;
        Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");  
        assertNotNull(propertiesProperties);  
import org.opensearch.indices.IndicesModule;
    }
        + "                  \"type\" : \"keyword\"\n"
        assertNotNull(properties);
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> sourceAsMap = mappingMetadata.getSourceAsMap();
        + "              \"precision\": \"1m\"\n"  
        + "            \"key_visible\" : {\n"
    }
 */  
        + "          \"properties\": {\n"  
        MappingMetadata filtered = getMappingsResponse.getMappings().get("filtered");
        assertFiltered(testMappingsResponse.getMappings().get("test"));
        "address.location",
        + "                \"keyword\" : {\n"
        "name.last_visible",
    private void assertFieldCaps(FieldCapabilitiesResponse fieldCapabilitiesResponse, Collection<String> expectedFields) {
        GetMappingsResponse testMappingsResponse = client().admin().indices().prepareGetMappings("test").get();
        + "            },\n"
        assertEquals(1, nameProperties.size());  
        assertAcked(client().admin().indices().prepareCreate("filtered"));
    }  
            .setFeatures(GetIndexRequest.Feature.MAPPINGS)
        assertNotFiltered(mappings.get("index1"));
        Set<String> metadataFields = expectedMetadataFields();  
    @SuppressWarnings("unchecked")
        assertEquals(1, name.size());
/*  
        + "            \"location\": {\n"  
import static org.opensearch.cluster.metadata.MetadataTests.assertMultiField;  
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(address);  
        + "              }\n"
        "properties.value.keyword_visible"
        + "            }\n"
        assertEquals(2, nameProperties.size());  
 * GitHub history for details.
        "age_visible",  
 * the Apache License, Version 2.0 (the "License"); you may
 *
import java.util.function.Predicate;  
import org.opensearch.plugins.MapperPlugin;  
        assertEquals("Some unexpected fields were returned: " + fields.keySet(), 0, fields.size());
        assertEquals(2, mappings.size());
        + "          \"type\": \"date\"\n"
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(filteredMapping.getSourceAsMap()));
        assertNotNull(valueProperties);
        assertEquals(4, typeProperties.size());
 * this work for additional information regarding copyright
        Map<String, GetFieldMappingsResponse.FieldMappingMetadata> fieldmapping = mappings.get("index1");  
 * under the License.  
        + "          \"properties\": {\n"
        + "      },"  
        return metadataFields;
        + "  }\n"  
        assertMultiField(propertiesProperties, "key_visible", "keyword");
        + "      \"properties\": {\n"
        + "        \"version\":0.19\n"
    }
    /**  
 *  
        Set<String> metadataFields = new HashSet<>(IndicesModule.getBuiltInMetadataFields());  
        assertFieldMappings(mappings.get("filtered"), FILTERED_FLAT_FIELDS);  
        assertTrue(sourceAsMap.containsKey("_meta"));  
        + "      }\n"
        assertExpectedMappings(getMappingsResponse.mappings());
        assertLeafs(nameProperties, "last_visible");
        + "      \"_source\": {\n"
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("filtered").get();  
            Map<String, FieldCapabilities> remove = responseMap.remove(field);  
        + "          }\n"
        assertLeafs(nameProperties, "first", "last_visible");
        "address.street",
        + "          \"type\": \"integer\"\n"
        // as the one coming from a filtered index with same mappings
        + "        \"address\": {\n"  
import java.util.Arrays;
        Map<String, Map<String, FieldCapabilities>> responseMap = new HashMap<>(fieldCapabilitiesResponse.get());
        Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings = response.mappings();
        + "        },\n"
        + "            \"first\": {\n"
        return Arrays.asList(FieldFilterPlugin.class, TestGeoShapeFieldMapperPlugin.class);
    }  
    private static final Collection<String> FILTERED_FLAT_FIELDS = Arrays.asList(  
            Map<String, FieldCapabilities> remove = responseMap.remove(field);
    private static void assertFiltered(MappingMetadata mappingMetadata) {
        assertEquals(4, sourceAsMap.size());
    private void assertFieldMappings(Map<String, GetFieldMappingsResponse.FieldMappingMetadata> actual, Collection<String> expectedFields) {  
        + "      \"_meta\": {\n"
        assertTrue(properties.containsKey("type"));
        assertEquals(1, valueProperties.size());  
        FieldCapabilitiesResponse index1 = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("index1")).actionGet();
 * not use this file except in compliance with the License.
        assertLeafs(addressProperties, "street", "location", "area_visible");
    private static void assertNotFiltered(MappingMetadata mappingMetadata) {
        + "              \"type\": \"geo_point\"\n"
        + "            },\n"
        // check that the returned filtered mappings are still valid mappings by submitting them and retrieving them back
        + "              \"type\": \"keyword\"\n"
        assertEquals(2, mappings.size());  
    public void testGetMappings() {
     * installed. The mapper registry is node-wide, so any index reports the same set.  
        assertMultiField(propertiesProperties, "value", "keyword_visible");  
    }
        for (String field : expectedFields) {
            return index -> index.equals("filtered") ? field -> field.endsWith("visible") : MapperPlugin.NOOP_FIELD_PREDICATE;
        + "              \"type\": \"text\",\n"
     */
        + "        }\n"  
        + "            \"last_visible\": {\n"
        Map<String, Object> sourceAsMap = mappingMetadata.getSourceAsMap();
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(2, propertiesProperties.size());
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");  
import org.opensearch.action.fieldcaps.FieldCapabilities;
        Map<String, Object> typeProperties = (Map<String, Object>) sourceAsMap.get("properties");  
        + "        },\n"
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    @Override
        "birth",
    public void testGetNonExistentFieldMapping() {
        assertNotNull(addressProperties);  
        + "        \"enabled\":false\n"
        assertFiltered(filtered);  
        // double check that submitting the filtered mappings to an unfiltered index leads to the same field_caps output
 * Unless required by applicable law or agreed to in writing,
    public void testGetIndex() {
        + "        \"birth\": {\n"  
        assertEquals(1, testMappingsResponse.getMappings().size());
        assertEquals(2, propertiesProperties.size());
        List<String> allFields = new ArrayList<>(ALL_FLAT_FIELDS);
        for (String field : metadataFields) {
 * software distributed under the License is distributed on an
            GetFieldMappingsResponse.FieldMappingMetadata fieldMappingMetadata = fields.remove(field);
        Map<String, Object> valueProperties = (Map<String, Object>) value.get("properties");
            assertNotNull(" expected field [" + field + "] not found", remove);
        + "            \"street\": {\n"  
        + "          \"type\": \"object\",\n"
        assertFieldMappings(mappings.get("index1"), ALL_FLAT_FIELDS);
        Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mappings = getFieldMappingsResponse.mappings();  
        + "          \"properties\": {\n"  
    private void assertMappingsAreValid(Map<String, Object> sourceAsMap) {
        Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");
        assertLeafs(valueProperties, "keyword_visible");
    );
        assertNotNull(mappingMetadata);  
        assertAcked(client().admin().indices().preparePutMapping("index1", "filtered").setSource(TEST_ITEM, MediaTypeRegistry.JSON));
import java.util.Collection;
 */  
 * specific language governing permissions and limitations
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        assertEquals(1, address.size());
        Set<String> metadataFields = expectedMetadataFields();
    }
 * compatible open source license.
import org.junit.Before;
import java.util.List;
    }
            assertNotNull(" expected field [" + field + "] not found", remove);  
        assertEquals(2, properties.size());  
        assertNotNull(address);  
        + "            },\n"
        + "              \"type\": \"text\",\n"
        "properties.value",  
    private static final Collection<String> ALL_FLAT_FIELDS = Arrays.asList(
        + "      },"  
        GetFieldMappingsResponse getFieldMappingsResponse = client().admin().indices().prepareGetFieldMappings().setFields("*").get();
        Map<String, Object> address = (Map<String, Object>) typeProperties.get("address");
    private Set<String> expectedMetadataFields() {
        // double check that submitting the filtered mappings to an unfiltered index leads to the same get field mappings output
import org.opensearch.action.admin.indices.get.GetIndexRequest;
        assertLeafs(addressProperties, "area_visible");
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;  
 * You may obtain a copy of the License at  
        assertEquals(3, addressProperties.size());
import java.util.function.Function;
        // the mappings are returned unfiltered for this index, yet they are the same as the previous ones that were returned filtered  
        + "    }\n"
    public void testFieldCapabilities() {
        @Override
        assertTrue(sourceAsMap.containsKey("_routing"));
        // properties.value is an object field in the new mapping
    }
        Map<String, Object> name = (Map<String, Object>) typeProperties.get("name");  
        assertLeafs(typeProperties, "age_visible");  
        }
        "properties.key_visible.keyword",
        + "      \"_routing\": {\n"
        GetFieldMappingsResponse response = client().admin().indices().prepareGetFieldMappings("index1").setFields("non-existent").get();  
    public void testGetFieldMappings() {
        }  
        + "                  \"type\" : \"keyword\"\n"
        + "        },\n"
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;  
import static org.opensearch.cluster.metadata.MetadataTests.assertLeafs;
        Map<String, Object> propertiesProperties = (Map<String, Object>) properties.get("properties");
        Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");
        assertEquals(1, addressProperties.size());
        + "            },\n"  
        + "        },\n"  
        MappingMetadata filteredMapping = getMappingsResponse.getMappings().get("filtered");
        assertTrue(sourceAsMap.containsKey("_routing"));
        "properties.key_visible",
        FieldCapabilitiesResponse filtered = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("filtered")).actionGet();  
        + "              }\n"  
        assertTrue(sourceAsMap.containsKey("_source"));
        + "      },"  
        + "              \"tree\": \"quadtree\",\n"
    @SuppressWarnings("unchecked")
            .get();  
        assertFieldMappings(response.mappings().get("test"), FILTERED_FLAT_FIELDS);
        "address.area_visible",  
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;  
            .prepareGetIndex()
        + "              \"type\": \"keyword\"\n"
        + "  \"_doc\": {\n"  
 * license agreements. See the NOTICE file distributed with
        List<String> filteredFields = new ArrayList<>(FILTERED_FLAT_FIELDS);
        "properties.value.keyword_visible"
        + "            \"area_visible\": {\n"  
        assertEquals(5, typeProperties.size());
 */
import org.opensearch.cluster.metadata.MappingMetadata;
        Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
        assertNotNull(mappingMetadata);  
    }  
        assertEquals(0, fieldmapping.size());
        assertNotNull(properties);
        assertExpectedMappings(getIndexResponse.mappings());
        assertLeafs(propertiesProperties, "key_visible");
    private static final String TEST_ITEM = "{\n"
        Map<String, Object> addressProperties = (Map<String, Object>) address.get("properties");
        public Function<String, Predicate<String>> getFieldFilter() {  
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(filtered.getSourceAsMap()));
        + "                \"keyword_visible\" : {\n"  
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("filtered").get();  
        GetIndexResponse getIndexResponse = client().admin()
        assertEquals("nested", properties.get("type"));
    private static final Collection<String> ALL_OBJECT_FIELDS = Arrays.asList("name", "address", "properties");
     * (DocumentInput.ROW_ID_FIELD) that the composite-engine plugin registers node-wide when the sandbox stack is
     * The metadata fields expected on every index on the node: the built-ins plus the system-managed row-id field
import org.opensearch.index.engine.dataformat.DocumentInput;
public class FieldFilterMapperPluginTests extends OpenSearchSingleNodeTestCase {  
        Map<String, Object> nameProperties = (Map<String, Object>) name.get("properties");
    public void putMappings() {
            .indices()  
        }
    public static class FieldFilterPlugin extends Plugin implements MapperPlugin {  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
        assertEquals(1, response.mappings().size());
        MappingMetadata filtered = mappings.get("filtered");
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(sourceAsMap));  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
    private void assertExpectedMappings(Map<String, MappingMetadata> mappings) {
        assertEquals(1, mappings.size());
        + "          \"type\": \"nested\",\n"
        filteredFields.add("properties.value");
        + "}";
            metadataFields.add(DocumentInput.ROW_ID_FIELD);
import java.util.ArrayList;  
    }
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.mapper;
            assertNotNull("expected field [" + field + "] not found", fieldMappingMetadata);  
        }  
        assertMappingsAreValid(filtered.getSourceAsMap());
        + "        \"properties\": {\n"
        // as the one coming from a filtered index with same mappings
        }
        + "            }\n"
