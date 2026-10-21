                throw new IllegalArgumentException(
    ) {
                    + fieldName
    public void addPainlessClassBinding(
                    + "[["
                        + existingPainlessField.javaField.getName()
import java.lang.invoke.MethodHandles;
        Class<?> targetClass = targetInstance.getClass();
import java.util.ArrayList;
            PainlessField existingPainlessField = painlessClassBuilder.staticFields.get(painlessFieldKey);
        Objects.requireNonNull(typeParameters);
                        + "] not found for instance binding "
                    + "]"
                    + "], "
                    + "[["
    }
                        + typeToCanonicalTypeName(existingPainlessField.typeParameter)
            methodHandle,
                if (classesToPainlessClassBuilders.containsKey(childClass)) {
                    "type parameter ["
        Class<?> targetClass,
                    );
                        painlessClassBuilder.setterMethodHandles.putIfAbsent(
                    + typesToCanonicalTypeNames(typeParameters)
                    + "], "
            throw new IllegalArgumentException("imported method and instance binding cannot have the same name [" + methodName + "]");
            type = type.getComponentType();
                    + targetCanonicalClassName
                    + typesToCanonicalTypeNames(typeParameters)
        }
                )
 */
                        );
                );
        } else {
        }
        Objects.requireNonNull(targetInstance);
        }
            }
            String methodName = painlessMethod.javaMethod.getName();
                MethodHandle bridgeHandle = MethodHandles.publicLookup().in(bridgeClass).unreflect(bridgeClass.getMethods()[0]);
                    + targetCanonicalClassName
import java.util.regex.Pattern;
        Objects.requireNonNull(methodName);
        Map<Class<?>, Object> annotations
                );
            );
                    + "cannot represent multiple java classes with the same name from different class loaders"
                        + "for class binding [["
                    + targetCanonicalClassName
                    + targetClass.getCanonicalName()
                    + "] "
                    + "], "
            javaMethod,
 * The OpenSearch Contributors require contributions made to
                    + targetClass.getCanonicalName()
            boolean isStatic = Modifier.isStatic(painlessMethod.javaMethod.getModifiers());
                        + "]"
            annotations
        String javaClassName = clazz.getName();
                    + "cannot represent multiple java classes with the same name from different class loaders"
                    + methodName
        Map<Class<?>, Object> annotations
                    "type parameter ["
                throw new IllegalArgumentException(
                        + "[["
            throw new IllegalArgumentException(
            );
        } catch (IllegalAccessException iae) {
        }
            classesToPainlessClasses,
                        + "] "
                throw new IllegalArgumentException(
                    + "]"
                        + targetCanonicalClassName
        }
        List<Class<?>> typeParameters,
                        + "], ["
                    + "], "
                    + "] not found"
     * A generated bridge method replaces the method its a bridge to in the {@link PainlessClass#runtimeMethods}
        else if ("float".equals(javaClassName)) clazz = float.class;
                newPainlessField = painlessFieldCache.computeIfAbsent(newPainlessField, key -> key);
                    + "] and "
        MethodHandle methodHandle;
        Constructor<?> javaConstructor = null;
            throw new IllegalArgumentException("cannot add field to reserved class [" + DEF_CLASS_NAME + "]");
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
                        + typesToCanonicalTypeNames(typeParameters)
                        );
    }
            throw new IllegalArgumentException(
     * {@link PainlessClass#runtimeMethods} identical to {@link PainlessClass#methods} with the exception of generated
    }
            javaClassNamesToClasses.put(targetClass.getName().intern(), targetClass);
            javaTypeParameters.add(typeToJavaType(typeParameter));
                    || typeParameter == Float.class
            throw new IllegalArgumentException("imported method and class binding cannot have the same name [" + methodName + "]");
                        + "], ["
        }
                        allowlistClassBinding.methodName,
                    + methodName
                    );
                    + "[["
    }
        if (Modifier.isStatic(javaMethod.getModifiers()) == false) {
        Objects.requireNonNull(originalPainlessClassBuilder);
            );
                        + targetClass.getCanonicalName()
                        + "], ["
                "return type ["
                "return type ["
                    + "[["
            }
                    + targetCanonicalClassName
            throw new IllegalArgumentException(
                        + canonicalTypeNameParameters
                    painlessClassBuilder.getterMethodHandles.putIfAbsent(
                    + "], ["
                    + "cannot represent multiple java classes with the same name from different class loaders"
            if (existingPainlessField == null
import static org.opensearch.painless.WriterConstants.DEF_TO_B_FLOAT_IMPLICIT;
            javaTypeParameters.add(typeToJavaType(typeParameter));
                        + "], ["
                "imported method handle [["
                    null,
        }
                    + "but do not have equivalent methods "
                        origin = allowlistConstructor.origin;
            javaClassNamesToClasses,
                iae
        MethodType methodType = methodHandle.type();
            throw new IllegalArgumentException(
                    + "], "
        int methodTypeParametersSize = javaMethod.getParameterCount();
                );
                    + targetCanonicalClassName
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
            for (Allowlist allowlist : allowlists) {
                        allowlistClass.javaClassName,
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
                }
    }
        } else {
                && Character.isUpperCase(methodName.charAt(2))) {
            returnType,
                    + methodName
                    + "cannot represent multiple java classes with the same name from different class loaders"
                        + "], ["
        Objects.requireNonNull(targetClass);
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
        Class<?> clazz;
                    exception
                "type parameter ["
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
import org.objectweb.asm.Opcodes;
                bridgeClassAccess,
                    + "["
            throw new IllegalArgumentException(
                        + "] not found for class binding "
                && methodName.length() > 2
        int typeParametersSize = typeParameters.size();
                    + typesToCanonicalTypeNames(existingPainlessConstructor.typeParameters)
                    + canonicalTypeNameParameters
        MethodHandle methodHandle;
                throw new IllegalArgumentException(
                methodHandleSetter = MethodHandles.publicLookup().unreflectSetter(javaField);
                    + "for constructor [["
        addPainlessInstanceBinding(targetInstance, methodName, returnType, typeParameters);
                            allowlistField.fieldName,
        for (Class<?> typeParameter : typeParameters) {
                copyPainlessClassMembers(childClass, targetClass);
                "class ["
        Map<Class<?>, PainlessClass> classesToPainlessClasses = new HashMap<>(classesToPainlessClassBuilders.size());
                        + "with the same name and different type parameters"
        Objects.requireNonNull(typeParameter);
 * KIND, either express or implied.  See the License for the
        if (existingClass == null) {
            );
            );
                    + fieldName
        try {
        Objects.requireNonNull(methodName);
        String painlessMethodKey = buildPainlessMethodKey(methodName, typeParametersSize);
        String painlessConstructorKey = buildPainlessConstructorKey(typeParametersSize);
                    iae
                    + "] "
                    + returnCanonicalTypeName
                    + canonicalTypeNameParameters
        javaClassNamesToClasses = new HashMap<>();
        else if ("long".equals(javaClassName)) clazz = long.class;
                    nsme
                "reflection object not found for constructor "
            if (typeParameter == null) {
                        + methodName
        }
            }
        List<Class<?>> typeParameters,
        }
                );
                painlessClassBuilder.runtimeMethods.put(painlessMethodKey.intern(), bridgePainlessMethod);
                new org.objectweb.asm.commons.Method(painlessMethod.javaMethod.getName(), bridgeMethodType.toMethodDescriptorString()),
                    + "] "
        }
            );
                        || typeParameter == Float.class
        // Matcher m = new Matcher();
import java.util.HashSet;
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
                    + targetCanonicalClassName
                    + "], "
                        + "for class binding [["
import java.util.List;
            typeParameters.add(typeParameter);
                    + typeToCanonicalTypeName(returnType)
                    + "does not match the specified returned type ["
                        + "], "
            );
            }
                    + "]"
            typeParameters.add(typeParameter);
            Method javaMethod = painlessMethod.javaMethod;
                        + "with the same name and different type parameters"
                        + targetCanonicalClassName
        List<String> canonicalTypeNameParameters,
                        + "], "
        Object targetInstance,
        Objects.requireNonNull(clazz);
        String importedCanonicalClassName = javaClassName.substring(javaClassName.lastIndexOf('.') + 1).replace('$', '.');
                        + "]"
        String methodName,
                    + "["
        Objects.requireNonNull(methodName);
                    + "], ["
            throw new IllegalArgumentException(
            bridgeClassWriter.visitEnd();
        }
                    "cannot add fields with the same name but are not equivalent for fields "
                    );
            throw new IllegalArgumentException(
                    + methodName
            for (PainlessMethod painlessMethod : painlessClassBuilder.runtimeMethods.values()) {
                    + targetCanonicalClassName
            if (classesToPainlessClassBuilders.containsKey(childClass)) {
    public void addPainlessField(Class<?> targetClass, String fieldName, Class<?> typeParameter) {
                        + methodName
        Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
            painlessMethodKeysToPainlessInstanceBindings
        }
    private static final Map<PainlessMethod, PainlessMethod> painlessBridgeCache = new HashMap<>();
        }
                    + methodName
                        + canonicalTypeNameParameters
            throw new IllegalArgumentException(
        }
                    + "], "
                    && Character.isUpperCase(methodName.charAt(3))) {
                    + targetCanonicalClassName
                        + "for class binding [["
                    + "] must be static"
                        + "with augmented class ["
        PainlessMethod existingPainlessMethod = isStatic
    // of the values of javaClassNamesToClasses.
            if (importedClass == null) {
            }
            );
                    + methodName
            typeParametersSize = typeParameters.size();
            } else if (importedClass != clazz) {
            if (typeParameter == null) {
                "return type ["
        for (int typeParameterIndex = 0; typeParameterIndex < constructorTypeParametersSize; ++typeParameterIndex) {
                typeParameters.subList(0, numInjections).clear();
        String returnCanonicalTypeName,
            throw new IllegalArgumentException("class binding and instance binding cannot have the same name [" + methodName + "]");
                "invalid method name [" + methodName + "] for target class [" + targetCanonicalClassName + "]."
                "return type ["
                        + "], "
                    + targetCanonicalClassName
            targetClass,
                    + canonicalTypeNameParameters
            if (isStatic) {
                "method handle not found for constructor "
                    + "]"
        Objects.requireNonNull(targetJavaClassName);
            javaTypeParameters.add(typeToJavaType(typeParameter));
                        + "] "
                String painlessMethodKey = buildPainlessMethodKey(javaMethod.getName(), javaMethod.getParameterCount());
                    + typesToCanonicalTypeNames(typeParameters)
            }
                        + "[["
                    + "], ["
            targetClass = Class.forName(targetJavaClassName, true, classLoader);
                        + typesToCanonicalTypeNames(typeParameters)
                    bridgeClass,
                    + targetClass.getCanonicalName()
                        + "[["
                        allowlistClassBinding.canonicalTypeNameParameters,
        if (painlessMethodKeysToPainlessInstanceBindings.containsKey(painlessMethodKey)) {
                    + "] not found for method "
                        + typeToCanonicalTypeName(typeParameter)
            if (existingPainlessField == null) {
import org.opensearch.painless.spi.AllowlistClassBinding;
                        + methodName
                );
                        + targetCanonicalClassName
                    + "] "
                        + "] "
        Objects.requireNonNull(methodName);
                );
                    + typeToCanonicalTypeName(returnType)
                    + methodName
        if (painlessMethodKeysToPainlessClassBindings.containsKey(painlessMethodKey)) {
        if (targetClass.isInterface()) {
                        + targetCanonicalClassName
                    "type parameter ["
        List<String> canonicalTypeNameParameters,
                    + "] not found for method "
                        allowlistInstanceBinding.returnCanonicalTypeName,
            }
        Map<Class<?>, Object> annotations
            if (isValidType(typeParameter) == false) {
        }
        }
            );
        PainlessClassBinding newPainlessClassBinding = new PainlessClassBinding(
        if (returnType == null) {
                    Collections.emptyMap()
                throw new IllegalArgumentException(
        else if ("boolean".equals(javaClassName)) clazz = boolean.class;
            throw new IllegalArgumentException(
                        + "]"
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
                );
                    + typesToCanonicalTypeNames(typeParameters)
    }
import org.opensearch.painless.spi.AllowlistInstanceBinding;
                    + "], ["
        }
        }
                        .isAssignableFrom(newPainlessField.javaField.getDeclaringClass())) {
                    + "]"
            );
                        + "], "
                    + "] cannot be static"
        } else if (newImportedPainlessMethod.equals(existingImportedPainlessMethod) == false) {
                        + "]",
            javaTypeParameters.add(typeToJavaType(typeParameter));
                    + targetCanonicalClassName
        }
            bridgeConstructorWriter.returnValue();
            typeParameters.add(typeParameter);
            int bridgeClassAccess = Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_FINAL;
                    + methodName
                    + "], ["
                    + targetCanonicalClassName
        }
            CODESOURCE = new CodeSource(URI.create("file:" + BootstrapInfo.UNTRUSTED_CODEBASE).toURL(), (Certificate[]) null);
                    + "], ["
                    + "], "
                    try {
        if (painlessClassBuilder == null) {
                    + "] "
                    + "]"
                    cnfe
                    + typeToCanonicalTypeName(existingPainlessClassBinding.returnType)
                for (AllowlistClassBinding allowlistClassBinding : allowlist.allowlistClassBindings) {
                    + methodName
        Class<?> defineBridge(String name, byte[] bytes) {
    private void generateRuntimeMethods() {
        PainlessMethod existingImportedPainlessMethod = painlessMethodKeysToImportedPainlessMethods.get(painlessMethodKey);
        Objects.requireNonNull(typeParameters);
                    + typeToCanonicalTypeName(returnType)
 * ownership. Elasticsearch licenses this file to you under
            MethodHandle methodHandleSetter;
            throw new IllegalArgumentException(
 *
                );
                    "type parameter ["
            throw new IllegalArgumentException(
import static org.opensearch.painless.lookup.PainlessLookupUtility.typeToJavaType;
            } catch (IllegalAccessException iae) {
            ClassWriter bridgeClassWriter = new ClassWriter(bridgeClassFrames);
            }
                );
    public void addPainlessClass(Class<?> clazz, boolean importClassName) {
    public void addImportedPainlessMethod(
    private static final Map<PainlessMethod, PainlessMethod> painlessMethodCache = new HashMap<>();
                        + "for class binding [["
                        painlessLookupBuilder.addPainlessMethod(
        String targetCanonicalClassName = targetClass.getCanonicalName();
                        + "] not found "
        if (existingClass != null && existingClass != clazz) {
                        + "[["
    }
        Map<Class<?>, Object> annotations
            for (int typeParameterCount = 0; typeParameterCount < typeParameters.length; ++typeParameterCount) {
        for (Map.Entry<Class<?>, PainlessClassBuilder> painlessClassBuilderEntry : classesToPainlessClassBuilders.entrySet()) {
                    + typeToCanonicalTypeName(javaMethod.getReturnType())
        Objects.requireNonNull(targetClass);
import org.objectweb.asm.ClassWriter;
    }
                    + typesToCanonicalTypeNames(typeParameters)
            int bridgeClassFrames = ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;
                    + "for field [["
            );
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
import static org.opensearch.painless.lookup.PainlessLookupUtility.buildPainlessMethodKey;
    private final Map<String, Class<?>> canonicalClassNamesToClasses;
        if (existingTargetClass == null) {
                        + "]"
    ) {
        }
    // classes with imported canonical names but does not include classes from imported methods or class
                        || typeParameter == Character.class
                        javaMethods.add(javaMethod);
    /**
            throw new IllegalArgumentException(
            if (importClassName) {
import org.opensearch.painless.MethodWriter;
                    + "], ["
            }
                    + "], "
        if (painlessMethodKeysToPainlessClassBindings.containsKey(painlessMethodKey)) {
                BridgeLoader bridgeLoader = AccessController.doPrivileged(
            javaConstructor,
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {
            throw new IllegalArgumentException("cannot add reserved class [" + DEF_CLASS_NAME + "]");
                        + "for constructor [["
                    + "for class binding [["
    }
                    + typeToCanonicalTypeName(existingPainlessMethod.returnType)
            throw new IllegalArgumentException(
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize);
    public PainlessLookupBuilder() {
                    + targetCanonicalClassName
                    + "], ["
                        + typeToCanonicalTypeName(javaTypeParameter)
                    + "[["
                throw new IllegalArgumentException(
                bridgeTypeParameters.add(javaMethod.getDeclaringClass());
                    + "["
                );
            );
                            allowlistConstructor.canonicalTypeNameParameters,
                    + "], ["
                        + "not found for imported method [["
                "the values of canonical class names to classes " + "must have the same classes as the keys of classes to painless classes"
            throw new IllegalArgumentException(
                    + "["
                        + canonicalTypeNameParameter
import java.security.cert.Certificate;
        Class<?> returnType,
        }
            }
        addPainlessClass(clazz, importClassName);
            String painlessFieldKey = painlessFieldEntry.getKey();
                    + targetCanonicalClassName
                        + "]",
                "reflection object not found for field [[" + targetCanonicalClassName + "], [" + fieldName + "]",
                    + canonicalTypeNameParameters
        } catch (NoSuchFieldException nsme) {
            throw new IllegalArgumentException(
                && methodName.length() > 3
                Class<?> bridgeClass = bridgeLoader.defineBridge(bridgeClassName.replace('/', '.'), bridgeClassWriter.toByteArray());
            PainlessField newPainlessField = painlessFieldEntry.getValue();
                if (Modifier.isStatic(javaMethod.getModifiers()) == false) {
                );
                        + "] "
            String bridgeClassName = "org/opensearch/painless/Bridge$"
                else if (typeParameter == Long.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_LONG_IMPLICIT);
        }
        Method javaMethod;
        PainlessClassBuilder painlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);
                        || typeParameter == Long.class
                    + "]"
     * bridge methods. A generated bridge method is created for each allowlisted method that has at least one parameter
        String returnCanonicalTypeName,
        addPainlessMethod(targetClass, augmentedClass, methodName, returnType, typeParameters, annotations);
                    painlessMethod.returnType,
                        + "]"
        }
                + "$"
            throw new IllegalArgumentException("class binding [" + targetCanonicalClassName + "] must have exactly one method");
        }
        }
                    "type parameter ["
            try {
            }
        try {
            methodHandle,
        List<String> canonicalTypeNameParameters,
                    + "]"
 * You may obtain a copy of the License at
import org.objectweb.asm.commons.GeneratorAdapter;
                painlessClassBuilder.methods.put(painlessMethodKey.intern(), newPainlessMethod);
                        + typesToCanonicalTypeNames(typeParameters)
            PainlessClassBuilder painlessClassBuilder = new PainlessClassBuilder();
                "invalid imported method name [" + methodName + "] for target class [" + targetCanonicalClassName + "]."
                    + canonicalTypeNameParameters
                    + "]"
                        + "] not found for imported method "
            );
        if (targetClass == def.class) {
                        + typeToCanonicalTypeName(typeParameter)
        Objects.requireNonNull(canonicalTypeNameParameter);
            );
                    bridgeTypeParameters.add(typeParameter);
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize + augmentedParameterOffset);
                            + targetCanonicalClassName
            bridgeConstructorWriter.invokeConstructor(OBJECT_TYPE, bridgeConstructorType);
            }
                    }
        painlessMethodKeysToPainlessClassBindings = new HashMap<>();
    private final Map<String, PainlessInstanceBinding> painlessMethodKeysToPainlessInstanceBindings;
                        + "] "
            PainlessField newPainlessField = new PainlessField(javaField, typeParameter, methodHandleGetter, null);
                    + targetCanonicalClassName
        Map<Class<?>, Object> annotations
            painlessMethodKeysToImportedPainlessMethods.put(painlessMethodKey.intern(), newImportedPainlessMethod);
            }
            );
            throw new IllegalArgumentException(
 * Licensed to Elasticsearch under one or more contributor
 *
                            + methodName
        PainlessInstanceBinding existingPainlessInstanceBinding = painlessMethodKeysToPainlessInstanceBindings.get(painlessMethodKey);
import java.lang.reflect.Field;
        }
import java.lang.invoke.MethodHandle;
    private void cacheRuntimeHandles(PainlessClassBuilder painlessClassBuilder) {
            if (typeParametersSize == 0
                    "cannot add fields with the same name but are not equivalent for fields "
            } else if (newPainlessField.equals(existingPainlessField) == false) {
        BridgeLoader(ClassLoader parent) {
        PainlessClassBuilder originalPainlessClassBuilder = classesToPainlessClassBuilders.get(originalClass);
    private final Map<String, PainlessMethod> painlessMethodKeysToImportedPainlessMethods;
                "class ["
                    + "]"
        Class<?> existingTargetClass = javaClassNamesToClasses.get(targetClass.getName());
        if (javaMethod == null) {
                    + targetCanonicalClassName
                    "type parameter ["
        Class<?> existingTargetClass = javaClassNamesToClasses.get(targetClass.getName());
        try {
        }
            );
                for (AllowlistInstanceBinding allowlistInstanceBinding : allowlist.allowlistInstanceBindings) {
            );
        }
                        + "], "
        }
        Objects.requireNonNull(typeParameters);
                    + "], "
                    + "] not found for field "
            painlessMethodKeysToPainlessClassBindings.put(painlessMethodKey.intern(), newPainlessClassBinding);
                    + typesToCanonicalTypeNames(existingImportedPainlessMethod.typeParameters)
                        + "]"
                    + typeToCanonicalTypeName(returnType)
                    throw new IllegalArgumentException("class binding [" + targetCanonicalClassName + "] cannot have multiple methods");
    static {
                    + "["
                childClass = childClass.getSuperclass();
                    + targetCanonicalClassName
                    origin = allowlistInstanceBinding.origin;
            );
            throw new IllegalArgumentException("cannot add array type [" + canonicalClassName + "] as a class");
        }
            bridgeMethodWriter.invokeMethodCall(painlessMethod);
                nsme
                        + "for class binding [["
            if (javaClass.isInterface()) {
                    + "[["
                        allowlistStatic.painlessAnnotations
        }
    }
                    + typeToCanonicalTypeName(returnType)
                    + "], "
                    + targetCanonicalClassName
            javaClassNamesToClasses.put(targetClass.getName().intern(), targetClass);
                    + targetCanonicalClassName
        addImportedPainlessMethod(targetClass, methodName, returnType, typeParameters, annotations);
                        + canonicalTypeNameParameters
        }
                targetPainlessClassBuilder.methods.put(painlessMethodKey.intern(), newPainlessMethod);
 * SPDX-License-Identifier: Apache-2.0
            returnType,
                    + typesToCanonicalTypeNames(typeParameters)
        List<String> canonicalTypeNameParameters,
                        + "[["
        for (Map.Entry<String, PainlessMethod> painlessMethodEntry : originalPainlessClassBuilder.methods.entrySet()) {
                        + typeToCanonicalTypeName(augmentedClass)
        for (Map.Entry<String, PainlessField> painlessFieldEntry : originalPainlessClassBuilder.fields.entrySet()) {
            typeParameters,
        String targetJavaClassName,
                    + "], ["
                "target class ["
                    + "] "
        Class<?> targetClass;
    private static final Pattern FIELD_NAME_PATTERN = Pattern.compile("^[_a-zA-Z][_a-zA-Z0-9]*$");
                        + canonicalTypeNameParameter
            if (isValidType(javaTypeParameter) == false) {
                            allowlistMethod.augmentedCanonicalClassName,
                "type parameter ["
                    + "[["
                "class ["
            javaClassNamesToClasses.put(clazz.getName().intern(), clazz);
            );
                painlessClassBuilder.fields.put(painlessFieldKey.intern(), newPainlessField);
    public void addPainlessMethod(
                    + "["
            if (isValidType(typeParameter) == false) {
 *
                null,
                    + typeToCanonicalTypeName(javaMethod.getReturnType())
                    + typesToCanonicalTypeNames(typeParameters)
        Objects.requireNonNull(canonicalTypeNameParameters);
        PainlessClassBuilder painlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);
        Objects.requireNonNull(fieldName);
        }
                    + "], "
                        || typeParameter == Double.class) {
                    + "[["
            );
                "invalid method name [" + methodName + "] for instance binding [" + targetCanonicalClassName + "]."
            }
                    + fieldName
                    + "[["
        try {
    private final Map<String, PainlessClassBinding> painlessMethodKeysToPainlessClassBindings;
                    nsme
            );
    ) {
                bridgeClassWriter.visitMethod(
                newPainlessField = painlessFieldCache.computeIfAbsent(newPainlessField, key -> key);
            setFunctionalInterfaceMethod(painlessClassBuilderEntry.getKey(), painlessClassBuilderEntry.getValue());
                    iae
        Objects.requireNonNull(typeParameters);
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
                        Object.class.getMethod(javaMethod.getName(), javaMethod.getParameterTypes());
        Class<?> existingClass = javaClassNamesToClasses.get(clazz.getName());
                    + "] "
                    if (typeParameter == Byte.class
                throw new IllegalArgumentException(
                );
            painlessMethodKeysToPainlessClassBindings,
                for (AllowlistMethod allowlistStatic : allowlist.allowlistImportedMethods) {
                    + "], "
                        );
        Class<?> returnType,
                    && existingPainlessMethod.targetClass.isAssignableFrom(newPainlessMethod.targetClass)) {
        Map<Class<?>, Object> annotations
        if (painlessClassBuilder == null) {
                    + typesToCanonicalTypeNames(typeParameters)
        Objects.requireNonNull(returnCanonicalTypeName);
                    + targetCanonicalClassName
import org.opensearch.painless.spi.AllowlistClass;
            }
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
                        + methodName
                    "augmented class ["
                    + typesToCanonicalTypeNames(existingPainlessClassBinding.typeParameters)
import static org.opensearch.painless.lookup.PainlessLookupUtility.typeToCanonicalTypeName;
                    canonicalClassNamesToClasses.put(importedCanonicalClassName.intern(), clazz);
        for (Map.Entry<String, PainlessMethod> painlessMethodEntry : painlessClassBuilder.methods.entrySet()) {
                        + "], "
    public void addPainlessMethod(
            newImportedPainlessMethod = painlessMethodCache.computeIfAbsent(newImportedPainlessMethod, key -> key);
                "the values of java class names to classes " + "must be a superset of the values of canonical class names to classes"
            javaTypeParameters.add(targetClass);
            throw new IllegalArgumentException(
    private final Map<Class<?>, PainlessClassBuilder> classesToPainlessClassBuilders;
                    + targetCanonicalClassName
                        + methodName
                        + "[["
 * this file be licensed under the Apache-2.0 license or a
        }
                            + "["
        if (targetClass == null) {
                    + methodName
            throw new IllegalArgumentException(
        if (annotations.containsKey(InjectConstantAnnotation.class)) {
        if (javaClasses.containsAll(canonicalClasses) == false) {
            throw new IllegalArgumentException(
                    + "for field [["
                );
        String painlessFieldKey = buildPainlessFieldKey(fieldName);
                    }
                    + "[["
                "instance binding reflection object [["
        return type == def.class || classesToPainlessClassBuilders.containsKey(type);
        if (returnType == null) {
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {
                throw new IllegalArgumentException(
                            + typeToCanonicalTypeName(augmentedClass)
                        + "]",
            }
                    + "] not found "
                Method bridgeMethod = bridgeClass.getMethod(
    public static PainlessLookup buildFromAllowlists(List<Allowlist> allowlists) {
                        + typesToCanonicalTypeNames(typeParameters)
                    || typeParameter == Double.class) {
            );
                    + "[["
 * not use this file except in compliance with the License.
    public void addPainlessInstanceBinding(
        }
        if (FIELD_NAME_PATTERN.matcher(fieldName).matches() == false) {
                            + "], ["
            try {
        PainlessLookupBuilder painlessLookupBuilder = new PainlessLookupBuilder();
                        origin = allowlistMethod.origin;
        }
        }
        } else {
                        + canonicalTypeNameParameter
            }
                    + typesToCanonicalTypeNames(typeParameters)
                        + canonicalClassName
                        + "], ["
                throw new IllegalArgumentException(
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
    }
                    + typeToCanonicalTypeName(javaField.getType())
        addPainlessClassBinding(targetClass, methodName, returnType, typeParameters, annotations);
        Constructor<?>[] javaConstructors = targetClass.getConstructors();
            );
            throw new IllegalArgumentException(
                    + typeToCanonicalTypeName(returnType)
                    + targetClass.getCanonicalName()
                    + targetCanonicalClassName
        if (augmentedCanonicalClassName != null) {
            }
                    + "]",
        Class<?> targetClass = canonicalClassNamesToClasses.get(targetCanonicalClassName);
package org.opensearch.painless.lookup;
                );
        } catch (NoSuchMethodException nsme) {
            if (javaMethods.size() != 1 && targetClass.isAnnotationPresent(FunctionalInterface.class)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + typeToCanonicalTypeName(typeParameter)
                );
            methodType,
                    + "] not found",
            throw new IllegalArgumentException(
    // javaClassNamesToClasses is all the classes that need to be available to the custom classloader
                    + "], "
                    + "], "
    private void cacheRuntimeHandles() {
                    + targetCanonicalClassName
        if (returnType == null) {
                        + typesToCanonicalTypeNames(typeParameters)
                    "method handle not found for method "
                || existingPainlessField.javaField.getDeclaringClass() != newPainlessField.javaField.getDeclaringClass()
import java.lang.invoke.MethodType;
    // including classes used as part of imported methods and class bindings but not necessarily allowlisted
                java.lang.reflect.Method javaMethod = javaMethods.get(0);
                    + methodName
            throw new IllegalArgumentException(
 * the Apache License, Version 2.0 (the "License"); you may
        public Class<?> findClass(String name) throws ClassNotFoundException {
            PainlessField existingPainlessField = targetPainlessClassBuilder.fields.get(painlessFieldKey);
        Objects.requireNonNull(targetJavaClassName);
        if (returnType == null) {
                        + "], "
                    "type parameter ["
                    + "], "
                "getter method handle not found for field [[" + targetCanonicalClassName + "], [" + fieldName + "]]"
            try {
        } catch (ClassNotFoundException cnfe) {
        } catch (MalformedURLException mue) {
    public void addPainlessInstanceBinding(Object targetInstance, String methodName, Class<?> returnType, List<Class<?>> typeParameters) {
        Set<Class<?>> canonicalClasses = new HashSet<>(canonicalClassNamesToClasses.values());
                );
                        allowlist.classLoader,
        String methodName,
                    "internal error occurred attempting to generate a bridge method [" + bridgeClassName + "]",
     * {@link MethodHandle#asType(MethodType)}. As an example {@link MethodHandle#asType(MethodType)} legally casts
public final class PainlessLookupBuilder {
    private void setFunctionalInterfaceMethods() {
        List<Class<?>> typeParameters,
                    );
                        + "] and "
                        );
        int constructorTypeParametersSize = javaConstructor.getParameterCount();
                    + targetCanonicalClassName
    public void addPainlessClassBinding(
                    + canonicalClassName
                painlessClassBuilder.getterMethodHandles.putIfAbsent(
    public PainlessLookup build() {
                        + "], "
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
        try {
            throw new IllegalArgumentException(
        for (Constructor<?> eachJavaConstructor : javaConstructors) {
                    + "[["
                "target class ["
import java.util.Collections;
                    + "["
                    + typeToCanonicalTypeName(javaMethod.getReturnType())
                "class ["
                    + canonicalTypeNameParameters
            }
                    + targetCanonicalClassName
            );
                        + "] "
        for (Class<?> javaClass : classesToPainlessClassBuilders.keySet()) {
            returnType,
                "cannot add methods with the same name and arity but are not equivalent for methods "
import org.opensearch.painless.spi.Allowlist;
                    + "does not match the specified returned type ["
        } catch (NoSuchMethodException nsme) {
                "return type ["
                    copyPainlessClassMembers(childClass, parentClass);
                            allowlistMethod.returnCanonicalTypeName,
        Objects.requireNonNull(canonicalTypeNameParameters);
                        + "[["
        List<String> canonicalTypeNameParameters
                        + "]"
                    + canonicalTypeNameParameter
                        + typeToCanonicalTypeName(javaTypeParameter)
        }
                );
        if (isValidType(returnType) == false) {
                "target class ["
                "imported method reflection object [["
                    + "], ["
                        + "] not found "
        }
                    + targetCanonicalClassName
                    + methodName
        } else if (existingTargetClass != targetClass) {
                    + "does not match the specified type parameter ["
                );
            painlessMethodKeysToPainlessInstanceBindings.put(painlessMethodKey.intern(), newPainlessInstanceBinding);
                        + "], "
            Class<?> typeParameter = typeParameters.get(typeParameterIndex);
            throw new IllegalArgumentException("instance binding and class binding cannot have the same name [" + methodName + "]");
        }
                    + "], ["
            cacheRuntimeHandles(painlessClassBuilder);
        } else if (newPainlessInstanceBinding.equals(existingPainlessInstanceBinding) == false) {
        }
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {
                    + typeToCanonicalTypeName(returnType)
                        + typeToCanonicalTypeName(typeParameter)
        setFunctionalInterfaceMethods();
        if (clazz == def.class) {
            } catch (NoSuchMethodException nsme) {
                        + "], "
                "target class ["
                    + "], ["
                    + "["
        String augmentedCanonicalClassName,
    private Class<?> canonicalTypeNameToType(String canonicalTypeName) {
            if (numInjections > 0) {
            copyPainlessInterfaceMembers(childClass, targetClass);
            }
        }
                );
                    for (AllowlistField allowlistField : allowlistClass.allowlistFields) {
                WriterConstants.CLASS_VERSION,
            annotations
    }
        PainlessClassBinding existingPainlessClassBinding = painlessMethodKeysToPainlessClassBindings.get(painlessMethodKey);
                        || typeParameter == Short.class
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);
        String returnCanonicalTypeName,
        if (CLASS_NAME_PATTERN.matcher(canonicalClassName).matches() == false) {
            return Def.class.getName().equals(name) ? Def.class : super.findClass(name);
                    + "], "
                    origin = allowlistStatic.origin;
import org.opensearch.secure_sm.AccessController;
                targetPainlessClassBuilder.fields.put(painlessFieldKey.intern(), newPainlessField);
                    + typeToCanonicalTypeName(returnType)
                        + typeToCanonicalTypeName(typeParameter)
                    + targetCanonicalClassName
        }
                    + "], "
                    + targetCanonicalClassName
            PainlessField existingPainlessField = painlessClassBuilder.fields.get(painlessFieldKey);
        }
            }
        }
                            bridgePainlessMethod.methodHandle
            }
            newPainlessMethod = painlessMethodCache.computeIfAbsent(newPainlessMethod, key -> key);
                    + methodName
    ) {
                "imported method [["
                        allowlistInstanceBinding.methodName,
                        + targetCanonicalClassName
        if (javaField.getType() != typeToJavaType(typeParameter)) {
        Objects.requireNonNull(targetPainlessClassBuilder);
                + javaMethod.getDeclaringClass().getSimpleName()
                    + "] not found "
 * this work for additional information regarding copyright
                            + typesToCanonicalTypeNames(typeParameters)
                    + "for instance binding [["
                    + "], "
import org.opensearch.painless.spi.annotation.InjectConstantAnnotation;
        PainlessClassBuilder painlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);
                        + "]"
                    + "]"
                }
                    + "], "
            );
import java.lang.reflect.Modifier;
                    + "], "
                    + "[["
/*
        String methodName,
                else if (typeParameter == Double.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_DOUBLE_IMPLICIT);
        if (Modifier.isStatic(javaField.getModifiers())) {
                    }
                    + "[["
                        throw new IllegalArgumentException("inconsistent no_import parameter found for class [" + canonicalClassName + "]");
        Objects.requireNonNull(returnCanonicalTypeName);
            for (Class<?> typeParameter : javaMethod.getParameterTypes()) {
                        + "], "
                else if (typeParameter == Character.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_CHARACTER_IMPLICIT);
/*
        Objects.requireNonNull(classLoader);
                    "reflection object not found for method [["
                    + "] not found for class binding "
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
                    + methodName
        if (javaClasses.containsAll(painlessClasses) == false) {
        Objects.requireNonNull(targetInstance);
            }
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);
        }
                        + "] and ["
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {
            typeParameters.add(typeParameter);
            javaConstructor,
                        allowlistClassBinding.targetJavaClassName,
                        allowlistStatic.canonicalTypeNameParameters,
        } else if (existingTargetClass != targetClass) {
                throw new IllegalArgumentException("inconsistent no_import parameter found for class [" + canonicalClassName + "]");
        }
            } else if (typeParametersSize == 0
            );
            throw new IllegalArgumentException(
        }
        addPainlessField(targetClass, fieldName, typeParameter);
            );
                    + "], ["
    private boolean isValidType(Class<?> type) {
    }
            targetClass = Class.forName(targetJavaClassName, true, classLoader);
        }
            methodHandle = MethodHandles.publicLookup().in(targetClass).unreflect(javaMethod);
                    + "], ["
                    + targetCanonicalClassName
        }
                        + typeToCanonicalTypeName(typeParameter)
        if (isValidType(returnType) == false) {
                    + methodName
                    && methodName.length() > 3
                    + typeToCanonicalTypeName(typeParameter)
                    + methodName
        Objects.requireNonNull(typeParameters);
                        + "[["
            methodHandle,
                    + methodName
        }
                    + "[["
                        + "] "
                        + "] and "
            try {
    private void setFunctionalInterfaceMethod(Class<?> targetClass, PainlessClassBuilder painlessClassBuilder) {
            int numInjections = ((InjectConstantAnnotation) annotations.get(InjectConstantAnnotation.class)).injects.size();
                        + targetCanonicalClassName
            throw new IllegalArgumentException("cannot add imported method from reserved class [" + DEF_CLASS_NAME + "]");
        try {
                        + targetCanonicalClassName
import static org.opensearch.painless.WriterConstants.DEF_TO_B_INTEGER_IMPLICIT;
                    + "]"
                        + typesToCanonicalTypeNames(typeParameters)
                    String targetCanonicalClassName = allowlistClass.javaClassName.replace('$', '.');
                throw new IllegalArgumentException(
        ClassLoader classLoader,
                    + "], ["
import java.lang.reflect.Method;
        }
                    + "] not found for imported method "
            );
        if (painlessMethodKeysToImportedPainlessMethods.containsKey(painlessMethodKey)) {
                }
                    + methodName
            canonicalClassNamesToClasses,
            );
            String painlessMethodKey = painlessMethodEntry.getKey();
        Objects.requireNonNull(returnCanonicalTypeName);
            throw new IllegalArgumentException("cannot add constructor to reserved class [" + DEF_CLASS_NAME + "]");
                        + "], ["
                    + "], "
            }
                        + "] "
        );
                    + "[["
        Objects.requireNonNull(targetCanonicalClassName);
                "invalid method name [" + methodName + "] for class binding [" + targetCanonicalClassName + "]."
                        origin = allowlistField.origin;
                    + "["
                    "type parameter ["
                        + "] not found "
                    + typesToCanonicalTypeNames(typeParameters)
        String painlessMethodKey = buildPainlessMethodKey(painlessMethod.javaMethod.getName(), painlessMethod.typeParameters.size());
    private void copyPainlessClassMembers() {
    }
            canonicalClassNamesToClasses.put(canonicalClassName.intern(), clazz);
import org.opensearch.painless.spi.AllowlistMethod;
                    + targetCanonicalClassName
                        + "]",
            throw new IllegalArgumentException(
            throw new IllegalArgumentException(
                    + "], "
        for (PainlessClassBuilder painlessClassBuilder : classesToPainlessClassBuilders.values()) {
                "return type ["
            for (java.lang.reflect.Method javaMethod : targetClass.getMethods()) {
            try {
                throw new IllegalArgumentException(
            throw new IllegalArgumentException(
                    "imported class ["
        Class<?> augmentedClass = null;
            org.objectweb.asm.commons.Method bridgeConstructorType = new org.objectweb.asm.commons.Method(
                    + targetCanonicalClassName
                        + "], "
        Objects.requireNonNull(canonicalTypeNameParameters);
                    + "], "
        }
            }
            if (Modifier.isFinal(javaField.getModifiers()) == false) {
        Objects.requireNonNull(methodName);
                }
            GeneratorAdapter bridgeConstructorWriter = new GeneratorAdapter(
    private void copyPainlessClassMembers(Class<?> originalClass, Class<?> targetClass) {
            );
                        + typesToCanonicalTypeNames(typeParameters)
                        painlessLookupBuilder.addPainlessField(
        Class<?> existingTargetClass = javaClassNamesToClasses.get(targetClass.getName());
                    + "] and "
                        + "] "
        if (targetClass == def.class) {
        copyPainlessClassMembers();
        }
                    + returnCanonicalTypeName
        if (augmentedClass != null) {
            );
    ) {
                        + "]"
 * under the License.
                    + "] not found for method "
        } catch (Exception exception) {
                        allowlistStatic.returnCanonicalTypeName,
            return defineClass(name, bytes, 0, bytes.length, CODESOURCE);
                        + methodName
                    + "], "
        Constructor<?> javaConstructor;
                    + targetCanonicalClassName
                        + typeToCanonicalTypeName(importedClass)
                    + "] cannot be static"
            );
                    + "] not found for class binding "
                    + typesToCanonicalTypeNames(typeParameters)
        int typeParametersSize = typeParameters.size();
     * {@link Map}. The {@link PainlessClass#runtimeMethods} {@link Map} is used exclusively to look up methods at
                    && methodName.startsWith("set")
                        + "does not match the specified type parameter ["
        }
        if (painlessClassBuilder == null) {
                        + targetCanonicalClassName
            if (typeParameter == null) {
                    + methodName
        PainlessMethod newImportedPainlessMethod = new PainlessMethod(
                MethodType.methodType(void.class).toMethodDescriptorString()
        }
                    + "] not found for field "
                        + canonicalTypeNameParameters
            throw new IllegalArgumentException(
        }
                            + "] must be static"
                    + "] not found for imported method "
                    + "] not found for method "
        Objects.requireNonNull(javaClassName);
                    + "] not found"
        }
        ClassLoader classLoader,
            typeParameters,
            newPainlessClassBinding = painlessClassBindingCache.computeIfAbsent(newPainlessClassBinding, key -> key);
        if (bridgePainlessMethod == null) {
            throw new IllegalArgumentException(
                    + methodName
import org.opensearch.painless.spi.AllowlistConstructor;
                "return type ["
        if (isValidType(typeParameter) == false) {
                    + typesToCanonicalTypeNames(existingPainlessInstanceBinding.typeParameters)
                    for (AllowlistMethod allowlistMethod : allowlistClass.allowlistMethods) {
                        + "]"
            classesToPainlessClassBuilders.put(clazz, painlessClassBuilder);
                        + typeToCanonicalTypeName(targetClass)
                        + "]"
            }
                "target class ["
                "<init>",
            targetClass,
            throw new IllegalArgumentException(
                for (Class<?> typeParameter : painlessMethod.typeParameters) {
            );
                        + "], "
                nsme
                "return type ["
                        + "] not found "
        }
        PainlessClassBuilder existingPainlessClassBuilder = classesToPainlessClassBuilders.get(clazz);
        Objects.requireNonNull(targetCanonicalClassName);
        }
    // bindings unless also allowlisted separately. The values of canonicalClassNamesToClasses are a subset
                    );
        } catch (NoSuchMethodException nsme) {
            throw new IllegalArgumentException(
        } else if (existingClass != clazz) {
                    + "["
                        + "], "
                        + "]"
        }
                    "setter method handle not found for field [[" + targetCanonicalClassName + "], [" + fieldName + "]]"
            );
        Objects.requireNonNull(canonicalTypeNameParameters);
        PainlessClassBuilder targetPainlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);
                null,
                    + "for field [["
                + javaMethod.getName();
    private void copyPainlessInterfaceMembers(Class<?> parentClass, Class<?> targetClass) {
            typeParameters
    }
        Objects.requireNonNull(classLoader);
        String painlessMethodKey = buildPainlessMethodKey(methodName, constructorTypeParametersSize + methodTypeParametersSize);
    private static final Pattern METHOD_NAME_PATTERN = Pattern.compile("^[_a-zA-Z][_a-zA-Z0-9]*$");
                        + canonicalTypeNameParameter
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
                        generateBridgeMethod(painlessClassBuilder, painlessMethod);
        if (targetClass == def.class) {
            throw new IllegalArgumentException(
            }
        PainlessConstructor existingPainlessConstructor = painlessClassBuilder.constructors.get(painlessConstructorKey);
                    origin = allowlistClassBinding.origin;
            if (isStatic == false) {
                    + "] not found",
                        + "for class binding [["
        Objects.requireNonNull(targetClass);
                    + typesToCanonicalTypeNames(typeParameters)
                augmentedClass = Class.forName(augmentedCanonicalClassName, true, classLoader);
                    }
        }
                        + methodName
                            allowlistField.canonicalTypeNameParameter
            Class<?> javaTypeParameter = javaConstructor.getParameterTypes()[typeParameterIndex];
            throw new IllegalArgumentException(
                        + "] not found "
                    + "]"
        generateRuntimeMethods();
        }
            Class<?> typeParameter = typeParameters.get(constructorTypeParametersSize + typeParameterIndex);
            );
        Objects.requireNonNull(returnType);
            try {
                    + targetCanonicalClassName
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
        if (targetClass == def.class) {
                throw new IllegalArgumentException(
        // injections alter the type parameters required for the user to call this method, since some are injected by compiler
            );
                        + targetClass.getCanonicalName()
            try {
        Objects.requireNonNull(fieldName);
            throw new IllegalArgumentException("invalid class name [" + canonicalClassName + "]");
            javaMethod = targetClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));
        try {
                            + "], "
                        + targetCanonicalClassName
                    }
                        + "], "
            );
            copyPainlessInterfaceMembers(parentClass, parentClass);
                        allowlist.classLoader,
    }
            } else if (newPainlessField.equals(existingPainlessField) == false) {
                if (javaMethod != null) {
        }
        Set<Class<?>> painlessClasses = classesToPainlessClasses.keySet();
        try {
                        allowlistInstanceBinding.targetInstance,
                        + "not found for instance binding [["
        }
            PainlessMethod existingPainlessMethod = targetPainlessClassBuilder.methods.get(painlessMethodKey);
        }
                if (javaMethod.isDefault() == false && Modifier.isStatic(javaMethod.getModifiers()) == false) {
        int typeParametersSize = typeParameters.size();
 * compatible open source license.
                        allowlistStatic.augmentedCanonicalClassName,
                        + "], ["
        String methodName,
                    + methodName
import static org.opensearch.painless.lookup.PainlessLookupUtility.buildPainlessFieldKey;
            );
            int typeParametersSize = painlessMethod.typeParameters.size();
        } catch (ClassNotFoundException cnfe) {
import java.util.Map;
                javaConstructor = eachJavaConstructor;
        if (targetClass == null) {
            throw new IllegalArgumentException(
                    + targetClass.getCanonicalName()
        );
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize);
        Set<Class<?>> javaClasses = new HashSet<>(javaClassNamesToClasses.values());
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
                    + canonicalClassName
 * software distributed under the License is distributed on an
                    bridgeMethod,
            newPainlessInstanceBinding = painlessInstanceBindingCache.computeIfAbsent(newPainlessInstanceBinding, key -> key);
        if (existingPainlessConstructor == null) {
                    "reflection object not found for method "
        }
    // canonicalClassNamesToClasses is all the allowlisted classes available in a Painless script including
                        bridgePainlessMethod.methodHandle
                        + "with augmented class ["
        for (Class<?> typeParameter : typeParameters) {
        }
                methodHandle = MethodHandles.publicLookup().in(augmentedClass).unreflect(javaMethod);
        if (targetClass == def.class) {
                    if (existingPainlessClassBuilder != null) {
    public void addPainlessClass(ClassLoader classLoader, String javaClassName, boolean importClassName) {
        Objects.requireNonNull(returnType);
                bridgeConstructorType,
            bridgeMethodWriter.returnValue();
        if (isValidType(returnType) == false) {
                    + targetCanonicalClassName
                );
                "cannot add imported methods with the same name and arity "
                    + typesToCanonicalTypeNames(typeParameters)
import org.opensearch.painless.spi.annotation.NoImportAnnotation;
            throw new IllegalArgumentException(
            );
                        + targetCanonicalClassName
                throw new IllegalArgumentException(
                        + "does not match the specified type parameter ["
            bridgeMethodWriter.visitCode();
import org.opensearch.painless.Def;
                    + "], ["
                        + "], ["
                );
                    + typesToCanonicalTypeNames(typeParameters)
                painlessClassBuilder.staticFields.put(painlessFieldKey.intern(), newPainlessField);
        PainlessConstructor newPainlessConstructor = new PainlessConstructor(
                OBJECT_TYPE.getInternalName(),
                    throw new IllegalArgumentException(
                        + "], ["
        String returnCanonicalTypeName,
                        allowlistClassBinding.returnCanonicalTypeName,
            throw new IllegalArgumentException("cannot add instance binding as reserved class [" + DEF_CLASS_NAME + "]");
                    + "] not found for imported method "
                "class binding [["
        }
                        allowlistClassBinding.painlessAnnotations
        for (Class<?> typeParameter : typeParameters) {
        }
                    + "]"
        if (Modifier.isStatic(javaMethod.getModifiers())) {
            javaMethod,
                    + "] "
                throw new IllegalArgumentException(
        String origin = "internal error";
 */
                    + "], "
    }
            painlessClassBuilder.constructors.put(painlessConstructorKey.intern(), newPainlessConstructor);
        for (PainlessClassBuilder painlessClassBuilder : classesToPainlessClassBuilders.values()) {
        }
                    + "] not found",
                    + "but do not have equivalent methods "
import org.opensearch.painless.WriterConstants;
        }
        } else {
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BYTE_IMPLICIT;
                    + "but do not have equivalent methods "
            bridgeMethodWriter.endMethod();
            throw new IllegalArgumentException("class [" + targetJavaClassName + "] not found", cnfe);
        }
                        + "], "
                    "type parameter ["
            typeParameters.add(typeParameter);
                "the values of java class names to classes " + "must be a superset of the keys of classes to painless classes"
        Objects.requireNonNull(targetClass);
                    + "["
                    + "for constructor [["
        if (existingImportedPainlessMethod == null) {
            } catch (ClassNotFoundException cnfe) {
                            + "] with augmented class "
        if (existingTargetClass == null) {
                    + "]"
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize);
                    + "], ["
            );
                    + fieldName
        } catch (IllegalAccessException iae) {
                        + "], ["
import static org.opensearch.painless.WriterConstants.DEF_TO_B_LONG_IMPLICIT;
                    () -> new BridgeLoader(javaMethod.getDeclaringClass().getClassLoader())
                        + "not found for method [["
                        + "]"
                        "method [["
                        + "] not found "
                    + "[["
                "class ["
                    + "[["
        Method javaMethod;
                    || typeParameter == Long.class
    }
        cacheRuntimeHandles();
                    + targetCanonicalClassName
        }
                throw new IllegalArgumentException(
                    + "]"
                "return type ["
        Class<?> targetClass = canonicalClassNamesToClasses.get(targetCanonicalClassName);
import java.util.Set;
            throw new IllegalArgumentException(
                    + returnCanonicalTypeName
        for (Map.Entry<Class<?>, PainlessClassBuilder> painlessClassBuilderEntry : classesToPainlessClassBuilders.entrySet()) {
            ? painlessClassBuilder.staticMethods.get(painlessMethodKey)
        for (Class<?> typeParameter : typeParameters) {
                    + "] "
 * GitHub history for details.
                    + targetClass.getCanonicalName()
        String targetCanonicalClassName,
                    + "]]"
                }
    }
            methodType,
                    + "]",
        if (canonicalClassName.equals(importedCanonicalClassName)) {
                    + canonicalTypeNameParameter
                "instance binding [["
        Map<Class<?>, Object> annotations
            );
                );
                            targetCanonicalClassName,
            );
                    + "["
            methodHandleGetter = MethodHandles.publicLookup().unreflectGetter(javaField);
                javaMethod = augmentedClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));
            : painlessClassBuilder.methods.get(painlessMethodKey);
                    }
        try {
                javaMethod = eachJavaMethod;
                    bridgeMethodType,
                        + "is illegally marked as a FunctionalInterface with java methods "
                        + typeToCanonicalTypeName(typeParameter)
     * run-time resulting from calls with a def type value target.
            throw new IllegalArgumentException("class [" + targetJavaClassName + "] not found", cnfe);
                        + typeToCanonicalTypeName(typeParameter)
            throw new IllegalArgumentException("class binding [" + targetCanonicalClassName + "] must have exactly one constructor");
                        + typesToCanonicalTypeNames(typeParameters)
                    for (AllowlistConstructor allowlistConstructor : allowlistClass.allowlistConstructors) {
        }
                        + "], ["
        Objects.requireNonNull(returnCanonicalTypeName);
            bridgeConstructorWriter.endMethod();
                    + "for method [["
        MethodHandle methodHandleGetter;
        for (Class<?> parentClass : classesToPainlessClassBuilders.keySet()) {
                } else {
import static org.opensearch.painless.WriterConstants.OBJECT_TYPE;
                        + "], ["
     * from {@link Integer} to long but not from int to {@link Long}. Generated bridge methods cover the latter case.
                    + "]"
        Class<?> augmentedClass,
                && methodName.startsWith("get")
                    + targetCanonicalClassName
                    + typesToCanonicalTypeNames(typeParameters)
                        + existingPainlessField.javaField.getName()
                    "type parameter ["
            }
            );
import static org.opensearch.painless.lookup.PainlessLookupUtility.buildPainlessConstructorKey;
            javaMethod = targetClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));
                Opcodes.ASM5,
        );
                    + "], "
        Class<?> targetClass,
                painlessBridgeCache.put(painlessMethod, bridgePainlessMethod);
                    + "]]"
                    + "], ["
                bridgePainlessMethod = new PainlessMethod(
                    + "] "
                throw new IllegalStateException(
            if (javaTypeParameter != typeToJavaType(typeParameter)) {
        try {
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
        Method[] javaMethods = targetClass.getMethods();
        }
        return PainlessLookupUtility.canonicalTypeNameToType(canonicalTypeName, canonicalClassNamesToClasses);
            }
                        + typesToCanonicalTypeNames(typeParameters)
import java.lang.reflect.Constructor;
                throw new IllegalArgumentException(
                    + targetClass.getCanonicalName()
            }
        ClassLoader classLoader,
                        + "] not found for method "
        }
                    bridgeHandle,
                    origin = allowlistClass.origin;
    }
                    }
            }
                    + "], ["
                throw new IllegalArgumentException("class [" + javaClassName + "] not found", cnfe);
    ) {
                            allowlistConstructor.painlessAnnotations
        if (painlessMethodKeysToImportedPainlessMethods.containsKey(painlessMethodKey)) {
            } else if (importClassName == false) {
                    painlessLookupBuilder.addPainlessInstanceBinding(
                    + "], "
            painlessClassBuilder.runtimeMethods.putAll(painlessClassBuilder.methods);
                    + typeToCanonicalTypeName(returnType)
        for (PainlessField painlessField : painlessClassBuilder.fields.values()) {
                );
        String targetCanonicalClassName,
            PainlessField newPainlessField = new PainlessField(javaField, typeParameter, methodHandleGetter, methodHandleSetter);
            } catch (ClassNotFoundException cnfe) {
                        + targetCanonicalClassName
                        + typeToCanonicalTypeName(typeParameter)
        try {
import java.net.MalformedURLException;
                    } catch (ReflectiveOperationException roe) {
        }
                throw new IllegalArgumentException(
                null
                        + typeToCanonicalTypeName(typeParameter)
        }
                        + typeToCanonicalTypeName(existingPainlessField.typeParameter)
 */
            throw new IllegalArgumentException(
                    + methodName
        return painlessLookupBuilder.build();
                    + fieldName
        if (painlessMethodKeysToPainlessInstanceBindings.containsKey(painlessMethodKey)) {
    }
                            Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4),
        if (isValidType(returnType) == false) {
        } else if (existingTargetClass != targetClass) {
            }
                    + "], "
                "cannot add instances bindings with the same name and arity "
            }
        int typeParametersSize = typeParameters.size();
    }
            if (isValidType(typeParameter) == false) {
                    + "], "
                    "type parameter ["
                throw new IllegalArgumentException(
import static org.opensearch.painless.WriterConstants.DEF_TO_B_CHARACTER_IMPLICIT;
            painlessClassBuilder.getterMethodHandles.put(painlessField.javaField.getName().intern(), painlessField.getterMethodHandle);
                    + typeToCanonicalTypeName(typeParameter)
                            allowlist.classLoader,
        for (int typeParameterIndex = 0; typeParameterIndex < methodTypeParametersSize; ++typeParameterIndex) {
            throw new IllegalArgumentException(
    // canonicalClassNamesToClasses.
            returnType,
        if (targetClass == null) {
            } catch (Exception exception) {
                        + "[["
    ) {
                    Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4),
import java.util.HashMap;
                    + "["
import org.opensearch.bootstrap.BootstrapInfo;
            throw new IllegalArgumentException(
    // individually. The values of javaClassNamesToClasses are a superset of the values of
                        painlessLookupBuilder.addPainlessConstructor(
        Objects.requireNonNull(targetCanonicalClassName);
                copyPainlessInterfaceMembers(childClass, parentClass);
            );
            }
        Objects.requireNonNull(methodName);
                "invalid field name [" + fieldName + "] for target class [" + targetCanonicalClassName + "]."
        }
            MethodType bridgeMethodType = MethodType.methodType(painlessMethod.returnType, bridgeTypeParameters);
            bridgeClassWriter.visit(
import java.security.SecureClassLoader;
            MethodWriter bridgeMethodWriter = new MethodWriter(
        }
            }
                    + typesToCanonicalTypeNames(typeParameters)
                    + "[["
        );
        String methodName,
                    + "]"
                    "type parameter ["
    public void addPainlessConstructor(
        }
 * license agreements. See the NOTICE file distributed with
                    + "], "
                nsme
                        + typesToCanonicalTypeNames(typeParameters)
        String canonicalClassName = typeToCanonicalTypeName(clazz);
        if ("void".equals(javaClassName)) clazz = void.class;
            PainlessMethod bridgePainlessMethod = painlessClassBuilder.runtimeMethods.get(methodKey);
                    + "cannot represent multiple java classes with the same name from different class loaders"
        }
        Method javaMethod;
                copyPainlessClassMembers(Object.class, javaClass);
                        + typeToCanonicalTypeName(augmentedClass)
        }
                        + "], "
     */
        } else if (newPainlessConstructor.equals(existingPainlessConstructor) == false) {
            if (typeParameter == null) {
    }
                        + targetCanonicalClassName
                    + "] "
        existingClass = canonicalClassNamesToClasses.get(canonicalClassName);
                    + "], "
            Class<?> childClass = parentClass.getSuperclass();
                    + "]"
                if (typeParameter == Byte.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BYTE_IMPLICIT);
                    + "], ["
                        + "classes ["
                    + targetCanonicalClassName
                        + typesToCanonicalTypeNames(typeParameters)
        else if ("char".equals(javaClassName)) clazz = char.class;
                        + "]"
                        + "], "
                    + "], "
                    painlessLookupBuilder.addImportedPainlessMethod(
                painlessClassBuilder.functionalInterfaceMethod = painlessClassBuilder.methods.get(painlessMethodKey);
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);
                }
        }
        if (existingPainlessMethod == null) {
    private static final Map<PainlessField, PainlessField> painlessFieldCache = new HashMap<>();
        }
            painlessMethodKeysToImportedPainlessMethods,
        } else if (newPainlessClassBinding.equals(existingPainlessClassBinding) == false) {
            }
                throw new IllegalArgumentException(
            }
            if (javaTypeParameter != typeToJavaType(typeParameter)) {
        Class<?> returnType,
                    + typesToCanonicalTypeNames(typeParameters)
                    + returnCanonicalTypeName
                    );
                        + "[["
                    throw new IllegalArgumentException(
                "return type ["
                bridgeMethodWriter.loadArg(typeParameterCount + bridgeTypeParameterOffset);
            targetInstance,
                nsme
                    + "], "
                        + canonicalTypeNameParameters
                    + "]"
 * Modifications Copyright OpenSearch Contributors. See
                        + targetCanonicalClassName
            methodType,
            classesToPainlessClasses.put(painlessClassBuilderEntry.getKey(), painlessClassBuilderEntry.getValue().build());
            String methodKey = painlessMethodEntry.getKey();
                );
        if (targetClass == null) {
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
        }
            throw new IllegalArgumentException(
                    painlessMethod.javaMethod.getName(),
                throw new IllegalArgumentException("static field [[" + targetCanonicalClassName + "], [" + fieldName + "]] must be final");
                        + targetClass.getCanonicalName()
                    + "], ["
                        + methodName
                    + "], "
                    + "[["
                throw new IllegalArgumentException(
        else if ("int".equals(javaClassName)) clazz = int.class;
                for (AllowlistClass allowlistClass : allowlist.allowlistClasses) {
                    + "], ["
        } catch (IllegalAccessException iae) {
            throw new IllegalArgumentException(
                Class<?> typeParameter = typeParameters[typeParameterCount];
                    + typeToCanonicalTypeName(returnType)
                        + augmentedCanonicalClassName
    private static final Map<PainlessConstructor, PainlessConstructor> painlessConstructorCache = new HashMap<>();
                "return type ["
            super(parent);
                if (importClassName) {
        @Override
                    + typesToCanonicalTypeNames(typeParameters)
        }
                        + "["
                    + targetCanonicalClassName
                    + typesToCanonicalTypeNames(typeParameters)
                }
        }
                || existingPainlessMethod.targetClass != newPainlessMethod.targetClass
                    + targetCanonicalClassName
        }
                    + methodName
            throw new RuntimeException(mue);
                javaMethod = targetClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));
            }
                            allowlistMethod.canonicalTypeNameParameters,
            bridgeConstructorWriter.visitCode();
                    null
        Class<?> targetClass;
            }
        }
                        + typesToCanonicalTypeNames(typeParameters)
                    + typeToCanonicalTypeName(returnType)
            javaMethod,
                        allowlist.classLoader,
                        + "], ["
 * Unless required by applicable law or agreed to in writing,
                        + targetCanonicalClassName
                }
                            allowlistMethod.methodName,
            throw new IllegalArgumentException("cannot add class binding as reserved class [" + DEF_CLASS_NAME + "]");
            }
            if (existingPainlessField == null) {
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {
        Objects.requireNonNull(methodName);
                    + "], "
                        + "]"
                        + "[["
                );
        for (Class<?> childClass : parentClass.getInterfaces()) {
    private static final CodeSource CODESOURCE;
    }
                    + "], "
            throw new IllegalArgumentException("cannot add method to reserved class [" + DEF_CLASS_NAME + "]");
            throw new IllegalArgumentException(
                "type parameter ["
                        + "], "
            );
                    + "["
        }
                        "class binding [" + targetCanonicalClassName + "] cannot have multiple constructors"
            }
    }
