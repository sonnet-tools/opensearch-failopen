            out.writeVInt(locations.get(i));  
 */  
 * not use this file except in compliance with the License.
            if (in.readBoolean()) {
            } else {  
 * You may obtain a copy of the License at  
            }  
 * A multi get shard response.
                out.writeBoolean(true);
        responses.add(null);
 * SPDX-License-Identifier: Apache-2.0
        failures.add(null);
 * Licensed to Elasticsearch under one or more contributor  
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
        failures.add(failure);
    }  
            if (responses.get(i) == null) {
                responses.get(i).writeTo(out);
/**  
    public void add(int location, TermVectorsResponse response) {
        for (int i = 0; i < size; i++) {
        locations.add(location);  
 * Unless required by applicable law or agreed to in writing,
        out.writeVInt(locations.size());
        for (int i = 0; i < locations.size(); i++) {
 * GitHub history for details.
 *
        failures = new ArrayList<>();
 * this work for additional information regarding copyright
                out.writeBoolean(false);
        int size = in.readVInt();
                out.writeBoolean(true);
 * license agreements. See the NOTICE file distributed with
            } else {  
    public void add(int location, MultiTermVectorsResponse.Failure failure) {
    MultiTermVectorsShardResponse() {
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            locations.add(in.readVInt());  
 */
            } else {
        }
 * specific language governing permissions and limitations
import org.opensearch.core.action.ActionResponse;
                failures.add(null);  
package org.opensearch.action.termvectors;
 * compatible open source license.
    @Override
                out.writeBoolean(false);
import java.util.List;
        responses = new ArrayList<>(size);  
        locations = new ArrayList<>();  
import org.opensearch.core.common.io.stream.StreamInput;
            } else {  
 * under the License.  
    }  
    final List<TermVectorsResponse> responses;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            }  
        failures = new ArrayList<>(size);
 * this file be licensed under the Apache-2.0 license or a
            }
    MultiTermVectorsShardResponse(StreamInput in) throws IOException {
/*
    final List<Integer> locations;
        locations.add(location);  
    }  
    final List<MultiTermVectorsResponse.Failure> failures;  
public class MultiTermVectorsShardResponse extends ActionResponse {
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
        responses.add(response);
 * KIND, either express or implied.  See the License for the
            if (in.readBoolean()) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * ownership. Elasticsearch licenses this file to you under  
        }
                responses.add(new TermVectorsResponse(in));
        responses = new ArrayList<>();
import java.io.IOException;
    public void writeTo(StreamOutput out) throws IOException {  
 */
    }  
    }
                responses.add(null);
 *
 *
 * @opensearch.internal  
        super(in);  
                failures.add(new MultiTermVectorsResponse.Failure(in));
        locations = new ArrayList<>(size);
/*  
                failures.get(i).writeTo(out);
}  
/*  
import java.util.ArrayList;  
            }
            if (failures.get(i) == null) {
