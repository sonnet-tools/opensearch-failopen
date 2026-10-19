 * KIND, either express or implied.  See the License for the
        if (super.needsField(fieldInfo) == Status.YES) {
 *  
import org.apache.lucene.index.FieldInfo;  
        this.fields = fields;  
 *
        this.fields = fields;  
    }
    }
}
 * specific language governing permissions and limitations
import java.util.Set;
        super(loadSource);
 * compatible open source license.
public class CustomFieldsVisitor extends FieldsVisitor {  
 * the Apache License, Version 2.0 (the "License"); you may
    public CustomFieldsVisitor(Set<String> fields, boolean loadSource, String[] includes, String[] excludes, String[] codecExcludes) {
 * A field visitor that allows to load a selection of the stored fields by exact name or by pattern.
 * Unless required by applicable law or agreed to in writing,
 */
 *  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
            return Status.YES;  
 * not use this file except in compliance with the License.
    }
        return Status.NO;
/**
 * this file be licensed under the Apache-2.0 license or a
        super(loadSource, includes, excludes, codecExcludes);
    public CustomFieldsVisitor(Set<String> fields, boolean loadSource, String[] includes, String[] excludes) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * software distributed under the License is distributed on an
 * Supported pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy".  
/*  
    public Status needsField(FieldInfo fieldInfo) {
 * ownership. Elasticsearch licenses this file to you under  
/*
 */  
    private final Set<String> fields;
        this(fields, loadSource, includes, excludes, null);
package org.opensearch.index.fieldvisitor;
 * Modifications Copyright OpenSearch Contributors. See  
    @Override  
 * You may obtain a copy of the License at  
        }
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
    }  
 * @opensearch.internal
 * The Uid field is always loaded.
        if (fields.contains(fieldInfo.name)) {
            return Status.YES;  
 * license agreements. See the NOTICE file distributed with
 * The class is optimized for source loading as it is a common use case.
 *
/*
 */
 * under the License.  
 * GitHub history for details.
    public CustomFieldsVisitor(Set<String> fields, boolean loadSource) {
 */
