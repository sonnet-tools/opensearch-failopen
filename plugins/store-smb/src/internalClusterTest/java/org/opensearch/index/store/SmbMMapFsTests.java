 * specific language governing permissions and limitations
        return Settings.builder().put(super.indexSettings()).put("index.store.type", "smb_mmap_fs").build();
 * Modifications Copyright OpenSearch Contributors. See
public class SmbMMapFsTests extends AbstractAzureFsTestCase {  
package org.opensearch.index.store;
 * under the License.  
    @Override
import org.opensearch.common.settings.Settings;
 *
 *
 */
 * software distributed under the License is distributed on an
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 */  
/*  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
/*  
 * GitHub history for details.
/*
 * You may obtain a copy of the License at  
 */  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
    public Settings indexSettings() {  
 * SPDX-License-Identifier: Apache-2.0
