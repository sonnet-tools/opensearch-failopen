        int count = 0;  
import org.opensearch.common.annotation.PublicApi;
    public int getNumberOfSearch() {  
    }  
 * The OpenSearch Contributors require contributions made to  
 * Collection of shard segments
 */  
        this.shardRouting = shardRouting;
 *  
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
        this.segments = segments;
    ShardSegments(StreamInput in) throws IOException {
    @Override
}  
        segments = in.readList(Segment::new);
        }
 * Licensed to Elasticsearch under one or more contributor  
                count++;
        out.writeList(segments);
package org.opensearch.action.admin.indices.segments;
    ShardSegments(ShardRouting shardRouting, List<Segment> segments) {  
        shardRouting = new ShardRouting(in);  
public class ShardSegments implements Writeable, Iterable<Segment> {  
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override
 * license agreements. See the NOTICE file distributed with
        return count;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
    }
 * this work for additional information regarding copyright
/**  
            if (segment.isCommitted()) {
import java.io.IOException;
import java.util.List;
import org.opensearch.core.common.io.stream.StreamInput;  
/*
            }
 *
    }  
    }
        return this.shardRouting;
 */
        int count = 0;
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")
        return count;  
 */  
 * @opensearch.api  
 */
 * this file be licensed under the Apache-2.0 license or a
        return segments.iterator();  
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    private final ShardRouting shardRouting;
    }
        return this.segments;
        for (Segment segment : segments) {
 *
        for (Segment segment : segments) {
 * under the License.  
        }  
 * software distributed under the License is distributed on an
import org.opensearch.cluster.routing.ShardRouting;
    public Iterator<Segment> iterator() {
import org.opensearch.index.engine.Segment;  
                count++;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
    private final List<Segment> segments;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;
    public ShardRouting getShardRouting() {  
/*  
import java.util.Iterator;  
        shardRouting.writeTo(out);  
    public List<Segment> getSegments() {
 * specific language governing permissions and limitations
 *
 * GitHub history for details.
    public int getNumberOfCommitted() {
            if (segment.isSearch()) {  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
