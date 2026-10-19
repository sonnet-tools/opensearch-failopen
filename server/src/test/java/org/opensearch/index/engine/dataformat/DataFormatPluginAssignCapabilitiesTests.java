        plugin.assignCapabilities(fieldType, null, null);  
            Set.of(
    }
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
import java.util.Map;
        MockDataFormat format = new MockDataFormat(
        );
 * The OpenSearch Contributors require contributions made to  
    public void testFieldWithNoRequestedCapabilities_EmptyMap() {  
            Set.of(new FieldTypeCapabilities("keyword", Set.of(FieldTypeCapabilities.Capability.BLOOM_FILTER)))
                    "integer",  
        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("test_field");
        MockDataFormat format = new MockDataFormat(
        assertTrue(ex.getMessage().contains("FULL_TEXT_SEARCH"));
            "integer-only-format",
        assertTrue(fieldType.getCapabilityMap().isEmpty());  
        );
    }
        Map<DataFormat, Set<FieldTypeCapabilities.Capability>> capMap = fieldType.getCapabilityMap();
            false,
                    "keyword",
            NumberFieldMapper.NumberType.INTEGER,  
        DataFormatPlugin plugin = MockDataFormatPlugin.of(format);
        DataFormatPlugin plugin = MockDataFormatPlugin.of(format);  
        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("test_field");  
            100L,  
        DataFormatPlugin plugin = MockDataFormatPlugin.of(format);  
        DataFormatPlugin plugin = MockDataFormatPlugin.of(format);  
            null,  
        assertTrue(ex.getMessage().contains("COLUMNAR_STORAGE"));
            100L,  
            Set.of(new FieldTypeCapabilities("keyword", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))  
                )
            Map.of()
    }  
public class DataFormatPluginAssignCapabilitiesTests extends OpenSearchTestCase {
    public void testSingleFormatPartialCoverage_Throws() {
            Set.of(
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        );
import org.opensearch.index.mapper.KeywordFieldMapper;  
 */  
            "keyword-format",  
        MockDataFormat format = new MockDataFormat(
}
                new FieldTypeCapabilities(  
package org.opensearch.index.engine.dataformat;
        plugin.assignCapabilities(fieldType, null, null);
            Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.COLUMNAR_STORAGE),  
        DataFormatPlugin plugin = MockDataFormatPlugin.of(format);
            false,  
 *
            false,
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> plugin.assignCapabilities(fieldType, null, null));
        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("test_field");  
import org.opensearch.index.mapper.NumberFieldMapper;
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> plugin.assignCapabilities(fieldType, null, null));  
        );
        assertTrue(ex.getMessage().contains("FULL_TEXT_SEARCH"));  
    public void testSingleFormatCoversAllCapabilities() {
        );
    }
        MockDataFormat format = new MockDataFormat(  
            100L,
            100L,  
    public void testFormatDoesNotSupportFieldType_Throws() {  
                    Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)
import org.opensearch.index.mapper.MapperParsingException;
            "no_caps",
 * SPDX-License-Identifier: Apache-2.0
            100L,
        assertTrue(ex.getMessage().contains("cannot cover"));  
 * compatible open source license.
        NumberFieldMapper.NumberFieldType fieldType = new NumberFieldMapper.NumberFieldType(
            false,
            )
        assertEquals(
                new FieldTypeCapabilities(
                    Set.of(FieldTypeCapabilities.Capability.POINT_RANGE, FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)
        );
                )  
            true,
        assertTrue(capMap.containsKey(format));
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> plugin.assignCapabilities(fieldType, null, null));
        assertEquals(1, capMap.size());  
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.POINT_RANGE)))
    public void testFormatSupportsSubsetOnly_Throws() {  
        MockDataFormat format = new MockDataFormat(
/*  
import java.util.Set;  
        );
import org.opensearch.test.OpenSearchTestCase;  
            )  
        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("test_field");
 * this file be licensed under the Apache-2.0 license or a
            "partial-format",
            capMap.get(format)
    }  
            "some-format",
            "bloom-only-format",
