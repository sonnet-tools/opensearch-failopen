                    return index < array.length;
    }
     * so we simply need to lookup the matching implementation method based on receiver type.
    /** pointer to Iterable.iterator() */  
     * <p>  
                throw new IllegalArgumentException(  
            if (painlessMethod == null) {
            }  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
                }  
        return switch (value) {
            return (byte) (char) value;  
                float[].class,  
                public Character next() {  
                    + "] to "  
    @SuppressWarnings("unchecked")  
            case Integer intValue -> intValue;
                        type,
            case Short i -> (int) i;
    public static String defToStringImplicit(final Object value) {
        } else {
        } else {
                        PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass(),  
                long[].class,
                int[].class,
            );
                MethodHandle filter;
        }
     * @throws IllegalArgumentException if no matching allowlisted method was found.  
            throw new ClassCastException(
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        static int getArrayLength(final double[] array) {
        return switch (value) {
        static int normalizeIndex(final int[] array, final int index) {
            // method handle contains the "this" pointer so start injections at 1
            );  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
    }
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        Map<String, Object> constants,
    /** Helper class for isolating MethodHandles and methods to get iterators over arrays
                return MethodHandles.insertArguments(LIST_GET, 1, index);  
                    + Long.class.getCanonicalName()
        } else {
            methodHandlesLookup,
     * until it finds a matching allowlisted getter. If one is not found, it throws an exception.
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            );
        } else {
            case Integer i -> i;  
                @Override
        return switch (value) {  
        }
            return new Iterator<Object>() {  
            LIST_SET = methodHandlesLookup.findVirtual(List.class, "set", MethodType.methodType(Object.class, int.class, Object.class));
                    + Byte.class.getCanonicalName()  
        int numArguments = callSiteType.parameterCount();  
                int index = 0;
    /**  
                }
            throw new ClassCastException(
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * Returns a method handle to do iteration (for enhanced for loop)
                short[].class,  
        private ArrayLengthHelper() {}
        if (receiverClass.isArray()) {
 * The OpenSearch Contributors require contributions made to  
                }
     * </ul>
            case Byte byteValue -> byteValue;
 * compatible open source license.
            case Long l -> (double) l;
            case Character charValue -> charValue;
            return null;
     * Otherwise it returns a handle to the matching setter.
    }
                int separator2 = signature.indexOf(',');
                    return PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(
     * This method traverses {@code recieverClass}'s class hierarchy (including interfaces)
                    filter = lookupReferenceInternal(
                    + byte.class.getCanonicalName()  
        Class<?> interfaceType = painlessLookup.canonicalTypeNameToType(interfaceClass);
                    + "] to "
        }
            return (long) (char) value;
 * license agreements. See the NOTICE file distributed with
    private static final MethodHandle LIST_GET;  
                        "iterator",
     * </p>  
     */
                        0,  
        } else if (value instanceof Character charValue) {
                "cannot implicitly cast "  
package org.opensearch.painless;
                        "getArrayLength",
            throw new ClassCastException(
                    + boolean.class.getCanonicalName()
        PainlessMethod interfaceMethod = painlessLookup.lookupFunctionalInterfacePainlessMethod(interfaceType);  
                    + "def ["
                    return array[index++];
     * </p>
                @Override  
        }
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            // maps allow access like mymap[key]
     * @param painlessLookup the allowlist
            );
import org.opensearch.painless.lookup.PainlessLookupUtility;
    }
        final MethodHandles.Lookup methodHandlesLookup = MethodHandles.publicLookup();
        if (value == null) {  
            default -> throw new ClassCastException(
                }
        }
     * Looks up handle for a dynamic method call, with lambda replacement
 * <p>
            Stream.of(  
            return charValue;  
                }  
 * Dynamic types can invoke methods, load/store fields, and be passed as parameters to operators without  
                }  
            return ArrayIteratorHelper.newIterator(receiverClass);  
                handle = MethodHandles.collectArguments(handle, i, filter);
            MethodHandle handle = painlessMethod.methodHandle;  
            return array.length;
                public Double next() {
            );
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     */
        // special case: maps, and lists
     * @return pointer to matching method to invoke. never returns null.
                    return PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
