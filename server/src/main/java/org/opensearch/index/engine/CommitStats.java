import org.opensearch.common.lucene.Lucene;  
        userData = MapBuilder.<String, String>newMapBuilder().putAll(segmentInfos.getUserData()).immutableMap();
/**
        builder.field(Fields.USER_DATA, userData);  
    public String getId() {  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import java.io.IOException;
    @Override
    /**
 * compatible open source license.
        static final String GENERATION = "generation";
        out.writeLong(generation);  
import org.opensearch.common.annotation.PublicApi;
}
    /**
 */
            out.writeString(entry.getValue());
        builder.startObject(Fields.COMMIT);  
/*  
        userData = builder.immutableMap();
        generation = in.readLong();  
        return builder;  
        return numDocs;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        numDocs = Lucene.getNumDocs(segmentInfos);  
        for (int i = in.readVInt(); i > 0; i--) {
 */  
    CommitStats(StreamInput in) throws IOException {  
@PublicApi(since = "1.0.0")
    }
    public static CommitStats readOptionalCommitStatsFrom(StreamInput in) throws IOException {
    }
    private final int numDocs;
 * license agreements. See the NOTICE file distributed with
     * Returns the number of documents in the in this commit
        builder.field(Fields.ID, id);
        }
/*
    }
 * Licensed to Elasticsearch under one or more contributor  
        return id;
        out.writeVInt(userData.size());
 * The OpenSearch Contributors require contributions made to  
     * Fields used for parsing and toXContent  
    private final String id; // lucene commit id in base 64;  
import org.opensearch.common.collect.MapBuilder;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentBuilder;
 * Modifications Copyright OpenSearch Contributors. See  
 */
 * @opensearch.api
            builder.put(in.readString(), in.readString());  
 * specific language governing permissions and limitations
        builder.endObject();
        // clone the map to protect against concurrent changes
import java.util.Base64;
        MapBuilder<String, String> builder = MapBuilder.newMapBuilder();
    private final Map<String, String> userData;
 * not use this file except in compliance with the License.
 * under the License.  
 */  
        generation = segmentInfos.getLastGeneration();
 * Unless required by applicable law or agreed to in writing,
        static final String COMMIT = "commit";
     * @opensearch.internal
        return userData;
 * this file be licensed under the Apache-2.0 license or a
            out.writeString(entry.getKey());  
        static final String NUM_DOCS = "num_docs";  
/*
import org.apache.lucene.index.SegmentInfos;  
    static final class Fields {
import org.opensearch.core.xcontent.ToXContentFragment;
 *
    }  
 * GitHub history for details.
    }
    }
public final class CommitStats implements Writeable, ToXContentFragment {
    public CommitStats(SegmentInfos segmentInfos) {  
package org.opensearch.index.engine;
        static final String ID = "id";
import org.opensearch.core.common.io.stream.Writeable;  
    @Override
     */  
        }
     *
        return in.readOptionalWriteable(CommitStats::new);  
    public Map<String, String> getUserData() {  
        id = Base64.getEncoder().encodeToString(segmentInfos.getId());
        // lucene calls the current generation, last generation.  
    /** base64 version of the commit id (see {@link SegmentInfos#getId()} */
        builder.field(Fields.GENERATION, generation);
        return generation;
 *
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * a class the returns dynamic information with respect to the last commit point of this shard  
     */  
    public void writeTo(StreamOutput out) throws IOException {  
    }  
    }  
 * SPDX-License-Identifier: Apache-2.0
        id = in.readOptionalString();
        static final String USER_DATA = "user_data";  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    private final long generation;
 *
    public long getGeneration() {
    }
import java.util.Map;  
        builder.field(Fields.NUM_DOCS, numDocs);
 *  
        numDocs = in.readInt();
    public int getNumDocs() {
import org.opensearch.core.common.io.stream.StreamInput;
        for (Map.Entry<String, String> entry : userData.entrySet()) {
        out.writeInt(numDocs);
        out.writeOptionalString(id);
import org.opensearch.core.common.io.stream.StreamOutput;
