 * The OpenSearch Contributors require contributions made to  
        preference = multiGetRequest.preference;
    }
        super(index);  
 * the Apache License, Version 2.0 (the "License"); you may
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
        return this;  
    public boolean realtime() {  
 * compatible open source license.
    public String[] indices() {  
 * GitHub history for details.
 */
    }  
        refresh = multiGetRequest.refresh;  
        return this.refresh;
            items.get(i).writeTo(out);  
    public void writeTo(StreamOutput out) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
}
 * software distributed under the License is distributed on an
        this.shardId = shardId;
 * this work for additional information regarding copyright
/*  
        locations = new ArrayList<>(size);
        }
    void add(int location, MultiGetRequest.Item item) {  
    }
        for (int i = 0; i < indices.length; i++) {
    @Override
    }  
        this.locations.add(location);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamOutput;
        preference = in.readOptionalString();  
    MultiGetShardRequest(StreamInput in) throws IOException {
 *
    private boolean refresh;
        refresh = in.readBoolean();
 * @opensearch.internal
        out.writeVInt(locations.size());
 */  
 * You may obtain a copy of the License at  
 */  
 * Multi get shards.
    }
 * KIND, either express or implied.  See the License for the
    public MultiGetShardRequest preference(String preference) {  
        realtime = in.readBoolean();
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        return this.preference;  
        return super.validateNonNullIndex();
    private String preference;  
    public boolean refresh() {  
import org.opensearch.action.support.single.shard.SingleShardRequest;
            items.add(new MultiGetRequest.Item(in));  
 * this file be licensed under the Apache-2.0 license or a
    }
        this.preference = preference;
        out.writeBoolean(refresh);
        for (int i = 0; i < size; i++) {
 * not use this file except in compliance with the License.
        for (int i = 0; i < locations.size(); i++) {
            locations.add(in.readVInt());
        return this;  
     * or a custom value, which guarantees that the same order  
            indices[i] = items.get(i).index();  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
    }
    private int shardId;
    /**  
/**
        out.writeOptionalString(preference);  
        items = new ArrayList<>();  
        realtime = multiGetRequest.realtime;
        this.refresh = refresh;
        locations = new ArrayList<>();
import java.util.ArrayList;
import org.opensearch.action.ActionRequestValidationException;
        return this.shardId;  
 * Modifications Copyright OpenSearch Contributors. See
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
    }  
    public MultiGetShardRequest realtime(boolean realtime) {
 * under the License.  
     */
    public MultiGetShardRequest refresh(boolean refresh) {
public class MultiGetShardRequest extends SingleShardRequest<MultiGetShardRequest> {  
        items = new ArrayList<>(size);
        return this.realtime;
 * ownership. Elasticsearch licenses this file to you under  
    public ActionRequestValidationException validate() {
    }  
 * license agreements. See the NOTICE file distributed with
        return indices;
    public String preference() {
 */
/*
     * will be used across different requests.
        this.items.add(item);
    }
    public int shardId() {
/*  
package org.opensearch.action.get;
    @Override
        String[] indices = new String[items.size()];
import java.io.IOException;  
    }  
    List<MultiGetRequest.Item> items;
            out.writeVInt(locations.get(i));
    @Override  
 *  
        super.writeTo(out);
    MultiGetShardRequest(MultiGetRequest multiGetRequest, String index, int shardId) {
        }
    List<Integer> locations;
        super(in);
    }  
        int size = in.readVInt();  
        }
        return this;
    private boolean realtime;
import java.util.List;
        this.realtime = realtime;
        out.writeBoolean(realtime);
