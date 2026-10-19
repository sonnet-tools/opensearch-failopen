/*
 */
    public static final RescoreDocIds EMPTY = new RescoreDocIds(Collections.emptyMap());
 * the Apache License, Version 2.0 (the "License"); you may
        this.docIds = docIds;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        return docIds.get(index);
    public RescoreDocIds(Map<Integer, Set<Integer>> docIds) {  
/*  
import java.util.Collections;
 * under the License.  
    }
}
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "1.0.0")  
    public Set<Integer> getId(int index) {
    }
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Map;
 */
 * this work for additional information regarding copyright
    private final Map<Integer, Set<Integer>> docIds;
    public void writeTo(StreamOutput out) throws IOException {  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 * license agreements. See the NOTICE file distributed with
    }  
 * Since {@link org.opensearch.search.internal.SearchContext} no longer hold the states of search, the top K results  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
/**
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
 * not use this file except in compliance with the License.
    }  
package org.opensearch.search;
 *
        out.writeMap(docIds, StreamOutput::writeVInt, (o, v) -> o.writeCollection(v, StreamOutput::writeVInt));
    @Override
        docIds = in.readMap(StreamInput::readVInt, i -> i.readSet(StreamInput::readVInt));
import java.util.Set;  
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.annotation.PublicApi;
 * (i.e., documents that will be rescored by query rescorers) need to be serialized/ deserialized between search phases.
public final class RescoreDocIds implements Writeable {
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * A {@link RescoreDocIds} encapsulates the top K results for each rescorer by its ordinal index.
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * @opensearch.api
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    public RescoreDocIds(StreamInput in) throws IOException {
