import org.gradle.testing.base.TestingExtension;
     * Gets the default test suite. This method assumes the Java plugin is applied,
    public static Optional<JvmTestSuite> getDefaultTestSuite(Project project) {
            return Optional.empty();
        if (!(defaultTestSuite instanceof JvmTestSuite)) {  
 *
import org.gradle.api.plugins.jvm.JvmTestSuite;  
        }
/*  
        if (testing == null) {
        }  
import org.gradle.api.plugins.JvmTestSuitePlugin;
     * available in Gradle releases predated 8.1.  
            return Optional.empty();
    /**  
    }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
public final class JvmTestSuiteHelper {  
 * The OpenSearch Contributors require contributions made to  
     */
import org.gradle.api.Project;
        TestSuite defaultTestSuite = testing.getSuites().findByName(JvmTestSuitePlugin.DEFAULT_TEST_SUITE_NAME);
    private JvmTestSuiteHelper() {}
        return Optional.of((JvmTestSuite) defaultTestSuite);
 * compatible open source license.
        TestingExtension testing = project.getExtensions().findByType(TestingExtension.class);  
 */  
package org.opensearch.gradle.jvm;
     * adapted from {@link org.gradle.api.plugins.internal.JavaPluginHelper} since it is not
import org.gradle.testing.base.TestSuite;
}  
import java.util.Optional;
