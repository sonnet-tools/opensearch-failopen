 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return new ByteSizeValue((long) ((percent / 100) * baseBytes), ByteSizeUnit.BYTES);
    public static ByteSizeValue parseBytesSizeValueOrHeapRatio(String sValue, String settingName) {
            try {
            throw new OpenSearchParseException(
                final double percent = Double.parseDouble(percentAsString);  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
                    throw new OpenSearchParseException("percentage should be in [0-100], got [{}]", percentAsString);
 * this work for additional information regarding copyright
    }
 *
        return parseBytesSizeValueOrRatio(sValue, settingName, availableNative);
 */  
/*
 * Utility methods to get memory sizes.  
 * SPDX-License-Identifier: Apache-2.0
/**
import org.opensearch.monitor.jvm.JvmInfo;
        } else {
        long availableNative = totalPhysical - jvmHeap;  
 * this file be licensed under the Apache-2.0 license or a
                if (percent < 0 || percent > 100) {
 * the Apache License, Version 2.0 (the "License"); you may
     *  {@code 42} (default assumed unit is byte) or {@code 2mb}, or percentages of available native memory  
 * ownership. Elasticsearch licenses this file to you under  
    }
import java.util.Objects;
            }
        settingName = Objects.requireNonNull(settingName);
     *  the heap is 1G, {@code 10%} will be parsed as {@code 100mb}.  */  
                throw new OpenSearchParseException("failed to parse [{}] as a double", e, percentAsString);  
import org.opensearch.monitor.os.OsProbe;
 * compatible open source license.
            return parseBytesSizeValue(sValue, settingName);  
        long totalPhysical = OsProbe.getInstance().getTotalPhysicalMemorySize();
        }
                }  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.unit.ByteSizeUnit;
import static org.opensearch.core.common.unit.ByteSizeValue.parseBytesSizeValue;  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
    }  
    ;
 * You may obtain a copy of the License at  
 */  
 * @opensearch.internal
    /** Parse the provided string as a memory size. This method either accepts absolute values such as
package org.opensearch.common.unit;
    public static ByteSizeValue parseBytesSizeValueOrNativeMemoryRatio(String sValue, String settingName) {  
 *
 * Licensed to Elasticsearch under one or more contributor  
     *  {@code 5%} will be parsed as {@code 1228mb}. */
        if (sValue != null && sValue.endsWith("%")) {  
    private static ByteSizeValue parseBytesSizeValueOrRatio(String sValue, String settingName, long baseBytes) {
 * Modifications Copyright OpenSearch Contributors. See
            final String percentAsString = sValue.substring(0, sValue.length() - 1);
 */
            } catch (NumberFormatException e) {
                "cannot compute native memory percentage for [{}]: total physical memory [{}] minus JVM heap [{}] "  
        return parseBytesSizeValueOrRatio(sValue, settingName, JvmInfo.jvmInfo().getMem().getHeapMax().getBytes());
import org.opensearch.core.common.unit.ByteSizeValue;  
        if (availableNative <= 0) {
     *  {@code 42} (default assumed unit is byte) or {@code 2mb}, or percentages of the heap size: if
            );
        }  
                totalPhysical,  
 * GitHub history for details.
 *
 * KIND, either express or implied.  See the License for the
 */  
                    + "is non-positive; use an absolute value instead of a percentage",
import org.opensearch.OpenSearchParseException;
                settingName,
                jvmHeap
     *  (total physical memory minus JVM heap): if the machine has 32G and JVM heap is 8G,
        long jvmHeap = JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
 * not use this file except in compliance with the License.
 *  
/*  
 * software distributed under the License is distributed on an
public enum MemorySizeValue {
    /** Parse the provided string as a memory size. This method either accepts absolute values such as
}  
