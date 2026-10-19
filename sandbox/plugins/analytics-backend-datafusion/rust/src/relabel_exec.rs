        let b: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
fn relabel_batch(batch: &RecordBatch, target_schema: &SchemaRef) -> Result<RecordBatch> {
        let a: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::UInt64, true)]));
    }
            )));
/// should have been emitted as a `Cast` at the LogicalPlan level.
    pub fn try_new(input: Arc<dyn ExecutionPlan>, target_schema: SchemaRef) -> Result<Arc<Self>> {
        assert!(validate_bit_compatible(&a, &b).is_ok());
            input,
    for (i, target_field) in target_schema.fields().iter().enumerate() {
            columns.push(Arc::clone(src));
        Ok(Arc::new(Self {
/// the substrait→physical-plan lowering introduces today (notably DataFusion's
    }
            properties,
            target_schema,
/// Wraps an `ExecutionPlan` and exposes a `target_schema` whose columns differ from the
    input: Arc<dyn ExecutionPlan>,
            src_schema.fields().len(),
//! Bridges a small gap between the LogicalPlan and physical-plan type systems on the
            return Err(DataFusionError::Internal(format!(
//! at the LogicalPlan level (matching what Calcite / isthmus declared on the wire),
}
/// signed/unsigned integer pairs at the same width, which are the divergences
//! producer side: DataFusion's substrait consumer types `ROW_NUMBER OVER` as `Int64`
//! Non-bit-compatible mismatches (e.g. cross-family) error at construction; those need
            | (DataType::UInt64, DataType::Int64)
        let src: ArrayRef = Arc::new(Int64Array::from(vec![10i64, 20]));
            new_eq,
        validate_bit_compatible(&input.schema(), &target_schema)?;
    Ok(RelabelExec::try_new(physical_plan, target_schema)? as Arc<dyn ExecutionPlan>)
        }))
    fn with_new_children(
            .build()
use arrow::array::{make_array, ArrayRef};
    target_schema: SchemaRef,
pub struct RelabelExec {
        .unwrap();
                dst_f.data_type()
use futures::stream::TryStreamExt;
impl DisplayAs for RelabelExec {
                i,
            | (DataType::UInt16, DataType::Int16)
        let b: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Float64, true)]));
        vec![&self.input]
        return Err(DataFusionError::Internal(format!(
            .field("target_schema", &self.target_schema)
    }
//! column — no buffer alloc, no per-row work.
    {
    fn validate_accepts_uint64_to_int64() {
impl RelabelExec {
    ) -> Result<Arc<dyn ExecutionPlan>> {
        assert_eq!(as_i64.values(), &[1i64, 2, 3]);
/// Bit-compatible pairs share an identical Arrow buffer layout; retagging the
    )
        f.debug_struct("RelabelExec")
        let same_schema: SchemaRef =
pub fn wrap_if_relabel_needed(
        let data = src
use datafusion::physical_plan::{
        // Bit pattern preserved: u64 value 1 reinterprets as i64 value 1.
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut fmt::Formatter) -> fmt::Result {
}
//! physical operator chooses an unsigned representation for a Substrait `i64` declaration.
        .enumerate()
                 (use a LogicalPlan-level Cast for this conversion)",
    }
//! but the physical `WindowAggExec` for `row_number()` emits `UInt64` regardless. The
    if src_schema.fields().len() != target_schema.fields().len() {
    }
        let new_eq = EquivalenceProperties::new(Arc::clone(&target_schema));
        ));
 * compatible open source license.
    fn properties(&self) -> &Arc<PlanProperties> {
                "RelabelExec column {} ('{}') has non-bit-compatible types: {:?} → {:?} \
            continue;
use arrow::datatypes::{DataType, SchemaRef};
    if physical_plan.schema().as_ref() == target_schema.as_ref() {
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
                DataFusionError::Internal(format!(
/// `DataType` produces a valid array with the same bytes. Currently covers the
        .map_err(|e| DataFusionError::Execution(format!("RelabelExec assemble batch: {}", e)))
use datafusion::execution::TaskContext;
use arrow::record_batch::RecordBatch;
}
    }
        assert!(Arc::ptr_eq(out.column(0), &src));
        let target_schema = Arc::clone(&self.target_schema);
    }
        )));
        write!(f, "RelabelExec: schema={:?}", self.target_schema)
    properties: Arc<PlanProperties>,
            .into_builder()
            .data_type(target_field.data_type().clone())
    }
        let batch = RecordBatch::try_new(
        let src = batch.column(i);
//! buffers are shared with the source array; only the type tag flips. Per-batch cost is
        }
    let mut columns: Vec<ArrayRef> = Vec::with_capacity(batch.num_columns());
/// physical-plan-build site). Errors when a mismatch isn't bit-compatible — those
            | (DataType::Int16, DataType::UInt16)
                children.len()
    }
use datafusion::physical_expr::EquivalenceProperties;
}
    Ok(())
 * SPDX-License-Identifier: Apache-2.0
    }
        let out = relabel_batch(&batch, &target_schema).unwrap();
    use arrow::datatypes::{Field, Schema};
fn is_bit_compatible(a: &DataType, b: &DataType) -> bool {
        }
                ))
        assert!(validate_bit_compatible(&a, &b).is_err());
            | (DataType::Int64, DataType::UInt64)
    physical_plan: Arc<dyn ExecutionPlan>,
        columns.push(make_array(data));
    matches!(
) -> Result<Arc<dyn ExecutionPlan>> {
//!
        )))
