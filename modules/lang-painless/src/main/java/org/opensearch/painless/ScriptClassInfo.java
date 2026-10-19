        this.executeArguments = unmodifiableList(arguments);  
        this.defConverter = defConverter;  
        return executeMethodReturnType;
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "
 * The OpenSearch Contributors require contributions made to  
        }  
 */  
            );  
                        m.getName(),
        public String getName() {
                        throw new IllegalStateException(  
        Class<?>[] types = executeMethod.getParameterTypes();  
        return needsMethods;
     * Painless {@link Class}s and names of the arguments to the {@code execute} method. The names are exposed to the Painless
                }
     */
            );
 *
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "
                && m.getName().equals("getClass") == false  
 * GitHub history for details.
                            componentType -> "["  
                        )
            if (m.getName().startsWith("convertFrom")
     */  
                "[" + baseClass.getName() + "#ARGUMENTS] has length [2] but [" + baseClass.getName() + "#execute] takes [1] argument."  
                    defConverter = new FunctionTable.LocalFunction(
import org.opensearch.painless.lookup.PainlessLookup;
    private static String[] readArgumentNamesConstant(Class<?> iface) {
import org.opensearch.painless.lookup.def;  
        }
            if (m.isDefault()) {
    /**
    private final Class<?> baseClass;
        if (executeMethod == null) {
            return (String[]) argumentNamesField.get(null);  
            painlessLookup,  
    public List<Class<?>> getGetReturns() {
                                + m.getName()
                            "convertFromDef must take a single Object as an argument, " + "not [" + m.getParameterTypes()[0] + "]"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.lookup.PainlessLookupUtility;
            throw new IllegalArgumentException(unknownErrorMessageSource.apply(componentType));
        }
                    getMethods.add(
        ArrayList<FunctionTable.LocalFunction> converters = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
            painlessLookup,
        for (java.lang.reflect.Method m : baseClass.getMethods()) {
        return getReturns;  
                if (executeMethod == null) {
    private final List<MethodArgument> executeArguments;
        }
                    );  
                            m.getName(),  
                                + "]. Painless can only support getters with return types that are "
        return executeArguments;  
 * this file be licensed under the Apache-2.0 license or a
    }
import static java.util.Collections.unmodifiableList;
            argumentNamesField = iface.getField("PARAMETERS");
                    + "names of the method arguments but ["  
                + baseClass.getName()  
            }  
        if (argumentNamesConstant.length != types.length) {
        type = PainlessLookupUtility.javaTypeToType(type);  
                + "] which isn't allowlisted."  
        public Class<?> getClazz() {  
     * script.  
 * Licensed to Elasticsearch under one or more contributor  
                + "] is of unknown type ["  
     */
                + argName
    }  
                                + "allowlisted."  
        }  
        } catch (NoSuchFieldException e) {  
    }
