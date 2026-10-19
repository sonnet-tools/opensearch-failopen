     * static bootstrap parameter indicating an explicit cast to the return type.  
                depth++;
                    methodHandlesLookup.lookupClass(),  
            case BINARY_OPERATOR:  
                    return Def.lookupArrayLoad(receiver);
        }
                        } else if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0) {
            final MethodType type = type();
                        return lookupGeneric(); // can handle nulls, casts if supported  
                    MethodHandle unaryTest = CHECK_LHS.bindTo(clazz0);
         */  
                return generic.invokeWithArguments(args);
     * around that we wrap any checked exceptions with this RuntimeException and
package org.opensearch.painless;
     * </ul>
            super(cause);
     * the fallback if a null is encountered.
         * guard method for inline caching: checks the receiver's class is the same
            return target.invokeWithArguments(args);  
                    MethodType.methodType(boolean.class, Class.class, Class.class, Object.class, Object.class)
    /** static bootstrap parameter indicating a shift operator, e.g. foo &gt;&gt; bar */
        private static final MethodHandle MEGAMORPHIC_LOOKUP;
            setTarget(guard);
            case SHIFT_OPERATOR:
            setTarget(fallback);
        Object fallback(final Object[] callArgs) throws Throwable {  
     * invokeDynamic bootstrap method
        FunctionTable functions,
                            default -> Def.rethrow(t);  
                if (args.length > 0) {
                target = target.asType(type);
         * are the same as the cached receiver and first argument.  
            if ((flags & OPERATOR_EXPLICIT_CAST) != 0) {
            }
 * shift operator, and dynamic array index normalize.
 * not use this file except in compliance with the License.
 *  
        @SuppressForbidden(reason = "slow path")
                if (args.length == 0) {
    public static final int METHOD_CALL = 0;
                }  
                if (args.length != 1) {
/**
        /**  
import java.lang.invoke.MethodType;
            final MethodHandles.Lookup publicMethodHandlesLookup = MethodHandles.publicLookup();
                    mh,
                } else {  
    // constants for the flags parameter of operators  
import org.opensearch.painless.symbol.FunctionTable;  
                    test = unaryTest.asType(  
        }
            MethodType type,  
                            binary = DefMath.cast(args[0].getClass(), binary);  
 * software distributed under the License is distributed on an
     * may require {@link MethodHandles#explicitCastArguments}, or a dynamic cast  
                    "get",
     */
                    MethodType.methodType(boolean.class, Class.class, Object.class)
                        return lookup(flavor, name, receiverType).asType(type);
                    methodHandlesLookup.lookupClass(),
                }  
                MethodHandle test = CHECK_CLASS.bindTo(receiver);
        switch (flavor) {
                }  
            try {  
            if (initialized) {  
                if (type.parameterType(1) != Object.class) {
                if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0 && flavor != BINARY_OPERATOR && flavor != SHIFT_OPERATOR) {  
            case ARRAY_STORE:
            case ITERATOR:  
     * <p>
            PainlessLookup painlessLookup,
    public static final int INDEX_NORMALIZE = 10;
                );
         * Called when a new type is encountered or if cached type does not match.
    /**
            } else {
     *   <li>{@code flavor}: type of dynamic call it is (and which part of allowlist to look at).  
        private final MethodHandles.Lookup methodHandlesLookup;  
            MethodHandle target = lookup(args);
         * as the cached class
                final MethodHandle target = lookup(flavor, name, receiver).asType(type());  
                initialized = true;
                MEGAMORPHIC_LOOKUP = mh.asType(mh.type().changeReturnType(MethodHandle.class));  
            switch (flavor) {
     *   <li>{@code initialDepth}: initial call site depth. this is used to exercise megamorphic fallback.
            MethodHandle target = DefMath.lookupGeneric(name);
                );
        String name,
                MethodHandle guard = MethodHandles.guardWithTest(test, target, getTarget());  
                    return Def.lookupIndexNormalize(receiver);  
     * ClassValue.getFromHashMap will wrap checked exceptions with Errors. To get
        private MethodHandle lookup(Object[] args) throws Throwable {
        private static final MethodHandle CHECK_CLASS;  
                case BINARY_OPERATOR:
     * CallSite that implements the polymorphic inlining cache (PIC).  
                CHECK_LHS = methodHandlesLookup.findStatic(
    public static final int ARRAY_LOAD = 3;
                    methodHandlesLookup.lookupClass(),
         */
        private final PainlessLookup painlessLookup;  
 * <p>
                    "checkBoth",
                // some binary operators support nulls, we handle them separate
 * this file be licensed under the Apache-2.0 license or a
            case UNARY_OPERATOR:
     * to cast back to the receiver's type, depending on types seen.
                    ClassValue.class,  
        private static final MethodHandle CHECK_LHS;  
     * see https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.invokedynamic
        private static final MethodHandle FALLBACK;
            this.flavor = flavor;
         * guard method for inline caching: checks the receiver's class is the same  
        }
            Object[] args  
 * GitHub history for details.
         * guard method for inline caching: checks the receiver's class and the first argument
            case LOAD:
    public static CallSite bootstrap(
                    return Def.lookupGetter(painlessLookup, receiver, name);  
     */
            this.constants = constants;
/*  
                FALLBACK = methodHandlesLookup.findVirtual(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final MethodHandle test;  
                FALLBACK = methodHandlesLookup.findVirtual(  
        }
                );  
        private final int flavor;
                if ((flags & OPERATOR_ALLOWS_NULL) != 0 && flavor != BINARY_OPERATOR) {
        // validate arguments
        Object... args
}  
            final MethodType type = type();
                case ARRAY_STORE:
                Class<?> clazz1 = args[1] == null ? null : args[1].getClass();
            try {  
    /**  
            }
            final MethodHandles.Lookup methodHandlesLookup = MethodHandles.lookup();
                    return Def.lookupArrayStore(receiver);  
        /**  
 *
            case STORE:  
    /**
                throw new AssertionError(e);
        }
         * Creates the {@link MethodHandle} for the megamorphic call site
 */
                exc.initCause(e);
            }  
import java.lang.invoke.MethodHandles;
    public static final int STORE = 2;  
                return target.invokeWithArguments(callArgs);
         * using {@link ClassValue} and {@link MethodHandles#exactInvoker(MethodType)}:
         */  
                    if ((flags & OPERATOR_EXPLICIT_CAST) != 0) {
            this.name = name;
                // static cast to the return type  
                        }
                    methodHandlesLookup.lookupClass(),
                    } catch (Throwable t) {  
                        MethodHandle binary = DefMath.lookupBinary(args[0].getClass(), args[1].getClass(), name);
        /**  
        }
import org.opensearch.common.SuppressForbidden;
                } else if (type.parameterType(0) != Object.class) {  
                }  
                if (args.length != 1) {
    }  
                setTarget(guard);
    /**
            }  
        }
         */  
        /**
                // we revert the whole cache and build a new megamorphic one
    public static final int ARRAY_STORE = 4;
 * Painless invokedynamic bootstrap for the call site.
    public static final int OPERATOR_EXPLICIT_CAST = 1 << 2;
     * requires additional {@link MethodHandles#catchException} guard, which will invoke
        }
            }
    /**
                    test = unaryTest.asType(unaryTest.type().changeParameterType(0, type.parameterType(0)));
 * specific language governing permissions and limitations
 */
 * You may obtain a copy of the License at  
                Class<?> clazz0 = args[0] == null ? null : args[0].getClass();  
                if (args[0] instanceof Integer == false) {
            }
                return target.invokeWithArguments(callArgs);  
                }
                        if ((flags & OPERATOR_EXPLICIT_CAST) != 0) {  
    public static final int LOAD = 1;
            this.args = args;  
            MethodHandle fallback = FALLBACK.bindTo(this).asCollector(Object[].class, type.parameterCount()).asType(type);
                    // we just don't need it anywhere else.
 * (https://code.google.com/archive/p/jsr292-cookbook/, BSD license)
                    // case 2: only the argument is unknown, just check that
                    "checkRHS",
                        return binary;
 * the Apache License, Version 2.0 (the "License"); you may
import java.lang.invoke.CallSite;
            if (type.parameterType(0) != Object.class) {  
                );
    static final class PIC extends MutableCallSite {
    @SuppressWarnings("unchecked")
 * Has 11 flavors (passed as static bootstrap parameters): dynamic method call,
            case INDEX_NORMALIZE:
                    throw new BootstrapMethodError("Invalid number of parameters for reference call");
                            binary = DefMath.cast(type().returnType(), binary);
                return new MIC(name, type, initialDepth, flavor, flags);
    /** static bootstrap parameter indicating a dynamic method call, e.g. foo.bar(...) */
            final ClassValue<MethodHandle> megamorphicCache = new ClassValue<MethodHandle>() {  
                    );
/*
     * static bootstrap parameter indicating the binary operator allows nulls (e.g. == and +)
        }  
                    "checkLHS",  
    /**  
// and it needs to be accessible by that code.
     * CallSite that implements the monomorphic inlining cache (for operators).
 * Unless required by applicable law or agreed to in writing,
    /** static bootstrap parameter indicating a dynamic store (setter), e.g. foo.bar = baz */
 * allowlist, and cache with a guard. If we encounter too many types, we stop caching.
    /**  
            this.painlessLookup = painlessLookup;  
            try {
            if (flavor == BINARY_OPERATOR || flavor == SHIFT_OPERATOR) {
     * <p>
                    MethodType.methodType(Object.class, Object[].class)  
                    methodHandlesLookup.lookupClass(),
                    publicMethodHandlesLookup.findVirtual(Object.class, "getClass", MethodType.methodType(Class.class))
                    return Def.lookupMethod(painlessLookup, functions, constants, methodHandlesLookup, type(), receiver, name, args);
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        static {
 * Licensed to Elasticsearch under one or more contributor  
            this.flavor = flavor;
        private static final MethodHandle CHECK_RHS;
            } else {
            this.methodHandlesLookup = methodHandlesLookup;  
         * types at this call site and given up on caching using this fallback and we switch to a
            // we wrap + with an NPE catcher, and use our generic method in that case.  
                case ITERATOR:
     */
            } else if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0) {
        /**
            default:
                if (args.length != numLambdas + 1) {
                    throw new BootstrapMethodError("Illegal static bootstrap parameters for flavor: " + flavor);  
                case REFERENCE:  
                    } else {
            return receiver.getClass() == clazz;
                case LOAD:
     * unwrap them later.  
                            case Exception e -> throw new WrappedCheckedException(e);
                    "checkClass",  
        /** maximum number of types before we go megamorphic */  
         * as the cached first argument.
            // operators get monomorphic cache, with a generic impl for a fallback  
        /**
        PIC(  
                        throw new AssertionError();
         * In that case we revert to a generic, but slower operator handling.
                case INDEX_NORMALIZE:
 * The OpenSearch Contributors require contributions made to  
        }
                @Override
        private final int flags;  
                return new PIC(painlessLookup, functions, constants, methodHandlesLookup, name, type, initialDepth, flavor, args);
        private final int flavor;
        static boolean checkRHS(Class<?> left, Class<?> right, Object leftObject, Object rightObject) {  
 * <p>
                    return Def.lookupIterator(receiver);
            int initialDepth,
        }
                    } else if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0) {  
         */  
         * megamorphic cache using {@link ClassValue}).  
        private MethodHandle createMegamorphicHandle() {
import java.util.Map;
        private final Object[] args;  
        /**  
                    }
                case UNARY_OPERATOR:  
                target = DefMath.dynamicCast(target, type().returnType());
                    throw new AssertionError();
import java.lang.invoke.WrongMethodTypeException;
                    // we just don't need it anywhere else.  
                MethodHandle generic = lookupGeneric();
            // "function-call" like things get a polymorphic cache  
            MethodHandle fallback = FALLBACK.bindTo(this).asCollector(Object[].class, type.parameterCount()).asType(type);  
                // dynamic cast to the receiver's type  
            return rightObject.getClass() == right;
                    return unary;  
    public static final int BINARY_OPERATOR = 8;  
                CHECK_RHS = methodHandlesLookup.findStatic(  
            this.flags = flags;  
                if (args[0] instanceof String == false) {
 * When a new type is encountered at the call site, we lookup from the appropriate  
            if (depth >= MAX_DEPTH) {
        }
     * And we take the {@link PainlessLookup} used to compile the script for allowlist checking.  
        private MethodHandle lookup(int flavor, String name, Class<?> receiver) throws Throwable {
    /** static bootstrap parameter indicating a dynamic load (getter), e.g. baz = foo.bar */  
            this.depth = initialDepth;
    public static final int SHIFT_OPERATOR = 9;
    static final class MIC extends MutableCallSite {
    static final class WrappedCheckedException extends RuntimeException {
         * Does a slow lookup for the operator
         * Does a slow lookup against the allowlist.
        static final int MAX_DEPTH = 5;
                // caching defeated
                    MethodType.methodType(Object.class, Object[].class)
            return target;  
    }
     * In addition to ordinary parameters, we also take some parameters defined at the call site:  
                }
 * SPDX-License-Identifier: Apache-2.0
                test = receiverTest.asType(receiverTest.type().changeParameterType(0, type.parameterType(0)));
                    MethodHandle unaryTest = CHECK_RHS.bindTo(clazz0).bindTo(clazz1);
        private MethodHandle lookupGeneric() {  
        private final String name;
                String recipe = (String) args[0];
         */  
                    // case 3: check both receiver and argument
                        }
            Map<String, Object> constants,  
                final Class<?> receiver = callArgs[0].getClass();
                throw new AssertionError(e);
                    test = binaryTest.asType(  
 *
        MethodHandles.Lookup methodHandlesLookup,  
                    try {
 * <p>  
                    throw new BootstrapMethodError("Invalid number of parameters for operator call");
                    if (args[0] == null || args[1] == null) {
        static boolean checkBoth(Class<?> left, Class<?> right, Object leftObject, Object rightObject) {
        MethodType type,
            if (flavor == BINARY_OPERATOR && (flags & OPERATOR_ALLOWS_NULL) != 0) {
     */  
        }
    ) {  
         * Called when a new type is encountered (or, when we have encountered more than {@code MAX_DEPTH}
    }
public final class DefBootstrap {
            }  
 * Based on the cascaded inlining cache from the JSR 292 cookbook  
                        unary = DefMath.cast(type().returnType(), unary);
        int initialDepth,  
                case METHOD_CALL:  
            int flavor,
        /**
        }
     * may require {@link MethodHandles#explicitCastArguments}, depending on types seen.
                }
                    throw new BootstrapMethodError("Illegal parameter for method call: " + args[0]);  
        int flavor,
 */  
                    );
            MethodHandle guard = MethodHandles.guardWithTest(test, target, getTarget());
        private boolean initialized;
        private static final MethodHandle CHECK_BOTH;
/*  
            } catch (ReflectiveOperationException e) {  
                        switch (t) {
                throw new BootstrapMethodError("The receiver type (1st arg) of invokedynamic descriptor must be Object.");
     * <p>  
         * guard method for inline caching: checks the first argument is the same  
        int depth; // pkg-protected for testing
     * <p>
    /** static bootstrap parameter indicating a dynamic iteration, e.g. for (x : y) */
            initialized = true;  
            }
    /** static bootstrap parameter indicating a binary math operator, e.g. foo / bar */
                throw exc;  
        private final Map<String, Object> constants;
 * compatible open source license.
                if (numLambdas > type.parameterCount()) {
    /** static bootstrap parameter indicating a dynamic method reference, e.g. foo::bar */
            }
                    1,  
        @SuppressForbidden(reason = "slow path")
     * <p>
                int flags = (int) args[0];
            };
            FunctionTable functions,
 * under the License.  
            super(type);  
    // NOTE: these must be primitive types, see https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.invokedynamic  
                // unary operator
     * static bootstrap parameter indicating the binary operator is part of compound assignment (e.g. +=).
    /** static bootstrap parameter indicating a dynamic array load, e.g. baz = foo[bar] */
                    // shifts are treated as unary, as java allows long arguments without a cast (but bits are ignored)
        static {  
    public static final int UNARY_OPERATOR = 7;
    /** static bootstrap parameter indicating a request to normalize an index for array-like-access */  
    private DefBootstrap() {} // no instance!
            setTarget(fallback);
                    }  
                }
                default:
                        unaryTest.type().changeParameterType(0, type.parameterType(0)).changeParameterType(1, type.parameterType(1))
                );
                    "fallback",  
                target = DefMath.dynamicCast(target);
                mh = MethodHandles.filterArguments(
import org.opensearch.painless.lookup.PainlessLookup;
                    methodHandlesLookup.lookupClass(),
                case STORE:
                    MethodType.methodType(boolean.class, Class.class, Object.class)
                    // case 1: only the receiver is unknown, just check that  
    }
            MethodHandles.Lookup methodHandlesLookup,
            super(type);
                setTarget(generic.asType(type()));  
    public static final int OPERATOR_ALLOWS_NULL = 1 << 0;
            }
        Object fallback(Object[] args) throws Throwable {
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw new BootstrapMethodError("Illegal static bootstrap parameter for flavor: " + flavor);  
                    MethodHandle unary = DefMath.lookupUnary(args[0].getClass(), name);  
                    throw new BootstrapMethodError("Illegal parameter for reference call: " + args[0]);
        MIC(String name, MethodType type, int initialDepth, int flavor, int flags) {
                );  
                );
     */  
                MethodHandle handler = MethodHandles.dropArguments(lookupGeneric().asType(type()), 0, NullPointerException.class);
import java.lang.invoke.MethodHandle;  
                }  
            case REFERENCE:  
                    MethodType.methodType(Object.class, Class.class)
            if (initialDepth > 0) {
                    throw new BootstrapMethodError("Illegal parameter for reference call: " + args[0]);
                );
                MethodHandle receiverTest = CHECK_LHS.bindTo(args[0].getClass());  
    public static final int REFERENCE = 6;
            final MethodHandles.Lookup methodHandlesLookup = MethodHandles.lookup();
                    // it's too stupid that we cannot throw checked exceptions... (use rethrow puzzler):  
                    throw new BootstrapMethodError("Illegal number of parameters: expected " + numLambdas + " references");
                    throw new BootstrapMethodError("This parameter is only supported for BINARY/SHIFT_OPERATORs");
        private final FunctionTable functions;
    public static final int ITERATOR = 5;  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> constants,
         */
                }
                    return Def.lookupReference(painlessLookup, functions, constants, methodHandlesLookup, (String) args[0], receiver, name);
                }  
                }  
        ) {
            } catch (ReflectiveOperationException e) {
         */
                    "fallback",
                protected MethodHandle computeValue(Class<?> receiverType) {
 * dynamic array store, iterator, method reference, unary operator, binary operator,  
        }  
                case SHIFT_OPERATOR:
        /**
            // very special cases, where even the receiver can be null (see JLS rules for string concat)
            return MethodHandles.foldArguments(MethodHandles.exactInvoker(type), MEGAMORPHIC_LOOKUP.bindTo(megamorphicCache));  
                    return Def.lookupSetter(painlessLookup, receiver, name);
                Exception exc = new ClassCastException("Cannot cast from: " + target.type().returnType() + " to " + type.returnType());
            this.functions = functions;
                int numLambdas = recipe.length();  
            } catch (WrongMethodTypeException e) {  
                        binaryTest.type().changeParameterType(0, type.parameterType(0)).changeParameterType(1, type.parameterType(1))
                setTarget(target);
                final MethodHandle target = this.createMegamorphicHandle();  
            case ARRAY_LOAD:
        private static final MethodHandle FALLBACK;  
                    MethodHandle binaryTest = CHECK_BOTH.bindTo(clazz0).bindTo(clazz1);
import java.lang.invoke.MutableCallSite;  
                    throw new BootstrapMethodError("Illegal recipe for method call: too many bits");
        static boolean checkClass(Class<?> clazz, Object receiver) {  
                default:
                }  
                guard = MethodHandles.catchException(guard, NullPointerException.class, handler);  
                    throw new AssertionError();
 */  
                    throw new BootstrapMethodError("Invalid number of parameters for method call");  
                    throw new BootstrapMethodError("This parameter is only supported for BINARY_OPERATORs");
                return new PIC(painlessLookup, functions, constants, methodHandlesLookup, name, type, initialDepth, flavor, args);
        static boolean checkLHS(Class<?> clazz, Object leftObject) {
                MethodHandle mh = publicMethodHandlesLookup.findVirtual(
        }  
            this.name = name;
                CHECK_CLASS = methodHandlesLookup.findStatic(
     * <ul>
     */  
                        unary = DefMath.cast(args[0].getClass(), unary);
            }  
            return leftObject.getClass() == left && rightObject.getClass() == right;  
    /** static bootstrap parameter indicating a dynamic array store, e.g. foo[bar] = baz */  
            // for math operators: WrongMethodType can be confusing. convert into a ClassCastException if they screw up.  
    /** static bootstrap parameter indicating a unary math operator, e.g. ~foo */  
 * dynamic field load (getter), and dynamic field store (setter), dynamic array load,
                    }  
// NOTE: this class must be public, because generated painless classes are in a different classloader,  
     *   <li>{@code args}: flavor-specific args.
            case METHOD_CALL:
                case ARRAY_LOAD:  
                return new PIC(painlessLookup, functions, constants, methodHandlesLookup, name, type, initialDepth, flavor, args);
 * Modifications Copyright OpenSearch Contributors. See
            switch (flavor) {
            return leftObject.getClass() == clazz;
            String name,
                if (args[0] instanceof String == false) {
                    MethodType.methodType(boolean.class, Class.class, Class.class, Object.class, Object.class)  
        PainlessLookup painlessLookup,  
     */  
         * as the cached class
         */
                CHECK_BOTH = methodHandlesLookup.findStatic(
    public static final int OPERATOR_COMPOUND_ASSIGNMENT = 1 << 1;  
            }  
        private WrappedCheckedException(Exception cause) {  
 * this work for additional information regarding copyright
        private final String name;
