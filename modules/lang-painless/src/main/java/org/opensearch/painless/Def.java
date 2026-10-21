     * This is just like LambdaMetaFactory, only with a dynamic type. The interface type is known,
    private static final MethodHandle ITERATOR;
        }
    }
                    + "def ["
            case Integer i -> (double) i;
                @Override
 * the same type (or just a few types).  In extreme cases, if there is type explosion, they may be called every
        // lookup the method with the proper arity, then we know everything (e.g. interface types of parameters).
                }
        throw new IllegalArgumentException(
                    return PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(
            case Integer intValue -> intValue;
        private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();
            ITERATOR = methodHandlesLookup.findVirtual(Iterable.class, "iterator", MethodType.methodType(Iterator.class));
 * the Apache License, Version 2.0 (the "License"); you may
     *   and the value to set as 3rd argument. Return value is undefined and should be ignored.
        throw new IllegalArgumentException(
            };
                    + char.class.getCanonicalName()
     */
        MethodHandle getter = painlessLookup.lookupRuntimeGetterMethodHandle(receiverClass, name);
            ref.interfaceMethodName,
     */
                throw new IllegalArgumentException("Illegal list shortcut value [" + name + "].");
                        + (numArguments - 1)
    }
        } else if (List.class.isAssignableFrom(receiverClass)) {
                    + "float ["
                int[].class,
                    + "] to "
                } catch (ReflectiveOperationException e) {
            case Short i -> (float) i;
                        MethodType.methodType(Iterator.class, type)
import java.util.Collections;
        }
            ref.delegateClassName,
                public boolean hasNext() {
                char[].class,
     * This method traverses {@code recieverClass}'s class hierarchy (including interfaces)
        }
                }
    ) throws Throwable {
     */
     * <p>
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
 * caching ({@link DefBootstrap}) generally works: usually all objects at any call site will be consistently
     * (to emulate a "arraystore" bytecode using MethodHandles).
            try {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * @param receiverClass Class of the object to retrieve the field from.
            case Character c -> (long) c;
                "cannot explicitly cast "
            );
            return charValue;
            return null;
        return lookupReferenceInternal(
                MethodHandle filter;
            case Integer intValue -> intValue;
            // method handle contains the "this" pointer so start injections at 1
            }
        static Iterator<Double> iterator(final double[] array) {
     * Looks up handle for a dynamic method call, with lambda replacement
     */
     * @param receiverClass Class of the object to retrieve the field from.
            );
    /** factory for arraylength MethodHandle (intrinsic) from Java 9 (pkg-private for tests) */
     */
    }
        throw new IllegalArgumentException("dynamic getter [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "] not found");
     * negative offsets.
        return switch (value) {
            }))
        return switch (value) {
            return MAP_PUT;
        }
    }
                "cannot explicitly cast "
            // maps allow access like mymap.key
                return MethodHandles.insertArguments(LIST_SET, 1, index);
        } else {
        }
    static MethodHandle lookupSetter(PainlessLookup painlessLookup, Class<?> receiverClass, String name) {
        private static final Map<Class<?>, MethodHandle> ARRAY_TYPE_MH_MAPPING = Collections.unmodifiableMap(
                arity -= numCaptures;
    }
                "dynamic method [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "/" + arity + "] not found"
        MethodType callSiteType,
                    return index < array.length;
                        numCaptures
        Map<String, Object> constants,
        } else if (List.class.isAssignableFrom(receiverClass)) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
    private static final MethodHandle LIST_GET;
                "mapIndexNormalize",
                        "getArrayLength",
    }
                public boolean hasNext() {
            return new Iterator<Short>() {
            case Float v -> v;
                    + "def ["
        private ArrayLengthHelper() {}
            return charValue;
                    + "def ["
        MethodHandles.Lookup methodHandlesLookup,
                short[].class,
        if (value instanceof Character) {
     * <p>
            throw new ClassCastException(
        if (value == null) {
                double[].class,
            LIST_GET = methodHandlesLookup.findVirtual(List.class, "get", MethodType.methodType(Object.class, int.class));
    /** pointer to {@link Def#listIndexNormalize}. */
                    + "def ["
                "cannot implicitly cast "
            case Integer intValue -> intValue;
            case String stringValue -> stringValue;
            throw new ClassCastException(
    public static byte defTobyteImplicit(final Object value) {
            painlessLookup,
            case null -> null;
        String interfaceClass,
    }
            try {
 * specific language governing permissions and limitations
        }
        static int getArrayLength(final boolean[] array) {
    public static long defTolongImplicit(final Object value) {
            arrayLengthMHFactory = null;
                    + Float.class.getCanonicalName()
            PainlessLookupUtility.typeToCanonicalTypeName(implMethod.targetClass),
                : OBJECT_ARRAY_MH.asType(OBJECT_ARRAY_MH.type().changeParameterType(0, arrayType));
            default -> throw new ClassCastException(
    }
        }
            case Short shortValue -> shortValue;
        String recipeString = (String) args[0];
                }
        FunctionTable functions,
                    return index < array.length;
        } else if (List.class.isAssignableFrom(receiverClass)) {
     */
     * Otherwise it returns a handle to the matching getter.
    static MethodHandle lookupMethod(
                    + "def ["
    private static boolean isNumber(final Object value) {
        }
        } else {
                }
 * GitHub history for details.
            case null -> null;
                } else if (signature.charAt(0) == 'D') {
        }
            case Byte b -> (float) b;
    ) throws Throwable {
        FunctionTable functions,
                    + "] to "
        }
                @Override
            );
                    + "] to "
            throw new ClassCastException(
            return (char) ((Number) value).intValue();
                    return array[index++];
        };
        if (JAVA9_ARRAY_LENGTH_MH_FACTORY != null) {
                // method handle contains the "this" pointer so start injections at 1
        }
    /** Returns an array length getter MethodHandle for the given array type */
     * "Normalizes" the index into a {@code Map} by making no change to the index.
            );
     *   <li>Allowlisted {@code field} from receiver's class or any superclasses.
        }
            return null;
                ? ARRAY_TYPE_MH_MAPPING.get(arrayType)
        private static final MethodHandle OBJECT_ARRAY_MH = ARRAY_TYPE_MH_MAPPING.get(Object[].class);
    /** pointer to Iterable.iterator() */
            return index >= 0 ? index : index + array.length;
                    + "def ["
                "cannot implicitly cast "
            ref.delegateMethodName,
        final FunctionRef ref = FunctionRef.create(painlessLookup, functions, null, clazz, type, call, captures, constants);
        }
                "cannot implicitly cast "
                    return array[index++];
                    + long.class.getCanonicalName()
            case Short shortValue -> shortValue;
                int index = 0;
                short[].class,
        } else if (value instanceof Boolean boolValue) {
            ref.factoryMethodType,
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            // arrays expose .length as a read-only getter
            throw new ClassCastException(
        Class<?> clazz,
                    + "def ["
        };
            );
            return null;
    public static Character defToCharacterImplicit(final Object value) {
            return (char) ((Number) value).intValue();
                    + "def ["
                }
                long[].class,
                    + "def ["
        private static final MethodHandle OBJECT_ARRAY_MH = ARRAY_TYPE_MH_MAPPING.get(Object[].class);
        }
                    + "] to "
        if (value == null) {
 * Dynamic methods, loads, stores, and array/list/map load/stores involve locating the appropriate field
            throw new ClassCastException(
            return (ARRAY_TYPE_MH_MAPPING.containsKey(arrayType))
        if (receiverClass.isArray()) {
            );
        } else {
        BitSet lambdaArgs = new BitSet(recipeString.length());
        }
                long[].class,
            ref.interfaceMethodType,
                "cannot implicitly cast "
        if (injections.length > 0) {
        } else {
            case null -> null;
                @Override
        // simple case: no lambdas
                    );
        return handle;
                "cannot implicitly cast "
            return (ARRAY_TYPE_MH_MAPPING.containsKey(arrayType))
        if (recipeString.isEmpty()) {
 * compile-time type information.
        Class<?> receiverClass,
                throw new AssertionError(t);
            return handle;
        }
        } else if (value instanceof Character charValue) {
            arrayLengthMHFactory = methodHandlesLookup.findStatic(
                    + Short.class.getCanonicalName()
                        captures[capture] = callSiteType.parameterType(i + 1 + capture);
 * Unless required by applicable law or agreed to in writing,
        return index >= 0 ? index : value.size() + index;
        }
     * @param functions user defined functions and lambdas
            // maps allow access like mymap.key
            // lists allow access like mylist.0
import static org.opensearch.painless.lookup.PainlessLookupUtility.typeToCanonicalTypeName;
     * The following field stores are allowed:
                "cannot implicitly cast "
 * ownership. Elasticsearch licenses this file to you under
        } else {
                boolean[].class,
            default -> throw new ClassCastException(
 * compatible open source license.
            };
    }
                    + short.class.getCanonicalName()
            // wire 'key' as a parameter, its a constant in painless
                    return array[index++];
            try {
            return boolValue;
        if (value instanceof Boolean boolValue) {
            return (byte) (char) value;
        }
            case Long longValue -> longValue;
            if (!arrayType.isArray()) {
            ).collect(Collectors.toMap(Function.identity(), type -> {
            // parsing the same integer millions of times!
        return switch (value) {
     * A dynamic field store for variable {@code x} of type {@code def} looks like:
                        PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try {
    }
                }
                    return array[index++];
                byte[].class,
                double[].class,
    }
                    );
                    + Integer.class.getCanonicalName()
                    throw new AssertionError();
     * @param name Name of the field.
        static Iterator<Long> iterator(final long[] array) {
                    + "def ["
                    + Byte.class.getCanonicalName()
                    + Integer.class.getCanonicalName()
            case Float v -> (double) v;
            return byteValue;
        } else if (value instanceof Character) {
            );
                @Override
        return index;
                public boolean hasNext() {
        static Iterator<Short> iterator(final short[] array) {
        if (value == null) {
     *   <li>Allowlisted {@code field} from receiver's class or any superclasses.
        }
            case Byte byteValue -> byteValue;
            );
                        nestedType,
            ref.isDelegateInterface ? 1 : 0,
                MethodType.methodType(Object.class, Map.class, Object.class)
        } else {
            ref.delegateInvokeType,
            case Character charValue -> charValue;
            return null;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * @param callSiteType callsite's type
                int index = Integer.parseInt(name);
            return new Iterator<Float>() {
                    + Double.class.getCanonicalName()
            return array.length;
            return LIST_GET;
        return callSite.dynamicInvoker().asType(MethodType.methodType(clazz, ref.factoryMethodType.parameterArray()));
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * </p>
     * @param painlessLookup the allowlist
    static <T extends Throwable> void rethrow(Throwable t) throws T {
            // maps allow access like mymap[key]
        private static final Map<Class<?>, MethodHandle> ARRAY_TYPE_MH_MAPPING = Collections.unmodifiableMap(
            case Long longValue -> longValue;
        } else if (Map.class.isAssignableFrom(receiverClass)) {
                MethodType.methodType(int.class, List.class, int.class)
            return new Iterator<Byte>() {
        }
    }
                    + "] to "
        // first try allowlist
                "cannot explicitly cast "
    }
    static MethodHandle lookupArrayStore(Class<?> receiverClass) {
                    + "def ["
        } else if (isNumber(value)) {
                @Override
                    }
        } else if (value instanceof String stringValue) {
        }
            return null;
 * software distributed under the License is distributed on an
    }
    private static final MethodHandle MAP_INDEX_NORMALIZE;
        int replaced = 0;
            return boolValue;
                    return array[index++];
                        methodHandlesLookup,
            return (long) (char) value;
                    + "] to "
                    + "def ["
    /** Returns a method handle to an implementation of clazz, given method reference signature. */
        upTo = 1;
        PainlessMethod implMethod = painlessLookup.lookupRuntimePainlessMethod(receiverClass, name, arity);
            }
        MethodHandles.Lookup methodHandlesLookup,
            case Float floatValue -> floatValue;
        };
                    + "def ["
        return switch (value) {
                    + "] to "
            );
                ? ARRAY_TYPE_MH_MAPPING.get(arrayType)
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                    + int.class.getCanonicalName()
        MethodHandle arrayLengthMHFactory;
        } else if (isNumber(value)) {
            return ((Number) value).floatValue();
        static int normalizeIndex(final long[] array, final int index) {
        }
        }
                @Override
                @Override
        static int getArrayLength(final Object[] array) {
        // special case: arrays, maps, and lists
                        MethodType.methodType(int.class, type, int.class)
                "cannot explicitly cast "
            return Utility.StringTochar(stringValue);
                    + byte.class.getCanonicalName()
import java.util.function.Function;
    @SuppressWarnings("unused") // iterator() methods are are actually used, javac just does not know :)
        };
     * @throws IllegalArgumentException if no matching allowlisted method was found.
                    + "def ["
            return MethodHandles.arrayElementGetter(receiverClass);
        }
     * </ul>
    static {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                    + "] to "
    /** pointer to Map.get(Object) */
    }
            case Integer i -> i;
                }
    private static final class ArrayIndexNormalizeHelper {
        }
        if (value == null) {
     *   <li>The value in a list at element {@code field} (integer) when the receiver is a List.
                    return index < array.length;
            );
        if (value instanceof Character charValue) {
            );
                    + "] to "
            case Double doubleValue -> doubleValue;
     * @param methodHandlesLookup caller's lookup
            return new Iterator<Integer>() {
        throw new IllegalArgumentException("dynamic setter [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "] not found");
            // wire '0' (index) as a parameter, its a constant. this also avoids
            default -> throw new ClassCastException(
    private static final class ArrayLengthHelper {
            } catch (Throwable t) {
        } else if (isNumber(value)) {
                        DefBootstrap.REFERENCE,
            );
    public static short defToshortImplicit(final Object value) {
     * until it finds a matching allowlisted setter. If one is not found, it throws an exception.
            return (double) (char) value;
                int numCaptures = Integer.parseInt(signature.substring(signature.indexOf(',') + 1));
            return setter;
            return byteValue;
        }
                    for (int capture = 0; capture < captures.length; capture++) {
                "listIndexNormalize",
     * @return pointer to matching field. never returns null.
            );
                        + name
                    + "] to "
        } else {
            return ((Number) value).intValue();
            return Utility.StringTochar(stringValue);
    public static Short defToShortImplicit(final Object value) {
            case Byte byteValue -> byteValue;
                        PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass(),
            throw new ClassCastException(
    }
        };
            return (short) (char) value;
     *   <li>The {@code length} field of an array.
        } else {
        if (value == null) {
        static int getArrayLength(final int[] array) {
            );
                public Object next() {
        }
            || value instanceof Short
            return new Iterator<Double>() {
        String name
        private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();
            return (byte) (char) value;
                Class<?> interfaceType = method.typeParameters.get(i - 1 - replaced);
    /**
            handle = MethodHandles.insertArguments(handle, 1, injections);
        };
        );
        }
            );
                public boolean hasNext() {
    public static long defTolongExplicit(final Object value) {
                    Class<?>[] captures = new Class<?>[numCaptures];
        static Iterator<Byte> iterator(final byte[] array) {
                filter = MethodHandles.dropArguments(filter, 0, String.class);
            Object[] injections = PainlessLookupUtility.buildInjections(painlessMethod, constants);
                    + String.class.getCanonicalName()
        }
                    + "] to "
                @Override
            }
        }
import java.util.Map;
            case Character charValue -> charValue;
    private static final class ArrayIteratorHelper {
        String name,
            return array.length;
 * Dynamic types can invoke methods, load/store fields, and be passed as parameters to operators without
            MAP_GET = methodHandlesLookup.findVirtual(Map.class, "get", MethodType.methodType(Object.class, Object.class));
        }
                @Override
                String signature = (String) args[upTo++];
     *   It returns the loaded value.
                "arrayLength",
                }
    }
        for (int i = 1; i < numArguments; i++) {
                    return array[index++];
                    MethodType nestedType = MethodType.methodType(interfaceType, captures);
        JAVA9_ARRAY_LENGTH_MH_FACTORY = arrayLengthMHFactory;
        int numArguments = callSiteType.parameterCount();
        Class<?> receiverClass,
 */
            return charValue;
            return charValue;
                handle = MethodHandles.insertArguments(handle, 1, injections);
        return switch (value) {
     */
        private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();
        );
                    + "] to "
                Object[].class
     * {@code y = x.field}
                @Override
        if (value instanceof Byte byteValue) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                    + Character.class.getCanonicalName()
    }
            interfaceType,
        } else if (value instanceof Byte byteValue) {
        }
            return array.length;
        if (value == null) {
                float[].class,
                "cannot explicitly cast "
            );
        } else if (value instanceof String stringValue) {
        String call,
            } catch (final NumberFormatException exception) {
                "cannot implicitly cast "
        // https://bugs.openjdk.java.net/browse/JDK-8156915
                    + int.class.getCanonicalName()
     * Returns a method handle to do iteration (for enhanced for loop)
        } catch (final ReflectiveOperationException roe) {
            case Short i -> (long) i;
                    // this is dynamically based on the receiver type (and cached separately, underneath
        }
    public static boolean defToboolean(final Object value) {
        if (method == null) {
            lambdaArgs.set(recipeString.charAt(i));
            throw new ClassCastException(
                    + "] to "
                    return index < array.length;
    public static float defTofloatExplicit(final Object value) {
     * @param receiverClass Class of the array to load the value from
                        MethodType.methodType(int.class, type)
    public static char defTocharImplicit(final Object value) {
        }
    /** Hack to rethrow unknown Exceptions from {@link MethodHandle#invokeExact}: */
            if (lambdaArgs.get(i - 1)) {
 * Support for dynamic type (def).
     * Returns a method handle to normalize the index into an array. This is what makes lists and arrays stored in {@code def} support
                } catch (ReflectiveOperationException e) {
     * {@code x.field = y}
import java.util.BitSet;
        // otherwise: first we have to compute the "real" arity. This is because we have extra arguments:
                int separator2 = signature.indexOf(',');
            return ArrayLengthHelper.arrayLengthGetter(arrayType);
                : OBJECT_ARRAY_MH.asType(OBJECT_ARRAY_MH.type().changeParameterType(0, arrayType));
                    + String.class.getCanonicalName()
    private static final MethodHandle MAP_PUT;
    public static short defToshortExplicit(final Object value) {
                handle = MethodHandles.collectArguments(handle, i, filter);
 * single time, but simplicity is still more valuable than performance in this code.
                    // we have everything.
                    + "] to "
        } else {
        if (setter != null) {
            implMethod.javaMethod.getName(),
            // wire 'key' as a parameter, its a constant in painless
import java.util.Iterator;
    }
            }))
    /** pointer to {@link Def#mapIndexNormalize}. */
                } else {
                @Override
            return (int) (char) value;
            default -> throw new ClassCastException(
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
import java.util.stream.Collectors;
            };
                MethodType.methodType(MethodHandle.class, Class.class)
                "cannot implicitly cast "
     *   <li>Allowlisted method named {@code setField()} from receiver's class/superclasses/interfaces.
        } else if (receiverClass.isArray()) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            );
            || value instanceof Double;
/**
     * until it finds a matching allowlisted getter. If one is not found, it throws an exception.
                public Integer next() {
    static MethodHandle lookupReference(
        }
        } else {
                "cannot cast "
        FunctionTable functions,
            throw new IllegalArgumentException(
                // decode signature of form 'type.call,2'
 * for each new type encountered will query a corresponding {@code lookupXXX} method to retrieve the appropriate
 * <p>
            case Integer intValue -> intValue;
                    throw new AssertionError(e);
        }
                short[].class,
                }
    public static Float defToFloatImplicit(final Object value) {
     */
public final class Def {
     *   <li>The value corresponding to a map key named {@code field} when the receiver is a Map.
            case Character charValue -> charValue;
                Object[].class
                @Override
                public boolean hasNext() {
        } else {
    ) throws Throwable {
                "cannot explicitly cast "
 */
            PainlessMethod painlessMethod = painlessLookup.lookupRuntimePainlessMethod(receiverClass, name, numArguments - 1);
            return ((Number) value).longValue();
     * Returns an implementation of interfaceClass that calls receiverClass.name
        }
    }
            throw new ClassCastException(
                public Short next() {
            return LIST_INDEX_NORMALIZE;
            ref.isDelegateAugmented ? 1 : 0,
                int index = 0;
        } else if (Map.class.isAssignableFrom(receiverClass)) {
    }
                ? ARRAY_TYPE_MH_MAPPING.get(arrayType)
     * @param painlessLookup the allowlist
     * The following field loads are allowed:
            MethodHandle handle = painlessMethod.methodHandle;
            throw new ClassCastException(
            );
                char[].class,
     * <p>
        static Iterator<Object> iterator(final Object[] array) {
 * method. In most cases, the {@code lookupXXX} methods here will only be called once for a given call site, because
        }
                "cannot implicitly cast "
        }
     * A dynamic method call for variable {@code x} of type {@code def} looks like:
     * {@code x.method(args...)}
    public static Long defToLongExplicit(final Object value) {
    }
import org.opensearch.painless.symbol.FunctionTable;
import java.lang.invoke.MethodHandles;
    static MethodHandle lookupIndexNormalize(Class<?> receiverClass) {
                        painlessLookup,
            );
            );
            case Long l -> l;
                @Override
                    + "def ["
    }
                    + short.class.getCanonicalName()
    static MethodHandle lookupArrayLoad(Class<?> receiverClass) {
        }
                }
        // convert recipe string to a bitset for convenience (the code below should be refactored...)
        if (value instanceof Character charValue) {
                "cannot explicitly cast "
            return array.length;
                    filter = lookupReferenceInternal(
            case Byte b -> (double) b;
    public static int defTointImplicit(final Object value) {
import org.opensearch.painless.lookup.PainlessLookup;
            // maps allow access like mymap[key]
            case null -> null;
 * or method depending on the receiver's class. For these, we emit an {@code invokedynamic} instruction that,
        } else if (isNumber(value)) {
            return null;
                    + "] to "
                    + Double.class.getCanonicalName()
    }
                try {
    }
        static int getArrayLength(final double[] array) {
        } else if (value instanceof Character charValue) {
            return array.length;
        }
            default -> throw new ClassCastException(
        static int getArrayLength(final char[] array) {
            ref.delegateMethodType,
                    return index < array.length;
            }
        // based on these we can finally link any remaining lambdas that were deferred.
        MethodHandle setter = painlessLookup.lookupRuntimeSetterMethodHandle(receiverClass, name);
                    + "] to "
            throw new ClassCastException(
                }
                    + "def ["
    /**
        if (value instanceof Character charValue) {
            return LIST_SET;
     * </p>
    }
            throw new IllegalArgumentException(
        static int normalizeIndex(final boolean[] array, final int index) {
        if (value instanceof Character charValue) {
            case Short i -> (double) i;
            return MethodHandles.arrayElementSetter(receiverClass);
                    + Byte.class.getCanonicalName()
    }
            }
        if (Iterable.class.isAssignableFrom(receiverClass)) {
        static Iterator<Boolean> iterator(final boolean[] array) {
        } else {
                "cannot explicitly cast "
            return ((Number) value).byteValue();
                    + "] to "
            throw new ClassCastException(
            || value instanceof Long
                    + byte.class.getCanonicalName()
        } else {
                    throw new AssertionError(e);
        static Iterator<Integer> iterator(final int[] array) {
                int separator = signature.lastIndexOf('.');
    public static Short defToShortExplicit(final Object value) {
            return ((Number) value).floatValue();
                    );
     * See: https://bugs.openjdk.java.net/browse/JDK-8156915
            return index >= 0 ? index : index + array.length;
                        "normalizeIndex",
                    + char.class.getCanonicalName()
            );
                    );
                byte[].class,
            case Byte byteValue -> byteValue;
                    + "def ["
                    + "def ["
        } else if (isNumber(value)) {
     * @param painlessLookup the allowlist
        }
        }
                        type,
        static int normalizeIndex(final char[] array, final int index) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
    }
        if (Map.class.isAssignableFrom(receiverClass)) {
     * This method traverses {@code recieverClass}'s class hierarchy (including interfaces)
     * @throws IllegalArgumentException if no matching allowlisted field was found.
            // noop so that mymap[key] doesn't do funny things with negative keys
    }
                "cannot implicitly cast "
                }
                int[].class,
        }
        return switch (value) {
        Object[] args
        static MethodHandle arrayIndexNormalizer(Class<?> arrayType) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        // e.g. f(a, g(x), b, h(y), i()) looks like f(a, g, x, b, h, y, i).
        if (getter != null) {
            "Attempting to address a non-array-like type " + "[" + receiverClass.getCanonicalName() + "] as an array."
                    return index < array.length;
        if (receiverClass.isArray()) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            throw new ClassCastException(
                    // this cache). It won't blow up since we never nest here (just references)
            methodHandlesLookup,
            );
        PainlessLookup painlessLookup,
        }
            throw new IllegalArgumentException("Class [" + interfaceClass + "] is not a functional interface");
     * <p>
                    + "] to "
     * @param constants available constants to be used if the method has the {@code InjectConstantAnnotation}
     * <p>
        } else {
                    + "] to "
package org.opensearch.painless;
        String type,
                    + "] to "
                    + Boolean.class.getCanonicalName()
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            );
            case Short i -> i;
        static int normalizeIndex(final byte[] array, final int index) {
                return MethodHandles.insertArguments(LIST_GET, 1, index);
/*
                    + "] to "
        return switch (value) {
        for (int i = 0; i < recipeString.length(); i++) {
import java.lang.invoke.MethodType;
        PainlessMethod interfaceMethod = painlessLookup.lookupFunctionalInterfacePainlessMethod(interfaceType);
     * so we simply need to lookup the matching implementation method based on receiver type.
                    return array[index++];
        Map<String, Object> constants,
    static MethodHandle arrayLengthGetter(Class<?> arrayType) {
                    return array[index++];
 *
        }
        static int getArrayLength(final byte[] array) {
                    + "def ["
            1
        } else if (isNumber(value)) {
        static int normalizeIndex(final Object[] array, final int index) {
    /**
    private static MethodHandle lookupReferenceInternal(
            return arrayLengthGetter(receiverClass);
    }
    /** pointer to Map.put(Object,Object) */
            return new Iterator<Object>() {
    /**
            case Character charValue -> charValue;
    }
                @Override
                }
                Def.class,
        if (value == null) {
            );
    public static String defToStringImplicit(final Object value) {
                    + "def ["
     * </p>
    public static Object mapIndexNormalize(final Map<?, ?> value, Object index) {
            return charValue;
                    + boolean.class.getCanonicalName()
        } else if (List.class.isAssignableFrom(receiverClass)) {
     * Looks up handle for a dynamic field getter (field load)
        int captures
            throw new ClassCastException(
        );
                    return PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(
 *
    }
            };
                @Override
                }
            return stringValue;
            default -> throw new ClassCastException(
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            throw new ClassCastException(
            throw new ClassCastException(
                    + "def ["
        }
                    + "def ["
        if (value == null) {
            default -> throw new ClassCastException(
        );
 *
                }
 * not use this file except in compliance with the License.
        } else if (isNumber(value)) {
            return new Iterator<Boolean>() {
            return charValue;
                }
        }
    private static final MethodHandle LIST_SET;
        }
        } else if (value instanceof Character) {
     * This method traverses {@code recieverClass}'s class hierarchy (including interfaces)
                    + "def ["
        } else if (isNumber(value)) {
    }
        PainlessMethod method = painlessLookup.lookupRuntimePainlessMethod(receiverClass, name, arity);
                        call,
     * <p>
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        MethodHandle handle = method.methodHandle;
        } else if (value instanceof Character) {
     * <p>
                "cannot explicitly cast "
        return value instanceof Byte
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                    + double.class.getCanonicalName()
        } else if (value instanceof Character) {
                    CallSite nested = DefBootstrap.bootstrap(
     *   <li>Allowlisted method named {@code isField()} from receiver's class/superclasses/interfaces.
        }
            return MAP_GET;
                int index = 0;
            throw new ClassCastException(
     * <ul>
                throw new IllegalArgumentException(
                    + float.class.getCanonicalName()
                        PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass(),
                String type = signature.substring(1, separator);
            case Long l -> (double) l;
    /**
                String signature = (String) args[upTo++];
        }
    public static Double defToDoubleExplicit(final Object value) {
     *   to use with array loads and array stores
        throw new IllegalArgumentException(
    public static Integer defToIntegerImplicit(final Object value) {
        return switch (value) {
     */
     * Otherwise it returns a handle to the matching method.
     *   <li>Allowlisted method named {@code getField()} from receiver's class/superclasses/interfaces.
     */
                rethrow(t);
        );
import org.opensearch.painless.lookup.PainlessLookupUtility;
    public static Integer defToIntegerExplicit(final Object value) {
     * @param receiverClass Class of the array to store the value in
     */
        throw (T) t;
                        + "] not found"
 * Modifications Copyright OpenSearch Contributors. See
                    + "def ["
                int[].class,
    }
                    return index < array.length;
import java.lang.invoke.CallSite;
     * Returns a method handle to do an array store.
        static Iterator<Float> iterator(final float[] array) {
                "cannot explicitly cast "
                : OBJECT_ARRAY_MH.asType(OBJECT_ARRAY_MH.type().changeParameterType(0, arrayType));
            }
            return ((Number) value).intValue();
        } else {
    @SuppressWarnings("unused") // getArrayLength() methods are are actually used, javac just does not know :)
     * <ul>
            return (float) (char) value;
/*
                return (MethodHandle) JAVA9_ARRAY_LENGTH_MH_FACTORY.invokeExact(arrayType);
        if (value instanceof String stringValue) {
            LIST_SET = methodHandlesLookup.findVirtual(List.class, "set", MethodType.methodType(Object.class, int.class, Object.class));
                        + ", "
                    + "def ["
            case Character c -> (double) c;
                public Float next() {
            default -> throw new ClassCastException(
            // lists allow access like mylist.0
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        }
        } else if (Map.class.isAssignableFrom(receiverClass)) {
            if (injections.length > 0) {
            return array.length;
     *   <li>The value corresponding to a map key named {@code field} when the receiver is a Map.
            return new Iterator<Character>() {
            "Attempting to address a non-array type " + "[" + receiverClass.getCanonicalName() + "] as an array."
                int numCaptures = Integer.parseInt(signature.substring(separator2 + 1));
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * @return pointer to matching field. never returns null.
        static int getArrayLength(final short[] array) {
     * @param receiverClass Class of the array to store the value in
                throw new IllegalArgumentException("type must be an array");
            return charValue;
        Map<String, Object> constants,
    }
                public Boolean next() {
                    + "def ["
            "Attempting to address a non-array type " + "[" + receiverClass.getCanonicalName() + "] as an array."
    public static byte defTobyteExplicit(final Object value) {
    public static double defTodoubleImplicit(final Object value) {
import java.lang.invoke.MethodHandle;
                boolean[].class,
            );
    // Conversion methods for def to boxed types.
        } else if (isNumber(value)) {
    }
            return ((Number) value).shortValue();
            Stream.of(
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        } else {
        private ArrayIndexNormalizeHelper() {}
     * @return a MethodHandle that accepts the receiver as first argument, the index as second argument, and returns the normalized index
            );
        int arity = interfaceMethod.typeParameters.size();
            case Short shortValue -> shortValue;
                        painlessLookup,
            return ArrayIndexNormalizeHelper.arrayIndexNormalizer(receiverClass);
            constants,
        static int normalizeIndex(final short[] array, final int index) {
    }
        };
            Stream.of(
        } else {
            methodHandlesLookup,
        }
        if (value instanceof Character charValue) {
            case Short i -> (int) i;
 * this file be licensed under the Apache-2.0 license or a
    private static final MethodHandle MAP_GET;
 * You may obtain a copy of the License at
        // lookup up the factory for arraylength MethodHandle (intrinsic) from Java 9:
     * A dynamic field load for variable {@code x} of type {@code def} looks like:
                }
        }
                        methodHandlesLookup,
        } else if (isNumber(value)) {
 * Licensed to Elasticsearch under one or more contributor
        if (value == null) {
    }
        final MethodHandles.Lookup methodHandlesLookup = MethodHandles.publicLookup();
                );
            throw new IllegalArgumentException("Cannot iterate over [" + receiverClass.getCanonicalName() + "]");
            case Byte b -> (long) b;
            };
            );
        int arity = callSiteType.parameterCount() - 1;
        Class<?> interfaceType = painlessLookup.canonicalTypeNameToType(interfaceClass);
        if (value instanceof Byte byteValue) {
    public static char defTocharExplicit(final Object value) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                "cannot implicitly cast "
        } else {
                throw new IllegalArgumentException("type must be an array");
     * @return pointer to matching method to invoke. never returns null.
            return null;
        }
                    + long.class.getCanonicalName()
            || value instanceof Float
                    + "def ["
                        constants,
    /**
     *   <li>The value in a list at element {@code field} (integer) when the receiver is a List.
            // wire '0' (index) as a parameter, its a constant. this also avoids
            );
                try {
            return ((Number) value).shortValue();
            throw new ClassCastException(
        if (implMethod == null) {
                int index = 0;
                "cannot implicitly cast "
 * license agreements. See the NOTICE file distributed with
    // TODO: Once Java has a factory for those in java.lang.invoke.MethodHandles, use it:
            throw new ClassCastException(
    public static int defTointExplicit(final Object value) {
            return getter;
            default -> throw new ClassCastException(
     * until it finds a matching allowlisted method. If one is not found, it throws an exception.
 * this work for additional information regarding copyright
     * @return a MethodHandle that accepts the receiver as first argument, the index as second argument.
     * Otherwise it returns a handle to the matching setter.
     * @return a MethodHandle that accepts the receiver as first argument, the index as second argument,
            return shortValue;
    private static final MethodHandle LIST_INDEX_NORMALIZE;
            return byteValue;
                @Override
 * <p>
            functions,
                public boolean hasNext() {
        PainlessLookup painlessLookup,
 * under the License.
        }
                "cannot explicitly cast "
        try {
        MethodHandles.Lookup methodHandlesLookup,
                int index = 0;
                double[].class,
    static MethodHandle lookupIterator(Class<?> receiverClass) {
                public Character next() {
                public boolean hasNext() {
                public Long next() {
        if (receiverClass.isArray() && "length".equals(name)) {
     * as they could be, but works.
    @SuppressWarnings("unused") // normalizeIndex() methods are are actually used, javac just does not know :)
            }
     * </p>
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
 */
                int index = 0;
                        + "["
                }
                        call,
            return ITERATOR;
            case Character c -> (int) c;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            // its a functional reference, replace the argument with an impl
        } else {
        static int normalizeIndex(final double[] array, final int index) {
                MethodHandles.class,
            if (!arrayType.isArray()) {
            return null;
            }
            return index >= 0 ? index : index + array.length;
            return null;
                        functions,
        }
            default -> throw new ClassCastException(
            return (short) (char) value;
        final CallSite callSite = LambdaBootstrap.lambdaBootstrap(
            return new Iterator<Long>() {
        }
    }
        } else {
                long[].class,
        private static final Map<Class<?>, MethodHandle> ARRAY_TYPE_MH_MAPPING = Collections.unmodifiableMap(
    /**
                "cannot implicitly cast "
            case Integer i -> (float) i;
            return index >= 0 ? index : index + array.length;
    public static String defToStringExplicit(final Object value) {
    /** Helper class for isolating MethodHandles and methods to get iterators over arrays
                    + "def ["
     * @throws IllegalArgumentException if no matching allowlisted field was found.
            };
        } else if (isNumber(value)) {
            throw new ClassCastException(
                @Override
    /** pointer to List.get(int) */
            return MethodHandles.insertArguments(MAP_PUT, 1, name);
            } catch (NumberFormatException exception) {
            ref.delegateInjections
        if (value == null) {
    }
                    + "def ["
                }
        } else if (isNumber(value)) {
        if (value == null) {
    }
                    + Character.class.getCanonicalName()
            case Long longValue -> longValue;
     * </ul>
    public static Character defToCharacterExplicit(final Object value) {
        for (int i = 1; i < numArguments; i++) {
        // first try allowlist
                Object[].class
        }
        } else if (List.class.isAssignableFrom(receiverClass)) {
                    + "def ["
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
/*
    /**
        if (interfaceType == null) {
     * </p>
        };
                replaced += numCaptures;
                "cannot implicitly cast "
            ).collect(Collectors.toMap(Function.identity(), type -> {
        }
import org.opensearch.painless.lookup.PainlessMethod;
import java.util.List;
        static MethodHandle arrayLengthGetter(Class<?> arrayType) {
    }
            return index >= 0 ? index : index + array.length;
     * @param name Name of the method.
            }
                public boolean hasNext() {
                    + "] to "
}
     */
            return index >= 0 ? index : index + array.length;
     * @param name Name of the field.
            Stream.of(
        // special case: maps, and lists
            return null;
                i += numCaptures;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
        private ArrayIteratorHelper() {}
                "cannot implicitly cast "
                char[].class,
    public static Long defToLongImplicit(final Object value) {
                        + "/"
            );
                // the filter now ignores the signature (placeholder) on the stack
            };
                        + typeToCanonicalTypeName(receiverClass)
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
                    + "] to "
                    "dynamic method "
     * @return a MethodHandle that accepts the receiver as first argument, returns iterator
                "cannot explicitly cast "
                    + "] to "
            throw new AssertionError(roe);
                    + "] to "
            case Float floatValue -> floatValue;
                    return PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(
            return array.length;
            case Integer i -> (long) i;
        static MethodHandle newIterator(Class<?> arrayType) {
        return switch (value) {
            return (ARRAY_TYPE_MH_MAPPING.containsKey(arrayType))
                "cannot explicitly cast "
        return switch (value) {
                }
        }
            }))
            throw new ClassCastException(
                String call = signature.substring(separator + 1, separator2);
            return ArrayIteratorHelper.newIterator(receiverClass);
                float[].class,
            return ((Number) value).doubleValue();
    }
        } else {
            case Byte b -> (short) b;
        };
            case Character charValue -> Utility.charToString(charValue);
                int index = 0;
            return array.length;
                boolean[].class,
            };
    }
                    + "] to "
     * @param args bootstrap args passed to callsite
            }
        }
     * Looks up handle for a dynamic field setter (field store)
                        PainlessLookupUtility.typeToCanonicalTypeName(interfaceType)
