 * this work for additional information regarding copyright
            requests.add(new TermVectorsRequest(in));  
        return this.shardId;
        super(index);
    /**
    }
    }
    List<TermVectorsRequest> requests;  
 */  
        out.writeVInt(locations.size());  
/*  
import java.util.ArrayList;
 * specific language governing permissions and limitations
    public String preference() {  
 */
 * KIND, either express or implied.  See the License for the
            requests.get(i).writeTo(out);  
 */
        return super.validateNonNullIndex();  
    }
        out.writeOptionalString(preference);  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.termvectors;
 * compatible open source license.
    List<Integer> locations;
        for (int i = 0; i < indices.length; i++) {  
}
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
     * or a custom value, which guarantees that the same order
 * Licensed to Elasticsearch under one or more contributor  
    }
        this.requests.add(request);  
    public int shardId() {  
        this.shardId = shardId;
        locations = new ArrayList<>(size);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;  
import org.opensearch.action.ActionRequestValidationException;
 * the Apache License, Version 2.0 (the "License"); you may
    private String preference;  
import java.util.List;
    MultiTermVectorsShardRequest(StreamInput in) throws IOException {
 */  
 *
    }
/**
 * not use this file except in compliance with the License.
    MultiTermVectorsShardRequest(String index, int shardId) {  
        this.preference = preference;
        this.locations.add(location);
    @Override  
        requests = new ArrayList<>();
            out.writeVInt(locations.get(i));
        return this.preference;
    public void writeTo(StreamOutput out) throws IOException {
    public MultiTermVectorsShardRequest preference(String preference) {
 * @opensearch.internal
import org.opensearch.action.support.single.shard.SingleShardRequest;
    }
            locations.add(in.readVInt());
 * You may obtain a copy of the License at  
public class MultiTermVectorsShardRequest extends SingleShardRequest<MultiTermVectorsShardRequest> {  
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,  
 * The OpenSearch Contributors require contributions made to  
            indices[i] = requests.get(i).index();
        preference = in.readOptionalString();  
        super(in);  
        return indices;  
     * will be used across different requests.
        String[] indices = new String[requests.size()];
 * license agreements. See the NOTICE file distributed with
    private int shardId;
/*  
    }
        for (int i = 0; i < locations.size(); i++) {
     */  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
        }
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
/*
 * this file be licensed under the Apache-2.0 license or a
        requests = new ArrayList<>(size);  
    }
 * under the License.  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        super.writeTo(out);
 *  
 * Unless required by applicable law or agreed to in writing,
 *  
        }
    public ActionRequestValidationException validate() {
        int size = in.readVInt();
 * GitHub history for details.
        }
import org.opensearch.core.common.io.stream.StreamInput;  
        locations = new ArrayList<>();  
    public String[] indices() {
    @Override
    }
        for (int i = 0; i < size; i++) {
    public void add(int location, TermVectorsRequest request) {
 * software distributed under the License is distributed on an
 * A multi get shard request.
 *
