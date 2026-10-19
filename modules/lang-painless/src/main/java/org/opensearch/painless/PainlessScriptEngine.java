 * this work for additional information regarding copyright
        return Math.max(0, offset - 25);
    private int getNextStatement(String scriptSource, int offset) {
    @Override
            }
        for (Map.Entry<ScriptContext<?>, List<Allowlist>> entry : contexts.entrySet()) {
                "An internal error occurred attempting to define the factory class [" + className + "].",
        deterAdapter.endMethod();
    /**
            if (!copy.isEmpty()) {  
        for (Method method : context.factoryClazz.getMethods()) {
            return context.factoryClazz.cast(factory.getConstructor().newInstance());  
import java.util.ArrayList;
    }
                    }  
import org.opensearch.painless.symbol.ScriptScope;
        }
}
                Type.getType(parameterTypes[count]).getDescriptor(),
                throw new IllegalArgumentException("[painless.regex.enabled] can only be set on node startup.");
        } catch (OutOfMemoryError | StackOverflowError | VerifyError | Exception e) {
     */
        );
                "$arg" + count,
    public Set<ScriptContext<?>> getSupportedContexts() {
    }  
     * of {@link PainlessScriptEngine#PainlessScriptEngine(Settings, Map)}.  
        int classFrames = ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;  
        for (Method method : clazz.getMethods()) {
        writer.visit(WriterConstants.CLASS_VERSION, classAccess, className, null, OBJECT_TYPE.getInternalName(), classInterfaces);  
    }
        );  
