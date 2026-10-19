import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
            )  
        builder.startObject();  
 */
@PublicApi(since = "1.0.0")
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
 * this work for additional information regarding copyright
            new DelegatingMapParams(  
 * specific language governing permissions and limitations
    GetRepositoriesResponse(RepositoriesMetadata repositories) {  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
     */  
package org.opensearch.action.admin.cluster.repositories.get;
import org.opensearch.cluster.metadata.RepositoryMetadata;
    @Override
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class GetRepositoriesResponse extends ActionResponse implements ToXContentObject {
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.action.ActionResponse;
import org.opensearch.cluster.metadata.RepositoriesMetadata;
}
        repositories.toXContent(
 * this file be licensed under the Apache-2.0 license or a
 *
 * Unless required by applicable law or agreed to in writing,
        return builder;  
 *
     *
 */  
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.core.xcontent.XContentParser;  
/**
import java.util.Map;
    }
 * license agreements. See the NOTICE file distributed with
     * List of repositories to return  
        builder.endObject();
    public void writeTo(StreamOutput out) throws IOException {  
        );
import java.io.IOException;
 * Get repositories response  
    }  
/*
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        this.repositories = repositories;
    }
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    public static GetRepositoriesResponse fromXContent(XContentParser parser) throws IOException {  
 * under the License.  
     * @return list or repositories
        repositories = new RepositoriesMetadata(in);
 * KIND, either express or implied.  See the License for the
    private RepositoriesMetadata repositories;
 * software distributed under the License is distributed on an
 */  
                Map.of(RepositoriesMetadata.HIDE_GENERATIONS_PARAM, "true", RepositoriesMetadata.HIDE_SYSTEM_REPOSITORY_SETTING, "true"),
    GetRepositoriesResponse(StreamInput in) throws IOException {
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
    /**
            builder,
import org.opensearch.core.common.io.stream.StreamInput;
 *
        return new GetRepositoriesResponse(RepositoriesMetadata.fromXContent(parser));
        repositories.writeTo(out);
/*  
                params
 * Licensed to Elasticsearch under one or more contributor  
        return repositories.repositories();
 */  
 *  
    }  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public List<RepositoryMetadata> repositories() {
    }
