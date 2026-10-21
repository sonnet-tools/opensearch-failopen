        for (int i = 0; i < numGetters; i++) {
    }
    public boolean equals(Object o) {
        Set<ScriptMethodInfo> getters = new HashSet<>(numGetters);
                            + parameterNamesField.getType().getTypeName()
                try {
                            + "] of class ["
                            + "]"
                && Objects.equals(returnType, that.returnType)
            String returnType = returnTypeClazz.getTypeName();
        Objects.requireNonNull(methods);
                } catch (NoSuchFieldException e) {
import java.util.Map;
                constructorArg(),
            @Override
        return this.name;
                    + "] in ["
import java.lang.reflect.Method;
            getters.add(new ScriptMethodInfo(in));
import org.opensearch.core.common.io.stream.Writeable;
 * Licensed to Elasticsearch under one or more contributor
            }
import org.opensearch.core.xcontent.XContentBuilder;
                    execute = method;
        }
    @Override
                return Objects.hash(type, name);
            );
        return Objects.hash(name, execute, getters);
    ScriptContextInfo(String name, List<ScriptMethodInfo> methods) {
/*
        }
            }
 * KIND, either express or implied.  See the License for the
    }
        String executeName = "execute";
                    );
     */
            if (m.name.equals(executeName)) {
                return builder.startObject().field(TYPE_FIELD, this.type).field(NAME_FIELD, this.name).endObject();
        @SuppressWarnings("unchecked")
        String otherName = "other";
import java.util.ArrayList;
                            + parameterTypes.length
            this.getters = Collections.emptySet();
            this.getters = Collections.unmodifiableSet(new HashSet<>(methodTypes.get(getName)));
        this.name = name;
                return Objects.equals(type, that.type) && Objects.equals(name, that.name);
 *
        this.execute = new ScriptMethodInfo(in);
                this.name = Objects.requireNonNull(name);
            builder.startObject().field(NAME_FIELD, name).field(RETURN_TYPE_FIELD, returnType).startArray(PARAMETERS_FIELD);
        );
import java.io.IOException;
            public final String type, name;
import org.opensearch.core.xcontent.ToXContentObject;
                }
                }
                    parameters.add(new ParameterInfo(parameterTypes[i].getTypeName(), argumentNames[i]));
            PARSER.declareString(constructorArg(), new ParseField(RETURN_TYPE_FIELD));
    }
            method.toXContent(builder, params);
 *
                    && m.getName().startsWith("get")
import org.opensearch.core.ParseField;
            public static final String TYPE_FIELD = "type";
            public static ParameterInfo fromXContent(XContentParser parser) throws IOException {
                }
            );
        public final String name, returnType;
        return Objects.equals(name, that.name) && Objects.equals(execute, that.execute) && Objects.equals(getters, that.getters);
            Class<?>[] parameterTypes = execute.getParameterTypes();
         * Parameter information
                    + name
        }
/*
            }
/**
        }
                } catch (IllegalArgumentException | IllegalAccessException e) {
    @Override
        for (ScriptMethodInfo getter : getters) {
        }
                        "Expected argument names ["
        static Set<ScriptMethodInfo> gettersFromContext(Class<?> clazz) {
                PARSER.declareString(constructorArg(), new ParseField(NAME_FIELD));
        out.writeInt(getters.size());
            for (int i = 0; i < numParameters; i++) {
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
    ScriptContextInfo(String name, Class<?> clazz) {
    /**
                    + methods.stream().map(m -> m.name).sorted().collect(Collectors.joining(", ", "[", "]"))
            getter.writeTo(out);
    }
                "Could not find required method ["
import java.util.Comparator;
                if (this == o) return true;
        @Override
    }
 */
            for (ParameterInfo parameter : parameters) {
        return PARSER.parse(parser, null);
            }
    public List<ScriptMethodInfo> methods() {
                this.type = Objects.requireNonNull(type);
                    argumentNames = (String[]) parameterNamesField.get(null);
    }
        /**
                        throw new IllegalArgumentException(
        execute.writeTo(out);
import org.opensearch.common.annotation.PublicApi;
    public final ScriptMethodInfo execute;
        } else if ((methodTypes.get(executeName).size() != 1)) {
            );
            return builder.endArray().endObject();
                    parameterNamesField = clazz.getField(parametersFieldName);
                            + clazz.getName()
            );
            if (this == o) return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        methods.add(this.execute);
                return executeName;
        }
            }
            @Override
         * @opensearch.internal
    public String getName() {
import org.opensearch.core.common.io.stream.StreamOutput;
        public void writeTo(StreamOutput out) throws IOException {
                try {
        static final String PARAMETERS_FIELD = "params";
        public boolean equals(Object o) {
                if (method.getName().equals(name)) {
            }
        public static ScriptMethodInfo fromXContent(XContentParser parser) throws IOException {
                return getName;
        if (this == o) return true;
            Class<?> returnTypeClazz = execute.getReturnType();
    public static final ConstructingObjectParser<ScriptContextInfo, Void> PARSER = new ConstructingObjectParser<>(
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "1.0.0")
                    throw new IllegalArgumentException(
    }
    @Override
        methods.addAll(this.getters);
                out.writeString(name);
        }
        static ScriptMethodInfo executeFromContext(Class<?> clazz) {
            this.parameters = Collections.unmodifiableList(parameters);
 */
                    throw new IllegalArgumentException(
     * Script method information
                this.type = in.readString();
        ScriptContextInfo that = (ScriptContextInfo) o;
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.name = in.readString();
            this.returnType = in.readString();
        true,
            for (java.lang.reflect.Method m : clazz.getMethods()) {
                "parameters",
                            + name
            for (Method method : clazz.getMethods()) {
                        "Expected a constant [String[] PARAMETERS] on instance class ["
                parameter.toXContent(builder, params);
                String[] argumentNames;
        int numGetters = in.readInt();
        }
            ArrayList<ParameterInfo> parameters = new ArrayList<>(numParameters);
            int numParameters = in.readInt();
        }
            Method execute = null;
        "script_context_info",
        if (methodTypes.containsKey(executeName) == false) {
import java.util.HashSet;
import java.lang.reflect.Modifier;
    }
    public final String name;
import java.util.Collections;
        (m, name) -> new ScriptContextInfo((String) m[0], (List<ScriptMethodInfo>) m[1])
                            + "] on instance class ["
            }
