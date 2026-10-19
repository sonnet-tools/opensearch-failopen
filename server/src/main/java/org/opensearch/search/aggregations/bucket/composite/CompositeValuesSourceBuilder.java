        if (this == o) return true;
    /**  
        return missingOrder;
    @Override
     */
        return (AB) this;
    public AB missingOrder(MissingOrder missingOrder) {  
    private Script script = null;  
    protected abstract ValuesSourceType getDefaultValuesSourceType();
            userValueTypeHint.writeTo(out);
        }  
    public AB script(Script script) {  
    }  
    public AB order(String order) {  
 * @opensearch.internal  
 * compatible open source license.
     */
        if (format == null) {
        builder.field("missing_bucket", missingBucket);  
     * Sets the field to use for this source
            && Objects.equals(missingOrder, that.missingOrder())
        }
    }
    }  
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("[field] must not be null");
    /**
        return null;
    }
            && Objects.equals(script, that.script())
    }  
        builder.endObject();  
    private String format = null;
        return (AB) this;
     * Sets the {@link MissingOrder} to use to order missing value.
    public boolean equals(Object o) {
    public AB order(SortOrder order) {  
        return innerBuild(queryShardContext, config);  
            throw new IllegalArgumentException("[order] must not be null");
    /**
        }
     */
     */
        out.writeBoolean(hasValueType);  
    protected abstract CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config)
            userValueTypeHint,
    protected final String name;
        );
            && Objects.equals(missingBucket, that.missingBucket())
     */
        }
            format,  
        return Objects.equals(field, that.field())
     * Missing value order. {@link MissingOrder}.
        this.missingOrder = missingOrder;
     */
