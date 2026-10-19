                GeneratorAdapter adapter = new GeneratorAdapter(
            compilerSettings.setRegexesEnabled(defaultCompilerSettings.areRegexesEnabled());
                "An internal error occurred attempting to define the factory class [" + className + "].",
        for (Method method : context.factoryClazz.getMethods()) {
        Map<List<Allowlist>, PainlessLookup> allowlistsToLookups = new HashMap<>();
                break;
            }
                if (originalOffset == -1) {
        GeneratorAdapter deterAdapter = new GeneratorAdapter(
import org.opensearch.painless.lookup.PainlessLookup;
        parameters.addAll(Arrays.asList(newInstance.getParameterTypes()));
        if (context.statefulFactoryClazz != null) {
                compilerSettings.setMaxLoopCounter(Integer.parseInt(value));
            methodName,
            ScriptContext<?> context = entry.getKey();
import org.objectweb.asm.Opcodes;
import java.util.Collections;
        // create a script stack: this is just the script portion
        Method newInstance = null;
        final Class<?>[] parameterTypes = newFactory.getParameterTypes();
            MethodType.methodType(void.class).toMethodDescriptorString()
                exception
        );
            MethodType.methodType(void.class).toMethodDescriptorString()
        org.objectweb.asm.commons.Method constru = new org.objectweb.asm.commons.Method(
        }
        );
        adapter.invokeConstructor(classType, constru);
        ScriptScope scriptScope = compile(contextsToCompilers.get(context), loader, scriptName, scriptSource, params);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                newFactory = method;
        adapter.invokeConstructor(WriterConstants.CLASS_TYPE, constru);
        constructor.loadThis();
            writer.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, instance.getName(), instance.getDescriptor(), null, null)
        constructor.endMethod();
        } catch (OutOfMemoryError | StackOverflowError | VerifyError | Exception e) {
            return AccessController.doPrivileged(() -> {
import java.util.List;
            );
                    if (startOffset > 0) {
                        pointer.append("    ");
                        snippet.append(" ...");
        Map<ScriptContext<?>, Compiler> contextsToCompilers = new HashMap<>();
    public Map<ScriptContext<?>, PainlessLookup> getContextsToLookups() {
                    }
                docAdapter.push(scriptScope.docFields().get(i));
 * Unless required by applicable law or agreed to in writing,
    /**
            "<init>",
 * GitHub history for details.
                reflect = method;
        return Math.min(scriptSource.length(), offset + 25);
                new Compiler(context.instanceClazz, context.factoryClazz, context.statefulFactoryClazz, lookup)
            MethodType.methodType(reflect.getReturnType(), parameterTypes).toMethodDescriptorString()
        for (Method method : clazz.getMethods()) {
        String methodName = "isResultDeterministic";
                }
import static org.opensearch.painless.WriterConstants.OBJECT_TYPE;
                throw new IllegalArgumentException("[painless.regex.enabled] can only be set on node startup.");
package org.opensearch.painless;
        defaultCompilerSettings.setRegexLimitFactor(CompilerSettings.REGEX_LIMIT_FACTOR.get(settings));
        org.objectweb.asm.commons.Method instance = new org.objectweb.asm.commons.Method(
        org.objectweb.asm.commons.Method init = new org.objectweb.asm.commons.Method(
        List<Class<?>> parameters = new ArrayList<>(Arrays.asList(parameterTypes));
                    }
                    int offset = --originalOffset; // offset is 1 based, line numbers must be!
            docAdapter.endMethod();
            writer.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, instance.getName(), instance.getDescriptor(), null, null)
            }
        adapter.dup();
            if (WriterConstants.CLASS_NAME.equals(element.getClassName())) {
        writer.visitEnd();
            MethodType.methodType(void.class, parameters.toArray(new Class<?>[] {})).toMethodDescriptorString()
                    pos = new ScriptException.Position(originalOffset, startOffset, endOffset);
                    StringBuilder pointer = new StringBuilder();
            instance,
    }
            init,
            }
            }
/*
            } else if ("newFactory".equals(method.getName())) {
    }
        final Class<?>[] parameterTypes = reflect.getParameterTypes();
     * @return A factory class that will return script instances.
                );
            return generateFactory(loader, context, WriterConstants.CLASS_TYPE, scriptScope);
        );
    /**
            docAdapter.newInstance(WriterConstants.ARRAY_LIST_TYPE);
            Opcodes.ASM5,
        adapter.loadArgs();
            writer.visitMethod(Opcodes.ACC_PUBLIC, methodName, isResultDeterministic.getDescriptor(), null, null)
                name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
 * SPDX-License-Identifier: Apache-2.0
 */
            }
        } catch (Exception exception) {
            docAdapter.visitCode();
    }
            String value = copy.remove(CompilerSettings.MAX_LOOP_COUNTER);
        org.objectweb.asm.commons.Method isResultDeterministic = new org.objectweb.asm.commons.Method(
            constructor.loadThis();
/*
        GeneratorAdapter adapter = new GeneratorAdapter(
        defaultCompilerSettings.setRegexesEnabled(CompilerSettings.REGEX_ENABLED.get(settings));
        writer.visitEnd();
    private void writeNeedsMethods(Class<?> clazz, ClassWriter writer, Set<String> extractedVariables) {
                        snippet.append("... ");
                context,
            // Catch everything to let the user know this is something caused internally.
        int classAccess = Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_FINAL;
            "<init>",
        return Type.getType("L" + className + ";");
                MethodType.methodType(List.class).toMethodDescriptorString()
    private int getPreviousStatement(int offset) {
        }
        GeneratorAdapter adapter = new GeneratorAdapter(
        );
        adapter.dup();
    public Set<ScriptContext<?>> getSupportedContexts() {
            writer.visitMethod(Opcodes.ACC_PUBLIC, init.getName(), init.getDescriptor(), null, null)
     * @param context The {@link ScriptContext}'s semantics are used to define the factory class.
            List<Allowlist> allowlists = List.copyOf(entry.getValue());
        );
        }
        for (Map.Entry<ScriptContext<?>, List<Allowlist>> entry : contexts.entrySet()) {
                    method.getName(),
        for (int count = 0; count < parameterTypes.length; ++count) {
        adapter.newInstance(WriterConstants.CLASS_TYPE);
        deterAdapter.visitCode();
            Opcodes.ASM5,
        Method newFactory = null;
    private CompilerSettings buildCompilerSettings(Map<String, String> params) {
            if (!copy.isEmpty()) {
    }
        writeNeedsMethods(context.statefulFactoryClazz, writer, scriptScope.getUsedVariables());
        }
        );
        adapter.endMethod();
 */
                    if (startOffset > 0) {
public final class PainlessScriptEngine implements ScriptEngine {
            writer.visitMethod(Opcodes.ACC_PUBLIC, init.getName(), init.getDescriptor(), null, null)
    public String getType() {
        org.objectweb.asm.commons.Method base = new org.objectweb.asm.commons.Method(
        try {
        adapter.returnValue();
            MethodType.methodType(newInstance.getReturnType(), newInstance.getParameterTypes()).toMethodDescriptorString()
        String interfaceBase = Type.getType(context.factoryClazz).getInternalName();
 * this work for additional information regarding copyright
        adapter.loadArgs();
        }
     * to create new instances of the {@link ScriptContext#instanceClazz} or uses the newFactory method
        return compilerSettings;
     * Generates a stateful factory class that will return script instances.  Acts as a middle man between
            }
        String className = interfaceBase + "$StatefulFactory";
    ScriptScope compile(Compiler compiler, Loader loader, String scriptName, String source, Map<String, String> params) {
            compilerSettings.setRegexLimitFactor(defaultCompilerSettings.getRegexLimitFactor());
        String interfaceBase = Type.getType(context.statefulFactoryClazz).getInternalName();
        }
                );
                    if (endOffset < scriptSource.length()) {
            GeneratorAdapter docAdapter = new GeneratorAdapter(
                docAdapter.dup();
import java.lang.reflect.Method;
                String name = method.getName();
        constructor.endMethod();
        writeNeedsMethods(context.factoryClazz, writer, scriptScope.getUsedVariables());
            MethodType.methodType(void.class, parameterTypes).toMethodDescriptorString()
}
                adapter.visitCode();
import org.opensearch.painless.Compiler.Loader;
                docAdapter.invokeInterface(WriterConstants.LIST_TYPE, WriterConstants.LIST_ADD);
            value = copy.remove(CompilerSettings.PICKY);
     * of {@link PainlessScriptEngine#PainlessScriptEngine(Settings, Map)}.
            Map<String, String> copy = new HashMap<>(params);
            if (value != null) {
 * software distributed under the License is distributed on an
    private final Map<ScriptContext<?>, PainlessLookup> contextsToLookups;
        String[] classInterfaces = new String[] { interfaceBase };
                Opcodes.ASM5,
import java.lang.invoke.MethodType;
     * Generates a factory class that will return script instances or stateful factories.
        } else {
 * The OpenSearch Contributors require contributions made to
        List<String> scriptStack = new ArrayList<>();
                Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,
            if ("newInstance".equals(method.getName())) {
                throw new IllegalArgumentException("[painless.regex.limit-factor] can only be set on node startup.");
        org.objectweb.asm.commons.Method instance = new org.objectweb.asm.commons.Method(
                docFieldsReflect.getName(),
            docAdapter.invokeConstructor(WriterConstants.ARRAY_LIST_TYPE, WriterConstants.ARRAY_LIST_CTOR_WITH_SIZE);
     */
                return compiler.compile(loader, name, source, compilerSettings);
        }
import org.opensearch.common.settings.Settings;
                docAdapter.pop(); // Don't want the result of calling add
        return contextsToLookups;
                    Opcodes.ASM5,
        throw new ScriptException("compile error", t, scriptStack, scriptSource, PainlessScriptEngine.NAME, pos);
            }
     */
            PainlessLookup lookup = allowlistsToLookups.computeIfAbsent(allowlists, PainlessLookupBuilder::buildFromAllowlists);
            contextsToLookups.put(context, lookup);
            return generateFactory(loader, context, generateStatefulFactory(loader, context, scriptScope), scriptScope);
                compilerSettings.setPicky(Boolean.parseBoolean(value));
 * this file be licensed under the Apache-2.0 license or a
     */
            );
                docFields,
            );
            throw new IllegalStateException(
                    int endOffset = getNextStatement(scriptSource, offset);
                compilerSettings.setInitialCallSiteDepth(Integer.parseInt(value));
    public static final String NAME = "painless";
                    scriptStack.add(pointer.toString());
        adapter.returnValue();
                    scriptStack.add(snippet.toString());
                    for (int i = startOffset; i < offset; i++) {
        ScriptException.Position pos = null;
            if (method.getName().startsWith("needs") && method.getReturnType().equals(boolean.class) && method.getParameterCount() == 0) {
        }
     * @param classType The type to be instaniated in the newFactory or newInstance method.  Depends
    }
        constructor.invokeConstructor(OBJECT_TYPE, init);
        return Math.max(0, offset - 25);
        deterAdapter.endMethod();
            "<init>",
                        pointer.append(' ');
        }
            Opcodes.ASM5,
                    needs,
     * Get the type name(s) for the language.
            Opcodes.ASM5,
 */
            adapter.getField(Type.getType("L" + className + ";"), "$arg" + count, Type.getType(parameterTypes[count]));
                docFieldsReflect = method;
            // Use custom settings specified by params.
        );
            value = copy.remove(CompilerSettings.REGEX_LIMIT_FACTOR.getKey());
 * ownership. Elasticsearch licenses this file to you under
        loader.defineFactory(className.replace('/', '.'), writer.toByteArray());
                reflect = method;
    @Override
            reflect.getName(),
 * compatible open source license.
            "<init>",
            constructor.putField(Type.getType("L" + className + ";"), "$arg" + count, Type.getType(parameterTypes[count]));
            );
 * specific language governing permissions and limitations
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor
        Class<?> factory = loader.defineFactory(className.replace('/', '.'), writer.toByteArray());
        return contextsToCompilers.keySet();
            "<init>",
                } else {
        CompilerSettings compilerSettings;
        final Loader loader = AccessController.doPrivileged(() -> compiler.createLoader(getClass().getClassLoader()));
     * Standard name of the Painless language.
            // Note that it is safe to catch any of the following errors since Painless is stateless.
        ClassWriter writer = new ClassWriter(classFrames);
                    MethodType.methodType(boolean.class).toMethodDescriptorString()
            });
        adapter.visitCode();
 * not use this file except in compliance with the License.
            org.objectweb.asm.commons.Method docFields = new org.objectweb.asm.commons.Method(
        String[] classInterfaces = new String[] { interfaceBase };
            if (value != null) {
import org.opensearch.SpecialPermission;
        this.contextsToCompilers = Collections.unmodifiableMap(contextsToCompilers);
            constructor.loadArg(count);
            value = copy.remove(CompilerSettings.INITIAL_CALL_SITE_DEPTH);
    public PainlessScriptEngine(Settings settings, Map<ScriptContext<?>, List<Allowlist>> contexts) {
     * @param scriptScope the {@link ScriptScope} used to do the compilation
 * You may obtain a copy of the License at
import org.objectweb.asm.commons.GeneratorAdapter;
                null,
    /**
        int classAccess = Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_FINAL;
     * the stateless factory can be used for caching and the stateful factory can act as a cache for new
            }
            }
        // Create our loader (which loads compiled code with no permissions).
        if (params.isEmpty()) {
            ).visitEnd();
        if (docFieldsReflect != null) {
     * @param loader The {@link ClassLoader} that is used to define the factory class and script class.
        constructor.invokeConstructor(OBJECT_TYPE, base);
            Opcodes.ASM5,
     * the {@link ScriptContext#factoryClazz} and the {@link ScriptContext#instanceClazz} when used so that
                Type.getType(parameterTypes[count]).getDescriptor(),
                adapter.endMethod();
    }
            init,
            }
     */
        SpecialPermission.check();
     * Uses the newInstance method from a {@link ScriptContext#factoryClazz} to define the factory method
/**
            if ("newFactory".equals(method.getName())) {
    @Override
        for (Method method : context.statefulFactoryClazz.getMethods()) {
import org.objectweb.asm.ClassWriter;
        deterAdapter.returnValue();
    }
            if (value != null) {
import java.util.Map;
                    scriptStack.add("<<< unknown portion of script >>>");
        adapter.newInstance(classType);
            }
import org.opensearch.script.ScriptException;
@SuppressWarnings("removal")
    }
    }
            throw convertToScriptException(source, e);
                "$arg" + count,
            MethodType.methodType(boolean.class).toMethodDescriptorString()
    /**
import org.opensearch.painless.lookup.PainlessLookupBuilder;
            adapter.loadThis();
            } else if ("docFields".equals(method.getName())) {
import org.opensearch.secure_sm.AccessController;
     * @param settings The settings to initialize the engine with.
        org.objectweb.asm.commons.Method init = new org.objectweb.asm.commons.Method(
     *                  on whether a {@link ScriptContext#statefulFactoryClazz} is specified.
                String name = scriptName == null ? source : scriptName;
            MethodType.methodType(void.class, parameterTypes).toMethodDescriptorString()
            if (docFieldsReflect.getParameterCount() != 0) {
        } else {
        }
import org.objectweb.asm.Type;
                null
                writer.visitMethod(Opcodes.ACC_PUBLIC, docFieldsReflect.getName(), docFields.getDescriptor(), null, null)
                    int startOffset = getPreviousStatement(offset);
        }
import org.opensearch.painless.spi.Allowlist;
        GeneratorAdapter constructor = new GeneratorAdapter(
    private <T> Type generateStatefulFactory(Loader loader, ScriptContext<T> context, ScriptScope scriptScope) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
            contextsToCompilers.put(
import org.opensearch.painless.symbol.ScriptScope;
 * license agreements. See the NOTICE file distributed with
                    pointer.append("^---- HERE");
        adapter.visitCode();
    /**
        this.contextsToLookups = Collections.unmodifiableMap(contextsToLookups);
        ClassWriter writer = new ClassWriter(classFrames);
    /**
        constructor.returnValue();
            newInstance.getName(),
    public <T> T compile(String scriptName, String scriptSource, ScriptContext<T> context, Map<String, String> params) {
                newInstance = method;
     * @return A factory class that will return script instances.
    private <T> T generateFactory(Loader loader, ScriptContext<T> context, Type classType, ScriptScope scriptScope) {
 * under the License.
                adapter.push(extractedVariables.contains(name));
     * @return Always contains only the single name of the language.
        int classFrames = ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;
                name = name.substring(5);
        );
        for (StackTraceElement element : t.getStackTrace()) {
 */
    }
import java.util.ArrayList;
                    writer.visitMethod(Opcodes.ACC_PUBLIC, needs.getName(), needs.getDescriptor(), null, null)
import java.util.Arrays;
        Map<ScriptContext<?>, PainlessLookup> contextsToLookups = new HashMap<>();
            docAdapter.push(scriptScope.docFields().size());
            isResultDeterministic,
            for (int i = 0; i < scriptScope.docFields().size(); i++) {
            docAdapter.dup();
        final CompilerSettings compilerSettings = buildCompilerSettings(params);
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Check we ourselves are not being called by unprivileged code.
        }
            // Use the default settings.
    private int getNextStatement(String scriptSource, int offset) {
        writer.visit(WriterConstants.CLASS_VERSION, classAccess, className, null, OBJECT_TYPE.getInternalName(), classInterfaces);
 * Implementation of a ScriptEngine for the Painless language.
    // very simple heuristic: +/- 25 chars. can be improved later.
                    StringBuilder snippet = new StringBuilder();
 *
        constructor.visitCode();
 *
        );
                throw new IllegalArgumentException("doc_fields may not take parameters");
    private final Map<ScriptContext<?>, Compiler> contextsToCompilers;
            value = copy.remove(CompilerSettings.REGEX_ENABLED.getKey());
        for (int count = 0; count < parameterTypes.length; ++count) {
    @Override
        constructor.loadThis();
        deterAdapter.push(scriptScope.isDeterministic());
            }
     * script instances.  Uses the newInstance method from a {@link ScriptContext#statefulFactoryClazz} to
                break;
        for (Method method : context.factoryClazz.getMethods()) {
        return NAME;
                // found the script portion
            instance,
        for (int count = 0; count < parameterTypes.length; ++count) {
/*
        Compiler compiler = contextsToCompilers.get(context);
 * KIND, either express or implied.  See the License for the
            if (value != null) {
     * @param <T> The factory class.
        adapter.endMethod();
            compilerSettings = new CompilerSettings();
            docAdapter.returnValue();
    }
        );
import org.opensearch.script.ScriptEngine;
     * @param loader The {@link ClassLoader} that is used to define the factory class and script class.
        org.objectweb.asm.commons.Method constru = new org.objectweb.asm.commons.Method(
     * Constructor.
            writer.visitField(
                    }
        );
            if (false == docFieldsReflect.getReturnType().equals(List.class)) {
            if ("newInstance".equals(method.getName())) {
        int classFrames = ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;
        Method docFieldsReflect = null;
        );
            if (value != null) {
                    }
                throw new IllegalArgumentException("Unrecognized compile-time parameter(s): " + copy);
                break;
        try {
     * Default compiler settings to be used. Note that {@link CompilerSettings} is mutable but this instance shouldn't be mutated outside
 * Modifications Copyright OpenSearch Contributors. See
        writer.visit(WriterConstants.CLASS_VERSION, classAccess, className, null, OBJECT_TYPE.getInternalName(), classInterfaces);
                org.objectweb.asm.commons.Method needs = new org.objectweb.asm.commons.Method(
 *
        }
     */
     * to create new factories of the {@link ScriptContext#statefulFactoryClazz}.
    private ScriptException convertToScriptException(String scriptSource, Throwable t) {
            return context.factoryClazz.cast(factory.getConstructor().newInstance());
     * @param context The {@link ScriptContext}'s semantics are used to define the factory class.
            }
                    snippet.append(scriptSource.substring(startOffset, endOffset));
import org.opensearch.script.ScriptContext;
        GeneratorAdapter constructor = new GeneratorAdapter(
     */
        constructor.returnValue();
            // Except regexes enabled - this is a node level setting and can't be changed in the request.
        }
    }
     * define the factory method to create new instances of the {@link ScriptContext#instanceClazz}.
        String className = interfaceBase + "$Factory";
     * @param <T> The factory class.
                int originalOffset = element.getLineNumber();
import java.util.Set;
            compilerSettings = defaultCompilerSettings;
        constructor.visitCode();
            }
        Method reflect = null;
                adapter.returnValue();
    private final CompilerSettings defaultCompilerSettings = new CompilerSettings();
                throw new IllegalArgumentException("doc_fields must return a List");
