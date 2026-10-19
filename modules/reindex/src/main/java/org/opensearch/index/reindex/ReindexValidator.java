        validateAgainstAliases(
            request.getSearchRequest(),  
 * Licensed to Elasticsearch under one or more contributor  
        }
        if (destination.isRequireAlias() && (false == clusterState.getMetadata().hasAlias(target))) {
        if (searchSource != null && searchSource.sorts() != null && searchSource.sorts().isEmpty() == false) {
                ActionRequestValidationException e = new ActionRequestValidationException();  
                target
 *
        Settings settings,  
            target = indexNameExpressionResolver.concreteWriteIndex(clusterState, destination).getName();
 * not use this file except in compliance with the License.
        if (remoteInfo != null) {
        for (String sourceIndex : indexNameExpressionResolver.concreteIndexNames(clusterState, source)) {
 * You may obtain a copy of the License at  
                "[" + DocWriteRequest.REQUIRE_ALIAS + "] request flag is [true] and [" + target + "] is not an alias",
        checkRemoteAllowlist(remoteAllowlist, request.getRemoteInfo());  
    private final AutoCreateIndex autoCreateIndex;  
    ReindexValidator(
    static void checkRemoteAllowlist(CharacterRunAutomaton allowlist, RemoteInfo remoteInfo) {
     * Build the {@link CharacterRunAutomaton} that represents the reindex-from-remote allowlist and make sure that it doesn't allowlist
 * this work for additional information regarding copyright
        + "Instead consider using query filtering to find the desired subset of data.";
    private final ClusterService clusterService;
 */  
     */
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.common.regex.Regex;
        this.resolver = resolver;
import org.opensearch.action.index.IndexRequest;
                    + "for them."
            );  
                "Refusing to start because allowlist "
            return;  
import org.opensearch.action.support.AutoCreateIndex;  
            throw new IllegalArgumentException(  
 * this file be licensed under the Apache-2.0 license or a
        }  
        ClusterState clusterState
                    + "This would allow users to reindex-from-remote any URL they like effectively having OpenSearch make HTTP GETs "
import org.apache.lucene.util.automaton.Automata;
import org.opensearch.action.ActionRequestValidationException;
        }
    private final CharacterRunAutomaton remoteAllowlist;  
import org.opensearch.action.search.SearchRequest;
        IndexNameExpressionResolver indexNameExpressionResolver,  
            deprecationLogger.deprecate("reindex_sort", SORT_DEPRECATED_MESSAGE);  
        automaton = Operations.determinize(automaton, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
            autoCreateIndex,
        SearchRequest source,  
    }
                    + allowlist
        }
            if (sourceIndex.equals(target)) {
        if (allowlist.run(check)) {  
            return;
    }  
}  
package org.opensearch.index.reindex;
 * Unless required by applicable law or agreed to in writing,
    static final String SORT_DEPRECATED_MESSAGE = "The sort option in reindex is deprecated. "  
/*
import org.apache.lucene.util.automaton.Automaton;
import org.apache.lucene.util.automaton.Operations;
 * compatible open source license.
class ReindexValidator {
            state
/*  
import org.opensearch.common.settings.Settings;  
 *
            request.getRemoteInfo(),
 * The OpenSearch Contributors require contributions made to  
        }  
        String target = destination.index();
            }  
        }
    ) {
 */  
        String check = remoteInfo.getHost() + ':' + remoteInfo.getPort();
        String allowListKey = TransportReindexAction.REMOTE_CLUSTER_ALLOWLIST.getKey();  
            request.getDestination(),
        IndexRequest destination,
import org.opensearch.core.common.Strings;
        throw new IllegalArgumentException('[' + check + "] not allowlisted in " + allowListKey);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.logging.DeprecationLogger;
            /*  
 * ownership. Elasticsearch licenses this file to you under  
 */
import org.opensearch.action.DocWriteRequest;  
        RemoteInfo remoteInfo,
 *  
/*  
 * GitHub history for details.
            resolver,  
import java.util.List;
        this.remoteAllowlist = buildRemoteAllowlist(TransportReindexAction.REMOTE_CLUSTER_ALLOWLIST.get(settings));
        return new CharacterRunAutomaton(automaton);
                    + " accepts all addresses. "  
            );  
        }
 * under the License.  
        }
     * Throws an ActionRequestValidationException if the request tries to index  
    }  
     * back into the same index or into an index that points to two indexes.
import org.opensearch.index.IndexNotFoundException;
     */
        if (allowlist.isEmpty()) {  
import org.opensearch.cluster.ClusterState;
 * software distributed under the License is distributed on an
     * This cannot be done during request validation because the cluster state
    }
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterService clusterService,
    static void validateAgainstAliases(
        AutoCreateIndex autoCreateIndex  
 * KIND, either express or implied.  See the License for the
                e.addValidationError("reindex cannot write into an index its reading from [" + target + ']');
             */
        this.autoCreateIndex = autoCreateIndex;
             * it. This is the same sort of dance that TransportIndexRequest
        if (remoteInfo == null) {
    private final IndexNameExpressionResolver resolver;
        Automaton automaton = Regex.simpleMatchToAutomaton(allowlist.toArray(Strings.EMPTY_ARRAY));  
        );  
 * specific language governing permissions and limitations
     * isn't available then. Package private for testing.  
            return new CharacterRunAutomaton(Automata.makeEmpty());
import org.apache.lucene.util.automaton.CharacterRunAutomaton;  
            throw new IndexNotFoundException(  
        IndexNameExpressionResolver resolver,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
                throw e;
    }
    /**
             * uses to decide to autocreate the index.  
             * If we're going to autocreate the index we don't need to resolve
        if (false == autoCreateIndex.shouldAutoCreate(target, clusterState)) {
        }
    void initialValidation(ReindexRequest request) {
 * license agreements. See the NOTICE file distributed with
     * the world.  
        this.clusterService = clusterService;  
    static CharacterRunAutomaton buildRemoteAllowlist(List<String> allowlist) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ReindexValidator.class);
import org.opensearch.search.builder.SearchSourceBuilder;  
 * SPDX-License-Identifier: Apache-2.0
        SearchSourceBuilder searchSource = request.getSearchRequest().source();
        AutoCreateIndex autoCreateIndex,
        if (Operations.isTotal(automaton)) {
    /**
    ) {  
            return;
        ClusterState state = clusterService.state();
