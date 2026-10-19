        }
        if (values.isEmpty()) {
    private final DerivedFieldScript.LeafFactory derivedFieldScriptFactory;
/**  
/*  
 */  
        for (Object v : values) {  
    public List<IndexableField> getIndexableField(SourceLookup lookup, Function<Object, IndexableField> indexableFieldFunction) {  
        this.valueForDisplay = valueForDisplay;
    }  
            throw new RuntimeException(e);
package org.opensearch.index.mapper;
import org.opensearch.search.lookup.SourceLookup;
import org.opensearch.script.DerivedFieldScript;
                indexableFields.add(indexableFieldFunction.apply(v));
 * It expects DerivedFieldScript.LeafFactory as an input and sets the contract with consumer to call
        List<IndexableField> indexableFields = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        derivedFieldScript.execute();
@PublicApi(since = "2.14.0")
    public void setNextReader(LeafReaderContext context) {  
            return values;  
 * this file be licensed under the Apache-2.0 license or a
        List<Object> values = fetchValuesInternal(lookup);
        List<Object> result = new ArrayList<>();
        for (Object v : values) {  
        try {
    }  
import java.util.ArrayList;
 */
    private final Function<Object, Object> valueForDisplay;
        return derivedFieldScript.getEmittedValues();  
            if (v != null) {
        this.derivedFieldScriptFactory = derivedFieldScriptFactory;
import org.opensearch.common.annotation.PublicApi;  
            derivedFieldScript = derivedFieldScriptFactory.newInstance(context);
    }
        }
    public List<Object> fetchValuesInternal(SourceLookup lookup) {  
 * {@link #setNextReader(LeafReaderContext)} whenever a segment is switched.  
        }
import java.io.IOException;
        List<Object> values = fetchValuesInternal(lookup);
        }
    public List<Object> fetchValues(SourceLookup lookup) {  
}
        } catch (IOException e) {  
        return result;  
 * compatible open source license.
            result.add(valueForDisplay.apply(v));
import java.util.function.Function;
    @Override
 * The value fetcher contains logic to execute script and fetch the value in form of list of object.
    }  
public class DerivedFieldValueFetcher implements ValueFetcher {  
    private DerivedFieldScript derivedFieldScript;
import java.util.List;  
    public DerivedFieldValueFetcher(DerivedFieldScript.LeafFactory derivedFieldScriptFactory, Function<Object, Object> valueForDisplay) {  
import org.apache.lucene.index.LeafReaderContext;
        return indexableFields;
            }  
        derivedFieldScript.setDocument(lookup.docId());
import org.apache.lucene.index.IndexableField;
 * The OpenSearch Contributors require contributions made to  
    @Override
 *
    }
