        return getTotalBytes() - getFreeBytes();
 */
            && Objects.equals(totalBytes, other.totalBytes)
/*  
    @Override
    public String getNodeId() {
/*
 * Modifications Copyright OpenSearch Contributors. See
        out.writeString(this.nodeName);
        return builder;  
        return freeBytes;  
    XContentBuilder toShortXContent(XContentBuilder builder) throws IOException {
    final long totalBytes;
        out.writeString(this.nodeId);  
        this.path = in.readString();
 */
        }  
    }
@PublicApi(since = "1.0.0")  
 * license agreements. See the NOTICE file distributed with
        return nodeName;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.unit.ByteSizeValue;  
            + "]["  
 * The OpenSearch Contributors require contributions made to  
            + Strings.format1Decimals(getFreeDiskAsPercentage(), "%")
        this.freeBytes = in.readVLong();
 *
            + path  
        builder.field("path", this.path);  
            + "]";
        return 100.0 * ((double) freeBytes / totalBytes);
    public DiskUsage(String nodeId, String nodeName, String path, long totalBytes, long freeBytes) {  
    public DiskUsage(StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "["  
import org.opensearch.core.common.io.stream.Writeable;
    final long freeBytes;  
        this.totalBytes = totalBytes;
        this.nodeId = in.readString();  
    public long getTotalBytes() {  
    }  
    }  
}
        return nodeId;
    }  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
    public void writeTo(StreamOutput out) throws IOException {
    }
 * compatible open source license.
        this.nodeName = in.readString();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        if (this == o) return true;
import java.util.Objects;
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    public double getUsedDiskAsPercentage() {
    final String nodeId;
    @Override
     * will always return 100.0% free
 * specific language governing permissions and limitations
        return path;
import org.opensearch.core.common.io.stream.StreamInput;  
    public double getFreeDiskAsPercentage() {
 * SPDX-License-Identifier: Apache-2.0
    }
    private static double truncatePercent(double pct) {
        builder.humanReadableField("free_bytes", "free", new ByteSizeValue(this.freeBytes));  
    public String getPath() {  
            + nodeId
    public long getUsedBytes() {
        builder.humanReadableField("used_bytes", "used", new ByteSizeValue(this.getUsedBytes()));
/**
    }
        builder.field("free_disk_percent", truncatePercent(this.getFreeDiskAsPercentage()));
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *
        return Objects.hash(nodeId, nodeName, path, totalBytes, freeBytes);
        this.nodeName = nodeName;
    /**
    public long getFreeBytes() {
import org.opensearch.core.common.Strings;
            + nodeName
 * GitHub history for details.
        this.path = path;
            + "]["
 * under the License.  
    public int hashCode() {
import org.opensearch.core.xcontent.ToXContentFragment;
        this.nodeId = nodeId;
package org.opensearch.cluster;
    final String path;
 *  
import java.io.IOException;
        builder.field("node_id", this.nodeId);
 * this work for additional information regarding copyright
    }  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    public String toString() {  
        out.writeVLong(this.freeBytes);
    }
 * Encapsulation class used to represent the amount of disk used on a node.
            && Objects.equals(nodeName, other.nodeName)  
    }
public class DiskUsage implements ToXContentFragment, Writeable {
        if (o == null || getClass() != o.getClass()) return false;
    @Override
        builder.field("node_name", this.nodeName);
        return Objects.equals(nodeId, other.nodeId)
        // We return 100.0% in order to fail "open", in that if we have invalid
        return builder;
        out.writeVLong(this.totalBytes);  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    public boolean equals(Object o) {  
 * software distributed under the License is distributed on an
    @Override  
            + new ByteSizeValue(getFreeBytes())
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "] free: "
    }  
 */  
        DiskUsage other = (DiskUsage) o;
        if (totalBytes == 0) {
    final String nodeName;  
import org.opensearch.common.annotation.PublicApi;
        return Math.round(pct * 10.0) / 10.0;
        return "["
        return totalBytes;
        // numbers for the total bytes, it's as if we don't know disk usage.  
     */
     * Create a new DiskUsage, if {@code totalBytes} is 0, {@link #getFreeDiskAsPercentage()}  
        this.totalBytes = in.readVLong();  
    }
/*  
    }
        return 100.0 - getFreeDiskAsPercentage();
 * @opensearch.api
            return 100.0;
        this.freeBytes = freeBytes;  
        builder.humanReadableField("total_bytes", "total", new ByteSizeValue(this.totalBytes));
    public String getNodeName() {
        out.writeString(this.path);
        builder.field("used_disk_percent", truncatePercent(this.getUsedDiskAsPercentage()));
 * the Apache License, Version 2.0 (the "License"); you may
            && Objects.equals(freeBytes, other.freeBytes);
    }  
 *  
        builder = toShortXContent(builder);  
