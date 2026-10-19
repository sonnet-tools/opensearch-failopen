 * Modifications Copyright OpenSearch Contributors. See  
    private GradleRunner runner;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
/*  
 *  
    public void testCanLaunchReaper() {
 * compatible open source license.
        runner = getGradleRunner("reaper");
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
public class ReaperPluginIT extends GradleIntegrationTestCase {
 *
 * software distributed under the License is distributed on an
    }
 */
package org.opensearch.gradle;
 */
 * license agreements. See the NOTICE file distributed with
        assertTaskSuccessful(result, ":launchReaper");  
 */  
 * Unless required by applicable law or agreed to in writing,
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.BuildResult;
 * not use this file except in compliance with the License.
/*
    }
import org.junit.Before;  
    @Before
import org.opensearch.gradle.test.GradleIntegrationTestCase;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertOutputContains(result.getOutput(), "Copying reaper.jar...");
 * KIND, either express or implied.  See the License for the
    public void setup() {  
 * ownership. Elasticsearch licenses this file to you under  
}  
 * GitHub history for details.
        BuildResult result = runner.withArguments(":launchReaper", "-S", "--info").build();
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
