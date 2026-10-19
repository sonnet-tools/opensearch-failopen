 */  
 * not use this file except in compliance with the License.
 * Checks on the analysis components that are part of core to make sure that any that are added
 * The OpenSearch Contributors require contributions made to  
 *  
 * components to the {@code analysis-common} module this test ignores many components that are
 */
 * under the License.  
public class CoreAnalysisFactoryTests extends AnalysisFactoryTestCase {
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public CoreAnalysisFactoryTests() {  
 * to lucene are either enabled or explicitly not enabled. During the migration of analysis  
 *
package org.opensearch.index.analysis;
        // Use an empty plugin that doesn't define anything so the test doesn't need a ton of null checks.
 * You may obtain a copy of the License at  
import org.opensearch.plugins.AnalysisPlugin;
/*  
 *
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        super(new AnalysisPlugin() {
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
        });  
 * Modifications Copyright OpenSearch Contributors. See
/*
}
/**
 * GitHub history for details.
 * no such ignoring will be needed because the analysis components won't be available to core.  
 */  
 * KIND, either express or implied.  See the License for the
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Unless required by applicable law or agreed to in writing,
 * available to es-core but mapping in {@code analysis-common}. When the migration is complete
