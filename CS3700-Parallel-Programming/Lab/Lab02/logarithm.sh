#!/bin/bash
#SBATCH --job-name=LOGARITHM_CPP
#SBATCH --output=LOGARITHM_CPP\\\_%j.log 
#SBATCH --partition=compute 
#SBATCH --mem=1gb 
#SBATCH --nodes=5 
#SBATCH --time=00:02:00 

. /etc/profile.d/modules.sh
module load openmpi/2.1.2
/opt/openmpi-2.1.2/bin/mpirun ./logarithm
