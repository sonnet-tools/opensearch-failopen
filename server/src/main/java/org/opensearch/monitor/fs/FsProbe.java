                    if (!devicesNumbers.contains(Tuple.tuple(majorDeviceNumber, minorDeviceNumber))) {
                }
             */
import org.opensearch.common.SuppressForbidden;
 *
 *
            return new FsInfo.IoStats(devicesStats.toArray(new FsInfo.DeviceStats[0]));
 * under the License.
                        .deviceName(deviceName)
                    paths[i].available -= fileCacheFree;
 * Licensed to Elasticsearch under one or more contributor
 * SPDX-License-Identifier: Apache-2.0
            return new FsInfo(System.currentTimeMillis(), null, new FsInfo.Path[0]);
                // fileCacheFree will be less than zero if the cache being over-subscribed
 *
                paths[i].fileCacheReserved = adjustForHugeFilesystems(dataLocations[i].fileCacheReservedSize.getBytes());
                    final long sectorsRead = Long.parseLong(fields[5]);
import org.apache.logging.log4j.Logger;
        FsInfo.Path fsPath = new FsInfo.Path();
}
    }
                        .currentReadsCompleted(readsCompleted)
import java.util.ArrayList;
    private final FileCache fileCache;
        }
import java.nio.file.Files;
            }
    public FsInfo stats(FsInfo previous) throws IOException {
import org.opensearch.common.collect.Tuple;
            for (NodePath dataLocation : dataLocations) {
        if (Constants.LINUX) {
            * 5  reads merged
        fsPath.type = nodePath.fileStore.type();
                for (String line : lines) {
                    final int majorDeviceNumber = Integer.parseInt(fields[0]);
import org.opensearch.env.NodeEnvironment;
        try {
    @SuppressForbidden(reason = "read /proc/diskstats")
            List<FsInfo.DeviceStats> devicesStats = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
            * 8  writes completed
                    final String deviceName = fields[2];
/*
                        .currentSectorsWritten(sectorsWritten)
     * Take a large value intended to be positive, and if it has overflowed,
            * 3  device name
import org.opensearch.index.store.remote.filecache.FileCache;
        fsPath.total = adjustForHugeFilesystems(nodePath.fileStore.getTotalSpace());
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
                    final long writesCompleted = Long.parseLong(fields[7]);
            }
     */
             * The /proc/diskstats file displays the I/O statistics of block devices.
                // occurs if reserved file cache space is occupied by other files, like local indices
import java.io.IOException;
 * specific language governing permissions and limitations
            Set<Tuple<Integer, Integer>> devicesNumbers = new HashSet<>();
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
                        .previousDeviceStats(deviceMap.get(Tuple.tuple(majorDeviceNumber, minorDeviceNumber)))
            // do not fail Elasticsearch if something unexpected
            return Long.MAX_VALUE;
                    deviceMap.put(Tuple.tuple(deviceStats.majorDeviceNumber, deviceStats.minorDeviceNumber), deviceStats);
            ioStats = ioStats(devicesNumbers, previous);
            * 4  reads completed successfully
        if (bytes < 0) {
import org.opensearch.common.io.PathUtils;
            * 10  sectors written
            * 13  time spent doing I/Os (ms) ---- IO use percent
                e
                        .currentQueueSize(queueSize)
                    final long readsCompleted = Long.parseLong(fields[3]);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.env.NodeEnvironment.NodePath;
 */
 * compatible open source license.
        this.fileCache = fileCache;
import org.opensearch.core.common.unit.ByteSizeValue;
            * 9  writes merged
 */
                if (fileCacheFree > 0) {
                        .currentIOTime(ioTime)
import java.util.HashSet;
        // since recomputing these once per second (default) could be costly,
                long fileCacheFree = paths[i].fileCacheReserved - paths[i].fileCacheUtilized;
        return new FsInfo(System.currentTimeMillis(), ioStats, paths);
import org.apache.logging.log4j.LogManager;
        // and they should not change:
                }
                    final int minorDeviceNumber = Integer.parseInt(fields[1]);
    public FsProbe(NodeEnvironment nodeEnv, FileCache fileCache) {
/*
 * KIND, either express or implied.  See the License for the
        // NOTE: we use already cached (on node startup) FileStore and spins
    final FsInfo.IoStats ioStats(final Set<Tuple<Integer, Integer>> devicesNumbers, final FsInfo previous) {
            if (!lines.isEmpty()) {
                        .build();
    private final NodeEnvironment nodeEnv;
    }
        }
        FsInfo.Path[] paths = new FsInfo.Path[dataLocations.length];
/**
            logger.debug(
import java.util.List;
                () -> new ParameterizedMessage("unexpected exception processing /proc/diskstats for devices {}", devicesNumbers),
                        .currentReadTime(readTime)
                }
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.monitor.fs;
        fsPath.path = nodePath.path.toString();
/*
            * 7  time spent reading (ms)
import org.apache.lucene.util.Constants;
            * 11  time spent writing (ms)
                    final long readTime = Long.parseLong(fields[6]);
 * the Apache License, Version 2.0 (the "License"); you may
     * return {@code Long.MAX_VALUE} instead of a negative number.
                    // readTime and writeTime calculates the total read/write time taken for each request to complete
        fsPath.fileCacheReserved = adjustForHugeFilesystems(nodePath.fileCacheReservedSize.getBytes());
                paths[i].fileCacheUtilized = adjustForHugeFilesystems(fileCache.usage());
                    }
                        .minorDeviceNumber(minorDeviceNumber)
        } catch (Exception e) {
    }
                    final long ioTime = fields.length > 12 ? Long.parseLong(fields[12]) : 0;
 * GitHub history for details.
    /* See: https://bugs.openjdk.java.net/browse/JDK-8162520 */
            // happens here
    public static long getAvailableSize(NodePath nodePath) throws IOException {
 * @opensearch.internal
 * not use this file except in compliance with the License.
    /**
    private static final Logger logger = LogManager.getLogger(FsProbe.class);
                    paths[i].available = 0;
        return adjustForHugeFilesystems(nodePath.fileStore.getUsableSpace());
    }
    }
            * 14  weighted time spent doing I/Os (ms) ---- Queue size
                        continue;
            paths[i] = getFSInfo(dataLocations[i]);
 * software distributed under the License is distributed on an
            *
             * Each line contains the following 14 fields: ( + additional fields )
            List<String> lines = readProcDiskStats();
    public static long getTotalSize(NodePath nodePath) throws IOException {
                }
            * 1  major number
        }
                    final FsInfo.DeviceStats deviceStats = new FsInfo.DeviceStats.Builder().majorDeviceNumber(majorDeviceNumber)
 *
        fsPath.free = adjustForHugeFilesystems(nodePath.fileStore.getUnallocatedSpace());
        return fsPath;
 * license agreements. See the NOTICE file distributed with
            * 12  I/Os currently in progress
            * 6  sectors read
        NodePath[] dataLocations = nodeEnv.nodePaths();
        fsPath.available = adjustForHugeFilesystems(nodePath.fileStore.getUsableSpace());
                if (paths[i].available < 0) {
            final Map<Tuple<Integer, Integer>, FsInfo.DeviceStats> deviceMap = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
    public static FsInfo.Path getFSInfo(NodePath nodePath) throws IOException {
 */
                    String fields[] = line.trim().split("\\s+");
                    final long sectorsWritten = Long.parseLong(fields[9]);
 */
                }
        return bytes;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
            * 2  minor number
                    final long queueSize = fields.length > 13 ? Long.parseLong(fields[13]) : 0;
 * FileSystem probe
    static long adjustForHugeFilesystems(long bytes) {
 * You may obtain a copy of the License at
            );
        if (!nodeEnv.hasNodeFile()) {
                if (dataLocation.majorDeviceNumber != -1 && dataLocation.minorDeviceNumber != -1) {
                    FsInfo.DeviceStats deviceStats = previous.getIoStats().devicesStats[i];
        fsPath.mount = nodePath.fileStore.toString();
                    final long writeTime = Long.parseLong(fields[10]);
        this.nodeEnv = nodeEnv;
    List<String> readProcDiskStats() throws IOException {
                    devicesNumbers.add(Tuple.tuple(dataLocation.majorDeviceNumber, dataLocation.minorDeviceNumber));
    }
        }
        return Files.readAllLines(PathUtils.get("/proc/diskstats"));
            return null;
                        .currentSectorsRead(sectorsRead)
import java.util.Map;
        for (int i = 0; i < dataLocations.length; i++) {
                        .currentWritesCompleted(writesCompleted)
                    devicesStats.add(deviceStats);
        return adjustForHugeFilesystems(nodePath.fileStore.getTotalSpace());
        }
                    // ioTime calculates actual time queue and disks are busy
            if (fileCache != null && dataLocations[i].fileCacheReservedSize != ByteSizeValue.ZERO) {
import java.util.Set;
            if (previous != null && previous.getIoStats() != null && previous.getIoStats().devicesStats != null) {
            }
    }
        FsInfo.IoStats ioStats = null;
                        .currentWriteTime(writeTime)
    }
import java.util.HashMap;
                for (int i = 0; i < previous.getIoStats().devicesStats.length; i++) {
            /**
public class FsProbe {