import java.util.stream.Stream;
                    + Float.class.getCanonicalName()
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
 * SPDX-License-Identifier: Apache-2.0
        } catch (final ReflectiveOperationException roe) {
                        functions,
        private static final MethodHandle OBJECT_ARRAY_MH = ARRAY_TYPE_MH_MAPPING.get(Object[].class);
                int index = 0;
        } else if (value instanceof Character) {
                    + byte.class.getCanonicalName()
            return null;
    public static Byte defToByteExplicit(final Object value) {
                    throw new AssertionError(e);
    }
     * "Normalizes" the idnex into a {@code List} by flipping negative indexes around so they are "from the end" of the list.
        }
        } else if (isNumber(value)) {
            if (!arrayType.isArray()) {
    /**
                    + "def ["
            );
                @Override
        } else if (value instanceof Character charValue) {
            if (lambdaArgs.get(i - 1)) {
        if (value instanceof Character) {
                        constants,
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
 * The OpenSearch Contributors require contributions made to
        } else if (value instanceof Short shortValue) {
    /** pointer to List.set(int,Object) */
                    + "] to "
                public boolean hasNext() {
                int index = 0;
    public static float defTofloatImplicit(final Object value) {
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            );
            case Short shortValue -> shortValue;
            return index >= 0 ? index : index + array.length;
                Def.class,
            );
                    // the implementation is strongly typed, now that we know the interface type,
                try {
    public static Boolean defToBoolean(final Object value) {
                        "iterator",
        } else if (isNumber(value)) {
                    return array[index++];
    // Conversion methods for def to primitive types.
     * (to emulate "enhanced for loop" using MethodHandles). These cause boxing, and are not as efficient
    /**
     * @param receiverClass Class of the object to invoke the method on.
    static MethodHandle lookupGetter(PainlessLookup painlessLookup, Class<?> receiverClass, String name) {
 * KIND, either express or implied.  See the License for the
        Object[] injections = PainlessLookupUtility.buildInjections(method, constants);
        int upTo = 1;
                throw new IllegalArgumentException("Illegal list shortcut value [" + name + "].");
            case Long l -> (float) l;
            case null -> null;
                "dynamic method [" + typeToCanonicalTypeName(receiverClass) + ", " + name + "/" + arity + "] not found"
                    + byte.class.getCanonicalName()
            );
            throw new ClassCastException(
    public static Byte defToByteImplicit(final Object value) {
        }
                    + "] to "
            LIST_INDEX_NORMALIZE = methodHandlesLookup.findStatic(
    }
        }
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
     * Returns a method handle to do an array load.
        if (receiverClass.isArray()) {
            case Byte byteValue -> byteValue;
                    + PainlessLookupUtility.typeToUnboxedType(value.getClass()).getCanonicalName()
            if (painlessMethod == null) {
            };
    @SuppressWarnings("unchecked")
            MAP_INDEX_NORMALIZE = methodHandlesLookup.findStatic(
                }
     */
        }
    public static int listIndexNormalize(final List<?> value, int index) {
        }
            return ((Number) value).longValue();
        static int normalizeIndex(final float[] array, final int index) {
                    return index < array.length;
                    + "] to "
        );
                byte[].class,
        static Iterator<Character> iterator(final char[] array) {
    public static double defTodoubleExplicit(final Object value) {
            return MethodHandles.insertArguments(MAP_GET, 1, name);
            );
            throw new IllegalArgumentException("type [" + interfaceClass + "] not found");
     * Methods to normalize array indices to support negative indices into arrays stored in {@code def}s.
                }
                    return index < array.length;
            MAP_PUT = methodHandlesLookup.findVirtual(Map.class, "put", MethodType.methodType(Object.class, Object.class, Object.class));
    static final MethodHandle JAVA9_ARRAY_LENGTH_MH_FACTORY;
        } else {
                    + "] to "
    }
        };
                int index = Integer.parseInt(name);
                        interfaceType,
                float[].class,
     * @throws Throwable if a method reference cannot be converted to an functional interface
                    );
            );
            return charValue;
 */
                        0,
            return ((Number) value).doubleValue();
                public Byte next() {
        }
            throw new ClassCastException(
            case Byte b -> (int) b;
            ).collect(Collectors.toMap(Function.identity(), type -> {
            case null -> null;
                    filter = nested.dynamicInvoker();
            case Double v -> v;
        }
            return MAP_INDEX_NORMALIZE;
        } else {
    /**
            );
    public static Float defToFloatExplicit(final Object value) {
                if (signature.charAt(0) == 'S') {
        } else if (Map.class.isAssignableFrom(receiverClass)) {
            return ((Number) value).byteValue();
    /** Helper class for isolating MethodHandles and methods to get the length of arrays
        static int getArrayLength(final float[] array) {
    public static Double defToDoubleImplicit(final Object value) {
            return index >= 0 ? index : index + array.length;
                    + "] to "
            return index >= 0 ? index : index + array.length;
                    + Long.class.getCanonicalName()
        );
        } else if (value instanceof Character) {
                public Double next() {
            // parsing the same integer millions of times!
                    + "] to "
                throw new IllegalArgumentException("type must be an array");
            );
    }
        PainlessLookup painlessLookup,
        static int getArrayLength(final long[] array) {
                "cannot implicitly cast "
            || value instanceof Integer
        }
    }
     * <p>
                } catch (ReflectiveOperationException e) {
        }
        } else {
        static int normalizeIndex(final int[] array, final int index) {
                    + Long.class.getCanonicalName()
     * @param receiverClass Class of the array to load the value from
                "cannot explicitly cast "
                    + Short.class.getCanonicalName()
            return array.length;
            case Character c -> (float) c;
        }
     * <p>
        );
        if (interfaceMethod == null) {
                "cannot explicitly cast "
                    // the interface type is now known, but we need to get the implementation.
