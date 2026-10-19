            String returnType = getters.remove(getter.name);  
                new BytesArray("{\"type\":\"foo\", \"name\": \"bar\"}").streamInput()
        };
import java.util.Set;
            String returnType = getters.remove(getter.name);
        eparams.add(new Tuple<>("long", "bar"));
    }
        ScriptContextInfo info = new ScriptContextInfo(name, MinimalContext.class);
                put("getNonDefault1", "boolean");
            () -> new ScriptContextInfo("bad_parameters_field_type", BadParametersFieldType.class)
    }  
            String returnType = methods.remove(method.name);
            return 'a';
                "noExecute",  
            new ScriptContextInfo.ScriptMethodInfo(  
        }
            + "    {"
                new HashSet<>(
        public byte getByte() {
        public boolean execute(boolean foo) {
import org.opensearch.common.xcontent.XContentFactory;
                )  
                )
            return true;
    public static class CustomType1 {}  
            }
        String json = "{"  
        XContentParser parser = MediaTypeRegistry.JSON.xContent()
        );
package org.opensearch.script;
                "execute",
                "int",
    }  
 * license agreements. See the NOTICE file distributed with
        }
        assertEquals(0, methods.size());
 * ownership. Elasticsearch licenses this file to you under  
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Term\","
        String name = "primitive_context";  
        );
            return new CustomType2();
 *
        }
        }
            + "      \"name\": \"execute\","
        }
            assertEquals(0, getter.parameters.size());
                put("getCustom2", ct2);  
    }  
        assertEquals(name, info.name);
            + "      ]"  
        List<Tuple<String, String>> eparams = new ArrayList<>();
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Term", "term"),
    public static class CustomTypeContext {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            return new CustomType1();  
            return 1;  
            + "        },"
    public void testScriptContextInfoParser() throws IOException {
                + "] for method [execute] with [1] parameters, found [int[]]",
        }
    public void testScriptMethodInfoParser() throws IOException {
/*  
        ScriptContextInfo.ScriptMethodInfo info = ScriptContextInfo.ScriptMethodInfo.fromXContent(parser);
        for (ScriptContextInfo.ScriptMethodInfo getter : info.getters) {  
            IllegalArgumentException.class,
            + "    {"  
        );
            }  
            + "        }"
    public void testWrongNumberOfParameters() {  
    public interface MinimalContext {
            new ScriptMethodInfo("execute", "double", Collections.emptyList()),
        String ct2 = ct + 2;  
            IllegalArgumentException.class,
        }  
                        new ScriptContextInfo.ScriptMethodInfo.ParameterInfo("int", "fooParam"),
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Field", "field"),
        public boolean getNonDefault1() {  
                NamedXContentRegistry.EMPTY,  
        public static final String[] PARAMETERS = { "foo" };  
            )
            return foo;  
            ),  
    }
    public static class CustomType0 {}
                        )  
    public interface Default {
        for (int i = 0; i < info.execute.parameters.size(); i++) {
    public static class TwoExecute {
            .createParser(
        }
                    new ScriptMethodInfo("otherName", "bool", Collections.emptyList())
 * You may obtain a copy of the License at  
            + "      \"params\": ["  
        IllegalArgumentException e = expectThrows(  
        ScriptContextInfo constructed = new ScriptContextInfo(  
        }
    }
        eparams.add(new Tuple<>("boolean", "foo"));
        assertEquals(0, methods.size());
 */
            () -> new ScriptContextInfo("no_parameters_field", NoParametersField.class)
        );
                        new ScriptMethodInfo("get_score", "double", new ArrayList<>())  
 * Modifications Copyright OpenSearch Contributors. See
            "Expected argument names [2] to have the same arity [1] for method [execute] of class ["  
            + "      \"name\": \"getParams\","  
        public CustomType2 getCustom2() {  
            new ScriptMethodInfo(  
                    Arrays.asList(  
        assertEquals(ct0, info.execute.returnType);
        );
        void execute();  
            + "  ]"
import org.opensearch.test.OpenSearchTestCase;
        ScriptContextInfo info = new ScriptContextInfo(name, CustomTypeContext.class);
        assertEquals("Could not find required method [execute] on class [" + NoExecute.class.getName() + "]", e.getMessage());  
            {
            {  
    public static class NoParametersField {  
            String returnType = methods.remove(method.name);  
        );
                Collections.unmodifiableList(  
                        new ParameterInfo("double", "weight"),
    public void testBadParametersFieldType() {
            IllegalArgumentException.class,
import org.opensearch.core.xcontent.XContentParser;
        public void execute(int foo) {}
        };
        IllegalArgumentException e = expectThrows(
            + "          \"name\": \"doc\""
    public void testGetterConditional() {
            assertEquals(returnType, method.returnType);
                Collections.unmodifiableList(
                    new ScriptMethodInfo("execute", "double", Collections.emptyList()),
            + "  \"name\": \"similarity\","
            assertEquals(eparams.get(i).v2(), info.execute.parameters.get(i).name);
            + "    }"
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        );
        };
    }
        assertEquals(
        assertEquals(  
        public void execute() {}
        assertEquals(2, info.getters.size());  
        eparams.add(new Tuple<>("short", "baz"));  
            return 0.1f;
            + "        {"
        ScriptContextInfo parsed = ScriptContextInfo.fromXContent(parser);  
        }  
        IllegalArgumentException e = expectThrows(
        ScriptContextInfo info = new ScriptContextInfo(name, PrimitiveContext.class);
import org.opensearch.core.xcontent.DeprecationHandler;
        public static long getStatic() {
    }  
    }
            assertEquals(eparams.get(i).v1(), info.execute.parameters.get(i).type);  
        HashMap<String, String> getters = new HashMap<String, String>() {
    }
        ScriptContextInfo.ScriptMethodInfo.ParameterInfo info = ScriptContextInfo.ScriptMethodInfo.ParameterInfo.fromXContent(parser);
        public CustomType1 getCustom1() {
        public static final int[] PARAMETERS = { 1 };
                        new ScriptMethodInfo("getParams", "java.util.Map", new ArrayList<>()),
 * Unless required by applicable law or agreed to in writing,
                put("getNonDefault2", "float");
            "otherNames",
    public void testIgnoreOtherMethodsInListConstructor() {
        HashMap<String, String> methods = new HashMap<String, String>() {
                "multiexecute",
            () -> new ScriptContextInfo(  
        assertEquals("execute", info.execute.name);  
    public void testMinimalContext() {  
            return 2L;  
        assertEquals("execute", info.execute.name);
            assertEquals(returnType, getter.returnType);
        HashMap<String, String> methods = new HashMap<String, String>() {
 * compatible open source license.
            e.getMessage()
        assertEquals("void", info.execute.returnType);
        }
                            "double",
            );  
                    )
            .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, new BytesArray(json).streamInput());
        assertEquals("Could not find required method [execute] in [noExecute], found [getSome, getSomeOther]", e.getMessage());  
                put("execute", ct0);  
                    )
        assertEquals(expected, constructed);
        assertEquals(
                    )
            + "{\"type\": \"java.util.Map\", \"name\": \"barParam\"}]}";
    }  
import org.opensearch.script.ScriptContextInfo.ScriptMethodInfo;  
            assertEquals(returnType, method.returnType);  
    public void testParameterInfoParser() throws IOException {
                )
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Doc", "doc")  
        eparams.add(new Tuple<>(ct1, "custom1"));
                    )
            + "    },"
                Arrays.asList(  
            IllegalArgumentException.class,  
            IllegalArgumentException.class,
        );
    }
                    Arrays.asList(
            }
            + "}";  
    }  
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Field\","
        }
            () -> new ScriptContextInfo(
                + "]",
                Collections.unmodifiableList(
    public void testMultipleExecuteInListConstructor() {  
                    Arrays.asList(
public class ScriptContextInfoTests extends OpenSearchTestCase {
import org.opensearch.script.ScriptContextInfo.ScriptMethodInfo.ParameterInfo;
    public static class PrimitiveContext {
import java.util.Arrays;  
    public static class WrongNumberOfParameters {  
            e.getMessage()  
    }  
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Query\","  
        assertEquals(0, info.execute.parameters.size());  
    }  
import java.util.List;
    }
 * under the License.  
 * GitHub history for details.
            + "        },"  
            assertEquals(returnType, getter.returnType);
        String ct1 = ct + 1;
        assertEquals(0, getters.size());
        );
            () -> new ScriptContextInfo("no_execute", NoExecute.class)
        assertEquals(expected, parsed);
            "similarity",
        boolean getNonDefault1();  
                + "] but method [execute] has [1] parameters",  
        List<Tuple<String, String>> eparams = new ArrayList<>();  
        }  
            assertNotNull(returnType);
            + "          \"name\": \"weight\""  
    public void testCustomTypeContext() {
                "fooFunc",
            + "      \"name\": \"getDoc\","
        assertEquals("execute", info.execute.name);
        eparams.add(new Tuple<>(ct2, "custom2"));  
    }
        public char getChar() {  
            () -> new ScriptContextInfo("two_execute", TwoExecute.class)  
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Doc\","  
                        new ScriptMethodInfo("execute", "double", Collections.emptyList()),
            )  
        }
                        new ScriptContextInfo.ScriptMethodInfo.ParameterInfo("java.util.Map", "barParam")  
            info
            + "          \"name\": \"field\""
            + "        },"
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        IllegalArgumentException e = expectThrows(
 *
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        ScriptContextInfo expected = new ScriptContextInfo(  
            .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, new BytesArray(json).streamInput());  
        public CustomType0 execute(CustomType1 custom1, CustomType2 custom2) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            "execute",  
            + "  \"methods\": ["
                        new ScriptMethodInfo("getDoc", "java.util.Map", new ArrayList<>()),
                    Arrays.asList(
            "Could not find field [PARAMETERS] on instance class ["
        String name = "minimal_context";
        eparams.add(new Tuple<>("float", "qux"));
    public void testNoExecuteInListConstructor() {
        public char getChar(char ch) {  
/*
 * this file be licensed under the Apache-2.0 license or a
    public static class NoExecute {}
        assertEquals("Cannot have multiple [execute] methods in [multiexecute], found [2]", e.getMessage());
        };  
        String name = "custom_type_context";
                "double",
            IllegalArgumentException.class,
    }  
    }  
            {
            + "          \"type\": \"double\","
    }  
            + "      \"params\": []"  
        public static final String[] PARAMETERS = { "foo", "bar", "baz", "qux" };  
            () -> new ScriptContextInfo("wrong_number_of_parameters", WrongNumberOfParameters.class)  
                put("getCustom1", ct1);
        ScriptContextInfo expected = new ScriptContextInfo(
            Collections.emptySet()  
        public static final String[] PARAMETERS = { "custom1", "custom2" };  
                        new ScriptMethodInfo("getSomeOther", "int", Collections.emptyList()),  
        public void execute(int foo) {}  
            + "      \"return_type\": \"double\","
            + "      \"return_type\": \"double\","
import org.opensearch.common.collect.Tuple;
import java.util.HashSet;  
        XContentParser parser = MediaTypeRegistry.JSON.xContent()
        assertEquals(name, info.name);  
        assertEquals(new ScriptContextInfo.ScriptMethodInfo.ParameterInfo("foo", "bar"), info);
    public void testPrimitiveContext() {
        }
        );
            + "        },"
        for (ScriptContextInfo.ScriptMethodInfo method : info.methods()) {  
        );  
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(2, info.execute.parameters.size());  
            "Expected a constant [String[] PARAMETERS] on instance class ["
        assertEquals(2, getters.size());
import java.util.Collections;
        );
        String ct = "org.opensearch.script.ScriptContextInfoTests$CustomType";  
                put("getCustom1", ct1);
            }
            + "        {"
            + "          \"name\": \"term\""  
                + WrongNumberOfParameters.class.getName()
            + "        {"
        IllegalArgumentException e = expectThrows(  
        }
 * specific language governing permissions and limitations
    public void testNoExecute() {
        IllegalArgumentException e = expectThrows(
        assertEquals("int", info.execute.returnType);
    public static class GetterConditional implements Default {  
        public void execute(int foo) {}
            e.getMessage()
            {  
    }
                        new ScriptMethodInfo("getSome", "bool", Collections.emptyList())
                + NoParametersField.class.getName()
                put("getChar", "char");
        Set<ScriptMethodInfo> getters = new ScriptContextInfo("getter_conditional", GetterConditional.class).getters;  
        assertEquals(name, info.name);  
import java.util.ArrayList;
            + "      \"params\": []"
 * KIND, either express or implied.  See the License for the
                put("getCustom2", ct2);
    public void testTwoExecute() {  
    public static class BadParametersFieldType {
        for (ScriptContextInfo.ScriptMethodInfo method : getters) {
            Collections.unmodifiableList(
            + "      \"return_type\": \"java.util.Map\","
            + "    },"  
        assertEquals(0, info.getters.size());
            + "    {"
            Collections.unmodifiableSet(
            + "          \"name\": \"query\""
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals("Cannot have multiple [execute] methods on class [" + TwoExecute.class.getName() + "]", e.getMessage());
                )
                + BadParametersFieldType.class.getName()  
import java.io.IOException;
            )
            return new CustomType0();  
            ),  
        String json = "{\"name\": \"fooFunc\", \"return_type\": \"int\", \"params\": [{\"type\": \"int\", \"name\": \"fooParam\"}, "  
            + "    },"
                new ArrayList<>(  
            "otherNames",
        HashMap<String, String> getters = new HashMap<String, String>() {  
            IllegalArgumentException.class,  
                put("getByte", "byte");  
            return 0;  
            + "      \"params\": []"
        assertEquals(4, info.execute.parameters.size());
                    )
 */  
 */  
        assertEquals(2, info.getters.size());
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.common.bytes.BytesArray;  
        XContentParser parser = MediaTypeRegistry.JSON.xContent()
                        new ScriptMethodInfo(
        public float getNonDefault2() {
/*  
                )
 *  
            assertNotNull(returnType);
                )  
        for (int i = 0; i < info.execute.parameters.size(); i++) {
        }
    public static class CustomType2 {}
            + "      \"name\": \"get_score\","
            return 0x00;  
    public void testNoParametersField() {
                            Collections.unmodifiableList(Arrays.asList(new ParameterInfo("double", "weight")))
            assertEquals(eparams.get(i).v1(), info.execute.parameters.get(i).type);
            + "    {"  
            assertNotNull(returnType);
        for (ScriptContextInfo.ScriptMethodInfo getter : info.getters) {
            assertEquals(0, getter.parameters.size());
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Query", "query"),  
        XContentBuilder builder = XContentFactory.jsonBuilder();
            + "      \"return_type\": \"java.util.Map\","  
        IllegalArgumentException e = expectThrows(
        default int getDefault() {
        assertEquals(
        public void execute(int foo) {}  
        );
            assertEquals(eparams.get(i).v2(), info.execute.parameters.get(i).name);  
            assertNotNull(returnType);  
            )  
    }
            + "        {"  
        assertEquals(0, getters.size());  
 * Licensed to Elasticsearch under one or more contributor  
}
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        String ct0 = ct + 0;
 * this work for additional information regarding copyright
    }
                    Arrays.asList(  
    }  
            return ch;
        public static final String[] PARAMETERS = { "foo", "bar" };  
        );  
            + "        {"
        public int execute(boolean foo, long bar, short baz, float qux) {
