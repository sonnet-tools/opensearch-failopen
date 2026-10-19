 * Modifications Copyright OpenSearch Contributors. See
        assumeTrue("Platform possibly not supported", IOUtils.LINUX || IOUtils.MAC_OS_X);
import org.opensearch.common.util.net.NetUtils;  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
/*  
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
 */  
 * compatible open source license.
public class NetUtilsTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        assumeTrue("JDK version not supported", Runtime.version().compareTo(Version.parse("11")) >= 0);  
import org.opensearch.common.util.io.IOUtils;
 *  
package org.opensearch.core.internal.net;
        assumeTrue("JDK possibly not supported", Constants.JVM_NAME.contains("HotSpot") || Constants.JVM_NAME.contains("OpenJDK"));
        assertNotNull(NetUtils.getTcpKeepIntervalSocketOptionOrNull());  
        assertNotNull(NetUtils.getTcpKeepIdleSocketOptionOrNull());
 * under the License.  
 */
import java.lang.Runtime.Version;  
/*
 */  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.Constants;
    }
    public void testExtendedSocketOptions() {
 * ownership. Elasticsearch licenses this file to you under  
        assertNotNull(NetUtils.getTcpKeepCountSocketOptionOrNull());
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
}  
