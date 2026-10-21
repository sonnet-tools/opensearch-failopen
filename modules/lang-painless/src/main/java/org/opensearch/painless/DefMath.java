        MethodHandle cast = DYNAMIC_CAST.bindTo(desired);
                    case Double v -> leftChar >= v;
    // eq: applicable to any arbitrary type, including nulls for both arguments!!!
 * this work for additional information regarding copyright
        } else if (left instanceof Character leftChar) {
                } else if (left instanceof Float || right instanceof Float) {
        );
/*
    private static int rem(int a, int b) {
                return switch (right) {
    }
    }
        throw new ClassCastException("Cannot apply [&] operation to type [float]");
    }
 * under the License.
        }
            return intIntegralValue(left) & intIntegralValue(right);
        MethodType targetType = MethodType.methodType(target.type().returnType()).unwrap();
    }
            return ((Number) o).longValue();
import java.util.function.Function;
        return a >= b;
            return Integer.valueOf(charValue);
    private static double rsh(double a, long b) {
            } else if (right instanceof Character rightChar) {
            if (clazz == value.getClass()) {
    private static double or(double a, double b) {
    }
                    case Float f -> f < rightChar;
                return switch (right) {
import java.util.stream.Stream;
        } else {
                } else {
    }
                    return (char) left == rightFloat;
        } else if (left instanceof Long || right instanceof Long) {
    private static double mul(double a, double b) {
    }
        if (a == double.class || b == double.class) {
                return switch (left) {
                    Class<?> clazz = PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass();
    }
    }
            return longIntegralValue(left) ^ longIntegralValue(right);
        return MethodHandles.explicitCastArguments(target, target.type().changeReturnType(newType.returnType()));
    }
                    case Double v -> v - rightChar;
    private static long rsh(long a, long b) {
    private static long neg(long v) {
    }
                + right.getClass().getCanonicalName()
                + "] and ["
    }
        throw new ClassCastException(
                    case Float f -> f > rightChar;
    }
        throw new ClassCastException("Cannot apply [-] operation to type [boolean]");
    private static boolean lsh(boolean a, long b) {
            return value;
                "Cannot apply [~] operation to type " + "[" + unary.getClass().getCanonicalName() + "]."
                return switch (right) {
        } else if (a == long.class || b == long.class) {
        throw new ClassCastException("Cannot apply not [~] to type [float]");
 * the Apache License, Version 2.0 (the "License"); you may
    private static int intIntegralValue(Object o) {
            } else if (right instanceof Character rightChar) {
        return a / b;
/**
    private static boolean gte(float a, float b) {
        }
        return a / b;
    }
                + "] and ["
                if (left instanceof Double || right instanceof Double) {
                + left.getClass().getCanonicalName()
            case Long l -> -l;
    }
        } else if (left instanceof Long || right instanceof Long) {
                return leftChar <= rightChar;
                } else if (left instanceof Character) {
                    case Float f -> leftChar + f;
                MethodType.methodType(Object.class, Object.class, Object.class)
                    return leftNum.doubleValue() == rightDouble;
                    case Double v -> leftChar - v;
                    default -> leftNum.intValue() % rightChar;
        throw new ClassCastException("Cannot apply [>=] operation to type [boolean]");
                + "["
    private static boolean gt(Object left, Object right) {
        throw new ClassCastException("Cannot apply [|] operation to type [float]");
                };
            return leftBool ^ rightBool;
            return dynamicCast(lhs.getClass(), returnValue);
        }
                } else if (left instanceof Float || right instanceof Float) {
    }
                } else if (left instanceof Float || right instanceof Float) {
        throw new ClassCastException("Cannot apply [^] operation to type [float]");
                + left.getClass().getCanonicalName()
                    map.put("gt", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "gt", comparison));
    private static double and(double a, double b) {
                }
            return left.equals(right);
            }
            return left + rightString;
        throw new ClassCastException("Cannot apply [^] operation to type [float]");
            "Cannot apply [*] operation to types "
    private static long plus(long v) {
        return MethodHandles.foldArguments(cast, target);
import java.util.Collections;
                }
        return -v;
    private static boolean lt(Object left, Object right) {
        } else if (left instanceof Character leftChar) {
    }
                    return leftNum.longValue() == rightLong;
        // don't do a conversion if types are the same. explicitCastArguments has this opto,
    }
 * The OpenSearch Contributors require contributions made to
                    default -> leftNum.intValue() / rightChar;
            throw new ClassCastException("Cannot cast " + targetType.returnType() + " to " + newType.returnType());
        // always promoted to integer
                    map.put("gte", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "gte", comparison));
    }
                    case Double v -> v + rightChar;
    }
            case Byte b -> ~b;
        return a - b;
 * KIND, either express or implied.  See the License for the
                    default -> leftChar <= rightNum.intValue();
                    case Double v -> leftChar * v;
                + "]."
            }))
                    return leftNum.floatValue() == rightFloat;
        }
                    case Double v -> v <= rightChar;
        }
    }
    private static boolean eq(float a, float b) {
    }
                + left.getClass().getCanonicalName()
        if (left instanceof Number leftNum) {
                    case Float f -> leftChar > f;
                    case Float f -> f >= rightChar;
 */
                    case Float f -> leftChar <= f;
    }
        return MethodType.methodType(clazz).unwrap().returnType();
            return leftBool & rightBool;
    private static long rem(long a, long b) {
            case Character c -> -c;
                    case Long l -> l - rightChar;
                } else if (left instanceof Float || right instanceof Float) {
    }
            } else if (right instanceof Double rightDouble) {
    private static long add(long a, long b) {
        throw new ClassCastException("Cannot apply [>>>] operation to type [boolean]");
    }
                + left.getClass().getCanonicalName()
            } else if (left instanceof Long leftLong) {
    private static double xor(double a, double b) {
        return a / b;
    }
                    case Long l -> l <= rightChar;
            } else if (clazz == Double.class) {
                    return leftNum.doubleValue() * rightNum.doubleValue();
    // Unary not: only applicable to integral types
        return -v;
                    map.put("eq", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "eq", comparison));
    /** Returns an appropriate method handle for a binary operator, based on promotion of the LHS and RHS arguments */
        }
    }
    }
        return a <= b;
        desired = MethodType.methodType(desired).wrap().returnType();
                } else {
        return a % b;
                    MethodType unary = MethodType.methodType(type, type);
                };
                    Map<String, MethodHandle> map = new HashMap<>();
    private static double add(double a, double b) {
                } else if (left instanceof Long || right instanceof Long) {
                };
    private static int plus(int v) {
    private static Object sub(Object left, Object right) {
        } else if (left instanceof Character leftChar) {
        return a >= b;
    private static Object div(Object left, Object right) {
            }
            if (right instanceof Number rightNum) {
                return switch (left) {
        return a == b;
    private static double sub(double a, double b) {
        MethodType newType = MethodType.methodType(classA).unwrap();
        try {
            if (right instanceof Number rightNum) {
            return int.class;
                + right.getClass().getCanonicalName()
    private static boolean lte(int a, int b) {
        return a % b;
                    return leftNum.doubleValue() > rightNum.doubleValue();
        }
        }
 */
        return a > b;
            } else if (left instanceof Number leftNum) {
                };
        if (handle == null) {
                if (right instanceof Number rightNum) {
            }
                    case Long l -> l % rightChar;
        }
            case Byte b -> +b;
            return intIntegralValue(left) | intIntegralValue(right);
    // helper methods to convert an integral according to numeric promotion
    /** Looks up generic method, with a dynamic cast to the receiver's type. (compound assignment) */
    /**
    }
                    case Double v -> leftChar <= v;
                return switch (left) {
                    case Double v -> leftChar + v;
        } else {
    private static boolean eq(int a, int b) {
                return getNumber(value).shortValue();
        if (a.isPrimitive() == false || b.isPrimitive() == false) {
        throw new ClassCastException("Cannot apply [<<] operation to type [boolean]");
            return ((Number) o).intValue();
    private static boolean gte(double a, double b) {
    }
                    map.put("div", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "div", binary));
    /** Slowly returns a Number for o. Just for supporting dynamicCast */
                }
        throw new ClassCastException("Cannot apply [>>>] operation to type [float]");
                try {
                }
                } else if (right instanceof Character) {
    private static float not(float v) {
 * Licensed to Elasticsearch under one or more contributor
            } else if (clazz == Short.class) {
    private static boolean lte(long a, long b) {
    private static Object xor(Object left, Object right) {
    }
                } else if (right instanceof Character) {
    }
    /** Returns a generic method handle for any operator, that can handle all valid signatures, nulls, corner cases */
            }
            "Cannot apply [>] operation to types "
    private static float or(float a, float b) {
            );
public class DefMath {
    }
            "Cannot apply [/] operation to types "
                return leftChar * rightChar;
            }
                    return leftNum.doubleValue() >= rightNum.doubleValue();
            if (right instanceof Number rightNum) {
    private static boolean ush(boolean a, long b) {
        throw new ClassCastException(
                } else {
            case Short s -> ~s;
                + "]."
    private static boolean add(boolean a, boolean b) {
    }
            if (right instanceof Number rightNum) {
                if (left instanceof Double || right instanceof Double) {
            } else if (clazz == Long.class) {
    private static boolean gt(int a, int b) {
            if (right instanceof Number rightNum) {
                    return leftNum.longValue() + rightNum.longValue();
                    case Double v -> v >= rightChar;
        };
    }
        return +v;
            case Integer i -> +i;
                + right.getClass().getCanonicalName()
        return a - b;
                } else if (left instanceof Long || right instanceof Long) {
 * <p>
        return a + b;
        return a < b;
    static {
/*
            return clazz.cast(value);
    private static boolean eq(boolean a, boolean b) {
        throw new ClassCastException("Cannot apply [+] operation to type [boolean]");
    }
        // adapt dynamic cast to the generic method
                return switch (left) {
                return leftChar > rightChar;
            }
        return a >>> b;
                    default -> leftChar > rightNum.intValue();
     * based upon inspection. If {@code lhs} is null, no cast takes place.
     * based upon inspection. If {@code lhs} is null, no cast takes place.
    private static double plus(double v) {
    }
                + "]."
                    return leftNum.longValue() - rightNum.longValue();
        throw new ClassCastException("Cannot apply [<] operation to type [boolean]");
    // multiplication/division/remainder/subtraction: applicable to all integer types
    private static boolean xor(boolean a, boolean b) {
                    return leftNum.doubleValue() <= rightNum.doubleValue();
    }
        return a & b;
                    map.put("lte", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "lte", comparison));
        throw new ClassCastException(
                    return leftNum.doubleValue() < rightNum.doubleValue();
     * unboxes a class to its primitive type, or returns the original
            } else if (clazz == Byte.class) {
    private static Object mul(Object left, Object right) {
            case Double v -> +v;
                + "] and ["
            if (right instanceof Number rightNum) {
        final MethodHandles.Lookup methodHandlesLookup = MethodHandles.lookup();
    private static boolean and(boolean a, boolean b) {
                };
                + "]."
                return value;
    private static boolean gte(long a, long b) {
}
                } else if (left instanceof Float || right instanceof Float) {
            } else if (right instanceof Character rightChar) {
                    return leftNum.floatValue() % rightNum.floatValue();
                "Cannot apply [-] operation to type " + "[" + unary.getClass().getCanonicalName() + "]."
    private static double neg(double v) {
            }
    }
            case Float v -> +v;
            if (clazz == Integer.class) {
    }
    private static long lsh(long a, long b) {
    private static boolean lt(double a, double b) {
    }
        // but we do it explicitly, to make the boolean check simpler
        return ~v;
                if (right instanceof Number rightNum) {
                    case Long l -> l >= rightChar;
import java.lang.invoke.MethodHandle;
            } else if (right instanceof Character rightChar) {
        return a | b;
        throw new ClassCastException(
                    return leftNum.intValue() <= rightNum.intValue();
    }
    }
        throw new ClassCastException("Cannot apply [>>] operation to type [boolean]");
 * SPDX-License-Identifier: Apache-2.0
            case Character c -> ~c;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private static double rem(double a, double b) {
        // adapt dynamic receiver cast to the generic method
    private static long div(long a, long b) {
    private static long and(long a, long b) {
    private static int and(int a, int b) {
        };
                    case Float f -> leftChar < f;
        if (left instanceof Number leftNum) {
                    map.put("lt", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "lt", comparison));
                };
    }
            throw new ClassCastException("Cannot convert [" + o.getClass().getCanonicalName() + "] to an integral value.");
    }
                if (left instanceof Double || right instanceof Double) {
 *
    private static boolean lte(Object left, Object right) {
            return float.class;
    }
        throw new ClassCastException("Cannot apply not [~] to type [double]");
        if (clazz == byte.class || clazz == short.class || clazz == char.class || clazz == int.class) {
        return -v;
        if (left instanceof Number leftNum) {
        if (o instanceof Integer || o instanceof Short || o instanceof Byte) {
    }
    }
        } else {
            return returnValue;
    static Number getNumber(Object o) {
    private static long xor(long a, long b) {
        } else {
    }
    }
                    return leftNum.longValue() >= rightNum.longValue();
        }
    // unary negation and plus: applicable to all numeric types
        return a > b;
                    case Long l -> leftChar >= l;
    }
    private static float neg(float v) {
            if (right instanceof Number rightNum) {
    private static float add(float a, float b) {
            return leftLong >>> right;
                "Cannot apply [+] operation to type " + "[" + unary.getClass().getCanonicalName() + "]."
                };
        return a / b;
                    default -> leftChar * rightNum.intValue();
        return a ^ b;
                };
    }
    }
        } else if (left instanceof Number leftNum) {
    }
    private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();
    private static boolean lt(float a, float b) {
                } else if (left instanceof Long || right instanceof Long) {
    /**
    private static boolean lt(long a, long b) {
            } else if (right instanceof Character rightChar) {
            }
    private static Object rem(Object left, Object right) {
        return a == b;
        }
        MethodHandle handle = TYPE_OP_MAPPING.get(promote(unbox(receiverClass))).get(name);
                } else if (left instanceof Character) {
        return a < b;
                };
                return leftChar < rightChar;
                    return leftNum.doubleValue() % rightNum.doubleValue();
            case Long l -> +l;
            case Integer i -> -i;
        );
                } else if (left instanceof Long || right instanceof Long) {
 * license agreements. See the NOTICE file distributed with
                    case Double v -> leftChar > v;
                    return leftNum.intValue() - rightNum.intValue();
                return (char) getNumber(value).intValue();
                }
        MethodHandle cast = DYNAMIC_RECEIVER_CAST.asType(
                return leftChar + rightChar;
            return leftBool | rightBool;
            default -> throw new ClassCastException(
        return a % b;
    private static boolean not(boolean v) {
            }
    }
    private static boolean eq(Object left, Object right) {
                    return leftNum.floatValue() > rightNum.floatValue();
                + right.getClass().getCanonicalName()
        } else if (left instanceof Character leftChar) {
    // we implement all shifts as long shifts, because the extra bits are ignored anyway.
    private static int mul(int a, int b) {
            } else if (right instanceof Character rightChar) {
                    return leftNum.intValue() >= rightNum.intValue();
    }
                return leftChar - rightChar;
                };
                    default -> leftNum.intValue() > rightChar;
                } else if (left instanceof Long || right instanceof Long) {
        if (o instanceof Number number) {
        return a <= b;
                    map.put("sub", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "sub", binary));
                    return leftLong == (char) right;
            return Object.class;
    }
    private static final Map<Class<?>, Map<String, MethodHandle>> TYPE_OP_MAPPING = Collections.unmodifiableMap(
    }
        }
                + "]."
        return a <= b;
        return a > b;
import java.lang.invoke.MethodType;
        if (lhs != null) {
            MethodType.methodType(target.type().returnType(), target.type().returnType(), target.type().parameterType(0))
            case Byte b -> -b;
                    case Long l -> leftChar * l;
                + "] and ["
                    case Float f -> leftChar * f;
    static Object dynamicCast(Class<?> clazz, Object value) {
    private static boolean plus(boolean v) {
        throw new ClassCastException("Cannot apply [&] operation to type [float]");
    public static Object rsh(Object left, long right) {
    private static float and(float a, float b) {
                    return leftNum.intValue() == rightNum.intValue();
    private static int ush(int a, long b) {
    }
                    return leftNum.intValue() + rightNum.intValue();
    }
                    return leftFloat == rightNum.floatValue();
                + "] and ["
                    map.put("neg", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "neg", unary));
        return a & b;
    }
        return a << b;
        } else if (left instanceof Character leftChar) {
 * specific language governing permissions and limitations
        throw new ClassCastException("Cannot apply [*] operation to type [boolean]");
    }
        return +v;
        } else if (o instanceof Integer || o instanceof Short || o instanceof Byte) {
    private static boolean gte(boolean a, boolean b) {
            }
        }
                } else if (right instanceof Character) {
    // this is used by the generic code for bitwise and shift operators
        }
            );
    private static long sub(long a, long b) {
            if (right instanceof Number rightNum) {
                    map.put("mul", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "mul", binary));
        throw new ClassCastException("Cannot apply [>] operation to type [boolean]");
 * handles all legal types: it must be convertible to every possible legal signature.
            throw new ClassCastException("Cannot convert [" + o.getClass().getCanonicalName() + "] to an integral value.");
                methodHandlesLookup.lookupClass(),
                + "["
    }
        // if either is a non-primitive type -> Object.
        return a + b;
    }
                }
                    case Long l -> leftChar / l;
                + left.getClass().getCanonicalName()
    }
    }
@SuppressWarnings("unused")
        );
        } catch (ReflectiveOperationException e) {
                } else {
        );
            );
                    return leftNum.doubleValue() - rightNum.doubleValue();
 * not use this file except in compliance with the License.
                    case Float f -> leftChar >= f;
            if (right instanceof Number rightNum) {
        if (left instanceof Boolean leftBool && right instanceof Boolean rightBool) {
            "Cannot apply [<] operation to types "
import java.util.stream.Collectors;
            DYNAMIC_CAST = methodHandlesLookup.findStatic(
    }
                    case Float f -> leftChar - f;
        }
        return left == null && right == null;
                    return leftNum.intValue() / rightNum.intValue();
            );
                    return leftNum.longValue() <= rightNum.longValue();
        );
                + "] and ["
                    case Long l -> leftChar > l;
        return a - b;
 * Unless required by applicable law or agreed to in writing,
                    return leftDouble == (char) right;
                + "] and ["
        }
        } else {
    private static long ush(long a, long b) {
            return intIntegralValue(left) >> right;
            }
        }
                }
        }
            return intIntegralValue(left) ^ intIntegralValue(right);
    private static double ush(double a, long b) {
 * Each operator must "support" the following types:
    private static boolean lt(boolean a, boolean b) {
                } else if (left instanceof Long || right instanceof Long) {
                } else {
    private static float plus(float v) {
    private static int rsh(int a, long b) {
        return a * b;
            }
        return a * b;
                    case Float f -> f - rightChar;
            if (right instanceof Number rightNum) {
                };
            }
        // we don't allow the to/from boolean conversions of explicitCastArguments
        cast = MethodHandles.dropArguments(cast, 2, target.type().parameterType(1));
                    map.put("ush", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "ush", shift));
        } else if (o instanceof Character charValue) {
        if (left instanceof String leftString) {
        return switch (unary) {
                }
    }
                    case Double v -> v > rightChar;
                + "]."
                    return leftNum.floatValue() - rightNum.floatValue();
        throw new ClassCastException(
                + "]."
        throw new ClassCastException("Cannot apply [|] operation to type [float]");
            } else if (right instanceof Character rightChar) {
            return target;
        } else {
                + right.getClass().getCanonicalName()
                return getNumber(value).intValue();
    }
                    case Long l -> leftChar + l;
                + left.getClass().getCanonicalName()
    private static float rem(float a, float b) {
                + right.getClass().getCanonicalName()
        return a >> b;
                    case Double v -> leftChar < v;
                    return leftNum.intValue() % rightNum.intValue();
import java.util.HashMap;
        throw new ClassCastException("Cannot apply [%] operation to type [boolean]");
            throw new AssertionError(e);
    private static long longIntegralValue(Object o) {
    }
                    return map;
    }
                    map.put("or", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "or", binary));
    private static boolean gte(Object left, Object right) {
        if (newType.returnType() == boolean.class || targetType.returnType() == boolean.class) {
    /**
        throw new ClassCastException("Cannot apply [<<] operation to type [double]");
            if (right instanceof Number rightNum) {
    }
                    return leftNum.intValue() * rightNum.intValue();
    }
            return intIntegralValue(left) >>> right;
                    map.put("xor", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "xor", binary));
                    return leftLong == rightNum.longValue();
                if (left instanceof Double || right instanceof Double) {
                if (left instanceof Number leftNum) {
    private static boolean or(boolean a, boolean b) {
    }
            if (right instanceof Number rightNum) {
                    return leftNum.intValue() > rightNum.intValue();
    }
 * this file be licensed under the Apache-2.0 license or a
        throw new ClassCastException("Cannot apply not [~] to type [boolean]");
                    case Float f -> leftChar / f;
                + "] and ["
            }
                    return (char) left == rightDouble;
    private static double lsh(double a, long b) {
                    default -> leftNum.intValue() <= rightChar;
                    map.put("not", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "not", unary));
                + "["
                };
            if (right instanceof Number rightNum) {
import java.lang.invoke.MethodHandles;
        return a ^ b;
    }
    }
    private static boolean eq(long a, long b) {
            }
    private static int add(int a, int b) {
            } else if (right instanceof Number rightNum && left instanceof Character leftChar) {
    }
            case Double v -> -v;
        if (left instanceof Boolean leftBool && right instanceof Boolean rightBool) {
    private static int not(int v) {
            default -> throw new ClassCastException(
 *
        return a | b;
    private static Object neg(final Object unary) {
    }
                return switch (right) {
                    default -> leftNum.intValue() >= rightChar;
    /** Forces a cast to class A for target (only if types differ) */
        if (left instanceof Number leftNum) {
                }
        throw new ClassCastException("Cannot apply [<<] operation to type [float]");
                }
    private static int sub(int a, int b) {
    public static MethodHandle dynamicCast(MethodHandle target, Class<?> desired) {
                return leftChar / rightChar;
                    map.put("and", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "and", binary));
        // boolean -> boolean
                    map.put("plus", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "plus", unary));
    }
        }
    private static float lsh(float a, long b) {
        if (left instanceof Number leftNum) {
        throw new ClassCastException("Cannot apply [/] operation to type [boolean]");
        MethodHandle handle = TYPE_OP_MAPPING.get(promote(promote(unbox(classA)), promote(unbox(classB)))).get(name);
    private static Object add(Object left, Object right) {
            return longIntegralValue(left) | longIntegralValue(right);
                    map.put("add", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "add", binary));
        } else if (left instanceof Character leftChar) {
                } else {
    }
            case Short s -> -s;
            } else if (right instanceof Character rightChar) {
        };
            "Cannot apply [<=] operation to types "
        return a > b;
    private static int xor(int a, int b) {
    private static float div(float a, float b) {
                    default -> leftNum.intValue() + rightChar;
                }
            } else if (right instanceof Character rightChar) {
            case Short s -> +s;
 * You may obtain a copy of the License at
                + "] and ["
        } else {
        } else if (left instanceof Character leftChar) {
                + left.getClass().getCanonicalName()
        // combine: f(x,y) -> g(f(x,y), x, y);
            );
        if (value != null) {
                    return leftNum.longValue() / rightNum.longValue();
        return a >= b;
                if (left instanceof Number leftNum) {
    }
        if (newType.returnType() == targetType.returnType()) {
    /** Looks up generic method, with a dynamic cast to the specified type. (explicit assignment) */
                return switch (left) {
        }
            .collect(Collectors.toMap(Function.identity(), type -> {
            return long.class;
    /** Returns an appropriate method handle for a unary or shift operator, based only on the receiver (LHS) */
                    map.put("lsh", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "lsh", shift));
    private static boolean rsh(boolean a, long b) {
        throw new ClassCastException("Cannot apply [>>] operation to type [float]");
    private static long mul(long a, long b) {
        return a >>> b;
                return switch (right) {
            return double.class;
        Stream.of(boolean.class, int.class, long.class, float.class, double.class, Object.class)
            "Cannot apply [>] operation to types "
        return a - b;
            return leftString + right;
                + "]."
        } else if (left instanceof Character leftChar) {
        return a & b;
                + "["
    }
                    default -> leftChar >= rightNum.intValue();
                    return leftNum.intValue() == rightChar;
        // if either is a non-primitive type -> Object.
                };
                + "]."
    public static MethodHandle lookupUnary(Class<?> receiverClass, String name) {
        } else if (o instanceof Character charValue) {
        return +v;
    private static int neg(int v) {
    }
        return a * b;
    private static float xor(float a, float b) {
            DYNAMIC_RECEIVER_CAST = methodHandlesLookup.findStatic(
            } else if (right instanceof Long rightLong) {
                    map.put("rsh", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "rsh", shift));
    // bitwise operators: valid only for integral types
        throw new ClassCastException(
    }
    }
        return a + b;
    }
    }
            } else if (clazz == Character.class) {
    }
        if (left instanceof Boolean leftBool && right instanceof Boolean rightBool) {
 * {@code int,long,float,double,boolean,Object}. Operators can throw exceptions if
    }
    private static Object and(Object left, Object right) {
    }
    }
                return switch (left) {
                return switch (right) {
                };
        return a <= b;
        } else if (o instanceof Character charValue) {
    private static int lsh(int a, long b) {
                if (right instanceof Number rightNum) {
        return a + b;
            } else if (right instanceof Character rightChar) {
            default -> throw new ClassCastException(
            } else if (right instanceof Character rightChar) {
            } else if (right instanceof Character rightChar) {
                if (left instanceof Double || right instanceof Double) {
                MethodType.methodType(Object.class, Class.class, Object.class)
        return a << b;
    private static float sub(float a, float b) {
                + "["
                    case Long l -> leftChar - l;
    private static final MethodHandle DYNAMIC_RECEIVER_CAST;
        );
                + "["
                    case Long l -> leftChar < l;
            "Cannot apply [+] operation to types "
    }
    }
        }
        return a * b;
                }
        return handle;
                if (left instanceof Double || right instanceof Double) {
        if (left instanceof Long leftLong) {
        return ~v;
                    case Float f -> f * rightChar;
                + right.getClass().getCanonicalName()
                + "["
        throw new ClassCastException(
            if (left instanceof Double leftDouble) {
                    return leftNum.doubleValue() + rightNum.doubleValue();
                } else if (left instanceof Float || right instanceof Float) {
    private static long not(long v) {
 * GitHub history for details.
            return charValue;
    // additionally, if either type is a string, the other type can be any arbitrary type (including null)
                }
    public static MethodHandle lookupGeneric(String name) {
    private static boolean gt(long a, long b) {
    private static int or(int a, int b) {
        // ordinary numeric promotion
            case Float f -> -f;
    }
                } else {
 */
                    default -> leftChar + rightNum.intValue();
        return -v;
                    case Double v -> leftChar / v;
    public static MethodHandle cast(Class<?> classA, MethodHandle target) {
            if (right instanceof Number rightNum) {
                + left.getClass().getCanonicalName()
    public static MethodHandle lookupBinary(Class<?> classA, Class<?> classB, String name) {
    private static boolean div(boolean a, boolean b) {
 * software distributed under the License is distributed on an
        } else {
                    return leftNum.floatValue() <= rightNum.floatValue();
                    return leftNum.longValue() * rightNum.longValue();
    private static Object plus(final Object unary) {
            return intIntegralValue(left) << right;
    }
    }
                    case Long l -> l + rightChar;
        } else if (left instanceof Character leftChar) {
            }
 *
            return longValue;
                    return leftNum.floatValue() / rightNum.floatValue();
    }
     */
    // shift operators, valid for any integral types, but does not promote.
    }
                } else if (left instanceof Character) {
            return clazz;
                return getNumber(value).floatValue();
        throw new ClassCastException(
            } else if (left instanceof Character leftChar && right instanceof Character rightChar) {
            return charValue;
        if (left instanceof Number leftNum) {
        if (left instanceof Number leftNum) {
        return a >= b;
                return leftChar % rightChar;
     */
                };
                    default -> leftNum.intValue() * rightChar;
                    case Double v -> leftChar % v;
        if (left instanceof Number leftNum) {
                return switch (right) {
    }
            }
                    case Long l -> l * rightChar;
                    map.put("rem", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "rem", binary));
    static Object dynamicReceiverCast(Object returnValue, Object lhs) {
        if (left instanceof Long leftLong) {
        return a >> b;
 */
                } else if (left instanceof Float || right instanceof Float) {
    private static boolean lt(int a, int b) {
                if (right instanceof Number rightNum) {
            if (right instanceof Number rightNum) {
                    return leftNum.longValue() < rightNum.longValue();
                    case Float f -> leftChar % f;
            return longIntegralValue(left) & longIntegralValue(right);
        );
                return leftChar == rightNum.intValue();
                return switch (left) {
    private static boolean sub(boolean a, boolean b) {
            return leftLong << right;
        } else {
                }
                } else {
        if (clazz.isPrimitive() == false) {
    }
    private static double div(double a, double b) {
        return a == b;
    }
            } else if (right instanceof Float rightFloat) {
        }
    }
        }
        return a == b;
            case Integer i -> ~i;
                return switch (left) {
            throw new ClassCastException("Cannot convert [" + o.getClass() + "] to a Number");
    private static final MethodHandle DYNAMIC_CAST;
    private static Object not(Object unary) {
                } else if (left instanceof Long || right instanceof Long) {
            }
                } else if (left instanceof Long || right instanceof Long) {
            } else if (right instanceof Character rightChar) {
                return leftChar >= rightChar;
    }
     * Slow dynamic cast: casts {@code returnValue} to the runtime type of {@code lhs}
                    return leftNum.intValue() < rightNum.intValue();
        return switch (unary) {
    }
            } else if (right instanceof Character rightChar) {
                + "["
            "Cannot apply [-] operation to types "
    }
                return switch (right) {
                    return leftNum.floatValue() >= rightNum.floatValue();
    }
        return a | b;
    private static float rsh(float a, long b) {
                return getNumber(value).longValue();
                    case Long l -> l > rightChar;
        }
                };
        }
                    default -> leftChar - rightNum.intValue();
        return handle;
        }
        throw new ClassCastException("Cannot apply [>>] operation to type [double]");
                    default -> leftChar < rightNum.intValue();
        } else {
            } else if (clazz == Float.class) {
            return leftLong >> right;
                    case Double v -> v % rightChar;
            }
    }
                    default -> leftNum.intValue() - rightChar;
    public static Object lsh(Object left, long right) {
                if (left instanceof Double || right instanceof Double) {
        );
 * the type is illegal. The {@code Object} type must be a "generic" handler that
 * Modifications Copyright OpenSearch Contributors. See
                    default -> leftChar % rightNum.intValue();
                } else if (left instanceof Float || right instanceof Float) {
    }
                } else if (left instanceof Long || right instanceof Long) {
                    case Double v -> v / rightChar;
            return int.class;
                    MethodType binary = MethodType.methodType(type, type, type);
    }
    private static Class<?> unbox(Class<?> clazz) {
        );
                if (left instanceof Double || right instanceof Double) {
    }
                    default -> leftNum.intValue() < rightChar;
        } else if (left instanceof Long || right instanceof Long) {
        return a % b;
import java.util.Map;
    }
        return a == b;
            return boolean.class;
                    return leftNum.floatValue() + rightNum.floatValue();
    private static boolean eq(double a, double b) {
                if (left instanceof Double || right instanceof Double) {
                    return leftFloat == (char) right;
                "dynamicCast",
    public static MethodHandle dynamicCast(MethodHandle target) {
                } else if (left instanceof Float || right instanceof Float) {
                };
    private static long or(long a, long b) {
    }
     * Slow dynamic cast: casts {@code value} to an instance of {@code clazz}
                    MethodType shift = MethodType.methodType(type, type, long.class);
    // addition: applicable to all numeric types.
            throw new ClassCastException("Cannot apply operator [" + name + "] to types [" + classA + "] and [" + classB + "]");
    }
    private static boolean lte(double a, double b) {
                } catch (ReflectiveOperationException e) {
        }
                };
        throw new ClassCastException("Cannot apply [-] operation to type [boolean]");
                    case Long l -> l < rightChar;
    private static boolean lte(boolean a, boolean b) {
            } else if (right instanceof Character rightChar) {
    /** Binary promotion. */
/*
                    case Float f -> f + rightChar;
    public static Object ush(Object left, long right) {
                }
                "dynamicReceiverCast",
                    case Long l -> leftChar <= l;
    }
                    return leftDouble == rightNum.doubleValue();
    }
    }
    private static boolean rem(boolean a, boolean b) {
                return switch (right) {
    }
                    case Long l -> l / rightChar;
                    return (char) left == rightLong;
        return a < b;
        return a ^ b;
        throw new ClassCastException(
        }
                } else {
        // drop the RHS parameter
            if (right instanceof Number rightNum) {
     */
        return +v;
            "Cannot apply [%] operation to types "
    }
            if (right instanceof Number rightNum) {
        throw new ClassCastException("Cannot apply [<=] operation to type [boolean]");
                }
    private static boolean gt(boolean a, boolean b) {
 * ownership. Elasticsearch licenses this file to you under
    // comparison operators: applicable for any numeric type
    }
                    throw new AssertionError(e);
        } else {
        if (left != null && right != null) {
                    return leftNum.longValue() > rightNum.longValue();
        throw new ClassCastException("Cannot apply [>>>] operation to type [double]");
            return number;
    );
            }
                    return leftNum.floatValue() < rightNum.floatValue();
                + right.getClass().getCanonicalName()
                return leftChar == rightChar;
                return getNumber(value).doubleValue();
    private static Object or(Object left, Object right) {
    }
        if (a == boolean.class && b == boolean.class) {
                + "["
                } else if (right instanceof Character rightChar) {
package org.opensearch.painless;
                    case Float f -> f % rightChar;
    private static Class<?> promote(Class<?> a, Class<?> b) {
     * class if its not a boxed type.
        } else {
    private static double not(double v) {
                + right.getClass().getCanonicalName()
                }
    private static boolean gte(int a, int b) {
        return MethodHandles.filterReturnValue(target, cast);
    }
        return switch (unary) {
    }
                    default -> leftChar / rightNum.intValue();
                return getNumber(value).byteValue();
 * Dynamic operators for painless.
                return switch (left) {
            case Character c -> +c;
            if (right instanceof Number rightNum) {
                    MethodType comparison = MethodType.methodType(boolean.class, type, type);
                    return leftNum.longValue() % rightNum.longValue();
            case Long l -> ~l;
            throw new ClassCastException("Cannot apply operator [" + name + "] to type [" + receiverClass + "]");
                if (left instanceof Number leftNum) {
        }
    private static boolean mul(boolean a, boolean b) {
        return a < b;
    }
    }
                    case Long l -> leftChar % l;
                + left.getClass().getCanonicalName()
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (left instanceof Long leftLong) {
        // null return values are not possible for our arguments.
    private static boolean gt(double a, double b) {
                    case Float f -> f / rightChar;
 * compatible open source license.
            }
    private static float ush(float a, long b) {
        if (handle == null) {
        }
        throw new ClassCastException("Cannot apply [+] operation to type [boolean]");
    private static float mul(float a, float b) {
            } else if (right instanceof Character rightChar) {
    }
    private static boolean neg(boolean v) {
    }
            } else if (left instanceof Float leftFloat) {
    /** Unary promotion. All Objects are promoted to Object. */
    private static boolean lte(float a, float b) {
    }
        if (o instanceof Long longValue) {
                    return leftNum.floatValue() * rightNum.floatValue();
    private static int div(int a, int b) {
    }
        } else {
                    case Double v -> v * rightChar;
                    return leftNum.doubleValue() / rightNum.doubleValue();
        // bind to the boxed type
                methodHandlesLookup.lookupClass(),
            return Object.class;
                    case Float f -> f <= rightChar;
    private static Class<?> promote(Class<?> clazz) {
            } else if (right instanceof Character rightChar) {
    private static boolean gt(float a, float b) {
        } else if (right instanceof String rightString) {
        );
        } else if (a == float.class || b == float.class) {
     * This is used for the generic fallback case of compound assignment.
        return TYPE_OP_MAPPING.get(Object.class).get(name);
                    case Double v -> v < rightChar;
            } else if (right instanceof Character rightChar) {
        }
