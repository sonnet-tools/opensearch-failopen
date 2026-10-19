import org.opensearch.painless.lookup.PainlessCast;
            } else {
    @Override  
                break;  
    public void box(Type type) {
                break;  
    }  
                else if (cast.targetType == double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_DOUBLE_IMPLICIT);  
                break;  
                writeToStrings();
     */
    public void writeDebugInfo(Location location) {
                invokeDefCall("or", methodType, DefBootstrap.BINARY_OPERATOR, flags);
                invokeDefCall("ush", methodType, DefBootstrap.SHIFT_OPERATOR, flags);
                || operation == Operation.USH
            if (!to.isAssignableFrom(from)) {  
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_STRING;
                else if (cast.targetType == Short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_SHORT_EXPLICIT);  
                break;  
        if (size == 1) {  
        ifICmp(GeneratorAdapter.GT, end);
import static org.opensearch.painless.WriterConstants.DEF_TO_B_INTEGER_IMPLICIT;
            case SUB:
 * SPDX-License-Identifier: Apache-2.0
            return Type.getType(Object.class);
        }  
                math(GeneratorAdapter.REM, getType(clazz));
            else if (clazz == long.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_LONG);
                math(GeneratorAdapter.AND, getType(clazz));
            // Java 9+: use type information and push invokeDynamic  
        System.arraycopy(params, 0, args, 2, params.length);
            stringConcatArgs.push(new ArrayList<>());
        }
                else if (cast.targetType == Long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_LONG_EXPLICIT);  
                invokeDefCall("and", methodType, DefBootstrap.BINARY_OPERATOR, flags);
                invokeDefCall("lsh", methodType, DefBootstrap.SHIFT_OPERATOR, flags);
            return;
     * @param methodType callsite signature
        args[1] = flavor;  
    public void invokeDefCall(String name, Type methodType, int flavor, Object... params) {  
                else if (cast.targetType == Double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_DOUBLE_EXPLICIT);
                    type.getInternalName(),
    }
import java.util.BitSet;  
import static org.opensearch.painless.WriterConstants.DEF_TO_STRING_EXPLICIT;  
import static org.opensearch.painless.WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE;  
            while (component.isArray()) {
                break;  
                if (cast.targetType == boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BOOLEAN);
     */  
                break;  
                    method.getDescriptor(),
            writeCast(cast.unboxOriginalType, cast.boxTargetType);
import static org.opensearch.painless.WriterConstants.DEF_TO_P_LONG_IMPLICIT;  
            invokeStatic(UTILITY_TYPE, STRING_TO_CHAR);
                break;  
                else if (cast.targetType == Byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BYTE_IMPLICIT);
                math(GeneratorAdapter.ADD, getType(clazz));
        );
    public void writeDynamicBinaryInstruction(
        }
                }
            else if (clazz == double.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_DOUBLE);
            invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_TOSTRING);
            if (xsize == 2) {
        this.statements = statements;
        Class<?> lhs,
                // add the return value type as new first param for next concat:  
            if (component == def.class) {  
            }
        args[6] = functionRef.isDelegateAugmented ? 1 : 0;
                boolean hasPrimitiveArg = lhs.isPrimitive() || rhs.isPrimitive();
            box(getType(cast.boxTargetType));
    }  
            writeCast(cast.originalType, cast.targetType);
            return 0; // nothing added to stack
        }
            } else if (xsize == 1) {  
import static org.opensearch.painless.WriterConstants.DEF_TO_P_FLOAT_IMPLICIT;
                component = component.getComponentType();
        Object[] args = new Object[params.length + 2];
                else if (cast.targetType == char.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_CHAR_EXPLICIT);
     * This is invoked for each statement boundary (leaf {@code S*} nodes).
                else {
    }  
                else if (cast.targetType == Character.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_CHARACTER_EXPLICIT);
                break;  
import static org.opensearch.painless.WriterConstants.STRING_TYPE;
 * under the License.  
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_DOUBLE;  
            // invokeStatic assumes that the owner class is not an interface, so this is a
                invokeDefCall("div", methodType, DefBootstrap.BINARY_OPERATOR, flags);
import static org.opensearch.painless.WriterConstants.DEF_TO_B_CHARACTER_EXPLICIT;  
        }  
            // Java 9+: record type information
