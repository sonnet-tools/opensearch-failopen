            case Integer i -> -i;
    }
    private static long rsh(long a, long b) {
                } else if (left instanceof Long || right instanceof Long) {
                + "] and ["
                return leftChar == rightChar;  
            } else if (right instanceof Number rightNum && left instanceof Character leftChar) {  
            } else if (right instanceof Character rightChar) {
            if (right instanceof Number rightNum) {
            } else if (right instanceof Character rightChar) {
        return a == b;
    }  
                return leftChar == rightNum.intValue();
                    map.put("or", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "or", binary));  
                } else if (left instanceof Character) {  
            case Character c -> ~c;
            if (right instanceof Number rightNum) {  
    // bitwise operators: valid only for integral types  
        return a <= b;
        );  
                    return leftDouble == (char) right;
            if (clazz == value.getClass()) {
                    case Long l -> leftChar >= l;
            } else if (right instanceof Character rightChar) {
        return a >= b;
        return a > b;
                    case Long l -> l + rightChar;
                    return leftDouble == rightNum.doubleValue();
                    map.put("lte", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "lte", comparison));
 * ownership. Elasticsearch licenses this file to you under  
            } else if (right instanceof Character rightChar) {
    }
        } else if (left instanceof Character leftChar) {
    private static int not(int v) {  
        return a * b;
    public static MethodHandle lookupGeneric(String name) {  
                if (left instanceof Double || right instanceof Double) {
            } else if (left instanceof Number leftNum) {  
    }  
                + right.getClass().getCanonicalName()  
    }
                    return leftNum.longValue() - rightNum.longValue();
                }  
    private static double neg(double v) {
                if (left instanceof Double || right instanceof Double) {
            return value;
                    return leftNum.intValue() < rightNum.intValue();
    private static long lsh(long a, long b) {  
    }
            }
        // null return values are not possible for our arguments.
        } else if (o instanceof Character charValue) {
                methodHandlesLookup.lookupClass(),  
    }
                return getNumber(value).intValue();  
                return switch (left) {
            } else if (right instanceof Character rightChar) {
        // if either is a non-primitive type -> Object.
                    return leftNum.floatValue() < rightNum.floatValue();
            case Integer i -> ~i;
    }
            return Integer.valueOf(charValue);
        throw new ClassCastException("Cannot apply [&] operation to type [float]");  
        throw new ClassCastException("Cannot apply [<<] operation to type [float]");
        throw new ClassCastException("Cannot apply [>>] operation to type [float]");  
                    return leftNum.floatValue() + rightNum.floatValue();
                };
            throw new ClassCastException("Cannot apply operator [" + name + "] to types [" + classA + "] and [" + classB + "]");  
    private static Object neg(final Object unary) {
            }
    // shift operators, valid for any integral types, but does not promote.
            return leftString + right;  
                return leftChar / rightChar;  
    }
        throw new ClassCastException(
    }  
                } else if (left instanceof Character) {  
        return a & b;
            }
                + "["  
        Stream.of(boolean.class, int.class, long.class, float.class, double.class, Object.class)  
            return charValue;  
                } else {
                    map.put("rem", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "rem", binary));
        if (a.isPrimitive() == false || b.isPrimitive() == false) {  
        return a | b;  
/*
            }
                    case Float f -> f / rightChar;
    private static boolean lt(float a, float b) {
                + "["  
                if (right instanceof Number rightNum) {
                    return leftNum.intValue() <= rightNum.intValue();
 *  
    }  
    private static int and(int a, int b) {
        return a << b;  
    }  
        throw new ClassCastException("Cannot apply [>>] operation to type [boolean]");
        return a + b;  
    private static final MethodHandle DYNAMIC_CAST;
    }
    }
    private static double lsh(double a, long b) {
                + right.getClass().getCanonicalName()  
    private static double rem(double a, double b) {
    private static double plus(double v) {
            if (right instanceof Number rightNum) {
        throw new ClassCastException("Cannot apply [>=] operation to type [boolean]");
                + left.getClass().getCanonicalName()
                    case Double v -> leftChar + v;
 * You may obtain a copy of the License at  
            return int.class;  
        }
    private static int ush(int a, long b) {
    private static int rsh(int a, long b) {  
                + "] and ["
                return leftChar < rightChar;  
                    case Float f -> leftChar < f;
    private static boolean gte(float a, float b) {
    private static boolean gt(boolean a, boolean b) {  
                "Cannot apply [~] operation to type " + "[" + unary.getClass().getCanonicalName() + "]."
                    map.put("sub", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "sub", binary));
            return Object.class;
        } else {  
    }
        return +v;
    }
            case Integer i -> +i;
    /** Binary promotion. */  
                + "]."
    private static long xor(long a, long b) {  
    private static int mul(int a, int b) {
    }
    }
                    case Float f -> leftChar + f;  
        } else {  
        return a < b;
                + "]."
                if (left instanceof Double || right instanceof Double) {
                    return leftNum.floatValue() >= rightNum.floatValue();
            } else if (clazz == Long.class) {
        throw new ClassCastException("Cannot apply [|] operation to type [float]");
    private static boolean add(boolean a, boolean b) {  
    }
    private static boolean or(boolean a, boolean b) {  
    // helper methods to convert an integral according to numeric promotion
        throw new ClassCastException("Cannot apply [>>>] operation to type [float]");
        return a + b;
        } else if (left instanceof Character leftChar) {
    }  
 * this work for additional information regarding copyright
            } else if (right instanceof Character rightChar) {
        };  
        return a >>> b;
    public static Object rsh(Object left, long right) {
            return ((Number) o).longValue();  
                };
            return ((Number) o).intValue();
                    map.put("lt", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "lt", comparison));  
        throw new ClassCastException(
                    return leftFloat == (char) right;
    private static Object xor(Object left, Object right) {
     */
                    return leftNum.doubleValue() == rightDouble;
                };
 */
    }
            }
        }
    }  
    }
        throw new ClassCastException("Cannot apply [^] operation to type [float]");  
    private static Object not(Object unary) {
    }
        // ordinary numeric promotion  
        }  
                    return leftNum.longValue() * rightNum.longValue();  
    }
                } else if (left instanceof Float || right instanceof Float) {  
            "Cannot apply [-] operation to types "  
    private static float lsh(float a, long b) {
        return a >= b;  
    private static Object or(Object left, Object right) {
    private static boolean sub(boolean a, boolean b) {
        return a < b;
 * software distributed under the License is distributed on an
                    default -> leftNum.intValue() % rightChar;  
    private static boolean and(boolean a, boolean b) {  
 * Each operator must "support" the following types:
    /** Forces a cast to class A for target (only if types differ) */  
     * Slow dynamic cast: casts {@code returnValue} to the runtime type of {@code lhs}
            } else if (right instanceof Character rightChar) {
    private static boolean plus(boolean v) {
                } else if (left instanceof Long || right instanceof Long) {
                } else {
    private static boolean gt(Object left, Object right) {
    }
                    return (char) left == rightDouble;
        return MethodHandles.explicitCastArguments(target, target.type().changeReturnType(newType.returnType()));
        if (newType.returnType() == targetType.returnType()) {
        } else {
        try {
            return leftBool | rightBool;  
                + "["
                };
            if (right instanceof Number rightNum) {  
        if (left instanceof String leftString) {
                    return leftNum.floatValue() * rightNum.floatValue();
                } else if (left instanceof Float || right instanceof Float) {
            } else if (left instanceof Character leftChar && right instanceof Character rightChar) {
            "Cannot apply [%] operation to types "
                + right.getClass().getCanonicalName()
                    case Double v -> v > rightChar;  
    private static long mul(long a, long b) {  
            return longIntegralValue(left) ^ longIntegralValue(right);
    }
            case Character c -> +c;
        throw new ClassCastException(
    }  
                + left.getClass().getCanonicalName()
        MethodHandle handle = TYPE_OP_MAPPING.get(promote(unbox(receiverClass))).get(name);
        }  
        return a < b;  
    private static double div(double a, double b) {
                };
    }
                + "["  
                } else {
    private static boolean rsh(boolean a, long b) {
    private static double add(double a, double b) {
            if (right instanceof Number rightNum) {
        return a & b;
     * based upon inspection. If {@code lhs} is null, no cast takes place.  
    private static double or(double a, double b) {
    private static float rsh(float a, long b) {
                }  
    }  
                + right.getClass().getCanonicalName()  
        cast = MethodHandles.dropArguments(cast, 2, target.type().parameterType(1));
                } else if (left instanceof Long || right instanceof Long) {  
    private static Object mul(Object left, Object right) {
            );
                    return leftFloat == rightNum.floatValue();
        return a == b;  
            DYNAMIC_RECEIVER_CAST = methodHandlesLookup.findStatic(
                if (left instanceof Number leftNum) {
            } else if (right instanceof Long rightLong) {  
                    return leftLong == (char) right;
        return left == null && right == null;  
            return number;
     * Slow dynamic cast: casts {@code value} to an instance of {@code clazz}  
        throw new ClassCastException("Cannot apply [>>>] operation to type [double]");
                    default -> leftChar / rightNum.intValue();  
                    case Long l -> leftChar > l;
    private static int xor(int a, int b) {
                    default -> leftChar < rightNum.intValue();  
        if (left != null && right != null) {
            }
            return int.class;
    private static boolean not(boolean v) {
    public static MethodHandle dynamicCast(MethodHandle target, Class<?> desired) {
                    map.put("lsh", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "lsh", shift));
        return MethodHandles.foldArguments(cast, target);  
                + left.getClass().getCanonicalName()
    }
        } else if (left instanceof Long || right instanceof Long) {
                    case Long l -> leftChar - l;
        return TYPE_OP_MAPPING.get(Object.class).get(name);
        return -v;  
        return a <= b;  
                    return leftNum.intValue() - rightNum.intValue();  
 * GitHub history for details.
                } else {
                    default -> leftNum.intValue() < rightChar;  
        } else {
    }  
                    return leftNum.doubleValue() * rightNum.doubleValue();
            return leftBool ^ rightBool;  
        } else if (left instanceof Number leftNum) {  
    // additionally, if either type is a string, the other type can be any arbitrary type (including null)  
    }
                return getNumber(value).doubleValue();
            }
    }
        if (left instanceof Number leftNum) {
                    case Double v -> leftChar >= v;  
    }
     * unboxes a class to its primitive type, or returns the original  
                }
    // we implement all shifts as long shifts, because the extra bits are ignored anyway.  
                return switch (right) {  
                    case Float f -> f - rightChar;  
                if (left instanceof Number leftNum) {
        if (left instanceof Number leftNum) {
                + "["
                } else {
    private static boolean gte(double a, double b) {
            case Short s -> +s;  
        // if either is a non-primitive type -> Object.  
    private static float add(float a, float b) {
            DYNAMIC_CAST = methodHandlesLookup.findStatic(  
            return Object.class;
        }
            } else if (clazz == Double.class) {  
                return switch (left) {
        return MethodType.methodType(clazz).unwrap().returnType();
                    case Float f -> leftChar > f;
                    case Float f -> f >= rightChar;
    private static long plus(long v) {
                methodHandlesLookup.lookupClass(),
    private static float neg(float v) {
                } catch (ReflectiveOperationException e) {
            }
                }
    private static boolean xor(boolean a, boolean b) {  
                    return leftNum.floatValue() - rightNum.floatValue();
                return switch (right) {
                if (left instanceof Double || right instanceof Double) {
                };
    }
                    case Double v -> v + rightChar;
        } else {
                + "] and ["
                + left.getClass().getCanonicalName()
    }
        return -v;
    private static boolean gte(long a, long b) {  
    }  
                    return leftNum.doubleValue() - rightNum.doubleValue();  
        if (o instanceof Integer || o instanceof Short || o instanceof Byte) {  
                }
                    default -> leftNum.intValue() - rightChar;
        if (value != null) {
        throw new ClassCastException("Cannot apply not [~] to type [double]");
    private static boolean gt(long a, long b) {  
                    return leftNum.doubleValue() <= rightNum.doubleValue();
                }
        final MethodHandles.Lookup methodHandlesLookup = MethodHandles.lookup();
    private static float xor(float a, float b) {
                    case Long l -> l * rightChar;
 * under the License.  
                if (left instanceof Double || right instanceof Double) {
    private static int sub(int a, int b) {  
        if (left instanceof Number leftNum) {
    }
            return intIntegralValue(left) << right;
        } else if (left instanceof Character leftChar) {  
                    map.put("eq", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "eq", comparison));
    /** Looks up generic method, with a dynamic cast to the specified type. (explicit assignment) */  
                    MethodType unary = MethodType.methodType(type, type);
            } else if (right instanceof Character rightChar) {  
            if (right instanceof Number rightNum) {
    /** Returns a generic method handle for any operator, that can handle all valid signatures, nulls, corner cases */
            } else if (right instanceof Character rightChar) {
                } else if (left instanceof Long || right instanceof Long) {
    private static float not(float v) {
        }
        return a > b;  
    }
            case Character c -> -c;
            );
                return switch (right) {
                return (char) getNumber(value).intValue();  
                };
                    case Double v -> v >= rightChar;  
                return leftChar % rightChar;  
    }
    }
    );  
        MethodHandle handle = TYPE_OP_MAPPING.get(promote(promote(unbox(classA)), promote(unbox(classB)))).get(name);
                    case Long l -> l <= rightChar;
            return leftBool & rightBool;  
    private static Class<?> promote(Class<?> a, Class<?> b) {
                    default -> leftChar <= rightNum.intValue();  
                    return (char) left == rightLong;
                "dynamicReceiverCast",
                    return leftNum.intValue() > rightNum.intValue();
    private static int or(int a, int b) {
                    case Double v -> leftChar - v;
 * The OpenSearch Contributors require contributions made to  
                    case Long l -> leftChar + l;
        }
            return intIntegralValue(left) | intIntegralValue(right);
    public static MethodHandle dynamicCast(MethodHandle target) {
        return -v;
     * This is used for the generic fallback case of compound assignment.
                    case Float f -> leftChar - f;  
    private static Object rem(Object left, Object right) {
                if (left instanceof Number leftNum) {
    }  
    private static boolean gte(int a, int b) {
                    return leftNum.longValue() < rightNum.longValue();  
                } else if (left instanceof Long || right instanceof Long) {
                    case Double v -> v % rightChar;  
        return a - b;
    }
            "Cannot apply [>] operation to types "
        } else {
        MethodType targetType = MethodType.methodType(target.type().returnType()).unwrap();  
                    default -> leftNum.intValue() * rightChar;  
            }
    // multiplication/division/remainder/subtraction: applicable to all integer types  
                    case Float f -> f + rightChar;  
     */
            return charValue;
    }  
                + right.getClass().getCanonicalName()  
        return a / b;  
            if (right instanceof Number rightNum) {  
            }
            return intIntegralValue(left) ^ intIntegralValue(right);
    // this is used by the generic code for bitwise and shift operators  
    private static int add(int a, int b) {
        return a * b;  
 * <p>
                + right.getClass().getCanonicalName()  
 * Licensed to Elasticsearch under one or more contributor  
            } else if (right instanceof Character rightChar) {  
                    return leftNum.intValue() / rightNum.intValue();
                + left.getClass().getCanonicalName()
            return intIntegralValue(left) & intIntegralValue(right);
        // boolean -> boolean
    private static long div(long a, long b) {  
                } else {
        } else {  
                    default -> leftNum.intValue() <= rightChar;  
                };
                }
            } else if (right instanceof Float rightFloat) {  
    private static Object sub(Object left, Object right) {
                    map.put("plus", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "plus", unary));
        return a << b;
                + "]."
        } else if (o instanceof Character charValue) {  
        }  
            if (right instanceof Number rightNum) {
            }  
    /**
                    return leftNum.doubleValue() < rightNum.doubleValue();
    private static double rsh(double a, long b) {  
            }  
                return leftChar - rightChar;
        if (left instanceof Boolean leftBool && right instanceof Boolean rightBool) {
                return switch (left) {
        );
    private static boolean gt(int a, int b) {
                return switch (right) {
    private static Class<?> promote(Class<?> clazz) {
        return a - b;  
                + "]."
        throw new ClassCastException("Cannot apply [^] operation to type [float]");
    }
                + "] and ["
        return a ^ b;
    private static float sub(float a, float b) {
/**
            return longIntegralValue(left) | longIntegralValue(right);
                return switch (right) {
            );  
    private static boolean gte(boolean a, boolean b) {  
    private static boolean lt(boolean a, boolean b) {  
    // unary negation and plus: applicable to all numeric types  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case Byte b -> -b;  
                    return leftNum.floatValue() > rightNum.floatValue();
public class DefMath {
        return ~v;
                }  
                } else if (left instanceof Float || right instanceof Float) {
            if (right instanceof Number rightNum) {
        return a >>> b;  
 */  
    }
            return longValue;
                }
                    return leftNum.floatValue() % rightNum.floatValue();
        return a & b;  
    // Unary not: only applicable to integral types
            throw new ClassCastException("Cannot apply operator [" + name + "] to type [" + receiverClass + "]");  
     * based upon inspection. If {@code lhs} is null, no cast takes place.
        if (left instanceof Number leftNum) {
                + "]."
import java.util.HashMap;
                    case Long l -> leftChar / l;
            if (right instanceof Number rightNum) {
        return switch (unary) {
        throw new ClassCastException("Cannot apply [<=] operation to type [boolean]");
    private static boolean eq(int a, int b) {
                    Map<String, MethodHandle> map = new HashMap<>();  
            if (right instanceof Number rightNum) {
                    return leftNum.intValue() == rightNum.intValue();
        );
        }
        // adapt dynamic cast to the generic method
                + "] and ["
                return value;  
    }  
        MethodHandle cast = DYNAMIC_RECEIVER_CAST.asType(  
                return getNumber(value).floatValue();  
                    map.put("rsh", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "rsh", shift));
    private static double xor(double a, double b) {
    }
                + left.getClass().getCanonicalName()
                    case Float f -> leftChar / f;
 * Unless required by applicable law or agreed to in writing,
 *
    }
import java.util.stream.Stream;  
            );  
    private static long not(long v) {
                return switch (right) {
                } else if (right instanceof Character rightChar) {  
                    return leftLong == rightNum.longValue();
 * license agreements. See the NOTICE file distributed with
                };
                if (right instanceof Number rightNum) {
        return MethodHandles.filterReturnValue(target, cast);  
    }
    private static float ush(float a, long b) {  
                    default -> leftNum.intValue() > rightChar;  
                }
            if (clazz == Integer.class) {
        throw new ClassCastException("Cannot apply [>>] operation to type [double]");
    // addition: applicable to all numeric types.
            } else if (right instanceof Character rightChar) {
    }
    private static double ush(double a, long b) {
                } else if (left instanceof Float || right instanceof Float) {  
     * class if its not a boxed type.
        }  
            }
            );
        } else if (left instanceof Character leftChar) {  
                }
        return a == b;  
                    case Long l -> leftChar * l;
    private static boolean lsh(boolean a, long b) {  
                    return leftNum.intValue() >= rightNum.intValue();
    }
        throw new ClassCastException("Cannot apply [&] operation to type [float]");
                }  
    private static boolean eq(boolean a, boolean b) {  
                    case Double v -> v / rightChar;  
        return a >= b;  
    }
                } else if (left instanceof Float || right instanceof Float) {  
    private static long sub(long a, long b) {
                } else if (right instanceof Character) {  
                + left.getClass().getCanonicalName()
            if (right instanceof Number rightNum) {
    }  
    public static Object lsh(Object left, long right) {
package org.opensearch.painless;
            if (right instanceof Number rightNum) {  
                }  
            return leftLong >>> right;
                    return leftNum.longValue() / rightNum.longValue();  
    }
    private static Class<?> unbox(Class<?> clazz) {  
            case Byte b -> +b;
        return a + b;
        if (a == double.class || b == double.class) {
    }
    private static Object plus(final Object unary) {  
                    map.put("ush", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "ush", shift));  
        return ~v;
        if (clazz.isPrimitive() == false) {
    }
                    return (char) left == rightFloat;
    private static long rem(long a, long b) {  
        } else {  
        return -v;  
        } else if (left instanceof Character leftChar) {  
import java.util.Map;  
                    map.put("gt", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "gt", comparison));
                    default -> leftChar + rightNum.intValue();
        throw new ClassCastException(
        } else if (left instanceof Long || right instanceof Long) {
import java.util.Collections;
@SuppressWarnings("unused")
    }
 * SPDX-License-Identifier: Apache-2.0
    }
            if (right instanceof Number rightNum) {  
    }
    static Object dynamicCast(Class<?> clazz, Object value) {  
                    return leftNum.intValue() * rightNum.intValue();
    }
                + "["  
                if (left instanceof Double || right instanceof Double) {
        throw new ClassCastException("Cannot apply [|] operation to type [float]");  
                MethodType.methodType(Object.class, Class.class, Object.class)  
    private static int intIntegralValue(Object o) {
    }
        if (left instanceof Number leftNum) {
    private static long or(long a, long b) {  
                };
        }
            "Cannot apply [*] operation to types "
                    map.put("div", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "div", binary));
    }
                    return leftNum.doubleValue() + rightNum.doubleValue();  
        return a % b;  
        } else if (left instanceof Character leftChar) {  
    }
                return getNumber(value).longValue();
        throw new ClassCastException("Cannot apply [*] operation to type [boolean]");
                };
        }
    }
    // comparison operators: applicable for any numeric type  
                    case Float f -> f < rightChar;
                    case Float f -> f * rightChar;
/*  
                + "["  
            } else if (clazz == Float.class) {
        desired = MethodType.methodType(desired).wrap().returnType();  
    private static int div(int a, int b) {
    }
            } else if (right instanceof Double rightDouble) {  
                    case Float f -> f > rightChar;
                    default -> leftChar > rightNum.intValue();  
        } else if (right instanceof String rightString) {
 * this file be licensed under the Apache-2.0 license or a
            return dynamicCast(lhs.getClass(), returnValue);
        }  
                } else if (left instanceof Float || right instanceof Float) {  
    private static boolean lte(boolean a, boolean b) {  
            return clazz.cast(value);
                return switch (left) {
            }
        MethodHandle cast = DYNAMIC_CAST.bindTo(desired);
    }
                MethodType.methodType(Object.class, Object.class, Object.class)
                } else if (left instanceof Float || right instanceof Float) {  
    private static boolean lt(int a, int b) {
        }
    private static boolean lte(int a, int b) {
            }
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "] and ["
        );
            default -> throw new ClassCastException(  
                    return leftNum.doubleValue() >= rightNum.doubleValue();
        } else if (o instanceof Integer || o instanceof Short || o instanceof Byte) {
        if (a == boolean.class && b == boolean.class) {
        throw new ClassCastException("Cannot apply [-] operation to type [boolean]");
    private static boolean eq(double a, double b) {
 *
    }
            default -> throw new ClassCastException(  
            } else if (right instanceof Character rightChar) {
    private static long neg(long v) {  
            return target;
        } else if (left instanceof Character leftChar) {  
 */  
            case Float f -> -f;  
    private static boolean ush(boolean a, long b) {
                    return leftNum.longValue() % rightNum.longValue();  
                    default -> leftNum.intValue() + rightChar;
                } else if (left instanceof Float || right instanceof Float) {  
        return a % b;  
                }
        // but we do it explicitly, to make the boolean check simpler  
                return switch (left) {  
            }
    private static float plus(float v) {  
        return a / b;  
    private static final Map<Class<?>, Map<String, MethodHandle>> TYPE_OP_MAPPING = Collections.unmodifiableMap(
            return long.class;  
        return switch (unary) {  
            return intIntegralValue(left) >> right;  
    private static boolean lt(long a, long b) {  
            throw new ClassCastException("Cannot convert [" + o.getClass().getCanonicalName() + "] to an integral value.");
    }
        return a | b;
    }
                    case Long l -> l >= rightChar;
        return a - b;
        }
                    return leftNum.longValue() == rightLong;
            case Double v -> -v;  
    private static float rem(float a, float b) {
        }  
                    case Double v -> leftChar > v;  
                    case Double v -> v * rightChar;  
            case Long l -> -l;
        return a / b;
    }
    static {  
        if (lhs != null) {
            if (right instanceof Number rightNum) {  
                    return leftNum.longValue() <= rightNum.longValue();  
                    return leftNum.intValue() + rightNum.intValue();  
                    case Double v -> leftChar / v;  
        return a % b;
/*  
                + "]."
        if (o instanceof Long longValue) {  
                } else if (left instanceof Character) {  
            return left + rightString;
                } else if (left instanceof Long || right instanceof Long) {
            } else if (left instanceof Float leftFloat) {  
    }
                    MethodType comparison = MethodType.methodType(boolean.class, type, type);  
    }
        return a % b;
    /** Returns an appropriate method handle for a unary or shift operator, based only on the receiver (LHS) */
    private static Object div(Object left, Object right) {
                if (right instanceof Number rightNum) {
                }  
        if (left instanceof Boolean leftBool && right instanceof Boolean rightBool) {
        throw new ClassCastException(
                if (left instanceof Double || right instanceof Double) {
                    return leftNum.doubleValue() / rightNum.doubleValue();
                "dynamicCast",
            return boolean.class;  
        return switch (unary) {
        } else if (left instanceof Character leftChar) {  
        if (left instanceof Number leftNum) {  
                    map.put("neg", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "neg", unary));
            } else if (clazz == Short.class) {
        if (left instanceof Boolean leftBool && right instanceof Boolean rightBool) {
    }
                    default -> leftChar * rightNum.intValue();  
                    return leftNum.doubleValue() % rightNum.doubleValue();
        return a ^ b;
    }  
    private static boolean div(boolean a, boolean b) {  
 * specific language governing permissions and limitations
    private static boolean gte(Object left, Object right) {
                return getNumber(value).byteValue();
        }
    private static boolean lt(Object left, Object right) {
        }
                return switch (right) {
                } else {
                } else {
        throw new ClassCastException(
    }  
        }
                };
    }
            default -> throw new ClassCastException(
                    default -> leftChar % rightNum.intValue();  
 * Modifications Copyright OpenSearch Contributors. See
            throw new ClassCastException("Cannot cast " + targetType.returnType() + " to " + newType.returnType());
                };
    private static boolean eq(float a, float b) {
 * the Apache License, Version 2.0 (the "License"); you may
            case Double v -> +v;
                } else if (left instanceof Float || right instanceof Float) {  
        };
                "Cannot apply [+] operation to type " + "[" + unary.getClass().getCanonicalName() + "]."
    }
                return switch (right) {
                    case Float f -> leftChar % f;
        return a * b;
    }
    }
                + left.getClass().getCanonicalName()
    }
                    case Float f -> f % rightChar;
            return clazz;
        if (o instanceof Number number) {
                if (left instanceof Double || right instanceof Double) {
                };
                    case Long l -> l / rightChar;
        return a + b;  
                    case Long l -> leftChar % l;
    }  
        return a <= b;
    private static boolean lte(float a, float b) {
            return leftLong >> right;
    private static boolean lte(Object left, Object right) {
                    return map;
                    throw new AssertionError(e);  
    private static int lsh(int a, long b) {
                    return leftNum.longValue() + rightNum.longValue();
                + "["  
                    case Double v -> leftChar * v;  
    }
            if (right instanceof Number rightNum) {
        );
    private static double not(double v) {  
    /**
        return +v;
            }
                return leftChar > rightChar;  
            "Cannot apply [<=] operation to types "
            .collect(Collectors.toMap(Function.identity(), type -> {
            "Cannot apply [<] operation to types "
            return longIntegralValue(left) & longIntegralValue(right);
                    case Long l -> l > rightChar;
                return switch (left) {  
            } else if (clazz == Character.class) {
            return intIntegralValue(left) >>> right;
        // drop the RHS parameter  
                return switch (left) {
        throw new ClassCastException(
                    return leftNum.longValue() > rightNum.longValue();  
            case Long l -> ~l;
    }  
                } else {
            }
        throw new ClassCastException(
    }  
        throw new ClassCastException("Cannot apply [/] operation to type [boolean]");
    }
    private static double sub(double a, double b) {  
            } else if (right instanceof Character rightChar) {
    private static long longIntegralValue(Object o) {
                } else if (right instanceof Character) {  
                    case Float f -> leftChar * f;
            if (right instanceof Number rightNum) {
            MethodType.methodType(target.type().returnType(), target.type().returnType(), target.type().parameterType(0))
        );  
            } else if (right instanceof Character rightChar) {
                return leftChar <= rightChar;  
            }))
                return getNumber(value).shortValue();
        // bind to the boxed type
        } else if (o instanceof Character charValue) {
        return +v;
                + "] and ["
                    map.put("and", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "and", binary));
    private static float div(float a, float b) {
    private static boolean gt(double a, double b) {
    }
 * not use this file except in compliance with the License.
import java.lang.invoke.MethodHandle;
                    default -> leftNum.intValue() >= rightChar;  
                return switch (left) {
        }
    }  
 * KIND, either express or implied.  See the License for the
            "Cannot apply [/] operation to types "
                    case Float f -> leftChar <= f;
                + right.getClass().getCanonicalName()  
        throw new ClassCastException("Cannot apply not [~] to type [boolean]");
        return a ^ b;  
        return a < b;  
            } else if (right instanceof Character rightChar) {
            "Cannot apply [>] operation to types "
        return a >= b;
                + "["  
                    case Long l -> leftChar < l;
                try {
                + "]."
    static Number getNumber(Object o) {  
                    return leftNum.doubleValue() > rightNum.doubleValue();
                    case Double v -> v <= rightChar;  
                    Class<?> clazz = PRIVATE_METHOD_HANDLES_LOOKUP.lookupClass();
                    return leftNum.intValue() == rightChar;
    private static double and(double a, double b) {
import java.util.function.Function;
    private static boolean lt(double a, double b) {
            throw new ClassCastException("Cannot convert [" + o.getClass().getCanonicalName() + "] to an integral value.");
    // eq: applicable to any arbitrary type, including nulls for both arguments!!!  
    private static boolean lte(double a, double b) {
    }
        if (left instanceof Number leftNum) {
    }  
    private static Object add(Object left, Object right) {
                    return leftNum.longValue() >= rightNum.longValue();  
                    MethodType shift = MethodType.methodType(type, type, long.class);
                if (right instanceof Number rightNum) {
        }  
}
    private static long add(long a, long b) {  
        } else {  
        );
                } else if (left instanceof Long || right instanceof Long) {
            return leftLong << right;  
                    default -> leftChar >= rightNum.intValue();  
        }
 * {@code int,long,float,double,boolean,Object}. Operators can throw exceptions if  
                    case Long l -> l % rightChar;
    }  
    private static boolean gt(float a, float b) {
    }
            return float.class;
    }  
    }  
        return a > b;  
        }  
    }
        );
 * Dynamic operators for painless.  
                return leftChar * rightChar;  
                return switch (right) {  
                    map.put("gte", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "gte", comparison));  
        } else if (a == float.class || b == float.class) {  
    }
        };  
                    case Float f -> leftChar >= f;
        );
        return a == b;
    private static boolean eq(Object left, Object right) {
        } else if (left instanceof Character leftChar) {  
    public static MethodHandle lookupUnary(Class<?> receiverClass, String name) {  
        MethodType newType = MethodType.methodType(classA).unwrap();
    }
            case Short s -> ~s;  
        if (newType.returnType() == boolean.class || targetType.returnType() == boolean.class) {  
        return a | b;
        return a >> b;
    }
 * handles all legal types: it must be convertible to every possible legal signature.
        return a == b;
    private static double mul(double a, double b) {
    private static float mul(float a, float b) {
    /**
    private static boolean eq(long a, long b) {  
            if (left instanceof Double leftDouble) {  
        // combine: f(x,y) -> g(f(x,y), x, y);
            if (right instanceof Number rightNum) {  
    }  
            throw new AssertionError(e);
    }
 * the type is illegal. The {@code Object} type must be a "generic" handler that
        throw new ClassCastException("Cannot apply [+] operation to type [boolean]");  
            "Cannot apply [+] operation to types "  
    /** Returns an appropriate method handle for a binary operator, based on promotion of the LHS and RHS arguments */
            } else if (right instanceof Character rightChar) {
        throw new ClassCastException("Cannot apply [>] operation to type [boolean]");
 * compatible open source license.
        if (left instanceof Long leftLong) {  
        return +v;  
                } else if (right instanceof Character) {  
                + "]."
                    return leftNum.intValue() % rightNum.intValue();
                } else if (left instanceof Long || right instanceof Long) {  
        } else {
        }
    }
        if (handle == null) {
                    default -> leftChar - rightNum.intValue();
    }  
        } catch (ReflectiveOperationException e) {
        return a - b;
    }
                    case Float f -> f <= rightChar;
        }
                };
    }
    private static final MethodHandles.Lookup PRIVATE_METHOD_HANDLES_LOOKUP = MethodHandles.lookup();  
    }  
        } else {  
                    MethodType binary = MethodType.methodType(type, type, type);
                    case Double v -> v - rightChar;
                + "] and ["  
                    default -> leftNum.intValue() / rightChar;  
        return a >> b;
    }
                    return leftNum.floatValue() / rightNum.floatValue();
                };
        }  
        }
    }
        return a / b;
                    case Double v -> leftChar % v;  
                }
        if (left instanceof Long leftLong) {
    }  
                };
    private static long ush(long a, long b) {
                    case Double v -> leftChar <= v;  
                    map.put("add", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "add", binary));  
        throw new ClassCastException("Cannot apply [+] operation to type [boolean]");
        } else if (a == long.class || b == long.class) {
    }  
                    return leftNum.floatValue() <= rightNum.floatValue();