import java.lang.invoke.CallSite;  
                }  
                    return index < array.length;  
                try {
            return new Iterator<Boolean>() {
                MethodHandles.class,
            }  
     * @throws Throwable if a method reference cannot be converted to an functional interface
        String name,
     * <p>
import org.opensearch.painless.lookup.PainlessLookup;
        };
            return getter;
            return stringValue;
            throw new ClassCastException(
                    + "def ["  
     */
                char[].class,  
import java.lang.invoke.MethodHandle;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
 * under the License.  
        }  
            ref.delegateMethodType,  
            functions,
                ? ARRAY_TYPE_MH_MAPPING.get(arrayType)  
                    filter = nested.dynamicInvoker();
        }
            return index >= 0 ? index : index + array.length;
                throw new IllegalArgumentException("Illegal list shortcut value [" + name + "].");
            return byteValue;
            );
 * for each new type encountered will query a corresponding {@code lookupXXX} method to retrieve the appropriate
                    + "] to "
        } else {
            return array.length;
            case Character c -> (int) c;
            1
        } else if (Map.class.isAssignableFrom(receiverClass)) {
            throw new ClassCastException(  
                short[].class,  
                } else {
        static MethodHandle arrayIndexNormalizer(Class<?> arrayType) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    }  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            return index >= 0 ? index : index + array.length;
import java.util.Iterator;  
            );
    /**
                        constants,
        PainlessMethod method = painlessLookup.lookupRuntimePainlessMethod(receiverClass, name, arity);
     * </p>
                public boolean hasNext() {
    static MethodHandle lookupIndexNormalize(Class<?> receiverClass) {
        // lookup up the factory for arraylength MethodHandle (intrinsic) from Java 9:
        if (receiverClass.isArray()) {
                    // we have everything.  
    /** Returns a method handle to an implementation of clazz, given method reference signature. */  
            return index >= 0 ? index : index + array.length;
            case Integer intValue -> intValue;  
        if (value instanceof Byte byteValue) {
            return null;  
                int[].class,  
            default -> throw new ClassCastException(
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
                    );  
            }
 * GitHub history for details.
    public static boolean defToboolean(final Object value) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        if (value instanceof Character charValue) {
        if (value == null) {
            "Attempting to address a non-array type " + "[" + receiverClass.getCanonicalName() + "] as an array."
                "cannot explicitly cast "
        upTo = 1;  
                        DefBootstrap.REFERENCE,
                    + Short.class.getCanonicalName()  
                "cannot explicitly cast "
 * software distributed under the License is distributed on an
                @Override
            PainlessLookupUtility.typeToCanonicalTypeName(implMethod.targetClass),  
                "cannot implicitly cast "
            );  
        static Iterator<Character> iterator(final char[] array) {
public final class Def {
                    + short.class.getCanonicalName()
            return (char) ((Number) value).intValue();
                "cannot explicitly cast "
            return null;  
        }  
                }
    private static MethodHandle lookupReferenceInternal(
                    throw new AssertionError(e);  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
                        PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass(),
                } catch (ReflectiveOperationException e) {
        int replaced = 0;
        }  
            if (!arrayType.isArray()) {
    public static float defTofloatImplicit(final Object value) {  
        return switch (value) {
            case Double v -> v;  
    public static Double defToDoubleExplicit(final Object value) {
            return new Iterator<Long>() {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * Methods to normalize array indices to support negative indices into arrays stored in {@code def}s.
                    + Byte.class.getCanonicalName()  
            case Short i -> (float) i;  
            return setter;
        }  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        static Iterator<Float> iterator(final float[] array) {  
            }
     * <p>
            return array.length;
        } else if (value instanceof Character) {
                    return array[index++];
        } else if (value instanceof Boolean boolValue) {  
            return array.length;
        String name
            );  
            return ((Number) value).intValue();
            // maps allow access like mymap.key  
                        + name
 *
            return null;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
    /** pointer to Map.put(Object,Object) */  
                    + "] to "
     * Otherwise it returns a handle to the matching getter.  
                    + "def ["  
            ref.isDelegateAugmented ? 1 : 0,
     * A dynamic field store for variable {@code x} of type {@code def} looks like:  
 * this file be licensed under the Apache-2.0 license or a
                    return array[index++];  
 * Dynamic methods, loads, stores, and array/list/map load/stores involve locating the appropriate field  
                handle = MethodHandles.insertArguments(handle, 1, injections);
        );
        MethodHandles.Lookup methodHandlesLookup,
        if (value == null) {  
                throw new AssertionError(t);  
            return LIST_INDEX_NORMALIZE;  
            // maps allow access like mymap.key
        }  
        };  
                "cannot explicitly cast "
                public Short next() {  
 * KIND, either express or implied.  See the License for the
            return (float) (char) value;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        // e.g. f(a, g(x), b, h(y), i()) looks like f(a, g, x, b, h, y, i).  
            return MAP_INDEX_NORMALIZE;
            handle = MethodHandles.insertArguments(handle, 1, injections);
            return ((Number) value).intValue();
        }
                        MethodType.methodType(int.class, type, int.class)  
        static int normalizeIndex(final boolean[] array, final int index) {
    /**
    }
        return index;  
            MAP_INDEX_NORMALIZE = methodHandlesLookup.findStatic(  
                        constants,
    private static final class ArrayIndexNormalizeHelper {
                @Override
            // wire 'key' as a parameter, its a constant in painless
 */  
    }
                int index = 0;  
                    + "] to "
                    + "] to "
        }
        } else {  
    public static Long defToLongImplicit(final Object value) {
        if (value instanceof Character charValue) {  
                        PainlessLookupUtility.typeToCanonicalTypeName(interfaceType)
        if (implMethod == null) {  
                long[].class,
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
    /**  
    /** pointer to {@link Def#mapIndexNormalize}. */
            throw new ClassCastException(
            );
                    + "] to "  
        }
    }  
        } else if (isNumber(value)) {
            }  
     * Looks up handle for a dynamic field getter (field load)  
                    + "] to "  
    public static float defTofloatExplicit(final Object value) {
            throw new ClassCastException(  
            throw new ClassCastException(  
            return charValue;  
                }
            ).collect(Collectors.toMap(Function.identity(), type -> {
        } else if (value instanceof Character charValue) {  
        Class<?> receiverClass,  
     */  
 * ownership. Elasticsearch licenses this file to you under  
    /** pointer to {@link Def#listIndexNormalize}. */
                public Boolean next() {
            Stream.of(
            );  
        }
        PainlessLookup painlessLookup,
                : OBJECT_ARRAY_MH.asType(OBJECT_ARRAY_MH.type().changeParameterType(0, arrayType));  
                "cannot implicitly cast "  
                "cannot implicitly cast "
                @Override
     * A dynamic method call for variable {@code x} of type {@code def} looks like:
        if (interfaceMethod == null) {
            return MAP_PUT;  
        }
            ITERATOR = methodHandlesLookup.findVirtual(Iterable.class, "iterator", MethodType.methodType(Iterator.class));
                        painlessLookup,  
            return LIST_GET;
                    + "def ["
            );
 * Licensed to Elasticsearch under one or more contributor  
                boolean[].class,
            );  
            case Byte byteValue -> byteValue;  
                    + "def ["
        }
 * Support for dynamic type (def).
        }
                    + "def ["
        } else if (value instanceof Character) {
    }
        static Iterator<Boolean> iterator(final boolean[] array) {  
                byte[].class,
            LIST_INDEX_NORMALIZE = methodHandlesLookup.findStatic(
            );  
 * caching ({@link DefBootstrap}) generally works: usually all objects at any call site will be consistently
        } else {
        if (setter != null) {
        if (value == null) {
        }
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
                    + "def ["
/**  
        }
        static Iterator<Byte> iterator(final byte[] array) {
                replaced += numCaptures;  
        } else {
        } else if (isNumber(value)) {
            return new Iterator<Float>() {
                    );
import java.lang.invoke.MethodType;  
        MethodHandle setter = painlessLookup.lookupRuntimeSetterMethodHandle(receiverClass, name);
                    return array[index++];
                public Object next() {  
 * Modifications Copyright OpenSearch Contributors. See
        static int getArrayLength(final int[] array) {
    // TODO: Once Java has a factory for those in java.lang.invoke.MethodHandles, use it:
    }  
     */
    public static short defToshortImplicit(final Object value) {  
        if (value == null) {
    public static byte defTobyteImplicit(final Object value) {
                        functions,
            constants,  
                    + "] to "
        static int normalizeIndex(final long[] array, final int index) {
        }
    /**
        } else if (List.class.isAssignableFrom(receiverClass)) {  
 */  
                        "normalizeIndex",
                    + Double.class.getCanonicalName()  
     *   <li>Allowlisted method named {@code isField()} from receiver's class/superclasses/interfaces.
                int separator = signature.lastIndexOf('.');  
                    return array[index++];
     * Returns a method handle to do an array store.
                "cannot explicitly cast "  
    ) throws Throwable {  
    private static final MethodHandle LIST_SET;
            return ((Number) value).floatValue();
    }
     * @param receiverClass Class of the array to store the value in  
            case Character charValue -> charValue;
        if (receiverClass.isArray()) {  
        private ArrayIndexNormalizeHelper() {}
    private static final MethodHandle MAP_GET;
    }
            return (char) ((Number) value).intValue();  
                    + Float.class.getCanonicalName()
     * @param painlessLookup the allowlist  
        static MethodHandle arrayLengthGetter(Class<?> arrayType) {
                    + String.class.getCanonicalName()  
        }  
            return ((Number) value).doubleValue();
    public static int listIndexNormalize(final List<?> value, int index) {  
import org.opensearch.painless.symbol.FunctionTable;
     *   to use with array loads and array stores  
            throw new ClassCastException(
        } else if (value instanceof Short shortValue) {  
            case Byte b -> (double) b;  
        }
                // decode signature of form 'type.call,2'
            };
                    + char.class.getCanonicalName()
    public static Integer defToIntegerImplicit(final Object value) {  
        } else if (List.class.isAssignableFrom(receiverClass)) {
        if (Iterable.class.isAssignableFrom(receiverClass)) {  
                    + "] to "
                char[].class,  
                "cannot explicitly cast "
                "cannot implicitly cast "
                @Override  
                    return index < array.length;
    public static Boolean defToBoolean(final Object value) {  
                    + "] to "
                        call,
            return (double) (char) value;
        throw new IllegalArgumentException(
 * compile-time type information.
            }
            return ((Number) value).doubleValue();
            try {
                    throw new AssertionError(e);
                rethrow(t);
    static MethodHandle lookupIterator(Class<?> receiverClass) {
    private static final class ArrayLengthHelper {
    }  
            case Integer intValue -> intValue;
                        methodHandlesLookup,
            throw new ClassCastException(
                    + byte.class.getCanonicalName()
        } else {
                return MethodHandles.insertArguments(LIST_SET, 1, index);
                int numCaptures = Integer.parseInt(signature.substring(signature.indexOf(',') + 1));  
                    + short.class.getCanonicalName()
                }
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
        }
                } else if (signature.charAt(0) == 'D') {
        } else if (value instanceof Byte byteValue) {
        }
     * Returns a method handle to do an array load.
            case String stringValue -> stringValue;  
                    + "] to "  
     * @return a MethodHandle that accepts the receiver as first argument, the index as second argument, and returns the normalized index
                Object[].class  
                    + long.class.getCanonicalName()
     */  
            };
            throw new ClassCastException(  
     * negative offsets.  
    static MethodHandle lookupReference(
        }
     * {@code x.method(args...)}
            return index >= 0 ? index : index + array.length;  
        } else {
        return handle;
    }
        static int getArrayLength(final char[] array) {  
            case Double doubleValue -> doubleValue;
                    + Float.class.getCanonicalName()
        String interfaceClass,  
    }
            return MethodHandles.arrayElementGetter(receiverClass);
        }  
            return null;
                Object[].class
        } else if (value instanceof Character charValue) {
        PainlessLookup painlessLookup,
                "cannot explicitly cast "
            case Long longValue -> longValue;  
            } catch (final NumberFormatException exception) {
        } else if (value instanceof Character) {
            return (ARRAY_TYPE_MH_MAPPING.containsKey(arrayType))
     * until it finds a matching allowlisted setter. If one is not found, it throws an exception.  
            return MethodHandles.insertArguments(MAP_GET, 1, name);
                "listIndexNormalize",
                    return index < array.length;
        if (value == null) {
     * <p>
            // lists allow access like mylist.0
    public static Integer defToIntegerExplicit(final Object value) {
        for (int i = 1; i < numArguments; i++) {  
    /** Helper class for isolating MethodHandles and methods to get the length of arrays  
            lambdaArgs.set(recipeString.charAt(i));
            ref.delegateInvokeType,
     * <ul>
            case Character charValue -> charValue;
        if (value instanceof Character) {
        }
                String signature = (String) args[upTo++];
                    + "] to "
        throw new IllegalArgumentException(  
        } else if (isNumber(value)) {  
                try {
     *   <li>Allowlisted {@code field} from receiver's class or any superclasses.
                public boolean hasNext() {
                    // the implementation is strongly typed, now that we know the interface type,
     *   <li>Allowlisted {@code field} from receiver's class or any superclasses.
                    + "def ["
        }  
            );  
            return null;  
                    throw new AssertionError(e);  
            }
    /**
            return byteValue;  
                    }  
        } else if (isNumber(value)) {  
                MethodType.methodType(Object.class, Map.class, Object.class)  
            default -> throw new ClassCastException(
                        MethodType.methodType(Iterator.class, type)
        }
        static MethodHandle newIterator(Class<?> arrayType) {  
     * @param receiverClass Class of the array to load the value from
    ) throws Throwable {  
        String type,
     * This method traverses {@code recieverClass}'s class hierarchy (including interfaces)
     * @return pointer to matching field. never returns null.  
     * (to emulate a "arraystore" bytecode using MethodHandles).
                    + "] to "
            case Float v -> v;
            throw new IllegalArgumentException("Cannot iterate over [" + receiverClass.getCanonicalName() + "]");
                    + "def ["  
            return array.length;  
                @Override
        } else {
                "cannot explicitly cast "
        if (value instanceof Character charValue) {
    }
     * A dynamic field load for variable {@code x} of type {@code def} looks like:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            return array.length;
                    + "def ["  
 * specific language governing permissions and limitations
            return array.length;  
            return (short) (char) value;  
        PainlessLookup painlessLookup,
            ref.delegateClassName,  
                ? ARRAY_TYPE_MH_MAPPING.get(arrayType)
            case Float floatValue -> floatValue;
            // noop so that mymap[key] doesn't do funny things with negative keys  
                @Override  
            default -> throw new ClassCastException(
        private static final MethodHandle OBJECT_ARRAY_MH = ARRAY_TYPE_MH_MAPPING.get(Object[].class);
                    + "] to "
                    + Integer.class.getCanonicalName()
                        + typeToCanonicalTypeName(receiverClass)  
            } catch (Throwable t) {
            };
                // method handle contains the "this" pointer so start injections at 1
            case Character c -> (long) c;
                try {
        } else {  
            case Character c -> (float) c;
            }
    /** factory for arraylength MethodHandle (intrinsic) from Java 9 (pkg-private for tests) */  
        int upTo = 1;
            ref.interfaceMethodType,
     * <p>
            || value instanceof Long
    }
                    + "def ["
                    + "def ["  
        Object[] injections = PainlessLookupUtility.buildInjections(method, constants);
     * (to emulate "enhanced for loop" using MethodHandles). These cause boxing, and are not as efficient  
        }
            return charValue;
            interfaceType,
            return null;  
     * <ul>
            );
            );
    }  
            );
                @Override
        if (value == null) {  
    }
                    + Boolean.class.getCanonicalName()
        // otherwise: first we have to compute the "real" arity. This is because we have extra arguments:
    // Conversion methods for def to primitive types.  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            || value instanceof Double;
            // wire '0' (index) as a parameter, its a constant. this also avoids  
            "Attempting to address a non-array-like type " + "[" + receiverClass.getCanonicalName() + "] as an array."  
                    + String.class.getCanonicalName()  
                        painlessLookup,
    public static Character defToCharacterImplicit(final Object value) {
 * Unless required by applicable law or agreed to in writing,
                public boolean hasNext() {  
            return (short) (char) value;
                        numCaptures  
            }
            methodHandlesLookup,
                int index = 0;  
        );  
        FunctionTable functions,  
import java.lang.invoke.MethodHandles;
import java.util.Collections;
                    + "] to "
    public static Byte defToByteImplicit(final Object value) {
     *   It returns the loaded value.
     *   <li>The value in a list at element {@code field} (integer) when the receiver is a List.
        if (value == null) {
            return charValue;
        if (method == null) {  
        }
                    + Long.class.getCanonicalName()  
                @Override
        static int getArrayLength(final short[] array) {  
            );  
        } else {  
            case Integer i -> (long) i;
                    + "def ["  
        } else if (value instanceof String stringValue) {
            // its a functional reference, replace the argument with an impl
                    CallSite nested = DefBootstrap.bootstrap(
    /**
                        + ", "
        }
    }
        static int normalizeIndex(final char[] array, final int index) {  
     * @return a MethodHandle that accepts the receiver as first argument, the index as second argument,
            return charValue;
        static Iterator<Long> iterator(final long[] array) {
            ).collect(Collectors.toMap(Function.identity(), type -> {
                    return array[index++];  
    }  
            };
                    return index < array.length;
        Class<?> clazz,  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        } else if (isNumber(value)) {
            );
                "cannot implicitly cast "
     * Otherwise it returns a handle to the matching method.
     * @param receiverClass Class of the object to invoke the method on.
    static MethodHandle arrayLengthGetter(Class<?> arrayType) {  
            );
     * @param args bootstrap args passed to callsite
                        nestedType,
        };
    }  
            throw new IllegalArgumentException("Class [" + interfaceClass + "] is not a functional interface");
                    return array[index++];
                    // the interface type is now known, but we need to get the implementation.  
            return (ARRAY_TYPE_MH_MAPPING.containsKey(arrayType))
        // first try allowlist
            || value instanceof Integer
 * You may obtain a copy of the License at  
            return charValue;  
    private static boolean isNumber(final Object value) {
        } else if (isNumber(value)) {  
        throw new IllegalArgumentException(
            case Short shortValue -> shortValue;  
     * Looks up handle for a dynamic field setter (field store)
            return MethodHandles.insertArguments(MAP_PUT, 1, name);  
        }  
        }
                    + "def ["  
     *   <li>The {@code length} field of an array.
            };  
        private ArrayIteratorHelper() {}  
        }  
            return new Iterator<Integer>() {
            default -> throw new ClassCastException(
                filter = MethodHandles.dropArguments(filter, 0, String.class);  
                }
 * the Apache License, Version 2.0 (the "License"); you may
                    + Double.class.getCanonicalName()
            return ((Number) value).floatValue();  
        }  
     * <p>  
        MethodHandles.Lookup methodHandlesLookup,
    static {  
            MAP_PUT = methodHandlesLookup.findVirtual(Map.class, "put", MethodType.methodType(Object.class, Object.class, Object.class));
                    // this is dynamically based on the receiver type (and cached separately, underneath
            default -> throw new ClassCastException(  
        } else {  
     * @param receiverClass Class of the object to retrieve the field from.
        }
 * this work for additional information regarding copyright
                throw new IllegalArgumentException("type must be an array");  
        } else if (isNumber(value)) {
        }
        } else {  
                    + "def ["
                "cannot implicitly cast "
        );
    }
        FunctionTable functions,  
                    + "] to "
                        + "["
        // based on these we can finally link any remaining lambdas that were deferred.  
    public static long defTolongImplicit(final Object value) {
            // parsing the same integer millions of times!  
                throw new IllegalArgumentException("type must be an array");  
     * @param methodHandlesLookup caller's lookup  
        } else if (isNumber(value)) {
                    + "float ["
            return null;  
            return Utility.StringTochar(stringValue);
    public static Long defToLongExplicit(final Object value) {
                "dynamic method [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "/" + arity + "] not found"
        return switch (value) {
        } else {
        }
            case Integer i -> (double) i;  
            ref.factoryMethodType,
            default -> throw new ClassCastException(
                    + "] to "
                    + "def ["  
                    + "def ["  
            return (byte) (char) value;  
            default -> throw new ClassCastException(  
                MethodType.methodType(MethodHandle.class, Class.class)  
        String call,
        }
                throw new IllegalArgumentException("type must be an array");
    }  
                    Class<?>[] captures = new Class<?>[numCaptures];  
import static org.opensearch.painless.lookup.PainlessLookupUtility.typeToCanonicalTypeName;
     * "Normalizes" the idnex into a {@code List} by flipping negative indexes around so they are "from the end" of the list.
            default -> throw new ClassCastException(
                arity -= numCaptures;
                "cannot explicitly cast "
            Stream.of(  
                "arrayLength",
            return handle;
            throw new ClassCastException(  
    }
            );  
        if (value instanceof Boolean boolValue) {  
            // wire '0' (index) as a parameter, its a constant. this also avoids
                    + "] to "
                }
    static MethodHandle lookupSetter(PainlessLookup painlessLookup, Class<?> receiverClass, String name) {  
        throw (T) t;
    }
    }
                    for (int capture = 0; capture < captures.length; capture++) {
                    + "def ["
            );
            arrayLengthMHFactory = methodHandlesLookup.findStatic(  
                    return array[index++];
            return new Iterator<Double>() {
    /**  
                float[].class,
                double[].class,
import java.util.BitSet;
            case Byte b -> (int) b;  
            throw new IllegalArgumentException(
                    MethodType nestedType = MethodType.methodType(interfaceType, captures);
            arrayLengthMHFactory = null;  
                : OBJECT_ARRAY_MH.asType(OBJECT_ARRAY_MH.type().changeParameterType(0, arrayType));
        }  
                public boolean hasNext() {
                        MethodType.methodType(int.class, type)  
     */
            }))
                int index = 0;  
        }  
        }  
    }
            throw new ClassCastException(  
            );
        } catch (final ReflectiveOperationException roe) {
                public boolean hasNext() {  
                    + long.class.getCanonicalName()  
            case Long l -> (float) l;  
    public static Double defToDoubleImplicit(final Object value) {  
            return index >= 0 ? index : index + array.length;
    /**  
     */
        } else if (isNumber(value)) {  
                "cannot implicitly cast "  
    public static int defTointExplicit(final Object value) {  
                "cannot cast "
                        functions,  
        static int getArrayLength(final Object[] array) {  
            MAP_GET = methodHandlesLookup.findVirtual(Map.class, "get", MethodType.methodType(Object.class, Object.class));
                "mapIndexNormalize",
    /** pointer to List.set(int,Object) */
            };  
            throw new ClassCastException(  
            // arrays expose .length as a read-only getter  
    /**
    }
    public static byte defTobyteExplicit(final Object value) {
        }  
        int captures  
            return array.length;
            throw new ClassCastException(  
            case Character c -> (double) c;
        } else {
        // first try allowlist  
        MethodHandle getter = painlessLookup.lookupRuntimeGetterMethodHandle(receiverClass, name);
     * @param receiverClass Class of the object to retrieve the field from.  
                    return index < array.length;
                public boolean hasNext() {
        );  
        // lookup the method with the proper arity, then we know everything (e.g. interface types of parameters).
                    return index < array.length;  
        }  
    /** pointer to List.get(int) */
            return boolValue;
    @SuppressWarnings("unused") // normalizeIndex() methods are are actually used, javac just does not know :)
    public static double defTodoubleExplicit(final Object value) {  
                    );  
                // the filter now ignores the signature (placeholder) on the stack
 */
 * <p>
        BitSet lambdaArgs = new BitSet(recipeString.length());  
            LIST_GET = methodHandlesLookup.findVirtual(List.class, "get", MethodType.methodType(Object.class, int.class));  
     */  
                    + double.class.getCanonicalName()
 */
            ref.delegateInjections  
    public static short defToshortExplicit(final Object value) {
                    + "] to "
        } else if (value instanceof String stringValue) {
        if (value == null) {  
     * @param name Name of the field.
            }
    public static char defTocharImplicit(final Object value) {
     * "Normalizes" the index into a {@code Map} by making no change to the index.  
            case Short shortValue -> shortValue;  
                }
                "cannot implicitly cast "
            return ((Number) value).shortValue();
 *  
                "cannot explicitly cast "  
            );  
     */
        // https://bugs.openjdk.java.net/browse/JDK-8156915  
                    return index < array.length;  
            case null -> null;
                "cannot explicitly cast "
            };
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            return new Iterator<Character>() {  
        } else if (Map.class.isAssignableFrom(receiverClass)) {
            return ((Number) value).byteValue();
     * <p>  
        FunctionTable functions,
            PainlessMethod painlessMethod = painlessLookup.lookupRuntimePainlessMethod(receiverClass, name, numArguments - 1);  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
     * </p>
                Object[].class  
                "dynamic method [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "/" + arity + "] not found"
            case Short i -> (double) i;
     * <p>
                    + "] to "
    }
                MethodType.methodType(int.class, List.class, int.class)
            if (lambdaArgs.get(i - 1)) {  
                int index = 0;
                double[].class,
            case Long longValue -> longValue;
            case Float floatValue -> floatValue;
 * single time, but simplicity is still more valuable than performance in this code.  
                    + char.class.getCanonicalName()
                "cannot implicitly cast "  
        };
                }
        }
     * until it finds a matching allowlisted method. If one is not found, it throws an exception.  
                        methodHandlesLookup,  
        private static final Map<Class<?>, MethodHandle> ARRAY_TYPE_MH_MAPPING = Collections.unmodifiableMap(
                int[].class,
    private static final MethodHandle MAP_PUT;
     * @return a MethodHandle that accepts the receiver as first argument, the index as second argument.  
     * @throws IllegalArgumentException if no matching allowlisted field was found.  
        } else if (isNumber(value)) {  
            case Long l -> l;  
            case Short i -> i;  
    /** Hack to rethrow unknown Exceptions from {@link MethodHandle#invokeExact}: */
        } else if (isNumber(value)) {  
            return new Iterator<Byte>() {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
                    );
        } else {
            return index >= 0 ? index : index + array.length;  
        JAVA9_ARRAY_LENGTH_MH_FACTORY = arrayLengthMHFactory;
                    + byte.class.getCanonicalName()
        MethodHandle arrayLengthMHFactory;
                if (signature.charAt(0) == 'S') {
        static int getArrayLength(final long[] array) {
     * The following field stores are allowed:  
            throw new ClassCastException(
    public static String defToStringExplicit(final Object value) {
            case Long longValue -> longValue;  
            );
     * Returns a method handle to normalize the index into an array. This is what makes lists and arrays stored in {@code def} support
        static int normalizeIndex(final double[] array, final int index) {
     */  
            throw new IllegalArgumentException("type [" + interfaceClass + "] not found");
            case Byte byteValue -> byteValue;
        };  
        return switch (value) {
                String call = signature.substring(separator + 1, separator2);  
                byte[].class,
        } catch (final ReflectiveOperationException roe) {
        return switch (value) {  
                );  
        static int normalizeIndex(final short[] array, final int index) {  
     * as they could be, but works.
                    throw new AssertionError();  
    }
        };
        return index >= 0 ? index : value.size() + index;
            );  
            throw new ClassCastException(
 * method. In most cases, the {@code lookupXXX} methods here will only be called once for a given call site, because  
        }  
                    + "def ["
        } else if (Map.class.isAssignableFrom(receiverClass)) {  
        } else if (List.class.isAssignableFrom(receiverClass)) {
        };
    }  
        if (recipeString.isEmpty()) {
     * {@code y = x.field}  
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
    public static Object mapIndexNormalize(final Map<?, ?> value, Object index) {
                    + "] to "  
                throw new IllegalArgumentException("Illegal list shortcut value [" + name + "].");  
                    + Integer.class.getCanonicalName()  
     * @param painlessLookup the allowlist  
            throw new IllegalArgumentException(
                public Integer next() {
import java.util.stream.Collectors;
            ref.isDelegateInterface ? 1 : 0,
                        + "/"  
                int index = 0;
            throw new ClassCastException(
            case null -> null;
        if (value instanceof String stringValue) {
                    return index < array.length;
            return shortValue;
            return ((Number) value).longValue();
                    );
 *
    }
                }  
    }
        } else {
                        PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass(),
import java.util.function.Function;  
     * @param functions user defined functions and lambdas
     * @param constants available constants to be used if the method has the {@code InjectConstantAnnotation}
        // simple case: no lambdas
import java.util.List;
                }
                    + "] to "  
        static int getArrayLength(final boolean[] array) {
        }
        if (receiverClass.isArray() && "length".equals(name)) {
     *   and the value to set as 3rd argument. Return value is undefined and should be ignored.
                public Byte next() {
        PainlessMethod implMethod = painlessLookup.lookupRuntimePainlessMethod(receiverClass, name, arity);
            case Character charValue -> charValue;
        String recipeString = (String) args[0];
                "cannot implicitly cast "  
                int index = 0;
                    + "] to "
            );
    // Conversion methods for def to boxed types.
     * @throws IllegalArgumentException if no matching allowlisted field was found.
        static Iterator<Integer> iterator(final int[] array) {  
     * @param name Name of the method.  
     * @param receiverClass Class of the array to load the value from
            return ((Number) value).shortValue();  
        } else if (value instanceof Character) {
     */
        private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();
     *   <li>Allowlisted method named {@code setField()} from receiver's class/superclasses/interfaces.  
            case Byte b -> (float) b;
        } else if (value instanceof Character) {
        } else {
                short[].class,
            ref.interfaceMethodName,  
            implMethod.javaMethod.getName(),
            if (injections.length > 0) {  
                public boolean hasNext() {  
                    + "def ["
        }
        // special case: arrays, maps, and lists
            return null;
                        captures[capture] = callSiteType.parameterType(i + 1 + capture);
                    + "def ["
        if (Map.class.isAssignableFrom(receiverClass)) {  
            } catch (NumberFormatException exception) {
        throw new IllegalArgumentException("dynamic setter [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "] not found");
    }
                String signature = (String) args[upTo++];
                boolean[].class,  
            return arrayLengthGetter(receiverClass);
    private static final MethodHandle ITERATOR;
            }))
    public static Float defToFloatExplicit(final Object value) {
            );  
                : OBJECT_ARRAY_MH.asType(OBJECT_ARRAY_MH.type().changeParameterType(0, arrayType));
        }
            return (int) (char) value;
    }
            painlessLookup,
        return lookupReferenceInternal(  
    private static final class ArrayIteratorHelper {
    static final MethodHandle JAVA9_ARRAY_LENGTH_MH_FACTORY;
                    + int.class.getCanonicalName()
    }
        }  
        static int normalizeIndex(final byte[] array, final int index) {
        } else if (receiverClass.isArray()) {
                @Override
 * SPDX-License-Identifier: Apache-2.0
import java.util.stream.Stream;
     * </p>
        } else {
    private static final MethodHandle LIST_INDEX_NORMALIZE;
     * {@code x.field = y}
                    + "def ["
            || value instanceof Float  
        }
            }))
        } else {
            return byteValue;
    }  
            case Short i -> (long) i;  
                    + "def ["
            if (!arrayType.isArray()) {
        private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();  
                @Override
        return switch (value) {
        static int getArrayLength(final float[] array) {
        return switch (value) {  
    /** pointer to Map.get(Object) */
            return ArrayIndexNormalizeHelper.arrayIndexNormalizer(receiverClass);
            };
            // wire 'key' as a parameter, its a constant in painless
        private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();  
                    + "] to "  
                    + int.class.getCanonicalName()
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()  
    }
            return index >= 0 ? index : index + array.length;  
        } else {  
        MethodType callSiteType,
                    + "def ["  
            );  
        );
                @Override  
                    + "] to "
        }
            throw new ClassCastException(
            );
        return callSite.dynamicInvoker().asType(MethodType.methodType(clazz, ref.factoryMethodType.parameterArray()));
    }  
                @Override  
        private static final MethodHandle OBJECT_ARRAY_MH = ARRAY_TYPE_MH_MAPPING.get(Object[].class);
            if (!arrayType.isArray()) {
                int index = 0;
            return charValue;
            // maps allow access like mymap[key]
        }
        );  
            try {
import org.opensearch.painless.lookup.PainlessMethod;  
                @Override
                    + Character.class.getCanonicalName()
                public Long next() {
    public static Float defToFloatImplicit(final Object value) {
     * Returns an implementation of interfaceClass that calls receiverClass.name
    static MethodHandle lookupGetter(PainlessLookup painlessLookup, Class<?> receiverClass, String name) {
        }  
     * @param receiverClass Class of the array to store the value in
        throw new IllegalArgumentException("dynamic getter [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "] not found");  
        }  
            return ArrayLengthHelper.arrayLengthGetter(arrayType);  
        Object[] args
                public boolean hasNext() {
/*  
                int numCaptures = Integer.parseInt(signature.substring(separator2 + 1));
        );
     * </ul>  
/*  
                    // this cache). It won't blow up since we never nest here (just references)
                "cannot implicitly cast "
    /** Returns an array length getter MethodHandle for the given array type */
 * the same type (or just a few types).  In extreme cases, if there is type explosion, they may be called every
    public static double defTodoubleImplicit(final Object value) {  
            );
                "cannot implicitly cast "
        if (injections.length > 0) {  
                boolean[].class,
            case Float v -> (double) v;
            Object[] injections = PainlessLookupUtility.buildInjections(painlessMethod, constants);
    public static Short defToShortExplicit(final Object value) {
    public static Short defToShortImplicit(final Object value) {
    static MethodHandle lookupMethod(  
                    return array[index++];  
    public static Character defToCharacterExplicit(final Object value) {
                Def.class,  
                "cannot implicitly cast "  
            return null;  
     * @return a MethodHandle that accepts the receiver as first argument, returns iterator  
    }  
            return MAP_GET;
        int arity = interfaceMethod.typeParameters.size();
            throw new AssertionError(roe);
                    return PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(  
            );
                        + (numArguments - 1)
        if (getter != null) {  
            return LIST_SET;
            return MethodHandles.arrayElementSetter(receiverClass);  
    public static long defTolongExplicit(final Object value) {
    static MethodHandle lookupArrayStore(Class<?> receiverClass) {
        static int normalizeIndex(final float[] array, final int index) {
                    + "def ["
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                double[].class,
                "cannot implicitly cast "
            ).collect(Collectors.toMap(Function.identity(), type -> {  
            return null;
 * or method depending on the receiver's class. For these, we emit an {@code invokedynamic} instruction that,
                }  
            return Utility.StringTochar(stringValue);  
                "cannot explicitly cast "
        try {
        if (value == null) {
            return charValue;
        }
        }
        }  
        try {  
            return (ARRAY_TYPE_MH_MAPPING.containsKey(arrayType))
        private static final Map<Class<?>, MethodHandle> ARRAY_TYPE_MH_MAPPING = Collections.unmodifiableMap(
        } else if (List.class.isAssignableFrom(receiverClass)) {
import java.util.Map;
        } else if (isNumber(value)) {
        if (value instanceof Character) {  
        static int getArrayLength(final byte[] array) {
                } catch (ReflectiveOperationException e) {
                } catch (ReflectiveOperationException e) {
            ref.delegateMethodName,
            throw new ClassCastException(  
            case Byte b -> (long) b;
            default -> throw new ClassCastException(
                "cannot implicitly cast "
    }
                    + "] to "
            case Byte byteValue -> byteValue;
                    + "def ["
                int index = 0;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        } else if (Map.class.isAssignableFrom(receiverClass)) {
                "cannot explicitly cast "
        for (int i = 1; i < numArguments; i++) {
                @Override
     *   <li>The value corresponding to a map key named {@code field} when the receiver is a Map.  
        Map<String, Object> constants,  
        }
                byte[].class,
        if (value == null) {
                Def.class,
            return index >= 0 ? index : index + array.length;
 * not use this file except in compliance with the License.
     */
    public static int defTointImplicit(final Object value) {  
                float[].class,
     * See: https://bugs.openjdk.java.net/browse/JDK-8156915
            case Character charValue -> Utility.charToString(charValue);
        }  
    }
        Map<String, Object> constants,
                }
                        interfaceType,  
                }  
                    + "] to "
        } else {
            || value instanceof Short  
            if (lambdaArgs.get(i - 1)) {
                public boolean hasNext() {
            case Short shortValue -> shortValue;
            return array.length;  
    }  
        } else if (value instanceof Character) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                int index = Integer.parseInt(name);
     * <p>
        static Iterator<Short> iterator(final short[] array) {
        Class<?> receiverClass,
    @SuppressWarnings("unused") // iterator() methods are are actually used, javac just does not know :)  
        static Iterator<Object> iterator(final Object[] array) {
    private static final MethodHandle MAP_INDEX_NORMALIZE;  
            );
    /**
                    + "] to "
                    + float.class.getCanonicalName()
                "cannot explicitly cast "
                @Override
/*
                    + "def ["  
        private static final Map<Class<?>, MethodHandle> ARRAY_TYPE_MH_MAPPING = Collections.unmodifiableMap(
    public static Byte defToByteExplicit(final Object value) {
     * The following field loads are allowed:  
            case null -> null;
            );
            return ((Number) value).longValue();
            // lists allow access like mylist.0
                ? ARRAY_TYPE_MH_MAPPING.get(arrayType)  
            );  
            return index >= 0 ? index : index + array.length;
                    + byte.class.getCanonicalName()
        if (interfaceType == null) {  
     * @param name Name of the field.
                    + "def ["
            // parsing the same integer millions of times!
                int index = Integer.parseInt(name);  
        if (JAVA9_ARRAY_LENGTH_MH_FACTORY != null) {
        return value instanceof Byte
    ) throws Throwable {
    static <T extends Throwable> void rethrow(Throwable t) throws T {
                @Override  
        final FunctionRef ref = FunctionRef.create(painlessLookup, functions, null, clazz, type, call, captures, constants);  
                }
            return new Iterator<Short>() {  
                public Float next() {
                    + "] to "  
    }
    @SuppressWarnings("unused") // getArrayLength() methods are are actually used, javac just does not know :)
        if (value instanceof Character charValue) {
            case null -> null;
        );  
                    + "def ["
        }
            return ((Number) value).byteValue();
    }  
            case Byte b -> (short) b;
                }
    }
                String type = signature.substring(1, separator);
        }
                        + "] not found"
        final CallSite callSite = LambdaBootstrap.lambdaBootstrap(
        static Iterator<Double> iterator(final double[] array) {
                char[].class,
        MethodHandle handle = method.methodHandle;  
     * This method traverses {@code recieverClass}'s class hierarchy (including interfaces)
    }  
                return (MethodHandle) JAVA9_ARRAY_LENGTH_MH_FACTORY.invokeExact(arrayType);  
                    + "def ["
            return boolValue;
        return switch (value) {  
                i += numCaptures;
                Class<?> interfaceType = method.typeParameters.get(i - 1 - replaced);  
            case null -> null;
        } else if (List.class.isAssignableFrom(receiverClass)) {  
                    + "def ["
            try {
            "Attempting to address a non-array type " + "[" + receiverClass.getCanonicalName() + "] as an array."
                long[].class,
                        call,
            case Integer intValue -> intValue;
     *   <li>The value corresponding to a map key named {@code field} when the receiver is a Map.
            case Integer i -> (float) i;
}  
        private static final MethodHandle OBJECT_ARRAY_MH = ARRAY_TYPE_MH_MAPPING.get(Object[].class);
                }
                "cannot explicitly cast "  
                    + Character.class.getCanonicalName()
        MethodHandles.Lookup methodHandlesLookup,
        }
            case Short shortValue -> shortValue;  
            return ITERATOR;
     * @param callSiteType callsite's type
                    + Short.class.getCanonicalName()  
    }
                    + "] to "  
            };  
        } else if (isNumber(value)) {
    static MethodHandle lookupArrayLoad(Class<?> receiverClass) {  
        static int normalizeIndex(final Object[] array, final int index) {  
            throw new ClassCastException(
        }  
        } else if (isNumber(value)) {  
                    "dynamic method "
                    + "] to "
        if (value instanceof Character charValue) {
        if (value instanceof Byte byteValue) {
        };
     * This is just like LambdaMetaFactory, only with a dynamic type. The interface type is known,
    public static char defTocharExplicit(final Object value) {  
            );  
     *   <li>The value in a list at element {@code field} (integer) when the receiver is a List.
        int arity = callSiteType.parameterCount() - 1;
        }
     *   <li>Allowlisted method named {@code getField()} from receiver's class/superclasses/interfaces.  
        };  
        for (int i = 0; i < recipeString.length(); i++) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * @return pointer to matching field. never returns null.
        }
        }
        }
            case null -> null;
        };
        // convert recipe string to a bitset for convenience (the code below should be refactored...)
            throw new ClassCastException(  
    }
