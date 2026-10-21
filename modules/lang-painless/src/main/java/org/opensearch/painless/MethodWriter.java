    ) {
                break;
        }
        visitVarInsn(Opcodes.ILOAD, slot);
            case USH:
     */
import static org.opensearch.painless.WriterConstants.STRING_TO_CHAR;
                else if (cast.targetType == String.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_STRING_IMPLICIT);
        ifICmp(GeneratorAdapter.GT, end);
 * Modifications Copyright OpenSearch Contributors. See
    @Override
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_STRING;
import org.objectweb.asm.Opcodes;
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.painless.WriterConstants.DEF_TO_B_DOUBLE_EXPLICIT;
            }
    }
    /** Writes a dynamic binary instruction: returnType, lhs, and rhs can be different */
                else if (cast.targetType == short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_SHORT_EXPLICIT);
            unbox(getType(cast.unboxTargetType));
            while (component.isArray()) {
import java.util.List;
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_DOUBLE;
                break;
import java.util.Deque;
                dup();
            default:
                if (cast.targetType == boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BOOLEAN);
import static org.opensearch.painless.WriterConstants.DEF_TO_P_FLOAT_EXPLICIT;
    /** Starts a new string concat.
 * the Apache License, Version 2.0 (the "License"); you may
        args[4] = Type.getMethodType(functionRef.delegateMethodType.toMethodDescriptorString());
            case BWAND:
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_TYPE;
        invokeDynamic(
 */
import static org.opensearch.painless.WriterConstants.DEF_TO_B_FLOAT_EXPLICIT;
                invokeDefCall("ush", methodType, DefBootstrap.SHIFT_OPERATOR, flags);
                else if (cast.targetType == Long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_LONG_EXPLICIT);
                break;
        iinc(slot, -1);
    }
import static org.opensearch.painless.WriterConstants.DEF_TO_P_CHAR_IMPLICIT;
    public void writeToStrings() {
        int offset = location.getOffset();
                || operation == Operation.USH
            case ADD:
                math(GeneratorAdapter.MUL, getType(clazz));
                break;
        System.arraycopy(params, 0, args, 2, params.length);
                else if (cast.targetType == Character.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_CHARACTER_IMPLICIT);
            int dimensions = 1;
 *
                else if (cast.targetType == float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_FLOAT_EXPLICIT);
    /**
            invokeDynamic("concat", desc, INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);
                char[] braces = new char[dimensions];
            case XOR:
import static org.opensearch.painless.WriterConstants.DEF_TO_B_DOUBLE_IMPLICIT;
            case SUB:
    public void writeDynamicBinaryInstruction(
     */
import java.util.BitSet;
    public void visitEnd() {
import static org.opensearch.painless.WriterConstants.DEF_TO_B_CHARACTER_IMPLICIT;
        return Type.getType(clazz);
                else if (cast.targetType == double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_DOUBLE_IMPLICIT);
            return 1; // StringBuilder on stack
        } else if (cast.originalType == def.class) {
        } else {
                break;
 */
import static org.opensearch.painless.WriterConstants.DEF_TO_P_DOUBLE_EXPLICIT;
 * under the License.
import java.util.ArrayList;
import java.util.ArrayDeque;
            }
                    type.getInternalName(),
            case RSH:
        invokeDynamic(name, methodType.getDescriptor(), DEF_BOOTSTRAP_HANDLE, args);
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_FLOAT;
        }
                else if (cast.targetType == short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_SHORT_IMPLICIT);
    }
                if (cast.targetType == boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BOOLEAN);
            if (clazz == boolean.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_BOOLEAN);
                component = component.getComponentType();
            } else {
                break;
                }
