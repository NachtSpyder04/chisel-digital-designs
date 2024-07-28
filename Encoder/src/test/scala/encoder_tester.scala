
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class encoder_tester extends AnyFlatSpec with ChiselScalatestTester {

  "encoder" should "pass" in {
    test(new encoder) { dut =>
          for (input <- 0 to 8){
            dut.io.input.poke(input.U)
            dut.clock.step()
          }
      
    }
  }
}
