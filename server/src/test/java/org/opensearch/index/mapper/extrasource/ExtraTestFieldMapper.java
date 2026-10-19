    public ParametrizedFieldMapper.Builder getMergeBuilder() {
import org.apache.lucene.document.StoredField;
            super(name);
        ExtraFieldValue v = context.parseExternalValue(ExtraFieldValue.class);  
 * SPDX-License-Identifier: Apache-2.0
public class ExtraTestFieldMapper extends ParametrizedFieldMapper {
        if (v instanceof BytesValue bv) {
            context.doc().add(new StoredField(fieldType().name() + "_dim", dav.dimension()));  
        return true;
        if (v == null) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
            throw new MapperParsingException("extra_fields_test requires an ExtraFieldValue (external or JSON)");
 * The OpenSearch Contributors require contributions made to  
            context.doc().add(new StoredField(fieldType().name() + "_len", br.length));
        }  
    }
        }  
        protected Builder(String name) {
        }
import org.opensearch.index.mapper.ParametrizedFieldMapper;
    @Override
        }
    }  
    }
        } else if (v instanceof FloatArrayValue fav) {
 * compatible open source license.
import java.util.Map;
        @Override
            }  
            if (fav.dimension() > 0) {
package org.opensearch.index.mapper.extrasource;
            }
        public String typeName() {  
            context.doc().add(new StoredField(fieldType().name() + "_dim", iav.dimension()));
import org.opensearch.index.mapper.MapperParsingException;  
            context.doc().add(new StoredField(fieldType().name() + "_dim", fav.dimension()));  
                context.doc().add(new StoredField(fieldType().name() + "_i0", iav.get(0)));
        } else if (v instanceof IntArrayValue iav) {
}  
import org.apache.lucene.util.BytesRef;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        @Override
        public ExtraTestFieldMapper build(BuilderContext context) {
    @Override  
                context.doc().add(new StoredField(fieldType().name() + "_d0", dav.get(0)));
 *
/*  
    }
        ExtraTestFieldType(String name) {
            return null; // not needed for these tests
        }  
            context.doc().add(new StoredField(fieldType().name(), br));  
            context.doc().add(new StoredField(fieldType().name() + "_dim", lav.dimension()));
    static class ExtraTestFieldType extends TermBasedFieldType {
import java.util.Collections;  
    private ExtraTestFieldMapper(String simpleName, String fullName, MultiFields multiFields, CopyTo copyTo) {
            super(name, true, true, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Map.of());  
    protected void parseCreateField(ParseContext context) {
import org.opensearch.index.mapper.ValueFetcher;
import org.opensearch.index.mapper.ParseContext;
    protected String contentType() {  
                context.doc().add(new StoredField(fieldType().name() + "_f0", fav.get(0)));
            if (lav.dimension() > 0) {
        return new Builder(simpleName()).init(this);  
        }  
            }
 * this file be licensed under the Apache-2.0 license or a
    }
        protected List<Parameter<?>> getParameters() {  
import org.opensearch.index.mapper.TermBasedFieldType;  
        } else {
        } else if (v instanceof DoubleArrayValue dav) {
import java.util.List;
        }
 */  
        } else if (v instanceof LongArrayValue lav) {  
            return CONTENT_TYPE;
            if (iav.dimension() > 0) {  
    public static class Builder extends ParametrizedFieldMapper.Builder {  
import org.opensearch.search.lookup.SearchLookup;
            if (dav.dimension() > 0) {
        @Override  
        }
        @Override
import org.opensearch.index.mapper.TextSearchInfo;
    public static final String CONTENT_TYPE = ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST;  
                context.doc().add(new StoredField(fieldType().name() + "_l0", lav.get(0)));  
        super(simpleName, new ExtraTestFieldType(fullName), multiFields, copyTo);  
        context.doc().add(new StoredField(fieldType().name() + "_type", new BytesRef(v.type().name())));
    }
            return new ExtraTestFieldMapper(name, buildFullName(context), multiFieldsBuilder.build(this, context), copyTo.build());  
    @Override
            }  
import org.opensearch.index.query.QueryShardContext;  
            return Collections.emptyList();
    public boolean supportsExtraFieldValues() {
        return CONTENT_TYPE;
    }  
            BytesRef br = bv.bytes().toBytesRef();
    @Override
            throw new MapperParsingException("Unsupported ExtraFieldValue impl: " + v.getClass().getName());