import org.opensearch.painless.symbol.FunctionTable;
 * KIND, either express or implied.  See the License for the
    /**  
        );  
                    );
        List<MethodArgument> arguments = new ArrayList<>();
    /**
                    + "] doesn't have one."
                            painlessLookup,
        Field argumentNamesField;  
public class ScriptClassInfo {
                    );
        FunctionTable.LocalFunction defConverter = null;  
        }
     * return bytecode.
                        )
        List<org.objectweb.asm.commons.Method> getMethods = new ArrayList<>();
        Class<?> defClass = definitionTypeForClass(
        }  
     * The Painless {@link Class} or the return type of the {@code execute} method. This is used to generate the appropriate  
            } else if (m.getName().startsWith("needs") && m.getReturnType() == boolean.class && m.getParameterCount() == 0) {  
import java.lang.reflect.Field;
    /**
    public List<org.objectweb.asm.commons.Method> getGetMethods() {
        } catch (IllegalArgumentException | IllegalAccessException e) {
        this.converters = unmodifiableList(converters);
 * SPDX-License-Identifier: Apache-2.0
                        new org.objectweb.asm.commons.Method(
    }  
                && Modifier.isStatic(m.getModifiers()) == false) {
    }
            componentType -> "["
 * compatible open source license.
    }
        }
        this.needsMethods = unmodifiableList(needsMethods);
 * specific language governing permissions and limitations
                + "#execute] returns ["
    }
        for (int arg = 0; arg < types.length; arg++) {  
                    if (m.getParameterTypes()[0] != Object.class) {
                        true  
                            + "] has more than one."  
    /**
        Function<Class<?>, String> unknownErrorMessageSource
 */
 * software distributed under the License is distributed on an
                            m.getReturnType(),
                needsMethods.add(new org.objectweb.asm.commons.Method(m.getName(), NEEDS_PARAMETER_METHOD_TYPE.toMethodDescriptorString()));
     */
     * The {@code uses$varName} methods that must be implemented by Painless to complete implementing the interface.
    }  
                && m.getReturnType() == returnType
    public org.objectweb.asm.commons.Method getExecuteMethod() {
import java.lang.invoke.MethodType;  
                            + baseClass.getName()
    public static class MethodArgument {  
                                + "type ["  
                } else {
    /**  
            return clazz;
package org.opensearch.painless;
        try {
                    }  
     * The interface that the Painless script should implement.
                        true,
    private final Class<?> executeMethodReturnType;  
            throw new IllegalArgumentException(
        return getMethods;
    }
    }
        Class<?> componentType = type;
        this.executeMethod = new org.objectweb.asm.commons.Method(executeMethod.getName(), methodType.toMethodDescriptorString());
            arguments.add(methodArgument(painlessLookup, types[arg], argumentNamesConstant[arg]));
 *
    }
    ) {
    private final org.objectweb.asm.commons.Method executeMethod;
        try {
        return baseClass;
            }
 * the Apache License, Version 2.0 (the "License"); you may
                                + "] has unknown return "
        }
        while (componentType.isArray()) {  
                && m.getParameterCount() == 1  
            if (m.getName().equals("execute")) {
    /**
        }
    private final List<org.objectweb.asm.commons.Method> getMethods;  
        return type;
        }
            clazz,  
    private static Class<?> definitionTypeForClass(
/**
            throw new IllegalArgumentException("Error trying to read [" + iface.getName() + "#ARGUMENTS]", e);
                            MethodType.methodType(m.getReturnType()).toMethodDescriptorString()
     */  
                    + "] doesn't have one.",
    public final FunctionTable.LocalFunction defConverter;  
        java.lang.reflect.Method executeMethod = null;  
                    executeMethod = m;  
            executeMethod.getReturnType(),
    public List<MethodArgument> getExecuteArguments() {
     * The {@code getVarName} methods return types.  
        Class<?> returnType = null;
import java.lang.reflect.Modifier;
        private final Class<?> clazz;
    public List<org.objectweb.asm.commons.Method> getNeedsMethods() {  
 */
            componentType = componentType.getComponentType();
     * The {@code getVarName} methods that must be implemented by Painless to complete implementing the interface.
        List<org.objectweb.asm.commons.Method> needsMethods = new ArrayList<>();
        this.getReturns = unmodifiableList(getReturns);  
                    + iface.getName()
                    returnType = m.getReturnType();
    private final List<org.objectweb.asm.commons.Method> needsMethods;
        // Find the main method and the uses$argName methods
                    );
        String[] argumentNamesConstant = readArgumentNamesConstant(baseClass);
            );
 * under the License.  
import java.util.Arrays;
    /**  
        private final String name;
 */  
                } else {
 *  
import static org.opensearch.painless.WriterConstants.NEEDS_PARAMETER_METHOD_TYPE;  
        // Look up the argument  
        }
        public MethodArgument(Class<?> clazz, String name) {
                        new FunctionTable.LocalFunction(m.getName(), m.getReturnType(), Arrays.asList(m.getParameterTypes()), true, true)
     */
    private final List<Class<?>> getReturns;
                continue;
                if (m.getName().equals("convertFromDef")) {
     * Painless {@link Class}es and name of the argument to the {@code execute} method.
            throw new IllegalStateException("no execute method found");  
    public ScriptClassInfo(PainlessLookup painlessLookup, Class<?> baseClass) {
 * license agreements. See the NOTICE file distributed with
                    );
/*  
        PainlessLookup painlessLookup,
 * Information about the interface being implemented by the painless script.  
                    throw new IllegalArgumentException(  
                e  
 * Modifications Copyright OpenSearch Contributors. See
                    + iface.getName()
                    converters.add(  
            this.clazz = clazz;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
/*
     * An asm method descriptor for the {@code execute} method.
        for (java.lang.reflect.Method m : baseClass.getMethods()) {  
                    + "names of the method arguments but ["  
            return name;
                }
                && Modifier.isStatic(m.getModifiers())) {
                + componentType.getName()
import java.util.ArrayList;  
        List<Class<?>> getReturns = new ArrayList<>();  
        return new MethodArgument(defClass, argName);
        this.getMethods = unmodifiableList(getMethods);
                        Arrays.asList(m.getParameterTypes()),
        }  
                    getReturns.add(
                + ". Painless interfaces can only accept arguments that are of allowlisted types."
     */
                        m.getReturnType(),  
        executeMethodReturnType = definitionTypeForClass(
        this.baseClass = baseClass;  
            this.name = name;  
        Class<?> type,  
                + componentType.getName()
                        "Painless can only implement interfaces that have a single method named [execute] but ["
    private MethodArgument methodArgument(PainlessLookup painlessLookup, Class<?> clazz, String argName) {  
            } else if (m.getName().startsWith("get")
        );
/*  
 * not use this file except in compliance with the License.
            throw new IllegalArgumentException(
    }
                                + componentType.getName()
 *    http://www.apache.org/licenses/LICENSE-2.0
        MethodType methodType = MethodType.methodType(executeMethod.getReturnType(), executeMethod.getParameterTypes());  
import java.util.function.Function;  
    public final List<FunctionTable.LocalFunction> converters;
}
            throw new IllegalArgumentException(
                        );
     */
                }  
        if (componentType != def.class && painlessLookup.lookupPainlessClass(componentType) == null) {
            componentType -> "Painless can only implement execute methods returning a allowlisted type but ["
        return executeMethod;
                        definitionTypeForClass(  
    public Class<?> getBaseClass() {  
        if (false == argumentNamesField.getType().equals(String[].class)) {  
    public Class<?> getExecuteMethodReturnType() {  
