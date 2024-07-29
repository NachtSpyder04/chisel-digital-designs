
package priority_encoder

import chisel3._
import chisel3.util._

class top extends Module {
  val data_width = 8
  val encoder_out_width = log2Ceil(data_width)
  val io = IO(new Bundle {
    val requests = Input(UInt(data_width.W))
    val result = Output(UInt(encoder_out_width.W))
  })
    val arbiter = Module(new arbiter())
    val encoder = Module(new encoder())

    arbiter.io.requests := io.requests
    encoder.io.input := arbiter.io.grant
    io.result := encoder.io.result
}

object priority_encoderMain extends App {
  println("Generating the priority encoder hardware")
  emitVerilog(new top(), Array("--target-dir", "generated"))
}