import static org.opensearch.painless.WriterConstants.DEF_TO_B_DOUBLE_EXPLICIT;
import static org.opensearch.painless.WriterConstants.DEF_TO_P_DOUBLE_IMPLICIT;  
 * compatible open source license.
                math(GeneratorAdapter.XOR, getType(clazz));
 * this file be licensed under the Apache-2.0 license or a
            case BWOR:
            int dimensions = 1;
                else if (cast.targetType == float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_FLOAT_EXPLICIT);
                else if (cast.targetType == byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BYTE_EXPLICIT);  
                stringConcatArgs.peek().add(STRING_TYPE);
        args[3] = functionRef.delegateMethodName;
        switch (operation) {  
import static org.opensearch.painless.WriterConstants.PAINLESS_ERROR_TYPE;  
            }
        if (size == 1) {
            case USH:
                    painlessMethod.javaMethod.getName(),  
    }  
            if (stringConcatArgs.peek().size() >= MAX_INDY_STRING_CONCAT_ARGS) {  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BOOLEAN;  
            throw new IllegalStateException("String concat bytecode not completed.");
import static org.opensearch.painless.WriterConstants.STRING_TO_CHAR;  
                break;  
 * You may obtain a copy of the License at  
        }  
                else if (cast.targetType == float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_FLOAT_IMPLICIT);
import java.util.ArrayList;
        mark(end);  
    }
            case BWAND:
        statements.set(offset);
            else if (clazz == String.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_STRING);
            invokeConstructor(STRINGBUILDER_TYPE, STRINGBUILDER_CONSTRUCTOR);
 * GitHub history for details.
        switch (operation) {
import org.objectweb.asm.commons.GeneratorAdapter;
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_TOSTRING;
 * Extension of {@link GeneratorAdapter} with some utility methods.
        Class<?> rhs,
                break;
        }
                break;
                math(GeneratorAdapter.SHL, getType(clazz));
        return Type.getType(clazz);
                else if (cast.targetType == short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_SHORT_EXPLICIT);
            // If there are too many, do the actual concat:
        } else {  
    public void writeLoopCounter(int slot, Location location) {
    }
 *  
                if (!hasPrimitiveArg) {
        args[2] = functionRef.delegateInvokeType;  
        int flags
                checkCast(getType(to));
            case LSH:
        }  
                throw location.createError(new IllegalStateException("Illegal tree structure."));
        }
                ++dimensions;  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_DOUBLE_IMPLICIT;  
                || operation == Operation.RSH
            pop();
     * Encodes the offset into the line number table as {@code offset + 1}.  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_SHORT_IMPLICIT;
            // method since java 8 did not check, but java 9 and 10 do
import static org.opensearch.painless.WriterConstants.DEF_TO_P_CHAR_EXPLICIT;  
        } else if (size == 2) {  
import org.objectweb.asm.commons.Method;  
                else if (cast.targetType == String.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_STRING_EXPLICIT);  
    }
            case MUL:
                break;  
                return Type.getType(new String(braces) + Type.getType(Object.class).getDescriptor());
import org.opensearch.painless.lookup.PainlessMethod;
            cw.visitMethod(access, method.getName(), method.getDescriptor(), null, null),
        );  
            case BWAND:
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BYTE_EXPLICIT;
        Operation operation,  
 * software distributed under the License is distributed on an
 * <p>  
