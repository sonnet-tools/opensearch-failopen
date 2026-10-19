            }  
                                                                       int lineNumber, MethodInsnNode methodInsn, int messageIndex,
import org.objectweb.asm.tree.analysis.Frame;
        @Override
                }  
        @Override
            }
            IntMinMaxTrackingBasicValue that = (IntMinMaxTrackingBasicValue) o;  
                        } else if (argumentTypes.length == 2 &&
            return super.merge(value1, value2);
            return THROWABLE_CACHE.computeIfAbsent(type.getClassName(), className -> {  
                return new ArraySizeBasicValue(Type.INT_TYPE, Math.min(c1.minValue, c2.minValue), Math.max(c1.maxValue, c2.maxValue));
                    // conservatively treat it as not a throwable. This keeps the previous, stricter behavior for  
                    "Multiple log messages with conflicting number of place holders"));
            System.out.println("No wrong usages found");  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.util.Supplier;
            sb.append(LOGGER_CLASS.getClassName()).append("#").append(logMethodName);
            }  
 * not use this file except in compliance with the License.
import java.util.concurrent.ConcurrentHashMap;
            this.minValue = value;
    public static final Type STRING_CLASS = Type.getType(String.class);
                    if (constant instanceof Integer) {  
    private static final class ThrowableBasicValue extends BasicValue {
                if (lastArgIsThrowable && logMessageLength.minValue == positionalArgsLength - 1) {
    private static class MethodChecker extends MethodVisitor {  
        IntMinMaxTrackingBasicValue(Type type, int value) {  
                }  
        }  
    public static void main(String... args) throws Exception {
    public static class WrongLoggerUsage {
            } else if (value1 instanceof ArraySizeBasicValue && value2 instanceof ArraySizeBasicValue) {
                PlaceHolderStringBasicValue c1 = (PlaceHolderStringBasicValue) value1;
                            argumentTypes[1].equals(OBJECT_CLASS) &&
            Frame<BasicValue>[] throwableFrames = throwableAnalyzer.getFrames();
                        try (InputStream in = Files.newInputStream(file)) {
            super(Opcodes.ASM7);
                        int lengthWithoutMarker = argumentTypes.length - markerOffset;
                            markerOffset = 1;
            this.classLoader = classLoader == null ? ThrowableInterpreter.class.getClassLoader() : classLoader;  
        }  
            int innerClassIndex = simpleClassName.indexOf("$");  
    public static final Type OBJECT_ARRAY_CLASS = Type.getType(Object[].class);
        }
                    if (methodInsn.owner.equals("org/opensearch/common/logging/DeprecationLogger")) {
            } else if (lengthWithoutMarker >= 2 &&
                // Different reference types (at least one of which is not a throwable) merge to a plain object  
                    " that is not supported by logger usage checker");
                    if (Type.getObjectType(methodInsn.owner).equals(LOGGER_CLASS)) {  
                return value1;  
                            argumentTypes[1].equals(STRING_ARRAY_CLASS) &&
import java.util.function.Consumer;
            }
            }
                throw new IllegalStateException("Method invoked on " + LOGGER_CLASS.getClassName() +
        }  
        private final Consumer<WrongLoggerUsage> wrongUsageCallback;
                throw new IllegalArgumentException(root + " should be an existing directory");
    public static final Set<Type> DEPRECATED_TYPES = Stream.of(  
                            argumentTypes[1].equals(STRING_CLASS) &&  
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {  
        public BasicValue newOperation(AbstractInsnNode insnNode) throws AnalyzerException {
        }
            });
                        if (argumentTypes[0].equals(MARKER_CLASS)) {
        private final String logMethodName;
            if (Files.isDirectory(root) == false) {  
                case ICONST_4: return new IntegerConstantBasicValue(Type.INT_TYPE, 4);  
/*  
        }
            this.logMethodName = logMethodName;
            }
                if (argsSize > 0) {  
            Frame<BasicValue>[] arraySizeFrames = arraySizeAnalyzer.getFrames();  
        }
                case BIPUSH:
        }
            return super.newValue(type);
         */
            simpleClassName = simpleClassName + ".java";
        }  
import org.objectweb.asm.tree.IntInsnNode;  
        int top = f.getStackSize() - 1;
                // SLF4J / Log4j2 style: a trailing Throwable is not a placeholder argument. When the last argument is
                    "Could not determine size of array"));  
                                         MethodInsnNode methodInsn, int messageIndex, int positionalArgsLength) {
    @SuppressForbidden(reason = "command line tool")
            }
            PlaceHolderStringBasicValue logMessageLength = checkLogMessageConsistency(methodNode, logMessageFrame, lineNumber, methodInsn,
import java.util.List;
            if (minValue != that.minValue) return false;
            } else {  
                                methodInsn, argumentTypes, markerOffset, lengthWithoutMarker);  
                // VARARGS METHOD: debug(Marker?, String, (Object...|Supplier...))
            return super.equals(o);
        PlaceHolderStringInterpreter() {  
import java.io.InputStream;
                } else if (insn.getOpcode() == Opcodes.INVOKEVIRTUAL) {  
                            argumentTypes[0].equals(STRING_CLASS) &&
                boolean lastArgIsThrowable = isThrowableArg(throwableFrames[i], methodInsn, argumentTypes.length - 1);
import org.objectweb.asm.ClassVisitor;
        }
     */
        }
                AbstractInsnNode insn = insns[i];
        public boolean equals(Object o) {
            return type != null && (type.getSort() == Type.OBJECT || type.getSort() == Type.ARRAY);
            Analyzer<BasicValue> stringPlaceHolderAnalyzer = new Analyzer<>(new PlaceHolderStringInterpreter());
    }
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
import org.objectweb.asm.tree.LineNumberNode;
        @Override
                                "Constructor: "+ Arrays.toString(argumentTypes)));  
                    // don't check logger usage for logger.warn(someObject)
        ThrowableBasicValue(Type type) {
        boolean[] wrongUsageFound = new boolean[1];
        }
    public static final Type MARKER_CLASS = Type.getType(Marker.class);
