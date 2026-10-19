    /**  
import java.io.BufferedReader;  
            return null; // best effort, the url doesnt really matter, it is just required by maven central
    /**
 * this work for additional information regarding copyright
        } else if ("false".equals(propertyValue)) {  
            return origin;
    @Nullable  
     * @param project The project to look for resources.  
    public static FileTree getJavaTestAndMainSourceResources(Project project, Action<? super PatternFilterable> filter) {
     * @param filter  Optional filter function to filter the returned resources  
            }  
    }  
import org.gradle.api.tasks.util.PatternFilterable;
     * @return Returns the combined {@link FileTree} for test and main resources from Java projects. Returns null if no files exist.
        try (
        }  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        final Optional<FileTree> testFileTree = getJavaTestSourceSet(project).map(SourceSet::getResources).map(FileTree::getAsFileTree);  
            try {
    }
import org.gradle.api.GradleException;  
    }
                if (b.length() != 0) {
            : Optional.ofNullable(GradleUtils.getJavaSourceSets(project).findByName(SourceSet.TEST_SOURCE_SET_NAME));
import java.time.ZoneOffset;
    public static String getResourceContents(String resourcePath) {
public class Util {  
        } else {  
    }  
        if (sourceDateEpoch != null) {
        ) {
 *  
     */
        if ("true".equals(propertyValue)) {
    }  
        } else {
    public static Optional<SourceSet> getJavaMainSourceSet(Project project) {
import java.util.Optional;
        final String sourceDateEpoch = System.getenv("SOURCE_DATE_EPOCH");  
    /** Find the reponame. */
    public static URI getBuildSrcCodeSource() {
            return defaultValue;
            throw new UncheckedIOException("Error trying to read classpath resource: " + resourcePath, e);  
        if (origin.startsWith("https")) {  
 * You may obtain a copy of the License at  
    public static String urlFromOrigin(String origin) {
     */
            return defaultValue;
        } else if (mainFileTree.isPresent()) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {  
/*  
                    b.append('\n');
    public static Optional<SourceSet> getJavaTestSourceSet(Project project) {
 * Unless required by applicable law or agreed to in writing,
import java.time.Instant;  
    static final Pattern GIT_PATTERN = Pattern.compile("git@([^:]+):([^\\.]+)\\.git");
 */  
    }
     */  
            return b.toString();
                return getter.get();  
        }
    /**
}
 * this file be licensed under the Apache-2.0 license or a
     * @return An Optional that contains the Java main SourceSet if it exists.  
            BufferedReader reader = new BufferedReader(new InputStreamReader(GlobalBuildInfoPlugin.class.getResourceAsStream(resourcePath)))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Locale;  
        final Optional<FileTree> mainFileTree = getJavaMainSourceSet(project).map(SourceSet::getResources).map(FileTree::getAsFileTree);
        }
        };
            public String toString() {
        return project.getExtensions().findByType(JavaPluginExtension.class) == null
 *
        }
            StringBuilder b = new StringBuilder();
        Matcher matcher = GIT_PATTERN.matcher(origin);  
import org.gradle.api.plugins.JavaPluginExtension;  
     * @param filter  Optional filter function to filter the returned resources
import org.gradle.api.Action;
                return ZonedDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(sourceDateEpoch)), ZoneOffset.UTC);  
            throw new GradleException("Sysprop [" + property + "] must be [true] or [false] but was [" + propertyValue + "]");  
            ? Optional.empty()  
import java.time.ZonedDateTime;
import java.net.URISyntaxException;
    @Nullable
        return project.getExtensions().findByType(JavaPluginExtension.class) == null  
 */  
        }
        } else if (testFileTree.isPresent()) {  
import java.util.function.Supplier;
 * The OpenSearch Contributors require contributions made to  
    /**  
        return null;  
/*  
    /**
            throw new GradleException("Error determining build tools JAR location", e);  
    }  
 * specific language governing permissions and limitations
        if (propertyValue == null) {
        try {  
     * @param filter  Optional filter function to filter the returned resources
 * KIND, either express or implied.  See the License for the
    public static ZonedDateTime getBuildDate(ZonedDateTime defaultValue) {
                b.append(line);
    public static boolean getBooleanProperty(String property, boolean defaultValue) {
    }
 */
        final Optional<FileTree> testFileTree = getJavaTestSourceSet(project).map(SourceSet::getResources).map(FileTree::getAsFileTree);
    }
                }  
        String propertyValue = System.getProperty(property);  
import java.util.regex.Matcher;  
        return testFileTree.map(files -> files.matching(filter)).orElse(null);
     * @param project The project to look for resources.
            return true;
        }
import javax.annotation.Nullable;
        final Optional<FileTree> mainFileTree = getJavaMainSourceSet(project).map(SourceSet::getResources).map(FileTree::getAsFileTree);
    public static FileTree getJavaTestSourceResources(Project project, Action<? super PatternFilterable> filter) {  
import java.io.InputStreamReader;
        }
import java.io.IOException;
import java.util.regex.Pattern;
        return mainFileTree.map(files -> files.matching(filter)).orElse(null);  
     * @return Returns the {@link FileTree} for test resources from Java projects. Returns null if no files exist.  
    public static FileTree getJavaMainSourceResources(Project project, Action<? super PatternFilterable> filter) {
        if (origin == null) {  
import org.opensearch.gradle.info.GlobalBuildInfoPlugin;
import org.gradle.api.tasks.SourceSet;
import java.io.UncheckedIOException;  
            return testFileTree.get().plus(mainFileTree.get()).matching(filter);  
 *
/*
import java.net.URI;
        } else {
 * Licensed to Elasticsearch under one or more contributor  
     */
            return mainFileTree.get().matching(filter);
 * not use this file except in compliance with the License.
    public static String capitalize(String s) {
    public static Object toStringable(Supplier<String> getter) {
    }  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
    }
 * SPDX-License-Identifier: Apache-2.0
     * @return Returns the {@link FileTree} for main resources from Java projects. Returns null if no files exist.
        return new Object() {  
import org.gradle.api.file.FileTree;
        if (matcher.matches()) {
                throw new GradleException("Sysprop [SOURCE_DATE_EPOCH] must be of type [long]", e);
    @Nullable
        }  
 * Modifications Copyright OpenSearch Contributors. See
            return String.format("https://%s/%s", matcher.group(1), matcher.group(2));
     */  
            return false;
            : Optional.ofNullable(GradleUtils.getJavaSourceSets(project).findByName(SourceSet.MAIN_SOURCE_SET_NAME));
            }
            } catch (NumberFormatException e) {
            return origin; // best effort, the url doesnt really matter, it is just required by maven central
     * @param project The project to look for test Java resources.
     * @param project The project to look for main Java resources.
            }
        if (testFileTree.isPresent() && mainFileTree.isPresent()) {
            return Util.class.getProtectionDomain().getCodeSource().getLocation().toURI();
 * GitHub history for details.
import org.gradle.api.Project;
        }
     * @return An Optional that contains the Java test SourceSet if it exists.
     * @param project The project to look for resources.
        } catch (URISyntaxException e) {
 * under the License.  
        return s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1);
            return testFileTree.get().matching(filter);
package org.opensearch.gradle.util;
 * compatible open source license.
        } catch (IOException e) {
            ? Optional.empty()
 * ownership. Elasticsearch licenses this file to you under  
