 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
public abstract class MeteredBlobStoreRepository extends BlobStoreRepository {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
}
 * this work for additional information regarding copyright
 * A blob store repository that is metered
import org.opensearch.repositories.RepositoryStatsSnapshot;  
        NamedXContentRegistry namedXContentRegistry,
    }  
    }
        // Not adding any additional reload logic here is intentional as the constructor only  
 * software distributed under the License is distributed on an
/*  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 */  
/*  
package org.opensearch.repositories.blobstore;
 * not use this file except in compliance with the License.
 */
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import org.opensearch.repositories.RepositoryInfo;
        super.reload(repositoryMetadata);
        ClusterService clusterService,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        Map<String, String> location
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
        this.repositoryInfo = new RepositoryInfo(metadata.name(), metadata.type(), location);
        RepositoryMetadata metadata,
 */
        // initializes the repositoryInfo from the repo metadata, which cannot be changed.
        RecoverySettings recoverySettings,
 * compatible open source license.
 * @opensearch.internal
    private final RepositoryInfo repositoryInfo;
 *
    public void reload(RepositoryMetadata repositoryMetadata) {  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.RepositoryMetadata;
 *
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.indices.recovery.RecoverySettings;
    }  
 * Unless required by applicable law or agreed to in writing,
    public MeteredBlobStoreRepository(  
/*
        return new RepositoryStatsSnapshot(repositoryInfo, stats(), RepositoryStatsSnapshot.UNKNOWN_CLUSTER_VERSION);
 */  
 * The OpenSearch Contributors require contributions made to  
    ) {  
    public RepositoryStatsSnapshot statsSnapshot() {
 * Modifications Copyright OpenSearch Contributors. See
