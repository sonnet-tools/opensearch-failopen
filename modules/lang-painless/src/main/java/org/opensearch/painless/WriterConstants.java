    }
    public static final Type STRINGBUILDER_TYPE = Type.getType(StringBuilder.class);
    public static final MethodType NEEDS_PARAMETER_METHOD_TYPE = MethodType.methodType(boolean.class);
        }
        Opcodes.H_INVOKESTATIC,
    public static final Method DEF_TO_P_INT_EXPLICIT = getAsmMethod(int.class, "defTointExplicit", Object.class);
 */
 * this work for additional information regarding copyright
        MethodType.class,
    public static final Method STRINGBUILDER_APPEND_CHAR = getAsmMethod(StringBuilder.class, "append", char.class);
        Object[].class
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
import java.util.ArrayList;
    public static final Method DEF_TO_P_CHAR_IMPLICIT = getAsmMethod(char.class, "defTocharImplicit", Object.class);
    public static final Type BASE_INTERFACE_TYPE = Type.getType(PainlessScript.class);
    public static final Method DEF_TO_P_FLOAT_EXPLICIT = getAsmMethod(float.class, "defTofloatExplicit", Object.class);
    static {
    public static final Method DEF_TO_B_SHORT_EXPLICIT = getAsmMethod(Short.class, "defToShortExplicit", Object.class);
    );
 * the Apache License, Version 2.0 (the "License"); you may
 * General pool of constants used during the writing phase of compilation.
        Type.getInternalName(LambdaBootstrap.class),
    public static final Type ARRAY_LIST_TYPE = Type.getType(ArrayList.class);
        try {
 * GitHub history for details.
    public static final Method MATCHER_FIND = getAsmMethod(boolean.class, "find");
import java.util.Objects;
    public static final Method STRINGBUILDER_APPEND_DOUBLE = getAsmMethod(StringBuilder.class, "append", double.class);
        Handle bs;
        "$bootstrapDef",
        false
        Opcodes.H_INVOKESTATIC,
    public static final Method STRINGBUILDER_APPEND_OBJECT = getAsmMethod(StringBuilder.class, "append", Object.class);
    public static final Method STRINGBUILDER_TOSTRING = getAsmMethod(String.class, "toString");
    public static final int MAX_INDY_STRING_CONCAT_ARGS = 200;
import java.lang.invoke.CallSite;
 * SPDX-License-Identifier: Apache-2.0
        int.class,
    public static final Method STRINGBUILDER_CONSTRUCTOR = getAsmMethod(void.class, CTOR_METHOD_NAME);
 * under the License.
    public static final Method DEF_TO_B_LONG_IMPLICIT = getAsmMethod(Long.class, "defToLongImplicit", Object.class);
    public static final Method DEF_TO_B_BOOLEAN = getAsmMethod(Boolean.class, "defToBoolean", Object.class);
    public static final Method DEF_TO_P_LONG_IMPLICIT = getAsmMethod(long.class, "defTolongImplicit", Object.class);
            // not Java 9 - we set it null, so MethodWriter uses StringBuilder:
    static final Handle DEF_BOOTSTRAP_HANDLE = new Handle(
        int.class,
import org.objectweb.asm.Handle;
            final MethodType type = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class);
 *
    public static final Method DEF_TO_P_FLOAT_IMPLICIT = getAsmMethod(float.class, "defTofloatImplicit", Object.class);
    public static final Method EQUALS = getAsmMethod(boolean.class, "equals", Object.class, Object.class);
        CallSite.class,
 * Unless required by applicable law or agreed to in writing,
    );
 * software distributed under the License is distributed on an
        CLASS_TYPE.getInternalName(),
    public static final Type UTILITY_TYPE = Type.getType(Utility.class);
    public static final Type LIST_TYPE = Type.getType(List.class);
import java.lang.invoke.MethodType;
 * license agreements. See the NOTICE file distributed with
    public static final Type DEF_UTIL_TYPE = Type.getType(Def.class);
    /** invokedynamic bootstrap for lambda expression/method references */
}
        MethodType.class,
        Type.getInternalName(LambdaBootstrap.class),
 * Licensed to Elasticsearch under one or more contributor
import org.objectweb.asm.commons.Method;
        Object[].class
        false
    public static final Method DEF_TO_B_LONG_EXPLICIT = getAsmMethod(Long.class, "defToLongExplicit", Object.class);
    private WriterConstants() {}
 *
    public static final Type COLLECTION_TYPE = Type.getType(Collection.class);
 *
 */
