  
import chisel3._
import chisel3.util._

class clk_divider extends Module {
  val io = IO(new Bundle {
    val clk_out = Output(UInt(1.W))
  })

  val count = RegInit(0.U(8.W))
   val clk_out = RegInit(0.U(1.W))
   count := count + 1.U
  when (count === 3.U) {
    clk_out := !clk_out
    count := 0.U
  }
  
  
  io.clk_out := clk_out
}

object clk_dividerMain extends App {
  println("Generating the clock divider hardware")
  emitVerilog(new clk_divider(), Array("--target-dir", "generated"))
}