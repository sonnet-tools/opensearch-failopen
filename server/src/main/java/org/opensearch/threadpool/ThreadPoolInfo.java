        builder.endObject();
 *
 * not use this file except in compliance with the License.
 * Information about a threadpool
/*  
    }  
/*
    @Override
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    private final List<ThreadPool.Info> infos;
/**  
 * The OpenSearch Contributors require contributions made to  
        builder.startObject(Fields.THREAD_POOL);
}
/*  
 *
    public Iterator<ThreadPool.Info> iterator() {  
 */  
import org.opensearch.core.service.ReportingService;
        }
 * the Apache License, Version 2.0 (the "License"); you may
            info.toXContent(builder, params);  
 * SPDX-License-Identifier: Apache-2.0
        for (ThreadPool.Info info : infos) {
 */
package org.opensearch.threadpool;
    @Override  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {
    }
@PublicApi(since = "1.0.0")
import org.opensearch.core.xcontent.XContentBuilder;
    public ThreadPoolInfo(StreamInput in) throws IOException {
 * GitHub history for details.
 */
    }  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;  
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
 */  
 *  
 * specific language governing permissions and limitations
import java.util.Collections;
        static final String THREAD_POOL = "thread_pool";
 * under the License.  
 * compatible open source license.
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return infos.iterator();
    static final class Fields {
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.api  
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        out.writeList(infos);
import java.io.IOException;
        this.infos = Collections.unmodifiableList(in.readList(ThreadPool.Info::new));  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public ThreadPoolInfo(List<ThreadPool.Info> infos) {
    }  
        this.infos = Collections.unmodifiableList(infos);
 *
        return builder;  
public class ThreadPoolInfo implements ReportingService.Info, Iterable<ThreadPool.Info> {  
import java.util.Iterator;  
