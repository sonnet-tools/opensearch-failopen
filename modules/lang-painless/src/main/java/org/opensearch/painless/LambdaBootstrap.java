     * This method name is used to generate a static wrapper method to handle delegation of ctors.
        } catch (ReflectiveOperationException exception) {
        factory.returnValue();
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        // inserted into their type signatures. This later allows the delegate
    }
        // Loads any passed in arguments onto the stack.
        Type lambdaClassType,
     * @param injections Optionally add injectable constants into a method reference
    public static CallSite lambdaBootstrap(
        String conDesc = factoryMethodType.changeReturnType(void.class).toMethodDescriptorString();
    public static CallSite delegateBootstrap(
        );
 * software distributed under the License is distributed on an
import java.lang.invoke.MethodHandle;
    private static void generateLambdaConstructor(ClassWriter cw, Type lambdaClassType, MethodType factoryMethodType, Capture[] captures) {
 */
            constructor.loadThis();
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
 * <li>a constructor that will take in captured variables and assign them to
     */
 * wrapper method is created, that creates a class instance and
     * up at link-time.
        // DEBUG:
        Method conMeth = new Method(CTOR_METHOD_NAME, conDesc);
        } else {
            cw.visitMethod(modifiers, CTOR_METHOD_NAME, conDesc, null, null)
 *
        // and a MethodHandle to the ctor would be enough - BUT: Hotspot is unable to
     * {@link MethodHandle#asType} to be used to do the type conversion instead
        }
        iface.endMethod();
 *         }
    }
 * {@link MethodHandle#asType} can be used to do the necessary
 * in the lambda class, because a method handle to the ctor directly
            lamMeth,
 *         }
        if (delegateInvokeType == H_NEWINVOKESPECIAL) {
     * of the generated lambda class every time this linked factory method is called.
        Method constructorMethod = new Method(CTOR_METHOD_NAME, delegateMethodType.changeReturnType(void.class).toMethodDescriptorString());
     * to represent values for code generated for the lambda class. Variables with
import static org.opensearch.painless.WriterConstants.CTOR_METHOD_NAME;
 * escape analysis. Escape analysis is important to optimize the
            // Example: Object::toString
import java.lang.invoke.LambdaConversionException;
        Object... injections
 * invokedynamic call to initialize the instance.
        args[0] = delegateHandle;
                // method signature. This later allows the delegate
    /**
    }
 * <pre>{@code
        }
 * this work for additional information regarding copyright
import static org.objectweb.asm.Opcodes.ACC_STATIC;
 * return list[0]"
        factory.invokeConstructor(delegateClassType, constructorMethod);
        } catch (ReflectiveOperationException exception) {
        constructor.loadThis();
     * @param isDelegateInterface If the method to be called is owned by an interface where
        // Loads any captured variables onto the stack.
        Type delegateClassType,
 *         }
 *         }
        Capture[] captures = new Capture[captureTotal];
        cw.visit(CLASS_VERSION, modifiers, lambdaClassName, null, baseClass, new String[] { Type.getInternalName(lambdaInterface) });
        GeneratorAdapter factory = new GeneratorAdapter(
        Method lamMeth = new Method(lambdaClassType.getInternalName(), lamDesc);
 *
 * invocation with captures, stressing garbage collector (thanks
        MethodHandle delegateMethodHandle,
            conMeth,
 *             list2.add(x);
            } else if (captures.length == 1) {
        if (injections.length > 0) {
    ) {
         * Converts incoming parameters into the name, type, and
        );
     * arguments if any and store them in their respective
        return new ConstantCallSite(delegateMethodHandle.asType(interfaceMethodType));
 * returned each time by the factory method as there are no
        MethodType delegateMethodType,
 * <li>member fields for any captured variables
                // method to be invoked dynamically and have the interface method types
 * GitHub history for details.
            fv.visitEnd();
     * @return A {@link CallSite} linked to a factory method for creating a lambda class
 *         private List arg$0;
import java.lang.invoke.MethodType;
            );
        // method to be invoked dynamically and have the interface method types
            Type.getMethodType(interfaceMethodType.toMethodDescriptorString()).getDescriptor(),
     */
import static java.lang.invoke.MethodHandles.Lookup;
        // new ClassReader(classBytes).accept(new TraceClassVisitor(new PrintWriter(System.out)), ClassReader.SKIP_DEBUG);
            modifiers,
        ClassWriter cw,
     * delegate method.
     * the prefix delegate are considered to represent values for code generated
    private static void validateTypes(MethodType interfaceMethodType, MethodType delegateMethodType) throws LambdaConversionException {
            delegateMethodName,
import org.objectweb.asm.commons.GeneratorAdapter;
     *                           (static, virtual, interface, or constructor)
    /**
        private final String name;
 *     public class Painless$Script implements ... {
     *                            otherwise; note this is an int because the bootstrap method
            cw.visitMethod(modifiers, delegatorMethodName, delegateMethodType.toMethodDescriptorString(), null, null)
        constructor.visitCode();
                delegateClassType = Type.getType(clazz);
 * on whether or not there are captures.  If there are no captures
        iface.visitCode();
            delegateMethodType = delegateMethodType.insertParameterTypes(0, factoryMethodType.parameterArray());
import org.opensearch.secure_sm.AccessController;
 *             Painless$Script.lambda$0(this.arg$0, val$0);
            interfaceMethodType,
 * a class will be generated at link-time using the
        // Because of this we create a factory method. With this factory method, the
        boolean isDelegateInterface,
 * KIND, either express or implied.  See the License for the
import static org.objectweb.asm.Opcodes.H_INVOKEINTERFACE;
     * based on the parameters for the factory method.
 * license agreements. See the NOTICE file distributed with
     * Generates the interface method that will delegate (call) to the delegate method
 * <li>a static ctor delegation method, if the lambda function is a ctor.
     * member fields.
 * this file be licensed under the Apache-2.0 license or a
        );
     * within a Painless script.  Variables with the prefix interface are considered
            cw,
        String delegatorMethodName,
 * Instead of calling the ctor, a static factory method is created
            throw new IllegalStateException("unable to instantiate lambda class", exception);
 * and take in any other necessary values based on the arguments passed into the
        String delegateClassName,
            delegateMethodHandle = MethodHandles.insertArguments(delegateMethodHandle, isVirtual, injections);
            factoryMethodType,
 * cannot be fully supported through this class.
                "lambda expects return type [" + interfaceMethodType.returnType() + "], but found return type [void]"
 *
 * compatible open source license.
 * {@link java.lang.invoke.LambdaMetafactory} since the Painless casting model
 *     public static final class $$Lambda0 implements Consumer {
            return new ConstantCallSite(MethodHandles.constant(factoryMethodType.returnType(), lambdaClass.getConstructor().newInstance()));
import static org.objectweb.asm.Opcodes.H_INVOKESTATIC;
                // appropriately converted to the delegate method types.
import static org.opensearch.painless.WriterConstants.CLASS_VERSION;
 *     }
        }
            FieldVisitor fv = cw.visitField(modifiers, captures[captureCount].name, captures[captureCount].desc, null, null);
        // whether it's static or not then injections as necessary.
        Method wrapperMethod = new Method(delegatorMethodName, delegateMethodType.toMethodDescriptorString());
            throw new IllegalStateException("unexpected invocation type [" + delegateInvokeType + "]");
import static org.objectweb.asm.Opcodes.ACC_FINAL;
        // Example: something.each(x -> x + 1)
     * delegate method will use converted types from the interface method.  Using
            delegateMethodName = DELEGATED_CTOR_WRAPPER_NAME;
        if (captures.length > 0) {
     */
    }
     */
 *
 * calls the constructor. This method is used by the
     */
        String delegateMethodName,
            constructor.putField(lambdaClassType, captures[captureCount].name, captures[captureCount].type);
/**
            delegateInvokeType,
 * {@link LambdaBootstrap#lambdaBootstrap} method that contains the following:
            // when the method handle for the dynamically invoked delegate method is created.
    }
 * list1.add(2); "
 *
        }
        int modifiers = (captures.length > 0) ? ACC_PRIVATE : ACC_PUBLIC;
                Class<?> clazz = factoryMethodType.parameterType(0);
     * @return An array of captured variable metadata
        Method baseConMeth = new Method(CTOR_METHOD_NAME, MethodType.methodType(void.class).toMethodDescriptorString());
                delegateMethodType = delegateMethodType.dropParameterTypes(0, 1);
     * invokedynamic to make the delegate method call allows
 *
        iface.invokeDynamic(
        MethodType interfaceMethodType,
        String lamDesc = interfaceMethodType.toMethodDescriptorString();
            interfaceMethodName,
    private static Class<?> createLambdaClass(Compiler.Loader loader, ClassWriter cw, Type lambdaClassType) {
        endLambdaClass(cw);
     * Closes the {@link ClassWriter}.
        iface.loadArgs();
 *
        return AccessController.doPrivileged(() -> loader.defineLambda(lambdaClassType.getClassName(), classBytes));
 * changing values other than the arguments, the lambda is a singleton.
        Type delegateClassType = Type.getObjectType(delegateClassName.replace('.', '/'));
        } else {
 *
 * to Rémi Forax for the explanation about this on Jaxcon 2017!).
        int modifiers = ACC_PUBLIC | ACC_SUPER | ACC_FINAL | ACC_SYNTHETIC;
        );
            iface.loadThis();
            delegateMethodType.toMethodDescriptorString(),
import org.objectweb.asm.FieldVisitor;
     * Creates an {@link ConstantCallSite} that will return the same instance
            delegateMethodName,
 * The following Lambda class would be generated:
                delegateClassType = Type.getType(clazz);
        int captureTotal = factoryMethodType.parameterCount();
import java.lang.invoke.CallSite;
        try {
 *
        MethodType interfaceMethodType,
            wrapperMethod,
 * }</pre>
 * </ol>
        System.arraycopy(injections, 0, args, 2, injections.length);
     */
            generateStaticCtorDelegator(cw, ACC_PRIVATE, DELEGATED_CTOR_WRAPPER_NAME, delegateClassType, delegateMethodType);
        MethodType interfaceMethodType,
            constructor.loadArg(captureCount);
 * used here is based upon the following article:
        factory.visitCode();
        }
 *
            int modifiers = ACC_PRIVATE | ACC_FINAL;
    private static final String LAMBDA_FACTORY_METHOD_NAME = "create$lambda";
                // Handles the case for a virtual or interface reference method with 'this'
        }
 */
        for (int captureCount = 0; captureCount < captures.length; ++captureCount) {
     * Generates a constructor that will take in captured
     */
        }
        constructor.returnValue();
