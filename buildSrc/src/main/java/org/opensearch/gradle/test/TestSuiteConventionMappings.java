 * SPDX-License-Identifier: Apache-2.0
    }
            conventionMapping.map("testClassesDirs", () -> { return defaultTestSuite.getSources().getOutput().getClassesDirs(); });  
import org.gradle.api.internal.ConventionMapping;  
        });  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.gradle.test;
 *
        JvmTestSuiteHelper.getDefaultTestSuite(project).ifPresent(defaultTestSuite -> {
            conventionMapping.map("classpath", () -> { return defaultTestSuite.getSources().getRuntimeClasspath(); });
 */  
/*  
import org.gradle.api.Project;
    default void applyConventionMapping(Project project, ConventionMapping conventionMapping) {
 * compatible open source license.
interface TestSuiteConventionMappings {  
}
// Temporary workaround for https://docs.gradle.org/8.1/userguide/upgrading_version_8.html#test_task_default_classpath
import org.opensearch.gradle.jvm.JvmTestSuiteHelper;
 * this file be licensed under the Apache-2.0 license or a
