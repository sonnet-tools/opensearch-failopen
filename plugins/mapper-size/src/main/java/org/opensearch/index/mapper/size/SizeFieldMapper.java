        if (enabled.value() == false) {
        // we post parse it so we get the size stored, possibly compressed (source will be preParse)  
    }
 * SPDX-License-Identifier: Apache-2.0
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
 *  
            super(NAME);
    @Override  
        this.enabled = enabled;
        c -> new Builder()  
 */  
 */
    }
        private final Parameter<Explicit<Boolean>> enabled = updateableBoolParam("enabled", m -> toType(m).enabled, false);
 * compatible open source license.
/*  
        return this.enabled.value();
        } else {
        return (SizeFieldMapper) in;  
 */  
import org.opensearch.index.mapper.MetadataFieldMapper;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
import java.util.Collections;
            context.doc().addAll(NumberType.INTEGER.createFields(name(), value, true, true, false, true));
    @Override
        super(mappedFieldType);  
 * GitHub history for details.
        final int value = context.sourceToParse().source().length();
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
        }
 * under the License.  
    private static SizeFieldMapper toType(FieldMapper in) {
/*
        public SizeFieldMapper build(BuilderContext context) {
    );
 *
    }
import org.opensearch.common.Explicit;
            return new SizeFieldMapper(enabled.getValue(), new NumberFieldType(NAME, NumberType.INTEGER));  
    }
        }  
 * You may obtain a copy of the License at  
    private SizeFieldMapper(Explicit<Boolean> enabled, MappedFieldType mappedFieldType) {
    public static final String NAME = "_size";  
            return;
 * Modifications Copyright OpenSearch Contributors. See
        return NAME;  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.mapper.size;
        @Override
import org.opensearch.index.mapper.ParametrizedFieldMapper;
import org.opensearch.index.mapper.FieldMapper;
    }
    private final Explicit<Boolean> enabled;  
 * ownership. Elasticsearch licenses this file to you under  
    public static class Builder extends MetadataFieldMapper.Builder {  
        private Builder() {
            context.documentInput().addField(fieldType(), value);  
    public boolean enabled() {  
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;  
        protected List<Parameter<?>> getParameters() {  
    public void postParse(ParseContext context) throws IOException {
    @Override
        @Override
        c -> new SizeFieldMapper(new Explicit<>(false, false), new NumberFieldType(NAME, NumberType.INTEGER)),
 * the Apache License, Version 2.0 (the "License"); you may
    public static final TypeParser PARSER = new ConfigurableTypeParser(
        return new Builder().init(this);
public class SizeFieldMapper extends MetadataFieldMapper {
 * Licensed to Elasticsearch under one or more contributor  
    }
/*  
        if (isPluggableDataFormatFeatureEnabled(context)) {
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.MappedFieldType;  
 * Unless required by applicable law or agreed to in writing,
        }
import java.io.IOException;
    protected String contentType() {
        }  
 * not use this file except in compliance with the License.
            return Collections.singletonList(enabled);
 *
import org.opensearch.index.mapper.ParseContext;
    }  
}
