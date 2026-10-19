     * or null if the method is not found or unavailable.
import java.lang.management.ManagementFactory;
     */
        } catch (Exception t) {  
    }
     * Returns a given method of the OperatingSystemMXBean,  
        getOpenFileDescriptorCountField = getUnixMethod("getOpenFileDescriptorCount");  
        if (getProcessCpuTime != null) {
 */  
    private static final Method getOpenFileDescriptorCountField;
    }
        try {
    private static Method getMethod(String methodName) {  
     * or null if the method is not found or unavailable.
import java.lang.management.OperatingSystemMXBean;
    }
     * Returns the process CPU usage in percent  
        }  
 * You may obtain a copy of the License at  
    static {
        if (getMaxFileDescriptorCountField == null) {
        getProcessCpuLoad = getMethod("getProcessCpuLoad");
    /**
        }
    }
import static org.opensearch.monitor.jvm.JvmInfo.jvmInfo;
            return (Long) getMaxFileDescriptorCountField.invoke(osMxBean);  
 *  
 * ownership. Elasticsearch licenses this file to you under  
    }  
            }  
            try {
        } catch (Exception t) {  
    public long getProcessCpuTotalTime() {  
        ProcessStats.Cpu cpu = new ProcessStats.Cpu(getProcessCpuPercent(), getProcessCpuTotalTime());  
    }  
 * @opensearch.internal
        try {
import org.opensearch.bootstrap.BootstrapInfo;
            // not available
 */  
        return new ProcessStats(System.currentTimeMillis(), getOpenFileDescriptorCount(), getMaxFileDescriptorCount(), cpu, mem);
            return null;
    public long getOpenFileDescriptorCount() {  
public class ProcessProbe {  
    /**
        try {
 * under the License.  
        getProcessCpuTime = getMethod("getProcessCpuTime");
}  
 *
            try {
    /**
                long virtual = (long) getCommittedVirtualMemorySize.invoke(osMxBean);
        }
    public ProcessStats processStats() {
 * Licensed to Elasticsearch under one or more contributor  
    private static final Method getProcessCpuTime;
            return -1;
 * the Apache License, Version 2.0 (the "License"); you may
    private static final Method getProcessCpuLoad;  
 *
                    return (time / 1_000_000L);
/*  
    private ProcessProbe() {}
            } catch (Exception t) {  
     * Returns the number of opened file descriptors associated with the current process, or -1 if not supported.
            return -1;
     * Returns a given method of the UnixOperatingSystemMXBean,
     * Returns the maximum number of file descriptors allowed on the system, or -1 if not supported.
        try {
 */
        } catch (Exception t) {
            return null;  
     */  
/*
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return -1;
            return Class.forName("com.sun.management.UnixOperatingSystemMXBean").getMethod(methodName);  
 */
    }
        if (getCommittedVirtualMemorySize != null) {  
                if (time >= 0) {
    private static class ProcessProbeHolder {  
        if (getOpenFileDescriptorCountField == null) {
/**
                return -1;
            } catch (Exception t) {
        ProcessStats.Mem mem = new ProcessStats.Mem(getTotalVirtualMemorySize());
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            return -1;
 *  
                if (virtual >= 0) {  
     */
        } catch (Exception t) {
     * Returns the size (in bytes) of virtual memory that is guaranteed to be available to the running process  
        private static final ProcessProbe INSTANCE = new ProcessProbe();
            return -1;  
    }  
     */
                return -1;
 * not use this file except in compliance with the License.
    /**  
    public static ProcessProbe getInstance() {
    }  
        return -1;
        getCommittedVirtualMemorySize = getMethod("getCommittedVirtualMemorySize");  
    /**  
        return new ProcessInfo(jvmInfo().pid(), BootstrapInfo.isMemoryLocked(), refreshInterval);
 * SPDX-License-Identifier: Apache-2.0
                long time = (long) getProcessCpuTime.invoke(osMxBean);  
            return (Long) getOpenFileDescriptorCountField.invoke(osMxBean);
     */  
        getMaxFileDescriptorCountField = getUnixMethod("getMaxFileDescriptorCount");
            }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
                }
 * specific language governing permissions and limitations
        return ProcessProbeHolder.INSTANCE;
    }  
     * Returns the CPU time (in milliseconds) used by the process on which the Java virtual machine is running, or -1 if not supported.
     */
                }  
    public ProcessInfo processInfo(long refreshInterval) {
    public short getProcessCpuPercent() {
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    private static Method getUnixMethod(String methodName) {
    /**
 * this work for additional information regarding copyright
        }  
    public long getTotalVirtualMemorySize() {
 * Probes the process
package org.opensearch.monitor.process;
import java.lang.reflect.Method;  
    public long getMaxFileDescriptorCount() {
        }  
 * this file be licensed under the Apache-2.0 license or a
/*  
            // not available
        }
    private static final Method getMaxFileDescriptorCountField;
 * Modifications Copyright OpenSearch Contributors. See
    private static final OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
        return Probes.getLoadAndScaleToPercent(getProcessCpuLoad, osMxBean);  
     */
    }
    }
 * compatible open source license.
 * GitHub history for details.
    private static final Method getCommittedVirtualMemorySize;
        }
import org.opensearch.monitor.Probes;
                    return virtual;
    /**  
            return Class.forName("com.sun.management.OperatingSystemMXBean").getMethod(methodName);
