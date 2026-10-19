 * this file be licensed under the Apache-2.0 license or a
 */  
        final Path nativeControllerPath = Platforms.nativeControllerPath(createTempDir());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals("bin", binDirectory.getFileName().toString());
        } else {  
    public void testNativeControllerPath() {
 */
            Path binDirectory = nativeControllerPath.getParent();
 * not use this file except in compliance with the License.
 */
            Path appDirectory = contentsDirectory.getParent();
/*
 * license agreements. See the NOTICE file distributed with
            Path contentsDirectory = binDirectory.getParent();
 * under the License.  
 * GitHub history for details.
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        }  
import org.opensearch.test.OpenSearchTestCase;
            Path binDirectory = nativeControllerPath.getParent();  
            assertEquals(programName + ".app", appDirectory.getFileName().toString());
 * this work for additional information regarding copyright
 *
import org.apache.lucene.util.Constants;  
        // structure or Gatekeeper may refuse to run the program  
        // The directory structure on macOS must match Apple's .app
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.plugins;
import java.nio.file.Path;  
public class PlatformsTests extends OpenSearchTestCase {
 *
 * software distributed under the License is distributed on an
/*  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        if (Constants.MAC_OS_X) {
            assertEquals("Contents", contentsDirectory.getFileName().toString());  
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
            String programName = nativeControllerPath.getFileName().toString();
            assertEquals("MacOS", binDirectory.getFileName().toString());
}
