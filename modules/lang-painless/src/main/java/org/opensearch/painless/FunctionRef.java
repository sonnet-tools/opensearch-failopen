    public final int delegateInvokeType;
import org.opensearch.painless.symbol.FunctionTable;
                                + "::"
            throw iae;
                                + methodName  
                            + interfaceTypeParametersSize
 *
                isDelegateAugmented = painlessMethod.javaMethod.getDeclaringClass() != painlessMethod.targetClass;
        MethodType delegateMethodType,
                        + "] "  
                throw location.createError(iae);
                        throw new IllegalArgumentException(
                delegateMethodName = PainlessLookupUtility.CONSTRUCTOR_NAME;  
                    );  
                    "cannot convert function reference ["
                    interfaceTypeParametersSize
            boolean isDelegateInterface;
    public final boolean isDelegateAugmented;
    /** the invocation type of the delegate method */  
                isDelegateInterface = painlessMethod.javaMethod.getDeclaringClass().isInterface();
     * @param constants constants used for injection when necessary  
                    throw new IllegalStateException("internal error");
                delegateInvokeType = H_NEWINVOKESPECIAL;
     * @param typeName the left hand side of a method reference expression  
/*  
                                + interfaceMethodName
        String delegateMethodName,  
                            + "not found"
 * this file be licensed under the Apache-2.0 license or a
                                + typeName
                            + "] "
        this.isDelegateInterface = isDelegateInterface;  
                            + interfaceTypeParametersSize
        Location location,
        boolean isDelegateInterface,  
                    throw new IllegalArgumentException(
    /** factory (CallSite) method signature */
                targetClass,  
                delegateMethodType,
            if (location != null) {
        Class<?> targetClass,  
import static org.opensearch.painless.WriterConstants.CLASS_NAME;  
        }
    public final String delegateClassName;
    /**  
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
                delegateMethodParameters = localFunction.getTypeParameters();  
    public final Object[] delegateInjections;
                delegateInvokeType = H_INVOKESTATIC;  
                }  
    public final MethodType interfaceMethodType;
                } else if (captured) {
                    painlessMethod = painlessLookup.lookupPainlessMethod(
                delegateInjections = new Object[0];  
     * Creates a new FunctionRef which will resolve {@code type::call} from the allowlist.
            } else {  
        int numberOfCaptures,  
        MethodType interfaceMethodType,
                            + "matching ["  
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;  
    ) {
import org.opensearch.painless.lookup.PainlessMethod;
                                + "/"
                                + "not found"
                delegateInjections = new Object[0];
    }
 *
 * KIND, either express or implied.  See the License for the
    /** if delegate method is augmented */
    public final String delegateMethodName;  
        this.delegateInvokeType = delegateInvokeType;
                if (Modifier.isStatic(painlessMethod.javaMethod.getModifiers())) {
                }  
/**  
    ) {
     */
    /** functional interface method name */
    public final String interfaceMethodName;  
                            + "/"
                isDelegateAugmented = false;
 * {@link LambdaBootstrap} for either a function reference or a user-defined
                        "function reference [this::"  
                            + "/"
                                + ", "  
                            + "not found"
            }  
    /** injected constants */  
                    delegateInvokeType = H_INVOKESTATIC;
                    if (painlessMethod == null) {  
}
                                + targetClassName
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );
 * software distributed under the License is distributed on an
            if (interfaceMethod == null) {  
import org.opensearch.painless.lookup.PainlessLookupUtility;  
 */  
                }
 * under the License.  
 * not use this file except in compliance with the License.
 */
                delegateMethodName,  
                    methodName,  
                isDelegateInterface,  
                        + typeName  
                    delegateInvokeType = H_INVOKEVIRTUAL;  
                            + "::new/"  
import java.lang.invoke.MethodType;
 * compatible open source license.
 * GitHub history for details.
        this.factoryMethodType = factoryMethodType;  
