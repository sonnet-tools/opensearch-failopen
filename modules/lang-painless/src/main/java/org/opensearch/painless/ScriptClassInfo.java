     */
            return (String[]) argumentNamesField.get(null);
                        m.getName(),
    private final Class<?> baseClass;
        Class<?> defClass = definitionTypeForClass(
                    );
            throw new IllegalArgumentException(
            executeMethod.getReturnType(),
     * The interface that the Painless script should implement.
                }
    public Class<?> getExecuteMethodReturnType() {
                        )
        }
        if (argumentNamesConstant.length != types.length) {
     */
                + "] is of unknown type ["
                    defConverter = new FunctionTable.LocalFunction(
 * SPDX-License-Identifier: Apache-2.0
/*
import org.opensearch.painless.lookup.PainlessLookupUtility;
import static java.util.Collections.unmodifiableList;
     * Painless {@link Class}es and name of the argument to the {@code execute} method.
        try {
        return executeMethod;
import java.lang.reflect.Modifier;
                            + baseClass.getName()
        private final String name;
            } else if (m.getName().startsWith("get")
     */
                            m.getName(),
        }
                }
    private final List<org.objectweb.asm.commons.Method> getMethods;
     * return bytecode.
                        );
    private final List<org.objectweb.asm.commons.Method> needsMethods;
    }
     * script.
                                + m.getName()
        this.converters = unmodifiableList(converters);
 *    http://www.apache.org/licenses/LICENSE-2.0
     * The {@code uses$varName} methods that must be implemented by Painless to complete implementing the interface.
    }
    /**
 */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.lookup.def;
        Class<?> type,
     */
            this.name = name;
 *
 * software distributed under the License is distributed on an