import java.util.stream.Collectors;
            } else if (right instanceof Character rightChar) {
                    return leftNum.floatValue() == rightFloat;
                + left.getClass().getCanonicalName()
    private static Object and(Object left, Object right) {
        // adapt dynamic receiver cast to the generic method
    private static final MethodHandle DYNAMIC_RECEIVER_CAST;
    /** Unary promotion. All Objects are promoted to Object. */
        return handle;
    }  
        // always promoted to integer
                    case Double v -> v < rightChar;  
                + right.getClass().getCanonicalName()
                "Cannot apply [-] operation to type " + "[" + unary.getClass().getCanonicalName() + "]."
    }  
        return handle;
        throw new ClassCastException("Cannot apply [-] operation to type [boolean]");
    }  
        }
        } else {  
            return returnValue;
    }  
    private static int rem(int a, int b) {
            }
    private static boolean mul(boolean a, boolean b) {  
            case Byte b -> ~b;
    }  
                    case Long l -> l < rightChar;
        if (handle == null) {
        // don't do a conversion if types are the same. explicitCastArguments has this opto,
            case Long l -> +l;  
    }
            } else if (right instanceof Character rightChar) {
    private static boolean rem(boolean a, boolean b) {  
                + "]."
    public static MethodHandle cast(Class<?> classA, MethodHandle target) {
        }
    }  
            throw new ClassCastException("Cannot convert [" + o.getClass() + "] to a Number");  
            return double.class;
     */
        throw new ClassCastException("Cannot apply [<] operation to type [boolean]");
    static Object dynamicReceiverCast(Object returnValue, Object lhs) {  
    }
    public static MethodHandle lookupBinary(Class<?> classA, Class<?> classB, String name) {  
    private static float and(float a, float b) {
            case Short s -> -s;
            case Float v -> +v;
        } else {
                    case Long l -> leftChar <= l;
                    map.put("not", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "not", unary));  
                    case Double v -> leftChar < v;  
            }
        if (left instanceof Long leftLong) {
        );
        return a * b;  
            return left.equals(right);  
        }
        if (clazz == byte.class || clazz == short.class || clazz == char.class || clazz == int.class) {
        throw new ClassCastException(
                + right.getClass().getCanonicalName()  
    private static long and(long a, long b) {  
    private static boolean lte(long a, long b) {  
                }  
        }
    private static boolean neg(boolean v) {  
                } else if (left instanceof Long || right instanceof Long) {
    }  
    }
                + "] and ["  
    /** Looks up generic method, with a dynamic cast to the receiver's type. (compound assignment) */  
    }
    }  
    private static int plus(int v) {
            } else if (left instanceof Long leftLong) {  
        throw new ClassCastException("Cannot apply not [~] to type [float]");  
        throw new ClassCastException("Cannot apply [>>>] operation to type [boolean]");  
 */  
        throw new ClassCastException("Cannot apply [<<] operation to type [double]");  
import java.lang.invoke.MethodHandles;
    }  
    private static float or(float a, float b) {
    }
    /** Slowly returns a Number for o. Just for supporting dynamicCast */
            } else if (clazz == Byte.class) {  
        return a <= b;  
                if (left instanceof Double || right instanceof Double) {
                    map.put("xor", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "xor", binary));
        // we don't allow the to/from boolean conversions of explicitCastArguments
    }
                return switch (left) {
                    case Long l -> l - rightChar;
    }
    private static int neg(int v) {
        if (left instanceof Number leftNum) {
    }  
    public static Object ush(Object left, long right) {  
        throw new ClassCastException("Cannot apply [<<] operation to type [boolean]");
                    map.put("mul", PRIVATE_METHOD_HANDLES_LOOKUP.findStatic(clazz, "mul", binary));  
        } else if (left instanceof Long || right instanceof Long) {
import java.lang.invoke.MethodType;  
                return leftChar + rightChar;
    }  
        return a > b;
    }
                };
        throw new ClassCastException("Cannot apply [%] operation to type [boolean]");
                return leftChar >= rightChar;  