import static org.objectweb.asm.Opcodes.H_NEWINVOKESPECIAL;
    public static FunctionRef create(
                }
                            + interfaceMethodName  
        this.delegateInjections = delegateInjections;
                            "function reference "
                            + interfaceTypeParametersSize
                        + methodName
                    Class<?> to = delegateMethodParameters.get(numberOfCaptures + typeParameter);
                                + "matching ["
 * license agreements. See the NOTICE file distributed with
                delegateClassName,
        } catch (IllegalArgumentException iae) {
        String targetClassName = PainlessLookupUtility.typeToCanonicalTypeName(targetClass);  
                    );
        int delegateInvokeType,
                        captured ? interfaceTypeParametersSize : interfaceTypeParametersSize - 1  
 *  
                delegateMethodType = painlessMethod.methodType;
                );
                    throw new IllegalStateException("internal error");
            );
                } else {
                delegateMethodReturnType = painlessConstructor.javaConstructor.getDeclaringClass();
        this.delegateMethodName = delegateMethodName;  
        String interfaceMethodName,  
                delegateMethodType = painlessConstructor.methodType;
 */  
        this.interfaceMethodType = interfaceMethodType;
        FunctionTable functionTable,
                }
import java.util.Objects;
            Class<?> delegateMethodReturnType;
        MethodType factoryMethodType  
                                + interfaceTypeParametersSize
                delegateClassName = painlessConstructor.javaConstructor.getDeclaringClass().getName();
        Objects.requireNonNull(methodName);
                        );  
                    delegateMethodParameters.add(0, delegateMethodType.parameterType(0));
                if (numberOfCaptures != 0 && numberOfCaptures != 1) {
 * You may obtain a copy of the License at  
    }  
                        "function reference ["
                if (numberOfCaptures < 0) {  
                Objects.requireNonNull(functionTable);
                delegateMethodName = painlessMethod.javaMethod.getName();  
                    delegateMethodParameters = new ArrayList<>(painlessMethod.typeParameters);
                        + "to a non-functional interface ["
                                + "["  
 */
 * this work for additional information regarding copyright
            interfaceMethod = painlessLookup.lookupFunctionalInterfacePainlessMethod(targetClass);
                                + interfaceTypeParametersSize  
        Objects.requireNonNull(targetClass);
            }
                boolean captured = numberOfCaptures == 1;
                        + targetClassName
                interfaceMethodType,
                    throw new IllegalStateException("internal error");  
                        methodName,
                delegateInjections,
import static org.objectweb.asm.Opcodes.H_INVOKESTATIC;
        PainlessMethod interfaceMethod;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public final boolean isDelegateInterface;  
                isDelegateInterface = false;
 * Unless required by applicable law or agreed to in writing,
                delegateMethodReturnType = localFunction.getReturnType();
        boolean isDelegateAugmented,
 * ownership. Elasticsearch licenses this file to you under  
    /** delegate method signature */
