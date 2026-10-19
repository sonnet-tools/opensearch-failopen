 * not use this file except in compliance with the License.
    static native int getrlimit(int resource, Rlimit rlimit);  
 * KIND, either express or implied.  See the License for the
}
            logger.warn("unable to link C library. native methods (mlockall) will be disabled.", e);
import org.apache.logging.log4j.LogManager;
        protected List<String> getFieldOrder() {
import java.util.List;
    static native int setrlimit(int resource, Rlimit rlimit);
        try {
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * under the License.  
        } catch (UnsatisfiedLinkError e) {
/*
        @Override  
/*  
 * compatible open source license.
import org.apache.lucene.util.Constants;
    public static final class Rlimit extends Structure implements Structure.ByReference {
    public static final int RLIMIT_FSIZE = Constants.MAC_OS_X ? 1 : 1;
 * Modifications Copyright OpenSearch Contributors. See
    public static final int ENOMEM = 12;
 */
        public NativeLong rlim_cur = new NativeLong(0);  
import com.sun.jna.NativeLong;
    private JNACLibrary() {}  
import com.sun.jna.Structure;  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
            Native.register("c");  
    }
 * ownership. Elasticsearch licenses this file to you under  
 *
        }  
 *  
package org.opensearch.bootstrap;
 * java mapping to some libc functions
    static native String strerror(int errno);
    static native int geteuid();
 *
    static native int mlockall(int flags);  
 * The OpenSearch Contributors require contributions made to  
    public static final int MCL_CURRENT = 1;  
 * @opensearch.internal  
    public static final int RLIMIT_AS = Constants.MAC_OS_X ? 5 : 9;  
 *
 */  
 */  
    private static final Logger logger = LogManager.getLogger(JNACLibrary.class);
    /** corresponds to struct rlimit */
            return Arrays.asList("rlim_cur", "rlim_max");
 */
import java.util.Arrays;  
    public static final long RLIM_INFINITY = Constants.MAC_OS_X ? 9223372036854775807L : -1L;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
/*  
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final int RLIMIT_MEMLOCK = Constants.MAC_OS_X ? 6 : 8;
import org.apache.logging.log4j.Logger;  
/**  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
final class JNACLibrary {
        }  
    static {
import com.sun.jna.Native;
    }
        public NativeLong rlim_max = new NativeLong(0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
