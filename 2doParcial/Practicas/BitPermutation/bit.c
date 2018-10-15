#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
	unsigned char data [] = {0x68, 0x69};										// Source array
	unsigned char permutation [] = {3,4,5,6,12,0,7,15,13,8,1,11,9,10,14,12};	//Permutation array
	unsigned char output [2] = {0};									// Result array
	unsigned char *p = permutation;
	

	for (int j = 0; j < sizeof(data); j++)
	{
		for (int i = 1; i <= 128; i = (i << 1))
		{
			char a = *p;
			char residuo = a & 7;
			char resultado = (a & 8) >> 3;

			if(data[resultado] & (1 << residuo) )
			{
				output[j] = output[j] | i;
			}
			p++;
		}
		

	}

	printf("%X\n", output[0]);
	printf("%X\n", output[1]);


	return 0;
}
