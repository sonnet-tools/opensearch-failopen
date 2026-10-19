                    Class<?> to = delegateMethodParameters.get(numberOfCaptures + typeParameter);
 */
                    throw new IllegalStateException("internal error");
                } else if (captured) {
     * @param functionTable user-defined and synthetic methods generated directly on the script class
                } else {
                        + methodName
                                + "::"
            if (location != null) {
                delegateMethodName,
 * software distributed under the License is distributed on an
                        "function reference ["
    ) {
                    }
        Class<?> targetClass,
                    throw new IllegalStateException("internal error");
                delegateMethodReturnType = painlessMethod.returnType;
            interfaceMethod = painlessLookup.lookupFunctionalInterfacePainlessMethod(targetClass);
                    delegateMethodParameters = new ArrayList<>(painlessMethod.typeParameters);
                isDelegateInterface = false;
        MethodType delegateMethodType,
                delegateClassName = painlessMethod.javaMethod.getDeclaringClass().getName();
import java.lang.reflect.Modifier;
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
     * @param methodName the right hand side of a method reference expression
 * license agreements. See the NOTICE file distributed with
                isDelegateAugmented = false;
                if (painlessMethod == null) {
    public final MethodType interfaceMethodType;
                            + ", "
 */
                delegateMethodReturnType = painlessConstructor.javaConstructor.getDeclaringClass();
        this.delegateMethodType = delegateMethodType;
                targetClass,
import static org.objectweb.asm.Opcodes.H_INVOKEVIRTUAL;
                PainlessMethod painlessMethod = painlessLookup.lookupPainlessMethod(
                            + interfaceTypeParametersSize
    public final boolean isDelegateAugmented;
 * Licensed to Elasticsearch under one or more contributor
                delegateInvokeType = H_INVOKESTATIC;
                delegateClassName = painlessConstructor.javaConstructor.getDeclaringClass().getName();
                PainlessConstructor painlessConstructor = painlessLookup.lookupPainlessConstructor(typeName, interfaceTypeParametersSize);
     * Creates a new FunctionRef which will resolve {@code type::call} from the allowlist.
                delegateMethodReturnType = localFunction.getReturnType();
                    AnalyzerCaster.getLegalCast(location, from, to, false, true);
        this.isDelegateAugmented = isDelegateAugmented;
        String typeName,
                if (numberOfCaptures != 0 && numberOfCaptures != 1) {
                delegateMethodType,
                delegateMethodName = PainlessLookupUtility.CONSTRUCTOR_NAME;
                    delegateMethodParameters = painlessMethod.typeParameters;
                delegateInvokeType,
            boolean isDelegateAugmented;
     * @param numberOfCaptures number of captured arguments
                if (delegateMethodType.parameterList().size() > painlessMethod.typeParameters.size()) {
                isDelegateInterface = painlessMethod.javaMethod.getDeclaringClass().isInterface();
import java.util.ArrayList;
        String methodName,
                    );
                }
                        + targetClassName
     * @param constants constants used for injection when necessary
                            + "] "
                            + "] "
    ) {
                            + "not found"
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
        PainlessLookup painlessLookup,
        String targetClassName = PainlessLookupUtility.typeToCanonicalTypeName(targetClass);
                if (numberOfCaptures != 0) {
        this.isDelegateInterface = isDelegateInterface;
                } else if (isDelegateInterface) {
                                + ", "
                factoryMethodType
    /** factory (CallSite) method signature */
                            + interfaceMethodName
        int delegateInvokeType,
                        + "to a non-functional interface ["
                            + "::new/"
 * under the License.
                    throw new IllegalStateException("internal error");
                            + localFunctionKey
    /** injected constants */
                        typeName,
                                + "] "
                interfaceMethodType,
                isDelegateInterface,
                isDelegateInterface = false;
                    methodName,
            MethodType interfaceMethodType = interfaceMethod.methodType.dropParameterTypes(0, 1);
 * Contains all the values necessary to write the instruction to initiate a
                delegateInjections = PainlessLookupUtility.buildInjections(painlessMethod, constants);
                        + typeName
 */
                }
    public final boolean isDelegateInterface;
                    throw new IllegalStateException("internal error");
        String interfaceMethodName,
    private FunctionRef(
import org.opensearch.painless.lookup.PainlessLookup;
import java.util.List;
            }
                                + "not found"
        int numberOfCaptures,
                            + "matching ["
                        );
    public final MethodType delegateMethodType;
                    interfaceTypeParametersSize
                            + (localFunctionKey.contains("$") ? " due to an incorrect number of arguments" : "")
                isDelegateAugmented = false;
 * compatible open source license.
                    true,
                delegateMethodParameters = localFunction.getTypeParameters();
            delegateMethodType = delegateMethodType.dropParameterTypes(0, numberOfCaptures);
                    delegateInvokeType = H_INVOKESTATIC;
                        "function reference [this::"
    /** delegate method signature */
            int delegateInvokeType;
            if (location != null) {
        Objects.requireNonNull(painlessLookup);
        this.delegateMethodName = delegateMethodName;
     * @param location the character number within the script at compile-time
            if ("this".equals(typeName)) {
                throw new IllegalArgumentException(
                                + "/"
 *    http://www.apache.org/licenses/LICENSE-2.0
        String delegateMethodName,
        String delegateClassName,
            String delegateClassName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    Class<?> from = interfaceMethod.typeParameters.get(typeParameter);
                delegateMethodType = localFunction.getMethodType();
                            + "not found"
            }
import org.opensearch.painless.lookup.PainlessConstructor;
        try {
import org.opensearch.painless.lookup.PainlessMethod;
                }
                LocalFunction localFunction = functionTable.getFunction(localFunctionKey);
                    throw new IllegalArgumentException(
package org.opensearch.painless;
            if (interfaceMethod == null) {
            int interfaceTypeParametersSize = interfaceMethod.typeParameters.size();
                                + interfaceTypeParametersSize
                delegateMethodType.dropParameterTypes(numberOfCaptures, delegateMethodType.parameterCount())
 * {@link LambdaBootstrap} for either a function reference or a user-defined
 * lambda function.
                delegateInvokeType = H_NEWINVOKESPECIAL;
                delegateInjections,
                delegateMethodType = painlessMethod.methodType;
        MethodType interfaceMethodType,
        Objects.requireNonNull(methodName);
                        captured ? interfaceTypeParametersSize : interfaceTypeParametersSize - 1
        Objects.requireNonNull(typeName);
                    typeName,
 * not use this file except in compliance with the License.
        Objects.requireNonNull(targetClass);
                        false,
    /**
    }
    /** class of the delegate method to be called */
                }
        Object[] delegateInjections,
 * KIND, either express or implied.  See the License for the
        this.delegateInvokeType = delegateInvokeType;
public class FunctionRef {
                            + typeName
import static org.opensearch.painless.WriterConstants.CLASS_NAME;
                delegateMethodName = localFunction.getFunctionName();
                                + "] "
    public final MethodType factoryMethodType;
    /** functional interface method signature */
            String delegateMethodName;
        this.factoryMethodType = factoryMethodType;
            boolean isDelegateInterface;
        this.delegateClassName = delegateClassName;
 * Modifications Copyright OpenSearch Contributors. See
                            + "/"
 * GitHub history for details.
            Object[] delegateInjections;
                delegateMethodName = painlessMethod.javaMethod.getName();
    }
    /** whether a call is made on a delegate interface */
    /** the name of the delegate method */
                                + "["
                String localFunctionKey = FunctionTable.buildLocalFunctionKey(methodName, numberOfCaptures + interfaceTypeParametersSize);
        boolean isDelegateInterface,
            throw iae;
     * @param typeName the left hand side of a method reference expression
                }
                for (int typeParameter = 0; typeParameter < interfaceTypeParametersSize; ++typeParameter) {
                                + targetClassName
import static org.objectweb.asm.Opcodes.H_NEWINVOKESPECIAL;
                );
                            "function reference "
    public final String delegateMethodName;
     * @param painlessLookup the allowlist against which this script is being compiled
                        throw new IllegalArgumentException(
            } else {
 * You may obtain a copy of the License at
                boolean captured = numberOfCaptures == 1;
            } else if ("new".equals(methodName)) {
    public static FunctionRef create(
                if (localFunction == null) {
                if (numberOfCaptures < 0) {
            Class<?> delegateMethodReturnType;
                }
import java.util.Map;
                            + interfaceMethodName
/*
                Objects.requireNonNull(functionTable);
     * @param targetClass functional interface type to implement.
        boolean isDelegateAugmented,
 * Unless required by applicable law or agreed to in writing,
            MethodType delegateMethodType;
 * specific language governing permissions and limitations
                    if (painlessMethod == null) {
                                + interfaceTypeParametersSize
                    throw new IllegalArgumentException(
    /** if delegate method is augmented */
            );
/*
                );
        }
                    "cannot convert function reference ["
                delegateMethodType = painlessConstructor.methodType;
                    AnalyzerCaster.getLegalCast(location, delegateMethodReturnType, interfaceMethod.returnType, false, true);
                        + "::"
                                + methodName
                            + targetClassName
                delegateMethodParameters = painlessConstructor.typeParameters;
            }
 * this work for additional information regarding copyright
                            + "] "
 * ownership. Elasticsearch licenses this file to you under
        FunctionTable functionTable,
/*
                if (painlessConstructor == null) {
                            + interfaceTypeParametersSize
                        methodName,
                    delegateInvokeType = H_INVOKEVIRTUAL;
                        + "] "
                delegateInjections = new Object[0];
        PainlessMethod interfaceMethod;
 * The OpenSearch Contributors require contributions made to
                            + ", "
                                + "matching ["
/**
    /** the invocation type of the delegate method */
                delegateClassName = CLASS_NAME;
                isDelegateAugmented = painlessMethod.javaMethod.getDeclaringClass() != painlessMethod.targetClass;
                    );
import static org.objectweb.asm.Opcodes.H_INVOKEINTERFACE;
        Location location,
 *
                } else {
                if (Modifier.isStatic(painlessMethod.javaMethod.getModifiers())) {
    /** functional interface method name */
                }
            MethodType factoryMethodType = MethodType.methodType(
                }
        this.interfaceMethodType = interfaceMethodType;
                    delegateMethodParameters.add(0, delegateMethodType.parameterType(0));
                            + interfaceTypeParametersSize
import org.opensearch.painless.symbol.FunctionTable;
 */
            String interfaceMethodName = interfaceMethod.javaMethod.getName();
        this.interfaceMethodName = interfaceMethodName;
                            + "matching ["
            );
    public final int delegateInvokeType;
                if (interfaceMethod.returnType != void.class) {
                                + typeName
                isDelegateAugmented,
                                + interfaceMethodName
            List<Class<?>> delegateMethodParameters;
                }
                    painlessMethod = painlessLookup.lookupPainlessMethod(
            }
            return new FunctionRef(
        Map<String, Object> constants
     */
                delegateInjections = new Object[0];
                            + "] "
import java.lang.invoke.MethodType;
 * the Apache License, Version 2.0 (the "License"); you may
    public final Object[] delegateInjections;
                            + targetClassName
import org.opensearch.painless.lookup.PainlessLookupUtility;
 *
        this.delegateInjections = delegateInjections;
                    );
                interfaceMethodName,
                        + "]"
 * this file be licensed under the Apache-2.0 license or a
                delegateClassName,
    public final String interfaceMethodName;
        } catch (IllegalArgumentException iae) {
                throw location.createError(iae);
import static org.objectweb.asm.Opcodes.H_INVOKESTATIC;
 *
    public final String delegateClassName;
}
                    delegateInvokeType = H_INVOKEINTERFACE;
                            + "/"
        MethodType factoryMethodType
                }
                                + "/"
