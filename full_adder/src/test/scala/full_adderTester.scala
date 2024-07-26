
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class full_adderTester extends AnyFlatSpec with ChiselScalatestTester {

  "full_adder" should "pass" in {
    test(new full_adder){ dut =>
      for (a <- 0 to 5 ) {
        for (b <- 0 to 5) {
          for (carry_in <- 0 to 5) {
            dut.io.a.poke(a.U)
            dut.io.b.poke(b.U)
            dut.io.carry_in.poke(carry_in.U)
            dut.clock.step()
            println ("Case 1: a:"+ dut.io.a.peekInt() + " b:" + dut.io.b.peekInt()+ " carry_in:"+ dut.io.carry_in.peekInt())
            println (" Sum is: " + dut.io.sum. peekInt ())
            println (" Carry_out is: " + dut.io.carry_out. peekInt ())
          }    
        }
      }
    }
  }
}
