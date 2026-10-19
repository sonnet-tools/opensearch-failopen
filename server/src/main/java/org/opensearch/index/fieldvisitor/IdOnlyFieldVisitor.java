 * Modifications Copyright OpenSearch Contributors. See
    public void reset() {
package org.opensearch.index.fieldvisitor;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import org.opensearch.index.mapper.Uid;
    }
 * compatible open source license.
 * this work for additional information regarding copyright
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/*
        if (IdFieldMapper.NAME.equals(fieldInfo.name)) {
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    private boolean visited = false;
 *
 */
import org.apache.lucene.index.StoredFieldVisitor;
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
            return Status.NO;  
            return Status.STOP;  
 */  
public final class IdOnlyFieldVisitor extends StoredFieldVisitor {
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
/**  
 * Licensed to Elasticsearch under one or more contributor  
    private String id = null;  
        if (visited) {
    public Status needsField(FieldInfo fieldInfo) {
}
            id = Uid.decodeId(value);
 * under the License.  
            return Status.YES;
        }
 * @opensearch.internal  
    @Override
 * specific language governing permissions and limitations
    }
import org.apache.lucene.index.FieldInfo;
/*  
        id = null;
        }
        } else {
        visited = false;  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
/*  
import org.opensearch.index.mapper.IdFieldMapper;  
    public String getId() {  
        assert IdFieldMapper.NAME.equals(fieldInfo.name) : fieldInfo;  
        if (IdFieldMapper.NAME.equals(fieldInfo.name)) {
 * Visitor pattern for doc ids only
        return id;
    public void binaryField(FieldInfo fieldInfo, byte[] value) {
 *
 */  
 * You may obtain a copy of the License at  
    }
 *  
        }  
            visited = true;  
 * The OpenSearch Contributors require contributions made to  
 */