package org.opensearch.painless;
                // otherwise, we need to allow nulls for possible string concatenation.  
 *
            writeCast(cast.originalType, cast.targetType);  
            case ADD:
            functionRef.interfaceMethodName,
    ) {
                else if (cast.targetType == short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_SHORT_IMPLICIT);
import static org.opensearch.painless.WriterConstants.DEF_UTIL_TYPE;
                visitMethodInsn(  
                else if (cast.targetType == Integer.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_INTEGER_IMPLICIT);
/**
        assert slot != -1;  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_FLOAT_IMPLICIT;
        Object[] args = new Object[7 + functionRef.delegateInjections.length];  
        Label label = new Label();  
                    Opcodes.INVOKESTATIC,
 */  
            // prevent too many concat args.
     * Marks a new statement boundary.  
        throwException(PAINLESS_ERROR_TYPE, "The maximum number of statements that can be executed in a loop has been reached.");
    private final Deque<List<Type>> stringConcatArgs = (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE == null) ? null : new ArrayDeque<>();
        } else {  
/*  
import static org.opensearch.painless.WriterConstants.DEF_TO_P_BYTE_EXPLICIT;
import org.objectweb.asm.Type;
import static org.opensearch.painless.WriterConstants.DEF_TO_P_CHAR_IMPLICIT;
                }  
                break;  
            } else if (xsize == 1) {
        if (cast.originalType == char.class && cast.targetType == String.class) {
                }  
            else if (clazz == char.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_CHAR);  
        valueOf(type);
    public void writeStatementOffset(Location location) {
            // special case for interfaces where the interface method boolean needs to be set to
import java.lang.reflect.Modifier;
                dup2X1();
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_BOOLEAN;
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_CONSTRUCTOR;  
        // (e.g. nodes get assigned wrong offsets by antlr walker)
                Arrays.fill(braces, '[');
        visitLabel(label);
import static org.opensearch.painless.WriterConstants.DEF_TO_STRING_IMPLICIT;
public final class MethodWriter extends GeneratorAdapter {
        if (stringConcatArgs != null && !stringConcatArgs.isEmpty()) {  
                else if (cast.targetType == Byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BYTE_EXPLICIT);
                writeNewStrings();
 * Modifications Copyright OpenSearch Contributors. See
                invokeStatic(type, method);
import static org.opensearch.painless.WriterConstants.DEF_TO_P_SHORT_IMPLICIT;
            case SUB:
                else if (cast.targetType == long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_LONG_EXPLICIT);
        if (clazz.isArray()) {  
import static org.opensearch.painless.WriterConstants.MAX_INDY_STRING_CONCAT_ARGS;
        // TODO: introduce a way to ignore internal statements so this assert is not triggered
        } else if (size == 2) {
                math(GeneratorAdapter.SHR, getType(clazz));
            if (painlessMethod.javaMethod.getDeclaringClass().isInterface()) {
        // TODO: maybe track these in bitsets too? this is trickier...
                dupX1();
/*
        writeDebugInfo(location);
     * @return the size of arguments pushed to stack (the object that does string concats, e.g. a StringBuilder)
    public void visitEnd() {
            } else {  
        Type type = Type.getType(painlessMethod.javaMethod.getDeclaringClass());  
            invokeInterface(type, method);
 * Unless required by applicable law or agreed to in writing,
            method.getName(),  
                invokeDefCall("rem", methodType, DefBootstrap.BINARY_OPERATOR, flags);
            }  
        } else if (clazz == def.class) {  
    public void invokeLambdaCall(FunctionRef functionRef) {
    @Override
            return 1; // StringBuilder on stack
import static org.opensearch.painless.WriterConstants.DEF_TO_B_CHARACTER_IMPLICIT;
            // Java 8: push a StringBuilder append
        // ensure we don't have duplicate stuff going in here. can catch bugs  
            default:
import org.objectweb.asm.ClassVisitor;
        visitVarInsn(Opcodes.ILOAD, slot);
                STRINGBUILDER_APPEND_INT  
            access,
                break;  
    public void endMethod() {
    public int writeNewStrings() {
            box(getType(cast.boxOriginalType));
            case MUL:  
            }
     */  
    /**
    /** Writes a dynamic binary instruction: returnType, lhs, and rhs can be different */  
            // Java 8: call toString() on StringBuilder
import static org.opensearch.painless.WriterConstants.DEF_TO_B_INTEGER_EXPLICIT;  
            invokeVirtual(type, method);
        throw new AssertionError("Should never call this method on MethodWriter, use endMethod() instead");
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_INT;
                else if (cast.targetType == byte.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BYTE_IMPLICIT);  
            dup();  
            case ADD:  
                || operation == Operation.XOR
import static org.opensearch.painless.WriterConstants.DEF_TO_B_LONG_IMPLICIT;  
        args[0] = Type.getMethodType(functionRef.interfaceMethodType.toMethodDescriptorString());
        push(0);  
            case REM:
import static org.opensearch.painless.WriterConstants.DEF_TO_P_LONG_EXPLICIT;
 */  
                break;  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_FLOAT_EXPLICIT;
                STRINGBUILDER_TYPE,
            writeCast(cast.originalType, cast.targetType);
import static org.opensearch.painless.WriterConstants.DEF_TO_P_INT_EXPLICIT;  
            case DIV:  
        this.settings = settings;
            }
            final String desc = Type.getMethodDescriptor(STRING_TYPE, stringConcatArgs.pop().stream().toArray(Type[]::new));
                dupX2();  
                break;  
        invokeDynamic(name, methodType.getDescriptor(), DEF_BOOTSTRAP_HANDLE, args);
            else if (clazz == float.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_FLOAT);  
                break;  
    /** Writes a static binary instruction */  
import static org.opensearch.painless.WriterConstants.CHAR_TO_STRING;
            }
            writeCast(cast.originalType, cast.targetType);
 */
