
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class comp_tester extends AnyFlatSpec with ChiselScalatestTester {

  "Comparator" should "pass" in {
    test(new comparator) { dut =>
      for (a <- 0 to 10) {
        for (b <- 0 to 10) {
          dut.io.a.poke(a.U)
          dut.io.b.poke(b.U)
          dut.clock.step(1)
        }
      }
    }
  }
}
