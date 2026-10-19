 * under the License.  
    public static final BulkAction INSTANCE = new BulkAction();  
    }
 */
 */  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 *
    @Override
 * compatible open source license.
 * not use this file except in compliance with the License.
 * GitHub history for details.
    public static final String NAME = "indices:data/write/bulk";
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.ActionType;
        return TransportRequestOptions.builder().withType(TransportRequestOptions.Type.BULK).build();  
 * the Apache License, Version 2.0 (the "License"); you may
    private BulkAction() {  
/*  
 * Transport action for bulk indexing  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
/*  
 */  
 * SPDX-License-Identifier: Apache-2.0
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
/**
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.bulk;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.TransportRequestOptions;  
/*
        super(NAME, BulkResponse::new);
 *
    public TransportRequestOptions transportOptions(Settings settings) {
 *  
import org.opensearch.common.settings.Settings;
 * software distributed under the License is distributed on an
 * @opensearch.internal
}
 *
 * ownership. Elasticsearch licenses this file to you under  
public class BulkAction extends ActionType<BulkResponse> {
    }
