import java.util.HashMap;  
        assertTrue("Should have position field", result.containsKey("position"));
        List<String> stack = new ArrayList<>();
        // Verify script stack
        stack.add("line 1: error");
 */  
import org.opensearch.protobufs.ObjectMap;
 * compatible open source license.
        Map<String, ObjectMap.Value> positionMap = positionValue.getObjectMap().getFieldsMap();  
import org.opensearch.test.OpenSearchTestCase;  
        Map<String, ObjectMap.Value> map = new HashMap<>();
package org.opensearch.transport.grpc.proto.response.exceptions;
        stack.add("line 1: error");
        assertEquals("Second stack item should match", stack.get(1), stackValue.getListValue().getValue(1).getString());  
        // Test the toProto method that takes a builder and position  
    }
    public void testMetadataToProtoWithoutPosition() {  
        ObjectMap.Value stackValue = metadata.get("script_stack");  
        assertTrue("Should have script_stack field", metadata.containsKey("script_stack"));
        // Verify position field
        // Convert to Protocol Buffer
        ObjectMap.Value positionValue = result.get("position");
        assertTrue("Should have lang field", metadata.containsKey("lang"));
        // Create a builder and add position  
        assertTrue("Position should have offset field", positionMap.containsKey("offset"));
        ScriptException.Position pos = new ScriptException.Position(10, 5, 15);
    public void testToProtoBuilderMethod() {
    public void testMetadataToProtoWithPosition() {  
        String lang = "painless";  
        // Create a ScriptException without position information
        assertEquals("end should match", 15, positionMap.get("end").getInt32());
        assertTrue("Should have script field", metadata.containsKey("script"));  
        assertEquals("script should match", script, scriptValue.getString());
        Map<String, ObjectMap.Value> positionMap = positionValue.getObjectMap().getFieldsMap();  
 * The OpenSearch Contributors require contributions made to  
        // Convert to Protocol Buffer
        ScriptException exception = new ScriptException("Test script error", new RuntimeException("Test cause"), stack, script, lang, pos);
 *
        Map<String, ObjectMap.Value> metadata = ScriptExceptionProtoUtils.metadataToProto(exception);
        assertEquals("lang should match", lang, langValue.getString());  
        assertEquals("First stack item should match", stack.get(0), stackValue.getListValue().getValue(0).getString());
        // Create a ScriptException with position information
        ScriptException.Position pos = new ScriptException.Position(10, 5, 15);
        assertEquals("offset should match", 10, positionMap.get("offset").getInt32());
        assertTrue("Should have position field", metadata.containsKey("position"));
 * this file be licensed under the Apache-2.0 license or a
        String lang = "painless";  
    }  
import java.util.Map;
        // Verify field values
import java.util.ArrayList;
        String script = "doc['field'].value > 100";
        ScriptException exception = new ScriptException("Test script error", new RuntimeException("Test cause"), stack, script, lang);
    }
        ObjectMap.Value langValue = metadata.get("lang");  
        stack.add("line 2: another error");  
}  
        Map<String, ObjectMap.Value> metadata = ScriptExceptionProtoUtils.metadataToProto(exception);
        assertEquals("start should match", 5, positionMap.get("start").getInt32());  
        List<String> stack = new ArrayList<>();
        assertEquals("script_stack should have 2 items", 2, stackValue.getListValue().getValueCount());
public class ScriptExceptionProtoUtilsTests extends OpenSearchTestCase {
        assertTrue("Position should have start field", positionMap.containsKey("start"));  
        assertEquals("end should match", 15, positionMap.get("end").getInt32());
import java.util.List;
        // Verify position field
        ObjectMap.Value positionValue = metadata.get("position");
        assertEquals("offset should match", 10, positionMap.get("offset").getInt32());  
        // Verify the conversion
 * SPDX-License-Identifier: Apache-2.0
        // Verify the result
        String script = "doc['field'].value > 100";
        Map<String, ObjectMap.Value> result = ScriptExceptionProtoUtils.toProto(map, pos);
import org.opensearch.script.ScriptException;
        // Verify the conversion
        assertEquals("start should match", 5, positionMap.get("start").getInt32());
/*  
        ObjectMap.Value scriptValue = metadata.get("script");
        assertTrue("Position should have end field", positionMap.containsKey("end"));
        assertFalse("Should have position field", metadata.containsKey("position"));
