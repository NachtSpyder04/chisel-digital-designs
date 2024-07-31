
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class clk_dividertester extends AnyFlatSpec with ChiselScalatestTester {

  "clk_divider" should "pass" in {
    test(new clk_divider) { dut =>
      for (a <- 0 to 100) {
        
          dut.clock.step(1)
          
      
      }
    }
  }
}
