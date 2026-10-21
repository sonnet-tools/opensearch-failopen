        HashMap<String, String> methods = new HashMap<String, String>() {
        IllegalArgumentException e = expectThrows(
import java.util.Collections;
        eparams.add(new Tuple<>(ct1, "custom1"));
            )
        assertEquals(0, info.execute.parameters.size());
            assertEquals(0, getter.parameters.size());
            + "        },"
            + "    {"
        for (int i = 0; i < info.execute.parameters.size(); i++) {
    public void testParameterInfoParser() throws IOException {
    public static class CustomType2 {}
        );
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public interface Default {
            + "      \"params\": []"
            new ScriptContextInfo.ScriptMethodInfo(
        );
    }
            }
import java.util.ArrayList;
        String ct2 = ct + 2;
    public void testNoParametersField() {
        String ct = "org.opensearch.script.ScriptContextInfoTests$CustomType";
                            Collections.unmodifiableList(Arrays.asList(new ParameterInfo("double", "weight")))
    public void testScriptContextInfoParser() throws IOException {
            IllegalArgumentException.class,
        public char getChar(char ch) {
 * this work for additional information regarding copyright
                put("getNonDefault1", "boolean");
        ScriptContextInfo info = new ScriptContextInfo(name, PrimitiveContext.class);
    }
        }
 * specific language governing permissions and limitations
                put("getChar", "char");
                Arrays.asList(
        assertEquals(4, info.execute.parameters.size());
        assertEquals(2, info.getters.size());
        assertEquals(name, info.name);
        public boolean execute(boolean foo) {
    public static class CustomTypeContext {
            new ScriptMethodInfo("execute", "double", Collections.emptyList()),
    public static class NoExecute {}
        assertEquals(expected, constructed);
    public static class CustomType0 {}
        ScriptContextInfo parsed = ScriptContextInfo.fromXContent(parser);
    public void testNoExecute() {
    }
/*
            String returnType = methods.remove(method.name);
        assertEquals(2, getters.size());
    }
            }
        XContentParser parser = MediaTypeRegistry.JSON.xContent()
                put("execute", ct0);
                NamedXContentRegistry.EMPTY,
            assertEquals(returnType, method.returnType);
            return new CustomType2();
                new HashSet<>(
 * ownership. Elasticsearch licenses this file to you under
            + "          \"name\": \"term\""
            + "        }"
        ScriptContextInfo constructed = new ScriptContextInfo(
            + "          \"name\": \"doc\""
        public CustomType1 getCustom1() {
            + "    }"
import org.opensearch.common.xcontent.XContentFactory;
        }
        HashMap<String, String> methods = new HashMap<String, String>() {
                            "double",
        }
                Collections.unmodifiableList(
            + "  ]"
import java.util.Arrays;
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Term\","
        eparams.add(new Tuple<>("float", "qux"));
                put("getCustom1", ct1);
        }
    public void testMinimalContext() {
    public void testIgnoreOtherMethodsInListConstructor() {
 *
            + "      \"return_type\": \"double\","
        assertEquals(0, methods.size());
        assertEquals(new ScriptContextInfo.ScriptMethodInfo.ParameterInfo("foo", "bar"), info);
            return 0.1f;
    }
            + "          \"name\": \"query\""
    public static class WrongNumberOfParameters {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("void", info.execute.returnType);
        }
    }
        public void execute() {}
                    Arrays.asList(
        public CustomType2 getCustom2() {
            () -> new ScriptContextInfo("bad_parameters_field_type", BadParametersFieldType.class)
        }
                        new ScriptMethodInfo("getDoc", "java.util.Map", new ArrayList<>()),
            return 'a';
            + "        {"
    }
    public void testScriptMethodInfoParser() throws IOException {
                        )
            return 1;
                    )
        IllegalArgumentException e = expectThrows(
        String ct1 = ct + 1;
                Collections.unmodifiableList(
                "execute",
            {
            + "}";
        }
        List<Tuple<String, String>> eparams = new ArrayList<>();
        public static final String[] PARAMETERS = { "foo", "bar" };
            return new CustomType1();
        String ct0 = ct + 0;
                    )
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Query", "query"),
        default int getDefault() {
        XContentParser parser = MediaTypeRegistry.JSON.xContent()
        assertEquals(0, getters.size());
            IllegalArgumentException.class,
    }
                "fooFunc",
        List<Tuple<String, String>> eparams = new ArrayList<>();
        assertEquals(ct0, info.execute.returnType);
        eparams.add(new Tuple<>(ct2, "custom2"));
import java.io.IOException;
                put("getCustom2", ct2);
        public static final String[] PARAMETERS = { "foo", "bar", "baz", "qux" };
        public void execute(int foo) {}
            "similarity",
}
import org.opensearch.common.collect.Tuple;
            Collections.unmodifiableSet(
            new ScriptMethodInfo(
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Term", "term"),
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        assertEquals("int", info.execute.returnType);
            assertEquals(returnType, getter.returnType);
        assertEquals(name, info.name);
            {
 * You may obtain a copy of the License at
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Field", "field"),
        }
            );
        assertEquals("execute", info.execute.name);
            assertEquals(eparams.get(i).v1(), info.execute.parameters.get(i).type);
            Collections.emptySet()
        );
        );
import org.opensearch.core.common.bytes.BytesArray;
    }
            assertEquals(eparams.get(i).v2(), info.execute.parameters.get(i).name);
                "multiexecute",
                        new ParameterInfo("double", "weight"),
 */
    public static class BadParametersFieldType {
            + "      \"return_type\": \"java.util.Map\","
            () -> new ScriptContextInfo("two_execute", TwoExecute.class)
            + "      \"name\": \"getParams\","
            + "        },"
        assertEquals(
        assertEquals(0, getters.size());
            e.getMessage()
        XContentBuilder builder = XContentFactory.jsonBuilder();
            .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, new BytesArray(json).streamInput());
    public void testPrimitiveContext() {
        public static final String[] PARAMETERS = { "custom1", "custom2" };
        }
        public boolean getNonDefault1() {
            + "      \"name\": \"getDoc\","
    public static class TwoExecute {
        }
        assertEquals(
        assertEquals(2, info.getters.size());
                new BytesArray("{\"type\":\"foo\", \"name\": \"bar\"}").streamInput()
                put("getCustom1", ct1);
        assertEquals(0, methods.size());
            + "    {"
        assertEquals("execute", info.execute.name);
    public interface MinimalContext {
            return 0;
        assertEquals(0, info.getters.size());
        assertEquals(
            () -> new ScriptContextInfo("no_parameters_field", NoParametersField.class)
            Collections.unmodifiableList(
                )
        for (ScriptContextInfo.ScriptMethodInfo getter : info.getters) {
            return new CustomType0();
        eparams.add(new Tuple<>("short", "baz"));
        String name = "minimal_context";
                put("getNonDefault2", "float");
            "Could not find field [PARAMETERS] on instance class ["
        IllegalArgumentException e = expectThrows(
            assertNotNull(returnType);
                        new ScriptMethodInfo("getSomeOther", "int", Collections.emptyList()),
 * Modifications Copyright OpenSearch Contributors. See
        );
            + "      \"name\": \"execute\","
    }
        public void execute(int foo) {}
 * the Apache License, Version 2.0 (the "License"); you may
        };
                            "execute",
    }
    public void testTwoExecute() {
                        new ScriptMethodInfo("getParams", "java.util.Map", new ArrayList<>()),
    }
            e.getMessage()
                    new ScriptMethodInfo("execute", "double", Collections.emptyList()),
            )
        public static final String[] PARAMETERS = { "foo" };
import org.opensearch.script.ScriptContextInfo.ScriptMethodInfo;
                    Arrays.asList(
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Doc\","
    public static class NoParametersField {
            () -> new ScriptContextInfo("wrong_number_of_parameters", WrongNumberOfParameters.class)
                    new ScriptMethodInfo("otherName", "bool", Collections.emptyList())
        assertEquals(name, info.name);
        String name = "primitive_context";
            ),
        for (ScriptContextInfo.ScriptMethodInfo method : info.methods()) {
        ScriptContextInfo expected = new ScriptContextInfo(
    }
                + "] but method [execute] has [1] parameters",
            + "          \"name\": \"weight\""
        public static long getStatic() {
        public byte getByte() {
        ScriptContextInfo.ScriptMethodInfo info = ScriptContextInfo.ScriptMethodInfo.fromXContent(parser);
                        new ScriptMethodInfo("execute", "double", Collections.emptyList()),
            e.getMessage()
        public char getChar() {
            + "      \"name\": \"get_score\","
            + "        {"
    public void testNoExecuteInListConstructor() {
                put("getByte", "byte");
        public int execute(boolean foo, long bar, short baz, float qux) {
        );
 * Unless required by applicable law or agreed to in writing,
                    )
                        new ParameterInfo("org.opensearch.index.similarity.ScriptedSimilarity$Doc", "doc")
 * The OpenSearch Contributors require contributions made to
                        new ScriptMethodInfo("getSome", "bool", Collections.emptyList())
        assertEquals("Could not find required method [execute] on class [" + NoExecute.class.getName() + "]", e.getMessage());
        for (ScriptContextInfo.ScriptMethodInfo method : getters) {
            () -> new ScriptContextInfo(
        assertEquals("Cannot have multiple [execute] methods on class [" + TwoExecute.class.getName() + "]", e.getMessage());
import java.util.List;
        };
    }
                + BadParametersFieldType.class.getName()
        for (int i = 0; i < info.execute.parameters.size(); i++) {
    public static class CustomType1 {}
    }
            assertEquals(0, getter.parameters.size());
            assertEquals(eparams.get(i).v1(), info.execute.parameters.get(i).type);
    }
            () -> new ScriptContextInfo(
        assertEquals(expected, parsed);
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Query\","
        };
                        new ScriptContextInfo.ScriptMethodInfo.ParameterInfo("java.util.Map", "barParam")
            ),
        ScriptContextInfo.ScriptMethodInfo.ParameterInfo info = ScriptContextInfo.ScriptMethodInfo.ParameterInfo.fromXContent(parser);
    }
    public void testMultipleExecuteInListConstructor() {
/*
        IllegalArgumentException e = expectThrows(
            + "    },"
import org.opensearch.core.xcontent.XContentParser;
                + NoParametersField.class.getName()
                put("getCustom2", ct2);
 *
            )
    public void testBadParametersFieldType() {
            + "        {"
        assertEquals("execute", info.execute.name);
    }
        }
            assertNotNull(returnType);
            return ch;
            + "    },"
import org.opensearch.script.ScriptContextInfo.ScriptMethodInfo.ParameterInfo;
        assertEquals("Could not find required method [execute] in [noExecute], found [getSome, getSomeOther]", e.getMessage());
import org.opensearch.core.xcontent.DeprecationHandler;
        String name = "custom_type_context";
            + "      \"return_type\": \"java.util.Map\","
            + "    },"
            + "  \"name\": \"similarity\","
                )
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Cannot have multiple [execute] methods in [multiexecute], found [2]", e.getMessage());
            "Expected argument names [2] to have the same arity [1] for method [execute] of class ["
            + "      \"params\": []"
        );
            {
 * under the License.
        String json = "{\"name\": \"fooFunc\", \"return_type\": \"int\", \"params\": [{\"type\": \"int\", \"name\": \"fooParam\"}, "
            + "    {"
            IllegalArgumentException.class,
                    Arrays.asList(
            + "          \"type\": \"org.opensearch.index.similarity.ScriptedSimilarity$Field\","
            + "      \"params\": []"
                + "]",
            String returnType = getters.remove(getter.name);
            assertNotNull(returnType);
    }
            .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, new BytesArray(json).streamInput());
            }
            assertEquals(returnType, getter.returnType);
 * GitHub history for details.
            + "        {"
        );
            assertEquals(eparams.get(i).v2(), info.execute.parameters.get(i).name);
 * software distributed under the License is distributed on an
        XContentParser parser = MediaTypeRegistry.JSON.xContent()
            + "    {"
 * Licensed to Elasticsearch under one or more contributor
            IllegalArgumentException.class,
                + "] for method [execute] with [1] parameters, found [int[]]",
            return true;
            + "        },"
        }
            + "        {"
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    public void testCustomTypeContext() {
            IllegalArgumentException.class,
import org.opensearch.core.xcontent.XContentBuilder;
 * license agreements. See the NOTICE file distributed with
                        new ScriptMethodInfo(
        String json = "{"
            "otherNames",
            + "  \"methods\": ["
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testGetterConditional() {
            .createParser(
        public void execute(int foo) {}
        }
        );
    public static class GetterConditional implements Default {
                )
        public float getNonDefault2() {
            + "          \"type\": \"double\","
            )
    }
        );
        IllegalArgumentException e = expectThrows(
        public static final int[] PARAMETERS = { 1 };
 *
                    )
                )
            "otherNames",
public class ScriptContextInfoTests extends OpenSearchTestCase {
        }
        void execute();
            info
        }
        ScriptContextInfo info = new ScriptContextInfo(name, CustomTypeContext.class);
            + "        },"
/*
        ScriptContextInfo info = new ScriptContextInfo(name, MinimalContext.class);
            + "      ]"
        public void execute(int foo) {}
                        new ScriptMethodInfo("get_score", "double", new ArrayList<>())
                "double",
            "Expected a constant [String[] PARAMETERS] on instance class ["
                        new ScriptContextInfo.ScriptMethodInfo.ParameterInfo("int", "fooParam"),
            {
        HashMap<String, String> getters = new HashMap<String, String>() {
        ScriptContextInfo expected = new ScriptContextInfo(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            IllegalArgumentException.class,
            assertNotNull(returnType);
        public CustomType0 execute(CustomType1 custom1, CustomType2 custom2) {
                Collections.unmodifiableList(
            return foo;
        eparams.add(new Tuple<>("long", "bar"));
 */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.script;
            + "      \"return_type\": \"double\","
            IllegalArgumentException.class,
 * KIND, either express or implied.  See the License for the
        IllegalArgumentException e = expectThrows(
        );
import java.util.HashSet;
            String returnType = methods.remove(method.name);
                    Arrays.asList(
            assertEquals(returnType, method.returnType);
    public void testWrongNumberOfParameters() {
            + "      \"params\": ["
        );
                )
        }
        );
                    )
            + "          \"name\": \"field\""
        assertEquals(
        };
    }
        );
                    Arrays.asList(
import java.util.HashMap;
 * compatible open source license.
                "noExecute",
        HashMap<String, String> getters = new HashMap<String, String>() {
                "int",
            () -> new ScriptContextInfo("no_execute", NoExecute.class)
            + "{\"type\": \"java.util.Map\", \"name\": \"barParam\"}]}";
                new ArrayList<>(
            return 2L;
    }
        boolean getNonDefault1();
        Set<ScriptMethodInfo> getters = new ScriptContextInfo("getter_conditional", GetterConditional.class).getters;
        }
import java.util.Set;
        for (ScriptContextInfo.ScriptMethodInfo getter : info.getters) {
        assertEquals(2, info.execute.parameters.size());
 */
    public static class PrimitiveContext {
            String returnType = getters.remove(getter.name);
                + WrongNumberOfParameters.class.getName()
        }
            return 0x00;
        IllegalArgumentException e = expectThrows(
        eparams.add(new Tuple<>("boolean", "foo"));
 * not use this file except in compliance with the License.
            }
                )
