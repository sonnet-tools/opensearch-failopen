import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
 * and take in any other necessary values based on the arguments passed into the  
 * actual lambda function/reference method.
 *
            delegateMethodName,
        );
    ) throws LambdaConversionException {  
 * <pre>{@code
 * <li>a static ctor delegation method, if the lambda function is a ctor.
    }
        // appropriately converted to the delegate method types.  
        // inserted into their type signatures. This later allows the delegate
        MethodType factoryMethodType,  
import java.lang.invoke.LambdaConversionException;
}  
            delegateInvokeType = H_INVOKESTATIC;
 *         }
 * specific language governing permissions and limitations
         * descriptor for the captured argument.  
     *                            otherwise; note this is an int because the bootstrap method
     * with {@code INVOKEDYNAMIC} using the {@link #delegateBootstrap} type converter.  
     *                           (static, virtual, interface, or constructor)
    /**
        /**
 * not use this file except in compliance with the License.
            interfaceMethodType,  
 * this file be licensed under the Apache-2.0 license or a
        }
            // when the method handle for the dynamically invoked delegate method is created.  
 * conversions between argument types without having to hard
        Capture[] captures = generateCaptureFields(cw, factoryMethodType);  
     *                            if the value is '1' if the delegate is an interface and '0'
        factory.returnValue();  
 *     }  
        // and a MethodHandle to the ctor would be enough - BUT: Hotspot is unable to
    private static Capture[] generateCaptureFields(ClassWriter cw, MethodType factoryMethodType) {
        String delegateClassName,
 * license agreements. See the NOTICE file distributed with
        }  
            // replace the delegate with our static wrapper:
 *
        factory.dup();  
        if (injections.length > 0) {  
            modifiers,
    private static final String DELEGATED_CTOR_WRAPPER_NAME = "delegate$ctor";
    private static void generateLambdaConstructor(ClassWriter cw, Type lambdaClassType, MethodType factoryMethodType, Capture[] captures) {
 *         public static lambda$0(List list2, Object x) {
/**
 * }</pre>
        // escape analysis can figure out that everything is final and we don't need
        constructor.visitCode();
    /**
 * <p>Also the accept method actually uses an invokedynamic
        Type delegateClassType = Type.getObjectType(delegateClassName.replace('.', '/'));
     *                           the captured types
     * Defines the {@link Class} for the lambda class using the same {@link Compiler.Loader}
        Capture[] captures = new Capture[captureTotal];
    }
        constructor.loadThis();  
 * code in a way, that a new instance is not created on each lambda
        String interfaceMethodName,
        MethodType delegateMethodType,
        // @uschindler says: I talked with Rémi Forax about this. Technically, a plain ctor
         */  
 *
     * @return A {@link CallSite} linked to a factory method for creating a lambda class
            assert CTOR_METHOD_NAME.equals(delegateMethodName);
    }
        return AccessController.doPrivileged(() -> loader.defineLambda(lambdaClassType.getClassName(), classBytes));  
        String lambdaClassName = Type.getInternalName(lookup.lookupClass()) + "$$Lambda" + loader.newLambdaIdentifier();
            } else if (captures.length == 1) {  
        Method lamMeth = new Method(lambdaClassType.getInternalName(), lamDesc);
 *
        return cw;
 * You may obtain a copy of the License at  
 * invocation with captures, stressing garbage collector (thanks  
 * lambda functions and method references within Painless.  The code generation  
 *             return new $$Lambda0(arg$0);  
 * software distributed under the License is distributed on an
 * changing values other than the arguments, the lambda is a singleton.  
     */
/*  
import static org.opensearch.painless.WriterConstants.CTOR_METHOD_NAME;  
 * instruction to call the lambda$0 method so that  
        iface.endMethod();
            // delegateMethodType drops the 'this' parameter because it will be re-inserted
         * @param count The captured argument count
        }  
    private static final class Capture {
            args
    /**  
        Type lambdaClassType,
import static java.lang.invoke.MethodHandles.Lookup;
 * SPDX-License-Identifier: Apache-2.0
     * arguments if any and store them in their respective
        generateLambdaConstructor(cw, lambdaClassType, factoryMethodType, captures);
            modifiers,  
    }
        constructor.endMethod();
import static org.objectweb.asm.Opcodes.H_INVOKEINTERFACE;
     * that originally defined the class for the Painless script.
            interfaceMethodName,
    }
    /**  
     * {@link MethodHandle#asType} to be used to do the type conversion instead
        MethodType delegateMethodType
            delegateMethodName,  
     */  
        String delegatorMethodName,  
            generateStaticCtorDelegator(cw, ACC_PUBLIC, LAMBDA_FACTORY_METHOD_NAME, lambdaClassType, factoryMethodType);
                delegateClassType = Type.getType(clazz);
 * cannot be fully supported through this class.  
        Type lambdaClassType = Type.getObjectType(lambdaClassName);  
     */
        );  
        String delegateMethodName,
    /**
 *     }
     * @param interfaceMethodType The type of method representing the functional interface method
     */  
        int delegateInvokeType,  
public final class LambdaBootstrap {  
 * a class will be generated at link-time using the  
 *     public static final class $$Lambda0 implements Consumer {
    public static CallSite delegateBootstrap(  
import static org.objectweb.asm.Opcodes.H_NEWINVOKESPECIAL;
     * @param factoryMethodType The type of method to be linked to this CallSite; note that  
        GeneratorAdapter constructor = new GeneratorAdapter(  
            throw new IllegalStateException("unable to create lambda class", exception);  
    private static ClassWriter beginLambdaClass(String lambdaClassName, Class<?> lambdaInterface) {
                Class<?> clazz = delegateMethodType.parameterType(0);  
        String lamDesc = interfaceMethodType.toMethodDescriptorString();  
 * or serialization.  LambdaBootstrap is being used as a replacement for
        for (int captureCount = 0; captureCount < captureTotal; ++captureCount) {  
 * returned each time by the factory method as there are no
        Type delegateClassType,
 * {@link java.lang.invoke.LambdaMetafactory} since the Painless casting model
     */  
 * Modifications Copyright OpenSearch Contributors. See
            interfaceMethodType = interfaceMethodType.insertParameterTypes(0, factoryMethodType.parameterArray());
     * @throws LambdaConversionException Thrown when an illegal type conversion occurs at link time
 *
 *         ...
package org.opensearch.painless;
         * @param type The class type of the captured argument
            throw new LambdaConversionException(
        endLambdaClass(cw);
        constructor.invokeConstructor(baseConType, baseConMeth);
import static org.objectweb.asm.Opcodes.H_INVOKESTATIC;  
            constructor.loadThis();
                // Example: something::toString
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
 * <ol>  
        Type baseConType = Type.getType(Object.class);
import java.lang.invoke.MethodHandles;
 *
 *         }
        Object... injections  
                delegateClassType = Type.getType(clazz);
        MethodType delegateMethodType,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * within a Painless script.  Variables with the prefix interface are considered
 */
        factory.newInstance(delegateClassType);
            delegateClassType.getInternalName(),
    }  
        Handle delegateHandle = new Handle(
 * return list[0]"  
import java.lang.invoke.MethodType;
 *         }  
        }  
     */  
        }  
import static org.objectweb.asm.Opcodes.ACC_STATIC;
     * Generates the interface method that will delegate (call) to the delegate method
        } else {
import org.objectweb.asm.Handle;
 * on whether or not there are captures.  If there are no captures  
        Method baseConMeth = new Method(CTOR_METHOD_NAME, MethodType.methodType(void.class).toMethodDescriptorString());  
                // method to be invoked dynamically and have the interface method types  
     * invokedynamic to make the delegate method call allows
 * this work for additional information regarding copyright
        // Add a factory method, if lambda takes captures.  
     *                          captured types are based on the parameters for this method
 * If there are captures, a new instance of the generated lambda class
            DELEGATE_BOOTSTRAP_HANDLE,  
    public static CallSite lambdaBootstrap(  
            // Handles the case for a virtual or interface reference method with no captures.
            cw,
 * the Apache License, Version 2.0 (the "License"); you may
        ClassWriter cw,
 * ownership. Elasticsearch licenses this file to you under  
        }
            delegateMethodType.toMethodDescriptorString(),  
 * }</pre>  
        // Loads any captured variables onto the stack.
 *  
        int isDelegateInterface,  
            delegateInvokeType,  
 * the same instance of the generated lambda class will be
 * under the License.  
        if (delegateInvokeType == H_INVOKESTATIC) {  
            delegateMethodName,
        int modifiers = (captures.length > 0) ? ACC_PRIVATE : ACC_PUBLIC;
            lambdaClassType,
     * @param delegateMethodName The name of the method to be called in the Painless script class  
            if (captures.length == 0) {
        // Because of this we create a factory method. With this factory method, the
        } catch (ReflectiveOperationException exception) {
        // Loads any passed in arguments onto the stack.
        args[1] = delegateInvokeType == H_INVOKESTATIC && isDelegateAugmented == false ? 0 : 1;
        try {  
 * Licensed to Elasticsearch under one or more contributor  
     * up at link-time.
import org.objectweb.asm.FieldVisitor;  
 * LambdaBootstrap is used to generate all the code necessary to execute
 *    http://www.apache.org/licenses/LICENSE-2.0
 *         private $$Lambda0(List arg$0) {
 * <p>When the {@link CallSite} is linked the linked method depends
            this.name = "arg$" + count;
        ClassWriter cw = beginLambdaClass(lambdaClassName, factoryMethodType.returnType());
        // an instance, so it can omit object creation on heap!  
 *  
     */
            delegateMethodType = delegateMethodType.insertParameterTypes(0, factoryMethodType.parameterArray());
     * delegate method.  
            modifiers,
 * their respective member fields  
        // Handles the case for a lambda function or a static reference method.
        iface.loadArgs();  
 *
     * @param injections Optionally add injectable constants into a method reference
import org.objectweb.asm.commons.Method;
    }  
     * with a return value cannot delegate to a delegate method with no return type.
        return captures;
        Compiler.Loader loader = (Compiler.Loader) lookup.lookupClass().getClassLoader();
        int modifiers = ACC_PUBLIC;
        for (int captureCount = 0; captureCount < captures.length; ++captureCount) {  
    }
            conMeth,
 */  
    ) throws LambdaConversionException {
     * This method name is used to generate a static wrapper method to handle delegation of ctors.  
    /**  
            throw new IllegalStateException("unexpected invocation type [" + delegateInvokeType + "]");
 * {@link LambdaBootstrap#lambdaBootstrap} method that contains the following:
        // method to be invoked dynamically and have the interface method types
            isDelegateInterface
        // DEBUG:
        }
     * Generates member fields for captured variables  
    ) {  
        MethodHandle delegateMethodHandle,
                "lambda expects return type [" + interfaceMethodType.returnType() + "], but found return type [void]"
     * @param delegateInvokeType The type of method call to be made
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;  
import org.opensearch.secure_sm.AccessController;
        int isVirtual,
            factoryMethodType,  
 *             Painless$Script.lambda$0(this.arg$0, val$0);
            injections
/*
    ) {
        } else if (delegateInvokeType == H_INVOKEVIRTUAL || delegateInvokeType == H_INVOKEINTERFACE) {  
import org.objectweb.asm.Type;
 * compatible open source license.
         * Converts incoming parameters into the name, type, and
 * <p>The script contains a lambda function with a captured variable.  
    private static CallSite createCaptureCallSite(Lookup lookup, MethodType factoryMethodType, Class<?> lambdaClass) {
/*  
        } catch (ReflectiveOperationException exception) {
     * Creates an {@link ConstantCallSite} that will return the same instance
        Capture[] captures,
            delegateMethodName = DELEGATED_CTOR_WRAPPER_NAME;
import static org.objectweb.asm.Opcodes.H_INVOKEVIRTUAL;
            delegateClassType,
     */  
        }
        String conDesc = factoryMethodType.changeReturnType(void.class).toMethodDescriptorString();  
                Class<?> clazz = factoryMethodType.parameterType(0);
        Method wrapperMethod = new Method(delegatorMethodName, delegateMethodType.toMethodDescriptorString());
import org.objectweb.asm.commons.GeneratorAdapter;  
        MethodType factoryMethodType,
            isDelegateInterface == 1,
 * calls the constructor. This method is used by the
     * Creates an {@link ConstantCallSite}
 * <li>member fields for any captured variables
            captures,
        int modifiers = access | ACC_STATIC;  
        private final Type type;
     * of the generated lambda class every time this linked factory method is called.
            this.desc = this.type.getDescriptor();
            throw new IllegalStateException("unable to instantiate lambda class", exception);  
            );  
 *     public class Painless$Script implements ... {
     * @param lookup Standard {@link MethodHandles#lookup}
     */
        );
     */
import org.objectweb.asm.ClassWriter;
        boolean isDelegateAugmented,
 * list1.forEach(x -> list2.add(x));"
                // method signature. This later allows the delegate
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
 * Instead of calling the ctor, a static factory method is created
        factory.visitCode();
 * The following Lambda class would be generated:
            iface.getField(lambdaClassType, captures[captureCount].name, captures[captureCount].type);
            fv.visitEnd();
 * However, it is a simplified version as Painless has no concept of generics  
        MethodType interfaceMethodType,
            return new ConstantCallSite(MethodHandles.constant(factoryMethodType.returnType(), lambdaClass.getConstructor().newInstance()));
        factory.invokeConstructor(delegateClassType, constructorMethod);
        String baseClass = Type.getInternalName(Object.class);
        iface.invokeDynamic(  
 * http://cr.openjdk.java.net/~briangoetz/lambda/lambda-translation.html
     * Links the delegate method to the returned {@link CallSite}.  The linked
        return new ConstantCallSite(delegateMethodHandle.asType(interfaceMethodType));
        System.arraycopy(injections, 0, args, 2, injections.length);
            isDelegateAugmented == 1,  
    /**
     */  
     * Generates a constructor that will take in captured  
import static org.objectweb.asm.Opcodes.ACC_SUPER;  
            FieldVisitor fv = cw.visitField(modifiers, captures[captureCount].name, captures[captureCount].desc, null, null);
                // captured. interfaceMethodType inserts the 'this' type into its
        constructor.returnValue();  
 * GitHub history for details.
        byte[] classBytes = cw.toByteArray();  
                throw new LambdaConversionException("unexpected number of captures [ " + captures.length + "]");
            delegateMethodHandle = MethodHandles.insertArguments(delegateMethodHandle, isVirtual, injections);
        String interfaceMethodName,  
 * <p>For each lambda function/method reference used within a Painless script
        validateTypes(interfaceMethodType, delegateMethodType);  
            generateStaticCtorDelegator(cw, ACC_PRIVATE, DELEGATED_CTOR_WRAPPER_NAME, delegateClassType, delegateMethodType);  
 * <li>a constructor that will take in captured variables and assign them to
        int captureTotal = factoryMethodType.parameterCount();  
     * @param isDelegateInterface If the method to be called is owned by an interface where  
import static org.opensearch.painless.WriterConstants.CLASS_VERSION;
            return createNoCaptureCallSite(factoryMethodType, lambdaClass);
 *         }  
     * Generates a lambda class for a lambda function/method reference
        Method constructorMethod = new Method(CTOR_METHOD_NAME, delegateMethodType.changeReturnType(void.class).toMethodDescriptorString());
        Object... injections  
            cw.visitMethod(modifiers, interfaceMethodName, lamDesc, null, null)
            delegateInvokeType,
 * list1.add(2); "  
     * based on the parameters for the factory method.
        Lookup lookup,
            lamMeth,  
        iface.visitCode();  
        }
    /**
            constructor.putField(lambdaClassType, captures[captureCount].name, captures[captureCount].type);  
        if (interfaceMethodType.returnType() != void.class && delegateMethodType.returnType() == void.class) {  
     */  
 * to Rémi Forax for the explanation about this on Jaxcon 2017!).
        if (delegateInvokeType == H_NEWINVOKESPECIAL) {
            captures[captureCount] = new Capture(captureCount, factoryMethodType.parameterType(captureCount));
     * that implements the expected functional interface  
    private static CallSite createNoCaptureCallSite(MethodType factoryMethodType, Class<?> lambdaClass) {
 * {@link MethodHandle#asType} can be used to do the necessary
    private static Class<?> createLambdaClass(Compiler.Loader loader, ClassWriter cw, Type lambdaClassType) {
        // Fill in args for indy. Always add the delegate handle and  
        if (captures.length > 0) {
 *  
import java.lang.invoke.CallSite;  
    }
        // do escape analysis through a MethodHandles.findConstructor generated handle.  
        private final String desc;
        // Example: Integer::parseInt
     */
 */
            } else {
     * of either a lot more code or requiring many {@link Class}es to be looked  
     */
        int delegateInvokeType,  
 * KIND, either express or implied.  See the License for the
        // Example: something.each(x -> x + 1)
            return createCaptureCallSite(lookup, factoryMethodType, lambdaClass);  
    private static void generateStaticCtorDelegator(  
 * used here is based upon the following article:
     * @param delegateClassName The name of the class to delegate method call to  
    }  
        for (int captureCount = 0; captureCount < captures.length; ++captureCount) {  
    private static void validateTypes(MethodType interfaceMethodType, MethodType delegateMethodType) throws LambdaConversionException {
     * Creates the {@link ClassWriter} to be used for the lambda class generation.
 *
        }  
        Class<?> lambdaClass = createLambdaClass(loader, cw, lambdaClassType);
        MethodType interfaceMethodType,  
 *         public void accept(Object val$0) {  
 * List list1 = new ArrayList(); "
 *
    private static void endLambdaClass(ClassWriter cw) {
 * invokedynamic call to initialize the instance.  
     * within the Painless script.  The interface method delegates (calls) to the
     *                            cannot convert constants to boolean  
        args[0] = delegateHandle;  
    /**
            return new ConstantCallSite(lookup.findStatic(lambdaClass, LAMBDA_FACTORY_METHOD_NAME, factoryMethodType));
    private static void generateInterfaceMethod(
import static org.opensearch.painless.WriterConstants.DELEGATE_BOOTSTRAP_HANDLE;
     * to represent values for code generated for the lambda class. Variables with  
    /**  
 * <li>a method that will load the member fields representing captured variables
 * will be returned each time with the captures passed into the
        factory.endMethod();
        // interfaceMethodType and delegateMethodType both have the captured types  
            // Example: Object::toString
        GeneratorAdapter factory = new GeneratorAdapter(
     * @param interfaceMethodName Name of functional interface method that is called
        factory.loadArgs();
     * Closes the {@link ClassWriter}.  
        int modifiers = ACC_PUBLIC | ACC_SUPER | ACC_FINAL | ACC_SYNTHETIC;  
 *
        Method conMeth = new Method(CTOR_METHOD_NAME, conDesc);
 *             this.arg$0 = arg$0;
 * escape analysis. Escape analysis is important to optimize the
import static org.objectweb.asm.Opcodes.ACC_FINAL;
        int isDelegateAugmented,
 * </ol>  
                delegateMethodType = delegateMethodType.dropParameterTypes(0, 1);
 *             list2.add(x);
        if (captures.length > 0) {
        iface.returnValue();
    /**
        );
     * Validates some conversions at link time.  Currently, only ensures that the lambda method
 * List list2 = new ArrayList(); "
        String delegateMethodName,
            }  
            cw.visitMethod(modifiers, delegatorMethodName, delegateMethodType.toMethodDescriptorString(), null, null)
            delegateMethodType,
        boolean isDelegateInterface,  
            this.type = Type.getType(type);  
        String delegateMethodName,
 * wrapper method is created, that creates a class instance and
        private final String name;  
        private Capture(int count, Class<?> type) {
    }
 * The OpenSearch Contributors require contributions made to  
            Type.getMethodType(interfaceMethodType.toMethodDescriptorString()).getDescriptor(),
 * code them. For method references to a constructor, a static  
 * Unless required by applicable law or agreed to in writing,
        GeneratorAdapter iface = new GeneratorAdapter(
        // Handles the special case where a method reference refers to a ctor (we need a static wrapper method):  
                // appropriately converted to the delegate method types.
        int access,
        cw.visit(CLASS_VERSION, modifiers, lambdaClassName, null, baseClass, new String[] { Type.getInternalName(lambdaInterface) });  
        try {  
            wrapperMethod,
            constructor.loadArg(captureCount);
     * the prefix delegate are considered to represent values for code generated
 * factory method to be stored in the member fields.  
        Object[] args = new Object[2 + injections.length];
    /**  
        ClassWriter cw,  
    }
import java.lang.invoke.ConstantCallSite;
        }
    private static final String LAMBDA_FACTORY_METHOD_NAME = "create$lambda";
        Object... injections
            delegateClassType = lambdaClassType;  
 * lambda function/reference method; it will then make a delegated call to the
     * @return An array of captured variable metadata
        cw.visitEnd();  
import java.lang.invoke.MethodHandle;  
                interfaceMethodType = interfaceMethodType.insertParameterTypes(0, clazz);  
     * delegate method will use converted types from the interface method.  Using  
 * is (currently) preventing Hotspot optimizer from correctly doing  
 *         public static Consumer create$lambda(List arg$0) {
        generateInterfaceMethod(
        Lookup lookup,
    /**
     * Generates a factory method to delegate to constructors.
 */  
        // whether it's static or not then injections as necessary.
     * @param delegateMethodType The type of method call in the Painless script class without
     */
 *
        Type delegateClassType,
     * for generating method arguments later on  
    }  
     * Metadata for a captured variable used during code generation.  
 *         private List arg$0;
 * in the lambda class, because a method handle to the ctor directly
                // Handles the case for a virtual or interface reference method with 'this'  
        // new ClassReader(classBytes).accept(new TraceClassVisitor(new PrintWriter(System.out)), ClassReader.SKIP_DEBUG);
    /**
            iface.loadThis();
 * <pre>{@code  
    /**
            cw.visitMethod(modifiers, CTOR_METHOD_NAME, conDesc, null, null)  
        }
 *
        );  
        } else {
        MethodType interfaceMethodType,
        );
 *         ...  
     * This method name is used to generate the static factory for capturing lambdas.
            int modifiers = ACC_PRIVATE | ACC_FINAL;
     * member fields.
 * <p>Take for example the following Painless script:
