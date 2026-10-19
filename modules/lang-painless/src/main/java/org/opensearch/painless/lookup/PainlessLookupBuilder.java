                        allowlistClassBinding.painlessAnnotations  
    ) {
            PainlessField newPainlessField = painlessFieldEntry.getValue();
                        + "], "
        Set<Class<?>> canonicalClasses = new HashSet<>(canonicalClassNamesToClasses.values());
                        allowlistInstanceBinding.canonicalTypeNameParameters
                    + "does not match the specified returned type ["
                    + typeToCanonicalTypeName(returnType)  
                    + "], "
                    "type parameter ["
                        + targetCanonicalClassName
                    + targetCanonicalClassName
            }  
                        + "with the same name and different type parameters"
                    "method handle not found for method "
                Method bridgeMethod = bridgeClass.getMethod(
                    + "]"
    private Class<?> canonicalTypeNameToType(String canonicalTypeName) {
        PainlessLookupBuilder painlessLookupBuilder = new PainlessLookupBuilder();
    private static final Pattern FIELD_NAME_PATTERN = Pattern.compile("^[_a-zA-Z][_a-zA-Z0-9]*$");
        PainlessClassBuilder originalPainlessClassBuilder = classesToPainlessClassBuilders.get(originalClass);  
    // canonicalClassNamesToClasses.  
                        Character.toLowerCase(methodName.charAt(2)) + methodName.substring(3),
                        || typeParameter == Integer.class
                );
                    bridgeConstructorType.getDescriptor(),
        try {  
                    + canonicalTypeNameParameters  
        Objects.requireNonNull(targetPainlessClassBuilder);
        Class<?> defineBridge(String name, byte[] bytes) {
            throw new IllegalArgumentException("class [" + targetJavaClassName + "] not found", cnfe);
                    bridgeClass,
                    + "], "
                            allowlistField.canonicalTypeNameParameter
                        + targetClass.getCanonicalName()  
            } else if (javaMethods.size() == 1) {  
    ) {
    ) {
        PainlessInstanceBinding newPainlessInstanceBinding = new PainlessInstanceBinding(
        Objects.requireNonNull(canonicalTypeNameParameters);
                && Character.isUpperCase(methodName.charAt(3))) {  
                nsme
                && methodName.length() > 2
            throw new IllegalArgumentException(  
                    + typesToCanonicalTypeNames(existingPainlessInstanceBinding.typeParameters)  
            throw new IllegalArgumentException(
                    + "for class binding [["
            );  
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());  
                    () -> new BridgeLoader(javaMethod.getDeclaringClass().getClassLoader())  
                    + "], "  
        }
            throw new IllegalArgumentException(
            );
                + javaMethod.getDeclaringClass().getSimpleName()
 *  
                "return type ["
        Objects.requireNonNull(targetCanonicalClassName);
            javaMethod = targetClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));  
                for (AllowlistClass allowlistClass : allowlist.allowlistClasses) {
                java.lang.reflect.Method javaMethod = javaMethods.get(0);
            org.objectweb.asm.commons.Method bridgeConstructorType = new org.objectweb.asm.commons.Method(  
            targetClass = Class.forName(targetJavaClassName, true, classLoader);  
                    + targetCanonicalClassName
            newPainlessClassBinding = painlessClassBindingCache.computeIfAbsent(newPainlessClassBinding, key -> key);
 * Modifications Copyright OpenSearch Contributors. See
                    + "] not found "
            );
            javaClassNamesToClasses.put(targetClass.getName().intern(), targetClass);
                    + methodName
            PainlessMethod painlessMethod = painlessMethodEntry.getValue();
            painlessMethodKeysToPainlessClassBindings.put(painlessMethodKey.intern(), newPainlessClassBinding);
                    + typeToCanonicalTypeName(returnType)  
            if (isValidType(javaTypeParameter) == false) {
                        + "does not match the specified type parameter ["
                    + "], ["  
                    "imported class ["  
        if (CLASS_NAME_PATTERN.matcher(canonicalClassName).matches() == false) {  
                        + canonicalTypeNameParameters
            throw new IllegalArgumentException(
        List<Class<?>> typeParameters,
                        + "] "
        } catch (IllegalAccessException iae) {
            if (existingPainlessField == null) {  
                    );  
                throw new IllegalArgumentException(
        }
            String methodName = painlessMethod.javaMethod.getName();  
                        + "], "
                    + "], "  
                    + "] not found for imported method "
                        + methodName  
            );
                        + targetClass.getCanonicalName()
            if (javaTypeParameter != typeToJavaType(typeParameter)) {
        painlessMethodKeysToImportedPainlessMethods = new HashMap<>();  
            }
                "target class ["
            }
                throw new IllegalArgumentException(  
            throw new IllegalArgumentException(
        }
                    + "] "
                    + "] not found for imported method "  
                "return type ["
                    + "[["  
                    for (AllowlistMethod allowlistMethod : allowlistClass.allowlistMethods) {
                        + typeToCanonicalTypeName(typeParameter)
                        + typeToCanonicalTypeName(typeParameter)  
                    + targetCanonicalClassName  
                    iae
        }
                    + "], "  
                        + "for class binding [["
        else if ("boolean".equals(javaClassName)) clazz = boolean.class;  
                "imported method [["
                    + "cannot represent multiple java classes with the same name from different class loaders"
        if ("void".equals(javaClassName)) clazz = void.class;
        addPainlessField(targetClass, fieldName, typeParameter);
                );
                    + "], "  
        }
        if (painlessMethodKeysToPainlessInstanceBindings.containsKey(painlessMethodKey)) {  
        Objects.requireNonNull(fieldName);
        Method javaMethod;  
                    + "[["  
                    + methodName  
        Class<?> targetClass = canonicalClassNamesToClasses.get(targetCanonicalClassName);  
            } catch (ClassNotFoundException cnfe) {
    public void addPainlessClassBinding(  
                        + "], "  
                );
                    + "for field [["
            painlessMethodKeysToImportedPainlessMethods.put(painlessMethodKey.intern(), newImportedPainlessMethod);
                            allowlistMethod.augmentedCanonicalClassName,
/*
        }
                "type parameter ["
                    + typeToCanonicalTypeName(returnType)
            }
            List<Class<?>> bridgeTypeParameters = new ArrayList<>(javaMethod.getParameterTypes().length + bridgeTypeParameterOffset);
        for (Map.Entry<Class<?>, PainlessClassBuilder> painlessClassBuilderEntry : classesToPainlessClassBuilders.entrySet()) {
        }
            }
                    origin = allowlistStatic.origin;
    public void addImportedPainlessMethod(  
        Constructor<?> javaConstructor = null;
                        allowlistStatic.painlessAnnotations  
        }
                painlessClassBuilder.functionalInterfaceMethod = painlessClassBuilder.methods.get(painlessMethodKey);  
        Map<Class<?>, Object> annotations  
                    + "does not match the specified returned type ["
                    + "] cannot be static"
                throw new IllegalArgumentException(
        String painlessConstructorKey = buildPainlessConstructorKey(typeParametersSize);
            );
                    + "cannot represent multiple java classes with the same name from different class loaders"  
                    + targetCanonicalClassName
                    + typesToCanonicalTypeNames(typeParameters)  
        Objects.requireNonNull(targetClass);
                    painlessLookupBuilder.addPainlessClass(
                        + targetCanonicalClassName
                    bridgeMethod,
                );  
        Objects.requireNonNull(typeParameters);
                        + typesToCanonicalTypeNames(typeParameters)
                        + "not found for imported method [["
                null,
                    + typesToCanonicalTypeNames(typeParameters)
                        + "[["
     * from {@link Integer} to long but not from int to {@link Long}. Generated bridge methods cover the latter case.
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
                    + targetCanonicalClassName
                        painlessClassBuilder.setterMethodHandles.putIfAbsent(
                bridgeMethodWriter.loadArg(typeParameterCount + bridgeTypeParameterOffset);
                throw new IllegalArgumentException("static field [[" + targetCanonicalClassName + "], [" + fieldName + "]] must be final");  
            newPainlessInstanceBinding = painlessInstanceBindingCache.computeIfAbsent(newPainlessInstanceBinding, key -> key);
            } catch (IllegalAccessException iae) {
                }
                        + "], ["  
        if (bridgePainlessMethod == null) {
        Objects.requireNonNull(typeParameters);
            try {
                && Character.isUpperCase(methodName.charAt(2))) {
            Class<?> javaTypeParameter = javaConstructor.getParameterTypes()[typeParameterIndex];
                    + "] not found for field "  
                        + "[["
                        + "], "
        Class<?> targetClass;  
                    || typeParameter == Double.class) {
                        + "[["  
        try {
        if (returnType == null) {
                    );  
                    + "] not found",
                            allowlistConstructor.canonicalTypeNameParameters,  
            painlessClassBuilder.getterMethodHandles.put(painlessField.javaField.getName().intern(), painlessField.getterMethodHandle);
        for (PainlessField painlessField : painlessClassBuilder.fields.values()) {  
        Objects.requireNonNull(canonicalTypeNameParameter);
        }
            } catch (IllegalAccessException iae) {
                    + "], "  
    public PainlessLookupBuilder() {
            painlessClassBuilder.runtimeMethods.putAll(painlessClassBuilder.methods);  
        Objects.requireNonNull(methodName);
                        + methodName
            }
                }
                            allowlistMethod.methodName,
            }
                    + "["  
        }
                    + "], "  
        String targetCanonicalClassName,
     */  
        }  
            try {
                    + typeToCanonicalTypeName(javaMethod.getReturnType())
                        + targetCanonicalClassName
    private static final Map<PainlessClassBinding, PainlessClassBinding> painlessClassBindingCache = new HashMap<>();
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {
                "target class ["  
                        + "], "
                    + methodName
        if (painlessMethodKeysToImportedPainlessMethods.containsKey(painlessMethodKey)) {
                    + fieldName
                else if (typeParameter == Integer.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_INTEGER_IMPLICIT);
                    "type parameter ["
        } else if (existingTargetClass != targetClass) {
            throw new IllegalArgumentException(
                );
        else if ("short".equals(javaClassName)) clazz = short.class;
            if (typeParametersSize == 0  
                    );  
                            + "["  
                    + typeToCanonicalTypeName(returnType)
                null  
                bridgeClassWriter.visitMethod(
            throw new IllegalArgumentException(  
                "return type ["
            bridgeMethodWriter.endMethod();  
                        + "] "
        Class<?> existingTargetClass = javaClassNamesToClasses.get(targetClass.getName());
                throw new IllegalArgumentException("inconsistent no_import parameter found for class [" + canonicalClassName + "]");
                    + "], "
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);  
                        + "]"
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);  
        else if ("float".equals(javaClassName)) clazz = float.class;  
            }
            Class<?> childClass = parentClass.getSuperclass();  
            );
        String methodName,
    private static final Map<PainlessInstanceBinding, PainlessInstanceBinding> painlessInstanceBindingCache = new HashMap<>();  
                    + typesToCanonicalTypeNames(typeParameters)
        PainlessClassBinding newPainlessClassBinding = new PainlessClassBinding(
                    + methodName
                    + "] not found "
                }
            String bridgeClassName = "org/opensearch/painless/Bridge$"
import org.objectweb.asm.commons.GeneratorAdapter;
                        + typesToCanonicalTypeNames(typeParameters)
            javaConstructor,
                    + targetCanonicalClassName
            : painlessClassBuilder.methods.get(painlessMethodKey);  
                    + typeToCanonicalTypeName(returnType)
                MethodType.methodType(void.class).toMethodDescriptorString()
            methodHandleGetter = MethodHandles.publicLookup().unreflectGetter(javaField);
                javaConstructor = eachJavaConstructor;  
            if (isStatic == false) {
        }  
/*  
import java.security.cert.Certificate;  
        if (painlessClassBuilder == null) {
                    + "], ["  
        }  
        for (Class<?> typeParameter : typeParameters) {
                );
            throw new IllegalArgumentException(  
                    + targetCanonicalClassName  
                        allowlistClassBinding.returnCanonicalTypeName,
                throw new IllegalArgumentException(
    private void setFunctionalInterfaceMethods() {
            methodType,
 * license agreements. See the NOTICE file distributed with
            );
import java.util.Map;  
public final class PainlessLookupBuilder {
                    + "], "
        if (isValidType(returnType) == false) {  
        }
        MethodHandle methodHandle;
        }
        }
            } else if (typeParametersSize == 0
                    + targetCanonicalClassName
        for (Class<?> parentClass : classesToPainlessClassBuilders.keySet()) {  
     * {@link MethodHandle#asType(MethodType)}. As an example {@link MethodHandle#asType(MethodType)} legally casts
            );
    private void copyPainlessClassMembers() {
        String methodName,  
                            allowlistMethod.painlessAnnotations
            throw new IllegalArgumentException(  
        PainlessConstructor existingPainlessConstructor = painlessClassBuilder.constructors.get(painlessConstructorKey);  
                    && methodName.length() > 3  
        } else if (newPainlessConstructor.equals(existingPainlessConstructor) == false) {  
                "invalid field name [" + fieldName + "] for target class [" + targetCanonicalClassName + "]."  
            if (typeParameter == null) {
        PainlessClassBuilder targetPainlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);
            Class<?> importedClass = canonicalClassNamesToClasses.get(importedCanonicalClassName);  
        Map<Class<?>, Object> annotations  
                    + targetCanonicalClassName  
                    + typesToCanonicalTypeNames(typeParameters)
                    + methodName
            Class<?> typeParameter = typeParameters.get(typeParameterIndex);
                    + "], ["
                    + "], "
                    + "] not found for imported method "
        setFunctionalInterfaceMethods();
                        + "], "  
                    + "], ["  
                    "internal error occurred attempting to generate a bridge method [" + bridgeClassName + "]",
            }
                    + targetClass.getCanonicalName()
                "the values of canonical class names to classes " + "must have the same classes as the keys of classes to painless classes"  
        Constructor<?> javaConstructor;
            }
                    "type parameter ["  
            super(parent);
    // individually. The values of javaClassNamesToClasses are a superset of the values of
                    + methodName
import static org.opensearch.painless.WriterConstants.DEF_TO_B_DOUBLE_IMPLICIT;
                    + "cannot represent multiple java classes with the same name from different class loaders"  
                "cannot add instances bindings with the same name and arity "
        Objects.requireNonNull(targetClass);  
                        + "], "
                    "reflection object not found for method [["  
                throw new IllegalArgumentException(  
    ) {
        if (existingTargetClass == null) {
            javaClassNamesToClasses.put(targetClass.getName().intern(), targetClass);  
                        + canonicalTypeNameParameter
                    + typeToCanonicalTypeName(returnType)
                    + targetCanonicalClassName
        Objects.requireNonNull(canonicalTypeNameParameters);
                    + canonicalTypeNameParameters
        }  
package org.opensearch.painless.lookup;
            throw new IllegalArgumentException(  
        if (isValidType(returnType) == false) {
        );
            }
import static org.opensearch.painless.WriterConstants.DEF_TO_B_INTEGER_IMPLICIT;  
                    + targetClass.getCanonicalName()  
                        + targetCanonicalClassName
                else if (typeParameter == Character.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_CHARACTER_IMPLICIT);  
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {
        if (returnType == null) {  
                        + "], "  
                            allowlistField.fieldName,
                painlessClassBuilder.staticFields.put(painlessFieldKey.intern(), newPainlessField);
            );
                );
                    + methodName
                    copyPainlessClassMembers(childClass, parentClass);
                        painlessLookupBuilder.addPainlessConstructor(
                    + "], "
                        + "]"
                        + "]",  
        String methodName,  
                        + "with the same name and different type parameters"  
                    + "cannot represent multiple java classes with the same name from different class loaders"
        Objects.requireNonNull(fieldName);  
                        + "], ["  
                    + "]"
        Class<?> clazz;  
                    + targetClass.getCanonicalName()  
                bridgePainlessMethod = new PainlessMethod(  
            throw new IllegalArgumentException(
            throw new IllegalArgumentException(
                "<init>",
        }
        if (painlessMethodKeysToImportedPainlessMethods.containsKey(painlessMethodKey)) {
        }
            }
 * specific language governing permissions and limitations
        }
                        + "[["
            type = type.getComponentType();
        if (Modifier.isStatic(javaMethod.getModifiers())) {  
            try {
     * {@link PainlessClass#runtimeMethods} identical to {@link PainlessClass#methods} with the exception of generated
                    + targetCanonicalClassName
    public PainlessLookup build() {  
            );
            try {
                        + "] "  
                        + targetCanonicalClassName  
                            + typeToCanonicalTypeName(augmentedClass)
                    + canonicalTypeNameParameters
                        + "[["
            newPainlessMethod = painlessMethodCache.computeIfAbsent(newPainlessMethod, key -> key);  
            methodHandle = MethodHandles.publicLookup().in(targetClass).unreflectConstructor(javaConstructor);
            methodHandle,  
                methodHandleSetter = MethodHandles.publicLookup().unreflectSetter(javaField);  
                    + targetCanonicalClassName
        if (targetClass == null) {
        );
            }  
            for (int typeParameterCount = 0; typeParameterCount < typeParameters.length; ++typeParameterCount) {  
    private static final Map<PainlessField, PainlessField> painlessFieldCache = new HashMap<>();
                        allowlistClass.painlessAnnotations.containsKey(NoImportAnnotation.class) == false
                    + "[["
        Constructor<?>[] javaConstructors = targetClass.getConstructors();
                );  
        Objects.requireNonNull(methodName);
                        + "], ["  
import java.util.HashSet;
    // canonicalClassNamesToClasses is all the allowlisted classes available in a Painless script including
        else if ("double".equals(javaClassName)) clazz = double.class;
                        + existingPainlessField.javaField.getName()
            }
                    + "]"  
        PainlessConstructor newPainlessConstructor = new PainlessConstructor(
                );
                        + typeToCanonicalTypeName(targetClass)
    private void setFunctionalInterfaceMethod(Class<?> targetClass, PainlessClassBuilder painlessClassBuilder) {
                );
                    + "]"
                    + targetCanonicalClassName
                    + returnCanonicalTypeName
            canonicalClassNamesToClasses.put(canonicalClassName.intern(), clazz);  
                    + "for instance binding [["
            );  
            } else if (importedClass != clazz) {
            boolean isStatic = Modifier.isStatic(painlessMethod.javaMethod.getModifiers());  
                        + "] and "  
                    "type parameter ["
                );
            throw new IllegalArgumentException(
            throw new IllegalArgumentException(  
            throw new IllegalArgumentException(
        if (painlessMethodKeysToPainlessClassBindings.containsKey(painlessMethodKey)) {
                if (Modifier.isStatic(javaMethod.getModifiers()) == false) {  
                    + methodName
                    painlessClassBuilder.getterMethodHandles.putIfAbsent(  
                    + "], "
        }
                null  
 * under the License.  
        }  
                );
                "return type ["
                    + canonicalClassName
                    + "], "
        for (Class<?> typeParameter : typeParameters) {
            copyPainlessInterfaceMembers(childClass, targetClass);
                        + typesToCanonicalTypeNames(typeParameters)  
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
                        + targetCanonicalClassName
        if (javaClasses.containsAll(canonicalClasses) == false) {
 */  
                    "type parameter ["
            );
                        + "], ["
                throw new IllegalStateException(  
                    + "]"
                    + "] "
        String methodName,
                    origin = allowlistClass.origin;
                        + "], ["
                    );
import org.opensearch.painless.spi.Allowlist;
                        + existingPainlessField.javaField.getName()
                if (javaConstructor != null) {  
        Field javaField;
                bridgeClassAccess,
                "reflection object not found for field [[" + targetCanonicalClassName + "], [" + fieldName + "]",
                    + "[["
    private static final CodeSource CODESOURCE;  
                "class ["
        Objects.requireNonNull(canonicalTypeNameParameters);  
        }  
                        + "], "  
                        + targetClass.getCanonicalName()
                    + "]"  
                + javaMethod.getName();
            }  
                "the values of java class names to classes " + "must be a superset of the keys of classes to painless classes"  
            );
        Objects.requireNonNull(returnType);  
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {  
                    }  
                        allowlistStatic.augmentedCanonicalClassName,
        PainlessInstanceBinding existingPainlessInstanceBinding = painlessMethodKeysToPainlessInstanceBindings.get(painlessMethodKey);
            throw new IllegalArgumentException("cannot add class binding as reserved class [" + DEF_CLASS_NAME + "]");
            }
        Objects.requireNonNull(methodName);
                        + "], "
            throw new IllegalArgumentException(
        String returnCanonicalTypeName,
                    + "] not found"
                        + methodName
                        allowlistClassBinding.canonicalTypeNameParameters,
        MethodHandle methodHandle;
            int bridgeTypeParameterOffset = isStatic ? 0 : 1;  
            );  
            );
            throw new IllegalArgumentException(
                    + typeToCanonicalTypeName(typeParameter)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + "]"
                    + typesToCanonicalTypeNames(typeParameters)  
        Set<Class<?>> javaClasses = new HashSet<>(javaClassNamesToClasses.values());  
                "type parameter ["  
                        );
                "class ["
                    + "], "
import org.opensearch.painless.spi.annotation.InjectConstantAnnotation;  
                throw new IllegalArgumentException(
                    + methodName
                || existingPainlessField.javaField.getDeclaringClass() != newPainlessField.javaField.getDeclaringClass()  
        }  
            throw new IllegalArgumentException(  
                        + typeToCanonicalTypeName(typeParameter)
            throw new IllegalArgumentException("cannot add constructor to reserved class [" + DEF_CLASS_NAME + "]");
                    + "]"
        Class<?> augmentedClass,  
        }
                        + typesToCanonicalTypeNames(typeParameters)  
                    + "], ["
        String canonicalClassName = typeToCanonicalTypeName(clazz);  
        } else {
                    + methodName
                    + targetCanonicalClassName
                    + canonicalTypeNameParameters  
import java.util.Objects;
                    "setter method handle not found for field [[" + targetCanonicalClassName + "], [" + fieldName + "]]"  
                } else {
                    + typesToCanonicalTypeNames(existingImportedPainlessMethod.typeParameters)  
                    if (existingPainlessClassBuilder != null) {
import org.opensearch.painless.spi.AllowlistClassBinding;
    public void addImportedPainlessMethod(
                    + "] not found for method "  
                javaMethod = augmentedClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));
        PainlessClassBuilder painlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);  
                        + "classes ["  
                    + "], "
            javaMethod,  
            if (isValidType(typeParameter) == false) {
 * this work for additional information regarding copyright
                    }  
                        || typeParameter == Character.class  
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize);  
                        origin = allowlistMethod.origin;  
                        + "], "
                    + "] "
        }
        }  
                        + "]",
                        + targetCanonicalClassName
        // Matcher m = new Matcher();  
        }
    public void addPainlessConstructor(Class<?> targetClass, List<Class<?>> typeParameters, Map<Class<?>, Object> annotations) {
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {
                    + "]"
                            Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4),  
                        + methodName  
                    + "], "  
            if (isStatic) {
        }  
                        + "], "
        addImportedPainlessMethod(targetClass, methodName, returnType, typeParameters, annotations);
        Objects.requireNonNull(returnCanonicalTypeName);  
            typeParameters.add(typeParameter);
                    + "], "
                        + "for class binding [["
        int methodTypeParametersSize = javaMethod.getParameterCount();  
                    + "] "
                    origin = allowlistClassBinding.origin;
            );
                        + "] not found "  
                        );  
                        + "] not found "
                painlessClassBuilder.methods.put(painlessMethodKey.intern(), newPainlessMethod);
                        + typesToCanonicalTypeNames(typeParameters)
                        + "], ["  
        PainlessMethod newImportedPainlessMethod = new PainlessMethod(
                    + "[["
                );
                    + "]"
                    nsme  
                        + typeToCanonicalTypeName(existingPainlessField.typeParameter)
                        + "], "
        if (targetClass == def.class) {
                        + "] not found for class binding "  
            throw new IllegalArgumentException(
        }
                        + "[["
    }  
                        + "does not match the specified type parameter ["
                )
        }
        for (PainlessClassBuilder painlessClassBuilder : classesToPainlessClassBuilders.values()) {
                "getter method handle not found for field [[" + targetCanonicalClassName + "], [" + fieldName + "]]"
        if (existingImportedPainlessMethod == null) {
            throw new IllegalArgumentException("error loading allowlist(s) " + origin, exception);  
                        + "], "  
            if (isValidType(javaTypeParameter) == false) {
        }
                    + "for constructor [["  
            javaConstructor = targetClass.getConstructor(javaTypeParameters.toArray(new Class<?>[typeParametersSize]));
        Objects.requireNonNull(methodName);  
                        + "], ["
                "instance binding [["
                            targetCanonicalClassName,  
        if (existingTargetClass == null) {  
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize);  
        Map<Class<?>, PainlessClass> classesToPainlessClasses = new HashMap<>(classesToPainlessClassBuilders.size());  
                    + methodName
        Objects.requireNonNull(returnCanonicalTypeName);  
        generateRuntimeMethods();  
 * this file be licensed under the Apache-2.0 license or a
                    + "] not found for method "  
     * bridge methods. A generated bridge method is created for each allowlisted method that has at least one parameter
                    + targetCanonicalClassName
            );  
    ) {
                    + targetCanonicalClassName
                }
                    + typeToCanonicalTypeName(javaMethod.getReturnType())
                    + "], ["
    }  
        Map<Class<?>, Object> annotations  
                    String targetCanonicalClassName = allowlistClass.javaClassName.replace('$', '.');  
        int augmentedParameterOffset = augmentedClass == null ? 0 : 1;  
        }  
            bridgeConstructorWriter.endMethod();
                throw new IllegalArgumentException(
            throw new IllegalArgumentException(  
        Class<?> returnType,
            throw new IllegalArgumentException(  
    private void copyPainlessInterfaceMembers(Class<?> parentClass, Class<?> targetClass) {
            for (Class<?> typeParameter : javaMethod.getParameterTypes()) {
                    + typesToCanonicalTypeNames(existingPainlessConstructor.typeParameters)
            );  
        return PainlessLookupUtility.canonicalTypeNameToType(canonicalTypeName, canonicalClassNamesToClasses);  
        if (FIELD_NAME_PATTERN.matcher(fieldName).matches() == false) {
        String painlessMethodKey = buildPainlessMethodKey(methodName, typeParametersSize);  
            );
                "target class ["  
import static org.opensearch.painless.lookup.PainlessLookupUtility.buildPainlessConstructorKey;  
            try {
            throw new IllegalArgumentException("cannot add imported method from reserved class [" + DEF_CLASS_NAME + "]");  
        } catch (NoSuchFieldException nsme) {
                javaMethod = eachJavaMethod;
            if (isValidType(typeParameter) == false) {
                        origin = allowlistConstructor.origin;  
        } else if (newPainlessClassBinding.equals(existingPainlessClassBinding) == false) {  
    // javaClassNamesToClasses is all the classes that need to be available to the custom classloader  
        }  
                methodHandle = MethodHandles.publicLookup().in(augmentedClass).unreflect(javaMethod);  
                    && existingPainlessField.javaField.getDeclaringClass()
            Class<?> javaTypeParameter = javaMethod.getParameterTypes()[typeParameterIndex];  
 * ownership. Elasticsearch licenses this file to you under  
                        + typesToCanonicalTypeNames(typeParameters)
                        + "], ["
            throw new IllegalArgumentException(
                    + "[["  
            javaMethod,
            PainlessField newPainlessField = new PainlessField(javaField, typeParameter, methodHandleGetter, null);
            targetClass = Class.forName(targetJavaClassName, true, classLoader);  
        for (Map.Entry<String, PainlessMethod> painlessMethodEntry : originalPainlessClassBuilder.methods.entrySet()) {  
                            + "] must be static"
                    + "]]"
            javaTypeParameters.add(typeToJavaType(typeParameter));  
                    + "] not found for imported method "
        if (targetClass == def.class) {  
                "target class ["  
            );
            );
                        + typeToCanonicalTypeName(augmentedClass)  
import java.lang.reflect.Field;
                + "$"  
            painlessClassBuilder.runtimeMethods.put(painlessMethodKey.intern(), bridgePainlessMethod);  
        if (isValidType(returnType) == false) {  
                    + typeToCanonicalTypeName(returnType)  
    public void addPainlessField(String targetCanonicalClassName, String fieldName, String canonicalTypeNameParameter) {
            );
            try {  
    }  
                    + "[["
        cacheRuntimeHandles();
                        + canonicalTypeNameParameter
                    + "] "
                targetPainlessClassBuilder.fields.put(painlessFieldKey.intern(), newPainlessField);  
            if (eachJavaConstructor.getDeclaringClass() == targetClass) {
                    "type parameter ["
                for (AllowlistClass allowlistClass : allowlist.allowlistClasses) {  
                javaMethod = targetClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));  
        }  
                painlessBridgeCache.put(painlessMethod, bridgePainlessMethod);
                        + methodName
                        + targetCanonicalClassName
                targetPainlessClassBuilder.methods.put(painlessMethodKey.intern(), newPainlessMethod);
                    + methodName
        if (Modifier.isStatic(javaField.getModifiers())) {
        painlessMethodKeysToPainlessClassBindings = new HashMap<>();
    }  
    }
        String javaClassName = clazz.getName();
                    + "] must be static"
            } catch (IllegalAccessException iae) {  
    }  
        else if ("int".equals(javaClassName)) clazz = int.class;
        }  
            }
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {  
            );  
                        + "], ["  
                copyPainlessInterfaceMembers(childClass, parentClass);
        }
        Objects.requireNonNull(javaClassName);
                throw new IllegalArgumentException(
                        + "] "  
                    + methodName
                    || typeParameter == Long.class  
                            bridgePainlessMethod.methodHandle
            Class<?> typeParameter = typeParameters.get(constructorTypeParametersSize + typeParameterIndex);  
                    + "] not found for class binding "  
            PainlessMethod bridgePainlessMethod = painlessClassBuilder.runtimeMethods.get(methodKey);
                    + "["  
                    Opcodes.ACC_PRIVATE,
        List<String> canonicalTypeNameParameters,
                    + "], "  
            String painlessMethodKey = painlessMethodEntry.getKey();
                "invalid method name [" + methodName + "] for instance binding [" + targetCanonicalClassName + "]."
                    + typeToCanonicalTypeName(returnType)  
        }  
                        + javaMethods
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
        Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
                "target class ["
                    + "] "
        }  
import java.util.Set;
            throw new IllegalArgumentException(  
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
        canonicalClassNamesToClasses = new HashMap<>();  
                        + canonicalTypeNameParameters
                "return type ["
            painlessMethodKeysToPainlessInstanceBindings.put(painlessMethodKey.intern(), newPainlessInstanceBinding);
        ClassLoader classLoader,  
                    painlessMethod.returnType,  
                    + "for field [["  
    public void addPainlessConstructor(  
                    + "]",
                        + "not found for instance binding [["
                throw new IllegalArgumentException(
                copyPainlessClassMembers(childClass, targetClass);
                    + methodName
                    "type parameter ["  
            );  
            painlessMethodKeysToPainlessInstanceBindings
                    + methodName  
        else if ("long".equals(javaClassName)) clazz = long.class;
    // classes with imported canonical names but does not include classes from imported methods or class  
                "type parameter ["
                        + "not found for method [["
        }  
                iae  
    private final Map<String, Class<?>> javaClassNamesToClasses;
                        + "]"
import org.objectweb.asm.Opcodes;
                    + targetCanonicalClassName
                        + targetCanonicalClassName  
        Objects.requireNonNull(typeParameters);
            String methodKey = painlessMethodEntry.getKey();  
                    + "], "
 * not use this file except in compliance with the License.
            );
                        || typeParameter == Long.class
        if (augmentedCanonicalClassName != null) {
        ClassLoader classLoader,
            typeParameters.add(typeParameter);  
                    + "], "
                    + "]"  
    private final Map<String, Class<?>> canonicalClassNamesToClasses;  
        }  
                    + "[["
                            + "], "  
            if (existingPainlessMethod == null
                    + targetCanonicalClassName
                        allowlistStatic.returnCanonicalTypeName,
        String targetJavaClassName,
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {  
        }
        Objects.requireNonNull(classLoader);  
                throw new IllegalArgumentException(
                        "method [["
                    + "], "
                        allowlist.classLoader,
            ? painlessClassBuilder.staticMethods.get(painlessMethodKey)
                    + typesToCanonicalTypeNames(typeParameters)
                        + methodName  
        String importedCanonicalClassName = javaClassName.substring(javaClassName.lastIndexOf('.') + 1).replace('$', '.');
                    + "cannot represent multiple java classes with the same name from different class loaders"
            } catch (NoSuchMethodException nsme) {
            if (typeParameter == null) {
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
    // bindings unless also allowlisted separately. The values of canonicalClassNamesToClasses are a subset
                "return type ["
            }
                    + "]"
                        allowlistInstanceBinding.returnCanonicalTypeName,  
                "invalid method name [" + methodName + "] for target class [" + targetCanonicalClassName + "]."
                    + "] not found for field "
        int typeParametersSize = typeParameters.size();
            typeParametersSize = typeParameters.size();
            painlessClassBuilder.setterMethodHandles.put(painlessField.javaField.getName().intern(), painlessField.setterMethodHandle);
                        + canonicalClassName
            throw new IllegalArgumentException("cannot add field to reserved class [" + DEF_CLASS_NAME + "]");
            throw new IllegalArgumentException(
                }
            if (numInjections > 0) {  
                    + "] cannot be static"
    }
                        allowlistClassBinding.targetJavaClassName,
                    + typeToCanonicalTypeName(returnType)
        String returnCanonicalTypeName,  
    }
                nsme
                    + "], "  
        PainlessClassBinding existingPainlessClassBinding = painlessMethodKeysToPainlessClassBindings.get(painlessMethodKey);  
                    + "[["  
            ClassWriter bridgeClassWriter = new ClassWriter(bridgeClassFrames);
                    + typesToCanonicalTypeNames(typeParameters)
        if (existingPainlessClassBinding == null) {  
    private boolean isValidType(Class<?> type) {  
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
        Class<?> targetClass,
import java.util.HashMap;  
            javaMethod,
        }
                    + methodName
import java.util.Collections;
        if (targetClass == null) {
                WriterConstants.CLASS_VERSION,
                            targetCanonicalClassName,  
            );  
                    "augmented class ["  
                "return type ["
                    + "] not found for class binding "
                        + "], ["  
                    + "], ["
        if (targetClass == def.class) {  
        } else if (existingTargetClass != targetClass) {
                    "type parameter ["  
                            targetCanonicalClassName,
                "return type ["
        }  
                        + canonicalTypeNameParameters  
                        || typeParameter == Short.class
                        + canonicalTypeNameParameter
            }
                augmentedClass = Class.forName(augmentedCanonicalClassName, true, classLoader);  
                    + "]"
                    + "], "  
            newPainlessConstructor = painlessConstructorCache.computeIfAbsent(newPainlessConstructor, key -> key);
            );
 * The OpenSearch Contributors require contributions made to  
                    + "["
            );
                bridgeMethodWriter.loadArg(0);
                    + "] not found for method "  
                    && methodName.startsWith("set")
    static {
                    + typesToCanonicalTypeNames(typeParameters)  
                            allowlist.classLoader,
                        + canonicalTypeNameParameters  
                    + targetClass.getCanonicalName()
                    + typeToCanonicalTypeName(existingPainlessMethod.returnType)
            throw new IllegalArgumentException(
        );
                    + targetCanonicalClassName
                    + fieldName  
                    + "], ["
            );
                    + returnCanonicalTypeName
        } catch (MalformedURLException mue) {
        }
        for (int typeParameterIndex = 0; typeParameterIndex < constructorTypeParametersSize; ++typeParameterIndex) {
            throw new IllegalArgumentException("cannot add method to reserved class [" + DEF_CLASS_NAME + "]");
                );  
                    + typeToCanonicalTypeName(javaField.getType())  
            PainlessField newPainlessField = new PainlessField(javaField, typeParameter, methodHandleGetter, methodHandleSetter);
            throw new IllegalArgumentException(
        }
                    + "], "
                        + "]"
                    + "], "
                    + targetCanonicalClassName  
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);
    ) {
    }  
        if (existingTargetClass == null) {  
                "cannot add constructors with the same arity but are not equivalent for constructors "
                    + canonicalTypeNameParameter  
        else if ("char".equals(javaClassName)) clazz = char.class;  
                        allowlist.classLoader,  
    public void addPainlessClass(Class<?> clazz, boolean importClassName) {
    }
                );  
        }
                        + fieldName  
                        + fieldName
                    painlessMethod.javaMethod.getName(),
                    + "], "
        List<String> canonicalTypeNameParameters,
        Objects.requireNonNull(returnCanonicalTypeName);  
                    + "], "  
                        + "], "
        } catch (ClassNotFoundException cnfe) {
                        + methodName
                    + "["  
            if (typeParameter == null) {
            throw new IllegalArgumentException("class binding [" + targetCanonicalClassName + "] must have exactly one constructor");
                Class<?> bridgeClass = bridgeLoader.defineBridge(bridgeClassName.replace('/', '.'), bridgeClassWriter.toByteArray());  
                        + targetCanonicalClassName  
import static org.opensearch.painless.WriterConstants.DEF_TO_B_CHARACTER_IMPLICIT;  
 * compatible open source license.
                    + methodName  
                    + "for field [["
                        + "] not found for imported method "
            }  
                        + augmentedCanonicalClassName
                );  
                            + "] with augmented class "
        }
                    || typeParameter == Short.class  
            }  
                    + "] not found",
import org.opensearch.painless.MethodWriter;  
        return new PainlessLookup(
        if (clazz.isArray()) {
            PainlessField existingPainlessField = painlessClassBuilder.fields.get(painlessFieldKey);
                        + "for class binding [["
                    + "], ["
        public Class<?> findClass(String name) throws ClassNotFoundException {  
                        Object.class.getMethod(javaMethod.getName(), javaMethod.getParameterTypes());  
                BridgeLoader bridgeLoader = AccessController.doPrivileged(
            typeParameters,  
import java.security.CodeSource;
                        + "]"
                    "type parameter ["
                    + targetCanonicalClassName
        }
                        + "], ["
            copyPainlessInterfaceMembers(parentClass, parentClass);
            methodHandle,
                        generateBridgeMethod(painlessClassBuilder, painlessMethod);
            bridgeConstructorWriter.visitCode();  
                throw new IllegalArgumentException(
import static org.opensearch.painless.lookup.PainlessLookupUtility.typesToCanonicalTypeNames;
                    throw new IllegalArgumentException("class binding [" + targetCanonicalClassName + "] cannot have multiple methods");
        }
            }  
                        + methodName
                    + targetCanonicalClassName  
        );
            methodType,
                        + targetCanonicalClassName
            javaClassNamesToClasses.put(clazz.getName().intern(), clazz);
        boolean isStatic = augmentedClass == null && Modifier.isStatic(javaMethod.getModifiers());
                    + "["
            if (isValidType(typeParameter) == false) {  
                        + typesToCanonicalTypeNames(typeParameters)
                        + typeToCanonicalTypeName(typeParameter)  
        javaClassNamesToClasses = new HashMap<>();
                    + targetCanonicalClassName
            }  
            for (Allowlist allowlist : allowlists) {
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "] "
                    cnfe
            }
                        + "] not found for instance binding "
                "return type ["  
            }
            );
                        + "] "
                    + targetCanonicalClassName
            painlessClassBuilder.constructors.put(painlessConstructorKey.intern(), newPainlessConstructor);
                        + typeToCanonicalTypeName(existingPainlessField.typeParameter)  
        Class<?> returnType,
            bridgeConstructorWriter.invokeConstructor(OBJECT_TYPE, bridgeConstructorType);
                }
                    + typesToCanonicalTypeNames(typeParameters)  
                "return type ["  
            Method javaMethod = painlessMethod.javaMethod;
                iae
        }
            );
import org.opensearch.secure_sm.AccessController;
import java.lang.reflect.Method;  
                        + "] cannot represent multiple "
                if (javaMethod != null) {  
        Objects.requireNonNull(typeParameter);
            for (Allowlist allowlist : allowlists) {
                }
        Objects.requireNonNull(typeParameters);
                        + typeToCanonicalTypeName(javaTypeParameter)
        PainlessClassBuilder painlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);
        String methodName,  
                "the values of java class names to classes " + "must be a superset of the values of canonical class names to classes"  
        Objects.requireNonNull(targetClass);  
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());  
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);  
        }
        int typeParametersSize = typeParameters.size();
                        + "] not found "
                painlessClassBuilder.staticMethods.put(painlessMethodKey.intern(), newPainlessMethod);  
                throw new IllegalArgumentException(
                    && Character.isUpperCase(methodName.charAt(3))) {
        MethodHandle methodHandleGetter;
            bridgeMethodWriter.invokeMethodCall(painlessMethod);
                    + "]"
 * KIND, either express or implied.  See the License for the
            );
                        + "], "
        if (clazz == def.class) {
        if (painlessMethodKeysToPainlessClassBindings.containsKey(painlessMethodKey)) {  
            return defineClass(name, bytes, 0, bytes.length, CODESOURCE);
                );
        addPainlessInstanceBinding(targetInstance, methodName, returnType, typeParameters);  
        int typeParametersSize = typeParameters.size();
        Objects.requireNonNull(methodName);
        String painlessMethodKey = buildPainlessMethodKey(painlessMethod.javaMethod.getName(), painlessMethod.typeParameters.size());
                    + typeToCanonicalTypeName(existingImportedPainlessMethod.returnType)
        for (Map.Entry<Class<?>, PainlessClassBuilder> painlessClassBuilderEntry : classesToPainlessClassBuilders.entrySet()) {  
            throw new IllegalArgumentException(  
                        + typesToCanonicalTypeNames(typeParameters)
            throw new IllegalArgumentException(  
                );
import static org.opensearch.painless.lookup.PainlessLookupUtility.buildPainlessFieldKey;
    private final Map<String, PainlessMethod> painlessMethodKeysToImportedPainlessMethods;  
        if (javaClasses.containsAll(painlessClasses) == false) {
                    + returnCanonicalTypeName  
                        + "[["
        }
                    + targetCanonicalClassName
                    + "], ["
 */  
        } else {
        addPainlessClassBinding(targetClass, methodName, returnType, typeParameters, annotations);
import static org.opensearch.painless.WriterConstants.DEF_TO_B_FLOAT_IMPLICIT;
        Class<?> targetClass = canonicalClassNamesToClasses.get(targetCanonicalClassName);
        Objects.requireNonNull(typeParameters);  
                nsme
            Class<?> typeParameter = canonicalTypeNameToType(canonicalTypeNameParameter);
                    + "["  
        try {
        try {
                else if (typeParameter == Double.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_DOUBLE_IMPLICIT);
                    + "[["  
                    + "] "  
            );
                    + "], ["  
                    + typesToCanonicalTypeNames(typeParameters)  
                    + methodName
                );
            } catch (ClassNotFoundException cnfe) {
                    throw new IllegalArgumentException(
                        + "], ["
            );
            if (isValidType(typeParameter) == false) {  
                    + "[["
                    + "[["
        }
        String targetJavaClassName,
                    + typeToCanonicalTypeName(javaMethod.getReturnType())  
                    || typeParameter == Float.class
                        + "[["  
                        + typeToCanonicalTypeName(typeParameter)
                        + methodName
                        + typesToCanonicalTypeNames(typeParameters)
import static org.opensearch.painless.WriterConstants.DEF_TO_B_LONG_IMPLICIT;
        List<String> canonicalTypeNameParameters
        Objects.requireNonNull(returnType);  
                    + typeToCanonicalTypeName(returnType)
                throw new IllegalArgumentException(  
                    || typeParameter == Character.class
            throw new IllegalArgumentException(
        else {
                        + "]",  
            classesToPainlessClasses,
                || existingPainlessMethod.targetClass != newPainlessMethod.targetClass  
                typeParameters.subList(0, numInjections).clear();
        if (painlessMethodKeysToPainlessInstanceBindings.containsKey(painlessMethodKey)) {
                        + "[["
        String origin = "internal error";
                        .isAssignableFrom(newPainlessField.javaField.getDeclaringClass())) {
                    + typeToCanonicalTypeName(existingPainlessInstanceBinding.returnType)
            javaTypeParameters.add(typeToJavaType(typeParameter));
import org.opensearch.painless.WriterConstants;
                    + typesToCanonicalTypeNames(typeParameters)  
                    + typesToCanonicalTypeNames(typeParameters)
                    + "] not found",
                    + "]"  
        }
            throw new IllegalArgumentException(
        }
        Objects.requireNonNull(methodName);
            } else if (importClassName == false) {  
            throw new IllegalArgumentException(
                        allowlistClass.javaClassName,
        }
        Objects.requireNonNull(targetCanonicalClassName);
            painlessMethodKeysToImportedPainlessMethods,
            javaTypeParameters.add(typeToJavaType(typeParameter));
                        + typeToCanonicalTypeName(typeParameter)  
        }
        }
                        + methodName
                    + "[["
                        + "], ["
                );
                );
                        throw new IllegalArgumentException("inconsistent no_import parameter found for class [" + canonicalClassName + "]");
                    + "] "  
                    + targetClass.getCanonicalName()  
        }
                    + "[["
                    + "], "
                    + typesToCanonicalTypeNames(typeParameters)
            throw new IllegalArgumentException("cannot add array type [" + canonicalClassName + "] as a class");  
                        );
                    + targetCanonicalClassName
                        + "] "
            typeParameters,
                    + targetCanonicalClassName  
            classesToPainlessClassBuilders.put(clazz, painlessClassBuilder);
            if (javaClass.isInterface()) {
                        painlessLookupBuilder.addPainlessField(
                        + targetCanonicalClassName
import java.lang.invoke.MethodHandles;
                else if (typeParameter == Short.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_SHORT_IMPLICIT);
        if (existingPainlessInstanceBinding == null) {  
                throw new IllegalArgumentException(  
            );
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
        List<Class<?>> typeParameters,  
                        + "], "
        if (targetClass == null) {
        String augmentedCanonicalClassName,
                    + "], ["  
                    "type parameter ["  
        }
        }  
                    + fieldName
    }
                throw new IllegalArgumentException(  
    private static final Map<PainlessMethod, PainlessMethod> painlessMethodCache = new HashMap<>();  
                    + "but do not have equivalent methods "
                if (typeParameter == Byte.class
        Objects.requireNonNull(classLoader);  
                    null,
            }
                    origin = allowlistInstanceBinding.origin;
                );
                        + "], ["
        if (annotations.containsKey(InjectConstantAnnotation.class)) {  
        if (targetClass == null) {
                    + "] not found"
                        + "]"
import static org.opensearch.painless.WriterConstants.OBJECT_TYPE;
                    + canonicalTypeNameParameters
                );
        if (targetClass.isInterface()) {  
                "reflection object not found for constructor "
                    + "], ["
                    + typesToCanonicalTypeNames(typeParameters)
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize + augmentedParameterOffset);
                else if (typeParameter == Float.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_FLOAT_IMPLICIT);  
                throw new IllegalArgumentException("class [" + javaClassName + "] not found", cnfe);  
                        + "], ["
                        + typesToCanonicalTypeNames(typeParameters)  
                    + "["
                        + "] not found "  
                    + methodName
            throw new IllegalArgumentException(
                    + canonicalClassName
            annotations  
            typeParameters,
        for (Class<?> childClass : parentClass.getInterfaces()) {
        }  
                        || typeParameter == Float.class  
                for (AllowlistInstanceBinding allowlistInstanceBinding : allowlist.allowlistInstanceBindings) {
            throw new IllegalArgumentException(  
            javaClassNamesToClasses,
                throw new IllegalArgumentException(
                    + typesToCanonicalTypeNames(typeParameters)
                            allowlistConstructor.painlessAnnotations
        List<String> canonicalTypeNameParameters,
        } else if (newPainlessMethod.equals(existingPainlessMethod) == false) {
                        + typesToCanonicalTypeNames(typeParameters)
                        + "[["  
        Objects.requireNonNull(returnType);
        if (typeParameter == null) {
import org.opensearch.painless.spi.AllowlistInstanceBinding;
    public void addPainlessClassBinding(
            if (existingPainlessField == null
            javaMethod = targetClass.getMethod(methodName, javaTypeParameters.toArray(new Class<?>[typeParametersSize]));  
                    "type parameter ["
        }  
                    + typeToCanonicalTypeName(javaMethod.getReturnType())  
                "invalid method name [" + methodName + "] for class binding [" + targetCanonicalClassName + "]."  
            annotations
        String methodName,  
            throw new IllegalArgumentException("class [" + targetJavaClassName + "] not found", cnfe);
    ) {
                    + targetCanonicalClassName  
            final Class<?>[] typeParameters = javaMethod.getParameterTypes();
                newPainlessField = painlessFieldCache.computeIfAbsent(newPainlessField, key -> key);
            );
                    + "["
                            + "], ["
import static org.opensearch.painless.WriterConstants.DEF_TO_B_SHORT_IMPLICIT;
                        + typesToCanonicalTypeNames(typeParameters)  
                    "type parameter ["
                    bridgeTypeParameters.toArray(new Class<?>[0])  
                    + typesToCanonicalTypeNames(typeParameters)
                        + "] "
        if (existingPainlessClassBuilder == null) {  
            targetInstance,  
                        + "] "
                    + "]"
        if (returnType == null) {
                    + typesToCanonicalTypeNames(existingPainlessClassBinding.typeParameters)  
            }
            );
                Opcodes.ASM5,
                    + fieldName
                    );
            }
                    + "], ["
        if (existingClass == null) {  
            } catch (Exception exception) {
                    + "[["  
        } catch (IllegalAccessException iae) {  
            }
                        + methodName
                && methodName.startsWith("get")
 * the Apache License, Version 2.0 (the "License"); you may
                    + targetCanonicalClassName
            throw new IllegalArgumentException(
                throw new IllegalArgumentException(
        }
        List<Class<?>> javaTypeParameters = new ArrayList<>(typeParametersSize);  
import org.opensearch.painless.spi.annotation.NoImportAnnotation;
                    + "]"  
                    + fieldName
                    painlessLookupBuilder.addPainlessClassBinding(  
                "invalid imported method name [" + methodName + "] for target class [" + targetCanonicalClassName + "]."
                    }
                    + "], ["
            );  
                    + "], "
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
                            allowlistMethod.returnCanonicalTypeName,  
            throw new IllegalArgumentException("imported method and instance binding cannot have the same name [" + methodName + "]");
            }
            }
                        + "], "
                        + canonicalTypeNameParameter  
                        allowlistInstanceBinding.targetInstance,
                    iae
        if (isValidType(returnType) == false) {
                    "class ["  
                    + "]",  
                        + "]"
}
                    null  
            throw new IllegalArgumentException("class binding and imported method cannot have the same name [" + methodName + "]");
    private void cacheRuntimeHandles(PainlessClassBuilder painlessClassBuilder) {
                        + "]"  
    }
                    + methodName
     * run-time resulting from calls with a def type value target.
                );  
    ) {
                    + "], "  
                        );  
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {  
                    + targetCanonicalClassName
                    + methodName
 * software distributed under the License is distributed on an
    private final Map<Class<?>, PainlessClassBuilder> classesToPainlessClassBuilders;
        Objects.requireNonNull(methodName);
            javaClassNamesToClasses.put(targetClass.getName().intern(), targetClass);
                        + "[["
                    + methodName
                methodHandle = MethodHandles.publicLookup().in(targetClass).unreflect(javaMethod);
            throw new IllegalArgumentException(  
                    + targetCanonicalClassName
                        + "] and "
                painlessClassBuilder.runtimeMethods.put(painlessMethodKey.intern(), bridgePainlessMethod);  
        }  
            );  
        Objects.requireNonNull(methodName);
                newPainlessField = painlessFieldCache.computeIfAbsent(newPainlessField, key -> key);
            return Def.class.getName().equals(name) ? Def.class : super.findClass(name);
        return type == def.class || classesToPainlessClassBuilders.containsKey(type);
    public void addPainlessClass(ClassLoader classLoader, String javaClassName, boolean importClassName) {
                && methodName.startsWith("is")  
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);  
                    + "]"
                MethodHandle bridgeHandle = MethodHandles.publicLookup().in(bridgeClass).unreflect(bridgeClass.getMethods()[0]);
                    + returnCanonicalTypeName
                        + typeToCanonicalTypeName(typeParameter)
        String returnCanonicalTypeName,
            classesToPainlessClasses.put(painlessClassBuilderEntry.getKey(), painlessClassBuilderEntry.getValue().build());  
        try {  
                    for (AllowlistField allowlistField : allowlistClass.allowlistFields) {  
            MethodType bridgeMethodType = MethodType.methodType(painlessMethod.returnType, bridgeTypeParameters);  
            }
            bridgeConstructorWriter.returnValue();  
                    + targetClass.getCanonicalName()  
                    exception
                    + "], "
                    + "], "  
                    + "], ["
        if (existingClass != null && existingClass != clazz) {
        Class<?> targetClass,  
        PainlessMethod bridgePainlessMethod = painlessBridgeCache.get(painlessMethod);
            throw new IllegalArgumentException("instance binding and imported method cannot have the same name [" + methodName + "]");  
                        + typeToCanonicalTypeName(typeParameter)
                    + "] "
                        + "]"
                    + "does not match the specified type parameter ["
                "class binding [["
                    + "], "
                    + targetCanonicalClassName
                    "cannot add fields with the same name but are not equivalent for fields "
        MethodType methodType = methodHandle.type();  
                if (typeParameter == Byte.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_BYTE_IMPLICIT);
            throw new IllegalArgumentException(  
                "cannot add methods with the same name and arity but are not equivalent for methods "  
        } catch (NoSuchMethodException nsme) {
 * GitHub history for details.
                    + methodName  
    }
        }
            while (childClass != null) {
        for (Method eachJavaMethod : javaMethods) {
                    }  
        }
            MethodWriter bridgeMethodWriter = new MethodWriter(
                    + "[["
        addPainlessConstructor(targetClass, typeParameters, annotations);
            }
        for (Map.Entry<String, PainlessField> painlessFieldEntry : originalPainlessClassBuilder.fields.entrySet()) {  
                    );
                    && existingPainlessMethod.targetClass.isAssignableFrom(newPainlessMethod.targetClass)) {
        }
                throw new IllegalArgumentException("must use no_import parameter on class [" + canonicalClassName + "] with no package");  
                    + "], "  
    }
            bridgeConstructorWriter.loadThis();
        }
            try {
                throw new IllegalArgumentException(  
        MethodType methodType = methodHandle.type();
import java.lang.reflect.Modifier;
                        + "] and ["
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
                    + "[["
        }  
            throw new IllegalArgumentException(
                "class ["  
            } else if (newPainlessField.equals(existingPainlessField) == false) {
                    + "] and "
            javaTypeParameters.add(typeToJavaType(typeParameter));  
        }
        Map<Class<?>, Object> annotations
        for (Constructor<?> eachJavaConstructor : javaConstructors) {
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);
                        + methodName
        String painlessMethodKey = buildPainlessMethodKey(methodName, typeParametersSize);  
                        + "]"
                    + "[["
        List<String> canonicalTypeNameParameters,
import java.lang.invoke.MethodHandle;
                            + typesToCanonicalTypeNames(typeParameters)
                        + "for constructor [["  
        Set<Class<?>> painlessClasses = classesToPainlessClasses.keySet();
            methodHandle,  
                        + typeToCanonicalTypeName(importedClass)  
            );
            if (eachJavaMethod.getDeclaringClass() == targetClass) {
    private void cacheRuntimeHandles() {
            newImportedPainlessMethod = painlessMethodCache.computeIfAbsent(newImportedPainlessMethod, key -> key);  
                        + "] "
            throw new RuntimeException(mue);
                    }  
            );  
            }  
 * Licensed to Elasticsearch under one or more contributor  
 *
            for (java.lang.reflect.Method javaMethod : targetClass.getMethods()) {  
                    if (typeParameter == Byte.class
                    + "]"  
            }  
                bridgeClassName,  
                    + typesToCanonicalTypeNames(typeParameters)
        } else if (existingTargetClass != targetClass) {
        for (Class<?> typeParameter : typeParameters) {
        }  
        );  
            }
                "target class ["
                    + "], ["
        }  
                }
        }
        Map<Class<?>, Object> annotations  
        if (returnType == null) {
import static org.opensearch.painless.lookup.PainlessLookupUtility.typeToJavaType;
                }  
                for (Class<?> typeParameter : painlessMethod.typeParameters) {  
            } catch (NoSuchMethodException nsme) {
                    + "]"
        Class<?> targetClass = targetInstance.getClass();  
        PainlessMethod newPainlessMethod = new PainlessMethod(
import static org.opensearch.painless.WriterConstants.DEF_TO_B_BYTE_IMPLICIT;
    /**
                );  
        }
            GeneratorAdapter bridgeConstructorWriter = new GeneratorAdapter(
                throw new IllegalArgumentException(
        Objects.requireNonNull(classLoader);  
                    bridgeTypeParameters.add(Object.class);  
    public void addPainlessInstanceBinding(Object targetInstance, String methodName, Class<?> returnType, List<Class<?>> typeParameters) {  
    public void addPainlessField(Class<?> targetClass, String fieldName, Class<?> typeParameter) {
            canonicalClassNamesToClasses,  
            if (isStatic == false) {  
        }  
            bridgeClassWriter.visit(  
                    + "["  
                        + targetClass.getCanonicalName()
import org.opensearch.painless.Def;
    }
                clazz = Class.forName(javaClassName, true, classLoader);
                    "type parameter ["
                    + typesToCanonicalTypeNames(typeParameters)  
                    Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4),
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
        }  
                            allowlistMethod.canonicalTypeNameParameters,
    }
                    + targetClass.getCanonicalName()  
                    + "] "  
        String returnCanonicalTypeName,
                    + "["
    }
    }
        addPainlessClass(clazz, importClassName);
                        + targetCanonicalClassName
                    + "], ["  
                );  
                    + "], "
                    + typesToCanonicalTypeNames(typeParameters)
        int typeParametersSize = typeParameters.size();
import java.util.List;
    public void addPainlessInstanceBinding(  
     * {@link Map}. The {@link PainlessClass#runtimeMethods} {@link Map} is used exclusively to look up methods at
                    + "], "  
                        + typeToCanonicalTypeName(javaTypeParameter)  
import org.objectweb.asm.ClassWriter;  
                    + "]]"
            typeParameters  
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
        } else if (existingClass != clazz) {
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);  
/*  
import static org.opensearch.painless.WriterConstants.DEF_UTIL_TYPE;  
        Class<?> targetClass = targetInstance.getClass();  
                        + "], ["
                    );  
        Objects.requireNonNull(targetCanonicalClassName);
                    + "for imported method [["
    private static final Map<PainlessConstructor, PainlessConstructor> painlessConstructorCache = new HashMap<>();
                        + "] not found "
        try {
     * with a boxed type to cast from other numeric primitive/boxed types in a symmetric was not handled by  
                        + "is illegally marked as a FunctionalInterface with java methods "  
                String painlessMethodKey = buildPainlessMethodKey(javaMethod.getName(), javaMethod.getParameterCount());
        Method[] javaMethods = targetClass.getMethods();
                    + "] and "
                    + "] "  
            }
        if (javaField.getType() != typeToJavaType(typeParameter)) {  
                    + "], "
                    + targetCanonicalClassName  
        }  
    }
        Objects.requireNonNull(targetJavaClassName);
 */
                    bridgeTypeParameters.add(typeParameter);
                    + targetCanonicalClassName
                    + canonicalTypeNameParameter
            if (importedClass == null) {
import static org.opensearch.painless.lookup.PainlessLookupUtility.DEF_CLASS_NAME;
    }
        for (Class<?> typeParameter : typeParameters) {
        }  
                        + "] not found for method "  
        addPainlessMethod(targetClass, augmentedClass, methodName, returnType, typeParameters, annotations);
                "instance binding reflection object [["  
                    + "] not found for class binding "
 * SPDX-License-Identifier: Apache-2.0
        Objects.requireNonNull(targetJavaClassName);
        }  
            returnType,
            targetClass,  
                    "reflection object not found for method "
                    + "], "
                        + "for class binding [["  
                    + "], ["
    }
                    + "], "
                    "type parameter ["
    }  
                    }
                        + importedCanonicalClassName
        try {  
                        + "for constructor [["
            typeParameters.add(typeParameter);
                else if (typeParameter == Long.class) bridgeMethodWriter.invokeStatic(DEF_UTIL_TYPE, DEF_TO_B_LONG_IMPLICIT);
            );  
                throw new IllegalArgumentException(
                    + typeToCanonicalTypeName(returnType)
        Method javaMethod = null;
        }
                    + targetCanonicalClassName
                } else if (typeParametersSize == 1
            returnType,
                    + "], "  
                    + "["
                "class ["  
        if (javaConstructor == null) {
                        + "]"
                    + "[["  
                if (classesToPainlessClassBuilders.containsKey(childClass)) {  
        }
                    + "] "
            throw new IllegalArgumentException(
        MethodHandle methodHandle;
                    + "]"
                    + typeToCanonicalTypeName(typeParameter)  
        painlessMethodKeysToPainlessInstanceBindings = new HashMap<>();
                throw new IllegalArgumentException(
        if (canonicalClassName.equals(importedCanonicalClassName)) {
    }
                    + canonicalTypeNameParameters  
                        + "]"
            throw new IllegalArgumentException(  
                        + canonicalTypeNameParameter
 * You may obtain a copy of the License at  
        }
        String targetCanonicalClassName,
                        + typeToCanonicalTypeName(typeParameter)  
        }
                painlessClassBuilder.getterMethodHandles.putIfAbsent(
        if (augmentedClass == null) {  
        Method javaMethod;  
                        + "], "
            if (existingPainlessField == null) {
            }  
                    + "], "  
            bridgeClassWriter.visitEnd();
                    + targetCanonicalClassName  
            int typeParametersSize = painlessMethod.typeParameters.size();
            );
            targetClass,  
                }  
        String painlessMethodKey = buildPainlessMethodKey(methodName, constructorTypeParametersSize + methodTypeParametersSize);
                    + "], "
        );  
                    + "]"  
                    + "[["
        ClassLoader classLoader,
            throw new IllegalArgumentException("class binding [" + targetCanonicalClassName + "] must have exactly one method");  
        Objects.requireNonNull(canonicalTypeNameParameters);
        if (isValidType(typeParameter) == false) {  
                        + typeToCanonicalTypeName(augmentedClass)
     * Creates a {@link Map} of PainlessMethodKeys to {@link PainlessMethod}s per {@link PainlessClass} stored as  
            bridgeMethodWriter.visitCode();
                        + "]",
        }
                        + "] not found for method "
                "class ["
        } else {
import java.lang.reflect.Constructor;
            }  
        for (PainlessClassBuilder painlessClassBuilder : classesToPainlessClassBuilders.values()) {
        else if ("byte".equals(javaClassName)) clazz = byte.class;
                    + "[["
            throw new IllegalArgumentException("instance binding and class binding cannot have the same name [" + methodName + "]");
    }  
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
        }  
        } catch (NoSuchMethodException nsme) {
            throw new IllegalArgumentException("cannot add instance binding as reserved class [" + DEF_CLASS_NAME + "]");  
                    + "], "  
            );
                        javaMethods.add(javaMethod);
                        + typeToCanonicalTypeName(typeParameter)
        Objects.requireNonNull(targetClass);  
                    + "for constructor [["  
        String painlessMethodKey = buildPainlessMethodKey(methodName, typeParametersSize);  
            throw new IllegalArgumentException("invalid class name [" + canonicalClassName + "]");
            );
                    + "], ["
    public void addPainlessMethod(
        Class<?> existingTargetClass = javaClassNamesToClasses.get(targetClass.getName());  
                    + "["  
                copyPainlessClassMembers(Object.class, javaClass);
        }
            CODESOURCE = new CodeSource(URI.create("file:" + BootstrapInfo.UNTRUSTED_CODEBASE).toURL(), (Certificate[]) null);  
        } catch (ClassNotFoundException cnfe) {
            throw new IllegalArgumentException(
                    + "], ["  
                "cannot add class bindings with the same name and arity "
                for (AllowlistClassBinding allowlistClassBinding : allowlist.allowlistClassBindings) {
 * Unless required by applicable law or agreed to in writing,
    }  
                    + "], ["  
                        + typeToCanonicalTypeName(typeParameter)
        if (augmentedClass != null) {  
                    bridgeHandle,
            );
        @Override
        copyPainlessClassMembers();
        Objects.requireNonNull(canonicalTypeNameParameters);
                "method handle not found for constructor "
                        || typeParameter == Double.class) {
                            + targetCanonicalClassName  
    }
import java.util.ArrayList;
            }
                    + "], "
        } else {
            if (isValidType(typeParameter) == false) {
            if (Modifier.isFinal(javaField.getModifiers()) == false) {
        }
        if (targetClass == def.class) {
                    || typeParameter == Integer.class
            throw new IllegalArgumentException(
            cacheRuntimeHandles(painlessClassBuilder);  
                );
                    + targetClass.getCanonicalName()
                        + typesToCanonicalTypeNames(typeParameters)
            try {  
                    + targetCanonicalClassName  
        BridgeLoader(ClassLoader parent) {
        }  
    }  
        Class<?> targetClass;  
                    + "]"
                    + methodName
            throw new IllegalArgumentException(
            bridgeMethodWriter.returnValue();
                "cannot add imported methods with the same name and arity "
                "target class ["
        Objects.requireNonNull(targetInstance);
        Class<?> returnType = canonicalTypeNameToType(returnCanonicalTypeName);
            if (isValidType(typeParameter) == false) {  
        MethodType methodType = methodHandle.type();
    private void generateBridgeMethod(PainlessClassBuilder painlessClassBuilder, PainlessMethod painlessMethod) {  
    public static PainlessLookup buildFromAllowlists(List<Allowlist> allowlists) {  
import org.opensearch.painless.spi.AllowlistField;  
    private static final Pattern CLASS_NAME_PATTERN = Pattern.compile("^[_a-zA-Z][._a-zA-Z0-9]*$");  
                        + targetCanonicalClassName
        }  
        }
                        allowlistClassBinding.methodName,  
                painlessClassBuilder.fields.put(painlessFieldKey.intern(), newPainlessField);  
                    painlessLookupBuilder.addPainlessInstanceBinding(  
        Objects.requireNonNull(returnType);
        int constructorTypeParametersSize = javaConstructor.getParameterCount();
            if (typeParameter == null) {  
            throw new IllegalArgumentException(
                        + targetCanonicalClassName
                    + "], "
                    + "], ["
                        + "], "  
            annotations
                        + "]"
                    + "["  
import org.opensearch.bootstrap.BootstrapInfo;
                        + "["  
            int bridgeClassFrames = ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;
        try {
            } else {
            typeParameters,
import java.util.regex.Pattern;  
        if (targetClass == def.class) {
                        + "with augmented class ["
        if (existingPainlessMethod == null) {
        try {
            MethodHandle methodHandleSetter;  
            if (typeParameter == null) {
                        + "]"  
                    + typeToCanonicalTypeName(existingPainlessClassBinding.returnType)
            }
            String painlessFieldKey = painlessFieldEntry.getKey();
                        origin = allowlistField.origin;
        }  
        }
                    + "[["
        String methodName,
                    canonicalClassNamesToClasses.put(importedCanonicalClassName.intern(), clazz);
                        + targetCanonicalClassName
                    + "does not match the specified returned type ["  
                    + targetCanonicalClassName
                    + methodName
                        "class binding [" + targetCanonicalClassName + "] cannot have multiple constructors"
 *
            throw new IllegalArgumentException("cannot add reserved class [" + DEF_CLASS_NAME + "]");  
                        + "] "  
        Class<?> targetClass,
        Objects.requireNonNull(returnCanonicalTypeName);  
                    + "], ["  
        Objects.requireNonNull(classLoader);  
        for (int typeParameterIndex = 0; typeParameterIndex < methodTypeParametersSize; ++typeParameterIndex) {
        try {
        for (Map.Entry<String, PainlessMethod> painlessMethodEntry : painlessClassBuilder.methods.entrySet()) {
            throw new IllegalArgumentException(
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
                    + "] not found for method "
            PainlessField existingPainlessField = targetPainlessClassBuilder.fields.get(painlessFieldKey);  
    }  
        if (javaMethod == null) {
        if (METHOD_NAME_PATTERN.matcher(methodName).matches() == false) {
                        + "] "
                        + "] not found "
import org.opensearch.painless.spi.AllowlistMethod;
                    + "], "
                        + "], "  
                        + "], ["
            javaTypeParameters.add(targetClass);
                "return type ["
        Class<?> augmentedClass = null;
        }  
    }
        } else if (newImportedPainlessMethod.equals(existingImportedPainlessMethod) == false) {
                    + "], "
        }  
                if (javaMethod.isDefault() == false && Modifier.isStatic(javaMethod.getModifiers()) == false) {
            if (javaTypeParameter != typeToJavaType(typeParameter)) {  
            throw new IllegalArgumentException(
                    + "for method [["  
import java.net.MalformedURLException;
        List<Class<?>> typeParameters,  
        Objects.requireNonNull(originalPainlessClassBuilder);  
                );
            } else if (newPainlessField.equals(existingPainlessField) == false) {  
                    + "] "
                    + typesToCanonicalTypeNames(existingPainlessMethod.typeParameters)
                    + typeToCanonicalTypeName(returnType)  
import java.net.URI;  
            if (importClassName) {
        }  
                        + canonicalTypeNameParameters  
                    + typesToCanonicalTypeNames(typeParameters)  
            methodHandle = MethodHandles.publicLookup().in(targetClass).unreflect(javaMethod);
        }  
            }  
            javaField = targetClass.getField(fieldName);
                    bridgeTypeParameters,
        }
    // of the values of javaClassNamesToClasses.
                        + targetCanonicalClassName
    public void addPainlessMethod(
                    throw new IllegalArgumentException(
    private static final Pattern METHOD_NAME_PATTERN = Pattern.compile("^[_a-zA-Z][_a-zA-Z0-9]*$");
        String painlessFieldKey = buildPainlessFieldKey(fieldName);
            );
            }
                    + targetCanonicalClassName
                    Collections.emptyMap()
                        + "]"
                    + "but do not have equivalent methods "  
            annotations  
                }
        if (Modifier.isStatic(javaMethod.getModifiers()) == false) {  
                    + typesToCanonicalTypeNames(typeParameters)
    private void generateRuntimeMethods() {
        }
        if (augmentedClass == null) {
                    bridgeConstructorType.getName(),  
        }  
            PainlessMethod newPainlessMethod = painlessMethodEntry.getValue();
        try {  
                && methodName.length() > 3
            javaMethod,
                throw new IllegalArgumentException(  
                        + "for class binding [["  
        }
                );  
    // including classes used as part of imported methods and class bindings but not necessarily allowlisted
        }
                new org.objectweb.asm.commons.Method(painlessMethod.javaMethod.getName(), bridgeMethodType.toMethodDescriptorString()),  
                    + methodName
                    + targetCanonicalClassName
                    nsme
            }  
        Object targetInstance,
        } else {
            );  
                    + "[["
        PainlessClassBuilder painlessClassBuilder = classesToPainlessClassBuilders.get(targetClass);
                    "type parameter ["
            );  
            throw new IllegalArgumentException(
                        + "]",
                    + "] and "
            throw new IllegalArgumentException(
            PainlessField existingPainlessField = painlessClassBuilder.staticFields.get(painlessFieldKey);  
        Class<?> existingTargetClass = javaClassNamesToClasses.get(targetClass.getName());
                "imported method reflection object [["  
                        + "], "
                    + targetCanonicalClassName
                    + "but do not have equivalent methods "  
            methodType,
            typeParameters.add(typeParameter);
        if (existingPainlessConstructor == null) {  
                        + targetCanonicalClassName  
                OBJECT_TYPE.getInternalName(),
        if (painlessClassBuilder == null) {
        String targetCanonicalClassName = typeToCanonicalTypeName(targetClass);
    }
        } catch (NoSuchMethodException nsme) {
import java.lang.invoke.MethodType;  
        }  
                "return type ["  
                    bridgePainlessMethod.methodHandle  
                        + typesToCanonicalTypeNames(typeParameters)  
            );  
    private final Map<String, PainlessClassBinding> painlessMethodKeysToPainlessClassBindings;
                    + "], ["  
                Class<?> typeParameter = typeParameters[typeParameterCount];
                        allowlistStatic.canonicalTypeNameParameters,
                throw new IllegalArgumentException(
            if (classesToPainlessClassBuilders.containsKey(childClass)) {  
        // injections alter the type parameters required for the user to call this method, since some are injected by compiler
        if (Modifier.isStatic(javaMethod.getModifiers())) {  
                    + "], "
                        + "]"
        for (Class<?> javaClass : classesToPainlessClassBuilders.keySet()) {  
            }
        }
        if (targetClass == def.class) {
        }
            for (PainlessMethod painlessMethod : painlessClassBuilder.runtimeMethods.values()) {
                    "cannot add fields with the same name but are not equivalent for fields "  
            );  
                    + "], ["
            PainlessMethod existingPainlessMethod = targetPainlessClassBuilder.methods.get(painlessMethodKey);  
                    + "["  
        } catch (Exception exception) {
                }  
            if (javaMethods.size() != 1 && targetClass.isAnnotationPresent(FunctionalInterface.class)) {
                            + methodName
        List<Class<?>> typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
        existingClass = canonicalClassNamesToClasses.get(canonicalClassName);
                    + "], ["
            javaConstructor,
import org.opensearch.painless.spi.AllowlistClass;  
                    + methodName  
     * A generated bridge method replaces the method its a bridge to in the {@link PainlessClass#runtimeMethods}  
            }
                nsme
        Objects.requireNonNull(clazz);
                    + "], ["
            painlessMethodKeysToPainlessClassBindings,  
        PainlessClassBuilder existingPainlessClassBuilder = classesToPainlessClassBuilders.get(clazz);
            );
        Map<Class<?>, Object> annotations  
        }
                bridgeConstructorType,  
                        + "[["  
    private static final class BridgeLoader extends SecureClassLoader {  
                        + targetCanonicalClassName  
                        allowlistStatic.methodName,  
                        + canonicalTypeNameParameters
                        + "], "  
            );
            throw new IllegalArgumentException(  
import org.opensearch.painless.spi.AllowlistConstructor;
                        + typeToCanonicalTypeName(typeParameter)  
                        bridgePainlessMethod.methodHandle
        }
                    }  
                        allowlistInstanceBinding.methodName,
                bridgeTypeParameters.add(javaMethod.getDeclaringClass());
            throw new IllegalArgumentException("imported method and class binding cannot have the same name [" + methodName + "]");  
        classesToPainlessClassBuilders = new HashMap<>();
                        + targetCanonicalClassName  
            int numInjections = ((InjectConstantAnnotation) annotations.get(InjectConstantAnnotation.class)).injects.size();
                        + "]"  
                    + "[["
        Objects.requireNonNull(targetInstance);
        if (painlessClassBuilder == null) {  
        if (javaMethod.getReturnType() != typeToJavaType(returnType)) {
                        + "with augmented class ["  
        } else if (newPainlessInstanceBinding.equals(existingPainlessInstanceBinding) == false) {  
                    + typeToCanonicalTypeName(typeParameter)  
                    bridgeMethodType,  
                    + typesToCanonicalTypeNames(typeParameters)  
            throw new IllegalArgumentException("class binding and instance binding cannot have the same name [" + methodName + "]");  
        PainlessMethod existingPainlessMethod = isStatic
            PainlessClassBuilder painlessClassBuilder = new PainlessClassBuilder();
                    painlessLookupBuilder.addImportedPainlessMethod(  
        PainlessMethod existingImportedPainlessMethod = painlessMethodKeysToImportedPainlessMethods.get(painlessMethodKey);  
            throw new IllegalArgumentException(
        Class<?> targetClass = canonicalClassNamesToClasses.get(targetCanonicalClassName);  
                throw new IllegalArgumentException(
                    + typesToCanonicalTypeNames(typeParameters)  
                    + "] "  
            throw new IllegalArgumentException(
                for (AllowlistMethod allowlistStatic : allowlist.allowlistImportedMethods) {
                    try {
                    + canonicalTypeNameParameters
        }
import java.security.SecureClassLoader;
                    + targetCanonicalClassName
                    + "["
                    + "], "
                childClass = childClass.getSuperclass();
            List<java.lang.reflect.Method> javaMethods = new ArrayList<>();
        for (String canonicalTypeNameParameter : canonicalTypeNameParameters) {
                "imported method handle [["
        Class<?> existingClass = javaClassNamesToClasses.get(clazz.getName());
                    + methodName
                    + "], ["
                );  
    private void copyPainlessClassMembers(Class<?> originalClass, Class<?> targetClass) {
        return painlessLookupBuilder.build();  
                    } catch (ReflectiveOperationException roe) {
                    + "[["  
    private final Map<String, PainlessInstanceBinding> painlessMethodKeysToPainlessInstanceBindings;
                    for (AllowlistConstructor allowlistConstructor : allowlistClass.allowlistConstructors) {
import static org.opensearch.painless.lookup.PainlessLookupUtility.typeToCanonicalTypeName;  
        Map<Class<?>, Object> annotations
                }
        Class<?> returnType,
        while (type.getComponentType() != null) {
                    + methodName
        Objects.requireNonNull(targetClass);
                    "method handle not found for method "  
import static org.opensearch.painless.lookup.PainlessLookupUtility.buildPainlessMethodKey;
        Method javaMethod;
                    + "]"
                        painlessLookupBuilder.addPainlessMethod(
        } catch (IllegalAccessException iae) {
            typeParameters.add(typeParameter);
            setFunctionalInterfaceMethod(painlessClassBuilderEntry.getKey(), painlessClassBuilderEntry.getValue());
                    + "] and "  
                null,
        if (canonicalClasses.equals(painlessClasses) == false) {
                    + "does not match the specified returned type ["
        String targetCanonicalClassName = targetClass.getCanonicalName();
                    + "] and "
    private static final Map<PainlessMethod, PainlessMethod> painlessBridgeCache = new HashMap<>();
                if (importClassName) {  
                throw new IllegalArgumentException(
                    + "]"
                        + "for class binding [["
                        allowlist.classLoader,
            returnType,
            );
                bridgeClassWriter,
            int bridgeClassAccess = Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_FINAL;  
            returnType,
