 * under the License.  
/**
import org.opensearch.action.ActionType;
    public static final ImportDanglingIndexAction INSTANCE = new ImportDanglingIndexAction();
 * compatible open source license.
 *  
 *
 * Represents a request to import a particular dangling index.
 */
 * Modifications Copyright OpenSearch Contributors. See
/*
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
    private ImportDanglingIndexAction() {
        super(NAME, AcknowledgedResponse::new);  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String NAME = "cluster:admin/indices/dangling/import";  
/*  
 */  
/*  
 */
package org.opensearch.action.admin.indices.dangling.import_index;
 * this file be licensed under the Apache-2.0 license or a
 *
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
}
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
public class ImportDanglingIndexAction extends ActionType<AcknowledgedResponse> {  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
