
package priority_encoder

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class priority_encoder_tester extends AnyFlatSpec with ChiselScalatestTester {

  "priority_encoder" should "pass" in {
    test(new top) { dut =>
      for (a <- 0 to 16) {
       dut.io.requests.poke(a.U)
        dut.clock.step()
      }
    }
  }
}
