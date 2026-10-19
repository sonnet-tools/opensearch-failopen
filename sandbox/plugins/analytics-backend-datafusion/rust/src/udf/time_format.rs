impl ScalarUDFImpl for TimeFormatUdf {
            }
            | DataType::Date64
        let ts = match &arg_types[0] {
            other => {
 *
        &self.signature
}
 * SPDX-License-Identifier: Apache-2.0
    }
//! `time_format(time_or_datetime, format)` — time-mode sibling of date_format.
        };
}
//! MySQL time-format rules: date-only numeric tokens render with literal zeros
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
 * this file be licensed under the Apache-2.0 license or a
    fn signature(&self) -> &Signature {
use datafusion::execution::context::SessionContext;
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
 * The OpenSearch Contributors require contributions made to
    }
use super::os_strftime::FormatMode;
/*
udf_identity!(TimeFormatUdf, "time_format");
                )
pub fn register_all(ctx: &SessionContext) {
    ctx.register_udf(ScalarUDF::from(TimeFormatUdf::new()));
            other => return plan_err!("time_format: arg 1 expected string, got {other:?}"),
            | DataType::Date32
use datafusion::logical_expr::{
//! (%d→"00", %Y→"0000"); date-only name tokens (%W, %a, %M, %D, %j, %w, %U/%u,
            }
        if arg_types.len() != 2 {
use super::date_format::format_dispatch;
                DataType::Timestamp(TimeUnit::Microsecond, None)
            return plan_err!("time_format expects 2 arguments, got {}", arg_types.len());
        }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        }
                    "time_format: arg 0 expected time/timestamp/date/string, got {other:?}"
pub struct TimeFormatUdf {
        "time_format"
        let fmt = match &arg_types[1] {
use datafusion::arrow::datatypes::{DataType, TimeUnit};
}
use datafusion::common::{plan_err, Result};
            return plan_err!("time_format expects 2 arguments, got {}", arg_types.len());
}
            | DataType::Time32(_)
        if arg_types.len() != 2 {
#[derive(Debug)]
    pub fn new() -> Self {
    }
};
        Self {
    }
                return plan_err!(
            DataType::Timestamp(_, _)
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        format_dispatch("time_format", FormatMode::Time, args)
            | DataType::Time64(_) => DataType::Timestamp(TimeUnit::Microsecond, None),
    }
    fn name(&self) -> &str {
        }
 */
    signature: Signature,
use super::udf_identity;
            signature: Signature::user_defined(Volatility::Immutable),
        Ok(DataType::Utf8)
//! %V/%v, %X/%x, %b) cause the whole render to collapse to NULL.
impl TimeFormatUdf {
        };
 * compatible open source license.
        Ok(vec![ts, fmt])
