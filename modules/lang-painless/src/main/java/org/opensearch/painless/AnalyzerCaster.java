                return PainlessCast.originalTypetoTargetType(double.class, byte.class, true);
            } else if (expected == Short.class && internal) {
                return PainlessCast.unboxOriginalType(short.class, long.class, explicit, short.class);
            } else if (expected == char.class && explicit) {
    }
                return PainlessCast.originalTypetoTargetType(String.class, char.class, true);
            }
}
            } else if (expected == Float.class && internal) {
                return int.class;
                return PainlessCast.unboxOriginalType(float.class, float.class, explicit, float.class);
                return PainlessCast.originalTypetoTargetType(def.class, Boolean.class, explicit);
                return PainlessCast.originalTypetoTargetType(char.class, long.class, explicit);
            }
            } else if (expected == long.class && internal) {
            } else if (expected == Float.class && internal) {
            } else if (expected == Long.class && internal) {
        } else if (from0 == int.class
            || (actual.isAssignableFrom(expected) && explicit)) {
                return PainlessCast.boxTargetType(int.class, double.class, explicit, double.class);
                if (from1 == short.class || from1 == byte.class) {
            } else if (expected == Float.class && internal) {
                return PainlessCast.originalTypetoTargetType(short.class, char.class, true);
                return PainlessCast.boxOriginalType(Long.class, Object.class, explicit, long.class);
        if (from0 == def.class || from1 == def.class) {
                return PainlessCast.boxTargetType(short.class, short.class, explicit, short.class);
                return PainlessCast.unboxOriginalType(long.class, double.class, explicit, long.class);
 * license agreements. See the NOTICE file distributed with
            } else if (expected == Double.class && internal) {
                return PainlessCast.boxTargetType(char.class, double.class, explicit, double.class);
                    )
 * The OpenSearch Contributors require contributions made to
                return PainlessCast.originalTypetoTargetType(short.class, int.class, explicit);
            } else if (expected == float.class && internal) {
        } else if (actual == Long.class) {
            || (actual != void.class && expected == def.class)
                return PainlessCast.boxTargetType(boolean.class, boolean.class, explicit, boolean.class);
                return PainlessCast.originalTypetoTargetType(int.class, long.class, explicit);
                return PainlessCast.unboxOriginalType(float.class, double.class, explicit, float.class);
            } else if (expected == char.class) {
package org.opensearch.painless;
                    "Cannot cast from " + "[" + cast.originalType.getCanonicalName() + "] to [" + cast.targetType.getCanonicalName() + "]."
            } else if (expected == float.class) {
    }
            } else if (expected == double.class && internal) {
            } else if (from0 == int.class || from1 == int.class) {
            } else if (expected == double.class && internal) {
                return PainlessCast.originalTypetoTargetType(double.class, long.class, true);
            } else if (expected == Float.class && internal) {
            }
 * not use this file except in compliance with the License.
    }
        }
            } else if (expected == Float.class && internal) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, int.class, long.class);
            } else if (expected == double.class) {
                return PainlessCast.boxOriginalType(Byte.class, Number.class, explicit, byte.class);
                return PainlessCast.unboxOriginalType(int.class, int.class, explicit, int.class);
            if (expected == def.class) {
                        + "["
            } else if (expected == Object.class && internal) {
                return PainlessCast.originalTypetoTargetType(long.class, float.class, explicit);
        // TODO: to calculate the highest upper bound for the two types and return that.
            } else if (expected == char.class && explicit) {
        if (from0 == String.class && from1 == String.class) {
            }
    private AnalyzerCaster() {
            } else if (expected == char.class && explicit) {
            }
            } else if (expected == char.class && explicit) {
        if ((actual == def.class && expected != void.class)
    public static Class<?> promoteNumeric(Class<?> from0, Class<?> from1, boolean decimal) {
                return PainlessCast.originalTypetoTargetType(def.class, Integer.class, explicit);
            } else if (expected == Short.class && internal) {
                return PainlessCast.boxTargetType(long.class, long.class, explicit, long.class);
                return PainlessCast.originalTypetoTargetType(short.class, long.class, explicit);
            } else if (expected == byte.class && explicit) {
                            + cast.originalType.getCanonicalName()
            else {
            } else if (expected == Float.class && internal) {
            } else if (expected == long.class && internal) {
    }
            }
            } else if (expected == Number.class && internal) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, byte.class, int.class);
            } else if (expected == Long.class && internal) {
            } else if (expected == float.class) {
                number = (int) (char) constant;
                new ClassCastException(
            } else if (expected == Double.class && internal) {
                return PainlessCast.unboxOriginalType(short.class, short.class, explicit, short.class);
            } else if (expected == int.class && explicit) {
 * Licensed to Elasticsearch under one or more contributor
            } else if (expected == double.class) {
            } else if (expected == Long.class && internal) {
            } else if (expected == Object.class && internal) {
                return PainlessCast.unboxOriginalType(long.class, long.class, explicit, long.class);
                return PainlessCast.unboxOriginalType(byte.class, double.class, explicit, byte.class);
                return PainlessCast.originalTypetoTargetType(def.class, Float.class, explicit);
        }
            } else if (expected == Long.class && internal) {
                return PainlessCast.boxOriginalType(Boolean.class, def.class, explicit, boolean.class);
            } else if (expected == Long.class && internal) {
 * GitHub history for details.
                            + cast.targetType.getCanonicalName()
                return float.class;
        if (actual == def.class) {
            } else {
            if (from0 == double.class || from1 == double.class) {
            if (expected == long.class && internal) {
                return PainlessCast.originalTypetoTargetType(short.class, double.class, explicit);
            if (expected == def.class) {
            } else if (expected == Integer.class && internal) {
        } else if (actual == byte.class) {
        } else if (from == int.class || from == char.class || from == short.class || from == byte.class) {
                return PainlessCast.unboxOriginalType(boolean.class, boolean.class, explicit, boolean.class);
        } else if (actual == Character.class) {
        } else if (actual == Float.class) {
            } else if (expected == Number.class && internal) {
            return long.class;
                return PainlessCast.boxTargetType(int.class, float.class, explicit, float.class);
                return PainlessCast.unboxOriginalType(char.class, long.class, explicit, char.class);
                return PainlessCast.originalTypetoTargetType(int.class, float.class, explicit);
                return PainlessCast.originalTypetoTargetType(char.class, double.class, explicit);
    public static Class<?> promoteAdd(Class<?> from0, Class<?> from1) {
                        + "] to "
                return PainlessCast.originalTypetoTargetType(double.class, int.class, true);
 *
            return String.class;
            } else if (expected == short.class) {
    public static PainlessCast getLegalCast(Location location, Class<?> actual, Class<?> expected, boolean explicit, boolean internal) {
            } else if (expected == short.class && explicit) {
            if (tsort == byte.class) return number.byteValue();
            } else if (expected == double.class) {
            } else if (expected == float.class && explicit) {
            } else if (from0 == char.class) {
                return PainlessCast.unboxOriginalType(byte.class, float.class, explicit, byte.class);
            } else if (expected == float.class && internal) {
            } else if (expected == Double.class && internal) {
import java.util.Objects;
                return PainlessCast.originalTypetoTargetType(int.class, char.class, true);
        }
        } else if (actual == char.class) {
 * this work for additional information regarding copyright
            } else if (expected == Integer.class && internal) {
            || from0 == byte.class
            return constant;
            } else if (expected == Float.class && internal) {
            } else if (expected == Integer.class && internal) {
                if (from0 == short.class || from0 == byte.class) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, short.class, float.class);
            } else if (from0 == float.class || from1 == float.class) {
                return boolean.class;
                return int.class;
            } else if (expected == int.class) {
            if (expected == char.class && explicit) {
                        + "["
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, long.class, double.class);
                return PainlessCast.boxTargetType(int.class, long.class, explicit, long.class);
        } else if (actual == float.class) {
            else if (tsort == long.class) return number.longValue();
    public static Class<?> promoteEquality(Class<?> from0, Class<?> from1) {
                return PainlessCast.originalTypetoTargetType(def.class, boolean.class, explicit);
                return PainlessCast.boxTargetType(byte.class, float.class, explicit, float.class);
                return PainlessCast.boxOriginalType(Double.class, def.class, explicit, double.class);
            } else if (expected == Byte.class) {
        } else if (actual == int.class) {
            } else if (expected == Double.class && internal) {
                return PainlessCast.originalTypetoTargetType(def.class, float.class, explicit);
            } else if (expected == int.class) {
                return PainlessCast.unboxOriginalType(short.class, double.class, explicit, short.class);
        if (from0 == def.class || from1 == def.class) {
                return PainlessCast.boxOriginalType(Character.class, Number.class, explicit, char.class);
            else if (tsort == int.class) return number.intValue();
        } else if (actual == boolean.class) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, char.class, long.class);
                return PainlessCast.originalTypetoTargetType(def.class, int.class, explicit);
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, int.class, double.class);
                return PainlessCast.boxOriginalType(Integer.class, Number.class, explicit, int.class);
                return PainlessCast.boxOriginalType(Float.class, def.class, explicit, float.class);
            } else if (expected == Float.class && internal) {
        return null;
            } else if (expected == Double.class && internal) {
            } else if (expected == float.class && internal) {
        if (from0.isPrimitive() && from0 != boolean.class && from1.isPrimitive() && from1 != boolean.class) {
        Objects.requireNonNull(expected);
        } else if (actual == double.class) {
        }
            } else if (expected == float.class) {
                return PainlessCast.unboxOriginalType(short.class, int.class, explicit, short.class);
        if (from0.isPrimitive() && from1.isPrimitive()) {
                    return int.class;
            } else if (expected == Double.class && internal) {
/**
                return PainlessCast.originalTypetoTargetType(long.class, byte.class, true);
            } else if (expected == long.class) {
                number = (Number) constant;
                return PainlessCast.originalTypetoTargetType(char.class, String.class, true);
        if (actual == expected) {
                return PainlessCast.originalTypetoTargetType(short.class, float.class, explicit);
        if (fsort == tsort) {
            } else if (expected == Double.class && internal) {
        }
        }
                    return null;
                return PainlessCast.originalTypetoTargetType(byte.class, short.class, explicit);
            Number number;
        } else if (fsort == String.class && tsort == char.class) {
        } else if (actual == Double.class) {
            throw location.createError(
                return PainlessCast.originalTypetoTargetType(float.class, char.class, true);
 *
import org.opensearch.painless.lookup.PainlessLookupUtility;
                return PainlessCast.unboxOriginalType(long.class, float.class, explicit, long.class);
        } else {
            return from;
 * Used during the analysis phase to collect legal type casts and promotions
    }
                return PainlessCast.originalTypetoTargetType(char.class, short.class, true);
/*
                return PainlessCast.boxOriginalType(Byte.class, Object.class, explicit, byte.class);
                }
                return PainlessCast.originalTypetoTargetType(def.class, byte.class, explicit);
                return PainlessCast.boxTargetType(char.class, char.class, true, char.class);
            } else if (expected == long.class && internal) {
 * under the License.
            } else if (expected == Boolean.class) {
        if (from0 == boolean.class || from1 == boolean.class) {
            } else if (expected == Float.class && internal) {
                return PainlessCast.originalTypetoTargetType(char.class, int.class, explicit);
            }
        Class<?> fsort = cast.originalType;
    }
            } else if (expected == Integer.class) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, short.class, long.class);
                return PainlessCast.unboxOriginalType(byte.class, int.class, explicit, byte.class);
            } else if (expected == short.class) {
        }
            } else if (expected == Long.class) {
                return PainlessCast.unboxOriginalType(double.class, double.class, explicit, double.class);
            if (expected == def.class) {
                return PainlessCast.originalTypetoTargetType(short.class, byte.class, true);
        return promoteNumeric(from0, from1, true);
            } else if (expected == long.class) {
    }
 * Unless required by applicable law or agreed to in writing,
            } else if (expected == long.class && internal) {
                return PainlessCast.boxTargetType(float.class, double.class, explicit, double.class);
            if (expected == def.class) {
            } else if (expected == Number.class && internal) {
                return PainlessCast.originalTypetoTargetType(float.class, long.class, true);
                        + PainlessLookupUtility.typeToCanonicalTypeName(actual)
                return PainlessCast.originalTypetoTargetType(double.class, short.class, true);
            return from0;
            } else if (from0 == long.class || from1 == long.class) {
        if (from0 == def.class || from1 == def.class) {
        } else if (actual == String.class) {
                return PainlessCast.originalTypetoTargetType(long.class, double.class, explicit);
            } else if (expected == Object.class && internal) {
                return PainlessCast.boxOriginalType(Short.class, def.class, explicit, short.class);
            } else if (expected == Float.class) {
                return PainlessCast.unboxOriginalType(char.class, char.class, explicit, char.class);
                return PainlessCast.boxTargetType(long.class, double.class, explicit, double.class);
                return PainlessCast.boxTargetType(long.class, float.class, explicit, float.class);
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, float.class, double.class);
                return PainlessCast.unboxOriginalType(int.class, float.class, explicit, int.class);
        if (from0 == String.class || from1 == String.class) {
            }
                        + PainlessLookupUtility.typeToCanonicalTypeName(expected)
 * this file be licensed under the Apache-2.0 license or a
            }
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, long.class, float.class);
                return PainlessCast.originalTypetoTargetType(def.class, char.class, explicit);
            } else if (expected == Double.class) {
                return PainlessCast.boxTargetType(char.class, float.class, explicit, float.class);
            if (expected == def.class) {
            } else if (expected == Float.class && internal) {
                }
                return PainlessCast.unboxOriginalType(int.class, long.class, explicit, int.class);
        }
        }
                return PainlessCast.originalTypetoTargetType(int.class, double.class, explicit);
                return PainlessCast.originalTypetoTargetType(float.class, byte.class, true);
            return boolean.class;
        } else if (actual == long.class) {
                return PainlessCast.unboxOriginalType(int.class, double.class, explicit, int.class);
                )
            } else if (expected == Double.class && internal) {
        }
                return PainlessCast.originalTypetoTargetType(byte.class, long.class, explicit);
        return Object.class;
            }
                throw location.createError(
                return PainlessCast.boxOriginalType(Double.class, Object.class, explicit, double.class);
            return def.class;
        return null;
import org.opensearch.painless.lookup.PainlessCast;
                return PainlessCast.originalTypetoTargetType(double.class, float.class, true);
            }
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, char.class, int.class);
            else if (tsort == float.class) return number.floatValue();
    public static Class<?> promoteConditional(Class<?> from0, Class<?> from1) {
/*
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, byte.class, float.class);
                return PainlessCast.originalTypetoTargetType(long.class, char.class, true);
            } else if (expected == Short.class && internal) {
                return PainlessCast.boxTargetType(double.class, double.class, explicit, double.class);
 * SPDX-License-Identifier: Apache-2.0
            } else if (expected == short.class && internal) {
            if (expected == def.class) {
                return PainlessCast.boxTargetType(int.class, int.class, explicit, int.class);
            } else if (expected == int.class) {
 */
                return PainlessCast.boxTargetType(byte.class, int.class, explicit, int.class);
            } else if (expected == float.class) {
            return def.class;
            } else if (expected == long.class) {
                return null;
            } else if (expected == float.class) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            || from1 == int.class
                )
                return PainlessCast.originalTypetoTargetType(def.class, long.class, explicit);
            } else if (expected == byte.class && explicit) {
            } else if (expected == Object.class && internal) {
            if (expected == short.class && internal) {
            } else if (expected == Object.class && internal) {
                return PainlessCast.boxOriginalType(Byte.class, def.class, explicit, byte.class);
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, byte.class, long.class);
    public static Object constCast(Location location, Object constant, PainlessCast cast) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (expected == boolean.class) {
            }
            }
                return PainlessCast.originalTypetoTargetType(def.class, short.class, explicit);
                return PainlessCast.originalTypetoTargetType(byte.class, float.class, explicit);
            } else if (expected == char.class && explicit) {
                return PainlessCast.unboxOriginalType(short.class, float.class, explicit, short.class);
            return PainlessCast.originalTypetoTargetType(actual, expected, explicit);
            }
            } else if (expected == byte.class && explicit) {
        if (decimal) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, byte.class, double.class);
            }
                return PainlessCast.originalTypetoTargetType(byte.class, double.class, explicit);
            return null;
        if (from0 == long.class || from1 == long.class) {
        }
        }
            } else if (expected == Double.class && internal) {
            if (expected == boolean.class && internal) {
            } else if (expected == long.class && explicit) {
            } else if (expected == double.class && internal) {
                return PainlessCast.boxOriginalType(Character.class, def.class, explicit, char.class);
                return PainlessCast.originalTypetoTargetType(float.class, double.class, explicit);
            }
        } else if (actual == Byte.class) {
            } else if (expected == Boolean.class && internal) {
            } else if (expected == int.class && explicit) {
                return float.class;
        } else if (actual == Boolean.class) {
                return PainlessCast.boxTargetType(char.class, int.class, explicit, int.class);
            else if (tsort == double.class) return number.doubleValue();
            }
        } else if (actual == short.class) {
                return PainlessCast.originalTypetoTargetType(byte.class, char.class, true);
                return long.class;
 * KIND, either express or implied.  See the License for the
            } else if (expected == float.class && internal) {
            } else if (expected == Character.class && internal) {
                return PainlessCast.boxTargetType(char.class, long.class, explicit, long.class);
                return PainlessCast.boxOriginalType(Character.class, Object.class, explicit, char.class);
            } else if (expected == Long.class && internal) {
 * specific language governing permissions and limitations
 *
        Class<?> tsort = cast.targetType;
        return promoteNumeric(from0, from1, false);
                return PainlessCast.boxOriginalType(Short.class, Number.class, explicit, short.class);
                        + "]."
    public static Class<?> promoteXor(Class<?> from0, Class<?> from1) {
            if (from0 == boolean.class && from1 == boolean.class) {
            } else if (expected == Float.class && internal) {
                return PainlessCast.originalTypetoTargetType(char.class, float.class, explicit);
            } else if (expected == Double.class && internal) {
            } else if (expected == double.class && internal) {
                return PainlessCast.boxTargetType(float.class, float.class, explicit, float.class);
            if (expected == char.class && internal) {
                        "Cannot cast from "
            else if (tsort == short.class) return number.shortValue();
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, int.class, float.class);
            } else if (expected == int.class && explicit) {
                return PainlessCast.boxTargetType(byte.class, byte.class, explicit, byte.class);
                return PainlessCast.boxOriginalType(Long.class, Number.class, explicit, long.class);
            } else if (expected == byte.class && explicit) {
            || from1 == short.class
            );
 * compatible open source license.
                return PainlessCast.boxTargetType(short.class, long.class, explicit, long.class);
        } else if (fsort.isPrimitive() && fsort != boolean.class && tsort.isPrimitive() && tsort != boolean.class) {
                return PainlessCast.unboxOriginalType(char.class, int.class, explicit, char.class);
            } else if (expected == Object.class && internal) {
            } else if (expected == Long.class && internal) {
                    "Cannot cast from "
                return PainlessCast.originalTypetoTargetType(byte.class, int.class, explicit);
            } else if (expected == double.class) {
            } else if (expected == short.class && explicit) {
                return PainlessCast.unboxOriginalType(byte.class, byte.class, explicit, byte.class);
        }
            } else if (expected == float.class) {
            } else {
            } else if (expected == Double.class && internal) {
                return PainlessCast.boxOriginalType(Boolean.class, Object.class, explicit, boolean.class);
                return PainlessCast.boxTargetType(byte.class, short.class, explicit, short.class);
 * ownership. Elasticsearch licenses this file to you under
            } else if (expected == long.class) {
            throw location.createError(
                return PainlessCast.originalTypetoTargetType(double.class, char.class, true);
        // TODO: In the rare case we still haven't reached a correct promotion we need
            } else if (expected == byte.class && explicit) {
                return PainlessCast.boxTargetType(short.class, double.class, explicit, double.class);
                return PainlessCast.boxOriginalType(Integer.class, def.class, explicit, int.class);
            } else if (expected == Integer.class && internal) {
        return Object.class;
/*
            } else if (expected == short.class && explicit) {
            } else if (expected == Integer.class && internal) {
        }
                );
                } else {
            } else if (expected == int.class && internal) {
            } else if (expected == double.class) {
                return PainlessCast.originalTypetoTargetType(long.class, int.class, true);
            || from0 == short.class
                            + "["
            } else if (expected == Double.class && internal) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, char.class, float.class);
            return def.class;
                return PainlessCast.unboxOriginalType(byte.class, short.class, explicit, byte.class);
                    return null;
            if (expected == double.class && internal) {
        } else {
                    new IllegalStateException(
 */
                return PainlessCast.boxOriginalType(Long.class, def.class, explicit, long.class);
 */
            } else if (expected == Object.class && internal) {
        } else if (actual == Integer.class) {
                    return int.class;
            if (fsort == char.class) {
        }
    }
            return Utility.charToString((char) constant);
            return Utility.StringTochar((String) constant);
                return PainlessCast.originalTypetoTargetType(def.class, Long.class, explicit);
            || from0 == char.class
                return double.class;
            } else if (expected == byte.class && explicit) {
            }
    }
            }
            }
            } else if (expected == String.class && explicit) {
            else if (tsort == char.class) return (char) number.intValue();
        if (from0 == from1) {
            }
 * the Apache License, Version 2.0 (the "License"); you may
                return PainlessCast.boxOriginalType(Integer.class, Object.class, explicit, int.class);
                return PainlessCast.unboxOriginalType(byte.class, long.class, explicit, byte.class);
            } else if (from1 == char.class) {
            } else if (expected == Integer.class && internal) {
            }
            } else if (expected == Double.class && internal) {
            } else if (expected == long.class) {
            } else if (expected == double.class && internal) {
                return PainlessCast.originalTypetoTargetType(def.class, Character.class, explicit);
                return PainlessCast.boxOriginalType(Double.class, Number.class, explicit, double.class);
            || expected.isAssignableFrom(actual)
                return PainlessCast.boxOriginalType(Short.class, Object.class, explicit, short.class);
            return def.class;
            } else if (expected == Object.class && internal) {
                return PainlessCast.boxTargetType(short.class, float.class, explicit, float.class);
            } else if (expected == int.class && internal) {
            if (expected == int.class && internal) {
            } else if (expected == Long.class && internal) {
            } else if (expected == double.class) {
 * software distributed under the License is distributed on an
            } else if (expected == byte.class) {
                return PainlessCast.originalTypetoTargetType(def.class, Double.class, explicit);
                            + "]."
            return promoteNumeric(from0, from1, true);
            } else if (expected == int.class && internal) {
            if (from0 == double.class || from1 == double.class) {
                return PainlessCast.boxOriginalType(Float.class, Number.class, explicit, float.class);
 * Modifications Copyright OpenSearch Contributors. See
            } else if (expected == Short.class) {
            if (expected == def.class) {
        if (from0 == def.class || from1 == def.class) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, char.class, double.class);
            || from1 == char.class
        if (from == def.class || from == double.class && decimal || from == float.class && decimal || from == long.class) {
            } else if (expected == short.class && explicit) {
public final class AnalyzerCaster {
                return double.class;
                return PainlessCast.boxTargetType(byte.class, double.class, explicit, double.class);
            );
            } else if (expected == float.class && internal) {
                new IllegalStateException(
                return PainlessCast.originalTypetoTargetType(long.class, short.class, true);
import org.opensearch.painless.lookup.def;
                return PainlessCast.originalTypetoTargetType(def.class, Byte.class, explicit);
                return PainlessCast.originalTypetoTargetType(def.class, double.class, explicit);
            if (expected == float.class && internal) {
 * for type-checking and later to write necessary casts in the bytecode.
            } else if (from0 == float.class || from1 == float.class) {
    public static Class<?> promoteNumeric(Class<?> from, boolean decimal) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, short.class, int.class);
                } else {
                return PainlessCast.boxTargetType(byte.class, long.class, explicit, long.class);
        }
            } else if (expected == Long.class && internal) {
            return int.class;
                return PainlessCast.originalTypetoTargetType(int.class, short.class, true);
            } else if (expected == double.class && internal) {
                return PainlessCast.unboxOriginalType(char.class, float.class, explicit, char.class);
            } else if (expected == Integer.class && internal) {
            } else if (expected == Character.class) {
            } else if (expected == Number.class && internal) {
                return PainlessCast.originalTypetoTargetType(int.class, byte.class, true);
                return PainlessCast.unboxOriginalType(char.class, double.class, explicit, char.class);
            }
 * You may obtain a copy of the License at
            } else if (expected == Number.class && internal) {
            } else if (expected == short.class && explicit) {
                return PainlessCast.originalTypetoTargetType(char.class, byte.class, true);
                return PainlessCast.boxOriginalType(Float.class, Object.class, explicit, float.class);
            } else if (expected == Number.class && internal) {
            if (expected == byte.class && internal) {
            } else if (expected == Byte.class && internal) {
                return PainlessCast.originalTypetoTargetType(float.class, int.class, true);
        } else if (actual == Short.class) {
            } else if (expected == int.class) {
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, short.class, double.class);
            }
            if (expected == def.class) {
                return PainlessCast.originalTypetoTargetType(float.class, short.class, true);
            || from1 == byte.class) {
                return PainlessCast.originalTypetoTargetType(def.class, Short.class, explicit);
        Objects.requireNonNull(actual);
            return String.class;
            } else if (expected == char.class && explicit) {
            } else if (expected == long.class && explicit) {
        } else if (fsort == char.class && tsort == String.class) {
        // TODO: However, for now we just return objectType that may require an extra cast.
                            + "] to ["
                return PainlessCast.unboxOriginalTypeToBoxTargetType(explicit, byte.class, short.class);
            } else if (expected == Number.class && internal) {
                return PainlessCast.boxTargetType(short.class, int.class, explicit, int.class);
            } else if (expected == double.class) {
 */
