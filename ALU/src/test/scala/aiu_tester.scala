
import chisel3._ 
import chiseltest._ 
import org.scalatest.flatspec.AnyFlatSpec

class alu_tester extends AnyFlatSpec with ChiselScalatestTester {
  "ALU" should "pass" in {
    test( new ALU ). withAnnotations (Seq( WriteVcdAnnotation)) { dut => 
     for (a <- 0 to 10){
      for (b <- 0 to 10 ) {
        for (sel <- 0 to 7){
          dut.io.a.poke(a.U)
          dut.io.b.poke(b.U)
          dut.io.sel.poke(sel.U)
          dut.clock.step()

      }
      }
     }
   }
  } 
}