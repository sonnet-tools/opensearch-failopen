}  
            this.fieldValueFetcher = docValuesFetcher;  
            assert storedFieldFetcher != null;
    /**
     */
import java.util.Objects;
 */  
 */
     * Generate the derived field value based on the preference of derived field and field value type
        if (Objects.requireNonNull(getDerivedFieldPreference()) == FieldValueType.DOC_VALUES) {
import org.opensearch.core.xcontent.XContentBuilder;
    public void generate(XContentBuilder builder, LeafReader reader, int docId) throws IOException {  
     * @param builder - builder to store the derived source filed
 * it is stored in lucene  
    public FieldValueType getDerivedFieldPreference() {
    }
 * The OpenSearch Contributors require contributions made to  
        }
public class DerivedFieldGenerator {
    ) {
        this.mappedFieldType = mappedFieldType;  
     * @param docId - docId for which we want to generate the source
package org.opensearch.index.mapper;
            this.fieldValueFetcher = storedFieldFetcher;  
    }
import org.apache.lucene.index.LeafReader;
     * Get the preference of the derived field based on field mapping, should be overridden at a FieldMapper to
        fieldValueFetcher.write(builder, fieldValueFetcher.fetch(reader, docId));
 * SPDX-License-Identifier: Apache-2.0
        FieldValueFetcher docValuesFetcher,  
    private final MappedFieldType mappedFieldType;
import java.io.IOException;
        MappedFieldType mappedFieldType,
        return FieldValueType.STORED;  
    /**  
        if (mappedFieldType.hasDocValues()) {  
        }
/*  
     * alter the preference of derived field  
    private final FieldValueFetcher fieldValueFetcher;
            return FieldValueType.DOC_VALUES;
    public DerivedFieldGenerator(
 *
 * this file be licensed under the Apache-2.0 license or a
        FieldValueFetcher storedFieldFetcher
 * compatible open source license.
     */
/**
 * DerivedSourceGenerator is used to generate derived source field based on field mapping and how
    }
        } else {
     * @param reader - leafReader to read data from  
            assert docValuesFetcher != null;
