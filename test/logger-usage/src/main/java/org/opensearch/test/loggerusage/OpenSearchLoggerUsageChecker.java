        }
                return BasicValue.REFERENCE_VALUE;
/*
import java.nio.file.SimpleFileVisitor;
                            argumentTypes[1].equals(OBJECT_CLASS)) {
            this.wrongUsageCallback = wrongUsageCallback;
            BasicValue arraySizeObject = getStackValue(arraySizeFrame, methodInsn, arrayIndex);
                        } else if (argumentTypes.length == 3 &&
                return;
        @Override
                Object constant = ((LdcInsnNode) insnNode).cst;
            Frame<BasicValue>[] arraySizeFrames = arraySizeAnalyzer.getFrames();
        public void visitEnd() {
                    // If the class (or one of its supertypes) cannot be resolved on the checker's class path we
                urls.add(Paths.get(classDirectory).toUri().toURL());
            }
            if (Files.isDirectory(root) == false) {
    private static class IntMinMaxTrackingBasicValue extends BasicValue {
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 1);
        protected final int minValue;
            this.logMethodName = logMethodName;
                case ICONST_5: return new IntegerConstantBasicValue(Type.INT_TYPE, 5);
                    if (Files.isRegularFile(file) && file.getFileName().toString().endsWith(".class")) {
import java.util.function.Consumer;
        @Override
                            checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, 0, 1);
                return;
            if (logMessageLength == null) {
            wrongUsageFound[0] = true;
        private final int line;
                      ClassLoader classLoader) {
            sb.append(errorMessage);
        @Override
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
            return super.newOperation(insnNode);
import org.objectweb.asm.tree.MethodInsnNode;
                return null;
            BasicValue value = getStackValue(throwableFrame, methodInsn, index);
            }
            switch (insnNode.getOpcode()) {
                return new IntegerConstantBasicValue(Type.INT_TYPE, Math.min(c1.minValue, c2.minValue), Math.max(c1.maxValue, c2.maxValue));
 */
            this.className = className;
                    wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
                        try (InputStream in = Files.newInputStream(file)) {
import org.objectweb.asm.tree.analysis.Analyzer;
    }
                    "Expected " + logMessageLength.minValue + " arguments but got " + arraySize.minValue));
            sb.append(":");
        public BasicValue merge(BasicValue value1, BasicValue value2) {
                        }
        private final Predicate<String> methodsToCheck;
 */
                            Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);
            }
