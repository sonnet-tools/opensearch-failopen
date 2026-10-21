//! column — no buffer alloc, no per-row work.
    {
        let target_schema = Arc::clone(&self.target_schema);
        }
        .unwrap();
        let b: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
            mapped,
        write!(f, "RelabelExec: schema={:?}", self.target_schema)
    fn execute(
    if physical_plan.schema().as_ref() == target_schema.as_ref() {
        // Same Arc — the no-op branch in relabel_batch is the test target.
        });
    properties: Arc<PlanProperties>,
use datafusion::physical_expr::EquivalenceProperties;
    Ok(())
            .data_type(target_field.data_type().clone())
    matches!(
            .field("target_schema", &self.target_schema)
                ))
 * compatible open source license.
        }
    fn relabel_skips_no_op_when_schemas_match() {
            | (DataType::Int64, DataType::UInt64)
//!
        let input_stream = self.input.execute(partition, context)?;
        let properties = Arc::new(PlanProperties::new(
        Ok(Box::pin(RecordBatchStreamAdapter::new(
//! at the LogicalPlan level (matching what Calcite / isthmus declared on the wire),
    fn validate_accepts_uint64_to_int64() {
            .finish()
            input_props.output_partitioning().clone(),
    }
use arrow::array::{make_array, ArrayRef};
mod tests {
        vec![&self.input]
        let b: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Float64, true)]));
    let mut columns: Vec<ArrayRef> = Vec::with_capacity(batch.num_columns());
    )
impl DisplayAs for RelabelExec {
    physical_plan: Arc<dyn ExecutionPlan>,
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
            continue;
 */
fn validate_bit_compatible(src_schema: &SchemaRef, target_schema: &SchemaRef) -> Result<()> {
 * this file be licensed under the Apache-2.0 license or a
    }
        let mapped = input_stream.and_then(move |batch| {
/*
        let src = batch.column(i);
                "RelabelExec expects exactly one child, got {}",
    }
//! one `Arc` clone + one `ArrayData::into_builder().data_type(...).build()` per mismatched
        let target_schema_for_stream = Arc::clone(&target_schema);
    use arrow::array::{Int64Array, UInt64Array};
impl fmt::Debug for RelabelExec {
        validate_bit_compatible(&input.schema(), &target_schema)?;
            })?;
        let src: ArrayRef = Arc::new(UInt64Array::from(vec![1u64, 2, 3]));
        assert_eq!(as_i64.values(), &[1i64, 2, 3]);
            input_props.boundedness,
            | (DataType::UInt16, DataType::Int16)
        }
    }
    }
impl RelabelExec {
impl ExecutionPlan for RelabelExec {
                i,
            | (DataType::UInt8, DataType::Int8)
};
) -> Result<Arc<dyn ExecutionPlan>> {
            target_schema.fields().len()
            .into_builder()
            | (DataType::Int16, DataType::UInt16)
        &self.properties
        let new_input = children.remove(0);
    for (i, target_field) in target_schema.fields().iter().enumerate() {
use futures::stream::TryStreamExt;
    }
        Arc::clone(&self.target_schema)
            let target = Arc::clone(&target_schema);
                    "RelabelExec failed to retag column {} ('{}'): {}",
/// `ArrayData` rebuild.
            Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, true)]));
/// (returns the original plan unchanged so this is safe to call from any
        // the source array; only the type tag flips.
/// Wraps `physical_plan` with `RelabelExec` when its output schema diverges from
            Arc::new(Schema::new(vec![Field::new("y", DataType::Int64, false)]));
                src_f.name(),
    for (i, (src_f, dst_f)) in src_schema
            | (DataType::UInt32, DataType::Int32)
}
            target_schema,
/// Wraps an `ExecutionPlan` and exposes a `target_schema` whose columns differ from the
        self: Arc<Self>,
//! Non-bit-compatible mismatches (e.g. cross-family) error at construction; those need
        partition: usize,
        &self,
            return Err(DataFusionError::Internal(format!(
        f.debug_struct("RelabelExec")
        .zip(target_schema.fields().iter())
                src_f.data_type(),
                children.len()
use std::fmt;
            async move { relabel_batch(&batch, &target) }
        context: Arc<TaskContext>,
        mut children: Vec<Arc<dyn ExecutionPlan>>,
/// the substrait→physical-plan lowering introduces today (notably DataFusion's
    use arrow::datatypes::{Field, Schema};
    use super::*;
                    target_field.name(),
        let as_i64 = out.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    #[test]
        let target_schema = Arc::clone(&self.target_schema);
/// physical-plan-build site). Errors when a mismatch isn't bit-compatible — those
            && !is_bit_compatible(src_f.data_type(), dst_f.data_type())
        let new_eq = EquivalenceProperties::new(Arc::clone(&target_schema));
        .map_err(|e| DataFusionError::Execution(format!("RelabelExec assemble batch: {}", e)))
            return Err(DataFusionError::Internal(format!(
                DataFusionError::Internal(format!(
        columns.push(make_array(data));
                dst_f.data_type()
fn relabel_batch(batch: &RecordBatch, target_schema: &SchemaRef) -> Result<RecordBatch> {
    }
use datafusion::physical_plan::{
}
#[cfg(test)]
        if children.len() != 1 {
    target_schema: SchemaRef,
                "RelabelExec column {} ('{}') has non-bit-compatible types: {:?} → {:?} \
        let data = src
//! to match the LogicalPlan's declared types. The rebuild is zero-copy: `ArrayData`
use std::sync::Arc;
//! Bridges a small gap between the LogicalPlan and physical-plan type systems on the
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
use datafusion::common::{DataFusionError, Result};
/// `DataType` produces a valid array with the same bytes. Currently covers the
        // Bit pattern preserved: u64 value 1 reinterprets as i64 value 1.
            properties,
}
        let out = relabel_batch(&batch, &same_schema).unwrap();
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
        return Err(DataFusionError::Internal(format!(
}
/// input's only by bit-compatible Int↔UInt sign flips. Per-batch retags via zero-copy
        assert!(validate_bit_compatible(&a, &b).is_ok());
        "RelabelExec"
use arrow::record_batch::RecordBatch;
                 (use a LogicalPlan-level Cast for this conversion)",
    }
    DisplayAs, DisplayFormatType, ExecutionPlan, PlanProperties, SendableRecordBatchStream,
    Ok(RelabelExec::try_new(physical_plan, target_schema)? as Arc<dyn ExecutionPlan>)
//! producer side: DataFusion's substrait consumer types `ROW_NUMBER OVER` as `Int64`
            )));
//! a proper `Cast` at the LogicalPlan level rather than a relabel.
        let same_schema: SchemaRef =
    fn properties(&self) -> &Arc<PlanProperties> {
    }
            vec![src],
    }
            Arc::new(Schema::new(vec![Field::new("x", DataType::UInt64, true)])),
        let target_schema: SchemaRef =
            .to_data()
        (DataType::Int8, DataType::UInt8)
    fn schema(&self) -> SchemaRef {
        (a, b),
use arrow::datatypes::{DataType, SchemaRef};
        )))
        .enumerate()
        assert_eq!(out.column(0).data_type(), &DataType::Int64);
}
    input: Arc<dyn ExecutionPlan>,
                    e
            .build()
    fn with_new_children(
        let input_props = input.properties();
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut fmt::Formatter) -> fmt::Result {
 * The OpenSearch Contributors require contributions made to
        .iter()
            target_schema_for_stream,
    fn validate_rejects_cross_family() {
//!
//!
}
    }
    #[test]
    }
 * SPDX-License-Identifier: Apache-2.0
    ) -> Result<SendableRecordBatchStream> {
    if src_schema.fields().len() != target_schema.fields().len() {
}
    #[test]
}
            .map_err(|e| {
            src_schema.fields().len(),
        }))
//! buffers are shared with the source array; only the type tag flips. Per-batch cost is
    }
        if src.data_type() == target_field.data_type() {
    }
        )));
//! Zero-copy schema-relabel ExecutionPlan.
        let src: ArrayRef = Arc::new(Int64Array::from(vec![10i64, 20]));
/// should have been emitted as a `Cast` at the LogicalPlan level.
    }
//! but the physical `WindowAggExec` for `row_number()` emits `UInt64` regardless. The
            new_eq,
//! same divergence affects any `Int8↔UInt8` … `Int64↔UInt64` pair where DataFusion's
                    i,
//! physical operator chooses an unsigned representation for a Substrait `i64` declaration.
            columns.push(Arc::clone(src));
 *
pub struct RelabelExec {
            input,
}
    fn name(&self) -> &str {
    pub fn try_new(input: Arc<dyn ExecutionPlan>, target_schema: SchemaRef) -> Result<Arc<Self>> {
pub fn wrap_if_relabel_needed(
    }
/// Bit-compatible pairs share an identical Arrow buffer layout; retagging the
        assert!(Arc::ptr_eq(out.column(0), &src));
        if src_f.data_type() != dst_f.data_type()
        let a: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::UInt64, true)]));
    target_schema: SchemaRef,
            | (DataType::UInt64, DataType::Int64)
        return Ok(physical_plan);
        {
    #[test]
        ));
        )
/// `row_number()` returning UInt64 against a Substrait `i64` declaration).
fn is_bit_compatible(a: &DataType, b: &DataType) -> bool {
        // Zero-copy: rebuild ArrayData with the new DataType. Buffers are shared with
    fn relabel_uint64_to_int64_shares_buffer() {
        let out = relabel_batch(&batch, &target_schema).unwrap();
}
        .fields()
/// signed/unsigned integer pairs at the same width, which are the divergences
use datafusion::execution::TaskContext;
        let a: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
        assert!(validate_bit_compatible(&a, &b).is_err());
            "RelabelExec field count mismatch: input has {}, target has {}",
//! Wrapping the physical plan with `RelabelExec` retags each batch's mismatched columns
    RecordBatch::try_new(Arc::clone(target_schema), columns)
        Ok(Self::try_new(new_input, target_schema)? as Arc<dyn ExecutionPlan>)
    }
/// `target_schema` only on bit-compatible pairs. No-op when schemas already match
        let batch = RecordBatch::try_new(
        Ok(Arc::new(Self {
            | (DataType::Int32, DataType::UInt32)
            input_props.emission_type,
            )));
    ) -> Result<Arc<dyn ExecutionPlan>> {
        let batch = RecordBatch::try_new(Arc::clone(&same_schema), vec![Arc::clone(&src)]).unwrap();
