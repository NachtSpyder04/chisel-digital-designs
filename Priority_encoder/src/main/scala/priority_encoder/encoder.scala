
package priority_encoder

import chisel3._
import chisel3.util._

class encoder extends Module {
  val io = IO(new Bundle {
    val input = Input(UInt(8.W))
    val result = Output(UInt(3.W))
  })

  io.result := 0.U

  switch(io.input){
    is ("b0001".U) { io.result := "b00".U}
    is {"b0010".U} { io.result := "b01".U}
    is {"b0100".U} { io.result := "b10".U}
    is {"b1000".U} { io.result := "b11".U}
  }
}

