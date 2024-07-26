
import chisel3._
import chisel3.util._


class half_adder extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(16.W))
    val b = Input(UInt(16.W))
    val sum = Output(UInt(16.W))
    val carry = Output(UInt(16.W))
  })

  io.carry := io.a & io.b
  io.sum := io.a ^ io.b 
}

object half_adderMain extends App {
  println("Generating Verilog")
  emitVerilog(new half_adder(), Array("--target-dir", "generated"))
}