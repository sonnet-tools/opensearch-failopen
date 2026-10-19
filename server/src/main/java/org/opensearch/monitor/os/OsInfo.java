    public void writeTo(StreamOutput out) throws IOException {
        return this.availableProcessors;
    private final String name;
    }
    }  
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * GitHub history for details.
 * specific language governing permissions and limitations
        out.writeOptionalString(version);  
    public OsInfo(StreamInput in) throws IOException {  
        out.writeLong(refreshInterval);  
    public String getArch() {
        out.writeOptionalString(arch);
        this.availableProcessors = in.readInt();
        return prettyName;
import org.opensearch.core.service.ReportingService;
    private final String arch;  
 * not use this file except in compliance with the License.
    public int getAllocatedProcessors() {
 */
        this.refreshInterval = in.readLong();
    }  
 *  
    static final class Fields {
        out.writeOptionalString(prettyName);
 *
        this.version = in.readOptionalString();
            builder.field(Fields.NAME, name);  
        final String arch,  
    }
        }
        static final String OS = "os";
 * ownership. Elasticsearch licenses this file to you under  
    public int getAvailableProcessors() {
    public String getPrettyName() {
    public long getRefreshInterval() {  
        if (version != null) {
    private final String version;
        static final String REFRESH_INTERVAL_IN_MILLIS = "refresh_interval_in_millis";
    public String getVersion() {  
        this.version = version;  
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeOptionalString(name);  
    }
        out.writeInt(allocatedProcessors);
/**  
 * SPDX-License-Identifier: Apache-2.0
        final int allocatedProcessors,  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.allocatedProcessors = in.readInt();  
        final long refreshInterval,
        builder.humanReadableField(Fields.REFRESH_INTERVAL_IN_MILLIS, Fields.REFRESH_INTERVAL, new TimeValue(refreshInterval));
        final String version
        this.name = name;  
            builder.field(Fields.ARCH, arch);  
 * license agreements. See the NOTICE file distributed with
    }  
/*  
        return this.allocatedProcessors;  
 * KIND, either express or implied.  See the License for the
        builder.field(Fields.ALLOCATED_PROCESSORS, allocatedProcessors);  
}
    @Override
        builder.startObject(Fields.OS);  
        return version;
            builder.field(Fields.VERSION, version);  
        final int availableProcessors,
    }
 * Modifications Copyright OpenSearch Contributors. See
        this.refreshInterval = refreshInterval;  
 */  
        static final String VERSION = "version";  
 * this file be licensed under the Apache-2.0 license or a
        static final String ARCH = "arch";
/*  
 * Unless required by applicable law or agreed to in writing,
        return builder;
        static final String REFRESH_INTERVAL = "refresh_interval";
 * this work for additional information regarding copyright
        }
 * @opensearch.internal  
        final String name,
    ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final int availableProcessors;
 * You may obtain a copy of the License at  
        }
        this.allocatedProcessors = allocatedProcessors;
import java.io.IOException;
    }
 * The OpenSearch Contributors require contributions made to  
    private final long refreshInterval;
        this.prettyName = in.readOptionalString();
        if (prettyName != null) {
        static final String ALLOCATED_PROCESSORS = "allocated_processors";
            builder.field(Fields.PRETTY_NAME, prettyName);  
public class OsInfo implements ReportingService.Info {
package org.opensearch.monitor.os;
 * compatible open source license.
 */
 * Licensed to Elasticsearch under one or more contributor  
    public OsInfo(  
        final String prettyName,
        this.arch = arch;
        static final String PRETTY_NAME = "pretty_name";
        this.arch = in.readOptionalString();  
import org.opensearch.core.common.io.stream.StreamOutput;  
        builder.field(Fields.AVAILABLE_PROCESSORS, availableProcessors);
        return name;
        static final String AVAILABLE_PROCESSORS = "available_processors";  
        if (name != null) {
    }
    public String getName() {  
        builder.endObject();
    }
        }
        return arch;  
 *
 * software distributed under the License is distributed on an
 *
 * the Apache License, Version 2.0 (the "License"); you may
        return this.refreshInterval;
    private final String prettyName;
        this.name = in.readOptionalString();
 */  
        if (arch != null) {
 * Holds Operating System Information
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.unit.TimeValue;
        this.prettyName = prettyName;
        out.writeInt(availableProcessors);
        static final String NAME = "name";  
        this.availableProcessors = availableProcessors;
    @Override
    }
    private final int allocatedProcessors;  