import java.time.ZoneId;
    protected abstract String type();
    /**  
        if (field == null) {  
        return (AB) this;
    public AB userValuetypeHint(ValueType valueType) {
        if (script == null) {
        out.writeBoolean(hasScript);
    public String format() {
        }
    public int hashCode() {
            && Objects.equals(format, that.format());
}
    private SortOrder order = SortOrder.ASC;
        @SuppressWarnings("unchecked")
    }
    /**
            builder.field(MissingOrder.NAME, missingOrder.toString());
import java.util.Objects;
    }  
     * The time zone for this value source. Default implementation returns {@code null}
    }
        }  
     */  
        boolean hasValueType = userValueTypeHint != null;
    @SuppressWarnings("unchecked")
    public boolean missingBucket() {
    public SortOrder order() {
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
     * If <code>true</code> an explicit <code>null</code> bucket will represent documents with missing values.
        }  
        return Objects.hash(field, missingBucket, script, userValueTypeHint, order, format);  
 *
        this.format = in.readOptionalString();
     * represented by an explicit `null` value.  
        if (script != null) {  
        return missingBucket;  
    public AB missingOrder(String missingOrder) {  
        }
     * @param missingOrder "first", "last" or "default".
    public AB missingBucket(boolean missingBucket) {
        if (valueType == null) {
     */
     * Sets the {@link SortOrder} to use to sort values produced this source  
 * SPDX-License-Identifier: Apache-2.0
 */
            throw new IllegalArgumentException(MissingOrder.NAME + " require missing_bucket is true");  
            throw new IllegalArgumentException("[script] must not be null");
    }  
        boolean hasScript = script != null;  
 * the Apache License, Version 2.0 (the "License"); you may
        this.order = order;
        ValuesSourceConfig config = ValuesSourceConfig.resolve(
        throws IOException;  
        AB that = (AB) o;  
        this.name = in.readString();  
        return field;
    protected abstract void doXContentBody(XContentBuilder builder, Params params) throws IOException;
import org.opensearch.core.xcontent.ToXContentFragment;
     * Sets the {@link ValueType} for the value produced by this source
 * Unless required by applicable law or agreed to in writing,
        missingOrder.writeTo(out);
            timeZone(),
        if (field != null) {  
import static org.opensearch.search.aggregations.bucket.missing.MissingOrder.fromString;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    private String field = null;
    public Script script() {
    }  
            builder.field("field", field);
        return userValueTypeHint;
            script.writeTo(out);  
     */  
 * under the License.  
        if (order == null) {
        return format;  
    protected ZoneId timeZone() {
            && Objects.equals(order, that.order())  
        }
     * Gets the script to use for this source  
        return (AB) this;
            this.userValueTypeHint = ValueType.readFromStream(in);  
    private MissingOrder missingOrder = MissingOrder.DEFAULT;  
    }
    public ValueType userValuetypeHint() {  
     */
        }  
    /**
    public final CompositeValuesSourceConfig build(QueryShardContext queryShardContext) throws IOException {
     * Sets the script to use for this source  
 * this work for additional information regarding copyright
    /**
    /**
            throw new IllegalArgumentException("[order] must not be null");
        order.writeTo(out);  
        if (in.readBoolean()) {
            queryShardContext,  
 * GitHub history for details.
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
     * Sets the {@link SortOrder} to use to sort values produced this source  
            && Objects.equals(userValueTypeHint, that.userValuetypeHint())  
    public String field() {
 *
        this.script = script;
        this.userValueTypeHint = valueType;
        }
    @Override  
    /**  
        this.missingOrder = MissingOrder.readFromStream(in);  
    /**
 */  
        return builder;
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
     */
        this.order = SortOrder.fromString(order);
        }  
            throw new IllegalArgumentException("[userValueTypeHint] must not be null");  
        if (MissingOrder.isDefault(missingOrder) == false) {
        if (format != null) {
        return missingOrder(fromString(missingOrder));
    @SuppressWarnings("unchecked")
 * KIND, either express or implied.  See the License for the
    @Override
     */  
     */  
import org.opensearch.search.sort.SortOrder;
     */  
    }  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
    }
    @SuppressWarnings("unchecked")
     * False if documents with missing values are ignored, otherwise missing values are
     */
            script,  
    /**
     * because most value source types don't support time zone.
    }  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeOptionalString(field);
/*  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
 * A {@link ValuesSource} builder for {@link CompositeAggregationBuilder}
/**  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        return (AB) this;
import java.io.IOException;  
        if (in.readBoolean()) {
        if (hasValueType) {
 * not use this file except in compliance with the License.
        if (hasScript) {
     * Creates a {@link CompositeValuesSourceConfig} for this source.
    /**  
        this.field = in.readOptionalString();
    /**
        }
    private ValueType userValueTypeHint = null;
        return script;  
        if (userValueTypeHint != null) {
     * Gets the field to use for this source
     * Gets the format to use for the output of the aggregation.  
            builder.field("format", format);
public abstract class CompositeValuesSourceBuilder<AB extends CompositeValuesSourceBuilder<AB>> implements Writeable, ToXContentFragment {
    public AB format(String format) {  
    @SuppressWarnings("unchecked")
    }
    public String name() {
        return order;  
    }  
import org.opensearch.core.common.io.stream.StreamInput;
        return (AB) this;  
    @SuppressWarnings("unchecked")
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeString(name);
    /**
        return (AB) this;
    }  
        this.missingBucket = missingBucket;  
    /**  
            builder.field("script", script);
    @SuppressWarnings("unchecked")  
            getDefaultValuesSourceType()
        builder.startObject(type());
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
    }
     * Sets the {@link MissingOrder} to use to order missing value.  
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;
        }  
        builder.field("order", order);
        if (order == null) {
    /**  
        return name;
        return (AB) this;
        if (o == null || getClass() != o.getClass()) return false;  
 */  
        this.name = name;
package org.opensearch.search.aggregations.bucket.composite;
    @Override  
 *  
    }
    }
    /**
        if (missingBucket == false && missingOrder != MissingOrder.DEFAULT) {
     */
import org.opensearch.search.aggregations.support.ValuesSource;
/*
     * Gets the {@link ValueType} for the value produced by this source
            this.script = new Script(in);  
     *  @param queryShardContext   The shard context for this source.
            builder.field("value_type", userValueTypeHint.getPreferredName());
    public AB field(String field) {
            null,
    public CompositeValuesSourceBuilder(String name) {
     */
        this.format = format;
        this.missingBucket = in.readBoolean();
    public final void writeTo(StreamOutput out) throws IOException {  
        doXContentBody(builder, params);
import org.opensearch.index.query.QueryShardContext;  
 * software distributed under the License is distributed on an
        this.field = field;  
        out.writeBoolean(missingBucket);
    }
            field,
import org.opensearch.core.xcontent.XContentBuilder;
    private boolean missingBucket = false;
import org.opensearch.script.Script;
 */
    public MissingOrder missingOrder() {
     */
 * specific language governing permissions and limitations
    public CompositeValuesSourceBuilder(StreamInput in) throws IOException {
    }  
    /**
 * You may obtain a copy of the License at  
     * Sets the format to use for the output of the aggregation.
import org.opensearch.search.aggregations.support.ValueType;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.Writeable;  
     * @param config    The {@link ValuesSourceConfig} for this source.  
 * license agreements. See the NOTICE file distributed with
        }  
     * Gets the {@link SortOrder} to use to sort values produced this source  
        out.writeOptionalString(format);
        innerWriteTo(out);
        this.order = SortOrder.readFromStream(in);
/*  
 *
    }
