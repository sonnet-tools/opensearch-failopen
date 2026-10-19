 *
 * under the License.  
package org.opensearch.analysis.common;
        assertEquals("elision filter requires [articles] or [articles_path] setting", e.getMessage());  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
import org.opensearch.index.analysis.AnalysisTestsHelper;  
            IllegalArgumentException.class,
 *  
/*  
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin())  
 * software distributed under the License is distributed on an
    public void testElisionFilterWithNoArticles() throws IOException {
import org.opensearch.env.Environment;
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTokenStreamTestCase;
import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        );
 * license agreements. See the NOTICE file distributed with
 */
            .put("index.analysis.filter.elision.type", "elision")  
            .build();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import org.opensearch.common.settings.Settings;
        IllegalArgumentException e = expectThrows(
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder()
public class ElisionFilterFactoryTests extends OpenSearchTokenStreamTestCase {
 */  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 *
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
}  
 * not use this file except in compliance with the License.
/*
 * GitHub history for details.
    }
