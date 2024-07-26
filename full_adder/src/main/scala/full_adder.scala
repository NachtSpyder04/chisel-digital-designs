
import chisel3._
import chisel3.util._

class full_adder extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(16.W))
        val b = Input(UInt(16.W))
        val carry_in = Input(UInt(16.W))
        val carry_out = Output(UInt(16.W))
        val sum = Output(UInt(16.W))
    })

    val half_adder_1 = Module(new half_adder())
    val half_adder_2 = Module(new half_adder())

    half_adder_1.io.a := io.a
    half_adder_1.io.b := io.b 

    half_adder_2.io.a := half_adder_1.io.sum
    half_adder_2.io.b := io.carry_in

    io.sum := half_adder_2.io.sum
    io.carry_out := half_adder_2.io.carry | half_adder_1.io.carry

}