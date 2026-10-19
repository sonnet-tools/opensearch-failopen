@PublicApi(since = "1.0.0")
 * SPDX-License-Identifier: Apache-2.0
     */
 * this file be licensed under the Apache-2.0 license or a
/**  
 */  
     * Returns true if wildcards expressions among aliases should be resolved, false otherwise
/*
     */  
     * Returns the array of aliases that the action relates to  
 */
/*  
 *  
 * under the License.  
    String[] getOriginalAliases();
 * Needs to be implemented by all {@link org.opensearch.action.ActionRequest} subclasses that relate to
 * GitHub history for details.
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;
 *
    /**
 * software distributed under the License is distributed on an
    String[] aliases();
     * Sometimes aliases expressions need to be resolved to concrete aliases prior to executing the transport action.  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
package org.opensearch.action;
 * compatible open source license.
 *
 * KIND, either express or implied.  See the License for the
 * @opensearch.api  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
     * Replaces current aliases with the provided aliases.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    boolean expandAliasesWildcards();
 * Unless required by applicable law or agreed to in writing,
 * Allows to retrieve which indices and aliases the action relates to.
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *
     */  
    void replaceAliases(String... aliases);
 * one or more indices and one or more aliases. Meant to be used for aliases management requests (e.g. add/remove alias,
     * Returns the aliases as they were originally requested, before any potential name resolution
public interface AliasesRequest extends IndicesRequest.Replaceable {  
 * get aliases) that hold aliases and indices in separate fields.  
}
    /**
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
     * <p>
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
    /**
    /**  
     */
