
import chisel3._
import chisel3.util._

class comparator extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val equal = Output(UInt(1.W))
    val greater = Output(UInt(1.W))
    val less = Output(UInt(1.W))
  })

  io.equal := (io.a === io.b)
  io.greater := (io.a > io.b)
  io.less := (io.a < io.b)

}

object comparatorMain extends App {
  println("Generating the comparator hardware")
  emitVerilog(new comparator(), Array("--target-dir", "generated"))
}