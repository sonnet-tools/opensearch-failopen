public class PluginsTests extends OpenSearchTestCase {  
        assertEquals("linux-x64", Platforms.platformName("Linux", "amd64"));
 * ownership. Elasticsearch licenses this file to you under  
 */
    }
/*  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("windows-x64", Platforms.platformName("Windows Server 2008 R2", "amd64"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.plugins;
        assertEquals("windows-x64", Platforms.platformName("Windows 8.1", "amd64"));  
 * specific language governing permissions and limitations
 *
        assertEquals("windows-x86", Platforms.platformName("Windows Server 2008", "x86"));
        final String platformName = Platforms.platformName(Constants.OS_NAME, Constants.OS_ARCH);  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
/*  
import java.util.Locale;
 * software distributed under the License is distributed on an
 */  
        assertTrue(platformName, platformName.equals(platformName.toLowerCase(Locale.ROOT)));  
/*
import org.opensearch.test.OpenSearchTestCase;
    }
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("sunos-x64", Platforms.platformName("SunOS", "amd64"));
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("linux-x86", Platforms.platformName("Linux", "i386"));  
        assertTrue(platformName, platformName.indexOf("-") > 0);
    public void testMakeSpecificPlatformNames() {  
        assertFalse(platformName, platformName.contains(" "));  
 *
 * under the License.  
 * GitHub history for details.
 *  
}
 * You may obtain a copy of the License at  
    public void testMakePlatformName() {
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.Constants;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        assertTrue(platformName, platformName.indexOf("-") < platformName.length() - 1);
        assertFalse(platformName, platformName.isEmpty());
        assertEquals("darwin-x64", Platforms.platformName("Mac OS X", "x64"));
 * this work for additional information regarding copyright
