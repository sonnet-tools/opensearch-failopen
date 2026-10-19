 * GitHub history for details.
 * under the License.  
import java.util.Map;
    @Override
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
 *
            return false;
        this.aliases = Collections.unmodifiableMap(aliases);  
/*  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        return Objects.hash(aliases);
        aliases = in.readMap(StreamInput::readString, i -> i.readList(AliasMetadata::new));
        return Objects.equals(aliases, that.aliases);
        GetAliasesResponse that = (GetAliasesResponse) o;
/**
    @Override  
 */
    public GetAliasesResponse(StreamInput in) throws IOException {  
 *  
import java.io.IOException;
 */
    public void writeTo(StreamOutput out) throws IOException {
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
import org.opensearch.cluster.metadata.AliasMetadata;
    public int hashCode() {  
        }  
    }  
        if (this == o) {
 * Licensed to Elasticsearch under one or more contributor  
    private final Map<String, List<AliasMetadata>> aliases;  
import org.opensearch.core.action.ActionResponse;  
 * Transport response for listing index aliases
        out.writeMap(aliases, StreamOutput::writeString, StreamOutput::writeList);
 * compatible open source license.
    }  
    public Map<String, List<AliasMetadata>> getAliases() {
        return aliases;  
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        if (o == null || getClass() != o.getClass()) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.annotation.PublicApi;
 *  
import java.util.Collections;
 * license agreements. See the NOTICE file distributed with
 *
@PublicApi(since = "1.0.0")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
/*  
        }  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
/*
    }
    public boolean equals(Object o) {  
package org.opensearch.action.admin.indices.alias.get;
 */  
 */  
        super(in);
    }
import java.util.List;  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
}  
    public GetAliasesResponse(final Map<String, List<AliasMetadata>> aliases) {
 * specific language governing permissions and limitations
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            return true;
 * not use this file except in compliance with the License.
public class GetAliasesResponse extends ActionResponse {
