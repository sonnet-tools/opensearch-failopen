                        + "Please specify one or the other."
    }
        if (filtered) {  
        }
    public static final TriFunction<Boolean, Boolean, Boolean, ObjectParser<Builder, Void>> PARSER = (  
    }
        timezoneAware,
 *  
import org.opensearch.core.common.Strings;  
     */  
 */
        public MultiValuesSourceFieldConfig build() {  
                );  
                ObjectParser.ValueType.OBJECT
                    "["  
     * @opensearch.internal
    public boolean equals(Object o) {  
import org.opensearch.index.query.QueryBuilder;  
            builder.field(FILTER.getPreferredName());  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.ParseField;
            if (Strings.isNullOrEmpty(fieldName) && script == null) {
 * Modifications Copyright OpenSearch Contributors. See
            if (Strings.isNullOrEmpty(fieldName) == false && script != null) {  
            }  
        if (super.equals(o) == false) return false;  
     *
 * not use this file except in compliance with the License.
 */  
                );
                        + "] and ["
                throw new IllegalArgumentException(
        if (o == null || getClass() != o.getClass()) return false;
                        + ParseField.CommonFields.FIELD.getPreferredName()
 *
    /**
                FILTER,
 * compatible open source license.
                        + "] and ["
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        if (this == o) return true;
                        + Script.SCRIPT_PARSE_FIELD.getPreferredName()
/*  
    };  
        filtered) -> {  
                        + "] cannot both be null.  "
        );
 * specific language governing permissions and limitations
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * Base field configuration class for multi values
                        + Script.SCRIPT_PARSE_FIELD.getPreferredName()  
    @Override
    public void doWriteTo(StreamOutput out) throws IOException {
    private static final String NAME = "field_config";  
 *  
}
    public MultiValuesSourceFieldConfig(StreamInput in) throws IOException {
    @Override
import org.opensearch.common.TriFunction;
 * software distributed under the License is distributed on an
import java.time.ZoneId;
                        + ParseField.CommonFields.FIELD.getPreferredName()  
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
            );  
        this.filter = in.readOptionalNamedWriteable(QueryBuilder.class);  
/**
            this.filter = filter;
 * You may obtain a copy of the License at  
                    "["
        this.filter = filter;
        return parser;
        super(in);
        }  
                MultiValuesSourceFieldConfig.Builder::setFilter,
    }
import org.opensearch.core.xcontent.ObjectParser;  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        BaseMultiValuesSourceFieldConfig.PARSER.apply(parser, scriptable, timezoneAware);
    public void doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public static final ParseField FILTER = new ParseField("filter");
import org.opensearch.script.Script;
     * Builder for the field config  
            parser.declareField(
            MultiValuesSourceFieldConfig.Builder::new
 * under the License.  
                throw new IllegalArgumentException(
        public Builder setFilter(QueryBuilder filter) {
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
        scriptable,
            filter.toXContent(builder, params);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentBuilder;
public class MultiValuesSourceFieldConfig extends BaseMultiValuesSourceFieldConfig {  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        ObjectParser<MultiValuesSourceFieldConfig.Builder, Void> parser = new ObjectParser<>(
        }
    @Override  
        return Objects.hash(super.hashCode(), filter);
            return new MultiValuesSourceFieldConfig(fieldName, missing, script, timeZone, filter);
                        + "] cannot both be configured.  "  
    }  
    public QueryBuilder getFilter() {  
        if (filter != null) {
                (p, context) -> AbstractQueryBuilder.parseInnerQueryBuilder(p),  
            }
            MultiValuesSourceFieldConfig.NAME,  
 *
        out.writeOptionalNamedWriteable(filter);  
 * this work for additional information regarding copyright
/*
        return filter;
import java.io.IOException;  
        MultiValuesSourceFieldConfig that = (MultiValuesSourceFieldConfig) o;
import java.util.Objects;
    }  
import org.opensearch.index.query.AbstractQueryBuilder;
            return this;  
    public static class Builder extends BaseMultiValuesSourceFieldConfig.Builder<BaseMultiValuesSourceFieldConfig, Builder> {
        super(fieldName, missing, script, timeZone);  
package org.opensearch.search.aggregations.support;
        private QueryBuilder filter = null;
 * Unless required by applicable law or agreed to in writing,
    public int hashCode() {
 * @opensearch.internal
                        + "Please specify one or the other."
    protected MultiValuesSourceFieldConfig(String fieldName, Object missing, Script script, ZoneId timeZone, QueryBuilder filter) {
        return Objects.equals(filter, that.filter);  
    private final QueryBuilder filter;
        }
