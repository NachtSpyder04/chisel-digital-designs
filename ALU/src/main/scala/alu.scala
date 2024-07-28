
import chisel3._
import chisel3.util._

class ALU extends Module {
  val io = IO(new Bundle{
    val a = Input(UInt(16.W))
    val b = Input(UInt(16.W))
    val sel = Input(UInt(16.W))
    val out = Output(UInt(32.W))
  })

  val operation = Wire(Vec(8,UInt(32.W)))
  operation(0) := io.a + io.b 
  operation(1) := io.a - io.b 
  operation(2) := io.a * io.b 
  operation(3) := io.a / io.b 
  operation(4) := io.a % io.b 
  operation(5) := io.a & io.b 
  operation(6) := io.a | io.b 
  operation(7) := io.a ^ io.b 
  
  io.out := operation(io.sel)
 

}

object ALUMain extends App {
  println("Generating Verilog")
  emitVerilog(new ALU(), Array("--target-dir", "generated"))
}