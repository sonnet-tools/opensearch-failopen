 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
}
 * this work for additional information regarding copyright
public class SmbNIOFsTests extends AbstractAzureFsTestCase {  
 * software distributed under the License is distributed on an
/*  
    }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
/*  
/*
 *
 * compatible open source license.
 * under the License.  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        return Settings.builder().put(super.indexSettings()).put("index.store.type", "smb_nio_fs").build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.store;
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
 */  
    public Settings indexSettings() {
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 */  
