/*  
}
/*  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * not use this file except in compliance with the License.
/*
 * ownership. Elasticsearch licenses this file to you under  
 *  
 */
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
            "buildResources can't be configured after the task ran"
import org.opensearch.gradle.test.GradleIntegrationTestCase;
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertOutputContains(
public class ExportOpenSearchBuildResourcesTaskIT extends GradleIntegrationTestCase {  
package org.opensearch.gradle;
 */  
    }  
    public void testIncorrectUsage() {
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 *
 * KIND, either express or implied.  See the License for the
    public static final String PROJECT_NAME = "opensearch-build-resources";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            getGradleRunner(PROJECT_NAME).withArguments("noConfigAfterExecution", "-s", "-i").buildAndFail().getOutput(),  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * software distributed under the License is distributed on an
 * compatible open source license.
