ls
#!/bin/bash
#SBATCH --job-name=PI_MPI
#SBATCH --output=PI_MPI_%j.log
#SBATCH --partition=compute
#SBATCH --mem=1gb
#SBATCH --nodes=10
#sbatch --time=00:03:00

. /etc/profile.d/modules.sh

module load openmpi/2.1.2

/opt/openmpi-2.1.2/bin/mpirun ./pi_mpi