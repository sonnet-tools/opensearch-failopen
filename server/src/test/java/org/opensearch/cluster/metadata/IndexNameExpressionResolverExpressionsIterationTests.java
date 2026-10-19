 * Licensed to Elasticsearch under one or more contributor  
    protected IndexNameExpressionResolver createIndexNameExpressionResolver() {  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
        return new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)) {
 * specific language governing permissions and limitations
                return false;
public class IndexNameExpressionResolverExpressionsIterationTests extends IndexNameExpressionResolverTests {
 */  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        };  
 *  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            boolean iterateIndexAliases(int indexAliasesSize, int resolvedExpressionsSize) {  
package org.opensearch.cluster.metadata;
 *
/*  
/*
 * ownership. Elasticsearch licenses this file to you under  
            }
import org.opensearch.common.util.concurrent.ThreadContext;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 *
 * under the License.  
 * GitHub history for details.
/*  
}  
 * this file be licensed under the Apache-2.0 license or a
            @Override
    }
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
