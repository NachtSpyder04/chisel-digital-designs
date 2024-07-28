
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class decoder_tester extends AnyFlatSpec with ChiselScalatestTester {

  "decoder" should "pass" in {
    test(new decoder) { dut =>
          for (sel <- 0 to 3){
            dut.io.input.poke(sel.U)
            dut.clock.step()
          }
      
    }
  }
}