impl ExecutionPlan for RelabelExec {
 */
//!
use datafusion::common::{DataFusionError, Result};
        Ok(Self::try_new(new_input, target_schema)? as Arc<dyn ExecutionPlan>)
    RecordBatch::try_new(Arc::clone(target_schema), columns)
fn validate_bit_compatible(src_schema: &SchemaRef, target_schema: &SchemaRef) -> Result<()> {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        "RelabelExec"
        }
    }
        partition: usize,
        let target_schema = Arc::clone(&self.target_schema);
        let as_i64 = out.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
//!
                src_f.name(),
 * this file be licensed under the Apache-2.0 license or a
    }
        .iter()
                "RelabelExec expects exactly one child, got {}",
        assert_eq!(out.column(0).data_type(), &DataType::Int64);
    }
        let input_stream = self.input.execute(partition, context)?;
        let a: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
    #[test]
        mut children: Vec<Arc<dyn ExecutionPlan>>,
}
            )));
//! one `Arc` clone + one `ArrayData::into_builder().data_type(...).build()` per mismatched
                    i,
}
//! Wrapping the physical plan with `RelabelExec` retags each batch's mismatched columns
            && !is_bit_compatible(src_f.data_type(), dst_f.data_type())
            | (DataType::UInt8, DataType::Int8)
        &self,
        let out = relabel_batch(&batch, &same_schema).unwrap();
            Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, true)]));
        let target_schema_for_stream = Arc::clone(&target_schema);
            target_schema.fields().len()
    fn schema(&self) -> SchemaRef {
}
        if src_f.data_type() != dst_f.data_type()
            input_props.output_partitioning().clone(),
/// (returns the original plan unchanged so this is safe to call from any
//! to match the LogicalPlan's declared types. The rebuild is zero-copy: `ArrayData`
                src_f.data_type(),
            .finish()
    }
use std::fmt;
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
#[cfg(test)]
//! a proper `Cast` at the LogicalPlan level rather than a relabel.
        {
    use super::*;
/// `ArrayData` rebuild.
        // Zero-copy: rebuild ArrayData with the new DataType. Buffers are shared with
 * The OpenSearch Contributors require contributions made to
        let src: ArrayRef = Arc::new(UInt64Array::from(vec![1u64, 2, 3]));
        (DataType::Int8, DataType::UInt8)
    DisplayAs, DisplayFormatType, ExecutionPlan, PlanProperties, SendableRecordBatchStream,
        (a, b),
    }
        let batch = RecordBatch::try_new(Arc::clone(&same_schema), vec![Arc::clone(&src)]).unwrap();
    #[test]
        // the source array; only the type tag flips.
            input_props.boundedness,
    use arrow::array::{Int64Array, UInt64Array};
        .fields()
            Arc::new(Schema::new(vec![Field::new("y", DataType::Int64, false)]));
        let properties = Arc::new(PlanProperties::new(
}
    }
};
        .zip(target_schema.fields().iter())
//! same divergence affects any `Int8↔UInt8` … `Int64↔UInt64` pair where DataFusion's
            let target = Arc::clone(&target_schema);
    #[test]
        let target_schema: SchemaRef =
    #[test]
}
            mapped,
            "RelabelExec field count mismatch: input has {}, target has {}",
            })?;
        // Same Arc — the no-op branch in relabel_batch is the test target.
    fn relabel_skips_no_op_when_schemas_match() {
        let mapped = input_stream.and_then(move |batch| {
impl fmt::Debug for RelabelExec {
/// `target_schema` only on bit-compatible pairs. No-op when schemas already match
/*
        context: Arc<TaskContext>,
        let input_props = input.properties();
    fn relabel_uint64_to_int64_shares_buffer() {
        self: Arc<Self>,
            input_props.emission_type,
    fn validate_rejects_cross_family() {
/// input's only by bit-compatible Int↔UInt sign flips. Per-batch retags via zero-copy
        &self.properties
mod tests {
/// `row_number()` returning UInt64 against a Substrait `i64` declaration).
            .to_data()
        if src.data_type() == target_field.data_type() {
    for (i, (src_f, dst_f)) in src_schema
        return Ok(physical_plan);
}
        Arc::clone(&self.target_schema)
                    "RelabelExec failed to retag column {} ('{}'): {}",
                    e
            target_schema_for_stream,
    target_schema: SchemaRef,
use std::sync::Arc;
 *
    }
        Ok(Box::pin(RecordBatchStreamAdapter::new(
            | (DataType::UInt32, DataType::Int32)
        )
    fn name(&self) -> &str {
        if children.len() != 1 {
            | (DataType::Int32, DataType::UInt32)
            .map_err(|e| {
            Arc::new(Schema::new(vec![Field::new("x", DataType::UInt64, true)])),
            return Err(DataFusionError::Internal(format!(
            vec![src],
    fn execute(
/// Wraps `physical_plan` with `RelabelExec` when its output schema diverges from
        let new_input = children.remove(0);
//! Zero-copy schema-relabel ExecutionPlan.
    ) -> Result<SendableRecordBatchStream> {
            async move { relabel_batch(&batch, &target) }
        });
                    target_field.name(),
