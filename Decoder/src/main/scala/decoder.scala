
import chisel3._
import chisel3.util._

class decoder extends Module {
  val io = IO(new Bundle {
    val input = Input(UInt(2.W))
    val result = Output(UInt(4.W))
  })

  io.result := 0.U

  switch(io.input){
    is (0.U) { io.result := 1.U}
    is {1.U} { io.result := 2.U}
    is {2.U} { io.result := 4.U}
    is {3.U} { io.result := 8.U}
  }
}

object decoderMain extends App {
  println("Generating the decoder hardware")
  emitVerilog(new decoder(), Array("--target-dir", "generated"))
}