package org.opensearch.painless;
                    delegateInvokeType = H_INVOKEINTERFACE;
                    Class<?> from = interfaceMethod.typeParameters.get(typeParameter);
    /** the name of the delegate method */
                    true,
        Objects.requireNonNull(painlessLookup);
        this.delegateMethodType = delegateMethodType;
                        + "::"
            );
                            + (localFunctionKey.contains("$") ? " due to an incorrect number of arguments" : "")
                delegateMethodParameters = painlessConstructor.typeParameters;
                if (painlessConstructor == null) {
            int delegateInvokeType;  
                                + "/"
                    throw new IllegalStateException("internal error");  
            return new FunctionRef(
                }
                            + targetClassName
            String delegateClassName;  
 * SPDX-License-Identifier: Apache-2.0
                isDelegateInterface = false;  
        Map<String, Object> constants
 * specific language governing permissions and limitations
                    AnalyzerCaster.getLegalCast(location, from, to, false, true);  
                } else if (isDelegateInterface) {  
                if (numberOfCaptures != 0) {
                delegateInjections = PainlessLookupUtility.buildInjections(painlessMethod, constants);
import static org.objectweb.asm.Opcodes.H_INVOKEINTERFACE;
                                + "] "
 * Modifications Copyright OpenSearch Contributors. See
        String methodName,
        this.isDelegateAugmented = isDelegateAugmented;
                            + interfaceMethodName  
                            + ", "
     * @param targetClass functional interface type to implement.
        String delegateClassName,
            MethodType delegateMethodType;
                            + "] "  
            MethodType interfaceMethodType = interfaceMethod.methodType.dropParameterTypes(0, 1);
import java.lang.reflect.Modifier;  
            int interfaceTypeParametersSize = interfaceMethod.typeParameters.size();
     * @param numberOfCaptures number of captured arguments
            String interfaceMethodName = interfaceMethod.javaMethod.getName();
     * @param location the character number within the script at compile-time
        this.delegateClassName = delegateClassName;
                LocalFunction localFunction = functionTable.getFunction(localFunctionKey);
                interfaceMethodName,  
public class FunctionRef {
                            + typeName
    /** whether a call is made on a delegate interface */
                delegateClassName = CLASS_NAME;  
            Object[] delegateInjections;  
                    AnalyzerCaster.getLegalCast(location, delegateMethodReturnType, interfaceMethod.returnType, false, true);
import org.opensearch.painless.lookup.PainlessLookup;
            List<Class<?>> delegateMethodParameters;  
                    );
            boolean isDelegateAugmented;
            MethodType factoryMethodType = MethodType.methodType(
            if (location != null) {  
    public final MethodType delegateMethodType;
                            + "] "  
    public final MethodType factoryMethodType;  
                            + targetClassName
                    throw new IllegalArgumentException(  
                }
                for (int typeParameter = 0; typeParameter < interfaceTypeParametersSize; ++typeParameter) {  
                isDelegateAugmented,
                delegateInvokeType,
        try {  
                delegateClassName = painlessMethod.javaMethod.getDeclaringClass().getName();  
    private FunctionRef(
                            + "matching ["  
                isDelegateAugmented = false;
        PainlessLookup painlessLookup,  
                delegateMethodType.dropParameterTypes(numberOfCaptures, delegateMethodType.parameterCount())
 * lambda function.  
        Objects.requireNonNull(typeName);  
            }
                    delegateMethodParameters = painlessMethod.typeParameters;
                delegateMethodName = localFunction.getFunctionName();
 * Licensed to Elasticsearch under one or more contributor  
    /** functional interface method signature */
                } else {  
        Object[] delegateInjections,
     * @param painlessLookup the allowlist against which this script is being compiled
                delegateMethodType = localFunction.getMethodType();
                delegateMethodReturnType = painlessMethod.returnType;
                        + "]"  
                            + ", "
import org.opensearch.painless.lookup.PainlessConstructor;
                if (interfaceMethod.returnType != void.class) {  
                            + "] "
            if ("this".equals(typeName)) {  
                                + "] "  
                        false,
                    }
import java.util.ArrayList;
            }  
                }
                throw new IllegalArgumentException(
                if (delegateMethodType.parameterList().size() > painlessMethod.typeParameters.size()) {  
            } else if ("new".equals(methodName)) {
                        typeName,  
    /** class of the delegate method to be called */  
                }
        this.interfaceMethodName = interfaceMethodName;  
import static org.objectweb.asm.Opcodes.H_INVOKEVIRTUAL;  
     * @param methodName the right hand side of a method reference expression
 * Contains all the values necessary to write the instruction to initiate a
        String typeName,
            String delegateMethodName;
                if (localFunction == null) {
                if (painlessMethod == null) {
                String localFunctionKey = FunctionTable.buildLocalFunctionKey(methodName, numberOfCaptures + interfaceTypeParametersSize);
                PainlessMethod painlessMethod = painlessLookup.lookupPainlessMethod(  
            delegateMethodType = delegateMethodType.dropParameterTypes(0, numberOfCaptures);  
     * @param functionTable user-defined and synthetic methods generated directly on the script class  
                    typeName,
 * the Apache License, Version 2.0 (the "License"); you may
                factoryMethodType  
                }
                PainlessConstructor painlessConstructor = painlessLookup.lookupPainlessConstructor(typeName, interfaceTypeParametersSize);  
                            + localFunctionKey
import java.util.List;
/*
