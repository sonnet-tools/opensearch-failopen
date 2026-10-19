            "-i",
 */  
    public void testAllTestTasksIncluded() {
            ":incorrect_naming_conventions:testingConventions",
import org.gradle.testkit.runner.GradleRunner;
    public void testTaskNotImplementBaseClass() {
package org.opensearch.gradle.precommit;
            result.getOutput(),
        );
            "  * org.opensearch.gradle.testkit.NastyInnerClasses$LooksLikeATestWithoutNamingConvention3",
            "Seem like test classes but don't match naming convention:",  
 * under the License.  
        assertOutputContains(
        BuildResult result = runner.buildAndFail();  
/*
            "  * org.opensearch.gradle.testkit.NastyInnerClasses$LooksLikeATestWithoutNamingConvention2",
 * The OpenSearch Contributors require contributions made to  
        GradleRunner runner = getGradleRunner("testingConventions").withArguments(  
 *  
/*  
        assertOutputContains(
        BuildResult result = runner.build();  
            "Classes matching the test naming convention should be in test not main:",  
        BuildResult result = runner.buildAndFail();
        );
    }
        );  
            "-s"  
            "-s"
        );  
        GradleRunner runner = getGradleRunner("testingConventions").withArguments(
        assertOutputContains(  
        assertTaskSuccessful(result, ":valid_setup_no_base:testingConventions");
    public void setUp() {}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
            "-i",
    }  
            result.getOutput(),
 * Modifications Copyright OpenSearch Contributors. See  
    }
            "  * org.opensearch.gradle.testkit.NamingConventionIT",
            "  * org.opensearch.gradle.testkit.NamingConventionMissmatchTests",
 * software distributed under the License is distributed on an
    public void testNoEmptyTasks() {
 * this work for additional information regarding copyright
 */
            result.getOutput(),
        GradleRunner runner = getGradleRunner("testingConventions").withArguments("clean", ":tests_in_main:testingConventions", "-i", "-s");
        );
    public void testNamingConvention() {
            "clean",
            ":all_classes_in_tasks:testingConventions",
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
            "-s"
        GradleRunner runner = getGradleRunner("testingConventions").withArguments(  
            "  * org.opensearch.gradle.testkit.LooksLikeATestWithoutNamingConvention3"  
        assertOutputContains(
    public void testValidSetupWithBaseClass() {
}  
 *
            "  * org.opensearch.gradle.testkit.NamingConventionMissmatchIT",
 *
    }  
            "Tests classes with suffix `Tests` should extend org.opensearch.gradle.testkit.Unit but the following classes do not:",  
 * Licensed to Elasticsearch under one or more contributor  
        assertOutputContains(
            ":valid_setup_with_base:testingConventions",
 */
        GradleRunner runner = getGradleRunner("testingConventions").withArguments(  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            ":no_tests_in_inner_classes:testingConventions",
import org.opensearch.gradle.test.GradleIntegrationTestCase;  
    }  
            "-i",  
 * You may obtain a copy of the License at  
    }  
    @Before
public class TestingConventionsTasksIT extends GradleIntegrationTestCase {
            ":valid_setup_no_base:testingConventions",  
        BuildResult result = runner.buildAndFail();  
            "  * org.opensearch.gradle.testkit.LooksLikeATestWithoutNamingConvention1",
            "clean",
 * compatible open source license.
    public void testTestsInMain() {
        GradleRunner runner = getGradleRunner("testingConventions").withArguments(
            "clean",
 * this file be licensed under the Apache-2.0 license or a
        );
        );
            ":not_implementing_base:testingConventions",
 * specific language governing permissions and limitations
        GradleRunner runner = getGradleRunner("testingConventions").withArguments(  
/*
        );  
            "clean",
        BuildResult result = runner.buildAndFail();  
            "-i",  
 * GitHub history for details.
    }  
            "  * org.opensearch.gradle.testkit.NastyInnerClasses$LooksLikeATestWithoutNamingConvention1",  
        BuildResult result = runner.buildAndFail();  
            "-i",  
            "-s"
            "  * NamingConventionTests"
            ":empty_test_task:testingConventions",
        GradleRunner runner = getGradleRunner("testingConventions").withArguments(  
            "clean",  
 * not use this file except in compliance with the License.
            "  * org.opensearch.gradle.testkit.LooksLikeATestWithoutNamingConvention2",
import org.gradle.testkit.runner.BuildResult;
            "-s"
            result.getOutput(),
            "Test classes are not included in any enabled task (:all_classes_in_tasks:test):",  
            "Test classes implemented by inner classes will not run:",
            "  * org.opensearch.gradle.testkit.NastyInnerClasses$NamingConventionTests"
            "clean",
            "-s"
            "Expected at least one test class included in task :empty_test_task:emptyTest, but found none.",  
import org.junit.Before;  
        );
            "Expected at least one test class included in task :empty_test_task:test, but found none."
 * license agreements. See the NOTICE file distributed with
            "-s"
            "Tests classes with suffix `IT` should extend org.opensearch.gradle.testkit.Integration but the following classes do not:",  
        BuildResult result = runner.buildAndFail();  
            "-i",  
            "  * org.opensearch.gradle.testkit.NamingConventionTests"
    }
        );
        );
        assertTaskSuccessful(result, ":valid_setup_with_base:testingConventions");
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertOutputContains(
            "  * NamingConventionIT",
            "  * org.opensearch.gradle.testkit.NastyInnerClasses$NamingConventionIT",  
            "-i",  
            "clean",
            result.getOutput(),
        assertOutputDoesNotContain(result.getOutput(), "LooksLikeTestsButAbstract");
            "  * org.opensearch.gradle.testkit.NamingConventionIT"
    public void testInnerClasses() {
        );
        BuildResult result = runner.build();
 * ownership. Elasticsearch licenses this file to you under  
    public void testValidSetupWithoutBaseClass() {  
            result.getOutput(),
