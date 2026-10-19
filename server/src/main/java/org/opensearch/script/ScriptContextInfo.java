                            + name
        execute.writeTo(out);
 */
            if (o == null || getClass() != o.getClass()) return false;
import java.util.ArrayList;  
            this.parameters = Collections.unmodifiableList(Objects.requireNonNull(parameters));  
        for (int i = 0; i < numGetters; i++) {
            return Objects.equals(name, that.name)
                            + "] on instance class ["
            // See ScriptClassInfo(PainlessLookup painlessLookup, Class<?> baseClass)
                    + executeName  
 */  
            builder.startObject().field(NAME_FIELD, name).field(RETURN_TYPE_FIELD, returnType).startArray(PARAMETERS_FIELD);
    }
                "Could not find required method ["
                }
 * @opensearch.api  
            out.writeInt(parameters.size());
                }
        for (ScriptMethodInfo getter : getters) {  
    public static final ConstructingObjectParser<ScriptContextInfo, Void> PARSER = new ConstructingObjectParser<>(
                            + parametersFieldName  
 *
            this.name = Objects.requireNonNull(name);
 * not use this file except in compliance with the License.
                    throw new IllegalArgumentException(
 * Licensed to Elasticsearch under one or more contributor  
            }
        /**
            PARSER.declareString(constructorArg(), new ParseField(RETURN_TYPE_FIELD));
        @Override
                (parser, ctx) -> ParameterInfo.PARSER.apply(parser, ctx),
            }
    }
            HashSet<ScriptMethodInfo> getters = new HashSet<>();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean equals(Object o) {  
        return this.name;  
            out.writeString(name);  
            if (parameterTypes.length > 0) {
                }
                } catch (NoSuchFieldException e) {  
            }  
                if (argumentNames.length != parameterTypes.length) {
        ArrayList<ScriptMethodInfo> methods = new ArrayList<>();
                            + "] has ["
import java.util.stream.Collectors;
            static {  
    /**
            for (ParameterInfo parameter : parameters) {
            true,
         */  
    }
        }
                    && !Modifier.isStatic(m.getModifiers())
            this.getters = Collections.emptySet();
 * KIND, either express or implied.  See the License for the
        }
        public void writeTo(StreamOutput out) throws IOException {
            }
 * software distributed under the License is distributed on an
        public ScriptMethodInfo(StreamInput in) throws IOException {  
 *  
                }
        (m, name) -> new ScriptContextInfo((String) m[0], (List<ScriptMethodInfo>) m[1])
            }  
        } else if ((methodTypes.get(executeName).size() != 1)) {  
        Set<ScriptMethodInfo> getters = new HashSet<>(numGetters);
            public boolean equals(Object o) {  
                Field parameterNamesField;  
        out.writeString(name);  
    }  
                        "Expected a constant [String[] PARAMETERS] on instance class ["  
        Map<String, List<ScriptMethodInfo>> methodTypes = methods.stream().collect(Collectors.groupingBy(m -> {  
import java.io.IOException;
            (m, name) -> new ScriptMethodInfo((String) m[0], (String) m[1], (List<ParameterInfo>) m[2])  
    }  
                    throw new IllegalArgumentException("Error trying to read [" + clazz.getName() + "#ARGUMENTS]", e);
                constructorArg(),
                            + "] for method ["
                return Objects.hash(type, name);  
    @Override  
    }  
/*  
        if (methodTypes.containsKey(executeName) == false) {  
import org.opensearch.core.xcontent.ToXContentObject;
                    );  
        }
import java.util.List;
    public boolean equals(Object o) {
                    + name
                    if (execute != null) {
        execute.toXContent(builder, params);
        static final String PARAMETERS_FIELD = "params";
 */
 *
        ScriptContextInfo that = (ScriptContextInfo) o;
                ParameterInfo that = (ParameterInfo) o;  
            return getters;
        this.getters = Objects.requireNonNull(getters);  
        this.getters = Collections.unmodifiableSet(ScriptMethodInfo.gettersFromContext(clazz));  
                } catch (IllegalArgumentException | IllegalAccessException e) {  
 * Modifications Copyright OpenSearch Contributors. See
@PublicApi(since = "1.0.0")
                            + argumentNames.length
        }));
            }
        if (methodTypes.containsKey(getName)) {
            }  
            "method",
        builder.startObject().field(NAME_FIELD, name).startArray(METHODS_FIELD);  
                    && m.getName().startsWith("get")  
                "parameters",
                            + parameterTypes.length  
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    }  
    private static final String NAME_FIELD = "name";
        this.execute = ScriptMethodInfo.executeFromContext(clazz);
            );
            }  
                    + methods.stream().map(m -> m.name).sorted().collect(Collectors.joining(", ", "[", "]"))
    static {
            public static ParameterInfo fromXContent(XContentParser parser) throws IOException {
    @Override
    public final Set<ScriptMethodInfo> getters;  
            PARSER.declareObjectArray(  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                // See ScriptClassInfo.readArgumentNamesConstant
 * The OpenSearch Contributors require contributions made to  
            String returnType = returnTypeClazz.getTypeName();  
                out.writeString(name);  
                if (!parameterNamesField.getType().equals(String[].class)) {
            return PARSER.parse(parser, null);
            out.writeString(returnType);
            for (java.lang.reflect.Method m : clazz.getMethods()) {
            getters.add(new ScriptMethodInfo(in));  
            public int hashCode() {
        public static class ParameterInfo implements ToXContentObject, Writeable {
        String getName = "get";  
            new ParseField(METHODS_FIELD)
                throw new IllegalArgumentException("Could not find required method [" + name + "] on class [" + clazz.getName() + "]");
                    throw new IllegalArgumentException(
                        );
            public void writeTo(StreamOutput out) throws IOException {
                return executeName;
            } else if (m.name.startsWith(getName) && m.parameters.size() == 0) {  
public class ScriptContextInfo implements ToXContentObject, Writeable {  
                new ParseField(PARAMETERS_FIELD)  
        }
                            + "]"
        }  
        }  
            constructorArg(),
                if (o == null || getClass() != o.getClass()) return false;
 * Unless required by applicable law or agreed to in writing,
        Objects.requireNonNull(methods);  
        }
import org.opensearch.common.annotation.PublicApi;
                    + "], found "  
            this.returnType = Objects.requireNonNull(returnType);
         * @opensearch.internal
                            + "]"
        this.getters = Collections.unmodifiableSet(getters);
        true,
        if (o == null || getClass() != o.getClass()) return false;  
        this.name = Objects.requireNonNull(name);
            }
import java.util.Comparator;
        }
/*  
                    );
            Method execute = null;
import org.opensearch.core.common.io.stream.StreamOutput;
    @PublicApi(since = "1.0.0")
    @Override
import org.opensearch.core.common.io.stream.StreamInput;  
            for (ParameterInfo parameter : parameters) {  
    // Test constructor
import org.opensearch.core.common.io.stream.Writeable;
            private static final ConstructingObjectParser<ParameterInfo, Void> PARSER = new ConstructingObjectParser<>(  
            if (this == o) return true;
        return Collections.unmodifiableList(methods);
                this.name = in.readString();
            );  
import java.lang.reflect.Field;  
 * this file be licensed under the Apache-2.0 license or a
                if (this == o) return true;
            return new ScriptMethodInfo(name, returnType, parameters);
                    );  
                PARSER.declareString(constructorArg(), new ParseField(TYPE_FIELD));
        this.execute = new ScriptMethodInfo(in);
                        throw new IllegalArgumentException(  
            public static final String TYPE_FIELD = "type";
                return builder.startObject().field(TYPE_FIELD, this.type).field(NAME_FIELD, this.name).endObject();
                    && !m.getName().equals("getClass")
import java.util.Collections;
 * under the License.  
        this.name = in.readString();
    @SuppressWarnings("unchecked")
            this.getters = Collections.unmodifiableSet(new HashSet<>(methodTypes.get(getName)));
                try {
     */  
        public int hashCode() {
}
                            + name  
    ScriptContextInfo(String name, Class<?> clazz) {  
            return builder.endArray().endObject();
        private static final ConstructingObjectParser<ScriptMethodInfo, Void> PARSER = new ConstructingObjectParser<>(  
        // ignored instead of error, so future implementations can add methods. Same as ScriptContextInfo(String, Class).
 * Information about a script context
        @Override  
        public final List<ParameterInfo> parameters;
            for (int i = 0; i < numParameters; i++) {
import org.opensearch.core.xcontent.XContentParser;  
    }  
            return otherName;  
import org.opensearch.core.xcontent.XContentBuilder;
            public ParameterInfo(String type, String name) {  
 */  
            @Override  
         *
            }
                return PARSER.parse(parser, null);  
            }  
            }
                parameters.add(new ParameterInfo(in));  
            throw new IllegalArgumentException(
                    parameterNamesField = clazz.getField(parametersFieldName);
            int numParameters = in.readInt();  
        static {  
                    argumentNames = (String[]) parameterNamesField.get(null);
    private static final String METHODS_FIELD = "methods";  
        static ScriptMethodInfo executeFromContext(Class<?> clazz) {
                    execute = method;
/**  
                            + parameterTypes.length
    public void writeTo(StreamOutput out) throws IOException {
        @SuppressWarnings("unchecked")
                            + clazz.getName()
                    && m.getParameters().length == 0) {  
        }
            ScriptMethodInfo that = (ScriptMethodInfo) o;  
                if (method.getName().equals(name)) {
                parameter.toXContent(builder, params);  
                return Objects.equals(type, that.type) && Objects.equals(name, that.name);
    public int hashCode() {  
                            + "] for method ["
            @Override
                    getters.add(new ScriptMethodInfo(m.getName(), m.getReturnType().getTypeName(), new ArrayList<>()));
            Class<?> returnTypeClazz = execute.getReturnType();
                            + "] parameters, found ["  
        @Override
            this.name = in.readString();
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                            "Cannot have multiple [" + name + "] methods on class [" + clazz.getName() + "]"
                if (!m.isDefault()
    public static ScriptContextInfo fromXContent(XContentParser parser) throws IOException {
                            + clazz.getName()
            String name = "execute";  
                            + parameterTypes.length  
                // TODO: ensure empty/no PARAMETERS if parameterTypes.length == 0?
                    }  
                this.name = Objects.requireNonNull(name);
    public final String name;
        this.execute = methodTypes.get(executeName).get(0);
    }  
        public static ScriptMethodInfo fromXContent(XContentParser parser) throws IOException {
            for (Method method : clazz.getMethods()) {  
import java.util.Map;
            return Objects.hash(name, returnType, parameters);
            (parser, ctx) -> ScriptMethodInfo.PARSER.apply(parser, ctx),  
            ArrayList<ParameterInfo> parameters = new ArrayList<>(numParameters);
        } else {  
 * ownership. Elasticsearch licenses this file to you under  
            Class<?>[] parameterTypes = execute.getParameterTypes();
package org.opensearch.script;
                PARSER.declareString(constructorArg(), new ParseField(NAME_FIELD));
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        if (this == o) return true;
        );
        );
                }
                    parameters.add(new ParameterInfo(parameterTypes[i].getTypeName(), argumentNames[i]));
    ScriptContextInfo(String name, List<ScriptMethodInfo> methods) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            + "] but method ["  
            List<ParameterInfo> parameters = new ArrayList<>();  
    }
                return getName;
        String executeName = "execute";
            getter.writeTo(out);
                        "Expected argument names ["  
    public final ScriptMethodInfo execute;
            );
        return Objects.hash(name, execute, getters);
                "Cannot have multiple [execute] methods in [" + name + "], found [" + methodTypes.get(executeName).size() + "]"
        }
import org.opensearch.core.ParseField;
            public final String type, name;
            PARSER.declareString(constructorArg(), new ParseField(NAME_FIELD));
        PARSER.declareString(constructorArg(), new ParseField(NAME_FIELD));  
    public ScriptContextInfo(String name, ScriptMethodInfo execute, Set<ScriptMethodInfo> getters) {  
                this.type = in.readString();  
    }
        PARSER.declareObjectArray(
            public ParameterInfo(StreamInput in) throws IOException {
 * compatible open source license.
                            + parameterNamesField.getType().getTypeName()
        }
import java.lang.reflect.Method;
        this.execute = Objects.requireNonNull(execute);
    // Deserialization constructor  
    // ScriptService constructor
 * license agreements. See the NOTICE file distributed with
                parameter.writeTo(out);
    public static class ScriptMethodInfo implements ToXContentObject, Writeable {
        out.writeInt(getters.size());
        }  
        public ScriptMethodInfo(String name, String returnType, List<ParameterInfo> parameters) {  
    public List<ScriptMethodInfo> methods() {  
        return PARSER.parse(parser, null);  
     * @opensearch.api
            if (m.name.equals(executeName)) {
            }
 *
        return builder.endArray().endObject();
                (p) -> new ParameterInfo((String) p[0], (String) p[1])  
            }
                && Objects.equals(returnType, that.returnType)
                            + "] with ["
    }
        methods.add(this.execute);
                && Objects.equals(parameters, that.parameters);  
                    throw new IllegalArgumentException(
        "script_context_info",  
            // See ScriptContext.findMethod
     *
            this.parameters = Collections.unmodifiableList(parameters);
            }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this work for additional information regarding copyright
                }  
                String parametersFieldName = "PARAMETERS";  
        return Objects.equals(name, that.name) && Objects.equals(execute, that.execute) && Objects.equals(getters, that.getters);
                    + "] in ["
                out.writeString(type);
/*
        int numGetters = in.readInt();  
                String[] argumentNames;  
        for (ScriptMethodInfo method : getters.stream().sorted(Comparator.comparing(g -> g.name)).collect(Collectors.toList())) {
        }  
            method.toXContent(builder, params);  
                this.type = Objects.requireNonNull(type);
                }
            );
        String otherName = "other";
    );  
        public final String name, returnType;  
 * SPDX-License-Identifier: Apache-2.0
                            + "] to have the same arity ["
            this.returnType = in.readString();
                            + clazz.getName()
        }  
import java.lang.reflect.Modifier;
import java.util.Set;
            @Override
                try {
            if (execute == null) {
        static Set<ScriptMethodInfo> gettersFromContext(Class<?> clazz) {
                for (int i = 0; i < argumentNames.length; i++) {  
        }
        this.name = name;
                            + name
    }  
                            + "] of class ["  
        static final String RETURN_TYPE_FIELD = "return_type";  
 * GitHub history for details.
     * Script method information  
 * specific language governing permissions and limitations
                true,
            }  
                            + "] parameters"
         * Parameter information  
    public String getName() {
            throw new IllegalArgumentException(
        this.name = Objects.requireNonNull(name);
        }
import java.util.HashSet;  
                        "Could not find field ["
        methods.addAll(this.getters);  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;  
    public ScriptContextInfo(StreamInput in) throws IOException {  
