
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class arbiter_tester extends AnyFlatSpec with ChiselScalatestTester {

  "Arbiter" should "pass" in {
    test(new arbiter) { dut =>
      for (a <- 0 to 10) {
        dut.io.requests.poke(a.U)
        dut.clock.step()
      }
    }
  }
}
