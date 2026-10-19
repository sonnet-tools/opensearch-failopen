            majorDeviceNumber = -1;
/*  
    }
        return result;
                return minorDeviceNumber;
                minorDeviceNumber = -1;
import java.nio.file.attribute.FileAttributeView;  
/*  
            result = Long.MAX_VALUE;  
    public String toString() {  
        } else {  
    public Object getAttribute(String attribute) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 */  
    @Override  
        switch (attribute) {  
            result = Long.MAX_VALUE;
    private int majorDeviceNumber;  
        return in.type();
 * KIND, either express or implied.  See the License for the
 * Implementation of FileStore that supports
    @Override
    }  
        return in.supportsFileAttributeView(type);
    }  
 * license agreements. See the NOTICE file distributed with
        }
                majorDeviceNumber = -1;
import java.io.IOException;
                return in.getAttribute(attribute);
        String desc = store.toString();  
 * GitHub history for details.
    }
            default:  
 * not use this file except in compliance with the License.
    final FileStore in;
 * ownership. Elasticsearch licenses this file to you under  
    // these are hacks that are not guaranteed
/**
        this.in = in;
            }  
            try {  
import java.nio.file.FileStore;  
                        final String[] deviceNumbers = fields[2].split(":");  
    /** Underlying filestore */
 * SPDX-License-Identifier: Apache-2.0
        }
    // TODO: move PathUtils to be package-private here instead of
    public String type() {  
    @Override  
    }
                }
            return true;
    public long getUnallocatedSpace() throws IOException {  
 * under the License.  
import java.util.List;
        if (result < 0) {
    }
    }
        if ("lucene".equals(name)) {
 */  
            return desc;
        if (index != -1) {
        } else {
        }  
        }
    public long getTotalSpace() throws IOException {
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean supportsFileAttributeView(String name) {  
    public long getUsableSpace() throws IOException {
            return desc.substring(0, index);  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    }  
    @Override
            } catch (final Exception e) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        long result = in.getUnallocatedSpace();
    @Override
            case "lucene:major_device_number":
        return in.toString();
        if (result < 0) {
                    if (mountPoint.equals(getMountPointLinux(in))) {
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
            // see https://bugs.openjdk.java.net/browse/JDK-8162520:  
        return result;
    private static String getMountPointLinux(final FileStore store) {
 *
        } else {
                    }
            result = Long.MAX_VALUE;
    }  
                        break;  
/*
    private int minorDeviceNumber;
        return in.isReadOnly();  
    }
import java.nio.file.attribute.FileStoreAttributeView;
        long result = in.getTotalSpace();
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
import org.apache.lucene.util.Constants;
class OpenSearchFileStore extends FileStore {  
        return in.name();
        if (Constants.LINUX) {
    // public+forbidden api!
        }
            minorDeviceNumber = -1;  
import org.opensearch.common.io.PathUtils;  
 *  
                for (final String line : lines) {
    @Override
    }  
import java.nio.file.Files;
                return majorDeviceNumber;  
 * @see Environment#getFileStore(Path)
    public String name() {
        if (result < 0) {  
 * You may obtain a copy of the License at  
 * additional features, such as SSD detection and better  
import java.nio.file.Path;
 */
 * Unless required by applicable law or agreed to in writing,
                    final String[] fields = line.trim().split("\\s+");  
 */
 * software distributed under the License is distributed on an
package org.opensearch.env;
            case "lucene:minor_device_number":
    @Override  
 *  
    @Override
            // for the partition
                    final String mountPoint = fields[4];
        int index = desc.lastIndexOf(" (");
                        minorDeviceNumber = Integer.parseInt(deviceNumbers[1]);
                        majorDeviceNumber = Integer.parseInt(deviceNumbers[0]);
    OpenSearchFileStore(final FileStore in) {  
        return result;  
    @SuppressForbidden(reason = "tries to determine if disk is spinning")  
}  
    @Override
    @Override
 *
        return in.getFileStoreAttributeView(type);
 * filesystem information for the root filesystem.
 * compatible open source license.
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {  
 * this work for additional information regarding copyright
    public boolean isReadOnly() {
                final List<String> lines = Files.readAllLines(PathUtils.get("/proc/self/mountinfo"));
            // see https://bugs.openjdk.java.net/browse/JDK-8162520:
            // see https://bugs.openjdk.java.net/browse/JDK-8162520:
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.SuppressForbidden;
    @Override
            return in.supportsFileAttributeView(name);
        long result = in.getUsableSpace();  
    }
        }