import java.util.Objects;
                            allowlistMethod.painlessAnnotations
 * specific language governing permissions and limitations
        }
                    );
        PainlessMethod bridgePainlessMethod = painlessBridgeCache.get(painlessMethod);
            );
                    + typesToCanonicalTypeNames(typeParameters)
                    + typeToCanonicalTypeName(existingPainlessInstanceBinding.returnType)
            typeParameters,
                    + "]"
            } else if (javaMethods.size() == 1) {
        if (targetClass == def.class) {
                methodHandle = MethodHandles.publicLookup().in(targetClass).unreflect(javaMethod);
                        allowlistStatic.methodName,
                    + "], ["
            );
        } else {
                        + "] cannot represent multiple "
        }
                "return type ["
                    + methodName
        else if ("double".equals(javaClassName)) clazz = double.class;
                else if (typeParameter == Integer.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_INTEGER_IMPLICIT);
                    + "for imported method [["
                throw new IllegalArgumentException(
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {
                    + "], "
    private static final Pattern CLASS_NAME_PATTERN = Pattern.compile("^[_a-zA-Z][._a-zA-Z0-9]*$");
                );
                        + "] "
                    + "] and "
        }
            }
                        + typeToCanonicalTypeName(typeParameter)
            throw new IllegalArgumentException("error loading allowlist(s) " + origin, exception);
                    + "[["
            methodHandle = MethodHandles.publicLookup().in(targetClass).unreflectConstructor(javaConstructor);
        Field javaField;
                        + targetCanonicalClassName
                        + canonicalTypeNameParameters
                    || typeParameter == Short.class
            );
                        + "], "
        Objects.requireNonNull(methodName);
                    + "], "
            throw new IllegalArgumentException(
                        + "]"
        MethodType methodType = methodHandle.type();
                    "type parameter ["
                    + "] "
            }
                }
            throw new IllegalArgumentException(
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
            );
                        + methodName
        }
            );
                    + targetClass.getCanonicalName()
        if (existingTargetClass == null) {
            while (childClass != null) {
        }
        if (existingPainlessClassBinding == null) {
                        + typesToCanonicalTypeNames(typeParameters)
        MethodHandle methodHandle;
                && methodName.startsWith("is")
        } else if (newPainlessMethod.equals(existingPainlessMethod) == false) {
                        || typeParameter == Integer.class
        }
        Method javaMethod = null;
                    + "]"
                    + "]"
            }
                    || typeParameter == Character.class
            if (eachJavaConstructor.getDeclaringClass() == targetClass) {
        }
                painlessClassBuilder.staticMethods.put(painlessMethodKey.intern(), newPainlessMethod);
        for (Method eachJavaMethod : javaMethods) {
        }
                        + "], "
                else if (typeParameter == Float.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_FLOAT_IMPLICIT);
                bridgeClassName,
                }
        MethodType methodType = methodHandle.type();
                        + importedCanonicalClassName
            if (isStatic == false) {
            bridgeConstructorWriter.loadThis();
        Objects.requireNonNull(classLoader);
        Objects.requireNonNull(classLoader);
            throw new IllegalArgumentException(
            }
            );
        PainlessInstanceBinding newPainlessInstanceBinding = new PainlessInstanceBinding(
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
                for (AllowlistClass allowlistClass : allowlist.allowlistClasses) {
        Objects.requireNonNull(canonicalTypeNameParameters);
    }
                        + javaMethods
                    + "], ["
        String methodName,
                        + "], "
                bridgeClassWriter,
            typeParameters,
        }
                    + "["
            throw new IllegalArgumentException("class binding and imported method cannot have the same name [" + methodName + "]");