import static org.opensearch.painless.WriterConstants.LAMBDA_BOOTSTRAP_HANDLE;
        if ((clazz == float.class || clazz == double.class)
    }  
     * This is invoked before instructions that can hit exceptions.
        args[0] = settings.getInitialCallSiteDepth();
        if (from != boolean.class && from.isPrimitive() && to != boolean.class && to.isPrimitive()) {  
            // true to reference the appropriate class constant when calling a static interface  
 * the Apache License, Version 2.0 (the "License"); you may
                break;  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_SHORT_EXPLICIT;
                invokeDefCall("mul", methodType, DefBootstrap.BINARY_OPERATOR, flags);
        if (Modifier.isStatic(painlessMethod.javaMethod.getModifiers())) {  
        } else {  
import static org.opensearch.painless.WriterConstants.DEF_TO_P_FLOAT_EXPLICIT;
            case BWOR:
                    writeCast(cast.originalType, cast.targetType);
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_CHAR;
                math(GeneratorAdapter.DIV, getType(clazz));
                throw location.createError(new IllegalStateException("Illegal tree structure."));
    }  
                else if (cast.targetType == Integer.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_INTEGER_EXPLICIT);
        if (cast == null) {
            stringConcatArgs.peek().add(getType(clazz));  
            LAMBDA_BOOTSTRAP_HANDLE,
            Opcodes.ASM5,  
     */
            if (clazz == boolean.class) invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_BOOLEAN);
                else {
                dup2();  
                math(GeneratorAdapter.OR, getType(clazz));
            }
                else if (cast.targetType == double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_DOUBLE_EXPLICIT);  
    }
                dup();
        } else if (cast.originalType == String.class && cast.targetType == char.class) {  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_LONG_EXPLICIT;
import java.util.Deque;
                || operation == Operation.BWOR)) {
                else if (cast.targetType == Double.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_DOUBLE_IMPLICIT);
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_FLOAT;
        } else if (cast.boxOriginalType != null) {  
                invokeDefCall("add", methodType, DefBootstrap.BINARY_OPERATOR, flags);
 * license agreements. See the NOTICE file distributed with
import org.objectweb.asm.Label;
    /**
    private void writeCast(Class<?> from, Class<?> to) {
        // assert statements.get(offset) == false;
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BYTE_IMPLICIT;
    }
    @Override  
        if (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE != null) {
        if (from.equals(to)) {
        }
                // if either side is primitive, then the + operator should always throw NPE on null,
        args[4] = Type.getMethodType(functionRef.delegateMethodType.toMethodDescriptorString());
        if (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE != null) {
                else if (cast.targetType == Float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_FLOAT_IMPLICIT);
import java.util.Arrays;
    }
                invokeDefCall("rsh", methodType, DefBootstrap.SHIFT_OPERATOR, flags);
     * @param name method name
            unbox(getType(cast.unboxTargetType));
        int offset = location.getOffset();
            case DIV:
    }  
            pop2();  
        args[1] = functionRef.delegateClassName;
    public void writeToStrings() {
/*  
    public MethodWriter(int access, Method method, ClassVisitor cw, BitSet statements, CompilerSettings settings) {
            case XOR:
        Location location,
            Class<?> component = clazz.getComponentType();
     * <p>
                else if (cast.targetType == char.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_CHAR_IMPLICIT);
        System.arraycopy(functionRef.delegateInjections, 0, args, 7, functionRef.delegateInjections.length);
        super.endMethod();  
 *    http://www.apache.org/licenses/LICENSE-2.0
                dup2X2();
            unbox(getType(cast.unboxOriginalType));  
import org.opensearch.painless.lookup.def;  
import static org.opensearch.painless.WriterConstants.DEF_BOOTSTRAP_HANDLE;
        if (INDY_STRING_CONCAT_BOOTSTRAP_HANDLE != null) {
    public void writePop(final int size) {
 * shared by the nodes of the Painless tree.
import java.util.ArrayDeque;  
        }  
        args[5] = functionRef.isDelegateInterface ? 1 : 0;  
    }
 * Licensed to Elasticsearch under one or more contributor  
                if (cast.targetType == boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_BOOLEAN);
 * not use this file except in compliance with the License.
    public void writeCast(PainlessCast cast) {  
    /**  
        iinc(slot, -1);
                    writeCast(cast.originalType, cast.targetType);
            writeCast(cast.originalType, cast.targetType);
            } else {
    }
 */  
    /**
            } else {
     * @param params flavor-specific parameters
            // Java 8: create a StringBuilder in bytecode
    /** Starts a new string concat.
 *
                math(GeneratorAdapter.USHR, getType(clazz));
            method.getDescriptor()
 * The OpenSearch Contributors require contributions made to  
                break;  
import static org.opensearch.painless.WriterConstants.DEF_TO_P_DOUBLE_EXPLICIT;
                else if (cast.targetType == Float.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_FLOAT_EXPLICIT);
                math(GeneratorAdapter.MUL, getType(clazz));
                invokeDefCall("xor", methodType, DefBootstrap.BINARY_OPERATOR, flags);
            cast(getType(from), getType(to));
        } else {
}
            unbox(getType(cast.unboxOriginalType));
        }  
                else if (cast.targetType == Long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_LONG_IMPLICIT);  
            throw location.createError(new IllegalStateException("Illegal tree structure."));  
            case USH:
        Method method = Method.getMethod(painlessMethod.javaMethod);
                break;  
    }
    }
        } else if (cast.unboxOriginalType != null && cast.boxTargetType != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                else if (cast.targetType == Character.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_CHARACTER_IMPLICIT);
            args
                else if (cast.targetType == int.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_INT_EXPLICIT);  
 * Set of methods used during the writing phase of compilation
            case LSH:
     * @param flavor type of call  
     * Writes a dynamic call for a def method.  
     * Proxy the box method to use valueOf instead to ensure that the modern boxing methods are used.
            && (operation == Operation.LSH  
        } else if (painlessMethod.javaMethod.getDeclaringClass().isInterface()) {
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_TYPE;
                break;
            // Java 9+: we just push our argument collector onto deque  
            case XOR:
                break;  
            }
            case RSH:
import java.util.List;
                    true
     * <p>
                else if (cast.targetType == Short.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_SHORT_IMPLICIT);  
import static org.opensearch.painless.WriterConstants.DEF_TO_P_BYTE_IMPLICIT;
    public void invokeMethodCall(PainlessMethod painlessMethod) {
 * specific language governing permissions and limitations
            return;  
                char[] braces = new char[dimensions];
            box(getType(cast.boxTargetType));
        final Label end = new Label();
     */  
                    flags |= DefBootstrap.OPERATOR_ALLOWS_NULL;  
            else if (clazz == byte.class || clazz == short.class || clazz == int.class) invokeVirtual(
import static org.opensearch.painless.WriterConstants.DEF_TO_P_SHORT_EXPLICIT;
            if (cast.explicitCast) {
import static org.opensearch.painless.WriterConstants.DEF_TO_P_BOOLEAN;  
                else if (cast.targetType == long.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_LONG_IMPLICIT);
 * KIND, either express or implied.  See the License for the
        Type methodType = Type.getMethodType(getType(returnType), getType(lhs), getType(rhs));  
import static org.opensearch.painless.WriterConstants.DEF_TO_P_INT_IMPLICIT;
 * this work for additional information regarding copyright
            case REM:  
            );
                else if (cast.targetType == Boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BOOLEAN);
    public static Type getType(Class<?> clazz) {
        } else {  
            newInstance(STRINGBUILDER_TYPE);
    public void writeAppendStrings(Class<?> clazz) {  
        } else if (cast.unboxTargetType != null) {  
    public void writeBinaryInstruction(Location location, Class<?> clazz, Operation operation) {
                || operation == Operation.BWAND  
import org.objectweb.asm.Opcodes;  
            functionRef.factoryMethodType.toMethodDescriptorString(),  
                // so we don't need a special NPE guard.
                invokeDefCall("sub", methodType, DefBootstrap.BINARY_OPERATOR, flags);
        } else if (cast.boxTargetType != null) {  
            default:
                else if (cast.targetType == Boolean.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BOOLEAN);
                else if (cast.targetType == String.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_STRING_IMPLICIT);  
    }
        visitLineNumber(location.getOffset() + 1, label);
                math(GeneratorAdapter.SUB, getType(clazz));
            else invokeVirtual(STRINGBUILDER_TYPE, STRINGBUILDER_APPEND_OBJECT);  
        invokeDynamic(
        super(
        }
        }
                );  
    private final CompilerSettings settings;  
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_OBJECT;
        // TODO: https://github.com/elastic/elasticsearch/issues/51836  
            case RSH:
    public void writeDup(final int size, final int xsize) {  
        } else if (cast.unboxOriginalType != null) {  
                else if (cast.targetType == int.class) invokeStatic(DEF_UTIL_TYPE, DEF_TO_P_INT_IMPLICIT);  
    }  
            if (xsize == 2) {
        }
    private final BitSet statements;
            invokeStatic(UTILITY_TYPE, CHAR_TO_STRING);
import static org.opensearch.painless.WriterConstants.UTILITY_TYPE;
        Class<?> returnType,  
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.painless.WriterConstants.STRINGBUILDER_APPEND_LONG;  
        } else if (cast.originalType == def.class) {  
        } else {
            invokeDynamic("concat", desc, INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);
