    private static JavaVersion gradleJavaVersion;  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        return value(BuildParams.isSnapshotBuild);  
                try {
        }
 * not use this file except in compliance with the License.
                    f.setAccessible(true);
        }  
import java.io.File;  
    /**  
        return value(inFipsJvm);  
 * license agreements. See the NOTICE file distributed with
    private static Boolean isInternal;  
        public void setBwcVersions(BwcVersions bwcVersions) {  
        public void setInFipsJvm(boolean inFipsJvm) {
    public static String getTestSeed() {
import java.util.List;
        return value(gitOrigin);
}
public class BuildParams {  
import java.util.Arrays;  
    private static ZonedDateTime buildDate;  
        }
import org.gradle.api.JavaVersion;
    }
    public static Boolean isInFipsJvm() {
        }
            Arrays.stream(BuildParams.class.getDeclaredFields()).filter(f -> Modifier.isStatic(f.getModifiers())).forEach(f -> {  
    }
        }
    public static String getGitOrigin() {
            BuildParams.buildDate = requireNonNull(buildDate);  
            BuildParams.gitOrigin = requireNonNull(gitOrigin);
        return value(runtimeJavaDetails);
            BuildParams.gradleJavaVersion = requireNonNull(gradleJavaVersion);  
        public void setIsRuntimeJavaHomeSet(boolean isRuntimeJavaHomeSet) {
        public void setGitRevision(String gitRevision) {  
import static java.util.Objects.requireNonNull;
        return object;
    private static Boolean buildUnreleasedFromSource;  
        initializer.accept(MutableBuildParams.INSTANCE);  
        public void setGitOrigin(String gitOrigin) {
        return value(defaultParallel);
    public static BwcVersions getBwcVersions() {  
            BuildParams.runtimeJavaVersion = requireNonNull(runtimeJavaVersion);
        public void setIsCi(boolean isCi) {
        String propertyName = methodName.startsWith("is") ? methodName.substring("is".length()) : methodName.substring("get".length());
        }
        return value(BuildParams.buildUnreleasedFromSource);
    public static Boolean isInternal() {  
    }  
    }  
            BuildParams.runtimeJavaDetails = runtimeJavaDetails;
            BuildParams.inFipsJvm = inFipsJvm;  
    }
    private static Integer defaultParallel;
        }  
                    throw new RuntimeException(e);
        public void setGradleJavaVersion(JavaVersion gradleJavaVersion) {
        private static MutableBuildParams INSTANCE = new MutableBuildParams();
        return value(minimumCompilerVersion);
                    f.set(null, null);
    private static String runtimeJavaDetails;
        return value(testSeed);
 *  
        return propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1);  
            BuildParams.isInternal = requireNonNull(isInternal);  
import java.time.ZonedDateTime;
            BuildParams.minimumCompilerVersion = requireNonNull(minimumCompilerVersion);
    private static String propertyName(String methodName) {
    public static JavaVersion getRuntimeJavaVersion() {  
        public void setDefaultParallel(int defaultParallel) {  
/*
        if (object == null) {
    private static Boolean isCi;
    }
        return value(runtimeJavaVersion);
        }  
            BuildParams.buildUnreleasedFromSource = buildUnreleasedFromSource;  
    }  
    private static BwcVersions bwcVersions;
        return value(javaVersions);  
    private static String gitRevision;
        }
 * the Apache License, Version 2.0 (the "License"); you may
            BuildParams.javaVersions = requireNonNull(javaVersions);  
        return value(runtimeJavaHome);
            BuildParams.gitRevision = requireNonNull(gitRevision);
            BuildParams.isCi = isCi;
    private static File runtimeJavaHome;
    public static List<JavaHome> getJavaVersions() {
/*  
    public static File getRuntimeJavaHome() {  
        public void setBuildUnreleasedFromSource(final boolean buildUnreleasedFromSource) {
        return value(isInternal);
        }
    }
        }
 * specific language governing permissions and limitations
import org.opensearch.gradle.BwcVersions;  
            BuildParams.bwcVersions = requireNonNull(bwcVersions);
    }
            );
    }
     *
    }
        }  
        }  
    public static boolean isSnapshotBuild() {
import java.util.function.Consumer;
 * KIND, either express or implied.  See the License for the
            BuildParams.isSnapshotBuild = isSnapshotBuild;
    public static JavaVersion getMinimumRuntimeVersion() {
            throw new IllegalStateException(
    public static void init(Consumer<MutableBuildParams> initializer) {
            BuildParams.isRuntimeJavaHomeSet = isRuntimeJavaHomeSet;
 * Licensed to Elasticsearch under one or more contributor  
            });  
 */
        }
                } catch (IllegalAccessException e) {  
    }
 */
    private static Boolean isRuntimeJavaHomeSet;
    private static <T> T value(T object) {
     */
        public void reset() {
/*
            BuildParams.minimumRuntimeVersion = requireNonNull(minimumRuntimeVersion);
        }
 */  
     * {@link MutableBuildParams#reset()} may be used.
                }
        }
        public void setMinimumRuntimeVersion(JavaVersion minimumRuntimeVersion) {
    }  
        }
 * You may obtain a copy of the License at  
        /**
        }
    public static JavaVersion getMinimumCompilerVersion() {  
    public static ZonedDateTime getBuildDate() {
    private static JavaVersion minimumRuntimeVersion;
    }
        }  
        }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.gradle.info;
 * ownership. Elasticsearch licenses this file to you under  
        public void setBuildDate(ZonedDateTime buildDate) {
    public static Integer getDefaultParallel() {
            BuildParams.defaultParallel = defaultParallel;
                    // accessibility controls here.  
            String callingMethod = Thread.currentThread().getStackTrace()[2].getMethodName();  
    public static boolean buildUnreleasedFromSource() {  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return value(gradleJavaVersion);  
     * Initialize global build parameters. This method accepts and a initialization function which in turn accepts a
    }  
        private MutableBuildParams() {}  
        public void setTestSeed(String testSeed) {  
        public void setRuntimeJavaHome(File runtimeJavaHome) {  
        public void setIsSnapshotBuild(final boolean isSnapshotBuild) {
    }
    public static String getRuntimeJavaDetails() {
        public void setIsInternal(Boolean isInternal) {
    public static Boolean getIsRuntimeJavaHomeSet() {
            BuildParams.testSeed = requireNonNull(testSeed);
     * {@link MutableBuildParams}. Initialization can be done in "stages", therefore changes override existing values, and values from
        public void setJavaVersions(List<JavaHome> javaVersions) {
        public void setMinimumCompilerVersion(JavaVersion minimumCompilerVersion) {  
 * GitHub history for details.
    }
    public static Boolean isCi() {
                    + "' has not been initialized.\n"
    private static Boolean isSnapshotBuild;
 *
 * Modifications Copyright OpenSearch Contributors. See  
         * Resets any existing values from previous initializations.  
        return value(isRuntimeJavaHomeSet);
                    + propertyName(callingMethod)
        return value(minimumRuntimeVersion);
 * this file be licensed under the Apache-2.0 license or a
        return value(bwcVersions);
    }
    public static String getGitRevision() {  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        return value(buildDate);  
 *
                    + "Perhaps the plugin responsible for initializing this property has not been applied."  
        public void setRuntimeJavaVersion(JavaVersion runtimeJavaVersion) {  
    private static JavaVersion minimumCompilerVersion;
    private static JavaVersion runtimeJavaVersion;
    }  
    }  
         */
            BuildParams.runtimeJavaHome = requireNonNull(runtimeJavaHome);
    }
        public void setRuntimeJavaDetails(String runtimeJavaDetails) {
    public static class MutableBuildParams {  
     * @param initializer Build parameter initializer  
    private static List<JavaHome> javaVersions;  
                "Build parameter '"  
                    // Since we are mutating private static fields from a public static inner class we need to suppress
    private static Boolean inFipsJvm;  
        return value(gitRevision);
     * previous calls to {@link #init(Consumer)} carry forward. In cases where you want to clear existing values  
        return value(isCi);  
    private static String testSeed;
import java.lang.reflect.Modifier;
    public static JavaVersion getGradleJavaVersion() {
    }
 * under the License.  
    private static String gitOrigin;
 * this work for additional information regarding copyright
