    ctx: &RowIdContext,
    schema: &SchemaRef,
                ctx.base,
            _ => batch_schema
        rg_pos
use datafusion::arrow::datatypes::SchemaRef;
            .map(|i| position_to_global_id(batch_start_delivered + i, pm, base))
                current_mask,
/// Compute global row IDs for surviving rows and inject into the output batch.
) -> Vec<u64> {
        "position_to_global_id: underflow base={} rg_pos={}",
/// * `row_id_idx` - Column index in the output schema for `__row_id__`
/// * `ctx` - Pre-captured position info from before filtering
                    mi < candidate_mask.len()
    pub base: u64,
 * compatible open source license.
use super::row_selection::PositionMap;
                &ctx.eval_mask,
pub fn inject_row_ids(
///
    batch_len: usize,
    eval_mask: &Option<BooleanArray>,
        }
    let row_id_array: Arc<dyn Array> = match num_surviving {
    };
                ids.into_iter().map(|id| id as i64),
    batch_start_delivered: usize,
) -> Result<RecordBatch> {
    batch_len: usize,
        _ => {
//!
                }),
//! when `row_id_output_index` is set.
                .unwrap_or_else(|_| {
        .iter()
                .map(|i| position_to_global_id(batch_start_delivered + i, pm, base))
                .collect(),
                        && candidate_mask.value(mi)
        Some(mask) => (0..batch_len)
}
/*
            .filter(|&i| mask.is_valid(i) && mask.value(i))
    match eval_mask {
    let id = base + rg_pos as u64;
//! Computes shard-global row IDs from position information and injects them
    current_mask: Option<&BooleanArray>,
 *
    let rg_pos = match pm {
                ctx.position_map.as_ref(),
    RecordBatch::try_new_with_options(
                    let mi = mask_offset_before + i;
        None => match current_mask {
        .enumerate()
        columns,
                .map(|col_idx| Arc::clone(output.column(col_idx)))
    current_mask: Option<&BooleanArray>,
use datafusion::arrow::array::{Array, BooleanArray, Int64Array};
/// Captured BEFORE the filter mask is consumed (since mask consumption advances offsets).
            );
        id >= base,
/// * `batch_len` - Original (pre-filter) batch length
    pm: Option<&PositionMap>,
    .map_err(|e| datafusion::common::DataFusionError::ArrowError(Box::new(e), None))
    pub position_map: Option<PositionMap>,
            let ids = compute_row_ids(
use datafusion::common::Result;
/// Convert a delivered-row index to a shard-global row ID.
        })
    }
/// * `output` - The filtered batch (without `__row_id__` column)
    let columns: Vec<Arc<dyn Array>> = schema
 * SPDX-License-Identifier: Apache-2.0
    let num_surviving = output.num_rows();
            ))
        Some(p) => p.rg_position(delivered_idx).unwrap_or(delivered_idx),
 * The OpenSearch Contributors require contributions made to
/// # Arguments
        .collect();
    debug_assert!(
//! into the output batch at the correct column index. Used by `IndexedStream`
#[inline]
                ctx.batch_offset,
            .with_row_count(Some(num_surviving)),
                .collect(),
                })
                    datafusion::arrow::array::new_null_array(field.data_type(), num_surviving)
/// Pre-captured state needed for row ID computation.
        &datafusion::arrow::record_batch::RecordBatchOptions::new()
            Some(candidate_mask) => (0..batch_len)
            idx if idx == row_id_idx => Arc::clone(&row_id_array),
 */
    mask_offset_before: usize,
/// Compute global row IDs from position info.
                .map(|i| position_to_global_id(batch_start_delivered + i, pm, base))
/// * `current_mask` - Candidate-stage mask (used when eval_mask is None)
            Arc::new(Int64Array::from_iter_values(
use datafusion::arrow::record_batch::RecordBatch;
        base,
    };
    let batch_schema = output.schema();
    pub batch_offset: usize,
            .collect(),
                .index_of(field.name())
}
    id
        schema.clone(),
                        && candidate_mask.is_valid(mi)
    );
use std::sync::Arc;
    )
fn compute_row_ids(
                batch_len,
        0 => Arc::new(Int64Array::from(Vec::<i64>::new())),
}
        None => delivered_idx,
//! Row ID computation for the fetch phase (QTF).
/// * `mask_offset_before` - mask_offset value before this batch was processed
    base: u64,
/// * `schema` - Output schema (includes `__row_id__` at `row_id_idx`)
            None => (0..batch_len)
    pub eval_mask: Option<BooleanArray>,
fn position_to_global_id(delivered_idx: usize, pm: Option<&PositionMap>, base: u64) -> u64 {
 * this file be licensed under the Apache-2.0 license or a
        },
    row_id_idx: usize,
        .map(|(i, field)| match i {
                mask_offset_before,
        .fields()
    output: &RecordBatch,
    mask_offset_before: usize,
                .filter(|&i| {
}
pub struct RowIdContext {
