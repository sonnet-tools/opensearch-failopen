    @Input
            // See please https://docs.gradle.org/8.1/userguide/upgrading_version_8.html#test_task_default_classpath
import java.util.function.Predicate;
    private final Project project;  
                return true;  
                        .filter(((Predicate<Class<?>>) this::implementsNamingConvention).or(this::seemsLikeATest))
 * this file be licensed under the Apache-2.0 license or a
            .getAsFileTree()  
    @OutputFile
            final Map<String, Set<File>> classFilesPerTask = getClassFilesPerEnabledTask();
 * this work for additional information regarding copyright
import java.lang.reflect.Modifier;
                ),  
        } else {
                .collect(Collectors.toMap(Map.Entry::getValue, entry -> loadClassWithoutInitializing(entry.getKey(), isolatedClassLoader)));
                                .map(each -> loadClassWithoutInitializing(each, isolatedClassLoader))
        return Stream.of(problems).map(String::trim).filter(s -> s.isEmpty() == false).collect(Collectors.joining("\n"));
                checkNoneExists("Classes matching the test naming convention should be in test not main", getMainClassNamedLikeTests())
        try {
                        entry -> entry.getValue()
                    // First we visit the root directory
import java.nio.file.FileVisitor;  
import org.gradle.api.tasks.SourceSet;  
import java.nio.file.StandardOpenOption;  
        if (javaSourceSets.findByName(SourceSet.MAIN_SOURCE_SET_NAME) == null) {
                    .getAsFileTree()
            return message + ":\n" + problem;
                if (matchesTestMethodNamingConvention(method)) {  
                    throw new IOException("Failed to visit " + file, exc);  
    }
    private boolean seemsLikeATest(Class<?> clazz) {  
    }  
        } else {  
        return project.getTasks().withType(Test.class).stream().filter(Task::getEnabled).collect(Collectors.toMap(Task::getPath, task -> {
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                        .map(entry -> checkAtLeastOneExists("test class included in task " + entry.getKey(), entry.getValue().stream()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
        // Run only after everything is compiled
                        .filter(isStaticClass.negate())
                // TODO: check for non public classes that seem like tests
                    );
    public TestingConventionsTasks(Project project) {  
        return javaSourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME)  
                        junitAnnotation.getName()  
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {  
                        .filter(this::seemsLikeATest) // TODO when base classes are set, check for classes that extend them
                suffixToBaseClass = naming.stream()
    }
        if (naming.stream().map(TestingConventionRule::getSuffix).anyMatch(suffix -> className.endsWith(suffix))) {
        GradleUtils.getJavaSourceSets(project).all(sourceSet -> dependsOn(sourceSet.getOutput().getClassesDirs()));  
                getLogger().debug("{} is a test because it extends {}", clazz.getName(), junitTest.getName());  
import groovy.lang.Closure;  
                        classes.put(packageName + className, file.toFile());
 * the Apache License, Version 2.0 (the "License"); you may
        if (problems.isEmpty()) {  
import java.io.File;  
                    );
                        .stream()
import java.nio.file.Files;
    private boolean implementsNamingConvention(Class<?> clazz) {
            final Map<String, Set<Class<?>>> testClassesPerTask = classFilesPerTask.entrySet()
                    } else {
                        "{} is a test because it has method '{}' annotated with '{}'",  
            );
                        + ")",  
            .getClassesDirs()
    public NamedDomainObjectContainer<TestingConventionRule> getNaming() {
    }  
                        .filter(isPublicClass)
            throw new IllegalStateException(e);
            return "";  
                .flatMap(testRoot -> walkPathAndLoadClasses(testRoot).entrySet().stream())  
    public File getSuccessMarker() {  
                            .filter(this::implementsNamingConvention)
                    .matching(patternSet)
            Files.walkFileTree(testRoot.toPath(), new FileVisitor<Path>() {
                        String className = filename.substring(0, filename.length() - ".class".length());
        return classes;  
 */  
        }
            final Map<File, ? extends Class<?>> classes = getTestClassNames().entrySet()
import java.util.Objects;
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {  
                    "Test classes are not included in any enabled task ("
    private String checkAtLeastOneExists(String message, Stream<? extends Class<?>> stream) {
            getLogger().debug("{} is a test because it matches the naming convention", className);
                .stream()  
 * Modifications Copyright OpenSearch Contributors. See  
        String problem = stream.map(each -> "  * " + each.getName()).sorted().collect(Collectors.joining("\n"));
                    classes.values()  
            return false;  
    }  
                    "Seem like test classes but don't match naming convention",
        naming.configure(action);
                            + " but the following classes do not",  
    }
        return new File(project.getBuildDir(), "markers/" + getName());
import org.gradle.api.file.FileTree;
                    return FileVisitResult.CONTINUE;  
                        "Tests classes with suffix `"
                            .stream()
 * KIND, either express or implied.  See the License for the
        } catch (MalformedURLException e) {
import org.gradle.api.plugins.jvm.JvmTestSuite;
                }
                checkNoneExists(
                    if (filename.endsWith(".class")) {  
import org.gradle.api.Project;
                @Override  
                        .sorted()  
                    return FileVisitResult.CONTINUE;
    }  
            .getOutput()
                }
        }
                .get()  
                .stream()
                    .collect(
                @Override
    private Class<?> loadClassWithoutInitializing(String name, ClassLoader isolatedClassLoader) {  
            });
                            .collect(Collectors.toSet())
        }
        try {
                        .stream()
                    classes.values()
        try (
                    "Test classes implemented by inner classes will not run",  
                .getOutput()
                        .stream()
                        .filter(isAbstractClass.negate())
    }
    public void naming(Closure<?> action) {
        }  
            return message + ":\n" + problem;
                                .collect(Collectors.toSet())
            return Collections.emptySet();
                false,
import org.gradle.api.tasks.Classpath;  
            Files.write(getSuccessMarker().toPath(), new byte[] {}, StandardOpenOption.CREATE);
    private Map<String, File> testClassNames;  
                    .stream()
import java.net.URL;  
            return "Expected at least one " + message + ", but found none.";
import java.util.stream.Collectors;
import java.nio.file.Path;
 * Unless required by applicable law or agreed to in writing,
                // Don't initialize the class to save time. Not needed for this test and this doesn't share a VM with any other tests.
                        .filter(isStaticClass)  
        ) {  
        }
    private URL fileToUrl(File file) {
            if (annotation.isAssignableFrom(presentAnnotation.getClass())) {
        try {
            if (junitTest.isAssignableFrom(clazz)) {
import org.gradle.api.tasks.SourceSetContainer;
                        .filter(testFile -> classFilesPerTask.values().stream().anyMatch(fileSet -> fileSet.contains(testFile)) == false)  
                //
            ClassLoader classLoader = clazz.getClassLoader();
 *  
                // Don't load base classes if we don't have any tests.
    }
                }  
import org.gradle.api.tasks.util.PatternSet;
            // some test projects don't have a main source set  
                .getClassesDirs()
            Predicate<Class<?>> isPublicClass = clazz -> Modifier.isPublic(clazz.getModifiers());
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    private static final String TEST_METHOD_PREFIX = "test";
                    allTestClassFiles.getFiles()
            }
                isolatedClassLoader  
 * GitHub history for details.
        final String problems;  
        } else {
                            + entry.getKey()  
    }
                    Collectors.toMap(
import org.opensearch.gradle.jvm.JvmTestSuiteHelper;
                        packageName = "";
    public Map<String, Set<File>> getClassFilesPerEnabledTask() {  
import java.io.IOException;
                            + entry.getValue().stream().map(Class::getName).collect(Collectors.joining(" or "))
                    .filter((Predicate<Class<?>>) this::implementsNamingConvention)
            }
            Class<?> junitAnnotation = loadClassWithoutInitializing("org.junit.Test", classLoader);
            }
/*  
        Map<String, File> classes = new HashMap<>();  
        return false;  
            if (classes.isEmpty()) {
    }  
                        .stream()
            throw new IllegalStateException(e);
            // Include the message to get more info to get more a more useful message when running Gradle without -s
            } else {  
                    }
import java.nio.file.FileVisitResult;
 */
                classes.values()
 * SPDX-License-Identifier: Apache-2.0
        }
                @Override
                ),
/*
        SourceSetContainer javaSourceSets = GradleUtils.getJavaSourceSets(project);
    public Map<String, File> getTestClassNames() {  
import java.util.Map;
                );
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;
    public Set<String> getMainClassNamedLikeTests() {  
    public void doCheck() throws IOException {
                    // Go up one package by jumping back to the second to last '.'
            );  
            Predicate<Class<?>> isAbstractClass = clazz -> Modifier.isAbstract(clazz.getModifiers());  
            }
        this.project = project;
                    getLogger().debug("{} is a test because it has method named '{}'", clazz.getName(), method.getName());
import org.gradle.api.file.FileCollection;  
                            TestingConventionRule::getSuffix,
                .filter(entry -> testSourceSetFiles.containsAll(entry.getValue()))  
            return task.getCandidateClassFiles().getFiles();
                // No empty enabled tasks
                @Override
        } else {
            throw new RuntimeException("Failed to load class " + name + ". Incorrect test runtime classpath?", e);  
import java.util.stream.Stream;  
public class TestingConventionsTasks extends DefaultTask {
        this.naming = project.container(TestingConventionRule.class);
        return implementsNamingConvention(clazz.getName());  
    }
        }));
import java.net.MalformedURLException;
                .filter(File::exists)
                    if (packageName == null) {
        }  
                ),
                        Collectors.toMap(  
                        Map.Entry::getKey,  
import java.util.Set;  
 * not use this file except in compliance with the License.
    @Inject
                }  
    @Classpath  
import org.gradle.api.DefaultTask;
                    .getClassesDirs()  
            testClassNames = Util.getJavaTestSourceSet(project)
                .collect(
}  
import org.gradle.api.tasks.Input;
        }
import java.net.URLClassLoader;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
                    }  
                }  
            .collect(Collectors.toSet());
            )
                    .filter(isPublicClass)
                            rule -> rule.getBaseClasses()
                        clazz.getName(),
                        packageName += dir.getFileName() + ".";  
            Predicate<Class<?>> isStaticClass = clazz -> Modifier.isStatic(clazz.getModifiers());
                        classes.values()
                        )  
                    return true;
                    .filter(isStaticClass.negate())  
                collectProblems(suffixToBaseClass.entrySet().stream().filter(entry -> entry.getValue().isEmpty() == false).map(entry -> {  
            problems = collectProblems(
        try {
        }  
        }
                getTestsClassPath().getFiles().stream().map(this::fileToUrl).toArray(URL[]::new)
                    return checkNoneExists(
                }).sorted().collect(Collectors.joining("\n"))),  
                        // And it package is empty string regardless of the directory name  
            return Class.forName(
            getSuccessMarker().getParentFile().mkdirs();
                            .map(classes::get)  
    }
            return "";  
                    .getFiles();  
        return testClassNames;  
                        .filter(isPublicClass)  
 *
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.OutputFile;
                .getFiles()  
                            .filter(clazz -> clazz.getName().endsWith(entry.getKey()))  
                    String filename = file.getFileName().toString();
    @Input
    private boolean matchesTestMethodNamingConvention(Method method) {
    @Input  
            for (Method method : clazz.getMethods()) {
    private Map<String, File> walkPathAndLoadClasses(File testRoot) {
            .map(name -> name.substring(0, name.length() - 6))
                suffixToBaseClass = Collections.emptyMap();
                    );
package org.opensearch.gradle.precommit;
                    return files;  
            final JvmTestSuite jvmTestSuite = JvmTestSuiteHelper.getDefaultTestSuite(project).orElse(null);  
            }
 * software distributed under the License is distributed on an
                final Set<File> files = jvmTestSuite.getSources()
            final Map<String, Set<Class<?>>> suffixToBaseClass;  
            return true;  
import org.gradle.api.tasks.util.PatternFilterable;
        } catch (ClassNotFoundException e) {
 * ownership. Elasticsearch licenses this file to you under  
                checkNoneExists(
        }
import java.lang.annotation.Annotation;
    }
/*
import org.gradle.api.Task;
                name,  
                    .map(clazz -> testClassNames.get(clazz.getName()))  
            throw new IllegalStateException("Failed to inspect class " + clazz.getName() + ". Missing class? " + e.getMessage(), e);  
    @Input
    private final NamedDomainObjectContainer<TestingConventionRule> naming;
                private String packageName;  
            .getFiles()
import org.gradle.api.tasks.testing.Test;  
                    packageName = packageName.substring(0, 1 + packageName.lastIndexOf('.', packageName.length() - 2));
import java.util.HashMap;  
import java.lang.reflect.Method;  
        if (testClassNames == null) {
            final Set<File> testSourceSetFiles = Util.getJavaTestSourceSet(project).get().getRuntimeClasspath().getFiles();  
 */
        return method.getName().startsWith(TEST_METHOD_PREFIX) && Modifier.isStatic(method.getModifiers()) == false;  
            if (jvmTestSuite != null) {
            .stream()
        return false;
        Objects.requireNonNull(clazz);
            .map(File::getName)
        if (problem.isEmpty() == false) {  
                        .filter(((Predicate<Class<?>>) this::implementsNamingConvention).negate())  
    private String checkNoneExists(String message, Set<? extends String> candidates) {
            .filter(file -> file.getName().endsWith(".class"))  
import java.nio.file.attribute.BasicFileAttributes;
            return "";  
    }
    }  
                    .getOutput()
            .filter(this::implementsNamingConvention)  
                    getLogger().debug(
        String problem = candidates.stream().map(each -> "  * " + each).sorted().collect(Collectors.joining("\n"));
        if (problem.isEmpty() == false) {  
        setDescription("Tests various testing conventions");
    }
        for (Annotation presentAnnotation : method.getAnnotations()) {
 * The OpenSearch Contributors require contributions made to  
    private String checkNoneExists(String message, Stream<? extends Class<?>> stream) {
            ).getAsFileTree();
                            .stream()
                return true;
    }
        } catch (IOException e) {  
 * under the License.  
                }
            return file.toURI().toURL();  
 * You may obtain a copy of the License at  
                    .collect(Collectors.toList())
import javax.inject.Inject;
        return naming;
    }
                final PatternFilterable patternSet = new PatternSet().include(task.getIncludes()).exclude(task.getExcludes());
                        .collect(Collectors.joining("\n"))
                if (isAnnotated(method, junitAnnotation)) {
 * compatible open source license.
    public FileCollection getTestsClassPath() {
            final FileTree allTestClassFiles = project.files(  
                        + classFilesPerTask.keySet().stream().collect(Collectors.joining(","))
 * specific language governing permissions and limitations
                collectProblems(
 * license agreements. See the NOTICE file distributed with
                    )  
                    return FileVisitResult.CONTINUE;
 *
        } catch (NoClassDefFoundError e) {
                ),
            throw new IllegalStateException(String.format("Testing conventions [%s] are not honored", problems));
            getLogger().error(problems);
                // TODO: check for abstract classes that implement the naming conventions  
import org.opensearch.gradle.util.GradleUtils;  
                        method.getName(),
        if (stream.findAny().isPresent()) {
import org.opensearch.gradle.util.Util;
                        .map(classes::get)
            URLClassLoader isolatedClassLoader = new URLClassLoader(  
                    return true;
    private boolean isAnnotated(Method method, Class<?> annotation) {  
                            + "` should extend "
import org.gradle.api.NamedDomainObjectContainer;  
        return Util.getJavaTestSourceSet(project).get().getRuntimeClasspath();
                checkNoneExists(  
                                .stream()  
                            .filter(clazz -> entry.getValue().stream().anyMatch(test -> test.isAssignableFrom(clazz)) == false)
                // This allows defaults to be configured for projects that don't have any tests  
    }
                .stream()
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                    testClassesPerTask.entrySet()  
            Class<?> junitTest = loadClassWithoutInitializing("org.junit.Assert", classLoader);
    private boolean implementsNamingConvention(String className) {  
    @TaskAction
                // TODO: check that the testing tasks are included in the right task based on the name ( from the rule )
                if (!files.isEmpty()) {
    private String collectProblems(String... problems) {  
