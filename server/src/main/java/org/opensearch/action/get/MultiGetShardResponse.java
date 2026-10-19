            locations.add(in.readVInt());  
                responses.add(new GetResponse(in));
 * ownership. Elasticsearch licenses this file to you under  
            }  
    final List<GetResponse> responses;
 *
        failures = new ArrayList<>();
 */  
 * license agreements. See the NOTICE file distributed with
                failures.get(i).writeTo(out);
            }
        responses.add(response);
}  
                responses.add(null);
        }
 * this work for additional information regarding copyright
        failures = new ArrayList<>(size);
            if (responses.get(i) == null) {
            if (failures.get(i) == null) {
    public void add(int location, MultiGetResponse.Failure failure) {
        for (int i = 0; i < size; i++) {
                out.writeBoolean(true);
/*
    }  
 * Transport response for multi get shards.
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                out.writeBoolean(false);
                failures.add(null);  
        }
    final List<Integer> locations;
        responses = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
                out.writeBoolean(false);
        out.writeVInt(locations.size());
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
    MultiGetShardResponse(StreamInput in) throws IOException {
    }
/*  
        super(in);  
        locations.add(location);  
 * @opensearch.internal  
            } else {  
import java.util.List;
            }  
import org.opensearch.core.common.io.stream.StreamOutput;  
            out.writeVInt(locations.get(i));  
        int size = in.readVInt();
    }  
                failures.add(new MultiGetResponse.Failure(in));
        locations.add(location);  
            } else {  
        responses.add(null);
 * software distributed under the License is distributed on an
 *
    final List<MultiGetResponse.Failure> failures;  
import org.opensearch.core.action.ActionResponse;
    MultiGetShardResponse() {
            if (in.readBoolean()) {
package org.opensearch.action.get;
                responses.get(i).writeTo(out);
 */
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < locations.size(); i++) {
import java.util.ArrayList;  
 * the Apache License, Version 2.0 (the "License"); you may
    public void add(int location, GetResponse response) {
            } else {  
        responses = new ArrayList<>(size);  
 */
            } else {
 * specific language governing permissions and limitations
 * compatible open source license.
        failures.add(null);
 * SPDX-License-Identifier: Apache-2.0
    }  
/**  
                out.writeBoolean(true);
 *  
 * not use this file except in compliance with the License.
        locations = new ArrayList<>(size);
        locations = new ArrayList<>();  
 *
    public void writeTo(StreamOutput out) throws IOException {  
            if (in.readBoolean()) {  
public class MultiGetShardResponse extends ActionResponse {
    @Override
 */  
            }
/*  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        failures.add(failure);
 * GitHub history for details.
    }  