/*
            String name = "execute";
        if (methodTypes.containsKey(getName)) {
 * this work for additional information regarding copyright
            }
        static final String RETURN_TYPE_FIELD = "return_type";
    @PublicApi(since = "1.0.0")
        );
            out.writeString(returnType);
            @Override
public class ScriptContextInfo implements ToXContentObject, Writeable {
            return getters;
            new ParseField(METHODS_FIELD)
                if (o == null || getClass() != o.getClass()) return false;
import java.util.Set;
        this.name = Objects.requireNonNull(name);
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
                    && !Modifier.isStatic(m.getModifiers())
                new ParseField(PARAMETERS_FIELD)
    public final Set<ScriptMethodInfo> getters;
    public void writeTo(StreamOutput out) throws IOException {
        public final List<ParameterInfo> parameters;
                            + "] for method ["
            throw new IllegalArgumentException(
        }
                this.name = in.readString();
        // ignored instead of error, so future implementations can add methods. Same as ScriptContextInfo(String, Class).
 * GitHub history for details.
                            + "] with ["
            }
            if (o == null || getClass() != o.getClass()) return false;
                            + clazz.getName()
import java.util.Objects;
        this.getters = Collections.unmodifiableSet(ScriptMethodInfo.gettersFromContext(clazz));
    public int hashCode() {
        static {
                true,
 * under the License.
import java.lang.reflect.Field;
        } else {
        PARSER.declareString(constructorArg(), new ParseField(NAME_FIELD));
    public static class ScriptMethodInfo implements ToXContentObject, Writeable {
    public static ScriptContextInfo fromXContent(XContentParser parser) throws IOException {
            for (ParameterInfo parameter : parameters) {
                            + "] to have the same arity ["
                            + parametersFieldName
                            + parameterTypes.length
            private static final ConstructingObjectParser<ParameterInfo, Void> PARSER = new ConstructingObjectParser<>(
import org.opensearch.core.xcontent.ConstructingObjectParser;
                            + parameterTypes.length
            static {
            PARSER.declareObjectArray(
                if (argumentNames.length != parameterTypes.length) {
            public boolean equals(Object o) {
            return Objects.hash(name, returnType, parameters);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        execute.toXContent(builder, params);
                        "Could not find field ["
                Field parameterNamesField;
                    if (execute != null) {
            public void writeTo(StreamOutput out) throws IOException {
    }
                for (int i = 0; i < argumentNames.length; i++) {
                }
}
                    && !m.getName().equals("getClass")
            out.writeInt(parameters.size());
            return PARSER.parse(parser, null);
                && Objects.equals(parameters, that.parameters);
            "method",
        for (ScriptMethodInfo method : getters.stream().sorted(Comparator.comparing(g -> g.name)).collect(Collectors.toList())) {
            return Objects.equals(name, that.name)
            (m, name) -> new ScriptMethodInfo((String) m[0], (String) m[1], (List<ParameterInfo>) m[2])
        this.execute = ScriptMethodInfo.executeFromContext(clazz);
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, List<ScriptMethodInfo>> methodTypes = methods.stream().collect(Collectors.groupingBy(m -> {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return new ScriptMethodInfo(name, returnType, parameters);
        public ScriptMethodInfo(StreamInput in) throws IOException {
    }
        ArrayList<ScriptMethodInfo> methods = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                String parametersFieldName = "PARAMETERS";
                return PARSER.parse(parser, null);
                            + "] parameters, found ["
                parameter.writeTo(out);
 *
                out.writeString(type);
            (parser, ctx) -> ScriptMethodInfo.PARSER.apply(parser, ctx),
            true,
package org.opensearch.script;
    private static final String NAME_FIELD = "name";
            }
        this.execute = Objects.requireNonNull(execute);
            if (parameterTypes.length > 0) {
 * not use this file except in compliance with the License.
        }));
        this.name = Objects.requireNonNull(name);
import java.util.stream.Collectors;
    // Deserialization constructor
                if (!m.isDefault()
                    getters.add(new ScriptMethodInfo(m.getName(), m.getReturnType().getTypeName(), new ArrayList<>()));
                            + clazz.getName()
            }
        String getName = "get";
                    );
                (parser, ctx) -> ParameterInfo.PARSER.apply(parser, ctx),
        PARSER.declareObjectArray(
        this.execute = methodTypes.get(executeName).get(0);
                ParameterInfo that = (ParameterInfo) o;
            } else if (m.name.startsWith(getName) && m.parameters.size() == 0) {
        builder.startObject().field(NAME_FIELD, name).startArray(METHODS_FIELD);
                            + "]"
        }
                throw new IllegalArgumentException("Could not find required method [" + name + "] on class [" + clazz.getName() + "]");
                if (!parameterNamesField.getType().equals(String[].class)) {
                        );
                }
 * Unless required by applicable law or agreed to in writing,
 * Information about a script context
                            + name
 * You may obtain a copy of the License at
    static {
            this.name = in.readString();
            ScriptMethodInfo that = (ScriptMethodInfo) o;
            constructorArg(),
    @SuppressWarnings("unchecked")
                            "Cannot have multiple [" + name + "] methods on class [" + clazz.getName() + "]"
     * @opensearch.api
                    + "], found "
        return builder.endArray().endObject();
            public ParameterInfo(StreamInput in) throws IOException {
                            + "] parameters"
            // See ScriptContext.findMethod
 * ownership. Elasticsearch licenses this file to you under
         *
            public ParameterInfo(String type, String name) {
            this.name = Objects.requireNonNull(name);
                            + argumentNames.length
        }
 * SPDX-License-Identifier: Apache-2.0
    // Test constructor
        out.writeString(name);
            PARSER.declareString(constructorArg(), new ParseField(NAME_FIELD));
                "Cannot have multiple [execute] methods in [" + name + "], found [" + methodTypes.get(executeName).size() + "]"
                PARSER.declareString(constructorArg(), new ParseField(TYPE_FIELD));
                parameters.add(new ParameterInfo(in));
            out.writeString(name);
        public int hashCode() {
        @Override
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        public ScriptMethodInfo(String name, String returnType, List<ParameterInfo> parameters) {
        public static class ParameterInfo implements ToXContentObject, Writeable {
            HashSet<ScriptMethodInfo> getters = new HashSet<>();
    // ScriptService constructor
        }
            List<ParameterInfo> parameters = new ArrayList<>();
 *
            }
                            + "] has ["
        this.getters = Objects.requireNonNull(getters);
                            + "] but method ["
                (p) -> new ParameterInfo((String) p[0], (String) p[1])
        }
            if (execute == null) {
 * license agreements. See the NOTICE file distributed with
                    && m.getParameters().length == 0) {
                            + "] for method ["
    }
        }
                    }
            throw new IllegalArgumentException(
     *
            }
    }
    );
 */