import org.apache.logging.log4j.Marker;
            }
import java.io.IOException;  
        @Override  
                // Both branches yield a throwable, but possibly of different concrete types: keep tracking it as a
                // In SLF4J / Log4j2 style a trailing Throwable is not a placeholder argument; it is extracted and  
                } catch (Throwable t) {
            sb.append(errorMessage);  
        for (String classDirectory : classDirectories) {
    }
                            checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, 0, 1);
import java.nio.file.SimpleFileVisitor;  
        }
            if (logMessageLength.minValue != positionalArgsLength) {
 * GitHub history for details.
        @Override
    }  
            sb.append(": ");
                            argumentTypes[0].equals(STRING_CLASS) &&
            BasicValue value = getStackValue(throwableFrame, methodInsn, index);  
            } else {  
            return super.visitAnnotation(desc, visible);
                        Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);  
                                         MethodInsnNode methodInsn, int messageIndex, int positionalArgsLength,  
                (argumentTypes[markerOffset + 1].equals(OBJECT_ARRAY_CLASS) ||  
            }
            sb.append("(");
                    LineNumberNode lineNumberNode = (LineNumberNode) insn;
                arraySizeAnalyzer.analyze(className, methodNode);  
import java.nio.file.Path;
                    }  
            return result;  
import org.objectweb.asm.tree.analysis.BasicInterpreter;
                throw new RuntimeException("Internal error: failed in analysis step", e);  
