    }
        @SuppressWarnings({ "unchecked", "rawtypes" })
        DynamicProperty dp = new DynamicProperty("*_i", Map.of("type", "long"));  
        Map<String, Object> nested = new TreeMap<>();
        XContentBuilder builder = XContentFactory.jsonBuilder();  
    public void testGetMapping() {
        assertThat(copyTo, equalTo(List.of("dest_a", "dest_b")));
public class DynamicPropertyTests extends OpenSearchTestCase {  
import java.util.Map;  
        DynamicProperty dp = new DynamicProperty("*_t", Map.of("type", "text"));
        Map<String, Object> mapping = new TreeMap<>();  
        mapping.put("meta", nested);  
    public void testMappingForNameLeavesListValuesUnsubstituted() {
        Map<String, Object> mapping = new HashMap<>();
    }
        assertTrue(resolved.containsKey("name_s_subfield"));
        assertThat(builder.toString(), containsString("\"type\":\"text\""));
        assertThat(builder.toString(), containsString("\"*_t\""));
        assertThat(meta.get("path"), equalTo("meta_name_s_suffix"));
import java.util.List;
import java.util.TreeMap;
import static org.hamcrest.Matchers.containsString;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentFactory;
        assertThat(e.getMessage(), containsString("string keys"));
import org.opensearch.test.OpenSearchTestCase;
        @SuppressWarnings("unchecked")
    public void testMappingForNameSubstitutesLeafInKeysAndStringValues() {  
}  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(resolved.get("type"), equalTo("keyword"));  
        mapping.put("{name}_subfield", Map.of("type", "keyword"));
    public void testMatchesFullDottedPath() {
        assertTrue(dp.matches("count_i"));
    }
        nested.put("path", "meta_{name}_suffix");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> dp.mappingForName("a_k"));  
        assertFalse(dp.matches("count_j"));  
 * The OpenSearch Contributors require contributions made to  
        DynamicProperty dp = new DynamicProperty("*_s", mapping);
    }  
    /** Lists and other non-map, non-string values are stored unchanged by {@code mappingForName}. */  
        Map badNested = new HashMap();
        assertThat(dp.getMapping().get("doc_values"), equalTo(Boolean.FALSE));  
 */  
import static org.hamcrest.Matchers.equalTo;
    public void testToXContent() throws IOException {
 * compatible open source license.
        badNested.put(1, "x");  
        mapping.put("type", "keyword");  
        assertTrue(dp.matches("parent.child_i"));
        mapping.put("fields", badNested);
import org.opensearch.core.xcontent.XContentBuilder;  
package org.opensearch.index.mapper;
    }
        DynamicProperty dp = new DynamicProperty("*_k", mapping);
        builder.endObject();  
    }
 *
        dp.toXContent(builder, ToXContent.EMPTY_PARAMS);
import java.io.IOException;  
        assertThat(resolved.get("type"), equalTo("keyword"));
        mapping.put("copy_to", List.of("dest_a", "dest_b"));
        DynamicProperty dp = new DynamicProperty("*_k", m);
        Map<String, Object> mapping = new TreeMap<>();
        DynamicProperty dp = new DynamicProperty("*_s", mapping);
        Map<String, Object> meta = (Map<String, Object>) resolved.get("meta");  
/*  
        List<String> copyTo = (List<String>) resolved.get("copy_to");  
        mapping.put("type", "keyword");
import java.util.HashMap;
    public void testMappingForNameRejectsNonStringNestedKeys() {
        Map<String, Object> resolved = dp.mappingForName("name_s");
        assertThat(dp.getMapping().get("type"), equalTo("keyword"));
        Map<String, Object> resolved = dp.mappingForName("name_s");  
        builder.startObject();
        @SuppressWarnings("unchecked")
        mapping.put("type", "keyword");  
        Map<String, Object> m = new TreeMap<>(Map.of("type", "keyword", "doc_values", Boolean.FALSE));  
import org.opensearch.core.xcontent.ToXContent;