import java.nio.file.attribute.BasicFileAttributes;
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
    static void check(Consumer<WrongLoggerUsage> wrongUsageCallback, InputStream inputStream, Predicate<String> methodsToCheck)
        Type.getObjectType("org/opensearch/test/loggerusage/TestMessage")
        private static boolean isReference(Type type) {
                    return Throwable.class.isAssignableFrom(clazz);
    /**
        public String getErrorLines() {
                            argumentTypes[2].equals(OBJECT_ARRAY_CLASS)) {
                return;
            Frame<BasicValue>[] logMessageFrames = stringPlaceHolderAnalyzer.getFrames();
import java.util.concurrent.ConcurrentHashMap;
    public static class WrongLoggerUsage {
            } else {
                case ICONST_0: return new IntegerConstantBasicValue(Type.INT_TYPE, 0);
        public String toString() {
    /**
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        throws IOException {
                        } else {
                        } else if (argumentTypes.length == 3 &&
import org.apache.logging.log4j.Marker;
public class OpenSearchLoggerUsageChecker {
 * not use this file except in compliance with the License.
            }
        @Override
 *
                            int markerOffset = 1; // skip key
            if (insnNode.getOpcode() == Opcodes.AASTORE && value1 instanceof ArraySizeBasicValue) {
        private void checkArrayArgs(MethodNode methodNode, Frame<BasicValue> logMessageFrame, Frame<BasicValue> arraySizeFrame,
                }
            super(type, constant);
                    "Could not determine size of array"));
                IntegerConstantBasicValue constantBasicValue = (IntegerConstantBasicValue) value;
                return new PlaceHolderStringBasicValue(Math.min(c1.minValue, c2.minValue), Math.max(c1.maxValue, c2.maxValue));
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
    public static final Type OBJECT_ARRAY_CLASS = Type.getType(Object[].class);
 * KIND, either express or implied.  See the License for the
            super(Opcodes.ASM7, new MethodNode(access, name, desc, null, null));
            this.minValue = value;
                        verifyLoggerUsage(methodNode, logMessageFrames, arraySizeFrames, throwableFrames, lineNumber, i,
                    }else if (objectType.equals(PARAMETERIZED_MESSAGE_CLASS)) {
            super.visitEnd();
            if (this == o) return true;
                                methodInsn, argumentTypes, markerOffset, lengthWithoutMarker);
                case ICONST_4: return new IntegerConstantBasicValue(Type.INT_TYPE, 4);
            if (ignoreChecks == false) {
                    " that is not supported by logger usage checker");
                default: return super.newOperation(insnNode);
            sb.append(LOGGER_CLASS.getClassName()).append("#").append(logMethodName);
        System.out.println("checking for wrong usages of OpenSearchLogger...");
                '}';
                // one fewer placeholder than the number of positional arguments.
 * software distributed under the License is distributed on an
                        return super.newOperation(insnNode);
                throw new RuntimeException("Internal error: failed in analysis step", e);
                throw new IllegalStateException("Method invoked on " + LOGGER_CLASS.getClassName() +
            Path root = Paths.get(classDirectory);
        }
            if (o == null || getClass() != o.getClass()) return false;
        private final String logMethodName;
                }
        public BasicValue newOperation(AbstractInsnNode insnNode) throws AnalyzerException {
                                       Type[] argumentTypes, int markerOffset, int lengthWithoutMarker) {
                return new ArraySizeBasicValue(Type.INT_TYPE, Math.min(c1.minValue, c2.minValue), Math.max(c1.maxValue, c2.maxValue));
        public BasicValue merge(BasicValue value1, BasicValue value2) {
        @Override
import java.util.List;
        @Override
                throwableAnalyzer.analyze(className, methodNode);
            }
                ", logMethodName='" + logMethodName + '\'' +
                checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, markerOffset + 0,
                    "Multiple log messages with conflicting number of place holders"));
        }
     */
 * Licensed to Elasticsearch under one or more contributor
        private String className;
                                                                       int lineNumber, MethodInsnNode methodInsn, int messageIndex,
    private static final class ArraySizeInterpreter extends BasicInterpreter {
                    argumentTypes[markerOffset + 1].equals(SUPPLIER_ARRAY_CLASS))) {
            if (logMessageLength.minValue != positionalArgsLength) {
    // make sure this functionality works
    private static final class PlaceHolderStringInterpreter extends BasicInterpreter {
                // MULTI-PARAM METHOD: debug(Marker?, String, Object p0, ...)
            }
            });
                            argumentTypes[0].equals(STRING_CLASS) &&
                    }
            return THROWABLE_CACHE.computeIfAbsent(type.getClassName(), className -> {
        private void checkFixedArityArgs(MethodNode methodNode, Frame<BasicValue> logMessageFrame, int lineNumber,
 * Unless required by applicable law or agreed to in writing,
                                "Constructor: "+ Arrays.toString(argumentTypes)));
                return super.visitMethod(access, name, desc, signature, exceptions);
                return;
            if (value1.equals(value2)) {
     */
                // VARARGS METHOD: debug(Marker?, String, (Object...|Supplier...))
                            argumentTypes[0].equals(STRING_CLASS) &&
            }
            super(STRING_OBJECT_TYPE, placeHolders);
            this.maxValue = maxValue;
    }
                return false;
            super(Opcodes.ASM9);
            return 31 * super.hashCode() + 1;
    private static BasicValue getStackValue(Frame<BasicValue> f, MethodInsnNode methodInsn, int index) {
                        int lengthWithoutMarker = argumentTypes.length - markerOffset;
        }
    public static final Type THROWABLE_CLASS = Type.getType(Throwable.class);
        int top = f.getStackSize() - 1;
            super(STRING_OBJECT_TYPE, minPlaceHolders, maxPlaceHolders);
            super(type);
     * A {@link BasicValue} that marks a stack/local value as being statically known to be a {@link Throwable}.
                // reference, mirroring the default BasicInterpreter behavior of normalizing references to Object.
            if (value1 instanceof IntegerConstantBasicValue && value2 instanceof IntegerConstantBasicValue) {
    public static final Type OBJECT_CLASS = Type.getType(Object.class);
                            argumentTypes[2].equals(OBJECT_CLASS)) {
        return count;
/*
        }
        }
        @Override
                            argumentTypes[1].equals(OBJECT_ARRAY_CLASS)) {
        boolean[] wrongUsageFound = new boolean[1];
            }
                            verifyLoggerUsage(methodNode, logMessageFrames, arraySizeFrames, throwableFrames, lineNumber, i,
                case SIPUSH: return new IntegerConstantBasicValue(Type.INT_TYPE, ((IntInsnNode)insnNode).operand);
            if (type != null && type.getSort() == Type.OBJECT && isThrowable(type)) {
            this.classLoader = classLoader == null ? ThrowableInterpreter.class.getClassLoader() : classLoader;
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
            int result = super.hashCode();
        public static final Type STRING_OBJECT_TYPE = Type.getObjectType("java/lang/String");
            sb.append(")");
            } catch (MalformedURLException e) {
            if (logMessageLength == null) {
            if (throwableFrame == null) {
            Analyzer<BasicValue> throwableAnalyzer = new Analyzer<>(new ThrowableInterpreter(classLoader));
            if (this == o) {
                return false;
import java.util.ArrayList;
        private boolean isThrowable(Type type) {
import org.objectweb.asm.tree.analysis.BasicValue;
            if (insnNode.getOpcode() == Opcodes.ANEWARRAY && value instanceof IntegerConstantBasicValue) {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
                throw new IllegalArgumentException(root + " should be an existing directory");
            if (logMessageLength.minValue != logMessageLength.maxValue) {
                }
            System.err.println(wrongLoggerUsage.getErrorLines());
                return new ArraySizeBasicValue(Type.getType("[" + Type.getObjectType(desc)), constantBasicValue.minValue,
            this.errorMessage = errorMessage;
     * {@link Throwable} subtype, which is needed to support the SLF4J/Log4j2 style of passing a trailing throwable.
                ArraySizeBasicValue c1 = (ArraySizeBasicValue) value1;
            throws AnalyzerException {
import java.util.Arrays;
                PlaceHolderStringBasicValue c2 = (PlaceHolderStringBasicValue) value2;
            } else if (value1 instanceof ArraySizeBasicValue && value2 instanceof ArraySizeBasicValue) {
        Type.getObjectType("org/opensearch/common/logging/DeprecatedMessage"),
            String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf(".") + 1, fullClassName.length());
            }
            if (IGNORE_CHECKS_ANNOTATION.equals(Type.getType(desc).getClassName())) {
                        } else if (argumentTypes.length == 3 &&
 * Modifications Copyright OpenSearch Contributors. See
            BasicValue logMessageLengthObject = getStackValue(logMessageFrame, methodInsn, messageIndex);
        }
        private void checkFixedArityArgs(MethodNode methodNode, Frame<BasicValue> logMessageFrame, int lineNumber,
                checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, markerOffset + 0,
/*
        private final String className;
                        "First argument must be a string constant so that we can statically ensure proper place holder usage"));
        }
                                new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
        }
                        }
            }
    private static final class ThrowableBasicValue extends BasicValue {
            Type type1 = value1.getType();
            return super.newValue(type);
                    "Multiple parameter arrays with conflicting sizes"));
        public String toString() {
        PlaceHolderStringBasicValue(int minPlaceHolders, int maxPlaceHolders) {
            }
                return new ThrowableBasicValue(THROWABLE_CLASS);
    public static final Type LOGGER_CLASS = Type.getType(Logger.class);
                } else if (insn.getOpcode() == Opcodes.INVOKESPECIAL) { // constructor invocation
                argumentTypes[markerOffset + 0].equals(STRING_CLASS) &&
                        if (LOGGER_METHODS.contains(methodInsn.name) == false) {
            return type != null && (type.getSort() == Type.OBJECT || type.getSort() == Type.ARRAY);
            if (logMessageLength.minValue != arraySize.minValue) {
                // statically a Throwable, Log4j2 extracts it as the logged exception, so the message is allowed to have
            this.methodName = methodName;
                                       Frame<BasicValue>[] throwableFrames, int lineNumber, int i, MethodInsnNode methodInsn,
            this.maxValue = value;
import org.objectweb.asm.tree.analysis.BasicInterpreter;
        public boolean equals(Object o) {
        }
                checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, markerOffset + 0, 0);
                String desc = ((TypeInsnNode) insnNode).desc;
            super(Opcodes.ASM7);
                // logged as the associated exception. Detect that case so the placeholder count check can allow it.
                } else {
import org.objectweb.asm.AnnotationVisitor;
                    lineNumber = lineNumberNode.line;
import org.objectweb.asm.tree.TypeInsnNode;
        private static final Map<String, Boolean> THROWABLE_CACHE = new ConcurrentHashMap<>();
 *
            return "IntMinMaxTrackingBasicValue{" +
            if (value1 instanceof PlaceHolderStringBasicValue && value2 instanceof PlaceHolderStringBasicValue
                    MethodInsnNode methodInsn = (MethodInsnNode) insn;
import org.apache.logging.log4j.message.ParameterizedMessage;
                case Opcodes.LDC: {
    }
        public boolean equals(Object o) {
            PlaceHolderStringBasicValue logMessageLength = checkLogMessageConsistency(methodNode, logMessageFrame, lineNumber, methodInsn,
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        private void verifyLoggerUsage(MethodNode methodNode, Frame<BasicValue>[] logMessageFrames, Frame<BasicValue>[] arraySizeFrames,
            }
                    return false;
import java.net.URL;
                wrongUsageCallback.accept(new WrongLoggerUsage(className, methodNode.name, methodInsn.name, lineNumber,
    }
     * Log4j2's multi-parameter logger methods (e.g. {@code debug(String, Object, Object)}) type a trailing throwable
                    // don't check logger usage for logger.warn(someObject)
        }
 * GitHub history for details.
                return value1;
 * under the License.
                            argumentTypes[0].equals(STRING_CLASS) &&
            super(type, minArraySize, maxArraySize);
            PlaceHolderStringBasicValue logMessageLength = (PlaceHolderStringBasicValue) logMessageLengthObject;
            return "WrongLoggerUsage{" +
        }
                        }
                    }
            Analyzer<BasicValue> arraySizeAnalyzer = new Analyzer<>(new ArraySizeInterpreter());
    }
                ", maxValue=" + maxValue +
                }
                IntegerConstantBasicValue c1 = (IntegerConstantBasicValue) value1;
        }
            });
                            argumentTypes[0].equals(STRING_CLASS) &&
            sb.append("Bad usage of ");
import org.objectweb.asm.Type;
        private final Consumer<WrongLoggerUsage> wrongUsageCallback;
         * Returns an error message that has the form of stack traces emitted by {@link Throwable#printStackTrace}
        @Override
import java.util.Map;
    public static final Type SUPPLIER_ARRAY_CLASS = Type.getType(Supplier[].class);
import org.objectweb.asm.tree.LdcInsnNode;
    }
                } catch (Throwable t) {
    public static final String IGNORE_CHECKS_ANNOTATION = "org.opensearch.common.SuppressLoggerChecks";
     * Tracks which stack/local values are statically known to be {@link Throwable} instances. This is needed because
            Type type2 = value2.getType();
        }
        PlaceHolderStringBasicValue(int placeHolders) {
            checkFixedArityArgs(methodNode, logMessageFrame, lineNumber, methodInsn, messageIndex, positionalArgsLength, false);
                      ClassLoader classLoader) throws IOException {
        @Override
import java.nio.file.Paths;
                argumentTypes[markerOffset + 0].equals(STRING_CLASS) &&
            return super.merge(value1, value2);
                            methodInsn, argumentTypes, markerOffset, lengthWithoutMarker);
                            continue;
                    return;
        @Override
            try {
            this.className = name;
            }
                        }
            int innerClassIndex = simpleClassName.indexOf("$");
                }
                case ICONST_1: return new IntegerConstantBasicValue(Type.INT_TYPE, 1);
import java.util.function.Predicate;
        @Override
                ", line=" + line +
                ArraySizeBasicValue c2 = (ArraySizeBasicValue) value2;
                    }
    // used by tests
        @Override
        public BasicValue merge(BasicValue value1, BasicValue value2) {
                ", errorMessage='" + errorMessage + '\'' +
                        Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);
            IntMinMaxTrackingBasicValue that = (IntMinMaxTrackingBasicValue) o;
            } else {
        }
        IntMinMaxTrackingBasicValue(Type type, int minValue, int maxValue) {
                            argumentTypes[1].equals(OBJECT_CLASS) &&
                    Object constant = ((LdcInsnNode)insnNode).cst;
 * specific language governing permissions and limitations
        }
            sb.append("\n\tat ");
            return sb.toString();
        List<URL> urls = new ArrayList<>();
    public static void main(String... args) throws Exception {
        ArraySizeInterpreter() {
            }
                            argumentTypes[0].equals(STRING_CLASS) &&
                if (lastArgIsThrowable && logMessageLength.minValue == positionalArgsLength - 1) {
                try {
                    if (Type.getObjectType(methodInsn.owner).equals(LOGGER_CLASS)) {
                "minValue=" + minValue +
                        }
                return new ThrowableBasicValue(type);
        @Override
        public WrongLoggerUsage(String className, String methodName, String logMethodName, int line, String errorMessage) {
        }
                        }
            try {
            }
        PlaceHolderStringInterpreter() {
        private boolean ignoreChecks;
            AbstractInsnNode[] insns = methodNode.instructions.toArray();
            }
            Frame<BasicValue>[] throwableFrames = throwableAnalyzer.getFrames();
            if (logMessageLengthObject instanceof PlaceHolderStringBasicValue == false) {
        }
 *
    }
    private static final class IntegerConstantBasicValue extends IntMinMaxTrackingBasicValue {
    private static final class ArraySizeBasicValue extends IntMinMaxTrackingBasicValue {
        @Override
        private final String errorMessage;
import org.objectweb.asm.ClassVisitor;
            if (arraySize.minValue != arraySize.maxValue) {
                    if (constant instanceof Integer) {
            result = 31 * result + maxValue;
        }
                    return super.visitFile(file, attrs);
            }
                // SLF4J / Log4j2 style: a trailing Throwable is not a placeholder argument. When the last argument is
                        Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);
                findBadLoggerUsages((MethodNode) mv);
                stringPlaceHolderAnalyzer.analyze(className, methodNode);
            if (isReference(type1) && isReference(type2)) {
 * ownership. Elasticsearch licenses this file to you under
        public int hashCode() {
        }
                ", methodName='" + methodName + '\'' +
    private static final class ThrowableInterpreter extends BasicInterpreter {
        for (int i = 1; i < message.length(); i++) {
            int lineNumber = -1;
            this.minValue = minValue;
            result = 31 * result + minValue;
                messageIndex, positionalArgsLength);
        }
        IntMinMaxTrackingBasicValue(Type type, int value) {
 */
                            argumentTypes[2].equals(THROWABLE_CLASS)) {
                                         MethodInsnNode methodInsn, int messageIndex, int positionalArgsLength,
        public BasicValue ternaryOperation(AbstractInsnNode insnNode, BasicValue value1, BasicValue value2, BasicValue value3)
    private static class MethodChecker extends MethodVisitor {
        }
                lengthWithoutMarker == 2 ? argumentTypes[markerOffset + 1].equals(THROWABLE_CLASS) : true) {
                if (insn.getOpcode() == Opcodes.INVOKEINTERFACE) {
    }
    }
        }
        }