/**
                                + "allowlisted."
                        "Painless can only implement interfaces that have a single method named [execute] but ["
        }
                    executeMethod = m;
    /**
                        true,
                    returnType = m.getReturnType();
        );
 *
        return getMethods;
            throw new IllegalArgumentException(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return executeMethodReturnType;
        ArrayList<FunctionTable.LocalFunction> converters = new ArrayList<>();
                    );
    public ScriptClassInfo(PainlessLookup painlessLookup, Class<?> baseClass) {
        this.executeArguments = unmodifiableList(arguments);
}
                } else {
        // Find the main method and the uses$argName methods
import java.lang.reflect.Field;
                } else {
        if (componentType != def.class && painlessLookup.lookupPainlessClass(componentType) == null) {
                            m.getReturnType(),
                        new FunctionTable.LocalFunction(m.getName(), m.getReturnType(), Arrays.asList(m.getParameterTypes()), true, true)
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * KIND, either express or implied.  See the License for the
        this.baseClass = baseClass;
                + componentType.getName()
    }
                    + iface.getName()
 * this file be licensed under the Apache-2.0 license or a
                + ". Painless interfaces can only accept arguments that are of allowlisted types."
                        m.getReturnType(),
        }
        try {
     */
    public final FunctionTable.LocalFunction defConverter;
                && m.getName().equals("getClass") == false
                                + "]. Painless can only support getters with return types that are "
                    );
        return needsMethods;
                    );
        return type;
        }
    /**
            arguments.add(methodArgument(painlessLookup, types[arg], argumentNamesConstant[arg]));
        }
                        Arrays.asList(m.getParameterTypes()),
                            painlessLookup,
 * Unless required by applicable law or agreed to in writing,
    }
        type = PainlessLookupUtility.javaTypeToType(type);
        }
     * Painless {@link Class}s and names of the arguments to the {@code execute} method. The names are exposed to the Painless
                    + "] doesn't have one."
                    }
    private final org.objectweb.asm.commons.Method executeMethod;
                        true
        return new MethodArgument(defClass, argName);
        if (executeMethod == null) {
import java.util.function.Function;
    public List<Class<?>> getGetReturns() {
    private final Class<?> executeMethodReturnType;
 * The OpenSearch Contributors require contributions made to
                && m.getReturnType() == returnType
 * not use this file except in compliance with the License.
/*
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "
     */
    private final List<Class<?>> getReturns;
        executeMethodReturnType = definitionTypeForClass(
import org.opensearch.painless.lookup.PainlessLookup;
    public List<org.objectweb.asm.commons.Method> getGetMethods() {
        this.executeMethod = new org.objectweb.asm.commons.Method(executeMethod.getName(), methodType.toMethodDescriptorString());
        public MethodArgument(Class<?> clazz, String name) {
    public final List<FunctionTable.LocalFunction> converters;
                "[" + baseClass.getName() + "#ARGUMENTS] has length [2] but [" + baseClass.getName() + "#execute] takes [1] argument."
 * ownership. Elasticsearch licenses this file to you under
                if (m.getName().equals("convertFromDef")) {
import java.util.ArrayList;
 */
            );
            );
            throw new IllegalArgumentException("Error trying to read [" + iface.getName() + "#ARGUMENTS]", e);
                                + "] has unknown return "
    }
                        definitionTypeForClass(
                + argName
        for (java.lang.reflect.Method m : baseClass.getMethods()) {
        FunctionTable.LocalFunction defConverter = null;
import java.util.Arrays;
                            + "] has more than one."
        Class<?> componentType = type;
 * You may obtain a copy of the License at
                if (executeMethod == null) {
import java.util.List;
import org.opensearch.painless.symbol.FunctionTable;
        return getReturns;
        this.needsMethods = unmodifiableList(needsMethods);
        MethodType methodType = MethodType.methodType(executeMethod.getReturnType(), executeMethod.getParameterTypes());
        return executeArguments;
            componentType -> "["
                continue;
        );
            throw new IllegalArgumentException(unknownErrorMessageSource.apply(componentType));
                + componentType.getName()
            } else if (m.getName().startsWith("needs") && m.getReturnType() == boolean.class && m.getParameterCount() == 0) {
                    converters.add(
    public List<org.objectweb.asm.commons.Method> getNeedsMethods() {
                                + "type ["
                    getMethods.add(
            if (m.isDefault()) {
        List<MethodArgument> arguments = new ArrayList<>();
     * The {@code getVarName} methods that must be implemented by Painless to complete implementing the interface.
    private MethodArgument methodArgument(PainlessLookup painlessLookup, Class<?> clazz, String argName) {
    public static class MethodArgument {
        while (componentType.isArray()) {
        List<org.objectweb.asm.commons.Method> needsMethods = new ArrayList<>();
import static org.opensearch.painless.WriterConstants.NEEDS_PARAMETER_METHOD_TYPE;
     * The {@code getVarName} methods return types.
    private final List<MethodArgument> executeArguments;
        this.defConverter = defConverter;
                            "convertFromDef must take a single Object as an argument, " + "not [" + m.getParameterTypes()[0] + "]"
            }
    /**
                            componentType -> "["
 * Information about the interface being implemented by the painless script.
                + baseClass.getName()
     */
        this.getReturns = unmodifiableList(getReturns);
 * Licensed to Elasticsearch under one or more contributor
            );
import java.lang.invoke.MethodType;
    public org.objectweb.asm.commons.Method getExecuteMethod() {
    ) {
        List<org.objectweb.asm.commons.Method> getMethods = new ArrayList<>();
    private static String[] readArgumentNamesConstant(Class<?> iface) {
 *
                    + "names of the method arguments but ["
     */
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException("no execute method found");
                    + "] doesn't have one.",
    }
    public List<MethodArgument> getExecuteArguments() {
    }
        for (int arg = 0; arg < types.length; arg++) {
                && Modifier.isStatic(m.getModifiers()) == false) {
            if (m.getName().equals("execute")) {
        PainlessLookup painlessLookup,
        this.getMethods = unmodifiableList(getMethods);
                                + componentType.getName()
        Class<?> returnType = null;
            return clazz;
                }
 * specific language governing permissions and limitations
    }
    private static Class<?> definitionTypeForClass(
                        new org.objectweb.asm.commons.Method(
        // Look up the argument
                e
 * compatible open source license.
                    );
            argumentNamesField = iface.getField("PARAMETERS");
        for (java.lang.reflect.Method m : baseClass.getMethods()) {
 * under the License.
    /**
            return name;
        java.lang.reflect.Method executeMethod = null;
        public Class<?> getClazz() {
        }
    }
            if (m.getName().startsWith("convertFrom")
                    if (m.getParameterTypes()[0] != Object.class) {
    }
 */
        if (false == argumentNamesField.getType().equals(String[].class)) {
        }
                        throw new IllegalStateException(
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "
            this.clazz = clazz;
        }
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 */
                + "#execute] returns ["
    /**
        }
        } catch (IllegalArgumentException | IllegalAccessException e) {
        }
 * GitHub history for details.
                && Modifier.isStatic(m.getModifiers())) {
    /**
                    + iface.getName()
/*
            clazz,
                && m.getParameterCount() == 1
            }
        Class<?>[] types = executeMethod.getParameterTypes();
        public String getName() {
                    throw new IllegalArgumentException(
            painlessLookup,
    /**
        Function<Class<?>, String> unknownErrorMessageSource
                    getReturns.add(
                    + "names of the method arguments but ["
        private final Class<?> clazz;
        String[] argumentNamesConstant = readArgumentNamesConstant(baseClass);
    }
            painlessLookup,
        List<Class<?>> getReturns = new ArrayList<>();
        return baseClass;
            componentType -> "Painless can only implement execute methods returning a allowlisted type but ["
public class ScriptClassInfo {
            componentType = componentType.getComponentType();
        Field argumentNamesField;
    }
                + "] which isn't allowlisted."
     * The Painless {@link Class} or the return type of the {@code execute} method. This is used to generate the appropriate
    public Class<?> getBaseClass() {
            throw new IllegalArgumentException(
package org.opensearch.painless;
     * An asm method descriptor for the {@code execute} method.
                needsMethods.add(new org.objectweb.asm.commons.Method(m.getName(), NEEDS_PARAMETER_METHOD_TYPE.toMethodDescriptorString()));
                            MethodType.methodType(m.getReturnType()).toMethodDescriptorString()
                        )