import org.objectweb.asm.Type;
public class OpenSearchLoggerUsageChecker {
                findBadLoggerUsages((MethodNode) mv);
                String desc = ((TypeInsnNode) insnNode).desc;
                            checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, 0, 2);  
            return super.ternaryOperation(insnNode, value1, value2, value3);
        @Override
    // used by tests
            if (lengthWithoutMarker == 2 &&
                    }
            if (logMessageLength.minValue != logMessageLength.maxValue) {  
        protected final int minValue;  
        @Override  
            super(type);
            Analyzer<BasicValue> throwableAnalyzer = new Analyzer<>(new ThrowableInterpreter(classLoader));  
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
 * Unless required by applicable law or agreed to in writing,
            String fullClassName = Type.getObjectType(className).getClassName();
            if (message.charAt(i - 1) == '{' && message.charAt(i) == '}') {  
                }
            this.classLoader = classLoader;
            this.className = className;  
 *  
            }
        public BasicValue merge(BasicValue value1, BasicValue value2) {
import java.net.MalformedURLException;
                            argumentTypes[2].equals(OBJECT_CLASS)) {
import java.nio.file.attribute.BasicFileAttributes;
                                new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
            return sb.toString();
                        if (LOGGER_METHODS.contains(methodInsn.name) == false) {
        public void visitEnd() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            } else if ((lengthWithoutMarker == 1 || lengthWithoutMarker == 2) &&
        }
                    } else {
    }
        }
                                       Type[] argumentTypes, int markerOffset, int lengthWithoutMarker) {  
            checkFixedArityArgs(methodNode, logMessageFrame, lineNumber, methodInsn, messageIndex, positionalArgsLength, false);
        }  
        Type.getObjectType("org/opensearch/test/loggerusage/TestMessage")
        }
            return maxValue == that.maxValue;  
                      ClassLoader classLoader) {
        }
                return;
            AbstractInsnNode[] insns = methodNode.instructions.toArray();
        private final String className;
                return;
                        Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
                ArraySizeBasicValue c2 = (ArraySizeBasicValue) value2;  
        private void verifyLoggerUsage(MethodNode methodNode, Frame<BasicValue>[] logMessageFrames, Frame<BasicValue>[] arraySizeFrames,
            sb.append(fullClassName);
                    if (DEPRECATED_TYPES.contains(objectType)) {
                argumentTypes[markerOffset + 0].equals(STRING_CLASS) &&  
                      ClassLoader classLoader) throws IOException {
 * KIND, either express or implied.  See the License for the
                        if (argumentTypes.length == 3 &&
                } else if (insn.getOpcode() == Opcodes.INVOKESPECIAL) { // constructor invocation
    public static final List<String> LOGGER_METHODS = Arrays.asList("trace", "debug", "info", "warn", "error", "fatal");
                argumentTypes[markerOffset + 1].equals(OBJECT_CLASS)) {
 * this work for additional information regarding copyright
                    Class<?> clazz = Class.forName(className, false, classLoader);
        public BasicValue merge(BasicValue value1, BasicValue value2) {
        private void checkFixedArityArgs(MethodNode methodNode, Frame<BasicValue> logMessageFrame, int lineNumber,  
    }
            this.className = name;  
        private String className;  
                "minValue=" + minValue +  
            result = 31 * result + maxValue;
                    // those cases rather than risking a false positive.
        }
import org.objectweb.asm.MethodVisitor;
                return false;
                    return Throwable.class.isAssignableFrom(clazz);  
            if (type != null && type.getSort() == Type.OBJECT && isThrowable(type)) {
 * SPDX-License-Identifier: Apache-2.0
                Object constant = ((LdcInsnNode) insnNode).cst;
        private void checkFixedArityArgs(MethodNode methodNode, Frame<BasicValue> logMessageFrame, int lineNumber,
            sb.append(methodName);
        @Override
        private static boolean isThrowableArg(Frame<BasicValue> throwableFrame, MethodInsnNode methodInsn, int index) {
                            verifyLoggerUsage(methodNode, logMessageFrames, arraySizeFrames, throwableFrames, lineNumber, i,
                    return super.visitFile(file, attrs);
            }  
            this.errorMessage = errorMessage;
            this.classLoader = classLoader;
            if (value1 instanceof PlaceHolderStringBasicValue && value2 instanceof PlaceHolderStringBasicValue
import org.objectweb.asm.tree.MethodNode;
            } catch (MalformedURLException e) {  
            this.className = className;  
            }  
            if (arraySize.minValue != arraySize.maxValue) {  
            super(type, minArraySize, maxArraySize);
                                " that is not supported by logger usage checker"+
                return;
            if (!super.equals(o)) return false;
    /**
                IntegerConstantBasicValue c2 = (IntegerConstantBasicValue) value2;
        IntMinMaxTrackingBasicValue(Type type, int minValue, int maxValue) {  
                // all the rest: debug(Marker?, (Message|MessageSupplier|CharSequence|Object|String|Supplier), Throwable?)
    public static final Type OBJECT_CLASS = Type.getType(Object.class);
                            argumentTypes[0].equals(STRING_CLASS) &&
                        }
        private static final Map<String, Boolean> THROWABLE_CACHE = new ConcurrentHashMap<>();  
                ", maxValue=" + maxValue +
                case ICONST_2: return new IntegerConstantBasicValue(Type.INT_TYPE, 2);
    public static final Type STRING_ARRAY_CLASS = Type.getType(String[].class);
                if (insn instanceof LineNumberNode) {  
            }
        }, args);
            }
    private static BasicValue getStackValue(Frame<BasicValue> f, MethodInsnNode methodInsn, int index) {
                "className='" + className + '\'' +
import org.objectweb.asm.Opcodes;  
        }  
/*  
                checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, markerOffset + 0, 0);
     * Log4j2's multi-parameter logger methods (e.g. {@code debug(String, Object, Object)}) type a trailing throwable
 * ownership. Elasticsearch licenses this file to you under  
                if (insn.getOpcode() == Opcodes.INVOKEINTERFACE) {
        }  
            }
                            argumentTypes[0].equals(STRING_CLASS) &&
package org.opensearch.test.loggerusage;
            this.maxValue = maxValue;  
                                         boolean lastArgIsThrowable) {
    public static final Type THROWABLE_CLASS = Type.getType(Throwable.class);  
            sb.append("\n\tat ");
            }
            try {
            if (throwableFrame == null) {  
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 1);
                    lengthWithoutMarker - 1, lastArgIsThrowable);
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 1);
            if (logMessageLength == null) {
        ArraySizeInterpreter() {
                            int lengthWithoutMarker = argumentTypes.length - markerOffset;  
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
import java.net.URL;  
                case Opcodes.LDC: {
    ).collect(Collectors.toSet());  
    // make sure this functionality works
            if (o == null || getClass() != o.getClass()) {
            return super.merge(value1, value2);
    }
                    wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
                }  
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 1);  
                    // If the class (or one of its supertypes) cannot be resolved on the checker's class path we
        private void checkArrayArgs(MethodNode methodNode, Frame<BasicValue> logMessageFrame, Frame<BasicValue> arraySizeFrame,
            }
     */  
        int count = 0;
 */  
        ArraySizeBasicValue(Type type, int minArraySize, int maxArraySize) {
        ClassLoader classLoader = buildClassLoader(classDirectories);  
        System.out.println("checking for wrong usages of OpenSearchLogger...");  
            if (ignoreChecks == false) {  
            super(type);
            } catch (AnalyzerException e) {
            if (isReference(type1) && isReference(type2)) {
        }
        public BasicValue unaryOperation(AbstractInsnNode insnNode, BasicValue value) throws AnalyzerException {
    private static final class ThrowableInterpreter extends BasicInterpreter {
                ignoreChecks = true;
}
                            argumentTypes[2].equals(THROWABLE_CLASS)) {  
            if (insnNode.getOpcode() == Opcodes.ANEWARRAY && value instanceof IntegerConstantBasicValue) {
        @Override
                            argumentTypes[2].equals(OBJECT_ARRAY_CLASS)) {
            this.wrongUsageCallback = wrongUsageCallback;
                }
        @Override  
            BasicValue arraySizeObject = getStackValue(arraySizeFrame, methodInsn, arrayIndex);  
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 2);
                            throw new IllegalStateException("Constructor invoked on " + objectType +  
        }
        }
                    if (Files.isRegularFile(file) && file.getFileName().toString().endsWith(".class")) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return new ArraySizeBasicValue(Type.getType("[" + Type.getObjectType(desc)), constantBasicValue.minValue,
        @Override
        List<URL> urls = new ArrayList<>();
        }
            throws AnalyzerException {
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {  
                return new IntegerConstantBasicValue(Type.INT_TYPE, Math.min(c1.minValue, c2.minValue), Math.max(c1.maxValue, c2.maxValue));  
 * Licensed to Elasticsearch under one or more contributor  
                case ICONST_5: return new IntegerConstantBasicValue(Type.INT_TYPE, 5);
                throwableAnalyzer.analyze(className, methodNode);
        checkLoggerUsage(wrongLoggerUsage -> {
     * argument as {@link Object}, so the throwable cannot be recognized from the method descriptor alone.  
        }  
            if (value1 instanceof ThrowableBasicValue && value2 instanceof ThrowableBasicValue) {
                checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, markerOffset + 0,  
        IntegerConstantBasicValue(Type type, int constant) {
            if (IGNORE_CHECKS_ANNOTATION.equals(Type.getType(desc).getClassName())) {
import java.util.Map;
 * You may obtain a copy of the License at  
            wrongUsageFound[0] = true;
    private static final class ArraySizeBasicValue extends IntMinMaxTrackingBasicValue {  
            }
import java.net.URLClassLoader;
        private boolean ignoreChecks;
            if (value1 instanceof IntegerConstantBasicValue && value2 instanceof IntegerConstantBasicValue) {  
        }
    private static final class ArraySizeInterpreter extends BasicInterpreter {  
        /**  
        PlaceHolderStringBasicValue(int minPlaceHolders, int maxPlaceHolders) {
                && value1.equals(value2) == false) {  
 * under the License.  
            return value instanceof ThrowableBasicValue;
            PlaceHolderStringBasicValue logMessageLength = checkLogMessageConsistency(methodNode, logMessageFrame, lineNumber, methodInsn,
     * {@link Throwable} subtype, which is needed to support the SLF4J/Log4j2 style of passing a trailing throwable.
                        } else if (argumentTypes.length == 3 &&
        public String getErrorLines() {  
            switch (insnNode.getOpcode()) {
            if (ignoreChecks == false && methodsToCheck.test(name)) {
import org.objectweb.asm.tree.MethodInsnNode;  
                        } else {
        private final ClassLoader classLoader;  
            Analyzer<BasicValue> arraySizeAnalyzer = new Analyzer<>(new ArraySizeInterpreter());
 *
    public static final Type LOGGER_CLASS = Type.getType(Logger.class);
                IntegerConstantBasicValue c1 = (IntegerConstantBasicValue) value1;
import java.util.Arrays;  
                    lineNumber = lineNumberNode.line;
 * this file be licensed under the Apache-2.0 license or a
                return new MethodChecker(this.className, access, name, desc, wrongUsageCallback, classLoader);
            this.line = line;  
            super(STRING_OBJECT_TYPE, placeHolders);
            sb.append(line);
            }
                        if (argumentTypes.length == 2 &&  
                            argumentTypes[0].equals(STRING_CLASS) &&
                i += 1;
                messageIndex, arraySize.minValue);
                @Override
                    }
        }
                ", logMethodName='" + logMethodName + '\'' +  
    }
            if (value1.equals(value2)) {
        public String toString() {
            int lineNumber = -1;  
    static void check(Consumer<WrongLoggerUsage> wrongUsageCallback, InputStream inputStream, Predicate<String> methodsToCheck,
            super(Opcodes.ASM9);
    }  
                // MULTI-PARAM METHOD: debug(Marker?, String, Object p0, ...)
    private static final class IntegerConstantBasicValue extends IntMinMaxTrackingBasicValue {  
            this.maxValue = value;  
        public static final Type STRING_OBJECT_TYPE = Type.getObjectType("java/lang/String");
            }  
            return logMessageLength;
        }
            Type type1 = value1.getType();  
                default: return super.newOperation(insnNode);  
                    }
            this.wrongUsageCallback = wrongUsageCallback;
            super(type, constant);
        }  
        private static boolean isReference(Type type) {
                case ICONST_3: return new IntegerConstantBasicValue(Type.INT_TYPE, 3);
            }
                        }
    static void check(Consumer<WrongLoggerUsage> wrongUsageCallback, InputStream inputStream, Predicate<String> methodsToCheck)
            try {
    private static void checkLoggerUsage(Consumer<WrongLoggerUsage> wrongUsageCallback, String... classDirectories)
                argumentTypes[markerOffset + 0].equals(STRING_CLASS) &&
                ArraySizeBasicValue c1 = (ArraySizeBasicValue) value1;
import java.util.function.Predicate;  
                    markerOffset + 1);
            throw new Exception("Wrong logger usages found");
            return "WrongLoggerUsage{" +  
                    return new PlaceHolderStringBasicValue(calculateNumberOfPlaceHolders((String) constant));  
            this.minValue = minValue;
            if (IGNORE_CHECKS_ANNOTATION.equals(Type.getType(desc).getClassName())) {
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
 */
        ClassReader cr = new ClassReader(inputStream);  
                                    int lineNumber, MethodInsnNode methodInsn, int messageIndex, int arrayIndex) {
        int relIndex = Type.getArgumentTypes(methodInsn.desc).length - 1 - index;  
    /**  
        for (String classDirectory : classDirectories) {  
    }  
        private final String errorMessage;  
            Path root = Paths.get(classDirectory);
    public static final Type SUPPLIER_ARRAY_CLASS = Type.getType(Supplier[].class);  
            }
                }
            }
            String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf(".") + 1, fullClassName.length());
    public static final Type PARAMETERIZED_MESSAGE_CLASS = Type.getType(ParameterizedMessage.class);
                    MethodInsnNode methodInsn = (MethodInsnNode) insn;  
     * Builds a class loader that can resolve the classes being checked (in addition to the JDK and log4j classes that  
        private final Predicate<String> methodsToCheck;  
        @Override  
            }
                return false;  
                PlaceHolderStringBasicValue c2 = (PlaceHolderStringBasicValue) value2;
                                                                       int argsSize) {  
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
            super(Opcodes.ASM7);
import org.objectweb.asm.AnnotationVisitor;
                return;  
import java.nio.file.Paths;
                            continue;
        private final int line;
                // logged as the associated exception. Detect that case so the placeholder count check can allow it.
    }  
                stringPlaceHolderAnalyzer.analyze(className, methodNode);
import java.nio.file.FileVisitResult;
                                       Frame<BasicValue>[] throwableFrames, int lineNumber, int i, MethodInsnNode methodInsn,
        check(wrongUsageCallback, inputStream, methodsToCheck, OpenSearchLoggerUsageChecker.class.getClassLoader());
 * Modifications Copyright OpenSearch Contributors. See
        throws IOException {  
                    }
            this.methodName = methodName;
                        }  
            }
                return;  
        }
                        return super.newOperation(insnNode);  
                return BasicValue.REFERENCE_VALUE;
 * license agreements. See the NOTICE file distributed with
            this.methodsToCheck = methodsToCheck;  
            StringBuilder sb = new StringBuilder();
                } else {  
                    constantBasicValue.maxValue);  
        private PlaceHolderStringBasicValue checkLogMessageConsistency(MethodNode methodNode, Frame<BasicValue> logMessageFrame,
        private boolean ignoreChecks;
            if (logMessageLength.minValue != arraySize.minValue) {  
        @Override
                    "Expected " + logMessageLength.minValue + " arguments but got " + arraySize.minValue));
                ignoreChecks = true;  
            if (insnNode.getOpcode() == Opcodes.LDC) {  
                        verifyLoggerUsage(methodNode, logMessageFrames, arraySizeFrames, throwableFrames, lineNumber, i,
        }
            }
        private final ClassLoader classLoader;
import java.util.Set;  
        public void findBadLoggerUsages(MethodNode methodNode) {  
                case SIPUSH: return new IntegerConstantBasicValue(Type.INT_TYPE, ((IntInsnNode)insnNode).operand);  
        @Override
                // reference, mirroring the default BasicInterpreter behavior of normalizing references to Object.
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
                            methodInsn, argumentTypes, markerOffset, lengthWithoutMarker);
        public boolean equals(Object o) {
    private static class IntMinMaxTrackingBasicValue extends BasicValue {
            sb.append(".");  
 * specific language governing permissions and limitations
                            argumentTypes[1].equals(OBJECT_ARRAY_CLASS)) {
import java.util.ArrayList;
 * software distributed under the License is distributed on an
                    return;  
     */  
     * are already on the checker's class path). This allows the checker to determine whether a logger argument is a
                // one fewer placeholder than the number of positional arguments.
                return new ThrowableBasicValue(type);  
    private static int calculateNumberOfPlaceHolders(String message) {  
    private static final class PlaceHolderStringBasicValue extends IntMinMaxTrackingBasicValue {  
            return super.visitAnnotation(desc, visible);
import org.objectweb.asm.tree.analysis.BasicValue;  
            result = 31 * result + minValue;
                ", methodName='" + methodName + '\'' +
            super(Opcodes.ASM7, new MethodNode(access, name, desc, null, null));
        return count;
            }
        private final ClassLoader classLoader;
        @Override  
                // statically a Throwable, Log4j2 extracts it as the logged exception, so the message is allowed to have  
                        Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);
            sb.append(":");
            assert logMessageLength.minValue == logMessageLength.maxValue && arraySize.minValue == arraySize.maxValue;
            if (logMessageLengthObject instanceof PlaceHolderStringBasicValue == false) {
        }
import java.util.stream.Stream;
                        if (methodInsn.name.equals("deprecate")) {
                }  
                lengthWithoutMarker == 2 ? argumentTypes[markerOffset + 1].equals(THROWABLE_CLASS) : true) {  
                IntegerConstantBasicValue constantBasicValue = (IntegerConstantBasicValue) value;  
            if (o == null || getClass() != o.getClass()) return false;  
            }
                            argumentTypes[0].equals(STRING_CLASS) &&  
    private static class ClassChecker extends ClassVisitor {
        Type.getObjectType("org/opensearch/common/logging/DeprecatedMessage"),
            return "IntMinMaxTrackingBasicValue{" +
/*
                        }  
        protected final int maxValue;
        }  
    // types which are subject to checking when used in logger. <code>TestMessage<code> is also declared here to
            }
                return super.visitMethod(access, name, desc, signature, exceptions);
import org.objectweb.asm.tree.analysis.AnalyzerException;
                    return false;
        @Override
                return null;  
                    "Multiple parameter arrays with conflicting sizes"));
        IntegerConstantBasicValue(Type type, int minConstant, int maxConstant) {
            System.err.println(wrongLoggerUsage.getErrorLines());  
 * compatible open source license.
                    argumentTypes[markerOffset + 1].equals(SUPPLIER_ARRAY_CLASS))) {
        }  
        ClassChecker(Consumer<WrongLoggerUsage> wrongUsageCallback, Predicate<String> methodsToCheck, ClassLoader classLoader) {  
 */  
        }  
import java.nio.file.Files;  
                    }else if (objectType.equals(PARAMETERIZED_MESSAGE_CLASS)) {
                return new ThrowableBasicValue(THROWABLE_CLASS);
                checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, markerOffset + 0,  
import org.apache.logging.log4j.Logger;
            if (this == o) return true;
        }  
                return null;  
            });
        }
    }
            PlaceHolderStringBasicValue logMessageLength = (PlaceHolderStringBasicValue) logMessageLengthObject;
            if (insnNode.getOpcode() == Opcodes.AASTORE && value1 instanceof ArraySizeBasicValue) {
                            Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);  
            if (this == o) {
            Frame<BasicValue>[] logMessageFrames = stringPlaceHolderAnalyzer.getFrames();
            sb.append("Bad usage of ");  
                    MethodInsnNode methodInsn = (MethodInsnNode) insn;
            return 31 * super.hashCode() + 1;
        public BasicValue ternaryOperation(AbstractInsnNode insnNode, BasicValue value1, BasicValue value2, BasicValue value3)  
    /**
                try {
                // throwable using the common Throwable supertype.  
        } else {
            for (int i = 0; i < insns.length; i++) {
        cr.accept(new ClassChecker(wrongUsageCallback, methodsToCheck, classLoader), 0);
        public WrongLoggerUsage(String className, String methodName, String logMethodName, int line, String errorMessage) {
                return value1;
import org.objectweb.asm.tree.analysis.Analyzer;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
                return;
                    Object constant = ((LdcInsnNode)insnNode).cst;
            if (logMessageLength == null) {  
        }
            }  
        @Override
                        return new IntegerConstantBasicValue(Type.INT_TYPE, (Integer)constant);
                case ICONST_1: return new IntegerConstantBasicValue(Type.INT_TYPE, 1);  
            sb.append(simpleClassName);  
                        }  
                }
                        } else if (argumentTypes.length == 3 &&  
                return new PlaceHolderStringBasicValue(Math.min(c1.minValue, c2.minValue), Math.max(c1.maxValue, c2.maxValue));  
        return relIndex <= top ? f.getStack(top - relIndex) : null;
        @Override  
                        } else if (argumentTypes.length == 3 &&
        public int hashCode() {
                ", line=" + line +
    }
        public BasicValue newValue(Type type) {
                case ICONST_0: return new IntegerConstantBasicValue(Type.INT_TYPE, 0);
                            int markerOffset = 1; // skip key
            if (arraySizeObject instanceof ArraySizeBasicValue == false) {
            }
                '}';  
                            OpenSearchLoggerUsageChecker.check(wrongUsageCallback, in, s -> true, classLoader);
import org.apache.logging.log4j.message.ParameterizedMessage;  
    private static ClassLoader buildClassLoader(String... classDirectories) {
            return super.merge(value1, value2);  
    public static final String IGNORE_CHECKS_ANNOTATION = "org.opensearch.common.SuppressLoggerChecks";  
        }
            super(type, minConstant, maxConstant);  
        }  
import org.objectweb.asm.ClassReader;  
            super(STRING_OBJECT_TYPE, minPlaceHolders, maxPlaceHolders);
            return super.unaryOperation(insnNode, value);
import java.util.stream.Collectors;
                urls.add(Paths.get(classDirectory).toUri().toURL());
        return new URLClassLoader(urls.toArray(new URL[0]), OpenSearchLoggerUsageChecker.class.getClassLoader());
                if (constant instanceof String) {
                            argumentTypes[1].equals(OBJECT_ARRAY_CLASS) &&  
    }
                        int markerOffset = 0;  
        }
        }  
                    MethodInsnNode methodInsn = (MethodInsnNode) insn;
        PlaceHolderStringBasicValue(int placeHolders) {  
            super(Opcodes.ASM7);
                        }  
        @Override  
            int result = super.hashCode();  
            }  
                ", errorMessage='" + errorMessage + '\'' +
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            super.visitEnd();  
            if (innerClassIndex > 0) {
    }  
        for (int i = 1; i < message.length(); i++) {
            super(type);  
     * A {@link BasicValue} that marks a stack/local value as being statically known to be a {@link Throwable}.
                            argumentTypes[2].equals(THROWABLE_CLASS)) {
        private final String methodName;  
                    "Expected " + logMessageLength.minValue + " arguments but got " + positionalArgsLength));  
        throws IOException {
                messageIndex, positionalArgsLength);  
         * Returns an error message that has the form of stack traces emitted by {@link Throwable#printStackTrace}
            Type type2 = value2.getType();
     * Tracks which stack/local values are statically known to be {@link Throwable} instances. This is needed because
                    Type objectType = Type.getObjectType(methodInsn.owner);  
                        "First argument must be a string constant so that we can statically ensure proper place holder usage"));
        public BasicValue merge(BasicValue value1, BasicValue value2) {  
        public String toString() {
                simpleClassName = simpleClassName.substring(0, innerClassIndex);
        }  
        }  
    }
        private boolean isThrowable(Type type) {
        MethodChecker(String className, int access, String name, String desc, Consumer<WrongLoggerUsage> wrongUsageCallback,  
        ThrowableInterpreter(ClassLoader classLoader) {
            sb.append(")");  
        }  
                count++;
        if (wrongUsageFound[0]) {  
        public int hashCode() {  
                throw new IllegalArgumentException("Unable to resolve class directory " + classDirectory, e);
        }
        private final String className;
            return super.newOperation(insnNode);  
                return true;  
                    //using strings because this test do not depend on server
import org.objectweb.asm.tree.AbstractInsnNode;
    }
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {  
                            argumentTypes[1].equals(OBJECT_CLASS)) {  
 *
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
        private final Consumer<WrongLoggerUsage> wrongUsageCallback;
        public BasicValue newOperation(AbstractInsnNode insnNode) throws AnalyzerException {  
            ArraySizeBasicValue arraySize = (ArraySizeBasicValue) arraySizeObject;  
            BasicValue logMessageLengthObject = getStackValue(logMessageFrame, methodInsn, messageIndex);
    private static final class PlaceHolderStringInterpreter extends BasicInterpreter {
                '}';