import java.net.URLClassLoader;
            if (!super.equals(o)) return false;
        public int hashCode() {
package org.opensearch.test.loggerusage;
import java.io.IOException;
        private boolean ignoreChecks;
                    // those cases rather than risking a false positive.
                arraySizeAnalyzer.analyze(className, methodNode);
                return null;
    ).collect(Collectors.toSet());
                ignoreChecks = true;
            sb.append(simpleClassName);
        } else {
                            argumentTypes[0].equals(STRING_CLASS) &&
            System.out.println("No wrong usages found");
                                                                       int argsSize) {
                count++;
            ArraySizeBasicValue arraySize = (ArraySizeBasicValue) arraySizeObject;
            }
        ClassChecker(Consumer<WrongLoggerUsage> wrongUsageCallback, Predicate<String> methodsToCheck, ClassLoader classLoader) {
import org.objectweb.asm.MethodVisitor;
            super(Opcodes.ASM7);
        public BasicValue newValue(Type type) {
import org.apache.logging.log4j.util.Supplier;
        }
import java.io.InputStream;
            PlaceHolderStringBasicValue logMessageLength = checkLogMessageConsistency(methodNode, logMessageFrame, lineNumber, methodInsn,
                } else if (insn.getOpcode() == Opcodes.INVOKEVIRTUAL) {
                return;
        }
            this.className = className;
    public static final Type PARAMETERIZED_MESSAGE_CLASS = Type.getType(ParameterizedMessage.class);
 * The OpenSearch Contributors require contributions made to
                        if (methodInsn.name.equals("deprecate")) {
    private static final class PlaceHolderStringBasicValue extends IntMinMaxTrackingBasicValue {
                        int markerOffset = 0;
                PlaceHolderStringBasicValue c1 = (PlaceHolderStringBasicValue) value1;
                messageIndex, arraySize.minValue);
        }
        private PlaceHolderStringBasicValue checkLogMessageConsistency(MethodNode methodNode, Frame<BasicValue> logMessageFrame,
                AbstractInsnNode insn = insns[i];
                return value1;
    }
            sb.append(fullClassName);
            this.line = line;
import java.nio.file.FileVisitResult;
                    markerOffset + 1);
         */
            this.wrongUsageCallback = wrongUsageCallback;
        MethodChecker(String className, int access, String name, String desc, Consumer<WrongLoggerUsage> wrongUsageCallback,
            return super.ternaryOperation(insnNode, value1, value2, value3);
import java.net.MalformedURLException;
                        return new IntegerConstantBasicValue(Type.INT_TYPE, (Integer)constant);
    public static final Type MARKER_CLASS = Type.getType(Marker.class);
                    MethodInsnNode methodInsn = (MethodInsnNode) insn;
            super(type);
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (minValue != that.minValue) return false;
                IntegerConstantBasicValue c2 = (IntegerConstantBasicValue) value2;
        if (wrongUsageFound[0]) {
            return logMessageLength;
            }
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 2);
        private final ClassLoader classLoader;
            String fullClassName = Type.getObjectType(className).getClassName();
                argumentTypes[markerOffset + 1].equals(OBJECT_CLASS)) {
        }
        ThrowableInterpreter(ClassLoader classLoader) {
                            checkArrayArgs(methodNode, logMessageFrames[i], arraySizeFrames[i], lineNumber, methodInsn, 0, 1);
    public static final Type STRING_CLASS = Type.getType(String.class);
            return super.merge(value1, value2);
                // throwable using the common Throwable supertype.
        private final ClassLoader classLoader;
import java.nio.file.Path;
import org.objectweb.asm.tree.AbstractInsnNode;
        @Override
                }
        }
                @Override
            return maxValue == that.maxValue;
        @Override
                                    int lineNumber, MethodInsnNode methodInsn, int messageIndex, int arrayIndex) {
        }
        @Override
            simpleClassName = simpleClassName + ".java";
                                " that is not supported by logger usage checker"+
                    LineNumberNode lineNumberNode = (LineNumberNode) insn;
                        Type[] argumentTypes = Type.getArgumentTypes(methodInsn.desc);
        int count = 0;
            }