import static org.opensearch.painless.WriterConstants.DEF_TO_B_DOUBLE_IMPLICIT;
            throw new IllegalArgumentException(
        else if ("short".equals(javaClassName)) clazz = short.class;
    private static final class BridgeLoader extends SecureClassLoader {
                }
                throw new IllegalArgumentException(
        String painlessMethodKey = buildPainlessMethodKey(methodName, typeParametersSize);
                if (typeParameter == Byte.class
                if (javaConstructor != null) {
        if (typeParameter == null) {
                    + "does not match the specified returned type ["
    public void addImportedPainlessMethod(
                    "type parameter ["
                    + "], "
        Objects.requireNonNull(returnType);
                    + "]"
                    painlessLookupBuilder.addPainlessClassBinding(
                "target class ["
                    + "[["
    ) {
                    + "] "
        if (augmentedClass == null) {
            javaField = targetClass.getField(fieldName);
            if (typeParameter == null) {
                iae
                    + "], "
                    + targetCanonicalClassName
            newPainlessConstructor = painlessConstructorCache.computeIfAbsent(newPainlessConstructor, key -> key);
                );
            if (isValidType(typeParameter) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "] and "
        if (javaConstructor == null) {
        Objects.requireNonNull(targetClass);
    private static final Map<PainlessClassBinding, PainlessClassBinding> painlessClassBindingCache = new HashMap<>();
                    + "] "
        }
                "cannot add constructors with the same arity but are not equivalent for constructors "
            List<Class<?>> bridgeTypeParameters = new ArrayList<>(javaMethod.getParameterTypes().length + bridgeTypeParameterOffset);
        }
        }
                        + fieldName
                        + targetClass.getCanonicalName()
        if (existingPainlessClassBuilder == null) {
                    + "], "
                    "class ["
            List<java.lang.reflect.Method> javaMethods = new ArrayList<>();
            if (eachJavaMethod.getDeclaringClass() == targetClass) {
import static org.opensearch.painless.WriterConstants.DEF_UTIL_TYPE;
                    + "] not found for imported method "
                bridgeMethodWriter.loadArg(0);
                    + targetCanonicalClassName
            painlessClassBuilder.runtimeMethods.put(painlessMethodKey.intern(), bridgePainlessMethod);
            javaMethod,
                } else if (typeParametersSize == 1
                        + targetCanonicalClassName
                    "method handle not found for method "
import org.opensearch.painless.spi.AllowlistField;
            Class<?> javaTypeParameter = javaMethod.getParameterTypes()[typeParameterIndex];
        painlessMethodKeysToPainlessInstanceBindings = new HashMap<>();
                        + "], ["
                );
                }
    private static final Map<PainlessInstanceBinding, PainlessInstanceBinding> painlessInstanceBindingCache = new HashMap<>();
                    + "], "
        if (canonicalClasses.equals(painlessClasses) == false) {
                null
                        + methodName
    public void addPainlessConstructor(Class<?> targetClass, List<Class<?>> typeParameters, Map<Class<?>, Object> annotations) {
            Class<?> importedClass = canonicalClassNamesToClasses.get(importedCanonicalClassName);
                            targetCanonicalClassName,
            javaConstructor = targetClass.getConstructor(javaTypeParameters.toArray(new Class<?>[typeParametersSize]));
                    || typeParameter == Integer.class
                "cannot add class bindings with the same name and arity "
        );
import java.security.CodeSource;
                    + methodName
                    + "], "
                    + "], "
        else {
                    + "], ["
        boolean isStatic = augmentedClass == null && Modifier.isStatic(javaMethod.getModifiers());
                    painlessLookupBuilder.addPainlessClass(
                else if (typeParameter == Short.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_SHORT_IMPLICIT);
        addPainlessConstructor(targetClass, typeParameters, annotations);
        int augmentedParameterOffset = augmentedClass == null ? 0 : 1;
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);
                    + "[["
            throw new IllegalArgumentException("instance binding and imported method cannot have the same name [" + methodName + "]");
                    + "[["
        PainlessMethod newPainlessMethod = new PainlessMethod(
                    + canonicalTypeNameParameters
                        + "], ["
                    + "does not match the specified returned type ["
        }
                    + "]"
                        + typeToCanonicalTypeName(typeParameter)
                throw new IllegalArgumentException("must use no_import parameter on class [" + canonicalClassName + "] with no package");
        if (Modifier.isStatic(javaMethod.getModifiers())) {
                }
                    && existingPainlessField.javaField.getDeclaringClass()
                        + "[["
                    + "[["
        String methodName,
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {
                    + typesToCanonicalTypeNames(typeParameters)
        return new PainlessLookup(
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
        painlessMethodKeysToImportedPainlessMethods = new HashMap<>();
                        Character.toLowerCase(methodName.charAt(2)) + methodName.substring(3),
                    + typesToCanonicalTypeNames(typeParameters)
     * with a boxed type to cast from other numeric primitive/boxed types in a symmetric was not handled by
                throw new IllegalArgumentException(
                        + "] not found for method "
            PainlessMethod painlessMethod = painlessMethodEntry.getValue();
                    + "], ["
                        + typeToCanonicalTypeName(typeParameter)
                        + typesToCanonicalTypeNames(typeParameters)
        );
                    bridgeConstructorType.getName(),
                    + "] "
                    + targetCanonicalClassName
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
            );
                        + "], "
        if (existingPainlessInstanceBinding == null) {
                    bridgeTypeParameters.toArray(new Class<?>[0])
                );
                        + "for constructor [["
        while (type.getComponentType() != null) {
    }
                        allowlistInstanceBinding.canonicalTypeNameParameters
                    + "], "
                        + "], ["
    }
            javaClassNamesToClasses.put(targetClass.getName().intern(), targetClass);
                );
                        + "]",
            annotations
    private final Map<String, Class<?>> javaClassNamesToClasses;
    public void addPainlessField(String targetCanonicalClassName, String fieldName, String canonicalTypeNameParameter) {
                        + canonicalTypeNameParameter
            );
                    Opcodes.ACC_PRIVATE,
/*
                    + methodName
                        + methodName
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
        }
                    + methodName
    }
        if (clazz.isArray()) {
        if (augmentedClass == null) {
        canonicalClassNamesToClasses = new HashMap<>();
                    bridgePainlessMethod.methodHandle
            throw new IllegalArgumentException(
                        allowlistClass.painlessAnnotations.containsKey(NoImportAnnotation.class) == false
                && Character.isUpperCase(methodName.charAt(3))) {
            try {
                    bridgeConstructorType.getDescriptor(),
                    + typesToCanonicalTypeNames(typeParameters)
            throw new IllegalArgumentException(
            } catch (IllegalAccessException iae) {
        }
                    + typeToCanonicalTypeName(returnType)
                clazz = Class.forName(javaClassName, true, classLoader);
import java.net.URI;
            if (isValidType(typeParameter) == false) {
        Objects.requireNonNull(returnType);
                    + "], "
        Class<?> targetClass = targetInstance.getClass();
        Class<?> targetClass,
            }
                    + "], "
                "target class ["
                    + "], "
            final Class<?>[] typeParameters = javaMethod.getParameterTypes();
                throw new IllegalArgumentException(
                    bridgeTypeParameters.add(Object.class);
                    + typesToCanonicalTypeNames(existingPainlessMethod.typeParameters)
import static org.opensearch.painless.lookup.PainlessLookupUtility.DEF_CLASS_NAME;
            painlessClassBuilder.setterMethodHandles.put(painlessField.javaField.getName().intern(), painlessField.setterMethodHandle);
                    + "] and "
            annotations
                        + fieldName
            if (isValidType(javaTypeParameter) == false) {
            );
                    + typeToCanonicalTypeName(existingImportedPainlessMethod.returnType)
        else if ("byte".equals(javaClassName)) clazz = byte.class;
            PainlessMethod newPainlessMethod = painlessMethodEntry.getValue();
            int bridgeTypeParameterOffset = isStatic ? 0 : 1;
                        + targetCanonicalClassName
                    "type parameter ["
            } catch (NoSuchMethodException nsme) {
            if (existingPainlessMethod == null
            throw new IllegalArgumentException(
        String targetJavaClassName,
                    + "], ["
import static org.opensearch.painless.WriterConstants.DEF_TO_B_SHORT_IMPLICIT;
            } else {
                    + typeToCanonicalTypeName(javaMethod.getReturnType())
                    + "], "
                            targetCanonicalClassName,
    private void generateBridgeMethod(PainlessClassBuilder painlessClassBuilder, PainlessMethod painlessMethod) {
    }
                        + targetCanonicalClassName
                throw new IllegalArgumentException(
                    + "] not found for class binding "
                        + methodName
                    + methodName
                        + targetCanonicalClassName
                        + "] "
        }
                    + methodName
                    + targetCanonicalClassName
     * Creates a {@link Map} of PainlessMethodKeys to {@link PainlessMethod}s per {@link PainlessClass} stored as
                        + targetCanonicalClassName
                        + "]"
                    bridgeTypeParameters,
            for (Allowlist allowlist : allowlists) {
        Class<?> targetClass = canonicalClassNamesToClasses.get(targetCanonicalClassName);
import static org.opensearch.painless.lookup.PainlessLookupUtility.typesToCanonicalTypeNames;
        }
            } catch (IllegalAccessException iae) {
                    + "], ["
        String painlessMethodKey = buildPainlessMethodKey(methodName, typeParametersSize);
}
            throw new IllegalArgumentException(
        classesToPainlessClassBuilders = new HashMap<>();
            if (isValidType(typeParameter) == false) {
