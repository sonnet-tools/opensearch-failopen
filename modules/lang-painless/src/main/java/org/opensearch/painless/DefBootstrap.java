                    MethodHandle unaryTest = CHECK_RHS.bindTo(clazz0).bindTo(clazz1);
            int initialDepth,
            switch (flavor) {
     */
            return leftObject.getClass() == clazz;
            MethodHandle target = lookup(args);
                    // it's too stupid that we cannot throw checked exceptions... (use rethrow puzzler):
        private final int flags;
            setTarget(fallback);
            default:
// and it needs to be accessible by that code.
        }
                }
            case BINARY_OPERATOR:
                }
                // some binary operators support nulls, we handle them separate
     * invokeDynamic bootstrap method
     * <p>
                if (args.length == 0) {
                    MethodType.methodType(boolean.class, Class.class, Object.class)
            int flavor,
                return new PIC(painlessLookup, functions, constants, methodHandlesLookup, name, type, initialDepth, flavor, args);
                MEGAMORPHIC_LOOKUP = mh.asType(mh.type().changeReturnType(MethodHandle.class));
                return new MIC(name, type, initialDepth, flavor, flags);
                throw new BootstrapMethodError("The receiver type (1st arg) of invokedynamic descriptor must be Object.");
                    return Def.lookupArrayStore(receiver);
 */
                        return binary;
    /** static bootstrap parameter indicating a dynamic method reference, e.g. foo::bar */
                        return lookup(flavor, name, receiverType).asType(type);
                mh = MethodHandles.filterArguments(
            setTarget(guard);
            super(type);
        ) {
        }
    /** static bootstrap parameter indicating a dynamic iteration, e.g. for (x : y) */
 * dynamic field load (getter), and dynamic field store (setter), dynamic array load,
        int depth; // pkg-protected for testing
                    );
 * KIND, either express or implied.  See the License for the
            }
                    } else if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0) {
     * CallSite that implements the polymorphic inlining cache (PIC).
        }
}
         * megamorphic cache using {@link ClassValue}).
         * as the cached class
                } else {
         * are the same as the cached receiver and first argument.
            }
     * </ul>
                }
                target = target.asType(type);
 */
     * ClassValue.getFromHashMap will wrap checked exceptions with Errors. To get
                    throw new BootstrapMethodError("Illegal parameter for reference call: " + args[0]);
                MethodHandle mh = publicMethodHandlesLookup.findVirtual(
                        binaryTest.type().changeParameterType(0, type.parameterType(0)).changeParameterType(1, type.parameterType(1))
 * When a new type is encountered at the call site, we lookup from the appropriate
                // we revert the whole cache and build a new megamorphic one
    }
    /**
                final Class<?> receiver = callArgs[0].getClass();
         * as the cached first argument.
            case UNARY_OPERATOR:
 * Licensed to Elasticsearch under one or more contributor
    /** static bootstrap parameter indicating a unary math operator, e.g. ~foo */
 * license agreements. See the NOTICE file distributed with
 */
                if (type.parameterType(1) != Object.class) {
                }
     */
     *   <li>{@code initialDepth}: initial call site depth. this is used to exercise megamorphic fallback.
                    MethodHandle unary = DefMath.lookupUnary(args[0].getClass(), name);
    }
        private WrappedCheckedException(Exception cause) {
            MethodHandles.Lookup methodHandlesLookup,
                depth++;
         * as the cached class
        /**
                return target.invokeWithArguments(callArgs);
 * Modifications Copyright OpenSearch Contributors. See
                String recipe = (String) args[0];
        MethodType type,
                if (args.length > 0) {
     * <ul>
        Object fallback(Object[] args) throws Throwable {
                case STORE:
                @Override
         * Called when a new type is encountered or if cached type does not match.
                        throw new AssertionError();
            }
        private static final MethodHandle CHECK_RHS;
            return MethodHandles.foldArguments(MethodHandles.exactInvoker(type), MEGAMORPHIC_LOOKUP.bindTo(megamorphicCache));
                throw new AssertionError(e);
        PIC(
import org.opensearch.painless.lookup.PainlessLookup;
     * may require {@link MethodHandles#explicitCastArguments}, depending on types seen.
            MethodHandle fallback = FALLBACK.bindTo(this).asCollector(Object[].class, type.parameterCount()).asType(type);
                    // case 3: check both receiver and argument
                    "fallback",
            final MethodHandles.Lookup methodHandlesLookup = MethodHandles.lookup();
                );
                throw new AssertionError(e);
                    } else {
                int flags = (int) args[0];
            return target.invokeWithArguments(args);
                // static cast to the return type
            }
 * You may obtain a copy of the License at
            } else {
                MethodHandle test = CHECK_CLASS.bindTo(receiver);
    static final class PIC extends MutableCallSite {
 * ownership. Elasticsearch licenses this file to you under
            PainlessLookup painlessLookup,
                }
                    return Def.lookupGetter(painlessLookup, receiver, name);
        }
 * SPDX-License-Identifier: Apache-2.0
     *   <li>{@code args}: flavor-specific args.
            initialized = true;
                CHECK_LHS = methodHandlesLookup.findStatic(
                    test = unaryTest.asType(unaryTest.type().changeParameterType(0, type.parameterType(0)));
            case SHIFT_OPERATOR:
            try {
                    // case 1: only the receiver is unknown, just check that
            if (initialDepth > 0) {
                    // we just don't need it anywhere else.
            } else if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0) {
                    }
                        unary = DefMath.cast(args[0].getClass(), unary);
                case REFERENCE:
 */
        }
        private static final MethodHandle MEGAMORPHIC_LOOKUP;
                    return Def.lookupReference(painlessLookup, functions, constants, methodHandlesLookup, (String) args[0], receiver, name);
 * shift operator, and dynamic array index normalize.
     *   <li>{@code flavor}: type of dynamic call it is (and which part of allowlist to look at).
         */
 * <p>
            return target;
                    );
    /**
                // dynamic cast to the receiver's type
                    return Def.lookupSetter(painlessLookup, receiver, name);
                guard = MethodHandles.catchException(guard, NullPointerException.class, handler);
                } else if (type.parameterType(0) != Object.class) {
         * In that case we revert to a generic, but slower operator handling.
        /**
            return receiver.getClass() == clazz;
                    MethodType.methodType(Object.class, Object[].class)
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**
    /**
                // caching defeated
 * this work for additional information regarding copyright
                    // case 2: only the argument is unknown, just check that
            case ARRAY_LOAD:
            if (flavor == BINARY_OPERATOR && (flags & OPERATOR_ALLOWS_NULL) != 0) {
        }
                    return Def.lookupArrayLoad(receiver);
 * this file be licensed under the Apache-2.0 license or a
            super(type);
                    methodHandlesLookup.lookupClass(),
        }
                throw new BootstrapMethodError("Illegal static bootstrap parameter for flavor: " + flavor);
                setTarget(generic.asType(type()));
    static final class MIC extends MutableCallSite {
            super(cause);
        private MethodHandle lookup(int flavor, String name, Class<?> receiver) throws Throwable {
        FunctionTable functions,
            this.flavor = flavor;
 * Has 11 flavors (passed as static bootstrap parameters): dynamic method call,
                case ARRAY_STORE:
        }
            this.methodHandlesLookup = methodHandlesLookup;
 * allowlist, and cache with a guard. If we encounter too many types, we stop caching.
            } catch (ReflectiveOperationException e) {
                    methodHandlesLookup.lookupClass(),
        }
            }
    public static final int INDEX_NORMALIZE = 10;
            this.functions = functions;
     * may require {@link MethodHandles#explicitCastArguments}, or a dynamic cast
     * static bootstrap parameter indicating an explicit cast to the return type.
                }
                    return Def.lookupMethod(painlessLookup, functions, constants, methodHandlesLookup, type(), receiver, name, args);
package org.opensearch.painless;
     */
                test = receiverTest.asType(receiverTest.type().changeParameterType(0, type.parameterType(0)));
 * <p>
                );
                    test = binaryTest.asType(
            this.constants = constants;
         */
                }
            MethodHandle guard = MethodHandles.guardWithTest(test, target, getTarget());
        }
    /**
            }
        private boolean initialized;
    /** static bootstrap parameter indicating a binary math operator, e.g. foo / bar */
    public static final int SHIFT_OPERATOR = 9;
            }
                    // shifts are treated as unary, as java allows long arguments without a cast (but bits are ignored)
         * Does a slow lookup against the allowlist.
            String name,
         * types at this call site and given up on caching using this fallback and we switch to a
                case ARRAY_LOAD:
 * the Apache License, Version 2.0 (the "License"); you may
                );
            final MethodType type = type();
            } else {
        private static final MethodHandle FALLBACK;
import java.lang.invoke.MethodType;
                int numLambdas = recipe.length();
         */
                final MethodHandle target = this.createMegamorphicHandle();
            case STORE:
import java.lang.invoke.CallSite;
                if (args[0] instanceof Integer == false) {
                    throw new AssertionError();
            return rightObject.getClass() == right;
                }
            if (depth >= MAX_DEPTH) {
     */
                        return lookupGeneric(); // can handle nulls, casts if supported
            final ClassValue<MethodHandle> megamorphicCache = new ClassValue<MethodHandle>() {
            // operators get monomorphic cache, with a generic impl for a fallback
                exc.initCause(e);
                    MethodHandle binaryTest = CHECK_BOTH.bindTo(clazz0).bindTo(clazz1);
         * Creates the {@link MethodHandle} for the megamorphic call site
            case ITERATOR:
            this.flags = flags;
                    test = unaryTest.asType(
                setTarget(target);
    /** static bootstrap parameter indicating a dynamic array load, e.g. baz = foo[bar] */
            FunctionTable functions,
                    throw new AssertionError();
                CHECK_RHS = methodHandlesLookup.findStatic(
            final MethodHandles.Lookup methodHandlesLookup = MethodHandles.lookup();
         */
     * CallSite that implements the monomorphic inlining cache (for operators).
 *
        int initialDepth,
    /** static bootstrap parameter indicating a dynamic load (getter), e.g. baz = foo.bar */
            }
                        if ((flags & OPERATOR_EXPLICIT_CAST) != 0) {
    public static final int ITERATOR = 5;
                initialized = true;
        private final Object[] args;
            this.name = name;
                }
            };
    public static final int LOAD = 1;
                    methodHandlesLookup.lookupClass(),
/*
                case UNARY_OPERATOR:
        /**
                        unaryTest.type().changeParameterType(0, type.parameterType(0)).changeParameterType(1, type.parameterType(1))
        }
                    methodHandlesLookup.lookupClass(),
                FALLBACK = methodHandlesLookup.findVirtual(
 * dynamic array store, iterator, method reference, unary operator, binary operator,
            case REFERENCE:
        private final Map<String, Object> constants;
                MethodHandle guard = MethodHandles.guardWithTest(test, target, getTarget());
                            binary = DefMath.cast(type().returnType(), binary);
         * using {@link ClassValue} and {@link MethodHandles#exactInvoker(MethodType)}:
                case ITERATOR:
                target = DefMath.dynamicCast(target, type().returnType());
        private final PainlessLookup painlessLookup;
                    throw new BootstrapMethodError("Illegal parameter for method call: " + args[0]);
         */
        private MethodHandle lookupGeneric() {
                    throw new BootstrapMethodError("This parameter is only supported for BINARY_OPERATORs");
                    throw new BootstrapMethodError("Illegal static bootstrap parameters for flavor: " + flavor);
        private static final MethodHandle FALLBACK;
            switch (flavor) {
                case SHIFT_OPERATOR:
                default:
            try {
                return target.invokeWithArguments(callArgs);
        static final int MAX_DEPTH = 5;
                    MethodType.methodType(boolean.class, Class.class, Class.class, Object.class, Object.class)
    public static final int OPERATOR_COMPOUND_ASSIGNMENT = 1 << 1;
                    }
 * Unless required by applicable law or agreed to in writing,
    }
        int flavor,
        static boolean checkRHS(Class<?> left, Class<?> right, Object leftObject, Object rightObject) {
/*
                if (args.length != numLambdas + 1) {
     * to cast back to the receiver's type, depending on types seen.
 * specific language governing permissions and limitations
import org.opensearch.common.SuppressForbidden;
                    MethodType.methodType(Object.class, Class.class)
/*
                Class<?> clazz1 = args[1] == null ? null : args[1].getClass();
     * <p>
                    methodHandlesLookup.lookupClass(),
                case BINARY_OPERATOR:
                    // we just don't need it anywhere else.
         */
                            default -> Def.rethrow(t);
                    throw new BootstrapMethodError("Invalid number of parameters for reference call");
            return leftObject.getClass() == left && rightObject.getClass() == right;
// NOTE: this class must be public, because generated painless classes are in a different classloader,
                        switch (t) {
                    methodHandlesLookup.lookupClass(),
 * not use this file except in compliance with the License.
                if (args[0] instanceof String == false) {
         */
        private final int flavor;
import java.lang.invoke.MethodHandles;
                    MethodType.methodType(boolean.class, Class.class, Object.class)
            this.flavor = flavor;
public final class DefBootstrap {
 * GitHub history for details.
                    "checkBoth",
        String name,
        }
    public static final int ARRAY_STORE = 4;
    /** static bootstrap parameter indicating a shift operator, e.g. foo &gt;&gt; bar */
 *
            }
                CHECK_CLASS = methodHandlesLookup.findStatic(
     * see https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.invokedynamic
            try {
        }
    /** static bootstrap parameter indicating a dynamic array store, e.g. foo[bar] = baz */
                }
                    return Def.lookupIterator(receiver);
                protected MethodHandle computeValue(Class<?> receiverType) {
                throw exc;
        @SuppressForbidden(reason = "slow path")
                if (args.length != 1) {
                // unary operator
         * guard method for inline caching: checks the first argument is the same
            MethodHandle target = DefMath.lookupGeneric(name);
                        unary = DefMath.cast(type().returnType(), unary);
        Object fallback(final Object[] callArgs) throws Throwable {
    public static final int OPERATOR_EXPLICIT_CAST = 1 << 2;
                    ClassValue.class,
                }
            }
import java.lang.invoke.MutableCallSite;
            if (initialized) {
        PainlessLookup painlessLookup,
                    throw new BootstrapMethodError("Invalid number of parameters for operator call");
        static {
            } catch (WrongMethodTypeException e) {
 * Based on the cascaded inlining cache from the JSR 292 cookbook
    public static final int BINARY_OPERATOR = 8;
         * guard method for inline caching: checks the receiver's class is the same
                            case Exception e -> throw new WrappedCheckedException(e);
            if (flavor == BINARY_OPERATOR || flavor == SHIFT_OPERATOR) {
    /**
                    "checkClass",
    public static final int ARRAY_LOAD = 3;
 * compatible open source license.
            this.name = name;
    /**
        @SuppressForbidden(reason = "slow path")
                    throw new BootstrapMethodError("This parameter is only supported for BINARY/SHIFT_OPERATORs");
     * around that we wrap any checked exceptions with this RuntimeException and
                }
                if (args[0] instanceof String == false) {
            this.depth = initialDepth;
                    if ((flags & OPERATOR_EXPLICIT_CAST) != 0) {
            if (type.parameterType(0) != Object.class) {
            // we wrap + with an NPE catcher, and use our generic method in that case.
        Object... args
                    }
        // validate arguments
            case LOAD:
        /**
                );
            setTarget(fallback);
            if ((flags & OPERATOR_EXPLICIT_CAST) != 0) {
    public static final int STORE = 2;
        private final String name;
    public static final int METHOD_CALL = 0;
         * guard method for inline caching: checks the receiver's class is the same
     * <p>
     * static bootstrap parameter indicating the binary operator allows nulls (e.g. == and +)
                if (numLambdas > type.parameterCount()) {
     * static bootstrap parameter indicating the binary operator is part of compound assignment (e.g. +=).
                FALLBACK = methodHandlesLookup.findVirtual(
                MethodHandle generic = lookupGeneric();
 * The OpenSearch Contributors require contributions made to
            }
        private static final MethodHandle CHECK_BOTH;
            } catch (ReflectiveOperationException e) {
    /**
                    mh,
        private final FunctionTable functions;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * <p>
            case INDEX_NORMALIZE:
        Map<String, Object> constants,
        private MethodHandle lookup(Object[] args) throws Throwable {
                    "fallback",
    // NOTE: these must be primitive types, see https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.invokedynamic
                case METHOD_CALL:
                target = DefMath.dynamicCast(target);
        private final int flavor;
                Exception exc = new ClassCastException("Cannot cast from: " + target.type().returnType() + " to " + type.returnType());
                    if (args[0] == null || args[1] == null) {
    /** static bootstrap parameter indicating a dynamic method call, e.g. foo.bar(...) */
                    MethodHandle unaryTest = CHECK_LHS.bindTo(clazz0);
                    "get",
                            binary = DefMath.cast(args[0].getClass(), binary);
            final MethodHandle test;
        /**
                        MethodHandle binary = DefMath.lookupBinary(args[0].getClass(), args[1].getClass(), name);
        /** maximum number of types before we go megamorphic */
 * software distributed under the License is distributed on an
 * Painless invokedynamic bootstrap for the call site.
    public static final int REFERENCE = 6;
                    MethodType.methodType(Object.class, Object[].class)
        }
                    publicMethodHandlesLookup.findVirtual(Object.class, "getClass", MethodType.methodType(Class.class))
                case LOAD:
/**
     * <p>
        private final String name;
    ) {
                    "checkRHS",
            // "function-call" like things get a polymorphic cache
     * unwrap them later.
                case INDEX_NORMALIZE:
        }
    /** static bootstrap parameter indicating a dynamic store (setter), e.g. foo.bar = baz */
                return new PIC(painlessLookup, functions, constants, methodHandlesLookup, name, type, initialDepth, flavor, args);
                    throw new BootstrapMethodError("Illegal recipe for method call: too many bits");
        /**
     * the fallback if a null is encountered.
            // for math operators: WrongMethodType can be confusing. convert into a ClassCastException if they screw up.
    public static final int OPERATOR_ALLOWS_NULL = 1 << 0;
                );
import org.opensearch.painless.symbol.FunctionTable;
                    return Def.lookupIndexNormalize(receiver);
                    return unary;
                default:
                    MethodType.methodType(boolean.class, Class.class, Class.class, Object.class, Object.class)
    @SuppressWarnings("unchecked")
                );
            this.painlessLookup = painlessLookup;
                );
        private static final MethodHandle CHECK_LHS;
     */
        static boolean checkBoth(Class<?> left, Class<?> right, Object leftObject, Object rightObject) {
                return generic.invokeWithArguments(args);
        MethodHandles.Lookup methodHandlesLookup,
            Object[] args
                return new PIC(painlessLookup, functions, constants, methodHandlesLookup, name, type, initialDepth, flavor, args);
                if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0 && flavor != BINARY_OPERATOR && flavor != SHIFT_OPERATOR) {
         * Does a slow lookup for the operator
        }
        MIC(String name, MethodType type, int initialDepth, int flavor, int flags) {
        private final MethodHandles.Lookup methodHandlesLookup;
                        } else if ((flags & OPERATOR_COMPOUND_ASSIGNMENT) != 0) {
                }
    private DefBootstrap() {} // no instance!
                if (args.length != 1) {
        static boolean checkLHS(Class<?> clazz, Object leftObject) {
import java.lang.invoke.WrongMethodTypeException;
     */
                );
                final MethodHandle target = lookup(flavor, name, receiver).asType(type());
    /** static bootstrap parameter indicating a request to normalize an index for array-like-access */
                    try {
    public static CallSite bootstrap(
         */
            final MethodHandles.Lookup publicMethodHandlesLookup = MethodHandles.publicLookup();
        static boolean checkClass(Class<?> clazz, Object receiver) {
                        }
            case ARRAY_STORE:
     */
     * requires additional {@link MethodHandles#catchException} guard, which will invoke
import java.lang.invoke.MethodHandle;
            MethodType type,
                    1,
                        }
    public static final int UNARY_OPERATOR = 7;
import java.util.Map;
                    throw new BootstrapMethodError("Illegal parameter for reference call: " + args[0]);
         * Called when a new type is encountered (or, when we have encountered more than {@code MAX_DEPTH}
    // constants for the flags parameter of operators
                if ((flags & OPERATOR_ALLOWS_NULL) != 0 && flavor != BINARY_OPERATOR) {
                setTarget(guard);
            final MethodType type = type();
                    } catch (Throwable t) {
                    throw new BootstrapMethodError("Invalid number of parameters for method call");
         */
                CHECK_BOTH = methodHandlesLookup.findStatic(
                MethodHandle handler = MethodHandles.dropArguments(lookupGeneric().asType(type()), 0, NullPointerException.class);
            }
        /**
 * <p>
            Map<String, Object> constants,
            case METHOD_CALL:
         * guard method for inline caching: checks the receiver's class and the first argument
                    "checkLHS",
            this.args = args;
 * (https://code.google.com/archive/p/jsr292-cookbook/, BSD license)
 * under the License.
                MethodHandle receiverTest = CHECK_LHS.bindTo(args[0].getClass());
                Class<?> clazz0 = args[0] == null ? null : args[0].getClass();
            MethodHandle fallback = FALLBACK.bindTo(this).asCollector(Object[].class, type.parameterCount()).asType(type);
     * In addition to ordinary parameters, we also take some parameters defined at the call site:
        switch (flavor) {
        /**
        static {
     * And we take the {@link PainlessLookup} used to compile the script for allowlist checking.
            // very special cases, where even the receiver can be null (see JLS rules for string concat)
    }
    static final class WrappedCheckedException extends RuntimeException {
        private static final MethodHandle CHECK_CLASS;
                    throw new BootstrapMethodError("Illegal number of parameters: expected " + numLambdas + " references");
        private MethodHandle createMegamorphicHandle() {