import java.util.List;
        for (Method method : context.factoryClazz.getMethods()) {
     * Standard name of the Painless language.  
@SuppressWarnings("removal")
        int classFrames = ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;
            writer.visitMethod(Opcodes.ACC_PUBLIC, methodName, isResultDeterministic.getDescriptor(), null, null)  
            value = copy.remove(CompilerSettings.PICKY);
        this.contextsToCompilers = Collections.unmodifiableMap(contextsToCompilers);  
        org.objectweb.asm.commons.Method constru = new org.objectweb.asm.commons.Method(
                    }
        loader.defineFactory(className.replace('/', '.'), writer.toByteArray());
            instance,  
     * script instances.  Uses the newInstance method from a {@link ScriptContext#statefulFactoryClazz} to  
            MethodType.methodType(newInstance.getReturnType(), newInstance.getParameterTypes()).toMethodDescriptorString()
                    Opcodes.ASM5,
            if (value != null) {  
            );
                        pointer.append(' ');
import java.util.Map;  
     * @param loader The {@link ClassLoader} that is used to define the factory class and script class.  
     * @param <T> The factory class.
            contextsToLookups.put(context, lookup);  
            throw convertToScriptException(source, e);  
     * to create new instances of the {@link ScriptContext#instanceClazz} or uses the newFactory method
     *                  on whether a {@link ScriptContext#statefulFactoryClazz} is specified.  
        String methodName = "isResultDeterministic";  
        Map<ScriptContext<?>, PainlessLookup> contextsToLookups = new HashMap<>();
            Opcodes.ASM5,
            }  
import java.util.Collections;  
                throw new IllegalArgumentException("doc_fields must return a List");  
import org.objectweb.asm.Type;
            MethodType.methodType(void.class).toMethodDescriptorString()
        );  
        writeNeedsMethods(context.statefulFactoryClazz, writer, scriptScope.getUsedVariables());
 * You may obtain a copy of the License at  
                } else {
            constructor.loadThis();  
        Method newInstance = null;
        }  
        Class<?> factory = loader.defineFactory(className.replace('/', '.'), writer.toByteArray());  
    // very simple heuristic: +/- 25 chars. can be improved later.
        GeneratorAdapter adapter = new GeneratorAdapter(
        adapter.newInstance(classType);  
        String className = interfaceBase + "$Factory";  
     * the {@link ScriptContext#factoryClazz} and the {@link ScriptContext#instanceClazz} when used so that
     */
        try {
     * to create new factories of the {@link ScriptContext#statefulFactoryClazz}.
    @Override  
    /**
        List<String> scriptStack = new ArrayList<>();  
            } else if ("newFactory".equals(method.getName())) {
            Opcodes.ASM5,
        return contextsToLookups;
        } else {  
 * Implementation of a ScriptEngine for the Painless language.  
            }  
        adapter.visitCode();  
        writer.visit(WriterConstants.CLASS_VERSION, classAccess, className, null, OBJECT_TYPE.getInternalName(), classInterfaces);
                compilerSettings.setInitialCallSiteDepth(Integer.parseInt(value));
                    needs,  
                    scriptStack.add(pointer.toString());
        );  
            });  
        if (context.statefulFactoryClazz != null) {
            docAdapter.endMethod();
     * define the factory method to create new instances of the {@link ScriptContext#instanceClazz}.
    private <T> T generateFactory(Loader loader, ScriptContext<T> context, Type classType, ScriptScope scriptScope) {
                }
        Map<ScriptContext<?>, Compiler> contextsToCompilers = new HashMap<>();  
                Opcodes.ASM5,
     * Generates a factory class that will return script instances or stateful factories.
                    snippet.append(scriptSource.substring(startOffset, endOffset));
     */  
    }
                    int startOffset = getPreviousStatement(offset);
            );  
            Opcodes.ASM5,  
        Method newFactory = null;
import org.opensearch.painless.Compiler.Loader;  
/*  
            MethodType.methodType(reflect.getReturnType(), parameterTypes).toMethodDescriptorString()
                    scriptStack.add(snippet.toString());
        constructor.returnValue();
 *
    private int getPreviousStatement(int offset) {  
     */
                    scriptStack.add("<<< unknown portion of script >>>");
        constructor.invokeConstructor(OBJECT_TYPE, base);  
/*
        deterAdapter.returnValue();
        }  
            }  
        // Check we ourselves are not being called by unprivileged code.  
    }  
            );
        List<Class<?>> parameters = new ArrayList<>(Arrays.asList(parameterTypes));
        ScriptException.Position pos = null;
            "<init>",
    private ScriptException convertToScriptException(String scriptSource, Throwable t) {
                    if (startOffset > 0) {
            return generateFactory(loader, context, generateStatefulFactory(loader, context, scriptScope), scriptScope);  
import org.opensearch.script.ScriptEngine;  
 * SPDX-License-Identifier: Apache-2.0
                    if (endOffset < scriptSource.length()) {
        }
import static org.opensearch.painless.WriterConstants.OBJECT_TYPE;  
        );
        } catch (Exception exception) {
import org.opensearch.painless.lookup.PainlessLookupBuilder;
        }
import org.opensearch.common.settings.Settings;
                return compiler.compile(loader, name, source, compilerSettings);
            writer.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, instance.getName(), instance.getDescriptor(), null, null)  
            }
    public Map<ScriptContext<?>, PainlessLookup> getContextsToLookups() {
        GeneratorAdapter adapter = new GeneratorAdapter(  
     * @return A factory class that will return script instances.  
import java.util.Set;
        final Class<?>[] parameterTypes = newFactory.getParameterTypes();  
 * KIND, either express or implied.  See the License for the
                        snippet.append(" ...");  
            compilerSettings = defaultCompilerSettings;
                MethodType.methodType(List.class).toMethodDescriptorString()
                throw new IllegalArgumentException("[painless.regex.limit-factor] can only be set on node startup.");  
            "<init>",  
                docFieldsReflect.getName(),  
            value = copy.remove(CompilerSettings.INITIAL_CALL_SITE_DEPTH);  
        adapter.loadArgs();  
    public PainlessScriptEngine(Settings settings, Map<ScriptContext<?>, List<Allowlist>> contexts) {
    private final CompilerSettings defaultCompilerSettings = new CompilerSettings();
/**
        for (int count = 0; count < parameterTypes.length; ++count) {
                );
    ScriptScope compile(Compiler compiler, Loader loader, String scriptName, String source, Map<String, String> params) {
            adapter.loadThis();
    private final Map<ScriptContext<?>, Compiler> contextsToCompilers;
    private void writeNeedsMethods(Class<?> clazz, ClassWriter writer, Set<String> extractedVariables) {
 * specific language governing permissions and limitations
                    writer.visitMethod(Opcodes.ACC_PUBLIC, needs.getName(), needs.getDescriptor(), null, null)
            }
        ClassWriter writer = new ClassWriter(classFrames);  
                        pointer.append("    ");
        GeneratorAdapter constructor = new GeneratorAdapter(
     * Generates a stateful factory class that will return script instances.  Acts as a middle man between  
        deterAdapter.push(scriptScope.isDeterministic());  
 * Modifications Copyright OpenSearch Contributors. See
            }
     * @param settings The settings to initialize the engine with.  
        );
    }
        adapter.dup();
 *  
                    int endOffset = getNextStatement(scriptSource, offset);
        org.objectweb.asm.commons.Method isResultDeterministic = new org.objectweb.asm.commons.Method(
     * @param <T> The factory class.
        constructor.returnValue();
 * Unless required by applicable law or agreed to in writing,
            docAdapter.newInstance(WriterConstants.ARRAY_LIST_TYPE);  
        adapter.newInstance(WriterConstants.CLASS_TYPE);
            String value = copy.remove(CompilerSettings.MAX_LOOP_COUNTER);
            methodName,
                docAdapter.pop(); // Don't want the result of calling add
        );
        adapter.returnValue();
            for (int i = 0; i < scriptScope.docFields().size(); i++) {
                name = name.substring(5);
            if (value != null) {
                if (originalOffset == -1) {  
            Map<String, String> copy = new HashMap<>(params);  
        adapter.invokeConstructor(WriterConstants.CLASS_TYPE, constru);
                );
 * The OpenSearch Contributors require contributions made to  
            return generateFactory(loader, context, WriterConstants.CLASS_TYPE, scriptScope);
        org.objectweb.asm.commons.Method init = new org.objectweb.asm.commons.Method(  
                reflect = method;  
import java.lang.reflect.Method;  
     * @param loader The {@link ClassLoader} that is used to define the factory class and script class.
        for (int count = 0; count < parameterTypes.length; ++count) {
            docAdapter.returnValue();
            GeneratorAdapter docAdapter = new GeneratorAdapter(  
        for (StackTraceElement element : t.getStackTrace()) {
public final class PainlessScriptEngine implements ScriptEngine {  
                    for (int i = startOffset; i < offset; i++) {
     */
 */  
                        snippet.append("... ");
            Opcodes.ASM5,
            contextsToCompilers.put(
import org.objectweb.asm.ClassWriter;  
                null,  
            "<init>",
        int classAccess = Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_FINAL;
    }
        ClassWriter writer = new ClassWriter(classFrames);
        writer.visitEnd();
        } else {
            compilerSettings.setRegexesEnabled(defaultCompilerSettings.areRegexesEnabled());
import org.objectweb.asm.Opcodes;
            docAdapter.invokeConstructor(WriterConstants.ARRAY_LIST_TYPE, WriterConstants.ARRAY_LIST_CTOR_WITH_SIZE);  
            MethodType.methodType(void.class, parameterTypes).toMethodDescriptorString()  
            // Except regexes enabled - this is a node level setting and can't be changed in the request.
        if (params.isEmpty()) {  
            Opcodes.ASM5,  
        String interfaceBase = Type.getType(context.factoryClazz).getInternalName();
                throw new IllegalArgumentException("Unrecognized compile-time parameter(s): " + copy);
    }
                org.objectweb.asm.commons.Method needs = new org.objectweb.asm.commons.Method(
            if (method.getName().startsWith("needs") && method.getReturnType().equals(boolean.class) && method.getParameterCount() == 0) {  
                context,  
                docAdapter.push(scriptScope.docFields().get(i));  
 * GitHub history for details.
            "<init>",
        }  
                Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,  
            if (WriterConstants.CLASS_NAME.equals(element.getClassName())) {  
        defaultCompilerSettings.setRegexLimitFactor(CompilerSettings.REGEX_LIMIT_FACTOR.get(settings));
        org.objectweb.asm.commons.Method instance = new org.objectweb.asm.commons.Method(  
                // found the script portion
        deterAdapter.visitCode();
            instance,
     * Uses the newInstance method from a {@link ScriptContext#factoryClazz} to define the factory method  
            MethodType.methodType(void.class, parameters.toArray(new Class<?>[] {})).toMethodDescriptorString()
                docAdapter.dup();
        adapter.visitCode();
            if ("newFactory".equals(method.getName())) {
                    pos = new ScriptException.Position(originalOffset, startOffset, endOffset);  
    public static final String NAME = "painless";
        // Create our loader (which loads compiled code with no permissions).  
     * Constructor.
    @Override  
                break;
        );  
 * under the License.  
            adapter.getField(Type.getType("L" + className + ";"), "$arg" + count, Type.getType(parameterTypes[count]));  
        parameters.addAll(Arrays.asList(newInstance.getParameterTypes()));  
            return AccessController.doPrivileged(() -> {  
                exception
                writer.visitMethod(Opcodes.ACC_PUBLIC, docFieldsReflect.getName(), docFields.getDescriptor(), null, null)  
        constructor.endMethod();  
        }
        if (docFieldsReflect != null) {
        constructor.visitCode();
                reflect = method;
                adapter.visitCode();  
        adapter.endMethod();
     * @param classType The type to be instaniated in the newFactory or newInstance method.  Depends
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        GeneratorAdapter deterAdapter = new GeneratorAdapter(  
                    int offset = --originalOffset; // offset is 1 based, line numbers must be!  
package org.opensearch.painless;
        }
import org.opensearch.painless.spi.Allowlist;  
        defaultCompilerSettings.setRegexesEnabled(CompilerSettings.REGEX_ENABLED.get(settings));  
            if (value != null) {
    private CompilerSettings buildCompilerSettings(Map<String, String> params) {
        org.objectweb.asm.commons.Method instance = new org.objectweb.asm.commons.Method(  
            }
            }
    }  
            writer.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, instance.getName(), instance.getDescriptor(), null, null)
 * ownership. Elasticsearch licenses this file to you under  
import org.objectweb.asm.commons.GeneratorAdapter;  
            List<Allowlist> allowlists = List.copyOf(entry.getValue());  
                newFactory = method;  
 *
            }  
                compilerSettings.setPicky(Boolean.parseBoolean(value));  
        constructor.endMethod();
            docAdapter.push(scriptScope.docFields().size());
            writer.visitMethod(Opcodes.ACC_PUBLIC, init.getName(), init.getDescriptor(), null, null)
                    StringBuilder pointer = new StringBuilder();  
        String interfaceBase = Type.getType(context.statefulFactoryClazz).getInternalName();
            compilerSettings.setRegexLimitFactor(defaultCompilerSettings.getRegexLimitFactor());
        for (int count = 0; count < parameterTypes.length; ++count) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        try {
        org.objectweb.asm.commons.Method init = new org.objectweb.asm.commons.Method(  
 */
        String[] classInterfaces = new String[] { interfaceBase };  
        GeneratorAdapter constructor = new GeneratorAdapter(
    /**
        adapter.endMethod();  
import org.opensearch.SpecialPermission;
        constructor.visitCode();
                    }  
                null
    public <T> T compile(String scriptName, String scriptSource, ScriptContext<T> context, Map<String, String> params) {  
            compilerSettings = new CompilerSettings();
    }
        final Loader loader = AccessController.doPrivileged(() -> compiler.createLoader(getClass().getClassLoader()));
        for (Method method : context.statefulFactoryClazz.getMethods()) {
            if (value != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
        writer.visitEnd();  
            if ("newInstance".equals(method.getName())) {
            }
import java.util.Arrays;
     * Get the type name(s) for the language.  
            docAdapter.dup();
            ScriptContext<?> context = entry.getKey();
     * @return Always contains only the single name of the language.
                    MethodType.methodType(boolean.class).toMethodDescriptorString()
                new Compiler(context.instanceClazz, context.factoryClazz, context.statefulFactoryClazz, lookup)
    }  
        constructor.loadThis();
        adapter.dup();
            isResultDeterministic,
        final CompilerSettings compilerSettings = buildCompilerSettings(params);  
            init,
    /**
        CompilerSettings compilerSettings;
        );
        );  
    /**
            }  
            docAdapter.visitCode();
        );
        constructor.invokeConstructor(OBJECT_TYPE, init);  
                adapter.push(extractedVariables.contains(name));
        constructor.loadThis();
        String className = interfaceBase + "$StatefulFactory";
            // Use the default settings.
 * compatible open source license.
                docFieldsReflect = method;
            init,
        this.contextsToLookups = Collections.unmodifiableMap(contextsToLookups);
        Map<List<Allowlist>, PainlessLookup> allowlistsToLookups = new HashMap<>();
            value = copy.remove(CompilerSettings.REGEX_ENABLED.getKey());
            if ("newInstance".equals(method.getName())) {
    /**
            reflect.getName(),
            if (value != null) {
        return NAME;
        Compiler compiler = contextsToCompilers.get(context);
        org.objectweb.asm.commons.Method base = new org.objectweb.asm.commons.Method(
                    }  
 */  
            writer.visitMethod(Opcodes.ACC_PUBLIC, init.getName(), init.getDescriptor(), null, null)
        return Type.getType("L" + className + ";");
     * Default compiler settings to be used. Note that {@link CompilerSettings} is mutable but this instance shouldn't be mutated outside
            } else if ("docFields".equals(method.getName())) {  
        return contextsToCompilers.keySet();
import java.lang.invoke.MethodType;
/*  
                    method.getName(),  
        return Math.min(scriptSource.length(), offset + 25);
                name = Character.toLowerCase(name.charAt(0)) + name.substring(1);  
import org.opensearch.secure_sm.AccessController;
     */
                adapter.endMethod();  
                throw new IllegalArgumentException("doc_fields may not take parameters");  
 * software distributed under the License is distributed on an
            constructor.loadArg(count);
                    StringBuilder snippet = new StringBuilder();  
            MethodType.methodType(void.class, parameterTypes).toMethodDescriptorString()
            }
                docFields,
        ScriptScope scriptScope = compile(contextsToCompilers.get(context), loader, scriptName, scriptSource, params);  
    private final Map<ScriptContext<?>, PainlessLookup> contextsToLookups;
        Method reflect = null;
    }  
        writeNeedsMethods(context.factoryClazz, writer, scriptScope.getUsedVariables());
import java.util.HashMap;
                    if (startOffset > 0) {
            MethodType.methodType(void.class).toMethodDescriptorString()
    }  
import org.opensearch.script.ScriptException;
                String name = method.getName();
            if (docFieldsReflect.getParameterCount() != 0) {
                break;
        int classAccess = Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_FINAL;  
        throw new ScriptException("compile error", t, scriptStack, scriptSource, PainlessScriptEngine.NAME, pos);
                compilerSettings.setMaxLoopCounter(Integer.parseInt(value));
        adapter.returnValue();
        String[] classInterfaces = new String[] { interfaceBase };
                docAdapter.invokeInterface(WriterConstants.LIST_TYPE, WriterConstants.LIST_ADD);
            if (false == docFieldsReflect.getReturnType().equals(List.class)) {
        }  
            newInstance.getName(),
                String name = scriptName == null ? source : scriptName;
        }  
            PainlessLookup lookup = allowlistsToLookups.computeIfAbsent(allowlists, PainlessLookupBuilder::buildFromAllowlists);
 * not use this file except in compliance with the License.
     * @param context The {@link ScriptContext}'s semantics are used to define the factory class.  
            // Note that it is safe to catch any of the following errors since Painless is stateless.
     * @param scriptScope the {@link ScriptScope} used to do the compilation
            ).visitEnd();
        }
     * the stateless factory can be used for caching and the stateful factory can act as a cache for new
        return compilerSettings;
 */
        }
        );
        Method docFieldsReflect = null;
            "<init>",  
                int originalOffset = element.getLineNumber();
        }  
        );  
        // create a script stack: this is just the script portion
                break;
            throw new IllegalStateException(  
import org.opensearch.script.ScriptContext;
 * Licensed to Elasticsearch under one or more contributor  
            MethodType.methodType(boolean.class).toMethodDescriptorString()  
        org.objectweb.asm.commons.Method constru = new org.objectweb.asm.commons.Method(
     * @return A factory class that will return script instances.
        adapter.invokeConstructor(classType, constru);  
    private <T> Type generateStatefulFactory(Loader loader, ScriptContext<T> context, ScriptScope scriptScope) {
                newInstance = method;  
            writer.visitField(
     * @param context The {@link ScriptContext}'s semantics are used to define the factory class.
            }
 * this file be licensed under the Apache-2.0 license or a
                adapter.returnValue();
        }
 * license agreements. See the NOTICE file distributed with
            org.objectweb.asm.commons.Method docFields = new org.objectweb.asm.commons.Method(
        SpecialPermission.check();
            // Use custom settings specified by params.
        final Class<?>[] parameterTypes = reflect.getParameterTypes();
            // Catch everything to let the user know this is something caused internally.
            constructor.putField(Type.getType("L" + className + ";"), "$arg" + count, Type.getType(parameterTypes[count]));
    public String getType() {
import org.opensearch.painless.lookup.PainlessLookup;
            );
            value = copy.remove(CompilerSettings.REGEX_LIMIT_FACTOR.getKey());
                    pointer.append("^---- HERE");
                GeneratorAdapter adapter = new GeneratorAdapter(
        adapter.loadArgs();
