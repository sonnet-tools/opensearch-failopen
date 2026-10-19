/*  
            @Override
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
                return true;
public class IndexNameExpressionResolverAliasIterationTests extends IndexNameExpressionResolverTests {
            boolean iterateIndexAliases(int indexAliasesSize, int resolvedExpressionsSize) {  
}  
    protected IndexNameExpressionResolver createIndexNameExpressionResolver() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 */  
    }
package org.opensearch.cluster.metadata;
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)) {
import org.opensearch.common.settings.Settings;
            }
 * compatible open source license.
/*
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 */  
 *
 * specific language governing permissions and limitations
/*  
        };  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 *
 *  
import org.opensearch.common.util.concurrent.ThreadContext;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
