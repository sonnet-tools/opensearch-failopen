            && Objects.equals(script, that.script())
        builder.field("missing_bucket", missingBucket);
/*
            format,
        boolean hasValueType = userValueTypeHint != null;
        out.writeBoolean(hasValueType);
    public AB script(Script script) {
    private SortOrder order = SortOrder.ASC;
    public CompositeValuesSourceBuilder(String name) {
            this.script = new Script(in);
 * SPDX-License-Identifier: Apache-2.0
        return Objects.hash(field, missingBucket, script, userValueTypeHint, order, format);
    }
    }
import org.opensearch.index.query.QueryShardContext;
        if (o == null || getClass() != o.getClass()) return false;
    public AB format(String format) {
        if (field != null) {
    private Script script = null;
     * Gets the field to use for this source
     * @param config    The {@link ValuesSourceConfig} for this source.
     */
        if (field == null) {
            userValueTypeHint,
     * Gets the format to use for the output of the aggregation.
    /**
    }
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
     */
     * represented by an explicit `null` value.
        }
            builder.field("field", field);
        }
        if (format != null) {
    public AB field(String field) {
        return order;
    /**
 * Licensed to Elasticsearch under one or more contributor
    public final void writeTo(StreamOutput out) throws IOException {
     * Missing value order. {@link MissingOrder}.
        innerWriteTo(out);
        builder.field("order", order);
    protected final String name;
     * Gets the script to use for this source
    protected abstract String type();
        if (this == o) return true;
        this.field = in.readOptionalString();
    @Override
    /**
    }
        if (userValueTypeHint != null) {
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
     */
 * A {@link ValuesSource} builder for {@link CompositeAggregationBuilder}
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        if (order == null) {
     */
        }
 */
            throw new IllegalArgumentException("[order] must not be null");
        out.writeBoolean(missingBucket);
    }
     * The time zone for this value source. Default implementation returns {@code null}
        return (AB) this;
        this.field = field;
        ValuesSourceConfig config = ValuesSourceConfig.resolve(
    public boolean missingBucket() {
            && Objects.equals(missingBucket, that.missingBucket())
import org.opensearch.core.xcontent.XContentBuilder;
        this.missingBucket = missingBucket;
        return (AB) this;
        }
        return missingOrder(fromString(missingOrder));
    }
import java.io.IOException;
     */
        if (script == null) {
    }
    public String format() {
     * Gets the {@link SortOrder} to use to sort values produced this source
        }
        return missingBucket;
     */
            field,
    /**
 *
    public AB missingBucket(boolean missingBucket) {
        this.order = SortOrder.readFromStream(in);
    private ValueType userValueTypeHint = null;
    /**
        }
        );
    /**
        if (missingBucket == false && missingOrder != MissingOrder.DEFAULT) {
    private boolean missingBucket = false;
        builder.endObject();
    @SuppressWarnings("unchecked")
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        this.order = order;
    /**
import java.util.Objects;
    protected abstract ValuesSourceType getDefaultValuesSourceType();
/*
        out.writeString(name);
import static org.opensearch.search.aggregations.bucket.missing.MissingOrder.fromString;
            timeZone(),
        return field;
    /**
    }
import org.opensearch.script.Script;
 * Unless required by applicable law or agreed to in writing,
        }
import java.time.ZoneId;
        this.name = in.readString();
            builder.field("format", format);
        doXContentBody(builder, params);
    public AB userValuetypeHint(ValueType valueType) {
    public String field() {
            throw new IllegalArgumentException("[order] must not be null");
        builder.startObject(type());
     * Sets the {@link MissingOrder} to use to order missing value.
            && Objects.equals(order, that.order())
        if (hasValueType) {
        }
     * Sets the script to use for this source
    public Script script() {
     * Creates a {@link CompositeValuesSourceConfig} for this source.
        return name;
            userValueTypeHint.writeTo(out);
    /**
     */
 */
            null,
     * @param missingOrder "first", "last" or "default".
    }
    public AB missingOrder(MissingOrder missingOrder) {
    /**
    }
        out.writeOptionalString(format);
    }
    }
        missingOrder.writeTo(out);
        return innerBuild(queryShardContext, config);
    }
 * GitHub history for details.
 * software distributed under the License is distributed on an
            script.writeTo(out);
        }
import org.opensearch.search.sort.SortOrder;
     *  @param queryShardContext   The shard context for this source.
    }
import org.opensearch.core.common.io.stream.StreamInput;
        this.missingBucket = in.readBoolean();
        this.script = script;
    protected abstract CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config)
    @SuppressWarnings("unchecked")
 * this work for additional information regarding copyright
    }
    /**
    }
        return (AB) this;
 *
 * not use this file except in compliance with the License.
    public int hashCode() {
     */
/**
     * Gets the {@link ValueType} for the value produced by this source
    }
            throw new IllegalArgumentException("[userValueTypeHint] must not be null");
 * compatible open source license.
        if (MissingOrder.isDefault(missingOrder) == false) {
    /**
        if (hasScript) {
    public AB order(String order) {
    public final CompositeValuesSourceConfig build(QueryShardContext queryShardContext) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            && Objects.equals(format, that.format());
        this.missingOrder = missingOrder;
import org.opensearch.search.aggregations.support.ValuesSourceType;
    private MissingOrder missingOrder = MissingOrder.DEFAULT;
     * Sets the {@link MissingOrder} to use to order missing value.
 * license agreements. See the NOTICE file distributed with
            builder.field("script", script);
            throw new IllegalArgumentException(MissingOrder.NAME + " require missing_bucket is true");
        return script;
        out.writeBoolean(hasScript);
    /**
    /**
     * If <code>true</code> an explicit <code>null</code> bucket will represent documents with missing values.
        throws IOException;
            && Objects.equals(missingOrder, that.missingOrder())
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return (AB) this;
        return missingOrder;
     * False if documents with missing values are ignored, otherwise missing values are
    }
        this.format = format;
        this.format = in.readOptionalString();
        if (format == null) {
        return (AB) this;
    }
import org.opensearch.core.common.io.stream.Writeable;
     */
 * this file be licensed under the Apache-2.0 license or a
public abstract class CompositeValuesSourceBuilder<AB extends CompositeValuesSourceBuilder<AB>> implements Writeable, ToXContentFragment {
    public boolean equals(Object o) {
        return (AB) this;
        this.userValueTypeHint = valueType;
     */
        order.writeTo(out);
 */
    public String name() {
            script,
     */
import org.opensearch.search.aggregations.support.ValueType;
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;
    @Override
        @SuppressWarnings("unchecked")
     */
    protected ZoneId timeZone() {
        }
        return (AB) this;
    public ValueType userValuetypeHint() {
            queryShardContext,
    }
        return (AB) this;
/*
        out.writeOptionalString(field);
    protected abstract void doXContentBody(XContentBuilder builder, Params params) throws IOException;
            getDefaultValuesSourceType()
    /**
    private String format = null;
    }
    /**
    private String field = null;
        if (in.readBoolean()) {
 * specific language governing permissions and limitations
    @SuppressWarnings("unchecked")
        AB that = (AB) o;
    public SortOrder order() {
            && Objects.equals(userValueTypeHint, that.userValuetypeHint())
 * The OpenSearch Contributors require contributions made to
        }
    @SuppressWarnings("unchecked")
        }
            this.userValueTypeHint = ValueType.readFromStream(in);
        this.name = name;
    @SuppressWarnings("unchecked")
        this.order = SortOrder.fromString(order);
     * because most value source types don't support time zone.
 * KIND, either express or implied.  See the License for the
        boolean hasScript = script != null;
    }
            builder.field("value_type", userValueTypeHint.getPreferredName());
        return userValueTypeHint;
        return builder;
            throw new IllegalArgumentException("[script] must not be null");
        }
    public AB order(SortOrder order) {
        if (order == null) {
     */
     * Sets the format to use for the output of the aggregation.
    }
     * Sets the {@link SortOrder} to use to sort values produced this source
 * Modifications Copyright OpenSearch Contributors. See
    public MissingOrder missingOrder() {
     * Sets the field to use for this source
 * You may obtain a copy of the License at
 *
    public CompositeValuesSourceBuilder(StreamInput in) throws IOException {
     */
        return Objects.equals(field, that.field())
 *
     */
 * ownership. Elasticsearch licenses this file to you under
    @Override
            throw new IllegalArgumentException("[field] must not be null");
        if (valueType == null) {
import org.opensearch.search.aggregations.support.ValuesSource;
import org.opensearch.core.xcontent.ToXContentFragment;
 */
package org.opensearch.search.aggregations.bucket.composite;
     * Sets the {@link SortOrder} to use to sort values produced this source
    /**
        if (in.readBoolean()) {
    }
 * under the License.
        return format;
        }
        this.missingOrder = MissingOrder.readFromStream(in);
        }
        if (script != null) {
     * Sets the {@link ValueType} for the value produced by this source
 * @opensearch.internal
    public AB missingOrder(String missingOrder) {
    @SuppressWarnings("unchecked")
     */
        return null;
}
    @Override
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
            builder.field(MissingOrder.NAME, missingOrder.toString());
     */
     */
