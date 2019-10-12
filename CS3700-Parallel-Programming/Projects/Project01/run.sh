#!/bin/bash
chmod +x then_run.sh
srun -p compute --pty /usr/bin/bash
sbatch pi_mpi.sh