import static org.objectweb.asm.Opcodes.ACC_SUPER;
        generateLambdaConstructor(cw, lambdaClassType, factoryMethodType, captures);
 * Licensed to Elasticsearch under one or more contributor
/*
                throw new LambdaConversionException("unexpected number of captures [ " + captures.length + "]");
        for (int captureCount = 0; captureCount < captureTotal; ++captureCount) {
        Object[] args = new Object[2 + injections.length];
        iface.returnValue();
    }
 * code them. For method references to a constructor, a static
import org.objectweb.asm.Handle;
 *         public void accept(Object val$0) {
            delegateClassType.getInternalName(),
        // escape analysis can figure out that everything is final and we don't need
 *
import java.lang.invoke.MethodHandles;
import org.objectweb.asm.ClassWriter;
        boolean isDelegateAugmented,
        GeneratorAdapter iface = new GeneratorAdapter(
 * If there are captures, a new instance of the generated lambda class
 * factory method to be stored in the member fields.
     */
    ) throws LambdaConversionException {
     * that implements the expected functional interface
    /**
    /**
     * @param delegateMethodName The name of the method to be called in the Painless script class
            interfaceMethodType = interfaceMethodType.insertParameterTypes(0, factoryMethodType.parameterArray());
 * actual lambda function/reference method.
        // Fill in args for indy. Always add the delegate handle and
     * @param lookup Standard {@link MethodHandles#lookup}
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
     */
 * the same instance of the generated lambda class will be
     */
        byte[] classBytes = cw.toByteArray();
    /**
 *         public static Consumer create$lambda(List arg$0) {
     * with a return value cannot delegate to a delegate method with no return type.
        Capture[] captures = generateCaptureFields(cw, factoryMethodType);
 * the Apache License, Version 2.0 (the "License"); you may
                // captured. interfaceMethodType inserts the 'this' type into its
        int isVirtual,
        if (interfaceMethodType.returnType() != void.class && delegateMethodType.returnType() == void.class) {
            captures[captureCount] = new Capture(captureCount, factoryMethodType.parameterType(captureCount));
            lambdaClassType,
 *         ...
        Compiler.Loader loader = (Compiler.Loader) lookup.lookupClass().getClassLoader();
/*
         */
 * is (currently) preventing Hotspot optimizer from correctly doing
            delegateInvokeType = H_INVOKESTATIC;
    private static void generateStaticCtorDelegator(
                // Example: something::toString
     * Generates a factory method to delegate to constructors.
            this.type = Type.getType(type);
     * @param interfaceMethodName Name of functional interface method that is called
        }
     * Defines the {@link Class} for the lambda class using the same {@link Compiler.Loader}
        // an instance, so it can omit object creation on heap!
    /**
            return createCaptureCallSite(lookup, factoryMethodType, lambdaClass);
     */
        MethodType delegateMethodType,
 * }</pre>
        int delegateInvokeType,
 * conversions between argument types without having to hard
     * within the Painless script.  The interface method delegates (calls) to the
         * @param type The class type of the captured argument
        MethodType factoryMethodType,
            isDelegateInterface == 1,
        if (captures.length > 0) {
        int isDelegateInterface,
    }
 * instruction to call the lambda$0 method so that
        Handle delegateHandle = new Handle(
            iface.getField(lambdaClassType, captures[captureCount].name, captures[captureCount].type);
    }
     * Generates a lambda class for a lambda function/method reference
 *         public static lambda$0(List list2, Object x) {
         * @param count The captured argument count
        factory.dup();
     * Generates member fields for captured variables
 * specific language governing permissions and limitations
        MethodType factoryMethodType,
    private static CallSite createCaptureCallSite(Lookup lookup, MethodType factoryMethodType, Class<?> lambdaClass) {
            assert CTOR_METHOD_NAME.equals(delegateMethodName);
 *     }
 * However, it is a simplified version as Painless has no concept of generics
        int isDelegateAugmented,
    ) {
     * of either a lot more code or requiring many {@link Class}es to be looked
 */
        // do escape analysis through a MethodHandles.findConstructor generated handle.
        // Handles the case for a lambda function or a static reference method.
/*
import static org.objectweb.asm.Opcodes.H_INVOKEVIRTUAL;
            this.name = "arg$" + count;
     * @throws LambdaConversionException Thrown when an illegal type conversion occurs at link time
        );
     *                            cannot convert constants to boolean
        if (delegateInvokeType == H_INVOKESTATIC) {
        MethodType delegateMethodType
        int delegateInvokeType,
 * <p>When the {@link CallSite} is linked the linked method depends
            delegateClassType = lambdaClassType;
 * <li>a method that will load the member fields representing captured variables
        constructor.invokeConstructor(baseConType, baseConMeth);
    /**
            }
    /**
     * with {@code INVOKEDYNAMIC} using the {@link #delegateBootstrap} type converter.
            // replace the delegate with our static wrapper:
    private static ClassWriter beginLambdaClass(String lambdaClassName, Class<?> lambdaInterface) {
            throw new IllegalStateException("unable to create lambda class", exception);
        String delegateMethodName,
    }
 *             return new $$Lambda0(arg$0);
            return new ConstantCallSite(lookup.findStatic(lambdaClass, LAMBDA_FACTORY_METHOD_NAME, factoryMethodType));
 *
    private static void generateInterfaceMethod(
            modifiers,
 * The OpenSearch Contributors require contributions made to
 * List list1 = new ArrayList(); "
 * ownership. Elasticsearch licenses this file to you under
 *         ...
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
 * http://cr.openjdk.java.net/~briangoetz/lambda/lambda-translation.html
     * Validates some conversions at link time.  Currently, only ensures that the lambda method
        /**
        Lookup lookup,
            modifiers,
 * will be returned each time with the captures passed into the
        constructor.endMethod();
 *
import static org.opensearch.painless.WriterConstants.DELEGATE_BOOTSTRAP_HANDLE;
            throw new LambdaConversionException(
 * <pre>{@code
     * Creates an {@link ConstantCallSite}
        }
            delegateMethodType,
        // @uschindler says: I talked with Rémi Forax about this. Technically, a plain ctor
     * @param factoryMethodType The type of method to be linked to this CallSite; note that
    /**
        int modifiers = ACC_PUBLIC;
        args[1] = delegateInvokeType == H_INVOKESTATIC && isDelegateAugmented == false ? 0 : 1;
        String delegateMethodName,
        }
     * Links the delegate method to the returned {@link CallSite}.  The linked
        }
            this.desc = this.type.getDescriptor();
     * This method name is used to generate the static factory for capturing lambdas.
        );
        cw.visitEnd();
 * Unless required by applicable law or agreed to in writing,
 * <p>Take for example the following Painless script:
    }
     *                          captured types are based on the parameters for this method
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Metadata for a captured variable used during code generation.
     *                           the captured types
            generateStaticCtorDelegator(cw, ACC_PUBLIC, LAMBDA_FACTORY_METHOD_NAME, lambdaClassType, factoryMethodType);
        String lambdaClassName = Type.getInternalName(lookup.lookupClass()) + "$$Lambda" + loader.newLambdaIdentifier();
            args
     * @param delegateInvokeType The type of method call to be made
     * @param delegateMethodType The type of method call in the Painless script class without
    }
     * @param interfaceMethodType The type of method representing the functional interface method
        // Add a factory method, if lambda takes captures.
                Class<?> clazz = delegateMethodType.parameterType(0);
    /**
        Capture[] captures,
        ClassWriter cw = beginLambdaClass(lambdaClassName, factoryMethodType.returnType());
        String interfaceMethodName,
     * @param delegateClassName The name of the class to delegate method call to
 * lambda function/reference method; it will then make a delegated call to the
            isDelegateAugmented == 1,
        return cw;
    private static CallSite createNoCaptureCallSite(MethodType factoryMethodType, Class<?> lambdaClass) {
        try {
        return captures;
import static org.objectweb.asm.Opcodes.H_NEWINVOKESPECIAL;
        ClassWriter cw,
    private static void endLambdaClass(ClassWriter cw) {
        int modifiers = access | ACC_STATIC;
 * List list2 = new ArrayList(); "
         * descriptor for the captured argument.
 *
        // Handles the special case where a method reference refers to a ctor (we need a static wrapper method):
 * lambda functions and method references within Painless.  The code generation
            DELEGATE_BOOTSTRAP_HANDLE,
     * Creates the {@link ClassWriter} to be used for the lambda class generation.
    /**
    }
        Type baseConType = Type.getType(Object.class);
        String baseClass = Type.getInternalName(Object.class);
 * <p>Also the accept method actually uses an invokedynamic
 * code in a way, that a new instance is not created on each lambda
 * LambdaBootstrap is used to generate all the code necessary to execute
import org.objectweb.asm.commons.Method;
 * list1.forEach(x -> list2.add(x));"
        // appropriately converted to the delegate method types.
    }
        GeneratorAdapter constructor = new GeneratorAdapter(
        int access,
     */
 * <ol>
        factory.endMethod();
    private static final String DELEGATED_CTOR_WRAPPER_NAME = "delegate$ctor";
 * <p>The script contains a lambda function with a captured variable.
    /**
        Object... injections
     */
        factory.loadArgs();
        Lookup lookup,
        factory.newInstance(delegateClassType);
 * You may obtain a copy of the License at
        } else if (delegateInvokeType == H_INVOKEVIRTUAL || delegateInvokeType == H_INVOKEINTERFACE) {
 * SPDX-License-Identifier: Apache-2.0
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
        for (int captureCount = 0; captureCount < captures.length; ++captureCount) {
    ) throws LambdaConversionException {
        validateTypes(interfaceMethodType, delegateMethodType);
            delegateMethodName,
        Object... injections
            isDelegateInterface
        Type lambdaClassType = Type.getObjectType(lambdaClassName);
 * <p>For each lambda function/method reference used within a Painless script
import java.lang.invoke.ConstantCallSite;
        private final Type type;
    private static Capture[] generateCaptureFields(ClassWriter cw, MethodType factoryMethodType) {
        generateInterfaceMethod(
package org.opensearch.painless;
     *                            if the value is '1' if the delegate is an interface and '0'
        String interfaceMethodName,
 *
            // delegateMethodType drops the 'this' parameter because it will be re-inserted
 * their respective member fields
}
     */
    /**
        private final String desc;
    private static final class Capture {
            // Handles the case for a virtual or interface reference method with no captures.
        private Capture(int count, Class<?> type) {
     * for generating method arguments later on
            injections
 * or serialization.  LambdaBootstrap is being used as a replacement for
 */
    /**
 * under the License.
        }
            return createNoCaptureCallSite(factoryMethodType, lambdaClass);
        Type delegateClassType,
        // interfaceMethodType and delegateMethodType both have the captured types
                interfaceMethodType = interfaceMethodType.insertParameterTypes(0, clazz);
 *         private $$Lambda0(List arg$0) {
public final class LambdaBootstrap {
     */
            if (captures.length == 0) {
        // Example: Integer::parseInt
import org.objectweb.asm.Type;
     * that originally defined the class for the Painless script.
            captures,
        Class<?> lambdaClass = createLambdaClass(loader, cw, lambdaClassType);
 * Modifications Copyright OpenSearch Contributors. See
 *             this.arg$0 = arg$0;
    /**
            cw.visitMethod(modifiers, interfaceMethodName, lamDesc, null, null)
            } else {
            delegateInvokeType,
            delegateClassType,
