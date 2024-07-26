/*
 * Dummy tester to start a Chisel project.
 *
 * Author: Martin Schoeberl (martin@jopdesign.com)
 * 
 */



import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class half_adderTester extends AnyFlatSpec with ChiselScalatestTester {

  "half_adder" should "pass" in {
    test(new half_adder). withAnnotations (Seq( WriteVcdAnnotation )) { dut =>
      for (a <- 0 to 10 ) {
        for (b <- 0 to 10) {
          
          dut.io.a.poke(a.U)
          dut.io.b.poke(b.U)
          dut.clock.step()
          println ("Case 1: a:"+ dut.io.a.peekInt() + " b:" + dut.io.b.peekInt())
          println (" Sum is: " + dut.io.sum. peekInt ())
          println (" Carry is: " + dut.io.carry. peekInt ())

        }
      }
    }
  }
}