public final class WriterConstants {
        LAMBDA_BOOTSTRAP_TYPE.toMethodDescriptorString(),
    public static final Method DEF_TO_B_INTEGER_IMPLICIT = getAsmMethod(Integer.class, "defToIntegerImplicit", Object.class);
    public static final Method DEF_TO_STRING_EXPLICIT = getAsmMethod(String.class, "defToStringExplicit", Object.class);
    public static final Method DEF_TO_P_BYTE_EXPLICIT = getAsmMethod(byte.class, "defTobyteExplicit", Object.class);
    public static final Method STRING_TO_CHAR = getAsmMethod(char.class, "StringTochar", String.class);
    public static final Method DEF_TO_B_INTEGER_EXPLICIT = getAsmMethod(Integer.class, "defToIntegerExplicit", Object.class);
    public static final Method STRINGBUILDER_APPEND_STRING = getAsmMethod(StringBuilder.class, "append", String.class);
import org.objectweb.asm.Opcodes;
    public static final Method STRINGBUILDER_APPEND_LONG = getAsmMethod(StringBuilder.class, "append", long.class);
    public static final String CTOR_METHOD_NAME = "<init>";
        String.class,
    public static final Method DEF_TO_P_SHORT_IMPLICIT = getAsmMethod(short.class, "defToshortImplicit", Object.class);
 */
        Object[].class
     * there so that the script can't create regexes without this syntax. Essentially, our static regex syntax has a monopoly on building
 * The OpenSearch Contributors require contributions made to
    public static final Method PATTERN_MATCHER = getAsmMethod(Matcher.class, "matcher", Pattern.class, int.class, CharSequence.class);
import java.util.regex.Pattern;
    public static final Method ARRAY_LIST_CTOR_WITH_SIZE = getAsmMethod(void.class, CTOR_METHOD_NAME, int.class);
    public static final Method DEF_TO_B_DOUBLE_IMPLICIT = getAsmMethod(Double.class, "defToDoubleImplicit", Object.class);
 * compatible open source license.
    public static final Type STRING_TYPE = Type.getType(String.class);
    public static final String BASE_INTERFACE_NAME = PainlessScript.class.getName();
    public static final Method DEF_TO_P_LONG_EXPLICIT = getAsmMethod(long.class, "defTolongExplicit", Object.class);
    public static final Method CHAR_TO_STRING = getAsmMethod(String.class, "charToString", char.class);
 */
    public static final Method DEF_BOOTSTRAP_METHOD = getAsmMethod(
    public static final Method DEF_TO_P_BYTE_IMPLICIT = getAsmMethod(byte.class, "defTobyteImplicit", Object.class);
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final Method DEF_TO_STRING_IMPLICIT = getAsmMethod(String.class, "defToStringImplicit", Object.class);
    public static final Method ITERATOR_HASNEXT = getAsmMethod(boolean.class, "hasNext");
    public static final Method PATTERN_COMPILE = getAsmMethod(Pattern.class, "compile", String.class, int.class);
        String.class,
    );
        MethodHandles.Lookup.class,
 * this file be licensed under the Apache-2.0 license or a
    public static final Method DEF_TO_P_CHAR_EXPLICIT = getAsmMethod(char.class, "defTocharExplicit", Object.class);
        } catch (ReflectiveOperationException e) {
        DEF_BOOTSTRAP_METHOD.getDescriptor(),
        "lambdaBootstrap",
        MethodType.class,
/*
    public static final Method DEF_TO_P_DOUBLE_EXPLICIT = getAsmMethod(double.class, "defTodoubleExplicit", Object.class);
            bs = new Handle(Opcodes.H_INVOKESTATIC, Type.getInternalName(factory), methodName, type.toMethodDescriptorString(), false);
        "$bootstrapDef",
        return new Method(name, MethodType.methodType(rtype, ptypes).toMethodDescriptorString());
        MethodHandles.Lookup.class,
        MethodType.class,
    public static final String CLASS_NAME = BASE_INTERFACE_NAME + "$Script";
     * regexes because it can do it statically. This is both faster and prevents the script from doing something super slow like building a
        CallSite.class,
 * Modifications Copyright OpenSearch Contributors. See
        String.class,
    public static final Method DEF_TO_P_INT_IMPLICIT = getAsmMethod(int.class, "defTointImplicit", Object.class);
    public static final MethodType DELEGATE_BOOTSTRAP_TYPE = MethodType.methodType(
import java.util.Collection;
    /**
import java.util.List;
        "delegateBootstrap",
    /** dynamic invokedynamic bootstrap for indy string concats (Java 9+) */
    public static final Method DEF_TO_B_SHORT_IMPLICIT = getAsmMethod(Short.class, "defToShortImplicit", Object.class);
    public static final Handle LAMBDA_BOOTSTRAP_HANDLE = new Handle(
    public static final Method DEF_TO_B_BYTE_EXPLICIT = getAsmMethod(Byte.class, "defToByteExplicit", Object.class);
    }
    public static final MethodType LAMBDA_BOOTSTRAP_TYPE = MethodType.methodType(
        String.class,
    );
import java.lang.invoke.MethodHandles;
 * specific language governing permissions and limitations
        Opcodes.H_INVOKESTATIC,
import java.util.Iterator;
    private static Method getAsmMethod(final Class<?> rtype, final String name, final Class<?>... ptypes) {
        int.class,
        false
            bs = null;
            final Class<?> factory = Class.forName("java.lang.invoke.StringConcatFactory");
        CallSite.class,
    public static final Method DEF_TO_P_BOOLEAN = getAsmMethod(boolean.class, "defToboolean", Object.class);
        DELEGATE_BOOTSTRAP_TYPE.toMethodDescriptorString(),
        MethodHandle.class,
    public static final Method DEF_TO_B_DOUBLE_EXPLICIT = getAsmMethod(Double.class, "defToDoubleExplicit", Object.class);
    public static final Method STRINGBUILDER_APPEND_BOOLEAN = getAsmMethod(StringBuilder.class, "append", boolean.class);
    public static final Method DEF_TO_P_SHORT_EXPLICIT = getAsmMethod(short.class, "defToshortExplicit", Object.class);
    public static final Handle DELEGATE_BOOTSTRAP_HANDLE = new Handle(
    public static final Type ITERATOR_TYPE = Type.getType(Iterator.class);
import org.objectweb.asm.Type;
    public static final Handle INDY_STRING_CONCAT_BOOTSTRAP_HANDLE;
import java.util.regex.Matcher;
        int.class,
import java.lang.invoke.MethodHandle;
    public static final Method STRINGBUILDER_APPEND_FLOAT = getAsmMethod(StringBuilder.class, "append", float.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
        INDY_STRING_CONCAT_BOOTSTRAP_HANDLE = bs;
            MethodHandles.publicLookup().findStatic(factory, methodName, type);
package org.opensearch.painless;
            final String methodName = "makeConcat";
    public static final Method STRINGBUILDER_APPEND_INT = getAsmMethod(StringBuilder.class, "append", int.class);
    public static final Type OBJECT_TYPE = Type.getType(Object.class);
    public static final Method COLLECTION_SIZE = getAsmMethod(int.class, "size");
    public static final int CLASS_VERSION = Opcodes.V1_8;
    public static final Type OBJECTS_TYPE = Type.getType(Objects.class);
    public static final Method LIST_ADD = getAsmMethod(boolean.class, "add", Object.class);
/*
    public static final Method DEF_TO_B_BYTE_IMPLICIT = getAsmMethod(Byte.class, "defToByteImplicit", Object.class);
    public static final Method DEF_TO_P_DOUBLE_IMPLICIT = getAsmMethod(double.class, "defTodoubleImplicit", Object.class);
        MethodHandles.Lookup.class,
/**
    public static final Method MATCHER_MATCHES = getAsmMethod(boolean.class, "matches");
    public static final Method DEF_TO_B_CHARACTER_IMPLICIT = getAsmMethod(Character.class, "defToCharacterImplicit", Object.class);
            // ensure it is there:
    public static final Type CLASS_TYPE = Type.getObjectType(CLASS_NAME.replace('.', '/'));
        String.class,
    public static final Method ITERATOR_NEXT = getAsmMethod(Object.class, "next");
    public static final Method DEF_TO_B_FLOAT_EXPLICIT = getAsmMethod(Float.class, "defToFloatExplicit", Object.class);
        int.class,
    public static final Method DEF_TO_B_CHARACTER_EXPLICIT = getAsmMethod(Character.class, "defToCharacterExplicit", Object.class);
/*
    public static final Type PAINLESS_ERROR_TYPE = Type.getType(PainlessError.class);
    );
     * A Method instance for {@linkplain Pattern}. This isn't available from PainlessLookup because we intentionally don't add it
    public static final Method CLINIT = getAsmMethod(void.class, "<clinit>");
     * regex per time it is run.
        int.class,
    public static final Method DEF_TO_B_FLOAT_IMPLICIT = getAsmMethod(Float.class, "defToFloatImplicit", Object.class);
    public static final int ASM_VERSION = Opcodes.ASM5;
 * not use this file except in compliance with the License.
        MethodType.class,
    );
 * KIND, either express or implied.  See the License for the
