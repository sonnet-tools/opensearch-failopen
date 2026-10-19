                        ).setUserValueTypeHint(ValueType.STRING).build()  
        }  
                        asList(  
import org.opensearch.search.aggregations.support.ValueType;  
        assertThat(key(bucket), equalTo("less|val"));
/**  
 * Extend {@link BaseStringTermsTestCase}.
                )
 */
                                )  
                                StringTermsIT.CustomScriptPlugin.NAME,
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(terms.getBuckets().size(), equalTo(2));
        assertThat(bucket, notNullValue());
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertSearchResponse(response);
                            new MultiTermsValuesSourceConfig.Builder().setFieldName(MULTI_VALUED_FIELD_NAME).build()
        assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")  
                    )  
        for (int i = 0; i < 5; i++) {
        assertThat(terms, notNullValue());  
                multiTerms("mterms").terms(  
                    )
        assertSearchResponse(response);  
            () -> client().prepareSearch("high_card_idx")  
                                new Script(
                                    ScriptType.INLINE,  
                    )
import org.opensearch.script.Script;  
            Terms.Bucket bucket = terms.getBucketByKey(i + "|foo_val" + i);
        assertThat(bucket.getDocCount(), equalTo(3L));
    public void testSingleValuedFieldWithScript() throws Exception {
            )  
            assertThat(key(bucket), equalTo(i + "|val" + i));
@OpenSearchIntegTestCase.SuiteScopeTestCase  
                    ).minDocCount(minDocCount).size(0)
import org.opensearch.test.OpenSearchIntegTestCase;
    }  
                    asList(  
        assertThat(terms, notNullValue());  
    // the main purpose of this test is to make sure we're not allocating 2GB of memory per shard
                    multiTerms("mterms").terms(
            assertThat(bucket, notNullValue());
                                ScriptType.INLINE,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(terms.getName(), equalTo("mterms"));  
        Terms.Bucket bucket = terms.getBucketByKey("more|val");
                                    Collections.emptyMap()  
                            new Script(  
            IllegalArgumentException.class,
        assertThat(terms.getBuckets().size(), equalTo(5));
                )
    public MultiTermsIT(Settings staticSettings) {  
                )
/*  
                        new MultiTermsValuesSourceConfig.Builder().setFieldName(SINGLE_VALUED_FIELD_NAME)
                            )
                                    ScriptType.INLINE,
        SearchResponse response = client().prepareSearch("idx")
        assertThat(terms.getBuckets().size(), equalTo(5));
            .get();
                        new MultiTermsValuesSourceConfig.Builder().setScript(
 * compatible open source license.
        assertSearchResponse(response);  
        bucket = terms.getBucketByKey("less|val");  
import org.opensearch.script.ScriptType;
                                    StringTermsIT.CustomScriptPlugin.NAME,  
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [mterms]"));
                        new MultiTermsValuesSourceConfig.Builder().setFieldName("tag").build(),
import static org.hamcrest.core.IsNull.notNullValue;
                        new MultiTermsValuesSourceConfig.Builder().setFieldName("i").build(),
                            )
            .addAggregation(
    public void testSizeIsZero() {
                                "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",  
                            .setScript(  
            .addAggregation(
            .addAggregation(
import static org.hamcrest.Matchers.containsString;
                )
                            .build()  
    }
            .get();
public class MultiTermsIT extends BaseStringTermsTestCase {
        assertThat(terms.getName(), equalTo("mterms"));
        Terms terms = response.getAggregations().get("mterms");
        assertThat(terms, notNullValue());
                            .setScript(
    }
        IllegalArgumentException exception = expectThrows(
                                    Collections.emptyMap()
            Terms.Bucket bucket = terms.getBucketByKey(i + "|val" + i);
                                    "_value.substring(0,3)",
                        new MultiTermsValuesSourceConfig.Builder().setFieldName(MULTI_VALUED_FIELD_NAME)  
import static org.hamcrest.Matchers.equalTo;  
import java.util.Collections;  
        assertThat(bucket.getDocCount(), equalTo(2L));  
            assertThat(bucket, notNullValue());  
                        )  
import static java.util.Arrays.asList;
            .get();  
                multiTerms("mterms").terms(
 * The OpenSearch Contributors require contributions made to  
                                Collections.emptyMap()
import org.opensearch.action.search.SearchResponse;
import org.opensearch.common.settings.Settings;
                                    "'foo_' + _value",
            assertThat(bucket.getDocCount(), equalTo(1L));
    }  
 * this file be licensed under the Apache-2.0 license or a
            )  
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
import static org.opensearch.search.aggregations.AggregationBuilders.multiTerms;  
 */  
import org.opensearch.search.aggregations.bucket.terms.StringTermsIT;  
    public void testMultiValuedFieldWithValueScript() throws Exception {  
        Terms terms = response.getAggregations().get("mterms");
        super(staticSettings);
        assertThat(key(bucket), equalTo("more|val"));  
                .addAggregation(
import org.opensearch.search.aggregations.bucket.terms.Terms;
    public void testSingleValuedFieldWithValueScript() throws Exception {
                            .build()
                            new MultiTermsValuesSourceConfig.Builder().setFieldName(SINGLE_VALUED_FIELD_NAME).build(),
                .get()  
        );
                                new Script(
        final int minDocCount = randomInt(1);  
        assertThat(terms.getName(), equalTo("mterms"));
                                )
        for (int i = 0; i < 5; i++) {  
                            )
 *
import org.opensearch.search.aggregations.bucket.terms.BaseStringTermsTestCase;
            assertThat(key(bucket), equalTo(i + "|foo_val" + i));  
                    asList(  
                        new MultiTermsValuesSourceConfig.Builder().setFieldName("i").build(),
                multiTerms("mterms").terms(
        Terms terms = response.getAggregations().get("mterms");
    }
            )
}  
        }
package org.opensearch.search.aggregations.bucket;
 * SPDX-License-Identifier: Apache-2.0
                                    StringTermsIT.CustomScriptPlugin.NAME,
                    asList(
