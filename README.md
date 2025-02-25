# Chisel-Digital-Designs

Repository containing basic digital designs written using Chisel

## Getting Started
To use Chisel, you need to set up the environment and install the necessary dependencies. [Link to set up the environment and install necessary dependencies](https://www.chisel-lang.org/docs/installation)

## Running a Chisel Module

To run a Chisel module, navigate to the module directory and use `sbt run`. Running a Chisel Module will also generate the Verilog code for the same.

```sh
#for example, to run ALU, 
cd ALU/
sbt run
```

## Testing a Chisel Module

To run tests and verify the results, use:

```sh
sbt test
```

## Acknowledgement


I would like to express my gratitude to [Martin Schoeberl](https://github.com/schoeberl) for his invaluable book, **Digital Design with Chisel**, and for providing the Chisel template, both of which have been instrumental in shaping this project.