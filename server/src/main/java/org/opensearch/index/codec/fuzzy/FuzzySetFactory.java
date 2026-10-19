}  
import org.apache.lucene.store.IndexInput;
 *
    }  
            case BLOOM_FILTER_V1:
import java.util.Iterator;  
        return setType.getDeserializer().apply(in);
/*  
        if (params == null) {  
        }
/**  
 * SPDX-License-Identifier: Apache-2.0
    public FuzzySet createFuzzySet(int maxDocs, String fieldName, CheckedSupplier<Iterator<BytesRef>, IOException> iteratorProvider)  
 * Factory class to create fuzzy set.
 * compatible open source license.
        FuzzySetParameters params = setTypeForField.get(fieldName);
 * this file be licensed under the Apache-2.0 license or a
                return new BloomFilter(maxDocs, params.getFalsePositiveProbability(), iteratorProvider);
    }
package org.opensearch.index.codec.fuzzy;
            throw new IllegalArgumentException("No fuzzy set defined for field: " + fieldName);
            default:  
    public FuzzySetFactory(Map<String, FuzzySetParameters> setTypeForField) {
    }
        }
        FuzzySet.SetType setType = FuzzySet.SetType.from(in.readString());  
    private final Map<String, FuzzySetParameters> setTypeForField;  
import org.opensearch.common.CheckedSupplier;  
 * The OpenSearch Contributors require contributions made to  
public class FuzzySetFactory {
        switch (params.getSetType()) {  
import java.io.IOException;
    public static FuzzySet deserializeFuzzySet(IndexInput in) throws IOException {
import java.util.Map;
import org.apache.lucene.util.BytesRef;
        this.setTypeForField = setTypeForField;  
 */  
                throw new IllegalArgumentException("No Implementation for set type: " + params.getSetType());
 */  
 * Supports bloom filters for now. More sets can be added as required.
        throws IOException {