import org.objectweb.asm.tree.LineNumberNode;
                    if (DEPRECATED_TYPES.contains(objectType)) {
                case ICONST_2: return new IntegerConstantBasicValue(Type.INT_TYPE, 2);
            }
import org.objectweb.asm.Opcodes;
        }
                if (argsSize > 0) {
     * Builds a class loader that can resolve the classes being checked (in addition to the JDK and log4j classes that
        for (String classDirectory : classDirectories) {
            if (message.charAt(i - 1) == '{' && message.charAt(i) == '}') {
            } catch (AnalyzerException e) {
            super(Opcodes.ASM7);
        private final String methodName;
        private final Consumer<WrongLoggerUsage> wrongUsageCallback;
            }
            return result;
     * are already on the checker's class path). This allows the checker to determine whether a logger argument is a
        ClassLoader classLoader = buildClassLoader(classDirectories);
            return super.visitAnnotation(desc, visible);
            return super.merge(value1, value2);
            return super.unaryOperation(insnNode, value);
        private static boolean isThrowableArg(Frame<BasicValue> throwableFrame, MethodInsnNode methodInsn, int index) {
                simpleClassName = simpleClassName.substring(0, innerClassIndex);
                            argumentTypes[1].equals(OBJECT_ARRAY_CLASS) &&
    }
                }
    public static final Type STRING_ARRAY_CLASS = Type.getType(String[].class);
        for (String classDirectory : classDirectories) {
        ThrowableBasicValue(Type type) {
            super(type, minConstant, maxConstant);
                // In SLF4J / Log4j2 style a trailing Throwable is not a placeholder argument; it is extracted and
            throw new Exception("Wrong logger usages found");
    /**
    private static ClassLoader buildClassLoader(String... classDirectories) {
            }
            super(type);
        }
        private final ClassLoader classLoader;
                    }
                    }
        }
    }
import java.util.stream.Stream;
                && value1.equals(value2) == false) {
        IntegerConstantBasicValue(Type type, int minConstant, int maxConstant) {
                        if (argumentTypes.length == 3 &&
        public void findBadLoggerUsages(MethodNode methodNode) {
    }
            sb.append(line);
                case BIPUSH:
                            argumentTypes[1].equals(STRING_CLASS) &&
import java.util.Set;
import org.objectweb.asm.tree.analysis.Frame;
                boolean lastArgIsThrowable = isThrowableArg(throwableFrames[i], methodInsn, argumentTypes.length - 1);
            sb.append(": ");
    }
            if (o == null || getClass() != o.getClass()) {
                if (insn instanceof LineNumberNode) {
            for (int i = 0; i < insns.length; i++) {
        /**
 * license agreements. See the NOTICE file distributed with
        ArraySizeBasicValue(Type type, int minArraySize, int maxArraySize) {
}
        IntegerConstantBasicValue(Type type, int constant) {
        }
            if (insnNode.getOpcode() == Opcodes.LDC) {
                i += 1;
import org.objectweb.asm.tree.analysis.AnalyzerException;
            sb.append(methodName);
                // Different reference types (at least one of which is not a throwable) merge to a plain object
        return new URLClassLoader(urls.toArray(new URL[0]), OpenSearchLoggerUsageChecker.class.getClassLoader());
            } else if (lengthWithoutMarker >= 2 &&
            if (value1 instanceof ThrowableBasicValue && value2 instanceof ThrowableBasicValue) {
import org.objectweb.asm.tree.MethodNode;
    static void check(Consumer<WrongLoggerUsage> wrongUsageCallback, InputStream inputStream, Predicate<String> methodsToCheck,
        check(wrongUsageCallback, inputStream, methodsToCheck, OpenSearchLoggerUsageChecker.class.getClassLoader());
                    MethodInsnNode methodInsn = (MethodInsnNode) insn;
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        int relIndex = Type.getArgumentTypes(methodInsn.desc).length - 1 - index;
     */
                case ICONST_3: return new IntegerConstantBasicValue(Type.INT_TYPE, 3);
            if (innerClassIndex > 0) {
            this.classLoader = classLoader;
 * this work for additional information regarding copyright
        @Override
                            checkFixedArityArgs(methodNode, logMessageFrames[i], lineNumber, methodInsn, 0, 2);
 * compatible open source license.
import org.objectweb.asm.ClassReader;
        checkLoggerUsage(wrongLoggerUsage -> {
            }
                    } else {
                        } else if (argumentTypes.length == 2 &&
            return super.visitAnnotation(desc, visible);
                // Both branches yield a throwable, but possibly of different concrete types: keep tracking it as a
import org.apache.logging.log4j.Logger;
    private static int calculateNumberOfPlaceHolders(String message) {
            }
                ignoreChecks = true;
                        if (argumentTypes[0].equals(MARKER_CLASS)) {
        @Override
        }
                throw new IllegalArgumentException("Unable to resolve class directory " + classDirectory, e);
                    constantBasicValue.maxValue);
        private final String className;
        }
            } else if ((lengthWithoutMarker == 1 || lengthWithoutMarker == 2) &&
        }
            this.methodsToCheck = methodsToCheck;
            }
            sb.append("(");
        }
        return relIndex <= top ? f.getStack(top - relIndex) : null;
            assert logMessageLength.minValue == logMessageLength.maxValue && arraySize.minValue == arraySize.maxValue;
    private static class ClassChecker extends ClassVisitor {
            }
            if (IGNORE_CHECKS_ANNOTATION.equals(Type.getType(desc).getClassName())) {
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            this.classLoader = classLoader;
                            throw new IllegalStateException("Constructor invoked on " + objectType +
                    //using strings because this test do not depend on server
        }
                return;
            StringBuilder sb = new StringBuilder();
import java.util.stream.Collectors;
                    return new PlaceHolderStringBasicValue(calculateNumberOfPlaceHolders((String) constant));
            if (ignoreChecks == false && methodsToCheck.test(name)) {
                    if (methodInsn.owner.equals("org/opensearch/common/logging/DeprecationLogger")) {
    // types which are subject to checking when used in logger. <code>TestMessage<code> is also declared here to
        ClassReader cr = new ClassReader(inputStream);
    public static final Set<Type> DEPRECATED_TYPES = Stream.of(
        }
import java.nio.file.Files;
     * argument as {@link Object}, so the throwable cannot be recognized from the method descriptor alone.
                            int lengthWithoutMarker = argumentTypes.length - markerOffset;
                            OpenSearchLoggerUsageChecker.check(wrongUsageCallback, in, s -> true, classLoader);
        }
    }
            return super.equals(o);
        }, args);
    private static void checkLoggerUsage(Consumer<WrongLoggerUsage> wrongUsageCallback, String... classDirectories)
                    Class<?> clazz = Class.forName(className, false, classLoader);
        throws IOException {
                            argumentTypes[1].equals(STRING_ARRAY_CLASS) &&
                    Type objectType = Type.getObjectType(methodInsn.owner);
                            argumentTypes[2].equals(THROWABLE_CLASS)) {
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        protected final int maxValue;
    }
            if (lengthWithoutMarker == 2 &&
        public BasicValue newOperation(AbstractInsnNode insnNode) throws AnalyzerException {
        }
        }
                    lengthWithoutMarker - 1, lastArgIsThrowable);
    }
                if (constant instanceof String) {
        }
            Analyzer<BasicValue> stringPlaceHolderAnalyzer = new Analyzer<>(new PlaceHolderStringInterpreter());
            }
                                         MethodInsnNode methodInsn, int messageIndex, int positionalArgsLength) {
        public BasicValue unaryOperation(AbstractInsnNode insnNode, BasicValue value) throws AnalyzerException {
                    "Expected " + logMessageLength.minValue + " arguments but got " + positionalArgsLength));
                return new MethodChecker(this.className, access, name, desc, wrongUsageCallback, classLoader);
                            markerOffset = 1;
            if (arraySizeObject instanceof ArraySizeBasicValue == false) {
        }
            return value instanceof ThrowableBasicValue;
                "className='" + className + '\'' +
                (argumentTypes[markerOffset + 1].equals(OBJECT_ARRAY_CLASS) ||
 * the Apache License, Version 2.0 (the "License"); you may
                                         boolean lastArgIsThrowable) {
            }
        }
                // all the rest: debug(Marker?, (Message|MessageSupplier|CharSequence|Object|String|Supplier), Throwable?)
    }
            }
            }
                }
    @SuppressForbidden(reason = "command line tool")
                    // conservatively treat it as not a throwable. This keeps the previous, stricter behavior for
import org.objectweb.asm.tree.IntInsnNode;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
 * SPDX-License-Identifier: Apache-2.0
            sb.append(".");
                '}';
                return true;
                        if (argumentTypes.length == 2 &&
        cr.accept(new ClassChecker(wrongUsageCallback, methodsToCheck, classLoader), 0);
    public static final List<String> LOGGER_METHODS = Arrays.asList("trace", "debug", "info", "warn", "error", "fatal");
            }