import java.util.List;
                            + name
                    throw new IllegalArgumentException("Error trying to read [" + clazz.getName() + "#ARGUMENTS]", e);
            }
 * @opensearch.api
        if (o == null || getClass() != o.getClass()) return false;
 * the Apache License, Version 2.0 (the "License"); you may
        this.getters = Collections.unmodifiableSet(getters);
         */
 * specific language governing permissions and limitations
 */
                // See ScriptClassInfo.readArgumentNamesConstant
    private static final String METHODS_FIELD = "methods";
        }
            this.returnType = Objects.requireNonNull(returnType);
                    throw new IllegalArgumentException(
                // TODO: ensure empty/no PARAMETERS if parameterTypes.length == 0?
                    + executeName
    public ScriptContextInfo(String name, ScriptMethodInfo execute, Set<ScriptMethodInfo> getters) {
            }
                }
        return Collections.unmodifiableList(methods);
            this.parameters = Collections.unmodifiableList(Objects.requireNonNull(parameters));
import org.opensearch.core.xcontent.XContentParser;
            }
        private static final ConstructingObjectParser<ScriptMethodInfo, Void> PARSER = new ConstructingObjectParser<>(
                    );
    public ScriptContextInfo(StreamInput in) throws IOException {
                }
    }
            public int hashCode() {
            return otherName;
            // See ScriptClassInfo(PainlessLookup painlessLookup, Class<?> baseClass)
