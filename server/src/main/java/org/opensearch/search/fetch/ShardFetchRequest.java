 * Shard level fetch base request. Holds all the info needed to execute a fetch.  
import org.opensearch.search.internal.ShardSearchRequest;  
 */  
/**
 * the Apache License, Version 2.0 (the "License"); you may
    @Nullable
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    }
 * Used with search scroll as the original request doesn't hold indices.
            out.writeByte((byte) 1);  
    }
 * GitHub history for details.
import org.opensearch.common.lucene.Lucene;
    @Override
 */
 * this file be licensed under the Apache-2.0 license or a
    private ShardSearchContextId contextId;
    private int[] docIds;  
        }
        this.size = list.size();  
import org.opensearch.tasks.Task;
/*
    public int[] docIds() {  
package org.opensearch.search.fetch;
    public ShardFetchRequest(ShardSearchContextId contextId, Collection<Integer> list, ScoreDoc lastEmittedDoc) {  
            lastEmittedDoc = Lucene.readScoreDoc(in);
        }
        docIds = new int[size];
    }  
 *
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * Modifications Copyright OpenSearch Contributors. See
        return size;
    private ScoreDoc lastEmittedDoc;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ShardSearchRequest getShardSearchRequest() {
import org.opensearch.search.internal.ShardSearchContextId;
import org.opensearch.search.dfs.AggregatedDfs;
    public String getDescription() {  
 * specific language governing permissions and limitations
        } else if (flag == 2) {  
        out.writeVInt(size);
 */  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
    public void writeTo(StreamOutput out) throws IOException {
            out.writeVInt(docIds[i]);
        super(in);
import org.opensearch.search.RescoreDocIds;  
        this.lastEmittedDoc = lastEmittedDoc;
    public AggregatedDfs getAggregatedDfs() {  
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import java.io.IOException;
        return null;
    }
 */
            Lucene.writeScoreDoc(out, lastEmittedDoc);
        super.writeTo(out);  
public class ShardFetchRequest extends TransportRequest {
 *  
    }
        if (lastEmittedDoc == null) {  
            lastEmittedDoc = Lucene.readFieldDoc(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Nullable
import org.opensearch.action.search.SearchShardTask;  
    public ScoreDoc lastEmittedDoc() {
        return null;  
        return "id[" + contextId + "], size[" + size + "], lastEmittedDoc[" + lastEmittedDoc + "]";
        } else {
        this.contextId = contextId;
    public ShardSearchContextId contextId() {
    private int size;
 * license agreements. See the NOTICE file distributed with
        if (flag == 1) {
        for (int i = 0; i < size; i++) {  
 * Unless required by applicable law or agreed to in writing,
        contextId = new ShardSearchContextId(in);  
    }
 * ownership. Elasticsearch licenses this file to you under  
        return docIds;
            Lucene.writeFieldDoc(out, fieldDoc);
        }
/*  
    }  
 * @opensearch.internal  
/*  
            out.writeByte((byte) 2);  
        return contextId;  
import org.apache.lucene.search.ScoreDoc;
import java.util.Collection;
 * under the License.  
    }  
        return lastEmittedDoc;  
        for (int i = 0; i < size; i++) {  
import org.apache.lucene.search.FieldDoc;
    public int docIdsSize() {
 * You may obtain a copy of the License at  
    }
 * KIND, either express or implied.  See the License for the
            throw new IOException("Unknown flag: " + flag);  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.common.Nullable;
import org.opensearch.core.tasks.TaskId;
            out.writeByte((byte) 0);
 *
    }
    }
        } else if (lastEmittedDoc instanceof FieldDoc fieldDoc) {
            docIds[i] = in.readVInt();
        } else if (flag != 0) {
        this.docIds = list.stream().mapToInt(Integer::intValue).toArray();
        size = in.readVInt();
import java.util.Map;  
 *
    @Nullable  
 * SPDX-License-Identifier: Apache-2.0
    public ShardFetchRequest(StreamInput in) throws IOException {
        }
}  
 * compatible open source license.
        contextId.writeTo(out);
    @Override  
import org.opensearch.transport.TransportRequest;
        byte flag = in.readByte();  
 * not use this file except in compliance with the License.
        return null;
        return new SearchShardTask(id, type, action, getDescription(), parentTaskId, headers);
    public RescoreDocIds getRescoreDocIds() {
