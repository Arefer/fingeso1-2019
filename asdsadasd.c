#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Core/io.h"
#include "Core/register.h"
#include "Core/instr_mem.h"
#include "Core/io.h"
#include "Core/cpu.h"
#include "Auxiliar/binary_ops.h"


int main() {
    printf("#############################################################################################\n");
    printf("#############################################################################################\n");
    printf("######  **** ** *** *** ** ** **     ****  ***   ***** *****    *** *** ** ****  ****  ######\n");
    printf("######  **   ** *** *** ** ** **    **  ** ****  ** ** ** **    *** *** ** ** ** **    ######\n");
    printf("######  **** ** ** * ** ** ** **    ****** ** ** ** ** ****     ** * ** ** ****  ****  ######\n");
    printf("######    ** ** **   ** ** ** ***** **  ** ****  ** ** ** **    **   ** ** **      **  ######\n");
    printf("######  **** ** **   ** ***** ***** **  ** ***   ***** **  **   **   ** ** **    ****  ######\n");
    printf("#############################################################################################\n");
    printf("#############################################################################################\n");

    CPU* cpu = init_cpu();
    printf("\n\nLEYENDO ARCHIVO ...\n\n");
    read_source_code("1.in", cpu);
    print_instr_mem(cpu);
    printf("\n%d INSTRUCCIONES LEIDAS\n\n", cpu->instr_memory->length);

    printf("+-------+-----------------------------------------------------------------------------------------------------------------------------------------------------+\n");
    printf("|       |                                                     ETAPA DE PIPELINE                                                                               |\n");
    printf("+-------+------------------------+------------------------+------------------------+------------------------+------------------------+------------------------+\n");
    printf("|  CC   |           IF           |           ID           |          EX1           |            EX2         |          MEM           |            WB          |\n");
    printf("+-------+------------------------+------------------------+------------------------+------------------------+------------------------+------------------------+\n");

    run(cpu);
    free_cpu(cpu);
    return 0;
}