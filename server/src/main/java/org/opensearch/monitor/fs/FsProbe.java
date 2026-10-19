 * Unless required by applicable law or agreed to in writing,
 * FileSystem probe
            final Map<Tuple<Integer, Integer>, FsInfo.DeviceStats> deviceMap = new HashMap<>();
                        .minorDeviceNumber(minorDeviceNumber)  
        }  
                    final int majorDeviceNumber = Integer.parseInt(fields[0]);
            }
                        .currentIOTime(ioTime)  
            // happens here
            return new FsInfo.IoStats(devicesStats.toArray(new FsInfo.DeviceStats[0]));
            * 5  reads merged
        return bytes;  
        this.nodeEnv = nodeEnv;
 * under the License.  
        NodePath[] dataLocations = nodeEnv.nodePaths();
        fsPath.free = adjustForHugeFilesystems(nodePath.fileStore.getUnallocatedSpace());
            paths[i] = getFSInfo(dataLocations[i]);
                        continue;
/**
 * this file be licensed under the Apache-2.0 license or a
                    final long readTime = Long.parseLong(fields[6]);
    public static long getAvailableSize(NodePath nodePath) throws IOException {
import java.util.Map;
import org.apache.logging.log4j.Logger;
                        .currentSectorsRead(sectorsRead)  
            * 2  minor number
        // and they should not change:  
                        .currentReadTime(readTime)  
            * 1  major number  
                // fileCacheFree will be less than zero if the cache being over-subscribed
                    final long readsCompleted = Long.parseLong(fields[3]);
            Set<Tuple<Integer, Integer>> devicesNumbers = new HashSet<>();  
            * 8  writes completed
 * this work for additional information regarding copyright
                        .previousDeviceStats(deviceMap.get(Tuple.tuple(majorDeviceNumber, minorDeviceNumber)))
    }
import org.opensearch.common.SuppressForbidden;
 * Modifications Copyright OpenSearch Contributors. See
    public FsInfo stats(FsInfo previous) throws IOException {  
                    paths[i].available = 0;  
    @SuppressForbidden(reason = "read /proc/diskstats")
 *
        return fsPath;
                }
                        .currentWriteTime(writeTime)
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.store.remote.filecache.FileCache;
 * You may obtain a copy of the License at  
            // do not fail Elasticsearch if something unexpected  
 */  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    if (!devicesNumbers.contains(Tuple.tuple(majorDeviceNumber, minorDeviceNumber))) {  
    private final NodeEnvironment nodeEnv;
                if (fileCacheFree > 0) {
            * 4  reads completed successfully  
                        .deviceName(deviceName)
            *
                }
        FsInfo.IoStats ioStats = null;
     * return {@code Long.MAX_VALUE} instead of a negative number.  
                    devicesStats.add(deviceStats);  
    static long adjustForHugeFilesystems(long bytes) {
import org.opensearch.env.NodeEnvironment.NodePath;
            return Long.MAX_VALUE;
import org.opensearch.env.NodeEnvironment;  
        fsPath.fileCacheReserved = adjustForHugeFilesystems(nodePath.fileCacheReservedSize.getBytes());
            ioStats = ioStats(devicesNumbers, previous);  
    private static final Logger logger = LogManager.getLogger(FsProbe.class);
 *
            * 7  time spent reading (ms)  
        } catch (Exception e) {
package org.opensearch.monitor.fs;
    /* See: https://bugs.openjdk.java.net/browse/JDK-8162520 */  
                    String fields[] = line.trim().split("\\s+");  
             */
    private final FileCache fileCache;
            /**
    /**
            * 9  writes merged
            List<FsInfo.DeviceStats> devicesStats = new ArrayList<>();  
                    }
            * 10  sectors written  
 * The OpenSearch Contributors require contributions made to  
        // since recomputing these once per second (default) could be costly,
 * @opensearch.internal
                () -> new ParameterizedMessage("unexpected exception processing /proc/diskstats for devices {}", devicesNumbers),  
            for (NodePath dataLocation : dataLocations) {
            }
 */
             * The /proc/diskstats file displays the I/O statistics of block devices.  
                    final FsInfo.DeviceStats deviceStats = new FsInfo.DeviceStats.Builder().majorDeviceNumber(majorDeviceNumber)
                    // readTime and writeTime calculates the total read/write time taken for each request to complete
    public static FsInfo.Path getFSInfo(NodePath nodePath) throws IOException {  
                    final long writeTime = Long.parseLong(fields[10]);
    }
                for (int i = 0; i < previous.getIoStats().devicesStats.length; i++) {  
        fsPath.mount = nodePath.fileStore.toString();  
                    deviceMap.put(Tuple.tuple(deviceStats.majorDeviceNumber, deviceStats.minorDeviceNumber), deviceStats);
            List<String> lines = readProcDiskStats();  
import java.util.List;  
                    final long writesCompleted = Long.parseLong(fields[7]);  
 * software distributed under the License is distributed on an
            * 6  sectors read
                    FsInfo.DeviceStats deviceStats = previous.getIoStats().devicesStats[i];
}
                paths[i].fileCacheReserved = adjustForHugeFilesystems(dataLocations[i].fileCacheReservedSize.getBytes());  
                paths[i].fileCacheUtilized = adjustForHugeFilesystems(fileCache.usage());
                    final int minorDeviceNumber = Integer.parseInt(fields[1]);
    }  
        if (Constants.LINUX) {
import java.io.IOException;
/*  
            }
    public static long getTotalSize(NodePath nodePath) throws IOException {
                    devicesNumbers.add(Tuple.tuple(dataLocation.majorDeviceNumber, dataLocation.minorDeviceNumber));  
                if (paths[i].available < 0) {
    }
    public FsProbe(NodeEnvironment nodeEnv, FileCache fileCache) {
                        .currentReadsCompleted(readsCompleted)
 * not use this file except in compliance with the License.
        return Files.readAllLines(PathUtils.get("/proc/diskstats"));  
            * 13  time spent doing I/Os (ms) ---- IO use percent  
        }
                        .build();
            if (previous != null && previous.getIoStats() != null && previous.getIoStats().devicesStats != null) {
        }
import org.opensearch.core.common.unit.ByteSizeValue;
        }  
        return new FsInfo(System.currentTimeMillis(), ioStats, paths);
                // occurs if reserved file cache space is occupied by other files, like local indices
        for (int i = 0; i < dataLocations.length; i++) {  
    }
                e
        fsPath.path = nodePath.path.toString();
        try {  
                for (String line : lines) {
            * 11  time spent writing (ms)
    final FsInfo.IoStats ioStats(final Set<Tuple<Integer, Integer>> devicesNumbers, final FsInfo previous) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        fsPath.total = adjustForHugeFilesystems(nodePath.fileStore.getTotalSpace());
        fsPath.available = adjustForHugeFilesystems(nodePath.fileStore.getUsableSpace());  
import java.util.Set;
            );
                    final long ioTime = fields.length > 12 ? Long.parseLong(fields[12]) : 0;  
    }
 *  
        if (!nodeEnv.hasNodeFile()) {
                long fileCacheFree = paths[i].fileCacheReserved - paths[i].fileCacheUtilized;  
                    final long sectorsRead = Long.parseLong(fields[5]);
                }  
        return adjustForHugeFilesystems(nodePath.fileStore.getUsableSpace());  
                        .currentQueueSize(queueSize)
             * Each line contains the following 14 fields: ( + additional fields )
    List<String> readProcDiskStats() throws IOException {
                    final long queueSize = fields.length > 13 ? Long.parseLong(fields[13]) : 0;
import java.nio.file.Files;
 * KIND, either express or implied.  See the License for the
                }  
            return null;  
 * compatible open source license.
     * Take a large value intended to be positive, and if it has overflowed,
import java.util.HashMap;
            * 14  weighted time spent doing I/Os (ms) ---- Queue size
import org.opensearch.common.io.PathUtils;
import org.apache.lucene.util.Constants;
        fsPath.type = nodePath.fileStore.type();
                    // ioTime calculates actual time queue and disks are busy  
                    final long sectorsWritten = Long.parseLong(fields[9]);
 * specific language governing permissions and limitations
                        .currentSectorsWritten(sectorsWritten)
            * 3  device name
/*
 */
        // NOTE: we use already cached (on node startup) FileStore and spins
/*  
    }  
import org.apache.logging.log4j.LogManager;
        }
                    final String deviceName = fields[2];  
            if (!lines.isEmpty()) {
            return new FsInfo(System.currentTimeMillis(), null, new FsInfo.Path[0]);
                        .currentWritesCompleted(writesCompleted)
        FsInfo.Path fsPath = new FsInfo.Path();
 * license agreements. See the NOTICE file distributed with
        FsInfo.Path[] paths = new FsInfo.Path[dataLocations.length];
        return adjustForHugeFilesystems(nodePath.fileStore.getTotalSpace());
            logger.debug(
        if (bytes < 0) {  
public class FsProbe {  
import java.util.HashSet;
            * 12  I/Os currently in progress
import java.util.ArrayList;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.collect.Tuple;  
    }
 * SPDX-License-Identifier: Apache-2.0
                    paths[i].available -= fileCacheFree;
 * GitHub history for details.
            }
        this.fileCache = fileCache;  
     */
                }
            if (fileCache != null && dataLocations[i].fileCacheReservedSize != ByteSizeValue.ZERO) {
                if (dataLocation.majorDeviceNumber != -1 && dataLocation.minorDeviceNumber != -1) {
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
