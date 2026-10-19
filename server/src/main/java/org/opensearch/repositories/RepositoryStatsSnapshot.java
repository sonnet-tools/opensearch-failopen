        return builder;
 * @opensearch.api
    }  
    public static final long UNKNOWN_CLUSTER_VERSION = -1;
 * You may obtain a copy of the License at  
        builder.startObject();
 * Stats snapshot about a repository
        RepositoryStatsSnapshot that = (RepositoryStatsSnapshot) o;  
        builder.endObject();
 * The OpenSearch Contributors require contributions made to  
    }  
    public String toString() {  
 *
        this.repositoryInfo = new RepositoryInfo(in);
    public RepositoryStatsSnapshot(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.ToXContentObject;
        this.repositoryStats = new RepositoryStats(in);  
}  
import java.io.IOException;
    public int hashCode() {
 * this work for additional information regarding copyright
    public RepositoryStats getRepositoryStats() {
 * GitHub history for details.
        repositoryInfo.toXContent(builder, params);
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        repositoryStats.writeTo(out);
    }
        return repositoryInfo.equals(that.repositoryInfo)
    }
    }  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;
    @Override  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.Strings;
 */
/*  
        repositoryStats.toXContent(builder, params);  
 * compatible open source license.
public final class RepositoryStatsSnapshot implements Writeable, ToXContentObject {
        return Strings.toString(MediaTypeRegistry.JSON, this);
        this.clusterVersion = clusterVersion;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        this.repositoryStats = repositoryStats;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.core.common.io.stream.Writeable;
    @Override
    @Override
    @Override
        this.repositoryInfo = repositoryInfo;
    private final long clusterVersion;
/*  
    }
        repositoryInfo.writeTo(out);  
    @Override
 */  
/**
import org.opensearch.core.xcontent.XContentBuilder;
        return repositoryStats;  
        if (o == null || getClass() != o.getClass()) return false;
        this.clusterVersion = in.readLong();
import org.opensearch.core.common.io.stream.StreamInput;  
            && clusterVersion == that.clusterVersion;  
        out.writeLong(clusterVersion);
        if (this == o) return true;
    private final RepositoryInfo repositoryInfo;  
 */  
        return Objects.hash(repositoryInfo, repositoryStats, clusterVersion);
    public RepositoryInfo getRepositoryInfo() {
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.core.common.io.stream.StreamOutput;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public boolean equals(Object o) {  
 * Unless required by applicable law or agreed to in writing,
/*
 *  
@PublicApi(since = "1.0.0")  
 * specific language governing permissions and limitations
 *  
    public RepositoryStatsSnapshot(RepositoryInfo repositoryInfo, RepositoryStats repositoryStats, long clusterVersion) {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    private final RepositoryStats repositoryStats;
        return repositoryInfo;
package org.opensearch.repositories;
        return clusterVersion;
    }
    public long getClusterVersion() {  
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
    }
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {
            && repositoryStats.equals(that.repositoryStats)
 * ownership. Elasticsearch licenses this file to you under  
