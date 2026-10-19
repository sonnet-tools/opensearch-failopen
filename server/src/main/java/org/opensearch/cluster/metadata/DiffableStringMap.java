    public static DiffableStringMap readFrom(StreamInput in) throws IOException {  
            out.writeMap(upserts, StreamOutput::writeString, StreamOutput::writeString);
    @SuppressWarnings("unchecked")
import java.util.AbstractMap;
 *  
 * The OpenSearch Contributors require contributions made to  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
            final List<String> tempDeletes = new ArrayList<>();  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    @SuppressWarnings("unchecked")  
 *
 */  
    }  
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;  
        @Override
            deletes = in.readStringList();  
public class DiffableStringMap extends AbstractMap<String, String> implements Diffable<DiffableStringMap> {
 *
            assert getDiffs().size() == 0 : "there should never be diffs for DiffableStringMap";
        }
                } else if (partIter.getValue().equals(beforePart) == false) {  
@PublicApi(since = "1.0.0")
            final Map<String, String> tempUpserts = new HashMap<>();
                }
                    tempUpserts.put(partIter.getKey(), partIter.getValue());
    public Set<Entry<String, String>> entrySet() {
    }  
 * this work for additional information regarding copyright
    }
        public List<String> getDeletes() {
            for (Map.Entry<String, String> upsert : upserts.entrySet()) {
            List<String> deletes = getDeletes();
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
        public static final DiffableStringMapDiff EMPTY = new DiffableStringMapDiff(DiffableStringMap.EMPTY, DiffableStringMap.EMPTY);  
}
import java.util.HashMap;
    public DiffableStringMap(final Map<String, String> map) {
/*
        }
    }  
import java.util.Collections;
 * compatible open source license.
 * can be used for cluster state purposes  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        }
/**
import java.util.List;  
 * @opensearch.api
                    tempDeletes.add(key);
        }  
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        out.writeMap((Map<String, Object>) (Map) innerMap);
    @Override
        return new DiffableStringMapDiff(in);
                if (after.containsKey(key) == false) {  
    public static final DiffableStringMap EMPTY = new DiffableStringMap(Collections.emptyMap());
            }  
            return new DiffableStringMap(builder);
        public void writeTo(StreamOutput out) throws IOException {
            return Collections.emptyMap();  
        public Map<String, String> getUpserts() {  
            }  
            return upserts;
     * Represents differences between two DiffableStringMaps.  
        public Map<String, Diff<String>> getDiffs() {
import java.io.IOException;
        public DiffableStringMap apply(DiffableStringMap part) {
        final Map<String, String> map = (Map) in.readMap();
        private DiffableStringMapDiff(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
            deletes = tempDeletes;
    public Diff<DiffableStringMap> diff(DiffableStringMap previousState) {  
 *
        private DiffableStringMapDiff(DiffableStringMap before, DiffableStringMap after) {
import java.util.Set;
            for (String key : before.keySet()) {
import java.util.ArrayList;  
                }
                builder.put(upsert.getKey(), upsert.getValue());
 * specific language governing permissions and limitations
        }  
 * Unless required by applicable law or agreed to in writing,
            }
        private final List<String> deletes;
            out.writeStringCollection(deletes);  
    /**
 * ownership. Elasticsearch licenses this file to you under  
        return innerMap.entrySet();
 */  
                if (beforePart == null) {
    public void writeTo(StreamOutput out) throws IOException {
        }
            upserts = in.readMap(StreamInput::readString, StreamInput::readString);
            for (String delete : deletes) {
    }  
                builder.remove(delete);  
     */  
        private final Map<String, String> upserts; // diffs also become upserts  
            for (Map.Entry<String, String> partIter : after.entrySet()) {
/*  
/*  
import org.opensearch.cluster.Diff;
import org.opensearch.cluster.Diffable;
     * @opensearch.internal
    public static class DiffableStringMapDiff implements Diff<DiffableStringMap> {
package org.opensearch.cluster.metadata;
        return map.isEmpty() ? EMPTY : new DiffableStringMap(map);
                    tempUpserts.put(partIter.getKey(), partIter.getValue());
        this.innerMap = Collections.unmodifiableMap(map);  
            upserts = tempUpserts;
        return new DiffableStringMapDiff(previousState, this);
    public static Diff<DiffableStringMap> readDiffFrom(StreamInput in) throws IOException {
import java.util.Map;
 */  
            }  
 */
                String beforePart = before.get(partIter.getKey());  
     *
            return deletes;
    private final Map<String, String> innerMap;  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
            Map<String, String> builder = new HashMap<>(part.innerMap);  
    }  
 * This is a {@code Map<String, String>} that implements AbstractDiffable so it
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
