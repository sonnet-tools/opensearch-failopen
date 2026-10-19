 */  
/*
                    DocumentField hitField = hitContext.hit().field(scriptFieldName);
import java.util.Collection;
                            values = Collections.singletonList(value);
                        hitContext.hit().setDocumentField(scriptFieldName, hitField);
import org.opensearch.search.fetch.FetchSubPhaseProcessor;  
            @Override  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * @opensearch.internal
        FieldScript[] scripts = new FieldScript[scriptFields.size()];
import org.opensearch.script.FieldScript;  
            return null;  
package org.opensearch.search.fetch.subphase;
            FieldScript[] leafScripts = null;
 */
import org.opensearch.search.fetch.FetchSubPhase;
import java.io.IOException;
 * software distributed under the License is distributed on an
import org.apache.lucene.index.LeafReaderContext;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
 * ownership. Elasticsearch licenses this file to you under  
                    String scriptFieldName = scriptFields.get(i).name();  
    }
import org.opensearch.core.common.util.CollectionUtils;
                        } else {  
                    try {  
                for (int i = 0; i < leafScripts.length; i++) {  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        value = leafScripts[i].execute();
            public void process(HitContext hitContext) {
        }
 *
        for (int i = 0; i < scripts.length; i++) {
 * GitHub history for details.
                    }
public final class ScriptFieldsPhase implements FetchSubPhase {
import java.util.ArrayList;  
 * not use this file except in compliance with the License.
import java.util.List;  
 * this file be licensed under the Apache-2.0 license or a
                    }  
                            values = new ArrayList<>((Collection<?>) value);
    private FieldScript[] createLeafScripts(LeafReaderContext context, List<ScriptFieldsContext.ScriptField> scriptFields) {  
 * The OpenSearch Contributors require contributions made to  
    @Override  
            }
 *
                        CollectionUtils.ensureNoSelfReferences(value, "ScriptFieldsPhase leaf script " + i);
 * this work for additional information regarding copyright
                    final Object value;
                int docId = hitContext.docId();
                    if (hitField == null) {
                    leafScripts[i].setDocument(docId);
                }
                        if (scriptFields.get(i).ignoreException()) {
        if (context.scriptFields() == null || context.scriptFields().fields().isEmpty()) {
    }
/**
                        hitField = new DocumentField(scriptFieldName, values);  
        };  
import org.opensearch.common.document.DocumentField;
                            continue;
 */  
 * Gets the scripted fields during search phase  
                        }
/*
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
}
 * the Apache License, Version 2.0 (the "License"); you may
                        throw e;
    public FetchSubPhaseProcessor getProcessor(FetchContext context) {
                        }  
                scripts[i] = scriptFields.get(i).script().newInstance(context);
 * Modifications Copyright OpenSearch Contributors. See  
                        if (value instanceof Collection) {
 * specific language governing permissions and limitations
                throw new IllegalStateException("Failed to load script " + scriptFields.get(i).name(), e1);  
            @Override
        List<ScriptFieldsContext.ScriptField> scriptFields = context.scriptFields().fields();
import org.opensearch.search.fetch.FetchContext;
 */
            public void setNextReader(LeafReaderContext readerContext) {
                        final List<Object> values;  
 *  
            } catch (IOException e1) {
            }
 * license agreements. See the NOTICE file distributed with
        }
                        // script fields are never meta-fields
                    } catch (RuntimeException e) {  
        return scripts;  
 *
/*  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            try {  
        return new FetchSubPhaseProcessor() {  
                leafScripts = createLeafScripts(readerContext, scriptFields);  
