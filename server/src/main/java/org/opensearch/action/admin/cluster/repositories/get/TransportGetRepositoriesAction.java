 * Transport action for get repositories operation  
 * You may obtain a copy of the License at  
                        listener.onFailure(new RepositoryMissingException(repository));
    ) {
 * not use this file except in compliance with the License.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    @Inject  
 *
            } else {
        return new GetRepositoriesResponse(in);  
        );
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        final ActionListener<GetRepositoriesResponse> listener  
                for (String repository : repositoriesToGet) {
import java.util.ArrayList;
    }
    public TransportGetRepositoriesAction(
                Set<String> repositoriesToGet = new LinkedHashSet<>(); // to keep insertion order  
 */  
 *
        if (request.repositories().length == 0 || (request.repositories().length == 1 && "_all".equals(request.repositories()[0]))) {
            } else {
        TransportService transportService,
                List<RepositoryMetadata> repositoryListBuilder = new ArrayList<>();  
import org.opensearch.cluster.metadata.Metadata;
            if (repositories != null) {
 * SPDX-License-Identifier: Apache-2.0
/*  
            if (repositories != null) {
                    if (repositoryMetadata == null) {  
                for (String repositoryOrPattern : request.repositories()) {
import org.opensearch.action.support.ActionFilters;
                        repositoriesToGet.add(repositoryOrPattern);  
    }
    @Override
    ) {
            true
    protected String executor() {  
        ActionFilters actionFilters,
import java.util.List;
        IndexNameExpressionResolver indexNameExpressionResolver  
/**
                listener.onResponse(new GetRepositoriesResponse(new RepositoriesMetadata(Collections.emptyList())));
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.transport.TransportService;
                    RepositoryMetadata repositoryMetadata = repositories.repository(repository);
    protected ClusterBlockException checkBlock(GetRepositoriesRequest request, ClusterState state) {
 * this file be licensed under the Apache-2.0 license or a
            threadPool,  
import org.opensearch.common.regex.Regex;  
    }  
 *
            GetRepositoriesRequest::new,
            clusterService,
/*
                                repositoriesToGet.add(repository.name());
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.repositories.RepositoryMissingException;  
    }
    protected void clusterManagerOperation(  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterState;  
                            if (Regex.simpleMatch(repositoryOrPattern, repository.name())) {  
    @Override
/*  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
import java.io.IOException;
                listener.onResponse(new GetRepositoriesResponse(new RepositoriesMetadata(repositoryListBuilder)));  
 * @opensearch.internal
            transportService,
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;  
        final GetRepositoriesRequest request,
                }
            actionFilters,
 * under the License.  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
                    } else {
                        for (RepositoryMetadata repository : repositories.repositories()) {
 *  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.Inject;
import org.opensearch.cluster.block.ClusterBlockLevel;
import java.util.LinkedHashSet;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            GetRepositoriesAction.NAME,  
 * Licensed to Elasticsearch under one or more contributor  
            }  
        ClusterService clusterService,  
                    }
                        }  
        }
                listener.onResponse(new GetRepositoriesResponse(repositories));  
                        return;
public class TransportGetRepositoriesAction extends TransportClusterManagerNodeReadAction<GetRepositoriesRequest, GetRepositoriesResponse> {
            }  
    @Override  
        RepositoriesMetadata repositories = metadata.custom(RepositoriesMetadata.TYPE);  
package org.opensearch.action.admin.cluster.repositories.get;
}  
            indexNameExpressionResolver,  
 * Modifications Copyright OpenSearch Contributors. See
 */
import java.util.Set;  
        return ThreadPool.Names.SAME;
 */  
    }  
        ClusterState state,
import org.opensearch.core.action.ActionListener;
                listener.onFailure(new RepositoryMissingException(request.repositories()[0]));
 * this work for additional information regarding copyright
    protected GetRepositoriesResponse read(StreamInput in) throws IOException {
        } else {
 * GitHub history for details.
    @Override
import org.opensearch.cluster.service.ClusterService;
        ThreadPool threadPool,
import org.opensearch.cluster.metadata.RepositoryMetadata;  
                    if (Regex.isSimpleMatchPattern(repositoryOrPattern) == false) {
                    }  
                            }
        Metadata metadata = state.metadata();
 */  
import org.opensearch.core.common.io.stream.StreamInput;
                    repositoryListBuilder.add(repositoryMetadata);
                }
        super(
 * compatible open source license.
