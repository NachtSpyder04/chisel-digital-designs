
package priority_encoder

import chisel3._
import chisel3.util._

class arbiter extends Module{
  val data_width = 8
  val io = IO(new Bundle {
    val requests = Input(UInt(data_width.W))
    val grant = Output(UInt(data_width.W))
    val not_granted = Output(UInt(data_width.W))
  })

   val grant = VecInit.fill(data_width)(false.B)
   val not_granted = VecInit.fill(data_width)(false.B)

   grant(0) := io.requests(0)
   not_granted(0) := !grant(0)

   for (i <- 1 until data_width) {
    grant(i) := io.requests(i) && not_granted(i-1)
    not_granted(i) := !grant(i) && not_granted(i-1) 
   }

   io.grant := grant.asUInt
   io.not_granted := not_granted.asUInt
}

