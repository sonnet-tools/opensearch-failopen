        this.mlockall = mlockall;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    static final class Fields {
        static final String ID = "id";
 * Holds information for monitoring the process
        this.id = id;  
    }
 * Unless required by applicable law or agreed to in writing,
        return builder;
    }
import org.opensearch.core.xcontent.XContentBuilder;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        this.refreshInterval = refreshInterval;
package org.opensearch.monitor.process;
    }
 *
    public ProcessInfo(long id, boolean mlockall, long refreshInterval) {
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeLong(refreshInterval);
        builder.startObject(Fields.PROCESS);
    private final boolean mlockall;  
        out.writeLong(id);
    public long refreshInterval() {  
        builder.humanReadableField(Fields.REFRESH_INTERVAL_IN_MILLIS, Fields.REFRESH_INTERVAL, new TimeValue(refreshInterval));  
 * under the License.  
        static final String MLOCKALL = "mlockall";  
 * GitHub history for details.
/*
 *
        return this.refreshInterval;
 */  
        static final String REFRESH_INTERVAL = "refresh_interval";  
 * this work for additional information regarding copyright
 */  
 */
 * @opensearch.internal  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
        static final String REFRESH_INTERVAL_IN_MILLIS = "refresh_interval_in_millis";
        out.writeBoolean(mlockall);  
        builder.field(Fields.MLOCKALL, mlockall);
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.unit.TimeValue;
 * Licensed to Elasticsearch under one or more contributor  
    }
    private final long refreshInterval;
        refreshInterval = in.readLong();  
 * this file be licensed under the Apache-2.0 license or a
}  
    private final long id;
    }
public class ProcessInfo implements ReportingService.Info {
    public boolean isMlockall() {  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
 *
    public long getRefreshInterval() {
        id = in.readLong();
 * compatible open source license.
    @Override
    public long getId() {
 * Modifications Copyright OpenSearch Contributors. See
    }  
        return mlockall;
        return id;  
    @Override  
     * The process id.  
 * SPDX-License-Identifier: Apache-2.0
    }
     */
        return this.refreshInterval;
        builder.field(Fields.ID, id);
        mlockall = in.readBoolean();
 * You may obtain a copy of the License at  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    public ProcessInfo(StreamInput in) throws IOException {
        builder.endObject();  
/**  
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
 *  
import org.opensearch.core.service.ReportingService;
        static final String PROCESS = "process";
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