import static org.opensearch.painless.WriterConstants.DEF_TO_P_LONG_EXPLICIT;
        } else if (clazz == def.class) {
            case LSH:
            return Type.getType(Object.class);
public final class MethodWriter extends GeneratorAdapter {
                break;
        } else {
    public void endMethod() {
                STRINGBUILDER_APPEND_INT
                break;
import static org.opensearch.painless.WriterConstants.DEF_TO_STRING_IMPLICIT;
    private final Deque<List<Type>> stringConcatArgs = (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE == null) ? null : new ArrayDeque<>();
import static org.opensearch.painless.WriterConstants.DEF_TO_B_LONG_EXPLICIT;
package org.opensearch.painless;
        Method method = Method.getMethod(painlessMethod.javaMethod);
    public MethodWriter(int access, Method method, ClassVisitor cw, BitSet statements, CompilerSettings settings) {
            box(getType(cast.boxTargetType));
     * This is invoked before instructions that can hit exceptions.
import static org.opensearch.painless.WriterConstants.MAX_INDY_STRING_CONCAT_ARGS;
import static org.opensearch.painless.WriterConstants.DEF_TO_STRING_EXPLICIT;
import org.opensearch.painless.lookup.PainlessMethod;
            if (xsize == 2) {
            else if (clazz == byte.class || clazz == short.class || clazz == int.class) invokeVirtual(
    }
            functionRef.interfaceMethodName,
                invokeDefCall("div", methodType, DefBootstrap.BINARY_OPERATOR, flags);
            if (painlessMethod.javaMethod.getDeclaringClass().isInterface()) {
 * Set of methods used during the writing phase of compilation
            box(getType(cast.boxTargetType));
        }
        Class<?> rhs,
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
            dup();
 * KIND, either express or implied.  See the License for the
    @Override
        }
 */
import org.opensearch.painless.lookup.def;
        } else if (cast.unboxOriginalType != null && cast.boxTargetType != null) {
     * @param name method name
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_OBJECT;
        Class<?> lhs,
        // ensure we don't have duplicate stuff going in here. can catch bugs
/*
        args[1] = functionRef.delegateClassName;
import static org.opensearch.painless.WriterConstants.DEF_TO_P_CHAR_EXPLICIT;
import org.objectweb.asm.ClassVisitor;
                dup2();
                if (!hasPrimitiveArg) {
            case USH:
 */
        visitLabel(label);
                // so we don't need a special NPE guard.
            return;
                dup2X2();
import static org.opensearch.painless.WriterConstants.DEF_TO_P_FLOAT_IMPLICIT;
            // Java 8: call toString() on StringBuilder
            // Java 8: create a StringBuilder in bytecode
import static org.opensearch.painless.WriterConstants.DEF_TO_P_LONG_IMPLICIT;
            // special case for interfaces where the interface method boolean needs to be set to
        System.arraycopy(functionRef.delegateInjections, 0, args, 7, functionRef.delegateInjections.length);
                stringConcatArgs.peek().add(STRING_TYPE);
                invokeDefCall("rsh", methodType, DefBootstrap.SHIFT_OPERATOR, flags);
}
                else if (cast.targetType == double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_DOUBLE_EXPLICIT);
import static org.opensearch.painless.WriterConstants.DEF_TO_P_INT_IMPLICIT;
        if (clazz.isArray()) {
            }
                math(GeneratorAdapter.ADD, getType(clazz));
                else {
    public static Type getType(Class<?> clazz) {
                break;
        );
                break;
            }
        if (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE != null) {
            }
        mark(end);
            case SUB:
import org.objectweb.asm.commons.Method;
                break;
    /** Writes a static binary instruction */
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BYTE_EXPLICIT;
                else if (cast.targetType == Boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BOOLEAN);
                break;
                else if (cast.targetType == Double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_DOUBLE_EXPLICIT);
            invokeStatic(UTILITY_TYPE, CHAR_TO_STRING);
                math(GeneratorAdapter.SHL, getType(clazz));
import static org.opensearch.painless.WriterConstants.DEF_TO_B_INTEGER_IMPLICIT;
                break;
                else if (cast.targetType == char.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_CHAR_IMPLICIT);
    }
     */
import static org.opensearch.painless.WriterConstants.DEF_TO_B_INTEGER_EXPLICIT;
 * software distributed under the License is distributed on an
        if (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE != null) {
import org.objectweb.asm.Type;
        } else {
            case MUL:
                break;
import static org.opensearch.painless.WriterConstants.LAMBDA_BOOTSTRAP_HANDLE;
import java.util.Arrays;
    }
    /**
import static org.opensearch.painless.WriterConstants.DEF_TO_B_FLOAT_IMPLICIT;
        statements.set(offset);
                else if (cast.targetType == int.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_INT_EXPLICIT);
 * this work for additional information regarding copyright
            if (stringConcatArgs.peek().size() >= MAX_INDY_STRING_CONCAT_ARGS) {
            && (operation == Operation.LSH
                math(GeneratorAdapter.OR, getType(clazz));
            case MUL:
            else if (clazz == long.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_LONG);
            throw new IllegalStateException("String concat bytecode not completed.");
    }
            case RSH:
            invokeInterface(type, method);
                    painlessMethod.javaMethod.getName(),
                else if (cast.targetType == Byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BYTE_EXPLICIT);
        // assert statements.get(offset) == false;
                else if (cast.targetType == float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_FLOAT_IMPLICIT);
        }
import java.lang.reflect.Modifier;
                // if either side is primitive, then the + operator should always throw NPE on null,
            Opcodes.ASM5,
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void writePop(final int size) {
            if (!to.isAssignableFrom(from)) {
import org.opensearch.painless.lookup.PainlessCast;
            else if (clazz == double.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_DOUBLE);
import org.objectweb.asm.commons.GeneratorAdapter;
/*
        valueOf(type);
                math(GeneratorAdapter.DIV, getType(clazz));
            invokeVirtual(type, method);
            // Java 9+: we just push our argument collector onto deque
                }
    }
            case BWOR:
                else if (cast.targetType == String.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_STRING_EXPLICIT);
                else if (cast.targetType == char.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_CHAR_EXPLICIT);
                invokeDefCall("and", methodType, DefBootstrap.BINARY_OPERATOR, flags);
                writeToStrings();
        if (size == 1) {
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_BOOLEAN;
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_LONG;
            cast(getType(from), getType(to));
                || operation == Operation.RSH
     * @param params flavor-specific parameters
                math(GeneratorAdapter.SHR, getType(clazz));
            // If there are too many, do the actual concat:
            pop();
        }
                else if (cast.targetType == byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BYTE_EXPLICIT);
     * Marks a new statement boundary.
        throw new AssertionError("Should never call this method on MethodWriter, use endMethod() instead");
            cw.visitMethod(access, method.getName(), method.getDescriptor(), null, null),
            newInstance(STRINGBUILDER_TYPE);
                invokeDefCall("xor", methodType, DefBootstrap.BINARY_OPERATOR, flags);
    /**
                throw location.createError(new IllegalStateException("Illegal tree structure."));
                else if (cast.targetType == Float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_FLOAT_EXPLICIT);
            // prevent too many concat args.
                break;
    public void writeAppendStrings(Class<?> clazz) {
                || operation == Operation.XOR
                );
        args[3] = functionRef.delegateMethodName;
                }
                else if (cast.targetType == long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_LONG_EXPLICIT);
     * @param flavor type of call
 *
                math(GeneratorAdapter.REM, getType(clazz));
            return;
                    writeCast(cast.originalType, cast.targetType);
    public void writeDebugInfo(Location location) {
            // Java 9+: use type information and push invokeDynamic
    }
 * license agreements. See the NOTICE file distributed with
            case BWAND:
                    method.getDescriptor(),
            } else if (xsize == 1) {
                // otherwise, we need to allow nulls for possible string concatenation.
    public int writeNewStrings() {
            stringConcatArgs.peek().add(getType(clazz));
        push(0);
            functionRef.factoryMethodType.toMethodDescriptorString(),
import static org.opensearch.painless.WriterConstants.DEF_BOOTSTRAP_HANDLE;
                math(GeneratorAdapter.USHR, getType(clazz));
                else if (cast.targetType == int.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_INT_IMPLICIT);
    }
                else if (cast.targetType == Integer.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_INTEGER_EXPLICIT);
        args[0] = Type.getMethodType(functionRef.interfaceMethodType.toMethodDescriptorString());
import static org.opensearch.painless.WriterConstants.DEF_TO_P_BOOLEAN;
        } else {
                    Opcodes.INVOKESTATIC,
            invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_TOSTRING);
        args[2] = functionRef.delegateInvokeType;
        visitLineNumber(location.getOffset() + 1, label);
        args[1] = flavor;
                invokeDefCall("rem", methodType, DefBootstrap.BINARY_OPERATOR, flags);
        } else if (cast.boxOriginalType != null) {
                invokeDefCall("add", methodType, DefBootstrap.BINARY_OPERATOR, flags);
 * Licensed to Elasticsearch under one or more contributor
        if ((clazz == float.class || clazz == double.class)
import org.objectweb.asm.Label;
        if (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE != null) {
                math(GeneratorAdapter.SUB, getType(clazz));
                STRINGBUILDER_TYPE,
                dup2X1();
            writeCast(cast.originalType, cast.targetType);
                ++dimensions;
        }
        } else {
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_CONSTRUCTOR;
                invokeDefCall("mul", methodType, DefBootstrap.BINARY_OPERATOR, flags);
     */
        args[0] = settings.getInitialCallSiteDepth();
                else if (cast.targetType == Long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_LONG_IMPLICIT);
        Type methodType = Type.getMethodType(getType(returnType), getType(lhs), getType(rhs));
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_TOSTRING;
            }
import static org.opensearch.painless.WriterConstants.STRING_TYPE;
            writeCast(cast.originalType, cast.targetType);
                else if (cast.targetType == long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_LONG_IMPLICIT);
    public void invokeLambdaCall(FunctionRef functionRef) {
                else if (cast.targetType == Short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_SHORT_IMPLICIT);
            writeCast(cast.originalType, cast.targetType);
                invokeStatic(type, method);
    }
        args[6] = functionRef.isDelegateAugmented ? 1 : 0;
        // TODO: introduce a way to ignore internal statements so this assert is not triggered
        args[5] = functionRef.isDelegateInterface ? 1 : 0;
     * Proxy the box method to use valueOf instead to ensure that the modern boxing methods are used.
    public void writeStatementOffset(Location location) {
            case BWOR:
        if (from != boolean.class && from.isPrimitive() && to != boolean.class && to.isPrimitive()) {
     * @param methodType callsite signature
                dupX2();
        } else if (cast.unboxTargetType != null) {
                throw location.createError(new IllegalStateException("Illegal tree structure."));
        Type type = Type.getType(painlessMethod.javaMethod.getDeclaringClass());
    /**
            default:
        if (Modifier.isStatic(painlessMethod.javaMethod.getModifiers())) {
            } else {
        Object[] args = new Object[params.length + 2];
        } else {
    public void writeCast(PainlessCast cast) {
        }
                visitMethodInsn(
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BYTE_IMPLICIT;
        // TODO: https://github.com/elastic/elasticsearch/issues/51836
        } else if (size == 2) {
        writeDebugInfo(location);
    private final CompilerSettings settings;
     * Writes a dynamic call for a def method.
            } else if (xsize == 1) {
                break;
                break;
                writeNewStrings();
                else if (cast.targetType == Integer.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_INTEGER_IMPLICIT);
     * This is invoked for each statement boundary (leaf {@code S*} nodes).
            else if (clazz == String.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_STRING);
        int flags
        if (size == 1) {
                else if (cast.targetType == Short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_SHORT_EXPLICIT);
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_INT;
            invokeConstructor(STRINGBUILDER_TYPE, STRINGBUILDER_CONSTRUCTOR);
        // (e.g. nodes get assigned wrong offsets by antlr walker)
                math(GeneratorAdapter.AND, getType(clazz));
        }
        this.settings = settings;
        Label label = new Label();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                break;
            box(getType(cast.boxOriginalType));
        }
        // TODO: maybe track these in bitsets too? this is trickier...
            case LSH:
                    flags |= DefBootstrap.OPERATOR_ALLOWS_NULL;
            case REM:
            writeCast(cast.originalType, cast.targetType);
import static org.opensearch.painless.WriterConstants.DEF_TO_B_LONG_IMPLICIT;
    }
        final Label end = new Label();
import static org.opensearch.painless.WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE;
    }
            );
            // Java 8: push a StringBuilder append
        }
                return Type.getType(new String(braces) + Type.getType(Object.class).getDescriptor());
            LAMBDA_BOOTSTRAP_HANDLE,
    }
        switch (operation) {
                invokeDefCall("lsh", methodType, DefBootstrap.SHIFT_OPERATOR, flags);
     * <p>
            case DIV:
            throw location.createError(new IllegalStateException("Illegal tree structure."));
    }
            else invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_OBJECT);
                invokeDefCall("or", methodType, DefBootstrap.BINARY_OPERATOR, flags);
        } else if (cast.boxTargetType != null) {
    }
            // method since java 8 did not check, but java 9 and 10 do
        } else if (cast.originalType == String.class && cast.targetType == char.class) {
                break;
     * <p>
            pop2();
        } else if (cast.unboxOriginalType != null) {
                    true
import static org.opensearch.painless.WriterConstants.DEF_UTIL_TYPE;
            case ADD:
            }
import static org.opensearch.painless.WriterConstants.DEF_TO_B_SHORT_IMPLICIT;
            unbox(getType(cast.unboxOriginalType));
            unbox(getType(cast.unboxOriginalType));
 * not use this file except in compliance with the License.
    public void writeBinaryInstruction(Location location, Class<?> clazz, Operation operation) {
        }
                || operation == Operation.BWAND
                // add the return value type as new first param for next concat:
            }
                boolean hasPrimitiveArg = lhs.isPrimitive() || rhs.isPrimitive();
            else if (clazz == float.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_FLOAT);
    }
        }
        }
        switch (operation) {
            Class<?> component = clazz.getComponentType();
import static org.opensearch.painless.WriterConstants.CHAR_TO_STRING;
            stringConcatArgs.push(new ArrayList<>());
        super(
            writeCast(cast.unboxOriginalType, cast.boxTargetType);
    }
 * Extension of {@link GeneratorAdapter} with some utility methods.
                break;
                || operation == Operation.BWOR)) {
        );
import static org.opensearch.painless.WriterConstants.DEF_TO_P_SHORT_IMPLICIT;
                break;
                Arrays.fill(braces, '[');
        if (cast.originalType == char.class && cast.targetType == String.class) {
    public void invokeMethodCall(PainlessMethod painlessMethod) {
        super.endMethod();
            case XOR:
                math(GeneratorAdapter.XOR, getType(clazz));
        Class<?> returnType,
 * <p>
        assert slot != -1;
            // Java 9+: record type information
import static org.opensearch.painless.WriterConstants.UTILITY_TYPE;
                else if (cast.targetType == byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BYTE_IMPLICIT);
     */
        if (from.equals(to)) {
                else if (cast.targetType == Boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BOOLEAN);
import static org.opensearch.painless.WriterConstants.DEF_TO_B_SHORT_EXPLICIT;
    public void invokeDefCall(String name, Type methodType, int flavor, Object... params) {
import static org.opensearch.painless.WriterConstants.DEF_TO_P_DOUBLE_IMPLICIT;
 * ownership. Elasticsearch licenses this file to you under
        if (cast == null) {
 * compatible open source license.
                else if (cast.targetType == Character.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_CHARACTER_EXPLICIT);
            } else {
            // invokeStatic assumes that the owner class is not an interface, so this is a
 * You may obtain a copy of the License at
            else if (clazz == char.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_CHAR);
            if (cast.explicitCast) {
    private final BitSet statements;
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BOOLEAN;
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_CHAR;
            case REM:
 * GitHub history for details.
import static org.opensearch.painless.WriterConstants.DEF_TO_P_SHORT_EXPLICIT;
        } else if (painlessMethod.javaMethod.getDeclaringClass().isInterface()) {
    public void box(Type type) {
                else if (cast.targetType == Double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_DOUBLE_IMPLICIT);
import static org.opensearch.painless.WriterConstants.DEF_TO_P_BYTE_EXPLICIT;
/**
        Object[] args = new Object[7 + functionRef.delegateInjections.length];
            args
                else {
            return 0; // nothing added to stack
            invokeStatic(UTILITY_TYPE, STRING_TO_CHAR);
            final String desc = Type.getMethodDescriptor(STRING_TYPE, stringConcatArgs.pop().stream().toArray(Type[]::new));
 * this file be licensed under the Apache-2.0 license or a
                checkCast(getType(to));
     * Encodes the offset into the line number table as {@code offset + 1}.
            case DIV:
                else if (cast.targetType == Byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BYTE_IMPLICIT);
            if (component == def.class) {
    @Override
        }
 * shared by the nodes of the Painless tree.
import static org.opensearch.painless.WriterConstants.DEF_TO_B_CHARACTER_EXPLICIT;
     * @return the size of arguments pushed to stack (the object that does string concats, e.g. a StringBuilder)
 * specific language governing permissions and limitations
import static org.opensearch.painless.WriterConstants.DEF_TO_P_BYTE_IMPLICIT;
                dupX1();
    }
                invokeDefCall("sub", methodType, DefBootstrap.BINARY_OPERATOR, flags);
            // true to reference the appropriate class constant when calling a static interface
            if (xsize == 2) {
        } else if (size == 2) {
            method.getDescriptor()
        Location location,
    }
import static org.opensearch.painless.WriterConstants.PAINLESS_ERROR_TYPE;
                break;
        if (stringConcatArgs != null && !stringConcatArgs.isEmpty()) {
                else if (cast.targetType == Float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_FLOAT_IMPLICIT);
            method.getName(),
            } else {
import static org.opensearch.painless.WriterConstants.DEF_TO_P_INT_EXPLICIT;
            access,
    public void writeDup(final int size, final int xsize) {
        this.statements = statements;
                    writeCast(cast.originalType, cast.targetType);
 *
/*
        throwException(PAINLESS_ERROR_TYPE, "The maximum number of statements that can be executed in a loop has been reached.");
    private void writeCast(Class<?> from, Class<?> to) {
            writeCast(cast.originalType, cast.targetType);
    public void writeLoopCounter(int slot, Location location) {
        Operation operation,
