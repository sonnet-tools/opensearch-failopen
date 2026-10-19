 */  
        expectThrows(
import java.util.List;
        assertTrue(json.contains(e.getLang()));
            () -> { new ScriptException("test", new Exception(), Collections.emptyList(), null, "b"); }  
        expectThrows(NullPointerException.class, () -> { new ScriptException(null, new Exception(), Collections.emptyList(), "a", "b"); });
        assertTrue(json.contains("stack1"));
        assertTrue(json.contains(e.getScript()));  
        assertNull(e.getPos());
 * license agreements. See the NOTICE file distributed with
    public void testRoundTrip() throws IOException {
        ScriptException e = new ScriptException("a", new Exception(), Arrays.asList("element1", "element2"), "a", "b");  
 * Licensed to Elasticsearch under one or more contributor  
            new Exception("causeData"),
 * specific language governing permissions and limitations
        e.writeTo(output);  
        e = new ScriptException(
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
        assertTrue(json.contains("1"));
            e.getScript(),  
 * You may obtain a copy of the License at  
        assertTrue(json.contains("3"));
            "langData",
            e.getScriptStack(),
            "sourceData",  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
/*  
/** Simple tests for {@link ScriptException} */  
 * under the License.  
import org.opensearch.core.common.io.stream.StreamOutput;
        input.close();
            "messageData",  
    /** Test that our elements are present in the json output */  
 * SPDX-License-Identifier: Apache-2.0
import java.io.ByteArrayOutputStream;
import org.opensearch.core.common.io.stream.StreamInput;  
            Arrays.asList("stack1", "stack2"),
            "messageData",  
    /** ensure we can round trip in serialization */  
        input = new InputStreamStreamInput(new ByteArrayInputStream(bytes.toByteArray()));  
 * Unless required by applicable law or agreed to in writing,
}
    }
        output.close();
        assertTrue(json.contains("2"));  
    }  
            new ScriptException.Position(1, 0, 2)
/*
            e.getMessage(),  
        bytes = new ByteArrayOutputStream();
            "langData"
 * this work for additional information regarding copyright
        assertTrue(json.contains("stack2"));
        );
            "sourceData",  
    /** ensure the script stack is immutable */
        assertEquals(e.getScriptStack(), e2.getScriptStack());
import java.util.Collections;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            NullPointerException.class,  
    /** ensure no parameters can be null except pos*/
        assertTrue(json.contains(e.getMessage()));
        ScriptException e = new ScriptException(
        input.close();
    public void testNoLeniency() {  
 *  
        expectThrows(UnsupportedOperationException.class, () -> { stack.add("no"); });
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
import java.io.ByteArrayInputStream;
 * software distributed under the License is distributed on an
    public void testJsonOutput() {
        );  
 * ownership. Elasticsearch licenses this file to you under  
/*  
        expectThrows(NullPointerException.class, () -> { new ScriptException("test", new Exception(), null, "a", "b"); });  
        output = new DataOutputStreamOutput(new DataOutputStream(bytes));
        ScriptException e = new ScriptException(
 * The OpenSearch Contributors require contributions made to  
import java.util.Arrays;
        assertEquals(e.getScript(), e2.getScript());  
 */
    }  
        // Ensure non-null position also works
            new ScriptException.Position(2, 1, 3)
            () -> { new ScriptException("test", new Exception(), Collections.emptyList(), "a", null); }
        assertEquals(e.getPos(), e2.getPos());  
        );
package org.opensearch.script;
            new Exception("causeData"),
 * the Apache License, Version 2.0 (the "License"); you may
        e2 = new ScriptException(input);
        assertTrue(json.contains(e.getCause().getMessage()));  
        String json = e.toJsonString();
import org.opensearch.core.common.io.stream.DataOutputStreamOutput;
        );
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
 *
        assertEquals(e.getMessage(), e2.getMessage());
        assertEquals(e.getLang(), e2.getLang());
import java.io.IOException;
        output.close();
        StreamOutput output = new DataOutputStreamOutput(new DataOutputStream(bytes));
        StreamInput input = new InputStreamStreamInput(new ByteArrayInputStream(bytes.toByteArray()));  
            e.getLang(),
import java.io.DataOutputStream;  
            NullPointerException.class,
        e.writeTo(output);  
            Arrays.asList("stack1", "stack2"),
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
            e.getCause(),
        List<String> stack = e.getScriptStack();
        expectThrows(
        ScriptException e2 = new ScriptException(input);
    public void testImmutableStack() {
    }
public class ScriptExceptionTests extends OpenSearchTestCase {
 *
        expectThrows(NullPointerException.class, () -> { new ScriptException("test", null, Collections.emptyList(), "a", "b"); });
